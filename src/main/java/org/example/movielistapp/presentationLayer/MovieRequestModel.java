package org.example.movielistapp.presentationLayer;

import lombok.*;
import org.springframework.stereotype.Component;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class MovieRequestModel {

    private String movieId;

    private String title;

    private Integer releaseYear;

    private String posterURL;

    private String directorId;

    private Integer languageId;

}
