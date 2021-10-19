@Web
Feature: Re-Test Cases for Ikea Website without account Access
  Background:
    Given I am on the homePage
    And I get on login session
    And I connect to my account

  @severity=minor
  @recommandation_1505
  Scenario: Add a checkbox below the main address
    When Once connected, click on *gérer votre compte*
    And Click on *adresse*
    Then The main address is displayed
    But There is no possibility to make the main address the default delivery address

  @severity=minor
  @bug_1508
  Scenario: Button not-functional
    When Once connected, click on *gérer votre compte*
    And Click on *adresse*
    And At the level of *adresse de livraison*, click on *modifier*
    And In the case of an address deletion already existing, click on *supprimer*
    And A pop-in window will appear stating that the address has been deleted
    And Click on the button *rejeter* to cancel the current action
    Then Clicking on the button *rejeter* does not change anything

  @severity=minor
  @bug_1509
  Scenario: Grammar error
    When Once connected, click on *gérer votre compte*
    And Click on *adresse*
    And In the level of *adresse principale*, click on *modifier*
    And Fill the form leaving the address field empty
    Then An error is displayed below the address field
    But the error text contains a grammatical error

  @severity=minor
  @bug_1537
  Scenario: Language error : English ways on French website
    And Browse theses differents tabs *the profile*, *transactions* and *members links*
    Then We observe that in the different tabs some texts are in English

  @severity=critical
  @bug_1547
  Scenario: Bad character management
    When Once connected, the panel is displayed click on *mon profil*
    And Click on *modifier* located at the level of *compte-->personnal*
    And Fill the field *nom supplémentaire* with special caracter
    Then The name is accepted despite the fact that it contains an impermissible character

  @severity=minor
  @bug_1564
  Scenario: Pop-in message in english
    When Select an article
    And Add it to your favorites
    Then The pop-in message of confirmation is in English




