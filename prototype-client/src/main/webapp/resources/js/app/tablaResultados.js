//obtiene el contexto de la aplicacion
var contextPathUrl = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));

// obtiene el nombre del servidor quien hace la peticion
var serverName = $("#serverName").val();

// obtiene la ip del servidor cliente
var hostAddress = $("#hostAddress").val();

// setea el puerto
var portNumber = 80;
if (hostAddress == "localhost")
  portNumber = 8080;

// url para obtener el historial de ejecuciones se envia como parametro el
// nombre del servidor
var jsonUrl = "http://" + hostAddress + ":" + portNumber + contextPathUrl + "/getHistorialEjecuciones/" + serverName;

$(document).ready(
    function() {

      $("#accordion").accordion({
        event : "click",
        active : true,
        collapsible : true,
        autoHeight : false,
        height : 600
      });

      $("#dataGrid").jqGrid(
          {
            url : jsonUrl,
            datatype : "json",
            styleUI : 'Bootstrap',
            headertitles : true,
            jsonReader : {
              repeatitems : false,
              root : function(obj) {
                return obj;
              }
            },
            colNames : [ 'id', 'CPU', 'LM', 'EM', 'LD', 'ED', 'AB', 'L', 'P', 'Fecha', 'Servidor' ],
            colModel : [
                {
                  name : 'id',
                  index : 'id',
                  key : true,
                  width : 60,
                  hidden : true
                },
                {
                  name : 'cpu',
                  index : 'cpu',
                  width : 60
                },
                {
                  name : 'lecturaMemoria',
                  index : 'lecturaMemoria',
                  width : 60
                },
                {
                  name : 'escrituraMemoria',
                  index : 'escrituraMemoria',
                  width : 60
                },
                {
                  name : 'lecturaDisco',
                  index : 'lecturaDisco',
                  width : 60
                },
                {
                  name : 'escrituraDisco',
                  index : 'escrituraDisco',
                  width : 60
                },
                {
                  name : 'anchoBanda',
                  index : 'anchoBanda',
                  width : 60
                },
                {
                  name : 'latencia',
                  index : 'latencia',
                  width : 60
                },
                {
                  name : 'instruccionesMinuto',
                  index : 'instruccionesMinuto',
                  width : 60
                },
                {
                  name : "fecha",
                  index : 'fecha',
                  autowidth : true,
                  shrinkToFit : false,
                  formatoptions : {
                    newformat : 'd/m/Y h:i A'
                  },
                  formatter : function(cellval, opts, rowObject, action) {
                    return $.fn.fmatter.call(this, "date", new Date(cellval), $
                        .extend({}, $.jgrid.formatter.date, opts), rowObject, action);
                  }
                }, {
                  name : 'servidor',
                  index : 'servidor',
                  width : 290,
                  hidden : true
                }, ],
            rowNum : 10,
            rowList : [ 10, 20, 30, 40, 50 ],
            // sortname: 'id',
            // sortorder: "asc",
            pager : '#navGrid',
            height : 275,
            viewrecords : true,
            loadComplete : function() {
              console.log("carga completa de resultados");
            }
          });

      $('#dataGrid').trigger('reloadGrid');

      var setTooltipsOnColumnHeader = function(grid, iColumn, text) {
        var thd = jQuery("thead:first", grid[0].grid.hDiv)[0];
        jQuery("tr.ui-jqgrid-labels th:eq(" + iColumn + ")", thd).attr("title", text);
      };

      // agrega titulo a la cabecera
      setTooltipsOnColumnHeader($("#dataGrid"), 1, "CPU");
      setTooltipsOnColumnHeader($("#dataGrid"), 2, "Lectura en Memoria");
      setTooltipsOnColumnHeader($("#dataGrid"), 3, "Escritura en Memoria");
      setTooltipsOnColumnHeader($("#dataGrid"), 4, "Lectura en Disco");
      setTooltipsOnColumnHeader($("#dataGrid"), 5, "Escritura en Disco");
      setTooltipsOnColumnHeader($("#dataGrid"), 6, "Ancho de Banda");
      setTooltipsOnColumnHeader($("#dataGrid"), 7, "Latencia");
      setTooltipsOnColumnHeader($("#dataGrid"), 8, "Procesamiento");
      setTooltipsOnColumnHeader($("#dataGrid"), 9, "Fecha de captura");
      setTooltipsOnColumnHeader($("#dataGrid"), 10, "Servidor de captura");
    });
