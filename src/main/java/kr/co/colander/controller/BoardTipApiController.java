package kr.co.colander.controller;

import java.util.HashMap;
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

import kr.co.colander.service.BoardService;
 

@RestController
@RequestMapping("/api/board/tip")
@CrossOrigin
public class BoardTipApiController {

	@Autowired
	BoardService boardService;
	
	
    @PostMapping(value = "/add")
    public JSONObject add(@RequestBody Map<String,Object> boardVO) throws JsonProcessingException{
        return boardService.insert(boardVO);
    }
    
    
    /**
     * 목록
     */
    @GetMapping(value = "/list")
    public JSONObject getList(@RequestParam Map<String,Object> map) throws JsonProcessingException{
      JSONObject json = new JSONObject();
      try{
        json.put("list", boardService.selectList(map));
        json.put("status", "OK");
      }catch(Exception e) {
        e.printStackTrace();
      }
      return json;
    }
    
    @GetMapping(value="/info/{no}")
    public JSONObject selectOne(@PathVariable int no) throws JsonProcessingException{
    	JSONObject json = new JSONObject();
    	try{
    		Map<String,Object> map = new HashMap<String,Object>();
    		map.put("no", no);
    		json.put("one", boardService.selectOne(map));
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return json;
    }
    
    @DeleteMapping(value="/info/{no}")
    public JSONObject delete(@PathVariable int no) throws JsonProcessingException{
    	Map<String,Object> map = new HashMap<String,Object>();
		map.put("no", no);
		return boardService.delete(map);
    }
    
    
}
