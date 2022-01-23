package kr.co.lotto_api.controller;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.lotto_api.model.WinNoVO;
import kr.co.lotto_api.service.WinNoService;
 

@Controller
@RequestMapping("/api")
public class ApiController {

	@Autowired
    WinNoService winNoService;
   
	ObjectMapper  om = new ObjectMapper();
	
    @RequestMapping(value = "/winNo", method = RequestMethod.GET)
    public @ResponseBody String get(@RequestParam Map<String,Object> map) throws JsonProcessingException {
    	List<WinNoVO> list = winNoService.selectList(map);
    	
        return om.writeValueAsString(list);
    }
    
    @RequestMapping(value = "/winNo", method = RequestMethod.POST)
    public @ResponseBody String set(@RequestParam Map<String,Object> map) throws JsonProcessingException {
    	JSONObject json = new JSONObject();
    	try {
    		winNoService.insert(map);
    		json.put("status", "OK");
    	}catch(Exception e) {
    		json.put("status", "Exception");
    	}
    	return json.toJSONString();
    }
 
    
    
}
