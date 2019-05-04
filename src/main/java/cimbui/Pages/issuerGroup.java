package cimbui.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import cimbui.TestBase.TestBase;

public class issuerGroup extends TestBase {
public static 	String IGNAME ;
@FindBy(id="GroupType")
WebElement ActionType;

@FindBy(id="SelectionType")
WebElement SelectFromMasterData;


@FindBy(id="BinTypeDDL")
WebElement bintype;

@FindBy(id="IssuerDropDown")
WebElement SelectIssuer;


@FindBy(id="ContentPlaceHolder1_LoadBinRangesBtn")
WebElement LoadBin;


@FindBy(id="SelectBinRange")
WebElement SelectBin;

@FindBy(id="IssuerGroupName")
WebElement IssuerGroupName;

@FindBy(id="IssuerGroupDescription")
WebElement IssuerDisc;



@FindBy(id="ContentPlaceHolder1_HubMessageID")
WebElement successMSG;


@FindBy(name="ctl00$ContentPlaceHolder1$SubmitBtn")
WebElement submitIG;



public issuerGroup() {
	PageFactory.initElements(driver, this);
}


public void createIssuerGrp() throws InterruptedException{
	Thread.sleep(2000);

			driver.findElement(
			By.xpath("/html/body/form/div[2]/aside/section/ul/li[5]/ul/li[2]/a/span[1]")).click();
			Thread.sleep(2000);
			driver.findElement(
			By.xpath("/html/body/form/div[2]/aside/section/ul/li[5]/ul/li[2]/ul/li[5]/a")).click();
	Select ActionTyp =new Select(ActionType);
	ActionTyp.selectByValue("1");
	
	Select ActionTyp2 =new Select(SelectFromMasterData);
	ActionTyp2.selectByValue("1");
	
	Select BinSelection =new Select(bintype);
	BinSelection.selectByValue("0");
	
	Select issuer =new Select(SelectIssuer);
	issuer.selectByValue("23");
	
	LoadBin.click();
	
	Select binSelect =new Select(SelectBin);
	binSelect.selectByValue("946");
	Thread.sleep(2000);
	IssuerGroupName.sendKeys(TestBase.issuerGroup);
	IssuerDisc.sendKeys(TestBase.issuerGroup);
	submitIG.click();
	
	IGNAME = successMSG.getText();
	System.out.println(IGNAME);
	
	
	driver.findElement(
			By.xpath("//*[@id='modal_displayMessage']/div/div/div[2]/button")).click();
	
	
	
}


}
