package com.workintech.Movie.Rest.Api.dao;

import com.workintech.Movie.Rest.Api.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorDao extends JpaRepository<Actor, Integer> {

}
