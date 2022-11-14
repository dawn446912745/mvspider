package com.test.demo.spider.handlers;

import com.test.demo.spider.model.Movie;

public class NameHandler extends AbstractHandler {

    public NameHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    boolean deal(String tag, Movie movie) {
        String tagStr = tag.replaceAll("　|&nbsp;", "");
        if (tagStr.contains("片名")) {
            String[] strings = tagStr.split("片名");
            movie.setName(strings[1]);
            return true;
        }
        return false;
    }
}
