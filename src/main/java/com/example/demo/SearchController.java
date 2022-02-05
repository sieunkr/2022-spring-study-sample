package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchController {

    private final MovieApplicationService movieApplicationService;

    @GetMapping("movies")
    public List<MovieDTO> search(@RequestParam(name = "q") String title){

        return movieApplicationService.searchMovie(title);
    }

}