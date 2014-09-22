package com.flatironschool.madlibsgenerator;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        final MadLibService service = new MadLibService();

        final Button button = (Button) findViewById(R.id.button);

        final EditText place1 = (EditText) findViewById(R.id.place1);

        final EditText adjective1 = (EditText) findViewById(R.id.adjective1);
        final EditText adjective2 = (EditText) findViewById(R.id.adjective2);
        final EditText adjective3 = (EditText) findViewById(R.id.adjective3);
        final EditText adjective4 = (EditText) findViewById(R.id.adjective4);
        final EditText adjective5 = (EditText) findViewById(R.id.adjective5);

        final EditText verb1 = (EditText) findViewById(R.id.verb1);
        final EditText verb2 = (EditText) findViewById(R.id.verb2);

        final EditText person1 = (EditText) findViewById(R.id.person1);
        final EditText person2 = (EditText) findViewById(R.id.person2);
        final EditText person3 = (EditText) findViewById(R.id.person3);
        final EditText person4 = (EditText) findViewById(R.id.person4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                final ProgressDialog dialog = new ProgressDialog(getApplicationContext());
//                dialog.setMessage("Loading....");
//
//                dialog.show();

                List<String>places = new ArrayList<String>();
                places.add(place1.getText().toString());

                List<String>people = new ArrayList<String>();
                people.add(person1.getText().toString());
                people.add(person2.getText().toString());
                people.add(person3.getText().toString());
                people.add(person4.getText().toString());

                List<String>verbs = new ArrayList<String>();
                verbs.add(verb1.getText().toString());
                verbs.add(verb2.getText().toString());

                List<String>adjectives = new ArrayList<String>();
                adjectives.add(adjective1.getText().toString());
                adjectives.add(adjective2.getText().toString());
                adjectives.add(adjective3.getText().toString());
                adjectives.add(adjective4.getText().toString());
                adjectives.add(adjective5.getText().toString());

                final MadLib madLib = new MadLib(places, people, verbs, adjectives);

                service.loadStory(madLib, new Callback<String>() {
                    @Override
                    public void success(String object, retrofit.client.Response response) {
                        Log.d(getLocalClassName(), response.toString());
                        //dialog.hide();

                        Intent intent = new Intent(MadLibActivity.this, MadLibStoryActivity.class);
                        intent.putExtra("story", object);

                        startActivity(intent);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.d(getLocalClassName(), error.getLocalizedMessage());
                       //
                       // dialog.hide();
                    }
                });
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
