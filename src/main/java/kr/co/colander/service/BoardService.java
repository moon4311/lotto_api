package kr.co.colander.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.co.colander.mapper.BoardTip;
import kr.co.colander.model.BoardVO;
import lombok.extern.log4j.Log4j2;

@Service
@Repository
@Log4j2
public class BoardService extends AbstractService implements ServiceImpl {

	@Resource
	private BoardTip boardTip;
	
	@Override
	public JSONObject insert(Map<String, Object> map) {
		try {
			boardTip.insert(map);
			return _jsonOk;
		}catch(DuplicateKeyException e) {
			JSONObject rslt = (JSONObject) _jsonFail.clone();
			rslt.put("msg", e.getMessage());
			return rslt;
		}catch(Exception e) {
			log.error(this.getClass().getName(), e.getMessage());
			return _jsonFail;
		}
	}

	@Override
	public JSONObject update(Map<String, Object> map) {
		try {
			boardTip.update(map);
			return _jsonOk;
		}catch(Exception e) {
			log.error(this.getClass().getName(), e.getMessage());
			return _jsonFail;
		}
	}

	
	@Override
	public JSONObject delete(Map<String, Object> map) {
		try {
			boardTip.delete(map);
			return _jsonOk;
		}catch(Exception e) {
			log.error(this.getClass().getName(), e.getMessage());
			return _jsonFail;
		}
	}

	public List<BoardVO> selectList(Map<String, Object> map) {
		return boardTip.selectList(map);
	}
	
	public BoardVO selectOne(Map<String, Object> map) {
		return boardTip.selectOne(map);
	}
	

}
