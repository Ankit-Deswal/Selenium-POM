package cimbui.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cimbui.TestBase.TestBase;

public class storeApprove extends TestBase {
	public static String store_approver_msg;

	@FindBy(xpath = ".//*[@id='MerchantNodeLi']/a")
	WebElement merchantManage;
	@FindBy(xpath = "/html/body/form/div[2]/aside/section/ul/li[2]/ul/li[2]/a")
	WebElement store;
	@FindBy(xpath = "/html/body/form/div[2]/aside/section/ul/li[2]/ul/li[2]/ul/li[2]/a")
	WebElement storeApp;
	@FindBy(name = "ctl00$ContentPlaceHolder1$MNameTB")
	WebElement storeMerchantApproveName;
	@FindBy(name = "ctl00$ContentPlaceHolder1$SearchMerchantBtn")
	WebElement storeApproveSearch;
	@FindBy(id = "ContentPlaceHolder1_StoreGV_StoreDetailLB_0")
	WebElement storegridview1;
	@FindBy(name = "ctl00$ContentPlaceHolder1$ApproveBtn")
	WebElement storeApprovebtn;
	@FindBy(name = "ctl00$ContentPlaceHolder1$ButtonOKApprove")
	WebElement storeApprovepopup;

	@FindBy(id = "ContentPlaceHolder1_HubMessageID")
	WebElement storeApprovepopuptext;

	public storeApprove() {
		PageFactory.initElements(driver, this);
	}

	public void storeApprve() throws InterruptedException {
		String mName = HomePage.merchantNamestore;
		merchantManage.click();
		Thread.sleep(1500);
		store.click();
		Thread.sleep(1500);
		storeApp.click();
		Thread.sleep(1500);
		storeMerchantApproveName.sendKeys(mName);
		Thread.sleep(1500);
		storeApproveSearch.click();

		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(1500);
		storegridview1.click();
		Thread.sleep(1500);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);

		}
		Thread.sleep(2000);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		storeApprovebtn.click();
		Thread.sleep(1500);
		storeApprovepopup.click();
		String store_approver_msgfull = storeApprovepopuptext.getText();
		store_approver_msg = store_approver_msgfull.substring(0, 40);

		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(3000);
	}
}
