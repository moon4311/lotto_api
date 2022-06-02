package kr.co.lotto_api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.co.lotto_api.mapper.LottoNo;
import kr.co.lotto_api.mapper.Strategy;
import kr.co.lotto_api.model.LottoNoVO;

@Service
@Repository
public class StrategyService extends AbstractService implements ServiceImpl {

	@Autowired
	private LottoNo lottoNo;
	
	@Autowired
	private Strategy strategty;
	
	@Override
	public void insert(Map<String, Object> map) {
		for(int a=1; a<41;a++) {
			for(int b=a+1;b<42;b++) {
				for(int c=b+1;c<43;c++) {
					for(int d=c+1;d<44;d++) {
							for(int e=d+1;e<45;e++) {
								for(int f=e+1;f<46;f++) {
									map.put("no1", a);
									map.put("no2", b);
									map.put("no3", c);
									map.put("no4", d);
									map.put("no5", e);
									map.put("no6", f);
									map.put("sum", a+b+c+d+e+f);
									lottoNo.insert(map);
								}
							}
							System.err.println(map);
					}
				}
			}
		}
	}

	@Override
	public void update(Map<String, Object> map) {
	}

	@Override
	public void delete(Map<String, Object> map) {
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
		strategty.insertHistory(map);

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
