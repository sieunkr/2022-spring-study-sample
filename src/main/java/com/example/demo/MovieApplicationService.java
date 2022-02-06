package com.example.demo;

import com.example.demo.domain.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieApplicationService {

    private final MovieRepository movieRepository;

    public List<MovieDTO> searchMovie(final String title) {
        return movieRepository.findByTitle(title).stream()
                .map(MovieDTO::of)
                .collect(Collectors.toList());

        /*TODO:
            1.평점이 높은 순서로 정렬
            2.평점이 0 인 경우 제외
         */
    }
}