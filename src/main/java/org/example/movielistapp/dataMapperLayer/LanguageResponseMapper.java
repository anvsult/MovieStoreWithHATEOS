package org.example.movielistapp.dataMapperLayer;

import org.example.movielistapp.dataAcesssLayer.Language;
import org.example.movielistapp.presentationLayer.LanguageResponseModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LanguageResponseMapper {
    LanguageResponseModel entityToResponseModel(Language language);
    List<LanguageResponseModel> entityListToResponseModelList(List<Language> languages);
}
