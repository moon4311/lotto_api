package kr.co.colander.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Delete;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.co.colander.mapper.Member;
import kr.co.colander.service.MemberService;
 

@RestController
@RequestMapping("/api/member")
@CrossOrigin
public class MemberApiController {

	@Autowired
	MemberService memberService;
	
	@Resource
	Member member;
	
	
    @PostMapping(value = "/login")
    public JSONObject login(@RequestBody Map<String,Object> map){
    	return memberService.login(map);
    }
    
    
    /**
     * 목록
     * @param map
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping(value = "/list")
    public JSONObject getList(@RequestBody Map<String,Object> map) throws JsonProcessingException{
      JSONObject json = new JSONObject();
      try{
        json.put("list", member.selectList(map));
        json.put("status", "OK");
      }catch(Exception e) {
        e.printStackTrace();
      }
      return json;
    }
    /**
     * 삭제
     * @param map
     * @return
     * @throws JsonProcessingException
     */
    @Delete(value = "/info")
    public JSONObject deleteInfo(@RequestBody Map<String,Object> map) throws JsonProcessingException{
      JSONObject json = new JSONObject();
      try{
        member.delete(map);
        json.put("status", "OK");
      }catch(Exception e) {
        e.printStackTrace();
      }
      return json;
    }
 
    
//    @GetMapping(value="/set")
    public String set() {
    	Map<String,Object> map = new HashMap<String,Object>();
//    	lottoNoService.insert(map);
    	return map.toString();
    }
}
