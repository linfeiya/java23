package com.kaishengit.crm.controller;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.kaishengit.crm.entity.Account;
import com.kaishengit.crm.entity.Dept;
import com.kaishengit.crm.service.AccountService;
import com.kaishengit.crm.service.DeptService;
import com.kaishengit.dto.AjaxResult;
import com.kaishengit.dto.DataTableResult;
import com.kaishengit.dto.ZTreeNode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by linfeiya on 2017/7/17 0017.
 */
@Controller
@RequestMapping("/manage/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private DeptService deptService;

    @PostMapping("/del/{id:\\d+}")
    @ResponseBody
    public AjaxResult delAccountById(@PathVariable Integer id){
        accountService.delAccountById(id);
        return AjaxResult.success();
    }
    @GetMapping
    public String accountList(Model model){
        model.addAttribute("deptList",deptService.findAllDept());
        return "manage/accounts";
    }

    @PostMapping("/depts.json")
    @ResponseBody
    public List<ZTreeNode> loadDeptData(){
        List<Dept> deptList = deptService.findAllDept();
        List<ZTreeNode> nodeList = Lists.newArrayList(Collections2.transform(deptList, new Function<Dept, ZTreeNode>() {
            @Nullable
            @Override
            public ZTreeNode apply(@Nullable Dept dept) {
                ZTreeNode node = new ZTreeNode();
                node.setId(dept.getId());
                node.setName(dept.getDeptName());
                node.setpId(dept.getpId());
                return node;
        }
        }));
        return nodeList;
    }
    //新增部门
    @PostMapping("/dept/new")
    @ResponseBody
    public AjaxResult saveNewDept(Dept dept){
            deptService.save(dept);
            return AjaxResult.success();
    }

    //新增员工
    @PostMapping("/new")
    @ResponseBody
    public AjaxResult saveNewAccount(Account account,Integer[] deptId){
        accountService.saveAccount(account,deptId);
        return AjaxResult.success();
    }

    //加载数据
    @GetMapping("/load.json")
    @ResponseBody
    public DataTableResult<Account> loadAccountData(HttpServletRequest request){
        String draw = request.getParameter("draw");
        String deptId = request.getParameter("deptId");

        Integer id = null;
        if(StringUtils.isNoneEmpty(deptId)){
            id = Integer.valueOf(deptId);
        }

        //获取account的总信息数
        Long total = accountService.countAll(id);
        //获取过滤后的数据数
        Long filtedTotal = total;
        //当前页的记录数
        List<Account> accountList = accountService.findByDeptId(id);
        return new  DataTableResult<>(draw,total,filtedTotal,accountList);
    }
}
