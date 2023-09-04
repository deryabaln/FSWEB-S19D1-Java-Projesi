package com.workintech.Movie.Rest.Api.service;

import com.workintech.Movie.Rest.Api.entity.Actor;
import com.workintech.Movie.Rest.Api.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> find();
    Movie findById(int id);
    Movie save(Movie movie);
    void delete(Movie movie);
}
