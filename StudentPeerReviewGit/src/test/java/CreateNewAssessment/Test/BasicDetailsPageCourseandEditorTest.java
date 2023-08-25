package CreateNewAssessment.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;

import Course.Pages.CreateNewCoursePage;
import Course.Pages.EditCoursePage;
import Course.Test.CreateNewCourseTest;
import Course.Test.EditCourseTest;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.BasicDetailsPageCourseandEditorPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;

public class BasicDetailsPageCourseandEditorTest extends basePage {

	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	CreateNewCourseTest cnt = new CreateNewCourseTest();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	BasicDetailsAssessmentTest bat = new BasicDetailsAssessmentTest();
	EditCoursePage ec = new EditCoursePage();
	EditCourseTest ect = new EditCourseTest();
	CommonMethods cm = new CommonMethods();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	BasicDetailsPageCourseandEditorPage be = new BasicDetailsPageCourseandEditorPage();

	public String Emailteacher;
	public String CourseName;
	public String NewCourseTitle;
	public String CourseID;
	public String AssessmentName;
	public String NewCourseName;

	/*
	 * To perform Sign Up functionality
	 */
	@Test(priority = 0)
	public void TCSPR090201() throws SQLException {

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
	 * To perform create new course functionality
	 */
	@Test(priority = 2)
	public void TCSPR090202() {

		CourseName = "Course Name" + generateRandomNumber().trim();

		// Click on create new course button
		click(cn.btn_createnew);

		// type-Course title
		type(cn.txbx_Coursetitle, CourseName);

		// To verify course name
		Assert.assertEquals(getValue(cn.txbx_Coursetitle).trim(), CourseName.trim());

		// To get the Course ID
		CourseID = (getText(cn.course_Id));
		waitThread(2000);

		// click on create course button
		click(cn.btn_Createcourse);

		waitThread(3000);

		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), CourseName.trim());

	}

	/*
	 * To check that the course name visible on the basic details page and
	 * perform discard functionality[Verify the popup text]
	 */
	@Test(priority = 3)
	public void TCSPR090203() {

		SoftAssert softAssert1 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);
		softAssert1.assertEquals(getText(ba.lbl_assessment), "Assessments", "Assertion  failed");
		// verify current tab is selected
		Assert.assertTrue(getAttribute(be.tab_current, "class").contains("p-highlight"));
		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);
		softAssert1.assertEquals(getText(ba.headinglbl_createnewassessment), "Create New Assessment",
				"Assertion  failed");

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);
		softAssert1.assertEquals(getText(ba.ddcoursename1), CourseName.trim(), "Assertion  failed");

		// Click on discard button
		click(ba.btndiscard);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(be.Confirm_discardpopup), "Confirmation Popup not visible");
		// Popuptext:Are you certain you want to proceed with your action?We see
		// that you have not made any changes to the information on this screen
		softAssert1.assertEquals(getText(be.Confirm_txtpopup),
				"Are you certain you want to proceed with your action?\n"
						+ "We see that you have not made any changes to the information on this screen",
				"Assertion failed");

		waitThread(1000);
		click(be.Confirm_btnYes);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(be.Confirm_discardpopup), "Confirmation Popup  visible");
		softAssert1.assertEquals(getText(ba.lbl_assessment), "Assessments", "Assertion  failed");
		// verify current tab is selected
		Assert.assertTrue(getAttribute(be.tab_current, "class").contains("p-highlight"));
		// verify assessment tab is selected
		Assert.assertTrue(getAttribute(be.tab_Assessment, "class").contains("active"));

		softAssert1.assertAll();

	}

	/*
	 * To edit the course name from the course details page and perform the
	 * discard pop up functionality while click on assessment tab
	 */

	@Test(priority = 4)
	public void TCSPR090204() {

		SoftAssert softAssert2 = new SoftAssert();
		// click on course tab
		click(ba.CourseTab);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		ect.TCSPR070204();

		NewCourseName = "New Course Name" + generateRandomNumber();

		// click on Edit button
		click(ec.btn_edit);

		// type-Course title
		type(cn.txbx_Coursetitle, NewCourseName);

		// Click on assessments tab
		click(ba.Assessmenttab);
		waitThread(1000);
		// To verify the discard popup functionality
		Assert.assertTrue(isElementPresent(be.Assessmenttabdiscardpopup), "Confirmation Popup not visible");
		waitFor(be.Assessment_txt1popup);
		softAssert2.assertEquals(getText(be.Assessment_txt1popup),
				"Are you certain you want to proceed with your action?\n"
						+ "Any changes that you have made will not be saved.",
				"Assertion  failed");
		waitThread(1000);
		// pop up cancel button
		JavaScriptclick(be.Assessment_btnCancel);
		waitThread(1000);

		Assert.assertFalse(isElementPresent(be.Assessmenttabdiscardpopup), "Confirmation Popup not visible");

		// Click on assessments tab
		click(ba.Assessmenttab);

		Assert.assertTrue(isElementPresent(ba.tabdiscardpopup), "Confirmation Popup not visible");

		// Popup button discard
		JavaScriptclick(be.Assessment_btnDiscard);
		Assert.assertTrue(getAttribute(be.tab_current, "class").contains("p-highlight"));

		softAssert2.assertAll();

	}

	/*
	 * To modify the course name from course details page
	 */
	@Test(priority = 5)
	public void TCSPR090205() {

		SoftAssert softAssert3 = new SoftAssert();

		// click on course tab
		click(ba.CourseTab);

		type(cn.searchbx, CourseName);
		waitThread(1000);
		ect.TCSPR070204();

		NewCourseName = "New Course Name" + generateRandomNumber();

		// click on Edit button
		click(ec.btn_edit);

		// type-Course title
		type(cn.txbx_Coursetitle, NewCourseName);

		// click on save changes button
		click(ec.btnsave);
		waitThread(1000);

		// Verify the toaster message
		softAssert3.assertEquals(getText(ec.toaster), "Course details updated successfully");
		click(ba.toasterclosebtn);
		waitThread(1000);
		// verify the following buttons disabled
		Assert.assertFalse(isEnabled(ec.btnsave), "Save button is enabled");
		softAssert3.assertAll();
	}

	/*
	 * To check the updated course name visible on the create new assessment
	 * basic details page
	 */

	@Test(priority = 6)
	public void TCSPR090206() {

		SoftAssert softAssert4 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(1000);
		softAssert4.assertFalse(isElementPresent(ba.tabdiscardpopup), "Confirmation Popup not visible");

		click(ba.btn_createnewassessment);

		waitThread(2000);
		// To click on course dropdown
		click(ba.dd_course);

		waitFor(ba.ddcoursename1);
		softAssert4.assertEquals(getText(ba.ddcoursename1), NewCourseName.trim(), "Assertion  failed");

		softAssert4.assertAll();

	}
	/*
	 * To perform delete course functionality
	 */

	@Test(priority = 7)
	public void TCSPR090207() {

		SoftAssert softAssert5 = new SoftAssert();
		waitThread(2000);
		// click on course tab
		click(ba.CourseTab);
		waitThread(3000);
		// verify heading courses
		softAssert5.assertEquals(getText(lg.pagetitle3), "Courses");
		waitThread(3000);
		click(cn.btn_details_1);
		// Click on delete course link
		click(cn.link_deletecourse);
		waitThread(2000);
		// click on Yes button
		click(cn.delete_yes);
		waitThread(3000);
		// verify that the course name not visible on the grid
		Assert.assertFalse(isElementPresent(cn.value_coursetitle), "Course Visible on the grid");
		softAssert5.assertAll();
	}

	/*
	 * To check that a nocourse popup visible on the page while click on
	 * assessment tab
	 * 
	 */
	@Test(priority = 8)
	public void TCSPR090208() {

		SoftAssert softAssert6 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);
		// check the popup and ok button visible
		Assert.assertTrue(isElementPresent(cn.nocoursepopup), "No Course pop up not visible");
		// click on ok button and check the popup not visible
		click(cn.btn_ok);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(cn.nocoursepopup), "No Course pop up  visible");
		// verify the course tab is selected
		Assert.assertTrue(getAttribute(cn.btnheader_course, "class").contains("active"));

		softAssert6.assertAll();

	}

	/*
	 * To perform create new course functionality and To load the create new
	 * assessment basic details page
	 */
	@Test(priority = 9)
	public void TCSPR090209() {

		SoftAssert softAssert7 = new SoftAssert();

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		TCSPR090202();

		// click on Assessment tab
		click(ba.Assessmenttab);
		softAssert7.assertEquals(getText(ba.lbl_assessment), "Assessments", "Assertion  failed");

		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);
		waitThread(5000);
		waitFor(ba.lbl_assessmentinfo);
		Assert.assertEquals(getText(ba.lbl_assessmentinfo), "Assessment Information for Students");

		softAssert7.assertAll();

	}

	/*
	 * To perform the Assessment Info Editor insert/edit image image upload
	 * functionality
	 */
	public String ImageURL = cm.ImageURL;

	@Test(enabled = false)
	public void TCSPR090210() {

		// Editor image button
		click(be.infoeditorimagebtn);

		// Verify the popup
		Assert.assertTrue(isElementPresent(be.popupimage), "Edit/Add image Popup not visible");
		waitThread(2000);
		// Type image URL
		driver.findElement(
				By.cssSelector("div[id*=dialog-describe_] > div > div > div > div:nth-child(1) > div > div>input"))
				.sendKeys(ImageURL);
		waitThread(5000);
		// click on save button
		click(be.imageuploadsavebtn);
		waitThread(2000);

		click(ba.lbl_assessmentinfo);
		// To switch the instruction frame
		driver.switchTo().frame("assessmentInfo_ifr");
		waitFor(be.instrimage);

		// To verify the added video visible
		Assert.assertTrue(isElementPresent(be.instrimage), "Uploaded image not visible");
		driver.findElement(By.xpath(ba.editorplaceholder1)).sendKeys(Keys.ENTER);
	}

	/*
	 * To perform the Assessment Info Editor Insert/Edit Media upload
	 * functionality
	 */
	public String VideoURL = cm.VideoURL;

	@Test(enabled = false)
	public void TCSPR090211() throws AWTException {

		driver.switchTo().defaultContent();

		// Editor video button
		click(be.infoeditorvideobtn);

		Assert.assertTrue(isElementPresent(be.popupimage), "Insert/Edit Media Popup not visible");
		waitThread(5000);
		driver.findElement(
				By.cssSelector("div[id*=dialog-describe_] > div > div > div > div:nth-child(1) > div > div>input"))
				.sendKeys(VideoURL);
		waitThread(7000);

		// click on save button
		click(be.videouploadsavebtn);
		waitThread(2000);

		// To switch the info frame
		driver.switchTo().frame("assessmentInfo_ifr");
		waitFor(be.infovideo1);

		// To verify the added video visible
		Assert.assertTrue(isElementPresent(be.infovideo1), "Uploaded video not visible");
		Assert.assertEquals(getAttribute(be.infovideo, "type"), "video/mp4");

	}

	/*
	 * To perform the Assessment Info Editor Insert/Edit Link add functionality
	 */
	public String URL = cm.URL;

	@Test(enabled = false)
	public void TCSPR090212() {

		driver.switchTo().defaultContent();

		click(ba.lbl_assessmentinfo);
		waitThread(1000);

		// Editor Info button
		click(be.infoeditorbtnlink);
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

		// Switch to assessment Info frame
		driver.switchTo().frame("assessmentInfo_ifr");
		Assert.assertTrue(isElementPresent(be.infolink), "Uploaded image not visible");
		Assert.assertEquals(getAttribute(be.infolink, "data-mce-href"), URL);
		driver.findElement(By.xpath(ba.editorplaceholder1)).sendKeys(Keys.ENTER);

	}

	/*
	 * To perform the Assessment Info Editor insert/edit image image upload
	 * functionality
	 */

	@Test(enabled = false)
	public void TCSPR090213() {
		driver.switchTo().defaultContent();

		// click on image button
		click(be.instreditorimagebtn);
		Assert.assertTrue(isElementPresent(be.popupimage), "Edit/Add image Popup not visible");
		waitThread(2000);
		driver.findElement(
				By.cssSelector("div[id*=dialog-describe_] > div > div > div > div:nth-child(1) > div > div>input"))
				.sendKeys(ImageURL);
		waitThread(5000);
		click(be.imageuploadsavebtn);
		waitThread(2000);

		// Switch to the instruction frame
		driver.switchTo().frame("instructions_ifr");
		waitThread(2000);
		Assert.assertTrue(isElementPresent(be.instrimage), "Uploaded image not visible");

	}

	/*
	 * click on Instruction editor image button
	 */
	@Test(enabled = false)
	public void TCSPR090214() {

		driver.switchTo().defaultContent();
		click(ba.lbl_AssessmentInstru);
		driver.switchTo().frame("instructions_ifr");
		driver.findElement(By.xpath(ba.editorplaceholder2)).sendKeys(Keys.ENTER);
		driver.switchTo().defaultContent();
		click(be.instreditorvideobtn);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(be.popupimage), "Insert/Edit Media Popup not visible");

	}
	/*
	 * To perform the Assessment Instruction Editor Insert/Edit Media upload
	 * functionality
	 */

	@Test(enabled = false)
	public void TCSPR090215() {

		// Click on video button in the editor
		click(be.instreditorvideobtn);
		Assert.assertTrue(isElementPresent(be.popupimage), "Insert/Edit Media Popup not visible");
		waitThread(2000);
		driver.findElement(
				By.cssSelector("div[id*=dialog-describe_] > div > div > div > div:nth-child(1) > div > div>input"))
				.sendKeys(VideoURL);
		waitThread(7000);
		click(be.videouploadsavebtn);
		waitThread(2000);

		// verify the added image on the editor
		driver.switchTo().frame("instructions_ifr");
		Assert.assertTrue(isElementPresent(be.infovideo1), "Uploaded video not visible");
		Assert.assertEquals(getAttribute(be.infovideo, "type"), "video/mp4");
	}

	/*
	 * To perform the Assessment Instruction Editor Insert/Edit Link add
	 * functionality
	 */
	@Test(enabled = false)
	public void TCSPR090216() {

		driver.switchTo().defaultContent();
		click(ba.lbl_AssessmentInstru);
		waitThread(1000);

		// click on link button
		click(be.instreditorbtnlink);
		Assert.assertTrue(isElementPresent(be.popupimage), "Insert/Edit Link Popup not visible");
		waitThread(2000);
		String URL = "https://en.wikipedia.org/wiki/Organic_chemistry";

		// To Type URL
		click(be.urltextbx);
		type(be.urltextbx, URL);
		waitThread(2000);
		click(be.texttodisplaybx);
		waitThread(5000);
		click(be.imageuploadsavebtn);
		waitThread(2000);

		// To switch the frame and verify the URL
		driver.switchTo().frame("instructions_ifr");
		Assert.assertTrue(isElementPresent(be.instrlink), "Uploaded link not visible");
		Assert.assertEquals(getAttribute(be.instrlink, "data-mce-href"), URL);
		driver.findElement(By.xpath(ba.editorplaceholder2)).sendKeys(Keys.ENTER);
	}

	/*
	 * To check the toaster functionality on the basic details page
	 */
	@Test(priority = 17)
	public void TCSPR090217() {

		driver.switchTo().defaultContent();
		SoftAssert softAssert7 = new SoftAssert();

		// To click on save and next button and verify the toaster
		click(ba.btnsaveandnext);
		waitFor(ba.toaster);
		softAssert7.assertEquals(getText(ba.toaster), "Please enter the Course Name and Assessment Name",
				"Assertion  failed");
		click(ba.toasterclosebtn);
		softAssert7.assertAll();

	}

	/*
	 * To move on to the question page from basic details page
	 */
	@Test(priority = 18)
	public void TCSPR090218() throws AWTException {

		SoftAssert softAssert7 = new SoftAssert();

		waitThread(4000);
		ScrollTo_Location(ba.WizardBasicdetails);
		waitThread(4000);
		// To select course
		click(ba.dd_course);
		click(ba.ddcoursename1);
		AssessmentName = "Assessmentname" + generateRandomNumber();

		// Type assessment name
		type(ba.Assessmenttxtbx, AssessmentName.trim());
		waitThread(3000);
		click(ba.btnsaveandnext);

		waitFor(ba.toaster);
		softAssert7.assertEquals(getText(ba.toaster), "Saved successfully", "Assertion  failed");
		click(ba.toasterclosebtn);
		waitThread(3000);
		// To verify the question wizard is selected
		softAssert7.assertEquals(getAttribute(ba.Questionwizard, "aria-selected"), "true", "Assertion  failed");

		softAssert7.assertAll();
	}
	/*
	 * To click back to basic details page from the question page.check that the
	 * details saved properly
	 * 
	 */

	@Test(priority = 19)
	public void TCSPR090219() {

		// Click on basic details wizard
		click(ba.WizardBasicdetails);
		waitThread(2000);

		// verify the course name in the course dropdown
		waitFor(ba.courseddselect);
		Assert.assertEquals(getText(ba.courseddselect), CourseName.trim(), "Assertion  failed");

	}

	/*
	 * To verify that the added details[image,video,link,equation] are visible
	 * in Assessment Info when it is taken from question page
	 */
	@Test(enabled = false)
	public void TCSPR090220() throws AWTException {

		driver.switchTo().frame("assessmentInfo_ifr");
		waitThread(2000);
		Assert.assertTrue(isElementPresent(be.instrimage), "Uploaded image not visible");
		Assert.assertTrue(isElementPresent(be.infovideo1), "Uploaded video not visible");
		Assert.assertEquals(getAttribute(be.infovideo, "type"), "video/mp4");
		Assert.assertTrue(isElementPresent(be.infolink), "Uploaded link not visible");
		Assert.assertEquals(getAttribute(be.infolink, "data-mce-href"), URL);
	}

	/*
	 * To verify that the added details[image,video,link,equation] are visible
	 * in Assessment Instructions when it is taken from question page
	 */
	@Test(enabled = false)
	public void TCSPR090221() {

		driver.switchTo().defaultContent();
		driver.switchTo().frame("instructions_ifr");
		waitThread(2000);
		Assert.assertTrue(isElementPresent(be.instrimage), "Uploaded image not visible");
		waitThread(2000);
		Assert.assertTrue(isElementPresent(be.infovideo1), "Uploaded video not visible");
		Assert.assertEquals(getAttribute(be.infovideo, "type"), "video/mp4");

	}

	/*
	 * To verify the assessment details on the draft page
	 */
	@Test(priority = 22)
	public void TCSPR090222() {

		driver.switchTo().defaultContent();
		waitThread(2000);
		// Click on save and exit button
		click(ba.btnsaveandexit);
		waitThread(2000);

		// To verify Current Assessment tab is selected
		Assert.assertEquals(getAttribute(ba.tabcurrectassessment, "aria-selected"), "true");
		// click on draft tab and verify draft tab is selected
		click(ba.tabdraft);
		Assert.assertEquals(getAttribute(ba.tabdraftselected, "aria-selected"), "true");

		// verify course name and assessment name
		Assert.assertEquals(getText(ba.draftcoursename), CourseName.trim(), "Assertion  failed");
		Assert.assertEquals(getText(ba.draftassessmentname), AssessmentName.trim(), "Assertion  failed");

		String date1 = pr.getdate();
		// Assert the created on date same as system date
		Assert.assertTrue(getText(pr.draftcreatdatelbl).trim().contains(date1.trim()));

		// Assert the last modified date same as system date
		Assert.assertTrue(getText(pr.draftmodifieddate_lbl).trim().contains(date1.trim()));

	}

	/*
	 * To verify that the added details
	 */
	@Test(priority = 22)
	public void TCSPR090223() throws AWTException {

		click(be.draftcontinueedit);
		waitThread(5000);
		Assert.assertEquals(getText(ba.courseddselect), CourseName.trim(), "Assertion  failed");

	}

	/*
	 * To verify that the added details[image,video,link] are visible in
	 * Assessment Instructions when it is taken from question page
	 */
	@Test(enabled = false)
	public void TCSPR090224() {

		TCSPR090221();

	}

	/*
	 * To perform the assessment delete functionality on the draft page
	 */
	@Test(priority = 25)
	public void TCSPR090225() {

		driver.switchTo().defaultContent();

		// Click on save and exit button
		click(ba.btnsaveandexit);
		waitThread(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(getText(ba.tabdraft), "Draft");
		// verify draft tab is selected
		Assert.assertEquals(getAttribute(ba.tabdraftselected, "aria-selected"), "true");
		Assert.assertTrue(isElementPresent(ba.Deletebtn), "Draft page delete button not visible");

	}

	/*
	 * To perform the assessment delete functionality on the draft page
	 */
	@Test(priority = 26)
	public void TCSPR090226() {

		// click on draft delete button
		click(be.draftdeletebtn);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(isElementPresent(ba.draftconfirmationbx), "Draft page delete confirmation popup not visible");

		Assert.assertTrue(isElementPresent(ba.draftconfYes), "Draft page delete popup yes button not visible");
		waitFor(be.draftbxtext);
		Assert.assertEquals(getText(be.draftbxtext),
				"Are you sure that you want to permanently delete this assessment?");

		// click on yes button in the confirmation popup
		click(ba.draftconfYes);
		waitFor(ba.toaster);
		Assert.assertEquals(getText(ba.toaster),
				"The assessment '" + AssessmentName.trim() + "' has been successfully deleted");

	}

	/*
	 * To verify the draft page heading labels
	 */
	@Test(priority = 27)
	public void TCSPR090227() {

		click(ba.toasterclosebtn);
		waitThread(3000);
		Assert.assertEquals(getText(be.lblsn), "S/N");
		Assert.assertEquals(getText(be.lblcoursename), "Course Name");
		Assert.assertEquals(getText(be.lblassessmntname), "Assessment Name");
		Assert.assertEquals(getText(be.lblQuestioncount), "Question Count");
		Assert.assertEquals(getText(be.lblcreatedon), "Create on");
		Assert.assertEquals(getText(be.lblmodifyon), "Last Modified");
		Assert.assertEquals(getText(be.lblaction), "Action");

	}

	/*
	 * To perform delete account functionality and try to login using deleted
	 * account credentials
	 */
	@Test(priority = 28)
	public void TCSPR090228() {

		// To perform delete account functionality
		cm.DeleteAccount();
		waitThread(2000);
		// To login with deleted account credentials
		lg.login(Emailteacher, "Abc@123");

		waitFor(lg.validationmsg3);
		// verify toaster text
		Assert.assertEquals(getText(lg.validationmsg3), "Enter a valid email address and password");

	}

}
