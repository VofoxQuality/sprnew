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

public class NewScriptrunTest extends basePage{
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

	public String AssessmentName="SPR0067_Assessment6543160";
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


	}
	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */

	public String CourseID = cm.CourseID3;
	public String CourseName = cm.CourseName3;

	public String RewardPercent = "50";
	public String studcount = "3";
	public String reconisderdays="1";
	public String reconsidertime="";


	/*
	 * To perform Assessment publish functionality and check the details on the
	 * publish popup
	 */
	public String TotalTestPoints="60";
	public String Totalpeerreviewpoint="30";
	public String quest_count="3";
	public String maxscoreposs1="90";
	public String rewarscoreQ1;
	public String rewarscoreQ2;
	public String rewarscoreQ3;
	//public int TotalReardScore=5;


	/*
	 * To perform review for Question 1 and Question 2
	 */
	public String stud1scores1q1 = "5";
	public String stud1scores1q2 = "10";


	/*
	 * To perfrom review for Question 3 and submit the Review To perform logout
	 * functionality on the Student 1 profile
	 */
	public String stud1scores1q3 = "10";


	public String Stud1Rewardscore="30";
	public String stud1scorefrompeers="25";
	public String stud1Totalscore="55";
	public String Stud2Rewardscore="30";
	public String stud2scorefrompeers="25";
	public String stud2Totalscore="55";
	public String Stud3Rewardscore="30";
	public String stud3scorefrompeers="25";
	public String stud3Totalscore="55";



	public String Q1Scorefrompeers="5";
	public String Q1rewardscorestud="5";
	public String Q1Finalscore="10";
	public String Q2Scorefrompeers="10";
	public String Q2Finalscore="20";
	public String Q3Scorefrompeers="10";
	public String Q3Finalscore="25";
	public String Student1Totalscore="55/90";

	public String Student1comment="Student 1 reconsideration comment";
	//public String Student1comment="Student 1 reconsideration comment_QAP7A5pU6e21";

	/*
	 * Login as teacher and check that the student reconsideration details on the
	 * assessment card
	 */
	@Test(priority = 39)
	public void TCSPR1500739() {

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
		driver.findElement(By.id("searchAssessments")).sendKeys("    ");
		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");

		// Assert label result Available
		Assert.assertEquals(getText(tts.time_status), "Reconsideration Requested");

		// Assert the Result status is pending
		Assert.assertEquals(getText(tr.resultsts_lbl), "Active");

		// Assert text "You need to manually publish the result"
		Assert.assertTrue(getText(trwp.resultdatelbl).contains("Result Published Date: " + trwp.getDate_1() + ", "));

		// Assert the label reconsider
		Assert.assertEquals(getText(rd.reconsiderlbl), "Last Date for raising Reconsideration Request:\n"
				+ trwp.getnextday_1() + ", " + cm.removeLeadingZeroes(reconsidertime));

		// Assert the Reconsideration count
		Assert.assertEquals(getText(trwp.teachercard_reconsidercount),
				"Reconsideration requested: 1 Pending 0 Processed");

		// Assert the button label View
		Assert.assertEquals(getAttribute(trwp.btn_view, "label"), "View");

	}

	/*
	 * To check that the assessment listed on the Reconsideration Tab
	 */
	@Test(priority = 40)
	public void TCSPR1500740() {

		// Click on Reconsideration Requests Tab
		click(trwp.reconsidertab);
		Assert.assertEquals(getText(trwp.reconsidertab), "Reconsideration Requests");
		// Verify the tab is selected
		Assert.assertEquals(getAttribute(trwp.tab_reconsiderationrequest, "aria-selected"), "true");

		// Search the Assessment Name
		type(trwp.searchbox, AssessmentName);

		// Assert the Labels on the grid
		Assert.assertEquals(getText(trwp.reconsider_coursename), CourseName);
		Assert.assertEquals(getText(trwp.reconsider_ass_name), AssessmentName);
	//	Assert.assertEquals(getText(trwp.reconsider_maxscore), maxscoreposs1);
		Assert.assertEquals(getText(trwp.reconsider_pending), "1");
		Assert.assertEquals(getText(trwp.reconsider_reqst_proccess), "0");
		// Assert the view request button visible
		Assert.assertTrue(isElementPresent(trwp.view_request_btn), "View request button  not visible");
		Assert.assertEquals(getText(trwp.view_request_btn_lbl), "View Request");

	}

	/*
	 * To view the reconsideration request and check the Labels on the
	 * reconsideration window
	 */
	@Test(priority = 41)
	public void TCSPR1500741() {

		// Click on View Request button
		click(trwp.view_request_btn);
		waitThread(5000);
		// Heading Label
		Assert.assertEquals(getText(trwp.lbl_reconsider_heading), "Reconsideration Requests");

		// Assert the Labels
		// Course Name: Course name and course ID
		// Assessment Name: Assessment Name
		Assert.assertEquals(getText(trwp.courseBasicDetailsRecon),
				"Course Name: "+ CourseName +" ("+CourseID+")\n"
				+ "Assessment Name: "+AssessmentName);
		// Reconsideration pending count
		Assert.assertEquals(getText(trwp.reconsiderationPendingCount),
				"Reconsideration Request\n" + "Pending: 1\n" + "Processed: 0");
	}

	/*
	 * To check the Labels on the Reconsideration window
	 */
	@Test(priority = 42)
	public void TCSPR1500742() {

		// Assert the Label and Value-Total Peer Review Points
		Assert.assertEquals(getText(trwp.reconTotalPeerPoints), "Total Peer Review Points\n" + Totalpeerreviewpoint);
		// Assert the Label and Value-Total Test Points
		Assert.assertEquals(getText(trwp.reconTotalTestPoints), "Total Test Points\n" + TotalTestPoints);

		// Assert the Label and Value-Maximum Score Possible
		// (Total Test Points + Total Peer Review Points)
		Assert.assertEquals(getText(trwp.reconMaxScorePossible),
				"Maximum Score Possible\n(Total Test Points + Total Peer Review Points)\n" + maxscoreposs1);

	}

	/*
	 * To check the Labels on the Reconsideration window
	 */
	@Test(priority = 43)
	public void TCSPR1500743() {

		// Assert the Labels and radio buttons
		Assert.assertTrue(isElementPresent(trwp.radiobtn_reconsider),
				"Reconsideration Requests radio button not visible");
		Assert.assertTrue(isElementPresent(trwp.radiobtn_allresults),
				"Reconsideration Requests radio button not visible");
		Assert.assertEquals(getText(trwp.lbl_reconsiderrequest), "Reconsideration Requests");
		Assert.assertEquals(getText(trwp.lbl_Allresults), "All Results");
		// Assert the Reconsideration Requests radio button is selected
		Assert.assertTrue(getAttribute(trwp.radiobtn_reconsider, "Class").contains("checked"));
		// Assert the All results radio button is not selected
		Assert.assertFalse(getAttribute(trwp.radiobtn_allresults, "Class").contains("checked"));
		waitThread(3000);
		// Assert the color green for Completed
		Assert.assertTrue(getAttribute(trwp.completed_dot, "Class").contains("green-dot"));
		Assert.assertEquals(getText(trwp.completed_lbl), "Completed");
		// Assert the color orange for Incomplete
		Assert.assertTrue(getAttribute(trwp.incomplete_dot, "Class").contains("orange-dot"));
		Assert.assertEquals(getText(trwp.incomplete_lbl), "Incomplete");
	}

	/*
	 * To check the grid Labels on the reconsideration window
	 */
	@Test(priority = 44)
	public void TCSPR1500744() {

		// Assert the Following Grid Labels

		Assert.assertEquals(getText(trwp.lbl_sino), "Sl No");
		Assert.assertEquals(getText(trwp.lblStudentName_), "Student\n"	+ "Name");
		Assert.assertEquals(getText(trwp.lbl_Answersheetsreviewedby), "Answer Sheets\n"
				+ "Reviewed by");
		Assert.assertEquals(getText(trwp.lblraisedon), "Raised On");
		Assert.assertEquals(getText(trwp.lblstatus), "Status");
		Assert.assertEquals(getText(trwp.lbl_RewardPoint), "Reward\n"
				+ "Score");
		Assert.assertEquals(getText(trwp.lbl_ScorefromPeers_), "Score Received from\n" + "Peers");
		Assert.assertEquals(getText(trwp.lbl_TotalScore_), "Total Score");
		Assert.assertEquals(getText(trwp.lbl_AnswerSheet), "Answer\n" + "Sheet");

		// Assert the student Names
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[3]/div"), Student1name);
			// Reward score
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[7]/div/span"),
				Stud1Rewardscore);
		// Score received from peers
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[8]/div/span"),
				stud1scorefrompeers);
		// Total Score of student 1
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[10]/div/span"),
				stud1Totalscore);
		// Status
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[6]/div/span"),
				"Reconsideration Pending");

		// reviewer name
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[4]/div/div/p-badge/span"), Student2name);

	}

	/*
	 * To check the Labels and Details of the All results page
	 */
	@Test(priority = 45)
	public void TCSPR1500745() {

		// click All results button
		click(trwp.radiobtn_allresults);
		waitThread(2000);
		// Assert the All results radio button is selected
		Assert.assertTrue(getAttribute(trwp.radiobtn_allresults, "Class").contains("checked"));
		// Assert the heading
		Assert.assertEquals(getText(trwp.lbl_allresults), "All Results");

		// Assert the Labels
		// Course Name: Course name and course ID
		// Assessment Name: Assessment Name
		Assert.assertEquals(getText(trwp.courseBasicDetailsRecon),
				"Course Name: "+ CourseName +" ("+CourseID+")\n"
				+ "Assessment Name: "+AssessmentName);
		// Reconsideration pending count
		Assert.assertEquals(getText(trwp.reconsiderationPendingCount),
				"Reconsideration Request\n" + "Pending: 1\n" + "Processed: 0");

	}

	/*
	 * To check the Labels and Details of the All results page
	 */
	@Test(priority = 46)
	public void TCSPR1500746() {

		// Assert the Label and Value-Total Peer Review Points
		Assert.assertEquals(getText(trwp.reconTotalPeerPoints), "Total Peer Review Points\n" + Totalpeerreviewpoint);
		// Assert the Label and Value-Total Test Points
		Assert.assertEquals(getText(trwp.reconTotalTestPoints), "Total Test Points\n" + TotalTestPoints);

		// Assert the Label and Value-Maximum Score Possible
		// (Total Test Points + Total Peer Review Points)
		Assert.assertEquals(getText(trwp.reconMaxScorePossible),
				"Maximum Score Possible\n(Total Test Points + Total Peer Review Points)\n" + maxscoreposs1);

	}

	/*
	 * To check the Labels and Details of the All results page
	 */
	@Test(priority = 47)
	public void TCSPR1500747() {

		// Assert the Following Grid Labels

		Assert.assertEquals(getText(trwp.lbl_sinoAll_results), "Sl No");
		Assert.assertEquals(getText(trwp.lblStudentNameAll_results_), "Student Name");
		Assert.assertEquals(getText(trwp.lbl_QuestionsAnsweredAll_results), "Questions\n" + "Answered");
		Assert.assertEquals(getText(trwp.lblReviewedbyAll_results_), "Answer Sheets Reviewed by");
		Assert.assertEquals(getText(trwp.lbl_RewardPointAll_results), "Reward\n" + "Point");
		Assert.assertEquals(getText(trwp.lbl_ScorefromPeersAll_results_), "Score Received from\n" + "Peers");
	//	Assert.assertEquals(getText(trwp.lbl_ScorefromTeacher_Peers), "Score Received from\n" + "Teacher/Peers");
		Assert.assertEquals(getText(trwp.lbl_TotalScore_1_), "Total Score");
		Assert.assertEquals(getText(trwp.lbl_AnswerSheet_1), "Answer\n" + "Sheet");

		Stud1Rewardscore = cm.getdatafromgrid(Student1name,
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[6]/div/span/a");

	}

	/*
	 * To check the Labels and Details of the All results page and check Student
	 * 1,Student 2,Student 3 Score details
	 */
	@Test(priority = 48)
	public void TCSPR1500748() {

		// Assert the student Names
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[3]/div"), Student1name);
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[3]/div"), Student2name);
		Assert.assertEquals(cm.getdatafromgrid(Student3name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[3]/div"), Student3name);

		// Reward points of student 1,2,3
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[6]/div/span/a"),
				Stud1Rewardscore);
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[6]/div/span/a"),
				Stud2Rewardscore);
		Assert.assertEquals(cm.getdatafromgrid(Student3name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[6]/div/span/a"),
				Stud3Rewardscore);

		// Score received from peers of student 1,2,3

		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[7]/div/span"),
				stud1scorefrompeers);
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[7]/div/span"),
				stud2scorefrompeers);
		Assert.assertEquals(cm.getdatafromgrid(Student3name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[7]/div/span"),
				stud3scorefrompeers);

		// Total Score of student 1,2,3
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[8]/div/span"),
				stud1Totalscore);
		Assert.assertEquals(cm.getdatafromgrid(Student2name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[8]/div/span"),
				stud2Totalscore);
		Assert.assertEquals(cm.getdatafromgrid(Student3name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[8]/div/span"),
				stud3Totalscore);

	}

	/*
	 * To check the Labels
	 */
	@Test(priority = 49)
	public void TCSPR1500749() {

		// click on reconsideration request radio button
		click(trwp.radiobtn_reconsider);
		waitThread(2000);
		// Assert the Reconsideration Requests radio button is selected
		Assert.assertTrue(getAttribute(trwp.radiobtn_reconsider, "Class").contains("checked"));
		// *Assert Only one student names shows on the Grid
		Assert.assertEquals(TotalElementsCount(trwp.studentname), 1);
		// "*Assert the Score Received from Teacher/Peers is Empty"
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[9]/div/span"), "--");
	}
	/*
	 * To verify the Student 1 Details on the grid
	 */

	@Test(priority = 50)
	public void TCSPR1500750() {

		// Assert the student name
		Assert.assertEquals(getText(trwp.studentname), Student1name);
		waitThread(1000);
		// Assert the reviewer name
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[4]/div/div/p-badge/span"),
				Student2name);
		waitThread(1000);
		// Assert the status Reconsideration Pending
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[6]/div/span"),
				"Reconsideration Pending");
		waitThread(1000);
		// Assert the reward score of student 1
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[7]/div/span"),
				Stud1Rewardscore);
		waitThread(1000);
		// Assert the Score received from peers of student 1
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[8]/div/span"),
				stud1scorefrompeers);
		waitThread(1000);
		// Assert the Total Score of student 1
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[10]/div/span"),
				stud1Totalscore);

	}

	/*
	 * To check the reconsider answer window of student 1 and the Student reason for
	 * Reconsideration pop up
	 */
	@Test(priority = 51)
	public void TCSPR1500751() {

		// Reconsider button label
		Assert.assertEquals(getAttribute(trwp.btn_reconsider, "label"), "Reconsider");
		// click on reconsider button
		click(trwp.btn_reconsider);

		// Assert the pop up
		Assert.assertTrue(isElementPresent(trwp.systemGeneratedCommentDialog),
				"Student reason for Reconsideration popup not shows");
		// Assert the pop up heading
		Assert.assertEquals(getText(trwp.commentpopupheading), "Student reason for Reconsideration");
		// Assert the student comment
		Assert.assertEquals(getText(trwp.studentcomment), Student1comment);
		// click on close button
		click(trwp.btnclose_commentpopup);
		waitThread(2000);
		Assert.assertFalse(isElementPresent(trwp.systemGeneratedCommentDialog),
				"Student reason for Reconsideration popup visible");
		// Student reason for Reconsideration button and tool tip
		Assert.assertTrue(isElementPresent(trwp.reconsodercommentbtn),
				"Student reason for Reconsideration button visible");
		Assert.assertEquals(getAttribute(trwp.btn_reconsider_1, "ptooltip"), "Student reason for Reconsideration");

	}

	/*
	 * To check the Labels and buttons on the reconsider answer window
	 */
	@Test(priority = 52)
	public void TCSPR1500752() {

		// Assert the publish button is disabled
		Assert.assertTrue(getAttribute(trwp.btn_publish_recosnider, "class").contains("disabled-btn"),
				"Publish button is Enabled state");
		// Assert the Assessment Name,Course name,Course ID,Student Name
		Assert.assertEquals(getText(arv.result_page_assess_name), AssessmentName);
		Assert.assertTrue(getText(arv.course_name_id).contains(CourseName));
		Assert.assertTrue(getText(arv.course_name_id).contains(CourseID));
		Assert.assertTrue(getText(arv.stud_name_resultwindow).contains(Student1name));
		// Assert the wizard panel
		Assert.assertTrue(getText(arv.wizardq1).contains("1"));

		// Assert the label and check box I approve the Total Scores given by peers
		Assert.assertEquals(getText(ari.iapprove_lbl), "I approve the Total Scores given by peers");
		Assert.assertTrue(isDisplayed(ari.score_checkbx), "Check box not present");
		// Assert the wizard previous button is disabled
		Assert.assertTrue(isElementPresent(trwp.wizardpreviousbtn), "Wizard previous button is Enabled");

	}

	/*
	 * To check the Labels and buttons on the reconsider answer window
	 */
	@Test(priority = 53)
	public void TCSPR1500753() {

		// Assert the Exit button
		Assert.assertTrue(isElementPresent(trwp.btn_exit), "Exit button not visible");
		// Assert the Question 1 is selected
		Assert.assertTrue(getAttribute(arv.wizardq1, "class").contains("p-highlight"));
		// Assert the Label and Value Max Score:
		Assert.assertTrue(getText(arv.maxscore_lbl).contains("Max Score"));
		Assert.assertEquals(getText(arv.maxscore_lbl), "Max Score: " + Maxscore1);
		// Assert the Label and Value Score Received from Peers:
		waitThread(2000);
		Assert.assertEquals(getText(arv.scorefrompeer_lbl), "Score Received from Peers: " + Q1Scorefrompeers);
		// Assert the Label and Value Final Score:
		Assert.assertTrue(getText(arv.final_scrorelbl).contains("Final Score"));
		Assert.assertEquals(getText(arv.final_scrorelbl), "Final Score: " + Q1Finalscore);
		// Total Score
		Assert.assertEquals(getText(trwp.student1totalscorereconsider), stud1Totalscore+"/"+maxscoreposs1);
		// Click on Next button
		click(arv.wizard_nextbtn);

		waitThread(3000);
		// Assert the second Question wizard is selected
		Assert.assertTrue(getAttribute(arv.wizardq2, "class").contains("p-highlight"));
		// Assert the Label and Value Max Score:
		Assert.assertTrue(getText(arv.maxscore_lbl).contains("Max Score"));
		Assert.assertEquals(getText(arv.maxscore_lbl), "Max Score: " + Maxscore2);
		// Assert the Label and Value Score Received from Peers:
		waitThread(2000);
		Assert.assertEquals(getText(arv.scorefrompeer_lbl), "Score Received from Peers: " + Q2Scorefrompeers);
		// Assert the Label and Value Final Score:
		Assert.assertTrue(getText(arv.final_scrorelbl).contains("Final Score"));
		Assert.assertEquals(getText(arv.final_scrorelbl), "Final Score: " + Q2Finalscore);
	}

	/*
	 * To check the Labels and buttons on the reconsider answer window
	 */
	@Test(priority = 54)
	public void TCSPR1500754() {

		waitThread(4000);
		// Click on 3rd Wizard
		Doubleclick(arv.wizardq3);

		waitThread(2000);
		// Assert the 3rd Question wizard is selected
		Assert.assertTrue(getAttribute(arv.wizardq3, "class").contains("p-highlight"));

		waitThread(3000);
		// Assert the Next button is disabled
		Assert.assertTrue(getAttribute(arv.wizard_nextbtn, "class").contains("p-disabled"));
		// Assert the Label and Value Max Score:
		Assert.assertTrue(getText(arv.maxscore_lbl).contains("Max Score"));
		Assert.assertEquals(getText(arv.maxscore_lbl), "Max Score: " + Maxscore3);
		// Assert the Label and Value Score Received from Peers:
		waitThread(2000);
		Assert.assertEquals(getText(arv.scorefrompeer_lbl), "Score Received from Peers: " + Q3Scorefrompeers);
		// Assert the Label and Value Final Score:
		Assert.assertTrue(getText(arv.final_scrorelbl).contains("Final Score"));
		Assert.assertEquals(getText(arv.final_scrorelbl), "Final Score: " + Q3Finalscore);
		//click Q1
		Doubleclick(arv.wizardq1);
		// Assert the Question content
		driver.switchTo().frame("questionId_ifr");
		Assert.assertEquals(getText(arv.quest), Question1);
		driver.switchTo().defaultContent();

		// Assert the accordian label Answer
		Assert.assertEquals(getText(arv.answer_accordian), "Answer");

		waitThread(3000);
		// Assert the Answer of Student 1
		driver.switchTo().frame("answerId_ifr");
		Assert.assertEquals(getText(arv.answer), stud1ans1);
		driver.switchTo().defaultContent();

		// Assert the accordion label Rubric
		Assert.assertEquals(getText(arv.rubric_aacordian), "Rubric");

		waitThread(2000);
		// Click on Rubric accordion
		click(arv.rubric_aacordian);

		// Assert the Rubric of Question 1
		driver.switchTo().frame("standardRubricId_ifr");
		Assert.assertEquals(getText(arv.rubric), Rubric1);
		driver.switchTo().defaultContent();

		// Assert the student Names
		Assert.assertEquals(getText(arv.studname1), Student2name);

		// Assert the Score given by each student
		Assert.assertEquals(getValue(arv.score_stud1), Q1Scorefrompeers);

	}

	public String Q1Scorefromteacher_1 = "8";
	public String Q1Scorefromteacher_new = "2";

	/*
	 * To check the Labels and buttons on the reconsider answer window and type
	 * score for question 1
	 */
	@Test(priority = 55)
	public void TCSPR1500755() {

		// Type Score for Question 1
		type(trwp.scoretextbx, Q1Scorefromteacher_1);
		// click save button
		// Click Save button
		waitThread(2000);
		click(ari.save_btn);

		// Assert the toaster "Score Saved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		
		waitThread(3000);
		// Save button is disabled
		Assert.assertFalse(isEnabled(ari.save_btn), "Save button is Enabled");

		// Wizard status-reconsidered
		Assert.assertTrue(getAttribute(arv.wizardq1, "class").contains("reconsidered"));
		waitThread(2000);
		// Assert the Scores :Score Received from Teacher:
		Assert.assertEquals(getText(ari.scorefromteach_lbl), "Score Received from Teacher: " + Q1Scorefromteacher_1);

	}

	public int Scorefrompeersandteacher;
	public int totalscorestud1;

	/*
	 * To check the exit button functionality and check the labels
	 */
	@Test(priority = 56)
	public void TCSPR1500756() {

		// click on exit button
		click(trwp.btn_exit);
		waitThread(2000);
		// Heading Label
		Assert.assertEquals(getText(trwp.lbl_reconsider_heading), "Reconsideration Requests");
		// Continue button label
		Assert.assertEquals(getAttribute(trwp.btn_continue, "label"), "Continue");
		// Score received from teacher of Q1+Score received from peer of Q2+Score
		// received from peer of Q3
		Scorefrompeersandteacher = (Integer.parseInt(Q1Scorefromteacher_1)) + (Integer.parseInt(Q2Scorefrompeers))
				+ (Integer.parseInt(Q3Scorefrompeers));
		// Score received from peers/Teachers
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[9]/div/span"),
				Integer.toString(Scorefrompeersandteacher));
		// Total Score=Score Received from Teacher/Peers +Reward Score
		totalscorestud1 = Scorefrompeersandteacher + (Integer.parseInt(Stud1Rewardscore));
		// Score received from peers/Teachers
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[10]/div/span"),
				Integer.toString(totalscorestud1));

	}

	/*
	 * To check the labels of reconsideration window and all results page
	 */
	@Test(priority = 57)
	public void TCSPR1500757() {

		// Reconsideration pending count
		Assert.assertEquals(getText(trwp.reconsiderationPendingCount),
				"Reconsideration Request\n" + "Pending: 1\n" + "Processed: 0");
		// click All results button
		click(trwp.radiobtn_allresults);
		// Assert the All results radio button is selected
		Assert.assertTrue(getAttribute(trwp.radiobtn_allresults, "Class").contains("checked"));
		// Score from peers/Teachers
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[8]/div/span"),
				Integer.toString(Scorefrompeersandteacher));

		// Total Score of student 1
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[9]/div/span"),
				Integer.toString(totalscorestud1));

	}
	/*
	 * To check the back button functionality and check the card details
	 */

	@Test(priority = 58)
	public void TCSPR1500758() {

		waitThread(3000);
		// Click On Back button
		click(trwp.back_btn);

		waitThread(6000);
		click(arv.cuurent_assm_tab);
		waitThread(8000);
		// Assert the Current Tab selected
		Assert.assertEquals(getAttribute(arv.cuurent_assm_tab, "aria-selected"), "true");

		// search assessment
		type(st1.assess_searchbx, AssessmentName);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");
		waitThread(3000);
		// Assert the Reconsideration count
		Assert.assertEquals(getText(trwp.teachercard_reconsidercount),
				"Reconsideration requested: 1 Pending 0 Processed");

		// Assert the button label View
		Assert.assertEquals(getAttribute(trwp.btn_view, "label"), "View");

	}

	/*
	 * To view the result from the card and Modify the Score of Q1
	 */
	@Test(priority = 59)
	public void TCSPR1500759() {

		// Click on View Request button
		click(trwp.btn_view);
		waitThread(3000);
		// Heading Label
		Assert.assertEquals(getText(trwp.lbl_reconsider_heading), "Reconsideration Requests");

		// click button continue
		click(trwp.btn_continue);
		waitThread(3000);
		click(trwp.btnclose_commentpopup);
		waitThread(3000);
		// Assert the check box is disabled
		Assert.assertTrue(getAttribute(ari.score_checkbx_check, "class").contains("disabled"));

		// Type new Score for Question 1
		type(trwp.scoretextbx, Q1Scorefromteacher_new);

		// click on exit button
		click(trwp.btn_exit);
		waitThread(2000);

	}

	/*
	 * Click on Exit button from student answer window and check that the Score
	 * modified on the gird
	 */
	@Test(priority = 60)
	public void TCSPR1500760() {

		// Click on Exit button
		click(arv.exit_btn);

		waitThread(1000);
		// Assert the confirmation popup visible
		Assert.assertTrue(isElementPresent(ari.conf_popup), "popup not present");

		waitThread(2000);
		// Assert the buttons and button Lables: Do you want to save the previously
		// added score?
		Assert.assertEquals(getText(ari.conf_txt), "Do you want to save the previously added score?");

		waitThread(1000);
		// Buttons:Discard and Continue,Save and Continue
		Assert.assertEquals(getText(ari.discard_btn), "Discard and Continue");
		Assert.assertEquals(getText(ari.savecont_btn), "Save & Continue");

		waitThread(2000);
		// Click on Button Save and Continue
		click(ari.savecont_btn);
		// Assert the toaster "Score Saved"
		waitFor(QP.toaster);
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);
		// Heading Label
		Assert.assertEquals(getText(trwp.lbl_reconsider_heading), "Reconsideration Requests");

	}

	/*
	 * To check that the Score modified on the gird
	 */
	@Test(priority = 61)
	public void TCSPR1500761() {

		// New Score received from teacher of Q1+Score received from peer of Q2+Score
		// received from peer of Q3
		Scorefrompeersandteacher = (Integer.parseInt(Q1Scorefromteacher_new)) + (Integer.parseInt(Q2Scorefrompeers))
				+ (Integer.parseInt(Q3Scorefrompeers));
		// Score received from peers/Teachers
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[9]/div/span"),
				Integer.toString(Scorefrompeersandteacher));
		// Total Score=Score Received from Teacher/Peers +Reward Score
		totalscorestud1 = Scorefrompeersandteacher + (Integer.parseInt(Stud1Rewardscore));
		// Score received from peers/Teachers
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[10]/div/span"),
				Integer.toString(totalscorestud1));

		// Reconsideration pending count
		Assert.assertEquals(getText(trwp.reconsiderationPendingCount),
				"Reconsideration Request\n" + "Pending: 1\n" + "Processed: 0");

		// click All results button
		click(trwp.radiobtn_allresults);
		// Assert the All results radio button is selected
		Assert.assertTrue(getAttribute(trwp.radiobtn_allresults, "Class").contains("checked"));
		// Score from peers/Teachers
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[8]/div/span"),
				Integer.toString(Scorefrompeersandteacher));

		// Total Score of student 1
		Assert.assertEquals(cm.getdatafromgrid(Student1name,
				"//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[", "]/td[9]/div/span"),
				Integer.toString(totalscorestud1));
	}

	/*
	 * To publish the reconsideration request of Student 1 and check the comment
	 * popup
	 */
	@Test(priority = 62)
	public void TCSPR1500762() {

		// click reconsideration request radio button
		click(trwp.radiobtn_reconsider);
		waitThread(1000);
		// click button continue
		click(trwp.btn_continue);
		waitThread(3000);
		click(trwp.btnclose_commentpopup);
		waitThread(3000);

		// Assert the publish button is Enable
		Assert.assertFalse(getAttribute(trwp.btn_publish_recosnider, "class").contains("disabled-btn"),
				"Publish button is Disabled  state");
		Assert.assertEquals(getAttribute(trwp.btn_publish_recosnider, "ptooltip"),
				"Add you response to the reconsideration and publish");
		// Assert the Scores :Score Received from Teacher:
		Assert.assertEquals(getText(ari.scorefromteach_lbl), "Score Received from Teacher: " + Q1Scorefromteacher_new);
		// Wizard status-reconsidered
		Assert.assertTrue(getAttribute(arv.wizardq1, "class").contains("reconsidered"));

		// click publish button
		click(trwp.btn_publish_recosnider);
		waitThread(1000);
		// Assert the popup visible
		Assert.assertTrue(isElementPresent(trwp.reconsiderCommentPopup), "Comment Popup  not visible");
		// click close button-comment popup
		click(trwp.reconsidercommentclosebtn);
		waitThread(4000);
		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(trwp.reconsiderCommentPopup), "Comment Popup   visible");
		// click publish button
		click(trwp.btn_publish_recosnider);
		// Assert heading
		Assert.assertEquals(getText(trwp.reconsiderCommentPopupheading),
				"Add your response to the reconsideration request");

	}

	/*
	 * To check the details of the Add your response to the reconsideration request
	 * popup
	 */
	public String Teachercomment;

	@Test(priority = 63)
	public void TCSPR1500763() {

		// placeholder
		Assert.assertEquals(getAttribute(trwp.reconReasonField, "placeholder"),
				"Add your comment regarding this reconsideration");
		// To verify the submit button is disabled
		Assert.assertFalse(isEnabled(trwp.reconsidercommentbtnpublish), "Submit button is enabled");

		Teachercomment = "TeacherComment for Student 1_" + generateRandomData();
		// Type reconsideration comment
		type(trwp.commenttextbx, Teachercomment);
		waitThread(4000);
		// To verify the submit button is enabled
		Assert.assertTrue(isEnabled(trwp.reconsidercommentbtnpublish), "Submit button is in disabled state");

	}

	/*
	 * To check the details on the reconsideration request page after publish the
	 * result and check the Answer sheet
	 */
	@Test(priority = 64)
	public void TCSPR1500764() {

		// click on publish button
		click(trwp.reconsidercommentbtnpublish);
		waitThread(2000);
		// Assert the popup visible
		Assert.assertTrue(isElementPresent(trwp.reconsiderpublishpopup),
				"Reconsideration processed publish Popup  not visible");
		// pop up Label
		Assert.assertEquals(getText(trwp.reconsiderpublishpopuplabel), "Result Published Successfully");
		// click back to result button
		click(trwp.reconsiderpublishbacktoresult_btn);
		waitThread(5000);
		// Reconsideration pending count
		Assert.assertEquals(getText(trwp.reconsiderationPendingCount),
				"Reconsideration Request\n" + "Pending: 0\n" + "Processed: 1");
		// Assert the button label View
		Assert.assertEquals(getAttribute(trwp.reconsiderviewbtn, "label"), "View");

	}

	/*
	 * To check the details on the reconsideration request page after publish the
	 * result and check the Answer sheet
	 */
	@Test(priority = 65)
	public void TCSPR1500765() {

		// click view button
		click(trwp.reconsiderviewbtn);
		waitThread(3000);
		// Assert the label
		Assert.assertEquals(getText(trwp.linkteachercomment), "View your response to this reconsideration");
		// Assert the score box not visible
		Assert.assertFalse(isElementPresent(trwp.scoretextbx), "Score box  not visible");

		// Assert the label and check box I approve the Total Scores given by peers not
		// visible
		Assert.assertFalse(isElementPresent(ari.iapprove_lbl),
				"I approve the Total Scores given by peers label present");
		Assert.assertFalse(isElementPresent(ari.score_checkbx), "Check box  present");
		// Wizard status-reconsidered
		Assert.assertTrue(getAttribute(arv.wizardq1, "class").contains("reconsidered"));
		waitThread(2000);
		// Assert the Scores :Score Received from Teacher:
		Assert.assertEquals(getText(ari.scorefromteach_lbl), "Score Received from Teacher: " + Q1Scorefromteacher_new);

		// click View your response to this reconsideration
		click(trwp.linkteachercomment);
		waitThread(2000);
		// Assert the pop up visible
		Assert.assertTrue(isElementPresent(trwp.teacherComment), "Reconsideration teacher comment Popup  not visible");
		// verify teacher comment on the popup
		Assert.assertEquals(getValue(trwp.teacherCommentField), Teachercomment);
		// click close button and check the popup not visible
		click(trwp.teacherCommentFieldclosebtn);
		waitThread(2000);
		Assert.assertFalse(isElementPresent(trwp.teacherComment), "Reconsideration teacher comment Popup   visible");

	}

	/*
	 * To check the Reconsideration details on the Card
	 */
	@Test(priority = 66)
	public void TCSPR1500766() {

		// Click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(6000);
		// search assessment
		type(st1.assess_searchbx, AssessmentName);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");
		waitThread(3000);
		// Assert the Reconsideration count
		Assert.assertEquals(getText(trwp.teachercard_reconsidercount),
				"Reconsideration requested: 0 Pending 1 Processed");
	}

	/*
	 * To check the reconsideration tab after reconsideration processing
	 */
	@Test(priority = 67)
	public void TCSPR1500767() {
		// Click on Reconsideration Requests Tab
		click(trwp.reconsidertab);
		waitThread(4000);
		// Verify the tab is selected
		Assert.assertEquals(getAttribute(trwp.tab_reconsiderationrequest, "aria-selected"), "true");

		// Search the Assessment Name
		type(trwp.searchbox, AssessmentName);
		waitThread(3000);
		// Assert the Assessment name not visible on the page
		Assert.assertTrue(getText(trwp.gridemptylabel).contains("No Assessment(s) Found."), "Assessment Name visible");
	}

	@Test(priority = 68)
	public void TCSPR1500768() {
		// Perform Teacher Logout
		cm.Logout();
		
		// login as Student 1
		waitThread(2000);
		lg.login("student1@gmail.com", cm.Password);

		// Search the Assessment Name
		waitThread(5000);
		Doubleclick(st1.stud_searchbx);
		waitThread(1000);
		click(st1.stud_searchbx);
		driver.findElement(By.id("searchAssessmentFilter")).sendKeys(AssessmentName);
		waitThread(3000);

		// Assert the view result button visible
		Assert.assertTrue(isElementPresent(rwbt.viewresultbtn), "View result button not visible");
		Assert.assertEquals(getText(rwbt.viewresultlbl), "View Result");
		// Assert the Result status is Reconsideration Processed
		Assert.assertEquals(getText(trwp.Cardlbl_reconsideration), "Reconsideration Processed");
	}

	/*
	 * To perform view result and check the teacher response for reconsideration
	 */
	@Test(priority = 69)
	public void TCSPR1500769() {

		// click on view result button
		click(rwbt.viewresultbtn);
		waitThread(3000);

		// Assert Result pop up visible
		Assert.assertTrue(isElementPresent(rwbt.resultpopup), "Result Popup  not visible");

		// Assert the View Teacher Response to Reconsideration Request button is
		// enabled
		Assert.assertFalse(getAttribute(trwp.viewteachercomment, "class").contains("disabled"),
				"Teacher Response to Reconsideration Request button is disabled");
		// click Teacher Response to Reconsideration Request button
		click(trwp.viewteachercomment);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(trwp.teachercommentfield), "Teacher comment  Popup  not visible");
		// heading Teacher's response to Reconsideration Request
		Assert.assertEquals(getText(trwp.headingcomment), "Teacher's response to Reconsideration Request");
		
		Assert.assertEquals(getValue(trwp.teachercommentfield), Teachercomment);
		click(trwp.teachercommentclosebtn);
		waitThread(2000);
		Assert.assertFalse(isElementPresent(trwp.teachercommentfield), "Teacher comment  Popup   visible");

	}

	/*
	 * To check the Scores and labels on the result popup
	 */
	@Test(priority = 70)
	public void TCSPR1500770() {
		waitThread(2000);
		// Score Received from Peer Reviewers/Teacher
		Assert.assertEquals(getText(trwp.lbl_peerscore), "Score Received from Peer Reviewers/Teacher\n"
				+ Integer.toString(Scorefrompeersandteacher) + "/" + TotalTestPoints);
		
		// Total Score
		Assert.assertEquals(getText(trwp.lbltotalscore),
				"Total Score\n" + "(Score Received from Peer Reviewers/Teacher + Score for Peer Review Done)\n"
						+ Integer.toString(totalscorestud1) + "/" + maxscoreposs1);
		// *Assert the Scores Received from Teacher of Q1
		Assert.assertEquals(trwp.getdatafromgridstudent("1",
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[7]/div/span"),
				Q1Scorefromteacher_new);
		// *Assert the status of Q1 is Teacher Reconsidered
		Assert.assertEquals(trwp.getdatafromgridstudent("1",
				"//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[9]/div"),
				"Teacher Reconsidered");

	}

	/*
	 * To check the Scores and labels on the result pop up
	 */
	@Test(priority = 71)
	public void TCSPR1500771() {

		// Click on Q1 view button
		click(trwp.Q1viewbtn);
		waitThread(3000);
		// *Assert the Label "Teacher Reconsidered "
		Assert.assertEquals(getText(trwp.answerwindowreconsoderstatus), "Teacher Reconsidered");
		waitThread(3000);
		// Assert the Score Received from Teacher: value same as teacher page
		Assert.assertEquals(getText(sasb.scorefromteach), "Score Received from Teacher: " + Q1Scorefromteacher_new);
		int finalscoreQ1 = Integer.parseInt(Q1rewardscorestud) + Integer.parseInt(Q1Scorefromteacher_new);
		// Assert the Final Score of Q1 is Scores Received from Teacher+Reward Score of
		// Q1
		Assert.assertEquals(getText(sasb.final_scrorelbl), "Final Score: " + Integer.toString(finalscoreQ1));
		// Assert the Total Score of the Answer sheet
		Assert.assertEquals(getText(sasb.totalscr_lbl),
				"Total Score " + Integer.toString(totalscorestud1) + "/" + maxscoreposs1);

	}

	/*
	 * To perform Logout of Student 1
	 */
	@Test(priority = 72)
	public void TCSPR1500772() {

		cm.Logout();
		// Assert heading Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

}
