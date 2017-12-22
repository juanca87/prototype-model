//ejecuta y guarda el resultado
function saveResultadoEjecucion() {
  $("#waiting").show();

  // obtiene el header y el token para spring security
  var csrf_token = $("meta[name='_csrf']").attr("content");
  var header = $("meta[name='_csrf_header']").attr("content");

  // obtiene la url
  var contents = $("#url").val();
  // var contents =
  // "http://localhost:8081/prototype-model-api/getResultadoEjecucionMockup.json";

  // obtiene el nombre del servidor
  var serverName = $("#serverName").val();

  // agrega el nombre del servidor a la url para el request
  var url = contents + "/" + serverName

  // limia en nodo "pieChart"
  var myNode = document.getElementById("pieChart");
  myNode.innerHTML = '';

  while (myNode.firstChild) {
    myNode.removeChild(myNode.firstChild);
  }

  // obtiene el json de la url
  var parseJson = $.getJSON(url, function(json) {
    // hace el submit
    $.ajax({
      headers : {
        'Accept' : 'application/json',
        'Content-Type' : 'application/json'
      },
      url : "saveResultadoEjecucion",
      type : "POST",
      contentType : "application/json; charset=utf-8",
      data : JSON.stringify(json),
      cache : false,
      processData : false,
      beforeSend : function(xhr) {
        xhr.setRequestHeader('X-CSRF-Token', csrf_token);
        // muestra barra de progreso
        $("#waiting").show();
      },
      success : function(data) {
        // agrega el resultado en el id="pieChart"
        $("#pieChart").append(data);
        // oculta barra de progreso
        $("#waiting").hide();
      },
      error : function(data, status, er) {
        alert("Error code: " + data.status + "\nStatus: " + status + "\nError description:" + er);
        $("#waiting").hide();
      }
    });
  }).done(function() {
    $("#waiting").hide();
  }).fail(function() {
    $("#waiting").hide();
    alert("No se pudo recuperar datos de la URL ingresada");
  });

  parseJson.complete(function() {
    console.log("Procesado con éxito resultadoEjecucion");
  });

  $("#dataGrid").jqGrid("setGridParam", {
    datatype : "json"
  }).trigger("reloadGrid", [ {
    current : true,
    page : 1
  } ]);
}
