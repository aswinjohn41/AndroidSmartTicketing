package com.example.mybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddComplaintActivity extends AppCompatActivity {

    Spinner spinner_bus;
    EditText edt_date,edt_complaint;
    Button btn_send;

    Integer bus_id,bus_login_id;
    String bus_name;

    SharedPreferences preferences;
    String login_id,login_type;

    String bus_idd,bus_login_idd;
    String str_date,str_complaint;

    ArrayList<HashMap<String,String>> bus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_complaint);

        getSupportActionBar().hide();

        spinner_bus=findViewById(R.id.spinner_bus);
        edt_date=findViewById(R.id.edt_date);
        edt_complaint=findViewById(R.id.edt_complaint);
        btn_send=findViewById(R.id.btn_send);

        GetBusToSpinner();

        preferences=getSharedPreferences("user_login",MODE_PRIVATE);
        login_id=preferences.getString("user_id","");
        login_type=preferences.getString("user_type","");

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str_date=edt_date.getText().toString();
                str_complaint=edt_complaint.getText().toString();

                if (spinner_bus.isSelected())
                {
                    Toast.makeText(AddComplaintActivity.this, "choose a bus!", Toast.LENGTH_SHORT).show();
                }
                else if (str_date.isEmpty())
                {
                    Toast.makeText(AddComplaintActivity.this, "Date is empty!", Toast.LENGTH_SHORT).show();
                }
                else if (str_complaint.isEmpty())
                {
                    Toast.makeText(AddComplaintActivity.this, "Complaint is empty!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    AddComplaint();
                }
            }
        });

        spinner_bus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                bus_idd=((TextView) view.findViewById(R.id.txt_bus_id)).getText().toString();
                bus_login_idd=((TextView) view.findViewById(R.id.txt_bus_login_id)).getText().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void AddComplaint()
    {
        String BASE_URL=getResources().getString(R.string.host);
        String ADD_COMPLAINT=BASE_URL+"addcomplaints.php";

        StringRequest request=new StringRequest(Request.Method.POST, ADD_COMPLAINT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(AddComplaintActivity.this, response, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),ComplaintActivity.class);
                startActivity(intent);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(AddComplaintActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String>params=new HashMap<String, String>();
                params.put("traveler_id",login_id);
                params.put("bus_login_id",bus_login_idd);
                params.put("date",str_date);
                params.put("complaint",str_complaint);
                return params;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }

    private void GetBusToSpinner()
    {
        String BASE_URL=getResources().getString(R.string.host);
        String GET_BUS_SPINNER=BASE_URL+"getbustospinner.php";

        JsonArrayRequest arrayRequest=new JsonArrayRequest(GET_BUS_SPINNER, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                bus=new ArrayList<>();

                for (int i=0;i<response.length();i++)
                {
                    try {

                        JSONObject object=response.getJSONObject(i);
                        bus_id=object.getInt("bus_id");
                        bus_login_id=object.getInt("login_id");
                        bus_name=object.getString("bus_name");

                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("bus_id", bus_id.toString());
                        map.put("bus_login_id",bus_login_id.toString());
                        map.put("bus_name",bus_name);

                        bus.add(map);

                        ListAdapter adapter = new SimpleAdapter(
                                getApplicationContext(), bus,
                                R.layout.spinner_bus, new String[]{"bus_id",
                                "bus_login_id","bus_name"},
                                new int[]{R.id.txt_bus_id, R.id.txt_bus_login_id,R.id.txt_bus_name});

                        spinner_bus.setAdapter((SpinnerAdapter) adapter);



                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(AddComplaintActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }
        );

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(arrayRequest);
    }
}