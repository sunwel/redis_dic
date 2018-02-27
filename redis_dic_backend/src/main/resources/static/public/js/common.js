//jqGrid的配置信息
$.jgrid.defaults.width = 1000;
$.jgrid.defaults.responsive = true;
$.jgrid.defaults.styleUI = 'Bootstrap';

//工具集合Tools
window.T = {};

// 获取请求参数
// 使用示例
// location.href = http://localhost:8080/index.html?id=123
// T.p('id') --> 123;
var url = function (name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
};
T.p = url;

//全局配置
$.ajaxSetup({
    dataType: "json",
    cache: false
});

function operatebtn(permission, btn) {
    if (hasPermission(permission)) {
        return btn;
    }
    return '';
}

function hasPermission(permission) {
    if (window.parent.permissions.indexOf(permission) > -1) {
        return true;
    } else {
        return false;
    }
}

//重写alert
window.alert = function (msg, callback) {
    parent.layer.alert(msg, function (index) {
        parent.layer.close(index);
        if (typeof(callback) === "function") {
            callback("ok");
        }
    });
}

//重写confirm式样框
window.confirm = function (msg, callback) {
    parent.layer.confirm(msg, {btn: ['确定', '取消']},
        function () {//确定事件
            if (typeof(callback) === "function") {
                callback("ok");
            }
        });
}

//选择一条记录
function getSelectedRow() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if (!rowKey) {
        alert("请选择一条记录");
        return;
    }

    var selectedIDs = grid.getGridParam("selarrrow");
    if (selectedIDs.length > 1) {
        alert("只能选择一条记录");
        return;
    }

    return selectedIDs[0];
}

//选择多条记录
function getSelectedRows() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if (!rowKey) {
        alert("请选择一条记录");
        return;
    }

    return grid.getGridParam("selarrrow");
}

function getLocalTime(nS) {
    var time = new Date(nS);
    return (time.getFullYear()) + "-" +
        (fillZero(time.getMonth() + 1)) + "-" +
        (fillZero(time.getDate())) + " " +
        (fillZero(time.getHours())) + ":" +
        (fillZero(time.getMinutes())) + ":" +
        (fillZero(time.getSeconds()));
}

function checkId(id) {
    return (id == null || typeof (id) != 'number') ? getSelectedRow() : id;
}

function checkIds(ids) {
    return (ids == null || typeof (ids) != 'number') ? getSelectedRows() : [ids];
}

function fillZero(num) {
    if (num / 10 < 1) {
        return '0' + num;
    }
    return num;
}

layer.config({
    skin: 'dialog-class'
});
/**===============================jqgrid配置=================================================**/
var jqGridConfig = {
    height: 385,
    rowNum: 15,
    rowList: [],
    rownumWidth: 55
};

/**
 * jggrid完成设iframe
 * @param obj
 */

function iframeHeight(obj) {
    var _minHeight = Math.floor($(window).height()*0.8);


    var contentsH = $(obj).contents().height() > _minHeight ? $(obj).contents().height() + 3 : _minHeight;
    // var contentsH = $(obj).contents().height();
    var frameId = window.frameElement && window.frameElement.id || '';
    frameId = '#' + frameId;
    window.top.setIframeH(frameId, contentsH + 174);
}