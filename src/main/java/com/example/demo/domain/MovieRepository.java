package com.example.demo.domain;

import com.example.demo.domain.Movie;

import java.util.List;

public interface MovieRepository {

    List<Movie> findByTitle(String title);

}
