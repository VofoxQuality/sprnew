package CommonFunctionalities.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import AccountSettings.Pages.AccountSettingsandDeleteAccountPage;
import Course.Pages.CreateNewCoursePage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;

public class CommonFileTest extends basePage {
	
	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	AccountSettingsandDeleteAccountPage as = new AccountSettingsandDeleteAccountPage();
	EncryptedText et = new EncryptedText();
	CommonMethods cm = new CommonMethods();

	public String Emailteacher;
	public String CourseTitle_1;
	public String NewCourseTitle;
	public String CourseID_1;
	public String AssessmentName;
	public String Emailstudent1;
	public String Emailstudent2;
	public String Emailstudent3;
	public String CourseTitle_2;
	public String CourseID_2;
	public String otp;
	public String Email;
	public String NewEmail;
	public String Test;
	public String Teacherfirstname;
	public String Teacherlastname;
	public String Teachername;
	public String Password;

	/*
	 * To perform Sign Up functionality
	 */
	public String SignUpTeacher(){
		
		SoftAssert softAssert1 = new SoftAssert();

		Teacherfirstname = "Test";
		Teacherlastname = "Teacher";
		Teachername = Teacherfirstname + " " + Teacherlastname;
		Password = "Abc@123";
		
		// To click on I am A teacher button
		click(sp.btn_1);
		
		// click first name
		click(sp.txtbxFirstN);

		// type first name
		type(sp.txtbxFirstN, Teacherfirstname);

		Teacherfirstname = getValue(sp.txtbxFirstN);

		// click last name
		click(sp.txtbxLastN);

		// type last name
		type(sp.txtbxLastN, Teacherlastname);

		// click email
		click(sp.txtbxEmail);

		Email = "test" + generateRandomNumber().trim() + "@gmail.com";
		// Teachername="Test"

		// type email
		type(sp.txtbxEmail, Email);

		// click password
		click(sp.txtbxPass);

		// type password
		type(sp.txtbxPass, Password);

		// click password
		click(sp.txtbxPassconf);

		// type password
		type(sp.txtbxPassconf, Password);

		waitThread(6000);
		// click signup button
		waitThread(5000);
		// click on privacy policy check box
		click(sp.chkbx_1);

		// verify the checkbox is checked
		Assert.assertTrue(isElementPresent(sp.chkbx_sel), "The privacy policy checkbox is not selected.");

		// click signup button
		click(sp.btn_signup);

		waitFor(sp.toaster);
		// validation message-Please Check your Email to enter Verification Code
		softAssert1.assertEquals(getText(sp.toaster), "Please check your email to enter the Verification Code",
				"Assersion failed");
		waitThread(3000);

		// verify heading-Email Verification Code
		softAssert1.assertEquals(getText(sp.HeadingTitle_2), "Email Verification Code");
		
		softAssert1.assertAll();
		
		return Email;

	}
	@Test(priority = 0)
	public void SignUp1() throws SQLException {
		

		// To click on I am A teacher button
		click(sp.btn_1);
		

		// To fill the details on the sign up page
		Emailteacher = SignUpTeacher();
	}
	
	@Test(priority = 1)
	public void OtpFetch() throws SQLException {

		SoftAssert softAssert2 = new SoftAssert();

		// To verify OTP boxes
		Assert.assertTrue(isElementPresent(sp.otpbx_1), "OTP box 1 present");
		Assert.assertTrue(isElementPresent(sp.otpbx_2), "OTP box 2 present");
		Assert.assertTrue(isElementPresent(sp.otpbx_3), "OTP box 3 present");
		Assert.assertTrue(isElementPresent(sp.otpbx_4), "OTP box 4 present");

		// To verify Labels on the Enter verification code page
		softAssert2.assertEquals(getText(sp.label1), "We've sent you a verification code to this Email address:\n"
				+ Email + "\n" + "Please enter the code here to verify your account", "Assertion  failed");

		// catch otp from sending resource

		otp = dc.sprotp(Email);

		// Type OTP
		driver.findElement(By.xpath(sp.otpbx_1)).sendKeys(otp);
		waitThread(2000);
		sp.selecttrialplan();
		waitFor(lg.pagetitle3);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");
		softAssert2.assertAll();

	}
	
	
	@Test(priority = 2)
	public void Course1creation() {
		
		CourseTitle_1 = "Course Name_" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID_1 = (getText(cn.course_Id));

		// type-Course title
		type(cn.txbx_Coursetitle, CourseTitle_1);

		// click on Add students button
		click(cn.btn_AddStudents);

		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent3="student3" + generateRandomNumber().trim() + "@gmail.com";

		// type email
		type(cn.tab_textbox, Emailstudent1 + ",");
		driver.findElement(By.xpath("//input[@id='inviteStudentChip']")).sendKeys(Keys.SPACE);
		type(cn.tab_textbox, Emailstudent2 + ",");
		driver.findElement(By.xpath("//input[@id='inviteStudentChip']")).sendKeys(Keys.SPACE);
		type(cn.tab_textbox, Emailstudent3 + ",");

		// verify email present on the text box
		Assert.assertEquals(cn.emailvalue(0), Emailstudent1);

		Assert.assertEquals(cn.emailvalue(1), Emailstudent2);
		Assert.assertEquals(cn.emailvalue(2), Emailstudent3);

		// click on add to list button
		click(cn.tab_btn_Addtolist);

		waitThread(2000);
		Scroll_DowntoEnd();

		// click on create course button
		click(cn.btn_Createcourse);

		waitThread(1000);
		waitFor(cn.toaster);

		// verify toaster-Course created successfully
		Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");

		waitThread(3000);

		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), CourseTitle_1.trim());


	}
	
	@Test(priority = 3)
	public void Course2creation(){
		
		CourseTitle_2 = "Course Name 2" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID_1 = (getText(cn.course_Id));

		// type-Course title
		type(cn.txbx_Coursetitle, CourseTitle_2);

		// click on Add students button
		click(cn.btn_AddStudents);

		// type email
		type(cn.tab_textbox, Emailstudent1 + ",");
		driver.findElement(By.xpath("//input[@id='inviteStudentChip']")).sendKeys(Keys.SPACE);
		type(cn.tab_textbox, Emailstudent2 + ",");

		// verify email present on the text box
		Assert.assertEquals(cn.emailvalue(0), Emailstudent1);

		Assert.assertEquals(cn.emailvalue(1), Emailstudent2);

		// click on add to list button
		click(cn.tab_btn_Addtolist);

		waitThread(2000);
		Scroll_DowntoEnd();

		// click on create course button
		click(cn.btn_Createcourse);

		waitThread(1000);

		waitThread(3000);

		cm.Logout();
	}
	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Student1firstname;
	public String Student1lastname;
	public String stud1name;
	public String stud2name;
	public String Student2firstname;
	public String Student2lastname;
	@Test(priority = 4)
	public void Student1invitation() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent1, CourseID_1);

		String encText = et.EncryptCode(studentinviteid);
		driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);

		Student1firstname = "Ashley";
		Student1lastname = "Albert";
		stud1name = Student1firstname + " " + Student1lastname;
		waitThread(3000);
		// click first name
		click(sp.txtbxFirstN);

		// type first name
		type(sp.txtbxFirstN, Student1firstname);

		// click last name
		click(sp.txtbxLastN);

		// type last name
		type(sp.txtbxLastN, Student1lastname);

		// click password
		click(sp.txtbxPass);

		// type password
		type(sp.txtbxPass, password);

		// click password
		click(sp.txtbxPassconf);

		// type password
		type(sp.txtbxPassconf, password);

		// click on privacy policy check box
		click(sp.chkbx_1);

		// click signup button
		click(sp.btn_signup);

		waitThread(5000);

		// verify heading label
		waitFor(cn.lbl_joincourse);
		Assert.assertEquals(getText(cn.lbl_joincourse), "Join New Course");

		// verify course name visible
		Assert.assertTrue(isElementPresent(cn.course_name), "Course Name Not Present");
	}
	
	@Test(priority = 5,invocationCount=2)
	public void TCSPR0901105() {

		// click on accept course button
		click(cn.btn_acceptcourse);

		// verify the confirmation pop up visible
		Assert.assertTrue(isElementPresent(cn.box_confirmation), "Course box Not visible");

		// click on Yes button
		click(cn.popupbtn_Yes);

		// Toaster message
		waitFor(cn.toaster);
		Assert.assertEquals(getText(cn.toaster), "Course accepted successfully");

		waitThread(3000);

		// perform logout functionality
	//	cm.Logout();

		// Heading Title-Login
		//Assert.assertEquals(getText(lg.PageTitle), "Login");
	}
	
	public void coursedelete(String text) {

		// click course tab
		click("//*[@id='navbar-menu']/div/a[1]");
		waitThread(1000);
		// click course delete dropdown
		click("p-splitbutton > div > button.p-splitbutton-menubutton> span.pi.pi-chevron-down");
		waitThread(1000);
		// click delete course button
		click("//p-splitbutton/div/p-menu/div/ul/li[5]/a/span");
		waitThread(1000);
		Assert.assertTrue(isElementPresent("#mainCoursesGrid > app-courses-grid > p-confirmdialog > div > div"),
				"delete popup not visible");
		Assert.assertEquals(getText("p-confirmdialog > div > div > div.p-dialog-content"), text);
		click("button.p-confirm-dialog-reject");
		waitThread(2000);
	}

	
}
	
	
