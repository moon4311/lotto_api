package kr.co.lotto_api.service;

import java.util.Map;

public abstract class AbstractService {

  public boolean insertBefore(Map<String, Object> map) {
    return true;
  }
  public boolean updateBefore(Map<String, Object> map) {
    return true;
  }
  public boolean deleteBefore(Map<String, Object> map) {
    return true;
  }
  public boolean selectBefore(Map<String, Object> map) {
    return true;
  }
  
}
