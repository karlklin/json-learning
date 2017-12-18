package com.github.karlklin.yaml;

import java.util.Date;
import java.util.List;

public class Invoice {

    private int invoice;
    private Date date;

    Address billTo;
    Address shipTo;
//
    List<Product> product;

    private double total;
    private double tax;
    private String comments;

    public Invoice() {
    }

    public Invoice(int invoice, Date date, double total, double tax, Address billTo, Address shipTo, List<Product> product, String comments) {
        this.invoice = invoice;
        this.date = date;
        this.total = total;
        this.tax = tax;
        this.billTo = billTo;
        this.shipTo = shipTo;
        this.product = product;
        this.comments = comments;
    }

    public int getInvoice() {
        return invoice;
    }

    public void setInvoice(int invoice) {
        this.invoice = invoice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Address getBillTo() {
        return billTo;
    }

    public void setBillTo(Address billTo) {
        this.billTo = billTo;
    }

    public Address getShipTo() {
        return shipTo;
    }

    public void setShipTo(Address shipTo) {
        this.shipTo = shipTo;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
