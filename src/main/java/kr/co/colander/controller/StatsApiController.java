package kr.co.colander.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.colander.model.BallNoVO;
import kr.co.colander.model.WinNoVO;
import kr.co.colander.service.WinNoService;
 

@RestController
@RequestMapping("/api/stats")
@CrossOrigin
public class StatsApiController {

	@Autowired
    WinNoService winNoService;
	
	ObjectMapper  om = new ObjectMapper();
	
    @GetMapping(value = "/winNo")
    public String getWinNo(@RequestParam Map<String,Object> map) throws JsonProcessingException {
    	List<WinNoVO> list = winNoService.selectList(map);
        return om.writeValueAsString(list);
    }
    
    @GetMapping(value = "/element/winNo")
    public Map<String,Object> getwinNo(@RequestParam Map<String,Object> map) throws JsonProcessingException {
    	List<BallNoVO> list = winNoService.selectElementWinNo(map);
    	map.put("list", list);
    	return map;
    }
    
    
    @Deprecated
    @GetMapping(value = "/ballNo")
    public Map<String,Object> getBallNo(@RequestParam Map<String,Object> map) throws JsonProcessingException {
    	List<BallNoVO> list = winNoService.selectBallNoVO(map);
    	map.put("list", list);
    	return map;
    }
    
    @GetMapping(value = "/ballNoRate")
    public Map<String,Object> getBallNoRate(@RequestParam Map<String,Object> map) throws JsonProcessingException {
    	map.put("list", winNoService.selectBallNoRateList(map));
    	map.put("drwNo", winNoService.selectCount(map));
    	map.put("containsRate", winNoService.selectContainRate(map));
    	return map;
    }
    
 
    @GetMapping(value="/oddEven")
    public String getOddEven() throws JsonProcessingException{
    	return om.writeValueAsString(winNoService.selectOddEven());
    }
    @GetMapping(value="/sumCnt")
    public String getSumCnt() throws JsonProcessingException{
    	return om.writeValueAsString(winNoService.selectSumCnt());
    }
    
    
//    @GetMapping(value="/set")
    public String set() {
    	Map<String,Object> map = new HashMap<String,Object>();
//    	lottoNoService.insert(map);
    	return map.toString();
    }
}
