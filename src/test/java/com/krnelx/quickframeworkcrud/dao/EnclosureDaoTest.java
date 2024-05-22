package com.krnelx.quickframeworkcrud.dao;

import com.krnelx.quickframeworkcrud.config.TestDataSourceConfig;
import com.krnelx.quickframeworkcrud.entity.Enclosure;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = EnclosureDao.class)
@ContextConfiguration(classes = TestDataSourceConfig.class)
public class EnclosureDaoTest {

    @Autowired
    private EnclosureDao enclosureDao;

    @Test
    void testCrudOperations() {
        // Create
        Enclosure enclosure = new Enclosure(UUID.randomUUID(), "Lion Enclosure", "Large", 10);
        enclosureDao.persist(enclosure);

        // Additional test: Find All
        List<Enclosure> allEnclosures = enclosureDao.findAll();
        assertEquals(1, allEnclosures.size());

        // Read
        Enclosure retrievedEnclosure = enclosureDao.findById(enclosure.getId());
        assertNotNull(retrievedEnclosure);
        assertEquals("Lion Enclosure", retrievedEnclosure.getName());
        assertEquals("Large", retrievedEnclosure.getType());
        assertEquals(10, retrievedEnclosure.getCapacity());

        // Update
        retrievedEnclosure.setName("Tiger Enclosure");
        enclosureDao.update(retrievedEnclosure);
        Enclosure updatedEnclosure = enclosureDao.findById(retrievedEnclosure.getId());
        assertEquals("Tiger Enclosure", updatedEnclosure.getName());

        // Delete
        enclosureDao.delete(updatedEnclosure.getId());
    }
}