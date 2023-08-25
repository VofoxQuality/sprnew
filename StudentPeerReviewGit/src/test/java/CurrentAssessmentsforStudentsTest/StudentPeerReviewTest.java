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
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CreateNewAssessment.Pages.SummaryQuestionsPage;
import CurrentAssessmentsforStudents.Pages.StudentPeerReviewPage;
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

public class StudentPeerReviewTest extends basePage {
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
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
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
	public String quest_count;

	/*
	 * To perform Login functionality
	 */
	@Test(priority = 1)
	public void TCSPR1000201() {

		click(lg.LoginBtn_1);

		lg.login("teacherone@gmail.com", password);

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

	public String CourseID = cm.CourseID1;
	public String CourseName = cm.CourseName1;

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */
	@Test(priority = 8)
	public void TCSPR1000208() {
		SoftAssert softAssert1 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);

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

		waitThread(1000);

		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert the toaster "Question 1 Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");

		click(QP.toasterclosebtn);

		waitThread(5000);
		MouseHover(rd.add_quest_btn);
		click(rd.add_quest_btn);

		waitThread(3000);

		// click on Question box
		driver.switchTo().frame("question_ifr");

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

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "2");

		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Question 2 Saved successfully"
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
	@Test(priority = 10)
	public void TCSPR1000210() {

		waitThread(5000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));
		waitThread(3000);
		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 4");

		// Assert the student names
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), student1.trim());
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), student2.trim());
	}

	/*
	 * To perform the save and next functionaity from peer review page and verify
	 * the schedule page details
	 */

	public String peerreviewopendate;
	public String peerreviewopentime;
	public String peerreviewduedate;
	public String peerreviewduetime;
	public String assessmentopendate;

	@Test(priority = 11)
	public void TCSPR1100311() {

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
		Assert.assertTrue(getText(sb.schedulecoursename).contains(CourseID));
		Assert.assertTrue(getText(sb.schedulecoursename).contains(CourseName.trim()));

		// Assert the text "Select schedules for "
		Assert.assertEquals(getText(sb1.selectstu_lbl), "Select Schedules for");

		// Assert that the Assessment Open date is Today's date
		Assert.assertEquals(getValue(sb1.assessmentopendate_txtbx), sb1.getdate());

		waitThread(3000);

		assessmentopendate = getValue(tts.assessmentopendate_txtbx);
		assessmentduedate = getValue(tts.assessmentduedate_txtbx);
		testopentime = getValue(tts.schedule_testopn_time);
		testduetime = getValue(tts.schedule_testdue_time);
		peerreviewopendate = getValue(sb1.peerreviewopendate_txtbx);
		peerreviewduedate = getValue(sb1.peerreviewduedate_txtbx);
		peerreviewopentime = getValue(sb1.peerreviewopentime_txtbx);
		peerreviewduetime = getValue(sb1.peerreviewduetime_txtbx);

		// Click Save&Next button
		click(QP.savenext_btn);
	}

	/*
	 * To verify the details on the Summary page & publish the Assessment
	 */

	@Test(priority = 12)
	public void TCSPR1100312() {

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
	public void TCSPR1100313() {
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
	public void TCSPR1100314() {

		// Click Back to Menu
		click(tts.back_to_menubutton);
		waitThread(4000);

		Doubleclick(st1.assess_searchbx);

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
	 * To check the peer review section of Assessment card
	 */
	@Test(priority = 15)
	public void TCSPR1100315() {

		// Assert the the "Peer review Pending "
		Assert.assertEquals(getText(tp.peersts_lbl), "Pending");

		// Assert the Peer review due date and time with schedule page date and
		// time
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewopen), peerreviewopendate);
		Assert.assertEquals(cm.timereviewopen, peerreviewopentime);

		// Assert the peer review due date & time is same as Schedule page date

		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewdue), peerreviewduedate);
		Assert.assertEquals(cm.timereviewdue, peerreviewduetime);

		// Assert the text "Peer Reviews Completed"
		Assert.assertEquals(getText(tp.peercompl_lbl), "Peer Reviews Completed");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 16)
	public void TCSPR1100316() {
		// Perform logout
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform Login functionality of student1 profile and check the Assessment
	 * card
	 * 
	 */
	@Test(priority = 17)
	public void TCSPR1100317() {
		// login as Student1
		lg.login("student1@gmail.com", password);

		waitThread(3000);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		click(st1.stud_searchbx);
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
	 * To check the published Assessment card
	 */
	@Test(priority = 18)
	public void TCSPR1100318() throws InterruptedException {

		waitThread(4000);
		// Assert the test Active status time on the top of card
		//Assert.assertTrue(getText(st1.testtime1).contains("Test Active for"));
		
		Assert.assertTrue(getText(st1.testtime2).contains("Test Active for"));
		waitThread(2000);
		// Assert the the "Test Active "
		Assert.assertEquals(getText(tp.teststs_lbl), "Active");
	}

	/*
	 * To check the published Assessment card peer review section
	 */
	@Test(priority = 19)
	public void TCSPR1100319() {

		// Assert the Peer Review open date and time with schedule page time
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewopen_stud), peerreviewopendate);
		Assert.assertEquals(cm.timereviewopen_stud, peerreviewopentime);

		// Assert the Peer review due date and time with schedule page date and
		// time
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewdue_stud), peerreviewduedate);
		Assert.assertEquals(cm.timereviewdue_stud, peerreviewopentime);

		// Assert the text "Peer Reviews Completed"
		Assert.assertEquals(getText(tp.peercompl_lbl), "Peer Reviews Completed");

		// Assert the 0% in the card
		Assert.assertEquals(getText(sp1.zeropercent_card), "0%");
	}

	/*
	 * To login to teacher account and reschedule the peer review open date & end
	 * the test
	 */
	public String peerreviewopendate1;
	public String peerreviewopentime1;
	public String assessmentduedate1;

	@Test(priority = 20)
	public void TCSPR1100320() {
		// Perform logout from Student1
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

		waitThread(2000);
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

		assessmentduedate1 = getValue(st1.resche_testduedat_txtbx);
		testduetime = getValue(st1.resche_testendtime_txtbx);

		peerreviewduedate1 = getValue(st1.resche_peerdue_date_txtbx);
		peerreviewduetime1 = getValue(st1.resche_peerduetime_txtbx);

		// Click on peer review open date
		Doubleclick(rd.peerreviewopendate_txtbx);

		cm.ClickTodaysDate();

		peerreviewopendate1 = getValue(st1.resche_peeropendat_txtbx);
		peerreviewopentime1 = getValue(st1.resche_peeropen_time_txtbx);
		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitFor(QP.toaster);
		// Assert toaster "Changes applied"
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		waitThread(3000);

	}

	/*
	 * To check the Peer review active status card
	 */
	@Test(priority = 21)
	public void TCSPR1100321() throws InterruptedException {

		TimeUnit.SECONDS.sleep(30);

		// Logout from Teacher profile
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
		waitThread(3000);

		// Login as Student1
		lg.login("student1@gmail.com", password);

		waitThread(3000);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		waitThread(3000);
		// Assert the peer review status as active
		Assert.assertEquals(getText(sp1.reviewpending_lbl), "Active");

		// Assert the "Peer Reviews Active for" status time on the top of card
	
		//Assert.assertTrue(getText(st1.testtime1).contains("Peer Reviews Active for"));
		Assert.assertTrue(getText(st1.testtime2).contains("Peer Reviews Active for"));
		// Assert the button begin review
		Assert.assertTrue(isDisplayed(st1.begintest_btn), "Begin Review not present");
		Assert.assertEquals(getText(st1.begintest_btn), "Begin Review");

		// Assert the peer review open date and time with Reschedule page time
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewopen_stud), peerreviewopendate1);
		Assert.assertEquals(cm.timereviewopen_stud, peerreviewopentime1);

		// Assert the Peer review due date and time with reschedule page date and
		// time
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewdue_stud), peerreviewduedate1);
		Assert.assertEquals(cm.timereviewdue_stud, peerreviewduetime1);

	}

	/*
	 * To perform logout functionality from student 1 profile& login as Student 2 ,
	 * check Assessment card
	 */
	@Test(priority = 22)
	public void TCSPR1100322() {

		// perform logoutstudent1
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// login as Student2
		lg.login("student2@gmail.com", password);

		waitThread(2000);
		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		waitThread(2000);
		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(3000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the peer review status as active
		Assert.assertEquals(getText(sp1.reviewpending_lbl), "Active");

		// Assert the button begin review
		Assert.assertTrue(isDisplayed(st1.begintest_btn), "Begin Review not present");
		Assert.assertEquals(getText(st1.begintest_btn), "Begin Review");

		// Assert the peer review open date and time with Reschedule page time
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewopen_stud), peerreviewopendate1);
		Assert.assertEquals(cm.timereviewopen_stud, peerreviewopentime1);

		// Assert the Peer review due date and time with reschedule page date and
		// time
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewdue_stud), peerreviewduedate1);
		Assert.assertEquals(cm.timereviewdue_stud, peerreviewduetime1);

	}

	public String peerreviewduedate1;
	public String peerreviewduetime1;

	/*
	 * To login to teacher account and reschedule the peer review due date
	 */
	@Test(priority = 23)
	public void TCSPR1100323() {
		// Perform logout from Student2
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// Login as teacher
		lg.login("teacherone@gmail.com", password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		waitThread(2000);
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

		waitThread(3000);
		// Click reschedule dates
		click(st1.reschedule_button);

		waitThread(3000);
		// Click on peer due date
		// Select peerreview due date as today's date
		Doubleclick(rd.peerreviewduedate_txtbx);
		cm.ClickTodaysDate();

		peerreviewduedate1 = getValue(st1.resche_peerdue_date_txtbx);
		peerreviewduetime1 = getValue(st1.resche_peerduetime_txtbx);

		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitFor(QP.toaster);
		// Assert toaster "Changes applied"
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		waitThread(2000);

	}

	/*
	 * To check the peer review window closed status card
	 */
	@Test(priority = 24)
	public void TCSPR1100324() throws InterruptedException {

		// Logout from Teacher profile
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
		waitThread(3000);

		// Login as Student2
		lg.login("student2@gmail.com", password);
		waitThread(2000);

		waitThread(2000);
		TimeUnit.SECONDS.sleep(40);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		waitThread(4000);
		// Assert the test status as window closed
		Assert.assertEquals(getText(st1.windowclosd), "Window Closed");

		// Assert the peer review open date and time with Reschedule page time
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewopen_stud), peerreviewopendate1);
		Assert.assertEquals(cm.timereviewopen_stud, peerreviewopentime1);

		// Assert the Peer review due date and time with reschedule page date and
		// time
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewdue_stud), peerreviewduedate1);
		Assert.assertEquals(cm.timereviewdue_stud, peerreviewduetime1);

	}

	/*
	 * To perform logout functionality from student 2 profile& login as Student 1 ,
	 * check Assessment card
	 */
	@Test(priority = 25)
	public void TCSPR1100325() throws InterruptedException {
		// perform logoutstudent2
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// login as Student1
		lg.login("student1@gmail.com", password);

		waitThread(3000);

		waitThread(2000);
		TimeUnit.SECONDS.sleep(40);

		click(st1.stud_searchbx);
		waitThread(2000);
		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		waitThread(3000);
		// Assert the Peer review window closed
		Assert.assertEquals(getText(sp1.peer_window_clsd), "Window Closed");
		waitThread(1000);

		waitThread(2000);
		// Assert the peer review open date and time with Reschedule page time
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewopen_stud), peerreviewopendate1);
		Assert.assertEquals(cm.timereviewopen_stud, peerreviewopentime1);

		// Assert the Peer review due date and time with reschedule page date and
		// time
		cm.studentdatetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewdue_stud), peerreviewduedate1);
		Assert.assertEquals(cm.timereviewdue_stud, peerreviewduetime1);

		waitThread(2000);
		TimeUnit.SECONDS.sleep(40);

		// Assert the status "Result - Upcoming in"
		Assert.assertTrue(getText(st1.testtime2).contains("Result - Upcoming in"));

	}

	/*
	 * To perform logout functionality from student 1 profile &Login as Teacher2
	 */
	@Test(priority = 26)
	public void TCSPR1100326() {
		// Logout from Student1
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// Perform Teacher2 Login functionality

		lg.login("teachertwo@gmail.com", password);

		waitThread(3000);
		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}
	/*
	 * 
	 */
	// @Test(priority = 27)
//		public void TCSPR1100327() throws SQLException {
	//
//			NewCourseName = "Course Name" + generateRandomNumber();
	//
//			// Click on create new course button
//			click(cn.btn_createnew);
	//
//			// To get the Course ID
//			NewCourseID = (getText(cn.course_Id));
	//
//			// type-Course title
//			type(cn.txbx_Coursetitle, CourseName);
	//
//			// click on Add students button
//			click(cn.btn_AddStudents);
	//
//			Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
//			Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";
	//
//			// type email
//			type(cn.tab_textbox, Emailstudent1 + ",");
//			driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
//			type(cn.tab_textbox, Emailstudent2 + ",");
	//
//			// verify email present on the text box
//			Assert.assertEquals(cn.emailvalue(0), Emailstudent1);
	//
//			Assert.assertEquals(cn.emailvalue(1), Emailstudent2);
	//
//			// click on add to list button
//			click(cn.tab_btn_Addtolist);
	//
//			waitThread(2000);
//			waitFor(cr.emailval_1);
	//
//			// verify the Email on the New Students to be invited to this class box
//			Assert.assertEquals(getText(cr.emailval_1), Emailstudent1);
//			Assert.assertEquals(getText(ps.emailval_2), Emailstudent2);
	//
//			// click on create course button
//			click(cn.btn_Createcourse);
	//
//			waitThread(1000);
//			waitFor(cn.toaster);
	//
//			// verify toaster-Course created successfully
//			Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");
	//
//			waitThread(3000);
	//
//			// verify the course title
//			Assert.assertEquals(getText(cn.value_coursetitle).trim(), CourseName.trim());
	//
//		}
	/*
	 * To perform logout functionality on the teacher profile
	 */

//		@Test(priority = 28)
//		public void TCSPR1100328() {
	//
//			// logout functionality
//			rs.Logout();
	//
//			// Heading Title-Login
//			Assert.assertEquals(getText(lg.PageTitle), "Login");
	//
//		}

	/*
	 * To check that invited course request visible on first student 's profile and
	 * accept course request-Read the student name
	 */
//		@Test(priority = 29)
//		public void TCSPR1100329() throws SQLException {
	//
	//
	//
//			lg.login("student1@gmail.com", password);
//	    	waitThread(5000);
	//
//			// verify heading label
//			waitFor(rs.lbl_joincourse);
//			Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");
	//
//			// verify course name visible
//			Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not Present");
	//
//			// verify the the course name
//			Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());
	//
//		}
//		/*
//		 * To Accept course and perform logout functionality on the student profile
//		 */
	//
//		@Test(priority = 30)
//		public void TCSPR1100330() {
	//
//			// click on accept course button
//			click(rs.btn_acceptcourse);
	//
//			// verify the confirmation popup visible
//			Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");
	//
//			// click on Yes button
//			click(rs.popupbtn_Yes);
	//
//			// Toaster message
//			waitFor(rs.toaster);
//			Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
	//
//			// verify the course name visibled on the enrolled section
//			waitFor(rs.enrolledcoursename);
	//
//			Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());
//			waitThread(3000);
	//
//			// perform logout functionality
//			rs.Logout();
	//
//			// Heading Title-Login
//			Assert.assertEquals(getText(lg.PageTitle), "Login");
//		}
	//
//		/*
//		 * To check that invited course request visible on first student 's profile and
//		 * accept course request-Read the student name
//		 */
//		@Test(priority = 31)
//		public void TCSPR1100331() throws SQLException {
	//
//			lg.login("student2@gmail.com", password);
	//
//			waitThread(5000);
	//
//			// verify heading label
//			waitFor(rs.lbl_joincourse);
//			Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");
	//
//			// verify course name visible
//			Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not Present");
	//
//			// verify the the course name
//			Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());
	//
//		}
//		/*
//		 * To Accept course and perform logout functionality on the student profile
//		 */
	//
//		@Test(priority = 32)
//		public void TCSPR1100332() {
	//
//			// click on accept course button
//			click(rs.btn_acceptcourse);
	//
//			// verify the confirmation popup visible
//			Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");
	//
//			// click on Yes button
//			click(rs.popupbtn_Yes);
	//
//			// Toaster message
//			waitFor(rs.toaster);
//			Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
	//
//			// verify the course name visibled on the enrolled section
//			waitFor(rs.enrolledcoursename);
//			Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());
//			waitThread(3000);
	//
//			// perform logout functionality
//			rs.Logout();
	//
//			// Heading Title-Login
//			Assert.assertEquals(getText(lg.PageTitle), "Login");
//		}

	public String CourseIDnew = "C15903";
	public String NewCourseName = "Course Name Two";

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */
	@Test(priority = 33)
	public void TCSPR1100333() {

		SoftAssert softAssert1 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		waitThread(3000);
		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);

		waitThread(2000);
		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		softAssert1.assertEquals(getText(ba.ddcoursename1), NewCourseName.trim(),
				"course name not visible on the dropdown");

		waitThread(2000);
		click(ba.ddcoursename1);

		waitThread(2000);
		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentName1 = "AssessmentQ" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentName1);

		waitThread(3000);

		// Click Save &Next button
		Doubleclick(QP.Savenext);
		waitThread(2000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(3000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), AssessmentName1);

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseIDnew + ", " + NewCourseName.trim());

		softAssert1.assertAll();

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 34)
	public void TCSPR1100334() {

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

		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);

		waitThread(2000);
		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");
	}

	/*
	 * To verify the details on the peer review page
	 */
	@Test(priority = 35)
	public void TCSPR1100335() {
		waitThread(2000);

		waitThread(2000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName1));

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		waitThread(3000);
		// Assert the text::Total Students : Assert the total student count is 3
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 3");

	}

	/*
	 * To perform the save and next functionaity from peer review page and verify
	 * the schedule page details
	 */
	@Test(priority = 36)
	public void TCSPR1100336() {

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
		waitThread(6000);

		// Click Save&Next button
		click(QP.savenext_btn);

	}

	/*
	 * To perform Assessment publish functionality and check the details on the
	 * publish popup
	 */
	@Test(priority = 37)
	public void TCSPR1100337() {

		waitThread(3000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");

		waitThread(2000);
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
	@Test(priority = 38)
	public void TCSPR1100338() {
		// Assert button Back to Menu
		Assert.assertTrue(isElementPresent(tts.back_to_menubutton), "Back to menu button not present");

		waitThread(2000);
		// Click Back to Menu
		click(tts.back_to_menubutton);

		waitThread(3000);
		// search newly created assessment
		type(st1.assess_searchbx, AssessmentName1);

		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");

		// Assert the Assessment name visible
		Assert.assertEquals(getText(st1.teach_assess_name), AssessmentName1);

		// Assert the course name and course ID
		Assert.assertTrue(getText(tp.course_lbl).contains(NewCourseName));
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseIDnew));
	}

	/*
	 * To perform logout functionality on the teacher profile&Login to Student1
	 */
	@Test(priority = 39)
	public void TCSPR1100339() {

		// logout functionality from Teacher profile
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// login as Student1
		lg.login("student5@gmail.com", password);

		waitThread(3000);
		// Click on Course tab
		click(QP.course_tab);

		waitThread(3000);
		// verify heading label enrolled courses
		waitFor(st1.enrolledcourse_lbl);
		Assert.assertEquals(getText(st1.enrolledcourse_lbl), "Enrolled Courses");

		waitThread(3000);

		// Click on Teacher dropdown
		click(sp1.teacher_dropdwn);

		waitThread(3000);
		// Assert the teacher 2 name visible
		Assert.assertEquals(getText(sp1.teachdrop_stud2), Teachername, "course name not visible on the dropdown");

	}

	/*
	 * To check that the teacher dropdown functionality on the student login
	 */
	@Test(priority = 40)
	public void TCSPR1100340() {

		waitThread(3000);
		// Click Assessment tab
		click(QP.Assessmenttab);

		waitThread(3000);

		Doubleclick(st1.stud_searchbx);
		waitThread(2000);
		click(st1.stud_searchbx);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName1);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(st1.Assess_name_card), AssessmentName1);
		Assert.assertTrue(getText(tp.course_lbl).contains(NewCourseName));
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseIDnew));

		// Assert the teacher name
		Assert.assertTrue(getText(st1.teachername_card).contains(Teachername));

		waitThread(2000);
		// Select Teacher 2 from teacher dropdown
		click(sp1.teach_list_drpdwn);

		Assert.assertEquals(getText(sp1.teachname_stud2), Teachername, "course name not visible on the dropdown");

		click(sp1.teachname_stud2);

		waitThread(3000);
		// Click on course drodown
		click(sp1.coursename_drop_stud);

		waitThread(2000);
		// Assert the corressponding course name on the dropdown
		Assert.assertEquals(getText(sp1.course_name_stud), NewCourseName, "course name not visible on the dropdown");

		// Select course name from course dropdown
		click(sp1.course_name_stud);

		// Assert the course name is selected
		Assert.assertEquals(getText(sp1.course_bx), NewCourseName, "course name not visible on the dropdown");

		// To verify only 1 number of assessment card visible
		// Assert.assertEquals(TotalElementsCount(natb.cardcount), 1);

		// Assert the course name and assessment name
		Assert.assertEquals(getText(st1.Assess_name_card), AssessmentName1);
		Assert.assertTrue(getText(tp.course_lbl).contains(NewCourseName));
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseIDnew));

		waitThread(3000);
		// Click on Course tab
		click(QP.course_tab);

		waitThread(4000);
		// Click Assessment tab
		click(QP.Assessmenttab);

		// Assert All selected placeholder visible in Select Teacher field
		Assert.assertEquals(getText(sp1.teach_allselect), "All Selected",
				"All Selected text not visible on the dropdown");

		// Assert 2cards visible on the dropdown
		// Assert.assertEquals(TotalElementsCount(natb.cardcount), 2);

	}

	/*
	 * To perform logout functionality on the student 1 profile& login as Student2
	 * 
	 */
	@Test(priority = 41)
	public void TCSPR1100341() {

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// login as Student2
		lg.login("student6@gmail.com", password);

		waitThread(2000);

		// Click Course tab
		click(QP.course_tab);

		waitThread(3000);
		// Click on Teacher dropdown
		click(sp1.teacher_dropdwn);

		waitThread(3000);
		// Assert the teacher 2 name visible
		Assert.assertEquals(getText(sp1.teachdrop_stud2), Teachername, "course name not visible on the dropdown");

	}

	/*
	 * To check that the teacher dropdown functionality on the student login
	 */
	@Test(priority = 42)
	public void TCSPR1100342() {

		// verify heading label enrolled courses
		waitFor(st1.enrolledcourse_lbl);
		Assert.assertEquals(getText(st1.enrolledcourse_lbl), "Enrolled Courses");

		waitThread(3000);
		// Click Assessment tab
		click(QP.Assessmenttab);

		waitThread(5000);

		Doubleclick(st1.stud_searchbx);
		waitThread(2000);

		click(st1.stud_searchbx);
		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName1);
		waitThread(3000);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(st1.Assess_name_card), AssessmentName1);
		Assert.assertTrue(getText(tp.course_lbl).contains(NewCourseName));
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseIDnew));

		// Assert the teacher name
		Assert.assertTrue(getText(st1.teachername_card).contains(Teachername));

		waitThread(2000);
		// Select Teacher 2 from teacher dropdown
		click(sp1.teach_list_drpdwn);

		waitThread(2000);
		Assert.assertEquals(getText(sp1.teachname_stud2), Teachername, "course name not visible on the dropdown");

		click(sp1.teachname_stud2);

		// Click on course drodown
		click(sp1.coursename_drop_stud);

		// Assert the corressponding course name on the dropdown
		Assert.assertEquals(getText(sp1.course_name_stud), NewCourseName, "course name not visible on the dropdown");

		// Select course name from course dropdown
		click(sp1.course_name_stud);

		// Assert the course name is selected
		Assert.assertEquals(getText(sp1.course_bx), NewCourseName, "course name not visible on the dropdown");

		// To verify only 1 number of assessment card visible
		// Assert.assertEquals(TotalElementsCount(natb.cardcount), 1);

		// Assert the course name and assessment name
		Assert.assertEquals(getText(st1.Assess_name_card), AssessmentName1);
		Assert.assertTrue(getText(tp.course_lbl).contains(NewCourseName));
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseIDnew));

		waitThread(2000);
		// Click on Course tab
		click(QP.course_tab);

		waitThread(2000);
		// Click Assessment tab
		click(QP.Assessmenttab);

		// Assert All selected placeholder visible in Select Teacher field
		Assert.assertEquals(getText(sp1.teach_allselect), "All Selected",
				"All Selected placeholder not visible on the dropdown");

		// Assert 2cards visible on the dropdown
		// Assert.assertEquals(TotalElementsCount(natb.cardcount), 2);

	}

	/*
	 * To perform logout functionality from student 2 profile
	 */
	@Test(priority = 43)
	public void TCSPR1100343() {

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

}
