package com.system.service;
import java.util.ArrayList;
import com.system.model.Website;

public class SubscriptionManager{
    ArrayList<Website> websites = new ArrayList<>();

    public void addWebsite(Website site){
        websites.add(site);
    }
    
    public void removeWebsite(Website site){
        websites.remove(site);
    }

    public void checkUpdates(){
        for (Website site : websites){
            site.checkAsUpdate();
        }
    }
}