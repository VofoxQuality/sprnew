package CreateNewAssessment.Pages;

import SPRautomation.StudentPeerReview.basePage;

public class SummaryQuestionsPage extends basePage {

//Schedule page
public String mailcheckbox_tick = "//*[@id='mailNotification']/div/div[2]/span";	

//Summary page
//public String summary_wizard_high = "//div[@id='stepperDiv']/p-steps/div/ul/li[5]";
public String summary_wizard_high ="//*[@id='stepperDiv']/p-steps/div/ul/li[5]";
//Labels
public String Summary_quest = "//div[@class='course-container']/div[2]//div[2]//app-question-summary//h5";
public String total_questcount = "//*[@id='tstTotalQstnBadge']/span";
public String max_scorepos_count = "//*[@id='tstMaxScoreBadge']/span";
public String total_test_points="//p-badge[@id='tstTotalTestPointsBadge']//span";
public String total_peerview_score="//p-badge[@id='tstTotalPeerScoreBadge']//span";
public String total_testscore = "//*[@id='tstTotalTestPointsBadge']/span";
public String total_peereviewvalue = "//*[@id='tstTotalPeerScoreBadge']/span";
public String max_score="//*[@id='maxScore']";

public String peer_reward_scorebx = "//input[@id='rewardScore']";
//Question contents
public String quest1 = "//*[@id='tstQstnTable']//div//tr[1]/td[3]/div";
public String quest2 = "//*[@id='tstQstnTable']//div//tr[2]/td[3]/div";
public String quest3= "//*[@id='tstQstnTable']//div//tr[3]/td[3]/div";
public String quest4= "//*[@id='tstQstnTable']//div//tr[4]/td[3]/div";
public String quest5 = "//*[@id='tstQstnTable']//div//tr[5]/td[3]/div";
public String quest6 = "//*[@id='tstQstnTable']//div//tr[6]/td[3]/div";

//Marks of each questions
public String markquest1 = "//*[@id='tstQstnTable']//div//tr[1]/td[6]/div/input";
public String markquest2 = "//*[@id='tstQstnTable']//div//tr[2]/td[6]/div/input";
public String markquest3 = "//*[@id='tstQstnTable']//div//tr[3]/td[6]/div/input";
public String markquest4 = "//*[@id='tstQstnTable']//div//tr[4]/td[6]/div/input";
public String markquest5 = "//*[@id='tstQstnTable']//div//tr[5]/td[6]/div/input";
public String markquest6 = "//*[@id='tstQstnTable']//div//tr[6]/td[6]/div/input";

//public String grandtotal_count = "//div[@class='course-container']//app-question-summary/div[2]/div/div/input";
public String grandtotal_count="//div[@class='course-container']//app-summary/div/div[2]/div/app-question-summary/div[2]/div/div/strong";
public String max_mark = "//p-badge[@id='tstMaxScoreBadge']/span";

//Rubrics of Questions
public String rubquest1 = "//*[@id='tstQstnTable']//div//tr[1]/td[4]/div";
public String rubquest2 = "//*[@id='tstQstnTable']//div//tr[2]/td[4]/div";
public String rubquest3 = "//*[@id='tstQstnTable']//div//tr[3]/td[4]/div";
public String rubquest5 = "//*[@id='tstQstnTable']//div//tr[5]/td[4]/div";
public String rubquest6 = "//*[@id='tstQstnTable']//div//tr[6]/td[4]/div";



public String samquest6 = "//*[@id='tstQstnTable']//div//tr[6]/td[5]/div";

//Edit button of each questions
public String edit_quest1 = "//*[@id='tstQstnTable']//div//tr[1]/td[7]//button[1]";
public String edit_quest2 = "//*[@id='tstQstnTable']//div//tr[2]/td[7]//button[1]";
public String edit_quest3 = "//*[@id='tstQstnTable']//div//tr[3]/td[7]//button[1]";
public String edit_quest4 = "//*[@id='tstQstnTable']//div//tr[4]/td[7]//button[1]";
public String edit_quest5 = "//*[@id='tstQstnTable']//div//tr[5]/td[7]//button[1]";
public String edit_quest6 = "//*[@id='tstQstnTable']//div//tr[6]/td[7]//button[1]";

//edit popup
//public String editpopup = "//app-summary/div[2]/div/app-question-summary/p-sidebar/div";
public String editpopup="//app-summary/div/div[2]/div/app-question-summary/div[2]/p-sidebar/div/div/app-edit-question/form";
public String editquest_label ="//app-summary/div/div[2]/div/app-question-summary/div[2]/p-sidebar/div/div/app-edit-question/h3";
public String quest1_label = "//p-accordion[@id='tstQuestionEditAccordian']//a//span[2]";
public String save_btn_editpop = "//app-edit-question/form/div/div[2]/p-button[2]/button";


//Question editor buttons on edit popup
public String imag_btn_editpop = "//*[@id='image_upload_editQes_editor']";
public String video_btn_editpop = "//*[@id='media_upload_editQes_editor']";
public String imag_btn_stdrub = "//*[@id='image_upload_editRubric_editor']";
public String video_btn_stdrub = "//*[@id='media_upload_editRubric_editor']";
public String edit_pop_std_rubox = "//body[@data-id='rubrics']";

public String equationineditor_std = "//*[@data-id='rubrics']//child::p[1]/img";
public String equationeditor_quest = "//*[@data-id='question']//child::p[1]/img";
public String quest_edit_video = "//*[@id='tinymce']/p/span";

public String assesment_label="//div[@id='tstSummaryAssessmentDetailsSection']//h6";
//public String assesment_label="//app-summary/div/div[1]/div";
public String course_label="//div[@id='tstSummaryAssessmentDetailsSection']//p//strong";
public String course_name="//div[@id='tstSummaryAssessmentDetailsSection']//p";
public String preview_btn="//p-button[@id='previewBtn']//button";
public String discard_btn="//p-button[@id='discardBtn']//button";
public String save_exit_btn="//p-button[@id='saveExitBtn']//button";
public String release_btn="//p-button[@id='publishBtn']//button";

public String assesment_edit_btn="//i[@id='tstEditBasicDetails']";
public String assesment_info_location="//div[@id='tstAssessmentInfoSection']//div//div//div[1]//h5";
public String assesment_instruction="//*[@id='tstAssessmentInfoSection']//div//div//div[2]//h5";
public String discard_btn1="//p-button[@id='discardBtn']//button";
public String discard_popup="#tstStepConfirm > div > div";
public String confirmation_txt="//*[@id='tstStepConfirm']//div//div//div[2]//span";
public String cancel_btn="//p-confirmdialog[@id='tstStepConfirm']//div//div//div[3]//button[1]";
public String course_drpdown="#courseId > div > span";
public String Save_btn="//p-button[@id='saveNextBtn']/button"; 
public String validation_msg="//input[@id='assessmentName']//following::small";
public String assesment_txtbx="//input[@id='assessmentName']";
public String assesment_label1="//strong[text()='Assessment Information for Students']";
public String discard_btn2="//span[text()='Discard']";
public String questionwizard="//a[@id='tstQstnStep']//parent::li";
public String draft_tab="#assessment_tab_list > p-tabview > div > ul > li:nth-child(2)";
public String draft_assesment_name="//p-table[@id='draft_main_table']//tbody/tr[1]//td[4]//div";
public String new_assesment_name="//div[@id='tstSummaryAssessmentDetailsSection']//h6//span";
public String continue_editing_btn="//p-button[@id='continue_edit_btn']//button//span";
public String label_result_publish_method="//div[@id='result-method-section']";
public String open_assesment_date="(//input[@id='navigators'])[1]";
public String edit_btn_result="//*[@id='tstEditSchedule']";
public String time_txtbox="//p-calendar[@id='spTestStartTimeCalendar']/span/input";
public String pm_btn="//html//body//div[2]//div//div[4]//button[1]";
public String time_btn="/html/body/div[2]/div/div[1]/button[1]";
public String summary_pg_discard_popup_btn="//p-confirmdialog[@id='tstStepConfirm']//div[3]//button[2]";
public String assessmentopendate_txtbx = "//p-calendar[@id='spTestStartDateCalendar']/span/input";
public String calender_date_today="//td[contains(@class,'p-datepicker-today')]";
public String assesment_instruction_txtbx="//iframe[@id='assessment-instructions_ifr']";
public String assesment_information_txtbx="//iframe[@id='assessment-info_ifr']";
public String edit_btn2="//*[@id='tstEditInfo']";
public String assesment_box="//body[@data-id='assessmentInfo']";
public String instruction_box="//body[@data-id='instructions']";
public String assesment_info_txt="//body[@data-id='assessment-instructions']//p[1]";
public String instruction_txt="//body[@data-id='assessment-info']//p[1]";
public String course_tab="//div[@id='navbar-menu']//div//a[1]";
public String current_tab="//span[@id='current_asm_text']";
public String grand_total="//div[@class='pt-3 text-right summary-total']//label";
public String drag1="//*[@id='tstQstnTable']/div/div/div/div[2]/table/tbody/tr[1]/td[1]/span";
}
