package com.example.pathalogyapp;

public class MRIstore {
    String MRI_name,MRI_price,regno;

    public MRIstore(String MRI_name, String MRI_price, String regno) {
        this.MRI_name = MRI_name;
        this.MRI_price = MRI_price;
        this.regno = regno;
    }

    public MRIstore() {
    }

    public String getMRI_name() {
        return MRI_name;
    }

    public void setMRI_name(String MRI_name) {
        this.MRI_name = MRI_name;
    }

    public String getMRI_price() {
        return MRI_price;
    }

    public void setMRI_price(String MRI_price) {
        this.MRI_price = MRI_price;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }
}
