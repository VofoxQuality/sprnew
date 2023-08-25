package TestWindowOfIndividualStudent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import SPRautomation.StudentPeerReview.basePage;

public class StudentAssessmentInfoAndInstructionPage extends basePage {

	public String newcard = " div.p-dataview-content > div > div > div:nth-child(1)";
	public String asses_name_card = " div.assessment-basic-details > p:nth-child(1)";
	public String course_nameid_card = " div.assessment-basic-details > p:nth-child(3)";

	// searchbox
	public String search_box = "span.p-input-icon-left.ml-auto.common-search > input";
	public String enrolledcourse_lbl = "//div[@id='enrolledCoursesTxt']";
	public String assess_searchbx = "//input[@id='searchAssessmentFilter']";
	public String published_card = "//div[@id='studentAssessmentDataView']/div/div/div";
	public String Assess_name_card = "//div[@id='studentAssessmentDataView']/div/div[1]/div/div[2]/p[1]";
	public String teachername_card = "#studentAssessmentDataView > div > div > div > div.assessment-basic-details > p:nth-child(5) > span";
	public String stud_searchbx = "#searchAssessmentFilter";
	public String test_sts = " div.d-flex.align-items-center.pb-1.flex-wrap > div > p-badge > span";
	public String testopendatetime = "div.assessment-details-dates > div:nth-child(1) > p.pb-1 > span";
	public String testduedatetime = "#studentAssessmentDataView > div > div > div > div:nth-child(3) > div > div> div:nth-child(1) > p:nth-child(2) > span";
	public String assessinfo_lbl = "#tstAssessmentInfoPopup > div > div>div>span";
	public String assessinstr_lbl = "#tstAssessmentInstructionPopup > div > div>div>span";

	public String addeddinfo_lbl = "//*[@data-id='infoPopup']/p[1]";
	public String addedimage = "#tstAssessmentInfoPopup > div > div > div> div > div > p:nth-child(2) > img";
	public String addedvideo = "#tstAssessmentInfoPopup > div > div > div> div > div > p:nth-child(3) > video";
	public String addedlink = "#tstAssessmentInfoPopup > div > div > div> div > div > p:nth-child(4) > a";

	public String addeddinstruc_lbl = "//*[@data-id='instructPopup']/p[1]";
	public String addedimage2 = "#tstAssessmentInstructionPopup > div > div > div> div > div > p:nth-child(2) > img";
	public String addedvideo2 = "#tstAssessmentInstructionPopup > div > div > div> div > div > p:nth-child(3) > video";
	public String addedlink2 = "#tstAssessmentInstructionPopup > div > div > div> div > div> p:nth-child(4) > a";

//button
	public String begintest_btn = "//div[@class='assessment-basic-details']//following::div[1]//button";
	public String infoclose_btn = "#tstAssessmentInfoPopup > div > div > div> div > button";
	public String instruclose_btn = "#tstAssessmentInstructionPopup > div > div > div> div > button";
	public String assessinfo_btn = "//div/app-assessment-test-start/div/form/div[1]/div/div[2]/div[3]/button";
	public String assessinstru_btn = "//div/app-assessment-test-start/div/form/div[1]/div/div[2]/div[2]/button";
	public String timeascarrow = "#spTestStartTimeCalendar > span > div > div > div.p-minute-picker> button:nth-child(1)";

//popup
	public String assessinfo_popup = "#tstAssessmentInfoPopup >div>div";
	public String assessinstru_popup = "#tstAssessmentInstructionPopup > div > div ";

	public String getdate(String locator, int num, int num2) {

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("MMM d, yyyy");
		String predate = getText(locator).substring(num, num2);
		LocalDate date2 = LocalDate.parse(predate, dt);
		DateTimeFormatter dtt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return dtt.format(date2);
	}

}
