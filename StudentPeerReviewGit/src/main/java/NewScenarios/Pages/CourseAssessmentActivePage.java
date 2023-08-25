package NewScenarios.Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import SPRautomation.StudentPeerReview.basePage;

public class CourseAssessmentActivePage extends basePage {

	public String courseTab = "//*[@id=\"navbar-menu\"]/div/a[1]";
	public String courseInfo = "//*[@id=\"courseListingTable\"]/div/div[1]/table/tbody/tr[1]/td[8]/p-splitbutton/div/button[2]/span[1]";
	public String CourseInfo_btn = "p-splitbutton > div > button.p-splitbutton-menubutton";
	public String Verifymodify1 = "p-splitbutton > div > p-menu > div > ul > li:nth-child(1) > a > span\r\n";
	public String coursedetailLabel = "//*[@id=\"p-tabpanel-9-label\"]/span";
	public String ActiveToogle = "//span[@class='p-inputswitch-slider']";
	public String Popupbox = "p-confirmdialog > div > div";
	public String popupcontent1 = "p-confirmdialog > div > div > div.p-dialog-header> span";
	public String popupcontent2 = "p-confirmdialog > div > div > div.p-dialog-content> span";
	public String No_Button = "button.p-confirm-dialog-reject";
	public String Yes_Button = "button.p-confirm-dialog-accept";
	public String Yes1_Button = "//div[@id='p-tabpanel-0']/app-courses-add-edit/p-confirmdialog/div/div/div[3]/button[2]";
	public String Activestatus = "//*[@id=\"setCourseStatus\"]/div/span";
	public String Inactive_tab = "//span[contains(text(),'Inactivated')]";
	public String Inactive_DD = "//p-dropdown[@id='inactivated_course_filter']";
	public String Assess_DD = "//p-dropdown[@id='inactivated_assessment_status']";
	public String Search_box = "//input[@id='draft_search_filter']";
	public String Search_PH = "//div/span/input[@id='draft_search_filter']";
	public String SI_no = "//div//tr/th[contains(text(),'Sl No')]";
	public String Assess_name = "//thead/tr[1]/th[2]";
	public String courseName = "//thead/tr[1]/th[3]";
	public String current_S = "//thead/tr[1]/th[4]";
	public String Action = "//thead/tr[1]/th[5]";
	public String Assessment = "//*[@id=\"inactivated_main_table\"]/div/div[1]/table/tbody/tr[1]/td[2]/div";
	public String course = "//*[@id=\"inactivated_main_table\"]/div/div[1]/table/tbody/tr[1]/td[3]/div";
	public String activate = "//div//p-Button[@id='continue_edit_btn']/button";
	public String Reschedule_Popupbox = "p-confirmdialog > div > div";
	public String testupcoming = "//*[@id='inactivated_main_table']/div/div[1]/table/tbody/tr[1]/td[4]/div/div/p-badge/span";
	public String reschedule_head = "//p-header";
	public String info1 = "//div[@id='inactivatedAssessmentTestDateTimeSectionMain']/p";
	public String info2 = "//div[@id='inactivatedAssessmentPeerDateTimeSectionMain']/p";

	public String testopendate = "//p-calendar[@id='inactivatedAssessmentTestStartDateCalendar']//input";
	public String testopentime = "//p-calendar[@id='inactivatedAssessmentTestStartTimeCalendar']//input";
	public String testduedate = "//p-calendar[@id='inactivatedAssessmentTestEndDateCalendar']//input";
	public String testduetime = "//p-calendar[@id='inactivatedAssessmentTestEndTimeCalendar']//input";
	public String peeropendate = "//p-calendar[@id='inactivatedAssessmentPeerStartDateCalendar']//input";
	public String peeropentime = "//p-calendar[@id='inactivatedAssessmentPeerStartTimeCalendar']//input";
	public String peerduedate = "//p-calendar[@id='inactivatedAssessmentPeerEndDateCalendar']//input";
	public String peerduetime = "//p-calendar[@id='inactivatedAssessmentPeerEndTimeCalendar']//input";
	

	public String cancel = "//*[@id='inactivatedAssessmentCancelSchedulebtn']/button/span[2]";
	public String save = "//span[contains(text(),'Save & Reactivate')]";

	public String toaster = "//div[contains(@class,'p-toast-detail')]";

	public String getdate() {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public String no_assess = "//td[contains(text(),'No Assessment(s) Found.')]";
	public String active = "//span[contains(text(),'Test Active')]";
	public String stud_date = "//div[@id=\"studentAssessmentDataView\"]/div/div[1]/div/div[3]/div/div[2]/div[1]/p[1]";

	public String Savenext = "//p-button[@id='saveNextBtn']";

}
