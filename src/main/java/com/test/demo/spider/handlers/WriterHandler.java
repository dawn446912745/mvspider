package com.test.demo.spider.handlers;

import com.test.demo.spider.model.Movie;

public class WriterHandler extends AbstractHandler {

    public WriterHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    boolean deal(String tag, Movie movie) {
        String tagStr = tag.replaceAll("　|&nbsp;", "");
        if (tagStr.contains("编剧")) {
            String[] strings = tagStr.split("编剧");
            movie.setWriter(strings[1]);
            return true;
        }
        return false;
    }
}
