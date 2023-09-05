package TestWindowOfIndividualStudent;

import SPRautomation.StudentPeerReview.basePage;

public class ModifyWizardSectionPage extends basePage {

	// labels
	public String test_window_assess_name = "//div[@id='tstAssessmentBasicDetails']/h6";
	public String course_name_id = "//div[@id='tstAssessmentBasicDetails']/p[1]";
	public String teach_name_testwindow = "//div[@id='tstAssessmentBasicDetails']/p[2]";
	public String time_status = "//p[@id='tstTimeLeft']";
	public String btn_maxscore="p-button.max-score-btn>button";
	public String compcount = "//div[@id='studentAssessmentDataView']//div/div[3]/div/div[2]/div[2]/div/p";
	public String max_score_txt = "//div[@id='questionDetails']/div[1]/p-badge[2]/span";
	public String next_btn="#nextQstnBtn";
		
	// Button
	public String image_btn = "//button[@id='image_upload_answer_editor']";
	public String video_btn = "//button[@id='media_upload_answer_editor']";
	public String link_btn = "//button[@id='link_upload_answer_editor']";
	public String submit_btn = "//p-button[@id='submitBtn']";
	public String backtoassess_btn = "//*[@id='backToMenu']/button";
	public String backtoassess_btn_1="//p-button[@id='successPopupBackToMenu']";
	public String reviewbactoassessmentbtn="//p-button[@id='successPopupBackToMenu']/button";
	public String questions_count = "//div[@id='questionDetails']/div[1]/div/label[1]";
	public String total_score = "//*[@id='questionDetails']/div[1]/div/label[2]";
	public String discard_btn = "#discardBtn";
	public String yes_btn = "#tstConfirmation > div > div > div > button:nth-child(2)";
	public String modify_btn = "#studentAssessmentDataView > div > div:nth-child(1) > div > div:nth-child(3) > div > div > button";
	
	// Added image vide and link
	public String addedimage = "#tinymce > p:nth-child(2) > img";
	public String addedvideo = "#tinymce > p:nth-child(3) > span > video";
	public String addedlink = "#tinymce > p:nth-child(4)";

	public String imageuploadheaderlbl = "div.tox-dialog>div>div.tox-dialog__title";
	public String instrimage = "#tinymce > p > img";

	// checkbox
	public String incomp_txt_checkbx = "//p-checkbox[@id='tstIncompleteChkBox']";
	public String incomp_txt_checkbx2 = "//p-checkbox[@id='tstIncompleteChkBox']/div";

	// tab
	public String currentass_tab = "#assessmentTabs > div > ul > li.p-highlight.ng-star-inserted";

	// popup
	public String conf_lbl = "#tstConfirmation > div > div > div.p-dialog-content> span";
	public String confir_popup = "//*[@id='tstConfirmation']/div/div";
	public String confirmation_txt = "//*[@id='tstConfirmation']//div/div[2]/span";
	public String cancel_confi = "//*[@id='tstConfirmation']//div[3]/button[1]";
	public String submit_confi = "button.p-confirm-dialog-accept";
	public String alert_txt ="#tstAlertBox > div.modal-body";
	public String popup_txt ="#tstSubmitAnswerPopup > div > div > div.p-dialog-content > div > div > p";
}
