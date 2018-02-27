
$(function () {
    $("#jqGrid").jqGrid({
        url: '../logEvent/pageList',
        datatype: "json",
        colModel: [
            {label: '时间', name: 'timestmp', width: '15%',formatter:function (value,options,row) {
                return  getLocalTime(value)
            }},
            {label: '名称', name: 'loggerName', width: '20%'},
            {label: '内容', name: 'formattedMessage', width: '65%'}
        ],
        viewrecords: true,
        height: jqGridConfig.height,
        rowNum: jqGridConfig.rowNum,
        rowList: jqGridConfig.rowList,
        rownumbers: true,
        rownumWidth: 30,
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
    el: '#event',
    data: {
        title: null,
        showList: true,
        dialogType: false,
        updateDialog: false,
        dialog: {width: '600px', height: '80%'}
    },
    watch: {
    },
    methods: {
    },
    created: function () {
    }

});

