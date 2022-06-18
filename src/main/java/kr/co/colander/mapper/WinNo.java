package kr.co.colander.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import kr.co.colander.model.BallNoRateVO;
import kr.co.colander.model.BallNoVO;
import kr.co.colander.model.WinNoVO;
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
  
  /**
   * 검색 결과 수
   * @return
   */
  public int selectCount(Map<String,Object> map );
  
  /**
   * 회차 합 갯수
   */
  public List<WinNoVO> selectSumCnt();
  
  public BallNoRateVO selectPreviousAppearance();
}
