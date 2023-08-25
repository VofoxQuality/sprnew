package Course.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import SPRautomation.StudentPeerReview.basePage;

public class CreateNewCoursePage extends basePage {
	public String userdirectory;
	// Toaster messages

	public String toaster = "//div[contains(@class,'p-toast-detail')]";
	public String toasterclosebtn = "//*[contains(@class,'p-toast-icon-close-icon')]";
	public String toasterinvalid="//div[contains(text(),'Invalid file format')]";
	// Student Profile Page

	// Labels
	public String lbl_joincourse = "//div[@id='joinNewCourseTxt']";
	public String btnlbl_joincourse = "//button[@id='joinNewCourseBtn']";
	public String course_name = "//p-carousel[@id='requestReceivedCarousel']//following::h6[1]";
	public String lbl_requestsend = "#studentRequestPopup > h3";
	public String lbl_popup = "#studentRequestPopup > div";
	
	// Buttons
	public String btn_acceptcourse = "//button[@class='btn outline-btn float-right']";
	public String box_confirmation = "#studentReqConfirmationDialog > div > div";
	public String popupbtn_Yes = "button.p-confirm-dialog-accept";
	public String btn_sendrequest = "//button[@id='joinCourse']";
	public String popupbtn_close = "span.p-dialog-header-close-icon";
	// buttons
	// create new course
	public String btn_createnew = "//p-button[@id='createNewCourseBtn']";
	public String searchbx = "//input[@id='searchCourseFilterMain']";

	// create course
	//public String btn_Createcourse = "//button[@id='createCourse']";
	public String stud_chip="//*[@id='studentsInvitedChip']";
	public String btn_Createcourse="//*[@id='createCourse']//span";
	public String btn_Createcourse1="//*[@id='sendRequestId']";
	public String btn_createcourse2="//button[@id='createCourse']";
	public String btnlbl_Createcourse = "//button[@id='createCourse']//child::span[1]";
	public String btn_cancel = "//button[@id='cancelCourseAdd']";
	public String btnlbl_cancel = "//button[@id='cancelCourseAdd']/span";
	public String btnsendrequest1="//button[@id='sendRequestId']";	
	// Add students
	public String btn_AddStudents = "//button[@id='inviteStudent']";
	public String btnlbl_Addstudents = "//button[@id='inviteStudent']/span[2]";

	// details button
	public String btn_details = "//div[@class='p-splitbutton p-component']";
	public String btn_details_1 = "p-splitbutton > div > button.p-splitbutton-menubutton";
	// View/Modify Student Roster
	public String link_lbl_1 = "p-splitbutton > div > p-menu > div > ul > li:nth-child(1) > a > span";
	// View/Process Student requests
	public String link_lbl_2 = " p-splitbutton > div > p-menu > div > ul > li:nth-child(2) > a > span";
	// Manage Assessments
	public String link_lbl_3 = " p-splitbutton > div > p-menu > div > ul > li:nth-child(4) > a > span";
	// Delete Course
	public String link_lbl_4 = " p-splitbutton > div > p-menu > div > ul > li:nth-child(5) > a > span";
	public String link_lbl_5 = " p-splitbutton > div > p-menu > div > ul > li:nth-child(3) > a > span";
	// course button on header
	public String btnheader_course = "//div[@id='navbar-menu']/div/a[1]";
	
	public String btnheader_assessment="//div[@id='navbar-menu']/div/a[2]";

	// eye icon
	public String eyeicon = "//i[@class='fas fa-info-circle']";

	// page headings
	// Create new course
	public String Headinglbl_1 = "div.page-title";

	// labels
	// Create new course-button label
	public String btnlbl_createnew = "//p-button[@id='createNewCourseBtn']//child::span[2]";

	public String lbl_coursestatus = "//div[@id='teacherCoursePageFilters']//following::label[1]";
	public String lbl_grid = "//div[@id='courseMainTableTeacher']//following::tbody//td";
	public String lbl_courseid = "//div[@id='courseMainTableTeacher']//following::thead//th[2]/div";
	public String lbl_coursetitle = "//div[@id='courseMainTableTeacher']//following::thead//th[3]/div";
	public String lbl_district = "//div[@id='courseMainTableTeacher']//following::thead//th[4]/div";
	public String lbl_department = "//div[@id='courseMainTableTeacher']//following::thead//th[5]/div";
	public String lbl_Enrolled = "//div[@id='courseMainTableTeacher']//following::thead//th[6]/div";
	public String lbl_Studentrequests = "//div[@id='courseMainTableTeacher']//following::thead//th[7]/div";
	public String lbl_Actions = "//div[@id='courseMainTableTeacher']//following::thead//th[7]/div/following::th";

	// Textboxe labels
	public String txbxlbl_coursetitle = "//input[@id='courseTitle']/following::label[1]";
	public String txtbxlbl_CourseCode = "//input[@id='courseCode']/following::label[1]";
	public String txtbxlbl_department = "//input[@id='department']/following::label[1]";
	public String txtbxlbl_district = "//input[@id='district']/following::label[1]";
	public String tctbxlbl_Coursesec = "//input[@id='courseSection']/following::label[1]";
	public String tctbxlbl_Special = "//input[@id='specialNotes']/following::label[1]";

	// Textboxes
	public String txbx_Coursetitle = "//input[@id='courseTitle']";
	public String txtbx_Coursecode = "//input[@id='courseCode']";
	public String txtbx_Coursesec = "//input[@id='courseSection']";
	public String txtbx_dep = "//input[@id='department']";
	public String txtbx_district = "//input[@id='district']";
	public String txtbx_special = "//input[@id='specialNotes']";

	// Course code
	public String course_Id = "//div[contains(@class,'section-title course-copy')]//child::span";
	// course code copy option
	public String coursecopy = "//i[@id='copy']";
	public String coursecopy1 = "//i[@class='pi pi-copy']";

	// Alertpopup box
	public String popupbx = "#tstAlertBox";
	public String popuptxt = "#tstAlertBox > div.modal-body";
	// popuplabel
	public String discardchanges = "#tstAlertBox > div.modal-header > h4";
	public String popupbtnDiscard = "//button[@class='btn1']";
	public String popupbtnCancel = "//button[@class='btn2']";

	// Required field validation message
	public String val_1 = "//div[@class='p-error small']";
	public String val_3="//input[@id='courseTitle']//following::small[1]";
	// special note value
	public String val_2 = "//div[@id='courseMainTableTeacher']//following::tbody[2]//td[5]/div";

	// Grid values
	// Course title
	public String value_coursetitle = "#courseListingTable > div > div.p-datatable-wrapper > table > tbody > tr:nth-child(1) > td:nth-child(3) > div > span";
	public String course_title2="#courseListingTable > div > div.p-datatable-wrapper.ng-star-inserted > table > tbody > tr:nth-child(2) > td:nth-child(3) > div > span";

	// submenu button-course landing page
	public String btn_submenu = "//button[contains(@class,'p-button-rounded')]";

	// grid labels
	// Course Code
	public String gridlabel1 = "//div[@id='courseMainTableTeacher']//following::thead[2]//th[1]/div";
	// Course Section
	public String gridlabel2 = "//div[@id='courseMainTableTeacher']//following::thead[2]//th[2]/div";
	// Invited & Not Accepted
	public String gridlabel3 = "//div[@id='courseMainTableTeacher']//following::thead[2]//th[3]/div";
	// Suspended
	public String gridlabel4 = "//div[@id='courseMainTableTeacher']//following::thead[2]//th[4]/div";
	// Special Notes
	public String gridlabel5 = "//div[@id='courseMainTableTeacher']//following::thead[2]//th[5]/div";
	// Created
	public String gridlabel6 = "//div[@id='courseMainTableTeacher']//following::thead[2]//th[6]/div";
	// Modified
	public String gridlabel7 = "//div[@id='courseMainTableTeacher']//following::thead[2]//th[7]/div";

	// searchbox-Landing page
	public String searchbx_1 = "//input[@id='searchCourseFilterMain']";
	
	
	//Email Edit popup 
	public String Email_chip="#inviteStudentChipArea > p-chips > div > ul > li.p-chips-token > div > span";
	public String Emaileditpopup="div.p-dialog-content > app-invite-student > div.ng-star-inserted > p-dialog > div > div";
	public String editpopupheading=" app-invite-student > div > p-dialog > div > div > div.p-dialog-header>span";
	public String Emailtext_bx="//label[@id='nameLabel']/following::input";
	public String update_btn="//app-courses-add-edit/div[5]/p-dialog/div/div/div[2]/app-invite-student/div[2]/p-dialog/div/div/div[3]/button[1]";
	public String cancel_btn="#cancelStudentAddBtn";
	public String label="//label[@id='nameLabel']";
	public String validation_msg="//label[@id='nameLabel']/following::input/following::small";

	// popup-Addstudents

	public String popupAddstudents = "//p-tabview[@id='inviteStudentsPopup']/div[1]";
	// heading label
	public String headinglabel = "//p-tabview[@id='inviteStudentsPopup']//preceding::p-header";
	// Invite New Students
	public String lbl_invite = "//p-tabview[@id='inviteStudentsPopup']/div/ul/li[1]/a/span[2]";
	// Invite Students from my existing courses
	public String lbl_Add_stud = "//p-tabview[@id='inviteStudentsPopup']/div/ul/li[2]/a/span[2]";
	// Invite New Students-link
	public String tab_invite = "//p-tabview[@id='inviteStudentsPopup']/div/ul/li[1]/a";
	// Add students from 'My Students' List
	public String tab_Addstudent = "//p-tabview[@id='inviteStudentsPopup']/div/ul/li[2]/a";
	public String taballcheckbx = "//thead[@class='p-datatable-thead']//child::p-tableheadercheckbox//div[2]";
	// Enter / copy-paste / import Email IDs below to invite students
	public String tab_label_1 = "//p-card[@id='inviteNewStudentsCard']/div/div/div/div/div[1]";
	// textbox-tab
	public String tab_textbox = "//input[@id='inviteStudentChip']";
	public String tab_txtbx = "//p-chips[@inputid='inviteStudentChip']//following::ul";
	
	// Textbox
	public String emailtype_txt = "//input[@id='inviteStudentChip']";
	
	//confirmation popup yes button
	public String confirmyesbtn="button.p-confirm-dialog-accept";
	
	// cancel-button-Tab
	public String tab_btn_cancel = "//button[@id='cancelStudentAddBtn']";
	// Add to list
	public String tab_btn_Addtolist = "//button[@id='addToListBtn']";
	public String tablbl_addtolist = "//button[@id='addToListBtn']/span";
	// button import
	public String btn_import = "//p-button[@id='importButton']";
	// button label
	public String btnlbl_import = "//p-button[@id='importButton']//child::span[2]";
	// close button-popup
	public String btnpopup_close = "//span[contains(@class,'p-dialog-header-close-icon')]";
	// popup-search
	public String btnpopup_search = "//input[@id='searchInput']";
	// email-grid value-popup
	public String grid_value_1 = "//p-chips[@inputid='studentsInvitedChip']//child::li[1]/div/span";
	// Email grid value-create new course page
	public String grid_value_2 = "//p-chips[@inputid='studentsInvitedChip']//child::li[2]/div/span";
	public String grid_value_3 = "//p-chips[@inputid='studentsInvitedChip']//child::li[3]/div/span";
	// label-New Students to be invited to this class
	public String lbl_newstudinv = "#studentDetails > p-card > div > div > div > div > div:nth-child(1)";
	// label-Students from My Student list
	public String lbl_studfrommystud = "#studentDetails > p-card > div > div > div.p-card-content > div > div:nth-child(3)";

	// Add students from my student list
	public String lbl_SIno = "#myStudentListTableCustomId > table > thead > tr > th:nth-child(2)";
	public String lbl_studentID = "#myStudentListTableCustomId > table > thead > tr > th:nth-child(3)";
	public String lbl_Firstname = "#myStudentListTableCustomId > table > thead > tr > th:nth-child(4)";
	public String lbl_LastName = "#myStudentListTableCustomId > table > thead > tr > th:nth-child(5)";
	public String lbl_Email = "#myStudentListTableCustomId > table > thead > tr > th:nth-child(6)";
	public String gridtxt_1 = "#myStudentListTableCustomId > table > tbody > tr > td";

	// links
	// Delete Course
	public String link_deletecourse = "p-splitbutton > div > p-menu > div > ul > li:nth-child(5) > a";
	public String link_deletecourse1 = "p-splitbutton > div > p-menu > div > ul > li:nth-child(5) > a";
	// View/Modify Student Roster
	public String link_view_modify = "p-splitbutton > div > p-menu > div > ul > li:nth-child(1) > a";
	// View/Process Student requests
	public String link_viewprocess = "p-splitbutton > div > p-menu > div > ul > li:nth-child(2) > a";

	// course delete confirmation popup
	
	// confirmation popup
	public String confm_popup = "p-confirmdialog > div > div";
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
	public String detailssplit_btn = "button.p-splitbutton-defaultbutton";
	// yes buttoncourse details page
	public String yes_details = "button.p-confirm-dialog-accept";

	public String value1 = "//*[@class='p-chips-token ng-star-inserted']/div/span";
	public String mystudent1 = "//p-chips[@inputid='studentsAddedChip']//div/ul/li[1]/span[1]";
	public String mystudent2 = "//p-chips[@inputid='studentsAddedChip']//div/ul/li[2]/span[1]";
	
	
	//Assessment pop up
	
	public String nocoursepopup="//div[@id='noCoursesInner']";
	public String nocoursepopuptxt="#ranOutSub > h6";
	public String btn_ok="//p-button[@id='backToCourses']";

	// To get grid labels
	public String gridvalue(int index) {

		List<WebElement> val = driver.findElements(By.xpath("//div[@class='col-td-medium ng-star-inserted']"));
		String namevalue = val.get(index).getText();
		return namevalue;

	}

	// To get grid labels
	public String tabname(int index) {

		List<WebElement> val = driver.findElements(By.xpath("//*[@class='p-tabview-nav-link p-ripple']/span[2]"));
		String tabname1 = val.get(index).getText();
		return tabname1;

	}

	// To get email text from textbox
	public String emailvalue(int index) {

		List<WebElement> val = driver.findElements(By.xpath("//*[@class='p-chips-token ng-star-inserted']/div/span"));

		String emails = val.get(index).getText();
		return emails;

	}

	/*
	 * Method to get system date
	 */

	public String getdate() {

		DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

	// To upload file
	public void fileupload(String filename) {

		waitThread(3000);
		WebElement browse = driver.findElement(By.xpath("//input[@type='file']"));
		userdirectory = System.getProperty("user.dir");
		// click on ‘Choose file’ to upload the desired file
		browse.sendKeys(userdirectory + "\\Documentfiles\\" + filename);
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
