package com.kaishengit.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Movie;

import java.util.List;

/**
 * Created by linfeiya on 2017/7/14 0014.
 */
public interface MovieService {
    List<Movie> findAll();
    void  save(Movie movie);
    PageInfo<Movie> findByParam(String title,String daoyan,Float min,Float max,Integer pageNo);
    Movie findById(Integer id);

    void update(Movie movie);

    void delById(Integer id);
}
