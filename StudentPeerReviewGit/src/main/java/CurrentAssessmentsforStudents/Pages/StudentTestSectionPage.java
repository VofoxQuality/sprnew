package CurrentAssessmentsforStudents.Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import SPRautomation.StudentPeerReview.basePage;

public class StudentTestSectionPage extends basePage{

	
public String enrolledcourse_lbl = "//*[@id='enrolledCoursesTxt']";
public String published_card = "//*[@id='studentAssessmentDataView']/div/div/div";
public String Assess_name_card = "//div[@id='studentAssessmentDataView']/div/div[1]/div/div[2]/p[1]";
public String teachername_card = "#studentAssessmentDataView > div > div > div > div.assessment-basic-details > p:nth-child(5) > span";
public String testtime = "div.d-flex.align-items-center.border-bottom.pb-2.mb-3 > div > span";
public String testtime2 ="div.d-flex.align-items-center.border-bottom.pb-2.mb-3 > div>p>span";
public String testopen = "//div[@id='studentAssessmentDataView']//div[3]//div[2]//p[1]/span";
public String Quest_ans_lbl = "//div[@id='studentAssessmentDataView']//div[3]//div[2]/div[2]/p";
public String quest_count = "//div[@id='studentAssessmentDataView']//div[3]//div[2]/div[2]/div/p";
public String windowclosd = "//div[@id='studentAssessmentDataView']//div[3]/div/div[1]/button/span";
public String teach_assess_card = "//div[@id='teacherAssessmentDataView']/div/div[1]";
public String stud_compl_txt = "//div[@id='teacherAssessmentDataView']/div/div[1]//div[3]//div[2]/p";
public String teach_assess_name= "//div[@id='teacherAssessmentDataView']/div/div[1]/div/div[2]/p[1]";

//textboxes
public String stud_searchbx ="#searchAssessmentFilter";
public String assess_searchbx = "//*[@id='searchAssessments']";
public String resche_testopendat_txtbx = "//p-calendar[@id='testStartDateCalendar']/span/input";
public String resche_testduedat_txtbx = "//p-calendar[@id='testEndDateCalendar']/span/input";
public String resche_testopentime_txtbx = "//p-calendar[@id='testStartTimeCalendar']/span/input";
public String resche_testendtime_txtbx = "//p-calendar[@id='testEndTimeCalendar']/span/input";
public String resche_peeropendat_txtbx = "//p-calendar[@id='peerStartDateCalendar']/span/input";
public String resche_peeropen_time_txtbx = "//p-calendar[@id='peerStartTimeCalendar']/span/input";
public String resche_peerdue_date_txtbx = "//p-calendar[@id='peerEndDateCalendar']/span/input";
public String resche_peerduetime_txtbx = "//p-calendar[@id='peerEndTimeCalendar']/span/input";
public String resche_resultdate_txtbx = "//p-calendar[@id='resultStartDateCalendar']/span/input";
public String resche_resultime_txtbx = "//p-calendar[@id='resultStartTimeCalendar']/span/input";
public String resche_testduedatetime = "//div[@id='testDueDateTime']";
public String resche_reviewopendatetime = "//div[@id='peerDateTimeRow']/div[1]";
public String resche_reviewduedatetime = "//div[@id='peerDueDateTime']";
public String resche_resultdatetime = "//div[@id='resultDateTimeSectionMain']/div";

//Buttons
public String split_btn = "//div[@id='teacherAssessmentDataView']//div[1]/div/div[1]/div[2]/p-splitbutton/div/button[2]";
public String begintest_btn = "//div[@id='studentAssessmentDataView']//div[1]/button/span[2]";
public String reschedule_button = "//div[@id='teacherAssessmentDataView']//div[2]//p-menu//li[1]//span[2]";
public String applychanges_btn = "//p-button[@id='saveScheduleBtn']/button/span[2]";
public String peeropen_timeadjust = "//p-calendar[@id='peerStartTimeCalendar']//div[3]/button[1]";
public String teach_assess_tab = "//a[@id='assessmentMainTabHead']";
//datepicker
public String calanderdate_val = "//td[contains(@class,'p-datepicker-today')]";

public String getdate() {

	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();
	return dateFormat.format(date);
}

}
