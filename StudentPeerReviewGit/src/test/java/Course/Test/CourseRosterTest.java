package Course.Test;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Generalmethods.Databaseconnection;

import Course.Pages.CourseRosterPage;
import Course.Pages.CreateNewCoursePage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;
import SignUp.Test.SignUpTest;

public class CourseRosterTest extends basePage {

	SignUpPage sp = new SignUpPage();
	SignUpTest st = new SignUpTest();
	LoginPage lg = new LoginPage();
	Databaseconnection dc = new Databaseconnection();
	CourseRosterPage cr = new CourseRosterPage();
	CreateNewCoursePage cn = new CreateNewCoursePage();
	public String Email;
	public String otp;
	public String CourseName;
	public String CourseID;
	public String Emailstudent1;
	public int Emailcountaftersearch;
	public String Emailcountbeforesearch;
	public String EmailTeacher;

	/*
	 * To perform Sign Up functionality
	 */
	@Test(priority = 0)
	public void TCSPR060301() throws SQLException {

		// To click on I am A teacher button
		click(sp.btn_1);

		// To fill the details on the sign up page
		EmailTeacher = st.TCSPR020005();
		System.out.println(EmailTeacher);
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
	public void TCSPR060302() {

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

		// type invalid email
		type(cn.tab_textbox, Emailstudent1 + ",");

		// verify email present on the text box
		Assert.assertEquals(cn.emailvalue(0), Emailstudent1);

		// click on add to list button
		click(cn.tab_btn_Addtolist);

		waitThread(3000);
		// click on yes button
		click(cn.delete_yes);

		waitThread(3000);
		waitFor(cr.emailvalue_1);
		// verify the Email on the New Students to be invited to this class box
		Assert.assertEquals(getText(cr.emailvalue_1), Emailstudent1);

	}

	/*
	 * To check the create new course functionality on the landing page
	 */
	@Test(priority = 3)
	public void TCSPR060303() {
		
		waitThread(2000);
		click(cn.btnsendrequest1);
		click(cn.stud_chip);
		// click on create course buttona
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
	 * To check the View/Modify Student Roster functionality on the grid
	 */
	@Test(priority = 4)
	public void TCSPR060304() {

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
		// verify the course name on the grid
		Assert.assertEquals(getText(cr.course_name).trim(), CourseName.trim());

	}

	/*
	 * To verify the labels and radio buttons
	 */
	@Test(priority = 5)
	public void TCSPR060305() {

		Assert.assertEquals(getText(cr.lbl_course), "Course:");
		Assert.assertEquals(getText(cr.lbl_enrolled), "Enrolled");
		Assert.assertEquals(getText(cr.lbl_InvitedNotAccepted), "Invited & Not Accepted");
		Assert.assertEquals(getText(cr.lbl_suspended), "Suspended");

		Assert.assertTrue(isElementPresent(cr.radiobtn_enrolled), "The Enrolled radio button not present");
		Assert.assertTrue(isElementPresent(cr.radiobtn_invited), "Invited & Not Accepted radio button not present");
		Assert.assertTrue(isElementPresent(cr.radiobtn_suspended), "Suspended radio button not present");
		Assert.assertTrue(isSelected(cr.check_radiobtn_enrolled), "The Enrolled radio button is not checked");

	}

	/*
	 * To verify the labels,buttons,toaster,search box
	 */
	@Test(priority = 6)
	public void TCSPR060306() {

		Assert.assertEquals(getText(cr.btnlbl_Action), "Actions");
		// Assert.assertEquals(getAttribute(cr.placeholder_search,
		// "placeholder"), "Search Student");

		Assert.assertTrue(isElementPresent(cr.btn_Action), "Actions button not present");
		Assert.assertTrue(isElementPresent(cr.searchbox), "Search box not present");
		// Assert.assertEquals(getAttribute(cr.Tooltipinvite, "ptooltip"),
		// "Invite more students");
		Assert.assertTrue(isElementPresent(cr.btn_backtocourse), "Back to course button present");
		Assert.assertEquals(getAttribute(cr.lbl_backtocourse, "label"), "Back to Course Listings");

	}

	/*
	 * To verify Action button dropdowns and links
	 */
	@Test(priority = 7)
	public void TCSPR060307() {

		click(cr.btn_Action);
		Assert.assertTrue(isElementPresent(cr.Actiondropdown), "Action dropdown box not visible");
		waitThread(2000);
		Assert.assertTrue(isElementPresent(cr.link_Suspendstudents), "Suspended students link not present");
		waitThread(2000);
		waitFor(cr.lbl_suspendedstudents);
		waitThread(2000);
		Assert.assertEquals(getText(cr.lbl_suspendedstudents), "Suspend Students");
		Assert.assertTrue(isElementPresent(cr.link_Reenrollstudents), "Re-enroll Students link not present");
		waitFor(cr.lbl_Reenrollstudents);
		Assert.assertEquals(getText(cr.lbl_Reenrollstudents), "Re-enroll Students");
		Assert.assertTrue(isElementPresent(cr.link_Resendinvitation), "Resend Invitations link not present");
		waitFor(cr.lbl_Resendinvitation);
		Assert.assertEquals(getText(cr.lbl_Resendinvitation), "Resend Invitations");
		Assert.assertTrue(isElementPresent(cr.link_Removestudents), "Remove Students link not present");
		waitFor(cr.lbl_Removestudents);
		Assert.assertEquals(getText(cr.lbl_Removestudents), "Remove Students");
		Assert.assertTrue(isElementPresent(cr.link_Revokeinvitations), "Revoke Invitations link not present");
		waitFor(cr.lbl_Revokeinvitations);
		Assert.assertEquals(getText(cr.lbl_Revokeinvitations), "Revoke Invitations");
		click(cr.btn_Action);
		waitThread(1000);
		Assert.assertFalse(isDisplayed(cr.Actiondropdown), "Action dropdown box  visible");

	}

	/*
	 * To check the table headings on the Invited & Not Accepted tab page
	 */
	@Test(priority = 8)
	public void TCSPR060308() {

		// click on invite radio button
		waitFor(cr.radiobtn_invited);
		click(cr.radiobtn_invited);

		// verify the radio button is selected
		Assert.assertTrue(isSelected(cr.check_radiobtn_invites),
				"The Invited & Not Accepted radio button is not checked");

		// To verify the grid labels
		Assert.assertEquals(getText(cr.lbl_Sino), "Sl No:");
		Assert.assertEquals(getText(cr.lbl_StudentID), "Student ID");
		Assert.assertEquals(getText(cr.lbl_Firstname), "First Name");
		Assert.assertEquals(getText(cr.lbl_lastname), "Last Name");
		Assert.assertEquals(getText(cr.lbl_Emailid), "Email ID");
		Assert.assertEquals(getText(cr.lbl_Invitationsendon), "Invitation Sent on");
		Assert.assertEquals(getText(cr.lbl_invitationstatus), "Invitation Status");

	}

	/*
	 * To check the data on the course roster Invited & Not Accepted Grid
	 */
	@Test(priority = 9)
	public void TCSPR060309() {

		// To verify the All check box present
		Assert.assertTrue(isElementPresent(cr.All_checkbox), "All checkbox is not present");

		// To verify the data's on the grid(Emails)
		Assert.assertTrue(isElementPresent(cr.gridvalue_email), "Student Email not present");
		Assert.assertEquals(getText(cr.gridvalue_email), Emailstudent1);

		// To verify the student id,firstname,lastname not visible on the grid
		Assert.assertEquals(getText(cr.gridvalue_studentid), "");
		Assert.assertEquals(getText(cr.gridvalue_firstname), "");
		Assert.assertEquals(getText(cr.gridvalue_lastname), "");

		// To verify the status
		Assert.assertEquals(getText(cr.lbl_notaccepted), "NO ACCOUNT");

		// Verify the Created date with system date
		Assert.assertEquals(getText(cr.invited_senddate), cr.getdate());

	}

	/*
	 * To check the search functionality on the course roster Invited & Not
	 * Accepted Grid
	 */
	@Test(priority = 10)
	public void TCSPR060310() {

		// To click on search box
		click(cr.searchbox);

		// To type Email id on search box
		type(cr.searchbox, Emailstudent1);

		// To verify the Email on the grid
		Assert.assertEquals(getText(cr.gridvalue_email), Emailstudent1);

	}

	/*
	 * To check the Resend Email functionality on the Action dropdown
	 */
	@Test(priority = 11)
	public void TCSPR060311() {

		// verify the student check box
		Assert.assertTrue(isElementPresent(cr.studentchkbx_1), "The check box visible on the page ");

		// click on check box
		check(cr.studentchkbx_1);

		// verify the check box is checked
		Assert.assertEquals(getAttribute(cr.studentchkbx_1, "aria-checked"), "true");

		// click on Action button
		click(cr.btn_Action);

		// verify the Action drop down visible
		waitFor(cr.Actiondropdown);
		Assert.assertTrue(isDisplayed(cr.Actiondropdown), "Action dropdown box not visible");
		waitThread(5000);
		// click on resend invitation button on the Action drop down
		click(cr.link_Resendinvitation);
		waitThread(3000);
		JavaScriptclick(cr.yes_btn);
		waitThread(2000);
		// verify the Toaster message
		waitFor(cr.toaster);
		Assert.assertEquals(getText(cr.toaster), "Successfully sent email");
		waitThread(5000);

	}

	/*
	 * To check the Revoke Invitations functionality on the course roster page
	 */
	@Test(priority = 12)
	public void TCSPR060312() {

		// click on check box
		waitFor(cr.studentchkbx_1);
		check(cr.studentchkbx_1);

		// verify the check box is checked
		Assert.assertEquals(getAttribute(cr.studentchkbx_1, "aria-checked"), "true");

		// click on Action button
		click(cr.btn_Action);

		// verify the Action drop down visible
		waitFor(cr.Actiondropdown);
		Assert.assertTrue(isDisplayed(cr.Actiondropdown), "Action dropdown box not visible");
		waitThread(5000);

		// click on resend invitation button
		click(cr.link_Revokeinvitations);
		waitThread(2000);
		JavaScriptclick(cr.yes_btn);
		waitThread(2000);
		// verify toaster message
		waitFor(cr.toaster);
		Assert.assertEquals(getText(cr.toaster), "Successfully revoked");
		waitThread(3000);
		// verify the revoked student email not visible on the grid
		Assert.assertFalse(isElementPresent(cr.gridvalue_email), "Student Email  present");

		// verify grid label
		Assert.assertEquals(getText(cr.gridtext), "No Student(s) Found.");
		waitThread(3000);

	}

	/*
	 * To verify the Add student button,Verify the labels buttons on the Add
	 * students pop up window
	 */
	@Test(priority = 13)
	public void TCSPR060313() {
		waitThread(1000);
		Assert.assertTrue(isElementPresent(cr.btn_Addstudents), "Add Students button not visible");
		// Assert.assertEquals(getAttribute(cr.Addstudentbtn_tooltip,
		// "ptooltip"), "Invite more students");

		// click on Add students button
		click(cr.btn_Addstudents);

		// verify the pop up visible
		Assert.assertTrue(isElementPresent(cr.Addstudents_window), "Add Students window not visible");
		waitFor(cr.Window_coursename);
		// verify the header course name visible on the popup
		Assert.assertEquals(getText(cr.Window_coursename),
				"Build a list of students to be invited to join the course: " + CourseName.trim());
		Assert.assertEquals(getText(cr.lblWindow_text1),
				"Enter / copy-paste / import Email IDs below to invite students");

		// verify buttons and button labels
		Assert.assertTrue(isElementPresent(cr.importbtn), "Import button not visible");
		Assert.assertEquals(getText(cr.lblWindow_text2), "Import CSV/Text File");

		// verify buttons and button labels
		Assert.assertTrue(isElementPresent(cr.addstud_searchbox), "Searchbox not visible");
		// Assert.assertEquals(getAttribute(cr.addstud_searchbox_txt,
		// "placeholder"), "Search Email");

		// verify buttons and button labels
		Assert.assertTrue(isElementPresent(cr.btn_cancel), "Cancel button not present");
		Assert.assertEquals(getAttribute(cr.btn_cancel, "label"), "Clear");

		// verify buttons and button labels
		Assert.assertTrue(isElementPresent(cr.Addtolist_btn), "Add to list button not visible");
		Assert.assertEquals(getText(cr.Addtolist_btn), "Add to List");

	}

	/*
	 * To check the cancel button functionality on the Add Students to this
	 * Course page
	 */
	@Test(enabled = false)
	public void TCSPR060314() {
		waitThread(2000);
		// click on cancel button
		click(cr.btn_cancel);
		waitThread(2000);

		// verify the Add Students window not visible
		Assert.assertFalse(isElementPresent(cr.btn_cancel), "Add Students window visible");

	}

	/*
	 * To check the close button functionality on the Add Students to the Course
	 * page
	 */
	@Test(priority = 15)
	public void TCSPR060315() {

		waitThread(1000);

		// click on close button
		JavaScriptclick(cr.popup_btn_close);

		waitThread(2000);
		// verify the add students popup not visible
		Assert.assertFalse(isElementPresent(cr.popup_btn_close), "pop up  visible");

	}

	/*
	 * To check the Invite New Students functionality on the pop up window
	 */
	@Test(priority = 16)
	public void TCSPR060316() {

		waitThread(3000);
		// click on Add students button
		click(cr.btn_Addstudents);
		waitFor(cr.chip_1);

		// Type email on chip
		type(cr.chip_1, "test1@gmail.com" + ",");

		// verify the email visible on the chip
		Assert.assertEquals(getText(cr.Emailchip_1), "test1@gmail.com");

	}

	/*
	 * To check the import functionality on the Invite New Students tab using
	 * invalid file
	 */
	@Test(priority = 17)
	public void TCSPR060317() {

		// upload invalid file
		cn.fileupload("TestImage.png");

		waitFor(cn.toasterinvalid);

		// verify toaster message-Invalid file format
		Assert.assertEquals(getText(cn.toasterinvalid), "Invalid file format");
		waitThread(1000);

	}

	/*
	 * To check the import functionality on the Invite New Students tab using
	 * csv file
	 */
	@Test(priority = 18)
	public void TCSPR060318() {

		// import csv
		cn.fileupload("Emailscsv.csv");
		waitThread(3000);

		// verify email present on the textbox
		Assert.assertEquals(getText(cr.Emailchip_2), "student1@gmail.com");

	}

	/*
	 * To check the import functionality on the Invite New Students tab using
	 * textfile
	 */
	@Test(priority = 19)
	public void TCSPR060319() {

		// import text file
		cn.fileupload("Emailtext.txt");
		waitThread(1000);

		// verify email present on the textbox
		Assert.assertEquals(getText(cr.Emailchip_3), "student2@gmail.com");

	}

	/*
	 * To check the search functionality on the Invite New Students tab
	 */
	@Test(priority = 20)
	public void TCSPR060320() {

		// To perform search functionality
		Assert.assertTrue(isElementPresent(cr.gridsearchbox1), "Search box not visible");

		// type Email
		type(cr.gridsearchbox1, "test1@gmail.com");

		// verify email present on the textbox
		Assert.assertEquals(getText(cr.Emailchip_1), "test1@gmail.com");

	}

	/*
	 * To check the Invite Students from my existing courses functionality on
	 * the popup check the headings,labels,text
	 */
	@Test(priority = 21)
	public void TCSPR060321() {

		// verify the tab heading
		Assert.assertEquals(getText(cr.invitetab), "Invite new students");
		waitThread(1000);
		Assert.assertEquals(getText(cr.Addstudentstab), "Invite students from my existing courses");
		waitThread(1000);

		// click on Invite Students from my existing courses tab
		click(cr.Addstudentstab);
		waitThread(4000);

		// Verify the following grid labels
		Assert.assertEquals(getText(cr.gridlbl_Sino), "Sl No:");
		Assert.assertEquals(getText(cr.gridlbl_studentid), "Student ID");
		Assert.assertEquals(getText(cr.gridlbl_firstname), "First Name");
		Assert.assertEquals(getText(cr.gridlbl_lastname), "Last Name");
		Assert.assertEquals(getText(cr.gridlbl_email), "Email ID");
		Assert.assertEquals(getText(cr.gridlbl_nostudfound), "No Student(s) Found.");
	}

	/*
	 * To check the Add to list functionality and preview popup on the Add
	 * students to the course popup window. -Verify the Labels,Textbox
	 */
	@Test(priority = 22)
	public void TCSPR060322() {

		waitThread(2000);
		click(cn.tab_invite);
		waitThread(2000);

		// click on add to list button
		click(cn.tab_btn_Addtolist);
		waitThread(4000);
		// Click on Yes button
		click(cn.delete_yes);
		waitThread(2000);

		// verify the Emails visible on the preview popup
		Assert.assertEquals(getText(cr.preview_Emailchip_1), "test1@gmail.com");
		Assert.assertEquals(getText(cr.preview_Emailchip_2), "student1@gmail.com");
		Assert.assertEquals(getText(cr.preview_Emailchip_3), "student2@gmail.com");

		// verify the buttons and button labels
		Assert.assertTrue(isElementPresent(cr.btn_previewsendrequest), "Send request button not visible");
		Assert.assertEquals(getText(cr.btnlbl_previewsendrequest), "Send Request");

	}

	/*
	 * To check the close button functionality on the preview popup page
	 */
	@Test(priority = 23)
	public void TCSPR060323() {

		waitThread(2000);

		// click on close button
		click(cr.popup_btn_close);
		waitThread(1000);

		// verify the preview pop up window not visible
		Assert.assertFalse(isElementPresent(cr.btn_previewsendrequest), "Add Students preview window visible");
		waitThread(1000);

		// click on Add students button
		click(cr.btn_Addstudents);
		Assert.assertTrue(isElementPresent(cr.Addstudents_window), "Add Students window not visible");

	}

	/*
	 * To check the Invite New Students functionality on the pop up window
	 */
	@Test(priority = 24)
	public void TCSPR060324() {

		// type email and verify email on the chip
		type(cr.chip_1, "test1@gmail.com" + ",");
		Assert.assertEquals(getText(cr.Emailchip_1), "test1@gmail.com");

	}

	/*
	 * To check the import functionality on the Invite New Students tab using
	 * invalid file
	 */
	@Test(priority = 25)
	public void TCSPR060325() {

		// upload invalid file
		cn.fileupload("TestImage.png");

		waitFor(cn.toasterinvalid);

		// verify toaster message-Invalid file format
		Assert.assertEquals(getText(cn.toasterinvalid), "Invalid file format");
		waitThread(1000);
	}

	/*
	 * To check the import functionality on the Invite New Students tab using
	 * csv file
	 */
	@Test(priority = 26)
	public void TCSPR060326() {

		// import csv
		cn.fileupload("Emailscsv.csv");
		waitThread(3000);

		// verify email present on the textbox
		Assert.assertEquals(getText(cr.Emailchip_2), "student1@gmail.com");

	}

	/*
	 * To check the import functionality on the Invite New Students tab using
	 * textfile
	 */
	@Test(priority = 27)
	public void TCSPR060327() {
		// import text file
		cn.fileupload("Emailtext.txt");
		waitThread(3000);

		// verify email present on the textbox
		Assert.assertEquals(getText(cr.Emailchip_3), "student2@gmail.com");

	}

	/*
	 * To check the Add more students functionality on the preview page
	 */
	@Test(priority = 28)
	public void TCSPR060328() {

		// click on add to list button
		click(cn.tab_btn_Addtolist);
		waitThread(4000);
		// Click on Yes button
		click(cn.delete_yes);
		waitThread(2000);

		// verify the Emails visible on the grid
		Assert.assertEquals(getText(cr.preview_Emailchip_1), "test1@gmail.com");
		waitThread(1000);
		Assert.assertEquals(getText(cr.preview_Emailchip_2), "student1@gmail.com");
		waitThread(1000);
		Assert.assertEquals(getText(cr.preview_Emailchip_3), "student2@gmail.com");

		// click on invite tab button
		click(cn.tab_invite);
		waitThread(2000);

		// type email and verify the email visible on the text box
		type(cr.chip_1, "test2@gmail.com" + ",");
		waitThread(2000);
		// Assert.assertEquals(getText(cr.Emailchip_1), "test2@gmail.com");
		// cr.Emailchip_1
		// click on Add to list button
		click(cr.Addtolist_btn);
		waitThread(2000);
		// Click on Yes button
		click(cn.delete_yes);
		waitThread(2000);
		// waitFor(cr.preview_Emailchip_1);

		// verify the newly added email visible on the grid
		// Assert.assertEquals(getText(cr.preview_Emailchip_1),
		// "test2@gmail.com");

	}

	/*
	 * To check the Send Request functionality on the course roster preview page
	 */
	@Test(priority = 29)
	public void TCSPR060329() {
		waitThread(1000);
		// click on Send request button
		click(cr.btn_previewsendrequest);

		waitFor(cr.toaster);

		// verify toaster message
		Assert.assertEquals(getText(cr.toaster), "Successfully sent email(s)");
		waitThread(4000);
	}

	/*
	 * To check the Send Request functionality on the course roster preview page
	 */
	@Test(priority = 30)
	public void TCSPR060330() {

		// click on enrolled radio button
		click(cr.radiobtn_enrolled);
		// click on invited students radio button
		click(cr.radiobtn_invited);
		// To take the row count[email count on the grid]
		List<WebElement> totalLinks = driver.findElements(By.xpath(cr.rowcountinvite));
		int totalLinkSize = totalLinks.size();
		waitThread(4000);
		// verify the email count on the grid
		Assert.assertEquals(TotalElementsCount(cr.rowcountinvite), 4);

		waitThread(2000);
		// verify the Emails on the grid
		Assert.assertEquals(getText(cr.grid_email_1), "test1@gmail.com");
		// Assert.assertEquals(getText(cr.grid_email_2), "student2@gmail.com");
		// Assert.assertEquals(getText(cr.grid_email_3), "test1@gmail.com");
		// Assert.assertEquals(getText(cr.grid_email_4), "student1@gmail.com");
		waitThread(3000);

		// Verify the invited date with system date
		Assert.assertEquals(getText(cr.grid_date_1), cr.getdate());
		// Assert.assertEquals(getText(cr.grid_date_2), cr.getdate());
		// Assert.assertEquals(getText(cr.grid_date_3), cr.getdate());
		// Assert.assertEquals(getText(cr.grid_date_4), cr.getdate());

		// Grid label;-NO ACCOUNT
		Assert.assertEquals(getText(cr.grid_label_1), "NO ACCOUNT");
		// Assert.assertEquals(getText(cr.grid_label_2), "NOT ACCEPTED");
		// Assert.assertEquals(getText(cr.grid_label_3), "NO ACCOUNT");
		// Assert.assertEquals(getText(cr.grid_label_4), "NO ACCOUNT");

		// To check the Student id,firstname,lastname not visible
		waitThread(4000);
		Assert.assertEquals(getText("//*[@id='p-tableGrid']/div/div[1]/table/tbody/tr/td[3]/div"), "");
		Assert.assertEquals(getText("//*[@id='p-tableGrid']/div/div[1]/table/tbody/tr/td[4]/div"), "");
		Assert.assertEquals(getText("//*[@id='p-tableGrid']/div/div[1]/table/tbody/tr/td[5]/div"), "");

	}

	/*
	 * To check the filter option on the Invited & Not Accepted
	 */

	@Test(priority = 31)
	public void TCSPR060331() {
		click(cr.btn_filter);
		waitThread(2000);

		// verify the filter pop up visible
		Assert.assertTrue(isElementPresent(cr.filter_popup), "Filter pop up not visible");
		Assert.assertTrue(isElementPresent(cr.all_dropdown), "All dropdown not visible");

		// verify dropdown label All
		Assert.assertEquals(getAttribute(cr.all_dropdown, "placeholder"), "All");

		// click dropdown
		click(cr.all_dropdown);
		waitThread(2000);
		waitFor(cr.filter_lblNoaccount);
		waitThread(2000);
		// verify dropdown labels
		Assert.assertEquals(getText(cr.filter_lblNoaccount), "No Account");
		waitFor(cr.filter_lblnotaccept);
		Assert.assertEquals(getText(cr.filter_lblnotaccept), "Not Accepted");
		// waitFor(cr.filter_lbldeclined);
		// Assert.assertEquals(getText(cr.filter_lbldeclined), "Declined");
		// waitFor(cr.chkbx_noaccount);
		// verify the No Account check box visible
		Assert.assertTrue(isElementPresent(cr.chkbx_noaccount), "No Account checkbox not visible");
		waitFor(cr.chkbx_lblnotaccept);

		// verify the Not Accept check box visible
		Assert.assertTrue(isElementPresent(cr.chkbx_lblnotaccept), "Not Accept check box not visible");
		// waitFor(cr.chkbx_lbldeclined);

		// verify the Declined check box
		// Assert.assertTrue(isElementPresent(cr.chkbx_lbldeclined), "Declined
		// check box not visible");

		// Click on No Account checkbox

		check(cr.chkbx_noaccount);
		waitThread(2000);
		// *Assert the no account checkbox is checked
		Assert.assertTrue(isElementPresent(cr.chkbx_noaccount), "No Account check box not selected");

		// Click on the filter button

		click(cr.btn_filter);
		waitThread(2000);

		// verify the filter popup not visible
		Assert.assertFalse(isElementPresent(cr.filter_lblNoaccount), "Filter pop up  visible");
		waitThread(1000);
		// Assert text 'No Account' on the grid
		Assert.assertEquals(getText(cr.grid_label_1), "NO ACCOUNT");

		// click on filter button
		click(cr.btn_filter);
		waitThread(2000);
		// verify the filter popup visible
		Assert.assertTrue(isElementPresent(cr.filter_popup), "Filter pop up not visible");
		waitThread(2000);
		click(cr.noaccount_dropdown);
		// Untick No Account checkbox

		click(cr.chkbx_noaccount);
		waitThread(3000);
		// *Assert the checkbox is not checked
		Assert.assertTrue(isElementPresent(cr.chkbx_noacc2), "No Account checbox is selected");

		waitThread(2000);
		// "Click on Not Accepted checkbox

		click(cr.not_accepted);
		waitThread(3000);

		// *Assert the Not Accepted check box is checked

		Assert.assertTrue(getAttribute(cr.not_accepted, "class").contains("p-checkbox-box p-highlight"));

		// Click on the filter button

		click(cr.btn_filter);

		// *Assert a dropdown(filter popup) not visible

		Assert.assertTrue(isElementPresent(cr.filter_popup), "Filter pop up not visible");
		// Click on the filter button
		click(cr.btn_filter);
		// *Assert a dropdown(filter popup) visible
		Assert.assertTrue(isElementPresent(cr.filter_popup), "Filter pop up not visible");

		click(cr.noaccount_dropdown);
		// "Untick Not Accepted checkbox"

		click(cr.not_accepted);
		waitThread(3000);
		// *Assert the checkbox is not checked

		Assert.assertFalse(
				getAttribute(cr.not_accepted_chkbox, "class").contains("p-multiselect-item p-ripple p-highlight"));

	}

	/*
	 * To check the Enrolled functionality on the page
	 */
	@Test(priority = 32)
	public void TCSPR06032() {

		// click on enrolled radio button
		waitFor(cr.radiobtn_enrolled);
		click(cr.radiobtn_enrolled);

		// verify the radio button is selected
		Assert.assertTrue(isSelected(cr.check_radiobtn_enrolled), "Enrolled radio button is not checked");

		// verify the grid labels
		Assert.assertEquals(getText(cr.lbl_Sino), "Sl No:");
		Assert.assertEquals(getText(cr.lbl_StudentID), "Student ID");
		Assert.assertEquals(getText(cr.lbl_Firstname), "First Name");
		Assert.assertEquals(getText(cr.lbl_lastname), "Last Name");
		Assert.assertEquals(getText(cr.lbl_Emailid), "Email ID");
		Assert.assertEquals(getText(cr.lbl_Enrolledvia), "Enrolled Date");
		Assert.assertEquals(getText(cr.gridtext), "No Student(s) Found.");

	}

	/*
	 * To check the Suspended functionality on the page
	 */
	@Test(priority = 33)
	public void TCSPR06033() {

		// click on suspended radio button
		click(cr.radiobtn__suspended);

		// verify the suspended radio button is selected
		Assert.assertTrue(isSelected(cr.radiobtn_suspended), "Enrolled radio button is not checked");

		// verify the grid labels
		Assert.assertEquals(getText(cr.lbl_Sino), "Sl No:");
		Assert.assertEquals(getText(cr.lbl_StudentID), "Student ID");
		Assert.assertEquals(getText(cr.lbl_Firstname), "First Name");
		Assert.assertEquals(getText(cr.lbl_lastname), "Last Name");
		Assert.assertEquals(getText(cr.lbl_Emailid), "Email ID");
		Assert.assertEquals(getText(cr.lbl_Enrolledvia), "Suspended Date");
		Assert.assertEquals(getText(cr.gridtext), "No Student(s) Found.");

	}

	/*
	 * To check the back button functionality
	 */

	@Test(priority = 34)
	public void TCSPR06034() {

		// click on back to course button
		click(cr.btn_backtocourse);

		// verify heading courses
		Assert.assertEquals(getText(lg.pagetitle3), "Courses");
	}

	/*
	 * To perform delete functionality
	 */
	@Test(priority = 35)
	public void TCSPR060335() {

		// To perform delete account functionality
		cr.DeleteAccount();

		// To login with deleted account credentials
		lg.login(EmailTeacher, "Abc@123");

		waitFor(lg.validationmsg3);
		// verify toaster text
		Assert.assertEquals(getText(lg.validationmsg3), "Enter a valid email address and password");
	}

}
