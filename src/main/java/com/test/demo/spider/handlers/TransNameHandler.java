package com.test.demo.spider.handlers;

import com.test.demo.spider.model.Movie;

public class TransNameHandler extends AbstractHandler {

    public TransNameHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    boolean deal(String tag, Movie movie) {
        String tagStr = tag.replaceAll("　|&nbsp;", "");
        if (tagStr.contains("译名")) {
            String[] strings = tagStr.split("译名");
            movie.setTransName(strings[1]);
            return true;
        }
        return false;
    }
}
