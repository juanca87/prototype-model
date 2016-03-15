//obtiene el contexto de la aplicacion
var contextPathUrl = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));

// obtiene la ip del servidor cliente
var hostAddress = $("#hostAddress").val();

// setea el puerto
var portNumber = 80;
if (hostAddress == "localhost")
  portNumber = 8080;

// url para obtener el historial de ejecuciones se envia como parametro el
// nombre del servidor
var jsonUrl = "http://" + hostAddress + ":" + portNumber + contextPathUrl + "/getComparacion.json";

$.getJSON(jsonUrl, function(json) {

  $(function() {
    Morris.Area({
      element : 'morris-area-chart',
      data : json,
      parseTime : false,
      ymax : 'auto',
      ymin : 'auto',
      xkey : 'atributo',
      ykeys : [ 'amazon', 'google', 'heroku' ],
      labels : [ 'Amazon EC2', 'Google App Engine', 'Heroku' ],
      pointSize : 2,
      hideHover : 'auto',
      resize : true
    });

  });
});
