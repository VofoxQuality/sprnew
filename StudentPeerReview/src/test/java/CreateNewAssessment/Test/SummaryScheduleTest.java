package CreateNewAssessment.Test;

import static org.testng.Assert.assertTrue;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
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

public class SummaryScheduleTest extends basePage {

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
	CommonMethods cm = new CommonMethods();

	public String Emailteacher;

	public String NewCourseTitle;

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
	public String CourseID = cm.CourseID3;
	public String CourseName = cm.CourseName3;

	/*
	 * To perform Sign in functionality
	 */

	@Test(priority = 0)
	public void TCSPR0901401() {
		click(lg.LoginBtn_1);
		cm.login(cm.emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");
	}

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */
	@Test(priority = 1)
	public void TCSPR0901402() throws InterruptedException

	{
		SoftAssert softAssert1 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);
		TimeUnit.SECONDS.sleep(25);
		// waitThread(12000);
		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);

		// To click on course dropdown
		click(ba.dd_course);
		waitThread(2000);
		waitFor(ba.ddcoursename3);

		softAssert1.assertEquals(getText(ba.ddcoursename3), CourseName.trim(),
				"course name not visible on the dropdown");

		click(ba.ddcoursename3);

		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentName = "Assessment" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentName);

		waitThread(2000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(2000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(5000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), AssessmentName);

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID + ", " + CourseName.trim());

		softAssert1.assertAll();

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 2)
	public void TCSPR0901403() {
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
		// waitThread(6000);

		// Click rubric drop down
		// click(QP.rubric_drp_btn);
		// waitThread(3000);

		// Click Standard rubric radio button
		// click(QP.std_rad);

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

		// Assert.assertEquals(getText(QP.max_scorbx), "3");

		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");

		click(QP.toasterclosebtn);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is not selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	/*
	 * To verify details on the peer review page
	 */
	@Test(priority = 3)
	public void TCSPR0901404() {
		Student1firstname = "Ashley";
		Student1lastname = "Albert";
		Student1name = Student1firstname + " " + Student1lastname;
		Student2firstname = "Ben";
		Student2lastname = "Alex";
		Student2name = Student2firstname + " " + Student2lastname;
		waitThread(2000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));
		// Assert course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Assert the text::Total Students : Assert the total student count is 3
		Assert.assertEquals(getText(pr.totalstudent_lbl1).trim(), "Total Students : 3");

		// Assert the student names
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Student1name.trim());
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Student2name.trim());

	}

	/*
	 * To verify details on the schedule page
	 */
	@Test(priority = 4)
	public void TCSPR0901405() {
		type(pr.PRreward_txtbox, "50");
		waitThread(3000);

		// Click Save&Next button
		click(QP.savenext_btn);
		waitThread(2000);
		// Assert the peer schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");
		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.scheduleassessmentname).contains("Assessment Name: " + AssessmentName));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.schedulecoursename).contains(CourseID));
		Assert.assertTrue(getText(sb.schedulecoursename).contains(CourseName.trim()));

	}

	public String assessmentopendate;
	public String assessmentopentime;
	public String assessmentduedate;
	public String assessmentduetime;
	/*
	 * To verify the details on the Test Window section[Date,Time]
	 */

	@Test(priority = 5)
	public void TCSPR0901406() {
		// Read the date and time

		assessmentopendate = getValue(sbp.assessmentopendate_txtbx);
		assessmentopentime = getValue(sbp.assessmentopentime_txtbx);
		assessmentduedate = getValue(sbp.assessmentduedate_txtbx);
		assessmentduetime = getValue(sbp.assessmentduetime_txtbx);
		Assert.assertEquals(getValue(sbp.assessmentopendate_txtbx), assessmentopendate);
		Assert.assertEquals(getValue(sbp.assessmentopentime_txtbx), assessmentopentime);
		Assert.assertEquals(getValue(sbp.assessmentduedate_txtbx), assessmentduedate);
		Assert.assertEquals(getValue(sbp.assessmentduetime_txtbx), assessmentduetime);

	}

	public String peerreviewopendate;
	public String peerreviewopentime;
	public String peerreviewduedate;
	public String peerreviewduetime;

	/*
	 * To verify the details on the Peer Review Window section[Date,Time]
	 */
	@Test(priority = 6)
	public void TCSPR0901407() {
		// Read the Date and Time

		peerreviewopendate = getValue(sbp.peerreviewopendate_txtbx);
		peerreviewopentime = getValue(sbp.peerreviewopentime_txtbx1);
		peerreviewduedate = getValue(sbp.peerreviewduedate_txtbx);
		peerreviewduetime = getValue(sbp.peerreviewduetime_txtbx);
		Assert.assertTrue(isElementPresent(sbp.peerreviewopendate_txtbx), "textbox not present");
		Assert.assertTrue(isElementPresent(sbp.peerreviewopentime_txtbx1), "textbox not present");
		Assert.assertTrue(isElementPresent(sbp.peerreviewduedate_txtbx), "textbox not present");
		Assert.assertTrue(isElementPresent(sbp.peerreviewduetime_txtbx), "textbox not present");

	}

	public String resultpublishdate;
	public String resultpublishtime;

	/*
	 * To verify the details on the Result Publishing section[Date,Time]
	 */
	@Test(priority = 7)
	public void TCSPR0901408() {
		resultpublishdate = getValue(sbp.resultpublishdate_txtbx);
		resultpublishtime = getValue(sbp.resultpublishtime_txtbx);
		Assert.assertTrue(isElementPresent(sbp.resultpublishdate_txtbx), "textbox not present");
		Assert.assertTrue(isElementPresent(sbp.resultpublishtime_txtbx), "textbox not present");

	}

	/*
	 * To perform save and next functionality from the schedule page
	 */
	@Test(priority = 8)
	public void TCSPR0901409() {
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
	@Test(priority = 9)
	public void TCSPR0901410() {
		Assert.assertTrue(isElementPresent(sshp.Schedulesection), "Schedule section not present");
		Assert.assertEquals(getText(sshp.testopenlbl), "Open on:");
		Assert.assertEquals(getText(sshp.testduelbl), "Due on:");
		Assert.assertEquals(getText(sshp.Resultmethodsection),
				"Result Publishing Method: \n" + "Result will be published automatically");

	}

	/*
	 * To verify the details on the Test Window section on the summary
	 * page[Labels,Date,Time]
	 */

	@Test(priority = 10)
	public void TCSPR0901411() {

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
	@Test(priority = 11)
	public void TCSPR0901412() {
		// To verify labels
		Assert.assertEquals(getText(sshp.peerreviewlbl1), "Peer Review");
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
		Assert.assertEquals(getValue(sshp.Reviewduetimevalue), peerreviewduetime);

	}

	/*
	 * To verify the details on the Result Publishing section[Labels,Date,Time]
	 */
	@Test(priority = 12)
	public void TCSPR0901413() {
		// To verify label
		Assert.assertEquals(getText(sshp.lblresultpublish1), "Result publishing on");

		// To check the textboxes are in disabled state
		Assert.assertEquals(getAttribute(sshp.Resultdatetxtbx, "disabled"), "true");
		Assert.assertEquals(getAttribute(sshp.Resulttimetxtbox, "disabled"), "true");

		// To verify the date and time values on the summary Result Publish
		// section
		Assert.assertEquals(getValue(sshp.Resultdatevalue), resultpublishdate);
		Assert.assertEquals(getValue(sshp.Resulttimevalue), resultpublishtime);

	}

	/*
	 * To check the Edit schedule date functionality on the summary page
	 */

	@Test(priority = 13)
	public void TCSPR0901414() {
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
	 * To change the result publishing date is manually[Teacher will manually
	 * publish the result] and check the details on the summary page
	 */
	@Test(priority = 14)
	public void TCSPR0901415() {
		Assert.assertTrue(isElementPresent(sshp.scheduletechermanualbtn),
				"Teacher will manually publish the result radio button not present");
		click(sshp.scheduletechermanualbtn);

		Assert.assertTrue(isElementPresent(sshp.checkedmanualbtn),
				"Teacher will manually publish radio button is not selected");
		ScrollTo_xy_position(0, 300);

		waitThread(1000);
		Assert.assertTrue(isElementPresent(sshp.schedulereconsiderationchkbx),
				"Allow students to raise a Reconsideration Request check box is  present");

		Assert.assertEquals(getText(sshp.schedulereconsiderationtext),
				"Allow students to raise a Reconsideration Request");
	}

	/*
	 * To perform the save and next functionality and check the Schedule section on
	 * the summary page
	 */
	@Test(priority = 15)
	public void TCSPR0901416() {
		click(QP.savenext_btn);
		// click(ba.btnsaveandnext);
		waitThread(2000);
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
	@Test(priority = 16)
	public void TCSPR0901417() {

		click(sshp.btnscheduleedit);
		waitThread(2000);
		// Assert the peer schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");
		// To perform discard functionality check confirmation popup

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
	 * To Edit dates and check that it should be updating on the summary page-
	 * Test/Peer review open and due dates
	 */
	@Test(priority = 17)
	public void TCSPR0901418() {

		click(sshp.btnscheduleedit);
		waitThread(2000);
		// Assert the peer schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");
		// To perform clear all functionality
		click(sbp.clearall_btn);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(sbp.conf_dlgbx), "Confirmation popup not present");
		click(sbp.confyes_btn);
		waitFor(pr.assessmentde_toaster);
		Assert.assertEquals(getText(pr.assessmentde_toaster), "Cleared successfully");
		click(QP.toasterclosebtn);
		waitThread(3000);

		// To check the text boxes
		Assert.assertEquals(getValue(sbp.assessmentduedate_txtbx), "");
		Assert.assertEquals(getValue(sbp.assessmentduetime_txtbx), "");
		Assert.assertEquals(getValue(sbp.assessmentopentime_txtbx), "");
		Assert.assertEquals(getValue(sbp.assessmentopendate_txtbx), "");
		Assert.assertEquals(getValue(sbp.peerreviewopendate_txtbx), "");
		Assert.assertEquals(getValue(sbp.peerreviewopentime_txtbx1), "");
		Assert.assertEquals(getValue(sbp.peerreviewduedate_txtbx), "");
		Assert.assertEquals(getValue(sbp.peerreviewduetime_txtbx), "");

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		// click on Assessment open date textbox
		click(sbp.assessmentopendate_txtbx);
		waitThread(1000);
//		Assert.assertTrue(isElementPresent(sbp.assessopen_calendar), "Assessment open date Calendar not  present");
		waitThread(1000);
		// Doubleclick(sbp.calanderdate_val);
		cm.ClicktomorrowDate();
		waitThread(3000);

		// click on Assessment due date Calendar
		waitThread(1000);
		click(sbp.assessmentduedate_txtbx);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(sbp.assessdue_calendar), "Assessment due date Calendar not  present");
		waitThread(1000);
		// Doubleclick(sbp.calanderdate_val);
		cm.ClicktomorrowDate();
		waitThread(3000);

		// Read the date and time

		assessmentopendate1 = getValue(sbp.assessmentopendate_txtbx);
		assessmentopentime1 = getValue(sbp.assessmentopentime_txtbx);
		assessmentduedate1 = getValue(sbp.assessmentduedate_txtbx);
		assessmentduetime1 = getValue(sbp.assessmentduetime_txtbx);

	}

	/*
	 * To select the peer review open and due dates
	 */
	@Test(priority = 18)
	public void TCSPR0901419() {

		// Click on peer review open calendar
		waitThread(1000);
		click(sbp.peerreviewopendate_txtbx);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(sbp.peeropen_calendar), "Peer Review open Calendar not  present");
		// select date
		// Doubleclick(sbp.calanderdate_val);
		cm.ClicktomorrowDate();
		waitThread(3000);
		// Assert.assertFalse(isElementPresent(sbp.peeropen_calendar), "Peer Review open
		// Calendar not present");

		// Click on peer review due calendar
		waitThread(1000);
		click(sbp.peerreviewduedate_txtbx);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(sbp.peerdue_calendar), "Peer Review due Calendar not  present");
		// select date
		// Doubleclick(sbp.calanderdate_val);
		cm.ClicktomorrowDate();
		waitThread(3000);
		// Assert.assertFalse(isElementPresent(sbp.peerdue_calendar), "Peer Review due
		// Calendar not present");

		// Read the Date and Time

		peerreviewopendate = getValue(sbp.peerreviewopendate_txtbx);
		peerreviewopentime = getValue(sbp.peerreviewopentime_txtbx1);
		peerreviewduedate = getValue(sbp.peerreviewduedate_txtbx);
		peerreviewduetime = getValue(sbp.peerreviewduetime_txtbx);
	}

	/*
	 * To perform save and next functionality and check that the newly added dates
	 * visible on the summary page
	 */
	@Test(priority = 19)
	public void TCSPR0901420() {

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
	 * To Fill the details on the configure default page
	 */
	@Test(priority = 20)
	public void TCSPR0901421() {
		ScrollTo_xy_position(0, 0);
		
		click(sshp.btnscheduleedit);
		waitThread(2000);
		
		ScrollTo_xy_position(0, 0);
		// Assert the schedule wizard is selected
		// Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"),
		// "true");

		// Assert.assertTrue(isElementPresent(sshp.btnconfigdefault), "Configure default
		// button not present");

		// click on configure default button
		click(sshp.btnconfigdefault);
		// waitThread(2000);
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
		// waitFor(ba.toaster);
		// Assert.assertEquals(getText(ba.toaster), "Default Dates Saved");

	}

	/*
	 * To apply default dates and assert the dates and time on each fields
	 */
	@Test(priority = 21)
	public void TCSPR0901422() {
		

		// Assert the schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");

		// click on apply default button
		click(sshp.btnapplydefault);
		waitFor(ba.toaster);
		Assert.assertEquals(getText(ba.toaster), "Default Dates Applied");
		click(ba.toasterclosebtn);
		waitThread(2000);

		// Read the Assessment date and time

		assessmentopendate1 = getValue(sbp.assessmentopendate_txtbx);
		assessmentopentime1 = getValue(sbp.assessmentopentime_txtbx);
		assessmentduedate1 = getValue(sbp.assessmentduedate_txtbx);
		assessmentduetime1 = getValue(sbp.assessmentduetime_txtbx);

		// Read the Peer Review Date and Time

		peerreviewopendate = getValue(sbp.peerreviewopendate_txtbx);
		peerreviewopentime = getValue(sbp.peerreviewopentime_txtbx1);
		peerreviewduedate = getValue(sbp.peerreviewduedate_txtbx);
		peerreviewduetime = getValue(sbp.peerreviewduetime_txtbx);

		// Read the Result Publish Date and Time

		resultpublishdate = getValue(sbp.resultpublishdate_txtbx);
		resultpublishtime = getValue(sbp.resultpublishtime_txtbx);
		click(sshp.configmailnotfication);
		
		// click on save and next button
		click(ba.btnsaveandnext);
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);
	}

	/*
	 * To Edit dates and check that it should updating on the summary page
	 */

	@Test(priority = 22)
	public void TCSPR0901423() {
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

		resultpublishdate = getValue(sbp.resultpublishdate_txtbx);
		resultpublishtime = getValue(sbp.resultpublishtime_txtbx);
		Assert.assertEquals(getValue(sbp.resultpublishdate_txtbx), resultpublishdate);
		Assert.assertEquals(getValue(sbp.resultpublishtime_txtbx), resultpublishtime);

		waitThread(1000);

		// Scroll_DowntoEnd();
		waitThread(1000);

		

	}

	/*
	 * To perform save and next functionality and check that the newly added dates
	 * visible on the summary page
	 */
	@Test(priority = 23)
	public void TCSPR0901424() {
		waitThread(1000);

		click(pr.savennext_button);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);
		waitThread(1000);

		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sbp.summary_wizard, "aria-selected"), "true");
		waitThread(1000);
		// To verify the date and time values on the summary Result Publish
		// section
		 Assert.assertEquals(getValue(sshp.Resultdatevalue), resultpublishdate);
		 Assert.assertEquals(getValue(sshp.Resulttimevalue), resultpublishtime);

	}

	public String reconsiderationdate;
	public String reconsiderationtime;
	/*
	 * To Edit dates and check that it should updating on the summary page
	 */

	@Test(priority = 24)
	public void TCSPR0901425() {
		ScrollTo_xy_position(0, 0);
		waitThread(2000);
		click(sshp.btnscheduleedit);
		waitThread(2000);
		// Assert the peer schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");

		// To fill Automatic publish result fields
		ScrollTo_xy_position(0, 300);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(sshp.scheduletechermanualbtn),
				"Teacher will manually publish the result radio button not present");
		click(sshp.scheduletechermanualbtn);

		Assert.assertTrue(isElementPresent(sshp.checkedmanualbtn),
				"Teacher will manually publish radio button is not selected");

		waitThread(1000);
		Assert.assertTrue(isElementPresent(sshp.schedulereconsiderationchkbx),
				"Allow students to raise a Reconsideration Request check box is  present");

		Assert.assertEquals(getText(sshp.schedulereconsiderationtext),
				"Allow students to raise a Reconsideration Request");
		 click(sshp.reconsiderchkbx);
		waitThread(1000);
		
	}

	/*
	 * To perform save and next functionality and check that the newly added dates
	 * visible on the summary page
	 */
	@Test(priority = 25)
	public void TCSPR0901426() {
		// click on save and next button
		click(ba.btnsaveandnext);
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);
		waitThread(3000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");
		// ScrollTo_xy_position(0, 300);
		Assert.assertEquals(getText(sshp.Resultmethodsection),
				"Result Publishing Method: \n" + "Teacher will manually publish the result");
		
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
	 * To check the discard popup functionality on the schedule edit page
	 */
	@Test(priority = 26)
	public void TCSPR0901427() {
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

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 27)
	public void TCSPR0901428() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

}
