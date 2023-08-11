package com.parabank.testcase;

import com.parabank.pages.CustomLoginPage;
import com.parabank.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomLoginTest extends BaseTest{
    @Test(enabled = false)
  public void LoginShouldFailWithoutCredential(){
        CustomLoginPage loginPage=page.getInstance(CustomLoginPage.class)
                .doLoginWithCrediential();
        Assert.assertTrue(loginPage.hasError());
    }
    @Test(enabled = false)
    public void LoginShouldFailWithoutPassword(){
        CustomLoginPage loginPage= page.getInstance(CustomLoginPage.class)
                        .doLoginWithoutPassword("sqa");
        Assert.assertTrue(loginPage.hasError());
    }


//
    @Test(enabled = false)
    public void loginSucceed2(){
        HomePage newpage= page.getInstance(CustomLoginPage.class)
                .doLoginWithCrediential("123","123");
        Assert.assertTrue(newpage.hasLogoutLink());
    }

    //for test title
    @Test
    public void LoginPageTittle(){
        CustomLoginPage loginPage=page.getInstance(CustomLoginPage.class);
        Assert.assertTrue(loginPage.getPageTittle().contains("ParaBank"));
    }


}
