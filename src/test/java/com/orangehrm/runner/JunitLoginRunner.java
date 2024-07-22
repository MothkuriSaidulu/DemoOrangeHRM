package com.orangehrm.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
//		"src\\test\\resources\\Features\\Login.feature"   
		"src\\test\\resources\\Features\\LoginTestWithMore.feature"  
}, dryRun = false, monochrome = true, glue = {
				"com.orangehrm.hooks", "com.orangehrm.stepDefination" }, plugin = { "pretty",
						"html:target\\cucumber-reports\\CucumberTestReport.html",
						"html:target\\cucumber-reports\\cucumber-pretty",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
//						tags = "@Forgot"

						tags = "@Regression"

)
public class JunitLoginRunner {

}
