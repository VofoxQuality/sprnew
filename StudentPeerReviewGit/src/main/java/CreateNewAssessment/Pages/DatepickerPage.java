package CreateNewAssessment.Pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import SPRautomation.StudentPeerReview.basePage;

public class DatepickerPage extends basePage {
 public String currentdate="//form/div[2]/div[2]/div/div[1]/div[1]/div[1]/div/p-calendar/span/input";
 public String comingdate="//form/div[2]/div[2]/div/div[2]/div/div[1]/div/p-calendar/span/input";
 
 
 
 public String currenttime="//form/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/p-calendar/span/input";
 public String gettime(String locator1,String locator2) {
	 try {

			DateTimeFormatter format=DateTimeFormatter.ofPattern("hh:mm");
			String	pretime=getValue(locator1).substring(0,5);
			System.out.println(pretime);
			String Pasttime=getValue(locator2).substring(0,5);
			System.out.println(Pasttime);
			LocalDate time1=LocalDate.parse(Pasttime,format);
			LocalDate time2=LocalDate.parse(pretime,format);
		  
				long daysbet= ChronoUnit.HOURS.between(time1, time2);
				System.out.println(daysbet);
			
			String time= String.valueOf(daysbet);
			System.out.println(time);
			return time;
			
	
	
 }
	 catch (Exception ignored) {

			return null;
		}
}
 public String getTime(String locator1,String locator2) {
	 
	 try {
	 String	pretime=getValue(locator1).substring(0,5);
		System.out.println(pretime);
		String Pasttime=getValue(locator2).substring(0,5);
		
	 SimpleDateFormat df = new SimpleDateFormat("hh:mm");
	 
	 Date time1=df.parse(pretime);
	 Date time2=df.parse(Pasttime);
	 
	 long dm=Math.abs(time2.getTime()- time1.getTime());
	 
	 long difference=(dm/(60*60*1000))%24;
	 
	 String time= String.valueOf(difference);
	 System.out.println(time);
	 return time;
 }

	 catch (Exception ignored) {

			return null;
	 }
 }
}