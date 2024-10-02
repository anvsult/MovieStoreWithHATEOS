package org.example.movielistapp.presentationLayer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LanguageRequestModel {
    @Id
    private Integer languageId;
    private String name;
}
