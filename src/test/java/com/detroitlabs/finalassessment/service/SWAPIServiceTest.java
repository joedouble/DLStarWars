package com.detroitlabs.finalassessment.service;

import com.detroitlabs.finalassessment.model.MovieDetailWrapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SWAPIServiceTest {

    private SWAPIService swapiServiceTest;

    @Before
    public void create() {
        swapiServiceTest = new SWAPIService();
    }

    @Test
    public void testFor200ResponseCode() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "spring");

        HttpEntity entity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<MovieDetailWrapper> response = restTemplate.exchange("https://swapi.co/api/films/2",
                HttpMethod.GET,
                entity, MovieDetailWrapper.class);

        Assert.assertEquals(200, response.getStatusCodeValue());
    }


    @Test
    public void testGettingCharacterName() {
        String name = swapiServiceTest.fetchCharacterName("https://swapi.co/api/people/1/").getName();
        Assert.assertEquals("Luke Skywalker", name);
    }

    @Test
    public void testGettingCharacterBirthYear() {
        String characterDetails =
                swapiServiceTest.fetchCharacterDetails("Luke Skywalker").getResults().get(0).getBirthYear();
        Assert.assertEquals("19BBY", characterDetails);
    }

    @Test
    public void fetchPlanetName() {
        String planetName = swapiServiceTest.fetchHomeworldName("https://swapi.co/api/planets/14/").getName();
        Assert.assertEquals("Kashyyyk", planetName);
    }
}