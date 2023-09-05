package PeerReviewWindowofIndividualStudentPages;

import SPRautomation.StudentPeerReview.basePage;

public class ReviewByMultipleStudentsPage extends basePage {
	
	//labels in peer review and summary page
	public String reviewans_sheetdropdwn = "//p-dropdown[@id='tstNoOfPeer']/div/span";
	public String reviewssheet_count = "//p-dropdown[@id='tstNoOfPeer']//div[3]//ul/p-dropdownitem[3]/li";	
	public String Summary_quest = "//div[@class='course-container']/div[2]//div[2]//app-question-summary//h5";
	public String total_questcount = "//*[@id='tstTotalQstnBadge']/span";
	public String max_scorepos_count = "//*[@id='tstMaxScoreBadge']/span";

	
	//wizard
	public String wizardans1 = "//*[@id='pages']/div/span/button[1]";
	public String wizardans2 = "//*[@id='pages']/div/span/button[2]";
	public String wizardans3 = "//*[@id='pages']/div/span/button[3]";
	public String wizardans4 = "//*[@id='pages']/div/span/button[4]";

	//Answerboxes
	public String stud1Answerbox="//body[@data-id='answerViewEditor_0']";
	public String stud2Answerbox="//body[@data-id='answerViewEditor_1']";
	public String stud3Answerbox="//body[@data-id='answerViewEditor_2']";

	//Rubric
	public String RubricAccordian="//div[@id='questionDetails']/div[4]/p-accordion/div/p-accordiontab/div/div[1]/a";
	public String Rubric_view="//body[@data-id='standardRubricViewEditor']";

	//Sample answer section
	public String SampleAnsAccordian="//div[@id='questionDetails']/div[3]/p-accordion/div/p-accordiontab/div/div[1]/a";
	public String SampleAns_view="//body[@data-id='sampleAnswerViewEditor']";
	public String stud3comment="//form[@id='peerStudentsForm']/div/div[4]/p-accordion/div/span/span[1]/input";
	

	//label
	public String lblstud1="//form[@id='peerStudentsForm']/div/div[2]/p-accordion/div/p-accordiontab/div/div[1]/a/span[2]";
	public String lblstud2="//form[@id='peerStudentsForm']/div/div[3]/p-accordion/div/p-accordiontab/div/div[1]/a/span[2]";
	
	//Accordian
	public String stud1accordian="//form[@id='peerStudentsForm']/div/div[2]/p-accordion/div/p-accordiontab/div/div[1]/a";
	public String stud1accordian_1="//form[@id='peerStudentsForm']/div/div[2]/p-accordion/div/p-accordiontab/div/div[1]";
	public String stud2accordian="//form[@id='peerStudentsForm']/div/div[3]/p-accordion/div/p-accordiontab/div/div[1]/a";
	public String stud2accordian_1="//form[@id='peerStudentsForm']/div/div[3]/p-accordion/div/p-accordiontab/div/div[1]";
	public String stud3accordian="//form[@id='peerStudentsForm']/div/div[4]/p-accordion/div/p-accordiontab/div/div[1]/a";
	
	public String stud3accordian_1="//form[@id='peerStudentsForm']/div/div[4]/p-accordion/div/p-accordiontab/div/div[1]";
	public String scorestud3="//form[@id='peerStudentsForm']/div/div[4]/p-accordion/div/span/span[2]/input";
	  
	//current assessment tab
	public String selectedcurrenttab="//p-tabview[@id='assessmentTabs']/div/ul/li[1]/a";

	//comment popup text are
	public String txtbx_comment="p-overlaypanel > div > div > textarea";
	
	//rubric box
	public String c1row1="//p-accordiontab[@id='tstQuestionAccordianTab_1']//child::app-rubric-score-card//div[contains(@class,'removablesCell_00')]";
	public String c1row2="//p-accordiontab[@id='tstQuestionAccordianTab_1']//child::app-rubric-score-card//div[contains(@class,'removablesCell_01')]";
	public String c2row1="//p-accordiontab[@id='tstQuestionAccordianTab_1']//child::app-rubric-score-card//div[contains(@class,'removablesCell_10')]";
	public String c2row2="//p-accordiontab[@id='tstQuestionAccordianTab_1']//child::app-rubric-score-card//div[contains(@class,'removablesCell_11')]";
	
	
	public String c1row1score="//p-accordiontab[@id='tstQuestionAccordianTab_1']//child::app-rubric-score-card//div[contains(@class,'removablesCell_00')]/p/span";
	public String c1row2score="//p-accordiontab[@id='tstQuestionAccordianTab_1']//child::app-rubric-score-card//div[contains(@class,'removablesCell_01')]/p/span";
	public String c2row1score="//p-accordiontab[@id='tstQuestionAccordianTab_1']//child::app-rubric-score-card//div[contains(@class,'removablesCell_10')]/p/span";
	public String c2row2score="//p-accordiontab[@id='tstQuestionAccordianTab_1']//child::app-rubric-score-card//div[contains(@class,'removablesCell_11')]/p/span";

}
