package cucumberService.definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.TestBase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class SeleniumTestDefinition extends TestBase {

    WebDriver driver;

    // Elements
    By signInButton = By.xpath("//a[@class]");
    By submitCreateButton = By.id("SubmitCreate");
    By emailCreate = By.id("email_create");
    By accountCreationForm = By.id("account-creation_form");
    By customerFirstname = By.id("customer_firstname");
    By customerLastname = By.id("customer_lastname");


    @Before
    public void setUpDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\arsen.senyk\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void quitDriverDriver(){
        driver.quit();
    }
    @Given("the user is on shop's main page {word}")
    public void theUserIsOnShopSMainPageHttpAutomationpracticeComIndexPhp(String url) {
        driver.get(url);
    }

    @When("click a button for signing in")
    public void clickAButtonForSigningIn() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        driver.findElement(signInButton).click();
    }

    @Then("a page for creating account opens")
    public void aPageForCreatingAccountOpens() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(submitCreateButton));
        assertThat(driver.findElement(submitCreateButton).isDisplayed()).isTrue();
    }

    @And("enters uses _email address_ to create a new account {word}")
    public void entersUses_emailAddress_ToCreateANewAccount(String value) {
        driver.findElement(emailCreate).sendKeys(value);
    }

    @Then("a form to be filled in with user's data opens")
    public void aFormToBeFilledInWithUserSDataOpens() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(accountCreationForm));
        assertThat(driver.findElement(accountCreationForm).isDisplayed()).isTrue();
    }

    @Given("the user filled in all necessary data in the page for creating an account {word} {word}")
    public void theUserFilledInAllNecessaryDataInThePageForCreatingAnAccount(String name, String surname) {
        driver.findElement(customerFirstname).sendKeys(name);
        driver.findElement(customerLastname).sendKeys(surname);
    }

    @And("submits the data with a button")
    public void submitsTheDataWithAButton() {
    }

    @Then("user is logged in to the account")
    public void userIsLoggedInToTheAccount() {
    }

    @Given("the account for the user is created")
    public void theAccountForTheUserIsCreated() {
    }

    @And("user is on shop's main page http:\\/\\/automationpractice.com\\/index.php")
    public void userIsOnShopSMainPageHttpAutomationpracticeComIndexPhp() {
    }

    @When("user logs in to created account")
    public void userLogsInToCreatedAccount() {
    }

    @Then("My account page is displayed")
    public void myAccountPageIsDisplayed() {
    }

    @And("click create account button")
    public void clickCreateAccountButton() {
        driver.findElement(By.id("SubmitCreate")).click();
    }
}

