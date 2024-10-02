package org.example.movielistapp.dataMapperLayer;

import org.example.movielistapp.dataAcesssLayer.Director;
import org.example.movielistapp.dataAcesssLayer.Movie;
import org.example.movielistapp.presentationLayer.DirectorRequestModel;
import org.example.movielistapp.presentationLayer.MovieRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DirectorRequestMapper {

    @Mapping(target = "id", ignore = true)
    Director requestModelToEntity(DirectorRequestModel requestModel);
    List<Director> requestModelListToEntityList(List<DirectorRequestModel> requestModel);



}
