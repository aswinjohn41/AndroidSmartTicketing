package com.example.mybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {

    TextView txt_name,txt_address,txt_contact,txt_email;

    SharedPreferences preferences;

    String login_id,login_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().hide();

        preferences=getSharedPreferences("user_login",MODE_PRIVATE);
        login_id=preferences.getString("user_id","");
        login_type=preferences.getString("user_type","");

        //Toast.makeText(this, login_id, Toast.LENGTH_SHORT).show();

        txt_name=findViewById(R.id.txt_name);
        txt_address=findViewById(R.id.txt_address);
        txt_contact=findViewById(R.id.txt_contact);
        txt_email=findViewById(R.id.txt_email);


        String BASE_URL=getResources().getString(R.string.host);
        String PROFILE_URL=BASE_URL+"profile.php?log_id="+login_id;

        //Toast.makeText(this, PROFILE_URL, Toast.LENGTH_SHORT).show();

    JsonObjectRequest objectRequest=new JsonObjectRequest(Request.Method.GET, PROFILE_URL, null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {

           Log.e("res", String.valueOf(response));

          try {

              String name=response.getString("name");
              String address=response.getString("address");
              String contact=response.getString("contact");
              String email=response.getString("email");


              txt_name.setText(name);
              txt_address.setText(address);
              txt_contact.setText(contact);
              txt_email.setText(email);

          } catch (Exception e) {
              e.printStackTrace();
          }

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    }
    );

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(objectRequest);


    }
}