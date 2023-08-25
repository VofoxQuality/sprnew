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
import NewScenarios.Pages.CourseAssessmentActivePage;
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
import TestWindowOfIndividualStudent.StudentAssessmentInfoAndInstructionPage;
import TestWindowOfIndividualStudent.TestWindowWizardPage;

public class CourseAssessmentActiveTest extends basePage {

	// CourseAssessmentActive ca = new CourseAssessmentActive();
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
	StudentAssessmentInfoAndInstructionPage sa = new StudentAssessmentInfoAndInstructionPage();

	CourseAssessmentActivePage ca = new CourseAssessmentActivePage();

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
	public String Assessment_Ongoing;
	public String AssessmentName_D2;
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

	public String assessmentopendate;
	public String assessmentopentime;
	public String assessmentduedate;
	public String assessmentduetime;

	public String peerreviewopendate;
	public String peerreviewopentime;
	public String peerreviewduedate;
	public String peerreviewduetime;

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
		waitThread(5000);
		rs.Logout();

		// heading title
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * To check that invited course request visible on first student's profile and
	 * accept course request Read the student name
	 */
	@Test(priority = 3)
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
	@Test(priority = 4)
	public void TCSPR1800305() {
		// Click accept button
		click(rs.btn_acceptcourse);
		waitThread(2000);
		// verify the confirmation popup visible
		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");
		// click on Yes button
		click(rs.popupbtn_Yes);

		// Toaster message
		waitFor(rs.toaster);
		Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");

		// verify the course name is visible on the enrolled section
		waitFor(rs.enrolledcoursename);
		waitThread(3000);
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * To check that invited course request visible on second student's profile and
	 * accept course request Read the student name
	 */
	@Test(priority = 5)
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

		// verify the course name visible on the enrolled section
		waitFor(rs.enrolledcoursename);
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

//To load the create new assessment page and fill details on the basic details page
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

		// waitThread(2000);
		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);
		waitThread(2000);

		// To click on course drop down
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		softAssert1.assertEquals(getText(ba.ddcoursename1), CourseName.trim(),
				"course name not visible on the dropdown");

		click(ba.ddcoursename1);
		waitThread(2000);

		// Type Assessment Name
		click(QP.Assess_name);
		Assessment_Ongoing = "Assessment_Ongoing" + generateRandomNumber().trim();

		type(QP.Assess_name, Assessment_Ongoing);
		waitThread(3000);

		// Click Save &Next button
		click(ca.Savenext);
		waitThread(2000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");
		softAssert1.assertAll();

	}

//To fill details on the Question page
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

	/*
	 * / To verify the details on the peer review page
	 */
	@Test(priority = 10)
	public void TCSPR1800310() {
		waitThread(4000);
		// Enter peer review Reward score
		type(prw.peer_reward_scorebx, RewardPercent);

		// Assert the text::Total Students : Assert the total student count is 3
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");
	}

	/*
	 * To perform the save and next functionality from peer review page and verify
	 * the schedule page details
	 * 
	 */
	@Test(priority = 11)
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

	/*
	 * To perform Assessment publish functionality and check the details on the
	 * publish pop up
	 */
	@Test(priority = 12)
	public void TCSPR1800312() {
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

	public String AssessmentNameupcoming;

	@Test(priority = 14)
	public void TCSPR1800314() {
		SoftAssert softAssert2 = new SoftAssert();
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

		softAssert2.assertEquals(getText(ba.ddcoursename1), CourseName.trim(),
				"course name not visible on the dropdown");

		click(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentNameupcoming = "Assessment_Upcoming" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentNameupcoming);

		waitThread(2000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(2000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");
		softAssert2.assertAll();

	}

//To fill details on the Question page
	@Test(priority = 15)
	public void TCSPR1800315() {
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

	// to verify details on peer review page
	@Test(priority = 16)
	public void TCSPR1800316() {
		waitThread(4000);
		// Enter peer review Reward score
		type(prw.peer_reward_scorebx, RewardPercent);
		waitThread(2000);

		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");
	}

	// To perform save and next functionality from peer review page and verifying
	// schedule page details
	@Test(priority = 17)
	public void TCSPR1800317() {

		// Click Save&Next button
		click(pr.savennext_button);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);

		waitThread(2000);
		Assert.assertEquals(getAttribute(sb1.schedule_wizard, "aria-expanded"), "true");

		// Assert the text "Select schedules for "
		Assert.assertEquals(getText(sb1.selectstu_lbl), "Select Schedules for");

		// selecting test start date as tommorow's date
		click(sb.assessmentopendate_txtbx);
		cm.ClicktomorrowDate();

		// manually clicking on published result button

		waitThread(3000);

		assessmentopendate = getValue(sb.assessmentopendate_txtbx);
		assessmentduedate = getValue(sb.assessmentduedate_txtbx);
		peerreviewopendate = getValue(sb.peerreviewopendate_txtbx);
		peerreviewduedate = getValue(sb.peerreviewduedate_txtbx);

		waitThread(3000);
		assessmentopentime = getValue(sb.assessmentopentime_txtbx);
		assessmentduetime = getValue(sb.assessmentduetime_txtbx);
		peerreviewopentime = getValue(sb.peerreviewopentime_txtbx1);
		peerreviewduetime = getValue(sb.peerreviewduetime_txtbx);

		// Assert the radio button and label::Teacher will manually publish the result
		Assert.assertEquals(getText(sb.teachermanua_lbl), "Teacher will manually publish the result");

		Assert.assertTrue(isElementPresent(sb.teacherwill_radio), "radio button is present");

		waitThread(5000);
		// Click on Teacher will manually publish the result
		Doubleclick(sb.teacherwill_radio);

		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sbp.summarywizard, "aria-selected"), "true");

	}

	@Test(priority = 18)
	public void TCSPR1800318() {
		// click on Release Button
		click(sbp.btnrelease);

		// Assert button Back to Menu
		Assert.assertTrue(isElementPresent(tts.back_to_menubutton), "Back to menu button not present");
	}

	@Test(priority = 19)
	public void TCSPR1800319() {
		waitThread(2000);
		// Click Back to Menu
		click(tts.back_to_menubutton);

		waitThread(3000);

		// Assert the text "Assessments "
		Assert.assertEquals(getText(ba.lbl_assessment), "Assessments");

		click(st1.assess_searchbx);
		// search the assessment
		type(st1.assess_searchbx, AssessmentNameupcoming);

		// Assert the newly published card visible on the current assessment page

		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");

	}

	@Test(priority = 20)
	public void TCSPR1800320() throws InterruptedException {

		// click course tab
		click(ca.courseTab);

		waitThread(3000);

		click(ca.CourseInfo_btn);

		click(ca.Verifymodify1);
		waitThread(2000);

		// Assert.assertEquals(getText(ca.coursedetailLabel), "Course Details");
		Assert.assertTrue(isElementPresent(ca.ActiveToogle), "toggle button is present");
		TimeUnit.MINUTES.sleep(1);
		click(ca.ActiveToogle);
		waitThread(2000);

	}

	@Test(priority = 21)
	public void TCSPR1800321() throws InterruptedException {
		SoftAssert assert1 = new SoftAssert();
		waitThread(2000);
		// Assert pop up box is visible
		Assert.assertTrue(isElementPresent(ca.Popupbox), "popup box  not visible");

		// Assert the Course : course Name
		waitThread(2000);
		Assert.assertEquals(getText(ca.popupcontent1), "Course: " + CourseName);
		// Assert.assertTrue(isElementPresent(cA.popupcontent1)," Heading missing ");

		// Assert the second content
		assert1.assertEquals(getText(ca.popupcontent2),
				"Are you sure that you want to inactivate this course?\n"
						+ "Note: Along with the course, the following will be inactivated as well -\n"
						+ "* 1 ongoing assessment\n" + "* 1 upcoming assessment",
				"assertion failed");

		// Click yes button
		click(ca.Yes_Button);

		// assert toggle button is disabled
		Assert.assertTrue(isEnabled(ca.ActiveToogle), "Active tooggle is enabled");
		TimeUnit.MINUTES.sleep(1);
		// click on toggle button
		click(ca.ActiveToogle);
		// Assert the toggle button is in active state
		Assert.assertTrue(isEnabled(ca.Activestatus), "Active tooggle is not selected");
		waitThread(2000);
		click(ca.Yes_Button);

		// assert toggle button is enabled
		Assert.assertTrue(isEnabled(ca.ActiveToogle), "Active tooggle is not enabled");
		assert1.assertAll();

	}

	@Test(priority = 22)
	public void TCSPR1800322() {
		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(5000);

		// click on in activated tab
		click(ca.Inactive_tab);
		waitThread(6000);

		// assertion of labels and drop down in in-activated tab
		Assert.assertTrue(isElementPresent(ca.Inactive_DD), "Dropdown not present");
		Assert.assertTrue(isElementPresent(ca.Assess_DD), "Dropdown not present");
		waitThread(2000);
		Assert.assertTrue(isElementPresent(ca.Search_box), "search box not present");
		waitThread(3000);
		Assert.assertTrue(isElementPresent(ca.Search_PH), "search placeholder not present");
		waitThread(2000);

		Assert.assertEquals(getText(ca.SI_no), "Sl No");
		Assert.assertEquals(getText(ca.Assess_name), "Assessment Name");
		Assert.assertEquals(getText(ca.courseName), "Course Name");
		Assert.assertEquals(getText(ca.current_S), "Current Status");
		Assert.assertEquals(getText(ca.Action), "Action");

		// assert assessment name and course name
		Assert.assertEquals(getText(ca.Assessment), Assessment_Ongoing);
		Assert.assertEquals(getText(ca.course), CourseName.trim());

	}

	@Test(priority = 23)
	public void TCSPR1800323() {

		click(ca.Search_box);
		waitThread(1000);

		// search the assessment
		type(ca.Search_box, AssessmentNameupcoming);
		waitThread(2000);

		Assert.assertTrue(isEnabled(ca.activate), " activate is not enabled");
		Assert.assertEquals(getText(ca.testupcoming), "Test Upcoming");
		click(ca.activate);
		waitThread(3000);

		// Assert the Reschedule popup visible
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");

		// Assert the text Reschedule dates
		Assert.assertEquals(getText(rd.reschedyledate_lbl), "Reschedule Dates");

		// asserting the info statements
		Assert.assertEquals(getText(ca.info1), "Students can answer the assessment during these dates only");
		Assert.assertEquals(getText(ca.info2), "Students can perform peer review during these dates only");
	}

	@Test(priority = 24)
	public void TCSPR1800324() {

		// Assert the test open date & time with schedule page date time
		Assert.assertEquals(getValue(ca.testopendate), assessmentopendate);

		Assert.assertEquals(getValue(ca.testopentime), assessmentopentime);

		// Assert the test due date & time with schedule page
		Assert.assertEquals(getValue(ca.testduedate), assessmentduedate);

		Assert.assertEquals(getValue(ca.testduetime), assessmentduetime);

		// Assert the Peer Review open date & time with Schedule page
		Assert.assertEquals(getValue(ca.peeropendate), peerreviewopendate);

		Assert.assertEquals(getValue(ca.peeropentime), peerreviewopentime);

		// Assert the Peer Review due date & time with schedule page
		Assert.assertEquals(getValue(ca.peerduedate), peerreviewduedate);

		Assert.assertEquals(getValue(ca.peerduetime), peerreviewduetime);

	}

	@Test(priority = 25)
	public void TCSPR1800325() {
		// asserting labels-test window, assessment open date and time,due date and time
		Assert.assertEquals(getText(rd.testwindow_lbl), "Test Window");
		Assert.assertEquals(getText(rd.assessopen_lbl), "Assessment Open date and time:");
		Assert.assertEquals(getText(rd.assessdue_lbl), "Assessment Due date and time:");

		// Assert labels-Peer Review - Peer Review Open date & time- Peer Review due
		// date and time
		Assert.assertEquals(getText(rd.peerreview_lbl), "Peer Review");
		Assert.assertEquals(getText(rd.peeropen_lbl), "Peer Review Open date and time:");
		Assert.assertEquals(getText(rd.peerdue_lbl), "Peer Review Due date and time:");
		// asserting cancel and save and reactivate button
		Assert.assertTrue(isElementPresent(ca.cancel), "cancel button not present");
		Assert.assertTrue(isElementPresent(ca.save), "save and reactivate button not present");
		click(ca.cancel);

		// Assert the Reschedule popup not visible
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup present");

	}

	@Test(priority = 26)
	public void TCSPR1800326() {
		// search the assessment
		type(ca.Search_box, AssessmentNameupcoming);
		Assert.assertTrue(isEnabled(ca.activate), " activate is not enabled");
		click(ca.activate);

		// assert result publish label & text boxes not available
		Assert.assertFalse(isElementPresent(rd.resultpub_lbl), "Result Publishing label is available");
		Assert.assertFalse(isElementPresent(rd.resultpublishdate_txtbx), "result publish text box is available");

		// Set the test start day to current day
		waitThread(2000);
		Doubleclick(ca.testopendate);

		waitThread(2000);
		cm.ClickTodaysDate();
		// assert todays date same as present in text box
		Assert.assertEquals(getValue(ca.testopendate), ca.getdate());
		click(ca.save);
		waitThread(1000);
		// assert the toaster visible
		Assert.assertEquals(getText(ca.toaster),
				"The assessment " + AssessmentNameupcoming + " has been successfully activated");

		// search assessment name
		type(ca.Search_box, AssessmentNameupcoming);
		// asserting assessment name not visible
		Assert.assertEquals(getText(ca.no_assess), "No Assessment(s) Found.");

	}

	@Test(priority = 27)
	public void TCSPR1800327() {

		// Click current tab
		waitThread(2000);
		click("//div[@id='assessment_tab_list']//ul//li[1]/a");
		waitThread(2000);

		// click on in activated tab
		click(ca.Inactive_tab);
		waitThread(6000);

		// search the assessment
		click(ca.Search_box);
		waitThread(2000);
		type(ca.Search_box, Assessment_Ongoing);
		Assert.assertTrue(isEnabled(ca.activate), " activate is not enabled");
		Assert.assertEquals(getText(ca.active), "Test Active");
		click(ca.activate);
		waitThread(2000);

		// Assert the Reschedule popup visible
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");

		// Assert the text Reschedule dates
		Assert.assertEquals(getText(rd.reschedyledate_lbl), "Reschedule Dates");

		// test open date text box disabled
		waitThread(2000);
		Assert.assertTrue(getAttribute("//div[@id='inactivatedAssessmentTestOpenDateTimeRow']", "class")
				.contains("row disableDiv"));
		waitThread(1000);

		click(ca.save);
		waitThread(6000);

		// Logout functionality of teacher
		rs.Logout();

		// heading title
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	@Test(priority = 28)
	public void TCSPR1800328() {

		// Login as Student1
		waitThread(2000);
		lg.login1(Emailstudent1, cm.Password);
		waitThread(3000);

		// Click Assessment tab
		click(QP.Assessmenttab);
		waitThread(3000);
		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentNameupcoming);
		waitThread(2000);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");
		waitThread(2000);

		// Search the Assessment Name ongoing
		waitThread(3000);
		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(Assessment_Ongoing);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");
		waitThread(2000);

	}

	@Test(priority = 29)
	public void TCSPR1800329() {

		// student 1 login using deleted account credentials
		waitThread(2000);
		cr.DeleteAccount();

		waitThread(2000);

		// login using deleted account credentials
		lg.login(Emailstudent1, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

		// student 2
		// login using deleted account credentials
		lg.login1(Emailstudent2, password);
		waitThread(2000);
		cr.DeleteAccount();
		waitThread(2000);

		// Teacher login
		waitThread(2000);
		lg.login(Emailteacher, password);
		waitThread(2000);

		// Delete teacher account
		cm.DeleteAccount();
		waitThread(2000);

	}

}
