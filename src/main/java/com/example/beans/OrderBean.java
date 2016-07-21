package com.example.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderBean {

    @ApiModelProperty(value = "this is the commercial id of the order", required = true)
    private String commercialId;

    private List<OrderLineBean> orderLines;

    @ApiModelProperty(required = true)
    private OrderPaymentInfoBean paymentInfo;

    @Deprecated
    @ApiModelProperty
    private Boolean scored = true;

    @Deprecated
    private String shippingZoneCode;

    private String channelCode;

    public OrderBean() {

    }

    public String getCommercialId() {
        return commercialId;
    }

    public List<OrderLineBean> getOrderLines() {
        return orderLines;
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

    public void setOrderLines(List<OrderLineBean> orderLines) {
        this.orderLines = orderLines;
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