package ResultWindowforIndividualStudent.Page;

import SPRautomation.StudentPeerReview.basePage;

public class StudentAnswerSheetBasicsPage extends basePage {

	// Result window popup scores
	public String scorefromreview_q3 = "//p-table[@id='questionResultListingTable']//div[1]//tbody/tr[3]/td[5]//span";

	// Buttons
	public String view_btn_q1 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[1]/td[9]/button";
	public String view_btn_q2 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[9]/button";
	public String view_btn_q3 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[3]/td[9]/button";
	public String wizardnext = "//p-paginator[@id='questionWizardResultPage']/div/button[3]";
	public String wizardprev = "//p-paginator[@id='questionWizardResultPage']/div/button[2]";
	public String answerdropdwn = "//p-accordiontab[@id='resultAnswerAccordionTab']/div";
	public String rubricdropdwn = "//p-accordion[@id='resultRubricViewAccordion']/div";
	public String Exit_btn = "//p-button[@id='exitBtnResultPage']/button";
	public String resultopopup_close = "//p-dialog[@id='studentResultPopup']/div/div/div[1]/div/button";
	
	// Label
	public String questionlabel = "//p-badge[@id='resultQuestionNoBadge']/span";
	public String maxscore_lbl = "//p-badge[@id='resultMaxScoreBadge']/span";
	public String scorefrompeer_lbl = "//p-badge[@id='scoreFromPeers']/span";
	public String scoreforreview_lbl = "//p-badge[@id='scoreForReviewsDone']/span";
	public String final_scrorelbl = "//p-badge[@id='resultFinalScoreBadge']/span";
	public String totalscr_lbl = "//p[@id='resultTotalScoreBadge']";
	public String markassign_lbl = "//div[@id='answerPeerStudentsSection']//label/strong";
	public String peer_score_lbl = "//p-badge[@id='resultPeerReviewScoreBadge']/span";
	public String reviewstatus = "//p-badge[@id='resultPeerReviewStatusBadge']/span";
	public String scorefromteach = "//*[@id='scoreFromTeacher']/span";
	
	//Totalscore value
	public String totalscore ="//p[@id='resultTotalScoreBadge']/span"; 
	
	//Answer Sheet
	public String wizardq1 = "//p-paginator[@id='questionWizardResultPage']//span/button[1]";
	public String wizardq2 = "//p-paginator[@id='questionWizardResultPage']//span/button[2]";
	public String wizardq3 = "//p-paginator[@id='questionWizardResultPage']//span/button[3]";
	
	//Answer
	public String answer = "//body[@data-id='resultAnswerViewEditor']/p";
	public String Studentonepart = "#tstQuestionAccordianTab > div> div.p-accordion-header.ng-tns-c130-95.p-disabled";
	public String rubric = "//body[@data-id='resultStandardRubricEditor']/p";
	public String answrpart = "//p-accordiontab[@id='resultAnswerAccordionTab']/div/div[1]";
	
	//Student1
	public String stud1part = "//div[@id='answerPeerStudentsSection']/div[2]/p-accordion//p-accordiontab/div/div[1]";
	public String stud1score = "//input[@id='peerMaxScore_0']";
	public String stud1_lbl = "//div[@id='answerPeerStudentsSection']/div[2]/p-accordion//p-accordiontab//span[2]";
	public String stud1tab = "//div[@id='answerPeerStudentsSection']/div[2]/p-accordion";
	public String stud1comment = "//body[@data-id='commentEditor_0']/p";
	
	//Student2
	public String stud2part = "//div[@id='answerPeerStudentsSection']/div[3]/p-accordion//p-accordiontab/div/div[1]";
	public String stud2tab = "//div[@id='answerPeerStudentsSection']/div[3]/p-accordion";
	public String stud2comment = "//body[@data-id='commentEditor_1']/p";
	public String stud2score = "//input[@id='peerMaxScore_1']";
	public String stud2_lbl = "//div[@id='answerPeerStudentsSection']/div[3]/p-accordion//p-accordiontab//span[2]";
	
	//Question
	public String quest = "//body[@data-id='resultQuestionViewEditor']";
	
	//tooltip
	public String Exit_tooltip = "//p-button[@id='exitBtnResultPage']";

}
