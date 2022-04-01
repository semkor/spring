package com.lesson7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping(method = RequestMethod.GET, value = "/testMvc")
    @ResponseBody
    public String  testMVc(){
        return "ok";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/testMvc2")
    public String testMVc2(){
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/testMvc3")
    @ResponseBody
    public CustomResponse testMVc3(){
        CustomResponse customResponse = new CustomResponse();
            customResponse.setId(11111L);
        return  customResponse;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/testMvc4")
    @ResponseBody
    public CustomResponse testMVc4(@RequestBody CustomResponse customResponse){
        return  customResponse;
    }
}
