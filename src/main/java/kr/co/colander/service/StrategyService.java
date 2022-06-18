package kr.co.colander.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.co.colander.mapper.LottoNo;
import kr.co.colander.mapper.Strategy;
import kr.co.colander.model.LottoNoVO;

@Service
@Repository
public class StrategyService extends AbstractService implements ServiceImpl {

	@Autowired
	private LottoNo lottoNo;
	
	@Autowired
	private Strategy strategty;
	
	@Override
	public JSONObject insert(Map<String, Object> map) {
		strategty.insertHistory(map);
		return _jsonOk;
	}

	@Override
	public JSONObject update(Map<String, Object> map) {
		return _jsonOk;
	}

	@Override
	public JSONObject delete(Map<String, Object> map) {
		return _jsonOk;
	}

	public List<LottoNoVO> selectList(Map<String, Object> map) {
		return lottoNo.selectList(map);
	}
	
	/**
	 * 전략. 로또번호 추출
	 * @param map
	 * @return
	 */
	public Map<String,Object> selectReduceList(Map<String, Object> map) {
		//검색조건 입력
		insert(map);

    	try {
    		int limit = (int) map.get("rows");
    		limit = limit * 1;
    	}catch(Exception e) {
    		map.put("rows", 10);
    	}
    	
    	String noListStr = (String)map.get("noArr");
    	String[] arr = noListStr.split(",");
    	if(arr.length> 1) {
	    	List<String> noList = new ArrayList<String>();
	    	for(String one : arr) {
	    		noList.add(one);
	    	}
	    	map.put("noList",noList);
    	}
    	
    	String oddStr = (String)map.get("oddArr");
    	String[] oddArr = oddStr.split(",");
    	if(oddArr.length> 0) {
    		List<String> oddList = new ArrayList<String>();
    		for(String one : oddArr) {
    			oddList.add(one);
    		}
    		map.put("oddList",oddList);
    	}
		
		
		//조회
		Map<String,Object> rslt = new HashMap<String,Object>();
    	rslt.put("cnt", strategty.selectCnt(map));
    	rslt.put("list", strategty.selectList(map));
		return rslt;
	}
	

}
