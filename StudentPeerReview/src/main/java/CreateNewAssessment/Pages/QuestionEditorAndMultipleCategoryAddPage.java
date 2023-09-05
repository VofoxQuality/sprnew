package CreateNewAssessment.Pages;

import SPRautomation.StudentPeerReview.basePage;

public class QuestionEditorAndMultipleCategoryAddPage extends basePage{
	
//Category dropdown box

public String Catdrop_box = "//*[@id='questionCategoryID']/div/div[4]";
	
//create Category close button
public String creat_cat_close_btn = "//*[@id='tstCreateCategory']/div/div/div[1]/div/button";
public String cre_cat_textbox = "//*[@id='categoryName']";
public String Cre_cat_box = "#tstCreateCategory > div > div";
public String clos_btn_added_cat = "div.category-chips-main > span:nth-child(1) > p-chip > div > span.pi-chip-remove-icon";
public String catagory_createbtn="//button[@id='createCategory']";

//labels
public String add_cat_search = "ul > p-multiselectitem:nth-child(2) > li.p-multiselect-item > div.ng-star-inserted";
public String no_resultfound = "div.p-multiselect-items-wrapper > ul > li.p-multiselect-empty-message";
public String categorysearchbx="div.p-multiselect-filter-container> input";

//validation messages
public String cat_duplic_validation = "//input[@id='categoryName']//following::div[contains(@class,'p-error small')]";

//Question Editor Buttons
public String bold_btn = "//*[@id='question']/div/div[1]/div[1]//div[2]/button[1]";
public String italic_btn = "//*[@id='question']/div/div[1]/div[1]//div[2]/button[2]";
public String underlin_btn = "//*[@id='question']/div/div[1]/div[1]//div[2]/button[3]";
public String image_btn= "//*[@id='image_upload_question_editor']";
public String video_btn = "//*[@id='media_upload_question_editor']";
public String math_editor = "//*[@id='question']/div/div[1]//div/div[10]/button[1]";
public String chem_editor = "//*[@id='question']/div/div[1]//div/div[10]/button[2]";
public String link_btn = "//*[@id='link_upload_question_editor']";
public String added_link = "//*[@id='tinymce']//a[1]";
public String rubric_math_edit = "//*[@id='rubrics']/div/div[1]//div/div[10]/button[1]";

//Image upload popup buttons
public String clos_btn = "div.tox-dialog>div>button";
public String cancel_btn = "div.tox-dialog__footer-end > button:nth-child(1)";
public String save_btn = "div.tox-dialog__footer-end > button:nth-child(2)";

//Math editor buttons
public String math_popup = "//*[@id='wrs_modal_dialogContainer[0]']";
public String math_close_btn = "//*[@id='wrs_modal_close_button[0]']";
public String math_insert_btn = "//*[@id='wrs_modal_button_accept[0]']";
public String math_cancel_btn = "//*[@id='wrs_modal_button_cancel[0]']";
public String upload_eqn_questbox = "//*[@id='tinymce']/p[2]/img";

public String tabdraft = "//span[contains(text(),'Draft')]";
public String course_txtbox = "//*[@id='courseId']/div/span";
}
