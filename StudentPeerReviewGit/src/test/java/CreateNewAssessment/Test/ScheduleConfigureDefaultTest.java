package CreateNewAssessment.Test;

import java.sql.SQLException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.ScheduleConfigureDefaultPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class ScheduleConfigureDefaultTest extends basePage {

	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	EncryptedText et = new EncryptedText();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	SchedulePageBasicsPage sb = new SchedulePageBasicsPage();
	ScheduleConfigureDefaultPage sd = new ScheduleConfigureDefaultPage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	CommonMethods cm = new CommonMethods();
	CourseRosterPage cr = new CourseRosterPage();
	EditCoursePage ec = new EditCoursePage();

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
	public String todaydate;
	public String Studentfirstname;
	public String Studentlastname;
	public String Studentname;
	public String Studentfirstname2;
	public String Studentlastname2;
	public String Student1Email;
	public String Student2Email;
	public String Studentname2;

	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	/*
	 * To perform Sign Up functionality
	 */
	@Test(priority = 0)
	public void TCSPR0901101() {

		// To click on I am A teacher button
		click(sp.btn_1);

		// To fill the details on the sign up page
		Emailteacher = st.TCSPR020005();

	}

	@Test(priority = 1)
	public void OtpFetch() throws SQLException {

		// To catch OTP from sending Resource
		st.TCSPR020006();

	}

	/*
	 * To create new course
	 */
	@Test(priority = 2)
	public void TCSPR0901102() throws SQLException {

		CourseName = "Course Name" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID = (getText(cn.course_Id));
		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";

		// Invite students to course
		cm.Invitestudentstocourse(CourseName, Emailstudent1, Emailstudent2);

	}
	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 3)
	public void TCSPR0901103() {

		// logout functionality
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on first student 's profile
	 * and accept course request-Read the student name
	 */
	@Test(priority = 4)
	public void TCSPR0901104() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent1, CourseID);

		String encText = et.EncryptCode(studentinviteid);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname = "Ashley";
		Studentlastname = "Albert";
		Studentname = Studentfirstname + " " + Studentlastname;
		waitThread(3000);

		// click first name
		click(sp.txtbxFirstN);

		// type first name
		type(sp.txtbxFirstN, Studentfirstname);

		// click last name
		click(sp.txtbxLastN);

		// type last name
		type(sp.txtbxLastN, Studentlastname);

		// click password
		click(sp.txtbxPass);

		// type password
		type(sp.txtbxPass, password);

		// click password
		click(sp.txtbxPassconf);

		// type password
		type(sp.txtbxPassconf, password);

		// click on privacy policy check box
		click(sp.chkbx_1);

		// click signup button
		click(sp.btn_signup);

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

	@Test(priority = 5)
	public void TCSPR0901105() {

		// click on accept course button
		click(rs.btn_acceptcourse);

		// verify the confirmation pop up visible
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
	 * To check that invited course request visible on first student 's profile
	 * and accept course request-Read the student name
	 */
	@Test(priority = 6)
	public void TCSPR0901106() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent2, CourseID);

		String encText = et.EncryptCode(studentinviteid);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname2 = "Ben";
		Studentlastname2 = "Max";
		Studentname2 = Studentfirstname2 + " " + Studentlastname2;
		waitThread(3000);
		// click first name
		click(sp.txtbxFirstN);

		// type first name
		type(sp.txtbxFirstN, Studentfirstname2);

		// click last name
		click(sp.txtbxLastN);

		// type last name
		type(sp.txtbxLastN, Studentlastname2);

		// click password
		click(sp.txtbxPass);

		// type password
		type(sp.txtbxPass, password);

		// click password
		click(sp.txtbxPassconf);

		// type password
		type(sp.txtbxPassconf, password);

		// click on privacy policy check box
		click(sp.chkbx_1);

		// click signup button
		click(sp.btn_signup);

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

	@Test(priority = 7)
	public void TCSPR0901107() {

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
	 * To load the create new assessment page and fill details on the basic
	 * details page
	 */
	@Test(priority = 8)
	public void TCSPR0901108() {

		SoftAssert softAssert1 = new SoftAssert();
		rs.login_Teacher(Emailteacher, password);

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
		AssessmentName = "Assessment" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentName);

		waitThread(2000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(2000);

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
	public void TCSPR0901109() {

		waitThread(1000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question1");

		driver.switchTo().defaultContent();

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
	public void TCSPR0901110() {

		waitThread(2000);

		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");

		// Assert the first student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Studentname);

		// Assert the second student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Studentname2);

	}

	/*
	 * To perform the save and next functionality from peer review page and
	 * verify the schedule page details
	 */
	@Test(priority = 11)
	public void TCSPR0901111() {

		// Type Reward Percentage
		type(pr.PRreward_txtbox, "50");
		waitThread(3000);
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

		// Assert the Discard,Save&Exit,Save&Next buttons and button labels:
		Assert.assertTrue(isElementPresent(pr.discard_button), "Button not present");
		Assert.assertTrue(isElementPresent(pr.savenexit_button), "Button not present");

		Assert.assertTrue(isElementPresent(pr.savennext_button), "Button not present");
		Assert.assertTrue(isElementPresent(sb.clearall_btn), "Button not present");

		Assert.assertFalse(isEnabled(sb.apply_btn), "Button not disabled");
		Assert.assertTrue(isEnabled(sb.clearall_btn), "Button Disabled");

		Assert.assertTrue(isEnabled(sb.configuredef_btn), "Button Disabled");

	}

	/*
	 * To check the Configure Default popup buttons label
	 */
	@Test(priority = 12)
	public void TCSPR0901112() {

		// Click on Configure default button
		click(sb.configuredef_btn);

		waitThread(1000);
		Assert.assertTrue(isElementPresent(sd.congigdef_popup), "popup not present");

		// Assert labels
		Assert.assertEquals(getText(sd.Testwindow_lbl).trim(), "Test Window");
		Assert.assertEquals(getText(sd.peerreview_lbl).trim(), "Peer Review Window");

		ScrollTo_Location(sd.peerreview_lbl);
		waitThread(1000);

		// Assert labels
		Assert.assertEquals(getText(sd.Resultpublish_lbl).trim(), "Result Publishing");
		Assert.assertFalse(isElementPresent(sd.lastdaterecons_lbl),
				"Last date for Reconsideration Request Label visible");

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		// Assert button
		Assert.assertTrue(isElementPresent(sd.reset_btn), "Button not present");
		Assert.assertTrue(isElementPresent(sd.discard_btn), "Button not present");
		Assert.assertTrue(isElementPresent(sd.save_btn), "Button not present");
		Assert.assertTrue(isElementPresent(sd.close_btn), "Button not present");

		// click close
		click(sd.close_btn);

		waitThread(1000);

		// Assert popup present
		Assert.assertFalse(isElementPresent(sd.congigdef_popup), "popup  present");

	}

	/*
	 * To check Result publishing method radio buttons
	 */
	@Test(priority = 13)
	public void TCSPR0901113() {

		SoftAssert softassert1 = new SoftAssert();

		// Click on Configure default button
		click(sb.configuredef_btn);
		waitThread(1000);

		ScrollTo_Location(sd.peerreview_lbl);
		waitThread(1000);

		// click Result publish radio button
		click(sd.resultpublish_radio1);
		waitThread(1000);

		// Assert radio button enabled
		Assert.assertTrue(isElementPresent(sd.resultpublish_radio), " Radio Button not selected");
		// Assert the Last date for Reconsideration Request label not visible
		Assert.assertFalse(isElementPresent(sd.lastdate_lbl), "label visible");

		// Assert labels
		Assert.assertEquals(getText(sd.resultpublishdate_lbl), "Result Publishing date and time:");

		// check radio button teacher will manualy publish result
		click(sd.teacherwill_radio);
		waitThread(1000);
		// Assert the result label not visible
		Assert.assertFalse(isElementPresent(sd.resultpublishdate_lbl), "Result label  visible");
		// Assert labels
		softassert1.assertEquals(getText(sd.lastdate_lbl), "Last date for raising reconsideration request by students:",
				"Label is not correct");
		softassert1.assertEquals(getText(sd.reconsider_lbl_1), "Last date for Reconsideration Request",
				"Label is not correct");
		softassert1.assertEquals(getText(sd.reconsider_lbl_2), "Day from Result Publishing Date at",
				"Label is not correct");

		// Assert the days and time drop downs
		Assert.assertTrue(isElementPresent(sd.reconsiderdays_btn), "Reconsideration Days dropdown not present");
		Assert.assertTrue(isElementPresent(sd.reconsidertime_btn), "Reconsideration Time dropdown not present");
		// click Result publish radio button
		click(sd.resultpublish_radio1);
		waitThread(1000);

		// Assert radio button enabled
		Assert.assertTrue(isElementPresent(sd.resultpublish_radio), " Radio Button not selected");
	}

	/*
	 * To verify the days and time on the textboxes
	 */
	@Test(priority = 14)
	public void TCSPR0901114() {

		SoftAssert softassert2 = new SoftAssert();
		todaydate = sd.getDate();
		ScrollTo_Location(sd.Testwindow_lbl);
		waitThread(1000);
		// Test Open
		softassert2.assertEquals(getValue(sd.teststart_drp), "0", "Days count not correct");
		softassert2.assertEquals(getValue(sd.assessmentopentime_txtbx), "12:00 AM", "Time not correct");
		softassert2.assertEquals(getText(sd.startdatetime_lbl),
				"Assessment Open date and time will be: " + todaydate + " - " + sd.dayname() + " at 12:00 AM",
				"The label is not correct");

		// Test Due
		softassert2.assertEquals(getValue(sd.testdue_drp), "0", "Assertion Failed");
		softassert2.assertEquals(getValue(sd.assessmentduetime_txtbx), "12:01 AM", "Assertion Failed");
		softassert2.assertEquals(getText(sd.duedatetime_lbl),
				"Assessment Due date and time will be: " + todaydate + " - " + sd.dayname() + " at 12:01 AM",
				"Assertion Failed");
		// Peer Open
		softassert2.assertEquals(getValue(sd.peerstart_drp), "0", "Assertion Failed");
		softassert2.assertEquals(getValue(sd.peeropentime_txtbx), "12:02 AM", "Assertion Failed");
		softassert2.assertEquals(getText(sd.peerstartdatetime_lbl),
				"Peer Review Open date and time will be: " + todaydate + " - " + sd.dayname() + " at 12:02 AM",
				"Assertion Failed");

		// Peer Due
		softassert2.assertEquals(getValue(sd.peerdue_drp), "0", "Assertion Failed");
		softassert2.assertEquals(getValue(sd.peerduetime_txtbx), "12:03 AM", "Assertion Failed");
		softassert2.assertEquals(getText(sd.peerduedatetime_lbl),
				"Peer Review Due date and time will be: " + todaydate + " - " + sd.dayname() + " at 12:03 AM",
				"Assertion Failed");

		ScrollTo_Location(sd.resultpub_drp);
		waitThread(1000);
		// Result
		softassert2.assertEquals(getValue(sd.resultpub_drp), "0", "Assertion Failed");
		softassert2.assertEquals(getValue(sd.resultpub_txtbox), "12:04 AM", "Assertion Failed");
		softassert2.assertEquals(getText(sd.resultpubdatetime_lbl),
				"Result publishing date and time will be: " + todaydate + " - " + sd.dayname() + " at 12:04 AM",
				"Assertion Failed");
		softassert2.assertAll();
	}

	/*
	 * To check the reset & discard button functionality & To Check the discard
	 * button functions
	 */
	@Test(priority = 15)
	public void TCSPR0901115() {
		ScrollTo_Location(sd.Testwindow_lbl);
		waitThread(1000);
		// Assert reset button
		Assert.assertTrue(isElementPresent(sd.reset_btn), "Button not present");

		// Click on Day dropdown of Assessment open time
		click(sd.teststart_drparrow);
		waitThread(1000);

		// select value 1
		click(sd.teststart_drpval1);
		waitThread(1000);
		Assert.assertEquals(getValue(sd.teststart_drp), "1");

		// Change the time to 1:00PM
		click(sd.assessmentopentime_txtbx);
		waitThread(1000);
		click(sd.teststartascarrow_btn);
		// click on Discard button
		click(sd.discard_btn);

		waitFor(QP.toaster);

		// Assert toaster"Changes Discarded"
		Assert.assertEquals(getText(QP.toaster), "Changes Discarded");

		click(QP.toasterclosebtn);
		waitThread(1000);

		waitThread(1000);

		click(sb.configuredef_btn);

		waitThread(1000);

		Assert.assertTrue(isElementPresent(sd.congigdef_popup), "popup not present");

		// Assert that test days and start time
		Assert.assertEquals(getValue(sd.teststart_drp), "0");
		Assert.assertEquals(getValue(sd.assessmentopentime_txtbx), "12:00 AM");

	}

	/*
	 * To save the configure page and apply default using this default dates To
	 * check the clear all functionality in schedule page & and also to check
	 * the past date toaster
	 */
	@Test(priority = 16)
	public void TCSPR0901116() {

		// To save the details on the configure default page
		click(sd.save_btn);
		waitThread(3000);

		Assert.assertFalse(isElementPresent(sd.congigdef_popup), "popup not present");
		ScrollTo_xy_position(300, 0);
		click(sb.clearall_btn);
		waitThread(1000);
		click(sb.confyes_btn);

		waitFor(pr.assessmentde_toaster);

		// Assert toaster
		Assert.assertEquals(getText(pr.assessmentde_toaster), "Cleared successfully");

		click(sb.apply_btn);
		waitThread(3000);

		// Assert the Assessment Open date displayed is current day and time is
		// 12:00AM
		Assert.assertEquals(getValue(sb.assessmentopendate_txtbx), sb.getdate());
		Assert.assertEquals(getValue(sb.assessmentopentime_txtbx), "12:00 AM");

		click(pr.savennext_button);

		waitFor(QP.toaster);

		// Assert toaster"Peer Review Open date and time is mandatory"
		Assert.assertEquals(getText(QP.toaster), "Date and time should not be past date and time");

		click(QP.toasterclosebtn);

		click(sb.configuredef_btn);

		waitThread(1000);

		// Assert popup
		Assert.assertTrue(isElementPresent(sd.congigdef_popup), "popup not present");

	}

	/*
	 * To check the default Test window date & time in Configure default dates
	 * popup after reset
	 */
	@Test(priority = 17)
	public void TCSPR0901117() {

		SoftAssert softassert3 = new SoftAssert();
		todaydate = sd.getDate();
		// click reset Button
		click(sd.reset_btn);
		waitThread(1000);

		// Test Open
		softassert3.assertEquals(getValue(sd.teststart_drp), "0", "Assertion Failed");
		softassert3.assertEquals(getValue(sd.assessmentopentime_txtbx), "12:00 AM", "Assertion Failed");
		softassert3.assertEquals(getText(sd.startdatetime_lbl),
				"Assessment Open date and time will be: " + todaydate + " - " + sd.dayname() + " at 12:00 AM",
				"Assertion Failed");

		// Test Due
		softassert3.assertEquals(getValue(sd.testdue_drp), "0", "Assertion Failed");
		softassert3.assertEquals(getValue(sd.assessmentduetime_txtbx), "12:30 AM", "Assertion Failed");
		softassert3.assertEquals(getText(sd.duedatetime_lbl),
				"Assessment Due date and time will be: " + todaydate + " - " + sd.dayname() + " at 12:30 AM",
				"Assertion Failed");

		softassert3.assertAll();
	}

	/*
	 * To check the default Peer Review Window date & time in Configure default
	 * dates pop up
	 */
	@Test(priority = 18)
	public void TCSPR0901118() {
		SoftAssert softassert4 = new SoftAssert();
		// Peer Open
		softassert4.assertEquals(getValue(sd.peerstart_drp), "0", "Assertion Failed");
		softassert4.assertEquals(getValue(sd.peeropentime_txtbx), "01:00 AM", "Assertion Failed");
		softassert4.assertEquals(getText(sd.peerstartdatetime_lbl),
				"Peer Review Open date and time will be: " + todaydate + " - " + sd.dayname() + " at 1:00 AM",
				"Assertion Failed");

		// Peer Due
		softassert4.assertEquals(getValue(sd.peerdue_drp), "0", "Assertion Failed");
		softassert4.assertEquals(getValue(sd.peerduetime_txtbx), "01:30 AM", "Assertion Failed");
		softassert4.assertEquals(getText(sd.peerduedatetime_lbl),
				"Peer Review Due date and time will be: " + todaydate + " - " + sd.dayname() + " at 1:30 AM",
				"Assertion Failed");
		softassert4.assertAll();

	}

	/*
	 * To check the default Result Publishing date and time in Configure default
	 * dates popup
	 */
	@Test(priority = 19)
	public void TCSPR0901119() {

		SoftAssert softassert5 = new SoftAssert();
		ScrollTo_Location(sd.resultpub_drp);
		waitThread(1000);
		// Result
		softassert5.assertEquals(getValue(sd.resultpub_drp), "0", "Assertion Failed");
		softassert5.assertEquals(getValue(sd.resultpub_txtbox), "02:00 AM", "Assertion Failed");
		softassert5.assertEquals(getText(sd.resultpubdatetime_lbl),
				"Result publishing date and time will be: " + todaydate + " - " + sd.dayname() + " at 2:00 AM",
				"Assertion Failed");
		softassert5.assertAll();
	}

	/*
	 * To check whether the validation toaster display when assessment due date
	 * is passed date than open date
	 */
	@Test(priority = 20)
	public void TCSPR0901120() {
		SoftAssert softassert6 = new SoftAssert();

		// Change the time to 1:00PM
		click(sd.assessmentopentime_txtbx);
		waitThread(1000);
		click(sd.teststartascarrow_btn);
		waitThread(1000);
		// Test open
		softassert6.assertEquals(getValue(sd.assessmentopentime_txtbx), "01:00 AM", "Assertion Failed");
		// Test close
		softassert6.assertEquals(getValue(sd.assessmentduetime_txtbx), "12:30 AM", "Assertion Failed");
		waitThread(1000);
		click(sd.save_btn);
		waitFor(QP.toaster);

		// Assert toaster"Assessment Due date and time should not be prior to
		// Assessment
		// Open date and time"
		Assert.assertTrue(getText(QP.toaster)
				.contains("Assessment Due date and time should not be prior to Assessment Open date and time"));

		click(QP.toasterclosebtn);
		waitThread(1000);
		softassert6.assertAll();
	}

	/*
	 * To check whether the validation toaster display when assessment due date
	 * is passed date than peer open date
	 */
	@Test(priority = 21)
	public void TCSPR0901121() {

		SoftAssert softassert7 = new SoftAssert();

		click(sd.assessmentduetime_txtbx);
		waitThread(1000);

		click(sd.testdueascarrow_btn);
		waitThread(2000);
		// Test close
		softassert7.assertEquals(getValue(sd.assessmentduetime_txtbx), "01:30 AM", "Assertion Failed");
		click(sd.save_btn);
		waitFor(sd.toaster_1);

		// Assert toaster"Peer Review Open date and time should not be prior to
		// Assessment Due date and time"
		Assert.assertTrue(getText(sd.toaster_1)
				.contains("Peer Review Open date and time should not be prior to Assessment Due date and time"));
		click(QP.toasterclosebtn);
		softassert7.assertAll();
	}

	/*
	 * To check whether the validation toaster display when peer due date is
	 * passed date than peer open date
	 */
	@Test(priority = 22)
	public void TCSPR0901122_Toaster_1() {

		// click reset button
		click(sd.reset_btn);
		waitThread(1000);

		// change peerreview open time
		click(sd.peeropentime_txtbx);
		waitThread(1000);

		click(sd.peeropenasc_arrow);
		waitThread(2000);

		Assert.assertEquals(getValue(sd.peeropentime_txtbx), "02:00 AM");

		click(sd.peerduetime_txtbx);
		waitThread(2000);
		Assert.assertEquals(getValue(sd.peerduetime_txtbx), "01:30 AM");

		click(sd.save_btn);
		waitFor(QP.toaster);

		// Assert toaster"Peer Review Due date and time should not be prior to
		// Peer
		// Review Open date and time"
		Assert.assertEquals(getText(QP.toaster),
				"Peer Review Due date and time should not be prior to Peer Review Open date and time");

		click(QP.toasterclosebtn);

	}

	/*
	 * To check whether the validation toaster display when result publish date
	 * is passed date than peer due date
	 */
	@Test(priority = 22)
	public void TCSPR0901122_Toaster_2() {
		click(sd.reset_btn);
		waitThread(1000);
		click(sd.peerduetime_txtbx);
		click(sd.peerdueasc_arrow);
		waitThread(2000);
		Assert.assertEquals(getValue(sd.peerduetime_txtbx), "02:30 AM");
		ScrollTo_Location(sd.resultpub_drp);
		waitThread(2000);
		click(sd.save_btn);
		waitFor(QP.toaster);

		// Assert toaster"Result publishing time should not be prior to Peer
		// Review Due
		// time"
		Assert.assertEquals(getText(QP.toaster), "Result publishing time should not be prior to Peer Review Due time");

		click(QP.toasterclosebtn);
	}

	/*
	 * To check the day dropdown value counts of each fields
	 */
	@Test(priority = 23)
	public void TCSPR0901123() {

		ScrollTo_Location(sd.Testwindow_lbl);
		waitThread(1000);
		// Assert dropdown value counts of each fields is 30
		click(sd.teststart_drparrow);
		waitThread(1000);
		Assert.assertEquals(TotalElementsCount(sd.teststartdrp_val), 31);

		click(sd.testdue_drparrow);
		waitThread(1000);
		Assert.assertEquals(TotalElementsCount(sd.testduedrp_val), 31);

		click(sd.peerdrp_arrow);
		waitThread(1000);
		Assert.assertEquals(TotalElementsCount(sd.peeropendrp_val), 31);

		click(sd.peerduedrp_arrow);
		waitThread(1000);
		Assert.assertEquals(TotalElementsCount(sd.peerduedrp_val), 31);

		ScrollTo_Location(sd.peerreview_lbl);
		waitThread(1000);

		click(sd.resultpubdrp_arrow);
		waitThread(1000);
		Assert.assertEquals(TotalElementsCount(sd.resultpubdrp_val), 31);

	}

	public String Config_assessmentopentime;
	public String Config_assessmentduetime;
	public String Config_peerreviewopentime;
	public String Config_peerreviewduetime;
	public String Config_resulttime;

	/*
	 * To reset the dates on the configure default window and modify the dates
	 */
	@Test(priority = 24)
	public void TCSPR0901124() throws ParseException {

		click(sd.reset_btn);
		waitThread(1000);
		ScrollTo_Location(sd.Testwindow_lbl);
		waitThread(1000);

		// Click on Day dropdown of Assessment open time
		click(sd.teststart_drparrow);
		waitThread(1000);

		// select value 1
		click(sd.teststart_drpval1);
		waitThread(1000);
		Assert.assertEquals(getValue(sd.teststart_drp), "1");

		Config_assessmentopentime = getValue(sd.assessmentopentime_txtbx);
		Config_assessmentduetime = getValue(sd.assessmentduetime_txtbx);
		Config_peerreviewopentime = getValue(sd.peeropentime_txtbx);
		Config_peerreviewduetime = getValue(sd.peerduetime_txtbx);

		ScrollTo_Location(sd.resultpub_drp);
		waitThread(1000);

		Config_resulttime = getValue(sd.resultpub_txtbox);
		ScrollTo_Location(sd.Testwindow_lbl);
		waitThread(1000);
		// Assessment open date and time Label
		Assert.assertEquals(getText(sd.startdatetime_lbl), "Assessment Open date and time will be: " + sd.getnextday()
				+ " - " + sd.Nextdayname() + " at " + sd.removeLeadingZeroes(Config_assessmentopentime));
		// Assessment due date and time Label
		Assert.assertEquals(getText(sd.duedatetime_lbl), "Assessment Due date and time will be: " + sd.getnextday()
				+ " - " + sd.Nextdayname() + " at " + sd.removeLeadingZeroes(Config_assessmentduetime));
		// Peer due date and time Label
		Assert.assertEquals(getText(sd.peerstartdatetime_lbl),
				"Peer Review Open date and time will be: " + sd.getnextday() + " - " + sd.Nextdayname() + " at "
						+ sd.removeLeadingZeroes(Config_peerreviewopentime));
		// Peer due date and time Label
		Assert.assertEquals(getText(sd.peerduedatetime_lbl), "Peer Review Due date and time will be: " + sd.getnextday()
				+ " - " + sd.Nextdayname() + " at " + sd.removeLeadingZeroes(Config_peerreviewduetime));

		ScrollTo_Location(sd.resultpub_drp);
		waitThread(1000);

		// Result date and time Label
		Assert.assertEquals(getText(sd.resultpubdatetime_lbl), "Result publishing date and time will be: "
				+ sd.getnextday() + " - " + sd.Nextdayname() + " at " + sd.removeLeadingZeroes(Config_resulttime));

	}

	/*
	 * To Apply the configure default dates on the schedule page
	 */
	@Test(priority = 25)
	public void TCSPR0901125() {

		// To save the details on the configure default page
		click(sd.save_btn);
		waitFor(QP.toaster);

		// Assert toaster"Peer Review Open date and time is mandatory"
		Assert.assertEquals(getText(QP.toaster), "Default Dates Saved");

		click(QP.toasterclosebtn);
		waitThread(2000);
		Assert.assertEquals(getText(sb.selectstu_lbl), "Select Schedules for");

		// click apply button
		click(sb.apply_btn);

		waitFor(QP.toaster);
		// Assert toaster"Default Dates Applied"
		Assert.assertEquals(getText(QP.toaster), "Default Dates Applied");
		click(QP.toasterclosebtn);
		waitThread(2000);
		// Assert Configure date is applied correctly on schedule page
		Assert.assertEquals(getValue(sb.assessmentopendate_txtbx), sd.getNextday());

		Assert.assertEquals(getValue(sb.assessmentduedate_txtbx), sd.getNextday());
		Assert.assertEquals(getValue(sb.peerreviewopendate_txtbx), sd.getNextday());
		Assert.assertEquals(getValue(sb.peerreviewduedate_txtbx), sd.getNextday());
		Assert.assertEquals(getValue(sb.assessmentopentime_txtbx), Config_assessmentopentime);

		Assert.assertEquals(getValue(sb.assessmentduetime_txtbx), Config_assessmentduetime);
		Assert.assertEquals(getValue(sb.peerreviewopentime_txtbx1), Config_peerreviewopentime);
		Assert.assertEquals(getValue(sb.peerreviewduetime_txtbx), Config_peerreviewduetime);

		Scroll_DowntoEnd();
		Assert.assertEquals(getValue(sb.resultpublishtime_txtbx), Config_resulttime);

	}

	public String reconisderdays;
	public String reconsidertime;

	/*
	 * Click on Configure default button and save configure default with Manual
	 * result publish and reconsideration request
	 */
	@Test(priority = 26)
	public void TCSPR0901126() throws ParseException {

		ScrollTo_xy_position(300, 0);
		click(sb.configuredef_btn);
		waitThread(1000);

		// Assert pop visible
		Assert.assertTrue(isElementPresent(sd.congigdef_popup), "popup not present");

		waitThread(1000);
		// Assessment open date and time Label
		Assert.assertEquals(getText(sd.startdatetime_lbl), "Assessment Open date and time will be: " + sd.getnextday()
				+ " - " + sd.Nextdayname() + " at " + sd.removeLeadingZeroes(Config_assessmentopentime));
		// Assessment due date and time Label
		Assert.assertEquals(getText(sd.duedatetime_lbl), "Assessment Due date and time will be: " + sd.getnextday()
				+ " - " + sd.Nextdayname() + " at " + sd.removeLeadingZeroes(Config_assessmentduetime));
		// Peer due date and time Label
		Assert.assertEquals(getText(sd.peerstartdatetime_lbl),
				"Peer Review Open date and time will be: " + sd.getnextday() + " - " + sd.Nextdayname() + " at "
						+ sd.removeLeadingZeroes(Config_peerreviewopentime));
		// Peer due date and time Label
		Assert.assertEquals(getText(sd.peerduedatetime_lbl), "Peer Review Due date and time will be: " + sd.getnextday()
				+ " - " + sd.Nextdayname() + " at " + sd.removeLeadingZeroes(Config_peerreviewduetime));

		ScrollTo_Location(sd.resultpub_drp);
		waitThread(1000);

		// Result date and time Label
		Assert.assertEquals(getText(sd.resultpubdatetime_lbl), "Result publishing date and time will be: "
				+ sd.getnextday() + " - " + sd.Nextdayname() + " at " + sd.removeLeadingZeroes(Config_resulttime));

		Scroll_DowntoEnd();
		// check radio button teacher will manualy publish result
		click(sd.teacherwill_radio);
		waitThread(4000);

		reconisderdays = getValue(sd.reconisderdays);
		reconsidertime = getValue(sd.reconsidertime);

		click(sd.save_btn);
		waitFor(QP.toaster);

		// Assert toaster"Peer Review Open date and time is mandatory"
		Assert.assertEquals(getText(QP.toaster), "Default Dates Saved");

		click(QP.toasterclosebtn);

	}

	/*
	 * To Apply default functionality with Manually result publish
	 */
	@Test(priority = 27)
	public void TCSPR0901127() {
		waitThread(4000);
		ScrollTo_xy_position(300, 0);
		// click apply button
		click(sb.apply_btn);

		waitFor(QP.toaster);
		// Assert toaster"Default Dates Applied"
		Assert.assertEquals(getText(QP.toaster), "Default Dates Applied");
		click(QP.toasterclosebtn);
		waitThread(4000);
		ScrollTo_Location(sb.teachwill_radio_select);

		// Assert the Teacher will manually publish the result radio button is
		// selected
		Assert.assertTrue(isEnabled(sb.teachwill_radio_select),
				"Teacher will manually publish the result radio button not selected");

		// Assert the Result publishing date radio button is unselected
		Assert.assertFalse(isSelected(sb.resultpublish_radio), "radio button is selected");

		// Assert the Allow students to raise a Reconsideration Request Label
		// visible
		Assert.assertEquals(getText(sb.allowstudent_lbl), "Allow students to raise a Reconsideration Request");

		// Assert the Allow students to raise a Reconsideration Request check
		// box is
		// unchecked
		Assert.assertFalse(isSelected(sb.allowstu_checkbx2),
				"Allow students to raise a Reconsideration Request check box is checked");

		// Assert the time on the box is same as configure page
		// Assert.assertEquals(getValue(sb.lasttime_select_bx), reconsidertime);
		// Assert the days visible on the page
		Assert.assertEquals(getValue(sb.day_drop_txtbx), reconisderdays);

		// Assert Configure date is applied correctly on schedule page
		Assert.assertEquals(getValue(sb.assessmentopendate_txtbx), sd.getNextday());
		ScrollTo_xy_position(0, 0);
		waitThread(1000);
		Assert.assertEquals(getValue(sb.assessmentduedate_txtbx), sd.getNextday());
		Assert.assertEquals(getValue(sb.peerreviewopendate_txtbx), sd.getNextday());
		Assert.assertEquals(getValue(sb.peerreviewduedate_txtbx), sd.getNextday());
		Assert.assertEquals(getValue(sb.assessmentopentime_txtbx), Config_assessmentopentime);

		Assert.assertEquals(getValue(sb.assessmentduetime_txtbx), Config_assessmentduetime);
		Assert.assertEquals(getValue(sb.peerreviewopentime_txtbx1), Config_peerreviewopentime);
		Assert.assertEquals(getValue(sb.peerreviewduetime_txtbx), Config_peerreviewduetime);

	}

	/*
	 * To perform Save & Next function from Schedule page
	 */
	@Test(priority = 28)
	public void TCSPR0901128() {

		// Click on save and next button
		click(pr.savennext_button);
		waitFor(QP.toaster);

		// Assert toaster"Peer Review Open date and time is mandatory"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);
		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");
	}


	/*
	 * To perform the create new course functionality on the landing page.
	 * 
	 * To invite students to course
	 */
	@Test(priority = 29)
	public void TCSPR0901129() {

		// click on course tab
		click(ba.CourseTab);
		waitThread(2000);
		// To click on split button
		click(ec.splitbutton);

		// click on details button
		click(ec.btn_coursedetails);
		waitThread(2000);
		// click on Active button
		click(ec.active_btn);
		waitThread(2000);

		waitFor(ec.btnyes);
		// click on Yes button
		click(ec.btnyes);
		waitThread(3000);

		// click(ps.alertdiscard_btn);
		// waitThread(2000);
		CourseNamenew = "Course Namenew" + generateRandomNumber();
		// click on course tab
		click(ba.CourseTab);
		waitThread(2000);
		waitFor(cn.btn_createnew);
		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID1 = (getText(cn.course_Id));

		// type-Course title
		type(cn.txbx_Coursetitle, CourseNamenew);

		// click on Add students button
		click(cn.btn_AddStudents);

		// Click on Invite Students from my existing courses tab
		click(sd.addstud_label);

		// Assert Heading "Invite Students from my existing courses"
		Assert.assertEquals(getText(sd.addstud_label), "Invite students from my existing courses");

		// Click on All check box
		click(sd.All_checkbox);

		// Assert the check box checked
		Assert.assertTrue(isElementPresent(sd.allcheckbox_tick), "Checkbox is not checked");

		// Assert the text "Total Students Selected: 1/1"
		Assert.assertEquals(getText(sd.addstud_select), "Total Students Selected: 2/2");

		// click on add to list button
		click(cn.tab_btn_Addtolist);
		click(cn.confirmyesbtn);

		waitThread(3000);
		
		click(cn.btn_Createcourse1);
		waitThread(1000);
		ScrollTo_Location(cn.btn_createcourse2);
		// click on create course button
		click(cn.btn_createcourse2);

		waitThread(1000);
		waitFor(cn.toaster);

		// verify toaster-Course created successfully
		Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");
		click(QP.toasterclosebtn);
		waitThread(2000);

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 30)
	public void TCSPR0901130() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on first student's profile
	 * and accept course request
	 */
	@Test(priority = 31)
	public void TCSPR0901131() {

		rs.login_Student(Emailstudent1, cm.Password);

		// click on My course tab
		click(sd.MyCourseTab);

		// verify course name visible
		Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not Present");

		// verify the the course name
		Assert.assertEquals(getText(rs.course_name).trim(), CourseNamenew.trim());

	}

	/*
	 * To Accept course and perform logout functionality on the student profile
	 */
	@Test(priority = 32)
	public void TCSPR0901132() {

		// click on accept course button
		click(rs.btn_acceptcourse);

		// verify the confirmation popup visible
		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");

		// click on Yes button
		click(rs.popupbtn_Yes);

		// Toaster message
		waitFor(rs.toaster);
		Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
		click(QP.toasterclosebtn);
		type(sd.studentsearcbox, CourseNamenew);
		waitThread(1000);
		// verify the course name visibled on the enrolled section
		waitFor(rs.enrolledcoursename);
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseNamenew.trim());
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on second student's profile
	 * and accept course request
	 */
	@Test(priority = 33)
	public void TCSPR0901133() {
		rs.login_Student(Emailstudent2, cm.Password);

		// click on My course tab
		click(sd.MyCourseTab);

		// verify course name visible
		Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not Present");

		// verify the the course name
		Assert.assertEquals(getText(rs.course_name).trim(), CourseNamenew.trim());
		// click on accept course button
	}

	/*
	 * To load the create new assessment page and fill details on the basic
	 * details page
	 */
	@Test(priority = 34)
	public void TCSPR0901134() {

		click(rs.btn_acceptcourse);

		// verify the confirmation popup visible
		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");

		// click on Yes button
		click(rs.popupbtn_Yes);

		// Toaster message
		waitFor(rs.toaster);
		Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
		click(QP.toasterclosebtn);
		type(sd.studentsearcbox, CourseNamenew);
		waitThread(1000);
		// verify the course name visibled on the enrolled section
		waitFor(rs.enrolledcoursename);
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseNamenew.trim());
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 35)
	public void TCSPR0901135() {

		rs.login_Teacher(Emailteacher, password);

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(5000);

		click(ba.btn_createnewassessment);
		waitThread(1000);

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(pr.course_drp3);

		// verify the course title
		Assert.assertEquals(getText(pr.course_drp3).trim(), CourseNamenew.trim());
		click(pr.course_drp3);

		NewAssessmentName = "NewAssessment" + generateRandomNumber().trim();

		type(QP.Assess_name, NewAssessmentName);
		waitThread(3000);
		// Click on save and next button
		click(pr.savennext_button);
		waitThread(3000);
		waitThread(1000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

	}

	/*
	 * To verify the details on the peer review page
	 */
	@Test(priority = 36)
	public void TCSPR0901136() {
		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question2");

		driver.switchTo().defaultContent();

		waitThread(1000);

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(1000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R2");

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
	 * To perform the save and next functionaity from peer review page and to
	 * verify the schedule page buttons
	 */
	@Test(priority = 37)
	public void TCSPR0901137() {

		waitThread(2000);

		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + NewAssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID1));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseNamenew.trim()));

		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");

	}

	/*
	 * To perform the save and next functionaity from peer review page and to
	 * verify the schedule page buttons
	 */
	@Test(priority = 38)
	public void TCSPR0901138() {

		// Type peer review reward score
		type(pr.PRreward_txtbox, "100");

		click(pr.savennext_button);
		waitThread(2000);
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);
		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.Sbassessmentname_lbl).contains("Assessment Name: " + NewAssessmentName));

		Assert.assertTrue(isEnabled(sb.clearall_btn), "Button Disabled");

		Assert.assertTrue(isEnabled(sb.configuredef_btn), "Button Disabled");
	}

	/*
	 * To Check whether the Configure default date popup having same dates of
	 * previous course
	 */
	@Test(priority = 39)
	public void TCSPR0901139() {

		click(sb.configuredef_btn);
		waitThread(1000);

		// Assert pop visible
		Assert.assertTrue(isElementPresent(sd.congigdef_popup), "popup not present");

		Scroll_DowntoEnd();
		waitThread(1000);

		Assert.assertEquals(getValue(sd.reconisderdays), reconisderdays);
		// Assert.assertEquals(getValue(sd.reconsidertime), reconsidertime);

	}

	/*
	 * To apply the already saved configure default dates to schedule page
	 */
	@Test(priority = 40)
	public void TCSPR0901140() {

		// click close
		click(sd.close_btn);

		waitThread(1000);

		// Assert popup present
		Assert.assertFalse(isElementPresent(sd.congigdef_popup), "popup  present");
		ScrollTo_xy_position(300, 0);
		// click apply button
		click(sb.apply_btn);

		waitFor(QP.toaster);

		// Assert toaster"Default Dates Applied"
		Assert.assertEquals(getText(QP.toaster), "Default Dates Applied");
		click(QP.toasterclosebtn);
	}

	/*
	 * To check the labels on the configure defaut page
	 */
	@Test(priority = 41)
	public void TCSPR0901141() {

		Scroll_DowntoEnd();

		// Assert the Teacher will manually publish the result radio button is
		// selected
		Assert.assertTrue(isEnabled(sb.teachwill_radio_select),
				"Teacher will manually publish the result radio button not selected");

		// Assert the Result publishing date radio button is unselected
		Assert.assertFalse(isSelected(sb.resultpublish_radio), "radio button is selected");

		// Assert the Allow students to raise a Reconsideration Request Label
		// visible
		Assert.assertEquals(getText(sb.allowstudent_lbl), "Allow students to raise a Reconsideration Request");

		// Assert the Allow students to raise a Reconsideration Request check
		// box is
		// unchecked
		Assert.assertFalse(isSelected(sb.allowstu_checkbx2),
				"Allow students to raise a Reconsideration Request check box is checked");

		// Assert the time on the box is same as configure page
		// Assert.assertEquals(getValue(sb.lasttime_select_bx), reconsidertime);
		// Assert the days visible on the page
		Assert.assertEquals(getValue(sb.day_drop_txtbx), reconisderdays);
		ScrollTo_xy_position(300, 0);
		// Assert Configure date is applied correctly on schedule page
		Assert.assertEquals(getValue(sb.assessmentopendate_txtbx), sd.getNextday());

		waitThread(1000);
		Assert.assertEquals(getValue(sb.assessmentduedate_txtbx), sd.getNextday());
		Assert.assertEquals(getValue(sb.peerreviewopendate_txtbx), sd.getNextday());
		Assert.assertEquals(getValue(sb.peerreviewduedate_txtbx), sd.getNextday());
		Assert.assertEquals(getValue(sb.assessmentopentime_txtbx), Config_assessmentopentime);

		Assert.assertEquals(getValue(sb.assessmentduetime_txtbx), Config_assessmentduetime);
		Assert.assertEquals(getValue(sb.peerreviewopentime_txtbx1), Config_peerreviewopentime);
		Assert.assertEquals(getValue(sb.peerreviewduetime_txtbx), Config_peerreviewduetime);

		// Click on save and next button
		click(pr.savennext_button);
		waitFor(QP.toaster);

		// Assert toaster"Peer Review Open date and time is mandatory"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);
		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");

	}

	/*
	 * To perform Delete Teacher Account functionality
	 */
	@Test(priority = 42)
	public void TCSPR0901142() {

		waitThread(3000);
		cr.DeleteAccount();

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted teacher profile credentials
	 */
	@Test(priority = 43)
	public void TCSPR0901143() {

		// login using deleted account credentials
		lg.login(Emailteacher, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student1 Account functionality
	 */
	@Test(priority = 44)
	public void TCSPR0901144() {

		// login using deleted account credentials
		lg.login1(Emailstudent1, password);

		cr.DeleteAccount();

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 1 profile
	 * credentials
	 */
	@Test(priority = 45)
	public void TCSPR0901145() {

		// login using deleted account credentials
		lg.login(Emailstudent1, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student2 Account functionality
	 */
	@Test(priority = 46)
	public void TCSPR0901146() {

		// login using deleted account credentials
		lg.login1(Emailstudent2, password);

		cr.DeleteAccount();

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 2 profile
	 * credentials
	 */
	@Test(priority = 47)
	public void TCSPR0901147() {

		// login using deleted account credentials
		lg.login(Emailstudent2, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

}
