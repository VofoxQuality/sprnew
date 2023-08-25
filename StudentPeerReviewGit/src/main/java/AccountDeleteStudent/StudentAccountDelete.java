package AccountDeleteStudent;

import SPRautomation.StudentPeerReview.basePage;

public class StudentAccountDelete extends basePage {

	// popup buttons
	public String alrt_nobutton = "button.p-confirm-dialog-reject";
	public String alrt_yesbutton = "button.p-confirm-dialog-accept";

	//current assessment tab
	public String current_assessment_tab = "#assessmentTabs div ul li:nth-child(1)";
	
	//student email textbox - Account settings
	public String stud_email_txtbx = "//div[contains(@class,'account-email-field')]";
	
	//Student email - account settings
	public String stud_email = "//div[contains(@class,'account-email-field')]//span//input";
	
	//No Answer popup- student Peer review
	public String no_answerpopup = "#tstUnattendedPopup > div > div";
	public String submit_btn = "#tstUnattendedSubmit";
	
	//Teacher- course page-enrolled count
	public String enrolled_count = "//*[@id='courseListingTable']//div[1]/table//tr/td[6]/div/span";
	
}
