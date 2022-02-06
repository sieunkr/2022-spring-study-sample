package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateConfig {

    @Bean //싱글톤...
    public RestTemplate naverOpenApiRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        //TODO: 기타 설정 추가해주면 됨



        //restTemplate.set..
        return restTemplate;
    }
}