package fd.TestQaAutomation.definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fd.TestQaAutomation.steps.applySortsSteps;
import net.thucydides.core.annotations.Steps;

public class applySortsDefinition {

		
	@Steps
	applySortsSteps ApplySortsSteps;
		
	
	@Given("^Yo como usuario al contar con el resultado de una búsqueda de valor \"([^\"]*)\" y poseer filtros aplicados por Marca \"([^\"]*)\" y por Estado  \"([^\"]*)\"$")
	public void yo_como_usuario_al_contar_con_el_resultado_de_una_búsqueda_de_valor_y_poseer_filtros_aplicados_por_Marca_y_por_Estado(String textSearch, String brand, String status) {
		
		ApplySortsSteps.makeSearch(textSearch,brand,status);

	}

	@When("^Realizo el ordenamiento por Precio \"([^\"]*)\"$")
	public void realizo_el_ordenamiento_por_Precio_y_o_por_nombre_y(String sortFilter) {
		ApplySortsSteps.selectSort(sortFilter);
	}
	
	@Then("^Deseo ver los productos ordenados y tomar los cinco primeros del listado de resultados\\.$")
	public void deseo_ver_los_productos_ordenados_y_tomar_los_cinco_primeros_del_listado_de_resultados() {
		ApplySortsSteps.validateSortsProducts();
	}

	
}
