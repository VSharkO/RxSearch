package com.example.vsharko.rxsearch.model;

import org.simpleframework.xml.Element;

import io.reactivex.annotations.Nullable;

public class Config {

    @Element(name = "customer_id", required = false)
    private String customer_id;
    @Element(name = "firstname", required = false)
    private String firstname;
    @Element(name = "currency")
    private String currency;
    @Element(name = "language")
    private String language;
    @Element(name = "country")
    private String country;
    @Element(name = "native_checkout")
    private String native_checkout;
    @Element(name = "cart_summary_qty")
    private String cart_summary_qty;
    @Element(name = "app_icon")
    private String app_icon;
    @Element(name = "delay_delivery_time")
    private String delay_delivery_time;

// Getter Methods


    public String getCustomer_id() {
        return customer_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getCurrency() {
        return currency;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getCart_summary_qty() {
        return cart_summary_qty;
    }

    public String getApp_icon() {
        return app_icon;
    }

    public String getDelay_delivery_time() {
        return delay_delivery_time;
    }

    public String getNative_checkout() {
        return native_checkout;
    }

    // Setter Methods


    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCart_summary_qty(String cart_summary_qty) {
        this.cart_summary_qty = cart_summary_qty;
    }

    public void setApp_icon(String app_icon) {
        this.app_icon = app_icon;
    }

    public void setDelay_delivery_time(String delay_delivery_time) {
        this.delay_delivery_time = delay_delivery_time;
    }

    public void setNative_checkout(String native_checkout) {
        this.native_checkout = native_checkout;
    }
}