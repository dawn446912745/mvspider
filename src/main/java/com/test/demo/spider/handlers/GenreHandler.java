package com.test.demo.spider.handlers;

import com.test.demo.spider.model.Movie;

public class GenreHandler extends AbstractHandler {

    public GenreHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    boolean deal(String tag, Movie movie) {
        String tagStr = tag.replaceAll("　|&nbsp;", "");
        if (tagStr.contains("类别")) {
            String[] strings = tagStr.split("类别");
            movie.setGenre(strings[1]);
            return true;
        }
        return false;
    }
}
