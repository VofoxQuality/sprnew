package CreateNewAssessment.Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.SQLException;

import org.apache.poi.poifs.property.Parent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import Course.Pages.EditCoursePage;
import Course.Pages.StudentRequestPage;
import CreateNewAssessment.Pages.AssessmentPublishPopupPage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.ClickableRubricPage;
import CreateNewAssessment.Pages.MultipleQuestionsAddPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.ScheduleConfigureDefaultPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import Login.Pages.LoginPage;

import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import StudentLogin.Pages.StudentProfileBasicDetailsPage;
import StudentLogin.Test.StudentProfileBasicDetailsTest;

public class QuestionsPageBasicsTest extends basePage {

	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	SignUpTest st = new SignUpTest();
	CourseRosterPage cr = new CourseRosterPage();
	LoginPage lg = new LoginPage();
	MultipleQuestionsAddPage mq = new MultipleQuestionsAddPage();
	CommonMethods cm = new CommonMethods();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	SignUpPage sp = new SignUpPage();
	Databaseconnection dc = new Databaseconnection();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	EncryptedText et = new EncryptedText();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	SchedulePageBasicsPage sb = new SchedulePageBasicsPage();
	ScheduleConfigureDefaultPage sd = new ScheduleConfigureDefaultPage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	AssessmentPublishPopupPage ap = new AssessmentPublishPopupPage();
	StudentRequestPage sr = new StudentRequestPage();
	StudentProfileBasicDetailsPage spdp = new StudentProfileBasicDetailsPage();
	StudentProfileBasicDetailsTest spdpTest = new StudentProfileBasicDetailsTest();
	EditCoursePage ec = new EditCoursePage();
	ClickableRubricPage ck = new ClickableRubricPage();

	public String Teacher_firstname;
	public String Teacher_lastname;
	public String Teacher_fullname;
	public String Password;
	public String EmailTeacher;
	public String CourseTitle;
	public String Assessment_name;
	public String newAssessment_name;
	public String CourseID;
	public String Emailteacher;
	public String CourseNamenew;
	public String NewCourseTitle;
	public String AssessmentName;
	public String NewAssessmentName;
	public String NewCourseName;
	public String Assessmentinfo;
	public String Assessmentinstruction;
	public String Assessmentinfonew;
	public String Assessmentinstructionnew;
	public String NewAssessmentinfo;
	public String NewAssessmentinstruction;
	public String CourseID1;
	public String CourseName;
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
	 * To perform Teacher Sign UP functionality
	 */
	@Test(priority = 0)
	public void TCSPR090301() {

		// To click on I am A teacher button
		click(sp.btn_1);

		// To fill the details on the sign up page
		Emailteacher = st.TCSPR020005();
		System.out.println(Emailteacher);
	}

	/*
	 * To fetch OTP
	 */
	@Test(priority = 1)
	public void OtpFetch() throws SQLException {

		// To catch OTP from sending Resource
		st.TCSPR020006();

	}

	/*
	 * To create new course
	 */
	@Test(priority = 2)
	public void TCSPR090302() throws SQLException {

		CourseName = "Course Name" + generateRandomNumber();
		// To verify the create new course button
		Assert.assertTrue(isElementPresent(cn.btn_createnew), "Create new course button not present");
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");
		Assert.assertEquals(isEnabled(cn.btn_createnew), true);
		// Click on create new course button
		click(cn.btn_createnew);
		waitThread(3000);
		Assert.assertEquals(getText(cn.Headinglbl_1), "Create New Course");
		Assert.assertTrue(isElementPresent(cn.course_Id), "Course code  not present");

		// To get the Course ID
		CourseID = (getText(cn.course_Id));
		// Click on Copy button
		click(QP.copy_btn);
		waitThread(1000);
		waitFor(cn.toaster);
		Assert.assertEquals(getText(cn.toaster).trim(), "Course ID is copied to clipboard");
		Assert.assertEquals(getText(QP.courseTitlelbl), "Course Title*");
		Assert.assertEquals(getText(QP.courseTitlestar), "*");
		Assert.assertEquals(getText(QP.txbx_Coursetitle), "");
	}

	@Test(priority = 3)
	public void TCSPR090303() {

		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";

		// Invite students to course
		cm.Invitestudentstocourse(CourseName, Emailstudent1, Emailstudent2);

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 4)
	public void TCSPR090304() {

		waitThread(2000);
		// To perform logout functionality on the teacher profile
		// Perform logout
		spdp.Logout();
		// Assert heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");
	}
	/*
	 * To check that invited course request visible on first student 's profile
	 * and accept course request-Read the student name
	 */

	@Test(priority = 5)
	public void TCSPR090305() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent1, CourseID);
		String encText = et.EncryptCode(studentinviteid);

		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		// Student1firstname = "Ashley";
		// Student1lastname = "Albert";
		// Student1name = Student1firstname + " " + Student1lastname;

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
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());

	}

	/*
	 * To Accept course and perform logout functionality on the student profile
	 */

	@Test(priority = 6)
	public void TCSPR090306() {

		// click on accept course button
		click(rs.btn_acceptcourse);
		waitThread(3000);
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
	 * To check that invited course request visible on second student's profile
	 * and course request-Read the student name
	 */
	@Test(priority = 7)
	public void TCSPR090307() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent2, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		// Student2firstname = "Ben";
		// Student2lastname = "Alex";
		// Student2name = Student2firstname + " " + Student2lastname;

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
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());

	}

	/*
	 * To Accept course and perform logout functionality on the student profile
	 */
	@Test(priority = 8)
	public void TCSPR090308() {

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
	 * To check the functionality of Manage Assessments in Course Info dropdown
	 */
	@Test(priority = 9)
	public void TCSPR090309() {

		rs.login_Teacher(Emailteacher, password);
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");
		click(QP.details_drop);
		waitThread(1000);

		// Assert the Manage Assessments
		Assert.assertEquals(getText(QP.manage_assessnew), "Manage Assessments");

		// Click Manage Assessments
		click(QP.manage_assessnew);

		// Assert Heading "Assessments"
		Assert.assertEquals(getText(QP.Assessments), "Assessments");

	}

	/*
	 * To add basic details of an assessment
	 */
	@Test(priority = 10)
	public void TCSPR090310() {
		// Assert the Create New Assessment button
		Assert.assertEquals(getText(QP.creatnew_assessbtn), "Create New Assessment");

		waitThread(1000);

		// Click Create New Assessment button
		click(QP.creatnew_assessbtn);
		waitThread(2000);

		// Assert the Basic details label on Wizard
		Assert.assertEquals(getText(QP.basic_detls_wizard), "Basic Details");
		// To click on course dropdown
		click(ba.dd_course);
		waitThread(3000);
		click(ba.ddcoursename1);
		// Type Assessment Name
		click(QP.Assess_name);
		waitThread(4000);
		Assessment_name = "Geometry_" + generateRandomNumber().trim();

		type(QP.Assess_name, Assessment_name);

		waitThread(2000);
		// Click Save &Next button
		click(QP.Savenext);

		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);

		waitThread(1000);

	}

	/*
	 * To check the Heading labels of the Question Page
	 */
	@Test(priority = 11)
	public void TCSPR090311() {
		waitThread(3000);
		// Assert the Create New Assessment heading
		Assert.assertEquals(getText(QP.creat_new_asesslabel), "Create New Assessment");

		// Assert the heading labels
		Assert.assertEquals(getText(QP.Assess_lbel), "Assessment Name:" + " " + Assessment_name);
		Assert.assertEquals(getText(QP.course_label), "Course:");
		Assert.assertTrue(isElementPresent(QP.course_name), "Course name and code are not present");
		// Assert the Course name is same as created course name
		Assert.assertEquals(getText(QP.course_name), "Course: " + CourseID + ", " + CourseName.trim());
		Assert.assertTrue(isElementPresent(QP.quest_bankcheckbx), "Add to question bank check box not visible");

	}

	/*
	 * To check the basic functionalities of all buttons in question page
	 */
	@Test(priority = 12)
	public void TCSPR090312() {
		Assert.assertTrue(isElementPresent(QP.import_quest), "Import Question Bank button not present");
		Assert.assertTrue(isEnabled(QP.import_quest), "Import Question bank button is not enabled");
		Assert.assertTrue(isElementPresent(QP.clear_all), "Clear All button not present");
		Assert.assertTrue(isElementPresent(QP.max_scorelabl), "Max Score label is not present");
		Assert.assertTrue(isElementPresent(QP.max_scorbx), "Max score field is not present");
		Assert.assertTrue(isElementPresent(QP.save), "Save button is not present");
		Assert.assertTrue(isEnabled(QP.save), "Save button is not enabled");

	}

	/*
	 * To check the tooltips of Questions Page
	 */
	@Test(priority = 13)
	public void TCSPR090313() {
		Assert.assertEquals(getAttribute(QP.Add_more_Quest, "ptooltip"), "Add More Questions");

		Assert.assertEquals(getAttribute(QP.saveexit_tool, "ptooltip"),
				"Saves any current changes to the information on this screen and returns to the main Assessments screen");

		Assert.assertEquals(getAttribute(QP.savenext_tool, "ptooltip"),
				"Saves all changes to the current screen, if any, then proceeds to the next screen in the ‘Assessment Creation’ process");
		// Assert discard button present
		Assert.assertTrue(isElementPresent(QP.discard_btn), "Discard button not present");

		// Assert the Save&Next,Save&Exit,+ button, Clear All, Save buttons
		Assert.assertTrue(isElementPresent(QP.savexit_btn), "Save&Exit  button not present");
		Assert.assertTrue(isElementPresent(QP.savenext_btn), "Save&Next button not present");
		Assert.assertTrue(isElementPresent(QP.plus_btn), "Add more questions button not present");
		Assert.assertTrue(isElementPresent(QP.clear_all), "Clear All button not present");

	}

	/*
	 * To Add Category functionalities on question page
	 */
	@Test(priority = 14)
	public void TCSPR090314() {

		Assert.assertTrue(isElementPresent(QP.lbladdtoQnBank), "Add to question bank label not present");
		click(QP.quest_bankcheckbx);
		waitThread(3000);
		// Click Select category dropdown
		click(QP.cat_drop);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(QP.cat_drop), "Select category dropdown box not present");
		Assert.assertTrue(isEnabled(QP.cat_drop), "Category dropdown not enabled");

		// Assert the Search box
		Assert.assertTrue(isElementPresent(QP.cat_searchbox), "Category search box not present");
		click(QP.cat_searchbox);
		// Assert Create a new Category text
		Assert.assertTrue(getAttribute(QP.chkSelect_Category, "class").contains("disabled"));

		// Assert.assertFalse(isEnabled(QP.chkSelect_Category), "Select Category
		// check
		// box is enabled");
		Assert.assertTrue(isEnabled(QP.srchIcon_selectCat), "Search icon not enabled");

	}

	/*
	 * To check Create a new category functionalities on Select category
	 * dropdown
	 */
	@Test(priority = 15)
	public void TCSPR090315() {
		Assert.assertEquals(getText(QP.creat_newcat), "Create a new Category");
		waitThread(2000);
		// Click on Create a new Category
		click(QP.creat_cat);

		// Assert Create Category box visible
		Assert.assertTrue(isElementPresent(QP.cat_pop), " Create Category popup not visible");
		waitThread(1000);
		// Assert Create button
		Assert.assertEquals(getText(QP.catpop_creatbtn), "Create");
		Assert.assertEquals(getText(QP.lblCreate_Catnew), "Create Category");
		Assert.assertEquals(getText(QP.lblName), "Name");
		Assert.assertTrue(isEnabled(QP.catpop_creatbtn), "Create button not enabled");
		click(QP.btn_CloseCreateCat);
		waitThread(2000);
		Assert.assertFalse(isElementPresent(QP.btn_CloseCreateCat), "Close tab is visible");
		Assert.assertFalse(isEnabled(QP.remove_quest), "Remove Qn tab is enabled");

	}

	/*
	 * To check the Placeholders of Question page- Question box
	 */
	@Test(priority = 16)
	public void TCSPR090316() {
		Assert.assertTrue(getAttribute(QP.txtQn_Accord, "aria-expanded").contains("true"));
		Assert.assertTrue(isEnabled(QP.txtQn_Accord), "Accordian drop down is enabled");
		driver.switchTo().frame("question_ifr");
		Assert.assertTrue(getAttribute(QP.lblEnter_Qn, "aria-placeholder").contains("Enter Question"));
		driver.switchTo().defaultContent();
		waitThread(2000);

	}

	/*
	 * To check add rubric details on question page
	 */

	@Test(priority = 17)
	public void TCSPR090317() {

		Assert.assertTrue(isElementPresent(QP.lblAdd_Rubric), "Add rubric label not present");
		Assert.assertEquals(getText(QP.lblRubric_InfoStmt),
				"Rubrics will be displayed to the students during the peer-review phase only");
		Assert.assertTrue(isElementPresent(QP.lbl_SelctRubricEdtr), "Select rubric Editor label not present");
		Assert.assertTrue(isElementPresent(QP.click_radio), "Clickable rubric radio button not present");
		Assert.assertTrue(isElementPresent(QP.std_rubcheck), "Standard rubric radio button not present");
		Assert.assertTrue(getAttribute(QP.std_rubcheck, "class").contains("checked"));
		Assert.assertTrue(getAttribute(QP.txtStdRubric_Accord, "aria-expanded").contains("true"));
		driver.switchTo().frame("rubric_ifr");
		Assert.assertEquals(getAttribute(QP.txtStdRubric_Editr1, "aria-placeholder"),
				"Enter/upload Rubric (image or pdf), and this will be displayed to the students during the peer-review phase. This helps the students to evaluate other's answers.");
		driver.switchTo().defaultContent();
		waitThread(2000);
	}

	/*
	 * To check Clickable rubric functionalities in question page
	 */

	@Test(priority = 18)
	public void TCSPR090318() {
		click(QP.click_radio);
		waitThread(1000);
		Assert.assertEquals(getText(QP.lblEmptyRubric_Msg), "No Rubric Created !");
		Assert.assertTrue(isDisplayed(QP.add_column), "Add column button is not present");
		Assert.assertTrue(isDisplayed(QP.remov_lastcolum), "Remove last column button is not present");
		Assert.assertTrue(isDisplayed(QP.add_row), "Add Row button is not present");
		Assert.assertTrue(isDisplayed(QP.remov_lastrw), "Remove last row button is not present");
		Assert.assertTrue(isEnabled(QP.add_column), "Add Column button is not enabled");
		Assert.assertFalse(isEnabled(QP.remov_lastcolum), "Remove last column button is enabled");
		Assert.assertFalse(isEnabled(QP.add_row), "Add Row button is enabled");
		Assert.assertFalse(isEnabled(QP.remov_lastrw), "Remove last row button is enabled");

	}

	/*
	 * To check Sample Answer functionalities on question page
	 */

	@Test(priority = 19)
	public void TCSPR090319() {

		Assert.assertTrue(isElementPresent(QP.lblSampleAns_Accord), "Sample Answer label not present");
		Assert.assertEquals(getText(QP.lblSampleAns_InfoStmt),
				"Sample answers will be displayed to the students during the peer-review phase only");
		Assert.assertTrue(getAttribute(QP.expandSampleAns_Accord, "aria-expanded").contains("true"));
		Assert.assertTrue(isElementPresent(QP.btnSampleAns_Dropdown), "Sample Answer drop down button not present");
		driver.switchTo().frame("sampleAnswer_ifr");
		// Assert.assertEquals(getAttribute(QP.txtSampleAns_Editr1,
		// "aria-placeholder"),
		// "Enter a sample answer, so that a student will get more insight on
		// the correct/expected answer from the teacher you. This will be
		// displayed to the students during the peer-review phase only.");
		driver.switchTo().defaultContent();
		waitThread(2000);

	}

	/*
	 * To check the labels and buttons of Select category dropdown
	 */
	@Test(priority = 20)
	public void TCSPR090320() {

		// ScrollTo_Location(QP.savenext_btn);
		// Scroll Up page
		// JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("window.scrollBy(0,350)", "");
		// waitThread(5000);
		// QP.ScrollUp();
		// click(QP.quest_bankcheckbx);
		// waitThread(3000);
		// click(QP.quest_bankcheckbx);
		// waitThread(3000);
		// QP.ScrollUp();
		QP.ScrollHome();
		waitThread(3000);
		// Actions a=new Actions(driver);
		// a.sendKeys(Keys.PAGE_UP).build().perform();
		// click(QP.quest_bankcheckbx);
		// waitThread(3000);
		// click(QP.quest_bankcheckbx);
		// waitThread(3000);
		// Page scroll up
		// JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("window.scrollTo(0,document.body.scrollTop)");

		// Assert.assertTrue(getAttribute(QP.chkAdd_QnBank,
		// "class").contains("checked"));
		// Assert.assertTrue(isEnabled(QP.cat_drop), "Category dropdown not
		// enabled");
		// Click Select category dropdown
		click(QP.cat_drop);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(QP.cat_drop), "Select category dropdown box not present");
		// Assert the Search box
		Assert.assertTrue(isElementPresent(QP.cat_searchbox), "Category search box not present");

	}

	/*
	 * To check Create a new category functionalities on question page
	 */
	@Test(priority = 21)
	public void TCSPR090321() {
		// Assert.assertEquals(getText(QP.creat_newcat), "Create a new
		// Category");
		waitThread(2000);
		// Click on Create a new Category
		click(QP.creat_cat);
		waitThread(1000);
		// Assert Create Category box visible
		Assert.assertTrue(isElementPresent(QP.cat_pop), " Create Category popup not visible");
		Assert.assertEquals(getText(QP.lblCreate_Catnew), "Create Category");

		String categoryname = "Category one" + generateRandomData().trim();
		// Type category name
		type(QP.cat_textbox, categoryname);
		waitThread(3000);
		Assert.assertEquals(getText(QP.lblName), "Name");
		// Assert Create button
		Assert.assertEquals(getText(QP.catpop_creatbtn), "Create");
		Assert.assertTrue(isEnabled(QP.catpop_creatbtn), "Create button not enabled");

		// Click Create button
		click(QP.catpop_creatbtn);

		waitFor(QP.toaster);
		// Assert toaster "Added to the question bank"
		Assert.assertEquals(getText(QP.toaster), "Added to the question bank");
		click(QP.toasterclosebtn);

		waitThread(2000);
		// Assert the created category visible on page
		Assert.assertTrue(isElementPresent(QP.added_cat), "Added category not visible");
		Assert.assertEquals(getText(QP.added_cat), categoryname);
		// Click Select category dropdown
		click(QP.cat_drop);
		waitThread(2000);
		Assert.assertEquals(getText(QP.ddlSelect_CreatedCategory), categoryname);
		click(QP.btnClose_SelectCategory);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(QP.btnClose_SelectCategory));

	}

	String question;

	/*
	 * To check the mandatory toasters of Question page of rubrics section
	 */
	@Test(priority = 22)
	public void TCSPR090322() {
		// click on Question box
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		question = "Question1" + generateRandomData().trim();
		// Type a question on Question box
		type(QP.Quest_box, question);
		Assert.assertEquals(getText(QP.Quest_box), question);
		driver.switchTo().defaultContent();

		waitThread(3000);
		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster),
				"Please enter the 'Max Score' and either the Rubric or Sample Answer(or both)");
		click(QP.toasterclosebtn);

		waitThread(4000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the warning message "Please enter the Rubric"
		Assert.assertEquals(getText(QP.toaster),
				"Please enter the 'Max Score' and either the Rubric or Sample Answer(or both)");
		click(QP.toasterclosebtn);
		waitThread(4000);
		// Click Save & Exit button
		click(QP.savexit_btn);

		waitFor(QP.toaster);
		// Assert the warning message "Please enter the mandatory fields in
		// Rubrics"
		Assert.assertEquals(getText(QP.toaster),
				"Please enter the 'Max Score' and either the Rubric or Sample Answer(or both)");
		click(QP.toasterclosebtn);

	}

	/*
	 * To check the Discard button functionality in Questions page after the
	 * edit
	 */
	@Test(priority = 23)
	public void TCSPR090323() {
		click(QP.discard_btn);
		waitThread(2000);
		// Assert a Confirmation popup visible
		Assert.assertTrue(isElementPresent(QP.discard_btn_conf_popup), "Confirmation popup not visible");

		waitThread(4000);
		// Assert the Text on popup "Are you sure you want to proceed with your
		// action?We detected you have made changes to the information on this
		// screen
		// and if you ‘Discard’ these changes will not be saved."
		Assert.assertEquals(getText(QP.text_confirm), "Are you sure you want to proceed with your action?\n"
				+ "We detected you have made changes to the information on this screen and if you ‘Discard’ these changes will not be saved.");

		waitThread(2000);
		// Assert the Cancel & Discard buttons on popup
		Assert.assertTrue(isDisplayed(QP.discardbtn_popup_cancel), "Cancel button not present");
		Assert.assertEquals(getText(QP.discardbtn_popup_cancel), "Cancel");

		Assert.assertTrue(isDisplayed(QP.discardbtn_popup_dis), "Discard button not present");
		Assert.assertEquals(getText(QP.discardbtn_popup_dis), "Discard");

		// Assert Close button on popup
		Assert.assertTrue(isDisplayed(QP.discardbtn_popup_close), "Close button not present");

	}

	/*
	 * To check the function of Close & Cancel buttons on confirmation popup of
	 * Discard button
	 */
	@Test(priority = 24)
	public void TCSPR090324() {
		// Assert Confirmation Label
		Assert.assertEquals(getText(QP.confir_label), "Confirmation");

		waitThread(2000);
		// Click Close button on popup
		click(QP.discardbtn_popup_close);

		waitThread(3000);
		// Assert No popup visible
		Assert.assertFalse(isElementPresent(QP.discard_btn_conf_popup), "Confirmation popup not visible");

		// Assert the added Question on the question box
		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), question);
		driver.switchTo().defaultContent();

		// Click Discard button
		click(QP.discard_btn);

		// Assert a Confirmation popup visible
		Assert.assertTrue(isElementPresent(QP.discard_btn_conf_popup), "Confirmation popup not visible");

		// Assert the Text on popup "Are you sure you want to proceed with your
		// action?We detected you have made changes to the information on this
		// screen
		// and if you ‘Discard’ these changes will not be saved."

		waitFor(QP.text_confirm);
		Assert.assertEquals(getText(QP.text_confirm), "Are you sure you want to proceed with your action?\n"
				+ "We detected you have made changes to the information on this screen and if you ‘Discard’ these changes will not be saved.");

		waitThread(2000);
		// Click Cancel button on popup
		click(QP.discardbtn_popup_cancel);

		waitThread(3000);
		// Assert No popup visible
		Assert.assertFalse(isElementPresent(QP.discard_btn_conf_popup), "Confirmation popup not visible");

	}

	/*
	 * To check whether the added datas are discarded when click on Discard
	 * button on popup
	 */
	@Test(priority = 25)
	public void TCSPR090325() {
		// Click Discard button
		click(QP.discard_btn);

		waitThread(2000);
		// Assert a Confirmation popup visible
		Assert.assertTrue(isElementPresent(QP.discard_btn_conf_popup), "Confirmation popup not visible");

		waitThread(2000);
		// Click Discard button on popup
		click(QP.discardbtn_popup_dis);

		waitThread(3000);
		// Assert the label "Assessments"
		Assert.assertEquals(getText(QP.Assessments), "Assessments");

		// Click draft button
		click(QP.tabdraft);

		// Assert the created Assessment name visible on grid
		Assert.assertEquals(getText(QP.assessment_draftgrid), Assessment_name);

		// Click continue editing
		click(QP.continue_edit);

		waitThread(2000);
		// Assert the Basic details label on Wizard
		Assert.assertEquals(getText(QP.basic_detls_wizard), "Basic Details");

		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(2000);
		// Assert Question box is empty
		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), "");
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Assert No category visible on Page
		Assert.assertFalse(isElementPresent(QP.added_cat), "Added category is present");

	}

	/*
	 * To check whether discard changes popup display when switching to
	 * Assessment tab without saving the edited page
	 */
	@Test(priority = 26)
	public void TCSPR090326() {

		click(QP.quest_bankcheckbx);
		waitThread(3000);
		// Enter Question
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		type(QP.Quest_box, question);
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Assessments tab
		click(QP.teach_assesstab);

		waitThread(2000);
		// Assert the Discard popup displayed
		waitFor(QP.discard_pop);
		Assert.assertTrue(isDisplayed(QP.discard_pop), "Discard popup not displayed");

		waitThread(4000);
		// Assert text "Are you certain you want to proceed with your action?Any
		// changes
		// that you have made will not be saved."
		Assert.assertEquals(getText(QP.discard_changes_popuptxt),
				"Are you certain you want to proceed with your action?\n"
						+ "Any changes that you have made will not be saved.");

		waitThread(2000);
		// Assert Cancel button
		Assert.assertEquals(getText(QP.dis_pop_cancel_btn), "Cancel");

		// Click Cancel button on popup
		click(QP.dis_pop_cancel_btn);

		waitThread(2000);
		// Assert the edited question visible in Question box
		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), question);
		driver.switchTo().defaultContent();

		// Click Assessments tab
		click(QP.teach_assesstab);

		// Assert the Discard popup displayed
		waitFor(QP.discard_pop);
		Assert.assertTrue(isDisplayed(QP.discard_pop), "Discard popup not displayed");

		// Click Discard button on popup
		click(QP.dis_pop_discard_btn);

		waitThread(3000);
		// Assert the label Assessments
		Assert.assertEquals(getText(QP.Assessments), "Assessments");

		// Click draft button
		click(QP.tabdraft);
		// search Assessment
		type(QP.draftsearchbx, Assessment_name);
		waitThread(2000);

		// Click continue editing
		click(QP.continue_edit);

		waitThread(2000);
		// Assert the Basic details label on Wizard
		Assert.assertEquals(getText(QP.basic_detls_wizard), "Basic Details");

		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(2000);
		// Assert the question label on wizard
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");
		click(QP.quest_bankcheckbx);
		// waitThread(3000);

		// Assert Question box is empty
		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), "");
		driver.switchTo().defaultContent();

		waitThread(2000);

	}

	/*
	 * To check Standard Rubric functionalites
	 */
	@Test(priority = 27)
	public void TCSPR090327() {
		Assert.assertTrue(isElementPresent(QP.lblAdd_Rubric), "Add rubric label not present");
		Assert.assertTrue(isElementPresent(QP.std_rubcheck), "Standard rubric radio button not present");
		Assert.assertTrue(getAttribute(QP.std_rubcheck, "class").contains("checked"));
		driver.switchTo().frame("rubric_ifr");
		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "Standard 1");

		driver.switchTo().defaultContent();
		waitThread(3000);
		click(QP.std_rubcheck);
		// ScrollTo_xy_position(0, 0);
		// ScrollTo_Location(QP.savenext_btn);
		// waitThread(2000);
		// click(QP.quest_bankcheckbx);
		// waitThread(3000);
		// click(QP.quest_bankcheckbx);
		// waitThread(3000);
		// Actions actions=new Actions(driver);
		// a.sendKeys(Keys.PAGE_UP).build().perform();
		// click(QP.max_scorbx);
		// JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("scroll(0, -250);");

		// Assert the "Save button"
		// actions.sendKeys(Keys.HOME).build().perform();
		QP.ScrollHome();
		waitThread(2000);

		Assert.assertEquals(getText(QP.save), "Save");
		// QP.ScrollUp();

		waitThread(3000);
		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert the toaster "Please enter the Question and Score"
		// Assert.assertEquals(getText(QP.toaster), "Please enter the Question,
		// 'Max Score' and Question Bank Category");
		click(QP.toasterclosebtn);
		waitThread(2000);

	}

	/*
	 * To check Clickable Rubric continue editing functionalities
	 */
	@Test(priority = 28)
	public void TCSPR090328() {

		click(QP.click_radio);
		waitThread(2000);
		Assert.assertTrue(isDisplayed(QP.popConfirm_Rubric), "Confirmation pop up is not visible");
		Assert.assertEquals(getText(QP.lblPopConfirm_Rubric), "Changes you made may not be saved.");
		Assert.assertEquals(isEnabled(QP.btnPopConfirm_RubricDiscard), true);
		Assert.assertEquals(isEnabled(QP.btnPopConfirm_RubricContinue), true);
		click(QP.btnPopConfirm_RubricContinue);
		waitThread(2000);
		Assert.assertTrue(getAttribute(QP.std_rubcheck, "class").contains("checked"));
		driver.switchTo().frame("rubric_ifr");
		Assert.assertEquals(getText(QP.std_rub_bx), "Standard 1");
		driver.switchTo().defaultContent();
		waitThread(1000);

	}

	/*
	 * To check Clickable Rubric discard functionalities
	 */
	@Test(priority = 29)
	public void TCSPR090329() {
		click(QP.click_radio);
		waitThread(2000);
		Assert.assertTrue(isDisplayed(QP.popConfirm_Rubric), "Confirmation pop up is not visible");
		Assert.assertEquals(getText(QP.lblPopConfirm_Rubric), "Changes you made may not be saved.");
		Assert.assertEquals(isEnabled(QP.btnPopConfirm_RubricDiscard), true);
		Assert.assertEquals(isEnabled(QP.btnPopConfirm_RubricContinue), true);
		click(QP.btnPopConfirm_RubricDiscard);
		waitThread(2000);
		Assert.assertEquals(getText(QP.lblEmptyRubric_Msg), "No Rubric Created !");
	}

	/*
	 * To check the functionalities of Add Column in Clickable Rubric
	 */
	@Test(priority = 30)
	public void TCSPR090330() {
		// Click Add column button
		click(QP.add_column);
		// To check the labels in clickable rubric box
		// Assert the labels-Criteria1,Score for column 1
		Assert.assertEquals(getText(ck.criteria1_lbl), "Criteria 1");
		Assert.assertEquals(getText(ck.score_fr_column1_lbl), "Score for Column 1");
		// To check the placeholders in the Clickable rubric
		// Assert the placeholders Enter criteria1,Enter Score, Enter condition
		Assert.assertEquals(getAttribute(ck.criteria1_place, "placeholder"), "Enter Criteria 1");
		Assert.assertEquals(getAttribute(ck.enter_scr, "placeholder"), "Enter Score");
		driver.switchTo().frame(1);
		waitThread(2000);
		Assert.assertEquals(getAttribute(ck.clic_rub_place, "aria-placeholder"), "Enter Condition");
		driver.switchTo().defaultContent();
	}

	/*
	 * To check the functionalities of Delete Column in Clickable Rubric
	 */
	@Test(priority = 31)
	public void TCSPR090331() {

		Assert.assertEquals(isEnabled(QP.remov_lastcolum), true);
		// click on Remove column button
		click(QP.remov_lastcolum);
		waitThread(2000);
		// Assert the Confirmation popup visible
		Assert.assertTrue(isDisplayed(ck.confirm_pop), "Confirmation popup not displayed");
		Assert.assertTrue(isElementPresent(ck.lblpopConfirm_RemvLstColm), "Confirmation popup label not present");
		Assert.assertEquals(getText(ck.lblpopConfirm_RemvLstColm),
				"Are you sure that you want to remove the last column(s)?");
		// Click No button
		click(ck.No_btn);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(ck.criteria1_lbl), "Criteria 1 label is not present");
		Assert.assertTrue(isElementPresent(ck.score_fr_column1_lbl), "Score for Column 1 label is not present");

	}

	/*
	 * To check the functionalities of Remove last column
	 */
	@Test(priority = 32)
	public void TCSPR090332() {
		click(QP.remov_lastcolum);
		waitThread(2000);
		click(ck.yes_btn);
		waitFor(cn.toaster);
		Assert.assertEquals(getText(cn.toaster).trim(), "Removed successfully");
		Assert.assertFalse(isElementPresent(ck.criteria1_lbl), "Criteria 1 label is present");
		Assert.assertFalse(isElementPresent(ck.score_fr_column1_lbl), "Score for Column 1 label is present");

	}

	/*
	 * To check the functionalities of Add Row
	 */
	@Test(priority = 33)
	public void TCSPR090333() {
		// Assert the clickable rubric radio button is enabled
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		waitThread(2000);
		// Click Add column button
		click(QP.add_column);
		// Click Row button
		click(QP.add_row);
		Assert.assertEquals(getText(ck.criteria2_lbl), "Criteria 2");
		waitThread(1000);
		Assert.assertEquals(getAttribute(QP.placeholdrEntr_Criteria2, "placeholder"), "Enter Criteria 2");
		Assert.assertEquals(getText(QP.lblScoreCol1_Criteria2), "Score for Column 1");
		Assert.assertEquals(getAttribute(QP.lblEnterScore_Criteria2, "placeholder"), "Enter Score");
		// Assert the new row added is visible
		driver.switchTo().frame(2);
		waitThread(2000);
		Assert.assertEquals(getAttribute(ck.clic_rub_place, "aria-placeholder"), "Enter Condition");

		driver.switchTo().defaultContent();

	}

	/*
	 * To check the Remove Last Row buttons functionality
	 */
	@Test(priority = 34)
	public void TCSPR090334() {
		Assert.assertEquals(isEnabled(QP.remov_lastrw), true);
		click(QP.remov_lastrw);
		waitThread(3000);
		Assert.assertTrue(isDisplayed(ck.confirm_pop), "Confirmation popup not displayed");
		Assert.assertEquals(getText(QP.lblPopConfirm_Rubric), "Are you sure that you want to remove the row?");
		click(QP.no_btn);
		waitThread(2000);
		Assert.assertEquals(getText(ck.criteria2_lbl), "Criteria 2");
		Assert.assertEquals(getText(QP.lblScoreCol1_Criteria2), "Score for Column 1");
		click(QP.remov_lastrw);
		waitThread(3000);
		click(ck.yes_btn);
		waitFor(cn.toaster);
		Assert.assertEquals(getText(cn.toaster).trim(), "Removed successfully");
	}

	/*
	 * To check the max row limit
	 */
	@Test(priority = 35)
	public void TCSPR090335() {
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
		// click(QP.toasterclosebtn);
		waitThread(2000);
	}

	/*
	 * To check the max column limit
	 */
	@Test(priority = 36)
	public void TCSPR090336() {
		// Scroll Up page
		// JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("scroll(0, -250);");
		// QP.ScrollUp();
		// click(QP.click_radio);
		QP.ScrollHome();
		// click(QP.click_radio);
		waitThread(2000);
		// ScrollTo_Location(QP.add_column);
		QP.ScrollDown();
		waitThread(2000);
		// To check the max column limit

		for (int i = 2; i <= 6; i++) {

			// Click Add Column button
			click(QP.add_column);
			driver.switchTo().frame(i);
			waitThread(2000);
			Assert.assertEquals(getAttribute(ck.clic_rub_place, "aria-placeholder"), "Enter Condition");
			driver.switchTo().defaultContent();
		}
		waitThread(2000);

		// Click Add Column button
		click(QP.add_column);

		waitFor(QP.toaster);
		// Assert the toaster "Max column limit reached"
		Assert.assertEquals(getText(QP.toaster), "Max column limit reached");
		click(QP.toasterclosebtn);

	}

	/*
	 * To check clickable rubric toasters
	 */
	@Test(priority = 37)
	public void TCSPR090337() {
		click(QP.std_rubcheck);
		waitThread(2000);

		click(QP.Confirm_btnYes);
		waitThread(2000);
		click(QP.click_radio);
		waitThread(2000);
		// click(QP.Confirm_btnYes);
		// waitThread(2000);
		click(QP.add_column);
		waitThread(2000);

		QP.ScrollHome();
		waitThread(2000);
		click(QP.save);
		waitFor(QP.toaster);
		// Assert.assertEquals(getText(QP.toaster),
		// "Please enter the Question, 'Max Score', either the Rubric or Sample
		// Answer(or both) and Question Bank Category");
		// click(QP.toasterclosebtn);
		waitThread(4000);
		QP.ScrollDown();
		waitThread(2000);
		// Enter score for column 1 as zero
		type(ck.scre_col1, "0");
		waitThread(5000);
		click(QP.std_rubcheck);
		waitThread(2000);
		click(QP.btnPopConfirm_RubricContinue);
		waitThread(2000);
		QP.ScrollHome();
		waitThread(2000);

		click(QP.save);
		waitFor(QP.toaster);
		// Assert.assertEquals(getText(QP.toaster),
		// "Please enter the Question, score greater than zero as 'Max Score',
		// either the Rubric or Sample Answer(or both) and Question Bank
		// Category");
		// click(QP.toasterclosebtn);
		waitThread(2000);

	}

	/*
	 * To check Clickable rubric toaster functionalities
	 */

	@Test(priority = 38)
	public void TCSPR090338() throws InterruptedException {
		// Enter criteria 1
		QP.ScrollDown();
		waitThread(2000);
		type(ck.crit1_bx, "Check 1");
		waitThread(1000);
		click("//*[@id='rubricMainTable']/tbody/tr/th/p/span");
		waitThread(5000);
		QP.ScrollUp();
		waitThread(5000);
		click(QP.std_rubcheck);

		waitThread(2000);
		click(QP.std_rubcheck);
		waitThread(5000);
		click(QP.btnPopConfirm_RubricContinue);
		waitThread(3000);
		QP.ScrollHome();
		waitThread(2000);
		click(QP.save);

		// Assert double toasters
		waitFor(QP.toasterRubric1);

		Assert.assertEquals(getText(QP.toasterRubric1),
				"Please enter the Question and Question Bank Category and number greater than zero on score for 'column 1' in Criteria 1");
		waitFor(QP.toasterRubric2);
		Assert.assertEquals(getText(QP.toasterRubric2), "Please enter the Condition for 'Column 1' in Criteria 1");
		waitThread(6000);
		QP.ScrollDown();
		waitThread(2000);
		type(ck.scre_col1, "10");
		waitThread(2000);
		click(QP.std_rubcheck);
		waitThread(2000);
		click(QP.btnPopConfirm_RubricContinue);
		waitThread(2000);
		QP.ScrollHome();
		waitThread(2000);
		click(QP.save);

		// Assert double toasters
		waitFor(QP.toasterRubric1);
		Assert.assertEquals(getText(QP.toasterRubric1), "Please enter the Question and Question Bank Category");
		waitFor(QP.toasterRubric2);
		Assert.assertEquals(getText(QP.toasterRubric2), "Please enter the Condition for 'Column 1' in Criteria 1");
		waitThread(6000);
		QP.ScrollDown();
		waitThread(2000);
		// ScrollTo_xy_position(0, 700);

		// Enter condition for 1st column
		driver.switchTo().frame("editorFieldRubric_00_ifr");
		waitThread(2000);
		type(ck.clic_rub_place, "Test 1");
		waitThread(2000);
		driver.switchTo().parentFrame();
		waitThread(2000);
		click(QP.std_rubcheck);
		waitThread(2000);
		click(QP.btnPopConfirm_RubricContinue);

		waitThread(2000);
		QP.ScrollHome();
		waitThread(2000);
		click(QP.save);
		waitThread(1000);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Please enter the Question and Question Bank Category");
		click(QP.toasterclosebtn);
		waitThread(2000);
		// Click Row button
		click(QP.add_row);
		waitThread(2000);
		type(QP.placeholdrEntr_Criteria2, "Check 2");
		waitThread(2000);
		type(QP.lblEnterScore_Criteria2, "10");
		waitThread(2000);
		driver.switchTo().frame(2);
		waitThread(2000);
		type(ck.clic_rub_place, "Test 2");
		// driver.switchTo().defaultContent();

		waitThread(2000);
		driver.switchTo().parentFrame();
		waitThread(5000);
		// String parent=driver.getWindowHandle();
		// driver.switchTo().window(parent);
		// WebElement e=find(QP.save);
		// new Actions(driver).moveToElement(e);
		waitThread(2000);
		click(ck.criteria2_lbl);
		waitThread(5000);
		QP.ScrollHome();

		click(QP.save);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Please enter the Question and Question Bank Category");
		click(QP.toasterclosebtn);
		waitThread(2000);

	}

	/*
	 * To check Clickable rubric toaster Add column and row functionalities
	 */
	@Test(priority = 39)
	public void TCSPR090339() {
		click(QP.remov_lastcolum);
		waitThread(2000);
		click(ck.yes_btn);
		waitFor(cn.toaster);
		Assert.assertEquals(getText(cn.toaster).trim(), "Removed successfully");
		click(QP.toasterclosebtn);
		waitThread(2000);
		// Click Add column button
		click(QP.add_column);
		waitThread(2000);

		click(QP.std_rubcheck);
		waitThread(2000);
		click(QP.btnPopConfirm_RubricContinue);
		waitThread(2000);
		QP.ScrollHome();
		waitThread(2000);

		click(QP.save);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster),
				"Please enter the Question, score greater than zero as 'Max Score', either the Rubric or Sample Answer(or both) and Question Bank Category");
		click(QP.toasterclosebtn);
		waitThread(2000);

	}

	/*
	 * To check the Rows and Column score validation
	 */
	@Test(priority = 40)
	public void TCSPR090340() {
		click(ck.scre_col1);
		waitThread(2000);
		click(ck.crit1_bx);
		waitThread(2000);
		Assert.assertEquals(getText(QP.lblValidation_Score), "*Score range should be 0-20");
		click(ck.criteria1_lbl);
		waitThread(2000);
		QP.ScrollHome();
		click(QP.save);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster),
				"Please enter the Question, score greater than zero as 'Max Score', either the Rubric or Sample Answer(or both) and Question Bank Category");
		click(QP.toasterclosebtn);
		waitThread(2000);

	}

	/*
	 * To check standard rubric and question page functionalities
	 */
	@Test(priority = 41)
	public void TCSPR090341() {
		// Click Select category dropdown
		click(QP.cat_drop);
		waitThread(2000);
		click(QP.ddlSelect_CreatedCategory);
		waitThread(2000);
		click(QP.btnClose_SelectCategory);
		waitThread(1000);
		// Assert Question box is empty
		driver.switchTo().frame("question_ifr");
		type(QP.lblEnter_Qn, "Question1" + generateRandomData().trim());
		driver.switchTo().defaultContent();
		click(QP.save);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster),
				"Please enter the score greater than zero as 'Max Score' and either the Rubric or Sample Answer(or both)");
		click(QP.toasterclosebtn);
		waitThread(2000);
		click(QP.std_rubcheck);
		waitThread(2000);
		click(QP.btnPopConfirm_RubricDiscard);
		waitThread(2000);
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);
		type(QP.std_rub_bx, "Standard 1");
		driver.switchTo().defaultContent();
		waitThread(5000);
		// JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("scroll(0, -250);");
		click(QP.click_radio);
		waitThread(2000);
		click(QP.btnPopConfirm_RubricContinue);

		waitThread(2000);
		QP.ScrollHome();
		waitThread(2000);
		click(QP.save);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Please enter the 'Max Score'");
		click(QP.toasterclosebtn);
		waitThread(2000);
	}

	/*
	 * To check the Question field ,Category and Clickable rubric validation
	 * toasters
	 */
	@Test(priority = 42)
	public void TCSPR090342() {
		click(QP.click_radio);
		waitThread(2000);
		click(QP.btnPopConfirm_RubricDiscard);
		waitThread(2000);
		// Click Add column button
		click(QP.add_column);
		waitThread(2000);

		QP.ScrollHome();
		waitThread(2000);
		click(QP.save);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster),
				"Please enter the 'Max Score' and either the Rubric or Sample Answer(or both)");
		click(QP.toasterclosebtn);
		waitThread(2000);
		// Enter criteria 1
		type(ck.crit1_bx, "Check 1");
		waitThread(2000);
		type(ck.scre_col1, "10");
		waitThread(2000);
		// Enter condition for 1st column
		driver.switchTo().frame("editorFieldRubric_00_ifr");

		waitThread(2000);
		type(ck.clic_rub_place, "Test 1");
		driver.switchTo().defaultContent();
		waitThread(2000);
	}

	/*
	 * To check the Question field ,Category and Clickable rubric Score for
	 * Column 2 validation toasters
	 */
	@Test(priority = 43)
	public void TCSPR090343() {
		click(ck.criteria1_lbl);
		waitThread(2000);

		QP.ScrollHome();
		waitThread(2000);
		QP.ScrollDown();
		waitThread(2000);
		// Click Add column button
		click(QP.add_column);
		waitThread(2000);
		type(ck.scre_col2, "10");
		waitThread(2000);
		// Enter condition for 2nd column
		driver.switchTo().frame("editorFieldRubric_01_ifr");
		waitThread(2000);
		type(ck.clic_rub_place, "Test 2");
		driver.switchTo().defaultContent();
		waitThread(2000);
		// Click Row button
		click(QP.add_row);
		waitThread(2000);
		Assert.assertEquals(getText(ck.criteria2_lbl), "Criteria 2");
		Assert.assertEquals(getValue(ck.scrore_r21), "10");
		Assert.assertEquals(getValue(ck.score_r22), "10");
		type(QP.placeholdrEntr_Criteria2, "Check 2");
		waitThread(2000);
	}

	/*
	 * To fill details of criteria 2 for validation
	 */
	@Test(priority = 44)
	public void TCSPR090344() {
		// Enter condition
		driver.switchTo().frame("editorFieldRubric_10_ifr");
		waitThread(2000);
		type(ck.clic_rub_place, "Test 3");
		driver.switchTo().defaultContent();
		waitThread(2000);
		// Enter condition
		driver.switchTo().frame("editorFieldRubric_11_ifr");
		waitThread(2000);
		type(ck.clic_rub_place, "Test 4");
		driver.switchTo().defaultContent();
		waitThread(2000);
		click(ck.criteria2_lbl);
		waitThread(2000);

		QP.ScrollHome();
		waitThread(2000);
		// JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("scroll(0, -250);");

		click(QP.save);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);
		waitThread(2000);
	}

	/*
	 * To check Max. Score functionalities
	 */
	@Test(priority = 45)
	public void TCSPR090345() {

		click(QP.plus_btn);
		waitThread(2000);
		click(QP.chkbx_questionbank);
		waitThread(1000);
		type(QP.max_scorbx, "20");
		waitThread(2000);
		click(QP.save);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster),
				"Please enter the Question, either the Rubric or Sample Answer(or both) and Question Bank Category");
		click(QP.toasterclosebtn);
		waitThread(2000);
	}

	/*
	 * To check Max. Score and select category , Question functionalities
	 */
	@Test(priority = 46)
	public void TCSPR090346() {
		// Click Select category dropdown
		click(QP.cat_drop);
		waitThread(2000);
		click(QP.ddlSelect_CreatedCategory);
		waitThread(2000);
		click(QP.btnClose_SelectCategory);
		waitThread(1000);
		click(QP.save);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster),
				"Please enter the Question and either the Rubric or Sample Answer(or both)");
		click(QP.toasterclosebtn);
		waitThread(2000);
		// click on Question box
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		// Type a question on Question box
		type(QP.Quest_box, "Question2" + generateRandomData().trim());
		driver.switchTo().defaultContent();
		waitThread(3000);
		click(QP.save);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Please enter either Rubric or Sample Answer(or both)");
		click(QP.toasterclosebtn);
		waitThread(2000);
	}

	/*
	 * To check Max. Score and select category , Question , Standard rubric
	 * functionalities,
	 */
	@Test(priority = 47)
	public void TCSPR090347() {
		click(QP.std_rubcheck);
		waitThread(2000);
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);
		type(QP.std_rub_bx, "Standard 2");
		driver.switchTo().defaultContent();
		waitThread(1000);
		click(QP.click_radio);
		waitThread(2000);
		click(QP.btnPopConfirm_RubricContinue);

		waitThread(2000);
		QP.ScrollHome();
		waitThread(2000);
		// JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("scroll(0, -250);");

		click(QP.save);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully");
		click(QP.toasterclosebtn);
		waitThread(2000);
	}

	/*
	 * To check Max. Score and select category , Question , Sample Answer
	 * functionalities
	 */
	@Test(priority = 48)
	public void TCSPR090348() {
		click(QP.plus_btn);
		waitThread(2000);
		click(QP.chkbx_questionbank);
		waitThread(1000);
		// Click Select category dropdown
		click(QP.cat_drop);
		waitThread(2000);
		click(QP.ddlSelect_CreatedCategory);
		waitThread(2000);
		click(QP.btnClose_SelectCategory);
		waitThread(1000);
		// click on Question box
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		// Type a question on Question box
		type(QP.Quest_box, "Question3" + generateRandomData().trim());
		driver.switchTo().defaultContent();
		waitThread(3000);
		click(QP.std_rubcheck);
		waitThread(2000);
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);
		type(QP.std_rub_bx, "Standard 3");
		driver.switchTo().defaultContent();
		waitThread(1000);
		Assert.assertEquals(getText(QP.lblSampleAns_Accord), "Sample Answer");

	}

	/*
	 * To fill sample answer details for checking toaster and validation
	 */
	@Test(priority = 49)
	public void TCSPR090349() {
		Assert.assertEquals(getAttribute(QP.expandSampleAns_Accord, "aria-expanded"), "true");
		driver.switchTo().frame("sampleAnswer_ifr");
		waitThread(2000);
		type(QP.sample_ansbx, "Sample 1");
		driver.switchTo().defaultContent();
		waitThread(2000);
		type(QP.max_scorbx, "10");
		waitThread(2000);
		click(QP.save);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Question 3 Saved successfully");
		click(QP.toasterclosebtn);
		waitThread(2000);
	}

	String question4;

	/*
	 * To fill check Clear All button functionality in add a new question page
	 */
	@Test(priority = 50)
	public void TCSPR090350() {
		click(QP.plus_btn);
		waitThread(2000);
		click(QP.chkbx_questionbank);
		waitThread(1000);
		// Click Select category dropdown
		click(QP.cat_drop);
		waitThread(2000);
		click(QP.ddlSelect_CreatedCategory);
		waitThread(2000);
		click(QP.btnClose_SelectCategory);
		waitThread(1000);
		// click on Question box
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		// Type a question on Question box
		question4 = "Question4" + generateRandomData().trim();
		type(QP.Quest_box, question4);
		driver.switchTo().defaultContent();
		waitThread(3000);

		click(QP.std_rubcheck);
		waitThread(2000);
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);
		type(QP.std_rub_bx, "Standard 4");
		driver.switchTo().defaultContent();
		waitThread(1000);
		type(QP.max_scorbx, "10");
		waitThread(2000);
		// Assert the Clear All button
		Assert.assertTrue(isElementPresent(QP.clear_all), "Clear All button not present");

	}

	/*
	 * To check Clear All functionalities
	 */
	@Test(priority = 51)
	public void TCSPR090351() {
		// Click Clear All button
		click(QP.clear_all);

		waitThread(1000);
		// Assert the confirmation pop up
		Assert.assertTrue(isElementPresent(QP.confi_pop), "Confirmation popup is not present");
		Assert.assertEquals(getText(QP.confirm_label), "Confirmation");
		// Assert text "Are you sure that you want to clear all the fields?"
		Assert.assertEquals(getText(QP.text_confirm), "Are you sure that you want to clear all the fields?");
		Assert.assertTrue(isElementPresent(QP.no_btn), "No button is not present");
		// Assert the Yes button
		Assert.assertTrue(isElementPresent(QP.yes_btn), "Yes button is not present");
		click(QP.no_btn);
		waitThread(2000);
		driver.switchTo().frame("question_ifr");
		waitThread(2000);
		Assert.assertEquals(getText(QP.quest_data).trim(), question4);
		driver.switchTo().defaultContent();
		waitThread(3000);
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);
		Assert.assertEquals(getText(QP.std_rub_bx), "Standard 4");
		driver.switchTo().defaultContent();
		waitThread(1000);
		Assert.assertEquals(getValue(QP.max_scorbx), "10");
		// Click Clear All button
		click(QP.clear_all);

		waitThread(1000);
		// Click Yes button
		click(QP.yes_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Cleared successfully"
		Assert.assertEquals(getText(QP.toaster), "Cleared successfully");
		click(QP.toasterclosebtn);

		waitThread(1000);

		// Assert the question data is not visible
		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.quest_data), "");
		driver.switchTo().defaultContent();

	}

	String question5;

	/*
	 * To check Remove question button functionalities
	 */
	@Test(priority = 52)
	public void TCSPR090352() {
		// click on Question box
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		// Type a question on Question box
		question5 = "Question5" + generateRandomData().trim();
		type(QP.Quest_box, question5);
		driver.switchTo().defaultContent();
		waitThread(3000);
		driver.switchTo().frame("sampleAnswer_ifr");
		waitThread(2000);
		type(QP.sample_ansbx, "Sample 1");
		driver.switchTo().defaultContent();
		waitThread(2000);
		type(QP.max_scorbx, "10");
		waitThread(2000);
	}

	/*
	 * To check Remove question button functionalities
	 */
	@Test(priority = 53)
	public void TCSPR090353() {
		// Assert the Remove question button is enabled
		Assert.assertTrue(isEnabled(QP.remove_quest), "Remove question button is disabled");

		waitThread(1000);
		// Click Remove Question button
		click(QP.remove_quest);

		waitThread(2000);
		// Assert the confirmation popup visible
		Assert.assertTrue(isElementPresent(QP.confi_pop), "Confirmation popup not present");

		// Assert text "Are you sure that you want to remove this question?"
		Assert.assertEquals(getText(QP.text_confirm), "Are you sure that you want to remove this question?");

		waitThread(2000);
		// Assert No button
		Assert.assertEquals(getText(QP.no_btn), "No");
		// Assert Yes button
		Assert.assertEquals(getText(QP.yes_btn), "Yes");

		waitThread(1000);
		// Click No button
		click(QP.no_btn);
		waitThread(1000);
		// Assert Question is not removed

		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.quest_data), question5);
		driver.switchTo().defaultContent();

		waitThread(2000);

		click(QP.save);
		waitThread(2000);
		// Click Remove Question button
		click(QP.remove_quest);

		waitThread(2000);
		// Assert Yes button
		Assert.assertEquals(getText(QP.yes_btn), "Yes");

		// Click Yes button
		click(QP.yes_btn);

		waitFor(QP.toaster);
		// Assert the "Removed successfully "toaster displayed
		Assert.assertEquals(getText(QP.toaster), "Removed successfully");
		click(QP.toasterclosebtn);

		waitThread(2000);
		Assert.assertFalse(isElementPresent(QP.btnQuestion4_Page), "Question 4 is present");
		// Assert the question, rubrics and marks are removed
		// Assert.assertEquals(getText(QP.max_scorbx), "");

		// driver.switchTo().frame("question_ifr");
		// Assert.assertEquals(getText(QP.quest_data), "");
		// driver.switchTo().defaultContent();

	}

	/*
	 * To perform Delete Teacher Account functionality
	 */
	@Test(priority = 54)
	public void TCSPR090354() {
		waitThread(2000);
		cr.DeleteAccount();

		waitThread(2000);
	}
}
