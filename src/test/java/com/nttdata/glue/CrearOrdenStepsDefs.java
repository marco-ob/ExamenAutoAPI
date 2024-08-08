package com.nttdata.glue;

import com.nttdata.steps.CrearOrden;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CrearOrdenStepsDefs {

    @Steps
    CrearOrden crearOrden;

    @Given("que tengo una orden con los siguientes datos {int}, {int}, {int}, {string}, {string}, {boolean}")
    public void queTengoUnaOrdenConLosSiguientesDatos(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        crearOrden.crearOrden(id, petId, quantity, shipDate, status, complete);
    }

    @When("envío una petición POST al endpoint /store/order")
    public void envioUnaPeticionPOSTAlEndpoint() {
        // La petición POST se realiza en el método @Given
    }

    @Then("el código de respuesta es {int}")
    public void elCodigoDeRespuestaEs(int statusCode) {
        crearOrden.validarCodigoRespuesta(statusCode);
    }

    @And("el cuerpo de la respuesta contiene {int}, {int}, {int}, {string}, {string}, {boolean}")
    public void elCuerpoDeLaRespuestaContiene(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        crearOrden.validarCuerpoRespuesta(id, petId, quantity, shipDate, status, complete);
    }

    @Given("que tengo una orden existente con id {int}")
    public void queTengoUnaOrdenExistenteConId(int orderId) {
        crearOrden.consultarOrden(orderId);
    }

    @When("envío una petición GET al endpoint /store/order/{int}")
    public void envioUnaPeticionGETAlEndpoint(int orderId) {

    }

    @And("el cuerpo de la respuesta contiene {int}, {int}, {int}, {string}, {string}, {boolean}")
    public void elCuerpoDeLaRespuestaContieneGET(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        crearOrden.validarCuerpoRespuesta(id, petId, quantity, shipDate, status, complete);
    }
}