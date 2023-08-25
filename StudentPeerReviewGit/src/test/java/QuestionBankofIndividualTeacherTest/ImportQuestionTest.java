package QuestionBankofIndividualTeacherTest;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import Course.Pages.EditCoursePage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.ClickableRubricPage;
import CreateNewAssessment.Pages.MultipleQuestionsAddPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CreateNewAssessment.Pages.SummaryQuestionsPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowWizardPage;
import QuestionBankofIndividualTeacherPage.ImportQuestionPage;
import QuestionBankofIndividualTeacherPage.QuestionBankPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class ImportQuestionTest extends basePage {

	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	CourseRosterPage cr = new CourseRosterPage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	EncryptedText et = new EncryptedText();
	EditCoursePage ec = new EditCoursePage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	CommonMethods cm = new CommonMethods();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	ImportQuestionPage iq = new ImportQuestionPage();
	QuestionBankPage qb = new QuestionBankPage();
	SchedulePageBasicsPage sb1 = new SchedulePageBasicsPage();
	MultipleQuestionsAddPage mq = new MultipleQuestionsAddPage();
	ClickableRubricPage ck = new ClickableRubricPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	SummaryQuestionsPage sq = new SummaryQuestionsPage();
	TeacherTestSectionPage tts = new TeacherTestSectionPage();
	SummaryBasicsPage sb = new SummaryBasicsPage();
	PeerReviewWindowWizardPage prw = new PeerReviewWindowWizardPage();

	public String AssessmentName;
	public String Emailteacher;
	public String Question1 = "Question1";
	public String Question2 = "Question2";
	public String Question3 = "Question3";
	public String Rubric1 = "Rubric1";
	public String Rubric2 = "Rubric2";
	public String Rubric3 = "Rubric3";
	public String Maxscore1 = "10";
	public String Maxscore2 = "20";
	public String Maxscore3 = "30";

	public String NewCourseTitle;
	public String CourseName;
	public String CourseID;
	public String Emailstudent1;
	public String Emailstudent2;
	public String Studentfirstname = "Ashley";
	public String Studentlastname = "Albert";
	public String Studentname = "Ashley Albert";
	public String Studentfirstname2 = "Ben";
	public String Studentlastname2 = "Alex";
	public String Studentname2 = "Ben Alex";

	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	/*
	 * To load the Student Peer Review Landing Page
	 */
	@Test(priority = 1)
	public void TCSPR1600201() throws SQLException {
		// Assert the heading label "Welcome to Student Peer Review"
		Assert.assertEquals(getText(lg.wel_label), "Welcome to Student Peer Review");

		// Teacher Sign up
		// To click on I am A teacher button
		click(sp.btn_1);

		// To fill the details on the sign up page
		Emailteacher = st.TCSPR020005();
		System.out.println(Emailteacher);

		// To catch OTP from sending Resource
		st.TCSPR020006();
	}

	/*
	 * To create a course for creating an Assessment and to invite student
	 */
	@Test(priority = 2)
	public void TCSPR1600202() {

		CourseName = "Course Name" + generateRandomNumber().trim();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID = (getText(cn.course_Id));
		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";

		// Invite students to course
		cm.Invitestudentstocourse(CourseName, Emailstudent1, Emailstudent2);

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 3)
	public void TCSPR1600203() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on first student's profile
	 * and accept course request-Read the student name
	 */
	@Test(priority = 4)
	public void TCSPR1600204() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent1, CourseID);
		String encText = et.EncryptCode(studentinviteid);

		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname = "Ashley";
		Studentlastname = "Albert";
		Studentname = Studentfirstname + " " + Studentlastname;

		// click first name
		click(sp.txtbxFirstN);
		waitThread(1000);
		// type first name
		type(sp.txtbxFirstN, Studentfirstname);
		waitThread(1000);
		// click last name
		click(sp.txtbxLastN);
		waitThread(1000);
		// type last name
		type(sp.txtbxLastN, Studentlastname);
		waitThread(1000);
		// click password
		click(sp.txtbxPass);
		waitThread(1000);
		// type password
		type(sp.txtbxPass, password);
		waitThread(1000);
		// click password
		click(sp.txtbxPassconf);
		waitThread(1000);
		// type password
		type(sp.txtbxPassconf, password);
		waitThread(1000);
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
		Assert.assertEquals(getText(rs.course_name), CourseName.trim());

	}

	/*
	 * To Accept course and perform logout functionality on the student profile
	 */
	@Test(priority = 5)
	public void TCSPR1600205() {

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
		Assert.assertEquals(getText(rs.enrolledcoursename), CourseName);
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on Second student's profile
	 * and accept course request-Read the student name
	 */
	@Test(priority = 6)
	public void TCSPR1600206() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent2, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname2 = "Ben";
		Studentlastname2 = "Alex";
		Studentname2 = Studentfirstname2 + " " + Studentlastname2;

		// click first name
		click(sp.txtbxFirstN);
		waitThread(1000);
		// type first name
		type(sp.txtbxFirstN, Studentfirstname2);
		waitThread(1000);
		// click last name
		click(sp.txtbxLastN);
		waitThread(1000);
		// type last name
		type(sp.txtbxLastN, Studentlastname2);
		waitThread(1000);
		// click password
		click(sp.txtbxPass);
		waitThread(1000);
		// type password
		type(sp.txtbxPass, password);
		waitThread(1000);
		// click password
		click(sp.txtbxPassconf);
		waitThread(1000);
		// type password
		type(sp.txtbxPassconf, password);
		waitThread(1000);
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
		Assert.assertEquals(getText(rs.course_name), CourseName);

	}

	/*
	 * To Accept course and perform logout functionality on the student profile
	 */
	@Test(priority = 7)
	public void TCSPR1600207() {
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
		Assert.assertEquals(getText(rs.enrolledcoursename), CourseName);
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check the functionality of Manage Assessments in Course Info dropdown
	 */
	@Test(priority = 8)
	public void TCSPR1600208() {

		// Login as teacher
		lg.login1(Emailteacher, password);

		// To verify the create new course button
		Assert.assertTrue(isElementPresent(cn.btn_createnew), "Create new course button not present");
		waitThread(3000);
		// Click Course Details drop down
		click(ec.splitbutton);

		// Assert the Manage Assessments
		waitThread(3000);
		Assert.assertEquals(getText(ec.manag_assess), "Manage Assessments");

		// Click Manage Assessments
		click(ec.manag_assess);

		// Assert Heading "Assessments"
		Assert.assertEquals(getText(ba.lbl_assessment), "Assessments");

	}

	/*
	 * To add basic details of an assessment
	 */
	@Test(priority = 9)
	public void TCSPR1600209() {

		waitThread(1000);
		// Click Create New Assessment button
		click(QP.creatnew_assessbtn);

		waitThread(3000);
		// Assert the Basic details label on Wizard
		Assert.assertEquals(getText(QP.basic_detls_wizard), "Basic Details");

		waitThread(2000);
		// Click on course dropdown
		click(QP.cours_drp);

		waitThread(2000);
		// Select the created course from course dropdown
		click(QP.coursname_drp);

		// Assert the Selected course is same as created course
		Assert.assertEquals(getText(QP.coursname_drp), CourseName);

		waitThread(2000);
		// Type Assessment Name
		Doubleclick(QP.Assess_name);
		AssessmentName = "Assessment" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentName);

		waitThread(1000);
		// Click Save &Next button
		click(QP.Savenext);

		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);

	}

	/*
	 * To check the Heading labels of the Question Page
	 */
	@Test(priority = 10)
	public void TCSPR1600210() {

		waitThread(1000);
		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(2000);
		// Assert the Create New Assessment heading
		Assert.assertEquals(getText(QP.creat_new_asesslabel), "Create New Assessment");

		// Assert the Course name&course code are present in the page
		Assert.assertTrue(isElementPresent(QP.course_name), "Course name and code are not present");

		// Assert the Course name is same as created course name
		Assert.assertEquals(getText(QP.course_name), "Course: " + CourseID + ", " + CourseName);

		// Assert the Assessment name
		Assert.assertEquals(getText(QP.Assess_lbel), "Assessment Name:" + " " + AssessmentName);

		// Assert Add to Question bank checkbox
		Assert.assertTrue(isElementPresent(QP.quest_bankcheckbx), "Add to Question bank check box is not present");

	}

	/*
	 * To check the basic funtionalities of all buttons in question page
	 * --Commenting tc due to repetition
	 */
	// @Test(priority = 11)
	public void TCSPR1600211() {

		// Assert Import from Question Bank label
		Assert.assertEquals(getText(QP.import_quest), "Import from Question Bank");

		// Assert 'Import from Question Bank' button is enable
		Assert.assertTrue(isEnabled(QP.import_quest), "Import from Question bank button is disabled");

		// Assert Clear All label
		Assert.assertEquals(getText(QP.clear_all), "Clear All");

		// Assert Clear All button is present
		Assert.assertTrue(isEnabled(QP.clear_all), "Clear all button is disabled");

		// Assert Max.Score label
		Assert.assertEquals(getText(QP.max_scorelabl), "Max Score");

		// Assert Save button is present
		Assert.assertTrue(isElementPresent(QP.save), "Save button not present");

		// Assert Save button is enable
		Assert.assertTrue(isEnabled(QP.save), "Save button is disabled");
	}

	/*
	 * To check the select category dropdown on the Import from Question Bank
	 */
	@Test(priority = 12)
	public void TCSPR1600212() {

		// Assert Import from Question Bank label
		Assert.assertEquals(getText(QP.import_quest), "Import from Question Bank");

		// Assert 'Import from Question Bank' button is enable
		Assert.assertTrue(isEnabled(QP.import_quest), "Import from Question bank button is disabled");

		// Click on Import from Question Bank button
		click(QP.import_quest);

		// Assert Question Bank popup is visible
		waitThread(1000);
		Assert.assertTrue(isDisplayed(iq.Questionbnkpopup), "Popup not visible");

		// Assert 'Question Bank' label
		Assert.assertEquals(getText(iq.Quest_bnk_lbl), "Question Bank");

		// Assert place holder Search Question
		Assert.assertEquals(getAttribute(iq.search_quest, "placeholder"), "Search Question");

		// Assert Category label
		Assert.assertEquals(getText(qb.cat_lbl), "Category");

		// click select category dropdown
		click(iq.catdropdwn);

		// Assert the search field checkbox present & disabled
		Assert.assertTrue(isElementPresent(qb.al_checkbx), "All checkbox not present");
		Assert.assertTrue(getAttribute(qb.al_checkbx, "class").contains("p-disabled"));

		// Assert Close button is present
		Assert.assertTrue(isElementPresent(qb.close_btn), "close button not present");

	}

	/*
	 * To check the select category search field on the Import from Question
	 * Bank
	 */
	@Test(priority = 13)
	public void TCSPR1600213() {

		// Assert the following grid labels:
		// *Sl No
		// *Question
		// *Rubric
		// *Sample Answer
		// *Max Score
		// *Linked to Category
		// *Last Modified
		// *Action

		Assert.assertEquals(getText(qb.sl_number), "Sl No");
		Assert.assertEquals(getText(qb.quest_lbl), "Question");
		Assert.assertEquals(getText(qb.Rubric_lbl), "Rubric");
		Assert.assertEquals(getText(qb.samp_ans_lbl), "Sample Answer");
		Assert.assertEquals(getText(qb.max_score_lbl), "Max Score");
		Assert.assertEquals(getText(qb.link_tocat_lbl), "Linked to Category");
		Assert.assertEquals(getText(qb.last_modified_lbl), "Last Modified");
		Assert.assertEquals(getText(qb.action_lbl), "Action");

		// Assert No Questions(s) Found. Label is visible in grid
		Assert.assertEquals(getText(qb.no_quest_found_txt), "No Question(s) Found.");

		// Assert Total question label
		Assert.assertTrue(getText(qb.tot_quest_lbl).contains("Total Questions:"));

		// Assert Total Question is 0
		Assert.assertEquals(getText(qb.tot_quest_lbl), "Total Questions: 0");

		// Assert Question bank close button is present
		Assert.assertTrue(isElementPresent(iq.quest_popup_close), "Close button not present");

		// Click on Question bank close button
		click(iq.quest_popup_close);

		waitThread(2000);
		// Assert popup is redirect to question page
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");
	}

	/*
	 * To check whether Add to question check box functionalities
	 */
	@Test(priority = 14)
	public void TCSPR1600214() {

		// Assert Add to Question check box is visible
		Assert.assertTrue(isElementPresent(QP.quest_bankcheckbx), "Add to Question bank check box is not present");

		// Assert 'Add to Question Bank' label
		Assert.assertEquals(getText(QP.add_quest_bnk_lbl), "Add to Question Bank");

		// Assert Select Category dropdown is disable
		Assert.assertTrue(getAttribute(QP.select_cat, "class").contains("disabled"));
	}

	/*
	 * To Add Category functionalities on question page
	 */
	@Test(priority = 15)
	public void TCSPR1600215() {

		// Click on Add to Question Bank check box
		click(QP.quest_bankcheckbx);

		// Click select category dropdown
		waitThread(2000);
		click(QP.select_cat);

		// Assert Select Category drop down field is enable when select the add
		// to
		// question bank check box
		Assert.assertFalse(getAttribute(QP.select_cat, "class").contains("disabled"));

		// Assert the search field checkbox present & disabled
		Assert.assertTrue(isElementPresent(QP.cat_all_check), "All checkbox not present");
		Assert.assertTrue(getAttribute(QP.cat_all_check, "class").contains("checkbox-disabled"));

	}

	/*
	 * To check Create a new category functionalities on question page
	 */
	public String cat_name = "Category1" + generateRandomData();

	@Test(priority = 16)
	public void TCSPR1600216() {

		// Assert 'Create a new Category' label
		Assert.assertEquals(getText(QP.creat_newcat), "Create a new Category");

		// Click on the Create a new Category Button
		click(QP.creat_newcat);

		// Assert Create Category popup is visible
		waitThread(1000);
		Assert.assertTrue(isDisplayed(qb.cat_popup), "Popup not visible");

		// Assert 'Create Category' label
		Assert.assertEquals(getText(qb.catpopup_lbl), "Create Category");

		// Assert 'Name' label
		Assert.assertEquals(getText(qb.name_lbl), "Name");

		// Enter Name
		waitThread(2000);
		click(qb.cat_textarea);
		type(qb.cat_textarea, cat_name);

		// Assert 'Create' button
		waitThread(2000);
		Assert.assertEquals(getText(qb.create_btn), "Create");

		// Click on create button
		click(qb.create_btn);

		// Assert 'Added to the question bank' toaster
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Added to the question bank");
		click(QP.toasterclosebtn);

		// Click on Select Category
		click(QP.select_cat);

		waitThread(1000);
		// Assert Category Name is display in the dropdown
		Assert.assertEquals(getText(QP.add_cat_indrpdwn), cat_name);

	}

	/*
	 * To fill details on the 1. Question in question page
	 */
	@Test(priority = 17)
	public void TCSPR1600217() {

		// click on Question box
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, Question1);
		driver.switchTo().defaultContent();

		// Enter Standrad rubric
		waitThread(2000);
		driver.switchTo().frame("rubric_ifr");
		type(QP.std_rub_bx, "R1");
		driver.switchTo().defaultContent();
		waitThread(2000);

		// Page scroll up
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		waitThread(2000);
		// Enter Max score
		type(QP.max_scorbx, Maxscore1);
		ScrollTo_Location(QP.Quest_wizard);
		// Click add question button
		waitThread(2000);
		click(mq.add_quest_btn);

		// Assert toaster "Question 1 Saved successfully"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);

	}

	/*
	 * To check Create a next category functionalities on question page
	 */
	public String cat_name2 = "Category2" + generateRandomData();

	@Test(priority = 18)
	public void TCSPR1600218() {

		// Click on Select Category
		waitThread(2000);
		click(QP.quest_bankcheckbx);

		click(QP.select_cat);
		waitThread(2000);

		// Click on the Create a new Category Button
		click(QP.creat_newcat);

		// Enter Name
		waitThread(2000);
		click(qb.cat_textarea);
		type(qb.cat_textarea, cat_name2);

		// Click on create button
		waitThread(3000);
		click(qb.create_btn);

		// Assert 'Added to the question bank' toaster
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Added to the question bank");
		click(QP.toasterclosebtn);

	}

	/*
	 * To fill details on the 2. Question in question page
	 */
	@Test(priority = 19)
	public void TCSPR1600219() {

		// Enter Question2
		driver.switchTo().frame("question_ifr");
		type(QP.Quest_box, Question2);
		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);

		// Click on Clickable Rubric radio button
		click(QP.click_radio);

		// Assert the Clickable Rubric radio button is enabled
		Assert.assertTrue(getAttribute(QP.click_radio, "class").contains("checked"));

		// Assert the placeholder "No Rubric Created!"
		Assert.assertEquals(getText(QP.click_rubric_holder), "No Rubric Created !");
	}

	/*
	 * To fill details Clickable rubric on question page
	 */
	@Test(priority = 20)
	public void TCSPR1600220() {

		// Click Add column button
		click(QP.add_column);
		waitThread(1000);

		// Enter Condition
		driver.switchTo().frame(1);
		waitThread(2000);
		type(ck.enter_con, "Test 1");
		driver.switchTo().defaultContent();

		// Enter criteria 1
		type(ck.crit1_bx, "C1");

		// Enter Score 5
		click(ck.scre_col1);
		type(ck.scre_col1, Maxscore2);

	}

	/*
	 * To fill details on the 3. Question and create 3rd category in question
	 * page
	 */
	public String cat_name3 = "Category3" + generateRandomData();

	@Test(priority = 21)
	public void TCSPR1600221() {

		// Click add question button
		waitThread(2000);
		click(mq.add_quest_btn);

		// Click on Add to Question Bank check box
		waitThread(4000);
		click(QP.quest_bankcheckbx);

		// Click select category dropdown
		waitThread(2000);
		click(QP.select_cat);

		waitThread(4000);
		// Click on the Create a new Category Button
		click(QP.creat_newcat);

		// Enter Name
		waitThread(2000);
		click(qb.cat_textarea);
		type(qb.cat_textarea, cat_name3);

		// Click on create button
		waitThread(3000);
		click(qb.create_btn);

		// Assert 'Added to the question bank' toaster
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Added to the question bank");
		click(QP.toasterclosebtn);

	}

	/*
	 * To fill details on the Question 3 on the question page
	 */
	@Test(priority = 22)
	public void TCSPR1600222() {

		// Type 3. Question
		driver.switchTo().frame("question_ifr");
		type(QP.Quest_box, Question3);
		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);

		// Click on Sample Answer box
		driver.switchTo().frame("sampleAnswer_ifr");
		click(QP.sample_ansbx);

		// Type Sample Answer
		waitThread(3000);
		type(QP.sample_ansbx, "Sample Answer");
		driver.switchTo().defaultContent();

		// Type maximum score
		ScrollTo_xy_position(0, 300);
		waitThread(2000);
		type(QP.max_scorbx, Maxscore3);

		// Click on Save & Next button
		click(QP.savenext_btn);

	}

	/*
	 * To fill peer review details
	 */
	@Test(priority = 23)
	public void TCSPR1600223() {

		// Assert the peer review wizard is selected
		waitThread(3000);
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

		// Enter Peer Review Reward %
		waitThread(2000);
		type(prw.peer_reward_scorebx, "50");

		// Assert the student count
		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");

	}

	/*
	 * To perform the save and next functionality from peer review page and
	 * verify the schedule page details
	 */
	@Test(priority = 24)
	public void TCSPR1600224() {

		// Click Save&Next button
		waitThread(2000);
		click(pr.savennext_button);

		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);

		// Assert schedule wizard is selected
		waitThread(2000);
		Assert.assertEquals(getAttribute(sb1.schedule_wizard, "aria-expanded"), "true");

		// Assert the text "Select schedules for "
		Assert.assertEquals(getText(sb1.selectstu_lbl), "Select Schedules for");

		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);

	}

	/*
	 * To check Question Summary page
	 */
	@Test(priority = 25)
	public void TCSPR1600225() {

		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");

		// Assert the Text "Questions Summary"
		Assert.assertEquals(getText(sq.Summary_quest), "Questions Summary");

		// click on Release Button
		click(sb.btnrelease);

		waitFor(QP.toaster);
		// Assert toaster "Assessment published successfully
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");

		click(QP.toasterclosebtn);

	}

	/*
	 * To check Release popup functionalities
	 */
	@Test(priority = 26)
	public void TCSPR1600226() {

		// Assert the popup visible
		Assert.assertTrue(isDisplayed(tts.release_popup), "Popup not visible");

		// Assert label "Assessment Created Successfully"
		Assert.assertEquals(getText(tts.popup_text), "Assessment Created Successfully");

		// Assert button Back to Menu
		Assert.assertTrue(isElementPresent(tts.back_to_menubutton), "Back to menu button not present");

		// Click Back to Menu
		click(tts.back_to_menubutton);

		waitThread(3000);
		// Assert Heading "Assessments"
		Assert.assertEquals(getText(QP.Assessments), "Assessments");

	}

	/*
	 * To check added library category is present in the library page
	 */
	@Test(priority = 27)
	public void TCSPR1600227() {

		// Click on Libraries tab
		waitThread(3000);
		click(qb.libr_tab_lbl);

		waitThread(3000);
		Assert.assertEquals(TotalElementsCount(qb.Elementcount), 3);

		type(qb.search, Question3);
		waitThread(3000);
		// Assert Question 3 +Random number is visible
		Assert.assertEquals(getText(qb.q3_grid), Question3);

		type(qb.search, Question1);
		waitThread(3000);
		// Assert Question 2 is visible
		Assert.assertEquals(getText(qb.q3_grid), Question1);

		type(qb.search, Question2);
		waitThread(3000);
		// Assert Question 1 is visible
		Assert.assertEquals(getText(qb.q3_grid), Question2);
		type(qb.search, "    ");
		waitThread(3000);
		// Assert Question 3 +Random number View/Modify button is visible
		Assert.assertEquals(getAttribute(qb.modify_btn_rw3, "label"), "View/Modify");

		// Assert Question 2 View/Modify button is visible
		Assert.assertEquals(getAttribute(qb.modify_btn_rw2, "label"), "View/Modify");

		// Assert Question 1 View/Modify button is visible
		Assert.assertEquals(getAttribute(qb.modify_btn_rw1, "label"), "View/Modify");

		// Assert Total question count is 3 is visible
		Assert.assertEquals(getText(qb.tot_quest_lbl), "Total Questions: 3");
	}

	/*
	 * To check added library category is present in the library page
	 */
	@Test(priority = 28)
	public void TCSPR1600228() {
		type(qb.search, Question3);
		waitThread(3000);
		// Assert Question 3 +Random number rubric tick is not visible
		Assert.assertFalse(isElementPresent(qb.rubrictick_rw1), "Question 3 +Random number rubric tick is  visible");

		// Assert Question 3 +Random number Sample Answer is visible
		Assert.assertTrue(isElementPresent(qb.sampletick_rw1), "Question 3 +Random number Sample Answer is  visible");

		// Assert Question 3 +Random number,Question 1+Random numberQuestion
		// 2+Random
		// number Max Score is visible
		type(qb.search, Question3);
		waitThread(3000);
		Assert.assertEquals(getText(qb.maxscore_rw1), Maxscore3);
		type(qb.search, Question2);
		waitThread(3000);
		Assert.assertEquals(getText(qb.maxscore_rw1), Maxscore2);
		type(qb.search, Question1);
		waitThread(3000);
		Assert.assertEquals(getText(qb.maxscore_rw1), Maxscore1);

		// Assert Question 3 +Random number,Question 1+Random numberQuestion
		// 2+Random
		// number Linked to Category is visible
		waitThread(3000);
		type(qb.search, Question1);
		waitThread(3000);
		Assert.assertEquals(getText(qb.link_cat_rw1), "1");
		type(qb.search, Question2);
		waitThread(3000);
		Assert.assertEquals(getText(qb.maxscore_rw1), "20");
		type(qb.search, Question3);
		waitThread(3000);
		Assert.assertEquals(getText(qb.maxscore_rw1), "30");
		type(qb.search, "    ");
		// Assert Question 3 +Random number,Question 1+Random numberQuestion
		// 2+Random
		// number Last modified date and time is visible
		waitThread(5000);
		Assert.assertTrue(getText(qb.date_rw1).contains(cm.getdate()));
		waitThread(1000);

		// Assert Question 3 +Random number,Question 1+Random numberQuestion
		// 2+Random
		// number Delete button is visible
		Assert.assertEquals(getAttribute(qb.del_btn_rw1, "label"), "Delete");
		Assert.assertEquals(getAttribute(qb.del_btn_rw2, "label"), "Delete");
		Assert.assertEquals(getAttribute(qb.del_btn_rw3, "label"), "Delete");

		// Assert Question 1+Random numberQuestion 2+Random number rubric tick
		// visible
		type(qb.search, Question1);
		waitThread(3000);
		Assert.assertTrue(getAttribute(qb.rubrictick_rw1, "class").contains("tick"));
		type(qb.search, Question2);
		waitThread(3000);
		Assert.assertTrue(getAttribute(qb.rubrictick_rw1, "class").contains("tick"));

	}

	/*
	 * To check search question is visible in the grid label in the library page
	 */
	@Test(priority = 29)
	public void TCSPR1600229() {

		// Click on Search question
		click(qb.search_quest);

		// Enter question
		type(qb.search_quest, Question2);

		waitThread(4000);
		// Assert Question2 is display in the grid label
		Assert.assertEquals(getText(qb.q3_grid), Question2);

		// Assert Rubric has clickable rubric tick is present
		Assert.assertTrue(getAttribute(qb.rubrictick_rw1, "class").contains("tick"));

		// Assert Max Score is present
		Assert.assertEquals(getText(qb.maxscore_rw1), Maxscore2);

		// Assert Linked to Category tool tip is present
		Assert.assertEquals(getText(qb.link_cat_rw1), "1");

		// Assert View/Modify button present
		Assert.assertEquals(getAttribute(qb.modify_btn_rw1, "label"), "View/Modify");

		// Assert Delete button is present
		Assert.assertEquals(getAttribute(qb.del_btn_rw1, "label"), "Delete");

	}

	/*
	 * To check grid label shows all the questions when search question is
	 * closed in the library page
	 */
	@Test(priority = 30)
	public void TCSPR1600230() {

		// Assert Total question count is 1
		Assert.assertEquals(getText(qb.tot_quest_lbl), "Total Questions: 1");

		// Click on Close button on search filed
		// Clear search
		click(qb.search_quest);
		driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input"))
				.sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input"))
				.sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input"))
				.sendKeys(Keys.BACK_SPACE);
		waitThread(2000);
		driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input"))
				.sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input"))
				.sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input"))
				.sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input"))
				.sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input"))
				.sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input"))
				.sendKeys(Keys.BACK_SPACE);
		waitThread(2000);

		// Assert Total Question count is 3 display
		Assert.assertEquals(getText(qb.tot_quest_lbl), "Total Questions: 3");

	}

	/*
	 * To check all categories are present in Select category dropdown in the
	 * library page
	 */
	@Test(priority = 31)
	public void TCSPR1600231() {

		// Click select category dropdown
		waitThread(5000);
		click(qb.cat_dropdwn_btn);
		waitThread(2000);

		// Assert Category one + random number is present in dropdown
		Assert.assertEquals(getText(iq.cat1), cat_name);

		// Assert Category 2 + random number is present in dropdown
		Assert.assertEquals(getText(iq.cat2), cat_name2);

		// Assert Category 3 + random number is present in dropdown
		Assert.assertEquals(getText(iq.cat3), cat_name3);

		// Assert all category check box is not selected
		Assert.assertTrue(getAttribute(qb.al_checkbx, "aria-checked").contains("false"));

		// Click on close button
		click(qb.close_btn);

		waitThread(2000);
		// Assert Category box is not visible
		Assert.assertFalse(isElementPresent(qb.cat_drop_bx), "Category dropdown visible");
	}

	/*
	 * To check View/Modify functionalities in Question bank page in the library
	 * page
	 */
	@Test(priority = 32)
	public void TCSPR1600232() {

		// Click on Search question
		click(qb.search_quest);

		// Enter question
		type(qb.search_quest, Question2);

		waitThread(4000);
		// Assert Question2 is display in the grid label
		Assert.assertEquals(getText(qb.q3_grid), Question2);

		waitThread(3000);
		// Click on View/Modify button
		click(qb.modify_btn_rw1);

		// Assert View/Modify popup is visible
		waitThread(1000);
		Assert.assertTrue(isDisplayed(qb.add_newquest_hd), "Popup not visible");
		Assert.assertEquals(getText(qb.add_newquest_hd), "View/Modify question");

		// Assert Selected caregory Name is present is the grid
		Assert.assertEquals(getText(qb.sel_cat_lbl), "Selected Category Name");
		waitThread(3000);

		// Assert Category 2+random number is present in the grid
		Assert.assertEquals(getText(qb.add_cat_popup), cat_name2);

		// Assert 1.Question is visible
		driver.switchTo().frame("questionEditorId_ifr");
		Assert.assertEquals(getText(qb.quest_bx), Question2);
		driver.switchTo().defaultContent();

		// Assert Clickable rubric is present
		ScrollTo_xy_position(0, 250);
		driver.switchTo().frame(1);
		waitThread(2000);
		Assert.assertEquals(getText(ck.enter_con), "Test 1");
		driver.switchTo().defaultContent();

		// Assert Max Score is present
		Assert.assertEquals(getValue(qb.maxscore), Maxscore2);

		// Assert Save button is disable
		Assert.assertFalse(isEnabled(qb.save_btn), "Save button is enabled");

		// Assert Cancel button is enable
		Assert.assertTrue(isEnabled(qb.cancel_btn), "Cancel button is disabled");
	}

	/*
	 * To check when question is modified on view/ modify page in the library
	 * page
	 */
	@Test(priority = 33)
	public void TCSPR1600233() {

		// Click on Select category dropdown box
		waitThread(2000);
		click(qb.cat_drop_popup);

		// Click on Category 3 + random number
		waitThread(1000);
		click(qb.added_cat_drpdwn);

		// Assert the selcted category name:Category 2+randomnumber,Category
		// 3+randomnumber
		Assert.assertTrue(isElementPresent(qb.added_cat_drpdwn), "Category 3+random number  check box not selected");
		Assert.assertTrue(isElementPresent(qb.added_cat_rw2), "Category 2+random number  check box not selected");
		waitThread(3000);

		// Click on select category Close button
		click(qb.close_btn);

		waitThread(2000);

		// Click on Question box
		driver.switchTo().frame("questionEditorId_ifr");
		click(qb.quest_bx);

		// Modify question
		type(qb.quest_bx, "Question2_modified");
		driver.switchTo().defaultContent();

		// Assert Save button is enable
		Assert.assertTrue(isEnabled(qb.save_btn), "Save button is disabled");

		// Click Save button
		waitThread(2000);
		click(qb.save_btn);
		// Assert 'Updated Sucessfully' toaster
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Updated Successfully");
		click(QP.toasterclosebtn);

		waitThread(3000);
		// Assert Question2 modified is listed first in the grid
		Assert.assertEquals(getText(qb.q3_grid), "Question2_modified");

	}

	/*
	 * To check Delete button functionalities in the library page
	 */
	@Test(priority = 34)
	public void TCSPR1600234() {

		// Click on Search question
		click(qb.search_quest);

		waitThread(2000);
		// Enter question3
		type(qb.search_quest, Question3);
		waitThread(2000);
		// Assert Question3 +Random question is display in the grid label
		Assert.assertEquals(getText(qb.q3_grid), Question3);

		// Assert Delete button is present in the grid
		Assert.assertEquals(getAttribute(qb.del_btn_rw1, "label"), "Delete");

		// Click on Delete button
		waitThread(1000);
		click(qb.del_btn_rw1);

		// Assert the Delete Question popup visible
		waitThread(2000);
		Assert.assertTrue(isDisplayed(qb.del_confpopup), "Delete Confirmation popup not displayed");
		waitThread(1000);
	}

	/*
	 * To check Delete popup functionalties on question bank page in the library
	 * page
	 */
	@Test(priority = 35)
	public void TCSPR1600235() {

		// Assert Delete Question Label
		Assert.assertEquals(getText(qb.del_conf_hd), "Delete Question");

		// Assert text "Are you sure you want to delete the question?"
		Assert.assertEquals(getText(qb.del_conf_txt), "Are you sure you want to delete the question?");

		// Assert No button is present
		Assert.assertEquals(getText(qb.no_btn_del), "No");

		// Assert Yes button is present
		Assert.assertEquals(getText(qb.ys_btn_del), "Yes");

		// Click No button
		waitThread(2000);
		click(qb.no_btn_del);

		// Assert question is present
		waitThread(4000);
		Assert.assertEquals(getText(qb.q3_grid), Question3);

		// click on Delete button
		waitThread(1000);
		click(qb.del_btn_rw1);

		// Click Yes button
		waitThread(2000);
		click(qb.ys_btn_del);

		// Assert 'Question deleted' toaster is visible
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Question deleted");
		click(QP.toasterclosebtn);

		waitThread(3000);
		// Assert No Questions(s) Found. message is visible
		Assert.assertEquals(getText(qb.no_quest_found_txt), "No Question(s) Found.");

		// Click on Search close button
		waitThread(2000);
		click(qb.search_quest);
		type(qb.search_quest, " ");

		driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input"))
				.sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input"))
				.sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input"))
				.sendKeys(Keys.BACK_SPACE);
		waitThread(2000);
		driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input"))
				.sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input"))
				.sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input"))
				.sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input"))
				.sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input"))
				.sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input"))
				.sendKeys(Keys.BACK_SPACE);
		waitThread(2000);

		// Assert Question one +Random and Question2 +Random + View/Modify..are
		// display
		// in the grid
		Assert.assertEquals(getText(qb.q3_grid), "Question2_modified");
		Assert.assertEquals(getText(qb.q2_grid), Question1);

		// Assert Total Question count is 2 display
		waitThread(1000);
		Assert.assertEquals(getText(qb.tot_quest_lbl), "Total Questions: 2");
	}

	/*
	 * To check add a new question to question page and import from question
	 * page cases
	 */
	@Test(priority = 36)
	public void TCSPR1600236() {

		// Assert Add a new question button is present
		Assert.assertTrue(isElementPresent(iq.addnewqs_btn), "Add new question button not visible");
		// click on add new question button
		click(iq.addnewqs_btn);
		waitThread(1000);
		Assert.assertTrue(isDisplayed(qb.add_newquest_hd), "Popup not visible");
		Assert.assertEquals(getText(qb.add_newquest_hd), "Add a new question");

		// Click Add a new question button

		// Assert Add a new question popup is display

	}

}
