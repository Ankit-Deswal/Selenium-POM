package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cimbui.Pages.HomePage;
import cimbui.Pages.LoginPage;
import cimbui.Pages.reinitliazeTIDtoolagg;
import cimbui.Pages.storeCreation;
import cimbui.TestBase.TestBase;
import cimbui.Util.TestUtil;

public class reinitiliaseTIDTest extends TestBase {
	
	cimbui.Pages.LoginPage loginPage;
	public HomePage homePage;
	TestUtil testUtil;
	

	public reinitiliaseTIDTest() {
		super();
	}




@BeforeMethod
public void setUp() throws InterruptedException {
	initialization();
	

	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
}

@Test(priority=1)
public void reinitialiseTID() throws InterruptedException{
	reinitliazeTIDtoolagg Tid = new reinitliazeTIDtoolagg();
	Tid.reinitilazetid();
	
	 driver.close();
	
	 
		
	 
	
}

}
