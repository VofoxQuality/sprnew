package CreateNewAssessment.Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Course.Pages.CreateNewCoursePage;
import SPRautomation.StudentPeerReview.basePage;

public class SchedulePageBasicsPage extends basePage {

	// wizard
	public String schedule_wizard = "//*[@id='stepperDiv']/p-steps/div/ul/li[4]";
	public String summary_wizard = "#stepperDiv > p-steps > div > ul > li.p-steps-item.ng-star-inserted.p-back.p-highlight.p-steps-current.p-disabled";
	public String basic_detail_wizard="//div[@id='stepperDiv']//p-steps//div//ul//li[1]";
	// Reward score
	public String RewardScore = "#rewardScore";
	
	//allow reconsider checkbox
	public String allowreconsiderchkbx="#reconsiderRequest > div";
	
	// label
	public String Sbassessmentname_lbl = "#tstScheduleAssessmentDetailsSection > h6";
	public String scheduleassesment_lbl="//*[@id='tstScheduleAssessmentDetailsSection']//h6";
	public String Sbassessmentname_lbl2 = "//div[@id='tstScheduleAssessmentDetailsSection']";
	public String Sbassessmentname_value = "//div[@id='tstScheduleAssessmentDetailsSection']/h6/span";
	public String Sbcoursename_lbl = "//div[@id='tstScheduleAssessmentDetailsSection']/p";
	public String totalques_lbl = "//div[@id='spTotalquestions']/label";
	public String selectstu_lbl = " div.pt-4.schedule-main > div.d-flex > h4";
	public String studentscan_lbl = " div.pt-4.schedule-main > div:nth-child(2) > p";
	public String testwin_lbl = " div.pt-4.schedule-main > div:nth-child(2) > h5";
	public String assessmentopen_lbl = "//div[@id='spTestOpenDateTime']/label";
	public String assessmentdue_lbl = "//div[@id='spTestDueDateTime']/label";

	public String studentscan_lbl2 = " div.pt-4.schedule-main > div:nth-child(3) > p";
	public String peerreview_lbl = " div.pt-4.schedule-main > div:nth-child(3) > h5";
	public String peerreviewopen_lbl = " div.pt-4.schedule-main > div:nth-child(3) > div > div.col-lg-6.pr-5 > label";
	public String peerreviewopenLabel = "//*[@id=\"spPeerWindowMainDiv\"]/div/div[1]/label";
	public String peerreviewdue_lbl = " div.pt-4.schedule-main > div:nth-child(3) > div > div.col-lg-6.pl-5 > label";
	public String peerreviewDueLabel = "//*[@id=\"spPeerWindowMainDiv\"]/div/div[2]/label";

	public String resultpublish_lbl = "div .pt-4.schedule-main > div:nth-child(4) > h5";
	public String resultpublishdate_lbl = "#auto-publish-date-sec > label";
	public String teachermanua_lbl = "#teacherPublishRdBtn";
	public String allowstudent_lbl = "#reconsiderationDiv > div > div > p > span";
	public String lastdate_lbl = "#reconsiderationDiv > div > div > div > h5";
	public String lastdatestu_lbl = "#reconsiderationDiv > div > div > div > label";
	public String dayfromresult_lbl = "//div[@id='recon-time']/p";

	public String quescount_lbl = " div.d-flex > div:nth-child(1) > p-badge > span";
	public String maxscore_lbl = "//div[@id='spMaximumScorePossible']/label";
	public String maxscorecount = "//div[@id='spMaximumScorePossible']/p-badge/span";

	public String mailnotifi_lbl = "div.d-flex > div > span.d-flex.align-items-center.mr-4 > label";
	public String notifiactive_lbl = " div.white-box.notification-box > div.border-top.pt-3.mt-3 > div > label";
	public String notifyActiveLabel = "//*[@id=\"mainSchedulePageTeacher\"]/form/div[2]/div[5]/div[1]/div/div/label";
	public String confignoti_lbl = " div.pt-4.schedule-main > h6";
	public String Wnewassess_lbl = "//p-checkbox[@id='assessmentPublished']//following::label[1]";
	public String Wtestandpeer_lbl = "//p-checkbox[@id='assessmentPublished']//following::label[2]";
	public String Wtestnpeerclose_lbl = "//p-checkbox[@id='assessmentPublished']//following::label[3]";
	public String Wtestnpeermodi_lbl = "//p-checkbox[@id='assessmentPublished']//following::label[4]";
	public String Wresultpub_lbl = "//p-checkbox[@id='assessmentPublished']//following::label[5]";
	public String Wteachresolve_lbl = "//p-checkbox[@id='assessmentPublished']//following::label[6]";
	public String confirm_lbl = "//p-confirmdialog[@id='tstStepConfirm']/div/div/div[2]/span";
	public String confirm_lbl2 = "//p-confirmdialog[@id='tstStepConfirm']/div/div/div[2]/span";
	public String schedulefor_lbl = "//div[@id='mainSchedulePageTeacher']//div[2]/div[1]/h4";

	// Button
	public String clearall_btn = "#clear-all-btn";
	public String configuredef_btn = "#configure-def-btn";
	public String apply_btn = "#apply-def-btn";
	public String confyes_btn = "//p-confirmdialog[@id='tstStepConfirm']/div/div/div[3]/button[2]/span[2]";
	public String confno_btn = "//p-confirmdialog[@id='tstStepConfirm']/div/div/div[3]/button[1]/span[2]";
	public String confcontinue_btn = "//p-confirmdialog[@id='tstStepConfirm']/div/div/div[3]/button[1]/span[2]";
	public String confdiscard_btn = "//p-confirmdialog[@id='tstStepConfirm']/div/div/div[3]/button[2]/span[2]";

	// textboxes
	// textboxes
	public String assessmentopendate_txtbx = "//p-calendar[@id='spTestStartDateCalendar']/span/input";
	public String assessmentopentime_txtbx = "//p-calendar[@id='spTestStartTimeCalendar']/span/input";
	public String assessmentduedate_txtbx = "//p-calendar[@id='spTestEndDateCalendar']/span/input";
	public String assessmentduetime_txtbx = "//p-calendar[@id='spTestEndTimeCalendar']/span/input";
	public String assesmentopendate_summarypage="//div[@id='result-method-section']//following::p-calendar[1]";
	public String assesmentopentime_summarypage="//div[@id='result-method-section']//following::p-calendar[2]";

	public String peerreviewopendate_txtbx = "//p-calendar[@id='spPeerStartDateCalendar']/span/input";
	public String peerreviewopentime_txtbx = " div.pt-4.schedule-main > div:nth-child(3) > div > div.col-lg-6.pr-5 > div.row > div:nth-child(2)>div>p-calendar>span>input";
	public String peerreviewopentime_txtbx1 ="//*[@id='spPeerStartTimeCalendar']/span/input";
	public String peerreviewduedate_txtbx = "//p-calendar[@id='spPeerEndDateCalendar']/span/input";
	public String peerreviewduetime_txtbx = "//p-calendar[@id='spPeerEndTimeCalendar']/span/input";

	public String resultpublishdate_txtbx = "//p-calendar[@id='spResultStartDateCalendar']/span/input";
	public String resultpublishtime_txtbx = "//p-calendar[@id='spResultStartTimeCalendar']/span/input";

	public String lastdate_txtbx = "lastdate_txtbx";
	public String lastdatetime_txtbx = "lastdatetime_txtbx";
	
	public String lasttime_txtbx = "//p-calendar[@id='reconsiderDateTime']/span/input";
	public String lasttime_select_bx = "//p-calendar[@id='reconsiderDateTime']/span/input";
	
	public String day_drop_txtbx = "//p-dropdown[@id='reconsiderDayVal']/div/input";
	
	// checkbox

	public String mailnotifi_checkbx = "#mailNotification > div > div.p-checkbox-box.p-highlight";
	public String mailnotifi_checkbx2 = "#mailNotification > div > div.p-checkbox-box";
	public String allowstu_checkbx = "#reconsiderRequest > div > div.p-checkbox-box.p-highlight";
	public String allowstu_checkbx2 = "#reconsiderRequest > div > div.p-checkbox-box";
	public String Wnewassess_checkbx = "#assessmentPublished > div > div.p-checkbox-box.p-highlight";
	public String Wnewassess_checkbx2 = "#assessmentPublished > div > div.p-checkbox-box ";
	public String Wtestandpeer_checkbx = "#testOrPeerActive > div > div.p-checkbox-box.p-highlight";
	public String Wtestnpeerclose_checkbx = "#testOrPeerWindowClosed > div > div.p-checkbox-box.p-highlight";
	public String Wtestnpeermodi_checkbx = "#testOrPeerDateTimeModified > div > div.p-checkbox-box.p-highlight";
	public String Wresultpub_checkbx = "#resultPublishedBy > div > div.p-checkbox-box.p-highlight";
	public String Wteachresolve_checkbx = "#resolvesReconsiderationRequest > div > div.p-checkbox-box.p-highlight";

	//dropdown 
	public String day_recons_dropdwn = "//p-dropdown[@id='reconsiderDayVal']/div/div[2]";
	public String dropvalue = "//p-dropdown[@id='reconsiderDayVal']/div/div[3]/div/ul/p-dropdownitem";
	public String zero_day_dropdwn = "//p-dropdown[@id='reconsiderDayVal']/div/div[3]/div/ul/p-dropdownitem[1]/li";
	
	
	// Radio button
	public String teacherwill_radio = "#manualPublishRadioBtn > div > div.p-radiobutton-box";
	
	public String teachwill_radio_select = "//p-radiobutton[@id='manualPublishRadioBtn']/div";
	public String resultpublish_radio = "#automatic-publish-rdbutton > div > div.p-radiobutton-box";

	// allow student section
	public String allowstu_section = "#reconsiderationDiv > div > div > div";

	// validation message
	public String mailvali_msg = "div.pt-4.schedule-main > div.white-box.notification-box > div:nth-child(3)";

	// toaster
	public String mailsave_toaster = "//div[contains(@class,'p-toast-detail')]";

	// confirmation dilogurbox
	public String conf_dlgbx = "//p-confirmdialog[@id='tstStepConfirm']/div/div";
	public String prconf_dlgbx = "//p-confirmdialog[@id='tstStepConfirm']/div/div";

	// datepicker

	public String assessopen_calendar = "#spTestStartDateCalendar> span > div > div > div";
	public String assessmentOpenclndr = "//p-calendar[@id='spTestStartDateCalendar']/span";
	public String assessdue_calendar = "#spTestEndDateCalendar > span > div > div";
	public String Assessdue_calendar = "//p-calendar[@id='spTestEndDateCalendar']/span";
	public String peeropen_calendar = "#spPeerStartDateCalendar > span > div > div > div";
	public String peerOpen_calendar = "//p-calendar[@id='spPeerStartDateCalendar']/span";
	public String peerdue_calendar = "#spPeerEndDateCalendar > span > div > div > div";
	public String peerDue_calendar = "//p-calendar[@id='spPeerEndDateCalendar']/span";
	public String resultpublish_calendar = "#spResultStartDateCalendar > span > div > div > div";
	public String resultPublishclndr = "//p-calendar[@id='spResultStartDateCalendar']/span";
	public String allowstu_calendar = "#spReconsiderDateFieldCalendar > span > div > div > div";

	public String calanderdate_val = "//td[contains(@class,'p-datepicker-today')]";
	
	//Timeadjust button
	
	public String reviewopen_timeadjust = "//p-calendar[@id='spPeerStartTimeCalendar']/span//div[3]/button[1]";
	public String reviewdue_timeadjust ="//p-calendar[@id='spPeerEndTimeCalendar']/span//div[3]/button[1]";
	public String resulttime_adjust = "//p-calendar[@id='spResultStartTimeCalendar']/span//div[3]/button[1]";
	
	
	// time picker
	public String timepicker = "//p-calendar[@id='spTestEndTimeCalendar']/span/div/div";
	public String timedes_arrow = " div.p-minute-picker> button:nth-child(3)";
	public String hour_label = "div.p-hour-picker > span";
	public String minute_label = "div.p-minute-picker> span";
	public String am_label = "div.p-ampm-picker> span";

	public String timepicker2 = "//p-calendar[@id='spPeerEndTimeCalendar']/span/div/div";
	public String timedes_arrow2 = "div.p-minute-picker> button:nth-child(3)";
	public String hour_label2 = "div.p-hour-picker > span";
	public String minute_label2 = " div.p-minute-picker> span";
	public String am_label2 = "div.p-ampm-picker> span";

	public String peertimepicker = "#spPeerStartDateCalendar > span > div > div";
	public String peertimeasc_arrow = "div.p-hour-picker> button:nth-child(1) > span";
	public String peerhour_label = "div.p-hour-picker> span";
	public String peerminute_label = " div.p-minute-picker> span";
	public String peeram_label = "div.p-ampm-picker> span";

	public String Assessopenfilledtime = "//p-calendar[contains(@class,'p-inputwrapper-filled') and @id='spTestStartTimeCalendar'] ";
	public String Assessduefilledtime = "//p-calendar[contains(@class,'p-inputwrapper-filled') and @id='spTestEndTimeCalendar'] ";

	public String peeropenfilledtime = "//div[@id='spPeerOpenTimeField']//p-calendar[contains(@class,'p-inputwrapper-filled') and @id='spPeerStartDateCalendar'] ";
	public String peerOpenFilledTime = "//p-calendar[contains(@class,'p-inputwrapper-filled ') and @id='spPeerStartTimeCalendar']";
	public String peerduefilledtime = "//p-calendar[contains(@class,'p-inputwrapper-filled ') and @id='spPeerEndTimeCalendar'] ";

	public String resultfilledtime = "//p-calendar[contains(@class,'p-inputwrapper-filled') and @id='spResultStartTimeCalendar'] ";;
	public String Allowstfilledtime = "#spReconsiderTimeCalendar";

	public String Assessopenfilledtime2 = "//p-calendar[contains(@class,'p-inputwrapper-filled ng-valid') and @id='spTestStartTimeCalendar'] ";
	public String Assessduefilledtime2 = "//p-calendar[contains(@class,'p-inputwrapper-filled ng-valid') and @id='spTestEndTimeCalendar'] ";

	public String peeropenfilledtime2 = "//div[@id='spPeerOpenTimeField']//p-calendar[contains(@class,'p-inputwrapper-filled ng-valid') and @id='spPeerStartDateCalendar'] ";
	public String peerduefilledtime2 = "//p-calendar[contains(@class,'p-inputwrapper-filled ng-valid') and @id='spPeerEndTimeCalendar'] ";

	public int getMonthNumber(String monthname) {

		return Month.valueOf(monthname.toUpperCase()).getValue();
	}

	public String getTime(int number) {

		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, number);

		SimpleDateFormat df = new SimpleDateFormat("hh:mm");
		// String l=df.format(now.getTime());
		return df.format(now.getTime());
	}

	public String geTtimedifference(String locator1, String locator2) {

		try {
			String pretime = getValue(locator1).substring(0, 5);
			System.out.println(pretime);
			String Pasttime = getValue(locator2).substring(0, 5);

			SimpleDateFormat df = new SimpleDateFormat("hh:mm");

			Date time1 = df.parse(pretime);
			Date time2 = df.parse(Pasttime);

			long dm = Math.abs(time2.getTime() - time1.getTime());

			long difference = (dm / (60 * 60 * 1000)) % 24;

			String time = String.valueOf(difference);
			System.out.println(time);
			return time;
		}

		catch (Exception ignored) {

			return null;
		}
	}

	public String geTtimedifferenceminute(String locator1, String locator2) {

		try {
			String pretime = getValue(locator1).substring(0, 5);
			System.out.println(pretime);
			String Pasttime = getValue(locator2).substring(0, 5);
			System.out.println(Pasttime);
			SimpleDateFormat df = new SimpleDateFormat("hh:mm");

			Date time1 = df.parse(pretime);
			Date time2 = df.parse(Pasttime);

			long dm = Math.abs(time2.getTime() - time1.getTime());

			long difference = (dm / (60 * 1000)) % 60;

			String time = String.valueOf(difference);
			System.out.println(time);
			return time;
		}

		catch (Exception ignored) {

			return null;
		}
	}

	public String getdate() {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public String getdatedifference(String locator1, String locator2) {

		try {

			DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			String predate = getValue(locator1);
			System.out.println(predate);
			String Pastdate = getValue(locator2);
			System.out.println(Pastdate);
			LocalDate date1 = LocalDate.parse(Pastdate, format);
			LocalDate date2 = LocalDate.parse(predate, format);
			long daysbet = ChronoUnit.DAYS.between(date2, date1);
			String period = String.valueOf(daysbet);

			return period;

		} catch (Exception ignored) {

			return null;
		}

	}

	// for retest
	public String minuteval = "//*[@id='spTestStartTimeCalendar']/span/div/div/div[3]/span";
	public String btn_minuteassessdue = "//*[@id='spTestEndTimeCalendar']/span/div/div/div[3]/button[1]/span";
	public String btn_minuteassessopen = "//*[@id='spTestStartTimeCalendar']/span/div/div/div[3]/button[1]/span";

	public String btn_minutepeerdue = "//*[@id='spPeerEndTimeCalendar']/span/div/div/div[3]/button[1]/span";
	public String buttondd = " button.p-datepicker-prev.p-link.p-ripple.ng-star-inserted > span";
	public String ddcal = "select.p-datepicker-month.ng-star-inserted";

CreateNewCoursePage cn=new CreateNewCoursePage();
QuestionPageBasicsPage QP=new QuestionPageBasicsPage();



public void Invitestudentstocourse(String coursename,String Student1email,String Student2email){
	
	// type-Course title
	type(cn.txbx_Coursetitle, coursename);
	
	//click Add students to course button
	click(cn.btn_AddStudents);
	waitThread(1000);
	
	type(cn.tab_textbox, Student1email + ",");
	
	driver.findElement(By.xpath(cn.emailtype_txt)).sendKeys(Keys.SPACE);
	
	type(cn.tab_textbox, Student2email + ",");
	waitThread(3000);
	// click on add to list button
	click(cn.tab_btn_Addtolist);
	waitThread(3000);
	//click(cn.confirmyesbtn);
	driver.findElement(By.xpath(cn.confirmyesbtn)).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	click("//p-tabview/div/ul/li[3]/a/span[2]");
	waitThread(1000);
	click("//button[@id='sendRequestId']");
	waitThread(1000);
	// click on create course button
	click(cn.btn_Createcourse);
	waitThread(1000);
	 waitFor(cn.toaster);			
	 // verify toaster-Course created successfully
	 Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");
	 click(QP.toasterclosebtn);
}
}









