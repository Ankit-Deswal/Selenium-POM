package TestCases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;









import cimbui.Pages.HomePage;
import cimbui.Pages.LoginPage;
import cimbui.TestBase.TestBase;

public class loginTest extends TestBase {
	LoginPage LoginPage;
	HomePage homePage;
	public loginTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		LoginPage = new LoginPage();	
	}
	
	
	
	
	@Test(priority=1)
	public void LoginTest() throws InterruptedException{
		homePage=LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
