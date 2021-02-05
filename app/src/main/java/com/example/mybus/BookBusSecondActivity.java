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

public class BookBusSecondActivity extends AppCompatActivity {

    EditText edt_source,edt_destination;
    TextView txt_seat_no;
    Button btn_ok;

    String str_seat,str_bus_id,str_traveler_id,str_source,str_destination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_bus_second);

        edt_source=findViewById(R.id.edt_source);
        edt_destination=findViewById(R.id.edt_destination);
        txt_seat_no=findViewById(R.id.txt_seat_no);
        btn_ok=findViewById(R.id.btn_ok);

        Intent intent=getIntent();
        str_seat=intent.getStringExtra("seat");
        str_bus_id=intent.getStringExtra("bus_id");
        str_traveler_id=intent.getStringExtra("login");

        //Toast.makeText(this, str_seat, Toast.LENGTH_SHORT).show();

        txt_seat_no.setText("Seat No :"+str_seat);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str_source=edt_source.getText().toString();
                str_destination=edt_destination.getText().toString();

                if(str_source.isEmpty())
                {
                    Toast.makeText(BookBusSecondActivity.this, "Source is empty!", Toast.LENGTH_SHORT).show();
                }
                else if (str_destination.isEmpty())
                {
                    Toast.makeText(BookBusSecondActivity.this, "Destination is empty!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String BASEURL=getResources().getString(R.string.host);
                    String BOOK_URL=BASEURL+"booking.php";

                    StringRequest request=new StringRequest(Request.Method.POST, BOOK_URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(BookBusSecondActivity.this, response, Toast.LENGTH_SHORT).show();
                            Intent intent1=new Intent(getApplicationContext(),DashboardActivity.class);
                            startActivity(intent1);

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(BookBusSecondActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                    ){

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {

                            Map<String,String>params=new HashMap<String, String>();
                            params.put("seats",str_seat);
                            params.put("bus_id",str_bus_id);
                            params.put("login_id",str_traveler_id);
                            params.put("source",str_source);
                            params.put("destination",str_destination);
                            return params;
                        }
                    };

                    RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(request);
                }
            }
        });



    }
}