package com.dorman.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.dorman.qa.util.TestUtil;
import com.dorman.qa.util.WebEventListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
public static ExtentReports _extent_report;
	
	
	
	public static ExtentTest _test_logger;
	public static ExtentTest _test_logger1;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/dorman"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void Extentreports() {
		_extent_report= new ExtentReports(System.getProperty("user.dir") + File.separator
				+"TestRun"+TestUtil.currentdateinexactformat()+ "_DormanExtent.html"); 
		
		//_extent_report.loadConfig(ExtentReports.class, System.getProperty("user.dir") + "src\\main\\java\\com\\dorman\\qa\\config\\extent-config.xml");
		
    	_extent_report.loadConfig(new File( 
    			System.getProperty("user.dir") + "\\src\\main\\java\\com\\dorman\\qa\\config\\extentconfig.xml"));
    	System.out.println("tataji");
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\tyerubandhi\\Downloads\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\tyerubandhi\\Downloads\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
		
		driver.get(prop.getProperty("url1"));
		
		
		
			//driver.get(prop.getProperty("url2"));
		
		
	}
	
	
	
	
	
	
	
	

}
