package com.example;

import com.example.beans.ISOCurrencyCode;
import com.example.beans.OrderBean;
import com.example.beans.OrderLineBean;
import com.example.beans.OrderPaymentInfoBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/service")
@Api
public class ServiceController {

    @RequestMapping(value = "/", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Method renvoyant un Service")
    public Service getMyService() {
        return new Service("DFKEFJ", "DSISDKF");
    }


    @RequestMapping(value = "/", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation("creates a service")
    public void serviceCreation(@RequestBody @ApiParam("service à créer") Service service) {
    }

    @RequestMapping(value = "/orderBean", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "creates a new order", tags = "shop")
    public OrderBean orderBean() {
        OrderBean orderBean = new OrderBean();
        orderBean.setChannelCode("ChannelCode");

        OrderPaymentInfoBean paymentInfo = new OrderPaymentInfoBean();
        paymentInfo.setImprintNumber("1234");
        paymentInfo.setPaymentType("CB");
        orderBean.setPaymentInfo(paymentInfo);

        List<OrderLineBean> offers = new ArrayList<>();
        OrderLineBean orderLineBean = new OrderLineBean();
        orderLineBean.setCurrencyIsoCode(ISOCurrencyCode.EUR);
        orderLineBean.setQuantity(12);
        orderLineBean.setPrice(new BigDecimal("12.3"));
        offers.add(orderLineBean);
        orderBean.setOrderLines(offers);

        return orderBean;
    }
}
