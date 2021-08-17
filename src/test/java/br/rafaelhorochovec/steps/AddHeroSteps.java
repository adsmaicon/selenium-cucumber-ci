package br.rafaelhorochovec.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddHeroSteps {

	private WebDriver driver;

	@Given("I wish save a new hero")
	public void i_wish_save_a_new_hero() {
		WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
		//driver = new ChromeDriver();
		driver.get("https://angular-heroi.herokuapp.com/herois");
		driver.manage().window().setSize(new Dimension(1200, 765));
	}

	@When("click in {string}")
	public void click_in(String button) {
		if (button.equals("Adicionar")) {
			driver.findElement(By.xpath("//nav/div/li[2]/a")).click();
		} else if (button.equals("Salvar")) {
			driver.findElement(By.xpath("//app-create/div/div/div/button")).click();
		}
	}

	@When("insert {string}, {string} e {string}")
	public void insert_e(String nome, String nomeCivil, String universo) {
		driver.findElement(By.id("nome")).sendKeys(nome);
		driver.findElement(By.id("nomeCivil")).sendKeys(nomeCivil);
		WebElement element = driver.findElement(By.id("universo"));
		Select combo = new Select(element);
		combo.selectByVisibleText(universo);
	}

	@SuppressWarnings("deprecation")
	@Then("will present the message {string}")
	public void will_present_the_message(String expected) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//app-create/div/div/div/h3")));
		String mensagem = driver.findElement(By.xpath("//app-create/div/div/div/h3")).getText();
		Assert.assertEquals(expected, mensagem);
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
}
