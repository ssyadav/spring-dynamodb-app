package com.satya.springboot.dynamodb.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * File: DynamoDbConfiguration.java Copyright 2021 THERMOFISHER SCIENTIFIC. All rights reserved.
 *
 * <p>This software is the confidential and proprietary information of THERMOFISHER SCIENTIFIC. You
 * shall not disclose such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with THERMOFISHER SCIENTIFIC.
 *
 * <p>Created on: 24/12/21, Created by: satyaveer.yadav, Version: 1.0, Project Name: Genexus/Ion
 * Reporter Last updated by: satyaveer.yadav
 */
@Configuration
public class DynamoDbConfiguration {

  @Bean
  public DynamoDBMapper dynamoDBMapper() {
    return new DynamoDBMapper(buildAmazonDynamoDb());
  }

  private AmazonDynamoDB buildAmazonDynamoDb() {
    return AmazonDynamoDBClientBuilder.standard()
        .withEndpointConfiguration(
            new AwsClientBuilder.EndpointConfiguration(
                "dynamodb.us-east-2.amazonaws.com", "us-east-2"))
        .withCredentials(
            new AWSStaticCredentialsProvider(
                new BasicAWSCredentials(
                    "AKIATTGVN65ZNDUP3XWX", "3Bs2CXblCyllGK0TJIng8jcsOYtVWSWAB2Y1jXcu")))
        .build();
  }
}
