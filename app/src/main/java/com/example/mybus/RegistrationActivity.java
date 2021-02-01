package com.example.mybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {

    EditText edt_name,edt_address,edt_email,edt_mobile,edt_username,edt_password;
    Button btn_register;
    TextView login_link;

    String str_name,str_address,str_email,str_mobile,str_username,str_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        getSupportActionBar().hide();

        edt_name=findViewById(R.id.edt_name);
        edt_address=findViewById(R.id.edt_address);
        edt_email=findViewById(R.id.edt_email);
        edt_mobile=findViewById(R.id.edt_mobile);
        edt_username=findViewById(R.id.edt_username);
        edt_password=findViewById(R.id.edt_password);

        btn_register=findViewById(R.id.btn_register);

        login_link=findViewById(R.id.login_link);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                str_name=edt_name.getText().toString().trim();
                str_address=edt_address.getText().toString().trim();
                str_mobile=edt_mobile.getText().toString().trim();
                str_email=edt_email.getText().toString().trim();
                str_username=edt_username.getText().toString().trim();
                str_password=edt_password.getText().toString().trim();

                if (str_name.isEmpty())
                {
                    Toast.makeText(RegistrationActivity.this, "name is empty!", Toast.LENGTH_SHORT).show();
                }
                else if (str_address.isEmpty())
                {
                    Toast.makeText(RegistrationActivity.this, "address is empty!", Toast.LENGTH_SHORT).show();
                }
                else if (str_email.isEmpty() && !str_email.matches(emailPattern))
                {
                    Toast.makeText(RegistrationActivity.this, "email is empty!", Toast.LENGTH_SHORT).show();
                }
                else if (str_mobile.isEmpty())
                {
                    Toast.makeText(RegistrationActivity.this, "mobile is empty!", Toast.LENGTH_SHORT).show();
                }
                else if (str_username.isEmpty())
                {
                    Toast.makeText(RegistrationActivity.this, "username is empty!", Toast.LENGTH_SHORT).show();
                }
                else if (str_password.isEmpty())
                {
                    Toast.makeText(RegistrationActivity.this, "password is empty!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String BASE_URL=getResources().getString(R.string.host);
                    String REG_URL=BASE_URL+"registration.php";

                    StringRequest request=new StringRequest(Request.Method.POST, REG_URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(RegistrationActivity.this, response, Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                            startActivity(intent);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(RegistrationActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                    )
                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {

                            Map<String,String>params=new HashMap<String, String>();
                            params.put("name",str_name);
                            params.put("address",str_address);
                            params.put("email",str_email);
                            params.put("mobile",str_mobile);
                            params.put("username",str_username);
                            params.put("password",str_password);
                            return params;
                        }
                    };

                    RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(request);

                }
            }
        });

        login_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}