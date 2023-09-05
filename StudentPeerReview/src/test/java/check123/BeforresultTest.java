package check123;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;

import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.ScheduleConfigureDefaultPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CreateNewAssessment.Pages.SummaryQuestionsPage;
import CurrentAssessmentsforStudents.Pages.StudentPeerReviewPage;
import CurrentAssessmentsforStudents.Pages.StudentResultSectionPage;
import CurrentAssessmentsforStudents.Pages.StudentTestSectionPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherResultSectionPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowWizardPage;
import ResultWindowforIndividualStudent.Page.StudentAnswerSheetBasicsPage;
import ResultWindowforIndividualStudent.Page.StudentResultWindowBasicsPage;
import ResultWindowofIndividualTeacherPage.TeacherAutomaticResultPeerreviewIncompletePage;
import ResultWindowofIndividualTeacherPage.TeacherAutomaticResultreviewcompletePage;
import ResultWindowofIndividualTeacherPage.TeacherManualResultPeerreviewcompletePage;
import ResultWindowofIndividualTeacherPage.TeacherReconsiderationWindowPage;
import SPRautomation.StudentPeerReview.basePage;
import TestWindowOfIndividualStudent.AssessmentSubmitAndStatusPopUpPage;
import TestWindowOfIndividualStudent.ModifyWizardSectionPage;
import TestWindowOfIndividualStudent.TestWindowWizardPage;

public class BeforresultTest  extends basePage{
	TeacherReconsiderationWindowPage trwp = new TeacherReconsiderationWindowPage();

	LoginPage lg = new LoginPage();
	CommonMethods cm = new CommonMethods();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	PeerReviewWindowWizardPage prw = new PeerReviewWindowWizardPage();
	SchedulePageBasicsPage sb1 = new SchedulePageBasicsPage();
	SummaryBasicsPage sb = new SummaryBasicsPage();
	SummaryQuestionsPage sq = new SummaryQuestionsPage();
	TeacherTestSectionPage tts = new TeacherTestSectionPage();
	StudentTestSectionPage st1 = new StudentTestSectionPage();
	ModifyWizardSectionPage ms = new ModifyWizardSectionPage();
	TeacherResultSectionPage tr = new TeacherResultSectionPage();
	AssessmentSubmitAndStatusPopUpPage asp = new AssessmentSubmitAndStatusPopUpPage();
	TestWindowWizardPage tsw = new TestWindowWizardPage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	PeerReviewWindowPage prp = new PeerReviewWindowPage();
	StudentPeerReviewPage sp1 = new StudentPeerReviewPage();
	StudentResultSectionPage srs = new StudentResultSectionPage();
	StudentResultWindowBasicsPage rwbt = new StudentResultWindowBasicsPage();
	TeacherAutomaticResultreviewcompletePage arv = new TeacherAutomaticResultreviewcompletePage();
	TeacherAutomaticResultPeerreviewIncompletePage ari = new TeacherAutomaticResultPeerreviewIncompletePage();
	StudentAnswerSheetBasicsPage sasb = new StudentAnswerSheetBasicsPage();
	ScheduleConfigureDefaultPage sd = new ScheduleConfigureDefaultPage();
	TeacherManualResultPeerreviewcompletePage mrp = new TeacherManualResultPeerreviewcompletePage();

	public String AssessmentName;
	public String Question1 = "Question1";
	public String Question2 = "Question2";
	public String Question3 = "Question3";
	public String Rubric1 = "Rubric1";
	public String Rubric2 = "Rubric2";
	public String Rubric3 = "Rubric3";
	public String Maxscore1 = "10";
	public String Maxscore2 = "20";
	public String Maxscore3 = "30";

	public String Student1name = "Ashley Albert";
	public String Student2name = "Ben Alex";
	public String Student3name = "Clara Albert";
	public String stud1ans1 = "Answer 1";

	/*
	 * To load the Student Peer Review Landing Page
	 */
	@Test(priority = 1)
	public void TCSPR1500701() {

		// Assert the heading label "Welcome to Student Peer Review"
		Assert.assertEquals(getText(lg.wel_label), "Welcome to Student Peer Review");

		click(lg.LoginBtn_1);

		cm.login(cm.emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}
	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */

	public String CourseID = cm.CourseID3;
	public String CourseName = cm.CourseName3;

	@Test(priority = 2)
	public void TCSPR1500702() {
		SoftAssert softAssert1 = new SoftAssert();

		// Click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(7000);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		// Click on create new assessment
		waitThread(2000);
		click(ba.btn_createnewassessment);

		// Click on Select course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename3);

		// Assert the course name visible on the dropdown
		softAssert1.assertEquals(getText(ba.ddcoursename3), CourseName.trim(),
				"course name not visible on the dropdown");

		// Click on course
		click(ba.ddcoursename3);

		// Type Assessment name
		click(QP.Assess_name);
		AssessmentName = "SPR0067_Assessment" + generateRandomNumber().trim();
		type(QP.Assess_name, AssessmentName);

		// Click on save &next button
		waitThread(2000);
		click(QP.Savenext);
		waitThread(2000);

		// Assert the question wizard is selected
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");
		softAssert1.assertAll();

	}

	/*
	 * To fill details for Question 1
	 */
	@Test(priority = 3)
	public void TCSPR1500703() {
		// Type Question 1
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		type(QP.Quest_box, Question1);
		driver.switchTo().defaultContent();

		// Type data in Standard Rubric box
		driver.switchTo().frame("rubric_ifr");
		type(QP.std_rub_bx, Rubric1);
		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, Maxscore1);

		MouseHover(QP.save);

		waitThread(2000);
		// Click on +button
		click(rd.add_quest_btn);
		waitFor(QP.toaster);

		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);
	}

	/*
	 * To fill details for Question 2
	 */
	@Test(priority = 4)
	public void TCSPR1500704() {
		// Type Question 2
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		type(QP.Quest_box, Question2);
		driver.switchTo().defaultContent();

		// Type data in Standard Rubric box
		driver.switchTo().frame("rubric_ifr");
		type(QP.std_rub_bx, "R2");
		driver.switchTo().defaultContent();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, Maxscore2);

		MouseHover(QP.save);

		waitThread(1000);
		// Click on +button
		click(rd.add_quest_btn);
		waitFor(QP.toaster);

		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully");
		click(QP.toasterclosebtn);

	}

	/*
	 * To fill details for Question 3
	 */
	@Test(priority = 5)
	public void TCSPR1500705() {

		waitThread(2000);
		// Type Question 3
		driver.switchTo().frame("question_ifr");
		Doubleclick(QP.Quest_box);
		type(QP.Quest_box, Question3);
		driver.switchTo().defaultContent();


		// Type data in Standard Rubric box
		driver.switchTo().frame("rubric_ifr");
		type(QP.std_rub_bx, Rubric3);
		driver.switchTo().defaultContent();

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0, -250);");

		waitThread(1000);
		// Enter Max score
		type(QP.max_scorbx, Maxscore3);

		MouseHover(QP.save);

		waitThread(1000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 3 Saved successfully");
		click(QP.toasterclosebtn);

		waitThread(1000);
		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}
	/*
	 * To verify the details on the peer review page
	 */

	public String RewardPercent = "50";
	public String studcount = "3";

	@Test(priority = 6)
	public void TCSPR1500706() {

		waitThread(1000);
		// Enter peer review Reward score
		type(prw.peer_reward_scorebx, RewardPercent);

		waitThread(4000);
		// Assert the text::Total Students : Assert the total student count is 3
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : " + studcount);

		// Assert the 3 student names
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Student1name.trim());
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Student2name.trim());
		Assert.assertEquals(getText(ps.studantname3_gridval).trim(), Student3name.trim());

	}

	public String reconisderdays;
	public String reconsidertime;

	/*
	 * To perform the save and next functionality from peer review page and verify
	 * the schedule page details
	 * 
	 */
	@Test(priority = 7)
	public void TCSPR1500707() {

		// Click Save&Next button
		click(pr.savennext_button);
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);

		// Assert schedule wizard is selected
		waitThread(2000);
		Assert.assertEquals(getAttribute(sb1.schedule_wizard, "aria-expanded"), "true");

		// Assert the text "Select schedules for "
		Assert.assertEquals(getText(sb1.selectstu_lbl), "Select Schedules for");

		ScrollTo_xy_position(0, 250);
		// Click on Teacher will manually publish the result radio button
		click(sb1.teacherwill_radio);

		// Click Allow ResConsideration checkbox
		click(sb1.allowstu_checkbx2);

		waitThread(3000);
		// Assert the radio button is selected
		Assert.assertTrue(getAttribute(sb1.teachwill_radio_select, "class").contains("checked"));

		// Click on Days dropdown
		click(sb1.day_recons_dropdwn);

		// select 1 days
		//click(sb1.reconsiderationday);
		// Assert the date visible on the page
		Assert.assertEquals(getValue(sb1.day_drop_txtbx), "1");
		reconisderdays = getValue(sb1.day_drop_txtbx);
		reconsidertime = getValue(sb1.lasttime_txtbx);

		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(5000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");

	}

	/*
	 * To perform Assessment publish functionality and check the details on the
	 * publish popup
	 */
	public String TotalTestPoints;
	public String Totalpeerreviewpoint;
	public String quest_count;
	public String maxscoreposs1;
	public String rewarscoreQ1;
	public String rewarscoreQ2;
	public String rewarscoreQ3;
	public int TotalRewardScore;

	@Test(priority = 8)
	public void TCSPR1500708() {

		ScrollTo_xy_position(300, 0);
		quest_count = getText(sq.total_questcount);

		// Assert the Total Questions: 3
		Assert.assertEquals(getText(sb.valuetotalQuestion), quest_count);

		TotalTestPoints = getText(sq.total_testscore);

		// Assert the Total Test Points: 60
		Assert.assertEquals(getText(sb.lblTotaltestpoints), "Total Test Points: " + TotalTestPoints);

		Totalpeerreviewpoint = getText(sq.total_peereviewvalue);

		// To calculate Reward Score for Question 1
		rewarscoreQ1 = cm.getrewardscoreforquestion(Maxscore1, RewardPercent);

		// To calculate Reward Score for Question 2
		rewarscoreQ2 = cm.getrewardscoreforquestion(Maxscore2, RewardPercent);

		// To calculate Reward Score for Question 3
		rewarscoreQ3 = cm.getrewardscoreforquestion(Maxscore3, RewardPercent);

		// Calculating Total Peer Review points
		int TotalRewardScore = cm.StringtoInt(rewarscoreQ1) + cm.StringtoInt(rewarscoreQ2)
				+ cm.StringtoInt(rewarscoreQ3);
		Totalpeerreviewpoint = Integer.toString(TotalRewardScore);

		int maxscorepossible1 = TotalRewardScore + cm.StringtoInt(TotalTestPoints);
		maxscoreposs1 = String.valueOf(maxscorepossible1);

		// Assert the Total Peer Review Points: 30.0
		Assert.assertEquals(getText(sb.lblpeerreviewpoints),
				"Total Peer Review Points: " + Totalpeerreviewpoint);

		// Assert theMaximum Score Possible: 90.0
		Assert.assertEquals(getText(sb.lblmaxscore), "Maximum Score Possible: " + maxscoreposs1);

		// click on Release Button
		click(sb.btnrelease);

		// Assert button Back to Menu
		Assert.assertTrue(isElementPresent(tts.back_to_menubutton), "Back to menu button not present");
	}
	/*
	 * To check the back to menu button functionality and check the created
	 * assessment visible on the Current tab
	 * 
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 9)
	public void TCSPR1500709() {

		waitThread(2000);
		// Click Back to Menu
		click(tts.back_to_menubutton);

		waitThread(6000);
		click(st1.assess_searchbx);

		// search the assessment
		type(st1.assess_searchbx, AssessmentName);

		// Assert the newly published card visible on the current assessment page
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");

		// Assert the Result section label:You need to manually publish the result
		Assert.assertEquals(getText(rd.manualpublishcard_txt), "You need to manually publish the result");

		// Assert the View result button is Disabled
		Assert.assertEquals(getAttribute(tr.evaluateans_btn, "disabled"), "true");

		// Perform logout functionality from Teacher profile
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform Login functionality of student1 profile and check the Assessment
	 * card To begin the test & check the labels of test window
	 */
	@Test(priority = 10)
	public void TCSPR1500710() throws InterruptedException {

		// Login to Student1
		lg.login("student1@gmail.com", cm.Password);

		waitThread(6000);
		// Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		// wait for 1 min
		//TimeUnit.MINUTES.sleep(1);
	//	TimeUnit.SECONDS.sleep(50);
		// Search Assessment name
		Doubleclick(st1.stud_searchbx);
		type(st1.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		waitThread(3000);
		// Click Begin Test
		click(st1.begintest_btn);

		waitThread(5000);
		// verify the assessment name
		Assert.assertEquals(getText(asp.testassessmentname), AssessmentName.trim());

	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 11)
	public void TCSPR1500711() {

		// Enter Answer1
		driver.switchTo().frame("answer_ifr");
		type(tsw.answer_bx, stud1ans1);
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Savebutton
		click(tsw.save_btn_test);

		// Click question2
		click(tsw.quest_2_wizard);

		// Second Question is selected
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("p-highlight"));

		// Type Answer2
		driver.switchTo().frame("answer_ifr");
		type(tsw.answer_bx, "Answer 2_" + generateRandomData());
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Savebutton
		click(tsw.save_btn_test);
		waitThread(2000);
		// Click question3
		click(tsw.quest_3_wizard);

		// Third Question is selected
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("p-highlight"));

		// Type Answer3
		driver.switchTo().frame("answer_ifr");
		type(tsw.answer_bx, "Answer 3_" + generateRandomData());
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Savebutton
		click(tsw.save_btn_test);

		waitFor(QP.toaster);
		// Assert Toaster Answer saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

	}

	/*
	 * To perform assessment submit functionality on the student profile To perform
	 * logout functionality on the Student 1 profile
	 */
	public String testcount;

	@Test(priority = 12)
	public void TCSPR1500712() {

		waitThread(2000);
		// Click Submit button
		click(tsw.submit_btn);

		waitThread(1000);
		// Assert confirmation popup
		Assert.assertTrue(isDisplayed(tsw.confir_popup), "popup not visible");

		// Click submit button on popup
		click(tsw.submit_confi);

		// Assert toaster "Assessment Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		// click back to Assessments
		click(tsw.backtoassess_btn);

		waitThread(5000);
		// Assert the current Assessments
		Assert.assertEquals(getText(prw.current_assess_label), "Current Assessments");

		waitThread(3000);
		// Search Assessment
		Doubleclick(st1.stud_searchbx);
		waitThread(2000);

		// Read the Test attended count
		testcount = getText(st1.quest_count);

		// To perform logout functionality on the Student 1 profile
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform Login functionality of student 2 profile and check the Assessment
	 * card
	 */
	@Test(priority = 13)
	public void TCSPR1500313() {

		waitThread(2000);
		// login as Student2
		lg.login("student2@gmail.com", cm.Password);

		waitThread(6000);

		// verify heading label current Assessments
		Assert.assertEquals(getText(QP.current_assesslabel), "Current Assessments");

		waitThread(5000);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		click(st1.stud_searchbx);
		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");
		waitThread(3000);

		// Click Begin Test
		click(st1.begintest_btn);

		waitThread(3000);
		// Assert the first question is highlighted on Wizard
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));

	}
	/*
	 * To attend test and fill answer functionality
	 */

	@Test(priority = 14)
	public void TCSPR1500714() {

		// Enter Answer1
		driver.switchTo().frame("answer_ifr");
		type(tsw.answer_bx, stud1ans1);
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Savebutton
		click(tsw.save_btn_test);

		// Click question2
		click(tsw.quest_2_wizard);

		// Second Question is selected
		Assert.assertTrue(getAttribute(tsw.quest_2_wizard, "class").contains("p-highlight"));

		// Type Answer2
		driver.switchTo().frame("answer_ifr");
		type(tsw.answer_bx, "Answer 2_" + generateRandomData());
		driver.switchTo().defaultContent();

	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 15)
	public void TCSPR1500715() {

		waitThread(2000);
		// Click Savebutton
		click(tsw.save_btn_test);

		waitFor(QP.toaster);
		// Assert Toaster Answer saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);
		waitThread(2000);
		// Click question3
		click(tsw.quest_3_wizard);

		// Third Question is selected
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("p-highlight"));

		// Type Answer3
		driver.switchTo().frame("answer_ifr");
		type(tsw.answer_bx, "Answer 3_" + generateRandomData());
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click Savebutton
		click(tsw.save_btn_test);

		waitFor(QP.toaster);
		// Assert Toaster Answer saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

	}

	/*
	 * To perform assessment submit functionality on the student profile To perform
	 * logout functionality on the Student 2 profile
	 */
	@Test(priority = 16)
	public void TCSPR1500716() throws InterruptedException {
		waitThread(2000);
		// Click Submit button
		click(tsw.submit_btn);

		waitThread(1000);
		// Assert confirmation popup
		Assert.assertTrue(isDisplayed(tsw.confir_popup), "popup not visible");

		// Click submit button on popup
		click(tsw.submit_confi);

		// Assert toaster "Assessment Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		// click back to Assessments
		click(tsw.backtoassess_btn);

		waitThread(4000);
		// Assert the current Assessments
		Assert.assertEquals(getText(prw.current_assess_label), "Current Assessments");

		TimeUnit.SECONDS.sleep(10);
		// To perform logout functionality on the Student 2 profile
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * To perform Login functionality of student 3 profile and check the Assessment
	 * card
	 */
	@Test(priority = 17)
	public void TCSPR1500717() {
		// Perform login by Student3
		lg.login("student3@gmail.com", cm.Password);

		waitThread(4000);

		// verify heading label current Assessments
		Assert.assertEquals(getText(QP.current_assesslabel), "Current Assessments");

		waitThread(3000);

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);

		// search newly created assessment
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 18)
	public void TCSPR1500718() {

		waitThread(2000);
		// Click Begin Test
		click(st1.begintest_btn);

		waitThread(3000);

		// Enter ANswer1
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);
		type(asp.Answertextbx, "Answer 1_" + generateRandomData());
		waitThread(1000);
		driver.switchTo().defaultContent();

		// Click on save Button
		click(asp.testbtnsave);
		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");
		click(QP.toasterclosebtn);
		waitThread(3000);

		ScrollTo_xy_position(0, 150);
		// click on Answer 2 wizard
		click(asp.wizardans2);
		waitThread(3000);

		// To fill the Answer 2
		waitThread(1000);
		// To enter the data on Question box
		driver.switchTo().frame("answer_ifr");
		waitThread(1000);
		type(asp.Answertextbx, "Answer 2_" + generateRandomData());
		waitThread(1000);
		driver.switchTo().defaultContent();

	}

	/*
	 * To attend test and fill answer functionality
	 */
	@Test(priority = 19)
	public void TCSPR1500719() {

		waitThread(2000);
		// Click on save Button
		click(asp.testbtnsave);
		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");
		click(QP.toasterclosebtn);
		waitThread(3000);

		// Click question3
		click(tsw.quest_3_wizard);
		MouseHover(tsw.save_btn_test);

		waitThread(2000);
		click(tsw.quest_3_wizard);
		// Third Question is selected
		Assert.assertTrue(getAttribute(tsw.quest_3_wizard, "class").contains("p-highlight"));

		ScrollTo_xy_position(0, 300);
		// Type Answer3
		driver.switchTo().frame("answer_ifr");
		type(tsw.answer_bx, "Answer 3_" + generateRandomData());
		driver.switchTo().defaultContent();

	}

	/*
	 * To perform assessment submit functionality on the student profile To perform
	 * logout functionality on the Student 3 profile
	 * 
	 */
	@Test(priority = 20)
	public void TCSPR1500720() {

		waitThread(2000);
		// Click Savebutton
		click(tsw.save_btn_test);

		waitFor(QP.toaster);
		// Assert Toaster Answer saved
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);
		waitThread(2000);
		// Click Submit button
		click(tsw.submit_btn);

		waitThread(1000);
		// Assert confirmation popup
		Assert.assertTrue(isDisplayed(tsw.confir_popup), "popup not visible");

		// Click submit button on popup
		click(tsw.submit_confi);

		// Assert toaster "Assessment Submitted"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		// click back to Assessments
		click(tsw.backtoassess_btn);

		waitThread(4000);
		// Assert the current Assessments
		Assert.assertEquals(getText(prw.current_assess_label), "Current Assessments");

		waitThread(6000);

		// To perform logout functionality on the Student 3 profile
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * Login as Teacher and Reschedule the Test due and peer review start date To
	 * perform Login functionality of student 1 profile and check the Assessment
	 * card
	 */
	@Test(priority = 21)
	public void TCSPR1500721() throws InterruptedException {

		// Login to Teacher profile
		cm.login(cm.emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		// Click Assessment tab
		click(QP.teach_assesstab);

		waitThread(5000);

		click(st1.assess_searchbx);
		// search newly created assessment
		type(st1.assess_searchbx, AssessmentName);

		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");

		waitThread(3000);
		// click menu button
		click(rd.threedot_btn);

		waitThread(1000);
		// click reschedule dates
		click(rd.reschedulemenu);
		waitThread(1000);

		// Set the test due day to current day
		waitThread(2000);
		Doubleclick(rd.assessmentduedate_txtbx);

		waitThread(2000);
		cm.ClickTodaysDate();

		// Set Peer review open date to Current day
		waitThread(2000);
		Doubleclick(rd.peerreviewopendate_txtbx);

		waitThread(2000);
		cm.ClickTodaysDate();

		waitThread(2000);
		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitThread(6000);

		// logout functionality
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);
		// Login to Student1
		lg.login("student1@gmail.com", cm.Password);

		waitThread(5000);
		// Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		type(st1.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Wait till peer review active
	//	TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(10);

		waitThread(2000);

		// Click Begin Review
		click(st1.begintest_btn);

		waitThread(5000);

		// Assert the first Question is selected
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));

	}

	/*
	 * To perform review for Question 1 and Question 2
	 */
	public String stud1scores1q1 = "5";
	public String stud1scores1q2 = "10";

	@Test(priority = 22)
	public void TCSPR1500722() {

		ScrollTo_xy_position(0, 300);
		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, stud1scores1q1);

		// click on save and next button
		click(prp.reviewbtnsaveandnext);
		waitFor(QP.toaster);

		// verify the toaster "Score Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);

		// verify the Question 2 is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));

		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, stud1scores1q2);

		waitThread(2000);
		// click on save and next button
		click(prp.reviewbtnsaveandnext);

		waitFor(QP.toaster);
		// verify the toaster "Score Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);

	}

	/*
	 * To perfrom review for Question 3 and submit the Review To perform logout
	 * functionality on the Student 1 profile
	 */
	public String stud1scores1q3 = "10";

	@Test(priority = 23)
	public void TCSPR1500723() {

		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, stud1scores1q3);

		// click submit button
		click(ms.submit_btn);
		waitThread(1000);
		Assert.assertTrue(isDisplayed(prp.confir_popup), "popup not visible");
		waitThread(2000);
		click(prp.submit_confi);
		waitThread(2000);
		// Click on Back to Assessment
		click(prp.reviewbactoassessmentbtn);
		waitThread(2000);

		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		waitThread(6000);

		// logout functionality
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform Login functionality of student 2 profile and check the Assessment
	 * card
	 */
	@Test(priority = 24)
	public void TCSPR1500724() {
		// Login to Student2
		lg.login("student2@gmail.com", cm.Password);

		waitThread(6000);
		// Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		Doubleclick(st1.stud_searchbx);
		waitThread(2000);
		type(st1.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Click Begin Review
		click(st1.begintest_btn);

		waitThread(5000);

		// Assert the first Question is selected
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));

	}

	/*
	 * To perform review for Question 1& Question2
	 */

	@Test(priority = 25)
	public void TCSPR1500725() {
		Scroll_DowntoEnd();
		waitThread(2000);

		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "5");

		// click on save and next button
		click(prp.reviewbtnsaveandnext);
		waitFor(QP.toaster);

		// verify the toaster "Score Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);

		// verify the Question 2 is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));

		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "10");

		waitThread(2000);
		// click on save and next button
		click(prp.reviewbtnsaveandnext);

		waitFor(QP.toaster);
		// verify the toaster "Score Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);

	}

	/*
	 * To perform review for Question 3 and submit the Review To perform logout
	 * functionality on the Student 3 profile
	 */
	@Test(priority = 26)
	public void TCSPR1500726() throws InterruptedException {

		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "10");

		// click submit button
		click(ms.submit_btn);
		waitThread(1000);
		Assert.assertTrue(isDisplayed(prp.confir_popup), "popup not visible");
		waitThread(2000);
		click(prp.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Peer Review Submitted"
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);
		// Click on Back to Assessment
		click(prp.reviewbactoassessmentbtn);
		waitThread(2000);

		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		waitThread(4000);

		TimeUnit.SECONDS.sleep(6);

		// logout functionality
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To perform Login functionality of student 3 profile and check the Assessment
	 * card
	 */
	@Test(priority = 27)
	public void TCSPR1500727() {

		// Login to Student3
		lg.login("student3@gmail.com", cm.Password);

		waitThread(5000);
		// Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));

		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		type(st1.stud_searchbx, AssessmentName);
		waitThread(2000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.published_card), "Published Assessment card not visible");

		// Click Begin Review
		click(st1.begintest_btn);

		waitThread(5000);

		// Assert the first Question is selected
		Assert.assertTrue(getAttribute(tsw.quest_1_wizard, "class").contains("p-highlight"));

	}

	/*
	 * To perfrom review for Question 1 and Question 2
	 */
	@Test(priority = 28)
	public void TCSPR1500728() {

		Scroll_DowntoEnd();
		waitThread(2000);
		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "5");

		// click on save and next button
		click(prp.reviewbtnsaveandnext);
		waitFor(QP.toaster);

		// verify the toaster "Score Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);

		// verify the Question 2 is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));

		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "10");

		// click on save and next button
		click(prp.reviewbtnsaveandnext);
		waitFor(QP.toaster);

		// verify the toaster "Score Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);

		// verify the Question 3 is selected
		Assert.assertTrue(getAttribute(asp.wizardans3, "class").contains("p-highlight"));

	}

	/*
	 * To perform review for Question 3 and submit the Review To perform logout
	 * functionality on the Student 3 profile
	 */
	@Test(priority = 29)
	public void TCSPR1500729() {

		// Enter Score for Student1
		click(prp.scorestud1);
		waitThread(1000);
		type(prp.scorestud1, "10");

		// click submit button
		click(ms.submit_btn);
		waitThread(1000);
		Assert.assertTrue(isDisplayed(prp.confir_popup), "popup not visible");
		waitThread(2000);
		click(prp.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Peer Review Submitted"
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);
		// Click on Back to Assessment
		click(prp.reviewbactoassessmentbtn);
		waitThread(2000);
		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		waitThread(6000);

		// logout functionality
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * Perform teacher login and reschedule the peer review and result date
	 */
	@Test(priority = 30)
	public void TCSPR1500730() throws InterruptedException {

		// Login to Teacher profile
		cm.login(cm.emailteacher, cm.Password);

		// Click Assessment tab
		click(QP.teach_assesstab);

		waitThread(7000);

		// search assessment
		type(st1.assess_searchbx, AssessmentName);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");
		waitThread(3000);

		// click menu button
		click(rd.threedot_btn);

		waitThread(1000);
		// click reschedule dates
		click(rd.reschedulemenu);
		waitThread(1000);

		// Set Peer review due date & Result date as Todays date
		Doubleclick(rd.peerreviewduedate_txtbx);
		cm.ClickTodaysDate();
		waitThread(2000);

		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitThread(5000);

		click(st1.assess_searchbx);
		// search assessment
		type(st1.assess_searchbx, AssessmentName);

		TimeUnit.MINUTES.sleep(2);

		waitThread(3000);
		// Assert label result upcoming
		Assert.assertEquals(getText(tts.time_status), "Result Upcoming");

	}

	/*
	 * To verify the result section Labels
	 */
	@Test(priority = 31)
	public void TCSPR1500731() {

		// Assert label result upcoming
		Assert.assertEquals(getText(tts.time_status), "Result Upcoming");

		// Assert the Result status is pending
		Assert.assertEquals(getText(tr.resultsts_lbl), "Pending");

		// Assert text "You need to manually publish the result"
		Assert.assertEquals(getText(rd.manualpublishcard_txt), "You need to manually publish the result");

		// Assert the label reconsider
		Assert.assertEquals(getText(rd.reconsiderlbl), "Last Date for Reconsideration Request: " + reconisderdays
				+ " days from Result Publish, " + cm.removeLeadingZeroes(reconsidertime));

		// Assert the Button and Button label Evaluate Answers
		Assert.assertTrue(isElementPresent(arv.viewresult_teachcard), "Evaluate Answers button not present");
		Assert.assertEquals(getText(arv.viewresult_teachcard), "Evaluate Answers");

	}
	/*
	 * To Perform the evaluate answer functionality from teacher login
	 */

	@Test(priority = 32)
	public void TCSPR1500732() {

		waitThread(3000);
		// Click on Evaluate Answer Button
		click(arv.viewresult_teachcard);
		waitThread(4000);
		// Assert the Heading Peer Review Results
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Peer Review Results");

		// *Assert the student 1 Status "Peer Review Completed"
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[9]/div/p"),
				"Peer Review Completed");
		// *Assert the student 2 Status "Peer Review Completed"
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[9]/div/p"),
				"Peer Review Completed");
		// *Assert the student 3 Status "Peer Review Completed"
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[9]/div/p"),
				"Peer Review Completed");
		// *Assert the new reconsideration time 1 days from Result publish, Time
		Assert.assertEquals(getText(trwp.reconisiderationtime),
				reconisderdays + " days from Result publish, " + cm.removeLeadingZeroes(reconsidertime));
	}

	public String Stud1Rewardscore;
	public String stud1scorefrompeers;
	public String stud1Totalscore;
	public String Stud2Rewardscore;
	public String stud2scorefrompeers;
	public String stud2Totalscore;
	public String Stud3Rewardscore;
	public String stud3scorefrompeers;
	public String stud3Totalscore;

	/*
	 * To perform publish the result functionality on the teacher login
	 */
	@Test(priority = 33)
	public void TCSPR1500733() throws ParseException {

		// Click on Publish button
		click(ari.publish_btn);
		waitThread(2000);
		// Assert the publish popup visible
		Assert.assertTrue(isElementPresent(ari.publish_popup), "popup not present");
		// Assert the Label "Result Published Successfully"
		Assert.assertEquals(getText(ari.pub_popup_txt), "Result Published Successfully");
		// Assert the reconsideration date and time
		Assert.assertEquals(getText(trwp.resultpopupreconsiderdate), "Last date for raising Reconsideration will be: "
				+ sd.getNextday__2() + " - " + sd.Nextdayname() + " at " + cm.removeLeadingZeroes(reconsidertime));
		// Assert the Back to results button
		Assert.assertTrue(isElementPresent(ari.publish_backtores_btn), "Back to results button not present");
		waitThread(1000);
		// Click on Back to Results Button
		click(ari.publish_backtores_btn);

		waitThread(3000);
		// Assert the Heading Final result
		Assert.assertEquals(getText(ari.evalu_answr_lbl), "Final Result");
		// Assert the reconsideration timer
		Assert.assertTrue(isElementPresent(trwp.reconsidertimer), "Reconisderation timer not visible");
		Assert.assertTrue(getText(trwp.reconsidertimer).contains("Reconsideration Request Active for "),
				"Timer text not visible");

		// Student 1 reward score
		Stud1Rewardscore = cm.getdatafromgrid(Student1name,
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[6]/div/span/a");
		// Student 2 reward score
		Stud2Rewardscore = cm.getdatafromgrid(Student2name,
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[6]/div/span/a");
		// Student 3 reward score
		Stud3Rewardscore = cm.getdatafromgrid(Student3name,
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[6]/div/span/a");

		// Student 1 Score Received from Peers
		Stud1Rewardscore = cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[7]/div/span");
		// Student 2 Score Received from Peers
		Stud2Rewardscore = cm.getdatafromgrid(Student2name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[7]/div/span");
		// Student 3 Score Received from Peers
		Stud3Rewardscore = cm.getdatafromgrid(Student3name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[7]/div/span");

		// Student 1 Total Score
		Stud1Rewardscore = cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[8]/div/span");
		// Student 2 Total Score
		Stud2Rewardscore = cm.getdatafromgrid(Student2name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[8]/div/span");
		// Student 3 Total Score
		Stud3Rewardscore = cm.getdatafromgrid(Student3name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[8]/div/span");

		// Click on Back button
		click(arv.back_btn);
		waitThread(7000);
		
		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(trwp.teachercurrenttab, "class").contains("p-highlight"));
		

	}

	/*
	 * To check the Result details on the Card and reschedule page
	 */
	@Test(priority = 34)
	public void TCSPR1500734() {

		waitThread(3000);
		// search assessment
		type(st1.assess_searchbx, AssessmentName);
		driver.findElement(By.id("searchAssessments")).sendKeys("  ");
		waitThread(3000);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");
		waitThread(3000);
		// Assert label result Available
		Assert.assertEquals(getText(tts.time_status), "Result Available");

		// Assert the Result status is pending
		Assert.assertEquals(getText(tr.resultsts_lbl), "Active");
	
		// Assert the label reconsider
		Assert.assertEquals(getText(rd.reconsiderlbl), "Last Date for raising Reconsideration Request:\n"
				+ trwp.getnextday_1() + ", " + cm.removeLeadingZeroes(reconsidertime));

		// Assert the Button and Button label View Result
		Assert.assertTrue(isElementPresent(arv.viewresult_teachcard), "View Result button not present");
		Assert.assertEquals(getText(arv.viewresult_teachcard), "View Result");
		Assert.assertTrue(getText(trwp.resultdatelbl).contains("Result Published Date: " + trwp.getDate_1() + ", "));

	}

	/*
	 * Login As student 1 and check the Details of Result window
	 */
	@Test(priority = 35)
	public void TCSPR1500735() {
		// perform teacher logout
		cm.Logout();
		
		// login as Student 1
		waitThread(2000);
		lg.login("student1@gmail.com", cm.Password);

		// Search the Assessment Name
		waitThread(7000);
		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		click(st1.stud_searchbx);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys("     ");
		waitThread(5000);

		// Assert Label "Result Available"
		Assert.assertEquals(getText(ari.stud_cardhead_lbl), "Result Available");

		// Assert the Result status is Active
		Assert.assertEquals(getText(tr.resultsts_lbl), "Active");

		// Assert text "You need to manually publish the result"
		Assert.assertTrue(getText(trwp.resultdatelbl).contains("Result Published Date: " + trwp.getDate_1() + ", "));

		// Assert the label reconsider
		Assert.assertEquals(getText(rd.reconsiderlbl), "Last date for reconsideration: "
				+ trwp.getnextday_1() + ", " + cm.removeLeadingZeroes(reconsidertime));

		// Assert the view result button visible
		Assert.assertTrue(isElementPresent(rwbt.viewresultbtn), "View result button not visible");
		Assert.assertEquals(getText(rwbt.viewresultlbl), "View Result");

	}

	public String Q1Scorefrompeers;
	public String Q1rewardscorestud;
	public String Q1Finalscore;
	public String Q2Scorefrompeers;
	public String Q2Finalscore;
	public String Q3Scorefrompeers;
	public String Q3Finalscore;
	public String Student1Totalscore;

	public String Student1comment="Student 1 reconsideration comment";

	/*
	 * To check the Details of Result window
	 */
	@Test(priority = 36)
	public void TCSPR1500736() {

		// click on view result button
		click(rwbt.viewresultbtn);
		waitThread(3000);

		// Assert Result pop up visible
		Assert.assertTrue(isElementPresent(rwbt.resultpopup), "Result Popup  not visible");

		// Assert the heading Result
		Assert.assertEquals(getText(rwbt.label_Result_1), "Result");

		// Reconsideration label
		Assert.assertTrue(
				getText(trwp.lbl_reconsideration).contains("Time left for raising Reconsideration Request : "),
				"Reconsideration label not visible");

		// Read the Scores Received from Peer Reviewers of each Question
		Q1Scorefrompeers = trwp.getdatafromgridstudent("1",
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[5]/div/span");
		System.out.println("Q1Scorefrompeers "+Q1Scorefrompeers);
		Q2Scorefrompeers = trwp.getdatafromgridstudent("2",
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[5]/div/span");
		System.out.println("Q2Scorefrompeers "+Q2Scorefrompeers);
		Q3Scorefrompeers = trwp.getdatafromgridstudent("3",
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[5]/div/span");
		System.out.println("Q3Scorefrompeers "+Q3Scorefrompeers);
		// Final Score of each Question
		Q1Finalscore = trwp.getdatafromgridstudent("1",
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[7]/div/span");
		System.out.println("Q1Finalscore "+Q1Finalscore);
		Q2Finalscore = trwp.getdatafromgridstudent("2",
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[7]/div/span");
		System.out.println("Q2Finalscore "+Q2Finalscore);
		Q3Finalscore = trwp.getdatafromgridstudent("3",
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[7]/div/span");
		System.out.println("Q3Finalscore "+Q3Finalscore);
		// Total Score
		Student1Totalscore = getText(trwp.Student1totalscore);
		System.out.println("Student1Totalscore "+Student1Totalscore);
		Q1rewardscorestud = trwp.getdatafromgridstudent("1",
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[6]/div/span");
		System.out.println("Q1rewardscorestud "+Q1rewardscorestud);
	}

	/*
	 * To submit the Reason For Reconsideration Request
	 */
	@Test(priority = 37)
	public void TCSPR1500737() {

		// click on reconsideration button
		click(trwp.btn_reconsiderationreqst);

		// Assert the pop up visible
		Assert.assertTrue(isElementPresent(trwp.commentpop), "Comment Popup  not visible");

		//Student1comment = "Student 1 reconsideration comment";
		// Type reconsideration comment
		type(trwp.commenttextbx, Student1comment);
		// To verify the submit button is enabled
		Assert.assertFalse(getAttribute(trwp.commentsubmitbtn_submit, "class").contains("raiseBtnDisabled"),
				"Publish button is disabled");
		// click on publish button
		click(trwp.commentsubmitbtn_submit);
		waitFor(QP.toaster);

		// Assert the toaster "Reconsideration Request Raised"
		Assert.assertEquals(getText(QP.toaster), "Reconsideration Request Raised");

		click(QP.toasterclosebtn);
		// Assert the View Teacher Response to Reconsideration Request button is
		// disabled
		Assert.assertTrue(getAttribute(trwp.viewteachercomment, "class").contains("disabled"),
				"Teacher Response to Reconsideration Request button is enabled");

	}

	/*
	 * To verify the student Card status after submit,the reconsideration request
	 */
	@Test(priority = 38)
	public void TCSPR1500738() {

		// click close button
		click(rwbt.resultpopupclosebtn);
		waitThread(5000);

		// Search the Assessment Name
		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		click(st1.stud_searchbx);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys("     ");
		waitThread(10000);

		// Assert the Result status is Reconsideration Requested
		Assert.assertEquals(getText(trwp.Cardlbl_reconsideration), "Reconsideration Requested");
		// Assert the Card status is Reconsideration Requested
		Assert.assertEquals(getText(trwp.cardheadinglbl), "Reconsideration Requested");
		
		// Assert the Result status is Active
		Assert.assertEquals(getText(tr.resultsts_lbl), "Active");



		// Perform Student 1 Logout
		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}
}
