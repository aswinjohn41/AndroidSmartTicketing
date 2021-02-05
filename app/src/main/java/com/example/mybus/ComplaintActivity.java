package com.example.mybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ComplaintActivity extends AppCompatActivity {

    ListView show_complaint_listview;
    ImageView img_add;

    SharedPreferences preferences;

    String login_id,login_type;

    ViewComplaintModel complaintModel;
    ViewComplaintAdapter complaintAdapter;
    public static ArrayList<ViewComplaintModel> showComplaintArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);

        getSupportActionBar().hide();

        complaintAdapter=new ViewComplaintAdapter(this,showComplaintArrayList);

        getComplaint();

        show_complaint_listview=findViewById(R.id.show_complaint_listview);
        img_add=findViewById(R.id.img_add);

        preferences=getSharedPreferences("user_login",MODE_PRIVATE);
        login_id=preferences.getString("user_id","");
        login_type=preferences.getString("user_type","");

        img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),AddComplaintActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getComplaint()
    {
        preferences=getSharedPreferences("user_login",MODE_PRIVATE);
        login_id=preferences.getString("user_id","");
        login_type=preferences.getString("user_type","");

        String BASE_URL=getResources().getString(R.string.host);
        String VIEW_COMPLAINT_URL=BASE_URL+"getcomplaint.php?traveler_id="+login_id;

        JsonArrayRequest arrayRequest=new JsonArrayRequest(VIEW_COMPLAINT_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                showComplaintArrayList.clear();
                for (int i=0;i<response.length();i++)
                {
                    try {
                        JSONObject object=response.getJSONObject(i);
                        String bus_name=object.getString("bus_name");
                        String traveler_name=object.getString("name");
                        String date=object.getString("date");
                        String complaint=object.getString("complaint");
                        String reply=object.getString("reply");

                        complaintModel=new ViewComplaintModel(bus_name,traveler_name,date,complaint,reply);
                        showComplaintArrayList.add(complaintModel);
                        complaintAdapter.notifyDataSetChanged();
                        show_complaint_listview.setAdapter(complaintAdapter);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(ComplaintActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }
        );

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(arrayRequest);
    }
}