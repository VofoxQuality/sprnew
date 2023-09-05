package PeerReviewWindowofIndividualStudentPages;

import SPRautomation.StudentPeerReview.basePage;

public class ModifyReviewWizardPanelPage extends basePage {

//Clickable Rubric Condition boxes
public String cond_00 = "//*[@data-id='editorFieldRubric_00']";
public String cond_01 = "//*[@data-id='editorFieldRubric_01']";
public String cond_02 = "//*[@data-id='editorFieldRubric_02']";
public String cond_10 = "//*[@data-id='editorFieldRubric_10']";
public String cond_11 = "//*[@data-id='editorFieldRubric_11']";
public String cond_12 = "//*[@data-id='editorFieldRubric_12']";
public String cond_20 = "//*[@data-id='editorFieldRubric_20']";
public String cond_21 = "//*[@data-id='editorFieldRubric_21']";
public String cond_22 = "//*[@data-id='editorFieldRubric_22']";

//Score tick mark
public String score_tick_stud2 = "//div[@id='answerPeerStudentsSection']/div[3]//p-accordion//span[3]/i";
public String score_tick_stud1 = "//div[@id='answerPeerStudentsSection']/div[2]//p-accordion//span[3]/i";

//Clickable Rubric criterias for Student2
public String crit1_stud2 = "//div[@id='answerPeerStudentsSection']/div[3]//div[@class='one-rubric-table']//tr[1]/td[1]/div";
public String crit2_stud2 = "//div[@id='answerPeerStudentsSection']/div[3]//div[@class='one-rubric-table']//tr[2]/td[1]/div";
public String crit3_stud2 = "//div[@id='answerPeerStudentsSection']/div[3]//div[@class='one-rubric-table']//tr[3]/td[1]/div";

//Clickable Rubric rows for student2
public String click_row11 = "//div[@id='answerPeerStudentsSection']/div[3]//div[@class='one-rubric-table']//tr[1]/td[2]";
public String click_row22 = "//div[@id='answerPeerStudentsSection']/div[3]//div[@class='one-rubric-table']//tr[2]/td[3]"; 
public String click_row33= "//div[@id='answerPeerStudentsSection']/div[3]//div[@class='one-rubric-table']//tr[3]/td[4]"; 

//Clickable Rubric rows for Student1
public String click_row11_stud1 = "//div[@id='answerPeerStudentsSection']/div[2]//div[@class='one-rubric-table']//tr[1]/td[2]";
public String click_row22_stud1 = "//div[@id='answerPeerStudentsSection']/div[2]//div[@class='one-rubric-table']//tr[2]/td[3]"; 
public String click_row33_stud1= "//div[@id='answerPeerStudentsSection']/div[2]//div[@class='one-rubric-table']//tr[3]/td[4]"; 

//labels
public String current_assess = "//*[@id='currentAssessment']";
public String stud_one_rub_label = "//p-accordiontab[@id='tstQuestionAccordianTab_0']//strong";
public String stud_two_rub_label = "//p-accordiontab[@id='tstQuestionAccordianTab_1']//strong";

//Button
public String viewdetails_btn = "//*[@id='teacherAssessmentDataView']//div[4]//button/span[2]";
public String discard_changes = "//button[@id='peerDiscardChangesBtn']";

//Tabs
public String mycourses_tab = "//a[@id='myCoursesLinkStudent']";
public String assess_tab = "//a[@id='assessmentsLinkStudent']";

//Discard Popup
public String discard_popup = "//div[@id='tstAlertBox']";
public String dis_popup_lbl = "//div[@id='tstAlertBox']/div[1]/h4";
public String dis_popup_txt = "//div[@id='tstAlertBox']/div[2]/p";
public String popup_dis_btn = "//div[@id='tstAlertBox']/div[3]/button[1]";
public String popup_cancel_btn = "//div[@id='tstAlertBox']/div[3]/button[2]";


}
