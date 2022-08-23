package tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.RegisterPage;
import utils.DataDriven;
import utils.PropertiesDriven;

import java.util.ArrayList;

public class Tests{
    //declarar atributos
    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;
    private ArrayList<String> dataCPs;

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
        homePage.cargarSitio(PropertiesDriven.getProperty("url"));
        homePage.maximizarBrowser();

    }


    
    @Test
    public void CP00_registro_ok(){
        //Preparar data
        dataCPs = DataDriven.getData("CP00_registro_ok");
        homePage.esperarXSegundos(30000);
        homePage.IraRegistro();
        registerPage.Registrar(dataCPs.get(1),dataCPs.get(2),dataCPs.get(3),dataCPs.get(4),dataCPs.get(5));

        Assert.assertEquals(registerPage.obtenerOkRegister(),dataCPs.get(6));
    }



}
