package com.example.mybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DashboardActivity extends AppCompatActivity {

    ImageView view_bus,logout;

    SharedPreferences preferences;

    String login_id,login_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        getSupportActionBar().hide();

        view_bus=findViewById(R.id.view_bus);
        logout=findViewById(R.id.logout);

        preferences=getSharedPreferences("user_login",MODE_PRIVATE);
        login_id=preferences.getString("user_id","");
        login_type=preferences.getString("user_type","");

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