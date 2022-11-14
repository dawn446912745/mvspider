package com.test.demo.spider.handlers;

import com.test.demo.spider.model.Movie;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntroductionHandler extends AbstractHandler {

    public IntroductionHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    boolean deal(String tag, Movie movie) {
        String tagStr = tag.replaceAll("　|&nbsp;", "");
        if (tagStr.contains("INTRODUCTION")) {
            String subStr = tagStr.split("INTRODUCTION")[1];
            movie.setIntroduction(subStr);
            return true;
        }
        return false;
    }
}
