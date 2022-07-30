package kr.co.colander.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.co.colander.model.TicketVO;
import kr.co.colander.service.TicketService;
 

@RestController
@RequestMapping("/api/ticket")
@CrossOrigin
public class TicketApiController {

	@Autowired
	TicketService ticketService;
	
	/**
	 * QR스캔으로 입력
	 * @param ticketList
	 * @return
	 * @throws JsonProcessingException
	 */
    @PostMapping(value = "/add")
    public JSONObject add(@RequestBody List<TicketVO> ticketList) throws JsonProcessingException{
        return ticketService.insertList(ticketList);
    }
    
    
    /**
     * 목록
     * @param map
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping(value = "/list")
    public JSONObject getList(@RequestParam Map<String,Object> map) throws JsonProcessingException{
      JSONObject json = new JSONObject();
      try{
        json.put("list", ticketService.selectList(map));
        json.put("status", "OK");
      }catch(Exception e) {
        e.printStackTrace();
      }
      return json;
    }
    
    @DeleteMapping(value="/info/{memberNo}/{tr}")
    public JSONObject delete(@PathVariable int memberNo, @PathVariable String tr) throws JsonProcessingException{
    	JSONObject json = new JSONObject();
    	try{
    		Map<String,Object> map = new HashMap<String,Object>();
    		map.put("memberNo", memberNo);
    		map.put("tr", tr);
    		return ticketService.delete(map);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return json;
    }
    
    
}
