package com.kaishengit.service.impl;

import com.github.pagehelper.PageInfo;
import com.kaishengit.mapper.MovieMapper;
import com.kaishengit.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaishengit.service.MovieService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linfeiya on 2017/7/14 0014.
 */
@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieMapper movieMapper;
    @Override
    public List<Movie> findAll() {
        return movieMapper.findAll();
    }

    @Override
    public void save(Movie movie) {
        movieMapper.save(movie);
    }


    @Override
    public PageInfo<Movie> findByParam(String title, String daoyan, Float min, Float max, Integer pageNo) {
        Map<String,Object> map = new HashMap<>();
        map.put("title",title);
        map.put("daoyan",daoyan);
        map.put("min",min);
        map.put("max",max);
        map.put("pageNum",pageNo);
        map.put("pageSize",15);
        List<Movie> movieList = movieMapper.findByParam(map);
        return new PageInfo<>(movieList);
    }

    @Override
    public Movie findById(Integer id) {

        return movieMapper.findById(id);
    }

    @Override
    public void update(Movie movie) {
        movieMapper.update(movie);
    }

    @Override
    public void delById(Integer id) {
        movieMapper.delById(id);
    }


}
