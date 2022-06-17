package kr.co.lotto_api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
/**
 * 복권 구매이력
 * @author KimJaeMoon
 *
 */
@Mapper
public interface TicketsHistory {

  public List<Map<String,Object>> selectList(Map<String,Object> map);
  public Map<String,Object> selectOne(Map<String,Object> map);
  public int insert(Map<String,Object> map);
  
}
