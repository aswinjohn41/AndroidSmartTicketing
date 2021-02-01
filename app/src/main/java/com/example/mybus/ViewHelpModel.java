package com.example.mybus;

public class ViewHelpModel {

    private String help,contact;

    public ViewHelpModel(String help,String contact) {
        this.help=help;
        this.contact=contact;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
