package CreateNewAssessment.Test;

import java.sql.SQLException;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;

import AccountSettings.Pages.AccountSettingsandDeleteAccountPage;
import Course.Pages.CreateNewCoursePage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;

public class BasicDetailsAssessmentTest extends basePage {

	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	AccountSettingsandDeleteAccountPage as = new AccountSettingsandDeleteAccountPage();
	CommonMethods cm = new CommonMethods();

	public String Emailteacher;
	public String CourseTitle;
	public String NewCourseTitle;
	public String CourseID;
	public String AssessmentName;

	// **Some test cases commented due to functionality flow issues due to
	// subscription.For Trial subscription we can create only one course

	/*
	 * To perform Sign Up functionality
	 */
	@Test(priority = 0)
	public void TCSPR090101() throws SQLException {

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
	 * To check the buttons, labels & headings of Assessments page
	 */
	@Test(priority = 2)
	public void TCSPR090102() {
		SoftAssert softAssert11 = new SoftAssert();

		// click on course tab
		click(ba.CourseTab);

		// To verify the create new course button
		Assert.assertTrue(isElementPresent(cn.btn_createnew), "Create new course button not present");

		// Click on create new course button
		click(cn.btn_createnew);

		CourseTitle = "Course Name" + generateRandomNumber();

		// To get the Course ID
		CourseID = (getText(cn.course_Id));

		// type-Course title
		type(cn.txbx_Coursetitle, CourseTitle.trim());

		waitThread(1000);
		// click on create course button
		click(cn.btn_Createcourse);

		waitThread(1000);
		// verify toaster-Course created successfully
		softAssert11.assertEquals(getText(cn.toaster).trim(), "Course created successfully", "Assertion  failed");

		waitThread(3000);

		// verify the course title
		softAssert11.assertEquals(getText(cn.value_coursetitle).trim(), CourseTitle.trim(), "Assertion  failed");
		softAssert11.assertAll();

	}

	/*
	 * To check the functionality of basic details wizard
	 */
	@Test(priority = 3)
	public void TCSPR090103() {

		SoftAssert softAssert1 = new SoftAssert();

		// Assessment Tab
		Assert.assertTrue(isElementPresent(ba.Assessmenttab), "Assessment tab not visible");
		softAssert1.assertEquals(getText(ba.Assessmenttab), "Assessments", "Assertion  failed");

		// click on Assessment tab
		click(ba.Assessmenttab);

		// To verify the labels and buttons
		softAssert1.assertEquals(getText(ba.lbl_assessment), "Assessments", "Assertion  failed");
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "Create new assessment button not visible");
		softAssert1.assertEquals(getText(ba.btn_createnewassessment), "Create New Assessment", "Assertion  failed");

		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);
		softAssert1.assertEquals(getText(ba.headinglbl_createnewassessment), "Create New Assessment",
				"Assertion  failed");

		softAssert1.assertAll();

		SoftAssert softAssert2 = new SoftAssert();

		// To verify the wizard label
		softAssert2.assertEquals(getText(ba.Wizardlbl_basicdetails), "Basic Details", "Assertion  failed");

		// To verify the wizard label is selected
		Assert.assertEquals(getAttribute(ba.Basicdetailswizard, "aria-selected"), "true");

		softAssert2.assertAll();
	}

	/*
	 * To check the buttons & labels of basic details page
	 */
	@Test(priority = 4)
	public void TCSPR090104() {

		SoftAssert softAssert3 = new SoftAssert();

		// verify the buttons and button labels
		Assert.assertTrue(isElementPresent(ba.btndiscard), "Discard button not visible");
		Assert.assertTrue(isElementPresent(ba.btnsaveandexit), "Save and exit button not visible");
		Assert.assertTrue(isElementPresent(ba.btnsaveandnext), "Save and next button not visible");
		Assert.assertTrue(isElementPresent(ba.dd_course), "Course dropdown not visible");
		Assert.assertTrue(isElementPresent(ba.Assessmenttxtbx), "Assessment textbox not visible");
		softAssert3.assertEquals(getText(ba.btndiscard), "Discard", "Assertion  failed");
		Assert.assertEquals(getText(ba.btnsaveandexit), "Save & Exit");
		Assert.assertEquals(getText(ba.btnsaveandnext), "Save & Next");

		softAssert3.assertAll();
	}

	/*
	 * To check the placeholder of basic details page
	 */
	@Test(priority = 5)
	public void TCSPR090105() {

		SoftAssert softAssert4 = new SoftAssert();

		// To verify the placeholder and headings
		softAssert4.assertEquals(getText(ba.dd_course), "Select Course", "Assertion  failed");
		softAssert4.assertEquals(getText(ba.lbl_selectcourse), "Select Course*", "Assertion  failed");
		softAssert4.assertEquals(getText(ba.lbl_assessmentname), "Assessment Name*", "Assertion  failed");

		driver.switchTo().frame("assessmentInfo_ifr");
		Assert.assertEquals(getAttribute(ba.editorplaceholder1, "aria-placeholder"),
				"Mention the portion/lessons/modules covered for this assessment", "Assertion  failed");

		driver.switchTo().defaultContent();

		// To switch the frame
		driver.switchTo().frame("instructions_ifr");
		Assert.assertEquals(getAttribute(ba.editorplaceholder2, "aria-placeholder"),
				"Mention the guidelines and instructions to be followed for this online assessment", "Assertion  failed");

		softAssert4.assertAll();
	}

	/*
	 * To check the Info statements of the basic details
	 */
	@Test(priority = 6)
	public void TCSPR090106() {

		SoftAssert softAssert5 = new SoftAssert();

		// To verify the labels
		driver.switchTo().defaultContent();

		softAssert5.assertEquals(getText(ba.infolbl_Assessmentinfo),
				"Students can view this before an assessment starts", "Assertion  failed");
		softAssert5.assertEquals(getText(ba.infolbl_AssessmentInstru),
				"Students can view this before an assessment starts", "Assertion  failed");

		softAssert5.assertAll();
	}

	/*
	 * To check the headings of basic details page
	 */
	@Test(priority = 7)
	public void TCSPR090107() {

		SoftAssert softAssert6 = new SoftAssert();

		// To verify the labels
		driver.switchTo().defaultContent();
		waitThread(4000);
		softAssert6.assertEquals(getText(ba.lbl_assessmentinfo), "Assessment Information for Students",
				"Assertion  failed");
		Assert.assertTrue(isElementPresent(ba.Editor_Assessmentinfo), "Assessment info editor not present");
		softAssert6.assertEquals(getText(ba.lbl_AssessmentInstru), "Assessment Instructions for Students",
				"Assertion  failed");
		Assert.assertTrue(isElementPresent(ba.Editor_AssessmentInstru), "Assessment Instruction editor not present");

		softAssert6.assertAll();
	}

	/*
	 * To check the Course drop downs & validation messages of basic details
	 * page
	 */

	@Test(priority = 8)
	public void TCSPR090108() {

		SoftAssert softAssert7 = new SoftAssert();

		// To click on course drop down
		click(ba.dd_course);
		Assert.assertTrue(isElementPresent(ba.coursedropdowntab), "course dropdown tab not visible");
		Assert.assertTrue(isElementPresent(ba.coursedropdowntab), "course dropdown tab not visible");

		// To click on course drop down and assessment text box
		click(ba.Assessmenttxtbx);
		click(ba.dd_course);

		// To verify validation messages
		// softAssert7.assertEquals(getText(ba.valmsg1), "Course is required",
		// "Assertion failed");
		softAssert7.assertEquals(getText(ba.valmsg2), "Assessment Name is required", "Assertion  failed");

		softAssert7.assertAll();
	}

	/*
	 * To check the toaster validations when user click on Save&Exit, Save&Next
	 * , Discard buttons
	 */
	@Test(priority = 9)
	public void TCSPR090109() {

		SoftAssert softAssert8 = new SoftAssert();

		// To click on save and exit button and verify the toaster
		click(ba.btnsaveandexit);
		waitFor(ba.toaster);
		softAssert8.assertEquals(getText(ba.toaster), "Please enter the Course Name and Assessment Name",
				"Assertion  failed");
		click(ba.toasterclosebtn);
		waitThread(4000);

		// To click on save and next button and verify the toaster
		click(ba.btnsaveandnext);
		waitFor(ba.toaster);
		softAssert8.assertEquals(getText(ba.toaster), "Please enter the Course Name and Assessment Name",
				"Assertion  failed");
		click(ba.toasterclosebtn);
		waitThread(4000);

		// To click on discard button and verify the confirmation popup
		// functionality
		click(ba.btndiscard);

		Assert.assertTrue(isElementPresent(ba.Confirm_discardpopup), "Confirmation Popup not visible");
		waitFor(ba.Confirm_lbl_confirmation);
		Assert.assertEquals(getText(ba.Confirm_lbl_confirmation), "Confirmation", "Assertion  failed");
		Assert.assertEquals(getText(ba.Confirm_txtpopup),
				"Are you certain you want to proceed with your action?\n"
						+ "We see that you have not made any changes to the information on this screen",
				"Assertion failed");

		// Confirmation popup no button
		click(ba.Confirm_btnNo);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(ba.Confirm_discardpopup), "Confirmation Popup not visible");

		waitThread(1000);
		AssessmentName = "assess" + generateRandomNumber();
		// To click on course drop down and assessment text box
		click(ba.Assessmenttxtbx);
		type(ba.Assessmenttxtbx, AssessmentName);

		waitThread(1000);
		click(ba.btndiscard);
		Assert.assertTrue(isElementPresent(ba.Confirm_discardpopup), "Confirmation Popup not visible");

		waitThread(1000);
		waitFor(ba.Confirm_txtpopup);
		Assert.assertEquals(getText(ba.Confirm_txtpopup),
				"Are you sure you want to proceed with your action?\n"
						+ "We detected you have made changes to the information on this screen and if you ‘Discard’ these changes will not be saved.",
				"Assertion failed");

		// Confirmation popup yes button
		click(ba.Confirm_btnYes);

		Assert.assertEquals(getText(ba.lbl_assessment), "Assessments", "Assertion  failed");
		// To verify Current Assessment tab is selected
		Assert.assertEquals(getAttribute(ba.tabcurrectassessment, "aria-selected"), "true");

		softAssert8.assertAll();
	}

	/*
	 * To check the tab switching functionality-Course tab
	 */
	@Test(priority = 10)
	public void TCSPR090110() {

		// click on draft tab and verify draft tab is selected
		click(ba.tabdraft);
		waitThread(1000);

		Assert.assertEquals(getAttribute(ba.tabdraftselected, "aria-selected"), "true");
		// click on create new assessment button
		click(ba.btn_createnewassessment);
		waitThread(1000);

		click(ba.Assessmenttxtbx);
		type(ba.Assessmenttxtbx, AssessmentName);

		click(ba.btndiscard);
		Assert.assertTrue(isElementPresent(ba.Confirm_discardpopup), "Confirmation Popup not visible");

		// Confirmation popup yes button
		click(ba.Confirm_btnYes);
		waitThread(1000);
		Assert.assertEquals(getAttribute(ba.tabdraftselected, "aria-selected"), "true");

		SoftAssert softAssert9 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);

		// click on create new assessment button
		click(ba.btn_createnewassessment);
		waitThread(1000);

		AssessmentName = "assess" + generateRandomNumber();
		click(ba.Assessmenttxtbx);
		type(ba.Assessmenttxtbx, AssessmentName);

		// Click on course tab
		click(ba.CourseTab);

		// To verify the discard popup functionality
		waitFor(ba.tabdiscardpopup);
		Assert.assertTrue(isElementPresent(ba.tabdiscardpopup), "Confirmation Popup not visible");
		waitFor(ba.txt1popup);
		softAssert9.assertEquals(getText(ba.txt1popup), "Are you certain you want to proceed with your action?\n"
				+ "Any changes that you have made will not be saved.", "Assertion  failed");
		// pop up cancel button
		click(ba.btnCancel);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(ba.tabdiscardpopup), "Confirmation Popup not visible");

		click(ba.CourseTab);

		softAssert9.assertTrue(isElementPresent(ba.tabdiscardpopup), "Confirmation Popup not visible");
		// pop up discard button
		click(ba.btnDiscard);

		// verify heading courses
		softAssert9.assertEquals(getText(lg.pagetitle3), "Courses", "Assertion  failed");

		softAssert9.assertAll();

	}

	/*
	 * To check the tab switching functionality-Assessment tab
	 */
	@Test(priority = 11)
	public void TCSPR090111() {

		SoftAssert softAssert10 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(2000);
		
		// click on create new assessment button
		click(ba.btn_createnewassessment);
		softAssert10.assertEquals(getText(ba.headinglbl_createnewassessment), "Create New Assessment",
				"Assertion  failed");

		AssessmentName = "assess" + generateRandomNumber();
		click(ba.Assessmenttxtbx);
		type(ba.Assessmenttxtbx, AssessmentName);

		// click on Assessment tab
		click(ba.Assessmenttab);

		// To verify the discard popup functionality
		waitFor(ba.tabdiscardpopup);
		Assert.assertTrue(isElementPresent(ba.tabdiscardpopup), "Confirmation Popup not visible");
		waitFor(ba.txt1popup);
		softAssert10.assertEquals(getText(ba.txt1popup), "Are you certain you want to proceed with your action?\n"
				+ "Any changes that you have made will not be saved.", "Assertion  failed");

		softAssert10.assertAll();

	}

	/*
	 * To create a course for creating a new assessment
	 */
	@Test(priority = 12)
	public void TCSPR090112() {

		SoftAssert softAssert11 = new SoftAssert();

		// Popup button cancel
		click(ba.btnCancel);

		waitThread(1000);
		Assert.assertFalse(isElementPresent(ba.tabdiscardpopup), "Confirmation Popup not visible");
		click(ba.Assessmenttab);
		Assert.assertTrue(isElementPresent(ba.tabdiscardpopup), "Confirmation Popup not visible");

		// Popup button discard
		click(ba.btnDiscard);
		softAssert11.assertEquals(getText(ba.tabdraft), "Draft", "Assertion  failed");

		softAssert11.assertAll();

	}

	/*
	 * To check the created course visible on basic details page course drop
	 * down
	 */
	@Test(priority = 13)
	public void TCSPR090113() {

		SoftAssert softAssert12 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);

		// click on create new assessment button
		click(ba.btn_createnewassessment);
		softAssert12.assertEquals(getText(ba.headinglbl_createnewassessment), "Create New Assessment",
				"Assertion  failed");

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);
		softAssert12.assertEquals(getText(ba.ddcoursename1), CourseTitle.trim(), "Assertion  failed");

		// To search course on the course dropdown
		type(ba.coursesearchbox, CourseTitle);
		softAssert12.assertEquals(getText(ba.ddcoursename1), CourseTitle.trim(), "Assertion  failed");
		type(ba.coursesearchbox, "v");
		softAssert12.assertEquals(getText(ba.coursedd_label), "No courses found", "Assertion  failed");
		click(ba.coursesearchbox);
		waitThread(2000);
		driver.findElement(By.xpath(ba.coursesearchbox)).sendKeys((Keys.BACK_SPACE));
		softAssert12.assertEquals(getText(ba.ddcoursename1), CourseTitle.trim(), "Assertion  failed");

		softAssert12.assertAll();

	}

	/*
	 * To Save basic details page with Course name & Assessment name and verify
	 * the invalid toasters
	 */

	@Test(priority = 14)
	public void TCSPR090114() {

		SoftAssert softAssert13 = new SoftAssert();

		// To select course
		click(ba.ddcoursename1);
		softAssert13.assertEquals(getText(ba.courseddselect), CourseTitle.trim(), "Assertion  failed");

		// Click on save and exit button and verify the toasters
		click(ba.btnsaveandexit);
		waitFor(ba.toaster);
		softAssert13.assertEquals(getText(ba.toaster), "Please enter the Assessment Name", "Assertion  failed");
		click(ba.toasterclosebtn);
		waitThread(4000);

		// Click on save and next button and verify the toasters
		click(ba.btnsaveandnext);
		waitFor(ba.toaster);
		softAssert13.assertEquals(getText(ba.toaster), "Please enter the Assessment Name", "Assertion  failed");
		click(ba.toasterclosebtn);

		AssessmentName = "Assessmentname" + generateRandomNumber();

		driver.findElement(By.id("assessmentName")).clear();
		waitThread(2000);
		click(ba.Assessmenttxtbx);
		// Type assessment name
		driver.findElement(By.id("assessmentName")).sendKeys(AssessmentName.trim());
		waitThread(3000);

		click(ba.btnsaveandnext);
		waitFor(ba.toaster);
		softAssert13.assertEquals(getText(ba.toaster), "Saved successfully", "Assertion  failed");

		softAssert13.assertAll();
	}

	/*
	 * To check whether the incomplete Assessments visible in Draft page and
	 * verify the labels and buttons
	 */

	@Test(priority = 15)
	public void TCSPR090115() {

		SoftAssert softAssert14 = new SoftAssert();

		// click on discard button
		click(ba.btndiscard);
		waitThread(1000);

		// Confirmation popup yes button
		click(ba.Confirm_btnYes);

		// To verify Current Assessment tab is selected
		Assert.assertEquals(getAttribute(ba.tabcurrectassessment, "aria-selected"), "true");
		// click on draft tab and verify draft tab is selected
		click(ba.tabdraft);
		Assert.assertEquals(getAttribute(ba.tabdraftselected, "aria-selected"), "true");
		softAssert14.assertEquals(getText(ba.tabdraft), "Draft\n"+"1", "Assertion  failed");
		softAssert14.assertEquals(getText(ba.draftcoursename), CourseTitle.trim(), "Assertion  failed");
		softAssert14.assertEquals(getText(ba.draftassessmentname), AssessmentName.trim(), "Assertion  failed");
		Assert.assertTrue(isElementPresent(ba.btn_continueedit), "Continue edit button not visible");
		Assert.assertTrue(isElementPresent(ba.Deletebtn), "Delete button not visible");

		softAssert14.assertAll();
	}

	/*
	 * Create a new course To check whether the duplication of Assessment Name
	 * is possible for different course
	 */
	// @Test(priority = 16)
	public void TCSPR090116() {

		SoftAssert softAssert15 = new SoftAssert();

		click(ba.CourseTab);

		// To verify the create new course button
		Assert.assertTrue(isElementPresent(cn.btn_createnew), "Create new course button not present");

		// Click on create new course button
		click(cn.btn_createnew);

		NewCourseTitle = "New Course Name" + generateRandomNumber();

		// type-Course title
		type(cn.txbx_Coursetitle, NewCourseTitle.trim());

		waitThread(1000);
		// click on create course button
		click(cn.btn_Createcourse);

		waitThread(1000);
		// verify toaster-Course created successfully
		softAssert15.assertEquals(getText(cn.toaster).trim(), "Course created successfully", "Assertion  failed");

		waitThread(3000);

		// verify the course title
		softAssert15.assertEquals(getText(cn.value_coursetitle).trim(), CourseTitle.trim(), "Assertion  failed");

		// click on Assessment tab
		click(ba.Assessmenttab);

		click(ba.btn_createnewassessment);
		softAssert15.assertEquals(getText(ba.headinglbl_createnewassessment), "Create New Assessment",
				"Assertion  failed");

		// To click on course dropdown
		click(ba.dd_course);

		// select latest added course
		click(ba.ddcoursename2);

		driver.findElement(By.id("assessmentName")).clear();
		waitThread(2000);
		click(ba.Assessmenttxtbx);
		// Type assessment name
		driver.findElement(By.id("assessmentName")).sendKeys(AssessmentName.trim());
		waitThread(3000);

		// click on save and next button
		click(ba.btnsaveandnext);

		waitFor(ba.toaster);
		softAssert15.assertEquals(getText(ba.toaster), "Saved successfully", "Assertion  failed");

		softAssert15.assertAll();

	}

	/*
	 * To check the Question Page Wizard functionality-To check the assessment
	 * name
	 */
	// @Test(priority = 17)
	public void TCSPR090117() {

		SoftAssert softAssert16 = new SoftAssert();

		waitThread(2000);
		softAssert16.assertEquals(getText(ba.stepperassessmentname), "Assessment Name: " + AssessmentName.trim(),
				"Assertion  failed");

		waitFor(ba.Questionwizard);
		// To verify the question wizard is selected
		softAssert16.assertEquals(getAttribute(ba.Questionwizard, "aria-selected"), "true", "Assertion  failed");

		softAssert16.assertAll();
	}

	/*
	 * To check whether the duplication of Assessment Name is possible for Same
	 * course
	 */

	// @Test(priority = 18)
	public void TCSPR090118() {

		SoftAssert softAssert17 = new SoftAssert();

		// click(ba.btndiscard);
		waitThread(1000);

		// Confirmation popup yes button
		// click(ba.Confirm_btnYes);

		softAssert17.assertEquals(getText(ba.tabdraft), "Draft", "Assertion  failed");
		// To verify Current Assessment tab is selected
		Assert.assertEquals(getAttribute(ba.tabcurrectassessment, "aria-selected"), "true");
		// click on draft tab and verify draft tab is selected
		click(ba.tabdraft);
		Assert.assertEquals(getAttribute(ba.tabdraftselected, "aria-selected"), "true");

		click(ba.btn_continueedit);
		softAssert17.assertEquals(getText(ba.headinglbl_createnewassessment), "Create New Assessment",
				"Assertion  failed");

		// To click on course drop down
		click(ba.dd_course);

		// select first course
		click(ba.ddcoursename1);
		waitFor(ba.valmsg3);
		softAssert17.assertEquals(getText(ba.valmsg3),
				"The assessment name of '" + AssessmentName.trim() + "' already exists. Please enter a new name.",
				"Assertion  failed");
		waitThread(3000);
		// click on save and next button
		click(ba.btnsaveandnext);
		waitFor(ba.toaster);
		softAssert17.assertEquals(getText(ba.toaster),
				"The Assessment name of '" + AssessmentName.trim() + "' already exists. Please enter a new name.",
				"Assertion  failed");
		click(ba.toasterclosebtn);
		softAssert17.assertAll();

	}

	/*
	 * To perform Assessment delete functionality
	 */

	// @Test(priority = 19)
	public void TCSPR090119() {

		SoftAssert softAssert18 = new SoftAssert();

		// click on discard button
		click(ba.btndiscard);

		click(ba.btndiscard);
		Assert.assertTrue(isElementPresent(ba.Confirm_discardpopup), "Confirmation Popup not visible");

		waitThread(1000);
		click(ba.Confirm_btnYes);

		waitThread(1000);
		softAssert18.assertEquals(getText(ba.lbl_assessment), "Assessments", "Assertion  failed");

		// To delete the assessment 2nd row
		click(ba.Deletebtn2);

		// To verify the delete confirmation popup
		Assert.assertTrue(isElementPresent(ba.draftconfirmationbx), "Confirmation popup not visible");
		click(ba.draftconfYes);
		waitFor(ba.toaster);
		softAssert18.assertEquals(getText(ba.toaster),
				"The assessment '" + AssessmentName.trim() + "' has been successfully deleted", "Assertion  failed");

		waitThread(1000);
		Assert.assertFalse(isElementPresent(ba.draftassessmentname2),
				"Assessment name" + AssessmentName.trim() + "visible");

		softAssert18.assertAll();

	}
	/*
	 * To check whether the deleted assessment name can be again used for create
	 * new assessment
	 */

	@Test(priority = 20)
	public void TCSPR090120() {

		SoftAssert softAssert19 = new SoftAssert();

		click(ba.btn_createnewassessment);
		// To click on course drop down
		click(ba.dd_course);

		// select course
		click(ba.ddcoursename1);

		driver.findElement(By.id("assessmentName")).clear();
		waitThread(2000);

		AssessmentName = "assessment_name" + generateRandomNumber();

		click(ba.Assessmenttxtbx);
		// Type assessment name
		driver.findElement(By.id("assessmentName")).sendKeys(AssessmentName.trim());
		waitThread(3000);

		// click save and exit button
		click(ba.btnsaveandexit);
		waitFor(ba.toaster);
		softAssert19.assertEquals(getText(ba.toaster), "Saved successfully", "Assertion  failed");
		waitThread(1000);
		Assert.assertEquals(getAttribute(ba.tabdraftselected, "aria-selected"), "true");
		softAssert19.assertAll();
	}

	/*
	 * To perform Assessment delete functionality
	 */

	@Test(priority = 21)
	public void TCSPR090121() {

		SoftAssert softAssert20 = new SoftAssert();

		// Click on assessment delete button
		click(ba.Deletebtn);
		Assert.assertTrue(isElementPresent(ba.draftconfirmationbx), "Confirmation popup not visible");
		click(ba.draftconfYes);
		waitFor(ba.toaster);
		softAssert20.assertEquals(getText(ba.toaster),
				"The assessment '" + AssessmentName.trim() + "' has been successfully deleted", "Assertion  failed");

		waitThread(1000);
		Assert.assertFalse(isElementPresent(ba.draftassessmentname2),
				"Assessment name" + AssessmentName.trim() + "visible");

		softAssert20.assertAll();

	}

	/*
	 * To perform Account delete functionality and verify the discard popup from
	 * basic details page while click on navigation bar
	 */

	@Test(priority = 22)
	public void TCSPR090122() {

		SoftAssert softAssert21 = new SoftAssert();

		waitThread(3000);
		// click on create new assessment button
		click(ba.btn_createnewassessment);
		waitThread(2000);

		AssessmentName = "assessname" + generateRandomNumber();
		// To click on course drop down and assessment text box
		click(ba.Assessmenttxtbx);
		type(ba.Assessmenttxtbx, AssessmentName);

		softAssert21.assertEquals(getText(ba.headinglbl_createnewassessment), "Create New Assessment",
				"Assertion  failed");
		// click on teacher name on navigation menu
		click(ba.Teachername);

		// click on account settings
		click(ba.linkaccountsettings);

		waitThread(1000);
		// To verify the discard popup functionality
		waitFor(ba.tabdiscardpopup);
		Assert.assertTrue(isElementPresent(ba.tabdiscardpopup), "Confirmation Popup not visible");
		waitFor(ba.txt1popup);
		softAssert21.assertEquals(getText(ba.txt1popup), "Are you certain you want to proceed with your action?\n"
				+ "Any changes that you have made will not be saved.", "Assertion  failed");

		// Popup button cancel
		click(ba.btnCancel);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(ba.tabdiscardpopup), "Confirmation Popup not visible");

		// click on teacher name on navigation menu
		click(ba.Teachername);

		// click on account settings
		click(ba.linkaccountsettings);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(ba.tabdiscardpopup), "Confirmation Popup not visible");

		// Popup button discard
		click(ba.btnDiscard);
		waitThread(1000);

		Assert.assertTrue(isElementPresent(ba.btn_delete), "Delete button not visible");

		softAssert21.assertAll();
	}

	@Test(priority = 23)
	public void TCSPR090122_CourseTabDiscard() {

		SoftAssert softAssert22 = new SoftAssert();
		// click edit button on Account Settings page
		click(as.edit_button3);
		click(as.frstnam_txt6);

		// clear the firstname in firstname textbox
		driver.findElement(By.xpath(as.frstnam_txt6)).clear();

		type(as.frstnam_txt6, "S");
		waitThread(1000);
		click(as.lstnam_txt7);
		// clear the last
		driver.findElement(By.xpath(as.lstnam_txt7)).clear();
		type(as.lstnam_txt7, "d");

		click(ba.Assessmenttab);
		// Click on course tab
		click(ba.CourseTab);

		// To verify the discard popup functionality
		waitFor(ba.tabdiscardpopup);
		Assert.assertTrue(isElementPresent(ba.tabdiscardpopup), "Confirmation Popup not visible");
		waitFor(ba.txt1popup);
		softAssert22.assertEquals(getText(ba.txt1popup), "Are you certain you want to proceed with your action?\n"
				+ "Any changes that you have made will not be saved.", "Assertion  failed");
		// pop up cancel button
		click(ba.btnCancel);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(ba.tabdiscardpopup), "Confirmation Popup not visible");

		click(ba.CourseTab);

		softAssert22.assertTrue(isElementPresent(ba.tabdiscardpopup), "Confirmation Popup not visible");
		// pop up discard button
		click(ba.btnDiscard);

		// verify heading courses
		softAssert22.assertEquals(getText(lg.pagetitle3), "Courses", "Assertion  failed");

		softAssert22.assertAll();
	}

	@Test(priority = 24)
	public void TCSPR090122_AssessmentTabDiscard() {

		// click navigation dropdown
		click(as.nav_drop1);
		// click account settings button
		click(as.accnt_sett1);
		waitThread(2000);

		// Assert the label Account Settings in accountsettings Page
		Assert.assertEquals(getText(as.hd_label5), "Account Settings");

		SoftAssert softAssert23 = new SoftAssert();
		// click edit button on Account Settings page
		click(as.edit_button3);
		click(as.frstnam_txt6);

		// clear the firstname in firstname textbox
		driver.findElement(By.xpath(as.frstnam_txt6)).clear();

		type(as.frstnam_txt6, "S");
		waitThread(1000);
		click(as.lstnam_txt7);
		// clear the last
		driver.findElement(By.xpath(as.lstnam_txt7)).clear();
		type(as.lstnam_txt7, "d");

		click(ba.Assessmenttab);

		// To verify the discard popup functionality
		waitFor(ba.tabdiscardpopup);
		Assert.assertTrue(isElementPresent(ba.tabdiscardpopup), "Confirmation Popup not visible");
		waitFor(ba.txt1popup);
		softAssert23.assertEquals(getText(ba.txt1popup), "Are you certain you want to proceed with your action?\n"
				+ "Any changes that you have made will not be saved.", "Assertion  failed");
		// pop up cancel button
		click(ba.btnCancel);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(ba.tabdiscardpopup), "Confirmation Popup not visible");

		click(ba.Assessmenttab);

		softAssert23.assertTrue(isElementPresent(ba.tabdiscardpopup), "Confirmation Popup not visible");
		// pop up discard button
		click(ba.btnDiscard);

		// To verify Current Assessment tab is selected
		Assert.assertEquals(getAttribute(ba.tabcurrectassessment, "aria-selected"), "true");

		softAssert23.assertAll();
	}

	@Test(priority = 25)
	public void TCSPR090122_DeleteAccount() {

		cm.DeleteAccount();
	}

	/*
	 * To perform login functionality using deleted account credentials
	 */
	@Test(priority = 26)
	public void TCSPR090123() {

		// To login with deleted account credentials
		lg.login(Emailteacher, "Abc@123");

		waitFor(lg.validationmsg3);
		// verify toaster text
		Assert.assertEquals(getText(lg.validationmsg3), "Enter a valid email address and password",
				"Assertion  failed");

	}

}
