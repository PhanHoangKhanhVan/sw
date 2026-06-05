package com.system.model;
import java.util.ArrayList;
import com.system.pattern.*;

import java.util.ArrayList;

public class Website implements Sender{
    public String url;
    public ArrayList<Receiver> receivers = new ArrayList<>();
    public String currentContent;   //noi dung hien tai vua tai ve
    public String oldContent;   //noi dung cu luu trong may

    //important: giu 1 bien thuoc kieu interface chien luoc
    private ComparisonStrategy strategy;

    public void attach(Receiver r){
        receivers.add(r);
    }

    public void detach(Receiver r){
        receivers.remove(r);
    }

    public void notifyObservers(){
        for(Receiver r: receivers){
            r.update();
        }
    }

    //ham de nguoi dung chon hoac doi chien luoc
    public void setStrategy(ComparisonStrategy strategy){
        this.strategy = strategy;
    }

    //kiem tra cap nhat
    public void checkAsUpdate(){
        //neu chien luoc khong giong nhau
        if (!strategy.isIdentical(oldContent, currentContent)){
            //kich hoat thong bao cho moi nguoi
            this.notifyObservers();
            //cap nhat lai noi dung
            this.oldContent = this.currentContent;
        }
    }
}