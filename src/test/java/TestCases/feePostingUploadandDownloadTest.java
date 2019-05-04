package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cimbui.TestBase.TestBase;

import cimbui.Pages.FeePostingUploadandDownload;

import cimbui.Pages.LoginPage;

import cimbui.Pages.storeApprove;

public class feePostingUploadandDownloadTest extends TestBase {
	cimbui.Pages.LoginPage loginPage;
	storeApprove strApp;

	public feePostingUploadandDownloadTest() {
		super();
	}

	@BeforeTest
	public void setUp() throws InterruptedException {
		initialization();

		loginPage = new LoginPage();
		strApp = loginPage.login2(prop.getProperty("username"),
				prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void uploadFeePostingFile() throws InterruptedException {
		FeePostingUploadandDownload tidreg1 = new FeePostingUploadandDownload();
		tidreg1.UploadFile();
		Assert.assertEquals("Upload request has been submitted",
				FeePostingUploadandDownload.FileUploadmsgtrim);
		tidreg1.DownloadFile();
		// Assert.assertTrue(isFileDownloaded_Ext(downloadPath, ".xls")

		// strApp.storeApprve();
	}
}