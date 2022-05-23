package com.example.pathalogyapp;

public class reportstore {

    String Centre_name , Report;

    public reportstore(String centre_name, String report) {
        Centre_name = centre_name;
        Report = report;
    }

    public reportstore() {
    }

    public String getCentre_name() {
        return Centre_name;
    }

    public void setCentre_name(String centre_name) {
        Centre_name = centre_name;
    }

    public String getReport() {
        return Report;
    }

    public void setReport(String report) {
        Report = report;
    }
}
