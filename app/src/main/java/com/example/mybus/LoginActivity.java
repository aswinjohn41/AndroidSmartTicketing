package com.example.mybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText edt_user,edt_pass;
    TextView register_link;
    Button btn_login;

    String str_user,str_pass;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferences=getSharedPreferences("user_login",MODE_PRIVATE);

        getSupportActionBar().hide();

        edt_user=findViewById(R.id.edt_user);
        edt_pass=findViewById(R.id.edt_pass);
        register_link=findViewById(R.id.register_link);
        btn_login=findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str_user=edt_user.getText().toString().trim();
                str_pass=edt_pass.getText().toString().trim();

                if(str_user.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "username is empty!", Toast.LENGTH_SHORT).show();
                }
                else if (str_pass.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "password is empty!", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    Map<String,String> parms=new HashMap<String, String>();
                    parms.put("username",str_user);
                    parms.put("password",str_pass);

                    JSONObject parameters= new JSONObject(parms);

                    String BASE_URL=getResources().getString(R.string.host);
                    String LOGIN_URL=BASE_URL+"login.php";

                    JsonObjectRequest objectRequest=new JsonObjectRequest(Request.Method.POST, LOGIN_URL, parameters, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            Log.e("res", String.valueOf(response));

                            try {

                               int success=response.getInt("success");

                               if (success==1)
                               {
                                   String login_id=response.getJSONObject("data").getString("login_id");
                                   String login_type=response.getJSONObject("data").getString("type");



                                   SharedPreferences.Editor editor=preferences.edit();
                                   editor.putString("user_id",login_id);
                                   editor.putString("user_type",login_type);
                                   editor.commit();


                                   if (login_type.equals("1"))
                                   {
                                       Intent intent=new Intent(getApplicationContext(),DashboardActivity.class);
                                       startActivity(intent);
                                   }
                                   else if(login_type.equals("2"))
                                   {
                                       Intent intent=new Intent(getApplicationContext(),BusActivity.class);
                                       startActivity(intent);
                                   }
                                   else
                                   {
                                       Toast.makeText(LoginActivity.this, "No Access", Toast.LENGTH_SHORT).show();
                                   }

                               }
                               else
                               {
                                   Toast.makeText(LoginActivity.this, "Login unsuccesfull", Toast.LENGTH_SHORT).show();
                               }


                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                    );

                    RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(objectRequest);

                }
            }
        });

        register_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}