package kr.co.lotto_api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WinNoVO{
	
	private int drwNo; //회차
	private String dt; //추첨일
	private int no1,no2,no3,no4,no5,no6,no7;
	
}
