package org.example.movielistapp.dataAcesssLayer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.security.auth.callback.LanguageCallback;

@Entity
@Table(name="movies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "movieid")
    private String movieId;
    private String title;
    @Column(name = "releaseyear")
    private Integer releaseYear;
    @Column(name = "posterurl")
    private String posterURL;

    @Column(name = "directorid")
    private String directorId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "languageid", nullable = false)
    private Language language;
}
