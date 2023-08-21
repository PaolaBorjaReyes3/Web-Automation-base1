Feature: API Tests

  @Test01
  Scenario: Retrieve user data
    Given url 'https://reqres.in'
    And path '/api/users?page=2'
    When method GET
    Then status 200
    #And match response == { id: 1, name: 'John' }