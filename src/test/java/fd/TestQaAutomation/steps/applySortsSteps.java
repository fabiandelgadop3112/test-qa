package fd.TestQaAutomation.steps;

import fd.TestQaAutomation.pageObject.applySortsPageObject;
import net.thucydides.core.annotations.Step;

public class applySortsSteps {
	
	applySortsPageObject ApplySortsPageObject;

	@Step
	public void makeSearch(String textSearch, String brand, String status) {
		
		ApplySortsPageObject.open();
		ApplySortsPageObject.makeSearch(textSearch,brand,status);
		
	}

	@Step
	public void selectSort(String sortFilter) {
		
		ApplySortsPageObject.selectSort(sortFilter);
		
	}

	@Step
	public void validateSortsProducts() {
		
		ApplySortsPageObject.validateSortsProducts();
		
	}

}
