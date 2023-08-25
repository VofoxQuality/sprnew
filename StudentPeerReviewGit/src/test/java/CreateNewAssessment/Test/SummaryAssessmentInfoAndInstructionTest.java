package CreateNewAssessment.Test;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;
import com.Generalmethods.Databaseconnection;
import com.Generalmethods.EncryptedText;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.BasicDetailsPageCourseandEditorPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.ScheduleConfigureDefaultPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryAssessmentInfoAndInstructionPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.RemoveStudentFromCoursePage;

public class SummaryAssessmentInfoAndInstructionTest extends basePage {
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
	BasicDetailsPageCourseandEditorPage be = new BasicDetailsPageCourseandEditorPage();
	SummaryBasicsPage su = new SummaryBasicsPage();
	CommonMethods cm = new CommonMethods();
	SummaryAssessmentInfoAndInstructionPage sa = new SummaryAssessmentInfoAndInstructionPage();

	public String Emailteacher;
	public String CourseName = cm.CourseName1;
	public String CourseNamenew;
	public String NewCourseTitle;
	public String CourseID = cm.CourseID1;
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

	public String Emailstudent1;
	public String Emailstudent2;
	public String Emailstudent3;
	public String Emailstudent4;

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

	public String studentinviteid;
	public String newOtp;
	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	/*
	 * To perform Sign In functionality
	 */
	@Test(priority = 1)
	public void TCSPR0901501() {

		click(lg.LoginBtn_1);

		cm.login(cm.emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	/*
	 * To create new course
	 */
//	@Test(priority = 2)
//	public void TCSPR0901502() throws SQLException {
//
//		CourseName = "Course Name" + generateRandomNumber();
//
//		// Click on create new course button
//		click(cn.btn_createnew);
//
//		// To get the Course ID
//		CourseID = (getText(cn.course_Id));
//
//		// type-Course title
//		type(cn.txbx_Coursetitle, CourseName);
//
//		// click on Add students button
//		click(cn.btn_AddStudents);
//
//		Emailstudent1 = "student1" + generateRandomNumber().trim() + "@gmail.com";
//		Emailstudent2 = "student2" + generateRandomNumber().trim() + "@gmail.com";
//
//		// type email
//		type(cn.tab_textbox, Emailstudent1 + ",");
//		driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
//		type(cn.tab_textbox, Emailstudent2 + ",");
//
//		// verify email present on the text box
//		Assert.assertEquals(cn.emailvalue(0), Emailstudent1);
//
//		Assert.assertEquals(cn.emailvalue(1), Emailstudent2);
//
//		// click on add to list button
//		click(cn.tab_btn_Addtolist);
//
//		waitThread(2000);
//		waitFor(cr.emailval_1);
//
//		// verify the Email on the New Students to be invited to this class box
//		Assert.assertEquals(getText(cr.emailval_1), Emailstudent1);
//		Assert.assertEquals(getText(ps.emailval_2), Emailstudent2);
//
//		// click on create course button
//		click(cn.btn_Createcourse);
//
//		waitThread(1000);
//		waitFor(cn.toaster);
//
//		// verify toaster-Course created successfully
//		Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");
//
//		waitThread(3000);
//
//		// verify the course title
//		Assert.assertEquals(getText(cn.value_coursetitle).trim(), CourseName.trim());
//
//	}
//	/*
//	 * To perform logout functionality on the teacher profile
//	 */
//
//	@Test(priority = 3)
//	public void TCSPR0901503() {
//
//		// logout functionality
//		rs.Logout();
//
//		// Heading Title-Login
//		Assert.assertEquals(getText(lg.PageTitle), "Login");
//
//	}

//	/*
//	 * To check that invited course request visible on first student 's profile
//	 * and accept course request-Read the student name
//	 */
//	@Test(priority = 4)
//	public void TCSPR0901504() throws SQLException {
//
//		studentinviteid = dc.InviteLink(Emailstudent1, CourseID);
//
//		String encText = et.EncryptCode(studentinviteid);
//		driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);
//
//		// Text-As individual Student
//		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");
//
//		Studentfirstname = "Ashley";
//		Studentlastname = "Albert";
//		Studentname = Studentfirstname + " " + Studentlastname;
//
//		// click first name
//		click(sp.txtbxFirstN);
//
//		// type first name
//		type(sp.txtbxFirstN, Studentfirstname);
//
//		// click last name
//		click(sp.txtbxLastN);
//
//		// type last name
//		type(sp.txtbxLastN, Studentlastname);
//
//		// click password
//		click(sp.txtbxPass);
//
//		// type password
//		type(sp.txtbxPass, password);
//
//		// click password
//		click(sp.txtbxPassconf);
//
//		// type password
//		type(sp.txtbxPassconf, password);
//
//		// click on privacy policy check box
//		click(sp.chkbx_1);
//
//		// click signup button
//		click(sp.btn_signup);
//
//		waitThread(5000);
//
//		// verify heading label
//		waitFor(rs.lbl_joincourse);
//		Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");
//
//		// verify course name visible
//		Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not Present");
//
//		// verify the the course name
//		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());
//
//	}
//	/*
//	 * To Accept course and perform logout functionality on the student profile
//	 */
//
//	@Test(priority = 5)
//	public void TCSPR0901505() {
//
//		// click on accept course button
//		click(rs.btn_acceptcourse);
//
//		// verify the confirmation popup visible
//		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");
//
//		// click on Yes button
//		click(rs.popupbtn_Yes);
//
//		// Toaster message
//		waitFor(rs.toaster);
//		Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
//
//		// verify the course name visibled on the enrolled section
//		waitFor(rs.enrolledcoursename);
//
//		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());
//		waitThread(3000);
//
//		// perform logout functionality
//		rs.Logout();
//
//		// Heading Title-Login
//		Assert.assertEquals(getText(lg.PageTitle), "Login");
//	}

//	/*
//	 * To check that invited course request visible on first student 's profile
//	 * and accept course request-Read the student name
//	 */
//	@Test(priority = 6)
//	public void TCSPR0901506() throws SQLException {
//
//		studentinviteid = dc.InviteLink(Emailstudent2, CourseID);
//
//		String encText = et.EncryptCode(studentinviteid);
//		driver.get("http://192.168.7.108:8051/SPRClient/signup/" + encText);
//
//		// Text-As individual Student
//		Assert.assertEquals(getText(rs.txt_1), "as Individual Student");
//
//		Studentfirstname2 = "Ben";
//		Studentlastname2 = "Max";
//		Studentname2 = Studentfirstname2 + " " + Studentlastname2;
//
//		// click first name
//		click(sp.txtbxFirstN);
//
//		// type first name
//		type(sp.txtbxFirstN, Studentfirstname2);
//
//		// click last name
//		click(sp.txtbxLastN);
//
//		// type last name
//		type(sp.txtbxLastN, Studentlastname2);
//
//		// click password
//		click(sp.txtbxPass);
//
//		// type password
//		type(sp.txtbxPass, password);
//
//		// click password
//		click(sp.txtbxPassconf);
//
//		// type password
//		type(sp.txtbxPassconf, password);
//
//		// click on privacy policy check box
//		click(sp.chkbx_1);
//
//		// click signup button
//		click(sp.btn_signup);
//
//		waitThread(5000);
//
//		// verify heading label
//		waitFor(rs.lbl_joincourse);
//		Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");
//
//		// verify course name visible
//		Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not Present");
//
//		// verify the the course name
//		Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());
//
//	}
//	/*
//	 * To Accept course and perform logout functionality on the student profile
//	 */
//
//	@Test(priority = 7)
//	public void TCSPR0901507() {
//
//		// click on accept course button
//		click(rs.btn_acceptcourse);
//
//		// verify the confirmation popup visible
//		Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not visible");
//
//		// click on Yes button
//		click(rs.popupbtn_Yes);
//
//		// Toaster message
//		waitFor(rs.toaster);
//		Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
//
//		// verify the course name visibled on the enrolled section
//		waitFor(rs.enrolledcoursename);
//		Assert.assertEquals(getText(rs.enrolledcoursename).trim(), CourseName.trim());
//		waitThread(3000);
//
//		// perform logout functionality
//		rs.Logout();
//
//		// Heading Title-Login
//		Assert.assertEquals(getText(lg.PageTitle), "Login");
//	}

	/*
	 * To load the create new assessment page and fill details on the basic details
	 * page
	 */

	@Test(priority = 8)
	public void TCSPR0901508() {

		SoftAssert softAssert1 = new SoftAssert();
		// rs.login_Teacher(Emailteacher, password);

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(5000);
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

		softAssert1.assertEquals(getText(ba.lbl_assessmentinfo), "Assessment Information for Students",
				"Assertion  failed");

		softAssert1.assertAll();

	}

	/*
	 * To fill details on the Assessment Information for Students editor.To perform
	 * the Assessment Information for Students Editor insert/edit image image upload
	 * functionality To upload an image file from the folder
	 */
	public String ImageURL = cm.ImageURL;

	@Test(priority = 9)
	public void TCSPR0901509() {

		Assessmentinfo = "Assessmentinfo" + generateRandomNumber().trim();
		driver.switchTo().frame("assessmentInfo_ifr");

		// Type Assessment Information for Students
		click(ba.editorplaceholder1);
		waitThread(1000);
		type(ba.editorplaceholder1, Assessmentinfo);

		driver.findElement(By.xpath(ba.editorplaceholder1)).sendKeys(Keys.ENTER);

		driver.switchTo().defaultContent();
		// Editor image button
		click(be.infoeditorimagebtn);

		// Verify the popup
		Assert.assertTrue(isElementPresent(be.popupimage), "Edit/Add image Popup not visible");
		waitThread(2000);

		// Type image URL
		driver.findElement(
				By.cssSelector("div[id*=dialog-describe_] > div > div > div > div:nth-child(1) > div > div>input"))
				.sendKeys(ImageURL);
		waitThread(5000);

		// click on save button
		click(be.imageuploadsavebtn);
		waitThread(2000);

		click(ba.lbl_assessmentinfo);

		// To switch the instruction frame
		driver.switchTo().frame("assessmentInfo_ifr");
		waitFor(be.instrimage);

		// To verify the added video visible
		Assert.assertTrue(isElementPresent(be.instrimage), "Uploaded image not visible");
		driver.findElement(By.xpath(ba.editorplaceholder1)).sendKeys(Keys.ENTER);

	}

	/*
	 * To perform the Assessment Information for Students Editor Insert/Edit Media
	 * upload functionality To upload a video file from the folder
	 */
	public String VideoURL = cm.VideoURL;

	@Test(priority = 10)
	public void TCSPR0901510() {

		driver.switchTo().defaultContent();

		// Editor video button
		click(be.infoeditorvideobtn);

		Assert.assertTrue(isElementPresent(be.popupimage), "Insert/Edit Media Popup not visible");
		waitThread(5000);
		driver.findElement(
				By.cssSelector("div[id*=dialog-describe_] > div > div > div > div:nth-child(1) > div > div>input"))
				.sendKeys(VideoURL);
		waitThread(7000);

		// click on save button
		click(be.videouploadsavebtn);
		waitThread(2000);

		// To switch the info frame
		driver.switchTo().frame("assessmentInfo_ifr");
		waitFor(be.infovideo1);

		// To verify the added video visible
		Assert.assertTrue(isElementPresent(be.infovideo1), "Uploaded video not visible");
		Assert.assertEquals(getAttribute(be.infovideo, "type"), "video/mp4");

	}

	/*
	 * To perform the Assessment Information for Students Editor Insert/Edit Link
	 * add functionality
	 */
	public String URL = cm.URL;

	@Test(priority = 11)
	public void TCSPR0901511() {

		driver.switchTo().defaultContent();

		click(ba.lbl_assessmentinfo);
		waitThread(1000);

		// Editor Info button
		click(be.infoeditorbtnlink);
		Assert.assertTrue(isElementPresent(be.popupimage), "Insert/Edit Link Popup not visible");
		waitThread(2000);

		// Click and type in URL text box and save it
		click(be.urltextbx);
		type(be.urltextbx, URL);
		waitThread(2000);
		click(be.texttodisplaybx);
		waitThread(5000);
		click(be.imageuploadsavebtn);
		waitThread(2000);

		// Switch to Assessment Information for Students frame
		driver.switchTo().frame("assessmentInfo_ifr");
		Assert.assertTrue(isElementPresent(be.infolink), "Uploaded image not visible");
		Assert.assertEquals(getAttribute(be.infolink, "data-mce-href"), URL);
		driver.findElement(By.xpath(ba.editorplaceholder1)).sendKeys(Keys.ENTER);

	}
	/*
	 * To fill details on the Assessment Instructions editor.To perform the
	 * Assessment Instructions for Students Editor insert/edit image image upload
	 * functionality To upload an image file from the folder
	 */

	@Test(priority = 12)
	public void TCSPR0901512() {

		driver.switchTo().defaultContent();
		waitThread(1000);
		Scroll_DowntoEnd();
		waitThread(2000);
		Assessmentinstruction = "Assessmentinstruction" + generateRandomNumber().trim();
		// To switch the frame
		driver.switchTo().frame("instructions_ifr");
		click(ba.editorplaceholder2);
		waitThread(1000);

		type(ba.editorplaceholder2, Assessmentinstruction);
		driver.findElement(By.xpath(ba.editorplaceholder2)).sendKeys(Keys.ENTER);

		driver.switchTo().defaultContent();

		// click on image button
		click(be.instreditorimagebtn);
		Assert.assertTrue(isElementPresent(be.popupimage), "Edit/Add image Popup not visible");
		waitThread(2000);
		driver.findElement(
				By.cssSelector("div[id*=dialog-describe_] > div > div > div > div:nth-child(1) > div > div>input"))
				.sendKeys(ImageURL);
		waitThread(5000);
		click(be.imageuploadsavebtn);
		waitThread(2000);

		// Switch to the instruction frame
		driver.switchTo().frame("instructions_ifr");
		waitThread(2000);
		Assert.assertTrue(isElementPresent(be.instrimage), "Uploaded image not visible");

	}

	/*
	 * To perform the Assessment Instruction Editor Insert/Edit Media upload
	 * functionality
	 */

	@Test(priority = 13)
	public void TCSPR0901513() {

		driver.switchTo().defaultContent();
		click(ba.lbl_AssessmentInstru);
		driver.switchTo().frame("instructions_ifr");
		driver.findElement(By.xpath(ba.editorplaceholder2)).sendKeys(Keys.ENTER);
		driver.switchTo().defaultContent();
		// Click on video button in the editor

		click(be.instreditorvideobtn);
		Assert.assertTrue(isElementPresent(be.popupimage), "Insert/Edit Media Popup not visible");
		waitThread(2000);
		driver.findElement(
				By.cssSelector("div[id*=dialog-describe_] > div > div > div > div:nth-child(1) > div > div>input"))
				.sendKeys(VideoURL);
		waitThread(7000);
		click(be.videouploadsavebtn);
		waitThread(2000);

		// verify the added image on the editor
		driver.switchTo().frame("instructions_ifr");
		Assert.assertTrue(isElementPresent(be.infovideo1), "Uploaded video not visible");
		Assert.assertEquals(getAttribute(be.infovideo, "type"), "video/mp4");
	}

	/*
	 * To perform the Assessment Instruction Editor Insert/Edit Link add
	 * functionality
	 */
	@Test(priority = 14)
	public void TCSPR0901514() {

		driver.switchTo().defaultContent();
		click(ba.lbl_AssessmentInstru);
		waitThread(1000);

		// click on link button
		click(be.instreditorbtnlink);
		Assert.assertTrue(isElementPresent(be.popupimage), "Insert/Edit Link Popup not visible");
		waitThread(2000);
		String URL = cm.URL;

		// To Type URL
		click(be.urltextbx);
		type(be.urltextbx, URL);
		waitThread(2000);
		click(be.texttodisplaybx);
		waitThread(5000);
		click(be.imageuploadsavebtn);
		waitThread(2000);

		// To switch the frame and verify the URL
		driver.switchTo().frame("instructions_ifr");
		Assert.assertTrue(isElementPresent(be.instrlink), "Uploaded link not visible");
		Assert.assertEquals(getAttribute(be.instrlink, "data-mce-href"), URL);
		driver.findElement(By.xpath(ba.editorplaceholder2)).sendKeys(Keys.ENTER);
	}

	/*
	 * To fill details on the Question page
	 */
	@Test(priority = 15)
	public void TCSPR0901515() {

		driver.switchTo().defaultContent();
		waitThread(1000);
		ScrollTo_xy_position(0, 0);
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

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");

	}

	/*
	 * To verify the details on the peer review page
	 */
	@Test(priority = 16)
	public void TCSPR0901516() {

		waitThread(2000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));

		// Assert lables:
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains("Course:"));

		// Assert course code,course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseID));
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Assert the text::Total Students : Assert the total student count is 1
		Assert.assertEquals(getText(pr.totalstudent_lbl).trim(), "Total Students : 4");

		
	}

	/*
	 * To perform the save and next functionaity from peer review page and verify
	 * the schedule page details
	 */
	@Test(priority = 17)
	public void TCSPR0901517() {

		type(pr.PRreward_txtbox, "50");
		waitThread(3000);

		click(pr.savennext_button);
		waitThread(3000);
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
	public void TCSPR0901518() {

		waitThread(3000);
		// Click on save and next button
		click(pr.savennext_button);

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");

		Assert.assertTrue(getText(su.summaryassessmentname).contains("Assessment Name: " + AssessmentName));

		// Assert course code,course name
		Assert.assertTrue(getText(su.summarycoursename).contains(CourseID));
		Assert.assertTrue(getText(su.summarycoursename).contains(CourseName.trim()));

		ScrollTo_Location(sa.Assessinfo_frame);
		waitThread(2000);

		Assert.assertTrue(isElementPresent(sa.Assessinfo_frame), "Assessment Information for Students box not visible");

		Assert.assertEquals(getAttribute(sa.Assessinfo_Box, "aria-disabled"), "true");

		Assert.assertTrue(isElementPresent(sa.Assessinstr_frame), "Assessment Instructions box not visible");

		Assert.assertEquals(getAttribute(sa.Assessinstr_Box, "aria-disabled"), "true");

	}

	/*
	 * To verify the added Assessment Information for Students details visible on
	 * the summary page
	 */
	@Test(priority = 19)
	public void TCSPR0901519() {

		ScrollTo_xy_position(0, 750);
		waitThread(2000);

		driver.switchTo().frame("assessment-info_ifr");
		waitThread(2000);

		// Assert the Assessment Information for Students Assessment Info+Random
		// number visible on the page
		Assert.assertEquals(getText(sa.Assessinfo_lbl), Assessmentinfo);

		// Assert the added image,vide and link visible on the page
		Assert.assertEquals(getAttribute(sa.assessinfoimage, "src"), ImageURL);
		Assert.assertTrue(isElementPresent(sa.assessinfovideo), "video not present");

		Assert.assertEquals(getAttribute(sa.assessinfolink, "href"), URL);

	}

	/*
	 * To verify the added Assessment instructions visible on the summary page
	 * 
	 */
	@Test(priority = 20)
	public void TCSPR0901520() {

		driver.switchTo().defaultContent();
		waitThread(2000);

		driver.switchTo().frame("assessment-instructions_ifr");
		waitThread(1000);

		// Assert the Assessment instructions Assessment Instruction+Random
		// number
		// visible on the page
		Assert.assertEquals(getText(sa.Assessinstruction_lbl), Assessmentinstruction);

		// Assert the added image,vide and link visible on the page
		Assert.assertEquals(getAttribute(sa.assessinfoimage, "src"), ImageURL);
		Assert.assertTrue(isElementPresent(sa.assessinfovideo), "video not present");
		Assert.assertEquals(getAttribute(sa.assessinstlink, "href"), URL);

	}

	/*
	 * To perform Edit Assessment Information for Students and Instruction
	 * functionality on the Summary page
	 */
	@Test(priority = 21)
	public void TCSPR0901521() {

		driver.switchTo().defaultContent();
		waitThread(1000);
		Assert.assertTrue(isElementPresent(sa.edit_btn), "Button not present");

		click(sa.edit_btn);
		waitThread(1000);

		// To verify the wizard label is selected
		Assert.assertEquals(getAttribute(ba.Basicdetailswizard, "aria-selected"), "true");

		// To verify the wizard label is selected
		Assert.assertEquals(getText(ba.dd_course), CourseName.trim());

		Assert.assertTrue(isElementPresent(ba.btndiscard), "Discard button not visible");
		Assert.assertTrue(isElementPresent(ba.btnsaveandnext), "Save and next button not visible");

	}

	/*
	 * To Edit Assessment Information for Students and instructions details
	 */
	@Test(priority = 22)
	public void TCSPR0901522() {

		Assessmentinfonew = "Assessmentinfonew" + generateRandomNumber().trim();
		driver.switchTo().frame("assessmentInfo_ifr");

		// Type Assessment Information for Students
		click(ba.editorplaceholder1);
		waitThread(1000);
		type(ba.editorplaceholder1, Assessmentinfonew);

		driver.findElement(By.xpath(ba.editorplaceholder1)).sendKeys(Keys.ENTER);
		Assert.assertEquals(getText(ba.editorplaceholder1), Assessmentinfonew);

		driver.switchTo().defaultContent();
		waitThread(2000);

		Scroll_DowntoEnd();
		waitThread(2000);
		Assessmentinstructionnew = "Assessmentinstructionnew" + generateRandomNumber().trim();

		// To switch the frame
		driver.switchTo().frame("instructions_ifr");
		click(ba.editorplaceholder2);
		waitThread(1000);

		type(ba.editorplaceholder2, Assessmentinstructionnew);
		driver.findElement(By.xpath(ba.editorplaceholder2)).sendKeys(Keys.ENTER);
		Assert.assertEquals(getText(ba.editorplaceholder2), Assessmentinstructionnew);

	}

	/*
	 * To perform Discard functionality
	 */
	@Test(priority = 23)
	public void TCSPR0901523() {

		driver.switchTo().defaultContent();
		waitThread(1000);

		click(pr.discard_button);
		// assert popup
		Assert.assertTrue(isElementPresent(sb.conf_dlgbx), "popup not  present");
		waitFor(sb.confirm_lbl);
		// Assert label
		Assert.assertEquals(getText(sb.confirm_lbl), "Are you sure you want to proceed with your action?\n"
				+ "We detected you have made changes to the information on this screen and if you ‘Discard’ these changes will not be saved.");

		// Assert button in popup
		Assert.assertTrue(isElementPresent(sb.confno_btn), "Cancel button not   present");
		Assert.assertTrue(isElementPresent(sb.confyes_btn), "Discard not  present");

		// click Cancel button
		click(sb.confno_btn);
		waitThread(1000);

		// Assert a confirmation popup not visible on the page
		Assert.assertFalse(isElementPresent(sb.conf_dlgbx), "popup  present");
		// To verify the wizard label is selected
		Assert.assertEquals(getAttribute(ba.Basicdetailswizard, "aria-selected"), "true");

		click(pr.discard_button);
		waitThread(2000);
		// click yes button
		click(sb.confyes_btn);

		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");
		// Assert the label assessment name,

		ScrollTo_xy_position(0, 750);
		waitThread(2000);

		driver.switchTo().frame("assessment-info_ifr");
		waitThread(2000);

		// Type new Assessment Information for Students text
		Assert.assertEquals(getText(sa.Assessinfo_lbl), Assessmentinfo);
		driver.switchTo().defaultContent();
		waitThread(1000);

		// Type new assessment instruction text
		driver.switchTo().frame("assessment-instructions_ifr");
		waitThread(1000);
		Assert.assertEquals(getText(sa.Assessinstruction_lbl), Assessmentinstruction);

	}
	/*
	 * To perform Edit Assessment Information for Students and Instruction
	 * functionality on the Summary page
	 */

	@Test(priority = 24)
	public void TCSPR0901524() {

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Assert edit button present
		Assert.assertTrue(isElementPresent(sa.edit_btn), "Button not present");
		click(sa.edit_btn);
		waitThread(1000);

		// To verify the wizard label is selected
		Assert.assertEquals(getAttribute(ba.Basicdetailswizard, "aria-selected"), "true");
		driver.switchTo().frame("assessmentInfo_ifr");

		waitThread(1000);

		click(ba.editorplaceholder1);
		driver.findElement(By.xpath(ba.editorplaceholder1)).clear();

		waitThread(1000);
		Assert.assertEquals(getText(ba.editorplaceholder1), "");

		driver.switchTo().defaultContent();
		waitThread(1000);
		Scroll_DowntoEnd();
		waitThread(2000);
		// To switch the frame
		driver.switchTo().frame("instructions_ifr");
		waitThread(1000);

		click(ba.editorplaceholder2);
		driver.findElement(By.xpath(ba.editorplaceholder2)).clear();

		waitThread(1000);

		Assert.assertEquals(getText(ba.editorplaceholder2), "");

	}

	/*
	 * To check the updated empty data on the assessment instruction and info boxes
	 */
	@Test(priority = 25)
	public void TCSPR0901525() {

		driver.switchTo().defaultContent();
		waitThread(1000);

		ScrollTo_xy_position(0, 0);
		waitThread(1000);

		click(QP.Savenext);
		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(3000);
		// Click Save&Next button
		click(QP.savenext_btn);
		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");
		click(pr.savennext_button);
		waitThread(2000);
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");

		// Set Assessment day as current day
		click(pr.assessmentopendate_txtbx);
		waitThread(1000);
		Doubleclick(pr.calanderdate_val);
		waitThread(3000);

		// Click on save and next button
		click(pr.savennext_button);
		waitThread(1000);

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");

		// Assert the label assessmentinfo not visible
		ScrollTo_xy_position(0, 750);
		waitThread(2000);

		driver.switchTo().frame("assessment-info_ifr");
		waitThread(2000);

		Assert.assertEquals(getText(sa.Assessinfo_lbl), "");
		driver.switchTo().defaultContent();
		waitThread(1000);

		// Assert the label assessment instruction not visible
		driver.switchTo().frame("assessment-instructions_ifr");
		waitThread(1000);
		Assert.assertEquals(getText(sa.Assessinstruction_lbl), "");

	}

	/*
	 * To perform Edit Assessment Information for Students and Instruction
	 * functionality on the Summary page
	 */
	@Test(priority = 26)
	public void TCSPR0901526() {

		driver.switchTo().defaultContent();
		waitThread(1000);

		// Assert edit button
		Assert.assertTrue(isElementPresent(sa.edit_btn), "Button not present");
		click(sa.edit_btn);
		waitThread(1000);

		// To verify the wizard label is selected
		Assert.assertEquals(getAttribute(ba.Basicdetailswizard, "aria-selected"), "true");

		// type new Assessment Information for Students
		driver.switchTo().frame("assessmentInfo_ifr");

		// Type Assessment Information for Students
		click(ba.editorplaceholder1);
		waitThread(1000);
		type(ba.editorplaceholder1, Assessmentinfonew);

		driver.findElement(By.xpath(ba.editorplaceholder1)).sendKeys(Keys.ENTER);
		Assert.assertEquals(getText(ba.editorplaceholder1), Assessmentinfonew);

		driver.switchTo().defaultContent();
		waitThread(1000);
		Scroll_DowntoEnd();
		waitThread(2000);

		// type new assessment instruction

		// To switch the frame
		driver.switchTo().frame("instructions_ifr");
		click(ba.editorplaceholder2);
		waitThread(1000);

		type(ba.editorplaceholder2, Assessmentinstructionnew);
		driver.findElement(By.xpath(ba.editorplaceholder2)).sendKeys(Keys.ENTER);
		Assert.assertEquals(getText(ba.editorplaceholder2), Assessmentinstructionnew);

	}

	/*
	 * To check the Edited assessment instruction and info text visible on the
	 * summary page
	 */
	@Test(priority = 27)
	public void TCSPR0901527() {

		driver.switchTo().defaultContent();
		waitThread(1000);

		ScrollTo_xy_position(0, 0);
		waitThread(500);

		click(QP.Savenext);
		waitThread(2000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(3000);
		// Click Save&Next button
		click(QP.savenext_btn);
		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		click(pr.savennext_button);
		waitThread(2000);
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");
		click(pr.assessmentopendate_txtbx);
		waitThread(1000);
		Doubleclick(pr.calanderdate_val);
		waitThread(3000);
		// Click on save and next button
		click(pr.savennext_button);
		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");

		// Assert the label assessment name,
		ScrollTo_xy_position(0, 750);
		waitThread(3000);

		driver.switchTo().frame("assessment-info_ifr");
		waitThread(2000);

		// Assert the newly added Assessment Information for Students text
		Assert.assertEquals(getText(sa.Assessinfo_lbl), Assessmentinfonew);
		driver.switchTo().defaultContent();
		waitThread(1000);

		// Assert the newly added assessment instructions text
		driver.switchTo().frame("assessment-instructions_ifr");
		waitThread(1000);
		Assert.assertEquals(getText(sa.Assessinstruction_lbl), Assessmentinstructionnew);

	}

	/*
	 * To perform save and exit functionality from summary page and load the
	 * assessment from draft and edit the Assessment Information for Students and
	 * instruction
	 * 
	 */
	@Test(priority = 28)
	public void TCSPR0901528() {

		driver.switchTo().defaultContent();
		waitThread(1000);
		// Click on save and next button
		click(pr.savenexit_button);
		waitThread(5000);
		click(pr.draft_tab);
		waitThread(1000);

		type(pr.draft_searchbx, AssessmentName);
		waitThread(1000);
		// Click on continue edit button
		click(pr.continueedit_button);

		// Assert the Basic Details wizard is selected
		Assert.assertTrue(isEnabled(pr.basicdetails_wizard), "Basic Details wizard is selected");

		// To verify the wizard label is selected
		Assert.assertEquals(getAttribute(ba.Basicdetailswizard, "aria-selected"), "true");

		// type new Assessment Information for Students text
		NewAssessmentinfo = "NewAssessmentinfonew" + generateRandomNumber().trim();
		driver.switchTo().frame("assessmentInfo_ifr");

		// Type Assessment Information for Students
		click(ba.editorplaceholder1);
		waitThread(1000);
		type(ba.editorplaceholder1, NewAssessmentinfo);

		driver.findElement(By.xpath(ba.editorplaceholder1)).sendKeys(Keys.ENTER);
		Assert.assertEquals(getText(ba.editorplaceholder1), NewAssessmentinfo);

		driver.switchTo().defaultContent();
		waitThread(1000);
		Scroll_DowntoEnd();
		waitThread(2000);

		// type new assessment instruction text
		NewAssessmentinstruction = "NewAssessmentinstruction" + generateRandomNumber().trim();
		// To switch the frame
		driver.switchTo().frame("instructions_ifr");
		click(ba.editorplaceholder2);
		waitThread(1000);

		type(ba.editorplaceholder2, NewAssessmentinstruction);
		driver.findElement(By.xpath(ba.editorplaceholder2)).sendKeys(Keys.ENTER);
		Assert.assertEquals(getText(ba.editorplaceholder2), NewAssessmentinstruction);

	}

	/*
	 * To check the Edited assessment instruction and info text visible on the
	 * summary page
	 */
	@Test(priority = 29)
	public void TCSPR0901529() {

		driver.switchTo().defaultContent();
		waitThread(1000);

		ScrollTo_xy_position(0, 0);
		waitThread(500);

		click(QP.Savenext);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(2000);
		// Click Save&Next button
		click(QP.savenext_btn);
		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");
		click(pr.savennext_button);
		waitThread(2000);
		Assert.assertEquals(getAttribute(sb.schedule_wizard, "aria-expanded"), "true");

		// Set Assessment day as current day
		click(pr.assessmentopendate_txtbx);
		waitThread(1000);
		Doubleclick(pr.calanderdate_val);
		waitThread(3000);

		// Click on save and next button
		click(pr.savennext_button);
		waitThread(2000);

		// Assert the peer review wizard is selected
		Assert.assertEquals(getAttribute(sb.summary_wizard, "aria-selected"), "true");

		ScrollTo_xy_position(0, 750);
		waitThread(2000);

		driver.switchTo().frame("assessment-info_ifr");
		waitThread(2000);

		// Assert the newly added Assessment Information for Students text on
		// the Assessment Information for Students box
		Assert.assertEquals(getText(sa.Assessinfo_lbl), NewAssessmentinfo);
		driver.switchTo().defaultContent();
		waitThread(1000);

		// Assert the newly added assessment instructions text on the Assessment
		// Information for Students
		// box
		driver.switchTo().frame("assessment-instructions_ifr");
		waitThread(1000);
		Assert.assertEquals(getText(sa.Assessinstruction_lbl), NewAssessmentinstruction);

	}

	/*
	 * To perform save and exit functionality and verify that it redirect to the
	 * draft page
	 */
	@Test(priority = 30)
	public void TCSPR0901530() {

		driver.switchTo().defaultContent();
		waitThread(1000);

		ScrollTo_xy_position(0, 0);
		waitThread(500);

		// Click on save and next button
		click(pr.savenexit_button);

		waitThread(3000);
		Assert.assertEquals(getAttribute(sa.draft_tab, "aria-selected"), "true");

		// Assert the tab name:Draft
		Assert.assertEquals(getText(pr.draft_lbl).trim(), "Draft");
		type(pr.draft_searchbx, AssessmentName);
		// Assert the assessment name on the grid
		Assert.assertEquals(getText(pr.draftassessname_lbl).trim(), AssessmentName);

	}

	/*
	 * To perform Logout TeacherAccount functionality
	 */
	@Test(priority = 31)
	public void TCSPR0901531() {

		cm.Logout();

		// Heading Title-Login
		Assert.assertEquals(getText(lg.PageTitle), "Login");

		waitThread(2000);

	}

}
