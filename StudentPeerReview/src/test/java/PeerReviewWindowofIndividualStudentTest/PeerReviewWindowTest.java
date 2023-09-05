package PeerReviewWindowofIndividualStudentTest;

import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.CommonMethods;

import Course.Pages.CreateNewCoursePage;
import Course.Pages.EditCoursePage;
import Course.Test.EditCourseTest;
import CreateNewAssessment.Pages.BasicDetailsAssessmentPage;
import CreateNewAssessment.Pages.BasicDetailsPageCourseandEditorPage;
import CreateNewAssessment.Pages.MultipleQuestionsAddPage;
import CreateNewAssessment.Pages.PeerReviewBasicDetailsPage;
import CreateNewAssessment.Pages.PeerReviewPageStudentDetailsPage;
import CreateNewAssessment.Pages.QuestionEditorAndMultipleCategoryAddPage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import CreateNewAssessment.Pages.SchedulePageBasicsPage;
import CreateNewAssessment.Pages.SummaryBasicsPage;
import CreateNewAssessment.Pages.SummarySchedulePage;
import CreateNewAssessment.Test.BasicDetailsAssessmentTest;
import CreateNewAssessment.Test.SummaryBasicsTest;
import CurrentAssessmentsforStudents.Pages.StudentCurrentAssessmentBasicsPage;
import CurrentAssessmentsforStudents.Pages.StudentTestSectionPage;
import Login.Pages.LoginPage;
import NewAssessmentOfTeacherPage.NewAssessmentTeacherBasicsPage;
import NewAssessmentOfTeacherPage.RescheduleDatesPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import PeerReviewWindowofIndividualStudentPages.PeerReviewWindowPage;
import SPRautomation.StudentPeerReview.basePage;
import StudentLogin.Pages.RemoveStudentFromCoursePage;
import TestWindowOfIndividualStudent.AnswerWindowPage;
import TestWindowOfIndividualStudent.AssessmentSubmitAndStatusPopUpPage;
import TestWindowOfIndividualStudent.ModifyWizardSectionPage;

public class PeerReviewWindowTest extends basePage {

	LoginPage lg = new LoginPage();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	RemoveStudentFromCoursePage rs = new RemoveStudentFromCoursePage();
	PeerReviewPageStudentDetailsPage ps = new PeerReviewPageStudentDetailsPage();
	MultipleQuestionsAddPage mq = new MultipleQuestionsAddPage();
	BasicDetailsAssessmentPage ba = new BasicDetailsAssessmentPage();
	QuestionPageBasicsPage QP = new QuestionPageBasicsPage();
	PeerReviewBasicDetailsPage pr = new PeerReviewBasicDetailsPage();
	EditCoursePage ec = new EditCoursePage();
	BasicDetailsAssessmentTest bdt = new BasicDetailsAssessmentTest();
	SchedulePageBasicsPage sbp = new SchedulePageBasicsPage();
	SummaryBasicsPage sb = new SummaryBasicsPage();
	EditCourseTest ect = new EditCourseTest();
	TeacherTestSectionPage tts = new TeacherTestSectionPage();
	StudentTestSectionPage st1 = new StudentTestSectionPage();
	SchedulePageBasicsPage sb1 = new SchedulePageBasicsPage();
	BasicDetailsPageCourseandEditorPage be = new BasicDetailsPageCourseandEditorPage();
	NewAssessmentTeacherBasicsPage natb = new NewAssessmentTeacherBasicsPage();
	StudentCurrentAssessmentBasicsPage sca = new StudentCurrentAssessmentBasicsPage();
	QuestionEditorAndMultipleCategoryAddPage QE = new QuestionEditorAndMultipleCategoryAddPage();
	AssessmentSubmitAndStatusPopUpPage asp = new AssessmentSubmitAndStatusPopUpPage();
	AnswerWindowPage an = new AnswerWindowPage();
	CommonMethods cm = new CommonMethods();
	ModifyWizardSectionPage ms = new ModifyWizardSectionPage();
	PeerReviewWindowPage prp = new PeerReviewWindowPage();
	RescheduleDatesPage rd=new RescheduleDatesPage();

	public String Emailteacher;
	public String AssessmentName;
	public String Student1name = "Ashley Albert";
	public String Student2name = "Ben Alex";
	public String Student3name = "Clara Albert";

	public String password = "Abc@123";
	public String Teachername = "Test Teacher";

	/*
	 * To perform Login functionality
	 */
	@Test(priority = 1)
	public void TCSPR1300201() {

		click(lg.LoginBtn_1);

		cm.login(cm.emailteacher, cm.Password);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}
	
	/*
	 * To create new course
	 */
	// @Test(priority = 2)
	// public void TCSPR1300202() {

	// CourseName = "Course Name" + generateRandomNumber();
	//
	// // Click on create new course button
	// click(cn.btn_createnew);
	//
	// // To get the Course ID
	// CourseID = (getText(cn.course_Id));
	//
	// // type-Course title
	// type(cn.txbx_Coursetitle, CourseName);
	//
	// // click on Add students button
	// click(cn.btn_AddStudents);
	//
	// Emailstudent1 = "student1@gmail.com";
	// Emailstudent2 = "student2@gmail.com";
	//
	// // type email
	// type(cn.tab_textbox, Emailstudent1 + ",");
	// driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
	// type(cn.tab_textbox, Emailstudent2 + ",");
	//
	// // verify email present on the text box
	// Assert.assertEquals(cn.emailvalue(0), Emailstudent1);
	//
	// Assert.assertEquals(cn.emailvalue(1), Emailstudent2);
	//
	// // click on add to list button
	// click(cn.tab_btn_Addtolist);
	//
	// waitThread(2000);
	// waitFor(cr.emailval_1);
	//
	// // verify the Email on the New Students to be invited to this class box
	// Assert.assertEquals(getText(cr.emailval_1), Emailstudent1);
	// Assert.assertEquals(getText(ps.emailval_2), Emailstudent2);
	//
	// // click on create course button
	// click(cn.btn_Createcourse);
	//
	// waitThread(1000);
	// waitFor(cn.toaster);
	//
	// // verify toaster-Course created successfully
	// Assert.assertEquals(getText(cn.toaster).trim(), "Course created
	// successfully");
	//
	// waitThread(3000);
	//
	// // verify the course title
	// Assert.assertEquals(getText(cn.value_coursetitle).trim(),
	// CourseName.trim());
	//

	// }

	// @Test(priority = 3)
	public void TCSPR1300203() {

		// CourseName = "Course Name" + generateRandomNumber();
		//
		// // Click on create new course button
		// click(cn.btn_createnew);
		//
		// // To get the Course ID
		// CourseID = (getText(cn.course_Id));
		//
		// // type-Course title
		// type(cn.txbx_Coursetitle, CourseName);
		//
		// // click on Add students button
		// click(cn.btn_AddStudents);
		//
		// Emailstudent_1 = "student1@gmail.com";
		// Emailstudent_2 = "student2@gmail.com";
		// Emailstudent_3 = "student3@gmail.com";
		//
		// // type email
		// type(cn.tab_textbox, Emailstudent1 + ",");
		// driver.findElement(By.xpath(ps.emailtype_txt)).sendKeys(Keys.SPACE);
		// type(cn.tab_textbox, Emailstudent2 + ",");
		//
		// // verify email present on the text box
		// Assert.assertEquals(cn.emailvalue(0), Emailstudent_1);
		//
		// Assert.assertEquals(cn.emailvalue(1), Emailstudent_2);
		// Assert.assertEquals(cn.emailvalue(2), Emailstudent_3);
		//
		// // click on add to list button
		// click(cn.tab_btn_Addtolist);
		//
		// waitThread(2000);
		// waitFor(cr.emailval_1);
		//
		// // verify the Email on the New Students to be invited to this class
		// box
		// Assert.assertEquals(getText(cr.emailval_1), Emailstudent1);
		// Assert.assertEquals(getText(ps.emailval_2), Emailstudent2);
		//
		// // click on create course button
		// click(cn.btn_Createcourse);
		//
		// waitThread(1000);
		// waitFor(cn.toaster);
		//
		// // verify toaster-Course created successfully
		// Assert.assertEquals(getText(cn.toaster).trim(), "Course created
		// successfully");
		//
		// waitThread(3000);
		//
		// // verify the course title
		// Assert.assertEquals(getText(cn.value_coursetitle).trim(),
		// CourseName.trim());

		// To perform logout functionality on the teacher profile
		// // logout functionality
		// rs.Logout();
		//
		// // Heading Title-Login
		// Assert.assertEquals(getText(lg.PageTitle), "Login");

		// To check that invited course request visible on first student 's
		// profile
		// and accept course request-Read the student name

		// lg.login("student1@gmail.com", password);
		// waitThread(5000);
		//
		// // verify heading label
		// waitFor(rs.lbl_joincourse);
		// Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");
		//
		// // verify course name visible
		// Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not
		// Present");
		//
		// // verify the the course name
		// Assert.assertEquals(getText(rs.course_name).trim(),
		// CourseName.trim());

	}
	/*
	 * To Accept course and perform logout functionality on the student profile
	 */
	// @Test(priority = 4)
	// public void TCSPR1300204() {
	// // click on accept course button
	// click(rs.btn_acceptcourse);
	//
	// // verify the confirmation pop up visible
	// Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box Not
	// visible");
	//
	// // click on Yes button
	// click(rs.popupbtn_Yes);
	//
	// // Toaster message
	// waitFor(rs.toaster);
	// Assert.assertEquals(getText(rs.toaster), "Course accepted successfully");
	//
	// // verify the course name visibled on the enrolled section
	// waitFor(rs.enrolledcoursename);
	//
	// Assert.assertEquals(getText(rs.enrolledcoursename).trim(),
	// CourseName.trim());
	// waitThread(3000);
	//
	// // perform logout functionality
	// rs.Logout();
	//
	// // Heading Title-Login
	// Assert.assertEquals(getText(lg.PageTitle), "Login");
	// }
	/*
	 * To check that invited course request visible on Second student 's profile
	 * and accept course request-Read the student name
	 */
	// @Test(priority = 5)
	// public void TCSPR1300205() {
	// lg.login("student2@gmail.com", password);
	//
	// waitThread(5000);
	//
	// // verify heading label
	// waitFor(rs.lbl_joincourse);
	// Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");
	//
	// // verify course name visible
	// Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not
	// Present");
	//
	// // verify the the course name
	// Assert.assertEquals(getText(rs.course_name).trim(), CourseName.trim());

	// }
	/*
	 * To Accept course and perform logout functionality on the student profile
	 * 
	 */

	//@Test(priority = 6)
	public void TCSPR1300206() {

		// // click on accept course button
		// click(rs.btn_acceptcourse);
		//
		// // verify the confirmation popup visible
		// Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box
		// Not
		// visible");
		//
		// // click on Yes button
		// click(rs.popupbtn_Yes);
		//
		// // Toaster message
		// waitFor(rs.toaster);
		// Assert.assertEquals(getText(rs.toaster), "Course accepted
		// successfully");
		//
		// // verify the course name visibled on the enrolled section
		// waitFor(rs.enrolledcoursename);
		// Assert.assertEquals(getText(rs.enrolledcoursename).trim(),
		// CourseName.trim());
		// waitThread(3000);
		// // perform logout functionality
		// rs.Logout();
		//
		// // Heading Title-Login
		// Assert.assertEquals(getText(lg.PageTitle), "Login");

		// lg.login("student2@gmail.com", password);
		//
		// waitThread(5000);
		//
		// // verify heading label
		// waitFor(rs.lbl_joincourse);
		// Assert.assertEquals(getText(rs.lbl_joincourse), "Join New Course");
		//
		// // verify course name visible
		// Assert.assertTrue(isElementPresent(rs.course_name), "Course Name Not
		// Present");
		//
		// // verify the the course name
		// Assert.assertEquals(getText(rs.course_name).trim(),
		// CourseName.trim());

		// // click on accept course button
		// click(rs.btn_acceptcourse);
		//
		// // verify the confirmation popup visible
		// Assert.assertTrue(isElementPresent(rs.box_confirmation), "Course box
		// Not
		// visible");
		//
		// // click on Yes button
		// click(rs.popupbtn_Yes);
		//
		// // Toaster message
		// waitFor(rs.toaster);
		// Assert.assertEquals(getText(rs.toaster), "Course accepted
		// successfully");
		//
		// // verify the course name visibled on the enrolled section
		// waitFor(rs.enrolledcoursename);
		// Assert.assertEquals(getText(rs.enrolledcoursename).trim(),
		// CourseName.trim());
		// waitThread(3000);
		// // perform logout functionality
		// rs.Logout();
		//
		// // Heading Title-Login
		// Assert.assertEquals(getText(lg.PageTitle), "Login");
	}

	public String CourseID = cm.CourseID2;
	public String CourseName = cm.CourseName2;

	public String CourseID_2 = cm.CourseID3;
	public String CourseName_2 = cm.CourseName3;

	/*
	 * To load the create new assessment page and fill details on the basic
	 * details page
	 */
	@Test(priority = 7)
	public void TCSPR1300207() {

		SoftAssert softAssert1 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(7000);
		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);
		waitThread(2000);
		// To click on course drop down
		click(ba.dd_course);

		// To search course on the course dropdown
		type(ba.coursesearchbox, CourseName);
		waitFor(ba.ddcoursename1);
		softAssert1.assertEquals(getText(ba.ddcoursename1), CourseName.trim(),
				"course name not visible on the dropdown");

		click(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		AssessmentName = "History" + generateRandomNumber().trim();
		System.out.println(AssessmentName);
		type(QP.Assess_name, AssessmentName);

		waitThread(2000);

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

	public String Question1;
	public String Question2;
	public String Rubric1;
	public String Question3;
	public String Rubric3;

	/*
	 * To fill details on the Question page [Question 1]
	 */
	@Test(priority = 8)
	public void TCSPR1300208() {
		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		Question1 = "Question 1" + generateRandomData();

		// Type a question on Question box
		type(QP.Quest_box, Question1);

		driver.switchTo().defaultContent();

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);
		Rubric1 = "Rubric 1" + generateRandomData();
		// Type data in Standard Rubric box
		type(QP.std_rub_bx, Rubric1);

		driver.switchTo().defaultContent();
		waitThread(1000);

		ScrollTo_xy_position(0, -250);

		// Enter Max score
		type(QP.max_scorbx, "10");

		// Click on +button
		click(mq.add_quest_btn);
		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);
		// Assert the label "2.Questions"
		Assert.assertEquals(getText(QP.question1), "2." + "\nQuestion");
	}

	public String Rubric2;

	/*
	 * To fill details on the Question page[Question 2]
	 */
	@Test(priority = 9)
	public void TCSPR1300209_2ndQuestion() {
		
		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		Question2 = "Question 2" + generateRandomData();

		// Type a question on Question box
		type(QP.Quest_box, Question2);

		driver.switchTo().defaultContent();

	}


	/*
	 * To perform rubric image upload functionality
	 */
	@Test(priority = 13)
	public void TCSPR1300209_2ndQuestionRubric() {
		

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");
		// Enter Condition
		driver.switchTo().frame("rubric_ifr");
		waitThread(2000);
		
		Rubric2 = "Rubric 2" + generateRandomData();
		
		// Type data in Standard Rubric box
		type(QP.std_rub_bx, Rubric2);

		driver.switchTo().defaultContent();
		waitThread(1000);

		ScrollTo_xy_position(0, -250);
		waitThread(6000);

	}

	/*
	 * To save the 2nd Question
	 */
	@Test(priority = 17)
	public void TCSPR1300209_2ndQuestion_score() {


		// Enter Max score
		type(QP.max_scorbx, "20");

		// Click on +button
		click(mq.add_quest_btn);
		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully");
		click(QP.toasterclosebtn);
		// Assert the label "2.Questions"
		Assert.assertEquals(getText(QP.question1), "3." + "\nQuestion");
	}

	/*
	 * To fill the Question and Rubric
	 */
	@Test(priority = 18)
	public void TCSPR1300210_QuestionandRubric() {

		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		Question3 = "Question 3" + generateRandomData();

		// Type a question on Question box
		type(QP.Quest_box, Question3);

		driver.switchTo().defaultContent();

		// Assert the radio button is selected
		Assert.assertTrue(isEnabled(QP.std_rad), "radio button is not selected");

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);
		Rubric3 = "Rubric3 " + generateRandomData();
		// Type data in Standard Rubric box
		type(QP.std_rub_bx, Rubric3);

		driver.switchTo().defaultContent();
		waitThread(1000);

	}

	/*
	 * To save the Question 3
	 */
	@Test(priority = 23)
	public void TCSPR1300210_3rdQuestion_score() {

		ScrollTo_xy_position(0, -250);
		waitThread(4000);

		click(QP.max_scorbx);
		// Enter Max score
		type(QP.max_scorbx, "30");
		waitThread(4000);
		// Click on +button
		click(mq.add_quest_btn);
		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 3 Saved successfully");
		click(QP.toasterclosebtn);
		// Assert the label "2.Questions"
		Assert.assertEquals(getText(QP.question1), "4." + "\nQuestion");
	}

	public String Question4;
	public String SampleAnswer4;

	/*
	 * To fill the Question 4
	 */
	@Test(priority = 24)
	public void TCSPR1300211_QuestionandRubric() {

		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		Question4 = "Question 4" + generateRandomData();

		// Type a question on Question box
		type(QP.Quest_box, Question4);

		driver.switchTo().defaultContent();

	}

	public String Criteria1;
	public String Criteria2;

	/*
	 * To Fill the clickable rubric
	 */
	@Test(priority = 25)
	public void TCSPR1300211_ClickableRubric() {
		
		click(QP.click_radio);
		waitThread(1000);
		// Assert the clickable rubric radio button is enabled
		Assert.assertTrue(isDisplayed(QP.click_radio), "Radio button is not checked");
//		ScrollTo_Location(QP.add_column);
		waitThread(1000);

		// Click Add column button
		Doubleclick(QP.add_column);
		driver.switchTo().frame(1);
		Assert.assertEquals(getAttribute(prp.clic_rub_place, "aria-placeholder"), "Enter Condition");
		driver.switchTo().defaultContent();

		waitThread(1000);
		Criteria1 = "Criteria1 " + generateRandomData();
		Criteria2 = "Criteria2 " + generateRandomData();
		// Type Criteria and score
		type(prp.criteria1, Criteria1);
		type(prp.scre_col00, "20");
		// Enter score
		type(prp.scre_col01, "15");
		// To Fill The condition
		driver.switchTo().frame("editorFieldRubric_00_ifr");
		type(prp.enter_con, "Very Good");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("editorFieldRubric_01_ifr");
		type(prp.enter_con, "Good");
		driver.switchTo().defaultContent();
	//	ScrollTo_Location(prp.sampleAnsweraccordian);

		// To Add a new row and fill the details
		Doubleclick((QP.add_row));
		// Assert the new row added is visible
		driver.switchTo().frame("editorFieldRubric_10_ifr");
		Assert.assertEquals(getAttribute(prp.clic_rub_place, "aria-placeholder"), "Enter Condition");
		driver.switchTo().defaultContent();
		type(prp.criteria2, Criteria2);
		// Enter score
		type(prp.scrore_r10, "10");
		// Enter score
		type(prp.score_r11, "5");

		// To add the conditions
		driver.switchTo().frame("editorFieldRubric_10_ifr");

		type(prp.enter_con, "Average");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("editorFieldRubric_11_ifr");

		type(prp.enter_con, "Below Average");
		driver.switchTo().defaultContent();

	}

	/*
	 * To fill the Sample Answer
	 */
	@Test(priority = 26)
	public void TCSPR1300211_Samplerubricanssave() {

		ScrollTo_Location(prp.sampleAnsweraccordian);
		click(prp.sampleAnsweraccordian);

		driver.switchTo().frame("sampleAnswer_ifr");

		SampleAnswer4 = "SampleAnswer4 " + generateRandomData();

		// Type Sample Answer
		type(prp.textbxsampleanswer, SampleAnswer4);

		driver.switchTo().defaultContent();

		ScrollTo_xy_position(0, -250);
		waitThread(4000);

		// To verify the Max score
		Assert.assertEquals(getValue(QP.max_scorbx), "30");
		waitThread(4000);

	}

	/*
	 * To verify the details on the peer review page
	 */
	@Test(priority = 27)
	public void TCSPR1300212() {

		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Question 4 Saved successfully");

		click(QP.toasterclosebtn);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		waitThread(2000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(pr.PRassessmentname_lbl).contains("Assessment Name: " + AssessmentName));
		// Assert course name
		Assert.assertTrue(getText(pr.PRcoursename_lbl).contains(CourseName.trim()));

		// Type the Reward Score Percentage
		type(prp.RewardScore, "50");

		// Assert the student names
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Student1name.trim());
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Student2name.trim());

	}

	/*
	 * To perform the save and next functionaity from peer review page and
	 * schedule the date and time
	 */
	@Test(priority = 28)
	public void TCSPR1300213() {

		click(pr.savennext_button);
		
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);
		waitThread(2000);
		Assert.assertEquals(getAttribute(sb1.schedule_wizard, "aria-expanded"), "true");

		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(3000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");
	}

	public String TotalQuestioncount1;
	public String maxscore1;

	/*
	 * To verify the details on the Summary page & publish the Assessment To
	 * perform Assessment publish functionality
	 */
	@Test(priority = 29)
	public void TCSPR1300214() {

		// To read the total question and max score
		TotalQuestioncount1 = getText(prp.total_questcount);
		maxscore1 = getText(prp.max_scorepos_count);

		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.summaryassessmentname).contains("Assessment Name: " + AssessmentName));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.summarycoursename).contains(CourseID));
		Assert.assertTrue(getText(sb.summarycoursename).contains(CourseName.trim()));

		// click on Release Button
		click(sb.btnrelease);

		waitFor(QP.toaster);
		// Assert toaster "Assessment published successfully
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");
		click(QP.toasterclosebtn);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(natb.publishpopup), "Publish popup not visible");
		waitThread(4000);
	}

	/*
	 * To check the back to menu button functionality and check the created
	 * assessment visible on the current assessment tab
	 */
	@Test(priority = 30)
	public void TCSPR1300215() {

		// click on Back To Menu Button
		click(natb.btnbacktomenu);
		Assert.assertFalse(isElementPresent(natb.publishpopup), "Publish popup  visible");
		waitThread(7000);

		// Search The Assessment Name
		type(sca.teacherassessmentsearchbox, AssessmentName.trim());
		waitThread(8000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(2000);

		// Assert the Assessment name visible
		Assert.assertEquals(getText(natb.cardassessmentname1), AssessmentName);
		Assert.assertEquals(getText(natb.cardcoursename1), "For" + " " + CourseName.trim() + "(" + CourseID + ")");

	}

	public String NewAssessmentName;

	/*
	 * To create a new assessment
	 */
	@Test(priority = 31)
	public void TCSPR1300216() {

		SoftAssert softAssert2 = new SoftAssert();

		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(8000);
		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		// To click on create new assessment button and verify label
		click(ba.btn_createnewassessment);

		// To click on course drop down
		click(ba.dd_course);

		// To search course on the course drop down
		type(ba.coursesearchbox, CourseName_2);
		waitFor(ba.ddcoursename1);
		softAssert2.assertEquals(getText(ba.ddcoursename1), CourseName_2.trim(),
				"course name not visible on the dropdown");

		click(ba.ddcoursename1);

		// Type Assessment Name
		click(QP.Assess_name);
		NewAssessmentName = "GK" + generateRandomNumber().trim();
		System.out.println(NewAssessmentName);
		type(QP.Assess_name, NewAssessmentName);

		waitThread(2000);

		// Click Save &Next button
		click(QP.Savenext);
		waitThread(1000);

		// Assert the label "Questions"
		Assert.assertEquals(getText(QP.Quest_wizard), "Questions");

		waitThread(3000);
		// Assert the assessment name
		Assert.assertEquals(getText(pr.QPassessname_lbl), NewAssessmentName);

		// Assert course name
		Assert.assertEquals(getText(pr.QPcoursename_lbl), "Course: " + CourseID_2 + ", " + CourseName_2.trim());

		softAssert2.assertAll();

	}

	/*
	 * To Fill the Question 1
	 */
	@Test(priority = 32)
	public void TCSPR1300217() {

		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question 1");

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
		type(QP.std_rub_bx, "R1");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "10");

		// Click on +button
		click(mq.add_quest_btn);
		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 1 Saved successfully");
		click(QP.toasterclosebtn);
		// Assert the label "2.Questions"
		Assert.assertEquals(getText(QP.question1), "2." + "\nQuestion");

	}

	/*
	 * To Fill the Question 2
	 */
	@Test(priority = 33)
	public void TCSPR1300218() {
		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question 2");

		driver.switchTo().defaultContent();


		ScrollTo_Location(QP.Qassessmentdetails);
		waitThread(3000);

		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R2");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "20");

		// Click on +button
		click(mq.add_quest_btn);
		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 2 Saved successfully");
		click(QP.toasterclosebtn);
		// Assert the label "2.Questions"
		Assert.assertEquals(getText(QP.question1), "3." + "\nQuestion");
	}

	/*
	 * To Fill the Question 3
	 */
	@Test(priority = 34)
	public void TCSPR1300219() {
		waitThread(3000);

		// To enter the data on Question box
		driver.switchTo().frame("question_ifr");

		// click on Question box
		Doubleclick(QP.Quest_box);

		// Type a question on Question box
		type(QP.Quest_box, "Question 3");

		driver.switchTo().defaultContent();

		ScrollTo_Location(QP.Qassessmentdetails);
		// Enter Condition
		driver.switchTo().frame("rubric_ifr");

		waitThread(2000);

		// Type data in Standard Rubric box
		type(QP.std_rub_bx, "R3");

		driver.switchTo().defaultContent();
		waitThread(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

		// Enter Max score
		type(QP.max_scorbx, "30");
		// Click Save&Next button
		click(QP.savenext_btn);

		waitFor(QP.toaster);
		// Assert a toaster Saved successfully
		Assert.assertEquals(getText(QP.toaster), "Question 3 Saved successfully");
		click(QP.toasterclosebtn);

		// Assert the peer review wizard is selected
		Assert.assertTrue(isEnabled(pr.peerrev_wizard), "peer review wizard is selected");

		// Assert the label "Peer Review"
		Assert.assertEquals(getText(QP.peer_reviewlbl), "Peer Review");
	}

	/*
	 * To verify the details on the Peer Review Page
	 */
	@Test(priority = 35)
	public void TCSPR1300220() {

		// click on Answer sheet per student drop down
		click(ps.anssheetperstu_drp);

		waitThread(2000);
		// Assert the Answer Sheets Per Student drop down is disabled
		Assert.assertTrue(isElementPresent(ps.anssheetperstu_drplist), "Answer Sheets Per Student dropdown is present");

		// Select Answer Sheets Per Student is 2
		click(ps.anssheetperstu_drpcount2);
		waitThread(2000);

		type(prp.RewardScore, "50");
		// Assert the Answer sheets to be assigned to the Peer Reviewer having 2
		// columns
		Assert.assertEquals(TotalElementsCount(ps.studant1_columncount), 2);

		// Assert the first student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname1_gridval).trim(), Student1name);

		// Assert the second student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname2_gridval).trim(), Student2name);

		// Assert the Third student name on the Grid-[Peer Reviewer section ]
		Assert.assertEquals(getText(ps.studantname3_gridval).trim(), Student3name);
	}

	/*
	 * To schedule date and time for Assessment
	 */
	@Test(priority = 36)
	public void TCSPR1300221() {

		// click on save and next button
		click(pr.savennext_button);
		
		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Saved successfully");

		click(QP.toasterclosebtn);

		waitThread(2000);
		Assert.assertEquals(getAttribute(sb1.schedule_wizard, "aria-expanded"), "true");

		// Click Save&Next button
		click(QP.savenext_btn);

		waitThread(4000);
		// Assert the summary wizard is selected
		Assert.assertEquals(getAttribute(sb.summarywizard, "aria-selected"), "true");

	}

	public String TotalQuestioncount2;
	public String maxscore2;

	/*
	 * To perform Assessment publish functionality
	 */
	@Test(priority = 37)
	public void TCSPR1300222() {

		// To Read the Total Question and max score
		TotalQuestioncount1 = getText(prp.total_questcount);
		maxscore1 = getText(prp.max_scorepos_count);
		waitThread(3000);
		// Assert the label assessment name,
		Assert.assertTrue(getText(sb.summaryassessmentname).contains("Assessment Name: " + NewAssessmentName));

		// Assert course code,course name
		Assert.assertTrue(getText(sb.summarycoursename).contains(CourseID_2));
		Assert.assertTrue(getText(sb.summarycoursename).contains(CourseName_2.trim()));

		// click on Release Button
		click(sb.btnrelease);

		waitFor(QP.toaster);
		// Assert toaster "Assessment published successfully
		Assert.assertEquals(getText(QP.toaster), "Assessment published successfully");
		click(QP.toasterclosebtn);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(natb.publishpopup), "Publish popup not visible");
		waitThread(4000);

	}

	/*
	 * To verify the published Assessment details on the card
	 */
	@Test(priority = 38)
	public void TCSPR1300223() {

		// click on Back To Menu Button
		click(natb.btnbacktomenu);
		Assert.assertFalse(isElementPresent(natb.publishpopup), "Publish popup  visible");
		waitThread(7000);

		// Search The Assessment Name
		type(sca.teacherassessmentsearchbox, NewAssessmentName.trim());
		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(2000);

		// Assert the Assessment name visible
		Assert.assertEquals(getText(natb.cardassessmentname1), NewAssessmentName);
		Assert.assertEquals(getText(natb.cardcoursename1), "For" + " " + CourseName_2.trim() + " (" + CourseID_2 + ")");

	}

	public String timertext;

	/*
	 * To perform Login of Student 1 and Begin the Test
	 */
	@Test(priority = 39)
	public void TCSPR1300224() throws InterruptedException {

		// Perform Log out of Teacher
		prp.Logout();

		waitThread(2000);
		// Login as Student 1
		lg.login("student1@gmail.com", password);
		waitThread(2000);
		// click on Assessments Tab
		click(sca.Assessmenttab);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		waitThread(5000);
		// Search The Assessment Name
		type(sca.searchbox, AssessmentName.trim());
		driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");

		// Assert the Assessment name and course name visible on the card
		Assert.assertEquals(getText(natb.cardassessmentname1), AssessmentName);
		Assert.assertEquals(getText(natb.cardcoursename1), "For" + " " + CourseName.trim() + " (" + CourseID + ")");

		// verify the teacher name
		Assert.assertEquals(getText(asp.teachernameoncard), Teachername);

		// To verify the begin test button visible or not

		if (isElementPresent((asp.btnbeginTest)) == true) {

			waitThread(3000);
			// click on Begin Test button
			click(asp.btnbeginTest);
			waitThread(3000);
			Assert.assertTrue(isElementPresent(asp.Questionwizard), "Test Window page not visible");
		}

		else {

			// wait for 1 min
			TimeUnit.MINUTES.sleep(1);
			waitThread(1000);

			// To get the timer text
			timertext = getText(asp.Assessmenttimerlabel);
			waitThread(2000);
			// To verify the begin test button visible
			Assert.assertTrue(isElementPresent(asp.btnbeginTest), "Begin Test button Not visible");
			waitThread(1000);

			// click on begin test button
			click(asp.btnbeginTest);
			Assert.assertTrue(isElementPresent(asp.Questionwizard), "Test Window page not visible");
		}
	}

	public String Stud1_Answer1;
	public String Stud1_Answer2;
	public String Stud1_Answer3;
	public String Stud1_Answer4;

	/*
	 * To Fill the ANswer 1
	 */
	@Test(priority = 40)
	public void TCSPR1300225_Answer1() {

		// verify the Assessment name on the test window
		Assert.assertEquals(getText(asp.testassessmentname), AssessmentName.trim());
		// Assert the first question is selected on wizard
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));
		Stud1_Answer1 = "Student 1 Answer 1 " + generateRandomData();

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer1
		type(an.ansplaceholder, Stud1_Answer1);

		driver.switchTo().defaultContent();

		click(ms.time_status);

		SwitchFrame("answer_ifr");
		waitThread(1000);
		driver.findElement(By.xpath(an.ansplaceholder)).sendKeys(Keys.ENTER);

		// driver.findElement(By.xpath("an.ansplaceholder")).sendKeys(Keys.ENTER);
		driver.switchTo().defaultContent();

	}

	/*
	 * To Fill the Answer 2
	 */
	@Test(priority = 43)
	public void TCSPR1300225_Answer2() {
		
		// Click Save button
		click(an.saveNext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		click(QP.toasterclosebtn);

		// To verify the 2nd question wizard is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));

		SwitchFrame("answer_ifr");
		waitThread(1000);
		Stud1_Answer2 = "Student 1 Answer 2 " + generateRandomData();
		// Enter Answer1
		type(an.ansplaceholder, Stud1_Answer2);

		driver.switchTo().defaultContent();

		click(ms.time_status);

		SwitchFrame("answer_ifr");
		waitThread(1000);
		driver.findElement(By.xpath(an.ansplaceholder)).sendKeys(Keys.ENTER);

		driver.switchTo().defaultContent();

	}

	/*
	 * To fill Answer 3
	 */
	@Test(priority = 45)
	public void TCSPR1300226() {

		// click on my answer is incomplete check box
		click(asp.incompleteanschkbx);
		// To verify the my answer is incomplete check box is selected
		Assert.assertTrue(getAttribute(asp.incompletechked, "class").contains("p-checkbox-checked"));
		waitThread(1000);
		// Click Save button
		click(an.saveNext_btn);
		waitThread(2000);
		// To verify the Answer 3 wizard is selected
		Assert.assertTrue(getAttribute(asp.wizardans3, "class").contains("p-highlight"));
		waitThread(2000);
		// To verify the wizard status of question 2 is incomplete
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("incomplete"));

		Stud1_Answer3 = "Student 1 Answer 3 " + generateRandomData();

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer1
		type(an.ansplaceholder, Stud1_Answer3);

		driver.switchTo().defaultContent();
		// click on save button
		click(asp.testbtnsave);
		waitFor(QP.toaster);
		// Assert the toaster "Answer Saved"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

	}

	/*
	 * To fill Answer 4 and submit the Test
	 */
	@Test(priority = 46)
	public void TCSPR1300227() {

		// Click Save button
		click(an.saveNext_btn);
		waitThread(2000);
		// To verify the Answer 3 wizard is selected
		Assert.assertTrue(getAttribute(asp.wizardans4, "class").contains("p-highlight"));
		waitThread(2000);

		Stud1_Answer4 = "Student 1 Answer 4 " + generateRandomData();

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer1
		type(an.ansplaceholder, Stud1_Answer4);

		driver.switchTo().defaultContent();
		// click on save button
		click(asp.testbtnsave);
		waitFor(QP.toaster);
		// Assert the toaster "Answer Saved"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		// click on Submit button
		click(asp.testbtnsubmit);

		// to click the submit button on the confirmation pop up
		click(asp.confirmationsubmit);
		waitFor(QP.toaster);
		// verify toaster "Assessment Submitted"
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");
		click(QP.toasterclosebtn);
		// To verify the confirmation pop up not visible
		Assert.assertFalse(isElementPresent(asp.testwindowconfirmpopup), "Test Window confirmation pop up not visible");
		// click on back to Assessment button
		click(asp.btnbacktoassessment);
		// To verify the Test confirmation pop up not visible
		Assert.assertFalse(isElementPresent(asp.tstSubmitAnswerPopup), "Test confirmation pop up visible");
		waitThread(1000);
		// To verify the current assessment tab is not visible
		Assert.assertEquals(getAttribute(sca.selectedcurrenttab, "aria-selected"), "true");

	}

	/*
	 * To Begin the test of Assessment 2
	 */
	@Test(priority = 47)
	public void TCSPR1300228() {
		waitThread(2000);
		// Search The Assessment Name
		type(sca.searchbox, NewAssessmentName.trim());
		driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(3000);
		// Assert the Assessment name and course name visible on the card
		Assert.assertEquals(getText(natb.cardassessmentname1), NewAssessmentName);
		Assert.assertEquals(getText(natb.cardcoursename1), "For" + " " + CourseName_2.trim() + " (" + CourseID_2 + ")");

		// verify the teacher name
		Assert.assertEquals(getText(asp.teachernameoncard), Teachername);

		// click on begin test button
		click(asp.btnbeginTest);
		Assert.assertTrue(isElementPresent(asp.Questionwizard), "Test Window page not visible");
		waitThread(2000);

		// verify the course name,assessment name,teacher name
		Assert.assertEquals(getText(asp.testassessmentname), NewAssessmentName.trim());
		Assert.assertEquals(getText(asp.testcoursename), "Course: " + CourseID_2 + "," + " " + CourseName_2.trim());
		Assert.assertEquals(getText(asp.testeachername), "Teacher: " + Teachername);

	}

	/*
	 * To Fill Answers of Question 1,2 & 3
	 */
	@Test(priority = 48)
	public void TCSPR1300229() {
		SoftAssert softassert29 = new SoftAssert();
		waitThread(2000);
		// Assert the first question is selected on wizard
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer1
		type(an.ansplaceholder, Stud1_Answer1);

		driver.switchTo().defaultContent();

		// Click Save button
		click(an.saveNext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		softassert29.assertEquals(getText(QP.toaster), "Answer Saved", "Assertion Failed");

		// To verify the 2nd question wizard is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));

		SwitchFrame("answer_ifr");
		waitThread(1000);
		// Enter Answer1
		type(an.ansplaceholder, Stud1_Answer2);

		driver.switchTo().defaultContent();

		// Click Save button
		click(an.saveNext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		softassert29.assertEquals(getText(QP.toaster), "Answer Saved");
		click(QP.toasterclosebtn);

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer1
		type(an.ansplaceholder, Stud1_Answer3);

		driver.switchTo().defaultContent();

		// Click Save button
		click(an.save_btn);
		waitThread(1000);
		waitFor(QP.toaster);
		// Assert the toaster "Answer Saved"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");
		click(QP.toasterclosebtn);
	}

	/*
	 * To Submit the Assessment 2 Test
	 */
	@Test(priority = 49)
	public void TCSPR1300230() {
		
		waitThread(2000);
		// click on Submit button
		click(asp.testbtnsubmit);
		waitThread(2000);
		// to click the submit button on the confirmation pop up
		click(asp.confirmationsubmit);
		waitFor(QP.toaster);
		// verify toaster "Assessment Submitted"
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");
		click(QP.toasterclosebtn);
		// To verify the confirmation pop up not visible
		Assert.assertFalse(isElementPresent(asp.testwindowconfirmpopup), "Test Window confirmation pop up not visible");
		// click on back to Assessment button
		click(asp.btnbacktoassessment);
		// To verify the Test confirmation pop up not visible
		Assert.assertFalse(isElementPresent(asp.tstSubmitAnswerPopup), "Test confirmation pop up visible");
		waitThread(1000);
		// To verify the current assessment tab is not visible
		Assert.assertEquals(getAttribute(sca.selectedcurrenttab, "aria-selected"), "true");

	}

	/*
	 * To search the Assessment 2 card on student 2 profile
	 */
	@Test(priority = 50)
	public void TCSPR1300231() {

		// Perform LOgout of Student 1
		prp.Logout();

		// Login as student 2
		waitThread(2000);
		lg.login("student2@gmail.com", password);
		waitThread(2000);
		// click on Assessments Tab
		click(sca.Assessmenttab);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		waitThread(5000);
		// Search The Assessment Name
		type(sca.searchbox, NewAssessmentName.trim());
		driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(3000);
		// Assert the Assessment name and course name visible on the card
		Assert.assertEquals(getText(natb.cardassessmentname1), NewAssessmentName);

	}

	public String Stud2_Answer1 = "Student 2 Answer 1";
	public String Stud2_Answer2 = "Student 2 Answer 2";
	public String Stud2_Answer3 = "Student 2 Answer 3";

	/*
	 * To check the Assessment 2 Details on the student test window and Fill
	 * Answer 1 and 2
	 */
	@Test(priority = 51)
	public void TCSPR1300232() {

		waitThread(3000);
		// click on begin test button
		click(asp.btnbeginTest);
		Assert.assertTrue(isElementPresent(asp.Questionwizard), "Test Window page not visible");
		waitThread(2000);

		// verify the course name,assessment name,teacher name
		Assert.assertEquals(getText(asp.testassessmentname), NewAssessmentName.trim());
		Assert.assertEquals(getText(asp.testcoursename), "Course: " + CourseID_2 + "," + " " + CourseName_2.trim());
		Assert.assertEquals(getText(asp.testeachername), "Teacher: " + Teachername);

		// Assert the first question is selected on wizard
		Assert.assertTrue(getAttribute(an.ques1_lbl, "class").contains("p-highlight"));

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer1
		type(an.ansplaceholder, Stud2_Answer1);

		driver.switchTo().defaultContent();

		// Click Save button
		click(an.saveNext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Answer Saved"
		Assert.assertEquals(getText(QP.toaster), "Answer Saved");

		SwitchFrame("answer_ifr");
		waitThread(1000);
		// Enter Answer1
		type(an.ansplaceholder, Stud2_Answer2);

		driver.switchTo().defaultContent();
		// To verify the 2nd question wizard is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));

	}

	/*
	 * To save Answer 3
	 */
	@Test(priority = 52)
	public void TCSPR1300233() {

		SoftAssert softAssert33 = new SoftAssert();
		waitThread(1000);
		// Click Save button
		click(an.saveNext_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Saved successfully"
		softAssert33.assertEquals(getText(QP.toaster), "Answer Saved", "Assertion Failed");
		click(QP.toasterclosebtn);

		SwitchFrame("answer_ifr");
		waitThread(1000);

		// Enter Answer1
		type(an.ansplaceholder, Stud2_Answer3);

		driver.switchTo().defaultContent();
		waitThread(1000);
		// Click Save button
		click(an.save_btn);

		waitFor(QP.toaster);
		// Assert the toaster "Answer Saved"
		softAssert33.assertEquals(getText(QP.toaster), "Answer Saved", "Assertion Failed");
		click(QP.toasterclosebtn);
		waitThread(4000);
		softAssert33.assertAll();
	}

	/*
	 * To submit the Assessment 2
	 */
	@Test(priority = 53)
	public void TCSPR1300233_Assessmentsubmit() {

		TCSPR1300230();
	}

	/*
	 * To search the Assessment 1 on the student 2 profile and submit the test
	 * without fill Answers
	 */
	@Test(priority = 54)
	public void TCSPR1300234() {

		// Search The Assessment Name
		type(sca.searchbox, AssessmentName.trim());
		driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(3000);
		// Assert the Assessment name and course name visible on the card
		Assert.assertEquals(getText(natb.cardassessmentname1), AssessmentName);

		// click on Resume Test button
		click(asp.buttontestbegin);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(asp.Questionwizard), "Test Window page not visible");

		// verify the course name,assessment name,teacher name
		Assert.assertEquals(getText(asp.testassessmentname), AssessmentName.trim());

		// click submit button
		click(ms.submit_btn);
		waitThread(1000);
		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");

		// Assert the text "You have 4 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(prp.confirmation_txt), "You have 4 skipped question(s)! Proceed to submit?");

		click(ms.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Assessment Submitted"
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		// click on back to Assessment button
		click(asp.btnbacktoassessment);
		// To verify the Test confirmation pop up not visible
		Assert.assertFalse(isElementPresent(asp.tstSubmitAnswerPopup), "Test confirmation pop up visible");
		waitThread(1000);
		// To verify the current assessment tab is not visible
		Assert.assertEquals(getAttribute(sca.selectedcurrenttab, "aria-selected"), "true");

	}

	/*
	 * To login as student 3 and search the Assessment 1
	 */
	@Test(priority = 55)
	public void TCSPR1300235() {

		// Perform Logout on student 2
		prp.Logout();
		// Login as student 3
		waitThread(2000);
		lg.login("student3@gmail.com", password);
		waitThread(2000);
		// click on Assessments Tab
		click(sca.Assessmenttab);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		waitThread(5000);

		// Search The Assessment Name
		type(sca.searchbox, NewAssessmentName.trim());
		driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(3000);
		// Assert the Assessment name and course name visible on the card
		Assert.assertEquals(getText(natb.cardassessmentname1), NewAssessmentName);

	}

	/*
	 * To submit the test with out fill Answers
	 */
	@Test(priority = 56)
	public void TCSPR1300236() {

		// click on Resume Test button
		click(asp.buttontestbegin);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(asp.Questionwizard), "Test Window page not visible");

		// verify the course name,assessment name,teacher name
		Assert.assertEquals(getText(asp.testassessmentname), NewAssessmentName.trim());

		// click submit button
		click(ms.submit_btn);
		waitThread(2000);
		Assert.assertTrue(isDisplayed(ms.confir_popup), "popup not visible");

		// Assert the text "You have 4 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(ms.confirmation_txt), "You have 3 skipped question(s)! Proceed to submit?");

		click(ms.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Saved successfully"
		Assert.assertEquals(getText(QP.toaster), "Assessment Submitted");

		click(QP.toasterclosebtn);

		// click on back to Assessment button
		click(asp.btnbacktoassessment);
		waitThread(5000);
		// To verify the Test confirmation pop up not visible
		Assert.assertFalse(isElementPresent(asp.tstSubmitAnswerPopup), "Test confirmation pop up visible");
		waitThread(1000);
		// To verify the current assessment tab is not visible
		Assert.assertEquals(getAttribute(sca.selectedcurrenttab, "aria-selected"), "true");
		
		cm.Logout();

	}
	

	/*
	 * To perform reschedule of Test Window and Peer Review window-NewAssessmentName
	 */
	@Test(priority = 57)
	public void RescheduleTestAndPeerDate_1() {

		// Login as Teacher
		cm.login(cm.emailteacher, cm.Password);
		waitThread(1000);
		// click on Assessment tab
		click(ba.Assessmenttab);
		waitThread(5000);
		
		// Assert button create new assessment
		Assert.assertTrue(isElementPresent(ba.btn_createnewassessment), "create new assessment not present");

		// Search The Assessment Name
		type(sca.teacherassessmentsearchbox, NewAssessmentName);
		waitThread(5000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(3000);

		// Click menu button
		click(rd.threedot_btn);
		Assert.assertTrue(isElementPresent(rd.reschedulemenu), "Reschedule Dates menu not present");
		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(2000);
		// Assert the Reschedule popup visible
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");
		click(rd.assessmentduedate_txtbx);

		// To select Todays Date
		cm.ClickTodaysDate();

		waitThread(1000);
		click(rd.peerreviewopendate_txtbx);
		waitThread(1000);
		// To select Todays date
		 cm.ClickTodaysDate_PeerReview();
		 	 
		 waitThread(1000);
		// click on Apply changes button
		click(rd.Applychangesbtn);

		waitThread(5000);
		// Assert popup not visible
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");
	}
	/*
	 * To perform reschedule of Test Window and Peer Review window-AssessmentName
	 */
	@Test(priority = 58)
	public void RescheduleTestAndPeerDate_2() {

		waitThread(6000);
		
		// Search The Assessment Name
		type(sca.teacherassessmentsearchbox, AssessmentName);
		waitThread(1000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(3000);

		// Click menu button
		click(rd.threedot_btn);
		Assert.assertTrue(isElementPresent(rd.reschedulemenu), "Reschedule Dates menu not present");
		// Click Reschedule dates
		click(rd.reschedulemenu);
		waitThread(2000);
		// Assert the Reschedule popup visible
		Assert.assertTrue(isElementPresent(rd.reschedulepopup), "Popup not present");
		click(rd.assessmentduedate_txtbx);

		// To select Todays Date
		cm.ClickTodaysDate();

		waitThread(1000);
		click(rd.peerreviewopendate_txtbx);
		waitThread(1000);
		// To select Todays date
		 cm.ClickTodaysDate_PeerReview();
		 	 
		 waitThread(1000);
		// click on Apply changes button
		click(rd.Applychangesbtn);

		waitThread(5000);
		// Assert popup not visible
		Assert.assertFalse(isElementPresent(rd.reschedulepopup), "Popup  present");
		cm.Logout();
	}
	/*
	 * To perform Begin Review Functionality of Assessment 2,To check the save
	 * and Exit button functionality on the Peer review window
	 */
	@Test(priority = 59)
	public void TCSPR1300237() throws InterruptedException {

		SoftAssert softassert37 = new SoftAssert();
		
		// Login as student 3
		waitThread(2000);
		lg.login("student3@gmail.com", password);
		waitThread(2000);
		// click on Assessments Tab
		click(sca.Assessmenttab);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		waitThread(5000);
		// wait for 1.5 min
		TimeUnit.MINUTES.sleep(1);
		TimeUnit.SECONDS.sleep(50);
		// Search The Assessment Name
		type(sca.searchbox, NewAssessmentName.trim());
		driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(3000);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(3000);

		// Click on Begin Review button
		click(prp.btnbeginReview);
		waitThread(6000);
		Assert.assertTrue(isElementPresent(prp.Reviewwizard), "Peer Review Window page not visible");
		waitThread(5000);
		// To verify the Assessment Details
		softassert37.assertEquals(getText(asp.testassessmentname), NewAssessmentName.trim(), "Assertion Failed");
		waitThread(2000);
		softassert37.assertEquals(getText(asp.testcoursename),
				"Course: " + CourseID_2 + "," + " " + CourseName_2.trim(), "Assertion Failed");
		softassert37.assertEquals(getText(asp.testeachername), "Teacher: " + Teachername, "Assertion Failed");
		// Assert.assertEquals(getText(asp.testtimeleft), "Time left: " +
		// timertext);

		// To verify the first question is selected
		Assert.assertTrue(getAttribute(asp.wizardans1, "class").contains("p-highlight"));
		waitThread(1000);
		Assert.assertEquals(getText(prp.maxscore), "Max Score: 10");
		// click on Question 2 wizard
		click(asp.wizardans2);
		waitThread(2000);
		// To verify the 2nd question wizard is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));
		// To verify the 1st question wizard is not selected,and it's status
		Assert.assertFalse(getAttribute(asp.wizardans1, "class").contains("p-highlight"));
		Assert.assertTrue(getAttribute(asp.wizardans1, "class").contains("visitednotattended"));
		waitThread(1000);

		// verify the save button is Disabled
		Assert.assertFalse(isEnabled(prp.reviewbtnsave), "Save Button is Enabled");

		// click on save and exit button
		click(prp.reviewbtnsaveandexit);
		waitThread(5000);
		// To check the current assessment tab is selected
		Assert.assertEquals(getAttribute(sca.selectedcurrenttab, "aria-selected"), "true");

		waitThread(3000);
		// Search The Assessment Name
		driver.findElement(By.xpath(sca.searchbox)).sendKeys(NewAssessmentName);
		driver.findElement(By.xpath(sca.searchbox)).sendKeys("   ");
		waitThread(4000);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");

		// click on Begin Review Button
		click(prp.btnbeginReview);
		waitThread(4000);
		// verify the 2nd wizard is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));
		softassert37.assertAll();
	}

	/*
	 * To Add score to student functionality on the peer review page
	 */
	@Test(priority = 59)
	public void TCSPR1300238() {

		waitThread(3000);
		// click on Question 1 wizard
		click(asp.wizardans1);
		waitThread(4000);
		// verify the Question 1 wizard is selected
		Assert.assertTrue(getAttribute(asp.wizardans1, "class").contains("p-highlight"));
		// verify the Max Score
		Assert.assertEquals(getText(prp.maxscore), "Max Score: 10");
		// Type Score for Student 1[Question 1]
		click(prp.scorestud1);
		waitThread(1000);
		
		driver.findElement(By.xpath(prp.scorestud1)).sendKeys("5");
		driver.findElement(By.xpath(prp.scorestud1)).sendKeys("0");

		waitThread(3000);
		// verify the save button is Enabled
		Assert.assertTrue(isEnabled(prp.reviewbtnsave), "Save Button is Disabled");
		waitThread(1000);

		// click on save button
		click(prp.reviewbtnsave);
		waitFor(QP.toaster);
		// Assert the toaster "Saved"
		Assert.assertEquals(getText(QP.toaster), "Saved");
		click(QP.toasterclosebtn);
		waitThread(1000);
		click(prp.scorestud1);
		waitThread(1000);
		driver.findElement(By.xpath(prp.scorestud1)).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath(prp.scorestud1)).sendKeys(Keys.BACK_SPACE);
		// Type new score for student 1[Question 1]
		driver.findElement(By.xpath(prp.scorestud1)).sendKeys("6");
		waitThread(1000);
		// click on save button
		click(prp.reviewbtnsave);
		waitFor(QP.toaster);
		// verify toaster Saved
		Assert.assertEquals(getText(QP.toaster), "Saved");
		click(QP.toasterclosebtn);
		waitThread(3000);

		// click on Save and Next button
		click(prp.reviewbtnsaveandnext);
		// verify toaster not visible
		Assert.assertFalse(isElementPresent(QP.toaster), "Toaster visible");
		// verify the Question 2 wizard is selected[Question 2]
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));
		waitThread(3000);
		// click on Question 1 wizard
		click(asp.wizardans1);
		waitThread(4000);
		ScrollTo_Location(prp.scorestud1);
		waitThread(3000);
		// verify the Added score visible[Question 1]
		Assert.assertEquals(getValue(prp.scorestud1), "6");

		// click on save and next button
		click(prp.reviewbtnsaveandnext);
		waitThread(1000);
		// verify the Question 2 wizard is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));
	}

	public String commentstudent1 = "Comment for student 1";

	/*
	 * To perform Add comment to a student's answer functionality
	 */
	@Test(priority = 59)
	public void TCSPR1300239() {

		waitThread(1000);
		// verify the comment box placeholder
		Assert.assertEquals(getAttribute(prp.stud1comment, "placeholder"), "Click here to enter your comment");

		// Type Score for student 1[Question 2]
		type(prp.scorestud1, "5");
		waitThread(2000);
		// verify that the comment box is Enabled[Question 2]
		Assert.assertFalse(getAttribute(prp.stud1comment, "class").contains("disabled"));

		// click on student 1 comment box[Question 2]
		click(prp.stud1comment);
		waitThread(2000);
		// verify the popup visible and check the placeholder,save and close
		// button of comment popup
		Assert.assertTrue(isElementPresent(prp.popupcomment), "Comment popup not  visible");
		Assert.assertEquals(getAttribute(prp.txtbx_comment, "placeholder"), "Enter the comment about the answer");
		Assert.assertTrue(isElementPresent(prp.commentclose_btn), "Comment box close button not visible");
		Assert.assertTrue(isElementPresent(prp.commentsave_btn), "Comment box save button not visible");

		// click on comment popup close button
		click(prp.commentclose_btn);
		waitThread(2000);
		// verify the comment popup is not visible
		Assert.assertFalse(isElementPresent(prp.popupcomment), "Comment popup  visible");
		waitThread(2000);
		// verify the student 1 comment box is Empty[Question 2]
		Assert.assertEquals(getValue(prp.stud1comment), "");
		// click on Student 1 comment box[Question 2]
		waitThread(2000);

		// click on Student 1 comment box[Question 2]
		click(prp.stud1comment);
		// verify the popup visible
		Assert.assertTrue(isElementPresent(prp.popupcomment), "Comment popup not  visible");
		waitThread(2000);
		// Type Comment for student 1[Question 2]
		type(prp.txtbx_comment, commentstudent1);
		waitThread(2000);
		// click on comment save button[Question 2]
		click(prp.commentsave_btn);
		waitThread(2000);
		// verify the comment box not visible[Question 2]
		Assert.assertFalse(isElementPresent(prp.popupcomment), "Comment popup  visible");
		// Type Comment for student 1[Question 2]
		Assert.assertEquals(getValue(prp.stud1comment), commentstudent1);
		waitThread(2000);

		// click on Next Arrorw
		click(prp.nextarrowbtn);
		waitFor(QP.toaster);
		// verify the toaster "Score Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);
		// verify the Question 3 is selected
		Assert.assertTrue(getAttribute(asp.wizardans3, "class").contains("p-highlight"));

		// click on Previous Arrow
		click(prp.previousarrowbtn);
		waitThread(2000);
		// verify the Question 2 is selected[Question 2]
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));
		// verify the Added comment and score visible[Question 2]
		Assert.assertEquals(getValue(prp.stud1comment), commentstudent1);
		Assert.assertEquals(getValue(prp.scorestud1), "5");
		waitThread(2000);
		// click on previous arrow
		click(prp.previousarrowbtn);
		waitThread(2000);
		// verify the Question 1 is selected
		Assert.assertTrue(getAttribute(asp.wizardans1, "class").contains("p-highlight"));
	}

	public String commentstudent2 = "Comment for studnet 2";

	/*
	 * To perform review of student 2 and check the wizard status and perform
	 * save and exit functionality
	 */
	@Test(priority = 60)
	public void TCSPR1300240() {
		ScrollTo_Location(prp.stud2comment);
		// click on Student 2 Comment box[Question 1]
		waitThread(2000);
		click(prp.stud2comment);
		waitThread(1000);
		// verify the comment box popup visible
		Assert.assertTrue(isElementPresent(prp.popupcomment), "Comment popup not  visible");
		waitThread(2000);
		// Type comment for student 2[Question 1]
		type(prp.txtbx_comment, commentstudent2);
		waitThread(2000);
		// click on save button
		click(prp.commentsave_btn);
		waitThread(2000);
		// verify the comment popup not visible
		Assert.assertFalse(isElementPresent(prp.popupcomment), "Comment popup  visible");
		// verify the added comment viisble
		Assert.assertEquals(getValue(prp.stud2comment), commentstudent2);
		waitThread(2000);

		// Type Score for student 2[Question 1]
		type(prp.scorestud2, "0");
		waitThread(2000);
		// click on save and exit button
		click(prp.reviewbtnsaveandexit);
		waitFor(QP.toaster);
		// Assert the toaster "Assessment Saved"
		Assert.assertEquals(getText(QP.toaster), "Review Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);
		// To check the current assessment tab is selected
		Assert.assertEquals(getAttribute(sca.selectedcurrenttab, "aria-selected"), "true");
		waitThread(2000);

		// Search The Assessment Name
		type(sca.searchbox, NewAssessmentName);
		driver.findElement(By.xpath(sca.searchbox)).sendKeys("  ");
		waitThread(7000);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");

		// click on Begin review button
		click(prp.btnbeginReview);
		waitThread(10000);
		// verify the Question 1 wizard is selected
		Assert.assertTrue(getAttribute(asp.wizardans1, "class").contains("p-highlight"));
		// verify the added comment and score visible for student 2[Question 1]
		Assert.assertEquals(getValue(prp.stud2comment), commentstudent2);
		Assert.assertEquals(getValue(prp.scorestud2), "0");
		waitThread(2000);

		// click on save and next button
		click(prp.reviewbtnsaveandnext);
		waitThread(2000);
		// verify the Answer 2 is selected
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));

		// click on student 2 comment box[Question 2]
		click(prp.stud2comment);
		// verify the comment box popup visible[Question 2]
		Assert.assertTrue(isElementPresent(prp.popupcomment), "Comment popup not  visible");
		waitThread(2000);
		// Type studnet 2 comment[Question 2]
		type(prp.txtbx_comment, commentstudent2);
		// click on save button
		click(prp.commentsave_btn);
		waitThread(2000);
		// verify the comment pop up not visible[Question 2]
		Assert.assertFalse(isElementPresent(prp.popupcomment), "Comment popup  visible");
		// verify the Added comment visible on the student 1 comment
		// box[Question 2]
		Assert.assertEquals(getValue(prp.stud2comment), commentstudent2);

		// Type score for student 2[Question 2]
		type(prp.scorestud2, "10");
		// click on save button
		click(prp.reviewbtnsave);
		waitFor(QP.toaster);
		// verify toaster "Saved"
		Assert.assertEquals(getText(QP.toaster), "Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);
		// verify the wizard status is reviewed[Question 2]
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("complete"));

	}

	/*
	 * To check the discard popup functionality on the peer review page[When
	 * click on My courses tab]
	 */
	@Test(priority = 61)
	public void TCSPR1300241() {

		// Edit the score for Student 1[Question 2]
		type(prp.scorestud1, "10");
		waitThread(1000);

		// Click course tab
		click(an.coursetab);
		waitThread(1000);
		// verify the Discard popup visible
		Assert.assertTrue(isElementPresent(an.alertbox), "popup not visible");
		waitThread(1000);
		// Assert the text
		Assert.assertEquals(getText(ms.alert_txt), "Are you certain you want to proceed with your action?\n"
				+ "Any changes that you have made will not be saved.");
		waitThread(1000);
		// Click on Cancel button
		click(an.alertcancel_btn);
		waitThread(1000);
		// verify the discard pop up not visible
		Assert.assertFalse(isElementPresent(an.alertbox), "popup  visible");
		// verify the application is on peer review page[Question 2]
		Assert.assertTrue(isElementPresent(prp.Reviewwizard), "Peer Review Window page not visible");
		waitThread(1000);

		// Click course tab
		click(an.coursetab);
		waitThread(1000);
		// verify the discard popup visible
		Assert.assertTrue(isElementPresent(an.alertbox), "popup not visible");
		waitThread(1000);
		// click on Discard button
		click(an.alertdisc_btn);
		waitThread(1000);
		// verify heading label enrolled courses
		waitFor(prp.enrolledcourse_lbl);
		Assert.assertEquals(getText(prp.enrolledcourse_lbl), "Enrolled Courses");
		waitThread(1000);
		// click on Assessments Tab
		click(sca.Assessmenttab);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		waitThread(5000);

		// Search The Assessment Name
		type(sca.searchbox, NewAssessmentName.trim());
		driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(3000);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(1000);

		// click on Begin Review button
		click(prp.btnbeginReview);
		waitThread(2000);
		// verify the Answer 2 is visible[Question 2]
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));
		// verify the score visible[Already saved][Question 2]
		Assert.assertEquals(getValue(prp.scorestud1), "5");

	}

	/*
	 * To check the discard popup functionality on the peer review page[When
	 * click on Assessments ab]
	 */
	@Test(priority = 62)
	public void TCSPR1300242() {

		// Edit the score of the student 1[Question 2]
		waitThread(1000);
		type(prp.scorestud1, "10");
		// click on student 1 comment box[Question 2]
		click(prp.stud1comment);
		// Type new comment[Question 2]
		type(prp.txtbx_comment, "New comment test");
		// click on save button
		click(prp.commentsave_btn);
		waitThread(1000);
		// verify the comment box popup noyt visible
		Assert.assertFalse(isElementPresent(prp.popupcomment), "Comment popup  visible");
		// verify the newly added comment visible on the student 1 comment box
		Assert.assertEquals(getValue(prp.stud1comment), "New comment test");
		waitThread(1000);

		// click on Assessments Tab
		click(sca.Assessmenttab);
		waitThread(1000);
		// verify the discard popup visible
		Assert.assertTrue(isElementPresent(an.alertbox), "popup not visible");
		// Assert the text
		Assert.assertEquals(getText(ms.alert_txt), "Are you certain you want to proceed with your action?\n"
				+ "Any changes that you have made will not be saved.");
		// Click on Cancel button
		click(an.alertcancel_btn);
		waitThread(1000);
		// verify the discard popup not visible
		Assert.assertFalse(isElementPresent(an.alertbox), "popup not visible");
		// verify the application is on peer review window
		Assert.assertTrue(isElementPresent(prp.Reviewwizard), "Peer Review Window page not visible");
		waitThread(1000);

		// click on Assessments Tab
		click(sca.Assessmenttab);
		waitThread(1000);
		Assert.assertTrue(isElementPresent(an.alertbox), "popup not visible");
		// click on Discard popup
		click(an.alertdisc_btn);
		waitThread(2000);
		// verify assessment search box is viisble
		Assert.assertTrue(isElementPresent(sca.searchbox), "Assessment search box is not visible");
		waitThread(5000);

		// Search The Assessment Name
		driver.findElement(By.xpath(sca.searchbox)).sendKeys(NewAssessmentName);
		driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(3000);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");

		// click on begin review button
		click(prp.btnbeginReview);
		waitThread(3000);
		// verify the question 2 wizard is selected[Question 2]
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));
		// verify score and comment visible on the page[Already saved]
		// [Question 2]
		Assert.assertEquals(getValue(prp.scorestud1), "5");
		Assert.assertEquals(getValue(prp.stud1comment), commentstudent1);
	}

	/*
	 * To submit the Review of student 3
	 */
	@Test(priority = 63)
	public void TCSPR1300243() {
		waitThread(1000);
		// click submit button
		click(ms.submit_btn);
		waitThread(1000);
		Assert.assertTrue(isDisplayed(prp.confir_popup), "popup not visible");
		waitThread(1000);
		// Assert the text "You have 3 skipped question(s)! Proceed to submit?"
		Assert.assertEquals(getText(prp.confirmation_txt), "You have 1 skipped evaluation(s)! Proceed to submit?");

		click(prp.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Assessment Submitted"
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);
		// Click on Back to Assessment
		click(prp.reviewbactoassessmentbtn);

		waitThread(4000);
		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		waitThread(2000);
		// Search The Assessment Name
		type(sca.searchbox, NewAssessmentName.trim());
		driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(3000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(1000);
		Assert.assertEquals(getText(prp.cardlblsubmited), "Submitted");
		Assert.assertEquals(getAttribute(prp.btnbeginReview, "label"), "Modify Review");
		// To verify the percentage on the progress bar
		Assert.assertEquals(getAttribute(prp.progressbarcard, "aria-valuenow"), "67");

	}

	/*
	 * Perform Login functionality on the student 1 login and search the
	 * Assessment 2,check the Answer of student 2
	 */
	@Test(priority = 64)
	public void TCSPR1300244() {

		// Logout student 2
		prp.Logout();
		waitThread(2000);
		// Login as student 1
		lg.login("student1@gmail.com", password);

		// click on Assessments Tab
		click(sca.Assessmenttab);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		waitThread(5000);
		// Search The Assessment Name
		type(sca.searchbox, NewAssessmentName.trim());
		driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(4000);
		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(3000);
		// To verify the percentage on the progress bar
		Assert.assertEquals(getAttribute(prp.progressbarcard, "aria-valuenow"), "0");

		// click on Begin review button
		click(prp.btnbeginReview);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(prp.Reviewwizard), "Peer Review Window page not visible");
		// verify the Assessment name
		Assert.assertEquals(getText(asp.testassessmentname), NewAssessmentName.trim());
		waitThread(2000);
		// verify the Student 1 Answer is disabled
		Assert.assertTrue(getAttribute(prp.stud1accordian_1, "class").contains("disable"),"Student 1 Answer is Enabled");
		waitThread(2000);
		Assert.assertTrue(getAttribute(prp.stud1accordian_1, "class").contains("disable-accordion-fields"),"Student 1 accordian is Enabled");
		Assert.assertFalse(getAttribute(prp.stud2accordian, "class").contains("disable-accordion-fields"),"Student 2 accordian is Disabled");


		// click on student 2 accoridian[Question 1]
		click(prp.stud2accordian_2);
		waitThread(2000);
		// verify the student 2 accoridian is Expanded
		Assert.assertTrue(getAttribute(prp.student2expandedaccordian,"class").contains("p-accordion-tab-active"),"Accordian Tab is Not Expanded");
		waitThread(2000);

		// verify the student 2 Answer visible[Question 1]
		driver.switchTo().frame("answerViewEditor_1_ifr");
		Assert.assertEquals(getText(prp.stud2Answerbox), Stud2_Answer1.trim());
		driver.switchTo().defaultContent();
		// click on student 2 comment box[Question 1]
		click(prp.stud2comment);
		waitThread(2000);
		Assert.assertTrue(isElementPresent(prp.popupcomment), "Comment popup not  visible");
		waitThread(2000);
		// Type comment for student 2[Question 1]
		type(prp.txtbx_comment, commentstudent2);
		waitThread(2000);
		// click on save button
		click(prp.commentsave_btn);
		waitThread(2000);
		// verify the comment box popup not visible
		Assert.assertFalse(isElementPresent(prp.popupcomment), "Comment popup  visible");
		// verify the added comment visible on student 2 box[Question 1]
		Assert.assertEquals(getValue(prp.stud2comment), commentstudent2);
		waitThread(2000);

		// Type score for student 2[Question 1]
		type(prp.scorestud2, "10");
		// click on save button
		click(prp.reviewbtnsave);
		waitFor(QP.toaster);
		// verify the toaster "Saved"
		Assert.assertEquals(getText(QP.toaster), "Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);
		// verify the wizard status is reviewedd[Question 1]
		Assert.assertTrue(getAttribute(asp.wizardans1, "class").contains("complete"));
	}

	/*
	 * To Review the Second Question of Student 2
	 */
	@Test(priority = 65)
	public void TCSPR1300245_Review2ndQuestion() {

		// click on 2nd Question
		click(asp.wizardans2);
		waitThread(2000);
		// verify the student 1 and student 2 accordian status[Question 2]
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));
		Assert.assertTrue(getAttribute(prp.stud1accordian_1, "class").contains("disable"));
		// click on student 2 accordian[Question 2]
		click(prp.stud2accordian_2);
		waitThread(2000);
		// verify the student 2 accordian is expanded
		Assert.assertTrue(getAttribute(prp.student2expandedaccordian,"class").contains("p-accordion-tab-active"));
		waitThread(2000);

		// verify the student 2 Answer [Question 2]
		driver.switchTo().frame("answerViewEditor_1_ifr");
		Assert.assertEquals(getText(prp.stud2Answerbox), Stud2_Answer2.trim());
		driver.switchTo().defaultContent();
		// click on student 2 comment box[Question 2]
		click(prp.stud2comment);
		Assert.assertTrue(isElementPresent(prp.popupcomment), "Comment popup not  visible");
		waitThread(2000);
		// Type comment for student 2 [Question 2]
		type(prp.txtbx_comment, NewAssessmentName + commentstudent2);
		waitThread(2000);
		// click on comment save button
		click(prp.commentsave_btn);
		waitThread(2000);
		// verify the addec comment viisble on student 2 box[Question 2]
		Assert.assertEquals(getValue(prp.stud2comment), NewAssessmentName + commentstudent2);
		waitThread(2000);

		// Type score for student 2
		type(prp.scorestud2, "15");
		// click on save button
		click(prp.reviewbtnsave);
		waitFor(QP.toaster);
		// verify the toaster "Saved"
		Assert.assertEquals(getText(QP.toaster), "Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);
		// verify the student 2 wizard status is reviewed[Question 2]
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("complete"));
		// verify the save button isa disabled
		Assert.assertFalse(isEnabled(prp.reviewbtnsave), "Save Button is Enabled");

	}

	/*
	 * To perform review of 3rd question of student 2
	 */
	@Test(priority = 66)
	public void TCSPR1300245_Review3rdQuestion() {

		// click on Question 3 wizard
		click(asp.wizardans3);
		waitThread(2000);
		Assert.assertTrue(getAttribute(asp.wizardans3, "class").contains("p-highlight"));
		// verify the Accordian status of student 1 and student 2
		Assert.assertTrue(getAttribute(prp.stud1accordian_1, "class").contains("disable"));

		// click on student 2 accordian[Question 3]
		click(prp.stud2accordian_2);
		waitThread(2000);

		// verify the 3rd question answer on the student 2 [Question 3]
		driver.switchTo().frame("answerViewEditor_1_ifr");
		Assert.assertEquals(getText(prp.stud2Answerbox), Stud2_Answer3.trim());
		driver.switchTo().defaultContent();
		// click on student 2 comment box[Question 3]
		click(prp.stud2comment);
		Assert.assertTrue(isElementPresent(prp.popupcomment), "Comment popup not  visible");
		// type comment[Question 3]
		type(prp.popupcomment, NewAssessmentName + commentstudent2);
		waitThread(2000);
		// click on save button
		click(prp.commentsave_btn);
		waitThread(2000);
		Assert.assertFalse(isElementPresent(prp.popupcomment), "Comment popup  visible");
		// verify that the added comment viisble on student 2[Question 3]
		Assert.assertEquals(getValue(prp.stud2comment), NewAssessmentName + commentstudent2);
		waitThread(2000);

		// Type score for student 2
		type(prp.scorestud2, "20");
		// click on save button
		click(prp.reviewbtnsave);
		waitFor(QP.toaster);
		// verify toaster "Saved"
		Assert.assertEquals(getText(QP.toaster), "Saved");
		click(QP.toasterclosebtn);
		waitThread(2000);
		// verify the question 2 wizard status is reviewed[Question 3]
		Assert.assertTrue(getAttribute(asp.wizardans1, "class").contains("complete"));
		// verify the save button is disabled
		Assert.assertFalse(isEnabled(prp.reviewbtnsave), "Save Button is Enabled");

	}

	/*
	 * To submit review for Assessment 2 of student 2
	 */
	@Test(priority = 67)
	public void TCSPR1300246() {

		waitThread(1000);
		// click submit button
		click(ms.submit_btn);
		waitThread(1000);
		Assert.assertTrue(isDisplayed(prp.confir_popup), "popup not visible");
		waitThread(1000);

		click(prp.submit_confi);
		waitFor(QP.toaster);

		// Assert the toaster "Assessment Submitted"
		Assert.assertEquals(getText(QP.toaster), "Peer Review Submitted");

		click(QP.toasterclosebtn);
		// Click on Back to Assessment
		click(prp.reviewbactoassessmentbtn);

		waitThread(5000);
		// *Assert the Current Assessment tab is selected
		Assert.assertTrue(getAttribute(ms.currentass_tab, "class").contains("p-highlight"));
		waitThread(1000);
		// Search The Assessment Name
		driver.findElement(By.xpath(sca.searchbox)).sendKeys(NewAssessmentName);
		driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(3000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(1000);
		Assert.assertEquals(getText(prp.cardlblsubmited), "Submitted");
		Assert.assertEquals(getAttribute(prp.btnbeginReview, "label"), "Modify Review");
		// To verify the percentage on the progress bar
		Assert.assertEquals(getAttribute(prp.progressbarcard, "aria-valuenow"), "100");

	}

	/*
	 * Login As Student 2 and then , search the Assessment name and check the
	 * details on the page [Question 1]
	 */
	@Test(priority = 68)
	public void TCSPR1300247() {

		// perform logout of student 1
		prp.Logout();
		waitThread(2000);
		// Login as student 2
		lg.login("student2@gmail.com", password);

		// click on Assessments Tab
		click(sca.Assessmenttab);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		waitThread(5000);
		// Search The Assessment Name
		type(sca.searchbox, AssessmentName.trim());
		driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(3000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(3000);
		// click on Begin review button
		click(prp.btnbeginReview);
		waitThread(3000);
		// verify the Labels on the peer review page
		Assert.assertEquals(getText(prp.lblQuestionno), "Question No: 1");
		Assert.assertEquals(getText(prp.lbl_maxscore), "Max Score: 10");
		Assert.assertEquals(getText(prp.lbl_totalscore), "Total Score 90");
		// Verify the Total score of the Assessment 1
	//	Assert.assertEquals(getText(prp.lbltotalscorevalue), maxscore1);

		// verify the Question 1 content
		driver.switchTo().frame("questionViewEditor_ifr");
		Assert.assertEquals(getText(prp.Questionview), Question1.trim());
		driver.switchTo().defaultContent();

		// verify the Rubric lable
	//	Assert.assertEquals(getText(prp.RubricAccordian), "Rubric");
		// verify the added rubric content
		driver.switchTo().frame("standardRubricViewEditor_ifr");
		Assert.assertEquals(getText(prp.Rubric_view), Rubric1.trim());
		driver.switchTo().defaultContent();

		// click on student 1 Answer and check the added Answer,Image,Video,URL
		// visible on the Answer box
		click(prp.stud1accordian);
		Assert.assertEquals(getAttribute(prp.stud1accordian, "aria-expanded"), "true");
		waitThread(2000);
		driver.switchTo().frame("answerViewEditor_0_ifr");
		Assert.assertEquals(getText(prp.stud1Answerbox), Stud1_Answer1.trim());
		driver.switchTo().defaultContent();
		waitThread(1000);
		// verify the sample answer not visible on the Question 1 page
		Assert.assertFalse(isElementPresent(prp.SampleAnsAccordian), "Sample Answer visible on the page");

	}

	/*
	 * To check the details on the Question 2
	 */
	@Test(priority = 69)
	public void TCSPR1300248() {

		// click on Question 2
		click(asp.wizardans2);
		waitThread(2000);
		Assert.assertTrue(getAttribute(asp.wizardans2, "class").contains("p-highlight"));

		// To check the details on the Peer review page
		Assert.assertEquals(getText(prp.lblQuestionno), "Question No: 2");
		Assert.assertEquals(getText(prp.lbl_maxscore), "Max Score: 20");
		Assert.assertTrue(getText(prp.lbl_totalquestions).contains("Total Questions"),"Label Not correct");
		Assert.assertEquals(getText(prp.lbl_totalscore), "Total Score 90");
		//Assert.assertEquals(getText(prp.lbltotalscorevalue), maxscore1);

		// verify the Student Answer 2 content on the page[Question 2]
		click(prp.stud1accordian);
		waitThread(2000);
		driver.switchTo().frame("answerViewEditor_0_ifr");
		Assert.assertEquals(getText(prp.stud1Answerbox), Stud1_Answer2.trim());

		driver.switchTo().defaultContent();
	}

	/*
	 * To check the details on the Question 3
	 */
	@Test(priority = 70)
	public void TCSPR1300249() {

		// click on Question 3
		click(asp.wizardans3);
		waitThread(2000);
		Assert.assertTrue(getAttribute(asp.wizardans3, "class").contains("p-highlight"));
		// check the assessment details on the question 3 page
		Assert.assertEquals(getText(prp.lblQuestionno), "Question No: 3");
		Assert.assertEquals(getText(prp.lbl_maxscore), "Max Score: 30");
		Assert.assertEquals(getText(prp.lbl_totalscore), "Total Score 90");
		//Assert.assertEquals(getText(prp.lbltotalscorevalue), maxscore1);

		// verify the Question 3 content
		driver.switchTo().frame("questionViewEditor_ifr");
		Assert.assertEquals(getText(prp.Questionview), Question3.trim());
		driver.switchTo().defaultContent();

		// verify the Rubric content
		//Assert.assertEquals(getText(prp.RubricAccordian), "Rubric");
		driver.switchTo().frame("standardRubricViewEditor_ifr");
		Assert.assertEquals(getText(prp.Rubric_view), Rubric3.trim());
		driver.switchTo().defaultContent();

		// verify the Answer 3 of student [Question 3]
		click(prp.stud1accordian);
		driver.switchTo().frame("answerViewEditor_0_ifr");
		Assert.assertEquals(getText(prp.stud1Answerbox), Stud1_Answer3.trim());
		driver.switchTo().defaultContent();

	}

	/*
	 * To check the details on the Question 4
	 */
	@Test(priority = 71)
	public void TCSPR1300250() {

		// click on Question 2
		click(asp.wizardans4);
		waitThread(2000);
		Assert.assertTrue(getAttribute(asp.wizardans4, "class").contains("p-highlight"));
		// verify the Assessment details on the Question 4
		Assert.assertEquals(getText(prp.lblQuestionno), "Question No: 4");
		Assert.assertEquals(getText(prp.lbl_maxscore), "Max Score: 30");
		Assert.assertEquals(getText(prp.lbl_totalscore), "Total Score 90");
	//	Assert.assertEquals(getText(prp.lbltotalscorevalue), maxscore1);

		// verify the Question 4 content
		driver.switchTo().frame("questionViewEditor_ifr");
		Assert.assertEquals(getText(prp.Questionview), Question4.trim());
		driver.switchTo().defaultContent();

		// verify the Rubric Accordian is not visible
		Assert.assertFalse(isElementPresent(prp.RubricAccordian), "Rubric Accordian not visible visible on the page");

		// verify the Answer of student [Question 4]
		click(prp.stud1accordian);
		driver.switchTo().frame("answerViewEditor_0_ifr");
		Assert.assertEquals(getText(prp.stud1Answerbox), Stud1_Answer4.trim());

		driver.switchTo().defaultContent();

	}

	/*
	 * To check the details of the clicakble rubric
	 */
	@Test(priority = 72)
	public void TCSPR1300250_ClickableRubricLabels() {

		ScrollTo_Location(ms.submit_btn);
		// verify the clickable rubric section visible
		Assert.assertTrue(isElementPresent(prp.rubriccardsection), "Clickable rubric not visible");
		// verify the Label
		Assert.assertEquals(getText(prp.cardrubriclbl), "Student One Rubric");

		// verify the Criteria 1 and Criteria 2
		Assert.assertEquals(getText(prp.criteria_1), Criteria1);
		Assert.assertEquals(getText(prp.criteria_2), Criteria2);
		waitThread(1000);
		// verify the clickable rubric rows visible[That added on the assessment
		// creation step]
		Assert.assertTrue(isElementPresent(prp.c1row1), "Row 1 for criteria 1 is not visible ");
		Assert.assertTrue(isElementPresent(prp.c1row2), "Row 2 for criteria 1 is not visible ");
		Assert.assertTrue(isElementPresent(prp.c2row1), "Row 1 for criteria 2 is not visible ");
		Assert.assertTrue(isElementPresent(prp.c2row2), "Row 2 for criteria 2 is not visible ");
		waitThread(1000);
		// verify the Score for each rows
		// score of Criteria 1 and row 1
		Assert.assertEquals(getText(prp.c1row1score), "Score 20");
		// score of Criteria 1 and row 2
		Assert.assertEquals(getText(prp.c1row2score), "Score 15");
		// score of Criteria 2 and row 1
		Assert.assertEquals(getText(prp.c2row1score), "Score 10");
		// score of Criteria 2 and row 2
		Assert.assertEquals(getText(prp.c2row2score), "Score 5");

		// verify the condition of Criteria 1 and row 1
		driver.switchTo().frame("answerView_000_ifr");
		Assert.assertEquals(getText(prp.c1row1condition), "Very Good");
		driver.switchTo().defaultContent();

		// verify the condition of Criteria 1 and row 2
		driver.switchTo().frame("answerView_001_ifr");
		Assert.assertEquals(getText(prp.c1row2condition), "Good");
		driver.switchTo().defaultContent();

		// verify the condition of Criteria 2 and row 1
		driver.switchTo().frame("answerView_010_ifr");
		Assert.assertEquals(getText(prp.c2row1condition), "Average");
		driver.switchTo().defaultContent();

		// verify the condition of Criteria 2 and row 2
		driver.switchTo().frame("answerView_011_ifr");
		Assert.assertEquals(getText(prp.c2row2condition), "Below Average");
		driver.switchTo().defaultContent();

		ScrollTo_Location(prp.SampleAnsAccordian);
		// verify the sample Answer of Question 4
		driver.switchTo().frame("sampleAnswerViewEditor_ifr");
		Assert.assertEquals(getText(prp.SampleAns_view), SampleAnswer4);
		driver.switchTo().defaultContent();

	}

	// To add score for question 4 using clickable rubric

	@Test(priority = 73)
	public void TCSPR1300251() {

		// verify the Score box  is disabled
		Assert.assertTrue(getAttribute(prp.scorestud_1, "class").contains("disabled-score-field hide-input-arrow"));
		waitThread(1000);
		// click on row 1 of Criteria 1
		click(prp.c1row1);
		// verify the row 1 of Criteria 1 is selected
		Assert.assertTrue(getAttribute(prp.c1row1, "class").contains("selectedCell"));
		waitThread(1000);
		// click on row 2 of Criteria 1
		click(prp.c1row2);
		// verify the row 2 of Criteria 1 is selected
		Assert.assertTrue(getAttribute(prp.c1row2, "class").contains("selectedCell"));
		// verify the row 1 of Criteria 1 is unselected
		Assert.assertFalse(getAttribute(prp.c1row1, "class").contains("selectedCell"));
		waitThread(1000);

		ScrollTo_Location(prp.scorestud1);
		// verify that no score visible on the score box
		Assert.assertEquals(getValue(prp.scorestud1), "");
		// verify the save button is disabled
		Assert.assertFalse(isEnabled(prp.reviewbtnsave), "Save Button is Disabled");
		ScrollTo_Location(prp.cardrubriclbl);
		waitThread(1000);
		// click on row 1 of Criteria 2
		click(prp.c2row1);
		// verify the row 1 of Criteria 2 is selected
		Assert.assertTrue(getAttribute(prp.c2row1, "class").contains("selectedCell"));
		// click on row 2 of Criteria 2
		click(prp.c2row2);
		// verify the row 2 of Criteria 2 is selected
		Assert.assertTrue(getAttribute(prp.c2row2, "class").contains("selectedCell"));
		// verify the row 1 of Criteria 2 is unselected
		Assert.assertFalse(getAttribute(prp.c2row1, "class").contains("selectedCell"));

		ScrollTo_Location(prp.scorestud1);
		waitThread(1000);
		// verify the score on the box for Question 4
		Assert.assertEquals(getValue(prp.scorestud1), "20");

		ScrollTo_Location(prp.cardrubriclbl);
		waitThread(1000);
		// click on row 1 of Criteria 1
		click(prp.c1row1);
		Assert.assertTrue(getAttribute(prp.c1row1, "class").contains("selectedCell"));
		// click on row 1 of Criteria 2
		click(prp.c2row1);
		Assert.assertTrue(getAttribute(prp.c2row1, "class").contains("selectedCell"));

		// verify the score is updated to 30
		ScrollTo_Location(prp.scorestud1);
		waitThread(1000);
		Assert.assertEquals(getValue(prp.scorestud1), "30");

		// click on previous arrow button
		click(prp.previousarrowbtn);
		waitThread(2000);
		// verify the Question 3 is selected
		Assert.assertTrue(getAttribute(asp.wizardans3, "class").contains("p-highlight"));
		waitFor(QP.toaster);
		// verify the toaster "Score Saved"
		Assert.assertEquals(getText(QP.toaster), "Score Saved");
		click(QP.toasterclosebtn);

		// click on next arrow
		click(prp.nextarrowbtn);
		waitThread(2000);
		// verify the Question 4 is selected
		Assert.assertTrue(getAttribute(asp.wizardans4, "class").contains("p-highlight"));
		// verify the score is 30
		Assert.assertEquals(getValue(prp.scorestud1), "30");

		// click on studnet 1 accordian
		click(prp.stud1accordian);

		Scroll_DowntoEnd();
		click(prp.c1row1);
		// verify the row 1 of Criteria 1 is selected
		Assert.assertTrue(getAttribute(prp.c1row1, "class").contains("selectedCell"));
		click(prp.c2row1);
		// verify the row 1 of Criteria 2 is selected
		Assert.assertTrue(getAttribute(prp.c2row1, "class").contains("selectedCell"));
		// verify the Question 4 wizard status is reviewed
		Assert.assertTrue(getAttribute(asp.wizardans4, "class").contains("complete"));
		// verify the save and next button is disabled
		Assert.assertTrue(getAttribute(prp.reviewbtnsaveandnext, "class").contains("disabled"));

		// click on save and exit button
		click(prp.reviewbtnsaveandexit);
		waitThread(7000);
		// To check the current assessment tab is selected
		Assert.assertEquals(getAttribute(sca.selectedcurrenttab, "aria-selected"), "true");

	}

	/*
	 * Perform Login functionality of student 1 and check the peer review
	 * window[Student not attended exam]
	 */
	@Test(priority = 74)
	public void TCSPR1300252() {

		// Logout the student 2
		prp.Logout();
		waitThread(2000);
		// Login as student 1
		lg.login("student1@gmail.com", password);

		// click on Assessments Tab
		click(sca.Assessmenttab);
		Assert.assertTrue(isElementPresent(sca.selectedassessmenttab), "Assessment tab is not selected");
		waitThread(5000);
		// Search The Assessment Name
		type(sca.searchbox, AssessmentName);
		driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(3000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		// verify the progress bar showing 0 % for Assessment 1
		Assert.assertEquals(getAttribute(prp.progressbarcard, "aria-valuenow"), "0");

		// click on begin review
		click(prp.btnbeginReview);
		waitThread(3000);
		// verify the test unattended popup viisble
		Assert.assertTrue(isDisplayed(prp.tstUnattendedPopup), "Test Unattended popup not visible");

		// verify the Labels
		Assert.assertEquals(getText(prp.testunattendedlbl_1),
				"Sorry! You have no answer sheet for peer review since the student assigned to you has not attended the assessment.");
		Assert.assertEquals(getText(prp.testunattendedlbl_2), "You will be awarded the peer review score");
		Assert.assertEquals(getText(prp.unattendedpopup_submitbtn), "Submit");

		// click on Submit button on the unattended popup
		click(prp.unattendedpopup_submitbtn);
		waitThread(7000);
		Assert.assertFalse(isElementPresent(prp.tstUnattendedPopup), "Test Unattended popup  visible");
		// To check the current assessment tab is selected
		Assert.assertEquals(getAttribute(sca.selectedcurrenttab, "aria-selected"), "true");
	}

	@Test(priority = 75)
	public void TCSPR1300253() {

		// Search The Assessment Name
		type(sca.searchbox, AssessmentName);
		driver.findElement(By.xpath(sca.searchbox)).sendKeys(" ");
		waitThread(4000);

		// Assert the published Assessment card visible
		Assert.assertTrue(isDisplayed(natb.Assessmentcard1), "Assessment card not visible");
		waitThread(3000);
		// verify the progress bar showing 100 %
		Assert.assertEquals(getAttribute(prp.progressbarcard, "aria-valuenow"), "100");
		// verify the card Labels
		Assert.assertEquals(getText(prp.cardlblsubmited), "Submitted");
		Assert.assertEquals(getAttribute(prp.btnbeginReview, "label"), "Modify Review");

	}

	/*
	 * Perform Logout for student 1
	 */
	@Test(priority = 76)
	public void TCSPR1300254() {

		prp.Logout();

	}

}
