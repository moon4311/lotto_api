package kr.co.lotto_api.model;

import lombok.Getter;
import lombok.Setter;

/**
 * sum_no_tb
 * @author kjm
 *
 */
@Getter
@Setter
public class SumCntVO{
	
	private int sumNo; //합
	private int totalCnt, pastCnt;		//갯수
	private String totalRate, pastRate;//비율
}
