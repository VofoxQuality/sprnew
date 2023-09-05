package NewAssessmentOfTeacherTest;

import java.util.concurrent.TimeUnit;

import org.jsoup.select.Evaluator.ContainsText;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import Course.Pages.EditCoursePage;
import CreateNewAssessment.Pages.AssessmentPublishPopupPage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CurrentAssessmentsforStudents.Pages.StudentTestSectionPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import NewAssessmentOfTeacherPage.TeacherResultSectionPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class TeacherResultSectionTest extends basePage {

	SignUpPage sp = new SignUpPage();
	LoginPage lg = new LoginPage();
	SignUpTest st = new SignUpTest();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	Databaseconnection dc = new Databaseconnection();
	CourseRosterPage cr = new CourseRosterPage();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	EncryptedText et = new EncryptedText();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	SchedulePageBasicsPage sb = new SchedulePageBasicsPage();
	AssessmentPublishPopupPage ap = new AssessmentPublishPopupPage();
	TeacherPeerReviewSectionPage tp = new TeacherPeerReviewSectionPage();
	TeacherResultSectionPage tr = new TeacherResultSectionPage();
	CommonMethods cm = new CommonMethods();
	StudentTestSectionPage st1 = new StudentTestSectionPage();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();

	public String AssessmentName;
	public String NewAssessmentName;
	public String newAssessmentName;
	public String newAssessmentNameone;

	public String Emailteacher;
	public String teacherotp;
	public String studentotp;
	public String CourseNamenew;
	public String CourseID1;

	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	/*
	 * To perform Login functionality
	 */
	@Test(priority = 1)
	public void TCSPR1000401() {

		click(lg.LoginBtn_1);

		cm.login(cm.emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	public String CourseID = cm.CourseID1;
	public String CourseName = cm.CourseName1;

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */
	@Test(priority = 2)
	public void TCSPR1000402() {

		SoftAssert softAssert1 = new SoftAssert();
		// click on Assessment tab
		click(ba.Assessmenttab);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");
waitThread(7000);
		waitThread(2000);
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
		waitThread(2000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(3000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), AssessmentName);

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID + ", " + CourseName.trim());

		softAssert1.assertAll();

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 3)
	public void TCSPR1000403() {

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

		// Click rubric drop down
		click(QP.rubric_drp_btn);
		waitThread(3000);

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

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

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	/*
	 * To verify the details on the peer review page
	 */
	@Test(priority = 4)
	public void TCSPR1000404() {

		waitThread(3000);

		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 4");

	}

	public String resultpublishdate;
	public String resultpublishtime;
	public String lastdateforrecon;
	public String lasttimeforrecon;
	/*
	 * To perform the save and next functionaity from peer review page and verify
	 * the schedule page details[Read the result publish date and time]
	 */

	@Test(priority = 5)
	public void TCSPR1000405() {

		// Type peer review reward score
		type(pr.PRreward_txtbox, "100");

		click(pr.savennext_button);
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);

		waitThread(3000);
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");

		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.Sbassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseName.trim()));

	}

	/*
	 * To perform Assessment publish functionality and check the details on the
	 * publish popup
	 */
	@Test(priority = 6)
	public void TCSPR1000406() {

		// Read the dates and time

		Scroll_DowntoEnd();
		waitThread(1000);
		resultpublishdate = getValue(sb.resultpublishdate_txtbx);
		resultpublishtime = getValue(sb.resultpublishtime_txtbx);

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		click(pr.savennext_button);
		waitThread(3000);

		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");
		waitThread(2000);

	}

	/*
	 * To perform Assessment publish functionality and check the details on the
	 * publish popup
	 */
	@Test(priority = 7)
	public void TCSPR1000407() {

		// click release button
		click(ap.relese_btn);
		waitFor(QP.toaster);

		// Assert the toaster "Assessment published successfully "
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");

		click(QP.toasterclosebtn);

		// Assert the popup visible
		Assert.assertTrue(isElementPresent(ap.publish_popup), "popup not visible");

		// Assert toaster "Assessment published successfully
		Assert.assertEquals(getText(ap.Assessmentcreated_lbl), "Assessment Created Successfully");

		// Assert button Back to Menu
		Assert.assertTrue(isElementPresent(ap.Backtomenu_btn), "button not visible");

	}

	/*
	 * To check the back to menu button functionality and check the created
	 * assessment visible on the current assessment tab
	 */
	@Test(priority = 8)
	public void TCSPR1000408() {

		// Click on Back to menu button
		click(ap.Backtomenu_btn);

		waitThread(2000);

		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(ap.publish_popup), "popup not visible");

		// Assert the Current Assessment is selected
		Assert.assertEquals(getAttribute(ap.currentassess_tab, "aria-selected"), "true");

		// search newly created assessment
		type(tr.search_box, AssessmentName);
		waitThread(1000);

		// Assert the newly published card visible on the current assessment page
		Assert.assertTrue(isElementPresent(tr.newcard), " new assessment card not visible");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(tr.newasses_lbl), AssessmentName);
		Assert.assertTrue(getText(tr.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(tr.course_lbl).contains(CourseID));

	}

	public String timetext;

	/*
	 * To verify the Result section on the assessment card check the labels
	 */
	@Test(priority = 9)
	public void TCSPR1000409() throws InterruptedException {

		ScrollTo_xy_position(0, 250);
		waitThread(1000);
		TimeUnit.SECONDS.sleep(15);

		// Assert the Test status Active
		Assert.assertEquals(getText(tr.teststs_lbl), "Active");

		// Assert the Peer Review status is pending
		Assert.assertEquals(getText(tr.peersts_lbl), "Pending");

		// Assert the Result status is pending
		Assert.assertEquals(getText(tr.resultsts_lbl), "Pending");

		// Assert the timer visible on the card
		Assert.assertTrue(getText(tp.timer).contains("Test active for"), "Timer not visible on card");

	}

	/*
	 * To verify the Result section on the assessment card check the date and time
	 */
	@Test(priority = 10)
	public void TCSPR1000410() {

		// Assert Label Result
		Assert.assertEquals(getText(tr.result_lbl), "Result");

		// Assert the view details button is in disabled state
		Assert.assertEquals(getAttribute(tr.evaluateans_btn, "disabled"), "true");

		// Assert label "Result publishing on:"
		Assert.assertTrue(getText(tr.resultpublishdate_lbl).contains("Result Publishing on"));

		// Assert the Result publish date and time
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.resultdate), resultpublishdate);
		Assert.assertEquals(cm.resultime, resultpublishtime);

	}

	public String resultpublishdate1;
	public String resultpublishtime1;

	/*
	 * To reschedule the assessment date & time and make result section active
	 */
	@Test(priority = 11)
	public void TCSPR1000411() throws InterruptedException {

		waitThread(2000);
		// click menu button
		click(rd.threedot_btn);

		waitThread(1000);
		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(2000);

		// assert popup
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");

		waitThread(2000);
		// Set the Assessment due date to current day
		Doubleclick(rd.assessmentduedate_txtbx);
		waitThread(2000);
		//cm.ClickTodaysDate();
		Doubleclick(pr.calanderdate_val);
		waitThread(2000);
		// Set the Peer Review open date to current day
		Doubleclick(rd.peerreviewopendate_txtbx);

		waitThread(2000);
		//cm.ClickTodaysDate();
		Doubleclick(pr.calanderdate_val);
		
		waitThread(2000);

		// Set the Peer Review due date to current day
		//waitThread(2000);
		Doubleclick(rd.peerreviewduedate_txtbx);

		waitThread(3000);
		cm.ClickTodaysDate();
		//Doubleclick(pr.calanderdate_val);
		waitThread(2000);
		// Set the Result publishing to current day
		Doubleclick(rd.resultpublishdate_txtbx);

		waitThread(3000);
		cm.ClickTodaysDate();
		//Doubleclick(pr.calanderdate_val);
		
		waitThread(2000);

		resultpublishdate1 = getValue(rd.resultpublishdate_txtbx);
		resultpublishtime1 = getValue(rd.resultpublishtime_txtbx);

		waitThread(2000);
		// Click Apply Changes button
		click(rd.applychanges_btn);
		waitThread(2000);
		waitFor(QP.toaster);
		// Assert toaster "Changes applied"
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		waitThread(4000);

		// search newly created assessment
		Doubleclick(rd.search_box);
		type(rd.search_box, AssessmentName);
		
		waitThread(2000);

		// Assert the assessment card visible
		Assert.assertTrue(isElementPresent(tr.newcard), " new assessment card not visible");
		
		TimeUnit.SECONDS.sleep(25);
		
		waitThread(2000);
		// Assert result date time with reschedule page
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.resultdate), resultpublishdate1);
		Assert.assertEquals(cm.resultime, resultpublishtime1);
			
		// Wait 10 mins to active result section
		TimeUnit.MINUTES.sleep(13);
		
		driver.navigate().refresh();
		
		waitThread(3000);
		// search newly created assessment
		Doubleclick(rd.search_box);
		type(rd.search_box, AssessmentName);
		
		waitThread(3000);

	}

	/*
	 * To check the Result active section of assessment card
	 */
	@Test(priority = 12)
	public void TCSPR1000412() {

		waitThread(4000);
		
		// Assert result active
		Assert.assertEquals(getText(tr.resultsts_lbl), "Active");

		// Assert View Result button enabled
		Assert.assertTrue(isEnabled(tr.evaluateans_btn), "Button is not enabled");

		// Assert the card status "Result Available "
		Assert.assertTrue(getText(tp.timer).contains("Result Available"), "Text not visible on card");

		

	}

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */
	@Test(priority = 13)
	public void TCSPR1000413() {

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		SoftAssert softAssert2 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		waitThread(2000);
		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		softAssert2.assertEquals(getText(ba.ddcoursename1), CourseName.trim(),
				"course name not visible on the dropdown");

		click(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		NewAssessmentName = "NewAssessment" + generateRandomNumber().trim();

		type(QP.Assess_name, NewAssessmentName);

		waitThread(1000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(1000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(3000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), NewAssessmentName);

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID + ", " + CourseName.trim());

		softAssert2.assertAll();

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 14)
	public void TCSPR1000414() {

		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question2");

		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);

		// Click rubric drop down
		click(QP.rubric_drp_btn);
		waitThread(3000);

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

		// Enter Max score
		type(QP.max_scorbx, "3");

		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");

		click(QP.toasterclosebtn);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	/*
	 * To verify the details on the peer review page
	 */
	@Test(priority = 15)
	public void TCSPR1000415() {

		waitThread(2000);

		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + NewAssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 4");

	}

	/*
	 * To perform the save and next functionaity from peer review pageand verify the
	 * schedule page details[Read the result publish
	 */
	public String recons_time;

	@Test(priority = 16)
	public void TCSPR1000416() {

		// Type peer review reward score
		type(pr.PRreward_txtbox, "100");

		click(pr.savennext_button);

		waitThread(2000);
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");

		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.Sbassessmentname_lbl).contains("Assessment Name: " + NewAssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseName.trim()));
		ScrollTo_xy_position(0, 300);

		Assert.assertTrue(isElementPresent(sb.teacherwill_radio), "radio button is present");

		waitThread(5000);
		// Click on Teacher will manually publish the result
		Doubleclick(sb.teacherwill_radio);

		waitThread(4000);
		// Assert the Teacher will manually publish the result radio button is selected
		Assert.assertTrue(isEnabled(sb.teachwill_radio_select),
				"Teacher will manually publish the result radio button not selected");

		// Click Allow ResConsideration checkbox
		click(sb.allowstu_checkbx2);

		// Assert the check box is checked
		Assert.assertTrue(getAttribute(sb.allowstu_checkbx2, "class").contains("highlight"));

		// Read the dates and time of reconsideration request
		Assert.assertTrue(isElementPresent(sb.lasttime_select_bx), "Time textbox not visible");
		recons_time = getValue(sb.lasttime_select_bx);

	}

	/*
	 * To perform Assessment publish functionality and check the details on the
	 * publish popup
	 */
	@Test(priority = 17)
	public void TCSPR1000417() {

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		click(pr.savennext_button);
		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);

		waitThread(2000);

		// Assert the label assessment name,
		click(ap.relese_btn);
		waitFor(QP.toaster);

		// Assert the toaster " Assessment published successfully"
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");

		click(QP.toasterclosebtn);

		// Assert the popup visible
		Assert.assertTrue(isElementPresent(ap.publish_popup), "popup not visible");

		Assert.assertEquals(getText(ap.Assessmentcreated_lbl), "Assessment Created Successfully");

		// Assert button Back to Menu
		Assert.assertTrue(isElementPresent(ap.Backtomenu_btn), "button not visible");

	}

	/*
	 * To check the back to menu button functionality and check the created
	 * assessment visible on the current assessment tab
	 */
	@Test(priority = 18)
	public void TCSPR1000418() {

		// Click on Back to menu button
		click(ap.Backtomenu_btn);

		waitThread(2000);

		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(ap.publish_popup), "popup not visible");

		// Assert the Current Assessment is selected
		Assert.assertEquals(getAttribute(ap.currentassess_tab, "aria-selected"), "true");

		// search newlycreated assessment name
		type(tr.search_box, NewAssessmentName);
		waitThread(1000);

		// Assert the newly published card visible on the current assessment page
		Assert.assertTrue(isElementPresent(tr.newcard), " new assessment card not visible");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(tr.newasses_lbl), NewAssessmentName);
		Assert.assertTrue(getText(tr.course_lbl).contains(CourseName));
		Assert.assertTrue(getText(tr.course_lbl).contains(CourseID));

	}

	/*
	 * To verify the Result section on the assessment card check the labels& To
	 * verify the Result section on the assessment card check the date and time
	 */
	@Test(priority = 19)
	public void TCSPR1000419() {

		// Assert the Result status is pending
		Assert.assertEquals(getText(tr.resultsts_lbl), "Pending");

		// Assert the view details button is in disabled state
		Assert.assertEquals(getAttribute(tr.evaluateans_btn, "disabled"), "true");

		// Assert text "You need to manually publish the result"
		Assert.assertEquals(getText(rd.manualpublishcard_txt), "You need to manually publish the result");

		// *Assert the Last Date for Reconsideration date and time not visible
		Assert.assertFalse(isElementPresent(tr.lastdate_lbl), "Last Date for Reconsideration not visible");

	}

	/*
	 * To perform log out functionality
	 */
	@Test(priority = 20)
	public void TCSPR1000420() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}
}
