package cimbui.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import cimbui.Util.TestUtil;

public class TestBase {
	public static String merchantNametxt;
	public static String storeNametext;
	public static String cimbtid;
	public static String cimbdebittid;
	public static String sinopaytid;
	public static String sinopaymid;
	public static String issuerGroup;
	public static String rulename;
	public static String schemename;
	public static WebDriver driver;
	public static Properties prop;
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:/selenium/workspace/CIMBUITest"+ "/src/main/java/cimbui"
					+ "/configProperties/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		merchantNametxt = prop.getProperty("merchantName");
		storeNametext = prop.getProperty("storeName");
		cimbtid = prop.getProperty("cimbtid");
		cimbdebittid = prop.getProperty("cimbdebittid");
		sinopaytid = prop.getProperty("sinopaytid");
		sinopaymid = prop.getProperty("sinopaymid");
		issuerGroup = prop.getProperty("issuergroup");
		rulename = prop.getProperty("rulename");
		schemename = prop.getProperty("schemename");
	
		if(browserName.equals("chrome")){
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--enable-features=VizDisplayCompositor");
			//options.addArguments("--disable-features=VizDisplayCompositor");
			//options.addArguments("--incognito"); 
			options.addArguments("enable-automation"); 
			//options.addArguments("--headless"); 
			options.addArguments("--no-sandbox"); 
			options.addArguments("--window-size=1920,1080"); 
			options.addArguments("--disable-gpu"); 
			options.addArguments("--disable-extensions"); 
			options.addArguments("--dns-prefetch-disable"); 
			options.addArguments("--disable-browser-side-navigation" ); 
			
		
			System.setProperty("webdriver.chrome.driver", "C://Users/ankit.deswal/Downloads/chromedriver/chromedriver.exe");	
			driver = new ChromeDriver(options); 
			
			
			
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C://Users/ankit.deswal/Downloads/geckodriver/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		

	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	
	}
}
