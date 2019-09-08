package fd.TestQaAutomation.definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fd.TestQaAutomation.steps.enterPageSteps;
import net.thucydides.core.annotations.Steps;

public class enterPageDefinition {
	
	@Steps
	enterPageSteps EnterPageSteps;
	
	
	@Given("^Yo como usuario deseo ingresar a la url de la pagina de ebay$")
	public void yo_como_usuario_deseo_ingresar_a_la_url_de_la_pagina_de_ebay() {

		EnterPageSteps.enterPage();
	}

	@When("^se accede a la URL$")
	public void se_accede_a_la_URL() {
	    
	}

	@Then("^Se despliega la pagina de ebay con el formulario de busqueda\\.$")
	public void se_despliega_la_pagina_de_ebay_con_el_formulario_de_busqueda() {
		EnterPageSteps.validatePage();
	}



}

