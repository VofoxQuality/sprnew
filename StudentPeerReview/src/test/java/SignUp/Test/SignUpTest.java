package SignUp.Test;

import java.sql.SQLException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.Databaseconnection;

import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;

public class SignUpTest extends basePage {

	SignUpPage sp = new SignUpPage();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	public String otp;
	public String oldotp;
	public String newotp;
	public String Email;
	public String NewEmail;
	public String Test;
	public String Teacherfirstname;
	public String Teacherlastname;
	public String Teachername;
	public String Password;

	/*
	 * To load the Student Peer Review Landing Page. To check the I am a Teacher
	 * Button present in the page
	 */
	@Test(priority = 1)
	public void TCSPR020001() {

		// To verify the I am a teacher button
		Assert.assertTrue(isElementPresent(sp.btn_1), "I am a Teacher button not present");

		// Button Label-I'm a Teacher
		Assert.assertEquals(getText(sp.btn_1lbl), "I'm a Teacher");

		// To click on I am A teacher button
		click(sp.btn_1);

		// To verify the heading signup
		Assert.assertEquals(getText(sp.HeadingTitle_1), "Sign Up");

	}

	/*
	 * To check the labels in the Teacher Sign up page
	 */
	@Test(priority = 2)
	public void TCSPR020002() {

		// Text-As individual Teacher
		Assert.assertEquals(getText(sp.txt_1), "as Individual Teacher");

		// Text-Terms and conditions
		Assert.assertEquals(getText(sp.txt_2), "I Agree to the Terms & Conditions and Privacy Policy");

		// checkbox-terms and conditions
		Assert.assertTrue(isElementPresent(sp.chkbx_1), "Checkbox not present");

	}

	/*
	 * To check the labels in the Teacher Sign up page
	 */
	@Test(priority = 3)
	public void TCSPR020003() {

		// To verify placeholders
		Assert.assertEquals(getAttribute(sp.txtbxFirstN, "placeholder"), "First Name");
		Assert.assertEquals(getAttribute(sp.txtbxLastN, "placeholder"), "Last Name");
		Assert.assertEquals(getAttribute(sp.txtbxEmail, "placeholder"), "Email");
		Assert.assertEquals(getAttribute(sp.txtbxPass, "placeholder"), "Password");
		Assert.assertEquals(getAttribute(sp.txtbxPassconf, "placeholder"), "Confirm Password");
		Assert.assertEquals(getText(sp.Signup_lbl), "Sign Up");
		Assert.assertEquals(getText(sp.alreadyact_lbl), "Already have an account?");
		Assert.assertEquals(getText(sp.privacypolicy), "Terms & Conditions");
		Assert.assertEquals(getText(sp.terms), "Privacy Policy");

		// To verify Textboxes
		Assert.assertTrue(isElementPresent(sp.txtbxFirstN), "First Name Textbox not present");
		Assert.assertTrue(isElementPresent(sp.txtbxLastN), "Last Name Textbox not present");
		Assert.assertTrue(isElementPresent(sp.txtbxEmail), "Email Textbox not present");
		Assert.assertTrue(isElementPresent(sp.txtbxPassconf), "Confirm Password Textbox not present");
		Assert.assertTrue(isElementPresent(sp.txtbxPass), " Password Textbox not present");

	}

	/*
	 * To check the required field validation messages
	 */
	@Test(priority = 4)
	public void TCSPR020004() {

		// Click on Sign up button
		click(sp.btn_signup);

		// To verify the validation messages
		Assert.assertEquals(getText(sp.valmsg_1), "First Name is required");
		Assert.assertEquals(getText(sp.valmsg_2), "Last Name is required");
		Assert.assertEquals(getText(sp.valmsg_3), "Email is required");
		Assert.assertEquals(getText(sp.valmsg_4), "Password is required");
		Assert.assertEquals(getText(sp.valmsg_5), "Confirm Password is required");

		TCSPR020005();
	}

	/*
	 * To check the Sign Up functionality To fill all the parameters and Assert
	 * the headings
	 */
	@Test(priority = 5)
	public String TCSPR020005() {

		SoftAssert softAssert1 = new SoftAssert();

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

		waitThread(6000);
		// click signup button
		click(sp.btn_signup);
		waitFor(sp.toaster);

		// validation message-Please Agree to the Terms & Conditions and Privacy
		softAssert1.assertEquals(getText(sp.toaster),
				"Please agree to the Terms & Conditions and the Privacy Policy before signing up", "Assertion  failed");

		waitThread(5000);
		// click on privacy policy check box
		click(sp.chkbx_1);

		// verify the checkbox is checked
		Assert.assertTrue(isElementPresent(sp.chkbx_sel), "The privacy policy checkbox is not selected.");

		// click signup button
		click(sp.btn_signup);

		waitFor(sp.toaster);
		// validation message-Please Check your Email to enter Verification Code
		softAssert1.assertEquals(getText(sp.toaster), "Please check your email to enter the Verification Code",
				"Assersion failed");
		waitThread(3000);

		// verify heading-Email Verification Code
		softAssert1.assertEquals(getText(sp.HeadingTitle_2), "Email Verification Code");
		softAssert1.assertAll();
		return Email;

	}

	/*
	 * To check the email verification functionality
	 */
	@Test(priority = 6)
	public void TCSPR020006() throws SQLException {
		SoftAssert softAssert2 = new SoftAssert();

		// To verify OTP boxes
		Assert.assertTrue(isElementPresent(sp.otpbx_1), "OTP box 1 present");
		Assert.assertTrue(isElementPresent(sp.otpbx_2), "OTP box 2 present");
		Assert.assertTrue(isElementPresent(sp.otpbx_3), "OTP box 3 present");
		Assert.assertTrue(isElementPresent(sp.otpbx_4), "OTP box 4 present");

		// To verify Labels on the Enter verification code page
		softAssert2.assertEquals(getText(sp.label1), "We've sent you a verification code to this Email address:\n"
				+ Email + "\n" + "Please enter the code here to verify your account", "Assertion  failed");

		// catch otp from sending resource

		otp = dc.sprotp(Email);

		// Type OTP
		driver.findElement(By.xpath(sp.otpbx_1)).sendKeys(otp);

		waitThread(2000);
		sp.selecttrialplan();

		waitFor(lg.pagetitle3);
		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");
		softAssert2.assertAll();

	}

	/*
	 * To perform logout functionalty in the student peer review page
	 */
	@Test(priority = 7)
	public void TCSPR020007() {

		// click on navigation menu drop down
		click(lg.Nav_dd);

		// Button logout
		Assert.assertTrue(isElementPresent(lg.Link_logout1), "Logout button not present");

		// click logout button
		click(lg.Link_logout1);

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To Load the sign Up page,Click on the Don't have an account? link
	 */
	@Test(priority = 8)
	public void TCSPR020008() {
		// click onDon't have an account? link
		click(lg.link2);

		// To click on I am A teacher button
		click(sp.btn_1);

		// Text-As individual Teacher
		Assert.assertEquals(getText(sp.txt_1), "as Individual Teacher");

	}

	/*
	 * To check the sign up with already registered Email ID
	 */
	@Test(priority = 9)
	public void TCSPR020009() {

		// type first name
		type(sp.txtbxFirstN, "Mary");

		// type last name
		type(sp.txtbxLastN, "S");

		// Type already registered email
		driver.findElement(By.xpath(sp.txtbxEmail)).sendKeys(Email);
		waitThread(1000);
		waitFor(sp.val_msg_2);
		// verify validation message
		//Assert.assertEquals(getText(sp.val_msg_2), "Email '" + Email + "'This email already exists");
		Assert.assertEquals(getText(sp.val_msg_2),  "This email already exists.");

		waitThread(5000);
		// Type passowrd
		driver.findElement(By.xpath(sp.txtbxPass)).sendKeys("Abc@123");
		driver.findElement(By.xpath(sp.txtbxPassconf)).sendKeys("Abc@123");

		// click on privacy policy check box
		click(sp.chkbx_1);

		// click signup button
		click(sp.btn_signup);

		// verify heading-Email Verification Code not visible
		Assert.assertFalse(isElementPresent(sp.HeadingTitle_2), "Email Verification Code heading present");

	}

	/*
	 * To perform login functionality and delete account
	 */
	@Test(priority = 10)
	public void TCSPR020010() {

		waitFor(sp.btn_AlreadyAccount);

		// Click on already have an account button
		click(sp.btn_AlreadyAccount);

		// Perform login
		lg.login1(Email, "Abc@123");

		// Account delete functionality
		sp.DeleteAccount();


	}

	/*
	 * To perform Don't have an account? functionality
	 */
	@Test(priority = 11)
	public void TCSPR020011() {
		
		// Click on login button
		click(lg.LoginBtn_1);
		waitThread(2000);
		// click onDon't have an account? link
		click(lg.link2);

		// To click on I am A teacher button
		click(sp.btn_1);

		// Text-As individual Teacher
		Assert.assertEquals(getText(sp.txt_1), "as Individual Teacher");

	}

	/*
	 * To check the validation messages for less than lower limit data
	 */
	@Test(priority = 12)
	public void TCSPR020012() {

		// type first name
		type(sp.txtbxFirstN, "f");

		click(sp.txtbxLastN);
		waitFor(sp.valmsg_1);

		// verify validation message
		Assert.assertEquals(getText(sp.valmsg_1), "First Name must be at least 2 letters");

		// Type invalid Email
		driver.findElement(By.xpath(sp.txtbxEmail)).sendKeys("ffff");

		waitFor(sp.valmsg_3);

		// verify validation message
		Assert.assertEquals(getText(sp.valmsg_3), "Email must be in the correct format");

		// Type password
		driver.findElement(By.xpath(sp.txtbxPass)).sendKeys("ff");

		waitFor(sp.valmsg_4);

		// verify validation message
		Assert.assertEquals(getText(sp.valmsg_4), "Password must be at least 5 characters");

		// Type confirm password
		driver.findElement(By.xpath(sp.txtbxPassconf)).sendKeys("ggg");

		// click on password textbox
		click(sp.txtbxPass);

		waitFor(sp.valmsg_5);

		// verify validation message
		Assert.assertEquals(getText(sp.valmsg_5), "Password mismatch");

	}

	/*
	 * To check the validation messages for greater than upper limit data
	 */
	@Test(priority = 13)
	public void TCSPR020013() {

		// type first name
		type(sp.txtbxFirstN, "Is simply dummy text of the printing and typesetting industry");

		// click lastname textbox
		click(sp.txtbxLastN);

		waitFor(sp.valmsg_1);

		// verify validation message
		Assert.assertEquals(getText(sp.valmsg_1), "First Name must be maximum 20 characters");

		// Type lastname
		type(sp.txtbxLastN, "Is simply dummy text of the printing and typesetting industry");

		// click on first name textbox
		click(sp.txtbxFirstN);
		waitFor(sp.valmsg_2);

		// verify validation message
		Assert.assertEquals(getText(sp.valmsg_2), "Last Name must be maximum 20 characters");

		// Type Email
		driver.findElement(By.xpath(sp.txtbxEmail))
				.sendKeys("Is simply dummy text of the printing and typesetting industry");
		waitFor(sp.valmsg_3);

		// verify validation message
		Assert.assertEquals(getText(sp.valmsg_3), "Email must be maximum 50 characters");

		// Type password
		driver.findElement(By.xpath(sp.txtbxPass))
				.sendKeys("Is simply dummy text of the printing and typesetting industry");
		waitFor(sp.valmsg_4);

		// verify validation message
		Assert.assertEquals(getText(sp.valmsg_4), "Password must be maximum 25 characters");

	}

	/*
	 * To check the Email visibled on th e Email verification code page
	 */
	@Test(priority = 14)
	public void TCSPR020014() {

		waitThread(3000);
		// type first name
		type(sp.txtbxFirstN, "Ashley");

		// type last name
		type(sp.txtbxLastN, "S");

		waitFor(sp.txtbxEmail);
		NewEmail = "newtest" + generateRandomNumber().trim() + "@gmail.com";
		// Type Email
		driver.findElement(By.xpath(sp.txtbxEmail)).clear();
		driver.findElement(By.xpath(sp.txtbxEmail)).sendKeys(NewEmail);

		waitThread(1000);
		// Type password
		driver.findElement(By.xpath(sp.txtbxPass)).clear();
		driver.findElement(By.xpath(sp.txtbxPass)).sendKeys("Abc@123");
		driver.findElement(By.xpath(sp.txtbxPassconf)).clear();
		driver.findElement(By.xpath(sp.txtbxPassconf)).sendKeys("Abc@123");

		// click on privacy policy check box
		click(sp.chkbx_1);

		// click signup button
		click(sp.btn_signup);

		// verify heading-Email Verification Code
		Assert.assertEquals(getText(sp.HeadingTitle_2), "Email Verification Code");

		// Verify the Email-on the email verification page
		Assert.assertEquals(getText(sp.emailvalue), NewEmail);

	}

	/*
	 * To check the Back To Home functionality
	 */
	@Test(priority = 15)
	public void TCSPR020015() {

		// Verify the Back to home -link
		Assert.assertEquals(getText(sp.btn_backtohome), "Back to Home");
		Assert.assertTrue(isElementPresent(sp.btn_backtohome), "Back to Home link not present");

		// click on back to home link
		click(sp.btn_backtohome);

		// To verify the I am a teacher button
		Assert.assertTrue(isElementPresent(sp.btn_1), "I am a Teacher button not present");

		// To click on I am A teacher button
		click(sp.btn_1);

		// Text-As individual Teacher
		Assert.assertEquals(getText(sp.txt_1), "as Individual Teacher");

	}

	/*
	 * To perform sign up functionality
	 */
	@Test(priority = 16)
	public void TCSPR020016() {

		waitThread(3000);
		// type first name
		type(sp.txtbxFirstN, "Ashley");

		// type last name
		type(sp.txtbxLastN, "S");

		waitFor(sp.txtbxEmail);

		NewEmail = "newtest" + generateRandomNumber().trim() + "@gmail.com";

		// Type new email
		driver.findElement(By.xpath(sp.txtbxEmail)).sendKeys(NewEmail);

		waitThread(1000);

		// Type password
		driver.findElement(By.xpath(sp.txtbxPass)).sendKeys("Abc@123");
		driver.findElement(By.xpath(sp.txtbxPassconf)).sendKeys("Abc@123");

		// click on privacy policy check box
		click(sp.chkbx_1);

		// click signup button
		click(sp.btn_signup);

		// verify heading-Email Verification Code
		Assert.assertEquals(getText(sp.HeadingTitle_2), "Email Verification Code");

		waitFor(sp.toaster);

		// validation message-Please Check your Email to enter Verification Code
		Assert.assertEquals(getText(sp.toaster), "Please check your email to enter the Verification Code");
		waitThread(2000);

	}

	/*
	 * To perform change email functionality on the Email Verification page
	 */
	@Test(priority = 17)
	public void TCSPR020017() {
		// To perform change email functionality
		// Verify change email link
		Assert.assertTrue(isElementPresent(sp.changeemail), "Change Email button not present");

		// Text-As individual Teacher
		Assert.assertEquals(getText(sp.changeemail), "Change Email");

		// click on Change Email link
		click(sp.changeemail);

		// Text-As individual Teacher
		Assert.assertEquals(getText(sp.txt_1), "as Individual Teacher");

	}

	/*
	 * To perform change email functionality on the Email Verification page
	 */
	@Test(priority = 18)
	public void TCSPR020018() {

		Test = "newtestemail" + generateRandomNumber().trim() + "@gmail.com";

		// to check change url functionality
		driver.findElement(By.xpath(sp.txtbxEmail)).clear();
		driver.findElement(By.xpath(sp.txtbxEmail)).sendKeys(Test);
		driver.findElement(By.xpath(sp.txtbxPass)).sendKeys("Abc@123");
		driver.findElement(By.xpath(sp.txtbxPassconf)).sendKeys("Abc@123");

		waitThread(2000);

		// click signup button
		click(sp.btn_signup);

		// waitFor(NewEmail);
		Assert.assertEquals(getText(sp.emailvalue), Test);

	}

	/*
	 * To perform Resend verification code functionality
	 */
	@Test(priority = 19)
	public void TCSPR020019() throws SQLException {

		oldotp = dc.sprotp(Test);

		waitThread(5000);
		// To verify button label
		Assert.assertEquals(getText(sp.btn_resend), "Resend Verification Code");

		// click on Resend Verification Code link
		click(sp.btn_resend);

		waitFor(sp.toaster);

		// validation message-Please Check your Email to enter Verification Code
		Assert.assertEquals(getText(sp.toaster), "Please check your email to enter the Verification Code");

		waitThread(7000);

		newotp = dc.sprotp(Test);

		// type old OTP
		driver.findElement(By.xpath(sp.otpbx_1)).sendKeys(oldotp);
		waitFor(sp.toaster);
		
		// Verify Invalid OTP toaster message
		Assert.assertEquals(getText(sp.toaster), "Verification Code '" + oldotp + "' is invalid");
		waitThread(3000);

		// Type Invalid OTP
		driver.findElement(By.xpath(sp.otpbx_1)).sendKeys("1234");
		waitThread(1000);
		waitFor(sp.toaster);

		// Verify Invalid OTP toaster message
		Assert.assertEquals(getText(sp.toaster), "Verification Code '" + 1234 + "' is invalid");
		waitThread(3000);

		// Type new OTP
		driver.findElement(By.xpath(sp.otpbx_1)).sendKeys(newotp);
		waitThread(2000);

	waitFor(sp.Selecttrialplan);
		//click on select trial plan button
		click(sp.Selecttrialplan);
		waitThread(1000);
		click(sp.coursetab);
		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");
		waitThread(2000);

		// To perform delete account functionality
		sp.DeleteAccount();
		waitThread(2000);
		// To login with deleted account credentials
		lg.login(Email, "Abc@123");
		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");
	}

}
