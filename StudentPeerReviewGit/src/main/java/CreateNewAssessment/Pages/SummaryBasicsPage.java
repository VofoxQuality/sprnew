package CreateNewAssessment.Pages;

import SPRautomation.StudentPeerReview.basePage;

public class SummaryBasicsPage extends basePage {
	
	
	//Schedule wizard
	public String schedulewizardlbl="//a[@id='tstScheduleStep']";
	public String schedulewizard="#stepperDiv > p-steps > div > ul > li:nth-child(4)";
	
	public String scheduleassessmentname="#tstScheduleAssessmentDetailsSection > h6";
	public String schedulecoursename="#tstScheduleAssessmentDetailsSection > p";
	
	//Summary Wizard
	public String summarywizardlbl="//a[@id='tstSummaryStep']";
	public String summarywizard="#stepperDiv > p-steps > div > ul > li:nth-child(5)";
	
	public String summaryassessmentname="#tstSummaryAssessmentDetailsSection > h6";
	public String summarycoursename="#tstSummaryAssessmentDetailsSection > p";
	
	public String questionassessmentname="#tstQstnAssessmentDetailsSection > h6";
	public String peerreviewassessmentname="#tstPeerReviewAssessmentDetailsSection > h6";
	
	//Tabs
	public String tabcurrectassessment="//*[@id='current_asm_text']//parent::a";
	public String tabdraft="#draft_asm_text";
	public String tabdraftselected="//*[@id='draft_asm_text']//parent::a";
	
	public String questionwizard="//a[@id='tstQstnStep']//parent::li";
	
	//Buttons
	public String btnpreview="#previewBtn";
	public String btndiscard="#discardBtn";
	public String btnsaaveandexit="//p-button[@id='saveExitBtn']";
	public String btnsaveandnext="#saveNextBtn";
	public String btnrelease="#publishBtn";
	public String basicdetailseditbtn="#tstEditBasicDetails";
	public String basicdetailscoursename="#courseId > div > span";
	public String basicdetailscoursename1="//*[@id='courseId']/div/span";
	
	public String ddcourse="//div[contains(@class,'p-component p-disabled')]";
	public String toasterclosebtn = "//*[contains(@class,'p-toast-icon-close-icon')]";
	
	//Course name landing page
	public String coursename2="tbody > tr:nth-child(2) > td:nth-child(3)";
	
	//Confirmation popup buttons
	public String discardbuttonlbl="button.tooltip-yes-btn.p-confirm-dialog-accept > span.p-button-label";
	public String cancelbuttonlbl="button.p-confirm-dialog-reject> span.p-button-label";
	
	//Labels
	public String lblTotalQuestions="div.summary-header > div > span:nth-child(1)";
	public String lblTotaltestpoints="div.summary-header > div > span:nth-child(2)";
	public String lblpeerreviewpoints="div.summary-header > div > span:nth-child(3)";
	public String lblmaxscore="div.summary-header > div > span:nth-child(4)";
	
	//Values
	public String valuetotalQuestion="//p-badge[@id='tstTotalQstnBadge']/span";
	public String valueTotaltestpoints="//p-badge[@id='tstTotalTestPointsBadge']//span";
	public String valuepeerreviewpoints="//p-badge[@id='tstTotalPeerScoreBadge']//span";
	public String valuemaxscore="//p-badge[@id='tstMaxScoreBadge']//span";

}
