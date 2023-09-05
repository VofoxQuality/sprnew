package Login.Pages;

import org.openqa.selenium.By;

import SPRautomation.StudentPeerReview.basePage;

public class LoginPage extends basePage {

	
	//label
	public String wel_label = "//h1[@class='page-title text-lg-left text-md-center']";
	// Buttons
	public String LoginBtn_2 = "//button[@id='submit']";
	public String loginbtn3="//*[@id='loginBtnId']/button/span";
	// PageTitle-login
	public String PageTitle = "//div[@class='login-right']/h1";
	// page title Reset Password
	public String pagetitle2 = "//div[contains(@class,'login-right')]/h1";

	// page title courses
	public String pagetitle3 = "//div[@id='teacherCoursePageRow']/div[1]/div";
	public String pagetitlenew = "//*[@id=\"teacherCoursePageRow\"]/div[1]/div";

	// Place holders
	public String Email_txt = "//input[@id='email']";
	public String Pass_txt = "//input[@id='password']";

	// Textboxes
	public String txtbx_Email = "//input[@id='email']//parent::span";
	public String txtbx_Password = "//input[@id='password']//parent::span";

	// navigation mrnu dropdown
	public String Nav_dd = "//div[@class='username']";
	public String Nav_dd1="//div[@id='teacherUserName']";

	// logout link
	public String Link_logout = "ul > li:nth-child(3) > div > div > a.dropdown-item.menu_links";
	public String Link_logout1 = "//a[@id='user-dropdown']//following::a[5]";

	// links
	// Forgot password?
	public String link1 = "//button[@id='submit']//following::a[1]";
	public String link1text = "//button[@id='submit']//following::a[1]";
	// Don't have an account?
	public String link2 = "//button[@id='submit']//following::a[2]";
	public String link2text = "//button[@id='submit']//following::a[2]";
	// Backtohome
	public String link3 = "//button[@id='submit']//following::a[1]";

	// validation messages
	// Email
	public String validationmsg1 = "//input[@id='email']//following::small[1]";
	// Password
	public String validationmsg2 = "//input[@id='password']//following::small[1]";

	// Toaster text
	public String validationmsg3 = "//div[contains(@class,'p-toast-detail')]";
	public String toaster = "//div[contains(@class,'p-toast-detail')]";
	public String LoginBtn_1 = "//p-button[@id='loginBtnId']/button";
	public void login(String Emaildata, String Passworddata) {
		// Click on login button
		click(LoginBtn_1);
		waitThread(2000);
		// fill the Email
		type(Email_txt, Emaildata);
		// fill password
		type(Pass_txt, Passworddata);
		// click login button
		click(LoginBtn_2);
		waitThread(2000);

	}
	public void login1(String Emaildata, String Passworddata) {
		waitThread(1000);
		// fill the Email
		type(Email_txt, Emaildata);
		// fill password
		type(Pass_txt, Passworddata);
		// click login button
		click(LoginBtn_2);
		waitThread(2000);

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

}
