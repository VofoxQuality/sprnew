package StudentLogin.Test;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Course.Pages.CourseRosterPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import StudentLogin.Pages.StudentAcceptCoursePage;
import StudentLogin.Pages.StudentProfileBasicDetailsPage;

public class StudentAcceptCourseTest extends basePage {

	StudentAcceptCoursePage sa = new StudentAcceptCoursePage();
	Databaseconnection dc = new Databaseconnection();
	StudentProfileBasicDetailsPage spdp = new StudentProfileBasicDetailsPage();
	StudentProfileBasicDetailsTest spt = new StudentProfileBasicDetailsTest();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	LoginPage lg =new LoginPage();
	CourseRosterPage cr = new CourseRosterPage();
	SignUpTest st = new SignUpTest();
	SignUpPage sp = new SignUpPage();
	EncryptedText et = new EncryptedText();
	public String EmailTeacher;
	public String otp;
	public String CourseID;
	public String coursename;
	public String EmailStud;
	public String Url;
	public String Teacher_firstname;
	public String Teacher_lastname;
	public String Teacher_fullname;
	public String Password;
	public String Stud_firstname;
	public String Stud_lastname;
	public String Student_ID;
	public String studentinviteid;

	/*
	 * Perform Sign Up
	 */
	@Test(priority = 0)
	public void TCSPR080201() throws SQLException {

		Teacher_firstname = "Test";
		Teacher_lastname = "Teacher";
		Teacher_fullname = "Test" + " " + "Teacher";
		Password = "Abc@123";

		// Assert the heading label "Welcome to Student Peer Review"
		Assert.assertEquals(getText(sa.welcome_to_label1), "Welcome to Student Peer Review");

		// Perform Teacher Sign up
		// Click on I'm a Teacher button
		click(sa.teach_button1);
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
	public void TCSPR080202() {

		// Click create new course Button
		click(sa.create_newcourse_btn3);

		// To get course id
		CourseID = getText(sa.courseid1);

		// Assert the course code
		Assert.assertTrue(isElementPresent(sa.courseid1), "CourseID: is not present");

		// Read Course Code
		Assert.assertEquals(getText(sa.courseid1), CourseID);

		// click on course title text box
		click(sa.coursetitle_txt);
		coursename = "GK" + generateRandomNumber().trim() + "part1";

		// type course name
		type(sa.coursetitle_txt, coursename);

		// Assert the course name on the text box
		Assert.assertEquals(getValue(sa.coursetitle_txt), coursename);

		// click Add Students button
		click(sa.Add_students_btn4);

		click(sa.emailtype_txt);
		// type email
		EmailStud = "studenttest" + generateRandomNumber().trim() + "@gmail.com";
		type(sa.emailtype_txt, EmailStud);
		driver.findElement(By.xpath(sa.emailtype_txt)).sendKeys(Keys.SPACE);

		cm.invitestudent();
		// click Create&Invite button
		waitThread(4000);
		click(sa.Create_invite_btn6);

		// Assert the Course title in grid
		Assert.assertEquals(getText(sa.course_tit_grid), coursename);

	}

	/*
	 * To check the Invitited student details on the course roster page
	 */
	@Test(priority = 3)
	public void TCSPR080203() {

		// click "Details Drop down"
		click(sa.Details_drop);

		waitFor(sa.Veiwmodify_btn);
		// Assert "View/Modify Student Roaster" link
		Assert.assertEquals(getText(sa.Veiwmodify_btn), "View/Modify Student Roster");

		// click "View/Modify Student Roaster button"
		click(sa.Veiwmodify_btn);

		// Assert heading Course Roaster
		Assert.assertEquals(getText(sa.course_roast), "Student Roster");

		// Click on "Invited &Not Accepted radio button"
		click(sa.Invited_drop);

		// Click on Add students Button
		click(sa.Add_stud_bt);

		waitFor(sa.Add_stud_course_hd);
		// Assert heading "Add Students to this Course : Course Name+Random
		// Number"
		Assert.assertEquals(getText(sa.Add_stud_course_hd), "Build a list of students to be invited to join the course: " + coursename);

		// Click on " Invite Students from my existing courses" tab
		click(sa.Add_stud_list);

		// Assert text "No Student(s) Found. "
		Assert.assertEquals(getText(sa.No_stud_found_txt), "No Student(s) Found.");

		// Click on "Invite New Students"
		click(sa.ivite_new_stud_btn);

		// Assert tab heading:" Invite New Students"
		Assert.assertEquals(getText(sa.ivite_new_stud_btn), "Invite new students");

		click(sa.emailtype_txt);
		// type email
		type(sa.emailtype_txt, EmailStud);
		driver.findElement(By.xpath(sa.emailtype_txt)).sendKeys(Keys.SPACE);

		// Assert email present on text box
		Assert.assertTrue(isElementPresent(sa.emailtype_txt), "Email not present");

		cm.invitestudent();

		// Assert Toaster Message "Successfully send email(s)"
		waitFor(sa.tost_1);
		//waitThread(1000);
		Assert.assertEquals(getText(sa.tost_1), "Successfully sent email(s)");
		//click radio button invite students 
		
		click(sa.Invited_drop);
		waitThread(4000);
		waitFor(sa.email_incourseroaster_grid);
		// Assert email is visible on the grid
		Assert.assertEquals(getText(sa.email_incourseroaster_grid), EmailStud);

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 4)
	public void TCSPR080204() {

		waitThread(2000);
		// To perform logout functionality on the teacher profile
		// Perform logout
		spdp.Logout();
		// Assert heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");

	}

	/*
	 * To check the course visible on the suspended students profile
	 */
	@Test(priority = 5)
	public void TCSPR080205() throws SQLException {
		Stud_firstname = "Test";
		Stud_lastname = "Student";

		// To perform Sign up functionality of student

		studentinviteid = dc.InviteLink(EmailStud, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		//driver.get("UrlSignUp"+ encText);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Assert heading Sign up
		Assert.assertEquals(getText(sa.signup_label2), "Sign Up");

		// click FirstName Text box
		click(sa.firstnametxt1);

		// type firstname
		type(sa.firstnametxt1, Stud_firstname);

		// click LastName Textbox
		click(sa.lastnametxt2);

		// type LastName
		type(sa.lastnametxt2, Stud_lastname);

		// Click Password Textbox
		click(sa.passwordtxt4);

		// type password
		type(sa.passwordtxt4, Password);

		// Click Confirm Password Textbox
		click(sa.confirmpasstxt5);

		// type Confirm password
		type(sa.confirmpasstxt5, Password);

		// click on privacy policy checkbox
		click(sa.checkbox1);

		// click Signup button
		click(sa.signup_button2);
		waitThread(4000);
		// Assert coursename visible on student profile
		Assert.assertEquals(getText(sa.coursename_studentpage), coursename);

		// Assert Accept Button
		Assert.assertEquals(getText(sa.Accept_btn), "Accept");

	}

	/*
	 * To check the labels in the Student Sign up page
	 */
	@Test(priority = 6)
	public void TCSPR080206() {

		// click Accept Button
		click(sa.Accept_btn);

		waitThread(1000);
		// Assert popup window visible
		Assert.assertTrue(isElementPresent(sa.Confir_label), "Confirmation popup not visible");

		// Assert the text "Are you sure that you want to accept this course?"
		Assert.assertEquals(getText(sa.Confir_label),
				"Are you sure that you want to accept this invitation to join the [" + coursename
						+ "] course being taught by [" + Teacher_fullname + "] ?");

		// Assert button-Yes and No
		Assert.assertEquals(getText(sa.Yes_btn), "Yes");
		Assert.assertEquals(getText(sa.No_btn), "No");

		// Click No button
		click(sa.No_btn);
		waitThread(1000);

		// Assert no popup visible
		Assert.assertFalse(isElementPresent(sa.Confir_label), "Confirmation popup visible");

		// click Accept Button
		click(sa.Accept_btn);

		// click Yes Button
		click(sa.Yes_btn);
		waitFor(sa.tost_1);

		// Assert Toaster Message "Course accepted successfully"
		Assert.assertEquals(getText(sa.tost_1), "Course accepted successfully");

	}

	/*
	 * To check the required field validation messages
	 */
	@Test(priority = 7)
	public void TCSPR080207() {

		// Assert heading Enrolled Courses
		Assert.assertEquals(getText(sa.enrolled_course_hd), "Enrolled Courses");
		waitThread(3000);
		// Assert heading Course created by
		Assert.assertEquals(getText(sa.Course_created_label), "Course Created By");

		// Assert Teacher drop down
		Assert.assertTrue(isElementPresent(sa.teach_drop), "Teacher drop down is not present");
		waitThread(1000);
		// Assert teacher name on the teacher drop down
		Assert.assertEquals(getText(sa.teach_nam_drop), Teacher_fullname);

		// Assert the accepted course visible on the grid
		Assert.assertTrue(isElementPresent(sa.acept_course), "Accepted course not present");

		// Assert the Course name with course title
		Assert.assertEquals(getText(sa.acept_course), coursename);

	}

	/*
	 * To check the student Sign Up functionality To fill all the parameters and
	 * Assert the headings
	 */
	@Test(priority = 8)
	public void TCSPR080208() {

		// Assert the text "Course ID:"
		Assert.assertEquals(getText(sa.Courseid_text), "Course ID:");

		// Assert the course ID same as on the course add page"
		Assert.assertEquals(getText(sa.Course_id_student_pro), "Course ID: " + CourseID);

		// Assert Text "Joined On"
		Assert.assertEquals(getText(sa.Joined_text), "Joined On:");

		// Assert joined date same as system date
		Assert.assertEquals(getText(sa.date), "Joined On: " + sa.getdate());

		// Assert text "Open Assessments:0"
		Assert.assertEquals(getText(sa.openassess_txt), "Open Assessments: 0");

		// Assert the text Course created by: text
		Assert.assertEquals(getText(sa.Course_creat_bytext), "Course Created By");
		Assert.assertEquals(getText(sa.teach_name), Teacher_fullname);

	}

	/*
	 * To check the search functionality on the student profile
	 */
	@Test(priority = 9)
	public void TCSPR080209() {

		// Assert search box on the student login page
		Assert.assertTrue(isElementPresent(sa.Stud_searchbox), "Search box not present");

		// type Course title on the search box
		type(sa.Stud_searchbox, coursename);

		// Assert Course Name visible on page
		Assert.assertTrue(isElementPresent(sa.acept_course), "Course name not visible");

	}

	/*
	 * To perform logout functionality on the student profile
	 */
	@Test(priority = 10)
	public void TCSPR080210() {

		// To read student ID:
		// click on header drop down
		click(sa.stud_dropdwn);

		// click Account settings
		click(sa.Accntset);
		waitThread(2000);
		// get Student ID:
		Student_ID = getText(sa.StudentIDdetails).substring(13);
		// Student_ID = getText(sa.StudentIDdetails);
		System.out.println(getText(sa.StudentIDdetails));
		// To perform logout functionality on the teacher profile
		// Perform logout
		spdp.Logout();

		// Assert heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");
	}

	/*
	 * To check the enrolled students details on the teacher course landing
	 * page. To check the course roster page
	 */
	@Test(priority = 11)
	public void TCSPR080211() {

		// Login as Teacher
		rs.login_Teacher(EmailTeacher, Password);

		// Assert the heading label "Courses"
		Assert.assertEquals(getText(sa.courses_label4), "Courses");

		// Assert the enrolled student count is 1 for the Course
		Assert.assertEquals(getText(sa.Enrolled_course_grid), "1");

		// click "Details Dropdown"
		click(sa.Details_drop);

		waitFor(sa.Veiwmodify_btn);

		// Assert "View/Modify Student Roster" link
		Assert.assertEquals(getText(sa.Veiwmodify_btn), "View/Modify Student Roster");

		// click "View/Modify Student Roster button"
		click(sa.Veiwmodify_btn);

		// Assert heading Course Roaster
		Assert.assertEquals(getText(sa.course_roast), "Student Roster");
		waitFor(sa.coursenam_grid);

		// Assert Coursename on the grid
		Assert.assertEquals(getText(sa.coursenam_grid), coursename);

		// Assert the text Enrolled
		Assert.assertEquals(getText(sa.enrol_lab), "Enrolled");

		// Assert the Enrolled radio button is checked
		Assert.assertTrue(isElementPresent(sa.enroll_radio), "Enrolled radio button is not checked");

	}

	/*
	 * To check the student details on the Invited & Not Accepted grid
	 */
	@Test(priority = 12)
	public void TCSPR080212() {

		// Click on "Invited &Not Accepted radio button"
		click(sa.Invited_drop);

		// Assert "Assert the Invited &Not Accepted radio button is checked"
		Assert.assertTrue(isElementPresent(sa.Invited_drop), "Invited &Not  Accepted radio button is checked");

		// Assert email not is visible on the grid
		Assert.assertFalse(isElementPresent(sa.email_incourseroaster_grid), " Email is visible on grid");

	}

	/*
	 * To check the student details on the course roster enrolled grid
	 */
	@Test(priority = 13)
	public void TCSPR080213() {

		// Click on Enrolled radio button
		click(sa.Enrol_rad);

		// Assert the Enrolled radio button is checked
		Assert.assertTrue(isElementPresent(sa.enroll_radio), "Enrolled radio button is not checked");

		// Assert the student ID on the page
		Assert.assertEquals(getText(sa.Studentid_grid), Student_ID);

		waitThread(2000);
		// Assert First Name Test on the page
		Assert.assertEquals(getText(sa.Firstname_grid), Stud_firstname);

		// Assert Last Name Test on the page
		Assert.assertEquals(getText(sa.Lastname_grid), Stud_lastname);

		// Assert Student email on grid
		Assert.assertEquals(getText(sa.email_grid), EmailStud);

		// Assert Enrolled via Status "Invitation" on the grid
		Assert.assertEquals(getText(sa.Status_invit), "Invitation");

	}

	/*
	 * To check the Add more students functionality with Enrolled student email
	 */
	@Test(priority = 14)
	public void TCSPR080214() {

		// Click on Add students Button
		click(sa.Add_stud_bt);
		waitFor(sa.Add_stud_course_hd);

		// Assert heading "Add Students to this Course : Course Name+Random
		// Number"
		Assert.assertEquals(getText(sa.Add_stud_course_hd), "Build a list of students to be invited to join the course: " + coursename);

		// Click on " Add students from 'My Students' List" tab
		click(sa.Add_stud_list);

		// Assert text "No Student(s) Found. "
		Assert.assertEquals(getText(sa.No_stud_found_txt), "No Student(s) Found.");

		// Click on "Invite New Students"
		click(sa.ivite_new_stud_btn);

		// Assert tab heading:" Invite New Students"
		Assert.assertEquals(getText(sa.ivite_new_stud_btn), "Invite new students");
		click(sa.emailtype_txt);

		// type Email (Enrolled student Email)
		type(sa.emailtype_txt, EmailStud);
		driver.findElement(By.xpath(sa.emailtype_txt)).sendKeys(Keys.SPACE);

		// Assert email present on text box
		Assert.assertTrue(isElementPresent(sa.emailtype_txt), "Email not present");

		SoftAssert assert1 = new SoftAssert();
		// click on add to list button
		click(sa.tab_btn_Addtolist);
		waitThread(4000);
		click(sa.confirmyesbtn);

		// Assert Toaster Message "Please remove invalid email(s) from the
		// "Invite New
		// Students" list"
		waitFor(sa.tost_1);
		assert1.assertEquals(getText(sa.tost_1), "Please correct the errors in the \"Invite new students\" tab to proceed further","Assersion failed");

		// Hover the Email on the text box
		MouseHover(sa.emailtype_txt);

		// Assert Tool tip
		Assert.assertTrue(isElementPresent(sa.tooltip), "Tooltip is not prsent");

		// Assert Tool tip Text
		Assert.assertEquals(getAttribute(sa.tooltip, "ptooltip"), "Student already enrolled");
		assert1.assertAll();
	}

	/*
	 * To check the suspend student functionality on the course roster page
	 */
	@Test(priority = 15)
	public void TCSPR080215() {

		// click close button
		click(sa.close__btn);

		// click checkbox
		click(sa.grid_checkbx);

		// Assert the check box is checked
		Assert.assertTrue(isElementPresent(sa.cour_grid_check), "Checkbox not  checked");

		// click on Actions drop down
		click(sa.Actions);
		waitFor(sa.susp_stud);

		// Assert link :Suspend Students
		Assert.assertEquals(getText(sa.susp_stud), "Suspend Students");

		// Click on Suspend Students Link
		click(sa.susp_stud);
		
		//Click on yes button
		click(sa.Yes_btn);

		// Assert Toaster Popup visible
		Assert.assertTrue(isElementPresent(sa.tost_1), "Toaster popup not visible");
		waitFor(sa.tost_1);

		// Assert Toaster Message "Successfully Suspended"
		Assert.assertEquals(getText(sa.tost_1), "Successfully suspended");
		waitThread(2000);

		// Assert text on the grid "No Student(s) Found."
		Assert.assertEquals(getText(sa.no_stud_found), "No Student(s) Found.");

	}

	/*
	 * To check that the suspended student listed on the suspended page
	 */
	@Test(priority = 16)
	public void TCSPR080216() {
		waitThread(3000);
		// Click on suspended radio button
		click(sa.Susp_rd);

		// Assert the radio button is checked
		Assert.assertTrue(isElementPresent(sa.Susp_rd), "Suspended radio button is not checked");

	}

	/*
	 * To check the Add more students functionality with Suspended student email
	 */
	@Test(priority = 17)
	public void TCSPR080217() {

		// Click on Add students Button
		click(sa.Add_stud_bt);
		waitFor(sa.Add_stud_course_hd);

		// Assert heading "Add Students to this Course : Course Name+Random
		// Number"
		Assert.assertEquals(getText(sa.Add_stud_course_hd), "Build a list of students to be invited to join the course: " + coursename);

		// Assert tab heading:" Invite New Students"
		Assert.assertEquals(getText(sa.ivite_new_stud_btn), "Invite new students");

		click(sa.emailtype_txt);
		// type Email (Enrolled student Email)
		type(sa.emailtype_txt, EmailStud);
		driver.findElement(By.xpath(sa.emailtype_txt)).sendKeys(Keys.SPACE);

		// Assert email present on text box
		Assert.assertTrue(isElementPresent(sa.emailtype_txt), "Email not present");
		// click on add to list button
		click(sa.tab_btn_Addtolist);
		waitThread(3000);
		click(sa.confirmyesbtn);		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// click on Add to list button
		//click("//button[@id='sendRequestId']");

		// Assert invalid Toaster Popup visible
		Assert.assertTrue(isElementPresent(sa.tost_1), " Invalid Toaster popup not visible");

		waitFor(sa.emailtype_txt);
		// Hover the Email on the text box
		MouseHover(sa.emailtype_txt);

		// Assert Tool tip Text
		Assert.assertEquals(getAttribute(sa.tooltip1, "ptooltip"), "Suspended student's email address");

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 18)
	public void TCSPR080218() {

		// click cancel button
		click(sa.close__btn);
		waitThread(2000);
		// To perform logout functionality on the teacher profile
		// Perform logout
		spdp.Logout();

		// Assert heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");
	}

	/*
	 * To check the course not visible on the suspended students profile
	 */
	@Test(priority = 19)
	public void TCSPR080219() {

		// Login as student
		rs.login_Student(EmailStud, Password);

		Assert.assertTrue(isElementPresent(spdp.selectedmycoursetab), "My course Tab is not selected");
		// click on join new course button
		click(sa.Join_newCourse_btn);
		waitFor(sa.newjoine_labl);

		// Assert the heading "Join New Course"
		Assert.assertEquals(getText(sa.newjoine_labl), "Join New Course");
		waitThread(5000);
		// Assert course name: Course Name+Random Number not visible on the
		// student
		// profile
		Assert.assertTrue(isElementPresent(sa.suspendedlbl), "Suspended label not visible");

	}

	/*
	 * To perform logout functionality on the student profile
	 */
	@Test(priority = 20)
	public void TCSPR080220() {

		// To perform logout functionality on the teacher profile
		// Perform logout
		spdp.Logout();
		// Assert heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");
	}

	/*
	 * To check Re-Enroll functionality on the Course roster Suspended page. -To
	 * verify the suspended page details
	 */
	@Test(priority = 21)
	public void TCSPR080221() {

		// Login as Teacher
		rs.login_Teacher(EmailTeacher, Password);

		// Assert the heading label "Courses"
		Assert.assertEquals(getText(sa.courses_label4), "Courses");

		// Assert the enrolled student count is 0 for the course Course Name
		Assert.assertEquals(getText(sa.Enrolled_course_grid), "0");

		// click "Details Drop down"
		click(sa.Details_drop);
		waitFor(sa.Veiwmodify_btn);

		// Assert "View/Modify Student Roaster" link
		Assert.assertEquals(getText(sa.Veiwmodify_btn), "View/Modify Student Roster");

		// click "View/Modify Student Roaster button"
		click(sa.Veiwmodify_btn);

		// Assert heading Course Roaster
		Assert.assertEquals(getText(sa.course_roast), "Student Roster");
		waitFor(sa.coursenam_grid);

		// Assert Course name on the grid
		Assert.assertEquals(getText(sa.coursenam_grid), coursename);

		// Click on suspended radio button
		click(sa.Susp_rd);

		// Assert the radio button is checked
		Assert.assertTrue(isElementPresent(sa.susp_rad_tick), "Suspended radio button is not checked");

	}

	/*
	 * To verify the student details on the Course roster Suspended page
	 */
	@Test(priority = 22)
	public void TCSPR080222() {

		waitFor(sa.email_grid);
		// Assert Email Random Generated Email on the grid
		Assert.assertEquals(getText(sa.email_grid), EmailStud);

		// Assert the student ID on the page
		Assert.assertEquals(getText(sa.Studentid_grid), Student_ID);

		// Assert First Name Test on the page
		Assert.assertEquals(getText(sa.Firstname_grid), Stud_firstname);

		// Assert Last Name Test on the page
		Assert.assertEquals(getText(sa.Lastname_grid), Stud_lastname);

		// Assert Enrolled via Status "Invitation" on the grid
		Assert.assertEquals(getText(sa.Status_invit), "Invitation");

	}

	/*
	 * To check Re-Enroll functionality on the Course roster Suspended page
	 */
	@Test(priority = 23)
	public void TCSPR080223() {

		// click check box
		click(sa.grid_checkbx);

		// Assert the check box is checked
		Assert.assertTrue(isElementPresent(sa.cour_grid_check), "Checkbox not checked");

		// click on Actions drop down
		click(sa.Actions);
		waitFor(sa.Re_enrol_btn);

		// Assert the Re-enroll Students link
		Assert.assertEquals(getText(sa.Re_enrol_btn), "Re-enroll Students");

		// click on Re-enroll Students link
		click(sa.Re_enrol_btn);
		
		//click on yes button
		click(sa.Yes_btn);

		// Assert Toaster Pop up visible
		Assert.assertTrue(isElementPresent(sa.tost_1), "Toaster popup not visible");

		// Assert Toaster Message "Successfully enrolled"
		waitFor(sa.tost_1);
		Assert.assertEquals(getText(sa.tost_1), "Successfully enrolled");
		waitThread(3000);
		// Assert text on the grid "No Student(s) Found."
		Assert.assertEquals(getText(sa.suspendedpagenostudentlbl), "No Student(s) Found.");
	}

	/*
	 * To check the Re-Enrolled student on the Enrolled student page
	 */
	@Test(priority = 24)
	public void TCSPR080224() {

		// Click on Enrolled radio button
		click(sa.Enrol_rad);
		waitFor(sa.email_grid);

		// Assert Student email on grid
		Assert.assertEquals(getText(sa.email_grid), EmailStud);

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 25)
	public void TCSPR080225() {

		waitThread(2000);
		// To perform logout functionality on the teacher profile
		// Perform logout
		spdp.Logout();

		// Assert heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");

	}

	/*
	 * To check that the Re-Enrolled course visible on student profile
	 */
	@Test(priority = 26)
	public void TCSPR080226() {

		// Login as student
		rs.login_Student(EmailStud, Password);
		// click on My course tab
		click(spdp.MyCourseTab);
		// click on join new course button
		click(sa.Join_newCourse_btn);
		waitFor(sa.newjoine_labl);

		// Assert the heading "Join New Course"
		Assert.assertEquals(getText(sa.newjoine_labl), "Join New Course");

		// Assert the Course name with course title
		Assert.assertEquals(getText(sa.acept_course), coursename);

	}

	/*
	 * To check the Send Request functionality on the student profile with
	 * enrolled course course code
	 */
	@Test(priority = 27)
	public void TCSPR080227() {

		// click on text box
		click(sa.enter_courseid);

		// Enter course id of the Course Name on text box
		type(sa.enter_courseid, CourseID);

		// click Send Request Button
		click(sa.Send_req_btn);

		// Assert Toaster Pop up visible
		Assert.assertTrue(isElementPresent(sa.tost_1), "Toaster popup not visible");

		// Assert Toaster Message "you are currently enrolled in this course"
		waitFor(sa.tost_1);
		Assert.assertEquals(getText(sa.tost_1),
				"You are currently enrolled in this course (" + CourseID + " - " + coursename + ")");

	}

	/*
	 * To perform Delete Student Account functionality
	 */
	@Test(priority = 28)
	public void TCSPR080228() {

		waitThread(2000);
		// Perform Delete Account functionality
		cr.DeleteAccount();


	}

	/*
	 * To perform login functionality using deleted student profile credentials
	 */
	@Test(priority = 29)
	public void TCSPR080229() {

		// Perform Login(student)
		lg.login(EmailStud, Password);

		waitFor(sa.tost_1);

		// "Assert toaster message "Enter a valid email address and password"
		Assert.assertEquals(getText(sa.tost_1), "Enter a valid email address and password");

	}

	/*
	 * Perform Login using Teacher credentials and perform delete account
	 * functionality
	 */
	@Test(priority = 30)
	public void TCSPR080230() {
		// Login using teacher credentails

		// Login as Teacher
		lg.login1(EmailTeacher, Password);

		// Assert the heading label "Courses"
		Assert.assertEquals(getText(sa.courses_label4), "Courses");

		// Perform Delete Account functionality
		cr.DeleteAccount();

	}

	/*
	 * To perform login functionality using deleted Teacher profile credentials
	 */
	@Test(priority = 31)
	public void TCSPR080231() {
		// Login using teacher credentials

		// Login as Teacher
		lg.login(EmailTeacher, Password);

		waitFor(sa.tost_1);

		// "Assert toaster message "Enter a valid email address and password"
		Assert.assertEquals(getText(sa.tost_1), "Enter a valid email address and password");

	}

}
