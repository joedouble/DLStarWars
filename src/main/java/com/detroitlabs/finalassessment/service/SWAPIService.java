package com.detroitlabs.finalassessment.service;

import com.detroitlabs.finalassessment.model.CharacterDetailsWrapper;
import com.detroitlabs.finalassessment.model.CharacterWrapper;
import com.detroitlabs.finalassessment.model.MovieDetailWrapper;
import com.detroitlabs.finalassessment.model.PlanetWrapper;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class SWAPIService {
    public MovieDetailWrapper fetchMovieDetails() {

        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "spring");

        HttpEntity entity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<MovieDetailWrapper> response = restTemplate.exchange("https://swapi.co/api/films/2", HttpMethod.GET,
                entity, MovieDetailWrapper.class);
        return response.getBody();
    }

    public CharacterWrapper fetchCharacterName(String characterUrl) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "spring");

        HttpEntity entity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CharacterWrapper> response = restTemplate.exchange(characterUrl, HttpMethod.GET,
                entity, CharacterWrapper.class);
        return response.getBody();
    }

    public CharacterDetailsWrapper fetchCharacterDetails(String name) {

        name = name.replace(' ', '+');

        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "spring");

        HttpEntity entity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CharacterDetailsWrapper> response = restTemplate.exchange("https://swapi.co/api/people/?search=" + name, HttpMethod.GET,
                entity, CharacterDetailsWrapper.class);
        return response.getBody();
    }

    public PlanetWrapper fetchPlanetName(String planetUrl) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "spring");

        HttpEntity entity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<PlanetWrapper> response = restTemplate.exchange(planetUrl, HttpMethod.GET,
                entity, PlanetWrapper.class);
        return response.getBody();
    }

}
