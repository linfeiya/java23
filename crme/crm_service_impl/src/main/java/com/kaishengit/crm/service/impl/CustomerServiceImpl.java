package com.kaishengit.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.crm.entity.Account;
import com.kaishengit.crm.entity.Customer;
import com.kaishengit.crm.mapper.CustomerMapper;
import com.kaishengit.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by linfeiya on 2017/7/20 0020.
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerMapper customerMapper;
    @Value("#{'${customer.source}'.split(',')}")
    private List<String> sourceList;
    @Value("#{'${customer.trade}'.split(',')}")
    private List<String> tradeList;

    //查询当前登录客户，并分页
    @Override
    public PageInfo<Customer> findMyCustomer(Map<String, Object> map) {
        Integer pageNum = (Integer) map.get("pageNum");
        PageHelper.startPage(pageNum, 10);
        List<Customer> myCustomer = customerMapper.findMyCustomer(map);
        return new PageInfo<>(myCustomer);
    }
    //所有行业数据
    @Override
    public List<String> findAllTrade() {
        return tradeList;
    }
    //所有客户来源
    @Override
    public List<String> findAllSource() {
        return sourceList;
    }
    //新增客户
    @Override
    public void saveNewCustomer(Customer customer, Account account) {
        customer.setAccountId(account.getId());
        customer.setCreateTime(new Date());
       customerMapper.insert(customer);
    }
    //根据ID查找客户
    @Override
    public Customer findById(Integer id) {
        return customerMapper.selectByPrimaryKey(id);
    }
    //修改客户并记录修改时间
    @Override
    public void editCustomer(Customer customer) {
        customer.setUpdateTime(new Date());
        customerMapper.updateByPrimaryKeySelective(customer);
    }
    //删除客户
    @Override
    public void delCustomer(Customer customer) {
        customerMapper.deleteByPrimaryKey(customer.getId());
    }

}
