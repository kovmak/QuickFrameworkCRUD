package com.krnelx.quickframeworkcrud.dao;

import com.krnelx.quickframeworkcrud.config.TestDataSourceConfig;
import com.krnelx.quickframeworkcrud.entity.Animal;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.UUID;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = AnimalDao.class)
@ContextConfiguration(classes = TestDataSourceConfig.class)
class AnimalDaoTest {

    @Autowired
    private AnimalDao animalDao;

    @Test
    void testCrudOperations() {
        // Create
        Animal animal = new Animal(UUID.randomUUID(), "Leo", "Lion", 5, 1);
        animalDao.persist(animal);

        // Additional test: Find All
        List<Animal> allAnimals = animalDao.findAll();
        assertEquals(1, allAnimals.size());

        // Read
        Animal retrievedAnimal = animalDao.findById(animal.getId());
        assertNotNull(retrievedAnimal);
        assertEquals("Leo", retrievedAnimal.getName());
        assertEquals("Lion", retrievedAnimal.getSpecies());
        assertEquals(5, retrievedAnimal.getAge());
        assertEquals(animal.getEnclosureId(), retrievedAnimal.getEnclosureId());

        // Update
        retrievedAnimal.setName("Simba");
        animalDao.update(retrievedAnimal);
        Animal updatedAnimal = animalDao.findById(retrievedAnimal.getId());
        assertEquals("Simba", updatedAnimal.getName());

        // Delete
        animalDao.delete(updatedAnimal.getId());
    }
}