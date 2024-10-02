package org.example.movielistapp.presentationLayer;

import org.example.movielistapp.businessLogicLayer.LanguageService;
import org.example.movielistapp.businessLogicLayer.MovieService;
import org.example.movielistapp.dataAcesssLayer.Language;
import org.example.movielistapp.dataAcesssLayer.Movie;
import org.example.movielistapp.dataMapperLayer.LanguageMovieResponseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/languages")
public class LanguageController {
    private final LanguageService languageService;
    private final LanguageMovieResponseMapper languageMovieResponseMapper;

    public LanguageController(LanguageService languageService, LanguageMovieResponseMapper languageMovieResponseMapper) {
        this.languageService = languageService;
        this.languageMovieResponseMapper = languageMovieResponseMapper;
    }

    @GetMapping("")
    public List<LanguageResponseModel> getLanguages() {
        return languageService.findAllLanguages();
    }

    @GetMapping("/{languageId}")
    public LanguageResponseModel getLanguageByLanguageId(@PathVariable String languageId){
        return languageService.findLanguageByLanguageId(languageId);
    }

    @GetMapping("/{languageId}/movies")
    public List<LanguageMovieResponseModel> getMoviesByLanguageId(@PathVariable String languageId){
        List<Movie> movies = languageService.findMoviesByLanguageId(languageId);
        return languageMovieResponseMapper.entityListToResponseModelList(movies);
    }


}
