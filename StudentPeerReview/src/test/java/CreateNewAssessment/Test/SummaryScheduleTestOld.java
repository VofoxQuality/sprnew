package CreateNewAssessment.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import Course.Pages.EditCoursePage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CreateNewAssessment.Pages.SummarySchedulePage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class SummaryScheduleTestOld extends basePage {

	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	CourseRosterPage cr = new CourseRosterPage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	EncryptedText et = new EncryptedText();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	EditCoursePage ec = new EditCoursePage();
	BasicDetailsAssessmentTest bdt = new BasicDetailsAssessmentTest();
	SchedulePageBasicsPage sbp = new SchedulePageBasicsPage();
	SummaryBasicsPage sb = new SummaryBasicsPage();
	SummaryBasicsTest sbt = new SummaryBasicsTest();
	SummarySchedulePage sshp = new SummarySchedulePage();

	public String Emailteacher;
	public String CourseName;
	public String NewCourseTitle;
	public String CourseID;
	public String AssessmentName;
	public String Emailstudent1;
	public String Emailstudent2;
	public String Emailstudent3;
	public String Emailstudent4;
	public String Student1firstname;
	public String Student1lastname;
	public String Student1name;
	public String Student2firstname;
	public String Student2lastname;
	public String Student2name;
	public String Student3firstname;
	public String Student3lastname;
	public String Student3name;
	public String Student4firstname;
	public String Student4lastname;
	public String Student4name;

	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	/*
	 * To perform Sign Up functionality
	 */
	@Test(priority = 0)
	public void TCSPR0901401() {

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
	public void TCSPR0901402() {

		CourseName = "Course Name" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID = (getText(cn.course_Id));

		// type-Course title
		type(cn.txbx_Coursetitle, CourseName);

		// Assert the course title
		Assert.assertEquals(getValue(cn.txbx_Coursetitle), CourseName.trim());
	}

	@Test(priority = 3)
	public void TCSPR0901403() {
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

	@Test(priority = 4)
	public void TCSPR0901404() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * To check that invited course request visible on first student 's profile
	 * and accept course request-Read the student name
	 */
	@Test(priority = 5)
	public void TCSPR0901405() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent1, CourseID);
		String encText = et.EncryptCode(studentinviteid);

		driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Student1firstname = "Ashley";
		Student1lastname = "Albert";
		Student1name = Student1firstname + " " + Student1lastname;

		// click first name
		click(sp.txtbxFirstN);
		waitThread(1000);
		// type first name
		type(sp.txtbxFirstN, Student1firstname);
		waitThread(1000);
		// click last name
		click(sp.txtbxLastN);
		waitThread(1000);
		// type last name
		type(sp.txtbxLastN, Student1lastname);
		waitThread(1000);
		// click password
		click(sp.txtbxPass);
		waitThread(1000);
		// type password
		type(sp.txtbxPass, password);
		waitThread(1000);
		// click password
		click(sp.txtbxPassconf);
		waitThread(1000);
		// type password
		type(sp.txtbxPassconf, password);
		waitThread(1000);
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
	@Test(priority = 6)
	public void TCSPR0901406() {
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
	 * To check that invited course request visible on second student's profile
	 * and course request-Read the student name
	 */
	@Test(priority = 7)
	public void TCSPR0901407() throws SQLException {
		studentinviteid = dc.InviteLink(Emailstudent2, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Student2firstname = "Ben";
		Student2lastname = "Alex";
		Student2name = Student2firstname + " " + Student2lastname;

		// click first name
		click(sp.txtbxFirstN);
		waitThread(1000);
		// type first name
		type(sp.txtbxFirstN, Student2firstname);
		waitThread(1000);
		// click last name
		click(sp.txtbxLastN);
		waitThread(1000);
		// type last name
		type(sp.txtbxLastN, Student2lastname);
		waitThread(1000);
		// click password
		click(sp.txtbxPass);
		waitThread(1000);
		// type password
		type(sp.txtbxPass, password);
		waitThread(1000);
		// click password
		click(sp.txtbxPassconf);
		waitThread(1000);
		// type password
		type(sp.txtbxPassconf, password);
		waitThread(1000);
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
	@Test(priority = 8)
	public void TCSPR0901408() {

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

	@Test(priority = 9)
	public void TCSPR0901409() {

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

		waitThread(1000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(1000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(3000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), AssessmentName.trim());

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID + ", " + CourseName.trim());

		softAssert1.assertAll();

	}

	/*
	 * To fill details on the Question page
	 */

	@Test(priority = 10)
	public void TCSPR0901410() {

		sbt.TCSPR0901209();
	}

	/*
	 * To verify details on the peer review page
	 */

	@Test(priority = 11)
	public void TCSPR0901411() {

		waitThread(2000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));
		// Assert course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");

		// Assert the student names
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Student1name.trim());
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Student2name.trim());

	}

	/*
	 * To verify details on the schedule page
	 */

	@Test(priority = 12)
	public void TCSPR0901412() {

		// Type Reward Percentage
		type(pr.PRreward_txtbox, "50");
		waitThread(3000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the peer schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");
		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.scheduleassessmentname).contains("Assessment Name: " + AssessmentName));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.schedulecoursename).contains(CourseID));
		Assert.assertTrue(getText(sb.schedulecoursename).contains(CourseName.trim()));
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);
	}

	public String assessmentopendate;
	public String assessmentopentime;
	public String assessmentduedate;
	public String assessmentduetime;

	/*
	 * To verify the details on the Test Window section[Date,Time]
	 */
	@Test(priority = 13)
	public void TCSPR0901413() {

		// Read the date and time

		assessmentopendate = getValue(sbp.assessmentopendate_txtbx);
		assessmentopentime = getValue(sbp.assessmentopentime_txtbx);
		assessmentduedate = getValue(sbp.assessmentduedate_txtbx);
		assessmentduetime = getValue(sbp.assessmentduetime_txtbx);
		Assert.assertTrue(isElementPresent(sbp.assessmentopendate_txtbx), "textbox not present");
		Assert.assertTrue(isElementPresent(sbp.assessmentopentime_txtbx), "textbox not present");
		Assert.assertTrue(isElementPresent(sbp.assessmentduedate_txtbx), "textbox not present");
		Assert.assertTrue(isElementPresent(sbp.assessmentduetime_txtbx), "textbox not present");

	}

	public String peerreviewopendate;
	public String peerreviewopentime;
	public String peerreviewduedate;
	public String peerreviewduetime;

	/*
	 * To verify the details on the Peer Review Window section[Date,Time]
	 */
	@Test(priority = 14)
	public void TCSPR0901414() {

		// Read the Date and Time

		peerreviewopendate = getValue(sbp.peerreviewopendate_txtbx);
		peerreviewopentime = getValue(sbp.peerreviewopentime_txtbx);
		peerreviewduedate = getValue(sbp.peerreviewduedate_txtbx);
		peerreviewduetime = getValue(sbp.peerreviewduetime_txtbx);
		Assert.assertTrue(isElementPresent(sbp.peerreviewopendate_txtbx), "textbox not present");
		Assert.assertTrue(isElementPresent(sbp.peerreviewopentime_txtbx), "textbox not present");
		Assert.assertTrue(isElementPresent(sbp.peerreviewduedate_txtbx), "textbox not present");
		Assert.assertTrue(isElementPresent(sbp.peerreviewduetime_txtbx), "textbox not present");

	}

	public String resultpublishdate;
	public String resultpublishtime;

	/*
	 * To verify the details on the Result Publishing section[Date,Time]
	 */
	@Test(priority = 15)
	public void TCSPR0901415() {

		// Read the Date and Time

		resultpublishdate = getValue(sbp.resultpublishdate_txtbx);
		resultpublishtime = getValue(sbp.resultpublishtime_txtbx);
		Assert.assertTrue(isElementPresent(sbp.resultpublishdate_txtbx), "textbox not present");
		Assert.assertTrue(isElementPresent(sbp.resultpublishtime_txtbx), "textbox not present");

	}

	public String reconsiderationdate;
	public String reconsiderationtime;

	/*
	 * To verify the details on the Allow students to raise a Reconsideration
	 * Request section[Date,Time]
	 */
	@Test(priority = 16)
	public void TCSPR0901416() {

		// Read the Date and Time

		reconsiderationdate = getValue(sbp.lastdate_txtbx);
		reconsiderationtime = getValue(sbp.lastdatetime_txtbx);
		Assert.assertTrue(isElementPresent(sbp.lastdate_txtbx), "textbox not present");
		Assert.assertTrue(isElementPresent(sbp.lastdatetime_txtbx), "textbox not present");

	}

	/*
	 * To perform save and next functionality from the schedule page
	 */
	@Test(priority = 17)
	public void TCSPR0901417() {

		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");
		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.summaryassessmentname).contains("Assessment Name: " + AssessmentName));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.summarycoursename).contains(CourseID));
		Assert.assertTrue(getText(sb.summarycoursename).contains(CourseName.trim()));

	}

	/*
	 * To check the Schedule section on the summary page[Headings and labels]
	 */
	@Test(priority = 18)
	public void TCSPR0901418() {

		Assert.assertTrue(isElementPresent(sshp.Schedulesection), "Schedule section not present");
		Assert.assertEquals(getText(sshp.Resultmethodsection),
				"Result Publishing Method: \n" + "Result will be published automatically");
		Assert.assertTrue(isElementPresent(sshp.reconsiderationckbx), "Reconsideration request checkbox not present");
		Assert.assertEquals(getText(sshp.reconsiderationreqstsection),
				"Allow Students to raise a Reconsideration Request if they are not satisfied with the score granted by peers");
		Assert.assertTrue(isElementPresent(sshp.recchkbx),
				"Reconsideration request checkbox is not disabled and checked");

	}

	/*
	 * To verify the details on the Test Window section on the summary
	 * page[Labels,Date,Time]
	 */

	@Test(priority = 19)
	public void TCSPR0901419() {

		// To verify labels
		Assert.assertEquals(getText(sshp.lblassessment), "Assessment");
		Assert.assertEquals(getText(sshp.testopenlbl), "Open on:");
		Assert.assertEquals(getText(sshp.testduelbl), "Due on:");

		// To check the textboxes are in disabled sate
		Assert.assertEquals(getAttribute(sshp.Testopendatetxtbx, "disabled"), "true");
		Assert.assertEquals(getAttribute(sshp.Testopentimetxtbx, "disabled"), "true");
		Assert.assertEquals(getAttribute(sshp.Testduedatetxtbx, "disabled"), "true");
		Assert.assertEquals(getAttribute(sshp.Testduetimetxtbx, "disabled"), "true");

		// To verify the date and time values on the summary Assessment section
		Assert.assertEquals(getValue(sshp.Testopendatevalue), assessmentopendate);
		Assert.assertEquals(getValue(sshp.Testopentimevalue), assessmentopentime);
		Assert.assertEquals(getValue(sshp.Testduedatevalue), assessmentduedate);
		Assert.assertEquals(getValue(sshp.Testduetimevalue), assessmentduetime);

	}

	/*
	 * To verify the details on the Peer Review Window section on the summary
	 * page[Labels,Date,Time]
	 */
	@Test(priority = 20)
	public void TCSPR0901420() {

		// To verify labels
		Assert.assertEquals(getText(sshp.peerreviewlbl), "Peer Review");
		Assert.assertEquals(getText(sshp.peerreviewopenlbl), "Open on:");
		Assert.assertEquals(getText(sshp.peereviewduelbl), "Due on:");

		// To check the textboxes are in disabled state
		Assert.assertEquals(getAttribute(sshp.Reviewopendatetxtbx, "disabled"), "true");
		Assert.assertEquals(getAttribute(sshp.Reviewopentimetxtbx, "disabled"), "true");
		Assert.assertEquals(getAttribute(sshp.Reviewduedatetxtbx, "disabled"), "true");
		Assert.assertEquals(getAttribute(sshp.Reviewduetimetxtbx, "disabled"), "true");

		// To verify the date and time values on the summary Peer Review section
		Assert.assertEquals(getValue(sshp.Reviewopendatevalue), peerreviewopendate);
		Assert.assertEquals(getValue(sshp.Reviewopentimevalue), peerreviewopentime);
		Assert.assertEquals(getValue(sshp.Reviewduedatevalue), peerreviewduedate);
		Assert.assertEquals(getValue(sshp.Reviewduetimevalue), peerreviewopentime);

	}

	/*
	 * To verify the details on the Result Publishing section[Labels,Date,Time]
	 */
	@Test(priority = 21)
	public void TCSPR0901421() {

		// To verify label
		Assert.assertEquals(getText(sshp.lblresultpublish), "Result publishing on");

		// To check the textboxes are in disabled state
		Assert.assertEquals(getAttribute(sshp.Resultdatetxtbx, "disabled"), "true");
		Assert.assertEquals(getAttribute(sshp.Resulttimetxtbox, "disabled"), "true");

		// To verify the date and time values on the summary Result Publish
		// section
		Assert.assertEquals(getValue(sshp.Resultdatevalue), resultpublishdate);
		Assert.assertEquals(getValue(sshp.Resulttimevalue), resultpublishtime);

	}

	/*
	 * To verify the details on the Last date for Reconsideration Request
	 * section[Labels,Date,Time]
	 */
	@Test(priority = 22)
	public void TCSPR0901422() {

		// To verify label
		Assert.assertEquals(getText(sshp.recosiderationlbl), "Last date for Reconsideration Request");

		// To check the textboxes are in disabled state
		Assert.assertEquals(getAttribute(sshp.Reconsiderationdatetxtbx, "disabled"), "true");
		Assert.assertEquals(getAttribute(sshp.Reconsiderationtimetxtbx, "disabled"), "true");

		// To verify the date and time values on the summary Reconsideration
		// Request section
		Assert.assertEquals(getValue(sshp.Reconsiderationdatevalue), reconsiderationdate);
		Assert.assertEquals(getValue(sshp.Reconsiderationtimevalue), reconsiderationtime);

	}

	/*
	 * To check the Edit schedule date functionality on the summary page
	 */
	@Test(priority = 23)
	public void TCSPR0901423() {

		Assert.assertTrue(isElementPresent(sshp.btnscheduleedit), "Schedule Edit button not visible");
		// click on schedule edit button
		click(sshp.btnscheduleedit);
		waitThread(2000);
		// Assert the peer schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");
		// To check the buttons
		Assert.assertTrue(isElementPresent(sb.btndiscard), "Discard button not visible");
		Assert.assertTrue(isElementPresent(sb.btnsaveandnext), "Save and next button not visible");

	}

	/*
	 * To change the result publishing date is manually
	 */
	@Test(priority = 24)
	public void TCSPR0901424() {

		Assert.assertTrue(isElementPresent(sshp.scheduletechermanualbtn),
				"Teacher will manually publish the result radio button not present");
		click(sshp.scheduletechermanualbtn);

		Assert.assertTrue(isElementPresent(sshp.checkedmanualbtn),
				"Teacher will manually publish radio button is not selected");

		ScrollTo_xy_position(0, 300);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(sshp.schedulereconsiderationchkbx),
				"Allow students to raise a Reconsideration Request check box is  present");
		Assert.assertFalse(isElementPresent(sbp.lastdate_txtbx), "textbox is present");
		Assert.assertFalse(isElementPresent(sbp.lastdatetime_txtbx), "textbox is present");
	}

	/*
	 * To perform the save and next functionality and check the Schedule section
	 * on the summary page
	 */
	@Test(priority = 25)
	public void TCSPR0901425() {

		// click on save and next button
		click(ba.btnsaveandnext);
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);

		waitThread(3000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");

		// To check the result publish textboxes and labels are not visible
		Assert.assertFalse(isElementPresent(sshp.lblresultpublish), "Result publishing on label present");
		Assert.assertFalse(isElementPresent(sshp.Resultdatetxtbx), "Result Publish textbox visible");
		Assert.assertFalse(isElementPresent(sshp.Resulttimetxtbox), "Result Publish textbox visible");

		// To check the Reconsideration Request textboxes and labels are not
		// visible
		Assert.assertFalse(isElementPresent(sshp.recosiderationlbl),
				"Last date for Reconsideration Request label present");
		Assert.assertFalse(isElementPresent(sshp.Reconsiderationdatetxtbx), "Reconsideration Request textbox visible");
		Assert.assertFalse(isElementPresent(sshp.Reconsiderationtimetxtbx), "Reconsideration Request textbox visible");

	}
	/*
	 * To perform the Discard button functionality on the schedule page
	 */

	@Test(priority = 26)
	public void TCSPR0901426() {

		click(sshp.btnscheduleedit);
		waitThread(2000);
		// Assert the peer schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");
		// To perform discard functionality check confirmation popup
		click(sb.btndiscard);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(sbp.conf_dlgbx), "Confirmation popup  not present");
		waitThread(1000);
		Assert.assertEquals(getText(sbp.confirm_lbl), "Are you certain you want to proceed with your action?\n"
				+ "We see that you have not made any changes to the information on this screen");
		// Confirmation popup cancel button
		click(sbp.confno_btn);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(sbp.conf_dlgbx), "Confirmation Popup not visible");
		waitThread(2000);
		ScrollTo_xy_position(0, 0);
		waitThread(2000);
		// To perform clear all functionality
		click(sbp.clearall_btn);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(sbp.conf_dlgbx), "Confirmation popup not present");
		click(sbp.confyes_btn);
		waitFor(pr.assessmentde_toaster);
		Assert.assertEquals(getText(pr.assessmentde_toaster), "Cleared successfully");
		click(QP.toasterclosebtn);
		waitThread(3000);

		// To perform discard functionality check confirmation popup
		click(sb.btndiscard);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(sbp.conf_dlgbx), "Confirmation popup  not present");
		waitThread(1000);
		// Heading Title-Login
		Assert.assertEquals(getText(sbp.confirm_lbl), "Are you sure you want to proceed with your action?\n"
				+ "We detected you have made changes to the information on this screen and if you ‘Discard’ these changes will not be saved.");
		// Confirmation popup no button
		Assert.assertTrue(isElementPresent(sbp.confno_btn), "No button not present");
		Assert.assertTrue(isElementPresent(sbp.confyes_btn), "Yes button not present");
		click(sbp.confno_btn);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(sbp.conf_dlgbx), "Confirmation popup present");

		// To perform discard
		click(sb.btndiscard);
		waitThread(1000);
		click(sbp.confyes_btn);
		waitThread(1000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");
	}

	public String assessmentopendate1;
	public String assessmentopentime1;
	public String assessmentduedate1;
	public String assessmentduetime1;

	/*
	 * To Edit dates and check that it should updating on the summary page- Test
	 * open and due dates
	 */
	@Test(priority = 27)
	public void TCSPR0901427() {

		click(sshp.btnscheduleedit);
		waitThread(2000);
		// Assert the peer schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");

		// To perform clear all functionality
		click(sbp.clearall_btn);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(sbp.conf_dlgbx), "Confirmation popup not present");
		click(sbp.confyes_btn);

		// To check the text boxes
		Assert.assertEquals(getValue(sbp.assessmentduedate_txtbx), "");
		Assert.assertEquals(getValue(sbp.assessmentduetime_txtbx), "");
		Assert.assertEquals(getValue(sbp.assessmentopentime_txtbx), "");
		Assert.assertEquals(getValue(sbp.assessmentopendate_txtbx), "");
		Assert.assertEquals(getValue(sbp.peerreviewopendate_txtbx), "");
		Assert.assertEquals(getValue(sbp.peerreviewopentime_txtbx), "");
		Assert.assertEquals(getValue(sbp.peerreviewduedate_txtbx), "");
		Assert.assertEquals(getValue(sbp.peerreviewduetime_txtbx), "");

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		// click on Assessment open date textbox
		click(sbp.assessmentopendate_txtbx);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(sbp.assessopen_calendar), "Assessment open date Calendar not  present");
		waitThread(1000);
		Doubleclick(sbp.calanderdate_val);
		waitThread(3000);
		Assert.assertFalse(isElementPresent(sbp.assessopen_calendar), "Assessment open date Calendar present");

		// click on Assessment due date Calendar
		waitThread(1000);
		click(sbp.assessmentduedate_txtbx);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(sbp.assessdue_calendar), "Assessment due date Calendar not  prsent");
		waitThread(1000);
		Doubleclick(sbp.calanderdate_val);
		waitThread(3000);
		Assert.assertFalse(isElementPresent(sbp.assessdue_calendar), "Assessment due date Calendar not  prsent");

		// Read the date and time

		assessmentopendate1 = getValue(sbp.assessmentopendate_txtbx);
		assessmentopentime1 = getValue(sbp.assessmentopentime_txtbx);
		assessmentduedate1 = getValue(sbp.assessmentduedate_txtbx);
		assessmentduetime1 = getValue(sbp.assessmentduetime_txtbx);

	}
	/*
	 * To select the peer review open and due dates
	 */

	@Test(priority = 28)
	public void TCSPR0901428() {

		// Click on peer review open calendar
		waitThread(1000);
		click(sbp.peerreviewopendate_txtbx);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(sbp.peeropen_calendar), "Peer Review open Calendar not  present");
		// select date
		Doubleclick(sbp.calanderdate_val);
		waitThread(3000);
		Assert.assertFalse(isElementPresent(sbp.peeropen_calendar), "Peer Review open Calendar not  present");

		// Click on peer review due calendar
		waitThread(1000);
		click(sbp.peerreviewduedate_txtbx);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(sbp.peerdue_calendar), "Peer Review due Calendar not  present");
		// select date
		Doubleclick(sbp.calanderdate_val);
		waitThread(3000);
		Assert.assertFalse(isElementPresent(sbp.peerdue_calendar), "Peer Review due Calendar not  present");

		// Read the Date and Time

		peerreviewopendate = getValue(sbp.peerreviewopendate_txtbx);
		peerreviewopentime = getValue(sbp.peerreviewopentime_txtbx);
		peerreviewduedate = getValue(sbp.peerreviewduedate_txtbx);
		peerreviewduetime = getValue(sbp.peerreviewduetime_txtbx);
	}

	/*
	 * To perform save and next functionality and check that the newly added
	 * dates visible on the summary page
	 */
	@Test(priority = 29)
	public void TCSPR0901429() {

		// click on save and next button
		click(ba.btnsaveandnext);
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);
		waitThread(3000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");
		ScrollTo_xy_position(0, 300);

		// To verify the date and time values on the summary Assessment section
		Assert.assertEquals(getValue(sshp.Testopendatevalue), assessmentopendate1);
		Assert.assertEquals(getValue(sshp.Testopentimevalue), assessmentopentime1);
		Assert.assertEquals(getValue(sshp.Testduedatevalue), assessmentduedate1);
		Assert.assertEquals(getValue(sshp.Testduetimevalue), assessmentduetime1);

		// To verify the date and time values on the summary Peer Review section
		Assert.assertEquals(getValue(sshp.Reviewopendatevalue), peerreviewopendate);
		Assert.assertEquals(getValue(sshp.Reviewopentimevalue), peerreviewopentime);
		Assert.assertEquals(getValue(sshp.Reviewduedatevalue), peerreviewduedate);
		Assert.assertEquals(getValue(sshp.Reviewduetimevalue), peerreviewduetime);

	}

	/*
	 * To Edit dates and check that it should updating on the summary page
	 */
	@Test(priority = 30)
	public void TCSPR0901430() {

		ScrollTo_xy_position(0, 0);
		waitThread(2000);
		click(sshp.btnscheduleedit);
		waitThread(2000);
		// Assert the peer schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");

		// To fill Automatic publish result fields
		ScrollTo_xy_position(0, 300);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(sshp.automaticradiobtn),
				"Teacher will Automatically publish the result radio button not present");

		// click on radio button
		click(sshp.automaticradiobtn);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(sshp.automaticchecked),
				"Teacher will Automatically publish radio button is not selected");
		waitThread(1000);
		click(sbp.resultpublishdate_txtbx);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(sbp.resultpublish_calendar), "Calendar not  prsent");

		// select calendar
		Doubleclick(sbp.calanderdate_val);
		waitThread(3000);
		Assert.assertFalse(isElementPresent(sbp.resultpublish_calendar), "Calendar not  prsent");
		waitThread(2000);
		Assert.assertTrue(isElementPresent(sshp.resultfilledtime), "time not visible");

		resultpublishdate = getValue(sbp.resultpublishdate_txtbx);
		resultpublishtime = getValue(sbp.resultpublishtime_txtbx);

		waitThread(1000);

		Scroll_DowntoEnd();
		waitThread(1000);

		// click on reconsideration request check box
		click(sshp.reconsiderchkbx);
		waitThread(1000);
		click(sbp.lastdate_txtbx);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(sbp.allowstu_calendar), "Calendar not  prsent");
		// select date
		Doubleclick(sbp.calanderdate_val);
		waitThread(3000);
		Assert.assertFalse(isElementPresent(sbp.allowstu_calendar), "Calendar not  prsent");
		Assert.assertTrue(isElementPresent(sshp.reconsiderfilledtime), "time not visible");

		// Read the Date and Time

		reconsiderationdate = getValue(sbp.lastdate_txtbx);
		reconsiderationtime = getValue(sbp.lastdatetime_txtbx);

	}

	/*
	 * To perform save and next functionality and check that the newly added
	 * dates visible on the summary page
	 */
	@Test(priority = 31)
	public void TCSPR0901431() {

		waitThread(1000);

		click(pr.savennext_button);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);
		waitThread(1000);

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sbp.summary_wizard, "aria-selected"), "true");
		waitThread(1000);
		// To verify the date and time values on the summary Result Publish
		// section
		Assert.assertEquals(getValue(sshp.Resultdatevalue), resultpublishdate);
		Assert.assertEquals(getValue(sshp.Resulttimevalue), resultpublishtime);

		// To verify the date and time values on the summary Reconsideration
		// Request section
		Assert.assertEquals(getValue(sshp.Reconsiderationdatevalue), reconsiderationdate);
		Assert.assertEquals(getValue(sshp.Reconsiderationtimevalue), reconsiderationtime);

	}

	/*
	 * To Fill the details on the configure default page
	 */
	@Test(priority = 32)
	public void TCSPR0901432() {

		ScrollTo_xy_position(0, 0);
		click(sshp.btnscheduleedit);
		waitThread(2000);
		// Assert the schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");
		ScrollTo_xy_position(0, 0);
		Assert.assertTrue(isElementPresent(sshp.btnconfigdefault), "Configure default button not  present");

		// click on configure default button
		click(sshp.btnconfigdefault);
		waitThread(2000);
		Assert.assertTrue(isDisplayed(sshp.configpopup), "Configure Default popup not visible");

		// Select days count
		click(sshp.assessmentstartday);
		click(sshp.dayarrowbtn);
		Assert.assertTrue(isElementPresent(sshp.ddday), "Days dropdown not visible");
		Doubleclick(sshp.selectteststartday);
		waitThread(2000);
		Assert.assertEquals(getValue(sshp.teststartddvalue), "2");

		// click on configure save button
		click(sshp.configsavebtn);
		waitFor(ba.toaster);
		Assert.assertEquals(getText(ba.toaster), "Default Dates Saved");
		waitThread(1000);
		Assert.assertFalse(isElementPresent(sshp.configlbl), "Configure Default popup  visible");

	}

	/*
	 * To perform save and next functionality and check the dates and time on
	 * the summary page
	 */
	@Test(priority = 33)
	public void TCSPR0901433() {

		// Assert the schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");

		// click on apply default button
		click(sshp.btnapplydefault);
		waitFor(ba.toaster);
		Assert.assertEquals(getText(ba.toaster), "Default Dates Applied");
		click(ba.toasterclosebtn);

		// Read the Assessment date and time

		assessmentopendate = getValue(sbp.assessmentopendate_txtbx);
		assessmentopentime = getValue(sbp.assessmentopentime_txtbx);
		assessmentduedate = getValue(sbp.assessmentduedate_txtbx);
		assessmentduetime = getValue(sbp.assessmentduetime_txtbx);

		// Read the Peer Review Date and Time

		peerreviewopendate = getValue(sbp.peerreviewopendate_txtbx);
		peerreviewopentime = getValue(sbp.peerreviewopentime_txtbx);
		peerreviewduedate = getValue(sbp.peerreviewduedate_txtbx);
		peerreviewduetime = getValue(sbp.peerreviewduetime_txtbx);

		// Read the Result Publish Date and Time

		resultpublishdate = getValue(sbp.resultpublishdate_txtbx);
		resultpublishtime = getValue(sbp.resultpublishtime_txtbx);

		// Read the Reconsideration request Date and Time

		reconsiderationdate = getValue(sbp.lastdate_txtbx);
		reconsiderationtime = getValue(sbp.lastdatetime_txtbx);

	}

	/*
	 * To perform save and next functionality and check the date and time on the
	 * summary page
	 */
	@Test(priority = 34)
	public void TCSPR0901434() {

		waitThread(1000);

		click(pr.savennext_button);
		waitFor(QP.toaster);

		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);
		waitThread(1000);
		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sbp.summary_wizard, "aria-selected"), "true");

		// To verify the date and time values on the summary Assessment section
		Assert.assertEquals(getValue(sshp.Testopendatevalue), assessmentopendate);
		Assert.assertEquals(getValue(sshp.Testopentimevalue), assessmentopentime);
		Assert.assertEquals(getValue(sshp.Testduedatevalue), assessmentduedate);
		Assert.assertEquals(getValue(sshp.Testduetimevalue), assessmentduetime);

		// To verify the date and time values on the summary Peer Review section
		Assert.assertEquals(getValue(sshp.Reviewopendatevalue), peerreviewopendate);
		Assert.assertEquals(getValue(sshp.Reviewopentimevalue), peerreviewopentime);
		Assert.assertEquals(getValue(sshp.Reviewduedatevalue), peerreviewduedate);
		Assert.assertEquals(getValue(sshp.Reviewduetimevalue), peerreviewduetime);

		// To verify the date and time values on the summary Result Publish
		// section
		Assert.assertEquals(getValue(sshp.Resultdatevalue), resultpublishdate);
		Assert.assertEquals(getValue(sshp.Resulttimevalue), resultpublishtime);

		// To verify the date and time values on the summary Reconsideration
		// Request section
		Assert.assertEquals(getValue(sshp.Reconsiderationdatevalue), reconsiderationdate);
		Assert.assertEquals(getValue(sshp.Reconsiderationtimevalue), reconsiderationtime);

	}

	/*
	 * To check the discard popup functionality on the schedule edit page
	 */
	@Test(priority = 35)
	public void TCSPR0901435() {

		SoftAssert softAssert21 = new SoftAssert();

		click(sshp.btnscheduleedit);
		waitThread(2000);
		// Assert the schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");

		// click on manually publish radio button
		click(sshp.scheduletechermanualbtn);
		Assert.assertTrue(isElementPresent(sshp.checkedmanualbtn),
				"Teacher will manually publish radio button is not selected");

		// click on teacher name on navigation menu
		click(ba.Teachername);

		// click on account settings
		click(ba.linkaccountsettings);

		// To verify the discard popup functionality
		waitFor(ba.tabdiscardpopup);
		Assert.assertTrue(isElementPresent(ba.tabdiscardpopup), "Confirmation Popup not visible");
		waitFor(ba.txt1popup);
		softAssert21.assertEquals(getText(ba.txt1popup), "Are you certain you want to proceed with your action?\n"
				+ "Any changes that you have made will not be saved.", "Assertion  failed");

		// Popup button cancel
		click(ba.btnCancel);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(ba.tabdiscardpopup), "Confirmation Popup not visible");

		// click on teacher name on navigation menu
		click(ba.Teachername);

		// click on account settings
		click(ba.linkaccountsettings);
		Assert.assertTrue(isElementPresent(ba.tabdiscardpopup), "Confirmation Popup not visible");

		// Popup button discard
		click(ba.btnDiscard);
		Assert.assertTrue(isElementPresent(ba.btn_delete), "Delete button not visible");

		// Account delete button
		click(ba.btn_delete);

		// Delete confirmation popup yes
		click(ba.btn_yes);
		waitThread(1000);

		// Heading Title-Login
		softAssert21.assertEquals(getText(lg.PageTitle), "Login");
		softAssert21.assertAll();

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted teacher profile credentials
	 */
	@Test(priority = 36)
	public void TCSPR0901436() {

		// login using deleted account credentials
		rs.login_Teacher(Emailteacher, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student1 Account functionality
	 */
	@Test(priority = 37)
	public void TCSPR0901437() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent1, password);

		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 1 profile
	 * credentials
	 */
	@Test(priority = 38)
	public void TCSPR0901438() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent1, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student2 Account functionality
	 */
	@Test(priority = 39)
	public void TCSPR0901439() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent2, password);

		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 2 profile
	 * credentials
	 */
	@Test(priority = 40)
	public void TCSPR0901440() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent2, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");
	}

}
