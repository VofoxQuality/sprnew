package NewAssessmentOfTeacherPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import SPRautomation.StudentPeerReview.basePage;

public class AssessmentStatusPage extends basePage {

	// button
	public String add_quest_btn = "//button[@id='addPage']";
	public String viewdetails1_btn = "#teacherAssessmentDataView > div > div:nth-child(1) > div > div:nth-child(3) > div > div> button";
	public String close_btn = "div.ng-star-inserted > p-dialog > div > div > div > div > button > span";
	// searchbox
	public String search_box = "span.p-input-icon-left.ml-auto.common-search > input";

	// label
	public String newasses_lbl = " div > p-dataview > div > div> div > div:nth-child(1) > div > div > p.font-weight-bold";
	public String course_lbl = " div > p-dataview > div > div > div > div:nth-child(1) > div > div > p:nth-child(3)";
	public String assessmentsts_lbl = "div.ng-star-inserted > p-dialog > div > div > div.p-dialog-header>span>p-header";
	public String assessname_lbl = "div.paginator-course-name.popup-course-name > h6 > span";
	public String coursename_lbl = " div.assessment-status-header > div.paginator-course-name> p";
	public String totalnoname_lbl = "div.popup-assessment-info > div:nth-child(1) > p";
	public String teststs_lbl = "div.popup-course-left > div:nth-child(1) > div> p-badge > span";
	public String peersts_lbl = " div.popup-course-left > div:nth-child(2) > div> p-badge > span";
	public String resultsts_lbl = "div.popup-course-left > div:nth-child(3) > div> p-badge > span";
	public String popuptestopendatetime = "//div[@id='testOpenDueDates']/p[1]/span";
	public String popuptestduedatetime = "//div[@id='testOpenDueDates']/p[2]/span";

	public String popuppeeropen_lbl = "//div[@id='peerOpenDueDates']/p[1]/span";
	public String popupeerdue_lbl = "//div[@id='peerOpenDueDates']/p[2]/span";
	public String popupresultpublishdate_lbl = "//div[@id='resultOpenDueDates']/p[1]/span";
	public String resultpublishdate_lbl2 = "#resultOpenDueDates > p:nth-child(1) > span";
	public String lastdatetime_lbl = " div.popup-course-left > div:nth-child(3)  > div:nth-child(2) > p:nth-child(2)";

	public String peerreward_lblcount = "//p[@id='peerScorePercent']/strong";
	public String peerreward_lbl = "//p[@id='peerScorePercent']";
	
	public String questioncount = " div.p-datatable-wrapper > table > tbody > tr:nth-child(1) > td:nth-child(3) > div > div";

	public String studentname_lbl = " div.p-datatable-wrapper > table > thead > tr > th:nth-child(2) > div";

	public String questans_lbl = " div.p-datatable-wrapper> table > thead > tr > th:nth-child(3) > div";

	public String ansshe_lbl = " div.p-datatable-wrapper > table > thead > tr > th:nth-child(4) > div";

	public String peerre_lbl = " div.p-datatable-wrapper> table > thead > tr > th:nth-child(5) > div";
	public String reward_lbl = " div.p-datatable-wrapper> table > thead > tr > th:nth-child(6) > div";
	public String lb6 = "div.p-datatable-wrapper> table > thead > tr > th:nth-child(7) > div";
	public String time_status = " div.assessment-schedule-details > span";

	// card
	public String newcard = " div.p-dataview-content > div > div > div:nth-child(1)";
	public String asses_name_card = " div.assessment-basic-details > p:nth-child(1)";
	public String course_nameid_card = " div.assessment-basic-details > p:nth-child(3)";

	// popup
	public String assessmentsts_popup = " div.ng-star-inserted > p-dialog > div > div";

	public String getdates(String date) {

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("d MMMyyy");
		String predate = date;
		LocalDate date2 = LocalDate.parse(predate, dt);
		DateTimeFormatter dtt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return dtt.format(date2);
	}

	public String timetestopen;
	public String datetestopen;
	public String timetestdue;
	public String datetestdue;
	public String timereviewopen;
	public String datereviewopen;
	public String timereviewdue;
	public String datereviewdue;
	public String resultdate;
	public String resultime;

	public void popupdatetimesplitmethod() {

		// Testopen date & time
		String[] arrOfStr = getText(popuptestopendatetime).split(" ");
		waitThread(2000);
		String d = arrOfStr[arrOfStr.length - 5];
		String month = arrOfStr[arrOfStr.length - 4];
		String y = arrOfStr[arrOfStr.length - 3];
		String year = y.substring(0, 4);

		String time1 = arrOfStr[arrOfStr.length - 2];
		String timeampm = arrOfStr[arrOfStr.length - 1];

		datetestopen = d + " " + month + year;

		String[] arrOfStrtime = time1.split(":");
		String hour = arrOfStrtime[arrOfStrtime.length - 2];
		String min = arrOfStrtime[arrOfStrtime.length - 1];

		String hour0;

		int l = hour.length();
		if (l == 1) {
			hour0 = "0" + hour;
		} else {
			hour0 = hour;
		}

		timetestopen = hour0 + ":" + min + " " + timeampm;

		// Test due date & time

		waitThread(4000);
		String[] arrOfStr1 = getText(popuptestduedatetime).split(" ");
		waitThread(2000);
		String d1 = arrOfStr1[arrOfStr1.length - 5];
		String month1 = arrOfStr1[arrOfStr1.length - 4];
		String y1 = arrOfStr1[arrOfStr1.length - 3];
		String year1 = y1.substring(0, 4);

		String time11 = arrOfStr1[arrOfStr1.length - 2];
		String timeampm1 = arrOfStr1[arrOfStr1.length - 1];

		datetestdue = d1 + " " + month1 + year1;

		String[] arrOfStrtime1 = time11.split(":");
		String hourtestdue = arrOfStrtime1[arrOfStrtime1.length - 2];
		String min1 = arrOfStrtime1[arrOfStrtime1.length - 1];

		String hr1;

		int l1 = hourtestdue.length();
		if (l1 == 1) {
			hr1 = "0" + hourtestdue;
		} else {
			hr1 = hourtestdue;
		}

		timetestdue = hr1 + ":" + min1 + " " + timeampm1;

		// Peer review Open date& time

		String[] arrOfStr2 = getText(popuppeeropen_lbl).split(" ");
		waitThread(2000);
		String d2 = arrOfStr2[arrOfStr2.length - 5];
		String month2 = arrOfStr2[arrOfStr2.length - 4];
		String y2 = arrOfStr2[arrOfStr2.length - 3];
		String year2 = y2.substring(0, 4);

		String time2 = arrOfStr2[arrOfStr2.length - 2];
		String timeampm2 = arrOfStr2[arrOfStr2.length - 1];

		datereviewopen = d2 + " " + month2 + year2;

		String[] arrOfStrtime2 = time2.split(":");
		String hourpeeropen = arrOfStrtime2[arrOfStrtime2.length - 2];
		String min2 = arrOfStrtime2[arrOfStrtime2.length - 1];

		String hr2;

		int l2 = hourpeeropen.length();
		if (l2 == 1) {
			hr2 = "0" + hourpeeropen;
		} else {
			hr2 = hourpeeropen;
		}

		timereviewopen = hr2 + ":" + min2 + " " + timeampm2;

		// Peer review due date& time

		String[] arrOfStr3 = getText(popupeerdue_lbl).split(" ");
		waitThread(2000);
		String d3 = arrOfStr3[arrOfStr3.length - 5];
		String month3 = arrOfStr3[arrOfStr3.length - 4];
		String y3 = arrOfStr3[arrOfStr3.length - 3];
		String year3 = y3.substring(0, 4);

		String time3 = arrOfStr3[arrOfStr3.length - 2];
		String timeampm3 = arrOfStr3[arrOfStr3.length - 1];

		datereviewdue = d3 + " " + month3 + year3;

		String[] arrOfStrtime3 = time3.split(":");
		String hourpeerdue = arrOfStrtime3[arrOfStrtime3.length - 2];
		String min3 = arrOfStrtime3[arrOfStrtime3.length - 1];

		String hr3;

		int l3 = hourpeerdue.length();
		if (l3 == 1) {
			hr3 = "0" + hourpeerdue;
		} else {
			hr3 = hourpeerdue;
		}

		timereviewdue = hr3 + ":" + min3 + " " + timeampm3;
	}

	public void popupresultmethod() {
		// Result publish date & time

		String[] arrOfStr4 = getText(popupresultpublishdate_lbl).split(" ");
		waitThread(2000);

		String d4 = arrOfStr4[arrOfStr4.length - 5];
		String month4 = arrOfStr4[arrOfStr4.length - 4];
		String y4 = arrOfStr4[arrOfStr4.length - 3];
		String year4 = y4.substring(0, 4);

		String time4 = arrOfStr4[arrOfStr4.length - 2];
		String timeampm4 = arrOfStr4[arrOfStr4.length - 1];

		resultdate = d4 + " " + month4 + year4;
		System.out.println(resultdate);

		String[] arrOfStrtime4 = time4.split(":");
		String houresult = arrOfStrtime4[arrOfStrtime4.length - 2];
		String min4 = arrOfStrtime4[arrOfStrtime4.length - 1];

		String hr4;

		int l4 = houresult.length();
		if (l4 == 1) {
			hr4 = "0" + houresult;
		} else {
			hr4 = houresult;
		}

		resultime = hr4 + ":" + min4 + " " + timeampm4;

	}
}
