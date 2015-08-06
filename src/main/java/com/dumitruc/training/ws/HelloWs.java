package com.dumitruc.training.ws;


/**
 * Created by dima on 06/08/2015.
 */


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class HelloWs {
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }


    @RequestMapping("/sum")
    @ResponseBody
    String calculate(int... numbers) {
        Integer result = 0;
        for (int i : numbers) {
            result = result + i;
        }

        return String.valueOf(result);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/object/{name}")
    ResponseEntity<?> back(@PathVariable String name){
        String responseBody =  String.format("Hello %s",name);
        return new ResponseEntity<Object>(responseBody,HttpStatus.ACCEPTED);
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloWs.class, args);
    }
}
