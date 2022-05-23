package com.example.pathalogyapp;

public class storingdata {
    String Email , Fullname , Password , Phonenumber , Address , Username;

    public storingdata() {
    }

    public storingdata(String email, String fullname, String password, String phonenumber, String address, String username) {
        Email = email;
        Fullname = fullname;
        Password = password;
        Phonenumber = phonenumber;
        Address = address;
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
