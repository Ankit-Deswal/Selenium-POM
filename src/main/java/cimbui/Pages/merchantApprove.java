package cimbui.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cimbui.TestBase.TestBase;

public class merchantApprove extends TestBase {

	public static String merchant_approve_msg;

	@FindBy(xpath = ".//*[@id='MerchantNodeLi']/a")
	WebElement merchantManage;

	@FindBy(xpath = ".//*[@id='MerchantManagement']/a/span[1]")
	WebElement merchant;
	@FindBy(id = "ApproveMerchantLI")
	WebElement merchantApprove;
	@FindBy(id = "SearchAllMerchantBtn")
	WebElement merchantSearchAll;
	@FindBy(id = "ContentPlaceHolder1_MerchantGV_MerchantDetailLB_0")
	WebElement merchantgridview1;
	@FindBy(name = "ctl00$ContentPlaceHolder1$ApproveBtn")
	WebElement merchantApprovebtn;

	public merchantApprove() {
		PageFactory.initElements(driver, this);
	}

	public void approveMerchant() throws InterruptedException {

		merchantManage.click();
		Thread.sleep(3000);
		merchant.click();
		Thread.sleep(3000);
		merchantApprove.click();

		merchantSearchAll.click();
		Thread.sleep(3000);

		// waitForNewWindowAndSwitchToIt(driver);
		// String newTitle = getCurrentWindowTitle();
		// Thread.sleep(3000);
		// String handle= driver.getWindowHandle();

		// System.out.println(handle);

		// driver.switchTo().window(handle);
		// driver.switchTo().activeElement();
		// Thread.sleep(3000);

		// driver.findElement(By.id("ApproveBtn")).click();

		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(1500);
		merchantgridview1.click();
		Thread.sleep(1500);

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			// driver.findElement(By.name("ctl00$ContentPlaceHolder1$ApproveBtn")).click();
		}
		Thread.sleep(2000);
		// merchantName
		// =driver.findElement(By.id("TextBoxDisplayNameIDMerchantName")).getText();
		// System.out.println("okmer"+ merchantName);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		merchantApprovebtn.click();
		Thread.sleep(1000);

		// driver.findElement(By.name("ctl00$ContentPlaceHolder1$RejectionReasonTB")).sendKeys("Reject by script");
		// driver.findElement(By.name("ctl00$ContentPlaceHolder1$RejectionReasonBtn")).click();

		driver.findElement(By.id("ContentPlaceHolder1_ButtonOKApprove"))
				.click();
		String merchantID = driver.findElement(
				By.id("ContentPlaceHolder1_HubMessageID")).getText();
		String merchant_approve_msgfull = driver.findElement(
				By.id("ContentPlaceHolder1_HubMessageID")).getText();
		merchant_approve_msg = merchant_approve_msgfull.substring(0, 46);
		System.out.println(merchantID);
		// Thread.sleep(3000);
		// driver.findElement(By.id("alertify-ok")).click();
		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(3000);

	}

}
