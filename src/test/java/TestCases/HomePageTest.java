package TestCases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cimbui.Pages.HomePage;
import cimbui.Pages.LoginPage;
import cimbui.TestBase.TestBase;
import cimbui.Util.TestUtil;




public class HomePageTest extends TestBase {
	cimbui.Pages.LoginPage loginPage;
	public HomePage homePage;
	TestUtil testUtil;
	

	public HomePageTest() {
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
	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
}


@Test(priority=1)
public void createMerchant() throws InterruptedException{
	 homePage.createMerchant();
	 loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
		Assert.assertEquals("Merchant Created Successfully and Request has been sent for Approval",HomePage.merchant_creation_msg);
	 
	
}







@AfterMethod
public void tearDown(){
	driver.quit();
}

}
