package org.example.movielistapp.businessLogicLayer;

import org.example.movielistapp.dataAcesssLayer.Language;
import org.example.movielistapp.dataAcesssLayer.Movie;
import org.example.movielistapp.presentationLayer.LanguageResponseModel;
import org.example.movielistapp.presentationLayer.MovieRequestModel;
import org.example.movielistapp.presentationLayer.MovieResponseModel;

import java.util.List;

public interface LanguageService {
    List<LanguageResponseModel> findAllLanguages();
    LanguageResponseModel findLanguageByLanguageId(String languageId);
    List<Movie> findMoviesByLanguageId(String languageId);

}
