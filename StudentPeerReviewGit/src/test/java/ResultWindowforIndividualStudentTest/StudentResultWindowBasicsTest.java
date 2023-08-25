package ResultWindowforIndividualStudentTest;

import java.sql.SQLException;
import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;
import com.google.gson.annotations.Until;

import CommonFunctionalities.Test.CommonFileTest;
import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import Course.Pages.EditCoursePage;
import Course.Test.EditCourseTest;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.BasicDetailsPageCourseandEditorPage;
import CreateNewAssessment.Pages.MultipleQuestionsAddPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionEditorAndMultipleCategoryAddPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CreateNewAssessment.Test.BasicDetailsAssessmentTest;
import CurrentAssessmentsforStudents.Pages.StudentCurrentAssessmentBasicsPage;
import CurrentAssessmentsforStudents.Pages.StudentTestSectionPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.NewAssessmentTeacherBasicsPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowPage;
import ResultWindowforIndividualStudent.Page.StudentResultWindowBasicsPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import TestWindowOfIndividualStudent.AnswerWindowPage;
import TestWindowOfIndividualStudent.AssessmentSubmitAndStatusPopUpPage;
import TestWindowOfIndividualStudent.ModifyWizardSectionPage;
import bsh.org.objectweb.asm.Type;

public class StudentResultWindowBasicsTest extends basePage {

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
	EditCourseTest ect = new EditCourseTest();
	TeacherTestSectionPage tts = new TeacherTestSectionPage();
	StudentTestSectionPage st1 = new StudentTestSectionPage();
	SchedulePageBasicsPage sb1 = new SchedulePageBasicsPage();
	BasicDetailsPageCourseandEditorPage be = new BasicDetailsPageCourseandEditorPage();
	NewAssessmentTeacherBasicsPage natb = new NewAssessmentTeacherBasicsPage();
	StudentCurrentAssessmentBasicsPage sca = new StudentCurrentAssessmentBasicsPage();
	QuestionEditorAndMultipleCategoryAddPage QE = new QuestionEditorAndMultipleCategoryAddPage();
	AssessmentSubmitAndStatusPopUpPage asp = new AssessmentSubmitAndStatusPopUpPage();
	AnswerWindowPage an = new AnswerWindowPage();
	CommonMethods cm = new CommonMethods();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	ModifyWizardSectionPage ms = new ModifyWizardSectionPage();
	PeerReviewWindowPage prp = new PeerReviewWindowPage();
	StudentResultWindowBasicsPage rwbt = new StudentResultWindowBasicsPage();
	CommonFileTest cmt = new CommonFileTest();
	SignUpPage sp = new SignUpPage();
	CourseRosterPage cr = new CourseRosterPage();
	EncryptedText et = new EncryptedText();
	Databaseconnection dc = new Databaseconnection();
	public String Emailteacher;
	public String AssessmentName;
	public String Student1name = "Ashley Albert";
	public String Student2name = "Ben Max";
	public String Student3name = "Clara April";

	public String password = "Abc@123";
	public String Teachername = "Test Teacher";
	public String Studentfirstname;
	public String Studentlastname;
	public String Studentname;
	public String Studentfirstname2;
	public String Studentlastname2;
	public String Studentname2;
	public String Studentfirstname3;
	public String Studentlastname3;
	public String Studentname3;
	public String studentinviteid;
	public String newOtp;
	public String Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
	public String Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";
	public String Emailstudent3 = "student3" + generateRandomNumber().trim() + "@gmail.com";

	public String CourseName3;
	public String CourseID3;

	/*
	 * To perform Login functionality
	 */
	@Test(priority = -7)
	public void TeacherSignUp() throws SQLException {

		Emailteacher = cmt.SignUpTeacher();

		// To catch OTP from sending Resource
		cmt.OtpFetch();

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	/*
	 * To create new course
	 */
	@Test(priority = -6)
	public void Teachercoursecreation() throws SQLException {

		CourseName3 = "Course Name" + generateRandomNumber().trim();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID3 = (getText(cn.course_Id));
		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent3 = "student3" + generateRandomNumber().trim() + "@gmail.com";

		// Invite students to course
		cm.Invitestudentstocourse_3(CourseName3, Emailstudent1, Emailstudent2, Emailstudent3);

	}
	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = -5)
	public void Teacherlogout() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on first student 's profile
	 * and accept course request-Read the student name
	 */
	@Test(priority = -4)
	public void Student1signup() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent1, CourseID3);

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
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName3.trim());

	}
	/*
	 * To Accept course and perform logout functionality on the student profile
	 */

	@Test(priority = -3)
	public void student1courseaccept() {

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

		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName3.trim());
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
	@Test(priority = -2)
	public void student2signup() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent2, CourseID3);

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
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName3.trim());

	}
	/*
	 * To Accept course and perform logout functionality on the student profile
	 */

	@Test(priority = -1)
	public void student2courseaccept() {

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
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName3.trim());
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	@Test(priority = 0)
	public void student3signup() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent3, CourseID3);

		String encText = et.EncryptCode(studentinviteid);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname3 = "Clara";
		Studentlastname3 = "April";
		Studentname3 = Studentfirstname3 + " " + Studentlastname3;
		waitThread(3000);
		// click first name
		click(sp.txtbxFirstN);

		// type first name
		type(sp.txtbxFirstN, Studentfirstname3);

		// click last name
		click(sp.txtbxLastN);

		// type last name
		type(sp.txtbxLastN, Studentlastname3);

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
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName3.trim());

	}

	/*
	 * To Accept course and perform logout functionality on the student profile
	 */

	@Test(priority = 1)
	public void student3acceptcourse() {

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
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName3.trim());
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
	@Test(priority = 2)
	public void TCSPR1400102() {

		SoftAssert softAssert1 = new SoftAssert();
		lg.login1(Emailteacher, password);
		waitThread(4000);
		// click on Assessment tab
		click(ba.Assessmenttab);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);

		// To click on course drop down
		click(ba.dd_course);

		// To search course on the course dropdown
		type(ba.coursesearchbox, CourseName3);
		waitFor(ba.ddcoursename1);
		softAssert1.assertEquals(getText(ba.ddcoursename1), CourseName3.trim(),
				"course name not visible on the dropdown");

		click(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentName = "History_" + generateRandomNumber().trim();
		type(QP.Assess_name, AssessmentName);

		waitThread(2000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(1000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(3000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), AssessmentName);

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID3 + ", " + CourseName3.trim());

		softAssert1.assertAll();

	}

	public String Question1 = "Question 1";
	public String Question2 = "Question 2";
	public String Question3 = "Question 3";
	public String Q1maxscore = "10";
	public String Q2maxscore = "20";
	public String Q3maxscore = "30";

	/*
	 * To fill details on the Question page [Question 1]
	 */
	@Test(priority = 3)
	public void TCSPR1400103() {

		SoftAssert softAssert2 = new SoftAssert();
		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, Question1);

		driver.switchTo().defaultContent();

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);
		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "Rubric 1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		ScrollTo_xy_position(0, -250);

		// Enter Max score
		type(QP.max_scorbx, Q1maxscore);

		// Click on +button
		click(mq.add_quest_btn);
		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		softAssert2.assertEquals(getText(QP.toaster), "Question 1 Saved successfully", "No Toaster Shows");
		click(QP.toasterclosebtn);
		waitThread(1000);
		softAssert2.assertAll();
	}

	/*
	 * To fill details on the Question page[Question 2]
	 */
	@Test(priority = 4)
	public void TCSPR1400104() {
		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, Question2);

		driver.switchTo().defaultContent();

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);
		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "Rubric 2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		ScrollTo_xy_position(0, -250);

		// Enter Max score
		type(QP.max_scorbx, Q2maxscore);

		// Click on +button
		click(mq.add_quest_btn);
		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully");
		click(QP.toasterclosebtn);

	}

	/*
	 * To fill details on the Question page[Question 3]
	 */

	@Test(priority = 5)
	public void TCSPR1400105() {
		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, Question3);

		driver.switchTo().defaultContent();

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);
		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "Rubric 3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		ScrollTo_xy_position(0, -250);

		// Enter Max score
		type(QP.max_scorbx, Q3maxscore);

		waitThread(4000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Question 3 Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 3 Saved successfully");

		click(QP.toasterclosebtn);

	}

	/*
	 * To verify the details on the peer review page
	 */
	public String RewardPercent = "50";

	@Test(priority = 6)
	public void TCSPR1400106() {
		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Type the Reward Score Percentage
		type(prp.RewardScore, RewardPercent);

		// Click on Answer Sheets Per Student
		click(ps.anssheetperstu_drp);

		// Select Answer Sheets Per Student is 2
		click(ps.anssheetperstu_drpcount2);
		waitThread(2000);

		// Assert the Answer sheets to be assigned to the Peer Reviewer having 2
		// columns
		Assert.assertEquals(TotalElementsCount(ps.studant1_columncount), 2);

		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 3");

		// Assert the student names
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Student1name.trim());
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Student2name.trim());
		Assert.assertEquals(getText(ps.studantname3_gridval).trim(), Student3name.trim());

	}

	/*
	 * To perform the save and next functionaity from peer review page and
	 * verify the schedule page details[Read the result publish and
	 * reconsideration request dates and time]
	 */
	@Test(priority = 7)
	public void TCSPR1400107() {

		click(pr.savennext_button);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);

		waitThread(2000);
		Assert.assertEquals(getAttribute(sb1.schedule_wizard, "aria-expanded"), "true");

		waitThread(1000);
		click(pr.savennext_button);
		waitThread(2000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sbp.summary_wizard, "aria-selected"), "true");
		waitThread(1000);

	}

	public String TotalQuestions;
	public int TotalTestPoints1;
	public int TotalRewardScore;
	public String TotalTestPoints;
	public String Totalpeerreviewpoints;
	public String MaxScore;
	public float Q1RSP;
	public String rewarscoreQ1;
	public float Q2RSP;
	public String rewarscoreQ2;
	public float Q3RSP;
	public String rewarscoreQ3;
	public int Q1RSP2;
	public int Q2RSP2;
	public int Q3RSP2;
	// Reward Percent
	public float RP = Float.parseFloat(RewardPercent);

	/*
	 * Tp verify details on the Summary page
	 */
	@Test(priority = 8)
	public void TCSPR1400108() {

		// To get The Total Test Points
		TotalTestPoints1 = Integer.parseInt(Q1maxscore) + Integer.parseInt(Q2maxscore) + Integer.parseInt(Q3maxscore);
		TotalTestPoints = Integer.toString(TotalTestPoints1);

		// To verify Total Questions
		Assert.assertEquals(getText(sb.valuetotalQuestion), "3");
		// To verify Total Test Points
		Assert.assertEquals(getText(sb.valueTotaltestpoints), TotalTestPoints);

		// To calculate Reward Score for Question 1
		rewarscoreQ1 = cm.getrewardscoreforquestion(Q1maxscore, RewardPercent);

		// To calculate Reward Score for Question 2
		rewarscoreQ2 = cm.getrewardscoreforquestion(Q2maxscore, RewardPercent);

		// To calculate Reward Score for Question 3
		rewarscoreQ3 = cm.getrewardscoreforquestion(Q3maxscore, RewardPercent);

		// Calculating Total Peer Review points
		TotalRewardScore = cm.StringtoInt(rewarscoreQ1) + cm.StringtoInt(rewarscoreQ2) + cm.StringtoInt(rewarscoreQ3);

		// To verify Total Peer Review points
		Assert.assertEquals(getText(sb.valuepeerreviewpoints), Integer.toString(TotalRewardScore));
		int maxscorepossible1 = TotalRewardScore + TotalTestPoints1;
		// To verify the Maximum Score Possible value
		Assert.assertEquals(getText(sb.valuemaxscore), Integer.toString(maxscorepossible1));

		// To verify the labels with values
		Assert.assertEquals(getText(sb.lblTotalQuestions), "Total Questions: 3");
		Assert.assertEquals(getText(sb.lblTotaltestpoints), "Total Test Points: " + TotalTestPoints);
		Assert.assertEquals(getText(sb.lblpeerreviewpoints),
				"Total Peer Review Points: " + Integer.toString(TotalRewardScore));
		Assert.assertEquals(getText(sb.lblmaxscore), "Maximum Score Possible: " + Integer.toString(maxscorepossible1));
		Totalpeerreviewpoints = Integer.toString(TotalRewardScore);
		MaxScore = Integer.toString(maxscorepossible1);
	}

	/*
	 * To check the back to menu button functionality and check the created
	 * assessment visible on the current assessment tab
	 */
	@Test(priority = 9)
	public void TCSPR1400109() {

		// click on Release Button
		click(sb.btnrelease);

		waitFor(QP.toaster);
		// Assert toaster "Assessment published successfully
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");
		click(QP.toasterclosebtn);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(natb.publishpopup), "Publish popup not visible");
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
		Assert.assertEquals(getText(natb.cardcoursename1), "For" + " " + CourseName3.trim() + " (" + CourseID3 + ")");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 10)
	public void TCSPR1400110() {
		cm.Logout();
	}

	/*
	 * To perform Login functionality of student1 profile and check the
	 * Assessment card
	 */
	@Test(priority = 11)
	public void TCSPR1400111() {

		waitThread(2000);
		// Login as Student 1
		lg.login1(Emailstudent1, cm.Password);

		waitThread(2000);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		waitThread(5000);

		// Search The Assessment Name
		type(sca.searchbox, AssessmentName.trim());
		// driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");

		// Assert the Assessment name and course name visible on the card
		Assert.assertEquals(getText(natb.cardassessmentname1), AssessmentName);
		Assert.assertEquals(getText(natb.cardcoursename1), "For" + " " + CourseName3.trim() + " (" + CourseID3 + ")");

		// Assert the labels-Result section
		Assert.assertEquals(getText(rwbt.studresultlbl), "Result Publishing Date: Will be Updated Shortly");
		Assert.assertEquals(getText(rwbt.lblpendinginresult), "Pending");
	}

	/*
	 * To begin the test & check the labels of test window
	 */
	@Test(priority = 12)
	public void TCSPR1400112() throws InterruptedException {

		// To verify the begin test button visible or not

		if (isElementPresent((asp.btnbeginTest)) == true) {

			waitThread(3000);
			// click on Begin Test button
			click(asp.btnbeginTest);
			Assert.assertTrue(isElementPresent(asp.Questionwizard), "Test Window page not visible");
		}

		else {

			// wait for 1.30 min
			TimeUnit.MINUTES.sleep(1);
			TimeUnit.SECONDS.sleep(80);
			// To verify the begin test button visible
			Assert.assertTrue(isElementPresent(asp.btnbeginTest), "Begin Test button Not visible");
			waitThread(1000);

			// click on begin test button
			click(asp.btnbeginTest);
			Assert.assertTrue(isElementPresent(asp.Questionwizard), "Test Window page not visible");

		}
		waitThread(5000);
		// verify the course name,assessment name,teacher name
		Assert.assertEquals(getText(asp.testassessmentname), AssessmentName.trim());
		Assert.assertEquals(getText(asp.testcoursename), "Course: " + CourseID3 + "," + " " + CourseName3.trim());

	}

	/*
	 * To attend test and fill answer functionality[Question 1,Question 2]
	 */
	@Test(priority = 13)
	public void TCSPR1400113() {

		// To enter the data on Question box
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);
		type(rwbt.Answertextbx, "Answer 1_" + generateRandomData());
		waitThread(1000);
		driver.switchTo().defaultContent();
		waitThread(1000);
		// Click on save Button
		click(asp.testbtnsave);
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");
		click(QP.toasterclosebtn);
		waitThread(3000);

		// click on Answer 2 wizard
		click(asp.wizardans2);

		// To fill the Answer 2
		waitThread(1000);
		// To enter the data on Question box
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);
		type(asp.Answertextbx, "Answer 2_" + generateRandomData());
		waitThread(1000);
		driver.switchTo().defaultContent();
		// To verify the Answer 2 is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));

		// Click on my answer is incomplete check box
		click(asp.incompleteanschkbx);
		Assert.assertTrue(getAttribute(asp.incompletechked, "class").contains("p-checkbox-checked"));
		waitThread(1000);

	}

	/*
	 * To attend test and fill answer functionality[Question 3]
	 */
	@Test(priority = 14)
	public void TCSPR1400114() {
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
		waitThread(1000);
		Assert.assertTrue(getAttribute(asp.wizardans3, "class").contains("p-highlight"));

		// To enter the data on Question box
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);
		type(asp.Answertextbx, "Answer 3_" + generateRandomData());
		waitThread(1000);
		driver.switchTo().defaultContent();
		// click on save button
		click(asp.testbtnsave);
		waitFor(QP.toaster);
		// Assert the toaster "Answer Saved"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");
		waitThread(4000);
	}
	/*
	 * To perform assessment submit functionality on the student profile
	 */

	@Test(priority = 15)
	public void TCSPR1400115() {

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

	}

	/*
	 * To perform logout functionality on the Student 1 profile
	 */
	@Test(priority = 16)
	public void TCSPR1400116() {

		cm.Logout();
	}

	/*
	 * To perform Login functionality of student 2 profile and check the
	 * Assessment card
	 */
	@Test(priority = 17)
	public void TCSPR1400117() {

		waitThread(2000);
		// Login as Student 1
		lg.login1(Emailstudent2, cm.Password);

		waitThread(2000);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		waitThread(5000);

		// Search The Assessment Name
		type(sca.searchbox, AssessmentName.trim());
		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");

		// click on begin test button
		click(asp.btnbeginTest);
		Assert.assertTrue(isElementPresent(asp.Questionwizard), "Test Window page not visible");

	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 18)
	public void TCSPR1400118() {

		// To enter the data on Question box
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);
		type(asp.Answertextbx, "Answer 1_" + generateRandomData());
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

		// To fill the Answer 2
		waitThread(1000);
		// To enter the data on Question box
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);
		type(asp.Answertextbx, "Answer 2_" + generateRandomData());
		waitThread(1000);
		driver.switchTo().defaultContent();
		// To verify the Answer 2 is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));
		waitThread(1000);
	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 19)
	public void TCSPR1400119() {

		// click on save button
		click(asp.testbtnsave);
		waitFor(QP.toaster);
		// Assert the toaster "Answer Saved"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");
		waitThread(2000);
		// Click on Answer 3
		click(asp.wizardans3);
		Assert.assertTrue(getAttribute(asp.wizardans3, "class").contains("p-highlight"));

		// To enter the data on Question box
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);
		type(asp.Answertextbx, "Answer 3_" + generateRandomData());
		waitThread(1000);
		driver.switchTo().defaultContent();
		// click on save button
		click(asp.testbtnsave);
		waitFor(QP.toaster);
		// Assert the toaster "Answer Saved"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		waitThread(2000);

	}

	/*
	 * To perform assessment submit functionality on the student profile
	 */
	@Test(priority = 20)
	public void TCSPR1400120() {

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

	}

	/*
	 * To perform logout functionality on the Student 2 profile
	 */
	@Test(priority = 21)
	public void TCSPR1400121() {
		cm.Logout();
	}

	/*
	 * To perform Login functionality of student 3 profile and check the
	 * Assessment card
	 */
	@Test(priority = 22)
	public void TCSPR1400122() {
		waitThread(2000);
		// Login as Student 1
		lg.login1(Emailstudent3, cm.Password);

		waitThread(2000);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		waitThread(5000);

		// Search The Assessment Name
		type(sca.searchbox, AssessmentName.trim());
		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");

		// click on begin test button
		click(asp.btnbeginTest);
		Assert.assertTrue(isElementPresent(asp.Questionwizard), "Test Window page not visible");

	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 23)
	public void TCSPR1400123() {
		// To enter the data on Question box
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);
		type(asp.Answertextbx, "Answer 1_" + generateRandomData());
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

		// To fill the Answer 2
		waitThread(1000);
		// To enter the data on Question box
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);
		type(asp.Answertextbx, "Answer 2_" + generateRandomData());
		waitThread(1000);
		driver.switchTo().defaultContent();
		// To verify the Answer 2 is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));
		waitThread(1000);
	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 24)
	public void TCSPR1400124() {
		// click on save button
		click(asp.testbtnsave);
		waitFor(QP.toaster);
		// Assert the toaster "Answer Saved"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");
		waitThread(2000);
		// Click on Answer 3
		click(asp.wizardans3);
		Assert.assertTrue(getAttribute(asp.wizardans3, "class").contains("p-highlight"));

		// To enter the data on Question box
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);
		type(asp.Answertextbx, "Answer 3_" + generateRandomData());
		waitThread(1000);
		driver.switchTo().defaultContent();
		// click on save button
		click(asp.testbtnsave);
		waitFor(QP.toaster);
		// Assert the toaster "Answer Saved"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");
		waitThread(2000);
	}

	/*
	 * To perform assessment submit functionality on the student profile
	 */

	@Test(priority = 25)
	public void TCSPR1400125() {

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

	}

	/*
	 * To perform logout functionality on the Student 3 profile
	 */

	@Test(priority = 26)
	public void TCSPR1400126() {

		cm.Logout();
	}

	public String assessmentduetime;

	/*
	 * To perform reschedule of Test Window and Peer Review window
	 */
	@Test(priority = 27)
	public void RescheduleTestAndPeerDate() {

		// Login as Teacher
		cm.login(Emailteacher, cm.Password);
		waitThread(5000);
		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(5000);
		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		// Search The Assessment Name
		type(sca.teacherassessmentsearchbox, AssessmentName.trim());
		waitThread(1000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(3000);

		// Click menu button
		click(rd.threedot_btn);
		Assert.assertTrue(isElementPresent(rd.reschedulemenu), "Reschedule Dates menu not present");
		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(2000);
		// Assert the Reschedule popup visible
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");
		click(rd.assessmentduedate_txtbx);
		waitThread(2000);
		// To select Todays Date
		cm.ClickTodaysDate();

		waitThread(2000);
		click(rd.peerreviewopendate_txtbx);
		waitThread(1000);
		// To select Todays date
		// cm.ClickTodaysDate_PeerReview();
		Calendar cal = Calendar.getInstance();
		int monthNumber2 = cal.get(Calendar.MONTH);
		int Day = cal.get(Calendar.DAY_OF_MONTH);
		int monthNumber = monthNumber2 + 1;
		String monthname = Month.of(monthNumber).name();
		waitThread(2000);
		String Dropmonth = DropselectedValue("select.p-datepicker-month.ng-star-inserted");

		if (monthname.equals(Dropmonth.toUpperCase())) {

			if (Day < 15) {

				Doubleclick("//td[contains(@class,'p-datepicker-today')]");
				waitThread(4000);
			} else {
				click("//span[contains(text(),'Su')]");
				click("//span[contains(text(),'Mo')]");
				Actions action = new Actions(driver);
				action.sendKeys(Keys.PAGE_DOWN).build().perform();
				// action.sendKeys(Keys.PAGE_DOWN).build().perform();
				waitThread(2000);
				Doubleclick("//td[contains(@class,'p-datepicker-today')]");
				waitThread(4000);

			}
		} else {

			click("button.p-datepicker-prev.p-link.p-ripple.ng-star-inserted > span");
			waitThread(3000);
			click("//span[contains(text(),'Su')]");
			click("//span[contains(text(),'Mo')]");
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			// action.sendKeys(Keys.PAGE_DOWN).build().perform();
			waitThread(4000);
			Doubleclick("//td[contains(@class,'p-datepicker-today')]");
			waitThread(4000);
		}

		// click on Apply changes button
		click(rd.Applychangesbtn);

		waitFor(QP.toaster);

		// Assert a toaster Changes applied
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		click(QP.toasterclosebtn);

		waitThread(5000);
		// Assert popup not visible
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");
		cm.Logout();
	}

	/*
	 * To perform Login functionality of student 1 profile and check the
	 * Assessment card
	 */
	@Test(priority = 27)
	public void TCSPR1400127() throws InterruptedException {

		// Login as Student 1
		lg.login1(Emailstudent1, cm.Password);
		waitThread(2000);

		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		waitThread(5000);
		// Search The Assessment Name
		type(sca.searchbox, AssessmentName.trim());
		// driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");

		// wait for 1 min
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(80);

		// Click on Begin Review button
		click(prp.btnbeginReview);
		waitThread(5000);
		Assert.assertTrue(isElementPresent(prp.Reviewwizard), "Peer Review Window page not visible");

	}

	/*
	 * To perfrom review for Question 1 and Question 2
	 */
	@Test(priority = 28)
	public void TCSPR1400128() {

		// verify the Question 1 wizard is selected
		Assert.assertTrue(getAttribute(asp.wizardans1, "class").contains("p-highlight"));
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "5");
		click(prp.scorestud2);
		waitThread(1000);
		type(prp.scorestud2, "10");
		// click on save and next button
		click(prp.reviewbtnsaveandnext);
		waitFor(QP.toaster);
		// verify the toaster "Score Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);
		// verify the Question 2 is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));

		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "10");
		click(prp.scorestud2);
		waitThread(1000);
		type(prp.scorestud2, "15");
		// click on save and next button
		click(prp.reviewbtnsaveandnext);
		waitFor(QP.toaster);
		// verify the toaster "Score Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);

	}

	/*
	 * To perfrom review for Question 3 and submit the Review
	 */
	@Test(priority = 29)
	public void TCSPR1400129() {

		// verify the Question 3 is selected
		Assert.assertTrue(getAttribute(asp.wizardans3, "class").contains("p-highlight"));
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "15");
		click(prp.scorestud2);
		waitThread(1000);
		type(prp.scorestud2, "30");

		waitThread(1000);
		// click submit button
		click(ms.submit_btn);
		waitThread(1000);
		Assert.assertTrue(isDisplayed(prp.confir_popup), "popup not visible");
		waitThread(2000);
		click(prp.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Peer Review Submitted"
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);
		// Click on Back to Assessment
		click(prp.reviewbactoassessmentbtn);
		waitThread(2000);
		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		waitThread(1000);

	}

	/*
	 * To perform logout functionality on the Student 1 profile
	 */
	@Test(priority = 30)
	public void TCSPR1400130() {
		cm.Logout();
	}

	/*
	 * To perform Login functionality of student 2 profile and check the
	 * Assessment card
	 */
	@Test(priority = 31)
	public void TCSPR1400131() {
		// Login as Student 2
		lg.login1(Emailstudent2, cm.Password);
		waitThread(2000);

		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		waitThread(5000);
		// Search The Assessment Name
		type(sca.searchbox, AssessmentName.trim());
		// driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");

		// Click on Begin Review button
		click(prp.btnbeginReview);
		Assert.assertTrue(isElementPresent(prp.Reviewwizard), "Peer Review Window page not visible");
		waitThread(5000);
	}

	public String Q1ScorefromStud1;
	public String Q1ScorefromStud2;
	public String Q2ScorefromStud1;
	public String Q2ScorefromStud2;
	public String Q3ScorefromStud1;
	public String Q3ScorefromStud2;

	/*
	 * To perfrom review for Question 1 and Question 2
	 */
	@Test(priority = 32)
	public void TCSPR1400132() {

		// verify the Question 1 wizard is selected
		Assert.assertTrue(getAttribute(asp.wizardans1, "class").contains("p-highlight"));
		// click on student 1 Score box
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "5");

		// click on student 2 score box
		click(prp.scorestud2);
		waitThread(1000);
		String Q1S1Score1 = "5";
		// type score
		type(prp.scorestud2, Q1S1Score1);
		// Read the Q1 Score From Student 1
		Q1ScorefromStud1 = getValue(prp.scorestud2);

		// click on save and next button
		click(prp.reviewbtnsaveandnext);
		waitFor(QP.toaster);
		// verify the toaster "Score Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);
		// verify the Question 2 is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));

		// Type score for student 1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "10");

		// Type Score for Student 2[Read the Data]
		String Q2S1Score1 = "10";
		click(prp.scorestud2);
		waitThread(1000);
		type(prp.scorestud2, Q2S1Score1);
		// Read the Q2 Score From Student 1
		Q2ScorefromStud1 = getValue(prp.scorestud2);

		// click on save and next button
		click(prp.reviewbtnsaveandnext);
		waitFor(QP.toaster);
		// verify the toaster "Score Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);

	}

	/*
	 * To perfrom review for Question 3 and submit the Review
	 */
	@Test(priority = 33)
	public void TCSPR1400133() {

		// verify the Question 3 is selected
		Assert.assertTrue(getAttribute(asp.wizardans3, "class").contains("p-highlight"));
		// Type Score for student 1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "15");

		// Type Score for student 2
		String Q3S1Score1 = "15";
		click(prp.scorestud2);
		waitThread(1000);
		type(prp.scorestud2, Q3S1Score1);
		// Read the Q3 Score From Student 1
		Q3ScorefromStud1 = getValue(prp.scorestud2);

		waitThread(1000);
		// click submit button
		click(ms.submit_btn);
		waitThread(2000);
		// verify the confirmation popup visible
		Assert.assertTrue(isDisplayed(prp.confir_popup), "popup not visible");
		waitThread(2000);
		click(prp.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Peer Review Submitted"
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);
		// Click on Back to Assessment
		click(prp.reviewbactoassessmentbtn);
		waitThread(2000);
		// Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		waitThread(1000);

	}

	/*
	 * To perform logout functionality on the Student 2 profile
	 */
	@Test(priority = 34)
	public void TCSPR1400134() {

		cm.Logout();
	}

	/*
	 * To perform Login functionality of student 3 profile and check the
	 * Assessment card
	 */
	@Test(priority = 35)
	public void TCSPR1400135() {

		// Login as Student 3
		lg.login1(Emailstudent3, cm.Password);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		waitThread(5000);
		// Search The Assessment Name
		type(sca.searchbox, AssessmentName.trim());
		// driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");

		// Click on Begin Review button
		click(prp.btnbeginReview);
		Assert.assertTrue(isElementPresent(prp.Reviewwizard), "Peer Review Window page not visible");
		waitThread(5000);
	}

	/*
	 * To perfrom review for Question 1 and Question 2
	 */
	@Test(priority = 36)
	public void TCSPR1400136() {

		// verify the Question 1 wizard is selected
		Assert.assertTrue(getAttribute(asp.wizardans1, "class").contains("p-highlight"));
		// Type score for student 1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "5");

		// Type score for student 2
		click(prp.scorestud2);
		waitThread(1000);
		String Q1S2Score1 = "10";
		type(prp.scorestud2, Q1S2Score1);
		// Read the Q1 Score from student 2
		Q1ScorefromStud2 = getValue(prp.scorestud2);

		// click on save and next button
		click(prp.reviewbtnsaveandnext);
		waitFor(QP.toaster);
		// verify the toaster "Score Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);
		// verify the Question 2 is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));

		// click on student 1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "10");
		// Type Score for student 2 qnd read the details
		String Q2S2Score1 = "20";
		click(prp.scorestud2);
		waitThread(1000);
		type(prp.scorestud2, Q2S2Score1);
		// Read the Q2 Score from student 2
		Q2ScorefromStud2 = getValue(prp.scorestud2);

		// click on save and next button
		click(prp.reviewbtnsaveandnext);
		waitFor(QP.toaster);
		// verify the toaster "Score Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);

	}

	/*
	 * To perfrom review for Question 3 and submit the Review
	 */
	@Test(priority = 37)
	public void TCSPR1400137() {
		// verify the Question 3 is selected
		Assert.assertTrue(getAttribute(asp.wizardans3, "class").contains("p-highlight"));

		// Type Score for student 1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "15");
		String Q3S2Score1 = "30";

		// Type Score for student 2
		click(prp.scorestud2);
		waitThread(1000);
		type(prp.scorestud2, Q3S2Score1);
		// Read Q3 score from student 2
		Q3ScorefromStud2 = getValue(prp.scorestud2);
		waitThread(1000);
		// click submit button
		click(ms.submit_btn);
		waitThread(2000);
		Assert.assertTrue(isDisplayed(prp.confir_popup), "popup not visible");
		waitThread(2000);
		click(prp.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Assessment Submitted"
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);
		// Click on Back to Assessment
		click(prp.reviewbactoassessmentbtn);
		waitThread(2000);
		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		waitThread(1000);
	}

	/*
	 * To perform logout functionality on the Student 3 profile
	 */
	@Test(priority = 38)
	public void TCSPR1400138() {

		cm.Logout();
	}

	public String Resultdate;
	public String resultopentime1;

	/*
	 * To perform reschedule of Peer Window and result Review window
	 */
	@Test(priority = 39)
	public void ReschedulePeerAndResultDate() throws InterruptedException {

		// Login as Teacher
		cm.login(Emailteacher, cm.Password);
		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(5000);
		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		// Search The Assessment Name
		type(sca.teacherassessmentsearchbox, AssessmentName.trim());
		waitThread(1000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(3000);

		// Click menu button
		click(rd.threedot_btn);
		Assert.assertTrue(isElementPresent(rd.reschedulemenu), "Reschedule Dates menu not present");
		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(2000);
		// Assert the Reschedule popup visible
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");

		click(rd.peerreviewduedate_txtbx);
		waitThread(1000);
		// To select Todays date
		// cm.ClickTodaysDate_PeerReview();
		Calendar cal = Calendar.getInstance();
		int monthNumber2 = cal.get(Calendar.MONTH);
		int Day = cal.get(Calendar.DAY_OF_MONTH);
		int monthNumber = monthNumber2 + 1;
		String monthname = Month.of(monthNumber).name();
		waitThread(2000);
		String Dropmonth = DropselectedValue("select.p-datepicker-month.ng-star-inserted");

		if (monthname.equals(Dropmonth.toUpperCase())) {

			if (Day < 15) {

				Doubleclick("//td[contains(@class,'p-datepicker-today')]");
				waitThread(4000);
			} else {
				click("//span[contains(text(),'Su')]");
				click("//span[contains(text(),'Mo')]");
				Actions action = new Actions(driver);
				action.sendKeys(Keys.PAGE_DOWN).build().perform();
				// action.sendKeys(Keys.PAGE_DOWN).build().perform();
				waitThread(2000);
				Doubleclick("//td[contains(@class,'p-datepicker-today')]");
				waitThread(4000);

			}
		} else {

			click("button.p-datepicker-prev.p-link.p-ripple.ng-star-inserted > span");
			waitThread(3000);
			click("//span[contains(text(),'Su')]");
			click("//span[contains(text(),'Mo')]");
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			// action.sendKeys(Keys.PAGE_DOWN).build().perform();
			waitThread(4000);
			Doubleclick("//td[contains(@class,'p-datepicker-today')]");
			waitThread(4000);
		}

		// Click on Result date testbox
		click(rd.resultpublishdate_txtbx);

		// To select Todays Date
		cm.ClickTodaysDate();

		waitThread(1000);

		// click on Apply changes button
		click(rd.Applychangesbtn);

		waitFor(QP.toaster);

		// Assert a toaster Changes applied
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		click(QP.toasterclosebtn);

		waitThread(5000);
		// Assert popup not visible
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");

		// wait for 10 min
		TimeUnit.MINUTES.sleep(3);
		cm.Logout();
	}

	public String AnswerdQuestioncount;

	/*
	 * To perform Login functionality of student 1 profile and check the
	 * Assessment card
	 */
	@Test(priority = 40)
	public void TCSPR1400139() throws InterruptedException {

		// Login as Student 1
		lg.login1(Emailstudent1, cm.Password);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		waitThread(5000);

		// Search The Assessment Name
		type(sca.searchbox, AssessmentName.trim());
		// driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(6000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		AnswerdQuestioncount = getText(asp.cardQuestioncount);
		// verify the progress bar showing 100 % for Assessment 1
		Assert.assertEquals(getAttribute(prp.progressbarcard, "aria-valuenow"), "100");
		// card Status-Heading
		// Assert.assertEquals(getText(rwbt.cardheading), "Result Available");
		// card Status
		// Assert.assertEquals(getText(rwbt.lbl_resultactive), "Active");
		// Assert.assertTrue(isElementPresent(rwbt.viewresultbtn), "View result
		// button not visible");

	}

	/*
	 * To perform View Result functionality on the student profile
	 */
	@Test(priority = 41)
	public void TCSPR1400140() {

		// click on view result button
		click(rwbt.viewresultbtn);
		waitThread(3000);
		// verify the result popup not visible
		Assert.assertTrue(isElementPresent(rwbt.resultpopup), "Result Popup  not visible");

	}

	public String TotalPeerreviewscore;
	public String Total_peerreview_points;

	/*
	 * To check the labels and details on the header section of result popup
	 */
	@Test(priority = 42)
	public void TCSPR1400141() {

		// verify the Question Answerd label and Value
		Assert.assertTrue(getText(rwbt.lbl_studentAnswered).contains("Questions Answered"));
		Assert.assertEquals(getText(rwbt.value_studentAnswered), AnswerdQuestioncount);

		// verify the Score from Peer Reviewers label and value
		Assert.assertTrue(getText(rwbt.lbl_scorefrmReviewers).contains("Score Received from Peer Reviewers"));

		// calculating Score from Peer Reviewers[performing Adition]
		float TotalpeerreviewScore_1 = (Float.parseFloat(Q1ScorefromStud1) + Float.parseFloat(Q1ScorefromStud2))
				/ (float) 2 + (Float.parseFloat(Q2ScorefromStud1) + Float.parseFloat(Q2ScorefromStud2)) / (float) 2
				+ (Float.parseFloat(Q3ScorefromStud1) + Float.parseFloat(Q3ScorefromStud2)) / (float) 2;
		// Score from Peer Reviewers[Coverting float to int]
		int TotalpeerreviewScore_2 = (int) Math.round(TotalpeerreviewScore_1);
		// Total Peer review points[Converting string to int]
		int Totalpeerreviewpoints_1 = Integer.parseInt(Totalpeerreviewpoints) * 2;
		// Total Peer Review points[Converting Int to String]
		Total_peerreview_points = Integer.toString(Totalpeerreviewpoints_1);
		// Total Peer Review Score[Converting Int to String]
		TotalPeerreviewscore = Integer.toString(TotalpeerreviewScore_2);
		// verifying the Score from Peer Reviewers
		Assert.assertEquals(getText(rwbt.score_frmReviewers), TotalPeerreviewscore + "/" + Total_peerreview_points);

		// verify Peer Reviews Done label and value
		Assert.assertTrue(getText(rwbt.lbl_ReviewsDone).contains("No of Peer Reviews Done"));
		Assert.assertEquals(getText(rwbt.studentPeerDone), "6/6");

	}

	/*
	 * To check the labels and details on the header section of result popup
	 */
	@Test(priority = 42)
	public void TCSPR1400142() {

		// verifying Score for Reviews Done label and value
		Assert.assertTrue(getText(rwbt.lbl_ScoreforReviewsDone).contains("Score for Reviews Done"));
		Assert.assertEquals(getText(rwbt.ScoreforReviewsDone), Totalpeerreviewpoints + "/" + Totalpeerreviewpoints);

		// verifying Total Score labels and value
		Assert.assertTrue(getText(rwbt.lbl_TotalScore).contains("Total Score"));
		Assert.assertTrue(getText(rwbt.lbl_TotalScore)
				.contains("(Score Received from Peer Reviewers + Score for Peer Review Done)"));
		// calculating (Score from Peer Reviewers + Score for Peer Review Done)
		int sumscore = Integer.parseInt(rwbt.getdenominator(rwbt.ScoreforReviewsDone))
				+ Integer.parseInt(rwbt.getdenominator(rwbt.score_frmReviewers));

		// verifying Total Score
		Assert.assertEquals(getText(rwbt.TotalScore), Integer.toString(sumscore) + "/" + MaxScore);

	}

	/*
	 * To verify the result table grid labels
	 */
	@Test(priority = 43)
	public void TCSPR1400143() {

		Assert.assertEquals(getText(rwbt.lblSIno), "Sl No");
		Assert.assertEquals(getText(rwbt.lblQuestion), "Question");
		Assert.assertEquals(getText(rwbt.lblMaxscore), "Max Score");
		Assert.assertEquals(getText(rwbt.lblScorefromreviewers), "Scores Received from\n" + "Peer Reviewers");
		Assert.assertEquals(getText(rwbt.lblScoreforreviewdone), "Scores for Reviews\n" + "Done");
		Assert.assertEquals(getText(rwbt.lblFinalscore), "Final\n" + "Score");
		Assert.assertEquals(getText(rwbt.lblStatus), "Status");
		Assert.assertEquals(getText(rwbt.lblAnswersheet), "Answer\n" + "Sheet");

	}

	public String Q1Scorefrompeerandscoreforreviewdone;

	/*
	 * To verify the details of the Question 1,on the result window of student 1
	 */
	@Test(priority = 44)
	public void TCSPR1400144() {

		// verify the SI Number
		Assert.assertEquals(getText(rwbt.Q1_sino), "1");
		// verify Question content
		Assert.assertEquals(getText(rwbt.Q1_content), Question1);
		// verify the Maximum score
		Assert.assertEquals(getText(rwbt.Q1_Maxscore), Q1maxscore);

		// calculating the Sum of Question 1 score drom student 1 and Question 2
		// score from student 2
		float Scorefrompeerss_1 = (Float.parseFloat(Q1ScorefromStud1) + Float.parseFloat(Q1ScorefromStud2)) / (float) 2;
		Assert.assertEquals(getText(rwbt.Q1_scorefrompeers), Float.toString(Scorefrompeerss_1));

		// verify the Q1 reward Score
		Assert.assertEquals(getText(rwbt.Q1_scoreforreviews), rewarscoreQ1);

		// calculating Scores from Peer Reviewers+Scores for Reviews Done
		float Q1Scorefrompeerandscoreforreviewdone = Scorefrompeerss_1 + cm.Stringtofloat(rewarscoreQ1);

		// verify the Final Score for Question 1
		Assert.assertEquals(getText(rwbt.Q1_FinalScore), cm.floattostring(Q1Scorefrompeerandscoreforreviewdone));

		// verify the status
		Assert.assertEquals(getText(rwbt.Q1_Status), "Peer Review Completed");

		// verify the Q1 Answer sheet visible on the page
		Assert.assertTrue(isElementPresent(rwbt.Q1_Answersheet), "Question 1 Answer sheet not visible");
	}

	/*
	 * To verify the details of the Question 2,on the result window of student 1
	 */
	@Test(priority = 45)
	public void TCSPR1400145() {

		// verify the SI Number
		Assert.assertEquals(getText(rwbt.Q2_sino), "2");

		// verify Question content
		Assert.assertEquals(getText(rwbt.Q2_content), Question2);

		// verify the Maximum score
		Assert.assertEquals(getText(rwbt.Q2_Maxscore), Q2maxscore);

		// calculating the Sum of Question 2 score drom student 1 and Question 2
		// score from student 2
		float Scorefrompeerss_2 = (Float.parseFloat(Q2ScorefromStud1) + Float.parseFloat(Q2ScorefromStud2)) / (float) 2;

		Assert.assertEquals(getText(rwbt.Q2_scorefrompeers), cm.InttoString(Math.round(Scorefrompeerss_2)));

		// verify the Q2 reward Score
		Assert.assertEquals(getText(rwbt.Q2_scoreforreviews), rewarscoreQ2);

		// calculating Scores from Peer Reviewers+Scores for Reviews Done
		float Q2Scorefrompeerandscoreforreviewdone = Scorefrompeerss_2 + cm.Stringtofloat(rewarscoreQ2);

		// verify the Final Score Q2
		Assert.assertEquals(getText(rwbt.Q2_FinalScore),
				cm.InttoString(Math.round(Q2Scorefrompeerandscoreforreviewdone)));

		// verify the status
		Assert.assertEquals(getText(rwbt.Q2_Status), "Peer Review Completed");

		// verify the Q2 Answer sheet visible on the page
		Assert.assertTrue(isElementPresent(rwbt.Q2_Answersheet), "Question 2 Answer sheet not visible");
	}

	/*
	 * To verify the details of the Question 3,on the result window of student 1
	 */
	@Test(priority = 46)
	public void TCSPR1400146() {

		// verify the SI Number
		Assert.assertEquals(getText(rwbt.Q3_sino), "3");
		// verify Question content
		Assert.assertEquals(getText(rwbt.Q3_content), Question3);
		// verify the Maximum score
		Assert.assertEquals(getText(rwbt.Q3_Maxscore), Q3maxscore);

		// calculating the Sum of Question 3 score drom student 1 and Question 3
		// score from student 2
		float Scorefrompeerss_3 = (Float.parseFloat(Q3ScorefromStud1) + Float.parseFloat(Q3ScorefromStud2)) / (float) 2;

		Assert.assertEquals(getText(rwbt.Q3_scorefrompeers), cm.floattostring(Scorefrompeerss_3));

		// verify the Q3 reward Score
		Assert.assertEquals(getText(rwbt.Q3_scoreforreviews), rewarscoreQ3);

		// calculating Scores from Peer Reviewers+Scores for Reviews Done
		float Q3Scorefrompeerandscoreforreviewdone = Scorefrompeerss_3 + cm.Stringtofloat(rewarscoreQ3);

		// verify the Final Score for Q3
		Assert.assertEquals(getText(rwbt.Q3_FinalScore), cm.floattostring(Q3Scorefrompeerandscoreforreviewdone));

		// verify the status
		Assert.assertEquals(getText(rwbt.Q3_Status), "Peer Review Completed");

		// verify the Q3 Answer sheet visible on the page
		Assert.assertTrue(isElementPresent(rwbt.Q3_Answersheet), "Question 3 Answer sheet not visible");
	}

	/*
	 * To check the Close button functionality of result popup
	 * 
	 */
	@Test(priority = 47)
	public void TCSPR1400147() throws InterruptedException {

		// click on result popup close button
		JavaScriptclick(rwbt.resultpopupclosebtn);
		TimeUnit.SECONDS.sleep(30);
		// Result Popup not vsiisble
		Assert.assertFalse(isElementPresent(rwbt.resultpopup), "Result Popup   visible");

	}

	/*
	 * To perform Delete student1 Account functionality
	 */
	@Test(priority = 48)
	public void DeleteStudent1() {

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
	@Test(priority = 49)
	public void DeleteStudent2() {

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

	/*
	 * To perform Delete student3 Account functionality
	 */
	@Test(priority = 50)
	public void DeleteStudent3() {

		// login using deleted account credentials
		lg.login1(Emailstudent3, password);
		waitThread(2000);
		cr.DeleteAccount();
		waitThread(2000);

		// login using deleted account credentials
		lg.login(Emailstudent3, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete Teacher Account functionality
	 */
	@Test(priority = 51)
	public void TCSPR1200652_DeleteTeacher() {

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
