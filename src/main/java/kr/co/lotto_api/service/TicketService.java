package kr.co.lotto_api.service;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.co.lotto_api.mapper.TicketsHistory;
import kr.co.lotto_api.model.TicketVO;
import lombok.extern.log4j.Log4j2;

@Service
@Repository
@Log4j2
public class TicketService extends AbstractService implements ServiceImpl {

	@Autowired
	private TicketsHistory ticketHistory;
	
	@Override
	public JSONObject insert(Map<String, Object> map) {
		try {
			ticketHistory.insert(map);
			return _jsonOk;
		}catch(DuplicateKeyException e) {
			JSONObject rslt = (JSONObject) _jsonFail.clone();
			rslt.put("msg", e.getMessage());
			return rslt;
		}catch(Exception e) {
			e.printStackTrace();
			return _jsonFail;
		}
	}

	@Override
	public JSONObject update(Map<String, Object> map) {
		return _jsonOk;
	}

	@Override
	public JSONObject delete(Map<String, Object> map) {
		return _jsonOk;
	}

	public List<TicketVO> selectList(Map<String, Object> map) {
		return ticketHistory.selectList(map);
	}
	

}
