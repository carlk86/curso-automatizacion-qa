package Practica;

import java.time.Duration;

import org.apache.hc.core5.util.Asserts;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HU003Formulario {
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
        driver.get("https://teststore.automationtesting.co.uk/index.php?controller=contact");

         //Seleccionar  area

        WebElement contactDropdown = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.id("id_contact")));
         
        Select dropdown = new Select(contactDropdown);
        dropdown.selectByValue("2");   
        
        String opcionSeleccionada = dropdown.getFirstSelectedOption().getAttribute("value");
        Assertions.assertEquals(opcionSeleccionada, "2", "La opcion seleccionada no es la correcta" );
        
        //Completar el correo

        WebElement correo = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.id("email")));
                
        correo.sendKeys("juan.perez@test.com");

         //Completar el mensaje

        WebElement mensaje = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.id("contactform-message")));
                
        mensaje.sendKeys("Solicito información adicional sobre un producto.");

        // Enviar informacación del formulario

        WebElement botonSubmit = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.name("submitMessage")));


        botonSubmit.click();

        pausa();

        // Validar mensaje de envio exitoso

        WebElement mensajeEnvioExitoso = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".alert-success li")));

        String textoMensaje = mensajeEnvioExitoso.getText();        
        
        Assertions.assertEquals(textoMensaje, "Your message has been successfully sent to our team.", "El mensaje encontrado no es el correcto");
        

            }
            
 

    
}
