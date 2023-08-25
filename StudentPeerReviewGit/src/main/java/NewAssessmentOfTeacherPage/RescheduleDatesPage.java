package NewAssessmentOfTeacherPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.testng.Assert;

import SPRautomation.StudentPeerReview.basePage;

public class RescheduleDatesPage extends basePage {

	// button
	public String add_quest_btn = "//button[@id='addPage']";
	public String threedot_btn = " div.custom-splitbutton> p-splitbutton > div > button:nth-child(2)";
	public String cancel_btn = "//*[@id='cancelSchedulebtn']/button";
	public String cancel_btn1="//*[@id='cancelSchedulebtn']/button/span[2]";

	public String applychanges_btn = "div.position-absolute > p-button:nth-child(2) > button";
	public String close_btn = "div.ng-star-inserted > p-dialog > div > div > div.p-dialog-header > div > button > span";
	//public String close_btn="//span[@class='p-dialog-header-close-icon ng-tns-c76-20 pi pi-times']";
	public String confcontinue_btn = "#tstScheduleConfirmation > div > div > div > button:nth-child(1)> span.p-button-label";
	public String confdiscard_btn = "#tstScheduleConfirmation > div > div > div > button:nth-child(2)> span.p-button-label";
	public String timeadjust = "//p-calendar[@id='testEndTimeCalendar']/span/div/div/div[3]/button[1]";
	public String assesment_duetime="//*[@id=\"testEndTimeCalendar\"]/span/div/div/div[1]/button[1]/span";
	// searchbox
	public String search_box = "span.p-input-icon-left.ml-auto.common-search > input";

	// label
	public String newasses_lbl = " div > p-dataview > div > div> div > div:nth-child(1) > div > div > p.font-weight-bold";
	public String course_lbl = "div > p-dataview > div > div > div > div:nth-child(1) > div > div > p:nth-child(3)";
	public String reschedyledate_lbl = " div.ng-star-inserted > p-dialog > div > div>div>span>p-header";

	public String testwindow_lbl = " div.reschedule-inner > form > div > div:nth-child(1) > h5";
	public String assessopen_lbl = " div.reschedule-inner> form > div > div:nth-child(1) > div > div:nth-child(1) > label";
	public String assessdue_lbl = " div.reschedule-inner> form > div > div:nth-child(1) > div > div:nth-child(2) > label";

	public String peerreview_lbl = " div.reschedule-inner > form > div > div:nth-child(2) > h5";
	public String peeropen_lbl = "div.reschedule-inner > form > div > div:nth-child(2) > div > div:nth-child(1) > label";
	public String peerdue_lbl = "div.reschedule-inner > form > div > div:nth-child(2) > div > div:nth-child(2)> label";

	public String resultpub_lbl = "#resultPublishingDiv > div > div:nth-child(1) > div > h5";
	public String resultpubdate_lbl = "#resultPublishingDiv > div > div.col-lg-6.pl-0 > div > label";
	
	public String manualpublishcard_txt = "div.assessment-details-dates.result-section-labels > p.align-items-center > span";
	public String reconsiderlbl="div > div.assessment-details-dates.result-section-labels > p:nth-child(2) > span";

	public String lastdate_lbl = "#reconsiderationDivSection > div > h5";
	public String lastdaterecon_lbl = "#reconsiderationDivSection > div > label";
	public String dayfrom_txt = "//div[@id='recon-time']/p";
	
	//Infostatements
	public String infotext1 = "//div[@id='testDateTimeSectionMain']//p";
	public String infotext2 = "//div[@id='peerDateTimeSectionMain']//p";
	public String manualpublish_txt = "//p[@id='result-method-text']";

	// card
	public String newcard = "div.p-dataview-content > div > div > div:nth-child(1)";
	public String reschedulemenu = "div.custom-splitbutton.ml-auto > p-splitbutton > div > p-menu > div > ul > li:nth-child(1) > a";
	public String reschedulepopup = " div.ng-star-inserted > p-dialog > div > div";
	// click apply Changes button
	public String Applychangesbtn="div.position-absolute > p-button:nth-child(2) > button";
	
	// textboxes
	public String assessmentopendate_txtbx = "//p-calendar[@id='testStartDateCalendar']//span//input";
	public String assessmentopentime_txtbx = "p-calendar#testStartTimeCalendar>span>input";
	public String assessmentduedate_txtbx = "p-calendar#testEndDateCalendar>span>input";
	public String assessmentduetime_txtbx = "p-calendar#testEndTimeCalendar>span>input";

	public String peerreviewopendate_txtbx = "p-calendar#peerStartDateCalendar>span>input";
	public String peerreviewopentime_txtbx = "p-calendar#peerStartTimeCalendar>span>input";
	public String peerreviewduedate_txtbx = "p-calendar#peerEndDateCalendar>span>input";
	public String peerreviewduetime_txtbx = "p-calendar#peerEndTimeCalendar>span>input";

	public String resultpublishdate_txtbx = "p-calendar#resultStartDateCalendar>span>input";
	public String resultpublishtime_txtbx = "p-calendar#resultStartTimeCalendar>span>input";

	public String lastdate_txtbx = "p-calendar#reconsiderDateCalendar>span>input";
	public String lastdatetime_txtbx = "//p-calendar[@id='reconsiderDateTime']//input";
	public String day_drop_txtbx = "//p-dropdown[@id='reconsiderDayVal']/div/input";
	public String testduetime_txtbx = "//p-calendar[@id='testEndTimeCalendar']";

	public String reconsiderationdat_txtbx = "p-calendar#spReconsiderDateFieldCalendar>span>input";
	public String reconsiderationtime_txtbx = "p-calendar#spReconsiderTimeCalendar>span>input";
	
	// Calendar value
	public String calanderdate_val = "//td[contains(@class,'p-datepicker-today')]";
	
	public String calanderdate_val2="//span[contains(@class,'p-highlight')]//following::td[1]";
	public String calanderdate_valtomo = "//td[contains(@class,'p-datepicker-today')]//following::td[1]";

	// time picker buttons
	public String assesshourarrow = "#testStartTimeCalendar > span > div > div > div.p-hour-picker > button:nth-child(3) > span";
	public String assessminarrow = "#testStartTimeCalendar > span > div > div > div.p-minute-picker > button:nth-child(1) > span";

	public String assessduehourarrow = "#testEndTimeCalendar > span > div > div > div.p-hour-picker > button:nth-child(3) > span";
	public String assessdueminarrow = "#testEndTimeCalendar > span > div > div > div.p-minute-picker> button:nth-child(1) > span";

	public String peerhourarrow = "#peerStartTimeCalendar > span > div > div > div.p-hour-picker > button:nth-child(3)";
	public String peerminarrow = "#peerStartTimeCalendar > span > div > div > div.p-minute-picker > button:nth-child(1) > span";

	public String peerduehourarrow = "#peerEndTimeCalendar > span > div > div > div.p-hour-picker > button:nth-child(3) > span";
	public String peerdueminarrow = "#peerEndTimeCalendar > span > div > div > div.p-minute-picker> button:nth-child(1) > span";

	public String resultduehourarrow = "#resultStartTimeCalendar > span > div > div > div.p-hour-picker > button:nth-child(3) > span";
	public String resultdueminarrow = "##resultStartTimeCalendar > span > div > div > div.p-minute-picker> button:nth-child(3) > span";

	public String recons_time_minarrow = "//p-calendar[@id='reconsiderDateTime']/span//div/div[3]/button[1]";
	public String lastduehourarrow = "#reconsiderTimeCalendar > span > div > div > div.p-hour-picker > button:nth-child(3) > span";

	// popup
	public String conf_dlgbx = "#tstScheduleConfirmation > div > div";

	public String getdate(String locator, int num, int num2) {

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("MMM d, yyyy");
		String predate = getText(locator).substring(num, num2);

		System.out.println(predate);
		LocalDate date2 = LocalDate.parse(predate, dt);
		DateTimeFormatter dtt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return dtt.format(date2);
	}
	public String gettodaydate() {
	 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
	 
	 //get current date time with Date()
	 Date date = new Date();
	 
	 // Now format the date
	 String date1= dateFormat.format(date);
	return date1;
	 
	}
}
