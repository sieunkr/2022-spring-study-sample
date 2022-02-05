package com.example.demo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Movie {

    private final String title;
    private final String link;
    private final Float userRating;

    

}
