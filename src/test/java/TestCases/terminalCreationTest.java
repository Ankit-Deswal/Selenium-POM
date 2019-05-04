package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cimbui.Pages.HomePage;
import cimbui.Pages.LoginPage;
import cimbui.Pages.createTerminal;
import cimbui.Pages.merchantApprove;

import cimbui.Pages.storeApprove;
import cimbui.Pages.storeCreation;
import cimbui.TestBase.TestBase;
import cimbui.Util.TestUtil;

public class terminalCreationTest extends TestBase {
	storeCreation storeCreations;
	storeApprove strApp;

	cimbui.Pages.LoginPage loginPage;
	HomePage homePage;
	merchantApprove merApp;

	TestUtil testUtil;

	public terminalCreationTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeTest
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();

		loginPage = new LoginPage();
		// homePage = loginPage.login(prop.getProperty("username"),
		// prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void createMerchant() throws InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"),
				prop.getProperty("password"));
		homePage.createMerchant();
		Assert.assertEquals("Pos Creation On Hub Successful For Terminal ID",
				createTerminal.POS_creation_msg);

	}

	@Test(priority = 2)
	public void approveMerchant() throws InterruptedException {
		testUtil = new TestUtil();
		loginPage = new LoginPage();

		merApp = loginPage.login1(prop.getProperty("username1"),
				prop.getProperty("password1"));
		merApp.approveMerchant();

	}

	@Test(priority = 3)
	public void createStore() throws InterruptedException {
		System.out.println("ok");
		storeCreation strCreate = new storeCreation();
		strCreate.createStore();
	}

	@Test(priority = 4)
	public void approveStore() throws InterruptedException {
		testUtil = new TestUtil();
		loginPage = new LoginPage();

		strApp = loginPage.login2(prop.getProperty("username"),
				prop.getProperty("password"));
		strApp.storeApprve();
	}

	@Test(priority = 5)
	public void terminalCreationt() throws InterruptedException {

		createTerminal terminal = new createTerminal();
		terminal.TerminalCreation();

	}

}
