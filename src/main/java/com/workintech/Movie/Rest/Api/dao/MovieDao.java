package com.workintech.Movie.Rest.Api.dao;

import com.workintech.Movie.Rest.Api.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository <Movie, Integer> {
}
