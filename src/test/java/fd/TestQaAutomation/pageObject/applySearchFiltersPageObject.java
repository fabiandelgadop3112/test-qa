package fd.TestQaAutomation.pageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.ebay.com/")
public class applySearchFiltersPageObject extends searchItemPageObject{
	
		public String xpathFilterBrand; 
		public String xpathFilterStatus;
		public String totalResults;
		public WebElementFacade brandFilter;
		public WebElementFacade statusFilter;
		
		@FindBy(className= "srp-controls__count-heading")
		WebElementFacade lblTotalResults;
				
	public void searchItem(String textSearch) {
		
		this.enterTextSearch(textSearch);
		this.submitSearch();
		
	}

	public void selectFilters(String brand, String status)  {
		
		xpathFilterBrand = "//SPAN[@class='cbx x-refine__multi-select-cbx'][text()='"+brand+"']";
		xpathFilterStatus = "//SPAN[@class='cbx x-refine__multi-select-cbx'][text()='"+status+"']";
		
		brandFilter = $(xpathFilterBrand);
		this.elementHighlight(labelBrand);
		this.elementHighlight(brandFilter);
		brandFilter.click();
		
		
		statusFilter = $(xpathFilterStatus);
		this.elementHighlight(labelState);
		this.elementHighlight(statusFilter);
		statusFilter.click();
		
	
	}

	public void validateFiltersResults() {
		
		this.elementHighlight(lblTotalResults);
		totalResults = lblTotalResults.getText();
		System.out.print("**********EL TOTAL DE RESULTADOS ES********\n");
		System.out.print(totalResults+"\n\n\n");
		
	}

}
