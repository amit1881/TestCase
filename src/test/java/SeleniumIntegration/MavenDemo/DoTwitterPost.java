package SeleniumIntegration.MavenDemo;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;


import utility.ReadExcelDemo;
public class DoTwitterPost
{
   /*WebDriver driver = new FirefoxDriver();
   
   @BeforeTest
   public void launchapp()
   {
      // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      // Launch website
      driver.navigate().to("http://social.ravabe.com/");
      driver.manage().window().maximize();
   }*/
	
	   public WebDriver driver,driver1;
	   public String URL, Node;
	   protected ThreadLocal<RemoteWebDriver> threadDriver = null;
	   
	   @Parameters("browser")
	   @BeforeTest
	   public void launchapp(String browser) throws MalformedURLException
	   {
	      String URL = "http://social.ravabe.com/";
	      
	      if (browser.equalsIgnoreCase("firefox"))
	      {
	         System.out.println(" Executing on FireFox");
	         String Node = "http://104.239.164.22:5555/wd/hub";
	         //String Node1="http://192.168.137.172:5556/wd/hub";
	         DesiredCapabilities cap = DesiredCapabilities.firefox();
	         
	         cap.setBrowserName("firefox");
	        
	         driver = new RemoteWebDriver(new URL(Node), cap);
	         //driver1=new RemoteWebDriver(new URL(Node1), cap);
	         // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
	         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         //driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         // Launch website
	         driver.navigate().to(URL);
	         //driver1.navigate().to(URL);
	         driver.manage().window().maximize();
	         //driver1.manage().window().maximize();
	         
	      }
	      /*
	      else if(browser.equalsIgnoreCase("firefox1"))
	      {
	    	  System.out.println(" Executing on FireFox");
	    	  String Node1 = "http://localhost:5556/wd/hub";
	    	  DesiredCapabilities cap1 = DesiredCapabilities.firefox();
	    	  cap1.setBrowserName("firefox");
	    	  driver1 = new RemoteWebDriver(new URL(Node1), cap1);
	    	  driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	  driver1.navigate().to(URL);
	    	  driver1.manage().window().maximize();
	      }*/
	      else if (browser.equalsIgnoreCase("chrome"))
	      {
	         System.out.println(" Executing on CHROME");
	         DesiredCapabilities cap = DesiredCapabilities.chrome();
	         cap.setBrowserName("chrome");
	         String Node = "http://104.239.164.22:5557/wd/hub";
	         //String Node1="http://192.168.137.172:5560/wd/hub";
	         driver = new RemoteWebDriver(new URL(Node), cap);
	         //driver1 = new RemoteWebDriver(new URL(Node1), cap);
	         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         //driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         // Launch website
	         driver.navigate().to(URL);
	         //driver1.navigate().to(URL);
	         driver.manage().window().maximize();
	         //driver1.manage().window().maximize();
	      }
	      /*
	      else if (browser.equalsIgnoreCase("ie"))
	      {
	         System.out.println(" Executing on IE");
	         DesiredCapabilities cap = DesiredCapabilities.chrome();
	         cap.setBrowserName("ie");
	         String Node = "http://localhost:5558/wd/hub";
	         driver = new RemoteWebDriver(new URL(Node), cap);
	         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         
	         // Launch website
	         driver.navigate().to(URL);
	         driver.manage().window().maximize();
	      }*/
	      else
	      {
	         throw new IllegalArgumentException("The Browser Type is Undefined");
	      }
	   }
	   @DataProvider(name="myMessage")
	   
	    public Object[][] SendMessages() throws Exception{
	 
	         Object[][] testObjArray = ReadExcelDemo.getTableArray("TestCase/src/test/resources/Messages.xlsx","Sheet1");
	 
	         return (testObjArray);
	 
			}
   @Test(dataProvider="myMessage")
   public void LoginTest(String message)
   {
	   //String email="a@ravabe.com";
	   //String password="Deepak07%";
	   String email="abhinavumang18@gmail.com";
	   String password="Amit1234";
	   //String message = "Hello facebook ";
	   //String message = UUID.randomUUID().toString();
	   driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(email);
       driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
       
       //String loginBtn = driver.findElement(By.xpath(" .//*[@id='login-form']/button"));
       driver.findElement(By.xpath(" .//*[@id='login-form']/button")).click();
       
       
       //Click on one of a recent projects
       driver.findElement(By.xpath(".//*[@id='mCSB_3_container']/div/a[1]")).click();
       Random rnd=new Random();
       //for (int i = 1; i <= 5; i++)
       //{
       //Click on add new post
       driver.findElement(By.xpath("html/body/div[3]/div/div[1]/div[1]/a")).click();
       driver.findElement(By.xpath("html/body/div[3]/div[1]/ul/li[2]/a")).click();
       

       //driver.findElement(By.xpath(".//*[@id='content_text']")).sendKeys(message+(rnd.nextDouble()+rnd.nextLong()));
       driver.findElement(By.xpath(".//*[@id='content_text']")).sendKeys(message);

       //WebDriver.FindElement(By.Id("content_text")).SendKeys(message);
       //Select a channel
       driver.findElement(By.xpath(".//*[@id='multipost_form']/div/div[2]/div[1]/div/div[1]")).click();
       //WebDriver.FindElement(By.XPath(".//*[@id='multipost_form']/div/div[2]/div[1]/div/div[2]")).Click();
       //WebDriver.FindElement(By.XPath(".//*[@id='multipost_form']/div/div[2]/div[1]/div/div[4]")).Click();
       //var publishNow = WebDriver.FindElement(By.XPath(".//*[@id='btn-publish']"));
       //publishNow.Click();
       driver.findElement(By.xpath(".//*[@id='btn-publish']")).click();
       //}
       //Go to dropdown in header
       driver.findElement(By.xpath(".//*[@id='caret']")).click();
       //Go to logout button
       driver.findElement(By.xpath(".//*[@id='dropdown']/div[2]/div[6]/a")).click();
   }
   @AfterTest
   public void terminatetest()
   {
	   
       driver.close();
   }
}
