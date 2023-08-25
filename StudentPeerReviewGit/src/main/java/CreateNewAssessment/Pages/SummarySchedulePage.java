package CreateNewAssessment.Pages;

import SPRautomation.StudentPeerReview.basePage;

public class SummarySchedulePage extends basePage{
	
	//Labels-Summary page
	public String Schedulesection="//div[@id='tstScheduleSection']";
	public String Resultmethodsection="//div[@id='result-method-section']";
	public String reconsiderationreqstsection="//div[@id='last-date-recon-sec']";
	public String lblassessment="#main-result-white-box > h5";
	public String peerreviewlbl="#main-result-white-box > div:nth-child(5) > div > h5";
	public String peerreviewlbl1="#main-result-white-box > div:nth-child(4) > div > h5";
	public String testopenlbl="//*[@id='result-method-section']//following::label[1]";
	public String testduelbl="//*[@id='result-method-section']//following::label[2]";
	public String peerreviewopenlbl="//*[@id='result-method-section']//following::label[3]";
	public String peereviewduelbl="//*[@id='result-method-section']//following::label[4]";
	public String lblresultpublish="//p-checkbox[@id='req-recon-checkbox']//following::h5[3]";
	public String lblresultpublish1="//*[@id='main-result-white-box']/div[4]//h5";
	
	public String recosiderationlbl="//p-checkbox[@id='req-recon-checkbox']//following::h5[4]";
	public String lbllstdayreconsider="//*[@id='main-result-white-box']//div[5]//h5";
	public  String lbldayfrmresultpblsh="//*[@id='recon-time']/p";
	
	
	
	//buttons
	public String reconsiderationckbx="//p-checkbox[@id='req-recon-checkbox']";
	public String recchkbx="//div[contains(@class,'p-checkbox-checked p-checkbox-disabled')]";
	public String btnscheduleedit="//p[@id='tstEditSchedule']";
	public String scheduletechermanualbtn="//p-radiobutton[@id='manualPublishRadioBtn']";
	public String checkedmanualbtn="//p-radiobutton[@id='manualPublishRadioBtn']//div[contains(@class,'p-radiobutton-box p-highlight')]";
	public String schedulereconsiderationchkbx="//p-checkbox[@id='reconsiderRequest']";
	public String schedulereconsiderationtext="//*[@id='reconsiderationDiv']//p/span";
	public String btnconfigdefault="//button[@id='configure-def-btn']";
	public String btnconfigdefault1="//*[@id='configure-def-btn']";
	public String btnapplydefault="//button[@id='apply-def-btn']";
	public String assessmentstartday="//p-dropdown[@id='testStartDayVal']";
	public String selectteststartday="p-dropdownitem:nth-child(3) > li";
	public String dayarrowbtn="#testStartDayVal > div > div.p-dropdown-trigger > span";
	public String ddday="#testStartDayVal > div > div.ng-trigger.ng-trigger-overlayAnimation.p-dropdown-panel.p-component.ng-star-inserted > div";
	public String teststartddvalue="#testStartDayVal > div > input";
	public String configsavebtn="//button[@id='save-conf-btn']";
	public String automaticradiobtn="//p-radiobutton[@id='automatic-publish-rdbutton']";
	public String automaticchecked="//p-radiobutton[@id='automatic-publish-rdbutton']//div[contains(@class,'p-radiobutton-box p-highlight')]";
	public String configmailnotfication="//*[@id='assessmentPublished']";
	
	
	//pop ups
	
	public String configpopup="#configure-popup-dialog > div > div";
	public String configlbl="#configure-popup-dialog > div > div > div.p-dialog-header.ng-star-inserted";
	
	//Textboxes
	public String Testopendatetxtbx="//div[@id='result-method-section']//following::p-calendar[1]";
	
	public String Testopentimetxtbx="//div[@id='result-method-section']//following::p-calendar[2]";
	
	public String Testduedatetxtbx="//div[@id='result-method-section']//following::p-calendar[3]";
	public String Testduetimetxtbx="//div[@id='result-method-section']//following::p-calendar[4]";
	
	public String Reviewopendatetxtbx="//div[@id='result-method-section']//following::p-calendar[5]";
	public String Reviewopentimetxtbx="//div[@id='result-method-section']//following::p-calendar[6]";
	
	public String Reviewduedatetxtbx="//div[@id='result-method-section']//following::p-calendar[7]";
	public String Reviewduetimetxtbx="//div[@id='result-method-section']//following::p-calendar[8]";
	
	public String Resultdatetxtbx="//div[@id='result-method-section']//following::p-calendar[9]";
	public String Resulttimetxtbox="//div[@id='result-method-section']//following::p-calendar[10]";
	
	public String Reconsiderationdatetxtbx="//div[@id='result-method-section']//following::p-calendar[11]";
	public String Reconsiderationtimetxtbx="//div[@id='result-method-section']//following::p-calendar[12]";
	
	
	//Date and time values
	
	public String Testopendatevalue="//div[@id='result-method-section']//following::p-calendar[1]//input";
	public String Testopentimevalue="//div[@id='result-method-section']//following::p-calendar[2]//input";
	
	public String Testduedatevalue="//div[@id='result-method-section']//following::p-calendar[3]//input";
	public String Testduetimevalue="//div[@id='result-method-section']//following::p-calendar[4]//input";
	
	public String Reviewopendatevalue="//div[@id='result-method-section']//following::p-calendar[5]//input";
	public String Reviewopentimevalue="//div[@id='result-method-section']//following::p-calendar[6]//input";
	
	public String Reviewduedatevalue="//div[@id='result-method-section']//following::p-calendar[7]//input";
	public String Reviewduetimevalue="//div[@id='result-method-section']//following::p-calendar[8]//input";
	
	public String Resultdatevalue="//div[@id='result-method-section']//following::p-calendar[9]//input[1]";
	public String Resulttimevalue="//div[@id='result-method-section']//following::p-calendar[10]//input[1]";
	public String resultfilledtime="//p-calendar[contains(@class,'p-inputwrapper-filled') and @inputid='timeonly' and @id='spResultStartTimeCalendar']";
	
	public String Reconsiderationdatevalue="//div[@id='result-method-section']//following::p-calendar[11]//input";
	public String Reconsiderationtimevalue="//div[@id='result-method-section']//following::p-calendar[12]//input";
	public String reconsiderchkbx="//p-checkbox[@id='reconsiderRequest']";
	public String reconsiderfilledtime="//p-calendar[contains(@class,'p-inputwrapper-filled') and @inputid='timeonly' and @id='spReconsiderTimeCalendar']";
	

}
