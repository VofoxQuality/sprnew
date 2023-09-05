package AccountSettings.Pages;

import org.testng.Assert;

import SPRautomation.StudentPeerReview.basePage;

public class AccountSettingsandDeleteAccountPage extends basePage {

	// heading labels
	// heading-Account Settings
	public String hd_label5 = "//div[contains(@class,'login-right account-setting')]//child::h1";
	// Label:Teacher ID
	public String hd_label6 = "//div[contains(@class,'login-right account-setting')]//child::form/span";
	public String hd_label7 = "//input[@id='firstName']//following::label[1]";
	public String hd_label8 = "//input[@id='lastName']//following::label[1]";
	public String hd_label9 = "//button[@id='save']//child::span[1]";
	public String hd_label10 = "//button[@id='cancel']//child::span[1]";
	public String hd_label11 = "//div[@class='login-right']/h1";
	// buttons

	public String teach_button1 = "//img[@id='teacher']//following::button[1]";
	public String signup_button2 = "//p-button[@id='singup']";
	public String edit_button3 = "//button[@id='edit']";
	public String delete_button4 = "//button[@id='delete']";
	public String save_button5 = "//button[@id='save']";
	public String cancel_button6 = "//button[@id='cancel']";
	public String login_button7 = "//button[@id='submit']";

	// checkboxes
	public String checkbox1 = "//div[@class='p-checkbox-box']";

	// Signup textboxes

	public String emailtxt3 = "//input[@id='Email']";
	public String passwordtxt4 = "//input[@id='password']";
	public String confirmpasstxt5 = "//input[@id='confirmPassword']";

	// Login textboxes
	public String loginemailtxt6 = "//input[@id='Email']";
	public String loginpasswordtxt7 = "//input[@id='password']";

	// OTP
	public String otp_bx1 = "//input[@id='ngx-otp-input-0']";

	// Accountsettings page textboxes
	public String frstnam_txt6 = "//input[@id='firstName']";
	public String lstnam_txt7 = "//input[@id='lastName']";

	// validation messages
	public String valid_msg1 = "//input[@id='firstName']//following::small[1]";
	public String valid_msg2 = "//input[@id='lastName']//following::small[1]";
	public String valid_msg3 = "//input[@id='firstName']//following::small[1]";
	public String valid_msg4 = "//input[@id='firstName']//following::small[1]";
	public String valid_msg5 = "//input[@id='lastName']//following::small[1]";
	// navigation dropdown menu
	public String nav_drop1 = "//div[@id='teacherUserName']";
	public String nav_drop2 = "//div[@class='username']";
	// Alert popupbox
	public String popbox_1 = "p-confirmdialog > div > div";

	// popup labels
	public String alrt_label1 = "p-confirmdialog > div > div > div.p-dialog-header > span";
	public String alrt_label2 = "p-confirmdialog > div > div > div.p-dialog-content > span";

	// popup buttons
	public String alrt_nobutton = "button.p-confirm-dialog-reject";
	public String alrt_yesbutton = "button.p-confirm-dialog-accept";

	// account settings option
	public String accnt_sett = "//div[@id='teacherUserName']";
	public String accnt_sett1 = "//div[@class='dropdown-menu dropdown-menu-right show']//following::a[1]";

	// Toaster Messages
	public String tost_1 = "//*[contains(@class,'p-toast-detail')]";

	public void login(String Emaildata, String Passworddata) {

		// fill the Email
		type(emailtxt3, Emaildata);
		// fill password
		type(passwordtxt4, Passworddata);
		// click login button
		click(login_button7);

	}

	public void coursedelete() {

		// click course tab
		click("//*[@id='navbar-menu']/div/a[1]");
		waitThread(1000);
		// click course delete dropdown
		click("p-splitbutton > div > button.p-splitbutton-menubutton> span.pi.pi-chevron-down");
		waitThread(1000);
		// click delete course button
		click("//p-splitbutton/div/p-menu/div/ul/li[5]/a/span");
		waitThread(1000);
		Assert.assertTrue(isElementPresent("#mainCoursesGrid > app-courses-grid > p-confirmdialog > div > div"),
				"delete popup not visible");
	}

}
