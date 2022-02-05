package kr.co.lotto_api.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WinNoVO{
	
	private int drwNo; //회차
	private String dt; //추첨일
	@JsonIgnore
	private int 	ballNo1,
						ballNo2,
						ballNo3,
						ballNo4,
						ballNo5,
						ballNo6,
						ballNo7;
	private int sum;
	private int[] nos ;
	
	public void setBallNo7(int no7) {
		this.ballNo7 = no7;
		this.nos = new int[]{ballNo1,ballNo2,ballNo3,ballNo4,ballNo5,ballNo6,ballNo7};
	}

	@Override
	public String toString() {
		return "{drwNo:" + drwNo + ", dt:" + dt + ", nos:" + Arrays.toString(nos) + "}";
	}
}
