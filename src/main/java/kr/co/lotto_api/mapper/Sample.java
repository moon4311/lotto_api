package kr.co.lotto_api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
/**
 * 
 * 
 * @author KimJaeMoon
 *
 */
@Mapper
public interface Sample {

  public List<Map<String,Object>> selectList(Map<String,Object> map);
  public Map<String,Object> selectOne(Map<String,Object> map);
  public int insert(Map<String,Object> map);
  
}
