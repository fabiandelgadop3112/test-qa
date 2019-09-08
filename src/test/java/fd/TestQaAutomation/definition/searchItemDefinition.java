package fd.TestQaAutomation.definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fd.TestQaAutomation.steps.searchItemSteps;
import net.thucydides.core.annotations.Steps;

public class searchItemDefinition {

	@Steps 
	
	searchItemSteps SearchItemSteps;
	
	@Given("^Yo como usuario al realizar la busqueda de un producto en el cuadro de busqueda con el valor \"([^\"]*)\"$")
	public void yo_como_usuario_al_realizar_la_busqueda_de_un_producto_en_el_cuadro_de_busqueda_con_el_valor(String searchText) {
		
		SearchItemSteps.enterTextSearch(searchText);
	}

	@When("^hago click en el boton buscar$")
	public void hago_click_en_el_boton_buscar() {
		SearchItemSteps.submitSearch();
	}

	@Then("^Debe devolver los resultados de la busqueda y mostrar los filtros disponibles$")
	public void debe_devolver_los_resultados_de_la_busqueda_y_mostrar_los_filtros_disponibles() {
		SearchItemSteps.validateResultsPage();
	}

}
