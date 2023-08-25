package CurrentAssessmentsforStudents.Pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import SPRautomation.StudentPeerReview.basePage;

public class StudentCurrentAssessmentBasicsPage extends basePage {

	// Tabs
	public String Assessmenttab = "//a[@id='assessmentsLinkStudent']";
	public String tabresultpublish="//span[@id='resultPublishPanelTxt']";
	public String MyCoursetab = "//*[@id='navbar-menu']/div/a[1]";
	public String MyCoursetab1 = "//*[@id='navbar-menu']/div/a[2]";
	public String selectedassessmenttab = "//a[@id='assessmentsLinkStudent'and @class='nav-item nav-link active']";
	public String selectedcoursetab="//*[@id='navbar-menu']/div/a[1][@class='nav-item nav-link active']";
	public String selectedcoursetab1="//*[@id='navbar-menu']/div/a[2][@class='nav-item nav-link active']";

	
	// labels
	public String teacherlbl = "//div[@id='student-assessments']/p-dataview/div/div[1]/div[1]/div[1]/label";
	public String lblcourse = "//div[@id='student-assessments']/p-dataview/div/div[1]/div[1]/div[2]/label";
	public String teacherdd = "//p-dropdown[@id='teacherListDropDown']";
	public String DropdownPnael="#teacherListDropDown > div > div.p-dropdown-panel";
	public String teacherdddisable = "//*[@optionvalue='teacherId']//*[contains(@class,'p-component p-disabled')]";
	public String coursedd = "//p-dropdown[@id='courseListDropDown']";
	public String coursedddisable = "//*[@optionvalue='courseId']//*[contains(@class,'p-component p-disabled')]";
	public String totalassessmentlbl = "//*[contains(@class,'student-total-assessments')]";
	public String lblgridempty = "//*[contains(@class,'p-dataview-emptymessage')]";

	// Advance Filter
	public String lblupcomingtest = "#upcomingTestBox > label";
	public String lbltestactive = "#testActiveBox > label";
	public String lblupcomingreview = "#upcomingPeerReviewsBox > label";
	public String lblreviewactive = "#peerReviewActiveBox > label";
	public String lblresultupcoming = "#upcomingResultsBox > label";
	public String lblresultavailable = "#resultAvailableBox > label";

	// check boxes
	public String upcomingtestcheckbx = "#upcomingTestBox > div > div.p-checkbox-box";
	public String testactivechkbx = "#testActiveBox > div > div.p-checkbox-box";
	public String upcomimgreviewchkbx = "#upcomingPeerReviewsBox > div > div.p-checkbox-box";
	public String reviewactiveckbx = "#peerReviewActiveBox > div > div.p-checkbox-box";
	public String upcomingresultchkbx = "#upcomingResultsBox > div > div.p-checkbox-box";
	public String resultavailablechkbx = "#resultAvailableBox > div > div.p-checkbox-box";
	
	public String ddteachername="ul > p-dropdownitem > li";
	public String ddteachernamelbl="ul > p-dropdownitem > li > span";
	public String teachernamedd="//*[@id='teacherListDropDown']/div/span";
	public String courseddselectedlbl="//*[@id='courseListDropDown']/div/span";
	public String coursenameindd="//*[@id='courseListDropDown']//child::p-dropdownitem//span";
	public String ddcoursename1="ul > p-dropdownitem:nth-child(2) > li > span";
	public String ddcoursename2="ul > p-dropdownitem:nth-child(3) > li > span";
	public String lblallselected="//div[@id='courseListDropDownContainer']//p-dropdown";
	public String courseddallselect=" ul > p-dropdownitem:nth-child(1) > li > span";
	public String tabcoursedropdown="#courseListDropDown > div > div.ng-trigger.p-dropdown-panel";
	
	// Buttons
	public String searchbox = "//input[@id='searchAssessmentFilter']";
	public String searchbox1="//*[@id='searchAsmSpan']/label";
	public String teacherassessmentsearchbox="//input[@id='searchAssessments']";
	public String advancefilterbx = "//*[contains(@class,'advanced-filter-box')]";
	public String btnApply = "div.advanced-filter-box-top.align-items-center.ng-star-inserted > button";
	public String lblApply = "div.advanced-filter-box-top.align-items-center.ng-star-inserted > button>span";
	public String btnnewjoincourse="//button[@id='joinNewCourseBtn']";
	public String tabcurrentassessment="//span[@id='currentAssessment']";
	public String selectedcurrenttab="//p-tabview[@id='assessmentTabs']/div/ul/li[1]/a";
	
	public String teachercoursesearchbox="//i[@class='pi pi-search']//following::input";
	public String studentcoursesearch="//input[@id='searchCourseFilter']";

	public void Logout() {

		waitThread(1000);
		driver.findElement(By.xpath("//div[@class='username']")).click();
		waitThread(1000);
		driver.findElement(By.xpath("//i[@class='pi pi-sign-out']")).click();
	}

}
