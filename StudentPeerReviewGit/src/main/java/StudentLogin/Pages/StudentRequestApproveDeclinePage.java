package StudentLogin.Pages;

import SPRautomation.StudentPeerReview.basePage;

public class StudentRequestApproveDeclinePage extends basePage {

	// Grid Text
	public String gridemptytext = "//h4[contains(@class,'no-data-color no-course')]";

	// Request send tab
	public String requestsendtab = "//ul[@class='p-tabview-nav']//child::li[2]";

	// Request count
	public String requestcount = "//span[contains(@class,'p-badge-no-gutter')]";
	public String requestcount1 ="//*[@id='studentReqCount']/span";

	// Invite card
	public String invitecard = "//div[contains(@class,'student-common-box')]";

	// Course name
	public String coursename = "//div[contains(@class,'product-item-content')]//child::h6";
	

	// course ID
	public String courseid = "//div[contains(@class,'product-item-content')]//child::p[1]";
	public String courseid1 = "//*[@id=\"pr_id_11\"]/div/div/div/div/div/div/div/div/p[1]";

	// Request send date
	public String requestsenddate = "//div[contains(@class,'product-item-content')]//child::p[2]";

	// Teacher name
	public String teachername = "//div[contains(@class,'product-item-content')]//child::p[3]";

	// cancel button
	public String btncancel = "//button[contains(@class,'btn btn-danger')]";

	// buttons
	public String navarrowbtn = "//div[@class='username']";
	public String accountsettingsbtn = "//i[@class='fas fa-user-circle']";
	public String Studentiddetails = "//button[@id='delete']//preceding::p-toast//following::span[1]";

	// student request for enrollment details
	public String griddate = "//p-table[@id='p-tableGrid']//following::tbody[2]//child::td[3]//div";
	public String griddate_1="//*[@id='studentRequestsDisplayTable']/table/tbody/tr/td[8]/div/span";
	public String gridstudentid = "//p-table[@id='p-tableGrid']//following::tbody[2]//child::td[4]//div";
	public String studentfirstname = "//p-table[@id='p-tableGrid']//following::tbody[2]//child::td[5]//div";
	public String studentlastname = "//p-table[@id='p-tableGrid']//following::tbody[2]//child::td[6]//div";
	public String studentemail = "//p-table[@id='p-tableGrid']//following::tbody[2]//child::td[7]//div";
	public String studentemail_1 = "//p-table[@id='p-tableGrid']//following::tbody[2]//child::td[6]//div";
	public String status = "//p-table[@id='p-tableGrid']//following::tbody[2]//child::td[8]//div";
	public String status_1 = "//p-table[@id='p-tableGrid']//following::tbody[2]//child::td[7]//div";
	public String studentchkbx = "//p-table[@id='p-tableGrid']//following::p-tablecheckbox//div[2]";
	public String btnapprove = "//button[contains(@class,'p-button-success')]";
	public String btndecline = "//button[contains(@class,'p-button-danger')]";
	public String chkbxdeclined = "//button[@id='cancelStudentRequest']//following::p-checkbox[2]";
	public String chkbxapproved = "//button[@id='cancelStudentRequest']//following::p-checkbox[1]";
	public String searchboxgrid = "//input[@id='studentRequestsSearch']";
	public String declinecheckboxchecked = "//button[@id='cancelStudentRequest']//following::p-checkbox[2]//input";
	public String requestprocessedradiobtn="p-radiobutton.processed-radio-btn>div";
	// Toaster
	public String toaster = "//div[contains(@class,'p-toast-detail')]";

	// confirmation box
	public String confirmationbx = "p-confirmdialog > div > div";
	public String confirmationbx1 ="//*[@id='studentReqConfirmationDialog']/div/div";
	public String confirmationtxt = "p-confirmdialog > div > div > div.p-dialog-header > span";
	public String confirmationtxt1 = "//*[@id='studentReqConfirmationDialog']//div[2]//span";
	public String btnNo = "button.p-confirm-dialog-reject";
	public String btnYes = "button.p-confirm-dialog-accept";

	// Enrolled Box
	public String enrolledbox = "//div[contains(@class,'student-common-box enrolled-box')]";
	public String coursenamebox = "//div[contains(@class,'student-common-box enrolled-box')]//child::div[1]";
	public String detailsbox = "//div[contains(@class,'student-common-box enrolled-box')]//child::div[2]";
	public String teachernamechip = "//div[contains(@class,'student-common-box enrolled-box')]//child::div[3]";
    // Confirmation close button
	
	public String closecnfrm = "//p-confirmdialog[@id=\"studentReqConfirmationDialog\"]/div/div/div[1]/div/button";
	public String closecnfrmnew = "//p-confirmdialog[@id=\"studentReqConfirmationDialog\"]/div/div/div[1]/div/button";
}
