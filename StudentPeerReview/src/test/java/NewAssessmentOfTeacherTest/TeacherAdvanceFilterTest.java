package NewAssessmentOfTeacherTest;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import CreateNewAssessment.Pages.AssessmentPublishPopupPage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.AssessmentStatusPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherAdvanceFilterPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class TeacherAdvanceFilterTest extends basePage {

	SignUpPage sp = new SignUpPage();
	LoginPage lg = new LoginPage();
	SignUpTest st = new SignUpTest();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	Databaseconnection dc = new Databaseconnection();
	CourseRosterPage cr = new CourseRosterPage();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	SchedulePageBasicsPage sb = new SchedulePageBasicsPage();
	SummaryBasicsPage sr = new SummaryBasicsPage();
	AssessmentPublishPopupPage ap = new AssessmentPublishPopupPage();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	TeacherPeerReviewSectionPage tp = new TeacherPeerReviewSectionPage();
	CommonMethods cm = new CommonMethods();
	TeacherAdvanceFilterPage ta = new TeacherAdvanceFilterPage();
	public String AssessmentName;
	public String NewAssessmentName;
	public String newAssessmentName;

	public String Emailteacher;
	public String teacherotp;
	public String studentotp;
	public String CourseNamenew;
	public String CourseID1;

	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

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
	// public void TCSPR1000602() throws SQLException {
	//
	// CourseName = "Course Name" + generateRandomNumber();
	//
	// // Click on create new course button
	// click(cn.btn_createnew);
	//
	// // To get the Course ID
	// CourseID = (getText(cn.course_Id));
	//
	// // type-Course title
	// type(cn.txbx_Coursetitle, CourseName);
	//
	// // click on Add students button
	// click(cn.btn_AddStudents);
	//
	// Emailstudent1 = "student1" + generateRandomNumber().trim() +
	// "@gmail.com";
	// Emailstudent2 = "student2" + generateRandomNumber().trim() +
	// "@gmail.com";
	//
	// // type email
	// type(cn.tab_textbox, Emailstudent1 + ",");
	// driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
	// type(cn.tab_textbox, Emailstudent2 + ",");
	//
	// // verify email present on the text box
	// Assert.assertEquals(cn.emailvalue(0), Emailstudent1);
	//
	// Assert.assertEquals(cn.emailvalue(1), Emailstudent2);
	//
	// // click on add to list button
	// click(cn.tab_btn_Addtolist);
	//
	// waitThread(2000);
	// waitFor(cr.emailval_1);
	//
	// // verify the Email on the New Students to be invited to this class box
	// Assert.assertEquals(getText(cr.emailval_1), Emailstudent1);
	// Assert.assertEquals(getText(ps.emailval_2), Emailstudent2);
	//
	// // click on create course button
	// click(cn.btn_Createcourse);
	//
	// waitThread(1000);
	// waitFor(cn.toaster);
	//
	// // verify toaster-Course created successfully
	// Assert.assertEquals(getText(cn.toaster).trim(), "Course created
	// successfully");
	//
	// waitThread(3000);
	//
	// // verify the course title
	// Assert.assertEquals(getText(cn.value_coursetitle).trim(),
	// CourseName.trim());
	//
	// }
	/*
	 * To perform logout functionality on the teacher profile
	 */

	// @Test(priority = 3)
	// public void TCSPR1000603() {
	//
	// // logout functionality
	// rs.Logout();
	//
	// // Heading Title-Login
	// Assert.assertEquals(getText(lg.PageTitle), "Login");
	//
	// }

	/*
	 * To check that invited course request visible on first student 's profile
	 * and accept course request-Read the student name
	 */
	// @Test(priority = 4)
	// public void TCSPR1000604() throws SQLException {
	//
	//
	//
	// lg.login("student1@gmail.com", password);
	// waitThread(5000);
	//
	// // verify heading label
	// waitFor(rs.lbl_joincourse);
	// Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");
	//
	// // verify course name visible
	// Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not
	// Present");
	//
	// // verify the the course name
	// Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());
	//
	// }
	// /*
	// * To Accept course and perform logout functionality on the student
	// profile
	// */
	//
	// @Test(priority = 5)
	// public void TCSPR1000605() {
	//
	// // click on accept course button
	// click(rs.btn_acceptcourse);
	//
	// // verify the confirmation popup visible
	// Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not
	// visible");
	//
	// // click on Yes button
	// click(rs.popupbtn_Yes);
	//
	// // Toaster message
	// waitFor(rs.toaster);
	// Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
	//
	// // verify the course name visibled on the enrolled section
	// waitFor(rs.enrolledcoursename);
	//
	// Assert.assertEquals(getText(rs.enrolledcoursename).trim(),
	// CourseName.trim());
	// waitThread(3000);
	//
	// // perform logout functionality
	// rs.Logout();
	//
	// // Heading Title-Login
	// Assert.assertEquals(getText(lg.PageTitle), "Login");
	// }
	//
	// /*
	// * To check that invited course request visible on first student 's
	// profile and
	// * accept course request-Read the student name
	// */
	// @Test(priority = 6)
	// public void TCSPR1000606() throws SQLException {
	//
	// lg.login("student2@gmail.com", password);
	//
	// waitThread(5000);
	//
	// // verify heading label
	// waitFor(rs.lbl_joincourse);
	// Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");
	//
	// // verify course name visible
	// Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not
	// Present");
	//
	// // verify the the course name
	// Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());
	//
	// }
	// /*
	// * To Accept course and perform logout functionality on the student
	// profile
	// */
	//
	// @Test(priority = 7)
	// public void TCSPR1000607() {
	//
	// // click on accept course button
	// click(rs.btn_acceptcourse);
	//
	// // verify the confirmation popup visible
	// Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not
	// visible");
	//
	// // click on Yes button
	// click(rs.popupbtn_Yes);
	//
	// // Toaster message
	// waitFor(rs.toaster);
	// Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
	//
	// // verify the course name visibled on the enrolled section
	// waitFor(rs.enrolledcoursename);
	// Assert.assertEquals(getText(rs.enrolledcoursename).trim(),
	// CourseName.trim());
	// waitThread(3000);
	//
	// // perform logout functionality
	// rs.Logout();
	//
	// // Heading Title-Login
	// Assert.assertEquals(getText(lg.PageTitle), "Login");
	// }

	public String CourseID = cm.CourseID1;
	public String CourseName = cm.CourseName1;

	/*
	 * To load the create new assessment page and fill details on the basic
	 * details page
	 */
	@Test(priority = 8)
	public void TCSPR1000608() {

		SoftAssert softAssert1 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

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
		AssessmentName = "GK" + generateRandomNumber().trim();

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
		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
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

	/*
	 * To perform the save and next functionaity from peer review page and
	 * verify the schedule page details
	 */
	@Test(priority = 11)
	public void TCSPR1000611() {

		// Type peer review reward score
		type(pr.PRreward_txtbox, "100");
		waitThread(1000);

		click(pr.savennext_button);
		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);

		waitThread(2000);
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");

		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.Sbassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseName.trim()));

		click(pr.savennext_button);
		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);

	}

	/*
	 * To verify the details on the Summary page & publish the Assessment
	 */
	@Test(priority = 12)
	public void TCSPR1000612() {

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
	 * To perform Assessment publish functionality & To check the published
	 * Assessment card
	 */
	@Test(priority = 13)
	public void TCSPR1000613() {

		// Click on Back to menu button
		click(ap.Backtomenu_btn);

		waitThread(1000);

		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(ap.publish_popup), "popup not visible");

		// Assert the Current Assessment is selected
		Assert.assertEquals(getAttribute(ap.currentassess_tab, "aria-selected"), "true");

		// search newly created assessment
		type(ta.search_box, AssessmentName);
		waitThread(2000);

		// Assert the newly published card visible on the current assessment
		// page
		Assert.assertTrue(isElementPresent(ta.newcard), " new assessment card not visible");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(ta.newasses_lbl), AssessmentName);
		Assert.assertTrue(getText(ta.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(ta.course_lbl).contains(CourseID));

	}

	/*
	 * To check the Upcoming tests filter functionality on the Assessment page
	 */
	@Test(priority = 14)
	public void TCSPR1000614() {

		// Click on Upcoming Tests check box
		click(ta.upcomingtestcheckbx);
		waitThread(1000);

		// Assert the check box is checked
		Assert.assertTrue(getAttribute(ta.upcomingtestcheckbx, "class").contains("p-highlight"));

		Assert.assertEquals(getText(ta.test_pending), "Pending");

		waitThread(1000);

		// search newly created assessment
		type(ta.search_box, AssessmentName);
		waitThread(2000);
		Assert.assertEquals(getText(ta.test_pending), "Pending");
		// Assert the newly published card visible on the current assessment
		// page
		Assert.assertTrue(isElementPresent(ta.newcard), " new assessment card not visible");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(ta.newasses_lbl), AssessmentName);
		Assert.assertTrue(getText(ta.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(ta.course_lbl).contains(CourseID));
		waitThread(2000);

		// Assert one card visible on the current assessment page
		Assert.assertTrue(isElementPresent(ta.newcard), " new assessment card not visible");

	}

	/*
	 * To check the Test Active filter functionality on the Assessment page
	 */
	@Test(priority = 15)
	public void TCSPR1000615() throws InterruptedException {

		// click draft tab
		click(pr.draft_tab);
		waitThread(3000);

		// current assessment tab
		click(ap.currentassess_tab);
		waitThread(1000);

		// wait for 3 minute
		TimeUnit.MINUTES.sleep(3);

		// Click on Test Active check box
		click(ta.testactivechkbx);
		waitThread(1000);

		// Assert the Test Active check box is checked
		Assert.assertTrue(getAttribute(ta.testactivechkbx, "class").contains("p-highlight"));

		waitThread(2000);
		// Assert the newly published card visible on the current assessment
		// page
		Assert.assertTrue(isElementPresent(ta.newcard), " new assessment card not visible");
		waitThread(2000);
		Assert.assertEquals(getText(ta.test_pending), "Active");

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(1000);
		Assert.assertEquals(getText(ta.test_pending), "Active");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(ta.newasses_lbl), AssessmentName);
		Assert.assertTrue(getText(ta.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(ta.course_lbl).contains(CourseID));

	}

	/*
	 * To perform Test window reshedule date functionality of the assesssment
	 * GK+random number
	 */
	@Test(priority = 16)
	public void TCSPR1000616() {

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(2000);

		// click menu button
		click(rd.threedot_btn);

		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(1000);

		// assert popup
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");

		waitThread(1000);

		//To reschedule test due date
		click(rd.assessmentduedate_txtbx);
		waitThread(3000);

		// To select Todays Date
		cm.ClickTodaysDate();
		
		// click apply chnages button
		click(rd.applychanges_btn);

		waitFor(QP.toaster);

		// Assert a toaster Changes applied
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		click(QP.toasterclosebtn);

		waitThread(1000);
		// Assert popup not visible
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");

	}

	/*
	 * To check the Upcoming Peer-Reviewsfilter functionality on the Assessment
	 * page
	 */
	@Test(priority = 17)
	public void TCSPR1000617() throws InterruptedException {

		// Click on Draft tab
		click(pr.draft_tab);

		waitThread(1000);

		// Click on current assessment tab
		click(ap.currentassess_tab);
		// wait for 2 minute
		TimeUnit.MINUTES.sleep(2);

		// Click on Upcoming Peer-Reviews check box
		click(ta.upcomimgreviewchkbx);
		waitThread(1000);

		// Assert the Upcoming Peer-Reviews check box is checked
		Assert.assertTrue(getAttribute(ta.upcomimgreviewchkbx, "class").contains("p-highlight"));

		waitThread(1000);
		// Assert the newly published card visible on the current assessment
		// page
		Assert.assertTrue(isElementPresent(ta.newcard), " new assessment card not visible");
		// Assert the Peer Review status is Active
		Assert.assertEquals(getText(tp.peersts_lbl), "Pending");

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(1000);
		// Assert the Peer Review status is Active
		Assert.assertEquals(getText(tp.peersts_lbl), "Pending");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(ta.newasses_lbl), AssessmentName);
		Assert.assertTrue(getText(ta.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(ta.course_lbl).contains(CourseID));

	}

	/*
	 * To perform Test window reshedule date functionality of the assesssment
	 * GK+random number
	 */
	@Test(priority = 18)
	public void TCSPR1000618() {

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(2000);

		// click menu button
		click(rd.threedot_btn);

		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(1000);

		// assert popup
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");

		waitThread(1000);

		click(rd.peerreviewopendate_txtbx);

		// To select Todays date
		cm.ClickTodaysDate();

		// click apply chnages button
		click(rd.applychanges_btn);
		waitFor(QP.toaster);

		// Assert a toaster Changes applied
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		click(QP.toasterclosebtn);

		waitThread(1000);
		// Assert popup not visible
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");

	}

	/*
	 * To check the Peer-review Active filter functionality on the Assessment
	 * page
	 */
	@Test(priority = 19)
	public void TCSPR1000619() throws InterruptedException {

		// Click on Draft tab
		click(pr.draft_tab);
		waitThread(3000);

		// Click on current assessment tab1
		click(ap.currentassess_tab);
		waitThread(1000);

		// wait for 2 minute
		TimeUnit.MINUTES.sleep(2);
		waitThread(5000);

		// Click on Peer-review Active check box
		click(ta.reviewactiveckbx);
		waitThread(1000);

		// Assert the Peer-review Active check box is checked
		Assert.assertTrue(getAttribute(ta.reviewactiveckbx, "class").contains("p-highlight"));
		waitThread(1000);

		// Assert one card visible on the current assessment page
		Assert.assertTrue(isElementPresent(ta.newcard), " new assessment card not visible");
		// Assert the Peer Review status is Active
		Assert.assertEquals(getText(tp.peersts_lbl), "Active");

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(1000);
		// Assert the Peer Review status is Active
		Assert.assertEquals(getText(tp.peersts_lbl), "Active");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(ta.newasses_lbl), AssessmentName);
		Assert.assertTrue(getText(ta.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(ta.course_lbl).contains(CourseID));

	}

	/*
	 * To perform Test window reshedule date functionality of the assesssment
	 * GK+random number
	 */
	@Test(priority = 20)
	public void TCSPR1000620() {

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(2000);

		// click menu button
		click(rd.threedot_btn);

		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(1000);

		// assert popup
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");

		waitThread(1000);

		click(rd.peerreviewduedate_txtbx);
		waitThread(3000);

		// Click on today's date
		cm.ClickTodaysDate();
		click(rd.applychanges_btn);
		waitFor(QP.toaster);

		// Assert a toaster Changes applied
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		click(QP.toasterclosebtn);

		waitThread(1000);
		// Assert popup not visible
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");

	}

	/*
	 * To check the Upcoming Results filter functionality on the Assessment page
	 */
	@Test(priority = 21)
	public void TCSPR1000621() throws InterruptedException {

		// Click on Draft tab
		click(pr.draft_tab);
		waitThread(1000);

		// Click on current assessment tab
		click(ap.currentassess_tab);

		// wait for 1 minute
		TimeUnit.MINUTES.sleep(3);

		// Click on Upcoming Result check box
		click(ta.upcomingresultchkbx);
		waitThread(1000);

		// Assert the Upcoming Result check box is checked
		Assert.assertTrue(getAttribute(ta.upcomingresultchkbx, "class").contains("p-highlight"));

		waitThread(1000);

		// Assert one card visible on the current assessment page
		Assert.assertTrue(isElementPresent(ta.newcard), " new assessment card not visible");

		// Assert the status Pending
		Assert.assertEquals(getText(tp.resultsts_lbl), "Pending");

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(1000);

		// Assert the status Pending
		Assert.assertEquals(getText(tp.resultsts_lbl), "Pending");

		// Assert the assessment name History+random number
		Assert.assertEquals(getText(ta.newasses_lbl), AssessmentName);
		Assert.assertTrue(getText(ta.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(ta.course_lbl).contains(CourseID));

	}

	/*
	 * To perform Test window reshedule date functionality of the assesssment
	 * GK+random number
	 */
	@Test(priority = 22)
	public void TCSPR1000622() {

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(2000);

		// click menu button
		click(rd.threedot_btn);

		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(1000);

		// assert popup
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");

		waitThread(1000);

		click(rd.resultpublishdate_txtbx);
		waitThread(3000);

		// To select Today's date
		cm.ClickTodaysDate();

		waitFor(QP.toaster);

		// Assert a toaster Changes applied
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		click(QP.toasterclosebtn);

		waitThread(1000);
		// Assert popup not visible
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");

	}

	/*
	 * To check the Result Published filter functionality on the Assessment page
	 */
	@Test(priority = 23)
	public void TCSPR1000623() throws InterruptedException {

		// Click on Draft tab
		click(pr.draft_tab);

		waitThread(1000);

		// Click on current assessment tab
		click(ap.currentassess_tab);
		// wait for 2 minute
		TimeUnit.MINUTES.sleep(2);

		// Click on Result Available check box
		click(ta.resultavailablechkbx);
		waitThread(1000);

		// Assert the Result Available check box is checked
		Assert.assertTrue(getAttribute(ta.resultavailablechkbx, "class").contains("p-highlight"));

		waitThread(1000);
		// Assert one card visible on the current assessment page
		Assert.assertTrue(isElementPresent(ta.newcard), " new assessment card not visible");

		// Assert the status Pending
		Assert.assertEquals(getText(tp.resultsts_lbl), "Published");

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(1000);

		// Assert the status Pending
		Assert.assertEquals(getText(tp.resultsts_lbl), "Published");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(ta.newasses_lbl), AssessmentName);
		Assert.assertTrue(getText(ta.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(ta.course_lbl).contains(CourseID));

	}

	/*
	 * To perform log out functionality
	 */
	@Test(priority = 24)
	public void TCSPR1000424() {

		// logout functionality
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}
}