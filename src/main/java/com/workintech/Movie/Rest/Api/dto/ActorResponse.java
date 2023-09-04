package com.workintech.Movie.Rest.Api.dto;

import com.workintech.Movie.Rest.Api.entity.Gender;
import com.workintech.Movie.Rest.Api.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorResponse {
    private int actorId;
    private String actorFirstName;
    private String actorLastName;
    private Gender gender;
    private LocalDate actorBirthDate;
}
