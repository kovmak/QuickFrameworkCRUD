package com.krnelx.quickframeworkcrud.dao;

import com.krnelx.quickframeworkcrud.entity.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class VisitorDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Visitor findById(UUID id) {
        String sql = "SELECT * FROM visitor WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
            new Visitor(
                UUID.fromString(rs.getString("id")),
                rs.getString("name"),
                rs.getInt("age")
            )
        );
    }

    public List<Visitor> findAll() {
        String sql = "SELECT * FROM visitor";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
            new Visitor(
                UUID.fromString(rs.getString("id")),
                rs.getString("name"),
                rs.getInt("age")
            )
        );
    }

    public void persist(Visitor visitor) {
        String sql = "INSERT INTO visitor (id, name, age) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, visitor.getId(), visitor.getName(), visitor.getAge());
    }

    public void update(Visitor visitor) {
        String sql = "UPDATE visitor SET name = ?, age = ? WHERE id = ?";
        jdbcTemplate.update(sql, visitor.getName(), visitor.getAge(), visitor.getId());
    }

    public void delete(UUID id) {
        String sql = "DELETE FROM visitor WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}