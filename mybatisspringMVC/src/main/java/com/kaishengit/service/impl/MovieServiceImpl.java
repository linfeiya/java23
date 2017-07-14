package com.kaishengit.service.impl;

import com.kaishengit.mapper.MovieMapper;
import com.kaishengit.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaishengit.service.MovieService;

import java.util.List;

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
}
