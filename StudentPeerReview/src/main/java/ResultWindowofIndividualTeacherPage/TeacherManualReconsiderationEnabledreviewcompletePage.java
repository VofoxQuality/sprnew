package ResultWindowofIndividualTeacherPage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import NewAssessmentOfTeacherPage.TeacherResultSectionPage;
import SPRautomation.StudentPeerReview.basePage;

public class TeacherManualReconsiderationEnabledreviewcompletePage extends basePage {

	TeacherResultSectionPage tr = new TeacherResultSectionPage();
	
	// Labels result popup
	public String reconstext = "//*[@id='reconsiderTimeLeftInDays']/p";
	public String reconsdaytime_text = "//*[@id='reconsiderTimeLeftInDays']/p/span";
	public String final_recons_txt = "//p[@id='reconRealTimer']";
	public String recons_lblcard = "//div[@id='teacherAssessmentDataView']/div//div/div[5]//div[1]/div[1]/p";
	public String result_stud_recons_txt = "//p[@id='timeLeftTxt']";
	
	public String recons_req_hd = "//div[@id='econsiderHeadingDiv']/h4";
	public String course_lbl = "//div[@id='courseBasicDetailsRecon']/h6[1]";
	public String assess_lbl = "//div[@id='courseBasicDetailsRecon']/h6[2]";
	public String pending_lbl = "//div[@id='reconCountDiv']/p[1]";
	public String process_lbl = "//div[@id='reconCountDiv']/p[2]";
	public String review_status = "//div[@id='teacherEvlauateQuestionDetails']/div[2]/p-badge/span";
	
	//Reconsideration Grid
	public String stud1grid = "//p-table[@id='questionResultListingTable']//div[1]/table//tr/td[3]/div";
	public String reconsider_btn = "//p-table[@id='questionResultListingTable']//div[1]/table//tr/td[11]/div/button";
	public String recons_status = "//p-table[@id='questionResultListingTable']//div[1]/table//tr/td[6]/div/span";
	public String score_frompeer_grid = "//p-table[@id='questionResultListingTable']//div[1]/table//tr/td[8]/div/span";
	public String totscore_grid = "//p-table[@id='questionResultListingTable']//div[1]/table//tr/td[10]/div/span";
	
	public String sys_genpopup_recon = "//p-dialog[@id='systemGeneratedCommentDialog']/div/div";
	public String stud_commment = "//p-dialog[@id='systemGeneratedCommentDialog']/div//div[2]//div/p";
	public String sys_gen_closebtn = "//p-dialog[@id='systemGeneratedCommentDialog']/div//div/div[1]//button";
	
	// Publish popup
	public String recons_txt_publishpopup = "//div[@id='resultPublishedSuccessDiv']/div/p";
	public String backresult_btn = "//button[@id='save-conf-btn']/span";

	// Button
	public String change_btn = "//a[@id='changeReconsiderDayTime']";
	public String submitbtn_recon_teach = "//button[@id='save-conf-btn']";
	public String submit_btn_reconpopup = "//div[@id='submitStudentReason']/button";
	public String recons_btn_stud = "//button[@id='raiseReconsiderButton']/span";
	public String teach_respons_btn = "//button[@id='viewTeacherCmntButton']/span";
	public String teach_respons_btn_disb = "//button[@id='viewTeacherCmntButton']";
	public String view_btn_teachcard = "//div[@id='teacherAssessmentDataView']//div/div[5]//div[1]/div[2]/button/span[2]";
	public String publish_btn_recons = "//p-button[@id='teacherReconsiderationPublishButton']/button";
	
	// Approve Total Score popup
	public String appr_scorepopup = "//p-confirmdialog[@id='tstScoreSatisfiedConfirmation']/div/div";

	// Textbox
	public String daybx_reconpopup = "//p-dropdown[@id='reconsiderDayVal']/div/input";
	public String day1_dropdwn = "//p-dropdown[@id='reconsiderDayVal']//div[3]//ul/p-dropdownitem[2]/li";
	public String day2_dropdwn = "//p-dropdown[@id='reconsiderDayVal']//div[3]//ul/p-dropdownitem[3]/li";
	public String time_minarrow = "//p-calendar[@id='reconsiderDateTime']//div//div[3]/button[1]/span";

	// Card
	public String recontxt_card = "//div[@id='teacherAssessmentDataView']//div/div/div[5]//div[2]/p[3]/span";
	public String recons_day_timetxt = "//div[@id='teacherAssessmentDataView']//div[5]//div[2]/p[2]/span";
	public String lstdate_txt = "//div[@id='spReconsiderMainDiv']/h5";
	public String lastdat_txt2 = "//div[@id='spReconsiderMainDiv']/label";
	public String lstdate_time = "//div[@id='teacherAssessmentDataView']//div//div[5]//div[2]/p[2]/span";
	
	//Timeleft in Student window
	public String stud_timeleft = "//p[@id='tstTimeLeftStatus']";
	
	//Student window label
	public String result_lbl = "//p-dialog[@id='studentResultPopup']/div/div/div[1]";
	
	//Reason for Reconsideration popup
	public String reason_reconpopup = "//p-dialog[@id='reconsiderCommentPopup']/div/div";
	public String reason_recon_hd = "//p-dialog[@id='reconsiderCommentPopup']/div/div/div[1]";
	public String txtarea_popup = "//textarea[@id='reconReasonField']";
	public String smalltext = "//div[@id='reconsiderationReasonDivMain']/small";
	public String submit_reasonpopup = "//div[@id='submitStudentReason']/button";
	public String reason_pop_closebtn = "//p-dialog[@id='reconsiderCommentPopup']//div/div[1]/div/button";
	
	//Result publishpopup
	public String resultpublish_popup = "//p-dialog[@id='tstSubmitAnswerPopup']/div/div";
	public String result_publish_txt = "//p-dialog[@id='tstSubmitAnswerPopup']//div/div[2]//h6";
	public String back_btn_reconspopup = "//p-button[@id='reconsiderationBackToResults']/button";
	
	public String stud3_anssheetname ="//p-table[@id='questionResultListingTable']//div[1]/table//tr[3]/td[5]//div/p-badge/span";
	
	//radiobuttons
	public String recons_req_radiobtn = "//div[@id='colorHintDiv']/div[2]/span[1]/p-radiobutton/div";
	
	//Student card 
	public String recons_processd_lbl = "//div[@id='studentAssessmentDataView']/div//div[5]//div[1]/div[1]/span/p-badge/span";
	public String viewteach_comment_btn = "//button[@id='viewTeacherCmntButton']";
	public String teach_response_txt  = "//textarea[@id='teacherCommentField']"	;
	public String teach_resp_close_btn = "//p-dialog[@id='teacherCommentPopup']//div[1]/div/button";
	
	/*
	 * To get the next day-Schedule page
	 */
	public String getNextday() {
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 2);

		SimpleDateFormat df = new SimpleDateFormat("d-M-yyyy");
		// String l=df.format(now.getTime());
		dt = c.getTime();
		return df.format(dt);
	}
	
	
	/*
	 * To get tomorrow day name:Eg-Monday,Tuesday
	 */
	public String Nextdayname() throws ParseException {

		LocalDate tomorrow = LocalDate.now();
		String tomorrowday = tomorrow.plusDays(2).toString();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date dt1 = format1.parse(tomorrowday);
		DateFormat format2 = new SimpleDateFormat("EEEE");
		String tomorrowdayname = format2.format(dt1);
		return tomorrowdayname;
	}
	
	
	/*
	 * To change date format
	 */
	public String getdates1(String date) {

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("d-M-yyyy");
		String predate = date;
		LocalDate date2 = LocalDate.parse(predate, dt);
		DateTimeFormatter dtt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return dtt.format(date2);
	}
	
	/*
	 * To get resconsideration date& time in Teacher card
	 */
	public String resultdate;
	public String resultime;
	
	public void teachrecon_datetimemethod() {

		String[] arrOfStr1 = getText(lstdate_time).split("\n");
		String w2= arrOfStr1[arrOfStr1.length - 1];
		System.out.println("w2= "+w2);
		waitThread(1000);
		
		String[] arrOfStr = (w2).split(" ");
		waitThread(2000);
		
		String month = arrOfStr[arrOfStr.length - 5];
		String d = arrOfStr[arrOfStr.length - 4];
		String y= arrOfStr[arrOfStr.length - 3];
		String year= y.substring(0, 4);

		String time = arrOfStr[arrOfStr.length - 2];
		String timeampm = arrOfStr[arrOfStr.length - 1];

		 resultdate = month + " " + d+ year;

		String[] arrOfStrtime = time.split(":");
		String houresult = arrOfStrtime[arrOfStrtime.length - 2];
		String min= arrOfStrtime[arrOfStrtime.length - 1];

		String hr;

		int l = houresult.length();
		if (l== 1) {
			hr= "0" + houresult;
		} else {
			hr= houresult;
		}

		resultime= hr+ ":" + min + " " + timeampm;

	}
	
	/*
	 * Reconsideration date time in stud card
	 */
	public String stud_resultdate;
	public String stud_resultime;
	
	public void stud_recons_datetimemethod()
	{
		String[] arrOfStr = getText(tr.lastdatetime_lbl).split(" ");
		waitThread(2000);
		String month = arrOfStr[arrOfStr.length - 5];
		String d = arrOfStr[arrOfStr.length - 4];
		String y= arrOfStr[arrOfStr.length - 3];
		String year= y.substring(0, 4);

		String time = arrOfStr[arrOfStr.length - 2];
		String timeampm = arrOfStr[arrOfStr.length - 1];

		 stud_resultdate = month + " " + d+ year;

		String[] arrOfStrtime = time.split(":");
		String houresult = arrOfStrtime[arrOfStrtime.length - 2];
		String min= arrOfStrtime[arrOfStrtime.length - 1];

		String hr;

		int l = houresult.length();
		if (l== 1) {
			hr= "0" + houresult;
		} else {
			hr= houresult;
		}

		stud_resultime= hr+ ":" + min + " " + timeampm;
		
		
		
	}
	
}
