package com.example.mybus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ViewComplaintAdapter extends ArrayAdapter<ViewComplaintModel> {

    Context context;
    List<ViewComplaintModel> arrayListComplaint;

    public ViewComplaintAdapter(@NonNull Context context, List<ViewComplaintModel> arrayListComplaint) {
        super(context, R.layout.custom_show_complaint,arrayListComplaint);

        this.context=context;
        this.arrayListComplaint=arrayListComplaint;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_show_complaint, null, true);

        TextView tv_traveler_name=view.findViewById(R.id.txt_traveler_name);
        TextView tv_bus_name=view.findViewById(R.id.txt_bus_name);
        TextView tv_date=view.findViewById(R.id.txt_date);
        TextView tv_complaint=view.findViewById(R.id.txt_complaint);
        TextView tv_reply=view.findViewById(R.id.txt_reply);

        tv_traveler_name.setText(arrayListComplaint.get(position).getTraveler_name());
        tv_bus_name.setText("Name :"+arrayListComplaint.get(position).getBus_name());
        tv_date.setText(arrayListComplaint.get(position).getDate());
        tv_complaint.setText(arrayListComplaint.get(position).getComplaint());
        tv_reply.setText("Reply :"+arrayListComplaint.get(position).getReply());

        return view;
    }
}
