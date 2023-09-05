package ChangePassword.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;

import ChangePassword.Pages.ChangePasswordPage;
import ForgotPassword.Pages.ForgotPasswordPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;

public class ChangePasswordTest extends basePage {

	ChangePasswordPage cp = new ChangePasswordPage();
	LoginPage lg = new LoginPage();
	ForgotPasswordPage fp = new ForgotPasswordPage();
	SignUpTest st = new SignUpTest();
	SignUpPage sp = new SignUpPage();
	CommonMethods cm=new CommonMethods();
	Databaseconnection dc = new Databaseconnection();
	public String oldpassword;
	public String newpassword;
	public String Email;
	public String otp;

	/*
	 * To perform Sign Up functionality
	 */
	@Test(priority = 1)
	public void TCSPR050001() {

		// To click on I am A teacher button
		click(sp.btn_1);

		// click first name
		click(sp.txtbxFirstN);

		// type first name
		type(sp.txtbxFirstN, "Test");

		// click last name
		click(sp.txtbxLastN);

		// type last name
		type(sp.txtbxLastN, "Teacher");

		// click email
		click(sp.txtbxEmail);

		Email = "test" + generateRandomNumber().trim() + "@gmail.com";

		// type email
		type(sp.txtbxEmail, Email);

		// click password
		click(sp.txtbxPass);

		oldpassword = generateRandomData();

		// type password
		type(sp.txtbxPass, oldpassword);

		// click password
		click(sp.txtbxPassconf);

		// type password
		type(sp.txtbxPassconf, oldpassword);

		// click on privacy policy check box
		click(sp.chkbx_1);

		// click signup button
		click(sp.btn_signup);

		waitThread(2000);

		waitFor(sp.toaster);

		// validation message-Please Check your Email to enter Verification Code
		Assert.assertEquals(getText(sp.toaster), "Please check your email to enter the Verification Code");
		waitThread(3000);

	}

	/*
	 * To fetch OTP
	 */
	@Test(priority = 2)
	public void OTPFetch() throws SQLException

	{
		// verify heading-Email Verification Code
		Assert.assertEquals(getText(sp.HeadingTitle_2), "Email Verification Code");

		// To verify Labels on the Enter verification code page
		Assert.assertEquals(getText(sp.label1), "We've sent you a verification code to this Email address:\n" + Email
				+ "\n" + "Please enter the code here to verify your account");

		// catch otp from sending resource

		otp = dc.sprotp(Email);
		// Type OTP
		driver.findElement(By.xpath(sp.otpbx_1)).sendKeys(otp);
		sp.selecttrialplan();
		waitFor(lg.pagetitle3);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	/*
	 * To check the Change Password link present in the navigation dropdown
	 */
	@Test(priority = 3)
	public void TCSPR050002() {
		// click on navigation menu
		click(lg.Nav_dd1);

		// Button Change Password
		Assert.assertTrue(isElementPresent(cp.btn_changepassword), "Change Password button not present");

		// Click Change Password
		click(cp.btn_changepassword);
		waitThread(2000);

		// verify heading
		Assert.assertEquals(getText(cp.heading_1), "Change Password");

	}

	/*
	 * To check the labels, textboxes,buttons on the change password page
	 */
	@Test(priority = 4)
	public void TCSPR050003() {

		// Verify the following
		Assert.assertTrue(isElementPresent(cp.txtbx_currentpass), "Current Password Textbox not  present");
		Assert.assertTrue(isElementPresent(cp.txtbx_newpass), "New Password Textbox not present");
		Assert.assertTrue(isElementPresent(cp.txtbx_confirmpass), "Confirm Password Textbox not present");
		Assert.assertTrue(isElementPresent(cp.btn_Apply), "Apply button not present");

		// Verify following placeholders
		Assert.assertEquals(getAttribute(cp.placeholder1, "placeholder"),"Current Password");
		Assert.assertEquals(getAttribute(cp.placeholder2, "placeholder"), "New Password");
		Assert.assertEquals(getAttribute(cp.placeholder3, "placeholder"),"Confirm New Password");
		Assert.assertEquals(getText(cp.btnlbl_Apply),"Apply");

		// To verify the login button is disabled
		Assert.assertTrue(isEnabled(cp.btn_Apply), "Apply button is Enabled");

	}

	/*
	 * To check the required field validation messages
	 */
	@Test(priority = 5)
	public void TCSPR050004() {

		// Click on the textboxes
		click(cp.txtbx_currentpass);
		click(cp.txtbx_newpass);
		click(cp.txtbx_confirmpass);
		click(cp.txtbx_currentpass);

		// verify validation messages
		Assert.assertEquals(getText(cp.valmsg_1), "Current Password is required");
		Assert.assertEquals(getText(cp.valmsg_2), "New Password is required");
		Assert.assertEquals(getText(cp.valmsg_3), "Confirm Password is required");

	}
	/*
	 * To check with invalid data
	 */

	@Test(priority = 6)
	public void TCSPR050005() {
		// Type new password text box
		type(cp.txtbx_newpass, "ff");

		// click on current password text box
		click(cp.txtbx_currentpass);
		waitFor(cp.valmsg_6);

		// verify validation message
		Assert.assertEquals(getText(cp.valmsg_6), "New Password must be at least 5 characters");

		// type new password
		type(cp.txtbx_newpass, "Is simply dummy text of the printing and typesetting industry");

		// click on current password text box
		click(cp.txtbx_currentpass);
		waitFor(cp.valmsg_6);

		// verify validation message
		Assert.assertEquals(getText(cp.valmsg_6), "New Password must be maximum 25 characters");

	}
	/*
	 * To check the validation messages on the current password page
	 */

	@Test(priority = 7)
	public void TCSPR050006() {

		// type current password
		type(cp.txtbx_currentpass, "1234567");

		// type new password
		type(cp.txtbx_newpass, "1234567");

		// verify validation message
		Assert.assertEquals(getText(cp.valmsg_4), "New password cannot be the same as the current password");

		// type confirm password
		type(cp.txtbx_confirmpass, "Abc@123");

		// verify validation message
		Assert.assertEquals(getText(cp.valmsg_5), "Passwords must match");

		// To verify the login button is disabled
		Assert.assertTrue(isEnabled(cp.btn_Apply), "Apply button is Enabled");

	}

	/*
	 * To check with incorrect current password
	 */
	@Test(priority = 8)
	public void TCSPR050007() {

		// type current password
		type(cp.txtbx_currentpass, "a1234556");

		// type new password
		type(cp.txtbx_newpass, "Abc@123");

		// type confirm password
		type(cp.txtbx_confirmpass, "Abc@123");

		// click Apply button
		click(cp.btn_Apply);

		waitFor(cp.toaster);
		// verify validation message
		Assert.assertEquals(getText(cp.toaster), "Incorrect current password.");
		waitThread(5000);

	}

	/*
	 * To check the change password functionality on the page
	 */
	@Test(priority = 9)
	public void TCSPR050008() {

		newpassword = generateRandomNumber();

		// type current password
		type(cp.txtbx_currentpass, oldpassword);

		// type new password
		type(cp.txtbx_newpass, newpassword);

		// type confirm password
		type(cp.txtbx_confirmpass, newpassword);

		// click Apply button
		click(cp.btn_Apply);

		waitFor(cp.toaster);
		// verify validation message
		Assert.assertEquals(getText(cp.toaster), "Password reset successfully");
		waitThread(2000);

	}
	/*
	 * To check the logout functionality on the page
	 */

	@Test(priority = 10)
	public void TCSPR050009() {

		// Click on navigation menu drop down
		click(lg.Nav_dd1);

		// Click logout button
		click(lg.Link_logout);

		waitThread(1000);
		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform login functionality with Old password
	 */
	@Test(priority = 11)
	public void TCSPR050010() {

		// To verify with invalid data
		lg.login1(Email, oldpassword);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");
		waitThread(1000);

	}

	/*
	 * To perform login functionality with newly created password
	 */
	@Test(priority = 12)
	public void TCSPR050011() {

		waitThread(2000);
		// To verify with valid
		lg.login1(Email, newpassword);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");
		waitThread(2000);

	}

	// To Perform Delete Account functionality
	@AfterTest
	public void TCSPR050012_Delete_Account() {

		// Delete account
		cm.DeleteAccount();


	}

}
