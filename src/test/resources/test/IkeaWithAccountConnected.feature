@Web
Feature: Re-Test Cases for Ikea Website without account Access
  Background:
    Given I am on the homePage
    And I get on login session
    And I connect to my account

  @severity=minor
  @bug_1537
  Scenario: Language error : English ways on French website
    And Browse theses differents tabs *the profile*, *transactions* and *members links*
    Then We observe that in the different tabs some texts are in English

  @severity=critical
  @bug_1547
  Scenario: Bad character management
    When Once connected, the panel is displayed click on *mon profil*
    And Click on *modifier* located at the level of *compte* option *personnal*
    And Fill the field *nom supplémentaire* with special caracter
    Then The name is accepted despite the fact that it contains an impermissible character

  @severity=minor
  @bug_1564
  Scenario: Pop-in message in english
    When Select an article
    And Add it to your favorites
    Then The pop-in message of confirmation is in English




