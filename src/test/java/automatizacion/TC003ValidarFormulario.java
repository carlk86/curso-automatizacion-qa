package automatizacion;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC003ValidarFormulario {

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
    public void completarFormularioDeContacto() throws InterruptedException{
        // Abrir el formulario
        driver.get("https://www.automationtesting.co.uk/contactForm.html");

        pausa();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='80%'");

        //Completar el nombre

        WebElement nombre = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[placeholder='First Name']")));
        nombre.sendKeys("Carlos");

        wait.until(ExpectedConditions.attributeToBe(By.cssSelector("input[placeholder='First Name']"),"value","Carlos"));
        
        js.executeScript("document.body.style.zoom='70%'");

        pausa();
        //Completar el apellido

        WebElement apellido = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[placeholder='Last Name']")));
        apellido.sendKeys("Salguero");

        wait.until(ExpectedConditions.attributeToBe(
            By.cssSelector("input[placeholder='Last Name']"),
            "value",
            "Salguero"));

            js.executeScript("document.body.style.zoom='60%'");
            pausa();
        //Completar el correo

        WebElement correo = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[placeholder='Email Address']")));
        correo.sendKeys("carlossalguero@mail.com");

        wait.until(ExpectedConditions.attributeToBe(
            By.cssSelector("input[placeholder='Email Address']"),
            "value",
            "carlossalguero@mail.com"));

            js.executeScript("document.body.style.zoom='50%'");
            pausa();
        //Completar el comentario

        WebElement comentarios = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector("textarea[placeholder='Comments']")));
        comentarios.sendKeys("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA100");

        wait.until(ExpectedConditions.attributeToBe(
            By.cssSelector("textarea[placeholder='Comments']"),
            "value",
            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA100"));

        // Enviar informacación del formulario

        WebElement botonSubmit = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[value='SUBMIT']")));

        js.executeScript("document.body.style.zoom='80%'");
        pausa();

        botonSubmit.click();

        pausa();

        // Validar mensaje de login exitoso

        WebElement mensajeLoginExitoso = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div[class='col-8 col-12-small'] h3")));
        
        Assertions.assertEquals("Thank you for your mail!"
        ,mensajeLoginExitoso.getText(),
    "El mensaje encontrado no es el correcto");

    }

    @AfterEach
        public void cerrarSesion(){
        driver.quit();
    }
    
}
 
