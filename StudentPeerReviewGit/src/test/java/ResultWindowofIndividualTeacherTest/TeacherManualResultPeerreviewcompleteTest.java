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
import ResultWindowofIndividualTeacherPage.TeacherManualResultPeerreviewcompletePage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import TestWindowOfIndividualStudent.AssessmentSubmitAndStatusPopUpPage;
import TestWindowOfIndividualStudent.ModifyWizardSectionPage;
import TestWindowOfIndividualStudent.TestWindowWizardPage;

public class TeacherManualResultPeerreviewcompleteTest extends basePage {
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
	ModifyWizardSectionPage ms = new ModifyWizardSectionPage();
	TeacherResultSectionPage tr = new TeacherResultSectionPage();
	AssessmentSubmitAndStatusPopUpPage asp = new AssessmentSubmitAndStatusPopUpPage();
	TestWindowWizardPage tsw = new TestWindowWizardPage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	PeerReviewWindowPage prp = new PeerReviewWindowPage();
	StudentPeerReviewPage sp1 = new StudentPeerReviewPage();
	StudentResultSectionPage srs = new StudentResultSectionPage();
	StudentResultWindowBasicsPage rwbt = new StudentResultWindowBasicsPage();
	TeacherAutomaticResultreviewcompletePage arv = new TeacherAutomaticResultreviewcompletePage();
	TeacherAutomaticResultPeerreviewIncompletePage ari = new TeacherAutomaticResultPeerreviewIncompletePage();
	StudentAnswerSheetBasicsPage sasb = new StudentAnswerSheetBasicsPage();
	TeacherManualResultPeerreviewcompletePage mrp = new TeacherManualResultPeerreviewcompletePage();
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
	public void TCSPR1500303() {
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
	public void TCSPR1500304() {
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
	public void TCSPR1500305() {

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
	/*
	 * To verify the details on the peer review page
	 */

	public String RewardPercent = "100";
	public String studcount = "3";

	@Test(priority = 6)
	public void TCSPR1500306() {

		waitThread(4000);
		// Enter peer review Reward score
		type(prw.peer_reward_scorebx, RewardPercent);

		waitThread(4000);
		// Assert the text::Total Students : Assert the total student count is 3
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : " + studcount);

		// Assert the 3 student names
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Student1name.trim());
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Student2name.trim());
		Assert.assertEquals(getText(ps.studantname3_gridval).trim(), Student3name.trim());

	}

	/*
	 * To perform the save and next functionality from peer review page and
	 * verify the schedule page details
	 * 
	 */
	@Test(priority = 7)
	public void TCSPR1500307() {

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
	public void TCSPR1500308() {

		quest_count = getText(sq.total_questcount);

		// Assert the Total Questions: 3
		Assert.assertEquals(getText(sb.valuetotalQuestion), quest_count);

		TotalTestPoints = getText(sq.total_testscore);

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
	 * assessment visible on the Current tab
	 * 
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 9)
	public void TCSPR1500309() {

		waitThread(2000);
		// Click Back to Menu
		click(tts.back_to_menubutton);

		waitThread(3000);
		click(st1.assess_searchbx);

		// search the assessment
		type(st1.assess_searchbx, AssessmentName);

		// Assert the newly published card visible on the current assessment
		// page
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");

		// Assert the Result section label:You need to manually publish the
		// result
		Assert.assertEquals(getText(rd.manualpublishcard_txt), "You need to manually publish the result");

		// Assert the View result button is Disabled
		Assert.assertEquals(getAttribute(tr.evaluateans_btn, "disabled"), "true");

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
	public void TCSPR1500310() throws InterruptedException {

		// Login to Student1
		lg.login1(Emailstudent1, cm.Password);

		waitThread(3000);
		// Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		// Search Assessment name
		Doubleclick(st1.stud_searchbx);
		type(st1.stud_searchbx, AssessmentName);
		waitThread(2000);
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(80);
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
	public void TCSPR1500311() {

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
	public String testcount;

	@Test(priority = 12)
	public void TCSPR1500312() {

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
	public void TCSPR1500313() {

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
	public void TCSPR1500314() {

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
	public void TCSPR1500315() {

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
	 * perform logout functionality on the Student 2 profile
	 */
	@Test(priority = 16)
	public void TCSPR1500316() throws InterruptedException {
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
	public void TCSPR1500317() {
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
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 18)
	public void TCSPR1500318() {

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
		waitThread(1000);
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
	public void TCSPR1500319() {

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
	public void TCSPR1500320() {

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
	 */
	@Test(priority = 21)
	public void TCSPR1500321() throws InterruptedException {

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
	 * To perform review for Question 1 and Question 2
	 */
	public String stud1scores1q1 = "5";
	public String stud1scores1q2 = "10";

	@Test(priority = 22)
	public void TCSPR1500322() {

		ScrollTo_xy_position(0, 300);
		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, stud1scores1q1);

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
		type(prp.scorestud1, stud1scores1q2);

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
	 * functionality on the Student 1 profile
	 */
	public String stud1scores1q3 = "10";

	@Test(priority = 23)
	public void TCSPR1500323() {

		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, stud1scores1q3);

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
	public void TCSPR1500324() {
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
	 * To perform review for Question 1& Question2
	 */

	@Test(priority = 25)
	public void TCSPR1500225() {
		Scroll_DowntoEnd();
		waitThread(2000);

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
	 * functionality on the Student 3 profile
	 */
	@Test(priority = 26)
	public void TCSPR1500326() throws InterruptedException {

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
		waitThread(4000);

		TimeUnit.SECONDS.sleep(6);

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
	public void TCSPR1500327() {

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
	 * To perfrom review for Question 1 and Question 2
	 */
	@Test(priority = 28)
	public void TCSPR1500328() {

		Scroll_DowntoEnd();
		waitThread(2000);
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

		// click on save and next button
		click(prp.reviewbtnsaveandnext);
		waitFor(QP.toaster);

		// verify the toaster "Score Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);

		// verify the Question 3 is selected
		Assert.assertTrue(getAttribute(asp.wizardans3, "class").contains("p-highlight"));

	}

	/*
	 * To perform review for Question 3 and submit the Review To perform logout
	 * functionality on the Student 3 profile
	 */
	@Test(priority = 29)
	public void TCSPR1500329() {

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
	 * Perform teacher login and reschedule the peer review and result date
	 */
	@Test(priority = 30)
	public void TCSPR1500330() throws InterruptedException {

		// Login to Teacher profile
		cm.login(Emailteacher, cm.Password);

		// Click Assessment tab
		click(QP.teach_assesstab);

		waitThread(5000);

		// search assessment
		type(st1.assess_searchbx, AssessmentName);
		driver.findElement(By.id("searchAssessments")).sendKeys("   ");
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
		driver.findElement(By.id("searchAssessments")).sendKeys("   ");
		TimeUnit.MINUTES.sleep(2);

	}

	/*
	 * To verify the result section Labels
	 */
	@Test(enabled = false)
	public void TCSPR1500331() {
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
	 * Perform Logout Functionality on the Teacher Account and Login the Student
	 * Page and check the Card result status
	 */
	@Test(priority = 32)
	public void TCSPR1500332() {

		// To perform logout functionality from Teacher account
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// Perform login by Student1
		lg.login1(Emailstudent1, cm.Password);
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

		// Assert the text "Teacher will publish the result manually"
		Assert.assertEquals(getText(srs.teach_publish_label), "Teacher will publish the result manually");

		// Assert View Result button disabled
		Assert.assertEquals(getAttribute(tr.evaluateans_btn, "disabled"), "true");

		// To perform logout functionality from Student1 account
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * Perform Teacher Login and check the Evaluate Answer Button Functionality
	 * and check the back Button
	 */
	@Test(priority = 33)
	public void TCSPR1500333() {

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
		// Assert the Heading Peer Review Results
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Peer Review Results");

		// Assert the Back Button
		Assert.assertEquals(getText(arv.back_btn), "Back");

		// Click the Back Button
		click(arv.back_btn);

		waitThread(3000);
		// Assert the Current Tab is selected
		Assert.assertTrue(isDisplayed(arv.current_tab), "Current tab not present");

		waitThread(5000);
		// Click on Evaluate Answer Button
		click(arv.viewresult_teachcard);

		waitThread(5000);
		// Assert the Labels
		// Course Name: Course name and course ID
		// Assessment Name: Assessment Name
		Assert.assertEquals(getText(arv.courselbl), "Course Name: " + CourseName3.trim() + " " + "(" + CourseID3 + ")");
		Assert.assertEquals(getText(arv.assess_lbl), "Assessment Name: " + AssessmentName);

	}

	/*
	 * To verify the labels and score in the result window
	 */
	public String cls_size;

	@Test(priority = 34)
	public void TCSPR1500334() {

		// Assert the Heading Peer Review Results
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Peer Review Results");

		// Assert the Label and Value-Students tested/Class size
		cls_size = getText(arv.studenttest_clsize);
		Assert.assertEquals(getText(arv.studenttest_clsize_lbl), "Students tested/Class size\n" + cls_size);

		// Assert the Label and Value-Total Questions
		Assert.assertEquals(getText(arv.tot_quest_count_lbl), "Total Questions\n" + quest_count);

		// Assert the Label and Value-Total Peer Review Points
		Assert.assertEquals(getText(arv.tot_peerpoints_lbl), "Total Peer Review Points\n" + Totalpeerreviewpoint);

	}

	/*
	 * To verify the labels and score in the result window
	 */
	@Test(priority = 35)
	public void TCSPR1500335() {

		// Assert the Label and Value-Total Test Points
		Assert.assertEquals(getText(arv.tot_testpoints_lbl), "Total Test Points\n" + TotalTestPoints);

		// Assert the Label and Value-Maximum Score Possible
		// (Total Test Points + Total Peer Review Points)
		Assert.assertEquals(getText(arv.maxscoreposs_lbl),
				"Maximum Score Possible\n(Total Test Points + Total Peer Review Points)\n" + maxscoreposs1);

		// Assert Publish button is enabled
		Assert.assertTrue(isEnabled(ari.publish_btn), "publish button is disabled");

		waitThread(3000);
		// Assert the color green for Completed
		Assert.assertTrue(getAttribute(arv.completed_lbl, "Class").contains("green-dot"));

		// Assert the color orange for Incomplete
		Assert.assertTrue(getAttribute(arv.incomplete_lbl, "Class").contains("orange-dot"));

	}

	/*
	 * To verify the grid Label on the Teacher result window
	 */
	String rewscore1;
	String totalscorestud1;

	@Test(priority = 36)
	public void TCSPR1500336() {

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

		// Assert the reward score of student 1
		rewscore1 = getText(ari.rewarescore_stud1);
		totalscorestud1 = getText(ari.totscore_stud1);

		// Assert the Score received from teacher
		Assert.assertEquals(getText(ari.scorerec_fromteach_stud1), "--");

	}

	/*
	 * To Modify the Scores of Student 2[Ben Alex]
	 */
	@Test(priority = 37)
	public void TCSPR1500337() {

		// Click on Student 2 view/Modify button
		click(ari.modifybtn_stud2);

		waitThread(3000);
		// Assert the student 2 Name
		Assert.assertTrue(getText(arv.stud_name_resultwindow).contains(Student2name));

		// Click on the I approve the Total Scores given by peers check box
		click(ari.score_checkbx);

		// Click on Exit button
		click(arv.exit_btn);
		waitThread(2000);

		// Click Yes button
		click(ari.savecont_btn);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Total Score Approved");
		click(QP.toasterclosebtn);

		// Assert the Total Score Approved popup visible
		waitThread(2000);
		Assert.assertEquals(getText(ari.score_popup_lbl), "Total Score Approved");

		// Click on Back to results button
		click(ari.score_back_resltbtn);

		waitThread(4000);
		// Assert the student 2 status is Peer Scores Approved
		Assert.assertEquals(getText(ari.status_stud2), "Peer Scores Approved");

	}

	/*
	 * To Modify the Scores of Student 2
	 */
	@Test(priority = 38)
	public void TCSPR1500338() {

		// Click on Student 2 view/Modify button
		waitThread(2000);
		click(ari.modifybtn_stud2);

		// Assert the I approve the Total Scores given by peers check box is
		// checked
		Assert.assertTrue(getAttribute(ari.score_checkbx_check, "class").contains("checked"));

		// Uncheck the I approve the Total Scores given by peers check box
		// checkbox
		click(ari.score_checkbx_check);
		waitThread(2000);

		// Assert the I approve the Total Scores given by peers checkbox is
		// unchecked
		Assert.assertFalse(getAttribute(ari.score_checkbx_check, "class").contains("checked"));

		// Assert the score box is enabled
		Assert.assertFalse(getAttribute(ari.addscore_txtbx, "class").contains("disabled"));

		// Click on Exit button
		click(arv.exit_btn);
		waitThread(2000);

		// Assert the student 2 status is Peer Review Completed
		Assert.assertEquals(getText(ari.status_stud2), "Peer Review Completed");

	}

	/*
	 * To check the pending evaluation tab functionality on the Teacher page
	 */
	@Test(priority = 39)
	public void TCSPR1500339() throws InterruptedException {

		// Click Back button
		waitThread(3000);
		click(arv.back_btn);

		// Click on Pending Evaluation tab
		waitThread(6000);
		click(arv.pending_ev_tab);
		TimeUnit.SECONDS.sleep(10);

		// Assert the pending evaluation tab is selected
		Assert.assertEquals(getAttribute(arv.pending_ev_tab, "aria-selected"), "true");

		// Search the Assessment Name
		// click(arv.search_bx);
		// type(arv.search_bx, AssessmentName);

		// Assert the Following Data's
		// -Course Name
		// -Assessment Name
		// -Publishing Method -Manual
		// -Pending Evaluation- 0 answer sheets
		waitThread(4000);
		Assert.assertEquals(getText(ari.course_namependtab), CourseName3);
		Assert.assertEquals(getText(ari.assess_namependtab), AssessmentName);
		Assert.assertEquals(getText(ari.selectpublis_grid), "Manual");
		Assert.assertEquals(getText(ari.answersheetgrid), "0 answer sheets");

		// Click on View answers &Evaluate button
		click(ari.btn_view_ans_grid);

		waitThread(2000);
		// Assert the Heading Peer Review Results
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Peer Review Results");

		// Assert the Assessment Name
		Assert.assertEquals(getText(arv.assess_lbl), "Assessment Name: " + AssessmentName);
	}

	/*
	 * To Modify the Scores of Student 3
	 */
	public String scoefrompeerS3;
	public String teachscoreq1s3 = "0";

	@Test(priority = 40)
	public void TCSPR1500340() {

		// adding the peer review score received by stud
		int a = cm.StringtoInt(stud1scores1q1) + cm.StringtoInt(stud1scores1q2) + cm.StringtoInt(stud1scores1q3);
		scoefrompeerS3 = cm.InttoString(a);

		// Assert the Score received from peers
		Assert.assertEquals(getText(ari.scorefrompeer_stud3), scoefrompeerS3);

		// Click on Student 3 view/Modify button
		waitThread(2000);
		click(ari.modifybtn_stud3);

		waitThread(2000);
		// Assert the Student 3 Name
		Assert.assertTrue(getText(arv.stud_name_resultwindow).contains(Student3name));

		waitThread(1000);
		// Type Score for Question 1
		click(ari.addscore_txtbx);
		type(ari.addscore_txtbx, teachscoreq1s3);

		// Click Save Button
		click(ari.save_btn);

		// Assert toaster "Score Saved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(3000);

		// Assert the Score Received from Teacher: 0
		Assert.assertEquals(getText(ari.scorefromteach_lbl), "Score Received from Teacher: " + teachscoreq1s3);

		// Click on Exit button
		click(arv.exit_btn);
		waitThread(2000);

		// Click Back to results button
		click(ari.backto_reslt_btn);

		waitThread(2000);
		// Assert the student 3 status is Scores Modified
		Assert.assertEquals(cm.getdatafromgrid(Student3name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[9]/div/p"), "Scores Modified");
	}

	/*
	 * To Modify the Scores of Student 2 and check the No button functionality
	 * on the total score approve popup
	 */
	@Test(priority = 41)
	public void TCSPR1500341() {

		waitThread(2000);
		// Click on Student 2 view/Modify button
		cm.clickstudentanswersheet(Student2name, "//p-table[@id='questionResultListingTable']//div[1]/table//tr[",
				"]/td[11]/div/button/span");

		// check the I approve the Total Scores given by peers check box
		// checkbox
		click(ari.score_checkbx);
		waitThread(1000);

		// Click on Exit button
		click(arv.exit_btn);
		waitThread(2000);

		waitThread(3000);
		// Click on No button
		Doubleclick(ari.discard_btn);

		waitThread(1000);
		// Assert the student 2 status is peer review completed
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[9]/div/p"),
				"Peer Review Completed");

	}

	/*
	 * To Modify the Scores of Student 2 check the Yes button functionality on
	 * the total score approve popup
	 */
	@Test(priority = 42)
	public void TCSPR1500342() {

		waitThread(2000);
		// Click on Student 2 view/Modify button
		cm.clickstudentanswersheet(Student2name, "//p-table[@id='questionResultListingTable']//div[1]/table//tr[",
				"]/td[11]/div/button/span");

		// check the I approve the Total Scores given by peers check box
		// checkbox
		click(ari.score_checkbx);
		waitThread(1000);

		// Click on Exit button
		click(arv.exit_btn);
		waitThread(2000);

		// Click Yes button
		Doubleclick(ari.savecont_btn);

		// Assert the toaster "Total Score Approved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Total Score Approved");
		click(QP.toasterclosebtn);

		// Assert the Score approved popup visible
		waitThread(2000);
		Assert.assertTrue(isDisplayed(ari.score_popup), "popup not visible");

		waitThread(3000);
		// Assert the Evaluate Next Answer sheet is Disabled
		Assert.assertTrue(getAttribute(ari.eva_ans_button_scorepopup, "class").contains("disabled-btn"));

		// Click on Back to results button
		click(ari.backto_reslt_btn);

		waitThread(2000);
		// Assert the student 2 status is Peer Scores Approved
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[9]/div/p"),
				"Peer Scores Approved");

	}

	/*
	 * To perform publish the result And check the reconsideration window
	 * functionalities
	 */
	@Test(priority = 43)
	public void TCSPR1500343() {

		// Click on Publish button
		click(ari.publish_btn);

		waitThread(2000);
		// Assert the Reconsideration popup visible on the page
		Assert.assertTrue(isElementPresent(ari.recons_popup), "popup not present");

		// Click on Close button
		click(ari.recons_popup_closebtn);

		waitThread(2000);
		// Assert the Reconsideration popup not visible on the page
		Assert.assertFalse(isElementPresent(ari.recons_popup), "popup not present");

		// Click on Publish button
		click(ari.publish_btn);

		waitThread(1000);
		// Assert the Labels:
		// -Set last date for raising Reconsideration Request
		// -Allow students to raise the reconsideration request if they are not
		// satisfied with their score granted by peers
		Assert.assertEquals(getText(ari.recons_popup_hd), "Set last date for raising Reconsideration Request");
		Assert.assertEquals(getText(ari.recons_popup_txt),
				"Allow students to raise the reconsideration request if they are not satisfied with their score granted by peers");

		// Assert the button Yes and No
		Assert.assertEquals(getAttribute(ari.recons_popup_yesbtn, "aria-label"), "Yes");
		waitThread(2000);
		Assert.assertEquals(getAttribute(ari.recons_popup_nobtn, "aria-label"), "No");

		waitThread(1000);
		// Assert the Yes button is Selected
		Assert.assertEquals(getAttribute(ari.recons_popup_yesbtn, "aria-pressed"), "true");
	}

	/*
	 * To verify the labels and buttons of reconsideration window and publish
	 * the result without reconsideration request
	 */
	public String time;

	@Test(priority = 44)
	public void TCSPR1500344() {

		// Assert tthe Labels:
		// -Last date for raising reconsideration request by students:
		// -Day from Result Publishing Date at
		// -Assert the Data Preview based on current date
		// Last date for raising Reconsideration will be: Date and Time
		Assert.assertEquals(getText(ari.recons_bystud_txt),
				"Last date for raising reconsideration request by students:");
		Assert.assertEquals(getText(ari.recons_timetxt), "Day from Result Publishing Date at");
		Assert.assertEquals(getText(ari.recons_dataprev_txt), "Data Preview based on current date");
		Assert.assertTrue(getText(ari.recons_lastdate_txt).contains("Last date for raising Reconsideration will be:"));

		// Assert the Days dropdown
		Assert.assertTrue(getAttribute(ari.daydrop_recons_popup, "class").contains("p-dropdown"));

		// Assert the time textbox
		Assert.assertTrue(isElementPresent(ari.time_txtbx), "time textbox not present");
		time = getValue(ari.time_txtbx);
		waitThread(1000);

		// Assert the publish button
		Assert.assertEquals(getText(ari.publish_btn_reconspopup), "Publish Result");

		// Click on No button
		click(ari.recons_popup_nobtn);

		waitThread(1000);
		// Assert the Label "Allow students to raise the reconsideration request
		// if they
		// are not satisfied with their score granted by peers"
		Assert.assertEquals(getText(ari.recons_popup_txt),
				"Allow students to raise the reconsideration request if they are not satisfied with their score granted by peers");

	}

	/*
	 * To perform publish the result functionality on the teacher login
	 */
	public String totalscorestud1sum;
	public String totalscorestud2sum;
	public String totalscorestud3sum;
	public String S1scorefromteach;

	@Test(priority = 45)
	public void TCSPR1500345() {

		waitThread(2000);
		// Click on Publish button
		click(ari.publish_btn_reconspopup);

		waitThread(2000);
		// Assert the publish popup visible
		Assert.assertTrue(isElementPresent(ari.publish_popup), "popup not present");

		// Assert the Label "Result Published Successfully"
		Assert.assertEquals(getText(ari.pub_popup_txt), "Result Published Successfully");

		waitThread(1000);
		// Click on Back to Results Button
		click(ari.publish_backtores_btn);

		waitThread(3000);
		// Assert the Heading Final result
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Final Result");

		waitThread(2000);
		S1scorefromteach = getText(ari.scorerec_fromteach_stud1);

		// *Assert the Total Score of Each student 1 is Score Received from
		// Peers
		// +Reward Score
		int t1 = cm
				.StringtoInt(cm.getdatafromgrid(Student1name,
						"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[6]//span"))
				+ cm.StringtoInt(cm.getdatafromgrid(Student1name,
						"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[7]//span"));
		totalscorestud1sum = cm.InttoString(t1);
		Assert.assertEquals(
				cm.getdatafromgrid(Student1name,
						"//p-table[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[9]/div/span"),
				totalscorestud1sum);

		// *Assert the Total Score of Each student 2 is Score Received from
		// Peers
		// +Reward Score
		waitThread(2000);
		int t2 = cm
				.StringtoInt(cm.getdatafromgrid(Student2name,
						"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[6]//span"))
				+ cm.StringtoInt(cm.getdatafromgrid(Student2name,
						"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[7]//span"));
		totalscorestud2sum = cm.InttoString(t2);
		Assert.assertEquals(
				cm.getdatafromgrid(Student2name,
						"//p-table[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[9]/div/span"),
				totalscorestud2sum);

		// *Assert the Total Score of Each student 3 is Score Received from
		// Peers/Teachers +Reward Score
		waitThread(2000);
		int t3 = cm
				.StringtoInt(cm.getdatafromgrid(Student3name,
						"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[6]//span"))
				+ cm.StringtoInt(cm.getdatafromgrid(Student3name,
						"//p-table[@id='questionResultListingTable']//div[1]/table//tr[", "]/td[8]/div/span"));
		totalscorestud3sum = cm.InttoString(t3);
		Assert.assertEquals(
				cm.getdatafromgrid(Student3name,
						"//p-table[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[9]/div/span"),
				totalscorestud3sum);

		// Click on Back button
		click(arv.back_btn);

		// Assert the Pending Evaluation tab is selected
		waitThread(6000);
		Assert.assertEquals(getAttribute(arv.pending_ev_tab, "aria-selected"), "true");

	}

	/*
	 * To check the result Publish date and Time
	 */
	public String resultdate;
	public String resulttime;

	@Test(priority = 46)
	public void TCSPR1500346() {

		// Click on Current Tab
		waitThread(3000);
		click(arv.current_tab);

		// Search the Assessment Name
		waitThread(4000);
		click(st1.assess_searchbx);
		type(st1.assess_searchbx, AssessmentName);

		// Assert the result publish Date and Time
		cm.datetimesplitmethod();
		resultdate = cm.getdates(cm.resultdate);
		resulttime = cm.resultime;

		// [Assert the date is todays and time is current time]
		Assert.assertEquals((resultdate), cm.getdate());
		// Assert.assertEquals((resulttime),time);

		// Assert the Last Date for Reconsideration date and time not visible
		Assert.assertFalse(isElementPresent(tr.lastdate_lbl), "Last Date for Reconsideration not visible");

		// Perform Teacher Logout
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * Login As student 1 and check the Details of Result window
	 */
	@Test(priority = 47)
	public void TCSPR1500347() {

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

		// Assert the Result Published Date: and time
		cm.studentresultdatetimemethod();
		String resultdatestud = cm.getdates(cm.resultdate_stud);
		String resulttimestud = cm.resultime_stud;

		Assert.assertEquals(resultdatestud, resultdate);
		Assert.assertEquals(resulttimestud, resulttime);

		// Assert the view result button visible
		Assert.assertTrue(isElementPresent(rwbt.viewresultbtn), "View result button not visible");

		// click on view result button
		click(rwbt.viewresultbtn);
		waitThread(3000);

		// Assert Result popup visible
		Assert.assertTrue(isElementPresent(rwbt.resultpopup), "Result Popup  not visible");

		// Assert the heading Result
		Assert.assertEquals(getText(rwbt.label_Result_1), "Result");

		// Assert the Labels and Scores:
		// Score Received from Peer Reviewers
		Assert.assertTrue(getText(rwbt.lbl_scorefrmReviewers).contains("Score Received from Peer Reviewers"));
		Assert.assertEquals(getText(rwbt.score_frmReviewers), "25/" + TotalTestPoints);

		// Total Score
		// (Score Received from Peer Reviewers + Score for Peer Review Done)
		Assert.assertTrue(getText(rwbt.lbl_TotalScore).contains("Total Score"));
		Assert.assertTrue(getText(rwbt.lbl_TotalScore)
				.contains("(Score Received from Peer Reviewers + Score for Peer Review Done)"));
		Assert.assertEquals(getText(rwbt.TotalScore), totalscorestud1sum + "/" + maxscoreposs1);

	}

	/*
	 * To verify the Score details of each questions [Student 1]
	 */
	@Test(priority = 48)
	public void TCSPR1500348() {

		waitThread(2000);
		// Assert the Status of Q1 is Peer Review Completed
		Assert.assertEquals(getText(mrp.Q1_Status), "Peer Review Completed");

		// Assert the Status of Q2 is Peer Review Completed
		Assert.assertEquals(getText(mrp.Q2_Status), "Peer Review Completed");

		// Assert the Status of Q3 is Peer Review Completed
		Assert.assertEquals(getText(mrp.Q3_Status), "Peer Review Completed");

		click(rwbt.resultpopupclosebtn);
		waitThread(3000);
		// Perform Student 1 Logout
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * Login As student 2 and check the Details of Result window
	 */
	@Test(priority = 49)
	public void TCSPR1500349() throws InterruptedException {

		// login as Student 2
		waitThread(2000);
		lg.login1(Emailstudent2, cm.Password);

		TimeUnit.SECONDS.sleep(10);
		// Search the Assessment Name
		waitThread(5000);
		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);

		TimeUnit.SECONDS.sleep(5);
		// Assert Label "Result Available"
		Assert.assertEquals(getText(ari.stud_cardhead_lbl), "Result Available");

		// Assert the Result Published Date: and time
		cm.studentresultdatetimemethod();
		String resultdatestud = cm.getdates(cm.resultdate_stud);
		String resulttimestud = cm.resultime_stud;

		Assert.assertEquals(resultdatestud, resultdate);
		Assert.assertEquals(resulttimestud, resulttime);

		// Assert the view result button visible
		Assert.assertTrue(isElementPresent(rwbt.viewresultbtn), "View result button not visible");

		// click on view result button
		click(rwbt.viewresultbtn);
		waitThread(3000);

		// Assert Result popup visible
		Assert.assertTrue(isElementPresent(rwbt.resultpopup), "Result Popup  not visible");

		// Assert the heading Result
		Assert.assertEquals(getText(rwbt.label_Result_1), "Result");

		// Assert the Labels and Scores:
		// Score Received from Peer Reviewers
		Assert.assertTrue(getText(rwbt.lbl_scorefrmReviewers).contains("Score Received from Peer Reviewers"));
		Assert.assertEquals(getText(rwbt.score_frmReviewers), "25/" + TotalTestPoints);

		// Total Score
		// (Score Received from Peer Reviewers + Score for Peer Review Done)
		Assert.assertTrue(getText(rwbt.lbl_TotalScore).contains("Total Score"));
		Assert.assertTrue(getText(rwbt.lbl_TotalScore)
				.contains("(Score Received from Peer Reviewers + Score for Peer Review Done)"));
		Assert.assertEquals(getText(rwbt.TotalScore), totalscorestud2sum + "/" + maxscoreposs1);
	}

	/*
	 * To verify the Score details of each questions [Student 2]
	 */
	@Test(priority = 50)
	public void TCSPR1500350() {

		// Assert the Scores Received from Teacher Not present
		Assert.assertFalse(getText(rwbt.lbl_Scorefrm_teach).contains("Scores Received from Teacher"));

		// Assert the Status of Q1 is Teacher Approved
		Assert.assertEquals(getText(mrp.Q1_Status), "Teacher Approved");

		// Assert the Status of Q2 is Teacher Approved
		Assert.assertEquals(getText(mrp.Q2_Status), "Teacher Approved");

		// Assert the Status of Q3 is Teacher Approved
		Assert.assertEquals(getText(mrp.Q3_Status), "Teacher Approved");

	}

	/*
	 * To verify the Score details of each questions [Student 2]
	 */
	@Test(priority = 51)
	public void TCSPR1500351() {

		// Click on Q1 view button
		click(mrp.view_btn_q1);

		// Assert the total Score same as teacher result window
		waitThread(2000);
		Assert.assertEquals(getText(sasb.totalscr_lbl), "Total Score " + totalscorestud2sum + "/" + maxscoreposs1);

		// Assert the Label Teacher Approved
		Assert.assertEquals(getText(arv.reviewstatus), "Teacher Approved");

		// Perform Student 2 Logout
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * Login As student 3 and check the Details of Result window
	 */
	@Test(priority = 52)
	public void TCSPR1500352() {

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

		// Assert the Result Published Date: and time
		cm.studentresultdatetimemethod();
		String resultdatestud = cm.getdates(cm.resultdate_stud);
		String resulttimestud = cm.resultime_stud;

		Assert.assertEquals(resultdatestud, resultdate);
		Assert.assertEquals(resulttimestud, resulttime);

		// Assert the view result button visible
		Assert.assertTrue(isElementPresent(rwbt.viewresultbtn), "View result button not visible");

		// click on view result button
		click(rwbt.viewresultbtn);
		waitThread(3000);

		// Assert Result popup visible
		Assert.assertTrue(isElementPresent(rwbt.resultpopup), "Result Popup  not visible");

		// Assert the heading Result
		Assert.assertEquals(getText(rwbt.label_Result_1), "Result");

		// Assert the Labels and Scores:
		// Score Received from Peer Reviewers/Teacher
		Assert.assertTrue(getText(rwbt.lbl_scorefrmReviewers).contains("Score Received from Peer Reviewers/Teacher"));
		Assert.assertEquals(getText(rwbt.score_frmReviewers), cm.StringtoInt(S1scorefromteach) + "/" + TotalTestPoints);

		waitThread(3000);
		// Total Score
		// (Score Received from Peer Reviewers/Teacher + Score for Peer Review
		// Done)
		Assert.assertTrue(getText(rwbt.lbl_TotalScore).contains("Total Score"));
		Assert.assertTrue(getText(rwbt.lbl_TotalScore)
				.contains("(Score Received from Peer Reviewers/Teacher + Score for Peer Review Done)"));
		Assert.assertEquals(getText(rwbt.TotalScore), totalscorestud3sum + "/" + maxscoreposs1);

	}

	/*
	 * To verify the Score details of each questions [Student 3]
	 */
	@Test(priority = 53)
	public void TCSPR1500353() {

		// Assert the Scores Received from Teacher of Q1 is 0
		Assert.assertEquals(getText(ari.Q1_scorefrm_teach), "0");

		// Assert that the Q1 Final Score is Final Score is Sum of Score
		// received from
		// Teacher + Score for review done
		int f1 = cm.StringtoInt(getText(ari.Q1_scoreforrev)) + cm.StringtoInt(getText(ari.Q1_scorefrm_teach));
		Assert.assertEquals(getText(ari.Q1_FinalScore), cm.InttoString(f1));

		// Assert that the Q2 Final Score is Final Score is Sum of Score
		// received from
		// Peers + Score for review done
		int f2 = cm.StringtoInt(getText(ari.Q2_scoreforrev)) + cm.StringtoInt(getText(ari.Q2_scorerec_frmpeer));
		Assert.assertEquals(getText(ari.Q2_FinalScore), cm.InttoString(f2));
	}

	/*
	 * To verify the Score details of each questions [Student 3]
	 */

	@Test(priority = 54)
	public void TCSPR1500354() {

		// Assert the Status of Q1 is Teacher Modified
		Assert.assertEquals(getText(ari.Q1_Status), "Teacher Modified");

		// Assert the Status of Q2 is Peer Review Completed
		Assert.assertEquals(getText(ari.Q2_Status), "Peer Review Completed");

		// Assert the Status of Q3 is Peer Review Completed
		Assert.assertEquals(getText(ari.Q3_Status), "Peer Review Completed");

		waitThread(1000);
		String S3Q1scoreforrev = getText(ari.Q1_scoreforrev);

		// Click on Q1 view button
		click(ari.view_btn_q1);

		waitThread(2000);
		// Assert the Score Received from Teacher: value same as teacher page
		Assert.assertEquals(getText(sasb.scorefromteach), "Score Received from Teacher: " + teachscoreq1s3);

		// Assert the Label Teacher Modified
		Assert.assertEquals(getText(arv.reviewstatus), "Teacher Modified");

		// Assert the Final Score of Q1[Sum of score received from
		// teacher+reward score]
		int f1 = cm.StringtoInt(teachscoreq1s3) + cm.StringtoInt(S3Q1scoreforrev);

		Assert.assertEquals(getText(sasb.final_scrorelbl), "Final Score: " + cm.InttoString(f1));

		// Assert the Total Score of the Answer sheet
		Assert.assertEquals(getText(sasb.totalscr_lbl), "Total Score " + totalscorestud3sum + "/" + maxscoreposs1);

	}

	/*
	 * To perform Delete student3 Account functionality
	 */
	@Test(priority = 55)
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
	@Test(priority = 56)
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
	@Test(priority = 57)
	public void DeleteStudent1() {
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
	@Test(priority = 58)
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
