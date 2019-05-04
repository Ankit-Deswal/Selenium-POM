package cimbui.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cimbui.TestBase.TestBase;

public class LoginPage extends TestBase {
	// Page factory

	@FindBy(id = "UserNameTB")
	WebElement username;

	@FindBy(id = "PwdTB")
	WebElement password;
	
	
	@FindBy(id = "CaptchaText")
	WebElement captcha;
	@FindBy(name = "logindiv")
	WebElement lgnbtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String un, String pwd) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		captcha.sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.name("logindiv")).click();
		return new HomePage();
	}

	public merchantApprove login1(String un, String pwd)
			throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		captcha.sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.name("logindiv")).click();
		return new merchantApprove();
	}

	public storeApprove login2(String un, String pwd)
			throws InterruptedException {
		// Thread.sleep(2000);
		username.sendKeys(un);
		password.sendKeys(pwd);
		captcha.sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.name("logindiv")).click();
		return new storeApprove();
	}
}
