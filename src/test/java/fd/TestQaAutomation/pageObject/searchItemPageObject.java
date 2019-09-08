package fd.TestQaAutomation.pageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.ebay.com/")
public class searchItemPageObject extends enterPageObject {
	
	
	
	//Mapeo del boton de busqueda
	@FindBy(id = "gh-btn")
	public WebElementFacade searchButton;  
	
	//Mapeo de la grilla de resultados
	@FindBy(id = "srp-river-results")
	public WebElementFacade resultsBox;
	
	//Mapeo del filtro de Marca
	//Se mapea el label del titulo
	@FindBy(xpath = "//H3[@class='x-refine__item'][text()='Marca']")
	public WebElementFacade labelBrand;
	//
	
	//Mapeo del filtro Estado
	//Se mapea el label del filtro
	@FindBy(xpath = "//H3[@class='x-refine__item'][text()='Estado']")
	public WebElementFacade labelState;

	
	public void enterTextSearch(String textSearch) {
		txtSearchBox.sendKeys(textSearch);
		
	}

	public void submitSearch() {
		searchButton.click();
	}

	public void validateResultsPage() {

		/*Se valida que el div de los resultados se muestre en la página*/
		resultsBox.isDisplayed();
		this.elementHighlight(resultsBox);
		
		/*Se valida que el filtro de marca este disponible, a partir del título del textbox*/
		
		labelBrand.isDisplayed();
		labelBrand.isPresent();
		this.elementHighlight(labelBrand);
		
		/*Se valida que el filtro de estado este disponible, a partir del título del textbox*/
		labelState.isDisplayed();
		labelState.isPresent();
		this.elementHighlight(labelState);
	}

}
