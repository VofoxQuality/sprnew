package NewAssessmentOfTeacherTest;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

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
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CreateNewAssessment.Pages.SummaryQuestionsPage;
import CurrentAssessmentsforStudents.Pages.StudentResultSectionPage;
import CurrentAssessmentsforStudents.Pages.StudentTestSectionPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import NewAssessmentOfTeacherPage.TeacherResultSectionPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class RescheduleDateTest extends basePage {

	SignUpPage sp = new SignUpPage();
	LoginPage lg = new LoginPage();
	SignUpTest st = new SignUpTest();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	Databaseconnection dc = new Databaseconnection();
	CourseRosterPage cr = new CourseRosterPage();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	EncryptedText et = new EncryptedText();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	SchedulePageBasicsPage sb = new SchedulePageBasicsPage();
	SummaryBasicsPage sr = new SummaryBasicsPage();
	AssessmentPublishPopupPage ap = new AssessmentPublishPopupPage();
	TeacherResultSectionPage tr = new TeacherResultSectionPage();
	RescheduleDatesPage rd = new RescheduleDatesPage();
	TeacherPeerReviewSectionPage tp = new TeacherPeerReviewSectionPage();
	CommonMethods cm = new CommonMethods();
	SummaryQuestionsPage sq = new SummaryQuestionsPage();
	TeacherTestSectionPage tts = new TeacherTestSectionPage();
	StudentTestSectionPage st1 = new StudentTestSectionPage();

	public String AssessmentName;
	public String NewAssessmentName;
	public String newAssessmentName;
	public String newAssessmentNameone;

	public String CourseName2;

	public String NewCourseTitle;


	public String AssessmentName2;
	public String New1AssessmentName;
	public String NewCourseName;

	public String Emailstudent1;
	public String Emailstudent2;

	public String Studentfirstname;
	public String Studentlastname;
	public String Studentname;
	public String Studentfirstname2;
	public String Studentlastname2;
	public String Studentname2;


	public String Emailteacher;
	public String CourseNamenew;
	public String CourseID1;

	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	public String quest_count;
	public String assessmentduedate1;
	public String assessmentopendate1;
	public String testopentime;
	public String testduetime;
	public String peerreviewopendate1;
	public String peerreviewopentime1;
	public String peerreviewduedate1;
	public String peerreviewduetime1;
	public String resultpublishdate1;
	public String resultpublishtime1;
	public String courseNameDate;
	public String currentday;
	public String assesmentopendate2;

	/*
	 * To perform Login functionality
	 */
	@Test(priority = 1)
	public void TCSPR1000501() throws SQLException {

		/*click(lg.LoginBtn_1);

		cm.login(cm.emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");*/

		// To click on I am A teacher button
		click(sp.btn_1);

		// To fill the details on the sign up page
		Emailteacher = st.TCSPR020005();
		// To catch OTP from sending Resource
		st.TCSPR020006();

	}

	public String CourseID = cm.CourseID1;
	public String CourseName = cm.CourseName1;

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */

	@Test(priority = 2)
	public void TCSPR1000502() throws SQLException{

		CourseName = "Course Name" + generateRandomNumber().trim();

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
		driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);

		// click on add to list button
		click(cn.tab_btn_Addtolist);

		waitThread(2000);
		waitFor(cr.emailval_1);

		// verify the Email on the New Students to be invited to this class box
		Assert.assertEquals(getText(cr.emailval_1), Emailstudent1);
		Assert.assertEquals(getText(ps.emailval_2), Emailstudent2);

		// click on create course button
		click(cn.btn_Createcourse);

		waitThread(3000);

		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), CourseName.trim());

	}

	//To perform logout functionality on the teacher profile

	@Test(priority = 3)
	public void TCSPR1000503() {
		
		waitThread(2000);
		click(rs.header_dropdown);
		waitThread(2000);
		
		//Assert link Logout
		Assert.assertTrue(isElementPresent(rs.logout_link), "Logout link not visible");

		// logout functionality
		click(rs.logout_btn);
		waitThread(2000);
		
		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}
	//To check that invited course request visible on first student's profile and accept course request  -Read the student name

	@Test(priority = 4)
	public void TCSPR1000504() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent1, CourseID);

		String encText = et.EncryptCode(studentinviteid);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname = "Ashley";
		Studentlastname = "Albert";
		Studentname = Studentfirstname + " " + Studentlastname;
		waitThread(3000);
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
	// To Accept course and perform logout functionality on the student profile
	@Test(priority = 5)
	public void TCSPR1000505(){

		// click on accept course button
		click(rs.btn_acceptcourse);
		waitThread(3000);
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
	public void TCSPR1000506() throws SQLException {

		studentinviteid = dc.InviteLink(Emailstudent2, CourseID);

		String encText = et.EncryptCode(studentinviteid);
		driver.get(prop.getProperty("UrlSignUp") + encText);

		// Text-As individual Student
		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");

		Studentfirstname2 = "Ben";
		Studentlastname2 = "Max";
		Studentname2 = Studentfirstname2 + " " + Studentlastname2;
		waitThread(3000);
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

	@Test(priority = 7)
	public void TCSPR1000507() {

		// click on accept course button
		click(rs.btn_acceptcourse);
		waitThread(2000);

		// verify the confirmation popup visible
		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");

		// click on Yes button
		click(rs.popupbtn_Yes);
		waitThread(1000);

		// Toaster message
		waitFor(rs.toaster);
		Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");

		// verify the course name visibled on the enrolled section
		waitFor(rs.enrolledcoursename);
		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());

		waitThread(1000);
		// perform logout functionality
		click(rs.header_dropdown);
		waitThread(2000);
		//Assert link Logout
		Assert.assertTrue(isElementPresent(rs.logout_link), "Logout link not visible");

		// logout functionality
		click(rs.logout_btn);
		waitThread(2000);
		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");
	}


	@Test(priority = 8)
	public void TCSPR1000508() throws SQLException{
		rs.login_Teacher(Emailteacher, password);

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(2000);
		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		waitThread(3000);
		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);
		waitThread(3000);

		// To click on course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		Assert.assertEquals(getText(ba.ddcoursename1), CourseName.trim(),
				"course name not visible on the dropdown");

		click(ba.ddcoursename1);
		waitThread(2000);

		// Type Assessment Name
		click(QP.Assess_name);
		waitThread(2000);
		AssessmentName = "Assessment" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentName);

		waitThread(2000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(2000);
	}

	@Test(priority = 9)
	public void TCSPR1000509() throws SQLException{


		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(3000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), AssessmentName);

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID + ", " + CourseName.trim());




	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 10)
	public void TCSPR1000510() {

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
		waitThread(3000);

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

		// Click Save button
		click(QP.save);

		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);

		// Click + button
		click(rd.add_quest_btn);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		waitThread(2000);

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question2");

		driver.switchTo().defaultContent();

		ScrollTo_Location(QP.Qassessmentdetails);
		waitThread(3000);

		// Page scroll down
		QP.Scroll_DowntoEnd();
		waitThread(3000);

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "5");
		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully");

		click(QP.toasterclosebtn);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");
	}

	/*
	 * To verify the details on the peer review page
	 */
	@Test(priority = 11)
	public void TCSPR1000511() {
		waitThread(3000);

		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " +AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		//Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));
		waitThread(2000);
		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");
		// Type peer review reward score
		type(pr.PRreward_txtbox, "100");



	}

	public String assessmentopendate;
	public String assessmentopentime;
	public String assessmentduedate;
	public String assessmentduetime;

	public String peerreviewopendate;
	public String peerreviewopentime;
	public String peerreviewduedate;
	public String peerreviewduetime;
	public String resultpublishdate;
	public String resultpublishtime;
	public String lastdateforrecon;
	public String lasttimeforrecon;

	/*
	 * To perform the save and next functionaity from peer review page and verify
	 * the schedule page details
	 */

	@Test(priority = 12)
	public void TCSPR1000512() {


		click(pr.savennext_button);
		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);

		waitThread(2000);
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");

		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.Sbassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(sb.Sbcoursename_lbl).contains(CourseName.trim()));

		// Assert that the Assessment Open date is Today's date
		Assert.assertEquals(getValue(sb.assessmentopendate_txtbx), sb.getdate());

		waitThread(3000);

		// Set Assessment open time as upcoming time(next day)

		click(sb.assessmentopendate_txtbx);
		waitThread(2000);

		cm.ClicktomorrowDate();

		// Read date and time
		assessmentopendate = getValue(sb.assessmentopendate_txtbx);
		assessmentopentime = getValue(sb.assessmentopentime_txtbx);
		assessmentduedate = getValue(sb.assessmentduedate_txtbx);
		assessmentduetime = getValue(sb.assessmentduetime_txtbx);

		peerreviewopendate = getValue(sb.peerreviewopendate_txtbx);
		peerreviewopentime = getValue(sb.peerreviewopentime_txtbx1);
		peerreviewduedate = getValue(sb.peerreviewduedate_txtbx);
		peerreviewduetime = getValue(sb.peerreviewduetime_txtbx);
		System.out.println(peerreviewopendate);
		System.out.println(peerreviewopentime);
		System.out.println(peerreviewduedate);
		System.out.println(peerreviewduetime);

		Scroll_DowntoEnd();
		waitThread(1000);
		resultpublishdate = getValue(sb.resultpublishdate_txtbx);
		resultpublishtime = getValue(sb.resultpublishtime_txtbx);

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

	}

	/*
	 * To verify the details on the Summary page & publish the Assessment
	 */
	@Test(priority = 13)
	public void TCSPR1000513() {

		waitThread(3000);
		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(4000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sr.summarywizard, "aria-selected"), "true");

		// Assert the Text "Questions Summary"
		Assert.assertEquals(getText(sq.Summary_quest), "Questions Summary");

		quest_count = getText(sq.total_questcount);
		// Assert the total Questions count
		Assert.assertEquals(getText(sq.total_questcount), quest_count);

	}

	/*
	 * To perform Assessment publish functionality
	 */
	@Test(priority = 14)
	public void TCSPR1000514() {

		waitThread(2000);
		Assert.assertTrue(isElementPresent(tts.release_btn), "Release button not present");

		waitThread(3000);
		Assert.assertTrue(isElementPresent(tts.release_btn), "Release button not present");
		// Click on Release button
		click(tts.release_btn);

		waitFor(QP.toaster);
		// Assert toaster "Assessment published successfully
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");


		// Assert the popup visible
		Assert.assertTrue(isDisplayed(tts.release_popup), "Popup not visible");

		// Assert label "Assessment Created Successfully"
		Assert.assertEquals(getText(tts.popup_text), "Assessment Created Successfully");

		// Assert button Back to Menu
		Assert.assertTrue(isElementPresent(tts.back_to_menubutton), "Back to menu button not present");

	}

	/*
	 * To check the published Assessment card
	 */
	@Test(priority = 15)
	public void TCSPR1000515() {
		// Click Back to Menu
		click(tts.back_to_menubutton);

		waitThread(9000);

		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(ap.publish_popup), "popup not visible");
		waitThread(4000);

		// Assert the Current Assessment is selected
		Assert.assertEquals(getAttribute(ap.currentassess_tab, "aria-selected"), "true");

		// search newly created assessment
		type(rd.search_box, AssessmentName+"     ");
		waitThread(5000);

		// Assert the newly published card visible on the current assessment page
		Assert.assertTrue(isElementPresent(rd.newcard), " new assessment card not visible");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(rd.newasses_lbl), AssessmentName);

		//Assert.assertTrue(getText(rd.course_lbl).contains("For "+CourseName+" "+"("+CourseID+")"));
		Assert.assertEquals(getText(rd.course_lbl), "For" + " " + CourseName.trim() + " (" + CourseID + ")");
		//Assert.assertTrue(getText(rd.course_lbl).contains(CourseID));

	}
	/*
	 * To check the published Assessment card
	 */

	@Test(priority = 16)
	public void TCSPR1000516() {

		// Assert the tooltips of Assessment name, course name& ID
		MouseHover(tts.asses_name_card);
		Assert.assertEquals(getAttribute(tts.asses_name_card, "tooltipposition"), "top");

		MouseHover(tts.course_nameid_card);
		Assert.assertEquals(getAttribute(tts.course_nameid_card, "tooltipposition"), "bottom");

		// Assert the test upcoming status time
		Assert.assertTrue(isDisplayed(tts.time_status), "Time status not displayed");

	}

	/*
	 * To check the Reschedule date popup
	 */
	@Test(priority = 17)
	public void TCSPR1000517() {
		// Assert menu button visible
		Assert.assertTrue(isElementPresent(rd.threedot_btn), "Three dot button not present");

		// Click menu button
		click(rd.threedot_btn);

		Assert.assertTrue(isElementPresent(rd.reschedulemenu), "Reschedule Dates menu not present");

		waitThread(2000);
		Assert.assertEquals(getText(rd.reschedulemenu), "Reschedule Dates");

		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(2000);

		// Assert the Reschedule popup visible
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");

		// Assert the text Reschedule dates
		Assert.assertEquals(getText(rd.reschedyledate_lbl), "Reschedule Dates");

	}

	/*
	 * To check dates in Reschedule popup
	 */
	@Test(priority = 18)
	public void TCSPR1000518() {

		// Assert the info statements
		Assert.assertEquals(getText(rd.infotext1), "Students can answer the assessment during these dates only");
		Assert.assertEquals(getText(rd.infotext2), "Students can perform peer review during these dates only");

		// Assert the test open date & time with schedule page date time
		Assert.assertEquals(getValue(rd.assessmentopendate_txtbx), assessmentopendate);
		waitThread(2000);

		Assert.assertEquals(getValue(rd.assessmentopentime_txtbx), assessmentopentime);
		waitThread(2000);

		// Assert the test due date & time with schedule page
		Assert.assertEquals(getValue(rd.assessmentduedate_txtbx), assessmentduedate);
		waitThread(2000);

		Assert.assertEquals(getValue(rd.assessmentduetime_txtbx), assessmentduetime);
		waitThread(2000);

		// Assert the Peer Review open date & time with Schedule page
		Assert.assertEquals(getValue(rd.peerreviewopendate_txtbx), peerreviewopendate);

		Assert.assertEquals(getValue(rd.peerreviewopentime_txtbx), peerreviewopentime);

		// Assert the Peer Review due date & time with schedule page
		Assert.assertEquals(getValue(rd.peerreviewduedate_txtbx), peerreviewduedate);

		Assert.assertEquals(getValue(rd.peerreviewduetime_txtbx), peerreviewduetime);

		// Assert the Result publishing date & time with schedule page
		Assert.assertEquals(getValue(rd.resultpublishdate_txtbx), resultpublishdate);

		Assert.assertEquals(getValue(rd.resultpublishtime_txtbx), resultpublishtime);

	}

	/*
	 * To check the labels of each section
	 */
	@Test(priority = 19)
	public void TCSPR1000519() {

		// Assert labels -Test window- Assessment Open date & time- Assessment due date&
		// time
		Assert.assertEquals(getText(rd.testwindow_lbl), "Test Window");

		Assert.assertEquals(getText(rd.assessopen_lbl), "Assessment Open date and time:");
		Assert.assertEquals(getText(rd.assessdue_lbl), "Assessment Due date and time:");

		// *Assert labels-Peer Review - Peer Review Open date & time- Peer Review due
		// date& time
		Assert.assertEquals(getText(rd.peerreview_lbl), "Peer Review");
		Assert.assertEquals(getText(rd.peeropen_lbl), "Peer Review Open date and time:");
		Assert.assertEquals(getText(rd.peerdue_lbl), "Peer Review Due date and time:");

		// Assert labels Result Publishing, Result publishing date
		Assert.assertEquals(getText(rd.resultpub_lbl), "Result Publishing");
		Assert.assertEquals(getText(rd.resultpubdate_lbl), "Result publishing date:");

		// Assert these label and textboxes not viisble on the page
		// -Last date for Reconsideration Request
		Assert.assertFalse(isElementPresent(rd.lastdate_lbl), "Last date for Reconsideration Request text Visible");
		Assert.assertFalse(isElementPresent(rd.lastdate_txtbx), "Reconsideration textbox not present");

	}

	/*
	 * To check the buttons in ther popup
	 */
	@Test(priority = 20)
	public void TCSPR1000520() {

		// Assert buttons in pop up
		Assert.assertTrue(isElementPresent(rd.close_btn), "Button not present");
		Assert.assertTrue(isElementPresent(rd.cancel_btn), "Button not present");
		Assert.assertTrue(isElementPresent(rd.applychanges_btn), "Button not present");

		// Assert the apply Changes button is disable
		Assert.assertTrue(getAttribute(rd.applychanges_btn, "class").contains("p-disabled"), "Button enabled");

		// Click Cancel button
		click(rd.cancel_btn);
		//waitThread(1000);
		waitThread(3000);
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(2000);

		// click menu button
		click(rd.threedot_btn);
		waitThread(3000);

		// click reschedule date menu
		click(rd.reschedulemenu);
		waitThread(2000);

		// Assert popup visible
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");

		// ClicK Close button
		click(rd.close_btn);
		waitThread(2000);

		// Assert no popup visible
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");

	}

	/*
	 * To check the apply changes button functionality
	 */
	@Test(priority = 21)
	public void TCSPR1000521() {


		driver.findElement(By.xpath("//*[@id='searchAssessments']")).clear();

		waitThread(5000);
		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(2000);

		// click menu button
		click(rd.threedot_btn);

		waitThread(2000);
		// Assert the text Reschedule dates
		Assert.assertEquals(getText(rd.reschedulemenu), "Reschedule Dates");

		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(2000);

		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");

		// Set the Assessment open day to next day
		click(rd.assessmentopendate_txtbx);
		//click(rd.assessmentopendate_txtbx);
		waitThread(2000);
		cm.ClicktomorrowDate();
		//Doubleclick(rd.calanderdate_valtomo);
		waitThread(3000);
		assessmentopendate1 = getValue(st1.resche_testopendat_txtbx);
		assessmentduedate1 = getValue(st1.resche_testduedat_txtbx);
		testopentime = getValue(st1.resche_testopentime_txtbx);
		testduetime = getValue(st1.resche_testendtime_txtbx);

		// Assert the apply Changes button is enabled
		Assert.assertFalse(getAttribute(rd.applychanges_btn, "class").contains("p-disabled"), "Button disabled");

		// click apply Changes button
		click(rd.applychanges_btn);
		waitThread(4000);
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");

		// Assert the Test open date&time in the card with Reschedule popup
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestopen), assessmentopendate1);
		Assert.assertEquals(cm.timetestopen,testopentime);	

	}

	/*
	 * To check the cancel button functions
	 */
	@Test(priority = 22)
	public void TCSPR1000522() {

		waitThread(2000);
		driver.findElement(By.xpath("//*[@id='searchAssessments']")).clear();
		waitThread(5000);
		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(2000);

		// click menu button
		click(rd.threedot_btn);

		waitThread(2000);
		Assert.assertEquals(getText(rd.reschedulemenu), "Reschedule Dates");

		// click reshedule date
		click(rd.reschedulemenu);
		waitThread(1000);

		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");

		// Select the Test Window open date
		click(rd.assessmentopendate_txtbx);
		waitThread(3000);
		assessmentopendate = getValue(rd.assessmentopendate_txtbx);
		assessmentopentime = getValue(rd.assessmentopentime_txtbx);

		cm.ClickTodaysDate();
		//Doubleclick(rd.calanderdate_valtomo);
		waitThread(3000);




		// click cancel button
		click(rd.cancel_btn1);
		waitThread(1000);

		// Assert the confirmation popup visible
		Assert.assertTrue(isElementPresent(rd.conf_dlgbx), "confirmation popup not present");

		// click discard button
		click(rd.confdiscard_btn);
		waitThread(3000);
		//assesmentopendate2=getValue(rd.assessmentopendate_txtbx);

		// Assert popup not visible
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");

		// Assert the Test open date is next day

		currentday=cm.getdate();
		System.out.println(currentday);

		// Assert the Test open date in the card with Reschedule popup
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestopen), assessmentopendate);

		//Click Reschedule dates

		click(rd.threedot_btn);

		waitThread(2000);

		// click reshedule date
		click(rd.reschedulemenu);
		waitThread(2000);

		//*Assert the Test open date is next day
		Assert.assertEquals(getValue(rd.assessmentopendate_txtbx), assessmentopendate);

		click(rd.close_btn);
		waitThread(2000);
	}

	/*
	 * To Reschedule the test open date
	 */
	@Test(priority = 23)
	public void TCSPR1000523() {

		driver.findElement(By.xpath("//*[@id='searchAssessments']")).clear();
		waitThread(5000);
		// search newly created assessment
		type(rd.search_box, AssessmentName);

		driver.findElement(By.xpath("//*[@id='searchAssessments']")).sendKeys("  ");
		waitThread(3000);

		// click menu button
		click(rd.threedot_btn);

		waitThread(3000);
		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(2000);

		// Select the Test Window open date
		click(rd.assessmentopendate_txtbx);
		waitThread(1000);

		// Set the Assessment open date to current day
		cm.ClickTodaysDate();

		assessmentopendate1 = getValue(st1.resche_testopendat_txtbx);
		assessmentduedate1 = getValue(st1.resche_testduedat_txtbx);
		testopentime = getValue(st1.resche_testopentime_txtbx);
		testduetime = getValue(st1.resche_testendtime_txtbx);

		peerreviewopendate1 = getValue(st1.resche_testduedat_txtbx);
		peerreviewopentime1 = getValue(st1.resche_peeropen_time_txtbx);

		peerreviewduedate1 = getValue(st1.resche_peerdue_date_txtbx);
		peerreviewduetime1 = getValue(st1.resche_peerduetime_txtbx);

		resultpublishdate1 = getValue(st1.resche_resultdate_txtbx);
		resultpublishtime1 = getValue(st1.resche_resultime_txtbx);

		// click apply changes button
		click(rd.applychanges_btn);

		waitFor(QP.toaster);
		// Assert toaster "Changes applied"
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

	}

	/*
	 * To Reschedule the test open date
	 */
	@Test(priority = 24)
	public void TCSPR1000524() {
		waitThread(4000);
		driver.findElement(By.xpath("//*[@id='searchAssessments']")).clear();
		waitThread(5000);
		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(4000);

		// Assert the test open date & time of card is same as Reschedule date popup
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestopen), assessmentopendate1);
		Assert.assertEquals(cm.timetestopen,testopentime );

		// Assert the test due date & time is same card as Reschedule date popup
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestdue), assessmentduedate1);
		Assert.assertEquals(cm.timetestdue,testduetime );

		// Assert the peer review open date & time is same as Reschedule date popup
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewopen), peerreviewopendate1);
		Assert.assertEquals(cm.timereviewopen, peerreviewopentime1 );

		// Assert the peer review due date & time is same as Reschedule date popup
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewdue), peerreviewduedate1);
		Assert.assertEquals(cm.timereviewdue, peerreviewduetime1 );

		// Assert result publishing date visible on the page
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.resultdate), resultpublishdate1 );
		Assert.assertEquals(cm.resultime, resultpublishtime1 );

		// Assert the reconsideration days not visible on the page
		Assert.assertFalse(isElementPresent(tr.lastdatetime_lbl), "Reconsideration dates not visible ");

	}

	/*
	 * To Reschedule date when assessment is Pending
	 */
	@Test(priority = 25)
	public void TCSPR1000525() {
		driver.findElement(By.xpath("//*[@id='searchAssessments']")).clear();
		waitThread(5000);
		waitThread(2000);
		// search newly created assessment
		type(rd.search_box, AssessmentName);

		waitThread(2000);
		
		// Assert the Test window is Active
				Assert.assertEquals(getText(tts.test_pending), "Pending");
				waitThread(1000);

		// click menu button
		click(rd.threedot_btn);

		waitThread(1000);
		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(2000);

		// assert popup
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");

	}

	/*
	 * To Reschedule the test due date
	 */
	@Test(priority = 26)
	public void TCSPR1000526() {

		waitThread(2000);
		// Set the Assessment due date to current day
		click(rd.assessmentduedate_txtbx);
		waitThread(2000);
		
		cm.ClickTodaysDate();
		waitThread(2000);
		
		assessmentduedate1 = getValue(st1.resche_testduedat_txtbx);
		testduetime = getValue(st1.resche_testendtime_txtbx);
		
		// Click Apply Changes button
		click(rd.applychanges_btn);
		
		waitFor(QP.toaster);
		if(QP.toaster.contains("Assessment Open date should not be past date and time"))
			click(QP.toasterclosebtn);

		/*


		waitFor(QP.toaster);
		// Assert toaster "Changes applied"
		Assert.assertEquals(getText(QP.toaster), "Changes applied");*/
		click(rd.close_btn);
		waitThread(2000);

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(3000);

		// Assert the card with rescheduled date
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datetestdue), assessmentduedate1);
		Assert.assertEquals(cm.timetestdue,testduetime );

	}

	/*
	 * To Reschedule date when assessment window closed
	 */
	@Test(priority = 27)
	public void TCSPR1000527() throws InterruptedException {
		TimeUnit.SECONDS.sleep(20);
		waitThread(2000);

		// Assert the Test window is Active
		Assert.assertEquals(getText(tts.test_pending), "Active");
		waitThread(1000);

		// click menu button
		click(rd.threedot_btn);

		waitThread(3000);
		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(2000);

		// Assert the Test due date& time field is disabled
		Assert.assertFalse(getAttribute(st1.resche_testduedatetime, "class").contains("disableDiv"),
				"DateTime disabled");

	}

	/*
	 * To Reschedule the Peer review open date
	 */
	@Test(priority = 28)
	public void TCSPR1000528() {


		// Set the Peer Review open date to current day
		click(rd.peerreviewopendate_txtbx);

		waitThread(2000);
		cm.ClickTodaysDate();

		/*	waitThread(2000);
		peerreviewopendate1 = getValue(st1.resche_peeropendat_txtbx);
		peerreviewopentime1 = getValue(st1.resche_peeropen_time_txtbx);*/

		waitThread(2000);
		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitFor(QP.toaster);
		// Assert toaster "Changes applied"
		if(QP.toaster.contains("Assessment due date and Peer review open date are overlapping"))
		{
			Assert.assertEquals(getText(QP.toaster), "Assessment due date and Peer review open date are overlapping");
			click(QP.toasterclosebtn);
		}
		else 
			if(QP.toaster.contains("Changes applied"))
				click(QP.toasterclosebtn);
		waitThread(1000);
		// click cancel button
		click(rd.cancel_btn1);
		waitThread(4000);

		// Assert the confirmation popup visible
		Assert.assertTrue(isElementPresent(rd.conf_dlgbx), "confirmation popup not present");

		// click discard button
		click(rd.confdiscard_btn);
		waitThread(3000);
		//assesmentopendate2=getValue(rd.assessmentopendate_txtbx);

		// Assert popup not visible
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");

		waitThread(3000);

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(4000);

		// Assert the card with rescheduled peer review open date
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.datereviewopen), peerreviewopendate1);
		Assert.assertEquals(cm.timereviewopen, peerreviewopentime1 );


	}

	/*
	 * To Reschedule date when Peer review is active
	 */
	@Test(priority = 29)
	public void TCSPR1000529() {
		waitThread(1000);

		// click menu button
		click(rd.threedot_btn);

		waitThread(3000);
		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(3000);

		// Assert the Peer review open date& time field is not disabled
		Assert.assertFalse(getAttribute(st1.resche_reviewopendatetime, "class").contains("disableDiv"),
				"DateTime disabled");

	}

	/*
	 * To Reschedule the Peer review due date
	 */
	@Test(priority = 30)
	public void TCSPR1000530() {

		// Set the Peer Review due date to current day
		waitThread(1000);
		click(rd.close_btn);
		waitThread(2000);

		/*click(rd.peerreviewduedate_txtbx);
		//peerreviewduedate1 = getValue(st1.resche_peerdue_date_txtbx);
		//peerreviewduetime1 = getValue(st1.resche_peerduetime_txtbx);

		waitThread(3000);
		cm.ClickTodaysDate();



		waitThread(3000);
		// Click Apply Changes button
		click(rd.applychanges_btn);

		waitFor(QP.toaster);
		// Assert toaster "Changes applied"
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		waitThread(4000);

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(3000);

		// Assert the card with rescheduled date
	//	cm.datetimesplitmethod();
	//	Assert.assertEquals(cm.getdates(cm.datereviewdue), peerreviewduedate1);
		//Assert.assertEquals(cm.timereviewdue, peerreviewduetime1 );
		 */

	}

	/*
	 * To Reschedule date when Peer Review window closed
	 */
	@Test(priority = 31)
	public void TCSPR1000531() throws InterruptedException {

		// wait till the Peer review window closed
		TimeUnit.SECONDS.sleep(40);

		// Assert the Peer review window Active
		Assert.assertEquals(getText(tts.review_window_closed), "Active");
		waitThread(1000);

		// click menu button
		click(rd.threedot_btn);

		waitThread(2000);
		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(2000);

		// Assert the Peer Review due date& time field is disabled
		Assert.assertFalse(getAttribute(st1.resche_reviewduedatetime, "class").contains("disableDiv"),
				"DateTime disabled");

	}

	/*
	 * To Reschedule the Result publishing date
	 */
	@Test(priority = 32)
	public void TCSPR1000532() {
		
		// Set the Result publishing to current day
		Doubleclick(rd.resultpublishdate_txtbx);
		resultpublishdate1 = getValue(st1.resche_resultdate_txtbx);
		resultpublishtime1 = getValue(st1.resche_resultime_txtbx);
		waitThread(1000);
		cm.ClickTodaysDate();
		waitThread(2000);



		waitThread(1000);
		/*
		// Click Apply Changes button
		click(rd.applychanges_btn);
		waitThread(2000);
		waitFor(QP.toaster);
		// Assert toaster "Changes applied"
		Assert.assertEquals(getText(QP.toaster), "Changes applied");

		waitThread(3000);*/
		click(rd.cancel_btn1);
		waitThread(3000);

		// Assert the confirmation popup visible
		Assert.assertTrue(isElementPresent(rd.conf_dlgbx), "confirmation popup not present");

		// click discard button
		click(rd.confdiscard_btn);
		waitThread(3000);
		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(2000);

		// Assert the card with rescheduled date
		cm.datetimesplitmethod();
		Assert.assertEquals(cm.getdates(cm.resultdate), resultpublishdate1 );
		Assert.assertEquals(cm.resultime, resultpublishtime1 );



	}

	/*
	 * To Reschedule the result date when the Result publishing window is active
	 */
	@Test(priority = 33)
	public void TCSPR1000533() throws InterruptedException {

		waitThread(2000);
		// Assert the Peer Review window closed
		Assert.assertEquals(getText(tts.review_window_closed), "Pending");
		waitThread(1000);

		TimeUnit.MINUTES.sleep(1);

		// click menu button
		click(rd.threedot_btn);

		waitThread(1000);
		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(2000);

		// Assert the Result publishing date& time field is disabledAssert the Peer
		// Review due date& time field is disabled
		Assert.assertFalse(getAttribute(st1.resche_resultdatetime, "class").contains("disableDiv"), "DateTime disabled");

		waitThread(1000);
		// Close the reschedule popup
		Doubleclick(rd.close_btn);

		// Assert popup not visible
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "popup visible");

		waitThread(1000);
		ScrollTo_xy_position(0, 0);
	}

	/*
	 * To Create new assessment with Reconsideration Request date
	 */
	@Test(priority = 34)
	public void TCSPR1000534() {

		waitThread(2000);
		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		waitThread(2000);
		// To click on create new assessment button
		click(ba.btn_createnewassessment);

		waitThread(3000);
		// Assert the basic details wizard selected
		Assert.assertEquals(getAttribute(ba.Basicdetailswizard, "aria-selected"), "true");

		// Click on Select course dropdown
		click(ba.dd_course);
		waitFor(ba.ddcoursename1);

		// Select Course
		Assert.assertEquals(getText(ba.ddcoursename1), CourseName.trim(), "course name not visible on the dropdown");

		click(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentName = "Assessment" + generateRandomNumber().trim();

		type(QP.Assess_name, AssessmentName);

		waitThread(3000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(1000);

		waitThread(2000);
		// Assert the questions wizard selected
		Assert.assertEquals(getAttribute(ba.Questionwizard, "aria-selected"), "true");

	}

	/*
	 * To fill details on theQuestion page
	 */
	@Test(priority = 35)
	public void TCSPR1000535() {

		waitThread(2000);
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

		// Click Save button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);
		waitThread(1000);




	}

	/*
	 * To verify the details on the peer review page
	 */
	@Test(priority = 36)
	public void TCSPR1000536() {
		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

		waitThread(4000);

		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));


		waitThread(2000);
		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		waitThread(2000);
		// Assert the text::Total Students : Assert the total student count is 2
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 2");

	}

	/*
	 * To perform the save and next functionaity from peer review page and verify
	 * the schedule page details
	 */
	@Test(priority = 37)
	public void TCSPR1000537() {
		waitThread(2000);

		// Type peer review reward score
		type(pr.PRreward_txtbox, "100");

		// Click Save&Next button
		click(pr.savennext_button);
		waitThread(1000);
		click(QP.toasterclosebtn);
		waitThread(2000);

		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");
		waitThread(4000);

		// Assert the text "Select schedules for "
		Assert.assertEquals(getText(sb.schedulefor_lbl), "Select Schedules for");

		// Assert that the Assessment Open date is Today's date
		Assert.assertEquals(getValue(sb.assessmentopendate_txtbx), sb.getdate());

		waitThread(3000);

	}

	public String recons_time;
	public String resche_recons_time;

	/*
	 * To fill the Schedule page details with Reconsideration request date
	 */
	@Test(priority = 38)
	public void TCSPR1000538() {

		ScrollTo_xy_position(0, 300);
		Assert.assertTrue(isElementPresent(sb.teacherwill_radio), "radio button is present");

		waitThread(5000);
		// Click on Teacher will manually publish the result
		Doubleclick(sb.teacherwill_radio);

		waitThread(4000);
		// Assert the Teacher will manually publish the result radio button is selected
		Assert.assertTrue(isEnabled(sb.teachwill_radio_select),
				"Teacher will manually publish the result radio button not selected");

		// Click Allow ResConsideration checkbox
		click(sb.allowstu_checkbx2);

		// Assert the labels
		// -Last date for raising reconsideration request by students
		// -Day from Result Publishing Date at
		Assert.assertEquals(getText(sb.lastdatestu_lbl), "Last date for raising reconsideration request by students");
		Assert.assertEquals(getText(sb.dayfromresult_lbl), "Day from Result Publishing Date at");

		// Read the day and time
		Assert.assertTrue(isElementPresent(sb.lasttime_select_bx), "Time textbox not visible");
		recons_time = getValue(sb.lasttime_select_bx);

		// Assert the date visible on the page
		Assert.assertEquals(getValue(sb.day_drop_txtbx), "0");

		waitThread(2000);
		ScrollTo_xy_position(0, 0);

		click(pr.savennext_button);
		waitThread(1000);
		click(QP.toasterclosebtn);
		waitThread(2000);

	}

	/*
	 * To verify the details on the Summary page
	 */
	@Test(priority = 39)
	public void TCSPR1000539() {

		waitThread(3000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");
		waitThread(2000);

		// Assert the text "Questions Summary "
		Assert.assertEquals(getText(sq.Summary_quest), "Questions Summary");

		waitThread(2000);
		// Assert the Total no: of Questions
		Assert.assertEquals(getText(sq.total_questcount), "1");

	}

	/*
	 * To perform Assessment publish functionality
	 */
	@Test(priority = 40)
	public void TCSPR1000540() {

		waitThread(2000);
		// click release button
		click(ap.relese_btn);
		waitFor(QP.toaster);

		// Assert the toaster "Assessment published successfully "
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");

		click(QP.toasterclosebtn);

		waitThread(2000);
		// Assert the popup visible
		Assert.assertTrue(isElementPresent(ap.publish_popup), "popup not visible");

		waitThread(2000);
		// Assert toaster "Assessment published successfully
		Assert.assertEquals(getText(ap.Assessmentcreated_lbl), "Assessment Created Successfully");

		// Assert button Back to Menu
		Assert.assertTrue(isElementPresent(ap.Backtomenu_btn), "button not visible");

		waitThread(2000);
		// Click on Back to menu button
		click(ap.Backtomenu_btn);

		waitThread(2000);

		// Assert the popup not visible
		Assert.assertFalse(isElementPresent(ap.publish_popup), "popup not visible");

	}

	/*
	 * To check the published Assessment card
	 */
	@Test(priority = 41)
	public void TCSPR1000541() {

		// Assert the text "Assessments "
		Assert.assertEquals(getText(ap.assess_lbl), "Assessments");

		// search newly created assessment
		type(rd.search_box, AssessmentName);
		waitThread(3000);

		// Assert the newly published card visible on the current assessment page
		Assert.assertTrue(isElementPresent(rd.newcard), " new assessment card not visible");

		// Assert the Assessment name,Course name and course code
		Assert.assertEquals(getText(rd.newasses_lbl), AssessmentName);

		Assert.assertEquals(getText(rd.course_lbl), "For" + " " + CourseName.trim() + " (" + CourseID + ")");

		

	}

	/*
	 * To check the Reschedule date popup[Manually published result section]
	 */
	@Test(priority = 42)
	public void TCSPR1000542() {

		waitThread(1000);

		// click menu button
		click(rd.threedot_btn);

		// click reschedule dates
		click(rd.reschedulemenu);
		waitThread(1000);

		// Assert Labels
		// -Teacher will manually publish the result
		// -Last date for Reconsideration Request
		// -Last date for raising reconsideration request by students
		// -Day from Result Publishing Date at

		Assert.assertEquals(getText(rd.manualpublish_txt), "Teacher will manually publish the result");
		Assert.assertEquals(getText(rd.lastdate_lbl), "Last date for Reconsideration Request");
		Assert.assertEquals(getText(rd.lastdaterecon_lbl), "Last date for raising reconsideration request by students");
		Assert.assertEquals(getText(rd.dayfrom_txt), "Day from Result Publishing Date at");

		waitThread(1000);
		// Assert Days dropdown
		Assert.assertEquals(getValue(rd.day_drop_txtbx), "0");

		waitThread(1000);
		// Assert the time Textbox
		Assert.assertTrue(isElementPresent(sb.lasttime_select_bx), "Time textbox not visible");
		resche_recons_time = getValue(rd.lastdatetime_txtbx);

		waitThread(2000);
		// Assert reconsideration time in reschedule page & schedule page are same
		Assert.assertEquals(getValue(rd.lastdatetime_txtbx), recons_time);

		waitThread(1000);
		// Close the reschedule popup
		click(rd.close_btn);

		// Assert popup not visible
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "popup visible");

	}

	/*
	 * To perform Logout Teacher Account functionality
	 */
	@Test(priority = 43)
	public void TCSPR1000543() {

		// logout functionality
		rs.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

	}

}
