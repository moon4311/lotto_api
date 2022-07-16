package kr.co.colander.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketVO {

    private String memberId;
	private int no, memberNo, drwNo; //pk, 회원번호, 회차
	private String method; // 자동/반자동/수동 :
	
	private String tr; // 일련번호
	private String no1,no2,no3,no4,no5, no6;
	private String result = "0"; //맞힌갯수 ( 보너스번호 0.5)
	
	private String url;
}
