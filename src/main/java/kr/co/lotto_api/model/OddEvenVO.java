package kr.co.lotto_api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OddEvenVO {
	
	//회차
	private int drwNo;
	
	// 홀수 0개 ~ 홀수 6개 의 출현수
	private int cnt0,cnt1,cnt2,cnt3,cnt4,cnt5,cnt6;
	
	// 비율
	private double rate0,rate1,rate2,rate3,rate4,rate5,rate6;
	

}
