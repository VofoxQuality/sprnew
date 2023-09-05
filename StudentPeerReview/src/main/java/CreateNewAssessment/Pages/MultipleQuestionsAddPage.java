package CreateNewAssessment.Pages;

import SPRautomation.StudentPeerReview.basePage;

public class MultipleQuestionsAddPage extends basePage {

//buttons
	  public String btnDiscard = "//*[@id='tstAlertBox']/div[3]/button[1]";
	  
public String add_quest_btn = "//button[@id='addPage']";
public String q3_btn_higlight="//button[contains(@class,'p-paginator-page p-paginator-element p-link p-ripple ng-star-inserted p-highlight')]";
public String q1_btn = "//span[@class='p-paginator-pages ng-star-inserted']//button[1]";	
public String q2_btn = "//span[@class='p-paginator-pages ng-star-inserted']//button[2]";	
public String q4_btn = "//span[@class='p-paginator-pages ng-star-inserted']//button[4]";
public String q3_btn = "//span[@class='p-paginator-pages ng-star-inserted']//button[3]";	
	
}
