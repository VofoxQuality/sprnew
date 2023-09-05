package CreateNewAssessment.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import Course.Pages.EditCoursePage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.BasicDetailsPageCourseandEditorPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class SummaryBasicsTest extends basePage {

	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	CourseRosterPage cr = new CourseRosterPage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	EncryptedText et = new EncryptedText();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	EditCoursePage ec = new EditCoursePage();
	BasicDetailsAssessmentTest bdt = new BasicDetailsAssessmentTest();
	BasicDetailsPageCourseandEditorPage be = new BasicDetailsPageCourseandEditorPage();
	SummaryBasicsPage sb = new SummaryBasicsPage();
	CommonMethods cm = new CommonMethods();
	SchedulePageBasicsPage spbp = new SchedulePageBasicsPage();

	public String Emailteacher;
	public String CourseName;
	public String NewCourseTitle;
	public String CourseID;
	public String AssessmentName;
	public String Emailstudent1;
	public String Emailstudent2;
	public String Emailstudent3;
	public String Emailstudent4;
	public String Student1firstname;
	public String Student1lastname;
	public String Student1name;
	public String Student2firstname;
	public String Student2lastname;
	public String Student2name;
	public String Student3firstname;
	public String Student3lastname;
	public String Student3name;
	public String Student4firstname;
	public String Student4lastname;
	public String Student4name;

	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	/*
	 * To perform Sign Up functionality
	 */
	@Test(priority = 0)
	public void TCSPR0901201() {

		// To click on I am A teacher button
		click(sp.btn_1);

		// To fill the details on the sign up page
		Emailteacher = st.TCSPR020005();

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
	public void TCSPR0901202() throws SQLException {

		CourseName = "Course Name" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID = (getText(cn.course_Id));
		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";

		// Invite students to course
		cm.Invitestudentstocourse(CourseName, Emailstudent1, Emailstudent2);

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 3)
	public void TCSPR0901203() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on first student 's profile
	 * and accept course request-Read the student name
	 */
	@Test(priority = 4)
	public void TCSPR0901204() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent1, CourseID);
		String encText = et.EncryptCode(studentinviteid);

		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Student1firstname = "Ashley";
		Student1lastname = "Albert";
		Student1name = Student1firstname + " " + Student1lastname;

		// click first name
		click(sp.txtbxFirstN);
		waitThread(1000);
		// type first name
		type(sp.txtbxFirstN, Student1firstname);
		waitThread(1000);
		// click last name
		click(sp.txtbxLastN);
		waitThread(1000);
		// type last name
		type(sp.txtbxLastN, Student1lastname);
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

	@Test(priority = 5)
	public void TCSPR0901205() {

		// click on accept course button
		click(rs.btn_acceptcourse);
		waitThread(2000);

		// verify the confirmation popup visible
		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");

		waitThread(1000);
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
	@Test(priority = 6)
	public void TCSPR0901206() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent2, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Student2firstname = "Ben";
		Student2lastname = "Alex";
		Student2name = Student2firstname + " " + Student2lastname;

		// click first name
		click(sp.txtbxFirstN);
		waitThread(1000);
		// type first name
		type(sp.txtbxFirstN, Student2firstname);
		waitThread(1000);
		// click last name
		click(sp.txtbxLastN);
		waitThread(1000);
		// type last name
		type(sp.txtbxLastN, Student2lastname);
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
	@Test(priority = 7)
	public void TCSPR0901207() {

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
	 * To load the create new assessment page and fill details on the basic
	 * details page
	 */
	@Test(priority = 8)
	public void TCSPR0901208() {

		SoftAssert softAssert1 = new SoftAssert();
		rs.login_Teacher(Emailteacher, password);

		// click on Assessment tab
		click(ba.Assessmenttab);

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
		Assert.assertEquals(getText(pr.QPassessname_lbl), AssessmentName.trim());

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID + ", " + CourseName.trim());

		softAssert1.assertAll();

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 9)
	public void TCSPR0901209() {

		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question1");

		driver.switchTo().defaultContent();

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
	 * To verify details on the peer review page
	 */
	@Test(priority = 10)
	public void TCSPR0901210() {

		waitThread(4000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));
		// Assert course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Assert the text::Total Students : Assert the total student count is 2
		waitThread(2000);
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");

		// Assert the student names
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Student1name.trim());
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Student2name.trim());

	}
	/*
	 * To verify details on the schedule page
	 */

	@Test(priority = 11)
	public void TCSPR0901211() {

		type(pr.PRreward_txtbox, "50");
		waitThread(3000);

		// Click Save&Next button
		click(QP.savenext_btn);
		waitThread(4000);

		// Assert the peer schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");
		waitThread(3000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.scheduleassessmentname).contains("Assessment Name: " + AssessmentName));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.schedulecoursename).contains(CourseID));
		Assert.assertTrue(getText(sb.schedulecoursename).contains(CourseName.trim()));

	}

	/*
	 * To verify details on the summary page
	 */

	@Test(priority = 12)
	public void TCSPR0901212() {

		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(5000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");

		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.summaryassessmentname).contains("Assessment Name: " + AssessmentName));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.summarycoursename).contains(CourseID));
		Assert.assertTrue(getText(sb.summarycoursename).contains(CourseName.trim()));

		// To verify buttons
		Assert.assertTrue(isElementPresent(sb.btnpreview), "Preview button not visible");
		Assert.assertTrue(isElementPresent(sb.btndiscard), "Discard button not visible");
		Assert.assertTrue(isElementPresent(sb.btnsaaveandexit), "Save and Exit button not visible");
		Assert.assertTrue(isElementPresent(sb.btnrelease), "Release button not visible");

	}
	/*
	 * To check the summary basic details edit button functionality,and check
	 * the Discard popup
	 */

	@Test(priority = 13)
	public void TCSPR0901213() {

		Assert.assertTrue(isElementPresent(sb.basicdetailseditbtn), "Basic details Edit button not visible");

		click(sb.basicdetailseditbtn);
		waitThread(1000);
		// To verify the wizard label is selected
		Assert.assertEquals(getAttribute(ba.Basicdetailswizard, "aria-selected"), "true");

		// click on discard button
		click(sb.btndiscard);
		// confirmation popup
		Assert.assertTrue(isElementPresent(be.Confirm_discardpopup), "Confirmation Popup not visible");
		waitFor(be.Confirm_lbl_confirmation);
		Assert.assertEquals(getText(be.Confirm_lbl_confirmation), "Confirmation");
		Assert.assertEquals(getText(be.Confirm_txtpopup), "Are you certain you want to proceed with your action?\n"
				+ "We see that you have not made any changes to the information on this screen");
		// Confirmation popup cancel button
		click(be.Confirm_btnNo);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(be.Confirm_discardpopup), "Confirmation Popup not visible");

		Assert.assertEquals(getText(sb.basicdetailscoursename), CourseName.trim());
		Assert.assertTrue(isElementPresent(sb.ddcourse), "The course name drodown is not disabled");
		Assert.assertTrue(isElementPresent(sb.btndiscard), "Discard button not visible");
		Assert.assertTrue(isElementPresent(sb.btnsaveandnext), "Save and next button not visible");

	}

	/*
	 * To check the validation messages on the basic details edit page
	 */
	@Test(priority = 14)
	public void TCSPR0901214() {

		driver.findElement(By.id("assessmentName")).clear();
		waitThread(1000);
		click(ba.Assessmenttxtbx);
		type(ba.Assessmenttxtbx, "s");
		driver.findElement(By.id("assessmentName")).sendKeys(Keys.BACK_SPACE);
		waitThread(1000);

		// Click on save and next button and verify the toasters
		click(ba.btnsaveandnext);
		Assert.assertEquals(getText(ba.valmsg2), "Assessment Name is required");
		waitFor(ba.toaster);
		Assert.assertEquals(getText(ba.toaster), "Please enter the Assessment Name");
		click(ba.toasterclosebtn);

	}
	/*
	 * To check the basic details edit page discard button functionality
	 */

	@Test(priority = 15)
	public void TCSPR0901215() {

		AssessmentName = "name" + generateRandomNumber();

		// Type assessment name
		waitThread(1000);

		type(ba.Assessmenttxtbx, AssessmentName.trim());

		// click on discard button
		click(sb.btndiscard);
		// confirmation popup
		Assert.assertTrue(isElementPresent(be.Confirm_discardpopup), "Confirmation Popup not visible");
		waitFor(be.Confirm_lbl_confirmation);
		// confirmation popup text
		Assert.assertEquals(getText(be.Confirm_lbl_confirmation), "Confirmation");
		Assert.assertEquals(getText(be.Confirm_txtpopup), "Are you sure you want to proceed with your action?\n"
				+ "We detected you have made changes to the information on this screen and if you ‘Discard’ these changes will not be saved.");
		// Confirmation popup no button
		click(be.Confirm_btnNo);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(be.Confirm_discardpopup), "Confirmation Popup not visible");

		// click on discard button
		click(sb.btndiscard);
		Assert.assertTrue(isElementPresent(be.Confirm_discardpopup), "Confirmation Popup not visible");
		// Confirmation popup Discard button
		click(be.Confirm_btnYes);
		waitThread(2000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");

	}

	public String NewAssessmentName;

	/*
	 * Perform basic details edit functionality and save with new assessment
	 * name
	 */
	@Test(priority = 16)
	public void TCSPR0901216() {

		waitThread(3000);
		// Basic details edit button
		click(sb.basicdetailseditbtn);

		// To verify the wizard label
		Assert.assertEquals(getText(ba.Wizardlbl_basicdetails), "Basic Details");

		// To verify the wizard label is selected
		Assert.assertEquals(getAttribute(ba.Basicdetailswizard, "aria-selected"), "true");

		// To save with new assessment name
		NewAssessmentName = "NewAssessmentname" + generateRandomNumber();
		click(ba.Assessmenttxtbx);
		waitThread(2000);

		// clear assessment name
		driver.findElement(By.id("assessmentName")).sendKeys(Keys.CONTROL, "a");
		waitThread(1000);
		driver.findElement(By.id("assessmentName")).sendKeys(Keys.BACK_SPACE);

		waitThread(2000);

		// Type new assessment name
		driver.findElement(By.id("assessmentName")).sendKeys(NewAssessmentName.trim());
		waitThread(3000);

		// Click on save and next button and verify the toasters
		click(ba.btnsaveandnext);
		waitFor(ba.toaster);
		Assert.assertEquals(getText(ba.toaster), "Saved successfully");
		click(ba.toasterclosebtn);
		waitThread(3000);

		// To verify the question page details
		Assert.assertEquals(getAttribute(sb.questionwizard, "aria-selected"), "true");

		// Assert the assessment name
		waitThread(3000);
		Assert.assertEquals(getText(pr.QPassessname_lbl), NewAssessmentName.trim());

		// To verify the peer review page details
		click(ba.btnsaveandnext);
		waitThread(2000);
		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");
		waitThread(3000);
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + NewAssessmentName.trim()));
		waitThread(2000);

		// To verify the schedule page details
		click(ba.btnsaveandnext);

		waitThread(3000);
		// Assert the peer schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");
		waitThread(3000);
		Assert.assertTrue(getText(sb.scheduleassessmentname).contains("Assessment Name: " + NewAssessmentName.trim()));
		waitThread(3000);

		click(spbp.assessmentopendate_txtbx);
		waitThread(3000);
		Doubleclick(spbp.calanderdate_val);
		waitThread(3000);

		// To verify the summary page details
		click(ba.btnsaveandnext);

		waitThread(5000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");
		waitThread(1000);
		Assert.assertTrue(getText(sb.summaryassessmentname).contains("Assessment Name: " + NewAssessmentName.trim()));

	}

	public String Assessmentname1;

	/*
	 * To perform the save and exit functionality and save with new assessment
	 * name
	 */
	@Test(priority = 17)
	public void TCSPR0901217() {

		waitThread(2000);
		// click save and exit functionality
		click(sb.btnsaaveandexit);
		waitFor(ba.toaster);
		Assert.assertEquals(getText(ba.toaster), "Saved successfully");
		waitThread(1000);
		// To verify Current Assessment tab is selected
		Assert.assertEquals(getAttribute(sb.tabcurrectassessment, "aria-selected"), "true");
		// click on draft tab and verify draft tab is selected
		click(sb.tabdraft);
		Assert.assertEquals(getAttribute(sb.tabdraftselected, "aria-selected"), "true");
		// Assert the course name and assessment name
		Assert.assertEquals(getText(ba.draftcoursename), CourseName.trim());
		Assert.assertEquals(getText(ba.draftassessmentname), NewAssessmentName.trim());
		// click on continue edit button
		click(ba.btn_continueedit);
		waitThread(1000);
		// To verify the wizard label is selected
		Assert.assertEquals(getAttribute(ba.Basicdetailswizard, "aria-selected"), "true");

		// Type new assessment name
		waitThread(1000);
		Assessmentname1 = "GK" + generateRandomNumber();

		click(ba.Assessmenttxtbx);
		waitThread(2000);

		// clear assessment name
		driver.findElement(By.id("assessmentName")).sendKeys(Keys.CONTROL, "a");
		waitThread(1000);
		driver.findElement(By.id("assessmentName")).sendKeys(Keys.BACK_SPACE);

		waitThread(2000);

		// Type new assessment name
		driver.findElement(By.id("assessmentName")).sendKeys(Assessmentname1.trim());
		waitThread(3000);

		// Click on save and next button and verify the toasters
		click(ba.btnsaveandnext);
		waitFor(ba.toaster);
		Assert.assertEquals(getText(ba.toaster), "Saved successfully");
		click(ba.toasterclosebtn);
		waitThread(4000);

		// To verify the question page details
		Assert.assertEquals(getAttribute(sb.questionwizard, "aria-selected"), "true");
		waitThread(4000);

		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), Assessmentname1.trim());
		waitThread(1000);

		// To verify the peer review page details
		click(ba.btnsaveandnext);
		waitThread(3000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");
		waitThread(5000);

		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + Assessmentname1.trim()));
		waitThread(1000);

		// To verify the schedule page details
		click(ba.btnsaveandnext);

		waitThread(3000);
		click(pr.assessmentopendate_txtbx);
		waitThread(1000);
		Doubleclick(pr.calanderdate_val);
		waitThread(3000);

		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");
		waitThread(1000);
		Assert.assertTrue(getText(sb.scheduleassessmentname).contains("Assessment Name: " + Assessmentname1.trim()));
		waitThread(2000);

		// To verify the summary page details
		click(ba.btnsaveandnext);
		waitThread(3000);

		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");
		waitThread(2000);
		Assert.assertTrue(getText(sb.summaryassessmentname).contains("Assessment Name: " + Assessmentname1.trim()));

		// Assert the Text "Questions Summary"
		// Assert.assertEquals(getText(sq.Summary_quest), "Questions Summary");

	}

	/*
	 * To perform discard functionality,check the Discard popup
	 */

	@Test(priority = 18)
	public void TCSPR0901218() {

		// click on Discard button
		waitThread(2000);
		click(sb.btndiscard);

		// confirmation popup,buttons labels
		waitThread(2000);
		Assert.assertTrue(isElementPresent(be.Confirm_discardpopup), "Confirmation Popup not visible");

		// verify the confirmation popup labels
		waitFor(be.Confirm_lbl_confirmation);
		Assert.assertEquals(getText(be.Confirm_lbl_confirmation), "Confirmation");
		Assert.assertEquals(getText(be.Confirm_txtpopup), "Are you certain you want to proceed with your action?\n"
				+ "We see that you have not made any changes to the information on this screen");
		Assert.assertEquals(getText(sb.discardbuttonlbl), "Discard");
		Assert.assertEquals(getText(sb.cancelbuttonlbl), "Cancel");

		// Confirmation popup cancel button
		click(be.Confirm_btnNo);

		waitThread(2000);
		Assert.assertFalse(isElementPresent(be.Confirm_discardpopup), "Confirmation Popup not visible");

		// Assert the summary wizard is selected
		waitThread(4000);
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");

		// click on discard button
		waitThread(2000);
		click(sb.btndiscard);

		// Confirmation popup cancel button
		waitThread(2000);
		click(be.Confirm_btnYes);

		// verify current tab is selected
		waitThread(4000);
		Assert.assertTrue(getAttribute(be.tab__draft, "class").contains("p-highlight"));
		waitThread(1000);

	}

	public String NewCourseName;
	public String NewCourseID;

	/*
	 * To create new course
	 */
	@Test(priority = 19)
	public void TCSPR0901219() {

		// Click on course tab
		click(ba.CourseTab);
		waitThread(2000);
		// To click on split button
		click(ec.splitbutton);

		// click on details button
		click(ec.btn_coursedetails);
		waitThread(2000);
		// click on Active button
		click(ec.active_btn);
		waitThread(2000);

		waitFor(ec.btnyes);
		// click on Yes button
		click(ec.btnyes);
		waitThread(3000);
		NewCourseName = "NewCourse Name" + generateRandomNumber();
		// click on course tab
		click(ba.CourseTab);
		waitThread(2000);
		// To verify the create new course button
		Assert.assertTrue(isElementPresent(cn.btn_createnew), "Create new course button not present");

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		NewCourseID = (getText(cn.course_Id));

		Emailstudent3 = "student3" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent4 = "student4" + generateRandomNumber().trim() + "@gmail.com";

		// Invite students to course
		cm.Invitestudentstocourse(NewCourseName, Emailstudent3, Emailstudent4);

	}

	/*
	 * perform logout functionality
	 */
	@Test(priority = 20)
	public void TCSPR0901220() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on 3rd student's profile and
	 * accept course request
	 */
	public String newstudentinviteid;

	@Test(priority = 21)
	public void TCSPR0901221() throws SQLException {

		newstudentinviteid = dc.InviteLink(Emailstudent3, NewCourseID);
		String encText = et.EncryptCode(newstudentinviteid);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Student3firstname = "Clara";
		Student3lastname = "April";
		Student3name = Student3firstname + " " + Student3lastname;

		// click first name
		click(sp.txtbxFirstN);
		waitThread(1000);
		// type first name
		type(sp.txtbxFirstN, Student3firstname);
		waitThread(1000);
		// click last name
		click(sp.txtbxLastN);
		waitThread(1000);
		// type last name
		type(sp.txtbxLastN, Student3lastname);
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
		waitThread(1000);
		// click signup button
		click(sp.btn_signup);

		waitThread(5000);

		// verify heading label
		waitFor(rs.lbl_joincourse);
		Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");

		// verify course name visible
		Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not Present");

		// verify the the course name
		Assert.assertEquals(getText(rs.course_name).trim(), NewCourseName.trim());

	}

	/*
	 * To Accept course and perform logout functionality on the student profile
	 */
	@Test(priority = 22)
	public void TCSPR0901222() {

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
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), NewCourseName.trim());
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}
	/*
	 * To check that invited course request visible on fourth student's profile
	 * and accept course request
	 */

	@Test(priority = 23)
	public void TCSPR0901223() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent4, NewCourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		// Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Student4firstname = "Eby";
		Student4lastname = "Thomas";
		Student4name = Student4firstname + " " + Student4lastname;

		// click first name
		click(sp.txtbxFirstN);
		waitThread(1000);
		// type first name
		type(sp.txtbxFirstN, Student4firstname);
		waitThread(1000);
		// click last name
		click(sp.txtbxLastN);
		waitThread(1000);
		// type last name
		type(sp.txtbxLastN, Student4lastname);
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
		Assert.assertEquals(getText(rs.course_name).trim(), NewCourseName.trim());

	}

	/*
	 * To Accept course and perform logout functionality on the student profile
	 */
	@Test(priority = 24)
	public void TCSPR0901224() {

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
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), NewCourseName.trim());
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	public String AssessmentNameTest;

	/*
	 * To create a new assessment
	 */
	@Test(priority = 25)
	public void TCSPR0901225() {

		rs.login_Teacher(Emailteacher, password);

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(2000);

		// click on create new assessment button
		click(ba.btn_createnewassessment);
		waitThread(3000);
		// To verify the wizard label
		Assert.assertEquals(getText(ba.Wizardlbl_basicdetails), "Basic Details");

		// To verify the wizard label is selected
		Assert.assertEquals(getAttribute(ba.Basicdetailswizard, "aria-selected"), "true");
		// To click on course dropdown
		click(ba.dd_course);
		// select latest added course
		click(ba.ddcoursename1);

		// Type new assessment name
		AssessmentNameTest = "Test" + "Assessment" + "Name" + generateRandomNumber();

		waitThread(2000);
		click(ba.Assessmenttxtbx);
		waitThread(2000);

		// Type assessment name
		driver.findElement(By.id("assessmentName")).sendKeys(AssessmentNameTest.trim());
		waitThread(2000);

		// Click on save and next button and verify the toasters
		click(ba.btnsaveandexit);
		waitFor(ba.toaster);
		Assert.assertEquals(getText(ba.toaster), "Saved successfully");
		click(ba.toasterclosebtn);
		waitThread(1000);
		Assert.assertEquals(getAttribute(sb.tabcurrectassessment, "aria-selected"), "true");

	}

	/*
	 * To take the assessment from draft and change the assessment name and
	 * check the other pages
	 */

	@Test(priority = 26)
	public void TCSPR0901226() {

		// click on draft tab
		click(sb.tabdraft);
		waitThread(3000);

		// verify the draft tab is selected and check the assesment name and

		// course name
		Assert.assertEquals(getAttribute(sb.tabdraftselected, "aria-selected"), "true");
		// Assert.assertEquals(getText(ba.draftcoursename),
		// NewCourseName.trim());
		// Assert.assertEquals(getText(ba.draftassessmentname),
		// AssessmentNameTest.trim());

		// click on create new assessment button
		click(ba.btn_createnewassessment);
		waitThread(3000);

		// To verify the wizard label
		Assert.assertEquals(getText(ba.Wizardlbl_basicdetails), "Basic Details", "Assertion  failed");

		// To verify the wizard label is selected
		Assert.assertEquals(getAttribute(ba.Basicdetailswizard, "aria-selected"), "true");

		// verify the course name

		// Assert.assertEquals(getText(sb.basicdetailscoursename1),
		// CourseName.trim());

		// To click on course dropdown
		click(ba.dd_course);
		waitThread(1000);

		// select latest added course
		click(ba.ddcoursename1);
		waitThread(2000);
		Assert.assertEquals(getText(sb.basicdetailscoursename1), NewCourseName.trim());
		waitThread(2000);

		// change Assessment name
		click(ba.Assessmenttxtbx);
		waitThread(2000);

		// clear old assessment name
		driver.findElement(By.id("assessmentName")).sendKeys(Keys.CONTROL, "a");
		waitThread(1000);
		driver.findElement(By.id("assessmentName")).sendKeys(Keys.BACK_SPACE);

		// Type a name
		driver.findElement(By.id("assessmentName")).sendKeys("dhfnisfe");
		waitThread(2000);

		// click on save and next button and verify toaster
		click(ba.btnsaveandnext);
		waitThread(3000);

		// To verify the question page details
		Assert.assertEquals(getAttribute(sb.questionwizard, "aria-selected"), "true");
		waitThread(4000);
		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question1");

		driver.switchTo().defaultContent();

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
		waitThread(2000);

		// To verify the peer review page details
		click(ba.btnsaveandnext);
		waitThread(4000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");
		waitThread(4000);
		// Enter Reward score
		type(pr.PRreward_txtbox, "50");
		waitThread(3000);

		// Assert course name
		// Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(NewCourseName.trim()));

		// To verify the schedule page details
		// Click Save&Next button
		click(QP.savenext_btn);
		waitThread(5000);

		// Select test start date as tomorrow's date
		click(pr.assessmentopendate_txtbx);
		waitThread(1000);
		Doubleclick(pr.calanderdate_val);
		waitThread(3000);

		// Assert the schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");
		
		// To verify the summary page details
		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);

		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");
		waitThread(1000);

	}

	/*
	 * To verify the validation messages on the basic details edit page while
	 * submit with already used assessment name
	 */
	@Test(priority = 27)
	public void TCSPR0901227() {

		SoftAssert as = new SoftAssert();
		// click on basic details edit button
		waitThread(2000);
		click(sb.basicdetailseditbtn);

		// To verify the wizard label
		waitThread(2000);
		Assert.assertEquals(getText(ba.Wizardlbl_basicdetails), "Basic Details", "Assertion  failed");

		// To verify the wizard label is selected
		Assert.assertEquals(getAttribute(ba.Basicdetailswizard, "aria-selected"), "true");

		// Type already used assessment name
		waitThread(2000);
		click(ba.Assessmenttxtbx);
		waitThread(1000);

		// Type assessment name
		driver.findElement(By.id("assessmentName")).sendKeys(Keys.CONTROL, "a");
		waitThread(1000);
		driver.findElement(By.id("assessmentName")).sendKeys(Keys.BACK_SPACE);

		// Type assessment name
		waitThread(2000);
		driver.findElement(By.id("assessmentName")).sendKeys(AssessmentNameTest.trim());
		driver.findElement(By.id("assessmentName")).sendKeys(" ");
		// To check the validation messages and toasters
		// waitFor(ba.valmsg3);
		waitThread(5000);
		as.assertEquals(getText(ba.valmsg3),
				"The assessment name of '" + AssessmentNameTest.trim() + "' already exists. Please enter a new name.",
				"The toaster text is not correct");
		waitThread(2000);
		// click on save and next button
		click(ba.btnsaveandnext);
		waitFor(ba.toaster);
		as.assertEquals(getText(ba.toaster),
				"The Assessment name of '" + AssessmentNameTest.trim() + "' already exists. Please enter a new name.",
				"The toaster text is not correct");
		click(sb.toasterclosebtn);
		as.assertAll();

	}

	/*
	 * To perform Delete TeacherAccount functionality
	 */
	@Test(priority = 28)
	public void TCSPR0901228() {

		click(ba.Assessmenttxtbx);
		waitThread(6000);

		// To perform discard functionality from basic details edit page
		click(sb.btndiscard);
		Assert.assertTrue(isElementPresent(be.Confirm_discardpopup), "Confirmation Popup not visible");
		// Confirmation popup yes button
		click(be.Confirm_btnYes);
		waitThread(2000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");
		waitThread(2000);

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted teacher profile credentials
	 */
	@Test(priority = 29)
	public void TCSPR0901229() {
		cr.DeleteAccount();
		// login using deleted account credentials
		lg.login(Emailteacher, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student1 Account functionality
	 */
	@Test(priority = 30)
	public void TCSPR0901230() {

		// login using deleted account credentials
		lg.login1(Emailstudent1, password);

		cr.DeleteAccount();

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 1 profile
	 * credentials
	 */
	@Test(priority = 31)
	public void TCSPR0901231() {

		// login using deleted account credentials
		lg.login(Emailstudent1, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student2 Account functionality
	 */
	@Test(priority = 32)
	public void TCSPR0901232() {

		// login using deleted account credentials
		lg.login1(Emailstudent2, password);

		cr.DeleteAccount();

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 2 profile
	 * credentials
	 */
	@Test(priority = 33)
	public void TCSPR0901233() {

		// login using deleted account credentials
		lg.login(Emailstudent2, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student3 Account functionality
	 */
	@Test(priority = 34)
	public void TCSPR0901234() {

		// login using deleted account credentials
		lg.login1(Emailstudent3, password);

		cr.DeleteAccount();

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 3 profile
	 * credentials
	 */
	@Test(priority = 35)
	public void TCSPR0901235() {

		// login using deleted account credentials
		lg.login(Emailstudent3, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student4 Account functionality
	 */
	@Test(priority = 36)
	public void TCSPR0901236() {

		// login using deleted account credentials
		lg.login1(Emailstudent4, password);

		cr.DeleteAccount();

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 4 profile
	 * credentials
	 */
	@Test(priority = 37)
	public void TCSPR0901237() {

		// login using deleted account credentials
		lg.login(Emailstudent4, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

}
