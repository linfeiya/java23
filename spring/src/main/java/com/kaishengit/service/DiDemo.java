package com.kaishengit.service;

import com.kaishengit.dao.UserDao;

import java.util.*;

/**
 * Created by linfeiya on 2017/7/7 0007.
 */
public class DiDemo {
    private double score;
    private String name;
    private List<String> nameList;
    private Set<String> mySet;
    private Map<String,UserDao> userMap;
    private Properties config;

    public void setScore(double score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setUserMap(Map<String, UserDao> userMap) {
        this.userMap = userMap;
    }

    public void setConfig(Properties config) {
        this.config = config;
    }

    public void show(){
        System.out.println("name:" + name);
        System.out.println("score: " + score);
        for (String str : nameList){
            System.out.println("nameList: " + str);
        }
        for (String set : mySet){
            System.out.println("myset: " + set);
        }

        for (Map.Entry<String, UserDao> map : userMap.entrySet()){
            System.out.println(map.getKey() + "-->" + map.getValue());
        }
        Enumeration keys = config.propertyNames();
        while (keys.hasMoreElements()){
            String key = (String) keys.nextElement();
            String value = config.getProperty(key);
            System.out.println(key + "-->" + value);
        }
    }

}
