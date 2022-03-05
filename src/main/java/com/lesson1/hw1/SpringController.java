package com.lesson1.hw1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringController {

    @RequestMapping(method= RequestMethod.GET, value = "/hi", produces = "text/plain")
        public @ResponseBody String test(){
        return "Endpoint = test";
    }
}