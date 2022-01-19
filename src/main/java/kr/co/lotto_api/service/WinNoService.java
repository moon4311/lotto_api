package kr.co.lotto_api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.lotto_api.mapper.WinNo;
import kr.co.lotto_api.model.WinNoVO;

@Transactional
@Service
@Repository
public class WinNoService extends AbstractService implements ServiceImpl{
   
	
	@Autowired
	private WinNo winNo;
	
	
	@Override
	public void insert(Map<String, Object> map) {
		winNo.insert(map);
	}
	
	@Override
	public void update(Map<String, Object> map) {
		winNo.update(map);
	}
	@Override
	public void delete(Map<String, Object> map) {
		winNo.delete(map);
	}
	
	public WinNoVO selectOne(Map<String,Object> map) {
		return winNo.selectOne(map);
	}
	
	public List<WinNoVO> selectList(Map<String,Object> map){
		return winNo.selectList(map);
	}
	
	
}
