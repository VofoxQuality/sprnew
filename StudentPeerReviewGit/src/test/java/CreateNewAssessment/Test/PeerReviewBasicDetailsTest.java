package CreateNewAssessment.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.Databaseconnection;

import Course.Pages.CreateNewCoursePage;
import Course.Pages.EditCoursePage;
import Course.Test.CreateNewCourseTest;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.BasicDetailsPageCourseandEditorPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;

public class PeerReviewBasicDetailsTest extends basePage {

	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	CreateNewCourseTest cnt = new CreateNewCourseTest();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	EditCoursePage ec = new EditCoursePage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	BasicDetailsPageCourseandEditorPage be = new BasicDetailsPageCourseandEditorPage();

	public String Emailteacher;
	public String CourseName;
	public String CourseNamenew;
	public String NewCourseTitle;
	public String CourseID;
	public String AssessmentName;
	public String NewAssessmentName;
	public String NewCourseName;

	/*
	 * To perform Sign Up functionality
	 */
	@Test(priority = 0)
	public void TCSPR090701() throws SQLException {

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
	public void TCSPR090702() {

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
	 * To load the create new assessment page and fill details on the basic
	 * details page
	 */
	@Test(priority = 3)
	public void TCSPR090703() {

		SoftAssert softAssert1 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(3000);
		// verify current tab is selected
		Assert.assertTrue(getAttribute(pr.tab_current, "class").contains("p-highlight"));
		// verify the assessment tab iss elected
		Assert.assertTrue(getAttribute(pr.tab_Assessment, "class").contains("active"));
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

		waitThread(3000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), AssessmentName);

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID + ", " + CourseName);

		softAssert1.assertAll();

	}
	/*
	 * To fill details on the Question page
	 */

	@Test(priority = 4)
	public void TCSPR090704() {

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
		type(QP.max_scorbx, "3");

		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");

		click(QP.toasterclosebtn);
		waitThread(2000);
		
		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");
		waitThread(2000);
		
		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	/*
	 * To verify the course name assessment name, labels, text boxes on the
	 * peerreview page
	 */
	@Test(priority = 5)
	public void TCSPR090705() {

		waitThread(3000);

		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		waitThread(2000);
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName));

		// Assert the tooltips
		MouseHover(pr.PRassessmentname_lbl);

		// *Assert-Assessment Name
		waitThread(1000);
		Assert.assertTrue(getText(pr.assessmentname_tooltip).contains(AssessmentName));

		// Assert the tooltips
		MouseHover(pr.PRcoursename_lbl);

		// *Assert CourseName:
		waitThread(1000);
		Assert.assertTrue(getText(pr.course_tooltip).contains(CourseID + ", " + CourseName));

		// Assert the Answer Sheets Per Student drop down is disabled
		Assert.assertFalse(isElementPresent(pr.anssheetperstu_drp), "Answer Sheets Per Student dropdown is enabled");

		// Assert the Peer Review Reward percentage text box is disabled
		Assert.assertFalse(isEnabled(pr.PRreward_txtbox), "Peer Review Reward Scoretextbox is enabled");
		// Peer review reward percentage
		Assert.assertEquals(getText(pr.lbl_rewardpercent).trim(), "Peer review reward percentage");
	}

	/*
	 * To verify the grid texts and labels on the peer review page
	 */
	@Test(priority = 6)
	public void TCSPR090706() {

		// Assert the text::Total Students : Assert the total student count is 0
		waitThread(3000);
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 0");

		// Assert info text 'Peer students name will be hide and will displayed
		// "anonymous" for the other Students'
		// Assert.assertEquals(getText(pr.infotext_lbl).trim(),
		// "Actual student names will be hidden from the reviewer and each
		// student will be reviewed anonymously.");

		// *Assert text 'A minimum of 2 students are required to perform Peer
		// Review'
		// Assert.assertEquals(getText(pr.minimumstudent_lbl).trim(),
		// "This course does not have any students in its roster. A minimum of 2
		// students are required to perform Peer Review");

		// Assert the grid lables::
		Assert.assertEquals(getText(pr.SN_gridlbl).trim(), "SN");
		Assert.assertEquals(getText(pr.Peerreviewer_gridlbl).trim(), "Peer Reviewer");
		Assert.assertEquals(getText(pr.anstobeassign_gridlbl).trim(),
				"Answer sheets to be assigned to the Peer Reviewer");
		Assert.assertEquals(getText(pr.Noreviewer_gridlbl).trim(), "No Reviewer(s) Found");

		// Assert the Discard,Save&Exit,Save&Next buttons and button labels:
		Assert.assertTrue(isElementPresent(pr.discard_button), "Button not present");
		Assert.assertTrue(isElementPresent(pr.savenexit_button), "Button not present");

		Assert.assertTrue(isElementPresent(pr.savennext_button), "Button not present");
		Assert.assertEquals(getText(pr.discard_button).trim(), "Discard");

		Assert.assertEquals(getText(pr.savenexit_button).trim(), "Save & Exit");
		Assert.assertEquals(getText(pr.savennext_button).trim(), "Save & Next");

	}
	/*
	 * To check the discard button functionality on the peer review page
	 */

	@Test(priority = 7)
	public void TCSPR090707() {

		// Click on discard button
		click(ba.btndiscard);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(pr.discardpopup), "Confirmation Popup not visible");
		// Popuptext:Are you certain you want to proceed with your action?We see
		// that you have not made any changes to the information on this screen
		Assert.assertEquals(getText(pr.discardpopuptext), "Are you certain you want to proceed with your action?\n"
				+ "We see that you have not made any changes to the information on this screen");

		waitThread(1000);
		// click on Discard Yes button
		click(pr.discardyes);
		waitThread(2000);
		// verify the confirmation popup not visible
		Assert.assertFalse(isElementPresent(pr.discardpopup), "Confirmation Popup  visible");
		// verify heading Assessments
		Assert.assertEquals(getText(ba.lbl_assessment), "Assessments");
		// verify current tab is selected
		Assert.assertTrue(getAttribute(pr.tab_current, "class").contains("p-highlight"));
		// verify assessment tab is selected
		Assert.assertTrue(getAttribute(pr.tab_Assessment, "class").contains("active"));
		// click on draft tab
		click(pr.draft_tab);
		waitThread(3000);
		// verify current tab is selected
		Assert.assertTrue(getAttribute(pr.draft_tab, "class").contains("p-highlight"));
		waitThread(2000);
		// Assert the assessment name on the grid
		Assert.assertEquals(getText(pr.draftassessname_lbl).trim(), AssessmentName);

		// verify the Question count
		waitThread(2000);
		Assert.assertEquals(getText(pr.Questioncount).trim(), "1");
		String date1 = pr.getdate();
		
		// Assert the created on date same as system date
		waitThread(2000);
		Assert.assertTrue(getText(pr.draftcreatdatelbl).trim().contains(date1.trim()));

		// Assert the last modified date same as system date
		waitThread(2000);
		Assert.assertTrue(getText(pr.draftmodifieddate_lbl).trim().contains(date1.trim()));

		// Click on continue edit button
		click(pr.continueedit_button);
		waitThread(3000);
		
		// Assert the basic details wizard is selected
		Assert.assertTrue(isEnabled(pr.basicdetails_wizard), "basic details wizard is not selected");

		// Click on save and next button
		click(pr.savennext_button);
		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.question_wizard), "peer review wizard is not selected");

		// Click on save and next button
		click(pr.savennext_button);
		waitThread(1000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is not selected");

	}
	/*
	 * To check the save and exit button functionality on the peer review page
	 */

	@Test(priority = 8)
	public void TCSPR090708() {

		// Click on save and next button
		click(pr.savenexit_button);
		waitThread(1000);
		// To verify the draft tab is selected
		Assert.assertEquals(getAttribute(ba.tabdraftselected, "aria-selected"), "true");
		// *Assert the assessment name on the grid
		Assert.assertEquals(getText(pr.draftassessname_lbl).trim(), AssessmentName);

		// click continue edit button
		click(pr.continueedit_button);
		waitThread(1000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.basicdetails_wizard), "peer review wizard is not selected");

		// Click on save and next button
		click(pr.savennext_button);
		waitThread(1000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.question_wizard), "peer review wizard is not selected");

		// Click on save and next button
		click(pr.savennext_button);
		waitThread(1000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

	}
	/*
	 * Assert toaster::A minimum of 2 students are required to perform Peer
	 * Review
	 */

	@Test(priority = 9)
	public void TCSPR090709() {

		// Click on save and next button
		click(pr.savennext_button);
		waitThread(1000);
		waitFor(pr.PRsavenext_toaster);
		//
		Assert.assertEquals(getText(pr.PRsavenext_toaster),
				"Warning\n" + "This course does not have any students in its roster. A minimum of 2 students \n"
						+ " are required to perform Peer Review");

	}

	/*
	 * To verify the updated assessment name visible on the peer review page
	 */
	@Test(priority = 10)
	public void TCSPR090710() {

		// Click on the basic details wizard
		click(pr.basicdetails_wizard);

		waitThread(2000);
		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.basicdetails_wizard), "peer review wizard is not selected");

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(pr.question_wizard2, "aria-selected"), "false");

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(pr.peerrev_wizard2, "aria-selected"), "false");

		// click assessment name field
		click(QP.Assess_name);
		driver.findElement(By.xpath(pr.Assessmentbox)).clear();

		// Type Assessment Name

		NewAssessmentName = "NewAssessment" + generateRandomNumber().trim();

		type(QP.Assess_name, NewAssessmentName);
		waitThread(2000);
		// Click on save and next button
		click(pr.savennext_button);
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);
		waitThread(3000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.question_wizard), "Question wizard is not selected");

		// Click on save and next button
		click(pr.savennext_button);

		waitThread(2000);
		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is not selected");

		// Click on save and next button
		click(pr.savenexit_button);
		waitThread(2000);

		// Assert the tab name:Draft
		waitFor(pr.draft_lbl);
		Assert.assertEquals(getText(pr.draft_lbl).trim(), "Draft");
		Assert.assertEquals(getAttribute(ba.tabdraftselected, "aria-selected"), "true");

	}

	/*
	 * To edit the course name and check that updated course name visible on the
	 * peer review page
	 */
	@Test(priority = 11)
	public void TCSPR090711() {

		// click on course tab
		click(ba.CourseTab);

		waitThread(2000);

		// click on details button dropdown
		click(cn.btn_details_1);

		waitThread(3000);

		// link texts
		Assert.assertEquals(getText(cn.link_lbl_1), "View/Modify Course Details");

		// click on View/Modify Course Details button
		click(ec.btn_coursedetails);
		waitThread(3000);

		// Course Details-Heading
		Assert.assertEquals(getText(ec.heading_coursedetails), "Course Details");

		// Verify the course code
		waitThread(3000);
		Assert.assertEquals(getValue(cn.txbx_Coursetitle), CourseName.trim());

		NewCourseName = "New Course Name" + generateRandomNumber();

		// click on Edit button
		click(ec.btn_edit);
		waitThread(1000);

		// type-Course title
		type(cn.txbx_Coursetitle, NewCourseName);

		// click on save changes button
		waitThread(1000);
		click(ec.btnsave);
		waitThread(1000);

		// Verify the toaster message
		Assert.assertEquals(getText(ec.toaster), "Course details updated successfully");

	}

	/*
	 * To check the updated course name visible on the peer review page
	 */
	@Test(priority = 12)
	public void TCSPR090712() {

		// click on Assessment tab
		click(ba.Assessmenttab);

		waitThread(2000);

		// click draft tab
		click(pr.draft_tab);
		waitThread(2000);

		// Assert heading draft
		Assert.assertEquals(getText(pr.draft_lbl).trim(), "Draft");

		// Assert the updated course name visible on the draft page
		waitFor(pr.draftcoursename_lbl);
		Assert.assertEquals(getText(pr.draftcoursename_lbl).trim(), NewCourseName.trim());

		click(pr.continueedit_button);
		waitThread(2000);

		// Assert the basic details wizard is selected
		Assert.assertTrue(isEnabled(pr.basicdetails_wizard), "basic details wizard is not selected");

		click(pr.savennext_button);
		waitThread(2000);

		// Assert the question wizard is selected
		Assert.assertTrue(isEnabled(pr.question_wizard), "Question wizard is not selected");
		click(pr.savennext_button);

		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is not selected");

		// Assert the updated course name visible on the draft page
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(NewCourseName.trim()));

	}

	/*
	 * To create a new course on the page
	 */
	@Test(priority = 18)
	public void TCSPR090713() {

		// click on course tab
		click(ba.CourseTab);

		CourseNamenew = "Course Namenew" + generateRandomNumber().trim();

		// Assert button create new course
		Assert.assertTrue(isElementPresent(cn.btn_createnew), "Button not present");

		// Click on create new course button
		click(cn.btn_createnew);
		waitThread(2000);

		// type-Course title
		type(cn.txbx_Coursetitle, CourseNamenew);

		waitThread(1000);
		waitFor(cn.btn_Createcourse);

		// click on create course button
		click(cn.btn_Createcourse);

		waitFor(cn.toaster);

		// verify toaster-Course created successfully
		Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");
		waitThread(3000);

		// verify the course title
		// Assert.assertEquals(getText(pr.value_coursetitle).trim(),
		// CourseNamenew.trim());

		// // click on Assessment tab
		// click(ba.Assessmenttab);
		// waitThread(2000);
		//
		// // click draft tab
		// click(pr.draft_tab);
		// waitThread(1000);
		//
		// // Assert heading tab name draft
		// Assert.assertEquals(getText(pr.draft_lbl).trim(), "Draft");
		//
		// // Assert the assessment name visible on the page
		// Assert.assertEquals(getText(pr.draftassessname_lbl).trim(),
		// NewAssessmentName);

	}

	/*
	 * To change the course from basic details page and check that it updating
	 * on the peer review page
	 */
	@Test(priority = 14)
	public void TCSPR090714() {
		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(2000);

		// click draft tab
		click(pr.draft_tab);
		waitThread(1000);
		// Click on continue edit button
		click(pr.continueedit_button);
		waitThread(2000);

		// Assert the basic detals wizard is selected
		Assert.assertTrue(isEnabled(pr.basicdetails_wizard), "basic details wizard is not selected");

		// Click on save and next button
		click(pr.savennext_button);
		waitThread(2000);

		// Assert the question wizard is selected
		Assert.assertTrue(isEnabled(pr.question_wizard), "question wizard is not selected");

		// Click on save and next button
		click(pr.savennext_button);
		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is not selected");

		// Click on basic details wizard
		click(pr.basicdetails_wizard);

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(pr.course_drp3);

		// verify the course title
		Assert.assertEquals(getText(pr.course_drp3).trim(), NewCourseName.trim());

	}

	/*
	 * To change the course from basic details page and check that it updating
	 * on the peer review page
	 */
	@Test(priority = 15)
	public void TCSPR090715() {

		// Click on save &next button
		click(pr.savennext_button);

		waitThread(1000);

		// Assert the question wizard is selected
		Assert.assertTrue(isEnabled(pr.question_wizard), "peer review wizard is not selected");

		// Click on save &next button
		click(pr.savennext_button);

		waitThread(3000);
		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is not selected");

		// Assert the newly selected course name visible on the page
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(NewCourseName.trim()));

	}

	/*
	 * To check that the assessment tab and course tab functionality from peer
	 * review page
	 */
	@Test(priority = 16)
	public void TCSPR090716() {

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(2000);

		// click draft tab
		click(pr.draft_tab);
		waitThread(1000);

		// Assert tab heading draft
		Assert.assertEquals(getText(pr.draft_lbl).trim(), "Draft");

		// Click on continue edit button
		click(pr.continueedit_button);
		waitThread(1000);

		// Click on save and next button
		click(pr.savennext_button);

		// Assert the question wizard is selected
		Assert.assertTrue(isEnabled(pr.question_wizard), "question wizard is not selected");

		// Click on save and next button
		click(pr.savennext_button);
		waitThread(1000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is not selected");

		// click on course tab
		click(ba.CourseTab);
		waitThread(2000);

		// verify heading courses-landing page
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(1000);

		// Assert tab heading draft
		Assert.assertEquals(getText(pr.draft_lbl).trim(), "Draft");

	}

	/*
	 * To check that the invalid toaster visibility when try to delete course
	 */
	@Test(priority = 17)
	public void TCSPR090717() {

		// click on course tab
		click(ba.CourseTab);
		waitThread(2000);

		// click on details drop down button
		click(ec.Details_drop);

		waitThread(1000);
		waitFor(pr.btn_deletee);

		// click on delete button
		click(pr.btn_deletee);
		waitThread(3000);

		// verify the confirmation pop up visible
		Assert.assertTrue(isElementPresent(ec.confm_popup), "Confirmation popup not visible");

		// click on Yes button
		click(ec.delete_yes);
		waitFor(cn.toaster);

		// verify toaster message-Course deleted successfully
		Assert.assertEquals(getText(cn.toaster),
				"The course" + " " + "\"" + NewCourseName.trim() + "\"" + " has been successfully deleted.");

	}

	/*
	 * To check that after delete active assessment then delete that course name
	 */
	@Test(priority = 19)
	public void TCSPR090718() {

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(2000);

		// click draft tab
		click(pr.draft_tab);

		// Assert the assessment name
		Assert.assertFalse(isElementPresent(pr.draftassessname_lbl), "Assessment name not present");
		waitThread(1000);

		// Assert the assessment name not visible on the grid
		Assert.assertEquals(getText(pr.draftnoassess_lbl).trim(), "No Assessment(s) Found.");
	}

	/*
	 * To perform delete course functionality
	 */
	// @Test(priority = 19)
	public void TCSPR090719() {

		// click on course tab
		click(ba.CourseTab);
		waitThread(2000);

		// click on details drop down button
		click(ec.Details_drop1);

		waitThread(2000);

		// click on delete button
		click(pr.btn_deletee);

		waitThread(2000);
		// verify the confirmation pop up visible
		Assert.assertTrue(isElementPresent(ec.confm_popup), "Confirmation popup not visible");

		// click on Yes button
		click(ec.delete_yes);

		waitFor(cn.toaster);

		// verify toaster message-Course deleted successfully
		Assert.assertEquals(getText(cn.toaster), "Course deleted successfully");
		click(QP.toasterclosebtn);
		waitThread(2000);

	}

	/*
	 * To perform Account delete functionality and perform login using deleted
	 * account credentials
	 */
	@Test(priority = 20)
	public void TCSPR090720() {

		// To perform delete account functionality
		be.DeleteAccount();

		// To login with deleted account credentials
		lg.login(Emailteacher, "Abc@123");

		waitFor(lg.validationmsg3);

		// verify toaster text
		Assert.assertEquals(getText(lg.validationmsg3), "Enter a valid email address and password");

	}
}