package com.nttdata.steps;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class OrdenSteps {
    private String URL_Base;
    private Response response;

    public void setURL_Base(String URL_Base) {
        this.URL_Base = URL_Base;
    }

    public void consultaPut(int cantidad,int mascotaID,String fecha){
        long id = 1;
        String jsonBody =
                "{\n" +
                        "  \"id\": " + id + ",\n" +
                        "  \"petId\": " + mascotaID + ",\n" +
                        "  \"quantity\": " + cantidad + ",\n" +
                        "  \"shipDate\": \"" + fecha + "\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}";
        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .baseUri(URL_Base)
                .body(jsonBody)
                .log().all()
                .when()
                .post("/order")
                .then()
                .log().all()
                .extract().response();

    }

    public void consultaGet(int orderID){
        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .baseUri(URL_Base)
                .log().all()
                .when()
                .get("/order/"+orderID)
                .then()
                .log().all()
                .extract().response();
    }

    public void validarCodigo(int statusCode){
        Assert.assertEquals("StatusCode",statusCode,response.getStatusCode());
    }
    public void validarBodyPut(int mascotaID,int cantidad){
        Assert.assertEquals("Mascota ID",
                Integer.toString(mascotaID),
                response.body().path("petId").toString());

        Assert.assertEquals("Cantidad",
                Integer.toString(cantidad),
                response.body().path("quantity").toString());
    }

    public void validarBodyGet(int orderID){
        Assert.assertEquals("Order ID",Integer.toString(orderID),response.body().path("id").toString());
    }
}

