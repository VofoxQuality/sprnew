package CreateNewAssessment.Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

import SPRautomation.StudentPeerReview.basePage;

public class BasicDetailsAssessmentPage extends basePage {

	// Labels

	public String Assessmenttab = "//div[@id='navbar-menu']//child::a[2]";
	public String CourseTab = "//div[@id='navbar-menu']//child::a[1]";
	public String lbl_selectcourse = "//p-dropdown[@id='courseId']//preceding::label";
	public String lbl_assessmentname = "//p-dropdown[@id='courseId']//following::label[1]";
	public String lbl_assessment = "//h4[@class='page-title']";
	public String headinglbl_createnewassessment = "//div[starts-with(@class,'page-title flex')]";

	
	// Wizard
	public String WizardBasicdetails = "//*[@id='tstBasicDetailsStep']";
	public String Wizardlbl_basicdetails = "//*[@id='tstBasicDetailsStep']//child::span[2]";
	public String Basicdetailswizard = "//*[@id='stepperDiv']//child::li[1]";
	public String Questionwizard = "//*[@id='stepperDiv']//child::li[2]";
	public String btndiscard = "//p-button[@id='discardBtn']";
	public String btnsaveandexit = "//p-button[@id='saveExitBtn']";
	public String btnsaveandnext = "//p-button[@id='saveNextBtn']";
	public String stepperassessmentname = "//div[@id='tstQstnAssessmentDetailsSection']//child::h6";
	public String steppercoursename = "//div[@id='tstQstnAssessmentDetailsSection']//child::p";

	// Validation messages stepperassessmentname
	public String valmsg1 = "//p-dropdown[@id='courseId']//following::small[1]";
	public String valmsg2 = "//input[@id='assessmentName']//following::small";
	public String valmsg3 = "//div[@class='p-error small']";

	// Toaster
	public String toaster = "//div[contains(@class,'p-toast-detail')]";
	public String toasterclosebtn = "//*[contains(@class,'p-toast-icon-close-icon')]";

	// Discard popup

	public String Confirm_discardpopup = "div.p-confirm-dialog";
	public String Confirm_lbl_confirmation = "div.p-dialog-header > span";
	public String Confirm_txtpopup = "div.p-dialog-content > span";
	public String Confirm_btnNo = "button.p-confirm-dialog-reject";
	public String Confirm_btnYes = "button.p-confirm-dialog-accept";

    public String tabdiscardpopup = "//div[@id='tstAlertBox']";
    public String txt1popup = "//*[@id='tstAlertBox']/div[2]/p";
    public String btnDiscard = "//*[@id='tstAlertBox']/div[3]/button[1]";
    public String btnCancel = "//*[@id='tstAlertBox']/div[3]/button[2]";
  //span[@id='draft_asm_text']
    // Draft Page
	public String tabdraft = "p-tabview > div > ul.p-tabview-nav > li:nth-child(3)>a";
	public String draftcoursename = "//div[@id='draft_table_container']//following::tbody[1]//tr[1]//td[3]";
	public String draftassessmentname = "//div[@id='draft_table_container']//following::tbody[1]//tr[1]//td[4]";
	public String draftassessmentname2 = "//div[@id='draft_table_container']//following::tbody[1]//tr[2]//td[4]";
	public String createdondate = "//div[@id='draft_table_container']//following::tbody[1]//tr[1]//td[5]";
	public String modifydate = "//div[@id='draft_table_container']//following::tbody[1]//tr[1]//td[6]";
	public String btn_continueedit = "//div[@id='draft_table_container']//following::tbody[1]//tr[1]//*[@id='continue_edit_btn']";
	public String btn_continueedit1 = "//div[@id='draft_table_container']//following::tbody[1]//tr[2]//*[@id='continue_edit_btn']";
	public String Deletebtn = "//div[@id='draft_table_container']//following::tbody[1]//tr[1]//*[@id='draft_del_btn']";
	public String Deletebtn2 = "//div[@id='draft_table_container']//following::tbody[1]//tr[2]//*[@id='draft_del_btn']";
	public String draftconfirmationbx = "//p-confirmdialog[@id='tstDraftsConfirmation']//child::div[contains(@class,'p-confirm-dialog')]";
	public String draftbxtext = "//p-confirmdialog[@id='tstDraftsConfirmation']//following::i//following::span[1]";
	public String popupclosebtn = "//p-confirmdialog[@id='tstDraftsConfirmation']//*[contains(@class,'close p-link')]";
	public String draftconfYes = "button.p-confirm-dialog-accept";

	// Buttons
	public String btn_createnewassessment = "//*[@id='create_new_assessment_btn']//button";
	public String dd_course = "//p-dropdown[@id='courseId']";
	public String ddcoursename1 = "p-dropdownitem:nth-child(1)>li";
	public String ddcoursename2 = "p-dropdownitem:nth-child(2)>li";
	public String ddcoursename3 = "p-dropdownitem:nth-child(3)>li";
	public String coursedropdowntab = "//p-dropdown[@id='courseId']//child::div[3]";
	public String coursesearchbox = "//*[@id='courseId']/div/div[3]/div[1]/div/input";
	public String courseddselect = "//*[@id='courseId']/div/span";
	public String coursedd_label = "//p-dropdown[@id='courseId']//child::div[3]//li";
	public String Assessmenttxtbx = "//input[@id='assessmentName']";
	public String DraftAssessname="#draft_main_table > div > div.p-datatable-wrapper.ng-star-inserted > table > tbody > tr > td:nth-child(4) > div";

	// Editor-Assessment Info
	public String lbl_assessmentinfo = "//*[@id='addAssessmentForm']/div/div[4]/label/strong";
	public String Editor_Assessmentinfo = "//editor[@id='assessmentInfo']";
	public String infolbl_Assessmentinfo = "//editor[@id='assessmentInfo']//following::p[1]";
	public String editorplaceholder1 = "//*[@data-id='assessmentInfo']";

	// Editor-Assessment Instructions for Students
	public String lbl_AssessmentInstru = "//iframe[@id='assessmentInfo_ifr']//following::label";
	public String Editor_AssessmentInstru = "//editor[@id='instructions']";
	public String infolbl_AssessmentInstru = "//editor[@id='instructions']//following::p";
	public String editorplaceholder2 = "//*[@data-id='instructions']";

	// Tabs
	public String tabcurrectassessment = "//*[@id='current_asm_text']//parent::a";
	public String tabdraft1 = "#draft_asm_text";
	public String tabdraftselected = "//*[@id='draft_asm_text']//parent::a";

	// Delete account

	public String Teachername = "//div[@class='username']";
	public String linkaccountsettings = "//i[@class='fas fa-user-circle']";
	public String btn_delete = "#delete";
	public String btn_yes = "button.p-confirm-dialog-accept";

	public String getdate() {

		DateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

	/*
	 * To perform delete account functionality
	 */
	public void DeleteAccount() {

		waitThread(1000);
		driver.findElement(By.xpath(Teachername)).click();

		waitThread(1000);
		driver.findElement(By.xpath(linkaccountsettings)).click();

		waitThread(1000);
		driver.findElement(By.xpath(btn_delete)).click();
		waitThread(1000);
		driver.findElement(By.xpath(btn_yes)).click();
		waitThread(1000);
	}

}
