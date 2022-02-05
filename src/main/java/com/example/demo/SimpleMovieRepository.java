package com.example.demo;

import lombok.Data;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SimpleMovieRepository implements MovieRepository {

    @Override
    public List<Movie> findByTitle(String title) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", "-");
        httpHeaders.add("X-Naver-Client-Secret", "-");
        String url = "https://openapi.naver.com/v1/search/movie.json" + "?query=" + title;
        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseMovie.class)
                .getBody().getItems().stream()
                .map(r -> Movie.builder()
                        .title(r.getTitle())
                        .link(r.getLink())
                        .userRating(r.userRating)
                        .build())
                .collect(Collectors.toList());
    }

    @Data
    static class ResponseMovie implements Serializable {

        private Integer total;
        private List<Item> items;

        @Data
        public static class Item{
            String title;
            String link;
            Float userRating;
        }
    }
}
