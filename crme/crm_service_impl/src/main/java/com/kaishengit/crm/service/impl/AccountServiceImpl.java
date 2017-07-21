package com.kaishengit.crm.service.impl;

import com.kaishengit.crm.entity.Account;
import com.kaishengit.crm.entity.AccountDeptExample;
import com.kaishengit.crm.entity.AccountDeptKey;
import com.kaishengit.crm.entity.AccountExample;
import com.kaishengit.crm.mapper.AccountDeptMapper;
import com.kaishengit.crm.mapper.AccountMapper;
import com.kaishengit.crm.service.AccountService;
import com.kaishengit.exception.AuthenticationException;
import com.kaishengit.exception.ServiceException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;

/**
 * Created by linfeiya on 2017/7/17 0017.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private AccountDeptMapper accountDeptMapper;
    @Value("${password.salt}")
    private String passwordSalt;

    @Override
    @Transactional
    public void saveAccount(Account account, Integer[] deptIds) {
        //添加员工
        account.setCreateTime(new Date());
        account.setPassword(DigestUtils.md5Hex(passwordSalt+account.getPassword()));
        accountMapper.insert(account);
        //员工和部门关系相对应
        for (Integer deptId : deptIds){
            AccountDeptKey accountDeptKey = new AccountDeptKey();
            accountDeptKey.setDeptId(deptId);
            accountDeptKey.setAccountId(account.getId());

            accountDeptMapper.insert(accountDeptKey);
        }
    }

    @Override
    public List<Account> findAllAccount() {
        return accountMapper.selectByExample(new AccountExample());
    }

    @Override
    public Long countAll(Integer id) {

        return accountMapper.countByExample(new AccountExample());
    }

    @Override
    public Long countByDeptId(Integer deptId) {
        if(new Integer(1000).equals(deptId)){
            deptId = null;
        }
        return accountMapper.countByDeptId(deptId);
    }


    @Override
    public List<Account> findByDeptId(Integer deptId) {
        if(new Integer(1000).equals(deptId)){
            deptId = null;
        }
        return accountMapper.findByDeptId(deptId);
    }

    @Override
    @Transactional
    public void delAccountById(Integer id) {
        //删除关系
        AccountDeptExample accountDeptExample = new AccountDeptExample();
        accountDeptExample.createCriteria().andAccountIdEqualTo(id);
        accountDeptMapper.deleteByExample(accountDeptExample);
        //删除员工
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andIdEqualTo(id);
        accountMapper.deleteByExample(accountExample);
    }
//登录时校验用户名和密码
    @Override
    public Account login(String mobile, String password) {
        //根据电话查询account对象
        Account account = accountMapper.findByMobileLoadDept(mobile);
        if (account == null){
            throw new AuthenticationException("账号或密码错误");
        }
        //System.out.println(account.getPassword());
        if (DigestUtils.md5Hex(passwordSalt + password).equals(account.getPassword())){
            return account;
        }
        throw new AuthenticationException("账号或密码错误");
    }
//修改密码
    @Override
    public void changePassword(String oldPassword, String password,Account account) {
        //判断旧密码是否正确
        if(DigestUtils.md5Hex(passwordSalt+oldPassword).equals(account.getPassword())){
            //新密码
            account.setPassword(DigestUtils.md5Hex(passwordSalt+password));
            //修改密码
            accountMapper.updateByPrimaryKeySelective(account);
        }else {
            throw new ServiceException("密码错误");
        }
    }
}
