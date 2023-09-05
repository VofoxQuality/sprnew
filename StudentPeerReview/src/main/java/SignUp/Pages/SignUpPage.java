package SignUp.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import SPRautomation.StudentPeerReview.basePage;

public class SignUpPage extends basePage {

	public String toaster = "//div[contains(@class,'p-toast-detail')]";

	// I am a teacher button
	public String btn_1 = "//img[@id='teacher']//following::button[1]";
	public String btn_1lbl = "//img[@id='teacher']//following::p-button[1]";

	// heading title-Signup
	public String HeadingTitle_1 = "//div[@class='login-right']/div/h1[1]";
	// Email Verification Code
	public String HeadingTitle_2 = "//div[@class='login-right']/h1";
	//public String HeadingTitle_2 = "/html/body/app-root/app-signup/div/app-email-verification/header/div/div/div[2]";

	// Texts
	// As individual Teacher
	public String txt_1 = "//div[@class='login-right']//following::h3";

	// Terms and conditions
	public String txt_2 = "//p-checkbox[@id='agreedTC']/div/div[2]/span/following::span[1]";
	//i am a Student 
    public String btn_in = "//*[@id=\"studentLoginBtn\"]/button/span";
	// check boxes
	// privacy policy
	public String chkbx_1 = "//div[@class='p-checkbox-box']";
	public String chkbx_sel = "//span[@class='p-checkbox-icon pi pi-check']";

	// OTP boxes
	public String otpbx_1 = "//input[@id='ngx-otp-input-0']";
	public String otpbx_2 = "//input[@id='ngx-otp-input-1']";
	public String otpbx_3 = "//input[@id='ngx-otp-input-2']";
	public String otpbx_4 = "//input[@id='ngx-otp-input-3']";

	//course Tab
	public String coursetab="//*[@id='navbar-menu']/div/a[1]";
	//select trial plan
	public String Selecttrialplan="//*[@id='trial-select-btn']/button";
	// placeholders

	// Signup
	public String Signup_lbl = "//p-button[@id='singup']//child::span";

	// Already have an account?
	public String alreadyact_lbl = "//p-button[@id='singup']//following::a[1]";

	// privacy policy
	public String privacypolicy = "//p-checkbox[@id='agreedTC']//following::a[1]";

	// terms and conditions
	public String terms = "//p-checkbox[@id='agreedTC']//following::a[2]";

	// Labels
	public String label1 = "div.login-right-box > div>h6";

	// Textboxes
	// First Name
	public String txtbxFirstN = "//input[@id='firstName']";
	// Last Name
	public String txtbxLastN = "//input[@id='lastName']";
	// Email
	public String txtbxEmail = "//input[@id='Email']";

	// Password
	public String txtbxPass = "//input[@id='password']";
	// Confirm Password
	public String txtbxPassconf = "//input[@id='confirmPassword']";

	// email value on email verification code
	public String emailvalue = "div.login-right-box > div>h6>div";

//	// validation messages
//	public String val_msg_1 = "//input[@id='firstName']//following::div/small[1]";
	public String val_msg_2 = "//input[@id='Email']//following::div[1]";
//	public String val_msg_3 = "//input[@id='password']//following::div[1]";
//	public String val_msg_4 = "//input[@id='confirmPassword']//following::div[1]";
//	public String val_msg_5 = "//input[@id='lastName']//following::div[1]";

	// Buttons
	public String btn_signup = "//*[@id='singup']/button/span";
	public String btn_resend = "//button[@id='backToHome']//parent::div//button[1]";
	public String btnlbl_resend = "//button[@id='backToHome']//parent::div//button[1]";
	public String btn_backtohome = "//button[@id='backToHome']";
	public String btnlbl_bactohome = "//button[@id='backToHome']";
	public String btn_back = "//i[@class='pi pi-arrow-left']";
	public String btn_AlreadyAccount = "//p-button[@id='singup']//following::a[1]";
	public String changeemail = "//button[@class='fbtn']";

	// validation messages
	public String valmsg_1 = "//input[@id='firstName']//following::small[1]";
	public String valmsg_2 = "//input[@id='lastName']//following::small[1]";
	public String valmsg_3 = "//input[@id='Email']//following::small[1]";
	public String valmsg_4 = "//input[@id='password']//following::small[1]";
	public String valmsg_5 = "//input[@id='confirmPassword']//following::small[1]";


	public String validationmsg(int index) {

		List<WebElement> val = driver.findElements(By.xpath("//small[@class='p-error ng-star-inserted']"));
		String validation = val.get(index).getText();
		return validation;

	}

	// To perform delete account functionality
	public void DeleteAccount() {
		waitThread(1000);
		driver.findElement(By.xpath("//div[@class='username']")).click();
		waitThread(1000);
		driver.findElement(By.xpath("//i[@class='fas fa-user-circle']")).click();
		waitThread(1000);
		driver.findElement(By.xpath("//button[@id='delete']")).click();
		waitThread(1000);
		driver.findElement(By.cssSelector("button.p-confirm-dialog-accept")).click();

	}
	
	public void selecttrialplan(){
		
		waitFor(Selecttrialplan);
		//click on select trial plan button
		click(Selecttrialplan);
		waitThread(1000);
		click(coursetab);
		waitThread(1000);
	}

}
