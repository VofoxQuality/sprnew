package StudentLogin.Pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;

public class RemoveStudentFromCoursePage extends basePage {

	LoginPage lg = new LoginPage();

	// Toaster
	public String toaster = "//div[contains(@class,'p-toast-detail')]";

	// Texts
	// As Individual Student
	public String txt_1 = "div.login-right > div:nth-child(1) > h3";

	// Student Profile Page

	// Labels
	public String lbl_joincourse = "//div[@id='joinNewCourseTxt']";
	public String btnlbl_joincourse = "//button[@id='joinNewCourseBtn']";
	public String course_name = "//p-carousel[@id='requestReceivedCarousel']//following::h6[1]";
	public String lbl_requestsend = "#studentRequestPopup > h3";
	public String lbl_popup = "#studentRequestPopup > div";
	public String Cpymessage= "//div[contains(@class,'p-toast-detail')]";

		

	// Place holders-Login
	public String Email_txt = "//input[@id='email']";
	public String Pass_txt = "//input[@id='password']";
	public String LoginBtn_2 = "//button[@id='submit']";

	// Buttons
	public String btn_acceptcourse = "//button[@class='btn outline-btn float-right']";
	public String box_confirmation = "#studentReqConfirmationDialog > div > div";
	public String popupbtn_Yes = "button.p-confirm-dialog-accept";
	public String btn_sendrequest = "//button[@id='joinCourse']";
	public String popupbtn_close = "span.p-dialog-header-close-icon";

	// course name on the enrolled page
	public String enrolledcoursename = "//div[@class='p-dataview-content']//child::h6[1]";

	// Course ID Textbox
	public String txtbx_courseID = "//input[@id='enterCourseId']";
	public String Course_id ="body > app-root:nth-child(3) > app-shell:nth-child(2) > div:nth-child(2) > app-courses:nth-child(2) > div:nth-child(1) > div:nth-child(2) > app-courses-grid:nth-child(1) > div:nth-child(1) > p-table:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > div:nth-child(1) > span:nth-child(1) > i:nth-child(1)";

	// student request view panel
	public String studentbx = "//div[@id='joinNewCourseDivMain']";
	public String success_popup = "#requestSendDialog > div > div";

	// Request view link and count
	public String requestviewlink = "tbody > tr:nth-child(1) > td:nth-child(7) > div > div.tabview-link > span.item-link";
	//public String requestviewlink1 = "//*[@id=\"p-tabpanel-12-label\"]/span";
	public String requestcount = "tbody > tr:nth-child(1) > td:nth-child(7) > div > div.tabview-link > p-badge > span";

	// heading label-student request page
	public String heading_Requestfrmstud = "//i[@id='studentRequestsIcon']//following::span[1]";
	public String Requestcount = "//p-badge[@id='noOfStudentReq']";
	public String coursename = "//div[@id='rseCourseName']";

	/*
	 * To perform Logout functionality
	 */

	public String header_dropdown="//div[@class='username']";
	public String logout_link="//i[@class='pi pi-sign-out']";
	public String logout_btn="//i[@class='pi pi-sign-out']";
	
	public void Logout() {

		waitThread(1000);
		driver.findElement(By.xpath("//div[@class='username']")).click();
		waitThread(1000);
		driver.findElement(By.xpath("//i[@class='pi pi-sign-out']")).click();
	}

	/*
	 * Login Teacher
	 */
	public void login_Teacher(String Emaildata, String Passworddata) {

		// fill the Email
		type(Email_txt, Emaildata);
		// fill password
		type(Pass_txt, Passworddata);
		// click login button
		click(LoginBtn_2);

	}

	/*
	 * Login Student
	 */
	public void login_Student(String Emaildata, String Passworddata) {

		// fill the Email
		type(Email_txt, Emaildata);
		// fill password
		type(Pass_txt, Passworddata);
		// click login button
		click(LoginBtn_2);

	}
}
