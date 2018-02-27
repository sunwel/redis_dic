var vm = new Vue({
    el: '#cache-refresh',
    data: {
        title: null,
        showList: true,
        typeSelect: "brand",
        dialogType: false,
        updateDialog: false,
        dialog: {width: '600px', height: '80%'}
    },
    watch: {
    },
    methods: {
        refresh: function (type) {
            $.ajax({
                type: "get",
                url: '../cache/refresh',
                // contentType: "application/json",
                data: {type: type},
                success: function (r) {
                    if (r.code === 200) {
                        $("#" + type).css('color', 'red');
                        alert('刷新成功');
                    } else {
                        alert(r.msg);
                    }
                }
            });
        }

    },
    created: function () {
    }

});

