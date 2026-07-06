package com.system.model;
import com.system.pattern.Receiver;

public class SMSNotification implements Receiver{
    public String SMS;

    public void update(){
        System.out.println(SMS + "da co thong bao moi!");
    }
}