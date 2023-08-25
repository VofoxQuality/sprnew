package PeerReviewWindowofIndividualStudentTest;

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

import CommonFunctionalities.Test.CommonFileTest;
import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import CreateNewAssessment.Pages.AssessmentPublishPopupPage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.ClickableRubricPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CreateNewAssessment.Pages.SummaryQuestionsPage;
import CurrentAssessmentsforStudents.Pages.StudentPeerReviewPage;
import CurrentAssessmentsforStudents.Pages.StudentTestSectionPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import NewAssessmentOfTeacherPage.TeacherResultSectionPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import PeerReviewWindowofIndividualStudentPages.ModifyReviewWizardPanelPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowWizardPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import TestWindowOfIndividualStudent.AnswerWindowPage;
import TestWindowOfIndividualStudent.ModifySubmittedAnswersPage;
import TestWindowOfIndividualStudent.ModifyWizardSectionPage;
import TestWindowOfIndividualStudent.TestWindowWizardPage;

public class ModifyReviewWindowTest extends basePage {
	SignUpPage sp = new SignUpPage();
	LoginPage lg = new LoginPage();
	SignUpTest st = new SignUpTest();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	Databaseconnection dc = new Databaseconnection();
	CourseRosterPage cr = new CourseRosterPage();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	EncryptedText et = new EncryptedText();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	ClickableRubricPage ck = new ClickableRubricPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	SchedulePageBasicsPage sb1 = new SchedulePageBasicsPage();
	SummaryBasicsPage sb = new SummaryBasicsPage();
	SummaryQuestionsPage sq = new SummaryQuestionsPage();
	AssessmentPublishPopupPage ap = new AssessmentPublishPopupPage();
	TeacherResultSectionPage tr = new TeacherResultSectionPage();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	TeacherPeerReviewSectionPage tp = new TeacherPeerReviewSectionPage();
	TeacherTestSectionPage tts = new TeacherTestSectionPage();
	StudentTestSectionPage st1 = new StudentTestSectionPage();
	StudentPeerReviewPage sp1 = new StudentPeerReviewPage();
	TestWindowWizardPage tsw = new TestWindowWizardPage();
	AnswerWindowPage an = new AnswerWindowPage();
	PeerReviewWindowWizardPage prw = new PeerReviewWindowWizardPage();
	ModifySubmittedAnswersPage ma = new ModifySubmittedAnswersPage();
	ModifyReviewWizardPanelPage mrw = new ModifyReviewWizardPanelPage();
	CommonMethods cm = new CommonMethods();
	ModifyWizardSectionPage ms = new ModifyWizardSectionPage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	CommonFileTest cmt = new CommonFileTest();

	public String AssessmentName;
	public String NewAssessmentName;
	public String newAssessmentName;
	public String newAssessmentNameone;
	public String quest_count;
	public String Emailteacher;
	public String teacherotp;
	public String studentotp;
	public String CourseNamenew;
	public String CourseID1;
	public String quest1;
	public String Studentfirstname;
	public String Studentlastname;
	public String Studentname;
	public String Studentfirstname2;
	public String Studentlastname2;
	public String Studentname2;
	public String Studentfirstname3;
	public String Studentlastname3;
	public String Studentname3;
	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	public String Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
	public String Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";
	public String Emailstudent3 = "student3" + generateRandomNumber().trim() + "@gmail.com";

	public String CourseName3;
	public String CourseID3;

	/*
	 * To perform Login functionality
	 */
	@Test(priority = 1)
	public void TCSPR1300601() throws SQLException {

		Emailteacher = cmt.SignUpTeacher();

		// To catch OTP from sending Resource
		cmt.OtpFetch();

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	/*
	 * To create new course
	 */
	@Test(priority = 2)
	public void TCSPR1300602() throws SQLException {

		CourseName3 = "Course Name" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID3 = (getText(cn.course_Id));
		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent3 = "student3" + generateRandomNumber().trim() + "@gmail.com";

		// Invite students to course
		cm.Invitestudentstocourse_3(CourseName3, Emailstudent1, Emailstudent2, Emailstudent3);

	}
	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 3)
	public void TCSPR1300603() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on first student 's profile
	 * and accept course request-Read the student name
	 */
	@Test(priority = 4)
	public void TCSPR1300604() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent1, CourseID3);

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
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName3.trim());

	}
	/*
	 * To Accept course and perform logout functionality on the student profile
	 */

	@Test(priority = 5)
	public void TCSPR1300605() {

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

		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName3.trim());
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
	public void TCSPR1300606() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent2, CourseID3);

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
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName3.trim());

	}
	/*
	 * To Accept course and perform logout functionality on the student profile
	 */

	@Test(priority = 7)
	public void TCSPR1300607() {

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
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName3.trim());
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	@Test(priority = 8)
	public void TCSPR1300608() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent3, CourseID3);

		String encText = et.EncryptCode(studentinviteid);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname3 = "Clara";
		Studentlastname3 = "April";
		Studentname3 = Studentfirstname3 + " " + Studentlastname3;
		waitThread(3000);
		// click first name
		click(sp.txtbxFirstN);

		// type first name
		type(sp.txtbxFirstN, Studentfirstname3);

		// click last name
		click(sp.txtbxLastN);

		// type last name
		type(sp.txtbxLastN, Studentlastname3);

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
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName3.trim());

	}

	/*
	 * To Accept course and perform logout functionality on the student profile
	 */

	@Test(priority = 9)
	public void TCSPR1300609() {

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
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName3.trim());
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
	@Test(priority = 10)
	public void TCSPR1300610() {
		SoftAssert softAssert1 = new SoftAssert();
		lg.login1(Emailteacher, password);
		waitThread(4000);
		// click on Assessment tab
		click(ba.Assessmenttab);

		waitThread(12000);
		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		waitThread(2000);
		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		softAssert1.assertEquals(getText(ba.ddcoursename1), CourseName3.trim(),
				"course name not visible on the dropdown");

		click(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentName = "Assessment" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentName);

		waitThread(2000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(1000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(3000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), AssessmentName);

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID3 + ", " + CourseName3.trim());

		softAssert1.assertAll();
	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 11)
	public void TCSPR1300611() {

		waitThread(3000);

		// Type Question 1
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);

		quest1 = "Question1";
		waitThread(1000);
		type(QP.Quest_box, quest1);

		// Assert the question content on the question editor
		Assert.assertEquals(getText(QP.Quest_box), quest1);
		driver.switchTo().defaultContent();

		// Type data in Standard Rubric box
		driver.switchTo().frame("rubric_ifr");
		waitThread(2000);
		type(QP.std_rub_bx, "R1");

		// Assert the rubic content on the textbox
		Assert.assertEquals(getText(QP.std_rub_bx), "R1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, "5");

		waitThread(2000);
		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");

		click(QP.toasterclosebtn);
		// Click on +button
		click(an.add_quest_btn);
		waitThread(1000);
		waitThread(3000);

		// Type Question 2
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);

		waitThread(1000);
		type(QP.Quest_box, "Question2");

		// Assert the question content on the question editor
		Assert.assertEquals(getText(QP.Quest_box), "Question2");
		driver.switchTo().defaultContent();
		waitThread(1000);
		click(QP.click_radio);
		waitThread(2000);
		// Add 3 columns
		Doubleclick(QP.add_column);
		click(QP.add_column);

		// Assert the clickable rubric radio button is Selected
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		// Type criteria1
		type(ck.crit1_bx, "CR1");

		// Type Score for columns
		type(ck.scre_col1, "2");
		type(ck.scre_col2, "3");
		type(ck.scre_col3, "4");

		// Type conditions for columns
		driver.switchTo().frame("editorFieldRubric_00_ifr");
		type(mrw.cond_00, "Condition1");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("editorFieldRubric_01_ifr");
		type(mrw.cond_01, "Condition2");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("editorFieldRubric_02_ifr");
		type(mrw.cond_02, "Condition3");
		driver.switchTo().defaultContent();

		// Add 2 rows
		click(QP.add_row);
		click(QP.add_row);

		// Enter criteria 2 , conditions&scores for row2
		type(ck.crit2_bx, "CR2");

		type(ck.scre_rw1, "1");
		type(ck.score_r22, "2");
		type(ck.score_r23, "4");

		driver.switchTo().frame("editorFieldRubric_10_ifr");
		type(mrw.cond_10, "Condition10");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("editorFieldRubric_11_ifr");
		type(mrw.cond_11, "Condition11");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("editorFieldRubric_12_ifr");
		type(mrw.cond_12, "Condition12");
		driver.switchTo().defaultContent();

		// Enter criteria 3 , conditions&scores for row3
		type(ck.crit3_bx, "CR3");

		type(ck.score_r30, "0");
		type(ck.score_r31, "1");
		type(ck.score_r32, "2");

		driver.switchTo().frame("editorFieldRubric_20_ifr");
		type(mrw.cond_20, "Condition20");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("editorFieldRubric_21_ifr");
		type(mrw.cond_21, "Condition21");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("editorFieldRubric_22_ifr");
		type(mrw.cond_22, "Condition22");
		driver.switchTo().defaultContent();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, -250);");

		MouseHover(QP.save);
		waitThread(4000);
		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert toaster Question 2 Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully");
		click(QP.toasterclosebtn);

	}

	/*
	 * To add more questions to questions page
	 *
	 **/
	@Test(priority = 12)
	public void TCSPR1300612() {
		MouseHover(QP.save);

		waitThread(3000);
		// Click add question
		click(rd.add_quest_btn);

		waitThread(3000);

		// Type Question 3
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);

		waitThread(1000);
		type(QP.Quest_box, "Question3");
		driver.switchTo().defaultContent();

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Type data in Standard Rubric box
		driver.switchTo().frame("rubric_ifr");
		waitThread(2000);
		type(QP.std_rub_bx, "R3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, "6");

		waitThread(2000);
		// Click Save button
		click(QP.save);
		// Click on +button
		click(an.add_quest_btn);
		waitThread(1000);
		waitThread(3000);


		// Type Question 4
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);

		waitThread(1000);
		type(QP.Quest_box, "Question4");
		driver.switchTo().defaultContent();

		waitThread(3000);

		click(QP.click_radio);

		waitThread(2000);
		// Add 3 columns
		click(QP.add_column);
		click(QP.add_column);
		click(QP.add_column);

		// Assert the clickable rubric radio button is Selected
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		// Type criteria1
		type(ck.crit1_bx, "CR1");

		// Type Score for columns
		type(ck.scre_col1, "2");
		type(ck.scre_col2, "3");
		type(ck.scre_col3, "4");

		// Type conditions for columns
		driver.switchTo().frame("editorFieldRubric_00_ifr");
		type(mrw.cond_00, "Condition1");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("editorFieldRubric_01_ifr");
		type(mrw.cond_01, "Condition2");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("editorFieldRubric_02_ifr");
		type(mrw.cond_02, "Condition3");
		driver.switchTo().defaultContent();

		// Add 2 rows
		click(QP.add_row);
		click(QP.add_row);

		// Enter criteria 2 , conditions&scores for row2
		type(ck.crit2_bx, "CR2");

		type(ck.scre_rw1, "1");
		type(ck.score_r22, "2");
		type(ck.score_r23, "4");

		driver.switchTo().frame("editorFieldRubric_10_ifr");
		type(mrw.cond_10, "Condition10");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("editorFieldRubric_11_ifr");
		type(mrw.cond_11, "Condition11");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("editorFieldRubric_12_ifr");
		type(mrw.cond_12, "Condition12");
		driver.switchTo().defaultContent();

		// Enter criteria 3 , conditions&scores for row3
		type(ck.crit3_bx, "CR3");

		type(ck.score_r30, "0");
		type(ck.score_r31, "1");
		type(ck.score_r32, "2");

		driver.switchTo().frame("editorFieldRubric_20_ifr");
		type(mrw.cond_20, "Condition20");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("editorFieldRubric_21_ifr");
		type(mrw.cond_21, "Condition21");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("editorFieldRubric_22_ifr");
		type(mrw.cond_22, "Condition22");
		driver.switchTo().defaultContent();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0, -250);");
		waitThread(2000);

		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 4 Saved successfully");
		click(QP.toasterclosebtn);

		waitThread(1000);
		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	/*
	 * To verify the details on the peer review page
	 */
	@Test(priority = 13)
	public void TCSPR1300613() {

		waitThread(3000);

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID3));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName3.trim()));

		// Select Answer Sheets Per Student =2
		click(prw.reviewans_sheetdropdwn);
		waitThread(1000);
		click(prw.reviewssheet_count);

		// Enter peer review Reward score 100
		type(prw.peer_reward_scorebx, "100");

	}

	/*
	 * To perform the save and next functionaity from peer review page and
	 * verify the schedule page details
	 */
	@Test(priority = 14)
	public void TCSPR1300614() {

		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(2000);
		Assert.assertEquals(getAttribute(sb1.schedule_wizard, "aria-expanded"), "true");

		// Assert the text "Select schedules for "
		Assert.assertEquals(getText(sb1.selectstu_lbl), "Select Schedules for");

		waitThread(3000);

	}

	/*
	 * To verify the details on the Summary page & publish the Assessment
	 */
	@Test(priority = 15)
	public void TCSPR1300615() {

		waitThread(3000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");

		// Assert the Text "Questions Summary"
		Assert.assertEquals(getText(sq.Summary_quest), "Questions Summary");

		quest_count = getText(sq.total_questcount);
		// Assert the total Questions count
		Assert.assertEquals(getText(sq.total_questcount), quest_count);

	}

	/*
	 * To perform Assessment publish functionality
	 */
	@Test(priority = 16)
	public void TCSPR1300616() {
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

	}

	/*
	 * To check the published Assessment card
	 */
	@Test(priority = 17)
	public void TCSPR1300617() {
		// Click Back to Menu
		click(tts.back_to_menubutton);

		waitThread(3000);

		// Assert the text "Assessments "
		Assert.assertEquals(getText(ba.lbl_assessment), "Assessments");

		// search newly created assessment
		type(st1.assess_searchbx, AssessmentName);

		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");

		// Assert the Assessment name visible
		Assert.assertEquals(getText(st1.teach_assess_name), AssessmentName);

	}

	/*
	 * To check the test section of Assessment card
	 */
	@Test(priority = 18)
	public void TCSPR1300618() {

		waitThread(2000);
		// Assert the the "Test Pending "
		// Assert.assertEquals(getText(tp.teststs_lbl), "Active");

		// Assert the text "Students completed"
		Assert.assertEquals(getText(st1.stud_compl_txt), "Students Submitted");
	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 19)
	public void TCSPR1300619() {
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform Login functionality of student1 profile and check the
	 * Assessment card
	 */
	@Test(priority = 20)
	public void TCSPR1300620() {

		// login as Student1
		lg.login1(Emailstudent1, password);
		waitThread(9000);

		// verify heading label current Assessments
		Assert.assertEquals(getText(QP.current_assesslabel), "Current Assessments");

		waitThread(5000);

		Doubleclick(st1.stud_searchbx);
		waitThread(3000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(8000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		waitThread(2000);
		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(st1.Assess_name_card), AssessmentName);

	}

	/*
	 * To Begin Test &add answers to questions by Student1
	 */
	@Test(priority = 21)
	public void TCSPR1300621() throws InterruptedException {
		// wait for 1.5 Min
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(50);
		// Assert the test status as active
		Assert.assertEquals(getText(tp.teststs_lbl), "Active");

		// Assert the button begin test
		Assert.assertTrue(isDisplayed(st1.begintest_btn), "Begin test not present");
		Assert.assertEquals(getText(st1.begintest_btn), "Begin Test");

		waitThread(2000);
		// Click Begin Test
		click(st1.begintest_btn);

		waitThread(3000);
		// Assert the total Questions, Total score
		Assert.assertTrue(getText(tsw.questions_count).contains("Total Questions"));
		Assert.assertTrue(getText(tsw.total_score).contains("Total Score"));

		// Assert the first question is highlighted on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));
		Assert.assertEquals(getText(tsw.quest_1_wizard), "1");

		// Enter Answer1
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer1");

		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(1000);
		// Assert first Question is answered
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("complete"));
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);
		// Enter Answer2
		waitThread(2000);
		type(tsw.answer_bx, "Answer2");

		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(3000);
		// Assert Second Question is answered
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("complete"));

		// Enter Answer3
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer3");

		driver.switchTo().defaultContent();
		waitThread(2000);

		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(1000);
		// Assert Third Question is answered
		// Assert.assertTrue(getAttribute(tsw.quest_3_wizard,
		// "class").contains("complete"));

		// Enter Answer4
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer4");

		driver.switchTo().defaultContent();

		// Assert Submit button
		Assert.assertTrue(isDisplayed(tsw.submit_btn), "Submit button not present");

	}

	/*
	 * To submit the Assessment and logout from Student1 profile
	 */
	@Test(priority = 22)
	public void TCSPR1300622() {

		waitThread(2000);
		// Click Submit button
		click(tsw.submit_btn);

		waitThread(1000);
		// Assert confirmation popup
		Assert.assertTrue(isDisplayed(tsw.confir_popup), "popup not visible");

		// Click submit button on popup
		click(tsw.submit_confi);

		// Assert toaster "Assessment Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		waitThread(3000);
		// click back to Assessments
		click(tsw.backtoassess_btn);

		waitThread(4000);
		// Assert the current Assessments
		Assert.assertEquals(getText(prw.current_assess_label), "Current Assessments");

		waitThread(3000);
		// Perform logout from Student1
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To Perform Login by Student2 and to Begin Test
	 */
	@Test(priority = 23)
	public void TCSPR1300623() {
		// login as Student2
		lg.login1(Emailstudent2, password);

		waitThread(9000);
		// verify heading label current Assessments
		Assert.assertEquals(getText(QP.current_assesslabel), "Current Assessments");

		waitThread(3000);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(st1.Assess_name_card), AssessmentName);

		waitThread(2000);
		// Click Begin Test
		click(st1.begintest_btn);

		waitThread(3000);
		// Assert the first question is highlighted on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));
		Assert.assertEquals(getText(tsw.quest_1_wizard), "1");

	}

	/*
	 * To Add answers to first Question and 2nd Question
	 */
	@Test(priority = 24)
	public void TCSPR1300624() {
		// Enter Answer1
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer1_Student2");

		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(1000);
		// Assert first Question is answered
		// Assert.assertTrue(getAttribute(tsw.quest_1_wizard2,
		// "class").contains("complete"));

		// Enter Answer2
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer2_Student1");

		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(1000);
		// Assert Second Question is answered
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("complete"));
		waitThread(2000);

		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(1000);
		// Assert Third Question is unanswered
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("visitednotattended"));

	}

	/*
	 * To Submit the Assessment and logout from Student2 profile
	 */
	@Test(priority = 25)
	public void TCSPR1300625() {
		waitThread(1000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(1000);

		Assert.assertTrue(isDisplayed(tsw.confir_popup), "popup not visible");

		// Assert the text "You have 2 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(tsw.confirmation_txt), "You have 2 skipped question(s)! Proceed to submit?");

		waitThread(1000);
		// Click submit button on popup
		click(tsw.submit_confi);

		// Assert toaster "Assessment Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		waitThread(2000);
		// click back to Assessments
		click(tsw.backtoassess_btn);

		waitThread(4000);
		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		waitThread(3000);
		// Assert the Questions answered count 2/4
		Assert.assertEquals(getText(tsw.ans_count), "2/4");

	}

	/*
	 * To Perform Login by Student3 and to Begin Test
	 */
	@Test(priority = 26)
	public void TCSPR1300626() {
		// Perform logout from Student2
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
		waitThread(2000);
		// Perform login by Student3
		lg.login1(Emailstudent3, password);

		waitThread(9000);
		// verify heading label current Assessments
		Assert.assertEquals(getText(QP.current_assesslabel), "Current Assessments");

		waitThread(3000);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(st1.Assess_name_card), AssessmentName);

		waitThread(2000);
		// Click Begin Test
		click(st1.begintest_btn);

		waitThread(4000);
		// Assert the first question is highlighted on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));
		Assert.assertEquals(getText(tsw.quest_1_wizard), "1");

	}

	/*
	 * To Add answers to first Question and 4th Question
	 */
	@Test(priority = 27)
	public void TCSPR1300627() {

		// Enter Answer1
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer1_Student1");

		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(2000);
		// Assert first Question is answered
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("complete"));

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(1000);
		// Assert Second Question is unanswered
		// Assert.assertTrue(getAttribute(tsw.quest_2_wizard,
		// "class").contains("visitednotattended"));

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(1000);
		// Enter Answer4
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer4_Student2");

		driver.switchTo().defaultContent();

		waitThread(1000);
		// Assert Third Question is unanswered
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("visitednotattended"));

	}

	/*
	 * To Submit the Assessment and wait until peer review active
	 */
	@Test(priority = 28)
	public void TCSPR1300628() {
		waitThread(2000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(1000);

		Assert.assertTrue(isDisplayed(tsw.confir_popup), "popup not visible");

		// Assert the text "You have 2 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(tsw.confirmation_txt), "You have 2 skipped question(s)! Proceed to submit?");

		waitThread(1000);
		// Click submit button on popup
		click(tsw.submit_confi);

		// Assert toaster "Assessment Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		// click back to Assessments
		click(tsw.backtoassess_btn);

		waitThread(3000);
		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the Questions answered count 2/4
		Assert.assertEquals(getText(tsw.ans_count), "2/4");

		// Perform logout from Student3
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To login Teacher profile and Reschedule the dates to make peer review
	 * active
	 */
	@Test(priority = 29)
	public void TCSPR1300629() {

		// Login to Teacher profile
		lg.login1(Emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// Click Assessment tab
		click(QP.teach_assesstab);

		waitThread(12000);

		// search assessment
		type(tp.search_box, AssessmentName);
		waitThread(1000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(tp.newcard), "Published Assessment card not visible");

		waitThread(3000);
		// click menu button
		click(rd.threedot_btn);

		waitThread(1000);
		// click reschedule dates
		click(rd.reschedulemenu);
		waitThread(1000);

		// Set the test due day to current day
		waitThread(2000);
		Doubleclick(rd.assessmentduedate_txtbx);

		waitThread(2000);
		cm.ClickTodaysDate();

		// Set Peer review open date to Currebt day
		waitThread(2000);
		Doubleclick(rd.peerreviewopendate_txtbx);

		waitThread(2000);
		cm.ClickTodaysDate();

		waitThread(2000);
		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitThread(5000);

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To login Student3 profile and check peer review active
	 */
	@Test(priority = 30)
	public void TCSPR1300630() throws InterruptedException {

		// Login to Student3
		lg.login1(Emailstudent3, password);

		waitThread(9000);
		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		Doubleclick(st1.stud_searchbx);
		waitThread(2000);
		type(st1.stud_searchbx, AssessmentName);
		waitThread(4000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Wait till peer review active
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(50);

		waitThread(3000);
		// Assert Test window closed
		Assert.assertEquals(getText(st1.windowclosd), "Window Closed");

		waitThread(1000);
		// Assert peer review active
		Assert.assertEquals(getText(sp1.reviewpending_lbl), "Active");

	}

	/*
	 * To begin the Review & check the labels of peer review window
	 */
	@Test(priority = 31)
	public void TCSPR1300631() {

		// Assert the Begin Review button
		Assert.assertTrue(isDisplayed(st1.begintest_btn), "Begin Review not present");
		Assert.assertEquals(getText(st1.begintest_btn), "Begin Review");

		// Assert peer review % =0%
		Assert.assertEquals(getText(sp1.zeropercent_card), "0%");

		waitThread(3000);

		// Click Begin Review
		click(st1.begintest_btn);

		waitThread(5000);
		// Assert the Assessment name
		Assert.assertEquals(getText(tsw.test_window_assess_name), AssessmentName);

		waitThread(2000);

		// Enter score for student1
		click(prw.score_bx_stud1);
		type(prw.score_bx_stud1, "2");

		// Assert the time status
		// Assert.assertTrue(getText(tsw.time_status).contains("Peer Review
		// Active for
		// "));

	}

	/*
	 * To check the submit button & confirmation popup of incomplete & skipped
	 * reviews
	 */
	@Test(priority = 32)
	public void TCSPR1300632() {

		waitThread(1000);
		// Assert first question selected on wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));
		Assert.assertEquals(getText(tsw.quest_1_wizard), "1");
		waitThread(2000);

		// Click Save &Next button
		click(QP.savenext_btn);

		waitThread(2000);
		// Assert the first question is incomplete review
		MouseHover(tsw.quest_1_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("complete"));

		waitThread(2000);

		waitThread(4000);
		// Assert label Student One Rubric
		Assert.assertEquals(getText(mrw.stud_one_rub_label), "Student One Rubric");
		ScrollTo_xy_position(0, 250);
		// Click scores on clickable rubric
		waitThread(2000);

		click(mrw.click_row11_stud1);
		click(mrw.click_row22_stud1);
		click(mrw.click_row33_stud1);

		waitThread(2000);

		waitThread(4000);
		// Assert label Student Two Rubric
		Assert.assertEquals(getText(mrw.stud_two_rub_label), "Student Two Rubric");

		// Click scores on clickable rubric
		waitThread(3000);

		ScrollTo_xy_position(0, 300);
		click(mrw.click_row11);
		click(mrw.click_row22);
		click(mrw.click_row33);

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.savenext_btn);

		waitThread(2000);
		MouseHover(tsw.quest_2_wizard);
		// Assert the Second question wizard is Reviewed
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("complete"));

		waitThread(2000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(2000);
		// Assert the text "There are incomplete evaluation/skipped evaluation,
		// do you
		// want to proceed ?"
		waitThread(1000);
		Assert.assertEquals(getText(prw.conf_txt),
				"There are incomplete /skipped question(s), do you want to proceed ?");
		waitThread(1000);

		// Click submit button on popup
		click(prw.conf_submit_btn);

		// Assert toaster "Peer Review Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);

		waitThread(2000);
		// Click back to Assessments
		click(prw.backto_btn);

		waitThread(3000);
		// Assert Current Assessments label
		Assert.assertEquals(getText(mrw.current_assess), "Current Assessments");

	}

	/*
	 * To check the assessment card peer review section & modify peer review
	 * part
	 */
	@Test(priority = 33)
	public void TCSPR1300633() {
		waitThread(2000);
		Doubleclick(st1.stud_searchbx);
		waitThread(3000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the peer review submitted
		Assert.assertEquals(getText(tp.peersts_lbl), "Submitted");

		// Assert the modify review button
		Assert.assertTrue(isDisplayed(st1.begintest_btn), "Modify Review not present");
		Assert.assertEquals(getText(st1.begintest_btn), "Modify Review");

		waitThread(2000);
		// Click modify review
		click(st1.begintest_btn);

		waitThread(4000);

	}

	/*
	 * To Check whether initially saved reviews status are visible on modify
	 * Wizard
	 */
	@Test(priority = 34)
	public void TCSPR1300634() {

		// Assert the first question status is incomplete review
		MouseHover(tsw.quest_1_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("incomplete"));

		// Assert the Second question status is reviewed
		MouseHover(tsw.quest_2_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("complete"));

		// Assert the Third question status not reviewed
		MouseHover(tsw.quest_3_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("visitednotattended"));

		waitThread(2000);

		// Click on 4th question on wizard
		click(tsw.quest_4_wizard);

		waitThread(2000);
		// Assert score box of student1 is empty
		Assert.assertEquals(getValue(prw.score_bx_stud1), "");

		// Assert the score box of student2 is empty
		Assert.assertEquals(getValue(prw.score_bx_stud2), "");

		waitThread(2000);
		// Click on 3rd question on wizard
		click(tsw.quest_3_wizard);

		waitThread(2000);
		// Assert the fourth question status as not reviewed
		MouseHover(tsw.quest_4_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_4_wizard, "class").contains("visitednotattended"));

	}

	/*
	 * To Check whether initially saved reviews datas are visible on modify
	 * window
	 */
	@Test(priority = 35)
	public void TCSPR1300635() {

		waitThread(1000);

		// Assert Third question selected on wizard
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("p-highlight"));
		Assert.assertEquals(getText(tsw.quest_3_wizard), "3");
		waitThread(2000);

		// Assert the score boxes of student1 &student2 are empty
		waitThread(2000);
		// Assert score box of student1 is empty
		Assert.assertEquals(getValue(prw.score_bx_stud1), "");

		// Assert the score box of student2 is empty
		Assert.assertEquals(getValue(prw.score_bx_stud2), "");

		waitThread(2000);
		// Click First question on Wizard
		click(tsw.quest_1_wizard);

		waitThread(2000);
		// Assert the score box of studentOne with added score
		Assert.assertEquals(getValue(prw.score_bx_stud1), "2");

		// Assert the score box of other student empty
		Assert.assertEquals(getValue(prw.score_bx_stud2), "");

		waitThread(2000);
		// Click second question on Wizard
		click(tsw.quest_2_wizard);

		waitThread(4000);

	}

	/*
	 * To check comment box labels, buttons in modify window
	 */
	@Test(priority = 36)
	public void TCSPR1300636() {

		waitThread(4000);
		// Click Third Question on Wizard
		click(tsw.quest_3_wizard);

		// Assert Third question highlighted on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("p-highlight"));

		waitThread(4000);

		ScrollTo_xy_position(0, 300);
		// Click Score box student2
		click(prw.score_bx_stud2);

		// Enter score for student2
		type(prw.score_bx_stud2, "3");

		// Assert the comment box of student2 enabled
		waitThread(2000);
		Assert.assertFalse(getAttribute(prw.comment_bx_stud2, "class").contains("disabled-btn"));

		// Assert placeholder in comment box
		Assert.assertEquals(getAttribute(prw.comment_bx_stud2, "placeholder"), "Click here to enter your comment");

		// Click Comment box of Student2
		waitThread(2000);
		click(prw.comment_bx_stud2);

		waitThread(2000);
		// Assert comment popup visible
		Assert.assertTrue(isElementPresent(prw.comment_popup), "Comment popup not visible");

		waitThread(1000);
		// Assert the placeholder in comment popup
		Assert.assertEquals(getAttribute(prw.txtbx_comment, "placeholder"), "Enter the comment about the answer");

		// Assert the tick button& close buttons of comment box
		Assert.assertTrue(isDisplayed(prw.commentsave_btn), "Comment Save button not present");
		Assert.assertTrue(isDisplayed(prw.commentcancel_btn), "Comment cancel button not present");

		// Assert the validation text "You have 100 words left."
		Assert.assertEquals(getText(prw.comment_val_msg), "You have 100 words left.");

		waitThread(2000);
		// Click cancel button on comment popup
		click(prw.commentcancel_btn);

		waitThread(3000);
		// Assert the comment popup not visible
		Assert.assertFalse(isElementPresent(prw.comment_popup), "Comment popup  visible");
	}

	/*
	 * To check comments adding functionality in modify window
	 */
	@Test(priority = 37)
	public void TCSPR1300637() {

		// Click comment box
		waitThread(1000);
		click(prw.comment_bx_stud2);

		waitThread(2000);
		// Assert comment popup visible
		Assert.assertTrue(isElementPresent(prw.comment_popup), "Comment popup not visible");

		waitThread(1000);
		// Enter comment
		click(prw.txtbx_comment);
		type(prw.txtbx_comment, "Comments");

		waitThread(2000);
		// Click close button
		click(prw.commentcancel_btn);

		waitThread(1000);
		// Assert comment box is empty
		Assert.assertEquals(getValue(prw.comment_bx_stud2), "");

		waitThread(1000);
		// Click comment box
		waitThread(1000);
		click(prw.comment_bx_stud2);

		waitThread(2000);
		// Assert comment popup visible
		Assert.assertTrue(isElementPresent(prw.comment_popup), "Comment popup not visible");

		waitThread(1000);
		// Enter comment
		click(prw.txtbx_comment);
		type(prw.txtbx_comment, "Comments");

		waitThread(2000);
		// Click Submit button
		click(prw.commentsave_btn);

		waitThread(2000);
		// Assert the added comment in comment box
		Assert.assertEquals(getValue(prw.comment_bx_stud2), "Comments");

		waitThread(2000);
		// Click 4th Question on Wizard
		click(tsw.quest_4_wizard);

		waitFor(QP.toaster);
		// Assert toaster "Score Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");

		click(QP.toasterclosebtn);

		waitThread(2000);
		// Click 3rd question on wizard
		click(tsw.quest_3_wizard);

		waitThread(2000);
		// Assert the added comment visible on comment box
		Assert.assertEquals(getValue(prw.comment_bx_stud2), "Comments");

	}

	/*
	 * To check the clickable rubric section in modify review window
	 */
	@Test(priority = 38)
	public void TCSPR1300638() {

		waitThread(2000);
		// Click 4th Question on Wizard
		click(tsw.quest_4_wizard);

		// Assert 4th question highlighted on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_4_wizard, "class").contains("p-highlight"));

		waitThread(2000);
		// Assert answer of student2 visible

		driver.switchTo().frame("answerViewEditor_1_ifr");
		Assert.assertTrue(isElementPresent(prw.ans_bx_stud2), "Answer Box of Student Two not visible");
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Assert label student Two rubric
		Assert.assertEquals(getText(mrw.stud_two_rub_label), "Student Two Rubric");

		ScrollTo_xy_position(0, 300);
		waitThread(2000);
		// Assert the clickable rubric added criterias visible
		Assert.assertEquals(getText(mrw.crit1_stud2), "CR1");
		Assert.assertEquals(getText(mrw.crit2_stud2), "CR2");
		Assert.assertEquals(getText(mrw.crit3_stud2), "CR3");

	}

	/*
	 * To check the Discard changes button functionality in Modify Window
	 */
	@Test(priority = 39)
	public void TCSPR1300639() {

		waitThread(2000);
		// Assert the 4th question highlighted on wizard
		Assert.assertTrue(getAttribute(tsw.quest_4_wizard, "class").contains("p-highlight"));

		// Assert Discard changes button disabled
		Assert.assertTrue(getAttribute(mrw.discard_changes, "class").contains("disabled-btn"));

		// Select scores from clickable rubric
		waitThread(2000);

		click(mrw.click_row11);
		click(mrw.click_row22);
		click(mrw.click_row33);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");
		waitThread(4000);

		// Assert score visible on score box
		Assert.assertEquals(getValue(prw.score_bx_stud2), "6");

		waitThread(4000);
		// Click comment box
		click(prw.comment_bx_stud2);

		// Assert comment popup visible
		waitThread(2000);
		Assert.assertTrue(isElementPresent(prw.comment_popup), "Comment popup of Student Two not visible");

		waitThread(1000);
		// Enter comment
		click(prw.txtbx_comment);
		type(prw.txtbx_comment, "Comments");

		// Click tick button
		click(prw.commentsave_btn);
		waitThread(2000);

		// Assert the added comment in comment box
		Assert.assertEquals(getValue(prw.comment_bx_stud2), "Comments");

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Assert Discard changes button enabled
		Assert.assertFalse(getAttribute(mrw.discard_changes, "class").contains("disabled-btn"));

		waitThread(2000);
		// Click discard changes
		click(mrw.discard_changes);

		// Assert toaster "Changes Discarded"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Changes Discarded");

		click(QP.toasterclosebtn);

		waitThread(2000);
		// Assert the score box & comment box empty
		Assert.assertEquals(getValue(prw.score_bx_stud2), "");
		Assert.assertEquals(getValue(prw.comment_bx_stud2), "");

		// Assert Discard changes button disabled
		Assert.assertTrue(getAttribute(mrw.discard_changes, "class").contains("disabled-btn"));

	}

	/*
	 * To check the Discard button functionality in modify window
	 */
	@Test(priority = 40)
	public void TCSPR1300640() {

		// Assert 4th question highlighted on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_4_wizard, "class").contains("p-highlight"));

		ScrollTo_xy_position(0, 300);
		// Select scores from clickable rubric
		waitThread(2000);

		click(mrw.click_row11);
		click(mrw.click_row22);
		click(mrw.click_row33);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");
		waitThread(3000);

		// Click comment box
		click(prw.comment_bx_stud2);

		// Assert comment popup visible
		waitThread(2000);
		Assert.assertTrue(isElementPresent(prw.comment_popup), "Comment popup of Student Two not visible");

		// Enter comment
		click(prw.txtbx_comment);
		type(prw.txtbx_comment, "Comments");

		// Click tick button
		click(prw.commentsave_btn);
		waitThread(2000);

		// Assert the added comment in comment box
		Assert.assertEquals(getValue(prw.comment_bx_stud2), "Comments");

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");
		waitThread(1000);

		// Click Third Question on Wizard
		click(tsw.quest_3_wizard);

		waitThread(2000);
		// Assert Third question status as reviewed
		MouseHover(tsw.quest_3_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("complete"));

		// Assert scores visible on score boxes
		Assert.assertEquals(getValue(prw.score_bx_stud2), "3");

		// Assert 4th question status as reviewed
		MouseHover(tsw.quest_4_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_4_wizard, "class").contains("complete"));

		waitThread(2000);
		// Click 4th Question on Wizard
		click(tsw.quest_4_wizard);

		waitThread(2000);
		// Assert scores visible on score box
		Assert.assertEquals(getValue(prw.score_bx_stud2), "6");

	}

	/*
	 * To check the Discard button functionality in modify window
	 */
	@Test(priority = 41)
	public void TCSPR1300641() {

		waitThread(1000);
		// Click Discard button
		click(ms.discard_btn);

		waitThread(2000);
		// Assert confirmationn popup visible
		Assert.assertTrue(isDisplayed(prw.conf_popup), "popup not visible");

		// Assert text "Do you want to discard the changes made and exit the
		// review
		// window?"
		Assert.assertEquals(getText(prw.conf_txt),
				"Do you want to discard the changes made and exit the review window?");

		waitThread(1000);
		// Assert Cancel & Yes button
		Assert.assertTrue(isDisplayed(prw.conf_cancel_btn), "Cancel button not present");
		Assert.assertEquals(getText(prw.conf_cancel_btn), "Cancel");

		Assert.assertTrue(isDisplayed(prw.conf_submit_btn), "Yes button not present");
		Assert.assertEquals(getText(prw.conf_submit_btn), "Yes");

		waitThread(2000);
		// Click Cancel button
		click(prw.conf_cancel_btn);

		waitThread(3000);
		// Assert no popup visible
		Assert.assertFalse(isElementPresent(prw.conf_popup), "popup visible");

		// Assert Third question status as reviewed
		MouseHover(tsw.quest_3_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("complete"));

		// Assert the wizard status are same

		waitThread(1000);
		// Click Discard button
		click(ms.discard_btn);

		waitThread(2000);
		// Assert confirmationn popup visible
		Assert.assertTrue(isDisplayed(prw.conf_popup), "popup not visible");

		// Click Yes button
		click(prw.conf_submit_btn);

		// Assert toaster "Review Discarded"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Review Discarded");

		click(QP.toasterclosebtn);

		// Assert the current assessments tab
		Assert.assertTrue(isElementPresent(prw.current_assess_label), "Current Assessment label not visible");

	}

	/*
	 * To check whether click on Discard button discarded all changes
	 */
	@Test(priority = 42)
	public void TCSPR1300642() {

		waitThread(3000);
		Doubleclick(st1.stud_searchbx);
		waitThread(3000);

		// Search assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the assessment card visible on the page
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		waitThread(2000);
		// Click Modify Review
		click(st1.begintest_btn);

		waitThread(4000);
		// Assert all questions displayed on Wizard
		Assert.assertEquals(getText(tsw.quest_2_wizard), "2");
		Assert.assertEquals(getText(tsw.quest_3_wizard), "3");
		Assert.assertEquals(getText(tsw.quest_4_wizard), "4");

		// Assert the Third question status not reviewed
		waitThread(1000);
		MouseHover(tsw.quest_3_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("visitednotattended"));

		// Assert 4th question status as not reviewed
		waitThread(1000);
		MouseHover(tsw.quest_4_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_4_wizard, "class").contains("visitednotattended"));

		waitThread(3000);
		// Click 3rd question on wizard
		click(tsw.quest_3_wizard);

		waitThread(1000);
		// Assert the score boxes are empty
		Assert.assertEquals(getValue(prw.score_bx_stud2), "");

		waitThread(3000);
		// Click 4th Question on Wizard
		click(tsw.quest_4_wizard);

		waitThread(3000);
		// Assert the score boxes are empty
		Assert.assertEquals(getValue(prw.score_bx_stud2), "");

	}

	/*
	 * To check the tab switching (My courses tab) functionality
	 */
	@Test(priority = 43)
	public void TCSPR1300643() {

		waitThread(3000);
		// Click 3rd question on wizard
		click(tsw.quest_3_wizard);

		// Assert score boxes empty
		Assert.assertEquals(getValue(prw.score_bx_stud2), "");

		waitThread(1000);
		// Click score box of student2
		click(prw.score_bx_stud2);

		// Enter score for student2
		type(prw.score_bx_stud2, "2");

		waitThread(1000);
		// Assert My Courses tab visible
		Assert.assertTrue(isElementPresent(mrw.mycourses_tab), "My Courses tab not visible");

		waitThread(3000);
		// Click My Courses tab
		click(mrw.mycourses_tab);

		waitThread(2000);
		// Assert a popup visible
		Assert.assertTrue(isElementPresent(mrw.discard_popup), "Discard Changes popup not visible");

		waitThread(1000);
		// Assert label "Discard Changes"
		Assert.assertEquals(getText(mrw.dis_popup_lbl), "Discard Changes");

		// Assert text "Are you certain you want to proceed with your action?Any
		// changes
		// that you have made will not be saved."
		Assert.assertEquals(getText(mrw.dis_popup_txt), "Are you certain you want to proceed with your action?\n"
				+ "Any changes that you have made will not be saved.");

	}

	/*
	 * To check the tab switching (My courses tab) functionality
	 */
	@Test(priority = 44)
	public void TCSPR1300644() {

		waitThread(1000);
		// Assert Discard & Cancel buttons
		Assert.assertTrue(isElementPresent(mrw.popup_dis_btn), "Discard button not present");
		Assert.assertEquals(getText(mrw.popup_dis_btn), "Discard");

		Assert.assertTrue(isElementPresent(mrw.popup_cancel_btn), "Cancel button not present");
		Assert.assertEquals(getText(mrw.popup_cancel_btn), "Cancel");

		waitThread(2000);
		// Click cancel button
		click(mrw.popup_cancel_btn);

		waitThread(2000);
		// Assert no popup visible
		Assert.assertFalse(isElementPresent(mrw.discard_popup), "Discard Changes popup visible");

		waitThread(1000);
		// Assert the 3rd question highlighted on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("p-highlight"));

		// Assert the added score for student2 visible
		Assert.assertEquals(getValue(prw.score_bx_stud2), "2");

		waitThread(3000);
		// Click My Courses tab
		click(mrw.mycourses_tab);

		waitThread(2000);
		// Assert a popup visible
		Assert.assertTrue(isElementPresent(mrw.discard_popup), "Discard Changes popup not visible");

		waitThread(1000);
		// Click Discard button
		click(mrw.popup_dis_btn);

		waitThread(4000);
		// Assert Heading "Enrolled Courses"
		waitFor(st1.enrolledcourse_lbl);
		Assert.assertEquals(getText(st1.enrolledcourse_lbl), "Enrolled Courses");

		waitThread(2000);
		// Click Assessment tab
		click(QP.Assessmenttab);

		waitThread(5000);

		Doubleclick(st1.stud_searchbx);
		waitThread(3000);
		// Search assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(4000);

		// Assert the assessment card visible on the page
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

	}

	/*
	 * To check whether the added datas discarded when tab is switched
	 */
	@Test(priority = 45)
	public void TCSPR1300645() {

		waitThread(3000);
		// Click Modify Review button
		click(st1.begintest_btn);

		waitThread(2000);
		// Assert the First question highlighted on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));

		// Assert Third question status as not reviewed
		MouseHover(tsw.quest_3_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("visitednotattended"));

		waitThread(1000);
		// Click 3rd question on wizard
		click(tsw.quest_3_wizard);

		waitThread(1000);
		// Assert the score box is empty
		Assert.assertEquals(getValue(prw.score_bx_stud2), "");

	}

	/*
	 * To check the tab switching (Assessments tab) functionality
	 */
	@Test(priority = 46)
	public void TCSPR1300646() {
		// Click score box of student2
		click(prw.score_bx_stud2);

		// Enter score for student2
		type(prw.score_bx_stud2, "2");

		// Click comment box
		click(prw.comment_bx_stud2);

		// Assert comment popup visible
		waitThread(1000);
		Assert.assertTrue(isElementPresent(prw.comment_popup), "Comment popup of Student Two not visible");

		// Enter comment
		click(prw.txtbx_comment);
		type(prw.txtbx_comment, "Comments");

		// Click tick button
		click(prw.commentsave_btn);
		waitThread(1000);

		// Assert the added comment in comment box
		Assert.assertEquals(getValue(prw.comment_bx_stud2), "Comments");

		// Assert Assessments tab visible
		Assert.assertTrue(isElementPresent(mrw.assess_tab), "Assessments tab not visible");

		waitThread(3000);
		// Click Assessments tab
		click(mrw.assess_tab);

		waitThread(3000);
		// Assert a popup visible
		Assert.assertTrue(isElementPresent(mrw.discard_popup), "Discard Changes popup not visible");

		waitThread(2000);
		// Assert label "Discard Changes"
		Assert.assertEquals(getText(mrw.dis_popup_lbl), "Discard Changes");

		// Assert text "Are you certain you want to proceed with your action?Any
		// changes
		// that you have made will not be saved."
		Assert.assertEquals(getText(mrw.dis_popup_txt), "Are you certain you want to proceed with your action?\n"
				+ "Any changes that you have made will not be saved.");

	}

	/*
	 * To check the tab switching (Assessments tab) functionality
	 */
	@Test(priority = 47)
	public void TCSPR1300647() {

		waitThread(1000);
		// Assert Discard & Cancel buttons
		Assert.assertTrue(isElementPresent(mrw.popup_dis_btn), "Discard button not present");
		Assert.assertEquals(getText(mrw.popup_dis_btn), "Discard");

		Assert.assertTrue(isElementPresent(mrw.popup_cancel_btn), "Cancel button not present");
		Assert.assertEquals(getText(mrw.popup_cancel_btn), "Cancel");

		waitThread(2000);
		// Click cancel button
		click(mrw.popup_cancel_btn);

		waitThread(3000);
		// Assert no popup visible
		Assert.assertFalse(isElementPresent(mrw.discard_popup), "Discard Changes popup not visible");

		waitThread(1000);
		// Assert the 3rd question highlighted on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("p-highlight"));

		// Assert the added score for student2 visible
		Assert.assertEquals(getValue(prw.score_bx_stud2), "2");

		// Assert the added comment visible on comment box
		Assert.assertEquals(getValue(prw.comment_bx_stud2), "Comments");

		waitThread(3000);
		// Click Assessments tab
		click(mrw.assess_tab);

		waitThread(2000);
		// Assert a popup visible
		Assert.assertTrue(isElementPresent(mrw.discard_popup), "Discard Changes popup not visible");

		waitThread(1000);
		// Click Discard button
		click(mrw.popup_dis_btn);

		waitThread(4000);
		// Assert Heading "Current Assessments"
		Assert.assertTrue(isElementPresent(prw.current_assess_label), "Current Assessment label not visible");
		Assert.assertEquals(getText(prw.current_assess_label), "Current Assessments");
		waitThread(2000);

		Doubleclick(st1.stud_searchbx);
		waitThread(2000);

		// Search assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(3000);

		// Assert the assessment card visible on the page
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

	}

	/*
	 * To check whether the added datas discarded when tab is switched
	 */
	@Test(priority = 48)
	public void TCSPR1300648() {
		waitThread(3000);
		// Click Modify Review button
		click(st1.begintest_btn);

		// Assert the First question highlighted on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));

		// Assert the Third question status not reviewed
		waitThread(1000);
		MouseHover(tsw.quest_3_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("visitednotattended"));

		waitThread(1000);
		// Click 3rd question on wizard
		click(tsw.quest_3_wizard);

		waitThread(1000);
		// Assert the score box is empty
		Assert.assertEquals(getValue(prw.score_bx_stud2), "");

	}

	/*
	 * To perform delete account functionality on Student3 profile
	 */
	@Test(priority = 49)
	public void TCSPR1300649() {

		waitThread(3000);
		cr.DeleteAccount();

		waitThread(2000);

		// login using deleted account credentials
		lg.login(Emailstudent3, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student2 Account functionality
	 */
	@Test(priority = 50)
	public void TCSPR1200650_DeleteStudent2() {

		// login using deleted account credentials
		lg.login1(Emailstudent2, password);
		waitThread(2000);
		cr.DeleteAccount();
		waitThread(2000);

		// login using deleted account credentials
		lg.login(Emailstudent2, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student1 Account functionality
	 */
	@Test(priority = 51)
	public void TCSPR1200651_DeleteStudent1() {

		// login using deleted account credentials
		lg.login1(Emailstudent1, password);
		waitThread(2000);
		cr.DeleteAccount();

		waitThread(2000);

		// login using deleted account credentials
		lg.login(Emailstudent1, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete Teacher Account functionality
	 */
	@Test(priority = 52)
	public void TCSPR1200652_DeleteTeacher() {

		// login using deleted account credentials
		lg.login1(Emailteacher, password);
		waitThread(2000);
		cr.DeleteAccount();
		waitThread(2000);

		// login using deleted account credentials
		lg.login(Emailteacher, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

}
