# Luiza Labs 
## _1 -Criando o banco de dados_

- Banco de dados Utilizado é MySQL
- Para alterar usuário e senha do banco de dados, deve-se alterar o arquivo `application.properties` dentro de `agendamento/src/main/resources`
-- Alterar a variável _spring.datasource.username_ com o usuário do banco de dados.
-- Alterar a variável _spring.datasource.password_ com a senha do banco de dados.
- Executar o script abaixo para criação do banco:
```
    CREATE DATABASE luizalabs;
    USE luizalabs;
    CREATE TABLE `scheduling` (
        `ID` varchar(36) NOT NULL,
        `DATE_TO_SEND` datetime NOT NULL,
        `RECIPIENT` varchar(250) NOT NULL,
        `RECIPIENT_TYPE` varchar(250) NOT NULL,
        `STATUS` varchar(250) NOT NULL,
        `MESSAGE` varchar(1000) NOT NULL,
        PRIMARY KEY (`ID`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

## _2 -Inicialização_
- Dentro do diretório raiz `agendamento`, executar o comando maven `mvn spring-boot:run`
- Acessar http://localhost:8080/schedulings
## _3 - Utilizando a aplicação_
- Criação de agendamento:
1) Utilizar o endpoint  `@POST /schedulings` --- http://localhost:8080/schedulings
```
    {
        "dateToSend": "2021-08-21T18:25:43-05:00",
        "recipient": "teste@luizalabs.com.br",
        "recipientType": "EMAIL",
        "message": "Teste de agendamento"
    }
```
- Consulta de todos agendamentos:
-- Utilizar o endpoint  `@GET /schedulings` --- http://localhost:8080/schedulings
Irá retornar uma lista de agendamentos cadastrados.

- Consulta de um determinado agendamento:
--  Utilizar o endpoint  `@GET /schedulings/{id}` --- http://localhost:8080/schedulings/{id}
Irá retornar o agendamento solicitado.

- Remover de um determinado agendamento:
-- Utilizar o endpoint  `@DELETE /schedulings/{id}` --- http://localhost:8080/schedulings/{id}
Irá remover o agendamento solicitado.

## _4 - Build e testes_
- Para realizar build do projeto por inteiro, basta executar no diretório raiz `mvn clean install`, junto com este comando serão rodados os testes 

- Para executar apenas testes, pode ser executado também `mvn clean test`. E no caso de preferir executar apenas um teste específico, basta executar `mvn clean test -Dtest=SchedulingServiceTest` ou `mvn clean test -Dtest=SchedulingServiceTest#whenSaveSchedulingThenReturnOk`

