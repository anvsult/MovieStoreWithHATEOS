package org.example.movielistapp.presentationLayer;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class DirectorRequestModel {
    private String directorId;
    private String name;
    private LocalDate dob;
    private String country;
    private String imageURL;

}
