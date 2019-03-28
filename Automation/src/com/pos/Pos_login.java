package com.pos;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Pos_login 
{

public void  e10(WebDriver driver,String username,String password)
{
	driver.findElement(By.id("email")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.xpath("//*[@id=\"rightdiv\"]/form/div[5]/button")).click();
}
public void pos_click(WebDriverWait wait,WebDriver driver,int b) throws InterruptedException
{
	wait.until(ExpectedConditions.elementToBeClickable(By.id("posqsr")));
	Thread.sleep(1000);
	driver.findElement(By.id("posqsr")).click();
	int c=b+1;
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"posNameId\"]/button["+c+"]")));
    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@id=\"posNameId\"]/button["+c+"]")).click();
}
public void password(WebDriverWait wait,WebDriver driver) throws InterruptedException
{
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='passwordModalTwo']//button[@id='oneBtn']")));
    Thread.sleep(1000);
    driver.findElement(By.id("pwdClearBtn2")).click();
    Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@id='passwordModalTwo']//button[@id='oneBtn']")).click();
	driver.findElement(By.xpath("//div[@id='passwordModalTwo']//button[@id='twoBtn']")).click();
	driver.findElement(By.xpath("//div[@id='passwordModalTwo']//button[@id='threeBtn']")).click();
	driver.findElement(By.xpath("//div[@id='passwordModalTwo']//button[@id='fourBtn']")).click();
	driver.findElement(By.xpath("//div[@id='passwordModalTwo']//button[@id='fiveBtn']")).click();
	driver.findElement(By.id("passOK2")).click();
}
public String check(WebDriverWait wait,WebDriver driver)
{
	String result="";
    String wpass = "http://142.93.221.167:8080/e10Web/action/posLayout";  
    String Geturl = driver.getCurrentUrl();
    if(Geturl.equals(wpass))
    {
     result = "wrongpassword";
    }
   /* else if(Geturl.equals(Shift))
    {
     result ="shift";
    }
    else if(Geturl.equals(noshift))
    {
     result ="noshift";
    }*/
	return result;
}
public void unlock(WebDriverWait wait,WebDriver driver) throws InterruptedException
{
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pwdClearBtnUnlock")));
    Thread.sleep(1000);
    driver.findElement(By.id("pwdClearBtnUnlock")).click();
    Thread.sleep(1000);
	driver.findElement(By.xpath("//button[@id='oneBtnUnlock']")).click();
	driver.findElement(By.xpath("//button[@id='twoBtnUnlock']")).click();
	driver.findElement(By.xpath("//button[@id='threeBtnUnlock']")).click();
	driver.findElement(By.xpath("//button[@id='fourBtnUnlock']")).click();
	driver.findElement(By.xpath("//button[@id='fiveBtnUnlock']")).click();
	driver.findElement(By.xpath("//button[@id='passOKUnlock']")).click();
}
public void shift(WebDriverWait wait,WebDriver driver,FileWriter f) throws IOException, InterruptedException
{
	String Shift = "http://142.93.221.167:8080/e10Web/action/authenticateShift";
    String noshift  = "http://142.93.221.167:8080/e10Web/action/posScreenQsrNew";
    Thread.sleep(1000);
    String Geturl = driver.getCurrentUrl();
    if(Geturl.equals(Shift))
    {
    	f.write("shift work correctly");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cardone']/button")));
        Thread.sleep(1000);  
        driver.findElement(By.xpath("//*[@id='cardone']/button")).click();
    }
    else if(Geturl.equals(noshift))
    {
    	f.write("shift not work");
    }
}
public void vh(WebDriverWait wait,WebDriver driver) throws InterruptedException
{
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='menu transition visible']/div[@class='item active selected']"))).click();
	Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@class='menu transition visible']/div[@class='item active selected']")).click();
    //  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("div[data-value='Horizontal']"))).click();
    //	Thread.sleep(1000);
    //  driver.findElement(By.xpath("div[data-value='Horizontal']")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.id("posViewLayoutOkBtn")));
    Thread.sleep(1000);
    driver.findElement(By.id("posViewLayoutOkBtn")).click();    
}
}