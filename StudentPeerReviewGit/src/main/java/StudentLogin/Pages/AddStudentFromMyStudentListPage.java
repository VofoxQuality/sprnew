package StudentLogin.Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import SPRautomation.StudentPeerReview.basePage;

public class AddStudentFromMyStudentListPage extends basePage {

	// labels
	public String wel_label = "//h1[@class='page-title text-lg-left text-md-center']";
	public String Signup_label = "//div[@class='login-right']//h1";
	public String emailverify_label = "//div[@class='login-right']//following::h3";
	public String courses_label = "//div[@class='page-title']";
	public String course_code = "//div[@class='p-card-content']//child::span[@tooltipposition='top']";
	public String Login_hd = "div.login-right>h1";
	public String newjoine_labl = "//div[@id='joinNewCourseTxt']";
	public String coursename_studentpage = "//div[contains(@class,'product-item-content')]//h6[1]";
	public String confirm_hd = "#studentReqConfirmationDialog > div > div > div.p-dialog-content > span";
	public String Courseid_text = "//div[@class='product-grid-item-content']//p[1]//strong";
	public String Courseid_num = "#studentAssessmentDataView > div > div > div > div.product-grid-item-content > p:nth-child(1)";
	public String course_roast = "//ul[@class='p-tabview-nav']//li[2]//span[1]";
	public String popup_heading = "//p-tabview[@id='inviteStudentsPopup']//preceding::p-header";
	public String addstud_label = "//p-tabview[@id='inviteStudentsPopup']/div/ul/li[2]/a/span[2]";
	public String StudentIDdetails = "span.account-heading";
	public String addstud_select = "div.p-datatable-header > div > div.align-items-center > span";
	public String stud_list_box = "//p-chips[@inputid='studentsAddedChip']//li[1]";
	public String newcourse_name = "//div[@class='product-item-content']//h6";
	public String course_head = "//div[@role='dialog']//p-header";
	//Students from My Student list
	public String studfrom_text = "div.p-card-content > div > div:nth-child(3)";
	public String stud_text = "div.p-card-content > div > div:nth-child(3)";
	// buttons
	public String teach_btn = "//img[@id='teacher']//following::button[1]";
	public String signup_btn = "//p-button[@id='singup']//span";
	public String creatnw_coursebtn = "//p-button[@id='createNewCourseBtn']//child::button[1]";
	public String Add_studbtn = "//button[@id='inviteStudent']";
	public String add_stud_listbtn = "//button[@id='addToListBtn']";
	public String createinvite_btn = "//button[@id='createCourse']";
	public String Accept_btn = "//div[@class='product-item-content']//button[1]";
	public String Yes_btn = "button.p-confirm-dialog-accept";
	public String Login_btn = "//button[@id='submit']";
	public String back_btn = "//button[@id='cancelStudentRequest']//span[1]";
	public String Accntset = "//div[@class='dropdown-menu dropdown-menu-right show']/a[1]";
	public String add_student_btn = "//i[@ptooltip='Invite more students']//button[@type='button']";
	public String add_student_btn1 = "//*[@id=\"roasterInviteMoreStudents\"]/button";
		
	
	public String Add_stud_listtab = "//p-tabview[@id='inviteStudentsPopup']/div/ul/li[2]/a";
	public String send_req = "//button[@id='sendRequestId']";
	public String delacount = "//button[@id='delete']";

	// grid
	public String course_tit_grid = "//table[@role='grid']//tbody//td[3]";
	public String acept_course = "#studentAssessmentDataView > div > div > div > div.product-grid-item-top.student-course-title-div > h6 > span";
	public String course_box = "//div[@class='enrolledbox ng-star-inserted']//child::h6";
	public String Enrolled_course_grid = "//tbody[@class='p-datatable-tbody']//td[6]//div";
	public String coursenam_grid = "//div[@id='courseNameSection']";
	public String Firstname_grid ="//div[@class='p-datatable-wrapper ng-star-inserted'][1]/table/tbody/tr/td[4]/div";
	public String Firstname_grid3 ="//*[@id=\"p-tableGrid\"]/div/div[1]/table/tbody/tr/td[4]/div[2]/span";
	public String Firstname_grid4 ="//*[@id=\"p-tableGrid\"]/div/div[1]/table/tbody/tr[1]/td[4]/div[2]/span";
	public String Firstname_grid1 ="//div[@class='p-datatable-wrapper ng-star-inserted'][1]/table/tbody/tr/td[5]/div";
	public String Firstname_grid2= "//*[@id=\"p-tableGrid\"]/div/div[1]/table/tbody/tr[1]/td[4]/div[2]/span";
	public String Lastname_grid = "//table[@role='grid']//td[5]";
	public String Lastname_grid1 = "//table[@role='grid']//td[6]";
	public String email_grid = "//table[@role='grid']//td[6]";
	public String email_grid1 = "//table[@role='grid']//td[7]";
	public String Stud_id = "//tr[@class='ng-star-inserted']//td[3]";
	public String Stud_id1 = "//tr[@class='ng-star-inserted']//td[4]";
	public String coursenam2 = "//p-table[@id='courseListingTable']/div/div[1]/table/tbody/tr[2]/td[3]/div/span";
	public String text_notaccept = "//table[@role='grid']//td[8]";
	public String text_notacceptnew = "//*[@id=\"p-tableGrid\"]/div/div[1]/table/tbody/tr/td[8]";
	public String date_grid_courseroster = "//table[@role='grid']//td[7]";

	// textboxes
	public String firstnametxt1 = "//input[@id='firstName']";
	public String lastnametxt2 = "//input[@id='lastName']";
	public String emailtxt3 = "//input[@id='Email']";
	public String passwordtxt4 = "//input[@id='password']";
	public String confirmpasstxt5 = "//input[@id='confirmPassword']";
	public String coursetitle_txt = "//input[@id='courseTitle']";
	public String emailtype_txt = "//input[@id='inviteStudentChip']";
	public String NewStudentstobeinvite = "//div[@class='p-chips p-component']//span[@class='ng-star-inserted']";
	// Login textboxes
	public String log_email = "//input[@id='email']";
	public String log_pass = "//input[@id='password']";
	// checkboxes
	public String checkbox1 = "//div[@class='p-checkbox-box']";
	public String checkbx1_tick = "//p-checkbox[@id='agreedTC']//span";
	public String checkboxgrid = "//table[@role='grid']//td[1]";
	public String All_checkbox = "//p-tableheadercheckbox//div[@role='checkbox']";
	public String allcheckbox_tick = "//div[@class='p-checkbox-box p-highlight']//span";
	public String checkboxgrid_tick = "//tr[@class='ng-star-inserted']//p-tablecheckbox";
	public String checkbox_grid1 = "//table[@role='grid']//td[1]//div[@class='p-checkbox-box p-component']";
	public String checkbox_tick = "//tbody[@class='p-datatable-tbody']//span[1]";
	// checkbox- courseroaster
	public String all_checkbox = "#myStudentListTableCustomId > table > thead > tr > th:nth-child(1) > p-tableheadercheckbox > div > div.p-checkbox-box";
	public String grid_checkbx = "#myStudentListTableCustomId > table > tbody > tr:nth-child(1) > td:nth-child(1) > p-tablecheckbox > div > div.p-checkbox-box";
	public String al_check_tick = "//button[@id='cancelStudentRequest']//following::p-table[2]//child::p-tableheadercheckbox//child::div[2]//span";
	public String grid_check_tick = "//button[@id='cancelStudentRequest']//following::p-table[2]//child::p-tablecheckbox//child::div[2]//span";
	// dropdowns
	public String nav_drop1 = "//div[@class='username']";
	public String teach_drop_text = "#courseCreatedBy > div > span";
	public String stud_dropdwn = "//*[@id='studentUserName']";
	public String Details_drop = "p-splitbutton > div > button.p-splitbutton-menubutton";
	//public String Details_drop2 = "//tbody[@class='p-datatable-tbody']//tr[2]//td[8]//button[2]";
	public String Actions_drop = "//a[@id='undefined_header']//span";
	// links
	public String Log_link = "//a[@class='dropdown-item menu_links']";
	public String Stud_logout_link = "//a[@class='dropdown-item menu_links']";
	public String Veiwmodify_link = "p-splitbutton > div > p-menu > div > ul > li:nth-child(2) > a";
	public String Revok_link = "//div[@id='undefined_content']//li[5]//span[2]";
	// otpbox
	public String otp_bx1 = "//input[@id='ngx-otp-input-0']";
	// toasters
	public String tost_1 = "//*[contains(@class,'p-toast-detail')]";
	public String toasterclosebtn = "//*[contains(@class,'p-toast-icon-close-icon')]";

	// popup box
	public String popup1 = "//div[@role='dialog']";

	// radiobuttons
	public String invited_radio = "//p-radiobutton[@id='invitedNot']";

	// System Date

	public String getdate() {
		DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
		Date date = new Date();
		return dateFormat.format(date);

	}

}
