package kr.co.lotto_api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.lotto_api.model.LottoNoVO;
/**
 * 
 * 
 * @author KimJaeMoon
 *
 */
@Mapper
public interface Strategy {


	/**
	 * 추출 건수
	 * @param map
	 * @return
	 */
  public int selectCnt(Map<String,Object> map);
  
  /**
   * 추출 목록
   * @param map
   * @return
   */
  public List<LottoNoVO> selectList(Map<String,Object> map);
  
  
  public void insertHistory(Map<String,Object> map);

  public List<Map<String,Object>> selectHistoryList(Map<String,Object> map);
  public int selectHistoryCnt(Map<String,Object> map);
  public Map<String,Object> selectHistoryOne(Map<String,Object> map);
}
