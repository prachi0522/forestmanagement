package com.capgimini.forestmanagementjdbc.bean;

import java.io.Serializable;

import lombok.Data;

@Data
//create one bean class
public class AdminBean implements Serializable {
	//declare variables
 private String name;
 private String password;
 
}