package org.example.movielistapp.businessLogicLayer;

import org.example.movielistapp.dataAcesssLayer.Language;
import org.example.movielistapp.dataAcesssLayer.LanguageRepository;
import org.example.movielistapp.dataAcesssLayer.Movie;
import org.example.movielistapp.dataMapperLayer.LanguageResponseMapper;
import org.example.movielistapp.presentationLayer.LanguageMovieResponseModel;
import org.example.movielistapp.presentationLayer.LanguageResponseModel;
import org.example.movielistapp.presentationLayer.MovieResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class LanguageServiceImpl implements LanguageService{
    private final LanguageRepository languageRepository;
    private final LanguageResponseMapper languageResponseMapper;

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository, LanguageResponseMapper languageResponseMapper) {
        this.languageRepository = languageRepository;
        this.languageResponseMapper = languageResponseMapper;
    }

    @Override
    public List<LanguageResponseModel> findAllLanguages() {
        List<Language> languages = languageRepository.findAll();
        return languageResponseMapper.entityListToResponseModelList(languages);
    }

    @Override
    public LanguageResponseModel findLanguageByLanguageId(String languageId) {
        Language language = languageRepository.findLanguageByLanguageId(languageId);
        return languageResponseMapper.entityToResponseModel(language);
    }

    @Override
    public List<Movie> findMoviesByLanguageId(String languageId) {
        Language language = languageRepository.findLanguageByLanguageId(languageId);
        Set<Movie> movieSet = language.getMovies();
        return new ArrayList<>(movieSet);
    }
}
