package com.test.demo.spider.handlers;

import com.test.demo.spider.model.Movie;

public class LangHandler extends AbstractHandler {

    public LangHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    boolean deal(String tag, Movie movie) {
        String tagStr = tag.replaceAll("　|&nbsp;", "");
        if (tagStr.contains("语言")) {
            String[] strings = tagStr.split("语言");
            movie.setLang(strings[1]);
            return true;
        }
        return false;
    }
}
