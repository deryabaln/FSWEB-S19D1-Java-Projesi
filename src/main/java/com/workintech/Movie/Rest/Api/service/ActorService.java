package com.workintech.Movie.Rest.Api.service;

import com.workintech.Movie.Rest.Api.entity.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> find();
    Actor findById(int id);
    Actor save(Actor actor);
    void delete(Actor actor);
}
