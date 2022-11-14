package com.test.demo.spider;

import com.test.demo.service.MvService;
import com.test.demo.spider.dao.SqlDao;
import com.test.demo.spider.handlers.Builder;
import com.test.demo.spider.handlers.Handler;
import com.test.demo.spider.model.Movie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ContentParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContentParser.class);

    @Autowired
    private MvService service;

    public void parse(List<String> content) {
        if (Objects.isNull(content) || CollectionUtils.isEmpty(content)) {
            return;
        }
        String str = content.get(0);
        if (!str.contains("<br>")) {
            LOGGER.error("this content is not contains <br>");
            return;
        }
        Movie movie = new Movie();
        String[] tags = str.split("<br>");
        Handler handler = new Builder().build();
        int i = 0;
        for (String tag : tags) {
            dealIntroduction(tag, tags, i);
            handler.process(tag, movie);
            i++;
        }
        Document document = Jsoup.parse(str);
        Element img = document.select("img").get(0);
        Element link = document.select("a").get(0);
        movie.setImg(img.attr("src"));
        movie.setLink(link.attr("href"));
        movie.setCreateDate(new Date());

        service.insert(movie);
        LOGGER.info("cont: {}", str);
    }

    private void dealIntroduction(String currTag, String[] tags, int i) {
        currTag = currTag.replaceAll("　", "");
        if (currTag.contains("简介")) {
            tags[i] = "";
            String longestTag = "";
            int n = 1;
            String tag1 = tags[i + 1];
            tag1 = tag1.replaceAll("　", "");
            if (tag1.length() > longestTag.length()) {
                longestTag = tag1;
            }
            String tag2 = tags[i + 2];
            tag2 = tag2.replaceAll("　", "");
            if (tag2.length() > longestTag.length()) {
                longestTag = tag2;
                n = 2;
            }
            String tag3 = tags[i + 3];
            tag3 = tag3.replaceAll("　", "");
            if (tag3.length() > longestTag.length()) {
                longestTag = tag3;
                n = 3;
            }
            tags[i + n] = "INTRODUCTION" + longestTag;
        }
    }
}
