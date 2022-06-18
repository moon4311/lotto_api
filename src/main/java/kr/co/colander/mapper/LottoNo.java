package kr.co.colander.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.colander.model.LottoNoVO;
/**
 * 
 * 
 * @author KimJaeMoon
 *
 */
@Mapper
public interface LottoNo {

  public List<LottoNoVO> selectList(Map<String,Object> map);
  public int insert(Map<String,Object> map);
  
}
