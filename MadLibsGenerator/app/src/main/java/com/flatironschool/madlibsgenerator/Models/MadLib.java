package com.flatironschool.madlibsgenerator.Models;

import java.util.List;

/**
 * Created by altyus on 9/19/14.
 */
public class MadLib {
    public List<String> places;
    public List<String> people;
    public List<String> verbs;
    public List<String> adjectives;

    public MadLib(List<String> places,
                  List<String> people,
                  List<String> verbs,
                  List<String> adjectives){
        this.places = places;
        this.people = people;
        this.verbs = verbs;
        this.adjectives = adjectives;
    }

    public List<String> getPlaces() {
        return places;
    }

    public List<String> getPeople() {
        return people;
    }

    public List<String> getVerbs() {
        return verbs;
    }

    public List<String> getAdjectives() {
        return adjectives;
    }
}
