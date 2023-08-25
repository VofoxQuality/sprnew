package CurrentAssessmentsforStudentsTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import Course.Pages.EditCoursePage;
import Course.Test.EditCourseTest;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CreateNewAssessment.Pages.SummarySchedulePage;
import CreateNewAssessment.Test.BasicDetailsAssessmentTest;
import CreateNewAssessment.Test.SummaryBasicsTest;
import CurrentAssessmentsforStudents.Pages.StudentAdvanceFilterPage;
import CurrentAssessmentsforStudents.Pages.StudentCurrentAssessmentBasicsPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.NewAssessmentTeacherBasicsPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherAdvanceFilterPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class StudentAdvanceFilterTest extends basePage {

	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	EncryptedText et = new EncryptedText();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	EditCoursePage ec = new EditCoursePage();
	BasicDetailsAssessmentTest bdt = new BasicDetailsAssessmentTest();
	SchedulePageBasicsPage sbp = new SchedulePageBasicsPage();
	SummaryBasicsPage sb = new SummaryBasicsPage();
	SummaryBasicsTest sbt = new SummaryBasicsTest();
	SummarySchedulePage sshp = new SummarySchedulePage();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	EditCourseTest ect = new EditCourseTest();
	NewAssessmentTeacherBasicsPage natb = new NewAssessmentTeacherBasicsPage();
	StudentCurrentAssessmentBasicsPage sca = new StudentCurrentAssessmentBasicsPage();
	TeacherPeerReviewSectionPage tp = new TeacherPeerReviewSectionPage();
	TeacherAdvanceFilterPage ta = new TeacherAdvanceFilterPage();
	CommonMethods cm = new CommonMethods();
	StudentAdvanceFilterPage safp = new StudentAdvanceFilterPage();

	public String AssessmentName;
	public String NewAssessmentName;

	public String Emailteacher;
	public String teacherotp;
	public String studentotp;
	public String CourseNamenew;
	public String CourseID1;

	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	/*
	 * To perform Login functionality
	 */
	@Test(priority = 1)
	public void TCSPR1100501() {

		click(lg.LoginBtn_1);

		cm.login(cm.emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	/*
	 * To create new course
	 */
	// @Test(priority = 2)
	// public void TCSPR1100502() throws SQLException {
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
	// Emailstudent1 = "student1@gmail.com";
	// Emailstudent2 = "student1@gmail.com";
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
	// public void TCSPR1100503() {
	//
	// // logout functionality
	// rs.Logout();
	//
	// // Heading Title-Login
	// Assert.assertEquals(getText(lg.PageTitle), "Login");
	//
	// }

	/*
	 * To check that invited course request visible on first student 's profile
	 * and accept course request-Read the student name
	 */
	// @Test(priority = 4)
	// public void TCSPR1100504() throws SQLException {
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
	// public void TCSPR1100505() {
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
	// public void TCSPR1100506() throws SQLException {
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

	/*
	 * To Accept course and perform logout functionality on the student profile
	 */

	// @Test(priority = 7)
	// public void TCSPR1100507() {
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
	 * To load the create new assessment page and fill details on the basic
	 * details page
	 */
	@Test(priority = 8)
	public void TCSPR1100508() {
		SoftAssert softAssert1 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

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
		AssessmentName = "History" + generateRandomNumber().trim();

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
	public void TCSPR1100509() {

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
		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
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
	public void TCSPR1100510() {

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
	 * To perform the save and next functionality from peer review page and
	 * verify the schedule page details
	 */

	@Test(priority = 11)
	public void TCSPR1100511() {

		// Type peer review reward score
		type(pr.PRreward_txtbox, "100");
		waitThread(1000);

		click(pr.savennext_button);
		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);
		waitThread(2000);
		Assert.assertEquals(getAttribute(sbp.schedule_wizard, "aria-expanded"), "true");

		// Assert the label assessment name,
		Assert.assertTrue(getText(sbp.Sbassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert labels:
		Assert.assertTrue(getText(sbp.Sbcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(sbp.Sbcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(sbp.Sbcoursename_lbl).contains(CourseName.trim()));

		waitThread(1000);
		click(pr.savennext_button);

		waitThread(3000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");
		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.summaryassessmentname).contains("Assessment Name: " + AssessmentName));

		waitThread(2000);

	}

	/*
	 * To verify the details on the Summary page & publish the Assessment
	 */

	@Test(priority = 12)
	public void TCSPR1100512() {
		// click on Release Button
		click(sb.btnrelease);
		waitFor(QP.toaster);
		// Assert toaster "Assessment published successfully
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");
		click(QP.toasterclosebtn);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(natb.publishpopup), "Publish popup not visible");

	}
	/*
	 * To check the newly created assessment card visible on the teacher profile
	 */

	@Test(priority = 13)
	public void TCSPR1100513() {

		// click on Back To Menu Button
		click(natb.btnbacktomenu);
		Assert.assertFalse(isElementPresent(natb.publishpopup), "Publish popup  visible");
		// To verify Current Assessment tab is selected
		Assert.assertEquals(getAttribute(ba.tabcurrectassessment, "aria-selected"), "true");
	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 14)
	public void TCSPR1100514() {

		cm.Logout();
		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * Perform Login functionality as student 1
	 */
	@Test(priority = 15)
	public void TCSPR1100515() {
		lg.login(cm.emailstudent1, cm.Password);

		waitThread(2000);
		Assert.assertTrue(isElementPresent(sca.btnnewjoincourse), "Join New Course button not visible");
	}

	/*
	 * To check the Upcoming tests filter functionality on the Assessment page
	 */
	@Test(priority = 16)
	public void TCSPR1100516() {

		// click on Assessment Tab
		click(sca.Assessmenttab);
		waitThread(5000);

		// Click on Upcoming Tests check box
		click(sca.upcomingtestcheckbx);
		waitThread(1000);
		// Assert the check box is checked
		Assert.assertTrue(getAttribute(sca.upcomingtestcheckbx, "class").contains("p-highlight"));

		Assert.assertTrue(getText(safp.Assessmentstatslabel).contains("Test Begins"));

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(natb.cardassessmentname1), AssessmentName);
		Assert.assertEquals(getText(natb.cardcoursename1), "For" + " " + CourseName.trim() + "(" + CourseID + ")");

	}

	/*
	 * To check the Test Active filter functionality on the Assessment page
	 */
	@Test(priority = 17)
	public void TCSPR1100517() throws InterruptedException {

		click(sca.tabresultpublish);
		// current assessment tab
		click(sca.tabcurrentassessment);
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(50);
		// Click on Test Active check box
		click(sca.testactivechkbx);
		waitThread(1000);

		// Assert the Test Active check box is checked
		Assert.assertTrue(getAttribute(sca.testactivechkbx, "class").contains("p-highlight"));
		// Assert the the "Test Active "
		Assert.assertEquals(getText(tp.teststs_lbl), "Active");

		// Search The Assessment Name
		type(sca.searchbox, AssessmentName.trim());
		waitThread(1000);

		// Assert the the "Test Pending "
		Assert.assertEquals(getText(tp.teststs_lbl), "Active");

	}

	/*
	 * To perform logout functionality on the student 1 profile
	 */
	@Test(priority = 18)
	public void TCSPR1100518() {

		cm.Logout();
	}

	/*
	 * Perform teacher login functionality
	 */
	@Test(priority = 19)
	public void TCSPR1100519() {

		lg.login(cm.emailteacher, password);

		// click on Assessment Tab
		click(sca.Assessmenttab);
		waitThread(5000);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");

	}

	/*
	 * To perform Test window reshedule date functionality of the assesssment
	 */
	@Test(priority = 20)
	public void TCSPR1100520() {

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(2000);
		// click menu button
		click(rd.threedot_btn);

		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(1000);

		// assert popup
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");
		// To reschedule test due date
		click(rd.assessmentduedate_txtbx);

		// To select Todays Date
		cm.ClickTodaysDate();

		waitThread(1000);
		// Assert popup not visible
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 21)
	public void TCSPR1100521() {
		cm.Logout();
	}

	/*
	 * Perform Login functionality as student 1
	 */
	@Test(priority = 22)
	public void TCSPR1100522() {

		lg.login(cm.emailstudent1, cm.Password);

		waitThread(2000);
		Assert.assertTrue(isElementPresent(sca.btnnewjoincourse), "Join New Course button not visible");
	}
	/*
	 * To check the Upcoming Peer-Reviews filter functionality on the Assessment
	 * page
	 */

	@Test(priority = 23)
	public void TCSPR1100523() throws InterruptedException {

		// click on Assessment Tab
		click(sca.Assessmenttab);
		// wait for 2 minute
		TimeUnit.MINUTES.sleep(2);
		// Click on Upcoming Peer-Reviews check box
		click(sca.upcomimgreviewchkbx);
		waitThread(1000);

		// Assert the Upcoming Peer-Reviews check box is checked
		Assert.assertTrue(getAttribute(sca.upcomimgreviewchkbx, "class").contains("p-highlight"));
		Assert.assertTrue(getText(safp.Assessmentstatslabel).contains("Peer Reviews - Begins"));
		waitThread(1000);
		Assert.assertEquals(getText(ta.reviewpending_lbl), "Pending");

		// Search The Assessment Name
		type(sca.searchbox, AssessmentName.trim());
		waitThread(1000);

		// Assert the newly published card visible on the current assessment
		// page
		Assert.assertTrue(isElementPresent(ta.newcard), " new assessment card not visible");

		// Assert the peer review status as active
		Assert.assertEquals(getText(ta.reviewpending_lbl), "Pending");
	}

	/*
	 * To perform logout functionality on the student 1 profile
	 */
	@Test(priority = 24)
	public void TCSPR1100524() {
		cm.Logout();
	}

	/*
	 * Perform teacher login functionality
	 */
	@Test(priority = 25)
	public void TCSPR1100525() {

		lg.login(cm.emailteacher, password);

		// click on Assessment Tab
		click(sca.Assessmenttab);
		waitThread(5000);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");

	}

	/*
	 * To perform Peer review Open window reshedule date functionality of the
	 * assesssment
	 */
	@Test(priority = 26)
	public void TCSPR1100526() {

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(2000);
		// click menu button
		click(rd.threedot_btn);

		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(1000);

		// assert popup
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");
		// To reschedule test due date
		click(rd.peerreviewopendate_txtbx);

		// To select Todays Date
		cm.ClickTodaysDate();

		waitThread(1000);
		// Assert popup not visible
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 27)
	public void TCSPR1100527() {

		cm.Logout();
	}

	/*
	 * Perform Login functionality as student 1
	 */
	@Test(priority = 28)
	public void TCSPR1100528() {

		lg.login(cm.emailstudent1, cm.Password);

		waitThread(2000);
		Assert.assertTrue(isElementPresent(sca.btnnewjoincourse), "Join New Course button not visible");

	}
	/*
	 * To check the Peer-review Active filter functionality on the Assessment
	 * page
	 */

	@Test(priority = 29)
	public void TCSPR1100529() throws InterruptedException {

		click(sca.Assessmenttab);
		// wait for 2 minute
		TimeUnit.MINUTES.sleep(2);

		// Click on Peer-review Active check box
		click(sca.reviewactiveckbx);
		waitThread(1000);

		// Assert the Peer-review Active check box is checked
		Assert.assertTrue(getAttribute(sca.reviewactiveckbx, "class").contains("p-highlight"));
		waitThread(1000);
		Assert.assertTrue(getText(safp.Assessmentstatslabel).contains("Peer Reviews Active"));

		// Assert the Peer Review status is Active
		Assert.assertEquals(getText(tp.peersts_lbl), "Active");

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(1000);
		// Assert one card visible on the current assessment page
		Assert.assertTrue(isElementPresent(ta.newcard), " new assessment card not visible");
		// Assert the Peer Review status is Active
		Assert.assertEquals(getText(tp.peersts_lbl), "Active");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(ta.newasses_lbl), AssessmentName);
	}

	/*
	 * To perform logout functionality on the student 1 profile
	 */
	@Test(priority = 30)
	public void TCSPR1100530() {

		cm.Logout();

	}

	/*
	 * Perform teacher login functionality
	 */
	@Test(priority = 31)
	public void TCSPR1100531() {
		lg.login(cm.emailteacher, password);

		// click on Assessment Tab
		click(sca.Assessmenttab);
		waitThread(5000);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");

	}

	/*
	 * To perform Peer review Open window reshedule date functionality of the
	 * assesssment
	 */
	@Test(priority = 32)
	public void TCSPR1100532() {

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(2000);
		// click menu button
		click(rd.threedot_btn);

		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(1000);

		// assert popup
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");
		// To reschedule test due date
		click(rd.peerreviewduedate_txtbx);

		// To select Todays Date
		cm.ClickTodaysDate();

		waitThread(1000);
		// Assert popup not visible
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 33)
	public void TCSPR1100533() {
		cm.Logout();
	}

	/*
	 * Perform Login functionality as student 1
	 */
	@Test(priority = 34)
	public void TCSPR1100534() {

		lg.login(cm.emailstudent1, cm.Password);

		waitThread(2000);
		Assert.assertTrue(isElementPresent(sca.btnnewjoincourse), "Join New Course button not visible");

	}

	/*
	 * To check the Upcoming Results filter functionality on the Assessment page
	 */
	@Test(priority = 35)
	public void TCSPR1100535() throws InterruptedException {

		click(sca.Assessmenttab);
		waitThread(5000);
		// wait for 2 minute
		TimeUnit.MINUTES.sleep(2);
		// Click on Upcoming Result check box
		click(sca.upcomingresultchkbx);
		waitThread(1000);

		// Assert the Upcoming Result check box is checked
		Assert.assertTrue(getAttribute(sca.upcomingresultchkbx, "class").contains("p-highlight"));

		waitThread(1000);

		// *Assert the Result status is pending
		Assert.assertEquals(getText(ta.resultsts_lbl), "Pending");

		// Search The Assessment Name
		type(sca.searchbox, AssessmentName.trim());
		// Assert one card visible on the current assessment page
		Assert.assertTrue(isElementPresent(ta.newcard), " new assessment card not visible");
		waitThread(1000);

		// *Assert the Result status is pending
		Assert.assertEquals(getText(ta.resultsts_lbl), "Pending");
		Assert.assertTrue(getText(safp.Assessmentstatslabel).contains("Result - Available in"));
		// Assert the assessment name History+random number
		Assert.assertEquals(getText(safp.newasses_lbl), AssessmentName);
	}

	/*
	 * To perform logout functionality on the student 1 profile
	 */
	@Test(priority = 36)
	public void TCSPR1100536() {

		cm.Logout();

	}

	/*
	 * Perform teacher login functionality
	 */

	@Test(priority = 37)
	public void TCSPR1100537() {

		lg.login(cm.emailteacher, password);

		// click on Assessment Tab
		click(sca.Assessmenttab);
		waitThread(5000);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");

	}

	/*
	 * To perform Result window Open window reshedule date functionality of the
	 * assesssment
	 */
	@Test(priority = 38)
	public void TCSPR1100538() {

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(2000);
		// click menu button
		click(rd.threedot_btn);

		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(1000);

		// assert popup
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");
		// To reschedule test due date
		click(rd.resultpublishdate_txtbx);

		// To select Todays Date
		cm.ClickTodaysDate();

		waitThread(1000);
		// Assert popup not visible
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 39)
	public void TCSPR1100539() {
		cm.Logout();
	}

	/*
	 * Perform Login functionality as student 1
	 */
	@Test(priority = 40)
	public void TCSPR1100540() {

		lg.login(cm.emailstudent1, cm.Password);

		waitThread(2000);
		Assert.assertTrue(isElementPresent(sca.btnnewjoincourse), "Join New Course button not visible");

	}

	/*
	 * To check the Results Active/Result Published filter functionality on the
	 * Assessment page
	 */
	@Test(priority = 41)
	public void TCSPR1100541() throws InterruptedException {

		// click on Assessment tab
		click(sca.Assessmenttab);

		// wait for 2 minute
		TimeUnit.MINUTES.sleep(2);
		// Click on Result Available check box
		click(sca.resultavailablechkbx);
		waitThread(1000);

		// Assert the Result Available check box is checked
		Assert.assertTrue(getAttribute(sca.resultavailablechkbx, "class").contains("p-highlight"));

		// *Assert the Result status is Active
		Assert.assertEquals(getText(ta.resultsts_lbl), "Active");

		// Search The Assessment Name
		type(sca.teacherassessmentsearchbox, AssessmentName.trim());
		Assert.assertTrue(getText(safp.Assessmentstatslabel).contains("Result Published"));
		Assert.assertTrue(isElementPresent(ta.newcard), " new assessment card not visible");
		waitThread(1000);
		// *Assert the Result status is pending
		Assert.assertEquals(getText(ta.resultsts_lbl), "Active");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(ta.newasses_lbl), AssessmentName);
	}

	/*
	 * To perform logout for student 1 profile
	 */
	@Test(priority = 42)
	public void TCSPR1100542() {

		cm.Logout();
	}

}
