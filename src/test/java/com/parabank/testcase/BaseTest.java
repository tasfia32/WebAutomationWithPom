package com.parabank.testcase;

import com.parabank.pages.BasePage;
import com.parabank.pages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    Page page;
    private Properties properties;
    //constructor
    public BaseTest(){
        //for path
        try {
        String filePath=System.getProperty("user.dir") + "/src/test/resources/config.properties"; // select path

         properties=new Properties();

            FileInputStream inputStream=new FileInputStream(filePath); // read properties element
            try {
                properties.load(inputStream); // read properties
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }



    }
    @BeforeMethod
     //For single//
//    public void setUpBrower(){
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.get("https://parabank.parasoft.com/parabank/index.htm");
//  driver.manage().window().maximize();
//
//  page=new BasePage(driver);
//    }

    //For Dynamic/Multiple
    public void SetUpBrowser(){
        String browserName=properties.getProperty("browserName");
        if (Objects.equals(browserName,"chrome")) {
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        } else if (Objects.equals(browserName,"firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();

        } else if (Objects.equals(browserName,"chromeHeadless")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options=new ChromeOptions(); // for headless part
            options.addArguments("--headless"); // for headlesspart
            driver=new ChromeDriver(options);


        } else if (Objects.equals(browserName,"firefoxHeadless")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options=new FirefoxOptions(); // for headless
            options.addArguments("---headless");
            driver=new FirefoxDriver(options);

        }

        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().window().maximize();

        page=new BasePage(driver);
    }

public String getUserName(){
        return properties.getProperty("username");
}

public String getPassword(){
        return properties.getProperty("password");
}
    @AfterMethod

    public  void dearTown(){
        driver.quit();
    }



}
