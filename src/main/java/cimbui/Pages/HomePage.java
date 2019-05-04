package cimbui.Pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import cimbui.TestBase.TestBase;

public class HomePage extends TestBase {
	public static String merchantNamestore;
	public static String merchant_creation_msg;

	@FindBy(xpath = ".//*[@id='MerchantNodeLi']/a")
	@CacheLookup
	WebElement merchant;

	@FindBy(xpath = ".//*[@id='MerchantManagement']/a/span[1]")
	WebElement contactCreateMerchantsLink;

	@FindBy(xpath = ".//*[@id='CreateMerchantLI']/a")
	WebElement regustermerchant;

	@FindBy(name = "ctl00$ContentPlaceHolder1$TextBoxDisplayNameIDMerchantName")
	WebElement merchantName;

	@FindBy(name = "ctl00$ContentPlaceHolder1$TextBoxaddress1IDMerchantPanel")
	WebElement merchantAddress1;
	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlCountry")
	WebElement country;

	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlState")
	WebElement merchantState;

	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlCity")
	WebElement merchantCity;

	@FindBy(name = "ctl00$ContentPlaceHolder1$TextBoxpinIDMerchantPanel")
	WebElement merchantPin;

	@FindBy(name = "ctl00$ContentPlaceHolder1$MerchantPrimaryContactName")
	WebElement merchantPrimaryContactname;
	@FindBy(name = "ctl00$ContentPlaceHolder1$TextBoxphone_numberIDMerchantPanel")
	WebElement merchantPrimaryPhoneno;
	@FindBy(name = "ctl00$ContentPlaceHolder1$TextBoxmobile_numberIDMerchantPanel")
	WebElement merchantPrimaryMobileNo;
	@FindBy(name = "ctl00$ContentPlaceHolder1$TextBoxemailIDMerchantPanel")
	WebElement merchantPrimaryEmail;

	@FindBy(name = "ctl00$ContentPlaceHolder1$ButtonCreateMerchant")
	WebElement merchantCreatebtn;

	@FindBy(id = "ContentPlaceHolder1_ClosePopup")
	WebElement merchantCreatepopup;
     
	@FindBy(xpath = "/html/body/form/div[2]/div[1]/div[5]/div/div[1]/div[3]/div/label/span[1]/i")
	WebElement addoncheck;

	@FindBy(id = "ContentPlaceHolder1_HubMessageID")
	WebElement merchantCreatepopupText;
	
	
	@FindBy(id = "BankNameDDL")
	WebElement AddonBank;
	
	@FindBy(id = "AccountNumberTB")
	WebElement Addonaccno;
	
	@FindBy(id = "BankIFCSCodeTB")
	WebElement AddonSwift;
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void createMerchant() throws InterruptedException {
		Thread.sleep(3000);
		merchant.click();
		Thread.sleep(3000);
		contactCreateMerchantsLink.click();
		Thread.sleep(3000);
		regustermerchant.click();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10);

		merchantName.sendKeys(merchantNametxt + randomInt);
		merchantNamestore = merchantNametxt + randomInt;
		merchantAddress1.sendKeys("MALAYSIA");
		Select contry = new Select(country);
		contry.selectByVisibleText("Malaysia");
		Select state = new Select(merchantState);
		state.selectByVisibleText("Johor");
		Select city = new Select(merchantCity);
		city.selectByVisibleText("Batu Pahat");
		merchantPin.sendKeys("12345");
		merchantPrimaryContactname.sendKeys("ankit");
		merchantPrimaryPhoneno.sendKeys("12345678");
		merchantPrimaryMobileNo.sendKeys("1234506789");
		merchantPrimaryEmail.sendKeys("abc@gmail.com");
		

		addoncheck.click();
		Select bankaddon =new Select(AddonBank);
		bankaddon.selectByValue("1005");
		Addonaccno.sendKeys("21354848645151");
		AddonSwift.sendKeys("CIBBMYKL");
		
		
		merchantCreatebtn.click();
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			// driver.findElement(By.name("ctl00$ContentPlaceHolder1$ApproveBtn")).click();
		}
		Thread.sleep(2000);
		String merchant_creation_msgfull = merchantCreatepopupText.getText();
		merchant_creation_msg = merchant_creation_msgfull.substring(0, 68);
		System.out.println(merchant_creation_msgfull);
		merchantCreatepopup.click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("/html/body/form/div[2]/header/nav/div[2]/ul/li/a/span"))
				.click();
		Thread.sleep(1000);
		driver.switchTo().window(winHandleBefore);
		driver.findElement(By.id("Logout")).click();
		// String mer = merchantCreatepopup.getText();
		// System.out.println("my" + mer);

		// merchantCreatepopup.getText();
		// merchantCreatepopup.click();
		Thread.sleep(2000);

	}

}
