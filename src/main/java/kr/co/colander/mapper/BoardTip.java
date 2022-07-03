package kr.co.colander.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.colander.model.BoardVO;
/**
 * 
 * 
 * @author KimJaeMoon
 *
 */
@Mapper
public interface BoardTip {

  public List<BoardVO> selectList(Map<String,Object> map);
  public BoardVO selectOne(Map<String,Object> map);
  public int insert(Map<String,Object> map);
  
  public void delete(Map<String,Object> map);
  public void update(Map<String,Object> map);
  
}
