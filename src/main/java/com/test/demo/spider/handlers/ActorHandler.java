package com.test.demo.spider.handlers;

import com.test.demo.spider.model.Movie;

public class ActorHandler extends AbstractHandler {

    public ActorHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    boolean deal(String tag, Movie movie) {
        String tagStr = tag.replaceAll("　|&nbsp;", "");
        if (tagStr.contains("演员")) {
            String[] strings = tagStr.split("演员");
            movie.setActor(strings[1]);
            return true;
        }
        return false;
    }
}
