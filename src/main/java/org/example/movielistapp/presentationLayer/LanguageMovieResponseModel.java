package org.example.movielistapp.presentationLayer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class LanguageMovieResponseModel extends RepresentationModel<LanguageMovieResponseModel> {
    private String movieId;
    private String title;
    private String languageId;
    private String language;
}
