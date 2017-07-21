package com.kaishengit.mapper;

import com.kaishengit.entity.Movie;

import java.util.List;
import java.util.Map;

/**
 * Created by linfeiya on 2017/7/14 0014.
 */
public interface MovieMapper {

    List<Movie> findAll();
    void save(Movie movie);

    List<Movie> findByParam(Map<String, Object> map);
    Movie findById(Integer id);

    void update(Movie movie);

    void delById(Integer id);
}
