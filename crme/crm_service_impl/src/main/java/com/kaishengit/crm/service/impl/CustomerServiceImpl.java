package com.kaishengit.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.crm.entity.Account;
import com.kaishengit.crm.entity.Customer;
import com.kaishengit.crm.entity.CustomerExample;
import com.kaishengit.crm.entity.Sales;
import com.kaishengit.crm.mapper.CustomerMapper;
import com.kaishengit.crm.service.CustomerService;
import com.kaishengit.exception.ServiceException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.OutputStream;
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
    //将客户放入公海
    @Override
    public void shareCustomerToPublic(Customer customer, Account account) {

        customer.setReminder(account.getUserName()+"将客户 "+customer.getCustName()+" 放入公海");
        customer.setAccountId(null);
        customerMapper.updateByPrimaryKey(customer);
    }
    //将客户转给其他账号
    @Override
    public void transferCustomerToAccount(Customer customer, Account account,Integer accountId) {
        customer.setAccountId(accountId);
        customer.setReminder("从" + account.getUserName() + "转交过来");
        customerMapper.updateByPrimaryKey(customer);
    }

    @Override
    public List<Customer> findByAccoutnId(Integer accountId) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andAccountIdEqualTo(accountId);
        return customerMapper.selectByExample(customerExample);
    }
    //导出
    @Override
    public void exportAccountCustomerToExcel(Account account, OutputStream outputStream) {
        //创建工作表
        Workbook workbook = new HSSFWorkbook();
        //创建sheet
        Sheet sheet = workbook.createSheet("客户资料");
        //创建列
        Row row = sheet.createRow(0);
        //创建数据
        row.createCell(0).setCellValue("客户名称");
        row.createCell(1).setCellValue("职位");
        row.createCell(2).setCellValue("级别");
        row.createCell(3).setCellValue("联系方式");

        //关联输出流
        List<Customer> customerList = findByAccoutnId(account.getId());
        for (int i = 0;i < customerList.size();i++){
            Customer customer = customerList.get(i);
            Row row1 = sheet.createRow(i+1);
            row1.createCell(0).setCellValue(customer.getCustName());
            row1.createCell(1).setCellValue(customer.getJobTitle());
            row1.createCell(2).setCellValue(customer.getLevel());
            row1.createCell(3).setCellValue(customer.getMobile());
        }
        try {
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            throw new ServiceException("Excel导出失败",e);
        }
    }
}
