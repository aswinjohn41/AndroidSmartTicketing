package com.example.mybus;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ViewLocBusAdapter extends ArrayAdapter<ViewLocBusModel> {

    Context context;
    List<ViewLocBusModel> arrayListLocBus;
    public ViewLocBusAdapter(@NonNull Context context, List<ViewLocBusModel> arrayListLocBus) {
        super(context, R.layout.custom_loc_show_bus,arrayListLocBus);

        this.context=context;
        this.arrayListLocBus=arrayListLocBus;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_loc_show_bus, null, true);

        TextView tv_loc_bus_id=view.findViewById(R.id.txt_loc_bus_id);
        TextView tv_loc_bus_name=view.findViewById(R.id.txt_loc_bus_name);
        TextView tv_loc_bus_source=view.findViewById(R.id.txt_loc_bus_source);
        TextView tv_loc_bus_destination=view.findViewById(R.id.txt_loc_bus_destination);
        TextView tv_loc__bus_date=view.findViewById(R.id.txt_loc_bus_date);
        TextView tv_loc_bus_time=view.findViewById(R.id.txt_loc_bus_time);
        TextView tv_loc_bus_seat=view.findViewById(R.id.txt_loc_bus_seat);
        TextView tv_loc_bus_latitude=view.findViewById(R.id.txt_loc_bus_latitude);
        TextView tv_loc_bus_longitude=view.findViewById(R.id.txt_loc_bus_longitude);
        Button btn_loc_bus=view.findViewById(R.id.btn_track);

        btn_loc_bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String map_latitude=tv_loc_bus_latitude.getText().toString();
                String map_longitude=tv_loc_bus_longitude.getText().toString();

                Intent intent=new Intent(getContext(),MapActivity.class);
                intent.putExtra("map_latitude",map_latitude);
                intent.putExtra("map_longitude",map_longitude);
                context.startActivity(intent);
            }
        });


        tv_loc_bus_id.setText(arrayListLocBus.get(position).getBus_id());
        tv_loc_bus_name.setText(arrayListLocBus.get(position).getBus_name());
        tv_loc_bus_source.setText("From :"+arrayListLocBus.get(position).getBus_source());
        tv_loc_bus_destination.setText("To :"+arrayListLocBus.get(position).getBus_destination());
        tv_loc__bus_date.setText("Date :"+arrayListLocBus.get(position).getBus_date());
        tv_loc_bus_time.setText("Time :"+arrayListLocBus.get(position).getBus_time());
        tv_loc_bus_seat.setText("Seat no :"+arrayListLocBus.get(position).getBus_seat());
        tv_loc_bus_latitude.setText(arrayListLocBus.get(position).getBus_latitude());
        tv_loc_bus_longitude.setText(arrayListLocBus.get(position).getBus_longitude());

        return view;
    }
}
