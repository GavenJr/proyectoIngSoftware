*https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax*
PD: JAJAJA, ya nunca sabran lo que decia aqui >:)
<!-- Los comentarios se hacen usando sintaxis HTML -->
<!-- -->
<!--
Group id: com.teamxploitdx
artifact id: proyecto_ubb
 -->

# Ingenieria de Software 2022-2

### Sistema de Encuestas que recopila informacion estrategica sobre usuarios para empresas

##### Team Xploit DX - Grupo 2 (17:10)
        
<p align="center" width="100%">
    <img width="10%" src="https://brandslogos.com/wp-content/uploads/images/large/java-logo-1.png">
    <img width="15%" src="https://e4developer.com/wp-content/uploads/2018/01/spring-boot.png">
    <img width="15%" src="https://download.logo.wine/logo/MySQL/MySQL-Logo.wine.png">
    <img width="10%" src="https://www.freepnglogos.com/uploads/logo-mysql-png/logo-mysql-how-setup-mysql-workbench-database-for-wordpress-20.png">
    <img width="15%" src="https://upload.wikimedia.org/wikipedia/commons/c/c2/Postman_%28software%29.png">
    <img width="15%" src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/PhpMyAdmin_logo_2010_hidef.svg/1200px-PhpMyAdmin_logo_2010_hidef.svg.png">
</p>

## Sobre el proyecto:
Se recomienda clonarlo en su IDE de preferencia (Ej: VS Code).

Java JDK 11 | Maven | Spring Boot 2.7.X | Arquitectura MVC.

Dependencias: Spring Boot DevTools | Spring Web | MySQL Driver | Spring data JPA | spring boot starter data jpa | spring-boot-starter-actuator
- - -
Para poder implementar el proyecto, siga el siguiente flujo:

<details><summary>VER INSTRUCCIONES</summary>
<p>
    > Crear el proyecto Spring Boot usando el Spring Initializr, o clonarlo de aqui

    > Edite el proyect properties en caso de que falten dependencias

    > Crear una base de datos MYSQL y definir sus credenciales (estas las necesitara el POM)
    >   > Si por alguna razon mysql tira errores al querer usarlo, revisen su configuracion horaria, necesitan tener la configuracion utf-8 Unicode habilitada
    
    > Inicialice la BD con el archivo initDB ubicado en /resources
    
    > Pueble la BD con el archivo populateDB
    
    > configure su archivo POM con un puerto para la spring boot app y la URI adecuada (debe ser distinto al server MySQL)
    
    > Si usa VS Code, asegurese de tener las extensiones apropiadas instaladas
    
    > Haga requests usando POSTMAN o un explorador web para certificar que todo funciona apropiadamente
</p>
</details>

Para ejecutarlo, corra el archivo "ProyectoUbbApplication.java"
- - -
El proyecto consiste en un sistema de encuestas que se dedica a recopilar informacion de usuarios, y se la entrega a las empresas encargadas en algun formato.
Esta informacion puede incluir preferencias de producto, edad, sexo, localidad, etc.

<!-- This content will not appear in the rendered Markdown -->
<!-- Los comentarios se hacen usando sintaxis HTML -->
<!-- -->

<!-- > ![Modelo ER](https://github.com/GavenJr/proyectoIngSoftware/blob/master/proyecto_ubb/src/main/resources/model/ER.jpg?raw=true) -->
<!-- <img src="https://github.com/GavenJr/proyectoIngSoftware/blob/master/proyecto_ubb/src/main/resources/model/ER.jpg" width="512x512"> -->

<!-- > ![Modelo Relacional](https://github.com/GavenJr/proyectoIngSoftware/blob/master/proyecto_ubb/src/main/resources/model/Relational_Schema.png?raw=true) -->
<!-- <img src="https://github.com/GavenJr/proyectoIngSoftware/blob/master/proyecto_ubb/src/main/resources/model/Relational_Schema.png" width="512x512"> -->

### SPRINT 1: Que esperamos lograr
Implementar los primeros 5 requisitos de sistema.
Implementar los servicios que conlleven.
Abarcar escenarios base.
- - -
##### SERVICIO 1
<details><summary>VER DETALLES</summary>
<p>
    ***COMO*** administrador ***QUIERO*** ser capaz de administrar la visibilidad de mis encuestas ***PARA*** así poder programar la publicación de alguna  ya hecha con anticipación.

    Tablas involucradas:

    - Encuesta

    Servicios requeridos:

    - Servicio para actualizar "visibilidad"

    ‌Escenario:

    - 1. Dado que me encuentro en la pantalla de encuesta al momento en que presiono el botón de "visible" , la encuesta se establecerá como "visible" o "no visible" según corresponda
</p>
</details>

##### SERVICIO 2
<details><summary>VER DETALLES</summary>
<p>
    _**COMO**_ encuestado, **QUIERO** que la aplicación me permita cambiar mis categorías de encuestas favoritas _**PARA**_ que así pueda actualizar mis preferencias de filtrado rápido de encuestas de interés"

    Tablas involucradas:

    - Preferencias
    - Usuario

    Servicios requeridos:

    - Servicio para añadir una preferencia
    - Servicio para eliminar una preferencia

    Escenarios:

    - Escenario 1: Agregar categoría
    Dado que me encuentro en la administración de usuario, al presionar el botón de agregar categoría, el sistema mostrara las categorías disponibles y permitirá seleccionar la que quiero agregar.
    - Escenario 2: Eliminar categoría
    Dado que me encuentro en la administración de usuario, al presionar el botón de eliminar categoría, el sistema mostrara las categorías que actualmente tengo seleccionadas y al seleccionarlas el sistema las eliminara de mis categorías favoritas
    - Escenario 3: Agrega categoría inexistente
    ‌
</p>
</details>

##### SERVICIO 3
<details><summary>VER DETALLES</summary>
<p>
    _**COMO** administrador,_ **QUIERO** que la aplicación me permita agregar nuevos empleados de mi empresa _**PARA**_ trabajar con las encuestas y los resultados obtenidos"

    Tablas involucradas:

    - Usuario
    - Rol
    - Empresa

    Servicios requeridos:

    - Servicio para crear un nuevo usuario
    - Servicio para asignar un rol
    - Servicio para asignar empresa

    Escenario 1: Registro de un nuevo usuario

    Dado que me encuentro en la pantalla principal de la empresa, cuando selecciono el botón de  agregar un nuevo usuario a la empresa entonces el sistema deberá mostrar un formulario que permita agregar los datos de mis empleados.

    Escenario 2: Asignación de rol

    Dado que me encuentro en la pantalla de gestión de usuarios de la empresa, cuando selecciono el botón de asignar rol a alguno de mis empleados el sistema deberá 

</p>
</details>

##### SERVICIO 4
<details><summary>VER DETALLES</summary>
<p>
    ***COMO*** encargado de marketing, ***QUIERO*** ser capaz de limitar el numero de personas que pueden realizar una encuesta ***PARA*** así poder mantener una muestra controlada de datos."

    Tablas involucradas:

    - Encuesta

    Servicios requeridos:

    - Servicio para actualizar el mínimo y máximo de encuestados que pueden responder la encuesta. (2 servicios uno para máx. y otro para min)

    Escenario: 

    Escenario 1: 
</p>
</details>

##### SERVICIO 5
<details><summary>VER DETALLES</summary>
<p>
    ***COMO*** encuestado, ***QUIERO*** ser capaz de buscar alguna empresa especifica y ver que encuestas me puede ofrecer ***PARA*** así participar con algún producto de mi interés"

    Tablas involucradas:

    - Empresa
    - Encuesta

    Servicios requeridos:
    \- Encontrar todas las encuestas por el nombre de una empresa (FindAllByName)

    Escenarios: 

    - Escenario 1: Mostrar empresas
    Dado que me encuentro en la categoría de Empresas, el sistema desplegara todas las empresas disponibles, que actualmente tienen encuestas activas.
</p>
</details>

<!-- NOTA: el tamano solo parece funcionar en incrementos de 10 -->
<p align="center" width="100%">
    <img width="25%" src="https://github.com/GavenJr/proyectoIngSoftware/blob/master/proyecto_ubb/src/main/resources/model/sprint1/Modelo_Fisico_BD.png">
    <img width="50%" src="https://github.com/GavenJr/proyectoIngSoftware/blob/master/proyecto_ubb/src/main/resources/model/sprint1/Representacion_SQL.PNG">
    <img width="20%" src="https://github.com/GavenJr/proyectoIngSoftware/blob/master/proyecto_ubb/java_tan.jfif">
</p>

- - -

### SPRINT 2: Que esperamos lograr

- - -
- - -
<!-- Imagenes alineadas unas con las otras con un tamano del 30% -->
<p align="center" width="100%">
    <img width="10%" src="https://www.pngkit.com/png/full/402-4028532_the-great-papyrus-great-papyrus.png">
    <img width="30%" src="https://github.com/GavenJr/proyectoIngSoftware/blob/master/proyecto_ubb/src/main/resources/model/sprint2/ER.jpg">
    <img width="30%" src="https://github.com/GavenJr/proyectoIngSoftware/blob/master/proyecto_ubb/src/main/resources/model/sprint2/Relational_Schema.png">
    <img width="10%" src="https://www.nicepng.com/png/full/26-267104_sans-sans-sprite.png">
</p>

- - -
### SPRINT 3: Que esperamos lograr
- - -
- - -

## Sobre la BDD:
MySQL Community 8.0.31 | Disenada con MySQL Workbench | Modelo ER hecho en yED Graph Editor

#### POBLACION DE LA BD
<details><summary>TABLA Sample Text</summary>
<p>

| First Header  | Second Header | Third Header  | Forth Header | Fifth Header  | Sixth Header | 
| ------------- | ------------- | ------------- | ------------- | ------------- | ------------- |
| Content Cell  | Content Cell  | Content Cell  | Content Cell  | Content Cell  | Content Cell  |
| Content Cell  | Content Cell  | Content Cell  | Content Cell  | Content Cell  | Content Cell  |

</p>
</details>

## Extensiones de Visual Studio Code Recomendadas
<details><summary>E X T E N S I O N E S</summary>
<p>
https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack

https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack

https://marketplace.visualstudio.com/items?itemName=developersoapbox.vscode-springboot-developer-pack

https://marketplace.visualstudio.com/items?itemName=donjayamanne.git-extension-pack

https://marketplace.visualstudio.com/items?itemName=waderyan.gitblame

https://marketplace.visualstudio.com/items?itemName=mhutchie.git-graph

https://marketplace.visualstudio.com/items?itemName=GitHub.codespaces

https://marketplace.visualstudio.com/items?itemName=GitHub.vscode-pull-request-github

https://marketplace.visualstudio.com/items?itemName=DotJoshJohnson.xml
</p>
</details>
