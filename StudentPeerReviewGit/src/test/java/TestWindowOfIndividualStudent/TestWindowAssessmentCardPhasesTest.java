package TestWindowOfIndividualStudent;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import SPRautomation.StudentPeerReview.basePage;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class TestWindowAssessmentCardPhasesTest extends basePage {

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
	ModifyWizardSectionPage ms = new ModifyWizardSectionPage();
	CommonMethods cm = new CommonMethods();
	TestWindowAssessmentCardPhasesPage ac = new TestWindowAssessmentCardPhasesPage();
	RescheduleDatesPage rd = new RescheduleDatesPage();

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
	public void TCSPR1200601() {

		click(lg.LoginBtn_1);

		cm.login(cm.emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}
	/*
	 * To create new course
	 */
	// @Test(priority = 2)
//	public void TCSPR1200702() throws SQLException {
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
//	public void TCSPR1200703() {
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
//	public void TCSPR1200704() throws SQLException {
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
//	public void TCSPR1200705() {
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
//	public void TCSPR1200706() throws SQLException {
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
//	public void TCSPR1200707() {
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
	public String student1 = "Ashley Albert";
	public String student2 = "Ben Alex";

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */
	@Test(priority = 8)
	public void TCSPR1200708() {

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
	public void TCSPR1200709() {

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
	@Test(priority = 10)
	public void TCSPR1200710() {
		// Click on +button
		click(an.add_quest_btn);
		waitThread(1000);
		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question3");
		driver.switchTo().defaultContent();
		waitThread(1000);

		driver.switchTo().defaultContent();

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R3");

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

		waitThread(2000);
		MouseHover(QP.quest_bankcheckbx);

		waitThread(2000);
		// Click on +button
		click(an.add_quest_btn);
		waitThread(1000);
		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question4");
		driver.switchTo().defaultContent();
		waitThread(1000);

		driver.switchTo().defaultContent();
		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R4");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "2");
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
	@Test(priority = 11)
	public void TCSPR1200711() {

		waitThread(2000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		waitThread(3000);
		// Assert the text::Total Students : Assert the total student count
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 4");

	}

	public String assessmentopendate;
	public String assessmentopentime;
	public String assessmentduedate;
	public String assessmentduetime;

	/*
	 * To perform the save and next functionaity from peer review page and verify
	 * the schedule page details
	 */

	@Test(priority = 12)
	public void TCSPR1200712() {

		// Type peer review reward score
		type(pr.PRreward_txtbox, "1");
		waitThread(1000);

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

		// Assert the Summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");

	}

	/*
	 * 
	 */
	@Test(priority = 13)
	public void TCSPR1200713() {

		waitThread(2000);

		// Assert the Summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");

		// Assert the text "Questions Summary "
		Assert.assertEquals(getText(ac.Summary_quest), "Questions Summary");

		// Assert the Total no: of Questions
		Assert.assertEquals(getText(ac.total_questcount), "4");

	}

	/*
	 * To verify the details on the Summary page & publish the Assessment
	 */
	@Test(priority = 14)
	public void TCSPR1200714() {

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
	 * To perform Assessment publish functionality
	 */
	@Test(priority = 15)
	public void TCSPR1200715() {

		// Click on Back to menu button
		click(ap.Backtomenu_btn);

		waitThread(2000);

		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(ap.publish_popup), "popup not visible");

		// Assert the Current Assessment is selected
		Assert.assertEquals(getAttribute(ap.currentassess_tab, "aria-selected"), "true");

		// search assessment
		type(tp.search_box, AssessmentName);
		waitThread(1000);

		// Assert the new assessment card visible
		Assert.assertTrue(isElementPresent(tp.newcard), " new assessment card not visible");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(tp.newasses_lbl), AssessmentName);
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseID));

	}

	/*
	 * To check the test section of Assessment card
	 */
	@Test(priority = 16)
	public void TCSPR1200716() {
		// search newly created assessment
		type(tp.search_box, AssessmentName);
		waitThread(2000);
		// Assert the new assessment card visible
		Assert.assertTrue(isElementPresent(tp.newcard), " new assessment card not visible");
	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 17)
	public void TCSPR1200717() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * To perform Login functionality of student1 profile and check the Assessment
	 * card
	 */
	@Test(priority = 18)
	public void TCSPR1200718() {

		waitThread(1000);

		lg.login("student1@gmail.com", password);

		waitThread(3000);
		// verify heading label current Assessments
		Assert.assertEquals(getText(QP.current_assesslabel), "Current Assessments");

		waitThread(5000);

		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(3000);

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
	 * To begin the test and add incomplete and complete answers
	 */
	@Test(priority = 19)
	public void TCSPR1200719() throws InterruptedException {
		// wait for 1 min
		TimeUnit.MINUTES.sleep(1);
		waitThread(1000);

		// click begin test
		click(sa.begintest_btn);
		waitThread(4000);

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

		// Click on my answer is incompleted button
		click(ms.incomp_txt_checkbx);
		waitThread(1000);

		Assert.assertTrue(getAttribute(ms.incomp_txt_checkbx2, "class").contains("p-checkbox-checked"));

		click(an.saveNext_btn);
		waitThread(1000);

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

		// Assert the 3rd question is selcted
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));

		// Assert the 2nd question showing incomplete answer
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-paginator-complete"));

	}

	/*
	 * To check the card status when the answers kept in draft
	 */
	@Test(priority = 20)
	public void TCSPR1200720() {

		// Assert the Buttons Discard,Next Question,Submit
		Assert.assertTrue(isEnabled(an.saveExit_btn), "Next Question button not present");
		click(an.saveExit_btn);
		waitThread(5000);

		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(3000);

		// Assert the Buttons Discard,Next Question,Submit
		Assert.assertTrue(isElementPresent(ac.resumetest_btn), "button not present");

		// Assert the test completed count is 1/4
		Assert.assertEquals(getText(ms.compcount), "1/4");

		waitThread(2000);

		click(ac.resumetest_btn);
		waitThread(5000);

		// Assert the 3rd question is selcted
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));

	}

	/*
	 * To check whether the incomplete status count visible on the Assessment card
	 * when submit the answers
	 */
	@Test(priority = 21)
	public void TCSPR1200721() {

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// enter answer 1
		type(an.ansplaceholder, "Answer 3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		click(ms.submit_btn);

		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");

		// Assert the text Are you sure you want to submit the assessment?
		Assert.assertEquals(getText(ms.confirmation_txt),
				"There are incomplete answers/skipped questions, do you want to proceed ?");

		click(ms.submit_confi);

		waitFor(QP.toaster);

		// Assert the toaster Assessment Submitted
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		// Click on Back to Assessment
		click(ms.backtoassess_btn);

		waitThread(3000);
		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
	}

	/*
	 * To check answers count on assessment card when give submit
	 */
	@Test(priority = 22)
	public void TCSPR1200722() {

		waitThread(4000);
		type(sa.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the Buttons Discard,Next Question,Submit
		Assert.assertTrue(isElementPresent(ms.modify_btn), "button not present");

		// Assert the test completed count is 3/3
		Assert.assertEquals(getText(ms.compcount), "3/4");

		Assert.assertEquals(getText(tp.teststs_lbl), "Submitted");

		click(ms.modify_btn);
		waitThread(4000);

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

		// assert checkbox not selected
		Assert.assertTrue(getAttribute(ms.incomp_txt_checkbx2, "class").contains("p-checkbox-checked"));

	}

	/*
	 * To modify the submitted answers
	 */
	@Test(priority = 23)
	public void TCSPR1200723() {

		// Untick the my answer is incomplete button
		click(ms.incomp_txt_checkbx);
		waitThread(1000);

		// assert checkbox not selected
		Assert.assertFalse(getAttribute(ms.incomp_txt_checkbx2, "class").contains("p-checkbox-checked"));

		// Assert the tooltips of buttons
		MouseHover(ms.next_btn);
		Assert.assertEquals(getAttribute(ms.next_btn, "ptooltip"), "Next Question");

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Assert the 1st question answer empty
		Assert.assertEquals(getText(an.ansplaceholder), "Answer 1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		click(ms.next_btn);

		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques2_lbl, "class").contains("p-highlight"));
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Assert the 2nd answer content answer 2
		Assert.assertEquals(getText(an.ansplaceholder), "Answer 2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		click(ms.next_btn);
		waitThread(1000);

		// Assert the 3rd question is selcted
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Assert the 3rd question answer empty
		Assert.assertEquals(getText(an.ansplaceholder), "Answer 3");

		// Clear the 3rd answer
		click(an.ansplaceholder);
		driver.findElement(By.xpath(an.ansplaceholder)).clear();

		driver.switchTo().defaultContent();
		waitThread(1000);
		click(ms.next_btn);
		waitThread(1000);

		// Assert the 4th question is selcted
		Assert.assertTrue(getAttribute(an.ques4_lbl, "class").contains("p-highlight"));

		// Assert the Question 3 Wizard is showing un Answerd
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-paginator-visitednotattended"));

	}

	/*
	 * To check whether the modified answers count visible on the card
	 */
	@Test(priority = 24)
	public void TCSPR1200724() {

		// click submit button
		click(ms.submit_btn);
		waitThread(2000);
		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");

		// Assert the text "You have 4 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(ms.confirmation_txt), "You have 2 skipped question(s)! Proceed to submit?");

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
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys("  ");
		waitThread(5000);

		// Assert the test completed count is 3/3
		Assert.assertEquals(getText(ms.compcount), "2/4");

		// Assert test status submitted
		Assert.assertEquals(getText(tp.teststs_lbl), "Submitted");

	}

	/*
	 * To check discard changes button functionality
	 */
	@Test(priority = 25)
	public void TCSPR1200725() {

		click(ms.modify_btn);
		waitThread(4000);

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-paginator-complete"));

		click(an.ques3_lbl);
		waitThread(1000);

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Assert the 1st question answer empty
		Assert.assertEquals(getAttribute(an.ansplaceholder, "aria-placeholder"), "Enter Answer");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Assert the Discard Changes button is in disabled state
		Assert.assertFalse(isEnabled(ac.dischange_btn), "Button not present");

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// enter answer 1
		type(an.ansplaceholder, "Answer 3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Assert the Discard Changes button is in disabled state
		Assert.assertTrue(isEnabled(ac.dischange_btn), "Button not present");

		// Untick the my answer is incomplete button
		click(ms.incomp_txt_checkbx);
		waitThread(1000);

		// assert checkbox not selected
		Assert.assertTrue(getAttribute(ms.incomp_txt_checkbx2, "class").contains("p-checkbox-checked"));

		click(ac.dischange_btn);
		waitThread(1000);

		waitFor(QP.toaster);

		// Assert the toaster Discarded the changes
		Assert.assertEquals(getText(QP.toaster), "Discarded the changes");

		click(QP.toasterclosebtn);

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Assert the 1st question answer empty
		Assert.assertEquals(getText(an.ansplaceholder), "");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Assert check box present
		Assert.assertFalse(isElementPresent(ms.incomp_txt_checkbx), "Button not present");

	}

	/*
	 * To check whether the Next Question button disable when user reach last
	 * question
	 */
	@Test(priority = 26)
	public void TCSPR1200726() {

		// Assert the Next Question button is enabled
		Assert.assertFalse(getAttribute(an.next_btn, "class").contains("p-disabled"));

		click(an.ques4_lbl);
		waitThread(1000);

		// Assert the 2nd question is selcted
		Assert.assertTrue(getAttribute(an.ques4_lbl, "class").contains("p-highlight"));

		// Assert the Next Question button is Disabled
		Assert.assertTrue(getAttribute(an.next_btn, "class").contains("p-disabled"));
		waitThread(2000);

		click(an.ques3_lbl);
		waitThread(2000);

		// Assert the 3rd question is selcted
		Assert.assertTrue(getAttribute(an.ques3_lbl, "class").contains("p-highlight"));

		// Assert the Next Question button is enabled
		Assert.assertFalse(getAttribute(an.next_btn, "class").contains("p-disabled"));

	}

	/*
	 * To check the Discard button functions and answers count on card
	 */
	@Test(priority = 27)
	public void TCSPR1200727() {

		waitThread(2000);

		// click submit button
		click(ms.submit_btn);

		click(ms.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Assessment Submitted"
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		// Click on Back to Assessment
		click(ms.backtoassess_btn);

		waitThread(2000);

		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		waitThread(4000);

		// search assessment name
		type(sa.stud_searchbx, AssessmentName);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys("  ");
		waitThread(2000);
		waitThread(2000);

		// click modify button
		click(ms.modify_btn);
		waitThread(4000);

		// click question 3
		click(an.ques3_lbl);
		waitThread(1000);
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// enter answer 3
		type(an.ansplaceholder, "Answer 3");

		driver.switchTo().defaultContent();
		waitThread(1000);
		click(ms.next_btn);
		waitThread(2000);

		// Assert the 4th question is selcted

		Assert.assertTrue(getAttribute(an.ques4_lbl, "class").contains("p-highlight"));
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// enter answer 4
		type(an.ansplaceholder, "Answer 4");

		driver.switchTo().defaultContent();
		waitThread(2000);
		click(ms.discard_btn);
		waitThread(5000);
		// Assert confirmation popup visible
		Assert.assertTrue(isElementPresent(an.cof_popup), "popup not visible");

		waitThread(2000);
		// Assert confirmation label
		Assert.assertEquals(getText(ms.conf_lbl),
				"Do you want to discard the changes made and exit the answer window?");

		click(ms.yes_btn);

		waitFor(QP.toaster);

		// Assert the toaster Assessment Discarded
		Assert.assertEquals(getText(QP.toaster), "Assessment Discarded");

		click(QP.toasterclosebtn);

		waitThread(2000);

		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		waitThread(4000);

		type(sa.stud_searchbx, AssessmentName);
		waitThread(2000);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys("  ");
		waitThread(2000);

		// Assert the test completed count is 2/4
		Assert.assertEquals(getText(ms.compcount), "2/4");

		waitThread(2000);
		// Assert test status submitted
		Assert.assertEquals(getText(tp.teststs_lbl), "Submitted");

	}

	/*
	 * To check whether the discarded answers not present in the answer box
	 */
	@Test(priority = 28)
	public void TCSPR1200728() {

		waitThread(1000);
		click(ms.modify_btn);
		waitThread(4000);

		click(an.ques3_lbl);
		waitThread(1000);
		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Assert the 1st question answer empty
		Assert.assertEquals(getText(an.ansplaceholder), "");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// click question 4
		click(an.ques4_lbl);
		waitThread(1000);

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Assert the 1st question answer empty
		Assert.assertEquals(getText(an.ansplaceholder), "");

		driver.switchTo().defaultContent();
		waitThread(1000);
		// click submit button
		click(ms.submit_btn);
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

		waitThread(2000);

		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

	}

	/*
	 * To check whether questions answered count by student is same in teachers card
	 */
	@Test(priority = 29)
	public void TCSPR1200729() {

		waitThread(4000);
		type(sa.stud_searchbx, AssessmentName);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys("  ");
		waitThread(2000);
		waitThread(2000);

		// Assert the test completed count is 2/3
		Assert.assertEquals(getText(ms.compcount), "2/4");
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		lg.login("teacherOne@gmail.com", password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// Click Assessment tab
		click(QP.teach_assesstab);

		waitThread(5000);

		// search assessment
		type(tp.search_box, AssessmentName);
		
		waitThread(3000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(tp.newcard), "Published Assessment card not visible");

		// Assert the count 1/4
		Assert.assertEquals(getText(ac.student_count_graph), "1/4");

	}

	/*
	 * To check whether questions answered count by student is same in teachers card
	 */
	@Test(priority = 30)
	public void TCSPR1200730() {

		// Assert the Test status "Active"
		Assert.assertEquals(getText(tp.teststs_lbl), "Active");

		// Assert View details button
		Assert.assertTrue(isElementPresent(ac.viewdetails1_btn), "Button not visible");

		// Click View details button
		click(ac.viewdetails1_btn);
		waitThread(2000);

		// Assert the Assessment status popup visible
		Assert.assertTrue(isElementPresent(ac.assessmentsts_popup), "popup not visible");

		// Assert the Student1 name visible on popup
		Assert.assertEquals(getText(ac.student1), student1);

		// Assert Questions answered count 4/4
		Assert.assertEquals(getText(ac.anscount1), "2/4");

		// Assert the Student2 name visible on popup
		Assert.assertEquals(getText(ac.student2), student2);

		// Assert Questions answered count 0/4
		Assert.assertEquals(getText(ac.anscount2), "0/4");
		click(ac.close_btn);
		waitThread(3000);
		Assert.assertFalse(isElementPresent(ac.assessmentsts_popup), "popup not visible");
	}

	/*
	 * To Reschedule the date of Assessment
	 */
	@Test(enabled = false)
	public void TCSPR1200731() throws InterruptedException {



		// search assessment
		type(tp.search_box, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(tp.newcard), "Published Assessment card not visible");

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

		waitThread(2000);
		click(rd.testduetime_txtbx);

		waitThread(2000);

		Doubleclick(rd.timeadjust);
		Doubleclick(rd.timeadjust);
		Doubleclick(rd.timeadjust);
		waitThread(1000);

		waitThread(2000);
		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitThread(4000);

	}

	/*
	 * To perform logout functionality on the teacher profile& login to studernt1
	 */
	@Test(priority = 32)
	public void TCSPR1200732() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		lg.login("student1@gmail.com", password);

		waitThread(3000);
		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		Doubleclick(sa.stud_searchbx);
		waitThread(1000);
		type(sa.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

	}

	/*
	 * To modify the submitted answers and wait till the assessment time ranout
	 * popup visible
	 */
	@Test(priority = 33)
	public void TCSPR1200733() throws InterruptedException {

		click(ms.modify_btn);
		waitThread(3000);

		// Assert the 1st question is selcted
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

		// click question 3
		click(an.ques3_lbl);

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// enter answer 3
		type(an.ansplaceholder, "Answer 3");

		driver.switchTo().defaultContent();
		waitThread(2000);
		click(ms.next_btn);

		waitThread(2000);
		// Assert the 4th question is selcted
		Assert.assertTrue(getAttribute(an.ques4_lbl, "class").contains("p-highlight"));

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// enter answer 4
		type(an.ansplaceholder, "Answer 4");

		driver.switchTo().defaultContent();
		waitThread(2000);


	}

	/*
	 * To check student card status when test due time passed
	 */
	@Test(priority = 34)
	public void TCSPR1200734() {

		// click submit button
		click(ms.submit_btn);
		waitThread(2000);
		click(ms.submit_confi);

		// Click back to menu button
		click(ac.backtomenu_btn);
		waitThread(5000);

		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(3000);

		// Assert the Text "Window closed " at test section
		Assert.assertEquals(getText(ac.windowclosed_lbl), "Window Closed");

		// Assert the Questions count 4/4
		Assert.assertEquals(getText(ms.compcount), "4/4");
		waitThread(2000);

		// Assert the status Test submitted
		Assert.assertEquals(getText(ac.teststs_lbl), "Submitted");

	}

	/*
	 * To check whether questions answered count by student is same in teachers card
	 */
	@Test(priority = 35)
	public void TCSPR1200635() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		lg.login("teacherOne@gmail.com", password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// Click Assessment tab
		click(QP.teach_assesstab);

		waitThread(5000);

		// search assessment
		type(tp.search_box, AssessmentName);
		waitThread(1000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(tp.newcard), "Published Assessment card not visible");

		waitThread(1000);
		// Assert the count 0/2
		Assert.assertEquals(getText(ac.student_count_graph), "1/4");

	}

	/*
	 * To check whether questions answered count by student is same in teachers card
	 */
	@Test(priority = 36)
	public void TCSPR1200736() {

		waitThread(2000);
		// Assert the Test status "Window closed"
		Assert.assertEquals(getText(tp.teststs_lbl), "Window Closed");

		// Assert View details button
		Assert.assertTrue(isElementPresent(ac.viewdetails1_btn), "Button not visible");
		waitThread(2000);

		// Click View details button
		click(ac.viewdetails1_btn);
		waitThread(2000);

		// Assert the Assessment status popup visible
		Assert.assertTrue(isElementPresent(ac.assessmentsts_popup), "popup not visible");

		// Assert the Student1 name visible on popup
		Assert.assertEquals(getText(ac.student1), student1);

		waitThread(1000);
		// Assert Questions answered count 4/4
		Assert.assertEquals(getText(ac.anscount1), "4/4");

		// Assert the Student2 name visible on popup
		Assert.assertEquals(getText(ac.student2), student2);

		// Assert Questions answered count 0/4
		Assert.assertEquals(getText(ac.anscount2), "0/4");

		waitThread(2000);
		click(ac.close_btn);

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 37)
	public void TCSPR1200737() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}
}
