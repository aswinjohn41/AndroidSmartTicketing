package com.example.mybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView icon;
    TextView icon_name;

    SharedPreferences preferences;

    String login_id,login_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences=getSharedPreferences("user_login",MODE_PRIVATE);
        login_id=preferences.getString("user_id","");
        login_type=preferences.getString("user_type","");

        getSupportActionBar().hide();

        icon=findViewById(R.id.icon);
        icon_name=findViewById(R.id.icon_name);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (login_type.equals("1"))
                {
                    Intent intent=new Intent(getApplicationContext(),DashboardActivity.class);
                    startActivity(intent);
                }
                else
                    {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }

            }
        },5000);
    }
}