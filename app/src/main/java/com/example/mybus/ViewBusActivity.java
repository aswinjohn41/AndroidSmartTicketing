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

public class ViewBusActivity extends AppCompatActivity {

    SharedPreferences preferences;

    String login_id,login_type;

    ListView show_bus_listview;

    ViewBusModel busModel;
    ViewBusAdapter busAdapter;
    public static ArrayList<ViewBusModel> showBusArrayList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bus);

        getSupportActionBar().hide();

        show_bus_listview=findViewById(R.id.show_bus_listview);

        busAdapter=new ViewBusAdapter(this,showBusArrayList);
        getBus();


        preferences=getSharedPreferences("user_login",MODE_PRIVATE);
        login_id=preferences.getString("user_id","");
        login_type=preferences.getString("user_type","");

    }

    private void getBus()
    {
       String BASE_URL=getResources().getString(R.string.host);
       String VIEW_BUS_URL=BASE_URL+"getbuses.php";

        JsonArrayRequest arrayRequest=new JsonArrayRequest(VIEW_BUS_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                showBusArrayList.clear();
               for (int i=0;i<response.length();i++)
               {
                   try {

                       JSONObject object=response.getJSONObject(i);
                       String bus_id=object.getString("bus_id");
                       String bus_name=object.getString("bus_name");
                       String bus_starting_point=object.getString("bus_starting_point");
                       String bus_end_point=object.getString("bus_end_point");
                       String bus_description=object.getString("bus_description");
                       String bus_total_seats=object.getString("bus_total_seats");
                       String bus_route=object.getString("bus_route");

                      busModel=new ViewBusModel(bus_id,bus_name,bus_starting_point,bus_end_point,bus_description,bus_total_seats,bus_route);
                      showBusArrayList.add(busModel);
                      busAdapter.notifyDataSetChanged();
                      show_bus_listview.setAdapter(busAdapter);

                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(ViewBusActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }
        );

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(arrayRequest);
    }
}