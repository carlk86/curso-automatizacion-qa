package automatizacion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC002ValidacionLogin {
//Script para validasr el login page
     WebDriver driver;

//Acciones que se vana a ejecutar antes de cada test
    @BeforeEach
    public void inicializarNavegador() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
     
     @Test 
     public void  validarTituloDeLaPagina(){
         //Abri nuestro navegador
         driver.get("https://practicetestautomation.com/practice-test-login/");

        //oBTENER TITULO DE NUETRA PAGINA
        String tituloActual = driver.getTitle();
        String tituloEsperado = "Test Login"


        Assertions.assertEquals(
            tituloEsperado, 
            tituloActual, 
            "El titulo esperado no coincide con lo esperado");

         System.out.println("Titulo fue validado correctamente")   

     } 

     //Validar funcionalidad de login 
     @Test
     public void loginExitoso(){
        
     }

     //Acciones que se van a ejecutar despues de cada test
     @AfterEach
     public void cerrarSesion(){

        drver.quit();
     }

}