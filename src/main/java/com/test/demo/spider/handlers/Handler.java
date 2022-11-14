package com.test.demo.spider.handlers;

import com.test.demo.spider.model.Movie;

public interface Handler {
    void process(String tag, Movie movie);
}
