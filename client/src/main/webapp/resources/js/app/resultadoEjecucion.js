//$(document).ready(
function ver() {
    // after button is clicked we download the data
    // $('.button').click(
    // function() {
    // start ajax request
    $.ajax({
        url : "http://localhost:8080/api/getResults",
        // force to handle it as text
        dataType : "text",
        success : function(data) {
            // data downloaded so we call parseJSON function and pass downloaded
            // data
            var valor = $.parseJSON(data);
            // now json variable contains data in json format
            // let's display a few items
            // $('#results').html('Plugin name: ' + valor.cpu );
            $('#cpuResult').text(valor.cpu);
            $('#lecturaMemoriaResult').text(valor.cpu);
            $('#escrituraMemoriaResult').text(valor.cpu);
            $('#lecturaDiscoResult').text(valor.cpu);
            $('#escrituraDiscoResult').text(valor.cpu);
            $('#bandwithResult').text(valor.cpu);
            $('#latencyResult').text(valor.cpu);
            $('#instruccionesMinResult').text(valor.cpu);
        }
    });
}
// });
// });

function saveResultadoEjecucion() {

    var csrf_token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    var contents = "http://localhost:8080/prototype-model-api/dashboardMockup.json";

    /*
     * deprecated function
    var json_obj = JSON.parse(getJson(contents));

    function getJson(yourUrl) {
        var Httpreq = new XMLHttpRequest(); // a new request
        Httpreq.open("GET", yourUrl, false);
        Httpreq.send(null);
        return Httpreq.responseText;
    }
     */

    $.getJSON(contents, function(json) {
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
//                alert(data.cpu);
                $("#dash").append(data);
            },
            error : function(data, status, er) {
                alert("error: " + data + " status: " + status + " er:" + er);
            }
        });
    });

}
