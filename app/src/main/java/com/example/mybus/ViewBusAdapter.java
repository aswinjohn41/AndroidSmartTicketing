package com.example.mybus;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class ViewBusAdapter extends ArrayAdapter<ViewBusModel> {

    Context context;
    List<ViewBusModel> arrayListShowBus;

    SharedPreferences preferences;

    String login_id,login_type;

    public ViewBusAdapter(@NonNull Context context, List<ViewBusModel> arrayListShowBus) {
        super(context,R.layout.custom_show_bus ,arrayListShowBus);

            this.context=context;
            this.arrayListShowBus=arrayListShowBus;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_show_bus, null, true);




        TextView tv_busid=view.findViewById(R.id.txt_bus_id);
        TextView tv_busname=view.findViewById(R.id.txt_bus_name);
        TextView tv_bus_startingpoint=view.findViewById(R.id.txt_bus_starting_point);
        TextView tv_bus_endingpoint=view.findViewById(R.id.txt_bus_end_point);
        TextView tv_bus_description=view.findViewById(R.id.txt_bus_description);
        TextView tv_bus_seat=view.findViewById(R.id.txt_bus_seat);
        TextView tv_bus_route=view.findViewById(R.id.txt_bus_route);

        Button btn_book=view.findViewById(R.id.btn_book);

        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences=context.getSharedPreferences("user_login",MODE_PRIVATE);
                login_id=preferences.getString("user_id","");
                login_type=preferences.getString("user_type","");

                

            }
        });


        tv_busid.setText(arrayListShowBus.get(position).getBus_id());
        tv_busname.setText(""+arrayListShowBus.get(position).getBus_name());
        tv_bus_startingpoint.setText("To :"+arrayListShowBus.get(position).getBus_starting_point());
        tv_bus_endingpoint.setText("From :"+arrayListShowBus.get(position).getBus_end_point());
        tv_bus_description.setText(arrayListShowBus.get(position).getBus_description());
        tv_bus_seat.setText("Seats :"+arrayListShowBus.get(position).getBus_seat());
        tv_bus_route.setText("Via :"+arrayListShowBus.get(position).getBus_route());

        return view;
    }
}
