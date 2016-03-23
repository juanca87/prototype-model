//obtiene el contexto de la aplicacion
var contextPathUrl = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));

// obtiene la ip del servidor cliente
var hostAddress = $("#hostAddress").val();

// setea el puerto
var portNumber = 80;
if (hostAddress == "localhost")
  portNumber = 8080;

// url para los resultados de la comparacion
var jsonUEBar = "http://" + hostAddress + ":" + portNumber + contextPathUrl + "/getUltimaEjecucion.json";

var barJson = $.getJSON(jsonUEBar, function(json) {

  $(function() {
    Morris.Bar({
      element : 'morris-bar-chart',
      data : json,
      parseTime : false,
      barColors:['#e8a02a','#3974c4','#413290'],
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
}).done(function() {
  $("#waiting").hide();
}).fail(function() {
  $("#waiting").hide();
  alert("No se pudo recuperar datos de la URL ingresada");
});

barJson.complete(function() {
  console.log("Procesado con exito bar chart");
});
