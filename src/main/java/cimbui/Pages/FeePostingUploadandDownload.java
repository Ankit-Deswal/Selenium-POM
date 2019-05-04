package cimbui.Pages;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cimbui.TestBase.TestBase;
public class FeePostingUploadandDownload extends TestBase  {
	static public String FileUploadmsgtrim;
	public String FileUploadmsgtrimID;
	
	@FindBy(xpath="//*[@id='MiscellaneousAndUpload']")
	WebElement Misc;
	//*[@id="MiscellaneousAndUpload"]
	
	@FindBy(xpath="/html/body/form/div[2]/aside/section/ul/li[8]/ul/li[3]/a")
	WebElement uploadanddownload;
	
	//*[@id="MiscellaneousUploadLI"]
	@FindBy(xpath="/html/body/form/div[2]/aside/section/ul/li[8]/ul/li[3]/ul/li[2]/a")
	WebElement Miscupload;
	
	@FindBy(id="OperationType")
	WebElement UploadType;

	
	@FindBy(id="SubmitBtn")
	WebElement SubmitFile;
	

	@FindBy(id="TB_Dnld_FileName")
	WebElement downloadtext;
	
	@FindBy(id="ContentPlaceHolder1_Button2")
	WebElement Submitdnld;
	
	
	public FeePostingUploadandDownload() {
		PageFactory.initElements(driver, this);
	}
	
	public void UploadFile() throws InterruptedException{
		
		Misc.click();
		Thread.sleep(2000);
		uploadanddownload.click();
		Thread.sleep(2000);
		Miscupload.click();
		
		Select filetype = new Select(UploadType);
		filetype.selectByValue("25");
		driver.findElement(By.id("ExcelID")).sendKeys("D:/Sample_FeePostingMappingauto.xlsx");
		String winHandleparent = driver.getWindowHandle();

		SubmitFile.click();
		
		Thread.sleep(2000);
		String winHandleBefore = driver.getWindowHandle();
		driver.switchTo().window(winHandleBefore);

		String FileUploadmsg= driver.findElement(By.xpath("/html/body/section[1]/div/article/p")).getText();
		FileUploadmsgtrim = FileUploadmsg.substring(0,33);
		FileUploadmsgtrimID = FileUploadmsg.substring(47,FileUploadmsg.length());
		System.out.print(FileUploadmsgtrimID);
		driver.findElement(By.id("alertify-ok")).click();
		driver.switchTo().window(winHandleparent);
	
		/*WebDriverWait wait = new WebDriverWait(driver, 50);
		 wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String FileUploadmsg = alert.getText();
		FileUploadmsgtrim = FileUploadmsg.substring(0, 33);
		System.out.print(FileUploadmsgtrim);*/
		
		
	}
	//download file after 1 min
	public void DownloadFile() throws InterruptedException{
		Thread.sleep(8000);
		downloadtext.sendKeys(FileUploadmsgtrimID);
		Submitdnld.click();
		
	}

}
