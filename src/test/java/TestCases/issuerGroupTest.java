package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cimbui.Pages.HomePage;
import cimbui.Pages.LoginPage;
import cimbui.TestBase.TestBase;
import cimbui.Pages.issuerGroup;


public class issuerGroupTest extends TestBase{
	cimbui.Pages.LoginPage loginPage;
	public HomePage homePage;
	
	public issuerGroupTest() {
		super();
	}



@BeforeMethod
public void setUp() throws InterruptedException {
	initialization();
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
	
}


@Test(priority=1)
public void createIssuerGroup() throws InterruptedException {
	
	issuerGroup ig =new issuerGroup();
	ig.createIssuerGrp();
	String Actual = "Issuer Group :"+TestBase.issuerGroup+ " Created Successfully";
	Assert.assertEquals(cimbui.Pages.issuerGroup.IGNAME,Actual);
	
	
}
	
	

}
