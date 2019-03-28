package com.pos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Quick_walkin {
public void add(WebDriverWait wait,WebDriver driver) throws InterruptedException
{
	wait.until(ExpectedConditions.elementToBeClickable(By.id("quickWalkIn")));
	Thread.sleep(1000);
	driver.findElement(By.id("quickWalkIn")).click();
}
}
