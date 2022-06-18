package kr.co.colander.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LottoNoVO{
	
	private String lottoNo;		//순서.
	private int ballNo1, 
					 ballNo2,
					 ballNo3,
					 ballNo4,
					 ballNo5,
					 ballNo6; //각 자리 수
	private int sum, oddCnt; //합계 , 홀 갯수
	private String pastYn;
}
