package ru.sf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


/**
 * Варианты запуска сценариев:
 * Команда 'mvn clean test' в консоли
 * Через UI intellij IDEA
 */
public class StepDefinitions {

    public static final WebDriver webDriver;
    public static final ChooseTextPage chooseTextPage;
    public static final WebSitePage webSitePage;

    //Процесс инициализации необходимых ресурсов
    static {
        System.setProperty("webdriver.chrome.driver", "D:\\PROGRAMIR\\QAJA_Final_1\\src\\test\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        chooseTextPage = new ChooseTextPage(webDriver);
        webSitePage = new WebSitePage(webDriver);
    }

    //Реализация шага
    //Текст должен строго соответствовать тексту сценария
    @Given("url of restaurant {string}")
    public void url_of_restaurant(String url) {
        chooseTextPage.go(url);
    }


    //Реализация шага
    @Then("assert that chosen city is {string}")
    public void assert_that_chosen_text_is(String expectedCity) {
        final var currentActiveText = chooseTextPage.getCurrentActiveText();
        assertEquals(expectedCity, currentActiveText);
    }

    //Реализация шага
    @Then("assert that user got message {string}")
    public void assert_that_user_got_message(String errorMessage) {
        final var textNotFoundMessage = chooseTextPage.getTextNotFoundMessage();
        assertEquals(errorMessage, textNotFoundMessage);
    }
}
