package kr.co.colander.service;

import java.util.Map;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import kr.co.colander.mapper.Member;

@Service
public class MemberService {

	@Resource
	Member member;
	
	/**
	 * 로그인 처리
	 * @param map
	 * @return
	 */
	public JSONObject login(Map<String,Object> map) {
		JSONObject json = new JSONObject();
    	//회원 입력시도, 이미존재하면 로그인 처리
    	String result = "insert"; 
    	try{
    		member.insert(map);
    	}catch(Exception e) {
    	  result = "login";
    		member.login(map);
    	}finally {
    		json.put("no", map.get("no"));
    		json.put("status", "OK");
    	}
    	json.put("result", result);
    	return json;
	}
	
	/**
	 * 내 정보 조회
	 * @param map
	 * @return
	 */
	public JSONObject myInfo(Map<String,Object> map) {
		JSONObject json = new JSONObject();
		json.put("data", member.selectMyInfo(map));
		return json;
	}
}
