package com.detroitlabs.finalassessment.controller;

import com.detroitlabs.finalassessment.model.*;
import com.detroitlabs.finalassessment.service.SWAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class CharacterController {

    @Autowired
    private SWAPIService swapiService;

    @RequestMapping("/")
    public String fetchCharacters(ModelMap modelMap) {
        MovieDetailWrapper movieDetailWrapper = swapiService.fetchMovieDetails();
        ArrayList<String> charactersInMovies = movieDetailWrapper.getCharacters();

        ArrayList<String> characterNames = new ArrayList<>();
        for (String characterUrl : charactersInMovies) {
            characterNames.add(swapiService.fetchCharacterName(characterUrl).getName());
        }

        modelMap.put("characterNames", characterNames);
        return "index";
    }

    @RequestMapping("/characterdetails/{name}")
    public String fetchCharacterDetails(@PathVariable String name, ModelMap modelMap) {
        CharacterDetailsWrapper characterDetailsWrapper = swapiService.fetchCharacterDetails(name);
        Results results = characterDetailsWrapper.getResults();

        for (CharacterDetails planet : results){
            PlanetWrapper planetWrapper = swapiService.fetchPlanetName(planet.getHomeworld());
            planet.setHomeworldName(planetWrapper.getName());
        }

        modelMap.put("results", results);
        return "characterdetails";
    }
}
