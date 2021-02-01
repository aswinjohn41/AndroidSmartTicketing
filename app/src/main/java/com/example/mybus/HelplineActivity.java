package com.example.mybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class HelplineActivity extends AppCompatActivity {

    SharedPreferences preferences;

    String login_id,login_type;


    ListView show_help_listview;

    ViewHelpModel helpModel;
    ViewHelpAdapter helpAdapter;
    public static ArrayList<ViewHelpModel> showHelpArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);

        getSupportActionBar().hide();

        show_help_listview=findViewById(R.id.show_help_listview);

        helpAdapter=new ViewHelpAdapter(this,showHelpArrayList);

        getHelp();

        preferences=getSharedPreferences("user_login",MODE_PRIVATE);
        login_id=preferences.getString("user_id","");
        login_type=preferences.getString("user_type","");
    }

    private void getHelp()
    {
        String BASE_URL=getResources().getString(R.string.host);
        String HELP_URL=BASE_URL+"help.php";

        JsonArrayRequest arrayRequest=new JsonArrayRequest(HELP_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                showHelpArrayList.clear();
                for (int i=0;i<response.length();i++)
                {
                    try {

                        JSONObject object=response.getJSONObject(i);
                        String help=object.getString("help");
                        String contact=object.getString("contact");

                        helpModel=new ViewHelpModel(help,contact);
                        showHelpArrayList.add(helpModel);
                        helpAdapter.notifyDataSetChanged();
                        show_help_listview.setAdapter(helpAdapter);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(HelplineActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }
        );

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(arrayRequest);
    }
}