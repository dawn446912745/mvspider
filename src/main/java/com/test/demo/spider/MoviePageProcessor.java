package com.test.demo.spider;

import com.test.demo.spider.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("all")
@Component
public class MoviePageProcessor implements PageProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(MoviePageProcessor.class);

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Autowired
    private ContentParser parser;

    @Override
    public void process(Page page) {
        List<String> linkStrList = page.getHtml().css("div.bd3rl>div.co_area2>div.co_content8 td a").all();
        Pattern pt = Pattern.compile("<a[^>]*href=\\\"([^\\\"]+)\\\".*</a>");
        List<String> targetLinkList = new ArrayList<>();
        for (String linkStr : linkStrList) {
            Matcher matcher = pt.matcher(linkStr);
            while (matcher.find()) {
                String group1 = matcher.group(1);
                String link = Constant.BASE_URL + group1;
                targetLinkList.add(link);
                LOGGER.info(link);
            }
        }
        page.addTargetRequests(targetLinkList);
        List<String> content = page.getHtml().css("div.bd3l span").all();
        parser.parse(content);
    }

    @Override
    public Site getSite() {
        return site;
    }
}
