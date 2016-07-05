/**
 * Copyright (C) 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 */
package com.example.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderPaymentInfoBean {

    private String imprintNumber;

    private String paymentType;

    public OrderPaymentInfoBean() {}

    public OrderPaymentInfoBean(String imprintNumber, String paymentType) {
        this.imprintNumber = imprintNumber;
        this.paymentType = paymentType;
    }

    public String getImprintNumber() {
        return imprintNumber;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setImprintNumber(String imprintNumber) {
        this.imprintNumber = imprintNumber;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
