package resources;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.jboss.logging.Logger;
import org.jboss.logmanager.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class AddContactTest {
    private static WebDriver webDriver;
    private static final String pathToChromeWebdriver = "/home/oscar/Oscar/Software/chromedriver";
    private static final String localhost = "http://localhost:8080";
//    private static final Logger log = Logger.getLogger();

//    private static final Logger LOG = Logger.getLogger(ExampleResource.class);

    @BeforeAll
    public static void setUp() {
//        System.setProperty("webdriver.chrome.driver", pathToChromeWebdriver);
//        System.setProperty("webdriver.gecko.driver", pathToFirefoxDriver);
//        webDriver = new ChromeDriver();
//        webDriver = new FirefoxDriver();
        // Wait before getting WebElements
//        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        ChromeDriverService service = new ChromeDriverService.Builder().build();
        webDriver = new ChromeDriver(service);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterAll
    public static void tearDown() {
        webDriver.quit();
    }

    @Given("I am in the contacts list page")
    public void i_am_in_the_contacts_list_page() {
        // Write code here that turns the phrase above into concrete actions
        webDriver.navigate().to(localhost);
    }
    @When("II provide {string} for the name")
    public void ii_provide_for_the_name(String name) throws InterruptedException {
//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(name);
    }
    @When("I provide {string} for the surname")
    public void i_provide_for_the_surname(String surname) throws InterruptedException {
//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"surname\"]")).sendKeys(surname);
    }
    @When("I provide {string} for the nif")
    public void i_provide_for_the_nif(String nif) throws InterruptedException {
//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"nif\"]")).sendKeys(nif);
    }
    @When("I click the New button")
    public void i_click_the_new_button() throws InterruptedException {
//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"new\"]")).click();
    }
    @Then("The person with nif {string} is created in the agenda")
    public void the_person_with_nif_is_created_in_the_agenda(String nif) {
        assertNotNull(webDriver.findElement(By.id(nif)));
    }
}
