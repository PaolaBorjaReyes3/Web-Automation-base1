<h1>Continuous Testing - Web</h1>

Este script permitira simular la acción humana a travéz de lineas de comandos enviados por metodos públicos dentro del
framework para interactuar con los componentes web de un aplicativo.

<h3>Pre-requisito para el desarrollo</h3>
Para poder interactuar con el framework es necesario primero entender los flujos o escenarios que se van a automatizar
(Pantallas, procesos, arquitectura, etc).

<h3>¿Cómo accedo a los metodos del framework?</h3>
Para acceder a los metodos del framework, la clase Page debe extender de la clase:
> WebDriverDom

<h3>Método con el que se inicializa el driver</h3>


private EnvironmentVariables environmentVariables;

    @Step("page open")
    public void openPage() throws Throwable {
        String url = UtilWeb.getPropertyValue("url.sauce");
        sauceDemoPage().getDriver().get(url);
    }

<h3>Propiedades necesarias para la ejecución</h3>
Estas propiedades son necesarias para la ejecución del Test.


webdriver.driver = chrome  //chrome, ie
headless.mode = false  // false, true


<h3>¿Cómo ejecuto el proyecto?</h3>
> mvn clean verify  -D cucumber.options="--tags @SauceTest" -Denvironment=dev


El reporte total generado por serenity se encontrará en la siguiente ruta:
> /target/site/serenity

En la clase RunnerTest, AfterClass llamar al metodo importTestResultExecution de la clase
JXrayServiceDom ubicada en el jar dependencia

java
public class RunnerTest{

    @BeforeClass
    public static void beforeExecution() {
        UtilWeb.logger(RunnerTest.class).info("BEFORE >>>");
        setEnvironment(SystemEnvironmentVariables.createEnvironmentVariables());
    }
    
    @AfterClass
    public static void afterExecution() {
        UtilWeb.logger(RunnerTest.class).info("AFTER >>>");
        if (WebDriverManager.getWebDriver() != null)
            WebDriverManager.stopWebDriver();
        }
    }