package com.diolabs.precureapi.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName ="Precure_Api_Table")
public class Precure {  

  @Id
  @DynamoDBHashKey (attributeName = "id")
  private String id;

  @DynamoDBAttribute (attributeName = "theme")
  private String theme;

  @DynamoDBAttribute (attributeName = "temporada")
  private String temporada;

  @DynamoDBAttribute (attributeName = "precure")
  private int precure;

}

