package org.example.movielistapp.presentationLayer;

import org.example.movielistapp.businessLogicLayer.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;


    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("")
    public List<MovieResponseModel> getMovies() {

        return movieService.getMovies();

    }

    @GetMapping("/{movie_id}")
    public MovieResponseModel getMovieById(@PathVariable String movie_id) {

        return movieService.getMovieById(movie_id);
    }


    @PostMapping("")
    public MovieResponseModel addOneMovie(@RequestBody MovieRequestModel movieRequestModel) {
        return movieService.addMovie(movieRequestModel);
    }

    @PutMapping("/{movie_id}")
    public MovieResponseModel updateMovie(@PathVariable String movie_id , @RequestBody MovieRequestModel movieRequestModel) {

        return movieService.updateMovie(movie_id, movieRequestModel);
    }

    @DeleteMapping("/{movie_id}")
    public String deleteMovie(@PathVariable String movie_id) {
        return movieService.deleteMovie(movie_id);
    }



}
