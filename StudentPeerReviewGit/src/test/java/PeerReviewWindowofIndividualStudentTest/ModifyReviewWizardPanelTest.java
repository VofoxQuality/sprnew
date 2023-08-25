package PeerReviewWindowofIndividualStudentTest;

import java.time.Month;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import CreateNewAssessment.Pages.ClickableRubricPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CreateNewAssessment.Pages.SummaryQuestionsPage;
import CurrentAssessmentsforStudents.Pages.StudentCurrentAssessmentBasicsPage;
import CurrentAssessmentsforStudents.Pages.StudentPeerReviewPage;
import CurrentAssessmentsforStudents.Pages.StudentTestSectionPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.NewAssessmentTeacherBasicsPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import NewAssessmentOfTeacherPage.TeacherResultSectionPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import PeerReviewWindowofIndividualStudentPages.ModifyReviewWizardPanelPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowWizardPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import TestWindowOfIndividualStudent.AnswerWindowPage;
import TestWindowOfIndividualStudent.ModifySubmittedAnswersPage;
import TestWindowOfIndividualStudent.ModifyWizardSectionPage;
import TestWindowOfIndividualStudent.TestWindowWizardPage;

public class ModifyReviewWizardPanelTest extends basePage {
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
	ClickableRubricPage ck = new ClickableRubricPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	SchedulePageBasicsPage sb1 = new SchedulePageBasicsPage();
	SummaryBasicsPage sb = new SummaryBasicsPage();
	SummaryQuestionsPage sq = new SummaryQuestionsPage();
	AssessmentPublishPopupPage ap = new AssessmentPublishPopupPage();
	TeacherResultSectionPage tr = new TeacherResultSectionPage();
	TeacherPeerReviewSectionPage tp = new TeacherPeerReviewSectionPage();
	TeacherTestSectionPage tts = new TeacherTestSectionPage();
	StudentTestSectionPage st1 = new StudentTestSectionPage();
	StudentPeerReviewPage sp1 = new StudentPeerReviewPage();
	TestWindowWizardPage tsw = new TestWindowWizardPage();
	AnswerWindowPage an = new AnswerWindowPage();
	PeerReviewWindowWizardPage prw = new PeerReviewWindowWizardPage();
	ModifySubmittedAnswersPage ma = new ModifySubmittedAnswersPage();
	ModifyReviewWizardPanelPage mrw = new ModifyReviewWizardPanelPage();
	CommonMethods cm = new CommonMethods();
	StudentCurrentAssessmentBasicsPage sca = new StudentCurrentAssessmentBasicsPage();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	NewAssessmentTeacherBasicsPage natb = new NewAssessmentTeacherBasicsPage();
	ModifyWizardSectionPage ms = new ModifyWizardSectionPage();

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
	public String quest1;

	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	public String Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
	public String Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";
	public String Emailstudent3 = "student3" + generateRandomNumber().trim() + "@gmail.com";

	/*
	 * To perform Login functionality
	 */
	@Test(priority = 1)
	public void TCSPR1300501() {

		click(lg.LoginBtn_1);

		cm.login(cm.emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}
	/*
	 * To create new course
	 */
	// @Test(priority = 2)
	// public void TCSPR1300502() throws SQLException {
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

	// // type email
	// type(cn.tab_textbox, Emailstudent1 + ",");
	// driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
	// type(cn.tab_textbox, Emailstudent2 + ",");
	//
	// // verify email present on the text box
	// Assert.assertEquals(cn.emailvalue(0), Emailstudent1);
	//
	// Assert.assertEquals(cn.emailvalue(1), Emailstudent2);
	// Assert.assertEquals(cn.emailvalue(2), Emailstudent_3);

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
	// public void TCSPR1300503() {
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
	// public void TCSPR1300504() throws SQLException {
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
	// public void TCSPR1300505() {
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
	// public void TCSPR1300506() throws SQLException {
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
	// public void TCSPR1300507() {
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

	// @Test(priority = 8)
	// public void TCSPR1300508() throws SQLException {
	//
	// lg.login("student3@gmail.com", password);
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
	// @Test(priority = 9)
	// public void TCSPR1300509() {
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

	public String CourseID = cm.CourseID3;
	public String CourseName = cm.CourseName3;

	/*
	 * To load the create new assessment page and fill details on the basic
	 * details page
	 */
	@Test(priority = 10)
	public void TCSPR1300510() {
		SoftAssert softAssert1 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(12000);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename3);

		softAssert1.assertEquals(getText(ba.ddcoursename3), CourseName.trim(),
				"course name not visible on the dropdown");

		click(ba.ddcoursename3);

		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentName = "Assessment" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentName);

		waitThread(2000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(2000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(1000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), AssessmentName);

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID + ", " + CourseName.trim());

		softAssert1.assertAll();

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 11)
	public void TCSPR1300511() {



		// Type Question 1
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);

		quest1 = "Question1";
		type(QP.Quest_box, quest1);

		// Assert the question content on the question editor
		Assert.assertEquals(getText(QP.Quest_box), quest1);
		driver.switchTo().defaultContent();

		// Page Scroll down
		QP.Scroll_DowntoEnd();
		waitThread(2000);

		// Click on Add rubric tab
		click(QP.rubric_drp_btn);
		waitThread(1000);

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Type data in Standard Rubric box
		driver.switchTo().frame("rubric_ifr");
		waitThread(2000);
		type(QP.std_rub_bx, "R1");

		// Assert the rubic content on the textbox
		Assert.assertEquals(getText(QP.std_rub_bx), "R1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, "5");

		MouseHover(QP.save);

		waitThread(1000);
		// Click on +button
		click(rd.add_quest_btn);
		waitFor(QP.toaster);

		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		
		click(QP.toasterclosebtn);
		waitThread(1000);
		// Assert the label "2.Questions"
		Assert.assertEquals(getText(QP.question1), "2." + "\nQuestion");

		// Type Question 2
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);

		waitThread(1000);
		type(QP.Quest_box, "Question2");

		// Assert the question content on the question editor
		Assert.assertEquals(getText(QP.Quest_box), "Question2");
		driver.switchTo().defaultContent();

		ScrollTo_Location(QP.Qassessmentdetails);
		waitThread(3000);

		// Click rubric drop down
		//click(QP.rubric_drp_btn);
		waitThread(2000);

		click(QP.click_radio);
		waitThread(2000);
		// Add 3 columns
		Doubleclick(QP.add_column);
		click(QP.add_column);

		// Assert the clickable rubric radio button is Selected
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		// Type criteria1
		type(ck.crit1_bx, "CR1");

		// Type Score for columns
		type(ck.scre_col1, "2");
		type(ck.scre_col2, "3");
		type(ck.scre_col3, "4");

		// Type conditions for columns
		driver.switchTo().frame("editorFieldRubric_00_ifr");
		type(mrw.cond_00, "Condition1");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("editorFieldRubric_01_ifr");
		type(mrw.cond_01, "Condition2");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("editorFieldRubric_02_ifr");
		type(mrw.cond_02, "Condition3");
		driver.switchTo().defaultContent();

		// Add 2 rows
		click(QP.add_row);
		click(QP.add_row);

		// Enter criteria 2 , conditions&scores for row2
		type(ck.crit2_bx, "CR2");

		type(ck.scre_rw1, "1");
		type(ck.score_r22, "2");
		type(ck.score_r23, "4");

		driver.switchTo().frame("editorFieldRubric_10_ifr");
		type(mrw.cond_10, "Condition10");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("editorFieldRubric_11_ifr");
		type(mrw.cond_11, "Condition11");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("editorFieldRubric_12_ifr");
		type(mrw.cond_12, "Condition12");
		driver.switchTo().defaultContent();

		// Enter criteria 3 , conditions&scores for row3
		type(ck.crit3_bx, "CR3");

		type(ck.score_r30, "0");
		type(ck.score_r31, "1");
		type(ck.score_r32, "2");

		driver.switchTo().frame("editorFieldRubric_20_ifr");
		type(mrw.cond_20, "Condition20");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("editorFieldRubric_21_ifr");
		type(mrw.cond_21, "Condition21");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("editorFieldRubric_22_ifr");
		type(mrw.cond_22, "Condition22");
		driver.switchTo().defaultContent();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, -250);");

		MouseHover(QP.save);
		waitThread(4000);
		// Click Save button
		click(QP.save);

		waitFor(QP.toasterclosebtn);
		// Assert toaster Question 2 Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully");
		click(QP.toasterclosebtn);

	}

	/*
	 * To add more questions to questions page
	 *
	 **/
	@Test(priority = 12)
	public void TCSPR1300512() {
		MouseHover(QP.save);

		waitThread(3000);
		// Click add question
		click(rd.add_quest_btn);

		waitThread(3000);
		// Assert the label "3.Questions"
		Assert.assertEquals(getText(QP.question1), "3." + "\nQuestion");

		// Type Question 3
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);

		waitThread(1000);
		type(QP.Quest_box, "Question3");
		driver.switchTo().defaultContent();

		ScrollTo_Location(QP.Qassessmentdetails);
		waitThread(3000);

		// Click rubric drop down
		//click(QP.rubric_drp_btn);
		waitThread(3000);

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Type data in Standard Rubric box
		driver.switchTo().frame("rubric_ifr");
		waitThread(2000);
		type(QP.std_rub_bx, "R3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, "6");

		MouseHover(QP.save);

		waitThread(2000);
		// Click on +button
		click(rd.add_quest_btn);
		waitThread(1000);
		waitFor(QP.toaster);

		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 3 Saved successfully");
		click(QP.toasterclosebtn);
		waitThread(1000);
		// Assert the label "4.Questions"
		Assert.assertEquals(getText(QP.question1), "4." + "\nQuestion");

		// Type Question 4
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);

		waitThread(1000);
		type(QP.Quest_box, "Question4");
		driver.switchTo().defaultContent();
		ScrollTo_Location(QP.Qassessmentdetails);
		waitThread(3000);

		// Click rubric drop down
		//click(QP.rubric_drp_btn);
		waitThread(3000);

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Type data in Standard Rubric box
		driver.switchTo().frame("rubric_ifr");
		waitThread(2000);
		type(QP.std_rub_bx, "R4");

		driver.switchTo().defaultContent();
		waitThread(1000);
		
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, "7");
		
		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 4 Saved successfully");
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
	@Test(priority = 13)
	public void TCSPR1300513() {

		waitThread(3000);

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Select Answer Sheets Per Student =2
		click(prw.reviewans_sheetdropdwn);
		waitThread(1000);
		click(prw.reviewssheet_count);

		// Enter peer review Reward score 100
		type(prw.peer_reward_scorebx, "100");

		// Assert the text::Total Students : Assert the total student count is 3
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 3");

	}

	/*
	 * To perform the save and next functionaity from peer review page and
	 * verify the schedule page details
	 */
	@Test(priority = 14)
	public void TCSPR1300514() {
		click(pr.savennext_button);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);
		waitThread(2000);
		Assert.assertEquals(getAttribute(sb1.schedule_wizard, "aria-expanded"), "true");

		// Assert the text "Select schedules for "
		Assert.assertEquals(getText(sb1.selectstu_lbl), "Select Schedules for");

	}

	/*
	 * To verify the details on the Summary page & publish the Assessment
	 */
	@Test(priority = 15)
	public void TCSPR1300515() {
		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");

		// Assert the Text "Questions Summary"
		Assert.assertEquals(getText(sq.Summary_quest), "Questions Summary");

		quest_count = getText(sq.total_questcount);
		// Assert the total Questions count
		Assert.assertEquals(getText(sq.total_questcount), quest_count);

	}

	/*
	 * To perform Assessment publish functionality
	 */
	@Test(priority = 16)
	public void TCSPR1300516() {

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
	@Test(priority = 17)
	public void TCSPR1300517() {

		// Click Back to Menu
		click(tts.back_to_menubutton);
		waitThread(9000);
		// Assert the text "Assessments "
		Assert.assertEquals(getText(ba.lbl_assessment), "Assessments");

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
	 * To check the test section of Assessment card
	 */
	@Test(priority = 18)
	public void TCSPR1300518() {

		waitThread(2000);

		// Assert the text "Students completed"
		Assert.assertEquals(getText(st1.stud_compl_txt), "Students Submitted");
	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 19)
	public void TCSPR1300519() {
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform Login functionality of student1 profile and check the
	 * Assessment card
	 */
	@Test(priority = 20)
	public void TCSPR1300120() {
		// login as Student1
		lg.login("student1@gmail.com", password);

		waitThread(9000);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(3000);

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
	 * To Begin Test &add answers to questions by Student1
	 */
	@Test(priority = 21)
	public void TCSPR1300121() throws InterruptedException {

//		// Wait till assessment active
//		TimeUnit.MINUTES.sleep(1);
//		TimeUnit.SECONDS.sleep(50);


		
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='studentAssessmentDataView']//div[1]/button/span[2]")));
		// Assert the test status as active
		Assert.assertEquals(getText(tp.teststs_lbl), "Active");

		// Assert the button begin test
		Assert.assertTrue(isDisplayed(st1.begintest_btn), "Begin test not present");
		Assert.assertEquals(getText(st1.begintest_btn), "Begin Test");
		
		waitThread(2000);
		// Click Begin Test
		click(st1.begintest_btn);

		// Assert the total Questions, Total score
		Assert.assertTrue(getText(tsw.questions_count).contains("Total Questions"));
		Assert.assertTrue(getText(tsw.total_score).contains("Total Score"));

		// Assert the first question is highlighted on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));
		Assert.assertEquals(getText(tsw.quest_1_wizard), "1");

		// Enter Answer1
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer1");

		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(1000);
		// Assert first Question is answered
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("complete"));

		// Enter Answer2
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer2");

		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(1000);
		// Assert Second Question is answered
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("complete"));

		// Enter Answer3
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer3");

		driver.switchTo().defaultContent();
		waitThread(2000);

		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(1000);
		// Assert Third Question is answered
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("complete"));

		// Enter Answer4
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer4");

		driver.switchTo().defaultContent();

		// Assert Submit button
		Assert.assertTrue(isDisplayed(tsw.submit_btn), "Submit button not present");

	}

	/*
	 * To submit the Assessment and logout from Student1 profile
	 */
	@Test(priority = 22)
	public void TCSPR1300122() {

		waitThread(2000);
		// Click Submit button
		click(tsw.submit_btn);

		waitThread(1000);
		// Assert confirmation popup
		Assert.assertTrue(isDisplayed(tsw.confir_popup), "popup not visible");

		// Click submit button on popup
		click(tsw.submit_confi);

		// Assert toaster "Assessment Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		waitThread(3000);
		// click back to Assessments
		click(tsw.backtoassess_btn);

		waitThread(12000);
		// Assert the current Assessments
		Assert.assertEquals(getText(prw.current_assess_label), "Current Assessments");

		waitThread(4000);
		// Perform logout from Student1
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To Perform Login by Student2 and to Begin Test
	 */
	@Test(priority = 23)
	public void TCSPR1300123() {

		// login as Student2
		lg.login("student2@gmail.com", password);

		waitThread(12000);

		Doubleclick(st1.stud_searchbx);
		waitThread(2000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(3000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(st1.Assess_name_card), AssessmentName);
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(tp.course_lbl).contains(CourseID));

		// Assert the teacher name
		Assert.assertTrue(getText(st1.teachername_card).contains(Teachername));

		waitThread(2000);
		// Click Begin Test
		click(st1.begintest_btn);

		// Assert the first question is highlighted on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));
		Assert.assertEquals(getText(tsw.quest_1_wizard), "1");

	}

	/*
	 * To Add answers to first Question and 2nd Question
	 */
	@Test(priority = 24)
	public void TCSPR1300524() {
		// Enter Answer1
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer1_Student1");

		driver.switchTo().defaultContent();

		waitThread(3000);
		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(2000);
		// Assert first Question is answered
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("complete"));

		// Enter Answer2
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer2_Student1");

		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(1000);
		// Assert Second Question is answered
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("complete"));
		waitThread(2000);

		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(1000);
		// Assert Third Question is unanswered
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("visitednotattended"));

	}

	/*
	 * To Submit the Assessment and logout from Student2 profile
	 */
	@Test(priority = 25)
	public void TCSPR1300525() {
		waitThread(1000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(1000);

		Assert.assertTrue(isDisplayed(tsw.confir_popup), "popup not visible");

		// Assert the text "You have 2 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(tsw.confirmation_txt), "You have 2 skipped question(s)! Proceed to submit?");

		waitThread(1000);
		// Click submit button on popup
		click(tsw.submit_confi);

		// Assert toaster "Assessment Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		waitThread(3000);

		// click back to Assessments
		click(tsw.backtoassess_btn);

		waitThread(5000);
		Doubleclick(st1.stud_searchbx);
		waitThread(3000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the Questions answered count 2/4
		Assert.assertEquals(getText(tsw.ans_count), "2/4");

		// Perform logout from Student2
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To Perform Login by Student3 and to Begin Test
	 */
	@Test(priority = 26)
	public void TCSPR1300526() {
		// Perform login by Student3
		lg.login("student3@gmail.com", password);

		waitThread(12000);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

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

		waitThread(2000);
		// Click Begin Test
		click(st1.begintest_btn);

		// Assert the first question is highlighted on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));
		Assert.assertEquals(getText(tsw.quest_1_wizard), "1");

	}

	/*
	 * To Add answers to first Question and 4th Question
	 */
	@Test(priority = 27)
	public void TCSPR1300527() {

		// Enter Answer1
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer1_Student2");

		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(1000);
		// Assert first Question is answered
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("complete"));

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.Savenext);

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.Savenext);
		// Assert Second Question is unanswered
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("visitednotattended"));

		waitThread(1000);
		// Enter Answer4
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer4_Student2");

		driver.switchTo().defaultContent();

		// Assert Third Question is unanswered
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("visitednotattended"));

	}

	/*
	 * To Submit the Assessment and wait until peer review active
	 */
	@Test(priority = 28)
	public void TCSPR1300528() throws InterruptedException {
		waitThread(2000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(1000);

		Assert.assertTrue(isDisplayed(tsw.confir_popup), "popup not visible");

		// Assert the text "You have 2 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(tsw.confirmation_txt), "You have 2 skipped question(s)! Proceed to submit?");

		waitThread(1000);
		// Click submit button on popup
		click(tsw.submit_confi);

		// Assert toaster "Assessment Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		waitThread(3000);
		// click back to Assessments
		click(tsw.backtoassess_btn);

		waitThread(5000);
		Doubleclick(st1.stud_searchbx);
		waitThread(3000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(3000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the Questions answered count 2/4
		Assert.assertEquals(getText(tsw.ans_count), "2/4");

		cm.Logout();

	}

	/*
	 * To perform reschedule of Test Window and Peer Review window
	 */
	@Test(priority = 29)
	public void RescheduleTestAndPeerDate() {

		// Login as Teacher
		cm.login(cm.emailteacher, cm.Password);

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(12000);

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
	//	cm.ClickTodaysDate_PeerReview();
		waitThread(1000);
		 Calendar cal = Calendar.getInstance();
		 int monthNumber2 = cal.get(Calendar.MONTH);
		 int Day = cal.get(Calendar.DAY_OF_MONTH);
		 int monthNumber = monthNumber2 + 1;
		 String monthname =Month.of(monthNumber).name();
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
	 * To begin the Review & check the labels of peer review window
	 */
	@Test(priority = 29)
	public void TCSPR1300529() throws InterruptedException {

		waitThread(1000);
		lg.login("student1@gmail.com", password);

//
	TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(30);

		waitThread(5000);
		Doubleclick(st1.stud_searchbx);
		waitThread(3000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(3000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");
		
		
		
		
		// Assert the Begin Review button
		Assert.assertTrue(isDisplayed(st1.begintest_btn), "Begin Review not present");
		Assert.assertEquals(getText(st1.begintest_btn), "Begin Review");

		// Assert peer review % =0%
		Assert.assertEquals(getText(sp1.zeropercent_card), "0%");
		
		// Click Begin Review
		Doubleclick(st1.begintest_btn);
		waitThread(3000);
		// Assert the Assessment name
		Assert.assertEquals(getText(tsw.test_window_assess_name), AssessmentName);

		// Assert the coursename, id, Teacher name on the test window
		Assert.assertTrue(getText(tsw.course_name_id).contains(CourseName));
		Assert.assertTrue(getText(tsw.course_name_id).contains(CourseID));

		Assert.assertTrue(getText(tsw.teach_name_testwindow).contains(Teachername));

		// Assert the time status
		Assert.assertTrue(getText(tsw.time_status).contains("Peer Review Active for "));

	}

	/*
	 * To check the answers of student1 &sudent2 and also to check the save
	 * button functionality
	 */
	@Test(priority = 30)
	public void TCSPR1300530() {

		// Open Answer box of Student1
		click(prw.studentone_label);

		driver.switchTo().frame("answerViewEditor_0_ifr");
		waitThread(2000);
		// Assert the Student1 Answer visible on the box
		Assert.assertTrue(isElementPresent(prw.ans_bx_stud1), "Answer Box of Student Two not visible");
		driver.switchTo().defaultContent();
		waitThread(2000);

		// Open Answer box of Student2
		click(prw.student2_label);

		driver.switchTo().frame("answerViewEditor_1_ifr");
		waitThread(2000);
		// Assert the Answer visible on the box
		Assert.assertTrue(isElementPresent(prw.ans_bx_stud2), "Answer Box of Student Two not visible");
		driver.switchTo().defaultContent();
		waitThread(2000);

		// Assert save button is disable
		Assert.assertTrue(getAttribute(tsw.save_btn_test, "class").contains("disabled-btn"));

		// Click score box of student1
		click(prw.score_bx_stud1);

		// Enter score
		type(prw.score_bx_stud1, "2");

		// Assert save button enabled
		Assert.assertFalse(getAttribute(tsw.save_btn_test, "class").contains("disabled-btn"));

		waitThread(2000);
		// Assert a check mark displayed near scorebox of student 1
		Assert.assertTrue(getAttribute(mrw.score_tick_stud1, "class").contains("pi-check "));

	}

	/*
	 * To check the submit button & confirmation popup of incomplete & skipped
	 * reviews
	 */
	@Test(priority = 31)
	public void TCSPR1300531() {

		waitThread(3000);
		// Click Save &Next button
		click(QP.savenext_btn);

		// Assert toaster "Score saved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Score Saved");

		click(QP.toasterclosebtn);
		waitThread(1000);

		MouseHover(tsw.quest_1_wizard);
		// Assert the first question is incomplete review
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("incomplete"));

		// Open Answer box of Student1
		click(prw.studentone_label);
		
		waitThread(2000);

		// Open Answer box of Student2
		click(prw.student2_label);
		waitThread(1000);
		ScrollTo_Location(mrw.stud_one_rub_label);
		waitThread(1000);
		// Assert label student one rubric
		Assert.assertEquals(getText(mrw.stud_two_rub_label), "Student Two Rubric");

		// Click scores on clickable rubric
		waitThread(2000);

		click(mrw.click_row11);
		Scroll_DowntoEnd();
		click(mrw.click_row22);
		click(mrw.click_row33);

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.savenext_btn);

		waitThread(1000);
		MouseHover(tsw.quest_2_wizard);
		waitThread(3000);
		// Assert the Second question wizard is Reviewed
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("complete"));

		waitThread(1000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(2000);
		// Assert confirmationn popup visible
		Assert.assertTrue(isDisplayed(prw.conf_popup), "popup not visible");

		waitThread(1000);
		// Assert the text "There are incomplete evaluation/skipped evaluation,
		// do you
		// want to proceed ?"
		Assert.assertEquals(getText(prw.conf_txt),
				"There are incomplete evaluation/skipped evaluation, do you want to proceed ?");

		waitThread(1000);
		// Click submit button
		click(prw.conf_submit_btn);

		// Assert toaster "Peer Review Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);

		// Click back to Assessments
		click(prw.backto_btn);
		waitThread(12000);
		// Assert Current Assessments label
		Assert.assertEquals(getText(mrw.current_assess), "Current Assessments");

	}

	/*
	 * To check the assessment card peer review section & modify peer review
	 * part
	 */
	@Test(priority = 32)
	public void TCSPR1300532() {
		waitThread(1000);
		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(" ");
		waitThread(4000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the peer review submitted
		Assert.assertEquals(getText(tp.peersts_lbl), "Submitted");

		// Assert the modify review button
		Assert.assertTrue(isDisplayed(st1.begintest_btn), "Modify Review not present");
		Assert.assertEquals(getText(st1.begintest_btn), "Modify Review");

		// Click modify review
		click(st1.begintest_btn);
		waitThread(2000);
		// Assert the Assessment name, course name , Id on the modify window
		Assert.assertTrue(getText(tsw.course_name_id).contains(CourseName));
		Assert.assertTrue(getText(tsw.course_name_id).contains(CourseID));

	}

	/*
	 * To check buttons of modify review window
	 */
	@Test(priority = 33)
	public void TCSPR1300533() {
		// Assert the Discard button
		Assert.assertTrue(isElementPresent(ms.discard_btn), "Discard button not present");
		Assert.assertEquals(getText(ms.discard_btn), "Discard");

		// Assert the Next Question button &Submit button
		Assert.assertTrue(isElementPresent(ms.next_btn), "Next Question button not present");
		Assert.assertEquals(getText(ms.next_btn), "Next Question");

		Assert.assertTrue(isElementPresent(ms.submit_btn), "Submit button not present");
		Assert.assertEquals(getText(ms.submit_btn), "Submit");

		waitThread(4000);
		// Assert the Question no:1 is visible on the page
		Assert.assertEquals(getText(tsw.quest1_text), "Question No: 1");
		Assert.assertTrue(isElementPresent(tsw.quest1_text), "Question no:1 is not visible on the page");

		waitThread(1000);
		// Click rubric accordian
		click(prw.rubric_accordian);

		// Assert the added rubric visible on the page
		driver.switchTo().frame("standardRubricViewEditor_ifr");
		waitThread(1000);

		Assert.assertEquals(getText(prw.std_rub_bx), "R1");
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Assert the Discard changes button disabled
		Assert.assertFalse(isEnabled(mrw.discard_changes), "Button not present");

		waitThread(2000);
		// Assert next question button enabled
		Assert.assertTrue(isEnabled(ms.next_btn), "Next Question button not present");

	}

	/*
	 * To check the Wizard of modify review .
	 */
	@Test(priority = 34)
	public void TCSPR1300534() {
		// Assert the prev button &next button on wizard are visible
		Assert.assertTrue(isElementPresent(an.last_btn), "Previous button not visible on the page");
		Assert.assertTrue(isElementPresent(an.next_btn), "Next Button not visible on the page");

		// Assert the prev button on wizard is disabled
		Assert.assertTrue(getAttribute(an.last_btn, "class").contains("p-disabled"));

		// Assert the next button on wizard is enabled
		Assert.assertFalse(getAttribute(an.next_btn, "class").contains("p-disabled"));

		// Assert all questions are visible on Wizard
		Assert.assertEquals(getText(tsw.quest_2_wizard), "2");
		Assert.assertEquals(getText(tsw.quest_3_wizard), "3");
		Assert.assertEquals(getText(tsw.quest_4_wizard), "4");

		// Assert the first question is highlighted on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));

	}

	/*
	 * To Check whether initially saved reviews status are visible on modify
	 * Wizard
	 */
	@Test(priority = 35)
	public void TCSPR1300535() {
		// Assert the first question status is incomplete review
		MouseHover(tsw.quest_1_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("incomplete"));

		// Assert the Second question status is reviewed
		MouseHover(tsw.quest_2_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("complete"));

		waitThread(2000);

		// Click on 4th question on wizard
		click(tsw.quest_4_wizard);
		// Assert the Third question status not reviewed
		MouseHover(tsw.quest_3_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("complete"));

		waitThread(2000);
		// Assertscore box of student1 is empty
		Assert.assertEquals(getValue(prw.score_bx_stud1), "");

		waitThread(1000);
		// Click on 3rd question on wizard
		click(tsw.quest_3_wizard);

		// Assert the fourth question status as not reviewed
		MouseHover(tsw.quest_4_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_4_wizard, "class").contains("visitednotattended"));

	}

	/*
	 * To check Next Question button ,Prev &Next buttons on Wizard
	 */
	@Test(priority = 36)
	public void TCSPR1300536() {

		waitThread(2000);
		// Click on 1st question on wizard
		click(tsw.quest_1_wizard);

		// Assert the first question highlighted
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));

		// Assert the prev button on wizard is disabled
		Assert.assertTrue(getAttribute(an.last_btn, "class").contains("p-disabled"));

		// Assert next Question button enabled
		Assert.assertFalse(getAttribute(ms.next_btn, "class").contains("p-disabled"));

		// Assert tooltip of Next question button
		MouseHover(ms.next_btn);
		Assert.assertEquals(getAttribute(ms.next_btn, "ptooltip"), "Next Question");

		// Assert next button on wizard is enabled
		Assert.assertFalse(getAttribute(an.next_btn, "class").contains("p-disabled"));

		waitThread(2000);
		// Click 2nd question on wizard
		click(tsw.quest_2_wizard);

		// Assert prev , next buttons on wizard enabled
		Assert.assertFalse(getAttribute(an.last_btn, "class").contains("p-disabled"));
		Assert.assertFalse(getAttribute(an.next_btn, "class").contains("p-disabled"));

		// Assert next question button enabled
		Assert.assertFalse(getAttribute(ms.next_btn, "class").contains("p-disabled"));

		waitThread(2000);
		// Click on 4th question on wizard
		click(tsw.quest_4_wizard);

		waitThread(2000);
		// Assert next button on wizard disabled
		Assert.assertTrue(getAttribute(an.next_btn, "class").contains("p-disabled"));

		waitThread(3000);
		// Assert the Next Question button disabled
		Assert.assertTrue(getAttribute(ms.next_btn, "class").contains("disabled-btn"));

		waitThread(2000);
		// Assert prev button on wizard is enabled
		Assert.assertFalse(getAttribute(an.last_btn, "class").contains("p-disabled"));

	}

	/*
	 * To check the Discard changes functionality
	 */
	@Test(priority = 37)
	public void TCSPR1300537() {

		waitThread(2000);
		// Assert discard changes button disabled
		Assert.assertFalse(isEnabled(mrw.discard_changes), "Button not present");

		waitThread(2000);
		// Assert 4th question selected on wizard
		Assert.assertTrue(getAttribute(tsw.quest_4_wizard, "class").contains("p-highlight"));

		waitThread(2000);
		// Click score box of student1
		click(prw.score_bx_stud1);

		// Enter score
		type(prw.score_bx_stud1, "6");

		waitThread(2000);
		// Assert score value displayed on score box
		Assert.assertEquals(getValue(prw.score_bx_stud1), "6");

		waitThread(2000);
		// Assert Discard changes buttonn enabled
		Assert.assertTrue(isEnabled(mrw.discard_changes), "Button not present");

		waitThread(1000);
		// Assert the tooltip od Discard changes button
		MouseHover(mrw.discard_changes);
		Assert.assertEquals(getAttribute(mrw.discard_changes, "ptooltip"), "Discard Changes");

		// Click Discard changes button
		click(mrw.discard_changes);

		waitFor(QP.toaster);
		// Assert toaster "Changes Discarded"
		Assert.assertEquals(getText(QP.toaster), "Changes Discarded");

		click(QP.toasterclosebtn);

		waitThread(2000);
		// Assert discard changes button disabled
		Assert.assertFalse(isEnabled(mrw.discard_changes), "Button not present");

		waitThread(1000);
		// Assert the score box of student2 is empty
		Assert.assertEquals(getValue(prw.score_bx_stud2), "");

	}

	/*
	 * To add scores for skipped reviews
	 */
	@Test(priority = 38)
	public void TCSPR1300538() {

		waitThread(2000);
		// Assert 4th question selected on wizard
		Assert.assertTrue(getAttribute(tsw.quest_4_wizard, "class").contains("p-highlight"));

		waitThread(3000);
		// Click 3rd Question on wizard
		click(tsw.quest_3_wizard);
		waitThread(3000);
		click(tsw.quest_4_wizard);
		// Assert the 3rd question is reviewed on wizard
		MouseHover(tsw.quest_3_wizard);
		
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("complete"));
		
		waitThread(4000);

		// Assert the Third question highlighted on wizard
		Assert.assertTrue(getAttribute(tsw.quest_4_wizard, "class").contains("p-highlight"));

		type(prw.score_bx_stud1, "6");
		waitThread(2000);
		// Assert Submit button
		Assert.assertTrue(isElementPresent(tsw.submit_btn), "Submit button not visible");

	}

	/*
	 * To check the confirmation popup of incomplete review
	 */
	@Test(priority = 39)
	public void TCSPR1300539() {
		waitThread(1000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(2000);
		// Assert confirmationn popup visible
		Assert.assertTrue(isDisplayed(prw.conf_popup), "popup not visible");

		waitThread(1000);
		// Assert the text "You have 1 review(s) as incomplete! Proceed to
		// submit?"
		Assert.assertEquals(getText(prw.conf_txt), "You have 1 review(s) as incomplete! Proceed to submit?");

		waitThread(1000);
		// Click submit button on popup
		click(prw.conf_submit_btn);

		// Assert toaster "Peer Review Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);

		waitThread(1000);
		// Click back to Assessments
		click(prw.backto_btn);

	}

	/*
	 * To perform logout from srudent3 and login to Student2
	 */
	@Test(priority = 40)
	public void TCSPR1300540() {
		
		waitThread(12000);
		// Perform logout from Student3
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// Perform login by Student2
		lg.login("student2@gmail.com", password);

		waitThread(12000);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert Begin review
		Assert.assertTrue(isDisplayed(st1.begintest_btn), "Begin Review not present");

		waitThread(1000);
		// Click Begin review
		click(st1.begintest_btn);

		waitThread(1000);
		// Assert peer review active time status
		Assert.assertTrue(getText(tsw.time_status).contains("Peer Review Active for "));
	}

	/*
	 * To skip all reviews in peer review window &submit reviews
	 */
	@Test(priority = 41)
	public void TCSPR1300541() {
		// Assert first Question is highlighted on Wizard.
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.savenext_btn);

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.savenext_btn);

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.savenext_btn);

		// Assert 1,2,3 questions status as not reviewed
		MouseHover(tsw.quest_1_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("visitednotattended"));

		MouseHover(tsw.quest_2_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("visitednotattended"));

		MouseHover(tsw.quest_3_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("visitednotattended"));

		waitThread(1000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(2000);
		// Assert confirmationn popup visible
		Assert.assertTrue(isDisplayed(prw.conf_popup), "popup not visible");

		waitThread(1000);
		// Assert the text "You have 4 skipped evaluation(s)! Proceed to
		// submit?"
		Assert.assertEquals(getText(prw.conf_txt), "You have 4 skipped evaluation(s)! Proceed to submit?");

		waitThread(1000);
		// Click submit button on popup
		click(prw.conf_submit_btn);

		// Assert toaster "Peer Review Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);
		waitThread(1000);

		// Click back to Assessments
		click(prw.backto_btn);
		waitThread(12000);

	}

	/*
	 * To check the modify review wizard of student 2 & submit the page with
	 * skipped reviews
	 */
	@Test(priority = 42)
	public void TCSPR1300542() {

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		waitThread(1000);

		// Click modify review
		click(st1.begintest_btn);
		waitThread(2000);

		// Assert 4 Questions on wizard
		Assert.assertEquals(getText(tsw.quest_2_wizard), "2");
		waitThread(1000);

		Assert.assertEquals(getText(tsw.quest_3_wizard), "3");
		waitThread(1000);

		Assert.assertEquals(getText(tsw.quest_4_wizard), "4");
		waitThread(1000);

		// Assert the status of all Questions as not reviewed
		MouseHover(tsw.quest_1_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("visitednotattended"));

		MouseHover(tsw.quest_2_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("visitednotattended"));

		MouseHover(tsw.quest_3_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("visitednotattended"));

		MouseHover(tsw.quest_4_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_4_wizard, "class").contains("visitednotattended"));

		waitThread(1000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(2000);
		// Assert confirmationn popup visible
		Assert.assertTrue(isDisplayed(prw.conf_popup), "popup not visible");

		waitThread(1000);
		// Assert the text "You have 4 skipped evaluation(s)! Proceed to
		// submit?"
		Assert.assertEquals(getText(prw.conf_txt), "You have 4 skipped evaluation(s)! Proceed to submit?");

		waitThread(1000);
		// Click submit button on popup
		click(prw.conf_submit_btn);

		// Assert toaster "Peer Review Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);
		waitThread(1000);

		// Click back to Assessments
		click(prw.backto_btn);

		waitThread(12000);
	}

	/*
	 * To perform logout from Student2
	 */
	@Test(priority = 43)
	public void TCSPR1300543() {
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

}
