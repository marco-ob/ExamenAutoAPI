package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class CrearOrden {

    private static final String BASE_URL = "https://petstore.swagger.io/v2/store/order";

    @Step("Crear orden con id {0}, petId {1}, quantity {2}, shipDate {3}, status {4}, complete {5}")
    public void crearOrden(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        SerenityRest.given()
                .contentType("application/json")
                .body(String.format("{\"id\":%d,\"petId\":%d,\"quantity\":%d,\"shipDate\":\"%s\",\"status\":\"%s\",\"complete\":%b}",
                        id, petId, quantity, shipDate, status, complete))
                .post(BASE_URL)
                .then()
                .log().all();
    }

    @Step("Consultar orden con id {0}")
    public void consultarOrden(int orderId) {
        SerenityRest.given()
                .contentType("application/json")
                .get(BASE_URL + "/" + orderId)
                .then()
                .log().all();
    }

    @Step("Validar código de respuesta {0}")
    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    @Step("Validar cuerpo de la respuesta contiene {0}, {1}, {2}, {3}, {4}, {5}")
    public void validarCuerpoRespuesta(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        restAssuredThat(response -> response.body("id", equalTo(id)));
        restAssuredThat(response -> response.body("petId", equalTo(petId)));
        restAssuredThat(response -> response.body("quantity", equalTo(quantity)));
        restAssuredThat(response -> response.body("shipDate", equalTo(shipDate)));
        restAssuredThat(response -> response.body("status", equalTo(status)));
        restAssuredThat(response -> response.body("complete", equalTo(complete)));
    }
}