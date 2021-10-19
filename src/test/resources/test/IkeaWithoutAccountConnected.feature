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

  @severity=minor
  @bug_1582
  Scenario: Lack of verification
    And Click on the truck icon reserved for tracking the order
    When Display of the page *gérer votre commande*, fill the following fields with errors
    Then An error message is displayed below the order number field
    But For the email or phone number field, no error message is displayed

#  @severity=minor
#  @bug_1561
#  Scenario: Overlay of elements
#    And Click on "produits", then on "meubles" and on "canapés"
#    And Click on "convertibles"
#    And Scroll down and click on the article "canapé convertible angle de rangement" of the mark "FRIHETEN"
#    When Add this item to cart and view cart
#    And Click on "passer commande", then enter the <postal_code> and click on "suivant"
#    And Leave the standard delivery method and check "je veux recevoir un devis pour un service de montage"
#    And Check the chart boxe and click on "continuer" and on "suivant"
#    And Fill in your login details as an individual with <firstname>,<name>,<email>,<phone_number>,<address>,<city>
#    And Click on "suivant" and fill the specification and click on "suivant"
#    Then On the right-hand side of the command summary panel, the editing icon is superimposed on a warning message

