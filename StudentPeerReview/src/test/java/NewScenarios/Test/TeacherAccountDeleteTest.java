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

public class TeacherAccountDeleteTest extends basePage {
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
	public String CourseName;
	public String CourseID;
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

	@Test(priority = 1)
	public void TCSPR1800101_TeacherSignUp() throws SQLException {

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
	public void TCSPR1800102_Teachercoursecreation() throws SQLException {

		CourseName = "Course Name" + generateRandomNumber().trim();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID = (getText(cn.course_Id));
		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";

		// Invite students to course
		cm.Invitestudentstocourse(CourseName, Emailstudent1, Emailstudent2);
		waitThread(3000);

		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), CourseName.trim());
		// To verify the course delete popup text-Are you sure that you want to
		// permanently delete this course?
		cmt.coursedelete("Are you sure that you want to permanently delete this course?");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 3)
	public void TCSPR1800103_Teacherlogout() {

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
	public void TCSPR1800104_Student1signup() throws SQLException {

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
	public void TCSPR1800105_student1courseaccept() {

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
	public void TCSPR1800106_student2signup() throws SQLException {

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
	public void TCSPR1800107_student2courseaccept() {

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
	public void TCSPR1800108() {

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
		AssessmentName = "Assessment_Ongoing" + generateRandomNumber().trim();

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
	 * To fill the Questions
	 */
	@Test(priority = 9)
	public void TCSPR1800109() {

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

	public String RewardPercent = "100";

	/*
	 * To verify the details on the peer review page
	 */
	public String peerstudname1;
	public String peerstudname2;

	@Test(priority = 10)
	public void TCSPR1800110() {

		waitThread(4000);
		// Enter peer review Reward score
		type(prw.peer_reward_scorebx, RewardPercent);

		// Assert the text::Total Students : Assert the total student count is 3
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");
	}

	/*
	 * To perform the save and next functionaity from peer review page and
	 * verify the schedule page details
	 */
	@Test(priority = 11)
	public void TCSPR1800111() {

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

	/*
	 * To perform Assessment publish functionality and check the details on the
	 * publish popup
	 */
	@Test(priority = 12)
	public void TCSPR1800112() {

		// click on Release Button
		click(sbp.btnrelease);

		// Assert button Back to Menu
		Assert.assertTrue(isElementPresent(tts.back_to_menubutton), "Back to menu button not present");

	}

	/*
	 * To check the back to menu button functionality and check the created
	 * assessment visible on the current assessment tab
	 */
	@Test(priority = 13)
	public void TCSPR1800113() {

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

	}

	public String AssessmentNamedraft;

	@Test(priority = 14)
	public void TCSPR1800114() {

		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		click(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentNamedraft = "Assessment_Draft" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentNamedraft);

		waitThread(2000);

		// To click on save and exit button and verify the toaster
		click(ba.btnsaveandexit);
		waitThread(4000);
		// click on draft tab and verify draft tab is selected
		click(ba.tabdraft);
		waitThread(1000);

		Assert.assertEquals(getAttribute(ba.tabdraftselected, "aria-selected"), "true");
		Assert.assertEquals(getText(ba.DraftAssessname), AssessmentNamedraft);
	}

	public String AssessmentName2;

	@Test(priority = 15)
	public void TCSPR180015() {

		waitThread(2000);
		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);
		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);
		click(ba.ddcoursename1);
		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentName2 = "Assessment_Upcoming" + generateRandomNumber().trim();
		type(QP.Assess_name, AssessmentName2);
		waitThread(2000);
		// Click Save &Next button
		click(QP.Savenext);
		waitThread(2000);
	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 16)
	public void TCSPR180016() {

		TCSPR1800109();

	}

	/*
	 * To verify the details on the peer review page
	 */
	@Test(priority = 17)
	public void TCSPR180017() {

		TCSPR1800110();

	}

	/*
	 * To perform the save and next functionaity from peer review page and
	 * verify the schedule page details
	 */
	@Test(priority = 18)
	public void TCSPR180018() {

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

	/*
	 * To perform Assessment publish functionality and check the details on the
	 * publish popup
	 */
	@Test(priority = 19)
	public void TCSPR180019() {

		TCSPR1800112();
	}

	/*
	 * To check the back to menu button functionality and check the created
	 * assessment visible on the current assessment tab
	 */
	@Test(priority = 20)
	public void TCSPR180020() {

		waitThread(2000);
		// Click Back to Menu
		click(tts.back_to_menubutton);

	}

	/*
	 * To check the back to menu button functionality and check the created
	 * assessment visible on the current assessment tab
	 */
	@Test(priority = 21)
	public void TCSPR180021() throws InterruptedException {

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(3000);
		click(tcd.currentatb);
		waitThread(1000);
		// search the assessment
		type(st1.assess_searchbx, AssessmentName2);
		waitThread(4000);
		// Assert the newly published card visible on the current assessment
		// page
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");
		Assert.assertTrue(getText(tcd.cardheadiglbl).contains("Test upcoming"));

	}

	/*
	 * To check the account delete popup text
	 */
	@Test(priority = 22)
	public void TCSPR180022() throws InterruptedException {
		TimeUnit.MINUTES.sleep(1);
		// click navigation dropdown
		click(as.nav_drop1);

		// click account settings button
		click(as.accnt_sett1);
		TimeUnit.SECONDS.sleep(2);
		// Assert the label Account Settings in accountsettings Page
		Assert.assertEquals(getText(as.hd_label5), "Account Settings");
		// click delete account button
		click(as.delete_button4);
		TimeUnit.SECONDS.sleep(2);
		// Assert the confirmation box
		Assert.assertTrue(isElementPresent(as.popbox_1), "Confirmation popup not visible");
		// Assert the label and value of teacher email
		Assert.assertEquals(getText(as.alrt_label2),
				"Are you sure that you want to permanently delete this account?\n" + "Note: You currently have -\n"
						+ "* 1 active course\n" + "* 1 ongoing assessment\n" + "* 1 upcoming assessment\n"
						+ "* 1 draft assessment");

		waitFor(as.alrt_nobutton);
		TimeUnit.SECONDS.sleep(2);
		// click No button in popup
		click(as.alrt_nobutton);
		// Assert confirmation popup not visible
		Assert.assertTrue(isElementPresent(as.popbox_1), "Confirmation popup not visible");
		// To verify the course delete popup text-Are you sure that you want to
		// permanently delete this course?
		cmt.coursedelete(
				"Are you sure that you want to permanently delete this course?\n" + "Note: You currently have -\n"
						+ "* 1 ongoing assessment\n" + "* 1 upcoming assessment\n" + "* 1 draft assessment");
		waitThread(1000);
		cm.Logout();
	}

	@Test(priority = 23)
	public void TCSPR180023() {
		waitThread(2000);
		// Login to Student1
		lg.login1(Emailstudent1, cm.Password);
		waitThread(2000);
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

	@Test(priority = 24)
	public void TCSPR180024() {

		// Enter Answer1
		driver.switchTo().frame("answer_ifr");
		type(tsw.answer_bx, "Answer 1_" + generateRandomData());
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Savebutton
		click(tsw.save_btn_test);
		waitFor(QP.toaster);
		// Assert Toaster Answer saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);
	}

	@Test(priority = 25)
	public void TCSPR180025() {
		waitThread(2000);
		// Click Submit button
		click(tsw.submit_btn);
		waitThread(1000);
		// Click submit button on popup
		click(tsw.submit_confi);

		// click back to Assessments
		click(tsw.backtoassess_btn);

		waitThread(4000);
		// Assert the current Assessments
		Assert.assertEquals(getText(prw.current_assess_label), "Current Assessments");
		cm.Logout();

	}

	@Test(priority = 26)
	public void TCSPR180026() {
		waitThread(2000);
		// Login to Student1
		lg.login1(Emailstudent2, cm.Password);
		waitThread(2000);
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

	@Test(priority = 27)
	public void TCSPR180027() {

		TCSPR180024();
		TCSPR180025();
	}

	@Test(priority = 28)
	public void TCSPR180028() throws InterruptedException {

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

	@Test(priority = 29)
	public void TCSPR180029() {

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

	@Test(priority = 30)
	public void TCSPR180030() {

		// Login to Student1
		lg.login1(Emailstudent2, cm.Password);

		waitThread(4000);
		// Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		type(st1.stud_searchbx, AssessmentName);
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
	public void TCSPR180031() {

		TCSPR180029();

	}

	@Test(priority = 32)
	public void TCSPR180032() throws InterruptedException {

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

	}

	@Test(priority = 33)
	public void TCSPR180033() throws InterruptedException {

		SoftAssert assert1 = new SoftAssert();

		// To verify the course delete popup text-Are you sure that you want to
		// permanently delete this course?
		cmt.coursedelete(
				"Are you sure that you want to permanently delete this course?\n" + "Note: You currently have -\n"
						+ "* 1 upcoming assessment\n" + "* 1 draft assessment\n" + "* 1 fulfilled assessment");
		waitThread(1000);

		// click navigation dropdown
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
		// Assert the label and value of teacher email
		assert1.assertEquals(getText(as.alrt_label2),
				"Are you sure that you want to permanently delete this account?\n" + "Note: You currently have -\n"
						+ "* 1 active course\n" + "* 1 upcoming assessment\n" + "* 1 draft assessment\n"
						+ "* 1 fulfilled assessment",
				"Assersion failed");

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

	@Test(priority = 34)
	public void TCSPR180034() {
		waitThread(2000);
		// Login to Student1
		lg.login(Emailstudent1, cm.Password);
		Assert.assertFalse(isElementPresent("div.student-course-title-div"), "course card not visible");
		waitThread(1000);
		click("//a[@id='assessmentsLinkStudent']");
		waitThread(2000);
		// Search Assessment name
		Doubleclick(st1.stud_searchbx);
		type(st1.stud_searchbx, AssessmentName);
		waitThread(2000);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed("div.p-dataview-emptymessage"), "Published Assessment card not visible");
		waitThread(1000);
		// Click on Fulfilled Assessments tab
		Doubleclick(tcd.tabassessmentpublishedtab);
		waitThread(3000);
		Assert.assertEquals(getText("//*[@id='assessments_grid_table']/div/div[2]/table/tbody/tr/td"),
				"No Assessment(s) Found.");

	}

	/*
	 * To perform Delete Teacher Account functionality
	 */
	@Test(priority = 35)
	public void Deletestudent1() {

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
	 * To perform Delete student1 Account functionality
	 */
	@Test(priority = 36)
	public void DeleteStudent2() {

		// login using deleted account credentials
		lg.login1(Emailstudent2, password);

		cr.DeleteAccount();

		waitThread(2000);

		// login using deleted account credentials
		lg.login(Emailstudent2, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}
}
