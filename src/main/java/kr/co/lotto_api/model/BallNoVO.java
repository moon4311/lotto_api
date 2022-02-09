package kr.co.lotto_api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BallNoVO{
	
	private String  ballNo;			//공 번호
	private int 	seq1Cnt,	//각 자리별 출현수
						seq2Cnt,
						seq3Cnt,
						seq4Cnt,
						seq5Cnt,
						seq6Cnt;	
	
}
