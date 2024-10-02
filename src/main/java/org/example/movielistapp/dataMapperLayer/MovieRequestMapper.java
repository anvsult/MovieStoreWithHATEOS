package org.example.movielistapp.dataMapperLayer;


import org.example.movielistapp.dataAcesssLayer.Movie;
import org.example.movielistapp.presentationLayer.MovieRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieRequestMapper {

    @Mapping(target = "id", ignore = true)
    Movie  requestModelToEntity(MovieRequestModel movieRequestModel);
    List<Movie>  requestModelListToEntityList(List<MovieRequestModel> movieRequestModel);


}
