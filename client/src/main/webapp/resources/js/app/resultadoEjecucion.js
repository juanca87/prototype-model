function saveResultadoEjecucion() {

  //obtiene el header y el token para spring security
  var csrf_token = $("meta[name='_csrf']").attr("content");
  var header = $("meta[name='_csrf_header']").attr("content");

  //obtiene la url
  var contents = $("#url").val()
  //var contents = "http://localhost:8080/prototype-model-api/dashboardMockup.json";

  //limia en nodo dash
  var myNode = document.getElementById("dash");
  myNode.innerHTML = '';

  while (myNode.firstChild) {
    myNode.removeChild(myNode.firstChild);
  }

  // obtiene el json de la url
  $.getJSON(contents, function(json) {
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
      },
      success : function(data) {
        //agrega el resultado en el id="dash"
        $("#dash").append(data);
      },
      error : function(data, status, er) {
        alert("error: " + data + " status: " + status + " er:" + er);
      }
    });
  });

}
