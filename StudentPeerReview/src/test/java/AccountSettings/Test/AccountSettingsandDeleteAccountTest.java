package AccountSettings.Test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Generalmethods.Databaseconnection;

import AccountSettings.Pages.AccountSettingsandDeleteAccountPage;
import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Test.SignUpTest;
import StudentLogin.Pages.AddStudentFromMyStudentListPage;

public class AccountSettingsandDeleteAccountTest extends basePage {

	AccountSettingsandDeleteAccountPage as = new AccountSettingsandDeleteAccountPage();
	AddStudentFromMyStudentListPage adds = new AddStudentFromMyStudentListPage();
	Databaseconnection dc = new Databaseconnection();
	LoginPage lg = new LoginPage();
	SignUpTest st = new SignUpTest();

	public String Teacher_firstname;
	public String Teacher_lastname;
	public String Teacher_fullname;
	public String Password;
	public String EmailTeacher;
	public String Email;
	public String otp;

	/*
	 * Sign Up as Teacher
	 */
	@Test(priority = 1)
	public void TCSPR070001() throws SQLException {

		Teacher_firstname = "Test";
		Teacher_lastname = "Teacher";
		Teacher_fullname = Teacher_firstname + " " + Teacher_lastname;
		Password = "Abc@123";

		// Assert the heading label "Welcome to Student Peer Review"
		Assert.assertEquals(getText(adds.wel_label), "Welcome to Student Peer Review");
		// Click on I'm a Teacher button
		click(adds.teach_btn);
		EmailTeacher = st.TCSPR020005();
		st.TCSPR020006();
		// Assert the heading label "Courses"
		Assert.assertEquals(getText(adds.courses_label), "Courses");

	}

	/*
	 * To check the Account Settings link present in the navigation dropdown
	 */
	@Test(priority = 2)
	public void TCSPR070002() {

		// Assert the teachername on the navigation menu
		Assert.assertEquals(getText(as.nav_drop1), "Test Teacher");

		// click navigation dropdown
		click(as.nav_drop1);

		// Assert the account setting button
		Assert.assertTrue(isElementPresent(as.accnt_sett1), "account settings button not present");

		// click account settings button
		click(as.accnt_sett1);

		// Assert the label Account Settings in accountsettings Page
		Assert.assertEquals(getText(as.hd_label5), "Account Settings");

	}

	/*
	 * To check the Labels in the Account Settings Page
	 */
	@Test(priority = 3)
	public void TCSPR070003() {

		waitThread(2000);
		// Assert the label Teacher ID:
		Assert.assertTrue(isElementPresent(as.hd_label6), "Teacher ID not present");
		Assert.assertTrue(getText(as.hd_label6).contains("Teacher ID : "));
		// Assert the label firstname
		Assert.assertEquals(getText(as.hd_label7), "First Name");
		// Assert the label Lastname
		Assert.assertEquals(getText(as.hd_label8), "Last Name");

	}

	/*
	 * To check the Text Boxes and Buttons on the Account Settings Page
	 */
	@Test(priority = 4)
	public void TCSPR070004() {
		// Assert firstname textbox On accountsettings page
		Assert.assertTrue(isElementPresent(as.frstnam_txt6), "First name textbox is not present");
		// Assert lastname textbox On accountsettings page
		Assert.assertTrue(isElementPresent(as.lstnam_txt7), "Last name text box is not present");
		// Assert Edit button
		Assert.assertTrue(isElementPresent(as.edit_button3), "Edit button is not present");
		// Assert Delete button
		Assert.assertTrue(isElementPresent(as.delete_button4), "Delete button is not present");

	}

	/*
	 * To check the First Name And Last Name in the text boxes. -To check the
	 * First Name same as we added on the Sign Up page -To check the Last Name
	 * same as we added on the Sign Up page
	 */
	@Test(priority = 5)
	public void TCSPR070005() {

		// Assert the Firstname
		Assert.assertEquals(getValue(as.frstnam_txt6), "Test");
		// Assert the Lastname
		Assert.assertEquals(getValue(as.lstnam_txt7), "Teacher");

	}

	/*
	 * To check the visibility of "Save" and "Cancel" Button on the Account
	 * Settings Page
	 */
	@Test(priority = 6)
	public void TCSPR070006() {
		// click edit button on Account Settings page
		click(as.edit_button3);
		// Assert save and cancel button visible
		Assert.assertTrue(isElementPresent(as.save_button5), "Save button is not present");
		Assert.assertTrue(isElementPresent(as.cancel_button6), "Cancel button is not present");

		// Assert save and cancel labels
		Assert.assertEquals(getText(as.hd_label9), "Save");
		Assert.assertEquals(getText(as.hd_label10), "Cancel");

	}

	/*
	 * To check the Required field validation messages on the Account Settings
	 * Page
	 */
	@Test(priority = 7)
	public void TCSPR070007() {

		click(as.frstnam_txt6);

		// clear the firstname in firstname textbox
		driver.findElement(By.xpath(as.frstnam_txt6)).clear();

		type(as.frstnam_txt6, "S");
		driver.findElement(By.xpath(as.frstnam_txt6)).sendKeys(Keys.BACK_SPACE);

		// Assert the validation message "First Name is required"
		Assert.assertEquals(getText(as.valid_msg1), "First Name is required");

		click(as.lstnam_txt7);
		// clear the last
		driver.findElement(By.xpath(as.lstnam_txt7)).clear();
		type(as.lstnam_txt7, "d");

		driver.findElement(By.xpath(as.lstnam_txt7)).sendKeys(Keys.BACK_SPACE);

		// Assert the validation message "Last Name is Required"
		Assert.assertEquals(getText(as.valid_msg2), "Last Name is required");

		// check save button is disable
		Assert.assertFalse(isEnabled(as.save_button5), "Save button is disabled");

	}

	/*
	 * To check the First Name with less than Lower Limit and verify the
	 * validation message on the Account Settings Page
	 */
	@Test(priority = 8)
	public void TCSPR070008() {
		// type first name less than 2 characters
		type(as.frstnam_txt6, "A");
		// Assert the validation message "First Name must be at least 2
		// characters."
		Assert.assertEquals(getText(as.valid_msg3), "First Name must be at least 2 letters");
		// Assert Save button is disabled
		Assert.assertFalse(isEnabled(as.save_button5), "Save button is disabled");

	}

	/*
	 * To check the First Name and Last Name with more that Upper Limit and
	 * verify the validation message on the Account Settings Page
	 */
	@Test(priority = 9)
	public void TCSPR070009() {
		driver.findElement(By.xpath(as.frstnam_txt6)).clear();
		// type first name more than limit
		type(as.frstnam_txt6, "testing testing testing");
		// Assert the Validation message "First Name must be maximum 20
		// characters"
		Assert.assertEquals(getText(as.valid_msg4), "First Name must be maximum 20 characters");
		// type last name more than limit
		type(as.lstnam_txt7, "testing testing testing");
		// Assert the Validation message "
		Assert.assertEquals(getText(as.valid_msg5), "Last Name must be maximum 20 characters");
		// Assert Save button is disabled
		Assert.assertFalse(isEnabled(as.save_button5), "Save button is disabled");

	}

	/*
	 * To check the functionality of Cancel Button on the Account Settings Page
	 */
	@Test(priority = 10)
	public void TCSPR070010() {
		// click on cancel button
		click(as.cancel_button6);

		// Assert the first name and last name as added in the signup page
		Assert.assertEquals(getValue(as.frstnam_txt6), "Test");
		Assert.assertEquals(getValue(as.lstnam_txt7), "Teacher");

		// Assert Save button is not visible
		Assert.assertFalse(isElementPresent(as.save_button5), "Save button is not Present");
		// Assert Cancel button is not visible
		Assert.assertFalse(isElementPresent(as.cancel_button6), "Cancel button is not Present");

	}

	/*
	 * To check the Edit functionality on the Account Settings page working
	 * proper on the Account Settings Page
	 */
	@Test(priority = 11)
	public void TCSPR070011() {

		// click on edit button
		click(as.edit_button3);
		// click firstname textbox, clear the data
		click(as.frstnam_txt6);
		driver.findElement(By.xpath(as.frstnam_txt6)).clear();
		// Enter the first name
		type(as.frstnam_txt6, "Mary");

		// click lastname textbox and clear the data
		click(as.lstnam_txt7);
		driver.findElement(By.xpath(as.lstnam_txt7)).clear();
		// Enter the last name
		type(as.lstnam_txt7, "Teacher");

		// Assert firstname and lastname
		Assert.assertEquals(getValue(as.frstnam_txt6), "Mary");
		Assert.assertEquals(getValue(as.lstnam_txt7), "Teacher");

		// click Save button
		click(as.save_button5);
		waitFor(as.tost_1);
		// Assert the successful toaster message "Successfully updated"visible
		// in the
		// page
		Assert.assertEquals(getText(as.tost_1), "Successfully updated");

	}

	/*
	 * To check the First Name and Second Name After Perform Edit Functionality
	 * on the Account Settings Page
	 */
	@Test(priority = 12)
	public void TCSPR070012() {
		// Assert the newly added firstname and lastname visible
		Assert.assertEquals(getValue(as.frstnam_txt6), "Mary");
		Assert.assertEquals(getValue(as.lstnam_txt7), "Teacher");
		waitThread(2000);

		// Assert the navigation menu name visible
		Assert.assertEquals(getText(as.nav_drop1), "Mary Teacher");

	}

	/*
	 * To check the delete functionality on the Account Settings Page
	 */
	@Test(priority = 13)
	public void TCSPR070013() {

		// click delete account button
		click(as.delete_button4);
		// Assert the confirmation box
		Assert.assertTrue(isElementPresent(as.popbox_1), "Confirmation popup not visible");

	}

	/*
	 * To check the labels,text,buttons in the delete confirmation pop up on the
	 * Account Settings Page
	 */
	@Test(priority = 14)
	public void TCSPR070014() {

		waitFor(as.alrt_label1);
		// Assert Confirmation label
		Assert.assertEquals(getText(as.alrt_label1), "Account Deletion: "+EmailTeacher);
		// Assert "Are you sure that you want to delete this account?" label
		Assert.assertEquals(getText(as.alrt_label2), "Are you sure that you want to permanently delete this account?");
		// Assert No button
		Assert.assertTrue(isElementPresent(as.alrt_nobutton), "No button is not present");
		// Assert Yes button
		Assert.assertTrue(isElementPresent(as.alrt_yesbutton), "yes button is not Present");

	}

	/*
	 * To check the functionality of No Button on the Conformation popup
	 */
	@Test(priority = 15)
	public void TCSPR070015() {

		waitFor(as.alrt_nobutton);
		// click No button in popup
		click(as.alrt_nobutton);
		// Assert confirmation popup not visible
		Assert.assertTrue(isElementPresent(as.popbox_1), "Confirmation popup not visible");

	}

	/*
	 * To check the delete functionality by clicking Yes button on the
	 * confirmation popup
	 */
	@Test(priority = 16)
	public void TCSPR070016() {

		// click delete Account button
		click(as.delete_button4);
		// Assert Confirmation Popup is Visible
		Assert.assertTrue(isElementPresent(as.popbox_1), "Confirmation popup not visible");
		// click Yes button on Confirmation Popup
		click(as.alrt_yesbutton);

	}

	/*
	 * Perform Login using deleted account credetails
	 */
	@Test(priority = 17)
	public void TCSPR070017() {

		lg.login(EmailTeacher, "123456");
		waitFor(as.tost_1);
		// Assert invalid toaster message
		Assert.assertEquals(getText(as.tost_1), "Enter a valid email address and password");

	}

}
