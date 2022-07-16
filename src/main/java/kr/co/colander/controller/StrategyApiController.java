package kr.co.colander.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.co.colander.service.StrategyService;
 

@RestController
@RequestMapping("/api/strategy")
@CrossOrigin
public class StrategyApiController {

	@Autowired
	StrategyService strategyService;
   
	/**
	 * 기본제외 후 남은 갯수
	 * @param map
	 * @return
	 * @throws JsonProcessingException
	 */
	@GetMapping(value = "/getStep1Cnt")
	public int getStep1Cnt(@RequestParam Map<String,Object> map) throws JsonProcessingException {
		return strategyService.selectStep1Cnt();
	}
	
    @GetMapping(value = "/getList")
    public Map<String,Object> getList(@RequestParam Map<String,Object> map) throws JsonProcessingException {
    	

    	return strategyService.selectReduceList(map);
    }
}
