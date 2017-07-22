package com.kaishengit.crm.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.crm.entity.Account;
import com.kaishengit.crm.entity.Customer;

import java.util.List;
import java.util.Map;

/**
 * Created by linfeiya on 2017/7/20 0020.
 */
public interface CustomerService {

    PageInfo<Customer> findMyCustomer(Map<String, Object> map);

    List<String> findAllTrade();

    List<String> findAllSource();

    void saveNewCustomer(Customer customer, Account account);

    Customer findById(Integer id);

    void editCustomer(Customer customer);

    void delCustomer(Customer customer);

    void shareCustomerToPublic(Customer customer, Account account);

    void transferCustomerToAccount(Customer customer, Account account,Integer accountId);
}
