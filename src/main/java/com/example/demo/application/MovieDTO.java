package com.example.demo.application;

import com.example.demo.domain.Movie;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieDTO {

    private final String title;
    private final String link;
    private final Float userRating;

    public static MovieDTO of(Movie m) {
        return MovieDTO.builder()
                .title(m.getTitle())
                .link(m.getLink())
                .userRating(m.getUserRating())
                .build();
    }
}