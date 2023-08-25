package com.Home.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Home.Pages.LandingPage;

import Login.Pages.LoginPage;
import SPRautomation.StudentPeerReview.basePage;
import SignUp.Pages.SignUpPage;

public class LandingpageTest extends basePage {

	LandingPage lp = new LandingPage();
	LoginPage lg = new LoginPage();
	SignUpPage sp = new SignUpPage();

	@Test(priority = 1)
	public void TCSPR010001() {
		// Verify the header text
		Assert.assertEquals(getTitle(), "Student Peer Review");

	}

	@Test(priority = 2)
	public void TCSPR010002() {
		Assert.assertEquals(getText(lp.PageTitle), "Welcome to Student Peer Review");
	}

	@Test(priority = 3)
	public void TCSPR010003() {
		Assert.assertEquals(getText(lp.sectionTitle),
				"Have your students learn by reviewing and scoring their fellow students");
	}

	@Test(priority = 4)
	public void TCSPR010004() {
		Assert.assertEquals(getText(lp.labels1),
				"No Account Yet? No Problem!\n" + "Just click on one of the buttons at the bottom left letting\n"
						+ "us know if you are a Teacher or Student.");

	}

	@Test(priority = 5)
	public void TCSPR010005() {

		// To verify the login button
		Assert.assertTrue(isElementPresent(lg.LoginBtn_1), "Login button not present");

	}

	@Test(priority = 6)
	public void TCSPR010006() {

		// verify labels
		Assert.assertEquals(getText(lp.labels2),
				"Have your students learn by reviewing and scoring their fellow students");

	}

	@Test(priority = 7)
	public void TCSPR010007() {

		// To verify the I am a teacher button
		Assert.assertTrue(isElementPresent(sp.btn_1), "I am a Teacher button not present");

		// Button Label-I'm a Teacher
		Assert.assertEquals(getText(sp.btn_1lbl), "I'm a Teacher");

	}

	@Test(priority = 8)
	public void TCSPR010008() {

		waitThread(2000);
		// To verify the I am a student button
		Assert.assertTrue(isElementPresent(lp.btnstudent), "I am a Student button not present");

		// To verify the button label
		Assert.assertEquals(getAttribute(lp.btnstudent, "label"), "I'm a Student");

	}

	@Test(priority = 9)
	public void TCSPR010010() {

		// verify labels
		Assert.assertEquals(getText(lp.labels3), "I would like to try Student Peer\n" + "Review free for one Course");
		Assert.assertEquals(getText(lp.labels4), "Please sign me up with no cost\n" + "as a student");

	}

}
