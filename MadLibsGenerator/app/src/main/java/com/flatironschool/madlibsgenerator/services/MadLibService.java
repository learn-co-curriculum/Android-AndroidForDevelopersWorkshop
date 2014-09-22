package com.flatironschool.madlibsgenerator.services;

import com.flatironschool.madlibsgenerator.Models.MadLib;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by altyus on 9/19/14.
 */
public class MadLibService {

    //private static final String API_URL = "http://192.168.56.1:80/";
    private static final String API_URL = "http://intense-fjord-5112.herokuapp.com:80/";

    public interface LibsService {
        @FormUrlEncoded
        @POST("/api/v1/madlibs")
        public void getStoryAsync(
                @Field("places") List<String> places,
                @Field("people") List<String> people,
                @Field("verbs") List<String> verbs,
                @Field("adjectives") List<String> adjectives
                , Callback<String> callback);
    }

    public void loadStory(MadLib madLib, Callback<String>callback) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();
        LibsService service = restAdapter.create(LibsService.class);
        service.getStoryAsync(madLib.getPlaces(),
                madLib.getPeople(),
                madLib.getVerbs(),
                madLib.getAdjectives(),
                callback);
    }
}
