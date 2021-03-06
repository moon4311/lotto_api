package kr.co.colander.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.colander.mapper.Member;
import kr.co.colander.model.WinNoVO;
import kr.co.colander.service.WinNoService;
 

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiController {

	@Autowired
    WinNoService winNoService;
	
	@Autowired
	Member member;
	
	
	ObjectMapper  om = new ObjectMapper();
	
    @GetMapping(value = "/winNo")
    public String getWinNo(@RequestParam Map<String,Object> map) throws JsonProcessingException {
    	List<WinNoVO> list = winNoService.selectList(map);
        return om.writeValueAsString(list);
    }
    
    @PostMapping(value = "/winNo")
    public String set(@RequestBody Map<String,Object> map) throws JsonProcessingException {
    	JSONObject json = new JSONObject();
    	try {
    		winNoService.insert(map);
    		json.put("status", "OK");
    	}catch(Exception e) {
    		json.put("status", "Exception");
    	}
    	return json.toJSONString();
    }
    
    @Deprecated
    @PostMapping(value = "/login")
    public JSONObject login(@RequestBody Map<String,Object> map) throws JsonProcessingException{
    	JSONObject json = new JSONObject();
    	//회원 입력시도, 이미존재하면 로그인 처리
    	String result = "insert"; 
    	try{
    		member.insert(map);
    		json.put("status", "OK");
    	}catch(Exception e) {
    	  result = "login";
    		member.login(map);
    	}
    	json.put("result", result);
    	return json;
    }
    
 
    
//    @GetMapping(value="/set")
    public String set() {
    	Map<String,Object> map = new HashMap<String,Object>();
//    	lottoNoService.insert(map);
    	return map.toString();
    }
}
