package com.test.demo.spider.handlers;

import com.test.demo.spider.model.Movie;

public class DirectorHandler extends AbstractHandler {

    public DirectorHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    boolean deal(String tag, Movie movie) {
        String tagStr = tag.replaceAll("　|&nbsp;", "");
        if (tagStr.contains("导演")) {
            String[] strings = tagStr.split("导演");
            movie.setDirector(strings[1]);
            return true;
        }
        return false;
    }
}
