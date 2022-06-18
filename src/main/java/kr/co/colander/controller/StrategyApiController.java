package kr.co.colander.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.colander.service.LottoNoService;
import kr.co.colander.service.StrategyService;
 

@RestController
@RequestMapping("/api/strategy")
@CrossOrigin
public class StrategyApiController {

	@Autowired
	LottoNoService lottoNoService;

	@Autowired
	StrategyService strategyService;
   
	ObjectMapper  om = new ObjectMapper();
	
    @GetMapping(value = "/getList")
    public @ResponseBody String getList(@RequestParam Map<String,Object> map) throws JsonProcessingException {
    	

    	Map<String,Object> rslt = strategyService.selectReduceList(map);
        return om.writeValueAsString(rslt);
    }
}
