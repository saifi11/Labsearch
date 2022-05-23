package com.example.pathalogyapp;

public class xraystore {
    String xray_name , xray_price , regno;

    public xraystore(String xray_name, String xray_price, String regno) {
        this.xray_name = xray_name;
        this.xray_price = xray_price;
        this.regno = regno;
    }

    public xraystore() {
    }

    public String getXray_name() {
        return xray_name;
    }

    public void setXray_name(String xray_name) {
        this.xray_name = xray_name;
    }

    public String getXray_price() {
        return xray_price;
    }

    public void setXray_price(String xray_price) {
        this.xray_price = xray_price;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }
}
