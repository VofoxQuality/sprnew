package ForgotPassword.Pages;

import org.openqa.selenium.By;

import SPRautomation.StudentPeerReview.basePage;

public class ForgotPasswordPage extends basePage {

	// Toaster
	public String toaster = "//div[contains(@class,'p-toast-detail')]";
	// Textbox-Send Reset Link
	public String emailtxtbx = "//input[@id='resetemail']";

	// placeholder-Enter Registered Email
	public String txtbxplaceholder = "//input[@id='resetemail']";

	// button-Send Reset Link
	public String btn_Reset = "//button[@id='submit']";
	public String btnlbl_Reset = "//button[@id='submit']/span";

	// back to home
	public String Backtohome = "//button[@id='submit']//following::div//a";

	// validation mesages
	// Email is required
	public String valmsg_1 = "//input[@id='resetemail']//following::small[1]";
	// Email must be in a correct format
	public String valmsg_2 = "//input[@id='resetemail']//following::small[1]";
	// New Password is required
	public String valmsg_3 = "//input[@id='newpassword']//following::small[1]";
	// Confirm Password is required
	public String valmsg_4 = "//input[@id='confirmPassword']//following::small[1]";
	// Password mismatch
	public String valmsg_5 = "//input[@id='confirmPassword']//following::small[1]";
	// This password already used . Please try another.
	public String valmsg_6 = "div.p-error.small";

	public String valmsg_pass = "//input[@id='newpassword']//following::small[1]";

	public String valmsg_confpass = "//input[@id='confirmPassword']//following::small[1]";

	// Generate New Password
	public String heading_1 = "//div[@class='login-box-main']//following::h1";

	// Textboxes
	public String newpass_txbx = "//input[@id='newpassword']";

	public String confpass_txbx = "//input[@id='confirmPassword']";


	// button-Apply
	public String btn_Apply = "//button[@id='submit']";
	public String btnlbl_Apply = "//button[@id='submit']/span";

	/*
	 * To perform Logout functionality
	 */

	public void Logout() {

		waitThread(1000);
		driver.findElement(By.xpath("//div[@class='username']")).click();
		waitThread(1000);
		driver.findElement(By.xpath("//a[@id='user-dropdown']//following::a[3]")).click();
	}

}
