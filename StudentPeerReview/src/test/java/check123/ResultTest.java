package check123;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Generalmethods.CommonMethods;

import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.ScheduleConfigureDefaultPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;


public class ResultTest extends basePage {

	LoginPage lg = new LoginPage();
	CommonMethods cm = new CommonMethods();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	ScheduleConfigureDefaultPage sd = new ScheduleConfigureDefaultPage();
	@Test(priority = -1)
    public  void day() throws ParseException {
    	
    	System.out.println(sd.getnextday());
    	
    	String str="01:30AM";
    	System.out.println(sd.removeLeadingZeroes(str));
    	
    	
    }
	@Test(priority = 1)
	public void login() {

		click(lg.LoginBtn_1);

		cm.login(cm.emailteacher, cm.Password);
		
		

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

		driver.get("http://192.168.7.108:8051/SPRClient/assessment/reconsider-evaluation/629d9e2d8e1bafdbf94c82b1");
		waitThread(2000);
		
		System.out.println(getText("//div[@id='reconMaxScorePossible']"));
		System.out.println(getText("//*[@id='colorHintDiv']/div[1]/div[1]"));

//		//to fetch data from grid
//		System.out.println("The Total score of Student 2 is  "+cm.getdatafromgrid("Ben Alex", "//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[","]/td[10]/div/span"));
//		Assert.assertEquals(cm.getdatafromgrid("Ben Alex", "//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[","]/td[10]/div/span"), "85");	
//		
//		//Score Received fromTeacher/Peers
//		System.out.println("The Score Received fromTeacher/Peers of Student 3 is  "+cm.getdatafromgrid("Clara Albert", "//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[","]/td[8]/div/span"));
//		Assert.assertEquals(cm.getdatafromgrid("Clara Albert", "//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr[","]/td[8]/div/span"), "20");	
//
//		//To click on reward Score
//		cm.clickrewardscoreofstudent("Clara Albert", "//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[", "]/td[6]/div");
//		waitThread(1000);
//		click("button.p-dialog-header-icon.p-dialog-header-close.p-link");
		
	}

	//@Test(priority = 2)
	public void Answersheetclick() {

		//click on answer sheet
		cm.clickstudentanswersheet("Ben Alex","//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[","]/td[11]/div/button");
		waitThread(5000);
		
	}
	
	
	

}
