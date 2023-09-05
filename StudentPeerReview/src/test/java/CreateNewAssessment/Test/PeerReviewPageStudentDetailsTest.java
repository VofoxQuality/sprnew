package CreateNewAssessment.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import Course.Pages.EditCoursePage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class PeerReviewPageStudentDetailsTest extends basePage {

	SignUpPage sp = new SignUpPage();
	LoginPage lg = new LoginPage();
	SignUpTest st = new SignUpTest();
	Databaseconnection dc = new Databaseconnection();
	CourseRosterPage cr = new CourseRosterPage();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	EncryptedText et = new EncryptedText();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	EditCoursePage ec = new EditCoursePage();

	public String AssessmentName;
	public String Emailteacher;
	public String teacherotp;
	public String studentotp;
	public String CourseName;
	public String CourseNamenew;
	public String CourseID;
	public String CourseID1;
	public String Emailstudent1;
	public String Emailstudent2;
	public String Emailstudent3;
	public String Emailstudent4;
	public String Emailstudent5;
	public String Emailstudent6;

	public String Studentfirstname;
	public String Studentlastname;
	public String Studentname;
	public String Studentfirstname2;
	public String Studentlastname2;
	public String Studentname2;
	public String Studentfirstname3;
	public String Studentlastname3;
	public String Studentname3;
	public String Studentfirstname4;
	public String Studentlastname4;
	public String Studentname4;
	public String Studentfirstname5;
	public String Studentlastname5;
	public String Studentname5;
	public String Studentfirstname6;
	public String Studentlastname6;
	public String Studentname6;

	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	/*
	 * To perform Sign Up functionality
	 */
	@Test(priority = 0)
	public void TCSPR090801() {

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
	 * To create new course
	 */
	@Test(priority = 2)
	public void TCSPR090802() throws SQLException {

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
	public void TCSPR090803() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on first student 's profile
	 * and accept course request-Read the student name
	 */
	@Test(priority = 4)
	public void TCSPR090804() throws SQLException {

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
	public void TCSPR090805() {

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
	 * To load the create new assessment page and fill details on the basic
	 * details page
	 */
	@Test(priority = 6)
	public void TCSPR090806() {

		SoftAssert softAssert1 = new SoftAssert();
		rs.login_Teacher(Emailteacher, password);

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
		AssessmentName = "Assessment" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentName);

		waitThread(1000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(1000);

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
	@Test(priority = 7)
	public void TCSPR090807() {

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
	 * To verify the course name assessment name, lables,textboxes on the peer
	 * review page
	 */
	@Test(priority = 8)
	public void TCSPR090808() {

		waitThread(2000);

		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Assert the tooltips
		MouseHover(pr.PRassessmentname_lbl);

		// *Assert-Assessment Name:
		Assert.assertTrue(getText(pr.assessmentname_tooltip).contains(AssessmentName));

		// Assert the tooltips
		MouseHover(pr.PRcoursename_lbl);

		waitThread(1000);
		// *Assert CourseName:
		Assert.assertTrue(getText(pr.course_tooltip).contains(CourseID + ", " + CourseName.trim()));

		// Assert the Answer Sheets Per Student drop down is disabled
		Assert.assertFalse(isElementPresent(pr.anssheetperstu_drp), "Answer Sheets Per Student dropdown is enabled");

		// Assert the Peer Review Reward Score text box is disabled
		Assert.assertFalse(isEnabled(pr.PRreward_txtbox), "Peer Review Reward Scoretextbox is enabled");

	}

	/*
	 * To verify the grid texts and lables on the peer review page
	 */
	@Test(priority = 9)
	public void TCSPR090809() {

		// Assert the text::Total Students : Assert the total student count is 1
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 1");

		// Assert info text 'Peer students name will be hide and will displayed
		// "anonymous" for the other Students'
		Assert.assertTrue(getText(pr.infotext_lbl).contains(
				"Actual student names will be hidden from the reviewer and each student will be reviewed anonymously."));
		// *Assert text 'A minimum of 2 students are required to perform Peer
		// Review'
		//Assert.assertTrue(getText(pr.minimumstudent_lbl).contains(
				//"This course only has one student in its roster. A minimum of 2 students are required to perform Peer Review.\n\n"+

// "To add students, save this assessment as a draft (by clicking 'Save & Exit' at the top of the screen) and then return to the \"Courses\" menu and add students. Once students are enrolled, you can return to the 'Assessments' menu and 'Continue Editing' this assessment from the 'Draft' assessment tab."));

		// Assert the grid lables::
		Assert.assertEquals(getText(pr.SN_gridlbl).trim(), "SN");
		Assert.assertEquals(getText(pr.Peerreviewer_gridlbl).trim(), "Peer Reviewer");

		Assert.assertEquals(getText(pr.anstobeassign_gridlbl).trim(),
				"Answer sheets to be assigned to the Peer Reviewer");
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Studentname.trim());

	}

	/*
	 * To check the save and next button functionality on the peer review page
	 */
	@Test(priority = 10)
	public void TCSPR090810() {

		// Click on save and next button
		click(pr.savennext_button);
		waitThread(1000);

		waitFor(pr.PRsavenext_toaster);
		// Assert toaster::A minimum of 2 students are required to perform Peer
		// Review
		Assert.assertEquals(getText(pr.PRsavenext_toaster),"Warning\n" + "This course only has one student in its roster. A minimum of 2 students \n"
						+ " are required to perform Peer Review");

	}

	/*
	 * To check the save and exit button functionality on the peer review page
	 */
	@Test(priority = 11)
	public void TCSPR090811() {

		// Click on save and next button
		click(pr.savenexit_button);
		waitThread(1000);

		// Assert the tab name:Draft
		Assert.assertEquals(getText(pr.draft_lbl).trim(), "Draft");

		click(pr.draft_tab);

		// *Assert the assessment name on the grid
		Assert.assertEquals(getText(pr.draftassessname_lbl).trim(), AssessmentName);

		// click continue edit button
		click(pr.continueedit_button);
		waitThread(1000);

		// Assert the basic deatils wizard is selected
		Assert.assertTrue(isEnabled(pr.basicdetails_wizard), "basic details wizard is selected");

		// Click on save and next button
		click(pr.savennext_button);
		waitThread(1000);

		// Assert the question wizard is selected
		Assert.assertTrue(isEnabled(pr.question_wizard), "question wizard is selected");

		// Click on save and next button
		click(pr.savennext_button);
		waitThread(1000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");
	}
	/*
	 * To perform logout functionality on the teacher profile
	 */

	@Test(priority = 12)
	public void TCSPR090812() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on second student's profile
	 * and course request-Read the student name
	 */
	@Test(priority = 13)
	public void TCSPR090813() throws SQLException {

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

		// type first name
		type(sp.txtbxFirstN, Studentfirstname2);

		// click last name
		click(sp.txtbxLastN);

		// type last name
		type(sp.txtbxLastN, Studentlastname2);

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
	@Test(priority = 14)
	public void TCSPR090814() {

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
	 * To load the peer review page and verify the student count and grid labels
	 * and dropdowns are enable
	 */
	@Test(priority = 15)
	public void TCSPR090815() {

		rs.login_Teacher(Emailteacher, password);

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(2000);

		// click draft tab
		click(pr.draft_tab);
		waitThread(2000);

		// Assert the tab name:Draft
		Assert.assertEquals(getText(pr.draft_lbl).trim(), "Draft");

		// *Assert the assessment name on the grid
		Assert.assertEquals(getText(pr.draftassessname_lbl).trim(), AssessmentName);

		// click continue edit button
		click(pr.continueedit_button);
		waitThread(1000);

		// Assert the basic details wizard is selected
		Assert.assertTrue(isEnabled(pr.basicdetails_wizard), "basic details wizard is selected");

		waitThread(2000);
		// Click on save and next button
		click(pr.savennext_button);

		waitThread(3000);

		MouseHover(pr.question_wizard);
		// Assert the question wizard is selected
		Assert.assertTrue(isEnabled(pr.question_wizard), "Question wizard is selected");

		// Click on save and next button
		click(pr.savennext_button);

		waitThread(3000);

		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");
		waitThread(3000);

		waitFor(pr.totalstudent_lbl);
		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");

		// Assert the second student name on the page[
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Studentname2);

		// Assert the Answer Sheets Per Student drop down is disabled
		Assert.assertTrue(isEnabled(ps.anssheetperstu_drp), "Answer Sheets Per Student dropdown is enabled");

		// Assert the Peer Review Reward Score text box is disabled
		Assert.assertTrue(isEnabled(pr.PRreward_txtbox), "Peer Review Reward Scoretextbox is enabled");

		// Assert the Answer Sheets Per Student dropdwon count is 1
		Assert.assertEquals(getText(ps.anssheetperstu_drpval).trim(), "1");

		// Click on Answer Sheets Per Student
		click(ps.anssheetperstu_drp);
		waitThread(2000);

		// Assert the Answer Sheets Per Student drop down is visible
		Assert.assertTrue(isElementPresent(ps.anssheetperstu_drplist), "Answer Sheets Per Student dropdown is present");

		// To check the Total no.of rows count is 1
		Assert.assertEquals(TotalElementsCount(ps.anssheetperstu_drpcount), 1);

	}

	/*
	 * To verify the students details on the grid and check the grid count
	 */
	@Test(priority = 16)
	public void TCSPR090816() {

		// Assert the Answer sheets to be assigned to the Peer Reviewer having 1
		// column
		// only
		Assert.assertEquals(TotalElementsCount(ps.studant1_columncount), 1);

		// Assert the first student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Studentname);

		// Assert the second student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Studentname2);

		String name1 = getText(ps.studantname1_gridval);
		String name2 = getText(ps.studantname2_gridval);

		// Assert that the student names are not repeating in the first row
		Assert.assertNotEquals(getText(ps.studant1_column1), name1);

		// Assert that the student names are not repeating in the second row
		Assert.assertNotEquals(getText(ps.studant2_column1), name2);

	}

	/*
	 * To add a new student from course roster page
	 */
	@Test(priority = 17)
	public void TCSPR090817() {

		Emailstudent3 = "student3" + generateRandomNumber().trim() + "@gmail.com";

		// click on course tab
		click(ba.CourseTab);

		waitThread(2000);

		// click on details button dropdown
		click(cn.btn_details_1);

		waitThread(3000);

		// verify link course roster
		waitFor(cr.link_courseroster);
		Assert.assertEquals(getText(cr.link_courseroster), "View/Modify Student Roster");

		// click on course roster link
		click(cr.link_courseroster);
		waitThread(2000);

		// click on Add students button
		click(cr.btn_Addstudents);
		waitThread(2000);

		// verify the pop up visible
		Assert.assertTrue(isElementPresent(cr.Addstudents_window), "Add Students window not visible");

		// type email and verify email on the chip
		type(cr.chip_1, Emailstudent3 + ",");
		Assert.assertEquals(getText(cr.Emailchip_1), Emailstudent3);

		driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);

		// click on Add to list button
		click(cr.Addtolist_btn);

		waitThread(3000);

		// click on Send request button
		click(cr.btn_previewsendrequest);
		waitFor(cr.toaster);

		// verify toaster message
		Assert.assertEquals(getText(cr.toaster), "Successfully sent email(s)");

		waitThread(3000);
	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 18)
	public void TCSPR090818() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on 3rd student's profile and
	 * accept course request
	 */
	@Test(priority = 19)
	public void TCSPR090819() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent3, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname3 = "Clara";
		Studentlastname3 = "April";
		Studentname3 = Studentfirstname3 + " " + Studentlastname3;

		// click first name
		click(sp.txtbxFirstN);

		// type first name
		type(sp.txtbxFirstN, Studentfirstname3);

		// click last name
		click(sp.txtbxLastN);

		// type last name
		type(sp.txtbxLastN, Studentlastname3);

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
	@Test(priority = 20)
	public void TCSPR090820() {

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
	 * To load the peer review page and verify the student count and grid labels
	 * and dropdowns are enable
	 */
	@Test(priority = 21)
	public void TCSPR090821() {

		rs.login_Teacher(Emailteacher, password);

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(2000);

		// click draft tab
		click(pr.draft_tab);
		waitThread(2000);

		// Assert the tab name:Draft
		Assert.assertEquals(getText(pr.draft_lbl).trim(), "Draft");

		// *Assert the assessment name on the grid
		Assert.assertEquals(getText(pr.draftassessname_lbl).trim(), AssessmentName);

		click(pr.continueedit_button);
		waitThread(2000);

		// Assert the basic details wizard is selected
		Assert.assertTrue(isEnabled(pr.basicdetails_wizard), "basic details wizard is selected");

		click(pr.savennext_button);

		waitThread(4000);

		// Assert the question wizard is selected
		Assert.assertTrue(isEnabled(pr.question_wizard), "Question wizard is selected");

		click(pr.savennext_button);
		waitThread(3000);

		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");
		waitThread(2000);

		// Assert the text::Total Students : Assert the total student count is 3
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 3");

		// Assert the 3rd student name on the page[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname3_gridval).trim(), Studentname3);

		// Assert the Answer Sheets Per Student drop down is disabled
		Assert.assertTrue(isEnabled(ps.anssheetperstu_drp), "Answer Sheets Per Student dropdown is enabled");

		// Assert the Peer Review Reward Score text box is disabled
		Assert.assertTrue(isEnabled(pr.PRreward_txtbox), "Peer Review Reward Scoretextbox is enabled");

		// Assert the Answer Sheets Per Student dropdwon count is 1
		Assert.assertEquals(getText(ps.anssheetperstu_drpval).trim(), "1");

		// Click on Answer Sheets Per Student
		click(ps.anssheetperstu_drp);

		waitThread(2000);

		// Assert the Answer Sheets Per Student drop down is visible
		Assert.assertTrue(isElementPresent(ps.anssheetperstu_drplist), "Answer Sheets Per Student dropdown is present");

		// Assert dropdown values,1 and 2
		Assert.assertEquals(getText(ps.anssheetperstu_drpcount1).trim(), "1");

		Assert.assertEquals(getText(ps.anssheetperstu_drpcount2).trim(), "2");

		// Assert the dropdown have 2 option only
		Assert.assertEquals(TotalElementsCount(ps.anssheetperstu_drpcount), 2);

	}

	/*
	 * 
	 */
	@Test(priority = 22)
	public void TCSPR090822() {

		// Assert the first student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Studentname);

		// Assert the second student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Studentname2);

		// Assert the Third student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname3_gridval).trim(), Studentname3);

		String name1 = getText(ps.studantname1_gridval);
		String name2 = getText(ps.studantname2_gridval);
		String name3 = getText(ps.studantname3_gridval);

		// Assert the Answer sheets to be assigned to the Peer Reviewer having 1
		// column
		// only
		Assert.assertEquals(TotalElementsCount(ps.studant1_columncount), 1);

		// Assert that the student names are not repeating in the first row
		Assert.assertNotEquals(getText(ps.studant1_column1), name1);

		// Assert that the student names are not repeating in the second row
		Assert.assertNotEquals(getText(ps.studant2_column1), name2);
		Assert.assertNotEquals(getText(ps.studant3_column1), name3);

	}

	/*
	 * To verify the students details on the grid and check the grid count
	 * -[Answer Sheets Per Student is 2
	 */
	@Test(priority = 23)
	public void TCSPR090823() {

		waitThread(2000);

		// Select Answer Sheets Per Student is 2
		click(ps.anssheetperstu_drpcount2);
		waitThread(2000);

		// Assert the first student name on the grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Studentname);

		// Assert the second student name on the grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Studentname2);

		// Assert the Third student name on the grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname3_gridval).trim(), Studentname3);

		String name1 = getText(ps.studantname1_gridval);
		String name2 = getText(ps.studantname2_gridval);
		String name3 = getText(ps.studantname3_gridval);

		// Assert the Answer sheets to be assigned to the Peer Reviewer having 2
		// columns
		Assert.assertEquals(TotalElementsCount(ps.studant1_columncount), 2);

		String Name1 = getText(ps.studant1_column1);
		// Assert that the student names are not repeating in the first raw row
		Assert.assertNotEquals(getText(ps.studant1_column1), name1);
		Assert.assertNotEquals(getText(ps.studant1_column2), Name1);
		Assert.assertNotEquals(getText(ps.studant1_column2), name1);

		String Name2 = getText(ps.studant2_column1);
		// Assert that the student names are not repeating in the second row
		Assert.assertNotEquals(getText(ps.studant2_column1), name2);
		Assert.assertNotEquals(getText(ps.studant2_column2), Name2);
		Assert.assertNotEquals(getText(ps.studant2_column2), name2);

		String Name3 = getText(ps.studant3_column1);
		// Assert that the student names are not repeating in the third row
		Assert.assertNotEquals(getText(ps.studant3_column1), name3);
		Assert.assertNotEquals(getText(ps.studant3_column2), Name3);
		Assert.assertNotEquals(getText(ps.studant3_column2), name3);

	}
	/*
	 * To add a new student from course roster page
	 */

	@Test(priority = 24)
	public void TCSPR090824() {

		Emailstudent4 = "student4" + generateRandomNumber().trim() + "@gmail.com";

		// click on course tab
		click(ba.CourseTab);

		waitThread(2000);
		// click on course tab
		click(ps.alertdiscard_btn);

		waitThread(2000);

		// click on details button dropdown
		click(cn.btn_details_1);

		waitThread(3000);

		// verify link course roster
		waitFor(cr.link_courseroster);
		Assert.assertEquals(getText(cr.link_courseroster), "View/Modify Student Roster");

		// click on course roster link
		click(cr.link_courseroster);
		waitThread(2000);

		// click on Add students button
		click(cr.btn_Addstudents);
		waitThread(2000);

		// verify the pop up visible
		Assert.assertTrue(isElementPresent(cr.Addstudents_window), "Add Students window not visible");

		type(cr.chip_1, Emailstudent4 + ",");
		driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);

		Assert.assertEquals(getText(cr.Emailchip_1), Emailstudent4);

		// click on Add to list button
		click(cr.Addtolist_btn);

		waitThread(3000);

		// click on Send request button
		click(cr.btn_previewsendrequest);
		waitFor(cr.toaster);

		// verify toaster message
		Assert.assertEquals(getText(cr.toaster), "Successfully sent email(s)");
		click(QP.toasterclosebtn);
		waitThread(3000);

	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 25)
	public void TCSPR090825() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	/*
	 * To check that invited course request visible on fourth student's profile
	 * and accept course request
	 */
	@Test(priority = 26)
	public void TCSPR090826() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent4, CourseID);
		String encText = et.EncryptCode(studentinviteid);
		driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);

		// Text-As individual Student
		// Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname4 = "Eby";
		Studentlastname4 = "Thomas";
		Studentname4 = Studentfirstname4 + " " + Studentlastname4;

		// click first name
		click(sp.txtbxFirstN);

		// type first name
		type(sp.txtbxFirstN, Studentfirstname4);

		// click last name
		click(sp.txtbxLastN);

		// type last name
		type(sp.txtbxLastN, Studentlastname4);

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
	@Test(priority = 27)
	public void TCSPR090827() {

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
	 * To load the peer review page and verify the student count and grid labels
	 * and dropdowns are enable
	 */
	@Test(priority = 28)
	public void TCSPR090828() {

		rs.login_Teacher(Emailteacher, password);

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(2000);

		// click draft tab
		click(pr.draft_tab);
		waitThread(2000);

		// Assert the tab name:Draft
		Assert.assertEquals(getText(pr.draft_lbl).trim(), "Draft");

		// *Assert the assessment name on the grid
		Assert.assertEquals(getText(pr.draftassessname_lbl).trim(), AssessmentName);

		// click continue edit button
		click(pr.continueedit_button);
		waitThread(2000);

		// Assert the Basic details wizard is selected
		Assert.assertTrue(isEnabled(pr.basicdetails_wizard), "Basic details wizard is selected");

		// Click on save and next button
		click(pr.savennext_button);

		waitThread(4000);

		// Assert the question wizard is selected
		Assert.assertEquals(getAttribute(pr.question_wizard2, "aria-selected"), "true");

		// Click on save and next button
		click(pr.savennext_button);

		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");
		waitThread(2000);

		// Assert the text::Total Students : Assert the total student count is 4
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 4");

		// Assert the 4th student name on the page[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname4_gridval).trim(), Studentname4);

		// Assert the Answer Sheets Per Student drop down is disabled
		Assert.assertTrue(isEnabled(ps.anssheetperstu_drp), "Answer Sheets Per Student dropdown is enabled");

		// Assert the Peer Review Reward Score text box is enabled
		Assert.assertTrue(isEnabled(pr.PRreward_txtbox), "Peer Review Reward Scoretextbox is enabled");

		// Assert the Answer Sheets Per Student dropdwon count is 1
		Assert.assertEquals(getText(ps.anssheetperstu_drpval).trim(), "1");

		// Click on Answer Sheets Per Student
		click(ps.anssheetperstu_drp);

		waitThread(2000);
		// Assert the Answer Sheets Per Student drop down is visible
		Assert.assertTrue(isElementPresent(ps.anssheetperstu_drplist), "Answer Sheets Per Student dropdown is present");

		// Assert dropdown values,1 ,2 and 3
		Assert.assertEquals(getText(ps.anssheetperstu_drpcount1).trim(), "1");

		Assert.assertEquals(getText(ps.anssheetperstu_drpcount2).trim(), "2");

		Assert.assertEquals(getText(ps.anssheetperstu_drpcount3).trim(), "3");

		// Assert the dropdown have 3 option only
		Assert.assertEquals(TotalElementsCount(ps.anssheetperstu_drpcount), 3);

	}

	/*
	 * To verify the students details on the grid and check the grid
	 * count[Answer Sheets Per Student is 1
	 */
	@Test(priority = 29)
	public void TCSPR090829() {

		// Assert the Answer sheets to be assigned to the Peer Reviewer having 1
		// column
		// only
		Assert.assertEquals(TotalElementsCount(ps.studant1_columncount), 1);

		// Assert the first student name on the grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Studentname);

		// Assert the first student name on the grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Studentname2);

		// Assert the first student name on the grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname3_gridval).trim(), Studentname3);

		// Assert the first student name on the grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname4_gridval).trim(), Studentname4);

		String name1 = getText(ps.studantname1_gridval);
		String name2 = getText(ps.studantname2_gridval);
		String name3 = getText(ps.studantname3_gridval);

		String name4 = getText(ps.studantname4_gridval);

		// Assert that the student names are not repeating in the first row
		Assert.assertNotEquals(getText(ps.studant1_column1), name1);

		// Assert that the student names are not repeating in the second row
		Assert.assertNotEquals(getText(ps.studant1_column1), name2);

		// Assert that the student names are not repeating in the second row
		Assert.assertNotEquals(getText(ps.studant3_column1), name3);

		// Assert that the student names are not repeating in the second row
		Assert.assertNotEquals(getText(ps.studant4_column1), name4);

	}

	/*
	 * To perform save and exit functionality from peer review page and repeat
	 * the steps on the TCSPR090828
	 */
	@Test(priority = 30)
	public void TCSPR090830() {

		click(pr.PRreward_txtbox);
		driver.findElement(By.xpath(pr.PRreward_txtbox)).sendKeys(Keys.BACK_SPACE);
		waitThread(3000);

		// Click on save and next button
		click(pr.savennext_button);

		waitFor(QP.toaster);
		// Assert the toaster

		Assert.assertEquals(getText(QP.toaster), "Please enter the Peer Review Reward Percentage");

		click(QP.toasterclosebtn);

		// Click on save and exit button
		click(pr.savenexit_button);

		waitFor(QP.toaster);
		// Assert the toaster

		Assert.assertEquals(getText(QP.toaster), "Please enter the Peer Review Reward Percentage");

		click(QP.toasterclosebtn);

		// Type peer review reward score
		type(pr.PRreward_txtbox, "0");

		click(pr.totalstudent_lbl);

		Assert.assertEquals(getText(ps.rew_val).trim(), "Must be greater than 0");

		// Click on save and next button
		click(pr.savennext_button);

		waitFor(QP.toaster);
		// Assert the toaster
		Assert.assertTrue(getText(QP.toaster).contains("Peer Review Reward percentage must be greater than 0"));

		click(QP.toasterclosebtn);

		// Click on save and exit button
		click(pr.savenexit_button);

		waitFor(QP.toaster);
		// Assert the toaster
		Assert.assertTrue(getText(QP.toaster).contains("Peer Review Reward percentage must be greater than 0"));

		click(QP.toasterclosebtn);

		// Type peer review reward score
		type(pr.PRreward_txtbox, "1500");

		click(pr.totalstudent_lbl);

		Assert.assertEquals(getText(ps.rew_val).trim(), "Must be less than or equal to 100");

		waitThread(1000);

		// Click on save and next button
		click(pr.savennext_button);

		waitFor(QP.toaster);
		// Assert the toaster
		Assert.assertTrue(
				getText(QP.toaster).contains("Peer Review Reward percentage must be less than or equal to 100"));

		click(QP.toasterclosebtn);

		// Click on save and exit button
		click(pr.savenexit_button);
		waitThread(2000);
		waitFor(QP.toaster);
		// Assert the toaster
		Assert.assertTrue(
				getText(QP.toaster).contains("Peer Review Reward percentage must be less than or equal to 100"));

		click(QP.toasterclosebtn);

		waitThread(2000);

		// Type peer review reward score
		type(pr.PRreward_txtbox, "1");

		waitThread(2000);
		// Click on save and exit button
		click(pr.savenexit_button);
		waitThread(1000);

		// Assert the tab name:Draft
		Assert.assertEquals(getText(pr.draft_lbl).trim(), "Draft");

		// click continue edit button
		click(pr.continueedit_button);
		waitThread(1000);

		// Click on save and next button
		click(pr.savennext_button);

		waitThread(1000);

		// Click on save and next button
		click(pr.savennext_button);

		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");
		waitThread(2000);
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 4");

		// Assert the Answer Sheets Per Student dropdwon count is 3
		Assert.assertEquals(getText(ps.anssheetperstu_drpval).trim(), "1");

		// *Assert the peer review score 1 on the grid
		Assert.assertEquals(getValue(pr.PRreward_txtbox), "1");

		// Assert the Answer Sheets Per Student drop down is disabled
		Assert.assertTrue(isEnabled(ps.anssheetperstu_drp), "Answer Sheets Per Student dropdown is enabled");

		click(ps.anssheetperstu_drp);

		waitThread(2000);
		// Assert the Answer Sheets Per Student drop down is disabled
		Assert.assertTrue(isElementPresent(ps.anssheetperstu_drplist), "Answer Sheets Per Student dropdown is present");

		//
		Assert.assertEquals(getText(ps.anssheetperstu_drpcount1).trim(), "1");

		Assert.assertEquals(getText(ps.anssheetperstu_drpcount2).trim(), "2");

		Assert.assertEquals(getText(ps.anssheetperstu_drpcount3).trim(), "3");

		// Assert the Answer Sheets Per Student dropdwon count is 3
		Assert.assertEquals(TotalElementsCount(ps.anssheetperstu_drpcount), 3);

	}

	/*
	 * To verify the students details onthe grid and check the grid
	 * count-[Answer Sheets Per Studentis 2
	 */
	@Test(priority = 31)
	public void TCSPR090831() {

		// Select Answer Sheets Per Student is 2
		click(ps.anssheetperstu_drpcount2);
		waitThread(2000);

		// Assert the Answer sheets to be assigned to the Peer Reviewer having 2
		// columns
		Assert.assertEquals(TotalElementsCount(ps.studant1_columncount), 2);

		// *Assert the first student name on the grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Studentname);

		// *Assert the 2nd student name on the grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Studentname2);

		// *Assert the 3rd student name on the grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname3_gridval).trim(), Studentname3);

		// *Assert the 4th student name on the grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname4_gridval).trim(), Studentname4);

		String name1 = getText(ps.studantname1_gridval);
		String name2 = getText(ps.studantname2_gridval);
		String name3 = getText(ps.studantname3_gridval);
		String name4 = getText(ps.studantname4_gridval);

		// Assert the Answer sheets to be assigned to the Peer Reviewer having 2
		// columns
		Assert.assertEquals(TotalElementsCount(ps.studant1_columncount), 2);

		// Assert that the student names are not repeating in the 1st row
		Assert.assertEquals(TotalElementsCount(ps.studant1_columncount), 2);

		Assert.assertNotEquals(getText(ps.studant1_column1), name1);
		String Name1 = getText(ps.studant1_column1);

		Assert.assertNotEquals(getText(ps.studant1_column2), Name1);
		Assert.assertNotEquals(getText(ps.studant1_column2), name1);

		// Assert that the student names are not repeating in the second row
		Assert.assertNotEquals(getText(ps.studant2_column1), name2);
		String Name2 = getText(ps.studant2_column1);
		Assert.assertNotEquals(getText(ps.studant2_column2), Name2);
		Assert.assertNotEquals(getText(ps.studant2_column2), name2);

		// Assert that the student names are not repeating in the 3rd row
		Assert.assertNotEquals(getText(ps.studant3_column1), name3);

		String Name3 = getText(ps.studant3_column1);
		Assert.assertNotEquals(getText(ps.studant3_column2), Name3);
		Assert.assertNotEquals(getText(ps.studant3_column2), name3);

		// Assert that the student names are not repeating in the 4th row
		Assert.assertNotEquals(getText(ps.studant4_column1), name4);
		String Name4 = getText(ps.studant4_column1);

		Assert.assertNotEquals(getText(ps.studant4_column2), Name4);
		Assert.assertNotEquals(getText(ps.studant4_column2), name4);
	}

	/*
	 * To perform save and exitfunctionality from peer review page and repeat
	 * the steps on the
	 */
	@Test(priority = 32)
	public void TCSPR090832() {

		// Type peer review reward score
		type(pr.PRreward_txtbox, "2");

		waitThread(2000);
		// Click on save and next button
		click(pr.savenexit_button);
		waitThread(1000);

		// Assert the tab name:Draft
		Assert.assertEquals(getText(pr.draft_lbl).trim(), "Draft");

		// click continue edit button
		click(pr.continueedit_button);
		waitThread(1000);

		// Click on save and next button
		click(pr.savennext_button);

		waitThread(2000);

		// Click on save and next button
		click(pr.savennext_button);

		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");
		waitThread(3000);

		// Assert the count::Total Students : 4
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 4");

		// *Assert the Answer Sheets Per Student dropdown count is 2
		Assert.assertEquals(getText(ps.anssheetperstu_drpval).trim(), "2");

		// Assert the peer review score 2 on the grid
		Assert.assertEquals(getValue(pr.PRreward_txtbox), "2");

		// Assert the first student name on the grid
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Studentname);

		// Assert the 2nd student name on the grid
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Studentname2);

		// Assert the 3rd student name on the grid
		Assert.assertEquals(getText(ps.studantname3_gridval).trim(), Studentname3);

		// Assert the first student name on the grid
		Assert.assertEquals(getText(ps.studantname4_gridval).trim(), Studentname4);

		String name1 = getText(ps.studantname1_gridval);
		String name2 = getText(ps.studantname2_gridval);
		String name3 = getText(ps.studantname3_gridval);

		String name4 = getText(ps.studantname4_gridval);
		Assert.assertEquals(TotalElementsCount(ps.studant1_columncount), 2);

		// Assert that the student names are not repeating in the first row
		Assert.assertNotEquals(getText(ps.studant1_column1), name1);

		// Assert that the student names are not repeating in the second row
		Assert.assertNotEquals(getText(ps.studant1_column1), name2);

		// Assert that the student names are not repeating in the 3rd row
		Assert.assertNotEquals(getText(ps.studant3_column1), name3);

		// Assert that the student names are not repeating in the 4th row
		Assert.assertNotEquals(getText(ps.studant4_column1), name4);

	}

	/*
	 * To verify the students details on the grid and check the grid
	 * count-[Answer Sheets Per Student] is 3
	 */
	@Test(priority = 33)
	public void TCSPR090833() {

		// Click on Answer Sheets Per Studendropdwon
		click(ps.anssheetperstu_drp);

		// Select Answer Sheets Per Student is 3
		waitThread(2000);
		click(ps.anssheetperstu_drpcount3);
		waitThread(2000);

		// Assert the Answer sheets to be assigned to the Peer Reviewer having 3
		// columns
		Assert.assertEquals(TotalElementsCount(ps.studant1_columncount), 3);

		// Assert the all 4 student name on the grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Studentname);
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Studentname2);

		Assert.assertEquals(getText(ps.studantname3_gridval).trim(), Studentname3);
		Assert.assertEquals(getText(ps.studantname4_gridval).trim(), Studentname4);

		String name1 = getText(ps.studantname1_gridval);
		String name2 = getText(ps.studantname2_gridval);
		String name3 = getText(ps.studantname3_gridval);
		String name4 = getText(ps.studantname4_gridval);

		// Assert that the student names are not repeating in the 1st row
		Assert.assertNotEquals(getText(ps.studant1_column1), name1);
		String Name1 = getText(ps.studant1_column1);

		Assert.assertNotEquals(getText(ps.studant1_column2), Name1);
		Assert.assertNotEquals(getText(ps.studant1_column2), name1);
		String Stname1 = getText(ps.studant1_column2);

		Assert.assertNotEquals(getText(ps.studant1_column3), Stname1);
		Assert.assertNotEquals(getText(ps.studant1_column3), name1);

		// Assert that the student names are not repeating in the second row
		Assert.assertNotEquals(getText(ps.studant2_column1), name2);
		String Name2 = getText(ps.studant2_column1);

		Assert.assertNotEquals(getText(ps.studant2_column2), Name2);
		Assert.assertNotEquals(getText(ps.studant2_column2), name2);

		String Stname2 = getText(ps.studant2_column2);
		Assert.assertNotEquals(getText(ps.studant2_column3), Stname2);
		Assert.assertNotEquals(getText(ps.studant2_column3), name2);

		// Assert that the student names are not repeating in the 3rd row

		Assert.assertNotEquals(getText(ps.studant3_column1), name3);
		String Name3 = getText(ps.studant3_column1);

		Assert.assertNotEquals(getText(ps.studant3_column2), Name3);
		Assert.assertNotEquals(getText(ps.studant3_column2), name3);

		String Stname3 = getText(ps.studant3_column2);
		Assert.assertNotEquals(getText(ps.studant3_column3), Stname3);
		Assert.assertNotEquals(getText(ps.studant3_column3), name3);

		// Assert that the student names are not repeating in the 4th row
		Assert.assertNotEquals(getText(ps.studant4_column1), name4);
		String Name4 = getText(ps.studant4_column1);

		Assert.assertNotEquals(getText(ps.studant4_column2), Name4);
		Assert.assertNotEquals(getText(ps.studant4_column2), name4);

		String Stname4 = getText(ps.studant4_column2);
		Assert.assertNotEquals(getText(ps.studant4_column3), Stname4);
		Assert.assertNotEquals(getText(ps.studant4_column3), name4);
	}

	/*
	 * To perform save and exit functionality from peer review page and repeat
	 * the steps on the
	 */
	@Test(priority = 34)
	public void TCSPR090834() {

		// Type peer review reward score
		type(pr.PRreward_txtbox, "1");

		waitThread(2000);
		// Click on save and next button
		click(pr.savenexit_button);
		waitThread(1000);

		// Assert the tab name:Draft
		Assert.assertEquals(getText(pr.draft_lbl).trim(), "Draft");

		// click continue edit button
		click(pr.continueedit_button);
		waitThread(1000);

		// Click on save and next button
		click(pr.savennext_button);

		waitThread(1000);

		// Click on save and next button
		click(pr.savennext_button);

		waitThread(1000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");
		waitThread(3000);
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 4");

		Assert.assertEquals(getText(ps.anssheetperstu_drpval).trim(), "3");

		// *Assert the peer review score 1 on the grid
		Assert.assertEquals(getValue(pr.PRreward_txtbox), "1");

		// Assert the Answer Sheets Per Student drop down is disabled
		Assert.assertTrue(isEnabled(ps.anssheetperstu_drp), "Answer Sheets Per Student dropdown is enabled");

		// click Answer Sheets Per Student drop down
		click(ps.anssheetperstu_drp);

		waitThread(2000);
		// Assert the Answer Sheets Per Student drop down is disabled
		Assert.assertTrue(isElementPresent(ps.anssheetperstu_drplist), "Answer Sheets Per Student dropdown is present");

		// Assert dropdown values,1 and 2,3
		Assert.assertEquals(getText(ps.anssheetperstu_drpcount1).trim(), "1");

		Assert.assertEquals(getText(ps.anssheetperstu_drpcount2).trim(), "2");

		Assert.assertEquals(getText(ps.anssheetperstu_drpcount3).trim(), "3");

		// Assert the Answer Sheets Per Student dropdwon count is 3
		Assert.assertEquals(TotalElementsCount(ps.anssheetperstu_drpcount), 3);

	}

	/*
	 * To perform create new course functionality and To change the course from
	 * the draft page
	 */
	@Test(priority = 35)
	public void TCSPR090835() {

		// Type peer review reward score
		type(pr.PRreward_txtbox, "2");

		click(ba.btndiscard);
		Assert.assertTrue(isElementPresent(ba.Confirm_discardpopup), "Confirmation Popup not visible");

		waitThread(1000);
		waitFor(ba.Confirm_txtpopup);
		Assert.assertEquals(getText(ba.Confirm_txtpopup),
				"Are you sure you want to proceed with your action?\n"
						+ "We detected you have made changes to the information on this screen and if you ‘Discard’ these changes will not be saved.",
				"Assertion failed");

		// Confirmation popup yes button
		click(ba.Confirm_btnNo);

		click(ba.btndiscard);
		Assert.assertTrue(isElementPresent(ba.Confirm_discardpopup), "Confirmation Popup not visible");

		waitThread(1000);
		waitFor(ba.Confirm_txtpopup);
		Assert.assertEquals(getText(ba.Confirm_txtpopup),
				"Are you sure you want to proceed with your action?\n"
						+ "We detected you have made changes to the information on this screen and if you ‘Discard’ these changes will not be saved.",
				"Assertion failed");

		// Confirmation popup yes button
		click(ba.Confirm_btnYes);

		// Assert the tab name:Draft
		Assert.assertEquals(getText(pr.draft_lbl).trim(), "Draft");

		// click continue edit button
		click(pr.continueedit_button);
		waitThread(1000);

		// Click on save and next button
		click(pr.savennext_button);

		waitThread(2000);

		// Click on save and next button
		click(pr.savennext_button);

		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");
		waitThread(3000);

		// click on course tab
		click(ba.CourseTab);

		waitThread(2000);

		// click(ps.alertdiscard_btn);
		// waitThread(2000);
		CourseNamenew = "Course Namenew" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID1 = (getText(cn.course_Id));

		// type-Course title
		type(cn.txbx_Coursetitle, CourseNamenew);

		// click on Add students button
		click(cn.btn_AddStudents);

		Emailstudent5 = "student5" + generateRandomNumber().trim() + "@gmail.com";
		Emailstudent6 = "student6" + generateRandomNumber().trim() + "@gmail.com";

		// type invalid email
		type(cn.tab_textbox, Emailstudent5 + ",");
		driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
		type(cn.tab_textbox, Emailstudent6 + ",");
		// verify email present on the text box
		Assert.assertEquals(cn.emailvalue(0), Emailstudent5);

		Assert.assertEquals(cn.emailvalue(1), Emailstudent6);

		// click on add to list button
		click(cn.tab_btn_Addtolist);

		waitThread(2000);
		waitFor(cr.emailval_1);

		// verify the Email on the New Students to be invited to this class box
		Assert.assertEquals(getText(cr.emailval_1), Emailstudent5);
		Assert.assertEquals(getText(ps.emailval_2), Emailstudent6);

		// click on create course button
		click(cn.btn_Createcourse);

		waitThread(1000);
		waitFor(cn.toaster);

		// verify toaster-Course created successfully
		Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");

	}

	/*
	 * To check that the changed course name visibled on the peer review page
	 */
	@Test(priority = 36)
	public void TCSPR090836() {

		waitThread(1000);
		waitFor(ba.Assessmenttab);
		// click on Assessment tab

		click(ba.Assessmenttab);
		waitThread(2000);

		// click draft tab
		click(pr.draft_tab);
		waitThread(1000);

		// Click on continue edit button
		click(pr.continueedit_button);
		waitThread(2000);

		// Assert the basic detals wizard is selected
		Assert.assertTrue(isEnabled(pr.basicdetails_wizard), "basic details wizard is selected");

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(pr.course_drp3);

		// verify the course title
		Assert.assertEquals(getText(pr.course_drp3).trim(), CourseNamenew.trim());

		// Select newly added course
		click(pr.course_drp3);
		waitThread(2000);

		// Click on save &next button
		click(pr.savennext_button);
		click(QP.toasterclosebtn);

		waitThread(1000);

		// Assert the question wizard is selected
		Assert.assertTrue(isEnabled(pr.question_wizard), "question wizard is selected");

		// Click on save &next button
		click(pr.savennext_button);

		waitThread(3000);
		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the newly selected course name visible on the page
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseNamenew.trim()));

		// Click on save and next button
		click(pr.savennext_button);
		waitThread(1000);
		waitFor(pr.PRsavenext_toaster);

		// Assert text 'A minimum of 2 students are required to perform Peer
		// Review'
		Assert.assertEquals(
				getText(pr.PRsavenext_toaster),"Warning\n"+
"This course does not have any students in its roster. A minimum of 2 students \n"+ 
 " are required to perform Peer Review");
		click(QP.toasterclosebtn);
		waitThread(2000);

		// Assert label
		Assert.assertEquals(getText(pr.Noreviewer_gridlbl).trim(), "No Reviewer(s) Found");

		waitThread(1000);
	}

	/*
	 * To perform logout functionality on the teacher profile
	 */
	@Test(priority = 37)
	public void TCSPR090837() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on fifth student's profile
	 * and accept course request
	 */
	@Test(priority = 38)
	public void TCSPR090838() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent5, CourseID1);
		String encText = et.EncryptCode(studentinviteid);
		driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);

		// Text-As individual Student
		// Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname5 = "Grig";
		Studentlastname5 = "Chris";
		Studentname5 = Studentfirstname5 + " " + Studentlastname5;

		// click first name
		click(sp.txtbxFirstN);

		// type first name
		type(sp.txtbxFirstN, Studentfirstname5);

		// click last name
		click(sp.txtbxLastN);

		// type last name
		type(sp.txtbxLastN, Studentlastname5);

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
		Assert.assertEquals(getText(rs.course_name).trim(), CourseNamenew.trim());

	}

	/*
	 * To Accept course and perform logout functionality on the student profile
	 */
	@Test(priority = 39)
	public void TCSPR090839() {

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
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseNamenew.trim());
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * To check that invited course request visible on fifth student's profile
	 * and accept course request
	 */
	@Test(priority = 40)
	public void TCSPR090840() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent6, CourseID1);
		String encText = et.EncryptCode(studentinviteid);
		driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname6 = "Lini";
		Studentlastname6 = "Christin";
		Studentname6 = Studentfirstname6 + " " + Studentlastname6;

		// click first name
		click(sp.txtbxFirstN);

		// type first name
		type(sp.txtbxFirstN, Studentfirstname6);

		// click last name
		click(sp.txtbxLastN);

		// type last name
		type(sp.txtbxLastN, Studentlastname6);

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
		Assert.assertEquals(getText(rs.course_name).trim(), CourseNamenew.trim());

	}

	/*
	 * To Accept course and perform logout functionality on the student profile
	 */
	@Test(priority = 41)
	public void TCSPR090841() {

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
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseNamenew.trim());
		waitThread(3000);

		// perform logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

	/*
	 * 
	 */
	@Test(priority = 42)
	public void TCSPR090842() {

		rs.login_Teacher(Emailteacher, password);

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(2000);

		// click draft tab
		click(pr.draft_tab);
		waitThread(2000);

		// Assert the tab name:Draft
		Assert.assertEquals(getText(pr.draft_lbl).trim(), "Draft");

		// *Assert the assessment name on the grid
		Assert.assertEquals(getText(pr.draftassessname_lbl).trim(), AssessmentName);

		// click continue edit button
		click(pr.continueedit_button);
		waitThread(1000);

		// Assert the Basic details wizard is selected
		Assert.assertTrue(isEnabled(pr.basicdetails_wizard), "Basic details wizard is selected");

		waitThread(2000);
		// Click on save and next button
		click(pr.savennext_button);

		waitThread(3000);
		// Assert the question wizard is selected
		Assert.assertTrue(isEnabled(pr.question_wizard), "Question wizard is selected");

		// Click on save and next button
		click(pr.savennext_button);

		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");

		// Assert student name on grid
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Studentname6);

		// Assert the Answer Sheets Per Student drop down is disabled
		Assert.assertTrue(isEnabled(ps.anssheetperstu_drp), "Answer Sheets Per Student dropdown is enabled");

		// Assert the Peer Review Reward Score text box is disabled
		Assert.assertTrue(isEnabled(pr.PRreward_txtbox), "Peer Review Reward Scoretextbox is enabled");

		// *Assert the Answer Sheets Per Student dropdwon count is 1
		Assert.assertEquals(getText(ps.anssheetperstu_drpval).trim(), "1");

		// Click on Answer Sheets Per Student
		click(ps.anssheetperstu_drp);

		waitThread(2000);
		// Assert the Answer Sheets Per Student drop down is disabled
		Assert.assertTrue(isElementPresent(ps.anssheetperstu_drplist), "Answer Sheets Per Student dropdown is present");

		// Assert the dropdown have 1 option only
		Assert.assertEquals(getText(ps.anssheetperstu_drpcount1).trim(), "1");

		// *Assert the Answer sheets to be assigned to the Peer Reviewer having
		// 1 column
		// only
		Assert.assertEquals(TotalElementsCount(ps.anssheetperstu_drpcount), 1);

	}

	/*
	 * To verify the students details on the grid and check the grid
	 * count-Should check if the students of the new course are there
	 */
	@Test(priority = 43)
	public void TCSPR090843() {

		// *Assert the Answer sheets to be assigned to the Peer Reviewer having
		// 1 column
		// only
		Assert.assertEquals(TotalElementsCount(ps.studant1_columncount), 1);

		// Assert the fifth student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Studentname5);

		// Assert the 6th student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Studentname6);

		String name1 = getText(ps.studantname1_gridval);
		String name2 = getText(ps.studantname2_gridval);

		// Assert that the student names are not repeating in the first row
		Assert.assertNotEquals(getText(ps.studant1_column1), name1);

		// Assert that the student names are not repeating in the second row
		Assert.assertNotEquals(getText(ps.studant2_column1), name2);

	}

	/*
	 * To perform Delete TeacherAccount functionality
	 */
	@Test(priority = 44)
	public void TCSPR090844() {

		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted teacher profile credentials
	 */
	@Test(priority = 45)
	public void TCSPR090845() {

		// login using deleted account credentials
		rs.login_Teacher(Emailteacher, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student1 Account functionality
	 */
	@Test(priority = 46)
	public void TCSPR090846() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent1, password);

		cr.DeleteAccount();
		waitThread(2000);
		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 1 profile
	 * credentials
	 */
	@Test(priority = 47)
	public void TCSPR090847() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent1, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student2 Account functionality
	 */
	@Test(priority = 48)
	public void TCSPR090848() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent2, password);

		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 2 profile
	 * credentials
	 */
	@Test(priority = 49)
	public void TCSPR090849() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent2, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student3 Account functionality
	 */
	@Test(priority = 50)
	public void TCSPR090850() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent3, password);

		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 3 profile
	 * credentials
	 */
	@Test(priority = 51)
	public void TCSPR090851() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent3, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student4 Account functionality
	 */
	@Test(priority = 52)
	public void TCSPR090852() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent4, password);

		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 4 profile
	 * credentials
	 */
	@Test(priority = 53)
	public void TCSPR090853() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent4, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student5 Account functionality
	 */
	@Test(priority = 54)
	public void TCSPR090854() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent5, password);

		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 5 profile
	 * credentials
	 */
	@Test(priority = 55)
	public void TCSPR090855() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent5, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

	/*
	 * To perform Delete student6 Account functionality
	 */
	@Test(priority = 56)
	public void TCSPR090856() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent6, password);

		cr.DeleteAccount();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

	/*
	 * To perform login functionality using deleted student 6 profile
	 * credentials
	 */
	@Test(priority = 57)
	public void TCSPR090857() {

		// login using deleted account credentials
		rs.login_Student(Emailstudent6, password);

		waitFor(lg.toaster);
		// verify toaster text
		Assert.assertEquals(getText(lg.toaster), "Enter a valid email address and password");

	}

}