package org.example.movielistapp.dataMapperLayer;


import org.example.movielistapp.dataAcesssLayer.Movie;
import org.example.movielistapp.presentationLayer.LanguageController;
import org.example.movielistapp.presentationLayer.MovieController;
import org.example.movielistapp.presentationLayer.MovieResponseModel;
import org.mapstruct.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieResponseMapper {
    @Mappings({
            @Mapping(target = "languageId", expression = "java(movie.getLanguage().getName().trim())")
    })

    MovieResponseModel entityToResponseModel(Movie movie);

    List<MovieResponseModel> entityListToResponseModelList(List<Movie> movies);


    @AfterMapping
    default void addLinks(@MappingTarget MovieResponseModel model, Movie entity){
        Link selfLink = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(MovieController.class)
                        .getMovieById(model.getMovieId()))
        .withSelfRel();

        Link langLink = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(LanguageController.class)
                        .getLanguages())
                .withRel("languages");

        model.add(selfLink);

        model.add(langLink);

    }
}
