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
	private int no1,no2,no3,no4,no5,no6,no7;
	private int[] nos ;
	
	public void setNo7(int no7) {
		this.no7 = no7;
		this.nos = new int[]{no1,no2,no3,no4,no5,no6,no7};
	}

	@Override
	public String toString() {
		return "{drwNo:" + drwNo + ", dt:" + dt + ", nos:" + Arrays.toString(nos) + "}";
	}
}
