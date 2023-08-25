package CreateNewAssessment.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import SPRautomation.StudentPeerReview.basePage;

public class BasicDetailsPageCourseandEditorPage extends basePage {

	public String userdirectory;
	// Editor
	public String QuestionEditor = "//editor[@id='question']";
	public String imageeditbtn = "//editor[@id='question']//button[@aria-label='Insert/edit image']";
	public String popupimage = "//*[@class='tox-dialog']";

	public String draftbxtext = "#tstDraftsConfirmation > div > div > div.p-dialog-content > span";
	public String popupclosebtn = "//p-confirmdialog[@id='tstDraftsConfirmation']//*[contains(@class,'close p-link')]";

	// Assessment info editor

	// Insert/Edit Image
	public String infoeditorimagebtn = "#image_upload_asmInfo_editor";
	public String infoimageuploadbtn = "div[id*=dialog-describe_ ]> div > div > div > div:nth-child(1) > div > button";
	public String imageuploadsavebtn = "div.tox-dialog__footer-end > button:nth-child(2)";
	public String imageuploadheaderlbl = "div.tox-dialog>div>div.tox-dialog__title";
	public String imageuploadpopupclosebtn = "div.tox-dialog__header > button";
	public String imageeditcancelbtn = "div.tox-dialog__footer-end > button.tox-button.tox-button--secondary";
	public String infoimage = "#tinymce > p > img";
	public String imagesource_field = "div[id*=dialog-describe_] > div > div > div > div:nth-child(1) > div > div>input";

	// Insert/Edit Media
	public String infoeditorvideobtn = "#media_upload_asmInfo_editor";
	public String infovideouploadbtn = "div[id*=dialog-describe_ ]> div > div.tox-dialog__body-content > div > div:nth-child(1) > div > button";
	public String videouploadsavebtn = "div.tox-dialog__footer-end > button:nth-child(2)";
	public String videouploadheaderlbl = "div.tox-dialog__title";
	public String videouploadpopupclosebtn = "div.tox-dialog__header > button";
	public String videoeditcancelbtn = "button.tox-button.tox-button--secondary";
	public String infovideo = "//*[@class='mce-preview-object mce-object-video']/video/source";
	public String infovideo1 = "//*[@class='mce-preview-object mce-object-video']";

	// Insert/Edit Link
	public String infoeditorbtnlink = "#link_upload_asmInfo_editor";
	public String infolink = "//*[@data-id='assessmentInfo']//a";
	public String urltextbx = "div.tox-control-wrap>input";
	public String texttodisplaybx = "div.tox-form__group:nth-child(2)>input.tox-textfield";

	// Mathtype
	public String infoequation = "#assessmentInfo > div > div.tox-editor-container > div.tox-editor-header > div.tox-toolbar-overlord > div > div:nth-child(10) > button:nth-child(1)";
	public String infomathpopup = "div[id*=wrs_modal_dialogContainer ]";
	public String infomathclosebtn = "a[id*=wrs_modal_close_button ]";
	public String infomathinsertbtn = "button[id*=wrs_modal_button_accept ]";
	public String infomathcancelbtn = "button[id*=wrs_modal_button_cancel ]";
	public String infofractionbtn = "div.wrs_multipleRowPanel.wrs_selected > table:nth-child(1) > tbody > tr:nth-child(1) > td:nth-child(1) > button";
	public String rubricfraction_btn = "#wrs_content_container\\[1\\] > div > div.wrs_toolbar > div.wrs_panelContainer > div.wrs_multipleRowPanel.wrs_selected > table:nth-child(1) > tbody > tr:nth-child(1) > td:nth-child(1) > button";
	public String infofractionbody = "span.wrs_container";
	public String infosquareroutebtn = "div.wrs_multipleRowPanel.wrs_selected > table:nth-child(1) > tbody > tr:nth-child(1) > td:nth-child(2) > button";
	public String infomathtextbx = "div.wrs_formulaDisplayWrapper > div.wrs_formulaDisplay > div > input";
	public String rubric_math_txtbx = "#wrs_content_container\\[1\\] > div > div.wrs_formulaDisplayWrapper > div.wrs_formulaDisplay > div > input";
	public String equationineditor = "//*[@data-id='assessmentInfo']//child::p[4]/img";
	public String rubric_sqre_root = "//*[@id=\"wrs_content_container[1]\"]/div/div[1]/div[3]/div[1]/table[1]/tbody/tr[1]/td[2]/button";
	public String rubric_math_insertbtn = "//button[@id='wrs_modal_button_accept[1]']";
	
	// Assessment instruction editor

	// Insert/Edit Image
	public String instreditorimagebtn = "#image_upload_asmInst_editor";
	public String instrimageuploadbtn = "div[id*=dialog-describe_ ]> div > div > div > div:nth-child(1) > div > button";
	public String instrimageuploadsavebtn = "div.tox-dialog__footer-end > button:nth-child(2)";
	public String instrimageuploadheaderlbl = "div.tox-dialog>div>div.tox-dialog__title";
	public String instrimageuploadpopupclosebtn = "div.tox-dialog__header > button";
	public String instrimageeditcancelbtn = "div.tox-dialog__footer-end > button.tox-button.tox-button--secondary";
	public String instrimage = "#tinymce > p > img";

	// Insert/Edit Media
	public String instreditorvideobtn = "#media_upload_asmInst_editor";
	public String instrvideouploadbtn = "div[id*=dialog-describe_ ]> div > div.tox-dialog__body-content > div > div:nth-child(1) > div > button";
	public String instrvideouploadsavebtn = "div.tox-dialog__footer-end > button:nth-child(2)";
	public String instrvideouploadheaderlbl = "div.tox-dialog__title";
	public String instrvideouploadpopupclosebtn = "div.tox-dialog__header > button";
	public String instrvideoeditcancelcancelbtn = "button.tox-button.tox-button--secondary";
	public String instrvideo = "#tinymce > p > span>video>source";
	public String instrvideo1 = "#tinymce > p > span";

	// Insert/Edit Link
	public String instreditorbtnlink = "//button[@id='link_upload_asmInst_editor']";
	public String instrlink = "//*[@data-id='instructions']//child::a";
	public String instrurltextbx = "div.tox-control-wrap>input";

	// Mathtype
	public String btnmathtype = "#instructions > div > div.tox-editor-container > div.tox-editor-header > div.tox-toolbar-overlord > div > div:nth-child(10) > button:nth-child(1)";
	public String instreqneditor = "div[id*='wrs_modal_dialogContainer']";
	public String equationeditor = "#wrs_modal_dialogContainer\\[0\\]";
	public String fractionbtn = "div.wrs_multipleRowPanel.wrs_selected > table:nth-child(1) > tbody > tr:nth-child(1) > td:nth-child(1) > button";
	public String instrnmathclose = "//*[contains(@id,'wrs_modal_close_button')]";
	// Draft page-grid labels
	public String lblsn = "table > thead.p-datatable-thead > tr > th:nth-child(2)";
	public String lblcoursename = "table > thead.p-datatable-thead > tr > th:nth-child(3)";
	public String lblassessmntname = "table > thead.p-datatable-thead > tr > th:nth-child(4)";
	public String lblQuestioncount="table > thead.p-datatable-thead > tr > th:nth-child(5)";
	public String lblcreatedon = "table > thead.p-datatable-thead > tr > th:nth-child(6)";
	public String lblmodifyon = "table > thead.p-datatable-thead > tr > th:nth-child(7)";
	public String lblaction = "table > thead.p-datatable-thead > tr > th:nth-child(8)";
	public String draftcontinueedit = "//*[@id='continue_edit_btn']";
	public String draftdeletebtn = "//*[@id='draft_del_btn']";
	
	//Confirmation popup
	public String Confirm_discardpopup = "div.p-confirm-dialog";
	public String Confirm_lbl_confirmation = "div.p-dialog-header > span";
	public String Confirm_txtpopup = "div.p-dialog-content > span";
	public String Confirm_btnNo = "button.p-confirm-dialog-reject";
	public String Confirm_btnYes = "button.p-confirm-dialog-accept";
	
	//Tab current
	public String tab_current="#assessment_tab_list > p-tabview > div > ul.p-tabview-nav > li:nth-child(1)";
	//Tab draft
	public String tab__draft="#assessment_tab_list > p-tabview > div > ul.p-tabview-nav > li:nth-child(3)";
	//Tab Assessment
	public String tab_Assessment="//*[@id='navbar-menu']/div/a[2]";
	public String tabdiscardpopup ="//div[@id='courseTabMain']//following::modal-container[1]//div[@id='tstAlertBox']";
	public String txt1popup = "//div[@id='courseTabMain']//following::modal-container[1]//div[@class='modal-body']";
	public String btnDiscard ="//div[@id='courseTabMain']//following::modal-container[1]//button[@class='btn1']";
	public String btnCancel ="//div[@id='courseTabMain']//following::modal-container[1]//button[@class='btn2']";
	
	public String Assessmenttabdiscardpopup = "#tstAlertBox";
	public String Assessment_txt1popup = "#tstAlertBox > div.modal-body";
	public String Assessment_btnDiscard = "//*[@id='tstAlertBox']/div[3]/button[1]";
	public String Assessment_btnCancel = "//*[@id='tstAlertBox']/div[3]/button[2]";
	public String tabdraft = "p-tabview > div > ul.p-tabview-nav > li:nth-child(2)>a";
	
	//Draftpage
	public String createdondate = "tbody.p-datatable-tbody > tr:nth-child(1) > td:nth-child(6)";
	public String modifydate = "tbody.p-datatable-tbody > tr:nth-child(1) > td:nth-child(7)";
	
	public String getdate() {

		DateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public void Editorfileupload(String filename) throws AWTException {

		waitThread(2000);
		userdirectory = System.getProperty("user.dir");
		StringSelection select = new StringSelection(userdirectory + "\\Documentfiles\\" + filename);
		waitThread(2000);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		waitThread(2000);
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);

	}

	// To perform delete account functionality
	public void DeleteAccount() {
		waitThread(1000);
		driver.findElement(By.xpath("//div[@class='username']")).click();
		waitThread(1000);
		driver.findElement(By.xpath("//i[@class='fas fa-user-circle']")).click();
		waitThread(1000);
		driver.findElement(By.xpath("//button[@id='delete']")).click();
		waitThread(1000);
		driver.findElement(By.cssSelector("button.p-confirm-dialog-accept")).click();

	}

}
