# README

### External resources _(templates/icons/libraries)_:

__Dashboard:__
* http://startbootstrap.com/template-overviews/sb-admin-2/
* http://blackrockdigital.github.io/startbootstrap-sb-admin-2/pages/index.html

__Bootstrap:__
* http://getbootstrap.com/2.3.2/base-css.html (http://getbootstrap.com/css/)

__Icons:__
* https://fortawesome.github.io/Font-Awesome/icons/
* http://www.w3schools.com/icons/fontawesome_icons_webapp.asp

__Morris Charts:__
* https://morrisjs.github.io/morris.js/lines.html
* https://morrisjs.github.io/morris.js/bars.html
* https://morrisjs.github.io/morris.js/donuts.html

__Live Morris:__
* http://www.bootply.com/3oI7ZxxiQ0#
* http://jsbin.com/otaxef/115/embed?js,output
* http://jsbin.com/uzosiq/258/embed?js,output
* http://jsbin.com/ukaxod/144/embed?js,output

### How to run?

* This project uses MySQL Database, so before running the application it is necessary to execute the following command to create the schema
```
CREATE SCHEMA `prototypeDB`;
```

* To compile the modules, go to the parent folder _(prototype_model)_ and execute the following command:
```
cd prototype-model
mvn clean install
```

* You can deploy it on apache tomcat or inside of your IDE, when it starts this will create the table.

### Modules:
* **prototype-api:** this module has the measurable attributes
* **prototype-client:** this module is designed to consume the services of prototype-api module, save it to the database and show the metrics

### Endpoints:
```
> http://<server:8081>/prototype-api/getInfoServidor
> http://<server:8081>/prototype-api/getResultadoEjecucion/<serverName>
> http://<server:8080>/prototype-client/getHistorialEjecuciones
> http://<server:8080>/prototype-client/getComparacion
> http://<server:8080>/prototype-client/getAtributoByName/<atributeName>
> http://<server:8080>/prototype-client/getUltimaEjecucion
```

```
* <serverName> : amazon, google or heroku
* <server:8080> : server (local or remote) and port
* <atributeName> : CPU, Lectura en Memoria, Escritura en Memoria, Lectura en Disco, Escritura en Disco, Ancho de Banda, Latencia or Procesamiento
```
