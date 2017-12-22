package com.example.agarw.earthipidea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Earthquake> earthquakeList = new ArrayList<>();
    private RecyclerView recyclerView;
    private EarthquakeAdapter mAdapter;



    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String url = "https://earthquake-report.com/feeds/recent-eq?json";
    private static final String TAG = MainActivity.class.getName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new EarthquakeAdapter(earthquakeList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mRequestQueue = Volley.newRequestQueue(this);


        JsonArrayRequest earth = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        Earthquake earthquake = new Earthquake();
                        earthquake.setTitle(obj.getString("title"));
                        earthquake.setDepth(obj.getString("depth"));
                        earthquake.setDate_time(obj.getString("date_time"));
                        earthquake.setLocation(obj.getString("location"));
                        earthquake.setLatitude(obj.getString("latitude"));
                        earthquake.setMagnitude(obj.getString("magnitude"));
                        earthquake.setLongitude(obj.getString("longitude"));
                        earthquakeList.add(earthquake);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                mAdapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }

    });

        mRequestQueue.add(earth);



    }






}
