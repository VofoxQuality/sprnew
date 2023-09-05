package CreateNewAssessment.Pages;

import SPRautomation.StudentPeerReview.basePage;

public class PeerReviewPageStudentDetailsPage extends basePage {

	// Textbox
	public String emailtype_txt = "//input[@id='inviteStudentChip']";

	// Grid

	// Email value grid
	public String emailval_2 = "//div[@id='studentDetails']/p-card/div/div/div/div/div[2]/p-chips/div/ul/li[2]/div";

	// Answer sheets to be assigned to the Peer Reviewer section Grid value

	// 1st raw
	public String studant1_column1 = " div.p-datatable-wrapper> table > tbody > tr:nth-child(1) > td:nth-child(3) > div > div:nth-child(1) > p-badge > span";
	public String studant1_column2 = " div.p-datatable-wrapper> table > tbody > tr:nth-child(1) > td:nth-child(3) > div > div:nth-child(2) > p-badge > span";
	public String studant1_column3 = " div.p-datatable-wrapper> table > tbody > tr:nth-child(1) > td:nth-child(3) > div > div:nth-child(3) > p-badge > span";

	// 2nd raw
	public String studant2_column1 = " div.p-datatable-wrapper > table > tbody > tr:nth-child(2) > td:nth-child(3) > div > div:nth-child(1) > p-badge > span";
	public String studant2_column2 = " div.p-datatable-wrapper > table > tbody > tr:nth-child(2) > td:nth-child(3) > div > div:nth-child(2) > p-badge > span";
	public String studant2_column3 = " div.p-datatable-wrapper > table > tbody > tr:nth-child(2) > td:nth-child(3) > div > div:nth-child(3) > p-badge > span";

	// 3rd raw

	public String studant3_column1 = " div.p-datatable-wrapper > table > tbody > tr:nth-child(3) > td:nth-child(3) > div > div:nth-child(1)  > p-badge > span";
	public String studant3_column2 = " div.p-datatable-wrapper> table > tbody > tr:nth-child(3) > td:nth-child(3) > div > div:nth-child(2)  > p-badge > span";
	public String studant3_column3 = " div.p-datatable-wrapper> table > tbody > tr:nth-child(3) > td:nth-child(3) > div > div:nth-child(3)  > p-badge > span";

	// 4th raw

	public String studant4_column1 = " div.p-datatable-wrapper> table > tbody > tr:nth-child(4) > td:nth-child(3) > div > div:nth-child(1) > p-badge > span";
	public String studant4_column2 = " div.p-datatable-wrapper > table > tbody > tr:nth-child(4) > td:nth-child(3) > div > div:nth-child(2) > p-badge > span";
	public String studant4_column3 = " div.p-datatable-wrapper> table > tbody > tr:nth-child(4) > td:nth-child(3) > div > div:nth-child(3) > p-badge > span";

	// column count
	public String studant1_columncount = "//*[@id='tstPeerReviewTable']/div/div[1]/table/tbody/tr[1]/td[3]/div/div";

	// Peer Reviewer section Grid value
	public String studantname1_gridval = "div.p-datatable-wrapper> table > tbody > tr:nth-child(1) > td:nth-child(2) > div";
	public String studantname2_gridval = "div.p-datatable-wrapper > table > tbody > tr:nth-child(2) > td:nth-child(2) > div";
	public String studantname3_gridval = "div.p-datatable-wrapper> table > tbody > tr:nth-child(3) > td:nth-child(2) > div";
	public String studantname4_gridval = " div.p-datatable-wrapper> table > tbody > tr:nth-child(4) > td:nth-child(2) > div";

	// drop down
	public String anssheetperstu_drp = "#tstNoOfPeer > div";
	
	//validation
	public String rew_val="//input[@id='rewardScore']//following::small[1]";

	// dropdownvalue
	public String anssheetperstu_drpval = "#tstNoOfPeer > div > span";
	public String anssheetperstu_drpcount = "//p-dropdown[@id='tstNoOfPeer']/div/div[3]/div/ul/p-dropdownitem/li";
	public String anssheetperstu_drpcount1 = "//p-dropdown[@id='tstNoOfPeer']/div/div[3]/div/ul/p-dropdownitem/li[1]";
	public String anssheetperstu_drpcount2 = "//p-dropdown[@id='tstNoOfPeer']/div/div[3]/div/ul/p-dropdownitem[2]/li";
	public String anssheetperstu_drpcount3 = "//p-dropdown[@id='tstNoOfPeer']/div/div[3]/div/ul/p-dropdownitem[3]/li";
	public String anssheetperstu_drplist = "//p-dropdown[@id='tstNoOfPeer']/div/div[3]/div/ul";

	// Button alert discard
	public String alertdiscard_btn = "#tstAlertBox > div.modal-footer > button.btn1";
}
