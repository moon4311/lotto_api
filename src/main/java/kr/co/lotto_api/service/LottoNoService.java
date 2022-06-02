package kr.co.lotto_api.service;

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
public class LottoNoService extends AbstractService implements ServiceImpl {

	@Autowired
	private LottoNo lottoNo;
	
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
	

}
