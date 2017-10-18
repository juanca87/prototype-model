//obtiene el contexto de la aplicacion
var contextPathUrl = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));

// obtiene la ip del servidor cliente
var hostAddress = $("#hostAddress").val();

// setea el puerto
var portNumber = 80;
if (hostAddress == "localhost")
  portNumber = 8080;

// obtiene el atributo
var atributo = "";

$('#combobox').change(function() {
  atributo = $('#combobox option:selected').text();

  // limia en nodo "pieChart"
  var donutChart = document.getElementById("morris-donut-chart");
  donutChart.innerHTML = '';

  while (donutChart.firstChild) {
    donutChart.removeChild(donutChart.firstChild);
  }

  if (atributo == "Procesamiento")
    atributo = "Instrucciones por Minuto";

  // url para los resultados de la comparacion
  var jsonUEDonut = "http://" + hostAddress + ":" + portNumber + contextPathUrl + "/getAtributoByName/" + atributo;

  var donutJson = $.getJSON(jsonUEDonut, function(json) {

    $(function() {

      Morris.Donut({
        element : 'morris-donut-chart',
        data : json,
        colors : [ '#e8a02a', '#3974c4', '#413290' ],
        resize : true
      }).select(0);

      $("#mejorAtributo").text(json[0].label);
      $("#mejorTiempo").text(json[0].value);
      $("#mejorResultado").show();
    });

  }).done(function() {
    $("#waiting").hide();
  }).fail(function() {
    $("#waiting").hide();
    alert("No se pudo recuperar datos de la URL ingresada");
  });

  donutJson.complete(function() {
    console.log("Procesado con exito donut chart");
  });

});
