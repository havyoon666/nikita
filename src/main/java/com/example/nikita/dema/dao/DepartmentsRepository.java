package com.example.nikita.dema.dao;

import com.example.nikita.dema.models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DepartmentsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // RowMapper to map SQL result to Department object
    private static final class UserRowMapper implements RowMapper<Department> {
        @Override
        public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
            Department department = new Department();
            department.setId(rs.getInt("id"));
            department.setName(rs.getString("name"));
            department.setDescription(rs.getString("description"));
            return department;
        }
    }

    // Insert
    public int insertDepartment(Department department) {
        String sql = "INSERT INTO departments (name, description) VALUES (?, ?)";
        return jdbcTemplate.update(sql, department.getName(), department.getDescription());
    }

    // Select
    public Department selectDepartmentById(Long id) {
        String sql = "SELECT * FROM departments WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
    }

    // Select All
    public List<Department> selectAllDepartments() {
        String sql = "SELECT * FROM departments";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    // Update
    public int updateUser(Department user) {
        String sql = "UPDATE departments SET name = ?, description = ? WHERE id = ?";
        return jdbcTemplate.update(sql, user.getName(), user.getDescription(), user.getId());
    }

    // Delete
    public int deleteUser(Long id) {
        String sql = "DELETE FROM departments WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}