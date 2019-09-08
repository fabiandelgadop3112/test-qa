#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@EjecucionTotal
Feature: Validacion de resultados de una busqueda Realizada a trav�s de un e-commerce
  El usuario debe poder ingresar a la pagina de ebay y realizar la busquedad de un producto determinado 
  permitiendo realizar un filtro de marca en los resultados
  obtenidos y ordenando el resultado filtrado por precio y nombre.
  y ordenenando los resultados

  @IngresoWebPage
  Scenario: Validacion de acceso a la pagina de ebay
    Given Yo como usuario deseo ingresar a la url de la pagina de ebay
    When se accede a la URL
    Then Se despliega la pagina de ebay con el formulario de busqueda.

 	@BusquedaDeProducto
 	Scenario: Validación del proceso de búsqueda de producto
 		Given Yo como usuario al realizar la busqueda de un producto en el cuadro de busqueda con el valor "Shoes"
 		When hago click en el boton buscar
 		Then Debe devolver los resultados de la busqueda y mostrar los filtros disponibles
 		
 	@ValidacionDeFiltros
 	Scenario: Validacion de aplicación de filtros en la búsqueda realizada
 		Given Yo como usuario al recibir los resultados de una busqueda con el valor "Shoes"
 		When Deseo filtrar los resultados por Marca "PUMA" y por Estado "Nuevo"
 		Then Se deben mostrar los resultados y el total de resultados acorde a los filtros seleccionados
 	
 	@ValidacionDeOrdenadores
 	Scenario: Validacion de ordenamiento de resultados acorde a la opcion seleccionada
 		Given Yo como usuario al contar con el resultado de una búsqueda de valor "Shoes" y poseer filtros aplicados por Marca "PUMA" y por Estado  "Nuevo"
 		When  Realizo el ordenamiento por Precio "Precio + Envío: más bajo primero"
 		Then Deseo ver los productos ordenados y tomar los cinco primeros del listado de resultados.