package CreateNewAssessment.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Generalmethods.CommonMethods;

import Course.Pages.CourseRosterPage;
import CreateNewAssessment.Pages.ClickableRubricPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Test.SignUpTest;

public class ClickableRubricTest extends basePage {

	ClickableRubricPage ck = new ClickableRubricPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	SignUpTest st = new SignUpTest();
	CourseRosterPage cr = new CourseRosterPage();
	LoginPage lg = new LoginPage();
	CommonMethods cm = new CommonMethods();

	public String Teacher_firstname;
	public String Teacher_lastname;
	public String Teacher_fullname;
	public String Password;
	public String EmailTeacher;
	public String CourseTitle;
	public String Assessment_name;
	public String CourseID;

	/*
	 * To load the Student Peer Review Landing Page
	 */
	@Test(priority = 0)
	public void TCSPR090401() throws SQLException {
//
//		Teacher_firstname = "Test";
//		Teacher_lastname = "Teacher";
//		Teacher_fullname = Teacher_firstname + " " + Teacher_lastname;
//		Password = "Abc@123";
//
//		// Assert the heading label "Welcome to Student Peer Review"
//		Assert.assertEquals(getText(QP.wel_label), "Welcome to Student Peer Review");
//
//		// Click on I'm a Teacher button
//		click(QP.teach_btn);
//
//		EmailTeacher = st.TCSPR020005();
//		System.out.println(EmailTeacher);
		click(lg.LoginBtn_1);

		cm.login(cm.emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	// @Test(priority = 1)
	public void Test() throws SQLException {

		// To catch OTP from sending Resource
		st.TCSPR020006();

		// Assert the heading label "Courses"
		Assert.assertEquals(getText(QP.courses_label), "Courses");

	}
	/*
	 * To Create a Course for creating new Assessment
	 */

	// @Test(priority = 2)
	public void TCSPR090402() {

		// Click Create New courses button
		click(QP.create_coursebtn);

		CourseTitle = "Maths" + generateRandomNumber().trim();
		// To get the Course ID
		CourseID = (getText(QP.course_Id));

		// Type course name on course title
		type(QP.txbx_Coursetitle, CourseTitle);

		waitThread(1000);
		// Click Create Course button
		click(QP.create_crsbtn);

		waitFor(QP.toaster);
		// Assert the toaster "Course created successfully
		Assert.assertEquals(getText(QP.toaster), "Course created successfully");
		click(QP.toasterclosebtn);

		// Assert the created course visible on the grid
		Assert.assertEquals(getText(QP.course_namegrid), CourseTitle);
	}

	/*
	 * To create an Assessment
	 */
	@Test(priority = 3)
	public void TCSPR090403() {

		// Assert the Assessments tab
		Assert.assertTrue(isElementPresent(QP.Assessmenttab), "Assessments tab not present");

		// Click Assessments tab
		click(QP.Assessmenttab);
		waitThread(5000);
		// Assert Create New Assessment button
		Assert.assertEquals(getText(QP.creatnew_assessbtn), "Create New Assessment");

		// Click Create New Assessment button
		click(QP.creatnew_assessbtn);

		// Assert the Create New Assessment heading
		Assert.assertEquals(getText(QP.creat_new_asesslabel), "Create New Assessment");

		// Assert the basic details label
		Assert.assertEquals(getText(QP.basic_detls_wizard), "Basic Details");
	}
	/*
	 * To create Create New Assessments-basic details page
	 */

	@Test(priority = 4)
	public void TCSPR090404() {

		waitThread(2000);
		// Click on course dropdown
		click(QP.cours_drp);

		// Select the created course from course dropdown
		click(QP.coursname_drp);

		// Assert the Selected course is same as created course
		// Assert.assertEquals(getText(QP.coursname_drp), CourseTitle);

		// Type Assessment Name
		click(QP.Assess_name);
		Assessment_name = "Geometry" + generateRandomNumber().trim();

		type(QP.Assess_name, Assessment_name);

		waitThread(1000);
		// Click Save &Next button
		click(QP.Savenext);

		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);

		// Assert the Questions label on Wizard
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");
	}

	/*
	 * To load Create New Assessments- Questions page
	 */
	@Test(priority = 5)
	public void TCSPR090405() {

		// Assert the Questions label on wizard which is highlighted
		Assert.assertTrue(isElementPresent(QP.question_highlight), "Questions label is not highlighted");

		waitThread(3000);
		// Assert the Assessment name
		Assert.assertEquals(getText(QP.Assess_lbel), "Assessment Name:" + " " + Assessment_name);

		waitThread(1000);
		// Assert the Course name is same as created course name
		// Assert.assertEquals(getText(QP.course_name), "Course: " + CourseID + ", " +
		// CourseTitle);

	}
	/*
	 * To enter the data on Question box
	 */

	@Test(priority = 6)
	public void TCSPR090406() {
		// Assert the Questions label on Wizard
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(2000);
		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question1");

		driver.switchTo().defaultContent();

		// Assert the heading "Add Rubric"
		Assert.assertEquals(getText(QP.Add_rublabel), "Add Rubric");

	}
	/*
	 * To check the Clickable Rubric functionality
	 */

	@Test(priority = 7)
	public void TCSPR090407() {
		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);

		// Click rubric dropdown
		click(QP.rubric_drp_btn);
		waitThread(3000);

		// Assert the clickable rubric radio button is enabled
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		waitThread(1000);
		// Click Add column button
		click(QP.add_column);

		// Assert the added column is visible in rubric box
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("framesize" + size);
		waitThread(2000);
		driver.switchTo().frame(1);

		waitThread(2000);
		Assert.assertEquals(getAttribute(ck.clic_rub_place, "aria-placeholder"), "Enter Condition");

		driver.switchTo().defaultContent();

	}
	/*
	 * To check the labels in clickable rubric box
	 */

	@Test(priority = 8)
	public void TCSPR090408() {

		// To check the labels in clickable rubric box
		// Assert the labels-Criteria1,Score for column 1
		Assert.assertEquals(getText(ck.criteria1_lbl), "Criteria 1");
		Assert.assertEquals(getText(ck.score_fr_column1_lbl), "Score for Column 1");

	}
	/*
	 * To check the placeholders in the Clickable rubric
	 */

	@Test(priority = 9)
	public void TCSPR090409() {
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
	 * To check the Remove column functionality
	 */
	@Test(priority = 10)
	public void TCSPR090410() {

		// Assert the clickable rubric radio button is enabled
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		waitThread(2000);
		// click on Remove column button
		click(QP.remov_lastcolum);

		waitThread(2000);
		// Assert the Confirmation popup visible
		Assert.assertTrue(isDisplayed(ck.confirm_pop), "Confirmation popup not displayed");
		waitThread(1000);
		// Click No button
		click(ck.No_btn);

		// Assert the popup not visible
		// Assert.assertFalse(isElementPresent(ck.confirm_pop), "Confirmation
		// popup
		// displayed");

		// click on Remove column button
		click(QP.remov_lastcolum);

		waitThread(2000);
		// Click Yes button
		click(ck.yes_btn);

		waitThread(3000);
		// Assert the Column deleted
		// Assert the placeholder "No Rubric Created!"
		Assert.assertEquals(getText(QP.click_rubric_holder), "No Rubric Created !");

	}
	/*
	 * To check the Add Row & Remove Last Row buttons functionality
	 */

	@Test(priority = 11)
	public void TCSPR090411() {

		// Assert the clickable rubric radio button is enabled
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		waitThread(2000);
		// Click Add column button
		click(QP.add_column);
		// Click Row button
		click(QP.add_row);

		// Assert the added column is visible in rubric box
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("framesize" + size);
		waitThread(2000);

		// Assert the new row added is visible
		driver.switchTo().frame(2);
		waitThread(2000);
		Assert.assertEquals(getAttribute(ck.clic_rub_place, "aria-placeholder"), "Enter Condition");
		driver.switchTo().defaultContent();

		// Assert the label "Criteria2"
		Assert.assertEquals(getText(ck.criteria2_lbl), "Criteria 2");
		waitThread(1000);
		// Click Remove Last Row button
		click(QP.remov_lastrw);
		waitThread(3000);
		click(ck.yes_btn);
		// Assert the added row removed

	}

	@Test(priority = 12)
	public void TCSPR090412() {
		// To check the max row limit

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

	@Test(priority = 13)
	public void TCSPR090413() {
		// Scroll Up page
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");
		// To check the max column limit

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
		waitThread(5000);
		// Click Add Column button
		click(QP.add_column);

		waitFor(QP.toaster);
		// Assert the toaster "Max column limit reached"
		Assert.assertEquals(getText(QP.toaster), "Max column limit reached");
		click(QP.toasterclosebtn);

	}

	@Test(priority = 14)
	public void TCSPR090414() {
		// To check whether the Save confirmation popup is displayed when
		// switching the
		// rubrics
		// Assert the clickable rubric radio button is enabled
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Assert the Confirmation popup visible
		waitThread(2000);
		// Assert the Confirmation popup visible
		Assert.assertTrue(isDisplayed(ck.confirm_pop), "Confirmation popup not displayed");

		// Assert the text "Changes you made may not be saved."
		Assert.assertEquals(getText(ck.confirm_txt_lbl), "Changes you made may not be saved.");

		// Assert continue editing button
		Assert.assertEquals(getText(ck.cont_edit_btn), "Continue Editing");

		waitThread(2000);
		// Click Continue editing
		click(ck.cont_edit_btn);

		// Assert the radio button of clickable rubric is checked
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		waitThread(2000);
		// Click Standard rubric radio button
		click(QP.std_rad);

		waitThread(2000);
		// Assert Discard button
		Assert.assertEquals(getText(ck.dis_btn), "Discard");

		// Click Discard button
		click(ck.dis_btn);

		// Assert the radio button of Standard rubric is checked
		Assert.assertTrue(isElementPresent(QP.std_rubcheck), "Standard rubric radio button is not checked");

	}

	/*
	 * To check the mandatory field toasters of rubric with 2 columns
	 */
	@Test(priority = 15)
	public void TCSPR090415() {

		// click on clickable rubric radio buton
		click(QP.click_radio);

		// Click Add column button
		click(QP.add_column);

		// Assert Add row , Remove Last Column, Remove Last Row are enabled
		Assert.assertTrue(isEnabled(QP.add_row), "Add Row button is disabled");
		Assert.assertTrue(isEnabled(QP.remov_lastcolum), "Remove Last column button is disabled");
		Assert.assertTrue(isEnabled(QP.remov_lastrw), "Remove Last Row button is disabled");

		// Enter criteria 1
		type(ck.crit1_bx, "C1");

		// Click Save&Next button
		waitThread(6000);
		click(QP.savenext_btn);

		// Assert the toasters
		// _ "Please enter the number greater than zero on score for 'column 1' in
		// Criteria 1"
		/// _"Please enter the score for 'Column 1' in Criteria 1, Condition for 'Column
		// 1' in Criteria 1"

		waitFor(ck.toaster1);
		Assert.assertTrue(getText(ck.toaster1).contains(
				"Please enter the score for 'Column 1' in Criteria 1, Condition for 'Column 1' in Criteria 1"));

		// waitFor(ck.toaster_2);
		// Assert.assertTrue(getText(ck.toaster_2).contains(
		// "Please enter the score for 'Column 1' in Criteria 1, Condition for 'Column
		// 1' in Criteria 1"));

		// click(QP.toasterclosebtn);
		waitFor(ck.toasterclosebtn1);
		click(ck.toasterclosebtn1);

		waitThread(3000);
		ScrollTo_xy_position(0, 500);
		waitThread(5000);

		// Click Add column button
		click(QP.add_column);

		// Click Save&Next button
		waitThread(6000);
		click(QP.savenext_btn);

		waitFor(ck.toaster1);
		// Assert toasters
		// -"Please enter a number greater than zero on at least one column in
		// criteria(s)"
		// -"Please enter the score for 'Column 1' in Criteria 1 & score for 'Column 2'
		// in Criteria 1, Condition for 'Column 1' in Criteria 1 & Condition for 'Column
		// 2' in Criteria 1"

		Assert.assertTrue(getText(ck.toaster1).contains(
				"Please enter the score for 'Column 1' in Criteria 1 & score for 'Column 2' in Criteria 1, Condition for 'Column 1' in Criteria 1 & Condition for 'Column 2' in Criteria 1"));

		waitFor(ck.toasterclosebtn1);
		click(ck.toasterclosebtn1);

//		waitFor(ck.toaster2);
//		Assert.assertTrue(getText(ck.toaster2).contains(
//				"Please enter the score for 'Column 1' in Criteria 1 & score for 'Column 2' in Criteria 1, Condition for 'Column 1' in Criteria 1 & Condition for 'Column 2' in Criteria 1"));
//
//		waitFor(ck.toasterclosebtn2);
//		click(ck.toasterclosebtn2);

		waitThread(3000);
		ScrollTo_xy_position(0, 700);

		// Enter condition for 1st column
		driver.switchTo().frame("editorFieldRubric_00_ifr");
		waitThread(2000);
		type(ck.enter_con, "Condition1");
		driver.switchTo().defaultContent();

		// Click Save&Next button
		waitThread(6000);
		click(QP.savenext_btn);
		waitFor(ck.toaster1);

		// Assert toasters
		// -"Please enter a number greater than zero on at least one column in
		// criteria(s)"
		// -"Please enter the score for 'Column 1' in Criteria 1 & score for 'Column 2'
		// in Criteria 1, Condition for 'Column 2' in Criteria 1"

		Assert.assertTrue(getText(ck.toaster1).contains(
				"Please enter the score for 'Column 1' in Criteria 1 & score for 'Column 2' in Criteria 1, Condition for 'Column 2' in Criteria 1"));

//		Assert.assertTrue(getText(ck.toaster_2).contains(
//				"Please enter the score for 'Column 1' in Criteria 1 & score for 'Column 2' in Criteria 1, Condition for 'Column 2' in Criteria 1"));

		waitFor(ck.toasterclosebtn1);
		click(ck.toasterclosebtn1);

		ScrollTo_xy_position(0, 700);

		// Enter condition for 2nd column
		driver.switchTo().frame("editorFieldRubric_01_ifr");
		waitThread(2000);
		type(ck.enter_con, "Condition2");
		driver.switchTo().defaultContent();

		// Click Save&Next button
		waitThread(2000);
		click(QP.savenext_btn);
		waitFor(ck.toaster1);

		// Assert toasters
		// -"Please enter a number greater than zero on at least one column in
		// criteria(s)"
		// "Please enter the score for 'Column 1' in Criteria 1 & score for 'Column 2'
		// in Criteria 1"
		Assert.assertTrue(getText(ck.toaster1)
				.contains("Please enter the score for 'Column 1' in Criteria 1 & score for 'Column 2' in Criteria 1"));

//		Assert.assertTrue(getText(ck.toaster_2)
//				.contains("Please enter the score for 'Column 1' in Criteria 1 & score for 'Column 2' in Criteria 1"));
//		click(QP.toasterclosebtn);
		waitFor(ck.toasterclosebtn1);
		click(ck.toasterclosebtn1);

	}

	/*
	 * To check the mandatory field toasters of Clickable rubric without Question
	 */
	@Test(priority = 16)
	public void TCSPR090416() {

		// page scroll up

		ck.scrolup();

		waitThread(3000);
		// Clear the added Question
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		driver.findElement(By.xpath("//body[@data-id='question']")).clear();
		driver.switchTo().defaultContent();

		// Click Save&Next button
		waitThread(5000);
		click(QP.savenext_btn);
		waitFor(ck.toasterquestion);

		// Assert toasters
		// _"Please enter the Question and number greater than zero on at least one
		// column in criteria(s)"
		// _"Please enter the score for 'Column 1' in Criteria 1 & score for 'Column 2'
		// in Criteria 1"

		Assert.assertTrue(getText(ck.toasterquestion).contains("Please enter the Question"));

		waitFor(ck.toasterquestionclosebtn);
		click(ck.toasterquestionclosebtn);

		Assert.assertTrue(getText(ck.toaster1)
				.contains("Please enter the score for 'Column 1' in Criteria 1 & score for 'Column 2' in Criteria 1"));

		// click(QP.toasterclosebtn);
		waitFor(ck.toasterclosebtn1);
		click(ck.toasterclosebtn1);

		waitThread(7000);

		ScrollTo_xy_position(0, 700);
		waitThread(1000);
		// Clear the criteria
		Doubleclick(ck.crit1_bx);
		// driver.findElement(By.xpath("//div[@id='rubricMain']//tr[1]//textarea[@id='criteriaInput']")).clear();
		// (Enter backspace) clear the score
		driver.findElement(By.xpath("//div[@id='rubricMain']//tr[1]//textarea[@id='criteriaInput']"))
				.sendKeys(Keys.BACK_SPACE);
		// (Enter backspace) clear the score
		driver.findElement(By.xpath("//div[@id='rubricMain']//tr[1]//textarea[@id='criteriaInput']"))
				.sendKeys(Keys.BACK_SPACE);

		//// Click Save&Next button
		waitThread(7000);
		click(QP.savenext_btn);
		waitFor(ck.toaster_1);

		// Assert toasters
		// _"Please enter the Question and number greater than zero on at least one
		// column in criteria(s)"
		// _"Please enter the score for 'Column 1' in Criteria 1 & score for 'Column 2'
		// in Criteria 1"
		// _-"Please enter the Criteria 1"

		Assert.assertTrue(getText(ck.toasterquestion).contains("Please enter the Question"));

		waitFor(ck.toasterquestionclosebtn);
		click(ck.toasterquestionclosebtn);

		Assert.assertTrue(getText(ck.toaster1)
				.contains("Please enter the score for 'Column 1' in Criteria 1 & score for 'Column 2' in Criteria 1"));

		// click(QP.toasterclosebtn);
		waitFor(ck.toasterclosebtn1);
		click(ck.toasterclosebtn1);

		waitFor(ck.toaster2);
		Assert.assertTrue(getText(ck.toaster2).contains("Please enter the Criteria 1"));

		waitFor(ck.toasterclosebtn2);
		click(ck.toasterclosebtn2);

		waitThread(4000);
		ScrollTo_xy_position(0, 500);

		waitThread(4000);
		// Click Add column button
		click(QP.add_column);

		// Click Save&Next button
		waitThread(5000);
		click(QP.savenext_btn);

		waitFor(ck.toaster_1);
		// Assert toasters
		// -"Please enter a number greater than zero on at least one column in
		// criteria(s)"
		// -"Please enter the Scores, Condition for 'Column 3' in Criteria 1"
		// _-"Please enter the Criteria 1"
		Assert.assertTrue(getText(ck.toasterquestion).contains("Please enter the Question"));

		waitFor(ck.toasterquestionclosebtn);
		click(ck.toasterquestionclosebtn);
		Assert.assertTrue(
				getText(ck.toaster1).contains("Please enter the Scores, Condition for 'Column 3' in Criteria 1"));

		// click(QP.toasterclosebtn);
		waitFor(ck.toasterclosebtn1);
		click(ck.toasterclosebtn1);
		waitFor(ck.toaster2);
		Assert.assertTrue(getText(ck.toaster2).contains("Please enter the Criteria 1"));

		waitFor(ck.toasterclosebtn2);
		click(ck.toasterclosebtn2);

		// Clear the added conditions
		waitThread(2000);
		driver.switchTo().frame("editorFieldRubric_00_ifr");
		waitThread(2000);
		click("//*[@id='tinymce']");
		driver.findElement(By.xpath("//*[@id='tinymce']")).clear();
		driver.switchTo().defaultContent();

		waitThread(2000);
		driver.switchTo().frame("editorFieldRubric_01_ifr");
		waitThread(2000);
		click("//*[@id='tinymce']");
		driver.findElement(By.xpath("//*[@id='tinymce']")).clear();
		driver.switchTo().defaultContent();

		// Click Save&Next button
		waitThread(6000);
		click(QP.savenext_btn);

		waitFor(ck.toaster_1);
		// Assert toasters
		// -"Please enter a number greater than zero on at least one column in
		// criteria(s)"
		// -"Please enter the Scores, Conditions"
		// _-"Please enter the Criteria 1"
		Assert.assertTrue(getText(ck.toasterquestion).contains("Please enter the Question"));

		waitFor(ck.toasterquestionclosebtn);
		click(ck.toasterquestionclosebtn);
		Assert.assertTrue(getText(ck.toaster1).contains("Please enter the Scores, Conditions"));

		// click(QP.toasterclosebtn);
		waitFor(ck.toasterclosebtn1);
		click(ck.toasterclosebtn1);
		waitFor(ck.toaster2);
		Assert.assertTrue(getText(ck.toaster2).contains("Please enter the Criteria 1"));

		waitFor(ck.toasterclosebtn2);
		click(ck.toasterclosebtn2);

	}

	/*
	 * To check the score field validation toasters
	 */
	@Test(priority = 17)
	public void TCSPR090417() {

		// Enter score for column 1 as zero
		type(ck.scre_col1, "0");

		// Click Save&Next button
		waitThread(7000);
		click(QP.savenext_btn);

		// Assert toasters
		// _"Please enter the Question and number greater than zero on at least one
		// column in criteria(s)"

		// _"Please enter the score for 'Column 2' in Criteria 1 & score for 'Column 3'
		// in Criteria 1, Conditions"
		// _"Please enter the Criteria 1
		waitFor(ck.toasterquestion);
		Assert.assertTrue(getText(ck.toasterquestion).contains("Please enter the Question"));

		waitFor(ck.toasterquestionclosebtn);
		click(ck.toasterquestionclosebtn);
		Assert.assertTrue(getText(ck.toaster1).contains(
				"Please enter the score for 'Column 2' in Criteria 1 & score for 'Column 3' in Criteria 1, Conditions"));

		// click(QP.toasterclosebtn);
		waitFor(ck.toasterclosebtn1);
		click(ck.toasterclosebtn1);
		waitFor(ck.toaster2);
		Assert.assertTrue(getText(ck.toaster2).contains("Please enter the Criteria 1"));

		waitFor(ck.toasterclosebtn2);
		click(ck.toasterclosebtn2);

		// Enter score for column 2 zero
		type(ck.scre_col2, "0");

		// Click Save&Next button
		waitThread(7000);
		click(QP.savenext_btn);

		// Assert toasters
		// -"Please enter the Question and number greater than zero on at least one
		// column in criteria(s)"

		// -"Please enter the score for 'Column 3' in Criteria 1, Conditions"

		// -"Please enter the Criteria 1"
		waitFor(ck.toasterquestion);
		
		Assert.assertTrue(getText(ck.toasterquestion).contains("Please enter the Question"));

		waitFor(ck.toasterquestionclosebtn);
		click(ck.toasterquestionclosebtn);
		Assert.assertTrue(
				getText(ck.toaster1).contains("Please enter the score for 'Column 3' in Criteria 1, Conditions"));

		// click(QP.toasterclosebtn);
		waitFor(ck.toasterclosebtn1);
		click(ck.toasterclosebtn1);
		waitFor(ck.toaster2);
		Assert.assertTrue(getText(ck.toaster2).contains("Please enter the Criteria 1"));

		waitFor(ck.toasterclosebtn2);
		click(ck.toasterclosebtn2);

		// Enter score for column 3 zero
		type(ck.scre_col3, "0");

		// Click Save&Next button
		waitThread(6000);
		click(QP.savenext_btn);

		// Assert toasters
		// -"Please enter the Question and number greater than zero on at least one
		// column in criteria(s)"

		// -"Please enter the Conditions"

		// -"Please enter the Criteria 1"
		waitFor(ck.toasterquestion);
		
		Assert.assertTrue(getText(ck.toasterquestion).contains(
				"Please enter the Question and number greater than zero on at least one column in criteria 1"));

		waitFor(ck.toasterquestionclosebtn);
		click(ck.toasterquestionclosebtn);
		Assert.assertTrue(getText(ck.toaster1).contains("Please enter the Conditions"));

		// click(QP.toasterclosebtn);
		waitFor(ck.toasterclosebtn1);
		click(ck.toasterclosebtn1);
		waitFor(ck.toaster2);
		Assert.assertTrue(getText(ck.toaster2).contains("Please enter the Criteria 1"));

		waitFor(ck.toasterclosebtn2);
		click(ck.toasterclosebtn2);

		// Clear the score for column 3 and Enter new score 1
		Doubleclick(ck.scre_col3);

		driver.findElement(By.xpath(ck.scre_col3)).sendKeys(Keys.BACK_SPACE);
		;

		type(ck.scre_col3, "1");

		// Click Save&Next button
		waitThread(5000);
		click(QP.savenext_btn);

		// Assert toasters
		// _"Please enter the Question"

		// _"Please enter the Conditions"

		// _"Please enter the Criteria 1"
		waitFor(ck.toasterquestion);
		
		Assert.assertTrue(getText(ck.toasterquestion).contains("Please enter the Question"));

		waitFor(ck.toasterquestionclosebtn);
		click(ck.toasterquestionclosebtn);
		Assert.assertTrue(getText(ck.toaster1).contains("Please enter the Conditions"));

		// click(QP.toasterclosebtn);
		waitFor(ck.toasterclosebtn1);
		click(ck.toasterclosebtn1);
		waitFor(ck.toaster2);
		Assert.assertTrue(getText(ck.toaster2).contains("Please enter the Criteria 1"));

		waitFor(ck.toasterclosebtn2);
		click(ck.toasterclosebtn2);
	}

	/*
	 * To check the score field validation toasters
	 */
	@Test(priority = 18)
	public void TCSPR090418() {

		// Clear the score for column 2 and Enter new score
		waitThread(4000);
		Doubleclick(ck.scre_col2);
		type(ck.scre_col2, "2");

		// Click Save&Next button
		waitThread(7000);
		click(QP.savenext_btn);
		waitFor(ck.toasterquestion);
		
		Assert.assertTrue(getText(ck.toasterquestion).contains("Please enter the Question"));

		waitFor(ck.toasterquestionclosebtn);
		click(ck.toasterquestionclosebtn);
		Assert.assertTrue(getText(ck.toaster1).contains("Please enter the Conditions"));

		// click(QP.toasterclosebtn);
		waitFor(ck.toasterclosebtn1);
		click(ck.toasterclosebtn1);
		waitFor(ck.toaster2);
		Assert.assertTrue(getText(ck.toaster2).contains("Please enter the Criteria 1"));

		waitFor(ck.toasterclosebtn2);
		click(ck.toasterclosebtn2);

		// Enter criteria1
		type(ck.crit1_bx, "CR1");

		waitThread(2000);
		click(QP.savenext_btn);

		// Assert toasters
		// _"Please enter the Question"

		// _"Please enter the Conditions"
		waitFor(ck.toasterquestion);
		
		Assert.assertTrue(getText(ck.toasterquestion).contains("Please enter the Question"));

		waitFor(ck.toasterquestionclosebtn);
		click(ck.toasterquestionclosebtn);
		Assert.assertTrue(getText(ck.toaster1).contains("Please enter the Conditions"));

		// click(QP.toasterclosebtn);
		waitFor(ck.toasterclosebtn1);
		click(ck.toasterclosebtn1);

		Scroll_DowntoEnd();
		waitThread(1000);

		// Click Add Row button
		click(QP.add_row);

		// Clear the second row scores
		Doubleclick(ck.scrore_r21);
		driver.findElement(By.xpath("//input[@id='scoreField_10']")).sendKeys(Keys.BACK_SPACE);
		;

		Doubleclick(ck.score_r22);
		driver.findElement(By.xpath("//input[@id='scoreField_11']")).sendKeys(Keys.BACK_SPACE);
		;

		Doubleclick(ck.score_r23);
		driver.findElement(By.xpath("//input[@id='scoreField_12']")).sendKeys(Keys.BACK_SPACE);
		;

		// click(ck.crit2_bx);
		// Click Save&Next button
		waitThread(3000);
		click(QP.savenext_btn);

		// Assert toasters
		// _"Please enter the Question"

		// _"Please enter the Scores, Conditions"
		// _"Please enter the Criteria 2"
		waitFor(ck.toasterquestion);
		
		Assert.assertTrue(getText(ck.toasterquestion).contains("Please enter the Question"));

		waitFor(ck.toasterquestionclosebtn);
		click(ck.toasterquestionclosebtn);
		waitFor(ck.toaster1);
		Assert.assertTrue(getText(ck.toaster1).contains("Please enter the Scores, Conditions"));

		// click(QP.toasterclosebtn);
		waitFor(ck.toasterclosebtn1);
		// click(ck.toasterclosebtn1);
		waitFor(ck.toaster2);
		Assert.assertTrue(getText(ck.toaster2).contains("Please enter the Criteria 2"));

		waitFor(ck.toasterclosebtn2);
		click(ck.toasterclosebtn2);

		// Enter scores for row2 zero
		click(ck.scrore_r21);
		type(ck.scrore_r21, "0");
		click(ck.score_r22);
		type(ck.score_r22, "0");
		click(ck.score_r23);
		type(ck.score_r23, "0");

		// Click Save&Next button
		waitThread(5000);
		click(QP.savenext_btn);

		// Assert toasters
		// -"Please enter the Question and number greater than zero on at least one
		// column in criteria(s)"

		// -"Please enter the Conditions"

		// -"Please enter the Criteria 1"
		waitFor(ck.toasterquestion);
		
		Assert.assertTrue(getText(ck.toasterquestion).contains(
				"Please enter the Question and number greater than zero on at least one column in criteria 2"));

		waitFor(ck.toasterquestionclosebtn);
		click(ck.toasterquestionclosebtn);
		Assert.assertTrue(getText(ck.toaster1).contains("Please enter the Conditions"));

		// click(QP.toasterclosebtn);
		waitFor(ck.toasterclosebtn1);
		click(ck.toasterclosebtn1);
		waitFor(ck.toaster2);
		Assert.assertTrue(getText(ck.toaster2).contains("Please enter the Criteria 2"));

		waitFor(ck.toasterclosebtn2);
		click(ck.toasterclosebtn2); // Enter score for column1 in row2 as 1
		type(ck.scrore_r21, "1");

		// Click Save&Next button
		waitThread(5000);
		click(QP.savenext_btn);

		// Assert toasters
		// _"Please enter the Question"

		// _"Please enter the Conditions"

		// _"Please enter the Criteria 2"
		waitFor(ck.toasterquestion);
		Assert.assertTrue(getText(ck.toasterquestion).contains("Please enter the Question"));

		waitFor(ck.toasterquestionclosebtn);
		click(ck.toasterquestionclosebtn);
		Assert.assertTrue(getText(ck.toaster1).contains("Please enter the Conditions"));

		// click(QP.toasterclosebtn);
		waitFor(ck.toasterclosebtn1);
		click(ck.toasterclosebtn1);
		waitFor(ck.toaster2);
		Assert.assertTrue(getText(ck.toaster2).contains("Please enter the Criteria 2"));

		waitFor(ck.toasterclosebtn2);
		click(ck.toasterclosebtn2);
	}

	/*
	 * To check the common validation toaster if there is more than 2 rows and
	 * columns
	 */
	@Test(priority = 19)
	public void TCSPR090419() {

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		// Click Clear all
		click(QP.clear_all);

		// Assert confirmation popup visible
		waitThread(1000);
		Assert.assertTrue(isElementPresent(QP.confi_pop), "Confirmation popup not visible");

		waitThread(1000);
		// Click Yes button
		click(ck.yes_btn);

		waitThread(2000);

		// Assert toaster "Cleared successfully"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Cleared successfully");
		click(QP.toasterclosebtn);

		ScrollTo_xy_position(0, 500);

		waitThread(1000);

		// Click Add column button three times
		click(QP.add_column);
		waitThread(1000);
		click(QP.add_column);
		waitThread(1000);
		click(QP.add_column);

		// Click Add Row button twice
		click(QP.add_row);
		waitThread(1000);
		click(QP.add_row);

		// Click Save&Next button
		waitThread(3000);
		click(QP.savenext_btn);

		// Assert toasters
		// -"Please enter the Question and number greater than zero on at least one
		// column in criteria(s)"
		// -"Please enter the Criterias, Scores, Conditions"

		Assert.assertTrue(getText(ck.toasterquestion).contains("Please enter the Question"));

		waitFor(ck.toasterquestionclosebtn);
		click(ck.toasterquestionclosebtn);
		Assert.assertTrue(getText(ck.toaster1).contains("Please enter the Criterias, Scores, Conditions"));

		// click(QP.toasterclosebtn);
		waitFor(ck.toasterclosebtn1);
		click(ck.toasterclosebtn1);

		// Enter score for column 1 of row1
		type(ck.scre_col1, "1");
		// Enter score for column 1 of row2
		type(ck.scrore_r21, "1");
		// Enter score for column 1 of row3
		type(ck.score_r31, "1");

		// Click Save&Next button
		waitThread(3000);
		click(QP.savenext_btn);

		// Assert toasters
		// -"Please enter the Question"
		// -"Please enter the Criterias, Scores, Conditions"
		waitFor(ck.toasterquestion);
		
		Assert.assertTrue(getText(ck.toasterquestion).contains("Please enter the Question"));

		waitFor(ck.toasterquestionclosebtn);
		click(ck.toasterquestionclosebtn);
		Assert.assertTrue(getText(ck.toaster1).contains("Please enter the Criterias, Scores, Conditions"));

		// click(QP.toasterclosebtn);
		waitFor(ck.toasterclosebtn1);
		click(ck.toasterclosebtn1);

	}

	/*
	 * To check the Rubric Score validations
	 */
	@Test(priority = 20)
	public void TCSPR090420() {

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		// Assert Clear all button
		Assert.assertTrue(isElementPresent(QP.clear_all), "Clear All button not present");

		// Click Clear all
		click(QP.clear_all);

		waitThread(1000);
		// Click Yes button
		click(ck.yes_btn);

		waitThread(2000);

		ScrollTo_xy_position(0, 500);
		waitThread(1000);

		// Click Add column button
		click(QP.add_column);

		// Enter score as 1
		type(ck.scre_col1, "1");

		// (Enter backspace) clear the score
		driver.findElement(By.xpath("//input[@id='scoreField_00']")).sendKeys(Keys.BACK_SPACE);

		// Assert the validation message "Score range should be 0-20"
		Assert.assertEquals(getText(ck.valid_msg_score), "*Score range should be 0-20");

		// Enter score zero
		type(ck.scre_col1, "0");

		// Click Save&Exit button
		click(QP.savexit_btn);

		// Assert Toasters
		// - "Please enter the Question and number greater than zero on score for
		// 'column 1' in Criteria 1"

		// -"Please enter the Condition for 'Column 1' in Criteria 1"
		
		// -"Please enter the Criteria 1"
		waitFor(ck.toasterquestion);
		
		
		Assert.assertTrue(getText(ck.toasterquestion).contains(
				"Please enter the Question and number greater than zero on score for 'column 1' in Criteria 1"));

		waitFor(ck.toasterquestionclosebtn);
		click(ck.toasterquestionclosebtn);
		Assert.assertTrue(getText(ck.toaster1).contains("Please enter the Condition for 'Column 1' in Criteria 1"));

		// click(QP.toasterclosebtn);
		waitFor(ck.toasterclosebtn1);
		click(ck.toasterclosebtn1);
		waitFor(ck.toaster2);
		Assert.assertTrue(getText(ck.toaster2).contains("Please enter the Criteria 1"));

		waitFor(ck.toasterclosebtn2);
		click(ck.toasterclosebtn2);

		// Clear the score
		click(ck.scre_col1);
		driver.findElement(By.xpath("//input[@id='scoreField_00']")).sendKeys(Keys.BACK_SPACE);

		// Enter score 25
		type(ck.scre_col1, "25");

		// Assert the validation message "Score range should be 0-20"
		Assert.assertEquals(getText(ck.valid_msg_score), "*Score range should be 0-20");

	}

	/*
	 * To check the save button functionality
	 */
	@Test(priority = 21)
	public void TCSPR090421() {

		ScrollTo_xy_position(0, 0);
		waitThread(1000);
		// Click Clear All button
		click(QP.clear_all);

		waitThread(2000);
		// Click Yes button
		click(QP.yes_btn);

		waitThread(5000);
		// Assert the question box is cleared
		driver.switchTo().frame("question_ifr");
		waitThread(1000);
		Assert.assertEquals(getText("//body[@data-id='question']"), "");
		driver.switchTo().defaultContent();

		// Type a question on Question box
		driver.switchTo().frame("question_ifr");
		click(QP.Quest_box);
		type(QP.Quest_box, "Question1");
		driver.switchTo().defaultContent();

		waitThread(1000);
		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);

		// Assert the datas of Rubrics are cleared
		waitThread(5000);
		Assert.assertEquals(getText(QP.click_rubric_holder), "No Rubric Created !");

		// Click Add column button
		click(QP.add_column);
		waitThread(2000);

		// Enter criteria 1
		type(ck.crit1_bx, "CR1");

		// Enter score
		type(ck.scre_col1, "2");

		waitThread(2000);
		// Enter Condition
		driver.switchTo().frame(1);
		waitThread(2000);
		type(ck.enter_con, "Good");
		driver.switchTo().defaultContent();

		waitThread(1000);
		// Scroll Up page
		ck.scrolup();
		waitThread(2000);
		// Click Save button
		click(QP.save);
		waitFor(QP.toaster);

		// Assert the toaster "Question1 Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);

		waitThread(1000);
		// Click Save&Next button
		click(QP.savenext_btn);

		// Assert no toaster displayed
		Assert.assertFalse(isElementPresent(QP.toaster), "Toaster displayed");

		waitThread(1000);
		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	/*
	 * To check editor buttons of clickable rubric
	 */
	@Test(priority = 22)
	public void TCSPR090422() {

		// Click Questions circle on wizard
		click(ck.Quest_wizard);

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);

		// Asssert the clickable rubric radio button is checked
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		QP.Scroll_DowntoEnd();

		// Assert the Bold button
		Assert.assertTrue(isElementPresent(ck.Bold_btn), "Bold button is not present");

		// Assert the Italic button
		Assert.assertTrue(isElementPresent(ck.italic_btn), "Italic button is not present");

		// Assert the underline button
		Assert.assertTrue(isElementPresent(ck.underline_btn), "Underline button is not present");

		// Assert the formula editor buttons
		Assert.assertTrue(isElementPresent(ck.math_edit_btn), "Math formula editor button is not present");
		Assert.assertTrue(isElementPresent(ck.chem_edit_btn), "Chem formula editor button is not present");

	}

	/*
	 * To check the function of editor in clickable rubric
	 */
	@Test(priority = 23)
	public void TCSPR090423() {

		// Click on condition box
		driver.switchTo().frame(1);
		waitThread(2000);
		click(ck.enter_con);

		// select the text in condition box
		Actions dummy = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//*[@id='tinymce']"));
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
	@Test(priority = 24)
	public void TCSPR090424()

	{
		// select the text in condition box
		driver.switchTo().frame(1);
		waitThread(2000);
		click(ck.enter_con);
		Actions dummy = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//*[@id='tinymce']"));
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
	@Test(priority = 25)
	public void TCSPR090425() {

		ck.scrolup();
		// Click on Standard rubric radio button
		waitThread(2000);
		click(QP.std_rad);

		waitThread(1000);
		// Assert the Confirmation popup visible
		Assert.assertTrue(isElementPresent(ck.confirm_pop), "Confirmation popup not visible");

		waitThread(1000);
		// Click Continue editing
		click(ck.cont_edit_btn);

		// Assert the editor is opened
		Assert.assertTrue(isDisplayed(ck.chem_edit_bx), "Chem editor not displayed");

		// Assert the radio button of Clickable rubric is checked
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		waitThread(2000);
		// click Standard rubric radio button
		click(QP.std_rad);
		waitThread(1000);
		// Click Discard button
		click(ck.dis_btn);

		// Assert the formula editor is closed
		Assert.assertFalse(isElementPresent(ck.chem_edit_bx), "math editor displayed");

	}

	/*
	 * To delete row fubctionality
	 */
	@Test(priority = 26)
	public void TCSPR090426() {

		// Assert the radio button of Standard rubric is checked
		Assert.assertTrue(isDisplayed(QP.std_rad), "Radio button is not checked");

		// click on clickable rubric radio buton
		click(QP.click_radio);

		waitThread(1000);
		// click on Remove last row button
		click(QP.remov_lastcolum);

		waitThread(1000);

		// Click Yes button
		click(ck.yes_btn);

		waitThread(3000);
		// Assert the text "No Rubric Created"
		Assert.assertEquals(getText(QP.click_rubric_holder), "No Rubric Created !");

	}

	/*
	 * To check the Max score functionality of Clickable rubric
	 */
	@Test(priority = 27)
	public void TCSPR090427() {
		waitThread(2000);
		// Click Add column button twice
		Doubleclick(QP.add_column);

		// Assert the label "Score for column2"
		Assert.assertEquals(getText(ck.score_fr_column2_lbl), "Score for Column 2");

		// Enter criteria 1
		type(ck.crit1_bx, "CR1");

		// Enter score for column1
		type(ck.scre_col1, "2");

		// Enter score for column2
		type(ck.scre_col2, "1");

		// Enter Conditions
		driver.switchTo().frame(1);
		waitThread(2000);
		type(ck.enter_con, "Good");
		driver.switchTo().defaultContent();

		waitThread(1000);
		driver.switchTo().frame(2);
		waitThread(2000);
		type(ck.enter_con, "Average");
		driver.switchTo().defaultContent();

		waitThread(1000);

		// page scroll up
		ck.scrolup();

		waitThread(3000);
		// Assert the Max.score is 2
		Assert.assertEquals(getValue(QP.max_scorbx), "2");

	}

	/*
	 * To check whether the Max.Score of clickable rubric is the Sum of Max Score of
	 * each row
	 */
	@Test(priority = 28)
	public void TCSPR090428() {
		// Click Add Row button

		waitThread(1000);
		click(QP.add_row);

		// Enter criteria 2
		type(ck.crit2_bx, "CR2");

		waitThread(2000);
		// Enter score of column2 of second row
		click(ck.score_r22);

		driver.findElement(By.xpath("//input[@id='scoreField_11']")).clear();
		type(ck.score_r22, "3");

		// Enter Conditions for Row 2

		driver.switchTo().frame("editorFieldRubric_10_ifr");
		type(ck.enter_con, "Good");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("editorFieldRubric_11_ifr");
		type(ck.enter_con, "Average");
		driver.switchTo().defaultContent();

		waitThread(1000);

		// page scroll up
		ck.scrolup();

		waitThread(1000);
		// Assert the Max score is 5
		Assert.assertEquals(getValue(QP.max_scorbx), "5");

		waitThread(1000);
		// Click Save&Next button
		click(QP.savenext_btn);

		// Assert the label "Peer Review"
		waitThread(1000);
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	/*
	 * To check the Max score possible field
	 */
	@Test(priority = 29)
	public void TCSPR090429() {

		// Click Questions circle on wizard
		click(ck.Quest_wizard);

		// Assert the question label on wizard
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");
		waitThread(3000);

		// Assert the Max score possible is 5
		Assert.assertEquals(getText(QP.max_scoreposs_value), "5");

	}

	/*
	 * To check whether the Max.score field is updating while switching the rubric
	 * radio buttons
	 */
	@Test(priority = 30)
	public void TCSPR090430() {

		waitThread(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		// Assert the heading "Add Rubric"
		Assert.assertEquals(getText(QP.Add_rublabel), "Add Rubric");

		// Click Standard rubric radio button
		click(QP.std_rad);

		waitThread(2000);
		// Assert the Standard rubric box is visible
		Assert.assertTrue(isDisplayed(ck.std_rub_txtbx), "Standard Rubric box not visible");

		// page scroll up
		ck.scrolup();
		waitThread(5000);

		System.out.println(getValue(QP.max_scorbx));
		// Assert the Max score field is empty
		Assert.assertEquals(getValue(QP.max_scorbx), "0");

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		// Click clickable rubric radio button
		click(QP.click_radio);

		waitThread(2000);
		// Assert the criteria 1 and criteria 2 box are visible
		Assert.assertTrue(isElementPresent(ck.crit1_bx), "Criteria1 box is not visible");
		Assert.assertTrue(isElementPresent(ck.crit2_bx), "Criteria 2 box not visible");

		// page scroll up
		ck.scrolup();
		waitThread(2000);

		// Assert the Max score is 5
		Assert.assertEquals(getValue(QP.max_scorbx), "5");

	}

	/*
	 * To check whether the Max.score field is updating while switching the rubric
	 * radio buttons
	 */
	@Test(priority = 31)
	public void TCSPR090431() {

		// Click on Standard rubric radio button
		waitThread(3000);
		click(QP.std_rad);

		waitThread(3000);
		// Assert the Standard rubric box is visible
		Assert.assertTrue(isDisplayed(ck.std_rub_txtbx), "Standard Rubric box not visible");

		// page scroll up
		ck.scrolup();
		waitThread(6000);
		
		// Assert the Max score is 5
		Assert.assertEquals(getValue(QP.max_scorbx), "5");

		// Enter data in Standard rubric box
		driver.switchTo().frame("rubric_ifr");

		waitThread(4000);
		type(QP.std_rub_bx, "R1");

		waitThread(3000);

		// Assert the data in Standard rubric box
		Assert.assertEquals(getText(QP.std_rub_bx), "R1");
		driver.switchTo().defaultContent();
		waitThread(3000);

		// page scroll up
		ck.scrolup();
		waitThread(3000);

		driver.findElement(By.xpath("//input[@id='maxScore']")).clear();
		// Enter Max score as 3
		type(QP.max_scorbx, "3");

		waitThread(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");


		waitThread(7000);
		// Click clickable rubric radio button
		click(QP.click_radio);

		// Assert the confirmation popup visible
		waitThread(5000);
		Assert.assertTrue(isElementPresent(ck.confirm_pop), "Confirmation popup not visible");

		waitThread(2000);
		// Click Discard button
		click(ck.dis_btn);

		// Assert the criteria 1 and criteria 2 box are visible
		Assert.assertTrue(isElementPresent(ck.crit1_bx), "Criteria1 box is not visible");
		Assert.assertTrue(isElementPresent(ck.crit2_bx), "Criteria 2 box not visible");

		// page scroll up
		ck.scrolup();
		waitThread(3000);

		// Assert the Max score is 5
		Assert.assertEquals(getValue(QP.max_scorbx), "5");

		waitThread(4000);

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Enter data in Standard rubric box
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);
		type(QP.std_rub_bx, "R1");

		waitThread(1000);
		driver.switchTo().defaultContent();
		waitThread(2000);

		// page scroll up
		ck.scrolup();
		waitThread(2000);

		driver.findElement(By.xpath("//input[@id='maxScore']")).clear();
		// Enter Max score as 3
		type(QP.max_scorbx, "3");

		waitThread(3000);
		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert toaster "Question1 Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");

	}

	/*
	 * To check whether the Max.score field is updating while switching the rubric
	 * radio buttons
	 */
	@Test(priority = 32)
	public void TCSPR090432() {

		waitThread(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		waitThread(4000);
		// Click clickable rubric radio button
		click(QP.click_radio);

		// Assert the placeholder "No rubrics created"
		waitThread(5000);
		Assert.assertEquals(getText(QP.click_rubric_holder), "No Rubric Created !");

		// page scroll up
		ck.scrolup();
		waitThread(2000);

		// Assert the Max score field is empty
		Assert.assertEquals(getValue(QP.max_scorbx), "0");

		waitThread(1000);

		// Click on Standard rubric radio button
		click(QP.std_rad);

		// Assert the data in Standard rubric box
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);
		Assert.assertEquals(getText(QP.std_rub_bx), "R1");
		driver.switchTo().defaultContent();
		waitThread(1000);

		// page scroll up
		ck.scrolup();
		waitThread(2000);

		// Assert Max score is 3
		Assert.assertEquals(getValue(QP.max_scorbx), "3");

		// Assert Max score possible 3
		waitThread(1000);
		Assert.assertEquals(getText(QP.max_scoreposs_value), "3");

	}
	/*
	 * To perform logout functionality
	 */

	@Test(priority = 33)
	public void TCSPR090433() {

		// perform logout
		cm.Logout();

		// Assert the heading "Login"
		Assert.assertEquals(getText(QP.hd_label11), "Login");

	}

}
