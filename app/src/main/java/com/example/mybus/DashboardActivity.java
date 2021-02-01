package com.example.mybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DashboardActivity extends AppCompatActivity {

    ImageView view_bus,logout,profile,complaints,helpline;

    SharedPreferences preferences;

    String login_id,login_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        getSupportActionBar().hide();

        view_bus=findViewById(R.id.view_bus);
        logout=findViewById(R.id.logout);
        profile=findViewById(R.id.profile);
        complaints=findViewById(R.id.complaints);
        helpline=findViewById(R.id.helpline);

        preferences=getSharedPreferences("user_login",MODE_PRIVATE);
        login_id=preferences.getString("user_id","");
        login_type=preferences.getString("user_type","");

        helpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),HelplineActivity.class);
                startActivity(intent);
            }
        });

        complaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ProfileActivity.class);
                startActivity(intent);
            }
        });

        view_bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ViewBusActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor=preferences.edit();
                editor.clear();
                editor.apply();

                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}