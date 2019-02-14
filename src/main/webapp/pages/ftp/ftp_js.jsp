<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script>
    var url = "${contextPath}/ftp/getNextFiles";
    var level;

    window.onload = function () {
        $("#operationBtn").hide();
        level = 0;
        var params = {level: level};
        ajax(url, params);

    };

    /**
     * 获取下一层文件
     * @param e
     */
    function getNextFiles(e) {

        var filePath = $("#filePath_"+ e.sectionRowIndex).val();
        //获取的是上一层的路径
        var relativePath = $("#relativePath_"+ e.sectionRowIndex).val();
        //判断是否为文件夹
        var isDirectory = $("#isDirectory_" + e.sectionRowIndex).val();
        if (isDirectory === 'false'){
            alert("该文件不是文件夹");
            return;
        }
        var param = {path: filePath, level: ++level};
        ajax(url, param);

    }

    /**
     * 获取上一层文件
     * @param e
     */
    function getPreviousFiles(e) {

        var url = '${contextPath}/ftp/getPreviousFiles';
        var globalRelativePath = $("#globalRelativePath").val();
        var param = {path: globalRelativePath, level: --level};
        ajax(url, param);

    }


    /**
     * 设置显示路径
     * @param filePath
     */
    function showFilePath(filePath) {
        $("#title_filepath").html(filePath);
    }


    /**
     * 新建文件夹
     */
    function mkdir() {

        var globalRelativePath = $("#globalRelativePath").val();
        var folderName = $("#new_folder").val();
        if (!folderName){
            alert("请输入文件夹名称");
            return;
        }
        var url = "${contextPath}/ftp/mkdir";
        var params = {globalRelativePath: globalRelativePath, level: level, folderName: folderName};
        ajax(url, params, true, '新建成功');

    }

    /**
     * 刷新文件夹
     */
    function refreshFolder() {
        var globalRelativePath = $("#globalRelativePath").val();
        var url = "${contextPath}/ftp/refresh";
        var params = {globalRelativePath: globalRelativePath, level: level};
        ajax(url, params, true, "刷新成功");
    }

    /**
     * 确认删除提示
     */
    function delConfirm() {

        $('#delModel').modal();
    }

    /**
     * 删除文件
     */
    function delFile() {
        var values = [];
        $("input[name='List_Selected']:checked").each(function () {
            values.push($(this).val())
        });

        if (values.length === 0){
            alert("请选择文件后再删除");
            return;
        }

        var globalRelativePath = $("#globalRelativePath").val();
        var url = "${contextPath}/ftp/delFiles";
        var params = {paths: values, globalRelativePath: globalRelativePath, level: level};
        ajax(url, params, true, "删除成功");

    }

    /**
     * 上传文件
     */
    function uploadFiles() {
        var url = "${contextPath}/ftp/upload";
        var globalRelativePath = $("#globalRelativePath").val();
        var formData = new FormData(document.getElementById("uploadForm"));
        formData.append("globalRelativePath", globalRelativePath);
        formData.append("level", level);
        var files = $("#file").prop('files');
        if (files !== null && files.length > 0  ){
            var x;
            for (x in files){
                formData.append('files',  files[x]);
            }
        } else {
            alert("请先选择文件");
            return;
        }
        var progressBar = $("#progressBar");
        var progressBarParent = $("#progressBarParent");
        var uploadBtn = $("#uploadBtn");
        uploadBtn.attr("disabled", true);
        progressBar.width("0%");
        progressBarParent.css("display","");
        progressBarParent.addClass("active");
        var xhr = new XMLHttpRequest();
        xhr.open("post",url, true);
        xhr.onload = function () {
            uploadBtn.attr("disabled", false);
            uploadBtn.html("提交");
            progressBarParent.removeClass("active");
            progressBarParent.css("display","none");
            progressBar.width("0%");
            setTimeout(function () {
                toastr.success("上传成功");
            }, 500);
        };
        xhr.upload.addEventListener("progress", progressFunction, false);
        xhr.send(formData);

        /*$.ajax({
            url: url,
            type: 'POST',
            data: formData,                    // 上传formdata封装的数据
            dataType: 'HTML',
            cache: false,                      // 不缓存
            processData: false,                // jQuery不要去处理发送的数据
            contentType: false,                // jQuery不要去设置Content-Type请求头
            success: function (msg) {           //成功回调
                $("#show_file").html(msg);
                toastr.success("上传成功");
            }
        });*/

    }

    // 文件修改时(还不知道作用)
    $("#file").change(function() {
        $("#uploadBtn").val("提交");
        $("#progressBar").width("0%");
        var file = $(this).prop('file');
        if (file.length !== 0) {
            $("#uploadBtn").attr('disabled', false);
        }
    });

    function progressFunction(evt) {
        var progressBar = $("#progressBar");
        if (evt.lengthComputable){
            var completePercent = Math.round(evt.loaded / evt.total * 100  )+ "%";
            progressBar.width(completePercent);
            $("#uploadBtn").html("正在上传：" + completePercent);
        }
    }

    /**
     * url:路径
     * params:参数
     * isTip: 是否提示
     * tip:  提示语
     */
    function ajax(url, params, isTip, tip) {

        console.log("url:" + url);
        $.ajax({
            type: 'POST',
            url: url,
            dataType: 'html',
            data: params,
            success: function (msg) {

                $("#show_file").html(msg);
                if(isTip){
                    toastr.success(tip);
                }
                if (level === 0){
                    $("#operationBtn").hide();
                } else {
                    $("#operationBtn").show();
                }

            },
            timeout: 20000,
            error: function (MLHttpRequest, textStatus, errorThrown) {
                if (textStatus === 'error') {
                    $('#rank').html("<div style='text-align: center;font-size: 20px;color: red' >返回错误，请刷新重试</div>");
                }
                if (textStatus === 'timeout') {
                    $('#rank').html("<div style='text-align: center;font-size: 20px;color: red' >请求超时</div>");
                }
            }
        });
    }


    /**
     * 阻止冒泡
     */
    function stopPropergation(){
        var e = window.event||arguments[0];
        if(!e){
            return;
        }
        if (window.event) {
            e.cancelBubble=true;//IE阻止冒泡方法
        } else {
            e.stopPropagation();//W3C阻止冒泡方法
        }
    }

</script>
