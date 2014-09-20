package com.flatironschool.madlibsgenerator;

import android.app.Activity;
import android.app.ProgressDialog;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.flatironschool.madlibsgenerator.Models.MadLib;
import com.flatironschool.madlibsgenerator.services.AppController;
import com.flatironschool.madlibsgenerator.services.MadLibService;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;


public class MadLibActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_lib);

        //String tag_json_obj = "json_obj_req";

        String url = "http://localhost:8080/api/v1/madlibs";
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Loading....");

        dialog.show();

        MadLibService service = new MadLibService();

        List<String> places = new ArrayList<String>();
        places.add("Chicago");
        places.add("Detroit");
        places.add("Washington");
        places.add("New York");
        places.add("San Francisco");

        List<String> people = new ArrayList<String>();
        people.add("George Washington");
        people.add("Barack Obama");
        people.add("Samuel L. Jackson");
        people.add("Drake");
        people.add("Chris Gonzalez");

        List<String> verbs = new ArrayList<String>();
        verbs.add("run");
        verbs.add("jump");
        verbs.add("toss");
        verbs.add("play");
        verbs.add("think");

        List<String> adjectives = new ArrayList<String>();
        adjectives.add("pretty");
        adjectives.add("tall");
        adjectives.add("perfect");
        adjectives.add("competitive");
        adjectives.add("complete");

        MadLib madLib = new MadLib(places, people, verbs, adjectives);

        service.loadStory(madLib, new Callback<String>() {
            @Override
            public void success(String s, retrofit.client.Response response) {
                Log.d(getLocalClassName(), response.toString());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(getLocalClassName(), error.getLocalizedMessage()); 
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mad_lib, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
