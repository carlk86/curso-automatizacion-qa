package automatizacion;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EX001compraDeProducto {

   private WebDriver driver;
   private WebDriverWait wait;

 @BeforeEach 
    public void inicializarNavegador() {
        //Inicializar driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Inicializar wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://teststore.automationtesting.co.uk/index.php");  

     }

@Test 
    public void autenticarUsuario() {
        // Ir al Login y autenticarse
        
        WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.user-info a")));
        signInLink.click();
        
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("field-email")));
        emailInput.sendKeys("carlo.pruebas@mail.com");

        WebElement passwordInput = driver.findElement(By.id("field-password"));
        passwordInput.sendKeys("153426.26");

        WebElement loginBtn = driver.findElement(By.id("submit-login"));
        loginBtn.click();

        wait.until(ExpectedConditions.invisibilityOf(loginBtn));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.logout")));
        loginBtn.click();

        // Validacion 1 Verificar que el usuario haya iniciado sesión correctamente
           WebElement singOutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.logout")));
           Assertions.assertEquals(singOutBtn.isDisplayed(), "El usuario no inicio sesion correctamente");

        // Navegar en el catalogo y seleccionar prodducto
        
        WebElement logo = driver.findElement(By.cssSelector("#_desktop_logo a"));
        logo.click();

        WebElement selecProducto = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".product-miiniature a.product-thumbnail")));
        selecProducto.click();

        //Agregar producto

        WebElement agrAlCarroBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.add-to-cart")));
        agrAlCarroBtn.click();

        //Acceder al carrito

        WebElement accAlCarroBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.cart-content-btn a.btn-primary")));
        accAlCarroBtn.click();

        //Validacion 2 	Verificar que los productos se encuentren en el carrito.

        WebElement ProdEnCarrito = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.cart-item")));
        Assertions.assertEquals(ProdEnCarrito.isDisplayed(), "No hay productos en el carrito");

        // Iniciar el proceso de checkout

        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.checkout a.btn-primary")));
        checkoutBtn.click();

        // Completar informacion 

        WebElement confDireccBtn = wait.until(ExpectedConditions.elementToBeClickable(By.name("confirm-addresses")));
        confDireccBtn.click();

        WebElement confMetEnvioBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("confirmDeliveryOption")));
        confMetEnvioBtn.click();

        WebElement confMetPago = wait.until(ExpectedConditions.elementToBeClickable(By.id("payment-option-1")));
        confMetPago.click();

        WebElement acceptTerminos = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        acceptTerminos.click();

        //Confirmar la orden

       WebElement confOrden = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#payment-confirmation button")));
        confOrden.click();

        // Validacion 3  Verificar que al finalizar el flujo se muestre el mensaje: "Your order is confirmed".

        WebElement valMensajeOrdenComplet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content-hook_order_confirmation h3.card-title")));
        String mensajeObtenido = valMensajeOrdenComplet.getText();

        Assertions.assertEquals(mensajeObtenido.contains("YOUR ORDER IS CONFIRMED") || mensajeObtenido.contains("You order is confirmed") , "el mensaje confirmado no coincide. texto encontrado:" + mensajeObtenido);


    }

       

}    