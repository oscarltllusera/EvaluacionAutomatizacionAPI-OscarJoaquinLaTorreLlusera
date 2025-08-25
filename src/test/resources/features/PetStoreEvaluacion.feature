# Created by oscar at 25/08/2025
Feature: Funcionalidad de Ordenes
  @TestOrder
  Scenario Outline: Ingresar Orden
    Given defino la URL "https://petstore.swagger.io/v2/store"
    When quiero comprar <cantidad> mascota(s) con el ID <mascotaID> para el dia <fecha>
    Then recibo un codigo de respuesta <StatusCodeEsperado>
    And recibo un body con <mascotaID> y <cantidad> indicados

    Examples:
    |mascotaID|cantidad|fecha                     |StatusCodeEsperado|
    |1        |1       |"2025-01-01T20:20:55.913Z"|200               |
    |3        |2       |"2025-11-02T20:20:55.913Z"|200               |
    |5        |1       |"2025-08-27T20:20:55.913Z"|200               |



  @TestOrder
  Scenario Outline:Obtener orden
    Given defino la URL "https://petstore.swagger.io/v2/store"
    When  quiero consultar una orden con el ID: <ordenID>
    Then recibo un codigo de respuesta <StatusCodeEsperado>
    And recibo un body con el parametro de ID <ordenID>


    Examples:
    |ordenID|StatusCodeEsperado|
    |1      |200               |
    |6      |200               |
    |7      |200               |

