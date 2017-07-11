package com.kaishengit.dao;

import com.kaishengit.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by linfeiya on 2017/7/11 0011.
 */
@Repository
public class DeptDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;




}
