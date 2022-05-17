package kr.co.lotto_api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import kr.co.lotto_api.model.BallNoRateVO;
import kr.co.lotto_api.model.BallNoVO;
import kr.co.lotto_api.model.OddEvenVO;
import kr.co.lotto_api.model.WinNoVO;
/**
 * 
 * 
 * @author KimJaeMoon
 *
 */
@Mapper
public interface WinNo {

  public List<WinNoVO> selectList(Map<String,Object> map);
  public WinNoVO selectOne(Map<String,Object> map);
  public int insert(Map<String,Object> map);
  public int update(Map<String,Object> map);
  public int delete(Map<String,Object> map);

  
  /**
   *  공순서별 최저/평균/최고
   * @param map
   * @return
   */
  public List<BallNoVO> selectBallNoMAM(Map<String,Object> map);
  /**
   * 공순서별 출현 수
   * @param map
   * @return
   */
  public List<BallNoVO> selectBallCntPerNo(Map<String,Object> map);
  
  
  /** 홀짝 비율
   * @return
   */
  public List<OddEvenVO> selectOddEven();
  
  /**
   * 회차 합 갯수
   */
  public List<WinNoVO> selectSumCnt();
  
  public BallNoRateVO selectPreviousAppearance();
}
