package CreateNewAssessment.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import Course.Pages.EditCoursePage;
import Course.Test.CreateNewCourseTest;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.BasicDetailsPageCourseandEditorPage;
import CreateNewAssessment.Pages.ClickableRubricPage;
import CreateNewAssessment.Pages.MultipleQuestionsAddPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionEditorAndMultipleCategoryAddPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryAssessmentInfoAndInstructionPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CreateNewAssessment.Pages.SummaryQuestionsPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class SummaryQuestionsTest extends basePage {
	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	CreateNewCourseTest cnt = new CreateNewCourseTest();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	EditCoursePage ec = new EditCoursePage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	CourseRosterPage cr = new CourseRosterPage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	EncryptedText et = new EncryptedText();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	SchedulePageBasicsPage sb = new SchedulePageBasicsPage();
	ClickableRubricPage ck = new ClickableRubricPage();
	MultipleQuestionsAddPage mq = new MultipleQuestionsAddPage();
	SummaryQuestionsPage sq = new SummaryQuestionsPage();
	BasicDetailsAssessmentTest bdastt = new BasicDetailsAssessmentTest();
	SummaryBasicsPage sbt = new SummaryBasicsPage();
	BasicDetailsPageCourseandEditorPage be = new BasicDetailsPageCourseandEditorPage();
	QuestionEditorAndMultipleCategoryAddPage QE = new QuestionEditorAndMultipleCategoryAddPage();
	SummaryAssessmentInfoAndInstructionPage sa = new SummaryAssessmentInfoAndInstructionPage();
	CommonMethods cm = new CommonMethods();
	public String Emailteacher;
	public String CourseName;
	public String CourseName2;
	public String CourseNamenew;
	public String NewCourseTitle;
	public String CourseID;
	public String AssessmentName;
	public String AssessmentName2;
	public String NewAssessmentName;
	public String New1AssessmentName;
	public String NewCourseName;
	public String CourseID1;
	public String Emailstudent1;
	public String Emailstudent2;

	public String Studentfirstname;
	public String Studentlastname;
	public String Studentname;
	public String Studentfirstname2;
	public String Studentlastname2;
	public String Studentname2;


	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	public String assessmentopendate;
	public String assessmentopentime;
	public String assessmentduedate;
	public String assessmentduetime;
	
	public String Assessmentinfo;
	public String Assessmentinstruction;

	SchedulePageBasicsPage sbp = new SchedulePageBasicsPage();

	/*
	 * To perform Sign Up functionality
	 */
	@Test(priority = 0)
	public void TCSPR0901201() {

		// To click on I am A teacher button
		click(sp.btn_1);

		// To fill the details on the sign up page
		Emailteacher = st.TCSPR020005();

	}

	@Test(priority = 1)
	public void OtpFetch() throws SQLException {

		// To catch OTP from sending Resource
		st.TCSPR020006();

	}

	/*
	 To perform the create new 
   course functionality on the landing page and To invite students to course
	 */
	@Test(priority = 2)
	public void TCSPR0901202() throws SQLException {

		CourseName = "Course Name" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID = (getText(cn.course_Id));

		// type-Course title
		type(cn.txbx_Coursetitle, CourseName);

		// click on Add students button
		click(cn.btn_AddStudents);

		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";

		// type email
		type(cn.tab_textbox, Emailstudent1 + ",");
		driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
		type(cn.tab_textbox, Emailstudent2 + ",");

		// verify email present on the text box
		Assert.assertEquals(cn.emailvalue(0), Emailstudent1);

		Assert.assertEquals(cn.emailvalue(1), Emailstudent2);

		// click on add to list button
		click(cn.tab_btn_Addtolist);

		waitThread(2000);
		waitFor(cr.emailval_1);

		// verify the Email on the New Students to be invited to this class box
		Assert.assertEquals(getText(cr.emailval_1), Emailstudent1);
		Assert.assertEquals(getText(ps.emailval_2), Emailstudent2);

		// click on create course button
		click(cn.btn_Createcourse);

		waitThread(1000);
		waitFor(cn.toaster);

		// verify toaster-Course created successfully
		Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");

		waitThread(3000);

		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), CourseName.trim());

	}
	//To perform logout functionality on the teacher profile

	@Test(priority = 3)
	public void TCSPR0901203() {
		waitThread(3000);
		click(rs.header_dropdown);
		//Assert link Logout
		Assert.assertTrue(isElementPresent(rs.logout_link), "Logout link not visible");
		waitThread(3000);
		// logout functionality
		click(rs.logout_btn);
		waitThread(2000);
		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}
	//To check that invited course request visible on first student's profile and accept course request  -Read the student name

	@Test(priority = 4)
	public void TCSPR0901204() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent1, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get("http://192.168.7.108:8042/SPRClient/signup/" + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname = "Ashley";
		Studentlastname = "Albert";
		Studentname = Studentfirstname + " " + Studentlastname;

		// click first name
		click(sp.txtbxFirstN);
		waitThread(2000);
		// type first name
		type(sp.txtbxFirstN, Studentfirstname);
		waitThread(2000);
		// click last name
		click(sp.txtbxLastN);
		waitThread(2000);
		// type last name
		type(sp.txtbxLastN, Studentlastname);
		waitThread(2000);
		// click password
		click(sp.txtbxPass);
		waitThread(2000);
		// type password
		type(sp.txtbxPass, password);
		waitThread(2000);
		// click password
		click(sp.txtbxPassconf);
		waitThread(2000);
		// type password
		type(sp.txtbxPassconf, password);
		waitThread(2000);
		// click on privacy policy check box
		click(sp.chkbx_1);
		waitThread(2000);
		// click signup button
		click(sp.btn_signup);

		waitThread(5000);

		// verify heading label
		waitFor(rs.lbl_joincourse);
		Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");
		waitThread(5000);
		// verify course name visible
		Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not Present");

		// verify the the course name
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());

	}
	// To Accept course and perform logout functionality on the student profile
	@Test(priority = 5)
	public void TCSPR0901205() {

		// click on accept course button
		click(rs.btn_acceptcourse);

		// verify the confirmation popup visible
		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");

		// click on Yes button
		click(rs.popupbtn_Yes);

		// Toaster message
		waitFor(rs.toaster);
		Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");

		// verify the course name visible on the enrolled section
		waitFor(rs.enrolledcoursename);
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*To check that invited  course request visible on second student's profile and accept course request
          -Read the student name*/
	@Test(priority = 6)
	public void TCSPR0901206() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent2, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get("http://192.168.7.108:8042/SPRClient/signup/" + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname2 = "Ben";
		Studentlastname2 = "Max";
		Studentname2 = Studentfirstname2 + " " + Studentlastname2;

		// click first name
		click(sp.txtbxFirstN);
		waitThread(2000);
		// type first name
		type(sp.txtbxFirstN, Studentfirstname2);
		waitThread(2000);
		// click last name
		click(sp.txtbxLastN);
		waitThread(2000);
		// type last name
		type(sp.txtbxLastN, Studentlastname2);
		waitThread(2000);
		// click password
		click(sp.txtbxPass);
		waitThread(2000);		// type password
		type(sp.txtbxPass, password);
		waitThread(2000);
		// click password
		click(sp.txtbxPassconf);
		waitThread(2000);
		// type password
		type(sp.txtbxPassconf, password);
		waitThread(2000);
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

	@Test(priority = 7)
	public void TCSPR0901207() {

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
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());

		waitThread(3000);
		// perform logout functionality
		click(rs.header_dropdown);
		//Assert link Logout
		Assert.assertTrue(isElementPresent(rs.logout_link), "Logout link not visible");
		waitThread(3000);
		// logout functionality
		click(rs.logout_btn);
		waitThread(2000);
		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */
	@Test(priority = 8)
	public void TCSPR0901208() {
		SoftAssert softAssert1 = new SoftAssert();
		rs.login_Teacher(Emailteacher, password);

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
		waitFor(ba.ddcoursename1);

		softAssert1.assertEquals(getText(ba.ddcoursename1), CourseName.trim(),
				"course name not visible on the dropdown");

		click(ba.ddcoursename1);
		waitThread(3000);
		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentName = "Assessment" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentName);

		waitThread(3000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(3000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(5000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), AssessmentName);

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID + ", " + CourseName.trim());

		softAssert1.assertAll();
	}
	/*
	 * To fill details on the Question page
	 * 
	 */
	@Test(priority = 9)
	public void TCSPR0901209() {

		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question1");

		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);

		// Click rubric drop down
		//click(QP.add_rubrics_tab);
		//waitThread(3000);

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "Standard 1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "10");

		waitThread(4000);

		Assert.assertEquals(getAttribute(QP.max_scorbx, "value"), "10");

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(2000);

		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

		waitThread(3000);

		/*
		 * To verify the details on the peer review page
		 * 
		 */

	}
	@Test(priority = 10)
	public void TCSPR0901210() {

		waitThread(2000);
		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl), "Total Students : 2");

		// Assert the first student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Studentname);

		// Assert the second student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Studentname2);

	}

	/*
	 * To perform the save and next functionaity from peer review page and verify the schedule 
		   page details
	 * 
	 */

	@Test(priority = 11)
	public void TCSPR0901211() {
		SoftAssert softAssert3 = new SoftAssert();
		waitThread(3000);
		type(pr.reward_percentage, "50");
		// Click Save &Next button
		click(pr.savennext_button);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		softAssert3.assertEquals(getText(QP.toaster), "Saved successfully", "Assertion  failed");
		click(QP.toasterclosebtn);

		waitThread(3000);

		// Assert the schedule wizard is selected
		softAssert3.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true", "Assertion  failed");

		// Assert Course name and course code
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseName.trim()));
		softAssert3.assertAll();
	}
	/*
	 * To Perform Save&Next and to verify the details on the Summary page
	 */
	@Test(priority = 12)
	public void TCSPR0901212() {

		SoftAssert softAssert4 = new SoftAssert();
		waitThread(3000);
		// Click Save &Next button
		click(pr.savennext_button);
		//	waitThread(2000);
		//waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		//softAssert4.assertEquals(getText(QP.toaster), "Saved successfully", "Assertion  failed");
		//	click(QP.toasterclosebtn);

		waitThread(3000);

		// Assert the Summary wizard is selected
		softAssert4.assertEquals(getAttribute(sq.summary_wizard_high, "aria-expanded"), "true", "Assertion  failed");

		waitThread(3000);
		// Assert the label assessment name
		Assert.assertTrue(getText(sq.assesment_label).contains("Assessment Name:"));
		//Assert the course labels
		Assert.assertTrue(getText(sq.course_label).contains("Course:"));
		//Assert the assessment name
		Assert.assertTrue(getText(sbt.summaryassessmentname).contains("Assessment Name: " + AssessmentName));
		waitThread(1000);
		//Assert.assertTrue(getText(sq.course_name).contains(CourseName));

		//Assert the course code
		Assert.assertTrue(getText(sq.course_name).contains(CourseID));
		//Assert the Course name
		Assert.assertTrue(getText(sq.course_name).contains(CourseName.trim()));
		//
		Assert.assertTrue(isElementPresent(sq.preview_btn), "Preview Button Not present");
		//
		Assert.assertTrue(isElementPresent(sq.discard_btn), "Discard Button Not present");
		//
		Assert.assertTrue(isElementPresent(sq.save_exit_btn), "Save&Exit Button Not present");
		//
		Assert.assertTrue(isElementPresent(sq.release_btn), "Release Button Not present");
		softAssert4.assertAll();
	}

	/*
	 * To Perform Save&Next and to verify the details on the Summary page
	 */
	@Test(priority = 13)
	public void TCSPR0901213() {
		SoftAssert softAssert5 = new SoftAssert();
		waitThread(3000);
		//*Assert the Edit button[Assessment Edit]
		Assert.assertTrue(isElementPresent(sq.assesment_edit_btn), "Assesment Edit Button Not present");
		//Click on Edit button
		click(sq.assesment_edit_btn);
		waitThread(2000);
		//*Assert the Basic Details wizard is selected
		softAssert5.assertEquals(getAttribute(sb.basic_detail_wizard, "aria-expanded"),"true", "Assertion  failed");
		//Click on discard button
		click(sq.discard_btn1);
		//*Assert the confirmation popup visible
		Assert.assertTrue(isElementPresent(sq.discard_popup), "Discard confirmation popup Not visible");
		/*Assert the confirmation text "Are you certain you want to proceed with your action?
		We see that you have not made any changes to the information on this screen"*/
		Assert.assertEquals(getText(sq.confirmation_txt), "Are you certain you want to proceed with your action?\n"
				+ "We see that you have not made any changes to the information on this screen");
		waitThread(1000);
		//Click on cancel button
		click(sq.cancel_btn);
		waitThread(2000);
		Assert.assertFalse(isElementPresent(sq.discard_popup), "Discard confirmation popup visible");
		softAssert5.assertEquals(getAttribute(sb.basic_detail_wizard, "aria-expanded"),"true", "Assertion  failed");

		//Assert.assertEquals(getAttribute(sq.course_drpdown,"label"),CourseName);
		Assert.assertEquals(getText(sq.course_drpdown.trim()),CourseName.trim());
		Assert.assertTrue(isElementPresent(sq.discard_btn1), "Discard Button Not visible");
		Assert.assertTrue(isElementPresent(sq.Save_btn), "Save and Next Button Not visible");

		softAssert5.assertAll();


	}
	/* To check the validation messages on the Basic details Edit page */
	@Test(priority = 14)
	public void TCSPR0901214() {

		waitThread(1000);
		//Clear the Assessment name
		driver.findElement(By.xpath(QP.Assess_name)).clear();
		waitThread(2000);
		click(sq.assesment_txtbx);
		waitThread(1000);
		type(sq.assesment_txtbx, "s");
		driver.findElement(By.xpath(QP.Assess_name)).sendKeys(Keys.BACK_SPACE);
		waitThread(2000);
		//*Assert validation message "Assessment Name is required"
		Assert.assertEquals(getText(sq.validation_msg), "Assessment Name is required");

		click(sq.Save_btn);
		waitThread(1000);
		waitFor(QP.toaster);

		// *Assert toaster "Please enter the Assessment Name"
		Assert.assertEquals(getText(QP.toaster), "Please enter the Assessment Name");

		click(QP.toasterclosebtn);
	}
	/* To perform Discard functionality on the basic details page */
	@Test(priority = 15)
	public void TCSPR0901215() {
		//Type Assessment name
		waitThread(1000);
		type(sq.assesment_txtbx, AssessmentName);
		click(sq.discard_btn1);
		waitThread(1000);
		//*Assert confirmation popup visible
		Assert.assertTrue(isElementPresent(sq.discard_popup), "Discard confirmation popup Not visible");
		/*Assert text"Are you certain you want to proceed with your action?
		We see that you have not made any changes to the information on this screen*/

		Assert.assertEquals(getText(sq.confirmation_txt), "Are you certain you want to proceed with your action?\n"
				+ "We see that you have not made any changes to the information on this screen");

		waitThread(1000);
		//*Assert button Cancel , Discard
		Assert.assertTrue(isElementPresent(sq.cancel_btn), "Cancel button Not visible");
		Assert.assertTrue(isElementPresent(sq.discard_btn1), "Discard button Not visible");
		click(sq.cancel_btn);
		waitThread(2000);
		//*Assert confirmation popup not visible
		Assert.assertFalse(isElementPresent(sq.discard_popup), "Discard confirmation popup visible");
		waitThread(2000);
		//*Assert the Basic Details wizard is selected
		Assert.assertEquals(getAttribute(sb.basic_detail_wizard, "aria-expanded"),"true");
		waitThread(2000);
		click(sq.discard_btn);
		waitThread(3000);
		//*Assert confirmation popup visible
		Assert.assertTrue(isElementPresent(sq.discard_popup), "Discard confirmation popup Not visible");
		click(sq.discard_btn2);
		waitThread(3000);
		//*Assert the Summary wizard is selected
		Assert.assertEquals(getAttribute(sq.summary_wizard_high, "aria-expanded"), "true");
		//*Assert the Assessment name
		Assert.assertTrue(getText(sbt.summaryassessmentname).contains("Assessment Name: " + AssessmentName));


	}
	/*To change the assessment name and check the new assessment name on the Question/Peer review/schedule/summary pages*/
	@Test(priority = 16)
	public void TCSPR0901216() {
		SoftAssert softAssert6 = new SoftAssert();
		waitThread(1000);
		//Click on Edit button
		click(sq.assesment_edit_btn);
		waitThread(2000);
		//*Assert the Basic Details wizard is selected
		Assert.assertEquals(getAttribute(sb.basic_detail_wizard, "aria-expanded"),"true");
		NewAssessmentName = "NewAssessment" + generateRandomNumber().trim();

		type(QP.Assess_name, NewAssessmentName);
		waitThread(2000);
		click(sq.Save_btn);
		waitThread(1000);
		waitFor(ba.toaster);
		//*Assert toaster "Saved successfully"
		Assert.assertEquals(getText(ba.toaster), "Saved successfully");
		click(ba.toasterclosebtn);
		waitThread(2000);


		//*Assert the question wizard is selected
		// To verify the question page details
		Assert.assertEquals(getAttribute(sq.questionwizard, "aria-selected"), "true");
		waitThread(2000);
		//*Assert new assessment name on the question page
		Assert.assertEquals(getText(pr.QPassessname_lbl).trim(), NewAssessmentName.trim());
		click(sq.Save_btn);
		waitThread(2000);

		//*Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(pr.peerrev_wizard, "aria-selected"), "true");
		//*Assert new assessment on the peer review page
		//Assert.assertEquals(getText(pr.PRassessmentname_lbl).trim(), NewAssessmentName.trim());
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + NewAssessmentName));

		click(sq.Save_btn);
		waitThread(3000);

		//*Assert the schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");
		//*Assert new assessment on the schedule page
		Assert.assertTrue(getText(sb.scheduleassesment_lbl).contains("Assessment Name: " + NewAssessmentName));
		waitThread(1000);
		///

		click(sq.time_txtbox);
		waitThread(2000);
		click(sq.pm_btn);
		waitThread(1000);


		// *Assert toaster "Please enter the Assessment Name"


		/*	waitFor(QP.toaster);
		if(QP.toaster.contains("Assessment Open date should not be past date and time"))
		{
		click(QP.toasterclosebtn);
		click(sq.open_assesment_date);
		cm.ClicktomorrowDate();
			click(sq.time_txtbox);
		waitThread(2000);
		click(sq.pm_btn);
		waitThread(1000);
		}*/


		// Click Save &Next button
		click(pr.savennext_button);
		waitFor(ba.toaster);
		//*Assert toaster "Saved successfully"
		Assert.assertEquals(getText(ba.toaster), "Saved successfully");
		click(ba.toasterclosebtn);
		waitThread(3000);
		// Assert the Summary wizard is selected
		softAssert6.assertEquals(getAttribute(sq.summary_wizard_high, "aria-expanded"), "true", "Assertion  failed");

		waitThread(1000);
		// Assert the label assessment name
		Assert.assertTrue(getText(sq.assesment_label).contains("Assessment Name:"));
		//click(sq.open_assesment_date);
		//cm.ClicktomorrowDate();

		Assert.assertTrue(getText(sbt.summaryassessmentname).contains("Assessment Name: " + NewAssessmentName));

		//Assert.assertEquals(getText(sq.new_assesment_name).trim(), NewAssessmentName.trim());

		///
		/*click(sq.Save_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"

		//Assert.assertEquals(getText(QP.toaster), "Assessment Open date should not be past date and time");
		Assert.assertEquals(getText(QP.toaster), "Assessment Open date should not be past date and time");
		click(QP.toasterclosebtn);
		waitThread(1000);
		//*Assert the summary wizard is selected

		softAssert6.assertEquals(getAttribute(sq.summary_wizard_high, "aria-expanded"), "true", "Assertion  failed");
		waitThread(1000);
		//*Assert new assessment on the summary page

		Assert.assertTrue(getText(sbt.summaryassessmentname).contains("Assessment Name: " + NewAssessmentName.trim()));*/

		softAssert6.assertAll();

	}
	/*To perform the save and exit functionality and take the assessment draft 
	 * and change the assessment name check newly updated name on the Question/Peer review/schedule/summary pages*/

	@Test(priority = 17)
	public void TCSPR0901217() {
		SoftAssert softAssert6 = new SoftAssert();
		waitThread(1000);
		//Click on save and exit button
		click(sq.save_exit_btn);
		//	*Assert toaster "Saved successfully"
		waitFor(ba.toaster);
		//*Assert toaster "Saved successfully"
		Assert.assertEquals(getText(ba.toaster), "Saved successfully");
		click(ba.toasterclosebtn);
		waitThread(3000);
		click(sq.draft_tab);
		waitThread(5000);
		//*Assert the draft tab is selected
		Assert.assertTrue(isElementPresent(sq.draft_tab), "Draft tab is selected");
		//*Assert the assessment on the draft page
		Assert.assertTrue(getText(sq.draft_assesment_name).contains(NewAssessmentName));

		click(sq.continue_editing_btn);
		waitThread(3000);
		//*Assert the Basic Details wizard is selected
		Assert.assertEquals(getAttribute(sb.basic_detail_wizard, "aria-expanded"),"true");
		New1AssessmentName = "New1Assessment" + generateRandomNumber().trim();

		type(QP.Assess_name, New1AssessmentName);
		waitThread(2000);
		click(sq.Save_btn);
		waitFor(ba.toaster);
		//*Assert toaster "Saved successfully"
		Assert.assertEquals(getText(ba.toaster), "Saved successfully");
		click(ba.toasterclosebtn);
		waitThread(4000);


		//*Assert the question wizard is selected
		// To verify the question page details
		Assert.assertEquals(getAttribute(sq.questionwizard, "aria-selected"), "true");
		waitThread(2000);

		//*Assert new assessment name on the question page
		Assert.assertEquals(getText(pr.QPassessname_lbl).trim(), New1AssessmentName.trim());
		click(sq.Save_btn);
		waitThread(4000);

		//*Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(pr.peerrev_wizard, "aria-selected"), "true");
		//*Assert new assessment on the peer review page
		//Assert.assertEquals(getText(pr.PRassessmentname_lbl).trim(), NewAssessmentName.trim());
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + New1AssessmentName));

		click(sq.Save_btn);
		waitThread(3000);

		//*Assert the schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");
		//*Assert new assessment on the schedule page
		Assert.assertTrue(getText(sb.scheduleassesment_lbl).contains("Assessment Name: " + New1AssessmentName));
		waitThread(1000);
		click(pr.savennext_button);
		waitThread(3000);
		// Assert the Summary wizard is selected
		softAssert6.assertEquals(getAttribute(sq.summary_wizard_high, "aria-expanded"), "true", "Assertion  failed");

		waitThread(1000);
		// Assert the label assessment name
		Assert.assertTrue(getText(sq.assesment_label).contains("Assessment Name:"));
		//click(sq.open_assesment_date);
		//cm.ClicktomorrowDate();
		waitThread(1000);
		softAssert6.assertAll();


	}
	//To perform discard functionality on the summary page
	@Test(priority = 18)
	public void TCSPR0901218() {
		SoftAssert softAssert7 = new SoftAssert();
		//click on discard button
		click(sq.discard_btn);

		//*Assert the confirmation popup visible
		Assert.assertTrue(isElementPresent(sq.discard_popup), "Discard confirmation popup Not visible");
		waitThread(2000);
		/*Assert the confirmation text "Are you certain you want to proceed with your action?
				We see that you have not made any changes to the information on this screen"*/
		Assert.assertEquals(getText(sq.confirmation_txt), "Are you certain you want to proceed with your action?\n"
				+ "We see that you have not made any changes to the information on this screen");
		waitThread(2000);
		//Click on cancel button
		click(sq.cancel_btn);
		waitThread(2000);
		Assert.assertFalse(isElementPresent(sq.discard_popup), "Discard confirmation popup visible");
		// Assert the Summary wizard is selected
		softAssert7.assertEquals(getAttribute(sq.summary_wizard_high, "aria-expanded"), "true", "Assertion  failed");
		click(sq.discard_btn);
		Assert.assertTrue(isElementPresent(sq.discard_popup), "Discard confirmation popup Not visible");
		// Assert the Summary wizard is selected
		click(sq.summary_pg_discard_popup_btn);
		waitThread(3000);
		//*Assert the draft tab is selected
		Assert.assertTrue(isElementPresent(sq.draft_tab), "Draft tab not selected");

		softAssert7.assertAll();

	}
	//To check Result Publishing Method functionalities in summary page
	@Test(priority = 19)
	public void TCSPR0901219() {
		//Click on Continue Edit button
		click(sq.continue_editing_btn);
		waitThread(3000);
		//*Assert the Basic Details wizard is selected
		Assert.assertEquals(getAttribute(sb.basic_detail_wizard, "aria-expanded"),"true");
		click(sq.Save_btn);
		waitThread(2000);


		//*Assert the question wizard is selected
		Assert.assertEquals(getAttribute(sq.questionwizard, "aria-selected"), "true"); 
		waitThread(2000);

		//Click on save &next button
		click(sq.Save_btn);
		waitThread(2000);

		//*Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(pr.peerrev_wizard, "aria-selected"), "true");

		click(sq.Save_btn);
		waitThread(3000);



		//*Assert the schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");
		//*Assert new assessment on the schedule page
		Assert.assertTrue(getText(sb.scheduleassesment_lbl).contains("Assessment Name: " +New1AssessmentName));
		waitThread(1000);
		click(pr.savennext_button);
		waitThread(2000);
		// Assert the Summary wizard is selected
		Assert.assertEquals(getAttribute(sq.summary_wizard_high, "aria-expanded"), "true");

		waitThread(1000);
		// Assert the label assessment name
		Assert.assertTrue(getText(sq.assesment_label).contains("Assessment Name: "));
		//*Assert new assessment on the summary page



		//click(sq.open_assesment_date);
		//cm.ClicktomorrowDate();
		waitThread(1000);
		//*Assert Result Publishing Method: Result will be published automatically label

		Assert.assertEquals(getText(sq.label_result_publish_method),
				"Result Publishing Method: \n" + "Result will be published automatically");
		//*Assert Edit button
		Assert.assertTrue(isElementPresent(sq.edit_btn_result), "Edit button not present");
		click(sq.edit_btn_result);
		waitThread(3000);
		//*Assert the schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");	

	}

	@Test(priority = 20)
	public void TCSPR0901220() {
		//Click on Test window open date and time
		click(sq.assessmentopendate_txtbx);
		waitThread(1000);
		
		Doubleclick(sq.calender_date_today);
		waitThread(2000);
		click(sq.assessmentopendate_txtbx);
		waitThread(1000);
		cm.ClicktomorrowDate();
		waitThread(3000);
		//click(sq.time_txtbox);
		//click(sq.pm_btn);

		click(pr.savennext_button);
		waitThread(3000);
		//*Assert changed date and time is reflect in the sumarry page

		assessmentopendate = getValue(sbp.assessmentopendate_txtbx);
		assessmentopentime = getValue(sbp.assessmentopentime_txtbx);

		Assert.assertEquals(getValue(sbp.assessmentopendate_txtbx), assessmentopendate);
		Assert.assertEquals(getValue(sbp.assessmentopentime_txtbx), assessmentopentime);



	}
	//To check Assessment Information for Students and Assessment Instructions for Students functionalities
	@Test(priority = 21)
	public void TCSPR0901221() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");
		//ScrollTo_Location(sq.assesment_info_location);
		//*Assert Assessment Information for Students  label is present
		Assert.assertEquals(getText(sq.assesment_info_location), "Assessment Information for Students");
		//*Assert Assessment Instructions for Students label is present
		Assert.assertEquals(getText(sq.assesment_instruction), "Assessment Instructions for Students");

		//Assessment instruction for Students  instruction box is present
		Assert.assertTrue(isElementPresent(sq.assesment_instruction_txtbx), "Students  instruction box not present");
		//Assessment Information for Students  instruction box is present
		Assert.assertTrue(isElementPresent(sq.assesment_information_txtbx), "Students  Information box not present");





	}
	//To check Assessment Edit functionalities of Assessment information and instruction fields
	@Test(priority = 22)
	public void TCSPR0901222() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		//driver.switchTo().defaultContent();
		waitThread(3000);
		//*Assert Edit button is present
		Assert.assertTrue(isElementPresent(sq.edit_btn2), "Edit button not visible");
		//Click on Edit button
		click(sq.edit_btn2);
		//*Assert the Basic Details wizard is selected
		Assert.assertEquals(getAttribute(sb.basic_detail_wizard, "aria-expanded"),"true");


		driver.switchTo().frame("assessmentInfo_ifr");
		//Type assessment information
		Assert.assertEquals(getAttribute(ba.editorplaceholder1, "aria-placeholder"),
				"Mention the portion/lessons/modules covered for this assessment", "Assertion  failed");
		//Type assessment information
		type(sq.assesment_box, "Informations");



		driver.switchTo().defaultContent();

		// To switch the frame
		driver.switchTo().frame("instructions_ifr");
		Assert.assertEquals(getAttribute(ba.editorplaceholder2, "aria-placeholder"),
				"Mention guidelines and instructions to be followed for this online assessment", "Assertion  failed");
		//Type assessment instruction
		type(sq.instruction_box, "Instructions");
		waitThread(2000);
		driver.switchTo().defaultContent();
		waitThread(1000);

		jse.executeScript("scroll(0, -250);");
		// Click Save &Next button
		click(sq.Save_btn);
		waitThread(1000);
		waitFor(ba.toaster);
		//*Assert toaster "Saved successfully"
		Assert.assertEquals(getText(ba.toaster), "Saved successfully");
		click(ba.toasterclosebtn);
		waitThread(2000);
	}

	//To check added instructions and informations are display on the summary page assessment box
	@Test(priority = 23)
	public void TCSPR0901223() {
		//*Assert the question wizard is selected
		Assert.assertEquals(getAttribute(sq.questionwizard, "aria-selected"), "true");
		waitThread(2000);

		click(sq.Save_btn);
		waitThread(3000);

		//*Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(pr.peerrev_wizard, "aria-selected"), "true");

		click(sq.Save_btn);
		waitThread(3000);



		//*Assert the schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");

		//*Assert new assessment on the schedule page
		Assert.assertTrue(getText(sb.scheduleassesment_lbl).contains("Assessment Name: " +New1AssessmentName));
		click(sq.time_txtbox);
		waitThread(2000);
		click(sq.pm_btn);
		waitThread(1000);
		waitThread(1000);
		click(pr.savennext_button);
		waitThread(2000);
		waitFor(ba.toaster);
		//*Assert toaster "Saved successfully"
		Assert.assertEquals(getText(ba.toaster), "Saved successfully");
		click(ba.toasterclosebtn);
		waitThread(3000);
		//Assert the Summary wizard is selected
		Assert.assertEquals(getAttribute(sq.summary_wizard_high, "aria-expanded"), "true");
		waitThread(1000);

		/*	ScrollTo_Location(sa.Assessinfo_frame);
		waitThread(2000);

		Assert.assertTrue(isElementPresent(sa.Assessinfo_frame), "Assessment Information for Students box not visible");
	
		


		Assert.assertTrue(isElementPresent(sa.Assessinstr_frame), "Assessment Instructions box not visible");
		
		ScrollTo_xy_position(0, 750);
		waitThread(2000);

		driver.switchTo().frame("assessment-info_ifr");
		waitThread(2000);

		// Assert the Assessment Information for Students Assessment Info+Random
		// number visible on the page
		
		Assert.assertTrue(getText(sq.assesment_info_txt).contains("Informations"));

		driver.switchTo().defaultContent();
		waitThread(2000);

		driver.switchTo().frame("assessment-instructions_ifr");
		waitThread(1000);

		// Assert the Assessment instructions Assessment Instruction+Random
		// number
		// visible on the page
		
		Assert.assertTrue(getText(sq.instruction_txt).contains("Instructions"));
		driver.switchTo().defaultContent();
		waitThread(2000);*/
		
		ScrollTo_Location(sa.Assessinfo_frame);
		waitThread(2000);

		Assert.assertTrue(isElementPresent(sa.Assessinfo_frame), "Assessment Information for Students box not visible");

		Assert.assertEquals(getAttribute(sa.Assessinfo_Box, "aria-disabled"), "true");

		Assert.assertTrue(isElementPresent(sa.Assessinstr_frame), "Assessment Instructions box not visible");

		Assert.assertEquals(getAttribute(sa.Assessinstr_Box, "aria-disabled"), "true");

	     cm.ScrollUp();
		//ScrollTo_xy_position(0, 750);
		waitThread(2000);

		driver.switchTo().frame("assessment-info_ifr");
		waitThread(2000);
		Assert.assertTrue(getText(sa.Assessinfo_lbl).contains("Informations"));
		driver.switchTo().defaultContent();
		waitThread(2000);

		driver.switchTo().frame("assessment-instructions_ifr");
		waitThread(1000);

		
		Assert.assertEquals(getText(sa.Assessinstruction_lbl), "Instructions");


		driver.switchTo().defaultContent();
		waitThread(2000);


		// Assert the label assessment name,
	/*	cm.ScrollEnd();
		
		
		waitThread(3000);

		driver.switchTo().frame("assessment-info_ifr");
		waitThread(2000);

		// Assert the newly added Assessment Information for Students text
	//	Assert.assertEquals(getText(sa.Assessinfo_lbl), Assessmentinfonew);
		Assert.assertTrue(getText(sq.assesment_info_txt).contains("Informations"));
		driver.switchTo().defaultContent();
		waitThread(2000);

		// Assert the newly added assessment instructions text
		driver.switchTo().frame("assessment-instructions_ifr");
		waitThread(1000);
		Assert.assertTrue(getText(sq.instruction_txt).contains("Instructions"));
		//	Assert.assertEquals(getText(sa.Assessinstruction_lbl), Assessmentinstructionnew);


		driver.switchTo().defaultContent();*/
	



		click(sq.discard_btn);
		Assert.assertTrue(isElementPresent(sq.discard_popup), "Discard confirmation popup Not visible");
		// Assert the Summary wizard is selected
		click(sq.summary_pg_discard_popup_btn);
		waitThread(3000);
		//*Assert the draft tab is selected
		Assert.assertTrue(isElementPresent(sq.draft_tab), "Draft tab not selected");


	}
	@Test(priority = 24)
	public void TCSPR0901224() {

		click(sq.course_tab);
		CourseName2 = "New Course Name" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID = (getText(cn.course_Id));

		// type-Course title
		type(cn.txbx_Coursetitle, CourseName2);

		// click on Add students button
		click(cn.btn_AddStudents);

		Emailstudent1 = "student3" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent2 = "student4" + generateRandomNumber().trim() + "@gmail.com";

		// type email
		type(cn.tab_textbox, Emailstudent1 + ",");
		driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
		type(cn.tab_textbox, Emailstudent2 + ",");

		// verify email present on the text box
		Assert.assertEquals(cn.emailvalue(0), Emailstudent1);

		Assert.assertEquals(cn.emailvalue(1), Emailstudent2);

		// click on add to list button
		click(cn.tab_btn_Addtolist);

		waitThread(2000);
		waitFor(cr.emailval_1);

		// verify the Email on the New Students to be invited to this class box
		Assert.assertEquals(getText(cr.emailval_1), Emailstudent1);
		Assert.assertEquals(getText(ps.emailval_2), Emailstudent2);

		// click on create course button
		click(cn.btn_Createcourse);

		waitThread(1000);
		waitFor(cn.toaster);

		// verify toaster-Course created successfully
		Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");

		waitThread(3000);

		// verify the course title
		Assert.assertEquals(getText(cn.course_title2).trim(), CourseName2.trim());


	}
	@Test(priority = 25)
	public void TCSPR0901225() {
		waitThread(3000);
		click(rs.header_dropdown);
		//Assert link Logout
		Assert.assertTrue(isElementPresent(rs.logout_link), "Logout link not visible");
		waitThread(3000);
		// logout functionality
		click(rs.logout_btn);
		waitThread(2000);
		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*To check that invited 
	 course request visible on first student's profile and accept course request
	-Read the student name*/


	@Test(priority = 26)
	public void TCSPR0901226() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent1, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get("http://192.168.7.108:8042/SPRClient/signup/" + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname = "Ashley";
		Studentlastname = "Albert";
		Studentname = Studentfirstname + " " + Studentlastname;

		// click first name
		click(sp.txtbxFirstN);
		waitThread(2000);
		// type first name
		type(sp.txtbxFirstN, Studentfirstname);
		waitThread(2000);
		// click last name
		click(sp.txtbxLastN);
		waitThread(2000);
		// type last name
		type(sp.txtbxLastN, Studentlastname);
		waitThread(2000);
		// click password
		click(sp.txtbxPass);
		waitThread(2000);
		// type password
		type(sp.txtbxPass, password);
		waitThread(2000);
		// click password
		click(sp.txtbxPassconf);
		waitThread(2000);
		// type password
		type(sp.txtbxPassconf, password);
		waitThread(2000);
		// click on privacy policy check box
		click(sp.chkbx_1);
		waitThread(2000);
		// click signup button
		click(sp.btn_signup);

		waitThread(5000);

		// verify heading label
		waitFor(rs.lbl_joincourse);
		Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");
		waitThread(5000);
		// verify course name visible
		Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not Present");

		// verify the the course name
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName2.trim());



	}
	/* To Accept course and perform logout functionality 
     on the student profile */
	@Test(priority = 27)
	public void TCSPR0901227() throws SQLException {
		// click on accept course button
		click(rs.btn_acceptcourse);

		// verify the confirmation popup visible
		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");

		// click on Yes button
		click(rs.popupbtn_Yes);

		// Toaster message
		waitFor(rs.toaster);
		Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");

		// verify the course name visible on the enrolled section
		waitFor(rs.enrolledcoursename);
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName2.trim());
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*  To check that invited 
        course request visible on fifth student's profile and accept course request
        -Read the student name*/
	@Test(priority = 28)
	public void TCSPR0901228() throws SQLException {
		studentinviteid = dc.InviteLink(Emailstudent2, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get("http://192.168.7.108:8042/SPRClient/signup/" + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname2 = "Ben";
		Studentlastname2 = "Max";
		Studentname2 = Studentfirstname2 + " " + Studentlastname2;

		// click first name
		click(sp.txtbxFirstN);
		waitThread(2000);
		// type first name
		type(sp.txtbxFirstN, Studentfirstname2);
		waitThread(2000);
		// click last name
		click(sp.txtbxLastN);
		waitThread(2000);
		// type last name
		type(sp.txtbxLastN, Studentlastname2);
		waitThread(2000);
		// click password
		click(sp.txtbxPass);
		waitThread(2000);		// type password
		type(sp.txtbxPass, password);
		waitThread(2000);
		// click password
		click(sp.txtbxPassconf);
		waitThread(2000);
		// type password
		type(sp.txtbxPassconf, password);
		waitThread(2000);
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
		Assert.assertEquals(getText(rs.course_name).trim(), CourseName2.trim());

	}
	/*To Accept course and perform logout functionality 
	on the student profile*/
	@Test(priority = 29)
	public void TCSPR0901229() {

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
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName2.trim());

		waitThread(3000);
		// perform logout functionality
		click(rs.header_dropdown);
		//Assert link Logout
		Assert.assertTrue(isElementPresent(rs.logout_link), "Logout link not visible");
		waitThread(3000);
		// logout functionality
		click(rs.logout_btn);
		waitThread(2000);
		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}
	/*To create an assessment and save it in draft*/
	@Test(priority = 30)
	public void TCSPR0901230() {
		SoftAssert softAssert1 = new SoftAssert();
		//Login as a teacher
		rs.login_Teacher(Emailteacher, password);

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
		waitFor(ba.ddcoursename2);

		softAssert1.assertEquals(getText(ba.ddcoursename2), CourseName2.trim(),
				"course name not visible on the dropdown");

		click(ba.ddcoursename2);
		waitThread(3000);
		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentName2 = "Test" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentName2);

		waitThread(3000);

		// Click Save &Exit button
		click(sq.save_exit_btn);

		waitThread(1000);
		waitFor(ba.toaster);
		//*Assert toaster "Saved successfully"
		Assert.assertEquals(getText(ba.toaster), "Saved successfully");
		click(ba.toasterclosebtn);
		waitThread(2000);
		//*Assert the current assessment tab is selected
		Assert.assertTrue(isElementPresent(sq.current_tab), "Logout link not visible");




	}
	/*To check that the changed course name visibled on the Question/Peer review/Schedul/Summary pages*/
	@Test(priority = 31)
	public void TCSPR0901231() {
		click(sq.draft_tab);
		waitThread(3000);
		//*Assert the draft tab is selected
		Assert.assertTrue(isElementPresent(sq.draft_tab), "Draft tab is not selected");
		//*Assert the assessment on the draft page
		Assert.assertTrue(getText(sq.draft_assesment_name).contains(AssessmentName2));
		//Click on continue edit button
		click(sq.continue_editing_btn);
		waitThread(5000);
		//*Assert the Basic Details wizard is selected
		Assert.assertEquals(getAttribute(sb.basic_detail_wizard, "aria-expanded"),"true");
		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename2);
		//*Assert the new course name on the page
		Assert.assertEquals(getText(ba.ddcoursename2), CourseName2.trim(),
				"course name not visible on the dropdown");
		//Select new course name
		click(ba.ddcoursename2);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(3000);
		//*Assert the Question wizard is checked
		Assert.assertEquals(getAttribute(sq.questionwizard, "aria-selected"), "true");
		//*Assert new course name on the question page
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID + ", " + CourseName2.trim());



	}
	//To fill details on the Question page
	@Test(priority = 32)
	public void TCSPR0901232() {
		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question1");
		
		//Assert.assertEquals(getValue(QP.Quest_box), "Question1");


		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);

		//Click on standard rubric radio button

		click(QP.std_rad);

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "Rubric1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "10");

		waitThread(4000);

		Assert.assertEquals(getAttribute(QP.max_scorbx, "value"), "10");

		// Click + button
		click(mq.add_quest_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);
		waitThread(3000);
		// Assert the label "2.Questions"
		Assert.assertEquals(getText(QP.question1), "2." + "\nQuestion");


	}

	@Test(priority = 33)
	public void TCSPR0901233() {

		waitThread(1000);
		// Enter Question2
		driver.switchTo().frame("question_ifr");
		type(QP.Quest_box, "Question2");
		driver.switchTo().defaultContent();

		// Page scroll down
		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);


		// Assert the Label Add Rubric
		Assert.assertEquals(getText(QP.Add_rublabel), "Add Rubric");
		//Click on Clickable Rubric

		click(QP.click_radio);
		//Click Add column button

		click(QP.add_column);

		// Enter Criteria
		type(ck.crit1_bx, "CR2");

		// Enter score for column1
		type(ck.scre_col1, "2");

		waitThread(2000);
		// Enter condition
		driver.switchTo().frame("editorFieldRubric_00_ifr");
		waitThread(2000);
		type(ck.enter_con, "Good");
		driver.switchTo().defaultContent();
		

		// page scroll up
		ck.scrolup();

		waitThread(7000);
		// Click + button
		click(mq.add_quest_btn);
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully", "Assertion failed");

		click(QP.toasterclosebtn);

		waitThread(4000);
		// Assert the label "3.Questions"
		Assert.assertEquals(getText(QP.question1), "3." + "\nQuestion");

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		waitThread(2000);
		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question3");

		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);
		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "Rubric3");
		
		//Assert.assertEquals(getValue(QP.std_rub_bx), "Rubric3");
		

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "5");

		waitThread(5000);
		// Click + button
		click(mq.add_quest_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 3 Saved successfully", "Assertion failed");
		click(QP.toasterclosebtn);





	}
	//To add mutiple questions with clickable rubric & Standard rubrics
	@Test(priority = 34)
	public void TCSPR0901234() {
		waitThread(4000);
		// Assert the label "4.Questions"
		Assert.assertEquals(getText(QP.question1), "4." + "\nQuestion");
		// Enter Question4
		driver.switchTo().frame("question_ifr");
		type(QP.Quest_box, "Question4");
		driver.switchTo().defaultContent();

		// Page scroll down
		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);


		// Assert the Label Add Rubric
		Assert.assertEquals(getText(QP.Add_rublabel), "Add Rubric");
		//Click on Clickable Rubric

		click(QP.click_radio);
		//Click Add column button

		click(QP.add_column);

		// Enter Criteria
		type(ck.crit1_bx, "C4");

		// Enter score for column1
		type(ck.scre_col1, "10");

		// Enter condition
		driver.switchTo().frame("editorFieldRubric_00_ifr");
		waitThread(2000);
		type(ck.enter_con, "Good");
		driver.switchTo().defaultContent();

		// page scroll up
		ck.scrolup();

		waitThread(7000);
		// Click + button
		click(mq.add_quest_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 4 Saved successfully", "Assertion  failed");
		click(QP.toasterclosebtn);
		// Assert the label "5.Questions"
		waitThread(2000);
		Assert.assertEquals(getText(QP.question1), "5." + "\nQuestion");

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		click(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question5");

		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "Rubric5");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "10");

		waitThread(7000);
		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 5 Saved successfully", "Assertion  failed");
		waitThread(1000);
		click(QP.toasterclosebtn);
		waitThread(2000);
	}
	//To perform Save&Next and to verify the details on the peer review page
	@Test(priority = 35)
	public void TCSPR0901235() {
		// Assert the Max score possible
		Assert.assertEquals(getText(QP.max_scoreposs_value), "37");

		// Assert the Max score field
		Assert.assertEquals(getValue(QP.max_scorbx), "10");


		waitThread(4000);
		// Click Save &Next button
		click(QP.savenext_btn);
		waitThread(3000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

		waitThread(4000);



	}
	//To verify the details on the peer review page
	@Test(priority = 36)
	public void TCSPR0901236() {
		//Enter Peer Review Reward %
		click(sq.peer_reward_scorebx);
		waitThread(3000);
		type(sq.peer_reward_scorebx, "100");
		//*Assert the student count
		waitThread(4000);
		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl), "Total Students : 2");

	}

	//To perform the save and next functionaity from peer review page and verify the schedule page details
	@Test(priority = 37)
	public void TCSPR0901237() {
		//*Assert the schedule wizard is selected
		click(pr.savennext_button);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully", "Assertion  failed");
		click(QP.toasterclosebtn);

		waitThread(3000);

		// Assert the schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true", "Assertion  failed");

		// *Assert the Assessment name,Course name and course code
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseName2.trim()));
		Assert.assertTrue(getText(sb.scheduleassesment_lbl).contains("Assessment Name: " + AssessmentName2));
		waitThread(1000);

	}
	//To Perform Save&Next and to verify the details on the Summary page
	@Test(priority = 38)
	public void TCSPR0901238() {

		click(pr.savennext_button);
		waitThread(4000);

		// Assert the Summary wizard is selected
		Assert.assertEquals(getAttribute(sq.summary_wizard_high, "aria-expanded"), "true", "Assertion  failed");


		//Assert the assessment name
		Assert.assertTrue(getText(sbt.summaryassessmentname).contains("Assessment Name: " + AssessmentName2));

	}
	//To check the Questions section on the Summary page.
	@Test(priority = 39)
	public void TCSPR0901239() {
		SoftAssert SoftAssert1 = new SoftAssert();
		waitThread(2000);
		//*Assert the text "Questions Summary 
		Assert.assertEquals(getText(sq.Summary_quest), "Questions Summary");

		// Assert the Total no: of Questions
		Assert.assertEquals(getText(sq.total_questcount), "5");

		// Assert the Maximum score possible
		Assert.assertEquals(getText(sq.max_scorepos_count), "74");
		waitThread(2000);
		//*Assert Total Test Points 
		Assert.assertEquals(getText(sq.total_test_points),"37");
		waitThread(2000);

		//*Assert Total Peer Review Points
		Assert.assertEquals(getText(sq.total_peerview_score), "37");
		waitThread(2000);
		//*Assert the Questions visible on the page is same as Questions added on page
		Assert.assertEquals(getText(sq.quest1), "Question1");
		Assert.assertEquals(getText(sq.quest2), "Question2");
		Assert.assertEquals(getText(sq.quest3), "Question3");
		Assert.assertEquals(getText(sq.quest4), "Question4");
		Assert.assertEquals(getText(sq.quest5), "Question5");

		// Tootips of question visible
		MouseHover(sq.quest1);
		Assert.assertEquals(getAttribute(sq.quest1, "tooltipposition"), "top");
		MouseHover(sq.quest2);
		Assert.assertEquals(getAttribute(sq.quest2, "tooltipposition"), "top");
		MouseHover(sq.quest3);
		Assert.assertEquals(getAttribute(sq.quest3, "tooltipposition"), "top");
		MouseHover(sq.quest4);
		Assert.assertEquals(getAttribute(sq.quest4, "tooltipposition"), "top");
		MouseHover(sq.quest5);
		Assert.assertEquals(getAttribute(sq.quest5, "tooltipposition"), "top");

		//*Assert the Score in Question page is same as questions page
		waitThread(3000);

		SoftAssert1.assertEquals(getValue(sq.markquest1), "10", "Assertion failed");
		SoftAssert1.assertEquals(getValue(sq.markquest2), "2", "Assertion failed");
		SoftAssert1.assertEquals(getValue(sq.markquest3), "5", "Assertion failed");
		SoftAssert1.assertEquals(getValue(sq.markquest4), "10", "Assertion failed");
		waitThread(1000);
		SoftAssert1.assertEquals(getValue(sq.markquest5), "10", "Assertion failed");
		waitThread(3000);

		//*Assert the Grand total is same as Maximum score possible
		SoftAssert1.assertEquals(getText(sq.grandtotal_count), "37", "Assertion failed");
		SoftAssert1.assertEquals(getText(sq.max_scorepos_count), "74", "Assertion failed");
		SoftAssert1.assertAll();


	}
	/*To perform Edit Questions functionality on the Summary page.
	-To check the Edit popup window visibility*/
	@Test(priority = 40)
	public void TCSPR0901240() {
		SoftAssert softAssert2 = new SoftAssert();
		// Assert the Edit button of first question is visible
		Assert.assertTrue(isElementPresent(sq.edit_quest1), "edit question button not present");

		// Assert the tooltip of edit button visible
		Assert.assertEquals(getAttribute(sq.edit_quest1, "ptooltip"), "Edit");

		waitThread(2000);
		// click Edit button of first question
		click(sq.edit_quest1);
		waitThread(4000);
		// Assert the Edit Question popup visible
		Assert.assertTrue(isDisplayed(sq.editpopup), "Edit pop up not visible");

		// Assert the text "Edit Question"
		Assert.assertEquals(getText(sq.editquest_label), "Edit Question");

		// Assert the Text "1.Question"
		softAssert2.assertEquals(getText(sq.quest1_label), "1.Question", "assertion failed");
		// Enter new Question content
		driver.switchTo().frame("question_ifr");
		click(QP.Quest_box);
		driver.findElements(By.xpath("//body[@data-id='question']")).clear();
		type(QP.Quest_box, "Content");
		driver.switchTo().defaultContent();
		// Assert save button on edit popup
		Assert.assertTrue(isElementPresent(sq.save_btn_editpop), "Save button is not present");

		waitThread(1000);
		// click save button
		click(sq.save_btn_editpop);

		waitFor(QP.toaster);
		// Assert the toaster "Question updated successfully"
		softAssert2.assertEquals(getText(QP.toaster), "Question updated successfully", "Assertion failed");
		click(QP.toasterclosebtn);
		waitThread(3000);
		// Assert the Summary wizard is selected
		Assert.assertEquals(getAttribute(sq.summary_wizard_high, "aria-selected"), "true");

		// Assert the edited question content visible on summary page
		Assert.assertEquals(getText(sq.quest1), "Content");
		softAssert2.assertAll();


	}
	/*To perform Edit Rubrics functionality on the Summary page.
	-To check the Edit popup window visibility*/
	@Test(priority = 41)
	public void TCSPR0901241() {
		SoftAssert softAssert3 = new SoftAssert();
		// Assert the tooltip of Standard rubric content of first question visible
		MouseHover(sq.rubquest1);
		Assert.assertEquals(getAttribute(sq.rubquest1, "tooltipposition"), "top");

		waitThread(1000);
		// click Edit button of first question
		click(sq.edit_quest1);
		waitThread(1000);

		// Page scroll down
		QP.Scroll_DowntoEnd();
		//*Assert the Standard rubric radio button is checked
		Assert.assertTrue(isElementPresent(QP.std_rubcheck), "Standard rubric radio button is not checked");
		// Enter the new content to standard rubric box
		driver.switchTo().frame("rubrics_ifr");
		driver.findElements(By.xpath("//body[@data-id='rubrics']")).clear();
		type(sq.edit_pop_std_rubox, "rubric content");

		driver.switchTo().defaultContent();
		waitThread(2000);
		// click save button
		click(sq.save_btn_editpop);

		waitFor(QP.toaster);
		// Assert the toaster "Question updated successfully"
		softAssert3.assertEquals(getText(QP.toaster), "Question updated successfully", "Assertion failed");
		click(QP.toasterclosebtn);

		waitThread(2000);
		// Assert the tooltip of new added Standard rubric content visible
		MouseHover(sq.rubquest1);
		Assert.assertEquals(getAttribute(sq.rubquest1, "tooltipposition"), "top");
		softAssert3.assertAll();

	}
	//To perform Score adjustments for Standard rubric
	@Test(priority = 42)
	public void TCSPR0901242() {
		SoftAssert softAssert4 = new SoftAssert();
		//*Assert the score added for the first question in the question page is visible in the score box
		waitThread(3000);
		Assert.assertTrue(isElementPresent(sq.markquest1), "Standard rubric Score of first question not visible");
		waitThread(3000);
		softAssert4.assertEquals(getValue(sq.markquest1), "10", "Assertion failed");
		//Adjust the score of first question
		click(sq.markquest1);
		driver.findElement(By.xpath("//*[@id='tstQstnTable']//div//tr[1]/td[6]/div/input")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id='tstQstnTable']//div//tr[1]/td[6]/div/input")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id='tstQstnTable']//div//tr[1]/td[6]/div/input")).sendKeys("12");
		waitThread(3000);

		//Click Grand Total Questions label
		//Assert.assertTrue(getText(sq.grand_total).contains("Grand Total:"));


		click(sq.max_scorepos_count);

		waitFor(QP.toaster);

		// Assert toaster "Score updated successfully"
		softAssert4.assertEquals(getText(QP.toaster), "Score updated successfully", "Assertion failed");
		click(QP.toasterclosebtn);
		waitThread(2000);
		// Assert the score box with new score value
		softAssert4.assertEquals(getValue(sq.markquest1), "12", "Assertion failed");

		waitThread(2000);
		//*Assert the Grand total& the max score possible same
		softAssert4.assertEquals(getText(sq.grandtotal_count), "39", "Assertion failed");
		softAssert4.assertEquals(getText(sq.max_scorepos_count), "78", "Assertion failed");

		softAssert4.assertAll();


	}
	//To check the Score adjustments for Clickable rubric is possible
	@Test(priority = 43)
	public void TCSPR0901243() {
		SoftAssert softAssert5 = new SoftAssert();
		// Assert the tooltip of Question 2 as clickable rubric
		MouseHover(sq.rubquest2);
		Assert.assertEquals(getAttribute(sq.rubquest2, "tooltipposition"), "top");

		waitThread(4000);
		//*Assert the score box of question visible
		Assert.assertTrue(isElementPresent(sq.markquest2), "Standard rubric Score of first question not visible");
		softAssert5.assertEquals(getValue(sq.markquest2), "2", "Assertion failed");
		//*Assert no score adjustment possible for clickable rubric scores
		softAssert5.assertFalse(isEnabled(sq.markquest2), "Clickable rubric score box is enabled");
		//*Assert the Grand total & Max score possible same
		softAssert5.assertEquals(getText(sq.grandtotal_count), "39", "Assertion failed");
		softAssert5.assertEquals(getText(sq.max_scorepos_count), "78");
		softAssert5.assertAll();



	}
	public String ImageURL = "http://192.168.7.108/SPRAPIQA/Files/Assessment/619dbf63c0429e0d15787b61/73b15af5-4d23-4d99-9690-ae509df4fc07.png";
	//To check the image upload functionality in the Edit question popup
	@Test(priority = 44)
	public void TCSPR0901244() {
		SoftAssert softAssert6 = new SoftAssert();
		waitThread(2000);
		// Click on Edit button of Question 3
		click(sq.edit_quest3);

		waitThread(4000);
		// Assert the Text "3.Question"
		softAssert6.assertEquals(getText(sq.quest1_label), "3.Question", "Assertion failed");
		// Assert the already added question is visible on the box
		driver.switchTo().frame("question_ifr");
		softAssert6.assertEquals(getText(QP.Quest_box), "Question3", "Assertion failed");
		click(QP.Quest_box);
		//Clear the contents of question 3
		driver.findElement(By.xpath("//body[@data-id='question']")).clear();
		driver.switchTo().defaultContent();
		//Click image button on the editor
		click(sq.imag_btn_editpop);

		// Assert the insert/edit image popup visible
		Assert.assertTrue(isDisplayed(be.imageuploadheaderlbl), "Insert image popup not present");

		// Type a url
		waitThread(2000);
		driver.findElement(
				By.cssSelector("div[id*=dialog-describe_] > div > div > div > div:nth-child(1) > div > div>input"))
		.sendKeys(ImageURL);
		waitThread(5000);
		// Click Save button in the image popup
		click(be.imageuploadsavebtn);
		waitThread(2000);

		// *Assert the added image visible on the edit question box
		driver.switchTo().frame("question_ifr");
		Assert.assertTrue(isElementPresent(be.instrimage), "Uploaded image not visible");
		click(QP.Quest_box);
		driver.switchTo().defaultContent();

		waitThread(2000);

		// Click Save button in edit question popup
		click(sq.save_btn_editpop);
		waitFor(QP.toaster);
		// Assert the toaster "Question updated successfully"
		softAssert6.assertEquals(getText(QP.toaster), "Question updated successfully", "Assertion failed");
		click(QP.toasterclosebtn);

		waitThread(2000);

		// Assert the text " Image/Video/Equation" in the question 3 row
		Assert.assertEquals(getText(sq.quest3), "Image/Video/Equation");

		softAssert6.assertAll();



	}
	public String VideoURL = "http://192.168.7.108/SPRAPIQA/Files/Assessment/619dbeddc0429e0d15787b5f/86d56375-b977-4156-a2e5-10a5c9f1812d.mp4";

	//To check the video upload functionality in the Edit question popup
	@Test(priority = 45)
	public void TCSPR0901245() {


		SoftAssert softAssert7 = new SoftAssert();
		waitThread(2000);
		// Click on Edit button of Question 4
		click(sq.edit_quest4);

		waitThread(5000);
		// Assert the Text "4.Question"
		Assert.assertEquals(getText(sq.quest1_label), "4.Question");

		// Assert the already added question is visible on the box
		driver.switchTo().frame("question_ifr");
		softAssert7.assertEquals(getText(QP.Quest_box), "Question4");
		waitThread(1000);
		//Clear the contents of question 4
		click(QP.Quest_box);
		driver.findElement(By.xpath("//body[@data-id='question']")).clear();
		driver.switchTo().defaultContent();

		// Click video button on the editor
		click(sq.video_btn_editpop);

		// Assert the Insert/Edit Media popup visible
		Assert.assertTrue(isDisplayed(be.imageuploadheaderlbl), "Insert media popup not present");

		// Type a url
		driver.findElement(
				By.cssSelector("div[id*=dialog-describe_] > div > div > div > div:nth-child(1) > div > div>input"))
		.sendKeys(VideoURL);
		waitThread(7000);

		// click on save button
		click(be.videouploadsavebtn);
		waitThread(2000);
		// Assert the added video visible on the edit question box
		driver.switchTo().frame("question_ifr");
		Assert.assertTrue(isElementPresent(sq.quest_edit_video), "Uploaded video not visible");
		click(QP.Quest_box);
		driver.switchTo().defaultContent();
		waitThread(2000);
		// Click Save button in edit question popup
		click(sq.save_btn_editpop);

		waitFor(QP.toaster);
		// Assert the toaster "Question updated successfully"
		softAssert7.assertEquals(getText(QP.toaster), "Question updated successfully", "Assertion failed");
		click(QP.toasterclosebtn);

		waitThread(3000);

		// Assert the text " Image/Video/Equation" in the question 4 row
		softAssert7.assertEquals(getText(sq.quest4), "Image/Video/Equation...");

		softAssert7.assertAll();
	}
	//To check the Maximum score validation toaster in the Standard Rubric score box
	@Test(priority = 46)
	public void TCSPR0901246() {
		SoftAssert softAssert8 = new SoftAssert();
		// Assert the score of 5th question is same as added in questions page
		softAssert8.assertEquals(getValue(sq.markquest5), "10", "Assertion failed");
		waitThread(5000);
		// Clear the Score box of 5th question
		driver.findElement(By.xpath("//*[@id='tstQstnTable']//div//tr[5]/td[6]/div/input")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id='tstQstnTable']//div//tr[5]/td[6]/div/input")).sendKeys(Keys.BACK_SPACE);
		// Enter a score
		driver.findElement(By.xpath("//*[@id='tstQstnTable']//div//tr[5]/td[6]/div/input")).sendKeys("500");
		waitThread(3000);
		click(sq.max_scorepos_count);
		waitFor(QP.toaster);
		// Assert toaster "Score updated successfully"
		softAssert8.assertEquals(getText(QP.toaster), "Score updated successfully", "Assertion failed");
		click(QP.toasterclosebtn);

		waitThread(2000);
		// Clear the Score box of 5th question
		driver.findElement(By.xpath("//*[@id='tstQstnTable']//div//tr[5]/td[6]/div/input")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id='tstQstnTable']//div//tr[5]/td[6]/div/input")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id='tstQstnTable']//div//tr[5]/td[6]/div/input")).sendKeys(Keys.BACK_SPACE);

		// Enter a score
		driver.findElement(By.xpath("//*[@id='tstQstnTable']//div//tr[5]/td[6]/div/input")).sendKeys("600");
		waitThread(3000);
		click(sq.max_scorepos_count);
		waitFor(QP.toaster);

		// Assert toaster "Score should be less than or equal to 500"
		softAssert8.assertEquals(getText(QP.toaster), "Score should be less than or equal to 500", "Assertion failed");
		click(QP.toasterclosebtn);

		waitThread(2000);
		// Assert the Score box with already added score
		Assert.assertEquals(getValue(sq.markquest5), "500", "Assertion failed");

		//Click on Edit button
		click(sq.assesment_edit_btn);
		waitThread(2000);
		//*Assert the Basic Details wizard is selected
		softAssert8.assertEquals(getAttribute(sb.basic_detail_wizard, "aria-expanded"),"true", "Assertion  failed");
		click(sq.Save_btn);
		waitThread(2000);


		//*Assert the question wizard is selected
		Assert.assertEquals(getAttribute(sq.questionwizard, "aria-selected"), "true"); 
		waitThread(2000);


		softAssert8.assertAll();

	}
	//To check whether modifications on question page updating on Summary page
	@Test(priority = 47)
	public void TCSPR0901247() {
		SoftAssert softAssert9 = new SoftAssert();
		waitThread(3000);

		// Assert the label "5.Question"
		Assert.assertEquals(getText(QP.question1), "5." + "\nQuestion");
		click(sq.max_score);
		waitThread(2000);

		// Click on +button
		click(mq.add_quest_btn);
		waitThread(3000);
		// Enter question 6
		driver.switchTo().frame("question_ifr");
		type(QP.Quest_box, "Question6");
		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(6000);


		//Click Standard rubric radio button
		click(QP.std_rad);

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "Standard rubric radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "Rubric contents 2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Click Sample Answer
		click(QP.sample_ans_btn);

		// Enter Sample Answer contents
		driver.switchTo().frame("sampleAnswer_ifr");
		type(QP.sample_ansbx, "Sample Answer contents");
		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");
		// Enter Max score
		type(QP.max_scorbx, "10");

		waitThread(3000);

		Assert.assertEquals(getAttribute(QP.max_scorbx, "value"), "10");

		waitThread(1000);
		// Click Save& Next button
		click(QP.savenext_btn);



		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 6 Saved successfully");
		click(QP.toasterclosebtn);
		// Click Save& Next button
		click(QP.savenext_btn);
		waitThread(2000);

		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");
        click(pr.reward_percentage);

		waitThread(2000);
		
		// Click Save &Next button
		click(pr.savennext_button);
		waitThread(4000);

		// Assert the schedule wizard is selected
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");
		waitThread(2000);

		click(sq.time_txtbox);
		waitThread(2000);
		click(sq.pm_btn);
		waitThread(1000);

		// Click Save &Next button
		click(pr.savennext_button);

		waitThread(4000);

		// Assert the Summary wizard is selected
		Assert.assertEquals(getAttribute(sq.summary_wizard_high, "aria-selected"), "true");

		// Assert the 6th added question visible on the page
		Assert.assertTrue(isDisplayed(sq.quest6), "Question 6 not present");
		Assert.assertEquals(getText(sq.quest6), "Question6");

		// Assert the standard rubric tooltip &sample answer tooltip visible
		MouseHover(sq.rubquest6);
		waitThread(2000);
		Assert.assertEquals(getAttribute(sq.rubquest6, "tooltipposition"), "top");

		MouseHover(sq.samquest6);
		waitThread(2000);
		Assert.assertEquals(getAttribute(sq.samquest6, "tooltipposition"), "top");

		// Assert the marks of added question
		Assert.assertEquals(getValue(sq.markquest6), "10");

		// Assert the Grand total and max score possible are same
		Assert.assertEquals(getText(sq.max_mark), "539.0");
		waitThread(2000);
		Assert.assertEquals(getValue(sq.grandtotal_count), "539");
		// Assert the total no:of questions
		Assert.assertEquals(getText(sq.total_questcount), "6");


		softAssert9.assertAll();

	}

	@Test(priority = 48)
	public void TCSPR0901248() {
		waitThread(4000);
		// click Edit button of Third question
		click(sq.edit_quest3);

		waitThread(3000);

		// Assert the Text "3.Question"
		Assert.assertEquals(getText(sq.quest1_label), "3.Question");

		waitThread(2000);
		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(3000);

		// Assert the Standard rubric radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "Standard rubric radio button is not selected");

		// Clear the rubric data
		driver.switchTo().frame("rubrics_ifr");
		Doubleclick("//body[@data-id='rubrics']");
		waitThread(2000);
		driver.findElements(By.xpath("//body[@data-id='rubrics']")).clear();
		waitThread(2000);
		driver.switchTo().defaultContent();

		// Click image button on the editor
		click(sq.imag_btn_stdrub);
		waitThread(2000);
		// Assert the insert/edit image popup visible
		Assert.assertTrue(isDisplayed(be.imageuploadheaderlbl), "Insert image popup not present");

		// Type a url
		waitThread(2000);
		driver.findElement(
				By.cssSelector("div[id*=dialog-describe_] > div > div > div > div:nth-child(1) > div > div>input"))
		.sendKeys(ImageURL);
		waitThread(5000);
		// click on save button
		click(be.imageuploadsavebtn);
		waitThread(2000);
		// Assert the added image visible on the page
		driver.switchTo().frame("rubrics_ifr");
		Assert.assertTrue(isElementPresent(be.instrimage), "Uploaded image not visible");
		click(sq.edit_pop_std_rubox);
		driver.switchTo().defaultContent();

		waitThread(5000);

		// Click Save button in edit question popup
		click(sq.save_btn_editpop);
		waitFor(QP.toaster);
		// Assert the toaster "Question updated successfully"
		Assert.assertEquals(getText(QP.toaster), "Question updated successfully");
		click(QP.toasterclosebtn);

		waitThread(4000);

		// Assert the tooltip " Image/Video/Equation" in the rubric part of Question3
		MouseHover(sq.rubquest3);
		waitThread(2000);
		Assert.assertEquals(getAttribute(sq.rubquest3, "tooltipposition"), "top");



	}




	/*
	 * To upload video to the Standard rubric edit box
	 */
	@Test(priority = 49)
	public void TCSPR0901249() {
		waitThread(2000);

		SoftAssert softAssert10 = new SoftAssert();
		// Click on Edit button of Question 5
		click(sq.edit_quest5);

		waitThread(5000);

		// Assert the Text "5.Question"
		softAssert10.assertEquals(getText(sq.quest1_label), "5.Question", "assertion failed");

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(3000);
		// Assert the Standard rubric radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "Standard rubric radio button is not selected");

		// Clear the rubric data
		driver.switchTo().frame("rubrics_ifr");
		Doubleclick("//body[@data-id='rubrics']");
		driver.findElements(By.xpath("//body[@data-id='rubrics']")).clear();
		waitThread(2000);
		driver.switchTo().defaultContent();

		// Click video button on the editor
		click(sq.video_btn_stdrub);

		// Assert the Insert/Edit Media popup visible
		Assert.assertTrue(isDisplayed(be.imageuploadheaderlbl), "Insert media popup not present");

		// Type a url
		driver.findElement(
				By.cssSelector("div[id*=dialog-describe_] > div > div > div > div:nth-child(1) > div > div>input"))
		.sendKeys(VideoURL);
		waitThread(7000);

		// click on save button
		click(be.videouploadsavebtn);
		waitThread(2000);

		// Assert the added video visible on the page
		driver.switchTo().frame("rubrics_ifr");
		Assert.assertTrue(isElementPresent(be.infovideo1), "Uploaded video not visible");
		click(sq.edit_pop_std_rubox);
		driver.switchTo().defaultContent();

		waitThread(5000);

		// Click Save button in edit question popup
		click(sq.save_btn_editpop);

		waitFor(QP.toaster);
		// Assert the toaster "Question updated successfully"
		Assert.assertEquals(getText(QP.toaster), "Question updated successfully");
		click(QP.toasterclosebtn);

		waitThread(3000);

		// Assert the tooltip " Image/Video/Equation" in the rubric part of Question5
		MouseHover(sq.rubquest5);
		Assert.assertEquals(getAttribute(sq.rubquest5, "tooltipposition"), "top");

		softAssert10.assertAll();
	}

	/*
	 * To upload equations to the question & Standard rubric edit box
	 */
	@Test(priority = 50)
	public void TCSPR0901250() {

		SoftAssert softAssert11 = new SoftAssert();

		waitThread(2000);
		// Click on Edit button of Question 6
		click(sq.edit_quest6);

		waitThread(5000);

		// Assert the Text "6.Question"
		softAssert11.assertEquals(getText(sq.quest1_label), "6.Question", "assertion failed");

		// Assert the added question content visible on question box
		driver.switchTo().frame("question_ifr");
		Assert.assertEquals(getText(QP.Quest_box), "Question6");

		// Clear the Question data
		Doubleclick("//body[@data-id='question']");
		driver.findElements(By.xpath("//body[@data-id='question']")).clear();
		driver.switchTo().defaultContent();

		// Click on the Mathtype button
		click(QE.math_editor);

		// Assert the Mathtype popup visible
		// To add equation to math editor
		JavaScriptclick(be.infofractionbtn);
		waitThread(2000);

		Assert.assertTrue(isDisplayed(be.infofractionbody), "Fraction body not visible");
		driver.findElement(By.cssSelector(be.infomathtextbx)).sendKeys("10");
		waitThread(2000);

		driver.findElement(By.cssSelector(be.infomathtextbx)).sendKeys(Keys.ARROW_DOWN);
		waitThread(2000);

		driver.findElement(By.cssSelector(be.infomathtextbx)).sendKeys("4");
		waitThread(2000);

		driver.findElement(By.cssSelector(be.infomathtextbx)).sendKeys(Keys.ARROW_RIGHT);
		JavaScriptclick(be.infosquareroutebtn);

		Assert.assertTrue(isDisplayed(be.infofractionbody), "Fraction body not visible");
		driver.findElement(By.cssSelector(be.infomathtextbx)).sendKeys("5");
		waitThread(2000);

		driver.findElement(By.cssSelector(be.infomathtextbx)).sendKeys(Keys.ARROW_RIGHT);
		waitThread(2000);

		Assert.assertTrue(isDisplayed(be.infofractionbody), "Fraction body not visible");
		waitThread(2000);
		Doubleclick(be.infomathinsertbtn);
		waitThread(2000);

		Assert.assertFalse(isDisplayed(be.infomathpopup), "MathType Popup  visible");
		waitThread(4000);

		// Switch to Question frame and verify the uploaded equation
		driver.switchTo().frame("question_ifr");
		waitThread(5000);
		Assert.assertTrue(isElementPresent(sq.equationeditor_quest), "Uploaded equation not visible");
		driver.switchTo().defaultContent();

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(3000);
		// Assert the Standard rubric radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "Standard rubric radio button is not selected");

		waitThread(3000);
		// Clear the rubric data
		driver.switchTo().frame("rubrics_ifr");
		Doubleclick("//body[@data-id='rubrics']");
		driver.findElements(By.xpath("//body[@data-id='rubrics']")).clear();
		waitThread(2000);
		driver.switchTo().defaultContent();

		waitThread(2000);
		// Click on the Mathtype button
		click(QE.rubric_math_edit);

		// Assert the Mathtype popup visible
		// To add equation to math editor
		JavaScriptclick(be.rubricfraction_btn);
		waitThread(2000);

		Assert.assertTrue(isDisplayed(be.rubricfraction_btn), "Fraction body not visible");
		driver.findElement(By.cssSelector(be.rubric_math_txtbx)).sendKeys("10");
		waitThread(2000);

		driver.findElement(By.cssSelector(be.rubric_math_txtbx)).sendKeys(Keys.ARROW_DOWN);
		waitThread(2000);

		driver.findElement(By.cssSelector(be.rubric_math_txtbx)).sendKeys("4");
		waitThread(2000);

		driver.findElement(By.cssSelector(be.rubric_math_txtbx)).sendKeys(Keys.ARROW_RIGHT);
		JavaScriptclick(be.rubric_sqre_root);

		Assert.assertTrue(isDisplayed(be.rubricfraction_btn), "Fraction body not visible");
		driver.findElement(By.cssSelector(be.rubric_math_txtbx)).sendKeys("5");
		waitThread(2000);

		driver.findElement(By.cssSelector(be.rubric_math_txtbx)).sendKeys(Keys.ARROW_RIGHT);
		waitThread(2000);

		Assert.assertTrue(isDisplayed(be.rubricfraction_btn), "Fraction body not visible");
		waitThread(2000);
		Doubleclick(be.rubric_math_insertbtn);
		waitThread(2000);

		Assert.assertFalse(isDisplayed(be.rubric_math_txtbx), "MathType Popup  visible");
		waitThread(4000);

		// Switch to Rubric frame and verify the uploaded equation
		driver.switchTo().frame("rubrics_ifr");
		waitThread(5000);
		Assert.assertTrue(isElementPresent(sq.equationineditor_std), "Uploaded equation not visible");
		driver.switchTo().defaultContent();

		waitThread(4000);

		// Click Save button in edit question popup
		click(sq.save_btn_editpop);

		waitFor(QP.toaster);
		// Assert the toaster "Question updated successfully"
		Assert.assertEquals(getText(QP.toaster), "Question updated successfully");
		click(QP.toasterclosebtn);

		waitThread(3000);

		// Assert the tooltip " Image/Video/Equation" rubric part of Question6
		MouseHover(sq.rubquest6);
		Assert.assertEquals(getAttribute(sq.rubquest6, "tooltipposition"), "top");

		// Assert the question content "Image/Video/Equation" visible on summary page
		Assert.assertEquals(getText(sq.quest6), "Image/Video/Equation");

		softAssert11.assertAll();
	}
	/*
	 * To perform Delete TeacherAccount functionality
	 */
	@Test(priority = 51)
	public void TCSPR0901251() {

		waitThread(2000);
		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted teacher profile credentials
	 */
	@Test(priority = 52)
	public void TCSPR0901252() {

		// login using deleted account credentials
		rs.login_Teacher(Emailteacher, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}
	/*
	 * Perform Login using Student 1 
       credentials and perform delete account functionality
	 */
	@Test(priority = 53)
	public void TCSPR0901253() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent1, password);

		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}
	/*
	 * To perform login functionality using deleted student 1 profile credentials
	 */
	@Test(priority = 54)
	public void TCSPR0901254() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent1, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}
	/*
	 * Perform Login using Student 2
       credentials and perform delete account functionality
	 */
	@Test(priority = 55)
	public void TCSPR0901255() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent2, password);

		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}
	/*
	 * To perform login functionality using deleted student 2 profile credentials
	 */
	@Test(priority = 56)
	public void TCSPR0901256() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent2, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}


}




