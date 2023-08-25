package ChangePassword.Pages;

import org.openqa.selenium.By;

import SPRautomation.StudentPeerReview.basePage;

public class ChangePasswordPage extends basePage {

	// Buttons
	// change password button
	public String btn_changepassword = "ul > li:nth-child(3) > div > div > a:nth-child(3)";
	public String btn_Apply = "//button[@id='apply']";
	public String btnlbl_Apply = "//button[@id='apply']/span";

	// heading-change password
	public String heading_1 = "//app-change-password/div/div/div/div/div/div/h1";

	// Textboxes
	public String txtbx_currentpass = "//input[@id='password']";
	public String txtbx_newpass = "//input[@id='newPassword']";
	public String txtbx_confirmpass = "//input[@id='confirmPassword']";

	// placeholders
	public String placeholder1 = "//input[@id='password']";
	public String placeholder2 = "//input[@id='newPassword']";
	public String placeholder3 = "//input[@id='confirmPassword']";

	// validation messages
	public String valmsg_1 = "//input[@id='password']//following::small[1]";
	public String valmsg_2 = "//input[@id='newPassword']//following::small[1]";
	public String valmsg_3 = "//input[@id='confirmPassword']//following::small[1]";
	public String valmsg_4 = "//input[@id='newPassword']//following::small[1]";
	public String valmsg_5 = "//input[@id='confirmPassword']//following::small[1]";
	public String valmsg_6 = "//input[@id='newPassword']//following::small[1]";

	// Toaster message
	public String toaster = "//div[contains(@class,'p-toast-detail')]";

	/*
	 * To perform delete account functionality
	 */
	public void DeleteAccount() {

		waitThread(1000);
		driver.findElement(By.xpath("//div[@class='username']")).click();
		waitThread(1000);
		driver.findElement(By.xpath("//a[@id='user-dropdown']//following::a[1]")).click();
		waitThread(1000);
		driver.findElement(By.xpath("//button[@id='delete']")).click();
		waitThread(1000);
		driver.findElement(By.cssSelector("button.p-confirm-dialog-accept")).click();

	}

}
