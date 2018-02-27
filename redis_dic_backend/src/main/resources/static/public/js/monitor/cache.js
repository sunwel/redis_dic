
$(function () {
    $("#jqGrid").jqGrid({
        url: '../cache/get',
        datatype: "json",
        mtype:'get',
        postData:{
            type:vm.type
        },
        colModel: [
            {label: 'ID', name: 'id', width: '20%'},
            {label: '名称', name: 'name', width: '60%'}
        ],
        viewrecords: true,
        height: jqGridConfig.height,
        rowNum: -1,
        rowList: jqGridConfig.rowList,
        rownumbers: true,
        rownumWidth: 40,
        autowidth: true,
        // multiselect: true,
        //开启隔行变色
        altRows: true,
        //设置行class*
        altclass: 'lineColor',
        pager: "#jqGridPager",
        jsonReader: {
            root: "obj.records",
            page: "obj.current",
            total: "obj.pages",
            records: "obj.total"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});


var vm = new Vue({
    el: '#cache',
    data: {
        title: null,
        type: "brand",
        dialogType: false,
        updateDialog: false,
        dialog: {width: '600px', height: '80%'}
    },
    watch: {
        type: function () {
            vm.reload();
        }
    },
    methods: {
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {
                    'type': vm.type
                },
                rowNum: -1
            }).trigger("reloadGrid");
        }
    },
    created: function () {
    }

});

