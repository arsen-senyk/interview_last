Feature: Operating on pet store with API
  Users should be able to submit GET, POST, PUT and DELETE requests to a web service

  Scenario: get all pets with status: available
    When GET request is made to https://petstore3.swagger.io/api/v3/pet/findByStatus endpoint with status available parameter
    Then the request status 200 is returned
    And the list of elements with status available is displayed

  Scenario: add a new pet
    When POST request is made to https://petstore3.swagger.io/api/v3/pet endpoint with the body C:\Users\pawel.plocki\Documents\Programy\GIT_repo\interview\src\main\resources\jsons\newPetBodyRequest.json
    Then the request status 200 is returned
    And the body is as is C:\Users\pawel.plocki\Documents\Programy\GIT_repo\interview\src\main\resources\jsons\newPetBodyRequest.json

  Scenario: change the status of a pet to 'sold'
    Given POST request is made to https://petstore3.swagger.io/api/v3/pet endpoint with the body C:\Users\pawel.plocki\Documents\Programy\GIT_repo\interview\src\main\resources\jsons\newPetBodyRequest.json
    When PUT request is made to https://petstore3.swagger.io/api/v3/pet endpoint with the body C:\Users\pawel.plocki\Documents\Programy\GIT_repo\interview\src\main\resources\jsons\changeStatusPetBodyRequest.json
    Then the request status 200 is returned
    And field status has value sold

  Scenario: delete an existing pet
    Given POST request is made to https://petstore3.swagger.io/api/v3/pet endpoint with the body C:\Users\pawel.plocki\Documents\Programy\GIT_repo\interview\src\main\resources\jsons\petBodyForDelete.json
    When DELETE request to https://petstore3.swagger.io/api/v3/pet/999 is made
    Then the request status 200 is returned
    Then GET request to https://petstore3.swagger.io/api/v3/pet/999 returns code 404
