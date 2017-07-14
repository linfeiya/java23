package com.kaishengit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kaishengit.service.MovieService;

/**
 * Created by linfeiya on 2017/7/14 0014.
 */
@Controller
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("movieList",movieService.findAll());
        return "movie/list";
    }


}
