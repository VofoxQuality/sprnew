package ForgotPassword.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Course.Pages.CourseRosterPage;
import ForgotPassword.Pages.ForgotPasswordPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;

public class ForgotPasswordTest extends basePage {

	LoginPage lg = new LoginPage();
	ForgotPasswordPage fp = new ForgotPasswordPage();
	Databaseconnection dc = new Databaseconnection();
	EncryptedText et = new EncryptedText();
	SignUpTest st = new SignUpTest();
	SignUpPage sp = new SignUpPage();
	CommonMethods cm=new CommonMethods();
	CourseRosterPage cr = new CourseRosterPage();
	SoftAssert softAssert = new SoftAssert();
	public String Teacherfirstname;
	public String Teacherlastname;
	public String Teachername;
	public String Passwordold;
	public String Passwordnew;
	public String Email;
	public String otpnew;

	/*
	 * To check the login Button present in the page
	 */
	@Test(priority = 1)
	public void TCSPR040001() {

		// Click on login button
		click(lg.LoginBtn_1);

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check the forgot password link present in the page
	 */
	@Test(priority = 2)
	public void TCSPR040002() {

		// verify link Forgot password?
		Assert.assertEquals(getText(lg.link1text), "Forgot password?");

		// click on forgot password link
		click(lg.link1);

		// Reset password heading
		Assert.assertEquals(getText(lg.pagetitle2), "Reset Password");

	}

	/*
	 * To Assert the labels in the forgot password page
	 */
	@Test(priority = 3)
	public void TCSPR040003() {

		// verify email textbox
		Assert.assertTrue(isElementPresent(fp.emailtxtbx), "Email Textbox not visible");

		// Placeholder-Enter Registered Email
		Assert.assertEquals(getAttribute(fp.txtbxplaceholder, "placeholder"), "Enter Registered Email");

		// button-Send Reset Link
		Assert.assertTrue(isElementPresent(fp.btn_Reset), "Send Reset Link button not visible");

		// button label--Send Reset Link
		Assert.assertEquals(getText(fp.btnlbl_Reset), "Send Reset Link");

	}

	/*
	 * To check the validations in the forgot password page Forgot password Page
	 */
	@Test(priority = 4)
	public void TCSPR040004() {

		// click on email textbox
		click(fp.emailtxtbx);

		//click on button
		click(fp.btn_Reset);

		// verify validation message-Email is required
		Assert.assertEquals(getText(fp.valmsg_1), "Email is required");

		// verify the Send Reset Link button disabled
		Assert.assertTrue(isEnabled(fp.btn_Reset), "Send Reset Link  button is not  Disabled");
	}

	/*
	 * To check with invalid email id in the email text box Forgot password Page
	 */
	@Test(priority = 5)
	public void TCSPR040005() {

		// Type invalid Email
		type(fp.emailtxtbx, "aa@");

		// verify validation message-Email must be in a correct format
		Assert.assertEquals(getText(fp.valmsg_2), "Email must be in a correct format");

	}

	/*
	 * To check with unregistered Email id in Forgot password Page
	 */
	@Test(priority = 6)
	public void TCSPR040006() {

		// Type unregistered
		type(fp.emailtxtbx, "aaaa@gmail.com");

		// click on button
		click(fp.btn_Reset);
		waitFor(fp.toaster);

		// verify toaster message-This Email address was not found in the
		// Student Peer Review system
		softAssert.assertEquals(getText(fp.toaster),
				"This Email address was not found in the Student Peer Review system.");

		waitFor(fp.Backtohome);

		// Click on back to home link
		click(fp.Backtohome);

		/*
		 * To perform Sign Up functionality
		 */

		Teacherfirstname = "Test";
		Teacherlastname = "Teacher";
		Teachername = Teacherfirstname + " " + Teacherlastname;
		Passwordold = generateRandomNumber();

		// To click on I am A teacher button
		click(sp.btn_1);

		// click first name
		click(sp.txtbxFirstN);

		// type first name
		type(sp.txtbxFirstN, Teacherfirstname);

		Teacherfirstname = getValue(sp.txtbxFirstN);

		// click last name
		click(sp.txtbxLastN);

		// type last name
		type(sp.txtbxLastN, Teacherlastname);

		// click email
		click(sp.txtbxEmail);

		Email = "test" + generateRandomNumber().trim() + "@gmail.com";

		// type email
		type(sp.txtbxEmail, Email);

		// click password
		click(sp.txtbxPass);

		// type password
		type(sp.txtbxPass, Passwordold);

		// click password
		click(sp.txtbxPassconf);

		// type password
		type(sp.txtbxPassconf, Passwordold);

		waitThread(5000);
		// click on privacy policy check box
		click(sp.chkbx_1);

		// click signup button
		click(sp.btn_signup);

		waitFor(sp.toaster);

		// validation message-Please Check your Email to enter Verification Code
		Assert.assertEquals(getText(sp.toaster), "Please check your email to enter the Verification Code");
		waitThread(3000);

		// verify heading-Email Verification Code
		Assert.assertEquals(getText(sp.HeadingTitle_2), "Email Verification Code");

	}

	/*
	 * To check with valid Registered Email id on the forgot password page
	 */
	@Test(priority = 7)
	public void TCSPR040007() throws SQLException {

		// To verify Labels on the Enter verification code page
		softAssert.assertEquals(getText(sp.label1), "We've sent you a verification code to this Email address:\n"
				+ Email + "\n" + "Please enter the code here to verify your account");

		// catch otp from sending resource

		otpnew = dc.sprotp(Email);

		// Type OTP
		driver.findElement(By.xpath(sp.otpbx_1)).sendKeys(otpnew);
		waitThread(2000);
		waitFor(sp.Selecttrialplan);
		//click on select trial plan button
		click(sp.Selecttrialplan);
		waitThread(1000);
		waitFor(lg.pagetitle3);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		/*
		 * Logout Functionality
		 */
		cm.Logout();

		waitThread(5000);

		// verify link Forgot password?
		Assert.assertEquals(getText(lg.link1text), "Forgot password?");

		// click on forgot password link
		click(lg.link1);

		// Reset password heading
		Assert.assertEquals(getText(lg.pagetitle2), "Reset Password");

		click(fp.emailtxtbx);
		// Type unregistered
		type(fp.emailtxtbx, Email);

		// click on button
		click(fp.btn_Reset);

		waitThread(1000);

		waitFor(fp.toaster);
		// verify toaster message-Reset Link has been sent to your Email
		Assert.assertEquals(getText(fp.toaster), "An email has been sent. Please check your inbox to reset your password");

		waitThread(1000);

	}

	/*
	 * To check the forgot password functionality with old reset password link
	 */
	@Test(priority = 8)
	public void TCSPR040008() throws SQLException {

		String oldmanageID = dc.ManagePwId(Email);
		String oldencText = et.EncryptCode(oldmanageID);

		// Type unregistered
		type(fp.emailtxtbx, Email);

		// click on button
		click(fp.btn_Reset);

		waitFor(fp.toaster);

		// verify toaster message-Reset Link has been sent to your Email
		softAssert.assertEquals(getText(fp.toaster), "Reset Link has been sent to your Email");
		waitThread(2000);

		// Load the Previous Reset Password Link
		driver.get(prop.getProperty("UrlResetpswd") + oldencText);

		waitFor(fp.toaster);
		// Verify toaster-Link expired.
		Assert.assertEquals(getText(fp.toaster), "Link expired.");

	}

	/*
	 * To check the forgot password functionality with latest reset password
	 * link
	 */
	@Test(priority = 9)
	public void TCSPR040009() throws SQLException {

		// verify reset link
		String Emaill = Email;
		String newmanageID = dc.ManagePwId(Emaill);
		String newencText = et.EncryptCode(newmanageID);
		waitThread(4000);

		// To load Latest New Reset Password Link
		driver.get(prop.getProperty("UrlResetpswd") + newencText);
		//driver.get("http://192.168.7.108:8042/SPRClient/generate-new-password/"+newencText);

		waitFor(fp.toaster);
		// verify toaster message-Please reset your password!
		softAssert.assertEquals(getText(fp.toaster), "Please reset your password!");

	}

	/*
	 * To check the heading
	 */
	@Test(priority = 10)
	public void TCSPR040010() {

		// verify heading-Generate New Password
		Assert.assertEquals(getText(fp.heading_1), "Generate New Password for Student Peer Review");

	}

	/*
	 * To check the Generate New Password functionality To check the
	 * labels,buttons,textboxes
	 */
	@Test(priority = 11)
	public void TCSPR040011() {

		// Verify Textboxes
		Assert.assertTrue(isElementPresent(fp.newpass_txbx), "New Password Text box not present");
		Assert.assertEquals(getAttribute(fp.newpass_txbx, "placeholder"), "New Password");
		Assert.assertTrue(isElementPresent(fp.confpass_txbx), "Confirm Password Text box not  present");
		Assert.assertEquals(getAttribute(fp.confpass_txbx, "placeholder"), "Confirm Password");

		// Apply Button-
		Assert.assertTrue(isElementPresent(fp.btn_Apply), "Apply Button not present");
		Assert.assertEquals(getText(fp.btnlbl_Apply), "Apply");

	}

	/*
	 * To check the required field and upper-lower limit validation messages
	 * Generate new password page
	 */
	@Test(priority = 12)
	public void TCSPR040012() {

		// Click new password textbox
		click(fp.newpass_txbx);

		// Click confirm password
		click(fp.confpass_txbx);

		// Click new password textbox
		click(fp.newpass_txbx);

		// validation message-New Password is required
		Assert.assertEquals(getText(fp.valmsg_pass), "New Password is required");

		// validation message-Confirm Password is required
		Assert.assertEquals(getText(fp.valmsg_confpass), "Confirm Password is required");

		// verify the Send Reset Link button disabled
		Assert.assertFalse(isEnabled(fp.btn_Apply), "Apply button is not  Disabled");

		// To verify validation message-Lower limit
		type(fp.newpass_txbx, "kkk");
		Assert.assertEquals(getText(fp.valmsg_pass), "Password must be at least 5 characters");

		// To verify validation messages-Upper Limit
		type(fp.newpass_txbx, "123456789123456789123456789123456789");
		Assert.assertEquals(getText(fp.valmsg_pass), "Password must be maximum 25 characters");

	}

	/*
	 * To check with different new password and confirm password
	 */
	@Test(priority = 13)
	public void TCSPR040013() {

		// type new password
		type(fp.newpass_txbx, "Abc@1");

		// type confirm password
		type(fp.confpass_txbx, "1234");

		// validation message-Password mismatch
		Assert.assertEquals(getText(fp.valmsg_confpass), "Passwords must match");

	}

	/*
	 * To check with previously used password
	 */
	@Test(priority = 14)
	public void TCSPR040014() {

		// type old login password-new password textbox
		type(fp.newpass_txbx, Passwordold);

		// type old login password-confirm password textbox
		type(fp.confpass_txbx, Passwordold);

		// click on Apply button
		click(fp.btn_Apply);

		waitFor(fp.valmsg_6);

		// validation message-This password already used . Please try another.
		Assert.assertEquals(getText(fp.valmsg_6), "Please enter a password that you haven’t used before.");

	}

	/*
	 * To check the forgot password functionality on the generate new passwod
	 * page
	 */
	@Test(priority = 15)
	public void TCSPR040015() {

		Passwordnew = generateRandomNumber();

		// type new password
		type(fp.newpass_txbx, Passwordnew);

		// type confirm password
		type(fp.confpass_txbx, Passwordnew);

		// click on Apply button
		click(fp.btn_Apply);

		waitFor(fp.toaster);

		// validation message-Successfully reset your password!
		Assert.assertEquals(getText(fp.toaster), "Successfully reset your password!");

	}

	/*
	 * To check the back to login functionality on the forgot password page
	 */
	@Test(priority = 16)
	public void TCSPR040016() {

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform login functionality with Old password
	 */
	@Test(priority = 17)
	public void TCSPR040017() {

		// To verify with invalid data
		lg.login1(Email, Passwordold);

		waitFor(lg.toaster);

		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform login functionality with newly created password
	 */
	@Test(priority = 18)
	public void TCSPR040018() {

		// To verify with valid
		lg.login1(Email, Passwordnew);
		waitThread(2000);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	/*
	 * To perform delete account functionality and login using deleted account
	 * credetials
	 */
	@Test(priority = 19)
	public void TCSPR040019() {

		// To perform delete account functionality
		cr.DeleteAccount();


		// To login with deleted account credentials
		lg.login(Email, Passwordnew);

		waitFor(lg.validationmsg3);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");
	}

}