package ResultWindowofIndividualTeacherPage;

import SPRautomation.StudentPeerReview.basePage;

public class TeacherAutomaticResultPeerreviewIncompletePage extends basePage {

	// Labels
	public String teach_manually_txt = "div.assessment-details-dates.result-section-labels > p:nth-child(2) > span.manual-publish-instruction";
	public String answrsheet_evalu_txt = "div.assessment-details-dates.result-section-labels > p:nth-child(3) > span.evaluation-complete-text";
	public String stud_cardhead_lbl = "//div[@id='studentAssessmentDataView']/div/div/div/div[1]/div/p/span";
	public String evalu_answr_lbl = "//div[@id='resultMainHeaderDetails']/h4";
	public String NofAnswerSheet_lbl = "//div[@id='studentAttended']";
	public String add_score_lbl = "//div[@id='teacherEvlauateQuestionDetails']/div[1]//div/label";
	public String scorefromteach_lbl = "//p-badge[@id='teacherEvlauateScoreFromTeacherTextBadge']/span";
	public String iapprove_lbl = "//p-checkbox[@id='finalScoreSatisfiedChkbox']//following::label[1]";
	public String reviewed_stud1name = "//p-accordion[@id='evaluationQuestionAccordian']//p-accordiontab//span[2]";
	public String commentadded_stud1 = "//body[@data-id='commentEditor_0']/p";
	
	// Pending Evaluation Tab grid
	public String course_namependtab = "//p-table[@id='assessments_grid_table']//div[2]/table//tr/td[2]/div";
	public String assess_namependtab = "//p-table[@id='assessments_grid_table']//div[2]/table//tr/td[3]/div";
	public String max_scoregrid = "//p-table[@id='assessments_grid_table']//div[2]/table//tr/td[4]/div";
	public String selectpublis_grid = "//p-table[@id='assessments_grid_table']//div[2]/table//tr/td[5]/div";
	public String answersheetgrid = "//p-table[@id='assessments_grid_table']//div[2]/table//tr/td[6]/div";
	public String btn_view_ans_grid = "//p-table[@id='assessments_grid_table']//div[2]/table//tr/td[7]/div";
	
	//Evaluation window grid
	public String lblScorereceivedfromteach = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(8)";
	public String lblstatus = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(9)";
	public String lbltotalscore = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(10)";
	public String lblansrsheet = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(11)";
	public String status_stud1 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[1]/td[9]/div/p";
	public String status_stud2 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[9]/div/p";
	public String status_stud3 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[3]/td[9]/div/p";
	public String stud1questans_count = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[1]/td[4]/div/span";
	public String stud2questans_count = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[3]/td[4]/div/span";
	public String stud3questans_count = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[4]/div/span";
	
	//reward points of students
	public String rewarescore_stud1 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[1]/td[6]//span";
	public String rewarescore_stud2 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[6]//span";
	public String rewarescore_stud3 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[3]/td[6]//span";
	
	//ScoreReceived from peers grid
	public String scorefrompeer_stud1 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[1]/td[7]//span";
	public String scorefrompeer_stud3 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[3]/td[7]//span";
	public String scorefrompeer_stud2 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[7]//span";
	public String scorerec_fromteach_stud1 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[1]/td[8]/div/span";
	public String scorerec_fromteach_stud2 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[8]/div/span";
	public String scorerec_fromteach_stud3 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[3]/td[8]/div/span";
	
	//Totalscores of students in grid
	public String totscore_stud1 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[1]/td[10]//span";
	public String totscore_stud3 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[3]/td[10]//span";
	public String totscore_stud2 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[10]//span";
	
	//System generated popup
	public String sys_popup = "//p-dialog[@id='systemGeneratedCommentDialog']/div/div";
	public String sys_popup_lbl = "//p-dialog[@id='systemGeneratedCommentDialog']/div/div//div[1]/span";
	public String sys_popup_txt = "//p-dialog[@id='systemGeneratedCommentDialog']/div//div[2]//div/p";
	public String sys_popup_clos_btn = "//p-dialog[@id='systemGeneratedCommentDialog']//div//div/button";

	//Textboxes
	public String addscore_txtbx = "//input[@id='teacherScore']";
	
	//Buttons
	public String publish_btn = "//button[@id='publishResultBtn']";
	public String eval_btn = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[1]/td[11]/div/button/span";
	public String modifybtn_stud1 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[1]/td[11]/div/button/span";
	public String modifybtn_stud2 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[11]/div/button/span";
	public String modifybtn_stud3 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[3]/td[11]/div/button/span";
	public String sys_comment_btn = "//div[@id='answerSheetTopBtns']/button";
	public String save_btn = "//button[@id='saveTeacherScoreBtn']";
	public String result_popup_close = "//p-dialog[@id='studentResultPopup']/div/div/div[1]//button";
	
	
	//Confirmation popup
	public String conf_popup = "//p-confirmdialog[@id='tstScoreSatisfiedConfirmation']/div/div";
	public String conf_txt = "//p-confirmdialog[@id='tstScoreSatisfiedConfirmation']//div/div[2]/span";
	public String conf_hd = "//p-confirmdialog[@id='tstScoreSatisfiedConfirmation']//div/div[1]/span";
	public String discard_btn = "//p-confirmdialog[@id='tstScoreSatisfiedConfirmation']//div[3]/button[1]/span[2]";
	public String savecont_btn = "//p-confirmdialog[@id='tstScoreSatisfiedConfirmation']//div[3]/button[2]/span[2]";
	
	//Exit popup
	public String exit_popup = "//p-dialog[@id='evaluationIncompleteDialog']/div/div";
	public String eva_incom_lbl = "//p-dialog[@id='evaluationIncompleteDialog']//div/div[2]//div[1]/h6";
	public String exit_popup_txt = "//p-dialog[@id='evaluationIncompleteDialog']//div/div[2]//p[1]";	
	public String cont_currentev_btn = "//p-dialog[@id='evaluationIncompleteDialog']//div/div[1]/p-button/button/span";
	public String view_nxt_sheetbtn = "//p-dialog[@id='evaluationIncompleteDialog']//div/div[2]/p-button[1]/button/span";
	public String backto_reslt_btn = "//p-button[@id='backToMenu'][2]//button";
	public String viewnextbtn_dis = "//p-dialog[@id='evaluationIncompleteDialog']//div/div[2]/p-button[1]";
	
	//Total Score value
	public String totscorevalue = "//span[@id='resultTotalScoreBadgeSpan']";
	
	//Checkbox
	public String score_checkbx = "//p-checkbox[@id='finalScoreSatisfiedChkbox']";
	public String score_checkbx_check = "//p-checkbox[@id='finalScoreSatisfiedChkbox']/div";
	
	//Score approved popup
	public String score_popup = "//p-dialog[@id='finalScoreApprovedDialog']/div/div";
	public String score_popup_lbl = "//p-dialog[@id='finalScoreApprovedDialog']//div/div[2]//div[1]/h6";
	public String score_popupview_nxtbtn ="//p-dialog[@id='finalScoreApprovedDialog']//div/div[2]/p-button[1]/button/span";
	public String score_back_resltbtn = "//p-dialog[@id='finalScoreApprovedDialog']//div/div[2]/p-button[2]/button/span";
	public String eva_ans_button_scorepopup = "//p-dialog[@id='finalScoreApprovedDialog']//div/div[2]/p-button[1]";
	//Publish popup
	public String publish_popup = "//p-dialog[@id='resultPublishSuccess']/div/div";
	public String pub_popup_txt = "//div[@id='resultPublishedSuccessDiv']/h6";
	public String publish_backtores_btn = "//button[@id='save-conf-btn']";
	
	//Reconsideration popup
	public String recons_popup = "//p-dialog[@id='configure-popup-dialog']/div/div";
	public String recons_popup_closebtn = "//p-dialog[@id='configure-popup-dialog']/div/div/div[1]/div/button";
	public String recons_popup_hd = "//p-dialog[@id='configure-popup-dialog']/div/div/div[1]";
	public String recons_popup_txt = "//p-dialog[@id='configure-popup-dialog']//div/div[2]/div[1]/div[1]";
	public String recons_popup_yesbtn = "//p-dialog[@id='configure-popup-dialog']//div[2]/div[1]/div[2]/p-selectbutton/div/div[1]";
	public String recons_popup_nobtn = "//p-dialog[@id='configure-popup-dialog']//div[2]/div[1]/div[2]/p-selectbutton/div/div[2]";
	public String recons_bystud_txt = "//div[@id='recon-sec']/p/strong";
	public String recons_timetxt = "//div[@id='recon-time']/p";
	public String recons_dataprev_txt = "//div[@id='preview-text']/div/p/strong";
	public String recons_lastdate_txt = "//div[@id='reconsider-window-section']/div[3]/div/p";
	public String daydrop_recons_popup = "//p-dropdown[@id='reconsiderDayVal']/div/div[2]/span";
	public String time_txtbx = "//input[@id='timeonly']";
	public String publish_btn_reconspopup = "//button[@id='publish-result-conf-btn']/span";
	
	//Final window view buttons
	public String viewbtn_stud1 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[1]/td[10]/div/button/span";
	public String viewbtn_stud2 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[3]/td[10]/div/button/span";
	public String viewbtn_stud3 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[10]/div/button/span";
	
	//Final result window
	public String finalwindw_totscorestud1 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[1]/td[9]//span";
	public String finalwindw_scorefrompeer_stud2 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[3]/td[7]//span";
	public String finalwindw_totscorestud2 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[3]/td[9]//span";
	public String finalwindw_totscorestud3 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[9]//span";
	
	//Student result window
	public String Q1_scorefrm_teach = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(1) > td:nth-child(7) > div>span";
	public String Q2_scorefrm_teach = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(2) > td:nth-child(7) > div";
	public String Q3_scorefrm_teach = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(3) > td:nth-child(7) > div";
	
	public String Q1_scorerec_frmpeer = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(1) > td:nth-child(5) > div";
	public String Q2_scorerec_frmpeer = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(2) > td:nth-child(5) > div";
	public String Q3_scorerec_frmpeer = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(3) > td:nth-child(5) > div";
	
	public String Q1_scoreforrev = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(1) > td:nth-child(6) > div>span";
	public String Q2_scoreforrev = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(2) > td:nth-child(6) > div";
	public String Q3_scoreforrev = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(3) > td:nth-child(6) > div";
	
	public String Q1_FinalScore = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(1) > td:nth-child(8) > div";
	public String Q2_FinalScore = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(2) > td:nth-child(8) > div";
	public String Q3_FinalScore = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(3) > td:nth-child(8) > div";
	
	public String Q1_StatusS2 = "#questionResultListingTable > div > div.p-datatable-wrapper > table > tbody > tr:nth-child(1) > td:nth-child(8) >div";
	public String Q2_StatusS2 = "#questionResultListingTable > div > div.p-datatable-wrapper > table > tbody > tr:nth-child(2) > td:nth-child(8) >div";
	public String Q3_StatusS2 = "#questionResultListingTable > div > div.p-datatable-wrapper > table > tbody > tr:nth-child(3) > td:nth-child(8) >div";
	
	public String Q1_FinalScoreS2 = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(1) > td:nth-child(7) > div>span";
	public String Q2_FinalScoreS2 = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(2) > td:nth-child(7) > div>span";
	public String Q3_FinalScoreS2 = "#questionResultListingTable > div > div.p-datatable-wrapper >table > tbody > tr:nth-child(3) > td:nth-child(7) > div>span";
	
	public String Q1_Status = "#questionResultListingTable > div > div.p-datatable-wrapper > table > tbody > tr:nth-child(1) > td:nth-child(9) >div";
	public String Q2_Status = "#questionResultListingTable > div > div.p-datatable-wrapper > table > tbody > tr:nth-child(2) > td:nth-child(9) >div";
	public String Q3_Status = "#questionResultListingTable > div > div.p-datatable-wrapper > table > tbody > tr:nth-child(3) > td:nth-child(9) >div";
	
	public String view_btn_q1 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[1]/td[10]/button";
	public String view_btn_q2 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[10]/button";
	public String view_btn_q3 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[3]/td[10]/button";
	
	public String view_btn_q1S2 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[1]/td[9]/button";
	public String view_btn_q2S2 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[9]/button";
	public String view_btn_q3S2 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[3]/td[9]/button";
	
	public String peerscore_txt1 = "//div[@id='teacherEvlauateQuestionDetails']/div[2]/p-badge/span";
	public String score_rec_peer_lbl = "//div[@id='studentPeerScore'][2]";
	public String finalscorelbl = "//p-badge[@id='resultFinalScoreBadge']";
	public String maxscorelbl = "//p-badge[@id='resultMaxScoreBadge']";
	
	//Result published tab
	public String result_tab = "//p-tabview[@id='assessmentTabs']//li[2]/a";
	public String resulttab_viewbtn = "//p-button[@id='view_result_button']/button";
	
}
