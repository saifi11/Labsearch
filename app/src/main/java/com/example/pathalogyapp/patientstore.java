package com.example.pathalogyapp;

public class patientstore {

    String patient_name, patient_phone, patient_age,Patient_gender, patient_Email, refer_doc, testname, testprice, address,Date;

    public patientstore() {
    }

    public patientstore(String patient_name, String patient_phone, String patient_age, String patient_gender, String patient_Email, String refer_doc, String testname, String testprice, String address, String date) {
        this.patient_name = patient_name;
        this.patient_phone = patient_phone;
        this.patient_age = patient_age;
        Patient_gender = patient_gender;
        this.patient_Email = patient_Email;
        this.refer_doc = refer_doc;
        this.testname = testname;
        this.testprice = testprice;
        this.address = address;
        Date = date;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_phone() {
        return patient_phone;
    }

    public void setPatient_phone(String patient_phone) {
        this.patient_phone = patient_phone;
    }

    public String getPatient_age() {
        return patient_age;
    }

    public void setPatient_age(String patient_age) {
        this.patient_age = patient_age;
    }

    public String getPatient_gender() {
        return Patient_gender;
    }

    public void setPatient_gender(String patient_gender) {
        Patient_gender = patient_gender;
    }

    public String getPatient_Email() {
        return patient_Email;
    }

    public void setPatient_Email(String patient_Email) {
        this.patient_Email = patient_Email;
    }

    public String getRefer_doc() {
        return refer_doc;
    }

    public void setRefer_doc(String refer_doc) {
        this.refer_doc = refer_doc;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public String getTestprice() {
        return testprice;
    }

    public void setTestprice(String testprice) {
        this.testprice = testprice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}