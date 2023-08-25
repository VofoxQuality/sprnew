package CreateNewAssessment.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Generalmethods.CommonMethods;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import CreateNewAssessment.Pages.MultipleQuestionsAddPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Test.SignUpTest;

public class QuestionsPageBasicsTestOld extends basePage {

	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	SignUpTest st = new SignUpTest();
	CourseRosterPage cr = new CourseRosterPage();
	LoginPage lg = new LoginPage();
	MultipleQuestionsAddPage mq = new MultipleQuestionsAddPage();
	CommonMethods cm = new CommonMethods();
	CreateNewCoursePage cn = new CreateNewCoursePage();

	public String Teacher_firstname;
	public String Teacher_lastname;
	public String Teacher_fullname;
	public String Password;
	public String EmailTeacher;
	public String CourseTitle;
	public String Assessment_name;
	public String newAssessment_name;
	public String CourseID;

	/*
	 * To load the Student Peer Review Landing Page
	 */
	@Test(priority = 1)
	public void TCSPR090301() throws SQLException {

		click(lg.LoginBtn_1);

		cm.login(cm.emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	/*
	 * To create a course for creating an Assessment
	 */

	// @Test(priority = 2)
	// public void TCSPR090302() {
	//
	// // Click Create New courses button
	// click(QP.create_coursebtn);
	//
	// CourseTitle = "Maths" + generateRandomNumber().trim();
	// // To get the Course ID
	// CourseID = (getText(QP.course_Id));
	//
	// // Type course name on course title
	// type(QP.txbx_Coursetitle, CourseTitle);
	//
	// waitThread(1000);
	// // Click Create Course button
	// click(QP.create_crsbtn);
	//
	// waitFor(QP.toaster);
	// // Assert the toaster "Course created successfully
	// Assert.assertEquals(getText(QP.toaster), "Course created successfully");
	// click(QP.toasterclosebtn);
	//
	// // Assert the created course visible on the grid
	// Assert.assertEquals(getText(QP.course_namegrid), CourseTitle);
	// }

	/*
	 * To check the functionality of Manage Assessments in Course Details
	 * dropdown
	 */
	@Test(priority = 3)
	public void TCSPR090303() {

		type(cn.searchbx, cm.CourseName1);
		waitThread(2000);
		// Click Course Details drop down
		click(QP.details_drop);
		waitThread(1000);

		// Assert the Manage Assessments
		Assert.assertEquals(getText(QP.manage_assess), "Manage Assessments");

		// Click Manage Assessments
		click(QP.manage_assess);

		// Assert Heading "Assessments"
		Assert.assertEquals(getText(QP.Assessments), "Assessments");

	}

	/*
	 * To add basic details of an assessment
	 */
	@Test(priority = 4)
	public void TCSPR090304() {

		// Assert the Create New Assessment button
		Assert.assertEquals(getText(QP.creatnew_assessbtn), "Create New Assessment");

		waitThread(1000);
		// Assert the created course in theCourse dropdown field
		Assert.assertEquals(getText(QP.course_assess), cm.CourseName1);

		waitThread(1000);
		// Click Create New Assessment button
		click(QP.creatnew_assessbtn);

		// Assert the Basic details label on Wizard
		Assert.assertEquals(getText(QP.basic_detls_wizard), "Basic Details");

		waitThread(2000);
		// Click on course dropdown
		click(QP.cours_drp);

		waitThread(1000);
		// Select the created course from course dropdown
		click(QP.coursname_drp);

		// Assert the Selected course is same as created course
		Assert.assertEquals(getText(QP.coursname_drp), cm.CourseName1);

		waitThread(1000);
		// Type Assessment Name
		click(QP.Assess_name);
		Assessment_name = "Geometry_" + generateRandomNumber().trim();

		type(QP.Assess_name, Assessment_name);

		waitThread(1000);
		// Click Save &Next button
		click(QP.Savenext);

		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);

		waitThread(1000);
		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

	}
	/*
	 * To check the Headings labels of Questions page
	 */

	@Test(priority = 5)
	public void TCSPR090305() {

		waitThread(2000);
		// Assert the Create New Assessment heading
		Assert.assertEquals(getText(QP.creat_new_asesslabel), "Create New Assessment");

		// Assert the heading labels
		Assert.assertEquals(getText(QP.Assess_lbel), "Assessment Name:" + " " + Assessment_name);
		Assert.assertEquals(getText(QP.course_label), "Course:");
		Assert.assertEquals(getText(QP.Add_rublabel), "Add Rubric");
		Assert.assertEquals(getText(QP.Sample_ans_label), "Sample Answer");
		Assert.assertEquals(getText(QP.max_scoreposs), "Total Test Points");
		waitThread(1000);
		Assert.assertEquals(getText(QP.max_scorelabl), "Max. Score");

	}
	/*
	 * To check Page labels & buttons of Questions Page
	 */

	@Test(priority = 6)
	public void TCSPR090306() {

		// Assert the questions label is highlighted
		Assert.assertTrue(isElementPresent(QP.question_highlight), "Questions label is not highlighted");

		// Assert discard button present
		Assert.assertTrue(isElementPresent(QP.discard_btn), "Discard button not present");

		// Assert the Save&Next,Save&Exit,+ button, Clear All, Save buttons
		Assert.assertTrue(isElementPresent(QP.savexit_btn), "Save&Exit  button not present");
		Assert.assertTrue(isElementPresent(QP.savenext_btn), "Save&Next button not present");
		Assert.assertTrue(isElementPresent(QP.plus_btn), "Add more questions button not present");
		Assert.assertTrue(isElementPresent(QP.plus_btn), "Add more questions button not present");
		Assert.assertTrue(isElementPresent(QP.clear_all), "Clear All button not present");
		Assert.assertTrue(isElementPresent(QP.save), "Save button not present");

		// Assert the question no:1 button
		Assert.assertTrue(isElementPresent(QP.buttton1), "question number button is not present");

		// Assert the Maximum score possible is zero
		Assert.assertEquals(getText(QP.max_scoreposvalue), "0");

	}
	/*
	 * To check the disabled buttons & checkboxes of Questions page
	 */

	@Test(priority = 7)
	public void TCSPR090307() {

		// Assert Add to Question bank checkbox
		Assert.assertTrue(isElementPresent(QP.quest_bankcheckbx), "Add to Question bank check box is not present");

		// Assert Select Category dropdown is disabled
		Assert.assertEquals(getAttribute(QP.select_cat, "optiondisabled"), "inactive");

		// Assert RemoveQuestion button is disabled
		Assert.assertFalse(isEnabled(QP.remove_quest), "Remove Question button is enabled");

		// Assert Import from Question bank is disabled
		Assert.assertFalse(isEnabled(QP.import_quest), "Import from Question bank button is enabled");

		// Assert Clear All button is enabled
		Assert.assertTrue(isEnabled(QP.clear_all), "Clear all button is disabled");

	}
	/*
	 * To check the tooltips of Questions Page
	 */

	@Test(priority = 8)
	public void TCSPR090308() {

		Assert.assertEquals(getAttribute(QP.Add_more_Quest, "ptooltip"), "Add More Questions");
		Assert.assertEquals(getAttribute(QP.Save_tool, "ptooltip"), "Save");
		Assert.assertEquals(getAttribute(QP.saveexit_tool, "ptooltip"),
				"Saves any current changes to the information on this screen and returns to the main Assessments screen");
		// Assert.assertEquals(getAttribute(QP.Discard_tool, "ptooltip"),
		// "Discard");
		Assert.assertEquals(getAttribute(QP.savenext_tool, "ptooltip"),
				"Saves all changes to the current screen, if any, then proceeds to the next screen in the ‘Assessment Creation’ process");

	}

	/*
	 * To check Whether the course name & Assessment Name are visible on the
	 * page
	 */
	@Test(priority = 9)
	public void TCSPR090309() {

		// Assert the Course name&course code are present in the page
		Assert.assertTrue(isElementPresent(QP.course_name), "Course name and code are not present");

		// Assert the Course name is same as created course name
		Assert.assertEquals(getText(QP.course_name), "Course: " + cm.CourseID1 + ", " + cm.CourseName1);

		// Assert the Assessment name is visible on the page
		Assert.assertTrue(isElementPresent(QP.Assess_lbel), "Assessment name is not present");

		// Assert the Assessment name as saved Assessment name
		Assert.assertEquals(getText(QP.Assess_lbel), "Assessment Name:" + " " + Assessment_name);

	}

	/*
	 * To check the info statements of Questions Page
	 */
	@Test(priority = 10)
	public void TCSPR090310() {

		waitThread(1000);
		QP.Scroll_DowntoEnd();

		// Assert the info statements
		Assert.assertEquals(getText(QP.rubric_info),
				"Rubrics will be displayed to the students during the peer-review phase only");

		Assert.assertEquals(getText(QP.sample_info),
				"Sample answers will be displayed to the students during the peer-review phase only");
	}

	/*
	 * To check the Placeholders of Question page
	 */
	@Test(priority = 11)
	public void TCSPR090311() {

		// Scroll Up page
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Assert "Enter the Question" placeholder of Question box

		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getAttribute(QP.quest_bx_holder, "aria-placeholder"), "Enter Question");
		driver.switchTo().defaultContent();

		// Scroll down page
		QP.Scroll_DowntoEnd();

		// Assert The Add Rubric dropdown button present
		Assert.assertTrue(isElementPresent(QP.rubric_drp_btn), "rubric down dropdown button not present");

		waitThread(2000);
		// Click Add rubricdown button
		click(QP.rubric_drp_btn);

		QP.Scroll_DowntoEnd();
		waitThread(3000);

		// Assert the placeholder "No Rubric Created!"
		Assert.assertEquals(getText(QP.click_rubric_holder), "No Rubric Created !");

		// Assert Sample Answer dropdown button
		Assert.assertTrue(isElementPresent(QP.sample_ans_btn), "rubric down dropdown button not present");

		waitThread(2000);
		// Click Sample Answer down button
		click(QP.sample_ans_btn);

		driver.switchTo().frame("sampleAnswer_ifr");
		waitThread(2000);
		// Assert the placeholder of Sample Answer box
		Assert.assertEquals(getAttribute(QP.sample_ans_holder, "aria-placeholder"),
				"Enter a sample answer, so that a student will get more insight on the correct/expected answer from the teacher you. This will be displayed to the students during the peer-review phase only.");
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Sample Answer down button
		click(QP.sample_ans_btn);

	}
	/*
	 * To check the labels and buttons of Select category dropdown
	 */

	@Test(priority = 12)
	public void TCSPR090312() {

		// Page scroll up
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Assert Add to Question bank checkbox
		Assert.assertTrue(isElementPresent(QP.quest_bankcheckbx), "Add to Question bank check box is not present");

		waitThread(1000);
		// Click Add to question bank checkbox
		click(QP.quest_bankcheckbx);

		// Assert the "Add to Question bank" check box is checked
		Assert.assertTrue(isElementPresent(QP.quest_bank_tick), "Add to Question bank check box is not checked");

		waitThread(2000);
		// Assert the Select Category placeholder is visible
		Assert.assertTrue(isElementPresent(QP.select_categ), "Category placeholder not present");

		waitThread(2000);
		// Click Select category dropdown
		click(QP.cat_drop);
		waitThread(2000);

		// Assert the dropdown box present in "Select Category box
		Assert.assertTrue(isElementPresent(QP.cat_box), "Select category dropdown box not present");

		// Assert the Search box
		Assert.assertTrue(isElementPresent(QP.cat_searchbox), "Category search box not present");

		// Assert Create a new Category text
		Assert.assertEquals(getText(QP.creat_newcat), "Create a new Category");

	}
	/*
	 * To create new category
	 */

	@Test(priority = 13)
	public void TCSPR090313() {

		waitThread(2000);
		// Click on Create a new Category
		click(QP.creat_cat);

		// Assert Create Category box visible
		Assert.assertTrue(isElementPresent(QP.cat_pop), " Create Category popup not visible");
		waitThread(1000);
		// Assert Create button
		Assert.assertEquals(getText(QP.catpop_creatbtn), "Create");

		String categoryname = "add" + generateRandomData().trim();
		// Type category name
		type(QP.cat_textbox, categoryname);
		waitThread(3000);

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

	}
	/*
	 * To check the mandatory toasters of Question page of rubrics section
	 */

	@Test(priority = 14)
	public void TCSPR090314() {

		// click on Question box
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question1");

		driver.switchTo().defaultContent();

		waitThread(3000);
		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert the warning message "Please enter the Rubric"
		Assert.assertEquals(getText(QP.toaster), "Please enter the Rubric");
		click(QP.toasterclosebtn);

		waitThread(4000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the warning message "Please enter the Rubric"
		Assert.assertEquals(getText(QP.toaster), "Please enter the Rubric");
		click(QP.toasterclosebtn);

		waitThread(4000);
		// Click Save & Exit button
		click(QP.savexit_btn);

		waitFor(QP.toaster);
		// Assert the warning message "Please enter the mandatory fields in
		// Rubrics"
		Assert.assertEquals(getText(QP.toaster), "Please enter the Rubric");
		click(QP.toasterclosebtn);

	}

	/*
	 * To check the Discard button functionality in Questions page after the
	 * edit
	 */
	@Test(priority = 15)
	public void TCSPR090315() {

		waitThread(2000);
		// Click Discard button
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
	@Test(priority = 16)
	public void TCSPR090316() {

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
		Assert.assertEquals(getText(QP.Quest_box), "Question1");
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
	@Test(priority = 17)
	public void TCSPR090317() {
		waitThread(3000);
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

		type(QP.draftsearchbx, Assessment_name);
		waitThread(2000);
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
	@Test(priority = 18)
	public void TCSPR090318() {
		// Enter Question
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		type(QP.Quest_box, "Question1");
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Assessments tab
		click(QP.Assessmenttab);

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
		Assert.assertEquals(getText(QP.Quest_box), "Question1");
		driver.switchTo().defaultContent();

		// Click Assessments tab
		click(QP.Assessmenttab);

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

		// Assert Question box is empty
		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), "");
		driver.switchTo().defaultContent();

		waitThread(2000);

	}

	/*
	 * To check whether discard changes popup display when switching to course
	 * tab without saving the edited page
	 */
	@Test(priority = 19)
	public void TCSPR090319() {
		// Enter Question
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		type(QP.Quest_box, "Question1");
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Course tab
		click(QP.course_tab);

		waitThread(2000);
		// Assert the Discard popup displayed
		waitFor(QP.discard_pop);
		Assert.assertTrue(isDisplayed(QP.discard_pop), "Discard popup not displayed");

		// Assert Cancel button
		Assert.assertEquals(getText(QP.dis_pop_cancel_btn), "Cancel");

		waitThread(2000);
		// Click Cancel button on popup
		click(QP.dis_pop_cancel_btn);

		waitThread(2000);
		// Assert the edited question visible in Question box
		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), "Question1");
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Course tab
		click(QP.course_tab);

		waitThread(2000);
		// Assert the Discard popup displayed
		waitFor(QP.discard_pop);
		Assert.assertTrue(isDisplayed(QP.discard_pop), "Discard popup not displayed");

		// Click Discard button on popup
		click(QP.dis_pop_discard_btn);

		waitThread(3000);
		// Assert label Courses
		Assert.assertEquals(getText(QP.courses_label), "Courses");

		waitThread(2000);
		// Click Assessment tab
		click(QP.Assessmenttab);

		// Click draft button
		click(QP.tabdraft);

		waitThread(2000);
		// search Assessment
		type(QP.draftsearchbx, Assessment_name);

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

		// Assert Question box is empty
		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), "");
		driver.switchTo().defaultContent();

		waitThread(2000);

	}

	/*
	 * To check the Discard button functionality in Questions page without the
	 * edit
	 */
	@Test(priority = 20)
	public void TCSPR090320() {

		// Click Discard button
		click(QP.discard_btn);

		// Assert a Confirmation popup visible
		Assert.assertTrue(isElementPresent(QP.discard_btn_conf_popup), "Confirmation popup not visible");

		// Assert the Text on popup "Are you certain you want to proceed with
		// your
		// action?We see that you have not made any changes to the information
		// on this
		// screen"
		waitFor(QP.text_confirm);
		Assert.assertEquals(getText(QP.text_confirm), "Are you certain you want to proceed with your action?\n"
				+ "We see that you have not made any changes to the information on this screen");

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
	@Test(priority = 21)
	public void TCSPR090321() {
		// Assert Confirmation Label
		Assert.assertEquals(getText(QP.confir_label), "Confirmation");

		waitThread(2000);
		// Click Close button on popup
		click(QP.discardbtn_popup_close);

		waitThread(3000);
		// Assert No popup visible
		Assert.assertFalse(isElementPresent(QP.discard_btn_conf_popup), "Confirmation popup visible");

		waitThread(2000);
		// Assert Question box is empty
		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), "");
		driver.switchTo().defaultContent();

		// Click Discard button
		click(QP.discard_btn);

		// Assert a Confirmation popup visible
		Assert.assertTrue(isElementPresent(QP.discard_btn_conf_popup), "Confirmation popup not visible");

		// Assert the Text on popup "Are you certain you want to proceed with
		// your
		// action?We see that you have not made any changes to the information
		// on this
		// screen"

		Assert.assertEquals(getText(QP.text_confirm), "Are you certain you want to proceed with your action?\n"
				+ "We see that you have not made any changes to the information on this screen");

		waitThread(2000);
		// Click Cancel button on popup
		click(QP.discardbtn_popup_cancel);

		waitThread(3000);
		// Assert No popup visible
		Assert.assertFalse(isElementPresent(QP.discard_btn_conf_popup), "Confirmation popup not visible");

	}

	/*
	 * To check whether click on Discard button popup will redirects to
	 * assessments window
	 */
	@Test(priority = 22)
	public void TCSPR090322() {
		waitThread(3000);
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
		waitThread(2000);
		// search Assessment
		type(QP.draftsearchbx, Assessment_name);
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

	}

	/*
	 * To Add a question & rubric to the page
	 */
	@Test(priority = 23)
	public void TCSPR090323() {

		// Enter a Question

		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		type(QP.Quest_box, "Question1");

		waitThread(2000);
		// Assert added question visible on question box
		Assert.assertEquals(getText(QP.Quest_box), "Question1");
		driver.switchTo().defaultContent();

		// Page scroll down
		Scroll_DowntoEnd();

		waitThread(2000);
		// Click Rubric accordian
		click(QP.rubric_drp_btn);

		waitThread(2000);
		// Assert Clickable rubric radio button is selected
		Assert.assertTrue(getAttribute(QP.click_radio, "class").contains("checked"));

		waitThread(2000);
		// Click Standard rubric radio button
		click(QP.std_rad);

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
		type(QP.max_scorbx, "3");

		// Click Save button
		waitThread(5000);
		click(QP.save);

		// Assert toaster "Question 1 Saved successfully"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);

	}

	/*
	 * To check the Discard button functionality in Questions page after saving
	 * the edited datas
	 */
	@Test(priority = 24)
	public void TCSPR090324() {
		waitThread(3000);
		// Click Discard button
		click(QP.discard_btn);

		waitThread(2000);
		// Assert a Confirmation popup visible
		Assert.assertTrue(isElementPresent(QP.discard_btn_conf_popup), "Confirmation popup not visible");

		// Assert the Text on popup "Are you certain you want to proceed with
		// your
		// action?We see that you have not made any changes to the information
		// on this
		// screen"

		Assert.assertEquals(getText(QP.text_confirm), "Are you certain you want to proceed with your action?\n"
				+ "We see that you have not made any changes to the information on this screen");

		waitThread(2000);
		// Click Discard button on popup
		click(QP.discardbtn_popup_dis);

		waitThread(3000);
		// Assert the label "Assessments"
		Assert.assertEquals(getText(QP.Assessments), "Assessments");

		// Click draft button
		click(QP.tabdraft);
		waitThread(2000);
		// search Assessment
		type(QP.draftsearchbx, Assessment_name);

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
		// Assert Question box with added question

		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), "Question1");
		driver.switchTo().defaultContent();

		// Assert the Max score box with added score
		Assert.assertEquals(getValue(QP.max_scorbx), "3");

	}

	/*
	 * To check whether no discard changes popup display when switching to tabs
	 * after saving the edited page
	 */
	@Test(priority = 25)
	public void TCSPR090325() {
		// Assert the questions page is highlighted on Wizard
		Assert.assertTrue(getAttribute(QP.question_highlight, "class").contains("p-highlight"));

		waitThread(2000);
		// Click Courses tab
		click(QP.course_tab);

		waitThread(5000);
		// Assert no Discard changes popup visible
		Assert.assertFalse(isElementPresent(QP.discard_pop), "Discard popup displayed");

		waitThread(2000);
		// Assert the label "Courses"
		Assert.assertEquals(getText(QP.courses_label), "Courses");

		waitThread(2000);
		// Click Assessment tab
		click(QP.Assessmenttab);

		// Click draft button
		click(QP.tabdraft);

		waitThread(2000);
		// search Assessment
		type(QP.draftsearchbx, Assessment_name);
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
		// Assert Question box with added question

		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), "Question1");
		driver.switchTo().defaultContent();

		// Assert the Max score box with added score
		Assert.assertEquals(getValue(QP.max_scorbx), "3");
	}

	/*
	 * To check whether no discard changes popup display when switching to tabs
	 * after saving the edited page
	 */
	@Test(priority = 26)
	public void TCSPR090326() {
		// Assert the questions page is highlighted on Wizard
		Assert.assertTrue(getAttribute(QP.question_highlight, "class").contains("p-highlight"));

		waitThread(2000);
		// Click Assessments tab
		click(QP.Assessmenttab);

		waitThread(5000);
		// Assert no Discard changes popup visible
		Assert.assertFalse(isElementPresent(QP.discard_pop), "Discard popup displayed");

		waitThread(2000);
		// Assert the label "Assessments"
		Assert.assertEquals(getText(QP.Assessments), "Assessments");

		// Click draft button
		click(QP.tabdraft);

		waitThread(2000);
		// search Assessment
		type(QP.draftsearchbx, Assessment_name);
		// Assert the created Assessment name visible on grid
		Assert.assertEquals(getText(QP.assessment_draftgrid), Assessment_name);

		// Click continue editing
		click(QP.continue_edit);

		waitThread(2000);
		// Assert the Basic details label on Wizard
		Assert.assertEquals(getText(QP.basic_detls_wizard), "Basic Details");

		waitThread(2000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(2000);
		// Assert Question box with added question

		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), "Question1");
		driver.switchTo().defaultContent();

		// Assert the Max score box with added score
		Assert.assertEquals(getValue(QP.max_scorbx), "3");

	}

	/*
	 * To check the functionality of clear all button
	 */
	@Test(priority = 27)
	public void TCSPR090327() {
		// Assert the Clear All button
		Assert.assertTrue(isElementPresent(QP.clear_all), "Clear All button not present");

		waitThread(2000);
		// Click Clear All button
		click(QP.clear_all);

		waitThread(1000);
		// Assert the label confirmation, No button
		Assert.assertEquals(getText(QP.confirm_label), "Confirmation");
		Assert.assertTrue(isElementPresent(QP.no_btn), "No button is present");

		// Click No button
		click(QP.no_btn);

		waitThread(1000);
		// Assert popup not visible
		Assert.assertFalse(isElementPresent(QP.confi_pop), "Confirmation popup is present");

		waitThread(2000);

		// Click Clear All button
		click(QP.clear_all);

		waitThread(2000);

		// Assert text "Are you sure that you want to clear all the fields?"
		Assert.assertEquals(getText(QP.text_confirm), "Are you sure that you want to clear all the fields?");

		// Assert the Yes button
		Assert.assertTrue(isElementPresent(QP.yes_btn), "No button is present");

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

	/*
	 * To check the labels, radio buttons & buttons of rubrics
	 */
	@Test(priority = 28)
	public void TCSPR090328() {
		Assert.assertEquals(getText(QP.Add_rublabel), "Add Rubric");

		QP.Scroll_DowntoEnd();
		waitThread(6000);

		// Click rubric drop down
		click(QP.rubric_drp_btn);
		waitThread(3000);

		// Assert "Select Rubric Editor" text is present
		Assert.assertEquals(getText(QP.sel_rubric_editor_label), "Select Rubric Editor");

		// Assert the clickable rubric radio button is checked
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		// Assert the buttons in clickable rubric
		Assert.assertTrue(isDisplayed(QP.add_column), "Add column button is not present");
		Assert.assertTrue(isDisplayed(QP.remov_lastcolum), "Remove last column button is not present");
		Assert.assertTrue(isDisplayed(QP.add_row), "Add Row button is not present");
		Assert.assertTrue(isDisplayed(QP.remov_lastrw), "Remove last row button is not present");

	}

	/*
	 * To check Whether the buttons of Clickable Rubric is enabled or not
	 */
	@Test(priority = 29)
	public void TCSPR090329() {

		// Assert the Add column button is enabled
		Assert.assertTrue(isEnabled(QP.add_column), "Add column button is disabled");

		// Assert Add Row button is disabled
		Assert.assertFalse(isEnabled(QP.add_row), "Add Row button is enabled");

		// Assert Remove Last column button is disabled
		Assert.assertFalse(isEnabled(QP.remov_lastcolum), "Remove Last column button is enabled");

		// Assert Remove Last Low button is disabled
		Assert.assertFalse(isEnabled(QP.remov_lastrw), "Remove Last Row button is enabled");

	}

	/*
	 * To check functionality of Normal rubric
	 */
	@Test(priority = 30)
	public void TCSPR090330() {
		// Assert the standard rubric radio button
		Assert.assertTrue(isElementPresent(QP.std_rad), "Standard rubric radio button is not prsesnt");

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Assert the standard rubric radio button is checked
		Assert.assertTrue(isElementPresent(QP.std_rubcheck), "Standard rubric radio button is not checked");

		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);
		// Assert the place holder in standard rubric box
		Assert.assertEquals(getAttribute(QP.std_rub_plac, "aria-placeholder"),
				"Enter/upload Rubric (image or pdf), and this will be displayed to the students during the peer-review phase. This helps the students to evaluate other's answers.");

	}

	/*
	 * To check the mandatory toasters of Question page of Questions section
	 */
	@Test(priority = 31)
	public void TCSPR090331() {
		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Assert the "Save button"
		Assert.assertEquals(getText(QP.save), "Save");

		waitThread(3000);
		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert the toaster "Please enter the Question and Score"
		Assert.assertEquals(getText(QP.toaster), "Please enter the Question and 'Max Score'");
		click(QP.toasterclosebtn);

		waitThread(6000);
		// Click Save &Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Please enter the Question and Score"
		Assert.assertEquals(getText(QP.toaster), "Please enter the Question and 'Max Score'");
		click(QP.toasterclosebtn);

		waitThread(3000);
		// Click Save & Exit button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Please enter the Question and Score"
		Assert.assertEquals(getText(QP.toaster), "Please enter the Question and 'Max Score'");
		click(QP.toasterclosebtn);

		// Assert the Max score box
		Assert.assertTrue(isElementPresent(QP.max_scorbx), "Max Score box not present");

		// Enter Max score
		type(QP.max_scorbx, "3");

		waitThread(6000);
		// Click Save &Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Please enter the Question "
		Assert.assertEquals(getText(QP.toaster), "Please enter the Question");
		click(QP.toasterclosebtn);

		waitThread(3000);
		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert the toaster "Please enter the Question "
		Assert.assertEquals(getText(QP.toaster), "Please enter the Question");
		click(QP.toasterclosebtn);

		waitThread(5000);
		// Click Save & Exit button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Please enter the Question "
		Assert.assertEquals(getText(QP.toaster), "Please enter the Question");
		click(QP.toasterclosebtn);

		// Assert the question label on wizard
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

	}

	/*
	 * To check the mandatory toasters of question bank category
	 */
	@Test(priority = 32)
	public void TCSPR090332() {
		driver.switchTo().frame("question_ifr");

		// click on Question box
		click(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question1");

		driver.switchTo().defaultContent();

		// Assert the "Add to Question bank" check box
		Assert.assertTrue(isElementPresent(QP.quest_bankcheckbx), "Add to Question bank check box is not present");

		waitThread(1000);
		// Tick the checkbox
		click(QP.quest_bankcheckbx);

		// Assert the Select category placeholder is visible
		Assert.assertTrue(isElementPresent(QP.select_categ), "Category placeholder not present");

		waitThread(2000);
		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert the toaster "Please enter the Question Bank Category"
		Assert.assertEquals(getText(QP.toaster), "Please enter the Question Bank Category");
		click(QP.toasterclosebtn);

		waitThread(4000);
		// Click Save &Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Please enter the Question Bank Category"
		Assert.assertEquals(getText(QP.toaster), "Please enter the Question Bank Category");
		click(QP.toasterclosebtn);

		waitThread(4000);
		// Click Save & Exit button
		click(QP.savexit_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Please enter the Question Bank Category"
		Assert.assertEquals(getText(QP.toaster), "Please enter the Question Bank Category");
		click(QP.toasterclosebtn);

		// Assert the Max score possible is 3
		Assert.assertEquals(getText(QP.max_scoreposs_value), "3");

	}

	/*
	 * To Check the Select Category dropdown functionlity after adding a
	 * category
	 */
	@Test(priority = 33)
	public void TCSPR090333() {
		// Click Select category dropdown
		click(QP.cat_drop);
		waitThread(2000);

		// Assert the already added category visible on the dropdown
		Assert.assertEquals(getText(QP.aded_cat_drop), "add");

		// click the checkbox of added category in dropdown
		click(QP.add_cat_checkbx);

		// Assert the checkbox of category is checked
		Assert.assertTrue(isElementPresent(QP.add_cat_tick), "Check box of added category is not checked");

		// Assert the all checkbox is checked
		Assert.assertTrue(isElementPresent(QP.cat_all_check), "Category all check box is not checked ");

		waitThread(2000);
		// Assert the category added to the page
		Assert.assertTrue(isElementPresent(QP.added_cat), "Added category not visible");
		Assert.assertEquals(getText(QP.added_cat), "add");

		// Assert the close button dropdown
		Assert.assertTrue(isElementPresent(QP.cat_clos_btn), "Category dropdown close button not present");

		waitThread(1000);
		// click close button on dropdown
		click(QP.cat_clos_btn);

		waitThread(2000);
		// Assert the dropdown closed
		Assert.assertFalse(isElementPresent(QP.cat_box), "Category dropdown is present");

		// Assert the Save&Next button
		Assert.assertTrue(isElementPresent(QP.savenext_btn), "Save & Next button is not present");

	}

	/*
	 * To check whether the user can reach peer review page
	 */
	@Test(priority = 34)
	public void TCSPR090334() {

		// Assert the Save&Next button
		Assert.assertTrue(isElementPresent(QP.savenext_btn), "Save & Next button is not present");

		waitThread(2000);
		// Click Save &Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert toaster "Question 1 Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	/*
	 * To check whether changed Assessment name from basic details page is
	 * reflecting on questions page
	 */
	@Test(priority = 35)
	public void TCSPR090335() {
		newAssessment_name = " Geometry123" + generateRandomData().trim();

		// Click the basic details wizard
		click(QP.basic_detls_wizard);

		// Assert the basic details circle is highlighted
		Assert.assertTrue(getAttribute(QP.basic_det_highlgt, "class").contains("p-highlight"));

		// Assert the Assessment Info heading
		Assert.assertEquals(getText(QP.lbl_assessmentinfo), "Assessment Information for Students");

		waitThread(2000);
		// click on Course drop down
		click(QP.cours_drp);

		waitThread(2000);
		// Assert the created course is visible on the dropdown
		Assert.assertEquals(getText(QP.creat_course_dropdwn), cm.CourseName1);

		waitThread(1000);
		// Click Assessment name text box
		click(QP.Assess_name);

		// Edit assessment name
		driver.findElement(By.xpath(QP.Assess_name)).clear();
		type(QP.Assess_name, newAssessment_name);

		waitThread(2000);
		// Click Save &Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);

		waitThread(3000);
		// Assert the new assessment visible on page
		Assert.assertEquals(getText(QP.Assess_lbel), "Assessment Name:" + newAssessment_name);

	}

	/*
	 * To check the functionality of Remove Question in the questions page
	 */
	@Test(priority = 36)
	public void TCSPR090336() {
		waitThread(4000);
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

		waitThread(1000);
		// Click No button
		click(QP.no_btn);

		// Assert Question is not removed

		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.quest_data), "Question1");
		driver.switchTo().defaultContent();

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
		// Assert the question, rubrics and marks are removed
		Assert.assertEquals(getText(QP.max_scorbx), "");

		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.quest_data), "");
		driver.switchTo().defaultContent();

		// Scroll down page
		QP.Scroll_DowntoEnd();

		waitThread(3000);
		// Click Standard rubric radio button
		click(QP.std_rad);

		driver.switchTo().frame("rubric_ifr");

		waitThread(4000);
		// Assert the place holder in standard rubric box
		Assert.assertEquals(getAttribute(QP.std_rub_plac, "aria-placeholder"),
				"Enter/upload Rubric (image or pdf), and this will be displayed to the students during the peer-review phase. This helps the students to evaluate other's answers.");

		Assert.assertEquals(getText(QP.std_rub_bx), "");
		driver.switchTo().defaultContent();

	}

	/*
	 * To perform Logout functionality
	 */
	@Test(priority = 37)
	public void TCSPR090337() {
		waitThread(2000);
		cm.Logout();

		// Assert the heading "Login"
		Assert.assertEquals(getText(QP.hd_label11), "Login");

	}

}
