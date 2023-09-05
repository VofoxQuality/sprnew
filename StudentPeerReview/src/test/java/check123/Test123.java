package check123;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import CreateNewAssessment.Pages.AssessmentPublishPopupPage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.ClickableRubricPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CreateNewAssessment.Pages.SummaryQuestionsPage;
import CurrentAssessmentsforStudents.Pages.StudentPeerReviewPage;
import CurrentAssessmentsforStudents.Pages.StudentResultSectionPage;
import CurrentAssessmentsforStudents.Pages.StudentTestSectionPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import NewAssessmentOfTeacherPage.TeacherResultSectionPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import PeerReviewWindowofIndividualStudentPages.ModifyReviewWizardPanelPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowWizardPage;
import ResultWindowforIndividualStudent.Page.StudentAnswerSheetBasicsPage;
import ResultWindowforIndividualStudent.Page.StudentResultWindowBasicsPage;
import ResultWindowofIndividualTeacherPage.TeacherAutomaticResultPeerreviewIncompletePage;
import ResultWindowofIndividualTeacherPage.TeacherAutomaticResultreviewcompletePage;
import ResultWindowofIndividualTeacherPage.TeacherManualReconsiderationEnabledreviewcompletePage;
import ResultWindowofIndividualTeacherPage.TeacherManualResultPeerreviewcompletePage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import TestWindowOfIndividualStudent.AnswerWindowPage;
import TestWindowOfIndividualStudent.AssessmentSubmitAndStatusPopUpPage;
import TestWindowOfIndividualStudent.ModifySubmittedAnswersPage;
import TestWindowOfIndividualStudent.ModifyWizardSectionPage;
import TestWindowOfIndividualStudent.TestWindowWizardPage;

public class Test123 extends basePage {

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
	TeacherManualResultPeerreviewcompletePage mrp = new TeacherManualResultPeerreviewcompletePage();
	TeacherManualReconsiderationEnabledreviewcompletePage mre = new TeacherManualReconsiderationEnabledreviewcompletePage();

	public String AssessmentName = "Assessment2594045";
	
	@Test(priority = 1)
	public void TCSPR1500201() {

		// Assert the heading label "Welcome to Student Peer Review"
		Assert.assertEquals(getText(lg.wel_label), "Welcome to Student Peer Review");

		click(lg.LoginBtn_1);
	}

	/*
	 * To verify the result section Labels
	 */
	@Test(priority = 31)
	public void TCSPR1500431() {
		// Login to Teacher profile
		cm.login(cm.emailteacher, cm.Password);

		// Click Assessment tab
		click(QP.teach_assesstab);

		waitThread(5000);

		// search assessment
		type(st1.assess_searchbx, AssessmentName);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(st1.teach_assess_card), "Published Assessment card not visible");
		waitThread(3000);
		
		/*
		 * To get resconsideration date& time in Teacher card
		 */
		 String resultdate;
		 String resultime;
		
		 
			String[] arrOfStr1 = getText(mre.lstdate_time).split("\n");
			String w2= arrOfStr1[arrOfStr1.length - 1];
			System.out.println("w2= "+w2);
			waitThread(1000);
			
			String[] arrOfStr = (w2).split(" ");
			waitThread(2000);
			String month = arrOfStr[arrOfStr.length - 5];
			String d = arrOfStr[arrOfStr.length - 4];
			String y= arrOfStr[arrOfStr.length - 3];
			String year= y.substring(0, 4);

			String time = arrOfStr[arrOfStr.length - 2];
			String timeampm = arrOfStr[arrOfStr.length - 1];

			 resultdate = month + " " + d+ year;
				System.out.println(resultdate);
			 
			String[] arrOfStrtime = time.split(":");
			String houresult = arrOfStrtime[arrOfStrtime.length - 2];
			String min= arrOfStrtime[arrOfStrtime.length - 1];

			String hr;

			int l = houresult.length();
			if (l== 1) {
				hr= "0" + houresult;
			} else {
				hr= houresult;
			}

			resultime= hr+ ":" + min + " " + timeampm;

		System.out.println(resultime);
		
		
		
		 String recondate1= cm.getdates(resultdate);
		 String reconstime1 = resultime;
	
		//Assert.assertEquals(recondate1,mre.getdates1(date));
		//Assert.assertEquals(reconstime1,cm.removeLeadingZeroes(time2));
		

			// Perform logout
			cm.Logout();

			// Assert heading Login
			Assert.assertEquals(getText(lg.PageTitle), "Login");
	}
	
	
	
	
	
}	