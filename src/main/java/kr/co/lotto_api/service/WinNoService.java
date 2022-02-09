package kr.co.lotto_api.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.co.lotto_api.mapper.WeekBatch;
import kr.co.lotto_api.mapper.WinNo;
import kr.co.lotto_api.model.BallNoVO;
import kr.co.lotto_api.model.OddEvenVO;
import kr.co.lotto_api.model.WinNoVO;

@Service
@Repository
public class WinNoService extends AbstractService implements ServiceImpl{
   
	
	@Autowired
	private WinNo winNo;
	
	@Resource
	private WeekBatch weekBatch;
	
	@Override
	public void insert(Map<String, Object> map) {
		winNo.insert(map);
		weekBatch.updateLottoNo();
		weekBatch.updateBallNo();
		weekBatch.updateOddNo();
		weekBatch.updateSumNo();
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
	
	public List<BallNoVO> selectBallNoMAM(Map<String,Object> map){
		return winNo.selectBallNoMAM(map);
	}
	public List<BallNoVO> selectBallNoVO(Map<String,Object> map){
		return winNo.selectBallCntPerNo(map);
	}
	
	public List<OddEvenVO> selectOddEven(){
		return winNo.selectOddEven();
	}
	
	public List<WinNoVO> selectSumCnt(){
		return winNo.selectSumCnt();
	}
	
}
