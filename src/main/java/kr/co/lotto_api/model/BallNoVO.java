package kr.co.lotto_api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BallNoVO{
	
	private int ballNo;		//공 번호
	private int cnt1,cnt2,cnt3,cnt4,cnt5,cnt6; //각 자리별 출현수
	
}
