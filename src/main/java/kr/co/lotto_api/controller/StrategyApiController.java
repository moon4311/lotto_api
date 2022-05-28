package kr.co.lotto_api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import kr.co.lotto_api.service.LottoNoService;
 

@RestController
@RequestMapping("/api/strategy")
@CrossOrigin
public class StrategyApiController {

	@Autowired
	LottoNoService lottoNoService;
   
	ObjectMapper  om = new ObjectMapper();
	
    @GetMapping(value = "/getList")
    public @ResponseBody String getList(@RequestParam Map<String,Object> map) throws JsonProcessingException {
    	
    	
    	try {
    		int limit = (int) map.get("limit");
    		limit = limit * 1;
    	}catch(Exception e) {
    		map.put("limit", 10);
    	}
    	
    	String noListStr = (String)map.get("noList");
    	String[] arr = noListStr.split(",");
    	if(arr.length> 1) {
	    	List<String> noList = new ArrayList<String>();
	    	for(String one : arr) {
	    		noList.add(one);
	    	}
	    	map.put("noList",noList);
    	}
    	
    	if(arr.length> 1) {
	    	List<String> noList = new ArrayList<String>();
	    	for(String one : arr) {
	    		noList.add(one);
	    	}
	    	map.put("noList",noList);
    	}

    	Map<String,Object> rslt = new HashMap<String,Object>();
    	rslt.put("cnt", lottoNoService.selectReduceCnt(map));
    	rslt.put("list", lottoNoService.selectReduceList(map));
        return om.writeValueAsString(rslt);
    }
}
