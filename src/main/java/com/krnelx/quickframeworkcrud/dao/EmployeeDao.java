package com.krnelx.quickframeworkcrud.dao;

import com.krnelx.quickframeworkcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employee findById(UUID id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
            new Employee(
                UUID.fromString(rs.getString("id")),
                rs.getString("name"),
                rs.getString("position"),
                rs.getDouble("salary")
            )
        );
    }

    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
            new Employee(
                UUID.fromString(rs.getString("id")),
                rs.getString("name"),
                rs.getString("position"),
                rs.getDouble("salary")
            )
        );
    }

    public void persist(Employee employee) {
        String sql = "INSERT INTO employee (id, name, position, salary) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getPosition(), employee.getSalary());
    }

    public void update(Employee employee) {
        String sql = "UPDATE employee SET name = ?, position = ?, salary = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getPosition(), employee.getSalary(), employee.getId());
    }

    public void delete(UUID id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}