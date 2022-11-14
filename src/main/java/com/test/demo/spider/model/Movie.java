package com.test.demo.spider.model;

import java.util.Date;

/**
 * The type Movie.
 */
public class Movie {
    private int id;
    // 片名
    private String name = "";
    // 译名
    private String transName = "";
    // 年代
    private int age = 2022;
    // 产地
    private String productPlace = "";
    // 类别
    private String genre = "";
    // 语言
    private String lang = "";
    // 字幕
    private String captions = "";
    // 上映日期
    private Date releaseDate = new Date();
    // IMDb评分
    private double imdbScore = 0.0d;
    // 豆瓣评分
    private double doubanScore = 0.0d;
    // 片长
    private int lengthOfFilm = 0;
    // 导演
    private String director = "";
    // 编剧
    private String writer = "";
    // 演员
    private String actor = "";
    // 简介
    private String introduction = "";
    // 下载链接
    private String link = "";
    // 图片
    private String img = "";
    // 下载次数
    private int downloadCount = 0;
    // 创建时间
    private Date createDate = new Date();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProductPlace() {
        return productPlace;
    }

    public void setProductPlace(String productPlace) {
        this.productPlace = productPlace;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCaptions() {
        return captions;
    }

    public void setCaptions(String captions) {
        this.captions = captions;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getImdbScore() {
        return imdbScore;
    }

    public void setImdbScore(double imdbScore) {
        this.imdbScore = imdbScore;
    }

    public double getDoubanScore() {
        return doubanScore;
    }

    public void setDoubanScore(double doubanScore) {
        this.doubanScore = doubanScore;
    }

    public int getLengthOfFilm() {
        return lengthOfFilm;
    }

    public void setLengthOfFilm(int lengthOfFilm) {
        this.lengthOfFilm = lengthOfFilm;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
