package CreateNewAssessment.Pages;

import SPRautomation.StudentPeerReview.basePage;

public class SummaryQuestionClickableRubircPage extends basePage {

public String max_score_click = "//*[@id='summaryRubricSum']";
public String close_btn_editpop = "//app-question-summary/p-sidebar/div/div/button";
public String cancel_btn_editpop = "//app-edit-question/form/div/div[2]/p-button[1]/button";
public String del_quest3 = "//*[@id='tstQstnTable']/div/div/table/tbody/tr[3]/td[7]/div/button[2]";
public String del_text = "div.summary-delete-popup > div.p-confirm-popup-content > span";
public String no_btn_del = "button.p-confirm-popup-reject";
public String yes_btn_del = "button.p-confirm-popup-accept";
public String save_btn_editpopup = "//app-edit-question/form/div/div[2]/p-button[2]/button";

public String remove_col_confir = "//*[@id='tstSummaryConfirm']/div/div";
public String conf_hd = "//*[@id='tstSummaryConfirm']/div//div/div[1]/span[1]";
public String conf_text = "//*[@id='tstSummaryConfirm']/div/div/div[2]/span";
public String cont_edit_btn = "//*[@id='tstSummaryConfirm']/div/div/div[3]/button[1]";
public String confirm_yes_btn = "//*[@id='tstSummaryConfirm']/div/div/div[3]/button[2]";
public String disc_btn = "//*[@id='tstSummaryConfirm']/div/div/div[3]/button[2]";
public String std_rub_bx = "//body[@data-id='rubrics']"; 
public String condit1_box = "//body[@data-id='editorFieldRubric_00']";
}
