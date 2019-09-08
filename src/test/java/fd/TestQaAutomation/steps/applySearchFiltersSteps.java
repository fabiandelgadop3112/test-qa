package fd.TestQaAutomation.steps;
import fd.TestQaAutomation.pageObject.applySearchFiltersPageObject;
import net.thucydides.core.annotations.Step;

public class applySearchFiltersSteps {
	
	applySearchFiltersPageObject ApplySearchFiltersPageObject;
	
	@Step
	public void searchItem(String textSearch) {
		
		ApplySearchFiltersPageObject.open();
		ApplySearchFiltersPageObject.searchItem(textSearch);
		
	}
	
	@Step
	public void selectFilters(String brand, String status) {
		
		ApplySearchFiltersPageObject.selectFilters(brand,status);
		
	}
	
	@Step
	public void validateFiltersResults() {
		
		ApplySearchFiltersPageObject.validateFiltersResults();
		
	}

}