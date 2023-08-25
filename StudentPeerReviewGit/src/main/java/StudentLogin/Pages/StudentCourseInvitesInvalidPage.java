package StudentLogin.Pages;

import org.openqa.selenium.By;

import SPRautomation.StudentPeerReview.basePage;

public class StudentCourseInvitesInvalidPage extends basePage {

	// labels
	public String wel_label = "div.home-content > div > div > div.welcome-left > h1";
	public String courses_label = "//div[@class='page-title']";
	public String course_code = "div.align-items-center > div > span";
	public String notenrol_text = "//div[@class='student-course-bottom']//p[1]//following::h4[1]";
	public String coursename_studentpage = "//div[@class='product-item-content']//h6[1]";
	public String Coursedetls_tb = "//ul[@class='p-tabview-nav']//child::li[1]/a/span";

	// buttons
	public String teach_btn = "#teacherLoginBtn > button";
	public String creatnw_coursebtn = "#createNewCourseBtn > button";
	public String Add_studbtn = "//button[@id='inviteStudent']";
	public String add_stud_listbtn = "//button[@id='addToListBtn']";
	public String createinvite_btn = "//button[@id='createCourse']";
	public String accept_btn = "//div[@class='product-item-content']//button[1]";
	public String signUp_btn = "//p-button[@id='singup']//button";
	public String Yes_btn = " div.p-dialog-footer> button.p-confirm-dialog-accept";
	public String sendreq_btn = "//button[@id='joinCourse']//span[1]";
	public String Login_btn = "//button[@id='submit']";
	public String joinnw_btn = "//button[@class='studentopen btn secondary-btn']";
	public String details_btn = "//button[contains(@class,'p-splitbutton-menubutton')]";
	public String active_btn = "//span[@class='p-inputswitch-slider']";
	public String back_tn = "//button[@id='cancelStudentRequest']//span";

	// View/Modify Course Details button
	public String btn_coursedetails = "//ul[contains(@class,'p-menu-list p-reset')]//child::li[1]";

	// links
	public String del_courselink = "//span[contains(text(),'Delete Course')]";

	// toasters
	public String tost_1 = "//div[contains(@class,'p-toast-detail')]";
	public String toasterclosebtn = "//*[contains(@class,'p-toast-icon-close-icon')]";

	// Student Signup textboxes
	public String Firstname_textb1 = "//input[@id='firstName']";
	public String Lastname_txtb2 = "//input[@id='lastName']";
	public String Email_txtb3 = "//input[@id='Email']";
	public String Password_txtb4 = "//input[@id='password']";
	public String confirm_txtb5 = "//input[@id='confirmPassword']";

	// textboxes
	public String coursetitle_txt = "//input[@id='courseTitle']";
	public String emailtype_txt = "//input[@id='inviteStudentChip']";
	public String NewStudentstobeinvite = " li.p-chips-token.ng-star-inserted > div > span";
	public String coursid_txtbx = "//input[@id='enterCourseId']";
	public String log_email = "//input[@id='email']";
	public String log_pass = "//input[@id='password']";
	
	// checkbox
	public String sign_check = "//div[@class='p-checkbox p-component']";

	// grid
	public String course_tit_grid = "//table[@role='grid']//tbody//td[3]";

	// popup
	public String Confir_label = "//p-confirmdialog[@id='studentReqConfirmationDialog']//div[2]//span";
	public String confirmlabel2 = "div.p-dialog-content > span";
	public String confirm_lb3 = " div.p-dialog-content> span";
	
	// dropdowns
	public String Details_drop = "//span[@class='p-button-icon pi pi-chevron-down']";
	/*
	 * To perform delete account functionality
	 */
	public void DeleteAccount() {
		
		waitThread(2000);
		driver.findElement(By.xpath("//div[@class='username']")).click();
		waitThread(1000);
		driver.findElement(By.xpath("//i[@class='fas fa-user-circle']")).click();
		waitThread(1000);
		driver.findElement(By.xpath("//button[@id='delete']")).click();
		waitThread(1000);
		driver.findElement(By.cssSelector("button.p-confirm-dialog-accept")).click();
		waitThread(3000);
		

	}


}
