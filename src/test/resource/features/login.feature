Feature: Login Functionality

  #Scenario: Validate Login
    #Given I navigate to login page
    #And I enter email "kallzz.commercial@gmail.com"
    #And I enter password "autm1234"
    #When I click on login
    #Then I validate success message

  # scenario outline is to acheive the data driven approach with examples data
  Scenario Outline: Validate Login
    Given I navigate to login page
    And I enter email <email>
    And I enter password <password>
    When I click on login
    Then I validate success message

    Examples: 
      | email                        | password |
      | kallzz.commercial@gmail.com  | autm1234 |
      | kallzz.commercial2@gmail.com | autm1234 |
