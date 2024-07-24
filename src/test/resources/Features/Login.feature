Feature: Login Module.

  Background: 
    Given user launched browser and entered url.

  @Valid @ALL
  Scenario: TC_001_Verify_login_function_with_valid_credentials.
    When user entered "userEmail" from Test Case "TC_001".
    And user entered "userPassword" from Test Case "TC_001".
    And user clicked on "login".
    And verify popup mesaage "Login Successfully".
  	And user clicked on button "Sign Out".
		And verify popup mesaage "Logout Successfully".
		
  @InValid @ALL
  Scenario: TC_002_Verify_login_Function_with_Invalid_Credentials.
    When user entered "userEmail" from Test Case "TC_004".
    And user entered "userPassword" from Test Case "TC_004".
    And user clicked on "login".
    And verify popup mesaage "Incorrect email or password.".

  @Forgot @ALL
  Scenario Outline:: TC_003_Verrify_forgot_password.
    When user clicked on forgot as "forgot-password-link".
    And user entered "userEmail" from sheet "<Sheetname>" for Test Case "<TestCaseID>".
    And user entered "userPassword" from sheet "<Sheetname>" for Test Case "<TestCaseID>".
    And user entered "confirmPassword" from sheet "<Sheetname>" for Test Case "<TestCaseID>".
		And user clicked on button "Save New Password".
		
		Examples:	
		|Sheetname|TestCaseID|
		|ForgotTestData|TC_001|
		|ForgotTestData|TC_002|