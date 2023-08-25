package Course.Test;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generalmethods.Databaseconnection;

import Course.Pages.CreateNewCoursePage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;

public class CreateNewCourseTest extends basePage {

	LoginPage lg = new LoginPage();
	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	Databaseconnection dc = new Databaseconnection();
	public String CourseTitle;
	public String NewCourseTitle;
	public String CourseID;
	public String Email;
	public String otp;
	public String EmailTeacher;

	/*
	 * To perform Sign Up functionality
	 */
	@Test(priority = 0)
	public void TCSPR090101() throws SQLException {

		// To click on I am A teacher button
		click(sp.btn_1);

		// To fill the details on the sign up page
		EmailTeacher = st.TCSPR020005();
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
	 * To check the buttons and heading labels
	 */
	@Test(priority = 2)
	public void TCSPR060102() {

		// To verify label-Create new course
		Assert.assertEquals(getText(cn.btnlbl_createnew), "Create New Course");

		// To verify the create new course button
		Assert.assertTrue(isElementPresent(cn.btn_createnew), "Create new course button not present");

		// To verify label-Course status
		Assert.assertEquals(getText(cn.lbl_coursestatus), "Course Status");

	}

	/*
	 * To check the labels on the course landing page.
	 */
	@Test(priority = 3)
	public void TCSPR060103() {

		// grid label
		Assert.assertEquals(getText(cn.lbl_grid), "You don't have any active course(s).\n"
				+ "Please click on the “+ Create New Course” button on the top right of this page to create a course");

		// To verify grid labels
		Assert.assertEquals(getText(cn.lbl_courseid), "Course ID");
		Assert.assertEquals(getText(cn.lbl_coursestatus), "Course Status");
		Assert.assertEquals(getText(cn.lbl_coursetitle), "Course Title");
		Assert.assertEquals(getText(cn.lbl_district), "District");
		Assert.assertEquals(getText(cn.lbl_department), "Department");
		Assert.assertEquals(getText(cn.lbl_Enrolled), "Enrolled");
		Assert.assertEquals(getText(cn.lbl_Studentrequests), "Student Requests");
		Assert.assertEquals(getText(cn.lbl_Actions), "Actions");
		Assert.assertTrue(isElementPresent(cn.eyeicon), "Eye icon not present");

	}

	/*
	 * To check the No course popup while click on Assessment tab
	 */
	@Test(priority = 3)
	public void TCSPR060103_Nocoursepopup() {

		// click on Assessment tab
		click(cn.btnheader_assessment);

		// check the popup and ok button visible
		Assert.assertTrue(isElementPresent(cn.nocoursepopup), "No Course pop up not visible");
		Assert.assertTrue(isElementPresent(cn.btn_ok), "Ok button not visible");
		waitThread(2000);
		// verify text
		Assert.assertEquals(getText(cn.nocoursepopuptxt),
				"Assessments can only be accessed when you have at least 1 active course");

		// click on ok button and check the popup not visible
		click(cn.btn_ok);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(cn.nocoursepopup), "No Course pop up  visible");
		// verify the course tab is selected
		Assert.assertTrue(getAttribute(cn.btnheader_course, "class").contains("active"));
		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");
	}

	/*
	 * To check thethe labels,text boxes in the course landing page
	 */
	@Test(priority = 4)
	public void TCSPR060104() {

		// Click on create new course button
		click(cn.btn_createnew);
		waitThread(5000);

		// To verify heading labels
		Assert.assertEquals(getText(cn.Headinglbl_1), "Create New Course");
		Assert.assertEquals(getText(cn.txbxlbl_coursetitle), "Course Title*");
		Assert.assertEquals(getText(cn.txtbxlbl_CourseCode), "Course Code");
		Assert.assertEquals(getText(cn.txtbxlbl_department), "Department");
		Assert.assertEquals(getText(cn.txtbxlbl_district), "District or Institution");
		Assert.assertEquals(getText(cn.tctbxlbl_Coursesec), "Course Section");
		Assert.assertEquals(getText(cn.tctbxlbl_Special), "Additional Notes");

		// Textboxes
		Assert.assertTrue(isElementPresent(cn.txbx_Coursetitle), "Course Title Textbox not present");
		Assert.assertTrue(isElementPresent(cn.txtbx_Coursecode), "Course code Textbox not present");
		Assert.assertTrue(isElementPresent(cn.txtbx_Coursesec), "Course section Textbox not present");
		Assert.assertTrue(isElementPresent(cn.txtbx_dep), "Department Textbox not present");
		Assert.assertTrue(isElementPresent(cn.txtbx_district), "District Textbox not present");
		Assert.assertTrue(isElementPresent(cn.txtbx_special), "Special note Textbox not present");

		// To verify the course ID present
		Assert.assertTrue(isElementPresent(cn.course_Id), "Course code  not present");

	}

	/*
	 * To check the Course Code copy functionality on the create new course, To
	 * check the no course popup while click on Assessment tab
	 */
	@Test(priority = 5)
	public void TCSPR060105() {

		// To verify the course id copy option present
		Assert.assertTrue(isElementPresent(cn.coursecopy), "Course copy button  not present");

		// click on copy option
		click(cn.coursecopy);

		waitFor(cn.toaster);
		// verify toaster text-Course ID is copied to clip board
		Assert.assertEquals(getText(cn.toaster), "Course ID is copied to clipboard");
		waitThread(1000);

		// To verify the no course popup

		// click on Assessment tab
		click(cn.btnheader_assessment);

		// check the popup and ok button visible
		Assert.assertTrue(isElementPresent(cn.nocoursepopup), "No Course pop up not visible");
		Assert.assertTrue(isElementPresent(cn.btn_ok), "Ok button not visible");
		waitThread(2000);
		// verify text
		Assert.assertEquals(getText(cn.nocoursepopuptxt),
				"Assessments can only be accessed when you have at least 1 active course");

		// click on ok button and check the popup not visible
		click(cn.btn_ok);
		waitThread(1000);
		Assert.assertFalse(isElementPresent(cn.nocoursepopup), "No Course pop up  visible");
		// verify the course tab is selected
		Assert.assertTrue(getAttribute(cn.btnheader_course, "class").contains("active"));
		// verify heading Create New Course
		Assert.assertEquals(getText(cn.Headinglbl_1), "Create New Course");

	}

	/*
	 * To check the buttons in the Create New Course page
	 */
	@Test(priority = 6)
	public void TCSPR060106() {

		waitThread(5000);
		// verify the create course button
		Assert.assertTrue(isElementPresent(cn.btn_Createcourse), "Create Course  button  not present");

		// btton label-create course
		Assert.assertEquals(getText(cn.btnlbl_Createcourse), "Create Course");
		waitThread(4000);
		// verify the create course button is disabled
		Assert.assertFalse(isEnabled(cn.btn_createcourse2), "Create course button is enabled");

		// type course title
		type(cn.txbx_Coursetitle, "ss");

		// Click on cancel button
		click(cn.btn_cancel);

		waitThread(5000);
		Assert.assertTrue(isElementPresent(cn.popupbx), "Discard popup not visible");

		// to verify label-
		Assert.assertEquals(getText(cn.discardchanges), "Discard Changes");

		// to verify popup text
		Assert.assertEquals(getText(cn.popuptxt), "Are you certain you want to proceed with your action?\n"
				+ "Any changes that you have made will not be saved.");

		// to verify the discard button visible
		Assert.assertTrue(isElementPresent(cn.popupbtnDiscard), "Discard button not visible");

		// to verify cancel button visible
		Assert.assertTrue(isElementPresent(cn.popupbtnCancel), "Cancel Button not visible");

		// click on cancel button
		click(cn.popupbtnCancel);

		waitThread(3000);
		// verify popup box not visible
		Assert.assertFalse(isElementPresent(cn.popupbx), "Discard popup  visible");

		waitThread(3000);
		// click on cancel
		click(cn.btn_cancel);

		// click on popup discard button
		click(cn.popupbtnDiscard);
		waitThread(3000);

		// verify heading courses-landing page
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	/*
	 * To check the create new course functionality on the landing page To fill
	 * all the fields on the create new course
	 */
	@Test(priority = 7)
	public void TCSPR060107() {

		CourseTitle = "Course Name" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);
		waitThread(3000);

		// to verify add students buuton disabled
		Assert.assertFalse(isEnabled(cn.btn_AddStudents), "Add students button is enabled");

		waitThread(3000);
		// to verify label-Add Students
		Assert.assertEquals(getText(cn.btnlbl_Addstudents), "Add Students");

		// click on course titile textbox
		click(cn.txbx_Coursetitle);

		// click on course code textbox
		click(cn.txtbx_Coursecode);
		waitThread(3000);
		// verify validation message
		Assert.assertEquals(getText(cn.val_3), "Course Title is required");

		// To get the Course ID
		CourseID = (getText(cn.course_Id));

		// type-Course title
		type(cn.txbx_Coursetitle, CourseTitle);

		// Type-Course code
		type(cn.txtbx_Coursecode, "01");

		// Assert the course code
		Assert.assertEquals(getValue(cn.txtbx_Coursecode), "01");

		// Type-Course section
		type(cn.txtbx_Coursesec, "Sec_101");

		// Assert the course section
		Assert.assertEquals(getValue(cn.txtbx_Coursesec), "Sec_101");

		waitThread(1000);
		// Type-Department
		type(cn.txtbx_dep, "Course Department_01");

		// Assert the Department
		Assert.assertEquals(getValue(cn.txtbx_dep), "Course Department_01");

		// Type-District
		type(cn.txtbx_district, "Course Name_District");

		// Assert the District
		Assert.assertEquals(getValue(cn.txtbx_district), "Course Name_District");

		// Type-Department
		type(cn.txtbx_special, "Course for High School students");

		// Assert the Department
		Assert.assertEquals(getValue(cn.txtbx_special), "Course for High School students");

	}

	/*
	 * To check the added course functionality and Assert the details visible on
	 * the grid
	 */
	@Test(priority = 8)
	public void TCSPR060108() {

		// click on create course button
		click(cn.btn_Createcourse);

		waitThread(1000);
		// verify toaster-Course created successfully
		Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");

		waitThread(3000);

		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), CourseTitle.trim());
		waitThread(3000);

		// verify District
		Assert.assertEquals(cn.gridvalue(1), "Course Name_District");

		// verify department
		Assert.assertEquals(cn.gridvalue(2), "Course Department_01");

		// verify enrolled count
		Assert.assertEquals(cn.gridvalue(3), "0");

	}

	/*
	 * To check the Course Code and Course Code copy functionality on the grid
	 */
	@Test(enabled = false)
	public void TCSPR060109() {

		// verify course ID
		Assert.assertEquals(cn.gridvalue(0).trim(), CourseID.trim());

		// click on course id copy option
		click(cn.coursecopy1);
		waitThread(1000);

		// verify toaster
		Assert.assertEquals(getText(cn.toaster), "Course ID is copied to clipboard");
		waitThread(2000);

	}

	/*
	 * To check the sub tab functionality on the Course landing page
	 */
	@Test(priority = 10)
	public void TCSPR060110() {

		// waitThread(3000);
		waitFor(cn.btn_submenu);

		// click on submenu button
		click(cn.btn_submenu);

		waitThread(3000);
		// to verify gridlabels
		Assert.assertEquals(getText(cn.gridlabel1).trim(), "Course Code");
		Assert.assertEquals(getText(cn.gridlabel2).trim(), "Course Section");
		Assert.assertEquals(getText(cn.gridlabel3).trim(), "Invited & Not Accepted");
		Assert.assertEquals(getText(cn.gridlabel4).trim(), "Suspended");
		Assert.assertEquals(getText(cn.gridlabel5).trim(), "Additional Notes");
		Assert.assertEquals(getText(cn.gridlabel6).trim(), "Created");
		Assert.assertEquals(getText(cn.gridlabel7).trim(), "Modified");

		waitThread(3000);
		// verify course code
		Assert.assertEquals(cn.gridvalue(5), "01");
		waitThread(3000);
		// verify course section
		Assert.assertEquals(cn.gridvalue(6), "Sec_101");

		waitThread(3000);
		Assert.assertEquals(getText(cn.val_2), "Course for High School students");

	}

	/*
	 * To check the created and modified date
	 */
	@Test(priority = 11)
	public void TCSPR060111() {

		// Verify the Created date with system date
		Assert.assertEquals(cn.gridvalue(9), cn.getdate());

		// Verify the Modified date with system date
		Assert.assertEquals(cn.gridvalue(10), cn.getdate());

	}

	/*
	 * To check the Details button on the course landing page
	 */
	@Test(priority = 12)
	public void TCSPR060112() {

		// to verify the details button
		Assert.assertTrue(isElementPresent(cn.btn_details), "Details button not visible");

		// click on details button dropdown
		click(cn.btn_details_1);

		waitThread(4000);

		// link texts
		Assert.assertEquals(getText(cn.link_lbl_1), "View/Modify Course Details");
		Assert.assertEquals(getText(cn.link_lbl_2), "View/Modify Student Roster");
		Assert.assertEquals(getText(cn.link_lbl_3), "Manage Assessments");
		Assert.assertEquals(getText(cn.link_lbl_4), "Delete Course");
		Assert.assertEquals(getText(cn.link_lbl_5), "View/Process student request to join");

	}

	/*
	 * To check the search functionality on the course landing page
	 */
	@Test(priority = 13)
	public void TCSPR060113() {

		// waitFor(cn.searchbx);
		click(cn.searchbx_1);

		// type course name
		type(cn.searchbx_1, CourseTitle);
		waitThread(3000);

		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), CourseTitle.trim());

	}

	/*
	 * To check with already created course title. Also check the confirmation
	 * popup when Click on courses link in the header
	 */
	@Test(priority = 15)
	public void TCSPR060114() {

		waitThread(3000);
		// Click on create new course button
		click(cn.btn_createnew);

		// type old course title
		type(cn.txbx_Coursetitle, CourseTitle);
		waitThread(2000);
		// verify validation messages
		// Assert.assertEquals(getText(cn.val_1), "Course '" +
		// CourseTitle.trim() + "' already exist");

		// course link on header
		Assert.assertTrue(isElementPresent(cn.btnheader_course), "header course  button not present");

		// To verify the discard popup

		// click on header course link
		click(cn.btnheader_course);

		waitThread(1000);
		Assert.assertTrue(isElementPresent(cn.popupbx), "Discard popup not visible");

		// To verify label-
		Assert.assertEquals(getText(cn.discardchanges), "Discard Changes");

		// To verify popup text
		Assert.assertEquals(getText(cn.popuptxt), "Are you certain you want to proceed with your action?\n"
				+ "Any changes that you have made will not be saved.");

		// To verify the discard button visible
		Assert.assertTrue(isElementPresent(cn.popupbtnDiscard), "Discard button not visible");

		// To verify cancel button visible
		Assert.assertTrue(isElementPresent(cn.popupbtnCancel), "Cancel Button not visible");

		// click on cancel button
		click(cn.popupbtnCancel);

		waitThread(3000);
		// verify popup box not visible
		Assert.assertFalse(isElementPresent(cn.popupbx), "Discard popup  visible");

		// click on header course link
		click(cn.btnheader_course);

		// click on popup discard button
		click(cn.popupbtnDiscard);
		waitThread(3000);

		// verify heading courses-landing page
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	/*
	 * check the confirmation popup when Click on assessment link in the header
	 */
	@Test(priority = 16)
	public void TCSPR060114_DiscardpopupAssessmenttab() {

		waitThread(3000);
		// Click on create new course button
		click(cn.btn_createnew);

		// type old course title
		type(cn.txbx_Coursetitle, CourseTitle);

		// click on Assessment tab
		click(cn.btnheader_assessment);

		waitThread(1000);
		Assert.assertTrue(isElementPresent(cn.popupbx), "Discard popup not visible");

		// To verify label-
		Assert.assertEquals(getText(cn.discardchanges), "Discard Changes");

		// To verify popup text
		Assert.assertEquals(getText(cn.popuptxt), "Are you certain you want to proceed with your action?\n"
				+ "Any changes that you have made will not be saved.");

		// To verify the discard button visible
		Assert.assertTrue(isElementPresent(cn.popupbtnDiscard), "Discard button not visible");

		// To verify cancel button visible
		Assert.assertTrue(isElementPresent(cn.popupbtnCancel), "Cancel Button not visible");

		// click on cancel button
		click(cn.popupbtnCancel);

		waitThread(3000);
		// verify popup box not visible
		Assert.assertFalse(isElementPresent(cn.popupbx), "Discard popup  visible");
		waitThread(3000);
		
		// click on header course link
		click(cn.btnheader_assessment);
		waitThread(3000);
		
		// click on popup discard button
		click(cn.popupbtnDiscard);
		waitThread(3000);
		
		if(isElementPresent(cn.nocoursepopuptxt)&& isDisplayed(cn.nocoursepopuptxt))
		{
		waitThread(1000);
		click(cn.btn_ok);
		waitThread(1000);
		}

		// verify assessment tab is selected
		Assert.assertTrue(getAttribute(cn.btnheader_assessment, "class").contains("active"));

		// click on course tab
		click(cn.btnheader_course);
		waitThread(3000);
		Assert.assertTrue(getAttribute(cn.btnheader_course, "class").contains("active"));
	}

	/*
	 * To perform delete course functionality on the course landing page
	 */
	@Test(priority = 14)
	public void TCSPR060115() {

		// click on details button dropdown
		click(cn.btn_details_1);

		waitFor(cn.link_deletecourse);
		// Click on delete course link
		click(cn.link_deletecourse);

		// verify the confirmation pop up visible
		Assert.assertTrue(isElementPresent(cn.confm_popup), "Confirmation popup not visible");

		waitThread(2000);
		// Assert following
		Assert.assertEquals(getText(cn.confirmationlbl), "Course: " + CourseTitle.trim());
		waitThread(2000);
		Assert.assertEquals(getText(cn.delete_popuptxt),
				"Are you sure that you want to permanently delete this course?");

		// button Yes
		Assert.assertTrue(isElementPresent(cn.delete_yes), "Yes button not visible in the Confirmation popup");

		// button-No
		Assert.assertTrue(isElementPresent(cn.delete_No), "No button not visible in the Confirmation popup");

		// click on No button
		click(cn.delete_No);

		waitThread(2000);
		// verify the confirmation popup not visible
		Assert.assertFalse(isElementPresent(cn.confm_popup), "confirmation popup  visible");

		waitThread(2000);
		// click on details button dropdown
		click(cn.btn_details_1);

		// Click on delete course link
		click(cn.link_deletecourse);
		waitThread(2000);

		// click on Yes button
		click(cn.delete_yes);
		waitThread(1000);
		// verify toaster message-Course deleted successfully
		Assert.assertEquals(getText(cn.toaster),
				"The course" + " " + "\"" + CourseTitle.trim() + "\"" + " has been successfully deleted.");
		waitThread(2000);
		// verify that the course name not visible on the grid
		Assert.assertFalse(isElementPresent(cn.value_coursetitle), "Course Visible on the grid");

	}

	/*
	 * To check the Add Students to the Course functionality on the course add
	 * page.
	 */
	@Test(priority = 16)
	public void TCSPR060116() {

		waitThread(2000);
		// Click on create new course button
		click(cn.btn_createnew);
		waitThread(2000);

		waitFor(cn.txbx_Coursetitle);
		// type course name
		type(cn.txbx_Coursetitle, CourseTitle);

		// click on Add students button
		click(cn.btn_AddStudents);

		waitThread(2000);
		// verify the add students popup visible
		Assert.assertTrue(isElementPresent(cn.popupAddstudents), "pop up  not visible");

		waitThread(2000);
		// verify the heading
		Assert.assertEquals(getText(cn.headinglabel),
				"Build a list of students to be invited to join the course: " + CourseTitle.trim());
		waitThread(2000);

		Assert.assertEquals(getText(cn.lbl_invite), "Invite new students");
		waitThread(1000);

		Assert.assertEquals(getText(cn.lbl_Add_stud), "Invite students from my existing courses");
		waitThread(1000);

	}

	/*
	 * To check the Invite New Students functionality on the pop up window
	 * Assert the labels,buttons,validation messages on the pop up window
	 */
	@Test(priority = 17)
	public void TCSPR060117() {

		// import button-
		Assert.assertTrue(isElementPresent(cn.btn_import), "Import Button not visible");

		// Import CSV & Text files
		Assert.assertEquals(getText(cn.btnlbl_import), "Import CSV/Text File");

		// cancel button
		Assert.assertTrue(isElementPresent(cn.tab_btn_cancel), "Tab button cancel not visible");

		// Add to list button
		Assert.assertTrue(isElementPresent(cn.tab_btn_Addtolist), "Tab button Add to list not visible");

		// Add to list button label-
		Assert.assertEquals(getText(cn.tablbl_addtolist), "Add to List");
		waitThread(5000);

		// click on add to list button
		click(cn.tab_btn_Addtolist);
		/*
		 * Need changes
		 */
		// waitFor(cn.toaster);
		// verify toaster-Please add or invite at least one student
		// Assert.assertEquals(getText(cn.toaster), "Please add or invite at
		// least one student");
		waitThread(3000);

	}

	/*
	 * To Assert the clear button functionality on the Add Studentspage
	 */
	@Test(priority = 18)
	public void TCSPR060118() {
		
		waitThread(1000);

		// click on clear button
		click(cn.tab_btn_cancel);

		waitThread(2000);
		// verify the add students popup not visible
		Assert.assertFalse(isEnabled(cn.tab_btn_cancel), "pop up clear Button  is enabled");

	}

	/*
	 * To Assert the close button functionality on the Add Studentspage
	 */
	@Test(priority = 19)
	public void TCSPR060119() {

		waitThread(1000);
		// click on close button
		click(cn.btnpopup_close);

		waitThread(2000);
		// verify the add students popup not visible
		Assert.assertFalse(isElementPresent(cn.popupAddstudents), "pop up    visible");
		waitThread(2000);
		
	}
	
	/*
	 * To check the Email ID edit functionality
	 */
	
	@Test(priority = 20)
	public void TCSPR060120(){
		
		SoftAssert asser1=new SoftAssert();
		
		// click on Add students button
		click(cn.btn_AddStudents);
		waitThread(1000);
		String Email1="a@@gmail.com ";
		
		// type invalid email
		type(cn.tab_textbox,Email1);
		waitThread(2000);
		
		//click on Email
		click(cn.Email_chip);
		waitThread(2000);
		
		//Assert theEdit popup visible 
		Assert.assertTrue(isElementPresent(cn.Emaileditpopup),"Email edit popup not visible");
		Assert.assertEquals(getText(cn.editpopupheading),"Update Email Id");
		Assert.assertEquals(getText(cn.label),"Student Email Id");
		Assert.assertEquals(getValue(cn.Emailtext_bx),Email1.trim());
		
		waitThread(2000);
		click("//p-dialog[@header='Update Email Id']//div[3]//button[2]");
		waitThread(2000);
		
		// type invalid email
		type(cn.tab_textbox,"kuuhiu@@@@.com");
		waitThread(3000);
		waitThread(3000);
		
		//click on Email
		click(cn.Email_chip);
		waitThread(3000);
		Assert.assertEquals(getValue(cn.Emailtext_bx),Email1.trim());
		waitThread(2000);
		click("//p-dialog[@header='Update Email Id']//div[3]//button[2]");
		waitThread(2000);
		
		// type invalid email
		waitThread(2000);
		type(cn.tab_textbox,"kuuhiu@@@@.com " );
		waitThread(2000);
		click("#inviteStudentChipArea > p-chips > div > ul > li.p-chips-token:nth-child(2) > div > span");
		waitThread(2000);
		waitThread(2000);
		
		//click on update button
		click(cn.update_btn);
		waitThread(2000);
		waitFor(cn.validation_msg);
		asser1.assertEquals(getText(cn.validation_msg),"Email Id must be in the correct format");
		waitThread(5000);
		
		//click on update button
		Doubleclick(cn.update_btn);
		waitFor(cn.toaster);
		Assert.assertEquals(getText(cn.toaster),"Enter valid Email Id");
		waitThread(2000);
		
		click(cn.Emailtext_bx);
		Doubleclick("//p-dialog[@header='Update Email Id']//div[3]//button[2]");
		
		//click on Email
		waitThread(2000);
		click(cn.Email_chip);
		waitThread(2000);
		click(cn.label);
		waitThread(2000);
		
		//asser1.Assert.assertEquals(getText(cn.toaster),"Email Id is required");
		String email2="student1@gmail.com";
		waitThread(2000);
		waitThread(2000);
		click(cn.Emailtext_bx);
		driver.findElement(By.xpath(cn.Emailtext_bx)).clear();
		waitThread(2000);
		driver.findElement(By.xpath(cn.Emailtext_bx)).sendKeys(email2);
		waitThread(2000);
		
		// type invalid email
		//	type(cn.tab_textbox,email2);
		//click on update button
		click(cn.update_btn);
		waitThread(7000);
		
		// verify email on textbox
		Assert.assertEquals(cn.emailvalue(0), email2);
		waitThread(1000);
		asser1.assertAll();
			
	
	}

	/*
	 * To check the Invite New Students functionality on the pop up window
	 */
	@Test(priority = 21)
	public void TCSPR060121() {
		
		waitThread(3000);
		// click on close button
		click(cn.btnpopup_close);
		waitThread(2000);
		
		// click on Add students button
		click(cn.btn_AddStudents);
		waitThread(2000);
		
		// type invalid email
		type(cn.tab_textbox, "hhhhh,");
		waitThread(3000);
		
		// verify toottip
		Assert.assertEquals(getAttribute(cn.value1, "ptooltip"), "Invalid email address");

		// click on add to list button
		waitThread(2000);
		click(cn.tab_btn_Addtolist);
		waitThread(2000);
		
		// Verify the confirmation popup is visible
		Assert.assertTrue(isElementPresent(cn.confm_popup), "Confirmation popup not visible");
		Assert.assertEquals(getText(cn.delete_popuptxt), "Do you want to add the students to the Invite list?");
		
		// Click on Yes button
		waitThread(2000);
		click(cn.delete_yes);
		waitFor(cn.toaster);
		
		// toaster-Please remove invalid email(s) from the "Invite New Students"
		// list
		Assert.assertEquals(getText(cn.toaster),
				"Please correct the errors in the \"Invite new students\" tab to proceed further");

		// click on clear button
		waitThread(2000);
		click(cn.tab_btn_cancel);
		waitThread(1000);
		
		// Verify the confirmation popup is visible
		Assert.assertTrue(isElementPresent(cn.confm_popup), "Confirmation popup not visible");
		waitThread(1000);
		Assert.assertEquals(getText(cn.delete_popuptxt), "Do you want to clear the selected students?");
		waitThread(1000);
		
		// Click on Yes button
		click(cn.delete_yes);
		waitThread(2000);
		
		// Assert the text box is empty
		Assert.assertEquals(getAttribute(cn.tab_textbox, "placeholder"), "Enter Email ID");
	}
	
	
	

	/*
	 * To type email on the add students window textbox
	 */
	@Test(priority = 22)
	public void TCSPR060122() {

		waitThread(2000);
		// type email
		type(cn.tab_textbox, "test@gmail.com,");
		waitThread(2000);
		
		// verify email on textbox
		Assert.assertEquals(cn.emailvalue(0), "test@gmail.com");
		waitThread(1000);

	}

	/*
	 * To check the CSV upload functionality
	 */
	@Test(priority = 23)
	public void TCSPR060123() {

		waitThread(2000);
		// import csv
		cn.fileupload("Emailscsv.csv");
		waitThread(1000);

		// verify email present on the textbox
		Assert.assertEquals(cn.emailvalue(1), "student1@gmail.com");

	}

	/*
	 * To check the Text file upload functionality
	 */
	@Test(priority = 24)
	public void TCSPR060124() {

		waitThread(2000);
		// import text file
		cn.fileupload("Emailtext.txt");
		waitThread(1000);

		// verify email present on the textbox
		Assert.assertEquals(cn.emailvalue(2), "student2@gmail.com");

	}

	/*
	 * To check with invalid file upload functionality
	 */
	@Test(priority = 25)
	public void TCSPR060125() {
		
		waitThread(2000);
		// upload invalid file
		cn.fileupload("TestImage.png");
		waitFor(cn.toasterinvalid);

		// verify toaster message-Invalid file format
		Assert.assertEquals(getText(cn.toasterinvalid), "Invalid file format");
		waitThread(1000);

	}

	/*
	 * To check the search functionality on the Invite New Students tab
	 */
	@Test(priority = 26)
	public void TCSPR060126() {

		// type on search box
		//type(cn.btnpopup_search, "Test@gmail.com");
		driver.findElement(By.xpath(cn.btnpopup_search)).sendKeys("student2");
		waitThread(2000);

		// verify email present on the textbox
		Assert.assertEquals(cn.emailvalue(0), "student2@gmail.com");

	}

	/*
	 * To check the Invite Students from my existing courses functionality on
	 * the popup Assert the headings,labels,text
	 */
	@Test(priority = 27)
	public void TCSPR060127() {
		waitThread(2000);
		// click on Invite Students from my existing courses tab
		click(cn.tab_Addstudent);
		waitThread(1000);
		
		// Verify the following grid labels
		Assert.assertEquals(getText(cn.lbl_SIno), "Sl No:");
		Assert.assertEquals(getText(cn.lbl_studentID), "Student ID");
		Assert.assertEquals(getText(cn.lbl_Firstname), "First Name");
		Assert.assertEquals(getText(cn.lbl_LastName), "Last Name");
		Assert.assertEquals(getText(cn.lbl_Email), "Email ID");
		Assert.assertEquals(getText(cn.gridtxt_1), "No Student(s) Found.");

	}

	/*
	 * To check the Add to list functionality on the Add students to the course
	 * popup window
	 */
	@Test(priority = 28)
	public void TCSPR060128() {
		
		waitThread(2000);
		click(cn.tab_invite);
		waitThread(2000);
		
		// click on add to list button
		click(cn.tab_btn_Addtolist);
		waitThread(4000);
		// Click on Yes button
		click(cn.delete_yes);
		waitThread(2000);
		// verify the labels
		Assert.assertEquals(getText(cn.lbl_newstudinv), "New Students to be invited to this course");
		waitThread(3000);
		Assert.assertEquals(getText(cn.lbl_studfrommystud), "Students from My Student list");
		waitThread(3000);
	}

	/*
	 * To check the course Add functionality on the course add page
	 */
	@Test(priority = 29)
	public void TCSPR060129() {
		waitThread(1000);
		click(cn.btnsendrequest1);
		waitThread(1000);
		// click on create course button
		click(cn.btn_Createcourse);

		waitThread(1000);
		waitFor(cn.toaster);
		// verify toaster-Course created successfully
		Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");

		waitThread(3000);

		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), CourseTitle.trim());

	}

	/*
	 * To check the Invited & Not Accepted count for the course New Course
	 * Name+Random Number on the grid
	 */
	@Test(priority = 30)
	public void TCSPR060130() {

		waitFor(cn.btn_submenu);
		// click on submenu button
		click(cn.btn_submenu);

		// verify the Invited &not accepted count
		Assert.assertEquals(cn.gridvalue(7), "3");
		waitThread(3000);

	}

	/*
	 * To perform delete course functionality on the course landing page
	 */
	@Test(priority = 31)
	public void TCSPR060131() {

		// click on details button dropdown
		click(cn.btn_details_1);

		// Click on delete course link
		click(cn.link_deletecourse);
		waitThread(2000);

		// click on Yes button
		click(cn.delete_yes);
		waitThread(2000);
		waitFor(cn.toaster);
		// verify toaster message-Course deleted successfully
		Assert.assertEquals(getText(cn.toaster),
				"The course" + " " + "\"" + CourseTitle.trim() + "\"" + " has been successfully deleted.");
		waitThread(5000);

	}

	/*
	 * To perform delete account functionality and login using delete account
	 * credentails
	 */
	@Test(priority = 32)
	public void TCSPR060132() {

		// To perform delete account functionality
		cn.DeleteAccount();

		// To login with deleted account credentials
		lg.login(EmailTeacher, "Abc@123");

		waitFor(cn.toaster);
		// verify toaster text
		Assert.assertEquals(getText(cn.toaster), "Enter a valid email address and password");

	}

}
