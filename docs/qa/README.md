# DOCUMENTAÇÃO DE TESTE
Arquivo PDF serão adicionados aqui.
## 🏗️ Arquitetura – SmartFailureOps

Abaixo está o diagrama oficial da arquitetura do projeto:

![Arquitetura SmartFailureOps](Documentos/qa/diagrama_smartfailureops.png)

O fluxo resume:

- Registro de falhas via Lambda Falhas  
- Tratamento automático via Lambda Tratamento  
- Observabilidade via CloudWatch Logs  
- Provisionamento IaC com Terraform e CloudFormation  
- Deploy automatizado via GitHub Actions  
