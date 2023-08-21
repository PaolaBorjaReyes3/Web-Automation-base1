package com.bdd.web.page;

import com.bdd.web.obj.SauceDemoObj;

public class SauceDemoPage extends SauceDemoObj {
    public void ingresarCredenciales(String usuario, String password) throws Throwable {
        waitElement(txtUser, 10);
        txtUser.clear();
        txtUser.sendKeys(usuario);
        waitElement(txtPassword, 10);
        txtPassword.clear();
        txtPassword.sendKeys(password);

    }

    public void clicLogin() {
        waitElement(btnLogin, 10);
        btnLogin.click();
    }

    public void seleccionarProducto() {
        waitElement(btnAddCard, 10);
        btnAddCard.click();
        waitElement(btnAddCard2, 10);
        btnAddCard2.click();
    }

    public void clicCarrito() {
        waitElement(btnShoppingCard, 10);
        btnShoppingCard.click();
    }

    public void clicCheckOut() {
        waitElement(btnCheckout, 10);
        btnCheckout.click();
    }

    public void completoDatos(String FirstName, String LastName, String PostalCode) throws Throwable {
        waitElement(txtFirstName, 10);
        txtFirstName.clear();
        txtFirstName.sendKeys(FirstName);
        waitElement(txtLastName, 10);
        txtLastName.clear();
        txtLastName.sendKeys(LastName);
        waitElement(txtPostalCode, 10);
        txtPostalCode.clear();
        txtPostalCode.sendKeys(PostalCode);

    }

    public void clicContinue() {
        waitElement(btnContinue, 10);
        btnContinue.click();
    }

    public void clicFinish() {
        waitElement(btnFinish, 10);
        btnFinish.click();
    }

    public boolean validarCompra(String sMensaje) {
        boolean value;
        waitElement(getMensaje, 10);
        if (getMensaje.getText().toLowerCase().contains(sMensaje.toLowerCase())) {
            return value = true;
        } else {
            return value = false;
        }
    }
}
