package CreateNewAssessment.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
import CreateNewAssessment.Pages.MultipleQuestionsAddPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class SchedulePageBasicsTest extends basePage {

	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	EditCoursePage ec = new EditCoursePage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	CourseRosterPage cr = new CourseRosterPage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	EncryptedText et = new EncryptedText();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	SchedulePageBasicsPage sb = new SchedulePageBasicsPage();
	MultipleQuestionsAddPage mq = new MultipleQuestionsAddPage();
	CommonMethods cm = new CommonMethods();

	public String Emailteacher;
	public String CourseNamenew;
	public String NewCourseTitle;
	public String AssessmentName;
	public String NewAssessmentName;
	public String NewCourseName;
	public String CourseID1;
	public String Emailstudent1;
	public String Emailstudent2;

	public String Studentfirstname;
	public String Studentlastname;
	public String Studentname;
	public String Studentfirstname2;
	public String Studentlastname2;
	public String Studentname2;

	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	/*
	 * To perform Sign Up functionality
	 */
	@Test(priority = 0)
	public void TCSPR0901001() {

		// To click on i am a teacher button
		click(sp.btn_1);
		waitThread(2000);

		// to fill the details of the teacher

		Emailteacher = st.TCSPR020005();
	}

	@Test(priority = 1)
	public void OtpFetch() throws SQLException {
		st.TCSPR020006();
	}

	/*
	 * To create new course
	 */
	@Test(priority = 2)
	public void TCSPR0901002() throws SQLException {

		CourseName = "Course Name" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID = (getText(cn.course_Id));
		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";

		// Invite students to course
		sb.Invitestudentstocourse(CourseName, Emailstudent1, Emailstudent2);

	}
	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 3)
	public void TCSPR0901003() {

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
	public void TCSPR0901004() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent1, CourseID);

		String encText = et.EncryptCode(studentinviteid);
		// driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname = "Ashley";
		Studentlastname = "Albert";
		Studentname = Studentfirstname + " " + Studentlastname;
		waitThread(3000);

		// click first name
		click(sp.txtbxFirstN);

		// type first name
		type(sp.txtbxFirstN, Studentfirstname);

		// click last name
		click(sp.txtbxLastN);

		// type last name
		type(sp.txtbxLastN, Studentlastname);

		// click password
		click(sp.txtbxPass);

		// type password
		type(sp.txtbxPass, password);

		// click password
		click(sp.txtbxPassconf);

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
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());
	}
	/*
	 * To Accept course and perform logout functionality on the student profile
	 */

	@Test(priority = 5)
	public void TCSPR0901005() {

		// click on accept course button
		click(rs.btn_acceptcourse);

		// verify the confirmation popup visible
		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");

		// click on Yes button
		click(rs.popupbtn_Yes);

		// Check for toaster element's presence
		java.util.List<WebElement> toaster = driver.findElements(By.xpath(rs.toaster));
		if (toaster.size() != 0) {
			// Toaster message
			waitFor(rs.toaster);
			Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
			click(QP.toasterclosebtn);
		} else

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
	 * To check that invited course request visible on first student 's profile
	 * and accept course request-Read the student name
	 */
	@Test(priority = 6)
	public void TCSPR0901006() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent2, CourseID);

		String encText = et.EncryptCode(studentinviteid);
		// driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname2 = "Ben";
		Studentlastname2 = "Max";
		Studentname2 = Studentfirstname2 + " " + Studentlastname2;

		// click first name
		click(sp.txtbxFirstN);

		// type first name
		type(sp.txtbxFirstN, Studentfirstname2);

		// click last name
		click(sp.txtbxLastN);

		// type last name
		type(sp.txtbxLastN, Studentlastname2);

		// click password
		click(sp.txtbxPass);

		// type password
		type(sp.txtbxPass, password);

		// click password
		click(sp.txtbxPassconf);

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
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());

	}
	/*
	 * To Accept course and perform logout functionality on the student profile
	 */

	@Test(priority = 7)
	public void TCSPR0901007() {

		// click on accept course button
		click(rs.btn_acceptcourse);

		// verify the confirmation popup visible
		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");
		waitThread(2000);

		// click on Yes button
		click(rs.popupbtn_Yes);

		// Check for toaster element's presence
		java.util.List<WebElement> toaster = driver.findElements(By.xpath(rs.toaster));
		if (toaster.size() != 0) {
			// Toaster message
			waitFor(rs.toaster);
			Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
			click(QP.toasterclosebtn);
		} else

			// verify the course name visibled on the enrolled section
			waitFor(rs.enrolledcoursename);
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	public String CourseID = cm.CourseID2;
	public String CourseName = cm.CourseName2;

	/*
	 * To load the create new assessment page and fill details on the basic
	 * details page
	 */
	@Test(priority = 8)
	public void TCSPR0901008() {

		SoftAssert softAssert1 = new SoftAssert();
		rs.login_Teacher(Emailteacher, password);
		waitThread(8000);
		// click on Assessment tab
		click(ba.Assessmenttab);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);

		// To click on course dropdown
		click(ba.dd_course);
		// waitFor(ba.ddcoursename2);
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
		waitThread(4000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(4000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), AssessmentName);

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID + ", " + CourseName.trim());

		softAssert1.assertAll();
	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 9)
	public void TCSPR0901009() {

		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question1");

		driver.switchTo().defaultContent();

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

		// Check for toaster element's presence
		java.util.List<WebElement> toaster = driver.findElements(By.xpath(rs.toaster));
		if (toaster.size() != 0) {
			// Toaster message
			waitFor(rs.toaster);
			// Assert the toaster "Saved successfully"
			Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
			click(QP.toasterclosebtn);
		} else

			// Assert the peer review wizard is selected
			Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	/*
	 * To verify the details on the peer review page
	 */
	@Test(priority = 10)
	public void TCSPR0901010() {

		waitThread(5000);

		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		waitThread(5000);
		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");

		waitThread(5000);
		waitThread(2000);
		// Assert the first student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), "Ashley Albert");

		waitThread(5000);
		waitThread(2000);

		// Assert the second student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), "Ben Max");

	}

	/*
	 * To perform the save and next functionaity from peer review page and
	 * verify the schedule page details
	 */
	@Test(priority = 11)
	public void TCSPR0901011() {

		// Type peer review reward score
		type(pr.PRreward_txtbox, "100");
		waitThread(4000);
		click(pr.savennext_button);
		waitThread(5000);
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");

		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.Sbassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseName.trim()));

		Assert.assertEquals(getText(sb.totalques_lbl), "Total Questions:");

		Assert.assertEquals(getText(sb.quescount_lbl), "1");
		Assert.assertEquals(getText(sb.maxscore_lbl), "Total Test Point:");
		Assert.assertEquals(getText(sb.maxscorecount), "3");

		// Assert the Discard,Save&Exit,Save&Next buttons and button labels:
		Assert.assertTrue(isElementPresent(pr.discard_button), "Button not present");
		Assert.assertTrue(isElementPresent(pr.savenexit_button), "Button not present");

		Assert.assertTrue(isElementPresent(pr.savennext_button), "Button not present");
		Assert.assertTrue(isElementPresent(sb.clearall_btn), "Button not present");
		Assert.assertTrue(isElementPresent(sb.configuredef_btn), "Button not present");

		Assert.assertTrue(isElementPresent(sb.apply_btn), "Button not present");

		Assert.assertEquals(getText(sb.selectstu_lbl), "Select Schedules for");

	}

	public String assessmentopendate;
	public String assessmentopentime;
	public String assessmentduedate;
	public String assessmentduetime;

	/*
	 * To verify the details on the Test Window section[Labels,Date,Time]
	 */
	@Test(priority = 12)
	public void TCSPR0901012() {

		// Assert labels-
		Assert.assertEquals(getText(sb.studentscan_lbl), "Students can answer the assessment during these dates only");
		Assert.assertEquals(getText(sb.testwin_lbl), "Test Window");

		Assert.assertEquals(getText(sb.assessmentopen_lbl), "Assessment Open date and time:");
		Assert.assertEquals(getText(sb.assessmentdue_lbl), "Assessment Due date and time:");

		// Assert the Assessment Due date and time text boxes
		Assert.assertTrue(isElementPresent(sb.assessmentopendate_txtbx), "textbox not present");
		Assert.assertTrue(isElementPresent(sb.assessmentopentime_txtbx), "textbox not present");

		Assert.assertTrue(isElementPresent(sb.assessmentduedate_txtbx), "textbox not present");
		Assert.assertTrue(isElementPresent(sb.assessmentduetime_txtbx), "textbox not present");

		assessmentopendate = getValue(sb.assessmentopendate_txtbx);
		assessmentopentime = getValue(sb.assessmentopentime_txtbx);
		assessmentduedate = getValue(sb.assessmentduedate_txtbx);
		assessmentduetime = getValue(sb.assessmentduetime_txtbx);

		waitThread(3000);
		// Assert that the Assessment Open date is Today's date
		Assert.assertEquals(getValue(sb.assessmentopendate_txtbx), sb.getdate());

		waitThread(4000);
		// Assert the Assessment Open time should be 2 min buffer time as
		// default
		// datefrom the current time
		// Assert.assertTrue(getValue(sb.assessmentopentime_txtbx).contains(sb.getTime(2)));

		// Assert the Assessment Due date should be 7 days buffer time as
		// default date
		// from the current time
		String difference1 = sb.getdatedifference(sb.assessmentopendate_txtbx, sb.assessmentduedate_txtbx);
		int d1 = Integer.valueOf(difference1);

		if (d1 == 7) {
			Assert.assertEquals(sb.getdatedifference(sb.assessmentopendate_txtbx, sb.assessmentduedate_txtbx), "7");

		} else if (d1 >= 8) {
			Assert.assertEquals(sb.getdatedifference(sb.assessmentopendate_txtbx, sb.assessmentduedate_txtbx), "8");

		}

		// Assert the Assessment Due time same as test start time
		Assert.assertEquals(getValue(sb.assessmentduetime_txtbx), assessmentopentime);

	}

	public String peerreviewopendate;
	public String peerreviewopentime;
	public String peerreviewduedate;
	public String peerreviewduetime;

	/*
	 * To verify the details on the Peer Review Window section[Labels,Date,Time]
	 */
	@Test(priority = 13)
	public void TCSPR0901013() {

		// assert labels
		Assert.assertEquals(getText(sb.studentscan_lbl2), "Students can perform peer review during these dates only");
		Assert.assertEquals(getText(sb.peerreview_lbl), "Peer Review");

		Assert.assertEquals(getText(sb.peerreviewopenLabel), "Peer Review Open date and time:");
		Assert.assertEquals(getText(sb.peerreviewDueLabel), "Peer Review Due date and time:");

		// Assert textbox
		Assert.assertTrue(isElementPresent(sb.peerreviewopendate_txtbx), "Textbox not present");
		Assert.assertTrue(isElementPresent(sb.peerreviewopentime_txtbx1), "Textbox not present");

		Assert.assertTrue(isElementPresent(sb.peerreviewduedate_txtbx), "Textbox not present");
		Assert.assertTrue(isElementPresent(sb.peerreviewduetime_txtbx), "Textbox not present");

		peerreviewopendate = getValue(sb.peerreviewopendate_txtbx);
		peerreviewopentime = getValue(sb.peerreviewopentime_txtbx1);
		peerreviewduedate = getValue(sb.peerreviewduedate_txtbx);
		peerreviewduetime = getValue(sb.peerreviewduetime_txtbx);
		assessmentduedate = getValue(sb.assessmentduedate_txtbx);

		// Assert that the Peer Review Open time is same time as the test close
		// time
		Assert.assertEquals(getValue(sb.peerreviewopentime_txtbx1), assessmentopentime);

		// Assert the Peer Review Due time is same as test due time
		Assert.assertEquals(getValue(sb.peerreviewduetime_txtbx), assessmentduetime);

		// Assert the peer review Due date should be 7 days buffer time as
		// default date
		// from the current time[Peer review start date]

		String difference1 = sb.getdatedifference(sb.peerreviewopendate_txtbx, sb.peerreviewduedate_txtbx);
		int d1 = Integer.valueOf(difference1);

		if (d1 == 7) {
			Assert.assertEquals(sb.getdatedifference(sb.peerreviewopendate_txtbx, sb.peerreviewduedate_txtbx), "7");

		} else if (d1 >= 8) {
			Assert.assertEquals(sb.getdatedifference(sb.peerreviewopendate_txtbx, sb.peerreviewduedate_txtbx), "8");

		}

		// *Assert the peer review start time same as Assessment Due time
		Assert.assertEquals(getValue(sb.peerreviewduetime_txtbx), assessmentopentime);

	}

	public String resultpublishdate;

	/*
	 * To verify the details on the Result Publishing section[Labels,Date,Time]
	 */
	@Test(priority = 14)
	public void TCSPR0901014() {

		// Assert labels-
		Assert.assertEquals(getText(sb.resultpublish_lbl), "Result Publishing");
		Assert.assertEquals(getText(sb.resultpublishdate_lbl),
				"Result will be automatically published on the following date");

		ScrollTo_xy_position(0, 300);
		waitThread(2000);

		// Assert text boxes
		waitFor(sb.resultpublishdate_txtbx);
		Assert.assertTrue(isElementPresent(sb.resultpublishdate_txtbx), "Textbox not present");
		Assert.assertTrue(isElementPresent(sb.resultpublishtime_txtbx), "Textbox not present");

		// Assert that the Result Publishing time is same as
		// peer review due time

		Assert.assertEquals(getValue(sb.resultpublishtime_txtbx), peerreviewduetime);

		peerreviewduedate = getValue(sb.peerreviewduedate_txtbx);
		resultpublishdate = getValue(sb.resultpublishdate_txtbx);

		// Assert the Result Publishing date is same as peer review due date
		Assert.assertEquals(getValue(sb.resultpublishdate_txtbx), peerreviewduedate);

	}

	// To verify the details on the Configuration Notifications section[verify
	// the
	// labels and checkboxes are selected]
	@Test(priority = 15)
	public void TCSPR0901015() {

		// Assert labels and check boxes is selected:
		Assert.assertEquals(getText(sb.confignoti_lbl), "Configure Mail Notifications");
		Assert.assertEquals(getText(sb.notifyActiveLabel), "Notification is activated for:");

		Assert.assertEquals(getText(sb.Wnewassess_lbl), "When a new assessment is published");
		Assert.assertEquals(getText(sb.Wtestandpeer_lbl), "When test and peer-review are active");

		Assert.assertEquals(getText(sb.Wtestnpeerclose_lbl), "When test,peer-review and result dates are modified");

		Assert.assertEquals(getText(sb.Wtestnpeermodi_lbl),
				"When result is published manually by teacher/automatically by system");
		// check boxes
		Assert.assertTrue(isElementPresent(sb.Wnewassess_checkbx), "checkbox not selected");
		Assert.assertTrue(isElementPresent(sb.Wtestandpeer_checkbx), "checkbox not selected");
		Assert.assertTrue(isElementPresent(sb.Wtestnpeermodi_checkbx), "checkbox not selected");
		Assert.assertTrue(isElementPresent(sb.Wresultpub_checkbx), "checkbox not selected");

	}
	// To change the assessment name from basic details page and verify the
	// assessment name is updating on the schedule page

	@Test(priority = 16)
	public void TCSPR0901016() {

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		// Click on the basic details wizard
		click(pr.basicdetails_wizard);

		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.basicdetails_wizard), "peer review wizard is selected");

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(pr.question_wizard2, "aria-selected"), "false");

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(pr.peerrev_wizard2, "aria-selected"), "false");

		// click assessment name field
		click(QP.Assess_name);
		driver.findElement(By.xpath("//input[@id='assessmentName']")).clear();

		// Type Assessment Name

		NewAssessmentName = "NewAssessment" + generateRandomNumber().trim();

		type(QP.Assess_name, NewAssessmentName);

		// Click on save and next button
		click(pr.savennext_button);
		// Check for toaster element's presence
		java.util.List<WebElement> toaster = driver.findElements(By.xpath(rs.toaster));
		if (toaster.size() != 0) {
			// Toaster message
			waitFor(rs.toaster);
			click(QP.toasterclosebtn);
		} else

			waitThread(3000);

		// Assert the question wizard is selected
		Assert.assertTrue(isEnabled(pr.question_wizard), "question wizard is selected");

		// Click on save and next button
		Doubleclick(pr.savennext_button);
		waitThread(8000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		MouseHover(pr.discard_button);
		waitThread(5000);
		click(pr.savennext_button);
		waitThread(8000);
		// Assert the schedule wizard is selected
		// Assert.assertEquals(getAttribute(sb.schedule_wizard,
		// "aria-selected"),
		// "true");

	}

	/*
	 * To perform save and next functionality from schedule page
	 */
	@Test(priority = 17)
	public void TCSPR0901017() {

		MouseHover(pr.discard_button);
		waitThread(4000);
		// Click on save and next button
		click(pr.savennext_button);

		waitThread(4000);
		// Assert the Summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");

		waitThread(4000);
		click(sb.schedule_wizard);
		waitThread(3000);

		// Assert the schedule wizard is selected
		// Assert.assertEquals(getAttribute(sb.schedule_wizard,
		// "aria-selected"),
		// "true");

		waitThread(6000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.Sbassessmentname_lbl2).contains("Assessment Name: " + NewAssessmentName.trim()));

	}

	/*
	 * To verify the details on the Teacher will manually publish the result
	 * section
	 */
	@Test(priority = 18)
	public void TCSPR0901018() {

		waitThread(3000);
		// Assert the radio button and label::Teacher will manually publish the
		// result
		Assert.assertEquals(getText(sb.teachermanua_lbl), "Teacher will manually publish the result");

		Assert.assertTrue(isElementPresent(sb.teacherwill_radio), "radio button is present");

		waitThread(5000);
		// Click on Teacher will manually publish the result
		Doubleclick(sb.teacherwill_radio);

		waitThread(4000);

		// Assert the Teacher will manually publish the result radio button is
		// selected
		Assert.assertTrue(isEnabled(sb.teachwill_radio_select),
				"Teacher will manually publish the result radio button not selected");

		// Assert the Result publishing date radio button is unselected
		Assert.assertFalse(isSelected(sb.resultpublish_radio), "radio button is selected");

		// Assert the Allow students to raise a Reconsideration Request Label
		// visible
		Assert.assertEquals(getText(sb.allowstudent_lbl), "Allow students to raise a Reconsideration Request");

		// Assert the Allow students to raise a Reconsideration Request check
		// box is
		// unchecked
		Assert.assertFalse(isSelected(sb.allowstu_checkbx2),
				"Allow students to raise a Reconsideration Request check box is checked");

		waitThread(4000);
		// Click on save and next button
		click(pr.savennext_button);
		waitThread(3000);

		// Assert the peer Summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");

		waitThread(4000);
		click(sb.schedule_wizard);
		waitThread(3000);

		// Assert the schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-selected"), "true");
	}

	/*
	 * To verify the Configuration Notifications required field validation
	 * messages
	 */
	@Test(enabled = false)
	public void TCSPR0901019() {

		Scroll_DowntoEnd();
		waitThread(5000);

		waitThread(1000);

		// Click on Mail Notification check box
		click(sb.mailnotifi_checkbx);
		waitThread(3000);

		// Assert the mail notification check box is unselected
		// Assert.assertFalse(isEnabled(sb.mailnotifi_checkbx2), "radio button
		// is selected");

		// Click on Mail Notification check box
		click(sb.mailnotifi_checkbx2);
		waitThread(1000);

		// Assert validation message "Select at least one mail notification
		// option"
		// Check for toaster element's presence
		java.util.List<WebElement> toaster = driver.findElements(By.xpath(rs.toaster));
		if (toaster.size() != 0) {
			// Toaster message
			waitFor(rs.toaster);
			click(QP.toasterclosebtn);
		} else

			click(pr.savennext_button);

		// Assert toaster"Select at least one mail notification"
		// Check for toaster element's presence
		java.util.List<WebElement> toaster1 = driver.findElements(By.xpath(rs.toaster));
		if (toaster1.size() != 0) {
			// Toaster message
			waitFor(rs.toaster);
			Assert.assertEquals(getText(rs.toaster), "Select at least one mail notification");
			click(QP.toasterclosebtn);
		} else

			// Click on When a new assessment is published check box
			click(sb.Wnewassess_checkbx2);
		waitThread(1000);

		// Assert the validation message not visible
		Assert.assertTrue(isElementPresent(sb.mailvali_msg), "validation not  present");
		ScrollTo_xy_position(0, 0);

		waitThread(2000);
		click(pr.savennext_button);

		waitFor(pr.assessmentde_toaster);

		// Assert toaster "Saved successfully"
		Assert.assertEquals(getText(pr.assessmentde_toaster), "Saved successfully");

		click(QP.toasterclosebtn);

	}

	/*
	 * To perform the save and exit functionality and load the assessment from
	 * draft page
	 */
	@Test(priority = 20)
	public void TCSPR0901020() {

		waitThread(3000);

		// Click on save and exit button
		click(pr.savenexit_button);
		waitThread(3000);

		Doubleclick(pr.draft_tab);
		waitThread(1000);

		click(pr.draft_tab);
		waitThread(1000);

		// click continue edit button
		click(pr.continueedit_button);
		waitThread(1000);

		// Click on save and next button
		click(pr.savennext_button);

		waitThread(2000);

		// Click on save and next button
		click(pr.savennext_button);

		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is not selected");
		Doubleclick(pr.savennext_button);

		waitThread(3000);
		// Assert the schedule wizard is selected
		Assert.assertTrue(isEnabled(sb.schedule_wizard), "schedule wizard is not  selected");
	}

	/*
	 * Verify the data's in each textboxes
	 * 
	 */
	@Test(priority = 21)
	public void TCSPR0901021() {

		// Assert the details same as we added

		// Assert the test open date and time
		waitThread(3000);
		Assert.assertEquals(getValue(sb.assessmentopendate_txtbx), sb.getdate());

		// Assert the test due date and time
		String difference1 = sb.getdatedifference(sb.assessmentopendate_txtbx, sb.assessmentduedate_txtbx);
		int d1 = Integer.valueOf(difference1);

		if (d1 == 7) {
			Assert.assertEquals(sb.getdatedifference(sb.assessmentopendate_txtbx, sb.assessmentduedate_txtbx), "7");

		} else if (d1 >= 8) {
			Assert.assertEquals(sb.getdatedifference(sb.assessmentopendate_txtbx, sb.assessmentduedate_txtbx), "8");

		}

		// Assert the peer review open date and time
		Assert.assertEquals(getValue(sb.peerreviewopendate_txtbx), assessmentduedate);
		// Assert.assertEquals(getValue(sb.peerreviewopentime_txtbx),
		// assessmentopentime);

		// Assert the peer review due date and time
		String difference2 = sb.getdatedifference(sb.peerreviewopendate_txtbx, sb.peerreviewduedate_txtbx);
		int d2 = Integer.valueOf(difference2);

		if (d2 == 7) {
			Assert.assertEquals(sb.getdatedifference(sb.peerreviewopendate_txtbx, sb.peerreviewduedate_txtbx), "7");

		} else if (d2 >= 8) {
			Assert.assertEquals(sb.getdatedifference(sb.peerreviewopendate_txtbx, sb.peerreviewduedate_txtbx), "8");

		}

		// Assert the Teacher will manually publish the result check box is
		// selected
		Assert.assertTrue(isEnabled(sb.teachwill_radio_select),
				"Teacher will manually publish the result radio button not selected");
	}

	/*
	 * To perform the clear all functionality on the schedule page
	 */
	@Test(priority = 22)
	public void TCSPR0901022() {

		// Click on Clear All button
		waitThread(1000);
		click(sb.clearall_btn);
		waitThread(2000);

		// Assert a confirmation popup visible on the page
		Assert.assertTrue(isElementPresent(sb.conf_dlgbx), "confirmation popup not visible on the page");

		// Assert label
		Assert.assertEquals(getText(sb.confirm_lbl), "Are you sure that you want to clear all the fields?");

		// Assert button in popup
		Assert.assertTrue(isElementPresent(sb.confno_btn), "Button not   present");
		Assert.assertTrue(isElementPresent(sb.confyes_btn), "Button not  present");

		// click no button
		click(sb.confno_btn);
		waitThread(1000);

		// Assert a confirmation popup not visible on the page
		Assert.assertFalse(isElementPresent(sb.conf_dlgbx), "popup  present");

		click(sb.clearall_btn);
		waitThread(1000);

		// click yes button
		click(sb.confyes_btn);

		// Assert the toaster "Cleared successfully"
		waitFor(pr.assessmentde_toaster);
		Assert.assertEquals(getText(pr.assessmentde_toaster), "Cleared successfully");

		// Assert that no data's on the Test Window[Asserts date and times] and
		// Peer
		// Review[assert date and time]
		Assert.assertEquals(getValue(sb.assessmentduedate_txtbx), "");
		Assert.assertEquals(getValue(sb.assessmentduetime_txtbx), "");
		Assert.assertEquals(getValue(sb.assessmentopentime_txtbx), "");
		Assert.assertEquals(getValue(sb.assessmentopendate_txtbx), "");

		Assert.assertEquals(getValue(sb.peerreviewopendate_txtbx), "");
		Assert.assertEquals(getValue(sb.peerreviewopentime_txtbx1), "");
		Assert.assertEquals(getValue(sb.peerreviewduedate_txtbx), "");
		Assert.assertEquals(getValue(sb.peerreviewduetime_txtbx), "");

	}

	/*
	 * To verify the confirmation popup when click on the peer review
	 * wizard[After perform clar all functionality]
	 */
	@Test(priority = 23)
	public void TCSPR0901023() {

		// Click on peer review wizard
		click(pr.peerrev_wizard);

		// Assert the confirmation popup visible
		waitFor(sb.prconf_dlgbx);
		Assert.assertTrue(isElementPresent(sb.prconf_dlgbx), "validation not  present");

		// Assert label
		Assert.assertEquals(getText(sb.confirm_lbl), "Changes you made may not be saved");

		// Assert buttons Continue Editing,Discard
		Assert.assertTrue(isElementPresent(sb.confdiscard_btn), "Button not  present");
		Assert.assertTrue(isElementPresent(sb.confcontinue_btn), "Button not  present");

		click(sb.confcontinue_btn);
		waitThread(1000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is not selected");

		// Assert the confirmation popup not visible
		Assert.assertFalse(isElementPresent(sb.prconf_dlgbx), "popup  present");

		click(pr.peerrev_wizard);

		// Assert the confirmation popup not visible
		Assert.assertTrue(isElementPresent(sb.prconf_dlgbx), "popup not  present");

		click(sb.confdiscard_btn);
		waitThread(1000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is not selected");

	}
	/*
	 * To click back to the schedule page and check the data's visible[Test
	 * window,Peer review window]
	 */

	@Test(priority = 24)
	public void TCSPR0901024() {

		click(pr.savennext_button);
		waitThread(3000);

		// Assert the already saved data's visible on the Test Window[Asserts
		// date and
		// times] and Peer Review[assert date and time]
		waitThread(3000);
		Assert.assertEquals(getValue(sb.assessmentduedate_txtbx), assessmentduedate);
		waitThread(3000);
		Assert.assertEquals(getValue(sb.assessmentopendate_txtbx), assessmentopendate);

		Assert.assertEquals(getValue(sb.peerreviewopendate_txtbx), peerreviewopendate);
		waitThread(3000);
		Assert.assertEquals(getValue(sb.peerreviewduedate_txtbx), peerreviewduedate);

		waitThread(2000);

		Assert.assertTrue(isElementPresent(sb.Assessopenfilledtime2), "time not visible");

		Assert.assertTrue(isElementPresent(sb.Assessduefilledtime2), "time not visible");

		waitThread(2000);
		// Assert.assertTrue(isElementPresent(sb.peeropenfilledtime2), "time not
		// visible");

		Assert.assertTrue(isElementPresent(sb.peerduefilledtime2), "time not visible");
		waitThread(3000);
	}

	/*
	 * To verify the clear all button disable/Enable functionalities
	 */
	@Test(priority = 25)
	public void TCSPR0901025() {

		// click clearall button
		waitThread(3000);
		click(sb.clearall_btn);
		waitThread(3000);

		// click yes
		click(sb.confyes_btn);
		waitFor(pr.assessmentde_toaster);

		// Assert toaster
		Assert.assertEquals(getText(pr.assessmentde_toaster), "Cleared successfully");

		// Assert the Clear all button is disable
		Assert.assertFalse(isEnabled(sb.clearall_btn), "button enabled");

		ScrollTo_xy_position(0, 500);
		waitThread(1000);

		// Click on Teacher will manually publish the result radio button
		click(sb.teachwill_radio_select);
		waitThread(3000);

		// Assert the Clear all button is enabled
		Assert.assertTrue(isEnabled(sb.clearall_btn), "button disabled");

		// Assert radio button is selected
		Assert.assertTrue(isEnabled(sb.teachwill_radio_select),
				"Teacher will manually publish the result radio button not selected");
	}

	/*
	 * Verify that Allow students to raise a Reconsideration Request
	 * functionality[Labels and texboxes]
	 */
	@Test(priority = 26)
	public void TCSPR0901026() {

		// Click Allow ResConsideration checkbox
		click(sb.allowstu_checkbx2);

		// Assert the labels
		// -Last date for raising reconsideration request by students
		// -Day from Result Publishing Date at

		Assert.assertEquals(getText(sb.lastdatestu_lbl), "Last date for raising reconsideration request by students");
		Assert.assertEquals(getText(sb.dayfromresult_lbl), "Day from the Result Publishing Date at");

		// Click on Days dropdown
		click(sb.day_recons_dropdwn);

		// Assert the dropdown number count is 0 to 30
		Assert.assertEquals(TotalElementsCount(sb.dropvalue), 62);

		// Click on Time textbox
		click(sb.lasttime_txtbx);

		// Assert the time box viisble
		Assert.assertTrue(isElementPresent(sb.lasttime_select_bx), "Time textbox not visible");

		// Click on Any of dropdown
		click(sb.day_recons_dropdwn);
		click(sb.zero_day_dropdwn);

		// Assert the date visible on the page
		Assert.assertEquals(getValue(sb.day_drop_txtbx), "0");

	}

	/*
	 * To verify the validation messages on the schedule page -To fill Test
	 * window due date and time
	 */
	@Test(priority = 27)
	public void TCSPR0901027() {

		click(pr.savennext_button);
		waitFor(QP.toaster);

		// Assert toaster "Please enter the mandatory date and time fields"
		Assert.assertEquals(getText(QP.toaster), "Please enter the mandatory date and time fields");

		click(QP.toasterclosebtn);

		click(pr.savenexit_button);
		waitFor(QP.toaster);

		// Assert toaster "Please enter the mandatory date and time fields"
		Assert.assertEquals(getText(QP.toaster), "Please enter the mandatory date and time fields");

		click(QP.toasterclosebtn);
		waitThread(1000);

		ScrollTo_xy_position(0, 150);
		waitThread(2000);
		// Click on Test Window due date date picker
		Doubleclick(sb.assessmentduedate_txtbx);
		waitFor(sb.Assessdue_calendar);

		// Assert the calendar visible
		// Assert.assertTrue(isElementPresent(sb.assessdue_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.Assessdue_calendar, "class").contains("p-calendar p-focus"));

		// Select the Test Window closed date
		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		// Assert the calendar not visible
		Assert.assertFalse(isElementPresent(sb.assessdue_calendar), "Calendar   present");

		// Assert time visible on the textbox
		Assert.assertTrue(isElementPresent(sb.Assessduefilledtime), "time not visible");

	}

	/*
	 * To fill the Peer review open date and time close date and time text boxes
	 */
	@Test(priority = 28)
	public void TCSPR0901028() {

		// Select the Peer Review Window open date
		waitThread(1000);
		Doubleclick(sb.peerreviewopendate_txtbx);
		waitThread(2000);

		// Assert the calendar visible
		// Assert.assertTrue(isElementPresent(sb.peeropen_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.peerOpen_calendar, "class").contains("p-calendar p-focus"));

		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		// Assert the calendar not visible
		Assert.assertFalse(isElementPresent(sb.peeropen_calendar), "Calendar  present");

		// Select the Peer Review Window due date
		waitThread(1000);
		Doubleclick(sb.peerreviewduedate_txtbx);
		waitThread(1000);

		// Assert the calendar visible
		// Assert.assertTrue(isElementPresent(sb.peerdue_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.peerDue_calendar, "class").contains("p-calendar p-focus"));

		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		// Assert the calendar not visible
		Assert.assertFalse(isElementPresent(sb.peerdue_calendar), "Calendar  present");

		// Assert the time filled
		Assert.assertTrue(isElementPresent(sb.peerduefilledtime), "time not visible");

	}

	/*
	 * To fill the Result publishing date and time
	 */
	@Test(priority = 29)
	public void TCSPR0901029() {
		waitThread(1000);

		// Select the Automatically Result publishing radio button
		click(sb.resultpublish_radio);

		// Assert the time visible on the textbox
		Assert.assertTrue(isElementPresent(sb.resultfilledtime), "time not visible");
	}

	/*
	 * To check the validation messages for the assessment open date section To
	 * fill the details on the schedule page for Test open date/Allow students
	 * to raise a Reconsideration Request/and notifications is mandatory
	 */
	@Test(priority = 30)
	public void TCSPR0901030() {
		waitThread(10000);
		// Click Save&Next button
		click(pr.savennext_button);
		waitThread(12000);
		click(pr.savennext_button);
		
		waitFor(QP.toaster);

		// Assert toaster"Assessment Open date and time is mandatory"
		Assert.assertEquals(getText(QP.toaster), "Assessment Open date and time is mandatory\n" + "\n"
				+ " Assessment Due date should not be past date and time");

		click(QP.toasterclosebtn);

		// click Save&Exit button
		click(pr.savenexit_button);
		waitFor(QP.toaster);

		// Assert toaster"Assessment Open date and time is mandatory"
		Assert.assertEquals(getText(QP.toaster), "Assessment Open date and time is mandatory\n" + "\n"
				+ " Assessment Due date should not be past date and time");

		// click(QP.toasterclosebtn);
		waitThread(8000);

		// ScrollTo_xy_position(0, 0);
		cm.ScrollHome();
		waitThread(2000);

		// click clear all button
		click(sb.clearall_btn);
		waitThread(2000);
		click(sb.confyes_btn);

		waitFor(pr.assessmentde_toaster);

		// Assert toaster
		Assert.assertEquals(getText(pr.assessmentde_toaster), "Cleared successfully");

		// Click on Test Window open date date picker
		Doubleclick(sb.assessmentopendate_txtbx);
		waitThread(1000);

		// Assert calender visible
		// Assert.assertTrue(isElementPresent(sb.assessopen_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.assessmentOpenclndr, "class").contains("p-calendar p-focus"));

		// Select the Test Window open date
		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		// Assert calender not visible
		// Assert.assertFalse(isElementPresent(sb.assessopen_calendar),
		// "Calendar not present");
		Assert.assertFalse(getAttribute(sb.assessmentOpenclndr, "class").contains("p-calendar p-focus"));

		// Assert the time visible on the textbox
		Assert.assertTrue(isElementPresent(sb.Assessopenfilledtime), "time not visible");

		// Select the Test Window Due date as today's date
		Doubleclick(sb.assessmentduedate_txtbx);
		waitThread(1000);
		// Assert.assertTrue(isElementPresent(sb.assessdue_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.Assessdue_calendar, "class").contains("p-calendar p-focus"));

		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		// Assert the time visible on the textbox
		Assert.assertTrue(isElementPresent(sb.Assessduefilledtime), "time not visible");

		// Select the Peer review Window Open date& due date as today's date
		waitThread(1000);
		Doubleclick(sb.peerreviewopendate_txtbx);
		waitThread(1000);
		// Assert.assertTrue(isElementPresent(sb.peeropen_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.peerOpen_calendar, "class").contains("p-calendar p-focus"));
		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		waitThread(3000);
		Doubleclick(sb.peerreviewduedate_txtbx);
		waitThread(1000);
		// Assert.assertTrue(isElementPresent(sb.peerdue_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.peerDue_calendar, "class").contains("p-calendar p-focus"));
		Doubleclick(sb.calanderdate_val);
		waitThread(2000);

		// Assert the time visible on the textbox
		Assert.assertTrue(isElementPresent(sb.peerduefilledtime), "time not visible");

		Scroll_DowntoEnd();
		waitThread(1000);

		// Click Teacher manually publishing result
		Doubleclick(sb.teacherwill_radio);
		waitThread(2000);

		// Click Automatically result publishing button
		click(sb.resultpublish_radio);

		// Assert the time visible on the textbox
		Assert.assertTrue(isElementPresent(sb.resultfilledtime), "time not visible");

		waitThread(2000);

		// click mail notification check box
		// click(sb.mailnotifi_checkbx2);
		// waitThread(500);

		// Assert the check box is selected
		// Assert.assertTrue(isElementPresent(sb.mailnotifi_checkbx));
		// waitThread(1000);

	}

	/*
	 * To check the validation messages for the assessment open date section To
	 * fill the details on the schedule page for Test open date and
	 * notifications is mandatory
	 */
	@Test(priority = 31)
	public void TCSPR0901031() {

		click(sb.clearall_btn);
		waitThread(2000);
		click(sb.confyes_btn);
		waitThread(8000);
		// Click SaveNext button
		click(pr.savennext_button);
		waitFor(QP.toaster);

		// Assert toaster"Select at least one mail notification"
		Assert.assertEquals(getText(QP.toaster), "Please enter the mandatory date and time fields");
		// Assert.assertEquals(getText(QP.toaster),"Saved successfully");

		click(QP.toasterclosebtn);

		// Click on Save and Exit button
		click(pr.savenexit_button);
		waitFor(QP.toaster);

		// Assert toaster
		Assert.assertEquals(getText(QP.toaster), "Please enter the mandatory date and time fields");

		click(QP.toasterclosebtn);
		waitThread(1000);

		/*
		 * ScrollTo_xy_position(0, 0); waitThread(5000);
		 * 
		 * // click clear all button click(sb.clearall_btn); waitThread(1000);
		 * click(sb.confyes_btn);
		 * 
		 * waitFor(pr.assessmentde_toaster);
		 * 
		 * // Assert toaster
		 * Assert.assertEquals(getText(pr.assessmentde_toaster),
		 * "Cleared successfully");
		 * Assert.assertFalse(isEnabled(sb.clearall_btn), "button enabled");
		 */

	}

	/*
	 * To fill the Test window open date and time,peer review open and Due date
	 * and time
	 */
	@Test(priority = 32)
	public void TCSPR0901032() {

		waitThread(2000);

		Doubleclick(sb.assessmentopendate_txtbx);
		waitThread(3000);

		// Assert calender visible
		// Assert.assertTrue(isElementPresent(sb.assessopen_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.assessmentOpenclndr, "class").contains("p-calendar p-focus"));

		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		// Assert calender not visible
		// Assert.assertFalse(isElementPresent(sb.assessopen_calendar),
		// "Calendar not present");
		Assert.assertFalse(getAttribute(sb.assessmentOpenclndr, "class").contains("p-calendar p-focus"));

		// Assert time field is filled
		Assert.assertTrue(isElementPresent(sb.Assessopenfilledtime), "time not visible");

		waitThread(2000);

		// Select the peer review Open date
		Doubleclick(sb.peerreviewopendate_txtbx);
		waitThread(1000);

		// Assert calender visible
		// Assert.assertTrue(isElementPresent(sb.peeropen_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.peerOpen_calendar, "class").contains("p-calendar p-focus"));

		Doubleclick(sb.calanderdate_val);
		waitThread(3000);
		Assert.assertFalse(isElementPresent(sb.peeropen_calendar), "Calendar not  present");

		// Select the peer review due date
		Doubleclick(sb.peerreviewduedate_txtbx);
		waitThread(1000);

		// Assert calendar visible
		// Assert.assertTrue(isElementPresent(sb.peerdue_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.peerDue_calendar, "class").contains("p-calendar p-focus"));

		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		// Assert calendar not visible
		Assert.assertFalse(isElementPresent(sb.peerdue_calendar), "Calendar not  present");

		// Assert time field is filled
		Assert.assertTrue(isElementPresent(sb.peerduefilledtime), "time not visible");

	}

	/*
	 * To fill the Result publishing date and time
	 */
	@Test(priority = 33)
	public void TCSPR0901033() {

		waitThread(2000);

		Scroll_DowntoEnd();
		waitThread(1000);

		// Click Teacher manually publishing result
		Doubleclick(sb.teacherwill_radio);
		waitThread(2000);

		// Click Automatically result publishing button
		click(sb.resultpublish_radio);

		// Assert the time visible on the textbox
		Assert.assertTrue(isElementPresent(sb.resultfilledtime), "time not visible");

		waitThread(2000);
	}

	/*
	 * To verify the valiation messages[for Test due date] when click on save
	 * and next andsave and exit buttons
	 */
	@Test(priority = 34)
	public void TCSPR0901034() {

		// Click Save&Next button
		click(pr.savennext_button);
		waitFor(QP.toaster);

		// Assert toaster"Assessment Due date and time is mandatory"
		/*
		 * Assert.assertEquals(getText(QP.toaster),
		 * "Assessment Due date and time is mandatory\n" + "\n"
		 * +" Peer Review open date and Assessment open date are overlapping");
		 */
		Assert.assertEquals(getText(QP.toaster), "Assessment Due date and time is mandatory");

		click(QP.toasterclosebtn);

		// Click Save&Exit button
		click(pr.savenexit_button);
		waitFor(QP.toaster);

		// Assert toaster"Assessment Due date and time is mandatory"
		/*
		 * Assert.assertEquals(getText(QP.toaster),
		 * "Assessment Due date and time is mandatory\n" + "\n"
		 * +" Date and time are overlapping");
		 */

		click(QP.toasterclosebtn);
		waitThread(1000);

		ScrollTo_xy_position(0, 0);
		waitThread(5000);

		// Click Clear all
		click(sb.clearall_btn);
		waitThread(2000);

		click(sb.confyes_btn);

		waitFor(pr.assessmentde_toaster);

		// Assert toaster
		Assert.assertEquals(getText(pr.assessmentde_toaster), "Cleared successfully");

	}

	/*
	 * To fill the Test window open/due date and time,peer review Due date and
	 * time ,Result publishing date and time
	 */
	@Test(priority = 35)
	public void TCSPR0901035() {

		// Select the Test Window Open date

		Doubleclick(sb.assessmentopendate_txtbx);
		waitThread(2000);

		// Assert calendar visible
		// Assert.assertTrue(isElementPresent(sb.assessopen_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.assessmentOpenclndr, "class").contains("p-calendar p-focus"));

		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		// Assert calendar not visible
		Assert.assertFalse(isElementPresent(sb.assessopen_calendar), "Calendar   present");

		Assert.assertTrue(isElementPresent(sb.Assessopenfilledtime), "time not visible");

		waitThread(1000);

		// Select the Test Window Due date
		click(sb.assessmentduedate_txtbx);
		waitThread(1000);

		// Assert calendar visible
		// Assert.assertTrue(isElementPresent(sb.assessdue_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.Assessdue_calendar, "class").contains("p-calendar p-focus"));

		Doubleclick(sb.calanderdate_val);
		waitThread(2000);

		// Assert calendar not visible
		Assert.assertFalse(isElementPresent(sb.assessdue_calendar), "Calendar  present");

		Assert.assertTrue(isElementPresent(sb.Assessduefilledtime), "time not visible");

		waitThread(1000);

		// Select the Peer Review Window closed date
		click(sb.peerreviewduedate_txtbx);
		waitThread(1000);

		// Assert calendar visible
		// Assert.assertTrue(isElementPresent(sb.peerdue_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.peerDue_calendar, "class").contains("p-calendar p-focus"));

		Doubleclick(sb.calanderdate_val);
		waitThread(2000);

		// Assert calendar not visible
		Assert.assertFalse(isElementPresent(sb.peerdue_calendar), "Calendar not  present");

		Assert.assertTrue(isElementPresent(sb.peerduefilledtime), "time not visible");

		waitThread(1000);

		Scroll_DowntoEnd();
		waitThread(1000);

		// Click Teacher manually publishing result
		Doubleclick(sb.teacherwill_radio);
		waitThread(1000);

		// Click Automatically result publishing button
		click(sb.resultpublish_radio);

		// Assert the time visible on the textbox
		Assert.assertTrue(isElementPresent(sb.resultfilledtime), "time not visible");

		waitThread(1000);

	}

	/*
	 * To verify the valiation messages[for Peer review open date] when click on
	 * save and next andsave and exit buttons
	 */
	@Test(priority = 36)
	public void TCSPR0901036() {

		// Click Save&Next button
		click(pr.savennext_button);
		waitFor(QP.toaster);

		// Assert toaster"Peer Review Open date and time is mandatory"
		/*
		 * Assert.assertEquals(getText(QP.toaster),
		 * "Peer Review Open date and time is mandatory\n" + "\n"
		 * +" Date and time are overlapping");
		 */
		Assert.assertEquals(getText(QP.toaster), "Peer Review Open date and time is mandatory");
		click(QP.toasterclosebtn);

		// Click Save&Exit button
		click(pr.savenexit_button);
		waitFor(QP.toaster);

		// Assert toaster"Peer Review Open date and time is mandatory"
		/*
		 * Assert.assertEquals(getText(QP.toaster),
		 * "Peer Review Open date and time is mandatory\n" + "\n"
		 * +" Date and time are overlapping");
		 */
		Assert.assertEquals(getText(QP.toaster), "Date and time are overlapping");

		click(QP.toasterclosebtn);
		waitThread(1000);

		ScrollTo_xy_position(0, 0);
		waitThread(500);

		click(sb.clearall_btn);
		waitThread(1000);
		click(sb.confyes_btn);

		waitFor(pr.assessmentde_toaster);

		// Assert toaster
		Assert.assertEquals(getText(pr.assessmentde_toaster), "Cleared successfully");
		Assert.assertFalse(isEnabled(sb.clearall_btn), "button enabled");

	}

	/*
	 * To fill the Test window open/due date and time,peer review open date and
	 * time ,Result publishing date and time
	 */
	@Test(priority = 37)
	public void TCSPR0901037() {

		// Select the Test Window Open date
		click(sb.assessmentopendate_txtbx);
		waitThread(1000);

		// Assert calendar visible
		// Assert.assertTrue(isElementPresent(sb.assessopen_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.assessmentOpenclndr, "class").contains("p-calendar p-focus"));

		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		// Assert calendar not visible
		Assert.assertFalse(isElementPresent(sb.assessopen_calendar), "Calendar present");

		Assert.assertTrue(isElementPresent(sb.Assessopenfilledtime), "time not visible");

		// Select the Test Window due date
		waitThread(1000);
		click(sb.assessmentduedate_txtbx);
		waitThread(1000);
		// Assert.assertTrue(isElementPresent(sb.assessdue_calendar), "Calendar
		// present");
		Assert.assertTrue(getAttribute(sb.Assessdue_calendar, "class").contains("p-calendar p-focus"));

		Doubleclick(sb.calanderdate_val);
		waitThread(2000);

		// Assert calendar not visible
		Assert.assertFalse(isElementPresent(sb.assessdue_calendar), "Calendar   present");

		Assert.assertTrue(isElementPresent(sb.Assessduefilledtime), "time not visible");

		waitThread(2000);

		// Select the Peer Review Window open date
		Doubleclick(sb.peerreviewopendate_txtbx);
		waitThread(1000);

		// Assert calendar visible
		// Assert.assertTrue(isElementPresent(sb.peeropen_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.peerOpen_calendar, "class").contains("p-calendar p-focus"));

		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		// Assert time visible
		Assert.assertFalse(isElementPresent(sb.peeropen_calendar), "Calendar  present");

		// Assert.assertTrue(isElementPresent(sb.peeropenfilledtime), "time not
		// visible");

		waitThread(2000);

		waitThread(1000);

		// Select the Result publish date
		Scroll_DowntoEnd();
		waitThread(1000);

		// Click Teacher manually publishing result
		Doubleclick(sb.teacherwill_radio);
		waitThread(2000);

		// Click Automatically result publishing button
		click(sb.resultpublish_radio);

		// Assert the time visible on the textbox
		Assert.assertTrue(isElementPresent(sb.resultfilledtime), "time not visible");
	}

	/*
	 * To verify the valiation messages[for Peer review Due date] when click on
	 * save and next andsave and exit buttons
	 */
	@Test(priority = 38)
	public void TCSPR0901038() {

		// Click Save&Next button
		click(pr.savennext_button);
		waitFor(QP.toaster);

		// Assert toaster"Peer Review Due date and time is mandatory"
		/*
		 * Assert.assertEquals(getText(QP.toaster),
		 * "Peer Review Due date and time is mandatory\n" + "\n"
		 * +" Date and time are overlapping");
		 */
		Assert.assertEquals(getText(QP.toaster), "Peer Review Due date and time is mandatory");

		click(QP.toasterclosebtn);

		// Click Save&Exit button
		click(pr.savenexit_button);
		waitFor(QP.toaster);

		// Assert toaster"Peer Review Due date and time is mandatory"
		/*
		 * Assert.assertEquals(getText(QP.toaster)
		 * ,"Peer Review Due date and time is mandatory\n" + "\n"
		 * +" Date and time are overlapping");
		 */

		Assert.assertEquals(getText(QP.toaster), "Date and time are overlapping");

		click(QP.toasterclosebtn);
		waitThread(1000);

		ScrollTo_xy_position(0, 0);
		waitThread(500);

		// click clear all button
		click(sb.clearall_btn);
		waitThread(1000);
		click(sb.confyes_btn);

		// Assert the toaster "Cleared successfully"
		waitFor(pr.assessmentde_toaster);
		Assert.assertEquals(getText(pr.assessmentde_toaster), "Cleared successfully");

		// Assert the Clear all button is disable
		Assert.assertFalse(isEnabled(sb.clearall_btn), "button enabled");

	}

	/*
	 * To fill the Test window open/due date and time,peer review open/due date
	 * and time
	 */
	@Test(priority = 39)
	public void TCSPR0901039() {

		click(sb.assessmentopendate_txtbx);
		waitThread(1000);

		// Assert calendar visible
		// Assert.assertTrue(isElementPresent(sb.assessopen_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.assessmentOpenclndr, "class").contains("p-calendar p-focus"));

		// Select the Test Window Open date
		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		// Assert calendar not visible
		Assert.assertFalse(isElementPresent(sb.assessopen_calendar), "Calendar   present");

		// Assert time filled in textbox
		Assert.assertTrue(isElementPresent(sb.Assessopenfilledtime), "time not visible");

		waitThread(1000);
		click(sb.assessmentduedate_txtbx);
		waitThread(1000);
		// Assert.assertTrue(isElementPresent(sb.assessdue_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.Assessdue_calendar, "class").contains("p-calendar p-focus"));

		// Select the Test Window Due date
		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		// Assert calendar visible
		Assert.assertFalse(isElementPresent(sb.assessdue_calendar), "Calendar not  prsent");

		Assert.assertTrue(isElementPresent(sb.Assessduefilledtime), "time not visible");

		waitThread(1000);
		click(sb.peerreviewopendate_txtbx);
		waitThread(1000);

		// Assert calendar visible
		// Assert.assertTrue(isElementPresent(sb.peeropen_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.peerOpen_calendar, "class").contains("p-calendar p-focus"));
		// Select the Peer Review Window open date
		Doubleclick(sb.calanderdate_val);
		waitThread(2000);

		// Assert calendar not visible
		Assert.assertFalse(isElementPresent(sb.peeropen_calendar), "Calendar   present");

		Assert.assertTrue(isElementPresent(sb.peerOpenFilledTime), "time not visible");

		waitThread(1000);
		click(sb.peerreviewduedate_txtbx);
		waitThread(1000);

		// Assert calendar visible
		// Assert.assertTrue(isElementPresent(sb.peerdue_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.peerDue_calendar, "class").contains("p-calendar p-focus"));

		waitThread(1000);
		// Select the Peer Review Window Due date
		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		// Assert calendar not visible
		Assert.assertFalse(isElementPresent(sb.peerdue_calendar), "Calendar not  present");

		Assert.assertTrue(isElementPresent(sb.peerduefilledtime), "time not visible");

	}

	/*
	 * To verify the valiation messages[for Result publishing date] when click
	 * on save and next andsave and exit buttons
	 */
	@Test(priority = 40)
	public void TCSPR0901040() {

		// Click Save&Next button
		click(pr.savennext_button);
		waitFor(QP.toaster);

		// Assert toaster"Result publishing date and time is mandatory"
		Assert.assertEquals(getText(QP.toaster), "Result publishing date and time is mandatory");

		click(QP.toasterclosebtn);

		// Click Save&Exit button
		click(pr.savenexit_button);
		waitFor(QP.toaster);

		// Assert toaster"Result publishing date and time is mandatory"
		// Assert.assertEquals(getText(QP.toaster), "Result publishing date and
		// time is mandatory");
		/*
		 * Assert.assertEquals(getText(QP.toaster),
		 * "Result publishing date and time is mandatory\n" + "\n"
		 * +" Assessment Open date should not be past date and time");
		 */

		click(QP.toasterclosebtn);
		waitThread(1000);

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		click(sb.clearall_btn);
		waitThread(1000);
		click(sb.confyes_btn);

		// Assert the toaster "Cleared successfully"
		waitFor(pr.assessmentde_toaster);
		Assert.assertEquals(getText(pr.assessmentde_toaster), "Cleared successfully");

		// Assert the Clear all button is disable
		Assert.assertFalse(isEnabled(sb.clearall_btn), "button enabled");

	}

	/*
	 * To fill the Result publishing date and time
	 */
	@Test(priority = 41)
	public void TCSPR0901041() {

		waitThread(1000);

		// Select the Result publishing date
		click(sb.resultpublishdate_txtbx);
		waitThread(1000);

		// Assert calendar visible
		// Assert.assertTrue(isElementPresent(sb.resultpublish_calendar),
		// "Calendar not present");
		Assert.assertTrue(getAttribute(sb.resultPublishclndr, "class").contains("p-calendar p-focus"));

		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		//// Assert calendar not visible
		Assert.assertFalse(isElementPresent(sb.resultpublish_calendar), "Calendar   present");
		waitThread(1000);

		// Assert the time visible on the text box
		Assert.assertTrue(isElementPresent(sb.resultfilledtime), "time not visible");

	}

	/*
	 * To verify the Open/Due date and time of Test window when selecting
	 * current date -To verify the Test Window Open and Due time having 1 min
	 * Difference
	 */
	@Test(priority = 42)
	public void TCSPR0901042() {

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		click(pr.savenexit_button);
		waitFor(QP.toaster);

		// Assert toaster"Assessment Open date and time is mandatory"
		/*
		 * Assert.assertEquals(getText(QP.toaster),
		 * "Assessment Open date and time is mandatory\n" + "\n" +
		 * " Assessment Due date should not be past date and time");
		 */

		// click(QP.toasterclosebtn);
		waitThread(8000);
		cm.ScrollHome();

		// Click on Clear All button
		click(sb.clearall_btn);
		waitThread(1000);
		click(sb.confyes_btn);

		waitFor(pr.assessmentde_toaster);

		// *Assert the toaster "Cleared successfully"
		Assert.assertEquals(getText(pr.assessmentde_toaster), "Cleared successfully");

		// Assert the Clear all button is disable
		Assert.assertFalse(isEnabled(sb.clearall_btn), "button enabled");

		// Select the Test Window Open date as today's date
		Doubleclick(sb.assessmentopendate_txtbx);
		waitThread(1000);

		// Assert.assertTrue(isElementPresent(sb.assessopen_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.assessmentOpenclndr, "class").contains("p-calendar p-focus"));

		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		// Assert the date selected on the textbox
		Assert.assertEquals(getValue(sb.assessmentopendate_txtbx), sb.getdate());

		Assert.assertTrue(isElementPresent(sb.Assessopenfilledtime), "time not visible");

		waitThread(1000);

		// Select the Test Window Due date as today's date
		click(sb.assessmentduedate_txtbx);
		waitThread(1000);

		// Assert.assertTrue(isElementPresent(sb.assessdue_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.Assessdue_calendar, "class").contains("p-calendar p-focus"));

		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		Assert.assertFalse(isElementPresent(sb.assessdue_calendar), "Calendar   present");
		waitThread(1000);

		// Assert the Test Window Open time and Due time having 1 min difference
		Assert.assertEquals(sb.geTtimedifferenceminute(sb.assessmentopentime_txtbx, sb.assessmentduetime_txtbx), "1");

	}

	/*
	 * To verify the Open/Due date and time of Peer review window when selecting
	 * current date --To verify the Peer review Open/Due time having 1 min
	 * Difference
	 */
	@Test(priority = 43)
	public void TCSPR0901043() {

		waitThread(1000);

		// Select the Peer review Window Open date as today's date
		click(sb.peerreviewopendate_txtbx);
		waitThread(2000);

		// Assert.assertTrue(isElementPresent(sb.peeropen_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.peerOpen_calendar, "class").contains("p-calendar p-focus"));

		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		Assert.assertFalse(isElementPresent(sb.peeropen_calendar), "Calendar not  present");

		// Assert the time on the text box
		Assert.assertEquals(getValue(sb.peerreviewopendate_txtbx), sb.getdate());

		// Select the Peer review Due date as today's date
		click(sb.peerreviewduedate_txtbx);
		waitThread(1000);

		// Assert.assertTrue(isElementPresent(sb.peerdue_calendar), "Calendar
		// not present");
		Assert.assertTrue(getAttribute(sb.peerDue_calendar, "class").contains("p-calendar p-focus"));

		Doubleclick(sb.calanderdate_val);
		waitThread(3000);

		Assert.assertFalse(isElementPresent(sb.peerdue_calendar), "Calendar not  present");
		waitThread(1000);

		// Assert the Peer review Open time and Due time having 01 min
		// difference
		Assert.assertEquals(sb.geTtimedifferenceminute(sb.peerreviewopentime_txtbx1, sb.peerreviewduetime_txtbx), "1");

	}

	/*
	 * To Add a new questions from question page
	 */
	@Test(priority = 44)
	public void TCSPR0901044() {

		// Click on Question wizard
		click(pr.question_wizard);

		// Click Discard button on popup
		click(sb.confdiscard_btn);

		waitThread(1000);

		// Assert + button to add more questions
		Assert.assertTrue(isElementPresent(mq.add_quest_btn), "Add more question button not present");
		waitThread(1000);

		// Click on +button
		click(mq.add_quest_btn);
		waitThread(1000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question2");

		driver.switchTo().defaultContent();

		// Page scroll down
		/*
		 * QP.Scroll_DowntoEnd(); waitThread(6000);
		 * 
		 * // Click rubric drop down click(QP.rubric_drp_btn); waitThread(3000);
		 * 
		 * // Click Standard rubric radio button click(QP.std_rad);
		 */

	}

	public String maxscore;

	/*
	 * To Add a new questions from question page
	 */
	@Test(priority = 45)
	public void TCSPR0901045() {

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

		waitThread(2000);
		// Click Save button
		click(QP.save);
		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully "
		Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully");
		click(QP.toasterclosebtn);
		waitThread(2000);

		maxscore = getText(QP.max_scoreposs_value);

		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

	}

	/*
	 * To check that the new question added and maximum score count updating on
	 * the schedule page
	 */
	@Test(priority = 46)
	public void TCSPR0901046() {

		click(pr.savennext_button);
		waitThread(4000);

		// Assert the schedule wizard is selected
		Assert.assertTrue(isEnabled(sb.schedule_wizard), "schedule wizard is not selected");

		// Assert the maximum score possible is same as that in the question
		// page
		Assert.assertEquals(getText(sb.maxscorecount), maxscore);

		// Assert the total question number count is 2
		Assert.assertEquals(getText(sb.quescount_lbl), "2");

	}

	/*
	 * To perform Logout TeacherAccount functionality
	 */
	@Test(priority = 47)
	public void TCSPR0901047() {

		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

}
