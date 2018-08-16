package com.example.vsharko.rxsearch.model;

import org.simpleframework.xml.Element;

@Element(name = "result")
public class Product {

    @Element(name = "id")
    private String id;
    @Element(name = "name")
    private String name;
    @Element(name = "image")
    private String image;
    @Element(name = "big_image")
    private String big_image;
    @Element(name = "price")
    private String price;

//     Getter Methods

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getBig_image() {
        return big_image;
    }

    public String getPrice() {
        return price;
    }

    // Setter Methods

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setBig_image(String big_image) {
        this.big_image = big_image;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
