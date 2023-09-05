package CreateNewAssessment.Test;

import java.awt.event.KeyEvent;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import Course.Pages.EditCoursePage;
import Course.Test.CreateNewCourseTest;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.BasicDetailsPageCourseandEditorPage;
import CreateNewAssessment.Pages.ClickableRubricPage;
import CreateNewAssessment.Pages.MultipleQuestionsAddPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionEditorAndMultipleCategoryAddPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CreateNewAssessment.Pages.SummaryQuestionClickableRubircPage;
import CreateNewAssessment.Pages.SummaryQuestionsPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class SummaryQuestionClickableRubircTest extends basePage {

	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	CreateNewCourseTest cnt = new CreateNewCourseTest();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	EditCoursePage ec = new EditCoursePage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	CourseRosterPage cr = new CourseRosterPage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	EncryptedText et = new EncryptedText();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	SchedulePageBasicsPage sb = new SchedulePageBasicsPage();
	ClickableRubricPage ck = new ClickableRubricPage();
	MultipleQuestionsAddPage mq = new MultipleQuestionsAddPage();
	SummaryQuestionsPage sq = new SummaryQuestionsPage();
	BasicDetailsAssessmentTest bdastt = new BasicDetailsAssessmentTest();
	SummaryBasicsPage sbt = new SummaryBasicsPage();
	BasicDetailsPageCourseandEditorPage be = new BasicDetailsPageCourseandEditorPage();
	QuestionEditorAndMultipleCategoryAddPage QE = new QuestionEditorAndMultipleCategoryAddPage();
	SummaryQuestionClickableRubircPage sqcr = new SummaryQuestionClickableRubircPage();

	public String Emailteacher;
	public String CourseName;
	public String CourseNamenew;
	public String NewCourseTitle;
	public String CourseID;
	public String AssessmentName;
	public String NewAssessmentName;
	public String NewCourseName;
	public String CourseID1;
	public String Emailstudent1;
	public String Emailstudent2;

	public String Studentfirstname;
	public String Studentlastname;
	public String Studentname;
	public String Studentfirstname2;
	public String Studentlastname2;
	public String Studentname2;

	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	/*
	 * To perform Sign Up functionality
	 */
	@Test(priority = 0)
	public void TCSPR0901701() {

		// To click on I am A teacher button
		click(sp.btn_1);

		// To fill the details on the sign up page
		Emailteacher = st.TCSPR020005();

	}

	@Test(priority = 1)
	public void OtpFetch() throws SQLException {

		// To catch OTP from sending Resource
		st.TCSPR020006();

	}

	/*
	 * To create new course
	 */
	@Test(priority = 2)
	public void TCSPR0901702() throws SQLException {

		CourseName = "Course Name" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID = (getText(cn.course_Id));

		// type-Course title
		type(cn.txbx_Coursetitle, CourseName);

		// click on Add students button
		click(cn.btn_AddStudents);

		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";

		// type email
		type(cn.tab_textbox, Emailstudent1 + ",");
		driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
		type(cn.tab_textbox, Emailstudent2 + ",");

		// verify email present on the text box
		Assert.assertEquals(cn.emailvalue(0), Emailstudent1);

		Assert.assertEquals(cn.emailvalue(1), Emailstudent2);

		// click on add to list button
		click(cn.tab_btn_Addtolist);

		waitThread(2000);
		waitFor(cr.emailval_1);

		// verify the Email on the New Students to be invited to this class box
		Assert.assertEquals(getText(cr.emailval_1), Emailstudent1);
		Assert.assertEquals(getText(ps.emailval_2), Emailstudent2);

		// click on create course button
		click(cn.btn_Createcourse);

		waitThread(1000);
		waitFor(cn.toaster);

		// verify toaster-Course created successfully
		Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");

		waitThread(3000);

		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), CourseName.trim());

	}
	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 3)
	public void TCSPR0901703() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on first student 's profile and
	 * accept course request-Read the student name
	 */
	@Test(priority = 4)
	public void TCSPR0901704() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent1, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname = "Ashley";
		Studentlastname = "Albert";
		Studentname = Studentfirstname + " " + Studentlastname;

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
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());

	}
	/*
	 * To Accept course and perform logout functionality on the student profile
	 */

	@Test(priority = 5)
	public void TCSPR0901705() {

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
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * To check that invited course request visible on first student 's profile and
	 * accept course request-Read the student name
	 */
	@Test(priority = 6)
	public void TCSPR0901706() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent2, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname2 = "Ben";
		Studentlastname2 = "Max";
		Studentname2 = Studentfirstname2 + " " + Studentlastname2;

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
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());

	}
	/*
	 * To Accept course and perform logout functionality on the student profile
	 */

	@Test(priority = 7)
	public void TCSPR0901707() {

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
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */
	@Test(priority = 8)
	public void TCSPR0901708() {
		SoftAssert softAssert1 = new SoftAssert();
		rs.login_Teacher(Emailteacher, password);

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

		waitThread(1000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(1000);

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
	 * 
	 */
	@Test(priority = 9)
	public void TCSPR0901709() {

		waitThread(3000);
		SoftAssert softAssert9 = new SoftAssert();

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

		// Assert the Label Add Rubric
		Assert.assertEquals(getText(QP.Add_rublabel), "Add Rubric");

		// Click rubric dropdown
		click(QP.rubric_drp_btn);
		waitThread(3000);

		// Add Column
		click(QP.add_column);

		// Enter Criteria
		type(ck.crit1_bx, "CR1");

		// Enter score for column1
		type(ck.scre_col1, "2");

		waitThread(2000);
		// Enter condition
		driver.switchTo().frame("editorFieldRubric_00_ifr");
		waitThread(2000);
		type(ck.enter_con, "Good");
		driver.switchTo().defaultContent();

		// page scroll up
		ck.scrolup();

		waitThread(7000);
		click(QP.save);

		waitFor(QP.toaster);
		// Assert the toaster "Question1 Saved successfully"
		softAssert9.assertEquals(getText(QP.toaster), "Question 1 Saved successfully", "Assertion failed");
		click(QP.toasterclosebtn);
		softAssert9.assertAll();
	}

	/*
	 * To add more questions with standard and clickable rubrics
	 */
	@Test(priority = 10)
	public void TCSPR0901710() {
		SoftAssert softAssert10 = new SoftAssert();
		// Click + button
		click(mq.add_quest_btn);

		waitThread(4000);
		// Assert the label "2.Questions"
		Assert.assertEquals(getText(QP.question1), "2." + "\nQuestion");

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question2");

		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);

		// Assert the Label Add Rubric
		Assert.assertEquals(getText(QP.Add_rublabel), "Add Rubric");

		// Add Column
		click(QP.add_column);

		// Enter Criteria
		type(ck.crit1_bx, "CR1");

		// Enter score for column1
		type(ck.scre_col1, "4");

		waitThread(2000);
		// Enter condition
		driver.switchTo().frame("editorFieldRubric_00_ifr");
		waitThread(2000);
		type(ck.enter_con, "Good");
		driver.switchTo().defaultContent();

		// page scroll up
		ck.scrolup();

		waitThread(7000);
		// Click + button
		click(mq.add_quest_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Question 2 Saved successfully"
		softAssert10.assertEquals(getText(QP.toaster), "Question 2 Saved successfully", "Assertion failed");
		click(QP.toasterclosebtn);

		waitThread(4000);
		// Assert the label "3.Questions"
		Assert.assertEquals(getText(QP.question1), "3." + "\nQuestion");

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		waitThread(2000);
		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question3");

		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "10");

		waitThread(5000);
		click(QP.save);

		softAssert10.assertAll();
	}

	/*
	 * 
	 * To perform Save&Next and to verify the details on the peer review page
	 */
	@Test(priority = 11)
	public void TCSPR0901711() {
		waitThread(4000);
		// Assert the Max score possible
		Assert.assertEquals(getText(QP.max_scoreposs_value), "16");

		// Assert the Max score field
		Assert.assertEquals(getValue(QP.max_scorbx), "10");

		waitThread(4000);
		// Click Save &Next button
		click(QP.savenext_btn);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}
	/*
	 * To verify the details on the peer review page
	 * 
	 */

	@Test(priority = 12)
	public void TCSPR0901712() {

		waitThread(5000);
		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");

		waitThread(1000);
		click(pr.PRreward_txtbox);

		// Enter peer review Reward score 100
		type(pr.PRreward_txtbox, "100");

		// Assert the first student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Studentname);

		// Assert the second student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Studentname2);

	}

	/*
	 * To perform the save and next functionaity from peer review page and verify
	 * the schedule page details
	 */
	@Test(priority = 13)
	public void TCSPR0901713() {
		SoftAssert softAssert3 = new SoftAssert();
		waitThread(5000);
		// Click Save &Next button
		click(pr.savennext_button);
		
				waitFor(QP.toaster);
				// Assert the toaster "Saved successfully"
				Assert.assertEquals(getText(QP.toaster), "Saved successfully");

				click(QP.toasterclosebtn);

				waitThread(3000);

		// Assert the schedule wizard is selected
		softAssert3.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true", "Assertion  failed");

		// Assert Course name and course code
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseName.trim()));
		softAssert3.assertAll();
	}

	/*
	 * To Perform Save&Next and to verify the details on the Summary page
	 */
	@Test(priority = 14)
	public void TCSPR0901714() {

		waitThread(3000);
		// Assert the Mail notification checkbox is checked
		Assert.assertTrue(isDisplayed(sq.mailcheckbox_tick), "Checkbox is not checked");

		MouseHover(pr.savennext_button);
		waitThread(6000);
		// Click Save &Next button
		click(pr.savennext_button);
		
		waitThread(6000);
		// Assert the Summary wizard is selected
		Assert.assertEquals(getAttribute(sq.summary_wizard_high, "aria-selected"), "true");

		// Assert the label assessment name,
		Assert.assertTrue(getText(sbt.summaryassessmentname).contains("Assessment Name: " + AssessmentName));

		// Assert the text "Questions Summary "
		Assert.assertEquals(getText(sq.Summary_quest), "Questions Summary");

		// Assert the Total no: of Questions
		Assert.assertEquals(getText(sq.total_questcount), "3");

		// Assert the Total test points 
		Assert.assertEquals(getText(sq.total_testscore), "16");

		// Assert the Questions visible on the page is same as Questions added on page
		Assert.assertEquals(getText(sq.quest1), "Question1");
		Assert.assertEquals(getText(sq.quest2), "Question2");
		Assert.assertEquals(getText(sq.quest3), "Question3");

		waitThread(3000);
		// Assert the marks in Question page is same as questions page
		Assert.assertEquals(getValue(sq.markquest1), "2");
		Assert.assertEquals(getValue(sq.markquest2), "4");
		Assert.assertEquals(getValue(sq.markquest3), "10");

		// Assert the Grand total is same as total test points
		Assert.assertEquals(getValue(sq.grandtotal_count), "16");
		Assert.assertEquals(getText(sq.total_testscore), "16");
	}
	/*
	 * To perform the edit functionality on clickable rubrics & to check the max
	 * score updations
	 */

	@Test(priority = 15)
	public void TCSPR0901715() {
		SoftAssert softAssert15 = new SoftAssert();
		// Assert the tooltip of edit button visible
		Assert.assertEquals(getAttribute(sq.edit_quest1, "ptooltip"), "Edit");

		waitThread(2000);
		// click Edit button of first question
		click(sq.edit_quest1);
		waitThread(2000);
		// Assert the text "Edit Question"
		softAssert15.assertEquals(getText(sq.editquest_label), "Edit Question", "Assertion failed");

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);

		// Assert the clickable rubric radio button is checked
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		// Assert the Max score field as "2"
		Assert.assertEquals(getText(sqcr.max_score_click), "2");

		// Update a new score to Score for column1
		driver.findElement(By.xpath("//input[@id='scoreField_00']")).sendKeys(Keys.BACK_SPACE);
		type(ck.scre_col1, "3");

		waitThread(2000);
		// Assert the Max score field as "3"
		Assert.assertEquals(getText(sqcr.max_score_click), "3");

		// Edit criteria field
		driver.findElement(By.xpath("//div[@id='rubricMain']//tr[1]//textarea[@id='criteriaInput']")).clear();
		type(ck.crit1_bx, "Criteria1");

		// Assert save button on edit popup
		Assert.assertTrue(isElementPresent(sq.save_btn_editpop), "Save button is not present");

		waitThread(4000);
		// click save button
		click(sq.save_btn_editpop);

		waitFor(QP.toaster);
		// Assert the toaster "Question updated successfully"
		softAssert15.assertEquals(getText(QP.toaster), "Question updated successfully", "Assertion failed");
		click(QP.toasterclosebtn);

		waitThread(5000);
		// Assert the score box of question 1 as "3"
		Assert.assertEquals(getValue(sq.markquest1), "3");

		// Assert the grand total & Total Test points are same
		Assert.assertEquals(getValue(sq.grandtotal_count), "17");
		Assert.assertEquals(getText(sq.total_testscore), "17");

		softAssert15.assertAll();
	}

	/*
	 * To check max score updation of clickable rubric by adding more rows & columns
	 * 
	 */
	@Test(priority = 16)
	public void TCSPR0901716() {
		SoftAssert softAssert16 = new SoftAssert();
		waitThread(2000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Assert the text "Questions Summary "
		softAssert16.assertEquals(getText(sq.Summary_quest), "Questions Summary", "Assertion failed");

		waitThread(4000);
		// click Edit button of Second question
		Doubleclick(sq.edit_quest2);
		waitThread(2000);
		// Assert the text "Edit Question"
		softAssert16.assertEquals(getText(sq.editquest_label), "Edit Question", "Assertion failed");
		waitThread(2000);
		// Page scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		waitThread(6000);

		// Assert the clickable rubric radio button is checked
		softAssert16.assertTrue(isEnabled(QP.click_radio), "Radio button is not checked");
		waitThread(5000);
		// Assert the criteria field
		softAssert16.assertEquals(getValue(ck.crit1_bx), "CR1");

		waitThread(2000);
		// Click on Add column button
		click(QP.add_column);

		waitThread(2000);
		// Enter score for column 2
		type(ck.scre_col2, "2");

		// Enter Condition for column2
		driver.switchTo().frame("editorFieldRubric_01_ifr");
		type(ck.enter_con, "Average");
		driver.switchTo().defaultContent();

		// *Assert the Max score is "4
		Assert.assertEquals(getText(sqcr.max_score_click), "4");

		// Click Add Row button
		waitThread(1000);
		click(QP.add_row);

		// Enter criteria 2
		type(ck.crit2_bx, "CR2");

		waitThread(2000);
		// Enter score of column1 &2 of second row
		click(ck.scrore_r21);
		driver.findElement(By.xpath("//input[@id='scoreField_10']")).clear();
		type(ck.scrore_r21, "2");

		click(ck.score_r22);
		driver.findElement(By.xpath("//input[@id='scoreField_11']")).clear();
		type(ck.score_r22, "1");

		// Enter Conditions for Row 2

		driver.switchTo().frame("editorFieldRubric_10_ifr");
		type(ck.enter_con, "Good");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("editorFieldRubric_11_ifr");
		type(ck.enter_con, "Average");
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Assert the Max score is "6"
		Assert.assertEquals(getText(sqcr.max_score_click), "6");

		waitThread(4000);
		// click save button
		click(sq.save_btn_editpop);

		waitFor(QP.toaster);
		// Assert the toaster "Question updated successfully"
		softAssert16.assertEquals(getText(QP.toaster), "Question updated successfully", "Assertion failed");
		click(QP.toasterclosebtn);

		waitThread(7000);
		// Assert the score box of question 2 as "6"
		Assert.assertEquals(getValue(sq.markquest2), "6");

		// Assert the grand total & Total test points same
		Assert.assertEquals(getValue(sq.grandtotal_count), "19");
		Assert.assertEquals(getText(sq.total_testscore), "19");

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		waitThread(4000);
		// click Edit button of Second question
		click(sq.edit_quest2);
		waitThread(2000);

		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		waitThread(4000);

		// Assert the clickable rubric radio button is checked
		softAssert16.assertTrue(isEnabled(QP.click_radio), "Radio button is not checked");

		waitThread(7000);
		// Assert the edited datas are visible on the edit question popup

		Assert.assertEquals(getText(sqcr.max_score_click), "6");
		Assert.assertEquals(getValue(ck.scrore_r21), "2");
		Assert.assertEquals(getValue(ck.score_r22), "1");

		softAssert16.assertAll();
	}

	/*
	 * To check the whether the validation message display if the clickable rubric
	 * is empty & also to check the max score updation if the rubric is empty
	 */
	@Test(priority = 17)
	public void TCSPR0901717() {
		SoftAssert softAssert17 = new SoftAssert();
		// Assert the Remove last column button
		Assert.assertTrue(isElementPresent(QP.remov_lastcolum), "Remove last column button not present");

		// Assert Remove last Row button
		Assert.assertTrue(isElementPresent(QP.remov_lastrw), "Remove last row button not present");

		waitThread(2000);
		// click on Remove column button
		click(QP.remov_lastcolum);

		waitThread(5000);
		// Assert the Confirmation popup visible
		Assert.assertTrue(isDisplayed(sqcr.remove_col_confir), "Confirmation popup not displayed");

		waitThread(2000);
		// Click Yes button
		click(sqcr.confirm_yes_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Removed successfully"
		softAssert17.assertEquals(getText(QP.toaster), "Removed successfully", "Assertion failed");
		click(QP.toasterclosebtn);

		// Assert the max score as 6
		waitThread(2000);
		Assert.assertEquals(getText(sqcr.max_score_click), "6");

		waitThread(2000);
		// click on Remove Row button
		click(QP.remov_lastrw);

		waitThread(2000);
		// Assert the Confirmation popup visible
		Assert.assertTrue(isDisplayed(sqcr.remove_col_confir), "Confirmation popup not displayed");

		waitThread(2000);
		// Click Yes button
		click(sqcr.confirm_yes_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Removed successfully"
		softAssert17.assertEquals(getText(QP.toaster), "Removed successfully", "Assertion failed");
		click(QP.toasterclosebtn);

		// Assert the max score as 4
		waitThread(4000);
		Assert.assertEquals(getText(sqcr.max_score_click), "4");

		waitThread(2000);
		// click on Remove Row button
		click(QP.remov_lastrw);

		waitThread(2000);
		// Click Yes button
		click(sqcr.confirm_yes_btn);

		// Assert the max score as 0
		waitThread(2000);
		Assert.assertEquals(getText(sqcr.max_score_click), "0");

		waitThread(2000);
		// Assert the text "No Rubric Created "
		softAssert17.assertEquals(getText(QP.click_rubric_holder), "No Rubric Created !", "Assertion failed");
		waitThread(3000);

		// Click Save button
		click(sq.save_btn_editpop);

		waitFor(QP.toaster);
		// Assert the toaster "Please enter the Rubric"
		softAssert17.assertEquals(getText(QP.toaster), "Please enter the Rubric", "Assertion failed");
		click(QP.toasterclosebtn);
		softAssert17.assertAll();
	}

	/*
	 * To check the cancel button & close button functions on the edit question
	 * popup
	 */
	@Test(priority = 18)
	public void TCSPR0901718() {
		// Assert close button on popup
		Assert.assertTrue(isElementPresent(sqcr.close_btn_editpop), "Close button not present");

		waitThread(2000);

		// Click close button on edit popup
		click(sqcr.close_btn_editpop);

		waitThread(4000);
		// Assert the edit question box not visible
		// Assert.assertFalse(isDisplayed(sq.editpopup), "edit popup present");

		waitThread(2000);
		// Assert the score box of question 2 as "6"
		Assert.assertEquals(getValue(sq.markquest2), "6");

		// Assert the grand total & Total Test points same
		Assert.assertEquals(getValue(sq.grandtotal_count), "19");
		Assert.assertEquals(getText(sq.total_testscore), "19");

		waitThread(4000);
		// Click Edit button of Second Question
		// click(sq.edit_quest2);

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		Doubleclick(sq.edit_quest2);
		waitThread(2000);

		// waitThread(3000);

		Scroll_DowntoEnd();
		waitThread(2000);
		// Assert the criteria 1 & criteria 2 are visible
		Assert.assertEquals(getValue(ck.crit1_bx), "CR1");
		Assert.assertEquals(getValue(ck.crit2_bx), "CR2");
		waitThread(3000);

		// Assert the max score is 6
		Assert.assertEquals(getText(sqcr.max_score_click), "6");
		waitThread(3000);

		// click on Remove column button
		click(QP.remov_lastcolum);

		waitThread(2000);
		// Assert the Confirmation popup visible
		Assert.assertTrue(isDisplayed(sqcr.remove_col_confir), "Confirmation popup not displayed");

		waitThread(2000);
		// Click Yes button
		click(sqcr.confirm_yes_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Removed successfully"
		Assert.assertEquals(getText(QP.toaster), "Removed successfully");
		click(QP.toasterclosebtn);

		waitThread(2000);
		// Assert the max score is 6
		Assert.assertEquals(getText(sqcr.max_score_click), "6");

		// Assert Cancel button onm popup
		Assert.assertTrue(isElementPresent(sqcr.cancel_btn_editpop), "Cancel button not present");

		waitThread(5000);

		// Click cancel button on edit popup
		click(sqcr.cancel_btn_editpop);
		waitThread(4000);

		// Assert the edit question box not visible
		//Assert.assertFalse(isElementPresent(sq.editpopup), "edit popup present");
		//waitThread(2000);

		// Assert the score box of question 2 as "6"
		Assert.assertEquals(getValue(sq.markquest2), "6");

		// Assert the grand total & Total Test points same
		Assert.assertEquals(getValue(sq.grandtotal_count), "19");
		Assert.assertEquals(getText(sq.total_testscore), "19");

		waitThread(2000);
		ScrollTo_xy_position(0, 0);
		waitThread(1000);
		// Click Edit button of first Question
		Doubleclick(sq.edit_quest1);

		waitThread(4000);
		// Assert the Text "1.Question"
		Assert.assertEquals(getText(sq.quest1_label), "1.Question");

	}

	/*
	 * To check the max row limit
	 */
	@Test(priority = 19)
	public void TCSPR0901719() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		waitThread(4000);

		// Assert the clickable rubric radio button is enabled
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		for (int i = 2; i <= 5; i++) {
			waitThread(3000);
			// Click Add Row button
			click(QP.add_row);
			driver.switchTo().frame(i);
			waitThread(2000);
			Assert.assertEquals(getAttribute(ck.clic_rub_place, "aria-placeholder"), "Enter Condition");
			driver.switchTo().defaultContent();
		}
		waitThread(2000);
		// Click Add Row button
		click(QP.add_row);

		waitFor(QP.toaster);
		// Assert the toaster "Max row limit reached"
		Assert.assertEquals(getText(QP.toaster), "Max row limit reached");
		click(QP.toasterclosebtn);

	}

	/*
	 * To check the max column limit
	 */
	@Test(priority = 20)
	public void TCSPR0901720() {

		// Assert the clickable rubric radio button is enabled
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		for (int i = 2; i <= 6; i++) {

			// Click Add Column button
			click(QP.add_column);
			driver.switchTo().frame(i);
			waitThread(2000);
			Assert.assertEquals(getAttribute(ck.clic_rub_place, "aria-placeholder"), "Enter Condition");
			driver.switchTo().defaultContent();
		}
		waitThread(3000);
		// Click Add Column button
		click(QP.add_column);

		waitFor(QP.toaster);
		// Assert the toaster "Max column limit reached"
		Assert.assertEquals(getText(QP.toaster), "Max column limit reached");
		click(QP.toasterclosebtn);

	}

	/*
	 * To check whether the Save confirmation popup is displayed when switching the
	 * rubrics
	 */
	@Test(priority = 21)
	public void TCSPR0901721() {
		// Assert the clickable rubric radio button is enabled
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Assert the Confirmation popup visible
		waitThread(2000);
		// Assert the Confirmation popup visible
		Assert.assertTrue(isDisplayed(sqcr.remove_col_confir), "Confirmation popup not displayed");

		// Assert the text "Changes you made may not be saved."
		Assert.assertEquals(getText(sqcr.conf_text), "Changes you made may not be saved.");

		// Assert continue editing button
		Assert.assertEquals(getText(sqcr.cont_edit_btn), "Continue Editing");

		waitThread(2000);
		// Click Continue editing
		click(sqcr.cont_edit_btn);

		// Assert the radio button of clickable rubric is checked
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		waitThread(2000);
		// Click Standard rubric radio button
		click(QP.std_rad);

		// Assert Discard button
		Assert.assertEquals(getText(sqcr.disc_btn), "Discard");

		// Click Discard button
		click(sqcr.disc_btn);

		// Assert the radio button of Standard rubric is checked
		Assert.assertTrue(isElementPresent(QP.std_rubcheck), "Standard rubric radio button is not checked");

	}

	/*
	 * To check the whether the validation message display if the Standard rubric is
	 * empty and also to change clickable rubric to standard rubric and save in the
	 * edit question popup
	 */
	@Test(priority = 22)
	public void TCSPR0901722() {
		SoftAssert softAssert22 = new SoftAssert();
		// Assert the Standard rubric is empty
		driver.switchTo().frame("rubrics_ifr");

		waitThread(2000);
		Assert.assertEquals(getText(sqcr.std_rub_bx), "");
		driver.switchTo().defaultContent();

		waitThread(3000);
		// Click Save button
		click(sq.save_btn_editpop);

		waitFor(QP.toaster);
		// Assert the toaster "Please enter the mandatory fields in Rubrics"
		softAssert22.assertEquals(getText(QP.toaster), "Please enter the Rubric", "Assertion failed");
		click(QP.toasterclosebtn);
		softAssert22.assertAll();

		// Enter standard rubric content
		driver.switchTo().frame("rubrics_ifr");

		waitThread(4000);
		type(sqcr.std_rub_bx, "Rubric");
		driver.switchTo().defaultContent();

		waitThread(3000);
		// click save button
		click(sq.save_btn_editpop);

		waitFor(QP.toaster);
		// Assert the toaster "Question updated successfully"
		softAssert22.assertEquals(getText(QP.toaster), "Question updated successfully", "Assertion failed");
		click(QP.toasterclosebtn);

		ScrollTo_xy_position(0, 0);
		waitThread(1000);
		
		waitThread(3000);
		// Assert the tooltip of question 1 as "standard rubric "
		MouseHover(sq.rubquest1);
		Assert.assertEquals(getAttribute(sq.rubquest1, "tooltipposition"), "top");

		// Assert the score of question 1 is editable
		click(sq.markquest1);

		waitThread(6000);

		// click Edit button of first question
		Doubleclick(sq.edit_quest1);
		waitThread(2000);

		// Page scroll down
		sqcr.Scroll_DowntoEnd();
		
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,250)", "");

		// Assert the Standard rubric radio button is checked
		Assert.assertTrue(isElementPresent(QP.std_rubcheck), "Standard rubric radio button is not checked");

		waitThread(4000);

		// Click close button of popup
		click(sqcr.close_btn_editpop);

		waitThread(4000);

		ScrollTo_xy_position(0, 0);
		waitThread(1000);
		
		// Assert the Total no: of Questions
		Assert.assertEquals(getText(sq.total_questcount), "3");

	}

	/*
	 * To check the delete Question functionality from Summary page
	 */
	@Test(priority = 23)
	public void TCSPR0901723() {

		waitThread(4000);

		// Assert the delete button of 3rd question
		Assert.assertTrue(isElementPresent(sqcr.del_quest3), "Delete button of question 3 not present");

		waitThread(4000);

		// Click the delete button of 3rd question
		click(sqcr.del_quest3);

		waitThread(3000);

		// Assert the text "Are you sure that you want to delete?"
		Assert.assertEquals(getText(sqcr.del_text), "Are you sure that you want to delete?");

		// Assert yes & No buttons
		Assert.assertTrue(isElementPresent(sqcr.no_btn_del), "No button not present");
		Assert.assertTrue(isElementPresent(sqcr.yes_btn_del), "Yes button not present");

		waitThread(2000);
		// click No Button
		click(sqcr.no_btn_del);

		waitThread(2000);
		// Assert No popup visible
		Assert.assertFalse(isElementPresent(sqcr.no_btn_del), "Popup  present");

		waitThread(2000);
		// Click the delete button of 3rd question
		click(sqcr.del_quest3);

		waitThread(2000);
		// Assert the text "Are you sure that you want to delete?"
		Assert.assertEquals(getText(sqcr.del_text), "Are you sure that you want to delete?");

		waitThread(2000);
		// Assert yes & No buttons
		Assert.assertTrue(isElementPresent(sqcr.no_btn_del), "No button not present");
		Assert.assertTrue(isElementPresent(sqcr.yes_btn_del), "Yes button not present");

		waitThread(2000);
		// click yes Button
		click(sqcr.yes_btn_del);

		waitFor(QP.toaster);
		// Assert toaster "Question deleted succesfully"
		Assert.assertEquals(getText(QP.toaster), "Question deleted succesfully");
		click(QP.toasterclosebtn);

		waitThread(2000);
		// Assert the count of Questions
		Assert.assertEquals(getText(sq.total_questcount), "2");
	}
	/*
	 * To check the rubric switching functions in edit question box
	 */

	@Test(priority = 24)
	public void TCSPR0901724() {
		// click Edit button of first question
		click(sq.edit_quest1);
		waitThread(1000);

		// Page scroll down
		QP.Scroll_DowntoEnd();
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,250)", "");
		
		// Assert the Standard rubric radio button is checked
		Assert.assertTrue(isEnabled(QP.std_rubcheck), "Standard rubric radio button is not checked");

		// Click Clickable rubric radio button
		click(QP.click_radio);

		// Assert max score is 0
		Assert.assertEquals(getText(sqcr.max_score_click), "0");

		// Click Add column button
		click(QP.add_column);

		// Enter criteria & condition to added column

		type(ck.crit1_bx, "CR1");
		type(ck.scre_col1, "1");

		waitThread(2000);
		driver.switchTo().frame("editorFieldRubric_00_ifr");
		waitThread(2000);
		type(sqcr.condit1_box, "Good");
		driver.switchTo().defaultContent();

		// Assert the max score 1
		Assert.assertEquals(getText(sqcr.max_score_click), "1");

		// Click Standard rubric radio button
		click(QP.std_rad);

		waitThread(1000);
		// Assert the Confirmation popup visible
		Assert.assertTrue(isElementPresent(sqcr.remove_col_confir), "Confirmation popup not visible");

		waitThread(1000);
		// Click Discard button
		click(sqcr.disc_btn);

		// Assert the radio button of Standard rubric is checked
		Assert.assertTrue(isEnabled(QP.std_rubcheck), "Standard rubric radio button is not checked");

		// Assert the content of standard rubric visible
		driver.switchTo().frame("rubrics_ifr");
		Assert.assertEquals(getText(sqcr.std_rub_bx), "Rubric");
		waitThread(2000);

		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Clickable rubric radio button
		click(QP.click_radio);

		// Assert max score is 0
		Assert.assertEquals(getText(sqcr.max_score_click), "0");

	}

	/*
	 * To check the Rubric Score validations
	 */
	@Test(priority = 25)
	public void TCSPR0901725() {
		waitThread(2000);
		// Click Add column button
		click(QP.add_column);

		waitThread(3000);
		// Click Score box
		click(ck.scre_col1);

		waitThread(2000);
		// click outside score box
		click(sqcr.max_score_click);

		waitThread(4000);
		// Assert the validation message "Score range should be 0-20"
		Assert.assertEquals(getText(ck.valid_msg_score), "*Score range should be 0-20");

		waitThread(2000);
		// Enter score 0
		type(ck.scre_col1, "0");
		driver.findElement(By.xpath("//input[@id='scoreField_00']")).clear();

		waitThread(3000);
		// Enter score
		type(ck.scre_col1, "100");

		waitThread(4000);
		// Assert the validation message "Score range should be 0-20"
		Assert.assertEquals(getText(ck.valid_msg_score), "*Score range should be 0-20");

	}
	/*
	 * To check the clickable rubric validations in summary page
	 */
	@Test(priority = 26)
	public void TCSPR0901726()
	{
		//Clear score
		click(ck.scre_col1);
		driver.findElement(By.xpath("//input[@id='scoreField_00']")).clear();

		//Click Save button
		click(sqcr.save_btn_editpopup);
		
		//Assert toasters
		//-Please enter the number greater than zero on score for 'column 1' in Criteria 1
		//- "Please enter the Condition for 'Column 1' in Criteria 1"
		//-"Please enter the Criteria 1"
		
		
		
		
		
	}

	/*
	 * To check the function of editor in clickable rubric
	 */
	@Test(priority = 28)
	public void TCSPR0901728() {

		waitThread(2000);
		// Click Cancel button
		click(sqcr.cancel_btn_editpop);

		waitThread(2000);
		// Assert the Summary Questions
		Assert.assertEquals(getText(sq.Summary_quest), "Questions Summary", "Assertion failed");

		waitThread(2000);
		// Click Edit button of first Question
		click(sq.edit_quest1);
		waitThread(4000);

		waitThread(2000);
		// Page scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		waitThread(6000);

		// Click Add column button
		click(QP.add_column);

		/// Click on condition box
		driver.switchTo().frame(1);
		waitThread(2000);
		click(sqcr.condit1_box);

		// Enter condition
		type(sqcr.condit1_box, "Conditions");

		// Click on condition box
		driver.switchTo().frame(1);
		waitThread(2000);
		click(sqcr.condit1_box);

		// select the text in condition box
		Actions dummy = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//body[@data-id='editorFieldRubric_00']"));
		dummy.doubleClick(ele).build().perform();
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click on Bold button
		click(ck.Bold_btn);

		// Click Italic button
		click(ck.italic_btn);

		// Assert the text is bold &Italic
		driver.switchTo().frame(1);
		Assert.assertTrue(isDisplayed(ck.bold_italic_text), "Text is not bold and ilatic");
		driver.switchTo().defaultContent();

	}
	
	/*
	 * To check the functions of formula editor &Underline button
	 */
	@Test(priority = 29)
	public void TCSPR0901729() {
		// select the text in condition box
		driver.switchTo().frame(1);
		waitThread(2000);
		click(sqcr.condit1_box);
		Actions dummy = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//body[@data-id='editorFieldRubric_00']"));
		dummy.doubleClick(ele).build().perform();
		driver.switchTo().defaultContent();

		waitThread(2000);

		// Click Underline button
		click(ck.underline_btn);

		// Assert the text is underlined
		driver.switchTo().frame(1);
		Assert.assertTrue(isDisplayed(ck.underlined_txt), "Text is not underlined");
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click on Math formula editor
		click(ck.math_edit_btn);

		waitThread(1000);
		// Assert the formula editor is opened
		Assert.assertTrue(isDisplayed(ck.math_edit_bx), "math editor not displayed");

		waitThread(2000);
		// Assert the label "Math type"
		Assert.assertEquals(getText(ck.math_typ_lbl), "MathType");

		waitThread(1000);
		// click cancel button
		click(ck.math_cancel);

		waitThread(2000);
		// Click on chem formula editor
		click(ck.chem_edit_btn);

		// Assert the Chem editor is opened
		Assert.assertTrue(isDisplayed(ck.chem_edit_bx), "math editor not displayed");

		waitThread(1000);
		// Assert the label "Chem type"
		Assert.assertEquals(getText(ck.chem_typ_labl), "ChemType");

	}

	/*
	 * To check whether the formula editor is closing while switching the rubric
	 */
	@Test(priority = 30)
	public void TCSPR0901730() {

		waitThread(1000);
		// Assert the Chem editor is opened
		Assert.assertTrue(isDisplayed(ck.chem_edit_bx), "math editor not displayed");

		// Assert the label "Chem type"
		Assert.assertEquals(getText(ck.chem_typ_labl), "ChemType");

		ck.scrolup();
		// Click on Standard rubric radio button
		waitThread(2000);
		click(QP.std_rad);

		waitThread(1000);
		// Assert the Confirmation popup visible
		Assert.assertTrue(isElementPresent(sqcr.remove_col_confir), "Confirmation popup not visible");

		waitThread(1000);
		// Click Continue editing
		click(sqcr.cont_edit_btn);

		// Assert the editor is opened
		Assert.assertTrue(isDisplayed(ck.chem_edit_bx), "Chem editor not displayed");

		// Assert the radio button of Clickable rubric is checked
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		waitThread(2000);
		// click Standard rubric radio button
		click(QP.std_rad);
		waitThread(2000);

		// Assert the Confirmation popup visible
		Assert.assertTrue(isElementPresent(sqcr.remove_col_confir), "Confirmation popup not visible");
		waitThread(1000);
		// Click Discard button
		click(sqcr.disc_btn);
		waitThread(1000);
		// Assert the formula editor is closed
		Assert.assertFalse(isElementPresent(ck.chem_edit_bx), "math editor displayed");

		waitThread(2000);

		// Click close button of editpopup
		click(sqcr.close_btn_editpop);

		waitThread(2000);
		// Assert the Summary wizard is selected
		Assert.assertEquals(getAttribute(sq.summary_wizard_high, "aria-selected"), "true");

	}

	/*
	 * To perform Delete TeacherAccount functionality
	 */
	@Test(priority = 31)
	public void TCSPR0901731() {
		waitThread(2000);
		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted teacher profile credentials
	 */
	@Test(priority = 32)
	public void TCSPR0901732() {

		// login using deleted account credentials
		rs.login_Teacher(Emailteacher, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Invalid email or password");

	}

	/*
	 * To perform Delete student1 Account functionality
	 */
	@Test(priority = 33)
	public void TCSPR0901733() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent1, password);

		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 1 profile credentials
	 */
	@Test(priority = 34)
	public void TCSPR0901734() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent1, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Invalid email or password");

	}

	/*
	 * To perform Delete student2 Account functionality
	 */
	@Test(priority = 35)
	public void TCSPR0901735() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent2, password);

		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 2 profile credentials
	 */
	@Test(priority = 36)
	public void TCSPR0901736() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent2, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Invalid email or password");

	}
}
