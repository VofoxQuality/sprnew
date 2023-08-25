package CreateNewAssessment.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.steadystate.css.parser.ParseException;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import Course.Pages.EditCoursePage;
import Course.Test.CreateNewCourseTest;
import Course.Test.EditCourseTest;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.BasicDetailsPageCourseandEditorPage;
import CreateNewAssessment.Pages.ClickableRubricPage;
import CreateNewAssessment.Pages.DatepickerPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;

public class DatepickerTest extends basePage {
	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	CreateNewCourseTest cnt = new CreateNewCourseTest();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	BasicDetailsAssessmentTest bat = new BasicDetailsAssessmentTest();
	EditCoursePage ec = new EditCoursePage();
	EditCourseTest ect = new EditCourseTest();
	BasicDetailsPageCourseandEditorPage be = new BasicDetailsPageCourseandEditorPage();
	SchedulePageBasicsPage sb = new SchedulePageBasicsPage();
	CourseRosterPage cr = new CourseRosterPage();
	ClickableRubricPage ck = new ClickableRubricPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
DatepickerPage dp= new DatepickerPage();
RescheduleDatesPage rd=new RescheduleDatesPage();
CommonMethods cm= new CommonMethods();
	public String Emailteacher;
	public String CourseName;
	public String NewCourseTitle;
	public String CourseID;
	public String AssessmentName;
	public String NewCourseName;


		/*
		 * To perform Login functionality
		 */
		@Test(priority = 1)
		public void TCSPR1400101() {

			click(lg.LoginBtn_1);

			cm.login(cm.emailstudent1, cm.Password);

			
			// click on Assessment tab
			click(ba.Assessmenttab);
			waitThread(5000);
//			// Search The Assessment Name
//			driver.findElement(By.xpath("//input[@id='searchAssessments']")).sendKeys("Time checking");
//			driver.findElement(By.xpath("//input[@id='searchAssessments']")).sendKeys(" ");
//			waitThread(5000);
//			
//			System.out.println("curr timw "+cm.gettime());
//			// Click menu button
//			click(rd.threedot_btn);
//
//			Assert.assertTrue(isElementPresent(rd.reschedulemenu), "Reschedule Dates menu not present");
//
//			Assert.assertEquals(getText(rd.reschedulemenu), "Reschedule Dates");
//
//			// Click Reschedule dates
//			click(rd.reschedulemenu);
//			waitThread(2000);
//			
//			// Assert the Reschedule popup visible
//			Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");
//			

		}
		public String assessmentduetime;
		//@Test(priority = 2)
		public void TCSPR1400102() {
			
//			 // Create object of SimpleDateFormat class and decide the format
//			 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
//			 
//			 //get current date time with Date()
//			 Date date = new Date();
//			 
//			 // Now format the date
//			 String date1= dateFormat.format(date);
			 
			 // Print the Date
			 System.out.println(cm.getdate());
			
			click(rd.assessmentduedate_txtbx);
			waitThread(3000);
			type(rd.assessmentduedate_txtbx, cm.getdate());
			driver.findElement(By.xpath("//p-calendar[@id='testEndDateCalendar']//input")).sendKeys(Keys.ENTER);
			waitThread(6000);
			String assessmentduetime1=getValue(rd.assessmentduetime_txtbx);
			LocalTime assessmentduetime = LocalTime.parse(cm.gettime().substring(0, 5));
			assessmentduetime = assessmentduetime.plusMinutes(2);
			Assert.assertEquals(getValue(rd.assessmentduetime_txtbx),assessmentduetime+" "+assessmentduetime1.substring(6, 8));
			System.out.println(assessmentduetime+assessmentduetime1.substring(6, 8));
		}
		
		@Test(priority = 3)
		public void TCSPR1400103(){
			
		// Search The Assessment Name
			driver.findElement(By.xpath("//input[@id='searchAssessmentFilter']")).sendKeys("History_2206629");
		driver.findElement(By.xpath("//input[@id='searchAssessmentFilter']")).sendKeys(" ");
			
			click("//*[@id='studentAssessmentDataView']/div/div/div/div[5]/div/div[1]/div[2]/button");
			waitThread(3000);
			System.out.println(getText("//div[@id='studentAnswered']"));
			System.out.println(getText("//div[@id='studentPeerScore']"));
			System.out.println(getText("//div[@id='studentPeerDone']"));
			System.out.println(getText("//div[@id='studentPeerDone']/following::div[1]"));
			System.out.println(getText("//div[@id='studentTotalScore']"));
			//System.out.println("studentPeerScore "+getText("//div[@id='studentPeerScore']"));
		}
		
}

