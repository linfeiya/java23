package com.kaishengit.crm.service;

import com.kaishengit.crm.entity.Dept;

import java.util.List;

/**
 * Created by linfeiya on 2017/7/17 0017.
 */
public interface DeptService {
    List<Dept> findAllDept();

    void save(Dept dept);
}
