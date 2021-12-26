package com.satya.springboot.dynamodb.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.satya.springboot.dynamodb.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * File: EmployeeRepository.java Copyright 2021 THERMOFISHER SCIENTIFIC. All rights reserved.
 *
 * <p>This software is the confidential and proprietary information of THERMOFISHER SCIENTIFIC. You
 * shall not disclose such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with THERMOFISHER SCIENTIFIC.
 *
 * <p>Created on: 24/12/21, Created by: satyaveer.yadav, Version: 1.0, Project Name: Genexus/Ion
 * Reporter Last updated by: satyaveer.yadav
 */
@Repository
public class EmployeeRepository {

  @Autowired private DynamoDBMapper dynamoDBMapper;

  public Employee save(Employee employee) {
    dynamoDBMapper.save(employee);
    return employee;
  }

  public Employee getEmployeeById(String employeeId) {
    return dynamoDBMapper.load(Employee.class, employeeId);
  }

  public String delete(String employeeId) {
    Employee emp = dynamoDBMapper.load(Employee.class, employeeId);
    dynamoDBMapper.delete(emp);
    return "Employee Deleted";
  }

  public String update(String employeeId, Employee employee) {
    dynamoDBMapper.save(
        employee,
        new DynamoDBSaveExpression()
            .withExpectedEntry(
                "employeeid", new ExpectedAttributeValue(new AttributeValue().withS(employeeId))));
    return employeeId;
  }
}
