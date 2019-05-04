package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cimbui.Pages.HomePage;
import cimbui.Pages.LoginPage;
import cimbui.Pages.merchantApprove;
import cimbui.TestBase.TestBase;
import cimbui.Util.TestUtil;

public class MerchantApproveTest extends  TestBase{
	
		cimbui.Pages.LoginPage loginPage;
		 HomePage homePage;
		merchantApprove merApp;
		TestUtil testUtil;
		

		public MerchantApproveTest() {
			super();
		}


	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();

		loginPage = new LoginPage();
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}


	@Test(priority=1)
	public void createMerchant() throws InterruptedException{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 homePage.createMerchant();
			System.out.println(HomePage.merchant_creation_msg);
		 Assert.assertEquals("Merchant Created Successfully and Request has been sent for Approval",HomePage.merchant_creation_msg);
			
		 driver.close();
		
	}
	

	
	@Test(priority=2)
	public void approveMerchant() throws InterruptedException{
	
		 
		 merApp = loginPage.login1(prop.getProperty("username1"), prop.getProperty("password1"));
			merApp.approveMerchant();
			System.out.println(merchantApprove.merchant_approve_msg);
			Assert.assertEquals("Merchant Approved Successfully with MerchantID",merchantApprove.merchant_approve_msg);
}
}

	