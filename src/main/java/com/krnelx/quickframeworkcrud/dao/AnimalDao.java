package com.krnelx.quickframeworkcrud.dao;

import com.krnelx.quickframeworkcrud.entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class AnimalDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Animal findById(UUID id) {
        String sql = "SELECT * FROM Animal WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id.toString()}, (rs, rowNum) ->
            new Animal(
                UUID.fromString(rs.getString("id")),
                rs.getString("name"),
                rs.getString("species"),
                rs.getInt("age"),
                rs.getInt("enclosure_id")
            )
        );
    }

    public List<Animal> findAll() {
        String sql = "SELECT * FROM Animal";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
            new Animal(
                UUID.fromString(rs.getString("id")),
                rs.getString("name"),
                rs.getString("species"),
                rs.getInt("age"),
                rs.getInt("enclosure_id")
            )
        );
    }

    public void persist(Animal animal) {
        String sql = "INSERT INTO Animal (id, name, species, age, enclosure_id) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, animal.getId(), animal.getName(), animal.getSpecies(), animal.getAge(), animal.getEnclosureId());
    }

    public void update(Animal animal) {
        String sql = "UPDATE Animal SET name = ?, species = ?, age = ?, enclosure_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, animal.getName(), animal.getSpecies(), animal.getAge(), animal.getEnclosureId(), animal.getId());
    }

    public void delete(UUID id) {
        String sql = "DELETE FROM Animal WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}