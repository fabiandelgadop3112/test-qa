package fd.TestQaAutomation.pageObject;



import org.openqa.selenium.JavascriptExecutor;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.ebay.com/")
public class enterPageObject extends PageObject{

	// Mapeo de Campo de Busqueda
	@FindBy(id="gh-ac")
	public WebElementFacade txtSearchBox;
	
	public void elementHighlight(WebElementFacade element) {

		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		try{
                Thread.sleep(1000);
            }
        
        catch(InterruptedException e){
            System.out.println("thread 2 interrupted");
        }
					
		js.executeScript(
				"arguments[0].setAttribute('style', arguments[1]);",
				element, "color: green; border: 3px solid green;");
		
		Serenity.takeScreenshot();	
}

	public void validatePage() {

		txtSearchBox.isDisplayed();
		txtSearchBox.sendKeys("Testing Search Box");
		Serenity.takeScreenshot();
		
	}
	


}
