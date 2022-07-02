package kr.co.colander.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author KimJaeMoon
 *
 */
@Mapper
public interface WeekBatch {

	// 814.. pastYn
	public int updateLottoNo(Map<String,Object> map);
	// 당첨번호 삭제
	public int deleteWinNo( Map<String,Object> map );
	
	// 각 자리별 숫자 출현 수 v1
	@Deprecated
	public int updateBallNo();
	
	// 각 자리별 숫자 출현 수 v2
	public int updateBallNoRate();
	
	// 합계 비율
	public int updateSumNo();
	
	// 홀짝 비율
	public int updateOddNo();

}
