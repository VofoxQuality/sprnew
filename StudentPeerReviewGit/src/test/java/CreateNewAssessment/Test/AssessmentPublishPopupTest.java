package CreateNewAssessment.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import CreateNewAssessment.Pages.AssessmentPublishPopupPage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.ScheduleConfigureDefaultPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class AssessmentPublishPopupTest extends basePage {

	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	EncryptedText et = new EncryptedText();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	SchedulePageBasicsPage sb = new SchedulePageBasicsPage();
	ScheduleConfigureDefaultPage sd = new ScheduleConfigureDefaultPage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	CourseRosterPage cr = new CourseRosterPage();
	CommonMethods cm = new CommonMethods();
	AssessmentPublishPopupPage ap = new AssessmentPublishPopupPage();

	public String Emailteacher;
	public String CourseNamenew;
	public String NewCourseTitle;
	public String AssessmentName;
	public String NewAssessmentName;
	public String NewCourseName;
	public String Assessmentinfo;
	public String Assessmentinstruction;
	public String Assessmentinfonew;
	public String Assessmentinstructionnew;
	public String NewAssessmentinfo;
	public String NewAssessmentinstruction;
	public String CourseID1;
	public String CourseID;
	public String CourseName;
	public String Emailstudent1;
	public String Emailstudent2;
	public String Studentfirstname = "Ashley";
	public String Studentlastname = "Albert";
	public String Studentname = "Ashley Albert";
	public String Studentfirstname2 = "Ben";
	public String Studentlastname2 = "Alex";
	public String Studentname2 = "Ben Alex";

	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	/*
	 * To perform Teacher Sign UP functionality
	 */
	@Test(priority = 0)
	public void TCSPR0901601() {

		// To click on I am A teacher button
		click(sp.btn_1);

		// To fill the details on the sign up page
		Emailteacher = st.TCSPR020005();
		

	}

	/*
	 * To fetch OTP
	 */
	@Test(priority = 1)
	public void OtpFetch() throws SQLException {

		// To catch OTP from sending Resource
		st.TCSPR020006();

	}

	/*
	 * To create new course
	 */
	@Test(priority = 2)
	public void TCSPR0901602() throws SQLException {

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
	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 3)
	public void TCSPR0901603() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on first student 's profile and
	 * accept course request-Read the student name
	 */
	@Test(priority = 4)
	public void TCSPR0901604() throws SQLException {
		studentinviteid = dc.InviteLink(Emailstudent1, CourseID);
		String encText = et.EncryptCode(studentinviteid);

		driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname = "Ashley";
		Studentlastname = "Albert";
		Studentname = Studentfirstname + " " + Studentlastname;

		// click first name
		click(sp.txtbxFirstN);
		waitThread(1000);
		// type first name
		type(sp.txtbxFirstN, Studentfirstname);
		waitThread(1000);
		// click last name
		click(sp.txtbxLastN);
		waitThread(1000);
		// type last name
		type(sp.txtbxLastN, Studentlastname);
		waitThread(1000);
		// click password
		click(sp.txtbxPass);
		waitThread(1000);
		// type password
		type(sp.txtbxPass, password);
		waitThread(1000);
		// click password
		click(sp.txtbxPassconf);
		waitThread(1000);
		// type password
		type(sp.txtbxPassconf, password);
		waitThread(1000);
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
	 * To Accept course and perform logout functionality on the student // profile
	 */
	@Test(priority = 5)
	public void TCSPR0901605() {

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
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * To check that invited course request visible on second student's profile and
	 * course request-Read the student name
	 */
	@Test(priority = 6)
	public void TCSPR0901606() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent2, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname2 = "Ben";
		Studentlastname2 = "Alex";
		Studentname2 = Studentfirstname2 + " " + Studentlastname2;

		// click first name
		click(sp.txtbxFirstN);
		waitThread(1000);
		// type first name
		type(sp.txtbxFirstN, Studentfirstname2);
		waitThread(1000);
		// click last name
		click(sp.txtbxLastN);
		waitThread(1000);
		// type last name
		type(sp.txtbxLastN, Studentlastname2);
		waitThread(1000);
		// click password
		click(sp.txtbxPass);
		waitThread(1000);
		// type password
		type(sp.txtbxPass, password);
		waitThread(1000);
		// click password
		click(sp.txtbxPassconf);
		waitThread(1000);
		// type password
		type(sp.txtbxPassconf, password);
		waitThread(1000);
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
	@Test(priority = 7)
	public void TCSPR0901607() {
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
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */

	@Test(priority = 8)
	public void TCSPR0901608() {

		SoftAssert softAssert1 = new SoftAssert();
		rs.login_Teacher(Emailteacher, password);
		waitThread(1000);
		// click on Assessment tab
		click(ba.Assessmenttab);

		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		softAssert1.assertEquals(getText(ba.ddcoursename1), CourseName.trim(),
				"course name not visible on the dropdown");

		click(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentName = "Assessment_1_" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentName);

		waitThread(1000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(2000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(3000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), AssessmentName);

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID + ", " + CourseName.trim());

		softAssert1.assertAll();
	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 9)
	public void TCSPR0901609() {

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
		click(QP.rubric_drp_btn);
		waitThread(3000);

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "3");

		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");

		click(QP.toasterclosebtn);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	/*
	 * To verify the details on the peer review page
	 */
	@Test(priority = 10)
	public void TCSPR0901610() {

		waitThread(2000);

		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");

		// Assert the first student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Studentname);

		// Assert the second student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Studentname2);

	}

	/*
	 * To perform the save and next functionaity from peer review page and verify
	 * the schedule page details
	 */
	@Test(priority = 11)
	public void TCSPR0901611() {

		// Type Reward Percentage
		type(pr.PRreward_txtbox, "50");
		waitThread(3000);
		click(pr.savennext_button);
		waitThread(2000);

		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");

		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.Sbassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseName.trim()));
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);
		waitThread(2000);

	}

	/*
	 * To perform Assessment publish functionality and check the details on the
	 * publish popup
	 */
	@Test(priority = 12)
	public void TCSPR0901612() {

		click(pr.savennext_button);
		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");
		// Assert the label assessment name,
		waitThread(2000);
		click(ap.relese_btn);
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");

		click(QP.toasterclosebtn);
		Assert.assertTrue(isElementPresent(ap.publish_popup), "popup not visible");

		Assert.assertEquals(getText(ap.Assessmentcreated_lbl), "Assessment Created Successfully");

		Assert.assertEquals(getText(ap.YourAssess_lbl),
				"Your assessment has been created and scheduled successfully. You can edit the assessment\n"
						+ "if needed before its start date. Also, you cannot edit the assessment once it has been started.");
		Assert.assertEquals(getText(ap.Addthis_lbl), "Add this assessment to the library to reuse later");
		Assert.assertEquals(getText(ap.selectcate_lbl), "Select a category to add assessment:");

		Assert.assertTrue(isElementPresent(ap.Addthis_chckbox), "checkbox not visible");
		Assert.assertTrue(isElementPresent(ap.selectcate_d_1), "Dropdown not visible");
		Assert.assertTrue(isElementPresent(ap.Backtomenu_btn), "Button not visible");

		Assert.assertTrue(getAttribute(ap.selectcate_d_3, "class").contains("p-disabled"), "Dropdown enabled");

	}

	/*
	 * To perform page refresh functionality and check the page redirect to the
	 * Current Assessment tab
	 */
	@Test(priority = 13)
	public void TCSPR0901613() {

		PageRefresh();
		waitThread(3000);
		Assert.assertEquals(getAttribute(ap.currentassess_tab, "aria-selected"), "true");
		click(pr.draft_tab);

		// Assert the assessment name not visible on the grid
		 Assert.assertEquals(getText(pr.draftnoassess_lbl).trim(), "No Assessment(s) Found.");

	}

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */
	@Test(priority = 14)
	public void TCSPR0901614() {

		SoftAssert softAssert2 = new SoftAssert();

		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		softAssert2.assertEquals(getText(ba.ddcoursename1), CourseName.trim(),
				"course name not visible on the dropdown");

		click(ba.ddcoursename1);
		waitThread(1000);
		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentName = "Assessment_2_" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentName);

		waitThread(1000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(2000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");
		softAssert2.assertAll();
	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 15)
	public void TCSPR0901615() {
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
		click(QP.rubric_drp_btn);
		waitThread(3000);

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "3");

		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Question 1 Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");

		click(QP.toasterclosebtn);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

	}

	/*
	 * To verify the details on the peer review page
	 */
	@Test(priority = 16)
	public void TCSPR0901616() {

		waitThread(3000);

		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");

		// Assert the first student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Studentname);

		// Assert the second student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Studentname2);

	}

	/*
	 * To perform the save and next functionaity from peer review pageand verify the
	 * schedule page details
	 */
	@Test(priority = 17)
	public void TCSPR0901617() {

		// Type Reward Percentage
		type(pr.PRreward_txtbox, "50");
		waitThread(3000);
		click(pr.savennext_button);
		waitThread(2000);
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");

		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.Sbassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseName.trim()));
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);
		waitThread(2000);
	}

	/*
	 * To perform save and next functionality from schedule page and check the
	 * details on the summary page
	 */
	@Test(priority = 18)
	public void TCSPR0901618() {

		click(pr.savennext_button);
		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");

		click(ap.relese_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");

		click(QP.toasterclosebtn);
		Assert.assertTrue(isElementPresent(ap.publish_popup), "popup not visible");

	}

	/*
	 * To check the back to menu button functionality and check the validation
	 * messages
	 */
	@Test(priority = 19)
	public void TCSPR0901619() {

		// waitThread(2000);
		// Click on Assessment library check box
		click(ap.Addthis_chckbox);

		waitThread(1000);

		// Assert checkbox is selected
		Assert.assertTrue(isElementPresent(ap.Addthis_chckbox2), "checkbox not selected");
		waitThread(1000);
		click(ap.Backtomenu_btn);
		waitThread(1000);
		waitFor(QP.toaster);
		// Assert the toaster Please select the Category
		Assert.assertEquals(getText(QP.toaster), "Please select the Category");

		click(QP.toasterclosebtn);
		waitThread(1000);
		click(ap.Addthis_chckbox);
		waitThread(2000);

		// assert check box not selected
		Assert.assertFalse(isElementPresent(ap.Addthis_chckbox2), "checkbox  selected");
		waitThread(2000);
		click(ap.Backtomenu_btn);

		waitThread(3000);

		
		// Assert the Assessment Draft tab is selected
		Assert.assertEquals(getAttribute(ap.assessmntdraft_tab, "aria-selected"), "true");

		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(ap.publish_popup), "popup is visible");

	}

	/*
	 * To create a new assessment and publish the assessment
	 */
	@Test(priority = 20)
	public void TCSPR0901620() {

		SoftAssert softAssert3 = new SoftAssert();

		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		softAssert3.assertEquals(getText(ba.ddcoursename1), CourseName.trim(),
				"course name not visible on the dropdown");

		JavaScriptclick(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentName = "Assessment_3_" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentName);

		waitThread(1000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(2000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");
		softAssert3.assertAll();
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
		click(QP.rubric_drp_btn);
		waitThread(3000);

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "3");

		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Question 1 Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");

		click(QP.toasterclosebtn);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");
		waitThread(1000);
		// Type Reward Percentage
		type(pr.PRreward_txtbox, "50");
		waitThread(3000);
		click(pr.savennext_button);
		waitThread(2000);
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);
		waitThread(2000);

		click(pr.savennext_button);
		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");
		click(ap.relese_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");

		click(QP.toasterclosebtn);
	}

	/*
	 * To check the Select a category functionality on the summary publish popup
	 */
	@Test(priority = 21)
	public void TCSPR0901621() {

		// Assert dropdown enabled
		Assert.assertTrue(getAttribute(ap.selectcate_d_3, "class").contains("p-disabled"), "Dropdown enabled");

		click(ap.Addthis_chckbox);
		waitThread(500);

		// Assert dropdown enabled
		// Assert.assertTrue(isEnabled(ap.selectcate_d_2), "Dropdown not enabled");
		Assert.assertFalse(getAttribute(ap.selectcate_d_3, "class").contains("p-disabled"), "Dropdown enabled");

		waitThread(3000);
		click(ap.selectcate_d_2);
		waitThread(1000);

		// Assert popup is visible
		Assert.assertTrue(isElementPresent(ap.category_popup), "popup not visible");
		waitThread(1000);
		// Assert checkbox is not checked
		Assert.assertEquals(getAttribute(ap.checkbox1, "aria-checked"), "0");

		// Assert textbox,buttons
		Assert.assertTrue(isElementPresent(ap.category_txtbox), "textbox visible");

		Assert.assertTrue(isElementPresent(ap.createnewcat_lbl), "Button visible");

		Assert.assertTrue(isElementPresent(ap.close_btn), "Button visible");

		// click closer button
		click(ap.close_btn);
		waitThread(1000);

		// assert popup not visible
		Assert.assertFalse(isElementPresent(ap.category_popup), "popup not visible");

	}

	/*
	 * To check that the create new category functionality on the publish popup
	 */
	@Test(priority = 22)
	public void TCSPR0901622() {

		click(ap.selectcate_d_1);

		waitThread(1000);

		// Assert popup visible
		Assert.assertTrue(isElementPresent(ap.category_popup), "popup not visible");

		click(ap.createnewcat_lbl);
		waitThread(1000);

		// Assert popup visible
		Assert.assertTrue(isElementPresent(ap.createcategory_popup), "popup not visible");

		// Assert label Create Category
		Assert.assertEquals(getText(ap.createcate_lbl), "Create Category");

		// Assert button create
		Assert.assertTrue(isElementPresent(ap.create_btn), "Button visible");

		// Assert name textbox
		Assert.assertTrue(isElementPresent(ap.name_txtbox), "textbox visible");

		click(ap.create_btn);
		waitFor(QP.toaster);

		// Assert the toaster Please enter the Category Name
		Assert.assertTrue(getText(QP.toaster).contains("Please enter the Category Name"));

		waitThread(1000);

	}

	/*
	 * To create a new category in the category popup
	 */
	@Test(priority = 23)
	public void TCSPR0901623() {

		click(ap.name_txtbox);
		waitThread(500);

		// type category name
		type(ap.name_txtbox, "Category one");

		waitThread(500);

		click(ap.create_btn);

		waitFor(QP.toaster);

		// Assert the toaster Added to the assessment library
		Assert.assertTrue(getText(QP.toaster).contains("Added to the assessment library"));

		waitThread(1000);

		// *Assert the Category popup not visible
		Assert.assertFalse(isElementPresent(ap.createcategory_popup), "popup visible");

		// Assert the added category visible on the popup
		Assert.assertTrue(isElementPresent(ap.addedcate_lbl), "added category not visible on the popup");

		// *Assert the assessment library check box is checked
		Assert.assertTrue(isElementPresent(ap.Addthis_chckbox2), "checkbox not selected");

	}

	/*
	 * To create a category with already used category name and check the validation
	 * message
	 */
	@Test(priority = 24)
	public void TCSPR0901624() {

		click(ap.selectcate_d_1);

		waitThread(500);

		// assert added category is present
		Assert.assertTrue(isElementPresent(ap.addedcate_lbl2), "added category not visible on the dropdown");

		click(ap.createnewcat_lbl);
		waitThread(500);

		click(ap.name_txtbox);
		waitThread(500);

		// type category name
		type(ap.name_txtbox, "Category one");
		waitThread(500);

		// click create button
		click(ap.create_btn);
		waitFor(QP.toaster);

		// Assert the toaster Category Name 'Category one' already exist
		Assert.assertTrue(getText(QP.toaster).contains("Category Name 'Category one' already exist"));

		waitThread(1000);

		click(ap.close_btn2);

		waitThread(1000);

		// Asser popup not visible
		Assert.assertFalse(isElementPresent(ap.createcategory_popup), "popup visible");

	}

	/*
	 * To create a new category in the category popup
	 */
	@Test(priority = 25)
	public void TCSPR0901625() {

		click(ap.selectcate_d_1);
		waitThread(500);

		// Added category present
		Assert.assertTrue(isElementPresent(ap.addedcate_lbl2), "added category not visible on the dropdown");
		click(ap.createnewcat_lbl);

		waitThread(500);
		click(ap.name_txtbox);
		waitThread(500);

		// type category anme
		type(ap.name_txtbox, "Category Two");
		waitThread(500);

		// click create button
		click(ap.create_btn);
		waitFor(QP.toaster);

		// Assert the toaster Added to the assessment library
		Assert.assertTrue(getText(QP.toaster).contains("Added to the assessment library"));

		waitThread(1000);

		// Assert pop up visible
		Assert.assertTrue(isElementPresent(ap.addedcate_lbl3), "added category not visible on the popup");

	}

	/*
	 * To check the added categories are visible on the publish popup and category
	 * dropdown
	 */
	@Test(priority = 26)
	public void TCSPR0901626() {

		click(ap.selectcate_d_1);
		waitThread(1000);

		// Assert the category name "Category one" visible
		Assert.assertTrue(isElementPresent(ap.addedcate_lbl2), "added category not visible on the dropdown");

		// Assert the category name "Category two" visible
		Assert.assertTrue(isElementPresent(ap.addedcate_lbl4), "added category not visible on the dropdown");

		waitThread(1000);

		// Assert category check boxes are selected
		Assert.assertTrue(getAttribute(ap.cateone_chckbox, "class").contains("p-highlight"), "checkbox not selected");
		Assert.assertTrue(getAttribute(ap.catetwo_chckbox, "class").contains("p-highlight"), "checkbox not selected");

		// Uncheck the category one from the dropdwon
		click(ap.cateone_chckbox);
		waitThread(1000);

		// Assert the check box is unchecked
		Assert.assertFalse(isSelected(ap.cateone_chckbox), "checkbox  selected");
		Assert.assertFalse(getText(ap.addedcate_lbl).contains("category One"));

		// Check the category one from the dropdwon
		click(ap.cateone_chckbox);
		waitThread(1000);

		// Assert the check box is checked
		Assert.assertTrue(getAttribute(ap.cateone_chckbox, "class").contains("p-highlight"), "checkbox not selected");

		waitThread(500);

		// click close button
		click(ap.close_btn);

		waitThread(1000);

		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(ap.createcategory_popup), "popup visible");

	}

	/*
	 * To remove the added categories from the popup
	 */
	@Test(priority = 27)
	public void TCSPR0901627() {

		// assert added category present on popup
		Assert.assertTrue(isElementPresent(ap.addedcate_lbl), "added category not visible on the popup");

		Assert.assertTrue(isElementPresent(ap.addedcate_lbl3), "added category not visible on the popup");

		// Click on category name "Category one" close button
		click(ap.close_btn4);
		waitThread(500);

		// Assert the category name "Category one"not visible
		Assert.assertFalse(isElementPresent(ap.addedcate_lbl3), "added category not visible on the popup");

		// Click on category name "Category two" close button
		click(ap.close_btn3);
		waitThread(500);

		// Assert the category name "Category two"not visible
		Assert.assertFalse(isElementPresent(ap.addedcate_lbl), "added category not visible on the popup");

		click(ap.Addthis_chckbox);
		waitThread(500);

		click(ap.selectcate_d_1);
		waitThread(500);

		// Assert the category name "Category one" check box is unselected
		Assert.assertFalse(isSelected(ap.cateone_chckbox), "checkbox  selected");

		// Assert the category name "Category two" check box is unselected
		Assert.assertFalse(isSelected(ap.catetwo_chckbox), "checkbox  selected");

		click(ap.Addthis_chckbox);
		waitThread(500);

		// Assert the assessment to library check box is unchecked
		Assert.assertFalse(isElementPresent(ap.Addthis_chckbox2), "checkbox  selected");

		// Assert the select category dropdown is disabled
		Assert.assertTrue(getAttribute(ap.selectcate_d_3, "class").contains("p-disabled"), "Dropdown enabled");

	}

	/*
	 * To publish assessment and Add this assessment to the library to reuse later
	 */
	@Test(priority = 28)
	public void TCSPR0901628() {

		click(ap.Addthis_chckbox);
		waitThread(2000);

		// Assert dropdown enabled
		Assert.assertTrue(isEnabled(ap.selectcate_d_2), "Dropdown not enabled");

		click(ap.selectcate_d_1);
		waitThread(1000);

		click(ap.checkbox1);
		waitThread(1000);

		// Assert the category name "Category one" check box is selected
		Assert.assertTrue(getAttribute(ap.cateone_chckbox, "class").contains("p-highlight"), "checkbox not selected");

		// Assert the category name "Category Two" check box is selected
		Assert.assertTrue(getAttribute(ap.catetwo_chckbox, "class").contains("p-highlight"), "checkbox not selected");

		// Assert the category name "Category One" visible on the dropdown
		Assert.assertTrue(isElementPresent(ap.addedcate_lbl3), "added category not visible on the dropdown");

		// Assert the category name "Category One" visible on the dropdown
		Assert.assertTrue(isElementPresent(ap.addedcate_lbl), "added category not visible on the dropdown");

		click(ap.close_btn);
		waitThread(1000);

		// Assert the category name "Category One" visible on the popup
		Assert.assertTrue(isElementPresent(ap.addedcate_lbl3), "added category not visible on the popup");

		// Assert the category name "Category Two" visible on the popup
		Assert.assertTrue(isElementPresent(ap.addedcate_lbl), "added category not visible on the popup");

		click(ap.Backtomenu_btn);

		waitFor(QP.toaster);

		// Assert the toaster Successfully added to the library
		Assert.assertEquals(getText(QP.toaster), "Successfully added to the library");

		waitThread(3000);
		
		// Assert the Assessment Draft tab is selected
		Assert.assertEquals(getAttribute(ap.assessmntdraft_tab, "aria-selected"), "true");

	}

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */
	@Test(priority = 29)
	public void TCSPR0901629() {

		SoftAssert softAssert4 = new SoftAssert();

		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		softAssert4.assertEquals(getText(ba.ddcoursename1), CourseName.trim(),
				"course name not visible on the dropdown");

		click(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		NewAssessmentName = "NewAssessment_" + generateRandomNumber().trim();

		type(QP.Assess_name, NewAssessmentName);

		waitThread(1000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(2000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");
		softAssert4.assertAll();

	}

	/*
	 * To fill details on theQuestion page
	 */
	@Test(priority = 30)
	public void TCSPR0901630() {
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
		click(QP.rubric_drp_btn);
		waitThread(3000);

		// Click Standard rubric radio button
		click(QP.std_rad);

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "3");

		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Question 1 Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");

		click(QP.toasterclosebtn);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

	}

	/*
	 * To verify the details on the peer review page
	 */
	@Test(priority = 31)
	public void TCSPR0901631() {
		waitThread(2000);

		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + NewAssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Assert the text::Total Students : Assert the total student count is 2
		// Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total
		// Students : 2");
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");

		// Assert the first student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Studentname);

		// Assert the second student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Studentname2);

	}

	/*
	 * To perform the save and next functionaity from peer review pageand verify the
	 * schedule page details
	 */
	@Test(priority = 32)
	public void TCSPR0901632() {

		// Type Reward Percentage
		type(pr.PRreward_txtbox, "50");
		waitThread(3000);
		click(pr.savennext_button);

		waitThread(2000);
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");

		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.Sbassessmentname_lbl).contains("Assessment Name: " + NewAssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseName.trim()));
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);
		waitThread(2000);
		click(pr.savennext_button);
		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");

	}

	/*
	 * To perform save and next functionality from schedule page and check the
	 * details on the summary page
	 */
	@Test(priority = 33)
	public void TCSPR0901633() {

		waitThread(2000);

		// click release button
		click(ap.relese_btn);

		waitFor(QP.toaster);

		// Assert the toaster Assessment published successfully
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");

		click(QP.toasterclosebtn);

		// Assert the popup visible
		Assert.assertTrue(isElementPresent(ap.publish_popup), "popup not visible");

	}

	/*
	 * To check that the added categories visible on the select category dropdown
	 */
	@Test(priority = 34)
	public void TCSPR0901634() {

		// Click on Create new category button
		click(ap.Addthis_chckbox);
		waitThread(500);

		// Assert dropdown enabled
		Assert.assertTrue(isEnabled(ap.selectcate_d_2), "Dropdown not enabled");

		click(ap.selectcate_d_1);
		waitThread(500);

		// Assert created category checkbox are unchecked
		Assert.assertFalse(isSelected(ap.cateone_chckbox), "checkbox  selected");
		Assert.assertFalse(isSelected(ap.catetwo_chckbox), "checkbox  selected");

		// assert added category present in dropdown
		Assert.assertTrue(isElementPresent(ap.addedcate_lbl2), "added category not visible on the dropdown");
		Assert.assertTrue(isElementPresent(ap.addedcate_lbl4), "added category not visible on the dropdown");

		// Assert category name visible
		Assert.assertEquals(getText(ap.addedcate_lbl2), "Category one");
		Assert.assertEquals(getText(ap.addedcate_lbl4), "Category Two");

	}

	/*
	 * To check the Add this assessment to the library to reuse later check box
	 * functionality
	 */
	@Test(priority = 35)
	public void TCSPR0901635() {

		click(ap.checkbox1);
		waitThread(500);

		// Assert the check box is checked
		Assert.assertTrue(getAttribute(ap.cateone_chckbox, "class").contains("p-highlight"), "checkbox not selected");

		// Assert the category name "Category one" visible on the popup
		Assert.assertTrue(getAttribute(ap.catetwo_chckbox, "class").contains("p-highlight"), "checkbox not selected");

		// Assert the category name "Category Two" visible on the popup
		Assert.assertTrue(isElementPresent(ap.addedcate_lbl3), "added category not visible on the popup");

		// Assert the category name "Category one" visible on the popup
		Assert.assertTrue(isElementPresent(ap.addedcate_lbl), "added category not visible on the popup");

		// Click on add assessment to library check box
		click(ap.Addthis_chckbox);
		waitThread(500);

		Assert.assertFalse(isElementPresent(ap.Addthis_chckbox2), "check box selected");

		// Assert the category name "Category two"not visible
		Assert.assertFalse(isElementPresent(ap.addedcate_lbl3), "added category not visible on the popup");

		// Assert the category name "Category one"not visible
		Assert.assertFalse(isElementPresent(ap.addedcate_lbl), "added category not visible on the popup");

	}

	/*
	 * To create a new category name and publish assessment
	 */
	@Test(priority = 36)
	public void TCSPR0901636() {

		// Click on add assessment to library check box
		click(ap.Addthis_chckbox);

		waitThread(1000);

		// Click on Back to menu button
		click(ap.Backtomenu_btn);

		waitFor(QP.toaster);

		// Assert toaster "Please select the Category"
		Assert.assertTrue(getText(QP.toaster).contains("Please select the Category"));

		click(ap.selectcate_d_1);
		waitThread(1000);

		click(ap.createnewcat_lbl);
		waitThread(1000);

		click(ap.name_txtbox);
		waitThread(500);

		// Type Category name
		type(ap.name_txtbox, "Category Three");
		waitThread(500);

		click(ap.create_btn);
		waitFor(QP.toaster);

		// Assert the toaster Added to the assessment library
		Assert.assertTrue(getText(QP.toaster).contains("Added to the assessment library"));

		waitThread(1000);

		// Assert the added category visible on the popup
		Assert.assertFalse(isElementPresent(ap.createcategory_popup), "popup visible");

		// Assert the Category popup not visible
		Assert.assertTrue(isElementPresent(ap.addedcate_lbl), "added category not visible on the popup");

		// Assert the assessment library check box is checked
		Assert.assertTrue(isElementPresent(ap.Addthis_chckbox2), "checkbox not selected");

		// Click on Back to menu button
		click(ap.Backtomenu_btn);

		waitFor(QP.toaster);

		// Assert the toaster "Successfully added to the library"
		Assert.assertTrue(getText(QP.toaster).contains("Successfully added to the library"));

		
		waitThread(3000);
		
		// Assert the Assessment Draft tab is selected
		Assert.assertEquals(getAttribute(ap.assessmntdraft_tab, "aria-selected"), "true");

	}

	/*
	 * To perform Delete Teacher Account functionality
	 */
	@Test(priority = 37)
	public void TCSPR0901637() {

		
		waitThread(2000);
		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
		waitThread(2000);
	}

	/*
	 * To perform login functionality using deleted teacher profile credentials
	 */
	@Test(priority = 38)
	public void TCSPR0901638() {

		// login using deleted account credentials
		rs.login_Teacher(Emailteacher, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");
	}

	/*
	 * To perform Delete student1 Account functionality
	 */
	@Test(priority = 39)
	public void TCSPR0901639() {

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
	@Test(priority = 40)
	public void TCSPR0901640() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent1, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student2 Account functionality
	 */
	@Test(priority = 41)
	public void TCSPR0901641() {
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
	@Test(priority = 42)
	public void TCSPR0901642() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent2, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");
	}
}