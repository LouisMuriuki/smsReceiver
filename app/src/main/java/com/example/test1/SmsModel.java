package com.example.test1;

import androidx.annotation.NonNull;

public class SmsModel {
    private int Id;
    private String ContactNumber;
    private String ContactSms;
    private String Time;
    private String Number;

    public SmsModel(int Id, String contactNumber, String contactSms, String time, String number) {
        Id = 0;
        ContactNumber = contactNumber;
        ContactSms = contactSms;
        Time = time;
        Number = number;
    }

    public  int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getContactSms() {
        return ContactSms;
    }

    public void setContactSms(String contactSms) {
        ContactSms = contactSms;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getNumber() {
        return Number;
    }

    @NonNull
    @Override
    public String toString() {
        return "SmsModel{" +
                "Id='" + Id + '\'' +
                ", ContactNumber='" + ContactNumber + '\'' +
                ", ContactSms='" + ContactSms + '\'' +
                ", Time='" + Time + '\'' +
                ", Number='" + Number + '\'' +
                '}';
    }
}
