package PeerReviewWindowofIndividualStudentTest;

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
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CurrentAssessmentsforStudents.Pages.StudentCurrentAssessmentBasicsPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.NewAssessmentTeacherBasicsPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowPage;
import PeerReviewWindowofIndividualStudentPages.ReviewByMultipleStudentsPage;
import PeerReviewWindowofIndividualStudentPages.ReviewSubmitAndTeacherAssessmentStatusPopUPPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import TestWindowOfIndividualStudent.AnswerWindowPage;
import TestWindowOfIndividualStudent.ModifyWizardSectionPage;
import TestWindowOfIndividualStudent.StudentAssessmentInfoAndInstructionPage;
import TestWindowOfIndividualStudent.TestWindowAssessmentCardPhasesPage;

public class ReviewSubmitAndTeacherAssessmentStatusPopUPTest extends basePage {

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
	BasicDetailsPageCourseandEditorPage be = new BasicDetailsPageCourseandEditorPage();
	StudentAssessmentInfoAndInstructionPage sa = new StudentAssessmentInfoAndInstructionPage();
	AnswerWindowPage an = new AnswerWindowPage();
	ModifyWizardSectionPage ms = new ModifyWizardSectionPage();
	PeerReviewWindowPage prp = new PeerReviewWindowPage();
	ReviewByMultipleStudentsPage rp = new ReviewByMultipleStudentsPage();
	CommonMethods cm = new CommonMethods();
	StudentCurrentAssessmentBasicsPage sca = new StudentCurrentAssessmentBasicsPage();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	NewAssessmentTeacherBasicsPage natb = new NewAssessmentTeacherBasicsPage();
	ReviewSubmitAndTeacherAssessmentStatusPopUPPage ra = new ReviewSubmitAndTeacherAssessmentStatusPopUPPage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	CommonFileTest cmt = new CommonFileTest();
	SignUpPage sp = new SignUpPage();
	CourseRosterPage cr = new CourseRosterPage();
	EncryptedText et = new EncryptedText();
	public String AssessmentName;
	public String NewAssessmentName;
	public String Emailteacher;
	public String CourseNamenew;
	public String CourseID1;
	public String Emailstudent1;
	public String Emailstudent2;
	public String Emailstudent3;
	public String Emailstudent4;
	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";
	public String Studentfirstname;
	public String Studentlastname;
	public String Studentname;
	public String Studentfirstname2;
	public String Studentlastname2;
	public String Studentname2;
	public String Studentfirstname3;
	public String Studentlastname3;
	public String Studentname3;

	/*
	 * To perform Login functionality
	 */
	@Test(priority = 1)
	public void TCSPR1300401() throws SQLException {

		Emailteacher = cmt.SignUpTeacher();

		// To catch OTP from sending Resource
		cmt.OtpFetch();

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	public String CourseID3;
	public String CourseName3;
	public String student1 = "Ashley Albert";
	public String student2 = "Ben Max";
	public String student3 = "Clara April";

	/*
	 * To create new course
	 */
	@Test(priority = 2)
	public void TCSPR1300402() throws SQLException {

		CourseName3 = "Course Name" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID3 = (getText(cn.course_Id));
		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent3 = "student3" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent4 = "student4" + generateRandomNumber().trim() + "@gmail.com";

		// Invite students to course
		cm.Invitestudentstocourse_4(CourseName3, Emailstudent1, Emailstudent2, Emailstudent3, Emailstudent4);

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 3)
	public void TCSPR1300403() {

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
	public void TCSPR1300404() throws SQLException {

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

	@Test(priority = 5)
	public void TCSPR1300405() {

		// click on accept course button
		click(rs.btn_acceptcourse);

		// verify the confirmation popup visible
		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not  visible");

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
	@Test(priority = 6)
	public void TCSPR1300406() throws SQLException {

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

	@Test(priority = 7)
	public void TCSPR1300407() {

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
	@Test(priority = 8)
	public void TCSPR1300408() throws SQLException {

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

	@Test(priority = 9)
	public void TCSPR1300409() {

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
	@Test(priority = 10)
	public void TCSPR1300410() {

		SoftAssert softAssert1 = new SoftAssert();
		lg.login1(Emailteacher, password);
		waitThread(4000);
		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(12000);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ra.ddcoursename1);

		softAssert1.assertEquals(getText(ra.ddcoursename1), CourseName3.trim(),
				"course name not visible on the dropdown");

		click(ra.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentName = "Assessment___55now" + generateRandomNumber().trim();

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
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID3 + ", " + CourseName3.trim());

		softAssert1.assertAll();

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 11)
	public void TCSPR1300411() {

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
		type(QP.Quest_box, "Question2");
		driver.switchTo().defaultContent();
		waitThread(1000);

		driver.switchTo().defaultContent();

		waitThread(6000);
		ScrollTo_Location(QP.Qassessmentdetails);

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
	@Test(priority = 12)
	public void TCSPR1300412() {

		// Click on +button
		click(an.add_quest_btn);
		waitThread(1000);
		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question 3");
		driver.switchTo().defaultContent();
		waitThread(1000);

		driver.switchTo().defaultContent();

		waitThread(6000);
		ScrollTo_Location(QP.Qassessmentdetails);

		// Click rubric drop down
		// click(QP.rubric_drp_btn);
		waitThread(3000);

		// Click Standard rubric radio button
		click(QP.std_rad);

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
		Assert.assertEquals(getText(QP.toaster), "Question 3 Saved successfully");

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
		type(QP.Quest_box, "Question 4");
		driver.switchTo().defaultContent();
		waitThread(1000);

		driver.switchTo().defaultContent();

		waitThread(6000);
		ScrollTo_Location(QP.Qassessmentdetails);

		// Click rubric drop down
		// click(QP.rubric_drp_btn);
		waitThread(3000);

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R4");

		driver.switchTo().defaultContent();
		waitThread(1000);

		ScrollTo_xy_position(0, -250);
		// Enter Max score
		type(QP.max_scorbx, "3");
		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 4 Saved successfully");

		click(QP.toasterclosebtn);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	/*
	 * To verify the details on the peer review page
	 */
	@Test(priority = 13)
	public void TCSPR1300413() {

		// Select Answer Sheets Per Student =2
		click(rp.reviewans_sheetdropdwn);
		waitThread(2000);
		click(ra.reviewssheet_count);

		// Type peer review reward score
		type(pr.PRreward_txtbox, "10");
		waitThread(1000);

		click(pr.savennext_button);
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);
		waitThread(2000);
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");

	}

	public String assessmentopendate;
	public String assessmentopentime;
	public String assessmentduedate;
	public String assessmentduetime;

	/*
	 * To perform the save and next functionaity from peer review pageand verify
	 * the schedule page details
	 */

	@Test(priority = 14)
	public void TCSPR1300414() {

		// Click on save and next button
		click(pr.savennext_button);
		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");

	}

	/*
	 * To verify the details on the Summary page & publish the Assessment
	 */
	@Test(priority = 15)
	public void TCSPR1300415() {

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");

		// Assert the text "Questions Summary "
		Assert.assertEquals(getText(rp.Summary_quest), "Questions Summary");

		// Assert the Total no: of Questions
		Assert.assertEquals(getText(rp.total_questcount), "4");

	}

	/*
	 * To perform Assessment publish functionality
	 */
	@Test(priority = 16)
	public void TCSPR1300416() {

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
	 * To check the published Assessment card
	 */
	@Test(priority = 17)
	public void TCSPR1300417() {

		// Click on Back to menu button
		click(ap.Backtomenu_btn);

		waitThread(7000);

		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(ap.publish_popup), "popup not visible");

		// Assert the Current Assessment is selected
		Assert.assertEquals(getAttribute(ap.currentassess_tab, "aria-selected"), "true");

		// search assessment
		type(tp.search_box, AssessmentName);
		// driver.findElement(By.cssSelector("span.p-input-icon-left.ml-auto.common-search
		// > input")).sendKeys(" ");
		waitThread(7000);

		// Assert the new assessment card visible
		Assert.assertTrue(isElementPresent(tp.newcard), " new assessment card not visible");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(tp.newasses_lbl), AssessmentName);

	}

	/*
	 * To perform Login functionality of student1 profile and check the
	 * Assessment card
	 */
	@Test(priority = 18)
	public void TCSPR1300418() throws InterruptedException {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(1000);

		lg.login1(Emailstudent1, password);

		// verify heading label enrolled courses
		// waitFor(sa.enrolledcourse_lbl);
		// Assert.assertEquals(getText(sa.enrolledcourse_lbl), "Enrolled
		// Courses");

		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(50);

		// Click Assessment tab
		click(QP.Assessmenttab);

		waitThread(8000);

		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(7000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");
		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(sa.Assess_name_card), AssessmentName);

		// Assert the teacher name
		Assert.assertTrue(getText(sa.teachername_card).contains(Teachername));

	}

	/*
	 * To Begin Test &add answers to questions by Student1
	 */
	@Test(priority = 19)
	public void TCSPR1300419() {

		// Assert the begin test
		Assert.assertTrue(isElementPresent(sa.begintest_btn), "Button not present");

		// click begin test
		click(sa.begintest_btn);
		waitThread(2000);

		// Enter Answer 1
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer1
		type(an.ansplaceholder, "Answer 1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		click(an.saveNext_btn);
		waitThread(1000);

		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-paginator-complete"));

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));
		waitThread(1000);
		SwitchFrame("answer_ifr");

		waitThread(1000);
		// Enter Answer1
		type(an.ansplaceholder, "Answer 2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		click(an.saveNext_btn);
		waitThread(1000);

		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-paginator-complete"));

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));
		waitThread(1000);
		SwitchFrame("answer_ifr");

		waitThread(1000);
		// Enter Answer1
		type(an.ansplaceholder, "Answer 3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		click(an.saveNext_btn);
		waitThread(1000);

		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-paginator-complete"));

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques4_lbl, "class").contains("p-highlight"));
		waitThread(1000);
		SwitchFrame("answer_ifr");

		waitThread(1000);
		// Enter Answer1
		type(an.ansplaceholder, "Answer 4");

		driver.switchTo().defaultContent();
		waitThread(1000);
		Assert.assertTrue(isElementPresent(ms.submit_btn), "Button not visible");

	}

	/*
	 * To submit the Assessment and logout from Student1 profile
	 */
	@Test(priority = 20)
	public void TCSPR1300420() {

		// click submit button
		click(ms.submit_btn);
		waitThread(3000);
		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");

		// Assert the text "You have 2 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(ms.confirmation_txt), "Are you sure you want to submit the assessment?");

		click(ms.submit_confi);
		waitFor(QP.toaster);
		// Click on Back to Assessment
		click(ms.backtoassess_btn);
		waitThread(9000);

		// To check the current assessment tab is selected
		Assert.assertEquals(getAttribute(rp.selectedcurrenttab, "aria-selected"), "true");
		waitThread(3000);

	}

	/*
	 * To Perform Login by Student2 and to Begin Test
	 */
	@Test(priority = 21)
	public void TCSPR1300421() {
		waitThread(3000);
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
		waitThread(1000);

		lg.login1(Emailstudent2, password);

		// verify heading label enrolled courses
		// waitFor(sa.enrolledcourse_lbl);
		// Assert.assertEquals(getText(sa.enrolledcourse_lbl), "Enrolled
		// Courses");

		// Click Assessment tab
		click(QP.Assessmenttab);

		waitThread(5000);

		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(7000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");
		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(sa.Assess_name_card), AssessmentName);

	}

	/*
	 * To Add answers to first Question and 3rd Question
	 */
	@Test(priority = 22)
	public void TCSPR1300422() {

		// click begin test
		click(sa.begintest_btn);
		waitThread(2000);

		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

		// Enter Answer 1
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer1
		type(an.ansplaceholder, "Answer 1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		click(an.saveNext_btn);
		waitThread(1000);

		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-paginator-complete"));

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));
		waitThread(1000);

		click(an.saveNext_btn);
		waitThread(2000);

		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("visitednotattended"));

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));
		waitThread(1000);
		SwitchFrame("answer_ifr");

		waitThread(1000);
		// Enter Answer1
		type(an.ansplaceholder, "Answer 3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		click(an.saveNext_btn);
		waitThread(1000);

		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("complete"));

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques4_lbl, "class").contains("p-highlight"));

	}

	/*
	 * To Submit the Assessment
	 */
	@Test(priority = 23)
	public void TCSPR1300423() {

		// click submit button
		click(ms.submit_btn);
		waitThread(2000);
		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");

		// Assert the text "You have 2 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(ms.confirmation_txt), "You have 2 skipped question(s)! Proceed to submit?");

		click(ms.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster Assessment Submitted
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);
		// Click on Back to Assessment
		click(ms.backtoassess_btn);

		waitThread(6000);
		// To check the current assessment tab is selected
		Assert.assertEquals(getAttribute(rp.selectedcurrenttab, "aria-selected"), "true");
		waitThread(5000);
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To Perform Login by Student3 and to Begin Test
	 */
	@Test(priority = 24)
	public void TCSPR1300424() {

		waitThread(1000);

		lg.login1(Emailstudent3, password);

		// verify heading label enrolled courses
		// waitFor(sa.enrolledcourse_lbl);
		// Assert.assertEquals(getText(sa.enrolledcourse_lbl), "Enrolled
		// Courses");

		// Click Assessment tab
		click(QP.Assessmenttab);

		waitThread(5000);

		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(4000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");
		// Assert the teacher name
		Assert.assertTrue(getText(sa.teachername_card).contains(Teachername));
		// Assert the begin test
		Assert.assertTrue(isElementPresent(sa.begintest_btn), "Button not present");

		// click begin test
		click(sa.begintest_btn);
		waitThread(7000);

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

		// Enter Answer 1
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer1
		type(an.ansplaceholder, "Answer 1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		click(an.saveNext_btn);
		waitThread(1000);

		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-paginator-complete"));

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));
		waitThread(1000);
		SwitchFrame("answer_ifr");

		waitThread(1000);
		// Enter Answer1
		type(an.ansplaceholder, "Answer 2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		click(an.saveNext_btn);
		waitThread(1000);

		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-paginator-complete"));

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));
		waitThread(1000);
		SwitchFrame("answer_ifr");

		waitThread(1000);
		// Enter Answer1
		type(an.ansplaceholder, "Answer 3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		click(an.saveNext_btn);
		waitThread(1000);

		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-paginator-complete"));

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques4_lbl, "class").contains("p-highlight"));

	}

	/*
	 * To Add answers to the questions[1,2,3 Questions Only]
	 */
	@Test(priority = 25)
	public void TCSPR1300425() {

		// click submit button
		click(ms.submit_btn);
		waitThread(3000);
		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");

		// Assert the text "You have 2 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(ms.confirmation_txt), "You have 1 skipped question(s)! Proceed to submit?");

		click(ms.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster Assessment Submitted
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);
		waitThread(3000);
		// Click on Back to Assessment
		click(ms.backtoassess_btn);
		waitThread(10000);
		// To check the current assessment tab is selected
		Assert.assertEquals(getAttribute(rp.selectedcurrenttab, "aria-selected"), "true");
		waitThread(1000);
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform reschedule of Test Window and Peer Review window
	 */
	@Test(priority = 26)
	public void RescheduleTestAndPeerDate() {

		// Login as Teacher
		lg.login1(Emailteacher, cm.Password);

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(5000);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		// Search The Assessment Name
		type(sca.teacherassessmentsearchbox, AssessmentName.trim());
		waitThread(1000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(3000);

		// Click menu button
		click(rd.threedot_btn);
		Assert.assertTrue(isElementPresent(rd.reschedulemenu), "Reschedule Dates menu not present");
		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(2000);
		// Assert the Reschedule popup visible
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");
		click(rd.assessmentduedate_txtbx);

		// To select Todays Date
		cm.ClickTodaysDate();

		waitThread(1000);
		click(rd.peerreviewopendate_txtbx);
		waitThread(1000);
		// To select Todays date
		cm.ClickTodaysDate_PeerReview();
		waitThread(1000);
		// Calendar cal = Calendar.getInstance();
		// int monthNumber2 = cal.get(Calendar.MONTH);
		// int Day = cal.get(Calendar.DAY_OF_MONTH);
		// int monthNumber = monthNumber2 + 1;
		// String monthname = Month.of(monthNumber).name();
		// waitThread(2000);
		// String Dropmonth =
		// DropselectedValue("select.p-datepicker-month.ng-star-inserted");
		//
		// if (monthname.equals(Dropmonth.toUpperCase())) {
		//
		// if (Day < 15) {
		//
		// Doubleclick("//td[contains(@class,'p-datepicker-today')]");
		// waitThread(4000);
		// } else {
		// click("//span[contains(text(),'Su')]");
		// click("//span[contains(text(),'Mo')]");
		// Actions action = new Actions(driver);
		// action.sendKeys(Keys.PAGE_DOWN).build().perform();
		// //action.sendKeys(Keys.PAGE_DOWN).build().perform();
		// waitThread(2000);
		// Doubleclick("//td[contains(@class,'p-datepicker-today')]");
		// waitThread(4000);
		//
		// }
		// } else {
		//
		// click("button.p-datepicker-prev.p-link.p-ripple.ng-star-inserted >
		// span");
		// waitThread(3000);
		// click("//span[contains(text(),'Su')]");
		// click("//span[contains(text(),'Mo')]");
		// Actions action = new Actions(driver);
		// action.sendKeys(Keys.PAGE_DOWN).build().perform();
		// // action.sendKeys(Keys.PAGE_DOWN).build().perform();
		// waitThread(4000);
		// Doubleclick("//td[contains(@class,'p-datepicker-today')]");
		// waitThread(4000);
		// }

		// click on Apply changes button
		click(rd.Applychangesbtn);

		waitFor(QP.toaster);

		// Assert a toaster Changes applied
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		click(QP.toasterclosebtn);

		waitThread(5000);
		// Assert popup not visible
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");
		cm.Logout();
	}

	/*
	 * To perform Login functionality of student1 profile and check the
	 * Assessment card
	 */
	@Test(priority = 26)
	public void TCSPR1300426() {

		waitThread(1000);
		lg.login1(Emailstudent1, password);

		waitThread(10000);

		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(4000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");
		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(sa.Assess_name_card), AssessmentName);
	}

	/*
	 * To load the test window and check that the details on the peer
	 * reviewWindow
	 */
	@Test(priority = 27)
	public void TCSPR1300427() throws InterruptedException {

		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(50);

		waitThread(8000);

		// click on Begin Review Button
		click(prp.btnbeginReview);
		waitThread(3000);
		// verify the 2nd wizard is selected
		Assert.assertTrue(getAttribute(rp.wizardans1, "class").contains("p-highlight"));

		ScrollTo_xy_position(0, 300);
		waitThread(3000);

		click(prp.scorestud1);
		// Type Score for Student 1[Question 1]
		type(prp.scorestud1, "3");
		waitThread(1000);

		click(prp.reviewbtnsaveandexit);

		waitThread(9000);
		// To check the current assessment tab is selected
		Assert.assertEquals(getAttribute(rp.selectedcurrenttab, "aria-selected"), "true");
		waitThread(2000);
		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(4000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

	}

	/*
	 * To perform the teacher login functionality and check the assessment card
	 */
	@Test(priority = 28)
	public void TCSPR1300428() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(1000);

		lg.login1(Emailteacher, password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(5000);

		// search assessment
		type(tp.search_box, AssessmentName);
		waitThread(1000);

		// Assert the new assessment card visible
		Assert.assertTrue(isElementPresent(tp.newcard), " new assessment card not visible");

	}

	public String totalper;

	/*
	 * To check the the details on the peer review section view details page.
	 * [Student resume assessments shoundn't visible on the teacher
	 * profile-Functionality]
	 */
	@Test(priority = 29)
	public void TCSPR1300429() {

		// Click on peer review view details button
		click(ra.viewdet_btn);
		waitThread(1000);

		// Assert popup visible
		Assert.assertTrue(isElementPresent(ra.assesssts_popup), "popup not visible");

		// Assert student name 1
		Assert.assertEquals(getText(ra.studentname1), student1);

		// Assert progressbar value 100
		Assert.assertEquals(getAttribute(ra.progressbar1, "aria-valuenow"), "100");

		// Assert the Answer count is 4/4 for student 1
		Assert.assertEquals(getText(ra.answercount1), "4/4");

		// Assert the Answer Sheets Assigned For Peer Reviewer's names
		Assert.assertEquals(getText(ra.ansforpeer1), student3);
		Assert.assertEquals(getText(ra.ansforpeer2), student2);

		// Assert the progress bar showing 0 percentage for student 1
		Assert.assertEquals(getAttribute(ra.peerprogressbar1, "aria-valuenow"), "20");

		Assert.assertEquals(getText(ra.peercount1), "20%");

		// Assert the reward status is Not eligible for student 1
		Assert.assertEquals(getText(ra.rewardsts1), "Eligible");

		// click close button
		click(ra.closebtn);
		waitThread(1000);

		// Assert popup not visible
		Assert.assertFalse(isElementPresent(ra.assesssts_popup), "popup not visible");
		Assert.assertEquals(getText(ra.teachercardper), "0%");

	}

	/*
	 * To perform Login functionality of student1 profile and check the
	 * Assessment card
	 */
	@Test(priority = 30)
	public void TCSPR1300430() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		lg.login1(Emailstudent1, password);
		waitThread(1000);

		// verify heading label enrolled courses
		// waitFor(sa.enrolledcourse_lbl);
		// Assert.assertEquals(getText(sa.enrolledcourse_lbl), "Enrolled
		// Courses");

		// Click Assessment tab
		click(QP.Assessmenttab);

		waitThread(9000);

		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(" ");
		waitThread(4000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");
	}

	/*
	 * To load the test window and fill with incomplete answer
	 */
	@Test(priority = 31)
	public void TCSPR1300431() {

		// click on Begin Review Button
		click(prp.btnbeginReview);
		waitThread(3000);

		// verify the 2nd wizard is selected
		Assert.assertTrue(getAttribute(rp.wizardans1, "class").contains("p-highlight"));

		ScrollTo_xy_position(0, 300);
		waitThread(3000);

		click(prp.scorestud2);
		// Type Score for Student 1[Question 1]
		type(prp.scorestud2, "2");
		waitThread(1000);

		ScrollTo_xy_position(0, 0);
		waitThread(2000);

		// click submit button
		click(ms.submit_btn);
		waitThread(2000);
		Assert.assertTrue(isDisplayed(ra.confir_popup), "popup not visible");

		// Assert the text "You have 4 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(ra.confirmation_txt), "The review of 3 question(s) was skipped. Do you wish to proceed?");

		click(ra.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);

		// Click on Back to Assessment
		click(ra.backtoassess_btn);

		waitThread(7000);

		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		waitThread(5000);
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(1000);

	}

	/*
	 * To perform the teacher login functionality and check the assessment card
	 */
	@Test(priority = 32)
	public void TCSPR1300432() {

		lg.login1(Emailteacher, password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(5000);

		// search assessment
		type(tp.search_box, AssessmentName);
		waitThread(1000);

		// Assert the new assessment card visible
		Assert.assertTrue(isElementPresent(tp.newcard), " new assessment card not visible");
		Assert.assertEquals(getText(ra.teachercardper), "13%");

	}

	/*
	 * To check the the details on the test section view details page. [Student
	 * Submited reviews visible on the teacher profile-Functionality]
	 */
	@Test(priority = 33)
	public void TCSPR1300433() {

		// Click on peer review details button

		click(ra.viewdet_btn);
		waitThread(1000);

		// assert popup visible
		Assert.assertTrue(isElementPresent(ra.assesssts_popup), "popup not visible");

		// Assert student1 name
		Assert.assertEquals(getText(ra.studentname1), student1);

		// Assert the progress bar showing percentage 40%
		Assert.assertEquals(getAttribute(ra.peerprogressbar1, "aria-valuenow"), "40");
		Assert.assertEquals(getText(ra.peercount1), "40%");

		String a = getText(ra.peercount1);
		a = a.replaceAll("\\D+", "");

		int c = Integer.parseInt(a);

		String b = getText(ra.peercount2);
		b = b.replaceAll("\\D+", "");

		int d = Integer.parseInt(b);

		String e = getText(ra.peercount3);
		e = e.replaceAll("\\D+", "");

		int f = Integer.parseInt(e);

		int percent1 = (c + d + f) / 3;

		String totalper = Integer.toString(percent1);

		// click close button
		click(ra.closebtn);
		waitThread(1000);

		// Assert popup not visible
		Assert.assertFalse(isElementPresent(ra.assesssts_popup), "popup not visible");

		// search assessment
		type(tp.search_box, AssessmentName);
		waitThread(1000);

		// Assert the new assessment card visible
		Assert.assertTrue(isElementPresent(tp.newcard), " new assessment card not visible");

		// Assert the progress bar showing percentage 40%
		Assert.assertEquals(getText(ra.teachercardper), totalper + "%");

	}

	/*
	 * To perform Login functionality of student 2 profile and check the
	 * Assessment card
	 */
	@Test(priority = 34)
	public void TCSPR1300434() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		lg.login1(Emailstudent2, password);

		// verify heading label enrolled courses
		// waitFor(sa.enrolledcourse_lbl);
		// Assert.assertEquals(getText(sa.enrolledcourse_lbl), "Enrolled
		// Courses");

		// Click Assessment tab
		click(QP.Assessmenttab);

		waitThread(5000);

		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(4000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

	}

	/*
	 * To perform review on the student 2 profile
	 */
	@Test(priority = 35)
	public void TCSPR1300435() {

		// click on Begin Review Button
		click(prp.btnbeginReview);
		waitThread(3000);

		ScrollTo_xy_position(0, 300);
		waitThread(3000);

		click(prp.scorestud1);

		// Type Score for Student 1[Question 1]
		type(prp.scorestud1, "2");
		waitThread(1000);

		click(prp.scorestud2);

		// Type Score for Student 1[Question 1]
		type(prp.scorestud2, "2");
		waitThread(1000);

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		// click on save button
		click(prp.reviewbtnsave);
		waitFor(QP.toaster);

		// verify toaster "Saved"
		Assert.assertEquals(getText(QP.toaster), "Saved");
		click(QP.toasterclosebtn);

		// click on 2nd Question
		click(rp.wizardans2);

		// verify the student 1 and student 2 accordian status[Question 2]
		Assert.assertTrue(getAttribute(rp.wizardans2, "class").contains("p-highlight"));

		ScrollTo_xy_position(0, 300);
		waitThread(3000);

		click(prp.scorestud1);

		// Type Score for Student 1[Question 1]
		type(prp.scorestud1, "2");
		waitThread(1000);

		ScrollTo_xy_position(0, 300);
		waitThread(1000);

		// click on save button
		click(prp.reviewbtnsave);
		waitFor(QP.toaster);

		// verify toaster "Saved"
		Assert.assertEquals(getText(QP.toaster), "Saved");
		click(QP.toasterclosebtn);

	}

	/*
	 * To perform logout functionality on the student profile
	 */
	@Test(priority = 36)
	public void TCSPR1300436() {

		// click submit button
		click(ms.submit_btn);
		waitThread(2000);
		Assert.assertTrue(isDisplayed(ra.confir_popup), "popup not visible");

		click(ra.submit_confi);

		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);
		waitThread(4000);
		// Click on Back to Assessment
		click(ra.backtoassess_btn);

		waitThread(7000);

		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		waitThread(5000);
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform the teacher login functionality and check the assessment card
	 */
	@Test(priority = 37)
	public void TCSPR1300437() {

		lg.login1(Emailteacher, password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(8000);

		// search assessment
		type(tp.search_box, AssessmentName);
		waitThread(1000);

		// Assert the new assessment card visible
		Assert.assertTrue(isElementPresent(tp.newcard), " new assessment card not visible");
		Assert.assertEquals(getText(ra.teachercardper), "28%");

	}

	/*
	 * To check the the details on the test section view details page. [Student
	 * Submited reviews visible on the teacher profile-Functionality]
	 */
	@Test(priority = 38)
	public void TCSPR1300438() {

		// Click on peer review details button
		click(ra.viewdet_btn);
		waitThread(1000);

		// Assert popup visible
		Assert.assertTrue(isElementPresent(ra.assesssts_popup), "popup not visible");

		// Assert student name 2
		Assert.assertEquals(getText(ra.studentname2), student2);

		// Assert progressbar shows 43%
		Assert.assertEquals(getAttribute(ra.peerprogressbar2, "aria-valuenow"), "43");
		Assert.assertEquals(getText(ra.peercount2), "43%");

		// click close button
		click(ra.closebtn);
		waitThread(1000);

		// Assert popup not visible
		Assert.assertFalse(isElementPresent(ra.assesssts_popup), "popup not visible");

	}

	/*
	 * To perform Login functionality of student 2 profile and check the
	 * Assessment card
	 */
	@Test(priority = 39)
	public void TCSPR1300439() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		lg.login1(Emailstudent1, password);

		// verify heading label enrolled courses
		// waitFor(sa.enrolledcourse_lbl);
		// Assert.assertEquals(getText(sa.enrolledcourse_lbl), "Enrolled
		// Courses");

		// Click Assessment tab
		click(QP.Assessmenttab);

		waitThread(9000);

		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(4000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

	}

	/*
	 * To perform review on the student 2 profile
	 */
	@Test(priority = 40)
	public void TCSPR1300440() {

		// click on Begin Review Button
		click(prp.btnbeginReview);
		waitThread(3000);

		click(prp.wizardans2);

		ScrollTo_xy_position(0, 300);
		waitThread(3000);

		click(prp.scorestud1);

		// Type Score for Student 2[Question 2]
		type(prp.scorestud1, "2");
		waitThread(3000);
		// click on 3rd Question
		click(rp.wizardans3);

		waitFor(QP.toaster);

		// verify toaster "Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);

		// verify the 3rd wizard selected
		Assert.assertTrue(getAttribute(rp.wizardans3, "class").contains("p-highlight"));

		ScrollTo_xy_position(0, 300);
		waitThread(3000);

		click(prp.scorestud1);

		// Type Score for Student 1[Question 3]
		type(prp.scorestud1, "2");
		waitThread(1000);

		click(prp.scorestud2);

		// Type Score for Student 1[Question 3]
		type(prp.scorestud2, "2");
		waitThread(1000);

		// click on 4th Question
		click(rp.wizardans4);

		waitFor(QP.toaster);
		// verify toaster "Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(1000);
		// verify the 4th wizard is selected
		Assert.assertTrue(getAttribute(rp.wizardans4, "class").contains("p-highlight"));

		// click submit button
		click(ms.submit_btn);
		waitThread(2000);
		Assert.assertTrue(isDisplayed(ra.confir_popup), "popup not visible");

		click(ra.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);
		waitThread(3000);

		// Click on Back to Assessment
		click(ms.backtoassess_btn_1);

		waitThread(9000);

		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

	}

	/*
	 * To perform the teacher login functionality and check the assessment card
	 */
	@Test(priority = 41)
	public void TCSPR1300441() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(1000);

		lg.login1(Emailteacher, password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(8000);

		// search assessment
		type(tp.search_box, AssessmentName);
		waitThread(1000);

		// Assert the new assessment card visible
		Assert.assertTrue(isElementPresent(tp.newcard), " new assessment card not visible");

		// Assert the peer review completed % is 47%
		Assert.assertEquals(getText(ra.teachercardper), "48%");

	}

	/*
	 * To check the the details on the test section view details page.[Student
	 * Submited reviews visible on the teacher profile-Functionality]
	 */
	@Test(priority = 42)
	public void TCSPR1300442() {

		// Click on peer review details button
		click(ra.viewdet_btn);
		waitThread(1000);

		// Assert the popup visible
		Assert.assertTrue(isElementPresent(ra.assesssts_popup), "popup not visible");

		// Assert the student 2 name
		Assert.assertEquals(getText(ra.studentname2), student2);

		// Assert the progress bar showing percentage 100%
		Assert.assertEquals(getAttribute(ra.peerprogressbar2, "aria-valuenow"), "43");
		Assert.assertEquals(getText(ra.peercount2), "43%");

		// Assert Label "Eligible" for student 2
		Assert.assertEquals(getText(ra.rewardsts1), "Eligible");

	}

	/*
	 * To perform Delete Teacher Account functionality
	 */
	@Test(priority = 43)
	public void TCSPR1300443_DeleteTeacher() {
		// click close button
		click(ra.closebtn);
		waitThread(1000);

		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(ra.assesssts_popup), "popup not visible");
		waitThread(2000);
		cr.DeleteAccount();

		// Heading Title-Login
		// Assert.assertEquals(getText(lg.PageTitle), "Login");

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
	@Test(priority = 44)
	public void TCSPR1300444_DeleteStudent2() {

		// login using deleted account credentials
		lg.login1(Emailstudent2, password);
		waitThread(2000);
		cr.DeleteAccount();

		// Heading Title-Login
		// Assert.assertEquals(getText(lg.PageTitle), "Login");

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
	@Test(priority = 45)
	public void TCSPR1300445_DeleteStudent1() {

		// login using deleted account credentials
		lg.login1(Emailstudent1, password);
		waitThread(2000);
		cr.DeleteAccount();

		// Heading Title-Login
		// Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

		// login using deleted account credentials
		lg.login(Emailstudent1, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

}
