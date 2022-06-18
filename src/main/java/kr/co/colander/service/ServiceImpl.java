package kr.co.colander.service;

import java.util.Map;

import org.json.simple.JSONObject;

public interface ServiceImpl {
	
	//입력
	public JSONObject insert(Map<String,Object> map);
	//수정
	public JSONObject update(Map<String,Object> map);
	//삭제
	public JSONObject delete(Map<String,Object> map);

}
