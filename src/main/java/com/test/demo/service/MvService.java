package com.test.demo.service;

import com.test.demo.spider.WebMagicSpider;
import com.test.demo.spider.dao.SqlDao;
import com.test.demo.spider.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Service
public class MvService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MvService.class);

    @Autowired
    private WebMagicSpider spider;

    @Autowired
    private SqlDao dao;

    @Scheduled(cron="0 0 0 * * ?")
    public void schedule() {
        LOGGER.info("=====================start collection======================");
        spider.run();
        LOGGER.info("======================end collection========================");
    }

    public void insert(Movie movie) {
        if (!StringUtils.isEmpty(movie.getTransName())) {
            int count = dao.getCountByName(movie.getTransName());
            if (count == 0) {
                dao.insertMovie(movie);
            }
        }
    }

    public List<Movie> getAll() {
        return dao.getMovies();
    }

    public Movie get(String id) {
        return dao.getMovieById(id);
    }

    public void updateDownloadCount(String id) {
        Movie mv = dao.getMovieById(id);
        int downloadCount = mv.getDownloadCount() + 1;
        dao.updateDownloadCount(id, downloadCount);
    }
}
