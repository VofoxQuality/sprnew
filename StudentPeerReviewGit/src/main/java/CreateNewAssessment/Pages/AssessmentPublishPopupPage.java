package CreateNewAssessment.Pages;

import SPRautomation.StudentPeerReview.basePage;

public class AssessmentPublishPopupPage extends basePage {

	//Publish Popup
	//Buttons
	public String relese_btn="#publishBtn > button";
	public String Backtomenu_btn="#backToMenu > button > span";
	public String close_btn="#category > div > div.ng-trigger.ng-trigger-overlayAnimation> div.p-multiselect-header.ng-star-inserted > button";
	public String create_btn="div.p-dialog-footer.ng-star-inserted > p-button > button";
	public String close_btn2="div.p-dialog-header.ng-star-inserted > div > button > span";
	public String close_btn3="div.category-chips-main.category-chips-overflow.ng-star-inserted > span:nth-child(1) > p-chip > div > span";
	public String close_btn4="div.category-chips-main.category-chips-overflow.ng-star-inserted > span:nth-child(2) > p-chip > div > span";
	
	//popup
	public String publish_popup="div.p-dialog-content > app-assessment-success-popup > div";
	public String category_popup="#category > div > div.ng-trigger.ng-trigger-overlayAnimation";
	public String createcategory_popup=" div.course-container.create-category-popup.ng-star-inserted > p-dialog > div > div";
	
	//label
	public String Assessmentcreated_lbl=" div.p-dialog-content > app-assessment-success-popup > div > div > div > h6";
	public String YourAssess_lbl=" div.p-dialog-content > app-assessment-success-popup > div > div > div > p";
	public String createnewcat_lbl="div.create-category-list-btn.bg-white.ng-star-inserted";
	public String Addthis_lbl=" div.p-dialog-content > app-assessment-success-popup > div > div > div > span";
	public String selectcate_lbl=" div.p-dialog-content > app-assessment-success-popup > div > div > div > div > p";
	public String createcate_lbl	=" div.p-dialog-header.ng-star-inserted>span";
	public String name_lbl="#nameLabel";
	public String addedcate_lbl="div.col-12.d-flex.flex-wrap.justify-content-center.category-chips-main> span > p-chip > div > div";
	public String addedcate_lbl2=" div.p-multiselect-items-wrapper > ul > p-multiselectitem:nth-child(2) > li";
	public String addedcate_lbl3=" div.justify-content-center.category-chips-main.category-chips-overflow.ng-star-inserted > span:nth-child(2) > p-chip > div > div";
	public String addedcate_lbl4=" div.p-multiselect-items-wrapper> ul > p-multiselectitem:nth-child(3) > li > div.ng-star-inserted";
	public String assess_lbl = "//div[@id='main_asm_heading']/div[1]/h4";
	
	//checkbox
	public String Addthis_chckbox="#addToLibrary > div > div.p-checkbox-box";
	public String Addthis_chckbox2="#addToLibrary > div > div.p-checkbox-box.p-highlight";
	public String checkbox1="div.p-checkbox.p-component.ng-star-inserted>div:nth-child(2)";
	
	public String cateone_chckbox=" div.p-multiselect-items-wrapper> ul > p-multiselectitem:nth-child(2) > li > div.p-checkbox.p-component > div";
	public String catetwo_chckbox="div.p-multiselect-items-wrapper > ul > p-multiselectitem:nth-child(3) > li > div.p-checkbox.p-component > div";
	
	//text box
	public String category_txtbox=" div.p-multiselect-filter-container.ng-star-inserted > input";
	public String name_txtbox="#assessmentCategoryName";
	
	//dropdown
	public String selectcate_d_1="//*[@id='category']";
	public String selectcate_d_2="#category > div > div.p-multiselect-trigger > span";
	public String selectcate_d_3="#category > div ";
	//tab
	public String currentassess_tab="#assessment_tab_list > p-tabview > div > ul>li:nth-child(1)>a";
	public String assessmntdraft_tab="#assessment_tab_list > p-tabview > div > ul>li:nth-child(2)>a";
}

