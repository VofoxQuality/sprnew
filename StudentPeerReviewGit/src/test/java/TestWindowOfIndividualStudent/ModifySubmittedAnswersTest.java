package TestWindowOfIndividualStudent;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

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

import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;

import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class ModifySubmittedAnswersTest extends basePage {

	LoginPage lg = new LoginPage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	Databaseconnection dc = new Databaseconnection();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	SchedulePageBasicsPage sb = new SchedulePageBasicsPage();
	AssessmentPublishPopupPage ap = new AssessmentPublishPopupPage();
	TeacherPeerReviewSectionPage tp = new TeacherPeerReviewSectionPage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	BasicDetailsPageCourseandEditorPage be = new BasicDetailsPageCourseandEditorPage();
	StudentAssessmentInfoAndInstructionPage sa = new StudentAssessmentInfoAndInstructionPage();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	AnswerWindowPage an = new AnswerWindowPage();
	ModifyWizardSectionPage ms = new ModifyWizardSectionPage();
	CommonMethods cm = new CommonMethods();
	AssessmentSubmitAndStatusPopUpPage asp = new AssessmentSubmitAndStatusPopUpPage();
	ModifySubmittedAnswersPage ma = new ModifySubmittedAnswersPage();
	CommonFileTest cmt = new CommonFileTest();
	CourseRosterPage cr = new CourseRosterPage();
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
	public String CourseID;
	public String CourseName;
	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";
	public String Question1 = "Question1";
	public String Question2 = "Question2";
	public String Question3 = "Question3";

	/*
	 * To perform Login functionality
	 */
	@Test(priority = 1)
	public void TCSPR1200601() throws SQLException {

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
	public void TCSPR1200602() throws SQLException {

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
	public void TCSPR1200603() {

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
	public void TCSPR1200604() throws SQLException {

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
	public void TCSPR1200605() {

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
	public void TCSPR1200606() throws SQLException {
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
	public void TCSPR1200607() {

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
	public void TCSPR1200608() {
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
		waitThread(2000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(5000);
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
	public void TCSPR1200609() {

		waitThread(3000);

		// Type Question 1
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);

		waitThread(1000);
		type(QP.Quest_box, Question1);

		// Assert the question content on the question editor
		Assert.assertEquals(getText(QP.Quest_box), Question1);
		driver.switchTo().defaultContent();

		// Type data in Standard Rubric box
		driver.switchTo().frame("rubric_ifr");
		waitThread(2000);
		type(QP.std_rub_bx, "R1");

		// Assert the rubic content on the textbox
		Assert.assertEquals(getText(QP.std_rub_bx), "R1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, "2");

		MouseHover(QP.save);

		waitThread(3000);
		// Click on +button
		click(rd.add_quest_btn);
		waitFor(QP.toaster);

		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);
	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 10)
	public void TCSPR1200610() {

		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);

		waitThread(1000);
		type(QP.Quest_box, Question2);

		// Assert the question content on the question editor
		Assert.assertEquals(getText(QP.Quest_box), Question2);
		driver.switchTo().defaultContent();

		// Type data in Standard Rubric box
		driver.switchTo().frame("rubric_ifr");
		waitThread(2000);
		type(QP.std_rub_bx, "R2");

		// Assert the rubic content on the textbox
		Assert.assertEquals(getText(QP.std_rub_bx), "R2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, "4");

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
	 * To fill details on the Question page
	 */
	@Test(priority = 11)
	public void TCSPR1200611() {

		waitThread(3000);

		// Type Question 3
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		waitThread(1000);

		type(QP.Quest_box, Question3);

		// Assert the question content on the question editor
		Assert.assertEquals(getText(QP.Quest_box), Question3);
		driver.switchTo().defaultContent();

		// Type data in Standard Rubric box
		driver.switchTo().frame("rubric_ifr");
		waitThread(2000);
		type(QP.std_rub_bx, "R3");

		// Assert the rubic content on the textbox
		Assert.assertEquals(getText(QP.std_rub_bx), "R3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, "2");

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
	@Test(priority = 12)
	public void TCSPR1200612() {

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
	public void TCSPR1200613() {

		// Type peer review reward score
		type(pr.PRreward_txtbox, "1");
		waitThread(1000);

		click(pr.savennext_button);
		click(QP.toasterclosebtn);

		waitThread(2000);
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
		// peerreviewopentime = getValue(sb.peerreviewopentime_txtbx);
		peerreviewopentime = getValue(sb.peerreviewopentime_txtbx1);
		peerreviewduedate = getValue(sb.peerreviewduedate_txtbx);
		peerreviewduetime = getValue(sb.peerreviewduetime_txtbx);

		// Click on save and next button
		click(pr.savennext_button);
		waitThread(4000);

		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");
		// Assert the label assessment name,

	}

	/*
	 * To verify the details on the Summary page & publish the Assessment
	 */
	@Test(priority = 14)
	public void TCSPR1200614() {

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
	public void TCSPR1200615() {

		// Click on Back to menu button
		click(ap.Backtomenu_btn);

		waitThread(2000);

		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(ap.publish_popup), "popup not visible");

		// Assert the Current Assessment is selected
		Assert.assertEquals(getAttribute(ap.currentassess_tab, "aria-selected"), "true");

		// search assessment
		type(tp.search_box, AssessmentName);
		waitThread(1000);

		// Assert the new assessment card visible
		Assert.assertTrue(isElementPresent(tp.newcard), " new assessment card not visible");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(tp.newasses_lbl), AssessmentName);

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 16)
	public void TCSPR1200616() {

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
	public void TCSPR1200617() {

		waitThread(1000);

		lg.login1(Emailstudent1, password);

		waitThread(3000);
		// Click Assessment tab
		click(QP.Assessmenttab);
		waitThread(3000);
		// verify heading label current Assessments
		Assert.assertEquals(getText(QP.current_assesslabel), "Current Assessments");

		waitThread(5000);

		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(3000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(sa.Assess_name_card), AssessmentName);

	}

	/*
	 * To begin the test & check the labels of test window
	 */
	@Test(priority = 18)
	public void TCSPR1200618() throws InterruptedException {
		// To verify the begin test button visible or not

		if (isElementPresent((asp.btnbeginTest)) == true) {

			waitThread(3000);
			// click on Begin Test button
			click(asp.btnbeginTest);
			Assert.assertTrue(isElementPresent(asp.Questionwizard), "Test Window page not visible");
		}

		else {

			// wait for 1 min
			TimeUnit.MINUTES.sleep(1);
			TimeUnit.SECONDS.sleep(30);
			// To verify the begin test button visible
			Assert.assertTrue(isElementPresent(asp.btnbeginTest), "Begin Test button Not visible");
			waitThread(1000);

			// Assert the begin test
			Assert.assertTrue(isElementPresent(sa.begintest_btn), "Button not present");

			waitThread(2000);
			// click begin test
			click(sa.begintest_btn);

		}

		waitThread(5000);

		// Assert the Assessment name
		Assert.assertEquals(getText(ms.test_window_assess_name), AssessmentName);

	}

	/*
	 * To submit test with no answer, check the confirmation popup
	 */
	@Test(priority = 19)
	public void TCSPR1200619() {

		// click submit button
		click(ms.submit_btn);
		waitThread(2000);
		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");

		// Assert the text "You have 3 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(ms.confirmation_txt), "You have 3 skipped question(s)! Proceed to submit?");

		click(ms.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);
		// Click on Back to Assessment
		click(ms.backtoassess_btn);

		waitThread(2000);
		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

	}

	/*
	 * To check the labels on the student card
	 */
	@Test(priority = 20)
	public void TCSPR1200620() {

		type(sa.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// Assert the published Assessment card visible
		Assert.assertTrue(isElementPresent(ms.modify_btn), "Button not present");

	}

	/*
	 * To check the wizard status on the modify answer window
	 */
	@Test(priority = 21)
	public void TCSPR1200621() {

		waitThread(2000);
		// Click on Modify Submitted Test Button
		click(ms.modify_btn);
		waitThread(4000);

		// Assert the Question 1 Wizard is showing unAnswerd
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("visitednotattended"));

	}

	/*
	 * To check the button status on the Modify window page
	 */
	@Test(priority = 22)
	public void TCSPR1200622() {

		// Assert the Discard Changes button is in disabled state
		Assert.assertFalse(isEnabled(ma.dischange_btn), "Button not present");

		// Assert the Buttons Discard,Next Question,Submit
		Assert.assertTrue(isEnabled(ms.next_btn), "Next Question button not present");

		Assert.assertTrue(isEnabled(ms.submit_btn), "Submit button not present");

		Assert.assertTrue(isEnabled(ms.discard_btn), "Discard button not present");

	}

	/*
	 * To check the button visibility on the modify question page
	 */
	@Test(priority = 23)
	public void TCSPR1200623() {

		// Assert the previous button on wizard
		Assert.assertTrue(getAttribute(an.last_btn, "class").contains("p-disabled"));
		MouseHover(an.ques3_lbl);
		click(an.ques3_lbl);
		// Assert the first question is selected on wizard
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));

		// Assert the Next Question button is Disabled
		Assert.assertTrue(getAttribute(an.next_btn, "class").contains("p-disabled"));

		// Assert the Next button is Disabled
		// Assert.assertTrue(getAttribute(ms.next_btn,
		// "class").contains("disabled-btn"));
		// Assert.assertFalse(getAttribute(ms.next_btn,
		// "class").contains("disabled-btn"));

		click(an.ques3_lbl);

		// Assert the first question is selected on wizard
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));

		// Assert the Next Question button is Disabled
		Assert.assertTrue(getAttribute(an.next_btn, "class").contains("p-disabled"));

		// Assert the Next button is Disabled
		Assert.assertTrue(getAttribute(ms.next_btn, "class").contains("disabled-btn"));
	}

	/*
	 * To check the discard button functionality on the modify window page
	 */
	@Test(priority = 24)
	public void TCSPR1200624() {

		click(ms.discard_btn);

		// Assert confirmation popup visible
		Assert.assertFalse(isElementPresent(an.cof_popup), "popup not visible");

		waitThread(2000);

		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		type(sa.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		waitThread(2000);
		// Click on Modify Submitted Test Button
		click(ms.modify_btn);
		waitThread(4000);

		// Assert the Question 1 Wizard is showing un Answerd
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("visitednotattended"));

	}

	/*
	 * To check the My Answer is incomplete button and label
	 */
	@Test(priority = 25)
	public void TCSPR1200625() {

		// Assert the My answer incomplete checkbox not visible
		Assert.assertFalse(isElementPresent(ms.incomp_txt_checkbx), "checkbox not present");

		// Assert the label "My Answer is Incomplete" not visible
		Assert.assertFalse(isElementPresent(ma.incompans_lbl), "label not present");

		// Enter Answer 2
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer1
		type(an.ansplaceholder, "Answer 1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Assert the My answer incomplete checkbox not visible
		Assert.assertTrue(isElementPresent(ms.incomp_txt_checkbx), "checkbox not present");

		// Assert the label "My Answer is Incomplete" visible
		Assert.assertTrue(isElementPresent(ma.incompans_lbl), "label not present");

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Clear the first answer
		click(an.ansplaceholder);
		driver.findElement(By.xpath(an.ansplaceholder)).clear();

		// Assert the Answedr window is empty
		Assert.assertEquals(getText(an.ansplaceholder), "");

		driver.switchTo().defaultContent();
		waitThread(3000);

		// Assert the My answer incomplete checkbox not visible
		Assert.assertFalse(isElementPresent(ms.incomp_txt_checkbx), "checkbox not present");

		// Assert the label "My Answer is Incomplete" not visible
		Assert.assertFalse(isElementPresent(ma.incompans_lbl), "label not present");

	}

	/*
	 * To check the Next and Previous button functionality on the modify
	 */
	@Test(priority = 26)
	public void TCSPR1200626() {

		// Click on Next question button
		click(an.next_btn);

		// Assert the toaster not present
		Assert.assertFalse(isElementPresent(QP.toaster), "Toaster present");

		waitThread(2000);

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));

		click(an.last_btn);

		// Assert the toaster not visible
		Assert.assertFalse(isElementPresent(QP.toaster), "Toaster present");

		waitThread(2000);

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

	}

	/*
	 * To save one answer and submit assessment
	 */
	@Test(priority = 27)
	public void TCSPR1200627() {

		// Click first question on wizard
		click(an.ques2_lbl);
		waitThread(1000);

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));
		waitThread(1000);
		SwitchFrame("answer_ifr");

		waitThread(1000);
		// Enter Answer2
		type(an.ansplaceholder, "Answer 2");

		driver.switchTo().defaultContent();
		waitThread(3000);

		// click submit button
		click(ms.submit_btn);

		waitThread(1000);
		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");

		// Assert the text "You have 2 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(ms.confirmation_txt), "You have 2 skipped question(s)! Proceed to submit?");

		waitThread(2000);
		click(ms.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster Assessment Submitted
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		waitThread(2000);
		// Click on Back to Assessment
		click(ms.backtoassess_btn);

		waitThread(3000);
		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		click(sa.stud_searchbx);
		type(sa.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		waitThread(2000);
		// Click on Modify Submitted Test Button
		click(ms.modify_btn);
		waitThread(4000);

		// Assert the Question 1 Wizard is showing un Answerd
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("visitednotattended"));

		click(an.ques2_lbl);
		waitThread(1000);

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));
		waitThread(1000);
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Assert the Answedr window is empty
		Assert.assertEquals(getText(an.ansplaceholder), "Answer 2");

		driver.switchTo().defaultContent();
		waitThread(1000);

	}

	/*
	 * To check the discard changes button functionality on the page
	 */
	@Test(priority = 28)
	public void TCSPR1200628() {

		// Assert the Discard Changes button is in disabled state
		Assert.assertFalse(isEnabled(ma.dischange_btn), "Button not present");

		click(ma.dischange_btn);
		waitThread(1000);

		// Assert the Discard Changes button is in disabled state
		Assert.assertFalse(isEnabled(ma.dischange_btn), "Button not present");

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Clear the second answer
		click(an.ansplaceholder);

		driver.findElement(By.xpath(an.ansplaceholder)).clear();

		// Enter new answer content
		type(an.ansplaceholder, "Answer Two");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Assert the Discard Changes button is in enabled state
		Assert.assertTrue(isEnabled(ma.dischange_btn), "Button not present");

		click(ma.dischange_btn);
		waitThread(1000);

		waitFor(QP.toaster);
		// Assert the toaster Discarded the changes
		Assert.assertEquals(getText(QP.toaster), "Discarded the changes");

		click(QP.toasterclosebtn);

		SwitchFrame("answer_ifr");
		waitThread(2000);

		// Assert the Answedr window contains answer 2
		Assert.assertEquals(getText(an.ansplaceholder), "Answer 2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Assert discard changes button
		Assert.assertFalse(isEnabled(ma.dischange_btn), "Button not present");
	}

	/*
	 * To check the discard changes button functionality on the page
	 */
	@Test(priority = 29)
	public void TCSPR1200629() {

		waitThread(2000);
		// Click first question on wizard
		click(an.ques1_lbl);
		waitThread(2000);

		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

		SwitchFrame("answer_ifr");
		waitThread(2000);

		// Clear the second answer
		click(an.ansplaceholder);

		driver.findElement(By.xpath(an.ansplaceholder)).clear();

		// Add answer content to new content
		type(an.ansplaceholder, "Answer One");

		driver.switchTo().defaultContent();
		waitThread(2000);

		Assert.assertTrue(isEnabled(ma.dischange_btn), "Button not present");

		// Click on Discard Button
		click(ma.dischange_btn);
		waitThread(3000);

		waitFor(QP.toaster);

		// Assert the toaster Discarded the changes
		Assert.assertEquals(getText(QP.toaster), "Discarded the changes");

		click(QP.toasterclosebtn);

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Assert the Answedr window is empty
		Assert.assertEquals(getText(an.ansplaceholder), "");

		driver.switchTo().defaultContent();
		waitThread(1000);

	}

	/*
	 * To check the discard button functionality on the modify window page
	 */
	@Test(priority = 30)
	public void TCSPR1200630() {

		click(ms.discard_btn);

		// Assert confirmation popup visible
		Assert.assertFalse(isElementPresent(an.cof_popup), "popup not visible");

		waitThread(2000);

		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		type(sa.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		waitThread(2000);
		// Click on Modify Submitted Test Button
		click(ms.modify_btn);
		waitThread(4000);

		// Assert the Question 1 Wizard is showing un Answerd
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("visitednotattended"));

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Assert the 1st question answer empty
		Assert.assertEquals(getText(an.ansplaceholder), "");

		driver.switchTo().defaultContent();
		waitThread(1000);

		click(an.ques2_lbl);
		waitThread(1000);

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));

		SwitchFrame("answer_ifr");
		waitThread(1000);
		// Assert the 2nd question answer showing on the textbox
		Assert.assertEquals(getText(an.ansplaceholder), "Answer 2");

		driver.switchTo().defaultContent();
		waitThread(1000);

	}

	/*
	 * To submit the assessment with incomplete answers
	 */
	@Test(priority = 31)
	public void TCSPR1200631() {

		waitThread(2000);
		click(ms.incomp_txt_checkbx);
		waitThread(1000);

		Assert.assertTrue(getAttribute(ms.incomp_txt_checkbx2, "class").contains("p-checkbox-checked"));
		// Click on Next question button
		click(ms.next_btn);

		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);
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

		// Click on my answer is incompleted button
		click(ms.incomp_txt_checkbx);
		waitThread(1000);

		Assert.assertTrue(getAttribute(ms.incomp_txt_checkbx2, "class").contains("p-checkbox-checked"));

		click(ms.submit_btn);
		waitThread(1000);
		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");

		// Assert the text There are incomplete answers/skipped questions, do
		// you want
		// to proceed ?
		Assert.assertEquals(getText(ms.confirmation_txt),
				"There are incomplete answers/skipped questions, do you want to proceed ?");

		click(ms.submit_confi);

		waitFor(QP.toaster);

		// Assert the toaster Assessment Submitted
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		waitThread(2000);
		// Click on Back to Assessment
		click(ms.backtoassess_btn);

		waitThread(2000);

		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

	}

	/*
	 * To check the answer count on the card
	 */
	@Test(priority = 32)
	public void TCSPR1200632() {

		waitThread(3000);
		click(sa.stud_searchbx);
		type(sa.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		waitThread(2000);
		// Click on Modify Submitted Test Button
		click(ms.modify_btn);
		waitThread(2000);

		// Assert the Question 1 Wizard is showing un Answerd
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("visitednotattended"));

		// Assert the 2nd and 3rd question showing incomplete answer
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-paginator-incomplete"));
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-paginator-incomplete"));

	}

	/*
	 * To check the toasters on the modify page
	 */
	@Test(priority = 33)
	public void TCSPR1200633() {

		click(an.ques1_lbl);
		waitThread(1000);

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// enter answer 1
		type(an.ansplaceholder, "Answer 1");

		driver.switchTo().defaultContent();
		waitThread(1000);
		// Click on Next question button
		click(ms.next_btn);

		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		waitThread(2000);
		// Click first question on wizard
		click(an.ques2_lbl);
		waitThread(2000);

		// Untick the my answer is incomplete button
		click(ms.incomp_txt_checkbx);

		waitThread(2000);

		// Assert the checkbox is unchecked
		Assert.assertFalse(getAttribute(ms.incomp_txt_checkbx2, "class").contains("p-checkbox-checked"));

	}

	/*
	 * To Modify the answers and perform discard button
	 */
	@Test(priority = 34)
	public void TCSPR1200634() {

		waitThread(1000);
		// Click on Next question button
		click(ms.next_btn);

		waitFor(QP.toaster);

		// Assert the toaster "Answer Saved"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		waitThread(1000);

		// Assert the 3rd question is selected on wizard
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));

		waitThread(1000);
		// Untick the incomplete answer checkbox
		click(ms.incomp_txt_checkbx);

		waitThread(5000);
		// Assert the checkbox is unchecked
		Assert.assertFalse(getAttribute(ms.incomp_txt_checkbx, "class").contains("p-checkbox-checked"));
		click(an.last_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Answer Saved"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		waitThread(1000);
		click(ms.discard_btn);
		waitThread(2000);
		// Assert confirmation popup visible
		Assert.assertTrue(isElementPresent(an.cof_popup), "popup not visible");
		waitThread(1000);
		Assert.assertEquals(getText(ms.conf_lbl),
				"Do you want to discard the changes made and exit the answer window?");

		waitThread(2000);
		click(ms.yes_btn);

		waitFor(QP.toaster);
		// Assert the toasterAssessment Discarded
		Assert.assertEquals(getText(QP.toaster), "Assessment Discarded");

		click(QP.toasterclosebtn);

		waitThread(3000);
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

	}

	/*
	 * To check the answer on the page after perform discard functionality
	 */
	@Test(priority = 35)
	public void TCSPR1200635() {

		waitThread(3000);
		click(sa.stud_searchbx);
		type(sa.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// Assert the test completed count is 2/3
		Assert.assertEquals(getText(ms.compcount), "2/3");

		waitThread(2000);
		// Click on Modify Submitted Test Button
		click(ms.modify_btn);
		waitThread(2000);

		// Assert the Question 1 Wizard is showing un Answerd
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("visitednotattended"));

		// Assert the 2nd and 3rd question showing incomplete answer
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-paginator-incomplete"));
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-paginator-incomplete"));

	}

	/*
	 * To perform modify the assessment functionality
	 */
	@Test(priority = 36)
	public void TCSPR1200636() {

		waitThread(2000);
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

		// Enter Answer 2
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer1
		type(an.ansplaceholder, "Answer 1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Click on Next question button
		click(ms.next_btn);

		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		waitThread(1000);
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));

		// Enter Answer 2
		SwitchFrame("answer_ifr");

		// Enter Answer 2

		driver.findElement(By.xpath(an.ansplaceholder)).sendKeys(generateRandomData());

		driver.switchTo().defaultContent();
		waitThread(2000);
		Assert.assertTrue(getAttribute(ms.incomp_txt_checkbx2, "class").contains("p-checkbox-checked"));
		// Untick the my answer is incomplete button
		click(ms.incomp_txt_checkbx2);
		waitThread(2000);

		Assert.assertFalse(getAttribute(ms.incomp_txt_checkbx2, "class").contains("p-checkbox-checked"));
		waitThread(1000);

		// Click on Next question button
		click(ms.next_btn);

		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));

		waitThread(1000);

		// Enter Answer 3
		SwitchFrame("answer_ifr");
		waitThread(1000);
		type(an.ansplaceholder, "Answer 3");

		driver.switchTo().defaultContent();

		// assert checkbox not selected
		Assert.assertFalse(getAttribute(ms.incomp_txt_checkbx2, "class").contains("p-checkbox-checked"));

		click(ms.submit_btn);
		waitThread(2000);
		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");

		// Assert the text Are you sure you want to submit the assessment?
		Assert.assertEquals(getText(ms.confirmation_txt), "Are you sure you want to submit the assessment?");

		waitThread(2000);
		click(ms.submit_confi);

		waitFor(QP.toaster);

		// Assert the toaster Assessment Submitted
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		waitThread(3000);
		// Click on Back to Assessment
		click(ms.backtoassess_btn);

		waitThread(4000);
		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

	}

	/*
	 * To check the answer status on the modify window
	 */
	@Test(priority = 37)
	public void TCSPR1200637() {

		waitThread(2000);

		click(sa.stud_searchbx);
		type(sa.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// Assert the test completed count is 3/3
		Assert.assertEquals(getText(ms.compcount), "3/3");

		waitThread(2000);
		// Click on Modify Submitted Test Button
		click(ms.modify_btn);
		waitThread(2000);

		// Assert the 1st,2nd and 3rd question showing completed answer
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-paginator-complete"));
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-paginator-complete"));
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-paginator-complete"));

	}

	/*
	 * To check the answers on the page
	 */
	@Test(priority = 38)
	public void TCSPR1200638() {
		waitThread(2000);
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

		// Click on Next question
		click(ms.next_btn);
		waitThread(1000);

		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));

		// Assert no toaster visible
		Assert.assertFalse(isElementPresent(QP.toaster), "toaster not resent");

		waitThread(2000);
		// Click on Next question
		click(ms.next_btn);

		waitThread(2000);
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));

		// Assert no toaster visible
		Assert.assertFalse(isElementPresent(QP.toaster), "Toaster not resent");

		// click submit button
		click(ms.submit_btn);

		waitThread(2000);
		// Assert popup visible
		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");

		// Assert the text Are you sure you want to submit the assessment?
		Assert.assertEquals(getText(ms.confirmation_txt), "Are you sure you want to submit the assessment?");
		waitThread(2000);
		click(ms.submit_confi);

		waitFor(QP.toaster);

		// Assert the toaster Assessment Submitted
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		waitThread(2000);
		// Click on Back to Assessment
		click(ms.backtoassess_btn);

		waitThread(3000);
		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

	}

	/*
	 * To perform Delete Student 1 Account functionality
	 */
	@Test(priority = 39)
	public void TCSPR1200639_DeleteStudent1() {

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
	@Test(priority = 40)
	public void TCSPR1200640_DeleteStudent2() {

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
	@Test(priority = 41)
	public void TCSPR1200641_DeleteTeacher() {

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
