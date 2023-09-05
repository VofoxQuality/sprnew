package ResultWindowofIndividualTeacherTest;

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
import NewAssessmentOfTeacherPage.TeacherResultSectionPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowWizardPage;
import ResultWindowforIndividualStudent.Page.StudentAnswerSheetBasicsPage;
import ResultWindowforIndividualStudent.Page.StudentResultWindowBasicsPage;
import ResultWindowofIndividualTeacherPage.TeacherAutomaticResultPeerreviewIncompletePage;
import ResultWindowofIndividualTeacherPage.TeacherAutomaticResultreviewcompletePage;
import ResultWindowofIndividualTeacherPage.TeacherManualResultPeerreviewIncompletePage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import TestWindowOfIndividualStudent.AssessmentSubmitAndStatusPopUpPage;
import TestWindowOfIndividualStudent.ModifyWizardSectionPage;
import TestWindowOfIndividualStudent.TestWindowWizardPage;

public class TeacherManualResultPeerreviewIncompleteTest extends basePage {

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
	TeacherResultSectionPage tr = new TeacherResultSectionPage();
	StudentTestSectionPage st1 = new StudentTestSectionPage();
	ModifyWizardSectionPage ms = new ModifyWizardSectionPage();
	AssessmentSubmitAndStatusPopUpPage asp = new AssessmentSubmitAndStatusPopUpPage();
	TestWindowWizardPage tsw = new TestWindowWizardPage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	PeerReviewWindowPage prp = new PeerReviewWindowPage();
	StudentPeerReviewPage sp1 = new StudentPeerReviewPage();
	StudentResultWindowBasicsPage rwbt = new StudentResultWindowBasicsPage();
	StudentAnswerSheetBasicsPage sasb = new StudentAnswerSheetBasicsPage();
	TeacherAutomaticResultreviewcompletePage arv = new TeacherAutomaticResultreviewcompletePage();
	TeacherAutomaticResultPeerreviewIncompletePage ari = new TeacherAutomaticResultPeerreviewIncompletePage();
	TeacherManualResultPeerreviewIncompletePage mri = new TeacherManualResultPeerreviewIncompletePage();
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
	public void TCSPR1500502() {

		SoftAssert softAssert1 = new SoftAssert();
		lg.login1(Emailteacher, password);
		waitThread(4000);
		// click on Assessment tab
		click(ba.Assessmenttab);

		waitThread(5000);
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
	public void TCSPR1500403() {

		// Type Question 1
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		type(QP.Quest_box, Question1);
		driver.switchTo().defaultContent();

		// Page Scroll down
		QP.Scroll_DowntoEnd();

		// Click on Add rubric tab
		click(QP.rubric_drp_btn);

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Type data in Standard Rubric box
		driver.switchTo().frame("rubric_ifr");
		type(QP.std_rub_bx, Rubric1);
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
	public void TCSPR1500404() {

		// Type Question 2
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		type(QP.Quest_box, Question2);
		driver.switchTo().defaultContent();

		// Page Scroll down
		QP.Scroll_DowntoEnd();

		// Click on Add rubric tab
		click(QP.rubric_drp_btn);

		// Click Standard rubric radio button
		click(QP.std_rad);

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
	public void TCSPR1500405() {

		waitThread(2000);
		// Type Question 3
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		type(QP.Quest_box, Question3);
		driver.switchTo().defaultContent();

		// Page Scroll down
		QP.Scroll_DowntoEnd();

		// Click on Add rubric tab
		click(QP.rubric_drp_btn);

		// Click Standard rubric radio button
		click(QP.std_rad);

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
	public String studcount = "3";
	/*
	 * To verify the details on the peer review page
	 */
	public String peerstudname1;
	public String peerstudname2;

	@Test(priority = 6)
	public void TCSPR1500406() {

		waitThread(4000);
		// Enter peer review Reward score
		type(prw.peer_reward_scorebx, RewardPercent);

		waitThread(4000);
		// Assert the text::Total Students : Assert the total student count is 3
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : " + studcount);

		// Assert the 3 student names
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Student1name.trim());
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Student2name.trim());

		waitThread(2000);
	}

	/*
	 * To perform the save and next functionality from peer review page and
	 * verify the schedule page details
	 * 
	 */
	@Test(priority = 7)
	public void TCSPR1500407() {

		// Click Save&Next button
		click(pr.savennext_button);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);

		// Assert schedule wizard is selected
		waitThread(2000);
		Assert.assertEquals(getAttribute(sb1.schedule_wizard, "aria-expanded"), "true");

		// Assert the text "Select schedules for "
		Assert.assertEquals(getText(sb1.selectstu_lbl), "Select Schedules for");

		ScrollTo_xy_position(0, 250);
		// Click on Teacher will manually publish the result radio button
		click(sb1.teacherwill_radio);

		waitThread(3000);
		// Assert the radio button is selected
		Assert.assertTrue(getAttribute(sb1.teachwill_radio_select, "class").contains("checked"));

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
	public String Totalpeerreviewpoint;
	public String quest_count;
	public String maxscoreposs1;
	public String rewarscoreQ1;
	public String rewarscoreQ2;
	public String rewarscoreQ3;
	public int TotalRewardScore;

	@Test(priority = 8)
	public void TCSPR1500408() {

		quest_count = getText(sq.total_questcount);
		TotalTestPoints = getText(sq.total_testscore);

		// Assert the Total Questions: 3
		Assert.assertEquals(getText(sb.valuetotalQuestion), quest_count);

		// Assert the Total Test Points: 60
		Assert.assertEquals(getText(sb.lblTotaltestpoints), "Total Test Points: " + TotalTestPoints);

		Totalpeerreviewpoint = getText(sq.total_peereviewvalue);

		// To calculate Reward Score for Question 1
		rewarscoreQ1 = cm.getrewardscoreforquestion(Maxscore1, RewardPercent);

		// To calculate Reward Score for Question 2
		rewarscoreQ2 = cm.getrewardscoreforquestion(Maxscore2, RewardPercent);

		// To calculate Reward Score for Question 3
		rewarscoreQ3 = cm.getrewardscoreforquestion(Maxscore3, RewardPercent);

		// Calculating Total Peer Review points
		int TotalRewardScore = cm.StringtoInt(rewarscoreQ1) + cm.StringtoInt(rewarscoreQ2)
				+ cm.StringtoInt(rewarscoreQ3);
		Totalpeerreviewpoint = Integer.toString(TotalRewardScore);

		int maxscorepossible1 = TotalRewardScore + cm.StringtoInt(TotalTestPoints);
		maxscoreposs1 = String.valueOf(maxscorepossible1);

		waitThread(2000);
		// Assert the Total Peer Review Points: 30.0
		Assert.assertEquals(getText(sb.lblpeerreviewpoints), "Total Peer Review Points: " + Totalpeerreviewpoint);

		// Assert theMaximum Score Possible: 90.0
		Assert.assertEquals(getText(sb.lblmaxscore), "Maximum Score Possible: " + maxscoreposs1);

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
	public void TCSPR1500409() {

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

		waitThread(8000);
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
	public void TCSPR1500410() throws InterruptedException {
		// Login to Student1
		lg.login1(Emailstudent1, cm.Password);

		waitThread(3000);
		// Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		TimeUnit.MINUTES.sleep(2);

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
	public void TCSPR1500411() {

		// Enter Answer1
		driver.switchTo().frame("answer_ifr");
		type(tsw.answer_bx, "Answer 1_" + generateRandomData());
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
	public String testcount;

	@Test(priority = 12)
	public void TCSPR1500412() {

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

		// Read the Test attended count
		testcount = getText(st1.quest_count);

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
	public void TCSPR1500413() {

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
	public void TCSPR1500414() {

		// Enter Answer1
		driver.switchTo().frame("answer_ifr");
		type(tsw.answer_bx, "Answer 1_" + generateRandomData());
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
	public void TCSPR1500415() {

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
	@Test(priority = 16)
	public void TCSPR1500416() throws InterruptedException {
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

		TimeUnit.SECONDS.sleep(10);
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
	public void TCSPR1500417() {

		// Perform login by Student3
		lg.login1(Emailstudent3, cm.Password);

		waitThread(4000);
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

	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 18)
	public void TCSPR1500418() {

		waitThread(2000);
		// Click Begin Test
		click(st1.begintest_btn);

		waitThread(3000);
		// click on Answer 2 wizard
		click(asp.wizardans2);
		waitThread(3000);

		// To fill the Answer 2
		waitThread(1000);
		// To enter the data on Question box
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);
		type(asp.Answertextbx, "Answer 2_" + generateRandomData());
		waitThread(1000);
		driver.switchTo().defaultContent();

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
		MouseHover(tsw.save_btn_test);

		waitThread(2000);
		click(tsw.quest_3_wizard);
		// Third Question is selected
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("p-highlight"));

		ScrollTo_xy_position(0, 300);
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
	public void TCSPR1500420() {

		waitThread(2000);
		// Click Savebutton
		click(tsw.save_btn_test);
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

		waitThread(9000);

		// To perform logout functionality on the Student 3 profile
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * Login as Teacher and Reschedule the Test due and peer review start date
	 * To perform Login functionality of student 1 profile and check the
	 * Assessment card
	 */
	@Test(priority = 21)
	public void TCSPR1500421() throws InterruptedException {

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
		TimeUnit.SECONDS.sleep(8);

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
	 * To perfrom review for Question 2
	 */
	@Test(priority = 22)
	public void TCSPR1500422() {

		// click on save and next button
		click(prp.reviewbtnsaveandnext);

		waitThread(2000);
		// verify the Question 2 is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));

		ScrollTo_xy_position(0, 300);
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
	 * To perform review for Question 3 and submit the Review
	 */
	@Test(priority = 23)
	public void TCSPR1500423() throws InterruptedException {
		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "15");

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

		TimeUnit.SECONDS.sleep(5);
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
	public void TCSPR1500424() {

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
	 * To perfrom review for Question 1 and add comment for question 1
	 */
	public String S2Q1ScorefroStud1 = "1";

	@Test(priority = 25)
	public void TCSPR1500425() {

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
	public void TCSPR1500426() {

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
	public void TCSPR1500427() {

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
	 * To perform review for Question 2
	 */
	@Test(priority = 28)
	public void TCSPR1500428() {

		// click on save and next button
		click(prp.reviewbtnsaveandnext);

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
	 * functionality on the Student 3 profile
	 */
	@Test(priority = 29)
	public void TCSPR1500429() {

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
	public void TCSPR1500430() throws InterruptedException {

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
		waitThread(2000);

		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitThread(5000);

		click(st1.assess_searchbx);
		// search assessment
		type(st1.assess_searchbx, AssessmentName);
		driver.findElement(By.id("searchAssessments")).sendKeys("  ");
		TimeUnit.MINUTES.sleep(2);

		waitThread(3000);
		// Assert label result upcoming
		Assert.assertEquals(getText(tts.time_status), "Result Upcoming");

	}

	/*
	 * To verify the result section Labels
	 */
	@Test(priority = 31)
	public void TCSPR1500431() {
		// Assert the View result Button is Enabled
		Assert.assertTrue(isEnabled(arv.viewresult_teachcard), "View result button is disabled");

		// Assert label result upcoming
		Assert.assertEquals(getText(tts.time_status), "Result Upcoming");

		// Assert the Result status is pending
		Assert.assertEquals(getText(tr.resultsts_lbl), "Pending");

		// Assert text "You need to manually publish the result"
		Assert.assertEquals(getText(rd.manualpublishcard_txt), "You need to manually publish the result");

		// Assert the Button and Button label Evaluate Answers
		Assert.assertTrue(isElementPresent(arv.viewresult_teachcard), "Evaluate Answers button not present");
		Assert.assertEquals(getText(arv.viewresult_teachcard), "Evaluate Answers");

	}

	/*
	 * To verify the Evaluate Answer Button Functionality and check the back
	 * Button
	 */
	@Test(priority = 32)
	public void TCSPR1500432() {

		waitThread(3000);
		// Click on Evaluate Answer Button
		click(arv.viewresult_teachcard);

		waitThread(1000);
		// Assert the Heading Evaluate answer sheets and Publish result
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
	@Test(priority = 33)
	public void TCSPR1500433() throws InterruptedException {

		TimeUnit.SECONDS.sleep(10);
		// Click on Pending Evaluation Tab
		click(arv.pending_ev_tab);

		waitThread(3000);
		// Assert the pending evaluation tab is selected
		Assert.assertEquals(getAttribute(arv.pending_ev_tab, "aria-selected"), "true");

		// Search the Assessment Name
		// click(arv.search_bx);
		// type(arv.search_bx, AssessmentName);

		waitThread(4000);
		waitThread(3000);
		// Assert the Following Data's
		// -Course Name
		// -Assessment Name
		// -Max Score Selected
		// -Publishing Method -Manual
		// -Pending Evaluation-2 answer sheets

		Assert.assertEquals(getText(arv.assess_namegrid), AssessmentName);
		Assert.assertEquals(getText(arv.cours_namegrid), CourseName3.trim());
		Assert.assertEquals(getText(ari.max_scoregrid), maxscoreposs1);
		Assert.assertEquals(getText(ari.selectpublis_grid), "Manual");
		Assert.assertEquals(getText(ari.answersheetgrid), "2 answer sheets");

		// Click on View answers &Evaluate button
		click(ari.btn_view_ans_grid);

		waitThread(1000);
		// Assert the Heading Evaluate answer sheets and Publish result
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Evaluate answer sheets and Publish result");

		// Assert the Labels
		// Course Name: Course name and course ID
		// Assessment Name: Assessment Name
		Assert.assertEquals(getText(arv.courselbl), "Course Name: " + CourseName3.trim() + " " + "(" + CourseID3 + ")");
		Assert.assertEquals(getText(arv.assess_lbl), "Assessment Name: " + AssessmentName);
	}

	/*
	 * To verify the labels and score in the result window
	 */
	@Test(priority = 34)
	public void TCSPR1500434() {
		// Assert the Label and Value
		// -No of Answer Sheets Pending for Evaluation-2 Answer Sheets
		Assert.assertTrue(getText(ari.NofAnswerSheet_lbl).contains("No of Answer Sheets Pending for Evaluation"));
		Assert.assertEquals(getText(arv.studenttest_clsize_lbl),
				"No of Answer Sheets Pending for Evaluation\n" + "2 Answer Sheets");

		// Assert the Label and Value -Total Peer Review Points
		Assert.assertEquals(getText(arv.tot_peerpoints_lbl), "Total Peer Review Points\n" + Totalpeerreviewpoint);

		waitThread(3000);
		// Assert the Label and Value -Total Test Points
		Assert.assertEquals(getText(arv.tot_testpoints_lbl), "Total Test Points\n" + TotalTestPoints);

	}

	/*
	 * To verify the labels and score in the result window
	 */
	public String maxscorepossb;

	@Test(priority = 35)
	public void TCSPR1500435() {

		// Assert the Label and Value
		// -Maximum Score Possible
		// (Total Test Points + Total Peer Review Points)
		Assert.assertTrue(getText(arv.maxscoreposs_lbl).contains("Maximum Score Possible"));
		Assert.assertEquals(getText(arv.sum_totalpoints_lbl), "(Total Test Points + Total Peer Review Points)");

		int maxscorepossible1 = TotalRewardScore + cm.StringtoInt(TotalTestPoints);
		maxscorepossb = String.valueOf(maxscorepossible1);

		// Assert Publish button is disabled
		// Assert.assertFalse(isEnabled(ari.publish_btn), "publish button is
		// enabled");

		// Assert the color green for Completed
		Assert.assertTrue(getAttribute(arv.completed_lbl, "Class").contains("green-dot"));

		// Assert the color orange for Incomplete
		Assert.assertTrue(getAttribute(arv.incomplete_lbl, "Class").contains("orange-dot"));

	}

	/*
	 * To verify the grid Label on the Teacher result window
	 */
	@Test(priority = 36)
	public void TCSPR1500436() {

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
	 * To check the Evaluate button functionality and check the Evaluate comment
	 * box functionality[Student 1]
	 */
	@Test(priority = 37)
	public void TCSPR1500437() {

		// Assert the Button Label Evaluate
		Assert.assertEquals(getText(ari.eval_btn), "Evaluate");

		// Click on Evaluate Button
		click(ari.eval_btn);

		// Assert the Evaluate comment popup visible
		Assert.assertTrue(isElementPresent(ari.sys_popup), "popup not present");

		// Assert the Label "Evaluate"
		Assert.assertEquals(getText(ari.sys_popup_lbl), "Evaluate");

		// Assert the text "Question No 2,3 has not been Peer Reviewed"
		Assert.assertEquals(getText(ari.sys_popup_txt), "Question No 2,3 has not been Peer Reviewed");

		waitThread(2000);
		// Click on Close button
		click(ari.sys_popup_clos_btn);

		waitThread(3000);
		// Assert the Evaluate comment popup Not visible
		Assert.assertFalse(isElementPresent(ari.sys_popup), "popup present");

		waitThread(4000);
		// Assert the Assessment Name,Course name,Course ID,Student Name
		Assert.assertEquals(getText(arv.result_page_assess_name), AssessmentName);
		Assert.assertTrue(getText(arv.course_name_id).contains(CourseName3));
		Assert.assertTrue(getText(arv.course_name_id).contains(CourseID3));
		Assert.assertTrue(getText(arv.stud_name_resultwindow).contains(Student1name));

	}

	/*
	 * To verify the Answer window Wizard functionalities
	 */
	@Test(priority = 38)
	public void TCSPR1500438() {

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
	@Test(priority = 39)
	public void TCSPR1500439() {

		// Assert the Button Evaluate Comment button
		Assert.assertTrue(isDisplayed(ari.sys_comment_btn), "Comment button not present");

		// Click on comment button
		click(ari.sys_comment_btn);

		// Assert the Button Evaluate Comment popup visible
		Assert.assertTrue(isElementPresent(ari.sys_popup), "popup not present");

		waitThread(2000);
		// Click on Close button
		click(ari.sys_popup_clos_btn);

		waitThread(3000);
		// Assert the Button Evaluate Comment popup Not visible
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
	@Test(priority = 40)
	public void TCSPR1500440() {

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
	@Test(priority = 41)
	public void TCSPR1500441() {

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
	@Test(priority = 42)
	public void TCSPR1500442() {

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
		Assert.assertEquals(getText(ari.view_nxt_sheetbtn), "Evaluate next answer sheet");
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

		waitThread(1000);
		// Assert the Question 1 Score box is Empty
		Assert.assertEquals(getValue(ari.addscore_txtbx), "");

	}

	/*
	 * To Edit the Question 1 Score and check the Save and Continue button
	 * functionality on the confirmation popup
	 */
	public String ScoreQ1 = "2";

	@Test(priority = 43)
	public void TCSPR1500443() {

		// Click on Peer reviewer Name
		ScrollTo_xy_position(0, 300);
		click(ari.reviewed_stud1name);

		// Assert The comment added
		driver.switchTo().frame("commentEditor_0_ifr");
		Assert.assertEquals(getText(ari.commentadded_stud1), "Comment1");
		driver.switchTo().defaultContent();

		// Type Score for Question 1
		ScrollTo_xy_position(300, 0);
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
	@Test(priority = 44)
	public void TCSPR1500444() {

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

		// Assert Label :No of Answer Sheets Pending for Evaluation ,2 Answer
		// Sheets
		Assert.assertEquals(getText(arv.studenttest_clsize_lbl),
				"No of Answer Sheets Pending for Evaluation\n" + "2 Answer Sheets");

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
	 * To verify the Evaluate Answer 2 functionality on the result window
	 */
	@Test(priority = 45)
	public void TCSPR1500445() throws InterruptedException {

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
		// Assert the Wizard status complete/Evaluate
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
	 * To check the View next Answer sheet functionality on the Answer window
	 */
	public String S1ScoreQ2 = "3";

	@Test(priority = 46)
	public void TCSPR1500446() {
		// Type Score for Question 2
		click(ari.addscore_txtbx);
		type(ari.addscore_txtbx, S1ScoreQ2);

		waitThread(1000);
		// Click on Exit button
		click(arv.exit_btn);

		waitThread(1000);
		// Click on Save and Continue button
		click(ari.savecont_btn);

		waitThread(1000);
		// Click On Evaluate Next answer sheet Button
		click(ari.view_nxt_sheetbtn);

		waitThread(1000);
		click(ari.sys_popup_clos_btn);
		waitThread(3000);

		// Assert the Student 2 Name on the Page
		Assert.assertTrue(getText(arv.stud_name_resultwindow).contains(Student2name));

		// Assert the wizard having no status labels
		waitThread(2000);
		Assert.assertFalse(getAttribute(arv.wizardq2, "class").contains("complete"));

		// Click on Exit button
		click(arv.exit_btn);
		waitThread(3000);

		// Assert the Heading Evaluate answer sheets and Publish result
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Evaluate answer sheets and Publish result");

		// Assert the Student 1 Newley added score visible on the Score Received
		// from
		// Teacher/Peers Field
		// Score Q1+Score Q2
		int Score = (Integer.parseInt(ScoreQ1)) + (Integer.parseInt(S1ScoreQ2));
		Assert.assertEquals(getText(ari.scorerec_fromteach_stud1), Integer.toString(Score));

		// Assert that the Total Score is sum of Score Received from
		// Teacher/Peers+Reward Point
		String rewscore = getText(ari.rewarescore_stud1);
		int tot = (Integer.parseInt(rewscore)) + Score;
		Assert.assertEquals(getText(ari.totscore_stud1), Integer.toString(tot));

	}

	/*
	 * To verify the Evaluate Answer 3 functionality on the result window
	 */
	public String ScoreQ3 = "1";

	@Test(priority = 47)
	public void TCSPR1500447() {

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
	 * To check the Evaluation complete Exit popup functionality
	 */
	@Test(priority = 48)
	public void TCSPR1500448() {

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
		// -Evaluate next answer sheet
		// -Back to results
		Assert.assertEquals(getText(ari.cont_currentev_btn), "Modify current evaluation");
		Assert.assertEquals(getText(ari.view_nxt_sheetbtn), "Evaluate next answer sheet");
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

	}

	/*
	 * To verify the card status when evaluation complete
	 */
	@Test(priority = 49)
	public void TCSPR1500449() throws InterruptedException {

		waitThread(2000);
		// Assert the label "1 Answer Sheets"
		Assert.assertTrue(getText(arv.studenttest_clsize_lbl).contains("1 Answer Sheets"));

		// Click Back button
		click(arv.back_btn);
		waitThread(6000);

		// Click Current assessment tab
		click(arv.cuurent_assm_tab);

		TimeUnit.SECONDS.sleep(10);

		// Search the Assessment Name
		click(st1.assess_searchbx);
		type(st1.assess_searchbx, AssessmentName);
		waitThread(5000);

		// Assert the result section label "pending"
		Assert.assertEquals(getText(tr.resultsts_lbl), "Pending");

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
	@Test(priority = 50)
	public void TCSPR1500450() {

		// Assert student1 button View/Modify[Button and button label]
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[11]/div/button/span"),
				"View/Modify Score");

		// Click on View/Modify of Student 1
		cm.clickrewardscoreofstudent(Student1name, "//p-table[@id='questionResultListingTable']//div[1]/table//tr[",
				"]/td[11]/div/button/span");

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
		// Assert the label "2 Answer Sheets"
		Assert.assertTrue(getText(arv.studenttest_clsize_lbl).contains("2 Answer Sheets"));

		// Click Back button
		click(arv.back_btn);
		waitThread(5000);

		// Search the Assessment Name
		click(st1.assess_searchbx);
		type(st1.assess_searchbx, AssessmentName);
		waitThread(3000);

		// Assert the result section label "pending"
		// Assert labels: -You need to manually publish the result
		// -No of Answer sheets pending for evaluation: 2
		// Assert.assertEquals(getText(ari.teach_manually_txt), "You need to
		// manually publish the result");
		// Assert.assertEquals(getText(tr.resultsts_lbl), "Pending");
		// Assert.assertEquals(getText(ari.answrsheet_evalu_txt), "No of Answer
		// sheets pending for evaluation: 2");

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

	@Test(priority = 51)
	public void TCSPR1500451() {

		// Click on continue Evaluation button
		cm.clickrewardscoreofstudent(Student1name, "//p-table[@id='questionResultListingTable']//div[1]/table//tr[",
				"]/td[11]/div/button/span");

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
		// Click on Exit button
		click(arv.exit_btn);
		waitThread(2000);

		// Click On Evaluate Next Answer sheet
		click(ari.view_nxt_sheetbtn);

		waitThread(1000);
		// Assert the popup Label -Evaluate
		Assert.assertEquals(getText(ari.sys_popup_lbl), "Evaluate");

		// -Question No 1 has not been Peer Reviewed
		Assert.assertEquals(getText(ari.sys_popup_txt), "Question No 1 has not been Peer Reviewed");

	}

	/*
	 * To perform Evaluation of student 2
	 */
	public String Stud2_scoreQ1 = "5";

	@Test(priority = 52)
	public void TCSPR1500452() {

		waitThread(1000);
		// Click on Close button
		click(ari.sys_popup_clos_btn);

		waitThread(1000);
		// Assert the Evaluate comment popup not visible
		Assert.assertFalse(isElementPresent(ari.sys_popup), "Popup visible");

		waitThread(3000);
		// Assert the Student 2 Name on the Page
		Assert.assertTrue(getText(arv.stud_name_resultwindow).contains(Student2name));

		waitThread(3000);
		// Assert the Wizard shows Orange colr
		Assert.assertTrue(getAttribute(arv.wizardq1, "class").contains("orange"));

		// Assert i approved the total Score of answer sheet checkbox and label
		// not
		// visible on the page
		Assert.assertFalse(isElementPresent(ari.score_checkbx), "Check box present");

		// Type Score for Question 1
		click(ari.addscore_txtbx);
		type(ari.addscore_txtbx, Stud2_scoreQ1);

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
		Assert.assertEquals(getText(ari.scorefromteach_lbl), "Score Received from Teacher: " + Stud2_scoreQ1);

	}

	/*
	 * To perform Evaluation of student 3
	 */
	@Test(priority = 53)
	public void TCSPR1500453() {

		// Click on Exit button
		click(arv.exit_btn);

		waitThread(3000);
		// Click On Evaluate Next answer sheet Button
		click(ari.view_nxt_sheetbtn);

		waitThread(4000);
		// Assert the student 3 name on the page
		Assert.assertTrue(getText(arv.stud_name_resultwindow).contains(Student3name));

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

		// Click On Back to results Button
		click(ari.score_back_resltbtn);

	}

	/*
	 * To check the Student 1,2,3 Labels and Scores
	 */
	public String score_from_teach1;
	public String score_from_teach2;
	public String Totscore1;
	public String Totscore2;
	public String Totscore3;

	@Test(priority = 54)
	public void TCSPR1500454() {

		waitThread(2000);
		// Assert the publish button is Enabled
		Assert.assertTrue(isEnabled(ari.publish_btn), "publish button is disabled");

		// Assert the Labels:No of Answer Sheets Pending for Evaluation- 0
		// Answer Sheets
		Assert.assertEquals(getText(arv.studenttest_clsize_lbl),
				"No of Answer Sheets Pending for Evaluation\n" + "0 Answer Sheets");

		// Assert the Score Received from Teacher/Peers of Student 1 and Student
		// 2
		score_from_teach1 = cm.getdatafromgrid(Student1name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[8]/div/span");
		score_from_teach2 = cm.getdatafromgrid(Student2name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[8]/div/span");

		// Assert the Total Score of Student 1,student 2,student 3
		Totscore1 = getText(ari.totscore_stud1);
		Totscore2 = getText(ari.totscore_stud2);
		Totscore3 = getText(ari.totscore_stud3);

		// Assert the Label of Student 1 is Evaluation Completed
		Assert.assertEquals(getText(ari.Q1_Status), "Evaluation Completed");

		// Assert the Label of Student 2 is Evaluation Completed
		Assert.assertEquals(getText(ari.Q2_Status), "Evaluation Completed");

		// Assert the Label of Student 3 is Peer Scores Approved
		Assert.assertEquals(getText(ari.Q3_Status), "Peer Scores Approved");

		// Assert the Score Received from Teacher/Peers of student 3 is empty
		Assert.assertEquals(getText(ari.scorerec_fromteach_stud3), "--");

	}

	/*
	 * To perform publish the result functionality on the teacher login
	 */
	public String questans_countS1;
	public String questans_countS2;
	public String questans_countS3;
	public String rewardpoint_stud1;
	public String Q1score;

	@Test(priority = 55)
	public void TCSPR1500455() {

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

		rewardpoint_stud1 = getText(ari.rewarescore_stud1);
		questans_countS1 = cm.getdatafromgrid(Student1name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[4]/div/span");
		questans_countS2 = cm.getdatafromgrid(Student2name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[4]/div/span");
		questans_countS3 = cm.getdatafromgrid(Student3name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[4]/div/span");

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

	@Test(priority = 56)
	public void TCSPR1500456() {

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
		Assert.assertEquals(getText(rwbt.value_studentAnswered), questans_countS1);

		Assert.assertTrue(getText(rwbt.lbl_ReviewsDone).contains("No of Peer Reviews Done"));
		Assert.assertEquals(getText(rwbt.studentPeerDone), "2/2");

		Assert.assertTrue(getText(rwbt.lbl_ScoreforReviewsDone).contains("Score for Reviews Done"));
		Assert.assertEquals(getText(rwbt.ScoreforReviewsDone), rewardpoint_stud1 + "/" + Totalpeerreviewpoint);

		Assert.assertTrue(getText(rwbt.lbl_Scorefrm_teach).contains("Score Received from Teacher"));
		Assert.assertEquals(getText(rwbt.Scorefrm_teach), score_from_teach1 + "/" + TotalTestPoints);

		Assert.assertTrue(getText(rwbt.lbl_TotalScore).contains("Total Score"));
		Assert.assertTrue(
				getText(rwbt.lbl_TotalScore).contains("(Score Received from Teacher + Score for Peer Review Done)"));
		Assert.assertEquals(getText(rwbt.TotalScore), Totscore1 + "/" + maxscoreposs1);

	}

	/*
	 * To verify the Score details of each questions [Student 1]
	 */
	@Test(priority = 57)
	public void TCSPR1500457() {

		waitThread(3000);
		// Assert the Scores Received from Peer Reviewers of Question 1
		Assert.assertEquals(getText(rwbt.Q1_scorefrompeers), S2Q1ScorefroStud1);

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
	@Test(priority = 58)
	public void TCSPR1500458() {

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
	@Test(priority = 59)
	public void TCSPR1500459() {

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
		driver.findElement(By.cssSelector("#publishedResultAssessmentDropDownDiv > div > span > input")).sendKeys("  ");
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
		Assert.assertEquals(getText(rwbt.value_studentAnswered), questans_countS2);

		// -Score Received from Peer Reviewers/Teacher
		Assert.assertEquals(getText(ari.score_rec_peer_lbl),
				"Score Received from Peer Reviewers/Teacher\n" + score_from_teach2 + "/" + Totalpeerreviewpoint);

		//// -Total Score ((Score Received from Peer Reviewers/Teacher + Score
		//// for Peer
		//// Review
		//// Done)
		Assert.assertTrue(getText(rwbt.lbl_TotalScore).contains("Total Score"));
		Assert.assertTrue(getText(rwbt.lbl_TotalScore)
				.contains("(Score Received from Peer Reviewers/Teacher + Score for Peer Review Done)"));

		Assert.assertEquals(getText(rwbt.TotalScore), Totscore2 + "/" + maxscoreposs1);
	}

	/*
	 * To verify the Score details of each questions [Student 2]
	 */
	@Test(priority = 60)
	public void TCSPR1500460() {

		// Assert the Score received from teacher Label on the grid
		Assert.assertEquals(getText(rwbt.lblscorefromteach), "Scores Received from\n" + "Teacher");

		waitThread(2000);
		// Assert the Score received from teacher of Q1
		Assert.assertEquals(getText(ari.Q1_scorefrm_teach), Stud2_scoreQ1);

		Q1score = getText(ari.Q1_scoreforrev);

		waitThread(3000);
		// Assert the Final score of Q1,Q2,Q3
		// [Should be the sum of Score received from the peers+ score for
		// reviews done]
		int f1 = cm.StringtoInt(Stud2_scoreQ1) + cm.StringtoInt(Q1score);
		int f2 = cm.StringtoInt(getText(ari.Q2_scorerec_frmpeer)) + cm.StringtoInt(getText(ari.Q2_scoreforrev));
		int f3 = cm.StringtoInt(getText(ari.Q3_scorerec_frmpeer)) + cm.StringtoInt(getText(ari.Q3_scoreforrev));

		waitThread(2000);
		Assert.assertEquals(getText(mri.finalscoreq1), cm.InttoString(f1));

		Assert.assertEquals(getText(mri.finalscoreq2), cm.InttoString(f2));

		Assert.assertEquals(getText(mri.finalscoreq3), cm.InttoString(f3));

		waitThread(2000);
		// Assert the Status of Q1 is Teacher Evaluated
		Assert.assertEquals(getText(ari.Q1_Status), "Teacher Evaluated");

		// Assert the Status of Q2 is Peer Review Completed
		Assert.assertEquals(getText(ari.Q2_Status), "Peer Review Completed");

		// Assert the Status of Q3 is Peer Review Completed
		Assert.assertEquals(getText(ari.Q3_Status), "Peer Review Completed");

	}

	/*
	 * To check the Details of Answer window
	 */
	@Test(priority = 61)
	public void TCSPR1500461() {

		// Click on Q1 view button
		click(ari.view_btn_q1);

		// Assert the Label Teacher Evaluated
		waitThread(3000);
		Assert.assertEquals(getText(arv.reviewstatus), "Teacher Evaluated");

		// Assert the Total Score of the Answer sheet same as in the Teacher
		// result
		// window
		Assert.assertEquals(getText(sasb.totalscr_lbl), "Total Score " + Totscore2 + "/" + maxscoreposs1);

		// Perform Student 2 Logout
		waitThread(2000);
		cm.Logout();

		// Assert heading Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * Login As student 2 and check the Details of Result window
	 */
	@Test(priority = 62)
	public void TCSPR1500462() {

		// login as Student 3
		waitThread(2000);
		lg.login1(Emailstudent3, cm.Password);

		// Search the Assessment Name
		waitThread(5000);
		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		click(st1.stud_searchbx);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys("   ");
		waitThread(3000);

		// Assert Label "Result Available"
		Assert.assertEquals(getText(ari.stud_cardhead_lbl), "Result Available");

		// Click View button
		click(rwbt.viewresultbtn);
		waitThread(3000);

		// Assert Result popup visible
		Assert.assertTrue(isElementPresent(rwbt.resultpopup), "Result Popup  not visible");

		// Assert the heading Result
		Assert.assertEquals(getText(rwbt.label_Result_1), "Result");
	}

	/*
	 * To check the Details of Result window
	 */
	@Test(priority = 63)
	public void TCSPR1500463() {

		// Assert the Labels and Scores:
		// Questions Answered 3/4
		Assert.assertTrue(getText(rwbt.lbl_studentAnswered).contains("Questions Answered"));
		Assert.assertEquals(getText(rwbt.value_studentAnswered), questans_countS3);

		// No of Peer Reviews Done 2/3
		Assert.assertTrue(getText(rwbt.lbl_ReviewsDone).contains("No of Peer Reviews Done"));
		Assert.assertEquals(getText(rwbt.studentPeerDone), "2/3");

		// Score Received from Peer Reviewers
		Assert.assertTrue(getText(rwbt.lbl_Scorefrm_teach).contains("Score Received from Peer Reviewers"));
		Assert.assertEquals(getText(rwbt.Scorefrm_teach), score_from_teach2 + "/" + TotalTestPoints);

		// Total Score (Score Received from Peer Reviewers + Score for Peer
		// Review Done)
		Assert.assertTrue(getText(rwbt.lbl_TotalScore).contains("Total Score"));
		Assert.assertTrue(getText(rwbt.lbl_TotalScore)
				.contains("(Score Received from Peer Reviewers + Score for Peer Review Done)"));
		Assert.assertEquals(getText(rwbt.TotalScore), Totscore3 + "/" + maxscoreposs1);

	}

	/*
	 * To verify the Score details of each questions [Student 3]
	 */
	@Test(priority = 64)
	public void TCSPR1500464() {

		// Assert the Score received from teacher label not present
		Assert.assertFalse(getText(rwbt.lbl_Scorefrm_teach).contains("Score Received from Teacher"));

		// Assert the Final Score of Q2 and Q3
		int f2 = cm.StringtoInt(getText(ari.Q2_scorerec_frmpeer)) + cm.StringtoInt(getText(ari.Q2_scoreforrev));
		int f3 = cm.StringtoInt(getText(ari.Q3_scorerec_frmpeer)) + cm.StringtoInt(getText(ari.Q3_scoreforrev));

		waitThread(3000);
		Assert.assertEquals(getText(ari.Q2_FinalScoreS2), cm.InttoString(f2));
		Assert.assertEquals(getText(ari.Q3_FinalScoreS2), cm.InttoString(f3));

		// Assert the Status of Q1 is Unanswered Question
		Assert.assertEquals(getText(ari.Q1_StatusS2), "Unanswered Question");

		// Assert the Status of Q2 is Teacher Approved
		Assert.assertEquals(getText(ari.Q2_StatusS2), "Teacher Approved");

		// Assert the Status of Q3 is Teacher Approved
		Assert.assertEquals(getText(ari.Q3_StatusS2), "Teacher Approved");
	}

	/*
	 * To check the Details of Answer window
	 */
	@Test(priority = 65)
	public void TCSPR1500465() {

		waitThread(2000);
		// Click on Q1 view button
		click(ari.view_btn_q1S2);

		// Assert the Label "Unanswerd Question"
		waitThread(6000);
		Assert.assertEquals(getText(arv.reviewstatus), "Unanswered Question");

		// Assert the Labels and Scores -Max Score: -Final Score:
		Assert.assertEquals(getText(ari.finalscorelbl), "Final Score: 0");
		Assert.assertEquals(getText(ari.maxscorelbl), "Max Score: " + rewarscoreQ1);

		waitThread(3000);
		// Click on Q2 Wizard button
		click(sasb.wizardq2);

		waitThread(3000);
		// Assert the Label Teacher Approved
		Assert.assertEquals(getText(arv.reviewstatus), "Teacher Approved");

		// Assert the Total Score of the Answer sheet same as in the result
		// window
		Assert.assertEquals(getText(sasb.totalscr_lbl), "Total Score " + Totscore3 + "/" + maxscoreposs1);

	}

	/*
	 * To perform Delete student3 Account functionality
	 */
	@Test(priority = 66)
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
	@Test(priority = 67)
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
	@Test(priority = 68)
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
	@Test(priority = 69)
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
