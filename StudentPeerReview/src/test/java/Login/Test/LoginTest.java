package Login.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Generalmethods.Databaseconnection;

import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;

public class LoginTest extends basePage {

	LoginPage lg = new LoginPage();
	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	Databaseconnection dc = new Databaseconnection();
	public String Email;
	public String otplogin;
	public String Teacherfirstname;
	public String Teacherlastname;
	public String Teachername;
	public String Password;

	/*
	 * To check the login Button present in the page
	 */
	@Test(priority = 1)
	public void TCSPR030001() {

		// To verify the login button
		Assert.assertTrue(isElementPresent(lg.LoginBtn_1), "Login button not present");

		// Click on login button
		click(lg.LoginBtn_1);

	}

	/*
	 * To check the labels textfields in the Login Page
	 */
	@Test(priority = 2)
	public void TCSPR030002() {

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// Placeholder-Email
		Assert.assertEquals(getAttribute(lg.Email_txt, "placeholder"), "Email");

		// Placeholder-Password
		Assert.assertEquals(getAttribute(lg.Pass_txt, "placeholder"), "Password");

		// Text box-Email
		Assert.assertTrue(isElementPresent(lg.txtbx_Email), "Email Textbox not present");

		// Tex tbox-Password
		Assert.assertTrue(isElementPresent(lg.txtbx_Password), "Password Textbox not present");

		// Login Button
		Assert.assertTrue(isElementPresent(lg.LoginBtn_2), "Login Button not visible");

	}

	/*
	 * To check the Text box field Empty validations in login page
	 */
	@Test(priority = 3)
	public void TCSPR030003() {

		// To verify the login button is disabled
		Assert.assertTrue(isEnabled(lg.LoginBtn_2), "Login button is Disabled");

	}

	/*
	 * To check the required field validation messages in Login page
	 */
	@Test(priority = 4)
	public void TCSPR030004() {

		// Click Email Text box
		click(lg.Email_txt);

		// Click on password Text box
		click(lg.Pass_txt);

		// Click on Email Text box
		click(lg.Email_txt);

		// Email validation message
		Assert.assertEquals(getText(lg.validationmsg1), "Email is required");

		// Password validation message
		Assert.assertEquals(getText(lg.validationmsg2), "Password is required");

	}

	/*
	 * To check the login functionality with invalid credentials
	 */
	@Test(priority = 5)
	public void TCSPR030005() {

		waitThread(5000);
		// To verify with invalid data
		lg.login1("grbvrfg", "gbvgrf");

		waitFor(lg.validationmsg3);
		// verify toaster text
		Assert.assertEquals(getText(lg.validationmsg3), "Enter a valid email address and password");

	}

	/*
	 * To check login with valid Email and password
	 */
	@Test(priority = 6)
	public void TCSPR030006() {

		// To verify with invalid data
		lg.login1("test@gmail.com", "12345");

		// click login button
		click(lg.LoginBtn_2);

		waitFor(lg.validationmsg3);
		// verify toaster text
		Assert.assertEquals(getText(lg.validationmsg3), "Enter a valid email address and password");

	}

	/*
	 * To check login with valid Email and password
	 */
	@Test(priority = 7)
	public void TCSPR030007() throws SQLException {

		// perform Sign up functionality

		// Click onDon't have an account? link
		click(lg.link2);

		// To click on I am A teacher button
		click(sp.btn_1);

		Teacherfirstname = "Test";
		Teacherlastname = "Teacher";
		Teachername = Teacherfirstname + " " + Teacherlastname;
		Password = "Abc@123";

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
		// Teachername="Test"

		// type email
		type(sp.txtbxEmail, Email);

		// click password
		click(sp.txtbxPass);

		// type password
		type(sp.txtbxPass, Password);

		// click password
		click(sp.txtbxPassconf);

		// type password
		type(sp.txtbxPassconf, Password);

		waitThread(5000);
		// waitFor(sp.btn_signup);
		// click signup button
		click(sp.btn_signup);

		waitFor(sp.toaster);

		// validation message-Please Agree to the Terms & Conditions and Privacy
		Assert.assertEquals(getText(sp.toaster),
				"Please agree to the Terms & Conditions and the Privacy Policy before signing up");

		waitThread(5000);
		// click on privacy policy check box
		click(sp.chkbx_1);

		// verify the checkbox is checked
		Assert.assertTrue(isElementPresent(sp.chkbx_sel), "The privacy policy checkbox is not selected");

		// click signup button
		click(sp.btn_signup);

		waitFor(sp.toaster);

		// validation message-Please Check your Email to enter Verification Code
		Assert.assertEquals(getText(sp.toaster), "Please check your email to enter the Verification Code");
		waitThread(3000);

		// verify heading-Email Verification Code
		Assert.assertEquals(getText(sp.HeadingTitle_2), "Email Verification Code");

		// To verify Labels on the Enter verification code page
		Assert.assertEquals(getText(sp.label1), "We've sent you a verification code to this Email address:\n" + Email
				+ "\n" + "Please enter the code here to verify your account");

		// catch otp from sending resource

		otplogin = dc.sprotp(Email);

		// Type OTP
		driver.findElement(By.xpath(sp.otpbx_1)).sendKeys(otplogin);
		waitThread(2000);
		waitFor(sp.Selecttrialplan);
		//click on select trial plan button
		click(sp.Selecttrialplan);
		waitThread(1000);
		waitFor(lg.pagetitle3);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// Click on navigation menu drop down
		click(lg.Nav_dd);

		// Click logout button
		click(lg.Link_logout);

		waitThread(5000);
		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		// Perform login functionality
		lg.login1(Email, "Abc@123");

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	/*
	 * To check on the delete account functionality and login using deleted
	 * account credentials
	 */
	@Test(priority = 8)
	public void TCSPR030008() {

		lg.DeleteAccount();

		// To login with deleted account credentials
		lg.login(Email, "Abc@123");
		waitFor(lg.validationmsg3);
		// verify toaster text
		Assert.assertEquals(getText(lg.validationmsg3), "Enter a valid email address and password");

		waitThread(5000);
		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check the "Don't have an account" functionality in the Login page
	 */
	@Test(priority = 9)
	public void TCSPR030009() {

		// verify link Don't have an account?
		Assert.assertEquals(getText(lg.link2text), "Don't have an account?");

		waitFor(lg.link2);

		// Click onDon't have an account? link
		click(lg.link2);

		// To verify the login button
		Assert.assertTrue(isElementPresent(lg.LoginBtn_1), "Login button not present");

		waitThread(3000);
		// Click on login button
		click(lg.LoginBtn_1);

	}

	/*
	 * To verify the Forgot password functionality
	 */
	@Test(priority = 10)
	public void TCSPR030010() {

		// verify link Forgot password?
		Assert.assertEquals(getText(lg.link1text), "Forgot password?");

		// click on forgot password link
		click(lg.link1);

		// Reset password heading
		Assert.assertEquals(getText(lg.pagetitle2), "Reset Password");

	}

}
