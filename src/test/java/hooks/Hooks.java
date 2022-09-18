package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class Hooks {

    @After(value = "@Registration")
    public void tearDown(Scenario scenario) throws IOException {


        if (scenario.isFailed()) {


            ReusableMethods.getScreenshot(scenario.getName());
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "screenshots");
        }
    }
}
