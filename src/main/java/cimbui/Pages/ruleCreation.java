package cimbui.Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import cimbui.TestBase.TestBase;

public class ruleCreation extends TestBase {
	public String rulename1;
	public String rulename2;
	static public String approverule;

	@FindBy(id = "IPP")
	WebElement IPPtab;

	@FindBy(id = "Tools")
	WebElement toolsTab;

	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_Table1']/div[2]/div[1]/label")
	WebElement label;

	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_ProgramTypeTV']")
	WebElement programType;

	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_ProgramTypeTable']/div/div/div[3]/button")
	WebElement pgTypeTable;

	@FindBy(id = "BANK_ONUS_IPP_PT")
	WebElement rulep;

	@FindBy(id = "AddSchema")
	WebElement addSchema;

	@FindBy(xpath = "//*[@id='BANK_ONUS_IPP_SCHEMA_0SCHEMA_0']")
	WebElement schemaDetails;

	@FindBy(name = "ctl00$ContentPlaceHolder1$RuleNameTB")
	WebElement ruleName;

	@FindBy(xpath = "/html/body/form/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div/div/div[2]/div/a/img")
	WebElement calenderstartdate;

	@FindBy(xpath = "/html/body/form/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div/div/div[3]/div/a/img")
	WebElement calenderenddate;

	@FindBy(xpath = "/html/body/div[2]/div[2]/dl/dd[3]/div/span/input")
	WebElement calenderendtime;

	@FindBy(name = "ctl00$ContentPlaceHolder1$SchemaDisplayNameTB")
	WebElement schemaDisplayName;
	@FindBy(name = "ctl00$ContentPlaceHolder1$MinAmountTB")
	WebElement minAmount;
	@FindBy(name = "ctl00$ContentPlaceHolder1$MaxAmountTB")
	WebElement maxAmount;
	@FindBy(name = "ctl00$ContentPlaceHolder1$IssuerBinRangeGroupDDL")
	WebElement issuergroup;

	@FindBy(name = "ctl00$ContentPlaceHolder1$EMIParamsLB")
	WebElement emiMonth;

	@FindBy(id = "RuleStartHrDTPickerTB")
	WebElement rulestartdate;

	@FindBy(id = "RuleEndHrDTPickerTB")
	WebElement ruleenddate;

	public ruleCreation() {
		PageFactory.initElements(driver, this);
	}

	public void createRule() throws InterruptedException {

		IPPtab.click();
		toolsTab.click();

		Thread.sleep(1000);
		driver.findElement(By.id("AddOnRulePage")).click();
		Thread.sleep(2000);
		label.click();
		Thread.sleep(2000);
		WebElement rule = programType;
		Select rules = new Select(rule);
		rules.selectByValue("105");
		pgTypeTable.click();
		Thread.sleep(2000);

		Actions oAction = new Actions(driver);
		oAction.moveToElement(rulep);
		oAction.contextClick(rulep).build().perform(); /*
														 * this will perform
														 * right click
														 */
		WebElement elementOpen = addSchema; /*
											 * This will select menu after right
											 * click
											 */
		elementOpen.click();
		Thread.sleep(2000);

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);

		schemaDetails.click();
		rulename2 = "Ruluiuoo1" + randomInt;
		ruleName.sendKeys(TestBase.rulename + randomInt);
		// elementOpen.click();

		WebElement calElement = calenderstartdate;
		calElement.click();

		Calendar cal = Calendar.getInstance();

		Date date = cal.getTime();

		DateFormat dateFormatdate = new SimpleDateFormat("dd/MM/yyyy");

		String formattedDate = dateFormatdate.format(date);
		String day = formattedDate.substring(0, 2);

		Thread.sleep(1500);
		driver.findElement(
				By.xpath("/html/body/div[2]/div[2]/dl/dd[2]/div/span/a[1]/span/span"))
				.click();
		calenderendtime.clear();
		calenderendtime.sendKeys("55");
		Thread.sleep(1500);
		
		//By calendarXpath = By
			//.xpath("//td[not(contains(@class,'ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all'))]/a[text()='"
				//	+ day + "']");
		//driver.findElement(calendarXpath).click();
		WebElement calElement2 = calenderenddate;
		calElement2.click();

		Thread.sleep(1000);

		WebElement years = driver.findElement(By
				.xpath("/html/body/div[2]/div[1]/div/select[2]"));

		Select iss5 = new Select(years);
		iss5.selectByValue("2021");
		//By calendarXpath1 = By
				//.xpath("//td[not(contains(@class,'ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all'))]/a[text()='"
				//		+ day + "']");
		Thread.sleep(2000);
		//*[@id="ui-datepicker-div"]/div[2]/dl/dd[3]/div/span/input
		//driver.findElement(calendarXpath1).click();
		driver.findElement(By
				.xpath("//*[@id='ui-datepicker-div']/div[2]/dl/dd[3]/div/span/input")).sendKeys("55");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String rulestart = (String) jse.executeScript(
				"return arguments[0].value;", rulestartdate);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		String ruleend = (String) jse1.executeScript(
				"return arguments[0].value;", ruleenddate);
		System.out.println(rulestart);
		System.out.println(ruleend);
		calElement2.click();
		schemaDisplayName.sendKeys(TestBase.schemename + randomInt);
		minAmount.clear();
		Thread.sleep(1500);
		JavascriptExecutor runJS= ((JavascriptExecutor) driver);
		runJS.executeScript("arguments[0].value='0000001.00';", minAmount);
		//minAmount.sendKeys("0000001.00");
		maxAmount.clear();
		Thread.sleep(1500);
		JavascriptExecutor runJS1= ((JavascriptExecutor) driver);
		runJS1.executeScript("arguments[0].value='9000000.00';", maxAmount);
		//maxAmount.sendKeys("9000000.00");
		Thread.sleep(1500);
		Select iss = new Select(issuergroup);
		iss.selectByValue("660");
		Select iss1 = new Select(emiMonth);
		iss1.selectByValue("3");
		driver.findElement(By.xpath("//*[@id='3Month']")).click();
		WebElement min1 = driver.findElement(
				By.name("ctl00$ContentPlaceHolder1$EMI_PARAMS_MIN_AMOUNT_TB"));
				min1.clear();
		//driver.findElement(
				//By.name("ctl00$ContentPlaceHolder1$EMI_PARAMS_MIN_AMOUNT_TB"))
				//.sendKeys("0000001.00");
				JavascriptExecutor runJS2= ((JavascriptExecutor) driver);
				runJS2.executeScript("arguments[0].value='0000001.00';", min1);
				WebElement max1 = driver.findElement(
						By.name("ctl00$ContentPlaceHolder1$EMI_PARAMS_MAX_AMOUNT_TB"));
						max1.clear();
						JavascriptExecutor runJS4= ((JavascriptExecutor) driver);
						runJS4.executeScript("arguments[0].value='9000000.00';", max1);
	
				
		driver.findElement(By.name("ctl00$ContentPlaceHolder1$EMIParamSaveBtn"))
				.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();

		Thread.sleep(2000);
		driver.findElement(By.id("alertify-ok")).click();

		driver.findElement(By.name("ctl00$ContentPlaceHolder1$CreateXMLBtn"))
				.click();
		Thread.sleep(2000);
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(2000);

		alert2.accept();

		Thread.sleep(2000);

		Thread.sleep(2000);
		rulename1 = driver.findElement(
				By.xpath("//*[@id='alertify']/div/article/p")).getText();
		driver.findElement(By.id("alertify-ok")).click();
		driver.findElement(
				By.xpath("/html/body/form/div[2]/header/nav/div[2]/ul/li/a/span"))
				.click();

		System.out.println(rulename1);
		approverule = rulename1.substring(50, rulename1.length());
		System.out.println(approverule);
		Thread.sleep(3000);
		driver.findElement(By.id("Logout")).click();
	}
}
