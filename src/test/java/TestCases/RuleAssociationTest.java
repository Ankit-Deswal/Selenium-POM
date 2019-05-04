package TestCases;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;


import cimbui.Pages.HomePage;
import cimbui.Pages.LoginPage;
import cimbui.Pages.createTerminal;
import cimbui.Pages.issuerGroup;
import cimbui.Pages.merchantApprove;
import cimbui.Pages.registerTID;
import cimbui.Pages.ruleApprove;
import cimbui.Pages.ruleAssociation;
import cimbui.Pages.ruleCreation;
import cimbui.Pages.storeApprove;
import cimbui.Pages.storeCreation;
import cimbui.TestBase.TestBase;
import cimbui.Util.TestUtil;

public class RuleAssociationTest extends TestBase {
	TestUtil testUtil;
	cimbui.Pages.LoginPage loginPage;
	storeApprove strApp;
	merchantApprove merApp;
	storeCreation storeCreations;

	String CIMBrev = "CIMB";
	String CIMBDEBITrev = "CIMBDEBIT";

	HomePage homePage;
	public RuleAssociationTest() {
		super();
	}

	@BeforeTest
	public void setUp() throws InterruptedException {
		initialization();
		

		loginPage = new LoginPage();
		
		// homePage = loginPage.login(prop.getProperty("username"),
		// prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void createMerchant() throws InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"),
				prop.getProperty("password"));
		homePage.createMerchant();
		Assert.assertEquals(
				"Merchant Created Successfully and Request has been sent for Approval",
				HomePage.merchant_creation_msg);

	}

	@Test(priority = 2)
	public void approveMerchant() throws InterruptedException {
		testUtil = new TestUtil();
		loginPage = new LoginPage();

		merApp = loginPage.login1(prop.getProperty("username1"),
				prop.getProperty("password1"));
		merApp.approveMerchant();
		Assert.assertEquals("Merchant Approved Successfully with MerchantID",
				merchantApprove.merchant_approve_msg);
	}

	@Test(priority = 3)
	public void createStore() throws InterruptedException {
		System.out.println("ok");
		storeCreation strCreate = new storeCreation();
		strCreate.createStore();
		Assert.assertEquals(
				"Store Created Successfully and Request has been sent for Approval",
				storeCreation.store_creation_msg);

	}

	@Test(priority = 4)
	public void approveStore() throws InterruptedException {
		testUtil = new TestUtil();
		loginPage = new LoginPage();

		strApp = loginPage.login2(prop.getProperty("username"),
				prop.getProperty("password"));
		strApp.storeApprve();
		Assert.assertEquals("Store Approved Successfully with StoreID",
				storeApprove.store_approver_msg);
	}

	@Test(priority = 5)
	public void terminalCreationt() throws InterruptedException {

		createTerminal terminal = new createTerminal();
		terminal.TerminalCreation();
		Assert.assertEquals("Pos Creation On Hub Successful For Terminal ID",
				createTerminal.POS_creation_msg);

	}

	@Test(priority = 6)
	public void tidRegistration() throws InterruptedException {

		registerTID tidreg = new registerTID();
		tidreg.tidRegister(CIMBrev);
		Assert.assertEquals("Registration successful, Bank registered with ID",
				registerTID.TID_SUCCESS_MSG);
		tidreg.tidRegister(CIMBDEBITrev);
		Assert.assertEquals("Registration successful, Bank registered with ID",
				registerTID.TID_SUCCESS_MSG);

	}

	@Test(priority = 7)
	public void ruleCreate() throws InterruptedException {
		ruleCreation tidreg1 = new ruleCreation();
		tidreg1.createRule();
		Assert.assertEquals(tidreg1.rulename1,
				"Rule is successfuly sent for approval. Rule Name: "
						+ ruleCreation.approverule);
	}

	@Test(priority = 8)
	public void ruleApproved() throws InterruptedException {
		loginPage = new LoginPage();
		 
		 merApp = loginPage.login1(prop.getProperty("username1"), prop.getProperty("password1"));
		ruleApprove tidreg2 = new ruleApprove();
		tidreg2.approveRule();
		Assert.assertEquals(ruleApprove.ruleapprovetext,
				"Rule Approved Successfuly. Rule Name: "
						+ ruleCreation.approverule);
		
	}

	/*@Test(priority=10)
	public void createIssuerGroup() throws InterruptedException {
		
		issuerGroup ig =new issuerGroup();
		ig.createIssuerGrp();
		String Actual = "Issuer Group :"+TestBase.issuerGroup+ " Created Successfully";
		Assert.assertEquals(cimbui.Pages.issuerGroup.IGNAME,Actual);
		
		
	}*/
	
	@Test(priority = 9)
	public void association() throws InterruptedException {
		

	
		
		ruleAssociation tidreg5 = new ruleAssociation();
		tidreg5.ApplyRule();

		Assert.assertEquals("Association Successful.",ruleAssociation.suceesmsgassociation);
		// strApp.storeApprve();
	}
	@AfterMethod
	public void tearDown(ITestResult result)
	{
	 
	// Here will compare if test is failing then only it will enter into if condition
	if(ITestResult.FAILURE==result.getStatus())
	{
	try 
	{
	// Create refernce of TakesScreenshot
	TakesScreenshot ts=(TakesScreenshot)driver;
	 
	// Call method to capture screenshot
	File source=ts.getScreenshotAs(OutputType.FILE);
	 
	// Copy files to specific location here it will save all screenshot in our project home directory and
	// result.getName() will return name of test case so that screenshot name will be same
	FileUtils.copyFile(source, new File("D:/selenium/error"+result.getName()+".png"));
	 
	System.out.println("Screenshot taken");
	} 
	catch (Exception e)
	{
	 
	System.out.println("Exception while taking screenshot "+e.getMessage());
	} 
	 
	}
	}
}
	 
	

