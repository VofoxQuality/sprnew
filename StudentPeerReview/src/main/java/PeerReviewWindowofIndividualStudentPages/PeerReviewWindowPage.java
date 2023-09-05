package PeerReviewWindowofIndividualStudentPages;

import org.openqa.selenium.By;
import org.testng.Assert;

import SPRautomation.StudentPeerReview.basePage;

public class PeerReviewWindowPage extends basePage {

	// Select Category
	public String Categoryselect = "div.category-select";

	// Total Question count
	public String total_questcount = "//*[@id='tstTotalQstnBadge']/span";
	// Maximum score possible
	public String max_scorepos_count = "//*[@id='tstMaxScoreBadge']/span";
	// label Assessment
	public String lbl_Assessment = "#tstQstnAssessmentDetailsSection";

	// Editor buttons
	// Equation
	public String upload_eqn_questbox = "//img[@class='Wirisformula']";
	public String added_link = "//*[@id='tinymce']/p[3]/a";

	// Rubric image/video,equation,link
	public String rubricimage = "//button[@id='image_upload_rubric_editor']";
	public String rubricvideo = "//button[@id='media_upload_rubric_editor']";
	public String rubricEqation = "//button[@id='link_upload_rubric_editor']//following::button[contains(@title,'MathType')][1]";
	public String rubriclink = "//button[@id='link_upload_rubric_editor']";

	// Question sample Answer Accordian and details
	public String sampleAnsweraccordian = "#tstSampleAnswerAccordian > div > p-accordiontab > div";
	public String sampleanswerimage = "//button[@id='image_upload_sample_editor']";
	public String sampleanswervideo = "//button[@id='media_upload_sample_editor']";
	public String sampleanswerequation = "//button[@id='media_upload_sample_editor']//following::button[contains(@title,'MathType')][1]";
	public String sampleanswerlink = "//button[@id='link_upload_sample_editor']";
	// Question Total marks
	public String Questiontotalmark = "//p-badge[@id='totalMark']";

	// Clickable Rubric details
	public String clic_rub_place = "//body[@aria-placeholder='Enter Condition']";
	public String scre_col00 = "//input[@id='scoreField_00']";
	public String enter_con = "//*[@id='tinymce']";
	public String scre_col01 = "//input[@id='scoreField_01']";
	public String crit2_bx = "//div[@id='rubricMain']//tr[2]//textarea[@id='criteriaInput']";
	public String scrore_r10 = "//input[@id='scoreField_10']";
	public String score_r11 = "//input[@id='scoreField_11']";
	public String criteria1 = "#rubricMainTable > tbody > tr:nth-child(1) > th > span>textarea";
	public String criteria2 = "#rubricMainTable > tbody > tr:nth-child(2) > th > span>textarea";

	// Textboxes-Question,Rubric,sample Answer
	public String textbx_question = "//body[@data-id='question']";
	public String textboxrubric = "//body[@data-id='rubric']";
	public String textbxsampleanswer = "//body[@data-id='sampleAnswer']";
	// Title-Login
	public String PageTitle = "div.login-right > h1";
	// Rewar score
	public String RewardScore = "#rewardScore";

	// Peer Review window

	// Buttons

	// Wizard section buttons
	public String btnbeginReview = "div:nth-child(4) > div > div.d-flex.align-items-center > button";
	public String Reviewwizard = "//p-paginator[@id='pages']";
	public String reviewbtnsave = "//button[@id='tstBtnAnswerSave']";
	public String reviewbtnsaveandexit = "//p-button[@id='saveExitBtn']";
	public String reviewbtnsaveandnext = "//p-button[@id='saveNextBtn']";
	public String reviewbtnsubmit = "//p-button[@id='submitBtn']";
	public String wizardans1 = "//*[@id='pages']/div/span/button[1]";
	public String wizardans2 = "//*[@id='pages']/div/span/button[2]";
	public String wizardans3 = "//*[@id='pages']/div/span/button[3]";
	public String wizardans4 = "//*[@id='pages']/div/span/button[4]";
	// Button Back to Assessment
	public String backtoassess_btn = "//*[@id='backToMenu']/button";
	// Sample Answer Accordian
	public String Questionsampleansaccordian = "#tstSampleAnswerAccordian > div > p-accordiontab > div > div.p-accordion-header";

	// Score boxes
	public String scorestud1 = "//input[@id='peerMaxScore_0']";
	public String scorestud_1 = "//input[@id='peerMaxScore_0']";
	public String scorestud2 = "//input[@id='peerMaxScore_1']";

	// comment boxes
	public String stud1comment = "//input[@id='enterCommentArea_0']";
	public String stud1_comment = "//span[@id='leftIconTab']/input";
	public String stud2comment = "//input[@id='enterCommentArea_1']";

	// Answer Accordians
	public String stud1accordian="//p-accordiontab[@id='tstQuestionAccordianTab_0']//div/div/a";
	public String stud1accordian_1 = "//*[@id='tstQuestionAccordian_0']/div/span";
	public String stud2accordian = "//*[@id='tstQuestionAccordian_1']/div/span";
	public String stud2accordian_2="//p-accordiontab[@id='tstQuestionAccordianTab_1']";
	public String student2expandedaccordian="//*[@id='tstQuestionAccordianTab_1']/div";
	public String stud2accordian_1 = "//p-accordiontab[@id='tstQuestionAccordianTab_1']/div/div[1]";
	public String expandedstud1accordian = "#tstQuestionAccordianTab_0>div>div>a";
	public String expandedstud2accordian = "#tstQuestionAccordianTab_1>div>div>a";
	
	//Accordians
	public String stud1_accordian = "//p-accordiontab[@id='tstQuestionAccordianTab_0']//div/div/a";
	public String stud2_accordian = "//p-accordiontab[@id='tstQuestionAccordianTab_1']//div/div/a";
	public String stud3_accordian = "//p-accordiontab[@id='tstQuestionAccordianTab_2']//div/div/a";

	// Rubric Accordian
	public String RubricAccordian = "#peerStandardAccordionTab>div>div>a";
	public String Rubric_view = "//body[@data-id='standardRubricViewEditor']";
	public String Rubricboximage = "//body[@data-id='standardRubricViewEditor']/p[1]/img";
	public String RRubricbxvideo = "//body[@data-id='standardRubricViewEditor']/p[2]/video/source";
	public String Rubricboxlink = "//body[@data-id='standardRubricViewEditor']/p[3]/a";
	public String Rubricboxequation = "//body[@data-id='standardRubricViewEditor']/p[3]/img";

	// Sample Answer Accordian
	public String SampleAnsAccordian = "#peerSampleAccordionTab";
	public String SampleAns_view = "//body[@data-id='sampleAnswerViewEditor']";
	public String SampleAnsboximage = "//body[@data-id='sampleAnswerViewEditor']/p[1]/img";
	public String SampleAnsbxvideo = "//body[@data-id='sampleAnswerViewEditor']/p[2]/video/source";
	public String SampleAnsboxlink = "//body[@data-id='sampleAnswerViewEditor']/p[3]/a";
	public String SampleAnsboxequation = "//body[@data-id='sampleAnswerViewEditor']/p[3]/img";

	// Question Accordian
	public String Questionview = "//body[@data-id='questionViewEditor']";
	public String QuestioAns = "//body[@data-id='questionViewEditor']/p[1]";
	public String Questioboximage = "//body[@data-id='questionViewEditor']/p[2]";
	public String Questiobxvideo = "//body[@data-id='questionViewEditor']/p[3]/video/source";
	public String Questioboxlink = "//body[@data-id='questionViewEditor']/p[4]/a";
	public String Questioboxequation = "//body[@data-id='questionViewEditor']/p[2]/img";

	// Review Answer Accordians
	public String ReviewAns = "//body[@data-id='answerViewEditor_0']/p[1]";
	public String Reviewboximage = "//body[@data-id='answerViewEditor_0']/p[2]";
	public String Reviewbxvideo = "//body[@data-id='answerViewEditor_0']/p[3]/video/source";
	public String Reviewboxlink = "//body[@data-id='answerViewEditor_0']/p[4]/a";
	public String Reviewboxequation = "//body[@data-id='answerViewEditor_0']/p[2]/img";

	// Answer accordian labels
	public String lblstud1 = "//p-accordiontab[@id='tstQuestionAccordianTab_0']//a/span[2]";
	public String lblstud2 = "//p-accordiontab[@id='tstQuestionAccordianTab_1']//a/span[2]";
	// Answer Accordians
	public String stud1Answerbox = "//body[@data-id='answerViewEditor_0']/p";
	public String stud2Answerbox = "//body[@data-id='answerViewEditor_1']/p";
	public String stud3Answerbox = "//body[@data-id='answerViewEditor_2']/p";

	// Max score
	public String maxscore = "//div[@id='answerPeerStudentsSection']/div[1]/div/p-badge/span";
	// Answers from Peer Students:
	public String lbl_1 = "//form[@id='peerStudentsForm']/div/div[1]/label/strong";

	public String Answereqation = "//textarea[@id='answer']//following::button[contains(@title,'MathType')][1]";

	// Wizard Arrow buttons(Next and Previous)
	public String nextarrowbtn = "#pages > div > button.p-paginator-next";
	public String previousarrowbtn = "#pages > div > button.p-paginator-prev";

	// Labels
	public String enrolledcourse_lbl = "//div[@id='enrolledCoursesTxt']";
	// Assessment card
	public String cardlblsubmited = " div:nth-child(4) > div > div.d-flex.align-items-center > div > p-badge > span";
	public String progressbarcard = "div:nth-child(4) > div > div.d-flex > div.ml-auto > div > p-progressbar > div";

	// Question details-Peer review Window
	public String lblQuestionno = "#questionDetails > div.question-details-head > p-badge:nth-child(1) > span";
	public String lbl_maxscore = "//div[@id='questionDetails']//following::p-badge[contains(@class,'p-badge')]";
	public String lbl_totalquestions = "#questionDetails > div.flex-wrap.question-details-head > div > label:nth-child(1)";
	public String lbltotalquescount = "#questionDetails > div.flex-wrap.question-details-head > div > label:nth-child(1)>span";
	public String lbl_totalscore = "#questionDetails > div.flex-wrap.question-details-head > div > label:nth-child(2)";
	public String lbltotalscorevalue = "#questionDetails > div.flex-wrap.question-details-head > div > label:nth-child(2)>span";

	// Comment box
	public String popupcomment = "p-overlaypanel > div > div > textarea";
	public String txtbx_comment = "p-overlaypanel > div > div > textarea";
	public String commentlbl_1 = "p-overlaypanel > div > div > small";
	public String commentclose_btn = " p-overlaypanel > div > div > span > p-button:nth-child(1) > button";
	public String commentsave_btn = "p-overlaypanel > div > div > span > p-button:nth-child(2) > button";

	//Review backto assessment button
	public String reviewbactoassessmentbtn="//p-button[@id='successPopupBackToMenu']/button";
	// clickable rubric

	public String rubriccardsection = "#rubricSectionCard";
	public String cardrubriclbl = "//div[@id='rubricSectionCard']//strong";
	// criteria's
	public String criteria_1 = "//tbody[@class='p-datatable-tbody']/tr[1]/td[1]/div";
	public String criteria_2 = "//tbody[@class='p-datatable-tbody']/tr[2]/td[1]/div";
	public String c1row1 = "//tbody[@class='p-datatable-tbody']/tr[1]/td[2]/div";
	public String c1row2 = "//tbody[@class='p-datatable-tbody']/tr[1]/td[3]/div";
	public String c2row1 = "//tbody[@class='p-datatable-tbody']/tr[2]/td[2]/div";
	public String c2row2 = "//tbody[@class='p-datatable-tbody']/tr[2]/td[3]/div";

	// Conditions
	public String c1row1condition = "//body[@data-id='answerView_000']";
	public String c1row2condition = "//body[@data-id='answerView_001']";
	public String c2row1condition = "//body[@data-id='answerView_010']";
	public String c2row2condition = "//body[@data-id='answerView_011']";
	// score
	public String c1row1score = "//tbody[@class='p-datatable-tbody']/tr[1]/td[2]/div/p/span";
	public String c1row2score = "//tbody[@class='p-datatable-tbody']/tr[1]/td[3]/div/p/span";
	public String c2row1score = "//tbody[@class='p-datatable-tbody']/tr[2]/td[2]/div/p/span";
	public String c2row2score = "//tbody[@class='p-datatable-tbody']/tr[2]/td[3]/div/p/span";

	// Test Unattended popup
	public String tstUnattendedPopup = "#tstUnattendedPopup > div > div";
	public String testunattendedlbl_1 = "div.p-dialog-content > div > div > div > p:nth-child(2)";
	public String testunattendedlbl_2 = "div.p-dialog-content > div > div > div > p:nth-child(3)";
	public String unattendedpopup_submitbtn = "//p-button[@id='tstUnattendedSubmit']";
	
	// popup
	public String conf_lbl = "#tstPeerReviewSubmitConfirmation > div > div > div.p-dialog-header";
	public String confir_popup = "#tstPeerReviewSubmitConfirmation > div > div";
	public String confirmation_txt = "span.p-confirm-dialog-message";
	public String cancel_confi = "button.p-confirm-dialog-reject";
	public String submit_confi = "button.p-confirm-dialog-accept";

	public void Logout() {

		waitThread(1000);
		driver.findElement(By.xpath("//div[@class='username']")).click();
		waitThread(1000);
		driver.findElement(By.xpath("//i[@class='pi pi-sign-out']")).click();
		// Heading Title-Login
		Assert.assertEquals(getText(PageTitle), "Login");
	}

}
