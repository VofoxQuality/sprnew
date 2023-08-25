package CurrentAssessmentsforStudents.Pages;

import SPRautomation.StudentPeerReview.basePage;

public class StudentPeerReviewPage extends basePage {

	public String reviewpending_lbl = "//div[@id='studentAssessmentDataView']/div/div[1]/div/div[4]//p-badge/span";
	public String zeropercent_card = "//div[@id='studentAssessmentDataView']/div/div[1]//div[4]/div/div[2]/div[2]/div/p";
	public String peer_window_clsd = "//div[@id='studentAssessmentDataView']//div[4]/div/div[1]/button/span";
	public String teacher_dropdwn = "//*[@id='courseCreatedBy']/div/div[2]/span";
	public String teacher2namedropdwn = "//p-dropdown[@id='courseCreatedBy']//div[3]/div[2]/ul/p-dropdownitem[3]/li/span";
	public String teach_list_drpdwn = "//*[@id='teacherListDropDown']/div/div[2]";
	public String teach2_nam_list = "//p-dropdown[@id='teacherListDropDown']//div[3]/div[2]/ul/p-dropdownitem[3]/li";
	public String coursename_drop_stud = "//*[@id='courseListDropDown']/div/div[2]";
	public String course_name_stud = "//p-dropdown[@id='courseListDropDown']//div[3]/div[2]/ul/p-dropdownitem/li/span";
	public String course_bx = "//*[@id='courseListDropDown']/div/span";
	public String teach_allselect = "//*[@id='teacherListDropDown']/div//span";
	public String teachdrop_stud2 = "//p-dropdown[@id='courseCreatedBy']//div[3]/div[2]/ul/p-dropdownitem/li/span";
	public String teachname_stud2 = "//p-dropdown[@id='teacherListDropDown']//div[3]/div[2]/ul/p-dropdownitem/li/span";

}
