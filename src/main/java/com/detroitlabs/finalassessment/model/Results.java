package com.detroitlabs.finalassessment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results extends ArrayList<CharacterDetails> {
}
