package com.example;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Service {

    private String code;
    private String name;

    public Service() {
    }

    public Service(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
