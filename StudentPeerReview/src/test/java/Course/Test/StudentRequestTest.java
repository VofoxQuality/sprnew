package Course.Test;

import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Generalmethods.Databaseconnection;

import Course.Pages.CreateNewCoursePage;
import Course.Pages.StudentRequestPage;
import Login.Pages.LoginPage;

public class StudentRequestTest extends basePage {
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	StudentRequestPage sr = new StudentRequestPage();
	SignUpTest st = new SignUpTest();
	CreateNewCoursePage cn=new CreateNewCoursePage();
	public String coursetitle;
	public String Email;
	public String otp;
	public String CourseTitle;
	public String studentemail;
	SignUpPage sp = new SignUpPage();

	/*
	 * To load the Student Peer Review Landing Page
	 */
	@Test(priority = 0)
	public void TCSPR090101() throws SQLException {

		// To click on I am A teacher button
		click(sp.btn_1);

		// To fill the details on the sign up page
		Email = st.TCSPR020005();
	}

	@Test(priority = 1)
	public void OtpFetch() throws SQLException {

		// To catch OTP from sending Resource
		st.TCSPR020006();

	}

	/*
	 * To check the create new course functionality on the landing page
	 */

	@Test(priority = 2)
	public void TCSPR060402() {

		// click create New course Button
		click(sr.btn_createnewcrs);
		// To verify course id is present
		Assert.assertTrue(isElementPresent(sr.heading_lbl3), "Course ID not Present");
		// click course title
		click(sr.txtbox_crstitle);
		CourseTitle = "Course Name" + generateRandomNumber().trim();
		// type course title
		type(sr.txtbox_crstitle, CourseTitle);

		// To verify course title present on textbox
		Assert.assertEquals(getValue(sr.txtbox_crstitle), CourseTitle);
		// click add student button
		click(sr.btn_addstudent);
		waitThread(3000);

		// to verify add student popup
		Assert.assertTrue(isElementPresent(sr.popup_addstu), "Add student popup not present");
		// click add student email textbox
		click(sr.txtbox_addstudentemail);
		waitThread(2000);
		studentemail = "student" + generateRandomNumber().trim() + "@gmail.com";
		// type student email on textbox
		type(sr.txtbox_addstudentemail, studentemail);
		waitThread(1000);
		// To verify email present on text box
				Assert.assertEquals(getValue(sr.txtbox_addstudentemail), studentemail);
				//waitThread(2000);
		driver.findElement(By.xpath("//input[@id='inviteStudentChip']")).sendKeys(Keys.SPACE);
		waitThread(2000);
		
		
		// click add to list
		click(sr.btn_addtolist);
		waitThread(4000);
		click(cn.confirmyesbtn);
		click("//p-tabview/div/ul/li[3]/a/span[2]");
		waitThread(1000);
		click("//button[@id='sendRequestId']");
		waitThread(2000);
		// to verify email visible on new student to be invited text box
				Assert.assertEquals(getText(sr.txtbox_newstinvited), studentemail);
				waitThread(2000);
		ScrollTo_Location(sr.btn_createandinvite);
		waitThread(2000);
		// click create and invite
		click(sr.btn_createandinvite);
		waitThread(1000);
		waitFor(sr.toaster_coursecreatesuc);
		// To verify toaster message course created successfully
		Assert.assertEquals(getText(sr.toaster_coursecreatesuc), "Course created successfully");
		waitThread(1000);
		// to verify course title visible on the grid

		Assert.assertTrue(isElementPresent(sr.gridval_coursetitle), "Course not Visible on the grid");
	}

	/*
	 * To check the View/Process Student requests functionality on the grid
	 */
	@Test(priority = 3)
	public void TCSPR060403() {

		click(sr.splitbutton);
		waitThread(3000);
		Assert.assertTrue(isElementPresent(sr.view_modify_btn), "View/Modify course detail link not present");
		// click on View/Modify Course Details button
		click(sr.view_modify_btn);
		
		waitThread(2000);
		// To check the View link visible
	//	Assert.assertTrue(isElementPresent(sr.link_stre), " student request view link not present");

		//click(sr.link_stre);

		Assert.assertEquals(getText(sr.headtab_studentrequest), "Requests from Students for Enrollment");
	}

	/*
	 * To check the buttons,labels on the student request for enrollment pagess
	 */
	@Test(priority = 4)
	public void TCSPR060404() {
		waitThread(1000);
		// to verify label course
		Assert.assertEquals(getText(sr.lbl_course), "Course:");
		waitThread(1000);

		// to verify course title present
		Assert.assertEquals(getText(sr.headlbl_course).trim(), CourseTitle.trim());
		waitThread(1000);
		//*Assert the radio buttons and labels Pending Requests to join the course
		Assert.assertTrue(isElementPresent(sr.pending_request_radiobtn), "Pending request checkbox Not present");
		Assert.assertEquals(getText(sr.pending_request_radiobtn), "Pending Requests to join the course");
		//*Assert the radio buttons and labels Requests to join the course that were processed
		Assert.assertTrue(isElementPresent(sr.req_to_join_radiobtn), "Requests to join the course that were processed");
		Assert.assertEquals(getText(sr.req_to_join_radiobtn), "Requests to join the course that were processed");
		
		// to verify label Display Students Whose request were
		Assert.assertEquals(getText(sr.lbl_Displaystu), "Approve/Decline Requests from students");

		/* to verify check box approved present
		Assert.assertTrue(isElementPresent(sr.checkbox_approved), "checkbox Approved is not present");
		// to verify label approved
		Assert.assertEquals(getText(sr.lbl_Approved), "Approved");

		// to verify check box declined present
		Assert.assertTrue(isElementPresent(sr.checkbox_declined), "checkbox declined not present");
		// to verify label declined
		Assert.assertEquals(getText(sr.lbl_declined), "Declined");*/

		// to verify button approve is present
		Assert.assertTrue(isElementPresent(sr.btn_Approve), "Button approve is not present");
		// to verify button label
		Assert.assertEquals(getAttribute(sr.btnlbl_Approve, "label"), "Approve");

		// to verify button decline is present
		Assert.assertTrue(isElementPresent(sr.btn_decline), "Button Decline not present");
		// to verify button label
		Assert.assertEquals(getAttribute(sr.btn_decline, "label"), "Decline");
		// to verify search box is present
		Assert.assertTrue(isElementPresent(sr.searchbox), "searchbox not present");
		waitThread(2000);
		// to verify search box placeholder
		Assert.assertEquals(getAttribute(sr.searchbox_lbl, "placeholder"), "Search Name/Email");

	}

	/*
	 * To check the grid heading labels on the student request for enrollment
	 * page
	 * To check the grid heading labels  on the Pending Requests to join the course page
	 */
	@Test(priority = 5)
	public void TCSPR060405() {
		waitThread(1000);
		// To verify grid labels
		Assert.assertEquals(getText(sr.gridlabel_1), "Sl No");
		Assert.assertEquals(getText(sr.gridlabel_2), "Date Requested");
		Assert.assertEquals(getText(sr.gridlabel_3), "Student ID");
		Assert.assertEquals(getText(sr.gridlabel_4), "First Name");
		Assert.assertEquals(getText(sr.gridlabel_5), "Last Name");
		Assert.assertEquals(getText(sr.gridlabel_6), "Email id");
		//Assert.assertEquals(getText(sr.gridlabel_7), "Status");
		//Assert.assertEquals(getText(sr.gridlabel_8), "Approved/ Declined On");

		//*Assert the Pending Requests to join the course Radio button is checked
		Assert.assertTrue(isEnabled(sr.pending_request_radiobtn),
				"Pending request radio button is not Enabled");
		
		// *Assert the grid text:No Request(s) Found.
		Assert.assertEquals(getText(sr.grid_txt1), "No Request(s) Found.");

	}
	// * To check the grid heading labels  on the Requests to join the course that were processed page
	@Test(priority = 6)
	public void TCSPR060406() 
	{
		waitThread(3000);
		click(sr.req_radiobtn);
		waitThread(3000);
		Assert.assertEquals(getText(sr.serial_no2), "Sl No");
		waitThread(2000);
		Assert.assertEquals(getText(sr.date_requested2), "Date Requested");
		waitThread(2000);
		Assert.assertEquals(getText(sr.sudid_3), "Student ID");
		waitThread(2000);
		Assert.assertEquals(getText(sr.first_name2), "First Name");
		Assert.assertEquals(getText(sr.last_name2), "Last Name");
		Assert.assertEquals(getText(sr.email_id2), "Email ID");
		Assert.assertEquals(getText(sr.status_2), "Status");
		Assert.assertEquals(getText(sr.approve_decline_on), "Approved/Declined On");
		
		Assert.assertEquals(getText(sr.course_label), "Course:");
		Assert.assertEquals(getText(sr.approve_label), "Approved");
		Assert.assertEquals(getText(sr.decline_label), "Declined");
	}

	/*
	 * To check the back button functionality on the student request for
	 * enrollment page
		 */
	@Test(priority = 7)
	public void TCSPR060407() {

		// to verify weather back button present
		Assert.assertTrue(isElementPresent(sr.btn_back), "Back Button not present");
		// to verify button label
		Assert.assertEquals(getText(sr.Btnlabel_back), "Back to Course Listings");

		// click back button
		click(sr.btn_back);
		// verify page title courses
		Assert.assertEquals(getText(sr.heading_lbl4), "Courses");

	}

	/*
	 * To perform delete Account functionality
	 */
	@Test(priority = 8)
	public void TCSPR060408() {

		waitThread(1000);
		// To perform delete account functionality
		sp.DeleteAccount();
		lg.login(Email, "Abc@123");
		waitFor(sp.toaster);
		Assert.assertEquals(getText(sp.toaster), "Enter a valid email address and password");
	}
}
