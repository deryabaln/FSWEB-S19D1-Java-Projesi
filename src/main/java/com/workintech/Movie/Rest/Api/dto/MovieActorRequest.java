package com.workintech.Movie.Rest.Api.dto;

import com.workintech.Movie.Rest.Api.entity.Actor;
import com.workintech.Movie.Rest.Api.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MovieActorRequest {
    private Actor actor;
    private Movie movie;
}
