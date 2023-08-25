package StudentLogin.Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import SPRautomation.StudentPeerReview.basePage;

public class StudentAcceptCoursePage extends basePage {

	// heading labels

	public String welcome_to_label1 = "//h1[@class='page-title text-lg-left text-md-center']";
	public String signup_label2 = "//div[@class='login-right']/div/h1[1]";
	public String email_ver_label3 = "//div[@class='login-right']//h1";
	public String courses_label4 = "//div[@class='page-title']";
	public String courseid1 = "//div[@class='p-card-content']//child::div[1]//span[@tooltipposition='top'] ";
	public String course_tit_grid = "//table[@role='grid']//tbody//td[3]";
	public String course_roast = "//ul[@class='p-tabview-nav']//li[2]//span[1]";
	public String Add_stud_course_hd = "//div[@role='dialog']//p-header";
	public String Add_stud_list = "//p-tabview[@id='inviteStudentsPopup']/div/ul/li[2]/a";
	public String No_stud_found_txt = "#myStudentListTableCustomId > table > tbody > tr > td";
	public String suspendedpagenostudentlbl="#p-tableGrid > div > div.p-datatable-wrapper > table > tbody > tr > td";
	public String ivite_new_stud_btn = "//p-tabview[@id='inviteStudentsPopup']/div/ul/li[1]/a/span[2]";
	public String email_incourseroaster_grid = "//table[@role='grid']//tbody//td[6]";
	public String Login_hd = "//div[@class='login-right']/h1";
	public String coursename_studentpage = "//div[contains(@class,'product-item-content')]//h6[1]";
	public String Confir_label = "#studentReqConfirmationDialog > div > div > div.p-dialog-content > span";

	public String enrolled_course_hd = "//div[@id='enrolledCoursesTxt']//div";
	public String Course_created_label ="p > strong.enrolledfontsmall";
	public String suspendedlbl="span.student-suspended-label";
	public String acept_course = "//div[@id='studentAssessmentDataView']//child::h6";
	public String Course_id_student_pro = "//div[@class='product-grid-item-content']//p[1]";
	public String Courseid_text = "//div[@class='product-grid-item-content']//p[1]//strong";
	public String Joined_text = "div.product-grid-item-content > p:nth-child(2) > strong";
	public String date = "//div[@class='product-grid-item-content']//p[2]";
	public String openassess_txt = "//div[@class='product-grid-item-content']//p[3]";
	public String Course_creat_bytext = "//strong[@class='enrolledfontsmall']";
	public String teach_name = "//div[@class='p-dataview-content']//div[3]//strong[2]";
	public String Enrolled_course_grid = "//tbody[@class='p-datatable-tbody']//td[6]//div";
	public String newjoine_labl = "//div[@id='joinNewCourseTxt']";
	public String confirm_hd = "#studentReqConfirmationDialog > div > div > div.p-dialog-header > span";
	public String StudentIDdetails = "div.login-right-box > form > span";
	// Course grid
	public String Studentid_grid = "//table[@role='grid']//tbody//td[3]";
	public String Firstname_grid = "//*[@id='p-tableGrid']/div/div[1]/table/tbody/tr[1]/td[4]/div[2]/span";
	public String Lastname_grid = "//*[@id='p-tableGrid']/div/div[1]/table/tbody/tr[1]/td[5]/div[2]/span";
	public String email_grid = "//*[@id='p-tableGrid']/div/div[1]/table/tbody/tr/td[6]/div[2]/span";
	public String coursenam_grid = "//div[@class='container-fluid course-head course-container']//div[contains(@class,'text-truncate')]";
	public String Enrol_rad = "//p-radiobutton[@id='enrolled']";
	public String Status_invit = "//table[@role='grid']//tbody//td[8]";
	public String enrol_lab = "//label[@id='enrolledId']";
	public String no_stud_found = "//p-table[@id='p-tableGrid']//child::td";
	// Teacher Signup textboxes

	public String firstnametxt1 = "//input[@placeholder='First Name']";
	public String lastnametxt2 = "//input[@placeholder='Last Name']";
	public String emailtxt3 = "//input[@id='Email']";
	public String passwordtxt4 = "//input[@id='password']";
	public String confirmpasstxt5 = "//input[@id='confirmPassword']";

	// Create new course- textboxes
	public String coursetitle_txt = "//input[@id='courseTitle']";
	public String emailtype_txt = "//input[@id='inviteStudentChip']";
	public String NewStudentstobeinvite = "//p-chips[@inputid='studentsInvitedChip']//child::li[1]/div/span";
	public String enter_courseid = "//input[@id='enterCourseId']";
	
	// Add to list
	public String tab_btn_Addtolist = "//button[@id='addToListBtn']";
	
	public String tablbl_addtolist = "//button[@id='addToListBtn']/span";
	//confirmation popup yes button
	public String confirmyesbtn="button.p-confirm-dialog-accept";
	// Login textboxes
	public String log_email = "//input[@id='email']";
	public String log_pass = "//input[@id='password']";

	// buttons
	public String teach_button1 = "//img[@id='teacher']//following::button[1]";
	public String signup_button2 = "//p-button[@id='singup']//span";
	public String create_newcourse_btn3 = "//span[@class='p-button-label ng-star-inserted']";
	public String Add_students_btn4 = "//button[@id='inviteStudent']//span[2]";
	public String Add_tolist_btn5 = "//button [@id='addToListBtn']//span";
	public String Create_invite_btn6 = "//button[@id='createCourse']//span";
	public String Veiwmodify_btn = "//ul[contains(@class,'p-menu-list p-reset')]//child::li[2]";
	public String Revokinvi = "//span[contains(text(),'Revoke Invitations')]";
	public String Add_stud_bt = "//i[@id='userPlus']";
	public String Send_req_btn = "//button[@label='Send Request']";
	public String Accept_btn = "//div[@class='product-item-content']//button[1]";
	public String Yes_btn = "//p-confirmdialog[@header='Confirmation']//div[3]//button[2]";
	public String No_btn = "//p-confirmdialog[@header='Confirmation']//div[3]//button[1]";
	public String Login_btn = "//button[@id='submit']";
	public String close_btn = "//div[@role='dialog']//button[@xpath='1']";
	public String susp_stud = "//span[contains(text(),'Suspend Students')]";
	public String cancel_btn = "//button[@id='cancelStudentAddBtn']";
	public String Join_newCourse_btn = "//button[@class='studentopen btn secondary-btn']";
	public String Re_enrol_btn = "//div[@id='undefined_content']//following::ul[1]//li[2]";
	public String delacount = "//button[@id='delete']";
	public String Yesbtn = "button.p-confirm-dialog-accept";
	public String close__btn="span.p-dialog-header-close-icon";

	// search box
	public String Stud_searchbox = "//input[@type='search']";

	// checkboxes
	public String checkbox1 = "//div[@class='p-checkbox-box']";
	public String enroll_radio = "//p-radiobutton[@value='Enrolled']//span[@class= 'p-radiobutton-icon']";
	public String grid_checkbx = "//p-table[@id='p-tableGrid']//following::p-tablecheckbox//div[2]";
	public String cour_grid_check = "//div[@class='p-checkbox-box p-component p-highlight']//span[@class='p-checkbox-icon pi pi-check']";

	// OTP
	public String otp_bx1 = "//input[@id='ngx-otp-input-0']";

	// toasters
	public String tost_1 = "//*[contains(@class,'p-toast-detail')]";
	

	// dropdowns
	public String Details_drop = "p-splitbutton > div > button.p-splitbutton-menubutton";
	public String nav_drop1 = "//a[@id='user-dropdown']";
	public String Log_link = "//a[@class='dropdown-item menu_links']";
	public String teach_drop = "//div[@class='student-course-bottom']//p-dropdown";
	public String teach_nam_drop = "//div[@class='student-course-bottom']/p-dataview[1]/div[1]/div[1]/div[1]/div[2]/div[1]/p-dropdown[1]/div[1]/span[1]";
	public String stud_dropdwn = "//div[@id='studentUserName']";
	public String Stud_logout_link = "//a[@class='dropdown-item menu_links']//i";
	public String Actions = "//a[@id='undefined_header']//child::span[2]";
	public String Accntset = "//div[@id='studentUserName']//following::a[1]";

	// radio buttons
	public String Invited_drop = "//*[@id='invitedNot']/div";
	public String Susp_rd = "//p-radiobutton[@value='Suspended']";
	public String susp_rad_tick = "//p-radiobutton[@value='Suspended']//span";
	// popups
	public String preveiw_pop = "//div[@class='p-tabview p-component']";

	public String tooltip = "//p-chips[@inputid='inviteStudentChip']//child::li[1]/div[1]//span";
	public String tooltip1 = "//p-chips[@inputid='inviteStudentChip']//child::li[1]/div[1]//span";
	// System Date

	public String getdate() {

		DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

}
