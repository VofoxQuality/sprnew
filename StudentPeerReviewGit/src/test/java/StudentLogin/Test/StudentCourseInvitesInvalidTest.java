package StudentLogin.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpCommonTest;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import StudentLogin.Pages.StudentCourseInvitesInvalidPage;
import StudentLogin.Pages.StudentProfileBasicDetailsPage;

public class StudentCourseInvitesInvalidTest extends basePage {

	StudentCourseInvitesInvalidPage sc = new StudentCourseInvitesInvalidPage();
	Databaseconnection dc = new Databaseconnection();
	SignUpTest st = new SignUpTest();
	SignUpPage sp = new SignUpPage();
	EncryptedText et = new EncryptedText();
	LoginPage lg = new LoginPage();
	StudentProfileBasicDetailsPage spdp = new StudentProfileBasicDetailsPage();
	StudentProfileBasicDetailsTest spt = new StudentProfileBasicDetailsTest();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();

	public String Teacher_firstname;
	public String Teacher_lastname;
	public String Teacher_fullname;
	public String Password = "Abc@123";
	public String Stud_firstname;
	public String Stud_lastname;
	public String EmailTeacher;
	public String otp;
	public String CourseID;
	public String coursename;
	public String Emailstudent1;
	public String studentinviteid;

	/*
	 * To load the Student Peer Review Landing Page. -Perform sign up
	 * functionality read the Teacher name and password
	 */
	@Test(priority = 0)
	public void TCSPR080601() throws SQLException {

		// Perform sign up functionality read the Teacher name and password
		Teacher_firstname = "Test";
		Teacher_lastname = "Teacher";
		Teacher_fullname = Teacher_firstname + " " + Teacher_lastname;

		// Assert the heading label "Welcome to Student Peer Review"
		Assert.assertEquals(getText(sc.wel_label), "Welcome to Student Peer Review");

		// Click on I'm a Teacher button
		click(sc.teach_btn);
		EmailTeacher = st.TCSPR020005();

	}

	@Test(priority = 1)
	public void OtpFetch() throws SQLException {

		// To catch OTP from sending Resource
		st.TCSPR020006();

	}

	CommonMethods cm = new CommonMethods();

	/*
	 * To perform the create new course functionality on the landing page. -Read
	 * the course name and course code
	 */
	@Test(priority = 2)
	public void TCSPR080602() {

		// Click on the Create New Course Button
		click(sc.creatnw_coursebtn);

		waitThread(3000);
		// Assert the course code present(Read the course code)
		CourseID = getText(sc.course_code);
		Assert.assertTrue(isElementPresent(sc.course_code), "Coursecode not present");

		// click on course title text box
		click(sc.coursetitle_txt);

		coursename = "GK" + generateRandomNumber().trim() + "part1";

		// type course name
		type(sc.coursetitle_txt, coursename);

		// Assert the course name on the text box
		Assert.assertEquals(getValue(sc.coursetitle_txt), coursename);

		// click Add Students button
		click(sc.Add_studbtn);
		click(sc.emailtype_txt);

		// type email
		Emailstudent1 = "studenttest" + generateRandomNumber().trim() + "@gmail.com";

		type(sc.emailtype_txt, Emailstudent1);
		driver.findElement(By.xpath(sc.emailtype_txt)).sendKeys(Keys.SPACE);

		// Assert email present on textbox
		Assert.assertTrue(isElementPresent(sc.emailtype_txt), "Email not present");

		cm.invitestudent();

		waitThread(1000);
		ScrollTo_Location(sc.createinvite_btn);
		waitThread(1000);

		// click Create&Invite button
		click(sc.createinvite_btn);

		// Assert the Course title in grid
		Assert.assertEquals(getText(sc.course_tit_grid), coursename);

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 3)
	public void TCSPR080603() {

		waitThread(2000);
		// To perform logout functionality on the teacher profile
		spdp.Logout();

		// Assert heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");

	}

	/*
	 * To perform student sign up functionality
	 */
	@Test(priority = 4)
	public void TCSPR080604() throws SQLException {

		// To perform student sign up functionality
		studentinviteid = dc.InviteLink(Emailstudent1, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		// driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Assert heading Signup
		Assert.assertEquals(getText(spdp.hd_label2), "Sign Up");

		Stud_firstname = "Test";
		Stud_lastname = "Student";

		waitFor(sc.Firstname_textb1);
		// click FirstName Textbox
		click(sc.Firstname_textb1);
		// type firstname
		type(sc.Firstname_textb1, Stud_firstname);

		// click LastName Textbox
		click(sc.Lastname_txtb2);
		// type LastName as
		type(sc.Lastname_txtb2, Stud_lastname);

		// Click Password Textbox
		click(sc.Password_txtb4);
		// type password
		type(sc.Password_txtb4, Password);

		// Click Confirm Password Textbox
		click(sc.confirm_txtb5);

		// type Confirm password
		type(sc.confirm_txtb5, Password);

		// click on privacy policy checkbox
		click(sc.sign_check);

		// click SignUp button
		click(sc.signUp_btn);

		// Assert Text You have not Enrolled in Any Course(s).
		Assert.assertEquals(getText(sc.notenrol_text), "You have not enrolled in any course(s).");

	}

	/*
	 * To check the course visible on the suspended students profile
	 */
	@Test(priority = 5)
	public void TCSPR080605() {

		waitFor(sc.coursename_studentpage);

		// Assert coursename visible
		Assert.assertEquals(getText(sc.coursename_studentpage), coursename);

		// Assert button:Accept
		Assert.assertEquals(getText(sc.accept_btn), "Accept");

	}

	/*
	 * To check the Accept course functionality on the student login
	 */
	@Test(priority = 6)
	public void TCSPR080606() {

		// Click Accept button
		click(sc.accept_btn);
		waitThread(2000);

		// Assert the popup window visible
		Assert.assertTrue(isElementPresent(sc.Confir_label), "Confiramtion popup not visible");

		// click Yes Button
		click(sc.Yes_btn);
		waitFor(sc.tost_1);

		// Assert Toaster Popup visible
		Assert.assertTrue(isElementPresent(sc.tost_1), "Toaster popup not visible");

		// Assert Toaster Message "Course accepted successfully"
		Assert.assertEquals(getText(sc.tost_1), "Course accepted successfully");

		// Assert the popup window not visible
		Assert.assertFalse(isElementPresent(sc.Confir_label), "Confiramtion popup visible");

	}

	/*
	 * To perform send request functionality with invalid course course code
	 */
	@Test(priority = 7)
	public void TCSPR080607() {

		// click Course ID on course id text box
		click(sc.coursid_txtbx);

		// Type Course ID "111"
		type(sc.coursid_txtbx, "111");

		// click Send Request button
		click(sc.sendreq_btn);
		waitFor(sc.tost_1);

		// Assert Toaster Pop up visible
		Assert.assertTrue(isElementPresent(sc.tost_1), "Toaster popup not visible");

		// Assert Toaster Message "Course does not exist."
		Assert.assertEquals(getText(sc.tost_1), "Course does not exist.");

	}

	/*
	 * To perform logout functionality on the student profile
	 */
	@Test(priority = 8)
	public void TCSPR080608() {

		waitThread(2000);
		// To perform logout functionality
		spdp.Logout();

		// Assert heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");

	}

	/*
	 * To perform delete course functionality on the teacher profile
	 */
	@Test(priority = 9)
	public void TCSPR080609() {

		// To perform delete course functionality on the teacher profile Login
		// as teacher
		rs.login_Teacher(EmailTeacher, Password);

		// click "Details Drop down"
		click(sc.Details_drop);
		waitFor(sc.del_courselink);

		// Assert link Delete course
		Assert.assertEquals(getText(sc.del_courselink), "Delete Course");

		// Click on Delete course link
		click(sc.del_courselink);

		// Assert the confirmation popup visible
		Assert.assertTrue(isElementPresent(sc.confirmlabel2), "confirmation popup not visible");

		// click Yes button
		click(sc.Yes_btn);

		// Assert the Course Name+Random Number course not visible on the course
		// landing page
		Assert.assertFalse(isElementPresent(coursename), "Course Name is visible");
	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 10)
	public void TCSPR080610() {

		// To perform logout functionality on the teacher profile
		spdp.Logout();

		// Assert heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");

	}

	/*
	 * To check the deleted course(Already enrolled) visible on student profile.
	 * Perform send request functionality with deleted course ID
	 */
	@Test(priority = 11)
	public void TCSPR080611() {

		// Login as student
		rs.login_Student(Emailstudent1, Password);

		// Assert the Course Name+Random Number not visible on the Enrolled page
		Assert.assertFalse(isElementPresent(coursename), "Course Name is visible");
		// click on My Course tab
		click(spdp.MyCourseTab);
		// click Join new Course button
		click(sc.joinnw_btn);

		// click Course ID on course id text box
		click(sc.coursid_txtbx);

		// Type Course ID for the course
		type(sc.coursid_txtbx, CourseID);

		// click Send Request button
		click(sc.sendreq_btn);

		// Assert Toaster Pop up visible
		Assert.assertTrue(isElementPresent(sc.tost_1), "Toaster popup not visible");

		waitFor(sc.tost_1);

		// Assert Toaster Message "Course does not exist."
		Assert.assertEquals(getText(sc.tost_1), "Course does not exist.");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 12)
	public void TCSPR080612() {

		waitThread(2000);
		// To perform logout functionality
		spdp.Logout();

		// Assert heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");

		// Login as teacher
		rs.login_Teacher(EmailTeacher, Password);

		// Assert the heading label "Courses"
		Assert.assertEquals(getText(sc.courses_label), "Courses");

	}

	/*
	 * To perform the create new course functionality on the landing page. -Read
	 * the course name and course code
	 */
	@Test(priority = 13)
	public void TCSPR080613() {

		// Click on the Create New Course Button
		click(sc.creatnw_coursebtn);

		// Assert the course code present(Read the course code)
		CourseID = getText(sc.course_code);
		Assert.assertTrue(isElementPresent(sc.course_code), "Coursecode not present");

	}

	/*
	 * To perform the create new course functionality on the landing page. -Read
	 * the course name and course code
	 */
	@Test(priority = 14)
	public void TCSPRO80614() {

		// click on course title text box
		click(sc.coursetitle_txt);

		coursename = "GK" + generateRandomNumber().trim() + "part1";

		// type course name
		type(sc.coursetitle_txt, coursename);

		// Assert the course name on the text box
		Assert.assertEquals(getValue(sc.coursetitle_txt), coursename);

		// click Add Students button
		click(sc.Add_studbtn);
		click(sc.emailtype_txt);

		// type email
		type(sc.emailtype_txt, Emailstudent1);
		driver.findElement(By.xpath(sc.emailtype_txt)).sendKeys(Keys.SPACE);

		// Assert email present on text box
		Assert.assertTrue(isElementPresent(sc.emailtype_txt), "Email not present");
		cm.invitestudent();
		waitThread(1000);
		ScrollTo_Location(sc.createinvite_btn);
		waitThread(1000);

		// click Create&Invite button
		click(sc.createinvite_btn);

		waitThread(2000);
		// Assert the Course title in grid
		Assert.assertEquals(getText(sc.course_tit_grid), coursename);

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 15)
	public void TCSPR080615() {

		waitThread(2000);
		// To perform logout functionality on the teacher profile
		spdp.Logout();

		// Assert heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");

	}

	/*
	 * To check the course visible on the suspended students profile
	 */
	@Test(priority = 16)
	public void TCSPR080616() {

		// Login as student
		rs.login_Student(Emailstudent1, Password);

		waitThread(3000);
		// click on My Course tab
		click(spdp.MyCourseTab);

		// Assert coursename visible
		Assert.assertTrue(isElementPresent(sc.coursename_studentpage), "Course name is not visible");

		// Assert button:Accept
		Assert.assertEquals(getText(sc.accept_btn), "Accept");

	}

	/*
	 * To check the Accept course functionality on the student login
	 */
	@Test(priority = 17)
	public void TCSPR080617() {

		// Click Accept button
		click(sc.accept_btn);

		// Assert the popup window visible
		Assert.assertTrue(isElementPresent(sc.Confir_label), "Confiramtion popup not visible");

		// click Yes Button
		click(sc.Yes_btn);
		waitFor(sc.tost_1);

		// Assert Toaster Popup visible
		Assert.assertTrue(isElementPresent(sc.tost_1), "Toaster popup not visible");

		// Assert Toaster Message "Course accepted successfully"
		Assert.assertEquals(getText(sc.tost_1), "Course accepted successfully");

		// Assert the popup window not visible
		Assert.assertFalse(isElementPresent(sc.Confir_label), "Confiramtion popup visible");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 18)
	public void TCSPR080618() {

		// To perform logout functionality
		spdp.Logout();

		// Assert heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");

	}

	/*
	 * To check the view/Edit course functionality on the grid
	 */
	@Test(priority = 19)
	public void TCSPR080619() {

		// To perform delete course functionality on the teacher profile Login
		// as teacher
		rs.login_Teacher(EmailTeacher, Password);

		// click "Details button"
		click(sc.details_btn);

		// click on View/Modify Course Details button
		click(sc.btn_coursedetails);
		waitThread(1000);

		// Assert tab Heading "Course Details"
		Assert.assertEquals(getText(sc.Coursedetls_tb), "Course Details");
	}

	/*
	 * To check the Active/Inactive functionality on the course details page
	 */
	@Test(enabled = false)
	public void TCSPR080620() {

		// Click on Active button
		Doubleclick(sc.active_btn);

		// Assert the confirmation pop up visible
		Assert.assertTrue(isElementPresent(sc.confirm_lb3), "Confirmation popup not visible");

		// click Yes button
		click(sc.Yes_btn);

		waitFor(sc.tost_1);
		// Assert Toaster Popup visible
		Assert.assertTrue(isElementPresent(sc.tost_1), "Toaster popup not visible");

		// Assert Toaster Message "Course does not exist."
		Assert.assertEquals(getText(sc.tost_1), "The course " + coursename.trim() + " has been successfully activated");

		// To verify the Course is inactive click "Back to course listing" arrow
		click(sc.back_tn);

		// Assert the inactive course not visible in the active course grid
		Assert.assertFalse(isElementPresent(coursename), "Course is not present");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 21)
	public void TCSPR080621() {

		waitThread(2000);
		// To perform logout functionality
		spdp.Logout();

		// Assert heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");

	}

	/*
	 * To check the inactive course (Already enrolled) visible on student
	 * profile. Perform send request functionality with deleted course ID
	 */
	@Test(priority = 22)
	public void TCSPR080622() {

		// Login as Student
		rs.login_Student(Emailstudent1, Password);
		// click on My Course tab
		click(spdp.MyCourseTab);
		// Assert the Course Name+Random Number not visible on the Enrolled page
		Assert.assertFalse(isElementPresent(coursename), "Course Name is visible");

		// click Join new Course button
		click(sc.joinnw_btn);

		// click Course ID on course id textbox
		click(sc.coursid_txtbx);

		// Type Course ID for the course
		type(sc.coursid_txtbx, CourseID);

		waitThread(1000);
		// click Send Request button
		click(sc.sendreq_btn);

		waitFor(sc.tost_1);
		// Assert Toaster Popup visible
		Assert.assertTrue(isElementPresent(sc.tost_1), "Toaster popup not visible");
		waitFor(sc.tost_1);
		// Assert Toaster Message "Course does not exist."
		Assert.assertEquals(getText(sc.tost_1), "Course does not exist.");
		click(sc.toasterclosebtn);

	}

	/*
	 * Delete student account
	 */
	@Test(priority = 23)
	public void TCSPR080623() {

		// To perform Delete Student Account functionality
		sc.DeleteAccount();

		waitThread(3000);

	}

	/*
	 * To perform login functionality using deleted student profile credentials
	 */
	@Test(priority = 24)
	public void TCSPR080624() {

		// Perform Login(student)
		lg.login(Emailstudent1, Password);

		waitFor(spdp.tost_1);
		// "Assert toaster message "Enter a valid email address and password"
		Assert.assertEquals(getText(spdp.tost_1), "Enter a valid email address and password");

	}

	/*
	 * Perform Login using Teacher credentials and perform delete account
	 * functionality
	 */
	@Test(priority = 25)
	public void TCSPR080625() {

		// Login using teacher credentials
		lg.login1(EmailTeacher, Password);

		// Assert the heading label "Courses"
		Assert.assertEquals(getText(spdp.hd_label3), "Courses");

		// Perform Delete Account functionality
		sc.DeleteAccount();
	}

	/*
	 * To perform login functionality using deleted Teacher profile credentials
	 */
	@Test(priority = 26)
	public void TCSPR080626() {

		// Login using teacher credentials
		lg.login(EmailTeacher, Password);
		waitFor(spdp.tost_1);

		// "Assert toaster message "Enter a valid email address and password"
		Assert.assertEquals(getText(spdp.tost_1), "Enter a valid email address and password");
	}
}