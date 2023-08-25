package CurrentAssessmentsforStudentsTest;

import java.util.concurrent.TimeUnit;

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
import CurrentAssessmentsforStudents.Pages.StudentPeerReviewPage;
import CurrentAssessmentsforStudents.Pages.StudentResultSectionPage;
import CurrentAssessmentsforStudents.Pages.StudentTestSectionPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.NewAssessmentTeacherBasicsPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import NewAssessmentOfTeacherPage.TeacherResultSectionPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class StudentResultSectionTest extends basePage {
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
	StudentPeerReviewPage sp1 = new StudentPeerReviewPage();
	NewAssessmentTeacherBasicsPage natb = new NewAssessmentTeacherBasicsPage();
	CommonMethods cm = new CommonMethods();
	StudentResultSectionPage srs = new StudentResultSectionPage();

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
	public void TCSPR1100401() {

		click(lg.LoginBtn_1);

		cm.login(cm.emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}
	/*
	 * To create new course
	 */
	// @Test(priority = 2)
//	public void TCSPR1100402() throws SQLException {
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
//	public void TCSPR1100403() {
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
//	public void TCSPR1100404() throws SQLException {
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
//	public void TCSPR1100405() {
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
//	public void TCSPR1100406() throws SQLException {
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
//	public void TCSPR1100407() {
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

	public String CourseID = cm.CourseID1;
	public String CourseName = cm.CourseName1;

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */

	@Test(priority = 8)
	public void TCSPR1100208() {

		SoftAssert softAssert1 = new SoftAssert();

		waitThread(4000);
		// click on Assessment tab
		click(ba.Assessmenttab);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		waitThread(4000);
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
	public void TCSPR1100409() {

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
	public void TCSPR1100410() {
		waitThread(2000);

		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		waitThread(4000);
		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 4");

	}

	public String peerreviewopendate;
	public String peerreviewopentime;
	public String peerreviewduedate;
	public String peerreviewduetime;
	public String assessmentopendate;
	public String assessmentduedate;

	/*
	 * To perform the save and next functionaity from peer review page and verify
	 * the schedule page details
	 */
	@Test(priority = 11)
	public void TCSPR1100411() {

		// Type peer review reward score
		type(pr.PRreward_txtbox, "100");

		waitThread(4000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(2000);
		Assert.assertEquals(getAttribute(sb1.schedule_wizard, "aria-expanded"), "true");

		// Assert the text "Select schedules for "
		Assert.assertEquals(getText(sb1.selectstu_lbl), "Select Schedules for");

		// Assert that the Assessment Open date is Today's date
		Assert.assertEquals(getValue(sb1.assessmentopendate_txtbx), sb1.getdate());

		assessmentopendate = getValue(tts.assessmentopendate_txtbx);
		assessmentduedate = getValue(tts.assessmentduedate_txtbx);
		peerreviewopendate = getValue(sb1.peerreviewopendate_txtbx);
		peerreviewduedate = getValue(sb1.peerreviewduedate_txtbx);
		peerreviewopentime = getValue(sb1.peerreviewopentime_txtbx);
		peerreviewduetime = getValue(sb1.peerreviewduetime_txtbx);
		resultpublishdate = getValue(sb1.resultpublishdate_txtbx);
		resultpublishtime = getValue(sb1.resultpublishtime_txtbx);

		// Click Save&Next button
		click(QP.savenext_btn);

	}

	/*
	 * To perform Assessment publish functionality and check the details on the
	 * publish popup
	 */

	@Test(priority = 12)
	public void TCSPR1100412() {

		waitThread(4000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");

		// Assert the Text "Questions Summary"
		Assert.assertEquals(getText(sq.Summary_quest), "Questions Summary");

		quest_count = getText(sq.total_questcount);
		// Assert the total Questions count
		Assert.assertEquals(getText(sq.total_questcount), "2");

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
	 * To check the back to menu button functionality and check the created
	 * assessment visible on the current assessment tab
	 */
	@Test(priority = 13)
	public void TCSPR1100413() {

		// Click Back to Menu
		click(tts.back_to_menubutton);

		// search newly created assessment
		type(st1.assess_searchbx, AssessmentName);

		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");

		// Assert the Assessment name visible
		Assert.assertEquals(getText(st1.teach_assess_name), AssessmentName);

		// Assert the course name and course ID
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseID));

	}

	/*
	 * To verify the Result section on the assessment card check the labels
	 */
	@Test(priority = 14)
	public void TCSPR1100414() throws InterruptedException {

		TimeUnit.SECONDS.sleep(20);
		// Assert the Test Status is Active
		Assert.assertEquals(getText(tts.test_pending), "Active");

		// Assert the Peer Review status is pending
		Assert.assertEquals(getText(tp.peersts_lbl), "Pending");

		// Assert the Result status is pending
		Assert.assertEquals(getText(tr.resultsts_lbl), "Pending");

		// Assert the timer visible on the card
		Assert.assertTrue(getText(tr.timer).contains("Test active for"), "Timer not visible on card");

	}

	public String resultpublishdate;
	public String resultpublishtime;

	/*
	 * To verify the Result section on the assessment card check the date and time
	 */
	@Test(priority = 15)
	public void TCSPR1100415() {

		// Assert Label Result
		Assert.assertEquals(getText(srs.Result_txt), "Result");

		// Assert label "Result publishing on:"
		Assert.assertEquals((getText(srs.Result_publ_label).substring(0, 21)), "Result Publishing on:");

		// Assert the Result publish date and time
		cm.studentresultdatetimemethod();
		Assert.assertEquals(cm.getdates(cm.resultdate_stud), resultpublishdate);
		Assert.assertEquals(cm.resultime_stud, resultpublishtime);

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 16)
	public void TCSPR1100416() {

		// Perform logout
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform Login functionality of student1 profile and check the Assessment
	 * card
	 */
	@Test(priority = 17)
	public void TCSPR1100417() {

		// login as Student1
		lg.login("student1@gmail.com", password);

		waitThread(5000);

		Doubleclick(st1.stud_searchbx);
		waitThread(2000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);
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
	 * To check the published Assessment card Result section
	 */
	@Test(priority = 18)
	public void TCSPR1100418() {

		// Assert the Text "Result Publishing Date: Will be Updated Shortly"
		Assert.assertEquals(getText(tr.resultpublishdate_lbl), "Result Publishing Date: Will be Updated Shortly");

		// Assert the text Result status "pending"
		Assert.assertEquals(getText(tr.resultsts_lbl), "Pending");

		// Assert Peer Review status pending
		Assert.assertEquals(getText(tp.peersts_lbl), "Pending");
	}

	/*
	 * To perform Logout functionality from student1 profile and Login as Student2
	 */
	@Test(priority = 19)
	public void TCSPR1100419() {
		// perform logoutstudent1
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// login as Student2
		lg.login("student2@gmail.com", password);

		waitThread(3000);
		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		Doubleclick(st1.stud_searchbx);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

	}

	/*
	 * To check Result Section of Student2 Assessment card
	 */
	@Test(priority = 20)
	public void TCSPR1100420() {

		// Assert the Result status as pending
		Assert.assertEquals(getText(tr.resultsts_lbl), "Pending");

		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(st1.Assess_name_card), AssessmentName);
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseID));

		// Assert the teacher name
		Assert.assertTrue(getText(st1.teachername_card).contains(Teachername));

		// Assert the Text "Result Publishing Date: Will be Updated Shortly"
		Assert.assertEquals(getText(tr.resultpublishdate_lbl), "Result Publishing Date: Will be Updated Shortly");

	}

	public String resultpublishdate2;
	public String resultpublishtime2;

	/*
	 * To Login to Teacher profile and To Reschedule Result date
	 */
	@Test(priority = 21)
	public void TCSPR1100421() {
		// Perform logout from Student2
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// Login as teacher
		lg.login("teacherone@gmail.com", password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// click on Assessment tab
		click(ba.Assessmenttab);

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
		// Click on Assessment due date
		// Select Test due date as today's date
		Doubleclick(rd.assessmentduedate_txtbx);
		cm.ClickTodaysDate();

		// Select Peer review Open date as todays date
		Doubleclick(st1.resche_peeropendat_txtbx);
		cm.ClickTodaysDate();

		// Click on peer due date
		// Select peerreview due date as today's date
		Doubleclick(st1.resche_peerdue_date_txtbx);
		cm.ClickTodaysDate();

		// Click Result publishing date
		Doubleclick(rd.resultpublishdate_txtbx);
		cm.ClickTodaysDate();
	
		resultpublishdate2 = getValue(rd.resultpublishdate_txtbx);
		resultpublishtime2 = getValue(rd.resultpublishtime_txtbx);

		// Click Apply changes button
		click(st1.applychanges_btn);

	}

	/*
	 * To check the Active result published card of students
	 */
	@Test(priority = 22)
	public void TCSPR1100422() throws InterruptedException {

		TimeUnit.SECONDS.sleep(30);

		// Logout from Teacher profile
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
		waitThread(3000);

		// Login as Student2
		lg.login("student2@gmail.com", password);

		waitThread(3000);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		click(st1.stud_searchbx);

		waitThread(2000);
		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(3000);

		// Wait 2 minutes to make peer review window close
		TimeUnit.MINUTES.sleep(1);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the Result status as pending
		Assert.assertEquals(getText(tr.resultsts_lbl), "Pending");

		// Assert View Result button disabled
		Assert.assertEquals(getAttribute(tr.evaluateans_btn, "disabled"), "true");

		// Assert the text Results are under consideration
		Assert.assertEquals(tr.getText(tr.resultpublishdate_lbl), "Results are under consideration");

	}

	/*
	 * To make result section active
	 */
	@Test(priority = 23)
	public void TCSPR1100423() throws InterruptedException {

		// Wait 10 minutes to make Result window Active
		TimeUnit.MINUTES.sleep(13);

		// perform logoutstudent2
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// Login as Student1
		lg.login("student1@gmail.com", password);

		waitThread(3000);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		click(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		waitThread(3000);

		// Assert the Result status as Active
		Assert.assertEquals(getText(tr.resultsts_lbl), "Active");

		// Assert Result date visible
		//cm.studentresultdatetimemethod();
		//Assert.assertEquals(cm.getdates(cm.resultdate_stud), resultpublishdate2);
		//Assert.assertEquals(cm.resultime_stud, resultpublishtime2);

	}

	/*
	 * To logout from student 1 profile and login as teacher
	 */
	@Test(priority = 24)
	public void TCSPR1100424() {

		// perform logoutstudent1
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// Login as Teacher

		lg.login("teacherOne@gmail.com", password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	/*
	 * To Create new Assessment with Manually Result publishing method
	 */
	@Test(priority = 25)
	public void TCSPR1100425() {

		Assert.assertEquals(getText(st1.teach_assess_tab), "Assessments");
		waitThread(2000);
		// Click Assessment tab
		click(st1.teach_assess_tab);

		waitThread(3000);
		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		Assert.assertEquals(getText(ba.ddcoursename1), CourseName.trim(), "course name not visible on the dropdown");

		click(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		NewAssessmentName = "Assessment1" + generateRandomNumber().trim();

		type(QP.Assess_name, NewAssessmentName);

		waitThread(1000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(1000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");
	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 26)
	public void TCSPR1100426() {

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
	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 27)
	public void TCSPR1100427() {
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

		waitThread(2000);
		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");
	}

	/*
	 * To verify the details on the peer review page &To perform the save and next
	 * functionaity from peer review page and verify the schedule page details
	 */
	@Test(priority = 28)
	public void TCSPR1100428() {

		waitThread(2000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + NewAssessmentName));

		waitThread(2000);
		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 4");

		// Type peer review reward score
		type(pr.PRreward_txtbox, "100");

		waitThread(4000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the peer schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");

		// Assert the text "Select schedules for "
		Assert.assertEquals(getText(sb1.selectstu_lbl), "Select Schedules for");

		waitThread(2000);
		// Assert that the Assessment Open date is Today's date
		Assert.assertEquals(getValue(sb1.assessmentopendate_txtbx), sb1.getdate());

	}

	/*
	 * To fill the Schedule page details
	 */
	@Test(priority = 29)
	public void TCSPR1100429() {

		waitThread(2000);

		// Assert the assessment open date is current day
		Assert.assertEquals(getValue(sb1.assessmentopendate_txtbx), sb1.getdate());

		// click teacher publish result radio button
		click(tts.teacher_publish_radiobtn);

		waitThread(2000);
		// Allow Reconsideration checkbox
		click(sb1.allowstu_checkbx2);

		waitThread(2000);
		// Assert the time box visible
		Assert.assertTrue(isElementPresent(sb1.lasttime_txtbx), "Time textbox not visible");

		waitThread(2000);
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
	@Test(priority = 30)
	public void TCSPR1100430() {
		// Click Save&Next button
		click(QP.savenext_btn);

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
	@Test(priority = 31)
	public void TCSPR1100431() {

		waitThread(3000);

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
	@Test(priority = 32)
	public void TCSPR1100432() {

		// search newly created assessment
		type(st1.assess_searchbx, NewAssessmentName);

		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");

		// Assert the Assessment name visible
		Assert.assertEquals(getText(st1.teach_assess_name), NewAssessmentName);

		// Assert the course name and course ID
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseID));

	}

	/*
	 * To check the published Assessment card
	 */
	@Test(priority = 33)
	public void TCSPR1100433() {

		waitThread(3000);
		// Assert the Result status is pending
		Assert.assertEquals(getText(tr.resultsts_lbl), "Pending");

		// Assert label -You need to manually publish the result
		Assert.assertEquals(getText(tr.youneed_lbl), "You need to manually publish the result");

	}

	/*
	 * To perform logout functionality on the teacher profile & login as Student 1
	 */
	@Test(priority = 34)
	public void TCSPR1100434() {

		// logout functionality from Teacher profile
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// login as Student1
		lg.login("student1@gmail.com", password);

		waitThread(3000);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(NewAssessmentName);
		waitThread(2000);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

	}

	/*
	 * To check the Result section of card from Student1 profile
	 */
	@Test(priority = 35)
	public void TCSPR1100435() {

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(tr.newasses_lbl), NewAssessmentName);
		Assert.assertTrue(getText(tr.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(tr.course_lbl).contains(CourseID));

		// Assert the teacher name
		Assert.assertTrue(getText(st1.teachername_card).contains(Teachername));

		waitThread(3000);
		// Assert the Result status is pending
		Assert.assertEquals(getText(tr.resultsts_lbl), "Pending");

		// Assert the text "Teacher will publish the result manually"
		Assert.assertEquals(getText(srs.teach_publish_label), "Teacher will publish the result manually");

		// Perform logout of Student1
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);
	}

	/*
	 * To check the Result section of card from Student2 profile
	 */
	@Test(priority = 36)
	public void TCSPR1100436() {

		// login as Student2
		lg.login("student2@gmail.com", password);

		waitThread(2000);
		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		Doubleclick(st1.stud_searchbx);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(NewAssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(tr.newasses_lbl), NewAssessmentName);
		Assert.assertTrue(getText(tr.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(tr.course_lbl).contains(CourseID));

		// Assert the teacher name
		Assert.assertTrue(getText(st1.teachername_card).contains(Teachername));

		waitThread(2000);
		// Assert the Result status is pending
		Assert.assertEquals(getText(tr.resultsts_lbl), "Pending");

		// Assert the text "Teacher will publish the result manually"
		Assert.assertEquals(getText(srs.teach_publish_label), "Teacher will publish the result manually");

	}

	/*
	 * To Login to Teacher profile and To make Result publishing date active
	 */
	@Test(priority = 37)
	public void TCSPR1100437() {

		// Perform logout from Student2
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// Login as teacher
		lg.login("teacherone@gmail.com", password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// click on Assessment tab
		click(ba.Assessmenttab);

		// search newly created assessment
		type(st1.assess_searchbx, NewAssessmentName);

		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");

		// Assert the Assessment name visible
		Assert.assertEquals(getText(st1.teach_assess_name), NewAssessmentName);

		waitThread(3000);
		// Click Splitbutton on Assessment card
		click(st1.split_btn);

		waitThread(2000);
		// Click reschedule dates
		click(st1.reschedule_button);

		waitThread(2000);
		// Click on Assessment due date
		// Select Test due date as today's date
		Doubleclick(rd.assessmentduedate_txtbx);
		cm.ClickTodaysDate();

		// Assert the time on the text box
		Assert.assertEquals(getValue(st1.resche_testduedat_txtbx), st1.getdate());

		// Select Peer review Open date as todays date
		// Assert the peer review open date is todays date
		Doubleclick(rd.peerreviewopendate_txtbx);
		cm.ClickTodaysDate();

		Assert.assertEquals(getValue(st1.resche_peeropendat_txtbx), st1.getdate());

		// Click on peer due date
		// Select peerreview due date as today's date
		Doubleclick(rd.peerreviewduedate_txtbx);
		cm.ClickTodaysDate();

		// Assert the time on the text box
		Assert.assertEquals(getValue(st1.resche_peerdue_date_txtbx), st1.getdate());

		waitThread(2000);

		// Click Apply changes button
		click(st1.applychanges_btn);

	}

	/*
	 * To check the Teacher manually publishing Result section card
	 */
	@Test(priority = 38)
	public void TCSPR1100438() {

		waitThread(3000);
		// Assert the Result status as pending
		Assert.assertEquals(getText(tr.resultsts_lbl), "Pending");

		waitThread(3000);
		// Assert the text "Teacher will publish the result manually"
		Assert.assertEquals(getText(srs.teach_publish_label), "Teacher will publish the result manually");

		// Assert the button view result disabled
		Assert.assertFalse(isEnabled(srs.viewbutonresult), "View button is enabled");

		// perform logout
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

}