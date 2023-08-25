package NewAssessmentOfTeacherPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import SPRautomation.StudentPeerReview.basePage;

public class TeacherResultSectionPage extends basePage {

	// searchbox
	public String search_box = "span.p-input-icon-left.ml-auto.common-search > input";

	// card
	public String newcard = " div.p-dataview-content > div > div > div:nth-child(1)";

    //timer
	public String timer = "div.assessment-schedule-details>span";
	
	// label
	public String teststs_lbl = " div.assessment-test-details  > div > div> div > p-badge > span";
	public String peersts_lbl = " div.assessment-test-details:nth-child(4) > div > div > div > p-badge > span";
	public String resultsts_lbl = " div.assessment-test-details:nth-child(5) > div > div > div > p-badge > span";
	public String newasses_lbl = " div.ng-star-inserted:nth-child(1) > div > div > p.font-weight-bold";
	public String course_lbl = "div.ng-star-inserted:nth-child(1) > div > div > p:nth-child(3)";
	public String result_lbl = " div.assessment-grid-item>div:nth-child(5) > div > div> div.assessment-details-left>p";

	public String resultpublish_lbl = "div.assessment-details-dates > p:nth-child(1)";
	public String lastdate_lbl = "  div.assessment-details-dates > p:nth-child(2)>span";
	public String resultpublishdate_lbl = "  div.assessment-details-dates > p:nth-child(1)>span";
	public String lastdatetime_lbl = " div.assessment-details-dates > p:nth-child(2)>span";
	public String youneed_lbl = " div.assessment-details-dates > p:nth-child(1) > span";
	public String lastdatewillup_lbl = " div.assessment-details-dates > p:nth-child(2) ";
	
	// Button
	public String evaluateans_btn = "  div.d-flex.align-items-center> div.ml-auto > button ";

	public String getDate(String locator) {

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		String predate = locator;
		System.out.println(predate);

		LocalDate date2 = LocalDate.parse(predate, dt);
		return dt.format(date2);

	}

	public String getdate(String locator, int num, int num2) {

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("MMM d, yyyy");
		String predate = getText(locator).substring(num, num2);
		LocalDate date2 = LocalDate.parse(predate, dt);
		DateTimeFormatter dtt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return dtt.format(date2);
	}
}
