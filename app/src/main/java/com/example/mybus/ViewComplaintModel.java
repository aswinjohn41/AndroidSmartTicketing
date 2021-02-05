package com.example.mybus;

import com.android.volley.toolbox.StringRequest;

public class ViewComplaintModel {

    private String traveler_name,bus_name,date,complaint,reply;

    public ViewComplaintModel(String traveler_name, String bus_name, String date, String complaint, String reply) {
        this.traveler_name = traveler_name;
        this.bus_name = bus_name;
        this.date = date;
        this.complaint = complaint;
        this.reply = reply;
    }

    public String getTraveler_name() {
        return traveler_name;
    }

    public void setTraveler_name(String traveler_name) {
        this.traveler_name = traveler_name;
    }

    public String getBus_name() {
        return bus_name;
    }

    public void setBus_name(String bus_name) {
        this.bus_name = bus_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
