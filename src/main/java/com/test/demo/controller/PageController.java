package com.test.demo.controller;

import com.test.demo.service.MvService;
import com.test.demo.spider.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PageController {
    @Autowired
    private MvService service;

    @RequestMapping("/index")
    public String index(Model model) {
        List<Movie> movieList = service.getAll();
        Map<String,Object> reMap=new HashMap<>();
        reMap.put("movieList", movieList);
        model.addAllAttributes(reMap);
        return "index";
    }

    @RequestMapping("/detail")
    public ModelAndView detail(String id) {
        Movie movie = service.get(id);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("detail");
        mv.addObject("movie", movie);
        return mv;
    }
}
