package check123;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import Course.Pages.EditCoursePage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.MultipleQuestionsAddPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CreateNewAssessment.Pages.SummaryQuestionsPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import NewAssessmentOfTeacherPage.TeacherResultSectionPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class SchedulereTest extends basePage {
	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	EditCoursePage ec = new EditCoursePage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	CourseRosterPage cr = new CourseRosterPage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	EncryptedText et = new EncryptedText();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	SchedulePageBasicsPage sb = new SchedulePageBasicsPage();
	MultipleQuestionsAddPage mq = new MultipleQuestionsAddPage();
	CommonMethods cm = new CommonMethods();
	TeacherPeerReviewSectionPage tp = new TeacherPeerReviewSectionPage();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	TeacherTestSectionPage tts = new TeacherTestSectionPage();
	SummaryQuestionsPage sq = new SummaryQuestionsPage();
	SchedulePageBasicsPage sb1 = new SchedulePageBasicsPage();
	TeacherResultSectionPage tr = new TeacherResultSectionPage();
	public String Emailteacher;
	public String CourseName;
	public String CourseNamenew;
	public String NewCourseTitle;
	public String CourseID;
	public String AssessmentName;
	public String NewAssessmentName;
	public String NewCourseName;
	public String CourseID1;
	public String Emailstudent1;
	public String Emailstudent2;

	public String Studentfirstname;
	public String Studentlastname;
	public String Studentname;
	public String Studentfirstname2;
	public String Studentlastname2;
	public String Studentname2;

	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	/*
	 * To perform Login functionality
	 */
	@Test(priority = 1)
	public void TCSPR1100501() {

		click(lg.LoginBtn_1);

		cm.login(cm.emailteacher, cm.Password);

		waitThread(1000);
		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */
	@Test(priority = 8)
	public void TCSPR0901008() {

		SoftAssert softAssert1 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

//		// To click on create new assessment button and verify label
//		click(ba.btn_createnewassessment);
//
//		// To click on course dropdown
//		click(ba.dd_course);
//		waitFor(ba.ddcoursename1);
//
//		softAssert1.assertEquals(getText(ba.ddcoursename1), cm.CourseName1.trim(),
//				"course name not visible on the dropdown");
//
//		click(ba.ddcoursename1);
		waitThread(5000);
		// Type Assessment Name
		AssessmentName = "Assessment8259034";
		type(tts.search_box, AssessmentName);
		waitThread(2000);
		
		// click menu button
		click(rd.threedot_btn);

		// click reschedule date menu
		click(rd.reschedulemenu);
		waitThread(1000);

		// Assert popup visible
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");
		ScrollTo_xy_position(0, 500);
		// Set the Assessment open day to next day
				click(rd.peerreviewduedate_txtbx);
				
				Calendar cal = Calendar.getInstance();
				int monthNumber = cal.get(Calendar.MONTH);
				
				System.out.println("month no:"+monthNumber);
				
				int s= Integer.valueOf(getValue(sb.ddcal));
				
			if(monthNumber==s)
			{
				Doubleclick(rd.calanderdate_val);
				waitThread(3000);
				// click apply Changes button
				click(rd.applychanges_btn);
				waitThread(2000);
			
			}
			else if((monthNumber!=s)){
				
			
				click(sb.buttondd);
				waitThread(3000);
				
				ScrollTo_xy_position(0, 50);;
				waitThread(1000);
				
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rd.calanderdate_val);
	//Doubleclick(rd.calanderdate_val);
				
				waitThread(3000);
				
				
				// click apply Changes button
				click(rd.applychanges_btn);
				waitThread(2000);
			
			}
			
				Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");

	
	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 9)
	public void TCSPR0901009() {

		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question1");

		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);

		// Click rubric drop down
		click(QP.rubric_drp_btn);
		waitThread(3000);

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "3");

		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");

		click(QP.toasterclosebtn);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	/*
	 * To verify the details on the peer review page
	 */
	@Test(priority = 10)
	public void TCSPR0901010() {

		waitThread(2000);

		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

	}

	/*
	 * To perform the save and next functionaity from peer review page and verify
	 * the schedule page details
	 */
	@Test(priority = 11)
	public void TCSPR0901011() {

		// Type peer review reward score
		type(pr.PRreward_txtbox, "100");

		click(pr.savennext_button);
		waitThread(2000);
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");

		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.Sbassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert the Discard,Save&Exit,Save&Next buttons and button labels:
		Assert.assertTrue(isElementPresent(pr.discard_button), "Button not present");
		Assert.assertTrue(isElementPresent(pr.savenexit_button), "Button not present");

		Assert.assertTrue(isElementPresent(pr.savennext_button), "Button not present");
		Assert.assertTrue(isElementPresent(sb.clearall_btn), "Button not present");
		Assert.assertTrue(isElementPresent(sb.configuredef_btn), "Button not present");

		Assert.assertTrue(isElementPresent(sb.apply_btn), "Button not present");

		Assert.assertEquals(getText(sb.selectstu_lbl), "Select Schedules for");

	}

	public String assessmentopendate;
	public String assessmentopentime;
	public String assessmentduedate;
	public String assessmentduetime;

	/*
	 * To verify the details on the Test Window section[Labels,Date,Time]
	 */
	@Test(priority = 12)
	public void TCSPR0901012() throws InterruptedException {

		// Assert labels-
		Assert.assertEquals(getText(sb.studentscan_lbl), "Students can answer the assessment during these dates only");
		Assert.assertEquals(getText(sb.testwin_lbl), "Test Window");

		Assert.assertEquals(getText(sb.assessmentopen_lbl), "Assessment Open date and time:");
		Assert.assertEquals(getText(sb.assessmentdue_lbl), "Assessment Due date and time:");

		// Assert the Assessment Due date and time text boxes
		Assert.assertTrue(isElementPresent(sb.assessmentopendate_txtbx), "textbox not present");
		Assert.assertTrue(isElementPresent(sb.assessmentopentime_txtbx), "textbox not present");

		Assert.assertTrue(isElementPresent(sb.assessmentduedate_txtbx), "textbox not present");
		Assert.assertTrue(isElementPresent(sb.assessmentduetime_txtbx), "textbox not present");

		assessmentopendate = getValue(sb.assessmentopendate_txtbx);
		assessmentopentime = getValue(sb.assessmentopentime_txtbx);
		assessmentduedate = getValue(sb.assessmentduedate_txtbx);
		assessmentduetime = getValue(sb.assessmentduetime_txtbx);

		click(sb.clearall_btn);
		waitThread(1000);

		// click yes button
		click(sb.confyes_btn);

		// Assert the toaster "Cleared successfully"
		waitFor(pr.assessmentde_toaster);
		Assert.assertEquals(getText(pr.assessmentde_toaster), "Cleared successfully");
		// Click on Test Window due date date picker
		click(sb.assessmentopendate_txtbx);
		waitThread(1000);

		// Assert the calendar visible
		Assert.assertTrue(isElementPresent(sb.assessmentopendate_txtbx), "Calendar not  prsent");

		// Select the Test Window closed date
		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		// Click on Test Window due date date picker
		click(sb.assessmentduedate_txtbx);
		waitThread(1000);

		// Assert the calendar visible
		Assert.assertTrue(isElementPresent(sb.assessmentduedate_txtbx), "Calendar not  prsent");

		// Select the Test Window closed date
		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		click(sb.assessmentduetime_txtbx);
		waitThread(1000);

		int minute = Integer.valueOf(getValue(sb.minuteval));
		System.out.println(minute);
		if (minute == 57) {
			TimeUnit.MINUTES.sleep(3);
			waitThread(7000);
			//Doubleclick(sb.minuteassessdue);
		} else if (minute == 58) {

			TimeUnit.MINUTES.sleep(2);
			waitThread(7000);
			//Doubleclick(sb.minuteassessdue);
		}

		else if (minute == 59) {

			TimeUnit.MINUTES.sleep(1);
			waitThread(7000);
			//Doubleclick(sb.minuteassessdue);
		}

		
		if (minute >= 57) {
			TimeUnit.MINUTES.sleep(3);
			waitThread(7000);
			//Doubleclick(sb.minuteassessdue);
		}
		//Doubleclick(sb.minuteassessdue);

		// Set peer review open day current date
		click(sb1.peerreviewopendate_txtbx);
		waitThread(1000);

		Doubleclick(sb1.calanderdate_val);
		waitThread(4000);

		// Set peer review open day current date
		click(sb1.peerreviewduedate_txtbx);
		waitThread(1000);
		Doubleclick(sb1.calanderdate_val);

		click(sb.peerreviewduetime_txtbx);
		waitThread(1000);

		//click(sb.minutepeerdue);
		ScrollTo_xy_position(0, 250);
		waitThread(1000);

		// elect the Result publishing date
		click(sb.resultpublishdate_txtbx);
		waitThread(1000);

		// Assert calender visible
		Assert.assertTrue(isElementPresent(sb.resultpublish_calendar), "Calendar not  prsent");

		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		// Assert calender not visible
		Assert.assertFalse(isElementPresent(sb.resultpublish_calendar), "Calendar   prsent");
		waitThread(1000);
		Scroll_DowntoEnd();
		waitThread(1000);

		// select the Result publishing date
		click(sb.lastdate_txtbx);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(sb.allowstu_calendar), "Calendar not  prsent");

		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		// Assert calendar not present
		Assert.assertFalse(isElementPresent(sb.allowstu_calendar), "Calendar   prsent");
		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);

		Assert.assertTrue(isElementPresent(tts.release_btn), "Release button not present");

		// Click on Release button
		click(tts.release_btn);

		waitFor(QP.toaster);
		// Assert toaster "Assessment published successfully
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");

		click(QP.toasterclosebtn);

		// Assert the popup visible
		Assert.assertTrue(isDisplayed(tts.release_popup), "Popup not visible");

		// Assert label "Assessment Created Successfully"
		Assert.assertEquals(getText(tts.popup_text), "Assessment Created Successfully");

		// Assert button Back to Menu
		Assert.assertTrue(isElementPresent(tts.back_to_menubutton), "Back to menu button not present");

		// Click Back to Menu
		click(tts.back_to_menubutton);
		// Assert Heading "Assessments"
		Assert.assertEquals(getText(QP.Assessments), "Assessments");
		click(QP.Assessments);
		waitThread(5000);

		// search assessment
		type(tts.search_box, AssessmentName);
		waitThread(2000);
		waitThread(10000);
		// Assert the Status "Test Active "
		Assert.assertEquals(getText(tts.test_text), "Test");
		waitThread(2000);

		// Assert the timer visible on the card
		Assert.assertTrue(getText(tts.timer).contains("Test upcoming in"), "Timer not visible on card");

		TimeUnit.MINUTES.sleep(1);
		waitThread(6000);
		Assert.assertEquals(getText(tts.test_pending), "Active");

		TimeUnit.MINUTES.sleep(3);
		waitThread(10000);
		Assert.assertEquals(getText(tp.peersts_lbl), "Active");

		TimeUnit.MINUTES.sleep(3);
		waitThread(6000);

		Assert.assertEquals(getText(tr.resultsts_lbl), "Active");

	}

	public String peerreviewopendate;
	public String peerreviewopentime;
	public String peerreviewduedate;
	public String peerreviewduetime;
}

//	/*
//	 * To verify the details on the Peer Review Window section[Labels,Date,Time]
//	 */
//	@Test(priority = 13)
//	public void TCSPR0901013() {
//
//		// assert labels
//		Assert.assertEquals(getText(sb.studentscan_lbl2), "Students can perform peer review during these dates only");
//		Assert.assertEquals(getText(sb.peerreview_lbl), "Peer Review");
//
//		Assert.assertEquals(getText(sb.peerreviewopen_lbl), "Peer Review Open date and time:");
//		Assert.assertEquals(getText(sb.peerreviewdue_lbl), "Peer Review Due date and time:");
//
//		// Assert textbox
//		Assert.assertTrue(isElementPresent(sb.peerreviewopendate_txtbx), "Textbox not present");
//		Assert.assertTrue(isElementPresent(sb.peerreviewopentime_txtbx), "Textbox not present");
//
//		Assert.assertTrue(isElementPresent(sb.peerreviewduedate_txtbx), "Textbox not present");
//		Assert.assertTrue(isElementPresent(sb.peerreviewduetime_txtbx), "Textbox not present");
//
//		peerreviewopendate = getValue(sb.peerreviewopendate_txtbx);
//		peerreviewopentime = getValue(sb.peerreviewopentime_txtbx);
//		peerreviewduedate = getValue(sb.peerreviewduedate_txtbx);
//		peerreviewduetime = getValue(sb.peerreviewduetime_txtbx);
//		assessmentduedate = getValue(sb.assessmentduedate_txtbx);
//
//		// Assert that the Peer Review Open time is 2 hr buffer time from test due
//		// time[4h from system time]
//		Assert.assertTrue(getValue(sb.peerreviewopentime_txtbx).contains(sb.getTime(4)));
//
//		// Assert the Assessment Open date is same as test due date or 1 day difference
//		String diff1 = sb.getdatedifference(sb.assessmentduedate_txtbx, sb.peerreviewopendate_txtbx);
//		int d2 = Integer.valueOf(diff1);
//
//		if (d2 == 0) {
//			Assert.assertEquals(sb.getdatedifference(sb.assessmentduedate_txtbx, sb.peerreviewopendate_txtbx), "0");
//
//		} else if (d2 >= 1) {
//			Assert.assertEquals(sb.getdatedifference(sb.assessmentduedate_txtbx, sb.peerreviewopendate_txtbx), "1");
//
//		}
//
//		// Assert the peer review Due date should be 7 days buffer time as default date
//		// from the current time[Peer review start date]
//
//		String difference1 = sb.getdatedifference(sb.peerreviewopendate_txtbx, sb.peerreviewduedate_txtbx);
//		int d1 = Integer.valueOf(difference1);
//
//		if (d1 == 7) {
//			Assert.assertEquals(sb.getdatedifference(sb.peerreviewopendate_txtbx, sb.peerreviewduedate_txtbx), "7");
//
//		} else if (d1 >= 8) {
//			Assert.assertEquals(sb.getdatedifference(sb.peerreviewopendate_txtbx, sb.peerreviewduedate_txtbx), "8");
//
//		}
//
//		// Assert the Assessment Due time same as peer review start time
//		Assert.assertEquals(getValue(sb.peerreviewduetime_txtbx), peerreviewopentime);
//
//	}
//
//	public String resultpublishdate;
//
//	/*
//	 * To verify the details on the Result Publishing section[Labels,Date,Time]
//	 */
//	@Test(priority = 14)
//	public void TCSPR0901014() {
//
//		// Assert labels-
//		Assert.assertEquals(getText(sb.resultpublish_lbl), "Result Publishing");
//		Assert.assertEquals(getText(sb.resultpublishdate_lbl), "Result publishing date");
//
//		ScrollTo_xy_position(0, 300);
//		waitThread(2000);
//
//		// Assert text boxes
//		waitFor(sb.resultpublishdate_txtbx);
//		Assert.assertTrue(isElementPresent(sb.resultpublishdate_txtbx), "Textbox not present");
//		Assert.assertTrue(isElementPresent(sb.resultpublishtime_txtbx), "Textbox not present");
//
//		// Assert that the Result Publishing time is 2 hr buffer time from peer review
//		// due time[6h from system time]
//		Assert.assertTrue(getValue(sb.resultpublishtime_txtbx).contains(sb.getTime(6)));
//
//		peerreviewduedate = getValue(sb.peerreviewduedate_txtbx);
//		resultpublishdate = getValue(sb.resultpublishdate_txtbx);
//
//		// Assert the Result Publishing is same as peer review due date
//		String diff1 = sb.getdatedifference(sb.peerreviewduedate_txtbx, sb.resultpublishdate_txtbx);
//		int d1 = Integer.valueOf(diff1);
//
//		if (d1 == 0) {
//			Assert.assertEquals(sb.getdatedifference(sb.peerreviewduedate_txtbx, sb.resultpublishdate_txtbx), "0");
//
//		}
//
//		else if (d1 >= 1)
//
//		{
//			Assert.assertEquals(sb.getdatedifference(sb.peerreviewduedate_txtbx, sb.resultpublishdate_txtbx), "1");
//
//		}
//
//	}
//
//	/*
//	 * To verify the details on the Allow students to raise a Reconsideration
//	 * Request section[Labels,Date,Time]
//	 */
//	@Test(priority = 15)
//	public void TCSPR0901015() {
//
//		// Assert labels-
//		Assert.assertEquals(getText(sb.allowstudent_lbl), "Allow students to raise a Reconsideration Request");
//		Assert.assertEquals(getText(sb.lastdate_lbl), "Last date for Reconsideration Request");
//		Assert.assertEquals(getText(sb.lastdatestu_lbl), "Last date for raising reconsideration request by students");
//
//		// Assert date and time text boxes
//		Assert.assertTrue(isElementPresent(sb.lastdate_txtbx), "textbox not present");
//		Assert.assertTrue(isElementPresent(sb.lastdatetime_txtbx), "textbox not present");
//
//		// Assert the Result Publishing is same as peer review due date or 1 day
//		String difference2 = sb.getdatedifference(sb.peerreviewduedate_txtbx, sb.resultpublishdate_txtbx);
//		int d2 = Integer.valueOf(difference2);
//
//		if (d2 == 0) {
//			Assert.assertEquals(sb.getdatedifference(sb.peerreviewduedate_txtbx, sb.resultpublishdate_txtbx), "0");
//
//		} else if (d2 >= 1) {
//			Assert.assertEquals(sb.getdatedifference(sb.peerreviewduedate_txtbx, sb.resultpublishdate_txtbx), "1");
//
//		}
//
//		String resultpublishtime = getValue(sb.resultpublishtime_txtbx);
//
//		// Assert result publishing and last date for reconsideration time are same
//		Assert.assertEquals(getValue(sb.lastdatetime_txtbx), resultpublishtime);
//
//		// Assert the result publish date date should be 7 days buffer time as default
//		// date from the current date
//
//		String difference1 = sb.getdatedifference(sb.resultpublishdate_txtbx, sb.lastdate_txtbx);
//		int d1 = Integer.valueOf(difference1);
//
//		if (d1 == 7) {
//			Assert.assertEquals(sb.getdatedifference(sb.resultpublishdate_txtbx, sb.lastdate_txtbx), "7");
//
//		} else if (d1 >= 8) {
//			Assert.assertEquals(sb.getdatedifference(sb.resultpublishdate_txtbx, sb.lastdate_txtbx), "8");
//
//		}
//
//	}
//
//	/*
//	 * To verify the details on the Configuration Notifications section[verify the
//	 * labels and checkboxes are selected]
//	 */
//	@Test(priority = 16)
//	public void TCSPR0901016() {
//
//		// Assert labels and check boxes is selected:
//		Assert.assertEquals(getText(sb.confignoti_lbl), "Configuration Notifications");
//		Assert.assertEquals(getText(sb.mailnotifi_lbl), "Mail Notification");
//		Assert.assertEquals(getText(sb.notifiactive_lbl), "Notification is activated for:");
//
//		Assert.assertEquals(getText(sb.Wnewassess_lbl), "When a new assessment is published");
//		Assert.assertEquals(getText(sb.Wtestandpeer_lbl), "When test and peer-review are active");
//
//		Assert.assertEquals(getText(sb.Wtestnpeerclose_lbl), "When a test and peer-review window is closed");
//		Assert.assertEquals(getText(sb.Wtestnpeermodi_lbl), "When test,peer-review and result dates are modified");
//
//		Assert.assertEquals(getText(sb.Wresultpub_lbl),
//				"When result is published manually by teacher/automatically by system");
//		Assert.assertEquals(getText(sb.Wteachresolve_lbl), "When teacher resolves a reconsideration request");
//
//		// check boxes
//		Assert.assertTrue(isElementPresent(sb.mailnotifi_checkbx), "checkbox not selected");
//		Assert.assertTrue(isElementPresent(sb.Wnewassess_checkbx), "checkbox not selected");
//
//		Assert.assertTrue(isElementPresent(sb.Wtestandpeer_checkbx), "checkbox not selected");
//		Assert.assertTrue(isElementPresent(sb.Wtestnpeerclose_checkbx), "checkbox not selected");
//
//		Assert.assertTrue(isElementPresent(sb.Wtestnpeermodi_checkbx), "checkbox not selected");
//		Assert.assertTrue(isElementPresent(sb.Wresultpub_checkbx), "checkbox not selected");
//		Assert.assertTrue(isElementPresent(sb.Wteachresolve_checkbx), "checkbox not selected");
//
//	}
//
//	/*
//	 * To change the assessment name from basic details page and verify the
//	 * assessment name is updating on the schedule page
//	 */
//	@Test(priority = 17)
//	public void TCSPR0901017() {
//
//		ScrollTo_xy_position(0, 0);
//		waitThread(1000);
//
//		// Click on the basic details wizard
//		click(pr.basicdetails_wizard);
//
//		waitThread(2000);
//
//		// Assert the peer review wizard is selected
//		Assert.assertTrue(isEnabled(pr.basicdetails_wizard), "peer review wizard is selected");
//
//		// Assert the peer review wizard is selected
//		Assert.assertEquals(getAttribute(pr.question_wizard2, "aria-selected"), "false");
//
//		// Assert the peer review wizard is selected
//		Assert.assertEquals(getAttribute(pr.peerrev_wizard2, "aria-selected"), "false");
//
//		// click assessment name field
//		click(QP.Assess_name);
//		driver.findElement(By.xpath("//input[@id='assessmentName']")).clear();
//
//		// Type Assessment Name
//
//		NewAssessmentName = "NewAssessment" + generateRandomNumber().trim();
//
//		type(QP.Assess_name, NewAssessmentName);
//
//		// Click on save and next button
//		click(pr.savennext_button);
//		click(QP.toasterclosebtn);
//		waitThread(3000);
//
//		// Assert the question wizard is selected
//		Assert.assertTrue(isEnabled(pr.question_wizard), "question wizard is selected");
//
//		// Click on save and next button
//		click(pr.savennext_button);
//		waitThread(3000);
//		// Assert the peer review wizard is selected
//		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");
//
//		click(pr.savennext_button);
//		waitThread(3000);
//
//		// Assert the schedule wizard wizard is selected
//		Assert.assertTrue(isEnabled(sb.schedule_wizard), "schedule wizard is selected");
//
//	}
//
//	/*
//	 * To perform save and next functionality from schedule page
//	 */
//	@Test(priority = 18)
//	public void TCSPR0901018() {
//
//		// Click on save and next button
//		click(pr.savennext_button);
//		waitThread(2000);
//
//		// Assert the peer review wizard is selected
//		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");
//
//		click(sb.schedule_wizard);
//		waitThread(2000);
//		// Assert the peer review wizard is selected
//		Assert.assertTrue(isEnabled(sb.schedule_wizard), "schedule wizard is selected");
//
//		// Assert the label assessment name,
//		Assert.assertTrue(getText(sb.Sbassessmentname_lbl2).contains("Assessment Name: " + NewAssessmentName.trim()));
//
//	}
//
//	/*
//	 * To verify the details on the Teacher will manually publish the result section
//	 */
//	@Test(priority = 19)
//	public void TCSPR0901019() {
//
//		Assert.assertEquals(getText(sb.teachermanua_lbl), "Teacher will manually publish the result");
//
//		Assert.assertTrue(isElementPresent(sb.teacherwill_radio), "radio button is prsent");
//
//		Assert.assertFalse(isSelected(sb.teacherwill_radio), "radio button is selected");
//		// Click on save and next button
//		click(pr.savennext_button);
//		waitThread(2000);
//
//		// Assert the summary wizard is selected
//		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");
//
//		click(sb.schedule_wizard);
//		waitThread(2000);
//		// Assert the schedule wizard is selected
//		Assert.assertTrue(isEnabled(sb.schedule_wizard), "schedule wizard is selected");
//
//	}
//
//	/*
//	 * To verify the Configuration Notifications required field validation messages
//	 */
//	@Test(priority = 20)
//	public void TCSPR0901020() {
//
//		Scroll_DowntoEnd();
//		waitThread(3000);
//		Assert.assertTrue(isElementPresent(sb.mailnotifi_checkbx), "checkbox is prsent");
//
//		waitThread(1000);
//
//		// Click on Mail Notification check box
//		click(sb.mailnotifi_checkbx);
//		waitThread(1000);
//
//		// Click on Mail Notification check box
//		click(sb.mailnotifi_checkbx2);
//		waitThread(1000);
//
//		// Assert validation message "Select at least one mail notification option"
//		waitFor(sb.mailvali_msg);
//		Assert.assertEquals(getText(sb.mailvali_msg), "Select at least one mail notification option");
//
//		click(pr.savennext_button);
//
//		// Assert toaster"Select at least one mail notification"
//		waitFor(sb.mailsave_toaster);
//		Assert.assertEquals(getText(sb.mailsave_toaster), "Select at least one mail notification");
//
//		click(QP.toasterclosebtn);
//
//		// Click on When a new assessment is published check box
//		click(sb.Wnewassess_checkbx2);
//		waitThread(1000);
//
//		// Assert the validation message not visible
//		Assert.assertTrue(isElementPresent(sb.mailvali_msg), "validation not  prsent");
//		ScrollTo_xy_position(0, 0);
//
//		waitThread(2000);
//		click(pr.savennext_button);
//
//		waitFor(pr.assessmentde_toaster);
//
//		// Assert toaster "Saved successfully"
//		Assert.assertEquals(getText(pr.assessmentde_toaster), "Saved successfully");
//
//		click(QP.toasterclosebtn);
//
//	}
//
//	/*
//	 * To perform the save and exit functionality and load the assessment from draft
//	 * page
//	 */
//	@Test(priority = 21)
//	public void TCSPR0901021() {
//
//		// Click on save and next button
//		click(pr.savenexit_button);
//		waitThread(1000);
//
//		click(pr.draft_tab);
//		waitThread(1000);
//
//		// click continue edit button
//		click(pr.continueedit_button);
//		waitThread(1000);
//
//		// Click on save and next button
//		click(pr.savennext_button);
//
//		waitThread(2000);
//
//		// Click on save and next button
//		click(pr.savennext_button);
//
//		waitThread(2000);
//
//		// Assert the peer review wizard is selected
//		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is not selected");
//		click(pr.savennext_button);
//
//		waitThread(2000);
//		// Assert the schedule wizard is selected
//		Assert.assertTrue(isEnabled(sb.schedule_wizard), "schedule wizard is not  selected");
//	}
//
//	/*
//	 * To perform the clear all functionality on the schedule page
//	 */
//	@Test(priority = 22)
//	public void TCSPR0901022() {
//
//		ScrollTo_xy_position(0, 500);
//		waitThread(1000);
//
//		// Click on Result publishing date radio button
//		click(sb.resultpublish_radio);
//		waitThread(1000);
//
//		click(ba.btndiscard);
//		Assert.assertTrue(isElementPresent(ba.Confirm_discardpopup), "Confirmation Popup not visible");
//
//		waitThread(1000);
//		waitFor(ba.Confirm_txtpopup);
//		Assert.assertEquals(getText(ba.Confirm_txtpopup), "Are you sure you want to proceed with your action?\n"
//				+ "We detected you have made changes to the information on this screen and if you ‘Discard’ these changes will not be saved.",
//				"Assertion failed");
//
//		// Confirmation popup yes button
//		click(ba.Confirm_btnNo);
//
//		click(ba.btndiscard);
//		Assert.assertTrue(isElementPresent(ba.Confirm_discardpopup), "Confirmation Popup not visible");
//
//		waitThread(1000);
//		waitFor(ba.Confirm_txtpopup);
//		Assert.assertEquals(getText(ba.Confirm_txtpopup), "Are you sure you want to proceed with your action?\n"
//				+ "We detected you have made changes to the information on this screen and if you ‘Discard’ these changes will not be saved.",
//				"Assertion failed");
//
//		// Confirmation popup yes button
//		click(ba.Confirm_btnYes);
//
//		// Assert the tab name:Draft
//		Assert.assertEquals(getText(pr.draft_lbl).trim(), "Draft");
//
//		// click continue edit button
//		click(pr.continueedit_button);
//		waitThread(2000);
//
//		// Click on save and next button
//		click(pr.savennext_button);
//
//		waitThread(2000);
//
//		// Click on save and next button
//		click(pr.savennext_button);
//
//		waitThread(2000);
//
//		// Assert the peer review wizard is selected
//		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is not selected");
//		click(pr.savennext_button);
//
//		waitThread(2000);
//		// Assert the schedule wizard is selected
//		Assert.assertTrue(isEnabled(sb.schedule_wizard), "schedule wizard is not  selected");
//
//		// Click on Clear All button
//		click(sb.clearall_btn);
//		waitThread(1000);
//
//		// assert popup
//		Assert.assertTrue(isElementPresent(sb.conf_dlgbx), "validation not  present");
//
//		// Assert label
//		Assert.assertEquals(getText(sb.confirm_lbl), "Are you sure that you want to clear all the fields?");
//
//		// Assert button in popup
//		Assert.assertTrue(isElementPresent(sb.confno_btn), "Button not   present");
//		Assert.assertTrue(isElementPresent(sb.confyes_btn), "Button not  present");
//
//		// click no button
//		click(sb.confno_btn);
//		waitThread(1000);
//
//		// Assert a confirmation popup not visible on the page
//		Assert.assertFalse(isElementPresent(sb.conf_dlgbx), "popup  present");
//
//		click(sb.clearall_btn);
//		waitThread(1000);
//
//		// click yes button
//		click(sb.confyes_btn);
//
//		// Assert the toaster "Cleared successfully"
//		waitFor(pr.assessmentde_toaster);
//		Assert.assertEquals(getText(pr.assessmentde_toaster), "Cleared successfully");
//
//		// Assert that no data's on the Test Window[Asserts date and times] and Peer
//		// Review[assert date and time]
//		Assert.assertEquals(getValue(sb.assessmentduedate_txtbx), "");
//		Assert.assertEquals(getValue(sb.assessmentduetime_txtbx), "");
//		Assert.assertEquals(getValue(sb.assessmentopentime_txtbx), "");
//		Assert.assertEquals(getValue(sb.assessmentopendate_txtbx), "");
//
//		Assert.assertEquals(getValue(sb.peerreviewopendate_txtbx), "");
//		Assert.assertEquals(getValue(sb.peerreviewopentime_txtbx), "");
//		Assert.assertEquals(getValue(sb.peerreviewduedate_txtbx), "");
//		Assert.assertEquals(getValue(sb.peerreviewduetime_txtbx), "");
//
//	}
//
//	/*
//	 * To verify the confirmation popup when click on the peer review wizard[After
//	 * perform clar all functionality]
//	 */
//	@Test(priority = 23)
//	public void TCSPR0901023() {
//
//		// Click on peer review wizard
//		click(pr.peerrev_wizard);
//
//		// Assert the confirmation popup visible
//		waitFor(sb.prconf_dlgbx);
//		Assert.assertTrue(isElementPresent(sb.prconf_dlgbx), "validation not  prsent");
//
//		// Assert label
//		Assert.assertEquals(getText(sb.confirm_lbl), "Changes you made may not be saved");
//
//		// Assert buttons Continue Editing,Discard
//		Assert.assertTrue(isElementPresent(sb.confdiscard_btn), "Button not  prsent");
//		Assert.assertTrue(isElementPresent(sb.confcontinue_btn), "Button not  prsent");
//
//		click(sb.confcontinue_btn);
//		waitThread(1000);
//
//		// Assert the peer review wizard is selected
//		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is not selected");
//
//		// Assert the confirmation popup not visible
//		Assert.assertFalse(isElementPresent(sb.prconf_dlgbx), "popup  present");
//
//		click(pr.peerrev_wizard);
//
//		// Assert the confirmation popup not visible
//		Assert.assertTrue(isElementPresent(sb.prconf_dlgbx), "popup not  present");
//
//		click(sb.confdiscard_btn);
//		waitThread(1000);
//
//		// Assert the peer review wizard is selected
//		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is not selected");
//
//	}
//
//	/*
//	 * To click back to the schedule page and check the data's visible[Test
//	 * window,Peer review window]
//	 */
//	@Test(priority = 24)
//	public void TCSPR0901024() {
//
//		click(pr.savennext_button);
//		waitThread(3000);
//
//		// Assert the already saved data's visible on the Test Window[Asserts date and
//		// times] and Peer Review[assert date and time]
//		Assert.assertEquals(getValue(sb.assessmentduedate_txtbx), assessmentduedate);
//
//		Assert.assertEquals(getValue(sb.assessmentopendate_txtbx), assessmentopendate);
//
//		Assert.assertEquals(getValue(sb.peerreviewopendate_txtbx), peerreviewopendate);
//
//		Assert.assertEquals(getValue(sb.peerreviewduedate_txtbx), peerreviewduedate);
//
//		waitThread(2000);
//
//		Assert.assertTrue(isElementPresent(sb.Assessopenfilledtime2), "time not visible");
//
//		Assert.assertTrue(isElementPresent(sb.Assessduefilledtime2), "time not visible");
//
//		Assert.assertTrue(isElementPresent(sb.peeropenfilledtime2), "time not visible");
//
//		Assert.assertTrue(isElementPresent(sb.peerduefilledtime2), "time not visible");
//
//	}
//
//	/*
//	 * To verify the clear all button disable/Enable functionalities
//	 */
//	@Test(priority = 25)
//	public void TCSPR0901025() {
//
//		// click clearall button
//		click(sb.clearall_btn);
//		waitThread(1000);
//
//		// click yes
//		click(sb.confyes_btn);
//
//		waitFor(pr.assessmentde_toaster);
//
//		// Assert toaster
//		Assert.assertEquals(getText(pr.assessmentde_toaster), "Cleared successfully");
//
//		// Assert the Clear all button is disable
//		Assert.assertFalse(isEnabled(sb.clearall_btn), "button enabled");
//
//		ScrollTo_xy_position(0, 500);
//		waitThread(1000);
//
//		// Click on Result publishing date radio button
//		click(sb.resultpublish_radio);
//		waitThread(1000);
//
//		// click allow student checkbox
//		click(sb.allowstu_checkbx);
//		waitThread(500);
//
//		// Assert allow student check box disabled
//		Assert.assertFalse(isElementPresent(sb.allowstu_checkbx));
//
//		ScrollTo_xy_position(0, 0);
//		waitThread(1000);
//
//		// Assert clear all button disabled
//		Assert.assertTrue(isEnabled(sb.clearall_btn), "button disabled");
//
//	}
//
//	/*
//	 * To verify the validation messages on the schedule page-To fill Test window
//	 * due date and time
//	 */
//	@Test(priority = 26)
//	public void TCSPR0901026() {
//
//		click(pr.savennext_button);
//		waitFor(QP.toaster);
//
//		// Assert toaster "Please enter the mandatory date and time fields"
//		Assert.assertEquals(getText(QP.toaster), "Please enter the mandatory date and time fields");
//
//		click(QP.toasterclosebtn);
//
//		click(pr.savenexit_button);
//		waitFor(QP.toaster);
//
//		// Assert toaster "Please enter the mandatory date and time fields"
//		Assert.assertEquals(getText(QP.toaster), "Please enter the mandatory date and time fields");
//
//		click(QP.toasterclosebtn);
//		waitThread(1000);
//
//		// Click on Test Window due date date picker
//		click(sb.assessmentduedate_txtbx);
//		waitThread(1000);
//
//		// Assert the calendar visible
//		Assert.assertTrue(isElementPresent(sb.assessdue_calendar), "Calendar not  prsent");
//
//		// Select the Test Window closed date
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		// Assert the calendar not visible
//		Assert.assertFalse(isElementPresent(sb.assessdue_calendar), "Calendar   present");
//
//		// Assert time visible on the textbox
//		Assert.assertTrue(isElementPresent(sb.Assessduefilledtime), "time not visible");
//
//	}
//
//	/*
//	 * To fill the Peer review open date and time close date and time text boxes
//	 */
//	@Test(priority = 27)
//	public void TCSPR0901027() {
//
//		// Select the Peer Review Window open date
//		waitThread(1000);
//		click(sb.peerreviewopendate_txtbx);
//		waitThread(1000);
//
//		// Assert the calendar visible
//		Assert.assertTrue(isElementPresent(sb.peeropen_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		// Assert the calendar not visible
//		Assert.assertFalse(isElementPresent(sb.peeropen_calendar), "Calendar  prsent");
//
//		// Select the Peer Review Window due date
//		waitThread(1000);
//		click(sb.peerreviewduedate_txtbx);
//		waitThread(1000);
//
//		// Assert the calendar visible
//		Assert.assertTrue(isElementPresent(sb.peerdue_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		// Assert the calendar not visible
//		Assert.assertFalse(isElementPresent(sb.peerdue_calendar), "Calendar  prsent");
//
//		// Assert the time filled
//		Assert.assertTrue(isElementPresent(sb.peerduefilledtime), "time not visible");
//
//	}
//
//	/*
//	 * To fill the Result publishing date and time
//	 */
//	@Test(priority = 28)
//	public void TCSPR0901028() {
//
//		waitThread(1000);
//
//		// elect the Result publishing date
//		click(sb.resultpublishdate_txtbx);
//		waitThread(1000);
//
//		// Assert calender visible
//		Assert.assertTrue(isElementPresent(sb.resultpublish_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		// Assert calender not visible
//		Assert.assertFalse(isElementPresent(sb.resultpublish_calendar), "Calendar   prsent");
//		waitThread(1000);
//
//		// Assert the time visible on the textbox
//		Assert.assertTrue(isElementPresent(sb.resultfilledtime), "time not visible");
//	}
//
//	/*
//	 * To check the validation messages for the assessment open date sectionTo fill
//	 * the details on the schedule page for Test open date/Allow students to raise a
//	 * Reconsideration Request/and notifications is mandatory
//	 */
//	@Test(priority = 29)
//	public void TCSPR0901029() {
//
//		click(pr.savennext_button);
//		waitFor(QP.toaster);
//
//		// Assert toaster"Assessment Open date and time is mandatory"
//		Assert.assertEquals(getText(QP.toaster), "Assessment Open date and time is mandatory");
//
//		click(QP.toasterclosebtn);
//
//		click(pr.savenexit_button);
//		waitFor(QP.toaster);
//
//		// Assert toaster"Assessment Open date and time is mandatory"
//		Assert.assertEquals(getText(QP.toaster), "Assessment Open date and time is mandatory");
//
//		click(QP.toasterclosebtn);
//		waitThread(1000);
//
//		// Select the Test Window open date
//		click(sb.assessmentopendate_txtbx);
//		waitThread(1000);
//
//		// Assert calender visible
//		Assert.assertTrue(isElementPresent(sb.assessopen_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		// Assert calender not visible
//		Assert.assertFalse(isElementPresent(sb.assessopen_calendar), "Calendar not  prsent");
//
//		Assert.assertTrue(isElementPresent(sb.Assessopenfilledtime), "time not visible");
//
//		waitThread(1000);
//
//		Scroll_DowntoEnd();
//		waitThread(1000);
//		click(sb.allowstu_checkbx2);
//
//		// click mail notification check box
//		click(sb.mailnotifi_checkbx2);
//		waitThread(500);
//		Assert.assertTrue(isElementPresent(sb.mailnotifi_checkbx));
//		waitThread(1000);
//		click(pr.savennext_button);
//		waitFor(QP.toaster);
//
//		// Assert toaster"Last date for raising reconsideration request by students is
//		// mandatory Select at least one mail notification"
//		Assert.assertEquals(getText(QP.toaster),
//				"Last date for raising reconsideration request by students is mandatory\n" + "\n"
//						+ " Select at least one mail notification");
//
//		click(QP.toasterclosebtn);
//
//		click(pr.savenexit_button);
//		waitFor(QP.toaster);
//
//		// Assert toaster
//		Assert.assertEquals(getText(QP.toaster),
//				"Last date for raising reconsideration request by students is mandatory\n" + "\n"
//						+ " Select at least one mail notification");
//
//		click(QP.toasterclosebtn);
//		waitThread(1000);
//
//		// click allow student checkbox
//		click(sb.allowstu_checkbx);
//		waitThread(500);
//
//		ScrollTo_xy_position(0, 0);
//		waitThread(500);
//
//		// click clear all button
//		click(sb.clearall_btn);
//		waitThread(1000);
//		click(sb.confyes_btn);
//
//		waitFor(pr.assessmentde_toaster);
//
//		// Assert toaster
//		Assert.assertEquals(getText(pr.assessmentde_toaster), "Cleared successfully");
//		Assert.assertFalse(isEnabled(sb.clearall_btn), "button enabled");
//
//	}
//
//	/*
//	 * To fill the Test window open date and time,peer review open and Due date and
//	 * time
//	 */
//	@Test(priority = 30)
//	public void TCSPR0901030() {
//
//		click(sb.assessmentopendate_txtbx);
//		waitThread(1000);
//
//		// Assert calender visible
//		Assert.assertTrue(isElementPresent(sb.assessopen_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		// Assert calender not visible
//		Assert.assertFalse(isElementPresent(sb.assessopen_calendar), "Calendar not  prsent");
//
//		// Assert time field is filled
//		Assert.assertTrue(isElementPresent(sb.Assessopenfilledtime), "time not visible");
//
//		waitThread(1000);
//
//		// Select the Test Window Open date
//		click(sb.peerreviewopendate_txtbx);
//		waitThread(1000);
//
//		// Assert calender visible
//		Assert.assertTrue(isElementPresent(sb.peeropen_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//		Assert.assertFalse(isElementPresent(sb.peeropen_calendar), "Calendar not  prsent");
//
//		// Assert time field is filled
//		Assert.assertTrue(isElementPresent(sb.peeropenfilledtime), "time not visible");
//
//		waitThread(1000);
//
//		// Select the peer review due date
//		click(sb.peerreviewduedate_txtbx);
//		waitThread(1000);
//
//		// Assert calendar visible
//		Assert.assertTrue(isElementPresent(sb.peerdue_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		// Assert calendar not visible
//		Assert.assertFalse(isElementPresent(sb.peerdue_calendar), "Calendar not  prsent");
//
//		// Assert time field is filled
//		Assert.assertTrue(isElementPresent(sb.peerduefilledtime), "time not visible");
//
//	}
//
//	/*
//	 * To fill the Result publishing date and time
//	 */
//	@Test(priority = 31)
//	public void TCSPR0901031() {
//
//		waitThread(1000);
//
//		// select the Result publishing date
//		click(sb.resultpublishdate_txtbx);
//		waitThread(1000);
//
//		// Assert calendar visible
//		Assert.assertTrue(isElementPresent(sb.resultpublish_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		// Assert calendar not visible
//		Assert.assertFalse(isElementPresent(sb.resultpublish_calendar), "Calendar   prsent");
//		waitThread(1000);
//
//		// Assert the time visible on the textbox
//		Assert.assertTrue(isElementPresent(sb.resultfilledtime), "time not visible");
//
//	}
//
//	/*
//	 * To verify the validation messages[for Test due date] when click on save and
//	 * next andsave and exit buttons
//	 */
//	@Test(priority = 32)
//	public void TCSPR0901032() {
//
//		click(pr.savennext_button);
//		waitFor(QP.toaster);
//
//		// Assert toaster"Assessment Due date and time is mandatory"
//		Assert.assertEquals(getText(QP.toaster), "Assessment Due date and time is mandatory");
//
//		click(QP.toasterclosebtn);
//
//		click(pr.savenexit_button);
//		waitFor(QP.toaster);
//
//		// Assert toaster"Assessment Due date and time is mandatory"
//		Assert.assertEquals(getText(QP.toaster), "Assessment Due date and time is mandatory");
//
//		click(QP.toasterclosebtn);
//		waitThread(1000);
//
//		ScrollTo_xy_position(0, 0);
//		waitThread(500);
//
//		click(sb.clearall_btn);
//		waitThread(1000);
//		click(sb.confyes_btn);
//
//		waitFor(pr.assessmentde_toaster);
//
//		// Assert toaster
//		Assert.assertEquals(getText(pr.assessmentde_toaster), "Cleared successfully");
//		Assert.assertFalse(isEnabled(sb.clearall_btn), "button enabled");
//
//	}
//
//	/*
//	 * To fill the Test window open/due date and time,peer review Due date and time
//	 * ,Result publishing date and time
//	 */
//	@Test(priority = 33)
//	public void TCSPR0901033() {
//
//		// Select the Test Window Open date
//
//		click(sb.assessmentopendate_txtbx);
//		waitThread(1000);
//
//		// Assert calendar visible
//		Assert.assertTrue(isElementPresent(sb.assessopen_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		// Assert calendar not visible
//		Assert.assertFalse(isElementPresent(sb.assessopen_calendar), "Calendar   prsent");
//
//		Assert.assertTrue(isElementPresent(sb.Assessopenfilledtime), "time not visible");
//
//		waitThread(1000);
//
//		// Select the Test Window Due date
//		click(sb.assessmentduedate_txtbx);
//		waitThread(1000);
//
//		// Assert calendar visible
//		Assert.assertTrue(isElementPresent(sb.assessdue_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		// Assert calendar not visible
//		Assert.assertFalse(isElementPresent(sb.assessdue_calendar), "Calendar  prsent");
//
//		Assert.assertTrue(isElementPresent(sb.Assessduefilledtime), "time not visible");
//
//		waitThread(1000);
//
//		// Select the Peer Review Window closed date
//		click(sb.peerreviewduedate_txtbx);
//		waitThread(1000);
//
//		// Assert calendar visible
//		Assert.assertTrue(isElementPresent(sb.peerdue_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		// Assert calendar not visible
//		Assert.assertFalse(isElementPresent(sb.peerdue_calendar), "Calendar not  prsent");
//
//		Assert.assertTrue(isElementPresent(sb.peerduefilledtime), "time not visible");
//
//		waitThread(1000);
//
//		// Select the Result publishing date
//		click(sb.resultpublishdate_txtbx);
//		waitThread(1000);
//
//		// Assert calendar visible
//		Assert.assertTrue(isElementPresent(sb.resultpublish_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		// Assert calendar not visible
//		Assert.assertFalse(isElementPresent(sb.resultpublish_calendar), "Calendar not  prsent");
//
//		Assert.assertTrue(isElementPresent(sb.resultfilledtime), "time not visible");
//
//		waitThread(1000);
//
//	}
//
//	/*
//	 * To verify the valiation messages[for Peer review open date] when click on
//	 * save and next andsave and exit buttons
//	 */
//	@Test(priority = 34)
//	public void TCSPR0901034() {
//
//		click(pr.savennext_button);
//		waitFor(QP.toaster);
//
//		// Assert toaster"Peer Review Open date and time is mandatory"
//		Assert.assertEquals(getText(QP.toaster), "Peer Review Open date and time is mandatory");
//
//		click(QP.toasterclosebtn);
//
//		click(pr.savenexit_button);
//		waitFor(QP.toaster);
//
//		// Assert toaster"Peer Review Open date and time is mandatory"
//		Assert.assertEquals(getText(QP.toaster), "Peer Review Open date and time is mandatory");
//
//		click(QP.toasterclosebtn);
//		waitThread(1000);
//
//		ScrollTo_xy_position(0, 0);
//		waitThread(500);
//
//		click(sb.clearall_btn);
//		waitThread(1000);
//		click(sb.confyes_btn);
//
//		waitFor(pr.assessmentde_toaster);
//
//		// Assert toaster
//		Assert.assertEquals(getText(pr.assessmentde_toaster), "Cleared successfully");
//		Assert.assertFalse(isEnabled(sb.clearall_btn), "button enabled");
//
//	}
//
//	/*
//	 * To fill the Test window open/due date and time,peer review open date and time
//	 * ,Result publishing date and time
//	 */
//	@Test(priority = 35)
//	public void TCSPR0901035() {
//
//		// Select the Test Window Open date
//		click(sb.assessmentopendate_txtbx);
//		waitThread(1000);
//
//		// Assert calendar visible
//		Assert.assertTrue(isElementPresent(sb.assessopen_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		// Assert calendar not visible
//		Assert.assertFalse(isElementPresent(sb.assessopen_calendar), "Calendar prsent");
//
//		Assert.assertTrue(isElementPresent(sb.Assessopenfilledtime), "time not visible");
//
//		// Select the Test Window due date
//		waitThread(1000);
//		click(sb.assessmentduedate_txtbx);
//		waitThread(1000);
//		Assert.assertTrue(isElementPresent(sb.assessdue_calendar), "Calendar  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		// Assert calendar not visible
//		Assert.assertFalse(isElementPresent(sb.assessdue_calendar), "Calendar   prsent");
//
//		Assert.assertTrue(isElementPresent(sb.Assessduefilledtime), "time not visible");
//
//		waitThread(1000);
//
//		// Select the Peer Review Window open date
//		click(sb.peerreviewopendate_txtbx);
//		waitThread(1000);
//
//		// Assert calendar visible
//		Assert.assertTrue(isElementPresent(sb.peeropen_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		// Assert calendar not visible
//		Assert.assertFalse(isElementPresent(sb.peeropen_calendar), "Calendar  prsent");
//
//		Assert.assertTrue(isElementPresent(sb.peeropenfilledtime), "time not visible");
//
//		waitThread(1000);
//
//		waitThread(1000);
//
//		// Select the Result publish date
//		click(sb.resultpublishdate_txtbx);
//		waitThread(1000);
//
//		// Assert calendar visible
//		Assert.assertTrue(isElementPresent(sb.resultpublish_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		// Assert calendar not visible
//		Assert.assertFalse(isElementPresent(sb.resultpublish_calendar), "Calendar   prsent");
//
//		Assert.assertTrue(isElementPresent(sb.resultfilledtime), "time not visible");
//
//		waitThread(1000);
//
//	}
//
//	/*
//	 * To verify the valiation messages[for Peer review Due date] when click on save
//	 * and next andsave and exit buttons
//	 */
//	@Test(priority = 36)
//	public void TCSPR0901036() {
//
//		click(pr.savennext_button);
//		waitFor(QP.toaster);
//
//		// Assert toaster"Peer Review Due date and time is mandatory"
//		Assert.assertEquals(getText(QP.toaster), "Peer Review Due date and time is mandatory");
//
//		click(QP.toasterclosebtn);
//
//		click(pr.savenexit_button);
//		waitFor(QP.toaster);
//
//		// Assert toaster"Peer Review Due date and time is mandatory"
//		Assert.assertEquals(getText(QP.toaster), "Peer Review Due date and time is mandatory");
//
//		click(QP.toasterclosebtn);
//		waitThread(1000);
//
//		ScrollTo_xy_position(0, 0);
//		waitThread(500);
//
//		// click clear all button
//		click(sb.clearall_btn);
//		waitThread(1000);
//		click(sb.confyes_btn);
//
//		// Assert the toaster "Cleared successfully"
//		waitFor(pr.assessmentde_toaster);
//		Assert.assertEquals(getText(pr.assessmentde_toaster), "Cleared successfully");
//
//		// Assert the Clear all button is disable
//		Assert.assertFalse(isEnabled(sb.clearall_btn), "button enabled");
//
//	}
//
//	/*
//	 * To fill the Test window open/due date and time,peer review open/due date and
//	 * time
//	 */
//	@Test(priority = 37)
//	public void TCSPR0901037() {
//
//		click(sb.assessmentopendate_txtbx);
//		waitThread(1000);
//
//		// Assert calendar visible
//		Assert.assertTrue(isElementPresent(sb.assessopen_calendar), "Calendar not  prsent");
//
//		// Select the Test Window Open date
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		// Assert calendar not visible
//		Assert.assertFalse(isElementPresent(sb.assessopen_calendar), "Calendar   prsent");
//
//		// Assert time filled in textbox
//		Assert.assertTrue(isElementPresent(sb.Assessopenfilledtime), "time not visible");
//
//		waitThread(1000);
//		click(sb.assessmentduedate_txtbx);
//		waitThread(1000);
//		Assert.assertTrue(isElementPresent(sb.assessdue_calendar), "Calendar not  prsent");
//
//		// Select the Test Window Due date
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		// Assert calendar visible
//		Assert.assertFalse(isElementPresent(sb.assessdue_calendar), "Calendar not  prsent");
//
//		Assert.assertTrue(isElementPresent(sb.Assessduefilledtime), "time not visible");
//
//		waitThread(1000);
//		click(sb.peerreviewopendate_txtbx);
//		waitThread(1000);
//
//		// Assert calendar visible
//		Assert.assertTrue(isElementPresent(sb.peeropen_calendar), "Calendar not  prsent");
//
//		// Select the Peer Review Window open date
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		// Assert calendar not visible
//		Assert.assertFalse(isElementPresent(sb.peeropen_calendar), "Calendar   prsent");
//
//		Assert.assertTrue(isElementPresent(sb.peeropenfilledtime), "time not visible");
//
//		waitThread(1000);
//		click(sb.peerreviewduedate_txtbx);
//		waitThread(1000);
//
//		// Assert calendar visible
//		Assert.assertTrue(isElementPresent(sb.peerdue_calendar), "Calendar not  prsent");
//
//		// Select the Peer Review Window Due date
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		// Assert calendar not visible
//		Assert.assertFalse(isElementPresent(sb.peerdue_calendar), "Calendar not  prsent");
//
//		Assert.assertTrue(isElementPresent(sb.peerduefilledtime), "time not visible");
//
//	}
//
//	/*
//	 * To verify the valiation messages[for Result publishing date] when click on
//	 * save and next andsave and exit buttons
//	 */
//	@Test(priority = 38)
//	public void TCSPR0901038() {
//
//		click(pr.savennext_button);
//		waitFor(QP.toaster);
//
//		// Assert toaster"Result publishing date and time is mandatory"
//		Assert.assertEquals(getText(QP.toaster), "Result publishing date and time is mandatory");
//
//		click(QP.toasterclosebtn);
//
//		click(pr.savenexit_button);
//		waitFor(QP.toaster);
//
//		// Assert toaster"Result publishing date and time is mandatory"
//		Assert.assertEquals(getText(QP.toaster), "Result publishing date and time is mandatory");
//
//		click(QP.toasterclosebtn);
//		waitThread(1000);
//
//		click(sb.clearall_btn);
//		waitThread(1000);
//		click(sb.confyes_btn);
//
//		// Assert the toaster "Cleared successfully"
//		waitFor(pr.assessmentde_toaster);
//		Assert.assertEquals(getText(pr.assessmentde_toaster), "Cleared successfully");
//
//		// Assert the Clear all button is disable
//		Assert.assertFalse(isEnabled(sb.clearall_btn), "button enabled");
//
//	}
//
//	/*
//	 * To fill the Result publishing date and time
//	 */
//	@Test(priority = 39)
//	public void TCSPR0901039() {
//
//		waitThread(1000);
//
//		// elect the Result publishing date
//		click(sb.resultpublishdate_txtbx);
//		waitThread(1000);
//
//		// Assert calendar visible
//		Assert.assertTrue(isElementPresent(sb.resultpublish_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		//// Assert calendar not visible
//		Assert.assertFalse(isElementPresent(sb.resultpublish_calendar), "Calendar   prsent");
//		waitThread(1000);
//
//		// Assert the time visible on the text box
//		Assert.assertTrue(isElementPresent(sb.resultfilledtime), "time not visible");
//
//	}
//
//	/*
//	 * To verify the Open/Due date and time of Test window when selecting current
//	 * date To verify the Test Window Open and Due time having 30 min Difference
//	 */
//	@Test(priority = 40)
//	public void TCSPR0901040() {
//
//		ScrollTo_xy_position(0, 0);
//		waitThread(1000);
//
//		// Click on Clear All button
//		click(sb.clearall_btn);
//		waitThread(1000);
//		click(sb.confyes_btn);
//
//		waitFor(pr.assessmentde_toaster);
//
//		// *Assert the toaster "Cleared successfully"
//		Assert.assertEquals(getText(pr.assessmentde_toaster), "Cleared successfully");
//
//		// Assert the Clear all button is disable
//		Assert.assertFalse(isEnabled(sb.clearall_btn), "button enabled");
//
//		// Select the Test Window Open date as today's date
//		click(sb.assessmentopendate_txtbx);
//		waitThread(1000);
//
//		Assert.assertTrue(isElementPresent(sb.assessopen_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		Assert.assertFalse(isElementPresent(sb.assessopen_calendar), "Calendar   prsent");
//
//		// Assert the date selected on the textbox
//		Assert.assertEquals(getValue(sb.assessmentopendate_txtbx), sb.getdate());
//
//		Assert.assertTrue(isElementPresent(sb.Assessopenfilledtime), "time not visible");
//
//		waitThread(1000);
//
//		// Select the Test Window Due date as today's date
//		click(sb.assessmentduedate_txtbx);
//		waitThread(1000);
//
//		Assert.assertTrue(isElementPresent(sb.assessdue_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		Assert.assertFalse(isElementPresent(sb.assessdue_calendar), "Calendar   prsent");
//		waitThread(1000);
//
//		// Assert the Test Window Open time and Due time having 30 min difference
//		Assert.assertEquals(sb.geTtimedifferenceminute(sb.assessmentopentime_txtbx, sb.assessmentduetime_txtbx), "30");
//
//		// click test window due time text box
//		click(sb.assessmentduetime_txtbx);
//
//		waitThread(1000);
//		Assert.assertTrue(isElementPresent(sb.timepicker), "Calendar not  prsent");
//
//		waitThread(1000);
//		Doubleclick(sb.timedes_arrow);
//		waitThread(3000);
//
//		String H = getText(sb.hour_label);
//		String M = getText(sb.minute_label);
//		String A = getText(sb.am_label);
//
//		// Assert that can't reduce the Due time from 30 min
//		Assert.assertEquals(getValue(sb.assessmentduetime_txtbx), H + ":" + M + " " + A);
//
//	}
//
//	/*
//	 * To verify the Open/Due date and time of Peer review window when selecting
//	 * current date --To verify the Peer review Open/Due time having 30 min
//	 * Difference
//	 */
//	@Test(priority = 41)
//	public void TCSPR0901041() {
//
//		waitThread(1000);
//
//		// Select the Peer review Window Open date as today's date
//		click(sb.peerreviewopendate_txtbx);
//		waitThread(2000);
//
//		Assert.assertTrue(isElementPresent(sb.peeropen_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		Assert.assertFalse(isElementPresent(sb.peeropen_calendar), "Calendar not  prsent");
//
//		// Assert the date selected on the textbox
//		String difference1 = sb.getdatedifference(sb.assessmentopendate_txtbx, sb.peerreviewopendate_txtbx);
//		int d1 = Integer.valueOf(difference1);
//
//		if (d1 == 0) {
//			Assert.assertEquals(sb.getdatedifference(sb.assessmentopendate_txtbx, sb.peerreviewopendate_txtbx), "0");
//
//		} else if (d1 >= 1) {
//			Assert.assertEquals(sb.getdatedifference(sb.assessmentopendate_txtbx, sb.peerreviewopendate_txtbx), "1");
//
//		}
//
//		waitThread(1000);
//
//		// Select the Peer review Due date as today's date
//		click(sb.peerreviewduedate_txtbx);
//		waitThread(1000);
//
//		Assert.assertTrue(isElementPresent(sb.peerdue_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		Assert.assertFalse(isElementPresent(sb.peerdue_calendar), "Calendar not  prsent");
//		waitThread(1000);
//
//		// Assert the Peer review Open time and Due time having 30 min difference
//		Assert.assertEquals(sb.geTtimedifferenceminute(sb.peerreviewopentime_txtbx, sb.peerreviewduetime_txtbx), "30");
//
//		click(sb.peerreviewduetime_txtbx);
//		waitThread(1000);
//
//		waitThread(1000);
//
//		// Assert time picker visible
//		Assert.assertTrue(isElementPresent(sb.timepicker2), "Time picker not  prsent");
//		waitThread(1000);
//
//		Doubleclick(sb.timedes_arrow2);
//		waitThread(3000);
//
//		String H = getText(sb.hour_label2);
//		String M = getText(sb.minute_label2);
//		String A = getText(sb.am_label2);
//
//		// Assert that can't reduce the Due time from 30 min
//		Assert.assertEquals(getValue(sb.peerreviewduetime_txtbx), H + ":" + M + " " + A);
//
//	}
//
//	/*
//	 * To verify the Result Publishing date when selecting current date -To verify
//	 * the Result Publishing time and Reconsideration Request time having 30 min
//	 * Difference
//	 */
//	@Test(priority = 42)
//	public void TCSPR0901042() {
//
//		waitThread(1000);
//
//		// Select the Result Publishing date as today's date
//		click(sb.resultpublishdate_txtbx);
//		waitThread(1000);
//
//		Assert.assertTrue(isElementPresent(sb.resultpublish_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		Assert.assertFalse(isElementPresent(sb.resultpublish_calendar), "Calendar not  prsent");
//
//		// Assert the date selected on the textbox
//
//		String difference1 = sb.getdatedifference(sb.assessmentopendate_txtbx, sb.resultpublishdate_txtbx);
//		int d1 = Integer.valueOf(difference1);
//
//		if (d1 == 0) {
//			Assert.assertEquals(sb.getdatedifference(sb.assessmentopendate_txtbx, sb.resultpublishdate_txtbx), "0");
//
//		} else if (d1 >= 1) {
//			Assert.assertEquals(sb.getdatedifference(sb.assessmentopendate_txtbx, sb.resultpublishdate_txtbx), "1");
//
//		}
//
//		Assert.assertTrue(isElementPresent(sb.resultfilledtime), "time not visible");
//
//		waitThread(500);
//
//		Scroll_DowntoEnd();
//		waitThread(1000);
//
//		// Select the Allow students to raise a Reconsideration Request as today's date
//		click(sb.allowstu_checkbx2);
//
//		waitThread(1000);
//
//		click(sb.lastdate_txtbx);
//		waitThread(1000);
//
//		Assert.assertTrue(isElementPresent(sb.allowstu_calendar), "Calendar not  prsent");
//
//		Doubleclick(sb.calanderdate_val);
//		waitThread(3000);
//
//		Assert.assertFalse(isElementPresent(sb.allowstu_calendar), "Calendar not  prsent");
//		waitThread(1000);
//
//		// Assert the Result Publishing time and Reconsideration Request time having 30
//		// min difference
//		Assert.assertEquals(sb.geTtimedifferenceminute(sb.resultpublishtime_txtbx, sb.lastdatetime_txtbx), "30");
//
//		// Click on save &next button
//		click(pr.savennext_button);
//		waitFor(QP.toaster);
//
//		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
//
//		click(QP.toasterclosebtn);
//		waitThread(1000);
//
//		// Assert the summary wizard is selected
//		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");
//
//		click(sb.schedule_wizard);
//		waitThread(1000);
//		// Assert the schedule wizard is selected
//		Assert.assertTrue(isEnabled(sb.schedule_wizard), "schedule wizard is not selected");
//
//	}
//
//	public String maxscore;
//
//	/*
//	 * To Add a new questions from question page
//	 */
//	@Test(priority = 43)
//	public void TCSPR0901043() {
//
//		click(pr.question_wizard);
//
//		// To Add more questions to the questions page
//		waitThread(1000);
//
//		// Assert + button to add more questions
//		Assert.assertTrue(isElementPresent(mq.add_quest_btn), "Add more question button not present");
//
//		waitThread(1000);
//		// Click on +button
//		click(mq.add_quest_btn);
//		waitThread(1000);
//		// To enter the data on Question box
//		driver.switchTo().frame("question_ifr");
//
//		// click on Question box
//		Doubleclick(QP.Quest_box);
//
//		// Type a question on Question box
//		type(QP.Quest_box, "Question2");
//
//		driver.switchTo().defaultContent();
//
//		// Page scroll down
//		QP.Scroll_DowntoEnd();
//		waitThread(6000);
//
//		// Click rubric drop down
//		click(QP.rubric_drp_btn);
//		waitThread(3000);
//
//		// Click Standard rubric radio button
//		click(QP.std_rad);
//
//		// Assert the radio button is selected
//		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");
//
//		// Enter Condition
//		driver.switchTo().frame("rubric_ifr");
//
//		waitThread(2000);
//
//		// Type data in Standard Rubric box
//		type(QP.std_rub_bx, "R2");
//
//		driver.switchTo().defaultContent();
//		waitThread(1000);
//
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("scroll(0, -250);");
//
//		// Enter Max score
//		type(QP.max_scorbx, "3");
//
//		waitThread(2000);
//		// Click Save button
//		click(QP.save);
//		waitFor(QP.toaster);
//
//		// Assert the toaster "Saved successfully "
//		Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully");
//		click(QP.toasterclosebtn);
//		waitThread(2000);
//
//		maxscore = getText(QP.max_scoreposs_value);
//
//		// Click Save&Next button
//		click(QP.savenext_btn);
//
//		waitThread(2000);
//
//		// Assert the peer review wizard is selected
//		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");
//
//	}
//
//	/*
//	 * To check that the new question added and maximum score count updating on the
//	 * schedule page
//	 */
//	@Test(priority = 44)
//	public void TCSPR0901044() {
//
//		click(pr.savennext_button);
//		waitThread(4000);
//
//		// Assert the schedule wizard is selected
//		Assert.assertTrue(isEnabled(sb.schedule_wizard), "schedule wizard is not selected");
//
//		// Assert the maximum score possible is same as that in the question page
//		Assert.assertEquals(getText(sb.maxscorecount), maxscore);
//
//		// Assert the total question number count is 2
//		Assert.assertEquals(getText(sb.quescount_lbl), "2");
//
//	}
//
//	/*
//	 * To perform Delete TeacherAccount functionality
//	 */
//	@Test(priority = 45)
//	public void TCSPR0901045() {
//
//		cr.DeleteAccount();
//
//		// Heading Title-Login
//		Assert.assertEquals(getText(lg.PageTitle), "Login");
//
//		waitThread(2000);
//
//	}
//
//	/*
//	 * To perform login functionality using deleted teacher profile credentials
//	 */
//	@Test(priority = 46)
//	public void TCSPR0901046() {
//
//		// login using deleted account credentials
//		rs.login_Teacher(Emailteacher, password);
//
//		waitFor(lg.toaster);
//		// verify toaster text
//		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");
//
//	}
//
//	/*
//	 * To perform Delete student1 Account functionality
//	 */
//	@Test(priority = 47)
//	public void TCSPR0901047() {
//
//		// login using deleted account credentials
//		rs.login_Student(Emailstudent1, password);
//
//		cr.DeleteAccount();
//
//		// Heading Title-Login
//		Assert.assertEquals(getText(lg.PageTitle), "Login");
//
//		waitThread(2000);
//
//	}
//
//	/*
//	 * To perform login functionality using deleted student 1 profile credentials
//	 */
//	@Test(priority = 48)
//	public void TCSPR0901048() {
//
//		// login using deleted account credentials
//		rs.login_Student(Emailstudent1, password);
//
//		waitFor(lg.toaster);
//		// verify toaster text
//		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");
//
//	}
//
//	/*
//	 * To perform Delete student2 Account functionality
//	 */
//	@Test(priority = 49)
//	public void TCSPR0901049() {
//
//		// login using deleted account credentials
//		rs.login_Student(Emailstudent2, password);
//
//		cr.DeleteAccount();
//
//		// Heading Title-Login
//		Assert.assertEquals(getText(lg.PageTitle), "Login");
//
//		waitThread(2000);
//
//	}
//
//	/*
//	 * To perform login functionality using deleted student 2 profile credentials
//	 */
//	@Test(priority = 50)
//	public void TCSPR0901050() {
//
//		// login using deleted account credentials
//		rs.login_Student(Emailstudent2, password);
//
//		waitFor(lg.toaster);
//		// verify toaster text
//		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");
//
//	}
//}
