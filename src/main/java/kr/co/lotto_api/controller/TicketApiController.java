package kr.co.lotto_api.controller;

import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import kr.co.lotto_api.mapper.Member;
 

@RestController
@RequestMapping("/api/ticket")
@CrossOrigin
public class TicketApiController {

	@Autowired
	Member member;
	
	
    @PostMapping(value = "/add")
    public @ResponseBody JSONObject add(@RequestBody Map<String,Object> map) throws JsonProcessingException{
    	JSONObject json = new JSONObject();
    	//회원 입력시도, 이미존재하면 로그인 처리
    	String result = "insert"; 
    	try{
    		
    		member.insert(map);
    		json.put("status", "OK");
    	}catch(Exception e) {
    		result = "exception";
    	}
    	json.put("result", result);
    	return json;
    }
    
    
    /**
     * 목록
     * @param map
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping(value = "/list")
    public @ResponseBody JSONObject getList(@RequestBody Map<String,Object> map) throws JsonProcessingException{
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
    public @ResponseBody JSONObject deleteInfo(@RequestBody Map<String,Object> map) throws JsonProcessingException{
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
    public @ResponseBody String set() {
    	Map<String,Object> map = new HashMap<String,Object>();
//    	lottoNoService.insert(map);
    	return map.toString();
    }
}
