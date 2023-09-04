package com.workintech.Movie.Rest.Api.service;

import com.workintech.Movie.Rest.Api.dao.ActorDao;
import com.workintech.Movie.Rest.Api.dao.MovieDao;
import com.workintech.Movie.Rest.Api.entity.Actor;
import com.workintech.Movie.Rest.Api.entity.Movie;
import com.workintech.Movie.Rest.Api.exeptions.MovieException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MovieServiceImpl implements MovieService{
    private MovieDao movieDao;

    @Autowired
    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> find() {
        return movieDao.findAll();
    }

    @Override
    public Movie findById(int id) {
        Optional<Movie> optionalMovie = movieDao.findById(id);
        if(optionalMovie.isPresent()){
            return optionalMovie.get();
        }
        throw new MovieException("Movie with given id is not exist: " + id, HttpStatus.BAD_REQUEST);
    }

    @Override
    public Movie save(Movie movie) {
        return movieDao.save(movie);
    }

    @Override
    public void delete(Movie movie) {
        movieDao.delete(movie);
    }
}