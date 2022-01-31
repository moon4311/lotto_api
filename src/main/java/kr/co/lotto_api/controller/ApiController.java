package kr.co.lotto_api.controller;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.lotto_api.model.BallNoVO;
import kr.co.lotto_api.model.WinNoVO;
import kr.co.lotto_api.service.WinNoService;
 

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiController {

	@Autowired
    WinNoService winNoService;
   
	ObjectMapper  om = new ObjectMapper();
	
    @GetMapping(value = "/winNo")
    public @ResponseBody String getWinNo(@RequestParam Map<String,Object> map) throws JsonProcessingException {
    	List<WinNoVO> list = winNoService.selectList(map);
    	
        return om.writeValueAsString(list);
    }
    
    @GetMapping(value = "/ballNo")
    public @ResponseBody String getBallNo(@RequestParam Map<String,Object> map) throws JsonProcessingException {
    	List<BallNoVO> list = winNoService.selectBallNoVO(map);
    	return om.writeValueAsString(list);
    }
    
    @PostMapping(value = "/winNo")
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
 
    @GetMapping(value="/oddEven")
    public @ResponseBody String getOddEven() throws JsonProcessingException{
    	return om.writeValueAsString(winNoService.selectOddEven());
    }
    @GetMapping(value="/sumCnt")
    public @ResponseBody String getSumCnt() throws JsonProcessingException{
    	return om.writeValueAsString(winNoService.selectSumCnt());
    }
    
}
