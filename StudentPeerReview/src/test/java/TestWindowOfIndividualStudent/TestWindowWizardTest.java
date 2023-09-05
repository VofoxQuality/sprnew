package TestWindowOfIndividualStudent;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.jsoup.select.Evaluator.ContainsText;
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
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CreateNewAssessment.Pages.SummaryQuestionsPage;
import CurrentAssessmentsforStudents.Pages.StudentTestSectionPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import NewAssessmentOfTeacherPage.TeacherResultSectionPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class TestWindowWizardTest extends basePage {

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
	CommonMethods cm = new CommonMethods();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	TestWindowWizardPage tsw = new TestWindowWizardPage();
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
	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	public String Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
	public String Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";

	/*
	 * To perform Login functionality
	 */
	@Test(priority = 1)
	public void TCSPR1200201() throws SQLException {

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
	public void TCSPR1200202() throws SQLException {
		CourseName = "Course Name" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID = (getText(cn.course_Id));
		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";

		// Invite students to course
		cm.Invitestudentstocourse(CourseName, Emailstudent1, Emailstudent2);

	}
	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 3)
	public void TCSPR1200203() {

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
	public void TCSPR1200204() throws SQLException {

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
	public void TCSPR1200205() {

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
	public void TCSPR1200206() throws SQLException {
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
	public void TCSPR1200207() {

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

	public String CourseID;
	public String CourseName;

	/*
	 * To load the create new assessment page and fill details on the basic
	 * details page
	 */
	@Test(priority = 8)
	public void TCSPR1200208() {

		SoftAssert softAssert1 = new SoftAssert();
		lg.login1(Emailteacher, password);
		waitThread(4000);
		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(7000);
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

		waitThread(1000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(1000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(3000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), AssessmentName);

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID + ", " + CourseName.trim());

		softAssert1.assertAll();

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 9)
	public void TCSPR1200209() {

		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		MouseHover(QP.Quest_box);
		// click on Question box
		Doubleclick(QP.Quest_box);

		quest1 = "Question1";
		// Type a question on Question box
		type(QP.Quest_box, quest1);

		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "10");

		MouseHover(QP.save);

		// Click on +button
		click(rd.add_quest_btn);
		waitFor(QP.toaster);

		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);

		// Assert the label "2.Questions"
		Assert.assertTrue(getText(QP.question1).contains("2." + "\nQuestion"));

		waitThread(2000);

		driver.switchTo().frame("question_ifr");
		// Type a question on Question box
		type(QP.Quest_box, "Question 2");

		driver.switchTo().defaultContent();

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, "5");

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
	@Test(priority = 10)
	public void TCSPR1200210() {

		waitThread(2000);
		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question3");

		driver.switchTo().defaultContent();

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, "4");

		waitThread(3000);
		MouseHover(rd.add_quest_btn);
		waitThread(1000);

		// Click + button
		click(rd.add_quest_btn);
		waitFor(QP.toaster);

		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 3 Saved successfully");
		click(QP.toasterclosebtn);

		waitThread(1000);
		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		waitThread(2000);

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question4");
		driver.switchTo().defaultContent();

		ScrollTo_Location(QP.Qassessmentdetails);
		waitThread(3000);

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R4");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, "6");

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
	@Test(priority = 11)
	public void TCSPR1200211() {

		waitThread(3000);

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

	}

	public String assessmentopendate;
	public String assessmentduedate;
	public String testopentime;
	public String testduetime;

	/*
	 * To perform the save and next functionaity from peer review page and
	 * verify the schedule page details
	 */
	@Test(priority = 12)
	public void TCSPR1200212() {

		// Type the Reward Score Percentage
		type(sb1.RewardScore, "50");

		click(pr.savennext_button);
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);
		waitThread(2000);
		Assert.assertEquals(getAttribute(sb1.schedule_wizard, "aria-expanded"), "true");

		// Assert the text "Select schedules for "
		Assert.assertEquals(getText(sb1.selectstu_lbl), "Select Schedules for");

		// Assert that the Assessment Open date is Today's date
		Assert.assertEquals(getValue(sb1.assessmentopendate_txtbx), sb1.getdate());

		waitThread(3000);

		assessmentopendate = getValue(tts.assessmentopendate_txtbx);
		assessmentduedate = getValue(tts.assessmentduedate_txtbx);
		testopentime = getValue(tts.schedule_testopn_time);
		testduetime = getValue(tts.schedule_testdue_time);

	}

	/*
	 * To verify the details on the Summary page & publish the Assessment
	 */
	@Test(priority = 13)
	public void TCSPR1200213() {
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
	@Test(priority = 14)
	public void TCSPR1200214() {

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
	@Test(priority = 15)
	public void TCSPR1200215() {
		waitThread(7000);
		// Assert the text "Assessments "
		Assert.assertEquals(getText(ba.lbl_assessment), "Assessments");
		waitThread(3000);
		// search newly created assessment
		type(st1.assess_searchbx, AssessmentName);
		driver.findElement(By.xpath(st1.assess_searchbx)).sendKeys("   ");
		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");

		// Assert the Assessment name visible
		Assert.assertEquals(getText(st1.teach_assess_name), AssessmentName);
	}

	/*
	 * To check the test section of Assessment card
	 */
	@Test(priority = 16)
	public void TCSPR1200216() {

		// Assert the the "Test Pending "
		Assert.assertEquals(getText(tp.teststs_lbl), "Pending");

		// Assert the text "Students completed"
		Assert.assertEquals(getText(st1.stud_compl_txt), "Students Submitted");
	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 17)
	public void TCSPR1200217() {
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform Login functionality of student1 profile and check the
	 * Assessment card
	 */
	@Test(priority = 18)
	public void TCSPR1200218() {

		// login as Student1
		lg.login1(Emailstudent1, password);

		waitThread(7000);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys("   ");
		waitThread(2000);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(st1.Assess_name_card), AssessmentName);

	}

	/*
	 * To check the published Assessment card
	 */
	@Test(priority = 19)
	public void TCSPR1200219() {

		waitThread(2000);
		// Assert the testTest active status time
		// Assert.assertTrue(getText(st1.testtime).contains("Test active for"));

		// Assert the the "Test Active "
		Assert.assertEquals(getText(tp.teststs_lbl), "Pending");

	}

	/*
	 * To check the published Assessment card
	 */
	@Test(priority = 20)
	public void TCSPR1200220() {

		// Assert the text "Questions Answered"
		Assert.assertEquals(getText(st1.Quest_ans_lbl), "Questions Answered");

		// Assert the Question count in the card is same as summary page
		// questions count
		Assert.assertTrue(getText(st1.quest_count).contains(quest_count));
	}

	/*
	 * To perform logout functionality from student 1 profile
	 */
	@Test(priority = 21)
	public void TCSPR1200221() {

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To login as Student2 and to check the Assessment status
	 */
	@Test(priority = 22)
	public void TCSPR1200222() {

		// login as Student2
		lg.login1(Emailstudent2, password);
		waitThread(7000);
		Doubleclick(st1.stud_searchbx);
		waitThread(3000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		// driver.findElement(By.id("searchAssessmentFilter")).sendKeys(" ");
		waitThread(4000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(st1.Assess_name_card), AssessmentName);

	}

	/*
	 * 
	 */
	@Test(priority = 23)
	public void TCSPR1200223() throws InterruptedException {
		waitThread(2000);
		// Assert the test Test active status time
		// Assert.assertTrue(getText(st1.testtime).contains("Test active for"));
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(80);
		// Assert the the "Test Active "
		// Assert.assertEquals(getText(tp.teststs_lbl), "Active");

		// Assert the text "Questions Answered"
		Assert.assertEquals(getText(st1.Quest_ans_lbl), "Questions Answered");
	}

	/*
	 * To check the Test active status card
	 */
	@Test(priority = 24)
	public void TCSPR1200224() throws InterruptedException {

		// Assert the test status as active
		Assert.assertEquals(getText(tp.teststs_lbl), "Active");

		// Assert the button begin test
		Assert.assertTrue(isDisplayed(st1.begintest_btn), "Begin test not present");
		Assert.assertEquals(getText(st1.begintest_btn), "Begin Test");
	}

	/*
	 * To begin the test & check the labels of test window
	 */
	@Test(priority = 25)
	public void TCSPR1200225() {

		// Click Begin Test
		click(st1.begintest_btn);

		waitThread(2000);
		// Assert the Assessment name
		Assert.assertEquals(getText(tsw.test_window_assess_name), AssessmentName);

	}

	/*
	 * To check the buttons of Test window
	 */
	@Test(priority = 26)
	public void TCSPR1200226() {

		// Assert the total Questions, Total score
		Assert.assertTrue(getText(tsw.questions_count).contains("Total Questions"));
		Assert.assertTrue(getText(tsw.total_score).contains("Total Score"));

		// Assert the Buttons Save&Next, Save&Exit, Submit
		Assert.assertTrue(isDisplayed(QP.savenext_btn), "Save&Next button not present");
		Assert.assertEquals(getText(QP.savenext_btn), "Save & Next");

		Assert.assertTrue(isDisplayed(QP.savexit_btn), "Save&Exit button not present");
		Assert.assertEquals(getText(QP.savexit_btn), "Save & Exit");

		Assert.assertTrue(isDisplayed(tsw.submit_btn), "Submit button not present");
		Assert.assertEquals(getText(tsw.submit_btn), "Submit");

		// Assert the tooltips of buttons
		//MouseHover(QP.savenext_btn);
		//Assert.assertEquals(getAttribute(QP.savexit_btn, "ptooltip"), "Save & Exit");
		//waitThread(1000);

		// Assert the max score of question1 with question page
		Assert.assertEquals(getText(tsw.max_score_txt), "Max Score: 10");

		// Assert the save button disable
		Assert.assertTrue(getAttribute(tsw.save_btn_test, "class").contains("disabled-btn"));

		waitThread(3000);
		// Assert Save&Next button disabled
		Assert.assertFalse(getAttribute(QP.savenext_btn, "class").contains("disabled-btn"));

	}

	/*
	 * To check the question number wizard
	 */
	@Test(priority = 27)
	public void TCSPR1200227() {
		// Assert the question 1 is select on the wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));
		Assert.assertEquals(getText(tsw.quest_1_wizard), "1");

		// Assert the Text "Question No:1" , Max Score
		Assert.assertEquals(getText(tsw.quest1_text), "Question No: 1");
		Assert.assertEquals(getText(tsw.max_score_txt), "Max Score: 10");

		// Assert the Question is same as that of question page
		driver.switchTo().frame("questionView_ifr");
		waitThread(1000);

		Assert.assertEquals(getText(tsw.quest_box), quest1);

		driver.switchTo().defaultContent();

		waitThread(1000);
		// Assert the all question numbers are visible on wizard
		Assert.assertEquals(getText(tsw.quest_2_wizard), "2");
		Assert.assertEquals(getText(tsw.quest_3_wizard), "3");
		Assert.assertEquals(getText(tsw.quest_4_wizard), "4");

	}

	/*
	 * To check the skipped answers confirmation popup before submit
	 */
	@Test(priority = 28)
	public void TCSPR1200228() {

		// Assert first question selected on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));
		waitThread(2000);

		// Click second question wizard
		click(tsw.quest_2_wizard);

		waitThread(2000);
		// Assert first question is unanswered
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("visitednotattended"));

		waitThread(3000);
		// Click 3rd Question wizard
		click(tsw.quest_3_wizard);

		waitThread(2000);
		// Assert second question is unanswered
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("visitednotattended"));

		waitThread(3000);
		// Click 4th question on Wizard
		click(tsw.quest_4_wizard);

		waitThread(2000);
		// Assert Third question is unanswered
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("visitednotattended"));

		waitThread(2000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(1000);

		Assert.assertTrue(isDisplayed(tsw.confir_popup), "popup not visible");

		// Assert the text "You have 4 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(tsw.confirmation_txt), "You have 4 skipped question(s)! Proceed to submit?");

		waitThread(1000);
		// Click cancel
		click(tsw.cancel_confi);

		waitThread(3000);
		// Assert no popup visible
		Assert.assertFalse(isElementPresent(tsw.confir_popup), "popup visible");
	}

	/*
	 * To add answer to the questions and check the functions of save button
	 */
	@Test(priority = 29)
	public void TCSPR1200229() {
		// Assert the Answer box is visible empty
		waitThread(1000);
		click(tsw.quest_1_wizard);

		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		Assert.assertEquals(getText(tsw.answer_bx), "");

		// Click Answer box
		waitThread(1000);
		click(tsw.answer_bx);

		// Enter the answer for first answer
		type(tsw.answer_bx, "Answer1");

		driver.switchTo().defaultContent();

		// Assert save button enabled
		Assert.assertFalse(getAttribute(tsw.save_btn_test, "class").contains("disabled-btn"));

		// Assert the My answer is incomplete checkbox text visible
		Assert.assertEquals(getText(tsw.answer_incompl_txt), "My Answer is Incomplete");
		Assert.assertTrue(isDisplayed(tsw.incomp_txt_checkbx), "Checkbox not present");

		// Click Save button
		click(tsw.save_btn_test);

		waitFor(QP.toaster);
		// Assert toaster "Answer saved"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		// Assert the green tick in the first question wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("complete"));

		// Assert the tooltip "Answered"
		MouseHover(tsw.quest_1_wizard);

	}

	/*
	 * To check the incomplete status on wizard
	 */
	@Test(priority = 30)
	public void TCSPR1200230() {
		// Click Answer box
		driver.switchTo().frame("answer_ifr");
		waitThread(3000);

		// Doubleclick(tsw.answer_bx);
		driver.findElement(By.xpath("//*[@data-id='answer']")).clear();

		// Edit the answer for first question
		type(tsw.answer_bx, "answeredited");

		driver.switchTo().defaultContent();

		// Assert My answer is incomplete checkbox
		Assert.assertTrue(isDisplayed(tsw.incomp_txt_checkbx), "Checkbox not present");

		// Tick the checkbox
		click(tsw.incomp_txt_checkbx);

		// Assert the check box is checked
		Assert.assertTrue(getAttribute(tsw.check_bx_checked, "class").contains("checked"));

		// Click Save&Next button
		click(QP.Savenext);

		// Assert toaster "Answer saved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		// Assert the Wizard status of first question as "Incomplete Answer"
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("incomplete"));
	}

	/*
	 * To check the unanswered status on Wizard
	 */
	@Test(priority = 31)
	public void TCSPR1200231() {
		// Assert the Second Question is selected on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("p-highlight"));

		// Assert Save button is disabled
		Assert.assertTrue(getAttribute(tsw.save_btn_test, "class").contains("disabled-btn"));

		// Assert the save&Next button enabled
		Assert.assertFalse(getAttribute(QP.savenext_btn, "class").contains("disabled-btn"));

		// Assert the answer box of second question is empty
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		Assert.assertEquals(getText(tsw.answer_bx), "");
		driver.switchTo().defaultContent();

		// Click 4th question on Wizard
		click(tsw.quest_4_wizard);

		// Assert the status on second question as "Unanswered"
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("visitednotattended"));

		// Assert the save&Next button disabled
		Assert.assertTrue(getAttribute(QP.savenext_btn, "class").contains("disabled-btn"));

	}

	/*
	 * To check the submit button & confirmation popup of incomplete & skipped
	 * answers
	 */
	@Test(priority = 32)
	public void TCSPR1200232() {
		// Assert the submit button
		Assert.assertTrue(isDisplayed(tsw.submit_btn), "Submit button not present");

		waitThread(1000);
		// Click submit button
		click(tsw.submit_btn);
		waitThread(1000);
		// Assert confirmationn popup visible
		Assert.assertTrue(isDisplayed(tsw.confir_popup), "popup not visible");

		// Assert the text "There are incomplete answers/skipped questions, do
		// you want
		// to proceed ?"
		Assert.assertEquals(getText(tsw.confirmation_txt),
				"There are incomplete answers/skipped questions, do you want to proceed ?");

		// Assert the cancel & submit button on popup
		Assert.assertTrue(isDisplayed(tsw.cancel_confi), "Cancel button not present");
		Assert.assertEquals(getText(tsw.cancel_confi), "Cancel");
		Assert.assertTrue(isDisplayed(tsw.submit_confi), "Submit button not present");
		Assert.assertEquals(getText(tsw.submit_confi), "Submit");

		// Click cancel
		click(tsw.cancel_confi);

		waitThread(3000);
		// Assert no popup visible
		Assert.assertFalse(isElementPresent(tsw.confir_popup), "popup visible");
	}

	/*
	 * To check the submit button & confirmation popup of incomplete answer
	 */
	@Test(priority = 33)
	public void TCSPR1200233() {

		// Click second question on wizard
		click(tsw.quest_2_wizard);

		// Enter answer for second question
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer2");
		driver.switchTo().defaultContent();

		// Click Save &Next button
		click(QP.savenext_btn);

		// Assert the toaster "Answer saved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		// Enter answer 3
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer3");
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Save &Next button
		click(QP.savenext_btn);

		// Enter answer 4
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer4");
		driver.switchTo().defaultContent();

		// Click Save button
		click(tsw.save_btn_test);

		// Assert toaster "Answer saved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		waitThread(2000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(3000);
		// Assert confirmationn popup visible
		Assert.assertTrue(isDisplayed(tsw.confir_popup), "popup not visible");

		// Assert the text "You have marked 1 answer(s) as incomplete! Proceed
		// to
		// submit?"
		Assert.assertEquals(getText(tsw.confirmation_txt),
				"You have marked 1 answer(s) as incomplete! Proceed to submit?");

		// Click cancel
		click(tsw.cancel_confi);

		waitThread(3000);
		// Assert no popup visible
		Assert.assertFalse(isElementPresent(tsw.confir_popup), "popup visible");
	}

	/*
	 * To complete all answer and check the confirmation popup
	 */
	@Test(priority = 34)
	public void TCSPR1200234() {

		waitThread(3000);
		// Click first question on wizard
		click(tsw.quest_1_wizard);

		waitThread(3000);
		// untick the incomplete answer checkbox
		click(tsw.check_bx_checked);

		waitThread(5000);
		// Click Save button
		click(tsw.save_btn_test);

		// Assert toaster "Answer saved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		waitThread(2000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(2000);
		// Assert confirmationn popup visible
		Assert.assertTrue(isDisplayed(tsw.confir_popup), "popup not visible");

		// Assert the text "Are you sure you want to submit the assessment?"
		Assert.assertEquals(getText(tsw.confirmation_txt), "Are you sure you want to submit the assessment?");

		waitThread(3000);
		// Click submit button
		click(tsw.submit_confi);

		// Assert toaster "Assessment Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

	}

	/*
	 * To check the submit popup
	 */
	@Test(priority = 35)
	public void TCSPR1200235() {

		waitThread(3000);
		// Assert the text "Answers Submitted Successfully"
		Assert.assertEquals(getText(tsw.assess_submitted_text), "Answers Submitted Successfully");

		// Assert the back to Assessments button
		Assert.assertTrue(isDisplayed(tsw.backtoassess_btn), "Back to Assessments button not present");
		Assert.assertEquals(getText(tsw.backtoassess_btn), "Back to Assessments");

		waitThread(2000);
		// click back to Assessments
		click(tsw.backtoassess_btn);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		Doubleclick(st1.stud_searchbx);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		waitThread(3000);
		// Assert the text 4/4 questions completed
		Assert.assertEquals(getText(tsw.ans_count), "4/4");
	}

	/*
	 * To perform Delete Student 2 Account functionality
	 */
	@Test(priority = 36)
	public void TCSPR1200235_DeleteStudent1() {

		waitThread(3000);
		cr.DeleteAccount();

		waitThread(2000);

		// login using deleted account credentials
		lg.login(Emailstudent2, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student2 Account functionality
	 */
	@Test(priority = 37)
	public void TCSPR1200235_DeleteStudent2() {

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
	@Test(priority = 38)
	public void TCSPR1200235_DeleteTeacher() {

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
