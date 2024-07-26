package com.orangehrm.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
		"src\\test\\resources\\Features\\Login.feature"   
//		"src\\test\\resources\\Features\\LoginTestWithMore.feature"  
}, dryRun = false, monochrome = true, glue = {
				"com.orangehrm.hooks", "com.orangehrm.stepDefination" }, plugin = { "pretty",
						"html:target\\cucumber-reports\\CucumberTestReport.html",
						"html:target\\cucumber-reports\\cucumber-pretty",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
						tags = "@ALL"

)
public class TestNGLoginRunner extends AbstractTestNGCucumberTests {

}
