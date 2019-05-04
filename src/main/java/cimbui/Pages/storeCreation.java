package cimbui.Pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import cimbui.TestBase.TestBase;

public class storeCreation extends TestBase {
	
	public static String store_creation_msg;
	//merchantApprove MerName = new merchantApprove();
	//String value=merchantApprove.merchantName;
	@FindBy(xpath="/html/body/form/div[2]/aside/section/ul/li[2]/ul/li[2]/a")
	WebElement store;
	@FindBy(xpath="//*[@id='CreateStoreLi']/a")
	WebElement createStore;
	
	@FindBy(id="MNameTB")
	WebElement merchantNameforStore;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$SaerchMerchantBtn")
	WebElement searchMerchant;
	@FindBy(id="ContentPlaceHolder1_HyperLinkCreateStore")
	WebElement createStoreNew;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$TextBoxDisplayNameStorePanel")
	WebElement storeName;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$TextBoxStoreDescription")
	WebElement storeDesc;
	@FindBy(name="ctl00$ContentPlaceHolder1$TextBoxAddress1StorePanel")
	WebElement storeAddress;
	@FindBy(name="ctl00$ContentPlaceHolder1$ddlCountry")
	WebElement storeCountry;
	@FindBy(name="ctl00$ContentPlaceHolder1$ddlState")
	WebElement storeState;
	@FindBy(name="ctl00$ContentPlaceHolder1$ddlCity")
	WebElement storeCity;
	@FindBy(name="ctl00$ContentPlaceHolder1$TextBoxPinCodeStorePanel")
	WebElement storePin;
	@FindBy(name="ctl00$ContentPlaceHolder1$TextBoxContactPerson")
	WebElement storeContactName;
	@FindBy(name="ctl00$ContentPlaceHolder1$TextBoxPhoneNumberStorePanel")
	WebElement storePhnNumber;
	@FindBy(name="ctl00$ContentPlaceHolder1$MobileNoTB")
	WebElement storeMobNumber;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$TextBoxEmailIDStorePanel")
	WebElement storeEmail;
	@FindBy(name="ctl00$ContentPlaceHolder1$ButtonCreateStore")
	WebElement storeCreatebtn;
	@FindBy(name="ctl00$ContentPlaceHolder1$ClosePopup")
	WebElement storeCreatepopup;
	

			
	@FindBy(id="ContentPlaceHolder1_HubMessageID")
	WebElement storeCreatepopupText;
	
	
	
	@FindBy(xpath="html/body/form/div[2]/div[1]/div[2]/div[22]/div/div/div[1]/div/div/table/tbody/tr[2]/td[2]/label")
	WebElement BankEMI;
	public storeCreation() {
		PageFactory.initElements(driver, this);
	}
	
	public void createStore() throws InterruptedException{
		Thread.sleep(2000);
		System.out.println(HomePage.merchantNamestore);
		String mName = HomePage.merchantNamestore;
		//driver.findElement(By.xpath(".//*[@id='MerchantNodeLi']/a")).click();
		store.click();
		Thread.sleep(2000);
		createStore.click();
		Thread.sleep(2000);
		merchantNameforStore.sendKeys(mName);
		Thread.sleep(2000);
		searchMerchant.click();
		createStoreNew.click();
		Random randomGenerator = new Random();  
	    int randomInt = randomGenerator.nextInt(10);
		storeName.sendKeys(storeNametext+randomInt);	
				
		storeDesc.sendKeys(storeNametext+randomInt);	
		storeAddress.sendKeys("Malaysia");
		
		
		 Select contry = new Select(storeCountry);
		 contry.selectByVisibleText("Malaysia");
		 Select state = new Select(storeState);
		 state.selectByVisibleText("Johor");
		 Select city = new Select(storeCity);
		 city.selectByVisibleText("Batu Pahat");
		
		storePin.sendKeys("12345");
		storeContactName.sendKeys("ankit");
		storePhnNumber.sendKeys("12345678");
		storeMobNumber.sendKeys("9999999999");
		storeEmail.sendKeys("abc@gmail.com");
		BankEMI.click();
		storeCreatebtn.click();
		Thread.sleep(2000);
		String store_creation_msgfull=storeCreatepopupText.getText();
		store_creation_msg=store_creation_msgfull.substring(0,65);
		storeCreatepopup.click();
		
		Thread.sleep(3000);
	    driver.findElement(By.xpath("/html/body/form/div[2]/header/nav/div[2]/ul/li/a/span")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("Logout")).click();
		
		
	}
	
	 
	 
	 }
