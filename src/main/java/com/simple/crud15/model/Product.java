package com.simple.crud15.model;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the ACCOUNTS database table.
 */
@Entity
@Data
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;


    int quantityInStock;


    Long productNumber;
    String name;
    Double unitPrice;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dateSupplied;






    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getId() {
        return productId;
    }

    public void setId(Long id) {
        this.productId = id;
    }


    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Date getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(Date dateSupplied) {
        this.dateSupplied = dateSupplied;
    }
}
