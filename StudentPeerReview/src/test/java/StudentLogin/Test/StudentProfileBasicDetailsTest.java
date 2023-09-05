package StudentLogin.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Course.Pages.CourseRosterPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.StudentProfileBasicDetailsPage;

public class StudentProfileBasicDetailsTest extends basePage {
	StudentProfileBasicDetailsPage spdp = new StudentProfileBasicDetailsPage();
	CourseRosterPage cr = new CourseRosterPage();
	Databaseconnection dc = new Databaseconnection();
	SignUpTest st = new SignUpTest();
	SignUpPage sp = new SignUpPage();
	EncryptedText et = new EncryptedText();
	LoginPage lg = new LoginPage();
	public String otpnew;
	public String coursename;
	public String Emailstudent1;
	public String Url;
	public String teachname;
	public String CourseID;
	public String Teacher_firstname;
	public String Teacher_lastname;
	public String Teacher_fullname;
	public String Password;
	public String Stud_firstname;
	public String Stud_lastname;
	public String EmailTeacher;
	public String studentinviteid;

	/*
	 * Perform sign up functionality read the Teacher name and password
	 */
	@Test(priority = 0)
	public void TCSPR080101() throws SQLException {

		Teacher_firstname = "Test";
		Teacher_lastname = "Teacher";
		Teacher_fullname = Teacher_firstname + " " + Teacher_lastname;
		Password = "Abc@123";

		// Click on I'm a Teacher button
		click(sp.btn_1);
		EmailTeacher = st.TCSPR020005();

	}

	/*
	 * To fetch OTP
	 */
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
	public void TCSPR080102() throws SQLException {

		// Click create new course Button
		click(spdp.create_newcourse_btn3);

		// To get course id
		CourseID = getText(spdp.courseid1);

		// Assert the course code
		Assert.assertTrue(isElementPresent(spdp.courseid1), "CourseID: is not present");

		// click on course title text box
		click(spdp.coursetitle_txt);

		coursename = "GK" + generateRandomNumber().trim() + "part1";

		// type course name
		type(spdp.coursetitle_txt, coursename);

		// click Add Students button
		click(spdp.Add_students_btn4);
		click(spdp.emailtype_txt);

		// type email
		Emailstudent1 = "studenttest" + generateRandomNumber().trim() + "@gmail.com";

		type(spdp.emailtype_txt, Emailstudent1);
		driver.findElement(By.xpath(spdp.emailtype_txt)).sendKeys(Keys.SPACE);

		cm.invitestudent();

		// click Create&Invite button
		click(spdp.Create_invite_btn6);

		// Assert the Course title in grid
		Assert.assertEquals(getText(spdp.course_tit_grid), coursename);

	}

	/*
	 * To check the Invitited student details on the course roaster page
	 */
	@Test(priority = 3)
	public void TCSPR080103() {
		waitThread(4000);
		// click "Details Dropdown"
		click(spdp.Details_drop);

		waitFor(spdp.Veiwmodify_btn);

		// Assert "View/Modify Student Roster" link
		Assert.assertEquals(getText(spdp.Veiwmodify_btn), "View/Modify Student Roster");

		// click "View/Modify Student Roster button"
		click(spdp.Veiwmodify_btn);

		// Click on "Invited &Not Accepted radio button"
		click(spdp.Invited_drop);

		// Assert "Assert the Invited &Not Accepted radio button is checked"
		Assert.assertTrue(isElementPresent(spdp.Invited_drop), "Invited &Not  Accepted radio button is checked");

		// Assert heading Course Roaster
		Assert.assertEquals(getText(spdp.course_roast), "Student Roster");

		// Assert Coursename on the grid
		Assert.assertEquals(getText(spdp.coursenam_grid), coursename);

		// Assert the Student ID is not visible on the grid
		Assert.assertEquals(getText(spdp.Studentid_empty), "");

		// Assert the First Name is not visible on grid
		Assert.assertEquals(getText(spdp.Firstname_empty), "");

		// Assert the Last Name is not visible on grid
		Assert.assertEquals(getText(spdp.Lastname_empty), "");

		// Assert invitation status NO Account
		Assert.assertEquals(getText(spdp.NoAccount), "NO ACCOUNT");

		// Assert email is visible on the grid
		Assert.assertEquals(getText(spdp.email_incourseroaster_grid), Emailstudent1);

		// Assert the invitation send date with system date
		Assert.assertEquals(getText(spdp.date_grid_courseroster), spdp.getdate());

	}

	/*
	 * To perform Logout in teacher profile
	 */
	@Test(priority = 4)
	public void TCSPR080104() {

		// Perform logout
		spdp.Logout();
		// Assert heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");

	}

	/*
	 * To load the invitation link that send by the teacher
	 */
	@Test(priority = 5)
	public void TCSPR080105() throws SQLException {

		// To perform Signup functionality of student
		studentinviteid = dc.InviteLink(Emailstudent1, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		// driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Assert heading Signup
		Assert.assertEquals(getText(spdp.hd_label2), "Sign Up");

	}

	/*
	 * To check the labels in the Student Sign up page
	 */
	@Test(priority = 6)
	public void TCSPR080106() {

		// Assert the heading as Individual Student
		Assert.assertEquals(getText(spdp.indiv_stu_label), "as Individual Student");

		// Assert the text 'I Agree to the Terms & Conditions and Privacy
		// Policy'
		Assert.assertEquals(getText(spdp.txtlabel), "I Agree to the Terms & Conditions and Privacy Policy");

		// Assert the terms and conditions checkbox
		Assert.assertTrue(isElementPresent(spdp.sign_check), "checkbox is not present");

		// Assert First Name, Last Name,Password,Confirm Password placeholders
		Assert.assertEquals(getAttribute(spdp.Firstname_placeh, "placeholder"), "First Name");
		Assert.assertEquals(getAttribute(spdp.Lastname_placeh, "placeholder"), "Last Name");
		Assert.assertEquals(getAttribute(spdp.Password_placeh, "placeholder"), "Password");
		Assert.assertEquals(getAttribute(spdp.confirm_placeh, "placeholder"), "Confirm Password");

		// Assert the email is in disabled state
		Assert.assertFalse(isEnabled(spdp.emailtxt3), "Email textbox is enabled");

		// Assert First Name, Last Name,Password,Confirm Password textboxes
		Assert.assertTrue(isElementPresent(spdp.Firstname_textb1), "First Name textbox is not present");
		Assert.assertTrue(isElementPresent(spdp.Lastname_txtb2), "Last Name textbox is not present");
		Assert.assertTrue(isElementPresent(spdp.Password_txtb4), "Password textbox is not present");
		Assert.assertTrue(isElementPresent(spdp.confirm_txtb5), "Confirm Password textbox  is not present");

		// Assert SignUp button
		Assert.assertTrue(isElementPresent(spdp.signUp_btn), "SignUp button not present");

		// Assert Already have an account link
		Assert.assertEquals(getText(spdp.Alrdy_accnt_link), "Already have an account?");
	}

	/*
	 * To check the required field validation messages
	 */
	@Test(priority = 7)
	public void TCSPR080107() {

		// Click on SignUp button
		click(spdp.signUp_btn);

		// Validation Messages in Student Signup Page
		Assert.assertEquals(getText(spdp.Valmsg_frstname), "First Name is required");
		Assert.assertEquals(getText(spdp.Valmsg_lstname), "Last Name is required");
		Assert.assertEquals(getText(spdp.Valmsg_pass), "Password is required");
		Assert.assertEquals(getText(spdp.Valmsg_confirmpas), "Confirm Password is required");

	}

	/*
	 * To check the student Sign Up functionality To fill all the parameters and
	 * Assert the headings
	 */
	@Test(priority = 8)
	public void TCSPR080108() throws SQLException {

		Stud_firstname = "Test";
		Stud_lastname = "Student";

		// click FirstName Textbox
		click(spdp.Firstname_textb1);

		// type firstname
		type(spdp.Firstname_textb1, Stud_firstname);

		// click LastName Textbox
		click(spdp.Lastname_txtb2);

		// type LastName as
		type(spdp.Lastname_txtb2, Stud_lastname);

		// Click Password Textbox
		click(spdp.Password_txtb4);

		// type password
		type(spdp.Password_txtb4, Password);

		// Click Confirm Password Textbox
		click(spdp.confirm_txtb5);

		// type Confirm password
		type(spdp.confirm_txtb5, Password);

		// click SignUp button
		click(spdp.signUp_btn);

		waitFor(spdp.tost_1);
		// Assert the Toaster Message Visible
		Assert.assertTrue(isElementPresent(spdp.tost_1), "Toaster message is not visible");

		// Assert Toaster Message "Please Agree to the Terms & Conditions and
		// Privacy
		// Policy before Sign Up"
		// Please Agree to the Terms & Conditions and Privacy Policy before Sign
		// Up
		Assert.assertEquals(getText(spdp.tost_1),
				"Please agree to the Terms & Conditions and the Privacy Policy before signing up");

		// click on privacy policy checkbox
		click(spdp.sign_check);

		// Assert the checkbox is checked
		Assert.assertTrue(isElementPresent(spdp.sign_sel_check),
				"Terms& Conditions and privacy policy checkbox not selected");

		// click on SignUp button
		click(spdp.signUp_btn);

		waitThread(5000);

		waitFor(spdp.newjoine_labl);
		// Assert the heading "Join New Course"
		Assert.assertEquals(getText(spdp.newjoine_labl), "Join New Course");

	}

	/*
	 * To check the course details on the student profile
	 */
	@Test(priority = 9)
	public void TCSPR080109() {

		// Assert the teacher Request visible on the page
		Assert.assertTrue(isElementPresent(spdp.req_receiv_box), "Request received not visible");

		// Assert the label "You have not enrolled in any course(s)."
		Assert.assertEquals(getText(spdp.you_have_notenrolled), "You have not enrolled in any course(s).");

		// Assert Request Received
		Assert.assertEquals(getText(spdp.Req_receiv_label), "Teacher Invitations\n" + "to join a course");

		// Assert Request Sent
		Assert.assertEquals(getText(spdp.Req_sent_label), "Requests I sent to\n" + "join a course");

		// Assert course name visible
		Assert.assertEquals(getText(spdp.coursename_studentpage), coursename);

		// view tool tip
		MouseHover(spdp.Req_receiv_label);
		Assert.assertEquals(getAttribute(spdp.tooltip1, "ptooltip"),
				"Requests I have received from Teachers to join their course");
		MouseHover(spdp.Req_sent_label);
		Assert.assertEquals(getAttribute(spdp.tooltip2, "ptooltip"),
				"Requests I have sent to Teachers to join their course");
	}

	/*
	 * To check the course details on the student profile
	 * 
	 */
	@Test(priority = 10)
	public void TCSPR080110() {

		// Assert the text label :Course ID
		Assert.assertEquals(getText(spdp.courseIdtext), "Course ID:");

		// Assert the course ID same as on the course add page
		Assert.assertEquals(getText(spdp.courseId), "Course ID: " + CourseID);

		// Assert Request Received Text
		Assert.assertTrue(isElementPresent(spdp.Req_rec_text), "Request Received Text is not present");

		// Assert the invitation received date with system date
		Assert.assertEquals(getText(spdp.date_grid), "Request Received: " + spdp.getdate());

		// Assert Course Created By text
		Assert.assertTrue(isElementPresent(spdp.Course_created_text), "Course Created by is not present");

		// Assert teacher Name
		Assert.assertTrue(isElementPresent(spdp.Teach_name), "Teacher name is not present");

		Assert.assertEquals(getText(spdp.Teacher_name), Teacher_fullname);

		// Assert Request Received count is 1
		Assert.assertEquals(getText(spdp.Req_receiv_count1), "1");

	}

	/*
	 * To perform Join new course tab close button functionality
	 */
	@Test(priority = 11)
	public void TCSPR080111() {

		// Assert close button is visible on page
		Assert.assertTrue(isElementPresent(spdp.close_btn), "Close button is not present");

		// click close button
		click(spdp.close_btn);
		waitThread(2000);

		// Assert Join New Course box not visible
		Assert.assertFalse(isDisplayed(spdp.Join_newbox), "Join New course box is present");

		// Assert New Join Course Button is visible
		Assert.assertTrue(isElementPresent(spdp.Join_newCourse_btn), "Join New Course Label is not present");

		// click on Join New Course button
		click(spdp.Join_newCourse_btn);

		// Assert Join New course box is visible
		Assert.assertTrue(isElementPresent(spdp.Join_newbox), "Join New course box is not present");

	}

	/*
	 * To perform logout functionality on the student profile
	 */
	@Test(priority = 12)
	public void TCSPR080112() {

		// perform Logout functionality
		spdp.Logout();

		// Assert Heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");

	}

	/*
	 * To check the Revoke Invitation functionality on the course roster page
	 */
	@Test(priority = 13)
	public void TCSPR080113() {

		// Login as Teacher
		spdp.login_Teacher(EmailTeacher, Password);

		// Assert the heading label "Courses"
		Assert.assertEquals(getText(spdp.hd_label3), "Courses");

		// click "Details Dropdown"
		click(spdp.Details_drop);
		waitFor(spdp.Veiwmodify_btn);

		// Assert "View/Modify Student Roster" link
		Assert.assertTrue(isElementPresent(spdp.Veiwmodify_btn), "View Modify Student Roster not prresent");

		// click "View/Modify Student Roster button"
		click(spdp.Veiwmodify_btn);

		// Assert heading Course Roaster
		Assert.assertEquals(getText(spdp.course_roast), "Student Roster");

		// Click on "Invited &Not Accepted radio button"
		click(spdp.Invited_drop);

		// Assert email is visible on the grid
		Assert.assertEquals(getText(spdp.email_incourseroaster_grid), Emailstudent1);

		// Assert Invitation Status:Not Accepted
		Assert.assertEquals(getText(spdp.Notaccept), "NOT ACCEPTED");

		waitFor(spdp.grid_checkbx);
		// click checkbox
		click(spdp.grid_checkbx);

		// Assert the check box is checked
		Assert.assertTrue(getAttribute(spdp.cour_grid_check, "class").contains("p-highlight"));

		// click on Actions drop down
		click(spdp.Actions);

		waitFor(spdp.Revokinvi);

		// Assert link "Revoke Invitations"
		Assert.assertEquals(getText(spdp.Revokinvi), "Revoke Invitations");

		// click Revoke Invitations
		JavaScriptclick(spdp.Revokinvi);
		waitThread(2000);
		// Confirm Yes
		JavaScriptclick(spdp.Yesbtn);
		waitFor(spdp.tost_1);
		// Assert toaster message: "Revoked Successfully"
		Assert.assertEquals(getText(spdp.tost_1), "Successfully revoked");

		waitThread(2000);
		// Assert Email:Random Generated Email not visible on the grid
		Assert.assertFalse(isElementPresent(spdp.email_incourseroaster_grid), "email is visible on grid");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 14)
	public void TCSPR080114() {

		spdp.Logout();

		// Assert heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");

	}

	/*
	 * To check that the Revoke invitation not visible on the student profile
	 */
	@Test(priority = 15)
	public void TCSPR080115() {

		// Login as student
		spdp.login_Student(Emailstudent1, Password);
		Assert.assertTrue(isElementPresent(spdp.selectedmycoursetab), "My course Tab is not selected");
		// click on join new course button
		click(spdp.Join_newCourse_btn);
		waitFor(spdp.newjoine_labl);

		// Assert the heading "Join New Course"
		Assert.assertEquals(getText(spdp.newjoine_labl), "Join New Course");

		waitFor(spdp.Join_newbox);
		// Assert Join New course box is visible
		Assert.assertTrue(isElementPresent(spdp.Join_newbox), "Join New course box is not present");

	}

	/*
	 * To perform Delete Student Account functionality
	 */
	@Test(priority = 16)
	public void TCSPR080116() {

		// Account delete functionality

		cr.DeleteAccount();

	}

	/*
	 * To perform login functionality using deleted student profile credentials
	 */
	@Test(priority = 17)
	public void TCSPR080117() {

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
	@Test(priority = 18)
	public void TCSPR080118() {

		// Login using teacher credentials
		lg.login1(EmailTeacher, Password);

		// Assert the heading label "Courses"
		Assert.assertEquals(getText(spdp.hd_label3), "Courses");

		// Perform Delete Account functionality
		cr.DeleteAccount();
	}

	/*
	 * To perform login functionality using deleted Teacher profile credentials
	 */
	@Test(priority = 19)
	public void TCSPR080119() {

		// Login using teacher credentials
		lg.login(EmailTeacher, Password);
		waitFor(spdp.tost_1);

		// "Assert toaster message "Enter a valid email address and password"
		Assert.assertEquals(getText(spdp.tost_1), "Enter a valid email address and password");

	}

}
