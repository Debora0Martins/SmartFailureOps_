# 🚀 SmartFailureOps

**SmartFailureOps** é um projeto demonstrativo de **observabilidade inteligente na nuvem**, desenvolvido com foco em **automação, monitoramento e resposta a falhas** usando **AWS Lambda, CloudFormation, Terraform e Docker**.  
Criado por **Débora Martins**, o projeto tem como objetivo provar competências em **infraestrutura como código (IaC)**, **automação serverless** e **boas práticas de segurança na nuvem**.

---

## 🧠 Visão Geral

O sistema simula um ambiente de monitoramento de rede na AWS:

- A Lambda **VivoLambdaFalhas** registra falhas simuladas (por exemplo, interrupções ou eventos críticos).
- A Lambda **VivoLambdaTratamento** identifica e trata as falhas registradas.
- Toda a infraestrutura é criada automaticamente com **AWS CloudFormation** e **Terraform**, garantindo reprodutibilidade e escalabilidade.
- O deploy é totalmente automatizado, podendo ser containerizado com **Docker** para ambientes locais.

---

## ⚙️ Tecnologias Utilizadas

| Categoria | Ferramenta / Serviço |
|------------|----------------------|
| Infraestrutura | **AWS CloudFormation** |
| Automação IaC | **Terraform** |
| Serverless | **AWS Lambda (Java 17)** |
| Build | **Maven + Shade Plugin** |
| Containerização | **Docker** |
| Logs e Monitoramento | **AWS CloudWatch Logs** |
| Linguagem | **Java 17** |
| Controle de Versão | **Git + GitHub** |

---

## 🧩 Estrutura do Projeto



vivo-cloud-monitor-lab/
│
├── infra/ # Scripts Terraform e CloudFormation
├── lambda/ # Código da função Lambda de Falhas
├── lambda-tratamento/ # Código da função Lambda de Tratamento
├── stack.yaml # Template principal do CloudFormation
├── .gitignore # Regras de segurança e exclusão de dados sensíveis
└── README.md # Este documento


---

## 🛠️ Implantação com Terraform (exemplo)

```bash
# Inicializar o Terraform
terraform init

# Verificar o plano de criação
terraform plan

# Aplicar as mudanças
terraform apply -auto-approve

🐳 Executar Localmente com Docker (demo)
# Buildar imagem local
docker build -t smartfailureops .

# Rodar container
docker run -it smartfailureops

🔒 Segurança e Boas Práticas

Nenhum arquivo sensível é versionado (.env, tfstate, .terraform/, target/ etc.).

Acesso à AWS gerenciado via IAM Role temporária, nunca com credenciais fixas.

Infraestrutura replicável e segura, sem risco de vazamento.

👩‍💻 Autora

Débora  Martins
💡 Engenheira de Dados em formação | Desenvolvedora Java | Entusiasta em Cloud e DevOps
📧 ddeboraf.mar@gmail.com

🐙 GitHub: @Debora0Martins

🌟 Licença

“Automatizar é multiplicar tempo — e o tempo é o ativo mais valioso da engenharia.” ⏱️
— Débora Martins
