package ResultWindowofIndividualTeacherTest;

import static org.testng.Assert.assertTrue;

import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
import ResultWindowofIndividualTeacherPage.TeacherManualResultPeerreviewcompletePage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import TestWindowOfIndividualStudent.AssessmentSubmitAndStatusPopUpPage;
import TestWindowOfIndividualStudent.ModifyWizardSectionPage;
import TestWindowOfIndividualStudent.TestWindowWizardPage;

public class TeacherManualReconsiderationEnabledreviewcompleteTest extends basePage {

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
	public void TCSPR1500503() {

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
	public void TCSPR1500504() {

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
	public void TCSPR1500505() {

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
	public String studcount = "2";
	/*
	 * To verify the details on the peer review page
	 */
	public String peerstudname1;
	public String peerstudname2;

	@Test(priority = 6)
	public void TCSPR1500506() {

		waitThread(4000);
		// Enter peer review Reward score
		type(prw.peer_reward_scorebx, RewardPercent);

		waitThread(4000);
		// Assert the text::Total Students : Assert the total student count
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : " + studcount);

		// Assert the 3 student names
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Student1name.trim());
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Student2name.trim());

	}

	/*
	 * To perform the save and next functionality from peer review page and
	 * verify the schedule page details
	 * 
	 */
	public String recon_day;
	public String recon_time;

	@Test(priority = 7)
	public void TCSPR1500507() {

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
	public void TCSPR1500508() {

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
	public void TCSPR1500509() throws InterruptedException {

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
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(50);
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
	public void TCSPR1500510() {
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
	public void TCSPR1500511() {

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
	public void TCSPR1500512() throws InterruptedException {

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

		TimeUnit.SECONDS.sleep(2);
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
	public void TCSPR1500513() {

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
	public void TCSPR1500514() {

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
	public void TCSPR1500515() {

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
	public void TCSPR1500516() throws InterruptedException {
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
	public void TCSPR1500517() throws InterruptedException {

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

	}

	/*
	 * To perform Login functionality of student 1 profile and check the
	 * Assessment card
	 */
	@Test(priority = 18)
	public void TCSPR1500518() throws InterruptedException {
		waitThread(2000);
		// Login to Student1
		lg.login1(Emailstudent1, cm.Password);

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
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(50);

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
	@Test(priority = 19)
	public void TCSPR1500519() {

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
	@Test(priority = 20)
	public void TCSPR1500520() {

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
	@Test(priority = 21)
	public void TCSPR1500521() {

		// logout functionality
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * To perform Login functionality of student 2 profile and check the
	 * Assessment card
	 */
	@Test(priority = 22)
	public void TCSPR1500522() {

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
	 * To perform review for Question 1 and Question 2
	 */
	@Test(priority = 23)
	public void TCSPR1500523() {

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
	 * functionality on the Student 3 profile
	 */
	@Test(priority = 24)
	public void TCSPR1500524() throws InterruptedException {

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
	 * Perform teacher login and reschedule the peer review date and time
	 */
	@Test(priority = 25)
	public void TCSPR1500525() throws InterruptedException {

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
		waitThread(3000);

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
	@Test(enabled = false)
	public void TCSPR1500526() {

		// Assert the View result Button is Enabled
		Assert.assertTrue(isEnabled(arv.viewresult_teachcard), "View result button is disabled");

		// Assert label result upcoming
		// Assert.assertEquals(getText(tts.time_status), "Result Upcoming");

		// Assert the Result status is pending
		// Assert.assertEquals(getText(tr.resultsts_lbl), "Pending");
		ScrollTo_Location(rd.manualpublishcard_txt);
		ScrollTo_Location(mre.recons_day_timetxt);
		// Assert text "You need to manually publish the result"
		Assert.assertEquals(getText(rd.manualpublishcard_txt), "You need to manually publish the result");

		waitThread(2000);
		// Assert text Last Date for Reconsideration Request: 0 days from Result
		// Publish, Time
		Assert.assertEquals(getText(mre.recons_day_timetxt),
				"Last Date for Reconsideration Request: 0 days from Result Publish, "
						+ cm.removeLeadingZeroes(recon_time));

		// Assert the Button and Button label Evaluate Answers
		Assert.assertTrue(isElementPresent(arv.viewresult_teachcard), "Evaluate Answers button not present");
		Assert.assertEquals(getText(arv.viewresult_teachcard), "Evaluate Answers");

	}

	/*
	 * Perform Logout Functionality on the Teacher Account and Login the Student
	 * Page and check the Card result status
	 */
	@Test(priority = 27)
	public void TCSPR1500527() throws InterruptedException {

		// To perform logout functionality from Teacher account
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// Perform login by Student1
		lg.login1(Emailstudent1, cm.Password);
		waitThread(4000);

		TimeUnit.SECONDS.sleep(5);

		// verify heading label current Assessments
		Assert.assertEquals(getText(QP.current_assesslabel), "Current Assessments");

		waitThread(5000);
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
	@Test(priority = 28)
	public void TCSPR1500528() {

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
		// Assert The Heading Label Peer Review Results
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Peer Review Results");

		// Assert the Back Button
		Assert.assertEquals(getText(arv.back_btn), "Back");

		// Click the Back Button
		click(arv.back_btn);

		waitThread(3000);
		// Assert the Current Tab is selected
		Assert.assertTrue(isDisplayed(arv.current_tab), "Current tab not present");

		// search newly created assessment
		click(st1.assess_searchbx);
		type(st1.assess_searchbx, AssessmentName);

		waitThread(3000);
		// Click on Evaluate Answer Button
		click(arv.viewresult_teachcard);

		// Assert the student 1 Status "Peer Review Completed"
		Assert.assertEquals(getText(ari.status_stud1), "Peer Review Completed");

		// Assert the student 2 Status "Peer Review Completed"
		Assert.assertEquals(getText(ari.status_stud2), "Peer Review Completed");

	}

	/*
	 * To check the reconsideration details on the page
	 */
	@Test(priority = 29)
	public void TCSPR1500529() {

		// Assert the Label "The student can raise reconsideration request till"
		Assert.assertTrue(getText(mre.reconstext).contains("The student can raise reconsideration request till:"));

		// Assert the Days and Time same as schedule page,0 days from Result
		// publish,
		// Time
		Assert.assertTrue(getText(mre.reconsdaytime_text)
				.contains(recon_day + " days from Result publish, " + cm.removeLeadingZeroes(recon_time)));

		// Assert the Button change
		Assert.assertEquals(getText(mre.change_btn), "Change");

		// Assert the Publish Button Is Enabled
		Assert.assertTrue(isEnabled(ari.publish_btn), "publish button is disabled");

	}

	/*
	 * To Approve the Student 2 Answer sheets and check that the reconsideration
	 * section not shows on the page
	 */
	@Test(priority = 30)
	public void TCSPR1500530() {

		// Click on Student 2 view/Modify button
		click(ari.modifybtn_stud2);
		waitThread(3000);

		// Assert the Label "I approve the Total Scores given by peers"
		Assert.assertEquals(getText(ari.iapprove_lbl), "I approve the Total Scores given by peers");

		// Click on I approve the Total Scores given by peers check box
		click(ari.score_checkbx);

		// Assert the checkbox is checked
		waitThread(1000);
		Assert.assertTrue(getAttribute(ari.score_checkbx_check, "class").contains("checked"));

		// Click on Exit Button
		click(arv.exit_btn);
		waitThread(2000);

		// Assert the Approve Total Score popup
		Assert.assertTrue(isDisplayed(mre.appr_scorepopup), "popup not visible");

		// Click Yes button
		click(ari.savecont_btn);

		waitThread(1000);
		// Click on Back to results button
		click(ari.score_back_resltbtn);

		waitThread(3000);
		// Assert the student 2 Status "Peer Scores Approved"
		Assert.assertEquals(getText(ari.status_stud2), "Peer Scores Approved");

	}

	/*
	 * To Modify the Student 1 Answer sheets and check that the reconsideration
	 * section not shows on the page
	 */
	@Test(priority = 31)
	public void TCSPR1500531() {

		// Click on Student 1 view/Modify button
		click(ari.modifybtn_stud1);
		waitThread(5000);

		// Assert the Label "I approve the Total Scores given by peers"
		Assert.assertEquals(getText(ari.iapprove_lbl), "I approve the Total Scores given by peers");

		waitThread(2000);
		// Type the Question 1 score
		click(ari.addscore_txtbx);
		driver.findElement(By.xpath("//input[@id='teacherScore']")).sendKeys("5");

		// Click Save button
		waitThread(2000);
		click(ari.save_btn);

		// Assert the toaster "Score Saved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);

		// Assert the label "Score Received from Teacher:"
		waitThread(2000);
		Assert.assertEquals(getText(ari.scorefromteach_lbl), "Score Received from Teacher: 5");

		// Click on Exit button
		click(arv.exit_btn);
		waitThread(2000);

		// Click on Back to results button
		click(ari.backto_reslt_btn);

		waitThread(3000);
		// Assert the student 1 Status "Scores Modified"
		Assert.assertEquals(getText(ari.status_stud1), "Scores Modified");

		waitThread(1000);
		// Assert the student 2 Status "Peer Scores Approved"
		Assert.assertEquals(getText(ari.status_stud2), "Peer Scores Approved");

		waitThread(1000);
		// Assert the Reconsideration Labels,dates,change button not visible on
		// the page
		Assert.assertFalse(isElementPresent(mre.reconstext),
				"The student can raise reconsideration request label present");
		Assert.assertFalse(isElementPresent(mre.reconsdaytime_text), "day time label not present");
		Assert.assertFalse(isElementPresent(mre.change_btn), "Change button present");

	}

	/*
	 * To remove the changes done by the teacher on student 1 pages
	 */
	@Test(priority = 32)
	public void TCSPR1500532() {

		waitThread(1000);
		// Click on Student 1 View/Modify button
		Doubleclick(ari.modifybtn_stud1);

		waitThread(5000);
		// Assert the Student 1 Name on the Page
		Assert.assertTrue(getText(arv.stud_name_resultwindow).contains(Student1name));

		// Clear the Score textbox Q1
		click(ari.addscore_txtbx);
		driver.findElement(By.xpath("//input[@id='teacherScore']")).sendKeys(Keys.BACK_SPACE);
		waitThread(3000);

		// Click Save button
		click(ari.save_btn);
		waitThread(3000);

		// Click on Exit button
		click(arv.exit_btn);
		waitThread(3000);

		// Click on Back to results button
		click(ari.backto_reslt_btn);

		waitThread(1000);
		// Assert the Student 1 Label "Peer review completed"
		Assert.assertEquals(getText(ari.status_stud1), "Peer Review Completed");

		// Assert the Reconsideration Labels,dates,change button visble on the
		// page
		Assert.assertTrue(getText(mre.reconstext).contains("The student can raise reconsideration request till:"));
		Assert.assertTrue(getText(mre.reconsdaytime_text)
				.contains(recon_day + " days from Result publish, " + cm.removeLeadingZeroes(recon_time)));
		Assert.assertTrue(isElementPresent(mre.change_btn), "Change button not present");

	}

	/*
	 * To check the Toaster message while click publish button To check the
	 * labels and buttons of Set last date for raising Reconsideration Request
	 * popup Functionality
	 */
	@Test(priority = 33)
	public void TCSPR1500533() {
		SoftAssert assert1 = new SoftAssert();
		waitThread(2000);
		// Click on Publish button
		click(ari.publish_btn);

		// Assert the Toaster "Reconsideration date and time should not be prior
		// to
		// result publishing date and time"
		waitFor(QP.toaster);
		assert1.assertEquals(getText(QP.toaster),
				"Reconsideration date and time should not be prior to result publishing date and time");
		click(QP.toasterclosebtn);

		waitThread(1000);
		// Click on Change button
		click(mre.change_btn);

		waitThread(1000);
		// Assert the Set last date for raising Reconsideration Request popup
		// visible
		Assert.assertTrue(isElementPresent(ari.recons_popup), "popup not present");

		// Assert the Label "Set last date for raising Reconsideration Request"
		Assert.assertEquals(getText(ari.recons_popup_hd), "Set last date for raising Reconsideration Request");

		// Assert the Label "Allow students to raise the reconsideration request
		// if they
		// are not satisfied with their score granted by peers"
		Assert.assertEquals(getText(ari.recons_popup_txt),
				"Allow students to raise the reconsideration request if they are not satisfied with their score granted by peers");

		// Assert the Button Yes and No
		Assert.assertEquals(getAttribute(ari.recons_popup_yesbtn, "aria-label"), "Yes");
		waitThread(2000);
		Assert.assertEquals(getAttribute(ari.recons_popup_nobtn, "aria-label"), "No");
		assert1.assertAll();
	}

	/*
	 * To check the labels and buttons of Set last date for raising
	 * Reconsideration Request popup Functionality
	 */
	@Test(priority = 34)
	public void TCSPR1500534() {

		// Assert the Yes button is selected
		waitThread(1000);
		Assert.assertEquals(getAttribute(ari.recons_popup_yesbtn, "aria-pressed"), "true");

		// Assert the Label Last date for raising reconsideration request by
		// students:
		Assert.assertEquals(getText(ari.recons_bystud_txt),
				"Last date for raising reconsideration request by students:");

		waitThread(1000);
		// Assert the Days and Time same as schedule page
		Assert.assertEquals(getValue(ari.time_txtbx), recon_time);
		Assert.assertEquals(getValue(mre.daybx_reconpopup), recon_day);

		waitThread(1000);
		// Assert the Submit Button Is Disabled
		Assert.assertFalse(isEnabled(mre.submitbtn_recon_teach), "Submit button is enabled");

	}

	/*
	 * Click on No button Functionality on the page
	 */
	@Test(priority = 35)
	public void TCSPR1500535() {

		waitThread(1000);
		// Click on No button
		click(ari.recons_popup_nobtn);

		waitThread(1000);
		// Assert the No button is selected
		Assert.assertEquals(getAttribute(ari.recons_popup_nobtn, "aria-pressed"), "true");

		waitThread(1000);
		// Assert the Label "Allow students to raise the reconsideration request
		// if they
		// are not satisfied with their score granted by peers"
		Assert.assertEquals(getText(ari.recons_popup_txt),
				"Allow students to raise the reconsideration request if they are not satisfied with their score granted by peers");

		// Assert the Submit button is Enabled
		Assert.assertTrue(isEnabled(mre.submitbtn_recon_teach), "Submit button is disabled");

	}

	/*
	 * To change the days and time check the new time and days viisble on the
	 * page
	 */
	public String new_time;

	@Test(priority = 36)
	public void TCSPR1500536() {

		waitThread(1000);
		// Click on Yes button
		click(ari.recons_popup_yesbtn);

		waitThread(1000);
		// Click on Days dropdown
		click(ari.daydrop_recons_popup);

		waitThread(1000);
		// Select 1
		click(mre.day1_dropdwn);

		// Assert the Days 1 selected on the Box
		waitThread(1000);
		Assert.assertEquals(getValue(mre.daybx_reconpopup), "1");

		waitThread(1000);
		// Click on Min Arrow on the time box
		click(ari.time_txtbx);
		click(mre.time_minarrow);

		// Assert the New time
		new_time = getValue(ari.time_txtbx);

		waitThread(1000);
		// Click on submit button
		click(mre.submitbtn_recon_teach);

		// Assert the toaster "Updated Successfully"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Updated Successfully");
		click(QP.toasterclosebtn);

		waitThread(5000);
		// Assert the new reconsideration time 1 days from Result publish, Time
		Assert.assertTrue(getText(mre.reconsdaytime_text)
				.contains("1 days from Result publish, " + cm.removeLeadingZeroes(new_time)));

	}

	/*
	 * To check that the newly updated reconsideration days and time Should
	 * change on the Card
	 */
	@Test(priority = 37)
	public void TCSPR1500537() {

		waitThread(1000);
		// Click on Back button
		click(arv.back_btn);

		waitThread(9000);
		// Assert the Current Tab is selected
		Assert.assertEquals(getAttribute(arv.cuurent_assm_tab, "aria-selected"), "true");

		// Search the Assessment Name
		click(st1.assess_searchbx);
		type(st1.assess_searchbx, AssessmentName);
		waitThread(5000);

		// Assert the Label :Last Date for Reconsideration Request: 1 days from
		// Result
		// Publish, Time
		Assert.assertEquals(getText(mre.recontxt_card),
				"Last Date for Reconsideration Request: 1 days from Result Publish, "
						+ cm.removeLeadingZeroes(new_time));

	}

	/*
	 * To check that the newly updated reconsideration days and time Should
	 * change on the reconsideration window and reschedule the reconsideration
	 * date and time
	 */
	public String time2;

	@Test(priority = 38)
	public void TCSPR1500538() {

		waitThread(1000);
		// Click on Menu button
		click(rd.threedot_btn);

		// Click on Reschedule Dates button
		click(rd.reschedulemenu);
		waitThread(1000);

		// Assert the Popup Visible on the page
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");

		waitThread(4000);
		// Assert the Days 1 selected on the Box
		Assert.assertEquals(getValue(rd.day_drop_txtbx), "1");

		// Assert the Time on the time box
		Assert.assertEquals(getValue(rd.lastdatetime_txtbx), new_time);

		waitThread(1000);
		// Click on Days dropdown
		click(ari.daydrop_recons_popup);

		// Click on 2 from dropdown
		waitThread(1000);
		click(mre.day2_dropdwn);

		// Assert the Days 2 selected on the Box
		waitThread(1000);
		Assert.assertEquals(getValue(mre.daybx_reconpopup), "2");

		// Click on Min Arrow on the time box
		click(rd.lastdatetime_txtbx);
		click(rd.recons_time_minarrow);

		// Assert the Time
		waitThread(1000);
		time2 = (getValue(rd.lastdatetime_txtbx));

		waitThread(2000);
		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitFor(QP.toaster);
		// Assert toaster "Changes applied"
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		waitThread(5000);

		// Assert the Popup not Visible on the page
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");
	}

	/*
	 * To verify the card label and check that the updated days and time viisble
	 * on the Card and teacher result window
	 */
	@Test(priority = 39)
	public void TCSPR1500539() {

		// Search the Assessment Name
		click(st1.assess_searchbx);
		type(st1.assess_searchbx, AssessmentName);
		driver.findElement(By.id("searchAssessments")).sendKeys("   ");
		waitThread(3000);
		waitThread(8000);
		ScrollTo_Location(mre.recontxt_card);

		// Assert the Label :Last Date for Reconsideration Request: 2 days from
		// Result
		// Publish, Time
		Assert.assertEquals(getText(mre.recontxt_card),
				"Last Date for Reconsideration Request: 2 days from Result Publish, " + cm.removeLeadingZeroes(time2));

		// Click on Continue Button
		click(arv.viewresult_teachcard);

		// Assert the Label :2 days from Result publish, Time
		Assert.assertTrue(getText(mre.reconsdaytime_text)
				.contains("2 days from Result publish, " + cm.removeLeadingZeroes(time2)));

		// Click on Change button
		click(mre.change_btn);
		waitThread(1000);

		// Assert the days and time as as result page
		Assert.assertEquals(getValue(mre.daybx_reconpopup), "2");
		Assert.assertEquals(getValue(ari.time_txtbx), time2);

		// Close the popup
		click(ari.recons_popup_closebtn);

		waitThread(3000);
		// Assert the popupnot visible
		Assert.assertFalse(isElementPresent(ari.recons_popup), "Popup  present");

	}

	/*
	 * To perform publish the result functionality on the teacher login
	 */
	public String date;

	@Test(priority = 40)
	public void TCSPR1500540() throws ParseException {

		// Click on Publish button
		click(ari.publish_btn);

		waitThread(3000);
		// Assert the publish popup visible
		Assert.assertTrue(isElementPresent(ari.publish_popup), "popup not present");

		waitThread(3000);
		// Assert the Label "Result Published Successfully"
		Assert.assertEquals(getText(ari.pub_popup_txt), "Result Published Successfully");

		waitThread(2000);
		// Assert the Reconsideration date and time on the popup
		date = mre.getNextday();

		Assert.assertEquals(getText(mre.recons_txt_publishpopup), "Last date for raising Reconsideration will be: "
				+ date + " - " + mre.Nextdayname() + " at " + cm.removeLeadingZeroes(time2));

		// Assert the button Back to Results
		Assert.assertEquals(getText(mre.backresult_btn), "Back to Results");

		waitThread(3000);
		// Click on Back to Result Button
		click(mre.backresult_btn);

		waitThread(3000);
		// Assert the Heading Final result
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Final Result");

		// Assert the Label Reconsideration Request Active visible on the Page
		Assert.assertTrue(getText(mre.final_recons_txt).contains("Reconsideration Request Active for "));

		// Click on Back button
		click(arv.back_btn);
		waitThread(4000);

		// Assert the Current Tab is selected
		Assert.assertEquals(getAttribute(arv.cuurent_assm_tab, "aria-selected"), "true");

	}

	/*
	 * To check the Result details on the Card and reschedule page
	 */
	public String recondate1;
	public String reconstime1;
	public String resultdate;
	public String resulttime;

	@Test(priority = 41)
	public void TCSPR1500541() {

		// Search the Assessment Name
		click(st1.assess_searchbx);
		type(st1.assess_searchbx, AssessmentName);
		waitThread(3000);

		// Assert Label "Result Available"
		Assert.assertTrue(getText(tp.timer).contains("Result Available"), "Text not visible on card");

		waitThread(3000);
		// Assert the Result section labels:-Reconsideration Request,Active
		Assert.assertEquals(getText(mre.recons_lblcard), "Reconsideration Request");
		Assert.assertEquals(getText(tr.resultsts_lbl), "Active");

		// -Result Published Date: Date and Time
		cm.datetimesplitmethod();
		resultdate = cm.getdates(cm.resultdate);
		resulttime = cm.resultime;

		// -Last Date for raising Reconsideration Request:
		Assert.assertTrue(getText(tr.lastdate_lbl).contains("Last Date for raising Reconsideration Request"));

		// Date and Time
		mre.teachrecon_datetimemethod();
		recondate1 = cm.getdates(mre.resultdate);
		reconstime1 = mre.resultime;

		Assert.assertEquals(recondate1, mre.getdates1(date));
		Assert.assertEquals(reconstime1, time2);

		// Perform Teacher Logout
		waitThread(3000);
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * Login As student 1 and check the Details of Result window
	 */
	public String stud_resultdate;
	public String stud_resulttime;

	@Test(priority = 42)
	public void TCSPR1500542() {

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

		// Last date for reconsideration: Date and Time
		mre.stud_recons_datetimemethod();
		stud_resultdate = cm.getdates(mre.stud_resultdate);
		stud_resulttime = mre.stud_resultime;

		Assert.assertEquals(stud_resultdate, recondate1);
		Assert.assertEquals(stud_resulttime, reconstime1);

		// Assert the view result button visible
		Assert.assertTrue(isElementPresent(rwbt.viewresultbtn), "View result button not visible");

	}

	/*
	 * To check the Details of Result window
	 */
	@Test(priority = 43)
	public void TCSPR1500543() {

		// click on view result button
		click(rwbt.viewresultbtn);
		waitThread(3000);

		// Assert Result popup visible
		Assert.assertTrue(isElementPresent(rwbt.resultpopup), "Result Popup  not visible");

		// Assert the heading Result
		Assert.assertEquals(getText(rwbt.label_Result_1), "Result");

		// Assert the Timer visible on the Page :Time left for raising
		// Reconsideration
		// Request :
		Assert.assertTrue(
				getText(mre.result_stud_recons_txt).contains("Time left for raising Reconsideration Request "));

		// Assert the button reconsideration request
		Assert.assertEquals(getText(mre.recons_btn_stud), "Raise Reconsideration Request");

		click(ari.result_popup_close);
		waitThread(3000);

		// Perform Student 1 Logout
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check the details on the reschedule page
	 */
	@Test(priority = 44)
	public void TCSPR1500544() {

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

		waitThread(1000);
		// Click on Menu button
		click(rd.threedot_btn);

		// Click on Reschedule Dates button
		click(rd.reschedulemenu);
		waitThread(3000);

		// Assert the Popup Visible on the page
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");

		waitThread(3000);
		// Assert the Labels:
		// -Last date for Reconsideration Request
		Assert.assertEquals(getText(mre.lstdate_txt), "Last date for Reconsideration Request");

		waitThread(2000);
		// -Last date for raising reconsideration request by students
		Assert.assertEquals(getText(mre.lastdat_txt2), "Last date for raising reconsideration request by students");

	}

	/*
	 * To reschedule the reconsideration date from the teacher Login
	 */
	public String reconsiderationdate;
	public String reconsideration_time;

	@Test(priority = 45)
	public void TCSPR1500545() throws InterruptedException {

		// Select Todays date on the reconsideration Text box
		Doubleclick(rd.reconsiderationdat_txtbx);

		waitThread(1000);
		cm.ClickTodaysDate();
		waitThread(2000);

		// wait for 1.5 min
		TimeUnit.MINUTES.sleep(1);
		// Click Apply Changes button
		click(rd.applychanges_btn);
		// Assert the toaster "Reconsideration date and time should not be prior
		// to
		// result publishing date and time"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster),
				"Reconsideration date and time should not be prior to result publishing date and time");
		click(QP.toasterclosebtn);

		// Select Tommorow date on the reconsideration box
		waitThread(1000);
		Doubleclick(rd.reconsiderationdat_txtbx);
		waitThread(1000);
		Doubleclick(rd.reconsiderationdat_txtbx);
		waitThread(1000);
		waitThread(2000);
		cm.ClicktomorrowDate();
		waitThread(2000);
		// Assert the Date and time on the box
		waitThread(2000);
		reconsiderationdate = getValue(rd.reconsiderationdat_txtbx);
		reconsideration_time = getValue(rd.reconsiderationtime_txtbx);

		waitThread(2000);
		// Click Apply Changes button
		click(rd.applychanges_btn);
		waitThread(6000);
		// Check for toaster element's presence
		java.util.List<WebElement> toaster = driver.findElements(By.xpath(rs.toaster));
		if (toaster.size() != 0) {
			// Toaster message
			waitFor(rs.toaster);
			click(QP.toasterclosebtn);
		} else

			// Search the Assessment Name
			click(st1.assess_searchbx);
		type(st1.assess_searchbx, AssessmentName);
		driver.findElement(By.id("searchAssessments")).sendKeys("  ");
		// Assert the Result Published Date: and time Last date for
		// reconsideration:
		// Date and Time
		waitThread(4000);
		mre.teachrecon_datetimemethod();
		recondate1 = cm.getdates(mre.resultdate);
		reconstime1 = mre.resultime;

	}

	/*
	 * Login As student 1 and check the Details of Result window
	 */
	@Test(priority = 46)
	public void TCSPR1500546() {

		// Check for reschedulepopupup element's presence
		java.util.List<WebElement> reschedulepopupup = driver.findElements(By.xpath("//div[@id='scheduleMainDiv']"));
		if (reschedulepopupup.size() != 0) {
		click("span.p-dialog-header-close-icon");
		} else		
		waitThread(2000);
		// Perform Logout Teacher profile
		cm.Logout();
		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
		// login as Student1
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

		// Assert the Result Published Date: and time last date for
		// reconsideration:
		// Date and Time
		cm.studentresultdatetimemethod();
		String resultdatestud = cm.getdates(cm.resultdate_stud);
		String resulttimestud = cm.resultime_stud;

		Assert.assertEquals(resultdatestud, resultdate);
		Assert.assertEquals(resulttimestud, resulttime);

		// Assert the last date for reconsideration:Date and Time
		mre.stud_recons_datetimemethod();
		stud_resultdate = cm.getdates(mre.stud_resultdate);
		stud_resulttime = mre.stud_resultime;

	}

	/*
	 * To check the Details of Result window
	 */
	public String scorefrmmpeers_stud;
	public String totscore_stud;

	@Test(priority = 47)
	public void TCSPR1500547() {

		// Assert the view result button visible
		Assert.assertTrue(isElementPresent(rwbt.viewresultbtn), "View result button not visible");

		// click on view result button
		click(rwbt.viewresultbtn);
		waitThread(3000);

		// Assert Result popup visible
		Assert.assertTrue(isElementPresent(rwbt.resultpopup), "Result Popup  not visible");

		// Assert the heading Result
		Assert.assertEquals(getText(rwbt.label_Result_1), "Result");

		// To get score received from peers
		String[] arrOfStr = getText(rwbt.Scorefrm_teach).split("/");
		waitThread(2000);
		scorefrmmpeers_stud = arrOfStr[arrOfStr.length - 2];

		// To get total score
		String[] arrOfStr1 = getText(rwbt.TotalScore).split("/");
		waitThread(2000);
		totscore_stud = arrOfStr1[arrOfStr1.length - 2];

		// Click on Question 1
		click(arv.view_btn);
		waitThread(2000);

		// Assert the reconsideration dates visible on the Answer window
		Assert.assertTrue(getText(mre.stud_timeleft).contains("Time left for raising Reconsideration Request : "));

		waitThread(2000);
		// Click on Exit button
		click(sasb.Exit_btn);

		waitThread(3000);
		// Assert the Label Result
		Assert.assertEquals(getText(mre.result_lbl), "Result");

	}

	/*
	 * To check the Raise reconsideration request functionality
	 */
	@Test(priority = 48)
	public void TCSPR1500548() {

		// Assert the button and button label Raise reconsideration request
		Assert.assertTrue(isElementPresent(mre.recons_btn_stud), "Reconsideration Request button not visible");
		Assert.assertEquals(getText(mre.recons_btn_stud), "Raise Reconsideration Request");

		// Click on Raise reconsideration request
		click(mre.recons_btn_stud);

		waitThread(1000);
		// Assert the popup visible
		Assert.assertTrue(isElementPresent(mre.reason_reconpopup), "Reason for Reconsideration popup not visible");

		// Assert the heading Reason For Reconsideration
		Assert.assertEquals(getText(mre.reason_recon_hd), "Add your reason for reconsideration");

		// Assert the placeholder Add your reason for reconsideration
		Assert.assertEquals(getAttribute(mre.txtarea_popup, "placeholder"), "Add your reason for reconsideration");

		// Assert label You have 200 words left.
		Assert.assertEquals(getText(mre.smalltext), "You have 200 words left.");

		waitThread(2000);
		// Assert the submit button and the button is in disabled state
		Assert.assertTrue(isDisplayed(mre.submit_btn_reconpopup), "Submit button not visible");
		Assert.assertFalse(isEnabled(mre.submit_btn_reconpopup), "Submit button is enabled");

	}

	/*
	 * To check the Reason For Reconsideration submit functionality
	 */
	public String comment1 = "Reason for reconsideration";

	@Test(priority = 49)
	public void TCSPR1500549() {

		// Click on close button
		click(mre.reason_pop_closebtn);

		waitThread(2000);
		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(mre.reason_reconpopup), "Reason for Reconsideration popup not visible");

		waitThread(2000);
		// Click on Raise reconsideration request
		click(mre.recons_btn_stud);

		waitThread(1000);
		// Assert the popup visible
		Assert.assertTrue(isElementPresent(mre.reason_reconpopup), "Reason for Reconsideration popup not visible");

		// Type Reason for reconsideration request
		click(mre.txtarea_popup);
		type(mre.txtarea_popup, comment1);

		waitThread(2000);
		// Assert the Submit button is Enabled
		Assert.assertTrue(isEnabled(mre.submit_btn_reconpopup), "Submit button is disabled");
	}

	/*
	 * To check the Reason For Reconsideration submit functionality
	 */
	@Test(priority = 50)
	public void TCSPR1500550() {

		// Click on Submit button
		click(mre.submit_btn_reconpopup);

		// Assert the toaster "Reconsideration Request Raised"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Reconsideration Request Raised");
		click(QP.toasterclosebtn);

		// Assert the button label View Teacher Response to Reconsideration
		// Request
		Assert.assertEquals(getText(mre.teach_respons_btn), "View Teacher Response to Reconsideration Request");

		// Assert the View Teacher Response to Reconsideration Request button is
		// disabled
		Assert.assertFalse(isEnabled(mre.teach_respons_btn_disb),
				" Teacher Response to Reconsideration Request button is enabled");

		// Assert the Timer Not visible on the Page
		Assert.assertFalse(isElementPresent(mre.result_stud_recons_txt), "the Timer visible on the Page");

		waitThread(2000);
		click(ari.result_popup_close);
		waitThread(2000);

		// Perform Student 1 Logout
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * Login As student 2 and check that reconsideration option not visible on
	 * the student 2 Card and result window
	 */
	@Test(priority = 51)
	public void TCSPR1500551() {

		// Perform Student 2 Login
		waitThread(2000);
		lg.login1(Emailstudent2, cm.Password);

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
		Assert.assertFalse(isElementPresent(tr.lastdatetime_lbl), "Reconsideration date and time visible");
	}

	/*
	 * To check that reconsideration option not visible on the student 2 result
	 * window
	 */
	@Test(priority = 52)
	public void TCSPR1500552() {

		// click on view result button
		click(rwbt.viewresultbtn);
		waitThread(3000);

		// Assert Result popup visible
		Assert.assertTrue(isElementPresent(rwbt.resultpopup), "Result Popup  not visible");

		// Assert the heading Result
		Assert.assertEquals(getText(rwbt.label_Result_1), "Result");

		// Assert the reconsideration Button not visible on the Page
		Assert.assertFalse(isElementPresent(mre.recons_btn_stud), " reconsideration Button visible on the Page");

		// Assert the reconsideration Timer not visible on the page
		Assert.assertFalse(isElementPresent(mre.result_stud_recons_txt), "the Timer visible on the Page");

		// Close the Result Popup
		waitThread(2000);
		click(ari.result_popup_close);
		waitThread(2000);

		// Perform Student 2 Logout
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * Login as teacher and check that the student reconsideration details on
	 * teh assessment card
	 */
	@Test(priority = 53)
	public void TCSPR1500553() {

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
		// Assert the heading Reconsideration Requested
		Assert.assertTrue(getText(tp.timer).contains("Reconsideration Requested"), "Text not visible on card");

		// Assert the result section labels:Reconsideration Request
		// Active
		Assert.assertEquals(getText(mre.recons_lblcard), "Reconsideration Request");
		Assert.assertEquals(getText(tr.resultsts_lbl), "Active");

		// Assert the Labels:Last Date for raising Reconsideration Request:Date
		// and Time
		// -Reconsideration requested: 1 Pending 0 Processed

		// Assert the button and Button label View
		Assert.assertTrue(isElementPresent(mre.view_btn_teachcard), "View result button not present");
		Assert.assertEquals(getText(mre.view_btn_teachcard), "View");
	}

	/*
	 * To view the reconsideration request of student 1
	 */
	@Test(priority = 54)
	public void TCSPR1500554() {

		// Click on View button
		click(mre.view_btn_teachcard);

		waitThread(2000);
		// Assert the label "Reconsideration Requests"
		Assert.assertEquals(getText(mre.recons_req_hd), "Reconsideration Requests");

		// Assert the Course Name,Assessment Name and Course Code
		Assert.assertEquals(getText(mre.course_lbl),
				"Course Name: " + CourseName3.trim() + " " + "(" + CourseID3 + ")");
		Assert.assertEquals(getText(mre.assess_lbl), "Assessment Name: " + AssessmentName);

		// Assert the Label:-Reconsideration Request-Pending: 1-Processed: 0
		Assert.assertEquals(getText(mre.pending_lbl), "Pending: 1");
		Assert.assertEquals(getText(mre.process_lbl), "Processed: 0");

		// Assert the Student 1 Name on the Grid
		Assert.assertEquals(getText(mre.stud1grid).trim(), Student1name.trim());
	}

	/*
	 * To view the reconsideration request of Student 1 and check the I approve
	 * the Total Scores given by peers checkbox and label
	 */
	@Test(priority = 55)
	public void TCSPR1500555() {

		// Click on Reconisder button
		click(mre.reconsider_btn);

		waitThread(2000);
		// Assert the Student reason for Reconsideration popup shows
		Assert.assertTrue(isDisplayed(mre.sys_genpopup_recon), "Student reason for Reconsideration popup  not present");

		// Assert the Student reason for Reconsideration comment
		Assert.assertEquals(getText(mre.stud_commment), comment1);

		// Click on close button
		click(mre.sys_gen_closebtn);

		waitThread(2000);
		// Assert the label and check box I approve the Total Scores given by
		// peers
		Assert.assertEquals(getText(ari.iapprove_lbl), "I approve the Total Scores given by peers");
		Assert.assertTrue(isDisplayed(ari.score_checkbx), "Check box not present");

		// Click on I approve the Total Scores given by peers checkbox
		click(ari.score_checkbx);

		waitThread(2000);
		// Assert the check box is checked
		Assert.assertTrue(getAttribute(ari.score_checkbx_check, "class").contains("checked"));

		// Assert the score box is disabled
		Assert.assertTrue(getAttribute(ari.addscore_txtbx, "class").contains("disabled"));

		// Click on I approve the Total Scores given by peers button
		click(ari.score_checkbx);

		// Assert the check box is unchecked
		waitThread(2000);
		Assert.assertFalse(getAttribute(ari.score_checkbx_check, "class").contains("checked"));

		// Assert the score box is Enabled
		Assert.assertFalse(getAttribute(ari.addscore_txtbx, "class").contains("disabled"));

	}

	/*
	 * To check the I approve the Total Scores given by peers functionality To
	 * check the No button
	 */
	@Test(priority = 56)
	public void TCSPR1500556() {

		// Click on I approve the Total Scores given by peers checkbox
		click(ari.score_checkbx);

		// Click on Exit Button
		click(arv.exit_btn);
		waitThread(2000);

		// Assert the Popup Visible on the page
		Assert.assertTrue(isDisplayed(ari.conf_popup), "popup not visible");

		// Assert the Labels:
		// -Confirmation
		// -Are you sure you want to approve the total score given by peers?
		Assert.assertEquals(getText(ari.conf_txt), "Are you sure you want to approve the total score given by peers?");
		Assert.assertEquals(getText(ari.conf_hd), "Confirmation");

		// Assert the Buttons:Yes and No
		Assert.assertEquals(getText(ari.discard_btn), "No");
		Assert.assertEquals(getText(ari.savecont_btn), "Yes");

		waitThread(3000);
		// Click on No button
		Doubleclick(ari.discard_btn);

		waitThread(3000);
		// Assert the Popup not visble on the page
		Assert.assertFalse(isElementPresent(ari.conf_popup), "popup visible");

		// Assert the heading Reconsideration Requests
		waitThread(1000);
		Assert.assertEquals(getText(mre.recons_req_hd), "Reconsideration Requests");
	}

	/*
	 * To check the I approve the Total Scores given by peers functionality To
	 * check the Yes button
	 */
	@Test(priority = 57)
	public void TCSPR1500557() {

		// Click on Reconisder button
		click(mre.reconsider_btn);

		waitThread(2000);
		click(mre.sys_gen_closebtn);

		// Click on I approve the Total Scores given by peers checkbox
		click(ari.score_checkbx);
		waitThread(1000);

		// Click on Exit button
		click(arv.exit_btn);

		waitThread(2000);
		// Click Yes button
		click(ari.savecont_btn);

		// Assert the toaster "Total Score Approved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Total Score Approved");
		click(QP.toasterclosebtn);

		// Assert the heading Reconsideration Requests
		waitThread(2000);
		Assert.assertEquals(getText(mre.recons_req_hd), "Reconsideration Requests");

	}

	/*
	 * To Publish the reconsideration request of student 1
	 */
	@Test(priority = 58)
	public void TCSPR1500558() {

		// Assert the Score received from peers is same as student window
		waitThread(1000);
		Assert.assertEquals(getText(mre.score_frompeer_grid), scorefrmmpeers_stud);

		waitThread(1000);
		// Assert the total score of answer sheet is same as student result
		// window
		Assert.assertEquals(getText(mre.totscore_grid), totscore_stud);

		// Assert the button name Continue
		Assert.assertTrue(isElementPresent(mre.reconsider_btn), "Continue Button not visible on the Page");
		Assert.assertEquals(getText(mre.reconsider_btn), "Continue");

		// Click on Continue button
		waitThread(1000);
		click(mre.reconsider_btn);

		// Click close button of student comment
		waitThread(1000);
		click(mre.sys_gen_closebtn);
		waitThread(2000);

		// Assert the check box I approve the Total Scores given by peers is
		// checked
		Assert.assertTrue(getAttribute(ari.score_checkbx_check, "class").contains("checked"));

		// Assert the publish button is Enabled
		Assert.assertTrue(isEnabled(mre.publish_btn_recons), "publish button is disabled");
	}

	/*
	 * To Publish the reconsideration request of student 1 and check the view
	 * result page functionalities
	 */
	public String comment2 = "response comment to reconsideration";

	@Test(priority = 59)
	public void TCSPR1500559() {

		// Click on Publish button
		waitThread(1000);
		click(mre.publish_btn_recons);

		// Assert the teacher reason for reconsideration request
		waitThread(1000);
		Assert.assertTrue(isElementPresent(mre.reason_reconpopup),
				"Add your response to the reconsideration request popup not visible");

		// Type comment
		click(mre.txtarea_popup);
		type(mre.txtarea_popup, comment2);

		waitThread(2000);

		// Click publish button
		click(mre.submit_btn_reconpopup);

		waitThread(2000);
		// Assert the publish popup visible
		Assert.assertTrue(isElementPresent(mre.resultpublish_popup), "popup not present");

		// Assert the Label "Result Published Successfully"
		Assert.assertEquals(getText(mre.result_publish_txt), "Result Published Successfully");

		// Click on Back to result button
		click(mre.back_btn_reconspopup);

		// Assert the reconsideration requested radio button is selected
		Assert.assertTrue(getAttribute(mre.recons_req_radiobtn, "class").contains("checked"));

		// Assert the Label "Reconsideration Processed"
		Assert.assertEquals(getText(mre.recons_status), "Reconsideration Processed");

		// Click on View button of student 1
		click(mre.reconsider_btn);

		// Assert the Label "Peer Scores Approved"
		waitThread(2000);
		Assert.assertEquals(getText(mre.review_status), "Peer Scores Approved");

		// Perform Teacher Logout
		waitThread(2000);
		cm.Logout();

		// Assert heading Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * Login As student 1
	 */
	@Test(priority = 60)
	public void TCSPR1500560() {

		// Login as Student1
		waitThread(2000);
		lg.login1(Emailstudent1, cm.Password);

		// Search the Assessment Name
		waitThread(5000);
		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		click(st1.stud_searchbx);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(3000);

		// Assert the Label Reconsideration processed
		Assert.assertEquals(getText(mre.recons_processd_lbl), "Reconsideration Processed");

		// Click on View Result Button
		click(rwbt.viewresultbtn);
		waitThread(3000);

		// Assert the heading Result
		Assert.assertEquals(getText(rwbt.label_Result_1), "Result");

		// Assert the button View Teacher Response to Reconsideration Request
		Assert.assertEquals(getText(mre.viewteach_comment_btn), "View Teacher Response to Reconsideration Request");

		// Assert the Reconsideration Timer not visible on the page
		Assert.assertFalse(isElementPresent(mre.result_stud_recons_txt), "Timer presemt");

	}

	/*
	 * Check the response of reconsideration request of student 1
	 */
	@Test(priority = 61)
	public void TCSPR1500561() {

		// Click teacher response for Reconsideration request button
		click(mre.viewteach_comment_btn);

		// Assert the teacher comment
		waitThread(3000);
		Assert.assertEquals(getValue(mre.teach_response_txt), comment2);

		// Click close button
		click(mre.teach_resp_close_btn);

		waitThread(2000);
		// Assert the Labels "Teacher Approved"
		Assert.assertEquals(getText(ari.Q1_StatusS2), "Teacher Approved");
		Assert.assertEquals(getText(ari.Q2_StatusS2), "Teacher Approved");
		Assert.assertEquals(getText(ari.Q3_StatusS2), "Teacher Approved");

		// Assert the Score received from peers and Total Score of Student 1
		Assert.assertEquals(getText(rwbt.Scorefrm_teach), scorefrmmpeers_stud + "/" + TotalTestPoints);
		Assert.assertEquals(getText(rwbt.TotalScore), totscore_stud + "/120");

		// Click on Q1
		waitThread(1000);
		click(ari.view_btn_q1S2);

		// Assert the Wizards
		waitThread(2000);
		Assert.assertTrue(getAttribute(sasb.wizardq1, "class").contains("p-highlight"));

		// Assert the Label "Teacher Approved"
		Assert.assertEquals(getText(arv.reviewstatus), "Teacher Approved");

		// Click on wizard 2
		click(sasb.wizardq2);

		// Assert the wizard 2 is selected
		waitThread(2000);
		Assert.assertTrue(getAttribute(sasb.wizardq2, "class").contains("p-highlight"));

		// Assert the Label "Teacher Approved"
		Assert.assertEquals(getText(arv.reviewstatus), "Teacher Approved");

		// Click on wizard 3
		click(sasb.wizardq3);

		// Assert the wizard 3 is selected
		waitThread(2000);
		Assert.assertTrue(getAttribute(sasb.wizardq3, "class").contains("p-highlight"));

		// Assert the Label "Teacher Approved"
		Assert.assertEquals(getText(arv.reviewstatus), "Teacher Approved");

	}

	/*
	 * To perform Delete student1 Account functionality
	 */
	@Test(priority = 62)
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
	 * To perform Delete student2 Account functionality
	 */
	@Test(priority = 63)
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
	 * To perform Delete Teacher Account functionality
	 */
	@Test(priority = 64)
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
