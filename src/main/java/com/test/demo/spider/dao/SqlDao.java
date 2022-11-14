package com.test.demo.spider.dao;

import com.test.demo.spider.model.Movie;
import com.test.demo.spider.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface SqlDao {
    @Insert("insert into user(id, name) values(#{id}, #{name})")
    public void add(User user);

    @Insert("insert into movie_tb(name, transName, age, productPlace, genre, lang, captions, releaseDate, imdbScore, " +
            "doubanScore, lengthOfFilm, director, writer, actor, introduction, link, img, createDate) " +
            "values(#{name}, #{transName}, #{age}, #{productPlace}, #{genre}, #{lang}, #{captions}, #{releaseDate}, #{imdbScore}, " +
            "#{doubanScore}, #{lengthOfFilm}, #{director}, #{writer}, #{actor}, #{introduction}, #{link}, #{img}, #{createDate})")
    public void insertMovie(Movie movie);

    @Select("select * from movie_tb order by createDate desc")
    public List<Movie> getMovies();

    @Select("select * from movie_tb where id=#{id}")
    public Movie getMovieById(String id);

    @Select("select count(*) from movie_tb where transName=#{transName}")
    public int getCountByName(String transName);

    @Update("update movie_tb set downloadCount=#{downloadCount} where id=#{id}")
    public void updateDownloadCount(@Param("id") String id, @Param("downloadCount") int downloadCount);
}
