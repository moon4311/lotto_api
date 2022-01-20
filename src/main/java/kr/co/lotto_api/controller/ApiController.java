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

import kr.co.lotto_api.model.WinNoVO;
import kr.co.lotto_api.service.WinNoService;
 

@Controller
@RequestMapping("/api")
public class ApiController {

	@Autowired
    WinNoService winNoService;
   
    @RequestMapping(value = "/winNo", method = RequestMethod.GET)
    public @ResponseBody String get(@RequestParam Map<String,Object> map) {
    	List<WinNoVO> list = winNoService.selectList(map);
    	JSONObject json = new JSONObject();
    	json.put("list", list);
        return json.toJSONString();
    }
 
}
