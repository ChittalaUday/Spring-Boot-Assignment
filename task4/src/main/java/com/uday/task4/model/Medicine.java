package com.uday.task4.model;

import java.util.Date;

public class Medicine {
    private Integer id;
    private String name;
    private String packing;
    private Double gst;
    private Double tradePrice;
    private Double retailPrice;
    private Double discount;
    private Date expiryDate;

    public Medicine() {
    }

    public Medicine(Integer id, String name, String packing, Double gst, Double tradePrice, Double retailPrice,
            Double discount, Date expiryDate) {
        this.id = id;
        this.name = name;
        this.packing = packing;
        this.gst = gst;
        this.tradePrice = tradePrice;
        this.retailPrice = retailPrice;
        this.discount = discount;
        this.expiryDate = expiryDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public Double getGst() {
        return gst;
    }

    public void setGst(Double gst) {
        this.gst = gst;
    }

    public Double getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(Double tradePrice) {
        this.tradePrice = tradePrice;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Medicine [id=" + id + ", name=" + name + ", packing=" + packing + ", gst=" + gst + ", tradePrice="
                + tradePrice + ", retailPrice=" + retailPrice + ", discount=" + discount + ", expiryDate=" + expiryDate
                + "]";
    }

    // Getters, setters, constructors
}
