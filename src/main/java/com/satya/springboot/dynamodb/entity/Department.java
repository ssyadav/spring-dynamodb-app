package com.satya.springboot.dynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * File: Department.java Copyright 2021 THERMOFISHER SCIENTIFIC. All rights reserved.
 *
 * <p>This software is the confidential and proprietary information of THERMOFISHER SCIENTIFIC. You
 * shall not disclose such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with THERMOFISHER SCIENTIFIC.
 *
 * <p>Created on: 24/12/21, Created by: satyaveer.yadav, Version: 1.0, Project Name: Genexus/Ion
 * Reporter Last updated by: satyaveer.yadav
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBDocument
public class Department {
  @DynamoDBAttribute private String departmentName;
  @DynamoDBAttribute private String departmentCode;
}
