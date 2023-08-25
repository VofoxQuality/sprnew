package CreateNewAssessment.Pages;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import SPRautomation.StudentPeerReview.basePage;

public class QuestionPageBasicsPage extends basePage {

	// Labels
	public String hd_label11 = "//h1[text()='Login']";
	public String wel_label = "//h1[@class='page-title text-lg-left text-md-center']";
	public String courses_label = "//div[@class='page-title']";
	public String course_namegrid = "//div[@class='p-datatable-wrapper ng-star-inserted']//td[3]";
	public String manage_assess = "//p-splitbutton//ul//li[3]";
	public String manage_assessnew = "//p-splitbutton//ul//li[4]";
	public String Assessments = "//h4[@class='page-title']";
	public String basic_detls_wizard = "//div[@id='stepperDiv']//li[1]//span[2]";
	public String coursname_drp = "//p-dropdown[@id='courseId']//div[3]//li[1]";
	public String coursname_drp2 = "//p-dropdown[@id='courseId']//div[3]/div[2]//p-dropdownitem[2]/li";
	public String Quest_wizard = "//div[@id='stepperDiv']//li[2]//span[2]";
	public String creat_new_asesslabel = "//div[@id='stepperDiv']/div[1]";
	public String Assess_lbel = "//h6[@class='text-truncate']";
	public String course_label = "//p[@class='text-truncate']/strong";
	public String Add_rublabel = "//div[@role='tablist']//p-accordiontab[@header='Add Rubric']//a//span[2]";
	public String clickable_rubric="//*[@id='p-accordiontab-4-content']//div//div//div[1]//p-radiobutton[1]";
	public String Sample_ans_label = "//div[@role='tablist']//p-accordiontab[@header='Sample Answer']//a//span[2]";
	public String max_scoreposs = "//span[@class='total-score mr-2']";
	public String max_scorelabl = "//input[@id='maxScore']//parent::div//child::label";
	public String question_highlight = "//li[@class='p-steps-item ng-star-inserted p-back p-highlight p-steps-current p-disabled']";
	public String max_scoreposvalue = "//p-badge[@id='totalMark']";
	public String course_name = "//div[@id='tstQstnAssessmentDetailsSection']/p";
	public String creat_newcat = "//div[@class='create-category-list-btn bg-white ng-star-inserted']";
	public String question1 = "//p-accordion[@id='tstQuestionAccordian']//a[@role='tab']";
	public String added_cat = "div.category-chips-main > span:nth-child(1) > p-chip > div.p-chip > div";
	public String confirm_label = "//p-confirmdialog[@id='tstConfirmation']//div[1]/span";
	public String max_scoreposs_value = "//p-badge[@id='totalMark']/span";
	public String aded_cat_drop = "//li[@class='p-multiselect-item p-ripple']";
	public String peer_reviewlbl = "//a[@id='tstPeerReviewStep']/span[2]";
	public String basic_det_highlgt = "//div[@id='stepperDiv']//li[1]";
	public String lbl_assessmentinfo = "//input[@id='assessmentName']//following::label[1]";
	public String creat_course_dropdwn = "//*[@id='courseId']/div/div[3]/div[2]/ul/p-dropdownitem/li[1]";
	public String usr_nam = "//div[@class='username']";
	public String account_sett_labl = "//div[@class='login-right account-setting']/h1";
	public String sel_rubric_editor_label = "//p-accordion[@id='tstRubricsAccordian']//p-accordiontab/div/div[2]/div/div/div[1]/p";
	public String basic_det_highlight = "//div[@id='stepperDiv']//ul/li[1]";
	public String discard_changes_popuptxt = "//div[@id='tstAlertBox']/div[2]";
	public String current_assesslabel = "//span[@id='currentAssessment']";
	public String lbladdtoQnBank="//*[@id='courseDetail']//div[1]/div[1]/span";
	public String lblCreate_Cat="//*[@id='pr_id_9-label']";
	public String lblCreate_Catnew="//*[@id='tstCreateCategory']//span";
	public String lblPopConfirm_Rubric="//*[@id='tstConfirmation']//div[2]/span";
	
	public String lblName="//*[@id='nameLabel']";
	public String lblEnter_Qn="//body[@data-id='question']";
	public String lblAdd_Rubric="//*[@id='tstRubricsAccordian']//p-accordiontab/div/div[1]//span[2]";
	public String lblRubric_InfoStmt="//*[@id='tstRubricsAccordian']//p-accordiontab/div/div[1]//p";
	public String lbl_SelctRubricEdtr="//*[@id='tstRubricsAccordian']//p-accordiontab/div/div[2]//p";
	public String lblEmptyRubric_Msg="//*[@id='emptyRubricMsg']/div/p";
	public String lblSampleAns_Accord="//*[@id='tstSampleAnswerAccordian']//span[2]";
	public String lblSampleAns_InfoStmt="//*[@id='tstSampleAnswerAccordian']//p";
	public String expandSampleAns_Accord="//*[@id='tstSampleAnswerAccordian']//div/div/a";
	
	public String courseTitlelbl="//*[@id='courseDetail']/p-card//div[2]/div[1]/span/label";
	public String courseTitlestar="//*[@id='courseDetail']/p-card//div[2]/div[1]/span/label/span";
	public String lblScoreCol1_Criteria2="//*[@id='rubricMainTable']/tbody/tr[2]/td//div/span";
	public String lblEnterScore_Criteria2="//*[@id='rubricMainTable']/tbody/tr[2]/td//div/input";
	public String lblEnterCond_Criteria2="//*[@id='rubricMainTable']/tbody/tr[2]/td//editor//div[2]/div/iframe";
	public String lblValidation_Score="//*[@id='rubricMainTable']//small[1]";

	// buttons
	public String teach_btn = "//button[@class='btn outline-btn p-button p-component p-ripple']";
	public String create_coursebtn = "//button[@class='btn primary-btn p-button p-component p-ripple']";
	public String create_crsbtn = "//button[@id='createCourse']";
	public String details_drop = "//p-splitbutton//button[2]";
	public String cours_drp = "//p-dropdown[@id='courseId']";
	public String creatnew_assessbtn = "//p-button[@label='Create New Assessment']//span[2]";
	public String Savenext = "//p-button[@id='saveNextBtn']";
	public String discard_btn = "//p-button[@id='discardBtn']";
	public String Confirm_btnYes = "button.p-confirm-dialog-accept";
	public String copy_btn="//*[@id='copy']";
	public String btnSampleAns_Dropdown="//*[@id='tstSampleAnswerAccordian']//span";

	public String savexit_btn = "//p-button[@id='saveExitBtn']";
	public String savenext_btn = "//p-button[@id='saveNextBtn']";
	public String plus_btn = "//button[@id='addPage']";
	public String clear_all = "//button[@id='importQuestion']//following::button[1]";
	public String save = "//button[@id='saveQuesiton']";
	public String save1 = "//button[@id='saveQuesiton']/span";
	public String buttton1 = "//button[@class='p-paginator-page p-paginator-element p-link p-ripple ng-star-inserted p-highlight']";
	public String remove_quest = "//button[@id='removeQuesiton']";
	public String import_quest = "//button[@id='importQuestion']";
	public String rubric_drp_btn = "//p-accordion[@id='tstRubricsAccordian']//p-accordiontab//div[1]//div[1]/a/span[1]";
	public String sample_ans_btn = "//p-accordion[@id='tstSampleAnswerAccordian']//p-accordiontab//div[1]//div[1]/a/span[1]";
	public String cat_drop = "//p-multiselect[@id='questionCategoryID']";
	public String creat_cat = "//p-multiselect[@id='questionCategoryID']//div[1]/div[4]//ul//li[@class='p-multiselect-item p-disabled p-ripple']";
	public String catpop_creatbtn = "//button[@id='createCategory']";
	public String no_btn = "//p-confirmdialog[@id='tstConfirmation']//div[3]//button[1]";
	public String yes_btn = "//p-confirmdialog[@id='tstConfirmation']//div[3]//button[2]";
	public String add_column = "//button[@id='addColBtn']";
	public String remov_lastcolum = "//button[@id='removeColBtn']";
	public String add_row = "//button[@id='addRowBtn']";
	public String remov_lastrw = "//button[@id='removeRowBtn']";
	public String cat_clos_btn = "//p-multiselect[@id='questionCategoryID']//button";
	public String dis_pop_cancel_btn = "//div[@id='tstAlertBox']//button[2]";
	public String dis_pop_discard_btn = "//div[@id='tstAlertBox']//button[1]";
	public String acct_set = "//i[@class='fas fa-user-circle']";
	public String assessment_draftgrid = "//p-table[@id='draft_main_table']//div[1]/table//tr[1]/td[4]/div";
	public String add_quest_bnk_lbl = "//div[@id='courseDetail']//div[1]/div[1]/span";
	public String btn_CloseCreateCat="//*[@id='tstCreateCategory']/div/div/div[1]//button/span";
	public String btnClose_SelectCategory="//*[@id='questionCategoryID']//div[4]/div[1]/button/span";
	
	public String discardbtn_popup_cancel = "//p-confirmdialog[@id='tstStepConfirm']//div[3]//button[1]";
	public String discardbtn_popup_dis = "//p-confirmdialog[@id='tstStepConfirm']//div[3]//button[2]";
	public String discardbtn_popup_close = "//p-confirmdialog[@id='tstStepConfirm']/div/div/div[1]/div/button";
	public String btnPopConfirm_RubricDiscard="//*[@id='tstConfirmation']//div[3]/button[2]";
	public String btnPopConfirm_RubricContinue="//*[@id='tstConfirmation']//div[3]/button[1]";
	public String btnQuestion4_Page="//*[@id='pages']/div/span/button[4]";
	
	public String countinueconfirm ="//*[@id='tstConfirmation']/div/div/div[3]/button[1]/span[2]";
	
	//drop down
	
	public String ddlSelect_CreatedCategory="//p-multiselectitem[2]/li/div[2]";
	
	// textboxes
	public String txbx_Coursetitle = "//input[@id='courseTitle']";
	public String course_assess = "//p-dataview//p-dropdown/div/span";
	public String Assess_name = "//input[@id='assessmentName']";
	public String select_cat = "//div[@class='category-select']//p-multiselect/div";
	public String cat_box = "//div[@class='category-select']//div[4]";
	public String cat_searchbox = "div.p-multiselect-filter-container> input";
	public String cat_textbox = "//input[@id='categoryName']";
	public String Quest_box = "//body[@data-id='question']";
	
	public String quest_data = "//body[@data-id='question']/p[1]";
	public String std_rub_bx = "//body[@data-id='rubric']";
	public String max_scorbx = "//input[@id='maxScore']";
	public String add_quest_btn = "//button[@id='addPage']";
	public String sample_ansbx = "//body[@data-id='sampleAnswer']";
	public String txtQn_Accord="//*[@id='tstQuestionAccordian']//p-accordiontab//div[1]/a";
	public String txtStdRubric_Accord="//*[@id='tstRubricsAccordian']//a";
	public String txtStdRubric_Editr="//*[@id='rubric_ifr']";
	public String txtStdRubric_Editr1="//*[@data-id='rubric']";
	
	public String txtSampleAns_Editr="//*[@id='sampleAnswer_ifr']";
	public String txtSampleAns_Editr1="//*[@data-id='sampleAnswer']";
	
	

	// Tooltip
	public String Add_more_Quest = "//i[@ptooltip='Add More Questions']";
	public String Discard_tool = "//p-button[@ptooltip='Discard']";
	public String saveexit_tool = "//p-button[@ptooltip='Saves any current changes to the information on this screen and returns to the main Assessments screen']";
	public String savenext_tool = "//p-button[@ptooltip='Saves all changes to the current screen, if any, then proceeds to the next screen in the ‘Assessment Creation’ process']";
	public String Save_tool = "//button[@ptooltip='Save']";

	// Check-boxes
	public String quest_bankcheckbx = "//p-checkbox[@id='isQuestionBank']";

	public String chkAdd_QnBank="//*[@id='isQuestionBank']/div";

	public String add_cat_indrpdwn = "//*[@id='questionCategoryID']//p-multiselectitem[2]/li/div[2]";

	public String chkbx_questionbank = "#isQuestionBank > div > div.p-checkbox-box";
	public String quest_bank_tick = "//p-checkbox[@id='isQuestionBank']//div[2]";
	public String add_cat_checkbx = "//li[@class='p-multiselect-item p-ripple']//div[@class='p-checkbox-box'][1]";
	public String add_cat_tick = "//li[@class='p-multiselect-item p-ripple p-highlight']//span";
	public String cat_all_check = "//*[@id='questionCategoryID']/div/div[4]/div[1]/div[1]";
	public String chkSelect_Category="//*[@id='questionCategoryID']//div[4]/div[1]/div[1]";

	// toaster
	public String toaster = "//div[contains(@class,'p-toast-detail')]";
	public String toasterclosebtn = "//*[contains(@class,'p-toast-icon-close-icon')]";
	//public String toasterRubric1="//div[@id='rubricValidationError1']";
	public String toasterRubric1="//div[@id='rubricError1']/div/div/div[2]";
	//public String toasterRubric2="//div[@id='rubricError3']";
	public String toasterRubric2="//div[@id='rubricValidationError1']/div/div/div[2]";
	
	// info statements
	public String rubric_info = "//p-accordion[@id='tstRubricsAccordian']//p-accordiontab[1]//a/p[1]";
	public String sample_info = "//p-accordion[@id='tstSampleAnswerAccordian']//p-accordiontab[1]//a/p[1]";

	// Course code
	public String course_Id = "//*[@id='courseDetail']/p-card/div/div/div/form/div[1]/div/div/div[1]/div/span";

	// placeholders
	public String quest_bx_holder = "//body[@data-id='question']";
	public String click_rubric_holder = "//div[@id='emptyRubricMsg']//child::div/p";
	public String sample_ans_holder = "//body[@data-id='sampleAnswer']";
	public String select_categ = "//p-multiselect[@placeholder='Select Category']";
	public String std_rub_plac = "//body[@data-id='rubric']";
	public String placeholdrEntr_Criteria2="//*[@id='rubricMainTable']/tbody/tr[2]/th/span/textarea";

	// popups
	public String cat_pop = "//p-dialog[@id='tstCreateCategory']//div[@role='dialog']";
	public String confi_pop = "//p-confirmdialog[@id='tstConfirmation']/div[1]/div";
	public String discard_pop = "//div[@id='tstAlertBox']";
	public String discard_btn_conf_popup = "//p-confirmdialog[@id='tstStepConfirm']/div/div";
	public String popConfirm_Rubric="//*[@id='tstConfirmation']/div/div";
	
	// confirmation text
	public String text_confirm = "div.p-dialog-content> span";
	public String confir_label = "//p-confirmdialog[@id='tstStepConfirm']//div[1]/span";

	//Draft search box
	public String draftsearchbx="//input[@id='draft_search_filter']";
	public String srchIcon_selectCat="//*[@id='questionCategoryID']//div[4]/div[1]/div[2]/span";
	// tabs
	public String Assessmenttab = "//*[@id='assessmentsLinkStudent']";
	public String teach_assesstab = "//a[@id='assessmentMainTabHead']";
	public String tabdraft = "//div[@class='p-tabview p-component']//ul//li[3]";
	public String continue_edit = "//p-button[@label='Continue Editing']/button";
	public String course_tab = "//a[@id='myCoursesLinkStudent']";

	// radiobuttons
	public String click_radio = "//p-radiobutton[@label='Clickable Rubric']/div";
	public String std_rad = "//p-radiobutton[@label='Standard Rubric']";
	public String std_rubcheck = "//p-radiobutton[@label='Standard Rubric']/div";
	public String Qassessmentdetails="//div[@id='tstQstnAssessmentDetailsSection']";
	
	public void ScrollUp()
	{
		Actions a=new Actions(driver);
		a.sendKeys(Keys.PAGE_UP).build().perform();
		return;
	}
	public void ScrollDown()
	{
		Actions a=new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		return;
	}
	public void ScrollHome()
	{
		Actions actions=new Actions(driver);
		actions.sendKeys(Keys.HOME).build().perform();
		return;
	}
	public void ScrollEnd()
	{
		Actions actions=new Actions(driver);
		actions.sendKeys(Keys.END).build().perform();
		return;
	}


}
