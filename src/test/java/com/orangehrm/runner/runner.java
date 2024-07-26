package com.orangehrm.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
		"src\\test\\resources\\Features\\Login.feature" }, dryRun = false, monochrome = false, glue = {
				"com.orangehrm.hooks", "com.orangehrm.runner" }, plugin = { "pretty",
						"html:target\\cucumber-reports\\CucumberTestReport.html",
						"html:target\\cucumber-reports\\cucumber-pretty",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, tags = "@ALL"

)
public class runner {

}
