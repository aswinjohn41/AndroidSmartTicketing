package com.example.mybus;

import com.android.volley.toolbox.StringRequest;

public class ViewLocBusModel {

    private String bus_id,bus_name,bus_source,bus_destination,bus_date,bus_time,bus_seat,bus_latitude,bus_longitude;

    public ViewLocBusModel(String bus_id, String bus_name, String bus_source, String bus_destination, String bus_date, String bus_time, String bus_seat,String bus_latitude,String bus_longitude) {
        this.bus_id = bus_id;
        this.bus_name = bus_name;
        this.bus_source = bus_source;
        this.bus_destination = bus_destination;
        this.bus_date = bus_date;
        this.bus_time = bus_time;
        this.bus_seat = bus_seat;
        this.bus_latitude=bus_latitude;
        this.bus_longitude=bus_longitude;
    }

    public String getBus_latitude() {
        return bus_latitude;
    }

    public void setBus_latitude(String bus_latitude) {
        this.bus_latitude = bus_latitude;
    }

    public String getBus_longitude() {
        return bus_longitude;
    }

    public void setBus_longitude(String bus_longitude) {
        this.bus_longitude = bus_longitude;
    }

    public String getBus_id() {
        return bus_id;
    }

    public void setBus_id(String bus_id) {
        this.bus_id = bus_id;
    }

    public String getBus_name() {
        return bus_name;
    }

    public void setBus_name(String bus_name) {
        this.bus_name = bus_name;
    }

    public String getBus_source() {
        return bus_source;
    }

    public void setBus_source(String bus_source) {
        this.bus_source = bus_source;
    }

    public String getBus_destination() {
        return bus_destination;
    }

    public void setBus_destination(String bus_destination) {
        this.bus_destination = bus_destination;
    }

    public String getBus_date() {
        return bus_date;
    }

    public void setBus_date(String bus_date) {
        this.bus_date = bus_date;
    }

    public String getBus_time() {
        return bus_time;
    }

    public void setBus_time(String bus_time) {
        this.bus_time = bus_time;
    }

    public String getBus_seat() {
        return bus_seat;
    }

    public void setBus_seat(String bus_seat) {
        this.bus_seat = bus_seat;
    }
}
