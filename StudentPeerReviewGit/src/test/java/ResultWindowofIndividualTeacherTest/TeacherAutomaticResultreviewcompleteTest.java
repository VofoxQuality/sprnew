package ResultWindowofIndividualTeacherTest;

import java.sql.SQLException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.jsoup.select.Evaluator.ContainsText;
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
import CurrentAssessmentsforStudents.Pages.StudentTestSectionPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowWizardPage;
import ResultWindowforIndividualStudent.Page.StudentResultWindowBasicsPage;
import ResultWindowofIndividualTeacherPage.TeacherAutomaticResultreviewcompletePage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import TestWindowOfIndividualStudent.AssessmentSubmitAndStatusPopUpPage;
import TestWindowOfIndividualStudent.ModifyWizardSectionPage;
import TestWindowOfIndividualStudent.TestWindowWizardPage;

public class TeacherAutomaticResultreviewcompleteTest extends basePage {

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
	TeacherAutomaticResultreviewcompletePage arv = new TeacherAutomaticResultreviewcompletePage();
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
	public void TCSPR1500102() {

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
	public void TCSPR1500103() {

		// Type Question 1
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		type(QP.Quest_box, Question1);
		driver.switchTo().defaultContent();

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
	public void TCSPR1500104() {

		// Type Question 2
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		type(QP.Quest_box, Question2);
		driver.switchTo().defaultContent();

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
	public void TCSPR1500105() {

		waitThread(2000);
		// Type Question 3
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		type(QP.Quest_box, Question3);
		driver.switchTo().defaultContent();

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
	public String peerstudname1;
	public String peerstudname2;

	@Test(priority = 6)
	public void TCSPR1500106() {

		waitThread(4000);
		// Enter peer review Reward score
		type(prw.peer_reward_scorebx, RewardPercent);

		// Select Answer Sheet per student is 2
		click(prw.reviewans_sheetdropdwn);
		waitThread(1000);
		click(prw.reviewssheet_count);

		waitThread(4000);
		// Assert the Answer sheets to be assigned to the Peer Reviewer having 2
		// colums
		Assert.assertEquals(getText(prw.reviewans_sheetdropdwn), "2");

		// Assert the text::Total Students : Assert the total student count is 3
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 3");

		// Assert the 3 student names
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Student1name.trim());
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Student2name.trim());
		Assert.assertEquals(getText(ps.studantname3_gridval).trim(), Student3name.trim());

		waitThread(3000);
		peerstudname1 = getText(arv.peerstud1);
		peerstudname2 = getText(arv.peerstud2);
	}

	/*
	 * To perform the save and next functionaity from peer review page and
	 * verify the schedule page details
	 */
	@Test(priority = 7)
	public void TCSPR1500107() {

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
	public void TCSPR1500108() {

		quest_count = "3";
		// Assert the Total Questions: 3
		Assert.assertEquals(getText(sb.valuetotalQuestion), quest_count);

		// To get The Total Test Points
		TotalTestPoints1 = Integer.parseInt(Maxscore1) + Integer.parseInt(Maxscore2) + Integer.parseInt(Maxscore3);

		TotalTestPoints = Integer.toString(TotalTestPoints1);

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
	public void TCSPR1500109() {

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
	public void TCSPR1500110() throws InterruptedException {
		// Login to Student1
		lg.login1(Emailstudent1, cm.Password);

		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(50);
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
	public void TCSPR1500111() {

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

	}

	/*
	 * To perform assessment submit functionality on the student profile
	 */
	public String quest_anscount1;

	@Test(priority = 12)
	public void TCSPR1500112() {

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

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		quest_anscount1 = getText(tsw.ans_count);

		// Assert the Test attended count
		Assert.assertEquals(getText(tsw.ans_count), quest_anscount1);

		waitThread(3000);
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
	public void TCSPR1500113() {

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
	public void TCSPR1500114() {

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

	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 15)
	public void TCSPR1500115() {

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

	public String quest_anscount;

	/*
	 * To perform assessment submit functionality on the student profile
	 */
	@Test(priority = 16)
	public void TCSPR1500116() {

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
	public void TCSPR1500117() {

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
	public void TCSPR1500118() {

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

		// click on Answer 2 wizard
		click(asp.wizardans2);

		//// Second Question is selected
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("p-highlight"));

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
	public void TCSPR1500119() {

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

		// Third Question is selected
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("p-highlight"));

		// Type Answer3
		driver.switchTo().frame("answer_ifr");
		type(tsw.answer_bx, "Answer 3_" + generateRandomData());
		driver.switchTo().defaultContent();

	}

	/*
	 * To perform assessment submit functionality on the student profile
	 */
	@Test(priority = 20)
	public void TCSPR1500120() {

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

		waitThread(4000);

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
	public void TCSPR1500121() throws InterruptedException {

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
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(80);

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
	public void TCSPR1500122() {
		// Enter Score for Student1
		click(prp.scorestud1);

		waitThread(1000);
		type(prp.scorestud1, "5");

		// Enter Score for Student2
		click(prp.scorestud2);
		waitThread(1000);
		type(prp.scorestud2, "10");

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

		// Enter Score for Student2
		click(prp.scorestud2);
		waitThread(1000);
		type(prp.scorestud2, "15");

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
	 * To perfrom review for Question 3 and submit the Review
	 */
	@Test(priority = 23)
	public void TCSPR1500123() {
		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "10");

		// Enter Score for Student2
		click(prp.scorestud2);
		waitThread(1000);
		type(prp.scorestud2, "15");

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
	public void TCSPR1500124() {

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

	public String S2Q1ScorefroStud2 = "5";
	public String S2Q2ScorefroStud2 = "10";

	/*
	 * To perfrom review for Question 1 and Question 2
	 */
	@Test(priority = 25)
	public void TCSPR1500125() {

		Scroll_DowntoEnd();
		waitThread(2000);
		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "1");

		// Enter Score for Student2
		click(prp.scorestud2);
		waitThread(1000);
		type(prp.scorestud2, S2Q1ScorefroStud2);

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
		type(prp.scorestud1, "2");

		// Enter Score for Student2
		click(prp.scorestud2);
		waitThread(1000);
		type(prp.scorestud2, S2Q2ScorefroStud2);
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
	 * To perfrom review for Question 3 and submit the Review
	 */
	@Test(priority = 26)
	public void TCSPR1500126() {

		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "3");

		// Assert the Student 2 answer field is disabled
		Assert.assertTrue(getAttribute(prw.studenttwo_part, "class").contains("p-disabled"));
		waitThread(2000);

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
	 * To perform Login functionality of student 3 profile and check the
	 * Assessment card
	 */
	@Test(priority = 27)
	public void TCSPR1500127() {

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
	 * To perfrom review for Question 1 and submit the Review
	 */

	public String S3Q1ScorefroStud2 = "10";
	public String S3_rewardper;

	@Test(priority = 28)
	public void TCSPR1500128() {

		waitThread(2000);
		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "1");

		// Enter Score for Student2
		click(prp.scorestud2);
		waitThread(1000);
		type(prp.scorestud2, S3Q1ScorefroStud2);

		waitThread(1000);
		// click submit button
		click(ms.submit_btn);
		waitThread(2000);

		// verify the confirmation popup visible
		Assert.assertTrue(isDisplayed(prp.confir_popup), "popup not visible");
		waitThread(2000);
		click(prp.submit_confi);

		waitThread(2000);
		// Click on Back to Assessment
		click(prp.reviewbactoassessmentbtn);
		waitThread(5000);
		// Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		waitThread(2000);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		type(st1.stud_searchbx, AssessmentName);
		waitThread(3000);

		// Assert the Peer review percentage and Read the percentage value
		S3_rewardper = getText(sp1.zeropercent_card);
		Assert.assertEquals(getText(sp1.zeropercent_card), S3_rewardper);

		waitThread(6000);
		// To perform logout functionality on the Student 3 profile
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * Perform teacher login and reschedule the peer review and result date
	 */
	@Test(priority = 29)
	public void TCSPR1500129() throws InterruptedException {

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

		waitThread(8000);

		click(st1.assess_searchbx);
		// search assessment
		type(st1.assess_searchbx, AssessmentName);
		driver.findElement(By.xpath(st1.assess_searchbx)).sendKeys("        ");

		TimeUnit.SECONDS.sleep(30);
		;
		waitThread(3000);

	}

	/*
	 * To verify the result section Labels
	 */
	@Test(priority = 30)
	public void TCSPR1500130() throws InterruptedException {

		// Assert the button Label :view result
		Assert.assertEquals(getText(arv.viewresult_teachcard), "View Result");

		// Assert the View result Button is disabled
		Assert.assertFalse(isEnabled(arv.viewresultbtn), "View result button is enabled");

		// wait till button is Enabled
		TimeUnit.MINUTES.sleep(2);
		driver.navigate().refresh();

		TimeUnit.SECONDS.sleep(20);
		click(st1.assess_searchbx);
		// search assessment
		type(st1.assess_searchbx, AssessmentName);

		// Assert the View result Button is Enabled
		Assert.assertTrue(isEnabled(arv.viewresult_teachcard), "View result button is disabled");

		waitThread(4000);
		// Assert Label Result Available
		Assert.assertEquals(getText(tts.time_status), "Result Available");

		waitThread(3000);
		// Click View Result Button
		click(arv.viewresult_teachcard);

		// Assert Heading Final Result
		Assert.assertEquals(getText(arv.finalresult_lbl), "Final Result");
	}

	/*
	 * To check the back button functionality in the teacher result window
	 */
	@Test(priority = 31)
	public void TCSPR1500131() {

		waitThread(3000);
		// Assert the Back Button
		Assert.assertEquals(getText(arv.back_btn), "Back");

		// Click the Back Button
		click(arv.back_btn);

		// Assert the Current Tab is selected
		Assert.assertTrue(isDisplayed(arv.current_tab), "Current tab not present");

		// Search the Assessment Name
		click(st1.assess_searchbx);
		// search assessment
		type(st1.assess_searchbx, AssessmentName);

		waitThread(2000);
		// Click the View Result Button
		click(arv.viewresult_teachcard);

		// Assert the Labels
		// Course Name: Course name and course ID
		// Assessment Name: Assessment Name
		Assert.assertEquals(getText(arv.courselbl), "Course Name: " + CourseName3.trim() + " " + "(" + CourseID3 + ")");
		Assert.assertEquals(getText(arv.assess_lbl), "Assessment Name: " + AssessmentName);

	}

	public String cls_size;

	/*
	 * To verify the labels and score in the result window
	 */
	@Test(priority = 32)
	public void TCSPR1500132() {

		// Assert the Label and Value-Students tested/Class size
		Assert.assertTrue(getText(arv.studenttest_clsize_lbl).contains("Students tested/Class size"));

		cls_size = getText(arv.studenttest_clsize);
		Assert.assertEquals(getText(arv.studenttest_clsize_lbl), "Students tested/Class size\n" + cls_size);

		// Assert the Label and Value-Total Questions
		Assert.assertEquals(getText(arv.tot_quest_count_lbl), "Total Questions\n" + quest_count);

		// Assert the Label and Value-Total Peer Review Points
		Assert.assertEquals(getText(arv.tot_peerpoints_lbl), "Total Peer Review Points\n" + TotalRewardScore);

	}

	/*
	 * To verify the labels and score in the result window
	 */

	@Test(priority = 33)
	public void TCSPR1500133() {

		// Assert the Label and Value-Total Test Points
		Assert.assertEquals(getText(arv.tot_testpoints_lbl), "Total Test Points\n" + TotalTestPoints);

		// Assert the Label and Value-Maximum Score Possible
		// (Total Test Points + Total Peer Review Points)
		Assert.assertTrue(getText(arv.maxscoreposs_lbl).contains("Maximum Score Possible"));
		Assert.assertEquals(getText(arv.sum_totalpoints_lbl), "(Total Test Points + Total Peer Review Points)");

		waitThread(3000);
		// Assert the color green for Completed
		Assert.assertTrue(getAttribute(arv.completed_lbl, "Class").contains("green-dot"));

		// Assert the color orange for Incomplete
		Assert.assertTrue(getAttribute(arv.incomplete_lbl, "Class").contains("orange-dot"));

	}

	/*
	 * To verify the grid Label on the Teacher result window
	 */
	@Test(priority = 34)
	public void TCSPR1500134() {

		// Assert the Following Grid Labels
		Assert.assertEquals(getText(arv.lblSIno), "Sl No");
		Assert.assertEquals(getText(arv.lblStudentName), "Student Name");
		Assert.assertEquals(getText(rwbt.lblMaxscore), "Questions\n" + "Answered");
		Assert.assertEquals(getText(arv.lblAnswerSheetReviewed), "Answer Sheets Reviewed by");
		Assert.assertEquals(getText(arv.lblRewardpoint), "Reward\n" + "Point");
		Assert.assertEquals(getText(arv.lblsScoreReceivedfrom), "Score Received from\n" + "Peers");
		Assert.assertEquals(getText(arv.lblTotalScore), "Total Score");
		Assert.assertEquals(getText(arv.lblAnswersheet), "Answer\n" + "Sheet");

		// Assert the students names on the grid
		Assert.assertEquals(getText(arv.stud1ingrid).trim(), Student3name.trim());
		Assert.assertEquals(getText(arv.stud2ingrid).trim(), Student1name.trim());
		Assert.assertEquals(getText(arv.stud3ingrid).trim(), Student2name.trim());

	}

	/*
	 * To verify the score details of student 1 should be correct
	 */
	public String TotalpeerreviewScore;
	public String totalscore;
	public String Scorefrompeers_of_Student1;

	@Test(priority = 35)
	public void TCSPR1500135() {

		// Assert the Answer attended count
		Assert.assertEquals(getText(arv.stud1anscount), quest_anscount1);

		// Assert the Student 2 and Student 3 Names
		Assert.assertEquals(getText(arv.stud2nameinstud1row), Student2name.trim());
		Assert.assertEquals(getText(arv.stud3nameinstud1row), Student3name.trim());

		// Assert the student 3 name is in Orange color
		String color = driver
				.findElement(By
						.xpath("//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[5]//div[2]/p-badge/span"))
				.getCssValue("color");
		System.out.println(color);
		String hex = Color.fromString(color).asHex();
		System.out.println(hex);

		Assert.assertEquals((hex), "#ff8128");

		// Assert the student 3 status is peer review incomplete
		Assert.assertTrue(getAttribute(arv.stud3nameingrid, "class").contains("peer-incomplete"));

		// calculating the score received from peers
		float Scorefrompeerss_of_Student1 = (Float.parseFloat(S2Q1ScorefroStud2) + Float.parseFloat(S2Q2ScorefroStud2))
				/ (float) 2;
		System.out.println(Scorefrompeerss_of_Student1);
		Scorefrompeers_of_Student1 = Float.toString(Scorefrompeerss_of_Student1);
		float peerscore = Scorefrompeerss_of_Student1 + Float.parseFloat(S3Q1ScorefroStud2);
		System.out.println(peerscore);

		TotalpeerreviewScore = Float.toString(peerscore);

		// Assert the Value of Score Received from Peers is correct
		Assert.assertEquals(getText(arv.scorefrompeer_stud1), TotalpeerreviewScore);

		// Calculating the Total score (sum of Reward point and score received
		// from
		// peers)

		waitThread(2000);
		float totalscore1 = (Float.parseFloat(TotalpeerreviewScore)) + (TotalTestPoints1);
		System.out.println(totalscore1);

		totalscore = String.valueOf(totalscore1);

		// Assert the Value of Total Score
		Assert.assertEquals(getText(arv.tot_score_stud1), totalscore);
	}

	/*
	 * To check the Reward score popup Functionality
	 */
	@Test(priority = 36)
	public void TCSPR1500136() {

		// Assert the reward score value
		Assert.assertEquals(getText(arv.rewardscore_stud1), TotalRewardScore1);

		waitThread(3000);
		// Click Student 1 reward score
		click(arv.rewardscore_stud1);

		// Assert the popup visible
		Assert.assertTrue(isElementPresent(arv.popup), "Popup not visible");

		// Assert Label Peer Review Status
		Assert.assertEquals(getText(arv.popup_lbl), "Peer Review Status");

		// Assert the Close button
		Assert.assertTrue(isElementPresent(arv.popup_closebtn), "close button not present");

		waitThread(2000);
		// Click on Close button
		click(arv.popup_closebtn);

		waitThread(2000);
		// Assert the popup closed
		Assert.assertFalse(isElementPresent(arv.popup), "Popup visible");

		waitThread(3000);
		// Click Student 1 reward score
		click(arv.rewardscore_stud1);

		// Assert the popup visible
		Assert.assertTrue(isElementPresent(arv.popup), "Popup not visible");
	}

	/*
	 * To verify the labels on the peer review status popup
	 */
	@Test(priority = 37)
	public void TCSPR1500137() {

		// Assert the Label Student Name and value
		Assert.assertEquals(getText(arv.studname_lbl), "Student Name");
		Assert.assertEquals(getText(arv.popup_studname), Student1name.trim());

		// Assert the Label Answer Sheet Assigned for Peer Review
		Assert.assertEquals(getText(arv.AnswerSheetAssigned_lbl), "Answer Sheet Assigned for Peer Review");

		waitThread(6000);
		// Assert the Students Names same as peer review page
		Assert.assertEquals(getText(arv.peerreviewstudname), peerstudname1);
		Assert.assertEquals(getText(arv.peerreviewstudname1), peerstudname2);

		// Assert the label Peer Review Completion
		Assert.assertEquals(getText(arv.PeerReviewCompletion), "Peer Review Completion");

		// Assert the Label Reward Score and Eligible
		Assert.assertEquals(getText(arv.RewardScore_lbl), "Reward Score");
		waitThread(2000);

		// Click on Close button
		click(arv.popup_closebtn);

		waitThread(2000);
		// Assert the popup closed
		Assert.assertFalse(isElementPresent(arv.popup), "Popup visible");

	}

	/*
	 * To check the Reward score popup Functionality
	 */
	@Test(priority = 38)
	public void TCSPR1500138() {

		// Assert the view button
		Assert.assertTrue(isElementPresent(arv.view_btn), "View button not present");

		// Click on View button
		click(arv.view_btn);
		waitThread(2000);

		// Assert the wizard panel
		Assert.assertTrue(getText(arv.wizardq1).contains("1"));

		// Assert the Assessment Name,Course name,Course ID,Student Name
		Assert.assertEquals(getText(arv.result_page_assess_name), AssessmentName);
		Assert.assertTrue(getText(arv.course_name_id).contains(CourseName3.trim()));
		Assert.assertTrue(getText(arv.course_name_id).contains(CourseID3));
		Assert.assertTrue(getText(arv.stud_name_resultwindow).contains(Student1name));

		// Assert the Button and button label Exit
		Assert.assertTrue(isElementPresent(arv.exit_btn), "Exit button not present");
		Assert.assertEquals(getText(arv.exit_btn), "Exit");

		// Assert the Previous button is disabled
		Assert.assertTrue(getAttribute(arv.Wizard_prevbtn, "class").contains("p-disabled"));

		// Assert the Question 1 is selected
		Assert.assertTrue(getAttribute(arv.wizardq1, "class").contains("p-highlight"));

	}

	/*
	 * To verify the Question,Rubric Sample answer and The Answer of student
	 */
	@Test(priority = 39)
	public void TCSPR1500139() {

		// Assert the Question content
		driver.switchTo().frame("questionId_ifr");
		Assert.assertEquals(getText(arv.quest), Question1);
		driver.switchTo().defaultContent();

		// Assert the accordian label Answer
		Assert.assertEquals(getText(arv.answer_accordian), "Answer");

		// Click on Answer accordian
		click(arv.answer_accordian);

		waitThread(3000);
		// Assert the Answer of Student 1
		driver.switchTo().frame("answerId_ifr");
		Assert.assertEquals(getText(arv.answer), stud1ans1);
		driver.switchTo().defaultContent();

		// Assert the accordian label Rubric
		Assert.assertEquals(getText(arv.rubric_aacordian), "Rubric");

		waitThread(2000);
		// Click on Rubric accordian
		click(arv.rubric_aacordian);

		// Assert the Rubric of Question 1
		driver.switchTo().frame("standardRubricId_ifr");
		Assert.assertEquals(getText(arv.rubric), Rubric1);
		driver.switchTo().defaultContent();

		// Assert the accordian label Sample Answer
		Assert.assertEquals(getText(arv.sample_aacordian), "Sample Answer");

		// Click on Sample Answer accordian
		click(arv.sample_aacordian);

		// Assert the Sample Answer of Question 1
		driver.switchTo().frame("sampleAnswerId_ifr");
		Assert.assertEquals(getText(arv.sample), "Sample answer");
		driver.switchTo().defaultContent();

	}

	/*
	 * To verify the details of Mark assigned from Peer Students section
	 */
	@Test(priority = 40)
	public void TCSPR1500140() {

		// Assert Label Mark assigned from Peer Students:
		ScrollTo_xy_position(0, 300);
		Assert.assertEquals(getText(arv.mark_assign_lbl), "Mark assigned from Peer Students:");

		// Assert the student Names
		Assert.assertEquals(getText(arv.studname1), Student2name);
		Assert.assertEquals(getText(arv.studname2), Student3name);

		// Assert the Score given by each student
		Assert.assertEquals(getValue(arv.score_stud1), S2Q1ScorefroStud2);
		Assert.assertEquals(getValue(arv.score_stud2), S2Q2ScorefroStud2);

		waitThread(3000);
		// Assert the Score Received From Peers: Label and Value
		Assert.assertEquals(getText(arv.score_frompeerlbl), "Score Received From Peers: " + Scorefrompeers_of_Student1);

	}

	/*
	 * To verify the Labels and Scores of Question 1[Student 1]
	 */
	@Test(priority = 41)
	public void TCSPR1500141() {

		// Assert the Label Question No: 1
		Assert.assertEquals(getText(arv.quest_lbl), "Question No: 1");

		// Assert the Label Peer Review Completed
		Assert.assertEquals(getText(arv.reviewstatus), "Peer Review Completed");

		// Assert the Label and Value Max Score:
		Assert.assertTrue(getText(arv.maxscore_lbl).contains("Max Score"));
		Assert.assertEquals(getText(arv.maxscore_lbl), "Max Score: " + Maxscore1);

		waitThread(5000);
		// Assert the Label and Value Score Received from Peers:
		waitThread(2000);
		Assert.assertEquals(getText(arv.scorefrompeer_lbl), "Score Received from Peers: " + Scorefrompeers_of_Student1);

		// Assert the Label and Value Final Score:
		Assert.assertTrue(getText(arv.final_scrorelbl).contains("Final Score"));
		Assert.assertEquals(getText(arv.final_scrorelbl), "Final Score: " + TotalpeerreviewScore);

		waitThread(3000);
		// Assert the Label and Value Total Score
		Assert.assertTrue(getText(arv.totalscr_lbl).contains("Total Score"));
		Assert.assertEquals(getText(arv.totalscore), totalscore + "/" + maxscoreposs1);

	}

	/*
	 * To verify the Next button functionality and check the Unanswerd question
	 * answer sheet
	 */
	@Test(priority = 42)
	public void TCSPR1500142() {

		waitThread(3000);
		// Click on Next button
		Doubleclick(arv.wizard_nextbtn);

		waitThread(3000);
		// Assert the second Question wizard is selected
		Assert.assertTrue(getAttribute(arv.wizardq2, "class").contains("p-highlight"));

		waitThread(4000);
		// Assert the Label Question No: 2
		Assert.assertEquals(getText(arv.quest_lbl), "Question No: 2");

		// Assert Label Partially Peer Reviewed
		Assert.assertEquals(getText(arv.reviewstatus), "Partially Peer Reviewed");

		ScrollTo_xy_position(0, 300);
		waitThread(4000);
		// Assert that in Mark assigned from Peer Students: Section Student 3
		// name and
		// score is disabled
		Assert.assertTrue(getAttribute(arv.stud2part, "class").contains("p-disabled"));
		Assert.assertEquals(getText(arv.studname2), Student3name);

		waitThread(4000);
		// Click on 3rd Wizard
		Doubleclick(arv.wizardq3);

		waitThread(2000);
		// Assert the 3rd Question wizard is selected
		Assert.assertTrue(getAttribute(arv.wizardq3, "class").contains("p-highlight"));

		waitThread(3000);
		// Assert the Next button is disabled
		Assert.assertTrue(getAttribute(arv.wizard_nextbtn, "class").contains("p-disabled"));
	}

	/*
	 * To verify that exit button functionality
	 */
	@Test(priority = 43)
	public void TCSPR1500143() {

		waitThread(4000);
		// Assert Label Unanswered Question
		Assert.assertEquals(getText(arv.reviewstatus), "Unanswered Question");

		// Assert the Answer is disabled
		Assert.assertTrue(getAttribute(arv.answrpart, "class").contains("p-disabled"));

		// Assert the Mark assigned from Peer Students: names is disabled
		ScrollTo_xy_position(0, 300);
		// Assert student One part disabled
		Assert.assertTrue(getAttribute(arv.stud1part, "class").contains("p-disabled"));

		// Assert student2 part is disabled
		Assert.assertTrue(getAttribute(arv.stud2part, "class").contains("p-disabled"));

		waitThread(2000);
		// Click on Exit button
		click(arv.exit_btn);

		waitThread(3000);
		// Assert the Label Final Result
		Assert.assertEquals(getText(arv.finalresult_lbl), "Final Result");

	}

	/*
	 * To verify the Reward point of Student 3
	 */
	@Test(priority = 44)
	public void TCSPR1500144() {

		waitThread(2000);
		// Click on Student 3 Reward score
		click(arv.rewardscore_stud3);

		waitThread(2000);
		// Assert the popup visible
		Assert.assertTrue(isElementPresent(arv.popup), "Popup not visible");

		// Assert the Reward Percent is same as student card
		Assert.assertEquals(getText(arv.popup_reviewpercent), S3_rewardper);

		// Assert the Reward Score status is Eligible
		Assert.assertEquals(getText(arv.eligible_txt), "Eligible");

		// Click popup close button
		click(arv.popup_closebtn);
	}

	/*
	 * To check that the assessment listed on the Fullfilled Assessment Tab
	 */
	@Test(priority = 45)
	public void TCSPR1500145() throws InterruptedException {

		waitThread(3000);
		// Click On Back button
		click(arv.back_btn);

		waitThread(6000);
		// Assert the Current Tab selected
		Assert.assertEquals(getAttribute(arv.cuurent_assm_tab, "aria-selected"), "true");

		TimeUnit.SECONDS.sleep(10);
		// Click on Fulfilled Assessments tab
		Doubleclick(arv.fullfil_tab);

		waitThread(5000);
		// Assert the Tab highlighted
		Assert.assertEquals(getAttribute(arv.fullfil_tab, "aria-selected"), "true");

		// Search the Assessment Name
		// click(arv.search_bx);
		// type(arv.search_bx, AssessmentName);

		waitThread(3000);
		// Assert the Assessment Name on the Grid
		Assert.assertEquals(getText(arv.assess_namegrid), AssessmentName);

		// Assert the course name and teacher name on the grid
		Assert.assertEquals(getText(arv.cours_namegrid), CourseName3.trim());

		// Assert the publishing method is Automatic
		Assert.assertEquals(getText(arv.auto_method), "Automatic");

		// Assert the Scores:
		// -Test Points Maximum Score Possible
		Assert.assertEquals(getText(arv.peerpoint_grid), maxscoreposs1);

	}

	/*
	 * To check that the assessment not listed in pending evaluation tab
	 */
	@Test(priority = 46)
	public void TCSPR1500146() {

		waitThread(3000);
		// Click on Pending Evaluation Tab
		click(arv.pending_ev_tab);

		waitThread(3000);
		// Assert the pending evaluation tab is selected
		Assert.assertEquals(getAttribute(arv.pending_ev_tab, "aria-selected"), "true");

		// Search the Assessment Name
		// click(arv.search_bx);
		// type(arv.search_bx, AssessmentName);

		waitThread(4000);
		// Assert the Label "No Assessment found"
		Assert.assertEquals(getText(arv.noassess_text), "No Assessment(s) Found.");
	}

	/*
	 * To perform Delete Teacher Account functionality
	 */
	@Test(priority = 47)
	public void DeleteTeacher() {

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
	@Test(priority = 48)
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
	@Test(priority = 49)
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
	@Test(priority = 50)
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
}
