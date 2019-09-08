package fd.TestQaAutomation.definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fd.TestQaAutomation.steps.applySearchFiltersSteps;
import net.thucydides.core.annotations.Steps;

public class applySearchFiltersDefinition {
	
	@Steps
	applySearchFiltersSteps ApplySearchFiltersSteps;
	
	@Given("^Yo como usuario al recibir los resultados de una busqueda con el valor \"([^\"]*)\"$")
	public void yo_como_usuario_al_recibir_los_resultados_de_una_busqueda_con_el_valor(String textSearch) {
		ApplySearchFiltersSteps.searchItem(textSearch);
	}

	
	@When("^Deseo filtrar los resultados por Marca \"([^\"]*)\" y por Estado \"([^\"]*)\"$")
	public void deseo_filtrar_los_resultados_por_Marca_y_por_Estado(String brand, String status) {
		ApplySearchFiltersSteps.selectFilters(brand,status);
	}

	@Then("^Se deben mostrar los resultados y el total de resultados acorde a los filtros seleccionados$")
	public void se_deben_mostrar_los_resultados_y_el_total_de_resultados_acorde_a_los_filtros_seleccionados() {
		ApplySearchFiltersSteps.validateFiltersResults();
	}


}
