package CurrentAssessmentsforStudentsTest;

import java.util.concurrent.TimeUnit;

import org.apache.xalan.xsltc.compiler.sym;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import CreateNewAssessment.Pages.AssessmentPublishPopupPage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
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

public class StudentTestSectionTest extends basePage {

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
	CommonMethods cm = new CommonMethods();
	StudentTestSectionPage st1 = new StudentTestSectionPage();

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
	public void TCSPR1100201() {

		click(lg.LoginBtn_1);

		cm.login(cm.emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}
	/*
	 * To create new course
	 */
	// @Test(priority = 2)
	// public void TCSPR1100202() throws SQLException {
	//
	// CourseName = "Course Name" + generateRandomNumber();
	//
	// // Click on create new course button
	// click(cn.btn_createnew);
	//
	// // To get the Course ID
	// CourseID = (getText(cn.course_Id));
	//
	// // type-Course title
	// type(cn.txbx_Coursetitle, CourseName);
	//
	// // click on Add students button
	// click(cn.btn_AddStudents);
	//
	// Emailstudent1 = "student1" + generateRandomNumber().trim() +
	// "@gmail.com";
	// Emailstudent2 = "student2" + generateRandomNumber().trim() +
	// "@gmail.com";
	//
	// // type email
	// type(cn.tab_textbox, Emailstudent1 + ",");
	// driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
	// type(cn.tab_textbox, Emailstudent2 + ",");
	//
	// // verify email present on the text box
	// Assert.assertEquals(cn.emailvalue(0), Emailstudent1);
	//
	// Assert.assertEquals(cn.emailvalue(1), Emailstudent2);
	//
	// // click on add to list button
	// click(cn.tab_btn_Addtolist);
	//
	// waitThread(2000);
	// waitFor(cr.emailval_1);
	//
	// // verify the Email on the New Students to be invited to this class box
	// Assert.assertEquals(getText(cr.emailval_1), Emailstudent1);
	// Assert.assertEquals(getText(ps.emailval_2), Emailstudent2);
	//
	// // click on create course button
	// click(cn.btn_Createcourse);
	//
	// waitThread(1000);
	// waitFor(cn.toaster);
	//
	// // verify toaster-Course created successfully
	// Assert.assertEquals(getText(cn.toaster).trim(), "Course created
	// successfully");
	//
	// waitThread(3000);
	//
	// // verify the course title
	// Assert.assertEquals(getText(cn.value_coursetitle).trim(),
	// CourseName.trim());
	//
	// }
	/*
	 * To perform logout functionality on the teacher profile
	 */

	// @Test(priority = 3)
	// public void TCSPR1100203() {
	//
	// // logout functionality
	// rs.Logout();
	//
	// // Heading Title-Login
	// Assert.assertEquals(getText(lg.PageTitle), "Login");
	//
	// }

	/*
	 * To check that invited course request visible on first student 's profile and
	 * accept course request-Read the student name
	 */
	// @Test(priority = 4)
	// public void TCSPR1100204() throws SQLException {
	//
	//
	//
	// lg.login("student1@gmail.com", password);
	// waitThread(5000);
	//
	// // verify heading label
	// waitFor(rs.lbl_joincourse);
	// Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");
	//
	// // verify course name visible
	// Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not
	// Present");
	//
	// // verify the the course name
	// Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());
	//
	// }
	// /*
	// * To Accept course and perform logout functionality on the student
	// profile
	// */
	//
	// @Test(priority = 5)
	// public void TCSPR1100205() {
	//
	// // click on accept course button
	// click(rs.btn_acceptcourse);
	//
	// // verify the confirmation popup visible
	// Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not
	// visible");
	//
	// // click on Yes button
	// click(rs.popupbtn_Yes);
	//
	// // Toaster message
	// waitFor(rs.toaster);
	// Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
	//
	// // verify the course name visibled on the enrolled section
	// waitFor(rs.enrolledcoursename);
	//
	// Assert.assertEquals(getText(rs.enrolledcoursename).trim(),
	// CourseName.trim());
	// waitThread(3000);
	//
	// // perform logout functionality
	// rs.Logout();
	//
	// // Heading Title-Login
	// Assert.assertEquals(getText(lg.PageTitle), "Login");
	// }
	//
	// /*
	// * To check that invited course request visible on first student 's
	// profile and
	// * accept course request-Read the student name
	// */
	// @Test(priority = 6)
	// public void TCSPR1100206() throws SQLException {
	//
	// lg.login("student2@gmail.com", password);
	//
	// waitThread(5000);
	//
	// // verify heading label
	// waitFor(rs.lbl_joincourse);
	// Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");
	//
	// // verify course name visible
	// Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not
	// Present");
	//
	// // verify the the course name
	// Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());
	//
	// }
	// /*
	// * To Accept course and perform logout functionality on the student
	// profile
	// */
	//
	// @Test(priority = 7)
	// public void TCSPR1100207() {
	//
	// // click on accept course button
	// click(rs.btn_acceptcourse);
	//
	// // verify the confirmation popup visible
	// Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not
	// visible");
	//
	// // click on Yes button
	// click(rs.popupbtn_Yes);
	//
	// // Toaster message
	// waitFor(rs.toaster);
	// Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
	//
	// // verify the course name visibled on the enrolled section
	// waitFor(rs.enrolledcoursename);
	// Assert.assertEquals(getText(rs.enrolledcoursename).trim(),
	// CourseName.trim());
	// waitThread(3000);
	//
	// // perform logout functionality
	// rs.Logout();
	//
	// // Heading Title-Login
	// Assert.assertEquals(getText(lg.PageTitle), "Login");
	// }

	public String CourseID = cm.CourseID1;
	public String CourseName = cm.CourseName1;

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */
	@Test(priority = 8)
	public void TCSPR1100208() {

		SoftAssert softAssert1 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(7000);
		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		waitThread(3000);
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
	public void TCSPR1100209() {

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

		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);

		// Click + button
		click(rd.add_quest_btn);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		waitThread(2000);

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question2");

		driver.switchTo().defaultContent();

		ScrollTo_Location(QP.Qassessmentdetails);
		waitThread(3000);

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
		type(QP.std_rub_bx, "R2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "5");
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
	 * To verify the details on the peer review page
	 */
	@Test(priority = 10)
	public void TCSPR1100210() {
		waitThread(2000);

		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 4");

	}

	public String assessmentopendate;
	public String assessmentduedate;
	public String testopentime;
	public String testduetime;

	/*
	 * To perform the save and next functionaity from peer review page and verify
	 * the schedule page details
	 */
	@Test(priority = 11)
	public void TCSPR1100211() {

		type(pr.PRreward_txtbox, "100");
		waitThread(3000);

		click(pr.savennext_button);

		waitThread(2000);
		Assert.assertEquals(getAttribute(sb1.schedule_wizard, "aria-expanded"), "true");
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);
		// Assert the text "Select schedules for "
		Assert.assertEquals(getText(sb1.selectstu_lbl), "Select Schedules for");

		// Assert that the Assessment Open date is Today's date
		Assert.assertEquals(getValue(sb1.assessmentopendate_txtbx), sb1.getdate());

		waitThread(3000);
		// Set Assessment open time as upcoming time(next day)
		click(sb1.assessmentopendate_txtbx);
		waitThread(2000);
		cm.ClicktomorrowDate();

		assessmentopendate = getValue(tts.assessmentopendate_txtbx);
		assessmentduedate = getValue(tts.assessmentduedate_txtbx);
		testopentime = getValue(tts.schedule_testopn_time);
		testduetime = getValue(tts.schedule_testdue_time);

		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);
	}

	/*
	 * To verify the details on the Summary page & publish the Assessment
	 */

	@Test(priority = 12)
	public void TCSPR1100212() {

		waitThread(3000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");

		// Assert the Text "Questions Summary"
		Assert.assertEquals(getText(sq.Summary_quest), "Questions Summary");

		quest_count = getText(sq.total_questcount);
		// Assert the total Questions count
		Assert.assertEquals(getText(sq.total_questcount), "2");

	}

	/*
	 * To perform Assessment publish functionality
	 */
	@Test(priority = 13)
	public void TCSPR1100213() {
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
	public void TCSPR1100214() {

		// Click Back to Menu
		click(tts.back_to_menubutton);

		waitThread(3000);
		// Assert Heading "Assessments"
		Assert.assertEquals(getText(QP.Assessments), "Assessments");

		// search assessment
		click(tts.search_box);
		type(tts.search_box, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(tts.Assessmentcard), "Assessment card not visible");

		// Assert the Assessment name visible
		Assert.assertEquals(getText(rd.newasses_lbl), AssessmentName);

		// Assert the course name and course ID
		Assert.assertTrue(getText(rd.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(rd.course_lbl).contains(CourseID));

	}

	/*
	 * To check the test section of Assessment card
	 */
	@Test(priority = 15)
	public void TCSPR1100215() {

		waitThread(3000);
		// Assert the the "Test Pending "
		Assert.assertEquals(getText(tts.test_pending), "Pending");

		// Assert the Assessment open date and time with schedule page time
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestopen), assessmentopendate);
		Assert.assertEquals(cm.timetestopen, testopentime);

		// Assert the Assessment due date and time with schedule page date and
		// time
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestdue), assessmentduedate);
		Assert.assertEquals(cm.timetestdue, testduetime);

		// Assert the text "Students Submitted"
		Assert.assertEquals(getText(st1.stud_compl_txt), "Students Submitted");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 16)
	public void TCSPR1100216() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform Login functionality of student1 profile and check the Assessment
	 * card
	 */
	@Test(priority = 17)
	public void TCSPR1100217() {
		// login as Student1
		lg.login("student1@gmail.com", password);

		waitThread(3000);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(5000);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(st1.Assess_name_card), AssessmentName);
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseID));

		// Assert the teacher name
		Assert.assertTrue(getText(st1.teachername_card).contains(Teachername));
	}

	/*
	 * To check the published Assessment card
	 */
	@Test(priority = 18)
	public void TCSPR1100218() {

		// Assert the tooltips of Assesssment name, coursename, id& Teacher name
		MouseHover(st1.Assess_name_card);

		// Assert the test upcoming status time
		Assert.assertTrue(getText(st1.testtime2).contains("Test Begins in"));

		// Assert the the "Test Pending "
		Assert.assertEquals(getText(tp.teststs_lbl), "Pending");

	}

	/*
	 * To check the published Assessment card
	 */
	@Test(priority = 19)
	public void TCSPR1100219() {

		// Assert the Assessment open date and time with schedule page time

		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestopen_stud), assessmentopendate);
		Assert.assertEquals(cm.timetestopen_stud, testopentime);

		// Assert the Assessment due date and time with teacher card date and
		// time
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestdue_stud), assessmentduedate);
		Assert.assertEquals(cm.timetestdue_stud, testduetime);

		// Assert the text "Questions Answered"
		Assert.assertEquals(getText(st1.Quest_ans_lbl), "Questions Answered");

		// Assert the Question count in the card is same as summary page
		// questions count
		Assert.assertTrue(getText(st1.quest_count).contains(quest_count));
	}

	/*
	 * To perform logout functionality from student 1 profile
	 */
	@Test(priority = 20)
	public void TCSPR1100220() {

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To login as Student2 and to check the Assessment status
	 */
	@Test(priority = 21)
	public void TCSPR1100221() {
		// login as Student2
		lg.login("student2@gmail.com", password);

		waitThread(3000);

		// search newly created assessment
		click(st1.stud_searchbx);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(st1.Assess_name_card), AssessmentName);
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseID));

		// Assert the teacher name
		Assert.assertTrue(getText(st1.teachername_card).contains(Teachername));

	}

	/*
	 * To check the published Assessment card
	 */
	@Test(priority = 22)
	public void TCSPR1100222() {

		// Assert the test upcoming status time
		Assert.assertTrue(getText(st1.testtime2).contains("Test Begins in"));

		// Assert the the "Test Pending "
		Assert.assertEquals(getText(tp.teststs_lbl), "Pending");

		// Assert the text "Questions Answered"
		Assert.assertEquals(getText(st1.Quest_ans_lbl), "Questions Answered");

		// Assert the Assessment open date and time with schedule page time
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestopen_stud), assessmentopendate);
		Assert.assertEquals(cm.timetestopen_stud, testopentime);

		// Assert the Assessment due date and time with schedule page date and
		// time
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestdue_stud), assessmentduedate);
		Assert.assertEquals(cm.timetestdue_stud, testduetime);

		// logout From Student2

		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To login to Teacher account and reschedule assessment open date to make test
	 * active
	 */
	public String assessmentopendate1;

	@Test(priority = 23)
	public void TCSPR1100223() {
		// Login as teacher
		cm.login(cm.emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		waitThread(2000);
		// click on Assessment tab
		click(ba.Assessmenttab);

		waitThread(2000);
		// search assessment
		type(tts.search_box, AssessmentName);
		waitThread(1000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(tts.Assessmentcard), "Assessment card not visible");
		waitThread(1000);

		// click menu button
		click(rd.threedot_btn);

		waitThread(2000);
		// Assert the text Reschedule dates
		Assert.assertEquals(getText(rd.reschedulemenu), "Reschedule Dates");

		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(1000);

		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");
		
		// Set the Assessment open date to current day
		click(rd.assessmentopendate_txtbx);
		waitThread(1000);
		cm.ClickTodaysDate();

		assessmentopendate1 = getValue(st1.resche_testopendat_txtbx);
		assessmentduedate = getValue(st1.resche_testduedat_txtbx);
		testopentime = getValue(st1.resche_testopentime_txtbx);
		testduetime = getValue(st1.resche_testendtime_txtbx);

		// click apply changes button
		click(rd.applychanges_btn);

		waitFor(QP.toaster);
		// Assert toaster "Changes applied"
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		// Logout from Teacher profile

		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * To check the Test active status card
	 */
	@Test(priority = 24)
	public void TCSPR1100224() {

		// login as Student2
		lg.login("student2@gmail.com", password);

		waitThread(3000);

		// search newly created assessment
		click(st1.stud_searchbx);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(3000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the test status as active
		Assert.assertEquals(getText(tp.teststs_lbl), "Active");

		// Assert the button begin test
		Assert.assertTrue(isDisplayed(st1.begintest_btn), "Begin test not present");
		Assert.assertEquals(getText(st1.begintest_btn), "Begin Test");

		// Assert the Assessment open date and time with Reschedule page time
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestopen_stud), assessmentopendate1);
		Assert.assertEquals(cm.timetestopen_stud, testopentime);

		// Assert Assessment due date & time with schedule page
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestdue_stud), assessmentduedate);
		Assert.assertEquals(cm.timetestdue_stud, testduetime);

	}

	/*
	 * To perform logout functionality from student 2 profile& login as Student 1,
	 * check Assessment card
	 */
	@Test(priority = 25)
	public void TCSPR1100225() {
		// perform logoutstudent2
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// login as Student1
		lg.login("student1@gmail.com", password);

		waitThread(2000);
		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		waitThread(2000);
		// Assert the test status as active
		Assert.assertEquals(getText(tp.teststs_lbl), "Active");

		// Assert the button begin test
		Assert.assertTrue(isDisplayed(st1.begintest_btn), "Begin test not present");
		Assert.assertEquals(getText(st1.begintest_btn), "Begin Test");

		// Assert the Assessment open date and time with Reschedule page time
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestopen_stud), assessmentopendate1);
		Assert.assertEquals(cm.timetestopen_stud, testopentime);

		// Assert Assessment due date & time with schedule page
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestdue_stud), assessmentduedate);
		Assert.assertEquals(cm.timetestdue_stud, testduetime);

	}

	/*
	 * To perform logout functionality from student 1 profile& login as teacher,
	 * reschedule the test due date
	 */
	public String assessmentduedate1;

	@Test(priority = 26)
	public void TCSPR1100226() {

		// perform logoutstudent1
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// Login as Teacher
		cm.login(cm.emailteacher, cm.Password);

		waitThread(2000);
		// Click Assessment tab
		click(st1.teach_assess_tab);

		waitThread(3000);
		// search newly created assessment
		type(st1.assess_searchbx, AssessmentName);

		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");

		// Assert the Assessment name visible
		Assert.assertEquals(getText(st1.teach_assess_name), AssessmentName);

		waitThread(3000);
		// Click Splitbutton on Assessment card
		click(st1.split_btn);

		waitThread(2000);
		// Click reschedule dates
		click(st1.reschedule_button);

		waitThread(2000);
		// Set the Assessment due date to current day
		Doubleclick(rd.assessmentduedate_txtbx);
		waitThread(2000);
		cm.ClickTodaysDate();

		assessmentduedate1 = getValue(st1.resche_testduedat_txtbx);
		testduetime = getValue(st1.resche_testendtime_txtbx);

		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitFor(QP.toaster);
		// Assert toaster "Changes applied"
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		waitThread(3000);

	}

	/*
	 * To perform logout functionality from teacher profile& login as Student 2,
	 * check Assessment card & test due date status
	 */
	@Test(priority = 27)
	public void TCSPR1100227() {

		waitThread(2000);

		// Logout from teacher profile
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// login as Student2
		lg.login("student2@gmail.com", password);

		Doubleclick(st1.stud_searchbx);
		waitThread(2000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the test status as window closed
		Assert.assertEquals(getText(st1.windowclosd), "Window Closed");

		// Assert the Assessment open date and time with Reschedule page time
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestopen_stud), assessmentopendate1);
		Assert.assertEquals(cm.timetestopen_stud, testopentime);

		// Assert Assessment due date with reschedule page
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestdue_stud), assessmentduedate1);
		Assert.assertEquals(cm.timetestdue_stud, testduetime);

		// Assert the status peer review begins in _mins
		Assert.assertTrue(getText(st1.testtime2).contains("Peer Reviews - Begins in"));

	}

	/*
	 * To check the Test window closed status card in student1
	 */
	@Test(priority = 28)
	public void TCSPR1100228() {
		// Logout from Student2
		rs.Logout();

		// login as Student1
		lg.login("student1@gmail.com", password);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the test status as window closed
		Assert.assertEquals(getText(st1.windowclosd), "Window Closed");
		waitThread(1000);

		// Assert the Assessment open date and time with Reschedule page time
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestopen_stud), assessmentopendate1);
		Assert.assertEquals(cm.timetestopen_stud, testopentime);

		// Assert Assessment due date with reschedule page
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestdue_stud), assessmentduedate1);
		Assert.assertEquals(cm.timetestdue_stud, testduetime);

		// Assert the status peer review begins in _mins
		Assert.assertTrue(getText(st1.testtime2).contains("Peer Reviews - Begins in"));

	}

	/*
	 * To perform logout functionality from student 1 profile
	 */
	@Test(priority = 29)
	public void TCSPR1100229() {

		// perform logoutstudent1
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

}
