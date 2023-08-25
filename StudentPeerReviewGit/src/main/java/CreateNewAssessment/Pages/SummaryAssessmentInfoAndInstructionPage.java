package CreateNewAssessment.Pages;

import SPRautomation.StudentPeerReview.basePage;

public class SummaryAssessmentInfoAndInstructionPage extends basePage {
	// frame
	public String Assessinfo_frame = "#assessment-info_ifr";
	public String Assessinstr_frame = "#assessment-instructions_ifr";

	// Box
	public String Assessinfo_Box = "#assessment-info > div";
	public String Assessinstr_Box = "#assessment-instructions > div";

	// label
	public String Assessinfo_lbl = "#tinymce > p:nth-child(1)";

	// image,vide,link in assessment info box
	public String assessinfoimage = "#tinymce > p:nth-child(2) > img";
	public String assessinfovideo = "#tinymce > p:nth-child(3) > video";
	public String assessinfolink = "#tinymce > p:nth-child(4) > a";

	// label
	public String Assessinstruction_lbl = "#tinymce > p:nth-child(1)";

	// image,video,link
	public String assessinstimage = "#tinymce > p:nth-child(2) > img";
	public String assessinstvideo = "#tinymce > p:nth-child(3) > video";
	public String assessinstlink = "#tinymce > p:nth-child(4) > a";

	// Button
	public String edit_btn = "#tstEditInfo";

	public String confyes_btn = "//p-confirmdialog[@id='tstStepConfirm']/div/div/div[3]/button[2]/span[2]";
	public String confno_btn = "//p-confirmdialog[@id='tstStepConfirm']/div/div/div[3]/button[1]/span[2]";

	// draft tab
	public String draft_tab = "//div[@id='assessment_tab_list']/p-tabview/div/ul/li[2]/a";

	// wizard
	public String schedule_wizard = "#stepperDiv > p-steps > div > ul > li:nth-child(4)";
	public String summary_wizard = "#stepperDiv > p-steps > div > ul > li:nth-child(5)";

}
