package kr.co.colander.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.colander.service.MemberService;
 

@RestController
@RequestMapping("/api/my")
@CrossOrigin
public class MyApiController {

	@Resource
	MemberService memberService;
	
	
    @GetMapping(value = "/info")
    public JSONObject login(@RequestBody Map<String,Object> map) {
    	JSONObject json = new JSONObject();
    	//회원 입력시도, 이미존재하면 로그인 처리
    	String result = "insert"; 
    	try{
    		memberService.myInfo(map);
    		json.put("status", "OK");
    	}catch(Exception e) {
    		result = "login";
    	}
    	json.put("result", result);
    	return json;
    }
    
}
