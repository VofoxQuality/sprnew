package com.Home.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import SPRautomation.StudentPeerReview.basePage;

public class LandingPage extends basePage {

	public String PageTitle = "//*[@class='page-title text-lg-left text-md-center']";

	public String sectionTitle = "//*[@class='section-title text-lg-left text-md-center']";

	public String labels1 = "//p-button[@label='Login']//following::strong//parent::p[1]";

	public String labels2 = "//h4[@class='section-title text-lg-left text-md-center']";

	public String labels3 = "//img[@id='teacher']//following::p[1]";

	public String labels4 = "//img[@id='graduate']/following::p[1]";

	public String btnstudent = "//img[@id='graduate']/following::p-button";

}
