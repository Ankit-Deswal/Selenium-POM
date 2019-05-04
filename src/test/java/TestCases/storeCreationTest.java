package TestCases;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cimbui.TestBase.TestBase;
import cimbui.Util.TestUtil;
import cimbui.Pages.HomePage;
import cimbui.Pages.LoginPage;
import cimbui.Pages.merchantApprove;
import cimbui.Pages.storeCreation;
public class storeCreationTest  extends TestBase {
	storeCreation storeCreations;
	

		
		cimbui.Pages.LoginPage loginPage;
		 HomePage homePage;
		merchantApprove merApp;
		
		TestUtil testUtil;
		

		public storeCreationTest() {
			super();
		}


	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser

	@BeforeTest
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
		 Assert.assertEquals("Merchant Created Successfully and Request has been sent for Approval",HomePage.merchant_creation_msg);
			
		 driver.close();
		
		 
			
		 
		
	}

	@Test(priority=2)
	public void approveMerchant() throws InterruptedException{
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		 
		 merApp = loginPage.login1(prop.getProperty("username1"), prop.getProperty("password1"));
			merApp.approveMerchant();
			Assert.assertEquals("Merchant Approved Successfully with MerchantID",merchantApprove.merchant_approve_msg);
}
	
	@Test(priority=3)
	public void createStore() throws InterruptedException {
		System.out.println("ok");
		storeCreation strCreate = new storeCreation();
		strCreate.createStore();
		Assert.assertEquals("Store Created Successfully and Request has been sent for Approval",storeCreation.store_creation_msg);
			}
	}

	


