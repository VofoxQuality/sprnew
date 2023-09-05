package CurrentAssessmentsforStudents.Pages;

import SPRautomation.StudentPeerReview.basePage;

public class StudentResultSectionPage extends basePage {

public String Result_txt = "//*[@id='teacherAssessmentDataView']/div/div[1]/div/div[5]/div/div[1]/div[1]/p";
public String Result_publ_label = "//*[@id='teacherAssessmentDataView']/div/div/div/div[5]/div/div[2]/p[1]";
public String last_date_text = "//*[@id='teacherAssessmentDataView']/div/div/div/div[5]/div/div[2]/p[2]";
public String teach_publish_label = "//*[@id='studentAssessmentDataView']/div/div[1]/div/div[5]/div/div[2]/p[1]/span";
public String last_date_studtxt = "//*[@id='studentAssessmentDataView']/div/div[1]/div/div[5]/div/div[2]/p[2]";
public String viewbutonresult = "//div[@id='studentAssessmentDataView']//div[5]//div[1]/div[2]/button";
}

