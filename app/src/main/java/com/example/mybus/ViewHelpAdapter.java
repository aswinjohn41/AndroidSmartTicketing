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

public class ViewHelpAdapter extends ArrayAdapter<ViewHelpModel> {

    Context context;
    List<ViewHelpModel> arrayListshowHelp;

    public ViewHelpAdapter(@NonNull Context context, List<ViewHelpModel> arrayListshowHelp) {
        super(context,R.layout.custom_show_help ,arrayListshowHelp);

        this.context=context;
        this.arrayListshowHelp=arrayListshowHelp;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_show_help, null, true);
        TextView tv_help=view.findViewById(R.id.txt_help);
        TextView tv_contact=view.findViewById(R.id.txt_contact);


        tv_help.setText(arrayListshowHelp.get(position).getHelp());
        tv_contact.setText(arrayListshowHelp.get(position).getContact());

        return view;
    }
}
