package kr.co.lotto_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.lotto_api.service.WinNoService;

@Controller
@RequestMapping("/")
public class BaseController {

  
  @Autowired
    WinNoService commonCodeService;

}
