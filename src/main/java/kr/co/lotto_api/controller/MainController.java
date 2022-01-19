package kr.co.lotto_api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 

@Controller
@RequestMapping("/main")
public class MainController {

   
    @RequestMapping(value = "/dashboard.do")
    public String signup_terms(HttpServletRequest request) {
        return "dashboard.tile";
    }
 
}
