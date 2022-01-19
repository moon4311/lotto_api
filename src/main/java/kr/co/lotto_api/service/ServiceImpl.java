package kr.co.lotto_api.service;

import java.util.Map;

public interface ServiceImpl {
	
	//입력
	public void insert(Map<String,Object> map);
	//수정
	public void update(Map<String,Object> map);
	//삭제
	public void delete(Map<String,Object> map);

}
