package com.detroitlabs.finalassessment.controller;

import com.detroitlabs.finalassessment.model.Characters;
import com.detroitlabs.finalassessment.model.MovieDetailWrapper;
import com.detroitlabs.finalassessment.service.SWAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class CharacterController {

    @Autowired
    private SWAPIService swapiService;

    @RequestMapping("/")
    public String fetchCharacters(ModelMap modelMap) {
        MovieDetailWrapper movieDetailWrapper = swapiService.fetchMovieDetails();
        ArrayList<String> temp = movieDetailWrapper.getCharacters();

        for (String character: temp){
            System.out.println(character);
        }
        return "index";
    }
}
