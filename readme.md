# HERRAMIENTA DE AUTOMATIZACION FILTROS Y ORDENAMIENTO ebay.com

Esta herramienta de automatización realiza la ejecución de los casos de prueba asociados al proceso de búsqueda, filtro y ordenamiento dentro de la página de compras ebay.com. 

La ejecución se realiza a partir del planteamiento de cuatro historias de usuario:

* IngresoWebPage (profile `caseone`)
* Búsqueda de producto (profile `casetwo`)
* Validación de Filtros (profile `casethree`)
* Validación de ordenadores (profile `casefour`)

Si se desean ejecutar todos los casos de prueba propuestos el profile configurado es `allCases`

(El caso de prueba con profile `casefour` es el encargado de realizar la búsqueda, filtrar por marca, estado, tomar e imprimir la cantidad de resultados, ordenar por precio ascendente y tomar los productos para el manejo de los datos).

Siendo cada historia de usuario prerrequisito de la siguiente en el respectivo orden. El planteamiento de las historias de usuario puede verse en el archivo properties:

[serenity.properties](https://github.com/fabiandelgadop3112/test-qa/blob/master/serenity.properties)

## CONTEXTO TECNICO DE LA HERRAMIENTA

A partir del planteamiento de las historias de usuario se realiza la implementación de la herramienta bajo la integración de Cucumber, Serenity y Java como lenguaje de desarrollo.

Bajo la estrategia de desarrollo BDD, cada historia de usuario se asocia a una estructura en java para su ejecución, donde la ejecución del proceso se realiza mediante la clase Runner a partir de la creación de un profile en el archivo [POM.xml](https://github.com/fabiandelgadop3112/test-qa/blob/master/pom.xml) para cada caso de prueba; y un profile general para la ejecución total.

Adicionalmente a la clase runner. Las clases definition realizan la conexión entre el archivo .feature a la ejecución implementada con java en las clases steps. Para finalizar, las clases steps envían los parámetros inicializados desde el archivo .definition hasta las clases PageObject; estas clases serán las encargadas de interactuar directamente con el navegador y realizar las validaciones de los casos de prueba.

## PREREQUISITOS

* JDK 12.0.2.
* Selenium.
* Jenkins instalado localmente (Para el proceso actual se instala en la ruta C:\Jenkins).
* Maven. (En el proceso actual instalado en la ruta C:\Maven)

### Configuracion de variables del sistema
Una vez se instalan los prerrequisitos mencionados, verificar o configurar las variables de entorno de la siguiente manera:

**MAVEN_HOME** `C:\Maven\apache-maven-3.6.2` o ruta de instalación de Maven.
**MAVEN** `%MAVEN_HOME%\bin`
**JAVA_HOME** `C:\Program Files\Java\jdk1.8.0_144 ` o ruta de instalación de Java.

### Instalacion cucumber

Desde Eclipse, realizar la instalación del plugin de Cucumber para Eclipse:

1. Click en el botón add.
2. Indicar el nombre “Cucumber” y el Location http://cucumber.github.com/cucumber-eclipse/update-site click en OK.
3. Visualizar el software disponible y seleccionar la opción “Cucumber Eclipse Plugin”.
4. Click en Next.
5. Click en Next para la pantalla de detalles de instalación.
6. Aceptar los términos de la licencia y dar click en finish.
7. En el mensaje de advertencia dar click en OK
8. Reiniciar Eclipse.

## GUIA DE INSTALACION

1. Descargar el proyecto desde el repositorio de GitHub en una ruta local:

```sh
$ git clone https://github.com/fabiandelgadop3112/test-qa.git
```

2. Abrir Jenkins y configurar el JDK y MAVEN para Jenkins en la opción **"Global Tools Configuration"** en la administración de Jenkins.

![Imagen 1](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image1.png)

3. En la opción JDK añadir un JDK con nombre JAVA SE 8 e indicar la ruta en el cual se encuentra instalado el JDK localmente.

![Imagen 2](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image2.png)

4. Realizar el mismo proceso para la configuración del Maven

![Imagen 3](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image3.png)

5. Verificar si se cuenta con el Plugin de Maven Instalado, en caso contrario realizar la instalación siguiendo los siguientes pasos:

* En el home de Jenkins ir a la opción **"administar Jenkins"**

![Imagen 4](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image4.png)

* Seleccionar la opción **"administrar Plugins"**

![Imagen 5](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image5.png)

* Verificar en los Plugins Instalados que se encuentre el plugin MAVEN Integration Plugin

![Imagen 6](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image6.png)

* En caso contrario realizar la búsqueda y descargar desde la opción **"todos los plugin"**

6. Para integrar el proyecto a Jenkins, desde el Home Seleccionar la opción **"Nueva Tarea"**

![Imagen 7](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image7.png)

7. Ingresar un nombre para el proyecto a crear y seleccionar la opción **"Crear un proyecto Maven"**. Seleccionar la opción **"OK"**.

![Imagen 8](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image8.png)

8. Ingresar una descripción adecuada para el proyecto

![Imagen 9](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image9.png)

9. En la configuración del origen del código fuente elegir **"ninguno"**

![Imagen 10](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image10.png)

10. En la opción proyecto, ingresar la ruta del archivo `POM.XML` del proyecto (ruta local en la cual se descargó el proyecto desde GitHub). Para el caso actual `C:\QA\test-qa\pom.xml`.

En la opción **"goles y opciones"** indicar el comando 

```sh
$ clean verify -P casefour. 
```
(Luego del parámetro -P se indica el profile configurado en el pom, del caso de prueba que se desea ejecutar).

![Imagen 11](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image11.png)

11. Click en Apply y Guardar

12. Para configurar la generación de la evidencia, desde el proyecto creado en Jenkins ir a la opción **"Configurar"**.

![Imagen 12](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image12.png)

13. Ir a la opción **"Pasos Posteriores"** y agregar un nuevo paso **"Ejecutar un comando de Windows"**.

![Imagen 13](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image13.png)

14. Agregar los comandos 

```sh
$ cd C:\QA\test-qa
```

(ruta en la cual se encuentra el proyecto) para ubicar la consola de Jenkins en la carpeta del proyecto y posterior indicar el comando 

```sh
$ mvn serenity:aggregate
```

el cual se encarga de construir la evidencia a partir del último caso de prueba ejecutado en el build (profile configurado).

![Imagen 14](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image14.png)

15. Aplicar y salvar los cambios.

16. Para configurar el envío por correo, ir a la opción de administración de Jenkins e ingresar al información del correo de envío y la configuración SMTP.

![Imagen 15](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image15.png)

17. Posteriormente configurar dentro del proyecto la notificación por correo de la tarea ejecutada

![Imagen 16](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image16.png)

## EJECUCION DESDE JENKINS

1. Una vez configurado el proceso desde Jenkins, en el home, seleccionar la tarea configurada.

![Imagen 17](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image17.png)

2. Seleccionar la opción ***"construir ahora"***.

![Imagen 18](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image18.png)

En este punto iniciara la ejecución del caso de prueba configurado. El progreso se muestra en la parte derecha de la pantalla, al hacer click en la barra de progreso se muestra la ejecución en consola en tiempo real.

![Imagen 19](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image19.png)

3. Una vez finaliza la ejecución se muestra el resultado de salida de consola.

![Imagen 20](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image20.png)

## VALIDACION DE EVIDENCIAS

1. En la ruta donde se encuentra el proyecto descargado ir al directorio: `*\test-qa\target\site\serenity`.

2. Ubicar el archivo `index.html`, el cual contiene la evidencia de ejecución.

![Imagen 21](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image21.png)

3. Se entrega el resultado de la ejecución en el archivo `index.html`.

![Imagen 22](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image22.png)

4. En la parte inferior del reporte se encuentra el escenario ejecutado con los pasos de la ejecución y la evidencia de esta.

![Imagen 23](https://killcloud.nyc3.digitaloceanspaces.com/readme/Image23.png)

### ARCHIVOS ADICIONALES Y EVIDENCIA DE LA EJECUCION

De manera informativa, en la carpeta [evidencia](https://github.com/fabiandelgadop3112/test-qa/tree/master/evidence), se tienen las evidencias de ejecución indicando el resultado de la prueba y la salida por consola del proceso.

***Si se desean ejecutar todos los casos de prueba propuestos el profile configurado debe ser “allCases”***