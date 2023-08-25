package TestWindowOfIndividualStudent;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
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
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import NewAssessmentOfTeacherPage.TeacherResultSectionPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class ModifyWizardSectionTest extends basePage {

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
	CommonMethods cm = new CommonMethods();
	ModifyWizardSectionPage ms = new ModifyWizardSectionPage();
	CommonFileTest cmt = new CommonFileTest();
	SignUpPage sp = new SignUpPage();
	EncryptedText et = new EncryptedText();
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
	public String Question1 = "Question1";
	public String Question2 = "Question2";
	public String Question3 = "Question3";
	public String Emailstudent1;
	public String Emailstudent2;

	/*
	 * To perform Login functionality
	 */
	@Test(priority = 1)
	public void TCSPR1200501() throws SQLException {

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
	public void TCSPR1200502() throws SQLException {
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
	public void TCSPR1200503() {

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
	public void TCSPR1200504() throws SQLException {

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
	public void TCSPR1200505() {

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
	public void TCSPR1200506() throws SQLException {

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
	public void TCSPR1200507() {

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
	public void TCSPR1200508() {

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
		waitThread(7000);
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
	 * To fill details on the Question page
	 */
	@Test(priority = 9)
	public void TCSPR1200509() {

		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question1");

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
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 10)
	public void TCSPR1200510() {

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

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "3");
		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully");

		click(QP.toasterclosebtn);

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 11)
	public void TCSPR1200511() {

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

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

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

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");
	}

	/*
	 * To verify the details on the peer review page
	 */
	@Test(priority = 12)
	public void TCSPR1200512() {

		waitThread(2000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

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

	@Test(priority = 13)
	public void TCSPR1200513() {

		// Type peer review reward score
		type(pr.PRreward_txtbox, "30");
		waitThread(1000);

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

		// // Select the Test Window open date
		// click(sb.assessmentopendate_txtbx);
		// waitThread(1000);
		//
		// // Assert calender visible
		// Assert.assertTrue(isElementPresent(sb.assessopen_calendar), "Calendar
		// not prsent");
		//
		// Doubleclick(sb.calanderdate_val);
		// waitThread(3000);
		//
		// click(sb.assessmentopentime_txtbx);
		// waitThread(2000);
		//
		// Doubleclick(an.timeascarrow);
		// waitThread(1000);
		// Doubleclick(tp.timedes_arrow);
		// waitThread(2000);

		// Read date and time
		assessmentopendate = getValue(sb.assessmentopendate_txtbx);
		assessmentopentime = getValue(sb.assessmentopentime_txtbx);
		assessmentduedate = getValue(sb.assessmentduedate_txtbx);
		assessmentduetime = getValue(sb.assessmentduetime_txtbx);

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		// Click on save and next button
		click(pr.savennext_button);
		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");
		// Assert the label assessment name,

	}

	/*
	 * To verify the details on the Summary page & publish the Assessment
	 */
	@Test(priority = 14)
	public void TCSPR1200514() {

		waitThread(2000);
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

		waitThread(2000);

	}

	/*
	 * To perform Assessment publish functionality
	 */
	@Test(priority = 15)
	public void TCSPR1200515() {

		// Click on Back to menu button
		click(ap.Backtomenu_btn);

		waitThread(2000);

		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(ap.publish_popup), "popup not visible");

		// Assert the Current Assessment is selected
		Assert.assertEquals(getAttribute(ap.currentassess_tab, "aria-selected"), "true");

		// search assessment
		type(tp.search_box, AssessmentName);
		waitThread(7000);

		// Assert the new assessment card visible
		Assert.assertTrue(isElementPresent(tp.newcard), " new assessment card not visible");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(tp.newasses_lbl), AssessmentName);
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseName.trim()));
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseID));

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 16)
	public void TCSPR1200516() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * To perform Login functionality of student1 profile and check the
	 * Assessment card
	 */
	@Test(priority = 17)
	public void TCSPR1200517() {

		waitThread(1000);

		lg.login1(Emailstudent1, password);

		waitThread(11000);

		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		// driver.findElement(By.id("searchAssessmentFilter")).sendKeys(" ");
		waitThread(7000);

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
	 * To begin the test & check the labels of test window
	 */
	@Test(priority = 18)
	public void TCSPR1200518() throws InterruptedException {

		// wait for 1 min
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(50);
		// Assert the begin test
		Assert.assertTrue(isElementPresent(sa.begintest_btn), "Button not present");

		// click begin test
		click(sa.begintest_btn);
		waitThread(5000);

		// Assert the Assessment name
		Assert.assertEquals(getText(ms.test_window_assess_name), AssessmentName);

		// Assert the coursename, id, Teacher name on the test window
		Assert.assertTrue(getText(ms.course_name_id).contains(CourseName.trim()));
		Assert.assertTrue(getText(ms.course_name_id).contains(CourseID));

		Assert.assertTrue(getText(ms.teach_name_testwindow).contains(Teachername));

		waitThread(2000);

	}

	/*
	 * To add answer to the questions and check the functions of save button
	 */
	@Test(priority = 19)
	public void TCSPR1200519() {

		// Assert the first question is selected on wizard
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer1
		type(an.ansplaceholder, "Answer 1");

		driver.switchTo().defaultContent();

		ScrollTo_xy_position(0, -250);
		waitThread(2000);
		// Click Save button
		click(an.saveNext_btn);
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		// Assert the first question marks as green
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-paginator-complete"));

	}

	/*
	 * To check the incomplete status on wizard
	 */
	@Test(priority = 20)
	public void TCSPR1200520() {

		// Assert the first question is selected on wizard
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer1
		type(an.ansplaceholder, "Answer 2");

		driver.switchTo().defaultContent();

		ScrollTo_xy_position(0, -250);
		waitThread(1000);

		click(ms.incomp_txt_checkbx);
		waitThread(1000);
		// Click Save button
		click(an.saveNext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		// Assert the first question marks as green
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-paginator-complete"));
	}

	/*
	 * To check the submit button & confirmation popup of incomplete & skipped
	 * answers
	 */
	@Test(priority = 21)
	public void TCSPR1200521() {

		click(ms.submit_btn);
		waitThread(1000);

		// Assert confirmation popup visible
		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");

		// Assert the text "Are you sure you want to submit the assessment?"
		Assert.assertEquals(getText(ms.confirmation_txt),
				"There are incomplete answers/skipped questions, do you want to proceed ?");

		// Click submit button
		click(ms.submit_confi);

		// Assert toaster "Assessment Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		waitThread(1000);
		// click back to Assessments
		click(ms.backtoassess_btn);
		waitThread(10000);
		type(sa.stud_searchbx, AssessmentName);
		waitThread(8000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

	}

	/*
	 * To check the details on the modify window page
	 */
	@Test(priority = 22)
	public void TCSPR1200522() {

		// click modify test
		click(ms.modify_btn);
		waitThread(5000);

		// Assert the Assessment name
		Assert.assertEquals(getText(ms.test_window_assess_name), AssessmentName);

		// Assert the coursename, id, Teacher name on the test window
		Assert.assertTrue(getText(ms.course_name_id).contains(CourseName.trim()));
		Assert.assertTrue(getText(ms.course_name_id).contains(CourseID));

		Assert.assertTrue(getText(ms.teach_name_testwindow).contains(Teachername));

		waitThread(2000);

	}

	/*
	 * To check the buttons of Test window
	 */
	@Test(priority = 23)
	public void TCSPR1200523() {

		// Assert the total Questions, Total score
		Assert.assertTrue(getText(ms.questions_count).contains("Total Questions"));
		Assert.assertTrue(getText(ms.total_score).contains("Total Score"));

		// Assert the Buttons Save&Next, Save&Exit, Submit
		Assert.assertTrue(isElementPresent(ms.next_btn), "Next Question button not present");
		Assert.assertEquals(getText(ms.next_btn), "Next Question");

		Assert.assertTrue(isElementPresent(ms.submit_btn), "Submit button not present");
		Assert.assertEquals(getText(ms.submit_btn), "Submit");

		Assert.assertTrue(isElementPresent(ms.discard_btn), "Discard button not present");
		Assert.assertEquals(getText(ms.discard_btn), "Discard");

		// Assert the max score of question1 with question page
		Assert.assertEquals(getText(ms.max_score_txt), "Max Score: 3");

	}

	/*
	 * To check the answer details on the modify window
	 */
	@Test(priority = 24)
	public void TCSPR1200524() {

		// Assert the first question is selected on wizard
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

		// Assert the first question completed from wiard
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-paginator-complete"));

		waitThread(1000);

		// click second question
		click(an.ques2_lbl);
		waitThread(2000);

		// Assert the second question is in complete
		Assert.assertTrue(getAttribute(ms.incomp_txt_checkbx2, "class").contains("p-checkbox-checked"));

		// Assert the second question is incomplete from wiard
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-paginator-incomplete"));

	}

	/*
	 * To check the answer details on the modify window
	 */
	@Test(priority = 25)
	public void TCSPR1200525() {

		// click Third question
		click(an.ques3_lbl);

		// Assert the third question is selected on wizard
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Assert the Answer for question3 window is empty
		Assert.assertEquals(getText(an.ansplaceholder), "");
		driver.switchTo().defaultContent();
		waitThread(1000);

		// Assert the 3rd question is not attended
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-paginator-visitednotattended"));

	}

	/*
	 * To check the Discard Button functionality without save the changes
	 */
	@Test(priority = 26)
	public void TCSPR1200526() {

		// Enter second answer
		SwitchFrame("answer_ifr");
		waitThread(2000);
		type(an.ansplaceholder, "Answer 3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Click course tab
		click(ms.discard_btn);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(an.alertbox), "popup  visible");

		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

	}

	/*
	 * To check the answer details on the modify window
	 */
	@Test(priority = 27)
	public void TCSPR1200527() {

		type(sa.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// click begin test
		click(sa.begintest_btn);
		waitThread(1000);
		// Assert the Assessment name
		Assert.assertEquals(getText(ms.test_window_assess_name), AssessmentName);

		// Assert the first question is selected on wizard
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

	}

	/*
	 * To check the Next Question functionality on the wizrad panel
	 */
	@Test(priority = 28)
	public void TCSPR1200528() {

		click(ms.next_btn);
		waitThread(1000);
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));

		// Enter Answer 2
		SwitchFrame("answer_ifr");
		waitThread(1000);
		type(an.ansplaceholder, "Answer two");

		driver.switchTo().defaultContent();
		waitThread(1000);

		click(ms.next_btn);
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		waitThread(2000);

		// Assert.assertTrue(getAttribute(an.ques2_lbl,
		// "class").contains("p-paginator-incomplete"));
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));

	}

	/*
	 * To check the discard button functionality on the modify window page
	 */
	@Test(priority = 29)
	public void TCSPR1200529() {
		MouseHover(ms.discard_btn);

		click(ms.discard_btn);
		waitThread(2000);
		// Assert confirmation popup visible
		Assert.assertTrue(isElementPresent(an.cof_popup), "popup not visible");
		Assert.assertTrue(isElementPresent(ms.cancel_confi), "Button not visible");
		Assert.assertTrue(isElementPresent(ms.yes_btn), "Button not visible");

		Assert.assertEquals(getText(ms.conf_lbl),
				"Do you want to discard the changes made and exit the answer window?");
		waitThread(2000);
		click(ms.cancel_confi);

		waitThread(2000);
		Assert.assertFalse(isElementPresent(an.cof_popup), "popup not visible");
		waitThread(2000);
		click(ms.discard_btn);

		waitThread(2000);
		click(ms.yes_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Assessment Discarded");

		click(QP.toasterclosebtn);
		waitThread(5000);

		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		waitThread(4000);
	}

	/*
	 * TO check that the discarded change not visible on the modify page
	 */
	@Test(priority = 30)
	public void TCSPR1200530() {

		waitThread(7000);
		waitThread(1000);
		type(sa.stud_searchbx, AssessmentName);
		waitThread(7000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// click modify test
		click(ms.modify_btn);
		waitThread(5000);

		// Assert the Assessment name
		Assert.assertEquals(getText(ms.test_window_assess_name), AssessmentName);

		// Assert the first question is selected on wizard
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));
		click(ms.next_btn);
		waitThread(1000);

		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));

		// Enter Answer 2
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Assert first question is empty
		Assert.assertTrue(getText(an.ansplaceholder).contains("Answer 2"));

		driver.switchTo().defaultContent();
		waitThread(1000);

		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-paginator-incomplete"));
	}

	/*
	 * To check the submit button & confirmation popup of incomplete answer
	 */
	@Test(priority = 31)
	public void TCSPR1200531() {

		click(ms.next_btn);
		waitThread(1000);
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));

		// Enter Answer 2
		SwitchFrame("answer_ifr");
		waitThread(1000);
		// Enter Answer1
		type(an.ansplaceholder, "Answer 3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		click(ms.incomp_txt_checkbx);
		waitThread(1000);

		Assert.assertTrue(getAttribute(ms.incomp_txt_checkbx2, "class").contains("p-checkbox-checked"));

		waitThread(5000);

		click(an.ques1_lbl);
		waitThread(4000);

		click(ms.incomp_txt_checkbx);

		Assert.assertTrue(getAttribute(ms.incomp_txt_checkbx2, "class").contains("p-checkbox-checked"));

		click(ms.submit_btn);
		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");
		Assert.assertTrue(isElementPresent(ms.cancel_confi), "Button visible");
		Assert.assertTrue(isElementPresent(ms.submit_confi), "Button visible");

		// Assert the text "You have 4 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(ms.confirmation_txt),
				"You have marked 3 answer(s) as incomplete! Proceed to submit?");

		waitThread(1000);
		// Click cancel
		click(ms.cancel_confi);

		waitThread(3000);
		// Assert no popup visible
		Assert.assertFalse(isElementPresent(ms.confir_popup), "popup visible");

	}

	/*
	 * To complete all answer and check the confirmation popup
	 */
	@Test(priority = 32)
	public void TCSPR1200532() {

		// Click first question on wizard
		click(an.ques1_lbl);
		waitThread(1000);
		// Assert the first question is selected on wizard
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

		waitThread(2000);
		// Untick the incomplete answer checkbox
		click(ms.incomp_txt_checkbx);

		waitThread(2000);
		// Assert the checkbox is unchecked
		Assert.assertFalse(getAttribute(ms.incomp_txt_checkbx2, "class").contains("p-checkbox-checked"));

		// Click on Next question button
		click(ms.next_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		// Assert the 2nd question is selected on wizard
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));

		// Untick the incomplete answer checkbox
		click(ms.incomp_txt_checkbx);

		waitThread(1000);
		// Assert the checkbox is unchecked
		Assert.assertFalse(getAttribute(ms.incomp_txt_checkbx, "class").contains("p-checkbox-checked"));

		click(ms.next_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		// Assert the 3rd question is selected on wizard
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));

		// Untick the incomplete answer checkbox
		click(ms.incomp_txt_checkbx);

		waitThread(1000);
		// Assert the checkbox is unchecked
		Assert.assertFalse(getAttribute(ms.incomp_txt_checkbx, "class").contains("p-checkbox-checked"));

		click(ms.submit_btn);
		waitThread(1000);
		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");

		// Assert the text Are you sure you want to submit the assessment?
		Assert.assertEquals(getText(ms.confirmation_txt), "Are you sure you want to submit the assessment?");

		click(ms.submit_confi);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

	}

	/*
	 * To check the submit button & confirmation popup of skipped answers
	 */
	@Test(priority = 33)
	public void TCSPR1200533() {

		// Assert the text "You have 4 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(ms.popup_txt), "You can also modify the answers later within the due date.\n"
				+ "You cannot make any modifications once the due date has expired.");

		// Click on Back to Assessment
		click(ms.backtoassess_btn);

		waitThread(2000);
		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		type(sa.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// Click on Modify Submitted Test Button
		click(ms.modify_btn);
		waitThread(1000);
		// Click first question on wizard
		click(an.ques1_lbl);
		waitThread(1000);

		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Clear the first answer
		click(an.ansplaceholder);
		driver.findElement(By.xpath(an.ansplaceholder)).clear();

		// Assert the Answedr window is empty
		Assert.assertEquals(getText(an.ansplaceholder), "");

		driver.switchTo().defaultContent();
		waitThread(3000);

		// Click on Next question button
		click(ms.next_btn);

		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		waitThread(6000);
		// Click first question on wizard
		click(an.ques2_lbl);
		waitThread(1000);

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));
		waitThread(1000);
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Clear the second answer
		Doubleclick(an.ansplaceholder);

		driver.findElement(By.xpath(an.ansplaceholder)).clear();
		waitThread(4000);
		driver.findElement(By.xpath(an.ansplaceholder)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(an.ansplaceholder)).sendKeys(Keys.ENTER);
		// Assert the Answedr window is empty
		Assert.assertEquals(getText(an.ansplaceholder), "");

		driver.switchTo().defaultContent();
		waitThread(3000);

		// Click on Next question button
		click(ms.next_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);
		waitThread(2000);
		click(an.ques3_lbl);
		waitThread(1000);

		// Assert the 3rd question is selcted
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Clear the 3rd answer
		click(an.ansplaceholder);
		driver.findElement(By.xpath(an.ansplaceholder)).clear();
		waitThread(3000);
		// Assert the Answedr window is empty
		Assert.assertEquals(getText(an.ansplaceholder), "");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// click submit button
		click(ms.submit_btn);
		waitThread(1000);
		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");

		// Assert the text "You have 3 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(ms.confirmation_txt), "You have 3 skipped question(s)! Proceed to submit?");

		click(ms.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Assessment Submitted"
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);
	}

	/*
	 * To check the Test submit popup functionality
	 */
	@Test(priority = 34)
	public void TCSPR1200534() {

		// Assert the text "You have 4 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(ms.popup_txt), "You can also modify the answers later within the due date.\n"
				+ "You cannot make any modifications once the due date has expired.");

		// Click on Back to Assessment
		click(ms.backtoassess_btn);

		waitThread(2000);
		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		type(sa.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// Assert the test completed count is 0/3
		Assert.assertEquals(getText(ms.compcount), "0/3");

	}

	/*
	 * To check the Discard Pop up functionality while My courses tab switching
	 */
	@Test(priority = 35)
	public void TCSPR1200535() {

		// Click on Modify Submitted Test Button
		click(ms.modify_btn);
		waitThread(1000);

		// Assert the Assessment name
		Assert.assertEquals(getText(ms.test_window_assess_name), AssessmentName);

		// Assert the first question is selected on wizard
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

		// Enter Answer 1
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer1
		type(an.ansplaceholder, "Answer 1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Click course tab
		click(an.coursetab);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(an.alertbox), "popup not visible");

		// Assert the text
		Assert.assertEquals(getText(ms.alert_txt), "Are you certain you want to proceed with your action?\n"
				+ "Any changes that you have made will not be saved.");

		// Click on Cancel button
		click(an.alertcancel_btn);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(an.alertbox), "popup not visible");

		// Click course tab
		click(an.coursetab);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(an.alertbox), "popup not visible");

		click(an.alertdisc_btn);
		waitThread(1000);

		// verify heading label enrolled courses
		waitFor(sa.enrolledcourse_lbl);
		Assert.assertEquals(getText(sa.enrolledcourse_lbl), "Enrolled Courses");

	}

	/*
	 * To check the Answer on the first question
	 */
	@Test(priority = 36)
	public void TCSPR1200536() {

		// Click Assessment tab
		click(QP.Assessmenttab);

		waitThread(3000);

		type(sa.stud_searchbx, AssessmentName);
		// type(sa.stud_searchbx, " ");
		waitThread(3000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// Assert the test completed count is 0/3
		Assert.assertEquals(getText(ms.compcount), "0/3");

		// Click on Modify Submitted Test Button
		click(an.resumetest_btn);

		// Assert the question 1 is selected
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Clear the second answer
		click(an.ansplaceholder);

		// Assert the Answedr window is empty
		Assert.assertEquals(getText(an.ansplaceholder), "");

		driver.switchTo().defaultContent();
		waitThread(1000);

	}

	/*
	 * To check the Discard Pop up functionality while Assessment tab switching
	 */
	@Test(priority = 37)
	public void TCSPR1200537() {

		// Type Answer 1
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer1
		type(an.ansplaceholder, "Answer 1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Click Assessment tab
		click(QP.Assessmenttab);
		waitThread(1000);
		// Assert confirmation popup visible
		Assert.assertTrue(isElementPresent(an.alertbox), "popup not visible");

		// Click Cancel button
		click(an.alertcancel_btn);

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Assert the enter content visible on the answer box
		Assert.assertEquals(getText(an.ansplaceholder), "Answer 1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Click Assessment tab
		click(QP.Assessmenttab);

		Assert.assertTrue(isElementPresent(an.alertbox), "popup not visible");

		// Click Discard button
		click(an.alertdisc_btn);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(an.alertbox), "popup not visible");

	}

	/*
	 * To check the Answer on the first question
	 */
	@Test(priority = 38)
	public void TCSPR1200538() {

		// Search the Assessment Name
		type(sa.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// Assert the test completed count is 0/3
		Assert.assertEquals(getText(ms.compcount), "0/3");

		// Click on Modify Submitted Test Button
		click(ms.modify_btn);

		// Assert the question 1 is selected
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

		// Assert the Answer 1 textbox having no data
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Assert the Answedr window is empty
		Assert.assertEquals(getText(an.ansplaceholder), "");

		driver.switchTo().defaultContent();
		waitThread(1000);

	}

	/*
	 * To check the Test submit popup functionality
	 */
	@Test(priority = 39)
	public void TCSPR1200539() {

		// Click on Submit button
		click(ms.submit_btn);

		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");

		click(ms.submit_confi);

		waitFor(QP.toaster);
		// Assert toaster Assessment Submitted
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		// Click on Back to Assessment
		click(ms.backtoassess_btn);

		waitThread(1000);
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		type(sa.stud_searchbx, AssessmentName);
		// type(sa.stud_searchbx, " ");
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// Assert the test completed count is 0/3
		Assert.assertEquals(getText(ms.compcount), "0/3");

	}

	/*
	 * To perform logout functionality on the student profile
	 */
	@Test(priority = 40)
	public void TCSPR1200540() {

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
	@Test(priority = 41)
	public void TCSPR1200541() {

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
	@Test(priority = 42)
	public void TCSPR1200542_DeleteTeacher() {

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
