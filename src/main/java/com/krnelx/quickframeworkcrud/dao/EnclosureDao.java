package com.krnelx.quickframeworkcrud.dao;

import com.krnelx.quickframeworkcrud.entity.Enclosure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class EnclosureDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Enclosure findById(UUID id) {
        String sql = "SELECT * FROM enclosure WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
            new Enclosure(
                UUID.fromString(rs.getString("id")),
                rs.getString("name"),
                rs.getString("type"),
                rs.getInt("capacity")
            )
        );
    }

    public List<Enclosure> findAll() {
        String sql = "SELECT * FROM enclosure";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
            new Enclosure(
                UUID.fromString(rs.getString("id")),
                rs.getString("name"),
                rs.getString("type"),
                rs.getInt("capacity")
            )
        );
    }

    public void persist(Enclosure enclosure) {
        String sql = "INSERT INTO enclosure (id, name, type, capacity) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, enclosure.getId(), enclosure.getName(), enclosure.getType(), enclosure.getCapacity());
    }

    public void update(Enclosure enclosure) {
        String sql = "UPDATE enclosure SET name = ?, type = ?, capacity = ? WHERE id = ?";
        jdbcTemplate.update(sql, enclosure.getName(), enclosure.getType(), enclosure.getCapacity(), enclosure.getId());
    }

    public void delete(UUID id) {
        String sql = "DELETE FROM enclosure WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}