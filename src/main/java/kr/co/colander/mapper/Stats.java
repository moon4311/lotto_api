package kr.co.colander.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import kr.co.colander.model.BallNoRateVO;
import kr.co.colander.model.BallNoVO;
import kr.co.colander.model.OddEvenVO;
import kr.co.colander.model.WinNoVO;
/**
 * 
 * 
 * @author KimJaeMoon
 *
 */
@Mapper
public interface Stats {

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
  public List<BallNoVO> selectElementWinNo(Map<String,Object> map);

  public List<BallNoRateVO> selectBallNoRateList(Map<String,Object> map);
  
  /**
   * 지난회차 포함 확율
   * @param map
   * @return
   */
  public Map<String,Object> selectContainRate(Map<String,Object> map);
  
  /** 홀짝 비율
   * @return
   */
  public List<OddEvenVO> selectOddEven();
  
}
