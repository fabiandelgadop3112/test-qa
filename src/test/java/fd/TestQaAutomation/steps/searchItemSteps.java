package fd.TestQaAutomation.steps;

import fd.TestQaAutomation.pageObject.searchItemPageObject;
import net.thucydides.core.annotations.Step;


public class searchItemSteps {
	
	searchItemPageObject SearchItemPageObject;
	
	@Step
	public void enterTextSearch(String textSearch) {		

		SearchItemPageObject.open();
		SearchItemPageObject.enterTextSearch(textSearch);
	}
	
	@Step
	public void submitSearch()
	{
		SearchItemPageObject.submitSearch();
	}
	
	@Step
	public void validateResultsPage()
	{
		SearchItemPageObject.validateResultsPage();
	}

}
