package kr.co.lotto_api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.lotto_api.model.MemberVO;
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
  
}
