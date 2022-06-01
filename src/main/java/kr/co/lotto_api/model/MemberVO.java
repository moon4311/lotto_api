package kr.co.lotto_api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	private String no;
	private String memberId,memberNm;
	private String password;
	private String registDt, lastLoginDt;
}
