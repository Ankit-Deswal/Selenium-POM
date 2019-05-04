package cimbui.Pages;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import cimbui.TestBase.TestBase;

public class createTerminal extends TestBase {
	public static String clientid;
	public static String POS_creation_msg;

	@FindBy(xpath = "/html/body/form/div[2]/aside/section/ul/li[2]/ul/li[3]/a/span[1]")
	WebElement terminal;
	@FindBy(id = "CreatePosLi")
	WebElement create;
	@FindBy(name = "ctl00$ContentPlaceHolder1$MNameTB")
	WebElement merchantNameforTerminal;
	@FindBy(id = "ContentPlaceHolder1_MerchantGV_HyperLinkRepName_0")
	WebElement createTerminal;
	@FindBy(name = "ctl00$ContentPlaceHolder1$SaerchMerchantBtn")
	WebElement searchMerchant;
	@FindBy(name = "ctl00$ContentPlaceHolder1$PVMDDL")
	WebElement pvm;
	@FindBy(name = "ctl00$ContentPlaceHolder1$hardwareTypeDDL")
	WebElement hardwareType;

	@FindBy(name = "ctl00$ContentPlaceHolder1$PonEDCDDL")
	WebElement printertype;

	@FindBy(name = "ctl00$ContentPlaceHolder1$DPWidth")
	WebElement printerWidth;

	@FindBy(name = "ctl00$ContentPlaceHolder1$HIdTB")
	WebElement hardwareSerialNumber;

	@FindBy(name = "ctl00$ContentPlaceHolder1$ButtonCreatePOS")
	WebElement terminalCreateFinal;

	@FindBy(name = "ctl00$ContentPlaceHolder1$ClosePopup")
	WebElement termialPopup;

	public createTerminal() {
		PageFactory.initElements(driver, this);
	}

	public void TerminalCreation() throws InterruptedException {

		terminal.click();
		Thread.sleep(1000);
		create.click();
		Thread.sleep(1000);
		String mName = HomePage.merchantNamestore;
		merchantNameforTerminal.sendKeys(mName);
		Thread.sleep(1000);
		searchMerchant.click();
		createTerminal.click();
		Select pvmTerminal = new Select(pvm);
		pvmTerminal.selectByIndex(4);

		Select hardware = new Select(hardwareType);
		hardware.selectByVisibleText("ICT220 INGENICO");

		Select printer = new Select(printertype);
		printer.selectByValue("1");
		Select printerWid = new Select(printerWidth);
		printerWid.selectByValue("24");
		Random rnd = new Random();
		int n = 1000000 + rnd.nextInt(900000000);
		String hw = String.valueOf(n);
		hardwareSerialNumber.sendKeys(hw);
		terminalCreateFinal.click();
		Thread.sleep(2000);
		String POS_creation_msgfull = driver.findElement(
				By.id("ContentPlaceHolder1_HubMessageID")).getText();
		System.out.println(POS_creation_msgfull);
		clientid = POS_creation_msgfull.substring(POS_creation_msgfull
				.lastIndexOf(" ") + 1);

		POS_creation_msg = POS_creation_msgfull.substring(0, 46);
		System.out.println(clientid);
		termialPopup.click();

	}
}
