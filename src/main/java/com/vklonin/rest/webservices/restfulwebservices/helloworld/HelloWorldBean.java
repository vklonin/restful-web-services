package com.vklonin.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {
    private final String message;

    public String setMessage() {
        return message;
    }

    public String getMessage() {
        return message;
    }

    public HelloWorldBean(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
