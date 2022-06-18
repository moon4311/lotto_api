package kr.co.lotto_api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.lotto_api.model.TicketVO;
/**
 * 복권 구매이력
 * @author KimJaeMoon
 *
 */
@Mapper
public interface TicketsHistory {

  public List<TicketVO> selectList(Map<String,Object> map);
  public TicketVO selectOne(Map<String,Object> map);
  public int insert(Map<String,Object> map);
  
}
