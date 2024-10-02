package org.example.movielistapp.dataMapperLayer;

import org.example.movielistapp.dataAcesssLayer.Director;
import org.example.movielistapp.dataAcesssLayer.Movie;
import org.example.movielistapp.presentationLayer.DirectorResponseModel;
import org.example.movielistapp.presentationLayer.MovieResponseModel;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface DirectorResponseMapper {


    DirectorResponseModel entityToResponseModel(Director entity);

        List<DirectorResponseModel> entityListToResponseModelList(List<Director> entities);
}
