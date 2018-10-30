/*
 * @author Naveen Khunteta
 * 
 */

package com.dorman.qa.testcases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.dorman.qa.base.TestBase;
import com.dorman.qa.pages.DormanSearch;
import com.dorman.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DormanSearchPageTest extends TestBase{

	TestUtil testUtil;
	DormanSearch Dormanpage;
	public  ExtentTest MainParent;	
	 ExtentTest child1;
	 
	 ExtentTest child2;
 ExtentTest child3;
	 
	 ExtentTest child4;
 ExtentTest child5;
	 
	 ExtentTest child6;
 ExtentTest child7;
	 
	 ExtentTest child8;
 ExtentTest child9;
	 
	 ExtentTest child10;
 ExtentTest child11;
	 
	 ExtentTest child12; 
 ExtentTest child13;
	 
	 ExtentTest child14;
 ExtentTest child15;
	 
	 ExtentTest child16;
 ExtentTest child17;
	 
	 ExtentTest child18;
	 
	   
	public DormanSearchPageTest(){
			super();
			
	}

	
	
	
    @BeforeTest
	public void setUp() {
    	Extentreports();

		initialization();
		testUtil = new TestUtil();
		Dormanpage = new DormanSearch();
	
		
		
	 }
   
	@Test(priority=1,enabled=true)
	public void searhc(){
		_test_logger = _extent_report.startTest("DormanAutomation Report");
		// parent1=_extent_report.startTest("My First Test1");
		
	
		 
	}
	
	
	
	@Test(priority=2,enabled=true, description="Search with combinations Year, Make, Model and Part type.")
	public void verifySearchYMMPTResult() throws InterruptedException, IOException{
		 child1 = _extent_report.startTest("Search with combinations Year, Make, Model and Part type.");
		Dormanpage.SearchYMMPT();
		
	
	
		child1.log(LogStatus.INFO, "Total "+Dormanpage.l1.size()+" items are found in the first page"); 
		child1.log(LogStatus.INFO,"Below are the item names :"); 
		
		
		for(int i=0;i<Dormanpage.l1.size();i++) {
			child1.log(LogStatus.INFO, i+1+"."+Dormanpage.l1.get(i).getText()); 
			
			//add assertion point that if l1.size grearter than 0-pass otherwise fail
		}
		
		if(Dormanpage.l1.size()>0) {
		
			child1.log(LogStatus.PASS, "Validation successful because number of records found were  "+Dormanpage.l1.size()+" which is greater than zero"); 
			
		}
		else {
			child1.log(LogStatus.FAIL, "Validation successful because number of records found were "+Dormanpage.l1.size()+" which is equal to  zero"); 
		}
		
		if(Dormanpage.feedback.getText().toString().equals("Thank you for your feedback.")) {
			child1.log(LogStatus.PASS, "Validation successful-because "+ Dormanpage.feedback.getText().toString()+"  text is being displayed when we provide feedback as yes"); 
		}
		else {
			child1.log(LogStatus.FAIL, "Validation unsuccessful-because "+ Dormanpage.feedback.getText().toString()+"  text is being displayed when we provide feedback as yes instead of 'Thank you for your feedback text'"); 
		}
		_extent_report.endTest(child1); 
	}
		
		  
	
		
	  
	
	
	@Test(priority=3,enabled=true,description="Search with combination Year, Make, Model and Keyword.")
	public void verifySearchYMMKWResult() throws InterruptedException, IOException{
		
		child2 = _extent_report.startTest("Search with combination Year, Make, Model and Keyword.");
		Dormanpage.SearchYMMKW();
		
		child2.log(LogStatus.INFO, "Total "+Dormanpage.l1.size()+" items are found in the first page"); 
		child2.log(LogStatus.INFO,"Below are the item names :"); 
	
		
		
		for(int i=0;i<Dormanpage.l1.size();i++) {
			
			child2.log(LogStatus.INFO, i+1+"."+Dormanpage.l1.get(i).getText()); 

		}
		
		if(Dormanpage.l1.size()>0) {
		
			child2.log(LogStatus.PASS, "Validation successful because number of records found were  "+Dormanpage.l1.size()+" which is greater than zero"); 
			
		}
		else {
		
			child2.log(LogStatus.FAIL, "Validation successful because number of records found were "+Dormanpage.l1.size()+" which is equal to  zero"); 
		}
				
Dormanpage.feedbackno.sendKeys("no");
		
		Dormanpage.feedbacknosubmit.click();
		if(Dormanpage.feedback.getText().toString().equals("Thank you for your feedback. ")) {
			child2.log(LogStatus.PASS, "Validation successful because "+ Dormanpage.feedback.getText().toString()+"  text is being displayed when we provide feedback as 'No' with proper comments"); 
		}
		else {
			child2.log(LogStatus.FAIL, "Validation unsuccessful because "+ Dormanpage.feedback.getText().toString()+"  text is being displayed when we provide feedback as 'No' with proper comments"); 
		}
		child2.log(LogStatus.PASS, "Test2");
		_extent_report.endTest(child2);
		
		}
	
	@Test(priority=4,enabled=true,description="Search with OE # or Interchange #.")
	public void verifySearchOEResult() throws InterruptedException{
		child3 = _extent_report.startTest("Search with OE # or Interchange #.");
		
		Dormanpage.SearchYMMPT();
		
		Thread.sleep(10000);
		
		

		
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		jse.executeScript("scroll(250, 0)"); // if the element is on top.
		Thread.sleep(10000);

		Dormanpage.viewdetails.click();
		Thread.sleep(20000);
		String OEnumbertext=Dormanpage.OEnumber.getText();
		Dormanpage.Interchange.sendKeys(OEnumbertext);
		Dormanpage.Interchangeclick.click();
		for(int i=0;i<Dormanpage.l2.size();i++) {
		
			if(OEnumbertext.equals(Dormanpage.l2.get(i).getText())) {
				
				child3.log(LogStatus.PASS, "Validation successful because - we found item with OE number  " +Dormanpage.l2.get(i).getText()+"  when we searched with OEnumber "+OEnumbertext);
			}
			
			else {
				child3.log(LogStatus.FAIL, "Validation unsuccessful because - we found item with OE number  " +Dormanpage.l2.get(i).getText()+"  when we searched with OEnumber "+OEnumbertext);
			}
			
			
		}
		_extent_report.endTest(child3);
		}
	
	@Test(priority=5,enabled=true,description="Search with Part number.")
	public void verifySearchPTResult() throws InterruptedException{
		child4 = _extent_report.startTest("Search with Part number.");
		
		Dormanpage.SearchYMMPT();
		String itemname=Dormanpage.l1.get(0).getText();
		Dormanpage.keywordtext.sendKeys(itemname);
		Dormanpage.keywordclick.click();
		Thread.sleep(1000);
	
		if(Dormanpage.productname.getText().equals(Dormanpage.l1.get(0).getText())){
			child4.log(LogStatus.PASS, "Validation successful because - we found item with item-name  " +Dormanpage.l1.get(0).getText()+"  when we searched with item-name "+itemname);
		}
		
		else {
			child4.log(LogStatus.FAIL, "Validation unsuccessful because - we found item with item-name  " +Dormanpage.l1.get(0).getText()+"  when we searched with item-name "+itemname);
		}
		_extent_report.endTest(child4);
		
		}
		
	@Test(priority=6,enabled=true,description="Search with Keyword.")
	public void verifySearchKWResult() throws InterruptedException{
		child5 = _extent_report.startTest("Search with Keyword.");
		Dormanpage.SearchYMMPT();
		String parttype=Dormanpage.Parttypename.getText();
		Dormanpage.keywordtext.sendKeys(parttype);
		Dormanpage.keywordclick.click();
		for(int i=0;i<Dormanpage.l3.size();i++) {
			
			if(Dormanpage.l3.get(i).getText().contains("Drain Plug Gasket")) {
				child5.log(LogStatus.PASS, "Validation successful-because we found item  "+Dormanpage.l3.get(i).getText()+"when we selected parttype dropdown as Oil Drain Plug Gasket ");
			}
			
			else {
				child5.log(LogStatus.FAIL, "Validation unsuccessful-because we found item  "+Dormanpage.l3.get(i).getText()+"when we selected parttype dropdown as Oil Drain Plug Gasket ");
			}
			
		}
		_extent_report.endTest(child5);
		}
	
	@Test(priority=7,enabled=true,description="Search with Phrase.")
	public void verifySearchPhraseResult() throws InterruptedException{
		child6 = _extent_report.startTest("Search with Phrase.");
		Dormanpage.SearchYMMPT();
		
		child6.log(LogStatus.INFO, "Below are the items found in pre-search:");
		int x=Dormanpage.l1.size();
		
		
		String a3[]=new String[x];
		String a4[]=new String[x];
		
		for(int i=0;i<x;i++) {
			child6.log(LogStatus.INFO,Dormanpage.l1.get(i).getText() ); 
			a3[i]=Dormanpage.l1.get(i).getText().toString();
			
			}
		
		
		Thread.sleep(10000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(250, 0)"); // if the element is on top.

		
		Dormanpage.savebutton.click();
		driver.switchTo().frame(Dormanpage.Nameyoursearchframe);
		Thread.sleep(5000);
		Dormanpage.savesearchtext.sendKeys("My First Search");
		
		Thread.sleep(5000);
		Dormanpage.SaveButtonFrame.click();
		
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Dormanpage.RecentActivity.click();
		
		/*Dormanpage.keywordtext.sendKeys("My First Search");
		Dormanpage.keywordclick.click();
		*/
		Thread.sleep(20000);
		
		driver.switchTo().frame(Dormanpage.RecentActivityframe);
		Dormanpage.SavedSearch.click();
		Dormanpage.SavedSearchName.click();
		int y=Dormanpage.l1.size();
		for(int i=0;i<y;i++) {
			child6.log(LogStatus.INFO,Dormanpage.l1.get(i).getText() ); 
			a4[i]=Dormanpage.l1.get(i).getText().toString();
			
			}
		
		child6.log(LogStatus.INFO, "Below are the items found in saved-search:");
		if(Arrays.equals(a3, a4)) {
			child6.log(LogStatus.PASS,"Validation successful because- items found in pre-search and saved search are same" ); 
		}
		else {
			child6.log(LogStatus.FAIL,"Validation unsuccessful because- items found in pre-search and saved search are not same" ); 
		}
		
	
		_extent_report.endTest(child6);
		}
	

	@Test(priority=8,enabled=true,description="Total Records Per page - 25, 50, 100.")
	public void verifySearchKEYWORDResult() throws InterruptedException{
		child7 = _extent_report.startTest("Total Records Per page - 25, 50, 100.");
		
		
		Dormanpage.keywordtext.sendKeys("Engine Oil Pan");
		Dormanpage.keywordclick.click();
		Thread.sleep(20000);
		Dormanpage.NextButton.click(); 
	
		Thread.sleep(20000);
		Select s1 = new Select(Dormanpage.recordsdropdown);
		List<WebElement> dd=s1.getOptions();
		
		
		for(int i=0;i<dd.size();i++) {
			s1.selectByIndex(i);
			String s=s1.getOptions().get(i).getText();
			String a[]=s.split(" ");
			int y = Integer.parseInt(a[0]);
			if( y>=Dormanpage.l1.size()){
				child7.log(LogStatus.PASS, "Validation successful-because we found "+y +" items when we choose "+s+" in drop down");
			}
			else {
				child7.log(LogStatus.FAIL, "Validation unsuccessful-because we found "+y +" items when we choose "+s+" in drop down");
			}
			Thread.sleep(1000);
			
		}

		_extent_report.endTest(child7); 
			
		}
		
	

	@Test(priority=9,enabled=true,description="Search with VIN ")
	public void verifySearchVINResult() throws InterruptedException{
		child8 = _extent_report.startTest("Search with VIN");
		
		Dormanpage.Vinbox.sendKeys("3C3CFFKR2HT535828");
		Actions builder = new Actions( driver );
		Thread.sleep(10000);
		  builder.moveToElement(Dormanpage.VinDDitem).click().build().perform();
		  Thread.sleep(10000);
		 String errormsg= Dormanpage.Erromsg.getText();
		  if(errormsg.equals("CAUTION: The search results are not tied to all aspects of your VIN" + "Please verify the selected part type using the Check Your Fit button.")){
			  child8.log(LogStatus.PASS, "Validation successful-because we found error message  "+errormsg+"  - when our search results are not tied to our searched VIN 3C3CFFKR2HT535828");
		  }
		  
		  else {
			  child8.log(LogStatus.FAIL, "Validation unsuccessful-because we found error message  "+errormsg+"  - when our search results are not tied to our searched VIN 3C3CFFKR2HT535828"); 
		  }
		  _extent_report.endTest(child8); 
	}

	
	@Test(priority=10,enabled=true,description="Search with part number and then click on view details.")
	public void verifyViewDetailsResult() throws InterruptedException{
		child9 = _extent_report.startTest("Search with part number and then click on view details.");
		Dormanpage.SearchYMMPT();
		Thread.sleep(10000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(250, 0)"); // if the element is on top.
		Thread.sleep(10000);
		

		Dormanpage.viewdetails.click();
		
		
		Thread.sleep(30000);
		for(int i=0;i<Dormanpage.summaryitem.size();i++) {
			child9.log(LogStatus.INFO,Dormanpage.summaryitem.get(i).getText()); 
			//System.out.println(Dormanpage.summaryitem.get(i).getText());
		}
		Dormanpage.CheckYourFitButton.click();
		
		DormanSearch.dropdownselection(Dormanpage.Constraintdropdown, "V6 182 3.0L");
		Dormanpage.Submitbutton.click();
		if(Dormanpage.PartFitLabel.getText().equals("This part is a fit for your vehicle")||Dormanpage.PartFitLabel.getText().equals("Sorry, this part is not a fit for your vehicle.")) {
			child9.log(LogStatus.PASS,"Validation successful because-  "+ Dormanpage.PartFitLabel.getText()+" is being displayed"); 
		}
		else {
			child9.log(LogStatus.FAIL,"Validation unsuccessful because-  " +Dormanpage.PartFitLabel.getText()+"  is being displayed"); 
		}
		_extent_report.endTest(child9); 
		
		}
	
	@Test(priority=11,enabled=true,description="Search by PIN and Select within miles.")
	public void verifyPINMILESResult() throws InterruptedException{
		child10 = _extent_report.startTest("Search by PIN and Select within miles.");
		Dormanpage.SearchYMMPT();
		Thread.sleep(10000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(250, 0)"); // if the element is on top.
		Thread.sleep(10000);

		Dormanpage.viewdetails.click();
		 
		
		Thread.sleep(30000); 
	// jse.executeScript("arguments[0].scrollIntoView(true);", Dormanpage.FindLocation);
		jse.executeScript("scroll(0, 2800)"); // if the element is on top.
		Thread.sleep(30000);
		driver.switchTo().frame(Dormanpage.findlocationframe);
		Thread.sleep(5000);
		
		Dormanpage.FindLocation.sendKeys("92123");
		
		Thread.sleep(10000);
		
		Dormanpage.dropdownselection(Dormanpage.SelectMiles, "25 miles");
		Thread.sleep(20000);
		Dormanpage.SearchLocation.click();
		Thread.sleep(20000);
		if(Dormanpage.Map.isDisplayed()) {
			child10.log(LogStatus.PASS,"Validation successful because- proper Location is being displayed in the MAP  "); 
			}
		else {
			child10.log(LogStatus.FAIL,"Validation unsuccessful because- proper Location is not being displayed in the MAP  ");
		}
		
		driver.switchTo().defaultContent();
		
		_extent_report.endTest(child10); 
		
		}
	
	@Test(priority=12,enabled=true,description="Full Text Search.")
	public void verifyFullTextSearchResult() throws InterruptedException{
		child11 = _extent_report.startTest("Full Text Search.");
		Dormanpage.keywordtext.sendKeys("Brake Caliper Bracket Bolts");
		Dormanpage.keywordclick.click();
		
		child11.log(LogStatus.INFO, "Below are the items found when we search with Brake Caliper Bracket Bolts:"); 
		
		for(int i=0;i<Dormanpage.l3.size();i++) {
			child11.log(LogStatus.INFO,Dormanpage.l3.get(i).getText() ); 
			}
	
		Dormanpage.keywordtext.sendKeys("Disc Brake Hardware Kit");
		Dormanpage.keywordclick.click();
		
		child11.log(LogStatus.INFO, "Below are the items found when we search with Disc Brake Hardware Kit:"); 
		
		for(int i=0;i<Dormanpage.l3.size();i++) {
			
			
			child11.log(LogStatus.INFO,Dormanpage.l3.get(i).getText() ); 
			}
	
		Dormanpage.keywordtext.sendKeys("Disc Brake Hardware Kit,HW2300");
		Dormanpage.keywordclick.click();
		
		child11.log(LogStatus.INFO, "Below are the items found when we search with Disc Brake Hardware Kit,HW2300"); 
		
		for(int i=0;i<Dormanpage.l3.size();i++) {
			
			
			child11.log(LogStatus.INFO,Dormanpage.l3.get(i).getText() ); 
			}
		
		Dormanpage.keywordtext.sendKeys("H620549,Brake Hydraulic Hose");
		Dormanpage.keywordclick.click();
		
		child11.log(LogStatus.INFO, "Below are the items found when we search with H620549,Brake Hydraulic Hose"); 
		
		for(int i=0;i<Dormanpage.l3.size();i++) {
			
			
			child11.log(LogStatus.INFO,Dormanpage.l3.get(i).getText() ); 
			}
		
		
		_extent_report.endTest(child11); 
		
		}
	
	@Test(priority=13,enabled= true, description="No Broken Links for Images.")
	public void verifyBrokenlinksResult() throws InterruptedException{
		child12 = _extent_report.startTest("No Broken Links for Images.");
		Dormanpage.SearchYMMPT();
		List<WebElement> totalLinks=DormanSearch.findAllLinks(driver);
		
		child12.log(LogStatus.INFO, "Total number of Links found " + totalLinks.size());
		   
		    for (WebElement link : totalLinks) {
		        try {
		        	child12.log(LogStatus.PASS, "URL: " + link.getAttribute("src")+ " returned " +DormanSearch. isLinkBroken(new URL(link.getAttribute("src")))); 
					//System.out.println("URL: " + link.getAttribute("src")+ " returned " + isLinkBroken(new URL(link.getAttribute("src"))));
					

				} catch (Exception e) {
					
					child12.log(LogStatus.FAIL,"At " + link.getAttribute("innerHTML") + " Exception occured -&gt; " + e.getMessage()); 
		    		//System.out.println("At " + link.getAttribute("innerHTML") + " Exception occured -&gt; " + e.getMessage());	
					
				}

			}
		    
			_extent_report.endTest(child12); 
	
		
		
		
		
	}
	
	@Test(priority=14,enabled=true, description="Search with Year/Make/Model/Part type.")
	public void verifyNarrowSearchResult() throws InterruptedException{
		child13 = _extent_report.startTest("Search with Year/Make/Model/Part type. ");
		Dormanpage.SearchYMMPT();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(250, 0)"); // if the element is on top.
		
		
		
		child13.log(LogStatus.INFO, "Number of items found before removing item from  You Have Selected menu are : "+Dormanpage.l1.size()); 
		
		
		
		Dormanpage.removesearch.click();
		
		
		
		String s1=	Dormanpage.itemscount.getText();
		String a[]=new String[Dormanpage.l1.size()];
		a=s1.split(" ");
		int y = Integer.parseInt(a[2]);
	
		child13.log(LogStatus.INFO, "Number of items found after removing item from You Have Selected menu are : "+y);
		
		child13.log(LogStatus.INFO, "Number of items found before click item in Narrow Your Search menu are : "+y);
		Dormanpage.NarrowSearch.click();
		
		Dormanpage.NarrowSearchclickitem.click();
		
		child13.log(LogStatus.INFO, "Number of items found after click item in Narrow Your Search menu are : "+Dormanpage.l1.size());
		child13.log(LogStatus.INFO, "Number of items found before checked the item in Filter Your results menu are : "+Dormanpage.l1.size());
		Dormanpage.FilterYourResults.click();
		Dormanpage.Selectcheckbox.click();
		Thread.sleep(10000);
		jse.executeScript("scroll(250, 0)");
		Dormanpage.ClearSearch.click();
		Thread.sleep(20000);
		child13.log(LogStatus.INFO, "Number of items found after checked item in Filter Your results menu are : "+Dormanpage.l1.size());
		Dormanpage.FilterYourResults.click();
		Dormanpage.Selectcheckbox.click();
		Thread.sleep(10000);
		child13.log(LogStatus.INFO, "Number of items found after unchecked item in Filter Your results menu are : "+Dormanpage.l1.size());
		
		
		jse.executeScript("scroll(250, 0)"); // if the element is on top.
		Dormanpage.savebutton.click();
		driver.switchTo().frame(Dormanpage.Nameyoursearchframe);
		Thread.sleep(30000);
		String s=Dormanpage.savesearchtext.getText();
		
		System.out.println("phrase name is :"+s);
		
		
		Thread.sleep(20000);
		Dormanpage.SaveButtonFrame.click();
		
		Thread.sleep(20000);
		driver.switchTo().defaultContent();
		
		Dormanpage.keywordtext.sendKeys(s);
		Dormanpage.keywordclick.click();
		
		child13.log(LogStatus.INFO, "Below are the items found when we search with saved phrase"); 
		
		for(int i=0;i<Dormanpage.l3.size();i++) {
			
			
			child13.log(LogStatus.INFO,Dormanpage.l3.get(i).getText() ); 
			}
		
		
		_extent_report.endTest(child13); 
	}
	
	
	
	
	

	@Test(priority=15,enabled=true, description="Advanced Search")
	public void verifyAdvancedSearchResult() throws InterruptedException{
		  child14 = _extent_report.startTest("Advanced Search");
		
		Thread.sleep(10000);
		  Dormanpage.keywordtext.sendKeys("Wheel-Studs");
		  Thread.sleep(5000);
			Dormanpage.keywordclick.click();
			 Thread.sleep(5000);
			Dormanpage.advanceSearch.click();
			 Thread.sleep(5000);
			
			Dormanpage.itemselect.click();
			 Thread.sleep(5000);
			
			Dormanpage.stylselect.click();
			 Thread.sleep(5000);
			
			Dormanpage.Metricselect.click();
			 Thread.sleep(5000);
			
			
			Dormanpage.sizeselect.click();
			 Thread.sleep(5000);
			
			
			
		String s=	Dormanpage.itemscount.getText();
		String a[]=new String[Dormanpage.l1.size()];
		a=s.split(" ");
		int y = Integer.parseInt(a[2]);
		child14.log(LogStatus.INFO,"Total number of items found in advanced search are : "+y); 
		
		
			if(y>0) {
				child14.log(LogStatus.PASS,"Total number of items found in advanced search are : "+y+" which is greater than zero"); 
			}
			else {
				child14.log(LogStatus.FAIL,"Total number of items found in advanced search are : "+y+" which is zero"); 
			}
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(250, 0)");
			Dormanpage.ClearSearch.click();
			
			String s1=	Dormanpage.itemscount.getText();
			String b[]=new String[Dormanpage.l1.size()];
			b=s1.split(" ");
			int z = Integer.parseInt(b[2]);
			child14.log(LogStatus.INFO,"Total number of items found after clearing advanced search are : "+z); 
			if(z>y) {
				child14.log(LogStatus.PASS,"Total number of items found after clearing  advanced search are : "+z+" which is greater than items found in advanced search"); 
			}
			else {
				child14.log(LogStatus.FAIL,"Total number of items found after clearing advanced search are : "+z+" which is less than items found in advanced search"); 
			}
			
		   
		   
			_extent_report.endTest(child14); 
}
	
	
	
	@Test(priority=16,enabled=true,description="Delete Saved Search from Recent Activities list.")
	public void verifySavedSearchDeletionResult() throws InterruptedException{
		child15 = _extent_report.startTest("Delete Saved Search from Recent Activities list.");
		Dormanpage.SearchYMMPT();
		
		
		
		Thread.sleep(10000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(250, 0)"); // if the element is on top.

		
		Dormanpage.savebutton.click();
		driver.switchTo().frame(Dormanpage.Nameyoursearchframe);
		Thread.sleep(5000);
		Dormanpage.savesearchtext.sendKeys("My First Search");
		
		Thread.sleep(5000);
		Dormanpage.SaveButtonFrame.click();
		
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Dormanpage.RecentActivity.click();
		
		/*Dormanpage.keywordtext.sendKeys("My First Search");
		Dormanpage.keywordclick.click();
		*/
		Thread.sleep(20000);
		
		driver.switchTo().frame(Dormanpage.RecentActivityframe);
		Dormanpage.SavedSearch.click();
		
		Dormanpage.SavedSearchRename.click();
		driver.switchTo().frame(Dormanpage.SavedSearchRenameframe);
		Dormanpage.SavedSearchRenameframetextbox.sendKeys("My Second Search");
		Dormanpage.SavedSearchRenameframetextboxSave.click();
		driver.switchTo().frame(Dormanpage.RecentActivityframe);
		if(Dormanpage.SavedSearchName.getText().equals("My Second Search"))
		{
			child15.log(LogStatus.PASS,"Saved search is renamed with "+Dormanpage.SavedSearchName.getText()+" so validation successful"); 
			
		
		}
		else {
			child15.log(LogStatus.FAIL,"Saved search is renamed with "+Dormanpage.SavedSearchName.getText()+" so validation unsuccessful"); 
		}
		Dormanpage.SavedSearchRemove.click();
		Alert a=driver.switchTo().alert();
		a.accept();
		
		/*String message=Dormanpage.AlertDismissMessage.getText();
		if(message.equals("Currently there are no SAVED SEARCHES.")) {
			child15.log(LogStatus.PASS,"Message "+ message +"  is being displayed after removing saved search so validation successful"); 
		}
		
		else {
			child15.log(LogStatus.FAIL,"Message "+ message +"  is being displayed after removing saved search so validation unsuccessful");
		}*/
		Thread.sleep(20000);
		driver.switchTo().defaultContent();
		
		_extent_report.endTest(child15);
		}
	@Test(priority=17,enabled=true,description="Search from Recent Activites list.")
	public void verifyRecentlyviewditemsResult() throws InterruptedException{
		child16 = _extent_report.startTest("Search from Recent Activites list.");
		Dormanpage.SearchYMMPT();
		
		
		
		Thread.sleep(10000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(250, 0)"); // if the element is on top.

		Dormanpage.RecentActivity.click();
		
		
		Thread.sleep(20000);
		
		driver.switchTo().frame(Dormanpage.RecentActivityframe);
		
		Thread.sleep(10000);
		Dormanpage.Recentvehiclesclick.click();
		Dormanpage.RecentVehicle.click();
		driver.switchTo().defaultContent();
		String s1=	Dormanpage.itemscount.getText();
		String b[]=new String[Dormanpage.l1.size()];
		b=s1.split(" ");
		int z = Integer.parseInt(b[2]);
		 
		if(z>0) {
			child16.log(LogStatus.PASS,"Validation successful because we found "+z+" items which is greater than zero when we click on recent vehicles"); 
		}
		else {
			child16.log(LogStatus.FAIL,"Validation unsuccessful because we found "+z+" items which is not a positive number" );
		} 
		
		//driver.switchTo().defaultContent();
		
		
		jse.executeScript("scroll(250, 0)"); // if the element is on top.
		Thread.sleep(10000);
		

		Dormanpage.viewdetails.click();
	String actual=	Dormanpage.Labelproductname.getText();
		
Dormanpage.RecentActivity.click();
		
		
		Thread.sleep(20000);
		
		driver.switchTo().frame(Dormanpage.RecentActivityframe); 
		//Dormanpage.RecentViewditemtab.click();
		Thread.sleep(10000);
		Dormanpage.RecentViewditem.click();
		driver.switchTo().defaultContent();
		String expected=	Dormanpage.Labelproductname.getText();
		if(actual.equals(expected)) {
			child16.log(LogStatus.PASS,"Validation successful because we found item name as "+expected+" from both view details and recently view item click");
		}
		else {
			child16.log(LogStatus.FAIL,"Validation unsuccessful because we did not find item name as "+expected+" from both view details and recently view item click");
		}
		
		
		
		_extent_report.endTest(child16);
		}
	
	
	@Test(priority=15,enabled=true, description="Login Page.")
	public void verifyLoginResult() throws InterruptedException{
		  child17 = _extent_report.startTest("Login Page.");
		  
		  String url="https://www.dormanproducts.com/default.aspx";
		Dormanpage.Login.click();
		Dormanpage.Loginid.sendKeys("Gnase");
		Dormanpage.Loginpassword.sendKeys("Dorman_2018");
		Dormanpage.Loginsubmit.click();
		Thread.sleep(10000);
		System.out.println(driver.getCurrentUrl());
		if(driver.getCurrentUrl().equals(url)) {
			child17.log(LogStatus.PASS,"User has been loggedin successfully"); 
		}
		
		else {
			child17.log(LogStatus.FAIL,"Login unsuccessful"); 
		}
		
		Dormanpage.Hollandar.sendKeys("123");
		Dormanpage.Hollandarclick.click();
		
		String s=	Dormanpage.itemscount.getText();
		String a[]=new String[Dormanpage.l1.size()];
		a=s.split(" ");
		int y = Integer.parseInt(a[2]);
		
		if(y>0) {
			child17.log(LogStatus.PASS,"Validation successful because we found "+y+" items when we search with hollander number");
		}
		else {
			child17.log(LogStatus.FAIL,"Validation unsuccessful because we found "+y+" items when we search with hollander number");
		}
		
		Dormanpage.Totalcart.click();
		Dormanpage.Logout.click();
		
	_extent_report.endTest(child17); 
	}
	@Test(priority=18,enabled=true, description="Select Spanish Language.")
	public void verifySpanishSearchResult() throws InterruptedException{
		child18 = _extent_report.startTest("Select Spanish Language.");
		Dormanpage.Languageclick.click();
		
		Actions builder = new Actions( driver );
		Thread.sleep(10000);
		  builder.moveToElement(Dormanpage.Spanishclick).click().build().perform();
		  Thread.sleep(10000);
		  
		String header=  Dormanpage.header_spanish.getText();
		child18.log(LogStatus.INFO,header+" is being displayed in spanish  which is eqvivalent to Search Products in English"); 
		  
		  Dormanpage.SearchSpanishYMMPT();
		Thread.sleep(10000);
		 
		child18.log(LogStatus.INFO,Dormanpage.Submitbutton.getAttribute("value")+" is being displayed in spanish  which is eqvivalent to submit in English"); 
		  
		  Dormanpage.Submitbutton.click();
		  
			Thread.sleep(10000);
		  
		  
			
		 
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(250, 0)"); // if the element is on top.
			Thread.sleep(10000);
			
			child18.log(LogStatus.INFO,Dormanpage.viewdetails.getText()+" is being displayed in spanish  which is eqvivalent to View Details in English"); 

			Dormanpage.viewdetails.click();
			
			child18.log(LogStatus.INFO,"Below are summary items when we click  view details in spanish language"); 
			Thread.sleep(30000);
			for(int i=0;i<Dormanpage.summaryitem_spanish.size();i++) {
				child18.log(LogStatus.INFO,Dormanpage.summaryitem_spanish.get(i).getText()); 
				//System.out.println(Dormanpage.summaryitem.get(i).getText());
			}
			child18.log(LogStatus.INFO,Dormanpage.CheckYourFitButton.getText()+" is being displayed in spanish  which is eqvivalent to Check your Fit Button in English"); 
			Dormanpage.CheckYourFitButton.click();
			
			DormanSearch.dropdownselection(Dormanpage.Constraintdropdown, "Rear");
			Dormanpage.Submitbutton.click();
			if(Dormanpage.PartFitLabel.getText().equals("Esta pieza es un acoplamiento para su vehículo")||Dormanpage.PartFitLabel.getText().equals("Sorry, this part is not a fit for your vehicle.")) {
				child18.log(LogStatus.PASS, Dormanpage.PartFitLabel.getText()+"is being displayed so validation successful"); 
			}
			_extent_report.endTest(child18); 
		  
		  
		  
		  
		
		
		_extent_report.endTest(child18); 
	}
	@AfterMethod //AfterMethod annotation - This method executes after every test execution
	public void screenShot(ITestResult result){
	//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
		System.out.println(result.getStatus());
		if(ITestResult.FAILURE==result.getStatus()){
	
			try{TestUtil.takeScreenshotAtEndOfTest(result.getName());
				
				System.out.println("Successfully captured a screenshot");
			}catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
		}
		}
	@AfterTest
	public void tearDown(){
		
		 
			
	    
		
		
		_test_logger
	    .appendChild(child1).appendChild(child2).appendChild(child3)
		.appendChild(child4).appendChild(child5).appendChild(child6)
		
		.appendChild(child7).appendChild(child8).appendChild(child9)
		.appendChild(child10).appendChild(child11).appendChild(child12)
		.appendChild(child13).appendChild(child14).appendChild(child15)
		.appendChild(child16).appendChild(child17).appendChild(child18);
		
		
		
		
		
		
		
		
		
		_extent_report.endTest(_test_logger);
		_extent_report.flush(); 
      //  _extent_report.close(); 
		
	}
	
	
	
	
}
