package fd.TestQaAutomation.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import fd.TestQaAutomation.TestQAautomationFunctions;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.ebay.com/")
public class applySortsPageObject extends applySearchFiltersPageObject{
	
	
	public String	xPathsortBy;
	public String	xPathsortResultBox;
	public String	infoNameProduct;
	public String	infoPriceProduct;

	public WebElementFacade sortBy;
	public WebElementFacade resultBox;
	public WebElement nameProduct;
	public WebElement priceProduct;
	
	@FindBy(xpath= "(//DIV[@class='srp-controls__control--legacy'])[3]")
	WebElementFacade sortBox;
	
	

	public void makeSearch(String textSearch, String brand, String status) {
		
		this.searchItem(textSearch);
		this.selectFilters(brand, status);
		this.validateFiltersResults();
		
		
	}

	public void selectSort(String sortFilter) {
		this.elementHighlight(sortBox);
		sortBox.click();	
		sortBox.click();
		xPathsortBy = "//*[contains(text(),'"+sortFilter+"')]";
		sortBy = $(xPathsortBy);
		this.elementHighlight(sortBy);
		sortBy.click();
		
	}

	public void validateSortsProducts() {
		
		 String[][]	resultProducts = new String[5][2];
		 String[][] orderProducts = new String[5][2]; 
		 
		 for (int i=1; i<=5; i++)
		{
			xPathsortResultBox = "//LI[@id='srp-river-results-listing"+i+"']";
			resultBox = $(xPathsortResultBox);
			this.elementHighlight(resultBox);
			
			nameProduct  = resultBox.findElement(By.className("s-item__title"));
			infoNameProduct = nameProduct.getText();
			
			priceProduct = resultBox.findElement(By.className("s-item__price"));
			infoPriceProduct = priceProduct.getText();
	
			
			resultProducts[i-1][0] = infoNameProduct.toString();
			resultProducts[i-1][1] = infoPriceProduct.toString();
			
		}
		
		
		System.out.print("*******PRIMEROS 5 RESULTADOS DE LA BUSQUEDA**********\n\n");
		TestQAautomationFunctions.printArray(resultProducts);
		System.out.print("\n\n\n");
		
		/*Se invoca la funcion de ordenamiento y se ordenan los resultados por Nombre
		 * De manea ascendente*/
		
		System.out.print("*******RESULTADOS ORDENADOS POR NOMBRE DE MANERA ASCENDENTE**********\n\n");
		orderProducts = TestQAautomationFunctions.Array(resultProducts, 0, true);
	    TestQAautomationFunctions.printArray(orderProducts);
	    System.out.print("\n\n\n");
	    /*Se invoca la funcion de ordenamiento y se ordenan los resultados por precio
		 * De manea descendente (Precio de menor a mayor)*/
	    
		System.out.print("*******RESULTADOS ORDENADOS POR PRECIO DE MANERA DESCENDENTE**********\n\n");
		orderProducts = TestQAautomationFunctions.Array(resultProducts, 1, false);
	    TestQAautomationFunctions.printArray(orderProducts);

	}

}
