package PeerReviewWindowofIndividualStudentTest;

import java.time.Month;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;

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
import SPRautomation.StudentPeerReview.basePage;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import TestWindowOfIndividualStudent.AnswerWindowPage;
import TestWindowOfIndividualStudent.ModifyWizardSectionPage;
import TestWindowOfIndividualStudent.StudentAssessmentInfoAndInstructionPage;
import TestWindowOfIndividualStudent.TestWindowAssessmentCardPhasesPage;

public class ReviewByMultipleStudentsTest extends basePage {

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
	AnswerWindowPage an = new AnswerWindowPage();
	NewAssessmentTeacherBasicsPage natb = new NewAssessmentTeacherBasicsPage();
	StudentCurrentAssessmentBasicsPage sca = new StudentCurrentAssessmentBasicsPage();
	ModifyWizardSectionPage ms = new ModifyWizardSectionPage();
	PeerReviewWindowPage prp = new PeerReviewWindowPage();
	CommonMethods cm = new CommonMethods();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	ReviewByMultipleStudentsPage rp = new ReviewByMultipleStudentsPage();
	TestWindowAssessmentCardPhasesPage ac = new TestWindowAssessmentCardPhasesPage();

	public String AssessmentName;
	public String NewAssessmentName;
	public String Emailteacher;
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
	public void TCSPR1300301() {

		click(lg.LoginBtn_1);

		cm.login(cm.emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}
	/*
	 * To create new course
	 */
	// @Test(priority = 2)
	// public void TCSPR1300302() throws SQLException {
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
	// Emailstudent3 = "student3" + generateRandomNumber().trim() +
	// "@gmail.com";
	// Emailstudent4 = "student4" + generateRandomNumber().trim() +
	// "@gmail.com";
	// // type email
	// type(cn.tab_textbox, Emailstudent1 + ",");
	// driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
	// type(cn.tab_textbox, Emailstudent2 + ",");
	// driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
	// type(cn.tab_textbox, Emailstudent3 + ",");
	// driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
	// type(cn.tab_textbox, Emailstudent4 + ",");
	// // verify email present on the text box
	// Assert.assertEquals(cn.emailvalue(0), Emailstudent1);
	//
	// Assert.assertEquals(cn.emailvalue(1), Emailstudent2);
	// Assert.assertEquals(cn.emailvalue(2), Emailstudent3);
	// Assert.assertEquals(cn.emailvalue(3), Emailstudent4);
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
	// public void TCSPR1300303() {
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
	// public void TCSPR1300304() throws SQLException {
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
	// public void TCSPR1300305() {
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
	// public void TCSPR1300306() throws SQLException {
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
	// public void TCSPR1300307() {
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
	/*
	 * To check that invited course request visible on first student 's profile
	 * and accept course request-Read the student name
	 */
	// @Test(priority = 8)
	// public void TCSPR1300308() throws SQLException {
	//
	//
	//
	// lg.login("student3@gmail.com", password);
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
	// @Test(priority = 9)
	// public void TCSPR1300309() {
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
	// @Test(priority = 10)
	// public void TCSPR1300310() throws SQLException {
	//
	// lg.login("student4@gmail.com", password);
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
	// @Test(priority = 11)
	// public void TCSPR1300311() {
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
	public String student1 = "Ashley Albert";
	public String student2 = "Ben Alex";

	/*
	 * To load the create new assessment page and fill details on the basic
	 * details page
	 */
	@Test(priority = 12)
	public void TCSPR1300312() {

		SoftAssert softAssert1 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(12000);
		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);
		waitThread(2000);
		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		softAssert1.assertEquals(getText(ba.ddcoursename1), CourseName.trim(),
				"course name not visible on the dropdown");

		click(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);

		AssessmentName = "AssessmentOne" + generateRandomNumber().trim();

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

	public String Question1;
	public String Question2;
	public String Question3;

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 13)
	public void TCSPR1300313() {

		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		Question1 = "Question 1" + generateRandomData();

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
		type(QP.max_scorbx, "10");

		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");

		click(QP.toasterclosebtn);
	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 14)
	public void TCSPR1300314() {

		// Click on +button
		click(an.add_quest_btn);
		waitThread(1000);
		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		Question2 = "Question 2" + generateRandomData();

		// Type a question on Question box
		type(QP.Quest_box, "Question2");
		driver.switchTo().defaultContent();
		waitThread(1000);

		driver.switchTo().defaultContent();


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
		type(QP.max_scorbx, "20");

		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully");

		click(QP.toasterclosebtn);

	}

	public String Criteria1;
	public String Criteria2;
	public String SampleAnswer4;

	/*
	 * To fill details on theQuestion page
	 */
	@Test(priority = 15)
	public void TCSPR1300315() {

		// Click on +button
		click(an.add_quest_btn);
		waitThread(1000);
		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);
		Question3 = "Question 3" + generateRandomData();

		// Type a question on Question box
		type(QP.Quest_box, "Question 3");
		driver.switchTo().defaultContent();
		waitThread(1000);

	//	ScrollTo_Location(prp.Questiontotalmark);
		waitThread(3000);
		// Click rubric drop down
		//click(QP.rubric_drp_btn);
		waitThread(3000);
		click(QP.click_radio);

		// Assert the clickable rubric radio button is enabled
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

	//	ScrollTo_Location(QP.add_column);
		waitThread(1000);

		// Click Add column button
		Doubleclick(QP.add_column);
		driver.switchTo().frame(1);

		waitThread(2000);
		Assert.assertEquals(getAttribute(prp.clic_rub_place, "aria-placeholder"), "Enter Condition");

		waitThread(1000);
		driver.switchTo().defaultContent();

		waitThread(1000);
		Criteria1 = "Criteria1 " + generateRandomData();
		Criteria2 = "Criteria2 " + generateRandomData();

		waitThread(2000);
		// Type Criteria and score
		type(prp.criteria1, Criteria1);
		type(prp.scre_col00, "10");
		waitThread(1000);
		// Enter score
		type(prp.scre_col01, "15");
		waitThread(1000);
		// To Fill The condition
		driver.switchTo().frame("editorFieldRubric_00_ifr");
		waitThread(2000);
		type(prp.enter_con, "Very Good");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("editorFieldRubric_01_ifr");
		waitThread(2000);
		type(prp.enter_con, "Good");
		driver.switchTo().defaultContent();
		ScrollTo_Location(prp.sampleAnsweraccordian);

		// To Add a new row and fill the details
		Doubleclick((QP.add_row));

		// Assert the new row added is visible
		driver.switchTo().frame("editorFieldRubric_10_ifr");
		waitThread(2000);
		Assert.assertEquals(getAttribute(prp.clic_rub_place, "aria-placeholder"), "Enter Condition");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// type criteria
		type(prp.criteria2, Criteria2);
		waitThread(1000);

		// Enter score
		type(prp.scrore_r10, "10");
		waitThread(1000);

		// Enter score
		type(prp.score_r11, "20");
		waitThread(1000);

		// To add the conditions
		driver.switchTo().frame("editorFieldRubric_10_ifr");
		waitThread(2000);

		// enter condition
		type(prp.enter_con, "Average");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("editorFieldRubric_11_ifr");
		waitThread(2000);

		// enter condition
		type(prp.enter_con, "Below Average");
		driver.switchTo().defaultContent();

		ScrollTo_Location(prp.sampleAnsweraccordian);
		click(prp.sampleAnsweraccordian);

		driver.switchTo().frame("sampleAnswer_ifr");

		SampleAnswer4 = "SampleAnswer4 " + generateRandomData();

		// Type Sample Answer
		type(prp.textbxsampleanswer, SampleAnswer4);

		driver.switchTo().defaultContent();

		ScrollTo_xy_position(0, -250);
		waitThread(4000);

		// To verify the Max score
		Assert.assertEquals(getValue(QP.max_scorbx), "35");
		waitThread(4000);

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
	@Test(priority = 16)
	public void TCSPR1300316() {
		waitThread(3000);

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		waitThread(2000);
		// Select Answer Sheets Per Student =2
		click(rp.reviewans_sheetdropdwn);
		waitThread(2000);
		click(rp.reviewssheet_count);

		// Enter peer review Reward score 100
		type(pr.PRreward_txtbox, "100");
		waitThread(1000);


	}

	public String assessmentopendate;
	public String assessmentopentime;
	public String assessmentduedate;
	public String assessmentduetime;

	/*
	 * To perform the save and next functionality from peer review page and
	 * verify the schedule page details
	 */
	@Test(priority = 17)
	public void TCSPR1300317() {

		click(pr.savennext_button);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

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

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		// Click on save and next button
		click(pr.savennext_button);
		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");

	}

	/*
	 * To verify the details on the Summary page & publish the Assessment
	 */
	@Test(priority = 18)
	public void TCSPR1300318() {

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");

		// Assert the text "Questions Summary "
		Assert.assertEquals(getText(rp.Summary_quest), "Questions Summary");

		// Assert the Total no: of Questions
		Assert.assertEquals(getText(rp.total_questcount), "3");

		// Assert the Maximum score possible
		Assert.assertEquals(getText(rp.max_scorepos_count), "130");

	}

	/*
	 * To perform Assessment publish functionality
	 */
	@Test(priority = 19)
	public void TCSPR1300319() {

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
	@Test(priority = 20)
	public void TCSPR1300320() {

		// Click on Back to menu button
		click(ap.Backtomenu_btn);

		waitThread(2000);

		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(ap.publish_popup), "popup not visible");

		// Assert the Current Assessment is selected
		Assert.assertEquals(getAttribute(ap.currentassess_tab, "aria-selected"), "true");

		// search assessment
		type(tp.search_box, AssessmentName);
		waitThread(5000);

		// Assert the new assessment card visible
		Assert.assertTrue(isElementPresent(tp.newcard), " new assessment card not visible");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(tp.newasses_lbl), AssessmentName);
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseID));

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 21)
	public void TCSPR1300321() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform Login functionality of student1 profile and check the
	 * Assessment card
	 */
	@Test(priority = 22)
	public void TCSPR1300322() throws InterruptedException {

		waitThread(1000);

		lg.login("student1@gmail.com", password);

		// verify heading label enrolled courses
		//waitFor(sa.enrolledcourse_lbl);
		//Assert.assertEquals(getText(sa.enrolledcourse_lbl), "Enrolled Courses");

		TimeUnit.MINUTES.sleep(1);

		// Click Assessment tab
		click(QP.Assessmenttab);

		waitThread(8000);

		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(8000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(sa.Assess_name_card), AssessmentName);
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseID));

		// Assert the teacher name
		Assert.assertTrue(getText(sa.teachername_card).contains(Teachername));

	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 23)
	public void TCSPR1300323() {

		// click begin test
		click(sa.begintest_btn);
		waitThread(2000);

		// Assert the Assessment name
		Assert.assertEquals(getText(ms.test_window_assess_name), AssessmentName);

		// Assert the 1st question is selcted
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

		// Assert the toaster Answer Saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));

		// Enter Answer 2
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer2
		type(an.ansplaceholder, "Answer 2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// click save next button
		click(an.saveNext_btn);

		waitFor(QP.toaster);
		waitThread(1000);

		// Assert the toaster Answer Saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

	}

	/*
	 * To attend test with incomplete answer functionality
	 */
	@Test(priority = 24)
	public void TCSPR1300324() {

		// Assert the 3rd question is selcted
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));

		// Enter Answer 2
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer3
		type(an.ansplaceholder, "Answer 3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		click(an.save_btn);

		waitFor(QP.toaster);
		waitThread(1000);

		// Assert the toaster Answer Saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

	}

	/*
	 * To perform assessment submit functionality on the student profile
	 */
	@Test(priority = 25)
	public void TCSPR1300325() {

		// click submit button
		click(ms.submit_btn);
		waitThread(2000);
		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");

		click(ms.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		// Click on Back to Assessment
		click(ms.backtoassess_btn);

		waitThread(5000);

		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		waitThread(5000);

		type(sa.stud_searchbx, AssessmentName);
		waitThread(8000);

		// Assert the test completed count is 3/3
		Assert.assertEquals(getText(ms.compcount), "3/3");

		// Assert test status submitted
		Assert.assertEquals(getText(tp.teststs_lbl), "Submitted");

	}

	/*
	 * To perform logout functionality on the Student 1 profile
	 */
	@Test(priority = 26)
	public void TCSPR1300326() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	public String Stud2_Answer1 = "Student 2 Answer 1";
	public String Stud2_Answer2 = "Student 2 Answer 2";
	public String Stud2_Answer3 = "Student 2 Answer 3";

	/*
	 * To perform Login functionality of student 2 profile and check the
	 * Assessment card
	 */
	@Test(priority = 27)
	public void TCSPR1300327() {

		waitThread(1000);

		lg.login("student2@gmail.com", password);

		// verify heading label enrolled courses
		//waitFor(sa.enrolledcourse_lbl);
		//Assert.assertEquals(getText(sa.enrolledcourse_lbl), "Enrolled Courses");

		// Click Assessment tab
		click(QP.Assessmenttab);

		waitThread(7000);

		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys("   ");
		waitThread(8000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(sa.Assess_name_card), AssessmentName);
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseID));

		// Assert the teacher name
		Assert.assertTrue(getText(sa.teachername_card).contains(Teachername));

	}

	/*
	 * To load the test window and check that the details on the Test window
	 */
	@Test(priority = 28)
	public void TCSPR1300328() {

		// click begin test
		click(sa.begintest_btn);
		waitThread(2000);

		// Assert the Assessment name
		Assert.assertEquals(getText(ms.test_window_assess_name), AssessmentName);

		// Assert the 1st question is selcted
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));
	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 29)
	public void TCSPR1300329() {

		// Enter Answer 1
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer1
		type(an.ansplaceholder, "Answer 1");

		driver.switchTo().defaultContent();
		waitThread(1000);
		click(an.saveNext_btn);
		waitThread(1000);

		// Assert the toaster Answer Saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));

		// Enter Answer 2
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer2
		type(an.ansplaceholder, "Answer 2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// click save next button
		click(an.saveNext_btn);

		waitFor(QP.toaster);
		waitThread(1000);

		// Assert the toaster Answer Saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

	}

	/*
	 * To attend test functionality
	 */
	@Test(priority = 30)
	public void TCSPR1300330() {

		// Assert the 3rd question is selcted
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));

		// Enter Answer 2
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer2
		type(an.ansplaceholder, "Answer 3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		click(an.save_btn);

		waitFor(QP.toaster);
		waitThread(1000);

		// Assert the toaster Answer Saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

	}

	/*
	 * To perform assessment submit functionality on the student profile
	 */
	@Test(priority = 31)
	public void TCSPR1300331() {

		// click submit button
		click(ms.submit_btn);
		waitThread(2000);
		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");

		click(ms.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		// Click on Back to Assessment
		click(ms.backtoassess_btn);

		waitThread(8000);

		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		waitThread(5000);

		type(sa.stud_searchbx, AssessmentName);
		waitThread(7000);

		// Assert the test completed count is 3/3
		Assert.assertEquals(getText(ms.compcount), "3/3");

		// Assert test status submitted
		Assert.assertEquals(getText(tp.teststs_lbl), "Submitted");

	}

	/*
	 * To perform Login functionality of student 3 profile and check the
	 * Assessment card
	 */
	@Test(priority = 32)
	public void TCSPR1300332() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(1000);

		lg.login("student3@gmail.com", password);

		// verify heading label enrolled courses
		//waitFor(sa.enrolledcourse_lbl);
		//Assert.assertEquals(getText(sa.enrolledcourse_lbl), "Enrolled Courses");

		// Click Assessment tab
		click(QP.Assessmenttab);

		waitThread(10000);

		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys("   ");
		waitThread(7000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(sa.Assess_name_card), AssessmentName);
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseID));

		// Assert the teacher name
		Assert.assertTrue(getText(sa.teachername_card).contains(Teachername));

	}

	/*
	 * To load the test window and check that the details on the Test window
	 */
	@Test(priority = 33)
	public void TCSPR1300333() {

		// click begin test
		click(sa.begintest_btn);
		waitThread(2000);

		// Assert the Assessment name
		Assert.assertEquals(getText(ms.test_window_assess_name), AssessmentName);

		// Assert the 1st question is selcted
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 34)
	public void TCSPR1300334() {

		// Enter Answer 1
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer1
		type(an.ansplaceholder, "Answer 1");

		driver.switchTo().defaultContent();
		waitThread(1000);
		click(an.saveNext_btn);
		waitThread(1000);

		// Assert the toaster Answer Saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));

		// Enter Answer 2
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer2
		type(an.ansplaceholder, "Answer 2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// click save next button
		click(an.saveNext_btn);

		waitFor(QP.toaster);
		waitThread(1000);

		// Assert the toaster Answer Saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

	}

	/*
	 * To attend test functionality
	 */
	@Test(priority = 35)
	public void TCSPR1300335() {

		// Assert the 3rd question is selcted
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));

		// Enter Answer 2
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer2
		type(an.ansplaceholder, "Answer 3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		click(an.save_btn);

		waitFor(QP.toaster);
		waitThread(1000);

		// Assert the toaster Answer Saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

	}

	/*
	 * To perform assessment submit functionality on the student profile
	 */
	@Test(priority = 36)
	public void TCSPR1300336() {

		// click submit button
		click(ms.submit_btn);
		waitThread(2000);
		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");

		click(ms.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		// Click on Back to Assessment
		click(ms.backtoassess_btn);

		waitThread(7000);

		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		waitThread(5000);

		type(sa.stud_searchbx, AssessmentName);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys("   ");
		waitThread(7000);

		// Assert the test completed count is 3/3
		Assert.assertEquals(getText(ms.compcount), "3/3");

		// Assert test status submitted
		Assert.assertEquals(getText(tp.teststs_lbl), "Submitted");

	}

	/*
	 * To perform Login functionality of student 4 profile and check the
	 * Assessment card
	 */
	@Test(priority = 37)
	public void TCSPR1300337() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(1000);

		lg.login("student4@gmail.com", password);

		// verify heading label enrolled courses
		//waitFor(sa.enrolledcourse_lbl);
		//Assert.assertEquals(getText(sa.enrolledcourse_lbl), "Enrolled Courses");

		// Click Assessment tab
		click(QP.Assessmenttab);

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
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseID));

		// Assert the teacher name
		Assert.assertTrue(getText(sa.teachername_card).contains(Teachername));

	}

	/*
	 * To begin the test and submit test with no answer, check the confirmation
	 * popup
	 */
	@Test(priority = 38)
	public void TCSPR1300338() {

		// click begin test
		click(sa.begintest_btn);
		waitThread(2000);

		// Assert the Assessment name
		Assert.assertEquals(getText(ms.test_window_assess_name), AssessmentName);

		// Assert the 1st question is selcted
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

		// click submit button
		click(ms.submit_btn);
		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");

		// Assert the text "You have 4 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(ms.confirmation_txt), "You have 3 skipped question(s)! Proceed to submit?");

		click(ms.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Assessment Submitted"
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		// Click on Back to Assessment
		click(ms.backtoassess_btn);

		waitThread(8000);
		// To verify the current assessment tab is not visible
		Assert.assertEquals(getAttribute(rp.selectedcurrenttab, "aria-selected"), "true");

		cm.Logout();
	}

	/*
	 * To perform reschedule of Test Window and Peer Review window
	 */
	@Test(priority = 39)
	public void RescheduleTestAndPeerDate() {

		// Login as Teacher
		cm.login(cm.emailteacher, cm.Password);

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(10000);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		// Search The Assessment Name
		type(sca.teacherassessmentsearchbox, AssessmentName);
		waitThread(7000);

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
		//cm.ClickTodaysDate_PeerReview();
		waitThread(1000);
		 Calendar cal = Calendar.getInstance();
		 int monthNumber2 = cal.get(Calendar.MONTH);
		 int Day = cal.get(Calendar.DAY_OF_MONTH);
		 int monthNumber = monthNumber2 + 1;
		 String monthname = Month.of(monthNumber).name();
		 waitThread(2000);
		 String Dropmonth =
		 DropselectedValue("select.p-datepicker-month.ng-star-inserted");
		
		 if (monthname.equals(Dropmonth.toUpperCase())) {
		
		 if (Day < 15) {
		
		 Doubleclick("//td[contains(@class,'p-datepicker-today')]");
		 waitThread(4000);
		 } else {
		 click("//span[contains(text(),'Su')]");
		 click("//span[contains(text(),'Mo')]");
		 Actions action = new Actions(driver);
		 action.sendKeys(Keys.PAGE_DOWN).build().perform();
		 //action.sendKeys(Keys.PAGE_DOWN).build().perform();
		 waitThread(2000);
		 Doubleclick("//td[contains(@class,'p-datepicker-today')]");
		 waitThread(4000);
		
		 }
		 } else {
		
		 click("button.p-datepicker-prev.p-link.p-ripple.ng-star-inserted >span");
		 waitThread(3000);
		 click("//span[contains(text(),'Su')]");
		 click("//span[contains(text(),'Mo')]");
		 Actions action = new Actions(driver);
		 action.sendKeys(Keys.PAGE_DOWN).build().perform();
		 // action.sendKeys(Keys.PAGE_DOWN).build().perform();
		 waitThread(4000);
		 Doubleclick("//td[contains(@class,'p-datepicker-today')]");
		 waitThread(4000);
		 }

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
	 * To check the details on the peer review page of student 4
	 */
	@Test(priority = 39)
	public void TCSPR1300339() throws InterruptedException {

		lg.login("student4@gmail.com", password);

		// wait for 1.5 Min
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(50);

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

		// click on Begin Review Button
		click(prp.btnbeginReview);
		waitThread(7000);

		ScrollTo_xy_position(0, 300);
		waitThread(2000);

		SwitchFrame("answerViewEditor_0_ifr");
		waitThread(1000);
		Assert.assertTrue(isElementPresent(rp.stud1Answerbox), "Student One Answers boxes not present");
		driver.switchTo().defaultContent();
		waitThread(2000);

		SwitchFrame("answerViewEditor_1_ifr");
		waitThread(1000);

		Assert.assertTrue(isElementPresent(rp.stud2Answerbox), "Student One Answers boxes not present");

		driver.switchTo().defaultContent();
		waitThread(2000);

		SwitchFrame("answerViewEditor_2_ifr");
		waitThread(1000);

		Assert.assertTrue(isElementPresent(rp.stud3Answerbox), "Student One Answers boxes not present");

		driver.switchTo().defaultContent();
		waitThread(2000);

		Assert.assertFalse(getAttribute(rp.stud1accordian_1, "class").contains("p-disabled"));

		Assert.assertFalse(getAttribute(rp.stud2accordian_1, "class").contains("p-disabled"));
		Assert.assertFalse(getAttribute(rp.stud3accordian_1, "class").contains("p-disabled"));

		click(prp.scorestud1);

		// Type Score for Student 1[Question 1]
		type(prp.scorestud1, "10");
		waitThread(1000);

		// click on student 1 comment box[Question 1]
		click(prp.stud1comment);
		waitThread(2000);

		// verify the popup visible
		Assert.assertTrue(isElementPresent(prp.popupcomment), "Comment popup not  visible");
		waitThread(2000);

		click(rp.txtbx_comment);

		// Type Comment for student 1[Question 1]
		type(rp.txtbx_comment, commentstudent1);
		waitThread(2000);

		// click on comment save button[Question 1]
		click(prp.commentsave_btn);
		waitThread(2000);

		// verify the comment box not visible[Question 1]
		Assert.assertFalse(isElementPresent(prp.popupcomment), "Comment popup  visible");

		waitThread(1000);

		click(prp.scorestud2);

		// Type Score for Student 1[Question 1]
		type(prp.scorestud2, "10");
		waitThread(1000);

		// click on student 1 comment box[Question 1]
		click(prp.stud2comment);
		waitThread(2000);

		// verify the popup visible
		Assert.assertTrue(isElementPresent(prp.popupcomment), "Comment popup not  visible");
		waitThread(2000);

		click(rp.txtbx_comment);

		// Type Comment for student 2[Question 1]
		type(rp.txtbx_comment, commentstudent2);
		waitThread(2000);

		// click on comment save button[Question 1]
		click(prp.commentsave_btn);
		waitThread(2000);
		// verify the comment box not visible[Question 1]
		Assert.assertFalse(isElementPresent(prp.popupcomment), "Comment popup  visible");
		waitThread(1000);

		ScrollTo_xy_position(0, 0);
		waitThread(2000);

		// click on save button
		click(prp.reviewbtnsave);
		waitFor(QP.toaster);

		// verify toaster "Saved"
		Assert.assertEquals(getText(QP.toaster), "Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);

		// verify the wizard status is complete[Question 1]
		Assert.assertTrue(getAttribute(rp.wizardans1, "class").contains("incomplete"));
		waitThread(1000);

	}

	/*
	 * Perform logout functionality on the student 3 login
	 */
	@Test(priority = 40)
	public void TCSPR1300340() {

		ScrollTo_xy_position(0, 300);
		waitThread(2000);

		click(rp.scorestud3);
		// Type Score for Student 1[Question 1]
		type(rp.scorestud3, "10");
		waitThread(1000);

		// click on student 1 comment box[Question 2]
		click(rp.stud3comment);
		waitThread(2000);

		// verify the popup visible
		Assert.assertTrue(isElementPresent(prp.popupcomment), "Comment popup not  visible");
		waitThread(2000);
		click(rp.txtbx_comment);
		// Type Comment for student 1[Question 2]
		type(rp.txtbx_comment, commentstudent3);
		waitThread(2000);
		// click on comment save button[Question 2]
		click(prp.commentsave_btn);
		waitThread(2000);
		// verify the comment box not visible[Question 2]
		Assert.assertFalse(isElementPresent(prp.popupcomment), "Comment popup  visible");
		waitThread(2000);

		ScrollTo_xy_position(0, 0);
		waitThread(2000);

		// click on save button

		click(prp.reviewbtnsave);
		waitFor(QP.toaster);

		// verify toaster "Saved"
		Assert.assertEquals(getText(QP.toaster), "Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);

		// click on save button
		click(prp.reviewbtnsaveandexit);
		waitThread(5000);
		// To verify the current assessment tab is not visible
		Assert.assertEquals(getAttribute(rp.selectedcurrenttab, "aria-selected"), "true");

	}

	/*
	 * Perform logout functionality on the student 3 login
	 */
	@Test(priority = 41)
	public void TCSPR1300341() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	public String commentstudent1 = "Comment for student 1";

	public String commentstudent2 = "Comment for student 2";
	public String commentstudent3 = "Comment for student 3";

	/*
	 * Login As Student 1 and begin the Review
	 */
	@Test(priority = 42)
	public void TCSPR1300342() throws InterruptedException {

		waitThread(1000);

		lg.login("student1@gmail.com", password);

		// verify heading label enrolled courses
		//waitFor(sa.enrolledcourse_lbl);
		//Assert.assertEquals(getText(sa.enrolledcourse_lbl), "Enrolled Courses");

		// Click Assessment tab
		click(QP.Assessmenttab);

		waitThread(14000);

		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(7000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// click on Begin Review Button
		click(prp.btnbeginReview);
		waitThread(7000);

		// verify the 1st wizard is selected
		Assert.assertTrue(getAttribute(rp.wizardans1, "class").contains("p-highlight"));

	//	ScrollTo_xy_position(0, 200);

		// Assert the Student one ,Student two,Student Three Answers boxes
		SwitchFrame("answerViewEditor_0_ifr");
		waitThread(1000);

		Assert.assertTrue(isElementPresent(rp.stud1Answerbox), "Student One Answers boxes not present");

		driver.switchTo().defaultContent();
		waitThread(2000);

		SwitchFrame("answerViewEditor_1_ifr");
		waitThread(1000);

		Assert.assertTrue(isElementPresent(rp.stud2Answerbox), "Student One Answers boxes not present");

		driver.switchTo().defaultContent();
		waitThread(2000);

		SwitchFrame("answerViewEditor_2_ifr");
		waitThread(1000);

		Assert.assertTrue(isElementPresent(rp.stud3Answerbox), "Student One Answers boxes not present");

		driver.switchTo().defaultContent();
		waitThread(2000);

		// Assert the Student one ,Student two,Student Three Answers boxes are
		// Enabled
		Assert.assertTrue(getAttribute(rp.stud1accordian_1, "class").contains("p-disabled"));
		Assert.assertFalse(getAttribute(rp.stud2accordian_1, "class").contains("p-disabled"));
		Assert.assertFalse(getAttribute(rp.stud3accordian_1, "class").contains("p-disabled"));

		click(prp.scorestud2);

		// Type Score for Student 1[Question 1]
		type(prp.scorestud2, "10");
		waitThread(1000);

		// click on student 1 comment box[Question 2]
		click(prp.stud2comment);
		waitThread(2000);

		// verify the popup visible
		Assert.assertTrue(isElementPresent(prp.popupcomment), "Comment popup not  visible");
		waitThread(2000);
		click(rp.txtbx_comment);

		// Type Comment for student 1[Question 2]
		type(rp.txtbx_comment, commentstudent2);
		waitThread(2000);

		// click on comment save button[Question 2]
		click(prp.commentsave_btn);
		waitThread(2000);

		// verify the comment box not visible[Question 2]
		Assert.assertFalse(isElementPresent(prp.popupcomment), "Comment popup  visible");

		waitThread(2000);
		// click on save button
		click(prp.reviewbtnsave);
		waitFor(QP.toaster);

		// verify toaster "Saved"
		Assert.assertEquals(getText(QP.toaster), "Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);

		// verify the wizard status is complete[Question 2]
		Assert.assertTrue(getAttribute(rp.wizardans1, "class").contains("incomplete"));
		waitThread(2000);
		Scroll_DowntoEnd();
		// click on student 2 accordian[Question 2]
		click(rp.stud3accordian);
		waitThread(2000);

		// verify the student 2 Answer [Question 1]
		driver.switchTo().frame("answerViewEditor_2_ifr");
		Assert.assertEquals(getText(prp.stud3Answerbox), "Answer 1");
		driver.switchTo().defaultContent();

		click(prp.scorestud2);
		// Type score for student 2
		type(prp.scorestud2, "15");

		// click on save button
		click(prp.reviewbtnsave);
		waitFor(QP.toaster);

		// verify the toaster "Saved"
		Assert.assertEquals(getText(QP.toaster), "Saved");
		click(QP.toasterclosebtn);

	}

	/*
	 * To check the student 2 Answer sheet is disabled on the Question 2,3
	 */
	@Test(priority = 43)
	public void TCSPR1300343() {

		// click on 2nd Question
		click(rp.wizardans2);
		waitThread(2000);
		// verify the student 1 and student 2 accordian status[Question 2]
		Assert.assertTrue(getAttribute(rp.wizardans2, "class").contains("p-highlight"));
		Assert.assertFalse(getAttribute(rp.stud2accordian_1, "class").contains("p-disabled"));

		// click on student 2 accordian[Question 2]
		click(prp.stud2accordian_2);
		waitThread(2000);
		// verify the student 2 accordian is expanded
		Assert.assertEquals(getAttribute(prp.stud2_accordian, "aria-expanded"), "true");
		waitThread(2000);

		// verify the student 2 Answer [Question 2]
		driver.switchTo().frame("answerViewEditor_1_ifr");

		Assert.assertEquals(getText(prp.stud2Answerbox), "Answer 2");
		driver.switchTo().defaultContent();

		click(prp.scorestud2);
		// Type score for student 2
		type(prp.scorestud2, "15");

		// click on save button
		click(prp.reviewbtnsave);
		waitFor(QP.toaster);

		// verify the toaster "Saved"
		Assert.assertEquals(getText(QP.toaster), "Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);

		// click on 2nd Question
		click(rp.wizardans3);

		// verify the student 1 and student 2 accordian status[Question 2]
		Assert.assertTrue(getAttribute(rp.wizardans3, "class").contains("p-highlight"));

		// click on 2nd Question
		click(rp.wizardans2);

		// verify the student 1 and student 2 accordian status[Question 2]
		Assert.assertTrue(getAttribute(rp.wizardans2, "class").contains("p-highlight"));
		click(prp.reviewbtnsaveandexit);

		waitThread(10000);

		// To check the current assessment tab is selected
		Assert.assertEquals(getAttribute(rp.selectedcurrenttab, "aria-selected"), "true");

		waitThread(3000);
		// Search The Assessment Name
		type(sa.stud_searchbx, AssessmentName.trim());
		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Assessment card not visible");

		// click on Begin Review Button
		click(prp.btnbeginReview);
		waitThread(7000);

		// verify the 2nd wizard is selected
		Assert.assertTrue(getAttribute(rp.wizardans2, "class").contains("p-highlight"));

	}

	/*
	 * To check the clickable Rubric functionality on the page
	 */
	@Test(priority = 44)
	public void TCSPR1300344() {

		// click on 2nd Question
		click(rp.wizardans3);

		// verify the student 1 and student 2 accordian status[Question 2]
		Assert.assertTrue(getAttribute(rp.wizardans3, "class").contains("p-highlight"));

		waitThread(3000);
		ScrollTo_xy_position(0, 400);
		waitThread(1000);

	//	ScrollTo_Location(prp.cardrubriclbl);
		waitThread(4000);

		// click on row 1 of Criteria 1
		click(rp.c1row1);
		Assert.assertTrue(getAttribute(rp.c1row1, "class").contains("selectedCell"));

		// click on row 1 of Criteria 2
		click(rp.c2row1);
		Assert.assertTrue(getAttribute(rp.c2row1, "class").contains("selectedCell"));

		String s = getText(rp.c1row1score);
		s = s.replaceAll("\\D+", "");

		int n = Integer.parseInt(s);

		String l = getText(rp.c2row1score);
		l = l.replaceAll("\\D+", "");

		int m = Integer.parseInt(l);

		int score = n + m;
		String totalscore = Integer.toString(score);

		// verify the score is updated to 30
		ScrollTo_Location(prp.scorestud2);
		waitThread(1000);

		Assert.assertEquals(getValue(prp.scorestud2), totalscore);
		ScrollTo_Location(prp.cardrubriclbl);
		waitThread(1000);

		// click on row 1 of Criteria 2
		click(rp.c1row2);

		// verify the row 1 of Criteria 2 is selected
		Assert.assertTrue(getAttribute(rp.c1row2, "class").contains("selectedCell"));

		// click on row 2 of Criteria 2
		click(rp.c2row2);

		// verify the row 2 of Criteria 2 is selected
		Assert.assertTrue(getAttribute(rp.c2row2, "class").contains("selectedCell"));

		String j = getText(rp.c1row2score);
		j = j.replaceAll("\\D+", "");

		int k = Integer.parseInt(j);

		String a = getText(rp.c2row2score);
		a = a.replaceAll("\\D+", "");

		int c = Integer.parseInt(a);

		int score2 = k + c;
		String totalscore2 = Integer.toString(score2);

		ScrollTo_Location(prp.scorestud2);
		waitThread(1000);

		// verify the score on the box for Question 4
		Assert.assertEquals(getValue(prp.scorestud2), totalscore2);

	}

	/*
	 * Perform save &Exit functionality on the page Perform Logout functionality
	 */
	@Test(priority = 45)
	public void TCSPR1300345() {

		click(prp.reviewbtnsaveandexit);
		waitThread(12000);

		// To check the current assessment tab is selected
		Assert.assertEquals(getAttribute(rp.selectedcurrenttab, "aria-selected"), "true");

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

}
