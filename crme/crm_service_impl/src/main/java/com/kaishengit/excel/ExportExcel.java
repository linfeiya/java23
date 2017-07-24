package com.kaishengit.excel;

import com.kaishengit.crm.entity.Account;
import com.kaishengit.crm.entity.Customer;
import com.kaishengit.crm.service.CustomerService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:application*.xml")
public class ExportExcel {
    @Autowired
    private CustomerService customerService;
    //Excel导出
    @Test
    public void exportExcelTest() throws IOException {
        List<Customer> customerList =  customerService.findByAccoutnId(1027);
        FileWriter fileWriter = new FileWriter("F:/upload/export.csv");

        fileWriter.write("姓名,职位,级别,联系方式\r\n");
        for (Customer customer : customerList){
            fileWriter.write(customer.getCustName()+","+customer.getJobTitle()+","+customer.getLevel()+","+customer.getMobile()+"\r\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }
    //导出如果出现中文乱码可更改导出字符格式
    @Test
    public void exportExcel() throws IOException {
        List<Customer> customerList = customerService.findByAccoutnId(1027);

        OutputStream outputStream = new FileOutputStream("F:/upload/export.csv");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,"UTF-8");

        outputStreamWriter.write("姓名,职位,级别,联系方式\r\n");
        for (Customer customer : customerList){
            outputStreamWriter.write(customer.getCustName()+","+customer.getJobTitle()+","+customer.getLevel()+","+customer.getMobile()+"\r\n");
        }
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }
    @Test
    public void excelXls() throws IOException {
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
        List<Customer> customerList = customerService.findByAccoutnId(1027);
        for (int i = 0;i < customerList.size();i++){
            Customer customer = customerList.get(i);
            Row row1 = sheet.createRow(i+1);
            row1.createCell(0).setCellValue(customer.getCustName());
            row1.createCell(1).setCellValue(customer.getJobTitle());
            row1.createCell(2).setCellValue(customer.getLevel());
            row1.createCell(3).setCellValue(customer.getMobile());
        }
        FileOutputStream outputStream = new FileOutputStream("F:/upload/export.csv");
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();

    }
}
