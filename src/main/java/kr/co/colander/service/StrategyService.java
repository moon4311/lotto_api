package kr.co.colander.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.co.colander.mapper.Strategy;
import kr.co.colander.model.LottoNoVO;

@Service
@Repository
public class StrategyService extends AbstractService implements ServiceImpl {

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
		return strategty.selectList(map);
	}
	
	/**
	 * 기본제외 후 남은 갯수
	 * @return
	 */
	public int selectStep1Cnt() {
		return strategty.selectStep1Cnt();
	}
	
	/**
	 * 전략. 로또번호 추출
	 * @param map
	 * @return
	 */
	public Map<String,Object> selectReduceList(Map<String, Object> map) {
		//검색조건 입력
//		insert(map);

    	try {
    		String limit = (String) map.get("rows");
    		if(limit == null) {
    			map.put("rows", 10);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	int no1 = Integer.parseInt((String)map.get("firstNo"));
    	int no2 = Integer.parseInt((String)map.get("secondNo"));
    	int no5 = Integer.parseInt((String)map.get("fiveNo"));
    	int no6 = Integer.parseInt((String)map.get("lastNo"));
    	
    	String noListStr = (String)map.get("noArr");
    	String[] arr = noListStr.split(",");
    	
    	if(arr.length> 1) {
    		//no1
	    	List<String> noList1 = new ArrayList<String>();
	    	List<String> noList2 = new ArrayList<String>();
	    	List<String> noList3 = new ArrayList<String>();
	    	List<String> noList4 = new ArrayList<String>();
	    	List<String> noList5 = new ArrayList<String>();
	    	List<String> noList6 = new ArrayList<String>();
	    	int no = 0;
	    	for(String one : arr) {
	    		no = Integer.parseInt(one);
	    		if(no <= no1) { noList1.add(one); }
	    		if(no>1 && no<=no2){ noList2.add(one); }
	    		if(no>2 && no<43 ) { noList3.add(one); }
	    		if(no>3 && no<44 ) { noList4.add(one); }
	    		if(no >= no5 && no < 45){ noList5.add(one); }
	    		if(no >= no6) { noList6.add(one); }
	    	}
	    	map.put("noList1",noList1);
	    	map.put("noList2",noList2);
	    	map.put("noList3",noList3);
	    	map.put("noList4",noList4);
	    	map.put("noList5",noList5);
	    	map.put("noList6",noList6);
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
