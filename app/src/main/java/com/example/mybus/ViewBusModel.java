package com.example.mybus;

public class ViewBusModel {

    private String bus_id,bus_login_id,bus_name,bus_starting_point,bus_end_point,bus_description,bus_seat,bus_route,bus_date,bus_time;

    public ViewBusModel(String bus_id,String bus_login_id,String bus_name,String bus_starting_point,String bus_end_point,String bus_description,String bus_seat,String bus_route,String bus_date,String bus_time) {

        this.bus_id=bus_id;
        this.bus_login_id=bus_login_id;
        this.bus_name=bus_name;
        this.bus_starting_point=bus_starting_point;
        this.bus_end_point=bus_end_point;
        this.bus_description=bus_description;
        this.bus_seat=bus_seat;
        this.bus_route=bus_route;
        this.bus_date=bus_date;
        this.bus_time=bus_time;
    }

    public String getBus_login_id() {
        return bus_login_id;
    }

    public void setBus_login_id(String bus_login_id) {
        this.bus_login_id = bus_login_id;
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

    public String getBus_starting_point() {
        return bus_starting_point;
    }

    public void setBus_starting_point(String bus_starting_point) {
        this.bus_starting_point = bus_starting_point;
    }

    public String getBus_end_point() {
        return bus_end_point;
    }

    public void setBus_end_point(String bus_end_point) {
        this.bus_end_point = bus_end_point;
    }

    public String getBus_description() {
        return bus_description;
    }

    public void setBus_description(String bus_description) {
        this.bus_description = bus_description;
    }

    public String getBus_seat() {
        return bus_seat;
    }

    public void setBus_seat(String bus_seat) {
        this.bus_seat = bus_seat;
    }

    public String getBus_route() {
        return bus_route;
    }

    public void setBus_route(String bus_route) {
        this.bus_route = bus_route;
    }
}
