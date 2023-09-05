package Course.Pages;

import org.openqa.selenium.By;

import SPRautomation.StudentPeerReview.basePage;

public class EditCoursePage extends basePage {

	// buttons
	// course details button
	//public String btn_coursedetails = "//ul[contains(@class,'p-menu-list p-reset')]//child::li[1]";
	//	public String btn_coursedetails = "li[@class='p-highlight ng-star-inserted']";
	public String btn_coursedetails="//span[text()='View/Modify Course Details']";
	public String splitbutton = "//p-splitbutton//button[2]";
	public String btn_coursedetails2 = "tbody > tr:nth-child(2) > td:nth-child(8) > p-splitbutton > div > button.p-splitbutton-menubutton";
	// Course details page
	// Assessment
	public String btn_Assessment = "//button[@id='assessment']";
	public String btnlbl_Assessment = "//span[contains(text(),'Assessment')]";
	public String btn_edit = "//p-button[@id='courseEdit']";
	public String btn_discardchanges = "//button[@id='discardCourseEdit']";
	public String btnlbl_discard = "//button[@id='discardCourseEdit']";
	public String btnsave = "//button[@id='updateCourse']";
	public String btnlbl_save = "//button[@id='updateCourse']";
	public String popupheadinglbl = "#tstAlertBox > div.modal-header > h4";

	public String Details_drop = "tbody > tr:nth-child(1) > td:nth-child(8) > p-splitbutton > div > button.p-splitbutton-menubutton";
	public String split_btn="(//button[@class='p-splitbutton-menubutton p-button p-component p-button-icon-only']//child::span)[1]";
	public String Details_drop1 = "tbody > tr:nth-child(2) > td:nth-child(8) > p-splitbutton > div > button.p-splitbutton-menubutton";
	public String view_studrequest="//span[text()='View/Process student request to join']";
	public String modify_course = "p-splitbutton > div > p-menu > div > ul > li:nth-child(1) > a > span";
	public String val_3 = "//div[@class='p-error small']";
	// toaster
	// toaster message-Course details updated successfully
	// public String toaster_1 = "//div[contains(text(),'Course details updated
	// successfully')]";
	public String toaster = "//div[contains(@class,'p-toast-detail')]";

	// Course details
	public String heading_coursedetails = "//i[@id='courseDetailsIcon']//following::span[1]";

	// labels
	public String label_1 = "//*[@for='courseTitle']";
	public String label_2 = "//*[@for='courseCode']";
	public String label_3 = "//*[@for='courseSection']";
	//public String label_3 = "//input[@id='courseSection']";
	public String label_4 = "//*[@for='department']";
	public String label_5 = "//*[@for='district']";
	public String label_6 = "//*[@for='specialNotes']";

	// Active button
	public String active_btn = "//p-inputswitch[@id='setCourseStatus']";
	// labels-Confirmation
	public String lbl_confirmation = "p-confirmdialog > div > div > div.p-dialog-header > span";
	// label-Are you sure that you want to change the course status?
	public String confirmation_text = "p-confirmdialog > div > div > div.p-dialog-content> span";

	// yes button
	public String btnyes = "button.p-confirm-dialog-accept";
	// No button
	public String btnNo = "button.p-confirm-dialog-reject";

	// back to course listings button
	public String backbtn = "//button[@id='cancelStudentRequest']/span[1]";

	// course name
	public String coursename = "//div[@class='col-td-large ng-star-inserted']";

	// Course status dropdown
	//	public String coursestatus_dd = "//p-dropdown[@id='courseStatusDropDown']/div/span";
	public String coursestatus_dd ="#courseStatusDropDown > div > span";

	// Inactive dropdown
	public String dd_inactive = "p-dropdownitem:nth-child(2) > li > span";
	public String ddactive="ul > p-dropdownitem:nth-child(1) > li";
	// button-active
	public String btn_active = "//input[@id='active']";

	// Edit page delete functionality
	// button delete
	public String btn_deletee = "//p-button[@id='courseDelete']";

	// Mange course
	
	public String manag_assess = "p-splitbutton > div > p-menu > div > ul > li:nth-child(4) > a > span";
	
	// confirmation popup
	public String confm_popup = "div.p-confirm-dialog";
	// label-confirmation
	public String confirmationlbl = "p-confirmdialog > div > div > div.p-dialog-header > span";
	// popup text-Are you sure that you want to delete this course?
	public String delete_popuptxt = "p-confirmdialog > div > div > div.p-dialog-content> span";
	// yes button
	public String delete_yes = "button.p-confirm-dialog-accept";
	// No button
	public String delete_No = "button.p-confirm-dialog-reject";

	// delete button course delete
	public String delete_btn = "//p-button[@id='courseDelete']";

	//
	public String stud_request_enrollment="//span[text()='Requests from Students for Enrollment']";
	//public String stud_enroll="//*[@id=\"courseListingTable\"]/div/div[1]/table/tbody/tr[1]/td[8]/p-splitbutton/div/p-menu/div/ul/li[3]/a/span";
	public String stud_enroll ="//div/ul/li[3]/a/span";
	public String pending_request_checkbox="//p-radiobutton[@class='pending-enroll-radio-btn ng-untouched ng-pristine ng-valid'][1]//label";
	
	public String course_name="//*[@id=\"rseCourseNameValue\"]";
	public String checkbox_2="//p-radiobutton[@name='studentEnrollmentStatus'][2]//label";
	
	public String approve_btn="//p-button[@id='approveReqBtn']";
	public String decline_btn="//p-button[@id='declineReqBtn']";
	public String search_box="//input[@id='studentRequestsSearch']";
	public String search_label="//*[@id=\"studentRequestsSearch\"]";
	
	public String serial_no="//*[@id='studentRequestsDisplayTable']//tr/th[2]";
	public String date_requested="//div[@id='studentRequestsDisplayTable']//th[3]";
	public String stu_id="//div[@id='studentRequestsDisplayTable']//th[4]"; 
	public String first_name="//div[@id='studentRequestsDisplayTable']//th[5]";
	public String last_name="//div[@id='studentRequestsDisplayTable']//th[6]";
	public String email_id="//div[@id='studentRequestsDisplayTable']//th[7]";
	public String no_result="//div[@id='studentRequestsDisplayTable']//tr//td";
	
	//TCSPR070221
	
	public String radio_btn2="//p-radiobutton[@name='studentEnrollmentStatus'][2]//div//div[2]";
	public String serial_no2="//div[@id='studentRequestsDisplayTable']//tr/th[1]";
	public String date_requested2="//div[@id='studentRequestsDisplayTable']//th[2]";
	public String sudid_3="//div[@id='studentRequestsDisplayTable']//th[3]";
	public String first_name2="//div[@id='studentRequestsDisplayTable']//th[4]";
	public String last_name2="//div[@id='studentRequestsDisplayTable']//th[5]";
	public String email_id2="//div[@id='studentRequestsDisplayTable']//th[6]";
	public String status_2="//div[@id='studentRequestsDisplayTable']//th[7]";
	public String approve_decline_on="//div[@id='studentRequestsDisplayTable']//th[8]";
	
	public String approve_btn_enabled="//p-checkbox[@id='isApproved']";
	public String decline_btn2="(//p-checkbox[@class='ng-untouched ng-pristine ng-valid'])[2]";
	
	public String course_label="//label[@id='rseCourseNameLabel']";
	public String disp_stud_whose_req_where_label="//label[@class='student-request-label gray-color']";
	public String approve_label="//label[text()='Approved']";
	public String decline_label="//label[text()='Declined']";
	
	public String new_course="//div[@id='rseCourseNameValue']";
	
	public String sp="//div[@class='p-splitbutton p-component']//button[2]";
	
	public String back_btn="//button[@id='cancelStudentRequest']//span[2]";
	
	
	
	// To delete course
	public void Deletecourse() {
		driver.findElement(By.xpath("//span[@class='p-button-icon pi pi-chevron-down']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Delete Course')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).click();
		waitThread(1000);
	}

	// Edit page delete course
	public void EditpageDeletecourse() {

		driver.findElement(By.id("courseDelete")).click();
		driver.findElement(By.cssSelector("button.p-confirm-dialog-accept")).click();
		waitThread(5000);
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


