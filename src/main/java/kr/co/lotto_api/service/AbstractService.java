package kr.co.lotto_api.service;

import java.util.Map;

import org.json.simple.JSONObject;

public abstract class AbstractService {

	public final static String _RESULT 	= "RESULT";
	public final static String _OK 			= "OK";
	public final static String _FAIL 		= "FAIL";
	public static JSONObject _jsonOk = new JSONObject() {{put(_RESULT, _OK);}};
	public static JSONObject _jsonFail = new JSONObject(){{put(_RESULT, _FAIL);}};
	
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
