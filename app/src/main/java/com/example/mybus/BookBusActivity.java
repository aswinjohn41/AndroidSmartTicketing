package com.example.mybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class BookBusActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;

    SharedPreferences preferences;

    String login_id,login_type;

    String bus_id,traveler_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_bus);

        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
        b10=findViewById(R.id.b10);
        b11=findViewById(R.id.b11);
        b12=findViewById(R.id.b12);
        b13=findViewById(R.id.b13);
        b14=findViewById(R.id.b14);
        b15=findViewById(R.id.b15);

        getSupportActionBar().hide();

        preferences=getSharedPreferences("user_login",MODE_PRIVATE);
        login_id=preferences.getString("user_id","");
        login_type=preferences.getString("user_type","");

        Intent intent=getIntent();
        bus_id=intent.getStringExtra("bus_id");
        //traveler_id=intent.getStringExtra("traveler_id");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getSeat("1");

               /* Intent i=new Intent(getApplicationContext(),BookBusSecondActivity.class);
                i.putExtra("seat","1");
                i.putExtra("bus_id",bus_id);
                i.putExtra("login",login_id);
                startActivity(i);*/
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getSeat("2");
               /* Intent i=new Intent(getApplicationContext(),BookBusSecondActivity.class);
                i.putExtra("seat","2");
                i.putExtra("bus_id",bus_id);
                i.putExtra("login",login_id);
                startActivity(i);*/
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),BookBusSecondActivity.class);
                i.putExtra("seat","3");
                i.putExtra("bus_id",bus_id);
                i.putExtra("login",login_id);
                startActivity(i);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),BookBusSecondActivity.class);
                i.putExtra("seat","4");
                i.putExtra("bus_id",bus_id);
                i.putExtra("login",login_id);
                startActivity(i);
            }
        });


        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),BookBusSecondActivity.class);
                i.putExtra("seat","5");
                i.putExtra("bus_id",bus_id);
                i.putExtra("login",login_id);
                startActivity(i);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),BookBusSecondActivity.class);
                i.putExtra("seat","6");
                i.putExtra("bus_id",bus_id);
                i.putExtra("login",login_id);
                startActivity(i);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),BookBusSecondActivity.class);
                i.putExtra("seat","7");
                i.putExtra("bus_id",bus_id);
                i.putExtra("login",login_id);
                startActivity(i);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),BookBusSecondActivity.class);
                i.putExtra("seat","8");
                i.putExtra("bus_id",bus_id);
                i.putExtra("login",login_id);
                startActivity(i);
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),BookBusSecondActivity.class);
                i.putExtra("seat","9");
                i.putExtra("bus_id",bus_id);
                i.putExtra("login",login_id);
                startActivity(i);
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),BookBusSecondActivity.class);
                i.putExtra("seat","10");
                i.putExtra("bus_id",bus_id);
                i.putExtra("login",login_id);
                startActivity(i);
            }
        });

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),BookBusSecondActivity.class);
                i.putExtra("seat","11");
                i.putExtra("bus_id",bus_id);
                i.putExtra("login",login_id);
                startActivity(i);
            }
        });

        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),BookBusSecondActivity.class);
                i.putExtra("seat","12");
                i.putExtra("bus_id",bus_id);
                i.putExtra("login",login_id);
                startActivity(i);
            }
        });

        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),BookBusSecondActivity.class);
                i.putExtra("seat","13");
                i.putExtra("bus_id",bus_id);
                i.putExtra("login",login_id);
                startActivity(i);
            }
        });

        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),BookBusSecondActivity.class);
                i.putExtra("seat","14");
                i.putExtra("bus_id",bus_id);
                i.putExtra("login",login_id);
                startActivity(i);
            }
        });

        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),BookBusSecondActivity.class);
                i.putExtra("seat","15");
                i.putExtra("bus_id",bus_id);
                i.putExtra("login",login_id);
                startActivity(i);
            }
        });
    }

    private void getSeat(String seat_id)
    {
        String BASEURL=getResources().getString(R.string.host);
        String BOOK_URL=BASEURL+"bookingChecking.php?seats="+seat_id +"&bus_id="+bus_id;

        Log.e("url",BOOK_URL);

        StringRequest request=new StringRequest(Request.Method.GET, BOOK_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("res",response);


                if(response.equals("success"))
                {
                    Toast.makeText(BookBusActivity.this, "Already Booked", Toast.LENGTH_SHORT).show();
                }
                else {


                    Intent intent = new Intent(getApplicationContext(), BookBusSecondActivity.class);
                    intent.putExtra("seat", seat_id);
                    intent.putExtra("bus_id", bus_id);
                    intent.putExtra("login", login_id);
                    startActivity(intent);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(BookBusActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }
        );


        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }
}