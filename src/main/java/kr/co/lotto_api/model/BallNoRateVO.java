package kr.co.lotto_api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BallNoRateVO{
	
	// no1 ~no6 공 위치
	// total : 전체 경우
	// rslt : 당첨번호의 경우
	// cnt : 수
	// rate : 비율
	
	private String  ballNo;			//공 번호
	private int 	no1TotalCnt,no1RsltCnt;
	private int 	no2TotalCnt,no2RsltCnt;
	private int 	no3TotalCnt,no3RsltCnt;
	private int 	no4TotalCnt,no4RsltCnt;
	private int 	no5TotalCnt,no5RsltCnt;
	private int 	no6TotalCnt,no6RsltCnt;
	
	private String no1TotalRate,no1RsltRate;
	private String no2TotalRate,no2RsltRate;
	private String no3TotalRate,no3RsltRate;
	private String no4TotalRate,no4RsltRate;
	private String no5TotalRate,no5RsltRate;
	private String no6TotalRate,no6RsltRate;
	
	
}
