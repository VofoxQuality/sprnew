package ResultWindowofIndividualTeacherPage;

import SPRautomation.StudentPeerReview.basePage;

public class TeacherAutomaticResultreviewcompletePage extends basePage {

	// Final Result Window

	// Buttons
	public String viewresult_teachcard = "div.ml-auto.result-section-btns > button > span.p-button-label";
	public String back_btn = "//button[@id='backToPrevBtn']/span[2]";
	public String view_btn = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[9]//button";
	public String exit_btn = "//p-button[@id='teacherEvaluateExitButton']/button";
	public String viewresultbtn ="//div[@id='teacherAssessmentDataView']//div[1]/div/div[5]//div[1]/div[2]/button";

	public String totscorestud1finalwindow = "//p-table[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[1]/td[9]/div/span";
	public String totscorestud2finalwindow = "//p-table[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[2]/td[9]/div/span";
	public String totscorestud3finalwindow = "//p-table[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[3]/td[9]/div/span";
			
	// Tabs
	public String cuurent_assm_tab = "//div[@id='assessment_tab_list']//div/ul/li[1]/a";
	public String fullfil_tab = "//div[@id='assessment_tab_list']//div/ul/li[6]/a";
	public String pending_ev_tab = "//div[@id='assessment_tab_list']//div/ul/li[4]/a";

	// Fullfilled Tab grid

	public String search_bx = "//p-table[@id='assessments_grid_table']//div[1]//span/input";
	public String searchbx_2="#publishedResultAssessmentDropDownDiv > div > span > input";
	public String assess_namegrid = "//p-table[@id='assessments_grid_table']//div[2]/table//tr/td[3]/div";
	public String cours_namegrid = "//p-table[@id='assessments_grid_table']//div[2]/table//tr/td[2]/div";
	public String auto_method = "//p-table[@id='assessments_grid_table']//div[2]/table//tr/td[4]/div";
	public String clsize_value_grid = "//p-table[@id='assessments_grid_table']//div[2]/table//tr/td[6]/div";
	public String peerpoint_grid = "//p-table[@id='assessments_grid_table']//div[2]/table//tr/td[7]/div";
	public String testpoint_grid = "//p-table[@id='assessments_grid_table']//div[2]/table//tr/td[8]/div";
	public String maxscore_grid = "//p-table[@id='assessments_grid_table']//div[2]/table//tr/td[9]/div";
	public String noassess_text = "//p-table[@id='assessments_grid_table']//div[2]/table//tr/td";

	// Labels
	public String finalresult_lbl = "//h4[@id='resultFinalHeading']";
	public String current_tab = "//span[@id='current_asm_text']";
	public String courselbl = "//div[@id='resultBasicAssessmentDetails']/h6[1]";
	public String assess_lbl = "//div[@id='resultBasicAssessmentDetails']/h6[2]";
	public String studenttest_clsize_lbl = "//div[@id='studentAttended']";
	public String tot_quest_count_lbl = "//div[@id='totalQuestionNumber']";
	public String tot_peerpoints_lbl = "//div[@id='totalPeerReviewPoints']";
	public String tot_testpoints_lbl = "//div[@id='totalTestPoints']";
	public String sum_totalpoints_lbl = "//div[@id='studentTotalScore']/p[1]";
	public String maxscoreposs_lbl = "//div[@id='studentTotalScore']";
	public String completed_lbl = "//div[@id='start-div']/div/div[1]/span";
	public String incomplete_lbl = "//div[@id='start-div']/div/div[2]/span";

	public String result_page_assess_name = "//div[@id='tstAssessmentBasicDetails']/h6";
	public String course_name_id = "//div[@id='tstAssessmentBasicDetails']/p[1]";
	public String stud_name_resultwindow = "//div[@id='tstAssessmentBasicDetails']/p[2]";

	// values
	public String studenttest_clsize = "//div[@id='studentAttended']/p";
	public String tot_quest_count = "//div[@id='totalQuestionNumber']/p";
	public String tot_peerpoints = "//div[@id='totalPeerReviewPoints']/p";
	public String tot_testpoints = "//div[@id='totalTestPoints']/p";
	public String maxscorepos = "//div[@id='studentTotalScore']/p[2]";
	public String scorefrompeer_stud1 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[7]//span";
	public String tot_score_stud1 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[8]//span";
	public String rewardscore_stud1 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[6]//span";
	public String rewardscore_stud3 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[1]/td[6]//span";
	public String totalscore = "//p[@id='resultTotalScoreBadge']/span";

	// Grid Labels
	public String lblSIno = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(2)";
	public String lblStudentName = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(3)";
	public String lblquestanswered = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(4)";
	public String lblAnswerSheetReviewed = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(5)";
	public String lblRewardpoint = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(6)";
	public String lblsScoreReceivedfrom = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(7)";
	public String lblTotalScore = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(8)";
	public String lblAnswersheet = "#questionResultListingTable > div > div.p-datatable-wrapper> table > thead > tr > th:nth-child(9)";

	// student names in grid
	public String stud1ingrid = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[1]/td[3]/div";
	public String stud2ingrid = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[3]/div";
	public String stud3ingrid = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[3]/td[3]/div";

	// Student1 details
	public String stud1anscount = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[4]//span";
	public String stud2nameinstud1row = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[5]//div[1]/p-badge/span";
	public String stud3nameinstud1row = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[5]//div[2]/p-badge/span";
	public String stud3nameingrid = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[5]//div[2]/p-badge";

	// Statuspopup
	public String popup = "//p-dialog[@id='peerReviewStatusPopup']/div/div/div[2]";
	public String popup_lbl = "//p-dialog[@id='peerReviewStatusPopup']/div/div/div[1]";
	public String popup_closebtn = "//p-dialog[@id='peerReviewStatusPopup']/div//div[1]//button";
	public String studname_lbl = "//p-dialog[@id='peerReviewStatusPopup']//div[2]//div[1]/div[1]/p";
	public String popup_studname = "//p-dialog[@id='peerReviewStatusPopup']//div[2]//div[1]/div[2]/p";
	public String AnswerSheetAssigned_lbl = "//p-dialog[@id='peerReviewStatusPopup']//div[2]//div[2]/div[1]/p";
	public String peerreviewstudname = "//p-dialog[@id='peerReviewStatusPopup']//div[2]//div[2]/div[2]/div[1]/p-badge/span";
	public String peerreviewstudname1 = "//p-dialog[@id='peerReviewStatusPopup']//div[2]//div[2]/div[2]/div[2]/p-badge/span";
	public String PeerReviewCompletion = "//p-dialog[@id='peerReviewStatusPopup']//div[2]//div[3]/div[1]/p";
	public String popup_reviewpercent = "//p-dialog[@id='peerReviewStatusPopup']//div[2]//div[3]//div[2]//span";
	public String RewardScore_lbl = "//p-dialog[@id='peerReviewStatusPopup']//div[2]//div[4]/div[1]/p";
	public String eligible_txt = "//p-dialog[@id='peerReviewStatusPopup']//div[2]//div[4]//div[2]/p";
	public String popup_studorder = "//p-dialog[@id='peerReviewStatusPopup']//div/div[2]/div/div[2]/div[2]";

	// Wizards
	public String wizardq1 = "//p-paginator[@id='teacherEvaluationQuestionPaginator']//span/button[1]";
	public String wizardq2 = "//p-paginator[@id='teacherEvaluationQuestionPaginator']//span/button[2]";
	public String wizardq3 = "//p-paginator[@id='teacherEvaluationQuestionPaginator']//span/button[3]";
	public String wizard_nextbtn = "//p-paginator[@id='teacherEvaluationQuestionPaginator']/div/button[3]";
	public String Wizard_prevbtn = "//p-paginator[@id='teacherEvaluationQuestionPaginator']/div/button[2]";

	// Result window
	public String quest = "//body[@data-id='questionId']";
	public String answer_accordian = "//p-accordiontab[@id='teacherEvlauatePeerAnswerAccordionTab']/div";
	public String answer = "//body[@data-id='answerId']/p";
	public String rubric_aacordian = "//p-accordiontab[@id='teacherEvlauatePeerStandardRubricAccordionTab']/div";
	public String rubric = "//body[@data-id='standardRubricId']/p";
	public String sample_aacordian = "//p-accordiontab[@id='teacherEvlauatePeerSampleAccordionTab']/div";
	public String sample = "//body[@data-id='sampleAnswerId']/p";

	public String mark_assign_lbl = "//div[@id='evaluationPeerStudentsSection']//label/strong";
	public String studname1 = "//div[@id='evaluationPeerStudentsSection']/div[2]/p-accordion//p-accordiontab//span[2]";
	public String studname2 = "//div[@id='evaluationPeerStudentsSection']/div[3]/p-accordion//p-accordiontab//span[2]";
	public String stud2part = "//div[@id='evaluationPeerStudentsSection']/div[3]/p-accordion//p-accordiontab/div/div[1]";
	public String stud1part = "//div[@id='evaluationPeerStudentsSection']/div[2]/p-accordion//p-accordiontab/div/div[1]";
	public String answrpart = "//p-accordiontab[@id='teacherEvlauatePeerAnswerAccordionTab']/div/div[1]";

	public String score_stud1 = "//input[@id='evaluationMaxScoreResult_0']";
	public String score_stud2 = "//input[@id='evaluationMaxScoreResult_1']";

	public String score_frompeerlbl = "#evaluationPeerReviewScoreBadge > span";

	// Label in result window of studentsheet
	public String quest_lbl = "//p-badge[@id='teacherEvlauateQuestionNoTextBadge']/span";
	public String reviewstatus = "//p-badge[@id='resultPeerReviewStatusBadge']/span";
	public String maxscore_lbl = "//p-badge[@id='teacherEvlauateQuestionMaxScoreTextBadge']/span";
	public String scorefrompeer_lbl = "#teacherEvlauateScoreReceivedFromPeerTextBadge > span";
	public String final_scrorelbl = "//p-badge[@id='teacherEvlauateFinalscoreTextBadge']/span";
	public String totalscr_lbl = "//p[@id='resultTotalScoreBadge']";

	// peer-review page students name
	public String peerstud1 = "//p-table[@id='tstPeerReviewTable']//div[1]/table//tr[1]/td[3]//div[1]/p-badge/span";
	public String peerstud2 = "//p-table[@id='tstPeerReviewTable']//div[1]/table//tr[1]/td[3]//div[2]/p-badge/span";
	
	
}
