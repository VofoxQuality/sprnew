package NewAssessmentOfTeacherTest;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryQuestionsPage;
import CurrentAssessmentsforStudents.Pages.StudentTestSectionPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class TeacherPeerReviewSectionTest extends basePage {

	SignUpPage sp = new SignUpPage();
	LoginPage lg = new LoginPage();
	SignUpTest st = new SignUpTest();
	Databaseconnection dc = new Databaseconnection();
	CourseRosterPage cr = new CourseRosterPage();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	EncryptedText et = new EncryptedText();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	SchedulePageBasicsPage sb = new SchedulePageBasicsPage();
	AssessmentPublishPopupPage ap = new AssessmentPublishPopupPage();
	CommonMethods cm = new CommonMethods();
	TeacherPeerReviewSectionPage tp = new TeacherPeerReviewSectionPage();
	EditCoursePage ec = new EditCoursePage();
	SummaryQuestionsPage sq = new SummaryQuestionsPage();
	StudentTestSectionPage st1 = new StudentTestSectionPage();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	TeacherTestSectionPage tts = new TeacherTestSectionPage();

	public String AssessmentName;
	public String Emailteacher;
	public String teacherotp;
	public String studentotp;
	public String CourseNamenew;
	public String CourseID1;
	public String Emailstudent1;
	public String Emailstudent2;

	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	/*
	 * To perform Sign Up functionality
	 */
	@Test(priority = 1)
	public void TCSPR1000301() {

		click(lg.LoginBtn_1);

		cm.login(cm.emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");
	}

	/*
	 * To create new course
	 */
	// @Test(priority = 2)
	public void TCSPR1000302() {

		CourseName = "Course Name" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID = (getText(cn.course_Id));

		// type-Course title
		type(cn.txbx_Coursetitle, CourseName);

		// click on Add students button
		click(cn.btn_AddStudents);

		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";

		// type email
		type(cn.tab_textbox, Emailstudent1 + ",");
		driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
		type(cn.tab_textbox, Emailstudent2 + ",");

		// verify email present on the text box
		Assert.assertEquals(cn.emailvalue(0), Emailstudent1);

		Assert.assertEquals(cn.emailvalue(1), Emailstudent2);

		// click on add to list button
		click(cn.tab_btn_Addtolist);

		waitThread(2000);
		waitFor(cr.emailval_1);

		// verify the Email on the New Students to be invited to this class box
		Assert.assertEquals(getText(cr.emailval_1), Emailstudent1);
		Assert.assertEquals(getText(ps.emailval_2), Emailstudent2);

		// click on create course button
		click(cn.btn_Createcourse);

		waitThread(1000);
		waitFor(cn.toaster);

		// verify toaster-Course created successfully
		Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");

		waitThread(3000);

		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), CourseName.trim());

	}
	/*
	 * To perform logout functionality on the teacher profile
	 */

	// @Test(priority = 3)
	public void TCSPR1000303() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}
	/*
	 * To check that invited course request visible on first student 's profile and
	 * accept course request-Read the student name
	 */

	// @Test(priority = 4)
	public void TCSPR1000304() {

		lg.login("student1@gmail.com", password);
		waitThread(5000);

		// verify heading label
		waitFor(rs.lbl_joincourse);
		Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");

		// verify course name visible
		Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not Present");

		// verify the the course name
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());

	}

	/*
	 * To Accept course and perform logout functionality on the student profile
	 */
	// @Test(priority = 5)
	public void TCSPR1000305() {

		// click on accept course button
		click(rs.btn_acceptcourse);

		// verify the confirmation popup visible
		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");

		// click on Yes button
		click(rs.popupbtn_Yes);

		// Toaster message
		waitFor(rs.toaster);
		Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");

		// verify the course name visibled on the enrolled section
		waitFor(rs.enrolledcoursename);

		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on first student 's profile and
	 * accept course request-Read the student name
	 */
	// @Test(priority = 6)
	public void TCSPR1000306() {

		lg.login("student2@gmail.com", password);

		waitThread(5000);

		// verify heading label
		waitFor(rs.lbl_joincourse);
		Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");

		// verify course name visible
		Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not Present");

		// verify the the course name
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());

	}

	/*
	 * To Accept course and perform logout functionality on the student profile
	 */

	// @Test(priority = 7)
	public void TCSPR1000307() {

		// click on accept course button
		click(rs.btn_acceptcourse);

		// verify the confirmation popup visible
		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");

		// click on Yes button
		click(rs.popupbtn_Yes);

		// Toaster message
		waitFor(rs.toaster);
		Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");

		// verify the course name visibled on the enrolled section
		waitFor(rs.enrolledcoursename);
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	public String CourseID = cm.CourseID1;
	public String CourseName = cm.CourseName1;

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */
	@Test(priority = 8)
	public void TCSPR1000308() {

		SoftAssert softAssert1 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");
		waitThread(5000);
		waitThread(2000);
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
	 * To fill details on theQuestion page
	 */
	@Test(priority = 9)
	public void TCSPR1000309() {

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
	public void TCSPR1000310() {

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

	/*
	 * To perform the save and next functionaity from peer review page and verify
	 * the schedule page details
	 */
	public String peerreviewopendate;
	public String peerreviewopentime;
	public String peerreviewduedate;
	public String peerreviewduetime;

	@Test(priority = 11)
	public void TCSPR1000311() {

		type(pr.PRreward_txtbox, "50");
		waitThread(4000);

		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");

		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.Sbassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseName.trim()));

		// Assert test open date is todays date
		Assert.assertEquals(getValue(tts.assessmentopendate_txtbx), sb.getdate());

		peerreviewopendate = getValue(sb.peerreviewopendate_txtbx);
		peerreviewopentime = getValue(sb.peerreviewopentime_txtbx);
		peerreviewduedate = getValue(sb.peerreviewduedate_txtbx);
		peerreviewduetime = getValue(sb.peerreviewduetime_txtbx);
	}

	/*
	 * To publish the assessment
	 */
	@Test(priority = 12)
	public void TCSPR1000312() {

		waitThread(3000);
		click(pr.savennext_button);

		waitThread(2000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");

		// Assert the Text "Questions Summary"
		Assert.assertEquals(getText(sq.Summary_quest), "Questions Summary");

		// Assert the total Questions count
		Assert.assertEquals(getText(sq.total_questcount), "1");

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

		waitThread(3000);
		// Assert the Current Assessment is selected
		Assert.assertEquals(getAttribute(ap.currentassess_tab, "aria-selected"), "true");

	}

	/*
	 * To check the newly created assessment card visible on the teacher profile
	 */
	@Test(priority = 13)
	public void TCSPR1000313() {

		click(tp.search_box);
		// search assessment
		type(tp.search_box, AssessmentName);
		waitThread(1000);

		// Assert the new assessment card visible
		Assert.assertTrue(isElementPresent(tp.newcard), " new assessment card not visible");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(tp.newasses_lbl), AssessmentName);
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseID));
	}

	public String timetext;

	/*
	 * To verify the peer review section on the assessment card check the labels
	 */
	@Test(priority = 14)
	public void TCSPR1000314() throws InterruptedException {
		TimeUnit.SECONDS.sleep(20);
		// Assert the Test status as Active
		Assert.assertEquals(getText(tp.teststs_lbl), "Active");

		// Assert the Peer Review status is pending
		Assert.assertEquals(getText(tp.peersts_lbl), "Pending");

		// Assert the timer visible on the card
		Assert.assertTrue(getText(tp.timer).contains("Test active for"), "Timer not visible on card");

	}

	/*
	 * To verify the peer review section on the assessment card check the date and
	 * time
	 */
	@Test(priority = 15)
	public void TCSPR1000315() {

		// Assert label Peer Reviews Completed
		Assert.assertEquals(getText(tp.peercompl_lbl), "Peer Reviews Completed");

		// Assert label Opens on:,Due on:
		Assert.assertTrue(getText(tp.openson_lbl).contains("Opens on"), "label not present");
		Assert.assertTrue(getText(tp.dueon_lbl).contains("Due on"), "label not present");

		// Assert the view details button is disabled
		Assert.assertFalse(isEnabled(tp.viewdet_btn), "Button enabled");
		Assert.assertEquals(getText(tp.peerrev_lbl), "Peer Review");

		// Assert the Peer review open date and time
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewopen), peerreviewopendate);
		Assert.assertEquals(cm.timereviewopen, peerreviewopentime);

		// Assert the Peer review due date and time with schedule page date and
		// time
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewdue), peerreviewduedate);
		Assert.assertEquals(cm.timereviewdue, peerreviewduetime);

	}

	/*
	 * To make peer review active
	 */
	public String assessmentduedate;
	public String testduetime;
	public String peerreviewopendate1;
	public String peerreviewopentime1;
	public String peerreviewduedate1;
	public String peerreviewduetime1;

	@Test(priority = 16)
	public void TCSPR1000316() {

		// Reschedule the test due time& peer review open time
		waitThread(2000);

		// click menu button
		click(rd.threedot_btn);

		waitThread(1000);
		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(2000);

		// assert popup
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");

		waitThread(2000);
		// Set the Assessment due date to current day
		Doubleclick(rd.assessmentduedate_txtbx);
		waitThread(2000);
		cm.ClickTodaysDate();

		assessmentduedate = getValue(st1.resche_testduedat_txtbx);
		testduetime = getValue(st1.resche_testendtime_txtbx);

		Doubleclick(rd.peerreviewopendate_txtbx);

		waitThread(2000);
		cm.ClickTodaysDate();

		waitThread(2000);
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
		waitThread(4000);

	}

	/*
	 * To verify the details on the peer review Active state
	 */
	@Test(priority = 17)
	public void TCSPR1000317() throws InterruptedException {

		TimeUnit.MINUTES.sleep(1);
		waitThread(2000);

		// Assert the status Active
		Assert.assertTrue(isEnabled(tp.viewdet_btn), "Button not enabled");
		Assert.assertEquals(getText(tp.peersts_lbl), "Active");

		// Assert the peer review open date and time on card with reschedule page
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewopen), peerreviewopendate1);
		Assert.assertEquals(cm.timereviewopen, peerreviewopentime1);
	}

	/*
	 * To make peer review window close
	 */
	@Test(priority = 18)
	public void TCSPR1000318() {
		// Reschedule the peer review due time
		waitThread(2000);

		// click menu button
		click(rd.threedot_btn);

		waitThread(1000);
		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(2000);

		// assert popup
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");

		waitThread(2000);

		// Set the Peer Review due date to current day
		waitThread(2000);
		Doubleclick(rd.peerreviewduedate_txtbx);

		waitThread(2000);
		cm.ClickTodaysDate();

		peerreviewduedate1 = getValue(st1.resche_peerdue_date_txtbx);
		peerreviewduetime1 = getValue(st1.resche_peerduetime_txtbx);

		waitThread(2000);
		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitFor(QP.toaster);
		// Assert toaster "Changes applied"
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		waitThread(4000);

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(3000);

	}

	/*
	 * To check the peer review window closed section
	 */
	@Test(priority = 19)
	public void TCSPR1000319() throws InterruptedException {

		TimeUnit.SECONDS.sleep(20);
		waitThread(2000);

		// Assert the peer review due date and time on card with reschedule page

		// Assert the status Window Closed
		Assert.assertEquals(getText(tp.peersts_lbl), "Window Closed");
		Assert.assertTrue(isEnabled(tp.viewdet_btn), "Button not enabled");

		// Assert the status Pending
		Assert.assertEquals(getText(tp.resultsts_lbl), "Pending");

		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewdue), peerreviewduedate1);
		Assert.assertEquals(cm.timereviewdue, peerreviewduetime1);

	}

	/*
	 * To perform Logout Functionality of Teacher
	 */
	@Test(priority = 20)
	public void TCSPR1000320() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}
}