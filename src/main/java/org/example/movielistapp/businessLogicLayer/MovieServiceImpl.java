package org.example.movielistapp.businessLogicLayer;

import jakarta.transaction.Transactional;

import org.example.movielistapp.dataAcesssLayer.*;

import org.example.movielistapp.dataMapperLayer.MovieRequestMapper;
import org.example.movielistapp.dataMapperLayer.MovieResponseMapper;

import org.example.movielistapp.presentationLayer.DirectorResponseModel;
import org.example.movielistapp.presentationLayer.MovieRequestModel;
import org.example.movielistapp.presentationLayer.MovieResponseModel;
import org.example.movielistapp.utils.HttpErrorInfo;
import org.example.movielistapp.utils.exceptions.InUseException;
import org.example.movielistapp.utils.exceptions.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepostiory;
    private final MovieResponseMapper movieResponseMapper;
    private final MovieRequestMapper movieRequestMapper;
    private final MovieResponseModel movieResponseDTO;
    private final MovieRequestModel movieRequestModel;
    private final LanguageRepository languageRepository;


    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, DirectorRepository directorRepostiory,
                            MovieResponseMapper movieResponseMapper, MovieRequestMapper movieRequestMapper,
                            MovieResponseModel movieResponseDTO, MovieRequestModel movieRequestModel, LanguageRepository languageRepository) {
        this.movieRepository = movieRepository;
        this.directorRepostiory = directorRepostiory;
        this.movieResponseMapper = movieResponseMapper;
        this.movieRequestMapper = movieRequestMapper;
        this.movieResponseDTO = movieResponseDTO;
        this.movieRequestModel = movieRequestModel;
        this.languageRepository = languageRepository;
    }

    @Override
    public List<MovieResponseModel> getMovies() {

        List<Movie> movieEntities = movieRepository.findAll();
        //convert list of Movie entities to list of MovieResponseDTO
        return this.movieResponseMapper.entityListToResponseModelList(movieEntities);
    }

    @Override
    public MovieResponseModel getMovieById(String movie_id) {

        Movie movie = this.movieRepository.findMovieByMovieId(movie_id);

        if (movie == null) {

            throw new NotFoundException("Unknown movieId: " + movie_id);
        }else {

            return this.movieResponseMapper.entityToResponseModel(movie);
        }
    }


@Override
    public MovieResponseModel addMovie(MovieRequestModel requestDTO) {

        String movieId = requestDTO.getMovieId();

        Movie foundMovie = movieRepository.findMovieByMovieId(movieId);

        if (foundMovie != null) {
            throw new InUseException("Movie with Id " + movieId + " already exists");
        }else {
            Movie movie = new Movie();
            Language language = languageRepository.findLanguageByLanguageId(String.valueOf(requestDTO.getLanguageId()));
            movie.setLanguage(language);
            BeanUtils.copyProperties(requestDTO, movie);
            Movie savedMovie = this.movieRepository.save(movie);
            MovieResponseModel movie2 = this.movieResponseMapper.entityToResponseModel(savedMovie);
            return movie2;
        }

}
@Override
    public MovieResponseModel updateMovie (String movie_id, MovieRequestModel requestDTO){


    if (requestDTO.getMovieId() == null || requestDTO.getMovieId().isEmpty()) {
        throw new NotFoundException("Movie ID in the request body is empty, keep the same id from the path variable");
    }

    if(!requestDTO.getMovieId().equals(movie_id)) {
       throw new NotFoundException("Movie ID in the request body is not the same as the id in the path variable");
 }
    Movie foundMovie = this.movieRepository.findMovieByMovieId(movie_id);

    if (foundMovie == null) {
        throw new NotFoundException("Movie with Id " + movie_id + " not found");
    }  else {

        BeanUtils.copyProperties(requestDTO, foundMovie,"movie_id");
        Movie savedMovie = this.movieRepository.save(foundMovie);
        MovieResponseModel model2 = this.movieResponseMapper.entityToResponseModel(savedMovie);
        return model2;

    }




}

@Override
    public String deleteMovie (String movie_id) {
        Movie foundMovie = this.movieRepository.findMovieByMovieId(movie_id);

        if (foundMovie == null) {
            throw new NotFoundException("Movie with Id " + movie_id + " not found");
        }
        movieRepository.delete(foundMovie);
        return "Movie with Id " + movie_id + " deleted";

}


}
