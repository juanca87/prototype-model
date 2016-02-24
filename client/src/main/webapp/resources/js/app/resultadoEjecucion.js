function saveResultadoEjecucion() {

  //obtiene el header y el token para spring security
  var csrf_token = $("meta[name='_csrf']").attr("content");
  var header = $("meta[name='_csrf_header']").attr("content");

  //obtiene la url
  var contents = $("#url").val();
  //var contents = "http://localhost:8080/prototype-model-api/getResultadoEjecucionMockup.json";

  //obtiene el nombre del servidor
  var serverName = $("#serverName").val();

  //agrega el nombre del servidor a la url para el request
  var url = contents + "/" + serverName
  //limia en nodo dash
  var myNode = document.getElementById("dash");
  myNode.innerHTML = '';

  while (myNode.firstChild) {
    myNode.removeChild(myNode.firstChild);
  }

  // obtiene el json de la url
  $.getJSON(url, function(json) {
    //hace el submit
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
        //muestra barra de progreso
        $("#waiting").show();
      },
      success : function(data) {
        //agrega el resultado en el id="dash"
        $("#dash").append(data);
        //oculta barra de progreso
        $("#waiting").hide();
      },
      error : function(data, status, er) {
        alert("Error code: " + data.status + "\nStatus: " + status + "\nError description:" + er);
        $("#waiting").hide();
      }
    });
  });

  $('#dataGrid').trigger('reloadGrid');

}
