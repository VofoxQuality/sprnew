package QuestionBankofIndividualTeacherTest;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;

import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.ClickableRubricPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SummaryQuestionClickableRubircPage;
import Login.Pages.LoginPage;
import QuestionBankofIndividualTeacherPage.QuestionBankPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;

public class QuestionBankTest extends basePage {

	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	CommonMethods cm = new CommonMethods();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	SummaryQuestionClickableRubircPage sqcr = new SummaryQuestionClickableRubircPage();
	ClickableRubricPage ck = new ClickableRubricPage();
	QuestionBankPage qb = new QuestionBankPage();

	public String AssessmentName;
	public String Emailteacher;
	public String Question1 = "Question1";
	public String Question2 = "Question2";
	public String Question3 = "Question3";
	public String Rubric1 = "Rubric1";
	public String Rubric2 = "Rubric2";
	public String Rubric3 = "Rubric3";
	public String Maxscore2 = "20";
	public String Maxscore3 = "30";

	/*
	 * To load the Student Peer Review Landing Page
	 */
	@Test(priority = 1)
	public void TCSPR1600101() throws SQLException {

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
	 * To check the buttons and heading labels of Library page
	 */
	@Test(priority = 2)
	public void TCSPR1600102() {

		// Click Library Tab
		waitThread(4000);
		click(qb.libr_tab_lbl);

		// Assert library heading
		waitThread(1000);
		Assert.assertEquals(getText(qb.libr_tab_lbl), "Libraries");

		// Assert label 'Question Bank'
		Assert.assertEquals(getText(qb.quest_bnk_lbl), "Question Bank");

	}

	/*
	 * To check the select category dropdown
	 */
	@Test(priority = 3)
	public void TCSPR1600103() {

		// Assert 'Category' label
		Assert.assertEquals(getText(qb.cat_lbl), "Category");

		// Click Select Category dropdown
		click(qb.cat_dropdwn_btn);

		// Assert Select Category drop down field visible
		waitThread(1000);
		Assert.assertTrue(isElementPresent(qb.cat_drop_bx), "Category dropdown box is not visible");

		// Click on Search field
		click(qb.cat_search);

		// Assert the search field checkbox present & disabled
		Assert.assertTrue(isElementPresent(qb.al_checkbx), "All checkbox not present");
		Assert.assertTrue(getAttribute(qb.al_checkbx, "class").contains("p-disabled"));

		// Assert Close button is present
		Assert.assertTrue(isElementPresent(qb.close_btn), "close button not present");

	}

	/*
	 * To check Create a new Category functionalities
	 */
	public String cat_name = "Category1" + generateRandomData();

	@Test(priority = 4)
	public void TCSPR1600104() {

		// Assert 'Create a new Category' label
		Assert.assertEquals(getText(qb.creat_new_cat_lbl), "Create a new Category");

		// Click on the Create a new Category Button
		click(qb.creat_new_cat_lbl);

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

	}

	/*
	 * To check Create a new Category listed in Question bank page
	 */
	@Test(priority = 5)
	public void TCSPR1600105() {

		// Assert Created Category is present in Select Category Name grid
		Assert.assertEquals(getText(qb.added_cat), cat_name);

		// Click on Select Category
		click(qb.cat_dropdwn_btn);

		waitThread(1000);
		// Assert Category Name is display in the dropdown
		Assert.assertEquals(getText(qb.added_cat_drpdwn), cat_name);

	}

	/*
	 * To check the already category toaster
	 */
	@Test(priority = 6)
	public void TCSPR1600106() {

		// Click on the Create a new Category Button
		click(qb.creat_new_cat_lbl);

		// Assert 'Create Category' heading label
		waitThread(1000);
		Assert.assertEquals(getText(qb.catpopup_lbl), "Create Category");

		// Click on Name field
		click(qb.cat_textarea);

		// Type already added Name
		type(qb.cat_textarea, cat_name);

		// Assert 'Category Name already exist ' validation message
		Assert.assertEquals(getText(qb.cat_val_msg), "Category Name already exist.");

		// Click on Create button
		click(qb.create_btn);

		// Assert "Please enter new Category Name" toaster
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Please enter new Category Name");
		click(QP.toasterclosebtn);

		// Click on Close tab
		click(qb.close_btn_popup);

		// Assert the popup not visible
		waitThread(1000);
		Assert.assertFalse(isElementPresent(qb.cat_popup), "Popup visible");
	}

	/*
	 * To check Question bank grid details
	 */
	@Test(priority = 7)
	public void TCSPR1600107() {

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

		// Assert there is sorting option in below columns
		// *Max Score
		// *Linked to Category
		// *Last Modified
		Assert.assertTrue(getAttribute(qb.max_score_lbl, "class").contains("sortable-column"));
		Assert.assertTrue(getAttribute(qb.link_tocat_lbl, "class").contains("sortable-column"));
		Assert.assertTrue(getAttribute(qb.last_modified_lbl, "class").contains("sortable-column"));

	}

	/*
	 * To check whether Total Question and search box is available
	 */
	@Test(priority = 8)
	public void TCSPR1600108() {

		// Assert Total question label
		Assert.assertTrue(getText(qb.tot_quest_lbl).contains("Total Questions:"));

		// Assert Total Question is 0
		Assert.assertEquals(getText(qb.tot_quest_lbl), "Total Questions: 0");

		// Assert Search Question Placeholder
		Assert.assertEquals(getAttribute(qb.search_quest, "placeholder"), "Search Question");

	}

	/*
	 * To check whether Add a new question button functionality and check the
	 * category dropdown
	 */
	@Test(priority = 9)
	public void TCSPR1600109() {

		// Assert Add a new question button is present
		Assert.assertTrue(isElementPresent(qb.add_new_quest_btn), "Add a new question button not present");

		// Assert Add a new question label
		Assert.assertEquals(getText(qb.add_new_quest_btn), "Add a new question");

		// Click Add a new question button
		click(qb.add_new_quest_btn);

		// Assert Add a new question popup is display
		waitThread(1000);
		Assert.assertTrue(isDisplayed(qb.add_newquest_hd), "Popup not visible");

		// Assert Add a new question label
		Assert.assertEquals(getText(qb.add_newquest_hd), "Add a new question");

		// Assert Category label
		Assert.assertEquals(getText(qb.cat_lbl_popup), "Category");

		// Assert Select Category drop down is present
		Assert.assertTrue(isElementPresent(qb.cat_drop_popup), "Category dropdown not present");

		// Click on Select Category
		click(qb.cat_drop_popup);

		// Assert Close button is present
		waitThread(2000);
		Assert.assertTrue(isElementPresent(qb.close_btn), "close button not present");
	}

	/*
	 * To check the Create a category button
	 */
	@Test(priority = 10)
	public void TCSPR1600110() {

		// Assert Create a new category button is present
		Assert.assertEquals(getText(qb.creat_new_cat_lbl), "Create a new Category");

		// Assert added Category is present on the dropdown
		Assert.assertEquals(getText(qb.added_cat_drpdwn), cat_name);

		// Assert all check box present
		Assert.assertTrue(isElementPresent(qb.al_checkbx), "All checkbox not present");
	}

	/*
	 * To check Create a new category functionalities
	 */
	public String cat_name2 = "Category2" + generateRandomData();

	@Test(priority = 11)
	public void TCSPR1600111() {

		// Click on the Create a new Category Button
		click(qb.creat_new_cat_lbl);

		// Assert Create Category popup is visible
		waitThread(2000);
		Assert.assertTrue(isDisplayed(qb.cat_popup), "Popup not visible");

		// Assert 'Create Category' label
		Assert.assertEquals(getText(qb.catpopup_lbl), "Create Category");

		// Assert 'Name' label
		Assert.assertEquals(getText(qb.name_lbl), "Name");

		// Enter Name
		waitThread(2000);
		click(qb.cat_textarea);
		type(qb.cat_textarea, cat_name2);

		// Assert 'Create' button
		Assert.assertEquals(getText(qb.create_btn), "Create");

		// Click on create button
		waitThread(2000);
		click(qb.create_btn);

		// Assert 'Added to the question bank' toaster
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Added to the question bank");
		click(QP.toasterclosebtn);

		// Assert Category 2+Random is present in Select Category Name grid
		Assert.assertEquals(getText(qb.add_cat_popup), cat_name2);
	}

	/*
	 * To check the Placeholders of Question page- Question box
	 */
	@Test(priority = 12)
	public void TCSPR1600112() {

		// Assert the label "1.Question"
		Assert.assertEquals(getText(qb.quest1_lbl), "1. Question");

		// Click on question box
		driver.switchTo().frame("questionEditorId_ifr");
		click(qb.quest_bx);
		driver.switchTo().defaultContent();

		// Click on Save button
		click(qb.save_btn);

		// Assert "Please enter the Question and 'Max Score' and either the
		// Rubric or
		// Sample Answer(or both)" toaster
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster),
				"Please enter the Question and 'Max Score' and either the Rubric or Sample Answer(or both)");
		click(QP.toasterclosebtn);

	}

	/*
	 * To check detailed question functionalities and tosaters
	 */
	@Test(priority = 13)
	public void TCSPR1600113() {

		// Enter Question
		driver.switchTo().frame("questionEditorId_ifr");
		click(qb.quest_bx);
		type(qb.quest_bx, Question1);
		driver.switchTo().defaultContent();

		// Click on save button
		waitThread(2000);
		click(qb.save_btn);

		// Assert Please enter the 'Max Score' and either the Rubric or Sample
		// Answer(or
		// both) toaster
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster),
				"Please enter the 'Max Score' and either the Rubric or Sample Answer(or both)");
		click(QP.toasterclosebtn);

	}

	/*
	 * To check Rubric functionalities
	 */
	@Test(priority = 14)
	public void TCSPR1600114() {

		// Assert Rubric label
		Assert.assertEquals(getText(qb.rubric_lbl), "Rubric");

		// Assert Standard Rubric button is enabled
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Assert "Rubric will displayed to the student during the peer-review
		// phase
		// only"label
		Assert.assertEquals(getText(qb.rubric_infotext),
				"Rubrics will be displayed to the students during the peer-review phase only");

	}

	/*
	 * To check Standard Rubric functionalities
	 */
	@Test(priority = 15)
	public void TCSPR1600115() {

		// Assert Clickable Rubric radio button is present
		Assert.assertTrue(isElementPresent(QP.click_radio), "Clickable Radio button not present");

		// Assert Clickable rubric label
		Assert.assertEquals(getText(qb.click_rubric_lbl), "Clickable Rubric");

		// Assert Standard Rubric radio button is present
		Assert.assertTrue(isElementPresent(QP.std_rad), "Standard Radio button not present");

		// Assert Standard Rubric label
		Assert.assertEquals(getText(qb.std_rubric_lbl), "Standard Rubric");

		// Assert the standard rubric radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Click on Rubric box
		driver.switchTo().frame("rubricEditorId_ifr");
		click(qb.rubric_bx);

		// Enter Standard Rubric
		type(qb.rubric_bx, Rubric1);
		driver.switchTo().defaultContent();

		// Click on Save button
		Scroll_DowntoEnd();
		waitThread(2000);
		click(qb.save_btn);

		// Assert "Please enter the 'Max Score" toaster
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Please enter the 'Max Score'");
		click(QP.toasterclosebtn);
	}

	/*
	 * To check Clickable Rubric continue editing functionalities
	 */
	@Test(priority = 16)
	public void TCSPR1600116() {
		ScrollTo_xy_position(0, 150);
		// Click on Clickable Rubric
		ScrollTo_Location(qb.max_scr);
		ScrollTo_xy_position(0, 150);
		waitThread(2000);
		click(QP.click_radio);

		// Assert the Confirmation popup is visible
		waitThread(3000);
		Assert.assertTrue(isDisplayed(sqcr.remove_col_confir), "Confirmation popup not displayed");

		// Assert text "Changes you made may not be saved.?"
		Assert.assertEquals(getText(sqcr.conf_text), "Changes you made may not be saved.");

		// Assert Discard button
		Assert.assertEquals(getText(sqcr.disc_btn), "Discard");

		// Assert Continue Editing button
		Assert.assertEquals(getText(sqcr.cont_edit_btn), "Continue Editing");

		// Click on Continue Editing
		click(sqcr.cont_edit_btn);

		// Assert Standard rubric radio button is selected
		waitThread(1000);
		Assert.assertTrue(isEnabled(QP.std_rad), " Standard radio button is not selected");

		// Assert rubric answer is present
		driver.switchTo().frame("rubricEditorId_ifr");
		Assert.assertEquals(getText(qb.rubric_bx), Rubric1);
		driver.switchTo().defaultContent();

	}

	/*
	 * To check Clickable Rubric discard functionalities
	 */
	@Test(priority = 17)
	public void TCSPR1600117() {

		// Click on Clickable Rubric
		click(QP.click_radio);
		waitThread(3000);
		// Assert the Confirmation popup is visible
		Assert.assertTrue(isDisplayed(sqcr.remove_col_confir), "Confirmation popup not displayed");

		// Assert text "Changes you made may not be saved.?"
		Assert.assertEquals(getText(sqcr.conf_text), "Changes you made may not be saved.");

		// Click Discard button
		click(sqcr.disc_btn);

		// Assert Clickable Rubric is selected
		waitThread(1000);
		Assert.assertTrue(isEnabled(QP.click_radio), " Standard radio button is not selected");
	}

	/*
	 * To check Clickable Rubric discard functionalities
	 */
	@Test(priority = 18)
	public void TCSPR1600118() {

		// Assert the placeholder "No Rubric Created!"
		waitThread(1000);
		Assert.assertEquals(getText(QP.click_rubric_holder), "No Rubric Created !");

		// Assert Add Column button is enable
		Assert.assertTrue(isEnabled(QP.add_column), "Add column button is disabled");

		// Assert Add Columm label
		Assert.assertEquals(getText(QP.add_column), "Add Column");

		// Assert Remove Last Column button is disable
		Assert.assertFalse(isEnabled(QP.remov_lastcolum), "Remove Last column button is enabled");

		// Assert Add Row button is disable
		Assert.assertFalse(isEnabled(QP.add_row), "Add Row button is enabled");

		// Assert Remove Last Row button is disable
		Assert.assertFalse(isEnabled(QP.remov_lastrw), "Remove Last Row button is enabled");
	}

	/*
	 * To check the functionalities of Add Column in Clickable Rubric
	 */
	@Test(priority = 19)
	public void TCSPR1600119() {

		// Click on Add Column
		click(QP.add_column);

		// Assert the labels
		// -Criteria1
		// -Score for column 1
		Assert.assertEquals(getText(ck.criteria1_lbl), "Criteria 1");
		Assert.assertEquals(getText(ck.score_fr_column1_lbl), "Score for Column 1");

		// Assert the Criteria1 placeholder
		Assert.assertEquals(getAttribute(ck.criteria1_place, "placeholder"), "Enter Criteria 1");

		// Assert the Enter Score placeholder
		Assert.assertEquals(getAttribute(ck.enter_scr, "placeholder"), "Enter Score");

		// Assert Enter Condition placeholder
		driver.switchTo().frame("editorFieldRubric_00_ifr");
		waitThread(2000);
		Assert.assertEquals(getAttribute(ck.clic_rub_place, "aria-placeholder"), "Enter Condition");
		driver.switchTo().defaultContent();

	}

	/*
	 * To check the functionalities of Delete Column in Clickable Rubric
	 */
	@Test(priority = 20)
	public void TCSPR1600120() {

		// Assert Remove Last Column button is enable
		Assert.assertTrue(isEnabled(QP.remov_lastcolum), "Remove Last Row button is disabled");

		// Click on Remove Last Column
		waitThread(3000);
		click(QP.remov_lastcolum);

		// Assert the Confirmation popup visible
		waitThread(3000);
		Assert.assertTrue(isDisplayed(sqcr.remove_col_confir), "Confirmation popup not displayed");
		waitThread(1000);

		// Assert Confirmation Label
		Assert.assertEquals(getText(sqcr.conf_hd), "Confirmation");

		// Assert text "Are you sure that you want to remove the last
		// column(s)?"
		Assert.assertEquals(getText(sqcr.conf_text), "Are you sure that you want to remove the last column(s)?");

		// Click No button
		click(sqcr.cont_edit_btn);

		// Assert Crietria 1 and Score for Column 1 is present
		Assert.assertTrue(isElementPresent(ck.crit1_bx), "criteria1box is not present");
		Assert.assertTrue(isElementPresent(ck.scre_col1), "scorebox is not present");

	}

	/*
	 * To check the functionalities of Remove last column
	 */
	@Test(priority = 21)
	public void TCSPR1600121() {

		// Click on Remove Last Column
		waitThread(2000);
		click(QP.remov_lastcolum);

		// Assert the Confirmation popup visible
		waitThread(2000);
		Assert.assertTrue(isDisplayed(sqcr.remove_col_confir), "Confirmation popup not displayed");
		waitThread(1000);

		// Click Yes button
		click(sqcr.disc_btn);

		// Assert Removed successfully toaster
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Removed successfully");
		click(QP.toasterclosebtn);

		// Assert Crietrial 1 and Score for Column 1 is present
		waitThread(2000);
		Assert.assertFalse(isElementPresent(ck.crit1_bx), "criteria1box is present");
		Assert.assertFalse(isElementPresent(ck.scre_col1), "scorebox is present");
	}

	/*
	 * To check the functionalities of Add Row
	 */
	@Test(priority = 22)
	public void TCSPR1600122() {

		// Click on Add Column
		click(QP.add_column);

		// Click Add Row button
		click(QP.add_row);

		// Assert Criteria2 label
		Assert.assertEquals(getText(ck.criteria2_lbl), "Criteria 2");

		// Assert Score box row2 visible
		Assert.assertTrue(isElementPresent(ck.scrore_r21), "scorebox is not present");

	}

	/*
	 * To check the Remove Last Row buttons functionality
	 */
	@Test(priority = 23)
	public void TCSPR1600123() {

		// Assert Remove Last Row button enable
		Assert.assertTrue(isEnabled(QP.remov_lastrw), "Remove Last Row button is disabled");

		// Click on Remove Row
		waitThread(1000);
		click(QP.remov_lastrw);

		// Assert the Confirmation popup visible
		waitThread(1000);
		Assert.assertTrue(isDisplayed(sqcr.remove_col_confir), "Confirmation popup not displayed");
		waitThread(1000);

		// Assert Confirmation Label
		Assert.assertEquals(getText(sqcr.conf_hd), "Confirmation");

		// Assert text "Are you sure that you want to remove the row?"
		Assert.assertEquals(getText(sqcr.conf_text), "Are you sure that you want to remove the row?");

		// Click No button
		click(sqcr.cont_edit_btn);

		// Assert Criteria 2 and Score for Column 1 is present
		Assert.assertTrue(isElementPresent(ck.crit2_bx), "criteria1box is not present");
		Assert.assertTrue(isElementPresent(ck.scrore_r21), "scorebox is not present");

		// click on Remove last row button
		waitThread(1000);
		click(QP.remov_lastrw);

		// Click Yes button
		click(sqcr.disc_btn);

		// Assert Removed successfully toaster
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Removed successfully");
		click(QP.toasterclosebtn);

	}

	/*
	 * To check the max column limit
	 */
	// @Test(priority = 24)
	public void TCSPR1600124() {
		ScrollTo_Location(QP.click_radio);
		waitThread(3000);
		// Assert the clickable rubric radio button is enabled
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		for (int i = 2; i <= 5; i++) {
			waitThread(3000);

			// Click Add column button
			click(QP.add_column);

			// driver.switchTo().frame(i);
			// waitThread(2000);
			// Assert.assertEquals(getAttribute(ck.clic_rub_place,
			// "aria-placeholder"), "Enter Condition");
			// driver.switchTo().defaultContent();
		}

		waitThread(5000);
		// Click Add Column button
		click(QP.add_column);

		waitFor(QP.toaster);
		// Assert the toaster "Max column limit reached"
		Assert.assertEquals(getText(QP.toaster), "Max column limit reached");
		click(QP.toasterclosebtn);

	}

	/*
	 * To check the max row limit
	 */
	// @Test(priority = 25)
	public void TCSPR1600125() {

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
	 * To check Clickable rubric toaster functionalities
	 */
	@Test(priority = 26)
	public void TCSPR1600126() {

		// Click on Cancel button
		click(qb.cancel_btn);

		// Click on Add a new question button
		click(qb.add_new_quest_btn);

		// Click on clickable rubric radio buton
		waitThread(1000);
		click(QP.click_radio);

		// Click Add column button
		click(QP.add_column);

		// Click Save button
		waitThread(2000);
		click(qb.save_btn);

		// Assert the toasters "Please enter the Question, 'Max Score', either
		// the
		// Rubric or Sample Answer(or both) and Question Bank Category"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster),
				"Please enter the Question, 'Max Score', either the Rubric or Sample Answer(or both) and Question Bank Category");
		click(QP.toasterclosebtn);

		// Click Score for Column 1
		click(ck.scre_col1);

		// Enter Score 0
		type(ck.scre_col1, "0");

		// Click Save button
		waitThread(2000);
		click(qb.save_btn);

		// Assert toaster 'Please enter the Question, score greater than zero as
		// 'Max
		// Score' and either the Rubric or Sample Answer(or both) and Question
		// Bank
		// Category'
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster),
				"Please enter the Question, score greater than zero as 'Max Score' and either the Rubric or Sample Answer(or both) and Question Bank Category");
		click(QP.toasterclosebtn);

	}

	/*
	 * To check Clickable rubric toaster functionalities
	 */
	// @Test(priority = 27)
	public void TCSPR1600127() {
		ScrollTo_Location(QP.click_radio);
		// Click on Criteria 1
		click(ck.crit1_bx);

		// Enter criteria 1
		type(ck.crit1_bx, "C1");

		// Click Save button
		waitThread(2000);
		click(qb.save_btn);

		// Assert toaster Please enter the Question and Question Bank Category
		// and
		// number greater than zero on score for 'column 1' in Criteria 1
		// Assert toaster Please enter the Condition for 'Column 1' in Criteria
		// 1

		Assert.assertTrue(getText(QP.toaster).contains(
				"Please enter the Question and Question Bank Category and number greater than zero on score for 'column 1' in Criteria 1"));

		waitFor(ck.toaster_2);
		Assert.assertTrue(getText(ck.toaster_2).contains("Please enter the Condition for 'Column 1' in Criteria 1"));

		// Click Score for Column 1
		waitThread(3000);
		click(ck.scre_col1);

		// Enter Score
		waitThread(3000);
		type(ck.scre_col1, "10");

		// Assert Toaster
		// - Please enter the Question and Question Bank Category
		// -Please enter the Condition for 'Column 1' in Criteria 1
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Please enter the Question and Question Bank Category");
		click(QP.toasterclosebtn);

		waitFor(ck.toaster_2);
		Assert.assertTrue(getText(ck.toaster_2).contains("Please enter the Condition for 'Column 1' in Criteria 1"));

		// Enter Condition
		driver.switchTo().frame(1);
		waitThread(2000);
		type(ck.enter_con, "Test 1");
		driver.switchTo().defaultContent();

		// Click on Save button
		waitThread(2000);
		click(qb.save_btn);

		// *Assert toaster "Please enter the Question and Question Bank
		// Category"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Please enter the Question and Question Bank Category");
		click(QP.toasterclosebtn);

	}

	/*
	 * To check Clickable rubric toaster functionalities
	 */
	// @Test(priority = 28)
	public void TCSPR1600128() {

		waitThread(2000);
		// Click Add Row button
		click(QP.add_row);

		// Click on Save button
		waitThread(2000);
		click(qb.save_btn);

		// Assert Toaster
		// -Please enter the Question and Question Bank Category
		// -Please enter the Condition for 'Column 1' in Criteria 2
		// -Please enter the Criteria 2

		// Enter criteria 2
		click(ck.crit1_bx);
		type(ck.crit1_bx, "Cr2");

		// Enter Score
		type(ck.scrore_r21, "10");

		// Enter Condition
		driver.switchTo().frame("editorFieldRubric_10_ifr");
		waitThread(2000);
		type(ck.enter_con, "Test 2");
		driver.switchTo().defaultContent();

		// Click on Save button
		waitThread(2000);
		click(qb.save_btn);

		// Assert Please enter the Question and Question Bank Category
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Please enter the Question and Question Bank Category");
		click(QP.toasterclosebtn);
	}

	/*
	 * To check the Rows and Column score validation
	 */
	// @Test(priority = 29)
	public void TCSPR1600129() {

		// Click Score for Column 1
		waitThread(3000);
		click(ck.scre_col1);

		// Enter Score
		type(ck.scre_col1, "25");

		waitThread(5000);
		// Assert message Score range should be 0-20 message is visible
		Assert.assertEquals(getText(qb.val_msg1), "*Score range should be 0-20");

		// Click on Save button
		waitThread(2000);
		click(qb.save_btn);

		// Assert Please enter the Question and Question Bank Category
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Please enter the Question and Question Bank Category");
		click(QP.toasterclosebtn);

	}

	/*
	 * To fill details of question field and standard rubric for display
	 * questions on the question bank grid
	 */
	@Test(priority = 30)
	public void TCSPR1600130() {

		// Click on Cancel button
		click(qb.cancel_btn);

		// Click on Add a new question button
		click(qb.add_new_quest_btn);

		// Click Select Category dropdown
		waitThread(2000);
		click("//*[@id='categorySelectDropDown']");

		// Select Category -Category 2+Random
		waitThread(2000);
		click(qb.added_cat_drpdwn);

		// Click on 1.Questionbx
		waitThread(3000);
		driver.switchTo().frame("questionEditorId_ifr");
		click(qb.quest_bx);

		// Enter Question
		type(qb.quest_bx, Question1);
		driver.switchTo().defaultContent();

		// Click on Standard Rubric box
		driver.switchTo().frame("rubricEditorId_ifr");
		click(qb.rubric_bx);

		// Enter Standard Rubric
		type(qb.rubric_bx, Rubric1);
		driver.switchTo().defaultContent();

	}

	/*
	 * To fill the clickable rubric details for display questions on the
	 * question bank grid
	 */
	public String S1 = "5";

	@Test(priority = 31)
	public void TCSPR1600131() {

		// Click on Clickable Rubric
		waitThread(2000);
		click(QP.click_radio);

		// Assert the Confirmation popup is visible
		Assert.assertTrue(isDisplayed(sqcr.remove_col_confir), "Confirmation popup not displayed");

		// Click Discard button
		click(sqcr.disc_btn);

		// Click on Add Column
		click(QP.add_column);
		waitThread(2000);

		// Enter Condition
		driver.switchTo().frame(1);
		waitThread(2000);
		type(ck.enter_con, "Test 1");
		driver.switchTo().defaultContent();

		// Enter criteria 1
		type(ck.crit1_bx, "C1");

		// Enter Score 5
		click(ck.scre_col1);
		type(ck.scre_col1, S1);

	}

	/*
	 * To fill the clickable rubric conditions and criteria for display
	 * questions on the question bank grid
	 */
	public String S2 = "6";

	// @Test(priority = 32)
	public void TCSPR1600132() {

		// Click Add column button
		click(QP.add_column);
		waitThread(1000);

		// Enter score for column
		type(ck.scre_col2, S2);

		// Enter Condition
		driver.switchTo().frame("editorFieldRubric_01_ifr");
		waitThread(2000);
		type(ck.enter_con, "Test 2");
		driver.switchTo().defaultContent();

		// Click on Add Row button
		click(QP.add_row);
		waitThread(1000);

		// Assert Score for Column 1score and Score for Column 2 score is
		// present
		Assert.assertEquals(getValue(ck.scrore_r21), S1);
		Assert.assertEquals(getValue(ck.score_r22), S2);

		// Click on Criteria 2 field
		click(ck.crit2_bx);

		// Enter criteria 2
		type(ck.crit2_bx, "CR2");
	}

	/*
	 * To fill details of criteia 2 for display questions on the question bank
	 * grid
	 */
	@Test(priority = 33)
	public void TCSPR1600133() {

		// // Enter Condition row2 colum1
		// driver.switchTo().frame("editorFieldRubric_10_ifr");
		// waitThread(2000);
		// type(ck.enter_con, "Test 3");
		// driver.switchTo().defaultContent();
		//
		// // Enter Condition row2 colum2
		// driver.switchTo().frame("editorFieldRubric_11_ifr");
		// waitThread(2000);
		// type(ck.enter_con, "Test 4");
		// driver.switchTo().defaultContent();

		// Click Save button
		waitThread(2000);
		click(qb.save_btn);

		// Assert Saved Successfully toaster
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Saved Successfully");
		click(QP.toasterclosebtn);

		// Assert Add a question page is redirect to question page
		waitThread(2000);
		Assert.assertEquals(getText(qb.quest_bnk_lbl), "Question Bank");

	}

	/*
	 * To check Max. Score functionalities on Add a new question popup
	 */
	@Test(priority = 34)
	public void TCSPR1600134() {

		// Click on Add a new question button
		click(qb.add_new_quest_btn);

		waitThread(2000);

		// Click on ,Max. Score field
		click(qb.max_scr);

		// Enter Score
		type(qb.max_scr, Maxscore2);

		// Click Save button
		waitThread(2000);
		click(qb.save_btn);

		// Assert "Please enter the Question and either the Rubric or Sample
		// Answer(or
		// both) and Question Bank Category toaster"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster),
				"Please enter the Question and either the Rubric or Sample Answer(or both) and Question Bank Category");
		click(QP.toasterclosebtn);

	}

	/*
	 * To check Max. Score and select category , Question functionalities on Add
	 * a new question popup
	 */
	@Test(priority = 35)
	public void TCSPR1600135() {
		// Click on Cancel button
		// click(qb.cancel_btn);
		// Click on Add a new question button
		click(qb.add_new_quest_btn);

		// Click Select Category dropdown
		waitThread(3000);
		click(qb.cat_dropdwn_btn);

		// Select Category -Category 1+Random
		waitThread(2000);
		click("//*[@id='categorySelectDropDown']");
		// Select Category -Category 2+Random
		waitThread(2000);
		click(qb.added_cat_drpdwn);
		// Click Save button
		waitThread(2000);
		click(qb.save_btn);

		// Assert "Please enter the Question and either the Rubric or Sample
		// Answer(or
		// both)"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster),
				"Please enter the Question and either the Rubric or Sample Answer(or both)");
		click(QP.toasterclosebtn);

		// Click on 2.Questionbx
		driver.switchTo().frame("questionEditorId_ifr");
		waitThread(3000);
		click(qb.quest_bx);

		// Enter Question
		type(qb.quest_bx, Question2);
		driver.switchTo().defaultContent();

	}

	/*
	 * To add details of question with standard rubric on the question bank grid
	 */
	@Test(priority = 36)
	public void TCSPR1600136() {

		// Click on Standard Rubric box
		driver.switchTo().frame("rubricEditorId_ifr");
		click(qb.rubric_bx);

		// Enter Standard Rubric
		type(qb.rubric_bx, Rubric2);
		driver.switchTo().defaultContent();

		// Click Save button
		waitThread(2000);
		click(qb.save_btn);

		// Assert Saved Successfully toaster
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Saved Successfully");
		click(QP.toasterclosebtn);

		// Assert Add a question page is redirect to question page
		waitThread(2000);
		Assert.assertEquals(getText(qb.quest_bnk_lbl), "Question Bank");

	}

	/*
	 * To fill details of questions,standard rubric for display questions on the
	 * question bank grid
	 */
	@Test(priority = 37)
	public void TCSPR1600137() {

		// Click on Add a new question button
		click(qb.add_new_quest_btn);

		waitThread(2000);

		// Click Select Category dropdown
		waitThread(1000);
		// click(qb.cat_dropdwn_btn);
		// Select Category -Category 1+Random
		waitThread(2000);
		click("//*[@id='categorySelectDropDown']");
		// Select Category -Category 1+Random
		waitThread(1000);
		click(qb.added_cat_rw2);

		// Click on 3.Questionbx
		driver.switchTo().frame("questionEditorId_ifr");
		click(qb.quest_bx);

		// Enter Question
		type(qb.quest_bx, Question3);
		driver.switchTo().defaultContent();

		// Click on Standard Rubric box
		driver.switchTo().frame("rubricEditorId_ifr");
		click(qb.rubric_bx);

		// Enter Standard Rubric
		type(qb.rubric_bx, Rubric3);
		driver.switchTo().defaultContent();

		// Assert Sample Answer label
		Assert.assertEquals(getText(QP.Sample_ans_label), "Sample Answer");

	}

	/*
	 * To fill sample answer details for display questions on the question bank
	 * grid
	 */
	@Test(priority = 38)
	public void TCSPR1600138() {

		// Click on Sample Answer
		driver.switchTo().frame("sampleAnswerEditorId_ifr");
		click(qb.sample_ans_bx);

		// Enter Sample answer
		type(qb.sample_ans_bx, "sample answer");
		driver.switchTo().defaultContent();

		// Click on Max score field
		click(qb.max_scr);

		// Enter Score
		type(qb.max_scr, Maxscore3);

		// Click Save button
		waitThread(2000);
		click(qb.save_btn);

		// Assert Saved Successfully toaster
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Saved Successfully");
		click(QP.toasterclosebtn);

		// Assert Add a question page is redirect to question page
		waitThread(2000);
		Assert.assertEquals(getText(qb.quest_bnk_lbl), "Question Bank");

	}

	/*
	 * To fill check Clear All button functionality on add a new question page
	 */
	@Test(priority = 39)
	public void TCSPR1600139() {

		// Click on Add a new question button
		click(qb.add_new_quest_btn);

		// Assert Clear All button is disable
		Assert.assertFalse(isEnabled(QP.remov_lastcolum), "Clear All button is enabled");

		// Click Select Category dropdown
		waitThread(1000);
		click("//*[@id='categorySelectDropDown']");

		// Select Category -Category 2+Random
		waitThread(1000);
		click(qb.added_cat_drpdwn);

		// Click on 4.Questionbx
		driver.switchTo().frame("questionEditorId_ifr");
		click(qb.quest_bx);

		// Enter Question
		waitThread(1000);
		type(qb.quest_bx, "Question 4");
		driver.switchTo().defaultContent();

		// Click on Standard Rubric box
		driver.switchTo().frame("rubricEditorId_ifr");
		click(qb.rubric_bx);

		// Enter Standard Rubric
		type(qb.rubric_bx, "Rubric4");
		driver.switchTo().defaultContent();

		// Click on Max score field
		click(qb.max_scr);

		// Enter Score
		type(qb.max_scr, "10");

		waitThread(2000);
		// Assert Clear All button is enable
		Assert.assertTrue(isEnabled(qb.clr_al_btn), "Clear All button is disabled");

	}

	/*
	 * To check Clear All functionalities on add a new question page
	 */
	@Test(priority = 40)
	public void TCSPR1600140() {

		// Click Clear All
		click(qb.clr_al_btn);

		// Assert the Confirmation popup visible
		waitThread(2000);
		Assert.assertTrue(isDisplayed(sqcr.remove_col_confir), "Confirmation popup not displayed");
		waitThread(1000);

		// Assert Confirmation Label
		Assert.assertEquals(getText(sqcr.conf_hd), "Confirmation");

		// Assert text "Are you sure you want to clear all the fields?"
		waitThread(1000);
		Assert.assertEquals(getText(sqcr.conf_text), "Are you sure you want to clear all the fields?");

		// Assert Yes button
		Assert.assertEquals(getText(sqcr.disc_btn), "Yes");

		// Assert No button
		Assert.assertEquals(getText(sqcr.cont_edit_btn), "No");

		// click No
		waitThread(1000);
		click(sqcr.cont_edit_btn);

		// Assert fill details is present
		driver.switchTo().frame("questionEditorId_ifr");
		Assert.assertEquals(getText(qb.quest_bx), "Question 4");
		driver.switchTo().defaultContent();

		// Click Clear All
		click(qb.clr_al_btn);

		// Assert the Confirmation popup visible
		waitThread(2000);
		Assert.assertTrue(isDisplayed(sqcr.remove_col_confir), "Confirmation popup not displayed");
		waitThread(1000);

		// click Yes
		click(sqcr.disc_btn);

		// Assert Cleared successfully toaster
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Cleared successfully");
		click(QP.toasterclosebtn);

		// Assert details is not visible on add a new question page
		driver.switchTo().frame("questionEditorId_ifr");
		Assert.assertEquals(getText(qb.quest_bx), "");
		driver.switchTo().defaultContent();

		// Click on Cancel button
		click(qb.cancel_btn);

		// Assert Add a question page is redirect to question page
		waitThread(2000);
		Assert.assertEquals(getText(qb.quest_bnk_lbl), "Question Bank");
	}

	/*
	 * To check added library questions is present in the library page
	 */
	@Test(priority = 41)
	public void TCSPR1600141() {

		// Assert Question 3 is visible
		Assert.assertEquals(getText(qb.q3_grid), Question3);

		// Assert Question 2 is visible
		Assert.assertEquals(getText(qb.q2_grid), Question2);

		// Assert Question 1 is visible
		Assert.assertEquals(getText(qb.q1_grid), Question1);

		// Assert Question 3 View/Modify button is visible
		Assert.assertEquals(getAttribute(qb.modify_btn_rw1, "label"), "View/Modify");

		// Assert Question 2 View/Modify button is visible
		Assert.assertEquals(getAttribute(qb.modify_btn_rw2, "label"), "View/Modify");

		// Assert Question 1 View/Modify button is visible
		Assert.assertEquals(getAttribute(qb.modify_btn_rw3, "label"), "View/Modify");

		// Assert Total question count is 3 is visible
		Assert.assertEquals(getText(qb.tot_quest_lbl), "Total Questions: 3");

	}

	/*
	 * To check added library category is present in the library page
	 */
	@Test(priority = 42)
	public void TCSPR1600142() {

		// Assert Question 3 ,Question 2,Question 1 rubric tick is present
		Assert.assertTrue(getAttribute(qb.rubrictick_rw1, "class").contains("tick"));
		Assert.assertTrue(getAttribute(qb.rubrictick_rw2, "class").contains("tick"));
		Assert.assertTrue(getAttribute(qb.rubrictick_rw3, "class").contains("tick"));

		// Assert Question 3 Sample Answer is visible
		Assert.assertTrue(getAttribute(qb.sampletick_rw1, "class").contains("tick"));

		// Assert Question 3 ,Question 2,Question 1 Max Score is visible
		Assert.assertEquals(getText(qb.maxscore_rw1), Maxscore3);
		Assert.assertEquals(getText(qb.maxscore_rw2), Maxscore2);
		Assert.assertEquals(getText(qb.maxscore_rw3), "5");

		waitThread(3000);
		// Assert Question 3 ,Question 2,Question 1 Linked to Category is
		// visible
		Assert.assertEquals(getText(qb.link_cat_rw1), "1");
		Assert.assertEquals(getText(qb.link_cat_rw2), "1");
		Assert.assertEquals(getText(qb.link_cat_rw3), "1");

		// Assert Question 3 ,Question 2,Question 1 Delete button is visible
		Assert.assertEquals(getAttribute(qb.del_btn_rw1, "label"), "Delete");
		Assert.assertEquals(getAttribute(qb.del_btn_rw2, "label"), "Delete");
		Assert.assertEquals(getAttribute(qb.del_btn_rw3, "label"), "Delete");

	}

	/*
	 * To check Search data is visible
	 */
	@Test(priority = 43)
	public void TCSPR1600143() {

		// Click on Search question
		click(qb.search_quest);

		// Enter question
		type(qb.search_quest, Question3);

		waitThread(2000);
		// Assert Question2 is display in the grid label
		Assert.assertEquals(getText(qb.q3_grid), Question3);

		// Assert Rubric has standard rubric tick is present
		Assert.assertTrue(getAttribute(qb.rubrictick_rw1, "class").contains("tick"));

		// Assert Sample answer has no tick
		Assert.assertTrue(isElementPresent(qb.sampletick_rw1), "Sample answer has tick");

		// Assert Max Score is present
		Assert.assertEquals(getText(qb.maxscore_rw1), Maxscore3);

		// Assert Linked to Category tool tip is present
		Assert.assertEquals(getText(qb.link_cat_rw1), "1");

		// Assert View/Modify button present
		Assert.assertEquals(getAttribute(qb.modify_btn_rw1, "label"), "View/Modify");

		// Assert Delete button is present
		Assert.assertEquals(getAttribute(qb.del_btn_rw1, "label"), "Delete");

		// Assert Total question count is 1
		Assert.assertEquals(getText(qb.tot_quest_lbl), "Total Questions: 1");

		// Clear search
		click(qb.search_quest);
		type(qb.search_quest, "   ");
		// driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input")).sendKeys(Keys.BACK_SPACE);
		// driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input")).sendKeys(Keys.BACK_SPACE);
		// driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input")).sendKeys(Keys.BACK_SPACE);
		waitThread(2000);
		// driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input")).sendKeys(Keys.BACK_SPACE);
		// driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input")).sendKeys(Keys.BACK_SPACE);
		// driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input")).sendKeys(Keys.BACK_SPACE);
		// driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input")).sendKeys(Keys.BACK_SPACE);
		// driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input")).sendKeys(Keys.BACK_SPACE);
		// driver.findElement(By.xpath("//p-table[@id='question-bank-table']//div[1]//span/input")).sendKeys(Keys.BACK_SPACE);
		waitThread(2000);

		// Assert grid shows all 3 questions
		waitThread(3000);
		Assert.assertEquals(getText(qb.q3_grid), Question3);
		Assert.assertEquals(getText(qb.q2_grid), Question2);
		Assert.assertEquals(getText(qb.q1_grid), Question1);

	}

	/*
	 * To check whether when more than one category selected ,there question is
	 * displaying in the grid label
	 */
	@Test(priority = 44)
	public void TCSPR1600144() {

		// Click on Select Category
		waitThread(5000);
		click(qb.cat_dropdwn_btn);
		click(qb.cat_dropdwn_btn);
		click(qb.cat_dropdwn_btn);

		driver.navigate().refresh();
		waitThread(8000);
		click(qb.cat_dropdwn_btn);

		// Click Category 1 + random number check box
		waitThread(2000);
		click(qb.added_cat_rw2);

		// Click on Select Category close button
		click(qb.close_btn);

		// Assert Question 3+Random number is visible in
		// the grid
		waitThread(2000);
		Assert.assertEquals(getText(qb.q3_grid), Question3);

		// Assert Total Question:2 count is visible
		Assert.assertEquals(getText(qb.tot_quest_lbl), "Total Questions: 1");
	}

	/*
	 * To check when more than catergory selected ,there question is dispalay in
	 * the grid label
	 */
	@Test(priority = 45)
	public void TCSPR1600145() {

		// Click on Select Category
		waitThread(1000);
		click(qb.cat_dropdwn_btn);

		// Click Category 2 + random number check box
		waitThread(1000);
		click(qb.added_cat_drpdwn);

		// Click on Select Category close button
		click(qb.close_btn);

		// Assert Question 3+Random number and Question 2+Random number
		// ,Question 1+Random number are visible in the grid
		waitThread(2000);
		Assert.assertEquals(getText(qb.q3_grid), Question3);
		Assert.assertEquals(getText(qb.q2_grid), Question2);
		Assert.assertEquals(getText(qb.q1_grid), Question1);

		// Assert Total Question:3 count is visible
		Assert.assertEquals(getText(qb.tot_quest_lbl), "Total Questions: 3");

		// Click on Category 2+random number close button
		waitThread(1000);
		click(qb.cat2_close);
		waitThread(2000);
		// Assert Category Question 1+Random number questions is not visible on
		// the grid
		Assert.assertEquals(getText(qb.q3_grid), Question3);

		// Assert Total Question:2 count is visible
		waitThread(1000);
		Assert.assertEquals(getText(qb.tot_quest_lbl), "Total Questions: 1");

		// Click on Category one + random number close button
		waitThread(1000);
		click(qb.cat1_close);

		// Assert total question 3 is visible on the grid
		waitThread(1000);
		Assert.assertEquals(getText(qb.tot_quest_lbl), "Total Questions: 3");
	}

	/*
	 * To check View/Modify button functionalities
	 */
	@Test(priority = 46)
	public void TCSPR1600146() {

		// Click on Search question
		click(qb.search_quest);

		waitThread(2000);
		// Enter question- question1
		type(qb.search_quest, Question1);

		waitThread(3000);
		// Assert View/Modify button is present
		Assert.assertEquals(getAttribute(qb.modify_btn_rw1, "label"), "View/Modify");

		// Assert View/Modify button is enable
		Assert.assertTrue(isEnabled(qb.modify_btn_rw1), "View/Modify button is disabled");

	}

	/*
	 * To check the Selected category functionalities
	 */
	@Test(priority = 47)
	public void TCSPR1600147() {

		waitThread(3000);
		// Click on View/Modify button
		click(qb.modify_btn_rw1);

		// Assert View/Modify question popup is visible
		waitThread(1000);
		Assert.assertTrue(isDisplayed(qb.add_newquest_hd), "Popup not visible");
		Assert.assertEquals(getText(qb.add_newquest_hd), "View/Modify question");

		// Assert Selected Category Name box is present
		Assert.assertEquals(getText(qb.sel_cat_lbl), "Selected Category Name");

		waitThread(3000);
		// Assert Category 2+random number is present in the grid
		Assert.assertEquals(getText(qb.add_cat_popup), cat_name2);

		// Click on Select category dropdown box
		waitThread(2000);
		click(qb.cat_drop_popup);

		// Assert Category 2+random number check box is selected
		Assert.assertTrue(isElementPresent(qb.added_cat_drpdwn), "Category 2+random number  check box not selected");
		waitThread(3000);

	}

	/*
	 * To check Question field functionalities
	 */
	@Test(priority = 48)
	public void TCSPR1600148() {

		// Click on select category Close button
		click(qb.close_btn);

		waitThread(3000);
		// Assert Question 1+Random number question is present on the question
		// box
		driver.switchTo().frame("questionEditorId_ifr");
		Assert.assertEquals(getText(qb.quest_bx), Question1);
		driver.switchTo().defaultContent();

		// Assert Clickbale rubric details is present
		ScrollTo_xy_position(0, 250);
		Assert.assertEquals(getValue(ck.scre_col1), S1);
		driver.switchTo().frame(1);
		waitThread(2000);
		Assert.assertEquals(getText(ck.enter_con), "Test 1");
		driver.switchTo().defaultContent();

		// Assert Save is disable
		Assert.assertFalse(isEnabled(qb.save_btn), "Save button is enabled");

	}

	/*
	 * To check View/modify selected clickable rubric functionalities'
	 */
	@Test(priority = 49)
	public void TCSPR1600149() {

		// Assert Cancel button is enable
		Assert.assertTrue(isEnabled(qb.cancel_btn), "Cancel button is disabled");

		// Click on Question box
		driver.switchTo().frame("questionEditorId_ifr");
		click(qb.quest_bx);

		// Modify question
		type(qb.quest_bx, "Question1_modified");
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

		// Assert page is redirected to question page
		waitThread(2000);
		Assert.assertEquals(getText(qb.quest_bnk_lbl), "Question Bank");

	}

	/*
	 * To check Delete functiontionalities
	 */
	@Test(priority = 50)
	public void TCSPR1600150() {

		// Assert Question 1+Random number modified is present in the grid

		// Click on Search question
		click(qb.search_quest);

		// Enter question
		type(qb.search_quest, Question2);

		// Assert Delete button label is present
		Assert.assertEquals(getAttribute(qb.del_btn_rw1, "label"), "Delete");

	}

	/*
	 * To check Delete toaster and functionalities
	 */
	@Test(priority = 51)
	public void TCSPR1600151() {

		// Click on Delete button
		click(qb.del_btn_rw1);

		// Assert the Delete Question popup visible
		waitThread(2000);
		Assert.assertTrue(isDisplayed(qb.del_confpopup), "Delete Confirmation popup not displayed");
		waitThread(1000);

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
		Assert.assertEquals(getText(qb.q3_grid), "Question2");

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

		// Click on Search close button
		waitThread(2000);
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

		// Assert the Question 2 +Random number not present in the grid

		// Click on Search box
		click(qb.search_quest);

		// Enter deleted question
		type(qb.search_quest, Question2);

		waitThread(3000);
		// Assert No Questions(s) Found. message is visible
		Assert.assertEquals(getText(qb.no_quest_found_txt), "No Question(s) Found.");

	}

	/*
	 * To perform Delete Teacher Account functionality
	 */
	@Test(priority = 52)
	public void TCSPR1600152() {

		// Perform delete account
		sp.DeleteAccount();

	}

}
