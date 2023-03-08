package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
               // "pretty",to get detailed report on the console
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
        },
        features ="src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun=false,
        tags ="",
        publish = true
        //to get link on the console to share
)


public class CukesRunner {





}
