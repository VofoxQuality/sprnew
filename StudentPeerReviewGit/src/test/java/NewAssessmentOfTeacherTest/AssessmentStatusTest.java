package NewAssessmentOfTeacherTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import Course.Pages.EditCoursePage;
import CreateNewAssessment.Pages.AssessmentPublishPopupPage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CurrentAssessmentsforStudents.Pages.StudentTestSectionPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.AssessmentStatusPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class AssessmentStatusTest extends basePage {

	SignUpPage sp = new SignUpPage();
	LoginPage lg = new LoginPage();
	SignUpTest st = new SignUpTest();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	Databaseconnection dc = new Databaseconnection();
	CourseRosterPage cr = new CourseRosterPage();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	EditCoursePage ec = new EditCoursePage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	SchedulePageBasicsPage sb = new SchedulePageBasicsPage();
	SummaryBasicsPage sr = new SummaryBasicsPage();
	AssessmentStatusPage as = new AssessmentStatusPage();
	AssessmentPublishPopupPage ap = new AssessmentPublishPopupPage();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	CommonMethods cm = new CommonMethods();
	TeacherTestSectionPage tts = new TeacherTestSectionPage();
	StudentTestSectionPage st1 = new StudentTestSectionPage();
	TeacherPeerReviewSectionPage tp = new TeacherPeerReviewSectionPage();

	public String AssessmentName;
	public String NewAssessmentName;
	public String newAssessmentName;
	public String newAssessmentNameone;

	public String Emailteacher;
	public String teacherotp;
	public String studentotp;
	public String CourseNamenew;
	public String CourseID1;

	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";
	public String reward = "3";

	/*
	 * To perform Login functionality
	 */
	@Test(priority = 1)
	public void TCSPR1000601() {

		click(lg.LoginBtn_1);

		cm.login(cm.emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}
	/*
	 * To create new course
	 */
	// @Test(priority = 2)
//	public void TCSPR1000602() throws SQLException {
//
//		CourseName = "Course Name" + generateRandomNumber();
//
//		// Click on create new course button
//		click(cn.btn_createnew);
//
//		// To get the Course ID
//		CourseID = (getText(cn.course_Id));
//
//		// type-Course title
//		type(cn.txbx_Coursetitle, CourseName);
//
//		// click on Add students button
//		click(cn.btn_AddStudents);
//
//		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
//		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";
//
//		// type email
//		type(cn.tab_textbox, Emailstudent1 + ",");
//		driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
//		type(cn.tab_textbox, Emailstudent2 + ",");
//
//		// verify email present on the text box
//		Assert.assertEquals(cn.emailvalue(0), Emailstudent1);
//
//		Assert.assertEquals(cn.emailvalue(1), Emailstudent2);
//
//		// click on add to list button
//		click(cn.tab_btn_Addtolist);
//
//		waitThread(2000);
//		waitFor(cr.emailval_1);
//
//		// verify the Email on the New Students to be invited to this class box
//		Assert.assertEquals(getText(cr.emailval_1), Emailstudent1);
//		Assert.assertEquals(getText(ps.emailval_2), Emailstudent2);
//
//		// click on create course button
//		click(cn.btn_Createcourse);
//
//		waitThread(1000);
//		waitFor(cn.toaster);
//
//		// verify toaster-Course created successfully
//		Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");
//
//		waitThread(3000);
//
//		// verify the course title
//		Assert.assertEquals(getText(cn.value_coursetitle).trim(), CourseName.trim());
//
//	}
	/*
	 * To perform logout functionality on the teacher profile
	 */

//	@Test(priority = 3)
//	public void TCSPR1000603() {
//
//		// logout functionality
//		rs.Logout();
//
//		// Heading Title-Login
//		Assert.assertEquals(getText(lg.PageTitle), "Login");
//
//	}

	/*
	 * To check that invited course request visible on first student 's profile and
	 * accept course request-Read the student name
	 */
//	@Test(priority = 4)
//	public void TCSPR1000604() throws SQLException {
//
//	
//
//		lg.login("student1@gmail.com", password);
//    	waitThread(5000);
//
//		// verify heading label
//		waitFor(rs.lbl_joincourse);
//		Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");
//
//		// verify course name visible
//		Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not Present");
//
//		// verify the the course name
//		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());
//
//	}
//	/*
//	 * To Accept course and perform logout functionality on the student profile
//	 */
//
//	@Test(priority = 5)
//	public void TCSPR1000605() {
//
//		// click on accept course button
//		click(rs.btn_acceptcourse);
//
//		// verify the confirmation popup visible
//		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");
//
//		// click on Yes button
//		click(rs.popupbtn_Yes);
//
//		// Toaster message
//		waitFor(rs.toaster);
//		Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
//
//		// verify the course name visibled on the enrolled section
//		waitFor(rs.enrolledcoursename);
//
//		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());
//		waitThread(3000);
//
//		// perform logout functionality
//		rs.Logout();
//
//		// Heading Title-Login
//		Assert.assertEquals(getText(lg.PageTitle), "Login");
//	}
//
//	/*
//	 * To check that invited course request visible on first student 's profile and
//	 * accept course request-Read the student name
//	 */
//	@Test(priority = 6)
//	public void TCSPR1000606() throws SQLException {
//
//		lg.login("student2@gmail.com", password);
//
//		waitThread(5000);
//
//		// verify heading label
//		waitFor(rs.lbl_joincourse);
//		Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");
//
//		// verify course name visible
//		Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not Present");
//
//		// verify the the course name
//		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());
//
//	}
//	/*
//	 * To Accept course and perform logout functionality on the student profile
//	 */
//
//	@Test(priority = 7)
//	public void TCSPR1000607() {
//
//		// click on accept course button
//		click(rs.btn_acceptcourse);
//
//		// verify the confirmation popup visible
//		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");
//
//		// click on Yes button
//		click(rs.popupbtn_Yes);
//
//		// Toaster message
//		waitFor(rs.toaster);
//		Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
//
//		// verify the course name visibled on the enrolled section
//		waitFor(rs.enrolledcoursename);
//		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());
//		waitThread(3000);
//
//		// perform logout functionality
//		rs.Logout();
//
//		// Heading Title-Login
//		Assert.assertEquals(getText(lg.PageTitle), "Login");
//	}

	public String CourseID = cm.CourseID1;
	public String CourseName = cm.CourseName1;

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */
	@Test(priority = 8)
	public void TCSPR1000608() {

		SoftAssert softAssert1 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(8000);
		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		waitThread(4000);
		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		softAssert1.assertEquals(getText(ba.ddcoursename1), CourseName.trim(),
				"course name not visible on the dropdown");

		click(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentName = "Assessment" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentName);

		waitThread(1000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(1000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(3000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), AssessmentName);

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID + ", " + CourseName.trim());

		softAssert1.assertAll();

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 9)
	public void TCSPR1000609() {

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

		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);

		// Click + button
		click(as.add_quest_btn);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		waitThread(2000);

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question2");

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
		type(QP.std_rub_bx, "R2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "5");
		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully");

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
	public void TCSPR1000610() {
		waitThread(2000);

		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 4");

	}

	public String assessmentopendate;
	public String assessmentopentime;
	public String assessmentduedate;
	public String assessmentduetime;

	public String peerreviewopendate;
	public String peerreviewopentime;
	public String peerreviewduedate;
	public String peerreviewduetime;
	public String resultpublishdate;
	public String resultpublishtime;
	public String lastdateforrecon;
	public String lasttimeforrecon;

	/*
	 * To perform the save and next functionaity from peer review page and verify
	 * the schedule page details
	 */
	@Test(priority = 11)
	public void TCSPR1000611() {

		// Type peer review reward score
		type(pr.PRreward_txtbox, reward);

		waitThread(3000);

		waitThread(4000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(2000);
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");

		// Assert the text "Select schedules for "
		Assert.assertEquals(getText(sb.selectstu_lbl), "Select Schedules for");

		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.Sbassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseName.trim()));

		// Assert that the Assessment Open date is Today's date
		Assert.assertEquals(getValue(sb.assessmentopendate_txtbx), sb.getdate());

		waitThread(3000);

		// Set Assessment open time as upcoming time(next day)

		click(sb.assessmentopendate_txtbx);
		waitThread(2000);

		cm.ClicktomorrowDate();

		// Read date and time
		assessmentopendate = getValue(sb.assessmentopendate_txtbx);
		assessmentopentime = getValue(sb.assessmentopentime_txtbx);
		assessmentduedate = getValue(sb.assessmentduedate_txtbx);
		assessmentduetime = getValue(sb.assessmentduetime_txtbx);

		peerreviewopendate = getValue(sb.peerreviewopendate_txtbx);
		peerreviewopentime = getValue(sb.peerreviewopentime_txtbx);
		peerreviewduedate = getValue(sb.peerreviewduedate_txtbx);
		peerreviewduetime = getValue(sb.peerreviewduetime_txtbx);

		Scroll_DowntoEnd();
		waitThread(1000);
		resultpublishdate = getValue(sb.resultpublishdate_txtbx);
		resultpublishtime = getValue(sb.resultpublishtime_txtbx);

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

	}

	/*
	 * To verify the details on the Summary page & publish the Assessment
	 */
	@Test(priority = 12)
	public void TCSPR1000612() {

		waitThread(3000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sr.summarywizard, "aria-selected"), "true");

		// Assert the label assessment name,
		Assert.assertTrue(getText(sr.summaryassessmentname).contains("Assessment Name: " + AssessmentName));

		// Assert course code,course name
		Assert.assertTrue(getText(sr.summarycoursename).contains(CourseID));
		Assert.assertTrue(getText(sr.summarycoursename).contains(CourseName.trim()));

	}

	/*
	 * To perform Assessment publish functionality
	 */
	@Test(priority = 13)
	public void TCSPR1000613() {

		// click release button
		click(ap.relese_btn);
		waitThread(1000);
		waitFor(QP.toaster);

		// Assert the toaster "Assessment published successfully "
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");

		click(QP.toasterclosebtn);

		// Assert the popup visible
		Assert.assertTrue(isElementPresent(ap.publish_popup), "popup not visible");

		// Assert toaster "Assessment published successfully
		Assert.assertEquals(getText(ap.Assessmentcreated_lbl), "Assessment Created Successfully");

		// Assert button Back to Menu
		Assert.assertTrue(isElementPresent(ap.Backtomenu_btn), "button not visible");

	}

	/*
	 * To check the published Assessment card
	 */
	@Test(priority = 14)
	public void TCSPR1000614() {

		// Click on Back to menu button
		click(ap.Backtomenu_btn);

		waitThread(2000);

		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(ap.publish_popup), "popup not visible");

		// Assert the Current Assessment is selected
		Assert.assertEquals(getAttribute(ap.currentassess_tab, "aria-selected"), "true");

		click(as.search_box);
		// search newly created assessment
		type(as.search_box, AssessmentName);
		waitThread(1000);

		// Assert the newly published card visible on the current assessment page
		Assert.assertTrue(isElementPresent(as.newcard), " new assessment card not visible");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(as.newasses_lbl), AssessmentName);
		Assert.assertTrue(getText(as.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(as.course_lbl).contains(CourseID));

	}

	/*
	 * To check the published Assessment card
	 */
	@Test(priority = 15)
	public void TCSPR1000615() {

		// Assert test status
		Assert.assertEquals(getText(tp.teststs_lbl), "Pending");

		// Assert the tooltips of Assessment name, course name& ID
		MouseHover(as.asses_name_card);
		Assert.assertEquals(getAttribute(as.asses_name_card, "tooltipposition"), "top");

		MouseHover(as.course_nameid_card);
		Assert.assertEquals(getAttribute(as.course_nameid_card, "tooltipposition"), "bottom");

		// Assert the test upcoming status time
		Assert.assertTrue(isDisplayed(as.time_status), "Time status not displayed");

	}

	/*
	 * To check Assessment status card
	 */
	@Test(priority = 16)
	public void TCSPR1000616() {

		// Assert the view details button
		Assert.assertTrue(isElementPresent(as.viewdetails1_btn), "Button not visible");

		// Click View details button
		click(as.viewdetails1_btn);
		waitThread(2000);

		// Assert the Assessment status popup visible
		Assert.assertTrue(isElementPresent(as.assessmentsts_popup), "popup not visible");

		// Assert the label "Assessment status"
		Assert.assertEquals(getText(as.assessmentsts_lbl), "Assessment Status");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(as.assessname_lbl), AssessmentName);
		Assert.assertTrue(getText(as.coursename_lbl).contains(CourseName));

		Assert.assertTrue(getText(as.coursename_lbl).contains(CourseID));
		Assert.assertEquals(getText(as.totalnoname_lbl), "Total Students : 4");

	}

	/*
	 * To check the Status of Test , peer review & Result
	 */
	@Test(priority = 17)
	public void TCSPR1000617() {

		// Assert the test Pending
		Assert.assertEquals(getText(as.teststs_lbl), "Pending");

		// Assert Peer Review pending
		Assert.assertEquals(getText(as.peersts_lbl), "Pending");

		// Assert Result Pending
		Assert.assertEquals(getText(as.resultsts_lbl), "Pending");

	}

	/*
	 * To check the time date of test , peer review & Result
	 */
	@Test(priority = 18)
	public void TCSPR1000618() {

		waitThread(2000);

		// Assert the Test open date&time in the popup with schedule page
		as.popupdatetimesplitmethod();
		Assert.assertEquals(as.getdates(as.datetestopen), assessmentopendate);
		Assert.assertEquals(as.timetestopen, assessmentopentime);

		waitThread(4000);
		// Assert the test due time with schedule date& time
		as.popupdatetimesplitmethod();
		Assert.assertEquals(as.getdates(as.datetestdue), assessmentduedate);
		Assert.assertEquals(as.timetestdue, assessmentduetime);

		// Assert the Peer review open time with schedule open date & time
		as.popupdatetimesplitmethod();
		Assert.assertEquals(as.getdates(as.datereviewopen), peerreviewopendate);
		Assert.assertEquals(as.timereviewopen, peerreviewopentime);

		// Assert the Peer review due time with schedule date& time
		as.popupdatetimesplitmethod();
		Assert.assertEquals(as.getdates(as.datereviewdue), peerreviewduedate);
		Assert.assertEquals(as.timereviewdue, peerreviewduetime);

		// Assert the result publishing date & time with schedule page
		as.popupresultmethod();
		Assert.assertEquals(as.getdates(as.resultdate), resultpublishdate);
		Assert.assertEquals(as.resultime, resultpublishtime);

	}

	/*
	 * To check the peer review section in the status popup
	 */
	@Test(priority = 19)
	public void TCSPR1000619() {

		waitThread(3000);
		// Assert the Peer review reward: points
		Assert.assertEquals(getText(as.peerreward_lbl), "Peer Review Reward Percentage: " + reward);

		// Assert the questions answered count
		Assert.assertEquals(getText(as.questioncount), "0/2");
	}

	/*
	 * To check the labels in status popup
	 */
	@Test(priority = 20)
	public void TCSPR1000620() {

		// Assert grid labels
		Assert.assertEquals(getText(as.studentname_lbl), "Student Name");
		Assert.assertEquals(getText(as.questans_lbl), "Questions Answered");
		Assert.assertEquals(getText(as.ansshe_lbl), "Submitted");
		Assert.assertEquals(getText(as.peerre_lbl), "Answer Sheets Assigned For Peer Reviewer");
		Assert.assertEquals(getText(as.reward_lbl), "Peer Review Completed");
		Assert.assertEquals(getText(as.lb6), "Reward Score");
	}

	public String assessmentopendate1;
	public String testopentime;

	/*
	 * To Reschedule the test open time
	 */
	@Test(priority = 21)
	public void TCSPR1000621() throws InterruptedException {

		click(as.close_btn);
		waitThread(1000);

		// search newly created assessment
		type(rd.search_box, AssessmentName);

		// click menu button
		click(rd.threedot_btn);

		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(5000);

		// Select the Test Window open date
		click(rd.assessmentopendate_txtbx);

		// Set the Assessment open date to current day
		cm.ClickTodaysDate();

		assessmentopendate1 = getValue(st1.resche_testopendat_txtbx);
		testopentime = getValue(st1.resche_testopentime_txtbx);

		// click apply changes button
		click(rd.applychanges_btn);

		waitFor(QP.toaster);
		// Assert toaster "Changes applied"
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		waitThread(4000);

		click(rd.search_box);
		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(4000);
		TimeUnit.SECONDS.sleep(20);
		// Assert the test Active
		Assert.assertEquals(getText(tts.test_pending), "Active");

		// Assert the test open date & time of card is same as Reschedule date popup
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestopen), assessmentopendate1);
		Assert.assertEquals(cm.timetestopen, testopentime);

	}

	/*
	 * To check the Status popup of active test
	 */
	@Test(priority = 22)
	public void TCSPR1000622() {

		click(as.viewdetails1_btn);
		waitThread(2000);

		Assert.assertTrue(isElementPresent(as.assessmentsts_popup), "popup not visible");

		// Assert the Test open date & time
		as.popupdatetimesplitmethod();
		Assert.assertEquals(as.getdates(as.datetestopen), assessmentopendate1);
		Assert.assertEquals(as.timetestopen, testopentime);

		Assert.assertEquals(getText(as.teststs_lbl), "Active");
		Assert.assertEquals(getText(as.peersts_lbl), "Pending");
		Assert.assertEquals(getText(as.resultsts_lbl), "Pending");

	}

	public String assessmentduedate1;
	public String testduetime;

	/*
	 * To Reschedule the test due time
	 */
	@Test(priority = 23)
	public void TCSPR1000623() throws InterruptedException {

		click(as.close_btn);
		waitThread(1000);

		// search newly created assessment
		type(rd.search_box, AssessmentName);

		// click menu button
		click(rd.threedot_btn);

		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(1000);

		waitThread(2000);
		// Set the Assessment due date to current day
		Doubleclick(rd.assessmentduedate_txtbx);
		waitThread(2000);
		cm.ClickTodaysDate();

		assessmentduedate1 = getValue(st1.resche_testduedat_txtbx);
		testduetime = getValue(st1.resche_testendtime_txtbx);

		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitFor(QP.toaster);
		// Assert toaster "Changes applied"
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		waitThread(3000);

		click(rd.search_box);
		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(5000);
		TimeUnit.SECONDS.sleep(10);

		// Assert the card with rescheduled date
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestdue), assessmentduedate1);
		Assert.assertEquals(cm.timetestdue, testduetime);

		// Assert the Test Status is Closed
		Assert.assertEquals(getText(tp.teststs_lbl), "Window Closed");

	}

	/*
	 * To check the Status popup of active test
	 */
	@Test(priority = 24)
	public void TCSPR1000624() {

		click(as.viewdetails1_btn);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(as.assessmentsts_popup), "popup not visible");

		// Assert the due time with rescheduled time
		as.popupdatetimesplitmethod();
		Assert.assertEquals(as.getdates(as.datetestdue), assessmentduedate1);
		Assert.assertEquals(as.timetestdue, testduetime);

		// Assert peer review&result date visible

		Assert.assertEquals(getText(as.teststs_lbl), "Window Closed");
		Assert.assertEquals(getText(as.peersts_lbl), "Pending");
		Assert.assertEquals(getText(as.resultsts_lbl), "Pending");

	}

	public String peerreviewopendate1;
	public String peerreviewopentime1;

	/*
	 * To Reschedule the Peer review open time
	 */
	@Test(priority = 25)
	public void TCSPR1000625() throws InterruptedException {

		click(as.close_btn);
		waitThread(1000);

		// click menu button
		click(rd.threedot_btn);

		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(2000);

		// Set the Peer Review open date to current day
		Doubleclick(rd.peerreviewopendate_txtbx);
		cm.ClickTodaysDate();

		peerreviewopendate1 = getValue(st1.resche_peeropendat_txtbx);
		peerreviewopentime1 = getValue(st1.resche_peeropen_time_txtbx);

		waitThread(2000);
		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitFor(QP.toaster);
		// Assert toaster "Changes applied"
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		waitThread(3000);

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(1000);

		// Assert the card with rescheduled peer review open date
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewopen), peerreviewopendate1);
		Assert.assertEquals(cm.timereviewopen, peerreviewopentime1);

		// Assert peer review window active
		Assert.assertEquals(getText(tp.peersts_lbl), "Active");
	}

	/*
	 * To check the Status popup of active review
	 */
	@Test(priority = 26)
	public void TCSPR1000626() {

		click(as.viewdetails1_btn);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(as.assessmentsts_popup), "popup not visible");

		// Assert the peer review open time with rescheduled time
		as.popupdatetimesplitmethod();
		Assert.assertEquals(as.getdates(as.datereviewopen), peerreviewopendate1);
		Assert.assertEquals(as.timereviewopen, peerreviewopentime1);

		Assert.assertEquals(getText(as.teststs_lbl), "Window Closed");
		Assert.assertEquals(getText(as.peersts_lbl), "Active");
		Assert.assertEquals(getText(as.resultsts_lbl), "Pending");

	}

	public String peerreviewduedate2;
	public String peerreviewduetime2;

	/*
	 * To Reschedule the Peer review due time
	 */
	@Test(priority = 27)
	public void TCSPR1000627() throws InterruptedException {

		click(as.close_btn);
		waitThread(1000);
		waitThread(3000);

		click(rd.search_box);
		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(3000);

		// Click menu button on Assessment card
		click(st1.split_btn);

		waitThread(2000);
		// Click reschedule dates
		click(st1.reschedule_button);

		waitThread(2000);

		// Click on peer due date
		// Select peerreview due date as today's date
		Doubleclick(st1.resche_peerdue_date_txtbx);
		cm.ClickTodaysDate();

		// Assert the time on the text box
		Assert.assertEquals(getValue(st1.resche_peerdue_date_txtbx), st1.getdate());

		peerreviewduedate2 = getValue(st1.resche_peerdue_date_txtbx);
		peerreviewduetime2 = getValue(st1.resche_peerduetime_txtbx);

		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitFor(QP.toaster);
		// Assert toaster "Changes applied"
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		waitThread(4000);

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(3000);

		// Assert the card with rescheduled date
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewdue), peerreviewduedate2);
		Assert.assertEquals(cm.timereviewdue, peerreviewduetime2);
	}

	/*
	 * To check the Status popup of active test
	 */
	@Test(priority = 28)
	public void TCSPR1000628() {

		waitThread(5000);

		click(as.viewdetails1_btn);

		waitThread(2000);
		Assert.assertTrue(isElementPresent(as.assessmentsts_popup), "popup not visible");

		waitThread(3000);

		// Assert the due time with rescheduled time
		as.popupdatetimesplitmethod();
		Assert.assertEquals(as.getdates(as.datereviewdue), peerreviewduedate2);
		Assert.assertEquals(as.timereviewdue, peerreviewduetime2);

		Assert.assertEquals(getText(as.teststs_lbl), "Window Closed");
		Assert.assertEquals(getText(as.peersts_lbl), "Window Closed");
		Assert.assertFalse(isElementPresent(as.resultsts_lbl), "Result status visible");
		// Assert.assertEquals(getText(as.resultsts_lbl), "Pending");

	}

	public String resultpublishdate1;
	public String resultpublishtime1;

	/*
	 * To Reschedule the Result publishing date
	 */
	@Test(priority = 29)
	public void TCSPR1000629() throws InterruptedException {

		click(as.close_btn);
		waitThread(4000);

		waitThread(3000);

		click(rd.search_box);
		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(3000);

		// click menu button
		click(rd.threedot_btn);

		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(3000);

		// Set the Result publishing to current day
		Doubleclick(st1.resche_resultdate_txtbx);
		cm.ClickTodaysDate();

		resultpublishdate1 = getValue(st1.resche_resultdate_txtbx);
		resultpublishtime1 = getValue(st1.resche_resultime_txtbx);

		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitFor(QP.toaster);
		// Assert toaster "Changes applied"
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		waitThread(3000);

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(2000);

		// Assert the due time with rescheduled time
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.resultdate), resultpublishdate1);
		Assert.assertEquals(cm.resultime, resultpublishtime1);

		// Assert the Result Status is pending
		Assert.assertEquals(getText(tp.resultsts_lbl), "Pending");

		TimeUnit.MINUTES.sleep(10);
	}

	/*
	 * To check the Status popup of active Result
	 */
	@Test(priority = 30)
	public void TCSPR1000630() {

		// Click View details button
		click(as.viewdetails1_btn);
		waitThread(4000);

		Assert.assertTrue(isElementPresent(as.assessmentsts_popup), "popup not visible");
	}

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */
	@Test(priority = 31)
	public void TCSPR1000631() {

		SoftAssert softAssert2 = new SoftAssert();
		waitThread(2000);
		click(as.close_btn);

		waitThread(7000);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		waitThread(3000);
		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		Assert.assertEquals(getText(ba.ddcoursename1), CourseName.trim(), "course name not visible on the dropdown");

		click(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		NewAssessmentName = "Assessment1" + generateRandomNumber().trim();

		type(QP.Assess_name, NewAssessmentName);

		waitThread(1000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(1000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(3000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), NewAssessmentName);

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID + ", " + CourseName.trim());

		softAssert2.assertAll();

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 32)
	public void TCSPR1000632() {

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
	 * To verify the details on the peer review page & Add peer review Reward score
	 */
	@Test(priority = 33)
	public void TCSPR1000633() {

		waitThread(3000);

		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + NewAssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 4");

		reward = "3";
		// Type peer review reward score
		type(pr.PRreward_txtbox, reward);

		// *Assert the peer review score 1 on the grid
		Assert.assertEquals(getValue(pr.PRreward_txtbox), reward);

	}

	/*
	 * To perform the save and next functionaity from peer review page and verify
	 * the schedule page details
	 */
	@Test(priority = 34)
	public void TCSPR1000634() {

		click(pr.savennext_button);

		waitThread(2000);
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");

		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.Sbassessmentname_lbl).contains("Assessment Name: " + NewAssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseName.trim()));

		waitThread(2000);

		// Assert the assessment open date is current day
		Assert.assertEquals(getValue(sb.assessmentopendate_txtbx), sb.getdate());
	}

	/*
	 * To fill the Schedule page details without Reconsideration request dat
	 */
	@Test(priority = 35)
	public void TCSPR1000635() {

		// click teacher publish result radio button
		click(tts.teacher_publish_radiobtn);

		waitThread(2000);
		// Allow Reconsideration checkbox
		click(sb.allowstu_checkbx2);

		waitThread(2000);
		// Assert the time box visible
		Assert.assertTrue(isElementPresent(sb.lasttime_txtbx), "Time textbox not visible");

		waitThread(2000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);

	}

	/*
	 * To verify the details on the Summary page
	 */
	@Test(priority = 36)
	public void TCSPR1000636() {
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");
		waitThread(2000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(sr.summaryassessmentname).contains("Assessment Name: " + NewAssessmentName));

		// Assert course code,course name
		Assert.assertTrue(getText(sr.summarycoursename).contains(CourseID));
		Assert.assertTrue(getText(sr.summarycoursename).contains(CourseName.trim()));

	}

	/*
	 * To perform Assessment publish functionality
	 */
	@Test(priority = 37)
	public void TCSPR1000637() {

		// click release button
		click(ap.relese_btn);
		waitFor(QP.toaster);

		// Assert the toaster "Assessment published successfully "
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");

		click(QP.toasterclosebtn);

		// Assert the popup visible
		Assert.assertTrue(isElementPresent(ap.publish_popup), "popup not visible");

		// Assert toaster "Assessment published successfully
		Assert.assertEquals(getText(ap.Assessmentcreated_lbl), "Assessment Created Successfully");

		// Assert button Back to Menu
		Assert.assertTrue(isElementPresent(ap.Backtomenu_btn), "button not visible");

	}

	/*
	 * To check the published Assessment card
	 */
	@Test(priority = 38)
	public void TCSPR1000638() {

		// Click on Back to menu button
		click(ap.Backtomenu_btn);

		waitThread(2000);

		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(ap.publish_popup), "popup not visible");

		// Assert the Current Assessment is selected
		Assert.assertEquals(getAttribute(ap.currentassess_tab, "aria-selected"), "true");

		// search newly created assessment
		type(as.search_box, NewAssessmentName);
		waitThread(1000);

		// Assert the newly published card visible on the current assessment page
		Assert.assertTrue(isElementPresent(as.newcard), " new assessment card not visible");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(as.newasses_lbl), NewAssessmentName);
		Assert.assertTrue(getText(as.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(as.course_lbl).contains(CourseID));

	}

	/*
	 * To check assessment status popup dates
	 */
	@Test(priority = 39)
	public void TCSPR1000639() {

		click(as.viewdetails1_btn);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(as.assessmentsts_popup), "popup not visible");

		// Assert no result date & time visible
		Assert.assertFalse(isElementPresent(as.resultpublishdate_lbl2), "no result date & time visible");

		// Assert the Total Peer Review percentage
		Assert.assertEquals(getText(as.peerreward_lblcount), reward);

	}

	/*
	 * To perform log out functionality
	 */
	@Test(priority = 40)
	public void TCSPR1000640() {
		waitThread(2000);
		click(as.close_btn);

		waitThread(1000);

		// Assert the popup visible
		Assert.assertFalse(isElementPresent(as.assessmentsts_popup), "popup not visible");

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}
}
