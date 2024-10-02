package org.example.movielistapp.dataAcesssLayer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "directors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Director {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "directorid")
    private String directorId;
    private String name;
    private LocalDate dob;
    private String country;


    @Column(name = "imageurl")
    private String imageURL;
//    @OneToMany(mappedBy = "directorId")
//    private Set<Movie> movies;
}
