package cimbui.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cimbui.TestBase.TestBase;

public class ruleApprove extends TestBase {
	public String ruleapp;
	public static String ruleapprovetext;
	@FindBy(id = "IPP")
	WebElement IPPtab;

	@FindBy(id = "Tools")
	WebElement toolsTab;

	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_Table1']/div[2]/div[1]/label")
	WebElement label;

	@FindBy(xpath = "/html/body/form/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[3]/label")
	WebElement ruleapprove;

	@FindBy(id = "ContentPlaceHolder1_SearchToUpdTB")
	WebElement ruletobeapproved;

	@FindBy(id = "ContentPlaceHolder1_SearchToUpdBtn")
	WebElement searchrule;

	@FindBy(id = "ContentPlaceHolder1_CreateXMLBtn")
	WebElement approverulebtn;

	public ruleApprove() {
		PageFactory.initElements(driver, this);
	}

	public void approveRule() throws InterruptedException {
		IPPtab.click();
		toolsTab.click();

		Thread.sleep(1000);
		driver.findElement(By.id("AddOnRulePage")).click();
		Thread.sleep(2000);
		label.click();
		ruleapprove.click();
		// ruleCreation rule = new ruleCreation();
		ruleapp = ruleCreation.approverule;
		System.out.println(ruleapp);
		ruletobeapproved.sendKeys(ruleapp);
		searchrule.click();
		Alert alert = driver.switchTo().alert();

		alert.accept();

		Thread.sleep(2000);

		approverulebtn.click();
		Alert alertaccept = driver.switchTo().alert();
		alertaccept.accept();

		Thread.sleep(2000);
		ruleapprovetext = driver.findElement(
				By.xpath("/html/body/section[1]/div/article/p")).getText();
		driver.findElement(By.id("alertify-ok")).click();
		Thread.sleep(2000);
	}
}
