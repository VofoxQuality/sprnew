package TestWindowOfIndividualStudent;

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
import CreateNewAssessment.Pages.AssessmentPublishPopupPage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.BasicDetailsPageCourseandEditorPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionEditorAndMultipleCategoryAddPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.AssessmentStatusPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import NewAssessmentOfTeacherPage.TeacherResultSectionPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class AnswerWindowTest extends basePage {

	SignUpPage sp = new SignUpPage();
	LoginPage lg = new LoginPage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	Databaseconnection dc = new Databaseconnection();
	CourseRosterPage cr = new CourseRosterPage();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	SchedulePageBasicsPage sb = new SchedulePageBasicsPage();
	AssessmentPublishPopupPage ap = new AssessmentPublishPopupPage();
	TeacherPeerReviewSectionPage tp = new TeacherPeerReviewSectionPage();
	TeacherResultSectionPage tr = new TeacherResultSectionPage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	BasicDetailsPageCourseandEditorPage be = new BasicDetailsPageCourseandEditorPage();
	QuestionEditorAndMultipleCategoryAddPage QE = new QuestionEditorAndMultipleCategoryAddPage();
	StudentAssessmentInfoAndInstructionPage sa = new StudentAssessmentInfoAndInstructionPage();
	AnswerWindowPage an = new AnswerWindowPage();
	EncryptedText et = new EncryptedText();
	CommonMethods cm = new CommonMethods();
	AssessmentStatusPage as = new AssessmentStatusPage();
	CommonFileTest cmt = new CommonFileTest();

	public String AssessmentName;
	public String NewAssessmentName;
	public String newAssessmentName;
	public String newAssessmentNameone;
	public String Assessmentinfo;
	public String Assessmentinstruction;
	public String Emailteacher;
	public String CourseNamenew;
	public String CourseID1;
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
	public String CourseID;
	public String CourseName;

	/*
	 * To perform Login functionality
	 */
	@Test(priority = 1)
	public void TCSPR1200301() throws SQLException {

		Emailteacher = cmt.SignUpTeacher();

		// To catch OTP from sending Resource
		cmt.OtpFetch();

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	public String Emailstudent1;
	public String Emailstudent2;

	/*
	 * To create new course
	 */
	@Test(priority = 2)
	public void TCSPR1200302() throws SQLException {

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
	public void TCSPR1200303() {

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
	public void TCSPR1200304() throws SQLException {

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
	public void TCSPR1200305() {

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
	public void TCSPR1200306() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent2, CourseID);

		String encText = et.EncryptCode(studentinviteid);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname2 = "Ben";
		Studentlastname2 = "Max";
		Studentname2 = Studentfirstname2 + " " + Studentlastname2;
		waitThread(5000);
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
	public void TCSPR1200307() {

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
	@Test(priority = 8)
	public void TCSPR1200308() {

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
		waitThread(2000);
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
	 * To fill details on theQuestion page
	 */
	// public String ImageURL =
	// "http://192.168.7.108/SPRAPIQA/Files/Assessment/619dbf63c0429e0d15787b61/73b15af5-4d23-4d99-9690-ae509df4fc07.png";
	//
	// public String VideoURL =
	// "http://192.168.7.108/SPRAPIQA/Files/Assessment/619dbeddc0429e0d15787b5f/86d56375-b977-4156-a2e5-10a5c9f1812d.mp4";

	@Test(priority = 9)
	public void TCSPR1200309() {

		SoftAssert softAssert22 = new SoftAssert();

		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question1");
		driver.switchTo().defaultContent();
		waitThread(1000);

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
		type(QP.max_scorbx, "3");
		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");

		click(QP.toasterclosebtn);

	}

	/*
	 * To add more questions to questions page
	 */
	@Test(priority = 10)
	public void TCSPR1200310() {

		// Click on +button
		click(an.add_quest_btn);
		waitThread(1000);
		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question2");
		driver.switchTo().defaultContent();
		waitThread(1000);

		driver.switchTo().defaultContent();

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

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
		type(QP.max_scorbx, "3");
		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully");

		click(QP.toasterclosebtn);

		// Click on +button
		click(an.add_quest_btn);
		waitThread(1000);
		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question3");
		driver.switchTo().defaultContent();
		waitThread(1000);

		driver.switchTo().defaultContent();

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "3");
		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 3 Saved successfully");

		click(QP.toasterclosebtn);

		waitThread(2000);
		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		waitThread(2000);
		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	/*
	 * To verify the details on the peer review page
	 */
	@Test(priority = 11)
	public void TCSPR1200311() {

		waitThread(3000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		waitThread(2000);
		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));
	}

	public String assessmentopendate;
	public String assessmentopentime;
	public String assessmentduedate;
	public String assessmentduetime;

	public String peerreviewopendate;
	public String peerreviewopentime;
	public String peerreviewduedate;
	public String peerreviewduetime;
	public String resultpublishdate;
	public String resultpublishtime;
	public String lastdateforrecon;
	public String lasttimeforrecon;
	/*
	 * To perform the save and next functionaity from peer review page and
	 * verify the schedule page details
	 */

	@Test(priority = 12)
	public void TCSPR1200312() {

		type(pr.PRreward_txtbox, "50");
		waitThread(3000);

		click(pr.savennext_button);
		waitThread(2000);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);

		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");

		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.Sbassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseName.trim()));

		// Read date and time
		assessmentopendate = getValue(sb.assessmentopendate_txtbx);
		assessmentopentime = getValue(sb.assessmentopentime_txtbx);
		assessmentduedate = getValue(sb.assessmentduedate_txtbx);
		assessmentduetime = getValue(sb.assessmentduetime_txtbx);

		peerreviewopendate = getValue(sb.peerreviewopendate_txtbx);
		peerreviewopentime = getValue(sb.peerreviewopentime_txtbx1);
		peerreviewduedate = getValue(sb.peerreviewduedate_txtbx);
		peerreviewduetime = getValue(sb.peerreviewduetime_txtbx);

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		// Click on save and next button
		click(pr.savennext_button);
		waitThread(3000);

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");
		// Assert the label assessment name,

	}

	/*
	 * To verify the details on the Summary page & publish the Assessment
	 */
	@Test(priority = 13)
	public void TCSPR1200313() {

		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");
		// Assert the label assessment name,

	}

	/*
	 * To perform Assessment publish functionality
	 */
	@Test(priority = 14)
	public void TCSPR1200314() {

		// click release button
		click(ap.relese_btn);
		waitFor(QP.toaster);

		// Assert the toaster "Assessment published successfully "
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");

		click(QP.toasterclosebtn);

		// Assert the popup visible
		Assert.assertTrue(isElementPresent(ap.publish_popup), "popup not visible");

		// Assert toaster "Assessment published successfully
		Assert.assertEquals(getText(ap.Assessmentcreated_lbl), "Assessment Created Successfully");

		// Assert button Back to Menu
		Assert.assertTrue(isElementPresent(ap.Backtomenu_btn), "button not visible");

	}

	/*
	 * To check the published Assessment card
	 */
	@Test(priority = 15)
	public void TCSPR1200315() {

		// Click on Back to menu button
		click(ap.Backtomenu_btn);

		waitThread(2000);

		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(ap.publish_popup), "popup not visible");

		// Assert the Current Assessment is selected
		Assert.assertEquals(getAttribute(ap.currentassess_tab, "aria-selected"), "true");

		// search assessment
		type(tp.search_box, AssessmentName);
		waitThread(4000);

		// Assert the new assessment card visible
		Assert.assertTrue(isElementPresent(tp.newcard), " new assessment card not visible");

	}

	/*
	 * To check the test section of Assessment card
	 */
	@Test(priority = 16)
	public void TCSPR1200316() {

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(tp.newasses_lbl), AssessmentName);
		Assert.assertEquals(getText(tp.course_lbl), "For " + CourseName.trim() + " (" + CourseID + ")");
		// Assert.assertEquals(getText(tp.course_lbl),CourseID);

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 17)
	public void TCSPR1200317() {

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
	public void TCSPR1200318() {

		waitThread(1000);

		lg.login1(Emailstudent1, password);

		waitThread(3000);
		// Click Assessment tab
		click(QP.Assessmenttab);
		waitThread(3000);
		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(sa.Assess_name_card), AssessmentName);
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseName.trim()));
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseID));

		// Assert the teacher name
		Assert.assertTrue(getText(sa.teachername_card).contains(Teachername));

	}

	/*
	 * To begin the test and to check the confirmation popup when switching to
	 * next questions
	 */
	@Test(priority = 19)
	public void TCSPR1200319() throws InterruptedException {
		// Wait till Test active
		TimeUnit.MINUTES.sleep(1);
		// Wait till peer review active
		TimeUnit.SECONDS.sleep(30);
		// Assert the begin test
		Assert.assertTrue(isElementPresent(sa.begintest_btn), "Button not present");
		// click begin test
		click(sa.begintest_btn);
		waitThread(1000);

		// Assert the total number of questions & max score possible
		Assert.assertEquals(getText(an.totalques_lbl), "Total Questions 3");
		Assert.assertEquals(getText(an.totalques_count), "3");
		Assert.assertTrue(getText(an.totalscore_lbl).contains("Total Score"));

		// Assert the question1 is selected on wizard
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

		driver.switchTo().frame("questionView_ifr");
		waitThread(1000);

		Assert.assertEquals(getText(an.quest_box), "Question1");

		driver.switchTo().defaultContent();

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Enter Answer 1
		SwitchFrame("answer_ifr");
		waitThread(1000);
		type(an.ansplaceholder, "Answer 1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Click next question on wizard
		click(an.next_btn);

		// Assert confirmation popup visible
		Assert.assertTrue(isElementPresent(an.cof_popup), "popup not visible");

		// Assert the buttons "Discard&Continue" , "Save&Continue"
		Assert.assertTrue(isElementPresent(an.discard_btn), "Button not visible");
		Assert.assertTrue(isElementPresent(an.contin_btn), "Button not visible");

		// Click Discard & continue
		click(an.discard_btn);
		waitThread(2000);

		// Assert the second question selected on wizard
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));

		// click first Question
		click(an.ques1_lbl);
		waitThread(1000);
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Assert first question is empty
		Assert.assertEquals(getText(an.ansplaceholder), "");

	}

	/*
	 * To check the save&continue functions of confirmation popup
	 */
	@Test(priority = 20)
	public void TCSPR1200320() {

		driver.switchTo().defaultContent();
		waitThread(1000);
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer1
		type(an.ansplaceholder, "Answer 1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Click next question on wizard
		click(an.next_btn);

		// Assert confirmation popup visible
		Assert.assertTrue(isElementPresent(an.cof_popup), "popup not visible");
		waitThread(1000);
		// Click Save & continue
		click(an.contin_btn);

		waitFor(QP.toaster);

		// Assert the toaster "Answer Saved"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		waitThread(1000);

		// Assert the second question selected on wizard
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));

		// click first Question
		click(an.ques1_lbl);
		waitThread(1000);
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Assert first answer content visible
		Assert.assertEquals(getText(an.ansplaceholder), "Answer 1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Assert the answer one wizard is green tick
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-paginator-complete"));

	}

	/*
	 * To check the save button enable functions
	 */
	@Test(priority = 21)
	public void TCSPR1200321() {

		// Click 2nd question
		click(an.ques2_lbl);
		waitThread(1000);

		// Assert save button disabled
		Assert.assertTrue(getAttribute(an.save_btn, "class").contains("disabled-btn"));

		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));

		SwitchFrame("questionView_ifr");
		waitThread(1000);

		Assert.assertEquals(getText(an.quest_box), "Question2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Enter second answer
		SwitchFrame("answer_ifr");
		waitThread(2000);
		type(an.ansplaceholder, "Answer 2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Assert the tooltip of save button
		Assert.assertEquals(getAttribute(an.save_btn, "ptooltip"), "Save");

		// Assert save button enabled
		Assert.assertFalse(getAttribute(an.save_btn, "class").contains("disabled-btn"));
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Clear the second answer
		click(an.ansplaceholder);
		driver.findElement(By.xpath(an.ansplaceholder)).clear();
		driver.switchTo().defaultContent();
		waitThread(4000);

	}

	/*
	 * To check the Resume test part
	 */
	@Test(priority = 22)
	public void TCSPR1200322() {

		// Assert save&Exit button present
		Assert.assertTrue(isElementPresent(an.saveExit_btn), "Button not visible");


		// Click Save&Exit button
		click(an.saveExit_btn);
		waitThread(6000);

		type(sa.stud_searchbx, AssessmentName);
		driver.findElement(By.cssSelector(sa.stud_searchbx)).sendKeys("       ");

		waitThread(2000);
		// Assert the assessment card visible on the page
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(sa.Assess_name_card), AssessmentName);

		Assert.assertTrue(isElementPresent(an.resumetest_btn), "Button not visible");

		// Assert the Resume test visible
		Assert.assertEquals(getText(an.resumetest_btn), "Resume Test");

		// Click Resume test
		click(an.resumetest_btn);

		waitThread(2000);

		// Assert the second question selected on wizard
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));

	}

	/*
	 * To check the course tab switching functionality
	 */
	@Test(priority = 23)
	public void TCSPR1200323() {

		// Enter second answer
		SwitchFrame("answer_ifr");
		waitThread(2000);
		type(an.ansplaceholder, "Answer 2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Click course tab
		click(an.coursetab);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(an.alertbox), "popup not visible");

		click(an.alertdisc_btn);
		waitThread(1000);

		// verify heading label enrolled courses
		waitFor(sa.enrolledcourse_lbl);
		Assert.assertEquals(getText(sa.enrolledcourse_lbl), "Enrolled Courses");

		// Click Assessment tab
		click(QP.Assessmenttab);

		waitThread(3000);
		click(sa.stud_searchbx);
		type(sa.stud_searchbx, AssessmentName);

		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		waitThread(2000);
		// Click Resume test
		click(an.resumetest_btn);

		waitThread(3000);

		// Assert the second question selected on wizard
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Assert the Answedr window is empty
		Assert.assertEquals(getText(an.ansplaceholder), "");
	}

	/*
	 * To check the Assessment tab switching functionality
	 */
	@Test(priority = 24)
	public void TCSPR1200324() {

		driver.switchTo().defaultContent();
		waitThread(3000);

		Doubleclick(an.ques2_lbl);
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));

		waitThread(1000);
		// Enter Answer 2
		SwitchFrame("answer_ifr");
		waitThread(1000);
		type(an.ansplaceholder, "Answer 2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		waitThread(1000);
		// Click Assessment tab
		click(QP.Assessmenttab);

		// Assert confirmation popup visible
		Assert.assertTrue(isElementPresent(an.alertbox), "popup not visible");

		waitThread(1000);
		// Click Cancel button
		click(an.alertcancel_btn);

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Assert the enter content visible on the answer box
		Assert.assertEquals(getText(an.ansplaceholder), "Answer 2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		waitThread(1000);
		// Click Assessment tab
		click(QP.Assessmenttab);
		waitThread(7000);
		Assert.assertTrue(isElementPresent(an.alertbox), "popup not visible");

		// Click Discard button
		click(an.alertdisc_btn);
		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys("    ");
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// Click Resume test
		click(an.resumetest_btn);

		waitThread(1000);
		// Assert the second question selected on wizard
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Assert the answer window is empty
		Assert.assertEquals(getText(an.ansplaceholder), "");

	}

	/*
	 * To check the Next &Prev buttons of Wizard
	 */
	@Test(priority = 25)
	public void TCSPR1200325() {

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Assert the prev&Next button on wizard
		Assert.assertTrue(isElementPresent(an.next_btn), "popup not visible");

		Assert.assertTrue(isElementPresent(an.last_btn), "popup not visible");

		// Assert the second question selected on wizard
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));

		// Click prev button on Wizard
		click(an.last_btn);
		waitThread(2000);
		// Assert the first question is selected on wizard
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Assert the answer1 content visible
		Assert.assertEquals(getText(an.ansplaceholder), "Answer 1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Assert the prev button is disable
		Assert.assertTrue(getAttribute(an.last_btn, "class").contains("p-disabled"));

		// Click Next button on Wizard
		click(an.next_btn);

		// Assert the Second question selected on wizard
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));

	}

	/*
	 * To Add more answers to answer window and give save&exit
	 */
	@Test(priority = 26)
	public void TCSPR1200326() {

		waitThread(2000);
		// Click 2nd question
		click(an.ques2_lbl);
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter second answer
		type(an.ansplaceholder, "Answer 2");

		driver.switchTo().defaultContent();
		waitThread(2000);

		// click save&next button
		click(an.saveNext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer 3
		type(an.ansplaceholder, "Answer 3");

		driver.switchTo().defaultContent();
		waitThread(1000);
		click(an.saveExit_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Assessment Saved"
		Assert.assertEquals(getText(QP.toaster), "Assessment Saved");

		click(QP.toasterclosebtn);
		waitThread(8000);
		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys("   ");
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// Assert the Resume test visible
		Assert.assertTrue(isElementPresent(an.resumetest_btn), "Button not visible");

		Assert.assertEquals(getText(an.resumetest_btn), "Resume Test");

	}

	/*
	 * To check whether the Wizard status & Questions are saved on the test
	 * window when user kept the answers on draft
	 */
	@Test(priority = 27)
	public void TCSPR1200327() {

		waitThread(3000);
		// Click Resume test
		click(an.resumetest_btn);

		waitThread(3000);

		// Assert the Third question selected on wizard
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));

		waitThread(2000);
		// Assert the third answer content visible
		SwitchFrame("answer_ifr");
		waitThread(1000);
		type(an.ansplaceholder, "Answer 3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Assert the first question marks as green
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-paginator-complete"));
		waitThread(1000);
		// Assert the 2nd question marks as green
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-paginator-complete"));

		waitThread(1000);
		// Click first Question
		click(an.ques1_lbl);

		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

		SwitchFrame("answer_ifr");
		waitThread(1000);
		type(an.ansplaceholder, "Answer 1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Click Second question
		click(an.ques2_lbl);

		waitThread(1000);
		// Assert the second answer content visible
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));

	}

	/*
	 * To check whether the removed answer content not visible on the answer box
	 * when click on Save&next button
	 */
	@Test(priority = 28)
	public void TCSPR1200328() {

		// Clear the second answer
		SwitchFrame("answer_ifr");
		waitThread(1000);

		click(an.ansplaceholder);
		driver.findElement(By.xpath(an.ansplaceholder)).clear();
		driver.switchTo().defaultContent();
		waitThread(1000);

		// clickt save &Next button
		click(an.saveNext_btn);
		waitThread(1000);
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));
		waitThread(5000);
		MouseHover(an.ques2_lbl);
		// Click 2nd question
		click(an.ques2_lbl);
		waitThread(5000);
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));
		SwitchFrame("answer_ifr");
		waitThread(1000);
		// Assert the second answer box is empty
		Assert.assertEquals(getText(an.ansplaceholder), "");

		driver.switchTo().defaultContent();
		waitThread(1000);

	}

	/*
	 * To perform Delete Student 1 Account functionality
	 */
	@Test(priority = 29)
	public void TCSPR1200329_DeleteStudent1() {

		waitThread(3000);
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
	@Test(priority = 30)
	public void TCSPR1200330_DeleteStudent2() {

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
	@Test(priority = 31)
	public void TCSPR1200331_DeleteTeacher() {

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