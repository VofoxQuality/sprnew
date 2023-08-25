package NewAssessmentOfTeacherTest;

import java.sql.SQLException;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.NewAssessmentTeacherBasicsPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class NewAssessmentTeacherBasicsTest extends basePage {

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
	public void TCSPR1000101() {

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
	 * To check the labels on the assessment page
	 */

	@Test(priority = 3)
	public void TCSPR1000102() {

		click(natb.Assessmenttab);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(natb.selectedassessmenttab), "Assessment tab not selected");
		Assert.assertEquals(getText(natb.lblcourse), "Course");
		waitFor(natb.gridlabl);
		Assert.assertEquals(getText(natb.gridlabl), "No assessment available");
		Assert.assertEquals(getAttribute(natb.ddcourse, "placeholder"), "All");

	}
	/*
	 * To check the course drop down functionality on the assessment page
	 */

	@Test(priority = 4)
	public void TCSPR1000103() {

		Assert.assertTrue(isElementPresent(natb.ddcourse), "Course dropdown not present");
		// click on course droddown
		click(natb.ddcourse);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(natb.ddpopup), "Course dropdown popup not present");
		Assert.assertTrue(isElementPresent(natb.ddcoursesearchbox), "Course dropdown search not present");
		//click on course dropdown
		click(natb.ddcourse);
		Assert.assertTrue(isElementPresent(natb.btnapplyfilter), "Advanced Filter Section not present");
	}

	/*
	 * To check the buttons and labels on the Apply filter section
	 */
	@Test(priority = 5)
	public void TCSPR1000104() {
		waitThread(1000);
		Assert.assertTrue(isElementPresent(natb.upcomingtestcheckbx), "Upcoming Tests check box not present");
		Assert.assertTrue(isElementPresent(natb.testactivechkbx), "Test Active check box not present");
		Assert.assertTrue(isElementPresent(natb.upcomimgreviewchkbx), "Upcoming Peer-Reviews check box not present");
		Assert.assertTrue(isElementPresent(natb.reviewactiveckbx), "Peer-review Active check box not present");
		Assert.assertTrue(isElementPresent(natb.upcomingresultchkbx), "Upcoming Results check box not present");
		Assert.assertTrue(isElementPresent(natb.resultavailablechkbx), "Result Available check box  not present");

		Assert.assertEquals(getText(natb.lblupcomingtest), "Upcoming Tests");
		Assert.assertEquals(getText(natb.lbltestactive), "Test Active");
		Assert.assertEquals(getText(natb.lblupcomingreview), "Upcoming Peer-Reviews");
		Assert.assertEquals(getText(natb.lblreviewactive), "Peer-Review Active");
		Assert.assertEquals(getText(natb.lblresultupcoming), "Upcoming Results");
		Assert.assertEquals(getText(natb.lblresultavailable), "Result Available");

	}

	/*
	 * To perform tab switch functionality from assessment landing page
	 */

	@Test(priority = 6)
	public void TCSPR1000105() {

		click(natb.Coursetab);
		Assert.assertTrue(isElementPresent(natb.selectedassessmenttab), "Course tab not selected");
		// To verify the create new course button
		Assert.assertTrue(isElementPresent(cn.btn_createnew), "Create new course button not present");

	}

	/*
	 * To perform the create new course functionality on the landing page.
	 */
	@Test(priority = 2)
	public void TCSPR1000106() {

		CourseName = "Course Name" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID = (getText(cn.course_Id));

		// type-Course title
		type(cn.txbx_Coursetitle, CourseName);

		// click on Add students button
		click(cn.btn_AddStudents);

		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";
		

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
	 * To verify that the created course visible on the assessment page course
	 * drop down
	 */
	@Test(priority = 7)
	public void TCSPR1000107() {

		click(natb.Assessmenttab);
		Assert.assertTrue(isElementPresent(natb.selectedassessmenttab), "Assessment tab not selected");

		click(natb.ddcourse);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(natb.ddpopup), "Course dropdown popup not present");

		// verify the course title
		Assert.assertEquals(getText(natb.ddcourse1).trim(), CourseName.trim());
		click(natb.ddcourse1);
		waitThread(1000);
		Assert.assertEquals(getText(natb.selectedddvalue).trim(), CourseName.trim());

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 8)
	public void TCSPR1000108() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}
	/*
	 * To check that invited course request visible on first student 's profile
	 * and accept course request-Read the student name
	 */

	@Test(priority = 9)
	public void TCSPR1000109() throws SQLException {

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
	 * To Accept course and perform logout functionality on the student profile
	 */

	@Test(priority = 10)
	public void TCSPR1000110() {

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
	 * To check that invited course request visible on second student's profile
	 * and course request-Read the student name
	 */
	@Test(priority = 11)
	public void TCSPR1000111() throws SQLException {

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
	@Test(priority = 12)
	public void TCSPR1000112() {

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

	@Test(priority = 13)
	public void TCSPR1000113() {

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
	@Test(priority = 14)
	public void TCSPR1000114() {

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

	@Test(priority = 15)
	public void TCSPR1000115() {

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

	@Test(priority = 16)
	public void TCSPR1000116() {

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

	@Test(priority = 17)
	public void TCSPR1000117() {

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
	@Test(priority = 18)
	public void TCSPR1000118() {

		click(natb.btnbacktomenu);
		Assert.assertFalse(isElementPresent(natb.publishpopup), "Publish popup  visible");
		waitThread(1000);
		Assert.assertTrue(isElementPresent(natb.selectedassessmenttab), "Assessment tab not selected");

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		
		// Search The Assessment Name
		type(natb.teacherassessmentsearchbox, AssessmentName.trim());
		waitThread(1000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(2000);

		// Assert the Assessment name visible
		Assert.assertEquals(getText(natb.cardassessmentname1), AssessmentName);
		Assert.assertEquals(getText(natb.cardcoursename1), "For" + " " + CourseName.trim() + " (" + CourseID + ")");

	}

	public String NewCourseName;

	/*
	 * To modify the course name from course details page and check the updated
	 * course name on the card
	 */
	@Test(priority = 19)
	public void TCSPR1000119() {

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
		waitThread(1000);
		// verify the following buttons disabled
		Assert.assertFalse(isEnabled(ec.btnsave), "Save button is enabled");

		click(natb.Assessmenttab);
		waitThread(3000);
		Assert.assertTrue(isElementPresent(natb.selectedassessmenttab), "Assessment tab not selected");
		
		// Search The Assessment Name
		type(natb.teacherassessmentsearchbox, AssessmentName.trim());
		waitThread(1000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(2000);
		
		// Assert the Assessment name visible
		Assert.assertEquals(getText(natb.cardassessmentname1), AssessmentName.trim());
		Assert.assertEquals(getText(natb.cardcoursename1), "For" + " " + NewCourseName.trim() + " (" + CourseID + ")");

		softAssert3.assertAll();

	}

	/*
	 * To perform tab switch functionality from assessment landing page
	 */

	@Test(priority = 20)
	public void TCSPR1000120() {

		click(natb.Coursetab);
		Assert.assertTrue(isElementPresent(natb.selectedassessmenttab), "Course tab not selected");
		// To verify the create new course button
		Assert.assertTrue(isElementPresent(cn.btn_createnew), "Create new course button not present");

	}

	public String NewCourseID;
	public String CourseNameNew;
	public String Emailstudent3;
	public String Emailstudent4;

	/*
	 * To perform the create new course functionality on the landing page.
	 */

	@Test(priority = 21)
	public void TCSPR1000121() {

		CourseNameNew = "GK" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		NewCourseID = (getText(cn.course_Id));

		// type-Course title
		type(cn.txbx_Coursetitle, CourseNameNew);

		// click on Add students button
		click(cn.btn_AddStudents);

		Emailstudent3 = "student3" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent4 = "student4" + generateRandomNumber().trim() + "@gmail.com";
		
		// type email
		type(cn.tab_textbox, Emailstudent3 + ",");
		driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
		type(cn.tab_textbox, Emailstudent4 + ",");

		// verify email present on the text box
		Assert.assertEquals(cn.emailvalue(0), Emailstudent3);

		Assert.assertEquals(cn.emailvalue(1), Emailstudent4);

		// click on add to list button
		click(cn.tab_btn_Addtolist);

		waitThread(2000);
		waitFor(cr.emailval_1);

		// verify the Email on the New Students to be invited to this class box
		Assert.assertEquals(getText(cr.emailval_1), Emailstudent3);
		Assert.assertEquals(getText(ps.emailval_2), Emailstudent4);

		// click on create course button
		click(cn.btn_Createcourse);

		waitThread(1000);
		waitFor(cn.toaster);

		// verify toaster-Course created successfully
		Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");

		waitThread(3000);

		// verify the course title
		Assert.assertEquals(getText(natb.coursename2).trim(), CourseNameNew.trim());

	}

	/*
	 * To check that newly created course name visible on the course drop down
	 */
	@Test(priority = 22)
	public void TCSPR1000122() {

		// click on assessment tab
		click(natb.Assessmenttab);
		Assert.assertTrue(isElementPresent(natb.selectedassessmenttab), "Assessment tab not selected");

		// click on course drop down
		click(natb.ddcourse);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(natb.ddpopup), "Course dropdown popup not present");
		Assert.assertEquals(getText(natb.ddcourse2), CourseNameNew.trim());

		// select course from drop down
		click(natb.ddcourse2);
		Assert.assertEquals(getText(natb.selectedddvalue).trim(), CourseNameNew.trim());
		waitThread(1000);
		Assert.assertEquals(getText(natb.gridlabl), "No assessment available");

		// click on draft tab and verify draft tab is selected
		click(ba.tabdraft);
		Assert.assertEquals(getAttribute(ba.tabdraftselected, "aria-selected"), "true");

		// To verify Current Assessment tab is selected
		click(ba.tabcurrectassessment);
		Assert.assertEquals(getAttribute(ba.tabcurrectassessment, "aria-selected"), "true");
		Assert.assertEquals(TotalElementsCount(natb.cardcount), 1);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		Assert.assertEquals(getAttribute(natb.ddcourse, "placeholder"), "All");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 23)
	public void TCSPR1000123() {

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on 3rd student's profile and
	 * accept course request
	 */
	@Test(priority = 24)
	public void TCSPR1000124() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent3, NewCourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);

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
		Assert.assertEquals(getText(rs.course_name).trim(), CourseNameNew.trim());

	}

	/*
	 * To Accept course and perform logout functionality on the student profile
	 */

	@Test(priority = 25)
	public void TCSPR1000125() {

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
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseNameNew.trim());
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
	@Test(priority = 26)
	public void TCSPR1000126() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent4, NewCourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);

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
		Assert.assertEquals(getText(rs.course_name).trim(), CourseNameNew.trim());

	}

	/*
	 * To Accept course and perform logout functionality on the student profile
	 */

	@Test(priority = 27)
	public void TCSPR1000127() {

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
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseNameNew.trim());
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * Perform teacher login functionality
	 */

	@Test(priority = 28)
	public void TCSPR1000128() {

		rs.login_Teacher(Emailteacher, password);

		// click on Assessment tab
		click(ba.Assessmenttab);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

	}

	public String AssessmentNameTest;

	/*
	 * To create a new assessment and publish the assessment
	 */
	@Test(priority = 29)
	public void TCSPR1000129() {

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(2000);

		// click on create new assessment button
		click(ba.btn_createnewassessment);
		waitThread(3000);
		bdt.TCSPR090103();

		// To click on course dropdown
		click(ba.dd_course);
		// select latest added course
		click(ba.ddcoursename2);

		// Type new assessment name
		AssessmentNameTest = "Test" + "Assessment" + "Name" + generateRandomNumber();
		driver.findElement(By.id("assessmentName")).clear();
		waitThread(2000);
		click(ba.Assessmenttxtbx);
		// Type assessment name
		driver.findElement(By.id("assessmentName")).sendKeys(AssessmentNameTest.trim());
		waitThread(2000);
		// Click Save &Next button
		click(QP.Savenext);
		waitThread(1000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

	}

	/*
	 * To create a new assessment and publish the assessment-To Add questions
	 */
	@Test(priority = 30)
	public void TCSPR1000130() {

		TCSPR1000114();

	}

	/*
	 * To create a new assessment and publish the assessment-To verify peer
	 * review page
	 */
	@Test(priority = 31)
	public void TCSPR1000131() {

		waitThread(2000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentNameTest.trim()));
		// Assert course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseNameNew.trim()));

		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");

		// Assert the student names
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Student3name.trim());
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Student4name.trim());

	}

	/*
	 * To check the newly created assessment card visible on the teacher profile
	 */
	@Test(priority = 32)
	public void TCSPR1000132() {
		
		type(pr.PRreward_txtbox, "50");
		waitThread(3000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the peer schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");
		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.scheduleassessmentname).contains("Assessment Name: " + AssessmentNameTest.trim()));
		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");
		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.summaryassessmentname).contains("Assessment Name: " + AssessmentNameTest.trim()));

		click(sb.btnrelease);
		waitFor(QP.toaster);
		// Assert toaster "Assessment published successfully
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");

		click(QP.toasterclosebtn);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(natb.publishpopup), "Publish popup not visible");

	}

	public int totalcount;

	/*
	 * To check the course drop down functionality from the current assessment
	 * page
	 */
	@Test(priority = 33)
	public void TCSPR1000133() {

		click(natb.btnbacktomenu);
		Assert.assertFalse(isElementPresent(natb.publishpopup), "Publish popup  visible");

		waitThread(1000);
		Assert.assertTrue(isElementPresent(natb.selectedassessmenttab), "Assessment tab not selected");

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		// Search The Assessment Name
		type(natb.teacherassessmentsearchbox, AssessmentNameTest.trim());
		waitThread(1000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(2000);
		// Assert the Assessment name visible
		Assert.assertEquals(getText(natb.cardassessmentname1), AssessmentNameTest.trim());
		Assert.assertEquals(getText(natb.cardcoursename1),
				"For" + " " + CourseNameNew.trim() + " (" + NewCourseID + ")");
		waitThread(1000);

	}

	/*
	 * To perform search functionality on the current assessment page
	 */
	@Test(priority = 34)
	public void TCSPR1000134() {

		// To verify the number of assessment cards
		Assert.assertEquals(TotalElementsCount(natb.cardcount), 1);
		
		Assert.assertEquals(getAttribute(natb.assessmentsearchbx, "type"), "search");
		

		// To perform Invalid search
		type(natb.assessmentsearchbx, "jdfoiasfod   ");
		waitThread(3000);
		Assert.assertEquals(getText(natb.gridlabl), "No assessment available");

		// To perform search with valid details
		type(natb.assessmentsearchbx, AssessmentNameTest);
		// Assert the Assessment name,course name on the visible card
		Assert.assertEquals(getText(natb.cardassessmentname1), AssessmentNameTest.trim());
		Assert.assertEquals(getText(natb.cardcoursename1),
				"For" + " " + CourseNameNew.trim() + " (" + NewCourseID + ")");
		Assert.assertEquals(TotalElementsCount(natb.cardcount), 1);

		// To clear the course drop down
		// click on draft tab and verify draft tab is selected
		click(ba.tabdraft);
		Assert.assertEquals(getAttribute(ba.tabdraftselected, "aria-selected"), "true");

		// To verify Current Assessment tab is selected
		click(ba.tabcurrectassessment);
		Assert.assertEquals(getAttribute(ba.tabcurrectassessment, "aria-selected"), "true");
		Assert.assertEquals(TotalElementsCount(natb.cardcount), 2);

	}

	/*
	 * To check the view assessment functionality from course details page
	 */
	@Test(priority = 35)
	public void TCSPR1000135() {

		// click on course tab
		click(natb.Coursetab);
		Assert.assertTrue(isElementPresent(natb.selectedassessmenttab), "Course tab not selected");

		// To click on split button
		click(natb.btncoursedetails2);

		// click on View/Modify Course Details button
		click(natb.btndetailsview2);

		// Course Details-Heading
		Assert.assertEquals(getText(ec.heading_coursedetails), "Course Details");
		click(natb.btnAssessment);
		Assert.assertTrue(isElementPresent(natb.btnviewassessment), "View assessment button not visible");

	}

	/*
	 * To check the view assessment functionality from course details page
	 */

	@Test(priority = 36)
	public void TCSPR1000136() {

		// click on view assessment button
		click(natb.btnviewassessment);
		waitThread(3000);
		// To verify Current Assessment tab is selected
		Assert.assertEquals(getAttribute(ba.tabcurrectassessment, "aria-selected"), "true");
		Assert.assertEquals(getText(natb.selectedddvalue).trim(), CourseNameNew.trim());

		// Assert the Assessment name and course name
		Assert.assertEquals(getText(natb.cardassessmentname1), AssessmentNameTest.trim());
		Assert.assertEquals(getText(natb.cardcoursename1),
				"For" + " " + CourseNameNew.trim() + " (" + NewCourseID + ")");
		Assert.assertEquals(TotalElementsCount(natb.cardcount), 1);

	}

	/*
	 * To check the Create new assessment functionality from course details page
	 */
	@Test(priority = 37)
	public void TCSPR1000137() {

		// click on course tab
		click(natb.Coursetab);
		Assert.assertTrue(isElementPresent(natb.selectedassessmenttab), "Course tab not selected");

		// To click on split button
		click(natb.btncoursedetails2);

		// click on View/Modify Course Details button
		click(natb.btndetailsview2);

		// Course Details-Heading
		Assert.assertEquals(getText(ec.heading_coursedetails), "Course Details");
		// click on assessment button
		click(natb.btnAssessment);
		Assert.assertTrue(isElementPresent(natb.btnnewassessment), "Create new assessment button not visible");

		// click on create new assessment button
		click(natb.btnnewassessment);
		waitThread(3000);
		// To verify the wizard label is selected
		Assert.assertEquals(getAttribute(ba.Basicdetailswizard, "aria-selected"), "true");
	}

	public String AssessmentName1;

	/*
	 * To verify and fill the details on the basic details page
	 */
	@Test(priority = 38)
	public void TCSPR1000138() {

		Assert.assertEquals(getText(ba.courseddselect), CourseNameNew.trim());
		AssessmentName1 = "IT" + "Part 1" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentName1);

		waitThread(1000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(1000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(3000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), AssessmentName1.trim());

	}

	/*
	 * To create a new assessment and publish the assessment
	 */
	@Test(priority = 39)
	public void TCSPR1000139() {

		TCSPR1000114();

	}

	/*
	 * To create a new assessment and publish the assessment
	 */
	@Test(priority = 40)
	public void TCSPR1000140() {

		waitThread(2000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName1.trim()));
		// Assert course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseNameNew.trim()));
		
		type(pr.PRreward_txtbox, "50");
		waitThread(3000);
		
		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the peer schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedulewizard, "aria-selected"), "true");
		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.scheduleassessmentname).contains("Assessment Name: " + AssessmentName1.trim()));
		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");
		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.summaryassessmentname).contains("Assessment Name: " + AssessmentName1.trim()));

		// click on release button
		click(sb.btnrelease);
		waitFor(QP.toaster);
		// Assert toaster "Assessment published successfully
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");

		click(QP.toasterclosebtn);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(natb.publishpopup), "Publish popup not visible");

		// click on back to menu button
		click(natb.btnbacktomenu);
		Assert.assertFalse(isElementPresent(natb.publishpopup), "Publish popup  visible");

	}

	/*
	 * To check the newly created assessment card visible on the teacher profile
	 */
	@Test(priority = 41)
	public void TCSPR1000141() {

		waitThread(1000);
		Assert.assertTrue(isElementPresent(natb.selectedassessmenttab), "Assessment tab not selected");

		// Search The Assessment Name
		type(natb.teacherassessmentsearchbox, AssessmentName1.trim());
		waitThread(1000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(2000);

		// Assert the Assessment name visible
		Assert.assertEquals(getText(natb.cardassessmentname1), AssessmentName1.trim());
		Assert.assertEquals(getText(natb.cardcoursename1),
				"For" + " " + CourseNameNew.trim() + " (" + NewCourseID + ")");

	}
	/*
	 * To perform Delete Teacher Account functionality
	 */

	@Test(priority = 42)
	public void TCSPR1000142() {

		waitThread(2000);
		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);
	}

	/*
	 * To perform login functionality using deleted teacher profile credentials
	 */
	@Test(priority = 43)
	public void TCSPR1000143() {

		// login using deleted account credentials
		rs.login_Teacher(Emailteacher, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");
	}
	/*
	 * To perform Delete student1 Account functionality
	 */

	@Test(priority = 44)
	public void TCSPR1000144() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent1, password);

		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 1 profile
	 * credentials
	 */
	@Test(priority = 45)
	public void TCSPR1000145() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent1, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student2 Account functionality
	 */
	@Test(priority = 46)
	public void TCSPR1000146() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent2, password);

		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 2 profile
	 * credentials
	 */
	@Test(priority = 47)
	public void TCSPR1000147() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent2, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}
	/*
	 * To perform Delete student3 Account functionality
	 */

	@Test(priority = 48)
	public void TCSPR1000148() {
		// login using deleted account credentials
		rs.login_Student(Emailstudent3, password);

		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 3 profile
	 * credentials
	 */
	@Test(priority = 49)
	public void TCSPR1000149() {
		// login using deleted account credentials
		rs.login_Student(Emailstudent3, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student4 Account functionality
	 */
	@Test(priority = 50)
	public void TCSPR1000150() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent4, password);

		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 4 profile
	 * credentials
	 */
	@Test(priority = 51)
	public void TCSPR1000151() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent4, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

}
