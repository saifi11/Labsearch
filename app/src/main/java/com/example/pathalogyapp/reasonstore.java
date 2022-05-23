package com.example.pathalogyapp;

public class reasonstore {

    String phonenumber , testname , reason;

    public reasonstore(String phonenumber, String testname, String reason) {
        this.phonenumber = phonenumber;
        this.testname = testname;
        this.reason = reason;
    }

    public reasonstore() {
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
