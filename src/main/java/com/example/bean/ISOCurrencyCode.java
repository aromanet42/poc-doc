/**
 * Copyright (C) 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 */
package com.example.bean;

public enum ISOCurrencyCode {

    EUR("€"),
    GBP("£"),
    USD("$"),
    AUD("$"),
    NGN("₦"),
    TRY("₺"),
    BTC("฿"),
    CAD("$"),
    NZD("$"),
    INR("₹"),
    BRL("R$"),
    CZK("Kč"),
    DKK("kr"),
    SEK("kr"),
    CHF("Fr."),
    HKD("$"),
    SGD("$"),
    PLN("zł"),
    NOK("kr"),
    ARS("$"),
    MXN("$"),
    UYU("$"),
    PEN("S/."),
    CLP("$"),
    COP("$"),
    JPY("¥"),
    BGN("лв."),
    HRK("Kn"),
    HUF("Ft"),
    RON("Lei"),
    ;

    private String symbol;

    ISOCurrencyCode(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
