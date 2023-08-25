package CreateNewAssessment.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.DoubleClickAction;
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
import CreateNewAssessment.Pages.SummaryQuestionsPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import net.bytebuddy.asm.Advice.Enter;

public class SummaryQuestionsTestOld extends basePage {

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
	public void TCSPR0901301() {

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
	public void TCSPR0901302() throws SQLException {

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
	public void TCSPR0901303() {

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
	public void TCSPR0901304() throws SQLException {

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
	public void TCSPR0901305() {

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
	public void TCSPR0901306() throws SQLException {

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
	public void TCSPR0901307() {

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
	public void TCSPR0901308() {
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
	public void TCSPR0901309() {

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
		type(QP.max_scorbx, "10");

		waitThread(4000);
		// Click + button
		click(mq.add_quest_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);

		// Assert the label "2.Questions"
		Assert.assertEquals(getText(QP.question1), "2." + "\nQuestion");

	}

	/*
	 * To add multiple questions with clickable rubric & Standard rubrics
	 */

	@Test(priority = 10)
	public void TCSPR0901310() {

		SoftAssert softAssert1 = new SoftAssert();
		waitThread(1000);
		// Enter Question2
		driver.switchTo().frame("question_ifr");
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
		type(ck.crit1_bx, "CR2");

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
		// Click + button
		click(mq.add_quest_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		softAssert1.assertEquals(getText(QP.toaster), "Question 2 Saved successfully", "Assertion failed");
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
		type(QP.max_scorbx, "5");

		waitThread(5000);
		// Click + button
		click(mq.add_quest_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		softAssert1.assertEquals(getText(QP.toaster), "Question 3 Saved successfully", "Assertion failed");
		click(QP.toasterclosebtn);

		waitThread(4000);
		// Assert the label "4.Questions"
		Assert.assertEquals(getText(QP.question1), "4." + "\nQuestion");

		softAssert1.assertAll();
	}

	/*
	 * To add mutiple questions with clickable rubric & Standard rubrics
	 */
	@Test(priority = 11)
	public void TCSPR0901311() {

		SoftAssert softAssert2 = new SoftAssert();

		// Enter Question4
		driver.switchTo().frame("question_ifr");
		type(QP.Quest_box, "Question4");
		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);

		// Assert the Label Add Rubric
		Assert.assertEquals(getText(QP.Add_rublabel), "Add Rubric");

		// Add Column
		click(QP.add_column);

		// Enter Criteria
		type(ck.crit1_bx, "C4");

		// Enter score for column1
		type(ck.scre_col1, "10");

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
		// Assert the toaster "Saved successfully"
		softAssert2.assertEquals(getText(QP.toaster), "Question 4 Saved successfully", "Assertion  failed");
		click(QP.toasterclosebtn);

		// Assert the label "5.Questions"
		Assert.assertEquals(getText(QP.question1), "5." + "\nQuestion");

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		click(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question5");

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
		type(QP.std_rub_bx, "R5");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "10");

		waitThread(7000);
		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		softAssert2.assertEquals(getText(QP.toaster), "Question 5 Saved successfully", "Assertion  failed");
		waitThread(1000);
		click(QP.toasterclosebtn);
		softAssert2.assertAll();
	}
	/*
	 * To perform Save&Next and to verify the details on the peer review page
	 * 
	 */

	@Test(priority = 12)
	public void TCSPR0901312() {

		// Assert the Max score possible
		Assert.assertEquals(getText(QP.max_scoreposs_value), "37");

		// Assert the Max score field
		Assert.assertEquals(getValue(QP.max_scorbx), "10");

		waitThread(2000);

		waitThread(4000);
		// Click Save &Next button
		click(QP.savenext_btn);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

		waitThread(3000);
		// Enter peer review Reward score 100
		click(sq.peer_reward_scorebx);
		waitThread(1000);
		type(sq.peer_reward_scorebx, "100");

	}
	/*
	 * To verify the details on the peer review page
	 * 
	 */

	@Test(priority = 13)
	public void TCSPR0901313() {

		waitThread(4000);
		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl), "Total Students : 2");

		// Assert the first student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Studentname);

		// Assert the second student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Studentname2);

	}

	/*
	 * To perform the save and next functionaity from peer review page and verify
	 * the schedule page details
	 */
	@Test(priority = 14)
	public void TCSPR0901314() {
		SoftAssert softAssert3 = new SoftAssert();
		waitThread(3000);
		// Click Save &Next button
		click(pr.savennext_button);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		softAssert3.assertEquals(getText(QP.toaster), "Saved successfully", "Assertion  failed");
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
	@Test(priority = 15)
	public void TCSPR0901315() {

		SoftAssert softAssert4 = new SoftAssert();
		waitThread(3000);
		// Assert the Mail notification checkbox is checked
		Assert.assertTrue(isDisplayed(sq.mailcheckbox_tick), "Checkbox is not checked");

		waitThread(3000);
		// Click Save &Next button
		click(pr.savennext_button);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		softAssert4.assertEquals(getText(QP.toaster), "Saved successfully", "Assertion  failed");
		click(QP.toasterclosebtn);

		waitThread(3000);

		// Assert the Summary wizard is selected
		Assert.assertEquals(getAttribute(sq.summary_wizard_high, "aria-selected"), "true");

		waitThread(3000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(sbt.summaryassessmentname).contains("Assessment Name: " + AssessmentName));
		softAssert4.assertAll();
	}

	/*
	 * To check the Questions section on the Summary page.
	 * 
	 */
	@Test(priority = 16)
	public void TCSPR0901316() {

		SoftAssert SoftAssert16 = new SoftAssert();
		// Assert the text "Questions Summary "
		Assert.assertEquals(getText(sq.Summary_quest), "Questions Summary");

		// Assert the Total no: of Questions
		Assert.assertEquals(getText(sq.total_questcount), "5");

		// Assert the Maximum score possible
		Assert.assertEquals(getText(sq.max_scorepos_count), "37.0");

		// Assert the Questions visible on the page is same as Questions added on page
		Assert.assertEquals(getText(sq.quest1), "Question1");
		Assert.assertEquals(getText(sq.quest2), "Question2");
		Assert.assertEquals(getText(sq.quest3), "Question3");
		Assert.assertEquals(getText(sq.quest4), "Question4");
		Assert.assertEquals(getText(sq.quest5), "Question5");

		// Tootips of question visible
		MouseHover(sq.quest1);
		Assert.assertEquals(getAttribute(sq.quest1, "tooltipposition"), "top");
		MouseHover(sq.quest2);
		Assert.assertEquals(getAttribute(sq.quest2, "tooltipposition"), "top");

		waitThread(3000);
		// Assert the marks in Question page is same as questions page
		SoftAssert16.assertEquals(getValue(sq.markquest1), "10", "Assertion failed");
		SoftAssert16.assertEquals(getValue(sq.markquest2), "2", "Assertion failed");
		SoftAssert16.assertEquals(getValue(sq.markquest3), "5", "Assertion failed");
		SoftAssert16.assertEquals(getValue(sq.markquest4), "10", "Assertion failed");
		waitThread(1000);
		SoftAssert16.assertEquals(getValue(sq.markquest5), "10", "Assertion failed");
		waitThread(3000);

		// Assert the Grand total is same as Maximum score possible
		SoftAssert16.assertEquals(getValue(sq.grandtotal_count), "37", "Assertion failed");
		SoftAssert16.assertEquals(getText(sq.max_scorepos_count), "37.0", "Assertion failed");
		SoftAssert16.assertAll();
	}

	/*
	 * To perform Edit Questions functionality on the Summary page & To check the
	 * Edit popup window visibility
	 * 
	 */
	@Test(priority = 17)
	public void TCSPR0901317() {
		SoftAssert softAssert17 = new SoftAssert();
		// Assert the Edit button of first question is visible
		Assert.assertTrue(isElementPresent(sq.edit_quest1), "edit question button not present");

		// Assert the tooltip of edit button visible
		Assert.assertEquals(getAttribute(sq.edit_quest1, "ptooltip"), "Edit");

		waitThread(2000);
		// click Edit button of first question
		click(sq.edit_quest1);
		waitThread(2000);
		// Assert the Edit Question popup visible
		Assert.assertTrue(isDisplayed(sq.editpopup), "Edit pop up not visible");

		// Assert the text "Edit Question"
		Assert.assertEquals(getText(sq.editquest_label), "Edit Question");

		// Assert the Text "1.Question"
		softAssert17.assertEquals(getText(sq.quest1_label), "1.Question", "assertion failed");

		// Enter new Question content
		driver.switchTo().frame("question_ifr");
		click(QP.Quest_box);
		driver.findElements(By.xpath("//body[@data-id='question']")).clear();
		type(QP.Quest_box, "firstQuestionnedited");
		driver.switchTo().defaultContent();

		// Assert save button on edit popup
		Assert.assertTrue(isElementPresent(sq.save_btn_editpop), "Save button is not present");

		waitThread(1000);
		// click save button
		click(sq.save_btn_editpop);

		waitFor(QP.toaster);
		// Assert the toaster "Question updated successfully"
		softAssert17.assertEquals(getText(QP.toaster), "Question updated successfully", "Assertion failed");
		click(QP.toasterclosebtn);

		waitThread(2000);
		// Assert the Summary wizard is selected
		Assert.assertEquals(getAttribute(sq.summary_wizard_high, "aria-selected"), "true");

		// Assert the edited question content visible on summary page
		Assert.assertEquals(getText(sq.quest1), "firstQuestionnedited");
		softAssert17.assertAll();
	}
	/*
	 * To perform Edit Rubrics functionality on the Summary page & To check the Edit
	 * popup window visibility
	 * 
	 */

	@Test(priority = 18)
	public void TCSPR0901318() {

		SoftAssert softAssert18 = new SoftAssert();
		// Assert the tooltip of Standard rubric content of first question visible
		MouseHover(sq.rubquest1);
		Assert.assertEquals(getAttribute(sq.rubquest1, "tooltipposition"), "top");

		waitThread(1000);
		// click Edit button of first question
		click(sq.edit_quest1);
		waitThread(1000);

		// Page scroll down
		QP.Scroll_DowntoEnd();

		// Assert the Standard rubric radio button is checked
		Assert.assertTrue(isElementPresent(QP.std_rubcheck), "Standard rubric radio button is not checked");

		// Enter the new content to standard rubric box
		driver.switchTo().frame("rubrics_ifr");
		driver.findElements(By.xpath("//body[@data-id='rubrics']")).clear();
		type(sq.edit_pop_std_rubox, "Rubric1");

		driver.switchTo().defaultContent();
		waitThread(2000);

		// click save button
		click(sq.save_btn_editpop);

		waitFor(QP.toaster);
		// Assert the toaster "Question updated successfully"
		softAssert18.assertEquals(getText(QP.toaster), "Question updated successfully", "Assertion failed");
		click(QP.toasterclosebtn);

		waitThread(2000);
		// Assert the tooltip of new added Standard rubric content visible
		MouseHover(sq.rubquest1);
		Assert.assertEquals(getAttribute(sq.rubquest1, "tooltipposition"), "top");
		softAssert18.assertAll();
	}
	/*
	 * To perform Score adjustments for Standard rubric
	 */

	@Test(priority = 19)
	public void TCSPR0901319() {
		SoftAssert softAssert19 = new SoftAssert();

		// Assert the score added for the first question in the question page is visible
		// in the score box
		waitThread(3000);
		Assert.assertTrue(isElementPresent(sq.markquest1), "Standard rubric Score of first question not visible");
		waitThread(3000);
		softAssert19.assertEquals(getValue(sq.markquest1), "10", "Assertion failed");

		waitThread(5000);
		// Adjust the score of first question and add new score
		click(sq.markquest1);
		driver.findElement(By.xpath("//*[@id='tstQstnTable']//div//tr[1]/td[6]/div/input")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id='tstQstnTable']//div//tr[1]/td[6]/div/input")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id='tstQstnTable']//div//tr[1]/td[6]/div/input")).sendKeys("12");

		waitThread(3000);

		click(sq.max_scorepos_count);

		waitFor(QP.toaster);

		// Assert toaster "Score updated successfully"
		softAssert19.assertEquals(getText(QP.toaster), "Score updated successfully", "Assertion failed");
		click(QP.toasterclosebtn);

		// Assert the score box with new score value
		softAssert19.assertEquals(getValue(sq.markquest1), "12", "Assertion failed");

		waitThread(2000);
		// Assert the Grand total & Max score possible same
		softAssert19.assertEquals(getValue(sq.grandtotal_count), "39", "Assertion failed");
		softAssert19.assertEquals(getText(sq.max_scorepos_count), "39.0", "Assertion failed");

		softAssert19.assertAll();
	}

	/*
	 * To check the Score adjustments for Clickable rubric is possible
	 */
	@Test(priority = 20)
	public void TCSPR0901320() {
		SoftAssert softAssert20 = new SoftAssert();
		// Assert the tooltip of Question 2 as clickable rubric
		MouseHover(sq.rubquest2);
		Assert.assertEquals(getAttribute(sq.rubquest2, "tooltipposition"), "top");

		waitThread(3000);
		// Assert the score box of question2 visible
		Assert.assertTrue(isElementPresent(sq.markquest2), "Standard rubric Score of first question not visible");
		softAssert20.assertEquals(getValue(sq.markquest2), "2", "Assertion failed");

		// Assert no score adjustment possible for clickable rubric scores
		softAssert20.assertFalse(isEnabled(sq.markquest2), "Clickable rubric score box is enabled");

		// Assert the Grand total & Max score possible same
		softAssert20.assertEquals(getValue(sq.grandtotal_count), "39", "Assertion failed");
		softAssert20.assertEquals(getText(sq.max_scorepos_count), "39.0");
		softAssert20.assertAll();
	}

	/*
	 * To check the image upload functionality in the Edit question popup
	 */
	public String ImageURL = "http://192.168.7.108/SPRAPIQA/Files/Assessment/619dbf63c0429e0d15787b61/73b15af5-4d23-4d99-9690-ae509df4fc07.png";

	@Test(priority = 21)
	public void TCSPR0901321() {
		SoftAssert softAssert21 = new SoftAssert();
		waitThread(2000);
		// Click on Edit button of Question 3
		click(sq.edit_quest3);

		waitThread(4000);
		// Assert the Text "3.Question"
		softAssert21.assertEquals(getText(sq.quest1_label), "3.Question", "Assertion failed");

		// Assert the already added question is visible on the box
		driver.switchTo().frame("question_ifr");
		softAssert21.assertEquals(getText(QP.Quest_box), "Question3", "Assertion failed");
		click(QP.Quest_box);
		driver.findElement(By.xpath("//body[@data-id='question']")).clear();
		driver.switchTo().defaultContent();

		// Click image button on the editor
		click(sq.imag_btn_editpop);

		// Assert the insert/edit image popup visible
		Assert.assertTrue(isDisplayed(be.imageuploadheaderlbl), "Insert image popup not present");

		// Type a url
		waitThread(2000);
		driver.findElement(
				By.cssSelector("div[id*=dialog-describe_] > div > div > div > div:nth-child(1) > div > div>input"))
				.sendKeys(ImageURL);
		waitThread(5000);

		// click on save button
		click(be.imageuploadsavebtn);
		waitThread(2000);

		// Assert the added image visible on the page
		driver.switchTo().frame("question_ifr");
		Assert.assertTrue(isElementPresent(be.instrimage), "Uploaded image not visible");
		click(QP.Quest_box);
		driver.switchTo().defaultContent();

		waitThread(2000);

		// Click Save button in edit question popup
		click(sq.save_btn_editpop);

		waitFor(QP.toaster);
		// Assert the toaster "Question updated successfully"
		softAssert21.assertEquals(getText(QP.toaster), "Question updated successfully", "Assertion failed");
		click(QP.toasterclosebtn);

		waitThread(2000);

		// Assert the text " Image/Video/Equation" in the question 3 row
		Assert.assertEquals(getText(sq.quest3), "Image/Video/Equation");

		softAssert21.assertAll();
	}

	/*
	 * To check the video upload functionality in the Edit question popup
	 * 
	 */
	public String VideoURL = "http://192.168.7.108/SPRAPIQA/Files/Assessment/619dbeddc0429e0d15787b5f/86d56375-b977-4156-a2e5-10a5c9f1812d.mp4";

	@Test(priority = 22)
	public void TCSPR0901322() {
		SoftAssert softAssert22 = new SoftAssert();
		waitThread(2000);
		// Click on Edit button of Question 4
		click(sq.edit_quest4);

		waitThread(5000);
		// Assert the Text "4.Question"
		Assert.assertEquals(getText(sq.quest1_label), "4.Question");

		// Assert the already added question is visible on the box
		driver.switchTo().frame("question_ifr");
		softAssert22.assertEquals(getText(QP.Quest_box), "Question4");
		waitThread(1000);
		click(QP.Quest_box);
		driver.findElement(By.xpath("//body[@data-id='question']")).clear();
		driver.switchTo().defaultContent();

		// Click video button on the editor
		click(sq.video_btn_editpop);

		// Assert the Insert/Edit Media popup visible
		Assert.assertTrue(isDisplayed(be.imageuploadheaderlbl), "Insert media popup not present");

		// Type a url
		driver.findElement(
				By.cssSelector("div[id*=dialog-describe_] > div > div > div > div:nth-child(1) > div > div>input"))
				.sendKeys(VideoURL);
		waitThread(7000);

		// click on save button
		click(be.videouploadsavebtn);
		waitThread(2000);

		// Assert the added video visible on the page
		driver.switchTo().frame("question_ifr");
		Assert.assertTrue(isElementPresent(sq.quest_edit_video), "Uploaded video not visible");
		click(QP.Quest_box);
		driver.switchTo().defaultContent();

		// Click Save button in edit question popup
		click(sq.save_btn_editpop);

		waitFor(QP.toaster);
		// Assert the toaster "Question updated successfully"
		softAssert22.assertEquals(getText(QP.toaster), "Question updated successfully", "Assertion failed");
		click(QP.toasterclosebtn);

		waitThread(2000);

		// Assert the text " Image/Video/Equation" in the question 4 row
		softAssert22.assertEquals(getText(sq.quest4), "Image/Video/Equation...");

		softAssert22.assertAll();
	}

	/*
	 * 
	 * To check the Maximum score validation toaster in the Standard Rubric score
	 * box
	 */
	@Test(priority = 23)
	public void TCSPR0901323() {
		SoftAssert softAssert23 = new SoftAssert();
		// Assert the score of 5th question is same as added in questions page
		softAssert23.assertEquals(getValue(sq.markquest5), "10", "Assertion failed");
		waitThread(5000);
		// Clear the Score box of 5th question
		driver.findElement(By.xpath("//*[@id='tstQstnTable']//div//tr[5]/td[6]/div/input")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id='tstQstnTable']//div//tr[5]/td[6]/div/input")).sendKeys(Keys.BACK_SPACE);
		// Enter a score
		driver.findElement(By.xpath("//*[@id='tstQstnTable']//div//tr[5]/td[6]/div/input")).sendKeys("500");
		waitThread(3000);
		click(sq.max_scorepos_count);
		waitFor(QP.toaster);
		// Assert toaster "Score updated successfully"
		softAssert23.assertEquals(getText(QP.toaster), "Score updated successfully", "Assertion failed");
		click(QP.toasterclosebtn);

		waitThread(3000);
		// Clear the Score box of 5th question
		driver.findElement(By.xpath("//*[@id='tstQstnTable']//div//tr[5]/td[6]/div/input")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id='tstQstnTable']//div//tr[5]/td[6]/div/input")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id='tstQstnTable']//div//tr[5]/td[6]/div/input")).sendKeys(Keys.BACK_SPACE);

		// Enter a score
		driver.findElement(By.xpath("//*[@id='tstQstnTable']//div//tr[5]/td[6]/div/input")).sendKeys("600");
		waitThread(3000);
		click(sq.max_scorepos_count);
		waitFor(QP.toaster);

		// Assert toaster "Score should be less than or equal to 500"
		softAssert23.assertEquals(getText(QP.toaster), "Score should be less than or equal to 500", "Assertion failed");
		click(QP.toasterclosebtn);

		waitThread(3000);
		// Assert the Score box with already added score
		softAssert23.assertEquals(getValue(sq.markquest5), "500", "Assertion failed");
		softAssert23.assertAll();
	}

	/*
	 * To perform order changing functionality of Questions in Summary page
	 */
	// @Test(priority = 24)
	public void TCSPR0901324() {
		SoftAssert softAssert24 = new SoftAssert();
		// Assert the first question content
		softAssert24.assertEquals(getText(sq.quest1), "firstQuestionnedited", "Assertion failed");

		// Assert the second question content
		softAssert24.assertEquals(getText(sq.quest2), "Question2", "Assertion failed");

		waitThread(2000);
		// Drag first question to second
		Actions builder = new Actions(driver);

		waitThread(1000);
		WebElement from = driver.findElement(By.xpath("//*[@id='tstQstnTable']//table//tr[1]/td[1]/span"));
		WebElement to = driver.findElement(By.xpath("//*[@id='tstQstnTable']//table//tr[2]/td[1]/span"));

		// Building a drag and drop action
		Action dragAndDrop = builder.clickAndHold(from).moveToElement(to).release(to).build();

		// Performing the drag and drop action
		dragAndDrop.perform();

		// Assert the toaster "Question order changed successfully"
		waitFor(QP.toaster);
		softAssert24.assertEquals(getText(QP.toaster), "Question order changed successfully", "Assertion failed");
		click(QP.toasterclosebtn);

		// Assert the order of first & second question has changed
		softAssert24.assertEquals(getText(sq.quest1), "Question2", "Assertion failed");
		softAssert24.assertEquals(getText(sq.quest2), "firstQuestionnedited", "Assertion failed");

		// Assert the rubrics and marks order of 1st&2nd question changed
		MouseHover(sq.rubquest1);
		Assert.assertEquals(getAttribute(sq.rubquest1, "tooltipposition"), "top");

		MouseHover(sq.rubquest2);
		Assert.assertEquals(getAttribute(sq.rubquest2, "tooltipposition"), "top");

		Assert.assertEquals(getValue(sq.markquest1), "2");
		Assert.assertEquals(getValue(sq.markquest2), "12");

		softAssert24.assertAll();
	}
	/*
	 * To check whether the order change of questions are updated on Questions page
	 * 
	 */

//	@Test(priority = 25)
	public void TCSPR0901325() {
		// Assert the Grand total & Maximum score possible
		waitThread(2000);
		Assert.assertEquals(getText(sq.max_mark), "529.0");
		Assert.assertEquals(getValue(sq.grandtotal_count), "529");

		waitThread(2000);
		// Click Question in wizard
		click(QP.Quest_wizard);

		waitThread(3000);

		// Assert the label "5.Question"
		Assert.assertEquals(getText(QP.question1), "5." + "\nQuestion");

		// Click Question 1 number
		click(mq.q1_btn);

		waitThread(3000);
		// Assert the label "1.Question"
		Assert.assertEquals(getText(QP.question1), "1." + "\nQuestion");

		// Assert the added Question 2 content in the Question 1 box
		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), "Question2");
		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);

		// Assert the Clickable rubric radio button selected
		Assert.assertTrue(isEnabled(QP.click_radio), "Clickable radio button is not selected");

		// Assert the rubric content
		driver.switchTo().frame("editorFieldRubric_00_ifr");
		waitThread(2000);
		Assert.assertEquals(getText(ck.enter_con), "Good");
		driver.switchTo().defaultContent();

		// page scroll up
		ck.scrolup();

		// Assert the marks
		Assert.assertEquals(getValue(QP.max_scorbx), "2");

		waitThread(2000);

		// Click Question 2 number
		click(mq.q2_btn);

		// Assert the label "2.Question"
		waitThread(3000);
		Assert.assertEquals(getText(QP.question1), "2." + "\nQuestion");

		// Assert the added Question 1 content in the Question 2 box
		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), "firstQuestionnedited");
		driver.switchTo().defaultContent();

		// Assert the Standard rubric radio button selected
		Assert.assertTrue(isEnabled(QP.std_rubcheck), "Clickable radio button is not selected");

		// Assert the rubric content
		driver.switchTo().frame("rubric_ifr");
		Assert.assertEquals(getText(QP.std_rub_bx), "Rubric1");
		driver.switchTo().defaultContent();

		// Assert the marks same as in summary page
		Assert.assertEquals(getValue(QP.max_scorbx), "12");
	}

	/*
	 * To check whether modifications on question page updating on Summary page
	 */
	@Test(priority = 26)
	public void TCSPR0901326() {

		waitThread(2000);
		// Click Question in wizard
		click(QP.Quest_wizard);

		waitThread(3000);

		// Assert the label "5.Question"
		Assert.assertEquals(getText(QP.question1), "5." + "\nQuestion");

		// Assert + button to add more questions
		Assert.assertTrue(isElementPresent(mq.add_quest_btn), "Add more question button not present");

		waitThread(1000);
		// Click on +button
		click(mq.add_quest_btn);

		waitThread(3000);

		// Assert the label "6.Questions"
		Assert.assertEquals(getText(QP.question1), "6." + "\nQuestion");

		// Enter question 6
		driver.switchTo().frame("question_ifr");
		type(QP.Quest_box, "Question6");
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
		Assert.assertTrue(isEnabled(QP.std_rad), "Standard rubric radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "Rubric6");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Click Sample Answer
		click(QP.sample_ans_btn);

		// Enter Sample Answer contents
		driver.switchTo().frame("sampleAnswer_ifr");
		type(QP.sample_ansbx, "Sampleans");
		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "10");

		waitThread(2000);
		// Click Save& Next button
		click(QP.savenext_btn);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 6 Saved successfully");
		click(QP.toasterclosebtn);

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

		waitThread(2000);
		// Click Save &Next button
		click(pr.savennext_button);
		waitThread(2000);

		// Assert the schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");

		waitThread(6000);
		// Click Save &Next button
		click(pr.savennext_button);

		waitThread(5000);
		// Assert the Summary wizard is selected
		Assert.assertEquals(getAttribute(sq.summary_wizard_high, "aria-selected"), "true");

		// Assert the 6th added question visible on the page
		Assert.assertTrue(isDisplayed(sq.quest6), "Question 6 not present");
		Assert.assertEquals(getText(sq.quest6), "Question6");

		// Assert the standard rubric tooltip &sample answer tooltip visible
		MouseHover(sq.rubquest6);
		Assert.assertEquals(getAttribute(sq.rubquest6, "tooltipposition"), "top");

		MouseHover(sq.samquest6);
		Assert.assertEquals(getAttribute(sq.samquest6, "tooltipposition"), "top");

		// Assert the marks of added question
		Assert.assertEquals(getValue(sq.markquest6), "10");

		// Assert the Grand total and max score possible are same
		Assert.assertEquals(getText(sq.max_mark), "539.0");
		Assert.assertEquals(getValue(sq.grandtotal_count), "539");

		// Assert the total no:of questions
		Assert.assertEquals(getText(sq.total_questcount), "6");
	}
	/*
	 * To perform edit function to the standard rubric & to upload image on Standard
	 * Rubric edit box
	 */

	@Test(priority = 27)
	public void TCSPR0901327() {
		waitThread(4000);
		// click Edit button of Third question
		click(sq.edit_quest3);

		waitThread(3000);

		// Assert the Text "3.Question"
		Assert.assertEquals(getText(sq.quest1_label), "3.Question");

		waitThread(2000);
		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(3000);
		// Assert the Standard rubric radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "Standard rubric radio button is not selected");

		// Clear the rubric data
		driver.switchTo().frame("rubrics_ifr");
		Doubleclick("//body[@data-id='rubrics']");
		driver.findElements(By.xpath("//body[@data-id='rubrics']")).clear();
		waitThread(2000);
		driver.switchTo().defaultContent();

		// Click image button on the editor
		click(sq.imag_btn_stdrub);

		// Assert the insert/edit image popup visible
		Assert.assertTrue(isDisplayed(be.imageuploadheaderlbl), "Insert image popup not present");

		// Type a url
		waitThread(2000);
		driver.findElement(
				By.cssSelector("div[id*=dialog-describe_] > div > div > div > div:nth-child(1) > div > div>input"))
				.sendKeys(ImageURL);
		waitThread(5000);

		// click on save button
		click(be.imageuploadsavebtn);
		waitThread(2000);

		// Assert the added image visible on the page
		driver.switchTo().frame("rubrics_ifr");
		Assert.assertTrue(isElementPresent(be.instrimage), "Uploaded image not visible");
		click(sq.edit_pop_std_rubox);
		driver.switchTo().defaultContent();

		waitThread(5000);

		// Click Save button in edit question popup
		click(sq.save_btn_editpop);

		waitFor(QP.toaster);
		// Assert the toaster "Question updated successfully"
		Assert.assertEquals(getText(QP.toaster), "Question updated successfully");
		click(QP.toasterclosebtn);

		waitThread(4000);

		// Assert the tooltip " Image/Video/Equation" in the rubric part of Question3
		MouseHover(sq.rubquest3);
		Assert.assertEquals(getAttribute(sq.rubquest3, "tooltipposition"), "top");

	}

	/*
	 * To upload video to the Standard rubric edit box
	 */
	@Test(priority = 28)
	public void TCSPR0901328() {
		waitThread(2000);

		SoftAssert softAssert28 = new SoftAssert();
		// Click on Edit button of Question 5
		click(sq.edit_quest5);

		waitThread(5000);

		// Assert the Text "5.Question"
		softAssert28.assertEquals(getText(sq.quest1_label), "5.Question", "assertion failed");

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(3000);
		// Assert the Standard rubric radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "Standard rubric radio button is not selected");

		// Clear the rubric data
		driver.switchTo().frame("rubrics_ifr");
		Doubleclick("//body[@data-id='rubrics']");
		driver.findElements(By.xpath("//body[@data-id='rubrics']")).clear();
		waitThread(2000);
		driver.switchTo().defaultContent();

		// Click video button on the editor
		click(sq.video_btn_stdrub);

		// Assert the Insert/Edit Media popup visible
		Assert.assertTrue(isDisplayed(be.imageuploadheaderlbl), "Insert media popup not present");

		// Type a url
		driver.findElement(
				By.cssSelector("div[id*=dialog-describe_] > div > div > div > div:nth-child(1) > div > div>input"))
				.sendKeys(VideoURL);
		waitThread(7000);

		// click on save button
		click(be.videouploadsavebtn);
		waitThread(2000);

		// Assert the added video visible on the page
		driver.switchTo().frame("rubrics_ifr");
		Assert.assertTrue(isElementPresent(be.infovideo1), "Uploaded video not visible");
		click(sq.edit_pop_std_rubox);
		driver.switchTo().defaultContent();

		waitThread(5000);

		// Click Save button in edit question popup
		click(sq.save_btn_editpop);

		waitFor(QP.toaster);
		// Assert the toaster "Question updated successfully"
		Assert.assertEquals(getText(QP.toaster), "Question updated successfully");
		click(QP.toasterclosebtn);

		waitThread(3000);

		// Assert the tooltip " Image/Video/Equation" in the rubric part of Question5
		MouseHover(sq.rubquest5);
		Assert.assertEquals(getAttribute(sq.rubquest5, "tooltipposition"), "top");

		softAssert28.assertAll();
	}

	/*
	 * To upload equations to the question & Standard rubric edit box
	 */
	@Test(priority = 29)
	public void TCSPR0901329() {

		SoftAssert softAssert29 = new SoftAssert();

		waitThread(2000);
		// Click on Edit button of Question 6
		click(sq.edit_quest6);

		waitThread(5000);

		// Assert the Text "6.Question"
		softAssert29.assertEquals(getText(sq.quest1_label), "6.Question", "assertion failed");

		// Assert the added question content visible on question box
		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), "Question6");

		// Clear the Question data
		Doubleclick("//body[@data-id='question']");
		driver.findElements(By.xpath("//body[@data-id='question']")).clear();
		driver.switchTo().defaultContent();

		// Click on the Mathtype button
		click(QE.math_editor);

		// Assert the Mathtype popup visible
		// To add equation to math editor
		JavaScriptclick(be.infofractionbtn);
		waitThread(2000);

		Assert.assertTrue(isDisplayed(be.infofractionbody), "Fraction body not visible");
		driver.findElement(By.cssSelector(be.infomathtextbx)).sendKeys("10");
		waitThread(2000);

		driver.findElement(By.cssSelector(be.infomathtextbx)).sendKeys(Keys.ARROW_DOWN);
		waitThread(2000);

		driver.findElement(By.cssSelector(be.infomathtextbx)).sendKeys("4");
		waitThread(2000);

		driver.findElement(By.cssSelector(be.infomathtextbx)).sendKeys(Keys.ARROW_RIGHT);
		JavaScriptclick(be.infosquareroutebtn);

		Assert.assertTrue(isDisplayed(be.infofractionbody), "Fraction body not visible");
		driver.findElement(By.cssSelector(be.infomathtextbx)).sendKeys("5");
		waitThread(2000);

		driver.findElement(By.cssSelector(be.infomathtextbx)).sendKeys(Keys.ARROW_RIGHT);
		waitThread(2000);

		Assert.assertTrue(isDisplayed(be.infofractionbody), "Fraction body not visible");
		waitThread(2000);
		Doubleclick(be.infomathinsertbtn);
		waitThread(2000);

		Assert.assertFalse(isDisplayed(be.infomathpopup), "MathType Popup  visible");
		waitThread(4000);

		// Switch to Question frame and verify the uploaded equation
		driver.switchTo().frame("question_ifr");
		waitThread(5000);
		Assert.assertTrue(isElementPresent(sq.equationeditor_quest), "Uploaded equation not visible");
		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(3000);
		// Assert the Standard rubric radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "Standard rubric radio button is not selected");

		waitThread(3000);
		// Clear the rubric data
		driver.switchTo().frame("rubrics_ifr");
		Doubleclick("//body[@data-id='rubrics']");
		driver.findElements(By.xpath("//body[@data-id='rubrics']")).clear();
		waitThread(2000);
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click on the Mathtype button
		click(QE.rubric_math_edit);

		// Assert the Mathtype popup visible
		// To add equation to math editor
		JavaScriptclick(be.rubricfraction_btn);
		waitThread(2000);

		Assert.assertTrue(isDisplayed(be.rubricfraction_btn), "Fraction body not visible");
		driver.findElement(By.cssSelector(be.rubric_math_txtbx)).sendKeys("10");
		waitThread(2000);

		driver.findElement(By.cssSelector(be.rubric_math_txtbx)).sendKeys(Keys.ARROW_DOWN);
		waitThread(2000);

		driver.findElement(By.cssSelector(be.rubric_math_txtbx)).sendKeys("4");
		waitThread(2000);

		driver.findElement(By.cssSelector(be.rubric_math_txtbx)).sendKeys(Keys.ARROW_RIGHT);
		JavaScriptclick(be.rubric_sqre_root);

		Assert.assertTrue(isDisplayed(be.rubricfraction_btn), "Fraction body not visible");
		driver.findElement(By.cssSelector(be.rubric_math_txtbx)).sendKeys("5");
		waitThread(2000);

		driver.findElement(By.cssSelector(be.rubric_math_txtbx)).sendKeys(Keys.ARROW_RIGHT);
		waitThread(2000);

		Assert.assertTrue(isDisplayed(be.rubricfraction_btn), "Fraction body not visible");
		waitThread(2000);
		Doubleclick(be.rubric_math_insertbtn);
		waitThread(2000);

		Assert.assertFalse(isDisplayed(be.rubric_math_txtbx), "MathType Popup  visible");
		waitThread(4000);

		// Switch to Rubric frame and verify the uploaded equation
		driver.switchTo().frame("rubrics_ifr");
		waitThread(5000);
		Assert.assertTrue(isElementPresent(sq.equationineditor_std), "Uploaded equation not visible");
		driver.switchTo().defaultContent();

		waitThread(4000);

		// Click Save button in edit question popup
		click(sq.save_btn_editpop);

		waitFor(QP.toaster);
		// Assert the toaster "Question updated successfully"
		Assert.assertEquals(getText(QP.toaster), "Question updated successfully");
		click(QP.toasterclosebtn);

		waitThread(3000);

		// Assert the tooltip " Image/Video/Equation" rubric part of Question6
		MouseHover(sq.rubquest6);
		Assert.assertEquals(getAttribute(sq.rubquest6, "tooltipposition"), "top");

		// Assert the question content "Image/Video/Equation" visible on summary page
		Assert.assertEquals(getText(sq.quest6), "Image/Video/Equation");

		softAssert29.assertAll();
	}

	/*
	 * To perform Delete TeacherAccount functionality
	 */
	@Test(priority = 30)
	public void TCSPR0901330() {

		waitThread(2000);
		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted teacher profile credentials
	 */
	@Test(priority = 31)
	public void TCSPR0901331() {

		// login using deleted account credentials
		rs.login_Teacher(Emailteacher, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student1 Account functionality
	 */
	@Test(priority = 32)
	public void TCSPR0901332() {

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
	@Test(priority = 33)
	public void TCSPR0901333() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent1, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student2 Account functionality
	 */
	@Test(priority = 34)
	public void TCSPR0901334() {

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
	@Test(priority = 35)
	public void TCSPR0901335() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent2, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

}
