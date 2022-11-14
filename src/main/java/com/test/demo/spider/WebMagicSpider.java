package com.test.demo.spider;

import com.test.demo.spider.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

@Component
public class WebMagicSpider {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebMagicSpider.class);

    @Autowired
    private MoviePageProcessor processor;

    public void run() {
        LOGGER.info("start spider.");
        Spider.create(processor)
                .addUrl(Constant.INDEX_URL)
                .thread(5)
                .run();
    }

}
