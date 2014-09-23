package com.flatironschool.madlibsgenerator.Models;

import java.util.List;

/**
 * Created by altyus on 9/19/14.
 */
public class MadLib {
    public List<String> mPlaces;
    public List<String> mPeople;
    public List<String> mVerbs;
    public List<String> mAdjectives;

    public MadLib(List<String> places,
                  List<String> people,
                  List<String> verbs,
                  List<String> adjectives){
        mPlaces = places;
        mPeople = people;
        mVerbs = verbs;
        mAdjectives = adjectives;
    }

    public List<String> getPlaces() {
        return mPlaces;
    }

    public List<String> getPeople() {
        return mPeople;
    }

    public List<String> getVerbs() {
        return mVerbs;
    }

    public List<String> getAdjectives() {
        return mAdjectives;
    }
}
