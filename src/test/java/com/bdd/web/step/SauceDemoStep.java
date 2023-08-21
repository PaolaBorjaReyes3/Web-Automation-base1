package com.bdd.web.step;

import com.bdd.util.UtilWeb;
import com.bdd.web.page.SauceDemoPage;
import net.thucydides.core.annotations.Step;

public class SauceDemoStep {

    private SauceDemoPage sauceDemoPage() {
        return new SauceDemoPage();
    }

    @Step("page open")
    public void openPage() throws Throwable {
        String url = UtilWeb.getPropertyValue("url.sauce");
        System.out.println(url + " -------------------------------");
        sauceDemoPage().getDriver().get(url);
    }

    @Step("ingreso credenciales")
    public void ingresarCredenciales() throws Throwable {
        String user = UtilWeb.getStringEvironmentProperty(UtilWeb.getEnvironment(), "username");
        String password = UtilWeb.getStringEvironmentProperty(UtilWeb.getEnvironment(), "password");
        sauceDemoPage().ingresarCredenciales(user, password);
    }

    @Step("Clic boton login")
    public void clicLogin() {
        sauceDemoPage().clicLogin();
    }

    @Step("Seleccionar producto")
    public void selecccionarProducto() {
        sauceDemoPage().seleccionarProducto();
    }

    @Step("Clic carrito")
    public void clicCarrito() {
        sauceDemoPage().clicCarrito();
    }

    @Step("Clic checkout")
    public void clicCheckOut() {
        sauceDemoPage().clicCheckOut();
    }

    @Step("Completo datos")
    public void completoDatos(String firstName, String lastName, String ZipCode) throws Throwable {
        sauceDemoPage().completoDatos(firstName, lastName, ZipCode);
    }

    @Step("Clic continuar")
    public void clicContinuar() {
        sauceDemoPage().clicContinue();
    }

    @Step("Clic finish")
    public void clicFinish() {
        sauceDemoPage().clicFinish();
    }

    @Step("Valido compra")
    public boolean validarCcompra(String sMensaje) {
        return sauceDemoPage().validarCompra(sMensaje);
    }
}
