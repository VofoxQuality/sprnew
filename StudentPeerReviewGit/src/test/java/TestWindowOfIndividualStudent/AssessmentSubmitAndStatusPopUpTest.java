package TestWindowOfIndividualStudent;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import CommonFunctionalities.Test.CommonFileTest;
import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import Course.Pages.EditCoursePage;
import Course.Test.EditCourseTest;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.MultipleQuestionsAddPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CreateNewAssessment.Pages.SummarySchedulePage;
import CreateNewAssessment.Test.BasicDetailsAssessmentTest;
import CreateNewAssessment.Test.SummaryBasicsTest;
import CurrentAssessmentsforStudents.Pages.StudentCurrentAssessmentBasicsPage;
import CurrentAssessmentsforStudents.Pages.StudentTestSectionPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.NewAssessmentTeacherBasicsPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class AssessmentSubmitAndStatusPopUpTest extends basePage {

	LoginPage lg = new LoginPage();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	MultipleQuestionsAddPage mq = new MultipleQuestionsAddPage();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	EditCoursePage ec = new EditCoursePage();
	BasicDetailsAssessmentTest bdt = new BasicDetailsAssessmentTest();
	SchedulePageBasicsPage sbp = new SchedulePageBasicsPage();
	SummaryBasicsPage sb = new SummaryBasicsPage();
	SummaryBasicsTest sbt = new SummaryBasicsTest();
	SummarySchedulePage sshp = new SummarySchedulePage();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	EditCourseTest ect = new EditCourseTest();
	Databaseconnection dc = new Databaseconnection();
	TeacherTestSectionPage tts = new TeacherTestSectionPage();
	StudentTestSectionPage st1 = new StudentTestSectionPage();
	SchedulePageBasicsPage sb1 = new SchedulePageBasicsPage();
	NewAssessmentTeacherBasicsPage natb = new NewAssessmentTeacherBasicsPage();
	CourseRosterPage cr = new CourseRosterPage();
	CommonMethods cm = new CommonMethods();
	EncryptedText et = new EncryptedText();
	SignUpPage sp = new SignUpPage();
	StudentCurrentAssessmentBasicsPage sca = new StudentCurrentAssessmentBasicsPage();
	AssessmentSubmitAndStatusPopUpPage asp = new AssessmentSubmitAndStatusPopUpPage();
	CommonFileTest cmt = new CommonFileTest();
	public String Studentfirstname;
	public String Studentlastname;
	public String Studentname;
	public String Studentfirstname2;
	public String Studentlastname2;
	public String Studentname2;
	public String CourseID = cm.CourseID1;
	public String CourseName = cm.CourseName1;
	public String Emailteacher;
	public String AssessmentName;
	public String Student1name = "Ashley Albert";
	public String Student2name = "Ben Alex";
	public String Emailstudent1;
	public String Emailstudent2;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	/*
	 * To perform Login functionality
	 */
	@Test(priority = 1)
	public void TCSPR1200401() throws SQLException {

		Emailteacher = cmt.SignUpTeacher();

		// To catch OTP from sending Resource
		cmt.OtpFetch();

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	/*
	 * To create new course
	 */
	@Test(priority = 2)
	public void TCSPR1200402() {

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
	public void TCSPR1200403() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	public String studentinviteid;

	/*
	 * To check that invited course request visible on first student 's profile
	 * and accept course request-Read the student name
	 */
	@Test(priority = 4)
	public void TCSPR1200404() throws SQLException {

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
	public void TCSPR1200405() {

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
	public void TCSPR1200406() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent2, CourseID);

		String encText = et.EncryptCode(studentinviteid);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname2 = "Ben";
		Studentlastname2 = "Alex";
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
	public void TCSPR1200407() {

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
	public void TCSPR1200408() {

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

		// To click on course drop down
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		softAssert1.assertEquals(getText(ba.ddcoursename1), CourseName.trim(),
				"course name not visible on the dropdown");

		click(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentName = "History" + generateRandomNumber().trim();

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
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID + ", " + CourseName.trim());

		softAssert1.assertAll();

	}

	/*
	 * To fill details for Question 1
	 */
	@Test(priority = 9)
	public void TCSPR1200409() {

		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question 1");

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
		type(QP.max_scorbx, "10");

		// Click on +button
		click(mq.add_quest_btn);
		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);

	}

	/*
	 * To fill details for Question 2
	 */
	@Test(priority = 10)
	public void TCSPR1200410() {
		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question 2");

		driver.switchTo().defaultContent();

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
		type(QP.max_scorbx, "20");

		// Click on +button
		click(mq.add_quest_btn);
		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully");
		click(QP.toasterclosebtn);

	}

	/*
	 * To fill details for Question 3
	 */
	@Test(priority = 11)
	public void TCSPR1200411() {
		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question 3");

		driver.switchTo().defaultContent();

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "30");
		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 3 Saved successfully");
		click(QP.toasterclosebtn);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	/*
	 * To verify the details on the peer review page
	 */
	@Test(priority = 12)
	public void TCSPR1200412() {

		waitThread(2000);

		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert labels:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

	}

	/*
	 * To perform the save and next functionality from peer review page and
	 * verify the schedule page details
	 */
	@Test(priority = 13)
	public void TCSPR1200413() {

		// Type peer review reward score
		type(pr.PRreward_txtbox, "100");
		waitThread(1000);

		click(pr.savennext_button);
		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);
		waitThread(2000);
		Assert.assertEquals(getAttribute(sbp.schedule_wizard, "aria-expanded"), "true");

		// Assert the label assessment name,
		Assert.assertTrue(getText(sbp.Sbassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert labels:
		Assert.assertTrue(getText(sbp.Sbcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(sbp.Sbcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(sbp.Sbcoursename_lbl).contains(CourseName.trim()));

	}

	/*
	 * To perform Assessment publish functionality
	 */
	@Test(priority = 14)
	public void TCSPR1200414() {

		// Click Save&Next button
		click(QP.savenext_btn);
		waitThread(1000);

		// click on Release Button
		click(sb.btnrelease);

		waitFor(QP.toaster);
		// Assert toaster "Assessment published successfully
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");
		click(QP.toasterclosebtn);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(natb.publishpopup), "Publish popup not visible");

	}

	/*
	 * To check the back to menu button functionality and check the created
	 * assessment visible on the current assessment tab
	 */
	@Test(priority = 15)
	public void TCSPR1200415() {

		waitThread(4000);
		// click on Back To Menu Button
		click(natb.btnbacktomenu);
		Assert.assertFalse(isElementPresent(natb.publishpopup), "Publish popup  visible");
		waitThread(2000);

		// Search The Assessment Name
		type(sca.teacherassessmentsearchbox, AssessmentName.trim());
		waitThread(1000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(2000);

		// Assert the Assessment name visible
		Assert.assertEquals(getText(natb.cardassessmentname1), AssessmentName);
		Assert.assertEquals(getText(natb.cardcoursename1), "For" + " " + CourseName.trim() + " (" + CourseID + ")");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 16)
	public void TCSPR1200416() {

		waitThread(2000);
		// Perform logout
		sca.Logout();
		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
		waitThread(2000);
	}

	/*
	 * Perform Login functionality as student 1
	 */
	@Test(priority = 17)
	public void TCSPR1200417() {

		lg.login1(Emailstudent1, password);

		waitThread(7000);

		// click on Assessments Tab
		click(sca.Assessmenttab);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");

	}

	public String timertext;

	/*
	 * To search the assessment name and check the details
	 */
	@Test(priority = 18)
	public void TCSPR1200418() throws InterruptedException {

		waitThread(6000);
		// Search The Assessment Name
		type(sca.searchbox, AssessmentName.trim());
		// driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(3000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");

		// Assert the Assessment name and course name visible on the card
		Assert.assertEquals(getText(natb.cardassessmentname1), AssessmentName);
		Assert.assertEquals(getText(natb.cardcoursename1), "For" + " " + CourseName.trim() + " (" + CourseID + ")");

		// verify the teacher name
		Assert.assertEquals(getText(asp.teachernameoncard), Teachername);

		// To verify the begin test button visible or not

		if (isElementPresent((asp.btnbeginTest)) == true) {

			waitThread(3000);
			// click on Begin Test button
			click(asp.btnbeginTest);
			Assert.assertTrue(isElementPresent(asp.Questionwizard), "Test Window page not visible");
		}

		else {

			// wait for 1 min
			TimeUnit.MINUTES.sleep(1);
			TimeUnit.SECONDS.sleep(70);
			waitThread(1000);

			waitThread(2000);
			// To verify the begin test button visible
			// Assert.assertTrue(isElementPresent(asp.btnbeginTest), "Begin Test
			// button Not visible");
			waitThread(3000);

		}
	}

	/*
	 * To load the test window and check that the details on the Test window
	 */
	@Test(priority = 19)
	public void TCSPR1200419() {
		// click on begin test button
		click(asp.btnbeginTest);
		Assert.assertTrue(isElementPresent(asp.Questionwizard), "Test Window page not visible");

		// To check the course name,assessment name,teacher name and timer
		waitThread(2000);
		Assert.assertEquals(getText(asp.testassessmentname), AssessmentName.trim());
		Assert.assertEquals(getText(asp.testcoursename), "Course: " + CourseID + "," + " " + CourseName.trim());
		Assert.assertEquals(getText(asp.testeachername), "Teacher: " + Teachername);

	}

	/*
	 * To attend test with completed answer functionality
	 */
	@Test(priority = 20)
	public void TCSPR1200420() {

		// To enter the data on Question box
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);

		type(asp.Answertextbx, "Answer 1");
		waitThread(1000);

		driver.switchTo().defaultContent();

		// click on save button
		click(asp.testbtnsave);
		waitFor(QP.toaster);

		// Assert the toaster "Answer Saved"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");
		click(QP.toasterclosebtn);
		waitThread(3000);
		Assert.assertTrue(getAttribute(asp.wizardans1, "class").contains("complete"));

		// click on save and exit button
		click(asp.testbtnsaveandexit);

		waitThread(3000);
		// To check the current assessment tab is selected
		Assert.assertEquals(getAttribute(sca.selectedcurrenttab, "aria-selected"), "true");

	}

	/*
	 * To perform logout functionality on the student profile
	 */
	@Test(priority = 21)
	public void TCSPR1200421() {

		waitThread(4000);
		// Perform logout
		sca.Logout();
		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * To perform the teacher login functionality and check the assessment card
	 */
	@Test(priority = 22)
	public void TCSPR1200422() {

		waitThread(2000);
		lg.login1(Emailteacher, password);

		waitThread(5000);

		// click on Assessment Tab
		click(QP.teach_assesstab);

		waitThread(7000);
		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(3000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");

		// To verify the number of assessment cards
		Assert.assertEquals(TotalElementsCount(natb.cardcount), 1);
	}

	public String Quecount;

	/*
	 * To check the the details on the teacher test section view details page.
	 */
	@Test(priority = 23)
	public void TCSPR1200423() {

		waitThread(2000);
		// click on view details button
		click(asp.buttontestbegin);

		waitThread(2000);
		// To check the view details pop up visible
		Assert.assertTrue(isDisplayed(asp.viewdetailspopup), "View details popup not visible");

		// To check the student name
		Assert.assertEquals(getText(asp.Student1_name), Student1name);

		// To verify the percentage on the progress bar
		Assert.assertTrue(getAttribute(asp.progressbarstud1, "aria-valuenow").contains("33.33"));
		// To verify the Answer count
		Assert.assertEquals(getText(asp.popupQuestioncountstud1).substring(0, 1), "1");

		// click on view details close button
		click(asp.btncloseviewdetails);

		// To check that the view details pop up not visible
		Assert.assertFalse(isElementPresent(asp.viewdetailspopup), "View details popup visible");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 24)
	public void TCSPR1200424() {

		waitThread(4000);
		// Perform logout
		sca.Logout();
		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * To perform Login functionality of student 1 profile and check the
	 * Assessment card
	 */
	@Test(priority = 25)
	public void TCSPR1200425() {

		TCSPR1200417();

		waitThread(5000);
		// Search The Assessment Name
		type(sca.searchbox, AssessmentName.trim());
		waitThread(3000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		// To verify the number of assessment cards
		Assert.assertEquals(TotalElementsCount(natb.cardcount), 1);
	}
	/*
	 * To load the test window and fill with incomplete answer
	 */

	@Test(priority = 26)
	public void TCSPR1200426() {

		// To verify the button label-Resume Test
		Assert.assertEquals(getAttribute(asp.buttontestbegin, "label"), "Resume Test");

		// click on Resume test button
		click(asp.buttontestbegin);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(asp.Questionwizard), "Test Window page not visible");

		// To verify the first question is selected
		Assert.assertTrue(getAttribute(asp.wizardans1, "class").contains("p-highlight"));
		waitThread(1000);

		// click on Answer 2 wizard
		click(asp.wizardans2);

		// To verify the 2nd question wizard is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));
		// To verify the 1st question wizard is selected
		Assert.assertFalse(getAttribute(asp.wizardans1, "class").contains("p-highlight"));
		waitThread(1000);

		// To enter the data on Answer 2 box
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);
		type(asp.Answertextbx, "Answer 2");
		waitThread(1000);
		driver.switchTo().defaultContent();
		waitThread(1000);

		// click on my answer is incomplete check box
		click(asp.incompleteanschkbx);
		// To verify the my answer is incomplete check box is selected
		Assert.assertTrue(getAttribute(asp.incompletechked, "class").contains("p-checkbox-checked"));
		waitThread(1000);

		// click on save button
		click(asp.testbtnsave);
		waitFor(QP.toaster);
		// Assert the toaster "Answer Saved"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");
		waitThread(2000);
		// To verify the wizard status of question 2 is incomplete
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("incomplete"));

		// click on save and exit button
		waitThread(3000);
		click(asp.testbtnsaveandexit);
		waitThread(3000);
		// To verify the current assessment tab is selected
		waitThread(5000);
		Assert.assertEquals(getAttribute(sca.selectedcurrenttab, "aria-selected"), "true");

	}

	/*
	 * To perform logout functionality on the student 1 profile
	 */
	@Test(priority = 27)
	public void TCSPR1200427() {

		TCSPR1200416();

	}

	/*
	 * To perform the teacher login functionality and check the assessment card
	 */
	@Test(priority = 28)
	public void TCSPR1200428() {

		TCSPR1200422();
	}

	/*
	 * To check the the details on the test section view details page.
	 */
	@Test(priority = 29)
	public void TCSPR1200429() {

		waitThread(2000);
		// click on view details button
		click(asp.buttontestbegin);

		waitThread(2000);
		// To check the view details pop up visible
		Assert.assertTrue(isDisplayed(asp.viewdetailspopup), "View details popup not visible");

		// To check the student name
		Assert.assertEquals(getText(asp.Student1_name), Student1name);

		// To verify the percentage on the progress bar
		Assert.assertTrue(getAttribute(asp.progressbarstud1, "aria-valuenow").contains("66.66"));
		// To verify the Answer count
		Assert.assertEquals(getText(asp.popupQuestioncountstud1).substring(0, 1), "2");

		// click on view details close button
		click(asp.btncloseviewdetails);
		// // search newly created assessment
		// type(rd.search_box, AssessmentName);
		// waitThread(3000);
		//
		// // Assert the published Assessment card visible
		// Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card
		// not visible");
		// // To check that the view details pop up not visible
		// Assert.assertFalse(isElementPresent(asp.viewdetailspopup), "View
		// details popup visible");
		// waitThread(1000);

		// To verify the percentage on the teacher card
		Assert.assertEquals(getAttribute(asp.teachercardprogressbar, "aria-valuenow"), "0");
		// To verify the student count on the student card
		Assert.assertEquals(getText(asp.teachercardstudcount).substring(0, 1), "0");
	}

	/*
	 * To perform logout functionality on the student profile
	 */
	@Test(priority = 30)
	public void TCSPR1200430() {

		TCSPR1200416();
	}

	/*
	 * To perform Login functionality of student1 profile and check the
	 * Assessment card
	 */
	@Test(priority = 31)
	public void TCSPR1200431() {

		TCSPR1200425();
	}

	/*
	 * To load the test window and fill with 3rd answer
	 */
	@Test(priority = 32)
	public void TCSPR1200432() {

		// click on Resume Test button
		click(asp.buttontestbegin);
		waitThread(2000);

		Assert.assertTrue(isElementPresent(asp.Questionwizard), "Test Window page not visible");

		waitThread(2000);
		// To verify the 2nd question is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));
		waitThread(2000);

		// click on Answer 3
		click(asp.wizardans3);

		waitThread(2000);
		// To verify the Answer 3 wizard is selected
		Assert.assertTrue(getAttribute(asp.wizardans3, "class").contains("p-highlight"));
		click(asp.wizardans2);

		waitThread(2000);
		// To verify the Answer 3 wizard status is "In complete"
		Assert.assertTrue(getAttribute(asp.wizardans3, "class").contains("visitednotattended"));
		waitThread(1000);

		// click on Submit button
		click(asp.testbtnsubmit);

		waitThread(1000);
		// verify the test window confirmation pop up visible
		Assert.assertTrue(isElementPresent(asp.testwindowconfirmpopup), "Test Window confirmation pop up not visible");

		waitThread(1000);
		// to click the submit button on the confirmation pop up
		click(asp.confirmationsubmit);
		waitFor(QP.toaster);

		// verify toaster "Assessment Submitted"
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");
		click(QP.toasterclosebtn);

		waitThread(1000);
		// To verify the confirmation pop up not visible
		Assert.assertFalse(isElementPresent(asp.testwindowconfirmpopup), "Test Window confirmation pop up not visible");

	}

	/*
	 * To check the Test submit pop up functionality and check the labels
	 */
	@Test(priority = 33)
	public void TCSPR1200433() {

		// verify the Test submit pop up visible
		Assert.assertTrue(isElementPresent(asp.tstSubmitAnswerPopup), "Test confirmation pop up not visible");
		// To verify the labels
		Assert.assertEquals(getText(asp.tstsubmitlbl_1), "Answers Submitted Successfully");
		Assert.assertEquals(getText(asp.tstsubmitlbl_2), "You can also modify the answers later within the due date.\n"
				+ "You cannot make any modifications once the due date has expired.");

		// To verify the Back to Assessment button visible
		Assert.assertTrue(isElementPresent(asp.btnbacktoassessment), "Back to Assessment button not visible");
		// To verify the label
		Assert.assertEquals(getText(asp.lbl_backtoassessment), "Back to Assessments");

		// click on back to Assessment button
		click(asp.btnbacktoassessment);

		// To verify the Test confirmation pop up not visible
		Assert.assertFalse(isElementPresent(asp.tstSubmitAnswerPopup), "Test confirmation pop up visible");
		waitThread(1000);
		// To verify the current assessment tab is not visible
		Assert.assertEquals(getAttribute(sca.selectedcurrenttab, "aria-selected"), "true");
	}

	/*
	 * To perform logout functionality on the student 1 profile
	 */
	@Test(priority = 34)
	public void TCSPR1200434() {

		TCSPR1200416();
	}

	/*
	 * To perform the teacher login functionality and check the assessment card
	 */
	@Test(priority = 35)
	public void TCSPR1200435() {

		TCSPR1200422();
	}

	/*
	 * To check the the details on the test section view details page.
	 */
	@Test(priority = 36)
	public void TCSPR1200436() {

		// click on view details button
		click(asp.buttontestbegin);
		waitThread(1000);
		// view details pop up not visible
		Assert.assertTrue(isDisplayed(asp.viewdetailspopup), "View details popup not visible");

		// To verify the student name on the card
		Assert.assertEquals(getText(asp.Student1_name), Student1name);

		// To verify the student 1 answer percentage on the progress bar
		Assert.assertTrue(getAttribute(asp.progressbarstud1, "aria-valuenow").contains("66.66"));

		// To verify the student 1 answer count on the view details page
		Assert.assertEquals(getText(asp.popupQuestioncountstud1).substring(0, 1), "2");
		Assert.assertEquals(getText(asp.popupQuestioncountstud1), "2/3");

		// click close button
		click(asp.btncloseviewdetails);
		Assert.assertFalse(isElementPresent(asp.viewdetailspopup), "View details popup visible");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 37)
	public void TCSPR1200437() {

		TCSPR1200416();
	}

	/*
	 * To perform Login functionality of student 2 profile and check the
	 * Assessment card
	 */

	@Test(priority = 38)
	public void TCSPR1200438() {

		waitThread(2000);
		lg.login1(Emailstudent2, password);
		waitThread(2000);

		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		waitThread(5000);

		// Search The Assessment Name
		type(sca.searchbox, AssessmentName.trim());
		waitThread(3000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		// To verify the number of assessment cards
		Assert.assertEquals(TotalElementsCount(natb.cardcount), 1);

	}

	/*
	 * To load the test window and check that the details on the Test window
	 */
	@Test(priority = 39)
	public void TCSPR1200439() {

		// verify the button label
		Assert.assertEquals(getAttribute(asp.buttontestbegin, "label"), "Begin Test");
		waitThread(1000);

		// click on begin test button
		click(asp.btnbeginTest);
		Assert.assertTrue(isElementPresent(asp.Questionwizard), "Test Window page not visible");
		waitThread(2000);

		// verify the course name,assessment name,teacher name
		Assert.assertEquals(getText(asp.testassessmentname), AssessmentName.trim());
		Assert.assertEquals(getText(asp.testcoursename), "Course: " + CourseID + "," + " " + CourseName.trim());
		Assert.assertEquals(getText(asp.testeachername), "Teacher: " + Teachername);

	}

	/*
	 * To attend test and fill answer 1 functionality
	 */
	@Test(priority = 40)
	public void TCSPR1200440() {

		// To enter the data on Question box
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);
		type(asp.Answertextbx, "Answer 1");
		waitThread(1000);
		driver.switchTo().defaultContent();

		// Click on save Button
		click(asp.testbtnsave);
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");
		click(QP.toasterclosebtn);
		waitThread(3000);

		// click on Answer 2 wizard
		click(asp.wizardans2);
		// To verify the Answer 2 is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));

	}

	/*
	 * To attend test with incomplete answer functionality
	 * 
	 */
	@Test(priority = 41)
	public void TCSPR1200441() {

		// To fill the Answer 2
		waitThread(1000);
		// To enter the data on Question box
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);
		type(asp.Answertextbx, "Answer 2");
		waitThread(1000);
		driver.switchTo().defaultContent();

		// Click on my answer is incomplete check box
		click(asp.incompleteanschkbx);
		Assert.assertTrue(getAttribute(asp.incompletechked, "class").contains("p-checkbox-checked"));
		waitThread(1000);

		// click on save button
		click(asp.testbtnsave);
		waitFor(QP.toaster);
		// Assert the toaster "Answer Saved"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");
		waitThread(2000);
		// To verify the wizard status of answer 2
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("incomplete"));

		// Click on Answer 3
		click(asp.wizardans3);
		Assert.assertTrue(getAttribute(asp.wizardans3, "class").contains("p-highlight"));

		// To enter the data on Question box
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);
		type(asp.Answertextbx, "Answer 3");
		waitThread(1000);
		driver.switchTo().defaultContent();

		// click on My answer is incomplete check box
		click(asp.incompleteanschkbx);
		// click on incomplete answer check box is checked
		Assert.assertTrue(getAttribute(asp.incompletechked, "class").contains("p-checkbox-checked"));
		waitThread(1000);
		// click on save button
		click(asp.testbtnsave);
		waitFor(QP.toaster);
		// Assert the toaster "Answer Saved"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");
		waitThread(2000);

		// verify the Answer 2 wizard status
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("incomplete"));

	}

	/*
	 * To perform assessment submit functionality on the student profile
	 */
	@Test(priority = 42)
	public void TCSPR1200442() {

		// click on submit button
		click(asp.testbtnsubmit);
		// To verify the confirmation pop up visible
		Assert.assertTrue(isElementPresent(asp.testwindowconfirmpopup), "Test Window confirmation pop up not visible");

		// click on submit button
		click(asp.confirmationsubmit);
		waitFor(QP.toaster);
		// verify toaster "Assessment Submitted"
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");
		click(QP.toasterclosebtn);
		Assert.assertFalse(isElementPresent(asp.testwindowconfirmpopup), "Test Window confirmation pop up not visible");

		// click on Back to Assessment button
		click(asp.btnbacktoassessment);
		// To check that the test submit pop up not visible
		Assert.assertFalse(isElementPresent(asp.tstSubmitAnswerPopup), "Test confirmation pop up visible");
		waitThread(1000);
		// To verify the current assessment tab not selected
		Assert.assertEquals(getAttribute(sca.selectedcurrenttab, "aria-selected"), "true");

		// Search The Assessment Name
		type(sca.searchbox, AssessmentName.trim());
		driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(3000);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		// To verify the number of assessment cards
		Assert.assertEquals(TotalElementsCount(natb.cardcount), 1);

		// To check the submitted answer percentage and count on the student
		// card
		Assert.assertTrue(getAttribute(asp.teachercardprogressbar, "aria-valuenow").contains("100"));
		Assert.assertEquals(getText(asp.teachercardstudcount).substring(0, 1), "3");
	}

	/*
	 * To perform logout functionality on the student 2 profile
	 */
	@Test(priority = 43)
	public void TCSPR1200443() {

		TCSPR1200416();

	}

	/*
	 * To perform the teacher login functionality and check the assessment card
	 */
	@Test(priority = 44)
	public void TCSPR1200444() {

		TCSPR1200422();

		// To check the total test completed students percentage and count
		waitThread(1000);
		Assert.assertEquals(getAttribute(asp.teachercardprogressbar, "aria-valuenow"), "100");
		Assert.assertEquals(getText(asp.teachercardstudcount).substring(0, 1), "2");

	}

	/*
	 * To check the the details on the test section view details page.
	 */
	@Test(priority = 45)
	public void TCSPR1200445() {

		// click on View details button
		click(asp.buttontestbegin);
		waitThread(2000);
		// To check the view details pop up not visible
		Assert.assertTrue(isDisplayed(asp.viewdetailspopup), "View details popup not visible");
		// To verify the student 2 name on the view details page
		Assert.assertEquals(getText(asp.Student2_name), Student2name);

		// verify the student 2 answer complete percentage and count
		Assert.assertEquals(getAttribute(asp.progressbarstud2, "aria-valuenow"), "100");
		Assert.assertEquals(getText(asp.popupQuestioncountstud2).substring(0, 1), "3");

		// click on view details pop up close button
		click(asp.btncloseviewdetails);
		// To check that the view details pop up not visible
		Assert.assertFalse(isElementPresent(asp.viewdetailspopup), "View details popup visible");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 46)
	public void TCSPR1200445_DeleteTeacher() {
		waitThread(2000);
		cr.DeleteAccount();

		waitThread(2000);

		// login using deleted account credentials
		lg.login(Emailteacher, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete Student 1 Account functionality
	 */
	@Test(priority = 47)
	public void TCSPR1200445_DeleteStudent1() {
		lg.login1(Emailstudent1, password);
		waitThread(3000);
		cr.DeleteAccount();
		waitThread(2000);

		// login using deleted account credentials
		lg.login(Emailstudent1, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student2 Account functionality
	 */
	@Test(priority = 48)
	public void TCSPR1200445_DeleteStudent2() {

		// login using deleted account credentials
		lg.login1(Emailstudent2, password);
		waitThread(2000);
		cr.DeleteAccount();

		waitThread(2000);

		// login using deleted account credentials
		lg.login(Emailstudent2, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

}
