function createGrid() {
    'use strict';
    $('#manualMessageMonitor').jqGrid({
        url : "http://localhost:8080/rest/list",
        datatype : 'json',
        mtype : 'GET',
        colNames : [ 'Name', 'Last Name', 'Age', 'E-mail' ],
        colModel : [ {
            name : 'name',
        }, {
            name : 'lastName',
        }, {
            name : 'age',
        }, {
            name : 'email',
        } ],
        postData : {
            //filters : cookieValue(cookieName)
        },
        rowList : [ 10, 20, 30 ],
        pager : '#pager',
//        rowNum : getDefaultOrderingData("rowAmount", cookieName, 20),
//        page : getDefaultOrderingData("pageNumber", cookieName, 1),
//        rownumbers : true,
        sortname : getDefaultOrderingData("sortColumn", cookieName, "id"),
        sortorder : getDefaultOrderingData("sortOrder", cookieName, "desc"),
        width : gridWidth,
        shrinkToFit : true,
        viewrecords : true,
        height : 'auto',
        search : true,
        toolbar : [ true, "top" ],
        toolbarfilter : true,
        multiselect : true,
        subGrid : false,
        ignoreCase : true,
        jsonReader : {
            root : "rows",
            page : "page",
            total : "total",
            records : "records",
            repeatitems : false,
            id : "ID"
        },
        beforeRequest : function() {
            var fil = $("#manualMessageMonitor").jqGrid('getGridParam').postData.filters;
            // add sortinfo so it is saved in the cookie
            fil = addSortInfo(fil, "#manualMessageMonitor");
            if (fil != null) {
                createCookie(cookieName, fil, 0);
            }
            // remove the sortinfo from the postdata because those are sent already by jquery
            fil = removeSortInfo(fil, "#manualMessageMonitor");
            $("#manualMessageMonitor").jqGrid('getGridParam').postData.filters = fil;

            $("#cb_manualMessageMonitor").css("visibility", "hidden");
            $("#cb_manualMessageMonitor").attr("disabled", true);
        },
        gridComplete : function() {
            for (var i = 0; i < rowsToColor.length; i++) {
                var status = $("#" + rowsToColor[i]).find("td").eq(statusColumn).html();
                $("#" + rowsToColor[i]).find("td").addClass(status);
            }
        }
    });
    $('#manualMessageMonitor').jqGrid('navGrid', '#pager', {
        edit : false,
        add : false,
        del : false,
        search : true,
        refresh : false
    }, {}, {}, {}, {
        sopt : [ 'eq', 'cn', 'gt', 'lt' ],
        closeOnEscape : true,
        multipleSearch : true,
        closeAfterSearch : true
    }).jqGrid('navButtonAdd', "#pager", {
        caption : "",
        buttonicon : "ui-icon ui-icon-refresh",
        onClickButton : refreshGrid,
        position : "last",
        title : "Refresh grid",
        cursor : "pointer"
    }).jqGrid('navButtonAdd', "#pager", {
        caption : "",
        buttonicon : "ui-icon ui-icon-trash",
        onClickButton : resetFilters,
        position : "last",
        title : "Reset filters",
        cursor : "pointer"
    });
    $('#manualMessageMonitor').jqGrid('filterToolbar', {
        searchOnEnter : true,
        ignoreCase : true,
        searchOperators : true,
        stringResult : true
    });
    $('#manualMonitorMenu .button').button();
    $("#replyMessage").click(replyMessageEvent);
    $("#approveMessage").button();
    $("#approveMessage").click(function(event) {
        event.stopPropagation();
        var selRows = jQuery('#manualMessageMonitor').jqGrid('getGridParam', 'selarrrow');
        var selectedIDs = [];

        for (var i = 0; i < selRows.length; i++) {
            var rowData = $("#manualMessageMonitor").getRowData(selRows[i]);
            selectedIDs.push(rowData.manualMessageId);
        }

        /*
         * var selectedIDs = []; var notApprove = []; for (var i = 0; i < selRows.length; i++){ var rowData = $("#manualMessageMonitor").getRowData(selRows[i]); var getUser = rowData.user; var
         * getStatus = rowData.msgStatus; var getID = rowData.manualMessageId;
         * 
         * if(getUser != userLoggin.textContent && getStatus.match('^PEND')) { selectedIDs.push(getID); } else { notApprove.push(getID); } }
         */
        if (selectedIDs.length > 0) {
            /*
             * if (notApprove.length > 0) { $("#dialog").html("Are you sure you want to approve " + selectedIDs.length + " Message(s)?" + "</br></br> You cannot approve " + notApprove.length + "
             * Message(s)"); } else {
             */
            $("#dialog").html("Are you sure you want to approve " + selectedIDs.length + " Message(s)?");
            // }
            $("#dialog").dialog({
                buttons : [ {
                    id : "btn-yes",
                    text : "YES",
                    click : function() {
                        approveMessageEvent(selectedIDs);
                        $(this).dialog("close");
                    }
                }, {
                    id : "btn-no",
                    text : "NO",
                    click : function() {
                        cleanSelectedRows(selectedIDs);
                        $(this).dialog("close");
                    }
                } ]
            });
        } /*
             * else if (notApprove.length > 0) { $("#dialog").html("You cannot approve " + notApprove.length + " Message(s)"); $("#dialog").dialog({ buttons : { "Ok" : function() {
             * cleanSelectedRows(selectedIDs,notApprove); $(this).dialog("close"); } }, height : 150, width : 300 }); }
             */else {
            $("#dialog").html("You must select at least one Message");
            $("#dialog").dialog({
                buttons : {
                    "Ok" : function() {
                        $(this).dialog("close");
                    }
                },
                height : 150,
                width : 300
            });
        }
    });
};
