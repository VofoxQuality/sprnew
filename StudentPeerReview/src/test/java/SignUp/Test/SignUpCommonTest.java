package SignUp.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;

import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class SignUpCommonTest extends basePage {

	SignUpPage sp = new SignUpPage();
	Databaseconnection dcc = new Databaseconnection();
	RemoveStudentFromCoursePage rsp = new RemoveStudentFromCoursePage();
	CommonMethods cm=new CommonMethods();
	public String EmailStudent;
	public String otp;
	public String Studentfirstname = "Clara";
	public String Studentlastname = "April";

	@Test(priority = 1)
	public void SignUp() throws SQLException {
		SignUptest();
	}

	public String SignUptest() throws SQLException {

		driver.get(prop.getProperty("baseUrl"));
		click(sp.btn_in);
		waitThread(2000);

		EmailStudent = "studenttest" + generateRandomNumber().trim() + "@gmail.com";
		// click first name
		click(sp.txtbxFirstN);

		// type first name
		type(sp.txtbxFirstN, Studentfirstname);

		// click last name
		click(sp.txtbxLastN);

		// type last name
		type(sp.txtbxLastN, Studentlastname);

		// click email
		click(sp.txtbxEmail);

		// type email
		type(sp.txtbxEmail, EmailStudent);

		// click password
		click(sp.txtbxPass);

		// type password
		type(sp.txtbxPass, "Abc@123");

		// click password
		click(sp.txtbxPassconf);

		// type password
		type(sp.txtbxPassconf, "Abc@123");

		
		// click on privacy policy check box
		click(sp.chkbx_1);

		// click signup button
		click(sp.btn_signup);


		return EmailStudent;
	}

	@Test(priority = 2)
	public void SignUpotp() throws SQLException {

		// To verify Labels on the Enter verification code page
		Assert.assertEquals(getText(sp.label1), "We've sent you a verification code to this Email address:\n"
				+ EmailStudent + "\n" + "Please enter the code here to verify your account");

		waitThread(2000);

		// catch otp from sending resource

		otp = dcc.sprotp(EmailStudent);

		// Type OTP
		driver.findElement(By.xpath(sp.otpbx_1)).sendKeys(otp);

		waitThread(3000);

		// verify heading label
		waitFor(rsp.btnlbl_joincourse);
		Assert.assertEquals(getText(rsp.btnlbl_joincourse), "Join New Course");

	}
	
	//@Test(priority = 3)
	public void deleteaccount() {
		
		driver.get("http://192.168.7.108:8051/SPRClient/student-courses");
		cm.login("josy.johnson+student38@vofoxsolutions.com", "123456");
		waitThread(3000);
		cm.DeleteAccount();
		
	}

}
