package com.diolabs.precureapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

import static com.diolabs.precureapi.constant.PrecureConstant.REGION_DYNAMO;
import static com.diolabs.precureapi.constant.PrecureConstant.ENDPOINT_DYNAMO;

public class PrecureData {
  public static void main(String[] args) throws Exception {

    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
      .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
      .build();
    DynamoDB dynamoDB = new DynamoDB(client);

    Table table = dynamoDB.getTable("Precure_Api_Table");

    Item precure1 = new Item()
      .withPrimaryKey("id", "2")
      .withString("temporada", "Futari wa Pretty Cure (Max Heart)")
      .withString("theme", "Hearts")
      .withNumber("precure", 3);

    Item precure2 = new Item()
      .withPrimaryKey("id", "3")
      .withString("temporada", "Futari wa Pretty Cure Splash Star")
      .withString("theme", "Flowers, birds, wind and moon")
      .withNumber("precure", 4);

    Item precure3 = new Item()
      .withPrimaryKey("id", "4")
      .withString("temporada", "Yes! Pretty Cure 5 (GoGo!)")
      .withString("theme", "Roses")
      .withNumber("precure", 6);

      Item precure4 = new Item()
      .withPrimaryKey("id", "5")
      .withString("temporada", "Fresh Pretty Cure!")
      .withString("theme", "Four-leaf clover")
      .withNumber("precure", 4);

      Item precure5 = new Item()
      .withPrimaryKey("id", "6")
      .withString("temporada", "Suite Precure!")
      .withString("theme", "Music")
      .withNumber("precure", 4);

    PutItemOutcome outcome1 = table.putItem(precure1);
    PutItemOutcome outcome2 = table.putItem(precure2);
    PutItemOutcome outcome3 = table.putItem(precure3);
    PutItemOutcome outcome4 = table.putItem(precure4);
    PutItemOutcome outcome5 = table.putItem(precure5);

    System.out.println("Itens inseridos na tabela");
  }
}