package Course.Pages;

import SPRautomation.StudentPeerReview.basePage;

public class StudentRequestPage extends basePage {
	// heading label
	public String heading_lbl1 = "//*[@class='page-title text-lg-left text-md-center']";;
	public String heading_lbl2 = "//div[@class='login-right']/h1";
	public String heading_lbl3 = "//div[contains(@class,'section-title course-copy')]//child::span";
	public String heading_lbl4 = "//div[@id='teacherCoursePageRow']/div[1]/div";

	public String lbl_Approved = "//p-checkbox[@id='isApproved']//following::label[1]";
	public String lbl_declined = "//p-checkbox[@id='isApproved']//following::label[2]";

	public String btnlbl_Approve = "#approveReqBtn";

	// button
	public String btn_teacher = "//img[@id='teacher']//following::p-button[1]";
	public String btn_signup = "//p-button[@id='singup']";
	public String btn_createnewcrs = "//span[contains(text(),'Create New Course')]";
	public String btn_addstudent = "//button[@id='inviteStudent']";
	public String btn_addtolist = "//*[@id='addToListBtn']//span";
	public String btn_createandinvite = "//button[@id='createCourse']";

	public String btn_Approve = "#approveReqBtn";
	public String btn_decline = "//p-button[@id='declineReqBtn']";

	public String btn_back = "//button[@id='cancelStudentRequest']//span[1]";
	public String Btnlabel_back = "//button[@id='cancelStudentRequest']//span[2]";

	// pagetitle
	public String pagetitle_1 = "//div[@id='teacherCoursePageRow']/div[1]/div";

	// textboxes
	public String firstname_txt = "//input[@id='firstName']";
	public String lastname_txt = "//input[@id='lastName']";
	public String email_txt = "//input[@id='Email']";
	public String password_txt = "//input[@id='password']";
	public String confirmpw_txt = "//input[@id='confirmPassword']";

	public String txtbox_crstitle = "//input[@id='courseTitle']";
	public String txtbox_addstudentemail = "//input[@id='inviteStudentChip']";
	public String txtbox_newstinvited = "//span[@class='ng-star-inserted']";

	// checkbox
	public String checkbox_1 = "//div[@class='p-checkbox-box']";
	public String checkbox_sel = "//span[@class='p-checkbox-icon pi pi-check']";
	public String checkbox_approved = "//p-checkbox[@id='isApproved']//div[@class='p-checkbox-box']";
	public String checkbox_declined = "//div[@class='d-inline-flex mt-1']/p-checkbox";

	// otp box
	public String otpbox_1 = "//input[@id='ngx-otp-input-0']";
	public String otpbox_2 = "//input[@id='ngx-otp-input-1']";
	public String otpbox_3 = "//input[@id='ngx-otp-input-2']";
	public String otpbox_4 = "//input[@id='ngx-otp-input-3']";

	// toaster message
	public String toaster_coursecreatesuc = "//div[contains(@class,'p-toast-detail')]";

	// grid value

	public String gridval_coursetitle = "//div[@class='col-td-large ng-star-inserted']";
	// details button
	public String btn_details = "//span[@class='p-button-icon pi pi-chevron-down']";
	// details link
	// view process students request
	public String link_stre = "//span[@class='item-link'][1]";
	public String splitbutton = "//p-splitbutton//button[2]";
	
	public String view_modify_btn="//span[text()='View/Process student request to join']";
	// tab heading
	public String headtab_studentrequest = "//span[contains(text(),'Requests from Students for Enrollment')]";
	// coursetitle
	public String headlbl_course = "//div[@id='rseCourseNameValue']";
	// courselabel
	public String lbl_course = "//label[@id='rseCourseNameLabel']";
	// label Display Students whose request were
	public String lbl_Displaystu = "//div[@id='rseCourseNameValue']//following::label[1]";

	// Searchbox

	public String searchbox = "//input[@id='studentRequestsSearch']";
	public String searchbox_lbl = "//input[@id='studentRequestsSearch']";

	// grid label

	public String gridlabel_1 = "//div[@id='studentRequestsDisplayTable']//following::thead[1]//child::th[2]";
	public String gridlabel_2 = "//div[@id='studentRequestsDisplayTable']//following::thead[1]//child::th[3]";
	public String gridlabel_3 = "//div[@id='studentRequestsDisplayTable']//following::thead[1]//child::th[4]";
	public String gridlabel_4 = "//div[@id='studentRequestsDisplayTable']//following::thead[1]//child::th[5]";
	public String gridlabel_5 = "//div[@id='studentRequestsDisplayTable']//following::thead[1]//child::th[6]";
	public String gridlabel_6 = "//div[@id='studentRequestsDisplayTable']//following::thead[1]//child::th[7]";
	public String gridlabel_7 = "//div[@id='studentRequestsDisplayTable']//following::thead[1]//child::th[8]";
	public String gridlabel_8 = "//div[@id='studentRequestsDisplayTable']//following::thead[1]//child::th[9]";

	// grid text
	public String grid_txt1 = "#studentRequestsDisplayTable > table > tbody > tr > td";
	// popup
	public String popup_addstu = "//p-tabview[@id='inviteStudentsPopup']/div[1]";
	// validation Message
	public String Validation_log = "//div[contains(@class,'p-toast-detail')]";
	public String pending_request_radiobtn="//p-radiobutton[@class='pending-enroll-radio-btn ng-untouched ng-pristine ng-valid'][1]//label";
	public String req_to_join_radiobtn="//p-radiobutton[@name='studentEnrollmentStatus'][2]//label";
	public String req_radiobtn="//*[@id='studentRequestTableListing']//p-radiobutton[2]//div//div[2]";
	//public String req_radiobtn="//*[@id='studentRequestTableListing']/div/div[1]/div[1]/div/div/p-radiobutton[2]/div/div[2]";
	
	public String serial_no2="//div[@id='studentRequestsDisplayTable']//tr/th[1]";
	public String date_requested2="//div[@id='studentRequestsDisplayTable']//th[2]";
	public String sudid_3="//div[@id='studentRequestsDisplayTable']//th[3]";
	public String first_name2="//div[@id='studentRequestsDisplayTable']//th[4]";
	public String last_name2="//div[@id='studentRequestsDisplayTable']//th[5]";
	public String email_id2="//div[@id='studentRequestsDisplayTable']//th[6]";
	public String status_2="//div[@id='studentRequestsDisplayTable']//th[7]";
	public String approve_decline_on="//div[@id='studentRequestsDisplayTable']//th[8]";
	
	public String course_label="//label[@id='rseCourseNameLabel']";
	public String disp_stud_whose_req_where_label="//label[@class='student-request-label gray-color']";
	public String approve_label="//label[text()='Approved']";
	public String decline_label="//label[text()='Declined']";
	//public String splitbutton;

}
