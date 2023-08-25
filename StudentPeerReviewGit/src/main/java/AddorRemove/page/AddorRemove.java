package AddorRemove.page;

import org.openqa.selenium.By;

import SPRautomation.StudentPeerReview.basePage;

public class AddorRemove extends basePage {
	
	
	// Buttons
	
	public String teach_button = "//span[contains(text(),\"I'm a Teacher\")]";
	
	
	// Email value grid
		public String emailval_3 = "//div[@id='studentDetails']/p-card/div/div/div/div/div[2]/p-chips/div/ul/li[2]/div";
		
		
		// textbox-tab
		public String tab_textbox = "//input[@id='inviteStudentChip']";
		
		public String three_dot_btn = "//div[@id='teacherAssessmentDataView']//div[1]/div/div[1]/div[2]/p-splitbutton/div/button[2]";
	
		public String add_orremove_menu = "div.custom-splitbutton.ml-auto > p-splitbutton > div > p-menu > div > ul > li:nth-child(4) > a";
		
		public String view_asmnt = "div.custom-splitbutton.ml-auto > p-splitbutton > div > p-menu > div > ul > li:nth-child(2) > a";
		
		public String delete_asmnt = "div.custom-splitbutton.ml-auto > p-splitbutton > div > p-menu > div > ul > li:nth-child(3) > a";
		
		public String reschedule_date = "/div.custom-splitbutton.ml-auto > p-splitbutton > div > p-menu > div > ul > li:nth-child(1) > a";
		
		public String add_orremove_popup = "//*[@id=\"p-tabpanel-0\"]/app-new-assessment/div[2]/app-add-remove-students/p-dialog[1]//app-add-remove-student-header//p[1]/strong";
		
		public String add_orremove_header ="//p-header";
		
		public String view_detail = "//*[@id=\"teacherAssessmentDataView\"]//div[3]//button/span[2]";
		
		public String reviewssheett_count = "//p-dropdown[@id='tstNoOfPeer']/div/div[3]/div/ul/p-dropdownitem[1]/li";
		
		public String release_btn = "//*[@id='publishBtn']/button";
		
		public String delete_button4 = "//button[@id='delete']";
		
		// AddorRemove Labels
		
		public String assesment_name = "//app-add-remove-student-header/div/div/div/div/p[1]/strong";
				
		public String course_name ="//app-add-remove-student-header/div/div/div/div/p[2]/strong";
		
		public String student_enr_course ="//app-add-remove-students-table/div[1]/div[1]/h6";
		
		public String info_data ="//app-add-remove-students-table/div[1]/div[1]/p";
		
		public String st_enrld = "//div[@id='p-tabpanel-0']//h6";
		
		public String std_asigned = "//app-add-remove-students-table/div[1]/div[2]/div/div/div[1]/div[2]/h6";
		
		public String remove_total_std = "//*[@id='p-tabpanel-0']/app-new-assessment/div[2]/app-add-remove-students/p-dialog[1]/div/div/div[2]/div[2]/app-add-remove-students-table/div[1]/div[2]/div/div/div[1]/div[2]/p";
		
		public String remove_count ="//*[@id='p-tabpanel-0']/app-new-assessment/div[2]/app-add-remove-students/p-dialog[1]/div/div/div[2]/div[2]/app-add-remove-students-table/div[1]/div[2]/div/div/div[1]/div[2]/p/span";
		
		public String not_asigned ="//*[@id='p-tabpanel-9']//app-add-remove-students//div[2]/div[2]/h6";
		
		public String add_total_std ="//div[@id='p-tabpanel-0']/app-new-assessment/div[2]/app-add-remove-students/p-dialog[1]/div/div/div[2]/div[2]/app-add-remove-students-table/div[1]/div[2]/div/div/div[2]/div[2]/p";
		
		public String add_count = "//*[@id='p-tabpanel-0']/app-new-assessment/div[2]/app-add-remove-students/p-dialog[1]/div/div/div[2]/div[2]/app-add-remove-students-table/div[1]/div[2]/div/div/div[2]/div[2]/p";
		
		public String sl_no = "//*[@id='asessmentParticipantTable']//th[2]";
		
		public String std_id = "//*[@id='asessmentParticipantTable']//th[3]";
		
		public String std_name = "//*[@id='asessmentParticipantTable']//th[4]";
		
        public String sl_no1 = "//*[@id='asessmentNonParticipantTable']//th[2]";
		
		public String std_id1 = "//*[@id='asessmentNonParticipantTable']//th[3]";
		
		public String std_name1 = "//*[@id='asessmentNonParticipantTable']//th[4]";
		
		public String no_stds = "//*[@id='asessmentNonParticipantTable']//td";
		
		public String asmnt_label = "#main_asm_heading > div > h4";
		
		public String email_chip2 = "//*[@id='newStudentsChipsMain']//span";
		
		public String totl_std2 ="//*[@id='p-tabpanel-92']/app-new-assessment/div[2]//div[2]/div[2]/p";
		
		public String pop_head = "//*[@id='p-tabpanel-92']//p-dialog[1]/div/div/div[1]";
		
		public String label_1 = "//*[@id='p-tabpanel-92']/app-new-assessment/div[2]//label";
		
		public String act_dd = "//*[@id='courseListingTable']//button[2]/span[1]";
		
		public String search_box = "#searchCourseFilterSpan >input";
		
		//public String course_info ="//*[@id='courseListingTable']/div/div[1]//p-splitbutton//button[1]/span";
		public String lbl_courseinfo=" div > button.p-splitbutton-defaultbutton.p-button.p-component";
		public String course_info = "p-splitbutton > div > button.p-splitbutton-menubutton";
		public String search_course ="//*[@id='searchCourseFilterMain']";
		
		//public String popup_header = "//*[@id= ' r_id_16-label']/p-header";
		
		//Addorremovepopup_buttons
		
		public String remove_btn = "//*[@id='removeStudentBtn']";
		
		public String addstudent_btn ="//*[@id='addStudentBtn']";
		
		public String cancel_btn = "//*[@id='cancelStudentAddRemove']";
		
		public String proceed_btn = "//*[@id='updateStudentAddRemove']";
		
		public String yes_btn ="//*[@id='cancelStudentAddRemoveConfirm']//button[2]/span[2]";
		
		public String Reschedule_date = "//*[@id='teacherCardMenuDropDown']/div/p-menu/div/ul/li[1]/a/span[2]";
		
		public String no_btn ="//*[@id='cancelStudentAddRemoveConfirm']/div/div/div[3]/button[1]";
		
		public String suspend_confirm = "//p-confirmdialog/div/div/div[2]/span";
		
		public String yes_button = "//p-confirmdialog/div/div/div[3]/button[2]/span[2]";
		
		public String course_tab = "#navbar-menu > div > a";
		
		public String teac_dd = "//*[@id='dropdownImgTeacher']";
		
		public String bck_btn = "//*[@id='backToPrevBtn']";
		
		public String reviewans_sheetdropdwn = "//p-dropdown[@id='tstNoOfPeer']/div/span";
		public String reviewssheet_count = "//*[@id='tstNoOfPeer']/div/div[3]/div/ul/p-dropdownitem[2]/li/span";	
		
		
		public String no_drpdwn = "//*[@id='tstNoOfPeer']/div/div[2]/span";
		
		public String save_btn ="//*[@id='savePeerAssignDataBtn']";
		
		public String std_roaster ="//*[@id='p-tabpanel-4-label']/span";
		
		public String course_roaster = "//*[@id='courseListingTable']//p-menu/div/ul/li[2]/a/span";
		
		public String course_nme = "//*[@id='courseNameSection']";
		
		public String roaster_addstd ="//*[@id='roasterInviteMoreStudents']//button";
		
		public String view_details = "//*[@id='teacherAssessmentDataView']/div/div/div/div[3]/div/div[1]/button";
		
		public String asmt_status_popup = "//*[@id='pr_id_32-label']/p-header";
		
		public String total_viewdetail = "//*[@id='totalStudentCountNumber']";
		
		public String close_icon = "//*[@id='assessmentStatusPopup']//button/span";
		
		public String suspend_check = "//*[@id='p-tableGrid']/div/div[1]//p-tablecheckbox/div/div[2]";
		
		public String stdroast_act_dd = "//*[@id='undefined_header']/span[2]";
		
		public String reenrold_std ="//*[@id='undefined_content']//li[2]/a/span[2]";
		
		public String sear_asmt ="//*[@id='searchAssessmentFilter']";
		
		public String no_asmt = "//*[@id=\"studentAssessmentDataView\"]/div/div/div";
		
		public String accnt_setngs ="/html/body/app-root/app-shell/app-header/header//ul/li[3]/div/div/a[1]";
		
		public String add_list = "#addToListBtn > span";
		
		public String cancel_list = "#cancelStudentAddBtn > span";
		
		public String nav_btn = "//*[@id='studentUserName']";
		
		public String Stud_logout_link = "//a[@id='user-dropdown']//following::a[3]";
		
	//	public String suspend_confirm = "//p-confirmdialog/div/div/div[2]/span";
		
		
		//checkboxes
		
		public String studentchkbx_1 = "//*[@id=\"asessmentParticipantTable\"]//div[1]//tr[1]/td[1]/p-tablecheckbox//div[2]   ";
		
		public String studentchkbx_2 = "//*[@id='asessmentNonParticipantTable']//p-tablecheckbox/div/div[2]";
	
		public String roaster_check1 ="//*[@id='p-tableGrid']//table/tbody/tr[3]/td[1]/p-tablecheckbox//div[2]";
	
		//toasters
		
		//public String rem_toaster = "//*[@id=\"cancelStudentAddRemoveConfirm\"]//span";
	
		public String confrm_popup_msg = "//*[@id='cancelStudentAddRemoveConfirm']//div[2]/span";
		
		public String confrm_popup ="#cancelStudentAddRemoveConfirm > div >div >div > span";
		
		
		
		// Place holders-Login
		public String Email_txt = "//input[@id='email']";
		public String Pass_txt = "//input[@id='password']";
		public String LoginBtn_2 = "//button[@id='submit']";
		
		
		
		/*
		 * Login Student
		 */
		public void login_Student(String Emaildata, String Passworddata) {

			// fill the Email
			type(Email_txt, Emaildata);
			// fill password
			type(Pass_txt, Passworddata);
			// click login button
			click(LoginBtn_2);

		}
		
		// logout
		
		public String header_dropdown="//div[@class='username']";
		public String logout_link="//i[@class='pi pi-sign-out']";
		public String logout_btn="//i[@class='pi pi-sign-out']";
		
		public void Logout() {

			waitThread(1000);
			driver.findElement(By.xpath("//div[@class='username']")).click();
			waitThread(1000);
			driver.findElement(By.xpath("//i[@class='pi pi-sign-out']")).click();
		
		
			
		
		}
}

