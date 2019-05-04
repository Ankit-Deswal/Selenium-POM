package cimbui.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import cimbui.TestBase.TestBase;

public class reinitliazeTIDtoolagg extends TestBase {
	@FindBy(xpath="/html/body/form/div[2]/aside/section/ul/li[7]/a/span[1]")
	WebElement ToolsServices;
	
	@FindBy(xpath="/html/body/form/div[2]/aside/section/ul/li[7]/ul/li/a")
	WebElement Tools;
	
	@FindBy(id="toolAgg")
	WebElement Toolsagg;
	
	
	@FindBy(id="SearchType")
	WebElement SearchType;
	
	
	
	

	@FindBy(id="posIdReinitializeTxt")
	WebElement posId;

	@FindBy(id="configRenitializeTxt")
	WebElement TID;

	@FindBy(id="bankReinitializeDrpDwn")
	WebElement Bankname;

	@FindBy(id="ContentPlaceHolder1_OkBtn_ReinitializeTID")
	WebElement submit;
	public reinitliazeTIDtoolagg() {
		PageFactory.initElements(driver, this);
	}
	
	public void reinitilazetid() throws InterruptedException{
		
		ToolsServices.click();
		Thread.sleep(1000);
		Tools.click();
		Thread.sleep(1000);
		Toolsagg.click();
		Thread.sleep(1000);
		
		Select searchtype = new Select(SearchType);
		searchtype.selectByValue("11");
		Thread.sleep(1000);
		posId.sendKeys("105554");
		TID.sendKeys("22356200");
		
		Select bankName = new Select(Bankname);
		bankName.selectByValue("23");
		
		submit.click();
		Alert alertaccept1 = driver.switchTo().alert();
		alertaccept1.accept();
		
		
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);

		}
		String ankit = driver.findElement(By.xpath("/html/body/section[1]/div/article/p")).getText();
	
		System.out.println(ankit);
		 driver.findElement(By.id("alertify-ok")).click();
	}
	
	
}
