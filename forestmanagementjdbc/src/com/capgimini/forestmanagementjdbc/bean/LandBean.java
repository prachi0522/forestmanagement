package com.capgimini.forestmanagementjdbc.bean;

import java.io.Serializable;

import lombok.Data;
@Data
public class LandBean implements Serializable {
	
	private int landId;	
	private String landLocation;
	private int landValue;
	private String acqDate;
	@Override
	public String toString() {
		return "[ Land Id=" + landId + ", Land Location=" + landLocation + ", Land Value=" + landValue
				+ ",  aquisition date =" + acqDate + "]";
	}
	
}
 