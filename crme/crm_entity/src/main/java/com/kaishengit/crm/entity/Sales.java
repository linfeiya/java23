package com.kaishengit.crm.entity;

import java.io.Serializable;
import java.util.Date;

public class Sales implements Serializable {

    private Integer id;
    private String salesName;
    private Integer accountId;
    private double valueOf;
    private String progressOf;
    private Date LastUpdateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public double getValueOf() {
        return valueOf;
    }

    public void setValueOf(double valueOf) {
        this.valueOf = valueOf;
    }

    public String getProgressOf() {
        return progressOf;
    }

    public void setProgressOf(String progressOf) {
        this.progressOf = progressOf;
    }

    public Date getLastUpdateTime() {
        return LastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        LastUpdateTime = lastUpdateTime;
    }
}
