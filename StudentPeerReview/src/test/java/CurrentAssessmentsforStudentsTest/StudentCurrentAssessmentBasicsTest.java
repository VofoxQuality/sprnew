package CurrentAssessmentsforStudentsTest;

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
import Course.Test.EditCourseTest;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CreateNewAssessment.Pages.SummarySchedulePage;
import CreateNewAssessment.Test.BasicDetailsAssessmentTest;
import CreateNewAssessment.Test.SummaryBasicsTest;
import CurrentAssessmentsforStudents.Pages.StudentCurrentAssessmentBasicsPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.NewAssessmentTeacherBasicsPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class StudentCurrentAssessmentBasicsTest extends basePage {

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
	SchedulePageBasicsPage sbp = new SchedulePageBasicsPage();
	SummaryBasicsPage sb = new SummaryBasicsPage();
	SummaryBasicsTest sbt = new SummaryBasicsTest();
	SummarySchedulePage sshp = new SummarySchedulePage();
	EditCourseTest ect = new EditCourseTest();
	NewAssessmentTeacherBasicsPage natb = new NewAssessmentTeacherBasicsPage();
	CommonMethods cm = new CommonMethods();
	StudentCurrentAssessmentBasicsPage sca = new StudentCurrentAssessmentBasicsPage();

	public String Emailteacher;
	public String CourseName;
	public String NewCourseTitle;
	public String CourseID;
	public String AssessmentName;
	public String Emailstudent1;
	public String Emailstudent2;
	public String Student1firstname;
	public String Student1lastname;
	public String Student1name;
	public String Student2firstname;
	public String Student2lastname;
	public String Student2name;

	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	/*
	 * To perform Sign Up functionality
	 */

	@Test(priority = 0)
	public void TCSPR1100101() {

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
	 * To create a course
	 */
	@Test(priority = 2)
	public void TCSPR1100102() {

		CourseName = "Course Name" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID = (getText(cn.course_Id));

		// type-Course title
		type(cn.txbx_Coursetitle, CourseName);

		// click on Add students button
		click(cn.btn_AddStudents);

		Emailstudent1 = "studentone" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent2 = "studenttwo" + generateRandomNumber().trim() + "@gmail.com";
		
		// type email
		type(cn.tab_textbox, Emailstudent1 + ",");
		driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
		type(cn.tab_textbox, Emailstudent2 + ",");

		// verify email present on the text box
		Assert.assertEquals(cn.emailvalue(0), Emailstudent1);

		Assert.assertEquals(cn.emailvalue(1), Emailstudent2);

		// click on add to list button
		click(cn.tab_btn_Addtolist);

		waitThread(2000);
		waitFor(cr.emailval_1);

		// verify the Email on the New Students to be invited to this class box
		Assert.assertEquals(getText(cr.emailval_1), Emailstudent1);
		Assert.assertEquals(getText(ps.emailval_2), Emailstudent2);

		// click on create course button
		click(cn.btn_Createcourse);

		waitThread(1000);
		waitFor(cn.toaster);

		// verify toaster-Course created successfully
		Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");

		waitThread(3000);

		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), CourseName.trim());

	}
	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 3)
	public void TCSPR1100103() {

		waitThread(2000);
		// Perform logout
		sca.Logout();
		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on first student 's profile and
	 * accept course request-Read the student name
	 */

	@Test(priority = 4)
	public void TCSPR1100104() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent1, CourseID);
		String encText = et.EncryptCode(studentinviteid);

		driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);

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
	 * To check the labels and buttons
	 */
	@Test(priority = 5)
	public void TCSPR1100105() {

		// click on Assessment Tab
		click(sca.Assessmenttab);
		waitThread(10000);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");

		Assert.assertEquals(getText(sca.teacherlbl).trim(), "Teacher");
		Assert.assertEquals(getText(sca.lblcourse).trim(), "Course");
		Assert.assertEquals(getText(sca.totalassessmentlbl).trim(), "Total Assessments: 0");
		
		Assert.assertEquals(getText(sca.lblgridempty).trim(), "No assessment available");
	}

	/*
	 * To verify the drop downs on the student assessment tab page
	 */

	@Test(priority = 6)
	public void TCSPR1100106() {

		Assert.assertTrue(isElementPresent(sca.teacherdd), "Teacher Dropdown Not visible");
		Assert.assertTrue(isElementPresent(sca.teacherdddisable), "Teacher Dropdown is Enable");
		Assert.assertTrue(isElementPresent(sca.coursedd), "Course Dropdown Not visible");
		Assert.assertTrue(isElementPresent(sca.coursedddisable), "Course Dropdown is Enable");
		Assert.assertTrue(isElementPresent(sca.searchbox), "Assessment Search box not visible");
		Assert.assertEquals(getText(sca.searchbox1), "Search Assessments");
		Assert.assertTrue(isElementPresent(sca.advancefilterbx), "Advance Filter Section Not visible");

	}

	/*
	 * To check the check boxes and labels on the Apply filter section
	 */
	@Test(priority = 7)
	public void TCSPR1100107() {

		// Labels
		Assert.assertEquals(getText(sca.lblupcomingtest), "Upcoming Tests");
		Assert.assertEquals(getText(sca.lbltestactive), "Test Active");
		Assert.assertEquals(getText(sca.lblupcomingreview), "Upcoming Peer-Reviews");
		Assert.assertEquals(getText(sca.lblreviewactive), "Peer-Review Active");
		Assert.assertEquals(getText(sca.lblresultupcoming), "Upcoming Results");
		Assert.assertEquals(getText(sca.lblresultavailable), "Result Available");

		// Check boxes
		Assert.assertTrue(isElementPresent(sca.upcomingtestcheckbx), "Upcoming Tests check box not present");
		Assert.assertTrue(isElementPresent(sca.testactivechkbx), "Test Active check box not present");
		Assert.assertTrue(isElementPresent(sca.upcomimgreviewchkbx), "Upcoming Peer-Reviews check box not present");
		Assert.assertTrue(isElementPresent(sca.reviewactiveckbx), "Peer-review Active check box not present");
		Assert.assertTrue(isElementPresent(sca.upcomingresultchkbx), "Upcoming Results check box not present");
		Assert.assertTrue(isElementPresent(sca.resultavailablechkbx), "Result Available check box  not present");

		// Assessment search box
		Assert.assertTrue(isElementPresent(sca.searchbox), "Assessment Search box not visible");
	}

	/*
	 * To perform tab switch functionality from assessment landing page
	 */
	@Test(priority = 8)
	public void TCSPR1100108() {

		// click on My courses tab
		click(sca.MyCoursetab1);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(sca.selectedcoursetab1), "Course tab is not selected");

		// verify the the course name
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());

	}

	/*
	 * To Accept the course
	 */
	@Test(priority = 9)
	public void TCSPR1100109() {

		// click on accept course button
		click(rs.btn_acceptcourse);

		// verify the confirmation pop up visible
		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");

		// click on Yes button
		click(rs.popupbtn_Yes);

		// Toaster message
		waitFor(rs.toaster);
		Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");

		// verify the course name visible on the enrolled section
		waitFor(rs.enrolledcoursename);
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());
		waitThread(3000);

	}

	/*
	 * To check the enrolled course teacher name visible on the teacher drop down
	 */

	@Test(priority = 10)
	public void TCSPR1100110() {

		// click on Assessment Tab
		click(sca.Assessmenttab);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		waitThread(1000);
		Assert.assertFalse(isElementPresent(sca.teacherdddisable), "Teacher Dropdown is Disable");
		Assert.assertTrue(isElementPresent(sca.coursedddisable), "Course Dropdown is Enable");

		// click on Teacher Drop down
		click(sca.teacherdd);
		Assert.assertTrue(isElementPresent(sca.teacherdd), "Dropddownpanel not visible");
		waitThread(6000);
		Assert.assertTrue(isElementPresent(sca.ddteachername), "Teacher Name not visible");
		// TO verify the Teacher name
		Assert.assertEquals(getText(sca.ddteachernamelbl).trim(), Teachername.trim());
		// To select the Teacher name from drop down
		click(sca.ddteachername);
		// To check the selected teacher name on the Drop down
		Assert.assertEquals(getText(sca.teachernamedd), Teachername.trim());
		waitThread(2000);
		// To check the course drop down is enable
		Assert.assertFalse(isElementPresent(sca.coursedddisable), "Course Dropdown is Disable");
		// To check the place Holder
		Assert.assertEquals(getAttribute(sca.lblallselected, "placeholder"), "All Selected");
		// click on course drop down
		click(sca.coursedd);
		waitThread(2000);
		// To check the course name pn the Drop down
		Assert.assertEquals(getText(sca.courseddallselect), CourseName.trim());
		// To select the course from course drop down
		click(sca.courseddallselect);
		waitThread(2000);
		// To check the selected course on the Drop down
		Assert.assertEquals(getText(sca.courseddselectedlbl), CourseName.trim());
		// To check the Grid label
		Assert.assertEquals(getText(sca.lblgridempty).trim(), "No assessment available");

	}

	/*
	 * To perform logout functionality on the student 1 profile
	 */
	@Test(priority = 11)
	public void TCSPR1100111() {

		TCSPR1100103();

	}

	/*
	 * To perform login functionality of teacher and perform delete course
	 * functionality
	 */
	@Test(priority = 12)
	public void TCSPR1100112() {

		lg.login(Emailteacher, password);
		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// click on details button dropdown
		click(cn.btn_details_1);

		// Click on delete course link
		click(cn.link_deletecourse1);
		waitThread(2000);

		// click on Yes button
		click(cn.delete_yes);
		waitFor(cn.toaster);

		// verify toaster message-Course deleted successfully
		Assert.assertEquals(getText(cn.toaster), "Course deleted successfully");
		waitThread(4000);

		// verify the course name not present on the grid
		Assert.assertFalse(isElementPresent(ec.coursename), "Course name present");

	}

	/*
	 * To check the No course popup functionality while click on Assessment tab
	 */
	@Test(priority = 13)
	public void TCSPR1100113() {

		// click on Assessment Tab
		click(natb.Assessmenttab);

		// check the popup and ok button visible
		Assert.assertTrue(isElementPresent(cn.nocoursepopup), "No Course pop up not visible");
		Assert.assertTrue(isElementPresent(cn.btn_ok), "Ok button not visible");
		waitThread(2000);
		// verify text
		Assert.assertEquals(getText(cn.nocoursepopuptxt),
				"Assessments can only be created once you have created one or more courses. Please click “OK” to dismiss this message.");

		// click on ok button and check the popup not visible
		click(cn.btn_ok);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(cn.nocoursepopup), "No Course pop up  visible");
		// verify the course tab is selected
		Assert.assertTrue(getAttribute(cn.btnheader_course, "class").contains("active"));

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 14)
	public void TCSPR1100114() {

		TCSPR1100103();

	}

	/*
	 * To perform student login functionality and check that the deleted course
	 * visible on the student profile
	 */
	@Test(priority = 15)
	public void TCSPR1100115() {

		lg.login(Emailstudent1, password);
		click(sca.MyCoursetab1);
		Assert.assertTrue(isElementPresent(sca.btnnewjoincourse), "Join New Course button not visible");
		Assert.assertFalse(isElementPresent(rs.enrolledcoursename), CourseName.trim() + "  visible");

		// click on Assessments Tab
		click(sca.Assessmenttab);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		Assert.assertTrue(isElementPresent(sca.teacherdddisable), "Teacher Dropdown is Enable");
		Assert.assertTrue(isElementPresent(sca.coursedddisable), "Course Dropdown is Enable");

	}

	/*
	 * To perform logout functionality on the student 1 profile
	 */
	@Test(priority = 16)
	public void TCSPR1100116() {

		TCSPR1100103();

	}

	/*
	 * Perform teacher login functionality
	 */
	@Test(priority = 17)
	public void TCSPR1100117() {

		lg.login(Emailteacher, password);
		// To verify the create new course button
		Assert.assertTrue(isElementPresent(cn.btn_createnew), "Create new course button not present");

	}

	/*
	 * To create new course
	 */
	@Test(priority = 18)
	public void TCSPR1100118() {

		CourseName = "Course Name" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID = (getText(cn.course_Id));

		// type-Course title
		type(cn.txbx_Coursetitle, CourseName);

		// click on Add students button
		click(cn.btn_AddStudents);

		// type email
		type(cn.tab_textbox, Emailstudent1 + ",");
		driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
		type(cn.tab_textbox, Emailstudent2 + ",");

		// verify email present on the text box
		Assert.assertEquals(cn.emailvalue(0), Emailstudent1);

		Assert.assertEquals(cn.emailvalue(1), Emailstudent2);

		// click on add to list button
		click(cn.tab_btn_Addtolist);

		waitThread(2000);
		waitFor(cr.emailval_1);

		// verify the Email on the New Students to be invited to this class box
		Assert.assertEquals(getText(cr.emailval_1), Emailstudent1);
		Assert.assertEquals(getText(ps.emailval_2), Emailstudent2);

		// click on create course button
		click(cn.btn_Createcourse);

		waitThread(1000);
		waitFor(cn.toaster);

		// verify toaster-Course created successfully
		Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");

		waitThread(3000);

		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), CourseName.trim());

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 19)
	public void TCSPR1100119() {

		TCSPR1100103();

	}

	/*
	 * To check that invited course request visible on first student 's profile and
	 * accept course request-Read the student name
	 */

	@Test(priority = 20)
	public void TCSPR1100120() {

		lg.login(Emailstudent1, password);
		click(sca.MyCoursetab1);
		
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

	@Test(priority = 21)
	public void TCSPR1100121() {

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
	 * To check that invited course request visible on second student's profile and
	 * course request-Read the student name
	 */
	@Test(priority = 22)
	public void TCSPR1100122() throws SQLException {

		waitThread(2000);
		studentinviteid = dc.InviteLink(Emailstudent2, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);

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

		// click sign up button
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
	@Test(priority = 23)
	public void TCSPR1100123() {

		// click on accept course button
		click(rs.btn_acceptcourse);

		// verify the confirmation popup visible
		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");

		// click on Yes button
		click(rs.popupbtn_Yes);

		// Toaster message
		waitFor(rs.toaster);
		Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");

		// verify the course name visible on the enrolled section
		waitFor(rs.enrolledcoursename);
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}
	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */

	@Test(priority = 24)
	public void TCSPR1100124() {

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

		// select course name
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
	@Test(priority = 25)
	public void TCSPR1100125() {
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
	 * To verify details on the peer review page
	 */

	@Test(priority = 26)
	public void TCSPR1100126() {

		waitThread(2000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));
		// Assert course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");

		// Assert the student names
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Student1name.trim());
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Student2name.trim());

	}
	/*
	 * To verify details on the schedule page and summary page
	 */

	@Test(priority = 27)
	public void TCSPR1100127() {

		type(pr.PRreward_txtbox, "50");
		waitThread(3000);

		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the peer schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");
		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.scheduleassessmentname).contains("Assessment Name: " + AssessmentName));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.schedulecoursename).contains(CourseID));
		Assert.assertTrue(getText(sb.schedulecoursename).contains(CourseName.trim()));
		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");
		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.summaryassessmentname).contains("Assessment Name: " + AssessmentName));

	}

	/*
	 * To perform Assessment publish functionality and check the details on the
	 * publish pop up
	 */
	@Test(priority = 28)
	public void TCSPR1100128() {

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

	@Test(priority = 29)
	public void TCSPR1100129() {

		// click on Back To Menu Button
		click(natb.btnbacktomenu);
		Assert.assertFalse(isElementPresent(natb.publishpopup), "Publish popup  visible");
		waitThread(1000);
		Assert.assertTrue(isElementPresent(natb.selectedassessmenttab), "Assessment tab not selected");

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");

		// Assert the Assessment name visible
		Assert.assertEquals(getText(natb.cardassessmentname1), AssessmentName);
		Assert.assertEquals(getText(natb.cardcoursename1), "For" + " " + CourseName.trim() + "(" + CourseID + ")");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 30)
	public void TCSPR1100130() {

		TCSPR1100103();

	}

	/*
	 * Perform Login functionality as student 1
	 */
	@Test(priority = 31)
	public void TCSPR1100131() {

		lg.login(Emailstudent1, password);
		waitThread(2000);
		click(sca.MyCoursetab1);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(sca.btnnewjoincourse), "Join New Course button not visible");
		Assert.assertTrue(isElementPresent(rs.enrolledcoursename), CourseName + " Not visible");

	}

	/*
	 * To check that the published assessment visible on student 1 current
	 * assessment section
	 */
	@Test(priority = 32)
	public void TCSPR1100132() {

		// click on Assessment Tab
		click(sca.Assessmenttab);

		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		Assert.assertTrue(isElementPresent(sca.tabcurrentassessment), "Current Assessment tab not visible");
		Assert.assertEquals(getAttribute(sca.selectedcurrenttab, "aria-selected"), "true");
		Assert.assertEquals(getAttribute(sca.teacherdd, "placeholder"), "All Selected");

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");

		// Assert the Assessment name visible
		Assert.assertEquals(getText(natb.cardassessmentname1), AssessmentName);
		Assert.assertEquals(getText(natb.cardcoursename1), "For" + " " + CourseName.trim() + "(" + CourseID + ")");

	}

	/*
	 * To perform logout functionality on the student 1 profile
	 */
	@Test(priority = 33)
	public void TCSPR1100133() {

		TCSPR1100103();

	}

	/*
	 * Perform Login functionality as student 2
	 */
	@Test(priority = 34)
	public void TCSPR1100134() {

		lg.login(Emailstudent2, password);
		waitThread(2000);
		click(sca.MyCoursetab1);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(sca.btnnewjoincourse), "Join New Course button not visible");
		Assert.assertTrue(isElementPresent(rs.enrolledcoursename), CourseName + " Not visible");

	}
	/*
	 * To check that the published assessment visible on student 2 current
	 * assessment section
	 */

	@Test(priority = 35)
	public void TCSPR1100135() {

		TCSPR1100132();

	}

	/*
	 * To perform logout functionality on the student 2 profile
	 */
	@Test(priority = 36)
	public void TCSPR1100136() {

		TCSPR1100103();

	}
	/*
	 * Perform teacher login functionality
	 */

	@Test(priority = 37)
	public void TCSPR1100137() {

		TCSPR1100117();

	}

	public String NewCourseName;

	/*
	 * To modify the course name from course details page and check the updated
	 * course name on the card
	 */
	@Test(priority = 38)
	public void TCSPR1100138() {

		SoftAssert softAssert3 = new SoftAssert();

		// click on course tab
		click(ba.CourseTab);

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
		waitThread(3000);
		// verify the following buttons disabled
		Assert.assertFalse(isEnabled(ec.btnsave), "Save button is enabled");

		softAssert3.assertAll();

	}
	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 39)
	public void TCSPR1100139() {

		TCSPR1100103();

	}

	/*
	 * Perform Login functionality as student 1
	 */
	@Test(priority = 40)
	public void TCSPR1100140() {

		lg.login(Emailstudent1, password);
		waitThread(2000);
		click(sca.MyCoursetab1);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(sca.btnnewjoincourse), "Join New Course button not visible");

		// verify the course name visible on the enrolled section
		waitFor(rs.enrolledcoursename);
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), NewCourseName.trim());
		waitThread(3000);

	}

	/*
	 * To check the updated course name visible on the current assessment tab
	 */
	@Test(priority = 41)
	public void TCSPR1100141() {

		// click on Assessment Tab
		click(sca.Assessmenttab);

		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		Assert.assertTrue(isElementPresent(sca.tabcurrentassessment), "Current Assessment tab not visible");
		Assert.assertEquals(getAttribute(sca.selectedcurrenttab, "aria-selected"), "true");
		Assert.assertEquals(getAttribute(sca.teacherdd, "placeholder"), "All Selected");

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");

		// Assert the Assessment name visible
		Assert.assertEquals(getText(natb.cardassessmentname1), AssessmentName);
		Assert.assertEquals(getText(natb.cardcoursename1), "For" + " " + NewCourseName.trim() + "(" + CourseID + ")");

	}

	/*
	 * To perform logout functionality on the student 1 profile
	 */
	@Test(priority = 42)
	public void TCSPR1100142() {

		TCSPR1100103();

	}

	/*
	 * Perform Login functionality as student 2
	 */
	@Test(priority = 43)
	public void TCSPR1100143() {

		lg.login(Emailstudent2, password);
		waitThread(2000);
		
		click(sca.MyCoursetab1);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(sca.btnnewjoincourse), "Join New Course button not visible");
		// verify the course name visible on the enrolled section
		waitFor(rs.enrolledcoursename);
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), NewCourseName.trim());
		waitThread(3000);
	}

	/*
	 * To check the updated course name visible on the current assessment tab
	 */
	@Test(priority = 44)
	public void TCSPR1100144() {

		// click on Assessment Tab
		click(sca.Assessmenttab);

		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		Assert.assertTrue(isElementPresent(sca.tabcurrentassessment), "Current Assessment tab not visible");
		Assert.assertEquals(getAttribute(sca.selectedcurrenttab, "aria-selected"), "true");
		Assert.assertEquals(getAttribute(sca.teacherdd, "placeholder"), "All Selected");

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");

		// Assert the Assessment name visible
		Assert.assertEquals(getText(natb.cardassessmentname1), AssessmentName);
		Assert.assertEquals(getText(natb.cardcoursename1), "For" + " " + NewCourseName.trim() + "(" + CourseID + ")");

	}
	/*
	 * To perform logout functionality on the student 2 profile
	 */

	@Test(priority = 45)
	public void TCSPR1100145() {

		TCSPR1100103();

	}

	/*
	 * Perform teacher login functionality
	 */
	@Test(priority = 46)
	public void TCSPR1100146() {

		lg.login(Emailteacher, password);
		// To verify the create new course button
		Assert.assertTrue(isElementPresent(cn.btn_createnew), "Create new course button not present");

	}

	public String CourseNameNew1;
	public String NewcourseId;

	/*
	 * To create a new course
	 */

	@Test(priority = 47)
	public void TCSPR1100147() {

		CourseNameNew1 = "GK" + " " + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		NewcourseId = (getText(cn.course_Id));

		// type-Course title
		type(cn.txbx_Coursetitle, CourseNameNew1);

		// click on Add students button
		click(cn.btn_AddStudents);

		// click on Add students from my student list tab
		click(cn.tab_Addstudent);
		Assert.assertEquals(getAttribute(cn.tab_Addstudent, "aria-selected"), "true");
		click(cn.taballcheckbx);
		Assert.assertEquals(getAttribute(cn.taballcheckbx, "aria-checked"), "true");
		waitThread(1000);
		// click on add to list button
		click(cn.tab_btn_Addtolist);

		waitThread(2000);

		// verify the Email on the New Students to be invited to this class box
		Assert.assertEquals(getText(cn.mystudent1), Emailstudent1);

		Assert.assertEquals(getText(cn.mystudent2), Emailstudent2);

		// click on create course button
		click(cn.btn_Createcourse);

		waitThread(1000);
		waitFor(cn.toaster);

		// verify toaster-Course created successfully
		Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");

		waitThread(3000);
		type(sca.teachercoursesearchbox, CourseNameNew1.trim());

		waitThread(1000);
		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), CourseNameNew1.trim());

		// To perform logout functionality on the teacher profile

		TCSPR1100103();

	}
	/*
	 * Perform Login functionality as student 1
	 */

	@Test(priority = 48)
	public void TCSPR1100148() {

		lg.login(Emailstudent1, password);
		waitThread(2000);
		
		click(sca.MyCoursetab1);
		waitThread(2000);

		Assert.assertTrue(isElementPresent(sca.btnnewjoincourse), "Join New Course button not visible");
		// verify the the new course name on the invite card
		Assert.assertEquals(getText(rs.course_name).trim(), CourseNameNew1.trim());
	}

	/*
	 * To Accept the new course and perform logout functionality on the student
	 * profile
	 */
	@Test(priority = 49)
	public void TCSPR1100149() {

		// click on accept course button
		click(rs.btn_acceptcourse);

		// verify the confirmation popup visible
		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");

		// click on Yes button
		click(rs.popupbtn_Yes);

		// Toaster message
		waitFor(rs.toaster);
		Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
		waitThread(1000);
		type(sca.studentcoursesearch, CourseNameNew1.trim());
		waitThread(1000);
		// verify the course name visible on the enrolled section
		waitFor(rs.enrolledcoursename);
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseNameNew1.trim());
		waitThread(3000);

		// To perform logout functionality on the student 1 profile

		TCSPR1100103();

	}

	/*
	 * Perform Login functionality as student 2
	 */
	@Test(priority = 50)
	public void TCSPR1100150() {

		lg.login(Emailstudent2, password);
		waitThread(2000);
		click(sca.MyCoursetab1);
		waitThread(2000);

		Assert.assertTrue(isElementPresent(sca.btnnewjoincourse), "Join New Course button not visible");
		// verify the the course name
		Assert.assertEquals(getText(rs.course_name).trim(), CourseNameNew1.trim());

	}

	/*
	 * To Accept course and perform logout functionality on the student profile
	 */
	@Test(priority = 51)
	public void TCSPR1100151() {

		// click on accept course button
		click(rs.btn_acceptcourse);

		// verify the confirmation pop up visible
		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");

		// click on Yes button
		click(rs.popupbtn_Yes);

		// Toaster message
		waitFor(rs.toaster);
		Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
		waitThread(1000);
		type(sca.studentcoursesearch, CourseNameNew1.trim());
		waitThread(1000);
		// verify the course name visible on the enrolled section
		waitFor(rs.enrolledcoursename);
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseNameNew1.trim());
		waitThread(3000);

		// To perform logout functionality on the student 2 profile

		TCSPR1100103();

	}

	/*
	 * Perform teacher login functionality
	 */
	@Test(priority = 52)
	public void TCSPR1100152() {

		rs.login_Teacher(Emailteacher, password);

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(5000);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

	}

	public String NewAssessmentName;

	/*
	 * To create a new assessment and publish the assessment
	 */
	@Test(priority = 53)
	public void TCSPR1100153() {

		SoftAssert softAssert1 = new SoftAssert();

		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);

		// To click on course drop down
		click(ba.dd_course);
		waitThread(2000);
		waitFor(ba.ddcoursename2);

		softAssert1.assertEquals(getText(ba.ddcoursename2), CourseNameNew1.trim(),
				"course name not visible on the dropdown");

		// Select the new course name
		click(ba.ddcoursename2);
		waitThread(2000);
		// Type Assessment Name
		click(QP.Assess_name);
		NewAssessmentName = "New Assessment" + " " + generateRandomNumber().trim();

		type(QP.Assess_name, NewAssessmentName.trim());

		waitThread(1000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(1000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(3000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), NewAssessmentName.trim());

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + NewcourseId + ", " + CourseNameNew1.trim());

		softAssert1.assertAll();

	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 54)
	public void TCSPR1100154() {

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
	 * To verify details on the peer review page and publish the Assessment
	 */

	@Test(priority = 55)
	public void TCSPR1100155() {

		waitThread(2000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + NewAssessmentName));
		// Assert course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseNameNew1.trim()));

		type(pr.PRreward_txtbox, "50");
		waitThread(3000);

		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the peer schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");

		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");
		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.summaryassessmentname).contains("Assessment Name: " + NewAssessmentName));

		// click on Release Button
		click(sb.btnrelease);
		waitFor(QP.toaster);
		// Assert toaster "Assessment published successfully
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");
		click(QP.toasterclosebtn);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(natb.publishpopup), "Publish popup not visible");
		// click on Back To Menu Button
		click(natb.btnbacktomenu);
		Assert.assertFalse(isElementPresent(natb.publishpopup), "Publish popup  visible");
		waitThread(1000);
		Assert.assertTrue(isElementPresent(natb.selectedassessmenttab), "Assessment tab not selected");

	}

	/*
	 * To check the newly created assessment card visible on the teacher profile
	 */
	@Test(priority = 56)
	public void TCSPR1100156() {

		// Search The Assessment Name
		type(sca.teacherassessmentsearchbox, NewAssessmentName.trim());
		waitThread(1000);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");

		// Assert the Assessment name visible
		Assert.assertEquals(getText(natb.cardassessmentname1), NewAssessmentName);
		Assert.assertEquals(getText(natb.cardcoursename1),
				"For" + " " + CourseNameNew1.trim() + "(" + NewcourseId + ")");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 57)
	public void TCSPR1100157() {

		TCSPR1100103();

	}

	/*
	 * Perform Login functionality as student 1
	 */
	@Test(priority = 58)
	public void TCSPR1100158() {

		lg.login(Emailstudent1, password);
		waitThread(2000);
		click(sca.MyCoursetab1);
		waitThread(2000);

		Assert.assertTrue(isElementPresent(sca.btnnewjoincourse), "Join New Course button not visible");

	}

	/*
	 * To check that the newly published assessment visible on the student current
	 * assessment tab
	 */
	@Test(priority = 59)
	public void TCSPR1100159() {

		// click on Assessment Tab
		click(sca.Assessmenttab);

		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		Assert.assertTrue(isElementPresent(sca.tabcurrentassessment), "Current Assessment tab not visible");
		Assert.assertEquals(getAttribute(sca.selectedcurrenttab, "aria-selected"), "true");
		Assert.assertEquals(getAttribute(sca.teacherdd, "placeholder"), "All Selected");

		// To verify the number of assessment cards
		Assert.assertEquals(TotalElementsCount(natb.cardcount), 2);

		// Click on Teacher Drop down
		click(sca.teacherdd);
		// To check the teacher name
		Assert.assertTrue(isElementPresent(sca.ddteachername), "Teacher Name visible");
		waitThread(2000);
		Assert.assertEquals(getText(sca.ddteachernamelbl).trim(), Teachername.trim());

		// To select the teacher name from drop down
		click(sca.ddteachername);

		// To check the selected teacher name on the drop down
		Assert.assertEquals(getText(sca.teachernamedd), Teachername.trim());
		waitThread(2000);
		// TO check the course drop down status
		Assert.assertFalse(isElementPresent(sca.coursedddisable), "Course Dropdown is Disable");
		Assert.assertEquals(getAttribute(sca.lblallselected, "placeholder"), "All Selected");

		// click on course drop down
		click(sca.coursedd);
		waitThread(2000);
		Assert.assertEquals(getText(sca.ddcoursename2), CourseNameNew1.trim());

		// To select the new course name
		click(sca.ddcoursename2);

		// To check the drop down selected course name
		Assert.assertEquals(getText(sca.courseddselectedlbl), CourseNameNew1.trim());

		// To verify the number of assessment cards
		Assert.assertEquals(TotalElementsCount(natb.cardcount), 1);

		waitThread(2000);
		// Assert the Assessment name and course name on the card
		Assert.assertEquals(getText(natb.cardassessmentname1), NewAssessmentName);
		Assert.assertEquals(getText(natb.cardcoursename1),
				"For" + " " + CourseNameNew1.trim() + "(" + NewcourseId + ")");

		waitThread(3000);
		// click on course dropdown
		click(sca.coursedd);

		waitThread(2000);
		Assert.assertTrue(isElementPresent(sca.tabcoursedropdown), "Course Dropdown not Visible");

		waitThread(2000);
		// click on All select option on the course drop down
		click(sca.courseddallselect);
		Assert.assertEquals(getAttribute(sca.lblallselected, "placeholder"), "All Selected");

		waitThread(1000);
		// To verify the number of assessment cards
		Assert.assertEquals(TotalElementsCount(natb.cardcount), 2);
	}

	/*
	 * To perform logout functionality on the student 1 profile
	 */
	@Test(priority = 60)
	public void TCSPR1100160() {

		TCSPR1100103();
	}

	/*
	 * Perform Login functionality as student 2
	 */
	@Test(priority = 61)
	public void TCSPR1100161() {

		lg.login(Emailstudent2, password);
		waitThread(2000);
		click(sca.MyCoursetab1);
		waitThread(2000);

		Assert.assertTrue(isElementPresent(sca.btnnewjoincourse), "Join New Course button not visible");

	}

	/*
	 * To check that the newly published assessment visible on the current
	 * assessment tab of Student 2
	 */
	@Test(priority = 62)
	public void TCSPR1100162() {

		// click on Assessment Tab
		click(sca.Assessmenttab);

		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		Assert.assertTrue(isElementPresent(sca.tabcurrentassessment), "Current Assessment tab not visible");
		Assert.assertEquals(getAttribute(sca.selectedcurrenttab, "aria-selected"), "true");
		Assert.assertEquals(getAttribute(sca.teacherdd, "placeholder"), "All Selected");

		// To verify the number of assessment cards
		Assert.assertEquals(TotalElementsCount(natb.cardcount), 2);

		// click on Teacher Drop down
		click(sca.teacherdd);

		// To check the teacher name
		Assert.assertTrue(isElementPresent(sca.ddteachername), "Teacher Name visible");
		waitThread(2000);
		Assert.assertEquals(getText(sca.ddteachernamelbl).trim(), Teachername.trim());

		waitThread(2000);
		// To select the teacher name from drop down
		click(sca.ddteachername);

		waitThread(2000);
		// To check the selected teacher name on the drop down
		Assert.assertEquals(getText(sca.teachernamedd), Teachername.trim());

		waitThread(2000);
		// TO check the course drop down status
		Assert.assertFalse(isElementPresent(sca.coursedddisable), "Course Dropdown is Disable");
		Assert.assertEquals(getAttribute(sca.lblallselected, "placeholder"), "All Selected");

		waitThread(2000);
		// click on course drop down
		click(sca.coursedd);
		waitThread(2000);
		Assert.assertEquals(getText(sca.ddcoursename2), CourseNameNew1.trim());

		waitThread(2000);
		// To select the new course name
		click(sca.ddcoursename1);

		// To check the drop down selected course name
		Assert.assertEquals(getText(sca.courseddselectedlbl), NewCourseName.trim());
		waitThread(2000);

		// To verify the number of assessment cards
		Assert.assertEquals(TotalElementsCount(natb.cardcount), 1);

		// Assert the Assessment name and course name on the card
		Assert.assertEquals(getText(natb.cardassessmentname1), AssessmentName);
		Assert.assertEquals(getText(natb.cardcoursename1), "For" + " " + NewCourseName.trim() + "(" + CourseID + ")");

		waitThread(2000);
		// click on course drop down
		click(sca.coursedd);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(sca.tabcoursedropdown), "Course Dropdown not Visible");

		// click on All select option on the course drop down
		click(sca.courseddallselect);
		Assert.assertEquals(getAttribute(sca.lblallselected, "placeholder"), "All Selected");

		// To verify the number of assessment cards
		Assert.assertEquals(TotalElementsCount(natb.cardcount), 2);
	}

	/*
	 * To perform Delete student2 Account functionality
	 */
	@Test(priority = 63)
	public void TCSPR1100163() {

		waitThread(2000);
		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 2 profile credentials
	 */
	@Test(priority = 64)
	public void TCSPR1100164() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent2, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}
	/*
	 * To perform Delete student1 Account functionality
	 */

	@Test(priority = 65)
	public void TCSPR1100165() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent1, password);

		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 1 profile credentials
	 */
	@Test(priority = 66)
	public void TCSPR1100166() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent1, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}
	/*
	 * To perform Delete Teacher Account functionality
	 */

	@Test(priority = 67)
	public void TCSPR1100167() {

		// login using deleted account credentials
		rs.login_Teacher(Emailteacher, password);

		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform login functionality using deleted teacher profile credentials
	 */
	@Test(priority = 68)
	public void TCSPR1100168() {

		// login using deleted account credentials
		rs.login_Teacher(Emailteacher, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

}
