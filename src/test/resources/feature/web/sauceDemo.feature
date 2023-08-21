@SauceTest
Feature: Compra online en Sauce Demo
  Como usuario de Sauce
  Quiero realizar una compra online
  Para obtener los productos deseados

  Scenario Outline: Iniciar sesion
    Given que entro a la pagina saucedemo
    And ingreso las credenciales
    And clic en Login
    When selecciono un producto
    And clic en el carrito
    And clic en Checkout
    When completo los datos "<FirstName>", "<LastName>", "<ZipCode>"
    And clic en Continue
    And clic en finish
    Then muestra el mensaje "THANK YOU FOR YOUR ORDER"
    Examples:
      | FirstName | LastName | ZipCode |
      | Paola     | Borja    | 10131   |


