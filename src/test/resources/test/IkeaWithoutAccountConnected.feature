@Web
Feature: Re-Test Cases for Ikea Website without account Access
  Background:
    Given I am on the homePage

  @severity=critical
  @bug_1498
  Scenario: Error page 404
    Given Go to the page notice information page
    When Scroll down and click on the first link of *charte de protection des données*
    Then A 404 error page is displayed

#  @severity=minor
#  @bug_1535
#  Scenario: Invisible ReCAPTCHA
#    And Click on the connection icon, then on *se connecter*
#    When Select *jachète pour mon entreprise*
#    And Fill in the information to create the company account then press the button *créer un compte*
#    Then A congratulation window is displayed
#    And A dynamic transparent component can be seen at the bottom right of the page

  @severity=minor
  @bug_1582
  Scenario: Lack of verification
    And Click on the truck icon reserved for tracking the order
    When Display of the page *gérer votre commande*, fill the following fields with errors
    Then An error message is displayed below the order number field
    But For the email or phone number field, no error message is displayed