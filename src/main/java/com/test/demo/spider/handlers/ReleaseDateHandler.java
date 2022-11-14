package com.test.demo.spider.handlers;

import com.test.demo.spider.model.Movie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReleaseDateHandler extends AbstractHandler {
    public ReleaseDateHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    boolean deal(String tag, Movie movie) throws ParseException {
        String tagStr = tag.replaceAll("　|&nbsp;", "");
        if (tagStr.contains("上映日期")) {
            SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
            String subStr = tagStr.split("上映日期")[1];
            String dateStr = "";
            Date date = new Date();
            if (subStr.contains("(")) {
                dateStr = subStr.split("\\(")[0];
                date = sdf.parse(dateStr);
                movie.setReleaseDate(date);
                return true;
            }
        }
        return false;
    }
}
