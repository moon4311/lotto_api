package kr.co.lotto_api.mapper;

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
	public int updateLottoNo();
	
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
