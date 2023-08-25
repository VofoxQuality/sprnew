package AccountDeleteStudent;

import java.sql.SQLException;
import java.time.Month;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import AccountSettings.Pages.AccountSettingsandDeleteAccountPage;
import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import CreateNewAssessment.Pages.AssessmentPublishPopupPage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CurrentAssessmentsforStudents.Pages.StudentCurrentAssessmentBasicsPage;
import CurrentAssessmentsforStudents.Pages.StudentTestSectionPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.NewAssessmentTeacherBasicsPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import TestWindowOfIndividualStudent.AnswerWindowPage;
import TestWindowOfIndividualStudent.ModifyWizardSectionPage;
import TestWindowOfIndividualStudent.StudentAssessmentInfoAndInstructionPage;
import TestWindowOfIndividualStudent.TestWindowWizardPage;

public class Student_AccountDeleteTest extends basePage {

	StudentAccountDelete sd = new StudentAccountDelete();
	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	CourseRosterPage cr = new CourseRosterPage();
	PeerReviewPageStudentDetailsPage ps2 = new PeerReviewPageStudentDetailsPage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	AccountSettingsandDeleteAccountPage as = new AccountSettingsandDeleteAccountPage();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	EncryptedText et = new EncryptedText();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	SummaryBasicsPage sb = new SummaryBasicsPage();
	SchedulePageBasicsPage spb = new SchedulePageBasicsPage();
	TeacherTestSectionPage tts = new TeacherTestSectionPage();
	NewAssessmentTeacherBasicsPage natb = new NewAssessmentTeacherBasicsPage();
	AssessmentPublishPopupPage ap = new AssessmentPublishPopupPage();
	TeacherPeerReviewSectionPage tp = new TeacherPeerReviewSectionPage();
	StudentAssessmentInfoAndInstructionPage sa = new StudentAssessmentInfoAndInstructionPage();
	TestWindowWizardPage tsw = new TestWindowWizardPage();
	AnswerWindowPage an = new AnswerWindowPage();
	StudentCurrentAssessmentBasicsPage sca = new StudentCurrentAssessmentBasicsPage();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	StudentTestSectionPage st1 = new StudentTestSectionPage();
	PeerReviewWindowPage prp = new PeerReviewWindowPage();
	ModifyWizardSectionPage ms = new ModifyWizardSectionPage();
	CommonMethods cm = new CommonMethods();

	public String Emailteacher;
	public String Email;

	/*
	 * To perform Sign Up functionality
	 */

	@Test(priority = 0)
	public void TCSPR1800101() {

		Email = "test" + generateRandomNumber().trim() + "@gmail.com";

		// To click on I am A teacher button
		click(sp.btn_1);

		Emailteacher = st.TCSPR020005();

	}

	@Test(priority = 1)
	public void OtpFetch() throws SQLException {

		// To catch OTP from sending Resource
		st.TCSPR020006();

	}

	public String CourseName;
	public String CourseID;
	public String Emailstudent1;
	public String Emailstudent2;

	/*
	 * To perform the create new course functionality on the landing page. To invite
	 * students to course
	 */
	@Test(priority = 2)
	public void TCSPR1800102() {

		CourseName = "Course Name" + generateRandomNumber().trim();

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
	public void TCSPR1800103() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that the invited course request visible on first student's profile
	 * and accept course request-Read the student name
	 */
	public String studentinviteid;
	public String Studentfirstname;
	public String Studentlastname;
	public String Studentname;
	public String password = "Abc@123";

	@Test(priority = 4)
	public void TCSPR1800104() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent1, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname = "Ashley";
		Studentlastname = "Albert";
		Studentname = Studentfirstname + " " + Studentlastname;

		waitThread(1000);
		// click first name
		click(sp.txtbxFirstN);
		waitThread(1000);
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

		// verify course name visible
		Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not Present");

		// verify the the course name
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());

	}

	/*
	 * To Accept course and perform logout functionality on the student profile
	 */
	@Test(priority = 5)
	public void TCSPR1800105() {
		// click on accept course button
		click(rs.btn_acceptcourse);
		waitThread(2000);

		// verify the confirmation popup visible
		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");

		waitThread(1000);
		// click on Yes button
		click(rs.popupbtn_Yes);

		// Toaster message
		waitFor(rs.toaster);
		Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");

		// verify the course name visibled on the enrolled section
		waitFor(rs.enrolledcoursename);
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());
		waitThread(5000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on second student's profile and
	 * accept course request-Read the student nam
	 */
	public String Student2firstname;
	public String Student2lastname;
	public String Student2name;

	@Test(priority = 6)
	public void TCSPR1800106() throws SQLException {
		studentinviteid = dc.InviteLink(Emailstudent2, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get(prop.getProperty("UrlSignUp") + encText);

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
	 * To Accept course and verify the delete account popup for checking the active
	 * course status .
	 */
	@Test(priority = 7)
	public void TCSPR1800107() {

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

		waitThread(2000);
		// click navigation dropdown
		click(as.nav_drop2);

		// Assert the account setting button
		Assert.assertTrue(isElementPresent(as.accnt_sett1), "account settings button not present");

		// click account settings button
		click(as.accnt_sett1);

		// Assert the label Account Settings in accountsettings Page
		Assert.assertEquals(getText(as.hd_label5), "Account Settings");

		// click delete account button
		click(as.delete_button4);
		waitThread(2000);

		// Asssert the confirmation popup visible
		// *Assert the Popup text- "Are you sure that you want to permanently delete
		// this account?
		// Note: You currently have
		// *1 Active course
		Assert.assertTrue(isElementPresent(as.popbox_1), "Confirmation popup not visible");

		Assert.assertEquals(getText(as.alrt_label2), "Are you sure that you want to permanently delete this account?\n"
				+ "Note: You currently have -\n" + "* 1 active course");
		waitThread(2000);

		// Click No button
		click(as.alrt_nobutton);
		waitThread(2000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page To create An upcoming Assessment
	 */
	public String AssessmentName_ongoing;

	@Test(priority = 8)
	public void TCSPR1800108() {

		SoftAssert softAssert1 = new SoftAssert();
		rs.login_Teacher(Emailteacher, password);

		// click on Assessment tab
		click(ba.Assessmenttab);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		// To click on create new assessment button
		click(ba.btn_createnewassessment);
		waitThread(2000);

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		// Assert the course name visible on the dropdown
		softAssert1.assertEquals(getText(ba.ddcoursename1), CourseName.trim(),
				"course name not visible on the dropdown");

		// Select course
		click(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentName_ongoing = "Assessment" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentName_ongoing);

		waitThread(1000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(2000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 9)
	public void TCSPR0901209() {

		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question1");

		driver.switchTo().defaultContent();

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
	public void TCSPR0901210() {

		waitThread(4000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName_ongoing));
		// Assert course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Assert the text::Total Students : Assert the total student count is 2
		waitThread(2000);
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");

	}

	/*
	 * To perform the save and next functionaity from peer review page and verify
	 * the schedule page details
	 */
	@Test(priority = 11)
	public void TCSPR0901211() {

		type(pr.PRreward_txtbox, "50");
		waitThread(3000);

		// Click Save&Next button
		click(QP.savenext_btn);
		waitThread(4000);

		// Assert the peer schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");
		waitThread(3000);

		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(5000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");

	}

	/*
	 * To perform Assessment publish functionality and check the details on the
	 * publish popup
	 */
	@Test(priority = 12)
	public void TCSPR0901212() {

		// click on Release Button
		click(sb.btnrelease);
		waitThread(2000);

		// Assert button Back to Menu
		Assert.assertTrue(isElementPresent(tts.back_to_menubutton), "Back to menu button not present");

	}

	/*
	 * To check the back to menu button functionality and check the created
	 * assessment visible on the current assessment tab
	 */
	@Test(priority = 13)
	public void TCSPR0901213() {

		waitThread(4000);
		// click on Back To Menu Button
		click(natb.btnbacktomenu);

		waitThread(2000);

		// Assert the Current Assessment is selected
		Assert.assertEquals(getAttribute(ap.currentassess_tab, "aria-selected"), "true");

		// search assessment
		type(tp.search_box, AssessmentName_ongoing);
		waitThread(5000);

		// Assert the new assessment card visible
		Assert.assertTrue(isElementPresent(tp.newcard), " new assessment card not visible");

	}

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page To create An upcoming Assessment
	 */
	public String AssessmentName_upcoming;

	@Test(priority = 14)
	public void TCSPR0901214() {

		// To click on create new assessment button
		click(ba.btn_createnewassessment);
		waitThread(2000);

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		// Assert the course name visible on the dropdown
		Assert.assertEquals(getText(ba.ddcoursename1), CourseName.trim(), "course name not visible on the dropdown");

		// Select course
		click(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentName_upcoming = "Assessment_Upcoming" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentName_upcoming);

		waitThread(1000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(2000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 15)
	public void TCSPR0901215() {

		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question1");

		driver.switchTo().defaultContent();

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
		type(QP.max_scorbx, "2");

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
	@Test(priority = 16)
	public void TCSPR0901216() {

		waitThread(4000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName_upcoming));
		// Assert course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Assert the text::Total Students : Assert the total student count is 2
		waitThread(2000);
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");

	}

	/*
	 * To perform the save and next functionaity from peer review page and verify
	 * the schedule page details
	 */
	@Test(priority = 17)
	public void TCSPR0901217() {

		type(pr.PRreward_txtbox, "50");
		waitThread(3000);

		// Click Save&Next button
		click(QP.savenext_btn);
		waitThread(4000);

		// Assert the peer schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");
		waitThread(3000);

		// Select test start date as tomorrow's date
		click(pr.assessmentopendate_txtbx);
		waitThread(1000);
		Doubleclick(pr.calanderdate_val);
		waitThread(3000);

		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);

		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");
		waitThread(2000);

	}

	/*
	 * To perform Assessment publish functionality and check the details on the
	 * publish popup
	 */
	@Test(priority = 18)
	public void TCSPR0901218() {

		// click on Release Button
		click(sb.btnrelease);

		waitThread(2000);

		// Assert button Back to Menu
		Assert.assertTrue(isElementPresent(tts.back_to_menubutton), "Back to menu button not present");

	}

	/*
	 * To check the back to menu button functionality and check the created
	 * assessment visible on the current assessment tab
	 */
	@Test(priority = 19)
	public void TCSPR0901219() {

		waitThread(4000);
		// click on Back To Menu Button
		click(natb.btnbacktomenu);

		waitThread(2000);

		// Assert the Current Assessment is selected
		Assert.assertEquals(getAttribute(ap.currentassess_tab, "aria-selected"), "true");

		// search assessment
		type(tp.search_box, AssessmentName_upcoming);
		waitThread(5000);

		// Assert the new assessment card visible
		Assert.assertTrue(isElementPresent(tp.newcard), " new assessment card not visible");
	}

	public String AssessmentName_Draft;

	/*
	 * To create an assessment and draft it
	 */
	@Test(priority = 20)
	public void TCSPR0901220() {

		// click on create new assessment button
		click(ba.btn_createnewassessment);
		waitThread(3000);

		// To verify the wizard label
		Assert.assertEquals(getText(ba.Wizardlbl_basicdetails), "Basic Details");

		// To verify the wizard label is selected
		Assert.assertEquals(getAttribute(ba.Basicdetailswizard, "aria-selected"), "true");

		// To click on course dropdown
		click(ba.dd_course);

		// select latest added course
		click(ba.ddcoursename1);

		// Type new assessment name
		AssessmentName_Draft = "Assessment Name Draft" + generateRandomNumber().trim();

		waitThread(2000);
		click(ba.Assessmenttxtbx);
		waitThread(2000);

		// Type assessment name
		driver.findElement(By.id("assessmentName")).sendKeys(AssessmentName_Draft);
		waitThread(2000);

		// Click on save and next button and verify the toasters
		click(ba.btnsaveandexit);
		waitFor(ba.toaster);

		Assert.assertEquals(getText(ba.toaster), "Saved successfully");
		click(ba.toasterclosebtn);
		waitThread(1000);
		Assert.assertEquals(getAttribute(sb.tabcurrectassessment, "aria-selected"), "true");

		// click on draft tab
		click(sb.tabdraft);
		waitThread(4000);

		// *Assert the assessment name visible
		Assert.assertEquals(getText(ba.draftassessmentname), AssessmentName_Draft);
	}

	/*
	 * To perform logout functionality on the teacher profile To perform Login
	 * functionality of student1 profile and check the Assessment card To begin the
	 * test & check the labels of test window
	 */
	@Test(priority = 21)
	public void TCSPR0901221() throws InterruptedException {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
		waitThread(1000);

		// Login as student
		lg.login1(Emailstudent1, password);
		waitThread(3000);

		// Assert the Assessments tab is selected
		Assert.assertTrue(getAttribute(QP.Assessmenttab, "class").contains("active"));

		// Click on search box
		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName_ongoing);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// click begin test
		TimeUnit.SECONDS.sleep(30);
		click(sa.begintest_btn);
		waitThread(6000);

		// Assert the Assessment name
		Assert.assertEquals(getText(tsw.test_window_assess_name), AssessmentName_ongoing);
	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 22)
	public void TCSPR0901222() {
		// Enter Answer
		SwitchFrame("answer_ifr");
		waitThread(1000);
		type(an.ansplaceholder, "Answer 1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Click on Save button
		click(tsw.save_btn_test);
		waitThread(1000);

	}

	/*
	 * To perform assessment submit functionality on the student profile
	 */
	@Test(priority = 23)
	public void TCSPR0901223() {
		// Click on Submit button
		click(tsw.submit_btn);
		waitThread(1000);

		// Assert the confirmation popup visible
		Assert.assertTrue(isDisplayed(tsw.confir_popup), "popup not visible");

		// Click on Submit button on popup
		waitThread(1000);
		click(tsw.submit_confi);

		waitThread(2000);
		// click back to Assessments
		click(tsw.backtoassess_btn);

		// Assert the Current Assessment tab is selected
		waitThread(2000);
		Assert.assertTrue(getAttribute(sd.current_assessment_tab, "class").contains("p-highlight"));
	}

	/*
	 * To check the account delete popup text of student
	 */
	@Test(priority = 24)
	public void TCSPR0901224() {

		waitThread(2000);
		// click navigation dropdown
		click(as.nav_drop2);
		waitThread(2000);

		// click account settings button
		click(as.accnt_sett1);
		waitThread(2000);

		// Assert the textbox Email
		Assert.assertTrue(isElementPresent(sd.stud_email_txtbx), "Student email textbox not present");

		// *Assert the student Email Address on the page
		Assert.assertEquals(getValue(sd.stud_email), Emailstudent1);

		// Click on Delete Account button
		click(as.delete_button4);
		waitThread(2000);

		// Assert the popup heading :Account Deletion:student Email
		Assert.assertEquals(getText(as.alrt_label1), "Account Deletion: " + Emailstudent1);

		// Assert the popup label
		/*
		 * Are you sure that you want to permanently delete this account?
		 * 
		 * Note: You currently have -
		 * 
		 * {1.} active courses {1.} ongoing assessments
		 */

		Assert.assertEquals(getText(as.alrt_label2), "Are you sure that you want to permanently delete this account?\n"
				+ "Note: You currently have -\n" + "* 1 active course\n" + "* 2 ongoing assessments");

		// Assert no draft assessment details visible for students
		Assert.assertFalse(getText(as.alrt_label2).contains("draft"));

		// click No button in popup
		click(as.alrt_nobutton);
		waitThread(2000);

		// Assert the popup not visible on the page
		Assert.assertFalse(isElementPresent(as.popbox_1), "popup visible on the page");

	}

	/*
	 * To perform logout functionality on the Student 1 profile
	 */
	@Test(priority = 25)
	public void TCSPR0901225() {
		// Click on Logout button
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
		waitThread(1000);
	}

	/*
	 * Login as Teacher and Reschedule the Test due and peer review start date To
	 * perform Login functionality of student 1 profile and check the Assessment
	 * card
	 */
	@Test(priority = 26)
	public void TCSPR0901226() throws InterruptedException {
		// login as teacher
		lg.login1(Emailteacher, password);
		waitThread(4000);

		// ***Perform Reschedule date functionality

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(5000);

		// Search The Assessment Name
		type(sca.teacherassessmentsearchbox, AssessmentName_ongoing);
		waitThread(1000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(3000);

		// Click menu button
		click(rd.threedot_btn);
		Assert.assertTrue(isElementPresent(rd.reschedulemenu), "Reschedule Dates menu not present");

		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(2000);
		// Assert the Reschedule popup visible
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");
		click(rd.assessmentduedate_txtbx);

		// To select Todays Date
		cm.ClickTodaysDate();

		waitThread(1000);
		click(rd.peerreviewopendate_txtbx);
		waitThread(1000);
		// To select Todays date
		// cm.ClickTodaysDate_PeerReview();
		Calendar cal = Calendar.getInstance();
		int monthNumber2 = cal.get(Calendar.MONTH);
		int Day = cal.get(Calendar.DAY_OF_MONTH);
		int monthNumber = monthNumber2 + 1;
		String monthname = Month.of(monthNumber).name();
		waitThread(2000);
		String Dropmonth = DropselectedValue("select.p-datepicker-month.ng-star-inserted");

		if (monthname.equals(Dropmonth.toUpperCase())) {

			if (Day < 15) {

				Doubleclick("//td[contains(@class,'p-datepicker-today')]");
				waitThread(4000);
			} else {
				click("//span[contains(text(),'Su')]");
				click("//span[contains(text(),'Mo')]");
				Actions action = new Actions(driver);
				action.sendKeys(Keys.PAGE_DOWN).build().perform();
				// action.sendKeys(Keys.PAGE_DOWN).build().perform();
				waitThread(2000);
				Doubleclick("//td[contains(@class,'p-datepicker-today')]");
				waitThread(4000);

			}
		} else {

			click("button.p-datepicker-prev.p-link.p-ripple.ng-star-inserted > span");
			waitThread(3000);
			click("//span[contains(text(),'Su')]");
			click("//span[contains(text(),'Mo')]");
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			// action.sendKeys(Keys.PAGE_DOWN).build().perform();
			waitThread(4000);
			Doubleclick("//td[contains(@class,'p-datepicker-today')]");
			waitThread(4000);
		}

		// click on Apply changes button
		click(rd.Applychangesbtn);

		waitFor(QP.toaster);

		// Assert a toaster Changes applied
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		click(QP.toasterclosebtn);

		waitThread(5000);
		// Assert popup not visible
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");

		// Teacher logout
		rs.Logout();

		// login as Student 1
		lg.login1(Emailstudent1, password);

		waitThread(3000);

		// Click Assessment tab
		click(QP.Assessmenttab);

		// Click on search box
		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName_ongoing);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// Wait till peer review active
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(50);

		// Click Begin Review
		click(st1.begintest_btn);
		waitThread(2000);

		// Assert the No answer popup visible
		Assert.assertTrue(isDisplayed(sd.no_answerpopup), "No Answer popup not visible");

		// click on Submit button
		click(sd.submit_btn);
		waitThread(3000);

		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(sd.no_answerpopup), "No Answer popup  visible");

	}

	/*
	 * To perform Login functionality of student 2 profile and check the Assessment
	 * card
	 */
	@Test(priority = 27)
	public void TCSPR0901227() {
		// Student 1 Logout
		rs.Logout();

		// login as Student 2
		lg.login1(Emailstudent2, password);

		waitThread(3000);

		// Click Assessment tab
		click(QP.Assessmenttab);

		// Click on search box
		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName_ongoing);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// Click Begin Review
		click(st1.begintest_btn);
		waitThread(2000);

		// Assert the question 1 is select on the wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));
	}

	/*
	 * To perfrom review for Question 1 functionality To perform assessment submit
	 * functionality on the student profile To perform logout functionality on the
	 * Student 2 profile
	 */
	@Test(priority = 28)
	public void TCSPR0901228() {

		waitThread(2000);
		// Type score for student 2
		type(prp.scorestud1, "1");
		waitThread(1000);

		// click on save button
		click(prp.reviewbtnsave);
		waitThread(1000);

		// click submit button
		click(ms.submit_btn);
		waitThread(1000);
		Assert.assertTrue(isDisplayed(prp.confir_popup), "popup not visible");
		waitThread(1000);

		click(prp.submit_confi);
		waitThread(2000);

		// Click on Back to Assessment
		click(prp.reviewbactoassessmentbtn);

		// Assert the Current Assessment tab is selected
		waitThread(3000);
		Assert.assertTrue(getAttribute(sd.current_assessment_tab, "class").contains("p-highlight"));

		// Student 1 Logout
		rs.Logout();

	}

	/*
	 * Perform teacher login and reschedule the peer review and result date
	 */
	@Test(priority = 29)
	public void TCSPR0901229() throws InterruptedException {
		// Login to Teacher profile
		cm.login(Emailteacher, cm.Password);

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(5000);

		// Search The Assessment Name
		type(sca.teacherassessmentsearchbox, AssessmentName_ongoing);
		waitThread(1000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(3000);

		// Click menu button
		click(rd.threedot_btn);
		Assert.assertTrue(isElementPresent(rd.reschedulemenu), "Reschedule Dates menu not present");

		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(2000);
		// Assert the Reschedule popup visible
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");

		// Set Peer review due date & Result date as Todays date
		waitThread(2000);
		Doubleclick(rd.peerreviewduedate_txtbx);

		waitThread(2000);
		cm.ClickTodaysDate();

		waitThread(2000);
		Doubleclick(rd.resultpublishdate_txtbx);

		waitThread(2000);
		cm.ClickTodaysDate();

		waitThread(2000);
		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitThread(5000);

		// wait for 10 min
		TimeUnit.MINUTES.sleep(2);
		TimeUnit.SECONDS.sleep(50);

		// logout functionality
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check the account delete popup text of student
	 */
	@Test(priority = 30)
	public void TCSPR0901230() {

		// login as Student 1
		lg.login1(Emailstudent1, password);
		waitThread(3000);

		waitThread(2000);
		// click navigation dropdown
		click(as.nav_drop2);
		waitThread(2000);

		// click account settings button
		click(as.accnt_sett1);
		waitThread(2000);

		// Assert the textbox Email
		Assert.assertTrue(isElementPresent(sd.stud_email_txtbx), "Student email textbox not present");

		// *Assert the student Email Address on the page
		Assert.assertEquals(getValue(sd.stud_email), Emailstudent1);

		// Click on Delete Account button
		click(as.delete_button4);
		waitThread(2000);

		// Assert the popup heading :Account Deletion:student Email
		Assert.assertEquals(getText(as.alrt_label1), "Account Deletion: " + Emailstudent1);
		waitThread(2000);

		// Assert the popup label
		/*
		 * Are you sure that you want to permanently delete this account? Note: You
		 * currently have - * 1 active course * 2 ongoing assessments
		 */

		waitThread(2000);
		Assert.assertEquals(getText(as.alrt_label2), "Are you sure that you want to permanently delete this account?\n"
				+ "Note: You currently have -\n" + "* 1 active course\n" + "* 1 ongoing assessment");

		// click on Yes button
		click(as.alrt_yesbutton);
		waitThread(3000);

		// Assert the popup not visible on the page
		Assert.assertFalse(isElementPresent(as.popbox_1), "popup visible on the page");

	}

	/*
	 * Login as teacher and check the student count on the course landing page
	 * Delete student 2 account
	 */
	@Test(priority = 31)
	public void TCSPR0901231() {

		// Teacher login
		waitThread(2000);
		lg.login(Emailteacher, password);
		waitThread(2000);

		// Assert the enrolled student count is 1
		Assert.assertEquals(getText(sd.enrolled_count), "1");

		// Delete teacher account
		cm.DeleteAccount();
		waitThread(2000);

		// Click on login button
		click(lg.LoginBtn_1);
		waitThread(2000);

		// login as student2
		lg.login1(Emailstudent2, password);
		waitThread(3000);

		// Delete student 2 account
		cm.DeleteAccount();
		waitThread(2000);

	}

}
