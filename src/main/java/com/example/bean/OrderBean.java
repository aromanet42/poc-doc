/**
 * Copyright (C) 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 */
package com.example.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderBean {

    private String commercialId;

    private List<OrderOfferBean> offers;

    private OrderPaymentInfoBean paymentInfo;

    private Boolean scored;

    private String shippingZoneCode;

    private String channelCode;

    public OrderBean() {

    }

    public String getCommercialId() {
        return commercialId;
    }

    public List<OrderOfferBean> getOffers() {
        return offers;
    }

    public OrderPaymentInfoBean getPaymentInfo() {
        return paymentInfo;
    }

    public Boolean getScored() {
        return scored;
    }

    public String getShippingZoneCode() {
        return shippingZoneCode;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setCommercialId(String commercialId) {
        this.commercialId = commercialId;
    }

    public void setOffers(List<OrderOfferBean> offers) {
        this.offers = offers;
    }

    public void setPaymentInfo(OrderPaymentInfoBean paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public void setScored(Boolean scored) {
        this.scored = scored;
    }

    public void setShippingZoneCode(String shippingZoneCode) {
        this.shippingZoneCode = shippingZoneCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

}
