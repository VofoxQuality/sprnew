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
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import NewAssessmentOfTeacherPage.TeacherResultSectionPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowWizardPage;
import ResultWindowforIndividualStudent.Page.StudentAnswerSheetBasicsPage;
import ResultWindowforIndividualStudent.Page.StudentResultWindowBasicsPage;
import ResultWindowofIndividualTeacherPage.TeacherAutomaticResultPeerreviewIncompletePage;
import ResultWindowofIndividualTeacherPage.TeacherAutomaticResultreviewcompletePage;
import ResultWindowofIndividualTeacherPage.TeacherManualReconsiderationEnabledreviewcompletePage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import TestWindowOfIndividualStudent.AssessmentSubmitAndStatusPopUpPage;
import TestWindowOfIndividualStudent.ModifyWizardSectionPage;
import TestWindowOfIndividualStudent.TestWindowWizardPage;

public class TeacherManualReconsiderationEnabledReviewIncompleteTest extends basePage {

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
	TeacherPeerReviewSectionPage tp = new TeacherPeerReviewSectionPage();
	StudentTestSectionPage st1 = new StudentTestSectionPage();
	ModifyWizardSectionPage ms = new ModifyWizardSectionPage();
	AssessmentSubmitAndStatusPopUpPage asp = new AssessmentSubmitAndStatusPopUpPage();
	TestWindowWizardPage tsw = new TestWindowWizardPage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	PeerReviewWindowPage prp = new PeerReviewWindowPage();
	StudentResultSectionPage srs = new StudentResultSectionPage();
	StudentPeerReviewPage sp1 = new StudentPeerReviewPage();
	StudentResultWindowBasicsPage rwbt = new StudentResultWindowBasicsPage();
	StudentAnswerSheetBasicsPage sasb = new StudentAnswerSheetBasicsPage();
	TeacherAutomaticResultreviewcompletePage arv = new TeacherAutomaticResultreviewcompletePage();
	TeacherAutomaticResultPeerreviewIncompletePage ari = new TeacherAutomaticResultPeerreviewIncompletePage();
	TeacherManualReconsiderationEnabledreviewcompletePage mre = new TeacherManualReconsiderationEnabledreviewcompletePage();
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
	public void TCSPR1500602() {
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
	public void TCSPR1500603() {

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
	public void TCSPR1500604() {

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
	public void TCSPR1500605() {

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
	public void TCSPR1500606() {

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

		waitThread(2000);
	}

	/*
	 * To perform the save and next functionality from peer review page and
	 * verify the schedule page details
	 * 
	 */
	public String recon_day;
	public String recon_time;

	@Test(priority = 7)
	public void TCSPR1500607() {

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
		ScrollTo_Location(sb1.teacherwill_radio);
		// Click on Teacher will manually publish the result radio button
		click(sb1.teacherwill_radio);

		waitThread(3000);
		// Assert the radio button is selected
		Assert.assertTrue(getAttribute(sb1.teachwill_radio_select, "class").contains("checked"));

		// Click Allow students to raise a Reconsideration Request check box
		click(sb1.allowreconsiderchkbx);

		waitThread(1000);
		// Assert the check box is checked
		// Assert.assertTrue(getAttribute(sb1.allowreconsiderchkbx,
		// "class").contains("highlight"));

		// Assert the Days count
		recon_day = getValue(sb1.day_drop_txtbx);
		Assert.assertEquals(recon_day, "0");

		// Assert the Time
		recon_time = getValue(sb1.lasttime_select_bx);

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
	public void TCSPR1500608() {

		quest_count = getText(sq.total_questcount);
		TotalTestPoints = getText(sq.total_testscore);

		// Assert the Total Questions: 3
		Assert.assertEquals(getText(sb.valuetotalQuestion), quest_count);

		// Assert the Total Test Points: 60
		Assert.assertEquals(getText(sb.lblTotaltestpoints), "Total Test Points: " + TotalTestPoints);

		Totalpeerreviewpoint = getText(sq.total_peereviewvalue);
		maxscoreposs1 = getText(sq.max_scorepos_count);
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
	 * assessment visible on the Current tab
	 * 
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 9)
	public void TCSPR1500609() {

		waitThread(2000);
		// Click Back to Menu
		click(tts.back_to_menubutton);

		waitThread(6000);

		// Assert the text "Assessments "
		Assert.assertEquals(getText(ba.lbl_assessment), "Assessments");

		click(st1.assess_searchbx);
		// search the assessment
		type(st1.assess_searchbx, AssessmentName);

		// Assert the newly published card visible on the current assessment
		// page
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");

		// Assert the Label "You need to manually publish the result"
		Assert.assertEquals(getText(rd.manualpublishcard_txt), "You need to manually publish the result");

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
	public void TCSPR1500610() throws InterruptedException {
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
		TimeUnit.SECONDS.sleep(50);
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
	public void TCSPR1500611() {

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

	@Test(priority = 12)
	public void TCSPR1500612() throws InterruptedException {

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

		TimeUnit.SECONDS.sleep(5);
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
	public void TCSPR1500613() {

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
	public void TCSPR1500614() {

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
	public void TCSPR1500615() {

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
	public String testcount;

	@Test(priority = 16)
	public void TCSPR1500616() throws InterruptedException {
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

		TimeUnit.SECONDS.sleep(5);

		// Search Assessment
		Doubleclick(st1.stud_searchbx);
		waitThread(2000);

		// Read the Test attended count
		testcount = getText(st1.quest_count);

		// To perform logout functionality on the Student 2 profile
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * Login as Teacher and Reschedule the Test due and peer review start date
	 * To perform Login functionality of student 1 profile and check the
	 * Assessment card
	 */
	@Test(priority = 17)
	public void TCSPR1500617() throws InterruptedException {

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
		// Login to Student3
		lg.login1(Emailstudent3, cm.Password);

		waitThread(6000);
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
	@Test(priority = 18)
	public void TCSPR1500618() {

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
	 * To perform review for Question 3 and submit the Review
	 */
	@Test(priority = 19)
	public void TCSPR1500619() {

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

	}

	/*
	 * To perform logout functionality on the Student 1 profile
	 */
	@Test(priority = 20)
	public void TCSPR1500620() {

		// logout functionality
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * Perform teacher login and reschedule the peer review and result date
	 */
	@Test(priority = 21)
	public void TCSPR1500621() throws InterruptedException {
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
		driver.findElement(By.id("searchAssessments")).sendKeys("   ");
		TimeUnit.MINUTES.sleep(3);

		waitThread(3000);
		// Assert label result upcoming
		// Assert.assertEquals(getText(tts.time_status), "Result Upcoming");

	}

	/*
	 * To verify the result section Labels
	 */
	@Test(priority = 22)
	public void TCSPR1500622() {
		ScrollTo_Location(arv.viewresult_teachcard);
		// Assert the Evaluate Answers Button is Enabled
		Assert.assertTrue(isEnabled(arv.viewresult_teachcard), "Evaluate Answers button is disabled");

		// Assert label result upcoming
		// Assert.assertEquals(getText(tts.time_status), "Result Upcoming");

		// Assert the Result status is pending
		Assert.assertEquals(getText(tr.resultsts_lbl), "Pending");

		// Assert text "You need to manually publish the result"
		Assert.assertEquals(getText(rd.manualpublishcard_txt), "You need to manually publish the result");

		// Assert text Last Date for Reconsideration Request: 0 days from Result
		// Publish, Time
		Assert.assertEquals(getText(mre.recontxt_card),
				"Last Date for Reconsideration Request: 0 days from Result Publish, "
						+ cm.removeLeadingZeroes(recon_time));

		// Assert the Button and Button label Evaluate Answers
		Assert.assertTrue(isElementPresent(arv.viewresult_teachcard), "Evaluate Answers button not present");
		Assert.assertEquals(getText(arv.viewresult_teachcard), "Evaluate Answers");

	}

	/*
	 * Click on the Evaluate Answers button and check the Labels on the pages
	 */
	@Test(priority = 23)
	public void TCSPR1500623() {
		// Click on Evaluate Answer Button
		click(arv.viewresult_teachcard);

		waitThread(6000);
		// Assert The Heading Label Evaluate answer sheets and Publish result
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Evaluate answer sheets and Publish result");

		// Assert the Label :No of Answer Sheets Pending for Evaluation 1 Answer
		// Sheets
		Assert.assertEquals(getText(arv.studenttest_clsize_lbl),
				"No of Answer Sheets Pending for Evaluation\n" + "1 Answer Sheets");

		// Assert the Total Peer Review Points
		Assert.assertEquals(getText(arv.tot_peerpoints_lbl), "Total Peer Review Points\n" + Totalpeerreviewpoint);

	}

	/*
	 * To check the reconsideration details on the page
	 */
	@Test(priority = 24)
	public void TCSPR1500624() {
		// Assert the Label "The student can raise reconsideration request till"
		Assert.assertTrue(getText(mre.reconstext).contains("The student can raise reconsideration request till:"));

		// Assert the Days and Time same as schedule page,0 days from Result
		// publish,
		// Time
		Assert.assertTrue(getText(mre.reconsdaytime_text)
				.contains(recon_day + " days from Result publish, " + cm.removeLeadingZeroes(recon_time)));

		// Assert the Button change
		Assert.assertEquals(getText(mre.change_btn), "Change");

		// Assert the Publish Button is disabled
		// Assert.assertFalse(isEnabled(ari.publish_btn), "publish button is
		// enabled");

	}

	/*
	 * To check the Student 1 details on the Result window
	 */
	@Test(priority = 25)
	public void TCSPR1500625() {
		// Assert the Reward Point is 0
		Assert.assertEquals(getText(ari.rewarescore_stud1), "0");

		// Assert the Status Label "Evaluation Pending"
		Assert.assertEquals(getText(ari.status_stud1), "Evaluation Pending");

		// Assert the Button Evaluate
		Assert.assertEquals(getText(ari.eval_btn), "Evaluate");
	}

	/*
	 * To check the Student 2 details on the Result window
	 */
	public String tot1;

	@Test(priority = 26)
	public void TCSPR1500626() {
		// Assert the Reward Point is 0
		Assert.assertEquals(getText(ari.rewarescore_stud2), "0");

		// Assert the Status Label "Peer Review Completed"
		Assert.assertEquals(getText(ari.status_stud2), "Peer Review Completed");

		// Assert the Button View/Modify Score
		Assert.assertEquals(getText(ari.modifybtn_stud2), "View/Modify Score");

		tot1 = getText(ari.totscore_stud1);
	}

	/*
	 * To check the Student 3 details on the Result window
	 */
	@Test(priority = 27)
	public void TCSPR1500627() {

		// Assert the Reward Point is : 60(Check it is same as Total Peer review
		// points)
		Assert.assertEquals(getText(ari.rewarescore_stud3), Totalpeerreviewpoint);

		// Assert the Score received from peers is empty
		Assert.assertEquals(getText(ari.scorefrompeer_stud3), "--");

		// Assert the Status Label "Unattended"
		Assert.assertEquals(getText(ari.status_stud3), "Unattended");

	}

	/*
	 * To check the Student 3 details on the Result window
	 */
	@Test(priority = 28)
	public void TCSPR1500628()

	{
		// Assert the Question Answer is "Unattended"
		Assert.assertEquals(getText(ari.stud2questans_count), "Unattended");

		// Assert the Answer sheet reviewed by student names disabled
		// Assert.assertFalse(isEnabled(mre.stud3_anssheetname), "Student name
		// is
		// enabled");

		// Assert the Total score same as reward Score
		Assert.assertEquals(getText(ari.totscore_stud3), Totalpeerreviewpoint);

		// Assert the Answer sheet Label "Answer Sheet"
		Assert.assertEquals(getText(ari.lblansrsheet), "Answer\n" + "Sheet");

	}

	/*
	 * To check the Evaluate button functionality and check the Evaluate comment
	 * box functionality[Student 1]
	 */
	@Test(priority = 29)
	public void TCSPR1500629() {
		// Click on Evaluate Button
		click(ari.eval_btn);
		waitThread(3000);
		// Assert the Evaluate popup visible
		Assert.assertTrue(isElementPresent(ari.sys_popup), "popup not present");

		// Assert the Label "Evaluate"
		Assert.assertEquals(getText(ari.sys_popup_lbl), "Evaluate");

		// Assert the text "Question No 1,2,3 has not been Peer Reviewed"
		Assert.assertEquals(getText(ari.sys_popup_txt), "Question No 1,2,3 has not been Peer Reviewed");

		waitThread(2000);
		// Click on Close button
		click(ari.sys_popup_clos_btn);

		// Assert the Evaluate comment popup Not visible
		waitThread(2000);
		Assert.assertFalse(isElementPresent(ari.sys_popup), "popup present");

		waitThread(4000);
		// Assert the Assessment Name,Course name,Course ID,Student Name
		Assert.assertEquals(getText(arv.result_page_assess_name), AssessmentName);

		// Assert the Total Score same as in the result window
		Assert.assertEquals(getText(ari.totscorevalue), tot1 + "/" + maxscoreposs1);

	}

	/*
	 * To Evaluate the Student 1 Answer sheet
	 */
	public String S1 = "2";
	public String S2 = "3";
	public String S3 = "4";
	public String total;

	@Test(priority = 30)
	public void TCSPR1500630() {
		// Type Score for Question 1
		click(ari.addscore_txtbx);
		type(ari.addscore_txtbx, S1);

		waitThread(2000);
		// Assert the Question number 1,2,3 Shows orange color
		Assert.assertTrue(getAttribute(arv.wizardq1, "Class").contains("orange"));
		Assert.assertTrue(getAttribute(arv.wizardq2, "Class").contains("orange"));
		Assert.assertTrue(getAttribute(arv.wizardq3, "Class").contains("orange"));

		waitThread(1000);
		// Click on Wizard 2
		click(arv.wizardq2);

		// Assert the Toaster "Score Saved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);

		// Assert the wizard 2 is selected
		waitThread(2000);
		Assert.assertTrue(getAttribute(arv.wizardq2, "class").contains("p-highlight"));

		// Type Score for Question 2
		click(ari.addscore_txtbx);
		type(ari.addscore_txtbx, S2);

		// Click on Wizard 3
		click(arv.wizardq3);

		// Assert the Toaster "Score Saved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);

		// Assert the wizard 3 is selected
		waitThread(2000);
		Assert.assertTrue(getAttribute(arv.wizardq3, "class").contains("p-highlight"));

		// Type Score for Question 3
		click(ari.addscore_txtbx);
		type(ari.addscore_txtbx, S3);

		// Click On Save button
		waitThread(2000);
		click(ari.save_btn);

		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);

		// Assert the Total Score is Sum of Score for Q1+Score for Q2+Score for
		// Q3
		int tot = cm.StringtoInt(S1) + cm.StringtoInt(S2) + cm.StringtoInt(S3);
		total = cm.InttoString(tot);
		Assert.assertEquals(getText(ari.totscorevalue), total + "/" + maxscoreposs1);
	}

	/*
	 * To Approve the Student 2 answer sheet To Exit from the Teacher Answer
	 * window and check the Score details on student 1
	 */
	@Test(priority = 31)
	public void TCSPR1500631() {
		waitThread(1000);
		// Click on Exit button
		click(arv.exit_btn);

		waitThread(3000);
		// Assert the Exit popup visible
		Assert.assertTrue(isElementPresent(ari.exit_popup), "popup not present");

		// click view next answer sheet
		click(ari.viewnextbtn_dis);

		// Assert the student 2 Name
		waitThread(3000);
		Assert.assertTrue(getText(arv.stud_name_resultwindow).contains(Student2name));

		// Click on I approve the Total Scores given by peers checkbox
		click(ari.score_checkbx);

		// Click on Exit Button
		click(arv.exit_btn);
		waitThread(2000);

		// Click on Yes button
		Doubleclick(ari.savecont_btn);

		// Click on Back to Result button
		waitThread(2000);
		click(ari.score_back_resltbtn);

		waitThread(3000);
		// Assert the Student 2 Label is Peer Scores approved
		Assert.assertEquals(getText(ari.status_stud2), "Peer Scores Approved");

		// Assert Label "0 Answer Sheets"
		Assert.assertEquals(getText(arv.studenttest_clsize_lbl),
				"No of Answer Sheets Pending for Evaluation\n" + "0 Answer Sheets");
	}

	/*
	 * To check the Score details on student 1
	 */
	@Test(priority = 32)
	public void TCSPR1500632() {

		// Assert the Score Received from Teacher/Peers is Sum of Score for
		// Q1+Score for
		// Q2+Score for Q3
		waitThread(3000);
		Assert.assertEquals(getText(ari.scorerec_fromteach_stud1), total);

		// Assert the Total Score is Sum of Score for Q1+Score for Q2+Score for
		// Q3+Reward Score
		waitThread(2000);
		tot1 = getText(ari.totscore_stud1);
		String Reward1 = getText(ari.rewarescore_stud1);
		int totalscore1 = cm.StringtoInt(Reward1) + cm.StringtoInt(total);
		Assert.assertEquals(tot1, cm.InttoString(totalscore1));

		// Assert the Status "Evaluation Completed"
		waitThread(2000);
		Assert.assertEquals(getText(ari.status_stud1), "Evaluation Completed");

	}

	/*
	 * To check the reconsideration days and time
	 */
	@Test(priority = 33)
	public void TCSPR1500633() {

		// Assert the Label "The student can raise reconsideration request till"
		// not
		// visible
		Assert.assertFalse(isElementPresent(mre.reconstext),
				"The student can raise reconsideration request label visible");

		// Assert the button change not visible
		Assert.assertFalse(isElementPresent(mre.change_btn), "Change button is visible");

		// Assert the Days and Time same as schedule page 0 days from Result
		// publish,
		// Time not visible
		Assert.assertFalse(isElementPresent(mre.reconsdaytime_text), "the Days and Time label visible ");

	}

	/*
	 * To perform publish the result functionality on the teacher login
	 */
	@Test(priority = 34)
	public void TCSPR1500634() {

		// Click on Publish button
		click(ari.publish_btn);

		waitThread(2000);
		// Assert the publish popup visible
		Assert.assertTrue(isElementPresent(ari.publish_popup), "popup not present");

		// Assert the Label "Result Published Successfully"
		Assert.assertEquals(getText(ari.pub_popup_txt), "Result Published Successfully");

		// Assert the Label "Reconsideration will be: Date- Day at Time" not
		// visible
		Assert.assertFalse(isElementPresent(mre.recons_txt_publishpopup),
				"Last date for raising Reconsideration will be: label visible");

		// Assert the button Back to Results
		Assert.assertTrue(isDisplayed(ari.publish_backtores_btn), "button not present");

		waitThread(1000);
		// Click on Back to Result Button
		click(ari.publish_backtores_btn);

		waitThread(3000);
		// Assert the Heading Final result
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Final Result");

		// Assert the Label Reconsideration Request Active not visible on the
		// Page
		Assert.assertFalse(isElementPresent(mre.final_recons_txt), "Reconsideration Request Active for label visible ");

		// Click on Back button
		click(arv.back_btn);
		waitThread(5000);

		// Assert the Current Tab is selected
		Assert.assertEquals(getAttribute(arv.cuurent_assm_tab, "aria-selected"), "true");

	}

	/*
	 * To check the Result details on the Card
	 */
	public String resultdate;
	public String resulttime;

	@Test(priority = 35)
	public void TCSPR1500635() {

		// Search the Assessment Name
		click(st1.assess_searchbx);
		type(st1.assess_searchbx, AssessmentName);
		waitThread(3000);

		// Assert Label "Result Available"
		Assert.assertTrue(getText(tp.timer).contains("Result Available"), "Text not visible on card");

		// Assert the Result section labels:
		// -Result Published Date: Date and Time
		cm.datetimesplitmethod();
		resultdate = cm.getdates(cm.resultdate);
		resulttime = cm.resultime;

		// -Last Date for raising Reconsideration Request:Date and Time not
		// visible
		Assert.assertFalse(isElementPresent(tr.lastdate_lbl),
				"Last Date for raising Reconsideration Request label visible");

		// Perform Teacher Logout
		waitThread(3000);
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * Login As student 1 and check that reconsideration option not visible on
	 * the Card and result window
	 */
	@Test(priority = 36)
	public void TCSPR1500636() {

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

		// Assert the reconsideration date not visible on the card
		Assert.assertFalse(isElementPresent(tr.lastdatetime_lbl), "reconsideration date time visible");

	}

	/*
	 * To check that reconsideration option not visible on the student 1 result
	 * window
	 */
	@Test(priority = 37)
	public void TCSPR1500637() {

		// click on view result button
		click(rwbt.viewresultbtn);
		waitThread(3000);

		// Assert the heading Result
		Assert.assertEquals(getText(rwbt.label_Result_1), "Result");

		// Assert the reconsideration Button not visible on the Page
		Assert.assertFalse(isElementPresent(mre.recons_btn_stud), "Raise Reconsideration Request button visible");

		// Assert the Reconsideration Timer not visible on the page
		Assert.assertFalse(isElementPresent(mre.result_stud_recons_txt),
				"Time left for raising Reconsideration Request visible ");

		// Click on Q1 view
		click(ari.view_btn_q1);

		// Assert the Reconsideration Timer not visible on the page
		waitThread(2000);

	}

	/*
	 * To perform logout functionality on the Student 1 profile
	 */
	@Test(priority = 38)
	public void TCSPR1500638() {

		// Perform logout
		cm.Logout();

		// Assert heading Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * Login As student 2 and check the Details of Result window
	 */
	@Test(priority = 39)
	public void TCSPR1500639() {

		// login as Student 2
		waitThread(2000);
		lg.login1(Emailstudent2, cm.Password);

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

		// Assert the reconsideration date not visible on the card
		Assert.assertFalse(isElementPresent(tr.lastdatetime_lbl), "reconsideration date time visible");

	}

	/*
	 * To check the Details of Result window
	 */
	@Test(priority = 40)
	public void TCSPR1500640() {

		// Assert the View result button
		Assert.assertTrue(isElementPresent(rwbt.viewresultbtn), "View result button not present");

		// Click on View Result Button
		click(rwbt.viewresultbtn);
		waitThread(3000);

		// Assert Result popup visible
		Assert.assertTrue(isElementPresent(rwbt.resultpopup), "Result Popup  not visible");

		// Assert the heading Result
		Assert.assertEquals(getText(rwbt.label_Result_1), "Result");

		// Assert the reconsideration Button not visible on the Page
		Assert.assertFalse(isElementPresent(mre.recons_btn_stud), "Raise Reconsideration Request button visible");

		// Assert the Reconsideration Timer not visible on the page
		Assert.assertFalse(isElementPresent(mre.result_stud_recons_txt),
				"Time left for raising Reconsideration Request visible ");

		// Close the Result popup
		waitThread(1000);
		click(ari.result_popup_close);

		// Assert the result popup not visible
		waitThread(2000);
		Assert.assertFalse(isElementPresent(rwbt.resultpopup), "Result Popup visible");

		// Perform logout
		waitThread(1000);
		cm.Logout();

	}

	/*
	 * Login As student 3 and check that reconsideration option not visible on
	 * the Card and result window
	 */
	@Test(priority = 41)
	public void TCSPR1500641() {

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

		// Assert the Result Published Date: and time
		cm.studentresultdatetimemethod();
		String resultdatestud = cm.getdates(cm.resultdate_stud);
		String resulttimestud = cm.resultime_stud;

		Assert.assertEquals(resultdatestud, resultdate);
		Assert.assertEquals(resulttimestud, resulttime);

		// Assert the reconsideration date not visible on the card
		Assert.assertFalse(isElementPresent(tr.lastdatetime_lbl), "reconsideration date time visible");

	}

	/*
	 * To check that reconsideration option not visible on the student 3 result
	 * window
	 */
	@Test(priority = 42)
	public void TCSPR1500642() {

		// Click on View Result Button
		click(rwbt.viewresultbtn);
		waitThread(3000);

		// Assert the heading Result
		Assert.assertEquals(getText(rwbt.label_Result_1), "Result");

		// Assert the reconsideration Button not visible on the Page
		Assert.assertFalse(isElementPresent(mre.recons_btn_stud), "Raise Reconsideration Request button visible");

		// Assert the Reconsideration Timer not visible on the page
		Assert.assertFalse(isElementPresent(mre.result_stud_recons_txt),
				"Time left for raising Reconsideration Request visible ");

		// Close the Result popup
		waitThread(1000);
		click(ari.result_popup_close);

		// Assert the result popup not visible
		waitThread(2000);
		Assert.assertFalse(isElementPresent(rwbt.resultpopup), "Result Popup  visible");

	}

	/*
	 * To perform Delete student3 Account functionality
	 */
	@Test(priority = 44)
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
	 * To perform Delete student2 Account functionality
	 */
	@Test(priority = 45)
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
	@Test(priority = 46)
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
	 * To perform Delete Teacher Account functionality
	 */
	@Test(priority = 47)
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
