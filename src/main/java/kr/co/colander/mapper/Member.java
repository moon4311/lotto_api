package kr.co.colander.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.colander.model.MemberVO;
/**
 * 
 * 
 * @author KimJaeMoon
 *
 */
@Mapper
public interface Member {

  public List<MemberVO> selectList(Map<String,Object> map);
  public MemberVO selectOne(Map<String,Object> map);
  public int insert(Map<String,Object> map);
  public void login(Map<String,Object> map);
  
  public void delete(Map<String,Object> map);
}
