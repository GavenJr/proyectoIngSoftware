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
    <img width="10%" src="https://junit.org/junit5/assets/img/junit5-logo.png">
    <img width="10%" src="https://static.javatpoint.com/tutorial/mockito/images/mockito.png">
</p>

## Sobre el proyecto:
Se recomienda clonarlo en su IDE de preferencia (Ej: VS Code).

Java JDK 11 | Maven | Spring Boot 2.7.X | Arquitectura MVC.

Dependencias: Spring Boot DevTools | Spring Web | MySQL Driver | Spring data JPA | spring boot starter data jpa | spring-boot-starter-actuator

MySQL Community 8.0.31 | Disenada con MySQL Workbench | Modelo ER hecho en yED Graph Editor
- - -

<details><summary>COMO USAR/IMPLEMENTAR/CORRER</summary>
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

    > Para ejecutarlo, corra el archivo "ProyectoUbbApplication.java"
</p>
</details>

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



#### POBLACION DE LA BD
<details><summary>TABLA Sample Text</summary>
<p>

| First Header  | Second Header | Third Header  | Forth Header | Fifth Header  | Sixth Header | 
| ------------- | ------------- | ------------- | ------------- | ------------- | ------------- |
| Content Cell  | Content Cell  | Content Cell  | Content Cell  | Content Cell  | Content Cell  |
| Content Cell  | Content Cell  | Content Cell  | Content Cell  | Content Cell  | Content Cell  |

</p>
</details>

- - -

### SPRINT 1: Que esperamos lograr
Implementar los primeros 5 requisitos de sistema.
Implementar los servicios que conlleven.
Abarcar escenarios base.
- - -

##### HU 03 (2 servicios)
<details><summary>VER DETALLES</summary>
<p>
    _**COMO**_ encuestado, **QUIERO** que la aplicaci??n me permita cambiar mis categor??as de encuestas favoritas _**PARA**_ que as?? pueda actualizar mis preferencias de filtrado r??pido de encuestas de inter??s"

    Tablas involucradas:

    - Preferencias
    - Usuario

    Servicios requeridos:

    - Servicio para a??adir una preferencia
    - Servicio para eliminar una preferencia

    Escenarios:

    - Escenario 1: Agregar categor??a
    Dado que me encuentro en la administraci??n de usuario, al presionar el bot??n de agregar categor??a, el sistema mostrara las categor??as disponibles y permitir?? seleccionar la que quiero agregar.
    - Escenario 2: Eliminar categor??a
    Dado que me encuentro en la administraci??n de usuario, al presionar el bot??n de eliminar categor??a, el sistema mostrara las categor??as que actualmente tengo seleccionadas y al seleccionarlas el sistema las eliminara de mis categor??as favoritas
    - Escenario 3: Agrega categor??a inexistente
    ???
</p>
</details>

##### HU 18 (1 Servicio)
<details><summary>VER DETALLES</summary>
<p>
    ***COMO*** administrador ***QUIERO*** ser capaz de administrar la visibilidad de mis encuestas ***PARA*** as?? poder programar la publicaci??n de alguna  ya hecha con anticipaci??n.

    Tablas involucradas:

    - Encuesta

    Servicios requeridos:

    - Servicio para actualizar "visibilidad"

    ???Escenario:

    - 1. Dado que me encuentro en la pantalla de encuesta al momento en que presiono el bot??n de "visible" , la encuesta se establecer?? como "visible" o "no visible" seg??n corresponda
</p>
</details>

##### HU 19 (2 servicios)
<details><summary>VER DETALLES</summary>
<p>
    ***COMO*** encargado de marketing, ***QUIERO*** ser capaz de limitar el numero de personas que pueden realizar una encuesta ***PARA*** as?? poder mantener una muestra controlada de datos."

    Tablas involucradas:

    - Encuesta

    Servicios requeridos:

    - Servicio para actualizar el m??nimo y m??ximo de encuestados que pueden responder la encuesta. (2 servicios uno para m??x. y otro para min)

    Escenario: 

    Escenario 1: 
</p>
</details>

##### HU 25 (1 Servicio)
<details><summary>VER DETALLES</summary>
<p>
    ***COMO*** encuestado, ***QUIERO*** ser capaz de buscar alguna empresa especifica y ver que encuestas me puede ofrecer ***PARA*** as?? participar con alg??n producto de mi inter??s"

    Tablas involucradas:

    - Empresa
    - Encuesta

    Servicios requeridos:
    \- Encontrar todas las encuestas por el nombre de una empresa (FindAllByName)

    Escenarios: 

    - Escenario 1: Mostrar empresas
    Dado que me encuentro en la categor??a de Empresas, el sistema desplegara todas las empresas disponibles, que actualmente tienen encuestas activas.
</p>
</details>

##### HU 32 (3 Servicios)
<details><summary>VER DETALLES</summary>
<p>
    _**COMO** administrador,_ **QUIERO** que la aplicaci??n me permita agregar nuevos empleados de mi empresa _**PARA**_ trabajar con las encuestas y los resultados obtenidos"

    Tablas involucradas:

    - Usuario
    - Rol
    - Empresa

    Servicios requeridos:

    - Servicio para crear un nuevo usuario
    - Servicio para asignar un rol
    - Servicio para asignar empresa

    Escenario 1: Registro de un nuevo usuario

    Dado que me encuentro en la pantalla principal de la empresa, cuando selecciono el bot??n de  agregar un nuevo usuario a la empresa entonces el sistema deber?? mostrar un formulario que permita agregar los datos de mis empleados.

    Escenario 2: Asignaci??n de rol

    Dado que me encuentro en la pantalla de gesti??n de usuarios de la empresa, cuando selecciono el bot??n de asignar rol a alguno de mis empleados el sistema deber?? 

</p>
</details>

<!-- NOTA: el tamano solo parece funcionar en incrementos de 10 -->
<p align="center" width="100%">
    <img width="10%" src="https://media.tenor.com/yZRsvoJB9QwAAAAj/wowa-pepe.gif">
    <img width="25%" src="https://github.com/GavenJr/proyectoIngSoftware/blob/master/proyecto_ubb/src/main/resources/model/sprint1/Modelo_Fisico_BD.png">
    <img width="50%" src="https://github.com/GavenJr/proyectoIngSoftware/blob/master/proyecto_ubb/src/main/resources/model/sprint1/Representacion_SQL.PNG">
    <img width="10%" src="https://static.wikia.nocookie.net/fridaynightfunking/images/0/05/CryingEmojiUp.png/revision/latest/scale-to-width-down/250?cb=20210715175906">
</p>

- - -

### SPRINT 2: Que esperamos lograr
Implementar 5 requisitos de sistema adicionales, y agregar tests a los servicios actualmente implementados, asi como asegurar que el codigo se encuentre documentado y sea mantenible

- - -

##### HU 01/06 (repetida, 2 servicios)
<details><summary>VER DETALLES</summary>
<p>
    HU_01 y HU_06 (REPETIDA): C??mo *usuario, necesito que la web permita crear encuestas de selecci??n m??ltiple para realizar mis an??lisis de forma efectiva.

    Escenario 1: Creacion de encuesta

    En el menu de "Mis encuestas", habra un boton para crear una encuesta vacia y NO visible por defecto, a la que habra que dar un nombre para confirmar que existe.

    Escenario 2: Usuario no existe

    Dado que me encuentro en la pantalla principal, cuando selecciono el bot??n de inicio de sesi??n entonces el sistema deber?? informar si mi usuario esta registrado o no.

    Servicios a implementar:

    Servicio que agrega una nueva encuesta

    Servicio que devuelve una encuesta basado en su nombre

    Tablas involucradas:

    Encuesta

</p>
</details>

##### HU 05 (1 Servicio)
<details><summary>VER DETALLES</summary>
<p>
    HU_05: Como encuestado deseo poder crear una cuenta en la plataforma

    Escenario 1: Creaci??n de usuario

    Dado que me encuentro en la pantalla principal, cuando selecciono el bot??n de registrar entonces el sistema deber?? mostrar un formulario de registro donde pueda ingresar mis datos.

    Escenario 2: Usuario no existe

    Dado que me encuentro en la pantalla principal, cuando selecciono el bot??n de inicio de sesi??n entonces el sistema deber?? informar si mi usuario esta registrado o no.

    Servicios a implementar:

    Servicio que agrega un nuevo encuestado

    Tablas involucradas:

    Encuestado
</p>
</details>

##### HU 16 (n servicios)
<details><summary>VER DETALLES</summary>
<p>
    HU_16: COMO administrador QUIERO que mis encuestas puedan describir su proposito en una descripcion PARA que mis encuestados sepan lo que necesiten para su desarrollo
</p>
</details>

##### HU 17 (2 servicios?)
<details><summary>VER DETALLES</summary>
<p>
    COMO usuario QUIERO ser capaz de definir que categorias de encuesta me interesa explorar o recibir PARA aportar en temas que sean de mi interes
</p>
</details>

##### HU 27 (5 Servicios)
<details><summary>VER DETALLES</summary>
<p>
    HU_27: "Como encargado de marketing desear??a poder eliminar una encuesta aun no publicada para as?? evitar que una encesta mal formulada salga al publico"
    
    Escenario 1: Eliminacion de encuesta antes de su publicacion

    En el menu de "Mis encuestas", habra un boton para eliminar cualquier encuesta que se encuentre sin publicar (fecha inicio nula o mayor a la actual, Y esta oculta). Se deberan eliminar igualmente las preguntas y alternativas asociadas.

    Escenario 2: Eliminacion de encuesta despues de su publicacion

    En el menu de "Mis encuestas", se procedera similar al escenario 1, solo que se dara una advertencia pidiendo al usuario cerrar su encuesta antes de proceder similar al escenario 1.
    En este caso habran respuestas realizadas, por lo que se debera eliminar estas igualmente, asi como de los borradores que hayan dejado los encuestados por ahi dispersadas.

    Servicios a implementar:

    Servicio que elimina una nueva encuesta
    Servicio que elimina las preguntas asociadas
    Servicio que elimina las alternativas asociadas a las preguntas
    Servicio que elimina las respuestas asociadas (en caso de haber para el escenario 2)
    Servicio que elimina los borradores de los encuestados (escenario 2)

    Tablas involucradas:

    Encuesta
    Pregunta
    Alternativa
    Borrador
    Respuesta

</p>
</details>

- - -
<!-- Imagenes alineadas unas con las otras con un tamano del 30% -->
<p align="center" width="100%">
    <img width="10%" src="https://www.pngkit.com/png/full/402-4028532_the-great-papyrus-great-papyrus.png">
    <img width="30%" src="https://github.com/GavenJr/proyectoIngSoftware/blob/master/proyecto_ubb/src/main/resources/model/sprint2/ER_2.jpg">
    <img width="30%" src="https://github.com/GavenJr/proyectoIngSoftware/blob/master/proyecto_ubb/src/main/resources/model/sprint2/Relational_Schema_2.png">
    <img width="10%" src="https://www.nicepng.com/png/full/26-267104_sans-sans-sprite.png">
</p>

- - -
### SPRINT 3: Que esperamos lograr
- - -
- - -


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
