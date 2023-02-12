package com.automationfraternity;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class StepDefsNavigateToUrl {

    WebDriver driver;
    Scenario scenario;
    @Before
    public void beforeScn(Scenario s){
        scenario = s;
    }

    @Given("I have browser opened")
    public void i_have_browser_opened() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setPlatformName(String.valueOf(Platform.LINUX));
        driver = new RemoteWebDriver(new URL(System.getProperty("gridUrl")),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Log: Browser opened.");
        scenario.log("Browser Opened.");
    }

    @When("I am on the page with url as {string}")
    public void i_am_on_google_search_page(String url) {
        driver.get(url);
        System.out.println("Log: Browser Navigated to: " + url);
        scenario.log("Browser navigated.");

    }

    @Then("Page title contains {string}")
    public void page_title_contains_text(String text) {
        Assertions.assertThat(driver.getTitle()).contains(text);
        System.out.println("Log: Assertion Success");
        scenario.log("Assertion Success.");
    }

    @AfterStep
    public void afterStep(){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        byte[] data = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        scenario.attach(data, "image/png", scenario.getLine().toString());
    }

    @After
    public void afterScn(){
        driver.quit();
        System.out.println("Log: Driver Quit");
    }

}
