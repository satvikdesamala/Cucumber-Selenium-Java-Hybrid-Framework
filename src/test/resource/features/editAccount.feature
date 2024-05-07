Feature: Edit Account

Background: 
Given I navigate to login page
And I enter email kallzz.commercial@gmail.com
And I enter password autm1234
When I click on login
Then I validate success message

@edit
Scenario: 
Given I click on edit account information
| FirstName | kallzz |
| LastName | kallzz |
When I click on continue
Then I validate account update confirmation message "Success: Your account has been successfully updated."