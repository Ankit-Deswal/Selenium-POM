package cimbui.Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import cimbui.TestBase.TestBase;

public class ruleAssociation extends TestBase {
	
 public static 	String suceesmsgassociation;

	@FindBy(xpath = "/html/body/form/div[2]/aside/section/ul/li[4]/a/span[1]")
	WebElement fileManagement;

	@FindBy(id = "FileSearchLI")
	WebElement FileSearch;
	
	@FindBy(id = "FileTypeRadioButton")
	WebElement FileType;


	@FindBy(id = "ContentPlaceHolder1_TextFileName")
	WebElement FileName;
	
	
	@FindBy(id = "Button1")
	WebElement searchFile;

	@FindBy(id = "ContentPlaceHolder1_RewardGridView_HyperLink4_0")
	WebElement Association;

	
	@FindBy(name = "ctl00$ContentPlaceHolder1$SearchCategory")
	WebElement AssociationSearchCategory;

	@FindBy(id = "ContentPlaceHolder1_Button3")
	WebElement searchPOS;
	@FindBy(name = "ctl00$ContentPlaceHolder1$StartDateTimeSingleRule")
	WebElement AssociationStartDate;
	
	
	@FindBy(name = "ctl00$ContentPlaceHolder1$ExpiryDateSingleRule")
	WebElement AssociationEndDate;
	@FindBy(name = "ctl00$ContentPlaceHolder1$SearchCategory")
	WebElement SearchCategory;

	@FindBy(id = "TextTerminalId")
	WebElement ClientIdforRuleAssociation;

	@FindBy(name = "ctl00$ContentPlaceHolder1$ProductIssuerGroupListTB")
	WebElement PGIGforRuleAssociation;

	@FindBy(xpath = "/html/body/form/div[2]/div[1]/div[2]/div/div[15]/div[2]/div/select/option")
	WebElement POSSelectionforRule;

	@FindBy(id = "ContentPlaceHolder1_AssociationTerminal")
	WebElement ApplyAssociation;
	
	
	
	@FindBy(xpath = "//*[@id='MessageTerminal']")
	WebElement Successmsg;
	
	
	
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[2]/dl/dd[3]/div/span/input")
	WebElement calenderendtime;
	
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_TableRowDateSelection']/div[2]/div/a/img")
	WebElement calenderenddate;

	public ruleAssociation() {
		PageFactory.initElements(driver, this);
	}

	public void ApplyRule() throws InterruptedException {
		Thread.sleep(1000);
		fileManagement.click();
		Thread.sleep(1000);
		FileSearch.click();
		
		Select filetypeasso = new Select(FileType);
		filetypeasso.selectByValue("Add On");
		
		Thread.sleep(1000);
		Select searchtypesel = new Select(AssociationSearchCategory);
		searchtypesel.selectByValue("File");
		System.out.println(ruleCreation.approverule);
		FileName.sendKeys(ruleCreation.approverule);
		//FileName.sendKeys("BANK EMI on CITI.xml");
		searchFile.click();
		Association.click();
		Thread.sleep(1000);
		
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			
			driver.switchTo().window(winHandle);
			// driver.findElement(By.name("ctl00$ContentPlaceHolder1$ApproveBtn")).click();
		}
		Select filetype = new Select(SearchCategory);
		filetype.selectByValue("Pos");
		
	ClientIdforRuleAssociation.sendKeys(createTerminal.clientid);
	//ClientIdforRuleAssociation.sendKeys("105784");
		searchPOS.click();
		Thread.sleep(1000);
		PGIGforRuleAssociation.sendKeys("cimb_ipp");
		
		Calendar cal = Calendar.getInstance();

		Date date = cal.getTime();

		DateFormat dateFormatdate = new SimpleDateFormat("dd/MM/yyyy");

		String formattedDate = dateFormatdate.format(date);
		String day = formattedDate.substring(0, 2);
        System.out.println(day);
		Thread.sleep(1500);
		driver.findElement(
				By.xpath("//*[@id='ContentPlaceHolder1_TableRowDateSelection']/div[1]/div/a/img"))
				.click();
		Thread.sleep(1500);
		driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/dl/dd[2]/div/span/a[1]/span/span")).click();
		//driver.findElement(
				//By.xpath("//*[@id='ui-datepicker-div']/div[2]/dl/dd[2]/div/span/input")).clear();
		
		//driver.findElement(
				//By.xpath("//*[@id='ui-datepicker-div']/div[2]/dl/dd[2]/div/span/input")).sendKeys("10");
		calenderendtime.clear();
		calenderendtime.sendKeys("56");
	
		WebElement calElement2 = calenderenddate;
		calElement2.click();
		
		Thread.sleep(1000);

		WebElement years = driver.findElement(By
				.xpath("//*[@id='ui-datepicker-div']/div[1]/div/select[2]"));

		Select iss5 = new Select(years);
		iss5.selectByValue("2020");
		//By calendarXpath1 = By
				//.xpath("//td[not(contains(@class,'ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all'))]/a[text()='"
					//	+ day + "']");
		Thread.sleep(2000);

		//driver.findElement(calendarXpath1).click();
		driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/dl/dd[3]/div/span/input")).sendKeys("50");
		
		POSSelectionforRule.click();
		ApplyAssociation.click();
	
		
			// driver.findElement(By.name("ctl00$ContentPlaceHolder1$ApproveBtn")).click();
	
		
		
			// driver.findElement(By.name("ctl00$ContentPlaceHolder1$ApproveBtn")).click();
		
		
		Thread.sleep(2000);
		suceesmsgassociation =Successmsg.getText();
		System.out.println("message associateion"+suceesmsgassociation);
		driver.close();
		}
	}


