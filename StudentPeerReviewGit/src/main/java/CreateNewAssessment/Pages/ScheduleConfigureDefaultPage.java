package CreateNewAssessment.Pages;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import SPRautomation.StudentPeerReview.basePage;

public class ScheduleConfigureDefaultPage extends basePage {

	// pop up
	public String congigdef_popup = "#configure-popup-footer";

	// label
	public String Testwindow_lbl = "#test-window-section>#result-row> div.col-12 > p > strong";
	public String peerreview_lbl = "#peer-row > div.col-12.p-0 > p > strong";
	public String Resultpublish_lbl = "#result-window-section>#result-row> div.col-12 > p > strong";
	public String lastdaterecons_lbl = "#recon-row > div.col-12 > p > strong";
	public String resultpublishdate_lbl = "#result-sec > p";
	public String assessopendatentime_lbl = "#test-open-sec > p";
	public String startdatetime_lbl = "//div[@id='test-window-section']/div[3]/div[1]/p/strong";
	public String duedatetime_lbl = "//div[@id='test-window-section']/div[3]/div[2]/p/strong";

	// Teacher will manually publish the result
	// Reconsideration Request
	public String reconsider_lbl_1 = "#recon-row > div > p > strong";
	public String lastdate_lbl = "#recon-sec > p";
	public String reconsider_lbl_2 = "#recon-time > p";
	public String reconsiderdays_btn = "//p-dropdown[@id='reconsiderDayVal']";
	public String reconsidertime_btn = "//p-calendar[@id='reconsiderDateTime']";

	public String peerstartdatetime_lbl = "//div[@id='peer-window-section']/div[3]/div[1]/p/strong";
	public String peerduedatetime_lbl = "//div[@id='peer-window-section']/div[3]/div[2]/p/strong";
	public String resultpubdatetime_lbl = "//div[@id='result-window-section']/div[3]/div/p/strong";
	public String lastdaterecondatetime_lbl = "//div[@id='reconsider-window-section']/div[3]/div/p/strong";

	public String hour_label = "#testStartDateTime > span > div > div > div.p-hour-picker> span";
	public String minute_label = "#testStartDateTime > span > div > div > div.p-minute-picker > span";
	public String am_label = "#testStartDateTime > span > div > div > div.p-ampm-picker > span";

	// Button
	public String reset_btn = "#clearAllConfDates";
	public String discard_btn = "#close-conf-popup > button";
	public String save_btn = "#save-conf-btn";
	public String close_btn = "#configure-popup-dialog > div > div > div.p-dialog-header> div > button > span";

	public String teststartascarrow_btn = "#testStartDateTime > span > div > div > div.p-hour-picker > button:nth-child(1)";
	public String teststartascarrow_btn2 = "#testStartDateTime > span > div > div > div.p-minute-picker> button:nth-child(1)";
	public String teststartamarrow_btn = "#testStartDateTime > span > div > div > div.p-ampm-picker > button:nth-child(1)";
	public String teststartmin_dd = "#testStartDateTime > span > div > div > div.p-minute-picker > button:nth-child(1) > span";
	public String testdueascarrow_btn = "#testEndDateTime > span > div > div > div.p-hour-picker> button:nth-child(1)";
	public String testdueamarrow_btn = "#testEndDateTime > span > div > div > div.p-ampm-picker > button:nth-child(1)";

	public String peeropenasc_arrow = "#peerStartDateTime > span > div > div > div.p-hour-picker > button:nth-child(1)";
	public String peeropenamarrow_btn = "#peerStartDateTime > span > div > div > div.p-ampm-picker > button:nth-child(1)";

	public String peerdueasc_arrow = "#peerEndDateTime > span > div > div > div.p-hour-picker > button:nth-child(1)";
	public String peerdueamarrow_btn = "#peerEndDateTime > span > div > div > div.p-ampm-picker > button:nth-child(1)";

	public String resultpubasc_arrow = "#resultDateTime > span > div > div > div.p-hour-picker > button:nth-child(1)";
	// radio
	public String resultpublish_radio = "#configure-auto-rdbtn > div > div.p-radiobutton-box.p-highlight";
	public String resultpublish_radio1 = "#configure-auto-rdbtn > div > div.p-radiobutton-box";
	public String teacherwill_radio = "#configure-manual-rdbtn > div > div.p-radiobutton-box";
	public String teacherwill_radio2 = "#manualPublishRadioBtn > div > div.p-radiobutton-box.p-highlight";

	// Reconsider days box
	public String reconisderdays = "#reconsiderDayVal > div > input";
	public String reconsidertime = "//p-calendar[@id='reconsiderDateTime']/span/input";
	// Student search box
	public String studentsearcbox = "//input[@id='searchCourseFilter']";
	// draft tab
	public String draft_tab = "//div[@id='assessment_tab_list']/p-tabview/div/ul/li[2]/a";

	// dropdown
	public String teststart_drp = "#testStartDayVal > div > input";
	public String teststart_drpval1 = "#testStartDayVal > div > div.ng-trigger.ng-trigger-overlayAnimation > div > ul > p-dropdownitem:nth-child(2) > li";
	public String testdue_drp = "#testEndDayVal > div > input";
	public String peerstart_drp = "#peerStartDayVal > div > input";
	public String peerdue_drp = "#peerEndDayVal > div > input";

	public String testdue_drparrow = "#testEndDayVal >div > div.p-dropdown-trigger";
	public String teststart_drparrow = "#testStartDayVal > div > div.p-dropdown-trigger";
	public String peerdrp_arrow = "#peerStartDayVal > div > div.p-dropdown-trigger";
	public String peerduedrp_arrow = "#peerEndDayVal> div > div.p-dropdown-trigger";
	public String resultpubdrp_arrow = "#resultDayVal> div > div.p-dropdown-trigger";
	public String lastdaterecondrp_arrow = "#reconsiderDayVal > div > div.p-dropdown-trigger";

	public String peerstart_drpval1 = "#peerStartDayVal > div > div.ng-trigger.ng-trigger-overlayAnimation > div > ul > p-dropdownitem:nth-child(2) > li";

	public String resultpub_drp = "#resultDayVal > div > input";
	public String lastdaterecon_drp = "#reconsiderDayVal > div > input";

	public String teststartdrp_val = "//p-dropdown[@id='testStartDayVal']/div/div[3]/div/ul/p-dropdownitem";

	public String testduedrp_val = "//p-dropdown[@id='testEndDayVal']/div/div[3]/div/ul/p-dropdownitem";
	public String peeropendrp_val = "//p-dropdown[@id='peerStartDayVal']/div/div[3]/div/ul/p-dropdownitem";
	public String peerduedrp_val = "//p-dropdown[@id='peerEndDayVal']/div/div[3]/div/ul/p-dropdownitem";

	public String resultpubdrp_val = "//p-dropdown[@id='resultDayVal']/div/div[3]/div/ul/p-dropdownitem";
	public String lastdatedrp_val = "//p-dropdown[@id='reconsiderDayVal']/div/div[3]/div/ul/p-dropdownitem";

	// textbox
	public String assessmentopentime_txtbx = "#testStartTimeField > div>p-calendar>span>input";
	public String assessmentduetime_txtbx = "#test-end-time > div>p-calendar>span>input";
	public String assessopentimeinval_txtbx = "//p-calendar[contains(@class,' invalid-field-conf') and @inputid='timeonly' and @id='testStartDateTime']";
	public String assessduetimeinval_txtbx = "//p-calendar[contains(@class,' invalid-field-conf') and @inputid='timeonly' and @id='testEndDateTime']";
	public String peeropeninval_txtbx = "//p-calendar[contains(@class,' invalid-field-conf') and @inputid='timeonly' and @id='peerStartDateTime']";
	public String peeropentime_txtbx = "#peer-start-time > div>p-calendar>span>input";
	public String peerduetime_txtbx = "#peer-end-time > div>p-calendar>span>input";
	public String resultpub_txtbox = "#result-time > div>p-calendar>span>input";
	public String lastdayrecon_txtbox = "#recon-time > div>p-calendar>span>input";

	// toaster
	public String toaster_1 = "div.col-12.px-5.pb-5.pt-4 > div > div > app-schedule > p-toast > div>p-toastitem:nth-child(1)>div";
	public String toaster_2 = "div.col-12.px-5.pb-5.pt-4 > div > div > app-schedule > p-toast > div>p-toastitem:nth-child(2)>div";

	// course page

	// Tab my students
	public String addstud_label = "//p-tabview[@id='inviteStudentsPopup']/div/ul/li[2]/a/span[2]";
	public String All_checkbox = "//p-tableheadercheckbox//div[@role='checkbox']";
	public String addstud_select = "div.p-datatable-header > div > div.align-items-center > span";
	public String checkboxgrid_tick = "//tr[@class='ng-star-inserted']//p-tablecheckbox";
	public String allcheckbox_tick = "//div[@class='p-checkbox-box p-highlight']//span";
	public String stud1email = "p-chips > div > ul > li:nth-child(1) > span.p-chips-token-label";
	public String stud2email = "p-chips > div > ul > li:nth-child(2) > span.p-chips-token-label";

	// tabs

	public String MyCourseTab = "//*[@id='myCoursesLinkStudent']";

	// Final Result

	// Peer review results

	public String getdate(String locator, int num, int num2) {

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String predate = getText(locator).substring(num, num2);
		System.out.println(predate);

		LocalDate date2 = LocalDate.parse(predate, dt);
		// long daysbet = ChronoUnit.DAYS.between(date2, date1);
		// String period = String.valueOf(daysbet);
		return dt.format(date2);

	}

	/*
	 * To get the date
	 */
	public String getDate() {

		DateFormat dateFormat = new SimpleDateFormat("d-M-yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}
	


	/*
	 * To get today name Eg:Monday
	 */
	public String dayname() {

		Format f = new SimpleDateFormat("EEEE");
		String Todayname = f.format(new Date());
		return Todayname;

	}

	/*
	 * To get the next day-Configure page
	 */
	public String getnextday() {
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 1);

		SimpleDateFormat df = new SimpleDateFormat("d-M-yyyy");
	//	SimpleDateFormat df = new SimpleDateFormat("MMM d,yyyy");
		// String l=df.format(now.getTime());
		dt = c.getTime();
		return df.format(dt);
	}

	/*
	 * To get the next day-Schedule page
	 */
	public String getNextday() {
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 1);

		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		// String l=df.format(now.getTime());
		dt = c.getTime();
		return df.format(dt);
	}
	/*
	 * To get the next day-Schedule page
	 */
	public String getNextday__2() {
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 1);

		SimpleDateFormat df = new SimpleDateFormat("d-M-yyyy");
		// String l=df.format(now.getTime());
		dt = c.getTime();
		return df.format(dt);
	}

	/*
	 * To get tomorrow day name:Eg-Monday,Tuesday
	 */
	public String Nextdayname() throws ParseException {

		LocalDate tomorrow = LocalDate.now();
		String tomorrowday = tomorrow.plusDays(1).toString();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date dt1 = format1.parse(tomorrowday);
		DateFormat format2 = new SimpleDateFormat("EEEE");
		String tomorrowdayname = format2.format(dt1);
		return tomorrowdayname;
	}

	/*
	 * To remove the leading zero's
	 */
	public String removeLeadingZeroes(String str) {
		String strPattern = "^0+(?!$)";
		str = str.replaceAll(strPattern, "");
		return str;
	}

}
