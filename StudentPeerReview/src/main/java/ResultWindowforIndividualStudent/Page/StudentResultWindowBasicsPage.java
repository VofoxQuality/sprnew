package ResultWindowforIndividualStudent.Page;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import SPRautomation.StudentPeerReview.basePage;

public class StudentResultWindowBasicsPage extends basePage {

	// Labels
	public String lblTotalQuestions = "div.summary-header > div > span:nth-child(1)";
	public String lblTotaltestpoints = "div.summary-header > div > span:nth-child(2)";
	public String lblpeerreviewpoints = "div.summary-header > div > span:nth-child(3)";
	public String lblmaxscore = "div.summary-header > div > span:nth-child(3)";

	// Values
	public String valuetotalQuestion = "//p-badge[@id='tstTotalQstnBadge']";
	public String valueTotaltestpoints = "//p-badge[@id='tstTotalTestPointsBadge']";
	public String valuepeerreviewpoints = "//p-badge[@id='tstTotalPeerScoreBadge']";
	public String valuemaxscore = "//p-badge[@id='tstMaxScoreBadge']";

	// Assessmnet Card labels
	public String lbl_resultactive = "div.assessment-active > p-badge > span";
	public String cardheading = "#studentAssessmentDataView > div > div > div > div.d-flex.align-items-center.border-bottom> div > p > span";
	public String lbl_reconsiderationreqstlbl = "//span[contains(@class,'reconsideration-req-badge')]//child::span[1]";

	// button
	public String viewresultbtn = "//*[@id='studentAssessmentDataView']/div/div/div/div[5]/div/div[1]/div[2]/button";
	public String viewresultlbl="//*[@id='studentAssessmentDataView']/div/div/div/div[5]/div/div[1]/div[2]/button/span[2]";
	public String resultbtnactive = "//*[@id='studentAssessmentDataView']/div/div/div/div[5]/div/div[1]/div[2]/button/span[1]";

	public String AnswerdQuestioncount = "div:nth-child(3) > div > div.assessment-details-dates > div.assessment-details-date-right > div > p";
	// Result Popup

	// Popup
	public String resultpopup = "#studentResultPopup > div > div";
	public String resultpopupclosebtn = "div.p-dialog-header> div > button > span.p-dialog-header-close-icon";

	// Labels
	public String label_Result_1 = "#studentResultPopup > div > div > div.p-dialog-header";
	public String lbl_Resul = "//p[@id='resultTxtMain']";
	public String lbl_status = "//p-badge[@id='resultStatus']";
	public String lbl_resultpublish = "//p[@id='resultPublishDate']";
	public String resultPublishingDateTxt = "//span[@id='resultPublishingDateTxt']";
	public String lbl_reconsideration = "//p[@id='reconsiderDate']";
	public String reconsiderationDateTxt = "//span[@id='reconsiderationDateTxt']";

	public String lbl_studentAnswered = "//div[@id='studentAnswered']";
	public String value_studentAnswered = "#studentAnswered > p";

	public String lbl_scorefrmReviewers = "//div[@id='studentPeerScore']//following::div[@id='studentPeerScore'][1]";
	public String score_frmReviewers = "//div[@id='studentPeerScore']//following::div[@id='studentPeerScore'][1]/p";

	public String lbl_ReviewsDone = "//div[@id='studentPeerDone']";
	public String studentPeerDone = "//div[@id='studentPeerDone']/p";

	public String lbl_ScoreforReviewsDone = "//div[@id='studentPeerDone']//following::div[@id='studentPeerScore'][1]";
	public String ScoreforReviewsDone = "//div[@id='studentPeerDone']//following::div[@id='studentPeerScore'][1]/p";
	

	public String lbl_Scorefrm_teach = "//div[@id='studentPeerDone']//following::div[@id='studentPeerScore'][2]";
	public String Scorefrm_teach = "//div[@id='studentPeerDone']//following::div[@id='studentPeerScore'][2]/p";

	public String lbl_TotalScore = "//div[@id='studentTotalScore']";
	public String TotalScore = "//div[@id='studentTotalScore']/p[2]";

	public String lbl_reconsideration1 = "//p[@id='timeLeftTxt']";

	// Buttonsnk9

	public String btn_reconsiderationreqst = "//button[@id='raiseReconsiderButton']";

	// Grid Labels
	public String lblSIno = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(2)";
	public String lblQuestion = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(3)";
	public String lblMaxscore = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(4)";
	public String lblScorefromreviewers = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(5)";
	public String lblScoreforreviewdone = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(6)";
	public String lblsumscore = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(7)";
	public String lblFinalscore = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(7)";
	public String lblStatus = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(8)";
	public String lblAnswersheet = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(9)";
	public String lblscorefromteach = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(7)";
	
	// Text box
	public String Answertextbx = "//body[@data-id='answer']";
	// Grid Values

	// Question 1

	public String Q1_sino = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(1) > td:nth-child(2) > div";
	public String Q1_content = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(1) > td:nth-child(3) > div";
	public String Q1_Maxscore = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(1) > td:nth-child(4) > div";
	public String Q1_scorefrompeers = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(1) > td:nth-child(5) > div";
	public String Q1_scoreforreviews = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(1) > td:nth-child(6) > div";
	public String Q1_sumofscorefrompeersandscoreforreview = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(1) > td:nth-child(7) > div";
	public String Q1_FinalScore = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(1) > td:nth-child(7) > div";
	public String Q1_Status = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(1) > td:nth-child(8) > div";
	public String Q1_Answersheet = "#questionResultListingTable > div > div.p-datatable-wrapper > table > tbody > tr:nth-child(1) > td:nth-child(9) > button";
	
	// Question 2

	public String Q2_sino = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(2) > td:nth-child(2) > div";
	public String Q2_content = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(2) > td:nth-child(3) > div";
	public String Q2_Maxscore = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(2) > td:nth-child(4) > div";
	public String Q2_scorefrompeers = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(2) > td:nth-child(5) > div";
	public String Q2_scoreforreviews = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(2) > td:nth-child(6) > div";
	public String Q2_sumofscorefrompeersandscoreforreview = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(2) > td:nth-child(7) > div";
	public String Q2_FinalScore = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(2) > td:nth-child(7) > div";
	public String Q2_Status = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(2) > td:nth-child(8) > div";
	public String Q2_Answersheet = "#questionResultListingTable > div > div.p-datatable-wrapper > table > tbody > tr:nth-child(2) > td:nth-child(9) > button";

	// Question 3

	public String Q3_sino = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(3) > td:nth-child(2) > div";
	public String Q3_content = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(3) > td:nth-child(3) > div";
	public String Q3_Maxscore = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(3) > td:nth-child(4) > div";
	public String Q3_scorefrompeers = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(3) > td:nth-child(5) > div";
	public String Q3_scoreforreviews = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(3) > td:nth-child(6) > div";
	public String Q3_sumofscorefrompeersandscoreforreview = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(3) > td:nth-child(7) > div";
	public String Q3_FinalScore = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(3) > td:nth-child(7) > div";
	public String Q3_Status = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(3) > td:nth-child(8) > div";
	public String Q3_Answersheet = "#questionResultListingTable > div > div.p-datatable-wrapper > table > tbody > tr:nth-child(3) > td:nth-child(9) > button";

	// Comment popup
	public String commentpop = "#reconsiderCommentPopup > div > div";
	public String lblheading_1 = "#reconsiderCommentPopup > div > div > div.p-dialog-header";
	public String commenttextbx = "//textarea[@id='reconReasonField']";
	public String textsmall = "//textarea[@id='reconReasonField']//following::small";
	public String commentsubmitbtn_submit = "//div[@id='submitStudentReason']/button";
	public String commentclosebutton = "#reconsiderCommentPopup > div > div > div.p-dialog-header > div > button > span";
	public String viewteachercomment = "//button[@id='viewTeacherCmntButton']";

	// Peer review window
	public String student1_box = "#tstQuestionAccordian_0 > div > span";
	public String student2_box = "#tstQuestionAccordian_1 > div > span";

	// Student Result section
	public String studresultlbl = "div.assessment-details-dates.result-section-labels p> span:nth-child(1)";
	public String lblpendinginresult = "#studentAssessmentDataView > div > div > div > div:nth-child(5) > div > div.d-flex.align-items-center > div.assessment-details-left.d-flex.assessment-pending > p-badge > span";

	public String getdate() {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public String getdates_1(String locator, String date) {

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("d MMM yyyy");
		String timetext = getText(locator);
		String[] arrOfStr = timetext.split(",");
		String predate = arrOfStr[arrOfStr.length - 2];
		LocalDate date2 = LocalDate.parse(predate, dt);
		DateTimeFormatter dtt = DateTimeFormatter.ofPattern(date);
		return dtt.format(date2);
	}

	public String getdates_2(String locator) {

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("d MMM yyyy");
		String timetext = getText(locator);
		String[] arrOfStr = timetext.split(",");
		String predate = arrOfStr[arrOfStr.length - 2];
		LocalDate date2 = LocalDate.parse(predate, dt);
		DateTimeFormatter dtt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return dtt.format(date2);
	}

	public String getTime(String locator) {

		String timetext = getText(locator);
		String[] arrOfStr = timetext.split(",");
		String Time = arrOfStr[arrOfStr.length - 1];
		return Time;

	}

	public String getdenominator(String locator) {

		String denominator = getText(locator);
		String[] arrOfStr = denominator.split("/");
		String Value = arrOfStr[arrOfStr.length - 2];
		return Value;

	}
}
