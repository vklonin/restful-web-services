package com.vklonin.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

//Controller
@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    // GET
    // URI - hello-world
    // "hello world"
    //@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello world");
    }

    @GetMapping(path = "/hello-world/path-variable/{name},{nameSec}")
    public HelloWorldBean helloWorldPathVar(@PathVariable String name, @PathVariable String nameSec) {
        return new HelloWorldBean(String.format("Hello world, %s second %s", name, nameSec));
    }

    @GetMapping("/hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required = false) Locale locale) {
        System.out.println(locale);
        return messageSource.getMessage("good.morning.message", null, "Default message" ,locale);

        //return "Hello world";

        //en = Hello world
        //ru = Привет!
        //nl = Goede Morgen
    }

}
