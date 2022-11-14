package com.test.demo.controller;

import com.test.demo.service.MvService;
import com.test.demo.spider.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
class RsController {
    @Autowired
    private MvService service;

    @PostMapping("/download/add")
    public boolean addDownloadCount(String id) {
        service.updateDownloadCount(id);
        return true;
    }
}
