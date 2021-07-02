Feature: Login Feature
  Verify if user is able to Login in to the site

 Scenario: Login as a authenticated user
    Given user is on homepage
    And user enters "Admin" and "admin123"
    Then validate dashboard page
   	
 Scenario: Login as a authenticated user
    Given user is on homepage
    And user enters "InvalidUser" and "pasword1"
    Then validate error message
