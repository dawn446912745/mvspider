package com.test.demo.spider.handlers;

import com.test.demo.spider.model.Movie;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LengthOfFilmHandler extends AbstractHandler {

    public LengthOfFilmHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    boolean deal(String tag, Movie movie) {
        String tagStr = tag.replaceAll("　|&nbsp;", "");
        if (tagStr.contains("片长")) {
            String subStr = tagStr.split("片长")[1];
            int score = 0;
            if (subStr.contains("分钟")) {
                String scoreStr = subStr.split("分钟")[0];
                score = Integer.parseInt(scoreStr);
                movie.setLengthOfFilm(score);
                return true;
            }
        }
        return false;
    }
}
