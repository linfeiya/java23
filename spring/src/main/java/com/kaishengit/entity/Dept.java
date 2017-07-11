package com.kaishengit.entity;

/**
 * Created by linfeiya on 2017/7/11 0011.
 */
public class Dept {
    private Integer id;
    private String dept_name;
    private String dept_password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDept_password() {
        return dept_password;
    }

    public void setDept_password(String dept_password) {
        this.dept_password = dept_password;
    }
}
