package com.example.vsharko.rxsearch.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "response")
public class Products {

    @ElementList(name = "results")
    private ArrayList<Product> mProductArrayList;


    @Element(name = "config" ,required = false)
    private Config mConfig;

    //getters and setters

    public ArrayList<Product> getProductArrayList() {
        return mProductArrayList;
    }

    public void setProductArrayList(ArrayList<Product> productArrayList) {
        mProductArrayList = productArrayList;
    }

    public Config getConfig() {
        return mConfig;
    }

    public void setConfig(Config config) {
        mConfig = config;
    }
}
