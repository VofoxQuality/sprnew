package PeerReviewWindowofIndividualStudentPages;

import SPRautomation.StudentPeerReview.basePage;

public class ReviewSubmitAndTeacherAssessmentStatusPopUPPage extends basePage {

	// peer review page
	public String reviewssheet_count = "//p-dropdown[@id='tstNoOfPeer']//div[3]//ul/p-dropdownitem[2]/li";

	// Button
	public String viewdet_btn = "div.d-flex.align-items-center.pb-2 > button > span.p-button-label";
	public String closebtn = "#assessmentStatusPopup > div > div > div> div > button";

	// label
	public String studentname1 = " div.p-datatable-wrapper> table > tbody > tr:nth-child(1) > td:nth-child(2) > div";
	public String studentname2 = " div.p-datatable-wrapper> table > tbody > tr:nth-child(2) > td:nth-child(2) > div";

	public String ansforpeer1 = "div.p-datatable-wrapper> table > tbody > tr:nth-child(1) > td:nth-child(5) > div > div:nth-child(1) > p-badge > span";
	public String ansforpeer2 = "div.p-datatable-wrapper> table > tbody > tr:nth-child(1) > td:nth-child(5) > div > div:nth-child(2) > p-badge > span";

	// progressbar and count
	public String progressbar1 = " div.p-datatable-wrapper> table > tbody > tr:nth-child(1) > td:nth-child(3) > div > div > p-progressbar > div";
	public String answercount1 = "div.p-datatable-wrapper> table > tbody > tr:nth-child(1) > td:nth-child(3) > div > div";
	public String peerprogressbar1 = "div.p-datatable-wrapper > table > tbody > tr:nth-child(1) > td:nth-child(6) > div > div > div > p-progressbar > div";
	public String peercount1 = "div.p-datatable-wrapper > table > tbody > tr:nth-child(1) > td:nth-child(6) > div > div > div";
	public String peerprogressbar2 = "div.p-datatable-wrapper > table > tbody > tr:nth-child(2) > td:nth-child(6) > div > div > div > p-progressbar > div";
	public String peercount2 = "div.p-datatable-wrapper > table > tbody > tr:nth-child(2) > td:nth-child(6) > div > div > div";
	public String peercount3 = "div.p-datatable-wrapper > table > tbody > tr:nth-child(3) > td:nth-child(6) > div > div > div";

	// reward status
	public String rewardsts1 = " div.p-datatable-wrapper > table > tbody > tr:nth-child(1) > td:nth-child(7) > div > div";
	public String rewardsts2 = " div.p-datatable-wrapper > table > tbody > tr:nth-child(2) > td:nth-child(7) > div > div > div";

	// percentage on teachercard
	public String teachercardper = "#teacherAssessmentDataView > div > div > div > div:nth-child(4) > div > div> div > div >p ";

	// popup
	public String assesssts_popup = "#assessmentStatusPopup > div > div";
	public String confir_popup = "//*[@id='tstPeerReviewSubmitConfirmation']/div/div";
	public String confirmation_txt = "#tstPeerReviewSubmitConfirmation > div > div > div.p-dialog-content > span";
	public String cancel_confi = "//*[@id='tstPeerReviewSubmitConfirmation']/div/div/div[3]/button[1]/span[2]";
	public String submit_confi = "//*[@id='tstPeerReviewSubmitConfirmation']/div/div/div[3]/button[2]";
	public String backtoassess_btn ="//*[@id='successPopupBackToMenu']/button";
	
	public String ddcoursename1 = "p-dropdownitem:nth-child(1)>li";

	
	
}
