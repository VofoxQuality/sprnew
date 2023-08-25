package StudentLogin.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.AddStudentFromMyStudentListPage;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import StudentLogin.Pages.StudentProfileBasicDetailsPage;

public class AddStudentFromMyStudentListTest extends basePage {

	AddStudentFromMyStudentListPage adds = new AddStudentFromMyStudentListPage();
	Databaseconnection dc = new Databaseconnection();
	SignUpTest st = new SignUpTest();
	SignUpPage sp = new SignUpPage();
	EncryptedText et = new EncryptedText();
	StudentProfileBasicDetailsPage spdp = new StudentProfileBasicDetailsPage();
	StudentProfileBasicDetailsTest spt = new StudentProfileBasicDetailsTest();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	CourseRosterPage cr = new CourseRosterPage();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	LoginPage lg = new LoginPage();

	public String EmailTeacher;
	public String otp;
	public String coursecode;
	public String coursename;
	public String Emailstud;
	public String Url;
	public String Teacher_firstname;
	public String Teacher_lastname;
	public String Teacher_fullname;
	public String Password;
	public String Stud_firstname;
	public String Stud_lastname;

	public String Student_ID;
	public String studentinviteid;
	public String coursecode_new;

	/*
	 * Perform Teacher Sign up
	 */
	@Test(priority = 0)
	public void TCSPR080401() throws SQLException {
		Teacher_firstname = "Test";
		Teacher_lastname = "Teacher";
		Teacher_fullname = Teacher_firstname + " " + Teacher_lastname;
		Password = "Abc@123";

		// Assert the heading label "Welcome to Student Peer Review"
		Assert.assertEquals(getText(adds.wel_label), "Welcome to Student Peer Review");

		// Click on I'm a Teacher button
		click(adds.teach_btn);

		// To fill the details on the sign up page
		EmailTeacher = st.TCSPR020005();
		System.out.println(EmailTeacher);

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
	 * To create course
	 */
	@Test(priority = 2)
	public void TCSPR080402() {
		// Click on the Create New Course Button
		click(adds.creatnw_coursebtn);

		// Assert the course code present(Read the course code)
		coursecode = getText(adds.course_code);
		Assert.assertTrue(isElementPresent(adds.course_code), "Coursecode not present");

		// click on course title text box
		click(adds.coursetitle_txt);
		coursename = "GK_" + generateRandomNumber().trim() + "part1";

		// type course name
		type(adds.coursetitle_txt, coursename);

		// click Add Students button
		click(adds.Add_studbtn);
		click(adds.emailtype_txt);

		// type email
		Emailstud = "studenttest" + generateRandomNumber().trim() + "@gmail.com";
		type(adds.emailtype_txt, Emailstud);
		driver.findElement(By.xpath(adds.emailtype_txt)).sendKeys(Keys.SPACE);
		waitThread(1000);

		cm.invitestudent();

		// click Create&Invite button
		click(adds.createinvite_btn);
		// Assert the Course title in grid
		Assert.assertEquals(getText(adds.course_tit_grid), coursename);

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 3)
	public void TCSPR080403() {

		waitThread(3000);
		// To perform logout functionality on the teacher profile
		spdp.Logout();
		// Assert heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");

	}

	/*
	 * To load the invitation link that send by the teacher
	 */
	@Test(priority = 4)
	public void TCSPR080404() throws SQLException {

		// To perform Signup functionality of student
		studentinviteid = dc.InviteLink(Emailstud, coursecode);
		String encText = et.EncryptCode(studentinviteid);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Assert heading Signup
		Assert.assertEquals(getText(spdp.hd_label2), "Sign Up");

	}

	/*
	 * To check the student Sign Up functionality To fill all the parameters and
	 * Assert the headings
	 */
	@Test(priority = 5)
	public void TCSPR080405() throws SQLException {

		// Application should be in the Student Peer Review Sign up Page
		Stud_firstname = "Test";
		Stud_lastname = "Student";

		// click FirstName Textbox
		click(adds.firstnametxt1);

		// type firstname as "Test"
		type(adds.firstnametxt1, Stud_firstname);

		// click LastName Textbox
		click(adds.lastnametxt2);

		// type LastName as "Student"
		type(adds.lastnametxt2, Stud_lastname);

		// Click Password Textbox
		click(adds.passwordtxt4);

		// type password
		type(adds.passwordtxt4, Password);

		// Click Confirm Password Textbox
		click(adds.confirmpasstxt5);

		// type Confirm password
		type(adds.confirmpasstxt5, Password);

		// click SignUp button
		click(adds.signup_btn);

		waitFor(adds.tost_1);

		// Assert Toaster Message "Please Agree to the Terms & Conditions and
		// Privacy
		// Policy before Sign Up"
		Assert.assertEquals(getText(adds.tost_1),
				"Please agree to the Terms & Conditions and the Privacy Policy before signing up");
		click(adds.toasterclosebtn);

		// click on privacy policy checkbox
		click(adds.checkbox1);

		// Assert the checkbox is checked
		Assert.assertTrue(isElementPresent(adds.checkbx1_tick),
				"Terms& Conditions and privacy policy checkbox not selected");

		// click on SignUp button
		click(adds.signup_btn);

		waitFor(adds.newjoine_labl);
		// Assert the heading "Join New Course"
		Assert.assertEquals(getText(adds.newjoine_labl), "Join New Course");

	}

	/*
	 * To check the course details on the student profile
	 */
	@Test(priority = 6)
	public void TCSPR080406() {

		// Application should be on student profile
		// Assert the course name Course Name visible on the -Request Received
		Assert.assertEquals(getText(adds.coursename_studentpage), coursename);

	}

	/*
	 * To perform the Accept course functionality on the student login
	 */
	@Test(priority = 7)
	public void TCSPR080407() {

		// To perform the Accept course functionality on the student login
		// Click Accept button
		click(adds.Accept_btn);

		// Assert the confirmation popup window visible
		Assert.assertTrue(isElementPresent(adds.confirm_hd), "popup is not  visible");

		// Assert yes button
		Assert.assertTrue(isElementPresent(adds.Yes_btn), "yes button is not present");

		// click Yes Button
		click(adds.Yes_btn);
		waitFor(adds.tost_1);
		// Assert Toaster Message "Course accepted successfully"
		Assert.assertEquals(getText(adds.tost_1), "Course accepted successfully");
		click(adds.toasterclosebtn);

		// Assert confirmation popup not visible
		Assert.assertFalse(isElementPresent(adds.confirm_hd), "popup  visible");

	}

	/*
	 * To check the enrolled course grid functionality on the student profile
	 * page. To check the enrolled course details
	 */
	@Test(priority = 8)
	public void TCSPR080408() {

		// Assert Teacher dropdown
		Assert.assertTrue(isElementPresent(adds.teach_drop_text), "Teacher drop down is not present");

		waitThread(1000);
		// Assert teachername on the teacher dropdown
		Assert.assertEquals(getText(adds.teach_drop_text), Teacher_fullname);

		// Assert the accepted course visible on the grid
		Assert.assertTrue(isElementPresent(adds.acept_course), "Accepted course not present");

		// Assert the Course name with course title
		Assert.assertEquals(getText(adds.acept_course), coursename);

		// Assert the text label :Course ID
		Assert.assertEquals(getText(adds.Courseid_text), "Course ID:");

		// Assert the course ID same as on the course add page
		Assert.assertEquals(getText(adds.Courseid_num), "Course ID: " + coursecode);

	}

	/*
	 * To perform logout functionality on the student profile
	 */
	@Test(priority = 9)
	public void TCSPR080409() {

		// click on header dropdown
		click(adds.stud_dropdwn);

		// To read student ID:
		// click Account settings
		click(adds.Accntset);
		waitThread(1000);
		// get Student ID:
		getText(adds.StudentIDdetails);
		Student_ID = getText(adds.StudentIDdetails).substring(13);

		// To perform logout functionality on the student profile
		spdp.Logout();
		// Assert heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");

	}

	/*
	 * To check the enrolled students details on the teacher course landing
	 * page. To check the course roster page
	 */
	@Test(priority = 10)
	public void TCSPR080410() {
		// "Application should be on Login page"
		// perform login
		rs.login_Teacher(EmailTeacher, Password);

		// Assert the heading label "Courses"
		Assert.assertEquals(getText(adds.courses_label), "Courses");

		// Assert the enrolled student count is 1 for the course
		Assert.assertEquals(getText(adds.Enrolled_course_grid), "1");

		// click "Details Dropdown"
		click(adds.Details_drop);

		waitFor(adds.Veiwmodify_link);

		// Assert "View/Modify Student Roster" link
		Assert.assertEquals(getText(adds.Veiwmodify_link), "View/Modify Student Roster");

		// click "View/Modify Student Roster button"
		click(adds.Veiwmodify_link);

		// Assert heading Course Roaster
		Assert.assertEquals(getText(adds.course_roast), "Student Roster");
		waitFor(adds.coursenam_grid);

		// Assert Coursename on the grid
		Assert.assertEquals(getText(adds.coursenam_grid), coursename);

		waitThread(2000);
		// Assert First Name Test on the page
		Assert.assertEquals(getText(adds.Firstname_grid3), Stud_firstname);

		// Assert Last Name on the page
		Assert.assertEquals(getText(adds.Lastname_grid), Stud_lastname);

		// Assert Student email on grid
		Assert.assertEquals(getText(adds.email_grid), Emailstud);

	}

	/*
	 * To check the back button functionality
	 */
	@Test(priority = 11)
	public void TCSPR080411() {

		// Assert back button visible
		Assert.assertTrue(isElementPresent(adds.back_btn), "back button is not present");

		// Click on back button
		click(adds.back_btn);

		// Assert the heading label "Courses"
		Assert.assertEquals(getText(adds.courses_label), "Courses");

	}

	/*
	 * To perform the create new course functionality on the landing page
	 */

	public String coursename_new = "Maths" + generateRandomNumber().trim();

	@Test(priority = 12)
	public void TCSPR080412() {

		// Click on the Create New Course Button
		click(adds.creatnw_coursebtn);

		// Assert the course code present(Read the course code)
		coursecode_new = getText(adds.course_code);
		Assert.assertTrue(isElementPresent(adds.course_code), "Coursecode not present");

		// click on course title text box
		click(adds.coursetitle_txt);

		// type course name
		type(adds.coursetitle_txt, coursename_new);

		waitThread(1000);
		// Assert the course name on the text box
		Assert.assertEquals(getValue(adds.coursetitle_txt), coursename_new);

		// click Add Students button
		click(adds.Add_studbtn);

		// Assert the Add students Pop up window visible
		Assert.assertTrue(isElementPresent(adds.popup1), "popup window not visible");

		// Assert heading Add Students to this Course : Course Name
		Assert.assertEquals(getText(adds.popup_heading), "Add students to the course: " + coursename_new);

		// Click on Invite Students from my existing courses tab
		click(adds.addstud_label);

		// Assert Heading "Invite Students from my existing courses"
		Assert.assertEquals(getText(adds.addstud_label), "Invite students from my existing courses");

	}

	/*
	 * To check the Add students from 'My Students' List tab functionality. To
	 * verify the Labels,Buttons,Text
	 */
	@Test(priority = 13)
	public void TCSPR080413() {

		waitThread(1000);
		// Assert the firstname of student
		Assert.assertEquals(getText(adds.Firstname_grid1), Stud_firstname);
		waitFor(adds.Lastname_grid1);
		// Assert lastname of student
		Assert.assertEquals(getText(adds.Lastname_grid1), Stud_lastname);

		waitFor(adds.Stud_id1);
		// Assert the student id on the page same as in the student profile
		Assert.assertEquals(getText(adds.Stud_id1), Student_ID);

		// Assert the email id of enrolled student visible on grid
		Assert.assertEquals(getText(adds.email_grid1), Emailstud);

	}

	/*
	 * To verify the check boxes and there functionality
	 */
	@Test(priority = 14)
	public void TCSPR080414() {

		// Assert the All check box visible
		Assert.assertTrue(isElementPresent(adds.All_checkbox), "All Check box is not visible ");

		// Assert the check box near student name is visible
		Assert.assertTrue(isElementPresent(adds.checkboxgrid), "check box near Student name is not visible");

		// Click on All check box
		click(adds.All_checkbox);

		// Assert the check box checked
		Assert.assertTrue(isElementPresent(adds.allcheckbox_tick), "Checkbox is not checked");

		// Assert the checkbox near the student near name checked
		Assert.assertTrue(isElementPresent(adds.checkboxgrid_tick), "Checkbox is not checked");

		// Assert the text "Total Students Selected: 1/1"
		Assert.assertEquals(getText(adds.addstud_select), "Total Students Selected: 1/1");

		waitFor(adds.stud_text);

		cm.invitestudent();
		// Assert Text Students from My Student list
		Assert.assertEquals(getText(adds.stud_text), "Students from My Student list");

		// Assert the Email visible on the Students from My Student list
		Assert.assertEquals(getText(adds.stud_list_box), Emailstud);

		// Click on create & invite button
		waitThread(2000);
		click(adds.createinvite_btn);

		// Assert the newly created course name visibled on the page
		waitThread(3000);
		Assert.assertEquals(getText(adds.coursenam2), coursename_new);

	}

	/*
	 * To check that Students from My Student list tab. Verify that the added
	 * student listed on the preview page
	 */
	@Test(priority = 15)
	public void TCSPR080415() {

		// waitFor(cn.searchbx);
		click(cn.searchbx_1);

		// type course name
		type(cn.searchbx_1, coursename_new);
		waitThread(3000);

		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), coursename_new.trim());
		// Click On new course detail button
		click(adds.Details_drop);

		// click "View/Modify Student Roster button"
		click(adds.Veiwmodify_link);

		// Click on Invited &Not Accepted radio button
		click(adds.invited_radio);
		waitThread(2000);
		// Assert the enrolled student Email visible on the grid
		waitFor(adds.email_grid);
		Assert.assertEquals(getText(adds.email_grid), Emailstud);
		waitThread(2000);
		// Assert First Name Test on the page
		Assert.assertEquals(getText(adds.Firstname_grid3), Stud_firstname);

		// Assert Last Name on the page
		Assert.assertEquals(getText(adds.Lastname_grid), Stud_lastname);

		// Assert the student id on the page same as in the student profile
		Assert.assertEquals(getText(adds.Stud_id), Student_ID);

		// Assert Text "NOT ACCEPTED"
		Assert.assertEquals(getText(adds.text_notacceptnew), "NOT ACCEPTED");

		// Assert the invitation send date same as system date
		Assert.assertEquals(getText(adds.date_grid_courseroster), adds.getdate());

		// Perform Logout functionality
		spdp.Logout();
		// Assert heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");

	}

	/*
	 * To Load the invitation link and verify the heading Login
	 */
	@Test(priority = 16)
	public void TCSPR080416() throws SQLException {

		// Assert heading Login
		Assert.assertEquals(getText(adds.Login_hd), "Login");

		rs.login_Student(Emailstud, Password);
		waitThread(1000);
		// click on My course tab
		click(spdp.MyCourseTab);

		// Assert the New_Course Name visible on the page
		Assert.assertEquals(getText(adds.newcourse_name), coursename_new);

	}

	/*
	 * To perform logout functionality on the student profile
	 */
	@Test(priority = 17)
	public void TCSPR080417() {
		// To perform logout functionality on the student profile
		spdp.Logout();
		// Assert heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");

	}

	/*
	 * To check Invite students from my existing course from course roster page
	 */
	@Test(priority = 18)
	public void TCSPR080418() {
		// To check Invite students from my existing course page functionality
		// from
		// course
		// roster page

		// Login as Teacher
		rs.login_Teacher(EmailTeacher, Password);

		// Assert the heading label "Courses"
		Assert.assertEquals(getText(adds.courses_label), "Courses");

		// waitFor(cn.searchbx);
		click(cn.searchbx_1);

		// type course name
		type(cn.searchbx_1, coursename_new);
		waitThread(3000);

		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), coursename_new.trim());

		// Click On new course detail button
		click(adds.Details_drop);

		// click "View/Modify Student Roster button"
		click(adds.Veiwmodify_link);

		// Assert heading Course Roaster
		Assert.assertEquals(getText(adds.course_roast), "Student Roster");
		waitFor(adds.coursenam_grid);

		// Assert Coursename on the grid
		Assert.assertEquals(getText(adds.coursenam_grid), coursename_new);
	}

	/*
	 * To Perform revoke invitation
	 */
	@Test(priority = 19)
	public void TCSPR080419() {

		// To Perform revoke invitation
		// Click on Invited &Not Accepted radio button
		click(adds.invited_radio);

		// Assert Student email on grid
		Assert.assertEquals(getText(adds.email_grid), Emailstud);

		// click on checkbox
		click(adds.checkbox_grid1);

		// Assert the checkbox is checked
		Assert.assertTrue(isElementPresent(adds.checkbox_tick), "Check box is not checked");

		// click Actions drop down
		click(adds.Actions_drop);
		waitThread(1000);

		// Assert link :Revoke Invitation
		Assert.assertEquals(getText(adds.Revok_link), "Revoke Invitations");

		// Click on Revoke Invitation link
		waitThread(1000);
		click(adds.Revok_link);
		click(adds.Yes_btn);
		waitFor(adds.tost_1);

		// Assert toaster message:Successfully Revoked
		Assert.assertEquals(getText(adds.tost_1), "Successfully revoked");
		click(adds.toasterclosebtn);
		waitThread(1000);

		// Assert Email:Random Generatrated Email not visible on the grid
		Assert.assertFalse(isElementPresent(adds.email_grid), "Email visible on grid");

	}

	/*
	 * To check Invite students from my existing course from course roster page
	 */
	@Test(priority = 20)
	public void TCSPR080420() {

		// Application should be in the Student Peer Review course roster Page
		// Click on Add students Button
		click(adds.add_student_btn1);
		waitFor(adds.course_head);
		// Assert heading Add Students to this Course : Course Name
		Assert.assertEquals(getText(adds.course_head), "Add students to the course: " + coursename_new);

		// Click on Invite Students from my existing courses
		click(adds.Add_stud_listtab);
		waitThread(2000);

		// Assert heading Invite Students from my existing courses
		Assert.assertEquals(getText(adds.Add_stud_listtab), "Invite students from my existing courses");

	}

	/*
	 * To check the Add students from 'My Students' List tab functionality. To
	 * verify the Labels,Buttons,Text
	 */
	@Test(priority = 21)
	public void TCSPR080421() {
		// To check the Invite Students from my existing courses tab
		// functionality.
		// Assert the student first name
		Assert.assertEquals(getText(adds.Firstname_grid1), Stud_firstname);

		// Assert the student last name
		Assert.assertEquals(getText(adds.Lastname_grid1), Stud_lastname);

		waitThread(1000);
		// Assert the student id on the page same as in the student profile
		Assert.assertEquals(getText(adds.Stud_id1), Student_ID);

		// Assert the email [Enrolled Student Email] present on the text box
		Assert.assertEquals(getText(adds.email_grid1), Emailstud);

	}

	/*
	 * To verify the check boxes and there functionality
	 */
	@Test(priority = 22)
	public void TCSPR080422() {
		// Assert the All check box visible
		Assert.assertTrue(isElementPresent(adds.all_checkbox), "All Check box is not visible ");

		// Assert the check box near student name
		Assert.assertTrue(isElementPresent(adds.grid_checkbx), "check box near Student name is visible");

		// Click on All check box
		click(adds.all_checkbox);

		// Assert the check box checked
		Assert.assertTrue(isElementPresent(adds.al_check_tick), "Checkbox is not checked");

		// Assert the checkbox near the student near name checked
		Assert.assertTrue(isElementPresent(adds.grid_check_tick), "Checkbox is not checked");

		// Assert the text "Total Students Selected: 1/1
		Assert.assertEquals(getText(adds.addstud_select), "Total Students Selected: 1/1");

	}

	/*
	 * To check that Students from My Student list tab. Verify that the added
	 * student listed on the preview page
	 */
	@Test(priority = 23)
	public void TCSPR080423() {
		// Application should be on the create new course Add students page
		// Click on the Add to list button
		click(adds.add_stud_listbtn);

		waitThread(2000);
		waitFor(adds.studfrom_text);
		// Assert Text Students from My Student list
		Assert.assertEquals(getText(adds.studfrom_text), "Students from My Student list");
		waitFor(adds.stud_list_box);

		// Assert the Email visible on the Students from My Student list
		Assert.assertEquals(getText(adds.stud_list_box), Emailstud);

		// Click on send request button
		click(adds.send_req);

		// Assert the student first name
		Assert.assertEquals(getText(adds.Firstname_grid4), Stud_firstname);

		// Assert the student last name
		Assert.assertEquals(getText(adds.Lastname_grid), Stud_lastname);

		// Assert the student id on the page same as in the student profile
		Assert.assertEquals(getText(adds.Stud_id), Student_ID);

		// Assert the email [Enrolled Student Email] present on the text box
		Assert.assertEquals(getText(adds.email_grid), Emailstud);

		// Assert Text "NOT ACCEPTED"
		Assert.assertEquals(getText(adds.text_notaccept), "NOT ACCEPTED");

		// Assert the invitation send date same as system date
		Assert.assertEquals(getText(adds.date_grid_courseroster), adds.getdate());
		waitThread(2000);

	}

	/*
	 * Perform student login and check the course name
	 */
	@Test(priority = 24)
	public void TCSPR080424() {

		// Perform Logout functionality
		spdp.Logout();
		// Assert heading Login
		Assert.assertEquals(getText(spdp.Login_hd), "Login");

		rs.login_Student(Emailstud, Password);
		// click on My course tab
		click(spdp.MyCourseTab);
		// Assert the New_Course Name visible on the page
		Assert.assertEquals(getText(adds.newcourse_name), coursename_new);

	}

	/*
	 * Delete student account
	 */
	@Test(priority = 25)
	public void TCSPR080425() {

		// To perform Delete Student Account functionality
		cr.DeleteAccount();

		waitThread(3000);

	}

	/*
	 * To perform login using deleted account credentials
	 */
	@Test(priority = 26)
	public void TCSPR080426() {
		// To perform login functionality using deleted student profile
		// credentials
		// Perform Login(student)
		lg.login(Emailstud, Password);

		waitFor(adds.tost_1);

		// "Assert toaster message "Invalid username or password"
		Assert.assertEquals(getText(adds.tost_1), "Enter a valid email address and password");

	}

	/*
	 * Perform Login using Teacher credentials and perform delete account
	 * functionality Login using teacher credentails
	 */
	@Test(priority = 27)
	public void TCSPR080427() {

		rs.login_Teacher(EmailTeacher, Password);
		waitThread(2000);

		// Assert the heading label "Courses"
		Assert.assertEquals(getText(adds.courses_label), "Courses");
		// Perform Delete Account functionality
		cr.DeleteAccount();

	}

	/*
	 * To perform login functionality using deleted Teacher profile credentials
	 * Login using teacher credentails
	 */
	@Test(priority = 28)
	public void TCSPR080428() {

		lg.login(EmailTeacher, Password);

		// rs.login_Teacher(EmailTeacher, Password);

		waitFor(adds.tost_1);

		// "Assert toaster message "Invalid username or password"
		Assert.assertEquals(getText(adds.tost_1), "Enter a valid email address and password");

	}

}
