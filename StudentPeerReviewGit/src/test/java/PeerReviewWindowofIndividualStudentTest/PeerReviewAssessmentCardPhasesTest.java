package PeerReviewWindowofIndividualStudentTest;

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
import TestWindowOfIndividualStudent.TestWindowAssessmentCardPhasesPage;
import TestWindowOfIndividualStudent.TestWindowWizardPage;

public class PeerReviewAssessmentCardPhasesTest extends basePage {
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
	RescheduleDatesPage rd = new RescheduleDatesPage();
	TeacherPeerReviewSectionPage tp = new TeacherPeerReviewSectionPage();
	TeacherTestSectionPage tts = new TeacherTestSectionPage();
	StudentTestSectionPage st1 = new StudentTestSectionPage();
	StudentPeerReviewPage sp1 = new StudentPeerReviewPage();
	TestWindowWizardPage tsw = new TestWindowWizardPage();
	AnswerWindowPage an = new AnswerWindowPage();
	PeerReviewWindowWizardPage prw = new PeerReviewWindowWizardPage();
	ModifySubmittedAnswersPage ma = new ModifySubmittedAnswersPage();
	ModifyReviewWizardPanelPage mrw = new ModifyReviewWizardPanelPage();
	ModifyWizardSectionPage ms = new ModifyWizardSectionPage();
	CommonMethods cm = new CommonMethods();
	StudentCurrentAssessmentBasicsPage sca = new StudentCurrentAssessmentBasicsPage();
	NewAssessmentTeacherBasicsPage natb = new NewAssessmentTeacherBasicsPage();
	TestWindowAssessmentCardPhasesPage ac = new TestWindowAssessmentCardPhasesPage();

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

		waitThread(5000);
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

		waitThread(3000);

		// Type Question 1
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);

		quest1 = "Question1";
		waitThread(1000);
		type(QP.Quest_box, quest1);

		// Assert the question content on the question editor
		Assert.assertEquals(getText(QP.Quest_box), quest1);
		driver.switchTo().defaultContent();

		// Page Scroll down
		QP.Scroll_DowntoEnd();
		waitThread(2000);

		// Click on Add rubric tab
		click(QP.rubric_drp_btn);
		waitThread(3000);

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
		waitThread(3000);

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Type data in Standard Rubric box
		driver.switchTo().frame("rubric_ifr");
		waitThread(2000);
		type(QP.std_rub_bx, "R2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, "6");

		MouseHover(QP.save);
		waitThread(2000);
		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
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

		waitThread(1000);
		// Click add question
		click(rd.add_quest_btn);

		waitThread(2000);

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

		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, "7");

		MouseHover(QP.save);

		waitThread(2000);
		// Click on +button
		click(rd.add_quest_btn);
		waitFor(QP.toaster);

		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 3 Saved successfully");
		click(QP.toasterclosebtn);

		waitThread(2000);
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

		jse2.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, "8");
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

		waitThread(4000);

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Select Answer Sheets Per Student =2
		click(prw.reviewans_sheetdropdwn);
		waitThread(1000);
		click(prw.reviewssheet_count);

		// Enter peer review Reward score 100
		type(prw.peer_reward_scorebx, "100");

		// Assert the text::Total Students : Assert the total student count is 2
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

		waitThread(2000);

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

	}

	/*
	 * To Begin Test &add answers to questions by Student1
	 */
	@Test(priority = 21)
	public void TCSPR1300121() throws InterruptedException {

		// Wait till assessment active
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(50);

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

		type(tsw.answer_bx, "Student_1_Answer1");

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

		type(tsw.answer_bx, "Student_1_Answer2");

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

		type(tsw.answer_bx, "Student_1_Answer3");

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

		type(tsw.answer_bx, "Student_1_Answer4");

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

		waitThread(2000);
		// click back to Assessments
		click(tsw.backtoassess_btn);

		waitThread(9000);
		// Assert the current Assessments
		Assert.assertEquals(getText(prw.current_assess_label), "Current Assessments");

		waitThread(1000);
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

		waitThread(9000);

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
	 * To Add answers to first Question and 2nd Question
	 */
	@Test(priority = 24)
	public void TCSPR1300524() {
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

		// Enter Answer2
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(tsw.answer_bx, "Answer2_Student2");

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

		waitThread(2000);
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

		waitThread(1000);
		// click back to Assessments
		click(tsw.backtoassess_btn);

		waitThread(9000);
		Doubleclick(st1.stud_searchbx);
		waitThread(2000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		waitThread(2000);
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

		waitThread(9000);

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

		type(tsw.answer_bx, "Answer1_Student1");

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
		// Assert Second Question is unanswered
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("visitednotattended"));

		waitThread(2000);
		// Click Save&Nextbutton
		click(QP.Savenext);

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

		waitThread(1000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(2000);

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

		waitThread(2000);
		// click back to Assessments
		click(tsw.backtoassess_btn);

		waitThread(9000);
		Doubleclick(st1.stud_searchbx);
		waitThread(2000);

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
		waitThread(9000);
		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(9000);

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
	 * To begin the Review & check the labels of peer review card section
	 */
	@Test(priority = 29)
	public void TCSPR1300729() throws InterruptedException {

		waitThread(1000);
		lg.login("student3@gmail.com", password);

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

		// Assert peer review % =0%
		Assert.assertEquals(getText(sp1.zeropercent_card), "0%");

		waitThread(2000);
		// Assert the Assessment name
		// Assert.assertEquals(getText(tp.newasses_lbl), AssessmentName);

		waitThread(4000);
		// Assert 'Peer Reviews Completed' label
		Assert.assertEquals(getText(tp.peercompl_lbl), "Peer Reviews Completed");

		waitThread(4000);
		// Assert the time status on card "Peer Review active for "
		// Assert.assertTrue(getText(tsw.time_card).contains("Peer Review Active
		// for".trim()));

		waitThread(2000);
		// Click Begin Review
		click(st1.begintest_btn);

		waitThread(2000);
		// Assert the coursename, id, Teacher name on the review window
		Assert.assertTrue(getText(tsw.course_name_id).contains(CourseName));
		Assert.assertTrue(getText(tsw.course_name_id).contains(CourseID));

		Assert.assertTrue(getText(tsw.teach_name_testwindow).contains(Teachername));

	}

	/*
	 * To begin the review and add incomplete and complete review
	 */
	@Test(priority = 30)
	public void TCSPR1300730() {

		waitThread(3000);
		// Click score box of student1
		click(prw.score_bx_stud1);

		// Enter score
		type(prw.score_bx_stud1, "2");

		waitThread(1000);
		// Assert the time status on review window
		Assert.assertTrue(getText(tsw.time_status).contains("Peer Review Active for "));

		waitThread(1000);
		// Assert first question selected on wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));
		Assert.assertEquals(getText(tsw.quest_1_wizard), "1");

		waitThread(2000);
		// Click Save &Next button
		click(QP.savenext_btn);

		waitThread(2000);
		// Assert the first question is incomplete review
		MouseHover(tsw.quest_1_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("incomplete"));
		waitThread(1000);
		// Click score box of student1
				click(prw.score_bx_stud1);

				// Enter score
				type(prw.score_bx_stud1, "2");

				waitThread(1000);

		// Click score box of student1
		click(prw.score_bx_stud2);

		// Enter score
		type(prw.score_bx_stud2, "2");
		// Click Save&Nextbutton
		click(QP.savenext_btn);

		waitThread(1000);
		MouseHover(tsw.quest_2_wizard);
		// Assert the Second question wizard is Reviewed
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("complete"));

		waitThread(1000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(1000);
		// Assert the text "There are incomplete evaluation/skipped evaluation,
		// do you
		// want to proceed ?"
		waitThread(1000);
		Assert.assertEquals(getText(prw.conf_txt),
				"There are incomplete evaluation/skipped evaluation, do you want to proceed ?");

	}

	/*
	 * To check the card status when the Reviews kept in draft &Perform logout
	 * from student3
	 */
	@Test(priority = 31)
	public void TCSPR1300731() {

		// Click Cancel button
		waitThread(1000);
		click(prw.conf_cancel_btn);

		waitThread(1000);
		// Assert save&exit button
		Assert.assertTrue(isDisplayed(QP.savexit_btn), "Save&Exit button not present");
		Assert.assertEquals(getText(QP.savexit_btn), "Save & Exit");

		waitThread(2000);
		// Click Save&Exit button
		click(QP.savexit_btn);

		waitThread(15000);
		Doubleclick(st1.stud_searchbx);
		waitThread(3000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Assert the Resume Review on Assessment card
		Assert.assertTrue(isDisplayed(st1.begintest_btn), "Resume Review not present");
		Assert.assertEquals(getText(st1.begintest_btn), "Resume Review");

		waitThread(1000);
		// Assert the Peer reviews completed % as 50%
		Assert.assertEquals(getText(sp1.zeropercent_card), "50%");

		// Assert the Peer review status "Active"
		Assert.assertEquals(getText(tp.peersts_lbl), "Active");

		// Perform logout by Student3

		rs.Logout();

		// Assert heading login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check whether the incomplete status percentage visible on the teacher
	 * Assessment card when Student kept Reviews in draft Reviews
	 */
	@Test(priority = 32)
	public void TCSPR1300732() {

		// Perform login by Teacher
		lg.login("teacherOne@gmail.com", password);

		waitThread(2000);
		// Click Assessment tab
		click(QP.teach_assesstab);

		waitThread(9000);
		// search assessment
		click(tp.search_box);
		type(tp.search_box, AssessmentName + " ");
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(tp.newcard), "Published Assessment card not visible");

		// Assert the Peer review completed percentage on card as 0%
		Assert.assertEquals(getText(ac.teach_review_percent), "0%");

		// Perform Teacher logout functionality
		rs.Logout();

		// Assert heading login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check whether the incomplete review percentage visible on the
	 * Assessment card when submit the Reviews
	 */
	@Test(priority = 33)
	public void TCSPR1300733() {
		// Perform login by Student3
		lg.login("student3@gmail.com", password);

		waitThread(9000);

		Doubleclick(st1.stud_searchbx);
		waitThread(2000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Click Resume review
		click(st1.begintest_btn);

		waitThread(4000);

		// Click Third question on Wizard
		click(tsw.quest_3_wizard);
		waitThread(1000);

		// Enter score for student2
		click(prw.score_bx_stud2);
		type(prw.score_bx_stud2, "3");

		waitThread(1000);
		// Assert the submit button
		Assert.assertTrue(isElementPresent(tsw.submit_btn), "Submit button not visible");

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
	 * To check Review percentage on assessment card when give submit
	 */
	@Test(priority = 34)
	public void TCSPR1300734() {
		waitThread(9000);
		Doubleclick(st1.stud_searchbx);
		waitThread(3000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the Modify Review
		Assert.assertTrue(isDisplayed(st1.begintest_btn), "Modify Review not present");
		Assert.assertEquals(getText(st1.begintest_btn), "Modify Review");

		// Assert the Peer review status "Submitted"
		Assert.assertEquals(getText(tp.peersts_lbl), "Submitted");

		// Assert peer review percentage as 67%
		Assert.assertEquals(getText(sp1.zeropercent_card), "67%");

		waitThread(2000);
		// Click Modify Review
		click(st1.begintest_btn);

		waitThread(2000);
		// Assert the first Question on wizard selected
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));
		Assert.assertEquals(getText(tsw.quest_1_wizard), "1");

		waitThread(2000);
		// Assert the first question is incomplete review
		MouseHover(tsw.quest_1_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("incomplete"));

	}

	/*
	 * To modify Submitted reviews
	 */
	@Test(priority = 35)
	public void TCSPR1300735() {

		waitThread(1000);
		// Enter score for student2
		click(prw.score_bx_stud2);
		type(prw.score_bx_stud2, "3");

		// click commenmt box
		click(prw.comment_bx_stud2);

		waitThread(1000);
		click(prw.txtbx_comment);

		// Enter comment for Student2
		type(prw.txtbx_comment, "Comments");

		// Click tick button
		click(prw.commentsave_btn);
		waitThread(1000);

		// Assert added comment on comment box
		Assert.assertEquals(getValue(prw.comment_bx_stud2), "Comments");

		waitThread(1000);
		// Click next question
		click(ms.next_btn);

		// Assert toaster "Score Saved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Score Saved");

		click(QP.toasterclosebtn);

		waitThread(2000);
		// Assert the first question as Reviewed
		MouseHover(tsw.quest_1_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("complete"));

		waitThread(1000);
		// Assert the added scores for Answer2 visible on score boxes
		Assert.assertEquals(getValue(prw.score_bx_stud1), "2");
		Assert.assertEquals(getValue(prw.score_bx_stud2), "2");

		waitThread(1000);
		// Click next question
		click(ms.next_btn);
		waitThread(1000);

		// Assert the second question status as reviewed
		MouseHover(tsw.quest_2_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("complete"));

		waitThread(1000);
		// Assert the added score for Answer3 visible on score box
		Assert.assertEquals(getValue(prw.score_bx_stud2), "3");

		// Click 4th question on wizard
		waitThread(1000);
		click(tsw.quest_4_wizard);
		waitThread(1000);

		// Click 3rd question on wizard
		click(tsw.quest_3_wizard);
		waitThread(3000);

		// Assert 4th question status as not reviewed
		MouseHover(tsw.quest_4_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_4_wizard, "class").contains("visitednotattended"));

	}

	/*
	 * To check whether the modified reviews percentage visible on the card
	 */
	@Test(priority = 36)
	public void TCSPR1300736() {

		waitThread(1000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(2000);
		// Assert confirmationn popup visible
		Assert.assertTrue(isDisplayed(prw.conf_popup), "popup not visible");

		waitThread(1000);
		// Assert the text "You have 1 skipped evaluation(s)! Proceed to
		// submit?"
		Assert.assertEquals(getText(prw.conf_txt), "You have 1 skipped evaluation(s)! Proceed to submit?");

		waitThread(1000);
		// Click submit button on popup
		click(prw.conf_submit_btn);

		// Assert toaster "Peer Review Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);

		waitThread(2000);

		// Click back to Assessments
		click(prw.backto_btn);

		waitThread(12000);
		Doubleclick(st1.stud_searchbx);
		waitThread(2000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(5000);

		// Assert the Modify Review button
		// Assert.assertTrue(isDisplayed(st1.begintest_btn), "Modify Review not
		// present");
		Assert.assertEquals(getText(st1.begintest_btn), "Modify Review");

		waitThread(2000);
		// Assert the peer review completed percentage as 83%
		Assert.assertEquals(getText(sp1.zeropercent_card), "83%");

		// Assert the status peer review submitted
		Assert.assertEquals(getText(tp.peersts_lbl), "Submitted");

	}

	/*
	 * To check the Discard button functions and review percentage on card
	 */
	@Test(priority = 37)
	public void TCSPR1300737() {

		waitThread(3000);
		// Click Modify Review button
		click(st1.begintest_btn);

		waitThread(1000);
		// Assert the first question is highlighted on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));

		waitThread(3000);
		// Assert first question status as Reviewed
		MouseHover(tsw.quest_1_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("complete"));

		waitThread(1000);
		// Assert second &Third question status as Reviewed
		MouseHover(tsw.quest_2_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("complete"));

		waitThread(1000);
		MouseHover(tsw.quest_3_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("complete"));

		waitThread(2000);
		// Click question4 on Wizard
		click(tsw.quest_4_wizard);

		waitThread(3000);
		click(tsw.quest_3_wizard);

		waitThread(2000);
		// Assert forth question status as Not Reviewed
		MouseHover(tsw.quest_4_wizard);
		Assert.assertTrue(getAttribute(tsw.quest_4_wizard, "class").contains("visitednotattended"));

		waitThread(1000);
		// Click question4 on Wizard
		click(tsw.quest_4_wizard);

		waitThread(1000);
		// Open Answerbox of Student2
		//click(prw.student2_label);
		
		// Enter score for student2
				click(prw.score_bx_stud2);
				type(prw.score_bx_stud2, "4");

				// click commenmt box
				click(prw.comment_bx_stud2);

				waitThread(1000);
				click(prw.txtbx_comment);

				// Enter comment for Student2
				type(prw.txtbx_comment, "Comments");

				// Click tick button
				click(prw.commentsave_btn);
				waitThread(1000);

				// Assert added comment on comment box
				Assert.assertEquals(getValue(prw.comment_bx_stud2), "Comments");

				waitThread(1000);


		// Click scores on clickable rubric
		waitThread(2000);

//		click(mrw.click_row11);
//		click(mrw.click_row22);
//		click(mrw.click_row33);
//
//		waitThread(2000);
//		// Assert score visible on Score box
		Assert.assertEquals(getValue(prw.score_bx_stud2), "4");

		// Assert the answer box of student1 is disabled
		Assert.assertTrue(getAttribute(prw.studentone_part, "class").contains("p-disabled"));

		waitThread(1000);
		// Click 3rd question on wizard
		click(tsw.quest_3_wizard);

		// Assert toaster "Score Saved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Score Saved");

		click(QP.toasterclosebtn);

		waitThread(2000);
		// Assert Discard button
		Assert.assertTrue(isElementPresent(ms.discard_btn), "Discard button not present");
		Assert.assertEquals(getText(ms.discard_btn), "Discard");

	}

	/*
	 * To do Discard functionality and to check the assessment card
	 */
	@Test(priority = 38)
	public void TCSPR1300738() {

		waitThread(1000);
		// Click Discard button
		click(ms.discard_btn);

		waitThread(2000);
		// Assert confirmationn popup visible
		Assert.assertTrue(isDisplayed(prw.conf_popup), "popup not visible");

		// Assert text "Do you want to discard the changes made and exit the
		// review
		// window?"
		Assert.assertEquals(getText(prw.conf_txt),
				"Do you want to discard the changes made and exit the review window?");

		waitThread(1000);
		// Assert Cancel & Yes button
		Assert.assertTrue(isDisplayed(prw.conf_cancel_btn), "Cancel button not present");
		Assert.assertEquals(getText(prw.conf_cancel_btn), "Cancel");

		Assert.assertTrue(isDisplayed(prw.conf_submit_btn), "Yes button not present");
		Assert.assertEquals(getText(prw.conf_submit_btn), "Yes");

		waitThread(2000);
		// Click Cancel button
		click(prw.conf_cancel_btn);

		waitThread(3000);
		// Assert no popup visible
		Assert.assertFalse(isElementPresent(prw.conf_popup), "popup visible");

		waitThread(4000);
		// Click Discard button
		click(ms.discard_btn);

		waitThread(5000);
		// Assert confirmation popup visible
		Assert.assertTrue(isDisplayed(prw.conf_popup), "popup not visible");

		waitThread(1000);
		// Click Yes button
		click(prw.conf_submit_btn);

		// Assert toaster "Review Discarded"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Review Discarded");

		click(QP.toasterclosebtn);

		waitThread(5000);

		// Assert Current Assessements label
		Assert.assertTrue(isElementPresent(prw.current_assess_label), "Current Assessment label not visible");

		waitThread(4000);
		Doubleclick(st1.stud_searchbx);
		waitThread(2000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the peer review completed percentage as 83%
		Assert.assertEquals(getText(sp1.zeropercent_card), "83%");
	}

	/*
	 * To check whether added datas are discarded from the review window
	 */
	@Test(priority = 39)
	public void TCSPR1300739() {

		waitThread(2000);
		// Click Modify Review
		click(st1.begintest_btn);

		waitThread(2000);
		// Assert first Question is highlighted on Wizard.
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));

		waitThread(1000);
		// Assert first question status as Reviewed
		MouseHover(tsw.quest_1_wizard);
		waitThread(1000);
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("complete"));

		// Assert Second question status as Reviewed
		MouseHover(tsw.quest_2_wizard);
		waitThread(1000);
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("complete"));

		// Assert Third question status as Reviewed
		MouseHover(tsw.quest_3_wizard);
		waitThread(1000);
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("complete"));

		// Click 4th question on wizard
		click(tsw.quest_4_wizard);
		waitThread(2000);
		// Assert forth question status as NotReviewed
		MouseHover(tsw.quest_4_wizard);
		waitThread(1000);
		Assert.assertTrue(getAttribute(tsw.quest_4_wizard, "class").contains("visitednotattended"));

		// Assert the score box of Student 2 is empty
		Assert.assertEquals(getValue(prw.score_bx_stud2), "");

		waitThread(2000);
		// Assert the Student 1 part is disabled
		Assert.assertTrue(getAttribute(prw.studentone_part, "class").contains("p-disabled"));

		waitThread(1000);
		// Assert disclaimer text at student 1 part
		Assert.assertEquals(getText(prw.stud1_disclaimer_txt),
				"Disclaimer: Student One did not answer this question so no peer review is necessary for this student, and your peer review points will not be affected.");
	}

	/*
	 * To complete the reviews and check the assessment card
	 */
	@Test(priority = 40)
	public void TCSPR1300740() {

		waitThread(2000);
		// Assert forth question highlighted on wizard
		Assert.assertTrue(getAttribute(tsw.quest_4_wizard, "class").contains("p-highlight"));

		waitThread(1000);
		// Open Answerbox of Student2
		//click(prw.student2_label);
		// Enter score for student2
		click(prw.score_bx_stud2);
		type(prw.score_bx_stud2, "4");

		// click commenmt box
		click(prw.comment_bx_stud2);

		waitThread(1000);
		click(prw.txtbx_comment);

		// Enter comment for Student2
		type(prw.txtbx_comment, "Comments");

		// Click tick button
		click(prw.commentsave_btn);
		waitThread(1000);

		// Assert added comment on comment box
		Assert.assertEquals(getValue(prw.comment_bx_stud2), "Comments");

		waitThread(1000);

		// Click scores on clickable rubric
		//waitThread(2000);

		//click(mrw.click_row11);
		//click(mrw.click_row22);
		//click(mrw.click_row33);

		waitThread(1000);
		// Assert score visible on Score box
		Assert.assertEquals(getValue(prw.score_bx_stud2), "4");

		waitThread(1000);
		// Click submit button
		click(tsw.submit_btn);

		waitThread(2000);
		// Assert confirmationn popup visible
		Assert.assertTrue(isDisplayed(prw.conf_popup), "popup not visible");

		waitThread(1000);
		// Assert the text "Are you sure you want to submit the review?"
		Assert.assertEquals(getText(prw.conf_txt), "Are you sure you want to submit the review?");

		waitThread(1000);
		// Click submit button on popup
		click(prw.conf_submit_btn);

		// Assert toaster "Peer Review Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);
		waitThread(5000);

		// Click back to Assessments
		click(prw.backto_btn);

		waitThread(9000);
		Doubleclick(st1.stud_searchbx);
		waitThread(2000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the Modify Review button
		Assert.assertTrue(isDisplayed(st1.begintest_btn), "Modify Review Review not present");
		waitThread(2000);

		// Assert the peer review completed percentage as 100%
		Assert.assertEquals(getText(sp1.zeropercent_card), "100%");

		// Assert the status peer review submitted
		Assert.assertEquals(getText(tp.peersts_lbl), "Submitted");

	}

	/*
	 * To Perform Logout from Student3 and Login to Teacher account and Check
	 * Assessment card
	 */
	@Test(priority = 41)
	public void TCSPR1300741() {

		// Perform logout from Student3
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// Perform login by Teacher
		lg.login("teacherOne@gmail.com", password);

		waitThread(2000);
		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		waitThread(1000);
		// Click Assessment tab
		click(ba.Assessmenttab);

		waitThread(12000);
		// search assessment
		click(tp.search_box);
		type(tp.search_box, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(tp.newcard), "Published Assessment card not visible");

		waitThread(1000);
		// Assert peer review completed % as 33%
		Assert.assertEquals(getText(ac.teach_review_percent), "33%");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 42)
	public void TCSPR1300742() {
		// Perform Teacher logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

}
