package ResultWindowofIndividualTeacherPage;

import SPRautomation.StudentPeerReview.basePage;

public class TeacherManualResultPeerreviewcompletePage extends basePage {
	
	
	//Student Result window with no teacher score 
	public String Q1_Status = "#questionResultListingTable > div > div.p-datatable-wrapper > table > tbody > tr:nth-child(1) > td:nth-child(8) >div";
	public String Q2_Status = "#questionResultListingTable > div > div.p-datatable-wrapper > table > tbody > tr:nth-child(2) > td:nth-child(8) >div";
	public String Q3_Status = "#questionResultListingTable > div > div.p-datatable-wrapper > table > tbody > tr:nth-child(3) > td:nth-child(8) >div";
	
	public String view_btn_q1 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[1]/td[9]/button";
	public String view_btn_q2 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[2]/td[9]/button";
	public String view_btn_q3 = "//p-table[@id='questionResultListingTable']//div[1]/table//tr[3]/td[9]/button";
	
	
	
	
}
