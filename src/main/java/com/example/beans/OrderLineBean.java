package com.example.beans;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderLineBean {

    private Integer quantity;
    private BigDecimal price;

    private BigDecimal shippingPrice;

    private String orderLineUuid;

    private ISOCurrencyCode currencyIsoCode;

    public OrderLineBean() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getShippingPrice() {
        return shippingPrice;
    }

    public String getOrderLineUuid() {
        return orderLineUuid;
    }

    public ISOCurrencyCode getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setShippingPrice(BigDecimal shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public void setOrderLineUuid(String orderLineUuid) {
        this.orderLineUuid = orderLineUuid;
    }


    public void setCurrencyIsoCode(ISOCurrencyCode currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }

}
