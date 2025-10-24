package com.vivo.lab;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import java.util.*;

public class TratamentoHandler implements RequestHandler<Map<String, Object>, String> {

    private final DynamoDbClient dynamoDb = DynamoDbClient.create();
    private static final String TABLE_NAME = "vivo_falhas_lab";

    @Override
    public String handleRequest(Map<String, Object> event, Context context) {
        context.getLogger().log("Iniciando varredura de falhas...");

        // Buscar todos os registros
        ScanResponse response = dynamoDb.scan(ScanRequest.builder().tableName(TABLE_NAME).build());

        int tratados = 0;

        for (Map<String, AttributeValue> item : response.items()) {
            String id = item.get("id").s();
            Map<String, AttributeValueUpdate> updates = new HashMap<>();
            updates.put("status", AttributeValueUpdate.builder()
                    .value(AttributeValue.builder().s("resolvido").build())
                    .action(AttributeAction.PUT)
                    .build());

            UpdateItemRequest update = UpdateItemRequest.builder()
                    .tableName(TABLE_NAME)
                    .key(Collections.singletonMap("id", AttributeValue.builder().s(id).build()))
                    .attributeUpdates(updates)
                    .build();

            dynamoDb.updateItem(update);
            context.getLogger().log("Falha tratada: " + id);
            tratados++;
        }

        return "Total de falhas tratadas: " + tratados;
    }
}

