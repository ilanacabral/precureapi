# Precure API - Gerenciador de anime Precure 

## Requisitos

- Java 8
- Spring Initializr (https://start.spring.io/)
- Spring Boot
- Spring Webflux
- Spring Data
- Dynamodb
- Junit
- Sl4j
- Reactor
  
## DyanmoDB

- Executar o seguinte comando,na pasta em que o jar foi baixado: 
```
java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
```
- Para criar a tabela executar o arquivo com.diolabs.precureapi.config.PrecureTable
- Para popular a tabela executar o arquivo com.diolabs.precureapi.config.PrecureData
- Para listar as tabelas criadas:
```
aws dynamodb list-tables --endpoint-url http://localhost:8000
```

## Endpoints / Documentação Swagger
- http://localhost:8080/swagger-ui-precure-reactive-api.html
  



