package QuestionBankofIndividualTeacherPage;

import SPRautomation.StudentPeerReview.basePage;

public class ImportQuestionPage extends basePage {
	
	//Question Bank popup
	public String Questionbnkpopup = "//p-dialog[@id='tstCreateCategory']/div/div";
	public String Quest_bnk_lbl = "//p-dialog[@id='tstCreateCategory']/div/div/div/span";
	public String quest_popup_close = "//p-dialog[@id='tstCreateCategory']//div[1]/div/button";
	public String search_quest = "//p-table[@id='question-bank-table']//div[1]/div/span/input";
	public String catdropdwn = "//span[@id='searchCourseFilterSpan']//p-multiselect//div[3]/span";
	
	
	//Libraries
	public String cat3 = "//span[@id='searchCourseFilterSpan']//div[4]/div[2]/ul/p-multiselectitem[2]/li/div[2]";
	public String cat2 = "//span[@id='searchCourseFilterSpan']//div[4]/div[2]/ul/p-multiselectitem[3]/li/div[2]";
	public String cat1 = "//span[@id='searchCourseFilterSpan']//div[4]/div[2]/ul/p-multiselectitem[4]/li/div[2]";
	
	//Buttons
	public String addnewqs_btn="//p-button[@id='createNewCourseBtn']//button";
	
	
}
