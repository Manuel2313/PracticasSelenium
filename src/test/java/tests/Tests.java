package tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.DataDriven;
import utils.PropertiesDriven;

import java.util.ArrayList;

public class Tests{
    //declarar atributos
    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;
    private ArrayList<String> dataCPs;
    private LoginPage loginPage;
    private NewsletterPage newsletterPage;
    private ProductosPage productPage;

   @AfterMethod
    public void posPrueba(){
       registerPage.cerrarBrowser();
   }



    @BeforeMethod
    public void preparacionEjecucion(){
        //Instanciar los objetos
        dataCPs = new ArrayList<>();
        homePage = new HomePage(driver);
        homePage.conexionDriver
                (PropertiesDriven.getProperty("browser")
                    ,PropertiesDriven.getProperty("rutaDriver")
                    ,PropertiesDriven.getProperty("propertyDriver"));
        registerPage = new RegisterPage(homePage.getDriver());
        loginPage = new LoginPage(homePage.getDriver());
        newsletterPage = new NewsletterPage(homePage.getDriver());
        productPage = new ProductosPage(homePage.getDriver());
        homePage.cargarSitio(PropertiesDriven.getProperty("url"));
        homePage.maximizarBrowser();

    }

    @Test
    public void CP00_registro_ok(){
        //Preparar data
        dataCPs = DataDriven.getData("CP00registrook");
        homePage.esperarXSegundos(5000);
        homePage.IraRegistro();
        registerPage.Registrar(dataCPs.get(1),dataCPs.get(2),dataCPs.get(3),dataCPs.get(4));

        Assert.assertEquals(registerPage.obtenerOkRegister(),dataCPs.get(5));
    }
    @Test
    public void CP01_Registro_NO_OK(){
        //Preparar data
        dataCPs = DataDriven.getData("CP01RegistroNOOK");
        homePage.esperarXSegundos(5000);
        homePage.IraRegistro();
        registerPage.Registrar(dataCPs.get(1),dataCPs.get(2),dataCPs.get(3),dataCPs.get(4));

        Assert.assertEquals(registerPage.obtenerRegisterFail(),dataCPs.get(5));
    }

    @Test
    public void CP02LoginOK(){
        //Preparar data
        dataCPs = DataDriven.getData("CP02Login_OK");
        homePage.iraLogin();
        loginPage.login(dataCPs.get(1),dataCPs.get(2));
        Assert.assertEquals(loginPage.obtenerLoginOK(),dataCPs.get(1));
    }
    @Test
    public void CP03LoginUserInvalido(){
        //Prepara data
        dataCPs = DataDriven.getData("CP03LoginUserInvalido");          /**Obtener Data Excel**/
        homePage.iraLogin();                                                    /**Click Login**/
        loginPage.login(dataCPs.get(1),dataCPs.get(2));                         /**Completar campos Login**/
        Assert.assertEquals(loginPage.obtenerLoginError(),dataCPs.get(3)); /**Verificar Login User Invalido**/
    }

    @Test
    public void CP05AgregarProducto (){
        dataCPs = DataDriven.getData("CP05AgregarProducto");//obtener data
        homePage.iraLogin();
        loginPage.login(dataCPs.get(1),dataCPs.get(2));     //loguear usuario
        homePage.irAComputer();                                 //Ir a sección producto seleccionado
        productPage.verProducto();                              //click en producto
        productPage.addToShoppingCart();                        //agregaralcarrito
        Assert.assertEquals(productPage.obtenerNameProd(),dataCPs.get(3));  //verificar que se haya agregado al carrito
    }

    @Test
    public void CP07SubNewsletter(){
        dataCPs = DataDriven.getData("CP07SubNewsletter"); /**Obtener Data Excel**/
        homePage.iraLogin();                                        /**Click Login**/
        loginPage.login(dataCPs.get(1),dataCPs.get(2));             /**Completar campos Login**/
        newsletterPage.subNewsletter(dataCPs.get(1));               /**Completar usuario en newsletter**/
        homePage.esperarXSegundos(2000);
        Assert.assertEquals(newsletterPage.obtenerMsjSub(),dataCPs.get(3));/**Verificar Suscripcion**/
    }

}
