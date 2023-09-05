package CreateNewAssessment.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import Course.Pages.CourseRosterPage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.BasicDetailsPageCourseandEditorPage;
import CreateNewAssessment.Pages.ClickableRubricPage;
import CreateNewAssessment.Pages.MultipleQuestionsAddPage;
import CreateNewAssessment.Pages.QuestionEditorAndMultipleCategoryAddPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SummaryQuestionsPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Test.SignUpTest;

public class QuestionEditorAndMultipleCategoryAddTest extends basePage {

	QuestionEditorAndMultipleCategoryAddPage QE = new QuestionEditorAndMultipleCategoryAddPage();
	ClickableRubricPage ck = new ClickableRubricPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	SignUpTest st = new SignUpTest();
	CourseRosterPage cr = new CourseRosterPage();
	LoginPage lg = new LoginPage();
	MultipleQuestionsAddPage mq = new MultipleQuestionsAddPage();
	BasicDetailsPageCourseandEditorPage be = new BasicDetailsPageCourseandEditorPage();
	SummaryQuestionsPage sq = new SummaryQuestionsPage();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();

	public String Teacher_firstname;
	public String Teacher_lastname;
	public String Teacher_fullname;
	public String Password;
	public String EmailTeacher;
	public String CourseTitle;
	public String Assessment_name;
	public String CourseID;

	/*
	 * To perform Teacher Sign UP
	 */
	@Test(priority = 0)
	public void TCSPR090601() throws SQLException {
		Teacher_firstname = "Test";
		Teacher_lastname = "Teacher";
		Teacher_fullname = Teacher_firstname + " " + Teacher_lastname;
		Password = "Abc@123";

		// Assert the heading label "Welcome to Student Peer Review"
		Assert.assertEquals(getText(QP.wel_label), "Welcome to Student Peer Review");

		// Click on I'm a Teacher button
		click(QP.teach_btn);

		EmailTeacher = st.TCSPR020005();

	}

	/*
	 * To fetch OTP
	 */
	@Test(priority = 1)
	public void Test() throws SQLException {

		// To catch OTP from sending Resource
		st.TCSPR020006();

		// Assert the heading label "Courses"
		Assert.assertEquals(getText(QP.courses_label), "Courses");

	}

	/*
	 * To create a course
	 */
	@Test(priority = 2)
	public void TCSPR090602() {
		// To create a course for creating an Assessment

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
	 * To Fill basic details of an assessment
	 */
	@Test(priority = 3)
	public void TCSPR090603() {

		// Assert the Assessments tab
		Assert.assertTrue(isElementPresent(QP.Assessmenttab), "Assessments tab not present");

		// Click Assessments tab
		click(QP.Assessmenttab);
		waitThread(3000);
		// verify assessment tab is selected
		Assert.assertTrue(getAttribute(be.tab_Assessment, "class").contains("active"));

		// Assert Create New Assessment button
		Assert.assertEquals(getText(QP.creatnew_assessbtn), "Create New Assessment");

		// Click Create New Assessment button
		click(QP.creatnew_assessbtn);

		// Assert the basic details label
		Assert.assertEquals(getText(QP.basic_detls_wizard), "Basic Details");

		waitThread(3000);
		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		Assert.assertEquals(getText(ba.ddcoursename1), CourseTitle.trim(), "course name not visible on the dropdown");

		click(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		Assessment_name = "Geometry";

		type(QP.Assess_name, Assessment_name);

		waitThread(4000);
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
	 * To Enter data'ss on questions 1 page
	 */
	@Test(priority = 4)
	public void TCSPR090604() {

		// To Enter datas on questions page

		// Enter Question
		driver.switchTo().frame("question_ifr");
		type(QP.Quest_box, "Question1");
		driver.findElement(By.xpath("//body[@data-id='question']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//body[@data-id='question']")).sendKeys(Keys.ENTER);
		driver.switchTo().defaultContent();

		// pageScroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		waitThread(6000);
		// Click rubric dropdown
		click(QP.rubric_drp_btn);
		waitThread(3000);

		// Assert the clickable rubric radio button is enabled
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Enter data in Standard rubric box
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);
		type(QP.std_rub_bx, "Rubric1");
		driver.switchTo().defaultContent();

		waitThread(1000);

		// Page scroll up
		ck.scrolup();

		waitThread(2000);
		// Enter Max score and verify
		type(QP.max_scorbx, "2");
		Assert.assertEquals(getValue(QP.max_scorbx), "2");
	}

	/*
	 * To check the Remove question functionality
	 */
	@Test(priority = 5)
	public void TCSPR090605() {
		// To check the Remove question functionality

		waitThread(5000);
		// Click Remove Question
		click(QP.remove_quest);

		// Assert the Remove Question button is disabled
		Assert.assertFalse(isEnabled(QP.remove_quest), "Remove Question is enabled");

		waitThread(2000);
		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);

		waitThread(1000);
		// Assert the Remove Question button is Enabled
		Assert.assertTrue(isEnabled(QP.remove_quest), "Remove Question is disabled");

		// Click Remove Question
		click(QP.remove_quest);
		waitThread(2000);

		// Assert the Confirmation popup visible
		Assert.assertTrue(isDisplayed(ck.confirm_pop), "Confirmation popup not displayed");
		Assert.assertEquals(getText(QP.text_confirm), "Are you sure that you want to remove this question?");
		waitThread(1000);

		// Click No button
		click(ck.No_btn);

		// Assert the data Question1 is visible on question box
		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.quest_data), "Question1");
		driver.switchTo().defaultContent();

	}

	/*
	 * To check whether the Add to question bank check box and select category
	 * dropdown are disabled
	 */
	@Test(priority = 6)
	public void TCSPR090606() {

		// Assert the Add to question bank checkbox is not checked
		Assert.assertFalse(isSelected(QP.quest_bankcheckbx), "Add to Questkon bank checkbox checked");

		// Assert Select Category dropdown is disabled
		Assert.assertEquals(getAttribute(QP.select_cat, "optiondisabled"), "inactive");

		// Tick Question bank checkbox
		click(QP.quest_bankcheckbx);

		// Assert the Category dropdown enabled
		Assert.assertTrue(isEnabled(QP.select_cat), "the Category dropdown is disabled");

		// Assert the place holder "Select new category "
		Assert.assertEquals(getAttribute(QP.select_categ, "Placeholder"), "Select Category");
	}

	/*
	 * To check the select category dropdown
	 */
	@Test(priority = 7)
	public void TCSPR090607() {

		waitThread(2000);
		// Click Select category dropdown
		click(QP.cat_drop);
		waitThread(2000);

		// Assert the All check box disabled
		Assert.assertTrue(getAttribute(QP.cat_all_check, "class").contains("disabled"));
		// Assert the search box present
		Assert.assertTrue(isElementPresent(QP.cat_searchbox), "Category Search box not present");

		// Assert the close button present in dropdown
		Assert.assertTrue(isElementPresent(QP.cat_clos_btn), "Category close button not present");

		waitThread(1000);
		// Click close button
		click(QP.cat_clos_btn);

		waitThread(4000);

		// Assert the dropdown closed
		Assert.assertFalse(isElementPresent(QE.Catdrop_box), "Category drop down box is visible");

	}

	/*
	 * To Create new category to question page
	 */
	@Test(priority = 8)
	public void TCSPR090608() {

		waitThread(2000);
		// Click Select category dropdown
		click(QP.cat_drop);
		waitThread(2000);

		// Assert the create new category + button
		Assert.assertTrue(isElementPresent(QP.creat_cat), "Create new category button not present");

		// Click Create new category
		click(QP.creat_cat);
		waitThread(2000);
		// Assert the Create Category box visible
		Assert.assertTrue(isDisplayed(QE.Cre_cat_box), "Category Box not visible");

		// Assert the create button in Create new Category box
		Assert.assertTrue(isElementPresent(QP.catpop_creatbtn), "Create button not present");

		// Assert the close button in Create new Category box
		Assert.assertTrue(isElementPresent(QE.creat_cat_close_btn), "Close button not present");

		// Assert the Name textbox
		Assert.assertTrue(isElementPresent(QE.cre_cat_textbox), "Category Textbox not present");

	}

	/*
	 * To check the create new category functions
	 */
	@Test(priority = 9)
	public void TCSPR090609() {

		// Click close button
		click(QE.creat_cat_close_btn);

		// Assert the Create category box not visible
		Assert.assertFalse(isElementPresent(QE.Cre_cat_box), "Create Category box present");

		// Assert the select category dropdown closed
		Assert.assertFalse(isElementPresent(QE.Catdrop_box), "Category drop down box is visible");

		// Assert the Add to Quesquest_bank_ticktion box check box checked
		Assert.assertTrue(isElementPresent(QP.quest_bank_tick), "Add to Question bank check box not checked ");
		Assert.assertTrue(getAttribute(QP.chkbx_questionbank, "class").contains("p-highlight"));
	}

	/*
	 * To check whether the created category is visible on page
	 */
	@Test(priority = 10)
	public void TCSPR0906010() {

		waitThread(2000);
		// Click Select category dropdown
		click(QP.cat_drop);
		waitThread(2000);

		// click on create category +button
		click(QP.creat_cat);

		// Assert the Create Category box visible
		Assert.assertTrue(isElementPresent(QE.Cre_cat_box), "Create Category box not visible");

		// Enter Name on Category box
		click(QE.cre_cat_textbox);
		type(QE.cre_cat_textbox, "Category_1");

		waitThread(5000);
		// Click Create button
		click(QP.catpop_creatbtn);

		waitFor(QP.toaster);

		// Assert the "Added to question bank " toaster
		Assert.assertEquals(getText(QP.toaster), "Added to the question bank");
		click(QP.toasterclosebtn);

		// Assert the added category visible on page
		Assert.assertTrue(isDisplayed(QP.added_cat), "Create Category box not visible");

	}

	/*
	 * To check the duplication of category name
	 */
	@Test(priority = 11)
	public void TCSPR0906011() {

		waitThread(2000);
		// Click Select category dropdown
		click(QP.cat_drop);
		waitThread(2000);

		// click on create category +button
		click(QP.creat_cat);

		// Enter already added category name(add)
		click(QE.cre_cat_textbox);
		type(QE.cre_cat_textbox, "Category_1");

		// Assert the validation message "Category Name already exist."
		Assert.assertEquals(getText(QE.cat_duplic_validation), "Category Name already exist.");
		// click on create category button
		click(QE.catagory_createbtn);
		// verify toaster-Please enter new Category Name
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Please enter new Category Name");
		click(QP.toasterclosebtn);

		// Clear data
		driver.findElement(By.xpath(QE.cre_cat_textbox)).clear();

		// Enter new category name
		type(QE.cre_cat_textbox, "Category_2");
		waitThread(2000);

		// Assert no validation message
		Assert.assertFalse(isElementPresent(QE.cat_duplic_validation), "Validation message visible");

		// Click close button
		click(QE.creat_cat_close_btn);

		// Assert the box not visible
		Assert.assertFalse(isElementPresent(QE.Cre_cat_box), "Create Category box present");

	}

	/*
	 * To check the Search option of Select category drop down
	 */
	@Test(priority = 12)
	public void TCSPR0906012() {
		// To check the Search option of Select category drop down

		waitThread(2000);
		// Click Select category dropdown
		click(QP.cat_drop);
		waitThread(2000);

		// Enter the Added category name on search box
		type(QP.cat_searchbox, "Category_1");

		waitThread(1000);
		// Assert the text "Category_1 " highlighted in the dropdown
		Assert.assertEquals(getText(QE.add_cat_search), "Category_1");

		// Clear Search box
		driver.findElement(By.cssSelector(QE.categorysearchbx)).clear();

		// Enter the another category name
		type(QP.cat_searchbox, "sum");

		// Assert "No results found"
		Assert.assertEquals(getText(QE.no_resultfound), "No results found");

		// Click close button of dropdown
		click(QP.cat_clos_btn);

		// Assert the box not visible
		Assert.assertFalse(isElementPresent(QE.Cre_cat_box), "Create Category box present");

	}

	/*
	 * To check whether the added category of question 1 is not visible on
	 * question 2
	 */
	@Test(priority = 13)
	public void TCSPR0906013() {

		waitThread(2000);

		// Click +button for next question
		click(mq.add_quest_btn);

		// Assert the toaster "Saved successfully "
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);

		waitThread(2000);
		// Assert the Category "Category_1" is not visible on question2
		Assert.assertFalse(isElementPresent((QP.added_cat)), "Create Category box  visible");

		// Asesert the category dropdown is disabled
		Assert.assertEquals(getAttribute(QP.select_cat, "optiondisabled"), "inactive");

		waitThread(1000);
		// click question 1 button
		click(mq.q1_btn);

		waitThread(1000);
		click(mq.q2_btn);

		waitThread(1000);
		click(mq.q1_btn);
		waitThread(2000);
		// verify question 1 is selected
		Assert.assertTrue(getAttribute(mq.q1_btn, "class").contains("p-highlight"));
		// Assert the check box "add to question bank " is checked
		Assert.assertTrue(getAttribute(QP.chkbx_questionbank, "class").contains("p-highlight"));

	}

	/*
	 * To check whether added category can remove
	 */
	@Test(priority = 14)
	public void TCSPR0906014() {

		// To check whether added category can remove

		waitThread(2000);
		// Asesert the category dropdown is disabled
		Assert.assertEquals(getAttribute(QP.select_cat, "optiondisabled"), "inactive");

		waitThread(6000);
		// click on close button of added category
		click(QE.clos_btn_added_cat);

		// Assert the check box "add to question bank " is not checked
		Assert.assertFalse(isSelected(QP.quest_bankcheckbx), "Add to Questkon bank checkbox checked");

		// Click Save button
		click(QP.save);

		// Assert the Peer Review label on Wizard
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	/*
	 * To check the question box editor buttons
	 */
	@Test(priority = 15)
	public void TCSPR0906015() {

		// click Questions in wizard
		click(QP.Quest_wizard);

		// Assert the label "1.Question"
		Assert.assertEquals(getText(QP.question1), "1." + "\nQuestion");

		// Assert buttons in Editor
		Assert.assertTrue(isElementPresent(QE.bold_btn), "Bold button is not present");
		Assert.assertTrue(isElementPresent(QE.italic_btn), "Italic button is not present");
		Assert.assertTrue(isElementPresent(QE.underlin_btn), "Underline button is not present");
		Assert.assertTrue(isElementPresent(QE.image_btn), "Image button is not present");
		Assert.assertTrue(isElementPresent(QE.video_btn), "Video button is not present");
		Assert.assertTrue(isElementPresent(QE.math_editor), "Math formula editor button is not present");
		Assert.assertTrue(isElementPresent(QE.chem_editor), "Chem formula editor button is not present");

	}

	/*
	 * To perform Question box Editor insert/edit image popup,button
	 * close,cancel button functionality
	 */
	@Test(priority = 16)
	public void TCSPR0906016() {

		// Click on the insert/edit image button
		click(QE.image_btn);

		// Assert the following labels and buttons::
		// -Insert/edit image
		Assert.assertEquals(getText(be.imageuploadheaderlbl), "Insert/Edit Image");

		// -Close button,save button,cancel button
		Assert.assertTrue(isElementPresent(QE.clos_btn), "Close button is not present");
		Assert.assertTrue(isElementPresent(QE.save_btn), "Save button is not present");
		Assert.assertTrue(isElementPresent(QE.cancel_btn), "Cancel button is not present");

		// Assert the insert/edit image popup visible
		Assert.assertTrue(isDisplayed(be.imageuploadheaderlbl), "Insert image popup not present");

		// Click on insert/edit image popup close button
		click(QE.clos_btn);

		// Assert the insert/edit image popup not visible
		Assert.assertFalse(isElementPresent(be.imageuploadheaderlbl), "Insert image popup present");

		// Click on the insert/edit image button
		click(QE.image_btn);

		// Assert the insert/edit image popup visible
		Assert.assertTrue(isDisplayed(be.imageuploadheaderlbl), "Insert image popup not present");

		// Click on cancel button
		click(QE.cancel_btn);

		// Assert the insert/edit image popup not visible
		Assert.assertFalse(isElementPresent(be.imageuploadheaderlbl), "Insert image popup present");

	}

	/*
	 * To perform the Assessment Info Editor insert/edit image image upload
	 * functionality
	 */

	public String ImageURL = "http://192.168.7.108/SPRAPIQA/Files/Assessment/619dbf63c0429e0d15787b61/73b15af5-4d23-4d99-9690-ae509df4fc07.png";

	@Test(priority = 17)
	public void TCSPR0906017() {

		// Click on the insert/edit image button
		click(QE.image_btn);

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
		driver.switchTo().defaultContent();

		waitThread(3000);

		click(QP.save);

		waitThread(2000);
		// Click Question 2 for next question
		click(mq.q2_btn);
		waitThread(1000);
		// verify question 1 is selected
		Assert.assertTrue(getAttribute(mq.q2_btn, "class").contains("p-highlight"));
	}

	/*
	 * To perform the Question Editor Insert/Edit Media upload functionality To
	 * upload a video file from the folder
	 */
	public String VideoURL = "http://192.168.7.108/SPRAPIQA/Files/Assessment/619dbeddc0429e0d15787b5f/86d56375-b977-4156-a2e5-10a5c9f1812d.mp4";

	@Test(priority = 18)
	public void TCSPR0906018() {

		waitThread(3000);
		// Click on the insert/edit video button
		click(QE.video_btn);

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
		driver.findElement(By.xpath(QP.Quest_box)).sendKeys(Keys.ENTER);
		driver.switchTo().defaultContent();

	}

	public String URL = "https://en.wikipedia.org/wiki/Organic_chemistry";

	/*
	 * To perform Question Editor Insert/Edit Link popup,button close,cancel
	 * button functionality
	 */
	@Test(priority = 19)
	public void TCSPR0906019() {

		waitThread(3000);
		// Click on the Insert/Edit Link button
		click(QE.link_btn);

		// Assert the Insert/Edit Link popup visible
		Assert.assertTrue(isElementPresent(be.popupimage), "Insert/Edit Link Popup not visible");
		waitThread(2000);

		// Click on popup close button
		click(QE.clos_btn);

		waitThread(2000);
		// Assert the insert/edit link popup not visible
		Assert.assertFalse(isElementPresent(be.imageuploadheaderlbl), "Insert link popup present");

		// Click on the Insert/Edit Link button
		click(QE.link_btn);

		// Assert the Insert/Edit Link popup visible
		Assert.assertTrue(isElementPresent(be.popupimage), "Insert/Edit Link Popup not visible");

		// Click on cancel button
		click(QE.cancel_btn);

		// Assert the insert/edit link popup not visible
		Assert.assertFalse(isElementPresent(be.imageuploadheaderlbl), "Insert link popup present");
	}

	/*
	 * To perform the Question Editor Insert/Edit Link upload functionality
	 */
	@Test(priority = 20)
	public void TCSPR0906020() {

		// Click on the Insert/Edit Link button
		click(QE.link_btn);

		// Assert the Insert/Edit Link popup visible
		Assert.assertTrue(isElementPresent(be.popupimage), "Insert/Edit Link Popup not visible");
		waitThread(2000);

		// Click and type in URL text box and save it
		click(be.urltextbx);
		type(be.urltextbx, URL);

		waitThread(2000);
		click(be.texttodisplaybx);

		waitThread(5000);
		click(be.imageuploadsavebtn);
		waitThread(2000);

		// Assert the added Link visible on the page
		driver.switchTo().frame("question_ifr");
		waitThread(2000);
		Assert.assertTrue(isElementPresent(QE.added_link), "Uploaded link not visible");
		Assert.assertEquals(getText(QE.added_link), URL);

		click(QP.Quest_box);
		driver.findElement(By.xpath(QP.Quest_box)).sendKeys(Keys.ENTER);
		driver.switchTo().defaultContent();
	}

	/*
	 * To perform Question Equation editor[Math type] popup,button close,cancel
	 * button functionality
	 */
	@Test(priority = 21)
	public void TCSPR0906021() {

		waitThread(4000);
		Assert.assertTrue(isElementPresent(QE.math_editor), "Math editor button is not present");

		// Click on the Mathtype button
		click(QE.math_editor);

		// Assert the following labels and buttons::
		// -Close button,insert button,cancel button

		Assert.assertTrue(isElementPresent(QE.math_close_btn), "Close button is not present");
		Assert.assertTrue(isElementPresent(QE.math_insert_btn), "insert button is not present");
		Assert.assertTrue(isElementPresent(QE.math_cancel_btn), "Cancel button is not present");

		waitThread(6000);

		// Click on Mathtype popup close button
		click(QE.math_close_btn);

		waitThread(5000);
		// Assert the Mathtype popup not visible
		Assert.assertFalse(isDisplayed(QE.math_popup), "Math popup  visible");

		waitThread(1000);
		// Click on the Mathtype button
		click(QE.math_editor);

		// Assert the Mathtype popup visible
		Assert.assertTrue(isElementPresent(QE.math_popup), "Math popup not visible");

		// Click on cancel button
		click(QE.math_cancel_btn);

		// Assert the Mathtype popup not visible

		Assert.assertFalse(isDisplayed(QE.math_popup), "Math popup  visible");
	}

	/*
	 * To perform the Question editor Mathtype upload functionality
	 */
	@Test(priority = 22)
	public void TCSPR0906022() {

		// To perform the Question editor Mathtype upload functionality

		waitThread(3000);
		// Click on the Mathtype button
		click(QE.math_editor);

		// Assert the Mathtype popup visible
		Assert.assertTrue(isElementPresent(QE.math_popup), "Math popup not visible");

		waitThread(1000);
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
		waitThread(6000);
		Assert.assertTrue(isElementPresent(QE.upload_eqn_questbox), "Uploaded equation not visible");
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
		type(QP.std_rub_bx, "R2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, "10");

		waitThread(7000);
		// Click Save button
		click(QP.save);
		// Assert the toaster "Question 2 Saved successfully "
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully");
		click(QP.toasterclosebtn);

	}

	/*
	 * To click back to basic details page from the question page.check that the
	 * details saved properly
	 */
	@Test(priority = 23)
	public void TCSPR0906023() {

		waitThread(5000);
		// Click on basic details wizard
		click(QP.basic_detls_wizard);

		// Assert the basic details wizard is selected
		Assert.assertEquals(getText(QP.basic_detls_wizard), "Basic Details");

		waitThread(1000);
		// Assert the course name visible on the dropdown
		Assert.assertEquals(getText(QE.course_txtbox), CourseTitle);

		waitThread(3000);
		// Assert the assessment name
		Assert.assertEquals(getValue(QP.Assess_name), Assessment_name);

	}

	/*
	 * To check the Question editor box.[To verify that the added details are
	 * visible when it is taken from question page]
	 */
	@Test(priority = 24)
	public void TCSPR0906024() {

		waitThread(2000);
		// Click Save& next button
		click(QP.savenext_btn);

		// Assert the following Question box editor data's::
		driver.switchTo().frame("question_ifr");

		waitThread(2000);
		// verify the added vedio,image,link visible
		Assert.assertTrue(isElementPresent(sq.quest_edit_video), "Uploaded video not visible");
		Assert.assertTrue(isElementPresent(QE.added_link), "Uploaded link not visible");
		Assert.assertTrue(isElementPresent(QE.upload_eqn_questbox), "Uploaded equation not visible");

		driver.switchTo().defaultContent();

		waitThread(4000);
		click(mq.q1_btn);
		driver.switchTo().frame("question_ifr");
		waitFor(be.instrimage);
		Assert.assertTrue(isElementPresent(be.instrimage), "Uploaded image not visible");

		driver.switchTo().defaultContent();
	}

	/*
	 * To check whether the added details are visible when the user open
	 * assessment from drafts
	 */
	@Test(priority = 25)
	public void TCSPR0906025() {

		waitThread(3000);
		// Click Save& Exit button
		click(QP.savexit_btn);

		// Assert the heading draft
		Assert.assertEquals(getText(QE.tabdraft), "Draft");

		waitThread(1000);
		click(QE.tabdraft);

		waitThread(1000);
		// Click continue editing
		click(QP.continue_edit);

		// Assert the Basic details label on wizard
		Assert.assertEquals(getText(QP.basic_detls_wizard), "Basic Details");

		waitThread(2000);
		// Click Save& next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the following Question box editor data's::
		driver.switchTo().frame("question_ifr");

		waitThread(2000);

		Assert.assertTrue(isElementPresent(be.infovideo1), "Uploaded video not visible");
		Assert.assertEquals(getAttribute(be.infovideo, "type"), "video/mp4");
		Assert.assertTrue(isElementPresent(QE.added_link), "Uploaded link not visible");
		Assert.assertTrue(isElementPresent(QE.upload_eqn_questbox), "Uploaded eqation not visible");

		driver.switchTo().defaultContent();

		waitThread(3000);
		click(mq.q1_btn);
		driver.switchTo().frame("question_ifr");
		waitFor(be.instrimage);
		Assert.assertTrue(isElementPresent(be.instrimage), "Uploaded image not visible");

		driver.switchTo().defaultContent();
	}

	/*
	 * To perform delete account functionality
	 */
	@Test(priority = 26)
	public void TCSPR0906026() {
		// To perform delete account functionality
		waitThread(2000);
		cr.DeleteAccount();

		// Assert the heading "Login"
		Assert.assertEquals(getText(QP.hd_label11), "Login");

	}

	/*
	 * To perform login with deleted account credentials
	 */
	@Test(priority = 27)
	public void TCSPR0906027() {

		lg.login(EmailTeacher, "Abc@123");

		waitFor(lg.validationmsg3);
		// verify toaster text
		Assert.assertEquals(getText(lg.validationmsg3), "Enter a valid email address and password");

	}

}
