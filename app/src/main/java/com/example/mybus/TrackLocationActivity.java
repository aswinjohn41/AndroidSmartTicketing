package com.example.mybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TrackLocationActivity extends AppCompatActivity {

    ListView show_loc_bus_listview;

    SharedPreferences preferences;

    String login_id,login_type;

    ViewLocBusModel locBusModel;

    ViewLocBusAdapter locBusAdapter;

    public static ArrayList<ViewLocBusModel> showlocBusArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_location);

        show_loc_bus_listview=findViewById(R.id.show_loc_bus_listview);

        getSupportActionBar().hide();

        locBusAdapter=new ViewLocBusAdapter(this,showlocBusArrayList);

        getLocBus();

        preferences=getSharedPreferences("user_login",MODE_PRIVATE);
        login_id=preferences.getString("user_id","");
        login_type=preferences.getString("user_type","");
    }

    private void getLocBus()
    {

        preferences=getSharedPreferences("user_login",MODE_PRIVATE);
        login_id=preferences.getString("user_id","");
        login_type=preferences.getString("user_type","");

        String BASE_URL=getResources().getString(R.string.host);
        String VIEW_LOC_BUS_URL=BASE_URL+"getlocationbuses.php?login="+login_id;

        JsonArrayRequest arrayRequest=new JsonArrayRequest(VIEW_LOC_BUS_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                showlocBusArrayList.clear();

                for (int i=0;i<response.length();i++)
                {
                    try {

                        JSONObject object=response.getJSONObject(i);
                        String bus_id=object.getString("bus_id");
                        String bus_name=object.getString("bus_name");
                        String bus_source=object.getString("source");
                        String bus_destination=object.getString("destination");
                        String bus_date=object.getString("date");
                        String bus_time=object.getString("time");
                        String bus_seat=object.getString("seat");
                        String loc_latitude=object.getString("latitude");
                        String loc_longitude=object.getString("longitude");

                        locBusModel=new ViewLocBusModel(bus_id,bus_name,bus_source,bus_destination,bus_date,bus_time,bus_seat,loc_latitude,loc_longitude);
                        showlocBusArrayList.add(locBusModel);
                        locBusAdapter.notifyDataSetChanged();
                        show_loc_bus_listview.setAdapter(locBusAdapter);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(TrackLocationActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }
        );

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(arrayRequest);

    }
}