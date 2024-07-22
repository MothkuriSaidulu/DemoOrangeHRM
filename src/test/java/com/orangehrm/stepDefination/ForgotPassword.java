package com.orangehrm.stepDefination;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.orangehrm.driverfactory.DriverFactory;
import com.orangehrm.utilities.CommonObjects;
import com.orangehrm.utilities.ReadExcelData;

import io.cucumber.java.en.*;

public class ForgotPassword {

	public static final Logger logger = LogManager.getLogger(ForgotPassword.class);
	public static CommonObjects objComm = new CommonObjects(DriverFactory.getDriver());

	
	/*
	 * 
	 */
	@When("user clicked on forgot as {string}.")
	public void user_clicked_on_forgot_as(String value) {

		try {
			objComm.clickOnLinkByClass(value);
			logger.info(" >>>>>> User Succesfully Clicked on  : " + value);

		} catch (Exception e) {
			logger.warn(e.getMessage());
			Assert.fail(" >>>>>> User failed to click on : " + value);

		}

	}

	@When("user entered {string} from sheet {string} for Test Case {string}.")
	public void user_entered_from_sheet_for_test_case(String value, String sheetname, String TestCaseId) {

		String enterText = ReadExcelData.getCellData(sheetname, TestCaseId, value);

		try {
			objComm.enterTextByFormcontrolName(value, enterText);
			logger.info(" >>>>>> User Succesfully Entered : " + value);

		} catch (Exception e) {
			logger.warn(e.getMessage());
			Assert.fail(" >>>>>> User failed to enter : " + value);

		}

	}

	/*
	 * Common step for click on button by contains text
	 */
	@When("user clicked on button {string}.")
	public void user_clicked_on_button(String value) {
		try {
			objComm.clickOnButtonByContainText(value);
			logger.info(" >>>>>> User Succesfully clicked on :  " + value);

		} catch (Exception e) {
			logger.warn(e.getMessage());
			Assert.fail(" >>>>>> User failed to click on : " + value);

		}
	}

}
