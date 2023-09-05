package TestWindowOfIndividualStudent;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

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

import CommonFunctionalities.Test.CommonFileTest;
import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import CreateNewAssessment.Pages.AssessmentPublishPopupPage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.BasicDetailsPageCourseandEditorPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.AssessmentStatusPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import NewAssessmentOfTeacherPage.TeacherResultSectionPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class StudentAssessmentInfoAndInstructionTest extends basePage {

	LoginPage lg = new LoginPage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	Databaseconnection dc = new Databaseconnection();
	CourseRosterPage cr = new CourseRosterPage();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	SchedulePageBasicsPage sb = new SchedulePageBasicsPage();
	AssessmentPublishPopupPage ap = new AssessmentPublishPopupPage();
	TeacherPeerReviewSectionPage tp = new TeacherPeerReviewSectionPage();
	TeacherResultSectionPage tr = new TeacherResultSectionPage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	BasicDetailsPageCourseandEditorPage be = new BasicDetailsPageCourseandEditorPage();
	StudentAssessmentInfoAndInstructionPage sa = new StudentAssessmentInfoAndInstructionPage();
	CommonMethods cm = new CommonMethods();
	EncryptedText et = new EncryptedText();
	AssessmentStatusPage as = new AssessmentStatusPage();
	CommonFileTest cmt = new CommonFileTest();
	SignUpPage sp = new SignUpPage();
	public String AssessmentName;
	public String NewAssessmentName;
	public String newAssessmentName;
	public String newAssessmentNameone;
	public String Assessmentinfo;
	public String Assessmentinstruction;
	public String Emailteacher;
	public String CourseNamenew;
	public String CourseID1;
	public String Studentfirstname;
	public String Studentlastname;
	public String Studentfirstname2;
	public String Studentlastname2;
	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	/*
	 * To perform Login functionality
	 */
	@Test(priority = 1)
	public void TCSPR1200101() throws SQLException {

		Emailteacher = cmt.SignUpTeacher();
		System.out.println(Emailteacher);

		// To catch OTP from sending Resource
		cmt.OtpFetch();

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	public String Emailstudent1;
	public String Emailstudent2;

	/*
	 * To create new course
	 */
	@Test(priority = 2)
	public void TCSPR1200102() throws SQLException {

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
	public void TCSPR1200103() {

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
	public void TCSPR1200104() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent1, CourseID);

		String encText = et.EncryptCode(studentinviteid);
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
	public void TCSPR1200105() {

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
	 * To check that invited course request visible on first student 's profile
	 * and accept course request-Read the student name
	 */
	@Test(priority = 6)
	public void TCSPR1200106() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent2, CourseID);

		String encText = et.EncryptCode(studentinviteid);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname2 = "Ben";
		Studentlastname2 = "Max";
		Studentname2 = Studentfirstname2 + " " + Studentlastname2;
		waitThread(3000);
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
	public void TCSPR1200107() {

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

	public String CourseID = cm.CourseID1;
	public String CourseName = cm.CourseName1;

	/*
	 * To load the create new assessment page and fill details on the basic
	 * details page
	 */
	@Test(priority = 8)
	public void TCSPR1200108() {

		SoftAssert softAssert1 = new SoftAssert();
		lg.login1(Emailteacher, password);
		waitThread(4000);
		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(7000);
		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);
		waitThread(1000);
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

		softAssert1.assertEquals(getText(ba.lbl_assessmentinfo), "Assessment Information for Students",
				"Assertion  failed");

		softAssert1.assertAll();

	}

	/*
	 * To fill details on the Assessment info editor.To perform the Assessment
	 * Info Editor insert/edit image image upload functionality To upload an
	 * image file from the folder
	 */
	public String ImageURL = cm.ImageURL;

	@Test(priority = 9)
	public void TCSPR1200109() {

		Assessmentinfo = "Assessmentinfo" + generateRandomNumber().trim();
		driver.switchTo().frame("assessmentInfo_ifr");

		// Type Assessment info
		click(ba.editorplaceholder1);
		waitThread(1000);
		type(ba.editorplaceholder1, Assessmentinfo);

		driver.findElement(By.xpath(ba.editorplaceholder1)).sendKeys(Keys.ENTER);

		driver.switchTo().defaultContent();

	}

	/*
	 * To perform the Assessment Info Editor Insert/Edit Media upload
	 * functionality To upload a video file from the folder
	 */
	public String VideoURL = cm.VideoURL;

	@Test(priority = 10)
	public void TCSPR1200110() {

	}

	/*
	 * To perform the Assessment Info Editor Insert/Edit Link add functionality
	 */
	public String URL = cm.URL;

	@Test(priority = 11)
	public void TCSPR1200111() {

	}
	/*
	 * To fill details on the Assessment Instructions editor.To perform the
	 * Assessment Instructions for Students Editor insert/edit image image
	 * upload functionality To upload an image file from the folder
	 */

	@Test(priority = 12)
	public void TCSPR1200112() {

		driver.switchTo().defaultContent();
		waitThread(1000);
		Scroll_DowntoEnd();
		waitThread(2000);
		Assessmentinstruction = "Assessmentinstruction" + generateRandomNumber().trim();
		// To switch the frame
		driver.switchTo().frame("instructions_ifr");
		click(ba.editorplaceholder2);
		waitThread(1000);

		type(ba.editorplaceholder2, Assessmentinstruction);
		driver.findElement(By.xpath(ba.editorplaceholder2)).sendKeys(Keys.ENTER);

		driver.switchTo().defaultContent();

	}

	/*
	 * To perform the Assessment Instruction Editor Insert/Edit Media upload
	 * functionality
	 */

	@Test(priority = 13)
	public void TCSPR1200113() {

		driver.switchTo().defaultContent();
		click(ba.lbl_AssessmentInstru);
		driver.switchTo().frame("instructions_ifr");
		driver.findElement(By.xpath(ba.editorplaceholder2)).sendKeys(Keys.ENTER);
		driver.switchTo().defaultContent();
	}

	/*
	 * To perform the Assessment Instruction Editor Insert/Edit Link add
	 * functionality
	 */
	@Test(priority = 14)
	public void TCSPR1200114() {

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 15)
	public void TCSPR1200115() {

		driver.switchTo().defaultContent();
		waitThread(1000);
		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(1000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(5000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), AssessmentName);

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID + ", " + CourseName.trim());
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

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	public String Studentname = "Ashley Albert";
	public String Studentname2 = "Ben Alex";
	/*
	 * To verify the details on the peer review page
	 */

	@Test(priority = 16)
	public void TCSPR1200116() {

		waitThread(2000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Assert the first student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Studentname);

		// Assert the second student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Studentname2);
	}

	public String assessmentopendate;
	public String assessmentopentime;
	public String assessmentduedate;
	public String assessmentduetime;

	public String peerreviewopendate;
	public String peerreviewopentime;
	public String peerreviewduedate;
	public String peerreviewduetime;
	public String resultpublishdate;
	public String resultpublishtime;
	public String lastdateforrecon;
	public String lasttimeforrecon;
	/*
	 * To perform the save and next functionaity from peer review page and
	 * verify the schedule page details
	 */

	@Test(priority = 17)
	public void TCSPR1200117() {

		type(pr.PRreward_txtbox, "50");
		waitThread(3000);
		click(pr.savennext_button);
		// Check for toaster element's presence
		java.util.List<WebElement> toaster = driver.findElements(By.xpath(rs.toaster));
		if (toaster.size() != 0) {
			// Toaster message
			waitFor(rs.toaster);
			Assert.assertEquals(getText(QP.toaster), "Saved successfully");
			click(QP.toasterclosebtn);
		} else
			waitThread(5000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.Sbassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseName.trim()));

		// Read date and time
		assessmentopendate = getValue(sb.assessmentopendate_txtbx);
		assessmentopentime = getValue(sb.assessmentopentime_txtbx);
		assessmentduedate = getValue(sb.assessmentduedate_txtbx);
		assessmentduetime = getValue(sb.assessmentduetime_txtbx);

		peerreviewopendate = getValue(sb.peerreviewopendate_txtbx);
		peerreviewopentime = getValue(sb.peerreviewopentime_txtbx1);
		peerreviewduedate = getValue(sb.peerreviewduedate_txtbx);
		peerreviewduetime = getValue(sb.peerreviewduetime_txtbx);

		ScrollTo_xy_position(0, 250);
		waitThread(1000);

		resultpublishdate = getValue(sb.resultpublishdate_txtbx);
		resultpublishtime = getValue(sb.resultpublishtime_txtbx);

		Scroll_DowntoEnd();
		waitThread(1000);

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		// Click on save and next button
		click(pr.savennext_button);
		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");
		// Assert the label assessment name,

	}

	/*
	 * To perform Assessment publish functionality
	 */
	@Test(priority = 18)
	public void TCSPR1200118() {

		waitThread(2000);
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
	 * To check the published Assessment card
	 */
	@Test(priority = 19)
	public void TCSPR1200119() {

		// Click on Back to menu button
		click(ap.Backtomenu_btn);

		waitThread(2000);

		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(ap.publish_popup), "popup not visible");

		// Assert the Current Assessment is selected
		Assert.assertEquals(getAttribute(ap.currentassess_tab, "aria-selected"), "true");

		// search newly created assessment
		type(sa.search_box, AssessmentName);
		waitThread(5000);

		// Assert the newly published card visible on the current assessment
		// page
		Assert.assertTrue(isElementPresent(sa.newcard), " new assessment card not visible");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(sa.asses_name_card), AssessmentName);

	}

	/*
	 * To perform log out functionality
	 */
	@Test(priority = 20)
	public void TCSPR1200120() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To login as Student and to check the Assessment status
	 */
	@Test(priority = 21)
	public void TCSPR1200121() {

		waitThread(1000);

		lg.login1(Emailstudent1, password);

		waitThread(7000);
		// Click Assessment tab
		click(QP.Assessmenttab);
		waitThread(3000);
		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		// driver.findElement(By.id("searchAssessmentFilter")).sendKeys(" ");
		waitThread(3000);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(sa.Assess_name_card), AssessmentName);
	}

	/*
	 * To check the test section of Assessment card
	 */
	@Test(priority = 22)
	public void TCSPR1200122() throws InterruptedException {

		// Wait till Test active
		TimeUnit.MINUTES.sleep(1);
		// Wait till Test active
		TimeUnit.SECONDS.sleep(70);
		// Assert.assertEquals(getText(sa.test_sts), "Active");

		int l = getText(sa.testopendatetime).length();
		String text = getText(sa.testopendatetime).substring(0, 11);
		System.out.println(text);
		System.out.println("length" + l);
		if (l == 20) {
			// Assert the test open date & time of card is same as Reschedule
			// date popup
			Assert.assertEquals(sa.getdate(sa.testopendatetime, 0, 11), assessmentopendate);

			waitThread(1000);
			int testopentimevalue0 = Integer.valueOf(assessmentopentime.substring(0, 1));
			System.out.println(testopentimevalue0);

			if (testopentimevalue0 == 0) {

				Assert.assertEquals(getText(sa.testopendatetime).substring(13, 20), assessmentopentime.substring(1, 8));

			} else if (testopentimevalue0 != 0) {

				Assert.assertEquals(getText(sa.testopendatetime).substring(13, 20), assessmentopentime);

			}

			// Assert the Assessment due date and time with Reschedule date
			// popup
			// Assert.assertEquals(as.getdate(sa.testduedatetime, 0, 11),
			// assessmentduedate);
		} else if (l == 21) {

			// Assert the test open date & time of card is same as Reschedule
			// date popup
			Assert.assertEquals(sa.getdate(sa.testopendatetime, 0, 12), assessmentopendate);

			waitThread(1000);
			int testopentimevalue0 = Integer.valueOf(assessmentopentime.substring(0, 1));
			System.out.println(testopentimevalue0);

			if (testopentimevalue0 == 0) {

				Assert.assertEquals(getText(sa.testopendatetime).substring(14, 21), assessmentopentime.substring(1, 8));

			} else if (testopentimevalue0 != 0) {

				Assert.assertEquals(getText(sa.testopendatetime).substring(14, 21), assessmentopentime);
			}
			// Assert the test due date & time is same card as Reschedule date
			// popup
			// Assert.assertEquals(sa.getdate(sa.testduedatetime, 0, 12),
			// assessmentduedate);

		}

		Assert.assertTrue(isElementPresent(sa.begintest_btn), "Button not present");
	}

	/*
	 * To check the begin test button functionality and check the assessmnt info
	 * popup
	 */
	@Test(priority = 23)
	public void TCSPR1200123() throws InterruptedException {

		waitThread(2000);
		// click begin test
		click(sa.begintest_btn);
		waitThread(3000);

		// Assert heading "Assessment Information"
		Assert.assertEquals(getText(sa.assessinfo_lbl), "Assessment Information");

		// Assert popup visible
		Assert.assertTrue(isElementPresent(sa.assessinfo_popup), "popup not present");

		driver.switchTo().frame("infoPopup_ifr");
		waitThread(3000);
		// Assert the added text visible
		Assert.assertEquals(getText(sa.addeddinfo_lbl), Assessmentinfo);
		waitThread(1000);


	}

	/*
	 * To check the assessment instruction functionality on the test window
	 */
	@Test(priority = 24)
	public void TCSPR1200124() {
		driver.switchTo().defaultContent();
		// Assert theclose button
		Assert.assertTrue(isElementPresent(sa.infoclose_btn), "popup not present");
		// Click on close button
		click(sa.infoclose_btn);
		waitThread(3000);

		Assert.assertEquals(getText(sa.assessinstr_lbl), "Assessment Instruction");
		Assert.assertTrue(isElementPresent(sa.assessinstru_popup), "popup not present");

		driver.switchTo().frame("instructPopup_ifr");
		// Assert the added text visible
		waitThread(2000);

		Assert.assertEquals(getText(sa.addeddinstruc_lbl), Assessmentinstruction);


	}

	/*
	 * To check the Assessment info button functionality on the test window
	 */
	@Test(priority = 25)
	public void TCSPR1200125() {
		driver.switchTo().defaultContent();

		// Assert close button
		Assert.assertTrue(isElementPresent(sa.instruclose_btn), "Button not present");
		click(sa.instruclose_btn);
		waitThread(5000);
		Assert.assertTrue(isElementPresent(sa.assessinfo_btn), "Button not present");

		click(sa.assessinfo_btn);
		waitThread(1000);
		Assert.assertEquals(getText(sa.assessinfo_lbl), "Assessment Information");
		Assert.assertTrue(isElementPresent(sa.assessinfo_popup), "popup not present");

		driver.switchTo().frame("infoPopup_ifr");
		// Assert the added text visible
		Assert.assertEquals(getText(sa.addeddinfo_lbl), Assessmentinfo);
		driver.switchTo().defaultContent();

		// Assert close button
		Assert.assertTrue(isElementPresent(sa.infoclose_btn), "popup not present");

	}

	/*
	 * To check the Assessment instruction button functionality on the test
	 * window
	 */
	@Test(priority = 26)
	public void TCSPR1200126() {

		// Click on close button
		click(sa.infoclose_btn);
		waitThread(1000);

		// Assert button Assessment Instruction
		Assert.assertTrue(isElementPresent(sa.assessinstru_btn), "Button not present");

		// click button Assessment Instruction
		click(sa.assessinstru_btn);
		waitThread(1000);

		Assert.assertEquals(getText(sa.assessinstr_lbl), "Assessment Instruction");
		Assert.assertTrue(isElementPresent(sa.assessinstru_popup), "popup not present");

		driver.switchTo().frame("instructPopup_ifr");
		// Assert the added text visible

		Assert.assertEquals(getText(sa.addeddinstruc_lbl), Assessmentinstruction);
		driver.switchTo().defaultContent();

	}

	/*
	 * To perform logout functionality from student profile
	 */
	@Test(priority = 27)
	public void TCSPR1200127() {

		click(sa.instruclose_btn);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(sa.assessinstru_popup), "popup not present");
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To load the create new assessment page and fill details on the basic
	 * details page
	 */
	@Test(priority = 28)
	public void TCSPR1200128() {

		lg.login1(Emailteacher, password);
		waitThread(2000);
		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	/*
	 * To load the create new assessment page and fill details on the basic
	 * details page
	 */
	@Test(priority = 29)
	public void TCSPR1200129() {

		SoftAssert softAssert1 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(7000);
		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);
		waitThread(7000);
		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		softAssert1.assertEquals(getText(ba.ddcoursename1), CourseName.trim(),
				"course name not visible on the dropdown");

		click(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		NewAssessmentName = "History" + generateRandomNumber().trim();

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

		softAssert1.assertAll();

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 30)
	public void TCSPR1200130() {

		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question1");

		driver.switchTo().defaultContent();

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
		// Assert a toaster Saved successfully
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
	@Test(priority = 31)
	public void TCSPR1200131() {
		waitThread(2000);

		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + NewAssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		type(pr.PRreward_txtbox, "50");
		waitThread(3000);

		click(pr.savennext_button);

		waitThread(5000);
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");
		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);

		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.Sbassessmentname_lbl).contains("Assessment Name: " + NewAssessmentName));

	}

	/*
	 * To perform the save and next functionaity from peer review page and
	 * verify the schedule page details
	 */
	@Test(priority = 32)
	public void TCSPR1200132() {

		ScrollTo_xy_position(0, 0);
		waitThread(1000);
		click(pr.savennext_button);
		waitThread(2000);

		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");
		waitThread(2000);
	}

	/*
	 * To select the dates from the schedule page,select the Test open and due
	 * dates
	 */
	@Test(priority = 33)
	public void TCSPR1200133() {

		waitThread(5000);
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
	 * To check the published Assessment card
	 */
	@Test(priority = 34)
	public void TCSPR1200134() {

		// Click on Back to menu button
		click(ap.Backtomenu_btn);

		waitThread(7000);

		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(ap.publish_popup), "popup not visible");

		// Assert the Current Assessment is selected
		Assert.assertEquals(getAttribute(ap.currentassess_tab, "aria-selected"), "true");

		// search newly created assessment
		type(sa.search_box, NewAssessmentName);
		waitThread(1000);

		// Assert the newly published card visible on the current assessment
		// page
		Assert.assertTrue(isElementPresent(sa.newcard), " new assessment card not visible");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(sa.asses_name_card), NewAssessmentName);

	}

	/*
	 * To perform logout functionality from teacher profile
	 */
	@Test(priority = 35)
	public void TCSPR1200135() {
		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To login as Student and to check the Assessment status
	 */
	@Test(priority = 36)
	public void TCSPR1200136() {

		lg.login1(Emailstudent2, password);

		waitThread(5000);

		Doubleclick(sa.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(NewAssessmentName);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(" ");
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(sa.published_card), "Published Assessment card not visible");

		// Assert the Assessment name, course name , Id on the card
		Assert.assertEquals(getText(sa.Assess_name_card), NewAssessmentName);

	}

	/*
	 * To check that the assessment Instruction and Info popups are not visible
	 */
	// @Test(priority = 37)
	public void TCSPR1200137() {

		waitFor(sa.begintest_btn);
		// Click on Begin Test Button
		click(sa.begintest_btn);
		waitThread(1000);

		// Assert the info popup not visible
		Assert.assertFalse(isElementPresent(sa.assessinfo_popup), "popup not present");

		// Assert the Instruction popup not visible
		Assert.assertFalse(isElementPresent(sa.assessinstru_popup), "popup not present");

		// Assert Buttons
		Assert.assertFalse(isElementPresent(sa.assessinfo_btn), "Button not present");
		Assert.assertFalse(isElementPresent(sa.assessinstru_btn), "Button not present");

	}

	/*
	 * To perform Delete Student 2 Account functionality
	 */
	@Test(priority = 38)
	public void TCSPR1200138_DeleteStudent1() {

		waitThread(3000);
		cr.DeleteAccount();

		waitThread(2000);

		// login using deleted account credentials
		lg.login(Emailstudent2, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student2 Account functionality
	 */
	@Test(priority = 39)
	public void TCSPR1200139_DeleteStudent2() {

		// login using deleted account credentials
		lg.login1(Emailstudent1, password);
		waitThread(2000);
		cr.DeleteAccount();
		waitThread(2000);

		// login using deleted account credentials
		lg.login(Emailstudent1, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete Teacher Account functionality
	 */
	@Test(priority = 40)
	public void TCSPR1200140_DeleteTeacher() {

		// login using deleted account credentials
		lg.login1(Emailteacher, password);
		waitThread(2000);
		cr.DeleteAccount();

		waitThread(2000);

		// login using deleted account credentials
		lg.login(Emailteacher, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

}