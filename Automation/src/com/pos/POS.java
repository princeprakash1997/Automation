package com.pos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class POS 
  {
  String FILENAME = "/home/stl/Downloads/TestResult/test_report.txt";
  File file = new File(FILENAME);
  WebDriver driver;
  WebDriverWait wait;
  Pos_login posl =new Pos_login();
  Quick_walkin qwalk = new Quick_walkin();
  Random r = new Random();  
  @Test (priority=0) 
  public void pos() throws InterruptedException, IOException
  {
	 FileWriter f = new FileWriter(FILENAME);
	 //driver install
     System.setProperty("webdriver.chrome.driver","/home/stl/Downloads/driver/chromedriver");
     driver = new ChromeDriver();
     driver.manage().window().maximize(); 
     wait = new WebDriverWait(driver, 1000);
     driver.get("http://142.93.221.167:8080/e10Web/action/login");
     f.write("chrome launched"+"\n");
     //login process
     posl.e10(driver, "testpos1", "Test123");
     int b =r.nextInt(5);
     posl.pos_click(wait,driver,b);
     f.write("pos clicked"+"\n");
     posl.password(wait,driver);
     String result =posl.check(wait,driver);
     if (result == "wrongpassword")
     {
          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='passwordModalTwo']/i[@class='close icon']")));	
          Thread.sleep(1000);
          driver.findElement(By.xpath("//div[@id='passwordModalTwo']/i[@class='close icon']")).click();	
          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//strong[.='POS Unlock']")));	
          Thread.sleep(1000);
          driver.findElement(By.xpath("//strong[.='POS Unlock']")).click();
          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"posUnlockId\"]/button")));
          Thread.sleep(1000);
          driver.findElement(By.xpath("//*[@id=\"posUnlockId\"]/button")).click();
          posl.unlock(wait,driver);
          Thread.sleep(2000);
          posl.pos_click(wait,driver,b);
          posl.password(wait,driver);
          posl.shift(wait, driver,f);
     }
     else 
     {
          posl.shift(wait, driver,f);
     }
    posl.vh(wait, driver);
    qwalk.add(wait, driver);
    f.close();
    }	
}
