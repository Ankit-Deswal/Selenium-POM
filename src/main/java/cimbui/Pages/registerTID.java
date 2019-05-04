package cimbui.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import cimbui.TestBase.TestBase;

public class registerTID extends TestBase {
	public int count = 0;
	public static String TID_SUCCESS_MSG;
	@FindBy(xpath = "/html/body/form/div[2]/aside/section/ul/li[4]/a/span[1]")
	WebElement fileManagement;

	@FindBy(id = "ManageTerminalLi")
	WebElement manage;

	@FindBy(name = "ctl00$ContentPlaceHolder1$SearchTypeDDL")
	WebElement clientdrpdwn;
	@FindBy(name = "ctl00$ContentPlaceHolder1$InputTB")
	WebElement clientidtxt;
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_UpdatePanel1']/div[1]/div/div[3]/div")
	WebElement searchBtn;
	@FindBy(id = "ContentPlaceHolder1_TabContainer1_GridView_PosGV_RegisterBankLB_0")
	WebElement regTid;

	@FindBy(name = "ctl00$ContentPlaceHolder1$TextBoxBankTIDBankPanel")
	WebElement TidNo;
	@FindBy(name = "ctl00$ContentPlaceHolder1$DropDownBankNameBankPanel")
	WebElement bankName;
	@FindBy(name = "ctl00$ContentPlaceHolder1$DropDownListTerminalType")
	WebElement terminalType;

	@FindBy(name = "ctl00$ContentPlaceHolder1$ButtonCreateBank")
	WebElement saveTid;
	@FindBy(id = "alertify-ok")
	WebElement tidPopup;

	@FindBy(id = "ContentPlaceHolder1_FileUploadRevFile")
	WebElement uploadRev;

	@FindBy(xpath = "//*[@id='alertify']/div/article/p")
	WebElement poputidmsg;

	public registerTID() {
		PageFactory.initElements(driver, this);
	}

	public void tidRegister(String bankname) throws InterruptedException {

		System.out.println(createTerminal.clientid);
		String POSIDf = createTerminal.clientid;
		Thread.sleep(2000);

		if (count == 0) {
			count = count + 1;
			fileManagement.click();

		}
		manage.click();
		Thread.sleep(1000);

		Select clntdrp = new Select(clientdrpdwn);
		clntdrp.selectByValue("ClientId");

		clientidtxt.sendKeys(POSIDf);
		// clientidtxt.sendKeys("105774");
		searchBtn.click();
		regTid.click();
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(1500);

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);

		}
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("/html/body/form/div[2]/div[1]/div[2]/div/div/div[9]/div/div[1]/div/div[1]/div/div/div/label/span[1]/i"))
				.click();
		if (bankname.equalsIgnoreCase("CIMB")) {
			TidNo.sendKeys(cimbtid);
			Select bnkName = new Select(bankName);
			bnkName.selectByValue("1027");
			uploadRev.sendKeys("D:/Rev/CIMB/" + cimbtid + ".rev");
		} else if (bankname.equalsIgnoreCase("CIMBDEBIT")) {
			TidNo.sendKeys(cimbdebittid);
			Select bnkName = new Select(bankName);
			bnkName.selectByValue("1029");
			uploadRev.sendKeys("D:/Rev/CIMBDEBIT/" + cimbdebittid + ".rev");
		} else if (bankname.equalsIgnoreCase("SINOPAY")) {
			TidNo.sendKeys(sinopaytid);
			Select bnkName = new Select(bankName);
			bnkName.selectByValue("1027");
		}
		Select terminaltp = new Select(terminalType);
		terminaltp.selectByValue("0");
		Thread.sleep(1500);

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		saveTid.click();
		Thread.sleep(2000);

		String winHandleBefore2 = driver.getWindowHandle();

		Thread.sleep(1500);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			// driver.findElement(By.name("ctl00$ContentPlaceHolder1$ApproveBtn")).click();
		}
		String TID_SUCCESS_MSGfull = poputidmsg.getText();
		System.out.println(TID_SUCCESS_MSGfull);
		TID_SUCCESS_MSG = TID_SUCCESS_MSGfull.substring(0, 48);
		tidPopup.click();
		driver.switchTo().window(winHandleBefore2);
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(2000);

		Thread.sleep(1000);
		// driver.findElement(By.id("Logout")).click();

	}

}
