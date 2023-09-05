package NewScenarios.Pages;

import SPRautomation.StudentPeerReview.basePage;

public class CourseAssessmentInactivePage extends basePage {

	public String courseTab = "//div[@id='navbar-menu']//child::a[1]";
	public String Assessment_Tab = "//div[@id='navbar-menu']//child::a[2]";
	public String courseInfo = "//*[@id=\"courseListingTable\"]/div/div[1]/table/tbody/tr[1]/td[8]/p-splitbutton/div/button[2]/span[1]";
	public String CourseInfo_btn = "p-splitbutton > div > button.p-splitbutton-menubutton";
	public String Course_Active = "//p-dropdown[@id='courseStatusDropDown']";
	public String Inactivedropdownlbl = "//span[contains(text(),'Inactive')]";
	public String Verifymodify1 = "p-splitbutton > div > p-menu > div > ul > li:nth-child(1) > a > span\r\n";
	public String coursedetailLabel = "//*[@id=\"p-tabpanel-9-label\"]/span";
	public String ActiveToogle = "//span[@class='p-inputswitch-slider']";
	public String Popupbox = "p-confirmdialog > div > div";
	public String popupcontent1 = "p-confirmdialog > div > div > div.p-dialog-header> span";
	public String popupcontent2 = "p-confirmdialog > div > div > div.p-dialog-content> span";
	public String No_Button = "button.p-confirm-dialog-reject";
	public String Yes_button = "button.p-confirm-dialog-accept";
	public String Activestatus = "//*[@id=\"setCourseStatus\"]/div/span";
	public String ActiveInstatus = "#setCourseStatus > div";
	public String ActiveInactive = "//p-inputswitch[@id='setCourseStatus']/div";
	public String Inactivestatus = "//*[@id=\"setCourseStatus\"]/div/div";
	public String Assessment_button = "//button[@id='assessment']";
	public String createAssessmentD = "//*[@id=\"createNewAssessmentMenu\"]";
	public String CreateAssessmentbtn = "//span[contains(text(),'Create New Assessments')]";
	public String Cnewbtndsbl = "//a[@id='createNewAssessmentMenu']";
	public String createAssessmentD1 = "#courseDetail > p-card > div > div > div > form > div:nth-child(1) > div > div > div.col-md-7.course-filter-btns > div > div.position-relative.d-inline-block.assessment-dropdown > p-menu > div > ul > li:nth-child(2)";
	public String Assessmentcreate = "//*[@id=\"courseDetail\"]/p-card/div/div/div/form/div[1]/div/div/div[2]/div/div[2]/p-menu/div/ul/li[2]";
	public String Toaster = "//div[contains(@class,'p-toast-detail')]";
	public String Inactive_Tab = "p-tabview > div > ul.p-tabview-nav > li:nth-child(2)>a";
	public String DraftTab = "p-tabview > div > ul.p-tabview-nav > li:nth-child(3)>a";
	public String AssessmentNameIn = "//*[@id='inactivated_main_table']/div/div[1]/table/tbody/tr/td[2]/div";
	public String Activate_btn = "//div//p-Button[@id='continue_edit_btn']/button";
	public String No_Assessment_lbl = "//div[contains(text(),'No assessment available')]";
	public String Resultpublishtab = "p-tabview > div > ul.p-tabview-nav > li:nth-child(2)>a";
	public String Noassessment_found = "#assessments_grid_table > div > div.p-datatable-wrapper.ng-star-inserted > table > tbody > tr > td";
	public String DraftNoAssessment = "//td[contains(text(),'No Assessment(s) Found.')]";
	public String draftassessmentname = "//tbody/tr[1]/td[4]/div[1]";
	public String DraftassessmentName = "#draft_main_table > div > div.p-datatable-wrapper.ng-star-inserted > table > tbody > tr:nth-child(1) > td:nth-child(4) > div";
	public String Assessmentsearch = "//*[@id='draft_search_filter']";
	public String CurrentTab = "//span[contains(text(),'Current')]";

	public String TNo_assessment = "//div[contains(text(),'No assessment available')]";

	
	public void coursedelete(){

			// click course tab
			click("//*[@id='navbar-menu']/div/a[1]");
			waitThread(1000);
			// click course delete dropdown
			click("p-splitbutton > div > button.p-splitbutton-menubutton> span.pi.pi-chevron-down");
			waitThread(1000);
			// click delete course button
			click("//p-splitbutton/div/p-menu/div/ul/li[5]/a/span");
			waitThread(1000);
			click("button.p-confirm-dialog-accept");
			waitThread(1000);
	}
}
