package com.krnelx.quickframeworkcrud.dao;

import com.krnelx.quickframeworkcrud.config.TestDataSourceConfig;
import com.krnelx.quickframeworkcrud.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = EmployeeDao.class)
@ContextConfiguration(classes = TestDataSourceConfig.class)
public class EmployeeDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testCrudOperations() {
        // Create
        Employee employee = new Employee(UUID.randomUUID(), "John Doe", "Software Engineer", 50000);
        employeeDao.persist(employee);

        // Additional test: Find All
        List<Employee> allEmployees = employeeDao.findAll();
        assertEquals(1, allEmployees.size());

        // Read
        Employee retrievedEmployee = employeeDao.findById(employee.getId());
        assertNotNull(retrievedEmployee);
        assertEquals("John Doe", retrievedEmployee.getName());
        assertEquals("Software Engineer", retrievedEmployee.getPosition());
        assertEquals(50000, retrievedEmployee.getSalary());

        // Update
        retrievedEmployee.setName("Jane Doe");
        employeeDao.update(retrievedEmployee);
        Employee updatedEmployee = employeeDao.findById(retrievedEmployee.getId());
        assertEquals("Jane Doe", updatedEmployee.getName());

        // Delete
        employeeDao.delete(updatedEmployee.getId());
    }
}