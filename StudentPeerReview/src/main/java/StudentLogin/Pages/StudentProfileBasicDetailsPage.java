package StudentLogin.Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.Assert;

import SPRautomation.StudentPeerReview.basePage;

public class StudentProfileBasicDetailsPage extends basePage {

	// heading labels

	public String hd_label1 = "//h1[@class='page-title text-lg-left text-md-center']";
	// Heading Sign-Up
	public String hd_label2 = "//div[@class='login-right']/div/h1[1]";
	public String hd_label3 = "//div[@class='page-title']";
	// Email Verification code
	public String hd_label4 = "//div[@class='login-right']/h1";
	// course ID
	public String courseid1 = "//div[contains(@class,'section-title course-copy')]//child::span";
	// Heading course roaster
	public String course_roast = "//ul[@class='p-tabview-nav']//child::li[2]/a/span";
	// Heading Login
	public String Login_hd = "//div[@class='login-right']/h1";
	public String email_hd1 = "//div[@class='login-right-box']//h6";
	public String Teacher_name = "div > p:nth-child(4) > strong > span";

	// Student SignUP Page labels
	public String indiv_stu_label = "//div[@class='login-right']//following::h3";
	public String txtlabel = "//p-checkbox[@id='agreedTC']/div/div[2]/span/following::span[1]";
	public String Alrdy_accnt_link = "//p-button[@id='singup']//following::a[1]";

	// Student Signup page Vlidation Messages
	public String Valmsg_frstname = "//input[@id='firstName']//following::small[1]";
	public String Valmsg_lstname = "//input[@id='lastName']//following::small[1]";
	public String Valmsg_email = "//input[@id='Email']//following::small[1]";
	public String Valmsg_pass = "//input[@id='password']//following::small[1]";
	public String Valmsg_confirmpas = "//input[@id='confirmPassword']//following::small[1]";

	// Student logined Page - heading labels
	public String newjoine_labl = "//div[@id='joinNewCourseTxt']";
	public String req_receiv_box = "//p-carousel[@id='requestReceivedCarousel']//div[contains(@class,'product-item-content')]";
	public String you_have_notenrolled = "//div[@id='noDataMessage']//child::h4[1]";
	public String Req_receiv_label = "#reqReceivedSpan > span";
	public String Req_sent_label = "#studentReqSpan > span";
	public String courseId = "//div[@class='p-carousel-items-container']//p[1]";
	public String Req_rec_text = "p.product-description:nth-child(3) > strong";
	public String Course_created_text = "p.product-description:nth-child(4) > strong";
	public String Teach_name = "//div[@class='product-item-content']//span";
	public String Req_receiv_count1 = "//p-badge[@id='reqReceivedCount']//span[1]";
	public String date_grid = "//div[@class='p-carousel-items-container']//p[2]";
	public String coursename_studentpage = "//div[@class='p-carousel-items-container']//h6";
	public String courseIdtext = "p.product-description:nth-child(2) > strong";
	// Student Logined Page - buttons

	public String close_btn = "//button[@id='joinNewCourseBtn']//following::button[1]";
	public String Join_newbox = "//div[@id='studentCourseLeft']";
	public String Join_newCourse_btn = "//button[@id='joinNewCourseBtn']";
	public String header_dropdwn = "//a[@id='user-dropdown']";
	public String dropdwn_box = "//div[contains(@class,'dropdown-menu-right show')]";
	public String Accntset = "//a[@id='user-dropdown']//following::a[1]";
	public String delacount = "//button[@id='delete']";
	public String Yesbtn = "button.p-confirm-dialog-accept";
	public String Login_btn = "//button[@id='submit']";
	public String selectedmycoursetab="//div[@id='studentHeaderLinks']//a[@class='nav-item nav-link active'][1]";

	// veiw tool tip
	public String tooltip1 = "//span[@id='reqReceivedSpan']";
	public String tooltip2 = "//span[@id='studentReqSpan']";

	// Student Signup checkboxes
	public String sign_check = "//div[@class='p-checkbox p-component']";
	public String sign_sel_check = "//span[@class='p-checkbox-icon pi pi-check']";

	// Student Signup Placeholders
	public String Firstname_placeh = "//input[@id='firstName']";
	public String Lastname_placeh = "//input[@id='lastName']";
	public String Email_placeh = "//input[@id='Email']";
	public String Password_placeh = "//input[@id='password']";
	public String confirm_placeh = "//input[@id='confirmPassword']";

	// Student Signup textboxes
	public String Firstname_textb1 = "//input[@id='firstName']";
	public String Lastname_txtb2 = "//input[@id='lastName']";
	public String Email_txtb3 = "//input[@id='Email']";
	public String Password_txtb4 = "//input[@id='password']";
	public String confirm_txtb5 = "//input[@id='confirmPassword']";

	// Student Signup buttons
	public String signUp_btn = "//p-button[@id='singup']//button";

	// buttons
	public String signup_button2 = "//p-button[@id='singup']//span";
	public String create_newcourse_btn3 = "//span[@class='p-button-label ng-star-inserted']";
	public String Add_students_btn4 = "//button[@id='inviteStudent']";
	public String Add_tolist_btn5 = "//button[@id='addToListBtn']";
	public String Create_invite_btn6 = "//button[@id='createCourse']";
	public String Veiwmodify_btn = "p-splitbutton > div > p-menu > div > ul.p-menu-list > li:nth-child(2)>a>span";
	public String Revokinvi = "li.p-menuitem:nth-child(5) > a > span.p-menuitem-text";
	
	//tabs
	
	public String MyCourseTab="//*[@id='myCoursesLinkStudent']";

	// checkboxes
	public String checkbox1 = "//div[@class='p-checkbox-box']";
	public String grid_checkbx = "table > tbody > tr:nth-child(1) > td:nth-child(1) > p-tablecheckbox > div";
	public String cour_grid_check = "tbody > tr:nth-child(1) > td:nth-child(1) > p-tablecheckbox > div > div.p-checkbox-box.p-component.p-highlight";

	// OTP
	public String otp_bx1 = "//input[@id='ngx-otp-input-0']";

	// Teacher Signup textboxes

	public String firstnametxt1 = "//input[@id='firstName']";
	public String lastnametxt2 = "//input[@id='lastName']";
	public String emailtxt3 = "//input[@id='Email']";
	public String passwordtxt4 = "//input[@id='password']";
	public String confirmpasstxt5 = "//input[@id='confirmPassword']";

	// Create new course- textboxes
	public String coursetitle_txt = "//input[@id='courseTitle']";
	public String emailtype_txt = "//input[@id='inviteStudentChip']";
	public String NewStudentstobeinvite = "//div[@class='p-chips p-component']//span[@class='ng-star-inserted']";
	public String course_tit_grid = "//table[@role='grid']//tbody//td[3]";

	// toasters
	
	public String tost_1 = "//*[contains(@class,'p-toast-detail')]";
	
	
	// course grid

	public String coursenam_grid = "//*[@id=\"courseNameSection\"]";
	public String Studentid_empty1 = "//table[@role='grid']//tbody//td[2]";
	
	public String Studentid_empty = "//table[@role='grid']//tbody//td[3]";
	public String Firstname_empty = "//table[@role='grid']//tbody//td[4]";
	public String Lastname_empty = "//table[@role='grid']//tbody//td[5]";
	public String NoAccount = "//table[@role='grid']//tbody//td[8]";
	
	public String date_grid_courseroster = "//table[@role='grid']//tbody//td[7]";
	public String email_incourseroaster_grid = "//table[@role='grid']//tbody//td[6]";
	
			
	public String Notaccept = "//table[@role='grid']//tbody//td[8]";
	//public String notAccept = "//*[@id=\"p-tableGrid\"]/div/div[1]/table/tbody/tr[1]/td[8]/div/div";
	

	// dropdowns
	public String Details_drop = "//span[@class='p-button-icon pi pi-chevron-down']";
	public String nav_drop1 = "//div[@class='username']";
	public String Log_link = "//a[@class='dropdown-item menu_links']";
	public String Stud_logout_link = "//a[@id='user-dropdown']//following::a[3]";
	public String Actions = "#undefined_header";

	// radiobuttons
	public String Invited_drop = "//p-radiobutton[@id='invitedNot']";

	// Teacher Login
	public String log_email = "//input[@id='email']";
	public String log_pass = "//input[@id='password']";

	/*
	 * Method to get system date
	 */

	public String getdate() {

		DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

	/*
	 * Login Teacher
	 */
	public void login_Teacher(String Emaildata, String Passworddata) {

		// fill the Email
		type(log_email, Emaildata);
		// fill password
		type(log_pass, Passworddata);
		// click login button
		click(Login_btn);
	}

	/*
	 * Login Student
	 */
	public void login_Student(String Emaildata, String Passworddata) {

		// fill the Email
		type(log_email, Emaildata);
		// fill password
		type(log_pass, Passworddata);
		// click login button
		click(Login_btn);

	}

	/*
	 * Logout
	 */
	public void Logout() {

		waitThread(1000);
		driver.findElement(By.xpath("//div[@class='username']")).click();
		waitThread(1000);
		// Assert link Logout
		Assert.assertTrue(isElementPresent(Log_link), "Logout link not present");
		driver.findElement(By.xpath("//i[@class='pi pi-sign-out']")).click();
	}

}
