package com.dy.shoppingSite.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.enterprise.inject.New;

public class MyUntil {

	public static String getID(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
	
	public static String getNowTime(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(new Date());
		
		
	}
}
