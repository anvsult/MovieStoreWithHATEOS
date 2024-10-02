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
public class LanguageResponseModel extends RepresentationModel<LanguageResponseModel> {
    private Integer languageId;
    private String name;
}
