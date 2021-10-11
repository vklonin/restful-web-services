package com.vklonin.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;

//Controller
@RestController
public class HelloWorldController {

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
}
