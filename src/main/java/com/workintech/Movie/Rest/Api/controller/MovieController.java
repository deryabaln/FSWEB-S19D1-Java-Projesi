package com.workintech.Movie.Rest.Api.controller;

import com.workintech.Movie.Rest.Api.dto.ActorResponse;
import com.workintech.Movie.Rest.Api.dto.MovieActorRequest;
import com.workintech.Movie.Rest.Api.dto.MovieResponse;
import com.workintech.Movie.Rest.Api.entity.Actor;
import com.workintech.Movie.Rest.Api.entity.Movie;
import com.workintech.Movie.Rest.Api.dto.MovieActorResponse;
import com.workintech.Movie.Rest.Api.service.ActorService;
import com.workintech.Movie.Rest.Api.service.MovieService;
import com.workintech.Movie.Rest.Api.util.HollywoodUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public List<MovieResponse> find() {
        List <MovieResponse> movieResponses = new ArrayList<>();
        List <Movie> movieList = movieService.find();
        for(Movie movie : movieList){
            movieResponses.add(new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                    movie.getRating(), movie.getReleaseDate()));
        }
        return movieResponses;
    }

    @GetMapping("/{id}")
    public MovieResponse findById(@PathVariable int id) {
        Movie movie = movieService.findById(id);
        return new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                movie.getRating(), movie.getReleaseDate());
    }

    @PostMapping("/")
    public MovieActorResponse save(@RequestBody MovieActorRequest movieActorRequest) {
        Movie movie = movieActorRequest.getMovie();
        Actor actor = movieActorRequest.getActor();
        movie.addActor(actor);
        Movie savedMovie = movieService.save(movie);
        return HollywoodUtility.convertMovieActorResponse(savedMovie, actor);
    }

    @PostMapping("/addActor/{movieId}")
    public List<ActorResponse> addActor(@RequestBody List<Actor> actors, @PathVariable int movieId) {
        Movie movie = movieService.findById(movieId);
        movie.addAllActor(actors);
        Movie savedMovie = movieService.save(movie);
        return HollywoodUtility.convertActorResponses(savedMovie);
    }


    @PutMapping("/{id}")
    public MovieResponse update(@RequestBody Movie movie, @PathVariable int id) {
        Movie foundMovie = movieService.findById(id);
        foundMovie.setId(id);
        movie.setActors(foundMovie.getActors());
        movieService.save(movie);
        return new MovieResponse(movie.getId(), movie.getName(),
                   movie.getDirectorName(),
                   movie.getRating(), movie.getReleaseDate());
    }

    @DeleteMapping("/{id}")
    public MovieResponse delete(@PathVariable int id) {
        Movie movie = movieService.findById(id);
        movieService.delete(movie);
        return new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                movie.getRating(), movie.getReleaseDate());
    }
}
