package com.test.demo.spider.handlers;

import java.util.Date;

public class Builder {
    public Handler build() {
        IntroductionHandler introductionHandler = new IntroductionHandler(null);
        ActorHandler actorHandler = new ActorHandler(introductionHandler);
        WriterHandler writerHandler = new WriterHandler(actorHandler);
        DirectorHandler directorHandler = new DirectorHandler(writerHandler);
        LengthOfFilmHandler lengthOfFilmHandler = new LengthOfFilmHandler(directorHandler);
        DoubanScoreHandler doubanScoreHandler = new DoubanScoreHandler(lengthOfFilmHandler);
        ImdbScoreHandler imdbScoreHandler = new ImdbScoreHandler(doubanScoreHandler);
        ReleaseDateHandler releaseDateHandler = new ReleaseDateHandler(imdbScoreHandler);
        CaptionsHandler captionsHandler = new CaptionsHandler(releaseDateHandler);
        LangHandler langHandler = new LangHandler(captionsHandler);
        GenreHandler genreHandler = new GenreHandler(langHandler);
        ProductPlaceHandler productPlaceHandler = new ProductPlaceHandler(genreHandler);
        AgeHandler ageHandler = new AgeHandler(productPlaceHandler);
        TransNameHandler transNameHandler = new TransNameHandler(ageHandler);
        NameHandler nameHandler = new NameHandler(transNameHandler);
        return nameHandler;
    }
}
