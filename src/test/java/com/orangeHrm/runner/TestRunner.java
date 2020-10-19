package com.orangeHrm.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
glue="com/orangeHrm/steps",//where we cna find the implementation code for 
//gherkin steps we will specify the packag of the steps
//monochrome=true,
//dryRun=false,//if set to true it will quickly scan that all ghrekin steps
//if set to false no actual expression will happen
//strict = true,
tags="@smoke",
plugin= {
		"pretty",//prints gherkin steps in console
		"html:target/cucumber-default-report",//create basic html report in specified location
		"json:target/cucumber.json"
})
public class TestRunner {

}
