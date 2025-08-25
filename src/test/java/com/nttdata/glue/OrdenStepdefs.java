package com.nttdata.glue;

import com.nttdata.steps.OrdenSteps;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class OrdenStepdefs {
    @Steps
    OrdenSteps orden;

    @Given("defino la URL {string}")
    public void definoLaURL(String url) {
        orden.setURL_Base(url);
        System.out.println("URL definida: " + url);
    }

    @When("quiero comprar {int} mascota\\(s) con el ID {int} para el dia {string}")
    public void quieroComprarCantidadMascotaSConElIDMascotaIDParaElDiaFecha(int cantidad, int mascotaID, String fecha) {
        orden.consultaPut(cantidad, mascotaID, fecha);
    }

    @Then("recibo un codigo de respuesta {int}")
    public void reciboUnCodigoDeRespuestaStatusCodeEsperado(int statusCode) {
        orden.validarCodigo(statusCode);
    }

    @When("quiero consultar una orden con el ID: {int}")
    public void quieroConsultarUnaOrdenConElIDOrdenID(int ordenID) {
        orden.consultaGet(ordenID);
    }

    @And("recibo un body con {int} y {int} indicados")
    public void reciboUnBodyConMascotaIDyCantidadIndicados(int mascotaID, int cantidad) {
        orden.validarBodyPut(mascotaID, cantidad);
    }

    @And("recibo un body con el parametro de ID {int}")
    public void reciboUnBodyConElParametroDeIDOrdenID(int orderID) {
        // Write code here that turns the phrase above into concrete actions
        orden.validarBodyGet(orderID);
    }
}
