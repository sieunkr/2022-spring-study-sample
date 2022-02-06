package com.example.demo.domain;

import lombok.*;

@Getter
@Builder
public class Movie {

    private String title;
    private String link;
    private Float userRating;

    public void changeTitle(String title) {
        this.title = title;
    }


}
