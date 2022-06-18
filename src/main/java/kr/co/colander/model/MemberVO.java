package kr.co.colander.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	private String id;
	private String displayName, email, photoUrl;
	private String registDt, lastLoginDt;
}
