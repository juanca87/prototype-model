$(document).ready(function() {
  $("#caracteristica").hide();
});

//mostrar Info
function mostrarInfo(){
  $("#valCaracteristica").show();
}
//ocultar Info
function ocultarInfo(){
  $("#valCaracteristica").hide();
}

// ejecuta y guarda el resultado
function recuperarCaracteristicas() {
  $("#waiting").show();
  $("#caracteristica").show();

  // obtiene la url
  var url = $("#urlCaracteristicas").val();
  // var contents = "http://localhost:8080/prototype-model-api/getInfoServidor.json";

  // obtiene el json de la url
  var parseJson = $.getJSON(url, function(json) {
    $("#soVal").text(json.sistemaOperativo);
    $("#aVal").text(json.arquitectura);
    $("#vVal").text(json.version);
    $("#cpuVal").text(json.cpu);
    $("#tdVal").text(json.totalDisco);
    $("#trVal").text(json.totalRAM);
    $("#waiting").hide();
  })
  .done(function() {
    $("#waiting").hide();
    $("#caracteristica").show();
    $("#valCaracteristica").show();
  })
  .fail(function() {
    $("#caracteristica").hide();
    $("#valCaracteristica").hide();
    alert("No se pudo recuperar datos de la URL ingresada");
    $("#waiting").hide();
  });

  parseJson.complete(function() {
    console.log( "Procesado con exito" );
  });

}
