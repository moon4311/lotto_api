package kr.co.colander.model;

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
	private int totalCnt, winCnt;		//갯수
	private String totalRate, winRate;//비율
}
