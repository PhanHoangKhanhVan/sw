package com.system.model;
import com.system.pattern.Receiver;

public class EmailNotification implements Receiver{
    public String emailAddress;

    public void update(){
        System.out.println(emailAddress + "co thong bao moi!");
    }
}