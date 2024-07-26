Feature: Login Module.

  Background: 
    Given user launched browser and entered url.

  @ALL
  Scenario Outline:: Verify login functionality with more users
    When user entered "userEmail" from Test Case "<TestCaseID>".
    And user entered "userPassword" from Test Case "<TestCaseID>".
    And user clicked on "login".
    And verify popup mesaage "Login Successfully".
  	And user clicked on button "Sign Out".
		And verify popup mesaage "Logout Successfully".
		
		Examples:
		|TestCaseID|
		|TC_001|
		|TC_002|
		|TC_003|