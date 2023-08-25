package NewAssessmentOfTeacherPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import SPRautomation.StudentPeerReview.basePage;

public class TeacherAdvanceFilterPage extends basePage {

	    // searchbox
		public String search_box = "span.p-input-icon-left.ml-auto.common-search > input";

		// label
		public String newasses_lbl = " div > p-dataview > div > div> div > div:nth-child(1) > div > div > p.font-weight-bold";
		public String course_lbl = " div > p-dataview > div > div > div > div:nth-child(1) > div > div > p:nth-child(3)";
		public String assessmentsts_lbl = "div.ng-star-inserted > p-dialog > div > div > div.p-dialog-header>span>p-header";
		public String assessname_lbl = "div.paginator-course-name.popup-course-name > h6 > span";
		
		// card
		public String newcard = " div.p-dataview-content > div > div > div:nth-child(1)";
		public String asses_name_card = " div.assessment-basic-details > p:nth-child(1)";
		public String course_nameid_card = " div.assessment-basic-details > p:nth-child(3)";
		public String testopendatetime = "div.d-flex.assessment-details-dates > div:nth-child(1) > p.pb-1 > span";
		public String testduedatetime = " div.d-flex.assessment-details-dates > div:nth-child(1) > p:nth-child(2) > span";
		public String test_pending = "//div[@id='teacherAssessmentDataView']//div/div[3]/div/div[1]/div/p-badge/span";
		public String testopen_timefield = "//div[@id='spTestOpenTimeField']";
		public String reviewpending_lbl = "//div[@id='studentAssessmentDataView']/div/div[1]/div/div[4]//p-badge/span";
		public String resultsts_lbl = " div.assessment-test-details:nth-child(5) > div > div > div > p-badge > span";
		
		//button
		public String timeadjust_btn = "//*[@id='spTestStartTimeCalendar']/span//div[3]/button[1]";
		public String hr_timeadjust_btn = "//*[@id='spTestStartTimeCalendar']/span//div[1]/button[2]";
		
		// Advance Filter
		public String lblupcomingtest = "#upcomingTestBox > label";
		public String lbltestactive = "#testActiveBox > label";
		public String lblupcomingreview = "#upcomingPeerReviewsBox > label";
		public String lblreviewactive = "#peerReviewActiveBox > label";
		public String lblresultupcoming = "#upcomingResultsBox > label";
		public String lblresultavailable = "#resultAvailableBox > label";

		// check boxes
		public String upcomingtestcheckbx = "#upcomingTestCheckboxTeacher > div > div.p-checkbox-box";
		public String testactivechkbx = "#testActiveCheckboxTeacher > div > div.p-checkbox-box";
		public String upcomimgreviewchkbx = "#upcomingPeerReviewsCheckboxTeacher > div > div.p-checkbox-box";
		public String reviewactiveckbx = "#peerReviewActiveCheckboxTeacher > div > div.p-checkbox-box";
		public String upcomingresultchkbx = "#upcomingResultsCheckboxTeacher> div > div.p-checkbox-box";
		public String resultavailablechkbx = "#resultAvailableCheckboxTeacher > div > div.p-checkbox-box";
		public String btnApply = "div.advanced-filter-box-top.align-items-center.ng-star-inserted > button";
		public String lblApply = "div.advanced-filter-box-top.align-items-center.ng-star-inserted > button>span";

		
		
		public String Getmonthnumber(String locator) {

			DateTimeFormatter dt = DateTimeFormatter.ofPattern("MMM");
			String predate = DropselectedValue(locator);
			System.out.println(predate);
			LocalDate monthnumber = LocalDate.parse(predate, dt);
			//DateTimeFormatter dtt =  DateTimeFormatter.ofPattern("M");
			
			return dt.format(monthnumber);
	}

}
