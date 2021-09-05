package com.udacity.persistence.entities0.DTO;

import java.math.BigDecimal;

public class RecipientAndPrice {
    private String recipientName;
    private BigDecimal price;

    public RecipientAndPrice(String recipientName, BigDecimal price) {
        this.recipientName = recipientName;
        this.price = price;
    }

    public String getName() {
        return recipientName;
    }

    public void setName(String recipientName) {
        this.recipientName = recipientName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
