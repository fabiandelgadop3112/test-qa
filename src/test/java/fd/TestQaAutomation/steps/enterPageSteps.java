package fd.TestQaAutomation.steps;

import fd.TestQaAutomation.pageObject.enterPageObject;
import net.thucydides.core.annotations.Step;

public class enterPageSteps {
	
	enterPageObject EnterPage;
	
	@Step
	public void enterPage()
	{
		EnterPage.open();

	}
	
	@Step
	public void validatePage() {
		
		EnterPage.validatePage();
	}

}
