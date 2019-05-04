package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cimbui.Pages.LoginPage;

import cimbui.Pages.ruleCreation;
import cimbui.Pages.storeApprove;
import cimbui.TestBase.TestBase;
import cimbui.Util.TestUtil;

public class ruleCreationTest extends TestBase {

	TestUtil testUtil;
	cimbui.Pages.LoginPage loginPage;
	storeApprove strApp;

	public ruleCreationTest() {
		super();
	}

	@BeforeTest
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();

		loginPage = new LoginPage();
		// homePage = loginPage.login(prop.getProperty("username"),
		// prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void approveStore() throws InterruptedException {
		testUtil = new TestUtil();
		loginPage = new LoginPage();

		strApp = loginPage.login2(prop.getProperty("username"),
				prop.getProperty("password"));
		// strApp.storeApprve();
	}

	@Test(priority = 2)
	public void ruleCreate() throws InterruptedException {
		ruleCreation tidreg1 = new ruleCreation();
		tidreg1.createRule();
		Assert.assertEquals(tidreg1.rulename1,
				"Rule is successfuly sent for approval. Rule Name: "
						+ ruleCreation.approverule + ".xml");
		// homePage = loginPage.login(prop.getProperty("username"),
		// prop.getProperty("password"));

	}
}
