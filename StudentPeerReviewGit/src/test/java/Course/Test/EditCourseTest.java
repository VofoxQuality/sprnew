package Course.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Generalmethods.Databaseconnection;

import Course.Pages.CreateNewCoursePage;
import Course.Pages.EditCoursePage;
import Login.Pages.LoginPage;
import Login.Test.LoginTest;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;

public class EditCourseTest extends basePage {

	CreateNewCoursePage cn = new CreateNewCoursePage();
	EditCoursePage ec = new EditCoursePage();
	SignUpTest st = new SignUpTest();
	Databaseconnection dc = new Databaseconnection();
	LoginPage lg = new LoginPage();
	LoginTest lt = new LoginTest();
	SignUpPage sp = new SignUpPage();
	public String CourseName;
	public String NewCourseName;
	public String CourseID;
	public String Email;
	public String otp;
	public String EmailTeacher;

	/*
	 * To perform Sign Up functionality
	 */
	
	@Test(priority = 0)
	public void TCSPR070201() {

		// To click on I am A teacher button
		click(sp.btn_1);
		

		// To fill the details on the sign up page
		st.TCSPR020005();
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
	 * To fill all the fields on the create new course
	 */
	@Test(priority = 2)
	public void TCSPR070202() {

		CourseName = "Course Name" + generateRandomNumber();

		// Click on create new course button
		click(cn.btn_createnew);

		// To get the Course ID
		CourseID = (getText(cn.course_Id));

		// type-Course title
		type(cn.txbx_Coursetitle, CourseName);

		// Type-Course code
		type(cn.txtbx_Coursecode, "01");

		// Assert the course code
		Assert.assertEquals(getValue(cn.txtbx_Coursecode), "01");

		// Type-Course section
		type(cn.txtbx_Coursesec, "Sec_101");

		// Assert the course section
		Assert.assertEquals(getValue(cn.txtbx_Coursesec), "Sec_101");

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
	 * To check the added course functionality and Assert the details visible on the
	 * grid
	 */
	@Test(priority = 3)
	public void TCSPR070203() {

		ScrollTo_Location(cn.btn_Createcourse);
		waitThread(2000);
		// click on create course button
		click(cn.btn_Createcourse);

		waitFor(cn.toaster);

		// verify toaster-Course created successfully
		Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");

		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), CourseName.trim());

	}

	/*
	 * To check the view/Edit course functionality on the grid
	 */
	@Test(priority = 4)
	public void TCSPR070204() {

		waitThread(3000);
		// To click on split button
		click(ec.splitbutton);
		waitThread(3000);
		// click on View/Modify Course Details button
		click(ec.btn_coursedetails);
		waitThread(3000);
		// Course Details-Heading
		Assert.assertEquals(getText(ec.heading_coursedetails), "Course Details");

	}

	/*
	 * To check labels in the course details page
	 */
	@Test(priority = 5)
	public void TCSPR070205() {

		// Assert the following heading labels
		Assert.assertEquals(getText(ec.label_1), "Course Title*");
		Assert.assertEquals(getText(ec.label_2), "Course Code");
		Assert.assertEquals(getText(ec.label_3), "Course Section");
		Assert.assertEquals(getText(ec.label_4), "Department");
		Assert.assertEquals(getText(ec.label_5), "District or Institution");
		Assert.assertEquals(getText(ec.label_6), "Additional Notes");

		// Assert the following textboxes
		// Textboxes
		Assert.assertTrue(isElementPresent(cn.txbx_Coursetitle), "Course Title Textbox not present");
		Assert.assertTrue(isElementPresent(cn.txtbx_Coursecode), "Course code Textbox not present");
		Assert.assertTrue(isElementPresent(cn.txtbx_Coursesec), "Course section Textbox not present");
		Assert.assertTrue(isElementPresent(cn.txtbx_dep), "Department Textbox not present");
		Assert.assertTrue(isElementPresent(cn.txtbx_district), "District Textbox not present");
		Assert.assertTrue(isElementPresent(cn.txtbx_special), "Additional note Textbox not present");

		waitThread(2000);
		// verify the course title
		Assert.assertEquals(getText(cn.course_Id).trim(), CourseID.trim());

	}

	/*
	 * To check the course code copy functionality on the create new course
	 */
	@Test(priority = 6)
	public void TCSPR070206() {

		// To verify the course id copy option present
		Assert.assertTrue(isElementPresent(cn.coursecopy), "Course copy button  not present");

		// click on copy option
		click(cn.coursecopy);

		waitFor(cn.toaster);
		// verify toaster text-Course ID is copied to clipboard
		Assert.assertEquals(getText(cn.toaster), "Course ID is copied to clipboard");
		waitThread(1000);

	}

	/*
	 * To check the buttons on the course details page
	 */
	@Test(priority = 7)
	public void TCSPR070207() {

		// Button-Delete
		Assert.assertTrue(isElementPresent(cn.delete_btn), "Delete Button Not present");

		// Assessment
		Assert.assertTrue(isElementPresent(ec.btn_Assessment), "Edit Button Not present");
		Assert.assertEquals(getText(ec.btnlbl_Assessment), "Assessment");

		// Edit Button
		Assert.assertTrue(isElementPresent(ec.btn_edit), "Edit Button Not present");

		// Save Changes
		Assert.assertTrue(isElementPresent(ec.btnsave), "Save Changes Button Not present");
		Assert.assertEquals(getAttribute(ec.btnsave, "label"), "Save Changes");

		// Discard changes
		Assert.assertTrue(isElementPresent(ec.btn_discardchanges), "Discard changes Button Not present");
		Assert.assertEquals(getAttribute(ec.btnlbl_discard, "label"), "Discard Changes");

	}

	/*
	 * To check the visibility of buttons,textboxes in the course details page
	 */
	@Test(priority = 8)
	public void TCSPR070208() {

		// verify that the textboxes are disabled
		Assert.assertFalse(isEnabled(cn.txbx_Coursetitle), "Course title textbox is enabled");
		Assert.assertFalse(isEnabled(cn.txtbx_Coursecode), "Course code textbox is enabled");
		Assert.assertFalse(isEnabled(cn.txtbx_Coursesec), "Course section textbox is enabled");
		Assert.assertFalse(isEnabled(cn.txtbx_dep), "Course department textbox is enabled");
		Assert.assertFalse(isEnabled(cn.txtbx_district), "District textbox is enabled");
		Assert.assertFalse(isEnabled(cn.txtbx_special), "Special notes textbox is enabled");

		// verify the following buttons disabled
		Assert.assertFalse(isEnabled(ec.btnsave), "Save button is enabled");
		Assert.assertFalse(isEnabled(ec.btn_discardchanges), "Discard changes button is enabled");

	}

	/*
	 * To check the details present on the text boxes in the course details page
	 */
	@Test(priority = 9)
	public void TCSPR070209() {

		// Verify the course code
		Assert.assertEquals(getValue(cn.txbx_Coursetitle), CourseName.trim());

		// Verify the course code
		Assert.assertEquals(getValue(cn.txtbx_Coursecode), "01");

		// Verify the course section
		Assert.assertEquals(getValue(cn.txtbx_Coursesec), "Sec_101");

		// Verify the Department
		Assert.assertEquals(getValue(cn.txtbx_dep), "Course Department_01");

		// Verify the District
		Assert.assertEquals(getValue(cn.txtbx_district), "Course Name_District");

		// Verify the Department
		Assert.assertEquals(getValue(cn.txtbx_special), "Course for High School students");

	}

	/*
	 * To check the edit functionality on the course details page
	 */
	@Test(priority = 10)
	public void TCSPR070210() {
		// WebDriverWait wait=new WebDriverWait(driver,10);

		NewCourseName = "New Course Name" + generateRandomNumber();

		// click on Edit button
		click(ec.btn_edit);

		// type-Course title
		type(cn.txbx_Coursetitle, NewCourseName);

		// Type-Course code
		type(cn.txtbx_Coursecode, "02");

		// Assert the course code
		Assert.assertEquals(getValue(cn.txtbx_Coursecode), "02");

		// Type-Course section
		type(cn.txtbx_Coursesec, "Sec_102");

		// Assert the course section
		Assert.assertEquals(getValue(cn.txtbx_Coursesec), "Sec_102");

		// Type-Department
		type(cn.txtbx_dep, "New Course Department_01");

		// Assert the Department
		Assert.assertEquals(getValue(cn.txtbx_dep), "New Course Department_01");

		// Type-District
		type(cn.txtbx_district, "New Course Name_District");

		// Assert the District
		Assert.assertEquals(getValue(cn.txtbx_district), "New Course Name_District");

		// Type-Department
		type(cn.txtbx_special, "New Course for High School students");

		// Assert the Department
		Assert.assertEquals(getValue(cn.txtbx_special), "New Course for High School students");

		// click on save changes button
		click(ec.btnsave);
		waitThread(1000);

		// Verify the toaster message
		Assert.assertEquals(getText(ec.toaster), "Course details updated successfully");
		waitThread(1000);
		// verify the following buttons disabled
		Assert.assertFalse(isEnabled(ec.btnsave), "Save button is enabled");
		Assert.assertFalse(isEnabled(ec.btn_discardchanges), "Discard changes button is enabled");

	}

	/*
	 * To check the Discard Changes Button functionality
	 */
	@Test(priority = 11)
	public void TCSPR070211() {

		// click on Edit button
		click(ec.btn_edit);

		// type-Course title
		type(cn.txbx_Coursetitle, "Mathematics");

		// click on discard changes button
		click(ec.btn_discardchanges);

		// verify the popup visible
		Assert.assertTrue(isElementPresent(cn.popupbx), "Discard popup not visible");
		waitFor(ec.popupheadinglbl);

		// to verify label-
		Assert.assertEquals(getText(ec.popupheadinglbl), "Discard Changes");

		// to verify popup text
		Assert.assertEquals(getText(cn.popuptxt), "Are you certain you want to proceed with your action?\n"
				+ "Any changes that you have made will not be saved.");

		// to verify the discard button visible
		Assert.assertTrue(isElementPresent(cn.popupbtnDiscard), "Discard button not visible");

		// to verify cancel button visible
		Assert.assertTrue(isElementPresent(cn.popupbtnCancel), "Cancel Button not visible");

		// click on cancel button
		click(cn.popupbtnCancel);

		waitThread(1000);
		// verify popup box not visible
		Assert.assertFalse(isElementPresent(cn.popupbx), "Discard popup  visible");

		// click on discard changes button
		click(ec.btn_discardchanges);

		// click on popup discard button
		click(cn.popupbtnDiscard);
		waitThread(2000);

		// verify course name
		Assert.assertEquals(getValue(cn.txbx_Coursetitle), NewCourseName.trim());

	}

	/*
	 * To check the Active/Inactive functionality on the course details page
	 */
	@Test(priority = 12)
	public void TCSPR070212() {

		// click on Active button
		click(ec.active_btn);

		// verify the confirmation pop up visible
		Assert.assertTrue(isElementPresent(cn.confm_popup), "Confirmation popup not visible");

		waitThread(3000);
		// Assert following"
		Assert.assertEquals(getText(ec.lbl_confirmation), "Course: "+NewCourseName.trim());
		waitThread(2000);
		Assert.assertEquals(getText(ec.confirmation_text), "Are you sure that you want to inactivate this course?");
	
		waitThread(1000);

		// button Yes
		Assert.assertTrue(isElementPresent(ec.btnyes), "Yes button not visible in the Confirmation popup");
		// m
		waitThread(4000);
		// button-No
		Assert.assertTrue(isElementPresent(ec.btnNo), "No button not visible in the Confirmation popup");
		waitFor(ec.btnyes);
		// click on No button
		JavaScriptclick(ec.btnyes);

		waitThread(1000);
		// verify the confirmation popup not visible
		Assert.assertFalse(isElementPresent(cn.confm_popup), "confirmation popup  visible");
	
		waitFor(cn.toaster);
		// Toaster-Course status updated successfully
		Assert.assertEquals(getText(cn.toaster), "This course has been successfully inactivated");
		click(cn.toasterclosebtn);
		// click on back to course button
		click(ec.backbtn);

		// verify the course name not present on the grid
		Assert.assertFalse(isElementPresent(ec.coursename), "Course name present");

	}

	/*
	 * To check the Active/Inactive functionality on the course landing page
	 */
	@Test(priority = 13)
	public void TCSPR070213() {
		waitThread(3000);
		// verify label active
		Assert.assertEquals(getText(ec.coursestatus_dd), "Active");
		waitThread(2000);
		// click on course status dropdown
		click(ec.coursestatus_dd);
		waitThread(2000);

		// inactive dropdown visibility
		Assert.assertTrue(isElementPresent(ec.dd_inactive), "Inactive button present");

		// verify label Inactive
		Assert.assertEquals(getText(ec.dd_inactive), "Inactive");

		// click on inactive dropdwon
		click(ec.dd_inactive);

		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), NewCourseName.trim());

	}

	/*
	 * To check the Active/Inactive functionality on the course details page
	 */
	//@Test(priority = 14)
	public void TCSPR070214() {

		// To click on split button
		click(ec.splitbutton);

		// click on details button
		click(ec.btn_coursedetails);
		waitThread(2000);
		// To verify the active button disabled
		Assert.assertEquals(getAttribute(ec.btn_active, "aria-checked"), "false");

		// click on Active button
		click(ec.active_btn);
		waitThread(2000);

		waitFor(ec.btnyes);
		// click on Yes button
		click(ec.btnyes);

		waitFor(cn.toaster);

		Assert.assertEquals(getText(cn.toaster), "The course "+NewCourseName.trim()+" has been successfully activated");
		click(cn.toasterclosebtn);
		// To verify the active button disabled
		Assert.assertEquals(getAttribute(ec.btn_active, "aria-checked"), "true");

		waitThread(2000);
		// click on back to course button
		click(ec.backbtn);
		waitThread(3000);
		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), NewCourseName.trim());

	}

	/*
	 * To check with already used course name on the course Edit page
	 */
	@Test(priority = 15)
	public void TCSPR070215() {
		WebDriverWait wait = new WebDriverWait(driver, 10);

		waitThread(2000);
		// Click on create new course button
		click(cn.btn_createnew);
		waitThread(3000);
		// type-Course title
		type(cn.txbx_Coursetitle, "IT");
		waitThread(2000);
		ScrollTo_Location(cn.btn_Createcourse);

		waitThread(2000);
		// click on create course button
		click(cn.btn_Createcourse);
		waitThread(2000);
		// click on course status dropdown
		click(ec.coursestatus_dd);
		waitThread(2000);
		// click on inactive dropdwon
		click(ec.ddactive);
		waitThread(2000);
		type(cn.searchbx, "IT");
		waitThread(2000);
		// verify the course title
		Assert.assertEquals(getText(cn.value_coursetitle).trim(), "IT");
		waitThread(2000);

		// To click on split button
		click(ec.splitbutton);

		waitThread(2000);
		// click View/modify course details
		click(ec.modify_course);

		waitThread(2000);
		// click on Edit button
		click(ec.btn_edit);
		waitThread(2000);
		// type-Course title
		type(cn.txbx_Coursetitle, NewCourseName.trim());
		waitThread(2000);

		click(cn.txtbx_Coursecode);
		waitFor(ec.val_3);
		waitThread(2000);
		// verify validation messages
		Assert.assertEquals(getText(ec.val_3), "Course '" + NewCourseName.trim() + "' already exist");
		waitThread(2000);
		// click on save changes button
		click(ec.btnsave);
		waitThread(3000);
		// To verify that can't save with already used course name
		Assert.assertFalse(isElementPresent(cn.toaster), "Toaster message visible");
		Assert.assertTrue(isEnabled(ec.btnsave), "The Save changes button is Not Enabled");
		// verify validation messages
		Assert.assertEquals(getText(ec.val_3), "Course '" + NewCourseName.trim() + "' already exist");

	}

	/*
	 * To check the delete functionality on the course landing page
	 */
	@Test(priority = 16)
	public void TCSPR070216() {

		// click on delete button
		click(ec.btn_deletee);

		// verify the confirmation pop up visible
		Assert.assertTrue(isElementPresent(ec.confm_popup), "Confirmation popup not visible");

		waitThread(3000);
		// Assert following
		Assert.assertEquals(getText(ec.confirmationlbl), "Course: "+NewCourseName.trim());
		waitThread(1000);
		Assert.assertEquals(getText(ec.delete_popuptxt), "Are you sure that you want to permanently delete this course?");

		// button Yes
		Assert.assertTrue(isElementPresent(ec.delete_yes), "Yes button not visible in the Confirmation popup");

		// button-No
		Assert.assertTrue(isElementPresent(ec.delete_No), "No button not visible in the Confirmation popup");
		waitThread(2000);
		// click on No button
		click(ec.delete_No);

		waitThread(2000);
		// verify the confirmation popup not visible
		Assert.assertFalse(isElementPresent(ec.confm_popup), "confirmation popup  visible");

		waitThread(2000);

		// click on delete button
		click(ec.btn_deletee);

		// click on Yes button
		click(ec.delete_yes);
		waitThread(3000);

		// verify toaster message-Course deleted successfully
		Assert.assertEquals(getText(cn.toaster), "Course deleted successfully");

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	/*
	 * To check the back to course button functionality on the course details page
	 */
	@Test(priority = 17)
	public void TCSPR070217() {
		// click on course status dropdown
		click(ec.coursestatus_dd);
		waitThread(2000);
		// click on inactive dropdwon
		click(ec.dd_inactive);
		waitThread(2000);
		// To click on split button
		click(ec.splitbutton);

		// click on details button
		click(ec.btn_coursedetails);
		waitThread(2000);
		
		// click on Active button
		click(ec.active_btn);
		waitThread(2000);

		waitFor(ec.btnyes);
		// click on Yes button
		click(ec.btnyes);
		waitThread(2000);
		// click on Edit button
		click(ec.btn_edit);
		waitThread(2000);
		// type-Course title
		type(cn.txbx_Coursetitle, "Physics");
		waitThread(1000);
		// click on back to course button
		click(ec.backbtn);

		// verify the popup visible
		Assert.assertTrue(isElementPresent(cn.popupbx), "Discard popup not visible");
		waitFor(ec.popupheadinglbl);
		// to verify label-
		Assert.assertEquals(getText(ec.popupheadinglbl), "Discard Changes");

		// to verify popup text
		Assert.assertEquals(getText(cn.popuptxt), "Are you certain you want to proceed with your action?\n"
				+ "Any changes that you have made will not be saved.");

		// to verify the discard button visible
		Assert.assertTrue(isElementPresent(cn.popupbtnDiscard), "Discard button not visible");

		// to verify cancel button visible
		Assert.assertTrue(isElementPresent(cn.popupbtnCancel), "Cancel Button not visible");

		// click on cancel button
		click(cn.popupbtnCancel);

		waitThread(2000);
		// verify popup box not visible
		Assert.assertFalse(isElementPresent(cn.popupbx), "Discard popup  visible");

		// click on back to course button
		click(ec.backbtn);

		// click on popup discard button
		click(cn.popupbtnDiscard);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}

	// *To check the View/Process Student requests functionality on the grid*/

	@Test(priority = 18)
	public void TCSPR07218() throws SQLException {

		waitThread(2000);
		click(ec.splitbutton);
		waitThread(3000);
		Assert.assertEquals(getText(ec.stud_enroll), "View/Process student request to join");
		click(ec.stud_enroll);
		waitThread(3000);
		Assert.assertEquals(getText(ec.stud_request_enrollment), "Requests from Students for Enrollment");
		waitThread(3000);
		//To check the header details on the course roster page
		Assert.assertEquals(getText(ec.new_course), NewCourseName.trim());

	}
	//To check the buttons,labels on the student request for enrollment page

	@Test(priority = 19)

	public void TCSPR070219() throws SQLException

	{

		waitThread(3000);
		Assert.assertTrue(isElementPresent(ec.pending_request_checkbox), "Pending request checkbox Not present");
		Assert.assertEquals(getText(ec.pending_request_checkbox), "Pending Requests to join the course");
		Assert.assertTrue(isElementPresent(ec.checkbox_2), "Requests to join the course that were processed");
		Assert.assertEquals(getText(ec.checkbox_2), "Requests to join the course that were processed");
		Assert.assertTrue(isElementPresent(ec.approve_btn), "Approve button is not visible");
		Assert.assertTrue(isElementPresent(ec.decline_btn), "Decline button is not visible");
		Assert.assertTrue(isElementPresent(ec.search_box), "Search box is not visible");
		waitThread(3000);
		Assert.assertEquals(getAttribute(ec.search_label, "placeholder"), "Search Name/Email");

	}

	//To check the grid heading labels  on the Pending Requests to join the course page

	@Test(priority = 20)

	public void TCSPR070220() {
		waitThread(3000);
		Assert.assertEquals(getText(ec.serial_no), "Sl No");
		Assert.assertEquals(getText(ec.date_requested), "Date Requested");
		Assert.assertEquals(getText(ec.stu_id), "Student ID");
		waitThread(3000);
		Assert.assertEquals(getText(ec.first_name), "First Name");
		waitThread(3000);
		Assert.assertEquals(getText(ec.last_name), "Last Name");
		waitThread(3000);
		Assert.assertEquals(getText(ec.email_id), "Email id");
		Assert.assertTrue(isEnabled(ec.pending_request_checkbox),
				"Pending request checkbox Not present is not Enabled");
		Assert.assertEquals(getText(ec.no_result), "No Request(s) Found.");
		waitThread(3000);
	}
	//To check the grid heading labels  on the Requests to join the course that were processed page
	@Test(priority = 21)

	public void TCSPR070221() {
		waitThread(3000);
		click(ec.radio_btn2);
		waitThread(4000);
		Assert.assertEquals(getText(ec.serial_no2), "Sl No");
		waitThread(2000);
		Assert.assertEquals(getText(ec.date_requested2), "Date Requested");
		waitThread(2000);
		Assert.assertEquals(getText(ec.sudid_3), "Student ID");
		waitThread(2000);
		Assert.assertEquals(getText(ec.first_name2), "First Name");
		Assert.assertEquals(getText(ec.last_name2), "Last Name");
		Assert.assertEquals(getText(ec.email_id2), "Email ID");
		Assert.assertEquals(getText(ec.status_2), "Status");
		Assert.assertEquals(getText(ec.approve_decline_on), "Approved/Declined On");

		Assert.assertEquals(getText(ec.course_label), "Course:");
		Assert.assertEquals(getText(ec.approve_label), "Approved");
		Assert.assertEquals(getText(ec.decline_label), "Declined");

	}
	//To check the back button functionality on the student request for enrollment page

	@Test(priority = 22)

	public void TCSPR07022() {

		waitThread(3000);
		Assert.assertEquals(getText(ec.back_btn), "Back to Course Listings");
		click(ec.back_btn);
		waitThread(3000);
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");

	}
	/*
	 * To perform delete account functionality and login using delete account
	 * credentails
	 */

	@Test(priority = 23)

	public void TCSPR07023() {

		waitThread(3000);
		ec.DeleteAccount();
		waitThread(3000);
		// To verify with invalid data
		String mail = st.Email;
		String password = "Abc@123";
		lg.login(mail, password);

		waitFor(lg.validationmsg3);
		// verify toaster text
		Assert.assertEquals(getText(lg.validationmsg3), "Enter a valid email address and password");

	}


}
