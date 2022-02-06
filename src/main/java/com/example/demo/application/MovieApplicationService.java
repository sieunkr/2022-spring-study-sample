package com.example.demo.application;

import com.example.demo.domain.Movie;
import com.example.demo.domain.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieApplicationService {

    private final MovieRepository movieRepository;

    public List<MovieDTO> searchMovie(final String title) {

        return movieRepository.findByTitle(title).stream()
                .filter(movie -> movie.getUserRating() != 0.0f)
                .sorted(Comparator.comparing(Movie::getUserRating).reversed())
                .map(MovieDTO::of)
                .collect(Collectors.toList());
    }
}