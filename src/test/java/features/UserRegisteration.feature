Feature: User Registeration
  I want to check that the user can register in out e-commerce website.

  Scenario Outline: User Registeration
    Given The user in the home page
    When He click on the register link
    And He entered "<firstname>", "<lastname>", "<email>", "<password>"
    Then The registeration page will be displayed successfully

    Examples: 
      | firstname | lastname | email               | password  |
      | Mohammed  | Samir    | msamiir958@gmail.com |    123456 |
      | Nour      | Samir    | nsamiir978@gmail.com | 123456789 |
