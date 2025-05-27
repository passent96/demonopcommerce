package org.example.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "C:\\Users\\Ram\\IdeaProjects\\p_demonopcommerce\\src\\main\\resources\\Features",
        glue = {"org.example.stepDefinitions"},
        monochrome = true,
        plugin = {"pretty",
        "html:target/cucumber.html",
        "json:target/cucumber.json",
        "junit:target/cukes.xml",
        "rerun:target/return.txt"},
        dryRun = false,
        tags="@smoke"
)
public class runner extends AbstractTestNGCucumberTests {

}
