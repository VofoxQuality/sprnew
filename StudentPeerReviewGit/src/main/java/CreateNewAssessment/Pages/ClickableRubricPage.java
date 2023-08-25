package CreateNewAssessment.Pages;

import org.openqa.selenium.JavascriptExecutor;

import SPRautomation.StudentPeerReview.basePage;

public class ClickableRubricPage extends basePage{

	
//Labels
public String criteria1_lbl = "//table[@id='rubricMainTable']//tr[1]//p/span";
public String score_fr_column1_lbl = "//table[@id='rubricMainTable']//td[1]//div[@class='rubric-editor-alignment position-relative']/child::span[1]";
public String criteria2_lbl = "//*[@id='rubricMainTable']/tbody/tr[2]/th/p/span";
public String confirm_txt_lbl = "//p-confirmdialog[@id='tstConfirmation']//div[2]/span";
public String valid_msg_score ="//div[@id='rubricMain']//td//small[1]";
public String underlined_txt = "//span[@style='text-decoration: underline;']";
public String math_typ_lbl = "//div[@id='wrs_modal_title[0]']";
public String chem_typ_labl = "//div[@id='wrs_modal_title[0]']";
public String score_fr_column2_lbl = "//table[@id='rubricMainTable']//tr[1]//td[2]//div[@class='rubric-editor-alignment position-relative']/child::span[1]";
public String bold_italic_text = "//*[@id='tinymce']/p/em/strong";
//buttons
public String No_btn = "//p-confirmdialog[@id='tstConfirmation']//div[3]//button[1]//span[2]";
public String yes_btn = "//p-confirmdialog[@id='tstConfirmation']//div[3]//button[2]//span[2]";
public String cont_edit_btn = "//p-confirmdialog[@id='tstConfirmation']//div[3]/button[1]";
public String dis_btn = "//p-confirmdialog[@id='tstConfirmation']//div[3]/button[2]";
public String Quest_wizard = "//div[@id='stepperDiv']//li[2]//span[1]";
public String Bold_btn = "//div[@class='rubric-editor-alignment position-relative']//button[@title='Bold']";
public String italic_btn = "//div[@class='rubric-editor-alignment position-relative']//button[@title='Italic']";
public String underline_btn = "//div[@class='rubric-editor-alignment position-relative']//button[@title='Underline']";
public String math_edit_btn = "//div[@class='rubric-editor-alignment position-relative']//button[@title='Insert a math equation - MathType']";
public String chem_edit_btn = "//div[@class='rubric-editor-alignment position-relative']//button[@title='Insert a chemistry formula - ChemType']"; 
public String math_cancel = "//button[@id='wrs_modal_button_cancel[0]']";
public String conf_close_btn = "//*[@id='tstConfirmation']/div/div/div[1]/div/button";

//textboxes
public String scre_rw1 = "//input[@id='scoreField_10']";
public String crit1_bx = "//div[@id='rubricMain']//tr[1]//textarea[@id='criteriaInput']";
public String scre_col1 = "//input[@id='scoreField_00']";
public String enter_con = "//*[@id='tinymce']";
public String math_edit_bx = "//div[@id='wrs_modal_wrapper[0]']";
public String chem_edit_bx = "//div[@id='wrs_modal_wrapper[0]']";
public String scre_col2 = "//input[@id='scoreField_01']";
public String scre_col3 = "//input[@id='scoreField_02']";
public String crit2_bx = "//div[@id='rubricMain']//tr[2]//textarea[@id='criteriaInput']";
public String crit3_bx = "//div[@id='rubricMain']//tr[3]//textarea[@id='criteriaInput']";
public String scrore_r21 = "//input[@id='scoreField_10']";
public String score_r22 = "//input[@id='scoreField_11']";
public String std_rub_txtbx = "//*[@id='rubric']/div/div[1]/div[2]/div[1]";
public String score_r23 = "//input[@id='scoreField_12']";
public String score_r30 = "//input[@id='scoreField_20']";
public String score_r31 = "//input[@id='scoreField_21']";
public String score_r32 = "//input[@id='scoreField_22']";

//placeholders
public String criteria1_place = "//textarea[@placeholder='Enter Criteria 1']";
public String enter_scr = "//input[@placeholder='Enter Score']";	
public String clic_rub_place = "//body[@aria-placeholder='Enter Condition']";


//popups
public String confirm_pop = "//*[@id='tstConfirmation']/div/div";
public String lblpopConfirm_RemvLstColm="//*[@id='tstConfirmation']//div[2]/span";

//Toasters

	public String toaster_1 = "div>p-toastitem:nth-child(1)>div";
	public String toaster_2 = "div>p-toastitem:nth-child(2)>div";
	public String toaster_3 = "div>p-toastitem:nth-child(3)>div";

	public String toaster1 = "//div[@id='rubricError8']";
	public String toasterclosebtn1 = "//div[@id='rubricError8']//button";

	public String toaster2 = "//div[@id='criteriaError5']";
	public String toasterclosebtn2 = "//div[@id='criteriaError5']//button";
	
	
	public String toasterquestion="//div[@id='rubricError7']";
	public String toasterquestionclosebtn = "//div[@id='rubricError7']//button";

	
//Maxscore box
public String maxscr_0 = "//input[@class='pl-2 ng-pristine ng-invalid ng-touched']";
public String maxscr_std = "//input[@class='pl-2 ng-untouched ng-pristine ng-valid']";

//scroll up 
public void scrolup()
{
JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("scroll(0, -250);");
return ;
}
	
}
