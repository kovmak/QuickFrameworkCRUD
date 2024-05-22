package com.krnelx.quickframeworkcrud.dao;

import com.krnelx.quickframeworkcrud.config.TestDataSourceConfig;
import com.krnelx.quickframeworkcrud.entity.Visitor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = VisitorDao.class)
@ContextConfiguration(classes = TestDataSourceConfig.class)
public class VisitorDaoTest {

    @Autowired
    private VisitorDao visitorDao;

    @Test
    void testCrudOperations() {
        // Create
        Visitor visitor = new Visitor(UUID.randomUUID(), "John Doe", 30);
        visitorDao.persist(visitor);

        // Additional test: Find All
        List<Visitor> allVisitors = visitorDao.findAll();
        assertEquals(1, allVisitors.size());

        // Read
        Visitor retrievedVisitor = visitorDao.findById(visitor.getId());
        assertNotNull(retrievedVisitor);
        assertEquals("John Doe", retrievedVisitor.getName());
        assertEquals(30, retrievedVisitor.getAge());

        // Update
        retrievedVisitor.setName("Jane Doe");
        visitorDao.update(retrievedVisitor);
        Visitor updatedVisitor = visitorDao.findById(retrievedVisitor.getId());
        assertEquals("Jane Doe", updatedVisitor.getName());

        // Delete
        visitorDao.delete(updatedVisitor.getId());
    }
}