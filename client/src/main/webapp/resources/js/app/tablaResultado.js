//obtiene el contexto de la aplicacion
var contextPathUrl = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

//var jsonUrl = "http://localhost:8080/" + contextPathUrl +"example/resources/json/listado.json";
var jsonUrl = "http://localhost:8080" + contextPathUrl + "/list";

$(document).ready(function () {
//$(function () {
    $("#dataGrid").jqGrid({
        url: jsonUrl,
        datatype: "json",
        styleUI : 'Bootstrap',
        jsonReader: {repeatitems: false, root: function (obj) { return obj; }},
        colNames:['Id','Nombre', 'Apellido', 'Edad','Email'],
        colModel:[
                  {name:'id',index:'id', key:true, width:100,editable:true,editoptions:{size:10}},
                  {name:'name',index:'name', width:100,editable:true},
                  {name:'lastName',index:'lastName', width:100,editable:true,editoptions:{size:10}},
                  {name:'age',index:'age', width:100,editable:true,editoptions:{size:25}},
                  {name:'email',index:'email', width:100, align:"right",editable:true,editoptions:{size:10}},
                  ],
        rowNum:10,
        rowList:[3,6],
        pager: '#navGrid',
        sortname: 'id',
        sortorder: "asc",
        height: "auto", //210,
        viewrecords: true,
    });
});

