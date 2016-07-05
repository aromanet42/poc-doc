/**
 * Copyright (C) 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 */
package com.example.bean;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderOfferBean {

    private Long offerId;

    private BigDecimal offerPrice;
    private Integer quantity;
    private BigDecimal price;

    private BigDecimal shippingPrice;

    private String shippingTypeCode;

    private Integer leadtimeToShip;

    private String orderLineUuid;

    private ISOCurrencyCode currencyIsoCode;

    public OrderOfferBean() {
    }

    public Long getOfferId() {
        return offerId;
    }

    public BigDecimal getOfferPrice() {
        return offerPrice;
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

    public String getShippingTypeCode() {
        return shippingTypeCode;
    }

    public Integer getLeadtimeToShip() {
        return leadtimeToShip;
    }

    public String getOrderLineUuid() {
        return orderLineUuid;
    }

    public ISOCurrencyCode getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public void setOfferPrice(BigDecimal offerPrice) {
        this.offerPrice = offerPrice;
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

    public void setShippingTypeCode(String shippingTypeCode) {
        this.shippingTypeCode = shippingTypeCode;
    }

    public void setLeadtimeToShip(Integer leadtimeToShip) {
        this.leadtimeToShip = leadtimeToShip;
    }

    public void setOrderLineUuid(String orderLineUuid) {
        this.orderLineUuid = orderLineUuid;
    }


    public void setCurrencyIsoCode(ISOCurrencyCode currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }
}
