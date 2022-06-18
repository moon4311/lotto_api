package kr.co.colander.controller;

import java.util.HashMap;
import java.util.List;
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
import kr.co.colander.model.TicketVO;
import kr.co.colander.service.TicketService;
 

@RestController
@RequestMapping("/api/ticket")
@CrossOrigin
public class TicketApiController {

	@Autowired
	TicketService ticketService;
	
	
    @PostMapping(value = "/add")
    public @ResponseBody JSONObject add(@RequestBody List<TicketVO> ticketList) throws JsonProcessingException{
        return ticketService.insertList(ticketList);
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
        json.put("list", ticketService.selectList(map));
        json.put("status", "OK");
      }catch(Exception e) {
        e.printStackTrace();
      }
      return json;
    }
}
