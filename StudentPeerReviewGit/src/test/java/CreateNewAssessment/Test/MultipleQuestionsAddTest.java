package CreateNewAssessment.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Generalmethods.CommonMethods;

import Course.Pages.CourseRosterPage;
import CreateNewAssessment.Pages.ClickableRubricPage;
import CreateNewAssessment.Pages.MultipleQuestionsAddPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Test.SignUpTest;

public class MultipleQuestionsAddTest extends basePage {

	MultipleQuestionsAddPage mq = new MultipleQuestionsAddPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	SignUpTest st = new SignUpTest();
	CourseRosterPage cr = new CourseRosterPage();
	LoginPage lg = new LoginPage();
	ClickableRubricPage ck = new ClickableRubricPage();
	CommonMethods cm = new CommonMethods();

	public String Teacher_firstname = "Test";
	public String Teacher_lastname = "Teacher";
	public String Teacher_fullname;
	public String Password = "Abc@123";
	public String EmailTeacher;
	public String CourseTitle= cm.CourseName1;
	public String Assessment_name;
	public String CourseID;


	/*
	 * To load the Student Peer Review Landing Page
	 */
	
	@Test(priority = 1)
	public void TCSPR090301() throws SQLException {
		Teacher_firstname = "Test";
		Teacher_lastname = "Teacher";
		Teacher_fullname = Teacher_firstname + " " + Teacher_lastname;
		Password = "Abc@123";

		click(lg.LoginBtn_1);

		cm.login(cm.emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	

	/*
	 * To create a course for creating an Assessment
	 */
	//@Test(priority = 2)
	//public void TCSPR090502() {

		// Click Create New courses button
	//	click(QP.create_coursebtn);

	//	CourseTitle = "Maths" + generateRandomNumber().trim();
		// To get the Course ID
	//	CourseID = (getText(QP.course_Id));

		// Type course name on course title
	//	type(QP.txbx_Coursetitle, CourseTitle);

		//waitThread(6000);
		// Click Create Course button
	//	click(QP.create_crsbtn);

	//	waitFor(QP.toaster);
		// Assert the toaster "Course created successfully
	//	Assert.assertEquals(getText(QP.toaster), "Course created successfully");
	//	click(QP.toasterclosebtn);

		// Assert the created course visible on the grid
	//	Assert.assertEquals(getText(QP.course_namegrid), CourseTitle);
	//}

	/*
	 * To add basic details of an assessment
	 */
	@Test(priority = 3)
	public void TCSPR090503() {

		waitThread(2000);
		// Click Assessments tab
		click(QP.Assessmenttab);

		waitThread(2000);
		// Click Create New Assessment button
		click(QP.creatnew_assessbtn);

		waitThread(2000);
		// Assert the basic details label
		Assert.assertEquals(getText(QP.basic_detls_wizard), "Basic Details");

		// Select the created course from course dropdown
		waitThread(1000);
		click(QP.cours_drp);
		click(QP.coursname_drp);

		// Assert the Selected course is same as created course
		Assert.assertEquals(getText(QP.coursname_drp), CourseTitle);

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

		// Assert the Questions label on Wizard
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

	}

	/*
	 * To Enter datas on questions page
	 */
	@Test(priority = 4)
	public void TCSPR090504() {

		// Enter Question
		driver.switchTo().frame("question_ifr");
		type(QP.Quest_box, "Question1");
		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);

		// Click rubric dropdown
		click(QP.rubric_drp_btn);
		waitThread(3000);

		// Assert the clickable rubric radio button is enabled
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		// Add Column
		click(QP.add_column);

		// Enter Criteria
		type(ck.crit1_bx, "CR1");

		// Enter score for column1
		type(ck.scre_col1, "2");

		// Enter condition
		driver.switchTo().frame("editorFieldRubric_00_ifr");
		waitThread(2000);
		type(ck.enter_con, "Good");
		driver.switchTo().defaultContent();

		// page scroll up
		ck.scrolup();

		// Assert Max score is two
		Assert.assertEquals(getValue(QP.max_scorbx), "2");

	}

	/*
	 * To Add more questions to the questions page
	 */
	@Test(priority = 5)
	public void TCSPR090505() {

		waitThread(1000);
		// Assert + button to add more questions
		Assert.assertTrue(isElementPresent(mq.add_quest_btn), "Add more question button not present");

		waitThread(1000);
		// Click on +button
		click(mq.add_quest_btn);
		waitThread(1000);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);

		// Assert the label "2.Questions"
		Assert.assertEquals(getText(QP.question1), "2." + "\nQuestion");

		waitThread(2000);
		// Assert the Max score possible 2
		Assert.assertEquals(getText(QP.max_scoreposs_value), "2");

	}

	/*
	 * To check the Max score &Max score posssible functions
	 */
	@Test(priority = 6)
	public void TCSPR090506() {

		// Enter Question2
		driver.switchTo().frame("question_ifr");
		type(QP.Quest_box, "Question2");
		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);

		// Click rubric dropdown
		click(QP.rubric_drp_btn);
		waitThread(3000);

		// Double Click Add Column
		Doubleclick(QP.add_column);

		// Enter criteria 1
		type(ck.crit1_bx, "CR1");

		// Enter score for column1
		type(ck.scre_col1, "3");

		// Enter score for column2
		type(ck.scre_col2, "2");

		// Enter Conditions
		driver.switchTo().frame("editorFieldRubric_00_ifr");
		waitThread(2000);
		type(ck.enter_con, "Good");
		driver.switchTo().defaultContent();

		waitThread(1000);
		driver.switchTo().frame("editorFieldRubric_01_ifr");
		waitThread(2000);
		type(ck.enter_con, "Average");
		driver.switchTo().defaultContent();

		// page scroll up
		ck.scrolup();

		waitThread(1000);
		// Assert the Max score is 3
		Assert.assertEquals(getValue(QP.max_scorbx), "3");

		// Assert Max score possible is 2
		Assert.assertEquals(getText(QP.max_scoreposs_value), "2");

	}

	/*
	 * To check the Add more Questions functionality
	 */
	@Test(priority = 7)
	public void TCSPR090507() {

		waitThread(5000);
		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully");
		click(QP.toasterclosebtn);

		MouseHover(QP.quest_bankcheckbx);
		waitThread(2000);
		// Click + button
		click(mq.add_quest_btn);

		// Assert no toaster displayed
		Assert.assertFalse(isElementPresent(QP.toaster), "Toaster displayed");

		// Assert the box3 of question is visible
		Assert.assertTrue(isDisplayed(mq.q3_btn_higlight), "Question3 button not present");

		// Assert the question3 button is highlighted
		Assert.assertTrue(isDisplayed(mq.q3_btn_higlight), "Question3 button is not highlighted");

		// Assert the label "3.Question"
		Assert.assertEquals(getText(QP.question1), "3." + "\nQuestion");

		// Assert Max score possible 5
		Assert.assertEquals(getText(QP.max_scoreposs_value), "5");

		// Assert Max score is empty
		Assert.assertEquals(getValue(QP.max_scorbx), "");

	}

	/*
	 * To perform questions switching functionality
	 */
	@Test(priority = 8)
	public void TCSPR090508() {

		// Enter Question3
		driver.switchTo().frame("question_ifr");
		type(QP.Quest_box, "Question3");
		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);

		// Click standard rubric radio button
		click(QP.std_rad);

		waitThread(2000);
		// Enter data in rubric box
		driver.switchTo().frame("rubric_ifr");
		waitThread(2000);
		type(QP.std_rub_bx, "Rubric");
		waitThread(2000);
		driver.switchTo().defaultContent();

		// Enter Max score
		type(QP.max_scorbx, "3");

		// Click Save button
		click(QP.save);

		waitThread(1000);
		// Click question1 button
		click(mq.q1_btn);

		// Assert the 1.Question label
		Assert.assertEquals(getText(QP.question1), "1." + "\nQuestion");

		// Assert the question1 button is highlighted
		Assert.assertTrue(isDisplayed(mq.q1_btn), "Question1 button is not highlighted");

		waitThread(6000);
		// Click question2 button
		click(mq.q2_btn);

		waitThread(4000);
		// Assert the 2.Question label
		Assert.assertEquals(getText(QP.question1), "2." + "\nQuestion");

		// Assert the question2 button is highlighted
		Assert.assertTrue(isDisplayed(mq.q2_btn), "Question2 button is not highlighted");

	}

	/*
	 * To check mandatory toasters after clicking + button
	 */
	@Test(priority = 9)
	public void TCSPR090509() {

		waitThread(3000);
		// Click + button
		click(mq.add_quest_btn);

		waitThread(3000);
		// Assert the label "4.Question"
		Assert.assertEquals(getText(QP.question1), "4." + "\nQuestion");

		// Assert the question 4 button is highlighted
		Assert.assertTrue(isDisplayed(mq.q4_btn), "Question4 button is not highlighted");

		// Click + button
		click(mq.add_quest_btn);

		// Assert the toaster "Please enter the Question and mandatory fields in
		// Rubrics"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Please enter the Question and Rubric");
		click(QP.toasterclosebtn);

	}

	/*
	 * To remove a question from questions page
	 */
	@Test(priority = 10)
	public void TCSPR090510() {

		waitThread(2000);
		// Click Remove Question Button
		click(QP.remove_quest);

		waitThread(2000);
		// Assert the confirmation popup
		Assert.assertTrue(isElementPresent(ck.confirm_pop), "Confirmation popup not displayed");

		waitThread(1000);
		// Click yes button
		click(ck.yes_btn);

		waitThread(5000);
		// Assert the label "3.Question"
		Assert.assertEquals(getText(QP.question1), "3." + "\nQuestion");

		// Assert the question4box not visible
		Assert.assertFalse(isElementPresent(mq.q4_btn), "Question4 button is visible");

		// Assert question no 3 highlighted
		Assert.assertTrue(isElementPresent(mq.q3_btn_higlight), "Question3 button is not highlighted");
	}

	/*
	 * To check whether the confirmation popup is visible, after editing the
	 * question and then switch to another question
	 */
	@Test(priority = 11)
	public void TCSPR090511() {

		// clear question3 box
		driver.switchTo().frame("question_ifr");
		driver.findElement(By.xpath("//body[@data-id='question']")).clear();

		// Edit Question3
		type(QP.Quest_box, "Quest3");
		driver.switchTo().defaultContent();

		waitThread(1000);
		// Assert question 2 button present
		Assert.assertTrue(isDisplayed(mq.q2_btn), "Question2 button is not present");

		// Click question2 button
		click(mq.q2_btn);

		waitThread(1000);
		// Assert Confirmation popup visible
		Assert.assertTrue(isElementPresent(ck.confirm_pop), "Confirmation popup not displayed");

		// Click Continue editing
		click(ck.cont_edit_btn);

		// Assert the edited data visible on the question3 box
		driver.switchTo().frame("question_ifr");

		Assert.assertEquals(getText(QP.Quest_box), "Quest3");
		driver.switchTo().defaultContent();

		waitThread(1000);
		// Click questionbox2 button
		click(mq.q2_btn);

		waitThread(1000);
		// Click Discard
		click(ck.dis_btn);

		waitThread(2000);
		// Assert the 2.Question label
		Assert.assertEquals(getText(QP.question1), "2." + "\nQuestion");

		// Assert the question2 button is highlighted
		Assert.assertTrue(isDisplayed(mq.q2_btn), "Question2 button is not highlighted");

	}

	/*
	 * To check the close button function of confirmation popup
	 */
	@Test(priority = 12)
	public void TCSPR090512() {

		waitThread(1000);
		// Click question3 button
		click(mq.q3_btn);

		waitThread(2000);
		// Assert the label "3.Question"
		Assert.assertEquals(getText(QP.question1), "3." + "\nQuestion");

		// Assert question no 3 highlighted
		Assert.assertTrue(isElementPresent(mq.q3_btn_higlight), "Question3 button is not highlighted");

		// clear question3 box
		driver.switchTo().frame("question_ifr");
		driver.findElement(By.xpath("//body[@data-id='question']")).clear();

		// Edit Question3
		type(QP.Quest_box, "Question321");
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click question2 button
		click(mq.q2_btn);

		waitThread(5000);
		// Assert Confirmation popup visible
		Assert.assertTrue(isElementPresent(ck.confirm_pop), "Confirmation popup not displayed");

		waitThread(2000);
		// Assert the close button
		Assert.assertTrue(isElementPresent(ck.conf_close_btn), "Close button not present");

		waitThread(2000);
		// Click close button on popup
		click(ck.conf_close_btn);

		// Assert the label "3.Question"
		Assert.assertEquals(getText(QP.question1), "3." + "\nQuestion");

		// Assert question no 3 highlighted
		Assert.assertTrue(isElementPresent(mq.q3_btn_higlight), "Question3 button is not highlighted");

		// Assert the edited data in the question box
		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), "Question321");
		driver.switchTo().defaultContent();

	}

	/*
	 * To check whether the saved question is visible on the questions page after
	 * giving Save&Exit
	 */
	@Test(priority = 13)
	public void TCSPR090513() {

		Assert.assertTrue(isElementPresent(QP.savexit_btn), "Save&Exit button not present");
		waitThread(4000);

		// Click Save&Exit button
		click(QP.savexit_btn);

		waitThread(1000);
		// Assert the Heading "draft"
		Assert.assertEquals(getText(QP.tabdraft), "Draft");

		click(QP.tabdraft);

		waitThread(4000);
		// Click Continue editing
		click(QP.continue_edit);

		// Assert the Basic details label on Wizard is highlighted
		Assert.assertTrue(isElementPresent(QP.basic_det_highlight), "Basic Details label is not highlighted");

		waitThread(2000);
		// Click Save &Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the label "3.Question"
		Assert.assertEquals(getText(QP.question1), "3." + "\nQuestion");

		// Assert question no 3 highlighted
		Assert.assertTrue(isElementPresent(mq.q3_btn_higlight), "Question3 button is not highlighted");

	}

	/*
	 * To check whether the user can go back to previous page by click on wizard
	 */
	@Test(priority = 14)
	public void TCSPR090514() {

		waitThread(4000);
		// Click on Basic details circle on wizard
		click(QP.basic_detls_wizard);

		waitThread(3000);

		// Assert the Basic details label on Wizard is highlighted
		Assert.assertEquals(getAttribute(QP.basic_det_highlight, "aria-selected"), "true");

		// Assert the Assessment Info heading
		Assert.assertEquals(getText(QP.lbl_assessmentinfo), "Assessment Information for Students");

	}

	/*
	 * To check whether the remove question can remove Max score possible
	 */
	@Test(priority = 15)
	public void TCSPR090515() {

		waitThread(2000);
		// Click Save &Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the 3.Question label
		waitThread(3000);
		Assert.assertEquals(getText(QP.question1), "3." + "\nQuestion");

		// Assert the Max score possible is 8
		Assert.assertEquals(getText(QP.max_scoreposs_value), "8");

		// Click Remove Question Button
		click(QP.remove_quest);

		waitThread(5000);
		// Assert Confirmation popup visible
		Assert.assertTrue(isElementPresent(ck.confirm_pop), "Confirmation popup not displayed");

		// Click yes button
		click(ck.yes_btn);

		// Assert the Max score possible is 8
		Assert.assertEquals(getText(QP.max_scoreposs_value), "8");
	}

	/*
	 * To check the clear all functionality
	 */
	@Test(priority = 16)
	public void TCSPR090516() {

		waitThread(2000);
		// Assert the 2.Question label
		Assert.assertEquals(getText(QP.question1), "2." + "\nQuestion");

		// Assert the question2 button is highlighted
		Assert.assertTrue(isDisplayed(mq.q2_btn), "Question2 button is not highlighted");

		// Click clear all button
		click(QP.clear_all);

		waitThread(5000);
		// Assert Confirmation popup visible
		Assert.assertTrue(isElementPresent(ck.confirm_pop), "Confirmation popup not displayed");

		// Click yes button
		click(ck.yes_btn);

		// Assert the max score field is empty
		Assert.assertEquals(getValue(QP.max_scorbx), "");

		// Assert the question box is empty
		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), "");
		driver.switchTo().defaultContent();

		waitThread(6000);
		// scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		waitThread(2000);
		// Assert the place holder "No Rubrics created "
		Assert.assertEquals(getText(QP.click_rubric_holder), "No Rubric Created !");

		ck.scrolup();
		waitThread(4000);

		// Click Discard button
		click(QP.discard_btn);

		// Confirmation popup yes button
		click(QP.Confirm_btnYes);

		waitThread(1000);
		// Assert the Heading "draft"
		Assert.assertEquals(getText(QP.tabdraft), "Draft");

		click(QP.tabdraft);

		waitThread(4000);
		// Click Continue editing
		click(QP.continue_edit);

		// Assert the Basic details label on Wizard is highlighted
		Assert.assertTrue(isElementPresent(QP.basic_det_highlight), "Basic Details label is not highlighted");

		waitThread(2000);
		// Click Save &Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the label "2.Question"
		Assert.assertEquals(getText(QP.question1), "2." + "\nQuestion");

		// Assert question no 2 highlighted
		Assert.assertTrue(isElementPresent(mq.q3_btn_higlight), "Question2 button is not highlighted");

		waitThread(3000);
		MouseHover(QP.quest_bankcheckbx);
		
		// Click on +button
		click(mq.add_quest_btn);
		waitThread(3000);

		// Assert the label "3.Question"
		Assert.assertEquals(getText(QP.question1), "3." + "\nQuestion");

		// Assert question no 3 highlighted
		Assert.assertTrue(isDisplayed(mq.q3_btn_higlight), "Question3 button is not highlighted");

		// Click question2 button
		click(mq.q2_btn);

		// Assert the already added data in Question 2 box
		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), "Question2");
		driver.switchTo().defaultContent();

		// Assert the Score in max score box 3
		Assert.assertEquals(getValue(QP.max_scorbx), "3");

		// Assert the Question No 3 visible
		Assert.assertTrue(isElementPresent(mq.q3_btn), "Question3 button is not present");

	}

	/*
	 * To check the function of Remove Questions
	 */
	@Test(priority = 17)
	public void TCSPR090517() {

		waitThread(2000);
		// Click question3 button
		click(mq.q3_btn);

		waitThread(3000);
		// Assert the 3.Question label
		Assert.assertEquals(getText(QP.question1), "3." + "\nQuestion");

		waitThread(2000);
		// Assert Question 3 box is empty
		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), "");
		driver.switchTo().defaultContent();

		waitThread(2000);
		// click Remove Question Button
		click(QP.remove_quest);

		waitThread(3000);
		// Click Yes button
		click(ck.yes_btn);

		waitThread(2000);
		// Assert the 2.Question label
		Assert.assertEquals(getText(QP.question1), "2." + "\nQuestion");

		// Assert the question2 button is highlighted
		Assert.assertTrue(isDisplayed(mq.q2_btn), "Question2 button is not highlighted");

		// Click first question number
		click(mq.q1_btn);

		// Assert the 1.Question label
		Assert.assertEquals(getText(QP.question1), "1." + "\nQuestion");

		// Assert the question1 button is highlighted
		Assert.assertTrue(isDisplayed(mq.q1_btn), "Question2 button is not highlighted");

		// Assert the data of question1
		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), "Question1");
		driver.switchTo().defaultContent();

		waitThread(1000);
		// Click Remove Question Button
		click(QP.remove_quest);

		waitThread(3000);
		// Assert the confirmation popup
		Assert.assertTrue(isElementPresent(ck.confirm_pop), "Confirmation popup not displayed");

		waitThread(2000);
		// Click Yes button
		click(ck.yes_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Removed successfully "
		Assert.assertEquals(getText(QP.toaster), "Removed successfully");
		click(QP.toasterclosebtn);

		// Assert the data of Question2 in question1 box
		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), "Question2");
		driver.switchTo().defaultContent();

		// Assert the Max score is 3
		Assert.assertEquals(getValue(QP.max_scorbx), "3");

		// Assert the question2 number is not visible
		Assert.assertFalse(isElementPresent(mq.q2_btn), "Question2 button is visible");

	}

	/*
	 * To check the Max score field validations
	 */
	@Test(priority = 18)
	public void TCSPR090518() {

		// page Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		waitThread(2000);
		// Click standard rubric radio button
		click(QP.std_rad);

		// Enter data in rubric box
		driver.switchTo().frame("rubric_ifr");
		waitThread(2000);
		type(QP.std_rub_bx, "Rubric");
		waitThread(2000);
		driver.switchTo().defaultContent();

		waitThread(1000);

		ck.scrolup();
		waitThread(3000);
		// Assert the max score value is 0
		Assert.assertEquals(getValue(QP.max_scorbx), "0");

		// Assert the Max score possible is 0
		Assert.assertEquals(getText(QP.max_scoreposs_value), "0");

		// Type Max score
		driver.findElement(By.xpath("//input[@id='maxScore']")).clear();
		type(QP.max_scorbx, "500");

		// Assert no validation toaster
		Assert.assertFalse(isElementPresent(QP.toaster), "No validation toaster displayed");

		waitThread(7000);
		// Assert the max score field with value 500
		Assert.assertEquals(getValue(QP.max_scorbx), "500");

		// Assert Max score possible is 500
		Assert.assertEquals(getText(QP.max_scoreposs_value), "500");

		// Clear the Max score field
		driver.findElement(By.xpath("//input[@id='maxScore']")).clear();

		waitThread(2000);
		click(QP.max_scorbx);
		// Type Max score "555555"
		driver.findElement(By.xpath("//input[@id='maxScore']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@id='maxScore']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@id='maxScore']")).sendKeys("5");
		waitThread(2000);
		driver.findElement(By.xpath("//input[@id='maxScore']")).sendKeys("5");
		waitThread(2000);
		
		click(QP.save);

		waitFor(QP.toaster);

		// Assert a toaster "Please enter the Max Score less than or equal to 500" displayed
		Assert.assertEquals(getText(QP.toaster), "Please enter the Max Score less than or equal to 500");
		click(QP.toasterclosebtn);

		waitThread(2000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert a toaster "Please enter the Max Score less than or equal to 500" displayed
		Assert.assertEquals(getText(QP.toaster), "Please enter the Max Score less than or equal to 500");
		click(QP.toasterclosebtn);

		waitThread(1000);
		// Click Remove Question Button
		click(QP.remove_quest);

		waitThread(3000);
		// Assert the confirmation popup
		Assert.assertTrue(isElementPresent(ck.confirm_pop), "Confirmation popup not displayed");

		waitThread(2000);
		// Click Yes button
		click(ck.yes_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Removed successfully "
		Assert.assertEquals(getText(QP.toaster), "Removed successfully");
		click(QP.toasterclosebtn);

		waitThread(3000);
		
	}

	/*
	 * To perform Logout functionality
	 */
	@Test(priority = 19)
	public void TCSPR090519() {

		
		waitThread(2000);
		cm.Logout();

		// Assert the heading "Login"
		Assert.assertEquals(getText(QP.hd_label11), "Login");

	}

}