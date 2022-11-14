package com.test.demo.spider.handlers;

import com.test.demo.spider.model.Movie;

public class ProductPlaceHandler extends AbstractHandler {

    public ProductPlaceHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    boolean deal(String tag, Movie movie) {
        String tagStr = tag.replaceAll("　|&nbsp;", "");
        if (tagStr.contains("产地")) {
            String[] strings = tagStr.split("产地");
            movie.setProductPlace(strings[1]);
            return true;
        }
        return false;
    }
}
