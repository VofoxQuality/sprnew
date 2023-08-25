package PeerReviewWindowofIndividualStudentTest;

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

import CommonFunctionalities.Test.CommonFileTest;
import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import CreateNewAssessment.Pages.AssessmentPublishPopupPage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CreateNewAssessment.Pages.SummaryQuestionsPage;
import CurrentAssessmentsforStudents.Pages.StudentCurrentAssessmentBasicsPage;
import CurrentAssessmentsforStudents.Pages.StudentPeerReviewPage;
import CurrentAssessmentsforStudents.Pages.StudentTestSectionPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.NewAssessmentTeacherBasicsPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import NewAssessmentOfTeacherPage.TeacherResultSectionPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowWizardPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import TestWindowOfIndividualStudent.ModifyWizardSectionPage;
import TestWindowOfIndividualStudent.TestWindowWizardPage;

public class PeerReviewWindowWizardTest extends basePage {

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
	CommonMethods cm = new CommonMethods();
	PeerReviewWindowWizardPage prw = new PeerReviewWindowWizardPage();
	StudentCurrentAssessmentBasicsPage sca = new StudentCurrentAssessmentBasicsPage();
	NewAssessmentTeacherBasicsPage natb = new NewAssessmentTeacherBasicsPage();
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
	public String CourseID;;
	public String CourseName;
	public String Emailstudent1;
	public String Emailstudent2;
	public String Emailstudent3;

	/*
	 * To perform Login functionality
	 */
	@Test(priority = 1)
	public void TCSPR1300101() throws SQLException {

		Emailteacher = cmt.SignUpTeacher();
		System.out.println(Emailteacher);

		// To catch OTP from sending Resource
		cmt.OtpFetch();

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	/*
	 * To create new course
	 */
	@Test(priority = 2)
	public void TCSPR1300102() throws SQLException {

		CourseName = "Course Name" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID = (getText(cn.course_Id));
		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent3 = "student3" + generateRandomNumber().trim() + "@gmail.com";

		// Invite students to course
		cm.Invitestudentstocourse_3(CourseName, Emailstudent1, Emailstudent2, Emailstudent3);
	}
	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 3)
	public void TCSPR1300103() {

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
	public void TCSPR1300104() throws SQLException {

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
	public void TCSPR1300105() {

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
	 * To check that invited course request visible on first student 's profile
	 * and accept course request-Read the student name
	 */
	@Test(priority = 6)
	public void TCSPR1300106() throws SQLException {

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
	public void TCSPR1300107() {

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

	@Test(priority = 8)
	public void TCSPR1300108() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent3, CourseID);

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
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());

	}
	/*
	 * To Accept course and perform logout functionality on the student profile
	 */

	@Test(priority = 9)
	public void TCSPR1300109() {

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

	@Test(priority = 10)
	public void TCSPR1300110() {

		SoftAssert softAssert1 = new SoftAssert();
		lg.login1(Emailteacher, password);
		waitThread(4000);
		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(12000);

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
	@Test(priority = 11)
	public void TCSPR1300111() {

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

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);
		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		ScrollTo_xy_position(0, -250);

		// Enter Max score
		type(QP.max_scorbx, "5");

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

		waitThread(6000);
		ScrollTo_Location(QP.Qassessmentdetails);

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

		ScrollTo_xy_position(0, -250);

		// Enter Max score
		type(QP.max_scorbx, "6");

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
	@Test(priority = 12)
	public void TCSPR1300112() {

		waitThread(2000);

		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);

		waitThread(1000);
		type(QP.Quest_box, "Question3");

		// Assert the question content on the question editor
		Assert.assertEquals(getText(QP.Quest_box), "Question3");
		driver.switchTo().defaultContent();

		waitThread(6000);
		ScrollTo_Location(QP.Qassessmentdetails);

		waitThread(3000);

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);
		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		ScrollTo_xy_position(0, -250);

		// Enter Max score
		type(QP.max_scorbx, "7");

		// Click on +button
		click(rd.add_quest_btn);
		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 3 Saved successfully");
		waitFor(QP.toasterclosebtn);
		click(QP.toasterclosebtn);

		waitThread(1000);
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);

		waitThread(1000);
		type(QP.Quest_box, "Question4");

		// Assert the question content on the question editor
		Assert.assertEquals(getText(QP.Quest_box), "Question4");
		driver.switchTo().defaultContent();

		waitThread(6000);
		ScrollTo_Location(QP.Qassessmentdetails);

		waitThread(1000);
		// Click Standard rubric radio button
		click(QP.std_rad);
		waitThread(1000);
		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);
		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R4");

		driver.switchTo().defaultContent();
		waitThread(1000);

		ScrollTo_xy_position(0, -250);

		// Enter Max score
		type(QP.max_scorbx, "5");

		MouseHover(QP.save);

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
	public void TCSPR1300113() {

		waitThread(5000);

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		waitThread(3000);
		// Select Answer Sheets Per Student =2
		click(prw.reviewans_sheetdropdwn);
		waitThread(2000);
		click(prw.reviewssheet_count);

		// Enter peer review Reward score 100
		waitThread(2000);
		type(prw.peer_reward_scorebx, "100");

	}

	/*
	 * To perform the save and next functionaity from peer review page and
	 * verify the schedule page details
	 */
	@Test(priority = 14)
	public void TCSPR1300114() {

		click(pr.savennext_button);
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);
		waitThread(2000);
		Assert.assertEquals(getAttribute(sb1.schedule_wizard, "aria-expanded"), "true");

	}

	/*
	 * To verify the details on the Summary page & publish the Assessment
	 */
	@Test(priority = 15)
	public void TCSPR1300115() {
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
	public void TCSPR1300116() {

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

	}

	/*
	 * To check the published Assessment card
	 */
	@Test(priority = 17)
	public void TCSPR1300117() {
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
	public void TCSPR1300118() {
		waitThread(5000);

		// Assert the the "Test Pending "
		// Assert.assertEquals(getText(tp.teststs_lbl), "Pending");

		// Assert the text "Students submitted"
		Assert.assertEquals(getText(st1.stud_compl_txt), "Students Submitted");
	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 19)
	public void TCSPR1300119() {
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
	public void TCSPR1300120() {
		// login as Student1
		lg.login1(Emailstudent1, password);

		waitThread(3000);

		// Click Assessment tab
		click(QP.Assessmenttab);

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

	}

	/*
	 * To Begin Test & add answers to questions by Student1
	 */
	@Test(priority = 21)
	public void TCSPR1300121() throws InterruptedException {

		// Wait till assessment active
		TimeUnit.MINUTES.sleep(2);

		// Assert the test status as active
		Assert.assertEquals(getText(tp.teststs_lbl), "Active");

		// Assert the button begin test
		Assert.assertTrue(isDisplayed(st1.begintest_btn), "Begin test not present");
		Assert.assertEquals(getText(st1.begintest_btn), "Begin Test");

		waitThread(2000);
		// Click Begin Test
		click(st1.begintest_btn);

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

		waitThread(1000);
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

		waitThread(1000);
		// Assert Second Question is answered
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("complete"));

		// Enter Answer3
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer3_Student1");

		driver.switchTo().defaultContent();
		waitThread(2000);

		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(1000);
		// Assert Third Question is answered
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("complete"));

		// Enter Answer4
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer4_Student1");

		driver.switchTo().defaultContent();

		// Assert Submit button
		Assert.assertTrue(isDisplayed(tsw.submit_btn), "Submit button not present");

	}

	/*
	 * To submit the Assessment and logout from Student1 profile
	 */
	@Test(priority = 22)
	public void TCSPR1300122() {

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
		waitThread(6000);
		// Assert the current Assessments
		Assert.assertEquals(getText(prw.current_assess_label), "Current Assessments");

		// Perform logout from Student1
		// logout functionality
		click("//div[@class='username']");
		waitThread(1000);
		click("//i[@class='pi pi-sign-out']");

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To Perform Login by Student2 and to Begin Test
	 */
	@Test(priority = 23)
	public void TCSPR1300123() {

		// login as Student2
		lg.login1(Emailstudent2, password);

		waitThread(4000);

		// Click Assessment tab
		click(QP.Assessmenttab);

		waitThread(8000);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(st1.Assess_name_card), AssessmentName);
		// Assert.assertTrue(getText(tp.course_lbl).contains("For
		// "+CourseName));
		waitThread(2000);
		// Click Begin Test
		click(st1.begintest_btn);

		// Assert the first question is highlighted on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));
		Assert.assertEquals(getText(tsw.quest_1_wizard), "1");

	}

	/*
	 * To Add answers to Second Question and 4th Question by student2
	 */
	@Test(priority = 24)
	public void TCSPR1300124() {

		waitThread(2000);

		// Click Save&Nextbutton
		click(QP.Savenext);
		waitThread(2000);
		// Assert first Question is unanswered
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("visitednotattended"));

		waitThread(1000);

		// Enter Answer2
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer2_Student2");

		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(2000);
		// Assert Second Question is answered
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("complete"));

		waitThread(1000);
		// Click Save&Nextbutton
		click(QP.Savenext);
		waitThread(3000);
		// Assert Third Question is unanswered
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("visitednotattended"));

		waitThread(1000);
		// Enter Answer4
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer4_Student2");

		driver.switchTo().defaultContent();
	}

	/*
	 * To submit the Assessment and logout from Student2 profile
	 */
	@Test(priority = 25)
	public void TCSPR1300125() {

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

		// click back to Assessments
		click(tsw.backtoassess_btn);

		waitThread(1000);
		Doubleclick(st1.stud_searchbx);
		waitThread(2000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the Questions answered count 2/4
		Assert.assertEquals(getText(tsw.ans_count), "2/4");

		// Perform logout from Student2
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform reschedule of Test Window and Peer Review window
	 */
	@Test(priority = 26)
	public void RescheduleTestAndPeerDate() {

		// Login as Teacher
		lg.login1(Emailteacher, cm.Password);

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(5000);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		// Search The Assessment Name
		type(sca.teacherassessmentsearchbox, AssessmentName.trim());
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
		cm.Logout();
	}

	/*
	 * To Perform Login by Student3 and wait till peer review active
	 */
	@Test(priority = 26)
	public void TCSPR1300126() throws InterruptedException {

		// Perform login by Student3
		lg.login1(Emailstudent3, password);

		waitThread(3000);

		// Click Assessment tab
		click(QP.Assessmenttab);

		waitThread(3000);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Wait till peer review active
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(50);

		// Assert Test window closed
		Assert.assertEquals(getText(st1.windowclosd), "Window Closed");

		// Assert peer review active
		Assert.assertEquals(getText(sp1.reviewpending_lbl), "Active");
	}

	/*
	 * To begin the Review & check the labels of peer review window
	 */
	@Test(priority = 27)
	public void TCSPR1300127() {

		// Assert the Begin Review button
		Assert.assertTrue(isDisplayed(st1.begintest_btn), "Begin Review not present");
		Assert.assertEquals(getText(st1.begintest_btn), "Begin Review");

		// Assert peer review % =0%
		Assert.assertEquals(getText(sp1.zeropercent_card), "0%");

		waitThread(2000);

		// Click Begin Review
		click(st1.begintest_btn);
		waitThread(2000);
		// Assert the Assessment name
		Assert.assertEquals(getText(tsw.test_window_assess_name), AssessmentName);

		waitThread(2000);
		// Assert the time status
		Assert.assertTrue(getText(tsw.time_status).contains("Peer Review Active for"));

	}

	/*
	 * To check the buttons of peer review window
	 */
	@Test(priority = 28)
	public void TCSPR1300128() {
		// Assert the total Questions, Total score
		Assert.assertTrue(getText(tsw.questions_count).contains("Total Questions"));
		Assert.assertTrue(getText(tsw.total_score).contains("Total Score"));
		waitThread(1000);

		// Assert the Buttons Save&Next, Save&Exit, Submit
		Assert.assertTrue(isDisplayed(QP.savenext_btn), "Save&Next button not present");
		Assert.assertEquals(getText(QP.savenext_btn), "Save & Next");

		Assert.assertTrue(isDisplayed(QP.savexit_btn), "Save&Exit button not present");
		Assert.assertEquals(getText(QP.savexit_btn), "Save & Exit");

		Assert.assertTrue(isDisplayed(tsw.submit_btn), "Submit button not present");
		Assert.assertEquals(getText(tsw.submit_btn), "Submit");

		// Assert the tooltips of buttons
		MouseHover(QP.savenext_btn);
		Assert.assertEquals(getAttribute(QP.savexit_btn, "ptooltip"), "Save & Exit");
		waitThread(1000);
		// Assert Save&Next button disabled
		waitThread(3000);
		// Assert Save&Next button disabled
		Assert.assertFalse(getAttribute(QP.savenext_btn, "class").contains("disabled-btn"));

		waitThread(2000);
		// Assert the max score of question1 with question page
		Assert.assertEquals(getText(prw.max_score_text), "Max Score: 5");

		// Assert the save button disable
		Assert.assertTrue(getAttribute(tsw.save_btn_test, "class").contains("disabled-btn"));

	}

	/*
	 * To check the question number wizard
	 */
	@Test(priority = 29)
	public void TCSPR1300129() {
		// Assert the question 1 is select on the wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));
		Assert.assertEquals(getText(tsw.quest_1_wizard), "1");

		waitThread(1000);
		// Assert the Text "Question No:1" , Max Score
		Assert.assertEquals(getText(tsw.quest1_text), "Question No: 1");
		Assert.assertEquals(getText(tsw.max_score_text), "Max Score: 5");

		// Assert the Question is same as that of question page
		driver.switchTo().frame("questionViewEditor_ifr");
		waitThread(1000);

		Assert.assertEquals(getText(tsw.quest_box1), quest1);

		driver.switchTo().defaultContent();

		waitThread(1000);
		// Assert the all question numbers are visible on wizard
		Assert.assertEquals(getText(tsw.quest_2_wizard), "2");
		Assert.assertEquals(getText(tsw.quest_3_wizard), "3");
		Assert.assertEquals(getText(tsw.quest_4_wizard), "4");

	}

	/*
	 * To check the rubric and labels of Peer review window
	 */
	@Test(priority = 30)
	public void TCSPR1300130() {

		// Assert the Rubric label
		Assert.assertEquals(getText(prw.rubric_accordian), "Rubric");

		// Click Rubric Accordian button
		click(prw.rubric_accordian);

		// Assert the added rubric visible on the page
		driver.switchTo().frame("standardRubricViewEditor_ifr");
		waitThread(1000);

		Assert.assertEquals(getText(prw.std_rub_bx), "R1");

		driver.switchTo().defaultContent();

		// Assert label "Answers from peer students"
		Assert.assertEquals(getText(prw.Answers_from_label), "Answers from Peer Students:");

		// Assert label Student One
		Assert.assertEquals(getText(prw.studentone_label), "Student One");

		// Assert StudentOne disabled
		Assert.assertTrue(getAttribute(prw.studentone_part, "class").contains("p-disabled"));

		// Assert label Student Two
		Assert.assertEquals(getText(prw.student2_label), "Student Two");

		waitThread(1000);
		// open the Answer box of Student Two
		click(prw.student2_label);

		driver.switchTo().frame("answerViewEditor_1_ifr");
		// Assert the Answer visible on the box
		Assert.assertTrue(isElementPresent(prw.ans_bx_stud2), "Answer Box of Student Two not visible");
		driver.switchTo().defaultContent();

		// Assert the score box of StudentTwo
		Assert.assertTrue(isDisplayed(prw.score_bx_stud2), "Score box of Student Two not present");
	}

	/*
	 * To check the Score box & Comment box of peer review window
	 */
	@Test(priority = 31)
	public void TCSPR1300131() {
		// Assert the placeholder of score box
		Assert.assertEquals(getAttribute(prw.score_bx_stud2, "placeholder"), "Score");

		// Assert the comment box of StudentTwo
		Assert.assertTrue(isDisplayed(prw.comment_bx_stud2), "Score box of student Two not present");

		// Assert the placeholder of Comment box
		Assert.assertEquals(getAttribute(prw.comment_bx_stud2, "placeholder"), "Click here to enter your comment");

	}

	/*
	 * To check the skipped review confirmation popup before submit
	 */
	@Test(priority = 32)
	public void TCSPR1300132() {
		// Assert first question selected on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));
		waitThread(1000);

		// Click second question wizard
		click(tsw.quest_2_wizard);

		waitThread(1000);
		MouseHover(tsw.quest_1_wizard);
		// Assert first question is Not Reviewd
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("visitednotattended"));

		waitThread(1000);
		// Click 3rd Question wizard
		click(tsw.quest_3_wizard);

		MouseHover(tsw.quest_2_wizard);
		waitThread(1000);
		// Assert second question Not Reviewd
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("visitednotattended"));

		waitThread(1000);
		// Click 4th question on Wizard
		click(tsw.quest_4_wizard);

		waitThread(1000);
		MouseHover(tsw.quest_3_wizard);
		// Assert Third question is Not Reviewd
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("visitednotattended"));

		waitThread(1000);
		// Click submit button
		click(tsw.submit_btn);
		waitThread(3000);

		Assert.assertTrue(isDisplayed(prw.conf_popup), "popup not visible");

		// Assert the text "You have 4 skipped evaluation(s)! Proceed to
		// submit?"
		Assert.assertEquals(getText(prw.conf_txt), "The review of 4 question(s) was skipped. Do you wish to proceed?");

		waitThread(1000);
		// Click cancel
		click(prw.conf_cancel_btn);

		waitThread(3000);
		// Assert no popup visible
		Assert.assertFalse(isElementPresent(prw.conf_popup), "popup visible");

	}

	/*
	 * To add score to the questions and check the functions of save button
	 */
	@Test(priority = 33)
	public void TCSPR1300133() {
		waitThread(1000);

		// Click First question on Wizard
		click(tsw.quest_1_wizard);

		// Assert the score box of StudentTwo is visible
		Assert.assertTrue(isDisplayed(prw.score_bx_stud2), "Score box of student Two not present");

		waitThread(1000);
		// Click score Box of StudentTwo
		click(prw.score_bx_stud2);

		// Enter the Score for StudentTwo
		type(prw.score_bx_stud2, "2");

		waitThread(3000);
		// Assert save button enabled
		// Assert.assertFalse(getAttribute(tsw.save_btn_test,
		// "class").contains("disabled-btn"));

		waitThread(1000);
		// Assert the comment box of StudentTwo enabled
		// Assert.assertFalse(getAttribute(prw.comment_bx_stud2,
		// "class").contains("disabled-btn"));

		waitThread(1000);

		waitThread(1000);
		// Assert score box of StudentOne disabled
		// Assert.assertTrue(getAttribute(prw.studentone_part,
		// "class").contains("p-disabled"));

		waitThread(2000);
		// Click Save button
		click(tsw.save_btn_test);

		// waitFor(QP.toaster);
		// Assert toaster "Score saved"
		// Assert.assertEquals(getText(QP.toaster), "Saved");
		// Assert.assertEquals(getText(QP.toaster), "Score Saved");
		// click(QP.toasterclosebtn);

		// MouseHover(tsw.quest_1_wizard);
		waitThread(1000);
		// Assert the first question on wizard as Reviewed
		// Assert.assertTrue(getAttribute(tsw.quest_1_wizard,
		// "class").contains("complete"));

	}

	/*
	 * To check the Not Reviewed status on Wizard
	 */
	@Test(priority = 34)
	public void TCSPR1300134() {
		waitThread(1000);

		// Click 2nd question on Wizard
		click(tsw.quest_2_wizard);

		waitThread(1000);
		// Assert the Second Question is selected on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("p-highlight"));
		waitThread(2000);
		// Assert Save button is disabled
		Assert.assertTrue(getAttribute(tsw.save_btn_test, "class").contains("disabled-btn"));

		// Assert the save&Next button enabled
		Assert.assertFalse(getAttribute(QP.savenext_btn, "class").contains("disabled-btn"));

		// Assert the score box of student1 is empty
		Assert.assertEquals(getValue(prw.score_bx_stud1), "");

		// Assert the score box of student2 is empty
		Assert.assertEquals(getValue(prw.score_bx_stud2), "");

		waitThread(1000);
		// Click 4th question on Wizard
		click(tsw.quest_4_wizard);

		MouseHover(tsw.quest_2_wizard);
		// Assert the Second question on wizard as Not Reviewed
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("visitednotattended"));

		// Assert the 4th question selected on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_4_wizard, "class").contains("p-highlight"));

	}

	/*
	 * To check the incomplete Review status on wizard
	 */
	@Test(priority = 35)
	public void TCSPR1300135() {

		waitThread(1000);
		// Click score Box of StudentOne
		click(prw.score_bx_stud1);

		// Enter Score for Student One
		type(prw.score_bx_stud1, "2");

		waitThread(3000);
		// Assert Comment box of StudentOne enabled
		Assert.assertFalse(getAttribute(prw.comment_bx_stud1, "class").contains("disabled-btn"));

		waitThread(1000);
		click(prw.comment_bx_stud1);

		waitThread(2000);
		// Enter comment for Student1
		click(prw.txtbx_comment);
		type(prw.txtbx_comment, "Comments");
		click(prw.commentsave_btn);

		waitThread(2000);
		// Assert the Scorebox of student2 is empty
		Assert.assertEquals(getValue(prw.score_bx_stud2), "");

		waitThread(1000);
		// Click 3rd question on wizard
		click(tsw.quest_3_wizard);

		waitFor(QP.toaster);
		// Assert toaster "Score saved"
		// Assert.assertEquals(getText(QP.toaster), "Please enter a score for
		// all the students for whom you entered a comment.");

		click(QP.toasterclosebtn);

		// MouseHover(tsw.quest_4_wizard);
		waitThread(1000);
		// Assert the Wizard status of Forth question as "Incomplete Review"
		// Assert.assertTrue(getAttribute(tsw.quest_4_wizard,
		// "class").contains("incomplete"));

	}

	/*
	 * To check the submit button & confirmation popup of incomplete & skipped
	 * Reviews
	 */
	@Test(priority = 36)
	public void TCSPR1300136() {
		waitThread(1000);
		// Click 4th question on Wizard
		click(tsw.quest_4_wizard);

		waitThread(3000);
		// Assert Save&Next button disabled
		Assert.assertTrue(getAttribute(QP.savenext_btn, "class").contains("disabled-btn"));

		waitThread(1000);
		// Assert Submit button
		Assert.assertTrue(isDisplayed(tsw.submit_btn), "Submit button not present");
		Assert.assertEquals(getText(tsw.submit_btn), "Submit");

		waitThread(1000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(2000);

		// Assert Confirmation popup visible
		Assert.assertTrue(isDisplayed(prw.conf_popup), "popup not visible");

		waitThread(1000);
		// Assert the text "There are incomplete evaluation/skipped evaluation,
		// do you
		// want to proceed ?""
		// Assert.assertEquals(getText(prw.conf_txt),"You have 4 skipped
		// evaluation(s)! Proceed to submit?");

		waitThread(1000);
		// Assert the cancel & submit button on popup
		Assert.assertTrue(isDisplayed(prw.conf_cancel_btn), "Cancel button not present");
		Assert.assertEquals(getText(prw.conf_cancel_btn), "Cancel");
		Assert.assertTrue(isDisplayed(prw.conf_submit_btn), "Submit button not present");
		Assert.assertEquals(getText(prw.conf_submit_btn), "Submit");

		waitThread(1000);
		// Click cancel
		click(prw.conf_cancel_btn);

		waitThread(3000);
		// Assert no popup visible
		Assert.assertFalse(isElementPresent(prw.conf_popup), "popup visible");

	}

	/*
	 * To check the submit button & confirmation popup of incomplete review
	 */
	@Test(priority = 37)
	public void TCSPR1300137() {

		waitThread(2000);
		// Click 2nd question on Wizard
		click(tsw.quest_2_wizard);

		waitThread(2000);
		click(prw.score_bx_stud1);
		// Enter Score for Student One
		type(prw.score_bx_stud1, "3");

		click(prw.score_bx_stud2);
		// Enter Score for Student Two
		type(prw.score_bx_stud2, "1");

		waitThread(2000);
		// Click Save &Next button
		click(QP.savenext_btn);

		// Assert toaster "Score saved"
		waitFor(QP.toaster);
		// Assert.assertEquals(getText(QP.toaster), "Score Saved");

		// click(QP.toasterclosebtn);
		waitThread(1000);

		MouseHover(tsw.quest_2_wizard);
		// Assert the Second question wizard is Reviewed
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("complete"));

		// Assert the 3rd question selected on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("p-highlight"));

		// Enter Score for Student Two
		click(prw.score_bx_stud2);
		type(prw.score_bx_stud2, "3");

		waitThread(4000);
		// Assert the Student One part is disabled
		Assert.assertTrue(getAttribute(prw.studentone_part, "class").contains("p-disabled"));

		waitThread(1000);
		// MouseHover(tsw.quest_4_wizard);

		// Assert the Forth question wizard is incomplete Review
		// Assert.assertTrue(getAttribute(tsw.quest_4_wizard,
		// "class").contains("incomplete"));

		waitThread(2000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(1000);
		// Assert confirmationn popup visible
		Assert.assertTrue(isDisplayed(prw.conf_popup), "popup not visible");

		waitThread(1000);
		// Assert the text "Are you sure you want to submit the review?"
		// Assert.assertEquals(getText(prw.conf_txt), "You have 1 review(s) as
		// incomplete! Proceed to submit?");
		// Assert.assertEquals(getText(prw.conf_txt), "There are incomplete
		// evaluation/skipped evaluation, do you want to proceed ?");
		waitThread(1000);
		// Click cancel
		click(prw.conf_cancel_btn);

		waitThread(3000);
		// Assert no popup visible
		Assert.assertFalse(isElementPresent(prw.conf_popup), "popup visible");

	}

	/*
	 * To complete all peer review and check the confirmation popup
	 */
	@Test(priority = 38)
	public void TCSPR1300138() {
		waitThread(1000);
		// Click 4th question on wizard
		click(tsw.quest_4_wizard);

		click(prw.score_bx_stud2);
		// Enter Score for Student Two
		type(prw.score_bx_stud2, "3");

		waitThread(1000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(2000);
		// Assert confirmationn popup visible
		Assert.assertTrue(isDisplayed(prw.conf_popup), "popup not visible");

		waitThread(1000);
		// Assert the text "Are you sure you want to submit the review?"
		// Assert.assertEquals(getText(prw.conf_txt), "You have 2 skipped
		// evaluation(s)! Proceed to submit?");

		waitThread(1000);
		// Click submit button
		click(prw.conf_submit_btn);

		// Assert toaster "Peer Review Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);

	}

	/*
	 * To check the submit popup
	 */
	@Test(priority = 39)
	public void TCSPR1300139() {

		waitThread(1000);
		// Assert the back to Assessments button
		// Assert.assertTrue(isDisplayed(prw.backto_btn), "Back to Assessments
		// button not present");
		// Assert.assertEquals(getText(prw.backto_btn), "Back to Assessments");

		waitThread(1000);
		// Click back to Assessments
		click(prw.backto_btn);
		waitThread(8000);
		// search assessments
		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(8000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the % as 100% peer review completed
		// Assert.assertEquals(getText(sp1.zeropercent_card), "67%");

	}

	/*
	 * To perform delete account functionality on Student3 profile
	 */
	@Test(priority = 49)
	public void TCSPR1300649() {

		waitThread(3000);
		cr.DeleteAccount();

		// Heading Title-Login
		// Assert.assertEquals(getText(lg.PageTitle), "Login");

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

		// Heading Title-Login
		// Assert.assertEquals(getText(lg.PageTitle), "Login");

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

		// Heading Title-Login
		// Assert.assertEquals(getText(lg.PageTitle), "Login");

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

		// Heading Title-Login
		// Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

		// login using deleted account credentials
		lg.login(Emailteacher, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

}
