package com.example.backend_1;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }

    @RequestMapping("/esp")
    public String holaMundo() {
        return "Hola Mundo!!";
    }

    @RequestMapping("/helloParam")
    public String helloParam(@RequestParam String fNamn) {
        return "Hello " + fNamn;
        // send http://localhost:8080/helloParam?fNamn=Dennis
    }

    @RequestMapping("/helloParams")
    public String helloParams(@RequestParam(defaultValue = "Lill") String fName,
                              @RequestParam(required = false) String lName) {

        if (lName == null) {
            lName = "";
        }
        return "Hello " + fName + " " + lName;
        // send http://localhost:8080/helloParams?fName=Dennis&lName=MasterMannen
        // send http://localhost:8080/helloParams Gets Default
    }

    @RequestMapping("/helloParamList")
    public String helloWorldList(@RequestParam List<String> list) {
        return "Hello " + list;
        // send http://localhost:8080/helloParamList?list=1,2,3,4,hej
    }

    @RequestMapping("/helloPathParam/{id}")
    public String helloWPathParam(@PathVariable String id) {
        return "Hello " + id;
        // send localhost:8080/helloPathParam/{id}
    }
}
