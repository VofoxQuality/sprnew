package NewAssessmentOfTeacherPage;

import SPRautomation.StudentPeerReview.basePage;

public class NewAssessmentTeacherBasicsPage extends basePage {

	// Tabs
	public String Assessmenttab = "//*[@id='navbar-menu']/div/a[2]";
	public String Coursetab = "//*[@id='navbar-menu']/div/a[1]";
	public String selectedassessmenttab = "#navbar-menu > div > a.nav-item.nav-link.active";
	public String ddcourse1 = "//div[@id='assessment_tab_list']//p-dropdownitem[1]/li/div";
	public String ddcourse2 = "//div[@id='assessment_tab_list']//p-dropdownitem[2]/li/div";
	public String selectedddvalue = "//*[@optionvalue='courseId'][1]//span[contains(@class,'p-dropdown-label p-inputtext')]";

	// Buttons
	public String btnapplyfilter = "//div[@id='tstTeacherAdvancedFilter']";
	public String ddcourse = "//p-tabpanel[@id='current_asm_tab']//child::p-dropdown";
	public String ddcoursesearchbox = "//div[contains(@class,'p-dropdown-filter-container')]//input";
	public String ddlabel = "//p-tabpanel[@id='current_asm_tab']//child::p-dropdown//li";
	public String ddpopup = "//div[contains(@class,'p-dropdown-panel')]";
	public String assessmentsearchbx = "span.ml-auto.common-search > input";
	public String ddclosebutton = "//p-dropdown[@id='draft_course_filter']//i[contains(@class,'p-dropdown-clear')]";

	// Labels
	public String lblcourse = " div.new-course-select.d-flex.align-items-center> label";
	public String gridlabl = "div.p-dataview-content > div > div > div";
	public String coursename2 = " table > tbody > tr:nth-child(2) > td:nth-child(3) > div > span";

	// Advanced Filter

	// labels
	public String lbl1 = "div > p-overlaypanel > div > div > div > div > strong";
	public String lblupcomingtest = "#upcomingTestCheckboxTeacher > label";
	public String lbltestactive = "#testActiveCheckboxTeacher> label";
	public String lblupcomingreview = "#upcomingPeerReviewsCheckboxTeacher> label";
	public String lblreviewactive = "#peerReviewActiveCheckboxTeacher> label";
	public String lblresultupcoming = "#upcomingResultsCheckboxTeacher> label";
	public String lblresultavailable = "#resultAvailableCheckboxTeacher> label";
	public String popupapplyfilter = "div > p-overlaypanel > div > div > div";

	// checkboxes
	public String upcomingtestcheckbx = "#upcomingTestCheckboxTeacher > div > div.p-checkbox-box";
	public String testactivechkbx = "#testActiveCheckboxTeacher> div > div.p-checkbox-box";
	public String upcomimgreviewchkbx = "#upcomingPeerReviewsCheckboxTeacher> div > div.p-checkbox-box";
	public String reviewactiveckbx = "#peerReviewActiveCheckboxTeacher> div > div.p-checkbox-box";
	public String upcomingresultchkbx = "#upcomingResultsCheckboxTeacher> div > div.p-checkbox-box";
	public String resultavailablechkbx = "#resultAvailableCheckboxTeacher> div > div.p-checkbox-box";

	// buttons
	public String btnclosefilter = " div > p-overlaypanel > div > button";
	public String btnapply = "//button[@id='tstAdvancedFilter']";
	public String btncoursedetails2 = " tbody > tr:nth-child(2) > td:nth-child(8) > p-splitbutton > div > button.p-splitbutton-menubutton";
	public String btndetailsview2 = "tbody > tr:nth-child(2) > td:nth-child(8) > p-splitbutton > div > p-menu > div > ul > li:nth-child(1)";
	public String btnAssessment = "//button[@id='assessment']";
	public String btnviewassessment = "p-menu > div > ul > li:nth-child(1) > a";
	public String btnnewassessment = "p-menu > div > ul > li:nth-child(2)";

	// Assessment publish popup
	public String publishpopup = "app-assessment-steps > div.ng-star-inserted > p-dialog > div > div";
	public String btnbacktomenu = "//p-button[@id='backToMenu']";
	// Teacher assessment search box
	public String teacherassessmentsearchbox = "//input[@id='searchAssessments']";
	// Assessment card
	public String Assessmentcard1 = "div.p-dataview-content > div > div:nth-child(1) > div";
	public String cardcoursename1 = "div > div.assessment-basic-details>p:nth-child(3)";
	public String cardassessmentname1 = "div > div.assessment-basic-details>p:nth-child(1)";
	public String cardcount = "//*[contains(@class,'assessment-grid-width ng-star-inserted')]";
}
