package org.example.movielistapp.presentationLayer;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class MovieResponseModel extends RepresentationModel<MovieResponseModel>  {

    private String movieId;

    private String title;

    private Integer releaseYear;

    private String posterURL;

    private String languageId;

    private String directorId;
}
