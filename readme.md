# README

###External resources _(templates/icons/libraries)_:

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


### prototype-model

* Database schema:
```
CREATE SCHEMA `prototypeDB`;
```

* api/client services:

```
* <serverName> : amazon, google or heroku
* <server:8080> : server (local or remote) and port
* <atributeName> : CPU, Lectura en Memoria, Escritura en Memoria, Lectura en Disco, Escritura en Disco, Ancho de Banda, Latencia or Procesamiento
```

```
> http://<server:8080>/prototype-model-api/getInfoServidor
> http://<server:8080>/prototype-model-api/getResultadoEjecucion/<serverName>
> http://<server:8080>/prototype-model-client/getHistorialEjecuciones
> http://<server:8080>/prototype-model-client/getComparacion
> http://<server:8080>/prototype-model-client/getAtributoByName/<atributeName>
> http://<server:8080>/prototype-model-client/getUltimaEjecucion
```

### Configuration
* Build and Deploy

```sh
#For local environment, this assume that use 8080 port
$ mvn clean -Plocal install
#For remote environment, this assume that use 80 port
$ mvn clean -Pprod install
#Deploy on application server
```