package com.example.demo.service;

import com.example.demo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class MySqlService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(Student student){
        String insertSql = "insert into a_student(id,name,sex,age) values(null,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(insertSql,new String[]{"id"});
                ps.setString(1,student.getName());
                ps.setInt(2,student.getSex());
                ps.setInt(3,student.getAge());
                return ps;
            }
        },keyHolder);
        return  Integer.parseInt(keyHolder.getKey().toString());
    }

    public List<Map<String, Object>> selectAll(){
        String sql = "select * from a_student";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }
}
