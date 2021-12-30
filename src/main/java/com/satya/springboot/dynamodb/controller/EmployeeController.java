package com.satya.springboot.dynamodb.controller;

import com.satya.springboot.dynamodb.entity.Employee;
import com.satya.springboot.dynamodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * File: EmployeeController.java Copyright 2021 Jaish Technologies. All rights reserved.
 *
 * <p>This software is the confidential and proprietary information of Jaish Technologies. You
 * shall not disclose such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Jaish Technologies.
 *
 * <p>Created on: 24/12/21, Created by: satyaveer.yadav, Version: 1.0, Project Name: Sprint boot dynamodb app
 * Last updated by: satyaveer.yadav
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") String employeeId) {
        return employeeRepository.getEmployeeById(employeeId);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") String employeeId) {
        return employeeRepository.delete(employeeId);
    }

    @PutMapping("/employee/{id}")
    public String updateEmployee(@PathVariable("id") String employeeId, @RequestBody Employee employee) {
        return employeeRepository.update(employeeId, employee);
    }
}
