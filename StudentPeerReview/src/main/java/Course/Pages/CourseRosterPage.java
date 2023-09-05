package Course.Pages;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.Generalmethods.Databaseconnection;

import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;

public class CourseRosterPage extends basePage {
	SignUpPage sp = new SignUpPage();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	public String Email;
	public String otp;

	// Toaster
	public String toaster = "//div[contains(@class,'p-toast-detail')]";
	//public String toaster="/p-toastitem/div/div/div/div[2]";
	// Link course roster
	public String link_courseroster = "p-splitbutton > div > p-menu > div > ul.p-menu-list > li:nth-child(2)>a";

	// Email value grid
	public String emailval_1 = "//div[@class='p-chips p-component']//child::div";
	
	public String emailvalue_1="//*[@id='newStudentsChipsMain']/p-chips/div/ul/li[1]/div/span";

	// Heading course roster
	public String heading_courseroster = "//ul[@class='p-tabview-nav']//child::li[2]/a/span";

	// labels
	public String lbl_course = "//div[@id='courseNameDiv']/label";
	public String course_name = "//div[@id='courseNameSection']";
	public String lbl_enrolled = "//label[@id='enrolledId']";
	public String lbl_InvitedNotAccepted = "//p-radiobutton[@id='invitedNot']//following::label[1]";
	public String lbl_suspended = "//*[@id='labelSuspended']";
	public String btnlbl_addstud = "//i[@id='userPlus']//following::text()[1]";
	public String gridtext = "//p-table[@id='p-tableGrid']//child::td[1]";
	public String gridtext_2="//*[@id=\"p-tableGrid\"]/div/div[1]/table/tbody/tr/td";

	// Tooltip
	public String Tooltipinvite = "//i[@ptooltip='Invite more students']";

	// Radio buttons
	public String check_radiobtn_enrolled = "//p-radiobutton[@id='enrolled']//child::input[1]";
	public String radiobtn_enrolled = "//p-radiobutton[@id='enrolled']";
	public String radiobtn_invited = "//p-radiobutton[@id='invitedNot']";
	public String check_radiobtn_invites = "//p-radiobutton[@id='invitedNot']//child::input[1]";
	public String radiobtn_suspended = "//p-radiobutton[@id='suspended']//child::input[1]";
	public String radiobtn__suspended = "//p-radiobutton[@id='suspended']";
	public String All_checkbox = "//p-table[@id='p-tableGrid']//child::p-tableheadercheckbox";

	// Buttons
	public String btn_Addstudent = "//p-button[@id='btnicop']//child::button";
	public String searchbox = "//*[@id='courseRoasterSearchBox']";
	public String placeholder_search = "//input[@placeholder='Search Student']";
	public String btn_Action = "//a[@id='undefined_header']";
	public String btnlbl_Action = "//a[@id='undefined_header']//child::span[2]";
	public String btn_backtocourse = "//button[@id='cancelStudentRequest']";
	public String lbl_backtocourse = "//button[@label='Back to Course Listings']";

	// Dropdown and dropdown labels
	public String Actiondropdown = "//div[@id='undefined_content']";
	public String link_Suspendstudents = "//div[@id='undefined_content']//child::li[1]";
	public String lbl_suspendedstudents = "//div[@id='undefined_content']//child::li[1]/a/span[2]";

	public String link_Reenrollstudents = "//div[@id='undefined_content']//child::li[2]";
	public String lbl_Reenrollstudents = "//div[@id='undefined_content']//child::li[2]//span[2]";

	public String link_Resendinvitation = "//div[@id='undefined_content']//child::li[3]";
	public String lbl_Resendinvitation = "//div[@id='undefined_content']//child::li[3]//span[2]";

	public String link_Removestudents = "//div[@id='undefined_content']//child::li[4]";
	public String lbl_Removestudents = "//div[@id='undefined_content']//child::li[4]//span[2]";

	public String link_Revokeinvitations = "//div[@id='undefined_content']//child::li[5]";
	public String lbl_Revokeinvitations = "//div[@id='undefined_content']//child::li[5]//span[2]";

	// Table headings
	public String lbl_Sino = "//p-table[@id='p-tableGrid']//child::th[2]";
	public String lbl_StudentID = "//p-table[@id='p-tableGrid']//child::th[3]";
	public String lbl_Firstname = "//p-table[@id='p-tableGrid']//child::th[4]";
	public String lbl_lastname = "//p-table[@id='p-tableGrid']//child::th[5]";
	public String lbl_Emailid = "//p-table[@id='p-tableGrid']//child::th[6]";
	public String lbl_Enrolledvia = "//p-table[@id='p-tableGrid']//child::th[7]";
	public String lbl_Invitationsendon = "//p-table[@id='p-tableGrid']//child::th[7]";
	public String gridlbl_nostud = "//p-table[@id='p-tableGrid']//child::td";
	public String lbl_invitationstatus = "//p-table[@id='p-tableGrid']//child::th[8]";
	public String lbl_selected = "//label[@id='selectedId']";
	public String lblvalue_selected = "//input[@id='selectedGridId']";

	// Grid values
	public String gridvalue_email = "//*[@id='p-tableGrid']/div/div[1]/table/tbody/tr[1]/td[6]/div[2]/span";
	public String gridvalue_studentid = "//p-table[@id='p-tableGrid']//child::td[3]//div[1]";
	public String gridvalue_firstname = "//p-table[@id='p-tableGrid']//child::td[4]//div[1]";
	public String gridvalue_lastname = "//p-table[@id='p-tableGrid']//child::td[5]//div[1]";
	public String invited_senddate = "//p-table[@id='p-tableGrid']//child::td[7]//div[1]";
	public String lbl_notaccepted = "table > tbody > tr > td:nth-child(8) > div > div";

	// check boxes
	public String studentchkbx_1 = "//p-table[@id='p-tableGrid']//following::p-tablecheckbox//div[2]";

	// Add students to course

	// Buttons and labels
	public String btn_Addstudents = "//*[@id='roasterInviteMoreStudents']//button";
	public String btn_Addstudents_in = "//*[@id=\"roasterInviteMoreStudents\"]/button";
	public String Addstudentbtn_tooltip = "//*[@id='inviteMoreStudentsDiv']/i";
	public String Addstudents_window = "//button[@id='cancelStudentRequest']//parent::div";
	public String Addstud_windowclosebtn = "//button[contains(@class,'p-dialog-header-close')]";
	public String Addtolist_btn = "//*[@id='addToListBtn']";
	public String Window_coursename = "//*[@id='cancelStudentRequest']//parent::div//p-header";
	public String lblWindow_text1 = "div.d-flex.justify-content-md-center";
	public String lblWindow_text2 = "//*[@id='importButton']//child::span[2]";
	public String importbtn = "//*[@id='importButton']";
	public String addstud_searchbox = "//*[@id='importButton']//following::div[1]//span";
	public String addstud_searchbox_txt = "//*[@id='importButton']//following::div[1]//input";
	public String btn_cancel = "//button[@id='cancelStudentAddBtn']";
	public String invitetab = "//p-tabview[@id='inviteStudentsPopup']//child::li[1]/a";
	public String Addstudentstab = "//p-tabview[@id='inviteStudentsPopup']//child::li[2]/a";
	public String yes_btn="//p-confirmdialog/div/div/div[3]/button[2]";

	// Add students to course Grid labels
	public String gridlbl_Sino = "//*[@id='myStudentListTableCustomId']/table/thead/tr/th[2]";
	public String gridlbl_course_title="//button[@id='cancelStudentRequest']//following::p-tabview//child::thead//th[3]/div";

	public String gridlbl_studentid = "//*[@id='myStudentListTableCustomId']/table/thead/tr/th[3]/div";
	public String gridlbl_firstname = "//*[@id='myStudentListTableCustomId']/table/thead/tr/th[4]/div";
	public String gridlbl_lastname = "//*[@id='myStudentListTableCustomId']/table/thead/tr/th[5]/div";
	public String gridlbl_email = "//*[@id='myStudentListTableCustomId']/table/thead/tr/th[6]/div";
	public String gridlbl_nostudfound = "//button[@id='cancelStudentRequest']//following::p-tabview//child::thead//following::tr[2]";
	// Email chips
	public String Emailchip_1 = "//p-chips[@inputid='inviteStudentChip']//child::li[1]";
	public String Emailchip_2 = "//p-chips[@inputid='inviteStudentChip']//child::li[2]";
	public String Emailchip_3 = "//p-chips[@inputid='inviteStudentChip']//child::li[3]";
	public String Emailchip_4 = "//*[@id='inviteStudentChipArea']/p-chips/div/ul/li[4]/div/span";
	public String chip_1 = "//input[@id='inviteStudentChip']";
	public String gridsearchbox = "//input[@id='searchEmailInput']";
	public String gridsearchbox1 = "//input[@id='searchInput']";
	public String previewsearchbx="//input[@id='previewSearchBox']";
	public String rowcountinvite = "//p-table[@id='p-tableGrid']//child::table//tbody//tr";

	// Preview tab
	public String preview_tab = "#previewStudentsAddedPopupCustomId";
	public String lbl_preview = "//*[@id='previewStudentsAddedPopupCustomId']/div/span/p-header";
	public String previewlbl_course = "//label[@id='previewlabelId']";
	public String coursename_previewtab = "//label[@id='previewlabelId']//following::div[1]";
	public String preview_tab_labels_1 = "p-card > div > div > div > div > div:nth-child(1)";
	public String preview_tab_labels_2 = "p-card > div > div > div > div > div:nth-child(3)";
	public String btn_addmorestud = "//p-button[@id='previewInviteId']//child::button";
	public String previewsearchbox = "//input[@id='previewSearchBox']";
	public String btn_previewdiscard = "//button[@id='preivewDiscardId']";
	public String btnlbl_previewdiscard = "//button[@id='preivewDiscardId']//span";
	public String btn_previewsendrequest = "//button[@id='sendRequestId']";
	public String btnlbl_previewsendrequest = "//button[@id='sendRequestId']//span";
	public String popup_btn_close = "div.p-dialog-header > div > button > span";

	// preview tab Email chips
	public String preview_Emailchip_1 = "//*[@id='newStudentsChipsMain']/p-chips/div/ul/li[1]/div/span";
	public String preview_Emailchip_2 = "//*[@id='newStudentsChipsMain']/p-chips/div/ul/li[2]/div/span";
	public String preview_Emailchip_3 = "//*[@id='newStudentsChipsMain']/p-chips/div/ul/li[3]/div/span";
	public String preview_Emailchip_4 = "//*[@id='newStudentsChipsMain']/p-chips/div/ul/li[4]/div/span";
	public String Email_count = "//p-chips[@inputid='studentsInvitedChip']//div";

	// Invited and Accepted Grid Emails,date,labels
	public String grid_email_1 = "//*[@id='p-tableGrid']/div/div[1]/table/tbody/tr/td[6]/div[2]/span";
	public String grid_email_2 = "//p-table[@id='p-tableGrid']//child::tbody//child::tr[2]//td[6]//div";
	public String grid_email_3 = "//p-table[@id='p-tableGrid']//child::tbody//child::tr[3]//td[6]//div";
	public String grid_email_4 = "//p-table[@id='p-tableGrid']//child::tbody//child::tr[4]//td[6]//div";

	public String grid_date_1 = "//p-table[@id='p-tableGrid']//child::tbody//child::tr[1]//td[7]//div";
	public String grid_date_2 = "//p-table[@id='p-tableGrid']//child::tbody//child::tr[2]//td[7]//div";
	public String grid_date_3 = "//p-table[@id='p-tableGrid']//child::tbody//child::tr[3]//td[7]//div";
	public String grid_date_4 = "//p-table[@id='p-tableGrid']//child::tbody//child::tr[4]//td[7]//div";

	public String grid_label_1 = "//p-table[@id='p-tableGrid']//child::tbody//child::tr[1]//td[8]//div//div";
	public String grid_label_2 = "//p-table[@id='p-tableGrid']//child::tbody//child::tr[2]//td[8]//div//div";
	public String grid_label_3 = "//p-table[@id='p-tableGrid']//child::tbody//child::tr[3]//td[8]//div//div";
	public String grid_label_4 = "//p-table[@id='p-tableGrid']//child::tbody//child::tr[4]//td[8]//div//div";

	// Filter Button
	public String btn_filter = "//p-table[@id='p-tableGrid']//following::button";
	public String filter_popup = "//p-table[@id='p-tableGrid']//following::p-confirmdialog//following::div[1]";
	//public String filter_popup="//div[@class='ng-trigger ng-trigger-overlayAnimation ng-tns-c106-24 p-column-filter-overlay p-component p-fluid p-column-filter-overlay-menu ng-star-inserted']";
	public String all_dropdown = "//p-table[@id='p-tableGrid']//following::p-confirmdialog//following::p-multiselect";
	public String filter_lblNoaccount = "ul > p-multiselectitem:nth-child(1) > li > div.p-multiselect-invitationStatus-option > span";
	public String not_accepted="//p-columnfilterformelement/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[2]/li/div[1]/div";
	public String not_accept="//p-columnfilterformelement/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[2]/li/div[1]/div";
	public String not_accepted_chkbox="//p-columnfilterformelement/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[2]/li";
	public String filter_lblnotaccept = "ul > p-multiselectitem:nth-child(2) > li > div.p-multiselect-invitationStatus-option > span";
	public String filter_lbldeclined = "ul > p-multiselectitem:nth-child(3) > li > div.p-multiselect-invitationStatus-option > span";
	public String chkbx_noaccount = "ul > p-multiselectitem:nth-child(1) > li > div.p-checkbox";
	public String chkbx_noacc2="//p-columnfilterformelement/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[1]/li/div[1]/div";
	public String chkbx_lblnotaccept = "ul > p-multiselectitem:nth-child(2) > li > div.p-checkbox";
	public String chkbx_lbldeclined = "ul > p-multiselectitem:nth-child(3) > li > div.p-checkbox";
	public String checked_noaccount_chkbx = "ul > p-multiselectitem:nth-child(1) > li > div.p-checkbox>div";
	public String no_account="//div[2]//ul//p-multiselectitem[1]//li";
	public String no_account_unchecked="//p-multiselectitem[1]/li/div[1]/div[@class='p-checkbox-box']"; 
	public String chkbx_notaccepted = "ul > p-multiselectitem:nth-child(2) > li > div.p-checkbox";
	public String checked_notaccepted_chkbx = "ul > p-multiselectitem:nth-child(2) > li > div.p-checkbox>div";
	public String chkbx_declined = "ul > p-multiselectitem:nth-child(3) > li > div.p-checkbox";
	public String cheked_declined_chkbx = "ul > p-multiselectitem:nth-child(3) > li > div.p-checkbox>div";
	public String declined_dropdown_lbl = "p-columnfilterformelement > p-multiselect > div > div.p-multiselect-label-container > div";
	public String Noaccountdropdownlabel = "p-columnfilterformelement > p-multiselect > div > div.p-multiselect-label-container > div";
	//public String Notaccepteddropdownlabel = "p-columnfilterformelement > p-multiselect > div > div.p-multiselect-label-container > div";
	public String Notaccepteddropdownlabel= "//p-columnfilterformelement/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem[2]/li/div[2]";
	public String noaccount_dropdown="//p-columnfilterformelement/p-multiselect/div/div[3]/span";
	
	//public String Notaccepteddropdownlabel="//div[@class='p-multiselect-label ng-tns-c123-46']";
public String checkbox1="(//div[@class='p-checkbox-box']//span)[1]";
	/*
	 * Method to get system date
	 */

	public String getdate() {

		DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

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
