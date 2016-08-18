package chapter2;

/**
 * Created by michael.song on 8/17/2016.
 */

import java.util.*;
import java.util.Calendar.*;

public class Days {
	public static void main(String args[]){
		Calendar cal = new GregorianCalendar();
		Calendar drJavaCal = new GregorianCalendar(1995,Calendar.JANUARY, 1);
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH)+1;
		int weekday = cal.get(Calendar.DAY_OF_WEEK)-1;
		System.out.println(month + " " + dayOfMonth + " weekday: " + weekday);
		System.out.println("Days betweeen:"+daysBetween(drJavaCal.getTime(), cal.getTime()));
	}

	private static int daysBetween(Date d1, Date d2){
		return (int)((d2.getTime() - d1.getTime())/(1000*60*60*24));
	}
}
