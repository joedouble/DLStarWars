package com.detroitlabs.finalassessment.service;

import com.detroitlabs.finalassessment.model.MovieDetailWrapper;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class SWAPIService {
    public MovieDetailWrapper fetchMovieDetails() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "spring");

        HttpEntity entity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<MovieDetailWrapper> response = restTemplate.exchange("https://swapi.co/api/films/2", HttpMethod.GET,
                entity, MovieDetailWrapper.class);
        return response.getBody();
    }
}
