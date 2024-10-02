package org.example.movielistapp.dataMapperLayer;

import org.example.movielistapp.dataAcesssLayer.Language;
import org.example.movielistapp.dataAcesssLayer.Movie;
import org.example.movielistapp.presentationLayer.LanguageController;
import org.example.movielistapp.presentationLayer.LanguageMovieResponseModel;
import org.example.movielistapp.presentationLayer.LanguageResponseModel;
import org.example.movielistapp.presentationLayer.MovieController;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LanguageMovieResponseMapper {

    @Mapping(target = "languageId", expression = "java(movie.getLanguage().getLanguageId())")
    @Mapping(target = "language", expression = "java(movie.getLanguage().getName().trim())")
    LanguageMovieResponseModel entityToResponseModel(Movie movie);

    @Mapping(target = "language", expression = "java(movie.getLanguage().getName().trim())")
    LanguageMovieResponseModel entityToResponseModel(Movie movie, Language language);

    @Mapping(target = "releaseYear", ignore = true)
    @Mapping(target = "posterURL", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "directorId", ignore = true)
    @Mapping(target = "language", ignore = true)

    List<LanguageMovieResponseModel> entityListToResponseModelList(List<Movie> movieList);

    @AfterMapping
    default void addLinks(@MappingTarget LanguageMovieResponseModel model){
        Link selfLink = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(LanguageController.class)
                        .getMoviesByLanguageId(model.getLanguageId()))
                .withSelfRel();
        model.add(selfLink);

        Link moviesLink = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(MovieController.class)
                        .getMovies())
                .withRel("movies");
        model.add(moviesLink);
    }
}
