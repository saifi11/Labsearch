package com.example.pathalogyapp;

public class centrestore {
    String  centre_name ,centre_phone , centre_regno , centre_Email , centre_passwd,centre_Pin;

    public centrestore(String centre_name, String centre_phone, String centre_regno, String centre_Email, String centre_passwd, String centre_Pin) {
        this.centre_name = centre_name;
        this.centre_phone = centre_phone;
        this.centre_regno = centre_regno;
        this.centre_Email = centre_Email;
        this.centre_passwd = centre_passwd;
        this.centre_Pin = centre_Pin;
    }

    public centrestore() {
    }

    public String getCentre_name() {
        return centre_name;
    }

    public void setCentre_name(String centre_name) {
        this.centre_name = centre_name;
    }

    public String getCentre_phone() {
        return centre_phone;
    }

    public void setCentre_phone(String centre_phone) {
        this.centre_phone = centre_phone;
    }

    public String getCentre_regno() {
        return centre_regno;
    }

    public void setCentre_regno(String centre_regno) {
        this.centre_regno = centre_regno;
    }

    public String getCentre_Email() {
        return centre_Email;
    }

    public void setCentre_Email(String centre_Email) {
        this.centre_Email = centre_Email;
    }

    public String getCentre_passwd() {
        return centre_passwd;
    }

    public void setCentre_passwd(String centre_passwd) {
        this.centre_passwd = centre_passwd;
    }

    public String getCentre_Pin() {
        return centre_Pin;
    }

    public void setCentre_Pin(String centre_Pin) {
        this.centre_Pin = centre_Pin;
    }
}
