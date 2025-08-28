package com.uday.task4.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class InvoiceItem {
    private Integer id;
    private Integer quantity;
    private String description;
    private String packing;
    private Double gst;
    private Double tradePrice;
    private Double retailPrice;
    private Double discount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expiryDate;

    private Double netAmount;

    public InvoiceItem() {
    }

    public InvoiceItem(Integer id, Integer quantity, String description, String packing, Double gst, Double tradePrice,
            Double retailPrice, Double discount, Date expiryDate, Double netAmount) {
        this.id = id;
        this.quantity = quantity;
        this.description = description;
        this.packing = packing;
        this.gst = gst;
        this.tradePrice = tradePrice;
        this.retailPrice = retailPrice;
        this.discount = discount;
        this.expiryDate = expiryDate;
        this.netAmount = netAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Double netAmount) {
        this.netAmount = netAmount;
    }

    @Override
    public String toString() {
        return "InvoiceItem [id=" + id + ", quantity=" + quantity + ", description=" + description + ", packing="
                + packing + ", gst=" + gst + ", tradePrice=" + tradePrice + ", retailPrice=" + retailPrice
                + ", discount=" + discount + ", expiryDate=" + expiryDate + ", netAmount=" + netAmount + "]";
    }

    // Getters and Setters
}
