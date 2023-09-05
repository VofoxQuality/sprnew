package ResultWindowforIndividualStudentTest;

import java.sql.SQLException;
import java.sql.Time;
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
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
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
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowWizardPage;
import ResultWindowforIndividualStudent.Page.StudentAnswerSheetBasicsPage;
import ResultWindowforIndividualStudent.Page.StudentResultWindowBasicsPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import TestWindowOfIndividualStudent.AssessmentSubmitAndStatusPopUpPage;
import TestWindowOfIndividualStudent.ModifyWizardSectionPage;
import TestWindowOfIndividualStudent.TestWindowWizardPage;

public class StudentAnswerSheetBasicsTest extends basePage {
	LoginPage lg = new LoginPage();
	CommonMethods cm = new CommonMethods();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	PeerReviewWindowWizardPage prw = new PeerReviewWindowWizardPage();
	SchedulePageBasicsPage sb1 = new SchedulePageBasicsPage();
	SummaryBasicsPage sb = new SummaryBasicsPage();
	SummaryQuestionsPage sq = new SummaryQuestionsPage();
	TeacherTestSectionPage tts = new TeacherTestSectionPage();
	StudentTestSectionPage st1 = new StudentTestSectionPage();
	TeacherPeerReviewSectionPage tp = new TeacherPeerReviewSectionPage();
	TestWindowWizardPage tsw = new TestWindowWizardPage();
	StudentPeerReviewPage sp1 = new StudentPeerReviewPage();
	ModifyWizardSectionPage ms = new ModifyWizardSectionPage();
	AssessmentSubmitAndStatusPopUpPage asp = new AssessmentSubmitAndStatusPopUpPage();
	StudentResultWindowBasicsPage rwbt = new StudentResultWindowBasicsPage();
	StudentAnswerSheetBasicsPage sasb = new StudentAnswerSheetBasicsPage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	CommonFileTest cmt = new CommonFileTest();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	SignUpPage sp = new SignUpPage();
	CourseRosterPage cr = new CourseRosterPage();
	EncryptedText et = new EncryptedText();
	Databaseconnection dc = new Databaseconnection();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();

	public String password = "Abc@123";
	public String Teachername = "Test Teacher";
	public String Emailteacher;
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
	public String Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
	public String Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";
	public String Emailstudent3 = "student3" + generateRandomNumber().trim() + "@gmail.com";

	public String CourseName3;
	public String CourseID3;

	public String AssessmentName;
	public String quest_count;
	public String Question1 = "Question1";
	public String Question2 = "Question2";
	public String Question3 = "Question3";
	public String Rubric1 = "R1";
	public String Answerstud1 = "Answer1_Student1";
	public String Answerstud2 = "Answer2_Student1";
	public String Comment1 = "Comment_student1";
	public String Comment2 = "Comment_student2";
	public String Comment3 = "Comment_student3";

	/*
	 * To perform Login functionality
	 */
	@Test(priority = -7)
	public void TeacherSignUp() throws SQLException {

		Emailteacher = cmt.SignUpTeacher();

		// To catch OTP from sending Resource
		cmt.OtpFetch();

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	/*
	 * To create new course
	 */
	@Test(priority = -6)
	public void Teachercoursecreation() throws SQLException {

		CourseName3 = "Course Name" + generateRandomNumber().trim();

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

	@Test(priority = -5)
	public void Teacherlogout() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on first student 's profile
	 * and accept course request-Read the student name
	 */
	@Test(priority = -4)
	public void Student1signup() throws SQLException {

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

	@Test(priority = -3)
	public void student1courseaccept() {

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
	@Test(priority = -2)
	public void student2signup() throws SQLException {

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

	@Test(priority = -1)
	public void student2courseaccept() {

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

	@Test(priority = 0)
	public void student3signup() throws SQLException {

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

	@Test(priority = 1)
	public void student3acceptcourse() {

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
	@Test(priority = 2)
	public void TCSPR1400302() {

		SoftAssert softAssert1 = new SoftAssert();
		lg.login1(Emailteacher, password);
		waitThread(4000);

		// click on Assessment tab
		click(ba.Assessmenttab);

		waitThread(3000);
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
		waitThread(2000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(5000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), AssessmentName);

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID3 + ", " + CourseName3.trim());

		softAssert1.assertAll();

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 3)
	public void TCSPR1400303() {

		waitThread(3000);

		// Type Question 1
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);

		waitThread(1000);
		type(QP.Quest_box, Question1);

		// Assert the question content on the question editor
		Assert.assertEquals(getText(QP.Quest_box), Question1);
		driver.switchTo().defaultContent();

		// Page Scroll down
		QP.Scroll_DowntoEnd();
		waitThread(2000);

		// Type data in Standard Rubric box
		driver.switchTo().frame("rubric_ifr");
		waitThread(2000);
		type(QP.std_rub_bx, Rubric1);

		// Assert the rubic content on the textbox
		Assert.assertEquals(getText(QP.std_rub_bx), Rubric1);

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, "2");

		MouseHover(QP.save);

		waitThread(3000);
		// Click on +button
		click(rd.add_quest_btn);
		waitFor(QP.toaster);

		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);

		// Type Question 2
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);

		waitThread(1000);
		type(QP.Quest_box, "Question2");

		// Assert the question content on the question editor
		Assert.assertEquals(getText(QP.Quest_box), "Question2");
		driver.switchTo().defaultContent();

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Type data in Standard Rubric box
		driver.switchTo().frame("rubric_ifr");
		waitThread(2000);
		type(QP.std_rub_bx, "R2");

		// Assert the rubic content on the textbox
		Assert.assertEquals(getText(QP.std_rub_bx), "R2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, "4");

		MouseHover(QP.save);

		waitThread(1000);
		// Click on +button
		click(rd.add_quest_btn);
		waitFor(QP.toaster);

		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully");
		click(QP.toasterclosebtn);

	}
	/*
	 * To add more questions to questions page
	 */

	@Test(priority = 4)
	public void TCSPR1400304() {

		waitThread(3000);

		// Type Question 3
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		waitThread(1000);

		type(QP.Quest_box, Question3);

		// Assert the question content on the question editor
		Assert.assertEquals(getText(QP.Quest_box), Question3);
		driver.switchTo().defaultContent();

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Type data in Standard Rubric box
		driver.switchTo().frame("rubric_ifr");
		waitThread(2000);
		type(QP.std_rub_bx, "R3");

		// Assert the rubic content on the textbox
		Assert.assertEquals(getText(QP.std_rub_bx), "R3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, "2");

		MouseHover(QP.save);

		waitThread(1000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 3 Saved successfully");
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
	@Test(priority = 5)
	public void TCSPR1400305() {

		waitThread(3000);

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID3));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName3.trim()));

		waitThread(4000);
		// Select Answer Sheets Per Student =2
		click(prw.reviewans_sheetdropdwn);
		waitThread(1000);
		click(prw.reviewssheet_count);

		waitThread(4000);
		// Enter peer review Reward score 100
		type(prw.peer_reward_scorebx, "100");

		// Assert the text::Total Students : Assert the total student count is 3
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 3");

	}

	/*
	 * To verify the details on the Summary page & publish the Assessment
	 */
	@Test(priority = 6)
	public void TCSPR1400306() {

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
	@Test(priority = 7)
	public void TCSPR1400307() {

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
	@Test(priority = 8)
	public void TCSPR1400308() {

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
	@Test(priority = 9)
	public void TCSPR1400309() {

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
	@Test(priority = 10)
	public void TCSPR1400310() throws InterruptedException {
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(50);
		waitThread(2000);
		// Assert the the "Test Active "
		// Assert.assertEquals(getText(tp.teststs_lbl), "Active");

		// Assert the text "Students Submitted"
		// Assert.assertEquals(getText(st1.stud_compl_txt), "Students
		// Submitted");
	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 11)
	public void TCSPR1400311() {
		// logout functionality
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform Login functionality of student1 profile and check the
	 * Assessment card
	 */
	@Test(priority = 12)
	public void TCSPR1400312() {

		// login as Student1
		lg.login1(Emailstudent1, password);

		waitThread(5000);

		// verify heading label current Assessments
		Assert.assertEquals(getText(QP.current_assesslabel), "Current Assessments");

		waitThread(3000);

		Doubleclick(st1.stud_searchbx);
		waitThread(3000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		waitThread(2000);
		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(st1.Assess_name_card), AssessmentName);

	}

	/*
	 * To Begin Test &add answers to 1& 2nd questions by Student1
	 */
	@Test(priority = 13)
	public void TCSPR1400313() throws InterruptedException {

		waitThread(2000);
		// Assert the test status as active
		Assert.assertEquals(getText(tp.teststs_lbl), "Active");

		// Assert the button begin test
		Assert.assertTrue(isDisplayed(st1.begintest_btn), "Begin test not present");
		Assert.assertEquals(getText(st1.begintest_btn), "Begin Test");

		waitThread(2000);
		// Click Begin Test
		click(st1.begintest_btn);

		waitThread(4000);
		// Assert the total Questions, Total score
		Assert.assertTrue(getText(tsw.questions_count).contains("Total Questions"));
		Assert.assertTrue(getText(tsw.total_score).contains("Total Score"));

		// Assert the first question is highlighted on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));
		Assert.assertEquals(getText(tsw.quest_1_wizard), "1");

		// Enter Answer1
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer1_Student1");

		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(3000);
		// Assert first Question is answered
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("complete"));

		// Enter Answer2
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer2_Student1");

		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(3000);
		// Assert Second Question is answered
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("complete"));

		// Assert Submit button
		Assert.assertTrue(isDisplayed(tsw.submit_btn), "Submit button not present");

	}

	/*
	 * To submit the Assessment and logout from Student1 profile
	 */
	@Test(priority = 14)
	public void TCSPR1400314() {
		waitThread(2000);
		// Click Submit button
		click(tsw.submit_btn);

		waitThread(1000);
		// Assert confirmation popup
		Assert.assertTrue(isDisplayed(tsw.confir_popup), "popup not visible");

		// Assert the text "You have 1 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(tsw.confirmation_txt), "You have 1 skipped question(s)! Proceed to submit?");

		// Click submit button on popup
		click(tsw.submit_confi);

		// Assert toaster "Assessment Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		// click back to Assessments
		click(tsw.backtoassess_btn);

		waitThread(4000);
		// Assert the current Assessments
		Assert.assertEquals(getText(prw.current_assess_label), "Current Assessments");

		waitThread(4000);
		// Perform logout from Student1
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To Perform Login by Student2 and to Begin Test
	 */
	@Test(priority = 15)
	public void TCSPR1400315() {

		waitThread(2000);
		// login as Student2
		lg.login1(Emailstudent2, password);

		waitThread(4000);

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
	 * To Add answers to all Questions by Student2
	 */
	@Test(priority = 16)
	public void TCSPR1400316() {

		// Enter Answer1
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer1_Student2");

		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(3000);
		// Assert first Question is answered
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("complete"));

		// Enter Answer2
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer2_Student2");

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

		click(tsw.answer_bx);
		type(tsw.answer_bx, "Answer3_Student2");

		driver.switchTo().defaultContent();
		waitThread(2000);

		waitThread(2000);
		click(tsw.save_btn_test);

		waitThread(3000);

		// Assert Third Question is answered
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("complete"));

	}

	/*
	 * To submit the Assessment and logout from Student2 profile
	 */
	@Test(priority = 17)
	public void TCSPR1400317() {

		waitThread(2000);
		// Click Submit button
		click(tsw.submit_btn);

		waitThread(1000);
		// Assert confirmation popup
		Assert.assertTrue(isDisplayed(tsw.confir_popup), "popup not visible");

		// Assert the text "Are you sure you want to submit the assessment?"
		Assert.assertEquals(getText(tsw.confirmation_txt), "Are you sure you want to submit the assessment?");

		waitThread(2000);
		// Click submit button on popup
		click(tsw.submit_confi);

		// Assert toaster "Assessment Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		// click back to Assessments
		click(tsw.backtoassess_btn);

		waitThread(4000);
		Doubleclick(st1.stud_searchbx);
		waitThread(2000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the Questions answered count 3/3
		Assert.assertEquals(getText(tsw.ans_count), "3/3");

		// Perform logout from Student2
		// logout functionality
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To Perform Login by Student3 & add answers to second & third questions
	 */
	@Test(priority = 18)
	public void TCSPR1400318() {
		// Perform login by Student3
		lg.login1(Emailstudent3, password);

		waitThread(4000);

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

		waitThread(2000);
		// Click Begin Test
		click(st1.begintest_btn);

		waitThread(3000);
		// Assert the first question is highlighted on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));
		Assert.assertEquals(getText(tsw.quest_1_wizard), "1");

		waitThread(1200);
		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(2000);
		// Assert first Question is unanswered
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("visitednotattended"));

		waitThread(1000);

		// Enter Answer2
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer2_Student3");

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

		type(tsw.answer_bx, "Answer3_Student3");

		driver.switchTo().defaultContent();

		waitThread(2000);

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

		// click back to Assessments
		click(tsw.backtoassess_btn);

		waitThread(3000);
		// Assert the current Assessments
		Assert.assertEquals(getText(prw.current_assess_label), "Current Assessments");

		waitThread(4000);

	}

	/*
	 * To perform logout from student 3 and login by Teacher and reschedule the
	 * dates to make peer review active
	 */
	@Test(priority = 19)
	public void TCSPR1400319() {

		waitThread(2000);
		// Perform logout from Student3
		// logout functionality
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// Login to Teacher profile
		cm.login(Emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// Click Assessment tab
		click(QP.teach_assesstab);

		waitThread(5000);

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

		// Set Peer review open date to Current day
		waitThread(2000);
		Doubleclick(rd.peerreviewopendate_txtbx);

		waitThread(2000);
		cm.ClickTodaysDate();

		waitThread(2000);
		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitThread(5000);

		// logout functionality
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To Login to Student1 profile &begin the Review & check the labels of peer
	 * review window
	 */
	@Test(priority = 20)
	public void TCSPR1400320() throws InterruptedException {

		// Login to Student1
		lg.login1(Emailstudent1, password);

		waitThread(3000);
		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		type(st1.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Wait till peer review active
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(50);
		waitThread(2000);
		// Assert Test window closed
		Assert.assertEquals(getText(st1.windowclosd), "Window Closed");
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(50);
		waitThread(1000);
		// Assert peer review active
		Assert.assertEquals(getText(sp1.reviewpending_lbl), "Active");

		// Assert the Begin Review button
		Assert.assertTrue(isDisplayed(st1.begintest_btn), "Begin Review not present");
		Assert.assertEquals(getText(st1.begintest_btn), "Begin Review");

		// Assert peer review % =0%
		Assert.assertEquals(getText(sp1.zeropercent_card), "0%");

		waitThread(2000);

		// Click Begin Review
		click(st1.begintest_btn);

		waitThread(5000);
		// Assert the Assessment name
		Assert.assertEquals(getText(tsw.test_window_assess_name), AssessmentName);

		// Assert the coursename, id, Teacher name on the test window
		Assert.assertTrue(getText(tsw.course_name_id).contains(CourseName3.trim()));
		Assert.assertTrue(getText(tsw.course_name_id).contains(CourseID3));

		waitThread(4000);

		// Assert the time status
		Assert.assertTrue(getText(tsw.time_status).contains("Peer Review Active for"));

	}

	/*
	 * To add score for students answer sheets. and make answer sheet of
	 * question2 as partially reviewed
	 */
	@Test(priority = 21)
	public void TCSPR1400321() {

		waitThread(2000);
		// Assert StudentOne disabled
		Assert.assertTrue(getAttribute(prw.studentone_part, "class").contains("p-disabled"));

		waitThread(2000);
		// Assert the disclaimer text
		Assert.assertEquals(getText(prw.stud1_disclaimer_txt),
				"Disclaimer: Student One did not answer this question so no peer review is necessary for this student, and your peer review points will not be affected.");

		waitThread(2000);
		// Click Score box student2
		click(prw.score_bx_stud2);

		// Enter score for student2
		type(prw.score_bx_stud2, "2");

		waitThread(2000);
		// Click 2nd Question on Wizard
		click(tsw.quest_2_wizard);

		waitThread(2000);
		// Assert First Question as Reviewed
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("complete"));

		waitThread(2000);
		// Click Score box student1
		click(prw.score_bx_stud1);

		// Enter score for student1
		type(prw.score_bx_stud1, "3");

		// Click Comment box of Student1
		waitThread(2000);
		click(prw.comment_bx_stud1);

		// Enter comment for Student1
		click(prw.txtbx_comment);
		type(prw.txtbx_comment, Comment1);

		waitThread(2000);
		click(prw.commentsave_btn);

		waitThread(2000);
		// Click 3rd Question on Wizard
		click(tsw.quest_3_wizard);

		waitThread(2000);
		// Assert Second Question as Reviewed
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("incomplete"));

		// Click Score box student1
		click(prw.score_bx_stud1);

		// Enter score for student1
		type(prw.score_bx_stud1, "2");

		// Click Score box student2
		click(prw.score_bx_stud2);

		// Enter score for student2
		type(prw.score_bx_stud2, "2");

		// Assert Submit button
		Assert.assertTrue(isElementPresent(tsw.submit_btn), "Submit button not present");

	}

	/*
	 * To submit reviews and check the card and logout from student1 profile
	 */
	@Test(priority = 22)
	public void TCSPR1400322() {

		waitThread(2000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(2000);
		// Assert text "You have 1 review(s) as incomplete! Proceed to submit?"
		Assert.assertEquals(getText(prw.conf_txt), "The review of 1 question(s) remains incomplete. Do you wish to proceed?");

		waitThread(1000);
		// Click submit button
		click(prw.conf_submit_btn);

		// Assert toaster "Peer Review Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);
		waitThread(1000);

		// Click back to Assessments
		click(prw.backto_btn);

		waitThread(4000);
		// search assessments
		click(st1.stud_searchbx);
		waitThread(2000);
		click(st1.stud_searchbx);
		waitThread(2000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the % as 80% per review completed
		Assert.assertEquals(getText(sp1.zeropercent_card), "80%");

		// Perform logout from Student1
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To Perform Login by Student2 and to begin review, skip first question
	 */
	@Test(priority = 23)
	public void TCSPR1400323() {

		// Login to Student2
		lg.login1(Emailstudent2, password);

		waitThread(4000);
		// Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		Doubleclick(st1.stud_searchbx);
		waitThread(2000);
		type(st1.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Click Begin Review
		click(st1.begintest_btn);

		waitThread(4000);
		// Assert first question selected on wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));

		// Click Save &Next button
		click(QP.savenext_btn);

		waitThread(2000);
		// Assert the first question is Not Reviewed
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("visitednotattended"));

		// Click Score box student1
		click(prw.score_bx_stud1);

		// Enter score for student1
		type(prw.score_bx_stud1, "2");

		// Enter comment for student1
		click(prw.comment_bx_stud1);
		click(prw.txtbx_comment);
		type(prw.txtbx_comment, Comment2);

		waitThread(2000);
		click(prw.commentsave_btn);

		waitThread(2000);

		// Click Score box student2
		click(prw.score_bx_stud2);

		// Enter score for student2
		type(prw.score_bx_stud2, scoretostud1ans2);

		click(prw.comment_bx_stud2);
		click(prw.txtbx_comment);
		type(prw.txtbx_comment, Comment2);

		waitThread(2000);
		click(prw.commentsave_btn);

		waitThread(1000);
		// Click Save &Next button
		click(QP.savenext_btn);

		waitThread(2000);
		// Assert the second question is Reviewed
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("complete"));

		waitThread(1000);
		// Click Score box student1
		Doubleclick(prw.score_bx_stud1);

		waitThread(1000);
		// Enter score for student1
		type(prw.score_bx_stud1, "2");

		click(prw.comment_bx_stud1);
		click(prw.txtbx_comment);
		type(prw.txtbx_comment, Comment2);

		waitThread(2000);
		click(prw.commentsave_btn);

		// Assert StudentTwo disabled
		Assert.assertTrue(getAttribute(prw.studenttwo_part, "class").contains("p-disabled"));

	}

	/*
	 * To submit reviews and check the card and logout from student2 profile
	 */
	@Test(priority = 24)
	public void TCSPR1400324() {

		waitThread(4000);
		// Click submit button
		click(tsw.submit_btn);
		waitThread(2000);
		// Assert text "You have 1 skipped evaluation(s)! Proceed to submit?"
		Assert.assertEquals(getText(prw.conf_txt), "The review of 1 question(s) was skipped. Do you wish to proceed?");

		waitThread(3000);
		// Click submit button
		click(prw.conf_submit_btn);

		// Assert toaster "Peer Review Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);
		waitThread(1000);

		// Click back to Assessments
		click(prw.backto_btn);

		waitThread(3000);
		// search assessments
		click(st1.stud_searchbx);
		waitThread(2000);
		click(st1.stud_searchbx);

		// search newly created assessment
		type(st1.stud_searchbx, AssessmentName);
		waitThread(3000);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the % as 75% per review completed
		Assert.assertEquals(getText(sp1.zeropercent_card), "75%");

		waitThread(2000);
		// Perform logout from Student2
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To Perform Login by Student3 and to do reviews for all questions
	 */
	public String scoretostud1ans1 = "1";
	public String scoretostud1ans2 = "2";

	@Test(priority = 25)
	public void TCSPR1400325() {

		// Login to Student3
		lg.login1(Emailstudent3, password);

		waitThread(4000);
		// Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		type(st1.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Click Begin Review
		click(st1.begintest_btn);

		waitThread(3000);
		// Assert first question selected on wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));

		waitThread(2000);
		// Click Score box student1
		click(prw.score_bx_stud1);

		waitThread(2000);
		// Enter score for student1
		type(prw.score_bx_stud1, "2");

		click(prw.comment_bx_stud1);
		click(prw.txtbx_comment);
		type(prw.txtbx_comment, Comment3);

		waitThread(2000);
		click(prw.commentsave_btn);

		waitThread(1000);
		// Click Score box student2
		click(prw.score_bx_stud2);

		waitThread(1000);
		// Enter score for student2
		type(prw.score_bx_stud2, scoretostud1ans1);

		click(prw.comment_bx_stud2);
		click(prw.txtbx_comment);
		type(prw.txtbx_comment, Comment3);

		waitThread(2000);
		click(prw.commentsave_btn);
		waitThread(1000);

		// Click Save &Next button
		click(QP.savenext_btn);

		waitThread(2000);
		// Assert the First question is Reviewed
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("complete"));
		waitThread(2000);

		// Click Score box student1
		Doubleclick(prw.score_bx_stud1);

		// Enter score for student1
		type(prw.score_bx_stud1, "2");

		click(prw.comment_bx_stud1);
		click(prw.txtbx_comment);
		type(prw.txtbx_comment, Comment3);

		waitThread(2000);
		click(prw.commentsave_btn);

		// Click Score box student2
		click(prw.score_bx_stud2);

		// Enter score for student2
		type(prw.score_bx_stud2, scoretostud1ans2);

		click(prw.comment_bx_stud2);
		click(prw.txtbx_comment);
		type(prw.txtbx_comment, Comment3);

		waitThread(2000);
		click(prw.commentsave_btn);

		waitThread(1000);
		// Click Save &Next button
		click(QP.savenext_btn);

		waitThread(2000);
		// Assert the second question is Reviewed
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("complete"));

		// Click Score box student1
		click(prw.score_bx_stud1);

		// Enter score for student1
		type(prw.score_bx_stud1, "2");

		// Assert StudentTwo disabled
		Assert.assertTrue(getAttribute(prw.studenttwo_part, "class").contains("p-disabled"));

	}

	/*
	 * To submit reviews and To Logout from student2 , Login by teacher & to
	 * reschedule date to make result active
	 */
	@Test(priority = 26)
	public void TCSPR1400326() throws InterruptedException {

		waitThread(2000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(2000);
		// Assert text "Are you sure you want to submit the review?"
		Assert.assertEquals(getText(prw.conf_txt), "Are you sure you want to submit the review?");

		waitThread(1000);
		// Click submit button
		click(prw.conf_submit_btn);

		// Assert toaster "Peer Review Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);
		waitThread(1000);

		// Click back to Assessments
		click(prw.backto_btn);

		waitThread(4000);
		// Perform logout from Student3
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// Login to Teacher profile
		cm.login(Emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// Click Assessment tab
		click(QP.teach_assesstab);

		waitThread(5000);

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
		TimeUnit.MINUTES.sleep(3);
		TimeUnit.SECONDS.sleep(50);

		// logout functionality
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check view Result window
	 */
	@Test(priority = 27)
	public void TCSPR1400327() throws InterruptedException {

		// Login to Student1
		lg.login1(Emailstudent1, password);

		waitThread(5000);
		// Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		Doubleclick(st1.stud_searchbx);
		waitThread(2000);
		type(st1.stud_searchbx, AssessmentName);
		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		AnswerdQuestioncount = getText(asp.cardQuestioncount);

		// Assert the % as 100% per review completed
		Assert.assertEquals(getText(sp1.zeropercent_card), "80%");
		Scroll_DowntoEnd();
		// Assert the Result window Active
		// Assert.assertEquals(getText(rwbt.lbl_resultactive), "Active");

		// Assert the timer status " Result Available"
		// Assert.assertEquals(getText(rwbt.cardheading), "Result Available");

		// Assert "View Result " button
		Assert.assertTrue(isElementPresent(rwbt.viewresultbtn), "View result button not visible");

		// click on view result button
		click(rwbt.viewresultbtn);
		waitThread(6000);

		// Assert Result popup visible
		Assert.assertTrue(isElementPresent(rwbt.resultpopup), "Result Popup  not visible");

		// Assert the Scores Received from Peer Reviewers of 3rd question is
		// "--"
		Assert.assertEquals(getText(sasb.scorefromreview_q3), "--");

	}

	/*
	 * To check view Result window question details
	 */
	public String AnswerdQuestioncount;
	public String q1status;
	public String q2status;
	public String q3status;

	@Test(priority = 28)
	public void TCSPR1400328() {

		q1status = getText(rwbt.Q1_Status);
		q2status = getText(rwbt.Q2_Status);
		q3status = getText(rwbt.Q3_Status);

		// Assert 3 questions visible on grid
		Assert.assertEquals(getText(rwbt.Q1_content), Question1);
		Assert.assertEquals(getText(rwbt.Q2_content), Question2);
		Assert.assertEquals(getText(rwbt.Q3_content), Question3);

		// Assert the view buttons of all questions
		Assert.assertTrue(isElementPresent(sasb.view_btn_q1), "View button of Question one not present");
		Assert.assertTrue(isElementPresent(sasb.view_btn_q2), "View button of Question two not present");
		Assert.assertTrue(isElementPresent(sasb.view_btn_q3), "View button of Question three not present");

		// Read the status of each questions
		Assert.assertEquals(getText(rwbt.Q1_Status), "Partially Peer Reviewed");
		Assert.assertEquals(getText(rwbt.Q2_Status), "Peer Review Completed");
		Assert.assertEquals(getText(rwbt.Q3_Status), "Unanswered Question");

		// Assert Questions Answered count
		Assert.assertEquals(getText(rwbt.value_studentAnswered), AnswerdQuestioncount);
	}

	public String maxscore1;
	public String finalscore1;
	public String scorefrompeer1;
	public String scoreforreview1;
	public String resulttotalscore;

	public String maxscore2;
	public String finalscore2;
	public String scorefrompeer2;
	public String scoreforreview2;

	public String scoreforreview3;
	public String maxscore3;
	public String finalscore3;

	/*
	 * To check the answer sheet window of first question
	 */
	@Test(priority = 29)
	public void TCSPR1400329() {
		maxscore1 = getText(rwbt.Q1_Maxscore);
		maxscore2 = getText(rwbt.Q2_Maxscore);
		maxscore3 = getText(rwbt.Q3_Maxscore);

		finalscore1 = getText(rwbt.Q1_FinalScore);
		finalscore2 = getText(rwbt.Q2_FinalScore);
		finalscore3 = getText(rwbt.Q3_FinalScore);

		scorefrompeer1 = getText(rwbt.Q1_scorefrompeers);
		scorefrompeer2 = getText(rwbt.Q2_scorefrompeers);

		scoreforreview1 = getText(rwbt.Q1_scoreforreviews);
		scoreforreview2 = getText(rwbt.Q2_scoreforreviews);
		scoreforreview3 = getText(rwbt.Q3_scoreforreviews);

		resulttotalscore = getText(rwbt.TotalScore);

		waitThread(3000);
		// Click View button of First question
		click(sasb.view_btn_q1);

		waitThread(4000);
		// Assert Assessment name
		Assert.assertEquals(getText(tsw.test_window_assess_name), AssessmentName);

		// Assert the course id, course name
		Assert.assertTrue(getText(tsw.course_name_id).contains(CourseName3.trim()));
		Assert.assertTrue(getText(tsw.course_name_id).contains(CourseID3));

		// Assert the Teacher Name
		Assert.assertTrue(getText(tsw.teach_name_testwindow).contains(Teachername));

		// Assert the Question1 label
		Assert.assertEquals(getText(sasb.questionlabel), "Question No: 1");

		// Assert Labels
		// - max score label
		// -Score Received from Peers:
		// -Score for Review Done:
		Assert.assertTrue(getText(sasb.maxscore_lbl).contains("Max Score"));
		waitThread(2000);
		Assert.assertTrue(getText(sasb.scorefrompeer_lbl).contains("Score Received from Peers:"));
		waitThread(4000);
		Assert.assertTrue(getText(sasb.scoreforreview_lbl).contains("Score for Review Done"));

		// Assert the max score in the answer sheet and in the grid of result
		// window are
		// same
		Assert.assertEquals(getText(sasb.maxscore_lbl), "Max Score: " + maxscore1);

		// Assert label Final score
		Assert.assertTrue(getText(sasb.final_scrorelbl).contains("Final Score"));

		// Assert the final score , Score Received from Peers,Score for Review
		// Done, in
		// the answer sheet are same as in the grid of first question
		Assert.assertEquals(getText(sasb.final_scrorelbl), "Final Score: " + finalscore1);
		Assert.assertEquals(getText(sasb.scorefrompeer_lbl), "Score Received from Peers: " + scorefrompeer1);
		Assert.assertEquals(getText(sasb.scoreforreview_lbl), "Score for Review Done: " + scoreforreview1);

	}

	/*
	 * To check the answer sheet window of first question and to check the
	 * wizard
	 */
	@Test(priority = 30)
	public void TCSPR1400330() {

		// Assert the Total Score label
		Assert.assertTrue(getText(sasb.totalscr_lbl).contains("Total Score"));

		// Assert the Total Score in answer sheet window and result window are
		// same
		Assert.assertEquals(getText(sasb.totalscore), resulttotalscore);

		// Assert the wizard contains all questions buttons
		Assert.assertTrue(getText(sasb.wizardq1).contains("1"));
		Assert.assertTrue(getText(sasb.wizardq2).contains("2"));
		Assert.assertTrue(getText(sasb.wizardq3).contains("3"));

		// Assert the next and prev buttons on wizard
		Assert.assertTrue(isElementPresent(sasb.wizardprev), "Previous button on Wizard not present");
		Assert.assertTrue(isElementPresent(sasb.wizardnext), "Next button on Wizard not present");

		// Assert the first question is highlighted on Wizard
		Assert.assertTrue(getAttribute(sasb.wizardq1, "class").contains("p-highlight"));

		// Assert the prev button of wizard is disabled
		Assert.assertTrue(getAttribute(sasb.wizardprev, "class").contains("p-disabled"));

		// Assert the next button of wizard is enabled
		Assert.assertFalse(getAttribute(sasb.wizardnext, "class").contains("p-disabled"));

	}

	/*
	 * To check the answer sheet window of first question and to check the
	 * question, answer and rubric
	 */
	@Test(priority = 31)
	public void TCSPR1400331() {

		// Assert the question is same as that of Result window
		driver.switchTo().frame("resultQuestionViewEditor_ifr");
		Assert.assertEquals(getText(sasb.quest), Question1);
		driver.switchTo().defaultContent();

		// Assert the Peer review status partially reviewed
		Assert.assertEquals(getText(sasb.reviewstatus), "Partially Peer Reviewed");

		// Assert the peer review status for first question is same in Answer
		// window and
		// result window grid
		Assert.assertEquals(getText(sasb.reviewstatus), q1status);

		// Click Answer box
		click(sasb.answerdropdwn);

		// Assert answer is visible same as that of added answer
		driver.switchTo().frame("resultAnswerViewEditor_ifr");
		Assert.assertEquals(getText(sasb.answer), Answerstud1);
		driver.switchTo().defaultContent();

		// Click Rubric dropdown
		click(sasb.rubricdropdwn);

		// Assert Rubric visible
		driver.switchTo().frame("resultStandardRubricEditor_ifr");
		Assert.assertTrue(isElementPresent(sasb.rubric), "Rubric not present");

		// Assert rubric Same as Question Page
		Assert.assertEquals(getText(sasb.rubric), Rubric1);
		driver.switchTo().defaultContent();
	}

	/*
	 * To check the peer review section of First question
	 */
	@Test(priority = 32)
	public void TCSPR1400332() {

		ScrollTo_xy_position(0, 300);
		// Assert the label "Mark assigned from Peer Students: "
		Assert.assertEquals(getText(sasb.markassign_lbl), "Mark assigned from Peer Students:");

		// Assert the label "Score Received from Peers: " at peer review section
		Assert.assertTrue(getText(sasb.peer_score_lbl).contains("Score Received from Peers:"));

		// Assert student1 part disabled
		Assert.assertTrue(getAttribute(sasb.stud1part, "class").contains("p-disabled"));

		// Click on Student2 Comment box
		click(sasb.stud2tab);

		driver.switchTo().frame("commentEditor_1_ifr");
		waitThread(2000);
		// Assert the Comment added by Student2 visible
		Assert.assertEquals(getText(sasb.stud2comment), Comment3);
		driver.switchTo().defaultContent();

		// Assert the mark given by student 2
		Assert.assertEquals(getValue(sasb.stud2score), scoretostud1ans1);

	}

	/*
	 * To check the answer sheet window of second question
	 */
	@Test(priority = 33)
	public void TCSPR1400333() {

		// Assert second question wizard
		Assert.assertTrue(getText(sasb.wizardq2).contains("2"));

		waitThread(2000);
		// Click Second question on wizard
		click(sasb.wizardq2);

		// Assert second question is selected on Wizard
		Assert.assertTrue(getAttribute(sasb.wizardq2, "class").contains("p-highlight"));

		waitThread(3000);
		// Assert the Question no : 2 label
		Assert.assertEquals(getText(sasb.questionlabel), "Question No: 2");

		// Assert the max score :
		Assert.assertTrue(getText(sasb.maxscore_lbl).contains("Max Score"));

		// Assert the Max score of question with Result window grid
		Assert.assertEquals(getText(sasb.maxscore_lbl), "Max Score: " + maxscore2);

		// Assert Final score
		Assert.assertTrue(getText(sasb.final_scrorelbl).contains("Final Score"));

		// Assert the final score , Score Received from Peers,Score for Review
		// Done, in
		// the answer sheet are same as in the grid of second question
		Assert.assertEquals(getText(sasb.final_scrorelbl), "Final Score: " + finalscore2);
		Assert.assertEquals(getText(sasb.scorefrompeer_lbl), "Score Received from Peers: " + scorefrompeer2);
		Assert.assertEquals(getText(sasb.scoreforreview_lbl), "Score for Review Done: " + scoreforreview2);

	}

	/*
	 * To check the question, answer and rubric of Second question
	 */
	@Test(priority = 34)
	public void TCSPR1400334() {

		// Assert the question is same as that of Result window
		driver.switchTo().frame("resultQuestionViewEditor_ifr");
		Assert.assertEquals(getText(sasb.quest), Question2);
		driver.switchTo().defaultContent();

		// Assert the Peer review status Peer Review Completed
		Assert.assertEquals(getText(sasb.reviewstatus), "Peer Review Completed");

		// Assert the peer review status for second question is same in Answer
		// window
		// and result window grid
		Assert.assertEquals(getText(sasb.reviewstatus), q2status);

		// Click Answer box
		click(sasb.answerdropdwn);

		// Assert answer is visible same as that of added answer
		driver.switchTo().frame("resultAnswerViewEditor_ifr");
		Assert.assertEquals(getText(sasb.answer), Answerstud2);
		driver.switchTo().defaultContent();

		// Click Rubric dropdown
		click(sasb.rubricdropdwn);

		// Assert Rubric visible
		driver.switchTo().frame("resultStandardRubricEditor_ifr");
		Assert.assertTrue(isElementPresent(sasb.rubric), "Rubric not present");
		driver.switchTo().defaultContent();

		// Assert the Total Score in the window
		Assert.assertTrue(getText(sasb.totalscr_lbl).contains("Total Score"));

		// Assert the prev button of wizard is enabled
		Assert.assertFalse(getAttribute(sasb.wizardprev, "class").contains("p-disabled"));

		// Assert the next button of wizard is enabled
		Assert.assertFalse(getAttribute(sasb.wizardnext, "class").contains("p-disabled"));

	}

	/*
	 * To check the peer review section of Second question
	 */
	@Test(priority = 35)
	public void TCSPR1400335() {

		ScrollTo_xy_position(0, 300);

		// Read the scores given by Student1 & 2
		Assert.assertEquals(getValue(sasb.stud1score), scoretostud1ans2);
		Assert.assertEquals(getValue(sasb.stud2score), scoretostud1ans2);

		// Assert the label Student One
		Assert.assertEquals(getText(sasb.stud1_lbl), "Student One");

		// Assert the label Student Two
		Assert.assertEquals(getText(sasb.stud2_lbl), "Student Two");

		// Click on Student1 Comment box
		click(sasb.stud1tab);

		// Assert the Comment added by Student1 visible
		driver.switchTo().frame("commentEditor_0_ifr");
		Assert.assertEquals(getText(sasb.stud1comment), Comment2);
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click on Student2 Comment box
		click(sasb.stud2tab);

		// Assert the Comment added by Student2 visible
		driver.switchTo().frame("commentEditor_1_ifr");
		Assert.assertEquals(getText(sasb.stud2comment), Comment3);
		driver.switchTo().defaultContent();

		// Assert the Score Received from Peers : value is the average of scores
		// given
		// by Student1 & Student2

		Float n1 = Float.parseFloat(scoretostud1ans2);
		Float n2 = Float.parseFloat(scoretostud1ans2);
		Float n3 = n1 + n2;
		Float avgscore = n3 / 2;
		String avgscor1 = Float.toString(avgscore);
		Assert.assertEquals(getText(sasb.peer_score_lbl), "Score Received from Peers: " + avgscor1.substring(0, 1));
	}

	/*
	 * To check the answer sheet window of Third question
	 */
	@Test(priority = 36)
	public void TCSPR1400336() {

		// Assert the Third Question on wizard
		Assert.assertTrue(getText(sasb.wizardq3).contains("3"));

		waitThread(2000);
		// Click Third question on wizard
		click(sasb.wizardq3);

		// Assert Third question is selected on Wizard
		Assert.assertTrue(getAttribute(sasb.wizardq3, "class").contains("p-highlight"));

		waitThread(2000);
		// Assert the Question no : 3 label
		Assert.assertEquals(getText(sasb.questionlabel), "Question No: 3");

		// Assert the max score :
		Assert.assertTrue(getText(sasb.maxscore_lbl).contains("Max Score"));

		// Assert the Max score of question with Result window grid
		Assert.assertEquals(getText(sasb.maxscore_lbl), "Max Score: " + maxscore3);

		// Assert Final score
		Assert.assertTrue(getText(sasb.final_scrorelbl).contains("Final Score"));

		// Assert the final score in the answer sheet are same as in the grid of
		// Third
		// question
		Assert.assertEquals(getText(sasb.final_scrorelbl), "Final Score: " + finalscore3);

	}

	/*
	 * To check the question, answer and rubric of Third question
	 */
	@Test(priority = 37)
	public void TCSPR1400337() {

		// Assert the question is same as that of Result window
		driver.switchTo().frame("resultQuestionViewEditor_ifr");
		Assert.assertEquals(getText(sasb.quest), Question3);
		driver.switchTo().defaultContent();

		// Assert the Peer review status Unanswered Question
		Assert.assertEquals(getText(sasb.reviewstatus), "Unanswered Question");

		// Assert the peer review status for Third question is same in Answer
		// window and
		// result window grid
		Assert.assertEquals(getText(sasb.reviewstatus), q3status);

		// Assert the answer part is disabled
		Assert.assertTrue(getAttribute(sasb.answrpart, "class").contains("p-disabled"));

		// Click Rubric
		click(sasb.rubricdropdwn);

		// Assert Rubric visible

		driver.switchTo().frame("resultStandardRubricEditor_ifr");
		Assert.assertTrue(isElementPresent(sasb.rubric), "Rubric not present");
		driver.switchTo().defaultContent();

		// Assert the prev button of wizard is enabled
		Assert.assertFalse(getAttribute(sasb.wizardprev, "class").contains("p-disabled"));

		// Assert the next button of wizard is disabled
		Assert.assertTrue(getAttribute(sasb.wizardnext, "class").contains("p-disabled"));

	}

	/*
	 * To check the peer review section of Third question
	 */
	@Test(priority = 38)
	public void TCSPR1400338() {

		// Assert "Score Received from Peers:" Lable not visible
		Assert.assertFalse(isElementPresent(sasb.peer_score_lbl), "label is present");

		waitThread(2000);
		// Assert "Score for Review Done:" Label visible
		Assert.assertTrue(getText(sasb.scoreforreview_lbl).contains("Score for Review Done"));

		ScrollTo_xy_position(0, 300);
		// Assert student One part disabled
		Assert.assertTrue(getAttribute(sasb.stud1part, "class").contains("p-disabled"));

		// Assert student2 part is disabled
		Assert.assertTrue(getAttribute(sasb.stud2part, "class").contains("p-disabled"));

		// Assert "Score for Review Done:" is same as the Result window grid
		Assert.assertEquals(getText(sasb.scoreforreview_lbl), "Score for Review Done: " + scoreforreview3);

	}

	/*
	 * To check the exit button functionality of Answer sheet window
	 */
	@Test(priority = 39)
	public void TCSPR1400339() {

		waitThread(2000);
		// Assert the Exit button on the page
		Assert.assertTrue(isElementPresent(sasb.Exit_btn), "Exit button not present");

		// Assert the tootlip of button" Exit & Return to Results"
		Assert.assertEquals(getAttribute(sasb.Exit_tooltip, "ptooltip"), ("Exit and Return to Results"));

		// Click Exit button
		click(sasb.Exit_btn);

		waitThread(4000);

		// Assert Result popup visible
		Assert.assertTrue(isElementPresent(rwbt.resultpopup), "Result Popup  not visible");

		waitThread(1000);
		// Click View button of Second question
		click(sasb.view_btn_q2);

		waitThread(4000);
		// Assert second question is selected on Wizard
		Assert.assertTrue(getAttribute(sasb.wizardq2, "class").contains("p-highlight"));

		// Click Exit button
		click(sasb.Exit_btn);

		// Assert the Result window popup
		waitThread(4000);
		Assert.assertTrue(isElementPresent(rwbt.resultpopup), "Result Popup  not visible");

	}

	/*
	 * To close the Result window and perform logout
	 */
	@Test(priority = 40)
	public void TCSPR1400340() throws InterruptedException {

		// Assert the close button of Result popup
		Assert.assertTrue(isElementPresent(sasb.resultopopup_close), "Close button not present");

		// Click close button
		JavaScriptclick(rwbt.resultpopupclosebtn);
		TimeUnit.SECONDS.sleep(10);

		// Assert current Assessments label
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

	}

	/*
	 * To perform Delete student1 Account functionality
	 */
	@Test(priority = 41)
	public void DeleteStudent1() {

		cr.DeleteAccount();

		waitThread(2000);

		// login using deleted account credentials
		lg.login(Emailstudent1, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student2 Account functionality
	 */
	@Test(priority = 42)
	public void DeleteStudent2() {

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
	 * To perform Delete student3 Account functionality
	 */
	@Test(priority = 43)
	public void DeleteStudent3() {

		// login using deleted account credentials
		lg.login1(Emailstudent3, password);
		waitThread(2000);
		cr.DeleteAccount();

		waitThread(2000);

		// login using deleted account credentials
		lg.login(Emailstudent3, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete Teacher Account functionality
	 */
	@Test(priority = 44)
	public void DeleteTeacher() {

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
