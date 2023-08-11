package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomLoginPage extends BasePage {
    public CustomLoginPage(WebDriver driver) {
        super(driver);
    }
    public CustomLoginPage fillUsername(String username){
        getWebElement(By.name("username")).sendKeys(username);

        return  this;
    }
    public CustomLoginPage fillPassword(String password){
        getWebElement(By.name("password")).sendKeys(password);
        return this;
    }

    public HomePage clickLoginBtn(){
        getWebElement(By.cssSelector("input.button")).click();
        return getInstance(HomePage.class);
    }

    public CustomLoginPage clickLoginBtnToFail(){
        getWebElement(By.cssSelector("input.button")).click();
        return this;
    }
    // without password & username
public CustomLoginPage doLoginWithCrediential(){
        return clickLoginBtnToFail();
}
// without passwprd
public CustomLoginPage doLoginWithoutPassword(String username){
        return fillUsername(username)
                .clickLoginBtnToFail();
}
// with password & username
public HomePage doLoginWithCrediential(String username, String password)
{
    return fillUsername(username)
            .fillPassword(password)
            .clickLoginBtn();
}


public boolean hasError(){
        return getWebElements(By.className("error")).size() >0;
}
}
