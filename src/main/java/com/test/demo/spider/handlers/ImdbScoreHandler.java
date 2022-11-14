package com.test.demo.spider.handlers;

import com.test.demo.spider.model.Movie;

public class ImdbScoreHandler extends AbstractHandler {

    public ImdbScoreHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    boolean deal(String tag, Movie movie) {
        String tagStr = tag.replaceAll("　|&nbsp;", "");
        if (tagStr.contains("IMDb评分")) {
            String subStr = tagStr.split("IMDb评分")[1];
            double score = 0d;
            if (subStr.contains("/")) {
                String scoreStr = subStr.split("/")[0];
                score = Double.parseDouble(scoreStr);
                movie.setImdbScore(score);
                return true;
            }
        }
        return false;
    }
}
