package com.test.demo.spider.handlers;

import com.test.demo.spider.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

public abstract class AbstractHandler implements Handler{
    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractHandler.class);

    Handler nextHandler;

    public AbstractHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void process(String tag, Movie movie) {
        try {
            if (!deal(tag, movie)) {
                if (nextHandler != null) {
                    nextHandler.process(tag, movie);
                }
            }
        } catch (Exception e) {
            LOGGER.error("deal occur error.", e);
        }
    }

    abstract boolean deal(String tag, Movie movie) throws Exception;
}
