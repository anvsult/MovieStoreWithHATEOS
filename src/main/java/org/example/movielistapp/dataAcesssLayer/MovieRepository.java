package org.example.movielistapp.dataAcesssLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findMovieByMovieId(String movie_id);

}
