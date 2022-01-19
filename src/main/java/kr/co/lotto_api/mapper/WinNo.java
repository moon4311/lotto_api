package kr.co.lotto_api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

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
  
}
