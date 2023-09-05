package TestWindowOfIndividualStudent;

import SPRautomation.StudentPeerReview.basePage;

public class TestWindowWizardPage extends basePage {

	//labels	
public String test_window_assess_name = "//div[@id='tstAssessmentBasicDetails']/h6";
public String course_name_id = "//div[@id='tstAssessmentBasicDetails']/p[1]";	
public String teach_name_testwindow = "//div[@id='tstAssessmentBasicDetails']/p[2]";	
public String time_status = "//p[@id='tstTimeLeft']";
public String questions_count = "//div[@id='questionDetails']/div[1]/div/label[1]";	
public String total_score = "//*[@id='questionDetails']/div[1]/div/label[2]";
public String max_score_txt = "//div[@id='questionDetails']/div[1]/p-badge[2]/span";
public String quest1_text = "//div[@id='questionDetails']/div[1]/p-badge[1]/span";
public String max_score_text = "//div[@id='questionDetails']/div[1]/p-badge[2]/span";
public String answer_incompl_txt = "//*[@id='tstQuestionAnswerForm']//div[1]/div[2]//div[1]/label";
public String assess_submitted_text = "//*[@id='tstSubmitAnswerPopup']//div[2]/div/div/h6";
public String ans_count = "//div[@id='studentAssessmentDataView']//div/div[3]/div/div[2]/div[2]/div/p";
public String time_card ="div[@id='studentAssessmentDataView']/div/div/div/div[1]/div/span";

	//Buttons
public String submit_btn = "//p-button[@id='submitBtn']";
public String save_btn_test = "//button[@id='tstBtnAnswerSave']";	
public String quest_1_wizard = "//*[@id='pages']/div/span/button[1]";
public String quest_2_wizard = "//*[@id='pages']/div/span/button[2]";
public String quest_3_wizard = "//*[@id='pages']/div/span/button[3]";
public String quest_4_wizard = "//*[@id='pages']/div/span/button[4]";
public String total_btn_wizard = "//*[@id='pages']/div/span/button";
public String backtoassess_btn = "//*[@id='backToMenu']/button";
public String save_next_dis = "//*[@id='saveNextBtn']/button";

	//Confirmation
public String confir_popup = "//*[@id='tstConfirmation']/div/div";
public String confirmation_txt = "//*[@id='tstConfirmation']//div/div[2]/span"; 
public String cancel_confi = "//*[@id='tstConfirmation']//div[3]/button[1]";
public String submit_confi = "//*[@id='tstConfirmation']//div[3]/button[2]";


	//Checkboxes
public String incomp_txt_checkbx = "//*[@id='tstIncompleteChkBox']";
public String check_bx_checked = "//*[@id='tstIncompleteChkBox']/div";

	//Textboxes
public String quest_box = "//*[@data-id='questionView']";
public String quest_box1 = "//*[@data-id='questionViewEditor']";

public String answer_bx = "//*[@data-id='answer']";

public String answer_bx_1 = "//*[@data-id='answerViewEditor_0']";
public String answer_bx_2 = "//*[@data-id='answerViewEditor_1']";

}