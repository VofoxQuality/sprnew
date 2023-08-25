package SPR.Utilities;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import SPRautomation.StudentPeerReview.basePage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
	

	
	public class Listeners extends basePage implements ITestListener {

	    //Extent Report Declarations
	    private static ExtentReports extent = ExtentManager.createInstance();
	    private static ThreadLocal<ExtentTest> test = new ThreadLocal();


	    @Override
	    public synchronized void onStart(ITestContext context) {
	        System.out.println("Extent Reports Version 3 Test Suite started!");
	    }

	    @Override
	    public synchronized void onFinish(ITestContext context) {
	        System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
	        extent.flush();
	    }

	    @Override
	    public synchronized void onTestStart(ITestResult result) {
	        System.out.println((result.getMethod().getMethodName() + " Started!"));
	        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
	        test.set(extentTest);
	    }

	    @Override
	    public synchronized void onTestSuccess(ITestResult result) {
	        System.out.println((result.getMethod().getMethodName() + " PASSED!"));
	        System.out.println("-------------------------------");
	        test.get().pass("Test passed");
	    }

	    /*@aswin : modified*/
	    
	    @Override
	    public synchronized void onTestFailure(ITestResult result) 
	    /*  screenshot path is stored into a string */  
	    {	
	    	System.out.println((result.getMethod().getMethodName() + " FAILED!"));
	    	System.out.println("-------------------------------");
	 		String screenshotPath = null;
			try {
				   screenshotPath = getScreenshot(driver, result.getName());
				} catch (IOException e)
			    {				
				e.printStackTrace();
			    }
		 
			test.get().log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
            test.get().fail(result.getThrowable());
            /*  Screenshot is attached into Extent Report with Error Message  */  
       		try {
				test.get().fail("Snapshot below: "+ result.getThrowable().getMessage()+"  " + test.get().addScreenCaptureFromPath(screenshotPath));
			} catch (IOException e) {				
				e.printStackTrace();
			}
       		
	    }
	    
	    /* @swin : 'getScreenshot' takes the screenshot and returns the screenshot path, the path is needed to attach screenshot into Extend Report   */
	    
       	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException
       		{
    			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    			TakesScreenshot ts = (TakesScreenshot) driver;
    			File source = ts.getScreenshotAs(OutputType.FILE);    			
    			String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName + ".png";
    			File finalDestination = new File(destination);
    			FileUtils.copyFile(source, finalDestination);
    			return destination;
    		}
	        

	    @Override
	    public synchronized void onTestSkipped(ITestResult result) {
	        System.out.println((result.getMethod().getMethodName() + " skipped!"));
	        test.get().skip(result.getThrowable());
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
	    }
	    
	    public static void logMessage(String message) {
	    	test.get().info(message);
	    }
	    
	    public static void logerror(String message) {
	    	test.get().error(message);
	    }
	    public static void logsucess(String message) {
	    	test.get().pass(message);
	    }
	}

	
	

