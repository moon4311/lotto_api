package kr.co.colander.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OddEvenVO {
	
	//회차
	private int oddCnt;
	
	// 814 기준, 당첨번호 기준
	private String totalCnt, winCnt;
	
	// 비율
	private String totalRate, winRate;
	
	// 마지막 회차
	private String lastDrwNo;
}
