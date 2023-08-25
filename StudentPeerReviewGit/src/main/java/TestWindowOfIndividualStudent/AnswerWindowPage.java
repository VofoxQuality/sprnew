package TestWindowOfIndividualStudent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import SPRautomation.StudentPeerReview.basePage;

public class AnswerWindowPage extends basePage {

	// Button
	public String add_quest_btn = "//button[@id='addPage']";
	public String timeascarrow = "#spTestStartTimeCalendar > span > div > div > div.p-minute-picker> button:nth-child(1)";
	public String discard_btn = "#tstConfirmation > div > div > div > button:nth-child(1)> span.p-button-label";
	public String contin_btn = "#tstConfirmation > div > div > div > button:nth-child(2)> span.p-button-label";
	public String next_btn = "#pages > div > button.p-paginator-next";
	public String last_btn = "#pages > div > button.p-paginator-prev";
	public String save_btn = "#tstBtnAnswerSave";
	public String saveExit_btn = "#saveExitBtn";
	public String saveNext_btn = "#saveNextBtn ";
	public String resumetest_btn = "#studentAssessmentDataView > div > div:nth-child(1) > div > div:nth-child(3) > div > div > button";
	public String coursetab = "#myCoursesLinkStudent";
	public String alertdisc_btn = "#tstAlertBox > div.modal-footer > button.btn1";
	public String alertcancel_btn = "#tstAlertBox > div.modal-footer > button.btn2";

	// label
	public String totalques_lbl = "#questionDetails > div> div > label:nth-child(1)";
	public String totalques_count = "#questionDetails > div> div > label:nth-child(1) > span";
	public String totalscore_lbl = "#questionDetails > div > div > label:nth-child(2)";
	public String ques1_lbl = "#pages > div > span > button:nth-child(1)";
	public String ques2_lbl = "#pages > div > span > button:nth-child(2)";
	public String ques3_lbl = "#pages > div > span > button:nth-child(3)";
	public String ques4_lbl = "#pages > div > span > button:nth-child(4)";
	public String testopendatetime = " div.d-flex.assessment-details-dates > div:nth-child(1) > p.pb-1 > span";
	public String testduedatetime = "#teacherAssessmentDataView > div > div > div > div:nth-child(3) > div > div > div:nth-child(1) > p:nth-child(2) > span";

	// added image video,equation
	public String addedimage = "#tinymce > p:nth-child(2) > img";
	public String addedQues = "#tinymce > p:nth-child(2) > img";
	public String addedvideo = "#tinymce > p:nth-child(2) > video ";
	public String addedequation = "#tinymce > p:nth-child(3) > img";
	public String ansplaceholder = "//*[@data-id='answer']";
	public String quest_box = "//*[@data-id='questionView']";
	// popup
	public String cof_popup = "#tstConfirmation > div > div";
	public String alertbox = "div#tstAlertBox";

	public String getdate(String locator, int num, int num2) {

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("MMM d, yyyy");
		String predate = getText(locator).substring(num, num2);

		System.out.println(predate);
		LocalDate date2 = LocalDate.parse(predate, dt);
		DateTimeFormatter dtt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return dtt.format(date2);
	}

}
