package org.example.movielistapp.businessLogicLayer;


import org.example.movielistapp.presentationLayer.MovieRequestModel;
import org.example.movielistapp.presentationLayer.MovieResponseModel;

import java.util.List;

public interface MovieService {
    List<MovieResponseModel> getMovies();

    MovieResponseModel getMovieById(String movieId);



    MovieResponseModel addMovie(MovieRequestModel movieRequestModel);


    MovieResponseModel updateMovie(String movieId, MovieRequestModel movieRequestModel);

    String deleteMovie(String movieId);

}
