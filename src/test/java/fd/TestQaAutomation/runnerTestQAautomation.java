package fd.TestQaAutomation;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith (CucumberWithSerenity.class)
@CucumberOptions (features = "src/test/resources/features/ebay/forms/ResultsValidation.feature",tags= "@ValidacionDeOrdenadores")
public class runnerTestQAautomation {

}
