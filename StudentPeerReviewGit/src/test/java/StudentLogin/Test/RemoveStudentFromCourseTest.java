package StudentLogin.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import StudentLogin.Pages.StudentProfileBasicDetailsPage;

public class RemoveStudentFromCourseTest extends basePage {

	StudentProfileBasicDetailsPage spdp = new StudentProfileBasicDetailsPage();
	SignUpPage sp = new SignUpPage();
	LoginPage lg = new LoginPage();
	SignUpTest st = new SignUpTest();
	Databaseconnection dc = new Databaseconnection();
	CourseRosterPage cr = new CourseRosterPage();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	EncryptedText et = new EncryptedText();
	public String Emailteacher;
	public String teacherotp;
	public String studentotp;
	public String CourseName;
	public String CourseID;
	public String Emailstudent1;
	public String Studentfirstname;
	public String Studentlastname;
	public String Studentname;
	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	/*
	 * To perform Sign Up functionality
	 */
	@Test(priority = 0)
	public void TCSPR090101() throws SQLException {

		// To click on I am A teacher button
		click(sp.btn_1);

		// To fill the details on the sign up page
		Emailteacher = st.TCSPR020005();
		System.out.println(Emailteacher);
	}

	/*
	 * To fetch OTP
	 */
	@Test(priority = 1)
	public void OtpFetch() throws SQLException {

		// To catch OTP from sending Resource
		st.TCSPR020006();

	}
	CommonMethods cm=new CommonMethods();
	/*
	 * To create new course
	 */
	@Test(priority = 2)
	public void TCSPR080302() throws SQLException {

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
		

		// type invalid email
		type(cn.tab_textbox, Emailstudent1 + ",");

		waitThread(1000);
		// click on add to list button
		click(cn.tab_btn_Addtolist);
		waitThread(4000);
		click(cn.confirmyesbtn);
		waitThread(4000);
		click("//p-tabview/div/ul/li[3]/a/span[2]");
		waitThread(2000);
		click("//button[@id='sendRequestId']");


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
	 * To check the Invitited student details on the Student Roster page
	 */
	@Test(priority = 3)
	public void TCSPR080303() {

		// click on details button dropdown
		click(cn.btn_details_1);

		waitFor(spdp.Veiwmodify_btn);

		// Assert "View/Modify Student Roster" link
		Assert.assertEquals(getText(spdp.Veiwmodify_btn), "View/Modify Student Roster");

		// click "View/Modify Student Roster button"
		click(spdp.Veiwmodify_btn);
		// verify the heading
		Assert.assertEquals(getText(cr.heading_courseroster), "Student Roster");
		waitThread(1000);
		waitFor(cr.radiobtn_invited);
		click(cr.radiobtn_invited);

		// verify the radio button is selected
		Assert.assertTrue(isSelected(cr.check_radiobtn_invites),
				"The Invited & Not Accepted radio button is not checked");

		// verify the course name on the grid
		Assert.assertEquals(getText(cr.course_name).trim(), CourseName.trim());

		// To verify the Email on the grid
		Assert.assertEquals(getText(cr.gridvalue_email), Emailstudent1);
	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 4)
	public void TCSPR080304() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * To perform Sign Up functionality of student
	 */
	@Test(priority = 5)
	public void TCSPR080305() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent1, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname = "Ashley";
		Studentlastname = "Albert";
		Studentname = Studentfirstname + " " + Studentlastname;

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
	@Test(priority = 6)
	public void TCSPR080306() {

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
	 * To perform remove student functionality on the Student Roster page
	 */
	@Test(priority = 7)
	public void TCSPR080307() {

		rs.login_Teacher(Emailteacher, password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitlenew), "Courses");

		// click on details button dropdown
		click(cn.btn_details_1);

		waitFor(spdp.Veiwmodify_btn);

		// Assert "View/Modify Student Roster" link
		Assert.assertEquals(getText(spdp.Veiwmodify_btn), "View/Modify Student Roster");

		// click "View/Modify Student Roster button"
		click(spdp.Veiwmodify_btn);

		// verify the heading
		Assert.assertEquals(getText(cr.heading_courseroster), "Student Roster");

		waitThread(1000);
		// verify the course name on the grid
		Assert.assertEquals(getText(cr.course_name).trim(), CourseName.trim());

		// verify the radio button is selected
		Assert.assertTrue(isSelected(cr.check_radiobtn_enrolled), "Enrolled radio button is not checked");

		waitFor(cr.gridvalue_email);
		// To verify the Student Email on the grid
		Assert.assertEquals(getText(cr.gridvalue_email), Emailstudent1);

	}

	/*
	 * To perform remove student functionality on the Student Roster page
	 */
	@Test(priority = 8)
	public void TCSPR080308() {

		// click on check box
		waitFor(cr.studentchkbx_1);
		check(cr.studentchkbx_1);

		// verify the check box is checked
		Assert.assertEquals(getAttribute(cr.studentchkbx_1, "aria-checked"), "true");

		// click on Action button
		click(cr.btn_Action);

		// verify the Action drop down visible
		waitFor(cr.Actiondropdown);
		Assert.assertTrue(isDisplayed(cr.Actiondropdown), "Action dropdown box not visible");
		waitThread(2000);

		// click on Remove Invitation Link
		click(cr.link_Removestudents);
		waitFor(rs.popupbtn_Yes);
		JavaScriptclick(rs.popupbtn_Yes);
		waitFor(cr.toaster);
		waitThread(1000);
		// verify toaster message
		Assert.assertEquals(getText(cr.toaster), "Successfully Removed");

		// verify the student email not visible
		Assert.assertFalse(isElementPresent(cr.gridvalue_email), "Removed Student Email present on the Grid");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 9)
	public void TCSPR080309() {

		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * To check that the Removed course visible on student profile
	 */
	@Test(priority = 10)
	public void TCSPR080310() {

		rs.login_Student(Emailstudent1, password);
		// click on My course tab
		click(spdp.MyCourseTab);

		// verify label
		waitFor(rs.btnlbl_joincourse);
		Assert.assertEquals(getText(rs.btnlbl_joincourse), "Join New Course");

		// verify course name
		Assert.assertFalse(isElementPresent(rs.enrolledcoursename), "Course name not visible on the page");

	}

	/*
	 * To check that the student can send request for the same course [Removed
	 * Course]
	 */
	@Test(priority = 11)
	public void TCSPR080311() {

		// click on join course button
		click(rs.btnlbl_joincourse);

		// student box visible
		Assert.assertTrue(isElementPresent(rs.studentbx), "The Student Box not visible");

		// Type course ID
		type(rs.txtbx_courseID, CourseID);

		// click on Send request button
		click(rs.btn_sendrequest);

		// verify Success popup
		Assert.assertTrue(isElementPresent(rs.success_popup), "The Success pop up Box not visible");
		// verify labels
		waitFor(rs.lbl_requestsend);
		Assert.assertEquals(getText(rs.lbl_requestsend), "Request Sent");
		Assert.assertEquals(getText(rs.lbl_popup),
				"Your request for this course has been sent\n" + "to the teacher," + " " + Teachername);

		// click on close button
		waitFor(rs.popupbtn_close);
		click(rs.popupbtn_close);

		// verify the popup not visible
		waitThread(3000);
		Assert.assertFalse(isElementPresent(rs.lbl_popup), "The Success pop up Box  visible");

	}

	/*
	 * To perform logout functionality on the student profile
	 */
	@Test(priority = 12)
	public void TCSPR080312() {

		// perform logout
		TCSPR080309();
	}

	/*
	 * To check the request view link functionality on the course landing page
	 */
	@Test(priority = 13)
	public void TCSPR080313() {

		rs.login_Teacher(Emailteacher, password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// verify count on the landing page
		Assert.assertEquals(getText(rs.requestcount), "1");

		// verify view link
		Assert.assertTrue(isElementPresent(rs.requestviewlink), "View Link not visible");

		// click on view link
		click(rs.requestviewlink);

		// verify labels,request count and course name
		Assert.assertEquals(getText(rs.heading_Requestfrmstud), "Requests from Students for Enrollment");
		Assert.assertEquals(getText(rs.Requestcount), "1");
		Assert.assertEquals(getText(rs.coursename).trim(), "Course:\n" + CourseName.trim());

	}

	/*
	 * To check that teacher can send request using removed student Email Address
	 */
	@Test(priority = 14)
	public void TCSPR080314() {

		// click on Student Roster tab
		click(cr.heading_courseroster);

		// click on Add students button
		click(cr.btn_Addstudents_in);
		waitFor(cr.Window_coursename);

		// verify the header course name visible on the popup
		Assert.assertEquals(getText(cr.Window_coursename), "Build a list of students to be invited to join the course: " + CourseName.trim());

		// Type email on chip
		type(cr.chip_1, Emailstudent1 + ",");

		cm.invitestudent();		
		waitFor(cr.toaster);

		// verify toaster message
		Assert.assertEquals(getText(cr.toaster), "Successfully sent email(s)");

		// click on invite radio button
		waitFor(cr.radiobtn_invited);

		// click on invited radio button
		click(cr.radiobtn_invited);

		// verify the Emails on the grid
		Assert.assertEquals(getText(cr.grid_email_1), Emailstudent1);

		waitThread(3000);

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 15)
	public void TCSPR080315() {

		// perform logout
		TCSPR080309();

	}

	/*
	 * To check that the teacher request visible on the page
	 */
	@Test(priority = 16)
	public void TCSPR080316() {

		rs.login_Student(Emailstudent1, password);
		// Click on My Course tab
		click(spdp.MyCourseTab);
		// verify labels,course name
		waitFor(rs.lbl_joincourse);
		Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");
		Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not Present");
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());

	}

	/*
	 * To perform Delete Student Account functionality
	 */
	@Test(priority = 17)
	public void TCSPR080317() {

		cr.DeleteAccount();


	}

	/*
	 * To perform login functionality using deleted student profile credentials
	 */
	@Test(priority = 18)
	public void TCSPR080318() {

		// login using deleted account credentials
		lg.login(Emailstudent1, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * Perform Login using Teacher credentials and perform delete account
	 * functionality
	 */
	@Test(priority = 19)
	public void TCSPR080319() {

		lg.login1(Emailteacher, password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// To delete teacher login
		TCSPR080317();

	}

	/*
	 * To perform login functionality using deleted Teacher profile credentials
	 */
	@Test(priority = 20)
	public void TCSPR080320() {

		// login using deleted account credentials
		lg.login(Emailteacher, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}
}
