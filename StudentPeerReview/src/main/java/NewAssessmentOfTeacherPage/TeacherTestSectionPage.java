package NewAssessmentOfTeacherPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import SPRautomation.StudentPeerReview.basePage;

public class TeacherTestSectionPage extends basePage {

	public String release_btn = "//*[@id='publishBtn']/button";
	public String back_to_menubutton = "//*[@id='backToMenu']/button";
	public String timeadjust_btn = "//*[@id='spTestStartTimeCalendar']/span//div[3]/button[1]";
	public String hr_timeadjust_btn = "//*[@id='spTestStartTimeCalendar']/span//div[1]/button[2]";
	public String yes_btn = "//*[@id='tstStepConfirm']/div/div/div[3]/button[2]/span[2]";
	public String dot_btn = "//div[@id='teacherAssessmentDataView']/div/div/div/div[1]/div[2]/p-splitbutton/div/button[2]";
	public String delete_assess = "//p-splitbutton/div/p-menu/div/ul/li[3]/a/span[2]";

	// Assessment card
	public String Assessmentcard = "//div[@id='teacherAssessmentDataView']/div/div/div";

	// label
	public String asses_name_card = "//div[@id='teacherAssessmentDataView']/div/div/div/div[2]/p[1]";
	public String course_nameid_card = "//div[@id='teacherAssessmentDataView']/div/div/div/div[2]/p[2]";
	public String time_status = "//div[@id='teacherAssessmentDataView']/div/div/div/div[1]/div[1]/span";
	public String test_text = "#teacherAssessmentDataView > div > div:nth-child(1) > div > div:nth-child(3) > div > div.d-flex.align-items-center> div > p";
	public String test_pending = "//div[@id='teacherAssessmentDataView']//div/div[3]/div/div[1]/div/p-badge/span";
	public String testopendatetime = "//div[@id='teacherAssessmentDataView']/div//div/div[3]//div[2]/div[1]/p[1]/span";
	public String testduedatetime = "//div[@id='teacherAssessmentDataView']/div//div[3]/div/div[2]/div[1]/p[2]/span";
	public String studenttestopendateandtime="//div[@id='studentAssessmentDataView']/div//div/div[3]//div[2]/div[1]/p[1]/span";
	public String studenttestduedateandtime="//div[@id='studentAssessmentDataView']/div//div[3]/div/div[2]/div[1]/p[2]/span";
	public String studentscompl_txt = "//div[@id='teacherAssessmentDataView']/div//div[3]/div/div[2]/div[2]/p";
	public String testopen_timefield = "//div[@id='spTestOpenTimeField']";
	public String no_assess_found = "//div[@id='teacherAssessmentDataView']/div/div/div";
	public String student_count_graph = "//div[@id='teacherAssessmentDataView']/div//div/div[3]/div/div[2]/div[2]/div/p";
	public String review_window_closed = "//div[@id='teacherAssessmentDataView']/div/div[1]/div/div[4]//p-badge/span";
	//Buttons
	public String teacher_publish_radiobtn = "//*[@id='manualPublishRadioBtn']";
	
	
	// calendar
	public String assessmentopendate_txtbx = "//*[@id='spTestStartDateCalendar']/span/input";
	public String assessmentduedate_txtbx = "//*[@id='spTestEndDateCalendar']/span/input";

	public String schedule_testopn_time = "//*[@id='spTestStartTimeCalendar']/span/input";
	public String schedule_testdue_time = "//*[@id='spTestEndTimeCalendar']/span/input";

	// Popoup
	public String dele_conf_popup = "//*[@id='tstCardViewConfirmation']/div/div";
	public String no_btn_del_popup = "//*[@id='tstCardViewConfirmation']/div/div/div[3]/button[1]";
	public String yes_btn_del_popup = "//*[@id='tstCardViewConfirmation']/div/div/div[3]/button[2]";

	public String release_popup = "//app-assessment-success-popup/div[1]";
	public String popup_text = "//app-assessment-success-popup/div/div/div/h6";

	// timer
	public String timer = "div.assessment-schedule-details>span";

	// searchbox
	public String search_box = "span.p-input-icon-left.ml-auto.common-search > input";

	public String getdate() {

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

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("MM/dd/yyy");
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

	public String getdates(String locator, int num, int num2) {

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		String predate = getText(locator).substring(num, num2);
		LocalDate date2 = LocalDate.parse(predate, dt);
		DateTimeFormatter dtt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return dtt.format(date2);
	}

}
