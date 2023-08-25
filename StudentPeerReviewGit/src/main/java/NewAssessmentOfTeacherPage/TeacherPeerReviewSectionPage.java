package NewAssessmentOfTeacherPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import SPRautomation.StudentPeerReview.basePage;

public class TeacherPeerReviewSectionPage extends basePage {

    //card
	public String newcard = " div .new-assessment-main> p-dataview > div > div.p-dataview-content > div > div > div:nth-child(1)";

    //label
	public String newasses_lbl = " div > p-dataview > div > div> div > div:nth-child(1) > div > div > p.font-weight-bold";
	public String course_lbl = " div > p-dataview > div > div > div > div:nth-child(1) > div > div > p:nth-child(3)";
	public String openson_lbl = " div.p-dataview-content > div > div > div > div:nth-child(3) > div > div.d-flex.assessment-details-dates > div:nth-child(1) > p.pb-1";
	public String dueon_lbl = " div.p-dataview-content > div > div > div > div:nth-child(3) > div > div> div:nth-child(1) > p:nth-child(2)";
	public String teststs_lbl = " div > p-dataview > div > div> div > div:nth-child(1) > div > div:nth-child(3) > div > div> div > p-badge > span";
	public String peersts_lbl = " div > p-dataview > div > div> div > div:nth-child(1) > div > div:nth-child(4) > div > div > div > p-badge > span";
	public String peercompl_lbl = " div.p-dataview-content > div > div > div > div:nth-child(4) > div > div.d-flex.assessment-details-dates > div:nth-child(2)  > p";
	public String peerrev_lbl = " div.p-dataview-content > div > div:nth-child(1) > div > div:nth-child(4) > div > div.d-flex.align-items-center.pb-2 > div > p";
	public String peeropen_lbl = " div.p-dataview-content > div > div:nth-child(1) > div > div:nth-child(4) > div > div > div.div > p.pb-2 > span";
	public String peerdue_lbl = " div.p-dataview-content > div > div:nth-child(1) > div > div:nth-child(4) > div > div > div.div > p:nth-child(2) > span";
	public String resultsts_lbl = " div.p-dataview-content > div > div:nth-child(1) > div > div:nth-child(5) > div > div> div.assessment-details-left> p-badge > span";
	public String timetext = "div.assessment-schedule-details>span";
    
	//timer
	public String timer = "div.assessment-schedule-details>span";

    //button
	public String viewdet_btn = " div.p-dataview-content > div > div > div > div:nth-child(4) > div > div.d-flex.align-items-center.pb-2 > button";
	public String timedes_arrow = "#spTestStartTimeCalendar > span > div > div > div.p-hour-picker> button:nth-child(3)";

    //searchbox
	public String search_box = "span.p-input-icon-left.ml-auto.common-search > input";

	public String Getdate() {

		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public String getTime(int number) {

		Calendar now = Calendar.getInstance();
		now.add(Calendar.HOUR, number);

		SimpleDateFormat df = new SimpleDateFormat(" h:mm");
		// String l=df.format(now.getTime());
		return df.format(now.getTime());
	}

	public String getDate(String locator, int num, int num2) {

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String predate = getText(locator).substring(num, num2);
		System.out.println(predate);

		LocalDate date2 = LocalDate.parse(predate, dt);
		return dt.format(date2);

	}

	public String getTime(String locator, int num, int num2) {

		DateTimeFormatter t1 = DateTimeFormatter.ofPattern("HH:MM XM");
		String pretime = getText(locator).substring(num, num2);
		System.out.println(pretime);

		LocalDate t2 = LocalDate.parse(pretime, t1);
		return t1.format(t2);

	}

	public String getdate(String locator, int num, int num2) {

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("MMM d, yyyy");
		String predate = getText(locator).substring(num, num2);
		LocalDate date2 = LocalDate.parse(predate, dt);
		DateTimeFormatter dtt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return dtt.format(date2);
	}
}
