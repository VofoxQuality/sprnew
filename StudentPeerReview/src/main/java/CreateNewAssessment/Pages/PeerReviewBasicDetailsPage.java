package CreateNewAssessment.Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import SPRautomation.StudentPeerReview.basePage;

public class PeerReviewBasicDetailsPage extends basePage {

    //labels
	public String QPassessname_lbl = "#tstQstnAssessmentDetailsSection > h6 > span";
	public String question_pg_assesment="#tstQstnAssessmentDetailsSection > h6 > span";
	public String QPcoursename_lbl = "//div[@id='tstQstnAssessmentDetailsSection']/p";
	public String PRassessmentname_lbl = "#tstPeerReviewAssessmentDetailsSection > h6";
	public String PRassessmentname_value = "//div[@id='tstPeerReviewAssessmentDetailsSection']/h6/span";
	public String PRcoursename_lbl = "//*[@id='tstPeerReviewAssessmentDetailsSection']/p";  
	public String totalstudent_lbl = "//*[@id='peerReviewForm']/div[2]/div[1]/p/strong";
	public String totalstudent_lbl1 = "//*[@id='peerReviewForm']/div[2]/div[1]/p";
	
	public String minimumstudent_lbl = "//*[@id='peerReviewForm']/div[3]/p";
	public String infotext_lbl = "//*[@id='peerReviewForm']/div[2]/div[2]/p";
	public String draft_lbl = "//span[@id='draft_asm_text']";
	public String draftassessname_lbl = "tbody.p-datatable-tbody > tr:nth-child(1) > td:nth-child(4)";
	public String Questioncount="tbody.p-datatable-tbody > tr:nth-child(1) > td:nth-child(5)";
	public String draftcoursename_lbl = "tbody.p-datatable-tbody > tr:nth-child(1) > td:nth-child(3)";
	public String draftcreatdatelbl = "tbody.p-datatable-tbody > tr:nth-child(1) > td:nth-child(6)";
	public String draftmodifieddate_lbl = "tbody.p-datatable-tbody > tr:nth-child(1) > td:nth-child(7)";
	public String draftnoassess_lbl = "tbody.p-datatable-tbody > tr>td.text-center";
	
	// Course title
	public String value_coursetitle = "div.p-datatable-wrapper.ng-star-inserted > table > tbody > tr:nth-child(2) > td:nth-child(3) > div > span";

	// grid label
	public String Assessmentbox="//input[@id='assessmentName']";
	public String SN_gridlbl = " div.p-datatable-wrapper.ng-star-inserted > table > thead > tr > th:nth-child(1)";
	public String Peerreviewer_gridlbl = " thead.p-datatable-thead > tr > th.p-sortable-column.ng-star-inserted > div";
	public String anstobeassign_gridlbl = " div.p-datatable-wrapper.ng-star-inserted > table > thead > tr > th:nth-child(3) > div";
	public String Noreviewer_gridlbl = " div.p-datatable-wrapper.ng-star-inserted > table > tbody > tr > td";
    
	//Tooltip	

	public String course_tooltip = "//p[@tooltipstyleclass='tooltip-wrap']";
	public String assessmentname_tooltip = "//h6[@tooltipposition='top']";
	public String autoassign_toottip = "//p-inputswitch[@tooltipstyleclass='tooltip-wrap']";
    
	//Dropdown
	public String anssheetperstu_drp = "//div[contains(@class,'ng-tns-c81-468 p-mb-2 p-mb-md-0 w-100 p-dropdown p-component p-disabled')]";
	public String course_drp2 = " div.p-dropdown-items-wrapper.ng-tns-c81-251 > ul > p-dropdownitem:nth-child(2) > li";
	public String course_drp3 = "//*[@id='courseId']/div/div[3]/div[2]/ul/p-dropdownitem[1]/li";
    
	//button
	public String autoassign_button = "//form[@id='peerReviewForm']/div/div/div[4]/div/p-inputswitch";
    public String discard_button = "#discardBtn > button";
	public String savenexit_button = "#saveExitBtn > button";
	public String savennext_button = "#saveNextBtn > button";
	public String continueedit_button = "#continue_edit_btn > button";
	public String draft_tab = "#assessment_tab_list > p-tabview > div > ul>li:nth-child(3)";
	public String assessdelete_btn = "#draft_del_btn > button";
	public String deleteyes_btn = "button.p-confirm-dialog-accept";
	public String btn_deletee = "ul.p-menu-list> li:nth-child(5) > a";
	
	// textboxes
	public String assessmentopendate_txtbx = "//p-calendar[@id='spTestStartDateCalendar']/span/input";
	public String calanderdate_val = "//td[contains(@class,'p-datepicker-today')]";
	//Draft searchbox
	public String draft_searchbx="//input[@id='draft_search_filter']";
;    
	//Textbox
	public String PRreward_txtbox = "//input[@id='rewardScore']";
	public String lbl_rewardpercent="//input[@id='rewardScore']//preceding::label[1]";
	
	// wizards
	public String basicdetails_wizard = "#tstBasicDetailsStep > span.p-steps-number";
	public String question_wizard = "#tstQstnStep > span.p-steps-number";
	public String peerrev_wizard = "//div[@id='stepperDiv']/p-steps/div/ul/li[3]";
	public String question_wizard2 = "#stepperDiv > p-steps > div > ul > li:nth-child(2)";
	public String peerrev_wizard2 = "#stepperDiv > p-steps > div > ul > li:nth-child(3)";

	// Toaster
	public String assessmentde_toaster = "//div[contains(@class,'p-toast-detail')]";
	public String PRsavenext_toaster = " div.course-container > p-toast > div";
	
	//Tab current
	public String tab_current="#assessment_tab_list > p-tabview > div > ul.p-tabview-nav > li:nth-child(1)";
	//Tab Assessment
	public String tab_Assessment="//*[@id='navbar-menu']/div/a[2]";
	
	//Discard popup
	public String discardpopup="#tstStepConfirm > div > div.p-confirm-dialog";
	public String discardpopuptext="#tstStepConfirm > div > div > div.p-dialog-content > span";
	public String discardyes="button.p-confirm-dialog-accept";
	public String discardno="button.p-confirm-dialog-reject";

	//
	public String reward_percentage="//input[@id='rewardScore']"; 
	
	public String getdate() {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public String gettime() {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		Date date = new Date();
		return dateFormat.format(date);
	}

}
