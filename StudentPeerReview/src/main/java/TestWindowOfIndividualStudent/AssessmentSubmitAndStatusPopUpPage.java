package TestWindowOfIndividualStudent;

import SPRautomation.StudentPeerReview.basePage;

public class AssessmentSubmitAndStatusPopUpPage extends basePage {

	// Buttons

	public String btnbeginTest = "//button[@label='Begin Test']";
	public String Questionwizard = "//p-paginator[@id='pages']";
	public String testbtnsave = "//button[@id='tstBtnAnswerSave']";
	public String testbtnsaveandexit = "//p-button[@id='saveExitBtn']";
	public String testbtnsaveandnext = "//p-button[@id='saveNextBtn']";
	public String testbtnsubmit = "//p-button[@id='submitBtn']";
	public String buttontestbegin = "//div[@class='assessment-basic-details']//following::div[1]//button";
	public String viewdetailspopup = "#assessmentStatusPopup > div > div";
	public String btncloseviewdetails = "//button[contains(@class,'p-dialog-header-close')]";
	public String wizardans1 = "//*[@id='pages']/div/span/button[1]";
	public String wizardans2 = "//*[@id='pages']/div/span/button[2]";
	public String wizardans3 = "//*[@id='pages']/div/span/button[3]";
	public String wizardans4 = "//*[@id='pages']/div/span/button[4]";

	// Labels

	public String teachernameoncard = "div.assessment-basic-details > p:nth-child(5) > span";
	public String Assessmenttimerlabel = "div.assessment-schedule-details>span";
	public String testtimeleft = "//p[@id='tstTimeLeft']";
	public String Student1_name = "table > tbody > tr:nth-child(1) > td:nth-child(2) > div";
	public String Student2_name = "table > tbody > tr:nth-child(2) > td:nth-child(2) > div";
	public String popupQuestioncountstud1 = "table > tbody > tr:nth-child(1) > td:nth-child(3) > div > div";
	public String cardQuestioncount="div:nth-child(3) > div > div.assessment-details-dates > div.assessment-details-date-right > div > p";
	public String progressbarstud1 = "table > tbody > tr:nth-child(1) > td:nth-child(3) > div > div > p-progressbar > div";
	public String popupQuestioncountstud2 = "table > tbody > tr:nth-child(2) > td:nth-child(3) > div > div";
	public String progressbarstud2 = "table > tbody > tr:nth-child(2) > td:nth-child(3) > div > div > p-progressbar > div";
	public String teachercardprogressbar = "div:nth-child(3) > div > div.d-flex> div.assessment-details-date-right> div > p-progressbar > div";
	public String teachercardstudcount = "div:nth-child(3) > div > div.d-flex> div.assessment-details-date-right> div ";

	// Test Window Labels

	public String testassessmentname = "#tstAssessmentBasicDetails > h6";
	public String testcoursename = "#tstAssessmentBasicDetails > p:nth-child(3)";
	public String testeachername = "#tstAssessmentBasicDetails > p:nth-child(5)";

	// Text box
	public String Answertextbx = "//body[@data-id='answer']";

	// check box
	public String incompleteanschkbx = "//p-checkbox[@id='tstIncompleteChkBox']";
	public String incompletechked = "#tstIncompleteChkBox > div";

	// Test window confirmation pop up
	public String testwindowconfirmpopup = "//p-confirmdialog[@id='tstConfirmation']/div/div";
	public String confirmationsubmit = "//button[contains(@class,'redirectionAccept')]";
	public String tstSubmitAnswerPopup = "//p-dialog[@id='tstSubmitAnswerPopup']/div/div";
	public String tstsubmitlbl_1 = "//p-dialog[@id='tstSubmitAnswerPopup']//child::h6";
	public String tstsubmitlbl_2 = "//p-dialog[@id='tstSubmitAnswerPopup']//child::p";
	public String btnbacktoassessment = "#backToMenu";
	public String lbl_backtoassessment = "#backToMenu > button > span";

}
