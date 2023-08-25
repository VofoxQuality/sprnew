package AddorRemoveTest;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.apache.http.impl.conn.tsccm.WaitingThread;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import AccountSettings.Pages.AccountSettingsandDeleteAccountPage;
import AddorRemove.page.AddorRemove;
import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import Course.Test.CourseRosterTest;
import CreateNewAssessment.Pages.AssessmentPublishPopupPage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CreateNewAssessment.Test.AssessmentPublishPopupTest;
import CreateNewAssessment.Test.PeerReviewPageStudentDetailsTest;
import CreateNewAssessment.Test.SummaryBasicsTest;
import CreateNewAssessment.Test.SummaryQuestionClickableRubircTest;
import CurrentAssessmentsforStudents.Pages.StudentCurrentAssessmentBasicsPage;
import CurrentAssessmentsforStudents.Pages.StudentTestSectionPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.NewAssessmentTeacherBasicsPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowWizardPage;
import PeerReviewWindowofIndividualStudentPages.ReviewByMultipleStudentsPage;
import ResultWindowofIndividualTeacherPage.TeacherAutomaticResultreviewcompletePage;
import ResultWindowofIndividualTeacherTest.TeacherAutomaticResultreviewcompleteTest;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import StudentLogin.Pages.StudentAcceptCoursePage;
import StudentLogin.Pages.StudentProfileBasicDetailsPage;
import StudentLogin.Test.RemoveStudentFromCourseTest;

public class AddorRemoveStudents extends basePage{
	AddorRemove at = new AddorRemove();
	Databaseconnection dc = new Databaseconnection();
	EncryptedText et = new EncryptedText();
	PeerReviewPageStudentDetailsTest ps = new PeerReviewPageStudentDetailsTest();
	PeerReviewPageStudentDetailsPage ps1 = new PeerReviewPageStudentDetailsPage();
	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	RemoveStudentFromCourseTest rs1 = new RemoveStudentFromCourseTest();
	LoginPage lg = new LoginPage();
	CourseRosterPage cr = new CourseRosterPage();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	AssessmentPublishPopupTest ap1 = new AssessmentPublishPopupTest();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	TeacherAutomaticResultreviewcompleteTest ta1 = new TeacherAutomaticResultreviewcompleteTest();
	TeacherAutomaticResultreviewcompletePage arv = new TeacherAutomaticResultreviewcompletePage();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	CommonMethods cm = new CommonMethods();
	SummaryQuestionClickableRubircTest sr = new SummaryQuestionClickableRubircTest();
	SchedulePageBasicsPage sb = new SchedulePageBasicsPage();
	AssessmentPublishPopupPage ap = new AssessmentPublishPopupPage();
	SummaryBasicsPage sb1 = new SummaryBasicsPage();  
	SummaryBasicsTest sbt = new SummaryBasicsTest();
	NewAssessmentTeacherBasicsPage natb = new NewAssessmentTeacherBasicsPage();
	StudentCurrentAssessmentBasicsPage sca = new StudentCurrentAssessmentBasicsPage();
	PeerReviewPageStudentDetailsPage ps2 = new PeerReviewPageStudentDetailsPage();
	ReviewByMultipleStudentsPage rp = new ReviewByMultipleStudentsPage();
	TeacherPeerReviewSectionPage tp = new TeacherPeerReviewSectionPage();
	AccountSettingsandDeleteAccountPage as = new AccountSettingsandDeleteAccountPage();
	PeerReviewWindowWizardPage prw = new PeerReviewWindowWizardPage();
	CourseRosterTest cr1 = new CourseRosterTest();
	StudentProfileBasicDetailsPage spdp = new StudentProfileBasicDetailsPage();	
	StudentTestSectionPage st1 = new StudentTestSectionPage();
	
	
	
	
	public String Emailteacher;
	public String Email;
	public String otp;
	public String Password;
	public String Teacher_firstname;
	public String Teacher_lastname;
	public String Teacher_fullname;
	public String studentinviteid;
	public String Studentfirstname;
	public String Studentlastname;
	public String Studentname;
	public String Studentfirstname2;
	public String Studentlastname2;
	public String Studentname2;
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
	public String CourseName1;
	public String CourseName2;
	public String CourseNamenew;
	public String NewCourseTitle;
	public String AssessmentName2;
	public String NewAssessmentName;
	public String New1AssessmentName;
	public String NewCourseName;
	public String CourseID1;
	public String assessmentduedate1;
	public String testduetime;
	
	
	
	
	
	
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";
	public String Student1name = "Ashley Albert";
	public String Student2name = "Ben Max";
	
	
	
	
	
	
	/*
	 * To perform Sign Up functionality
	 */
	
	
  @Test (priority = 0)
  public void TCSPR1700101() {
	  
  Email = "test" + generateRandomNumber().trim() + "@gmail.com";
	  
 // To click on I am A teacher button
 click(sp.btn_1);

 Emailteacher = st.TCSPR020005();
			 
		
	 }
 
  @Test(priority = 1)
	public void OtpFetch() throws SQLException {

		// To catch OTP from sending Resource
   st.TCSPR020006();

	}
  
  /*
	 * To create new course
	 */
  
  public String CourseName;
  public String CourseID;
  public String Emailstudent1;
  public String Emailstudent2;
  public String Emailstudent3;
  
  
  
  @Test(priority = 2)
	public void TCSPR1700102() throws SQLException {
	  

		CourseName = "Course Name" + generateRandomNumber().trim();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID = (getText(cn.course_Id));
		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";

		// Invite students to course
		cm.Invitestudentstocourse(CourseName, Emailstudent1, Emailstudent2);

	  
	  
  }
  @Test(priority = 3)
	public void TCSPR1700104() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}
  
  /*
	 * To sign up to the student profile
	 */
  @Test(priority = 4)
	public void TCSPR1700105() throws SQLException {
	  
	  
	 
	  studentinviteid = dc.InviteLink(Emailstudent1, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		//driver.get("http://192.168.7.108:8042/SPRClient/signup/" + encText);
		
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname = "Ashley";
		Studentlastname = "Albert";
		Studentname = Studentfirstname + " " + Studentlastname;
		
		waitThread(2000);

		// click first name
		click(sp.txtbxFirstN);

		// type first name
		type(sp.txtbxFirstN, Studentfirstname);

		// click last name
		click(sp.txtbxLastN);

		// type last name
		type(sp.txtbxLastN, Studentlastname);

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
		waitFor(rs.lbl_joincourse);
		Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");

		// verify course name visible
		Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not Present");

		// verify the the course name
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());

	  
	 
	  
  }
  /*
	 * To Accept course and perform logout functionality on the student profile
	 */
  @Test(priority = 5)
	public void TCSPR1700106() {

	// click on accept course button
			click(rs.btn_acceptcourse);

			// verify the confirmation popup visible
			Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");

			// click on Yes button
			click(rs.popupbtn_Yes);

			// Toaster message
			waitFor(rs.toaster);
			Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
			waitThread(3000);

			// verify the course name visible on the enrolled section
			
			waitFor(rs.enrolledcoursename);
			Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());
			waitThread(3000);
  }
			
  @Test(priority = 6)
  public void logoutstudent() throws SQLException {
	  
			// perform logout functionality
			rs.Logout();
			waitThread(3000);

			// Heading Title-Login
			Assert.assertEquals(getText(lg.PageTitle), "Login");
			waitThread(2000);
		
	}
  
  @Test(priority = 7)
  public void student2signup() throws SQLException {
	 
	  
	  studentinviteid = dc.InviteLink(Emailstudent2, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get(prop.getProperty("UrlSignUp") + encText);
		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname = "Ben";
		Studentlastname = "Max";
		Studentname = Studentfirstname + " " + Studentlastname;
		//Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
		
		
		waitThread(2000);

		// click first name
		click(sp.txtbxFirstN);

		// type first name
		type(sp.txtbxFirstN, Studentfirstname);

		// click last name
		click(sp.txtbxLastN);

		// type last name
		type(sp.txtbxLastN, Studentlastname);

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
		waitThread(2000);

		// click signup button
		click(sp.btn_signup);

		waitThread(5000);

		// verify heading label
		waitFor(rs.lbl_joincourse);
		Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");

		// verify course name visible
		Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not Present");

		// verify the the course name
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());

	  
	  
	  
	  
	  
  }
  /*
	 * To Accept course and perform logout functionality on the student profile
	 */
  
  @Test(priority = 8)
  public void student2courseaccept() {
		
		 // click on accept course button
		 click(rs.btn_acceptcourse);
		
		 // verify the confirmation popup visible
		 Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");
		
		 // click on Yes button
		 click(rs.popupbtn_Yes);
		
		 // Toaster message
		 waitFor(rs.toaster);
		 Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
		
		 // verify the course name visibled on the enrolled section
		 waitFor(rs.enrolledcoursename);
		 Assert.assertEquals(getText(rs.enrolledcoursename).trim(),
		 CourseName.trim());
		 waitThread(3000);
		
		 // perform logout functionality
		 rs.Logout();
		
		 // Heading Title-Login
		 Assert.assertEquals(getText(lg.PageTitle), "Login");
		 
	}
  
  /*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */
  
 
  @Test(priority = 9)
  public void TCSPR1700107() {
	  
	  
	  
	 
	  SoftAssert softAssert1 = new SoftAssert();
	  rs.login_Teacher(Emailteacher, password);
		waitThread(1000);
		
		// click on Assessment tab
				click(ba.Assessmenttab);
				waitThread(3000);
				// Assert button create new assessment
				Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

				// To click on create new assessment button and verify label
				click(ba.btn_createnewassessment);
				waitThread(3000);
				
				// To click on course dropdown
				click(ba.dd_course);
				CourseName = "Course Name" + generateRandomNumber();
				
				waitFor(ba.ddcoursename1);


				click(ba.ddcoursename1);
				waitThread(3000);
				// Type Assessment Name
				click(QP.Assess_name);
				AssessmentName = "Assessment" + generateRandomNumber().trim();

				type(QP.Assess_name, AssessmentName);

				waitThread(3000);

				// Click Save &Next button
				click(QP.Savenext);
				waitThread(1000);

				// Assert the label "Questions"
				Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

				waitThread(5000);
				// Assert the assessment name
				Assert.assertEquals(getText(pr.QPassessname_lbl), AssessmentName);

				softAssert1.assertAll();
	}


	/*
	 * To fill details for Question 1
	 */
	@Test(priority = 10)
	public void TCSPR1700108() {  
		
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

				// Type Sample answer
				click(QP.sample_ans_btn);
				driver.switchTo().frame("sampleAnswer_ifr");
				type(QP.sample_ansbx, "Sample answer");
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
				waitThread(2000);
				
	}
	/*
	 * To fill details for Question 2
	 */
	
	@Test(priority = 11)
	public void TCSPR1700109() {
  
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

				click(QP.save);
				waitFor(QP.toaster);

				// Assert a toaster Saved successfully
				Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully");
				click(QP.toasterclosebtn);
		
				waitThread(3000);
				// Click on +button
				click(rd.add_quest_btn);	}
				
	/*
	 * To fill details for Question 3
	 */
	@Test(priority = 12)
	public void TCSPR1700110() {

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

	public String RewardPercent = "100";
	
	/*
	 * To verify the details on the peer review page
	 */
	@Test(priority = 13)
	public void TCSPR1700111() {
		waitThread(2000);

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		// Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		waitThread(2000);
		// Select Answer Sheets Per Student =2
		click(rp.reviewans_sheetdropdwn);
		waitThread(2000);
		click(at.reviewssheett_count);
		waitThread(1000);

	}
	public String assessmentopendate;
	public String assessmentopentime;
	public String assessmentduedate;
	public String assessmentduetime;
  
	/*
	 * To perform the save and next functionaity from peer review page and
	 * verify the schedule page details
	 */
	@Test(priority = 14)
	public void TCSPR1700112 () {                  

		// Type peer review reward score
		type(pr.PRreward_txtbox, "100");
		waitThread(1000);

		click(pr.savennext_button);

		waitThread(3000);
		

		// Read date and time
		assessmentopendate = getValue(sb.assessmentopendate_txtbx);
		assessmentopentime = getValue(sb.assessmentopentime_txtbx);
		assessmentduedate = getValue(sb.assessmentduedate_txtbx);
		assessmentduetime = getValue(sb.assessmentduetime_txtbx);

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		// Click on save and next button
		click(pr.savennext_button);
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");
		click(QP.toasterclosebtn);

	}

	/*
	 * To verify the details on the Summary page & publish the Assessment
	 */
	@Test(enabled = false)
	public void TCSPR1700113() {

		
		waitThread(8000);
		driver.findElement(By.id("publishBtn")).click();
		// Assert the popup visible
		Assert.assertTrue(isElementPresent(ap.publish_popup), "popup not visible");

		// Assert toaster "Assessment published successfully
		Assert.assertEquals(getText(ap.Assessmentcreated_lbl), "Assessment Created Successfully");

		// Assert button Back to Menu
		Assert.assertTrue(isElementPresent(ap.Backtomenu_btn), "button not visible");

	}

	/*
	 * To perform Assessment publish functionality
	 */
	@Test(priority = 16)
	public void TCSPR1700114() {

		// Click Save&Next button
		click(QP.savenext_btn);
		waitThread(1000);

		// click on Release Button
		click(sb1.btnrelease);

		waitFor(QP.toaster);
		// Assert toaster "Assessment published successfully
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");
		click(QP.toasterclosebtn);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(natb.publishpopup), "Publish popup not visible");

		// Assert toaster "Assessment published successfully
		Assert.assertEquals(getText(ap.Assessmentcreated_lbl), "Assessment Created Successfully");

		// Assert button Back to Menu
		Assert.assertTrue(isElementPresent(ap.Backtomenu_btn), "button not visible");

		waitThread(2000);

	}

	/*
	 * To check the back to menu button functionality and check the created
	 * assessment visible on the current assessment tab
	 */
	@Test(priority = 17)
	public void TCSPR1700115() {

		waitThread(4000);
		// click on Back To Menu Button
		click(natb.btnbacktomenu);
		waitThread(2000);

		// search assessment
		type(tp.search_box, AssessmentName);
		waitThread(5000);

		

	}
	
	/*
	 * To check the Add/Remove Students from the Assessments  popup
	 */
	@Test(priority = 18)
	public void TCSPR1700116() throws InterruptedException {

		SoftAssert softAssert1 = new SoftAssert();

		waitThread(10000);

		WebElement element = driver.findElement(By.xpath("//*[@id=\"teacherAssessmentDataView\"]/div/div[1]/div/div[3]/div/div[1]/div/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 

		// Click menu button
		click(at.three_dot_btn);
		waitThread(5000);
		
		Assert.assertEquals(getText(at.add_orremove_menu), "Add/Remove students from Assessment");

		waitFor(at.add_orremove_menu);
		waitThread(1000);
		click(at.add_orremove_menu);
		waitThread(1000);

		// Assert the addorremove popup visible
		Assert.assertEquals(getText(at.add_orremove_header), "Add/Remove Students from the Assessment");
		
		softAssert1.assertAll();

	}
	/*
	 * To check the Add/Remove Students from the Assessments popup details 
	 */
	
	@Test(priority = 19)
	public void TCSPR1700117() {

		SoftAssert softAssert1 = new SoftAssert();

		// Assert Assessment Name
		Assert.assertEquals(getText(at.assesment_name), "Assessment Name:");
		// Assert Course Name
		Assert.assertEquals(getText(at.course_name), "Course Name:");
		// Assert text 'Students Enrolled in the Course'
		Assert.assertEquals(getText(at.student_enr_course), "Students Enrolled in the Course");
		// Assert Info statement
		Assert.assertEquals(getText(at.info_data),
				"You can Add/Remove the students & update Peer Review Untill one hour before the Test Due date and Time");

		// verify remove_student Button is not visible
		Assert.assertTrue(isElementPresent(at.remove_btn), "removeStudentBtn");

		// verify add_student Button is not visible
		Assert.assertTrue(isElementPresent(at.addstudent_btn), "addStudentBtn");

		// Assert Text Students assigned to the Assessment
		Assert.assertEquals(getText(at.std_asigned), "Students assigned to the Assessment");

		softAssert1.assertAll();
	}
	
	/*
	 To check the Add/Remove Students from the Assessments popup details
	 */
				
	@Test(priority = 20)
	public void TCSPR1700118() {

		SoftAssert softAssert1 = new SoftAssert();

		// Assert grid names SL No., Student ID ,Student Name - remove students
		Assert.assertEquals(getText(at.sl_no), "Sl No:");
		Assert.assertEquals(getText(at.std_id), "Student ID");
		Assert.assertEquals(getText(at.std_name), "Student Name");

		Assert.assertEquals(getText(at.sl_no1), "Sl No:");
		Assert.assertEquals(getText(at.std_id1), "Student ID");
		Assert.assertEquals(getText(at.std_name1), "Student Name");

		// Assert No Student(s) Found on the Students not assigned to the Assessment
		// grid
		Assert.assertEquals(getText(at.no_stds), "No Student(s) Found.");

		// *Assert Cancel button
		Assert.assertTrue(isElementPresent(at.cancel_btn), "Cancel");
		// Assert Proceed & Update Peer Review button
		Assert.assertTrue(isElementPresent(at.proceed_btn), "Proceed & Update Peer Review");
		softAssert1.assertAll();
	}
	/*
	 * To check Remove Student on Students assigned to the Assessment functionalities			
	 */
	@Test(priority = 21)
	public void TCSPR1700119() {

		// click on check box
		waitFor(at.studentchkbx_1);
		check(at.studentchkbx_1);

		waitThread(1000);

		// verify remove_student Button
		Assert.assertTrue(isElementPresent(at.remove_btn), "Remove Student");
		click(at.remove_btn);

		waitThread(1000);

		driver.findElement(By.xpath(at.cancel_btn)).isDisplayed();
		click(at.cancel_btn);

		// Assert the confirmation popup visible
		Assert.assertTrue(isElementPresent(at.confrm_popup), "Confirmation");
		

		Assert.assertTrue(isElementPresent(at.no_btn), "No");
		Assert.assertTrue(isElementPresent(at.yes_btn), "Yes");

		driver.findElement(By.xpath(at.yes_btn)).isDisplayed();
		click(at.yes_btn);
		// Assert popup is redirect to Assessment page
		Assert.assertEquals(getText(at.asmnt_label), "Assessments");
		waitThread(1000);

	}
	/*
	 * To add more students to the the course
	 */

	@Test(priority = 22)
	public void TCSPR1700120() {

		// verify heading courses
		Assert.assertEquals(getText(at.course_tab), "Courses");
		click(at.course_tab);
		waitThread(1000);

		// click on details button dropdown
		click(cn.btn_details_1);

		// verify link course roster
		waitFor(cr.link_courseroster);
		Assert.assertEquals(getText(cr.link_courseroster), "View/Modify Student Roster");

		// click on course roster link
		click(cr.link_courseroster);
		waitThread(3000);
		// verify the heading
		Assert.assertEquals(getText(cr.heading_courseroster), "Student Roster");

		waitThread(3000);
		

	}

	@Test(priority = 23)
	public void invite_students() {

		waitThread(1000);
		Assert.assertTrue(isElementPresent(cr.btn_Addstudents), "Add Students");

		// click on Add students button
		click(cr.btn_Addstudents);

		waitFor(cr.chip_1);
		click(cr.chip_1);

		// Type email on chip

		Emailstudent3 = "student3" + generateRandomNumber().trim() + "@gmail.com";
		type(cr.chip_1, Emailstudent3);
		driver.findElement(By.xpath(cr.chip_1)).sendKeys(Keys.SPACE);

		

		// click on Add to list button
		click(at.add_list);
		click(cn.confirmyesbtn);		
		click("//p-tabview/div/ul/li[3]/a/span[2]");
		waitThread(1000);

		// verify the preview tab is visible
		//Assert.assertTrue(isElementPresent(cr.preview_tab), "Preview Tab is visible");
		//waitThread(1000);

		// verify the Emails visible on the preview grid
		Assert.assertEquals(getText(cr.preview_Emailchip_1), Emailstudent3);
		waitThread(1000);
	}

	@Test(priority = 24)
	public void send_request() {

		// click on Send request button
		click(cr.btn_previewsendrequest);

		waitFor(cr.toaster);

		// verify toaster message
		Assert.assertEquals(getText(cr.toaster), "Successfully sent email(s)");
		waitThread(2000);

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}
	
			/*
			 * To check that invited course request visible on  profile and accept course request 
			 * Read the student name	
			 */
	public String Stud_firstname3;
	public String Stud_lastname3;
	public String Password1;
	//public String coursename;
	
	StudentAcceptCoursePage sa = new StudentAcceptCoursePage();
	
	@Test(priority = 25)
	public void TCSPR1700121() throws SQLException {

		Stud_firstname3 = "Test";
		Stud_lastname3 = "Student";
		Password1 = "Abc123";

		// To perform Sign up functionality of student

		studentinviteid = dc.InviteLink(Emailstudent3, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		// driver.get("UrlSignUp"+ encText);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		waitThread(2000);

		// click first name
		click(sp.txtbxFirstN);

		// type first name
		type(sp.txtbxFirstN, Stud_firstname3);

		// click last name
		click(sp.txtbxLastN);

		// type last name
		type(sp.txtbxLastN, Stud_lastname3);

		// click password
		click(sp.txtbxPass);

		// type password
		type(sp.txtbxPass, Password1);

		// click password
		click(sp.txtbxPassconf);

		// type password
		type(sp.txtbxPassconf, Password1);

		// click on privacy policy check box
		click(sp.chkbx_1);

		// click signup button
		click(sp.btn_signup);

		waitThread(5000);

		// verify heading label
		waitFor(rs.lbl_joincourse);
		Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");

		

	}


	@Test(priority = 26)
	public void stud3_logout() throws SQLException {

		// click on accept course button
		click(rs.btn_acceptcourse);

		// verify the confirmation popup visible
		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");

		// click on Yes button
		click(rs.popupbtn_Yes);

		// Toaster message
		waitFor(rs.toaster);
		Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
		waitThread(8000);

		// perform logout functionality
		rs.Logout();
		waitThread(3000);

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
		waitThread(2000);

	}

/*
 * To check remove student functionalities on the add/remove page
 */
@Test(priority = 27)
public void TCSPR1700122() throws InterruptedException {

	rs.login_Teacher(Emailteacher, password);
	waitThread(1000);

	// click on Assessment tab
	click(ba.Assessmenttab);
	waitThread(3000);

	// search assessment
	type(tp.search_box, AssessmentName);
	waitThread(10000);

	WebElement element = driver.findElement(By.xpath("//*[@id=\"teacherAssessmentDataView\"]/div/div[1]/div/div[3]/div/div[1]/div/p"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	Thread.sleep(5000); 


	// Click menu button
	click(at.three_dot_btn);
	waitThread(3000);

	// Click addorremove menu
	click(at.add_orremove_menu);
	waitThread(3000);

}

	/*
	 * To check Add the selected students into the assessment functionalities	
	 */
	
	@Test(priority = 28)
	public void TCSPR1700123() {

		// click on check box
		waitFor(at.studentchkbx_2);
		check(at.studentchkbx_2);

		click(at.addstudent_btn);
		waitThread(2000);

		// click on check box
		waitFor(at.studentchkbx_1);
		check(at.studentchkbx_1);

		click(at.remove_btn);
		waitThread(1000);

		// Click on proceed button
		click(at.proceed_btn);

		waitThread(3000);

		// waitFor(at.bck_btn);
		click(at.bck_btn);

		waitThread(2000);

		// click on check box
		waitFor(at.studentchkbx_2);
		check(at.studentchkbx_2);

		waitThread(1000);
		click(at.addstudent_btn);
		waitThread(2000);

		click(at.proceed_btn);

	}

	@Test(priority = 29)
	public void TCSPR1700125() {

		waitThread(4000);
		// Select Answer Sheets Per Student =2
		click(at.reviewans_sheetdropdwn);
		waitThread(2000);
		click(at.reviewssheet_count);

		waitThread(1000);

		click(at.save_btn);

		waitThread(5000);

	}
	
	
	@Test(priority = 30)
	public void TCSPR1700135() {
		
		
		// Click menu button
		click(at.three_dot_btn);
		waitThread(5000);
		// click reschedule dates
		click(at.Reschedule_date);
		waitThread(2000);

		
		// Set the Assessment due date to current day
		click(rd.assessmentduedate_txtbx);
		assessmentduedate1 = getValue(st1.resche_testduedat_txtbx);
		testduetime = getValue(st1.resche_testendtime_txtbx);
		waitThread(2000);
		cm.ClickTodaysDate();
		waitThread(2000);

		
		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitThread(8000);

	}
	
	//To check Add/ Remove button is display after test window is closed
	@Test(priority = 31)
	public void TCSPR1700136() {
		
		// click on Assessment tab
		click(ba.Assessmenttab);
		//Assert text Assessments
		//Assert.assertEquals(getText(at.asmnt_label), "Assessments");
		waitThread(5000);	
		
		// Click menu button
		waitThread(5000);
		click(rd.threedot_btn);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(at.add_orremove_menu), "Add/Remove students menu not present");
	
	}
	
	
	
	//"To perform Delete Teacher Account functionality"
	
	@Test(priority = 32)
	public void TCSPR1700137() throws InterruptedException {

		waitThread(3000);
		SoftAssert assert1 = new SoftAssert();
		// click navigation dropdown
		click(as.nav_drop1);
		TimeUnit.SECONDS.sleep(2);
		// click account settings button
		click(as.accnt_sett1);
		TimeUnit.SECONDS.sleep(2);
		// Assert the label Account Settings in accountsettings Page
		Assert.assertEquals(getText(as.hd_label5), "Account Settings");
		TimeUnit.SECONDS.sleep(2);
		// click delete account button
		click(as.delete_button4);
		// Assert the confirmation box
		Assert.assertTrue(isElementPresent(as.popbox_1), "Confirmation popup not visible");
		TimeUnit.SECONDS.sleep(2);

		waitFor(as.alrt_yesbutton);
		// click No button in popup
		click(as.alrt_yesbutton);
		// Assert confirmation popup not visible
		Assert.assertTrue(isElementPresent(as.popbox_1), "Confirmation popup not visible");
		waitThread(4000);
		// Verify the header text
		Assert.assertEquals(getTitle(), "Student Peer Review");
		assert1.assertAll();

	}

		@Test(priority = 33)
		public void login_Delete_Teacher() {

			waitThread(2000);


			// login using deleted account credentials
			lg.login(Emailteacher, password);

			waitFor(lg.toaster);
			// verify toaster text
			Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

		}
	

  
}
