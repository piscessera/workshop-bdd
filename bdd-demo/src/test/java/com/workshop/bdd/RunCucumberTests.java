package com.workshop.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

// Todo 2
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-result", "json:target/cucumber-json/cucumber.json"})
public class RunCucumberTests {
}
