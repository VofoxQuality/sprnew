package NewAssessmentOfTeacherTest;

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

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import Course.Pages.EditCoursePage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CreateNewAssessment.Pages.SummaryQuestionsPage;
import CreateNewAssessment.Test.BasicDetailsAssessmentTest;
import CurrentAssessmentsforStudents.Pages.StudentTestSectionPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class TeacherTestSectionTest extends basePage {

	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	CourseRosterPage cr = new CourseRosterPage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	EncryptedText et = new EncryptedText();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	EditCoursePage ec = new EditCoursePage();
	BasicDetailsAssessmentTest bdt = new BasicDetailsAssessmentTest();
	SummaryBasicsPage sb = new SummaryBasicsPage();
	TeacherTestSectionPage tts = new TeacherTestSectionPage();
	SummaryQuestionsPage sq = new SummaryQuestionsPage();
	SchedulePageBasicsPage sb1 = new SchedulePageBasicsPage();
	StudentTestSectionPage st1 = new StudentTestSectionPage();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	CommonMethods cm = new CommonMethods();

	public String Emailteacher;
	public String NewCourseTitle;
	public String AssessmentName;
	public String AssessmentName1;
	public String Emailstudent1;
	public String Emailstudent2;
	public String Emailstudent3;
	public String Emailstudent4;
	public String student1 = "Ashley Albert";
	public String student2 = "Ben Alex";
	public String assessmentduedate;
	public String testopentime;
	public String testduetime;
	public String studcount;
	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	/*
	 * To perform Login functionality
	 */
	@Test(priority = 1)
	public void TCSPR1000201() {

		click(lg.LoginBtn_1);

		cm.login(cm.emailteacher, cm.Password);
		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}
	/*
	 * To create new course
	 */
	// @Test(priority = 2)
//	public void TCSPR1000202() throws SQLException {
//
//		CourseName = "Course Name" + generateRandomNumber();
//
//		// Click on create new course button
//		click(cn.btn_createnew);
//
//		// To get the Course ID
//		CourseID = (getText(cn.course_Id));
//
//		// type-Course title
//		type(cn.txbx_Coursetitle, CourseName);
//
//		// click on Add students button
//		click(cn.btn_AddStudents);
//
//		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
//		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";
//
//		// type email
//		type(cn.tab_textbox, Emailstudent1 + ",");
//		driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
//		type(cn.tab_textbox, Emailstudent2 + ",");
//
//		// verify email present on the text box
//		Assert.assertEquals(cn.emailvalue(0), Emailstudent1);
//
//		Assert.assertEquals(cn.emailvalue(1), Emailstudent2);
//
//		// click on add to list button
//		click(cn.tab_btn_Addtolist);
//
//		waitThread(2000);
//		waitFor(cr.emailval_1);
//
//		// verify the Email on the New Students to be invited to this class box
//		Assert.assertEquals(getText(cr.emailval_1), Emailstudent1);
//		Assert.assertEquals(getText(ps.emailval_2), Emailstudent2);
//
//		// click on create course button
//		click(cn.btn_Createcourse);
//
//		waitThread(1000);
//		waitFor(cn.toaster);
//
//		// verify toaster-Course created successfully
//		Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");
//
//		waitThread(3000);
//
//		// verify the course title
//		Assert.assertEquals(getText(cn.value_coursetitle).trim(), CourseName.trim());
//
//	}
	/*
	 * To perform logout functionality on the teacher profile
	 */

//	@Test(priority = 3)
//	public void TCSPR1000203() {
//
//		// logout functionality
//		rs.Logout();
//
//		// Heading Title-Login
//		Assert.assertEquals(getText(lg.PageTitle), "Login");
//
//	}

	/*
	 * To check that invited course request visible on first student 's profile and
	 * accept course request-Read the student name
	 */
//	@Test(priority = 4)
//	public void TCSPR1000204() throws SQLException {
//
//	
//
//		lg.login("student1@gmail.com", password);
//    	waitThread(5000);
//
//		// verify heading label
//		waitFor(rs.lbl_joincourse);
//		Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");
//
//		// verify course name visible
//		Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not Present");
//
//		// verify the the course name
//		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());
//
//	}
//	/*
//	 * To Accept course and perform logout functionality on the student profile
//	 */
//
//	@Test(priority = 5)
//	public void TCSPR1000205() {
//
//		// click on accept course button
//		click(rs.btn_acceptcourse);
//
//		// verify the confirmation popup visible
//		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");
//
//		// click on Yes button
//		click(rs.popupbtn_Yes);
//
//		// Toaster message
//		waitFor(rs.toaster);
//		Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
//
//		// verify the course name visibled on the enrolled section
//		waitFor(rs.enrolledcoursename);
//
//		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());
//		waitThread(3000);
//
//		// perform logout functionality
//		rs.Logout();
//
//		// Heading Title-Login
//		Assert.assertEquals(getText(lg.PageTitle), "Login");
//	}
//
//	/*
//	 * To check that invited course request visible on first student 's profile and
//	 * accept course request-Read the student name
//	 */
//	@Test(priority = 6)
//	public void TCSPR1000206() throws SQLException {
//
//		lg.login("student2@gmail.com", password);
//
//		waitThread(5000);
//
//		// verify heading label
//		waitFor(rs.lbl_joincourse);
//		Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");
//
//		// verify course name visible
//		Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not Present");
//
//		// verify the the course name
//		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());
//
//	}
//	/*
//	 * To Accept course and perform logout functionality on the student profile
//	 */
//
//	@Test(priority = 7)
//	public void TCSPR1000207() {
//
//		// click on accept course button
//		click(rs.btn_acceptcourse);
//
//		// verify the confirmation popup visible
//		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");
//
//		// click on Yes button
//		click(rs.popupbtn_Yes);
//
//		// Toaster message
//		waitFor(rs.toaster);
//		Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
//
//		// verify the course name visibled on the enrolled section
//		waitFor(rs.enrolledcoursename);
//		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());
//		waitThread(3000);
//
//		// perform logout functionality
//		rs.Logout();
//
//		// Heading Title-Login
//		Assert.assertEquals(getText(lg.PageTitle), "Login");
//	}

	public String CourseName2 = "Course Name Two";
	public String CourseID2 = "C16972";

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */
	@Test(priority = 8)
	public void TCSPR1000208() {

		SoftAssert softAssert1 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(10000);
		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		waitThread(2000);
		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);

		// To click on course dropdown
		click(ba.dd_course);

		waitFor(ba.ddcoursename2);

		softAssert1.assertEquals(getText(ba.ddcoursename2), CourseName2.trim(),
				"course name not visible on the dropdown");
		click(ba.ddcoursename2);

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
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID2 + ", " + CourseName2.trim());

		softAssert1.assertAll();

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 9)
	public void TCSPR1000209() {

		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question1");

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

		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");

		click(QP.toasterclosebtn);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	/*
	 * To verify details on the peer review page
	 */
	@Test(priority = 10)
	public void TCSPR1000210() {

		waitThread(5000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));
		waitThread(3000);
		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");

		// Assert the student names
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), student1.trim());
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), student2.trim());

	}

	/*
	 * To verify details on the schedule page
	 */
	public String assessmentopendate;

	@Test(priority = 11)
	public void TCSPR1000211() {

		// Type peer review reward score
		type(pr.PRreward_txtbox, "100");

		waitThread(4000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the peer schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");
		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.scheduleassessmentname).contains("Assessment Name: " + AssessmentName));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.schedulecoursename).contains(CourseID2));
		Assert.assertTrue(getText(sb.schedulecoursename).contains(CourseName2.trim()));

		// Assert that the Assessment Open date is Today's date
		Assert.assertEquals(getValue(tts.assessmentopendate_txtbx), sb1.getdate());

		waitThread(3000);
		// Set Assessment open time as upcoming time(next day)
		click(sb1.assessmentopendate_txtbx);
		waitThread(2000);
		cm.ClicktomorrowDate();

		assessmentopendate = getValue(tts.assessmentopendate_txtbx);
		assessmentduedate = getValue(tts.assessmentduedate_txtbx);
		testopentime = getValue(tts.schedule_testopn_time);
		testduetime = getValue(tts.schedule_testdue_time);
	}

	/*
	 * To verify the details on the Summary page & publish the Assessment
	 */

	@Test(priority = 12)
	public void TCSPR1000212() {

		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");

		// Assert the Text "Questions Summary"
		Assert.assertEquals(getText(sq.Summary_quest), "Questions Summary");

		// Assert the total Questions count
		Assert.assertEquals(getText(sq.total_questcount), "1");

	}

	/*
	 * To perform Assessment publish functionality
	 */
	@Test(priority = 13)
	public void TCSPR1000213() {
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

	}

	/*
	 * To check the published Assessment card
	 */
	@Test(priority = 14)
	public void TCSPR1000214() {
		// Click Back to Menu
		click(tts.back_to_menubutton);

		waitThread(2000);
		// Assert Heading "Assessments"
		Assert.assertEquals(getText(QP.Assessments), "Assessments");

		// search assessment
		type(tts.search_box, AssessmentName);
		waitThread(1000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(tts.Assessmentcard), "Assessment card not visible");

		// Assert the Assessment name visible
		Assert.assertEquals(getText(tts.asses_name_card), AssessmentName);

		// Assert course code,course name
		Assert.assertEquals(getText(rd.newasses_lbl), AssessmentName);
		Assert.assertTrue(getText(rd.course_lbl).contains(CourseName2));
		Assert.assertTrue(getText(rd.course_lbl).contains(CourseID2));
	}

	/*
	 * To check the published Assessment card
	 */
	@Test(priority = 15)
	public void TCSPR1000215() {

		// Assert the tooltips of Assessment name, course name& ID
		MouseHover(tts.asses_name_card);
		Assert.assertEquals(getAttribute(tts.asses_name_card, "tooltipposition"), "top");
		MouseHover(tts.course_nameid_card);
		Assert.assertEquals(getAttribute(tts.course_nameid_card, "tooltipposition"), "bottom");

		// Assert the test upcoming status time
		Assert.assertTrue(isDisplayed(tts.time_status), "Time status not displayed");
		waitThread(2000);
		Assert.assertTrue(getText(tts.time_status).contains("Test upcoming in"));

	}

	/*
	 * To check the test section of Assessment card
	 */
	@Test(priority = 16)
	public void TCSPR1000216() {

		// Assert the the "Test Pending "
		Assert.assertEquals(getText(tts.test_text), "Test");
		waitThread(2000);
		Assert.assertEquals(getText(tts.test_pending), "Pending");

		// Assert the Assessment open date and time with schedule page time
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestopen), assessmentopendate);
		Assert.assertEquals(cm.timetestopen, testopentime);

		// Assert the Assessment due date and time with schedule page date and time
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestdue), assessmentduedate);
		Assert.assertEquals(cm.timetestdue, testduetime);

	}

	/*
	 * To perform delete assessment
	 */
	@Test(priority = 17)
	public void TCSPR1000217() {

		// Assert the 3dot button of 1st Assessment
		Assert.assertTrue(isElementPresent(tts.dot_btn), "dot button not present");

		// Click 3 dot button
		click(tts.dot_btn);

		// Assert the delete Assessment
		Assert.assertTrue(isElementPresent(tts.delete_assess), "Delete Assessment not present");

		waitThread(2000);
		Assert.assertEquals(getText(tts.delete_assess), "Delete Assessment");

		waitThread(2000);
		// Click Delete Assessment
		click(tts.delete_assess);

		waitThread(2000);
		// Assert confirmation popup visible
		Assert.assertTrue(isDisplayed(tts.dele_conf_popup), "Confirmation popup not visible");

		// Assert No button
		Assert.assertTrue(isElementPresent(tts.no_btn_del_popup), "No button not present");

		waitThread(2000);
		// Click No button
		click(tts.no_btn_del_popup);

		waitThread(2000);
		// Assert no confirmation popup visible
		Assert.assertFalse(isElementPresent(tts.dele_conf_popup), "Confirmation popup visible");

		waitThread(2000);
		// Assert the 3dot button of 1st Assessment
		Assert.assertTrue(isElementPresent(tts.dot_btn), "dot button not present");

		waitThread(2000);
		// Click 3 dot button
		click(tts.dot_btn);

		// Assert the delete Assessment
		Assert.assertTrue(isElementPresent(tts.delete_assess), "Delete Assessment not present");

		Assert.assertEquals(getText(tts.delete_assess), "Delete Assessment");
		waitThread(2000);
		// Click Delete Assessment
		click(tts.delete_assess);

		// Assert confirmation popup visible
		Assert.assertTrue(isDisplayed(tts.dele_conf_popup), "Confirmation popup not visible");

		// Assert yes button
		Assert.assertTrue(isElementPresent(tts.yes_btn_del_popup), "Yes button not present");

		waitThread(2000);
		// Click Yes button
		click(tts.yes_btn_del_popup);

		waitFor(QP.toaster);
		// Assert the toaster "Assessment deleted successfully"
		Assert.assertEquals(getText(QP.toaster), "Assessment deleted successfully");

		click(QP.toasterclosebtn);

		waitThread(3000);
		// search assessment
		type(tts.search_box, AssessmentName);
		waitThread(1000);

		// Assert the deleted assessment not visible on page
		Assert.assertEquals(getText(tts.no_assess_found), "No assessment available");
	}

	/*
	 * To create a new assessment for checking test active case
	 */
	@Test(priority = 18)
	public void TCSPR1000218() {

		// Click create new Assessment
		click(ba.btn_createnewassessment);

		// Assert the Basic details label on Wizard
		Assert.assertEquals(getText(QP.basic_detls_wizard), "Basic Details");
		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename2);

		Assert.assertEquals(getText(ba.ddcoursename2), CourseName2.trim(), "course name not visible on the dropdown");

		click(ba.ddcoursename2);

		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentName1 = "Assessment1" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentName1);

		waitThread(1000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(1000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(3000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), AssessmentName1.trim());

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID2 + ", " + CourseName2.trim());

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 19)
	public void TCSPR1000219() {

		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question1");

		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);

		// Click rubric drop down
		click(QP.rubric_drp_btn);
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

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "3");

		// Click on save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 20)
	public void TCSPR1000220() {

		waitThread(2000);
		// Click add question
		click(QP.Add_more_Quest);

		waitThread(3000);
		// Assert the 2.Question label
		Assert.assertEquals(getText(QP.question1), "2." + "\nQuestion");

		// Enter Question3
		driver.switchTo().frame("question_ifr");
		type(QP.Quest_box, "Question2");
		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();

		// Click rubric drop down
		click(QP.rubric_drp_btn);
		waitThread(1000);

		// Click standard rubric radio button
		click(QP.std_rad);

		// Enter data in rubric box
		driver.switchTo().frame("rubric_ifr");
		waitThread(2000);
		type(QP.std_rub_bx, "Rubric");
		driver.switchTo().defaultContent();

		// Enter Max score
		type(QP.max_scorbx, "2");

		waitThread(2000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully");

		click(QP.toasterclosebtn);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	/*
	 * To verify details on the peer review page
	 */
	@Test(priority = 21)
	public void TCSPR1000221() {

		waitThread(3000);
		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");

		studcount = getText(pr.totalstudent_lbl).trim().substring(17, 18);

		// Assert the student names
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), student1.trim());
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), student2.trim());

	}
	/*
	 * To perform the save and next functionaity from peer review page and verify
	 * the schedule page details
	 */

	@Test(priority = 22)
	public void TCSPR1000222() {

		// Type peer review reward score
		type(pr.PRreward_txtbox, "100");

		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the peer schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");
		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.scheduleassessmentname).contains("Assessment Name: " + AssessmentName1));

		// Assert the text "Select schedules for "
		Assert.assertEquals(getText(sb1.selectstu_lbl), "Select Schedules for");

		// Assert the assessment open date is current day
		Assert.assertEquals(getValue(sb1.assessmentopendate_txtbx), sb1.getdate());

		assessmentopendate = getValue(tts.assessmentopendate_txtbx);
		assessmentduedate = getValue(tts.assessmentduedate_txtbx);
		testopentime = getValue(tts.schedule_testopn_time);
		testduetime = getValue(tts.schedule_testdue_time);

	}

	/*
	 * To fill the Schedule page details
	 */
	@Test(priority = 23)
	public void TCSPR1000223() {

		waitThread(2000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(2000);

		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");

		// Assert the Text "Questions Summary"
		Assert.assertEquals(getText(sq.Summary_quest), "Questions Summary");

		// Assert the total Questions count
		Assert.assertEquals(getText(sq.total_questcount), "2");

	}

	/*
	 * To perform Assessment publish functionality
	 */
	@Test(priority = 24)
	public void TCSPR1000224() {

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
		// Assert Heading "Assessments"
		Assert.assertEquals(getText(QP.Assessments), "Assessments");

	}

	/*
	 * To check the published Assessment card
	 */
	@Test(priority = 25)
	public void TCSPR1000225() {

		click(QP.Assessments);
		waitThread(5000);

		// search assessment
		type(tts.search_box, AssessmentName1);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(tts.Assessmentcard), "Assessment card not visible");

		waitThread(2000);
		// Assert the Assessment name visible
		Assert.assertEquals(getText(tts.asses_name_card), AssessmentName1);

		// Assert course code,course name
		Assert.assertTrue(getText(rd.course_lbl).contains(CourseName2));
		Assert.assertTrue(getText(rd.course_lbl).contains(CourseID2));

	}

	/*
	 * To check the published Assessment card
	 */
	@Test(priority = 26)
	public void TCSPR1000226() throws InterruptedException {

		waitThread(10000);
		// Assert the Status "Test Active "
		Assert.assertEquals(getText(tts.test_text), "Test");

		// Assert time
		Assert.assertTrue(isDisplayed(tts.time_status), "Time status not displayed");

		TimeUnit.MINUTES.sleep(1);
		Assert.assertEquals(getText(tts.test_pending), "Active");

		Assert.assertTrue(getText(tts.time_status).contains("Test active for"));

	}

	/*
	 * To check the test active section
	 */
	@Test(priority = 27)
	public void TCSPR1000227() {

		// Assert the Test open date and time with schedule page
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestopen), assessmentopendate);
		Assert.assertEquals(cm.timetestopen, testopentime);

		// Assert the Test due date and time with schedule page date and time
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestdue), assessmentduedate);
		Assert.assertEquals(cm.timetestdue, testduetime);
	}

	/*
	 * To check the total student count graph in Test section
	 */
	@Test(priority = 28)
	public void TCSPR1000228() {

		// Assert the "Students Submitted" text
		Assert.assertEquals(getText(tts.studentscompl_txt), "Students Submitted");

		// Assert the count 0/2
		Assert.assertEquals(getText(tts.student_count_graph), "0/2");

		// Assert the students count in card & total student enrolled count are same
		Assert.assertEquals(getText(tts.student_count_graph).substring(2), studcount);

	}

	/*
	 * To check the Test window closed section
	 */
	@Test(priority = 29)
	public void TCSPR1000229() throws InterruptedException {

		// Reschedule date and make test window close

		waitThread(1000);
		// click menu button
		click(rd.threedot_btn);

		waitThread(1000);
		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(2000);

		// assert popup
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");

		waitThread(2000);
		// Set the Assessment due date to current day
		Doubleclick(rd.assessmentduedate_txtbx);
		waitThread(2000);
		cm.ClickTodaysDate();

		assessmentduedate = getValue(st1.resche_testduedat_txtbx);
		testduetime = getValue(st1.resche_testendtime_txtbx);

		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitFor(QP.toaster);
		// Assert toaster "Changes applied"
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		waitThread(3000);

		// search newly created assessment
		click(rd.search_box);
		type(rd.search_box, AssessmentName1);
		waitThread(3000);

		Assert.assertTrue(isElementPresent(rd.newcard), " new assessment card not visible");

		// Assert the Test open date& time with reschedule page
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestopen), assessmentopendate);
		Assert.assertEquals(cm.timetestopen, testopentime);

		// Assert the Test due date &time with reschedule page
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestdue), assessmentduedate);
		Assert.assertEquals(cm.timetestdue, testduetime);

		// Assert the Test Status closed
		Assert.assertEquals(getText(tts.test_pending), "Window Closed");

	}

	/*
	 * To perform TeacherAccount logout functionality
	 */
	@Test(priority = 30)
	public void TCSPR1000230() {

		waitThread(2000);
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

}