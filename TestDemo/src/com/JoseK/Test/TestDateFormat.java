package com.JoseK.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestDateFormat {


	public static void main(String[] args) throws ParseException {
		
		//测试format
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = df.format(new Date());
		System.out.println(str);		
		//测试parse
		/*DateFormat format = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
		Date date = null;
		String str = "2018:4:11 17:00:00";
		date = format.parse(str);
		System.out.println(date);
		System.out.println(date.getTime());*/
	}

}
