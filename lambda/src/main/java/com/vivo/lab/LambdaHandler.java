package com.vivo.lab;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LambdaHandler implements RequestHandler<Map<String, Object>, String> {

    private final DynamoDbClient dynamoDb = DynamoDbClient.create();
    private static final String TABLE_NAME = "vivo_falhas_lab";

    @Override
    public String handleRequest(Map<String, Object> event, Context context) {
        String id = UUID.randomUUID().toString();
        String descricao = (String) event.getOrDefault("descricao", "Falha simulada no sistema");
        String timestamp = Instant.now().toString();

        Map<String, AttributeValue> item = new HashMap<>();
        item.put("id", AttributeValue.builder().s(id).build());
        item.put("descricao", AttributeValue.builder().s(descricao).build());
        item.put("timestamp", AttributeValue.builder().s(timestamp).build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName(TABLE_NAME)
                .item(item)
                .build();

        dynamoDb.putItem(request);

        context.getLogger().log("Falha registrada com ID: " + id);
        return "Falha registrada com sucesso: " + id;
    }
}

