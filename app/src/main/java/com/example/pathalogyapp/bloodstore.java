package com.example.pathalogyapp;

public class bloodstore {
    String Blood_name,Blood_price,Regno;

    public bloodstore(String blood_name, String blood_price, String regno) {
        Blood_name = blood_name;
        Blood_price = blood_price;
        Regno = regno;
    }

    public bloodstore() {
    }

    public String getBlood_name() {
        return Blood_name;
    }

    public void setBlood_name(String blood_name) {
        Blood_name = blood_name;
    }

    public String getBlood_price() {
        return Blood_price;
    }

    public void setBlood_price(String blood_price) {
        Blood_price = blood_price;
    }

    public String getRegno() {
        return Regno;
    }

    public void setRegno(String regno) {
        Regno = regno;
    }
}
