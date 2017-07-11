package com.kaishengit.dao;

import com.kaishengit.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void  save(User user){
        String sql = "insert into t_user(dept_id,user_name,user_age,address,password) values(?,?,?,?,?)";
        jdbcTemplate.update(sql,user.getDept_id(),user.getUser_name(),user.getUser_age(),user.getAddress(),user.getPassword());
    }

    public void update(User user){
        String sql = "update t_user set user_name = ? where id = ?";
        jdbcTemplate.update(sql,user.getUser_name(),user.getId());
    }

    public List<User> findAll(){
        String sql = "select * from t_user";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
    }
    public User findById(Integer id){
        String sql = "select * from t_user where id=?";
        return jdbcTemplate.queryForObject(sql,new UserRowMapper(),id);
    }

    public List<User> findByName(String userName){
        String sql = "select * from t_user where user_name = ?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class),userName);
    }

    public List<User> findByAddress(String address){
        String sql = "select * from t_user where address=?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class),address);
    }

    public Long count(){
        String sql = "select count(*) from t_user";
        return jdbcTemplate.queryForObject(sql,Long.class);
    }

    private class UserRowMapper implements RowMapper<User>{

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUser_name(resultSet.getString("user_name"));
                user.setUser_age(resultSet.getInt("user_age"));
                user.setAddress(resultSet.getString("address"));
                user.setDept_id(resultSet.getInt("dept_id"));
                user.setPassword(resultSet.getString("password"));
            return user;
        }
    }
}
