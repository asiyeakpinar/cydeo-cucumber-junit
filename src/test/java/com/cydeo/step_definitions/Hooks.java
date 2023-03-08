package com.cydeo.step_definitions;
 /*
    in this class we will bw able to pass pre- and post- conditions in each scenario and steps
     */


import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //import before method from cucumber.java not from junit
   // @Before (order = 1)
    public void setupScenario(){
        System.out.println("===setting up browser using cucumber @Before default everything");

    }
   // @Before (value = "@Login",order = 2)
    public void setupScenarioForLogins(){
        System.out.println("===setting up browser using cucumber @Before for login");

    }
    //@Before (value = "@db",order = 0)
    public void setupDatabaseScenario(){
        System.out.println("===setting up browser using cucumber @Before for database");

    }
    @After
    public void tearDownScenario(Scenario scenario)  {

       //scenario.isFailed()---> if scenario fails this method  will return true boolean value
        if(scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();

        //System.out.println(" ===closing browser using cucumber @After");
       // System.out.println("====scenario ended/take a screenshot if failed");

    }
   // @BeforeStep
    public void setupSteps(){
        System.out.println("----------------applying setup using @BeforeStep");
    }

  //  @AfterStep
    public void afterStep(){
        System.out.println("----------------applying setup using @AfterStep");
    }


}
