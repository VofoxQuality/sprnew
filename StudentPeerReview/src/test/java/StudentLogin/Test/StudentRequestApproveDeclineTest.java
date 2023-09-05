package StudentLogin.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Generalmethods.Databaseconnection;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpCommonTest;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.AddStudentFromMyStudentListPage;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import StudentLogin.Pages.StudentProfileBasicDetailsPage;
import StudentLogin.Pages.StudentRequestApproveDeclinePage;

public class StudentRequestApproveDeclineTest extends basePage {

	StudentProfileBasicDetailsPage spdp = new StudentProfileBasicDetailsPage();
	AddStudentFromMyStudentListPage adds = new AddStudentFromMyStudentListPage();
	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	CourseRosterPage cr = new CourseRosterPage();
	RemoveStudentFromCourseTest rst = new RemoveStudentFromCourseTest();
	Databaseconnection dc = new Databaseconnection();
	RemoveStudentFromCoursePage rsp = new RemoveStudentFromCoursePage();
	LoginPage lg = new LoginPage();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	SignUpCommonTest sct = new SignUpCommonTest();
	StudentRequestApproveDeclinePage sr = new StudentRequestApproveDeclinePage();
	public String Emailteacher;
	public String CourseName;
	public String CourseID;
	public String Studentfirstname = "Clara";
	public String Studentlastname = "April";
	public String Studentname;
	public String StudentEmail;
	public String studotp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";
	public String Student_ID;

	/*
	 * To perfrom Teacher Sign Up
	 */
	@Test(priority = 0)
	public void TCSPR080501() throws SQLException {

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

	/*
	 * To fill the create new course page
	 */
	@Test(priority = 2)
	public void TCSPR080502() {

		CourseName = "Course Name" + generateRandomNumber().trim();

		// Click on create new course button
		click(cn.btn_createnew);

		// type-Course title
		type(cn.txbx_Coursetitle, CourseName);

		// To verify course name
		Assert.assertEquals(getValue(cn.txbx_Coursetitle).trim(), CourseName.trim());

	}

	/*
	 * To create a course
	 */
	@Test(priority = 3)
	public void TCSPR080503() {

		// To get the Course ID
		CourseID = (getText(cn.course_Id));
		waitThread(2000);

		// click on create course button
		click(cn.btn_Createcourse);

		waitThread(3000);

		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), CourseName.trim());
		waitThread(3000);

	}

	/*
	 * Perform Logout
	 */
	@Test(priority = 4)
	public void TCSPR080504() {
	
		// perform logout
		rst.TCSPR080309();

	}

	/*
	 * Sign Up as student
	 */
	@Test(priority = 5)
	public void TCSPR080505() throws SQLException {

		// To perform sign up functionality of student
		StudentEmail = sct.SignUptest();
		
		sct.SignUpotp();

		// verify label
		Assert.assertEquals(getText(sr.gridemptytext), "You have not enrolled in any course(s).");
		
	}

	/*
	 * To check the course details on the student profile
	 */
	@Test(priority = 6)
	public void TCSPR080506() {

		// click on join course button
		click(rsp.btnlbl_joincourse);

		// student box visible
		Assert.assertTrue(isElementPresent(rsp.studentbx), "The Student Box not visible");

		// Type course ID
		type(rsp.txtbx_courseID, CourseID);

		// click on Send request button
		click(rsp.btn_sendrequest);

		waitThread(2000);
		// verify Success popup
		Assert.assertTrue(isElementPresent(rsp.success_popup), "The Success pop up Box not visible");

	}

	/*
	 * To check the details on the request send popup
	 */
	@Test(priority = 7)
	public void TCSPR080507() {

		// verify labels
		waitFor(rsp.lbl_requestsend);
		Assert.assertEquals(getText(rsp.lbl_requestsend), "Request Sent");
		Assert.assertEquals(getText(rsp.lbl_popup),
				"Your request for this course has been sent\n" + "to the teacher," + " " + Teachername);

		// click on close button
		waitFor(rsp.popupbtn_close);
		click(rsp.popupbtn_close);

		// verify the popup not visible
		waitThread(3000);
		Assert.assertFalse(isElementPresent(rsp.lbl_popup), "The Success pop up Box  visible");

	}

	/*
	 * To check the Requested Courses Pending Teacher Approval grid functionality on
	 * the page
	 */
	@Test(priority = 8)
	public void TCSPR080508() {

		// click on join course button
		// click(rsp.btnlbl_joincourse);

		// verify the student
		Assert.assertTrue(isElementPresent(rsp.studentbx), "The Student Box not visible");

		// click request send tab
		click(sr.requestsendtab);

		// verify the request count and course name
		Assert.assertEquals(getText(sr.requestcount1), "1");
		Assert.assertEquals(getText(sr.coursename), CourseName);
	}

	/*
	 * To verify the details(Course ID,Date,Teacher name) on the student box
	 */

	@Test(priority = 9)
	public void TCSPR080509() {

		// verify the request visible
		Assert.assertTrue(isElementPresent(sr.requestsendtab), "Request send tab not visible");

		// verify the Course Id
		Assert.assertEquals(getText(sr.courseid), "Course ID: " + CourseID);

		// verify the Teacher name
		waitFor(sr.teachername);
		Assert.assertEquals(getText(sr.teachername), "Approval pending from:\n" + "Test Teacher");

		// verify the request send date
		waitFor(sr.requestsenddate);
		Assert.assertEquals(getText(sr.requestsenddate), "Request Sent: " + cn.getdate());

		// verify cancel button visible
		Assert.assertTrue(isElementPresent(sr.btncancel), "Cancel Button Not visible");

	}

	/*
	 * TTo perform logout functionality on the student profile
	 */
	@Test(priority = 10)
	public void TCSPR080510() {

		// click on navigation menu
		click(sr.navarrowbtn);

		// verify the account settings button
		Assert.assertTrue(isElementPresent(sr.accountsettingsbtn), "Account Settings Button Not visible");

		// To read student ID:
		// click Account settings
		click(adds.Accntset);
		waitThread(2000);
		// get Student ID:
		getText(adds.StudentIDdetails);
		Student_ID = getText(adds.StudentIDdetails).substring(13);

		// perform logout
		rst.TCSPR080309();
	}

	/*
	 * To check the request view link functionality on the course landing page
	 */
	@Test(priority = 11)
	public void TCSPR080511() {

		rsp.login_Teacher(Emailteacher, password);
		// verify heading courses
		waitFor(lg.pagetitle3);
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// verify count on the landing page
		Assert.assertEquals(getText(rsp.requestcount), "1");

		// verify view link
		Assert.assertTrue(isElementPresent(rsp.requestviewlink), "View Link not visible");

		// click on view link
		click(rsp.requestviewlink);

		// verify labels,request count and course name
		Assert.assertEquals(getText(rsp.heading_Requestfrmstud), "Requests from Students for Enrollment");

	}
	/*
	 * Verify the details on the Requests from Students for Enrollment page
	 */

	@Test(priority = 12)
	public void TCSPR080512() {

		// verify the request count
		Assert.assertEquals(getText(rsp.Requestcount), "1");

		waitThread(1000);
		// To verify the course name
		Assert.assertEquals(getText(rsp.coursename).trim(), "Course:\n" + CourseName.trim());

		// To verify the course id
		Assert.assertEquals(getText(sr.gridstudentid), Student_ID);

		// To verify the date
		Assert.assertEquals(getText(sr.griddate), cr.getdate());

	}

	/*
	 * To check the student request for enrollment page functionality
	 */
	@Test(priority = 13)
	public void TCSPR080513() {

		// To verify the labels[Student name,Email,Status]
		Assert.assertEquals(getText(sr.studentfirstname), Studentfirstname);
		Assert.assertEquals(getText(sr.studentlastname), Studentlastname);
		Assert.assertEquals(getText(sr.studentemail), StudentEmail);

		// To verify the Approve and Decline button disabled
		Assert.assertFalse(isEnabled(sr.btnapprove), "Approve button is Enabled");
		Assert.assertFalse(isEnabled(sr.btndecline), "Decline button is Enabled");

	}

	/*
	 * To check the decline request functionality on the student request for
	 * enrollment page
	 */
	@Test(priority = 14)
	public void TCSPR080514() {

		// click on check box
		check(cr.studentchkbx_1);

		// verify the check box is checked
		Assert.assertEquals(getAttribute(cr.studentchkbx_1, "aria-checked"), "true");

		// click on decline check box
		click(sr.btndecline);

		// verify toaster
		waitFor(sr.toaster);
		Assert.assertEquals(getText(sr.toaster), "Student Request(s) declined successfully");

	}

	/*
	 * To check the decline request functionality on the student request for
	 * enrollment page
	 */
	@Test(priority = 15)
	public void TCSPR080515() {
		waitThread(2000);

		// verify the student Email visible
		Assert.assertFalse(isElementPresent(sr.studentemail), "Student Email  visible");

		//Click on Requests to join the course that were processed radio button
		click(sr.requestprocessedradiobtn);
		waitThread(3000);

		// verify the student Email visible
		Assert.assertTrue(isElementPresent(sr.studentemail), "Student Email Not visible");

	}

	/*
	 * To check the search functionality on the student request for enrollment page
	 */
	@Test(priority = 16)
	public void TCSPR080516() {

		// To perform the search functionality and verify the Email on the grid
		type(sr.searchboxgrid, StudentEmail);
		Assert.assertEquals(getText(sr.studentemail_1), StudentEmail);

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 17)
	public void TCSPR080517() {

		// perform logout
		rst.TCSPR080309();

	}

	/*
	 * To verify the teacher declined request card not not visible on student
	 * profile. -To perform the Send Request to teacher functionality on the student
	 * profile
	 */
	@Test(priority = 18)
	public void TCSPR080518() {

		// Perform Login
		rsp.login_Student(StudentEmail, password);
		// click on My Course tab
		click(spdp.MyCourseTab);
		Assert.assertTrue(isElementPresent(rsp.btnlbl_joincourse), "Join course button  not visible");

		// click on join course button
		click(rsp.btnlbl_joincourse);

		// student box visible
		Assert.assertTrue(isElementPresent(rsp.studentbx), "The Student Box not visible");

		// Type course ID
		type(rsp.txtbx_courseID, CourseID);

		// click on Send request button
		click(rsp.btn_sendrequest);

		// verify Success popup
		Assert.assertTrue(isElementPresent(rsp.success_popup), "The Success pop up Box not visible");

	}

	/*
	 * To verify the teacher declined request card not not visible on student
	 * profile. -To perform the Send Request to teacher functionality on the student
	 * profile
	 */
	@Test(priority = 19)
	public void TCSPR080519() {

		// verify labels,Teacher name
		waitFor(rsp.lbl_requestsend);
		Assert.assertEquals(getText(rsp.lbl_requestsend), "Request Sent");
		Assert.assertEquals(getText(rsp.lbl_popup),
				"Your request for this course has been sent\n" + "to the teacher," + " " + Teachername);

		// click on close button
		waitFor(rsp.popupbtn_close);
		click(rsp.popupbtn_close);

		// verify the popup not visible
		waitThread(3000);
		Assert.assertFalse(isElementPresent(rsp.lbl_popup), "The Success pop up Box  visible");

	}

	/*
	 * Logout from Teacher
	 */
	@Test(priority = 20)
	public void TCSPR080520() {

		// perform logout
		rst.TCSPR080309();

	}

	/*
	 * To check the request view link functionality on the course landing page
	 */
	@Test(priority = 21)
	public void TCSPR080521() {

		// To load the Requests from Students for Enrollment Page
		TCSPR080511();
		// verify the student Email visible
		Assert.assertEquals(getText(sr.studentemail), StudentEmail);

	}

	/*
	 * Logout -Teacher
	 */
	@Test(priority = 22)
	public void TCSPR080522() {

		// perform logout
		rst.TCSPR080309();

	}

	/*
	 * To check the cancel request functionality on the student profile
	 */
	@Test(priority = 23)
	public void TCSPR080523() {

		// Perform student login
		rsp.login_Student(StudentEmail, password);
		// click on My Course tab
		click(spdp.MyCourseTab);
		// click on join course button
		click(rsp.btnlbl_joincourse);

		// student box visible
		Assert.assertTrue(isElementPresent(rsp.studentbx), "The Student Box not visible");
		waitThread(2000);

		// click on request send tab
		click(sr.requestsendtab);
		waitThread(2000);
		// To verify the count
		Assert.assertEquals(getText(sr.requestcount1), "1");

		// To verify the course name
		Assert.assertEquals(getText(sr.coursename), CourseName);

		// click on cancel button
		click(sr.btncancel);

		// verify the confirmation box visible
		Assert.assertTrue(isElementPresent(sr.confirmationbx1), "Confirmation box not visible");
		waitFor(sr.confirmationtxt1);

		// Assert the text
		Assert.assertEquals(getText(sr.confirmationtxt1),
				"Are you sure that you want to cancel the course join request?");

	}

	/*
	 * To check the cancel request functionality on the student profile
	 */
	@Test(priority = 24)
	public void TCSPR080524() {

		// Assert the buttons

		Assert.assertTrue(isElementPresent(sr.btnNo), "No Button Not Visible");
		Assert.assertTrue(isElementPresent(sr.btnYes), "No Button Not Visible");

		// To click on No button
		click(sr.btnNo);

		// verify the confirmation box not visible
		waitThread(2000);
		Assert.assertFalse(isElementPresent(sr.btnNo), "Confirmation box visible");

		// click on cancel button
		click(sr.btncancel);

		// verify the confirmation box visible
		Assert.assertTrue(isElementPresent(sr.confirmationbx1), "Confirmation box not visible");

		// click on Yes button
		click(sr.btnYes);

		// verify toaster
		waitFor(sr.toaster);
		Assert.assertEquals(getText(sr.toaster), "Course join request cancelled successfully");
		waitThread(4000);
	}

	/*
	 * Logout-Student
	 */
	@Test(priority = 25)
	public void TCSPR080525() {

		// perform logout
		rst.TCSPR080309();

	}

	/*
	 * Sign up as teacher,To check the request view link functionality on the course
	 * landing page
	 */
	@Test(priority = 26)
	public void TCSPR080526() {

		// perform login
		rsp.login_Teacher(Emailteacher, password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");
		//Clicking the icon to copy the course id 
		click(rsp.Course_id);
		
		waitFor(rsp.Cpymessage);
		//Verify the pop up box 
	
		
		Assert.assertEquals(getText(rsp.Cpymessage),"Course ID is copied to clipboard");
		waitThread(4000);
		
		
		//log out teacher 
		TCSPR080522();
		
		//rst.TCSPR080309();
		
		//login student
		rsp.login_Student(StudentEmail, password);
		
		//my course click 
		click(spdp.MyCourseTab);
		// click on request i send to join a course 
		click(rsp.btnlbl_joincourse);
		//check student box visible or not
		
		Assert.assertTrue(isElementPresent(rsp.studentbx), "The Student Box not visible");
		
		//type course id inside "Enter course Id"
		
		type(rsp.txtbx_courseID, CourseID);
		
		
		
		// click on Send request button
		click(rsp.btn_sendrequest);
		waitThread(2000);
		// verify Success popup
		Assert.assertTrue(isElementPresent(rsp.success_popup), "The Success pop up Box not visible");
		
	   //Validating the message 
		
		TCSPR080507();
		// Click on the narrow button
		
		click(sr.navarrowbtn);
		
		// verify the account settings button
		Assert.assertTrue(isElementPresent(sr.accountsettingsbtn), "Account Settings Button Not visible");
		// To read student ID: click Account settings
		click(adds.Accntset);
		waitThread(2000);
		// get Student ID:
		getText(adds.StudentIDdetails);
		Student_ID = getText(adds.StudentIDdetails).substring(13);

		// perform logout
		rst.TCSPR080309();

		
		//perform login
		
		rsp.login_Teacher(Emailteacher, password);


		// click on view link
		click(rsp.requestviewlink);
		waitThread(3000);

		// verify labels,request count and course name
		Assert.assertEquals(getText(rsp.heading_Requestfrmstud), "Requests from Students for Enrollment");

		Assert.assertTrue(isElementPresent(sr.studentemail), "Student Email visible");

		// perform logout
		rst.TCSPR080309();

}

	/*
	 * To perform send request to the teacher functionality
	 */
	@Test(priority = 27)
	public void TCSPR080527() {

		// Perform Login

		rsp.login_Student(StudentEmail, password);
		// click on My Course tab
		click(spdp.MyCourseTab);
		Assert.assertTrue(isElementPresent(rsp.btnlbl_joincourse), "Join course button  not visible");

		// click on join course button
		click(rsp.btnlbl_joincourse);

		// student box visible
		Assert.assertTrue(isElementPresent(rsp.studentbx), "The Student Box not visible");

		// Type course ID
		type(rsp.txtbx_courseID, CourseID);

		// click on Send request button
		click(rsp.btn_sendrequest);

		// verify Success popup
		Assert.assertTrue(isElementPresent(rsp.success_popup), "The Success pop up Box not visible");

	}

	/*
	 * To perform send request to the teacher functionality
	 */
	@Test(priority = 28)
	public void TCSPR080528() {

		// verify labels
		waitThread(2000);
		waitFor(rsp.lbl_requestsend);
		Assert.assertEquals(getText(rsp.lbl_requestsend), "Request Sent");
		Assert.assertEquals(getText(rsp.lbl_popup),
				"Your request for this course has been sent\n" + "to the teacher," + " " + Teachername);

		// click on close button
		waitFor(rsp.popupbtn_close);
		click(rsp.popupbtn_close);

		// verify the popup not visible
		waitThread(3000);
		Assert.assertFalse(isElementPresent(rsp.lbl_popup), "The Success pop up Box  visible");

	}

	/*
	 * To perform logout functionality on the student profile
	 */
	@Test(priority = 29)
	public void TCSPR080529() {

		// perform logout
		rst.TCSPR080309();
	}

	/*
	 * Sign up as teacher,To check the request visible on teacher profile
	 */
	@Test(priority = 30)
	public void TCSPR080530() {

		rsp.login_Teacher(Emailteacher, password);

		// click on view link
		click(rsp.requestviewlink);

		// verify labels,request count and course name
		Assert.assertEquals(getText(rsp.heading_Requestfrmstud), "Requests from Students for Enrollment");
		Assert.assertEquals(getText(sr.studentemail), StudentEmail);

		// click on check box
		check(cr.studentchkbx_1);

		// verify the check box is checked
		Assert.assertEquals(getAttribute(cr.studentchkbx_1, "aria-checked"), "true");
	}

	/*
	 * To check the Accept Course request functionality on the student request for
	 * enrollment page
	 */
	@Test(priority = 31)
	public void TCSPR080531() {

		// click on Approve button
		click(sr.btnapprove);

		// Assert the toaster
		waitFor(sr.toaster);
		Assert.assertEquals(getText(sr.toaster), "Student Request(s) accepted successfully");
		waitThread(2000);
		// verify the Email not visible
		Assert.assertFalse(isElementPresent(sr.studentemail), "Student Email  visible");

		click(sr.requestprocessedradiobtn);
		waitThread(3000);

		// verify the student email visible
		Assert.assertTrue(isElementPresent(sr.studentemail), "Student Email Not visible");

		// verify the status label and date
		Assert.assertEquals(getText(sr.status_1), "APPROVED");
		Assert.assertEquals(getText(sr.griddate_1), cr.getdate());

	}

	/*
	 * To check that the Approved student list visible on the course roster enrolled
	 * page
	 */
	@Test(priority = 32)
	public void TCSPR080532() {

		// click on course roaster tab
		click(cr.heading_courseroster);

		waitFor(cr.gridvalue_email);
		waitThread(1000);
		// To verify the Student Email on the grid
		Assert.assertEquals(getText(cr.gridvalue_email), StudentEmail);

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 33)
	public void TCSPR080533() {

		// perform logout
		rst.TCSPR080309();

	}

	/*
	 * To check the request card not visible on the student profile. -To check the
	 * teacher approved course visible on the student profile
	 */
	@Test(priority = 34)
	public void TCSPR080534() {

		// perform login
		rsp.login_Student(StudentEmail, password);
		// click on My Course tab
		click(spdp.MyCourseTab);

		// click on join course button
		click(rsp.btnlbl_joincourse);

		// student box visible
		Assert.assertTrue(isElementPresent(rsp.studentbx), "The Student Box not visible");
		waitThread(2000);

		// click on request send tab
		click(sr.requestsendtab);

		// Verify the course name not visible
		Assert.assertFalse(isElementPresent(sr.coursename), "The course name visible on the page");

	}

	/*
	 * To check the teacher accepted course visible in the student profile page. To
	 * check the enrolled course details
	 */
	@Test(priority = 35)
	public void TCSPR080535() {

		// verify the course name
		Assert.assertEquals(getText(sr.coursenamebox), CourseName);

		// To verify the Course Id,Joined Date,Open Assessments,Teacher Name
		Assert.assertEquals(getText(sr.detailsbox),
				"Course ID: " + CourseID + "\nJoined On: " + cn.getdate() + "\nOpen Assessments: 0");
		Assert.assertEquals(getText(sr.teachernamechip), "Course Created By\n" + Teachername);

	}

	/*
	 * To perform Delete Student Account functionality
	 */
	@Test(priority = 36)
	public void TCSPR080536() {

		// Perform delete account
		cr.DeleteAccount();


	}

	/*
	 * To perform login functionality using deleted student profile credentials
	 */
	@Test(priority = 37)
	public void TCSPR080537() {

		// Perform Login
		lg.login(StudentEmail, password);
		waitFor(lg.validationmsg3);

		// verify toaster text
		Assert.assertEquals(getText(lg.validationmsg3), "Enter a valid email address and password");

	}

	/*
	 * Perform Login using Teacher credentials and perform delete account
	 * functionality
	 */
	@Test(priority = 38)
	public void TCSPR080538() {

		// Perform Login
		lg.login1(Emailteacher, password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// Perform Delete account
		cr.DeleteAccount();

	}

	/*
	 * To perform login functionality using deleted Teacher profile credentials
	 */
	@Test(priority = 39)
	public void TCSPR080539() {

		lg.login(Emailteacher, password);

		waitFor(lg.validationmsg3);
		// verify toaster text
		Assert.assertEquals(getText(lg.validationmsg3), "Enter a valid email address and password");

	}

}
