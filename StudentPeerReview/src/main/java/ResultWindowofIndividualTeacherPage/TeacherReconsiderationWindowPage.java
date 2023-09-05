package ResultWindowofIndividualTeacherPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import SPRautomation.StudentPeerReview.basePage;

public class TeacherReconsiderationWindowPage extends basePage {

	// Peer Review Results page

	// Labels
	public String reconisiderationtime = "#reconsiderTimeLeftInDays > p > span";
	public String resultpopupreconsiderdate = "#resultPublishedSuccessDiv > div.result-date-text > p";
	public String reconsidertimer = "#reconRealTimer";
	public String resultdatelbl = "div > div.assessment-details-dates.result-section-labels > p:nth-child(1) > span";

	// Buttons
	public String publish_btn = "//button[@id='publishResultBtn']";
	
	//search box
	public String searchbox="//*[@id=\"assessments_grid_table\"]/div/div[1]/div/span/input";

	// reconsideration request tab
	public String reconsidertab = "#reconsider_asm_text";
	public String tab_reconsiderationrequest="//div[@id='assessment_tab_list']/p-tabview[1]/div[1]/ul[1]/li[5]/a[1]";

	// Reconsideration tab -Grids
	public String reconsider_coursename = "//div[@id='reconsiderationRequestTableContainer']//following::p-table[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]";
	public String reconsider_ass_name = "//div[@id='reconsiderationRequestTableContainer']//following::p-table[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[3]/div[1]";
	public String reconsider_maxscore = "//div[@id='reconsiderationRequestTableContainer']//following::p-table[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[4]/div[1]";
	public String reconsider_pending = "//div[@id='reconsiderationRequestTableContainer']//following::p-table[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[5]/div[1]";
	public String reconsider_reqst_proccess = "//div[@id='reconsiderationRequestTableContainer']//following::p-table[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[6]/div[1]";
	public String viewrequest_btn = "//div[@id='reconsiderationRequestTableContainer']//following::p-table[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[7]/div[1]";
	public String gridemptylabel="table > tbody > tr > td.empty-message-table";
	// View request button
	public String view_request_btn = "//p-button[@id='view_request_button']//button";
	public String view_request_btn_lbl = "//p-button[@id='view_request_button']//button//span";
	
	//view button
	public String btn_view="div.result-section-btns > button";
	//Card Labels
	public String teachercard_reconsidercount="div.assessment-details-dates.result-section-labels > p:nth-child(3)";
	

	/*
	 * Reconsideration page
	 */

	// Reconsideration Requests

	// Labels
	

	public String lbl_reconsider_heading = "//h4[@id='reconsEvalHeader']";
	public String reconsiderpage_coursename = "//h6[@id='reconEvalCourseName']/span";
	public String reconsiderpage_assessmentname = "//h6[@id='reconEvalAsmName']/span";
	public String reconsiderationPendingCount = "//div[@id='reconsiderationPendingCountDiv']";
	public String courseBasicDetailsRecon ="//div[@id='courseBasicDetailsRecon']";
	public String reconTotalPeerPoints = "//div[@id='reconTotalPeerPoints']";
	public String reconTotalTestPoints = "//div[@id='reconTotalTestPoints']";
	public String reconMaxScorePossible = "//div[@id='reconMaxScorePossible']";
	public String lbl_reconsiderrequest = "//*[@id=\"colorHintDiv\"]/div[2]/span[1]";
	public String lbl_Allresults = "//*[@id=\"colorHintDiv\"]/div[2]/span[2]";
	public String completed_dot = "//*[@id=\"colorHintDiv\"]/div[1]/div[1]/span";
	public String incomplete_dot = "//*[@id=\"colorHintDiv\"]/div[1]/div[2]/span";
	public String completed_lbl = "//*[@id=\"colorHintDiv\"]/div[1]/div[1]";
	public String incomplete_lbl = "//*[@id=\"colorHintDiv\"]/div[1]/div[2]";
	public String student1totalscorereconsider="//span[@id='resultTotalScoreBadgeSpan']";
	public String reviewername="//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr/td[4]/div/div/p-badge/span";

	
	// Radio buttons
	public String radiobtn_reconsider = "//*[@id=\"colorHintDiv\"]/div[2]/span[1]/p-radiobutton/div";
	public String radiobtn_allresults = "//*[@id=\"colorHintDiv\"]/div[2]/span[2]/p-radiobutton/div";
	public String btn_reconsider="button.student-reconsider-btn";
	public String btn_reconsider_1="//*[@id='teacherAnswerEvaluateForm']/div[1]/div[1]/div/div/div[2]/button";
	public String btn_continue="div.studentRaisedBtn.view-btn-group > button";
	public String back_btn = "//button[@id='reconsiderEvalBackBtn']";
	public String reconsiderviewbtn="div.studentRaisedBtn.view-btn-group > button";
	public String reconsiderviewbtnteacher="div > a.view-teacher-comment-popup";

	// Grid Labels-Reconsideration requests
	public String lbl_sino = "#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(2)";
	public String lbl_Answersheetsreviewedby="#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(4)";
	public String lblStudentName_ = "#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(3)";
	public String lblraisedon="#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(5)";
	public String lblstatus="#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(6)";
	public String lbl_RewardPoint = "#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(7)";
	public String lbl_ScorefromPeers_ = "#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(8)";
	public String lbl_ScorefromTeacher_Peers = "#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(9)";
	public String lbl_TotalScore_ = "#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(10)";
	public String lbl_AnswerSheet = "#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(11)";
	
	// Grid Labels-All_results
	public String lbl_sinoAll_results = "#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(2)";
	public String lblStudentNameAll_results_ = "#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(3)";
	public String lbl_QuestionsAnsweredAll_results = "#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(4)";
	public String lblReviewedbyAll_results_ = "#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(5)";
	public String lbl_RewardPointAll_results = "#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(6)";
	public String lbl_ScorefromPeersAll_results_ = "#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(7)";
	public String lbl_ScorefromTeacher_PeersAll_results = "#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(8)";
	public String lbl_TotalScoreAll_results_ = "#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(9)";
	public String lbl_AnswerSheetAll_results = "#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(10)";

	
	public String lbl_TotalScore_1_ = "#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(8)";
	public String lbl_AnswerSheet_1 = "#questionResultListingTable > div > div.p-datatable-wrapper > table > thead > tr > th:nth-child(9)";

	public String studentname="//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr/td[3]/div";
	
	//All Results page
	public String lbl_allresults="//h4[@id='reconsEvalHeader']";
	
	//Answer window teacher
	//Student comment pop up
	
	public String systemGeneratedCommentDialog="//*[@id=\"systemGeneratedCommentDialog\"]/div/div";
	public String commentpopupheading="#systemGeneratedCommentDialog > div > div>div.p-dialog-header>span";
	public String btnclose_commentpopup="button > span.p-dialog-header-close-icon";
	public String studentcomment="div.assessment-success-inner > p";
	public String reconsodercommentbtn="div.d-flex.evaluation-right-btns>button";
	public String Student1totalscore="//*[@id=\"studentTotalScore\"]/p[2]";
	
	//buttons
	public String btn_publish_recosnider="//p-button[@id='teacherReconsiderationPublishButton']";
	public String wizardpreviousbtn="button.p-paginator-prev.p-paginator-element.p-link.p-disabled";
	public String btn_exit="//p-button[@id='teacherEvaluateExitButton']";
	
	//Teacher score textbox
	public String scoretextbx="//input[@id='teacherScore']";
	
	//Publish popup teacher
	public String reconsiderCommentPopup ="#reconsiderCommentPopup > div > div";
	public String reconsiderCommentPopupheading="#reconsiderCommentPopup > div > div > div.p-dialog-header";
	public String reconReasonField="//textarea[@id='reconReasonField']";
	public String reconsidercommentbtnpublish="#submitStudentReason > button";
	public String reconsidercommentclosebtn="button > span.p-dialog-header-close-icon";
	public String reconsiderpublishpopup="#tstSubmitAnswerPopup > div > div";
	public String reconsiderpublishpopuplabel="#tstSubmitAnswerPopup > div > div > div.p-dialog-content > div > h6";
	public String reconsiderpublishbacktoresult_btn="//p-button[@id='reconsiderationBackToResults']";
	
	//Answer window after reconsideration processed
	public String linkteachercomment="#teacherEvlauateQuestionDetails > div> div > a.view-teacher-comment-popup";
	public String teacherComment="//div[@id='teacherCommentMainDiv']";
	public String teacherCommentField="//textarea[@id='teacherCommentField']";
	public String teacherCommentFieldclosebtn="button > span.p-dialog-header-close-icon";
	
	
	//Student Login
	
	//Result popup
	public String lbl_reconsideration="//p[@id='timeLeftTxt']";
	public String lbl_timeranswersheet="//p[@id='tstTimeLeftStatus']";
	public String btn_reconsiderationreqst = "//button[@id='raiseReconsiderButton']";
	
	//card label
	public String Cardlbl_reconsideration="span.reconsideration-req-badge > p-badge>span";
	public String cardheadinglbl="#studentAssessmentDataView > div > div > div > div.d-flex.align-items-center.border-bottom > div > p > span";
	// Comment popup
	public String commentpop = "#reconsiderCommentPopup > div > div";
	public String lblheading_1 = "#reconsiderCommentPopup > div > div > div.p-dialog-header";
	public String commenttextbx = "//textarea[@id='reconReasonField']";
	public String textsmall = "//textarea[@id='reconReasonField']//following::small";
	public String commentsubmitbtn_submit = "//div[@id='submitStudentReason']/button";
	public String commentclosebutton = "#reconsiderCommentPopup > div > div > div.p-dialog-header > div > button > span";
	public String viewteachercomment = "//button[@id='viewTeacherCmntButton']";
	public String headingcomment="#teacherCommentPopup > div > div > div.p-dialog-header";
	public String teachercommentfield="//textarea[@id='teacherCommentField']";
	public String teachercommentclosebtn="#teacherCommentPopup > div > div > div.p-dialog-header > div > button > span";
	
	//Label
	public String lbl_peerscore="//*[@id=\"studentPeerScore\"][2]";
	public String lbltotalscore="//div[@id='studentTotalScore']";
	public String Q1viewbtn="//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[1]/td[10]/button";
	public String answerwindowreconsoderstatus="//p-badge[@id='resultPeerReviewStatusBadge']/span";
	public String scoreFromTeacher_stud="//p-badge[@id='scoreFromTeacher']/span";
	public String Q1finalscorestud="//p-badge[@id='resultFinalScoreBadge']/span";
	public String studcurrenttab="//*[@id=\"assessment_tab_list\"]/p-tabview/div/ul/li[1]";
	public String teachercurrenttab="//*[@id=\"assessment_tab_list\"]/p-tabview/div/ul/li[1]";
	/*
	 * Method to get the grid data from the table-Student Result window
	 */
	public String getdatafromgridstudent(String Questionnumber, String firstlocator, String lastlocator) {
		String griddata = "";
		// identify rows of table.
		List<WebElement> r_table = driver
				.findElements(By.xpath("//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr"));
		int tablesize = r_table.size();
		// To get the student name
		String path1 = "//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[";
		String path2 = "]/td[2]/div";
		// iterate rows of table according to the student name
		for (int r = 1; r <= tablesize; r++) {
			// To get the student name
			String n = driver.findElement(By.xpath(path1 + r + path2)).getText();
			if (n.contains(Questionnumber)) {
				// get data from the grid
				griddata = driver.findElement(By.xpath(firstlocator + r + lastlocator)).getText();
				break;

			}

		}
		return griddata;

	}
	/*
	 * To get the date
	 */
	public String getDate_1() {

		DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	/*
	 * get next day
	 */
	public String getnextday_1() {
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 1);
		SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy");
		// String l=df.format(now.getTime());
		dt = c.getTime();
		return df.format(dt);
	}
}
