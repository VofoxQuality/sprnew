package TestWindowOfIndividualStudent;

import SPRautomation.StudentPeerReview.basePage;

public class TestWindowAssessmentCardPhasesPage extends basePage {

	// button
	public String resumetest_btn = "div.d-flex.align-items-center.pb-1.flex-wrap > button ";
	public String dischange_btn = "#tstDiscardChangesBtn";
	public String viewdetails1_btn = "#teacherAssessmentDataView > div > div:nth-child(1) > div > div:nth-child(3) > div > div> button";
	public String close_btn = "div.ng-star-inserted > p-dialog > div > div > div > div > button > span";
	public String threedot_btn = " div.custom-splitbutton> p-splitbutton > div > button:nth-child(2)";
	public String applychanges_btn = "div.position-absolute > p-button:nth-child(2) > button";
	public String reschedulemenu = "div.custom-splitbutton.ml-auto > p-splitbutton > div > p-menu > div > ul > li:nth-child(1) > a";
	public String backtomenu_btn	="#backToMenu > button > span";
	
	
	// Calendar value
	public String calanderdate_val = "//td[contains(@class,'p-datepicker-today')]";
	public String assessmentduedate_txtbx = "p-calendar#testEndDateCalendar>span>input";
	public String assessmentduetime_txtbx = "p-calendar#testEndTimeCalendar>span>input";
	public String assessduehourarrow = "#testEndTimeCalendar > span > div > div > div.p-hour-picker > button:nth-child(3) > span";
	public String assessdueminarrow = "#testEndTimeCalendar > span > div > div > div.p-minute-picker> button:nth-child(1) > span";

	public String student_count_graph = "//div[@id='teacherAssessmentDataView']/div//div/div[3]/div/div[2]/div[2]/div/p";
	public String teach_review_percent = "//div[@id='teacherAssessmentDataView']/div/div[1]//div[4]/div/div[2]/div[2]/div/p";
	// popup
	public String assessmentsts_popup = " div.ng-star-inserted > p-dialog > div > div";

	//label
	public String student1 = " div.p-datatable-wrapper> table > tbody > tr:nth-child(1) > td:nth-child(2) > div";
	public String student2 = " div.p-datatable-wrapper> table > tbody > tr:nth-child(2) > td:nth-child(2) > div";
	public String Summary_quest = "//div[@class='course-container']/div[2]//div[2]//app-question-summary//h5";
	public String total_questcount = "//*[@id='tstTotalQstnBadge']/span";
	public String anscount1 = " div.p-datatable-wrapper> table > tbody > tr:nth-child(1) > td:nth-child(3) > div>div";
	public String anscount2 = " div.p-datatable-wrapper> table > tbody > tr:nth-child(2) > td:nth-child(3) > div>div";
	public String windowclosed_lbl="div.d-flex.align-items-center.pb-1.flex-wrap > button > span";
	public String teststs_lbl=" div.d-flex.align-items-center.pb-1.flex-wrap > div > span > p-badge";
	// popup
	public String timeout_popup = "#tstTestEndPopup > div > div > div > div > div";

}
