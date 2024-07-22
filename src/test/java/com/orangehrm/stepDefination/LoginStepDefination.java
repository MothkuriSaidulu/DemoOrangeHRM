package com.orangehrm.stepDefination;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.orangehrm.driverfactory.DriverFactory;
import com.orangehrm.utilities.CommonObjects;
import com.orangehrm.utilities.ReadExcelData;

import io.cucumber.java.en.*;

public class LoginStepDefination {

	public static final Logger logger = LogManager.getLogger(LoginStepDefination.class);
	public static CommonObjects objComm = new CommonObjects(DriverFactory.getDriver());

	@Given("user launched browser and entered url.")
	public void user_launched_browser_and_entered_url() {

		logger.info(" >>>>>> User launched browser successfully. ");

	}

	/*
	 * Common Step for enter Text
	 */
	@When("user entered {string} from Test Case {string}.")
	public void user_entered_from_test_case(String value, String TestCaseID) {

		String enterText = ReadExcelData.getCellData("LoginTestData", TestCaseID, value);

		try {
			objComm.enterTextByID(value, enterText);
			logger.info(" >>>>>> User entered :  " + enterText);

		} catch (Exception e) {
			logger.warn(e.getMessage());
			Assert.fail(" >>>>>> User failed to enter : " + enterText);
		}
	}
	
	/*
	 * Common Step for click on button
	 */

	@When("user clicked on {string}.")
	public void user_clicked_on(String value) {
		try {
			objComm.clickOnButtonByID(value);
			logger.info(" >>>>>> User clicked on :  " + value);

		} catch (Exception e) {
			logger.warn(e.getMessage());
			Assert.fail(" >>>>>> User failed to click on : " + value);

		}
	}

	/*
	 * Common step for verify text
	 */

	@When("verify popup mesaage {string}.")
	public void verify_popup_mesaage(String value) {

		try {
			objComm.verifyTextByContainText(value);

		} catch (Exception e) {
			logger.warn(e.getMessage());
			Assert.fail(" >>>>>> Expected and Actual not matching " + value);
		}
	}

}
