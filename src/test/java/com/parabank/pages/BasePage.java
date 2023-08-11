package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends  Page {
    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTittle() {
        return driver.getTitle();
    }

    @Override
    public WebElement getWebElement(By locator) {
        WebElement webElement=null;
        try {
            waitForWebElement(locator);
webElement=driver.findElement(locator);
        }catch (Exception exception) {
            System.out.println(locator.toString() + " NOT FOUND");
        }
        return webElement;
    }

    @Override
    public List<WebElement> getWebElements(By locator) {
        List<WebElement> webElements=null;
        try {
            waitForWebElement(locator);
            webElements=driver.findElements(locator);
        }catch (Exception exception){
            System.out.println(locator.toString() + "Error");
        }
        return webElements;
    }

    @Override
    public void waitForWebElement(By locator) {
        try{
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

        }
        catch (Exception exception){
            System.out.println(locator.toString()+ "NOT LODING..");
        }


    }
}
