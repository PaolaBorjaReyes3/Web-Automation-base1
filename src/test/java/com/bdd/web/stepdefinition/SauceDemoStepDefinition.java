package com.bdd.web.stepdefinition;

import com.bdd.generic.Constants;
import com.bdd.util.UtilWeb;
import com.bdd.web.step.SauceDemoStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class SauceDemoStepDefinition {

    @Steps
    private SauceDemoStep sauceDemoStep;
    private Scenario scenario;

    @Before
    public void beforeGoogleStepDefinition(Scenario scenario) {
        Constants.SCENARIO = scenario.getName();
        UtilWeb.setScenarioName(Constants.SCENARIO);
    }

    @Given("que entro a la pagina saucedemo")
    public void queEntroALaPaginaSaucedemo() throws Throwable {
        sauceDemoStep.openPage();
    }

    @And("ingreso las credenciales")
    public void ingresoLasCredenciales() throws Throwable {
        sauceDemoStep.ingresarCredenciales();
    }

    @And("clic en Login")
    public void clicEnLogin() {
        sauceDemoStep.clicLogin();
    }

    @When("selecciono un producto")
    public void seleccionoUnProducto() {
        sauceDemoStep.selecccionarProducto();
    }


    @And("clic en el carrito")
    public void clicEnElCarrito() {
        sauceDemoStep.clicCarrito();

    }

    @And("clic en Checkout")
    public void clicEnCheckout() {
        sauceDemoStep.clicCheckOut();

    }

    @When("completo los datos {string}, {string}, {string}")
    public void completoLosDatos(String arg0, String arg1, String arg2) throws Throwable {
        sauceDemoStep.completoDatos(arg0, arg1, arg2);
    }

    @And("clic en Continue")
    public void clicEnContinue() {
        sauceDemoStep.clicContinuar();

    }

    @And("clic en finish")
    public void clicEnFinish() {
        sauceDemoStep.clicFinish();
    }

    @Then("muestra el mensaje {string}")
    public void muestraElMensaje(String arg0) {
        Assert.assertTrue(sauceDemoStep.validarCcompra(arg0));
    }

}
