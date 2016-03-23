//obtiene el contexto de la aplicacion
var contextPathUrl = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));

// obtiene la ip del servidor cliente
var hostAddress = $("#hostAddress").val();

// setea el puerto
var portNumber = 80;
if (hostAddress == "localhost")
  portNumber = 8080;

// url para obtener los resultados de la comparacion
var jsonUrl = "http://" + hostAddress + ":" + portNumber + contextPathUrl + "/getComparacion";

$(document).ready(
    function() {

      var grid = $("#comparacionGrid"), headerRow, rowHight, resizeSpanHeight;

      grid.jqGrid({
        url : jsonUrl,
        datatype : "json",
        styleUI : 'Bootstrap',
        headertitles : true,
        sortable : true,
        sortname : 'fecha',
        sortorder : "desc",
        jsonReader : {
          repeatitems : false,
          root : function(obj) {
            return obj;
          }
        },
        colNames : [ 'Servidor', 'CPU', 'Lectura en Memoria', 'Escritura en Memoria', 'Lectura en Disco',
            'Escritura en Disco', 'Ancho de Banda', 'Latencia', 'Procesamiento', 'Fecha' ],
        colModel : [
            {
              name : 'servidor',
              index : 'servidor',
              width : 90,
            },
            {
              name : 'cpu',
              index : 'cpu',
              width : 70
            },
            {
              name : 'lecturaMemoria',
              index : 'lecturaMemoria',
              width : 90
            },
            {
              name : 'escrituraMemoria',
              index : 'escrituraMemoria',
              width : 90
            },
            {
              name : 'lecturaDisco',
              index : 'lecturaDisco',
              width : 90
            },
            {
              name : 'escrituraDisco',
              index : 'escrituraDisco',
              width : 90
            },
            {
              name : 'anchoBanda',
              index : 'anchoBanda',
              width : 90
            },
            {
              name : 'latencia',
              index : 'latencia',
              width : 90
            },
            {
              name : 'instruccionesMinuto',
              index : 'instruccionesMinuto',
              width : 110
            },
            {
              name : "fecha",
              index : 'fecha',
              width : 90,
              autowidth : true,
              shrinkToFit : true,
              formatoptions : {
                // newformat : 'd/m/Y h:i A'
                newformat : 'd/m/Y'
              },
              formatter : function(cellval, opts, rowObject, action) {
                return $.fn.fmatter.call(this, "date", new Date(cellval), $.extend({}, $.jgrid.formatter.date, opts),
                    rowObject, action);
              }
            } ],
        height : 106,
        width : '100%',
        scrollOffset : 1
      });

      // Obtiene la fila de la cabecera
      headerRow = grid.closest("div.ui-jqgrid-view").find("table.ui-jqgrid-htable>thead>tr.ui-jqgrid-labels");

      // Aumenta la altura
      resizeSpanHeight = 'height: ' + headerRow.height() + 'px !important; cursor: col-resize;';
      headerRow.find("span.ui-jqgrid-resize").each(function() {
        this.style.cssText = resizeSpanHeight;
      });

      // alinea el texto en el centro
      rowHight = headerRow.height();
      headerRow.find("div.ui-jqgrid-sortable").each(function() {
        var ts = $(this);
        ts.css('top', (rowHight - ts.outerHeight()) / 2 + 'px');
      });

      grid.trigger('reloadGrid');

      var setTooltipsOnColumnHeader = function(grid, iColumn, text) {
        var thd = jQuery("thead:first", grid[0].grid.hDiv)[0];
        jQuery("tr.ui-jqgrid-labels th:eq(" + iColumn + ")", thd).attr("title", text);
      };

    });
