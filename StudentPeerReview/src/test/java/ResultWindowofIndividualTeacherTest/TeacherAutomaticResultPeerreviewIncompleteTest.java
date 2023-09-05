package ResultWindowofIndividualTeacherTest;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;
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
import CurrentAssessmentsforStudents.Pages.StudentPeerReviewPage;
import CurrentAssessmentsforStudents.Pages.StudentResultSectionPage;
import CurrentAssessmentsforStudents.Pages.StudentTestSectionPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherResultSectionPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowWizardPage;
import ResultWindowforIndividualStudent.Page.StudentAnswerSheetBasicsPage;
import ResultWindowforIndividualStudent.Page.StudentResultWindowBasicsPage;
import ResultWindowofIndividualTeacherPage.TeacherAutomaticResultPeerreviewIncompletePage;
import ResultWindowofIndividualTeacherPage.TeacherAutomaticResultreviewcompletePage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import TestWindowOfIndividualStudent.AssessmentSubmitAndStatusPopUpPage;
import TestWindowOfIndividualStudent.ModifyWizardSectionPage;
import TestWindowOfIndividualStudent.TestWindowWizardPage;

public class TeacherAutomaticResultPeerreviewIncompleteTest extends basePage {
	LoginPage lg = new LoginPage();
	CommonMethods cm = new CommonMethods();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	PeerReviewWindowWizardPage prw = new PeerReviewWindowWizardPage();
	SchedulePageBasicsPage sb1 = new SchedulePageBasicsPage();
	SummaryBasicsPage sb = new SummaryBasicsPage();
	TeacherTestSectionPage tts = new TeacherTestSectionPage();
	StudentTestSectionPage st1 = new StudentTestSectionPage();
	ModifyWizardSectionPage ms = new ModifyWizardSectionPage();
	AssessmentSubmitAndStatusPopUpPage asp = new AssessmentSubmitAndStatusPopUpPage();
	TestWindowWizardPage tsw = new TestWindowWizardPage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	PeerReviewWindowPage prp = new PeerReviewWindowPage();
	StudentPeerReviewPage sp1 = new StudentPeerReviewPage();
	StudentResultWindowBasicsPage rwbt = new StudentResultWindowBasicsPage();
	TeacherResultSectionPage tr = new TeacherResultSectionPage();
	StudentResultSectionPage srs = new StudentResultSectionPage();
	StudentAnswerSheetBasicsPage sasb = new StudentAnswerSheetBasicsPage();
	TeacherAutomaticResultreviewcompletePage arv = new TeacherAutomaticResultreviewcompletePage();
	TeacherAutomaticResultPeerreviewIncompletePage ari = new TeacherAutomaticResultPeerreviewIncompletePage();
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
	public String Answerstud1 = "Answer1_Student1";
	public String Answerstud2 = "Answer2_Student1";
	public String Comment1 = "Comment_student1";
	public String Comment2 = "Comment_student2";
	public String Comment3 = "Comment_student3";
	public String AssessmentName;
	public String Question1 = "Question1";
	public String Question2 = "Question2";
	public String Question3 = "Question3";
	public String Rubric1 = "Rubric1";
	public String Rubric2 = "Rubric2";
	public String Rubric3 = "Rubric3";
	public String Maxscore1 = "10";
	public String Maxscore2 = "20";
	public String Maxscore3 = "30";
	public String Student1name = "Ashley Albert";
	public String Student2name = "Ben Max";
	public String Student3name = "Clara April";
	public String stud1ans1 = "Answer 1";

	/*
	 * To perform SignUp functionality
	 */
	@Test(priority = -7)
	public void TeacherSignUp() throws SQLException {

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
	@Test(priority = -6)
	public void Teachercoursecreation() throws SQLException {

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

	@Test(priority = 1, dependsOnMethods = { "student3signup" })
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
	public void TCSPR1500202() {

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
		softAssert1.assertAll();

	}

	/*
	 * To fill details for Question 1
	 */
	@Test(priority = 3)
	public void TCSPR1500203() {

		// Type Question 1
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		type(QP.Quest_box, Question1);
		driver.switchTo().defaultContent();

		// Page Scroll down
		QP.Scroll_DowntoEnd();

		// Type data in Standard Rubric box
		driver.switchTo().frame("rubric_ifr");
		type(QP.std_rub_bx, Rubric1);
		driver.switchTo().defaultContent();
		waitThread(1000);

		// Type Sample answer
		click(QP.sample_ans_btn);
		driver.switchTo().frame("sampleAnswer_ifr");
		type(QP.sample_ansbx, "Sample answer");
		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, Maxscore1);

		MouseHover(QP.save);

		waitThread(2000);
		// Click on +button
		click(rd.add_quest_btn);
		waitFor(QP.toaster);

		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);

	}

	/*
	 * To fill details for Question 2
	 */
	@Test(priority = 4)
	public void TCSPR1500204() {

		// Type Question 2
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		type(QP.Quest_box, Question2);
		driver.switchTo().defaultContent();

		// Page Scroll down
		QP.Scroll_DowntoEnd();

		// Type data in Standard Rubric box
		driver.switchTo().frame("rubric_ifr");
		type(QP.std_rub_bx, "R2");
		driver.switchTo().defaultContent();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, Maxscore2);

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
	 * To fill details for Question 3
	 */
	@Test(priority = 5)
	public void TCSPR1500205() {

		waitThread(2000);
		// Type Question 3
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		type(QP.Quest_box, Question3);
		driver.switchTo().defaultContent();

		// Page Scroll down
		QP.Scroll_DowntoEnd();

		// Type data in Standard Rubric box
		driver.switchTo().frame("rubric_ifr");
		type(QP.std_rub_bx, Rubric3);
		driver.switchTo().defaultContent();

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, Maxscore3);

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

	public String RewardPercent = "100";

	/*
	 * To verify the details on the peer review page
	 */

	@Test(priority = 6)
	public void TCSPR1500206() {

		waitThread(4000);
		// Enter peer review Reward score
		type(prw.peer_reward_scorebx, RewardPercent);

		waitThread(4000);
		// Assert the text::Total Students : Assert the total student count is 3
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 3");

		// Assert the 3 student names
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Student1name.trim());
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Student2name.trim());
		Assert.assertEquals(getText(ps.studantname3_gridval).trim(), Student3name.trim());

	}

	/*
	 * To perform the save and next functionaity from peer review page and
	 * verify the schedule page details
	 */
	@Test(priority = 7)
	public void TCSPR1500207() {

		// Click Save&Next button
		click(pr.savennext_button);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);

		waitThread(2000);
		Assert.assertEquals(getAttribute(sb1.schedule_wizard, "aria-expanded"), "true");

		// Assert the text "Select schedules for "
		Assert.assertEquals(getText(sb1.selectstu_lbl), "Select Schedules for");

		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");

	}

	/*
	 * To perform Assessment publish functionality and check the details on the
	 * publish popup
	 */
	public String TotalTestPoints;
	public int TotalTestPoints1;
	public String rewarscoreQ1;
	public String rewarscoreQ2;
	public String rewarscoreQ3;
	public String rewarscoreQ4;
	public int TotalRewardScore;
	public String TotalRewardScore1;
	public String quest_count;
	public String maxscoreposs1;

	@Test(priority = 8)
	public void TCSPR1500208() {

		quest_count = "3";
		// Assert the Total Questions: 3
		Assert.assertEquals(getText(sb.valuetotalQuestion), quest_count);

		// To get The Total Test Points
		TotalTestPoints1 = Integer.parseInt(Maxscore1) + Integer.parseInt(Maxscore2) + Integer.parseInt(Maxscore3);

		TotalTestPoints = Integer.toString(TotalTestPoints1);
		System.out.println(TotalTestPoints);

		// To verify Total Test Points
		Assert.assertEquals(getText(sb.valueTotaltestpoints), TotalTestPoints);

		// To calculate Reward Score for Question 1
		rewarscoreQ1 = cm.getrewardscoreforquestion(Maxscore1, RewardPercent);

		// To calculate Reward Score for Question 2
		rewarscoreQ2 = cm.getrewardscoreforquestion(Maxscore2, RewardPercent);

		// To calculate Reward Score for Question 3
		rewarscoreQ3 = cm.getrewardscoreforquestion(Maxscore3, RewardPercent);

		// Calculating Total Peer Review points
		TotalRewardScore = cm.StringtoInt(rewarscoreQ1) + cm.StringtoInt(rewarscoreQ2) + cm.StringtoInt(rewarscoreQ3);
		TotalRewardScore1 = Integer.toString(TotalRewardScore);

		System.out.println("Total Reward Score=" + TotalRewardScore);

		int maxscorepossible1 = TotalRewardScore + TotalTestPoints1;
		maxscoreposs1 = String.valueOf(maxscorepossible1);

		// To verify the Maximum Score Possible value
		Assert.assertEquals(getText(sb.valuemaxscore), Integer.toString(maxscorepossible1));

		// click on Release Button
		click(sb.btnrelease);

		// Assert button Back to Menu
		Assert.assertTrue(isElementPresent(tts.back_to_menubutton), "Back to menu button not present");

	}

	/*
	 * To check the back to menu button functionality and check the created
	 * assessment visible on the current assessment tab
	 */
	@Test(priority = 9)
	public void TCSPR1500209() throws InterruptedException {

		waitThread(2000);
		// Click Back to Menu
		click(tts.back_to_menubutton);

		waitThread(3000);

		// Assert the text "Assessments "
		Assert.assertEquals(getText(ba.lbl_assessment), "Assessments");

		click(st1.assess_searchbx);
		// search the assessment
		type(st1.assess_searchbx, AssessmentName);

		// Assert the newly published card visible on the current assessment
		// page
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(60);
		// Perform logout functionality from Teacher profile
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform Login functionality of student1 profile and check the
	 * Assessment card To begin the test & check the labels of test window
	 */
	@Test(priority = 10)
	public void TCSPR1500210() {
		// Login to Student1
		lg.login1(Emailstudent1, cm.Password);

		waitThread(3000);
		// Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		// Search Assessment name
		Doubleclick(st1.stud_searchbx);
		type(st1.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		waitThread(3000);
		// Click Begin Test
		click(st1.begintest_btn);

		waitThread(5000);
		// verify the assessment name
		Assert.assertEquals(getText(asp.testassessmentname), AssessmentName.trim());

	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 11)
	public void TCSPR1500211() {

		// Enter Answer1
		driver.switchTo().frame("answer_ifr");
		type(tsw.answer_bx, stud1ans1);
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Savebutton
		click(tsw.save_btn_test);

		// Click question2
		click(tsw.quest_2_wizard);

		// Second Question is selected
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("p-highlight"));

		// Type Answer2
		driver.switchTo().frame("answer_ifr");
		type(tsw.answer_bx, "Answer 2_" + generateRandomData());
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Savebutton
		click(tsw.save_btn_test);

		waitFor(QP.toaster);
		// Assert Toaster Answer saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");
		click(QP.toasterclosebtn);

		// Click question3
		click(tsw.quest_3_wizard);

		// Third Question is selected
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("p-highlight"));

		// Type Answer3
		driver.switchTo().frame("answer_ifr");
		type(tsw.answer_bx, "Answer 3_" + generateRandomData());
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Savebutton
		click(tsw.save_btn_test);

		waitFor(QP.toaster);
		// Assert Toaster Answer saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

	}

	/*
	 * To perform assessment submit functionality on the student profile To
	 * perform logout functionality on the Student 1 profile
	 */
	@Test(priority = 12)
	public void TCSPR1500212() {

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

		waitThread(5000);
		// Assert the current Assessments
		Assert.assertEquals(getText(prw.current_assess_label), "Current Assessments");

		waitThread(3000);
		// Search Assessment
		Doubleclick(st1.stud_searchbx);
		waitThread(2000);

		// To perform logout functionality on the Student 1 profile
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform Login functionality of student 2 profile and check the
	 * Assessment card
	 */
	@Test(priority = 13)
	public void TCSPR1500213() {
		waitThread(2000);
		// login as Student2
		lg.login1(Emailstudent2, cm.Password);

		waitThread(6000);

		// verify heading label current Assessments
		Assert.assertEquals(getText(QP.current_assesslabel), "Current Assessments");

		waitThread(5000);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		click(st1.stud_searchbx);
		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");
		waitThread(3000);

		// Click Begin Test
		click(st1.begintest_btn);

		waitThread(3000);
		// Assert the first question is highlighted on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));

	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 14)
	public void TCSPR1500214() {

		// Enter Answer1
		driver.switchTo().frame("answer_ifr");
		type(tsw.answer_bx, stud1ans1);
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Savebutton
		click(tsw.save_btn_test);

		// Click question2
		click(tsw.quest_2_wizard);

		// Second Question is selected
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("p-highlight"));

		// Type Answer2
		driver.switchTo().frame("answer_ifr");
		type(tsw.answer_bx, "Answer 2_" + generateRandomData());
		driver.switchTo().defaultContent();

	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 15)
	public void TCSPR1500215() {
		waitThread(2000);
		// Click Savebutton
		click(tsw.save_btn_test);

		// Click question3
		click(tsw.quest_3_wizard);

		// Third Question is selected
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("p-highlight"));

		// Type Answer3
		driver.switchTo().frame("answer_ifr");
		type(tsw.answer_bx, "Answer 3_" + generateRandomData());
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Savebutton
		click(tsw.save_btn_test);

		waitFor(QP.toaster);
		// Assert Toaster Answer saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

	}

	/*
	 * To perform assessment submit functionality on the student profile To
	 * perform logout functionality on the Student 2 profile
	 */
	public String quest_anscount;

	@Test(priority = 16)
	public void TCSPR1500216() throws InterruptedException {

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

		waitThread(4000);
		// Assert the current Assessments
		Assert.assertEquals(getText(prw.current_assess_label), "Current Assessments");

		waitThread(4000);
		// Search Assessment
		Doubleclick(st1.stud_searchbx);
		waitThread(2000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		TimeUnit.SECONDS.sleep(10);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		quest_anscount = getText(tsw.ans_count);

		// Assert the Test attended count
		Assert.assertEquals(getText(tsw.ans_count), quest_anscount);

		// To perform logout functionality on the Student 2 profile
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}
	/*
	 * To perform Login functionality of student 3 profile and check the
	 * Assessment card
	 */

	@Test(priority = 17)
	public void TCSPR1500217() {

		// Perform login by Student3
		lg.login1(Emailstudent3, cm.Password);

		waitThread(4000);

		// verify heading label current Assessments
		Assert.assertEquals(getText(QP.current_assesslabel), "Current Assessments");

		waitThread(4000);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 18)
	public void TCSPR1500218() {

		waitThread(2000);
		// Click Begin Test
		click(st1.begintest_btn);

		waitThread(3000);

		// Enter ANswer1
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);
		type(asp.Answertextbx, "Answer 1_" + generateRandomData());
		waitThread(1000);
		driver.switchTo().defaultContent();

		// Click on save Button
		click(asp.testbtnsave);
		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");
		click(QP.toasterclosebtn);
		waitThread(3000);

		ScrollTo_xy_position(0, 150);
		// click on Answer 2 wizard
		click(asp.wizardans2);
		waitThread(3000);

		// To fill the Answer 2
		// To enter the data on Question box
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);
		type(asp.Answertextbx, "Answer 2_" + generateRandomData());
		waitThread(1000);
		driver.switchTo().defaultContent();

	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 19)
	public void TCSPR1500219() {

		waitThread(2000);
		// Click on save Button
		click(asp.testbtnsave);
		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");
		click(QP.toasterclosebtn);
		waitThread(3000);

		// Click question3
		click(tsw.quest_3_wizard);

		ScrollTo_xy_position(0, 150);
		MouseHover(tsw.save_btn_test);

		// Type Answer3
		driver.switchTo().frame("answer_ifr");
		type(tsw.answer_bx, "Answer 3_" + generateRandomData());
		driver.switchTo().defaultContent();

	}

	/*
	 * To perform assessment submit functionality on the student profile To
	 * perform logout functionality on the Student 3 profile
	 * 
	 */
	@Test(priority = 20)
	public void TCSPR1500220() {

		waitThread(2000);
		// Click Savebutton
		click(tsw.save_btn_test);

		waitFor(QP.toaster);
		// Assert Toaster Answer saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);
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

		waitThread(4000);
		// Assert the current Assessments
		Assert.assertEquals(getText(prw.current_assess_label), "Current Assessments");

		waitThread(6000);

		// To perform logout functionality on the Student 3 profile
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * Login as Teacher and Reschedule the Test due and peer review start date
	 * To perform Login functionality of student 1 profile and check the
	 * Assessment card
	 * 
	 */
	@Test(priority = 21)
	public void TCSPR1500221() throws InterruptedException {

		// Login to Teacher profile
		cm.login(Emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// Click Assessment tab
		click(QP.teach_assesstab);

		waitThread(6000);

		click(st1.assess_searchbx);
		// search newly created assessment
		type(st1.assess_searchbx, AssessmentName);

		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");

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

		waitThread(6000);

		// logout functionality
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);
		// Login to Student1
		lg.login1(Emailstudent1, cm.Password);

		waitThread(4000);
		// Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		type(st1.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Wait till peer review active
		TimeUnit.MINUTES.sleep(2);

		waitThread(2000);

		// Click Begin Review
		click(st1.begintest_btn);

		waitThread(5000);

		// Assert the first Question is selected
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));

	}

	/*
	 * To perfrom review for Question 1 and Question 2
	 */
	@Test(priority = 22)
	public void TCSPR1500222() {

		ScrollTo_xy_position(0, 300);
		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "5");

		// click on save and next button
		click(prp.reviewbtnsaveandnext);
		waitFor(QP.toaster);

		// verify the toaster "Score Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);

		// verify the Question 2 is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));

		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "10");

		waitThread(2000);
		// click on save and next button
		click(prp.reviewbtnsaveandnext);

		waitFor(QP.toaster);
		// verify the toaster "Score Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);

	}

	/*
	 * To perform review for Question 3 and submit the Review To perform logout
	 * functionality on the Student 1 profile
	 */
	@Test(priority = 23)
	public void TCSPR1500223() {

		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "10");

		// click submit button
		click(ms.submit_btn);
		waitThread(1000);
		Assert.assertTrue(isDisplayed(prp.confir_popup), "popup not visible");
		waitThread(2000);
		click(prp.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Peer Review Submitted"
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);
		// Click on Back to Assessment
		click(prp.reviewbactoassessmentbtn);
		waitThread(2000);

		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		waitThread(6000);

		// logout functionality
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform Login functionality of student 2 profile and check the
	 * Assessment card
	 */
	@Test(priority = 24)
	public void TCSPR1500224() {
		// Login to Student2
		lg.login1(Emailstudent2, cm.Password);

		waitThread(6000);
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

		waitThread(5000);

		// Assert the first Question is selected
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));

	}

	/*
	 * To perform review for Question 1
	 */
	public String S2Q1ScorefroStud1 = "1";

	@Test(priority = 25)
	public void TCSPR1500225() {
		Scroll_DowntoEnd();
		waitThread(2000);

		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(2000);
		type(prp.scorestud1, S2Q1ScorefroStud1);

		waitThread(1000);
		// Click Comment box
		click(prp.stud1comment);

		waitThread(2000);
		// Type Comment for student 1
		type(prp.txtbx_comment, "Comment1");

		waitThread(2000);
		// click on comment save button
		click(prp.commentsave_btn);
		waitThread(2000);

		// Assert the added comment on the box
		Assert.assertEquals(getValue(prp.stud1comment), "Comment1");
		waitThread(2000);

	}

	/*
	 * To perform review submit the Review To perform logout functionality on
	 * the Student 2 profile
	 */
	@Test(priority = 26)
	public void TCSPR1500226() {

		// click submit button
		click(ms.submit_btn);
		waitThread(1000);
		Assert.assertTrue(isDisplayed(prp.confir_popup), "popup not visible");
		waitThread(2000);
		click(prp.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Peer Review Submitted"
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");
		click(QP.toasterclosebtn);

		// Click on Back to Assessment
		click(prp.reviewbactoassessmentbtn);
		waitThread(2000);

		// Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		waitThread(6000);

		// logout functionality
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform Login functionality of student 3 profile and check the
	 * Assessment card
	 */
	@Test(priority = 27)
	public void TCSPR1500227() {

		// Login to Student3
		lg.login1(Emailstudent3, cm.Password);

		waitThread(5000);
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

		waitThread(5000);

		// Assert the first Question is selected
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));

	}

	/*
	 * To perform review for Question 1 and Question 2
	 */
	@Test(priority = 28)
	public void TCSPR1500228() {

		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "5");

		// click on save and next button
		click(prp.reviewbtnsaveandnext);
		waitFor(QP.toaster);

		// verify the toaster "Score Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);

		// verify the Question 2 is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));

		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "10");

		waitThread(2000);
		// click on save and next button
		click(prp.reviewbtnsaveandnext);

		waitFor(QP.toaster);
		// verify the toaster "Score Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);

	}

	/*
	 * To perfrom review for Question 3 and submit the Review To perform logout
	 * functionality on the Student 3 profile
	 */
	@Test(priority = 29)
	public void TCSPR1500229() {

		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "10");

		// click submit button
		click(ms.submit_btn);
		waitThread(1000);
		Assert.assertTrue(isDisplayed(prp.confir_popup), "popup not visible");
		waitThread(2000);
		click(prp.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Peer Review Submitted"
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);
		// Click on Back to Assessment
		click(prp.reviewbactoassessmentbtn);
		waitThread(2000);

		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		waitThread(7000);

		// logout functionality
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * Perform teacher login and reschedule the peer review and result date
	 */
	@Test(priority = 30)
	public void TCSPR1500230() throws InterruptedException {

		// Login to Teacher profile
		cm.login(Emailteacher, cm.Password);

		// Click Assessment tab
		click(QP.teach_assesstab);

		waitThread(5000);

		// search assessment
		type(st1.assess_searchbx, AssessmentName);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");
		waitThread(3000);

		// click menu button
		click(rd.threedot_btn);

		waitThread(1000);
		// click reschedule dates
		click(rd.reschedulemenu);
		waitThread(1000);

		// Set Peer review due date & Result date as Todays date
		Doubleclick(rd.peerreviewduedate_txtbx);
		cm.ClickTodaysDate();

		Doubleclick(rd.resultpublishdate_txtbx);
		cm.ClickTodaysDate();

		waitThread(2000);
		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitThread(6000);

		Doubleclick(st1.assess_searchbx);
		// search assessment
		type(st1.assess_searchbx, AssessmentName);
		// search newly created assessment
		driver.findElement(By.id("searchAssessments")).sendKeys("   ");
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(30);

	}

	/*
	 * To verify the result section Labels
	 */
	@Test(priority = 31)
	public void TCSPR1500231() throws InterruptedException {

		// wait till button is Enabled
		TimeUnit.MINUTES.sleep(2);
		driver.navigate().refresh();

		// search assessment
		click(st1.assess_searchbx);
		type(st1.assess_searchbx, AssessmentName);
		waitThread(6000);
		// Assert the button Label :view result
		Assert.assertEquals(getText(arv.viewresult_teachcard), "Evaluate Answers");

		// Assert the View result Button is Enabled
		Assert.assertTrue(isEnabled(arv.viewresultbtn), "View result button is disabled");

		// Assert Label Result Upcoming
		Assert.assertEquals(getText(tts.time_status), "Result Upcoming");

		// Assert Label Pending
		Assert.assertEquals(getText(tr.resultsts_lbl), "Pending");

		// Assert Label -"You need to manually publish the result"
		// "No of Answer sheets pending for evaluation: 1"
		Assert.assertEquals(getText(ari.teach_manually_txt), "You need to manually publish the result");
		// Assert.assertEquals(getText(ari.answrsheet_evalu_txt), "No of Answer
		// sheets pending for evaluation: 1");

		// Assert the Button and Button label Evaluate Answers
		Assert.assertTrue(isDisplayed(arv.viewresult_teachcard), "Evaluate Answers button not present");
		Assert.assertEquals(getText(arv.viewresult_teachcard), "Evaluate Answers");

	}

	/*
	 * Perform Logout Functionality on the Teacher Account and Login the Student
	 * Page and check the Card result status
	 */
	@Test(priority = 32)
	public void TCSPR1500232() {

		// To perform logout functionality from Teacher account
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// Perform login by Student3
		lg.login1(Emailstudent3, cm.Password);
		waitThread(4000);

		// verify heading label current Assessments
		Assert.assertEquals(getText(QP.current_assesslabel), "Current Assessments");

		waitThread(3000);
		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(6000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert Label Result Upcoming
		Assert.assertEquals(getText(ari.stud_cardhead_lbl), "Result Upcoming");

		// Assert the Label Results are under consideration
		Assert.assertEquals(tr.getText(tr.resultpublishdate_lbl), "Teacher is reviewing this assessment and results are pending");

		// To perform logout functionality on the Student 3 profile
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * Perform Teacher Login and check the Evaluate Answer Button Functionality
	 * and check the back Button
	 * 
	 */
	@Test(priority = 33)
	public void TCSPR1500233() {

		// Login to Teacher profile
		cm.login(Emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// Click Assessment tab
		click(QP.teach_assesstab);

		waitThread(5000);

		click(st1.assess_searchbx);
		// search newly created assessment
		type(st1.assess_searchbx, AssessmentName);

		waitThread(3000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");

		// Click on Evaluate Answer Button
		click(arv.viewresult_teachcard);

		waitThread(4000);
		// Assert The Heading Label Evaluate answer sheets and Publish result
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Evaluate answer sheets and Publish result");

		// Assert the Back Button
		Assert.assertEquals(getText(arv.back_btn), "Back");

		// Click the Back Button
		click(arv.back_btn);

		waitThread(3000);
		// Assert the Current Tab is selected
		Assert.assertTrue(isDisplayed(arv.current_tab), "Current tab not present");

	}

	/*
	 * To check that the assessment listed in pending evaluation tab
	 */
	@Test(priority = 34)
	public void TCSPR1500234() throws InterruptedException {

		TimeUnit.SECONDS.sleep(10);

		// Click on Pending Evaluation Tab
		Doubleclick(arv.pending_ev_tab);

		waitThread(5000);
		// Assert the pending evaluation tab is selected
		Assert.assertEquals(getAttribute(arv.pending_ev_tab, "aria-selected"), "true");

		// Search the Assessment Name
		// Doubleclick(arv.search_bx);
		// type(arv.search_bx, AssessmentName);

		waitThread(3000);
		// Assert the Following Data's
		// -Course Name
		// -Assessment Name
		// -Max Score Selected
		// -Publishing Method -Automatic
		// -Pending Evaluation-1 answer sheets

		Assert.assertEquals(getText(arv.assess_namegrid), AssessmentName);
		Assert.assertEquals(getText(arv.cours_namegrid), CourseName3.trim());
		Assert.assertEquals(getText(ari.max_scoregrid), maxscoreposs1);
		Assert.assertEquals(getText(ari.selectpublis_grid), "Automatic");
		Assert.assertEquals(getText(ari.answersheetgrid), "1 answer sheets");

	}

	/*
	 * To verify the labels and score in the result window
	 */
	@Test(priority = 35)
	public void TCSPR1500235() {
		// Click on Current Tab
		click(arv.cuurent_assm_tab);

		// Assert the Current Tab is selected
		waitThread(2000);
		Assert.assertEquals(getAttribute(arv.cuurent_assm_tab, "aria-selected"), "true");

		// search newly created assessment
		click(st1.assess_searchbx);
		type(st1.assess_searchbx, AssessmentName);

		waitThread(3000);
		// Click on Evaluate Answer Button
		click(arv.viewresult_teachcard);

		waitThread(5000);
		// Assert the Labels
		// Course Name: Course name and course ID
		// Assessment Name: Assessment Name
		Assert.assertEquals(getText(arv.courselbl), "Course Name: " + CourseName3.trim() + " " + "(" + CourseID3 + ")");
		Assert.assertEquals(getText(arv.assess_lbl), "Assessment Name: " + AssessmentName);

		// Assert the Label and Value
		// -No of Answer Sheets Pending for Evaluation
		// -1 Answer Sheets
		Assert.assertTrue(getText(ari.NofAnswerSheet_lbl).contains("No of Answer Sheets Pending for Evaluation"));
		Assert.assertEquals(getText(arv.studenttest_clsize_lbl),
				"No of Answer Sheets Pending for Evaluation\n" + "1 Answer Sheets");

		// Assert the Label and Value-Total Peer Review Points
		Assert.assertEquals(getText(arv.tot_peerpoints_lbl), "Total Peer Review Points\n" + TotalRewardScore);

		// Assert the Label and Value-Total Test Points
		Assert.assertEquals(getText(arv.tot_testpoints_lbl), "Total Test Points\n" + TotalTestPoints);
	}

	/*
	 * To verify the labels and score in the result window
	 */
	@Test(priority = 36)
	public void TCSPR1500236() {

		// Assert the Label and Value
		// -Maximum Score Possible
		// (Total Test Points + Total Peer Review Points)
		Assert.assertTrue(getText(arv.maxscoreposs_lbl).contains("Maximum Score Possible"));
		Assert.assertEquals(getText(arv.sum_totalpoints_lbl), "(Total Test Points + Total Peer Review Points)");

		int maxscoreposs = TotalTestPoints1 + TotalRewardScore;
		maxscoreposs1 = String.valueOf(maxscoreposs);

		// Assert Publish button is disabled
		Assert.assertFalse(getAttribute(ari.publish_btn, "class").contains("enable"));

		// Assert the color green for Completed
		Assert.assertTrue(getAttribute(arv.completed_lbl, "Class").contains("green-dot"));

		// Assert the color orange for Incomplete
		Assert.assertTrue(getAttribute(arv.incomplete_lbl, "Class").contains("orange-dot"));

	}

	/*
	 * To verify the grid Label on the Teacher result window
	 */
	@Test(priority = 37)
	public void TCSPR1500237() {

		// Assert the Following Grid Labels

		Assert.assertEquals(getText(arv.lblSIno), "Sl No");
		Assert.assertEquals(getText(arv.lblStudentName), "Student Name");
		Assert.assertEquals(getText(rwbt.lblMaxscore), "Questions\n" + "Answered");
		Assert.assertEquals(getText(arv.lblAnswerSheetReviewed), "Answer Sheets Reviewed by");
		Assert.assertEquals(getText(arv.lblRewardpoint), "Reward\n" + "Point");
		Assert.assertEquals(getText(arv.lblsScoreReceivedfrom), "Score Received from\n" + "Peers");
		Assert.assertEquals(getText(ari.lblScorereceivedfromteach), "Score Received from\n" + "Teacher/Peers");
		Assert.assertEquals(getText(ari.lblstatus), "Status");
		Assert.assertEquals(getText(ari.lbltotalscore), "Total Score");
		Assert.assertEquals(getText(ari.lblansrsheet), "Answer\n" + "Sheet");

		// Assert the students names on the grid
		Assert.assertEquals(getText(arv.stud1ingrid).trim(), Student1name.trim());
		Assert.assertEquals(getText(arv.stud2ingrid).trim(), Student2name.trim());
		Assert.assertEquals(getText(arv.stud3ingrid).trim(), Student3name.trim());

		String rewscore1 = getText(ari.rewarescore_stud1);
		String rewscore2 = getText(ari.rewarescore_stud2);
		String rewscore3 = getText(ari.rewarescore_stud3);

		String scorefrompeer2 = getText(ari.scorefrompeer_stud2);
		String scorefrompeer3 = getText(ari.scorefrompeer_stud3);

		int tot1 = (Integer.parseInt(rewscore1)) + (Integer.parseInt(S2Q1ScorefroStud1));
		int tot2 = (Integer.parseInt(rewscore2)) + (Integer.parseInt(scorefrompeer2));
		int tot3 = (Integer.parseInt(rewscore3)) + (Integer.parseInt(scorefrompeer3));

		// Assert that The Total Score is Reward Score+Score received from peers
		Assert.assertEquals(getText(ari.totscore_stud1), Integer.toString(tot1));
		Assert.assertEquals(getText(ari.totscore_stud2), Integer.toString(tot2));
		Assert.assertEquals(getText(ari.totscore_stud3), Integer.toString(tot3));

	}

	/*
	 * To verify the Details of Student 1 and check the Buttons
	 */
	@Test(priority = 38)
	public void TCSPR1500238() {

		// Assert the Student 1 Name on the top of grid
		Assert.assertTrue(isDisplayed(arv.stud1ingrid), "Student name not present");

		// Assert the Score recieved from the Teacher is Empty
		Assert.assertEquals(getText(ari.scorerec_fromteach_stud1), "--");

		// Assert the Button Label Evaluate
		Assert.assertEquals(getText(ari.eval_btn), "Evaluate");

		// Assert the Button Evaluate at the top of page
		Assert.assertTrue(isDisplayed(ari.eval_btn), "Evaluate Button not present");

		// Assert the Button color Orange
		String color = driver
				.findElement(By
						.xpath("//p-table[@id='questionResultListingTable']//div[1]/table//tr[1]/td[11]/div/button/span"))
				.getCssValue("color");
		System.out.println(color);
		String hex = Color.fromString(color).asHex();
		System.out.println(hex);

		Assert.assertTrue((hex).contains("#ff8128"));

		// Assert the Status Evaluation Pending
		Assert.assertEquals(getText(ari.status_stud1), "Evaluation Pending");

	}

	/*
	 * To check the Evaluate button functionality and check the System Generated
	 * comment box functionality[Student 1]
	 */
	@Test(priority = 39)
	public void TCSPR1500239() {

		// Click on Evaluate Button
		click(ari.eval_btn);

		// Assert the System Generate comment popup visible
		Assert.assertTrue(isElementPresent(ari.sys_popup), "popup not present");

		// Assert the Label "System Generated Reconsideration Request"
		Assert.assertEquals(getText(ari.sys_popup_lbl), "System Generated Reconsideration Request");

		// Assert the text "Question No 2,3 has not been Peer Reviewed"
		Assert.assertEquals(getText(ari.sys_popup_txt), "Question No 2,3 has not been Peer Reviewed");

		waitThread(2000);
		// Click on Close button
		click(ari.sys_popup_clos_btn);

		waitThread(3000);
		// Assert the System Generate comment popup Not visible
		Assert.assertFalse(isElementPresent(ari.sys_popup), "popup present");

		waitThread(4000);
		// Assert the Assessment Name,Course name,Course ID,Student Name
		Assert.assertEquals(getText(arv.result_page_assess_name), AssessmentName);
		Assert.assertTrue(getText(arv.course_name_id).contains(CourseName3.trim()));
		Assert.assertTrue(getText(arv.course_name_id).contains(CourseID3));
		Assert.assertTrue(getText(arv.stud_name_resultwindow).contains(Student1name));
	}

	@Test(priority = 40)
	public void TCSPR1500240() {

		// Assert the Question 2,3 in Orange color
		Assert.assertTrue(getAttribute(arv.wizardq2, "Class").contains("orange"));
		Assert.assertTrue(getAttribute(arv.wizardq3, "Class").contains("orange"));

		// Assert the Previous button is disabled
		Assert.assertTrue(getAttribute(arv.Wizard_prevbtn, "class").contains("p-disabled"));

		// Click on Question 1 Wizard
		click(arv.wizardq1);

		// Assert the Question 1 is selected
		Assert.assertTrue(getAttribute(arv.wizardq1, "class").contains("p-highlight"));

		// Click on Question 2 Wizard
		click(arv.wizardq2);

		// Assert the Question 2 is selected
		// Assert the Question 2 is in Orange color
		Assert.assertTrue(getAttribute(arv.wizardq2, "class").contains("p-highlight"));
		Assert.assertTrue(getAttribute(arv.wizardq2, "Class").contains("orange"));

		// Click on Question 3 Wizard
		click(arv.wizardq3);

		// Assert the Question 3 is selected
		// Assert the Question 3 is in Orange color
		Assert.assertTrue(getAttribute(arv.wizardq3, "class").contains("p-highlight"));
		Assert.assertTrue(getAttribute(arv.wizardq3, "Class").contains("orange"));

		waitThread(3000);
		// Assert the Next button is disabled
		Assert.assertTrue(getAttribute(arv.wizard_nextbtn, "class").contains("p-disabled"));
	}

	/*
	 * To check the Buttons and Score boxes
	 */
	@Test(priority = 41)
	public void TCSPR1500241() {

		// Assert the Button System Generated Comment
		Assert.assertTrue(isDisplayed(ari.sys_comment_btn), "Comment button not present");

		// Click on comment button
		click(ari.sys_comment_btn);

		// Assert that the System Genearte comment popup visible
		Assert.assertTrue(isElementPresent(ari.sys_popup), "popup not present");

		waitThread(2000);
		// Click on Close button
		click(ari.sys_popup_clos_btn);

		waitThread(3000);
		// Assert the System Generate comment popup Not visible
		Assert.assertFalse(isElementPresent(ari.sys_popup), "popup present");

		// Assert the Label Add Your Score
		Assert.assertEquals(getText(ari.add_score_lbl), "Add Your Score");

		// Assert the Score Textbox
		Assert.assertTrue(isDisplayed(ari.addscore_txtbx), "Score textbox not present");

		// Assert that the Save button is disabled
		Assert.assertFalse(isEnabled(ari.save_btn), "Save button is enabled");

	}

	/*
	 * To verify the Exit button functionality on the Answer window
	 */
	@Test(priority = 42)
	public void TCSPR1500242() {

		// Assert the button Exit
		Assert.assertTrue(isDisplayed(arv.exit_btn), "Exit button not present");

		// Click on Exit button
		click(arv.exit_btn);

		waitThread(4000);
		// Assert The Heading Label Evaluate answer sheets and Publish result
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Evaluate answer sheets and Publish result");

		waitThread(2000);
		// Click Evaluate button[Student 1]
		click(ari.eval_btn);

		// Assert that the System Generate comment popup visible
		Assert.assertTrue(isElementPresent(ari.sys_popup), "popup not present");

		waitThread(2000);
		// Click on Close button
		click(ari.sys_popup_clos_btn);

		// Assert the Score Received from Peers: of Student 1
		Assert.assertEquals(getText(arv.scorefrompeer_lbl), "Score Received from Peers: " + S2Q1ScorefroStud1);

	}

	/*
	 * To Edit the Question 1 Score and check the Discard popup Functionality
	 */
	@Test(priority = 43)
	public void TCSPR1500243() {

		// Type Score for Question 1
		click(ari.addscore_txtbx);
		type(ari.addscore_txtbx, "2");

		waitThread(3000);
		// Assert the save button is Enabled
		Assert.assertTrue(isEnabled(ari.save_btn), "Save button is disabled");

		// Clear the Score box
		click(ari.addscore_txtbx);
		driver.findElement(By.xpath("//input[@id='teacherScore']")).sendKeys(Keys.BACK_SPACE);
		waitThread(3000);

		// Assert the save button is Disabled
		Assert.assertFalse(isEnabled(ari.save_btn), "Save button is enabled");

		waitThread(2000);
		// Type Score for Question 1
		click(ari.addscore_txtbx);
		type(ari.addscore_txtbx, "2");

		// Click on Exit button
		click(arv.exit_btn);

		waitThread(1000);
		// Assert the confirmation popup visible
		Assert.assertTrue(isElementPresent(ari.conf_popup), "popup not present");

		waitThread(2000);
		// Assert the buttons and button Lables: Do you want to save the
		// previously
		// added score?
		Assert.assertEquals(getText(ari.conf_txt), "Do you want to save the previously added score?");

		waitThread(1000);
		// Buttons:Discard and Continue,Save and Continue
		Assert.assertEquals(getText(ari.discard_btn), "Discard and Continue");
		Assert.assertEquals(getText(ari.savecont_btn), "Save & Continue");

		waitThread(2000);
		// Click on Button Discard and Continue
		click(ari.discard_btn);

		waitThread(2000);
		// Assert Exit Popup Visible
		Assert.assertTrue(isElementPresent(ari.exit_popup), "popup not present");

	}

	/*
	 * To check the details on the Exit popup
	 */
	@Test(priority = 44)
	public void TCSPR1500244() {

		waitThread(2000);
		// Assert the Labels
		// -Evaluation Incomplete
		// -You can only publish the final result once you completes the
		// evaluation of
		// answers that has not been Peer reviewed
		Assert.assertEquals(getText(ari.eva_incom_lbl), "Evaluation Incomplete");
		Assert.assertEquals(getText(ari.exit_popup_txt),
				"You can only publish the final result once you completes the evaluation of answers that has not been Peer reviewed");

		// Assert the Buttons and Button Labels
		// -Continue current Evaluation
		// -View Next Answer Sheet
		// -Back to results
		Assert.assertEquals(getText(ari.cont_currentev_btn), "Continue current evaluation");
		Assert.assertEquals(getText(ari.view_nxt_sheetbtn), "View next answer sheet");
		Assert.assertEquals(getText(ari.backto_reslt_btn), "Back to results");

		waitThread(2000);
		// Click on Continue current Evaluation button
		click(ari.cont_currentev_btn);

		waitThread(4000);
		// Assert the Exit popup closed
		Assert.assertFalse(isElementPresent(ari.exit_popup), "popup present");

		// Assert the Student 1 Name visible
		Assert.assertTrue(getText(arv.stud_name_resultwindow).contains(Student1name));

		// Assert the Score box is Empty
		Assert.assertEquals(getValue(ari.addscore_txtbx), "");

		// Click on Exit button
		click(arv.exit_btn);
		waitThread(2000);

		// Assert No confirmation popup shows
		Assert.assertFalse(isElementPresent(ari.conf_popup), "popup present");

		waitThread(2000);
		// Click Evaluate button[Student 1]
		click(ari.eval_btn);
		waitThread(3000);

		// Click on Close button
		click(ari.sys_popup_clos_btn);

		// Assert the Question 1 Score box is Empty
		Assert.assertEquals(getValue(ari.addscore_txtbx), "");

	}

	/*
	 * To Edit the Question 1 Score and check the Save and Continue button
	 * functionality on the confirmation popup
	 */
	public String ScoreQ1 = "2";

	@Test(priority = 45)
	public void TCSPR1500245() {

		// Type Score for Question 1
		click(ari.addscore_txtbx);
		type(ari.addscore_txtbx, ScoreQ1);

		// Click on Exit button
		click(arv.exit_btn);

		waitThread(2000);
		// Assert the confirmation popup visible
		Assert.assertTrue(isElementPresent(ari.conf_popup), "popup not present");

		waitThread(2000);
		// Click on Save and Continue button
		click(ari.savecont_btn);

		// Assert the Toaster "Score Saved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);

		waitThread(2000);
		// Assert Exit Popup Visble
		Assert.assertTrue(isElementPresent(ari.exit_popup), "popup not present");

		// Click On Back to results Button
		click(ari.backto_reslt_btn);

		waitThread(4000);
		// Assert the Exit popup not visible
		Assert.assertFalse(isElementPresent(ari.exit_popup), "popup present");

		// Assert the Heading Evaluate answer sheets and Publish result
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Evaluate answer sheets and Publish result");

	}

	/*
	 * To check the Scores of Student 1 and check the contine Evaluation button
	 * functionality
	 */
	@Test(priority = 46)
	public void TCSPR1500246() {

		// Assert the Question 1 Newly added score visible on the Score Received
		// from
		// Teacher/Peers Field
		Assert.assertEquals(getText(ari.scorerec_fromteach_stud1), ScoreQ1);

		// Assert that the Total Score is sum of Score Received from
		// Teacher/Peers+Reward Point
		String rewscore1 = getText(ari.rewarescore_stud1);
		int tot1 = (Integer.parseInt(rewscore1)) + (Integer.parseInt(ScoreQ1));
		Assert.assertEquals(getText(ari.totscore_stud1), Integer.toString(tot1));

		// Assert the Label "Evaluation Pending"
		Assert.assertEquals(getText(ari.status_stud1), "Evaluation Pending");

		// Assert the button and Label continue evaluation
		Assert.assertEquals(getText(ari.eval_btn), "Continue Evaluation");
		Assert.assertTrue(isDisplayed(ari.eval_btn), "Continue Evaluation button not present");

		// Assert Label :No of Answer Sheets Pending for Evaluation ,1 Answer
		// Sheets
		Assert.assertEquals(getText(arv.studenttest_clsize_lbl),
				"No of Answer Sheets Pending for Evaluation\n" + "1 Answer Sheets");

		// Click continue evaluation button
		click(ari.eval_btn);
		waitThread(2000);

		// Click on Close button
		click(ari.sys_popup_clos_btn);

		waitThread(4000);
		// Assert the Question 1 wizard shows Modified
		Assert.assertTrue(getAttribute(arv.wizardq1, "class").contains("modified"));

		waitThread(2000);
		// Assert Score of Question 1:Score Received from Teacher: Score
		Assert.assertEquals(getText(ari.scorefromteach_lbl), "Score Received from Teacher: " + ScoreQ1);

	}

	/*
	 * To verify the Evaluate Answer 2 functionality on the result
	 * window[Student 1]
	 */
	@Test(priority = 47)
	public void TCSPR1500247() throws InterruptedException {

		waitThread(2000);
		// Click Second Question
		click(arv.wizardq2);

		waitThread(4000);
		// Assert the Score Received from Peers label :missing on Question 2
		Assert.assertFalse(isElementPresent(arv.scorefrompeer_lbl), "Label visible");

		// Assert the Label "No Peer Review Done"
		Assert.assertEquals(getText(arv.score_frompeerlbl), "No Peer Review Done");

		// Assert the Student name is in disabled state
		Assert.assertTrue(getAttribute(arv.stud1part, "class").contains("p-disabled"));

		// Type Score for Question2 as zero
		click(ari.addscore_txtbx);
		type(ari.addscore_txtbx, "0");

		// Click Save Button
		click(ari.save_btn);

		// Assert toaster "Score Saved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);

		waitThread(3000);
		// Assert the Wizard status
		Assert.assertTrue(getAttribute(arv.wizardq2, "class").contains("complete"));

		// Assert the Label Score Received from Teacher: 0
		Assert.assertEquals(getText(ari.scorefromteach_lbl), "Score Received from Teacher: 0");

		// Clear the Question 2 Score field
		click(ari.addscore_txtbx);
		waitThread(2000);
		driver.findElement(By.xpath("//input[@id='teacherScore']")).sendKeys(Keys.BACK_SPACE);
		waitThread(4000);

		// Click Save button
		click(ari.save_btn);

		TimeUnit.SECONDS.sleep(4);

		// Assert the Label Score Received from Teacher: 0 Not present
		Assert.assertFalse(isElementPresent(ari.scorefromteach_lbl), "Label visible");

		// Assert the wizard shows orange color
		Assert.assertTrue(getAttribute(arv.wizardq2, "class").contains("orange"));

	}

	/*
	 * To check the View next Answer sheet functionality on the Answer
	 * window[Student 1]
	 */
	public String ScoreQ2 = "3";

	@Test(priority = 48)
	public void TCSPR1500248() {

		// Type Score for Question 2
		click(ari.addscore_txtbx);
		type(ari.addscore_txtbx, ScoreQ2);

		waitThread(1000);
		// Click on Exit button
		click(arv.exit_btn);

		waitThread(1000);
		// Click on Save and Continue button
		click(ari.savecont_btn);

		waitThread(1000);
		// Click On View Next answer sheet Button
		click(ari.view_nxt_sheetbtn);

		waitThread(2000);
		// Assert the Student 2 Name on the Page
		Assert.assertTrue(getText(arv.stud_name_resultwindow).contains(Student2name));

		// Assert the wizard having no status labels
		waitThread(2000);
		Assert.assertFalse(getAttribute(arv.wizardq2, "class").contains("complete"));

		// Click on Exit button
		click(arv.exit_btn);

		// Assert the Exit popup Visible on the page
		waitThread(3000);
		// Assert.assertTrue(isElementPresent(ari.exit_popup), "popup present");

		// Click On Back to results Button
		// click(ari.backto_reslt_btn);

		// Assert the Heading Evaluate answer sheets and Publish result
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Evaluate answer sheets and Publish result");

		// Assert the Student 1 Newley added score visible on the Score Received
		// from
		// Teacher/Peers Field
		// Score Q1+Score Q2
		int Score = (Integer.parseInt(ScoreQ1)) + (Integer.parseInt(ScoreQ2));
		Assert.assertEquals(getText(ari.scorerec_fromteach_stud1), Integer.toString(Score));

		// Assert that the Total Score is sum of Score Received from
		// Teacher/Peers+Reward Point
		String rewscore = getText(ari.rewarescore_stud1);
		int tot = (Integer.parseInt(rewscore)) + Score;
		Assert.assertEquals(getText(ari.totscore_stud1), Integer.toString(tot));

	}

	/*
	 * To verify the Evaluate Answer 3 functionality on the result
	 * window[Student 1]
	 */
	public String ScoreQ3 = "1";

	@Test(priority = 49)
	public void TCSPR1500249() {

		// Click continue evaluation button
		click(ari.eval_btn);
		waitThread(3000);

		// Click on Close button
		click(ari.sys_popup_clos_btn);

		waitThread(3000);
		click(arv.wizardq2);
		waitThread(4000);

		// Assert the wizard 2 have status
		Assert.assertTrue(getAttribute(arv.wizardq2, "class").contains("p-paginator-complete"));

		waitThread(1000);
		// Click on Question 3 Wizard
		click(arv.wizardq3);

		// Type Score
		click(ari.addscore_txtbx);
		type(ari.addscore_txtbx, ScoreQ3);

		// Click Save Button
		click(ari.save_btn);

		// Assert toaster "Score Saved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);

		waitThread(1000);
		// Assert the Label Modified Score
		Assert.assertEquals(getText(ari.add_score_lbl), "Modify Score");

		waitThread(1000);
		// Assert the label Score Received from Teacher:Score Q3
		// Assert the save button is disabled
		// Assert the label and check box "I approve the Total Scores given by
		// peers"
		// not present
		Assert.assertEquals(getText(ari.scorefromteach_lbl), "Score Received from Teacher: " + ScoreQ3);
		Assert.assertFalse(isEnabled(ari.save_btn), "Save button is Enabled");
		Assert.assertFalse(isElementPresent(ari.score_checkbx), "Check box present");

		// Click on Exit button
		click(arv.exit_btn);

		waitThread(2000);
		// Assert the Exit popup Visible on the page
		waitThread(3000);
		Assert.assertTrue(isElementPresent(ari.exit_popup), "popup present");

	}

	/*
	 * To check the Evaluation complete Exit popup functionality[Student 1]
	 */
	@Test(priority = 50)
	public void TCSPR1500250() {

		// Assert the Labels:
		// -Evaluation completed successfully
		// -You can modify the scores later before the final result publish.You
		// cannot
		// make any modifications once the result is published.
		Assert.assertEquals(getText(ari.eva_incom_lbl), "Evaluation completed successfully");
		Assert.assertEquals(getText(ari.exit_popup_txt),
				"You can modify the scores later before the final result publish.You cannot make any modifications once the result is published.");

		// Assert the buttons and button labels:
		// -Modify Current Evaluation
		// -View next Answer sheet
		// -Back to results
		Assert.assertEquals(getText(ari.cont_currentev_btn), "Modify current evaluation");
		Assert.assertEquals(getText(ari.view_nxt_sheetbtn), "View next answer sheet");
		Assert.assertEquals(getText(ari.backto_reslt_btn), "Back to Results");

		waitThread(3000);
		// Click On Modify current evaluation button
		click(ari.cont_currentev_btn);

		waitThread(3000);
		// Assert the Exit popup not visible
		Assert.assertFalse(isElementPresent(ari.exit_popup), "popup present");

		// Click on Exit button
		click(arv.exit_btn);
		waitThread(2000);

		// Click On Back to results Button
		click(ari.backto_reslt_btn);

		waitThread(2000);
		// Assert the publish button is Enabled
		Assert.assertTrue(isEnabled(ari.publish_btn), "publish button is disabled");

	}
	/*
	 * To verify the card status when evaluation complete[Student 1]
	 */

	@Test(priority = 51)
	public void TCSPR1500251() {

		waitThread(2000);
		// Assert the label "0 Answer Sheets"
		Assert.assertTrue(getText(arv.studenttest_clsize_lbl).contains("0 Answer Sheets"));

		// Assert the Score Received from Teacher/Peers is Score Q1+Score
		// Q2+Score Q3
		int Score = (Integer.parseInt(ScoreQ1)) + (Integer.parseInt(ScoreQ2) + Integer.parseInt(ScoreQ3));
		Assert.assertEquals(getText(ari.scorerec_fromteach_stud1), Integer.toString(Score));

		// Click Back button
		click(arv.back_btn);
		waitThread(6000);

		// Search the Assessment Name
		click(st1.assess_searchbx);
		type(st1.assess_searchbx, AssessmentName);
		waitThread(7000);

		// Assert the result section label "pending"
		// Assert labels:-You need to manually publish the result, Evaluation
		// Completed
		Assert.assertEquals(getText(ari.teach_manually_txt), "You need to manually publish the result");
		Assert.assertEquals(getText(tr.resultsts_lbl), "Pending");
		Assert.assertEquals(getText(ari.answrsheet_evalu_txt), "Evaluation Completed");

		// Assert Button continue
		Assert.assertEquals(getText(arv.viewresult_teachcard), "Continue");

		// Assert the label Result Upcoming
		Assert.assertEquals(getText(tts.time_status), "Result Upcoming");

		// Click continue button
		click(arv.viewresult_teachcard);

		waitThread(4000);
		// Assert The Heading Label Evaluate answer sheets and Publish result
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Evaluate answer sheets and Publish result");

	}

	/*
	 * To Edit the Answer sheet of student 1
	 */
	public String rewscore1;

	@Test(priority = 52)
	public void TCSPR1500252() {

		// Assert student1 button View/Modify[Button and button label]
		Assert.assertEquals(getText(ari.eval_btn), "View/Modify Score");

		// Click on View/Modify of Student 1
		click(ari.eval_btn);
		waitThread(3000);

		// Click on Wizard 2
		click(arv.wizardq2);

		// clear score textbox & save
		click(ari.addscore_txtbx);
		driver.findElement(By.xpath("//input[@id='teacherScore']")).sendKeys(Keys.BACK_SPACE);
		waitThread(2000);

		click(ari.save_btn);

		waitThread(6000);
		// Assert the wizard shows orange color
		Assert.assertTrue(getAttribute(arv.wizardq2, "class").contains("orange"));

		// Assert the label Add Your Score
		Assert.assertEquals(getText(ari.add_score_lbl), "Add Your Score");

		// Click on Exit button
		click(arv.exit_btn);
		waitThread(2000);

		// Assert the Label "Evaluation Incomplete"
		Assert.assertEquals(getText(ari.eva_incom_lbl), "Evaluation Incomplete");

		// Click On Back to results Button
		click(ari.backto_reslt_btn);

		waitThread(3000);
		// Assert the label "1 Answer Sheets"
		Assert.assertTrue(getText(arv.studenttest_clsize_lbl).contains("1 Answer Sheets"));

		// Assert the Score Received from Teacher/Peers is Score Q1+Score Q3
		int Score = (Integer.parseInt(ScoreQ1)) + (Integer.parseInt(ScoreQ3));
		Assert.assertEquals(getText(ari.scorerec_fromteach_stud1), Integer.toString(Score));

		// Assert the Total Score is Reward Score +Score Q1+Score Q3
		rewscore1 = getText(ari.rewarescore_stud1);
		int tot = (Integer.parseInt(rewscore1)) + Score;
		Assert.assertEquals(getText(ari.totscore_stud1), Integer.toString(tot));

		// Click Back button
		click(arv.back_btn);
		waitThread(5000);

		// Search the Assessment Name
		click(st1.assess_searchbx);
		type(st1.assess_searchbx, AssessmentName);
		waitThread(3000);
		Scroll_DowntoEnd();
		// Assert the result section label "pending"
		// Assert labels: -You need to manually publish the result
		// -No of Answer sheets pending for evaluation: 1
		Assert.assertEquals(getText(ari.teach_manually_txt), "You need to manually publish the result");
		Assert.assertEquals(getText(tr.resultsts_lbl), "Pending");
		// Assert.assertEquals(getText(ari.answrsheet_evalu_txt), "No of Answer
		// sheets pending for evaluation: 1");
		// Click continue button
		click(arv.viewresult_teachcard);

		waitThread(4000);
		// Assert The Heading Label Evaluate answer sheets and Publish result
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Evaluate answer sheets and Publish result");

		// Assert student1 button Continue Evaluation[Button and button label]
		Assert.assertTrue(isElementPresent(ari.eval_btn), "Button not present");
		Assert.assertEquals(getText(ari.eval_btn), "Continue Evaluation");

		// Assert the label "Evaluation Pending"
		Assert.assertEquals(getText(ari.status_stud1), "Evaluation Pending");

	}

	/*
	 * To Edit the Answer sheet of student 1
	 */
	public String Newscore_Q2 = "2";
	public String rewardpoint_stud1;
	public String score_rec_peer;
	public String score_from_teach;
	public String totalscore_stud1;

	@Test(priority = 53)
	public void TCSPR1500253() {

		// Click on continue Evaluation button
		click(ari.eval_btn);

		waitThread(1000);
		click(ari.sys_popup_clos_btn);

		waitThread(3000);
		// Click on Wizard 2
		click(arv.wizardq2);

		// New Score Q2
		click(ari.addscore_txtbx);
		type(ari.addscore_txtbx, Newscore_Q2);

		// Click Save button
		waitThread(2000);
		click(ari.save_btn);

		waitThread(2000);
		// Assert the Total Score in the Answer window:Score Q1+New Score
		// Q2+Score
		// Q3+Reward Score
		int Score = (Integer.parseInt(ScoreQ1)) + (Integer.parseInt(ScoreQ3)) + (Integer.parseInt(Newscore_Q2));
		int tot = (Integer.parseInt(rewscore1)) + Score;
		Assert.assertEquals(getText(ari.totscorevalue), Integer.toString(tot) + "/" + maxscoreposs1);

		// Click on Exit button
		click(arv.exit_btn);
		waitThread(2000);

		// Click On Back to results Button
		click(ari.backto_reslt_btn);

		waitThread(3000);
		// Assert the Label 'Evaluation completed'
		Assert.assertEquals(getText(ari.status_stud1), "Evaluation Completed");

		// Assert the Score Received from Teacher/Peers :Score Q1+New Score
		// Q2+Score Q3
		Assert.assertEquals(getText(ari.scorerec_fromteach_stud1), Integer.toString(Score));

		// Assert the Total Score is: Score Q1+New Score Q2+Score Q3+Reward
		// Score
		Assert.assertEquals(getText(ari.totscore_stud1), Integer.toString(tot));

		// Read the Scores of each fields[Student 1] -RewardPoint,-Score
		// Received from
		// Peer,-Score Received from Teacher/Peers
		// -Total Score
		rewardpoint_stud1 = getText(ari.rewarescore_stud1);
		score_rec_peer = getText(ari.scorefrompeer_stud1);
		score_from_teach = getText(ari.scorerec_fromteach_stud1);
		totalscore_stud1 = getText(ari.totscore_stud1);

	}

	/*
	 * To perform Evaluation of student 2
	 */
	@Test(priority = 54)
	public void TCSPR1500254() {

		waitThread(7000);
		// Click on Student 2 View/Modify button
		Doubleclick(ari.modifybtn_stud2);

		waitThread(5000);
		// Assert the Student 2 Name on the Page
		Assert.assertTrue(getText(arv.stud_name_resultwindow).contains(Student2name));

		// Assert the label and check box I approve the Total Scores given by
		// peers
		Assert.assertEquals(getText(ari.iapprove_lbl), "I approve the Total Scores given by peers");
		Assert.assertTrue(isDisplayed(ari.score_checkbx), "Check box not present");

		// Click on I approve the Total Scores given by peers checkbox
		click(ari.score_checkbx);

		waitThread(1000);
		// Assert the check box is checked
		Assert.assertTrue(getAttribute(ari.score_checkbx_check, "class").contains("checked"));

		// Assert the score box is disabled
		Assert.assertTrue(getAttribute(ari.addscore_txtbx, "class").contains("disabled"));

		// Click on I approve the Total Scores given by peers checkbox
		click(ari.score_checkbx_check);

		waitThread(2000);
		// Assert the check box is unchecked
		Assert.assertFalse(getAttribute(ari.score_checkbx_check, "class").contains("checked"));

		// Assert the score box is Enabled
		Assert.assertFalse(getAttribute(ari.addscore_txtbx, "class").contains("disabled"));

		waitThread(2000);
		// Click on 3rd Question wizard
		click(arv.wizardq3);

		// Assert the label and check box I approve the Total Scores given by
		// peers
		Assert.assertEquals(getText(ari.iapprove_lbl), "I approve the Total Scores given by peers");
		Assert.assertTrue(isDisplayed(ari.score_checkbx), "Check box not present");

	}

	/*
	 * To Approve the Answer sheet of student 2
	 */
	@Test(priority = 55)
	public void TCSPR1500255() {

		// Click on I approve the Total Scores given by peers checkbox
		click(ari.score_checkbx_check);

		// Click on Exit Button
		click(arv.exit_btn);
		waitThread(2000);

		// Assert the Popup Viisble on the page
		Assert.assertTrue(isDisplayed(ari.conf_popup), "popup not visible");

		// Assert the Labels:-Approve Total Score
		// -Are you sure you want to approve the total score given by peers?
		Assert.assertEquals(getText(ari.conf_txt), "Are you sure you want to approve the total score given by peers?");
		Assert.assertEquals(getText(ari.conf_hd), "Approve Total Score");

		// Assert the Buttons:Yes and No
		Assert.assertEquals(getText(ari.discard_btn), "No");
		Assert.assertEquals(getText(ari.savecont_btn), "Yes");

		waitThread(3000);
		// Click on No button
		Doubleclick(ari.discard_btn);

		waitThread(3000);
		// Assert the Approve Total Score Popup not visble on the page
		Assert.assertFalse(isElementPresent(ari.conf_popup), "popup visible");

		waitThread(1000);
		// Assert the label Evaluate answer sheets and Publish result
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Evaluate answer sheets and Publish result");

	}

	/*
	 * To Approve the Answer sheet of student 2
	 */
	public String rewardpoint_stud31;

	@Test(priority = 56)
	public void TCSPR1500256() {
		rewardpoint_stud31 = getText(ari.rewarescore_stud3);

		waitThread(2000);
		// Click on Student 2 View/Modify button
		click(ari.modifybtn_stud2);

		// Assert the I approve the Total Scores given by peers checkbox is
		// unchecked
		Assert.assertFalse(getAttribute(ari.score_checkbx_check, "class").contains("checked"));

		// Click on I approve the Total Scores given by peers checkbox
		click(ari.score_checkbx);

		// Click on Exit button
		click(arv.exit_btn);
		waitThread(2000);

		// Click Yes button
		click(ari.savecont_btn);

		// Assert the toaster "Total Score Approved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Total Score Approved");
		click(QP.toasterclosebtn);

		// Assert the Score approved popup visible
		waitThread(2000);
		Assert.assertTrue(isDisplayed(ari.score_popup), "popup not visible");
	}

	/*
	 * To check the view next answer sheet functionality of Total Score Approved
	 * popup
	 */
	public String Stud3_scoreQ1 = "1";
	public String peersQ2;
	public String peersQ3;
	public int score1;

	@Test(priority = 57)
	public void TCSPR1500257() {

		waitThread(2000);
		// Assert the Label "Total Score Approved"
		Assert.assertEquals(getText(ari.score_popup_lbl), "Total Score Approved");

		// Assert the buttons view next answer sheets and Back to results
		Assert.assertEquals(getText(ari.score_popupview_nxtbtn), "View next answer sheet");
		Assert.assertEquals(getText(ari.score_back_resltbtn), "Back to results");

		waitThread(3000);
		// Click On View Next answer sheet Button
		click(ari.score_popupview_nxtbtn);

		waitThread(4000);
		// Assert the student 3 name on the page
		Assert.assertTrue(getText(arv.stud_name_resultwindow).contains(Student3name));

		// Assert the label and check box I approve the Total Scores given by
		// peers
		Assert.assertEquals(getText(ari.iapprove_lbl), "I approve the Total Scores given by peers");
		Assert.assertTrue(isDisplayed(ari.score_checkbx), "Check box not present");

		waitThread(2000);
		// Type Score for question 1
		click(ari.addscore_txtbx);
		type(ari.addscore_txtbx, Stud3_scoreQ1);

		// Click Save button
		waitThread(2000);
		click(ari.save_btn);

		// Assert the toaster "Score Saved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);

		waitThread(2000);
		// Assert the Scores :Score Received from Teacher:Stud 3 score Q1 and
		// Final
		Assert.assertEquals(getText(ari.scorefromteach_lbl), "Score Received from Teacher: " + Stud3_scoreQ1);

		// Score: Stud 3 score Q1 +Reward Score of Q1
		int finalscorr = (Integer.parseInt(Stud3_scoreQ1)) + (Integer.parseInt(rewarscoreQ1));
		Assert.assertEquals(getText(arv.final_scrorelbl), "Final Score: " + Integer.toString(finalscorr));

		waitThread(2000);
		// Click on Q2 Wizard button
		click(arv.wizardq2);

		waitThread(3000);
		// Read the Score received from peers Q2
		String[] arrOfStr = getText(arv.scorefrompeer_lbl).split(" ");
		peersQ2 = arrOfStr[arrOfStr.length - 1];
		waitThread(2000);

		// Click on Q3 Wizard button
		click(arv.wizardq3);

		// Read the Score received from peers Q3
		String[] arrOfStr1 = getText(arv.scorefrompeer_lbl).split(" ");
		peersQ3 = arrOfStr1[arrOfStr1.length - 1];

		// Assert the I approve the Total Scores given by peers checkbox is
		// disabled
		Assert.assertTrue(getAttribute(ari.score_checkbx_check, "class").contains("disabled"));

		// Assert the Total Score :Stud 3 score Q1 +Score received from peers
		// Q2+Score
		// received from peers Q3+Reward Score
		score1 = (Integer.parseInt(Stud3_scoreQ1)) + (Integer.parseInt(peersQ2)) + (Integer.parseInt(peersQ3));
		int tot = (Integer.parseInt(rewardpoint_stud31)) + score1;
		Assert.assertEquals(getText(ari.totscorevalue), Integer.toString(tot) + "/" + maxscoreposs1);

	}

	/*
	 * To perform exit button functionality from the Student 3 And check the
	 * score details and label of student 2 and student 3
	 */
	@Test(priority = 58)
	public void TCSPR1500258() {

		// Click on Exit button
		click(arv.exit_btn);
		waitThread(2000);

		// Assert the Exit popup Visible on the page
		Assert.assertTrue(isElementPresent(ari.exit_popup), "popup not present");

		// Assert the Label:Scores Modified Successfully
		Assert.assertEquals(getText(ari.eva_incom_lbl), "Scores Modified Successfully");

		// Assert the View next answer sheet button is disabled
		Assert.assertTrue(getAttribute(ari.viewnextbtn_dis, "class").contains("disabled-btn"));

		// Click On Back to results Button
		click(ari.backto_reslt_btn);

		waitThread(2000);
		// Assert the publish button is Enabled
		Assert.assertTrue(isEnabled(ari.publish_btn), "publish button is disabled");

		waitThread(1000);
		// Assert the Student 2 status label is :Peer Scores Approved
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[9]/div/p"),
				"Peer Scores Approved");

		waitThread(1000);
		// Assert that Score Received from Teacher/Peers is Empty[Student 2]
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[8]/div/span"), "--");

		waitThread(1000);
		// Assert the Student 3 Score Received from Teacher/Peers Score:Stud 3
		// score Q1
		// +Score received from peers Q2+Score received from peers Q3
		Assert.assertEquals(cm.getdatafromgrid(Student3name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[8]/div/span"),
				Integer.toString(score1));

		waitThread(1000);
		// Assert the Total Score :Stud 3 score Q1 +Score received from peers
		// Q2+Score
		// recived from peers Q3+Reward Score
		String rewscore3 = cm.getdatafromgrid(Student3name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[6]//span");
		int tot = (Integer.parseInt(rewscore3)) + score1;
		Assert.assertEquals(cm.getdatafromgrid(Student3name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[10]//span"),
				Integer.toString(tot));

		// Assert the Label Scores Modified for Student 3
		Assert.assertEquals(cm.getdatafromgrid(Student3name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[9]/div/p"), "Scores Modified");

	}

	/*
	 * To check pending evaluation count on the pending evaluation tab
	 */
	public String rewardpoint_stud22;
	public String score_rec_peer2;
	public String score_from_teach2;
	public String totalscore_stud2;
	public String rewardpoint_stud3;
	public String score_rec_peer3;
	public String score_from_teach3;
	public String totalscore_stud3;

	@Test(priority = 59)
	public void TCSPR1500259() throws InterruptedException {

		waitThread(3000);
		// Click On Back button
		click(arv.back_btn);

		waitThread(6000);
		// Assert the Current Tab selected
		Assert.assertEquals(getAttribute(arv.cuurent_assm_tab, "aria-selected"), "true");

		TimeUnit.SECONDS.sleep(10);

		waitThread(3000);
		// Click on Pending Evaluation Tab
		click(arv.pending_ev_tab);

		waitThread(3000);
		// Search the Assessment Name
		// click(arv.search_bx);
		// type(arv.search_bx, AssessmentName);

		waitThread(4000);

		// Assert the Pending Evaluation is Pending Evaluation-0 answer sheets
		Assert.assertEquals(getText(ari.answersheetgrid), "0 answer sheets");

		// Click on View Answers &Evaluate
		click(ari.btn_view_ans_grid);

		waitThread(3000);
		// Assert heading Evaluate answer sheets and Publish result
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Evaluate answer sheets and Publish result");

		// Read the Scores of each fields[Student 2 and Student 3]-Reward
		// Point,-Score
		// Received from Peers,-Score Received from Teacher/Peers,-Total Score
		rewardpoint_stud22 = cm.getdatafromgrid(Student2name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[6]//span");
		score_rec_peer2 = cm.getdatafromgrid(Student2name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[7]//span");
		score_from_teach2 = cm.getdatafromgrid(Student2name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[8]/div/span");
		totalscore_stud2 = cm.getdatafromgrid(Student2name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[10]//span");

		rewardpoint_stud3 = cm.getdatafromgrid(Student3name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[6]//span");
		score_rec_peer3 = cm.getdatafromgrid(Student3name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[7]//span");
		score_from_teach3 = cm.getdatafromgrid(Student3name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[8]/div/span");
		totalscore_stud3 = cm.getdatafromgrid(Student3name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[10]//span");

	}

	/*
	 * To perform publish the result functionality on the teacher login
	 */
	@Test(priority = 60)
	public void TCSPR1500260() {

		// Click on Publish button
		click(ari.publish_btn);

		waitThread(2000);
		// Assert the publish popup visible
		Assert.assertTrue(isElementPresent(ari.publish_popup), "popup not present");

		// Assert the Label "Result Published Successfully"
		Assert.assertEquals(getText(ari.pub_popup_txt), "Result Published Successfully");

		// Assert the button Back to Results
		Assert.assertTrue(isDisplayed(ari.publish_backtores_btn), "button not present");

		waitThread(1000);
		// Click on Back to Result Button
		click(ari.publish_backtores_btn);

		waitThread(3000);
		// Assert the Heading Final result
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Final Result");

	}

	/*
	 * To verify the labels and score in the Final result window
	 */
	public String cls_size;
	public String questans_count;
	public String questans_count2;
	public String questans_count3;

	@Test(priority = 61)
	public void TCSPR1500261() {

		// Assert the Label and Value -Students tested/Class size
		cls_size = getText(arv.studenttest_clsize);
		Assert.assertEquals(getText(arv.studenttest_clsize_lbl), "Students tested/Class size\n" + cls_size);

		// Assert the Label and Value -Total Questions
		Assert.assertEquals(getText(arv.tot_quest_count_lbl), "Total Questions\n" + quest_count);
		questans_count = cm.getdatafromgrid(Student1name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[4]/div/span");
		questans_count2 = cm.getdatafromgrid(Student2name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[4]/div/span");
		questans_count3 = cm.getdatafromgrid(Student3name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[4]/div/span");

		// Assert the Labels:
		// *Sl No, Student Name ,Questions Answered ,Answer Sheets Reviewed by
		// *Reward
		// Point
		// *Score Received from Peer, Score Received from Teacher/Peers
		// *Total Score Answer Sheet
		Assert.assertEquals(getText(arv.lblSIno), "Sl No");
		Assert.assertEquals(getText(arv.lblStudentName), "Student Name");
		Assert.assertEquals(getText(rwbt.lblMaxscore), "Questions\n" + "Answered");
		Assert.assertEquals(getText(arv.lblAnswerSheetReviewed), "Answer Sheets Reviewed by");
		Assert.assertEquals(getText(arv.lblRewardpoint), "Reward\n" + "Point");
		Assert.assertEquals(getText(arv.lblsScoreReceivedfrom), "Score Received from\n" + "Peers");
		Assert.assertEquals(getText(ari.lblScorereceivedfromteach), "Score Received from\n" + "Teacher/Peers");
		Assert.assertEquals(getText(ari.lblstatus), "Total Score");
		Assert.assertEquals(getText(ari.lbltotalscore), "Answer\n" + "Sheet");

	}

	/*
	 * To verify the Scores of each student Same as Evaluate answer sheets and
	 * Publish result[Student 1,Student 2,Student 3]
	 */
	@Test(priority = 62)
	public void TCSPR1500262() {

		// Assert the Scores of Student 1
		// -Score Received from Peers
		// -Score Received from Teacher/Peers
		// -Total Score
		// -the button View of student1
		Assert.assertEquals(getText(ari.scorefrompeer_stud1), score_rec_peer);
		Assert.assertEquals(getText(ari.scorerec_fromteach_stud1), score_from_teach);
		Assert.assertEquals(getText(ari.finalwindw_totscorestud1), totalscore_stud1);
		Assert.assertEquals(getText(ari.rewarescore_stud1), rewardpoint_stud1);
		Assert.assertEquals(getText(ari.viewbtn_stud1), "View");

		// Assert the Scores of Student 2
		// -Score Received from Peers
		// -Score Received from Teacher/Peers
		// -Total Score
		// -the button View of student2
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[7]//span"), score_rec_peer2);
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[8]/div/span"),
				score_from_teach2);
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[9]//span"), totalscore_stud2);
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[6]//span"), rewardpoint_stud22);
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[10]/div/button/span"), "View");

		// Assert the Scores of Student 3
		// -Score Received from Peers
		// -Score Received from Teacher/Peers
		// -Total Score
		// - the button View of student3
		Assert.assertEquals(cm.getdatafromgrid(Student3name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[7]//span"), score_rec_peer3);
		Assert.assertEquals(cm.getdatafromgrid(Student3name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[8]/div/span"),
				score_from_teach3);
		Assert.assertEquals(cm.getdatafromgrid(Student3name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[9]//span"), totalscore_stud3);
		Assert.assertEquals(cm.getdatafromgrid(Student3name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[6]//span"), rewardpoint_stud3);
		Assert.assertEquals(cm.getdatafromgrid(Student3name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[10]/div/button/span"), "View");

	}

	/*
	 * Verify the Answer sheets of each student Perform Logout Functionality
	 */
	public String resultdate;
	public String resulttime;

	@Test(priority = 63)
	public void TCSPR1500263() {

		// Click view Student 1 Answer sheet
		click(ari.viewbtn_stud1);

		// Assert the Student 1 Name
		waitThread(3000);
		Assert.assertTrue(getText(arv.stud_name_resultwindow).contains(Student1name));

		// Assert the Label "Teacher Modified"
		Assert.assertEquals(getText(arv.reviewstatus), "Teacher Modified");

		// Click on 2nd Question Wizard
		click(arv.wizardq2);

		// Assert the Label "Teacher Evaluated"
		waitThread(3000);
		Assert.assertEquals(getText(arv.reviewstatus), "Teacher Evaluated");

		// Click on Exit button
		click(arv.exit_btn);

		waitThread(3000);
		// Assert the Heading Final result
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Final Result");

		// Click View Student 2 Answer sheet
		cm.clickstudentanswersheet(Student2name, "//p-table[@id='questionResultListingTable']//div[1]/table//tr[",
				"]/td[10]/div/button/span");

		// Assert the Student 2 Name
		waitThread(2000);
		Assert.assertTrue(getText(arv.stud_name_resultwindow).contains(Student2name));

		waitThread(3000);
		// Assert the label "Peer Scores Approved"
		Assert.assertEquals(getText(ari.peerscore_txt1), "Peer Scores Approved");

		// Click on Exit button
		click(arv.exit_btn);
		waitThread(2000);

		// Assert the Heading Final result
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Final Result");

		waitThread(1000);
		// Click View Student 3 Answer sheet
		cm.clickstudentanswersheet(Student3name, "//p-table[@id='questionResultListingTable']//div[1]/table//tr[",
				"]/td[10]/div/button/span");

		// Assert the Student 3 Name
		waitThread(3000);
		Assert.assertTrue(getText(arv.stud_name_resultwindow).contains(Student3name));

		waitThread(3000);
		// Assert the label "Teacher Modified"
		Assert.assertEquals(getText(arv.reviewstatus), "Teacher Modified");

		// Click on Exit button
		click(arv.exit_btn);
		waitThread(2000);

		// Click Back button
		click(arv.back_btn);
		waitThread(3000);

		// Click Current tab
		click(arv.current_tab);
		waitThread(6000);

		// Search the Assessment Name
		Doubleclick(tts.search_box);
		waitThread(2000);
		type(tts.search_box, AssessmentName);
		waitThread(3000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(tts.Assessmentcard), "Published Assessment card not visible");

		// Assert the Result Published Date: Date and time
		cm.datetimesplitmethod();
		resultdate = cm.getdates(cm.resultdate);
		resulttime = cm.resultime;

		waitThread(3000);
		// Perform Teacher Logout
		cm.Logout();

		// Assert heading Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * Login As student 1 and check the Details of Result window
	 */
	public String resultdatestud;
	public String resulttimestud;

	@Test(priority = 64)
	public void TCSPR1500264() {

		// login as Student 1
		waitThread(2000);
		lg.login1(Emailstudent1, cm.Password);

		// Search the Assessment Name
		waitThread(5000);
		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		click(st1.stud_searchbx);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(3000);

		// Assert Label "Result Available"
		Assert.assertEquals(getText(ari.stud_cardhead_lbl), "Result Available");

		// Assert the Result Published Date: Date and time
		cm.studentresultdatetimemethod();
		resultdatestud = cm.getdates(cm.resultdate_stud);
		resulttimestud = cm.resultime_stud;

		// Assert the view result button visible
		Assert.assertTrue(isElementPresent(rwbt.viewresultbtn), "View result button not visible");

		// click on view result button
		click(rwbt.viewresultbtn);
		waitThread(3000);

		// Assert Result popup visible
		Assert.assertTrue(isElementPresent(rwbt.resultpopup), "Result Popup  not visible");

		// Assert the heading Result
		Assert.assertEquals(getText(rwbt.label_Result_1), "Result");

		waitThread(3000);
		// Assert the Labels and Scores:
		// -Questions Answered,No of Peer Reviews Done
		// -Score Received from Teacher,Total Score (Score Received from Teacher
		// + Score
		// for Peer Review Done)
		Assert.assertTrue(getText(rwbt.lbl_studentAnswered).contains("Questions Answered"));
		Assert.assertEquals(getText(rwbt.value_studentAnswered), questans_count);

		Assert.assertTrue(getText(rwbt.lbl_ReviewsDone).contains("No of Peer Reviews Done"));
		Assert.assertEquals(getText(rwbt.studentPeerDone), quest_count + "/" + quest_count);

		Assert.assertTrue(getText(rwbt.lbl_ScoreforReviewsDone).contains("Score for Reviews Done"));
		Assert.assertEquals(getText(rwbt.ScoreforReviewsDone), rewardpoint_stud1 + "/" + TotalRewardScore);

		Assert.assertTrue(getText(rwbt.lbl_Scorefrm_teach).contains("Score Received from Teacher"));
		Assert.assertEquals(getText(rwbt.Scorefrm_teach), score_from_teach + "/" + TotalTestPoints);

		Assert.assertTrue(getText(rwbt.lbl_TotalScore).contains("Total Score"));
		Assert.assertTrue(
				getText(rwbt.lbl_TotalScore).contains("(Score Received from Teacher + Score for Peer Review Done)"));
		Assert.assertEquals(getText(rwbt.TotalScore), totalscore_stud1 + "/" + maxscoreposs1);
	}

	/*
	 * To verify the Score details of each questions [Student 1]
	 */
	@Test(priority = 65)
	public void TCSPR1500265() {
		waitThread(3000);
		// Assert the Scores Received from Peer Reviewers of Question 1
		Assert.assertEquals(getText(rwbt.Q1_scorefrompeers), score_rec_peer);

		// Assert the Scores Received from Peer Reviewers of Question 2 and
		// Question 3
		// is Empty
		Assert.assertEquals(getText(rwbt.Q2_scorefrompeers), "--");
		Assert.assertEquals(getText(rwbt.Q3_scorefrompeers), "--");

		// Assert the Scores Received from Teacher Of Q1,Q2 and Q3
		Assert.assertEquals(getText(ari.Q1_scorefrm_teach), ScoreQ1);
		Assert.assertEquals(getText(ari.Q2_scorefrm_teach), Newscore_Q2);
		Assert.assertEquals(getText(ari.Q3_scorefrm_teach), ScoreQ3);

		waitThread(3000);
		// Assert the Final score of Q1,Q2,Q3
		int f1 = cm.StringtoInt(rewarscoreQ1) + cm.StringtoInt(ScoreQ1);
		int f2 = cm.StringtoInt(rewarscoreQ2) + cm.StringtoInt(Newscore_Q2);
		int f3 = cm.StringtoInt(rewarscoreQ3) + cm.StringtoInt(ScoreQ3);

		waitThread(3000);
		Assert.assertEquals(getText(ari.Q1_FinalScore), cm.InttoString(f1));
		Assert.assertEquals(getText(ari.Q2_FinalScore), cm.InttoString(f2));
		Assert.assertEquals(getText(ari.Q3_FinalScore), cm.InttoString(f3));

		// Assert the Status of Q1 is Teacher Modified
		Assert.assertEquals(getText(ari.Q1_Status), "Teacher Modified");

		// Assert the Status of Q2 is Teacher Evaluated
		Assert.assertEquals(getText(ari.Q2_Status), "Teacher Evaluated");

		// Assert the Status of Q3 is Teacher Evaluated
		Assert.assertEquals(getText(ari.Q3_Status), "Teacher Evaluated");

	}

	/*
	 * To verify the Answer sheets
	 */
	@Test(priority = 66)
	public void TCSPR1500266() {

		// Click on Q1 view button
		click(ari.view_btn_q1);

		waitThread(3000);
		// Assert the Score Received from Teacher: value same as teacher page
		Assert.assertEquals(getText(sasb.scorefromteach), "Score Received from Teacher: " + ScoreQ1);

		waitThread(1000);
		// Assert the Label Teacher Modified
		Assert.assertEquals(getText(arv.reviewstatus), "Teacher Modified");

		waitThread(2000);
		// Click on Q2 Wizard button
		click(sasb.wizardq2);

		waitThread(3000);
		// Assert the Score Received from Teacher: value same as teacher page
		Assert.assertEquals(getText(sasb.scorefromteach), "Score Received from Teacher: " + Newscore_Q2);

		waitThread(1000);
		// Assert the Label Teacher Evaluated
		Assert.assertEquals(getText(arv.reviewstatus), "Teacher Evaluated");

		waitThread(1000);
		// Assert the Label No Peer Review Done
		Assert.assertEquals(getText(sasb.peer_score_lbl), "No Peer Review Done");

		// Perform Student 1 Logout
		cm.Logout();

		// Assert heading Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * Login As student 2 and check the Details of Result window
	 */
	@Test(priority = 67)
	public void TCSPR1500267() {

		// login as Student 2
		waitThread(2000);
		lg.login1(Emailstudent2, cm.Password);

		// Click on Result publish Tab
		waitThread(5000);
		click(ari.result_tab);

		// Assert the result publish tab is selected
		waitThread(5000);
		Assert.assertEquals(getAttribute(ari.result_tab, "aria-selected"), "true");

		// Search the Assessment Name
		waitThread(5000);
		click(arv.searchbx_2);
		type(arv.searchbx_2, AssessmentName);

		waitThread(4000);

		// Click View button
		click(ari.resulttab_viewbtn);
		waitThread(3000);

		// Assert Result popup visible
		Assert.assertTrue(isElementPresent(rwbt.resultpopup), "Result Popup  not visible");

		// Assert the heading Result
		Assert.assertEquals(getText(rwbt.label_Result_1), "Result");

		waitThread(3000);
		// Assert the Labels and Scores:
		// -Questions Answered
		Assert.assertTrue(getText(rwbt.lbl_studentAnswered).contains("Questions Answered"));
		Assert.assertEquals(getText(rwbt.value_studentAnswered), questans_count2);
		// -Score Received from Peer Reviewers
		Assert.assertEquals(getText(ari.score_rec_peer_lbl),
				"Score Received from Peer Reviewers\n" + score_rec_peer2 + "/" + TotalRewardScore);

		//// -Total Score (Score Received from Peer Reviewers + Score for Peer
		//// Review
		//// Done)
		Assert.assertTrue(getText(rwbt.lbl_TotalScore).contains("Total Score"));
		Assert.assertTrue(getText(rwbt.lbl_TotalScore)
				.contains("(Score Received from Peer Reviewers + Score for Peer Review Done)"));

		Assert.assertEquals(getText(rwbt.TotalScore), totalscore_stud2 + "/" + maxscoreposs1);
	}

	/*
	 * To verify the Score details of each questions [Student 2]
	 */
	@Test(priority = 68)
	public void TCSPR1500268() {

		// Assert the Score received from teacher label not present
		Assert.assertFalse(getText(rwbt.lbl_Scorefrm_teach).contains("Score Received from Teacher"));

		waitThread(3000);
		// Assert the Final score of Q1,Q2,Q3
		// [Should be the sum of Score received from the peersr+ score for
		// reviews done]
		int f1 = cm.StringtoInt(getText(ari.Q1_scorerec_frmpeer)) + cm.StringtoInt(getText(ari.Q1_scoreforrev));
		int f2 = cm.StringtoInt(getText(ari.Q2_scorerec_frmpeer)) + cm.StringtoInt(getText(ari.Q2_scoreforrev));
		int f3 = cm.StringtoInt(getText(ari.Q3_scorerec_frmpeer)) + cm.StringtoInt(getText(ari.Q3_scoreforrev));

		waitThread(3000);
		Assert.assertEquals(getText(ari.Q1_FinalScoreS2), cm.InttoString(f1));
		Assert.assertEquals(getText(ari.Q2_FinalScoreS2), cm.InttoString(f2));
		Assert.assertEquals(getText(ari.Q3_FinalScoreS2), cm.InttoString(f3));

		// Assert the Status of Q1 is Teacher Approved
		Assert.assertEquals(getText(ari.Q1_StatusS2), "Teacher Approved");

		// Assert the Status of Q2 is Teacher Approved
		Assert.assertEquals(getText(ari.Q2_StatusS2), "Teacher Approved");

		// Assert the Status of Q3 is Teacher Approved
		Assert.assertEquals(getText(ari.Q3_StatusS2), "Teacher Approved");

		// Click on Q1 view button
		click(ari.view_btn_q1S2);

		// Assert the Label Teacher Approved
		waitThread(3000);
		Assert.assertEquals(getText(arv.reviewstatus), "Teacher Approved");

		// Assert the Total Score of the Answer sheet same as in the Teacher
		// result
		// window
		Assert.assertEquals(getText(sasb.totalscr_lbl), "Total Score " + totalscore_stud2 + "/" + maxscoreposs1);

		// Perform Student 2 Logout
		waitThread(2000);
		cm.Logout();

		// Assert heading Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * Login As student 3 and check the Details of Result window
	 */
	@Test(priority = 69)
	public void TCSPR1500269() {

		// login as Student 3
		waitThread(2000);
		lg.login1(Emailstudent3, cm.Password);

		// Search the Assessment Name
		waitThread(5000);
		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		click(st1.stud_searchbx);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(3000);

		// Assert Label "Result Available"
		Assert.assertEquals(getText(ari.stud_cardhead_lbl), "Result Available");

		// Click View button
		click(rwbt.viewresultbtn);
		waitThread(3000);
		// Assert Result popup visible
		Assert.assertTrue(isElementPresent(rwbt.resultpopup), "Result Popup  not visible");

		// Assert the Labels and Scores:
		// -Questions Answered
		Assert.assertTrue(getText(rwbt.lbl_studentAnswered).contains("Questions Answered"));
		Assert.assertEquals(getText(rwbt.value_studentAnswered), questans_count3);

		// No of Peer Reviews Done
		Assert.assertTrue(getText(rwbt.lbl_ReviewsDone).contains("No of Peer Reviews Done"));
		Assert.assertEquals(getText(rwbt.studentPeerDone), quest_count + "/" + quest_count);

		// Score Received from Peer Reviewers/Teacher
		Assert.assertTrue(getText(rwbt.lbl_Scorefrm_teach).contains("Score Received from Peer Reviewers/Teacher"));
		Assert.assertEquals(getText(rwbt.Scorefrm_teach), score_from_teach3 + "/" + TotalTestPoints);

		// -Total Score (Score Received from Peer Reviewers/Teacher + Score for
		// Peer
		// Review Done)
		Assert.assertTrue(getText(rwbt.lbl_TotalScore).contains("Total Score"));
		Assert.assertTrue(getText(rwbt.lbl_TotalScore)
				.contains("(Score Received from Peer Reviewers/Teacher + Score for Peer Review Done)"));

		Assert.assertEquals(getText(rwbt.TotalScore), totalscore_stud3 + "/" + maxscoreposs1);

	}

	/*
	 * To verify the Score details of each questions [Student 3]
	 */
	@Test(priority = 70)
	public void TCSPR1500270() {

		// Assert the Scores Received from Teacher Of Q1
		Assert.assertEquals(getText(ari.Q1_scorefrm_teach), Stud3_scoreQ1);

		// Assert the Status of Q1 is Teacher Modified
		Assert.assertEquals(getText(ari.Q1_Status), "Teacher Modified");

		// Assert the Status of Q2 is Peer Review Completed
		Assert.assertEquals(getText(ari.Q2_Status), "Peer Review Completed");

		// Close popup
		waitThread(1000);
		click(ari.result_popup_close);
		waitThread(2000);

	}

	/*
	 * To perform Delete student3 Account functionality
	 */
	@Test(priority = 71)
	public void DeleteStudent3() {
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
	@Test(priority = 72)
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

	/*
	 * To perform Delete student1 Account functionality
	 */
	@Test(priority = 73)
	public void DeleteStudent1() {

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
	 * To perform Delete student2 Account functionality
	 */
	@Test(priority = 74)
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

}
