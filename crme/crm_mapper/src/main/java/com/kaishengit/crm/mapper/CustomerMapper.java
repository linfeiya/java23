package com.kaishengit.crm.mapper;

import com.github.pagehelper.PageInfo;
import com.kaishengit.crm.entity.Account;
import com.kaishengit.crm.entity.Customer;
import com.kaishengit.crm.entity.CustomerExample;

import java.util.List;
import java.util.Map;

/**
 * Created by linfeiya on 2017/7/20 0020.
 */
public interface CustomerMapper {

    List<Customer> findMyCustomer(Map<String, Object> map);

    void insert(Customer customer);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customer record);

    int deleteByPrimaryKey(Integer id);

    void updateByPrimaryKey(Customer customer);

    List<Customer> selectByExample(CustomerExample customerExample);
}
