package kr.co.lotto_api.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.co.lotto_api.mapper.Stats;
import kr.co.lotto_api.mapper.WeekBatch;
import kr.co.lotto_api.mapper.WinNo;
import kr.co.lotto_api.model.BallNoRateVO;
import kr.co.lotto_api.model.BallNoVO;
import kr.co.lotto_api.model.OddEvenVO;
import kr.co.lotto_api.model.WinNoVO;

@Service
@Repository
public class WinNoService extends AbstractService implements ServiceImpl{
   
	
	@Autowired
	private WinNo winNo;
	
	@Resource
	private Stats stats;
	
	@Resource
	private WeekBatch weekBatch;
	
	@Override
	public JSONObject insert(Map<String, Object> map) {
		winNo.insert(map);
		weekBatch.updateLottoNo();
//		weekBatch.updateBallNo();
		weekBatch.updateBallNoRate();
		weekBatch.updateOddNo();
		weekBatch.updateSumNo();
		return _jsonOk;
	}
	
	@Override
	public JSONObject update(Map<String, Object> map) {
		winNo.update(map);
		return _jsonOk;
	}
	@Override
	public JSONObject delete(Map<String, Object> map) {
		winNo.delete(map);
		return _jsonOk;
	}
	
	public WinNoVO selectOne(Map<String,Object> map) {
		return winNo.selectOne(map);
	}
	
	public int selectCount(Map<String,Object> map) {
	  return winNo.selectCount(map);
	}
	
	public List<WinNoVO> selectList(Map<String,Object> map){
		return winNo.selectList(map);
	}
	
	public List<BallNoVO> selectElementWinNo(Map<String,Object> map){
		return stats.selectElementWinNo(map);
	}
	public List<BallNoVO> selectBallNoVO(Map<String,Object> map){
		return winNo.selectBallCntPerNo(map);
	}
	
	public List<OddEvenVO> selectOddEven(){
		return stats.selectOddEven();
	}
	
	public List<WinNoVO> selectSumCnt(){
		return winNo.selectSumCnt();
	}
	
	/**
	 *  자리별 통계( ball_no_rate_tb )
	 */
	public List<BallNoRateVO> selectBallNoRateList(Map<String,Object> map){
		return stats.selectBallNoRateList(map);
	}
	
}
