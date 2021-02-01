package com.example.mybus;

public class ViewBusModel {

    private String bus_id,bus_name,bus_starting_point,bus_end_point,bus_description,bus_seat,bus_route;

    public ViewBusModel(String bus_id,String bus_name,String bus_starting_point,String bus_end_point,String bus_description,String bus_seat,String bus_route) {

        this.bus_id=bus_id;
        this.bus_name=bus_name;
        this.bus_starting_point=bus_starting_point;
        this.bus_end_point=bus_end_point;
        this.bus_description=bus_description;
        this.bus_seat=bus_seat;
        this.bus_route=bus_route;
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
