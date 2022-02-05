package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class MovieApplicationServiceTest {

    /*TODO:
        1.평점이 높은 순서로 정렬
        2.평점이 0 인 경우 제외
     */

    private MovieApplicationService movieApplicationService;

    @Mock
    private SimpleMovieRepository movieRepository;

    @Test
    @DisplayName("평점 순으로 정렬이 잘 되는지")
    void arranged_well_in_user_ratings() {

        //given
        float expectedUserRanking = 9.7f;
        Mockito.when(movieRepository.findByTitle(any())).thenReturn(getStubMovieList());
        movieApplicationService = new MovieApplicationService(movieRepository);

        //when
        List<MovieDTO> actualList = movieApplicationService.searchMovie("쿼리");

        //then
        assertEquals(expectedUserRanking, actualList.stream().findFirst().get().getUserRating());

    }

    @Test
    @DisplayName("평점이 0인 데이터는 제외하는지")
    void user_ratings_exclude_zero() {

        //given
        int expectedMovieSize = 3;
        Mockito.when(movieRepository.findByTitle(any())).thenReturn(getStubMovieList());
        movieApplicationService = new MovieApplicationService(movieRepository);

        //when
        List<MovieDTO> actualList = movieApplicationService.searchMovie("쿼리");

        //then
        assertEquals(expectedMovieSize, actualList.size());

    }


    private List<Movie> getStubMovieList() {

        return Arrays.asList(
                Movie.builder().title("<b>영화1</b> 제목").userRating(9.3f).build(),
                Movie.builder().title("<b>영화2</b> 제목").userRating(9.7f).build(),
                Movie.builder().title("<b>영화3</b> 제목").userRating(0.0f).build(),
                Movie.builder().title("<b>영화4</b> 제목").userRating(7.5f).build()
        );
    }

}