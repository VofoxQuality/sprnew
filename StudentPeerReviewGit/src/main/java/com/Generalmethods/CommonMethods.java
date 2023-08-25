package com.Generalmethods;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Course.Pages.CreateNewCoursePage;
import CreateNewAssessment.Pages.QuestionPageBasicsPage;
import NewAssessmentOfTeacherPage.TeacherPeerReviewSectionPage;
import NewAssessmentOfTeacherPage.TeacherResultSectionPage;
import NewAssessmentOfTeacherPage.TeacherTestSectionPage;
import SPRautomation.StudentPeerReview.basePage;

public class CommonMethods extends basePage {

	TeacherTestSectionPage tts = new TeacherTestSectionPage();
	TeacherPeerReviewSectionPage tp = new TeacherPeerReviewSectionPage();
	TeacherResultSectionPage tr = new TeacherResultSectionPage();
	private static final int TIMEOUT = 20000;
	public String emailteacher = "teacherone@gmail.com";
	public String Password = "Abc@123";
	public String emailstudent1 = "student1@gmail.com";
	public String emailstudent2 = "student2@gmail.com";
	public String emailstudent3 = "student3@gmail.com";
	public String emailstudent4 = "student4@gmail.com";
	public String CourseName1 = "Course Name One";
	public String CourseID1 = "C10092";
	public String CourseName2 = "Course Name Two";
	public String CourseID2 = "C10093";
	public String CourseName3 = "Course Name Three";
	public String CourseID3 = "C10094";
	// Image URL
	public String ImageURL = "http://192.168.7.108/SPRAPIQA/Files/Assessment/61ecf7f78f4de687f00166dc/f7c2d6bc-f573-42a6-9cd9-e95de13822e9.png";
	// Video URL
	public String VideoURL = "http://192.168.7.108/SPRAPIQA/Files/Assessment/619dbeddc0429e0d15787b5f/86d56375-b977-4156-a2e5-10a5c9f1812d.mp4";
	// URL
	public String URL = "https://en.wikipedia.org/wiki/Organic_chemistry";

	// Place holders
	public String Email_txt = "//input[@id='email']";
	public String Pass_txt = "//input[@id='password']";
	// Buttons
	public String LoginBtn_1 = "//p-button[@label='Login']";
	public String LoginBtn_2 = "//button[@id='submit']";
	private String rewardscore;

	/*
	 * To perform Login
	 */

	public void login(String Emaildata, String Passworddata) {

		// fill the Email
		type(Email_txt, Emaildata);
		// fill password
		type(Pass_txt, Passworddata);
		// click login button
		click(LoginBtn_2);

	}

	/*
	 * To perform Logout functionality
	 */

	public void Logout() {

		waitThread(1000);
		driver.findElement(By.xpath("//div[@class='username']")).click();
		waitThread(1000);
		driver.findElement(By.xpath("//i[@class='pi pi-sign-out']")).click();
	}

	/*
	 * To perform delete account functionality
	 */
	public void DeleteAccount() {

		waitThread(2000);
		driver.findElement(By.xpath("//div[@class='username']")).click();
		waitThread(1000);
		driver.findElement(By.xpath("//i[@class='fas fa-user-circle']")).click();
		waitThread(1000);
		driver.findElement(By.xpath("//button[@id='delete']")).click();
		waitThread(1000);
		driver.findElement(By.cssSelector("button.p-confirm-dialog-accept")).click();
		waitThread(3000);

	}

	/*
	 * Method to get system time
	 * 
	 */

	public String gettime() {

		DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}

	/*
	 * Method to get system date
	 */

	public String getdate() {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

	/*
	 * Integer to String Conversion
	 */
	public String InttoString(int value) {

		String InttoString_value = Integer.toString(value);
		return InttoString_value;
	}

	/*
	 * String to Integer Conversion
	 */
	public int StringtoInt(String value) {

		int StringtoInt_value = Integer.parseInt(value);
		return StringtoInt_value;

	}

	/*
	 * Float to String Conversion
	 */
	public String floattostring(float value) {

		String floattostring_value = Float.toString(value);
		return floattostring_value;
	}

	/*
	 * String to float conversion
	 */
	public float Stringtofloat(String value) {

		float Stringtofloat_value = Float.parseFloat(value);
		return Stringtofloat_value;

	}
	/*
	 * Integer to Float conversion
	 */

	public float Inttofloat(int value) {

		float Inttofloat_value = (float) (value);
		return Inttofloat_value;

	}

	/*
	 * Float to Integer conversion
	 */
	public int FloattoInt(float value) {
		int FloattoInt_value = Math.round(value);
		return FloattoInt_value;

	}

	/*
	 * Method For selecting Today's date
	 */

	public void ClickTodaysDate() {

		Calendar cal = Calendar.getInstance();
		int monthNumber2 = cal.get(Calendar.MONTH);
		int monthNumber = monthNumber2 + 1;
		String monthname = Month.of(monthNumber).name();
		waitThread(2000);
		String Dropmonth = DropselectedValue("select.p-datepicker-month.ng-star-inserted");

		if (monthname.equals(Dropmonth.toUpperCase())) {

			click("//span[contains(text(),'Su')]");
			click("//span[contains(text(),'Mo')]");
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			WebElement element = driver.findElement(By.cssSelector("td.p-datepicker-today"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
			waitThread(3000);
			Doubleclick("//td[contains(@class,'p-datepicker-today')]");
			waitThread(3000);

		} else {

			click("button.p-datepicker-prev.p-link.p-ripple.ng-star-inserted > span");
			waitThread(3000);
			WebElement element = driver.findElement(By.cssSelector("td.p-datepicker-today>span"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
			waitThread(4000);
			Doubleclick("//td[contains(@class,'p-datepicker-today')]");
			waitThread(1000);
		}
	}

	/*
	 * Method For selecting Today's date-Peer Review Section
	 */

	public void ClickTodaysDate_PeerReview() {

		waitThread(1000);
		Calendar cal = Calendar.getInstance();
		int monthNumber2 = cal.get(Calendar.MONTH);
		int Day = cal.get(Calendar.DAY_OF_MONTH);
		int monthNumber = monthNumber2 + 1;
		String monthname = Month.of(monthNumber).name();
		waitThread(2000);
		String Dropmonth = DropselectedValue("select.p-datepicker-month.ng-star-inserted");

		if (monthname.equals(Dropmonth.toUpperCase())) {

			if (Day < 15) {

				Doubleclick("//td[contains(@class,'p-datepicker-today')]");
				waitThread(4000);
			} else {
				click("//span[contains(text(),'Su')]");
				click("//span[contains(text(),'Mo')]");
				Actions action = new Actions(driver);
				action.sendKeys(Keys.PAGE_DOWN).build().perform();
				// action.sendKeys(Keys.PAGE_DOWN).build().perform();
				waitThread(2000);
				Doubleclick("//td[contains(@class,'p-datepicker-today')]");
				waitThread(4000);

			}
		} else {

			click("button.p-datepicker-prev.p-link.p-ripple.ng-star-inserted > span");
			waitThread(3000);
			click("//span[contains(text(),'Su')]");
			click("//span[contains(text(),'Mo')]");
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			// action.sendKeys(Keys.PAGE_DOWN).build().perform();
			waitThread(4000);
			Doubleclick("//td[contains(@class,'p-datepicker-today')]");
			waitThread(4000);
		}

	}

	// Wait for enable the element
	public void waitForEnable(String locator) {
		try {
			new WebDriverWait(driver, (TIMEOUT / 4000), 90000)
					.until(ExpectedConditions.elementToBeClickable(parseLocator(locator)));
		} catch (TimeoutException e) { // from org.openqa.selenium.TimeoutException
			throw new AssertionError("Timeout during waiting for element: '" + locator + "'");
		}
	}

	public void WaitforbuttonEnable() {

		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@id='studentAssessmentDataView']//div[1]/button/span[2]")));
	}

	public void WaitforbuttonEnable1() {

		WebDriverWait wait2 = new WebDriverWait(driver, 1000);
		wait2.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@id='studentAssessmentDataView']//div[1]/button/span[2]")));
	}

	/*
	 * To find the reward percentage
	 */
	public String getrewardscoreforquestion(String Score, String rewardscore) {

		float RP = Float.parseFloat(rewardscore);

		// To calculate Reward Score for Question 1
		try {
			// convert String max score value to float
			float RSQ = Float.parseFloat(Score);
			// Multiply max score with reward percentage and calculate
			// percentage
			float QRSP = (float) (RSQ * RP);
			float QRSP1 = QRSP / 100;
			// Converting reward score percent to Int
			int Q1RSP2 = (int) Math.round(QRSP1);
			// Converting reward score percent to String
			// Reward Score for Question
			rewardscore = Integer.toString(Q1RSP2);

		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
		return rewardscore;
	}

	/*
	 * To select TomorrowDate
	 */
	public void ClicktomorrowDate() {

		Calendar cal = Calendar.getInstance();
		int Day = cal.get(Calendar.DAY_OF_MONTH);
		waitThread(4000);

		if (Day <= 27) {

			WebElement element2 = driver.findElement(By.cssSelector("td.p-datepicker-today"));
			//WebElement element2 = driver.findElement(By.cssSelector("td.ng-tns-c92-49.p-datepicker-today"));
			
			Actions builder2 = new Actions(driver);
			builder2.moveToElement(element2).perform();
			Doubleclick("//td[contains(@class,'p-datepicker-today')]//following::td[1]//span");
			waitThread(3000);
		}

		else if (Day > 27) {
			

			WebElement element = driver.findElement(By.cssSelector("td.p-datepicker-today"));
		
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
			String Nextday = getAttribute("//td[contains(@class,'p-datepicker-today')]//following::td[1]", "class");

			if (Nextday.contains("p-datepicker-other-month")) {

				WebElement element1 = driver.findElement(By.cssSelector("button.p-datepicker-next"));
				Actions builder1 = new Actions(driver);
				builder1.moveToElement(element1).perform();
				click("button.p-datepicker-next");
				waitThread(5000);
				Doubleclick("//span[@tabindex='0']");
				waitThread(2000);

			}

			else {

				Doubleclick("//td[contains(@class,'p-datepicker-today')]//following::td[1]");
				waitThread(3000);

			}
		}

	}

	/*
	 * To compare date&time in card with scheduled date&time
	 */

	public String getdate(String locator) {

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("MMM d, yyyy, h:mm XM");
		String predate = getText(locator);
		// .substring(num1, num2);
		LocalDate date2 = LocalDate.parse(predate, dt);
		DateTimeFormatter dtt = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:MM XM");
		return dtt.format(date2);
	}

	public String getdates(String date) {

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("MMM d,yyyy");
		String predate = date;
		LocalDate date2 = LocalDate.parse(predate, dt);
		DateTimeFormatter dtt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return dtt.format(date2);
	}

	public String timetestopen;
	public String datetestopen;
	public String timetestdue;
	public String datetestdue;
	public String timereviewopen;
	public String datereviewopen;
	public String timereviewdue;
	public String datereviewdue;
	public String resultdate;
	public String resultime;

	public void datetimesplitmethod() {

		// Testopen date & time

		String[] arrOfStr = getText(tts.testopendatetime).split(" ");
		waitThread(2000);
		String month = arrOfStr[arrOfStr.length - 5];
		String d = arrOfStr[arrOfStr.length - 4];
		String y = arrOfStr[arrOfStr.length - 3];
		String year = y.substring(0, 4);

		String time1 = arrOfStr[arrOfStr.length - 2];
		String timeampm = arrOfStr[arrOfStr.length - 1];

		datetestopen = month + " " + d + year;

		String[] arrOfStrtime = time1.split(":");
		String hour = arrOfStrtime[arrOfStrtime.length - 2];
		String min = arrOfStrtime[arrOfStrtime.length - 1];

		String hour0;

		int l = hour.length();
		if (l == 1) {
			hour0 = "0" + hour;
		} else {
			hour0 = hour;
		}

		timetestopen = hour0 + ":" + min + " " + timeampm;

		// Test due date & time

		String[] arrOfStr1 = getText(tts.testduedatetime).split(" ");
		waitThread(2000);
		String month1 = arrOfStr1[arrOfStr1.length - 5];
		String d1 = arrOfStr1[arrOfStr1.length - 4];
		String y1 = arrOfStr1[arrOfStr1.length - 3];
		String year1 = y1.substring(0, 4);

		String time11 = arrOfStr1[arrOfStr1.length - 2];
		String timeampm1 = arrOfStr1[arrOfStr1.length - 1];

		datetestdue = month1 + " " + d1 + year1;

		String[] arrOfStrtime1 = time11.split(":");
		String hourtestdue = arrOfStrtime1[arrOfStrtime1.length - 2];
		String min1 = arrOfStrtime1[arrOfStrtime1.length - 1];

		String hr1;

		int l1 = hourtestdue.length();
		if (l1 == 1) {
			hr1 = "0" + hourtestdue;
		} else {
			hr1 = hourtestdue;
		}

		timetestdue = hr1 + ":" + min1 + " " + timeampm1;

		// Peer review Open date& time

		String[] arrOfStr2 = getText(tp.peeropen_lbl).split(" ");
		waitThread(2000);
		String month2 = arrOfStr2[arrOfStr2.length - 5];
		String d2 = arrOfStr2[arrOfStr2.length - 4];
		String y2 = arrOfStr2[arrOfStr2.length - 3];
		String year2 = y2.substring(0, 4);

		String time2 = arrOfStr2[arrOfStr2.length - 2];
		String timeampm2 = arrOfStr2[arrOfStr2.length - 1];

		datereviewopen = month2 + " " + d2 + year2;

		String[] arrOfStrtime2 = time2.split(":");
		String hourpeeropen = arrOfStrtime2[arrOfStrtime2.length - 2];
		String min2 = arrOfStrtime2[arrOfStrtime2.length - 1];

		String hr2;

		int l2 = hourpeeropen.length();
		if (l2 == 1) {
			hr2 = "0" + hourpeeropen;
		} else {
			hr2 = hourpeeropen;
		}

		timereviewopen = hr2 + ":" + min2 + " " + timeampm2;

		// Peer review due date& time

		String[] arrOfStr3 = getText(tp.peerdue_lbl).split(" ");
		waitThread(2000);
		String month3 = arrOfStr3[arrOfStr3.length - 5];
		String d3 = arrOfStr3[arrOfStr3.length - 4];
		String y3 = arrOfStr3[arrOfStr3.length - 3];
		String year3 = y3.substring(0, 4);

		String time3 = arrOfStr3[arrOfStr3.length - 2];
		String timeampm3 = arrOfStr3[arrOfStr3.length - 1];

		datereviewdue = month3 + " " + d3 + year3;

		String[] arrOfStrtime3 = time3.split(":");
		String hourpeerdue = arrOfStrtime3[arrOfStrtime3.length - 2];
		String min3 = arrOfStrtime3[arrOfStrtime3.length - 1];

		String hr3;

		int l3 = hourpeerdue.length();
		if (l3 == 1) {
			hr3 = "0" + hourpeerdue;
		} else {
			hr3 = hourpeerdue;
		}

		timereviewdue = hr3 + ":" + min3 + " " + timeampm3;

		// Result publish date & time

		String[] arrOfStr4 = getText(tr.resultpublishdate_lbl).split(" ");
		waitThread(2000);
		String month4 = arrOfStr4[arrOfStr4.length - 5];
		String d4 = arrOfStr4[arrOfStr4.length - 4];
		String y4 = arrOfStr4[arrOfStr4.length - 3];
		String year4 = y4.substring(0, 4);

		String time4 = arrOfStr4[arrOfStr4.length - 2];
		String timeampm4 = arrOfStr4[arrOfStr4.length - 1];

		resultdate = month4 + " " + d4 + year4;

		String[] arrOfStrtime4 = time4.split(":");
		String houresult = arrOfStrtime4[arrOfStrtime4.length - 2];
		String min4 = arrOfStrtime4[arrOfStrtime4.length - 1];

		String hr4;

		int l4 = houresult.length();
		if (l4 == 1) {
			hr4 = "0" + houresult;
		} else {
			hr4 = houresult;
		}

		resultime = hr4 + ":" + min4 + " " + timeampm4;

	}

	// Date Time Format in Student section Assessment Card

	public String datetestopen_stud;
	public String timetestopen_stud;
	public String datetestdue_stud;
	public String timetestdue_stud;
	public String datereviewopen_stud;
	public String timereviewopen_stud;
	public String datereviewdue_stud;
	public String timereviewdue_stud;
	public String resultdate_stud;
	public String resultime_stud;

	public void studentdatetimesplitmethod() {

		// Testopen date & time
		waitThread(3000);
		String[] arrOfStr11 = getText(tts.studenttestopendateandtime).split(" ");
		waitThread(3000);

		String month11 = arrOfStr11[arrOfStr11.length - 5];
		String d11 = arrOfStr11[arrOfStr11.length - 4];
		String y11 = arrOfStr11[arrOfStr11.length - 3];
		String year11 = y11.substring(0, 4);

		String time111 = arrOfStr11[arrOfStr11.length - 2];
		String timeampm11 = arrOfStr11[arrOfStr11.length - 1];

		datetestopen_stud = month11 + " " + d11 + year11;

		String[] arrOfStrtime1 = time111.split(":");
		String hour11 = arrOfStrtime1[arrOfStrtime1.length - 2];
		String min11 = arrOfStrtime1[arrOfStrtime1.length - 1];

		String hour01;

		int l11 = hour11.length();
		if (l11 == 1) {
			hour01 = "0" + hour11;
		} else {
			hour01 = hour11;
		}

		timetestopen_stud = hour01 + ":" + min11 + " " + timeampm11;

		// Test due date & time

		String[] arrOfStr12 = getText(tts.studenttestduedateandtime).split(" ");
		waitThread(2000);
		String month12 = arrOfStr12[arrOfStr12.length - 5];
		String d12 = arrOfStr12[arrOfStr12.length - 4];
		String y12 = arrOfStr12[arrOfStr12.length - 3];
		String year12 = y12.substring(0, 4);

		String time112 = arrOfStr12[arrOfStr12.length - 2];
		String timeampm12 = arrOfStr12[arrOfStr12.length - 1];

		datetestdue_stud = month12 + " " + d12 + year12;

		String[] arrOfStrtime12 = time112.split(":");
		String hourtestdue1 = arrOfStrtime12[arrOfStrtime12.length - 2];
		String min12 = arrOfStrtime12[arrOfStrtime12.length - 1];

		String hr12;

		int l12 = hourtestdue1.length();
		if (l12 == 1) {
			hr12 = "0" + hourtestdue1;
		} else {
			hr12 = hourtestdue1;
		}

		timetestdue_stud = hr12 + ":" + min12 + " " + timeampm12;

		// Peer review Open date& time

		String[] arrOfStr21 = getText(tp.peeropen_lbl).split(" ");
		waitThread(2000);
		String month21 = arrOfStr21[arrOfStr21.length - 5];
		String d21 = arrOfStr21[arrOfStr21.length - 4];
		String y21 = arrOfStr21[arrOfStr21.length - 3];
		String year21 = y21.substring(0, 4);

		String time21 = arrOfStr21[arrOfStr21.length - 2];
		String timeampm21 = arrOfStr21[arrOfStr21.length - 1];

		datereviewopen_stud = month21 + " " + d21 + year21;

		String[] arrOfStrtime21 = time21.split(":");
		String hourpeeropen21 = arrOfStrtime21[arrOfStrtime21.length - 2];
		String min21 = arrOfStrtime21[arrOfStrtime21.length - 1];

		String hr21;

		int l21 = hourpeeropen21.length();
		if (l21 == 1) {
			hr21 = "0" + hourpeeropen21;
		} else {
			hr21 = hourpeeropen21;
		}

		timereviewopen_stud = hr21 + ":" + min21 + " " + timeampm21;

		// Peer review due date& time

		String[] arrOfStr31 = getText(tp.peerdue_lbl).split(" ");
		waitThread(2000);
		String month31 = arrOfStr31[arrOfStr31.length - 5];
		String d31 = arrOfStr31[arrOfStr31.length - 4];
		String y31 = arrOfStr31[arrOfStr31.length - 3];
		String year31 = y31.substring(0, 4);

		String time31 = arrOfStr31[arrOfStr31.length - 2];
		String timeampm31 = arrOfStr31[arrOfStr31.length - 1];

		datereviewdue_stud = month31 + " " + d31 + year31;

		String[] arrOfStrtime31 = time31.split(":");
		String hourpeerdue31 = arrOfStrtime31[arrOfStrtime31.length - 2];
		String min31 = arrOfStrtime31[arrOfStrtime31.length - 1];

		String hr31;

		int l31 = hourpeerdue31.length();
		if (l31 == 1) {
			hr31 = "0" + hourpeerdue31;
		} else {
			hr31 = hourpeerdue31;
		}

		timereviewdue_stud = hr31 + ":" + min31 + " " + timeampm31;
	}
	// Result publish date & time
	public void studentresultdatetimemethod() {

		

		String[] arrOfStr41 = getText(tr.resultpublishdate_lbl).split(" ");
		waitThread(2000);
		String month41 = arrOfStr41[arrOfStr41.length - 5];
		String d41 = arrOfStr41[arrOfStr41.length - 4];
		String y41 = arrOfStr41[arrOfStr41.length - 3];
		String year41 = y41.substring(0, 4);

		String time41 = arrOfStr41[arrOfStr41.length - 2];
		String timeampm41 = arrOfStr41[arrOfStr41.length - 1];

		resultdate_stud = month41 + " " + d41 + year41;

		String[] arrOfStrtime41 = time41.split(":");
		String houresult41 = arrOfStrtime41[arrOfStrtime41.length - 2];
		String min41 = arrOfStrtime41[arrOfStrtime41.length - 1];

		String hr41;

		int l41 = houresult41.length();
		if (l41 == 1) {
			hr41 = "0" + houresult41;
		} else {
			hr41 = houresult41;
		}

		resultime_stud = hr41 + ":" + min41 + " " + timeampm41;

	}

	/*
	 * Method to click Student answer sheet from Result window of Teacher
	 */
	public void clickstudentanswersheet(String Studentname, String firstlocator, String lastlocator) {

		// identify rows of table.
		List<WebElement> r_table = driver
				.findElements(By.xpath("//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr"));
		int tablesize = r_table.size();
		// To find student name
		String path1 = "//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[";
		String path2 = "]/td[3]/div";

		// iterate rows of table according to the student name
		for (int r = 1; r <= tablesize; r++) {
			// To get student name
			String n = driver.findElement(By.xpath(path1 + r + path2)).getText();
			if (n.contains(Studentname)) {

				// To click on the Answer sheet button
				click(firstlocator + r + lastlocator);
				waitThread(1000);
				break;
			}
		}

	}

	/*
	 * Method to get the grid data from the table-Teacher Result window
	 */
	public String getdatafromgrid(String studentname, String firstlocator, String lastlocator) {
		String griddata = "";
		// identify rows of table.
		List<WebElement> r_table = driver
				.findElements(By.xpath("//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr"));
		int tablesize = r_table.size();
		// To get the student name
		String path1 = "//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[";
		String path2 = "]/td[3]/div";
		// iterate rows of table according to the student name
		for (int r = 1; r <= tablesize; r++) {
			// To get the student name
			String n = driver.findElement(By.xpath(path1 + r + path2)).getText();
			if (n.contains(studentname)) {
				// get data from the grid
				griddata = driver.findElement(By.xpath(firstlocator + r + lastlocator)).getText();
				break;

			}

		}
		return griddata;

	}
	
	
	/*
	 * Method to click reward score of Student
	 */
	public void clickrewardscoreofstudent(String Studentname, String firstlocator, String lastlocator) {

		// identify rows of table.
		List<WebElement> r_table = driver
				.findElements(By.xpath("//*[@id='questionResultListingTable']/div/div[1]/table/tbody/tr"));
		int tablesize = r_table.size();
		// To find student name
		String path1 = "//*[@id=\"questionResultListingTable\"]/div/div[1]/table/tbody/tr[";
		String path2 = "]/td[3]/div";

		// iterate rows of table according to the student name
		for (int r = 1; r <= tablesize; r++) {
			// To get student name
			String n = driver.findElement(By.xpath(path1 + r + path2)).getText();
			if (n.contains(Studentname)) {

				// To click on the Answer sheet button
				click(firstlocator + r + lastlocator);
				waitThread(1000);
				break;
			}
		}

	}
	
	/*
	 * To remove the leading zero's
	 */
	public String removeLeadingZeroes(String str) {
		String strPattern = "^0+(?!$)";
		str = str.replaceAll(strPattern, "");
		return str;
	}
	
	public void ScrollUp()
	{
		Actions a=new Actions(driver);
		a.sendKeys(Keys.PAGE_UP).build().perform();
		return;
	}
	public void ScrollDown()
	{
		Actions a=new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		return;
	}
	public void ScrollHome()
	{
		Actions actions=new Actions(driver);
		actions.sendKeys(Keys.HOME).build().perform();
		return;
	}
	public void ScrollEnd()
	{
		Actions actions=new Actions(driver);
		actions.sendKeys(Keys.END).build().perform();
		return;
	}

	CreateNewCoursePage cn=new CreateNewCoursePage();
	QuestionPageBasicsPage QP=new QuestionPageBasicsPage();
	
	//To Invite the students to a course-2 students
	public void Invitestudentstocourse(String coursename,String Student1email,String Student2email){
		// type-Course title
		type(cn.txbx_Coursetitle, coursename);
		//click Add students to course button
		click(cn.btn_AddStudents);
		waitThread(1000);
		type(cn.tab_textbox, Student1email + ",");
		driver.findElement(By.xpath(cn.emailtype_txt)).sendKeys(Keys.SPACE);
		type(cn.tab_textbox, Student2email + ",");
		waitThread(3000);
		// click on add to list button
		click(cn.tab_btn_Addtolist);
		waitThread(4000);
		JavaScriptclick(cn.confirmyesbtn);		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		click("//p-tabview/div/ul/li[3]/a/span[2]");
		waitThread(1000);
		click("//button[@id='sendRequestId']");
		waitThread(1000);
		// click on create course button
		click(cn.btn_Createcourse);
		waitThread(1000);
		 waitFor(cn.toaster);			
		 // verify toaster-Course created successfully
		 Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");
		 click(QP.toasterclosebtn);
	}
	//To Invite the students to a course-3 students
	public void Invitestudentstocourse_3(String coursename,String Student1email,String Student2email,String Student3email){
		// type-Course title
		type(cn.txbx_Coursetitle, coursename);
		//click Add students to course button
		click(cn.btn_AddStudents);
		waitThread(1000);
		type(cn.tab_textbox, Student1email + ",");
		
		driver.findElement(By.xpath(cn.emailtype_txt)).sendKeys(Keys.SPACE);		
		type(cn.tab_textbox, Student2email + ",");
		type(cn.tab_textbox, Student3email + ",");
		// click on add to list button
		click(cn.tab_btn_Addtolist);
		waitThread(3000);
		click(cn.confirmyesbtn);
		click("//p-tabview/div/ul/li[3]/a/span[2]");
		waitThread(1000);
		click("//button[@id='sendRequestId']");
		waitThread(1000);
		// click on create course button
		click(cn.btn_Createcourse);
		waitThread(1000);
		 waitFor(cn.toaster);			
		 // verify toaster-Course created successfully
		 Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");
		 click(QP.toasterclosebtn);
	}
	
	//To Invite the students to a course-3 students
	public void Invitestudentstocourse_4(String coursename,String Student1email,String Student2email,String Student3email,String Student4email){
		// type-Course title
		type(cn.txbx_Coursetitle, coursename);
		//click Add students to course button
		click(cn.btn_AddStudents);
		waitThread(1000);
		type(cn.tab_textbox, Student1email + ",");
		driver.findElement(By.xpath(cn.emailtype_txt)).sendKeys(Keys.SPACE);
		type(cn.tab_textbox, Student2email + ",");
		type(cn.tab_textbox, Student3email + ",");
		type(cn.tab_textbox, Student4email + ",");
		// click on add to list button
		click(cn.tab_btn_Addtolist);
		waitThread(1000);
		click(cn.confirmyesbtn);
		click("//p-tabview/div/ul/li[3]/a/span[2]");
		waitThread(1000);
		click("//button[@id='sendRequestId']");
		waitThread(1000);
		// click on create course button
		click(cn.btn_Createcourse);
		waitThread(1000);
		 waitFor(cn.toaster);			
		 // verify toaster-Course created successfully
		 Assert.assertEquals(getText(cn.toaster).trim(), "Course created successfully");
		 click(QP.toasterclosebtn);
	}
	
	public void invitestudent(){
		
		waitThread(1000);
		// click on add to list button
		click(cn.tab_btn_Addtolist);
		waitThread(4000);
		click(cn.confirmyesbtn);
		waitThread(4000);
		click("//p-tabview/div/ul/li[3]/a/span[2]");
		waitThread(2000);
		click("//button[@id='sendRequestId']");
	}
}
