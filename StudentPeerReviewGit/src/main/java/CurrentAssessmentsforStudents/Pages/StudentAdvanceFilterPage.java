package CurrentAssessmentsforStudents.Pages;

import SPRautomation.StudentPeerReview.basePage;

public class StudentAdvanceFilterPage extends basePage {

	public String ResultpublishTab = "//i[@id='resultPublishIcon']//parent::a";

	// label
	public String newasses_lbl = "div.assessment-basic-details > p.font-weight-bold.text-truncate";
	public String course_lbl = "div.assessment-basic-details > p:nth-child(3)";
	public String assessmentsts_lbl = "div.ng-star-inserted > p-dialog > div > div > div.p-dialog-header>span>p-header";
	public String assessname_lbl = "div.paginator-course-name.popup-course-name > h6 > span";

	public String Assessmentstatslabel = "div.assessment-schedule-details>span";
}
