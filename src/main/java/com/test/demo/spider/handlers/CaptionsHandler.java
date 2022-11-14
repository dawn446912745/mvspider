package com.test.demo.spider.handlers;

import com.test.demo.spider.model.Movie;

public class CaptionsHandler extends AbstractHandler {

    public CaptionsHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    boolean deal(String tag, Movie movie) {
        String tagStr = tag.replaceAll("　|&nbsp;", "");
        if (tagStr.contains("字幕")) {
            String[] strings = tagStr.split("字幕");
            movie.setCaptions(strings[1]);
            return true;
        }
        return false;
    }
}
