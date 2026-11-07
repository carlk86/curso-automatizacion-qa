package automatizacion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;


public class TC002BuscarProd {

    private WebDriver driver;
    private WebDriverWait wait;


  @BeforeEach 
    public void inicializarNavegador() {
        //Inicializar driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Inicializar wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void pausa() throws InterruptedException{
        Thread.sleep(3000);
    }

    @Test 
public void buscarProducto() throws InterruptedException{

        // Abrir navegador
        driver.get("https://teststore.automationtesting.co.uk/index.php");

       
        WebElement buscar = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.id("search_widget")));

            buscar.sendKeys("Mug");
            buscar.sendKeys(Keys.ENTER);
        
        }          



}

