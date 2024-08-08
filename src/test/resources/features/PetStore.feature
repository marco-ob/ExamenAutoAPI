Feature: Pruebas de Servicio de la API Swagger Store

  Scenario Outline: Crear una orden con método POST
    Given que tengo una orden con los siguientes datos <id>, <petId>, <quantity>, "<shipDate>", "<status>", <complete>
    When envío una petición POST al endpoint /store/order
    Then el código de respuesta es <responseStatus>
    And el cuerpo de la respuesta contiene id : <id>, petId: <petId>, quantity: <quantity>, "shipDate": "<shipDate>", "status": "<status>", complete: <complete>

    Examples:
      | id | petId | quantity | shipDate             | status  | complete | responseStatus |
      | 1010  | 1010   | 959        | 2024-08-07T23:55:10Z | placed  | true     | 200            |


  Scenario Outline: Consultar una orden con método GET
    Given que tengo una orden existente con id <orderId>
    When envío una petición GET al endpoint /store/order/{orderId}
    Then el código de respuesta es <responseStatus>
    And el cuerpo de la respuesta contiene id : <id>, petId: <petId>, quantity: <quantity>, "shipDate": "<shipDate>", "status": "<status>", complete: <complete>
    Examples:
      | orderId | petId | quantity | shipDate             | status  | complete | responseStatus |
      | 1010       | 1010   | 959        | 2024-08-07T23:55:10Z | placed  | true     | 200            |
