package PeerReviewWindowofIndividualStudentPages;

import SPRautomation.StudentPeerReview.basePage;

public class PeerReviewWindowWizardPage extends basePage{
	
//labels
	public String current_assess_label = "//span[@id='currentAssessment']";
	public String Answers_from_label = "//div[@id='answerPeerStudentsSection']/div[1]/label";
	public String studentone_part = "//div[@id='answerPeerStudentsSection']/div[2]//p-accordiontab/div/div[1]";
	public String studentone_label = "//div[@id='answerPeerStudentsSection']/div[2]//p-accordiontab/div/div[1]//span[2]";
	public String student2_label = "//div[@id='answerPeerStudentsSection']/div[3]//p-accordiontab/div/div[1]//span[2]";
	public String max_score_text = "//*[@id='answerPeerStudentsSection']/div[1]/div/p-badge/span";
	public String comment_val_msg = "p-overlaypanel > div > div > small";
	public String studenttwo_part = "//div[@id='answerPeerStudentsSection']/div[3]//p-accordiontab/div/div[1]";
//dropdowns
	public String reviewans_sheetdropdwn = "//p-dropdown[@id='tstNoOfPeer']/div/span";
	public String reviewssheet_count = "//p-dropdown[@id='tstNoOfPeer']//div[3]//ul/p-dropdownitem[2]/li";
	public String rubric_accordian = "//div[@id='questionDetails']/div[3]/p-accordion/div/p-accordiontab/div/div/a";
//Textboxes
	public String peer_reward_scorebx = "//input[@id='rewardScore']";
	public String std_rub_bx = "//*[@data-id='standardRubricViewEditor']";
	public String ans_bx_stud1 = "//*[@data-id='answerViewEditor_0']";
	public String score_bx_stud1 = "//input[@id='peerMaxScore_0']";
	public String score_bx_stud2 = "//input[@id='peerMaxScore_1']";
	public String comment_bx_stud1 = "//input[@id='enterCommentArea_0']";
	public String comment_bx_stud2 = "//input[@id='enterCommentArea_1']";
	public String ans_bx_stud2 = "//*[@data-id='answerViewEditor_1']";
	public String txtbx_comment="p-overlaypanel > div > div > textarea";
	public String comment_popup = "p-overlaypanel > div";

	
//Buttons
	public String commentsave_btn="p-overlaypanel > div > div > span > p-button:nth-child(2) > button";
	public String commentcancel_btn = "p-overlaypanel > div > div > span > p-button:nth-child(1) > button";
	public String backto_btn = "//p-button[@id='successPopupBackToMenu']/button";
	
//Confirmation
	public String conf_popup = "//*[@id='tstPeerReviewSubmitConfirmation']/div/div";
	public String conf_txt = "//*[@id='tstPeerReviewSubmitConfirmation']//div/div[2]/span";
	public String conf_cancel_btn = "//*[@id='tstPeerReviewSubmitConfirmation']//div[3]/button[1]";
	public String conf_submit_btn = "//*[@id='tstPeerReviewSubmitConfirmation']//div[3]/button[2]";
	
//Disclaimer Text 
	public String stud1_disclaimer_txt = "//div[@id='answerPeerStudentsSection']/div[2]/p";
	public String stud2_disclaimer_txt = "//div[@id='answerPeerStudentsSection']/div[3]/p";
}
