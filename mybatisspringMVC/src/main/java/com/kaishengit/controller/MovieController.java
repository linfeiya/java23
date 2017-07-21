package com.kaishengit.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Movie;

import com.kaishengit.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.kaishengit.service.MovieService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by linfeiya on 2017/7/14 0014.
 */
@Controller
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping("/list")
    public String list(@RequestParam(required = false,defaultValue = "1",name = "p") Integer pageNo,
                       @RequestParam(required = false) String title,
                       @RequestParam(required = false) String daoyan,
                       @RequestParam(required = false) Float min,
                       @RequestParam(required = false) Float max,
                       Model model){
        title = StringUtil.isoToUtf8(title);
        daoyan = StringUtil.isoToUtf8(daoyan);
        PageInfo<Movie> pageInfo = movieService.findByParam(title,daoyan,min,max,pageNo);
        model.addAttribute("page",pageInfo);
        model.addAttribute("title",title);
        model.addAttribute("daoyan",daoyan);
        model.addAttribute("min",min);
        model.addAttribute("max",max);
        model.addAttribute("movieList",movieService.findAll());
        return "movie/list";
    }
    @GetMapping("/new")
    public String save(){
        return "movie/new";
    }

    @PostMapping("/new")
    public String saveMovie(Movie movie, RedirectAttributes redirectAttributes){
        movieService.save(movie);
        redirectAttributes.addFlashAttribute("message","新增成功");
        return "redirect:/movie/list";
    }
    @GetMapping("/edit/{id:\\d+}")
    public String movieShow(@PathVariable Integer id,Model model){
        Movie movie = movieService.findById(id);
        model.addAttribute("movie",movie);
        return "movie/edit";
    }
    @PostMapping("/edit/{id:\\d+}")
    public String editMovie(Movie movie,RedirectAttributes redirectAttributes){
        movieService.update(movie);
        redirectAttributes.addFlashAttribute("message","修改成功");
        return "redirect:/movie/list";
    }
    @GetMapping("/del/{id:\\d+}")
    public String delMoive(@PathVariable Integer id,RedirectAttributes redirectAttributes){
        movieService.delById(id);
        redirectAttributes.addFlashAttribute("message","删除成功");
        return "redirect:/movie/list";
    }
}
