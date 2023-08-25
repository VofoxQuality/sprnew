package ResultWindowofIndividualTeacherTest;

import java.sql.SQLException;
import java.text.ParseException;
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
import CreateNewAssessment.Pages.ScheduleConfigureDefaultPage;
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
import ResultWindowofIndividualTeacherPage.TeacherReconsiderationWindowPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import TestWindowOfIndividualStudent.AssessmentSubmitAndStatusPopUpPage;
import TestWindowOfIndividualStudent.ModifyWizardSectionPage;
import TestWindowOfIndividualStudent.TestWindowWizardPage;

public class TeacherReconsiderationWindowTest extends basePage {

	TeacherReconsiderationWindowPage trwp = new TeacherReconsiderationWindowPage();

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
	ScheduleConfigureDefaultPage sd = new ScheduleConfigureDefaultPage();
	TeacherManualResultPeerreviewcompletePage mrp = new TeacherManualResultPeerreviewcompletePage();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	SignUpPage sp = new SignUpPage();
	CourseRosterPage cr = new CourseRosterPage();
	EncryptedText et = new EncryptedText();
	Databaseconnection dc = new Databaseconnection();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	CommonFileTest cmt = new CommonFileTest();

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
	 * To load the create new assessment page and fill details on the basic
	 * details page
	 */

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
		waitThread(2000);
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

	@Test(priority = 2)
	public void TCSPR1500702() {
		SoftAssert softAssert1 = new SoftAssert();
		lg.login1(Emailteacher, password);
		waitThread(4000);

		// Click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(7000);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		// Click on create new assessment
		waitThread(2000);
		click(ba.btn_createnewassessment);

		// Click on Select course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		// Assert the course name visible on the dropdown
		softAssert1.assertEquals(getText(ba.ddcoursename1), CourseName3.trim(),
				"course name not visible on the dropdown");

		// Click on course
		click(ba.ddcoursename1);

		// Type Assessment name
		click(QP.Assess_name);
		AssessmentName = "SPR0067_Assessment" + generateRandomNumber().trim();
		type(QP.Assess_name, AssessmentName);

		// Click on save &next button
		waitThread(2000);
		click(QP.Savenext);
		waitThread(2000);

		// Assert the question wizard is selected
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");
		softAssert1.assertAll();

	}

	/*
	 * To fill details for Question 1
	 */
	@Test(priority = 3)
	public void TCSPR1500703() {
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
	public void TCSPR1500704() {
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
	public void TCSPR1500705() {

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
	/*
	 * To verify the details on the peer review page
	 */

	public String RewardPercent = "50";
	public String studcount = "3";

	@Test(priority = 6)
	public void TCSPR1500706() {

		waitThread(1000);
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

	public String reconisderdays;
	public String reconsidertime;

	/*
	 * To perform the save and next functionality from peer review page and
	 * verify the schedule page details
	 * 
	 */
	@Test(priority = 7)
	public void TCSPR1500707() {

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

		// Click Allow ResConsideration checkbox
		click(sb1.allowstu_checkbx2);

		waitThread(3000);
		// Assert the radio button is selected
		Assert.assertTrue(getAttribute(sb1.teachwill_radio_select, "class").contains("checked"));

		// Click on Days dropdown
		click(sb1.day_recons_dropdwn);
		click("div > ul > p-dropdownitem:nth-child(2) > li");

		// select 1 days
		// click(sb1.reconsiderationday);
		// Assert the date visible on the page
		Assert.assertEquals(getValue(sb1.day_drop_txtbx), "1");
		reconisderdays = getValue(sb1.day_drop_txtbx);
		reconsidertime = getValue(sb1.lasttime_txtbx);

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
	public void TCSPR1500708() {

		ScrollTo_xy_position(300, 0);
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
	public void TCSPR1500709() {

		waitThread(2000);
		// Click Back to Menu
		click(tts.back_to_menubutton);

		waitThread(6000);
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
	public void TCSPR1500710() throws InterruptedException {

		// Login to Student1
		lg.login1(Emailstudent1, cm.Password);

		waitThread(6000);
		// Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		// wait for 1 min
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(50);
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
	public void TCSPR1500711() {

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
		waitThread(2000);
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
	public void TCSPR1500712() {

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
	public void TCSPR1500714() {

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
	public void TCSPR1500715() {

		waitThread(2000);
		// Click Savebutton
		click(tsw.save_btn_test);

		waitFor(QP.toaster);
		// Assert Toaster Answer saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);
		waitThread(2000);
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
	public void TCSPR1500716() throws InterruptedException {
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
	public void TCSPR1500717() {
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
		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 18)
	public void TCSPR1500718() {

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
	public void TCSPR1500719() {

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
	public void TCSPR1500720() {

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
	public void TCSPR1500721() throws InterruptedException {

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

		waitThread(5000);
		// Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		type(st1.stud_searchbx, AssessmentName);
		// driver.findElement(By.id("searchAssessmentFilter")).sendKeys(" ");
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Wait till peer review active
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(80);

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
	public void TCSPR1500722() {

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
	public void TCSPR1500723() {

		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "6");

		// click submit button
		click(ms.submit_btn);
		waitThread(1000);
		Assert.assertTrue(isDisplayed(prp.confir_popup), "popup not visible");
		waitThread(2000);
		click(prp.submit_confi);
		waitThread(2000);
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
	public void TCSPR1500724() {
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
	public void TCSPR1500725() {
		Scroll_DowntoEnd();
		waitThread(2000);

		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "2");

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
		type(prp.scorestud1, "3");

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
	public void TCSPR1500726() throws InterruptedException {

		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "5");

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
	public void TCSPR1500727() {

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
	public void TCSPR1500728() {

		Scroll_DowntoEnd();
		waitThread(2000);
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
	public void TCSPR1500729() {

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
	 * Perform teacher login and reschedule the peer review and result date
	 */
	@Test(priority = 30)
	public void TCSPR1500730() throws InterruptedException {

		// Login to Teacher profile
		cm.login(Emailteacher, cm.Password);

		// Click Assessment tab
		click(QP.teach_assesstab);

		waitThread(7000);

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

		TimeUnit.MINUTES.sleep(2);

		waitThread(3000);
		// Assert label result upcoming
		// Assert.assertEquals(getText(tts.time_status), "Result Upcoming");

	}

	/*
	 * To verify the result section Labels
	 */
	@Test(priority = 31)
	public void TCSPR1500731() {

		ScrollTo_Location(arv.viewresult_teachcard);

		// Assert label result upcoming
		// Assert.assertEquals(getText(tts.time_status), "Result Upcoming");

		// Assert the Result status is pending
		Assert.assertEquals(getText(tr.resultsts_lbl), "Pending");

		// Assert text "You need to manually publish the result"
		Assert.assertEquals(getText(rd.manualpublishcard_txt), "You need to manually publish the result");

		// Assert the label reconsider
		Assert.assertEquals(getText(rd.reconsiderlbl), "Last Date for Reconsideration Request: " + reconisderdays
				+ " days from Result Publish, " + cm.removeLeadingZeroes(reconsidertime));

		// Assert the Button and Button label Evaluate Answers
		Assert.assertTrue(isElementPresent(arv.viewresult_teachcard), "Evaluate Answers button not present");
		Assert.assertEquals(getText(arv.viewresult_teachcard), "Evaluate Answers");

	}
	/*
	 * To Perform the evaluate answer functionality from teacher login
	 */

	@Test(priority = 32)
	public void TCSPR1500732() {

		waitThread(3000);
		// Click on Evaluate Answer Button
		click(arv.viewresult_teachcard);
		waitThread(4000);
		// Assert the Heading Peer Review Results
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Peer Review Results");

		// *Assert the student 1 Status "Peer Review Completed"
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[9]/div/p"),
				"Peer Review Completed");
		// *Assert the student 2 Status "Peer Review Completed"
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[9]/div/p"),
				"Peer Review Completed");
		// *Assert the student 3 Status "Peer Review Completed"
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[9]/div/p"),
				"Peer Review Completed");
		// *Assert the new reconsideration time 1 days from Result publish, Time
		Assert.assertEquals(getText(trwp.reconisiderationtime),
				reconisderdays + " days from Result publish, " + cm.removeLeadingZeroes(reconsidertime));
	}

	public String Stud1Rewardscore;
	public String stud1scorefrompeers;
	public String stud1Totalscore;
	public String Stud2Rewardscore;
	public String stud2scorefrompeers;
	public String stud2Totalscore;
	public String Stud3Rewardscore;
	public String stud3scorefrompeers;
	public String stud3Totalscore;

	public String Resultpublishdate;
	public String reconsiderationdate;

	/*
	 * To perform publish the result functionality on the teacher login
	 */
	@Test(priority = 33)
	public void TCSPR1500733() throws ParseException {

		// Click on Publish button
		click(ari.publish_btn);
		waitThread(2000);
		Resultpublishdate = trwp.getDate_1();
		reconsiderationdate = trwp.getnextday_1();
		// Assert the publish popup visible
		Assert.assertTrue(isElementPresent(ari.publish_popup), "popup not present");
		// Assert the Label "Result Published Successfully"
		Assert.assertEquals(getText(ari.pub_popup_txt), "Result Published Successfully");

		// Assert the reconsideration date and time
		Assert.assertEquals(getText(trwp.resultpopupreconsiderdate), "Last date for raising Reconsideration will be: "
				+ sd.getNextday__2() + " - " + sd.Nextdayname() + " at " + cm.removeLeadingZeroes(reconsidertime));
		// Assert the Back to results button
		Assert.assertTrue(isElementPresent(ari.publish_backtores_btn), "Back to results button not present");
		waitThread(1000);
		// Click on Back to Results Button
		click(ari.publish_backtores_btn);

		waitThread(3000);
		// Assert the Heading Final result
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Final Result");
		// Assert the reconsideration timer
		Assert.assertTrue(isElementPresent(trwp.reconsidertimer), "Reconisderation timer not visible");
		Assert.assertTrue(getText(trwp.reconsidertimer).contains("Reconsideration Request Active for "),
				"Timer text not visible");

		// Student 1 reward score
		Stud1Rewardscore = cm.getdatafromgrid(Student1name,
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[6]/div/span/a");
		// Student 2 reward score
		Stud2Rewardscore = cm.getdatafromgrid(Student2name,
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[6]/div/span/a");
		// Student 3 reward score
		Stud3Rewardscore = cm.getdatafromgrid(Student3name,
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[6]/div/span/a");

		// Student 1 Score Received from Peers
		stud1scorefrompeers = cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[7]/div/span");
		// Student 2 Score Received from Peers
		stud2scorefrompeers = cm.getdatafromgrid(Student2name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[7]/div/span");
		// Student 3 Score Received from Peers
		stud3scorefrompeers = cm.getdatafromgrid(Student3name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[7]/div/span");

		// Student 1 Total Score
		stud1Totalscore = cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[8]/div/span");
		// Student 2 Total Score
		stud2Totalscore = cm.getdatafromgrid(Student2name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[8]/div/span");
		// Student 3 Total Score
		stud3Totalscore = cm.getdatafromgrid(Student3name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[8]/div/span");

		// Click on Back button
		click(arv.back_btn);
		waitThread(7000);

		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(trwp.teachercurrenttab, "class").contains("p-highlight"));

	}

	/*
	 * To check the Result details on the Card and reschedule page
	 */
	@Test(priority = 34)
	public void TCSPR1500734() {

		waitThread(3000);
		// search assessment
		type(st1.assess_searchbx, AssessmentName);
		driver.findElement(By.id("searchAssessments")).sendKeys("  ");
		waitThread(3000);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");
		waitThread(3000);
		// Assert label result Available
		Assert.assertEquals(getText(tts.time_status), "Result Available");

		// Assert the Result status is pending
		Assert.assertEquals(getText(tr.resultsts_lbl), "Active");

		// Assert the label reconsider
		Assert.assertEquals(getText(rd.reconsiderlbl), "Last Date for raising Reconsideration Request:\n"
				+ reconsiderationdate + ", " + cm.removeLeadingZeroes(reconsidertime));

		// Assert the Button and Button label View Result
		Assert.assertTrue(isElementPresent(arv.viewresult_teachcard), "View Result button not present");
		Assert.assertEquals(getText(arv.viewresult_teachcard), "View Result");

		// Assert text "You need to manually publish the result"
		Assert.assertTrue(getText(trwp.resultdatelbl).contains("Result Published Date: " + Resultpublishdate + ", "));

	}

	/*
	 * Login As student 1 and check the Details of Result window
	 */
	@Test(priority = 35)
	public void TCSPR1500735() {
		// perform teacher logout
		cm.Logout();

		// login as Student 1
		waitThread(2000);
		lg.login1(Emailstudent1, cm.Password);

		// Search the Assessment Name
		waitThread(7000);
		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		click(st1.stud_searchbx);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys("     ");
		waitThread(5000);

		// Assert Label "Result Available"
		Assert.assertEquals(getText(ari.stud_cardhead_lbl), "Result Available");

		// Assert the Result status is Active
		Assert.assertEquals(getText(tr.resultsts_lbl), "Active");

		// Assert text "You need to manually publish the result"
		Assert.assertTrue(getText(trwp.resultdatelbl).contains("Result Published Date: " + Resultpublishdate + ", "));

		// Assert the label reconsider
		Assert.assertEquals(getText(rd.reconsiderlbl), "Last date for reconsideration: " + reconsiderationdate + ", "
				+ cm.removeLeadingZeroes(reconsidertime));

		// Assert the view result button visible
		Assert.assertTrue(isElementPresent(rwbt.viewresultbtn), "View result button not visible");
		Assert.assertEquals(getText(rwbt.viewresultlbl), "View Result");

	}

	public String Q1Scorefrompeers;
	public String Q1rewardscorestud;
	public String Q1Finalscore;
	public String Q2Scorefrompeers;
	public String Q2Finalscore;
	public String Q3Scorefrompeers;
	public String Q3Finalscore;
	public String Student1Totalscore;

	public String Student1comment;

	/*
	 * To check the Details of Result window
	 */
	@Test(priority = 36)
	public void TCSPR1500736() {

		// click on view result button
		click(rwbt.viewresultbtn);
		waitThread(3000);

		// Assert Result pop up visible
		Assert.assertTrue(isElementPresent(rwbt.resultpopup), "Result Popup  not visible");

		// Assert the heading Result
		Assert.assertEquals(getText(rwbt.label_Result_1), "Result");

		// Reconsideration label
		Assert.assertTrue(
				getText(trwp.lbl_reconsideration).contains("Time left for raising Reconsideration Request : "),
				"Reconsideration label not visible");

		// Read the Scores Received from Peer Reviewers of each Question
		Q1Scorefrompeers = trwp.getdatafromgridstudent("1",
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[5]/div/span");
		Q2Scorefrompeers = trwp.getdatafromgridstudent("2",
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[5]/div/span");
		Q3Scorefrompeers = trwp.getdatafromgridstudent("3",
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[5]/div/span");
		// Final Score of each Question
		Q1Finalscore = trwp.getdatafromgridstudent("1",
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[7]/div/span");
		Q2Finalscore = trwp.getdatafromgridstudent("2",
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[7]/div/span");
		Q3Finalscore = trwp.getdatafromgridstudent("3",
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[7]/div/span");
		// Total Score
		Student1Totalscore = getText(trwp.Student1totalscore);
		Q1rewardscorestud = trwp.getdatafromgridstudent("1",
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[6]/div/span");
	}

	/*
	 * To submit the Reason For Reconsideration Request
	 */
	@Test(priority = 37)
	public void TCSPR1500737() {

		// click on reconsideration button
		click(trwp.btn_reconsiderationreqst);

		// Assert the popup visible
		Assert.assertTrue(isElementPresent(trwp.commentpop), "Comment Popup  not visible");

		Student1comment = "Student 1 reconsideration comment_" + generateRandomData();
		// Type reconsideration comment
		type(trwp.commenttextbx, Student1comment);
		// To verify the submit button is enabled
		Assert.assertFalse(getAttribute(trwp.commentsubmitbtn_submit, "class").contains("raiseBtnDisabled"),
				"Publish button is disabled");
		// click on publish button
		click(trwp.commentsubmitbtn_submit);
		waitFor(QP.toaster);

		// Assert the toaster "Reconsideration Request Raised"
		Assert.assertEquals(getText(QP.toaster), "Reconsideration Request Raised");

		click(QP.toasterclosebtn);
		// Assert the View Teacher Response to Reconsideration Request button is
		// disabled
		Assert.assertTrue(getAttribute(trwp.viewteachercomment, "class").contains("disabled"),
				"Teacher Response to Reconsideration Request button is enabled");

	}

	/*
	 * To verify the student Card status after submit,the reconsideration
	 * request
	 */
	@Test(priority = 38)
	public void TCSPR1500738() {

		// click close button
		click(rwbt.resultpopupclosebtn);
		waitThread(5000);
		waitThread(5000);
		// Search the Assessment Name
		Doubleclick(st1.stud_searchbx);
		waitThread(5000);
		click(st1.stud_searchbx);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys("       ");
		waitThread(5000);

		// Assert the Result status is Reconsideration Requested
		Assert.assertEquals(getText(trwp.Cardlbl_reconsideration), "Reconsideration Requested");
		waitThread(5000);
		// Assert the Result status is Active
		Assert.assertEquals(getText(tr.resultsts_lbl), "Active");

		// Assert the Card status is Reconsideration Requested
		Assert.assertEquals(getText(trwp.cardheadinglbl), "Reconsideration Requested");

	}

	/*
	 * Login as teacher and check that the student reconsideration details on
	 * the assessment card
	 */
	@Test(priority = 39)
	public void TCSPR1500739() {

		// Perform Student 1 Logout
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

		click(st1.assess_searchbx);
		// search newly created assessment
		type(st1.assess_searchbx, AssessmentName);
		driver.findElement(By.id("searchAssessments")).sendKeys("     ");
		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");

		// Assert label Reconsideration Requested
		Assert.assertEquals(getText(tts.time_status), "Reconsideration Requested");

		// Assert the Result status is pending
		Assert.assertEquals(getText(tr.resultsts_lbl), "Active");

		// Assert text "You need to manually publish the result"
		Assert.assertTrue(getText(trwp.resultdatelbl).contains("Result Published Date: " + Resultpublishdate + ", "));

		// Assert the label reconsider
		Assert.assertEquals(getText(rd.reconsiderlbl), "Last Date for raising Reconsideration Request:\n"
				+ reconsiderationdate + ", " + cm.removeLeadingZeroes(reconsidertime));

		// Assert the Reconsideration count
		Assert.assertEquals(getText(trwp.teachercard_reconsidercount),
				"Reconsideration requested: 1 Pending 0 Processed");

		// Assert the button label View
		Assert.assertEquals(getAttribute(trwp.btn_view, "label"), "View");

	}

	/*
	 * To check that the assessment listed on the Reconsideration Tab
	 */
	@Test(priority = 40)
	public void TCSPR1500740() {

		// Click on Reconsideration Requests Tab
		click(trwp.reconsidertab);
		Assert.assertEquals(getText(trwp.reconsidertab), "Reconsideration Requests");
		// Verify the tab is selected
		Assert.assertEquals(getAttribute(trwp.tab_reconsiderationrequest, "aria-selected"), "true");

		// Search the Assessment Name
		// type(trwp.searchbox, AssessmentName);

		// Assert the Labels on the grid
		Assert.assertEquals(getText(trwp.reconsider_coursename), CourseName3.trim());
		Assert.assertEquals(getText(trwp.reconsider_ass_name), AssessmentName);
		Assert.assertEquals(getText(trwp.reconsider_maxscore), maxscoreposs1);
		Assert.assertEquals(getText(trwp.reconsider_pending), "1");
		Assert.assertEquals(getText(trwp.reconsider_reqst_proccess), "0");
		// Assert the view request button visible
		Assert.assertTrue(isElementPresent(trwp.view_request_btn), "View request button  not visible");
		Assert.assertEquals(getText(trwp.view_request_btn_lbl), "View Request");

	}

	/*
	 * To view the reconsideration request and check the Labels on the
	 * reconsideration window
	 */
	@Test(priority = 41)
	public void TCSPR1500741() {

		// Click on View Request button
		click(trwp.view_request_btn);
		waitThread(5000);
		// Heading Label
		Assert.assertEquals(getText(trwp.lbl_reconsider_heading), "Reconsideration Requests");
		// Assert the Labels
		// Course Name: Course name and course ID
		// Assessment Name: Assessment Name
		Assert.assertEquals(getText(trwp.courseBasicDetailsRecon),
				"Course Name: " + CourseName3.trim() + " (" + CourseID3 + ")\n" + "Assessment Name: " + AssessmentName);
		// Reconsideration pending count
		Assert.assertEquals(getText(trwp.reconsiderationPendingCount),
				"Reconsideration Request\n" + "Pending: 1\n" + "Processed: 0");
	}

	/*
	 * To check the Labels on the Reconsideration window
	 */
	@Test(priority = 42)
	public void TCSPR1500742() {

		// Assert the Label and Value-Total Peer Review Points
		Assert.assertEquals(getText(trwp.reconTotalPeerPoints), "Total Peer Review Points\n" + Totalpeerreviewpoint);
		// Assert the Label and Value-Total Test Points
		Assert.assertEquals(getText(trwp.reconTotalTestPoints), "Total Test Points\n" + TotalTestPoints);

		// Assert the Label and Value-Maximum Score Possible
		// (Total Test Points + Total Peer Review Points)
		Assert.assertEquals(getText(trwp.reconMaxScorePossible),
				"Maximum Score Possible\n(Total Test Points + Total Peer Review Points)\n" + maxscoreposs1);

	}

	/*
	 * To check the Labels on the Reconsideration window
	 */
	@Test(priority = 43)
	public void TCSPR1500743() {

		// Assert the Labels and radio buttons
		Assert.assertTrue(isElementPresent(trwp.radiobtn_reconsider),
				"Reconsideration Requests radio button not visible");
		Assert.assertTrue(isElementPresent(trwp.radiobtn_allresults),
				"Reconsideration Requests radio button not visible");
		Assert.assertEquals(getText(trwp.lbl_reconsiderrequest), "Reconsideration Requests");
		Assert.assertEquals(getText(trwp.lbl_Allresults), "All Results");
		// Assert the Reconsideration Requests radio button is selected
		Assert.assertTrue(getAttribute(trwp.radiobtn_reconsider, "Class").contains("checked"));
		// Assert the All results radio button is not selected
		Assert.assertFalse(getAttribute(trwp.radiobtn_allresults, "Class").contains("checked"));
		waitThread(3000);
		// Assert the color green for Completed
		Assert.assertTrue(getAttribute(trwp.completed_dot, "Class").contains("green-dot"));
		Assert.assertEquals(getText(trwp.completed_lbl), "Completed");
		// Assert the color orange for Incomplete
		Assert.assertTrue(getAttribute(trwp.incomplete_dot, "Class").contains("orange-dot"));
		Assert.assertEquals(getText(trwp.incomplete_lbl), "Incomplete");
	}

	/*
	 * To check the grid Labels on the reconsideration window
	 */
	@Test(priority = 44)
	public void TCSPR1500744() {

		// Assert the Following Grid Labels

		Assert.assertEquals(getText(trwp.lbl_sino), "Sl No");
		Assert.assertEquals(getText(trwp.lblStudentName_), "Student\n" + "Name");
		Assert.assertEquals(getText(trwp.lbl_Answersheetsreviewedby), "Answer Sheets\n" + "Reviewed by");
		Assert.assertEquals(getText(trwp.lblraisedon), "Raised On");
		Assert.assertEquals(getText(trwp.lblstatus), "Status");
		Assert.assertEquals(getText(trwp.lbl_RewardPoint), "Reward\n" + "Point");
		Assert.assertEquals(getText(trwp.lbl_ScorefromPeers_), "Score Received from\n" + "Peers");
		Assert.assertEquals(getText(trwp.lbl_TotalScore_), "Total Score");
		Assert.assertEquals(getText(trwp.lbl_AnswerSheet), "Answer\n" + "Sheet");

		// Assert the student Names
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[3]/div"), Student1name);
		// Reward score
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[7]/div/span"),
				Stud1Rewardscore);
		// Score received from peers
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[8]/div/span"),
				stud1scorefrompeers);
		// Total Score of student 1
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[10]/div/span"),
				stud1Totalscore);
		// Status
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[6]/div/span"),
				"Reconsideration Pending");

		// reviewer name
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[4]/div/div/p-badge/span"),
				Student2name);

	}

	/*
	 * To check the Labels and Details of the All results page
	 */
	@Test(priority = 45)
	public void TCSPR1500745() {

		// click All results button
		click(trwp.radiobtn_allresults);
		waitThread(3000);
		// Assert the All results radio button is selected
		Assert.assertTrue(getAttribute(trwp.radiobtn_allresults, "Class").contains("checked"));
		// Assert the heading
		Assert.assertEquals(getText(trwp.lbl_allresults), "All Results");

		// Assert the Labels
		// Course Name: Course name and course ID
		// Assessment Name: Assessment Name
		Assert.assertEquals(getText(trwp.courseBasicDetailsRecon),
				"Course Name: " + CourseName3.trim() + " (" + CourseID3 + ")\n" + "Assessment Name: " + AssessmentName);
		// Reconsideration pending count
		Assert.assertEquals(getText(trwp.reconsiderationPendingCount),
				"Reconsideration Request\n" + "Pending: 1\n" + "Processed: 0");

	}

	/*
	 * To check the Labels and Details of the All results page
	 */
	@Test(priority = 46)
	public void TCSPR1500746() {

		// Assert the Label and Value-Total Peer Review Points
		Assert.assertEquals(getText(trwp.reconTotalPeerPoints), "Total Peer Review Points\n" + Totalpeerreviewpoint);
		// Assert the Label and Value-Total Test Points
		Assert.assertEquals(getText(trwp.reconTotalTestPoints), "Total Test Points\n" + TotalTestPoints);

		// Assert the Label and Value-Maximum Score Possible
		// (Total Test Points + Total Peer Review Points)
		Assert.assertEquals(getText(trwp.reconMaxScorePossible),
				"Maximum Score Possible\n(Total Test Points + Total Peer Review Points)\n" + maxscoreposs1);

	}

	/*
	 * To check the Labels and Details of the All results page
	 */
	@Test(priority = 47)
	public void TCSPR1500747() {

		// Assert the Following Grid Labels

		Assert.assertEquals(getText(trwp.lbl_sinoAll_results), "Sl No");
		Assert.assertEquals(getText(trwp.lblStudentNameAll_results_), "Student Name");
		Assert.assertEquals(getText(trwp.lbl_QuestionsAnsweredAll_results), "Questions\n" + "Answered");
		Assert.assertEquals(getText(trwp.lblReviewedbyAll_results_), "Answer Sheets Reviewed by");
		Assert.assertEquals(getText(trwp.lbl_RewardPointAll_results), "Reward\n" + "Point");
		Assert.assertEquals(getText(trwp.lbl_ScorefromPeersAll_results_), "Score Received from\n" + "Peers");
		Assert.assertEquals(getText(trwp.lbl_TotalScore_1_), "Total Score");
		Assert.assertEquals(getText(trwp.lbl_AnswerSheet_1), "Answer\n" + "Sheet");

		Stud1Rewardscore = cm.getdatafromgrid(Student1name,
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[6]/div/span/a");

	}

	/*
	 * To check the Labels and Details of the All results page and check Student
	 * 1,Student 2,Student 3 Score details
	 */
	@Test(priority = 48)
	public void TCSPR1500748() {

		// Assert the student Names
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[3]/div"), Student1name);
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[3]/div"), Student2name);
		Assert.assertEquals(cm.getdatafromgrid(Student3name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[3]/div"), Student3name);

		// Reward points of student 1,2,3
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[6]/div/span/a"),
				Stud1Rewardscore);
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[6]/div/span/a"),
				Stud2Rewardscore);
		Assert.assertEquals(cm.getdatafromgrid(Student3name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[6]/div/span/a"),
				Stud3Rewardscore);

		// Score received from peers of student 1,2,3

		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[7]/div/span"),
				stud1scorefrompeers);
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[7]/div/span"),
				stud2scorefrompeers);
		Assert.assertEquals(cm.getdatafromgrid(Student3name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[7]/div/span"),
				stud3scorefrompeers);

		// Total Score of student 1,2,3
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[8]/div/span"),
				stud1Totalscore);
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[8]/div/span"),
				stud2Totalscore);
		Assert.assertEquals(cm.getdatafromgrid(Student3name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[8]/div/span"),
				stud3Totalscore);
	}

	/*
	 * To check the Labels
	 */
	@Test(priority = 49)
	public void TCSPR1500749() {

		// click on reconsideration request radio button
		click(trwp.radiobtn_reconsider);
		waitThread(2000);
		// Assert the Reconsideration Requests radio button is selected
		Assert.assertTrue(getAttribute(trwp.radiobtn_reconsider, "Class").contains("checked"));
		// *Assert Only one student names shows on the Grid
		Assert.assertEquals(TotalElementsCount(trwp.studentname), 1);
		// "*Assert the Score Received from Teacher/Peers is Empty"
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[9]/div/span"), "--");
	}
	/*
	 * To verify the Student 1 Details on the grid
	 */

	@Test(priority = 50)
	public void TCSPR1500750() {

		// Assert the student name
		Assert.assertEquals(getText(trwp.studentname), Student1name);
		waitThread(1000);
		// Assert the reviewer name
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[4]/div/div/p-badge/span"),
				Student2name);
		waitThread(1000);
		// Assert the status Reconsideration Pending
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[6]/div/span"),
				"Reconsideration Pending");
		waitThread(1000);
		// Assert the reward score of student 1
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[7]/div/span"),
				Stud1Rewardscore);
		waitThread(1000);
		// Assert the Score received from peers of student 1
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[8]/div/span"),
				stud1scorefrompeers);
		waitThread(1000);
		// Assert the Total Score of student 1
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[10]/div/span"),
				stud1Totalscore);

	}

	/*
	 * To check the reconsider answer window of student 1 and the Student reason
	 * for Reconsideration pop up
	 */
	@Test(priority = 51)
	public void TCSPR1500751() {

		// Reconsider button label
		Assert.assertEquals(getAttribute(trwp.btn_reconsider, "label"), "Reconsider");
		// click on reconsider button
		click(trwp.btn_reconsider);

		// Assert the pop up
		Assert.assertTrue(isElementPresent(trwp.systemGeneratedCommentDialog),
				"Student reason for Reconsideration popup not shows");
		// Assert the pop up heading
		Assert.assertEquals(getText(trwp.commentpopupheading), "Student reason for Reconsideration");
		// Assert the student comment
		Assert.assertEquals(getText(trwp.studentcomment), Student1comment);
		// click on close button
		click(trwp.btnclose_commentpopup);
		waitThread(2000);
		Assert.assertFalse(isElementPresent(trwp.systemGeneratedCommentDialog),
				"Student reason for Reconsideration popup visible");
		// Student reason for Reconsideration button and tool tip
		Assert.assertTrue(isElementPresent(trwp.reconsodercommentbtn),
				"Student reason for Reconsideration button visible");
		Assert.assertEquals(getAttribute(trwp.btn_reconsider_1, "ptooltip"), "Student reason for Reconsideration");

	}

	/*
	 * To check the Labels and buttons on the reconsider answer window
	 */
	@Test(priority = 52)
	public void TCSPR1500752() {

		// Assert the publish button is disabled
		Assert.assertTrue(getAttribute(trwp.btn_publish_recosnider, "class").contains("disabled-btn"),
				"Publish button is Enabled state");
		// Assert the Assessment Name,Course name,Course ID,Student Name
		Assert.assertEquals(getText(arv.result_page_assess_name), AssessmentName);
		Assert.assertTrue(getText(arv.course_name_id).contains(CourseName3.trim()));
		Assert.assertTrue(getText(arv.course_name_id).contains(CourseID3));
		Assert.assertTrue(getText(arv.stud_name_resultwindow).contains(Student1name));
		// Assert the wizard panel
		Assert.assertTrue(getText(arv.wizardq1).contains("1"));

		// Assert the label and check box I approve the Total Scores given by
		// peers
		Assert.assertEquals(getText(ari.iapprove_lbl), "I approve the Total Scores given by peers");
		Assert.assertTrue(isDisplayed(ari.score_checkbx), "Check box not present");
		// Assert the wizard previous button is disabled
		Assert.assertTrue(isElementPresent(trwp.wizardpreviousbtn), "Wizard previous button is Enabled");

	}

	/*
	 * To check the Labels and buttons on the reconsider answer window
	 */
	@Test(priority = 53)
	public void TCSPR1500753() {

		// Assert the Exit button
		Assert.assertTrue(isElementPresent(trwp.btn_exit), "Exit button not visible");
		// Assert the Question 1 is selected
		Assert.assertTrue(getAttribute(arv.wizardq1, "class").contains("p-highlight"));
		// Assert the Label and Value Max Score:
		Assert.assertTrue(getText(arv.maxscore_lbl).contains("Max Score"));
		Assert.assertEquals(getText(arv.maxscore_lbl), "Max Score: " + Maxscore1);
		// Assert the Label and Value Score Received from Peers:
		waitThread(2000);
		Assert.assertEquals(getText(arv.scorefrompeer_lbl), "Score Received from Peers: " + Q1Scorefrompeers);
		// Assert the Label and Value Final Score:
		Assert.assertTrue(getText(arv.final_scrorelbl).contains("Final Score"));
		Assert.assertEquals(getText(arv.final_scrorelbl), "Final Score: " + Q1Finalscore);
		// Total Score
		Assert.assertEquals(getText(trwp.student1totalscorereconsider), stud1Totalscore + "/" + maxscoreposs1);
		// Click on Next button
		click(arv.wizard_nextbtn);

		waitThread(3000);
		// Assert the second Question wizard is selected
		Assert.assertTrue(getAttribute(arv.wizardq2, "class").contains("p-highlight"));
		// Assert the Label and Value Max Score:
		Assert.assertTrue(getText(arv.maxscore_lbl).contains("Max Score"));
		Assert.assertEquals(getText(arv.maxscore_lbl), "Max Score: " + Maxscore2);
		// Assert the Label and Value Score Received from Peers:
		waitThread(2000);
		Assert.assertEquals(getText(arv.scorefrompeer_lbl), "Score Received from Peers: " + Q2Scorefrompeers);
		// Assert the Label and Value Final Score:
		Assert.assertTrue(getText(arv.final_scrorelbl).contains("Final Score"));
		Assert.assertEquals(getText(arv.final_scrorelbl), "Final Score: " + Q2Finalscore);
	}

	/*
	 * To check the Labels and buttons on the reconsider answer window
	 */
	@Test(priority = 54)
	public void TCSPR1500754() {

		waitThread(4000);
		// Click on 3rd Wizard
		Doubleclick(arv.wizardq3);

		waitThread(2000);
		// Assert the 3rd Question wizard is selected
		Assert.assertTrue(getAttribute(arv.wizardq3, "class").contains("p-highlight"));

		waitThread(3000);
		// Assert the Next button is disabled
		Assert.assertTrue(getAttribute(arv.wizard_nextbtn, "class").contains("p-disabled"));
		// Assert the Label and Value Max Score:
		Assert.assertTrue(getText(arv.maxscore_lbl).contains("Max Score"));
		Assert.assertEquals(getText(arv.maxscore_lbl), "Max Score: " + Maxscore3);
		// Assert the Label and Value Score Received from Peers:
		waitThread(2000);
		Assert.assertEquals(getText(arv.scorefrompeer_lbl), "Score Received from Peers: " + Q3Scorefrompeers);
		// Assert the Label and Value Final Score:
		Assert.assertTrue(getText(arv.final_scrorelbl).contains("Final Score"));
		Assert.assertEquals(getText(arv.final_scrorelbl), "Final Score: " + Q3Finalscore);
		// click Q1
		Doubleclick(arv.wizardq1);
		// Assert the Question content
		driver.switchTo().frame("questionId_ifr");
		Assert.assertEquals(getText(arv.quest), Question1);
		driver.switchTo().defaultContent();

		// Assert the accordian label Answer
		Assert.assertEquals(getText(arv.answer_accordian), "Answer");

		waitThread(3000);
		// Assert the Answer of Student 1
		driver.switchTo().frame("answerId_ifr");
		Assert.assertEquals(getText(arv.answer), stud1ans1);
		driver.switchTo().defaultContent();

		// Assert the accordion label Rubric
		Assert.assertEquals(getText(arv.rubric_aacordian), "Rubric");

		waitThread(2000);
		// Click on Rubric accordion
		click(arv.rubric_aacordian);

		// Assert the Rubric of Question 1
		driver.switchTo().frame("standardRubricId_ifr");
		Assert.assertEquals(getText(arv.rubric), Rubric1);
		driver.switchTo().defaultContent();

		// Assert the student Names
		Assert.assertEquals(getText(arv.studname1), Student2name);

		// Assert the Score given by each student
		Assert.assertEquals(getValue(arv.score_stud1), Q1Scorefrompeers);

	}

	public String Q1Scorefromteacher_1 = "8";
	public String Q1Scorefromteacher_new = "2";

	/*
	 * To check the Labels and buttons on the reconsider answer window and type
	 * score for question 1
	 */
	@Test(priority = 55)
	public void TCSPR1500755() {

		// Type Score for Question 1
		type(trwp.scoretextbx, Q1Scorefromteacher_1);
		// click save button
		// Click Save button
		waitThread(2000);
		click(ari.save_btn);

		// Assert the toaster "Score Saved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);

		waitThread(3000);
		// Save button is disabled
		Assert.assertFalse(isEnabled(ari.save_btn), "Save button is Enabled");

		// Wizard status-reconsidered
		Assert.assertTrue(getAttribute(arv.wizardq1, "class").contains("reconsidered"));
		waitThread(2000);
		// Assert the Scores :Score Received from Teacher:
		Assert.assertEquals(getText(ari.scorefromteach_lbl), "Score Received from Teacher: " + Q1Scorefromteacher_1);
	}

	public int Scorefrompeersandteacher;
	public int totalscorestud1;

	/*
	 * To check the exit button functionality and check the labels
	 */
	@Test(priority = 56)
	public void TCSPR1500756() {

		// click on exit button
		click(trwp.btn_exit);
		waitThread(2000);
		// Heading Label
		Assert.assertEquals(getText(trwp.lbl_reconsider_heading), "Reconsideration Requests");
		// Continue button label
		Assert.assertEquals(getAttribute(trwp.btn_continue, "label"), "Continue");
		// Score received from teacher of Q1+Score received from peer of
		// Q2+Score
		// received from peer of Q3
		Scorefrompeersandteacher = (Integer.parseInt(Q1Scorefromteacher_1)) + (Integer.parseInt(Q2Scorefrompeers))
				+ (Integer.parseInt(Q3Scorefrompeers));
		// Score received from peers/Teachers
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[9]/div/span"),
				Integer.toString(Scorefrompeersandteacher));
		// Total Score=Score Received from Teacher/Peers +Reward Score
		totalscorestud1 = Scorefrompeersandteacher + (Integer.parseInt(Stud1Rewardscore));
		// Score received from peers/Teachers
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[10]/div/span"),
				Integer.toString(totalscorestud1));

	}

	/*
	 * To check the labels of reconsideration window and all results page
	 */
	@Test(priority = 57)
	public void TCSPR1500757() {

		// Reconsideration pending count
		Assert.assertEquals(getText(trwp.reconsiderationPendingCount),
				"Reconsideration Request\n" + "Pending: 1\n" + "Processed: 0");
		// click All results button
		click(trwp.radiobtn_allresults);
		waitThread(2000);
		Assert.assertEquals(getText(trwp.lbl_ScorefromTeacher_PeersAll_results),
				"Score Received from\n" + "Teacher/Peers");
		// Assert the All results radio button is selected
		Assert.assertTrue(getAttribute(trwp.radiobtn_allresults, "Class").contains("checked"));
		// Score from peers/Teachers
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[8]/div/span"),
				Integer.toString(Scorefrompeersandteacher));

		// Total Score of student 1
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[9]/div/span"),
				Integer.toString(totalscorestud1));

	}
	/*
	 * To check the back button functionality and check the card details
	 */

	@Test(priority = 58)
	public void TCSPR1500758() {

		waitThread(3000);
		// Click On Back button
		click(trwp.back_btn);

		waitThread(6000);
		click(arv.cuurent_assm_tab);
		waitThread(8000);
		// Assert the Current Tab selected
		Assert.assertEquals(getAttribute(arv.cuurent_assm_tab, "aria-selected"), "true");

		// search assessment
		type(st1.assess_searchbx, AssessmentName);
		driver.findElement(By.id("searchAssessments")).sendKeys("    ");

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");
		waitThread(3000);
		// Assert the Reconsideration count
		Assert.assertEquals(getText(trwp.teachercard_reconsidercount),
				"Reconsideration requested: 1 Pending 0 Processed");

		// Assert the button label View
		Assert.assertEquals(getAttribute(trwp.btn_view, "label"), "View");

	}

	/*
	 * To view the result from the card and Modify the Score of Q1
	 */
	@Test(priority = 59)
	public void TCSPR1500759() {

		// Click on View Request button
		click(trwp.btn_view);
		waitThread(3000);
		// Heading Label
		Assert.assertEquals(getText(trwp.lbl_reconsider_heading), "Reconsideration Requests");

		// click button continue
		click(trwp.btn_continue);
		waitThread(3000);
		click(trwp.btnclose_commentpopup);
		waitThread(3000);
		// Assert the check box is disabled
		Assert.assertTrue(getAttribute(ari.score_checkbx_check, "class").contains("disabled"));

		// Type new Score for Question 1
		type(trwp.scoretextbx, Q1Scorefromteacher_new);

		// click on exit button
		click(trwp.btn_exit);
		waitThread(2000);

	}

	/*
	 * Click on Exit button from student answer window and check that the Score
	 * modified on the gird
	 */
	@Test(priority = 60)
	public void TCSPR1500760() {

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
		// Click on Button Save and Continue
		click(ari.savecont_btn);
		// Assert the toaster "Score Saved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);
		// Heading Label
		Assert.assertEquals(getText(trwp.lbl_reconsider_heading), "Reconsideration Requests");

	}

	/*
	 * To check that the Score modified on the gird
	 */
	@Test(priority = 61)
	public void TCSPR1500761() {

		// New Score received from teacher of Q1+Score received from peer of
		// Q2+Score
		// received from peer of Q3
		Scorefrompeersandteacher = (Integer.parseInt(Q1Scorefromteacher_new)) + (Integer.parseInt(Q2Scorefrompeers))
				+ (Integer.parseInt(Q3Scorefrompeers));
		// Score received from peers/Teachers
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[9]/div/span"),
				Integer.toString(Scorefrompeersandteacher));
		// Total Score=Score Received from Teacher/Peers +Reward Score
		totalscorestud1 = Scorefrompeersandteacher + (Integer.parseInt(Stud1Rewardscore));
		// Score received from peers/Teachers
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[10]/div/span"),
				Integer.toString(totalscorestud1));

		// Reconsideration pending count
		Assert.assertEquals(getText(trwp.reconsiderationPendingCount),
				"Reconsideration Request\n" + "Pending: 1\n" + "Processed: 0");

		// click All results button
		click(trwp.radiobtn_allresults);
		// Assert the All results radio button is selected
		Assert.assertTrue(getAttribute(trwp.radiobtn_allresults, "Class").contains("checked"));
		// Score from peers/Teachers
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[8]/div/span"),
				Integer.toString(Scorefrompeersandteacher));

		// Total Score of student 1
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[9]/div/span"),
				Integer.toString(totalscorestud1));
	}

	/*
	 * To publish the reconsideration request of Student 1 and check the comment
	 * popup
	 */
	@Test(priority = 62)
	public void TCSPR1500762() {

		// click reconsideration request radio button
		click(trwp.radiobtn_reconsider);
		waitThread(1000);
		// click button continue
		click(trwp.btn_continue);
		waitThread(3000);
		click(trwp.btnclose_commentpopup);
		waitThread(3000);

		// Assert the publish button is Enable
		Assert.assertFalse(getAttribute(trwp.btn_publish_recosnider, "class").contains("disabled-btn"),
				"Publish button is Disabled  state");
		Assert.assertEquals(getAttribute(trwp.btn_publish_recosnider, "ptooltip"),
				"Add you response to the reconsideration and publish");
		// Assert the Scores :Score Received from Teacher:
		Assert.assertEquals(getText(ari.scorefromteach_lbl), "Score Received from Teacher: " + Q1Scorefromteacher_new);
		// Wizard status-reconsidered
		Assert.assertTrue(getAttribute(arv.wizardq1, "class").contains("reconsidered"));

		// click publish button
		click(trwp.btn_publish_recosnider);
		waitThread(1000);
		// Assert the popup visible
		Assert.assertTrue(isElementPresent(trwp.reconsiderCommentPopup), "Comment Popup  not visible");
		// click close button-comment popup
		click(trwp.reconsidercommentclosebtn);
		waitThread(4000);
		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(trwp.reconsiderCommentPopup), "Comment Popup   visible");
		// click publish button
		click(trwp.btn_publish_recosnider);
		waitThread(2000);
		// Assert heading
		Assert.assertEquals(getText(trwp.reconsiderCommentPopupheading),
				"Add your response to the reconsideration request");

	}

	/*
	 * To check the details of the Add your response to the reconsideration
	 * request popup
	 */
	public String Teachercomment;

	@Test(priority = 63)
	public void TCSPR1500763() {

		// placeholder
		Assert.assertEquals(getAttribute(trwp.reconReasonField, "placeholder"),
				"Add your comment regarding this reconsideration");
		// To verify the submit button is disabled
		Assert.assertFalse(isEnabled(trwp.reconsidercommentbtnpublish), "Submit button is enabled");

		Teachercomment = "TeacherComment for Student 1_" + generateRandomData();
		// Type reconsideration comment
		type(trwp.commenttextbx, Teachercomment);
		waitThread(4000);
		// To verify the submit button is enabled
		Assert.assertTrue(isEnabled(trwp.reconsidercommentbtnpublish), "Submit button is in disabled state");

	}

	/*
	 * To check the details on the reconsideration request page after publish
	 * the result and check the Answer sheet
	 */
	@Test(priority = 64)
	public void TCSPR1500764() {

		// click on publish button
		click(trwp.reconsidercommentbtnpublish);
		waitThread(2000);
		// Assert the popup visible
		Assert.assertTrue(isElementPresent(trwp.reconsiderpublishpopup),
				"Reconsideration processed publish Popup  not visible");
		// pop up Label
		Assert.assertEquals(getText(trwp.reconsiderpublishpopuplabel), "Result Published Successfully");
		// click back to result button
		click(trwp.reconsiderpublishbacktoresult_btn);
		waitThread(5000);
		// Reconsideration pending count
		Assert.assertEquals(getText(trwp.reconsiderationPendingCount),
				"Reconsideration Request\n" + "Pending: 0\n" + "Processed: 1");
		// Assert the button label View
		Assert.assertEquals(getAttribute(trwp.reconsiderviewbtn, "label"), "View");

	}

	/*
	 * To check the details on the reconsideration request page after publish
	 * the result and check the Answer sheet
	 */
	@Test(priority = 65)
	public void TCSPR1500765() {

		// click view button
		click(trwp.reconsiderviewbtn);
		waitThread(3000);
		// Assert the label
		Assert.assertEquals(getText(trwp.linkteachercomment), "View your response to this reconsideration");
		// Assert the score box not visible
		Assert.assertFalse(isElementPresent(trwp.scoretextbx), "Score box  not visible");

		// Assert the label and check box I approve the Total Scores given by
		// peers not
		// visible
		Assert.assertFalse(isElementPresent(ari.iapprove_lbl),
				"I approve the Total Scores given by peers label present");
		Assert.assertFalse(isElementPresent(ari.score_checkbx), "Check box  present");
		// Wizard status-reconsidered
		Assert.assertTrue(getAttribute(arv.wizardq1, "class").contains("reconsidered"));
		waitThread(2000);
		// Assert the Scores :Score Received from Teacher:
		Assert.assertEquals(getText(ari.scorefromteach_lbl), "Score Received from Teacher: " + Q1Scorefromteacher_new);

		// click View your response to this reconsideration
		click(trwp.linkteachercomment);
		waitThread(2000);
		// Assert the pop up visible
		Assert.assertTrue(isElementPresent(trwp.teacherComment), "Reconsideration teacher comment Popup  not visible");
		// verify teacher comment on the popup
		Assert.assertEquals(getValue(trwp.teacherCommentField), Teachercomment);
		// click close button and check the popup not visible
		click(trwp.teacherCommentFieldclosebtn);
		waitThread(2000);
		Assert.assertFalse(isElementPresent(trwp.teacherComment), "Reconsideration teacher comment Popup   visible");

	}

	/*
	 * To check the Reconsideration details on the Card
	 */
	@Test(priority = 66)
	public void TCSPR1500766() {

		// Click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(6000);
		// search assessment
		type(st1.assess_searchbx, AssessmentName);
		driver.findElement(By.id("searchAssessments")).sendKeys("       ");

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");
		waitThread(3000);
		// Assert the Reconsideration count
		Assert.assertEquals(getText(trwp.teachercard_reconsidercount),
				"Reconsideration requested: 0 Pending 1 Processed");

	}

	/*
	 * To check the reconsideration tab after reconsideration processing
	 */
	@Test(priority = 67)
	public void TCSPR1500767() {
		// Click on Reconsideration Requests Tab
		click(trwp.reconsidertab);
		waitThread(4000);
		// Verify the tab is selected
		Assert.assertEquals(getAttribute(trwp.tab_reconsiderationrequest, "aria-selected"), "true");

		// Search the Assessment Name
		// type(trwp.searchbox, AssessmentName);
		waitThread(3000);
		// Assert the Assessment name not visible on the page
		Assert.assertTrue(getText(trwp.gridemptylabel).contains("No Assessment(s) Found."), "Assessment Name visible");

	}

	@Test(priority = 68)
	public void TCSPR1500768() {

		// Perform Teacher Logout
		cm.Logout();

		// login as Student 1
		waitThread(2000);
		lg.login1(Emailstudent1, cm.Password);

		// Search the Assessment Name
		waitThread(5000);
		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		click(st1.stud_searchbx);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys("       ");
		waitThread(3000);

		// Assert the view result button visible
		Assert.assertTrue(isElementPresent(rwbt.viewresultbtn), "View result button not visible");
		Assert.assertEquals(getText(rwbt.viewresultlbl), "View Result");
		// Assert the Result status is Reconsideration Processed
		Assert.assertEquals(getText(trwp.Cardlbl_reconsideration), "Reconsideration Processed");
	}

	/*
	 * To perform view result and check the teacher response for reconsideration
	 */
	@Test(priority = 69)
	public void TCSPR1500769() {

		// click on view result button
		click(rwbt.viewresultbtn);
		waitThread(3000);

		// Assert Result pop up visible
		Assert.assertTrue(isElementPresent(rwbt.resultpopup), "Result Popup  not visible");

		// Assert the View Teacher Response to Reconsideration Request button is
		// enabled
		Assert.assertFalse(getAttribute(trwp.viewteachercomment, "class").contains("disabled"),
				"Teacher Response to Reconsideration Request button is disabled");
		// click Teacher Response to Reconsideration Request button
		click(trwp.viewteachercomment);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(trwp.teachercommentfield), "Teacher comment  Popup  not visible");
		// heading Teacher's response to Reconsideration Request
		Assert.assertEquals(getText(trwp.headingcomment), "Teacher's response to Reconsideration Request");

		Assert.assertEquals(getValue(trwp.teachercommentfield), Teachercomment);
		click(trwp.teachercommentclosebtn);
		waitThread(2000);
		Assert.assertFalse(isElementPresent(trwp.teachercommentfield), "Teacher comment  Popup   visible");

	}

	/*
	 * To check the Scores and labels on the result popup
	 */
	@Test(priority = 70)
	public void TCSPR1500770() {

		waitThread(2000);
		// Score Received from Peer Reviewers/Teacher
		Assert.assertEquals(getText(trwp.lbl_peerscore), "Score Received from Peer Reviewers/Teacher\n"
				+ Integer.toString(Scorefrompeersandteacher) + "/" + TotalTestPoints);

		// Total Score
		Assert.assertEquals(getText(trwp.lbltotalscore),
				"Total Score\n" + "(Score Received from Peer Reviewers/Teacher + Score for Peer Review Done)\n"
						+ Integer.toString(totalscorestud1) + "/" + maxscoreposs1);
		// *Assert the Scores Received from Teacher of Q1
		Assert.assertEquals(trwp.getdatafromgridstudent("1",
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[7]/div/span"),
				Q1Scorefromteacher_new);
		// *Assert the status of Q1 is Teacher Reconsidered
		Assert.assertEquals(trwp.getdatafromgridstudent("1",
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[9]/div"),
				"Teacher Reconsidered");

	}

	/*
	 * To check the Scores and labels on the result pop up
	 */
	@Test(priority = 71)
	public void TCSPR1500771() {

		// Click on Q1 view button
		click(trwp.Q1viewbtn);
		waitThread(3000);
		// *Assert the Label "Teacher Reconsidered "
		Assert.assertEquals(getText(trwp.answerwindowreconsoderstatus), "Teacher Reconsidered");
		waitThread(3000);
		// Assert the Score Received from Teacher: value same as teacher page
		Assert.assertEquals(getText(sasb.scorefromteach), "Score Received from Teacher: " + Q1Scorefromteacher_new);
		int finalscoreQ1 = Integer.parseInt(Q1rewardscorestud) + Integer.parseInt(Q1Scorefromteacher_new);
		// Assert the Final Score of Q1 is Scores Received from Teacher+Reward
		// Score of
		// Q1
		Assert.assertEquals(getText(sasb.final_scrorelbl), "Final Score: " + Integer.toString(finalscoreQ1));
		// Assert the Total Score of the Answer sheet
		Assert.assertEquals(getText(sasb.totalscr_lbl),
				"Total Score " + Integer.toString(totalscorestud1) + "/" + maxscoreposs1);

	}

	/*
	 * To perform Delete student1 Account functionality
	 */
	//@Test(priority = 72)
	public void DeleteStudent1() {
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
	//@Test(priority = 73)
	public void DeleteTeacher() {
		// login using deleted account credentials
		rs.login_Student(Emailteacher, password);
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
	 * To perform Delete student2 Account functionality
	 */
	//@Test(priority = 74)
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
	 * To perform Delete student1 Account functionality
	 */
	//@Test(priority = 75)
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
