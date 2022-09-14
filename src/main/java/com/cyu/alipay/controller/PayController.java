package com.cyu.alipay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PayController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
