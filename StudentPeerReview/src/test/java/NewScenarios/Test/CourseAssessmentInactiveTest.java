package NewScenarios.Test;

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

import AccountSettings.Pages.AccountSettingsandDeleteAccountPage;
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
import NewScenarios.Pages.CourseAssessmentInactivePage;
import NewScenarios.Pages.TeacherAccountDeletePage;
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

public class CourseAssessmentInactiveTest extends basePage {

	LoginPage lg = new LoginPage();
	CommonMethods cm = new CommonMethods();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	PeerReviewWindowWizardPage prw = new PeerReviewWindowWizardPage();
	SchedulePageBasicsPage sb1 = new SchedulePageBasicsPage();
	SummaryBasicsPage sbp = new SummaryBasicsPage();
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
	SchedulePageBasicsPage sb = new SchedulePageBasicsPage();
	TeacherAccountDeletePage tcd = new TeacherAccountDeletePage();
	AccountSettingsandDeleteAccountPage as = new AccountSettingsandDeleteAccountPage();
	CourseAssessmentInactivePage cA = new CourseAssessmentInactivePage();

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
	public String Emailstudent1;
	public String Emailstudent2;
	public String Emailstudent3;
	public String Emailstudent4;
	public String CourseName;
	public String CourseNameN;
	public String CourseID;
	public String draftAssessmentName;
	public String Assessment_Ongoing;
	public String Assessment_Upcoming;
	public String Question1 = "Question1";
	public String Question2 = "Question2";
	public String Question3 = "Question3";
	public String Rubric1 = "Rubric1";
	public String Rubric2 = "Rubric2";
	public String Rubric3 = "Rubric3";
	public String Maxscore1 = "10";
	public String Maxscore2 = "20";
	public String Maxscore3 = "30";
	public String RewardPercent = "100";
	public String peerstudname1;
	public String peerstudname2;

	@Test(priority = 1)
	public void TCSPR1800301() throws SQLException {

		Emailteacher = cmt.SignUpTeacher();

		// To catch OTP from sending Resource
		cmt.OtpFetch();

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	// To create new Course
	@Test(priority = 2)

	public void TCSPR1800302() {
		CourseName = "Course Name" + generateRandomNumber().trim();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID = (getText(cn.course_Id));
		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";

		// Invite students to course
		cm.Invitestudentstocourse(CourseName, Emailstudent1, Emailstudent2);

	}

	// To perform Logout functionality on Teacher profile

	@Test(priority = 3)
	public void TCSPR1800303() {
		// logout functionality
		rs.Logout();

		// heading title
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * To check that invited course request visible on first student's profile
	 * and accept course request Read the student name
	 */
	@Test(priority = 4)
	public void TCSPR1800304() throws SQLException {
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
	public void TCSPR1800305() {
		// Click accept button
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
	 * To check that invited course request visible on second student's profile
	 * and accept course request Read the student name
	 */
	@Test(priority = 6)

	public void TCSPR1800306() throws SQLException {
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

	// To accept course and perform Logout Functionality second student
	@Test(priority = 7)
	public void TCSPR1800307() {

		waitThread(2000);
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

	// To load the create new assessment page and fill details on the basic
	// details
	// page
	@Test(priority = 8)
	public void TCSPR1800308() {
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
		Assessment_Ongoing = "Assessment_Ongoing" + generateRandomNumber().trim();

		type(QP.Assess_name, Assessment_Ongoing);

		waitThread(2000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(2000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");
		softAssert1.assertAll();

	}

	// To fill details on the Question page
	@Test(priority = 9)

	public void TCSPR1800309() {
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
		waitThread(1000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);

		waitThread(1000);
		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	@Test(priority = 10)
	// To verify the details on the peer review page

	public void TCSPR1800310() {
		waitThread(4000);
		// Enter peer review Reward score
		type(prw.peer_reward_scorebx, RewardPercent);

		// Assert the text::Total Students : Assert the total student count is 3
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");
	}

	@Test(priority = 11)

	/*
	 * To perform the save and next functionality from peer review page and
	 * verify the schedule page details
	 */
	public void TCSPR1800311() {
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
		Assert.assertEquals(getAttribute(sbp.summarywizard, "aria-selected"), "true");

	}

	@Test(priority = 12)
	/*
	 * To perform Assessment publish functionality and check the details on the
	 * publish pop up
	 */
	public void TCSPR1800312() {
		// click on Release Button
		click(sbp.btnrelease);

		// Assert button Back to Menu
		Assert.assertTrue(isElementPresent(tts.back_to_menubutton), "Back to menu button not present");
	}

	@Test(priority = 13)
	/*
	 * To check the back to menu button functionality and check the created
	 * assessment visible on the current assessment tab
	 */

	public void TCSPR1800313() {
		waitThread(2000);
		// Click Back to Menu
		click(tts.back_to_menubutton);

		waitThread(3000);

		// Assert the text "Assessments "
		Assert.assertEquals(getText(ba.lbl_assessment), "Assessments");

		click(st1.assess_searchbx);
		// search the assessment
		type(st1.assess_searchbx, Assessment_Ongoing);

		// Assert the newly published card visible on the current assessment
		// page
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");
	}

	@Test(priority = 14)
	/* To create an assessment and draft it */
	public void TCSPR1800314()

	{

		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		click(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		draftAssessmentName = "Assessment_Draft" + generateRandomNumber().trim();

		type(QP.Assess_name, draftAssessmentName);

		waitThread(2000);

		// To click on save and exit button and verify the toaster
		click(ba.btnsaveandexit);
		waitThread(8000);
		// click on draft tab and verify draft tab is selected
		click(ba.tabdraft);
		waitThread(1000);

		Assert.assertEquals(getAttribute(ba.tabdraftselected, "aria-selected"), "true");
		Assert.assertEquals(getText(ba.DraftAssessname), draftAssessmentName);
	}

	@Test(priority = 15)
	/*
	 * To load the create new assessment page and fill details on the basic
	 * details page
	 * 
	 * To create An upcoming Assessment
	 */
	public void TCSPR1800315() {
		waitThread(2000);
		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);
		// To click on course drop down
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);
		click(ba.ddcoursename1);
		// Type Assessment Name
		click(QP.Assess_name);
		Assessment_Upcoming = "Assessment_Upcoming" + generateRandomNumber().trim();
		type(QP.Assess_name, Assessment_Upcoming);
		waitThread(2000);
		// Click Save &Next button
		click(QP.Savenext);
		waitThread(2000);
	}

	@Test(priority = 16)
	/* To fill details on the Question page */
	public void TCSPR1800316()

	{
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
		waitThread(1000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);

		waitThread(1000);
		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	@Test(priority = 17)
	/* To verify the details on the peer review page */
	public void TCSPR1800317()

	{
		TCSPR1800310();
	}

	@Test(priority = 18)
	/*
	 * To perform the save and next functionality from peer review page and
	 * verify the schedule page details
	 */
	public void TCSPR1800318() {
		// Click Save&Next button
		click(pr.savennext_button);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);

		waitThread(2000);
		Assert.assertEquals(getAttribute(sb1.schedule_wizard, "aria-expanded"), "true");

		// Assert the text "Select schedules for "
		Assert.assertEquals(getText(sb1.selectstu_lbl), "Select Schedules for");

		click(sb.assessmentopendate_txtbx);

		cm.ClicktomorrowDate();

		waitThread(3000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sbp.summarywizard, "aria-selected"), "true");
	}

	@Test(priority = 19)
	/*
	 * To perform Assessment publish functionality and check the details on the
	 * publish pop up
	 */
	public void TCSPR1800319() {
		// click on Release Button
		click(sbp.btnrelease);

		// Assert button Back to Menu
		Assert.assertTrue(isElementPresent(tts.back_to_menubutton), "Back to menu button not present");
	}

	@Test(priority = 20)
	/*
	 * To check the back to menu button functionality and check the created
	 * assessment visible on the current assessment tab
	 */
	public void TCSPR1800320() {
		waitThread(2000);
		// Click Back to Menu
		click(tts.back_to_menubutton);

	}

	@Test(priority = 21)
	/*
	 * To check the course details page and check the inactive button
	 * functionality
	 */
	public void TCSPR1800321() {

		waitThread(2000);
		// to click on Course Tab
		click(cA.courseTab);

		// To verify Course info button

		Assert.assertTrue(isElementPresent(cA.CourseInfo_btn), "Button is not present");

		waitThread(2000);
		// click on Course Info drop down

		click(cA.CourseInfo_btn);

		// Click on Verify or modify Text
		click(cA.Verifymodify1);

		// Assert the heading label "Course Details"
		// Assert.assertEquals(getText(cA.coursedetailLabel), "Course Details");

	}

	@Test(priority = 22)
	// To check the content and assessment details on the inactive pop up

	public void TCSPR1800322() throws InterruptedException {
		TimeUnit.MINUTES.sleep(1);
		// click on active toggle button
		click(cA.ActiveToogle);
		waitThread(2000);

		// Assert pop up box is visible

		Assert.assertTrue(isElementPresent(cA.Popupbox), "popup box  not visible");

		// Assert the Course : course Name

		Assert.assertEquals(getText(cA.popupcontent1), "Course: " + CourseName);
		// Assert.assertTrue(isElementPresent(cA.popupcontent1)," Heading
		// missing ");
		// Assert the second content
		Assert.assertEquals(getText(cA.popupcontent2),
				"Are you sure that you want to inactivate this course?\n"
						+ "Note: Along with the course, the following will be inactivated as well -\n"
						+ "* 1 ongoing assessment\n" + "* 1 upcoming assessment\n" + "* 1 draft assessment");
		/*
		 * Assert.assertEquals(getText(cA.popupcontent2),
		 * "Are you sure that you want to inactivate this course?\n" +
		 * "Note: Along with the course, the following will be inactivated as well -\n"
		 * +"* 2 ongoing assessments\n" + "* 1 draft assessment");
		 */

		// Click No button

		click(cA.No_Button);
		// Assert the active button is selected

		Assert.assertTrue(isEnabled(cA.Activestatus), "Active tooggle is not selected");

	}

	@Test(priority = 23)
	// Teacher Logout
	public void TCSPR1800323() {
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
		waitThread(2000);
		// Login to Student1
		lg.login1(Emailstudent1, cm.Password);
		waitThread(2000);
		// Search Assessment name
		Doubleclick(st1.stud_searchbx);
		type(st1.stud_searchbx, Assessment_Ongoing);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		waitThread(3000);
		// Click Begin Test
		click(st1.begintest_btn);

		waitThread(5000);
		// assert the assessment name
		Assert.assertEquals(getText(asp.testassessmentname), Assessment_Ongoing.trim());
	}

	@Test(priority = 24)
	// To attend test and fill answer functionality

	public void TCSPR1800324()

	{
		// Type Answer 1
		driver.switchTo().frame("answer_ifr");
		type(tsw.answer_bx, "Answer 1_" + generateRandomData());
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click on Save button
		click(tsw.save_btn_test);
		waitFor(QP.toaster);
		// Assert Toaster Answer saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);
	}

	@Test(priority = 25)
	// To perform assessment submit functionality on the student profile
	public void TCSPR1800325() {
		waitThread(2000);
		// Click Submit button
		click(tsw.submit_btn);
		waitThread(1000);
		// Click submit button on pop up
		click(tsw.submit_confi);

		// click back to Assessments
		click(tsw.backtoassess_btn);

		waitThread(4000);
		// Assert the current Assessments
		Assert.assertEquals(getText(prw.current_assess_label), "Current Assessments");
		cm.Logout();
	}

	@Test(priority = 26)
	/*
	 * To perform Login functionality of student1 profile and check the
	 * Assessment card To begin the test & check the labels of test window
	 */
	public void TCSPR1800326() {
		waitThread(2000);
		// Login to Student1
		lg.login1(Emailstudent2, cm.Password);
		waitThread(2000);
		// Search Assessment name
		Doubleclick(st1.stud_searchbx);
		type(st1.stud_searchbx, Assessment_Ongoing);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		waitThread(3000);
		// Click Begin Test
		click(st1.begintest_btn);

		waitThread(5000);
		// verify the assessment name
		Assert.assertEquals(getText(asp.testassessmentname), Assessment_Ongoing.trim());
	}

	@Test(priority = 27)
	/*
	 * To attend test and fill answer functionality To perform assessment submit
	 * functionality on the student profile To perform logout functionality on
	 * the Student 1 profile
	 */
	public void TCSPR1800327() {

		// To attend test and fill answer functionality
		// Type Answer 1
		driver.switchTo().frame("answer_ifr");
		type(tsw.answer_bx, "Answer 1_" + generateRandomData());
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click on Save button
		click(tsw.save_btn_test);
		waitFor(QP.toaster);
		// Assert Toaster Answer saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		// To perform Assessment submit functionality on the submit page

		TCSPR1800325();

	}

	@Test(priority = 28)
	/*
	 * Login as Teacher and Reschedule the Test due and peer review start date
	 * 
	 * To perform Login functionality of student 1 profile and check the
	 * Assessment card
	 */
	public void TCSPR1800328() throws InterruptedException {
		// Login to Teacher profile
		cm.login(Emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// Click Assessment tab
		click(QP.teach_assesstab);

		waitThread(5000);

		click(st1.assess_searchbx);
		// search newly created assessment
		type(st1.assess_searchbx, Assessment_Ongoing);

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
		type(st1.stud_searchbx, Assessment_Ongoing);
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

	@Test(priority = 29)
	/*
	 * To perform review for Question 1 functionality To perform assessment
	 * submit functionality on the student profile To perform logout
	 * functionality on the Student 1 profile
	 */
	public void TCSPR1800329() {
		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "10");

		// click submit button
		click(ms.submit_btn);
		waitThread(1000);
		waitThread(2000);
		click(prp.submit_confi);

		// Click on Back to Assessment
		click(prp.reviewbactoassessmentbtn);
		waitThread(5000);

		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		waitThread(6000);


	}

	@Test(priority = 30)
	/*
	 * To perform Login functionality of student 2 profile and check the
	 * Assessment card
	 */
	public void TCSPR1800330() {
		
		// logout functionality
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
		// Login to Student2
		lg.login1(Emailstudent2, cm.Password);

		waitThread(4000);
		// Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		type(st1.stud_searchbx, Assessment_Ongoing);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		waitThread(2000);

		// Click Begin Review
		click(st1.begintest_btn);

		waitThread(5000);

		// Assert the first Question is selected
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));

	}

	@Test(priority = 31)
	/* To perform assessment submit functionality on the student profile */
	public void TCSPR1800331() {
		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "10");

		// click submit button
		click(ms.submit_btn);
		waitThread(1000);
		waitThread(2000);
		click(prp.submit_confi);

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

	@Test(priority = 32)
	/* Perform teacher login and reschedule the peer review and result date */
	public void TCSPR1800332() throws InterruptedException {
		// Login to Teacher profile
		cm.login(Emailteacher, cm.Password);

		// Click Assessment tab
		click(QP.teach_assesstab);

		waitThread(5000);

		// search assessment
		type(st1.assess_searchbx, Assessment_Ongoing);

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
		type(st1.assess_searchbx, Assessment_Ongoing);
		driver.findElement(By.xpath(st1.assess_searchbx)).sendKeys("        ");

		TimeUnit.SECONDS.sleep(30);
		waitThread(3000);
		// wait till button is Enabled
		TimeUnit.MINUTES.sleep(2);
		driver.navigate().refresh();

		TimeUnit.SECONDS.sleep(20);
		click(st1.assess_searchbx);
		// search assessment
		type(st1.assess_searchbx, Assessment_Ongoing);

		// Assert the View result Button is Enabled
		Assert.assertTrue(isEnabled(arv.viewresult_teachcard), "View result button is disabled");

		waitThread(4000);
		// Assert Label Result Available
		Assert.assertEquals(getText(tts.time_status), "Result Available");
	}

	@Test(priority = 35)
	/*
	 * To check the course details page and check the inactive button
	 * functionality ** --priority changed due to flow.trial subscription have
	 * permission for only one course
	 */
	public void TCSPR1800333() throws InterruptedException {

		waitThread(2000);
		// to click on Course Tab
		click(cA.courseTab);
		waitThread(4000);

		// Create new Active Course
		CourseNameN = "Course Name" + generateRandomNumber().trim();

		// Click on create new course button
		click(cn.btn_createnew);
		waitThread(4000);

		// To get the Course ID
		CourseID = (getText(cn.course_Id));
		waitThread(2000);
		// type-Course title
		type(cn.txbx_Coursetitle, CourseNameN);

		// click on Add students button
		/*
		 * click(cn.btn_AddStudents);
		 * 
		 * Emailstudent1 = "student1" + generateRandomNumber().trim() +
		 * "@gmail.com"; Emailstudent2 = "student2" +
		 * generateRandomNumber().trim() + "@gmail.com"; // type email
		 * type(cn.tab_textbox, Emailstudent1 + ",");
		 * driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
		 * type(cn.tab_textbox, Emailstudent2 + ",");
		 * driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
		 * 
		 * // click on add to list button click(cn.tab_btn_Addtolist);
		 * 
		 * waitThread(2000); waitFor(cr.emailval_1);
		 * 
		 * // verify the Email on the New Students to be invited to this class
		 * box Assert.assertEquals(getText(cr.emailval_1), Emailstudent1);
		 * Assert.assertEquals(getText(ps.emailval_2), Emailstudent2);
		 */

		// click on create course button
		waitThread(2000);
		click(cn.btn_Createcourse);

		waitThread(3000);

		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), CourseNameN.trim());

		// To verify Course info button

		Assert.assertTrue(isElementPresent(cA.CourseInfo_btn), "Button is not present");

	}

	@Test(priority = 33)
	/* To check the content and assessment details on the inactive pop up */

	public void TCSPR1800334() throws InterruptedException {
		waitThread(2000);
		// to click on Course Tab
		click(cA.courseTab);
		waitThread(4000);
		// click on Course Info drop down

		click(cA.CourseInfo_btn);

		// Click on Verify or modify Text
		click(cA.Verifymodify1);

		// click on active toggle button
		TimeUnit.MINUTES.sleep(1);
		click(cA.ActiveToogle);
		waitThread(2000);

		waitThread(2000);
		// Assert pop up box is visible

		Assert.assertTrue(isElementPresent(cA.Popupbox), "popup box  not visible");

		// Assert the Course : course Name

		Assert.assertEquals(getText(cA.popupcontent1), "Course: " + CourseName);
		// Assert.assertTrue(isElementPresent(cA.popupcontent1)," Heading
		// missing ");
		// Assert the second content
		Assert.assertEquals(getText(cA.popupcontent2),
				"Are you sure that you want to inactivate this course?\n"
						+ "Note: Along with the course, the following will be inactivated as well -\n"
						+ "* 1 upcoming assessment\n" + "* 1 draft assessment\n" + "* 1 fulfilled assessment");
		/*
		 * Assert.assertEquals(getText(cA.popupcontent2),
		 * "Are you sure that you want to inactivate this course?\n" +
		 * "Note: Along with the course, the following will be inactivated as well -\n"
		 * +"* 2 ongoing assessments\n" + "* 1 draft assessment");
		 */
		// Click Yes button
		waitThread(3000);
		click(cA.Yes_button);

	}

	@Test(priority = 34)
	/* To In activate the course from the application */
	public void TCSPR1800335() {

		waitThread(1000);
		waitFor(cA.Toaster);

		// Assert the content

		Assert.assertEquals(getText(cA.Toaster), "This course has been successfully inactivated");
		// Assert the active button is disabled
		waitThread(4000);

		// Assert the toggle is disabled

		Assert.assertFalse(getAttribute(cA.ActiveInactive, "class").contains("checked"));

		// click on Assessment Button

		click(cA.Assessment_button);
		waitThread(5000);

		// Assert create new assessment button is disabled

		// Assert.assertFalse(isEnabled(cA.CreateAssessmentbtn),"create
		// assessment
		// button is enabled");
		Assert.assertTrue(getAttribute(cA.Cnewbtndsbl, "class").contains("p-disabled"));

	}

	@Test(priority = 36)
	/* To check that the Assessments listed on the inactive tab */

	public void TCSPR1800336() {
		// click on assessment Tab

		click(cA.Assessment_Tab);
		waitThread(5000);

		// click on inactive Tab

		click(cA.Inactive_Tab);
		waitThread(4000);

		// Assert the Assessment Assessment name Assessment name Upcoming+random
		// number
		// not visible
		// type(cA.Assessmentsearch,AssessmentName_D2);
		Assert.assertFalse(isElementPresent(cA.AssessmentNameIn), Assessment_Upcoming+"Coursename visible on the page");
		waitThread(3000);
		// click draft tab

		// click(cA.DraftTab);
		/*
		 * click(ba.tabdraft); waitThread(2000);
		 * 
		 * //Assert msg //Assert.assertEquals(getText(cA.draftassessmentname),
		 * draftAssessmentName);
		 * 
		 * Assert.assertEquals(getText(cA.DraftNoAssessment),
		 * "No Assessment(s) Found.");
		 */

		// click assessment tab

		/*
		 * click(cA.Assessment_Tab);
		 * 
		 * Assert.assertEquals(getText(cA.draftassessmentname),AssessmentName);
		 */

		// Click Current tab
		click(cA.CurrentTab);

		waitThread(5000);

		// search assessment
		type(st1.assess_searchbx, Assessment_Ongoing);

		Assert.assertEquals(getText(cA.No_Assessment_lbl), "No assessment available");
		waitThread(3000);

		// Assert upcoming assessment

		// search assessment
		type(st1.assess_searchbx, Assessment_Upcoming);

		// Assert the published Assessment card visible
		Assert.assertEquals(getText(cA.No_Assessment_lbl), "No assessment available");
		// Assert.assertTrue(isDisplayed(st1.teach_assess_name), "Published
		// Assessment
		// card not visible");
		waitThread(3000);

	}

	@Test(priority = 37)
	/*
	 * To check that the in activated course assessments not listed on the
	 * students login
	 */
	public void TCSPR1800337() {
		// log out Teacher
		cm.Logout();

		waitThread(5000);
		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);
		// Login to Student1
		lg.login1(Emailstudent2, cm.Password);
		waitThread(2000);
		// Assert the label no assessment available
		Assert.assertEquals(getText(cA.No_Assessment_lbl), "No assessment available");
		// click on result publish tab

		click(cA.Resultpublishtab);

		// Assert the label No assessment found

		Assert.assertEquals(getText(cA.Noassessment_found), "No Assessment(s) Found.");

		// perform logout functionality

		rs.Logout();

	}

	@Test(priority = 38)
	/* */
	public void TCSPR1800338() throws InterruptedException {

		lg.login1(Emailteacher, password);
		waitThread(4000);

		cA.coursedelete();
		waitThread(2000);

		click(cA.Course_Active);
		waitThread(2000);

		click(cA.Inactivedropdownlbl);
		waitThread(2000);
		// click on Course Info drop down

		click(cA.CourseInfo_btn);

		// Click on Verify or modify Text
		click(cA.Verifymodify1);

		// click on active toggle button
		TimeUnit.MINUTES.sleep(1);
		click(cA.ActiveToogle);
		waitThread(2000);

		Assert.assertTrue(isElementPresent(cA.Popupbox), "popup box  not visible");
		// Assert.assertTrue(isElementPresent(cA.popupcontent1)," Heading
		// missing ");
		// Assert the second content
		Assert.assertEquals(getText(cA.popupcontent2), "Are you sure that you want to activate this course?\n"
				+ "Note: Any upcoming or ongoing assessments in this course will remain inactive until each assessment is manually activated");
		click(cA.No_Button);
		// Assert the active button is selected

		// Assert.assertFalse(isEnabled(cA.Activate_btn),"Activate button is
		// enabled");
		waitThread(2000);
		Assert.assertFalse(getAttribute(cA.ActiveInactive, "class").contains("checked"));

		TimeUnit.MINUTES.sleep(1);
		click(cA.ActiveToogle);
		waitThread(2000);

		Assert.assertTrue(isElementPresent(cA.Popupbox), "popup box  not visible");

		click(cA.Yes_button);

		waitThread(1000);
		waitFor(cA.Toaster);

		Assert.assertEquals(getText(cA.Toaster), "The course " + CourseName + " has been successfully activated");

		click(cA.Assessment_button);
		waitThread(5000);
		// Assert create new assessment button is enabled

		Assert.assertFalse(getAttribute(cA.CreateAssessmentbtn, "class").contains("p-disabled"));

	}

	@Test(priority = 39)
	/* logout Teacher */

	public void TCSPR1800339() {
		// logout functionality Teacher
		waitThread(2000);
		cm.Logout();

	}

	@Test(priority = 40)
	public void TCSPR1800340() throws InterruptedException {

		waitThread(2000);
		// Login as student

		// login using deleted account credentials
		lg.login1(Emailstudent1, password);
		waitThread(2000);
		cr.DeleteAccount();

		waitThread(2000);

		// login using deleted account credentials
		lg.login(Emailstudent1, password);

		// Delete Teacher account

		waitThread(2000);
		cm.login(Emailteacher, cm.Password);
		SoftAssert assert1 = new SoftAssert();
		click(as.nav_drop1);

		// click account settings button
		click(as.accnt_sett1);
		TimeUnit.SECONDS.sleep(2);
		// Assert the label Account Settings in accountsettings Page
		Assert.assertEquals(getText(as.hd_label5), "Account Settings");
		TimeUnit.SECONDS.sleep(2);
		// click delete account button
		click(as.delete_button4);
		// Assert the confirmation box
		Assert.assertTrue(isElementPresent(as.popbox_1), "Confirmation popup not visible");
		TimeUnit.SECONDS.sleep(2);

		waitFor(as.alrt_yesbutton);
		// click No button in popup
		click(as.alrt_yesbutton);
		// Assert confirmation popup not visible
		Assert.assertTrue(isElementPresent(as.popbox_1), "Confirmation popup not visible");
		waitThread(4000);
		// Verify the header text
		Assert.assertEquals(getTitle(), "Student Peer Review");
		assert1.assertAll();

	}

}
