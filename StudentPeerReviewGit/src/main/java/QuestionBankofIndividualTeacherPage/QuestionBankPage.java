package QuestionBankofIndividualTeacherPage;

import SPRautomation.StudentPeerReview.basePage;

public class QuestionBankPage extends basePage{

	//Labels
	
public String libr_tab_lbl = "//app-header//div/div/div[2]/nav//a[3]";
public String quest_bnk_lbl = "//div[@id='librariesPageRow']/div[1]/div";	
public String cat_lbl = "//div[@id='searchCourseFilter']/label";
public String creat_new_cat_lbl = "//span[@id='searchCourseFilterSpan']//div[4]//ul/p-multiselectitem[1]/li/div[2]";
public String added_cat = "//div[@id='librariesPageRow']/div[3]//span//div/div";

	//Validation mesg
public String cat_val_msg = "//p-dialog[@id='tstCreateCategory']//div[2]/div/div/div";

	// Category dropdown

public String cat_dropdwn_btn = "//div[@id='mainLibrariesGrid']//p-multiselect//div[3]/span";
public String cat_drop_bx = "//span[@id='searchCourseFilterSpan']//p-multiselect/div/div[4]";
public String cat_search = "//span[@id='searchCourseFilterSpan']//div[4]/div[1]/div[2]/input";
public String al_checkbx = "//span[@id='searchCourseFilterSpan']//div/div[4]/div[1]/div[1]/div[2]";
public String close_btn = "//span[@id='searchCourseFilterSpan']//div[4]/div[1]/button";
public String added_cat_drpdwn = "//span[@id='searchCourseFilterSpan']//div[4]/div[2]/ul/p-multiselectitem[2]/li/div[2]";
public String added_cat_rw2= "//span[@id='searchCourseFilterSpan']//div[4]/div[2]/ul/p-multiselectitem[3]/li/div[2]";

	//New Category popup
public String cat_popup = "//p-dialog[@id='tstCreateCategory']/div/div";
public String catpopup_lbl = "//p-dialog[@id='tstCreateCategory']/div/div//div/span[1]";
public String name_lbl = "//label[@id='nameLabel']";
public String cat_textarea = "//input[@id='categoryName']";
public String create_btn = "//button[@id='createCategory']/span";
public String close_btn_popup = "//p-dialog[@id='tstCreateCategory']/div/div/div[1]/div/button";

	//Grid labels
public String sl_number = "//p-table[@id='question-bank-table']//div[2]/table//tr/th[1]";
public String quest_lbl = "//p-table[@id='question-bank-table']//div[2]/table//tr/th[2]";
public String Rubric_lbl = "//p-table[@id='question-bank-table']//div[2]/table//tr/th[3]";
public String samp_ans_lbl = "//p-table[@id='question-bank-table']//div[2]/table//tr/th[4]";
public String max_score_lbl = "//p-table[@id='question-bank-table']//div[2]/table//tr/th[5]";
public String link_tocat_lbl = "//p-table[@id='question-bank-table']//div[2]/table//tr/th[6]";
public String last_modified_lbl = "//p-table[@id='question-bank-table']//div[2]/table//tr/th[7]";
public String action_lbl = "//p-table[@id='question-bank-table']//div[2]/table//tr/th[8]";

public String no_quest_found_txt = "//p-table[@id='question-bank-table']//div[2]/table//tr/td";
public String tot_quest_lbl = "//div[@id='mainLibrariesGrid']//app-p-table-library/div[1]//span";
public String search_quest = "//p-table[@id='question-bank-table']//div[1]//span/input";

	//Selected category Names section
public String cat2_close = "//div[@id='librariesPageRow']//div/span[2]/p-chip//span";
public String cat1_close = "//div[@id='librariesPageRow']//div/span[1]/p-chip//span";

	//Buttons

public String add_new_quest_btn = "//p-button[@id='createNewCourseBtn']/button/span[2]";
public String cancel_btn = "//app-libraries//div/div//form//div[2]/p-button//span[2]";
public String save_btn = "//app-libraries//div//form//div[2]/div/p-button/button";

public String clr_al_btn = "//app-libraries//div//form/div/div[1]/div[1]/div/div[2]/button";

	//Add a new question popup
public String add_newquest_hd = "//app-libraries//div//app-view-question/h3";
public String cat_lbl_popup = "//app-view-question/form/div/div[1]//div[1]/label";
public String cat_drop_popup = "//p-multiselect[@id='categorySelectDropDown']//div[3]";
public String add_cat_popup = "//app-libraries/p-sidebar//form//div[1]/div[1]/div/span//div/div";
public String sel_cat_lbl = "//app-libraries/p-sidebar//form//div[1]/div[1]/div[1]/label";

	//Question Section
public String quest1_lbl = "//p-accordion[@id='tstQuestionEditAccordian']//a[@role='tab']";
public String quest_bx = "//body[@data-id='questionEditorId']";
public String maxscore="//input[@id='maxScore']";
public String rubric_lbl = "//div[@role='tablist']//p-accordiontab[@header='Rubric']//a//span[2]";
public String click_rubric_lbl = "//p-radiobutton[@label='Clickable Rubric']/label"; 
public String std_rubric_lbl = "//p-radiobutton[@label='Standard Rubric']/label";
public String rubric_bx = "//body[@data-id='rubricEditorId']";
public String max_scr = "//app-libraries//form/div/div[1]/div[1]/div/div[2]//input";
public String sample_ans_bx = "//body[@data-id='sampleAnswerEditorId']";

	//info text 
public String rubric_infotext = "//p-accordion[@id='tstRubricsEditAccordian']//p-accordiontab[1]//a/p[1]";
public String Elementcount="//*[@id='question-bank-table']/div/div[2]/table/tbody/tr";
public String search="#question-bank-table > div > div.p-datatable-header> div > span > input";
	//Questions in grid
public String q3_grid = "//p-table[@id='question-bank-table']//div[2]//tr[1]/td[2]/div";
public String q2_grid = "//p-table[@id='question-bank-table']//div[2]//tr[2]/td[2]/div";
public String q1_grid = "//p-table[@id='question-bank-table']//div[2]//tr[3]/td[2]/div";

public String modify_btn_rw1 = "//p-table//tr[1]/td[8]//p-button[@label='View/Modify']";
public String modify_btn_rw2 = "//p-table//tr[2]/td[8]//p-button[@label='View/Modify']";
public String modify_btn_rw3 = "//p-table//tr[3]/td[8]//p-button[@label='View/Modify']";

public String del_btn_rw1 = "//p-table//tr[1]/td[8]//p-button[@label='Delete']";
public String del_btn_rw2 = "//p-table//tr[2]/td[8]//p-button[@label='Delete']";
public String del_btn_rw3 = "//p-table//tr[3]/td[8]//p-button[@label='Delete']";

public String rubrictick_rw1 = "//p-table[@id='question-bank-table']//tr[1]/td[3]/div";
public String rubrictick_rw2 = "//p-table[@id='question-bank-table']//tr[2]/td[3]/div";
public String rubrictick_rw3 = "//p-table[@id='question-bank-table']//tr[3]/td[3]/div";

public String sampletick_rw3 = "//p-table[@id='question-bank-table']//tr[3]/td[4]/div";
public String sampletick_rw1 = "//p-table[@id='question-bank-table']//tr[1]/td[4]/div";

public String maxscore_rw1 = "//p-table[@id='question-bank-table']//tr[1]/td[5]/div";
public String maxscore_rw2 = "//p-table[@id='question-bank-table']//tr[2]/td[5]/div";
public String maxscore_rw3 = "//p-table[@id='question-bank-table']//tr[3]/td[5]/div";

public String link_cat_rw1 = "//p-table[@id='question-bank-table']//tr[1]/td[6]/div";
public String link_cat_rw2 = "//p-table[@id='question-bank-table']//tr[2]/td[6]/div";
public String link_cat_rw3 = "//p-table[@id='question-bank-table']//tr[3]/td[6]/div";

public String date_rw1 = "//p-table[@id='question-bank-table']//tr[1]/td[7]/div";
public String date_rw2 = "//p-table[@id='question-bank-table']//tr[2/td[7]/div";
public String date_rw3 = "//p-table[@id='question-bank-table']//tr[3]/td[7]/div";

	//Confirmation
public String del_confpopup = "//p-confirmdialog[@id='libraryConfirmations']/div/div";
public String del_conf_hd = "//p-confirmdialog[@id='libraryConfirmations']/div/div/div[1]/span[1]";
public String del_conf_txt = "//p-confirmdialog[@id='libraryConfirmations']/div/div/div[2]/span[1]";
public String no_btn_del = "//p-confirmdialog[@id='libraryConfirmations']/div/div/div[3]/button[1]";
public String ys_btn_del = "//p-confirmdialog[@id='libraryConfirmations']/div/div/div[3]/button[2]";

public String val_msg1 = "//div[@id='rubricMain']//tr[1]/td//small[1]";
}
