package com.test.demo.spider.handlers;

import com.test.demo.spider.model.Movie;

public class AgeHandler extends AbstractHandler {

    public AgeHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    boolean deal(String tag, Movie movie) {
        String tagStr = tag.replaceAll("　|&nbsp;", "");
        if (tagStr.contains("年代")) {
            String[] strings = tagStr.split("年代");
            movie.setAge(Integer.parseInt(strings[1]));
            return true;
        }
        return false;
    }
}
