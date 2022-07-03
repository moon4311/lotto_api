package kr.co.colander.service;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.co.colander.mapper.TicketsHistory;
import kr.co.colander.model.TicketVO;
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

	public JSONObject insertList(List<TicketVO> list) {
	  JSONObject rslt = (JSONObject) _jsonFail.clone();
	  
	  if(list == null || list.size()==0) {
	    rslt.put("msg", "list is null  or  0");
	    return rslt;
	  }else {
	    if(ticketHistory.checkTr(list.get(0).getTr())){
	      rslt.put("msg", "already inserted");
	      return rslt;
	    }
	  }
	  
	  try {
	    ticketHistory.insertList(list);
	    return _jsonOk;
	  }catch(Exception e) {
	    e.printStackTrace();
	    rslt.put("msg", e.getMessage());
	    return rslt;
	  }
	}
	
	@Override
	public JSONObject update(Map<String, Object> map) {
		return _jsonOk;
	}

	
	@Override
	/**
	 * memberNo, tr 기준 삭제
	 */
	public JSONObject delete(Map<String, Object> map) {
		ticketHistory.delete(map);
		return _jsonOk;
	}

	public List<TicketVO> selectList(Map<String, Object> map) {
		return ticketHistory.selectList(map);
	}
	

}
